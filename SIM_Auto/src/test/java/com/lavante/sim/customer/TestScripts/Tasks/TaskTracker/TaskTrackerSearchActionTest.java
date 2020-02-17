package com.lavante.sim.customer.TestScripts.Tasks.TaskTracker;

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

public class TaskTrackerSearchActionTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
	String Email="";
	
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
		Email=LdataMap.get("username");
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "taskTracker");
		enobjhomePage.selectTab(LdataMap);

		lavanteUtils.fluentwait(enTasksTracker.searchbtn());
		enTasksTracker.switchTasksClaimView(LdataMap);
		if(!(objTasksClaimPage.iterateSearchHeaderFindColList("Task ID").size()>2)){
			
			LdataMap.put("subtab", "viewApprovalTasks");
			enobjhomePage.selectTab(LdataMap);
			
			LdataMap.put("filterby","Claims to approve");
			LdataMap.put("ALLSupplier","");
			LdataMap.put("ReAssign","");
			LdataMap.put("AssginTo","User");
			/*String x="Select lr.UserRoleName From Login l,LoginRole lr where l.ContactID in (select ContactID From contact where Email ='"+LdataMap.get("username")+"') "
					+ " and lr.UserRoleID=l.UserRoleID";
			x=lavanteUtils.fetchDBdata(x);
			String uname=x+"("+LdataMap.get("username")+")";*/
			LdataMap.put("User",LdataMap.get("username")); 
			enReassign.selectSupplierFormAction(LdataMap);
		}
	
	}
	
	/**
	 * Before method to navigate to the Tasks->Claim tab
	 * 
	 */
	@BeforeMethod
	public void navigateToTaskClaimPage(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "taskTracker");
		enobjhomePage.selectTab(LdataMap);
		waitforPageload(enTasksTracker.searchbtn());		
	}
	
	/**
	 * Test Script for Task Tracker Single Search.
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void taskTrackerSingleSearchTest() throws Exception {
		Reporter.log("<----------Test Started for taskTrackerSingleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
				String x=enTasksTracker.iterateSearchHeaderFindColList("Task ID").get(0).getText().trim();
				dataMap.put("TaskID",x );
				dataMap.put("Search","");
				enTasksTracker.search(dataMap);
		
				if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
					Reporter.log("Search Returned the Result");
					String y=enTasksTracker.iterateSearchHeaderFindColList("Task ID").get(0).getText().trim();
					Reporter.log("Task ID ,Expected:"+x+",Actual:"+y);
					softAssert.assertEquals(y, x,"Task ID Not Matched");
					flag=true;
				}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<----------Test Ended at taskTrackerSingleSearchTest:" + currenttime(),true);
	}

	/**
	 * Test Script for Task Tracker Multi Search 
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void taskTrackerMultipleSearchTest() throws Exception {
		Reporter.log("<----------Test Started for taskTrackerMultipleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
				
			String x= enTasksTracker.iterateSearchHeaderFindColList("Task ID").get(0).getText().trim();
			String xx=enTasksTracker.iterateSearchHeaderFindColList("Task Type").get(0).getText().trim();
		dataMap.put("TaskID",x);
		dataMap.put("TaskType",xx );
		dataMap.put("Search","");
		enTasksTracker.search(dataMap);
		
			if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
				Reporter.log("Search Returned the Result");
				
				String y=enTasksTracker.iterateSearchHeaderFindColList("Task ID").get(0).getText().trim();
				Reporter.log("Task ID ,Expected:"+x+",Actual:"+y);
				softAssert.assertEquals(y, x,"Task ID Not Matched");
				
				y=enTasksTracker.iterateSearchHeaderFindColList("Task Type").get(0).getText().trim();
				Reporter.log("Task Type ,Expected:"+xx+",Actual:"+y);
				softAssert.assertEquals(y, xx,"Task Type Not Matched");

				flag=true;
			}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("--Test Ended at taskTrackerMultipleSearchTest:" + currenttime(),true);
	}
	
	/**
	 * Test Script for Task Tracker Reassign Test with reassignement
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void taskTrackerReassignMyTaskTest() throws Exception {
		Reporter.log("<---------------------Test Started for taskTrackerSingleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
				
		dataMap.put("TaskID", "ANY");
		dataMap.put("Action", "Reassign");
		dataMap.put("AssginTo", "User");
		String x="select MAX(ContactName) from Contact where Email not in ('"+Email+"') and ContactID in (select ContactID from Login where UserRoleID in"
				+ " (select UserRoleID from CustomerLoginRoleMap where CustomerID ="+customerID+")) and Isactive=1;";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("User", x);
		enTasksTracker.actionOnTasksClaims(dataMap);
		
		dataMap.put("Search","");
		enTasksTracker.search(dataMap);
		
		enTasksTracker.switchTasksClaimView(dataMap);
		
		if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
				Reporter.log("Search Returned the Result");
				String y=enTasksTracker.iterateSearchHeaderFindColList("Task ID").get(0).getText().trim();
				Reporter.log("Task ID ,Expected:"+dataMap.get("TaskID")+",Actual:"+y,true);
				softAssert.assertEquals(y, dataMap.get("TaskID"),"Task ID Not Matched");
				y=enTasksTracker.iterateSearchHeaderFindColList("Assigned To").get(0).getText().trim();
				Reporter.log("Assigned To ,Expected:"+x+",Actual:"+y,true);
				softAssert.assertEquals(y, x,"Assigned TO Not Matched");
				
				dataMap.put("View","My Tasks");
				enTasksTracker.switchTasksClaimView(dataMap);
				enTasksTracker.search(dataMap);
				if(enTasksTracker.iterateSearchHeaderFindColList("Task ID").size()>0){
					
				}else{
					Reporter.log("My Task Not Showing any Task ID as Expected");
					flag=true;
				}
				
			}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at taskTrackerSingleSearchTest:" + currenttime(),true);
	}

	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();		
	}
}
