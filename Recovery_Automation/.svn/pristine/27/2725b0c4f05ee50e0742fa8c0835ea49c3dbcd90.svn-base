package com.lavante.recovery.TestScripts.Configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class Config_SetUp_Preferences extends pageInitiator {
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
		@Optional(LavanteUtils.browser) String browser,
		@Optional(LavanteUtils.browserVersion) String version) throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();

		waitForTime(3000);
		homePage.verifyHomePageDisplayed();
		
		waitForTime(3000);
		homePage.SelectAudit("Giant Eagle");
		
	}

	/**
	 * Before Method to navigate to the Configuration Tab->Set Up ->Preferences
	 * @author girish.n
	 */
	@BeforeMethod
	public void configSetUpPrefBefMethod(){
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("maintab","configuration");
        dataMap.put("subtab","configurationSetup");
        homePage.selectTab(dataMap);
	}
	
	/**
	 * Test Method to verify whether the Lavante user is able to configure batch by currency and create a batch by currency from the Batching page.
	 * Pre-Requisite:  
	 * Unbatched credits should be available for the batching.
	 * 
	 * @author girish.n
	 */
	@Test
	public void configBatchByCurrencyTest(){
		Reporter.log("Test Start Time:"+randomnum(),true);
		
		fluentwait(configSetUpPage.preferencesTab());
		click(configSetUpPage.preferencesTab());
		
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		
		//To get the open credit details
		dataMap.put("Save", "");
		configSetUpPage.configBatchPreference(dataMap);
		dataMap.put("maintab","audit");
        dataMap.put("subtab","batchingPage");
        homePage.selectTab(dataMap);
        waitforPageload(auditBatchingPage.cancelBatchBtn());
        switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
        if(auditBatchingPage.openCredits().size()>0){
        	switchtoFrame(null);        	
        	fluentwait(auditBatchingPage.previewBtn());
        	click(auditBatchingPage.previewBtn());
        	waitforPageload(auditBatchingPage.cancelBatchBtn());
        	
        	switchtoFrame(auditBatchingPage.IFRAMEBatchSummary());
        	int noOfClaimsBatSum=Integer.parseInt(auditBatchingPage.numberofClaims().getText().trim());
        	
        	switchtoFrame(auditBatchingPage.IFRAMEauditBatchingDetails());
        	int noOfClaimsBatDet=auditBatchingPage.lineItem().size();
        	
        	HashSet<String> currTypesSet = new HashSet<String>();
        	for(int i=0;i<auditBatchingPage.currency().size();i++){
        		String data=auditBatchingPage.currency().get(i).getText().trim();
        		currTypesSet.add(data);
        	}
        	HashSet<String> buSet = new HashSet<String>();
        	for(int i=0;i<auditBatchingPage.location().size();i++){
        		String data=auditBatchingPage.location().get(i).getText().trim();
        		buSet.add(data);
        	}
        	
        	Reporter.log("Currency Types:"+currTypesSet,true);
        	Reporter.log("BU(Location):"+buSet,true);
        	
        	//To configure Batch By Currency
        	switchtoFrame(null);
    		dataMap.put("maintab","configuration");
            dataMap.put("subtab","configurationSetup");
            homePage.selectTab(dataMap);
            fluentwait(configSetUpPage.preferencesTab());
    		click(configSetUpPage.preferencesTab());
    		
        	dataMap.put("BatchByCurrency", "");
    		dataMap.put("Save", "");
    		
    		configSetUpPage.configBatchPreference(dataMap);
    		
    		//To create Batch and validate its type (which should be Batch By Currency)
    		dataMap.put("maintab","audit");
            dataMap.put("subtab","batchingPage");
            homePage.selectTab(dataMap);
            waitforPageload(auditBatchingPage.cancelBatchBtn());
            
            fluentwait(auditBatchingPage.previewBtn());
        	click(auditBatchingPage.previewBtn());
        	waitforPageload(auditBatchingPage.cancelBatchBtn());
        	
        	/**
        	 * Validating Batch details: No. of Batches, Batch Types, No. of Claims
        	 */
        	switchtoFrame(auditBatchingPage.IFRAMEBatchSummary());
        	
        	softAssert.assertEquals(auditBatchingPage.batchTypeList().size(), currTypesSet.size());
        	Reporter.log("Expected No. of Batches:"+currTypesSet.size()+"::Actual No. of Batches:"+auditBatchingPage.batchTypeList().size(),true);
        	
        	for(int i=0;i<auditBatchingPage.batchTypeList().size();i++){
        		String batchType = auditBatchingPage.batchTypeList().get(i).getText().trim();
        		Reporter.log("BatchType:"+batchType,true);
        		batchType=batchType.replace("All-", "");
        		if(currTypesSet.contains(batchType))
        			softAssert.assertTrue(true);
        		else
        			softAssert.assertTrue(false);
        	}
        	
        	int actNoOfClaims=0;
        	for(int i=0;i<auditBatchingPage.noOfClaimsList().size();i++){
        		String data=auditBatchingPage.noOfClaimsList().get(i).getText().trim();
        		actNoOfClaims=actNoOfClaims+Integer.parseInt(data);
        	}
        	softAssert.assertEquals(actNoOfClaims, noOfClaimsBatSum);
        	Reporter.log("Total No. of Claims - Expected:"+noOfClaimsBatSum+"::Total No. of Claims - Actual:"+actNoOfClaims,true);
        	flag=true;
        	
        	switchtoFrame(null);
        }
        else{
        	Reporter.log("There is no unbatched credits available for batching. Please add credits or change the audit",true);
        }
        
		softAssert.assertTrue(flag);
		Reporter.log("Test End Time:"+randomnum(),true);
		softAssert.assertAll();
	}


	/**
	 * Test Method to verify whether the Lavante user is able to configure batch by BU and create a batch by BU from the Batching page.
	 * Pre-Requisite:  
	 * Unbatched credits should be available for the batching.
	 * 
	 * @author girish.n
	 */
	@Test
	public void configBatchByBUTest(){
		Reporter.log("Test Start Time:"+randomnum(),true);
		
		fluentwait(configSetUpPage.preferencesTab());
		click(configSetUpPage.preferencesTab());
		
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		
		//To get the open credit details
		dataMap.put("Save", "");
		configSetUpPage.configBatchPreference(dataMap);
		dataMap.put("maintab","audit");
        dataMap.put("subtab","batchingPage");
        homePage.selectTab(dataMap);
        waitforPageload(auditBatchingPage.cancelBatchBtn());
        switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
        if(auditBatchingPage.openCredits().size()>0){
        	switchtoFrame(null);        	
        	fluentwait(auditBatchingPage.previewBtn());
        	click(auditBatchingPage.previewBtn());
        	waitforPageload(auditBatchingPage.cancelBatchBtn());
        	
        	switchtoFrame(auditBatchingPage.IFRAMEBatchSummary());
        	int noOfClaimsBatSum=Integer.parseInt(auditBatchingPage.numberofClaims().getText().trim());
        	
        	switchtoFrame(auditBatchingPage.IFRAMEauditBatchingDetails());
        	int noOfClaimsBatDet=auditBatchingPage.lineItem().size();
        	
        	HashSet<String> currTypesSet = new HashSet<String>();
        	for(int i=0;i<auditBatchingPage.currency().size();i++){
        		String data=auditBatchingPage.currency().get(i).getText().trim();
        		currTypesSet.add(data);
        	}
        	HashSet<String> buSet = new HashSet<String>();
        	for(int i=0;i<auditBatchingPage.location().size();i++){
        		String data=auditBatchingPage.location().get(i).getText().trim();
        		buSet.add(data);
        	}
        	
        	Reporter.log("Currency Types:"+currTypesSet,true);
        	Reporter.log("BU(Location):"+buSet,true);
        	
        	//To configure Batch By Currency
        	switchtoFrame(null);
    		dataMap.put("maintab","configuration");
            dataMap.put("subtab","configurationSetup");
            homePage.selectTab(dataMap);
            fluentwait(configSetUpPage.preferencesTab());
    		click(configSetUpPage.preferencesTab());
    		
        	dataMap.put("BatchByBU", "");
    		dataMap.put("Save", "");
    		
    		configSetUpPage.configBatchPreference(dataMap);
    		
    		//To create Batch and validate its type (which should be Batch By Currency)
    		dataMap.put("maintab","audit");
            dataMap.put("subtab","batchingPage");
            homePage.selectTab(dataMap);
            waitforPageload(auditBatchingPage.cancelBatchBtn());
            
            fluentwait(auditBatchingPage.previewBtn());
        	click(auditBatchingPage.previewBtn());
        	waitforPageload(auditBatchingPage.cancelBatchBtn());
        	
        	/**
        	 * Validating Batch details: No. of Batches, Batch Types, No. of Claims
        	 */
        	switchtoFrame(auditBatchingPage.IFRAMEBatchSummary());
        	
        	softAssert.assertEquals(auditBatchingPage.batchTypeList().size(), buSet.size());
        	Reporter.log("Expected No. of Batches:"+buSet.size()+"::Actual No. of Batches:"+auditBatchingPage.batchTypeList().size(),true);
        	
        	for(int i=0;i<auditBatchingPage.batchTypeList().size();i++){
        		String batchType = auditBatchingPage.batchTypeList().get(i).getText().trim();
        		Reporter.log("BatchType:"+batchType,true);
        		if(buSet.contains(batchType))
        			softAssert.assertTrue(true);
        		else
        			softAssert.assertTrue(false);
        	}
        	
        	int actNoOfClaims=0;
        	for(int i=0;i<auditBatchingPage.noOfClaimsList().size();i++){
        		String data=auditBatchingPage.noOfClaimsList().get(i).getText().trim();
        		actNoOfClaims=actNoOfClaims+Integer.parseInt(data);
        	}
        	softAssert.assertEquals(actNoOfClaims, noOfClaimsBatSum);
        	Reporter.log("Total No. of Claims - Expected:"+noOfClaimsBatSum+"::Total No. of Claims - Actual:"+actNoOfClaims,true);
        	flag=true;
        	
        	switchtoFrame(null);
        }
        else{
        	Reporter.log("There is no unbatched credits available for batching. Please add credits or change the audit",true);
        }
        
		softAssert.assertTrue(flag);
		Reporter.log("Test End Time:"+randomnum(),true);
		softAssert.assertAll();
	}

	
	
	/**
	 * After Method to navigate back to the home page(Dashboard).
	 * @author girish.n
	 */
	@AfterMethod
	public void configSetUpPrefAftMethod(){
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("maintab","dashboard");
        homePage.selectTab(dataMap);
        homePage.verifyHomePageDisplayed();
	}

	
	@AfterClass
	public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	}

}
