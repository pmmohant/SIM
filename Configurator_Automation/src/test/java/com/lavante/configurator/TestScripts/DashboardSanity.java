package com.lavante.configurator.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.configurator.Common.Util.LavanteUtils;
import com.lavante.configurator.pageobjects.pageInitiator;

/**
 * @author chaitra.s
 *
 */
public class DashboardSanity extends pageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils(); 
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();

		waitForTime(3000);

	}

	/**
	 * 
	 * DashboardPageTest  will verify all the element in the Dashboard page
	 * 
	 * @author Chaitra.S
	 * @throws Exception
	 */
	@Test
	public void DashboardPageTest() throws Exception{
		
		Reporter.log("Test Started at:"+currenttime());
		
		SoftAssert softAssert =new SoftAssert();
	
		fluentwait(sanityTest.LavanteLogo());
		
		boolean flag=isElementDisplayed(sanityTest.LavanteLogo());
		Reporter.log("Lavante Logo  Verification:"+flag,true);
		softAssert.assertTrue(flag,"Lavante Logo Not Displayed");
		
		flag=isElementDisplayed(sanityTest.Lastlogin());
		Reporter.log("Last Login Verification:"+flag,true);
		softAssert.assertTrue(flag,"Last Login Not Displayed");
		
		flag=isElementDisplayed(sanityTest.LavanteLogo());
		Reporter.log("Lavante Logo  Verification:"+flag,true);
		softAssert.assertTrue(flag,"Lavante Logo Not Displayed");
		
		flag=isElementDisplayed(sanityTest.Logout());
		Reporter.log("Logout  Verification:"+flag,true);
		softAssert.assertTrue(flag," Logout Not Displayed");
		

	/*	flag=isElementDisplayed(sanityTest.Buyerpagination());
		Reporter.log("Buyer list Pagination  Verification:"+flag);
		softAssert.assertTrue(flag," Buyer list Pagination is Not Displayed");
	*/
		
		fluentwait(sanityTest.Buyernametableheader());
		
		flag=isElementDisplayed(sanityTest.Buyernametableheader());
		Reporter.log("Buyer Name Table Header Verification:"+flag,true);
		softAssert.assertTrue(flag," Buyer Name Table Header is Not Displayed");
		
		
		flag=isElementDisplayed(sanityTest.IRSidentifierheader());
		Reporter.log("IRS Identifier Table Header Verification:"+flag,true);
		softAssert.assertTrue(flag,"IRS Identifier Table Header is Not Displayed");

		flag=isElementDisplayed(sanityTest.Logoheader());
		Reporter.log("Logo Table Header Verification:"+flag,true);
		softAssert.assertTrue(flag,"Logo Table Header is Not Displayed");
		
		flag=isElementDisplayed(sanityTest.Actionheader());
		Reporter.log("Action Table Header Verification:"+flag,true);
		softAssert.assertTrue(flag,"Action Table Header is Not Displayed");
		
		flag=isElementDisplayed(sanityTest.Filterbuyer());
		Reporter.log("Buyer filter Verification:"+flag,true);
		softAssert.assertTrue(flag,"Buyer filter is Not Displayed");
		
		flag=isElementDisplayed(sanityTest.Filterirsidentifier());
		Reporter.log("IRS Identifier filter Verification:"+flag,true);
		softAssert.assertTrue(flag,"IRS Identifier filter is Not Displayed");
		
		
		flag=isElementDisplayed(sanityTest.Editbuyerbutton());
		Reporter.log("Edit Buyer Button Verification:"+flag,true);
		softAssert.assertTrue(flag,"Edit Buyer Button is Not Displayed");
		
		flag=isElementDisplayed(sanityTest.footer_Copyright());
		Reporter.log("Copyright Footer Verification:"+flag,true);
		softAssert.assertTrue(flag,"Copyright Footer is Not Displayed");
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended:"+currenttime());
}
	
	
	
	/**
	 * After Class Logout and Quit Method 
	 * 
	 * @author Piramanayagam.S
	 */
	
	@AfterClass
	  public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	  }
	
	
}
