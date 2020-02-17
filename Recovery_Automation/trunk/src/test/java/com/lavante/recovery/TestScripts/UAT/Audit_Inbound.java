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

public class Audit_Inbound extends pageInitiator {

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
		lavanteUtils.driver = driver;
		loginPage.login();
		waitForTime(3000);
		homePage.SelectAudit("Safety-Kleen");
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		//The following map update for Main and Sub tab selection
		dataMap.put("maintab", "audit");
	    dataMap.put("subtab", "inbound");
		homePage.selectTab(dataMap);
	}

	/** 
	 * @author Nagappa
	 * 
	 * Test to verify the newly added open credit and same is available in the batching page.
	 * 
	 */
	@Test
	public void verifyCredits() {
		Reporter.log("Test Started for Audit --> Inbound: " + LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flagData = false;
		boolean flagBatch = false;
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		// The following map update for Tab name for selection and Supplier name on which need to be clicked
		String tabName = "Recognized";
		String docSelectionType = "Verifications";
		String creditStatus = "All";

		dataMap.put("TabName", tabName);
		dataMap.put("DocSelectionType", docSelectionType);
		dataMap.put("CreditStatus", creditStatus);
		dataMap.put("SuppName", "ANY");
		dataMap.put("validate", "");
		
		// This method call is to select the Inbound tab and Sub tab under the Recognized tab.
		boolean flag = auditInboundPage.InboundPageSelection(dataMap);
		if(flag){
		flagData=true;
		
		// The following data is for adding a new Open CREDIT, which will be updated in the Batching page.
		String expSupplierRef = "Ref" + currenttime();
		String expCustomer = "Customer" + currenttime();
		String expCreditDate = "11/09/2016";
		String expAmount = "999";
		String expCurrency = "USD";
		String expLocationBU = "CAD";

		dataMap.put("SupplierRef", expSupplierRef);
		dataMap.put("Customer", expCustomer);
		dataMap.put("CreditDate", expCreditDate);
		dataMap.put("Amount", expAmount);
		dataMap.put("Currency", expCurrency);
		dataMap.put("LocationBU", expLocationBU);
		
		// The following map update is for button actions.
		dataMap.put("Submit", "");
		dataMap.put("ReqCheck", "");
		dataMap.put("Link", "");
		dataMap.put("Save", "");
		

		String expSuppName = auditInboundPage.supplierNameDetail().getText().trim();
    	auditInboundPage.outboundCreditDataPages(dataMap);

		// After adding a new open CREDIT, validate it from Batching tab. for the same navigating to Batching tab.
		dataMap.put("subtab", "batchingPage");
		homePage.selectTab(dataMap);

		waitForTime(2000);
		dataMap.put("Preview", "");
		auditBatchingPage.formBatching(dataMap);

		
		lavanteUtils.fluentwait(auditBatchingPage.previewBtn());
		// Switching to frame to get the Batching details
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEauditBatchingDetails());

		for (int i = 0; i < auditBatchingPage.reference().size(); i++) {
			String actReference = auditBatchingPage.reference().get(i).getText().trim();
			if (expSupplierRef.equalsIgnoreCase(actReference)) {
				flagBatch = true;

				boolean actSuppNameFlag = auditBatchingPage.supplierName().get(i).getText().contains(expSuppName);
				
				String actCreditDate = auditBatchingPage.creditDate().get(i).getText().trim();
				String actLocation = auditBatchingPage.location().get(i).getText().trim();
							
				boolean actAmountFlag =auditBatchingPage.amount().get(i).getText().contains(expAmount);
				
				String actCurrency = auditBatchingPage.currency().get(i).getText().trim();
				String actSubmit = auditBatchingPage.submit().get(i).getText().trim();

				System.out.println("Values: " + auditBatchingPage.supplierName().get(i).getText() + " - "+ actCreditDate + " - " + actLocation + " - " + " - " + auditBatchingPage.amount().get(i).getText() + " - " + actCurrency + " - " + actSubmit);

				Reporter.log("Expected Supplier Name: " + expSuppName + ", Actual Supplier Name: " + auditBatchingPage.supplierName().get(i).getText(), true);
				softAssert.assertTrue(actSuppNameFlag, "Validate Suuplier name ");
				
				Reporter.log("Expected Reference: " + expSupplierRef + ", Actual Reference: " + actReference);
				softAssert.assertEquals(expSupplierRef, actReference);
				
				Reporter.log("Expected Credit Date: " + expCreditDate + ", Actual Credit Date: " + actCreditDate);
				softAssert.assertEquals(expCreditDate, actCreditDate);

				Reporter.log("Expected Location: " + expLocationBU + ", Actual Location: " + actLocation);
				softAssert.assertEquals(expLocationBU, actLocation);

				Reporter.log("Expected Amount value: " + expAmount + ", Actual Amount value: " + auditBatchingPage.amount().get(i).getText());
				softAssert.assertTrue(actAmountFlag, "Validate amount value ");
				
				Reporter.log("Expected Currency value: " + expCurrency + ", Actual Currency value: " + actCurrency);
				softAssert.assertEquals(expCurrency, actCurrency);

				Reporter.log("Expected Submit value: " + "Yes" + ", Actual Submit value: " + actSubmit);
				softAssert.assertEquals("Yes", actSubmit);

			}
		}
		}
		System.out.println("flagData: " + flagData);
		softAssert.assertTrue(flagData, "No data for creating an Verification document type credit.");
		
		System.out.println("flagBatch: " + flagBatch);
		softAssert.assertTrue(flagBatch, "Please Recheck the Test");

		softAssert.assertAll();
		Reporter.log("Test Ended for  Audit --> Inbound: " + LavanteUtils.currenttime());
	}
	
	@AfterClass
	public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	}
}
