package lavante.recovery.testsuites;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.http.impl.execchain.MainClientExec;
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
import lavante.recovery.pageobjects.MainClaimsPage;
import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

public class Claims_TS17 extends pageInitiator {
	
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
		//  verifyBrowserStartPopUp();
		  
		  waitForTime(3000);

		  genericPageObjects.verifyAuditSelectBox();
		  genericPageObjects.verifyAuditSelectBoxTextBox();
		  	 
		//  endTest("loginWithValidCredentials");	 
	  }


	 /**
	 * Created by : Srikanth Tallury
	 * Date Created : 01/19/2017
	 * Purpose : Verify Claims tool tip functionality
	 */
	  @Test
	  public void verifyClaimsPageFunctionality() {
			
		  Reporter.log("Verify claims page started");
			
				String expClaimsPageTooltip = readConfigFile("MainClaimsToolTip");
				
				waitForTime(5000);
				String actClaimsPageTooltip = verifyTooltip(mainClaimsPage.verifyclaimsLink());
				System.out.println(actClaimsPageTooltip+expClaimsPageTooltip);
				Assert.assertEquals(expClaimsPageTooltip, actClaimsPageTooltip);
			 
			 	click(mainClaimsPage.claimsLink());
			 	fluentwait(mainClaimsPage.claimListClaimID());
			 	String claimListINClaimID = getText("claimListClaimID", mainClaimsPage.claimListClaimID());
				String claimListINSuppRefence = getText("claimListSuppRefence", mainClaimsPage.claimListSuppRefence);
				String claimListINAmt = getText("claimListAmt", mainClaimsPage.claimListAmt);
				
				click(mainClaimsPage.doIconClaimsList());
				fluentwait(mainClaimsPage.docIconClaimID);
				String docIconINClaimID = getText("docIconClaimID", mainClaimsPage.docIconClaimID);
				String docIconINReference = getText("docIconReference", mainClaimsPage.docIconReference);
				String docIconINAmt = getText("docIconAmt", mainClaimsPage.docIconAmt);
				
				Assert.assertEquals(claimListINClaimID, docIconINClaimID);
				Assert.assertEquals(claimListINSuppRefence, docIconINReference);
				Assert.assertEquals(claimListINAmt, docIconINAmt);

			Reporter.log("Verify claims page completed");
	 }
	  
	/**
	* Created by : Srikanth Tallury
	* Date Created : 01/19/2017
	* Purpose : Verify edit claims functionality
	*/
	@Test
	public void verifyEditClaimsPageFunctionality() {
		String expClaimsPageTooltip = readConfigFile("MainClaimsToolTip");
		
		 waitForTime(5000);
		 String actClaimsPageTooltip = verifyTooltip(mainClaimsPage.verifyclaimsLink());
		 Assert.assertEquals(expClaimsPageTooltip, actClaimsPageTooltip);
			Reporter.log("Verify edit claims functionality started");
			 click(mainClaimsPage.claimsLink());
			 fluentwait(mainClaimsPage.claimListClaimID());
				String claimListINClaimID = getText("claimListClaimID", mainClaimsPage.claimListClaimID());
				String claimListINStatus = getText("claimListStatus", mainClaimsPage.claimListStatus);
				String claimListINAmt = getText("claimListAmt", mainClaimsPage.claimListAmt);
				String claimListINSuppRefence = getText("claimListSuppRefence", mainClaimsPage.claimListSuppRefence);

				click(mainClaimsPage.editClaimsIcon);
				waitForTime(5000);
				fluentwait(mainClaimsPage.editClaimsClaimID);
				String editClaimsINClaimID = getText("editClaimsClaimID", mainClaimsPage.editClaimsClaimID);
				String editClaimsINClaimStatus = getText("editClaimsClaimStatus", mainClaimsPage.editClaimsClaimStatus);
				String editClaimsINClaimAmt = getText("editClaimsClaimAmt", mainClaimsPage.editClaimsClaimAmt);
				String editClaimsINSuppRef = getText("editClaimsSuppRef", mainClaimsPage.editClaimsSuppRef);
				
			//	Assert.assertEquals(claimListINClaimID, editClaimsINClaimID);
				Assert.assertEquals(claimListINStatus, editClaimsINClaimStatus);
				Assert.assertEquals(claimListINAmt, editClaimsINClaimAmt);
				Assert.assertEquals(claimListINSuppRefence, editClaimsINSuppRef);
				
				mainClaimsPage.verifyClaimDetailsinEditClaimsPageClaimsQueue();
			Reporter.log("Verify edit claims functionality completed");
		 }
	  

	@AfterClass
	public void clean() {
			  quitBrowser();
	   }
  
}
