package com.lavante.sim.customer.TestScripts.Task;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.PageInitiator;


public class CustomerTasksSupplierApprovalTC0002 extends PageInitiator{
	
	List<setTestData> objdata=null;
	List<setTestData> objdataDelegate=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objdata=ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.ApprovalTasks.getConstantValue());
		objdataDelegate=ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.ReassignUser.getConstantValue());
		
	}
	

	@Test
	public void testdelegate(){
		Reporter.log("Test for CustomerTasksSuplierApprovalTC0002 has started ...");
		try{
			
			Reporter.log("Navigated to the SIM application");
			for(int i=0;i<objdata.size();i++){
				if(!objdata.get(i).getActionType().toString().equalsIgnoreCase(ConfigPathFile.Reassign.getConstantValue()))
					continue;
				if(objLoginPage.userLogin(objdata.get(i))){
					Reporter.log("Logged into the Application");
				String str_user=objdata.get(i).getReassignUserName().toString()+"("+objdata.get(i).getReassignUserID().toString();
				str_user=objdata.get(i).getReassignUserID().toString();
				System.out.println(str_user);
				objMyAccountPage.delegateTasks(str_user);
				Reporter.log("Delegated the tasks to the user : "+objdata.get(i).getReassignUserName().toString());
				objtaskapproval.navigatetoTasksApproval();
				List<String> lst_sup= new ArrayList<String>();
				//the number of suppliers recorded from the tasks list for verification is 2
				lst_sup=objtaskapproval.firstSuppliers(2);
				objLoginPage.logout();
				Reporter.log("Logged out from the Customer Admin portal");
				for(int j=0;j<objdataDelegate.size();j++){
				if(objLoginPage.userLogin(objdataDelegate.get(j))){
					Reporter.log("Logged into the LAVANTE application");
					objtaskapproval.navigatetoTasksApproval();
					Assert.assertTrue(objtaskapproval.verifyListpresentinTasks(lst_sup),"Failed to find the supplier task list in the Approval Tasks table");
					Reporter.log("Found all the required suppliers in the tasks list of the User to whom the tasks were delegated");
					objLoginPage.logout();
					Reporter.log("Logged out of the application");
				}else{
					Assert.assertTrue(false,"Failed to login to the Application as the Other User to whom the tasks were delegated");
				}
				}
				objLoginPage.userLogin(objdata.get(i));
				Reporter.log("Changing the settings back to 'No Delegate'");
				objMyAccountPage.delegateTasks(ConfigPathFile.NoDelegate.getConstantValue());
				objLoginPage.logout();
			}else{
				Assert.assertTrue(false,"Failed to login to the application as the Customer Admin");
			}
			}

		}catch(Exception e){
			Reporter.log("Failed to complete the execution of the test to delegate the tasks ");
		//	log.severe("Failure in the test run of Delegation of tasks due to : "+e.getMessage());
			Assert.assertTrue(false,"Failure in the test execution of the CustomerTasksSupplierApprovalTC0002 due to : "+e.getCause());
		}
		Reporter.log("Test Execution of the test script to verify the delegation functionality has ended");
	}
	

	@AfterClass
	public void close(){	
		quitBrowser();
	}

	
}
