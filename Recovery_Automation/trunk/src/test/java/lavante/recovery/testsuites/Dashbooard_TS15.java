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

public class Dashbooard_TS15 extends pageInitiator {
	
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
	 * Date Created : 01/04/2017
	 * Purpose : Verify tool tip for all the menus
	 */
	  @Test
	  public void verifyToolTip() throws AWTException, IOException, SQLException{
			Reporter.log("Verification of tool tip started");
			 waitForTime(5000);
			String actdashboardPageTooltip = verifyTooltip(dashboardclaimsPage.verifyDashBoardLink());
			String actdashClaimsPageTooltip = verifyTooltip(dashboardclaimsPage.verifyClaimsLink());
			String actdashSupplierPageTooltip = verifyTooltip(dashboardsupplierPage.verifySupplierLink());
			String actdashCompliancePageTooltip = verifyTooltip(compliancePage.verifycomplainceLink());
			
			String expdashoardPageTooltip = readConfigFile("DashboardToolTip");
			String expdashClaimsPageTooltip = readConfigFile("ClaimsToolTip");
			String expdashSupplierPageTooltip = readConfigFile("SuppliersToolTip");
			String expdashCompliancePageTooltip = readConfigFile("ComplianceToolTip");
			
			Assert.assertEquals(expdashoardPageTooltip, actdashboardPageTooltip);
			Assert.assertEquals(expdashClaimsPageTooltip, actdashClaimsPageTooltip);
			Assert.assertEquals(expdashSupplierPageTooltip, actdashSupplierPageTooltip);
			Assert.assertEquals(expdashCompliancePageTooltip, actdashCompliancePageTooltip);
			
			Reporter.log("Verification of tool tip completed");
	 }
	
	
	 	
	   @AfterClass
	   public void clean() {
			  //auditOutboundPage.LogOut();
			  quitBrowser();
	   }
  
}
