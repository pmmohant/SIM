package com.lavante.recovery.TestScripts.UAT;


import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class DashboardCompliance extends pageInitiator {
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
	}
	
	/**
	 * 
	 * The below method is for performing the actions on Compliant and on NonCompliant tab.
	 * @author nagappa.vaddebail
	 * 
	 */
	
	@Test
	public void complianceTabActions(){		
		Reporter.log("Test Started for Dashboard - Compliant page actions:" + LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMapTab = new LinkedHashMap<String, String>();
		dataMapTab.put("maintab","dashboard");
		dataMapTab.put("subtab","complianceDashboard");		
		homePage.selectTab(dataMapTab);
		dashCompliancePage.clickComplaintTab();			
	
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("SuppName", "ANY");
		LinkedHashMap<String, String> dataMap1 = dashCompliancePage.selectCompliantSupplier(dataMap);
		String expSuppName= dataMap1.get("SuppName");
		String expSpendRank= dataMap1.get("SpendRank");
		
		// Validating the Supplier name and spend rank with data present in Supplier Details page
		Reporter.log("Supplier Name Actual: " + supplierPage.supplierName().getText() +", Excpected: "+  expSuppName,true);
		softAssert.assertEquals(expSuppName,supplierPage.supplierName().getText(), "Supplier Name Actual: " + supplierPage.supplierName().getText() +", Excpected: "+  expSuppName);
		Reporter.log("Spend Rank Actual: " + supplierPage.spendRank().getText() +", Excpected: "+  expSpendRank, true);
		softAssert.assertEquals(expSpendRank,supplierPage.spendRank().getText(), "Spend Rank Actual: " + supplierPage.spendRank().getText() +", Excpected: "+  expSpendRank);
		
		//Non-compliance tab actions
		Reporter.log("Test Started for Dashboard - Non-Compliant page actions:" + LavanteUtils.currenttime());
		homePage.selectTab(dataMapTab);
		dashCompliancePage.clickNonComplaintTab();
		
		LinkedHashMap<String, String> dataMap4 = new LinkedHashMap<String, String>();
		dataMap4.put("SuppName", "ANY");
		dataMap4 = dashCompliancePage.selectNonCompliantSupplier(dataMap4);
		String expSuppName1=dataMap4.get("SuppName");
		String expSpendRank1= dataMap4.get("SpendRank");
		
		// Validating the Supplier name and spend rank with data present in Supplier Details page
		Reporter.log("Supplier Name Actual: " + supplierPage.supplierName().getText()  +", Excpected: "+  expSuppName1,true);
		softAssert.assertEquals(expSuppName1,supplierPage.supplierName().getText() , "Supplier Name Actual: " + supplierPage.supplierName().getText()  +", Excpected: "+  expSuppName1);
		Reporter.log("Spend Rank Actual: " + supplierPage.spendRank().getText() +", Excpected: "+  expSpendRank1, true);
		softAssert.assertEquals(expSpendRank1,supplierPage.spendRank().getText(), "Spend Rank Actual: " + supplierPage.spendRank().getText() +", Excpected: "+  expSpendRank1);
		
		softAssert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());	
	 }
	
	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }
}
