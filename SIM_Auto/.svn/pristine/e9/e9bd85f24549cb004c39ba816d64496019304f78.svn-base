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
import com.lavante.sim.customer.pageobjects.Login.GmailLoginPage;
import com.lavante.sim.customer.pageobjects.Login.SimAccountSetupPage;

public class SimAccSetupTC0003 extends PageInitiator {

	GmailLoginPage objGmailLoginPage = null;
	SimAccountSetupPage objSimAccountSetupPage = null;
	List<setTestData> objGmailTestData = null;
	List<setTestData> objAccSetupTestData = null;
	List<setTestData> objSupplierSubTestData = null;
	GetExcelFile ge=new GetExcelFile();
	public WebDriver driver=null;
	
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
		
		
	}
	

	/**
	 * Method Name : verifyExistingSupplierInvite Purpose: verifying the
	 * existing supplier get invites
	 * 
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifyExistingSupplierInvite() {
		Reporter.log("SimAccSetupTC0003 Started: ");
		try {
	
			
				for (int i = 0; i < objSupplierSubTestData.size(); i++) {
					objGmailLoginPage.navigateToGmailApplication();
					//this wait is given to wait for the email to arrive
					Thread.sleep(80000);
					if (objGmailLoginPage.validateGMailLogin(objGmailTestData) == true) {
						
					String str_link=objGmailLoginPage.readMails(objSupplierSubTestData.get(i),objSupplierSubTestData.get(i).getAcceptInvite().toString(),ConfigPathFile.Click.getConstantValue());
					objGmailLoginPage.clickLogoutBtn();
					driver.get(str_link);
					objSimAccountSetupPage.verifyAcceptDeclinePageUIControls();
				}
			}
		} catch (Exception e) {
	//		log.severe("Exception in method verifyMyAccountUIControls due To "
		//			+ e.getMessage());
			Assert.assertTrue(false,
					"Exception in method verifyMyAccountUIControls due To  "
							+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SimAccSetupTC0003 is completed: ");
	}
	@AfterClass
	public void closer(){
	
		quitBrowser();
	}

}
