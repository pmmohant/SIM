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

public class Inbound_WorkFlow_TS01 extends pageInitiator {
	
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

     //verification for Needs Review and Save and Dispose functionality
	 @Test(priority=1)
	  public void verifyInboundDataPageActions() throws AWTException{
		 
		 Reporter.log("verification for Data page actions started");
		 
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 dataMap.put("Save", "");
		 dataMap.put("Save & Dispose","" );
		 dataMap.put("Awaiting Response","");
		 dataMap.put("Review","");
		 dataMap.put("Previous","" );
		 dataMap.put("Next","");
  
		 waitForTime(5000); 
		  dashboardclaimsPage.verifyDashBoardLink();
		  
		  waitForTime(5000);
		  auditOutboundPage.verifyauditLink();
		 // waitForTime(5000);
		  auditInboundPage.verifyinboundLink();
		  auditInboundPage.RecognizedFax();
		  auditInboundPage.selectFax();
		  auditInboundPage.selectSupplierfromInboundPageforRecognized();
		  auditInboundPage.selectAction(dataMap);
		  Reporter.log("verification for Data page actions completed");

	 }
	  
	 
	 //Verify of FIX OCR functionality
	 @Test(priority=2)
	public void verifyFIXOCR() throws AWTException{
		  waitForTime(5000);
		  Reporter.log("verification for Fix OCR functionality started");
		  dashboardclaimsPage.verifyDashBoardLink();
		 
		  waitForTime(5000);
		  auditOutboundPage.verifyauditLink();
		  auditInboundPage.verifyinboundLink();
		  waitForTime(2000);

		  auditInboundPage.UnrecognizedFax();
		  auditInboundPage.selectFax();
		  auditInboundPage.selectSupplierfromInboundPageforUnRecognized();
		  auditInboundPage.FixOCRPopUp();		  
		  auditInboundPage.validateFixOCR();  
		  Reporter.log("verification for Fix OCR functionality completed");
	 }
	
	 
	
	 	@Test(priority=3)
		public void verifyCreditEntryForRecognizedFax() throws AWTException, ParseException{
	 		  waitForTime(5000);
	 		  Reporter.log("verification for credit entry functionality started");
	 		
	 		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 	  dataMap.put("SupplierRef", "supp");
		 	  dataMap.put("Customer", "cust");
		 	  dataMap.put("CreditDate", "");
		 	  dataMap.put("Amount", "");
			  dashboardclaimsPage.verifyDashBoardLink();
			 
			  waitForTime(3000);
			  auditOutboundPage.verifyauditLink();
			  waitForTime(5000);
			  auditInboundPage.verifyinboundLink();
			  auditInboundPage.RecognizedFax();
			  auditInboundPage.selectFax();
			  auditInboundPage.selectSupplierfromInboundPageforRecognized();
			  waitForTime(20000);
			  auditInboundPage.EnterCredits(dataMap);
			  auditInboundPage.verifyDiffClaimStatus(dataMap);
			  Reporter.log("verification for credit entry functionality completed");
		 }
	 	
	 	 /* 
	 	
	 	@Test(priority=4)
		public void verifyComments() throws AWTException, ParseException{
	 		  waitForTime(5000);
	 		  Reporter.log("verification for comments entry functionality started");
	 		  
	 	 	  LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 	  dataMap.put("Save", "");
		 	  dataMap.put("Address1", "");
			  dataMap.put("SuppName", "");

		 	  System.out.println(dataMap);
			 dashboardclaimsPage.verifyDashBoardLink();
			 
			  waitForTime(3000);
			  auditOutboundPage.verifyauditLink();
			  waitForTime(5000);
			  auditInboundPage.verifyinboundLink();
			  auditInboundPage.RecognizedFax();
			  auditInboundPage.verifyVerifications();
			  auditInboundPage.selectSupplierfromInboundPageforRecognized();
			  auditInboundPage.selectAction(dataMap);
			  auditInboundPage.verifyComments();
			  Reporter.log("verification for comments entry functionality completed");
		 }*/
  
	 	
  @AfterClass
  public void clean() {
	  quitBrowser();
  }
  
}
