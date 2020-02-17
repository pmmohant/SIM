/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 */

package com.lavante.sim.customer.TestScripts.AccountSetup;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SimAccSetupTC0001_0002 extends PageInitiator {

	List<setTestData> objGmailTestData = null;
	List<setTestData> objSupplierSubTestData = null;
	List<setTestData> objAccSetupTestData = null;
	List<setTestData> objinvitedata=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	launchAppFromPOM(Platform,browser,Version);
	initiate();
	
	openAPP();
		
		objGmailTestData = ge.getData(
				ConfigPathFile.TestDataIntegration.getConstantValue(),
				ConfigPathFile.GmailLogin.getConstantValue());
		objSupplierSubTestData = ge.getData(
				ConfigPathFile.TestDataIntegration.getConstantValue(),
				ConfigPathFile.SupplierSubject.getConstantValue());
		objAccSetupTestData = ge.getData(
				ConfigPathFile.TestDataIntegration
				.getConstantValue(),
				ConfigPathFile.validateMandateFields.getConstantValue());
		objinvitedata =ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.InviteAccept.getConstantValue());
	}
	

	/**
	 * Method Name : verifySimAccountSetup Purpose: Method is used to read the
	 * received mail and click on the link to open Account setup page
	 * 
	 * @param: None
	 * @return None
	 */
	
	@Test
	public void verifySimAccountSetup() {
		Reporter.log("SimAccSetupTC0001_0002 Started: ");
		try {

			
			//objGmailLoginPage.navigateToGmailApplication();

			/*if (objGmailLoginPage.validateGMailLogin(objGmailTestData) == true) {
				for (int i = 0; i < objSupplierSubTestData.size(); i++) {
					String str_link=objGmailLoginPage.readMails(objSupplierSubTestData.get(i),objSupplierSubTestData.get(i).getSupplierName().toString(),ConfigPathFile.Click.getConstantValue());
					objGmailLoginPage.clickLogoutBtn();
					System.out.println(str_link+"NW RUL");
					driver.get(str_link);
					objSimAccountSetupPage.verifyACCSetupPageUIControls();
					objSimAccountSetupPage.validateMandateControls(objAccSetupTestData);
				}
			}*/
			String str_link=null;
			/*This part of code is for sending invite to the same supplier from a different customer
			 * Commented for now since there are no other customers to send invitations to the supplier 
			 * directly by clicking on the INVITE NEW SUPPLIER link
			 */
			openAPP();
			
			for(int i=0;i<objinvitedata.size();i++){

				// This URL should be moved to config file. 
			
				str_link="http://simdev.lavante.com:8080/sim/supplierRegistrationPage.lvp?/iNe/rwa6jQUDHhgMInlhuGtoybh90crtE/aCAw/cNCjB7N28ZuPBXXBdHRUfUC4gvwxsyLzCgtV9NHJVXDt8LQvyt4F3FQC+ZKAn5wkHx6jy450K7xAuEv6+NZS4cQBnMhuJD94gyA=";
				
				driver.get(str_link);
				objSimAccountSetupPage.verifyACCSetupPageUIControls();
				objSimAccountSetupPage.validateMandateControls(objAccSetupTestData);
				
				if(objLoginPage.userLogin(objinvitedata.get(i))==true){
					Reporter.log("\n Successfully Logged into LAVANTE");
					objSupplierSearchPage.navigateToSuplPage();
					if(objSupplierSearchPage.inviteNewSupplier(objinvitedata.get(i))==true)
						Reporter.log("\n Successfully invited a supplier");
					else
						Reporter.log("\n Failure in inviting new supplier");
					objLoginPage.logout();
					Reporter.log("\n Successfully logged out of LAVANTE application");
				}
			}

		} catch (Exception e) {
		//	log.severe("Exception in method verifyMyAccountUIControls due To "
		//			+ e.getMessage());
		}
		Reporter.log("\n Successfully logged out of LAVANTE application");
		Reporter.log("Execution of Test Case SimAccSetupTC0001_0002 is completed: ");
	}
	
	@AfterClass
	public void close(){
	
		quitBrowser();
	}

}
