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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.DataProviders.CreditTableDataProvider;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

public class ContactEntry_TS02 extends pageInitiator {
	
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

     //verification for Needs Review and Save and Dispose functionality
	 @Test
	  public void ContactEntryPageActions() throws AWTException{
		 
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 dataMap.put("Save", "");
		 dataMap.put("Save & Dispose","" );
		 dataMap.put("Reset","");
		 dataMap.put("Review","");
		 dataMap.put("Previous","" );
		 dataMap.put("Next","");
		 dataMap.put("ContactName","");
		 dataMap.put("ContactPhone","");
		 dataMap.put("Email","");
		 dataMap.put("ContactFax","");
		  
		 waitForTime(5000); 
		  dashboardclaimsPage.verifyDashBoardLink();
		  
		  waitForTime(5000);
		  auditOutboundPage.verifyauditLink();
		  waitForTime(5000);
		  auditContactEntryPage.verifycontactEntry();
		  waitForTime(5000);
		  auditContactEntryPage.fixOCRsuppName();
		  auditContactEntryPage.suppLookUpbtn();
		  auditInboundPage.SuppLookUpAfterLoad();
		  auditInboundPage.selectSuppFromSuppList();
		  auditInboundPage.SelectBtninIFRAME();
		  switchtoFrame(null);
		  auditContactEntryPage.contactEntryFixOCRBtn();
		  waitForTime(5000);
		  auditContactEntryPage.verifySuppNameUpdated();
		  auditContactEntryPage.updateContactDetails(dataMap);
		//auditInboundPage.selectAction(dataMap);

	 }
	
	
	 	
  @AfterTest
  public void clean() {
	  quitBrowser();
  }
  
}
