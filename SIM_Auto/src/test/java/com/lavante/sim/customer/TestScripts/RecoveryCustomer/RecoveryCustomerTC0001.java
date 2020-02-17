package com.lavante.sim.customer.TestScripts.RecoveryCustomer;

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
import com.lavante.sim.customer.pageobjects.Login.*;
import com.lavante.sim.customer.pageobjects.SupplierProfile.SupplierProfilePage;
import com.lavante.sim.customer.pageobjects.Login.*;
import com.lavante.sim.customer.pageobjects.PageInitiator;
import com.lavante.sim.customer.pageobjects.BasicSearch.*;


public class RecoveryCustomerTC0001 extends PageInitiator {

	List<setTestData> objdatarecovery=null;
	List<setTestData> objrecoveryInvite=null;
	List<setTestData> objdatagmail=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
	}
		
	

	@Test
	public void testLegalIDRecoveryCustomer(){
		try{

			for(int i=0;i<objrecoveryInvite.size();i++){
			//objLoginPage.navigateToSIMApplication();
				Reporter.log("Navigated to the LAVANTE SIM application");
			if(objLoginPage.userLogin(objrecoveryInvite.get(i))){
		//		if(1==1){
					Reporter.log("Logged into the LAVANTE SIM application");
					objSupplierSearchPage.navigateToSuplPage();
					Reporter.log("Navigated to the supplier search page ");
					//change to be made in this method
					objSupplierSearchPage.inviteNewSupplier(objrecoveryInvite.get(i));
					Reporter.log("Invited a new supplier");
					objLoginPage.logout();
					Reporter.log("Logged out of the LAVANTE application");
					for(int j=0;j<objdatagmail.size();j++){
						objGmailLoginPage.navigateToGmailApplication();
						objGmailLoginPage.validateGMailLogin(objdatagmail);
						Thread.sleep(120000);
						Reporter.log("Logged into Gmail");
						Reporter.log("Finding the invitation mail that was sent ");
						String str_link=objGmailLoginPage.readMails(objdatagmail.get(i), objdatagmail.get(i).getRecoverySubject().toString(), ConfigPathFile.Click.getConstantValue());
						objGmailLoginPage.clickLogoutBtn();
						Reporter.log("Found the invitation mail that was sent to the supplier from the Recovery customer");
						driver.get(str_link);
					}
					for(int k=0;k<objdatarecovery.size();k++){
						Reporter.log("Navigated to the Supplier Account setup page");
						Thread.sleep(7000);
						objSimAccountSetupPage.validateMandateControls(objdatarecovery);
						Reporter.log("Completed the Account set up.. Navigating to the Supplier Registeration page");
						Reporter.log("Verifying if the legal ID section is present in the registration page");
						Assert.assertTrue(objSimAccRegistrationPage.verifyLegalIDTabpresent(objdatarecovery.get(i)), "The legal ID section is found on the registration page for the supplier invited from a recovery customer");
						Reporter.log("Completed the Registration of the supplier. Navigating to the supplier profile page");
						objLoginPage.userLogin(objdatarecovery.get(i));
						objSimAccRegistrationPage.acceptDialogAfterReg();
						Reporter.log("Navigating to the profile page of the supplier to verify if there are more than 2 tabs in the profile");
						//objprofilepage.verifyProfilePercentage("Sears Holding Corporation");
						objSupplierProfilePage.navigateToProfilePage();
						Assert.assertTrue(objSupplierProfilePage.verifypresenceAbsenceTAB(objdatarecovery.get(k)),"Failed in the verification of the TABs on the profile page");
						objLoginPage.logout();
						Reporter.log("Supplier logged out of the supplier portal");
					}
				}else {
					Reporter.log("Failed to login to the application successfully");
				}
			}
		}catch(Exception e){
			Reporter.log("Failure to run the test to completion due to the exception caused "+e.getCause());
		//	log.severe("Failure in the test execution due to the exception caused : "+e.getMessage());

		}
	}

	@AfterClass
	public void close(){
	
		quitBrowser();
	}

}
