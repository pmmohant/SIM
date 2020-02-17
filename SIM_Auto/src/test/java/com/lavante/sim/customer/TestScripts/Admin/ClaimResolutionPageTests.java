package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

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

public class ClaimResolutionPageTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
	String ClaimReason="";
	
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		
	}	
	
	/**
	 * Before Method to navigate to the Admin->Claim Resolution tab.
	 * @author girish.n
	 */
	
	@BeforeMethod
	public void beforeMethod(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "manageClaimResolution");
		enobjhomePage.selectTab(LdataMap);
		waitforPageload(objClaimResolutionPage.pageHeader());
		
		ClaimReason="";
	}
	
	/**
	 * Verify whether the user is able to add a new claim resolution reason and edit the same.
	 * @author girish.n
	 * @throws Exception
	 */
	@Test
	public void addEditClaimResolutionTest() throws Exception {
		Reporter.log("<---------------------Test Started for addEditClaimResolutionTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String expClmResRsn="AddClmResRsn"+ currenttime();
		dataMap.put("ClaimResReason", expClmResRsn);
		dataMap.put("AddOrEdit", "Add");
		dataMap.put("Save","");
		waitForTime(2000);
		objClaimResolutionPage.addClaimResolution(dataMap);
		dataMap.remove("AddOrEdit");
		
		//For Deleting from DB
		ClaimReason=expClmResRsn;
		
		
		//Verification of the claim resolution Addition.
		dataMap.put("SearchText", expClmResRsn);
		objClaimResolutionPage.searchClaimResReason(dataMap);
		String actClmResRsn="";
		
		if(objClaimResolutionPage.claimResReasonList().size()>0){
			
			actClmResRsn=objClaimResolutionPage.claimResReasonList().get(0).getText().trim(); 	
			softAssert.assertEquals(actClmResRsn, expClmResRsn);
			Reporter.log("Expected Claim Resolution Reason:"+expClmResRsn+"::"+"Actual Claim Resolution Reason:"+actClmResRsn,true);
			
			//Edit Claim Resolution Reason
			expClmResRsn="EditClmResRsn"+ currenttime();
			dataMap.put("ClaimResReason", expClmResRsn);
			dataMap.put("AddOrEdit", "Edit");
		
			click(objClaimResolutionPage.editLinks().get(0));
			objClaimResolutionPage.addClaimResolution(dataMap);
			
			//Verification of Claim Resolution Reason Edition
			dataMap.put("SearchText", expClmResRsn);
			objClaimResolutionPage.searchClaimResReason(dataMap);
			
			//For Deleting from DB
			ClaimReason=expClmResRsn;
			
			actClmResRsn=objClaimResolutionPage.claimResReasonList().get(0).getText().trim();
			
			softAssert.assertEquals(actClmResRsn, expClmResRsn);
			Reporter.log("Expected Claim Resolution Reason:"+expClmResRsn+"::"+"Actual Claim Resolution Reason:"+actClmResRsn,true);
		
		}else {
			softAssert.assertTrue(false,"<---------------------Search Result is empty. Claim Resolution is not added.");
		}
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
		
	}
		
	/**
	 * Verify whether the user is able to add a new claim resolution reason and delete the same.
	 * @author girish.n
	 * @throws Exception
	 */
	@Test
	public void addDeleteClaimResolutionTest() throws Exception {
		Reporter.log("<---------------------Test Started for addDeleteClaimResolutionTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String expClmResRsn="AddClmResRsn"+ currenttime();
		dataMap.put("ClaimResReason", expClmResRsn);
		dataMap.put("AddOrEdit", "Add");
		dataMap.put("Save","");
		objClaimResolutionPage.addClaimResolution(dataMap);
		dataMap.remove("AddOrEdit");
		
		//For Deleting from DB
		ClaimReason=expClmResRsn;
		
		//Verification of the claim resolution Addition.
		dataMap.put("SearchText", expClmResRsn);
		objClaimResolutionPage.searchClaimResReason(dataMap);
		
		String actClmResRsn="";
		
		if(objClaimResolutionPage.claimResReasonList().size()>0){
			
			actClmResRsn=objClaimResolutionPage.claimResReasonList().get(0).getText().trim(); 	
			softAssert.assertEquals(actClmResRsn, expClmResRsn);
			Reporter.log("Expected Claim Resolution Reason:"+expClmResRsn+"::"+"Actual Claim Resolution Reason:"+actClmResRsn,true);
		
			//Delete Claim Resolution Reason
			
			click(objClaimResolutionPage.deleteLinks().get(0));
			waitForTime(3000);
			fluentwait(objClaimResolutionPage.deleteBtn());
			click(objClaimResolutionPage.deleteBtn());
			waitForTime(3000);
			waitforPageload(objClaimResolutionPage.pageHeader());
			
			//Verification of Claim Resolution Reason Deletion
			dataMap.put("SearchText", expClmResRsn);
			objClaimResolutionPage.searchClaimResReason(dataMap);
					
			softAssert.assertEquals(actClmResRsn, expClmResRsn);
			if(objClaimResolutionPage.claimResReasonList().size()==0){
				Reporter.log(expClmResRsn + " Deleted Successfully",true);	
				softAssert.assertTrue(true, " Delete Not Success");
				//For Deleting from DB
				ClaimReason="";
				
			}
			else{
				Reporter.log(expClmResRsn + " Delete Failed",true);	
				softAssert.assertTrue(false);
			}
			
		}else {
			softAssert.assertTrue(false,"<---------------------Search Result is empty. Claim Resolution is not added.");
		}

		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	
	}
		
	/**
	 * Verify whether the user is able to add duplicate claim resolution.
	 * @author girish.n
	 * @throws Exception
	 */
	@Test
	public void duplicateClaimResolutionTest() throws Exception {
		Reporter.log("<---------------------Test Started for duplicateClaimResolutionTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String expClmResRsn="AddClmResRsn"+ currenttime();
		dataMap.put("ClaimResReason", expClmResRsn);
		dataMap.put("AddOrEdit", "Add");
		dataMap.put("Save","");
		//For Deleting from DB
		ClaimReason=expClmResRsn;
		//Add New Claim Resolution Reason
		objClaimResolutionPage.addClaimResolution(dataMap);
		dataMap.remove("AddOrEdit");
		
		//Verification of the claim resolution Addition.
		
		String expErrMsg = "";
		String actErrMsg = "";
		boolean flag=false;

		dataMap.put("SearchText", expClmResRsn);
		objClaimResolutionPage.searchClaimResReason(dataMap);
		
		String actClmResRsn="";
		
		if(objClaimResolutionPage.claimResReasonList().size()>0){
			
			actClmResRsn=objClaimResolutionPage.claimResReasonList().get(0).getText().trim(); 	
			softAssert.assertEquals(actClmResRsn, expClmResRsn);
			Reporter.log("Expected Claim Resolution Reason:"+expClmResRsn+"::"+"Actual Claim Resolution Reason:"+actClmResRsn,true);
		
			//Add duplicate Claim Resolution Reason
			dataMap.put("AddOrEdit", "Add");
			objClaimResolutionPage.addClaimResolution(dataMap);
			dataMap.remove("AddOrEdit");
		
			//Verification of Error Message
			expErrMsg =expClmResRsn + " already exists. Please enter a unique value";
			actErrMsg = "";
			
			if(objClaimResolutionPage.bannerMsg().isDisplayed()){
				Reporter.log("<---------------------Error Message Displayed",true);
				flag=true;
				actErrMsg = objClaimResolutionPage.bannerMsg().getText().trim();
				softAssert.assertEquals(actErrMsg, expErrMsg);
				Reporter.log("Expected Error Message:"+expErrMsg+"::Actual Error Message:"+actErrMsg,true);
			}
			
		}else {
			softAssert.assertTrue(false,"<---------------------Search Result is empty. Claim Resolution is not added.");
		}
					
		softAssert.assertTrue(flag,"<---------------------Error Message Not Displayed");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
		
	}
	
	/**
	 * Delete claim resolution that are associated with some claim
	 * @author girish.n
	 */
	@Test
	public void deleteAssociatedClaimResolutionTest() throws Exception {
		Reporter.log("<---------------------Test Started for deleteAssociatedClaimResolutionTest: " + currenttime(),true);
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		SoftAssert softAssert = new SoftAssert();
		
		//To Select claim resolution reason which is associated to a claim
		String query="select ClaimResolutionReasonName from ClaimResolutionReason where ClaimResolutionReasonID in "
				+ " (select top 1 ClaimResolutionReasonID from Claim_Resolution_Reason_Map) and CustomerID="+customerID;
		String claimResolution=lavanteUtils.fetchDBdata(query);
		Reporter.log("<---------------------Claim Resolution Reason: "+claimResolution,true);
		
		dataMap.put("SearchText", claimResolution);
		objClaimResolutionPage.searchClaimResReason(dataMap);
		
		String expErrMsg = "";
		String actErrMsg = "";
		boolean flag = false;
		
		if(objClaimResolutionPage.claimResReasonList().size()>0){
			
			//Delete Claim Resolution Reason
			fluentwait(objClaimResolutionPage.deleteLinks().get(0));
			click(objClaimResolutionPage.deleteLinks().get(0));
			//waitForTime(3000);
			fluentwait(objClaimResolutionPage.deleteBtn());
			click(objClaimResolutionPage.deleteBtn());
			waitForTime(3000);
			waitforPageload(objClaimResolutionPage.pageHeader());
			
			//Verification of Claim Resolution Reason associated to claim deletion
			expErrMsg="Can not delete,it is being used or associated with some other claims";
			actErrMsg = "";
			
			if(objClaimResolutionPage.bannerMsg().isDisplayed()){
				Reporter.log("<---------------------Error Message Displayed",true);
				flag=true;
				actErrMsg = objClaimResolutionPage.bannerMsg().getText().trim();
				softAssert.assertEquals(actErrMsg, expErrMsg);
				Reporter.log("Expected Error Message:"+expErrMsg+"::Actual Error Message:"+actErrMsg,true);
			}
		}else {
			softAssert.assertTrue(false,"<---------------------Search Result is empty.");
		}
	
		softAssert.assertTrue(flag,"<---------------------Error Message Not Displayed");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	
	}
		
	/**
	 * Test to verify whether the claim resolution reason added is appearing in the Claim Resolution Reason pop up in Task-> Claims->Edit Claims page. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */	
	@Test
	public void validateClaimResReasonTest() throws Exception {
		Reporter.log("<---------------------Test Started for validateClaimResReasonTest: " + currenttime(),true);
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		SoftAssert softAssert = new SoftAssert();
	
		String expClmResRsn="AddClmResRsn"+ currenttime();
		dataMap.put("ClaimResReason", expClmResRsn);
		dataMap.put("AddOrEdit", "Add");
		dataMap.put("Save","");
		waitForTime(2000);
		objClaimResolutionPage.addClaimResolution(dataMap);
		dataMap.remove("AddOrEdit");
		
		//For Deleting from DB
		ClaimReason=expClmResRsn;
		//Verification of the claim resolution Addition.
		dataMap.put("SearchText", expClmResRsn);
		objClaimResolutionPage.searchClaimResReason(dataMap);
		String actClmResRsn="";
		
		if(objClaimResolutionPage.claimResReasonList().size()>0){
			
			actClmResRsn=objClaimResolutionPage.claimResReasonList().get(0).getText().trim(); 	
			softAssert.assertEquals(actClmResRsn, expClmResRsn,"Claim Res Reason not matched");
			Reporter.log("Expected Claim Resolution Reason:"+expClmResRsn+"::"+"Actual Claim Resolution Reason:"+actClmResRsn,true);
			
			if(actClmResRsn.equals(expClmResRsn)){
				
				waitforPageload(enobjhomePage.pageHeader());
				dataMap.put("maintab", "Tasks");
				dataMap.put("subtab", "claimTasks");
				enobjhomePage.selectTab(dataMap);
				
				waitforPageload(objTasksClaimPage.pageHeader());
				String expClaimID="Any";
				String action ="EditClaim";
				dataMap.put("Action", action);
				dataMap.put("ClaimId", expClaimID);
				dataMap.put("TaskView", "My Task");
				objTasksClaimPage.actionOnTasksClaims(dataMap);	
				
				dataMap.put("Repay", "");
				dataMap.put("ClaimResolReason",expClmResRsn);
				objCreateClaimPage.createClaimFillDetails(dataMap);
				
				String x=objCreateClaimPage.ClaimResolReasonSelect().getText();
				
				softAssert.assertEquals(x, expClmResRsn,expClmResRsn+" is not present in the Edit Claim Claim Resolution Popup");
				Reporter.log("Claim Resolution Reason:"+expClmResRsn+" is not present in the Edit Claim Claim Resolution Popup",true);
				
				dataMap.remove("subtab");
				dataMap.put("maintab", "Home");
				enobjhomePage.selectTab(dataMap);
			}
		}else {
			softAssert.assertTrue(false,"<---------------------Search Result is empty. Claim Resolution is not added.");
		}
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	
	}	
	
	  @AfterMethod
	  public void afterMethod() throws FileNotFoundException, IOException, SQLException{
		  	lavanteUtils.switchtoFrame(null);
			lavanteUtils.refreshPage();
		  if(ClaimReason.length()>0){
			  String x="select ClaimResolutionReasonName_i18nKey from ClaimResolutionReason where ClaimResolutionReasonName='"+ClaimReason+"' " ;
			  x= lavanteUtils.fetchDBdata(x);
			  
			   String xx="delete From ClaimResolutionReason where ClaimResolutionReasonName='"+ClaimReason+"'";
			   lavanteUtils.UpdateDB(xx);	   
			   
			   xx="delete from UserTranslation where i18nKey='"+x+"'";
			   lavanteUtils.UpdateDB(xx);
			   
			   xx="delete From I18NKey where i18nKey='"+x+"'";
			   lavanteUtils.UpdateDB(xx);
			 
		  }
	  }
	  
	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
	
}
