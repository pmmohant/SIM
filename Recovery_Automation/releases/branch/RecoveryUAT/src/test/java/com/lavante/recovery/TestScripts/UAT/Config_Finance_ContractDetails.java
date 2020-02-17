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

public class Config_Finance_ContractDetails extends pageInitiator {

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
		waitForTime(2000);
		homePage.SelectAudit(InitProperties("DefaultAudit").trim());
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("maintab","configuration");
        dataMap.put("subtab","financeConfiguration");
        homePage.selectTab(dataMap);
        fluentwait(configFinancePage.contractDetailsTab());
        click(configFinancePage.contractDetailsTab());
	
	}
			
	/**
	 * Method to add and Edit Contract Details. Method validates the contract details after add and edit. 
	 * @author girish.n
	 */
	@Test
	public void addEditContractDetails(){
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		boolean flag=false;
		
		//Add Contract Details
		String expAuditName="AuditName"+currenttime();
		String expTerm="6";
		String expRnwlType="EverGreen";
		String expRnwlLength="5";
		String expRate="500";
		String expNotes="AddContractDetails";
		dataMap.put("AuditName", expAuditName);
		dataMap.put("Term", expTerm);
		dataMap.put("RenewalType", expRnwlType);
		dataMap.put("RenewalLength", expRnwlLength);
		dataMap.put("Rate", expRate);
		dataMap.put("Notes", expNotes);
		dataMap.put("SaveContractDetails", "");
		configFinancePage.addContractDetails(dataMap);
		
		//Search Contract Detail
		dataMap.put("SearchType","Audit Name");
		dataMap.put("SearchValue",expAuditName);
		configFinancePage.searchContractDetails(dataMap);
		
		//Validation
		SoftAssert softAssert=new SoftAssert();
	
		for(int i=0;i<configFinancePage.auditNameList().size();i++){
			String actAuditName=configFinancePage.auditNameList().get(i).getText().trim();
			if(actAuditName.equalsIgnoreCase(expAuditName)){
				String actTerm=configFinancePage.termList().get(i).getText().trim();
				String actRnwlType=configFinancePage.rnwlTypeList().get(i).getText().trim();
				String actRnwlLength=configFinancePage.rnwlLengthList().get(i).getText().trim();
				String actRate=configFinancePage.rateList().get(i).getText().trim();
				String actNotes=configFinancePage.notesList().get(i).getText().trim();
				
				softAssert.assertEquals(actAuditName, expAuditName);
				Reporter.log("Expected Audi Name:"+expAuditName+"::Actual Audit Name:"+actAuditName,true);
				
				softAssert.assertEquals(actTerm, expTerm);
				Reporter.log("Expected Term:"+expTerm+"::Actual Term:"+actTerm,true);
				
				softAssert.assertEquals(actRnwlType, expRnwlType);
				Reporter.log("Expected Renewal Type:"+expRnwlType+"::Actual Renewal Type:"+actRnwlType,true);
				
				softAssert.assertEquals(actRnwlLength, expRnwlLength);
				Reporter.log("Expected Renewal Length:"+expRnwlLength+"::Actual Renewal Length:"+actRnwlLength,true);
				
				softAssert.assertEquals(actRate, expRate);
				Reporter.log("Expected Rate:"+expRate+"::Actual Rate:"+actRate,true);
				
				softAssert.assertEquals(actNotes, expNotes);
				Reporter.log("Expected Notes:"+expNotes+"::Actual Notes:"+actNotes,true);
				
				//Editing the Contract Details
				expAuditName="EditName"+currenttime();
				expTerm="10";
				expRnwlType="Auto";
				expRnwlLength="2";
				expRate="1000";
				expNotes="EditContractDetails";
				dataMap.put("AuditName", expAuditName);
				dataMap.put("Term", expTerm);
				dataMap.put("RenewalType", expRnwlType);
				dataMap.put("RenewalLength", expRnwlLength);
				dataMap.put("Rate", expRate);
				dataMap.put("Notes", expNotes);
				dataMap.put("SaveContractDetails", "");
				
				fluentwait(configFinancePage.editLinksList().get(i));
				click(configFinancePage.editLinksList().get(i));
				
				configFinancePage.fillContractDetails(dataMap);
				configFinancePage.formContractDetails(dataMap);
				
				//Search Contract Details
				dataMap.put("SearchType","Audit Name");
				dataMap.put("SearchValue",expAuditName);
				configFinancePage.searchContractDetails(dataMap);
				
				for(int j=0;j<configFinancePage.auditNameList().size();j++){
					actAuditName=configFinancePage.auditNameList().get(j).getText().trim();
					
					if(actAuditName.equalsIgnoreCase(expAuditName)){
						actTerm=configFinancePage.termList().get(j).getText().trim();
						actRnwlType=configFinancePage.rnwlTypeList().get(j).getText().trim();
						actRnwlLength=configFinancePage.rnwlLengthList().get(j).getText().trim();
						actRate=configFinancePage.rateList().get(j).getText().trim();
						actNotes=configFinancePage.notesList().get(j).getText().trim();
						
						softAssert.assertEquals(actAuditName, expAuditName);
						Reporter.log("Expected Audi Name:"+expAuditName+"::Actual Audit Name:"+actAuditName,true);
						
						softAssert.assertEquals(actTerm, expTerm);
						Reporter.log("Expected Term:"+expTerm+"::Actual Term:"+actTerm,true);
						
						softAssert.assertEquals(actRnwlType, expRnwlType);
						Reporter.log("Expected Renewal Type:"+expRnwlType+"::Actual Renewal Type:"+actRnwlType,true);
						
						softAssert.assertEquals(actRnwlLength, expRnwlLength);
						Reporter.log("Expected Renewal Length:"+expRnwlLength+"::Actual Renewal Length:"+actRnwlLength,true);
						
						softAssert.assertEquals(actRate, expRate);
						Reporter.log("Expected Rate:"+expRate+"::Actual Rate:"+actRate,true);
						
						softAssert.assertEquals(actNotes, expNotes);
						Reporter.log("Expected Notes:"+expNotes+"::Actual Notes:"+actNotes,true);
						
						flag=true;
						break;
					}
				}
				break;
			}
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	/**
	 * Method to add and delete Contract Details. Method validates the contract details after add and delete.
	 * @author girish.n
	 */
	@Test
	public void addDeleteContractDetails(){
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		boolean flag=false;
		
		//Add Contract Details
		String expAuditName="AuditName"+currenttime();
		String expTerm="6";
		String expRnwlType="EverGreen";
		String expRnwlLength="5";
		String expRate="500";
		String expNotes="AddContractDetails";
		dataMap.put("AuditName", expAuditName);
		dataMap.put("Term", expTerm);
		dataMap.put("RenewalType", expRnwlType);
		dataMap.put("RenewalLength", expRnwlLength);
		dataMap.put("Rate", expRate);
		dataMap.put("Notes", expNotes);
		dataMap.put("SaveContractDetails", "");
		configFinancePage.addContractDetails(dataMap);
		
		//Search Contract Detail
		dataMap.put("SearchType","Audit Name");
		dataMap.put("SearchValue",expAuditName);
		configFinancePage.searchContractDetails(dataMap);
		
		//Validation
		SoftAssert softAssert=new SoftAssert();
		
		for(int i=0;i<configFinancePage.auditNameList().size();i++){
			String actAuditName=configFinancePage.auditNameList().get(i).getText().trim();
			String actTerm=configFinancePage.termList().get(i).getText().trim();
			String actRnwlType=configFinancePage.rnwlTypeList().get(i).getText().trim();
			String actRnwlLength=configFinancePage.rnwlLengthList().get(i).getText().trim();
			String actRate=configFinancePage.rateList().get(i).getText().trim();
			String actNotes=configFinancePage.notesList().get(i).getText().trim();
			if(actAuditName.equalsIgnoreCase(expAuditName)){
				softAssert.assertEquals(actAuditName, expAuditName);
				Reporter.log("Expected Audi Name:"+expAuditName+"::Actual Audit Name:"+actAuditName,true);
				
				softAssert.assertEquals(actTerm, expTerm);
				Reporter.log("Expected Term:"+expTerm+"::Actual Term:"+actTerm,true);
				
				softAssert.assertEquals(actRnwlType, expRnwlType);
				Reporter.log("Expected Renewal Type:"+expRnwlType+"::Actual Renewal Type:"+actRnwlType,true);
				
				softAssert.assertEquals(actRnwlLength, expRnwlLength);
				Reporter.log("Expected Renewal Length:"+expRnwlLength+"::Actual Renewal Length:"+actRnwlLength,true);
				
				softAssert.assertEquals(actRate, expRate);
				Reporter.log("Expected Rate:"+expRate+"::Actual Rate:"+actRate,true);
				
				softAssert.assertEquals(actNotes, expNotes);
				Reporter.log("Expected Notes:"+expNotes+"::Actual Notes:"+actNotes,true);
				
				//Deleting the Contract Details
				fluentwait(configFinancePage.deleteLinksList().get(i));
				click(configFinancePage.deleteLinksList().get(i));
				fluentwait(configFinancePage.okBtn());
				click(configFinancePage.okBtn());
				waitforPageload(configFinancePage.contractDetailsTab());
					
				//Search Contract Details
				dataMap.put("SearchType","Audit Name");
				dataMap.put("SearchValue",expAuditName);
				configFinancePage.searchContractDetails(dataMap);
				
				if(configFinancePage.auditNameList().get(0).getText().contains("No Data Available"))
					flag=true;
				break;
			}
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}

	@AfterClass
	public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	}		
}
