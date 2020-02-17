package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 24-08-2016
 * Created for  UAT
 * Ended on 28-08-2016
 * @author Piramanayagam.S
 *
 */
public class UATContactFilesTC extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
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
		
		List listofdatafrm=lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
	}
	
	@BeforeMethod
	public void before(){

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}

	/** Upload Contact File
	 * Verify Hyper Link
	 * Verify Status
	 * Verify via Advance Search
	 * Verify in Edit Profile
	 * Verify in View Supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test(dataProvider="AddLocation",dataProviderClass=EditProfDataProvider.class)
	public void uploadContactFile001(LinkedHashMap<String, String> dataMap) throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Contact File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Contact_Template.csv");
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("SupplierID", "1");	
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		
		
		
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		String suppname="";
		String supid="";
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		for(int i=0;i<enobjsupplierPage.iterateSearchHeaderFindColList("ERP").size();i++){
			supid=enobjsupplierPage.getColumnText("ERP",0);
			System.out.println(supid);
			if(supid.contains(": ")&&(supid.contains(ERPNAMe))){
				System.out.println(supid);
				suppname=enobjsupplierPage.getColumnText("Name",0);
				String[] dsa=supid.split(": ");
				supid=dsa[1];
				break;
			}
		}
		
		Assert.assertTrue(supid.length()>0, "Supplier ID Not available");
		Assert.assertTrue(suppname.length()>0, "Supplier Name Not available");

		String cname="AConSP"+LavanteUtils.randomnum();
		String cphone=""+LavanteUtils.randomnum();
		String cfax=""+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9)+"-"+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
		String cemail=cname+"@"+cname+".com";
		
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);

		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,cname );
		LavanteUtils.editcsv(nwfile, 5,cphone );
		LavanteUtils.editcsv(nwfile, 6,cfax );
		LavanteUtils.editcsv(nwfile, 7,cemail );

		//	String supp=LavanteUtils.Readcsv(nwfile,1);
		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "ContactFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEContactuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softassert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.ContactUploadListunqrecord().get(i).getText();
				System.out.println("Uploaded file Count,Expected:1,Actuals:"+count);
				Reporter.log("Uploaded file Record Count,Expected:1,Actuals:"+count);
				softassert.assertEquals(count,"1","File Record Count not matched");
				flag=true;
				break;
			
			}
			
		}
		
		Assert.assertTrue(flag,"File Status Not Expected");

		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		dataMap.put("Tab", "CompanyProfile");
		dataMap.put("ContactEmail", "Equals To,"+cemail);		
		ensupplierAdvanced.buildQuery(dataMap);
	
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		String actsuppname=enobjsupplierPage.getColumnText("Name",0);
		System.out.println("Advance Search,Contact Email Search, Match,Actual:"+actsuppname+",Exp:"+cname);
		Reporter.log("Advance Search,Contact Email Search,Actual:"+actsuppname+",Exp :"+cname);
		softassert.assertEquals(actsuppname,cname,"Advance Search,Contact Email Search , Not matched");	
		
		dataMap.put("supplierName", suppname);	
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		dataMap.put("DelPrevious", "");
		dataMap.put("AddAddress", "Add New");
		
		dataMap.put("AddContact",cname);
		
		eneditCompanyProfile.AddLocationContact(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(suppname);

		lavanteUtils.waitForTime(3000);
		
		for(int i=0;i<enviewSupplier.cntactaddressloctn().size();i++){
			String en=enviewSupplier.cntactaddressloctn().get(i).getText();
			System.out.println(en);
			if(en.contains(dataMap.get("LocationType"))){
				
				String actCname=enviewSupplier.cntactaddresscntct().get(i).getText();
				String actEmail=enviewSupplier.cntactEmail().getText();
				System.out.println("Contact Name Match,Actual:"+actCname+",Exp:"+cname);
				Reporter.log("Contact Name Match,Actual:"+actCname+",Exp :"+cname);
				softassert.assertEquals(actCname,cname,"Contact Name Not matched");	
				
				System.out.println("Contact Email Match,Actual:"+actEmail+",Exp:"+cname);
				Reporter.log("Contact Email Match,Actual:"+actEmail+",Exp :"+cname);
				softassert.assertEquals(actEmail,cname,"Contact Email Not matched");	
				
				lavanteUtils.click(enviewSupplier.ContactName());
				lavanteUtils.switchtoFrame(enviewSupplier.IFRAMEContact());
				
				actCname=enviewSupplier.cntactPopupName().getText();
				actEmail=enviewSupplier.cntactPopupEmail().getText();
				String actCphone=enviewSupplier.cntactName().getText();
				String actCFax=enviewSupplier.cntactEmail().getText();
				
				System.out.println("Contact Popup Name Match,Actual:"+actCname+",Exp:"+cname);
				Reporter.log("Contact Popup  Match,Actual:"+actCname+",Exp :"+cname);
				softassert.assertEquals(actCname,cname,"Contact Popup  Name Not matched");	
				
				System.out.println("Contact Popup Email Match,Actual:"+actEmail+",Exp:"+cname);
				Reporter.log("Contact Popup  Email Match,Actual:"+actEmail+",Exp :"+cname);
				softassert.assertEquals(actEmail,cname,"Contact Popup  Email Not matched");	
				
				System.out.println("Contact Popup  Phone Match,Actual:"+actCphone+",Exp:"+cphone);
				Reporter.log("Contact Popup Phone,Actual:"+actCphone+",Exp :"+cphone);
				softassert.assertEquals(actCphone,cphone,"Contact Popup  Phone Not matched");	
				
				System.out.println("Contact Popup  Fax Match,Actual:"+actCFax+",Exp:"+cfax);
				Reporter.log("Contact Popup  Fax Match,Actual:"+actCFax+",Exp :"+cfax);
				softassert.assertEquals(actCFax,cfax,"Contact Popup  Fax Not matched");	
				flag=true;
				break;
			}
		}
		
		
		softassert.assertTrue(flag,"Please Retest");
		softassert.assertAll();
		Reporter.log("Test Ended for Upload Contact File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Contact File-------");
	
	}

	/** Duplicate Contact File
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(status='ivnalid')
	public void DuplicateContactFile002() throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Duplicate Contact File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Contact_Template.csv");
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("SupplierID", "1");	
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		
		String suppname="";
		String supid="";
		for(int i=0;i<enobjsupplierPage.iterateSearchHeaderFindColList("ERP").size();i++){
			supid=enobjsupplierPage.getColumnText("ERP",0);
			if(supid.contains(": ")&&(supid.contains(ERPNAMe))){
				System.out.println(supid);
				suppname=enobjsupplierPage.getColumnText("Name",0);
				String[] dsa=supid.split(": ");
				supid=dsa[1];
				break;
			}
		}
		
		Assert.assertTrue(supid.length()>0, "Supplier ID Not available");
		Assert.assertTrue(suppname.length()>0, "Supplier Name Not available");
				
		String cname="AConSP"+LavanteUtils.randomnum();
		String cphone=""+LavanteUtils.randomnum();
		String cfax=""+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9)+"-"+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
		String cemail=cname+"@"+cname+".com";
		
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);

		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,cname );
		LavanteUtils.editcsv(nwfile, 5,cphone );
		LavanteUtils.editcsv(nwfile, 6,cfax );
		LavanteUtils.editcsv(nwfile, 7,cemail );

		String dupfile=LavanteUtils.CopyFile(nwfile);
		
		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "ContactFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEContactuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softassert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.ContactUploadListunqrecord().get(i).getAttribute("href");
				System.out.println("Uploaded file Count,Expected:1,Actuals:"+count);
				Reporter.log("Uploaded file Record Count,Expected:1,Actuals:"+count);
				softassert.assertEquals(count,"1","File Record Count not matched");
				flag=true;
				break;
			
			}
			
		}
		
		Assert.assertTrue(flag,"File Status Not Expected");

		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("UploadFile", dupfile);
		
		dataMap.put("Status", "Process Completed");
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload Duplicate File Status Not Matched,Please Recheck");
		Reporter.log("Upload duplicate Content File:"+dupfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEContactuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(dupfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softassert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.ContactUploadListduprecord().get(i).getAttribute("href");
				System.out.println("Uploaded file Count,Expected:1,Actuals:"+count);
				Reporter.log("Uploaded file Record Count,Expected:1,Actuals:"+count);
				softassert.assertEquals(count,"1","File Record Count not matched");
				flag=true;
				break;
			
			}
			
		}
		
		
		softassert.assertAll();
		Reporter.log("Test Ended for Upload Duplicate Contact File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Duplicate Contact File-------");
	
	}

	/** Upload Error Contact File by providing invalid Email ID and verify the Count
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void ErorContactFile003() throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Spend File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Contact_Template.csv");

		String suppname=" select MAX(SupplierName) from Supplier where LavanteUID in  (select LavanteUID from Relationship where CustomerID="+customerid+" and RelationshipID in"
				+ " (select RelationshipID from Relationship_ERP_Map where ERPCustomerMapID=1)) "
				+ " and LavanteUID in (select LavanteUID from Supplier_Contact_Map)";
		
		suppname=lavanteUtils.fetchDBdata(suppname);
		
		String supid=" select SupplierERPID from Relationship_ERP_Map where RelationshipID "
				+ "   in (select RelationshipID from Relationship where CustomerID="+customerid+" and LavanteUID"
				+ "     in (select LavanteUID from Supplier where SupplierName='"+suppname+"') ) ";
		supid=lavanteUtils.fetchDBdata(supid);
		
		String cname="select ContactName from Contact where ContactID in (select MAX(ContactID) from Supplier_Contact_Map where "
				+ " LavanteUID in ( select LavanteUID from Supplier where SupplierName='"+suppname+"'))";
		cname=lavanteUtils.fetchDBdata(cname);
				
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);
	
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,cname );
		LavanteUtils.editcsv(nwfile, 7,cname );

		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "ContactFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEContactuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+nwfile+",Actuals:"+fname);
				Reporter.log("Uploaded file,Expected:"+nwfile+",Actuals:"+fname);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"Status not matched");
				
				String count=enobjuploadFiles.ContactUploadListErrrecord().get(i).getText();
				String exp="1";
				System.out.println("Uploaded file Error Count,Expected:"+exp+",Actuals:"+count);
				Reporter.log("Uploaded file Error Count,Expected:"+exp+",Actuals:"+count);
				softassert.assertEquals(count,exp,"Error Count not matched");
				
				lavanteUtils.click(enobjuploadFiles.ContactErrorLog().get(i));
				lavanteUtils.switchtoFrame(enobjuploadFiles.IframeFileProcessLogMsg());
				
				String actermsg=enobjuploadFiles.ContactErrorLogMsg().get(0).getText();
				String expmsg="Invalid Email-id for column Contact Email";
				System.out.println("Uploaded file Error Msg Count,Expected:"+expmsg+",Actuals:"+actermsg);
				Reporter.log("Uploaded file  Error Msg,Expected:"+expmsg+",Actuals:"+actermsg);
				softassert.assertEquals(actermsg,expmsg,"Error Msg not matched");
				
				flag=true;
				break;
			
			}
		}

		Assert.assertTrue(flag,"Data not Matched");
		
		softassert.assertAll();
		Reporter.log("Test Ended for Upload Eror Contact File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Eror Contact File-------");
	
	}
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		lavanteUtils.refreshPage();
		enobjhomePage.backtoSearch();
		enobjhomePage.popupclose();
		
	}
	
	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();		
		quitBrowser();
	}


}

