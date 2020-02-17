package com.lavante.sim.customer.TestScripts.Task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.*;
import com.lavante.sim.customer.pageobjects.PageInitiator;
import com.lavante.sim.customer.pageobjects.Login.GmailLoginPage;
import com.lavante.sim.customer.pageobjects.Login.LoginPage;
import com.lavante.sim.customer.pageobjects.BasicSearch.SupplierSearchPage;
import com.lavante.sim.customer.pageobjects.Task.TasksApprovalPage;

public class CustomerTasksSupplierApprovalTC0001  extends PageInitiator{
	
	List<setTestData> objdatareassignuser=null;
	List<setTestData> objTDsupplierapproval=null;
	GetExcelFile ge=new GetExcelFile();
	

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objdatareassignuser=ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.ReassignUser.getConstantValue());
		objTDsupplierapproval=ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.ApprovalTasks.getConstantValue());
		
	}
	

	@Test
	public void testverify_profilecomplete(){
	//	log.info("CustomerTasksSupplierApprovalTC0001 test execution started..");
		Reporter.log("\n Test for verify Profile complete for the module Customer's Tasks supplier approval has started...");
		try{
			String str_time="";
			Reporter.log("\n Navigating to SIM application");
			//To reject the supplier
			for(int i=0;i<objTDsupplierapproval.size();i++){
				if(!objTDsupplierapproval.get(i).getActionType().toString().trim().equalsIgnoreCase(ConfigPathFile.Reject.getConstantValue()))
					continue;
				Reporter.log("\n Logging into LAVANTE SIM aplication ");
				Assert.assertTrue(objLoginPage.userLogin(objTDsupplierapproval.get(i)),"Failure in logging into the application");
				objtaskapprovalpage.navigatetoTasksApproval();
				Reporter.log("Searching the supplier name expected along with header name");
				objtaskapprovalpage.filterByOption(ConfigPathFile.Profileapproval.getConstantValue());
				System.out.println(objTDsupplierapproval.get(i).getSupplierName().toString());
				
				String supname=objTDsupplierapproval.get(i).getSupplierName().toString();
				objtaskapprovalpage.searchSupplierwithHeader(supname,ConfigPathFile.SupplierNAME.getConstantValue());
				
				Thread.sleep(2000);

				objtaskapprovalpage.taskOptionType(ConfigPathFile.Reject.getConstantValue());
				
				str_time=objtaskapprovalpage.frameReject(objTDsupplierapproval.get(i).getComment().toString(), ConfigPathFile.Comment.getConstantValue());
				Thread.sleep(10000);
				Assert.assertFalse(objtaskapprovalpage.searchSupplierwithHeader(supname,ConfigPathFile.SupplierNAME.getConstantValue()),"Expected the record to be absent in the table");
				Reporter.log("The supplier detail of the supplier who was rejected is absent in the table as expected");
				Reporter.log("\n After approval of the supplier navigating to the search page to check the profile status of the supplier");
				Thread.sleep(2000);
				objSupplierSearchPage.searchBasicSupplier(supname,"","","true");
				Reporter.log("\n Searching for the Supplier who was rejected ");
				Thread.sleep(2000);
				objSupplierSearchPage.viewProfileofSupplierunderSearch(supname,ConfigPathFile.SupplierNAME.getConstantValue(),"");
				objSupplierSearchPage.selecttabSupplierDetails(ConfigPathFile.Status_and_History.getConstantValue(), ConfigPathFile.Profile_n_Approval_History.getConstantValue());
				objSupplierSearchPage.verifyStatusnProfileTable(objTDsupplierapproval.get(i), str_time,ConfigPathFile.Reject.getConstantValue());
				objLoginPage.logout();
			}
			//Approve the task
			for(int i=0;i<objTDsupplierapproval.size();i++){
				if(!objTDsupplierapproval.get(i).getActionType().toString().trim().equalsIgnoreCase(ConfigPathFile.Approve.getConstantValue()))
					continue;
				String supname=objTDsupplierapproval.get(i).getSupplierName().toString();
				supname="SCRASONIC";
				Assert.assertTrue(objLoginPage.userLogin(objTDsupplierapproval.get(i)),"Failure in logging into the application");
				Reporter.log("\n Navigating to the Tasks Approval Page");
				objtaskapprovalpage.navigatetoTasksApproval();
				Reporter.log("\n Searching the Approval task for the supplier");
				objtaskapprovalpage.filterByOption(ConfigPathFile.Profileapproval.getConstantValue());
				objtaskapprovalpage.searchSupplierwithHeader(supname, ConfigPathFile.SupplierNAME.getConstantValue());
				Reporter.log("\n Approving the supplier");
				objtaskapprovalpage.taskOptionType(ConfigPathFile.Approve.getConstantValue());
				str_time=objtaskapprovalpage.frameApprove(objTDsupplierapproval.get(i).getComment().toString(),ConfigPathFile.Comment.getConstantValue());
			//	str_time=objtasksapprovalpage.dbGetTime().replace(" ", "")+"PST";
				System.out.println(str_time);
				Reporter.log("\n After approval of the supplier navigating to the search page to check the profile status of the supplier");
				objSupplierSearchPage.searchBasicSupplier(supname,"","","");
				Reporter.log("\n Searching for the Supplier who was approved ");
				System.out.println(objTDsupplierapproval.get(i).getComment().toString());
				objSupplierSearchPage.viewProfileofSupplierunderSearch(supname,ConfigPathFile.SupplierNAME.getConstantValue(),"");
				objSupplierSearchPage.selecttabSupplierDetails(ConfigPathFile.Status_and_History.getConstantValue(), ConfigPathFile.Profile_n_Approval_History.getConstantValue());
				objSupplierSearchPage.verifyStatusnProfileTable(objTDsupplierapproval.get(i), str_time,ConfigPathFile.Approve.getConstantValue());
				objSupplierSearchPage.viewProfileofSupplierunderSearch(supname,ConfigPathFile.SupplierNAME.getConstantValue(),"");
				objSupplierSearchPage.selecttabSupplierDetails(ConfigPathFile.Enterprise_Owned.getConstantValue(), ConfigPathFile.Notes_n_Comments.getConstantValue());
				objSupplierSearchPage.verifyNotesandComments(objTDsupplierapproval.get(i), str_time, ConfigPathFile.Approve.getConstantValue());
				Reporter.log("\n The table contents and the corresponding values are verified");
				objSupplierSearchPage.closeSupplierDetailsPopup();
				objLoginPage.logout();
			}


			//For reassigning the tasks
			for(int i=0;i<objTDsupplierapproval.size();i++){
				if(!objTDsupplierapproval.get(i).getActionType().toString().trim().equalsIgnoreCase(ConfigPathFile.Reassign.getConstantValue()))
					continue;
				String supname=objTDsupplierapproval.get(i).getSupplierName().toString();
				supname="SCRTHWEST LOGISTICS";
				Assert.assertTrue(objLoginPage.userLogin(objTDsupplierapproval.get(i)),"Failure in logging into the application");
				Reporter.log("Navigating to tasks >> Approval page ");
				objtaskapprovalpage.navigatetoTasksApproval();
				Reporter.log("Searching the supplier name expected along with header name");
				objtaskapprovalpage.filterByOption(ConfigPathFile.Profileapproval.getConstantValue());
				objtaskapprovalpage.searchSupplierwithHeader(supname,ConfigPathFile.SupplierNAME.getConstantValue());
				objtaskapprovalpage.taskOptionType(ConfigPathFile.Reassign.getConstantValue());
				objtaskapprovalpage.frameReassign(objTDsupplierapproval.get(i).getReassignUserGrp().toString(), objTDsupplierapproval.get(i).getReassignUserName().toString()+"("+objTDsupplierapproval.get(i).getReassignUserID().toString()+")");
				Thread.sleep(10000);
				Assert.assertFalse(objtaskapprovalpage.searchSupplierwithHeader(supname,ConfigPathFile.SupplierNAME.getConstantValue()),"The supplier did not get off from the Approval list of the customer after reassigning approval task to a different user");
				Reporter.log("Supplier moved out from the customer's approval task list after being reassigned");
				objLoginPage.logout();
				Thread.sleep(20000);
				//login as the user to whom the task was reassigned
				objLoginPage.validateUserLogin(objdatareassignuser);
				objtaskapprovalpage.navigatetoTasksApproval();
				//search for the supplier in the tasks list
				Thread.sleep(2000);
				//approve the reassigned task of post profile completion
				objtaskapprovalpage.filterByOption(ConfigPathFile.Profileapproval.getConstantValue());
				Assert.assertTrue(objtaskapprovalpage.searchSupplierwithHeader(supname, ConfigPathFile.SupplierNAME.getConstantValue()),"Failed to find the supplier in the task list of the user to whom the task was reassigned");
				Reporter.log("The task reassigned to the user has appeared in the suppliers list");
				objLoginPage.logout();
				Reporter.log("The user logged out of the LAVANTE application");
			}
			Reporter.log("Test execution for the test verify_profile complete is SUCCESSFUL");
		}catch(Exception e){
			Reporter.log("Failure in the test execution of the test for Verify_profilecomplete");
	//		log.severe("Failure in the test execution of Verify Profile complete for the module Customer's Tasks supplier approval due to : "+e.getMessage());
			Assert.assertTrue(false,"Failure in the test execution due to  : "+e.getCause());
		}
		Reporter.log("The test execution ended");
	}


	@AfterClass
	public void closer(){
		quitBrowser();		
	}


}
