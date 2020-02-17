package com.lavante.sim.customer.TestScripts.Task;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.PageInitiator;
import com.lavante.sim.customer.pageobjects.BasicSearch.SupplierSearchPage;

public class CustomerTasksSupplierApprovalTC0003 extends PageInitiator{

	List<setTestData> objdatacustomerAdminlogin=null;
	List<setTestData> objdata=null;
	List<setTestData> objdatagmaillogin=null;
	SupplierSearchPage objsearchpage=null;
	List<setTestData> objdatauserLogin=null;
	List<setTestData> objdatareassignuser=null;
	SoftAssert sAssert=new SoftAssert();
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objdata=ge.getData(ConfigPathFile.TestDataForInviteApproval.getConstantValue(), ConfigPathFile.InviteSupplierTasks.getConstantValue());
		objdatacustomerAdminlogin=ge.getData(ConfigPathFile.TestDataForInviteApproval.getConstantValue(), ConfigPathFile.CustomerLogin.getConstantValue());
		objdatauserLogin=ge.getData(ConfigPathFile.TestDataForInviteApproval.getConstantValue(), ConfigPathFile.UserLogin.getConstantValue());
		objdatagmaillogin=ge.getData(ConfigPathFile.TestDataForGmail.getConstantValue(), ConfigPathFile.Login.getConstantValue());
		objdatareassignuser=ge.getData(ConfigPathFile.TestDataForInviteApproval.getConstantValue(),ConfigPathFile.ReassignUser.getConstantValue());
		
	}
	
	


	@Test
	public void testApprovalInvite(){
		try{
			
			
			Reporter.log("Navigated to the LAVANTE SIM application");
		for(int j=0;j<objdatacustomerAdminlogin.size();j++){ 
				for(int i=0;i<objdatauserLogin.size();i++){
					for(int n=0;n<objdata.size();n++){
						
						Assert.assertTrue(objLoginPage.userLogin(objdatauserLogin.get(i)),"Failed to Login to application");
						Reporter.log("Logged into the application with the credentials provided.");
						objsearchpage.navigateToSuplPage();
						Reporter.log("Navigated to the supplier search page");
						Assert.assertTrue(objsearchpage.inviteNewSupplier(objdata.get(n)),"Failed to invite a new supplier ");
						Reporter.log("Invite a new supplier");
						Thread.sleep(20000);
						objLoginPage.logout();
					}

				}
				
				objLoginPage.navigateToSIMApplication();
				Reporter.log("Navigated to the Login page of LAVANTE application");
				Assert.assertTrue(objLoginPage.userLogin(objdatacustomerAdminlogin.get(j)),"Failed to login to the application with the credentials provided in the excel sheet");
				Reporter.log("Logged into the Super Admin Customer Account");
				for(int k=0;k<objdata.size();k++){ 
					objtaskapprovalpage.navigatetoTasksApproval();
					try{
					Thread.sleep(150000);
					}catch(Exception e)
					{
						
					}
					String Supname=objdata.get(k).getSupplierName().toString();
					//Supname="testInviteApprovalSup124";
					System.out.println("ACTION"+objdata.get(k).getActionType().toString());
					Reporter.log("Navigated to the tasks approval page");
					objtaskapprovalpage.filterByOption(objdata.get(k).getActionTaken().toString());
					Reporter.log("Filtered the suppliers as ||"+objdata.get(k).getActionTaken().toString()+"||");
				
					objtaskapprovalpage.searchSupplierwithHeader(Supname,ConfigPathFile.SupplierNAME.getConstantValue());
					objtaskapprovalpage.taskOptionType(objdata.get(k).getActionType());
					String str_time="";
				    str_time=objtaskapprovalpage.actionToBeDone(objdata.get(k));
					Thread.sleep(2000);
					//Assert.assertFalse(objapprovalpage.searchSupplierwithHeader(Supname,ConfigPathFile.SupplierNAME.getConstantValue()),"Expected the record to be absent in the table");
					
					if(objdata.get(k).getActionType().toString().equalsIgnoreCase(ConfigPathFile.Reject.getConstantValue()))
					{
						Reporter.log("\n Searching for the Supplier who was Rejected ");
						
						objsearchpage.searchBasicSupplier(Supname,"","","true");
						objsearchpage.viewProfileofSupplierunderSearch(Supname,ConfigPathFile.SupplierNAME.getConstantValue(),objdata.get(k).getActionType().toString());
						objsearchpage.selecttabSupplierDetails(ConfigPathFile.Status_and_History.getConstantValue(), ConfigPathFile.Profile_n_Approval_History.getConstantValue());
						System.out.println("SELECTED TABBBBBBBBBBBB");
						Assert.assertTrue(objsearchpage.verifyStatusnProfileTable(objdata.get(k), str_time,objdata.get(k).getActionType().toString()),"Failure to verify the details of the given supplier");
						System.out.println("Verified for reject");
						Reporter.log("Reject Verification done");
					}
					else if(objdata.get(k).getActionType().toString().equalsIgnoreCase(ConfigPathFile.Approve.getConstantValue())){
						for(int m=0;m<objdatagmaillogin.size();m++){
							objGmailLoginPage.navigateToGmailApplication();
							Reporter.log("Navigated to the Gmail Application");
							objGmailLoginPage.validateGMailLogin(objdatagmaillogin);
							Reporter.log("Logged into Gmail");
							objGmailLoginPage.readMails(objdata.get(k), objdata.get(k).getCustomerName().toString()+","+Supname, ConfigPathFile.Click.getConstantValue());
							objGmailLoginPage.clickLogoutBtn();
						}
					}
					else if(objdata.get(k).getActionType().toString().equalsIgnoreCase(ConfigPathFile.Reassign.getConstantValue())){
						for(int p=0;p<objdatareassignuser.size();p++){
							objLoginPage.logout();
							Reporter.log("Logged out of the Super Admin Customer Account");
							Assert.assertTrue(objLoginPage.userLogin(objdatareassignuser.get(p)),"Failed to login to the LAVANTE SIM application");
							objtaskapprovalpage.navigatetoTasksApproval();
							Reporter.log("Navigated to the Tasks approval page");
							objtaskapprovalpage.filterByOption(objdata.get(k).getActionTaken().toString());
							sAssert.assertTrue(objtaskapprovalpage.searchSupplierwithHeader(Supname, ConfigPathFile.SupplierNAME.getConstantValue()),"Failed to find the supplier in the approvals list");
							Reporter.log("Found the reassigned supplier in the Approvals list");
						}
					} 
					else{
						System.out.println(objdata.get(k).getActionType().toString()+"NOT MATCHED HENCE GONNA FAIL");
						Assert.assertTrue(false,"The option provided is not present in the expected set of values");
					}
				}
				objLoginPage.logout();
				Reporter.log("Logged out of the application");
			}

		}catch(Exception e){
			Reporter.log("Failed the test due to exception");
		//	log.severe("Failure in the test to approve the supplier by invite new suplier workflow failed due to  : "+e.getLocalizedMessage());
			Assert.assertTrue(false,"Failed due the exception : "+e.getMessage()+" due to : "+e.getCause());
		}
		Reporter.log("Successfully completed the execution of the test for Customer Supplier Invite Approvals ");
	}



	@AfterClass
	public void close(){
		quitBrowser();		
	}

	

}
