package com.lavante.sim.customer.TestScripts.Tasks.PendingUpdate;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class PendingUpdateTest  extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
	
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "viewClaimPendingUpdates.lvp?filterWorkflow=16");
		enobjhomePage.selectTab(LdataMap);
		
		lavanteUtils.fluentwait(objPendingUpdatePage.searchbtn());
		if(!(objPendingUpdatePage.iterateSearchHeaderFindColList("Claim ID").size()>2)){
		
			LdataMap.put("ClaimId","All");
			LdataMap.put("Action","Reassign");
			LdataMap.put("ALLSupplier","");
			objPendingUpdatePage.actionOnClaimsToUpdate(LdataMap);
			
			LdataMap.put("ReAssign","");
			LdataMap.put("AssginTo","User");
			String x="select ContactName From contact where Email ='"+LdataMap.get("username")+"'";
			x=lavanteUtils.fetchDBdata(x);
			String uname=x+"("+LdataMap.get("username")+")";
			LdataMap.put("User",uname); 
			LdataMap.put("filterby","Claims to Approve");
			enReassign.Reassigns(LdataMap);
		}
	}
	
	/**
	 * Before Method to navigate to the Tasks->Claim tab.
	 * @author girish.n
	 */
	
	@BeforeMethod
	public void beforeMethod(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();	
		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "viewClaimPendingUpdates.lvp?filterWorkflow=16");
		enobjhomePage.selectTab(LdataMap);
		waitforPageload(objTasksClaimPage.pageHeader());

	}
	
	/**
	 * Verify whether the user is able to reassign a claim that has been requested for an update.
	 * @throws Exception
	 * @author girish.n
	 */
	@Test
	public void reassignPendingUpdateClaimTest() throws Exception {
		Reporter.log("<--------------Test Started for reassignPendingUpdateClaimTest: " + currenttime(),true);
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		String expClaimID="Any";
		String action ="Reassign";
		dataMap.put("Action", action);
		dataMap.put("ClaimId", expClaimID);
		String expUser="select Min(Email) from Contact Where Contactname like '%clerk%' and ContactID in "
				+ " (select ContactID from Login where USerRoleID in (Select USerRoleID from Loginrole where UserRoleName like '% Clerk'))";
		expUser=lavanteUtils.fetchDBdata(expUser);
		String Validation="Select UserRoleName from Loginrole where UserRoleID  in ( "
				+ "	(select USerRoleID from Login where  ContactID  in (select ContactID from Contact Where Email='"+expUser+"')) )";
		Validation=lavanteUtils.fetchDBdata(Validation);
		dataMap.put("Action", action);
		dataMap.put("ClaimId", expClaimID);
		dataMap.put("Reassign","");
		objPendingUpdatePage.actionOnClaimsToUpdate(dataMap);
		Reporter.log(expClaimID+", Reassigned to USer:"+expUser);
		
		if(dataMap.containsKey("flag")){
			String x=dataMap.get("flag");
			if(x.equalsIgnoreCase("true")){
				flag=false;
				dataMap.put("AssignTo","User");
				dataMap.put("InvitingOrganization","All");
				dataMap.put("User", expUser);
				objTasksClaimPage.reassignClaim(dataMap);
				
				Reporter.log("<------Index:"+dataMap.get("Index"),true);
				Reporter.log("<--------ClaimID:"+dataMap.get("ClaimId"),true);
	
				expClaimID=dataMap.get("ClaimId");
		
				//Verification of claim reassign in View Claim Details page
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
				
				String actUser="";				
				if(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").size()>0){
					click(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
					waitforPageload(objViewClaimsPage.claimHeaderLabel());
					
					dataMap.put("ActionTaken", "Request Update Pending");
					objViewClaimsPage.viewDetails(dataMap);
					if(dataMap.containsKey("Actor")){
						actUser = dataMap.get("Actor");
					}
					//We are not showing the email id , showing the role
					softAssert.assertTrue(actUser.contains(Validation),"Claim "+expClaimID+" Not Reassinged to the actor " + actUser);
					flag=true;
					Reporter.log("<---------------------Expected Reassigned User:"+actUser+"::Actual Reassigned User:"+expUser,true);
				}
			}else{
				softAssert.assertTrue(flag,"Please Add Test Data,No Claim Available for Pending Update");
				flag=true;
			}


		}
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);

	}

	/**
	 * Verify whether the user is able to reassign a claim that has been requested for an update.
	 * @throws Exception
	 * @author girish.n
	 */
	@Test
	public void editPendingUpdateClaimTest() throws Exception {
		Reporter.log("<---------------------Test Started for editPendingUpdateClaimTest: " + currenttime(),true);
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		String expClaimID="Any";
		String action ="EditClaim";
		dataMap.put("Action", action);
		dataMap.put("ClaimId", expClaimID);
		dataMap.put("View", "My Tasks");
		objPendingUpdatePage.actionOnClaimsToUpdate(dataMap);
		
		if(dataMap.containsKey("flag")){
			
			String x=dataMap.get("flag");
			if(x.equalsIgnoreCase("true")){
				flag=false;
				
				dataMap.put("SubmitClaim","");
				objCreateClaimPage.createClaim(dataMap);
				waitforPageload(objPendingUpdatePage.pageHeader());
				
				Reporter.log("<------Index:"+dataMap.get("Index"),true);
				Reporter.log("<--------ClaimID:"+dataMap.get("ClaimId"),true);
	
				expClaimID=dataMap.get("ClaimId");
		
				//Verification of claim reassign in View Claim Details page
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("ClaimId",expClaimID);
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
				
				String expUser="";
				String actUser="";				
				if(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").size()>0){
					click(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
					waitforPageload(objViewClaimsPage.claimHeaderLabel());
					
					//To get the current user to whom the claim is assigned
					dataMap.put("ActionTaken", "Approval Pending");
					objViewClaimsPage.viewDetails(dataMap);
					if(dataMap.containsKey("Actor")){
						actUser = dataMap.get("Actor");
						dataMap.remove("Actor");
					}
					
					//To get the user that requested for an update
					dataMap.put("ActionTaken", "Request update");
					objViewClaimsPage.viewDetails(dataMap);
					if(dataMap.containsKey("Actor")){
						expUser = dataMap.get("Actor");
					}
					
					softAssert.assertEquals(actUser, expUser,"Claim "+expClaimID+" Not Reassinged to the actor " + expUser);
					flag=true;
					Reporter.log("<---------------------Claim Assigned to Expected User:"+actUser+"::Claim Assigned to Actual User:"+expUser,true);
				}
			}else{
				softAssert.assertTrue(flag,"Please Add Test Data, No Claim Available for Pending Update on MY Task");
				flag=true;
			}


		}
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);

	}
	
	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}


}
