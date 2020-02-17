package lavante.recovery.testsuites.UAT;

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

public class DataPage_Dlink_TS12 extends pageInitiator {
	
	 @BeforeClass
	  @Parameters({ "Platform", "Browser", "Version" })
	  public void preCondition(@Optional (LavanteUtils.Platform) String platform , @Optional (LavanteUtils.browser) String browser,@Optional (LavanteUtils.browserVersion) String version) throws Exception  {
		  
		  launchAppThroughPOM(platform,browser,version);

		  initiate();
		  
		  startTest("loginWithValidCredentials");
		  
		  loginPage.enterUserName(readConfigFile("username"));
		  loginPage.enterPassWord(readConfigFile("password"));	
		  //waitForTime(5000);

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
	 	 * Date Created : 01/02/17
	 	 * Creator: Srikanth Tallury
	 	 * Purpose: This test is for verifying D-Link functionality
	 	 * @throws AWTException
	 	 * @throws ParseException
	 	 */
	 	@Test()
		public void DLinkFunctionality() throws AWTException, ParseException{

	 		Reporter.log("Verification of D-Link functionality started");
			  dashboardclaimsPage.verifyDashBoardLink();
			 
			  waitForTime(5000);
			  auditOutboundPage.verifyauditLink();
			  waitForTime(5000);
			  auditOutboundPage.navigateDatapage();
			  auditOutboundPage.verifyRelatedSuppler();
			  
			 
			Reporter.log("Verification of D-Link functionality Ended");
		 }
	 	
  @AfterClass
  public void clean() {
	  //auditOutboundPage.LogOut();
	  quitBrowser();
  }
  
}
