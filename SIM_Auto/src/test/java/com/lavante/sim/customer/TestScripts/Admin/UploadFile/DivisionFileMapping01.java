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
 * @author Piramanayagam.S
 *
 */
public class DivisionFileMapping01 extends PageInitiator {
	
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
	 * Upload Division Mapping File
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void UploadDivisionMappingFile() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for for Divison Mapping File at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("DivisionMapping_Template.csv");
	
	String expNwDivisonMapping="AutoDiv"+LavanteUtils.randomnum();
	LavanteUtils.editcsv(nwfile, 0, expNwDivisonMapping);
	
	String existingName="select Top 1 ut.UTFString from CustomerOrganization co , UserTranslation ut where ut.i18nKey=co.OrganizationName_i18nKey and ut.LanguageID=50";
	existingName=lavanteUtils.fetchDBdata(existingName);
	
	//1st Row is Unique to be inserted into Application
	LavanteUtils.editMultiRowcsv(nwfile,2,0,existingName );
	
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Divison Mapping File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File not available in the list");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean fstatus=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(fstatus,"Current File not available in the list");
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEDivisonMappinguploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

			if(fname.equalsIgnoreCase(nwfile)){	
				Reporter.log("Uploaded file available in the list");
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Update Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File Status not matched");
				
				status=enobjuploadFiles.DivisonMappingUploadListunqrecord().get(i).getText();
				expsttaus="1";
				Reporter.log("Uploaded file Unique Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Unique Count not matched");
				
				status=enobjuploadFiles.DivisionMappingUploadListduprecord().get(i).getText();
				expsttaus="1";
				Reporter.log("Uploaded file Duplicate Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Dup Count not matched");
				
				flag=true;
				break;
			}
	}
	
	Assert.assertTrue(flag,"File not available in the list");
	
	lavanteUtils.switchtoFrame(null);
	
	if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
		Reporter.log("Query Returned with Search data");
		
		enobjhomePage.backtoSearch();
		
		
	}

	
	softassert.assertAll();
	Reporter.log("Test Ended for Divison Mapping File VMF at:"+LavanteUtils.currenttime());
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

