package lavante.recovery.testsuites;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.DataProviders.CreditTableDataProvider;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

public class Audit_OutboundDataPage_TS04 extends pageInitiator {
	
	 @BeforeClass
	  @Parameters({ "Platform", "Browser", "Version" })
	 public void preCondition(@Optional (LavanteUtils.Platform) String platform , @Optional (LavanteUtils.browser) String browser,@Optional (LavanteUtils.browserVersion) String version) throws Exception  {
		  
		  launchAppThroughPOM(platform,browser,version);

		  initiate();
		  
		  startTest("loginWithValidCredentials");
		  
		  loginPage.enterUserName(readConfigFile("username"));
		  loginPage.enterPassWord(readConfigFile("password"));	
		 // waitForTime(5000);

		  loginPage.clickLoginButton();  
		  
		  waitForTime(5000);
		  
		  homePage.verifyHomePageDisplayed();

		  //Close the pop up for Browser specific info
		  verifyBrowserStartPopUp();
		  
		  waitForTime(3000);
		  
		  genericPageObjects.verifyAuditSelectBox();
		  genericPageObjects.verifyAuditSelectBoxTextBox();
		  	 
		  endTest("loginWithValidCredentials");	 
	  }

	 	/**
	 	 * Date Created : 12/12/16
	 	 * Creator: Srikanth Tallury
	 	 * Purpose: This test is for verifying credits are saved successfully
	 	 * @throws AWTException
	 	 * @throws ParseException
	 	 */
	 	@Test()
		public void verifyCreditEntryForRecognizedFax() throws AWTException, ParseException{

	 		Reporter.log("Verification of credits in credit table started");
	 		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 	  dataMap.put("SupplierRef", "supp");
		 	  dataMap.put("Customer", "cust");
		 	  dataMap.put("CreditDate", "");
		 	  dataMap.put("Amount", "");
		 	  dataMap.put("Active", "Active");
			  dataMap.put("Credits", "Credits");
 
			  dashboardclaimsPage.verifyDashBoardLink();
			 
			  waitForTime(3000);
			  auditOutboundPage.verifyauditLink();
			//  waitForTime(5000);
			  auditOutboundPage.navigateDatapage();
			  auditInboundPage.updateSupplierDetails();
			  auditInboundPage.EnterCredits(dataMap);
			  switchtoFrame(null);
			  auditOutboundPage.updateSuppStatus(dataMap);
			Reporter.log("Verification of credits in credit table Ended");
		 }
	 	
	 	/**
	 	 * Date Created : 12/12/16
	 	 * Creator: Srikanth Tallury
	 	 * Purpose: This test is for verifying supplier details update
	 	 * @throws AWTException
	 	 * @throws ParseException
	 	 */
	 	@Test()
		public void verifySupplierDetailsChange() throws AWTException, ParseException{
	 		Reporter.log("Verification of updation of supplier details started");
	 		
	 		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 	  dataMap.put("Active", "Active");
		 	 dataMap.put("Credits", "Credits");
		 	  
			  auditInboundPage.updateSupplierDetails();
			  auditOutboundPage.updateSuppStatus(dataMap);
			  
			Reporter.log("Verification of updation of supplier details Ended");
		 }
	 	
	 	/**
	 	 * Date Created : 01/04/16
	 	 * Creator: Srikanth Tallury
	 	 * Purpose: This test is for verifying DNA and NC suppliers, Send fax should be disabled
	 	 * @throws AWTException
	 	 * @throws ParseException
	 	 */
	 	@Test()
		public void verifyDNASuppliersSendFax() throws AWTException, ParseException{
	 		Reporter.log("Verification of sending fax for DNA suppliers started");
	 		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 	  dataMap.put("Do Not Audit", "");

		 	  waitForTime(3000);
			  auditOutboundPage.verifyauditLink();
			  waitForTime(5000);
			  auditOutboundPage.DataPageCheckforSendFax(dataMap);
			
 
			Reporter.log("Verification of sending fax for DNA suppliers started Ended");
		 }
	 	
  @AfterClass
  public void clean() {
	  auditOutboundPage.LogOut();
	  quitBrowser();
  }
  
}
