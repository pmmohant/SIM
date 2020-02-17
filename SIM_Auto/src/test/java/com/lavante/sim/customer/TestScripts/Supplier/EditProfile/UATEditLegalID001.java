package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 30-11-2016
 * SIM-8479 Able to Enter Duplicate  Legal ID 
 * @author Piramanayagam.S
 */
public class UATEditLegalID001 extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String suppname="";
	String validLegalID="";
	String invalidLegalid="";
	
	/**
	 * This class all test starts using login page and driver intilization
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
		List listofdatafrm=lavanteUtils.login("LegalIDInviteNwSup",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LdataMap.put("maintab","Supplier");
		LdataMap.put("subtab","customerSupplierLegalID");
		enobjhomePage.selectTab(LdataMap);
		
		LdataMap.put("FilterBY","LegalID");
		enobjLegalID.searchSupplier(LdataMap);
		
		if(enobjLegalID.ListSupplier().size()>0){
			validLegalID=enobjLegalID.ListSupplierLegalID().get(0).getText();
		}
		
		LdataMap.put("FilterBY","LegalID");
		LdataMap.put("FilterSub","PendingValidation");
		enobjLegalID.searchSupplier(LdataMap);
		
		if(enobjLegalID.ListSupplier().size()>0){
			invalidLegalid=enobjLegalID.ListSupplierLegalID().get(0).getText();
		}
		
	}

	/**Valid TAX ID entering in  edit Profile of another newly created supplier and verifying the Error message
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider = "LegalIDInviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void DuplicateValidTINEditProfile(LinkedHashMap<String,String> dataMap) throws Exception{	
		
		Reporter.log("Test Started for Duplicate TIN Edit Profile Search at:"+LavanteUtils.currenttime());
		SoftAssert softAssert=new SoftAssert();
		
		
		if(!(validLegalID.length()>0)){
			Assert.assertFalse(true,"Data Not Found");
		}
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());

		Reporter.log("  Create New Supplier:");
		dataMap.put("TakeControl", "");
		dataMap.put("invite", "");
		//Create is removed hence changing to invtie
		String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
		String supp=s[0];
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);
		
		lavanteUtils.fluentwait(eneditLegal.countryofReg());
		
		dataMap.put("CountryOfReg", "United States");
		dataMap.put("BusinessName", supp);
		dataMap.put("TIN", "YES");
		dataMap.put("TINNum", validLegalID);
		eneditLegal.fillLegal(dataMap);
		
		dataMap.put("Save","");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.fluentwait(eneditProfile.errorMSG());
		String actErrormsg=eneditProfile.errorMSG().getText();
		String expErrormsg="Supplier with the given Employer Identification Number(EIN) already exists.";
		
		System.out.println("Duplicate,TAX ID Error Msg ,Expected:"+expErrormsg+",Actual:"+actErrormsg);
		Reporter.log("Duplicate,TAX ID  Error Msg ,Expected:"+expErrormsg+",Actual:"+actErrormsg);
		softAssert.assertEquals(actErrormsg,expErrormsg,"Duplicate,TAX ID  Error Msg Not Matched,Expected:"+",Actual:"+actErrormsg);
		
		dataMap.clear();
		dataMap.put("EditCancel","");
		eneditProfile.formAction(dataMap);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Duplicate TIN edit Profile Check  :"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended---for Duplicate TIN edit Profile Check --------");
	}

	/**InValid TAX ID entering in  edit Profile of another newly created supplier and
	 * Verify in View Supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider = "LegalIDInviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void DuplicateInvalidTINEditProfile(LinkedHashMap<String,String> dataMap) throws Exception{	
		
		Reporter.log("Test Started for Duplicate TIN Edit Profile Search at:"+LavanteUtils.currenttime());
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		
		if(!(invalidLegalid.length()>0)){
			Assert.assertFalse(true,"Data Not Found");
		}
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());

		Reporter.log("  Create New Supplier:");
		dataMap.put("TakeControl", "");
		dataMap.put("invite", "");
		String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
		String supp=s[0];
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);
		
		lavanteUtils.fluentwait(eneditLegal.countryofReg());
		
		dataMap.put("CountryOfReg", "United States");
		dataMap.put("BusinessName", supp);
		dataMap.put("TIN", "YES");
		dataMap.put("TINNum", invalidLegalid);
		eneditLegal.fillLegal(dataMap);
		
		dataMap.put("SaveExit","");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			Reporter.log("Query Returned with Search data");
			
			enviewSupplier.clickOnSupplier(supp);
			
			dataMap.clear();
			
			dataMap.put("subtab", "LegalIDInfo");
			enviewSupplier.selectTab(dataMap);
			
			validLegalID=enviewSupplier.taxIDNum().getText();
			String[] slegalID=validLegalID.split(" ");
			validLegalID=slegalID[0];
			
			System.out.println("Pending Validation state ,Supplier,TAX ID Entered for Another Supplier,"+supp+" ,Expected:"+invalidLegalid+",Actual:"+validLegalID);
			Reporter.log("Pending Validation state ,Supplier,TAX ID Entered for Another Supplier,"+supp+" ,Expected:"+invalidLegalid+",Actual:"+validLegalID);
			softAssert.assertEquals(validLegalID,invalidLegalid,"Pending Validation state ,Supplier,TAX ID Entered for Another Supplier,"+supp+" ,Expected:"+invalidLegalid+",Actual:"+validLegalID);
			
			enobjhomePage.backtoSearch();
			flag=true;
			
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		
		dataMap.clear();
		dataMap.put("EditCancel","");
		eneditProfile.formAction(dataMap);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Duplicate TIN edit Profile Check  :"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended---for Duplicate TIN edit Profile Check --------");
	}
	
	/**Valid TAX ID entering in  Supplier Registration page  of another newly Invited supplier 
	 * and verifying the Error message and Merging the data and Verify the Newly Created Profile Status
	 * 
	 * 
	 * @author Piramanayagam.S 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	//@Test(dataProvider = "LegalIDInviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void ValidLegalIDAccSetup(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Valid Legal ID:" + LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		if(!(validLegalID.length()>0)){
			Assert.assertFalse(true,"Data Not Found");
		}
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());

		dataMap.put("invite", "");
		dataMap.put("checkconfirm", "");
		dataMap.put("nextbttn", "");
		dataMap.put("confirmChkBox", "");
		dataMap.put("accSetupnextBtn", "");

		
		String[] ns = enobjInvitenewSupplier.inviteNwSupp(dataMap);
	
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		dataMap.put("supplierName", ns[0]);
		dataMap.put("InactiveSup", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			String supStatus=enobjsupplierPage.getColumnText("Status",0);
			String expStatus="Invited";
			System.out.println("New Supplier Profile Status:"+ns[0]+",Before Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			Reporter.log("New Supplier Profile Status:"+ns[0]+",Before Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			softassert.assertEquals(supStatus,expStatus,"New Supplier Profile Status:"+ns[0]+",Before Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			
		}
		
		enobjhomePage.logout();
	
		lavanteUtils.navigatetoAccSetup(ns);
		
		objSimAccountSetupPage.accSetup(dataMap);
		
		dataMap.put("tinNumber", validLegalID);
		objSimAccountRegistrationPage.registrationPage(dataMap);
		
		lavanteUtils.fluentwait(objSimAccountRegistrationPage.dialogContenttxt());
		
		String actmsg=objSimAccountRegistrationPage.dialogContenttxt().getText();
		String expMsg="Based on the Legal ID, you appear to have already registered in the Lavante Connect Network";
//		
		System.out.println("Valid Legal ID,Supplier Reg Page,Info Msg,"+expMsg+",Actual Msg,"+actmsg);
		Reporter.log("Valid Legal ID,Supplier Reg Page,Info Msg,"+expMsg+",Actual Msg,"+actmsg);
		softassert.assertTrue(actmsg.contains(expMsg),	"Actual Msg didnot match for Valid legal id  ");
		
		lavanteUtils.click(objSimAccountRegistrationPage.OKBtn());
		
		lavanteUtils.fluentwait(enobjhomePage.logoutbtn());
		lavanteUtils.fluentwait(objSimAccountRegistrationPage.OKBtn());
		lavanteUtils.click(objSimAccountRegistrationPage.OKBtn());
		
		enobjhomePage.logout("Customer");
		
		//Login
		List listofdatafrm=lavanteUtils.login("LegalIDInviteNwSup",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		dataMap.put("supplierName", ns[0]);
		dataMap.put("InactiveSup", "");
		enobjsupplierBasicSearch.search(dataMap);

		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			String supStatus=enobjsupplierPage.getColumnText("Status",0);
			String expStatus="Inactive";
			System.out.println("New Supplier Profile Status:"+ns[0]+",After Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			Reporter.log("New Supplier Profile Status:"+ns[0]+",After Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			softassert.assertEquals(supStatus,expStatus,"New Supplier Profile Status:"+ns[0]+",After Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			flag=true;
		}
		
		softassert.assertTrue(flag,"Please Retest");
		
		softassert.assertAll();
	}
	
	/**InValid TAX ID entering in  Supplier Registration page  of another newly Invited supplier
	 *and VErify the Profile status
	 *
	 * @author Piramanayagam.S 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	//@Test(dataProvider = "LegalIDInviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void InvalidLegalIDAccSetup(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Invalid Legal ID Suppiler Registeration Page:" + LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		if(!(invalidLegalid.length()>0)){
			Assert.assertFalse(true,"Data Not Found");
		}
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());

		dataMap.put("invite", "");
		dataMap.put("checkconfirm", "");
		dataMap.put("nextbttn", "");
		dataMap.put("confirmChkBox", "");
		dataMap.put("accSetupnextBtn", "");
		
		String[] ns = enobjInvitenewSupplier.inviteNwSupp(dataMap);
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		dataMap.put("supplierName", ns[0]);
		dataMap.put("InactiveSup", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			String supStatus=enobjsupplierPage.getColumnText("Status",0);
			String expStatus="Invited";
			System.out.println("New Supplier Profile Status:"+ns[0]+",Before  Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			Reporter.log("New Supplier Profile Status:"+ns[0]+",Before  Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			softassert.assertEquals(supStatus,expStatus,"New Supplier Profile Status:"+ns[0]+",before Registering,Status:"+supStatus+",Expected status:"+expStatus);
			
		}
		
		
		enobjhomePage.logout();
	
		String url=lavanteUtils.navigatetoAccSetup(ns);
				
		objSimAccountSetupPage.accSetup(dataMap);
		dataMap.put("tinNumber", invalidLegalid);
		objSimAccountRegistrationPage.registrationPage(dataMap);
		
		lavanteUtils.fluentwait(objSimAccountRegistrationPage.dialogContenttxt());
		
		String actmsg=objSimAccountRegistrationPage.dialogContenttxt().getText();
		String exp="Thank you, your account has been successfully created";

		System.out.println(exp+"Act Msg,"+actmsg);
		Reporter.log("Verification of  ");
		softassert.assertTrue(actmsg.contains(exp),	"Actual Msg didnot match for Valid legal id  ");
		
		lavanteUtils.click(objSimAccountRegistrationPage.OKBtn());
		
		enobjhomePage.logout("Customer");
		
		//Login
		List listofdatafrm=lavanteUtils.login("LegalIDInviteNwSup",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		dataMap.put("supplierName", ns[0]);
		dataMap.put("InactiveSup", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			String supStatus=enobjsupplierPage.getColumnText("Status",0);
			String expStatus="Pending Validation";
			System.out.println("New Supplier Profile Status:"+ns[0]+",After  Registering,Status:"+supStatus+",Expected status:"+expStatus);
			Reporter.log("New Supplier Profile Status:"+ns[0]+",After  Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			softassert.assertEquals(supStatus,expStatus,"New Supplier Profile Status:"+ns[0]+",After  Registering ,Status:"+supStatus+",Expected status:"+expStatus);
			flag=true;
		}
		
		softassert.assertTrue(flag,"Please Retest");
		softassert.assertAll();
	}
	
	
	@AfterMethod
	public void aftermethod(){
		enobjInvitenewSupplier.cancel();
		enobjhomePage.backtoSearch();
		enobjhomePage.popupclose();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();	
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
	}
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

