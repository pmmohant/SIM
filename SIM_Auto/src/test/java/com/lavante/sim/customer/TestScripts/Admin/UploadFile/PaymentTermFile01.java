package com.lavante.sim.customer.TestScripts.Admin.UploadFile;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created for Payment Term
 * @author Piramanayagam.S
 *
 */
public class PaymentTermFile01 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	String dir="src"+File.separator+"test"+File.separator+"resources"+File.separator+"data";
	String customerid="";
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		List listofdatafrm=lavanteUtils.login("VMF", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=""+listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		//One of the test in this class navigate to supplier search page.
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab","UploadFiles");
		enobjhomePage.selectTab(LdataMap);
		
	
	}
	

	/** 
	 * Upload Payment Term File
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void UploadPaymentTermFile() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for for Payment Term File at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("PaymentTerm_Template.csv");
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expPaymentTerm="AutoPayT"+LavanteUtils.randomnum();
	
	String paymentCenter="select Top 1 ut.UTFString from PaymentCenter pc, UserTranslation ut where pc.PaymentCenter_i18nKey=ut.i18nKey and pc.CustomerID="+customerid;
	paymentCenter=lavanteUtils.fetchDBdata(paymentCenter);

	String paymentType="Check";
	
	LavanteUtils.editcsv(nwfile, 0, paymentCenter);
	LavanteUtils.editcsv(nwfile, 1, paymentType);
	LavanteUtils.editcsv(nwfile, 2, expPaymentTerm);

	
	String existingPCName="select Top 1 ut.UTFString from PaymentTerms pt,PaymentCenter pc, UserTranslation ut where pt.PaymentCenterID>0 "
			+ "  and pt.PaymentCenterID = pc.PaymentCenterID  and pc.PaymentCenter_i18nKey=ut.i18nKey and pc.CustomerID="+customerid;
	existingPCName=lavanteUtils.fetchDBdata(existingPCName);
	
	String existingPtype="select Top 1pty.PaymentType from PaymentTerms pt,PaymentCenter pc,PaymentType pty, "
			+ "  UserTranslation ut where pt.PaymentCenterID>0  and pt.PaymentCenterID = pc.PaymentCenterID"
			+ "  and pc.PaymentCenter_i18nKey=ut.i18nKey  and pty.PaymentTypeID = pt.PaymentTypeID"
			+ "  and ut.UTFString='"+existingPCName+"' and pc.CustomerID="+customerid;
	existingPtype=lavanteUtils.fetchDBdata(existingPtype);
	
	String existingptr=" select top 1 utr.UTFString from PaymentTerms ptr, UserTranslation utr where "
			+ "  PaymentTypeID in (select pt.PaymentTypeID from PaymentType pt, UserTranslation ut where pt.PaymentType_i18nKey=ut.i18nKey  and"
			+ "  ut.LanguageID=50 and ut.UTFString='"+existingPtype+"' )"
			+ "  and PaymentCenterID in (select pc.PaymentCenterID from PaymentCenter pc, UserTranslation ut where pc.PaymentCenter_i18nKey=ut.i18nKey  and"
			+ "  ut.LanguageID=50 and ut.UTFString='"+existingPCName+"')"
			+ " and ptr.PaymentName_i18nKey=utr.i18nKey and utr.LanguageID=50 and ptr.CustomerID="+customerid;
	existingptr=lavanteUtils.fetchDBdata(existingptr);
	
	//1st Row is Unique to be inserted into Application
	LavanteUtils.editMultiRowcsv(nwfile,2,0,existingPCName );
	LavanteUtils.editMultiRowcsv(nwfile,2,1,existingPtype );
	LavanteUtils.editMultiRowcsv(nwfile,2,2,existingptr );
	
	LavanteUtils.editMultiRowcsv(nwfile,3,0,"" );
	LavanteUtils.editMultiRowcsv(nwfile,3,1,existingPtype );
	LavanteUtils.editMultiRowcsv(nwfile,3,2,"" );
	
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Payment Term File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File not available in the list");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean fstatus=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(fstatus,"Current File not available in the list");
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEpaymentTermFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

			if(fname.equalsIgnoreCase(nwfile)){	
				Reporter.log("Uploaded file available in the list");
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File Status not matched");
				
				status=enobjuploadFiles.PaymentTermUploadListunqrecord().get(i).getText();
				expsttaus="1";
				Reporter.log("Uploaded file Unique Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Unique Count not matched");
				
				status=enobjuploadFiles.PaymentTermUploadListduprecord().get(i).getText();
				expsttaus="1";
				Reporter.log("Uploaded file Duplicate Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Duplicate Count not matched");

				status=enobjuploadFiles.PaymentTermUploadListErrrecord().get(i).getText();
				expsttaus="1";
				Reporter.log("Uploaded file Error Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Error Count not matched");
				
				status=enobjuploadFiles.PaymentTermUploadListTotalrecord().get(i).getText();
				expsttaus="3";
				Reporter.log("Uploaded file Total Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Total Count not matched");
				
				flag=true;
				break;
			}
	}
	
	Assert.assertTrue(flag,"File not available in the list");
	
	dataMap.put("maintab", "Admin");
	dataMap.put("subtab", "PaymentTerms");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(objPaymentTermPage.PaymentTermsTab());
	lavanteUtils.click(objPaymentTermPage.PaymentTermsTab());
	lavanteUtils.fluentwait(objPaymentTermPage.AddPaymentTerms());
	
	for (int i = 0; i <objPaymentTermPage.ListPaymentTerms.size() ; i++) {
		String actualPaymentTerm = objPaymentTermPage.ListPaymentTerms.get(i).getText();
		System.out.println("Actual paymet Term: "+actualPaymentTerm);
		if (actualPaymentTerm.equals(expPaymentTerm)) {
			flag = true;
			Reporter.log("Payment Term created,Actual:" + actualPaymentTerm + ",Expected Payment center name:" + expPaymentTerm,true);
			break;
			
			/*String query="delete from PaymentCenter_Division_Map where PaymentCenterID in (select PaymentCenterID from PaymentCenter where PaymentCenterName='"+actualPaymentTerm+"')";
			lavanteUtils.UpdateDB(query);
			
			String ut="select PaymentCenter_i18nKey from PaymentCenter where PaymentCenterName='"+actualPaymentTerm+"'";
			ut=lavanteUtils.fetchDBdata(ut);
			
			query="delete from PaymentCenter where PaymentCenterName='"+actualPaymentTerm+"'";
			lavanteUtils.UpdateDB(query);
			
			 query="delete from UserTranslation where i18nKey='"+ut+"'";
			lavanteUtils.UpdateDB(query);

			query="delete from I18NKey where i18nKey='"+ut+"'";
			lavanteUtils.UpdateDB(query);*/
			
		}
		
	}
	softassert.assertTrue(flag,"Flag is not True,Please Retest");

	
	softassert.assertAll();
	Reporter.log("Test Ended for Payment Term File VMF at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---for Payment Term File -------------");
}

	
	/**
	 * After Class logout and driver quitting
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

