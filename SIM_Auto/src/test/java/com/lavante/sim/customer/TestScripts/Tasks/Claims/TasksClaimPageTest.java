package com.lavante.sim.customer.TestScripts.Tasks.Claims;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class TasksClaimPageTest  extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
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
		customerID=(String) listofdatafrm.get(1);
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(LdataMap);
		
		lavanteUtils.fluentwait(objTasksClaimPage.basicsearchbtn());
		if(!(objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID").size()>4)){
		
			LdataMap.put("subtab", "viewApprovalTasks");
			enobjhomePage.selectTab(LdataMap);
			
			LdataMap.put("filterby","Claims to approve");
			LdataMap.put("ALLSupplier","");
			LdataMap.put("ReAssign","");
			LdataMap.put("AssginTo","User");
			String x="select ContactName From contact where Email ='"+LdataMap.get("username")+"'";
			x=lavanteUtils.fetchDBdata(x);
			String uname=x+"("+LdataMap.get("username")+")";
			LdataMap.put("User",uname); 
			LdataMap.put("filterby","Claims to Approve");
			enReassign.selectSupplierFormAction(LdataMap);
			
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
		LdataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(LdataMap);
	}
	
	/**
	 * Test Script to Reassign Claim to another role.
	 * @throws Exception
	 * @author girish.n
	 */
	@Test
	public void reassignClaimToAnotherRoleTest() throws Exception {
		Reporter.log("<---------------------Test Started for reassignClaimToAnotherRoleTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String expClaimID="Any";
		String action ="Reassign";
		String expRole="select UserRoleName from LoginRole where Description Like '% PRGX Clerk'";
		expRole=lavanteUtils.fetchDBdata(expRole);
		//String expRole="Kroger PRGX Clerk";
		boolean flag=false;
		
		dataMap.put("Action", action);
		dataMap.put("ClaimId", expClaimID);
		dataMap.put("Role", expRole);
		dataMap.put("Reassign","");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		
		if(dataMap.containsKey("flag")){
		
			String x=dataMap.get("flag");
			if(x.equalsIgnoreCase("true")){
				flag=false;
				dataMap.put("AssignTo","Role");
				dataMap.put("InvitingOrganization","All");
				objTasksClaimPage.reassignClaim(dataMap);
				
				switchtoFrame(null);
				lavanteUtils.waitForTime(4000);
			
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
		
				String actRole="";
				if(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").size()>0){
						click(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
						waitforPageload(objViewClaimsPage.claimHeaderLabel());
						dataMap.put("ActionTaken", "Approval Pending");
						objViewClaimsPage.viewDetails(dataMap);
						if(dataMap.containsKey("Actor")){
							actRole = dataMap.get("Actor");
						}			
						softAssert.assertEquals(actRole, expRole,"Claim "+expClaimID+" Not Reassinged to the actor " + expRole);
						flag=true;
						Reporter.log("<---------------------Expected Reassigned User Role:"+actRole+"::Actual Reassigned User Role:"+expRole,true);
				}
			}else{
				softAssert.assertTrue(flag,"Please Add Test Data,No Claim Available for Reassign");
				flag=true;
			}
		}	
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}

	/**
	 * Test Script to Reassign Claim to another user.
	 * @throws Exception
	 * @author girish.n
	 */
	@Test
	public void reassignClaimToAnotherUserTest() throws Exception {
		Reporter.log("<-------Test Started for reassignClaimToAnotherUserTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String expClaimID="Any";
		String action ="Reassign";
		String expUser="select Min(Email) from Contact Where Contactname like '%PRGX%' and ContactID in "
				+ " (select ContactID from Login where USerRoleID in (Select USerRoleID from Loginrole where UserRoleName like '% PRGX%'))";
		expUser=lavanteUtils.fetchDBdata(expUser);
		
		//String expUser="prgx@kroger.com";
		boolean flag=false;
		
		dataMap.put("Action", action);
		dataMap.put("ClaimId", expClaimID);
		dataMap.put("User", expUser);
		dataMap.put("Reassign","");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		
		if(dataMap.containsKey("flag")){
			
			String x=dataMap.get("flag");
			if(x.equalsIgnoreCase("true")){
				flag=false;
				dataMap.put("AssignTo","User");
				objTasksClaimPage.reassignClaim(dataMap);
				
				switchtoFrame(null);
				lavanteUtils.waitForTime(4000);
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
				
				String actUser="";				
				if(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").size()>0){
					click(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
					waitforPageload(objViewClaimsPage.claimHeaderLabel());
					dataMap.put("ActionTaken", "Approval Pending");
					objViewClaimsPage.viewDetails(dataMap);
					if(dataMap.containsKey("Actor")){
						actUser = dataMap.get("Actor");
					}			
					expUser="Select ContactName From contact where Email='"+expUser+"';";
					expUser=lavanteUtils.fetchDBdata(expUser);
					softAssert.assertEquals(actUser.contains(expUser),"Claim "+expClaimID+" Not Reassinged to the actor " + expUser);
					flag=true;
					Reporter.log("<---------------------Expected Reassigned User:"+actUser+"::Actual Reassigned User:"+expUser,true);
				}
			}else{
				softAssert.assertTrue(flag,"Please Add Test Data,No Claim Available for Reassign");
				flag=true;
			}
		}	
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}
	
	/** Test Script to Request Update a Claim.
	 * @throws Exception
	 * @author girish.n
 	 * Need to add MailVerification */
	@Test
	public void requestUpdateTest() throws Exception {
		Reporter.log("--Test Started for requestUpdateTest: " + currenttime(),true);
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		String expClaimID="Any";
		String action ="RequestUpdate";
		String expRecipient="select Min(Email) from Contact Where Contactname like '%PRGX%' and ContactID in "
				+ " (select ContactID from Login where USerRoleID in (Select USerRoleID from Loginrole where UserRoleName like '% PRGX%'))";
		expRecipient=lavanteUtils.fetchDBdata(expRecipient);
		String expSubject="Subject:"+currenttime();
		String expMessage="Message"+currenttime();
		dataMap.put("Action", action);
		dataMap.put("ClaimId", expClaimID);
		dataMap.put("TaskView","My Task");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		
		if(dataMap.containsKey("flag")){
			
			String x=dataMap.get("flag");
			if(x.equalsIgnoreCase("true")){
				flag=false;
				dataMap.put("Recipient", expRecipient);
				dataMap.put("Subject", expSubject);
				dataMap.put("Message", expMessage);
				dataMap.put("ReqUpdate","");
				dataMap.put("InvitingOrganization","All");
				objTasksClaimPage.requestUpdateClaim(dataMap);
				
				Reporter.log("<----Index:"+dataMap.get("Index"),true);
				Reporter.log("<----ClaimID:"+dataMap.get("ClaimId"),true);
				
				//Verification of claim reassign in View Claim Details page
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				expClaimID=dataMap.get("ClaimId");
				dataMap.put("ClaimId",expClaimID);
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
				
				String actRecipient="";				
				if(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").size()>0){
					click(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
					waitforPageload(objViewClaimsPage.claimHeaderLabel());
					dataMap.put("ActionTaken", "Request update");	
					objViewClaimsPage.viewDetails(dataMap);
					if(dataMap.containsKey("Actor")){
						actRecipient = dataMap.get("Actor");
					}			
					softAssert.assertEquals(actRecipient, expRecipient,"Claim "+expClaimID+" Not Request Updated to the actor " + expRecipient+",Actual:"+actRecipient);
					flag=true;
					Reporter.log("<---------------------Expected Recipent:"+expRecipient+"::Actual Recipient:"+actRecipient,true);
				}
			}else{
				softAssert.assertTrue(flag,"Please Add Test Data,No Claim Available for Request Update");
				flag=true;
			}
		}	
			
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}

	/**
	 * @author vidya.c
	 * 
	 *        ProcessClaimTest
	 *        
	 *        Doing Tasks >> Edit, fill all the mandatory fields, 
	 *        GL code details and Save the claim. Then Select the claim and do process claim
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException 
	 */
	@Test
	public void ProcessClaimTest() throws FileNotFoundException, IOException, InterruptedException {
		Reporter.log("Test Started for Process claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
			
		dataMap.put("TaskView","My Task");
		dataMap.put("ClaimId","ANY");
		dataMap.put("Action","ProcessClaims");
		dataMap.put("BannerMsg", "");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		
		lavanteUtils.waitForTime(3000);
		String errMsg = "Claims could not be submitted because they do not contain required fields";
		String actProcessMsg = dataMap.get("BannerMsg");
		if(actProcessMsg.contains(errMsg)) {
			lavanteUtils.click(objTasksClaimPage.actionBtn());
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(objTasksClaimPage.editClaimOption());

			dataMap.put("Department", "ANY");
			dataMap.put("ClaimPriority", "No");
			dataMap.put("Repay", "");
			dataMap.put("ClaimResolReason", "any");
			dataMap.put("GLCode", "any");
			dataMap.put("GLCodeAmount","");
			dataMap.put("SaveClaim", "");
			dataMap.put("GLCodeWarning", "No");
			objCreateClaimPage.EditClaim(dataMap);

			dataMap.put("Action","ProcessClaims");
			dataMap.put("BannerMsg", "");
			objTasksClaimPage.actionOnTasksClaims(dataMap);
			lavanteUtils.waitForTime(3000);

		} 

		actProcessMsg = dataMap.get("BannerMsg");
		Reporter.log("Process Claims Message, Expected: 'Claims successfully processed' Actual: "+actProcessMsg);
		softAssert.assertEquals(actProcessMsg, "Claims successfully processed","Claims did not get processed successfully");

		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		boolean flag=enobjhomePage.selectTab(dataMap);

		if(flag){
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
	
			String expStatus = "Pending/Closed";
			String expResol = "Paid";
			String actClaimResol = enobjsupplierPage.iterateSearchHeaderFindColList("Claim Resolution").get(0).getText();
			String actClaimStatus = enobjsupplierPage.iterateSearchHeaderFindColList("Claim Status").get(0).getText();
			Reporter.log("Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus);
			Reporter.log("Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol);
			softAssert.assertTrue(expStatus.contains(actClaimStatus),"Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus);
			softAssert.assertEquals(actClaimResol, expResol,"Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol);
	
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Claim ID").get(0));
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(objViewClaimsPage.claimStatuslink());
			String actStatus = objViewClaimsPage.claimStatuslink().getText();
			Reporter.log("Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);
			softAssert.assertTrue(expStatus.contains(actStatus), "Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);

		}else{
				softAssert.assertTrue(flag,"Edit Claim Task Didnot fill mandatory data");
				flag=true;
		}
		
		softAssert.assertAll();		
		Reporter.log("Test Ended for Process claim:" + currenttime());

	}

	/**
	 * @author Vidya.C
	 * 		Test to enter multiple GL code and verify the data entered
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	@Test
	public void AddMultipleGLCodeTest() throws FileNotFoundException, IOException, InterruptedException, SQLException {
		Reporter.log("Test Started for Add Multiple GLCode: " + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		dataMap.put("TaskView","My Task");
		dataMap.put("Action","EditClaim");
		dataMap.put("ClaimId", "Any");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		Assert.assertEquals(dataMap.get("flag"),"true","Issue while selecting the claims,Please Recheck");
		
		dataMap.put("Department", "ANY");
		dataMap.put("ClaimPriority", "No");
		dataMap.put("Repay", "");
		dataMap.put("ClaimResolReason", "ANY");
		String claimID=dataMap.get("ClaimId");
		String PaymentRef=objCreateClaimPage.ViewPaymentRef().getText().trim();
		String glcode="";
		glcode=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
		
		String glcode2="";
		if(glcode==null){
			
			objCreateClaimPage.UpdateGLCode(claimID,PaymentRef,glcode,customerID);
			glcode=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
			
			objCreateClaimPage.UpdateGLCode(claimID,PaymentRef,glcode,customerID);
			glcode2=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
			
			lavanteUtils.refreshPage();
			
		}else{
			glcode2=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
			
			if(glcode2==null){
				objCreateClaimPage.UpdateGLCode(claimID,PaymentRef,glcode,customerID);
				glcode2=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
				lavanteUtils.refreshPage();
			}
		} 
		
		dataMap.put("GLCode", glcode+"#"+glcode2);
		dataMap.put("GLCodeAmount","any#any");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.EditClaim(dataMap);

		lavanteUtils.waitForTime(5000);
		dataMap.put("View", "Claims and GL codes");
		dataMap.put("Search","");
		objTasksClaimPage.searchTasksClaim(dataMap);

		dataMap.put("GLData", "GLCodeList");
		LinkedHashMap<String, String> glMap = objTasksClaimPage.getGLDatas(dataMap);
						
		String[] expGLcodeList = dataMap.get("GLCode").split("#");
		String[] expGLCodeAmtList = dataMap.get("GLCodeAmount").split("#");
		boolean flag=false;
		for(int i=0; i<expGLcodeList.length; i++) {
			if(glMap.containsKey(expGLcodeList[i])) {
				Reporter.log("List of Glcode Amt, Expected: "+glMap.get(expGLcodeList[i])+ " Actual: "+expGLCodeAmtList[i],true);
				softAssert.assertTrue(glMap.get(expGLcodeList[i]).contains(expGLCodeAmtList[i]), "List of Glcode Amt not matching, Expected: "+glMap.get(expGLcodeList[i])+ " Actual: "+expGLCodeAmtList[i]);
			} else {
				Reporter.log("List of GL code not matching, Expected: "+expGLcodeList[i]+" Actual: "+glMap,true);
				softAssert.assertTrue(flag);
			}
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Add Multiple GLCode :" + currenttime());
	}
	
	/**
	 * @author Vidya.C
	 * 
	 * 		Test to enter duplicate GL code and verify the data entered
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	@Test
	public void AddDuplicateGLCodeTest() throws FileNotFoundException, IOException, InterruptedException, SQLException {
		Reporter.log("Test Started for Add Duplicate GLCode: " + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("TaskView","My Task");
		dataMap.put("Action","EditClaim");
		dataMap.put("ClaimId", "Any");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		lavanteUtils.waitForTime(3000);

		dataMap.put("Department", "ANY");
		dataMap.put("ClaimPriority", "No");
		dataMap.put("Repay", "");
		dataMap.put("ClaimResolReason", "any");
		String claimID=dataMap.get("ClaimId");
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objCreateClaimPage.ViewPaymentRef());
		String PaymentRef=objCreateClaimPage.ViewPaymentRef().getText().trim();
		String glcode="";
		glcode=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
		if(glcode==null){
			objCreateClaimPage.UpdateGLCode(claimID,PaymentRef,glcode,customerID);
			glcode=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
			lavanteUtils.refreshPage();
		}
		dataMap.put("GLCode", glcode+"#"+glcode);
		dataMap.put("GLCodeAmount","any#any");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.EditClaim(dataMap);

		lavanteUtils.waitForTime(5000);
		dataMap.put("View", "Claims and GL codes");
		dataMap.put("Search","");
		objTasksClaimPage.searchTasksClaim(dataMap);
		
		dataMap.put("GLData", "GLCodeList");
		LinkedHashMap<String, String> glMap =objTasksClaimPage.getGLDatas(dataMap);
				
		String[] expGLcodeList = dataMap.get("GLCode").split("#");
		String[] expGLCodeAmtList = dataMap.get("GLCodeAmount").split("#");
		boolean flag=false;
		for(int i=0; i<expGLcodeList.length; i++) {
			if(glMap.containsKey(expGLcodeList[i])) {
				Reporter.log("List of Glcode Amt, Expected: "+glMap.get(expGLcodeList[i])+ " Actual: "+expGLCodeAmtList[i]);
				softAssert.assertTrue(glMap.get(expGLcodeList[i]).contains(expGLCodeAmtList[i]), "List of Glcode Amt not matching, Expected: "+glMap.get(expGLcodeList[i])+ " Actual: "+expGLCodeAmtList[i]+",Org List"+glMap);
			}else {
				Reporter.log("List of GL code not matching, Expected: "+expGLcodeList[i]+" Actual: "+glMap);
				softAssert.assertTrue(flag);
			}
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Add Duplicate GLCode :" + currenttime());
	}
	
	/**
	 * @author Vidya.C
	 * 
	 * 		Test to validate the error messages of GL code and Gl code amount
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws SQLException 
	 */
	@Test
	public void GLcodeErrorValidationTest() throws FileNotFoundException, IOException, InterruptedException, SQLException {
		Reporter.log("Test Started for GLCode Error validation :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("TaskView","My Task");
		dataMap.put("Action","EditClaim");
		dataMap.put("ClaimId", "Any");
		objTasksClaimPage.actionOnTasksClaims(dataMap);
		
		String claimID=dataMap.get("ClaimId");
		String PaymentRef=objCreateClaimPage.ViewPaymentRef().getText().trim();
		String glcode="";
		glcode=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
		if(glcode==null){
			objCreateClaimPage.UpdateGLCode(claimID,PaymentRef,glcode,customerID);
			glcode=objCreateClaimPage.glCodeFetch(claimID,PaymentRef,glcode,customerID);
			lavanteUtils.refreshPage();
		}
		dataMap.put("Department", "ANY");
		dataMap.put("ClaimPriority", "No");
		dataMap.put("Repay", "");
		dataMap.put("ClaimResolReason", "any");
		dataMap.put("GLCode", glcode);
		objCreateClaimPage.createClaimFillDetails(dataMap);

		String expGlAmtErr = "Amount is required";
		String actGLAmtErr = objCreateClaimPage.GLCodeAmtError().getText();
		softAssert.assertEquals(actGLAmtErr, expGlAmtErr,"GLCode Amount error message is not matching, Expected: "	+expGlAmtErr+ " Actual: "+actGLAmtErr);

		dataMap.clear();
		dataMap.put("GLCode", "Select GL Code");
		dataMap.put("GLCodeAmount","any");
		objCreateClaimPage.createClaimFillDetails(dataMap);

		String expGLCodeErr = "Please select GL Code for amount/receiver Number entered";
		String actGLCodeErr = objCreateClaimPage.GLCodeError().getText();
		softAssert.assertEquals(actGLCodeErr, expGLCodeErr,"GLCode error message is not matching, Expected: "	+expGLCodeErr+ " Actual: "+actGLCodeErr);
		
		dataMap.put("GLCode", glcode);
		dataMap.put("GLCodeAmount","1");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.EditClaim(dataMap);
		String expBannerMsg = "Sum of total GL Code amount is not equal to Claim Amount";
		String actBannerMsg = objCreateClaimPage.GLCodeBannerMsg().get(0).getText();
		softAssert.assertEquals(actBannerMsg, expBannerMsg,"GLCode amount is not equal to claim amount, Expected: "	+expBannerMsg+ " Actual: "+actBannerMsg);

		softAssert.assertAll();
		Reporter.log("Test Ended for GLCode error validation :" + currenttime());
	}
		
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}


}
