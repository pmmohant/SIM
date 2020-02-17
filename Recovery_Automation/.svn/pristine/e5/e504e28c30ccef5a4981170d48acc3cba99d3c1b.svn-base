package com.lavante.recovery.TestScripts.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class AuditPreference extends pageInitiator {
	
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
		
		lavanteUtils.driver=driver;
		loginPage.login();
		
		waitForTime(3000);
		waitForTime(3000);
		homePage.SelectAudit("Safety-Kleen");
		
		homePage.verifyHomePageDisplayed();
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("maintab","configuration");
		homePage.selectTab(dataMap);
        
		}
	/** 
	 * @author Ramya
	 * 
	 * Test to verify Audit Preference Rolling month
	 * 
	 */
	

	@Test(priority=0)
	public void RollingMonthCheck() throws InterruptedException, FileNotFoundException, IOException{
		Reporter.log("Test Started for Audit --> Preference:Rolling Month check " + LavanteUtils.currenttime());
		waitForTime(3000);
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("RollingMonths","8");
		configSetUpPage.fillAuditPreference(dataMap);
		fluentwait(configSetUpPage.saveBtn());
		click(configSetUpPage.saveBtn());
		fluentwait(configSetUpPage.confirmationButton());
		click(configSetUpPage.confirmationButton());
		waitforPageLoad(configSetUpPage.auditTab());
		dataMap.put("maintab","audit");
		dataMap.put("subtab","batchingPage");
        homePage.selectTab(dataMap);
        waitforPageLoad(auditBatchingPage.previewBtn());
        switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
		String expCredit = auditBatchingPage.openCredits().get(0).getText();
		waitforPageLoad(configSetUpPage.auditTab());
		dataMap.put("maintab","audit");
		dataMap.put("subtab","inbound");
        homePage.selectTab(dataMap);
        
        //Clicking on verification link
        waitforPageload(auditInboundPage.verificationsCount());
        auditInboundPage.verificationsCount().click();
        waitforPageLoad(auditInboundPage.recognizedTab());
        waitForTime(3000);
        auditInboundPage.dateLinks().get(0).click();
        dataMap.put("validate", "");
        auditInboundPage.validatePopup(dataMap);
        fluentwait(auditInboundPage.supplierRef());
        
        //Filling credits
        dataMap = new LinkedHashMap<String, String>();
		dataMap.put("SupplierRef" , "test");
		dataMap.put("Customer", "test");
		dataMap.put("CreditDate", "11/02/2016");
		dataMap.put("Amount", "100");
		dataMap.put("Currency", "USD");
		dataMap.put("LocationBU", "BAU");
		dataMap.put("Submit", "");
		dataMap.put("ReqCheck", "");
		dataMap.put("Link", "");
		auditInboundPage.fillCredits(dataMap);
		
		//Clicking on save button and handling popup
        dataMap = new LinkedHashMap<String, String>();
		dataMap.put("Save", "");
        auditInboundPage.dataPageAction(dataMap);
        dataMap.put("validate", "");
        auditInboundPage.validatePopup(dataMap);
        dataMap.put("maintab","audit");
		dataMap.put("subtab","batchingPage");
        homePage.selectTab(dataMap);
        switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
        System.out.println(auditBatchingPage.openCredits().get(0).getText());
        String actCredit = auditBatchingPage.openCredits().get(0).getText();
        softAssert.assertNotEquals(actCredit, expCredit);
        Reporter.log("Test Ended for  Audit --> Preferences: Rolling Month check: " + LavanteUtils.currenttime());
              
        
		}
	@Test(priority=1)
	public void RollingMonthCheck1() throws InterruptedException, FileNotFoundException, IOException{
		Reporter.log("Test Started for Audit --> Preference:Rolling Month check " + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","configuration");
		homePage.selectTab(dataMap);
        waitForTime(3000);
		SoftAssert softAssert = new SoftAssert();
		dataMap.put("RollingMonths","8");
		configSetUpPage.fillAuditPreference(dataMap);
		fluentwait(configSetUpPage.saveBtn());
		click(configSetUpPage.saveBtn());
		fluentwait(configSetUpPage.confirmationButton());
		click(configSetUpPage.confirmationButton());
		waitforPageLoad(configSetUpPage.auditTab());
		dataMap.put("maintab","audit");
		dataMap.put("subtab","batchingPage");
        homePage.selectTab(dataMap);
        waitforPageLoad(auditBatchingPage.previewBtn());
        switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
		String expCredit = auditBatchingPage.openCredits().get(0).getText();
		waitforPageLoad(configSetUpPage.auditTab());
		dataMap.put("maintab","audit");
		dataMap.put("subtab","inbound");
        homePage.selectTab(dataMap);
        
        //Clicking on verification link
        waitforPageload(auditInboundPage.verificationsCount());
        auditInboundPage.verificationsCount().click();
        waitforPageLoad(auditInboundPage.recognizedTab());
        waitForTime(3000);
        auditInboundPage.dateLinks().get(0).click();
        dataMap.put("validate", "");
        auditInboundPage.validatePopup(dataMap);
        fluentwait(auditInboundPage.supplierRef());
        
        //Filling credits
        dataMap = new LinkedHashMap<String, String>();
		dataMap.put("SupplierRef" , "test");
		dataMap.put("Customer", "test");
		dataMap.put("CreditDate", "11/02/2016");
		dataMap.put("Amount", "100");
		dataMap.put("Currency", "USD");
		dataMap.put("LocationBU", "BAU");
		dataMap.put("Submit", "");
		dataMap.put("ReqCheck", "");
		dataMap.put("Link", "");
		auditInboundPage.fillCredits(dataMap);
		
		//Clicking on save button and handling popup
        dataMap = new LinkedHashMap<String, String>();
		dataMap.put("Save", "");
        auditInboundPage.dataPageAction(dataMap);
        dataMap.put("validate", "");
        auditInboundPage.validatePopup(dataMap);
        dataMap.put("maintab","audit");
		dataMap.put("subtab","batchingPage");
        homePage.selectTab(dataMap);
        switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
        System.out.println(auditBatchingPage.openCredits().get(0).getText());
        String actCredit = auditBatchingPage.openCredits().get(0).getText();
        softAssert.assertEquals(actCredit, expCredit);
        Reporter.log("Test Ended for  Audit --> Preferences: Rolling Month check: " + LavanteUtils.currenttime());
              
        
		}
	

}