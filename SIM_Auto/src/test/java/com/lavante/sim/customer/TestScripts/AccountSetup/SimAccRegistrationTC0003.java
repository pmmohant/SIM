/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 */ 

package com.lavante.sim.customer.TestScripts.AccountSetup;

import java.util.List;

import org.openqa.selenium.WebDriver;
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


public class SimAccRegistrationTC0003 extends PageInitiator {

	List<setTestData> objSupplierRegistrationTestData =null;
	List<setTestData> objGmailTestData =null;
	List<setTestData> objSupplierSubTestData =null;
	List<setTestData> objinvitedata=null;GetExcelFile ge=new GetExcelFile();
	public WebDriver driver=null;
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	launchAppFromPOM(Platform,browser,Version);
	initiate();
	
	openAPP();	
		
	objGmailTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.GmailLogin.getConstantValue());
	objSupplierSubTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.SupplierSubject.getConstantValue());
	objSupplierRegistrationTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.SupplierRegistration.getConstantValue());
	objinvitedata =ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.InviteDecline.getConstantValue());
	}
	


	/**
	 * Method Name : verifyExistingSupplierInvite 
	 * Purpose: verifying the existing supplier get invites
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifyExistingSupplierInvite() {
		Reporter.log(" SimAccRegistrationTC0003 Started");
		try {
	
			for(int i=0;i<objSupplierSubTestData.size();i++){
				objGmailLoginPage.navigateToGmailApplication();
				if(objGmailLoginPage.validateGMailLogin(objGmailTestData)==true){
					String str_link=null;
					str_link=objGmailLoginPage.readMails(objSupplierSubTestData.get(i),objSupplierSubTestData.get(i).getSupplierName().toString(),ConfigPathFile.Click.getConstantValue());
					objGmailLoginPage.clickLogoutBtn();
					//str_link="http://192.168.21.36:9080/sim/supplierAccountSetup.lvp?ODbJFKzfqHcXobM5yNTAl50Ojfpv9IOukdAsmATEe8mrYru3TiGZ803LeaoqKSwShJRNERc8yYuy7+OTrv/bb8z9HWNl6ENemns8sshtE8Wwe1WzPsl/7g/kDd/kPZL78nRReJQ+jhU=";
					driver.get(str_link);
					
					objSimAccRegistrationPage.validateSupplierRegistrations(objSupplierRegistrationTestData);
					objLoginPage.logout();
				}
			}
			
			/**commented out this piece of code which will do the invite for declining the invite 
			because there is no 3rd customer have 'Invite New Supplier' link for sending the invite for declining it
			*/
			//the below code sends an invite to the supplier for declining
			/*objLogin.navigateToSIMApplication();
			for(int i=0;i<objinvitedata.size();i++){
				if(objLogin.userLogin(objinvitedata.get(i))==true){
					Reporter.log("\n Successfully Logged into LAVANTE");
					objsearchPage.navigateToSuplPage();
					if(objsearchPage.inviteNewSupplier(objinvitedata.get(i))==true)
					{
						Reporter.log("\n Successfully invited a supplier");
					}
					else
						Reporter.log("\n Failure in inviting new supplier");
					objLogin.logout();

					Reporter.log("\n Successfully logged out of LAVANTE application");
				}
			}*/

		} catch (Exception e) {
	//		log.severe("Exception in method verifyMyAccountUIControls due To "+e.getMessage());
			Assert.assertTrue(false,"Exception in method verifyMyAccountUIControls due To  "+e.getMessage());
		}
		Reporter.log(" Execution of Test Case SimAccRegistrationTC0003 is completed ");
	}

	/**
	 * Method Name : tearnDown 
	 * Purpose: Method for closing the Browser
	 * @param: None
	 * @return None
	 */
	@AfterClass
	public void close(){
	
		quitBrowser();
	}

		

}
