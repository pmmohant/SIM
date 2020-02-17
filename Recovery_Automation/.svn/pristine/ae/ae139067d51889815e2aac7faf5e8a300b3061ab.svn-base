package com.lavante.recovery.TestScripts.Configuration;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class Config_SetUp_ManageCurrency extends pageInitiator {
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
		homePage.verifyHomePageDisplayed();
		
		waitForTime(3000);
		homePage.SelectAudit("Giant Eagle");
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		
		dataMap.put("maintab","configuration");
        dataMap.put("subtab","configurationSetup");
        homePage.selectTab(dataMap);

	}
	
	/**
	 * Test  Method to verify multi-currency by selecting multiple currency in Customer preferred currency
	 * and verifying the same in credit entry page. Also verifies the default currency for a customer.
	 * 
	 * @author girish.n
	 */
	
	@Test
	public void configMultiAndDefCurrencyTest(){

		Reporter.log("Test Start Time:"+randomnum(),true);
		
		fluentwait(configSetUpPage.manageCurrencyTab());
		click(configSetUpPage.manageCurrencyTab());
		
		/*
		 * Configuring multiple currency and setting up the default currency.
		 */
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		String defCurrency="EUR";
		dataMap.put("USD","");
		dataMap.put("EUR","");
		dataMap.put("GBP","");
		dataMap.put("CAD","");
		dataMap.put("DefaultCurrencyType", defCurrency);
		
		configSetUpPage.configPreferredCurrencies(dataMap);
		
		dataMap.put("maintab","audit");
        dataMap.put("subtab","inbound");
        homePage.selectTab(dataMap);
        
        /*
         * Adding new credit entry and verify the currency types.
         */
        String tabName = "Recognized";
		String docSelectionType = "Verifications";
		String creditStatus = "All";

		dataMap.put("TabName", tabName);
		dataMap.put("DocSelectionType", docSelectionType);
		dataMap.put("CreditStatus", creditStatus);
		dataMap.put("SuppName", "ANY");
		dataMap.put("validate", "");

		boolean prefCurrCheckFlag=false;
		boolean defCurrCheckFlag=false;
		SoftAssert softAssert=new SoftAssert();
		// This method call is to select the Inbound tab and Sub tab under the Recognized tab.
		boolean flag = auditInboundPage.InboundPageSelection(dataMap);
		if(flag){
			//Verifying Customer Preferred Currencies
			switchtoFrame(auditInboundPage.creditTableiFrame());
			fluentwait(auditInboundPage.currencyDDL());
			click(auditInboundPage.currencyDDL());
			List<WebElement> currList = auditInboundPage.currencyDDLoptions();
			for(int i=0;i<currList.size();i++){
				prefCurrCheckFlag=true;
				String data=currList.get(i).getText().trim();
				Reporter.log(data,true);
				if (data.length()>0&&!dataMap.containsKey(data)){
					prefCurrCheckFlag=false;
					Reporter.log(data+": Not a prefered currency",true);
					break;
				}
			}
			click(auditInboundPage.currencyDDL());
			//Test will go into the 'if block' only if the currency type options are same as the customer preferred currencies
			if(prefCurrCheckFlag){
				// The following data is for adding a new Open CREDIT
				String expSupplierRef = "Ref" + currenttime();
				String expCustomer = "Customer" + currenttime();
				String expCreditDate = "11/09/2016";
				String expAmount = "2500";
				String expLocationBU = "GiantEagleBU1";
				dataMap.put("SupplierRef", expSupplierRef);
				dataMap.put("Customer", expCustomer);
				dataMap.put("CreditDate", expCreditDate);
				dataMap.put("Amount", expAmount);
				dataMap.put("LocationBU", expLocationBU);
				
				// The following map update is for button actions.
				dataMap.put("Submit", "");
				dataMap.put("ReqCheck", "");
				dataMap.put("Link", "");
				dataMap.put("Save", "");
				
			//	String expSuppName = auditInboundPage.supplierNameDetail().getText().trim();
		    	auditInboundPage.outboundCreditDataPages(dataMap);
		    	//Validate the default Currency
		    	switchtoFrame(auditInboundPage.creditTableiFrame());
		    	for(int i=0;i<auditInboundPage.suppRefList().size();i++){
		    		String actSuppRef=auditInboundPage.suppRefList().get(i).getText().trim();
		    		if(actSuppRef.equalsIgnoreCase(expSupplierRef)){
		    			String actCurrency=auditInboundPage.currTypeList().get(i).getText().trim();
		    			if(actCurrency.equalsIgnoreCase(defCurrency)){
		    				Reporter.log("Expected Supplier Reference:"+expSupplierRef+"::Actual Supplier Reference:"+actSuppRef,true);
		    				Reporter.log("Expected Currency:"+defCurrency+"::Actual Currency:"+actCurrency,true);
		    				defCurrCheckFlag=true;
		    				break;
		    			}
		    		}
		    	}
		    	switchtoFrame(null);
			}
			
		}else{
			Reporter.log("Inbound Dashboard Page is empty", true);
		}
		softAssert.assertTrue(prefCurrCheckFlag);
		softAssert.assertTrue(defCurrCheckFlag);
		Reporter.log("Test End Time:"+randomnum(),true);
		softAssert.assertAll();
	}

	@AfterClass
	public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	}

}
