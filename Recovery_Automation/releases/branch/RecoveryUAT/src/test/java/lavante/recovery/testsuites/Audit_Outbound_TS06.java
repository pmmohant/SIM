package lavante.recovery.testsuites;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.DataProviders.CreditTableDataProvider;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

public class Audit_Outbound_TS06 extends pageInitiator {
	
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
	 	 * Date Created : 14/12/16
	 	 * Creator: Srikanth Tallury
	 	 * Purpose: This test is for verifying VRL count match and drilling from Current Month to Outbound data page
	 	 * @throws SQLException 
	 	 * @throws IOException 
	 	 * @throws FileNotFoundException 
	 	 */
	 	@Test
		public void verifyOutboundDocAction() throws FileNotFoundException, IOException, SQLException{
			  dashboardclaimsPage.verifyDashBoardLink();
			  waitForTime(5000);
			  auditPage.verifyconfigurationLink();
			  waitForTime(5000);
			  String fetchVRLCredits = auditPage.fetchVRLCredits();
			  System.out.println(fetchVRLCredits);
			  Reporter.log("VRL Credits count in application is :" + fetchVRLCredits);

			  String auditID = "select ID from as_audits where Name = 'DPSG'";
			  String resultsetAuditID = String.valueOf(fetchDBdata(auditID));
			  
			  
			  String query = "select VerificationRequestLetter_NumberOfCredits from LC_AuditConfiguration where AuditID =" + resultsetAuditID;
			  String resultset = String.valueOf(fetchDBdata(query));
			  System.out.println(resultset);
			  
			  Reporter.log("VRL Credits count in DB is :" + resultset);
			  
			  if(resultset.equalsIgnoreCase(fetchVRLCredits)){
				  System.out.println("VRL Credits Count matched in Outbound Doc action");
				  Reporter.log("VRL Credits Count matched in Outbound Doc action");
			  }
			  else{
				  System.out.println("VRL Credits Count NOT matched in Outbound Doc action");
				  Reporter.log("VRL Credits Count NOT matched in Outbound Doc action");
				  Assert.assertTrue(false, "VRL Credits Count not matched");
			  }
			  
			  auditOutboundPage.verifyauditLink();
			  waitForTime(5000);
			  
			  //Drill down to outbound data page and check verification letter pop up shows up
			  auditOutboundPage.verifyCreditsinOutboundAction();
			  
				  
	 	}
			  
	 	
  @AfterClass
  public void clean() {
	 // auditOutboundPage.LogOut();
	  quitBrowser();
  }
  
}
