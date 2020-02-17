/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 */ 

package com.lavante.sim.customer.TestScripts.AccountSetup;

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

public class SimAccRegistrationTC0002 extends PageInitiator {

	List<setTestData> objSimRegistrationTestData =null;
	List<setTestData> objGmailTestData =null;
	List<setTestData> objAccSetupTestData =null;
	List<setTestData> objSupplierSubTestData =null;
	List<setTestData> objFieldLabelNamesTestData=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	launchAppFromPOM(Platform,browser,Version);
	initiate();
	
	openAPP();
	
	objGmailTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.GmailLogin.getConstantValue());
	objSupplierSubTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.SupplierSubject.getConstantValue());
	objSimRegistrationTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.ValidateFieldErrMsgs.getConstantValue());
	objAccSetupTestData = ge.getData(ConfigPathFile.TestDataForSupplierAccSetup.getConstantValue(), ConfigPathFile.VALIDATEREGISTRATION.getConstantValue());

	}
	
	/**
	 * Method Name : verifyExistingSupplierInvite 
	 * Purpose: verifying the existing supplier get invites
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifyExistingSupplierInvite() {
		Reporter.log(" SimAccRegistrationTC0002 Started");
		try {
				for(int i=0;i<objSupplierSubTestData.size();i++){
					String sub=null;
					sub=objSupplierSubTestData.get(i).getSupplierName().toString();
					objGmailLoginPage.navigateToGmailApplication();
					if(objGmailLoginPage.validateGMailLogin(objGmailTestData)==true){
						
					String str_link=null;
					str_link=objGmailLoginPage.readMails(objSupplierSubTestData.get(i),sub,ConfigPathFile.Click.getConstantValue());
					objGmailLoginPage.clickLogoutBtn();
					System.out.println(str_link);
					driver.get(str_link);
					
		//			objSimAccSetupPage.validateMandateControls(objAccSetupTestData);
					objSimAccRegistrationPage.VerifyRequiredFieldErrMessages(objSimRegistrationTestData);
				}
			}
		} catch (Exception e) {
		//	log.severe("Exception in method verifyExistingSupplierInvite due To "+e.getMessage());
			Assert.assertTrue(false,"Exception in method verifyExistingSupplierInvite due To  "+e.getMessage());
		}
		Reporter.log(" Execution of Test Case SimAccRegistrationTC0002 is completed ");
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
