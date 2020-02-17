package lavante.recovery.testsuites.UAT;

import java.awt.AWTException;
import java.io.FileNotFoundException;
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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.DataProviders.CreditTableDataProvider;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

public class Batching_TS07 extends pageInitiator {
	
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
	 	 * Date Created : 16/12/16
	 	 * Creator: Srikanth Tallury
	 	 * Purpose: This test is for verifying only Credits added to Verification doc type Supplier appear under Batching
	 	 * @throws SQLException 
	 	 * @throws IOException 
	 	 * @throws FileNotFoundException 
	 	 * @throws AWTException 
	 	 * @throws ParseException 
	 	 */
	 	@Test
		public void verifyOutboundDocAction() throws FileNotFoundException, IOException, SQLException, AWTException, ParseException{
	 		
	 		Actions act = new Actions(driver);
	 		
	 		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
	 			map.put("SupplierRef", "supp");
	 			map.put("Customer", "cust");
	 			map.put("CreditDate", "");
	 			map.put("Amount", "");
	 			map.put("Submit", "");
	 			map.put("Link", "");
		 	  
			  dashboardclaimsPage.verifyDashBoardLink();
			  waitForTime(10000);
			  auditOutboundPage.verifyauditLink();
			  waitForTime(10000);
			  auditInboundPage.verifyinboundLink();
			  auditInboundPage.navigateToVerifications();
			  auditInboundPage.EnterCredits(map);	
			  switchtoFrame(null);
			//  act.sendKeys(Keys.PAGE_UP).build().perform(); 
	 	}
			  
	 	
  @AfterTest
  public void clean() {
	  auditOutboundPage.LogOut();
	  quitBrowser();
  }
  
}
