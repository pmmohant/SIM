package lavante.recovery.testsuites.UAT;

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

import lavante.recovery.DataProviders.CreditTableDataProvider;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

/**
 * @author tallury.srikanth
 *
 */
/**
 * @author tallury.srikanth
 *
 */
public class MailerReg_TS24 extends pageInitiator {
	
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
		  
		/*  genericPageObjects.verifyAuditSelectBox();
		  genericPageObjects.verifyAuditSelectBoxTextBox();*/
		  	 
		  endTest("loginWithValidCredentials");	 
	  }

    /* Purpose: This is for verifying mailer registry functionality
     * Date: 21-Feb-2017
     * Author: Srikanth Tallury
    */ 
	 @Test
	  public void verifyMailerRegistry() throws AWTException, IOException, SQLException{
		 LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		 Reporter.log("Verifiation of mailer registry functionality started");
		  map.put("LAVQTY", "");
		  map.put("PMPQTY", "");
		  map.put("Tax", "");
		  map.put("Total", "");
		  map.put("USPSTotal", "");

		  dashboardclaimsPage.verifyDashBoardLink();
		  waitForTime(5000);
		  auditPage.verifyconfigurationLink();
		  waitForTime(3000);
		  mailerRegistryPage.verifyMailerRegistryLink();
		  mailerRegistryPage.verifyaddNewBtn();
		  mailerRegistryPage.verifyNewMailerRegFunctionality(map);
		Reporter.log("Verifiation of mailer registry functionality completed");
	 }
	
	
	 	
	   @AfterClass
	   public void clean() {
			 quitBrowser();
	   }
  
}
