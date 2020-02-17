package lavante.recovery.testsuites;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
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

import junit.framework.Assert;
import lavante.recovery.DataProviders.CreditTableDataProvider;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

public class DashboardClaims_TS16 extends pageInitiator {
	
	 @BeforeClass
	  @Parameters({ "Platform", "Browser", "Version" })
	  public void preCondition(@Optional (LavanteUtils.Platform) String platform , @Optional (LavanteUtils.browser) String browser,@Optional (LavanteUtils.browserVersion) String version) throws Exception  {
		  
		  launchAppThroughPOM(platform,browser,version);

		  initiate();
		  
		  startTest("loginWithValidCredentials");
		  
		  loginPage.enterUserName(readConfigFile("username"));
		  loginPage.enterPassWord(readConfigFile("password"));	
		  waitForTime(5000);

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
	 * Created by : Srikanth Tallury
	 * Date Created : 01/17/2017
	 * Purpose : Verify dashboard claims
	 */
	  @Test
	  public void verifyItemsformyReview() {
			Reporter.log("Verify dashboard claims started");
			 waitForTime(5000);
			 dashboardclaimsPage.verifyClaimsLink();
			 dashboardclaimsPage.verifyNewOpenClaims();
			 dashboardclaimsPage.verifyclaimsINProcess();
			 dashboardclaimsPage.verifyclaimsonHold(); 
			 dashboardclaimsPage.verifyChangedClaims();
			 dashboardclaimsPage.verifyUnpaidInvoices();

			Reporter.log("Verify dashboard claims completed");
	 }
	
	
	 	
	   @AfterClass
	   public void clean() {
			  //auditOutboundPage.LogOut();
			  quitBrowser();
	   }
  
}
