package com.lavante.recovery.TestScripts.UAT;



import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;


public class Dashboard_Supplier extends pageInitiator {
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
		homePage.verifyHomePageDisplayed();
		
		}
	
	@BeforeMethod()
	public void Before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","dashboard");
		dataMap.put("subtab","supplierDashboard");
		homePage.selectTab(dataMap);
	}


	/**
	 * @author Ramya.Raj
	 *
	 */
	@Test(priority = 1)
	public void SupplierChangeStatistics() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		
		waitForTime(6000);
		click(suppDashboardPage.supplierChangeStatisticsDropdown());
		fluentwait(suppDashboardPage.supplierChangeStatisticsDatatable());
		click(suppDashboardPage.supplierChangeStatisticsDatatable());
			
		String expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(0).getText();
		String ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(0).getText();
		click(suppDashboardPage.supplierChangeStatisticsLinks().get(0));
		
		Reporter.log("Verification for Supplier Name:");
		String actValue = suppListPage.supplierListName().getText();
		String actValue1[] = actValue.split(":");
		String actualValue = actValue1[1];
		String expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
		softAssert.assertEquals(actualValue, expectedValue1,"Supplier Name Count Mismatch");
		
		if(!ExpCount.equalsIgnoreCase("0")){
		String actMatchingCriteria = suppListPage.matchingCriteria().getText();
		String actualMatchingCriteria1[] =actMatchingCriteria.split(":");
		softAssert.assertEquals(actMatchingCriteria, expLinkValue,"Matching criteria Mismatch");
		}else {
			String expData = "No Data Available";
			String actData = suppListPage.noDataAvailable().getText();
			softAssert.assertEquals(actData,expData);
			
			}
		
		
		click(suppListPage.backButton());
		click(suppDashboardPage.supplierLink());
		waitForTime(6000);
		click(suppDashboardPage.supplierChangeStatisticsDropdown());
		click(suppDashboardPage.supplierChangeStatisticsDatatable());
		
		
		expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(1).getText();
		ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(1).getText();
		click(suppDashboardPage.supplierChangeStatisticsLinks().get(1));
		
		actValue = suppListPage.supplierListName().getText();
		String actValue2[] = actValue.split(":");
		actualValue = actValue2[1];
		expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
		softAssert.assertEquals(actualValue, expectedValue1,"Supplier Name Count Mismatch");
		
		if(!ExpCount.equalsIgnoreCase("0")){
		String actMatchingCriteria = suppListPage.matchingCriteria().getText();
		String actualMatchingCriteria2[] =actMatchingCriteria.split(":");
		softAssert.assertEquals(actMatchingCriteria, expLinkValue," Supplier Matching criteria mismatch");
		}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
		}
	
		
		click(suppListPage.backButton());
		click(suppDashboardPage.supplierLink());
		waitForTime(6000);
		click(suppDashboardPage.supplierChangeStatisticsDropdown());
		click(suppDashboardPage.supplierChangeStatisticsDatatable());
		
		
		
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(2).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(2).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(2));
	
	actValue = suppListPage.supplierListName().getText();
	String actValue3[] = actValue.split(":");
	actualValue = actValue3[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1," Supplier Count Mismatch");
	
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria3[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria3[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue," Supplier Criteria Mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(3).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(3).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(3));
	actValue = suppListPage.supplierListName().getText();
	String actValue4[] = actValue.split(":");
	actualValue = actValue4[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name mismatch");
			
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria4[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria4[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue,"Supplier criteria mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(4).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(4).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(4));
	actValue = suppListPage.supplierListName().getText();
	String actValue5[] = actValue.split(":");
	actualValue = actValue5[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name mismatch");
	
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria5[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria5[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue,"Supplier matching criteria mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(5).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(5).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(5));
	actValue = suppListPage.supplierListName().getText();
	String actValue6[] = actValue.split(":");
	actualValue = actValue6[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name count mismatch");
	
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria6[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria6[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue,"Supplier matching criteria mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(6).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(6).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(6));
	actValue = suppListPage.supplierListName().getText();
	String actValue7[] = actValue.split(":");
	actualValue = actValue7[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name count mismatch");
	
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria7[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria7[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue,"Supplier matching criteria mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(7).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(7).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(6));
	actValue = suppListPage.supplierListName().getText();
	String actValue8[] = actValue.split(":");
	actualValue = actValue8[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name count mismatch");
		
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria8[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria8[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue,"Supplier matching criteria mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(8).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(8).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(8));
	actValue = suppListPage.supplierListName().getText();
	String actValue9[] = actValue.split(":");
	actualValue = actValue9[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name count mismatch");
			
	if(!ExpCount.equalsIgnoreCase("0")){
	String actMatchingCriteria = suppListPage.matchingCriteria().getText();
	String actualMatchingCriteria9[] =actMatchingCriteria.split(":");
	String actualMatchingCriteria = actualMatchingCriteria9[0];
	System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
	System.out.println("expLinkValue="+ expLinkValue);
	softAssert.assertEquals(actualMatchingCriteria, expLinkValue,"Supplier matching criteria mismatch");
	}else {
		String expData = "No Data Available";
		String actData = suppListPage.noDataAvailable().getText();
		softAssert.assertEquals(actData,expData);
		
	}
	
	
	click(suppListPage.backButton());
	click(suppDashboardPage.supplierLink());
	waitForTime(6000);
	click(suppDashboardPage.supplierChangeStatisticsDropdown());
	click(suppDashboardPage.supplierChangeStatisticsDatatable());
	
	
	expLinkValue = suppDashboardPage.supplierChangeStatisticsLinks().get(9).getText();
	ExpCount = suppDashboardPage.supplierChangeStatisticsDataTableCount().get(9).getText();
	click(suppDashboardPage.supplierChangeStatisticsLinks().get(9));
	actValue = suppListPage.supplierListName().getText();
	String actValue10[] = actValue.split(":");
	actualValue = actValue10[1];
	expectedValue1 = expLinkValue+ " "+ "(" + ExpCount +")";
	System.out.println("actual value=" +actualValue);
	System.out.println("expected value = "+expectedValue1);
	softAssert.assertEquals(actualValue, expectedValue1,"Supplier name count mismatch");
	
		if(!ExpCount.equalsIgnoreCase("0")){
			String actMatchingCriteria = suppListPage.matchingCriteria().getText();
			String actualMatchingCriteria10[] =actMatchingCriteria.split(":");
			String actualMatchingCriteria = actualMatchingCriteria10[0];
			System.out.println("actMatchingCriteria=" +actualMatchingCriteria);
			System.out.println("expLinkValue="+ expLinkValue);
			softAssert.assertEquals(actMatchingCriteria, expLinkValue);
			click(suppListPage.backButton());
		}else {
			String expData = "No Data Available";
			String actData = suppListPage.noDataAvailable().getText();
			softAssert.assertEquals(actData,expData);
			click(suppListPage.backButton());
			
		}
		
		
		Reporter.log("Test Ended "+currenttime());
	
	}
	
	/**
	 * @author Ramya.Raj
	 *
	 */
	@Test(priority = 2)
	public void RelatedSupplierAnalysis() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(6000);
		click(suppDashboardPage.relatedSupplierAnalysisDropdown());
		click(suppDashboardPage.relatedSupplierAnalysisDataTable());
		int actSize = 16;
		int expSize = suppDashboardPage.relatedSupplierAnalysisLinks().size();
		Assert.assertEquals(actSize, expSize);
		for( int i =0 ; i<suppDashboardPage.relatedSupplierAnalysisLinks().size();i++){
			String expCount = suppDashboardPage.relatedSupplierAnalysisCounts().get(i).getText();
			System.out.println("expectedcount = "+expCount);
			click(suppDashboardPage.relatedSupplierAnalysisLinks().get(i));
			String actCount = suppListPage.supplierListName().getText();
			String actCount1[] = actCount.split("\\(");
			String actualCount = actCount1[1];
			System.out.println("actual Count = " +actualCount);
			String actualCount1 = actualCount.toString();
			actualCount1 = actualCount1.substring(0, actualCount1.length() - 1);
			System.out.println(actualCount1);
			Assert.assertEquals(actualCount1, expCount);
			click(suppListPage.backButton());
			click(suppDashboardPage.supplierLink());
			waitForTime(6000);
						
		}
		

		
	}
	
	/**
	 * @author Girish N
	 *
	 */
	@Test(priority=3)
	public void Top100SuppliersBy(){
		
		SoftAssert softAssert=new SoftAssert();
		
		// Verifying Dashboard Supplier Page --> Credit Tab
		if(suppDashboardPage.creditSupplierNameList().size()>0){
			String dsbdSuppName=suppDashboardPage.creditSupplierNameList().get(0).getText().trim();
			String dsbdSuppCrdtAmt=suppDashboardPage.creditTotalAmountList().get(0).getText().trim();
			String dsbdSuppCrdtCnt=suppDashboardPage.creditCountList().get(0).getText().trim();
			
			click(suppDashboardPage.creditSupplierNameList().get(0));
			
			fluentwait(supplierPage.suppNameOnTitle());
			
			String suppClmAmt=supplierPage.totalClaimAmt().getText();
			String suppName=supplierPage.supplierName().getText();
			String suppClmCnt=supplierPage.claimCnt().getText();
			
			softAssert.assertEquals(suppName, dsbdSuppName);
			Reporter.log("Dashboard-Supplier_Name:"+dsbdSuppName+"::SupplierPage-Supplier_Name:"+suppName, true);
	
			softAssert.assertEquals(suppClmAmt, dsbdSuppCrdtAmt);
			Reporter.log("Dashboard-Claim_Amt:"+dsbdSuppCrdtAmt+"::SupplierPage-Claim_Amt:"+suppClmAmt, true);
			
			softAssert.assertEquals(suppClmCnt, dsbdSuppCrdtCnt);
			Reporter.log("Dashboard-Claim_Count:"+dsbdSuppCrdtCnt+"::SupplierPage-Claim_Count:"+suppClmCnt, true);
			
			click(supplierPage.backBtn());
		}
		else{
			Reporter.log("Supplier List is empty. Select another audit", true);
		}
		
		// Verifying Dashboard Supplier Page --> Spend Tab		
		fluentwait(suppDashboardPage.spendTab());
		click(suppDashboardPage.spendTab());
		waitForTime(3000);

		if(suppDashboardPage.spendSupplierNameList().size()>0){
			String dsbdSuppName=suppDashboardPage.spendSupplierNameList().get(0).getText().trim();
			String dsbdSuppSpendtAmt=suppDashboardPage.spendTotalAmountList().get(0).getText().trim();
			String dsbdSuppSpendRank=suppDashboardPage.spendRankList().get(0).getText().trim();
			
			click(suppDashboardPage.spendSupplierNameList().get(0));
			
			fluentwait(supplierPage.suppNameOnTitle());
			
			String suppSpendAmt=supplierPage.spendAmt().getText();
			String suppName=supplierPage.supplierName().getText();
			String suppSpendRank=supplierPage.spendRank().getText();
			
			softAssert.assertEquals(suppName, dsbdSuppName);
			Reporter.log("Dashboard-Supplier_Name:"+dsbdSuppName+"::SupplierPage-Supplier_Name:"+suppName, true);
	
			softAssert.assertEquals(suppSpendAmt, dsbdSuppSpendtAmt);
			Reporter.log("Dashboard-Spend_Amt:"+dsbdSuppSpendtAmt+"::SupplierPage-Spend_Amt:"+suppSpendAmt, true);
			
			softAssert.assertEquals(suppSpendRank, dsbdSuppSpendRank);
			Reporter.log("Dashboard-Spend_Rank:"+dsbdSuppSpendRank+"::SupplierPage-Spend_Rank:"+suppSpendRank, true);
		}
		else{
			Reporter.log("Supplier List is empty. Select another audit", true);
		}

		
		softAssert.assertAll();
	}
	



		/**
		 * After Class Logout and Quit Method 
		 * 
		 * @author Ramya.Raj
		 */
		
		@AfterClass
		  public void QuitBrowser() {
			  homePage.logout();
			  quitBrowser();
		  }
		
		}

		
		
		
		
		

