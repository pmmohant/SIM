package com.lavante.recovery.TestScripts.UAT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class Audit_Batching extends pageInitiator {
	
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
	    dataMap.put("subtab", "batchingPage");
		homePage.selectTab(dataMap);
	}

	/** 
	 * @author Nagappa
	 * 
	 * Test to verify the batching page.
	 * 
	 */
	@Test
	public void verifyBatching() {
		Reporter.log("Test Started for Audit --> Batching: " + LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flagBatchAction=false;
		boolean flagUnBatchedCredits=false;
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("Preview","");
				
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
		int count=auditBatchingPage.openCredits().size();		
		lavanteUtils.switchtoFrame(null);
		
		//checking whether open credits exist or not and Preview button is enabled
		if(count>0 && auditBatchingPage.previewBtn().isEnabled()){
			
		//flagUnBatchedCredits - setting this flag as true if there any open credits to move to batching.
		//else, failing the test script saying, Zero Un-batched credits. Please add an open credit to process batching action.
		flagUnBatchedCredits=true;
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEUnBatchedCredits());
		String openCredits=auditBatchingPage.openCredits().get(0).getText().trim();
		lavanteUtils.switchtoFrame(null);
		
		//Click on the Preview button
		auditBatchingPage.formBatching(dataMap);
		
		double sum=0;
				
		//Switching to Batch Details frame
		lavanteUtils.fluentwait(auditBatchingPage.IFRAMEauditBatchingDetails());
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEauditBatchingDetails());
		int maxLineItem=auditBatchingPage.amount().size();
		for(int i=0; i<auditBatchingPage.amount().size(); i++)
		{
			sum+=Double.valueOf(auditBatchingPage.amount().get(i).getText().replace(",", ""));
		}
		String totalSum= ""+sum;
		System.out.println("totalSum= " + totalSum);
		lavanteUtils.switchtoFrame(null);
		
		//Asserting open credits with claims total from Batch Summary table
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEBatchSummary());
		String claimsTotal=auditBatchingPage.claimsTotal().getText().trim();
		int numberofClaims=Integer.parseInt(auditBatchingPage.numberofClaims().getText().trim());
		lavanteUtils.switchtoFrame(null);
		
		Reporter.log("Expected open credits: " + openCredits +", Actual Claims total from Batch Summary table: "+  claimsTotal,true);
		softAssert.assertEquals(openCredits, claimsTotal);		
		
		//Asserting open credits with claims total from Batch Details table
		Reporter.log("Expected open credits: " + openCredits +", Actual Claims total from Batch Details table: "+  totalSum,true);
		softAssert.assertTrue(openCredits.replace(",", "").contains(totalSum));
		
		//Asserting total Line Items from  Batch Details table with (#) Claims from Batch Summary table
		Reporter.log("Expected Line Items from  Batch Details table: " + maxLineItem +", Actual (#) Claims from Batch Summary table: "+  numberofClaims,true);
		softAssert.assertEquals(maxLineItem, numberofClaims);
		
		//Asserting the Batch Summary data with Batch Preview data
		//First switch to Batch Summary frame and get the required values
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEBatchSummary());
		claimsTotal=auditBatchingPage.claimsTotal().getText().trim();
		numberofClaims=Integer.parseInt(auditBatchingPage.numberofClaims().getText().trim());
		String summBatchId = auditBatchingPage.batchID().getText().trim();
		String summDate = auditBatchingPage.summaryDate().getText().trim();
		String summBatchType = auditBatchingPage.batchType().getText().trim();
		lavanteUtils.switchtoFrame(null);
		
		//click on the Create button
		dataMap.clear();
		dataMap.put("Create","");
		auditBatchingPage.formBatching(dataMap);
		
		//Switch to Batch Summary Preview frame and get the required values
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEpreview());
		String prevBatchId = auditBatchingPage.previewBatchID().getText().trim();
		String prevDate = auditBatchingPage.previewDate().getText().trim();
		String prevClaimsTotal=auditBatchingPage.previewClaimsTotal().getText().trim();
		int prevNumberofClaims=Integer.parseInt(auditBatchingPage.previewNumberofClaims().getText().trim());
		String prevBatchType = auditBatchingPage.previewBatchType().getText().trim();
		lavanteUtils.switchtoFrame(null);
				
		Reporter.log("Expected Batch ID from  Batch Summary table: " + summBatchId +", Actual Batch ID from Batch Preview Frame: "+  prevBatchId,true);
		softAssert.assertEquals(summBatchId, prevBatchId);

		Reporter.log("Expected Date from  Batch Summary table: " + summDate +", Actual Date from Batch Preview Frame: "+  prevDate,true);
		softAssert.assertEquals(summDate, prevDate);

		Reporter.log("Expected Claims Total from  Batch Summary table: " + claimsTotal +", Actual Claims Total from Batch Preview Frame: "+  prevClaimsTotal,true);
		softAssert.assertEquals(claimsTotal, prevClaimsTotal);

		Reporter.log("Expected Total Number of Claims from  Batch Summary table: " + numberofClaims +", Actual Total Number of Claims from Batch Preview Frame: "+  prevNumberofClaims,true);
		softAssert.assertEquals(numberofClaims, prevNumberofClaims);

		Reporter.log("Expected Batch type from  Batch Summary table: " + summBatchType +", Actual Batch type from Batch Preview Frame: "+  prevBatchType,true);
		softAssert.assertEquals(summBatchType, prevBatchType);
		
		//click on the Commit button
		dataMap.clear();
		dataMap.put("Commit","");
		auditBatchingPage.formBatching(dataMap);
		
		//After committing the data, Click on Batched Claims and move to Claims page and validate the data.
		lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEbatchedClaims());
		int totalRows=auditBatchingPage.batchedClaimsDate().size();
		String batchedClaimID="";
		
		for(int j=0; j<totalRows; j++)
		{
			batchedClaimID=auditBatchingPage.batchedClaimsID().get(j).getText().trim();
			if(summBatchId.equalsIgnoreCase(batchedClaimID)){
				String batchedClaimDate=auditBatchingPage.batchedClaimsDate().get(j).getText().trim();
				String batchedClaimTotal1[]=auditBatchingPage.batchedClaimsTotal().get(j).getText().split("/");
				String batchedClaimTotal=batchedClaimTotal1[0].trim();
				String batchedClaimAmount=auditBatchingPage.batchedClaimsAmount().get(j).getText().trim().replace(",", "");
				//String batchedClaimType=auditBatchingPage.batchedClaimsType().get(j).getText().trim();
			
				lavanteUtils.click(auditBatchingPage.batchedClaimsDate().get(j));
				
				//Moved to Claims page.
				waitForTime(4000);
				
				Reporter.log("Expected Claims Total from  Batching page: " + batchedClaimTotal +", Actual Claims Total from Claims page: "+  claimsPage.numberOpen().getText().trim(),true);
				softAssert.assertTrue(claimsPage.numberOpen().getText().trim().contains(batchedClaimTotal));

				Reporter.log("Expected Total Number of Claims from  Batching page: " + batchedClaimAmount+", Actual Total Number of Claims from Claims page: "+  claimsPage.amountOpen().getText().trim().replace(",", ""),true);
				softAssert.assertTrue(claimsPage.amountOpen().getText().trim().replace(",", "").contains(batchedClaimAmount));
				
				Reporter.log("Expected Date from  Batching page: " + batchedClaimDate+", Actual Date from Claims page: "+  claimsPage.startDate().getText().trim(),true);
				softAssert.assertEquals(batchedClaimDate,claimsPage.startDate().getText().trim());
				
				flagBatchAction=true;
			    break;
			}
		}			
	}
		System.out.println("flagAssert: " + flagBatchAction);
		softAssert.assertTrue(flagBatchAction, "Please Recheck the Test");
		softAssert.assertTrue(flagUnBatchedCredits, "Zero Un-batched credits. Please add an open credit to process batching action.");
		
		softAssert.assertAll();
		Reporter.log("Test Ended for  Audit --> Batching: " + LavanteUtils.currenttime());
	}
		
	/** 
	 * @author Nagappa
	 * 
	 * Test to verify the flow from Batching page to Claims and Invoice.
	 * 
	 */
	@Test(dependsOnMethods={"verifyBatching"})
	public void processBatchedClaims(){
		Reporter.log("Test Started for Audit --> processing the Batched Claims: " + LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean clickFlag=false;
		/*lavanteUtils.switchtoFrame(auditBatchingPage.IFRAMEbatchedClaims());
		int totalRows=auditBatchingPage.batchedClaimsTotal().size();
		for(int i=0; i<totalRows; i++){
			String openCount[]=auditBatchingPage.batchedClaimsTotal().get(i).getText().split("/");
			
			if(Integer.parseInt(openCount[0].trim()) > 0){
				lavanteUtils.click(auditBatchingPage.batchedClaimsDate().get(i));
				clickFlag=true;
				break;
			}
		}*/
		//select all claims from Claims List table
		lavanteUtils.fluentwait(claimsPage.selectAllCheckBox());
		lavanteUtils.click(claimsPage.selectAllCheckBox());
		
		lavanteUtils.switchtoFrame(null);
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("Comment","Processed"+lavanteUtils.currenttime());
		dataMap.put("Save","");
		
		//Copy Claims List data
		LinkedHashMap<String, String> dataFromClaimsPage = new LinkedHashMap<String, String>();
		String supplierId=claimsPage.supplierId().get(0).getText();
		for(int i=0; i<claimsPage.supplierName().size(); i++){
			
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_SupplierName", claimsPage.supplierName().get(i).getText().trim());
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_ClaimId", claimsPage.claimId().get(i).getText().trim());			
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_Reference", claimsPage.supplierReference().get(i).getText().trim());
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_CreditDate", claimsPage.creditDate().get(i).getText().trim());
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_Amount", claimsPage.claimAmount().get(i).getText().trim());
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_CurrencyCode", claimsPage.currency().get(i).getText().trim());
			dataFromClaimsPage.put(claimsPage.claimId().get(i).getText().trim()+"_Organization", claimsPage.organization().get(i).getText().trim());
		}
		String size = ""+claimsPage.supplierName().size();
		dataFromClaimsPage.put("size",size);
		System.out.println("dataFromClaimsPage: " + dataFromClaimsPage);
		lavanteUtils.waitForTime(2000);
		claimsPage.markAsProcessed(dataMap);
		
		//Navigate to Invoice page and validate the details
		//The following map update for Main and Sub tab selection
				lavanteUtils.waitForTime(3000);
				dataMap.clear();
				dataMap.put("maintab", "audit");
			    dataMap.put("subtab", "invoicingPage");
				homePage.selectTab(dataMap);
				
				dataMap.put("Preview","");
				auditInvoicePage.auditInvoiceActions(dataMap);
				
				lavanteUtils.switchtoFrame(auditInvoicePage.IFRAMEauditInvoicePreview());
				lavanteUtils.click(auditInvoicePage.okayBtn());
				lavanteUtils.switchtoFrame(null);
				
				//get the data to compare
				Set<Entry<String, String>>  keys = dataFromClaimsPage.entrySet();
				String claimIDs="";
				for(Entry<String, String> key: keys){
					if(key.getKey().contains("ClaimId")){
						System.out.println("key.getKey(): " + key.getKey());
						claimIDs+=key.getKey()+"#";
					}					
				}
				LinkedHashMap<String, String> dataMapForPagination = new LinkedHashMap<String, String>();
				dataMapForPagination.put("ClaimId", claimIDs);
				dataMapForPagination.put("size", size);
				LinkedHashMap<String, String> dataFromInvoicePage = new LinkedHashMap<String, String>();
				dataFromInvoicePage = auditInvoicePage.pagination(dataMapForPagination);
				System.out.println("dataFromInvoicePage: " + dataFromInvoicePage);
				
				//Fail the test script if the Size flag does not match the passed count				
				boolean flagPagination = (dataFromInvoicePage.get("flag").equalsIgnoreCase("true"));
				Reporter.log("Pagination flag: " + flagPagination);
				softAssert.assertTrue(flagPagination);
				
				System.out.println("dataMap before Create: " + dataFromInvoicePage);
				dataMap.clear();
				dataMap.put("Create", "");
				auditInvoicePage.auditInvoiceActions(dataMap);
				
				//Switch to Invoice Summary Preview FRAME and get the data
				lavanteUtils.switchtoFrame(auditInvoicePage.IFRAMEinvoiceSummaryPreview());
				String invoiceNumbrPreview=auditInvoicePage.invoiceNumberPreview().getText().trim();
				String invoiceDatePreview = auditInvoicePage.invoiceDatePreview().getText().trim();
				String invoiceAmountPreview=auditInvoicePage.invoiceAmountPreview().getText().trim();
				String invoiceTypePreview=auditInvoicePage.invoiceTypePreview().getText().trim();
				
				System.out.println("dataMap before Cancel: " + dataFromInvoicePage);
				dataMap.clear();
				dataMap.put("Cancel", "");
				auditInvoicePage.auditInvoiceActions(dataMap);
				lavanteUtils.switchtoFrame(null);
				
				lavanteUtils.switchtoFrame(auditInvoicePage.IFRAMEinvoiceSummary());
				Reporter.log("Expected Invoice number from  Invoice page: " + auditInvoicePage.invoiceNumber().getText().trim()+", Actual Invoice number from Invoice Summary Preview: "+  invoiceNumbrPreview,true);
				softAssert.assertEquals(auditInvoicePage.invoiceNumber().getText().trim(),invoiceNumbrPreview);
				
				Reporter.log("Expected Invoice Date from  Invoice page: " + auditInvoicePage.invoiceDate().getText().trim()+", Actual Invoice Date from Invoice Summary Preview: "+  invoiceDatePreview,true);
				softAssert.assertEquals(auditInvoicePage.invoiceDate().getText().trim(),invoiceDatePreview);
				
				Reporter.log("Expected Amount from  Invoice page: " + auditInvoicePage.totalAmount().getText().trim()+", Actual Amount from Invoice Summary Preview: "+  invoiceAmountPreview,true);
				softAssert.assertEquals(auditInvoicePage.totalAmount().getText().trim(),invoiceAmountPreview);
				
				Reporter.log("Expected Invoice Type from  Invoice page: " + auditInvoicePage.currencyType().getText().trim()+", Actual Invoice Type from Invoice Summary Preview: "+  invoiceTypePreview,true);
				softAssert.assertTrue(invoiceTypePreview.contains(auditInvoicePage.currencyType().getText().trim()));
				
				lavanteUtils.switchtoFrame(null);
				
				//Compare the data from Claims page against the data captured in invoice page
				System.out.println("dataFromInvoicePage: " + dataFromInvoicePage);
				System.out.println("dataFromClaimsPage: " + dataFromClaimsPage);
								
				String s[] = claimIDs.split("_ClaimId#");
				for(String claimID: s)
				{
					System.out.println("claimID: "+claimID);
					
					Reporter.log("Expected SupplierName from  Claims page: " + dataFromClaimsPage.get(claimID+"_SupplierName")+", Actual SupplierName from Invoice page: "+  dataFromInvoicePage.get(claimID+"_SupplierName"),true);
					softAssert.assertTrue(dataFromClaimsPage.get(claimID+"_SupplierName").contains(dataFromInvoicePage.get(claimID+"_SupplierName")));
										
					Reporter.log("Expected ClaimId from  Claims page: " + dataFromClaimsPage.get(claimID+"_ClaimId")+", Actual ClaimId from Invoice page: "+  dataFromInvoicePage.get(claimID+"_ClaimId"),true);
					softAssert.assertEquals(dataFromClaimsPage.get(claimID+"_ClaimId"), dataFromInvoicePage.get(claimID+"_ClaimId"));
					
					Reporter.log("Expected Reference from  Claims page: " + dataFromClaimsPage.get(claimID+"_Reference")+", Actual Reference from Invoice page: "+  dataFromInvoicePage.get(claimID+"_Reference"),true);
					softAssert.assertEquals(dataFromClaimsPage.get(claimID+"_Reference"), dataFromInvoicePage.get(claimID+"_Reference"));
					
					Reporter.log("Expected CreditDate from  Claims page: " + dataFromClaimsPage.get(claimID+"_CreditDate")+", Actual CreditDate from Invoice page: "+  dataFromInvoicePage.get(claimID+"_CreditDate"),true);
					String yyFormatDate = lavanteUtils.convertDateToYYFormat(dataFromClaimsPage.get(claimID+"_CreditDate"));
					softAssert.assertEquals(yyFormatDate, dataFromInvoicePage.get(claimID+"_CreditDate"));
					
					Reporter.log("Expected Amount from  Claims page: " + dataFromClaimsPage.get(claimID+"_Amount")+", Actual Amount from Invoice page: "+  dataFromInvoicePage.get(claimID+"_Amount").replace(",", ""),true);
					softAssert.assertTrue(dataFromInvoicePage.get(claimID+"_Amount").replace(",", "").contains(dataFromClaimsPage.get(claimID+"_Amount")));
										
					Reporter.log("Expected CurrencyCode from  Claims page: " + dataFromClaimsPage.get(claimID+"_CurrencyCode")+", Actual CurrencyCode from Invoice page: "+  dataFromInvoicePage.get(claimID+"_CurrencyCode"),true);
					softAssert.assertEquals(dataFromClaimsPage.get(claimID+"_CurrencyCode"), dataFromInvoicePage.get(claimID+"_CurrencyCode"));
			}
								
				dataMap.clear();
				dataMap.put("Create", "");
				auditInvoicePage.auditInvoiceActions(dataMap);
				lavanteUtils.waitForTime(2000);
				
				dataMap.clear();
				dataMap.put("Commit", "");
				auditInvoicePage.auditInvoiceActions(dataMap);
				lavanteUtils.switchtoFrame(null);
				
				softAssert.assertAll();
				Reporter.log("Test Ended for  Audit --> processing the Batched Claims: " + LavanteUtils.currenttime());
								
	}
	
	@AfterMethod
	public void AfterMethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
	}
	
	/**
	 * Logout Application
	 * 
	 */	
	@AfterClass
	public void QuitBrowser(){
		homePage.logout();
		quitBrowser();
	}
}
