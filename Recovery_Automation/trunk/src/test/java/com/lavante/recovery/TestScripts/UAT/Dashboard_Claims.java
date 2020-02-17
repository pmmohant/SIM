package com.lavante.recovery.TestScripts.UAT;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author Ramya.Raj
 *
 */
public class Dashboard_Claims extends pageInitiator {
	
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
		homePage.SelectAudit("ANY");
		waitForTime(3000);
		homePage.verifyHomePageDisplayed();
		
		}
	
	@BeforeMethod()
	public void Before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","dashboard");
		dataMap.put("subtab","claim");
		homePage.selectTab(dataMap);
	}
	

	@Test(priority = 1)
	public void ItemsForMyReviewTable() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(6000);
		Reporter.log("Verifying New Open Claims From Lavante: ");
		String expData1 = dashboardclaimsPage.openClaimsLavante().get(0).getText();
		String expectedData1[] = expData1.split("\\(");
		String expectedData1Amount = expectedData1[0];
		String expectedData1Count1 = expectedData1[1];
		String expectedData1Count = expectedData1Count1.substring(0,1);
		
		
		String expData2 = dashboardclaimsPage.openClaimsLavante().get(1).getText();
		String expectedData2[] = expData2.split("\\(");
		String expectedData2Amount = expectedData2[0];
		String expectedData2Count1 = expectedData2[1];
		String expectedData2Count  = expectedData2Count1.substring(0,1);
		
		String expData3 = dashboardclaimsPage.openClaimsLavante().get(2).getText();
		String expectedData3[] = expData3.split("\\(");
		String expectedData3Amount = expectedData3[0];
		String expectedData3Count1 = expectedData3[1];
		String expectedData3Count  = expectedData3Count1.substring(0,1);
		
		String expStatus="";
		String expStatus1="";
		String actStatus="";
		String actStatus1="";
		
		SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		String expDate = "";
		String actDate = "";
		String[] actualDate ;
		String actualMonth1 = "";
		String actualDate1 = "";
		String[] expectedDate ;
		String expectedMonth1 = "";
		String expectedDate1 = "";
		
		int flag;
		int flag1;

		int actualmonth2 ;
		int actualdate2;
		int expectedmonth2;
		int expecteddate2;
		
		String linkText = dashboardclaimsPage.openClaimsLavante().get(0).getText().trim();
		String countLinks[] =  linkText.replaceAll("[^0-9.]","").split("\\(");
		
		boolean flagData=false;
		if(!countLinks[0].contains("0.00"))
		{			
			click(dashboardclaimsPage.openClaimsLavanteLinks().get(0));
			String actualData1Amount = claimsPage.amountOpen().getText();
			String actualData1Amoun1 = claimsPage.amountTotal().getText();
			String actualData1Count = claimsPage.numberOpen().getText();
			String actualData1Count1 = claimsPage.numberTotal().getText();
			expStatus = "Open";
			actStatus = claimsPage.claimbyStatus().getText();
			actStatus1= claimsPage.claimStatus().getText();
			softAssert.assertEquals(actStatus, expStatus);
			softAssert.assertEquals(actStatus1,expStatus);
			softAssert.assertEquals(actualData1Amount, expectedData1Amount);
			softAssert.assertEquals(actualData1Amoun1, expectedData1Amount);
			softAssert.assertEquals(actualData1Count, expectedData1Count);
			softAssert.assertEquals(actualData1Count1, expectedData1Count);
			expDate = DtFormat.format(date).toString();
			actDate = claimsPage.startDate().getText();
			actualDate = actDate.split("/");
			actualMonth1 = actualDate[0];
			actualDate1 = actualDate[1];
			expectedDate = expDate.split("/");
			expectedMonth1 = expectedDate[0];
			expectedDate1 = expectedDate[1];
			actualmonth2 = Integer.parseInt((actualMonth1));
			actualdate2 = Integer.parseInt((actualDate1));
			expectedmonth2= Integer.parseInt(expectedMonth1);
			expecteddate2 = Integer.parseInt(expectedDate1);
			flag = 1;
			flag1= 1;
			if ((expecteddate2-actualdate2)<= 30) {
				flag1 = 1 ;
			}
			flagData=true;
			softAssert.assertTrue(flagData, "Please recheck the data..! Open Claims count is equal to zero..!");
			softAssert.assertEquals(flag, flag1);
			click(claimsPage.backButton());
		}
		
		linkText = dashboardclaimsPage.openClaimsLavante().get(1).getText().trim();
		String countLinks1[] =  linkText.replaceAll("[^0-9.]","").split("\\(");
		
		flagData=false;
		if(!countLinks1[0].contains("0.00"))
		{
			click(dashboardclaimsPage.openClaimsLavanteLinks().get(1));
			String actualData2Amount = claimsPage.amountOpen().getText();
			String actualData2Amoun1 = claimsPage.amountTotal().getText();
			String actualData2Count = claimsPage.numberOpen().getText();
			String actualData2Count1 = claimsPage.numberTotal().getText();
			expStatus = "Open";
			actStatus = claimsPage.claimbyStatus().getText();
			actStatus1= claimsPage.claimStatus().getText();
			softAssert.assertEquals(actStatus, expStatus);
			softAssert.assertEquals(actStatus1, expStatus);
			softAssert.assertEquals(actualData2Amount, expectedData2Amount);
			softAssert.assertEquals(actualData2Amoun1, expectedData2Amount);
			softAssert.assertEquals(actualData2Count, expectedData2Count);
			softAssert.assertEquals(actualData2Count1, expectedData2Count);
			DtFormat = new SimpleDateFormat("MM/dd/yy");
			date = new Date();
			expDate = DtFormat.format(date).toString();
			actDate = claimsPage.startDate().getText();
			actualDate = actDate.split("/");
			actualMonth1 = actualDate[0];
			actualDate1 = actualDate[1];
			expectedDate = expDate.split("/");
			expectedMonth1 = expectedDate[0];
			expectedDate1 = expectedDate[1];
			actualmonth2 = Integer.parseInt((actualMonth1));
			actualdate2 = Integer.parseInt((actualDate1));
			expectedmonth2= Integer.parseInt(expectedMonth1);
			expecteddate2 = Integer.parseInt(expectedDate1);
			flag = 1;
			flag1= 1;
			if ((expecteddate2-actualdate2)<= 60) {
				flag1 = 1 ;
			}
			flagData=true;
			softAssert.assertTrue(flagData, "Please recheck the data..! Open Claims count is equal to zero..!");
			softAssert.assertEquals(flag, flag1);
			click(claimsPage.backButton());
		
		}
		
		linkText = dashboardclaimsPage.openClaimsLavante().get(2).getText().trim();
		String countLinks2[] =  linkText.replaceAll("[^0-9.]","").split("\\(");
		
		flagData=false;
		if(!countLinks2[0].contains("0.00"))
		{
			click(dashboardclaimsPage.openClaimsLavanteLinks().get(2));
			String actualData3Amount = claimsPage.amountOpen().getText();
			String actualData3Amoun1 = claimsPage.amountTotal().getText();
			String actualData3Count = claimsPage.numberOpen().getText();
			String actualData3Count1 = claimsPage.numberTotal().getText();
			expStatus = "Open";
			actStatus = claimsPage.claimbyStatus().getText();
			actStatus1= claimsPage.claimStatus().getText();
			softAssert.assertEquals(actStatus, expStatus);
			softAssert.assertEquals(actStatus1, expStatus);
			softAssert.assertEquals(actualData3Amount, expectedData3Amount);
			softAssert.assertEquals(actualData3Amoun1, expectedData3Amount);
			softAssert.assertEquals(actualData3Count, expectedData3Count);
			softAssert.assertEquals(actualData3Count1, expectedData3Count);
			DtFormat = new SimpleDateFormat("MM/dd/yy");
			date = new Date();
			expDate = DtFormat.format(date).toString();
			actDate = claimsPage.startDate().getText();
			actualDate = actDate.split("/");
			actualMonth1 = actualDate[0];
			actualDate1 = actualDate[1];
			expectedDate = expDate.split("/");
			expectedMonth1 = expectedDate[0];
			expectedDate1 = expectedDate[1];
			actualmonth2 = Integer.parseInt((actualMonth1));
			actualdate2 = Integer.parseInt((actualDate1));
			expectedmonth2= Integer.parseInt(expectedMonth1);
			expecteddate2 = Integer.parseInt(expectedDate1);
			flag = 1;
			flag1= 1;
		if ((expecteddate2-actualdate2)<= 30) {
			flag1 = 1 ;
		}
		flagData=true;
		softAssert.assertTrue(flagData, "Please recheck the data..! Open Claims count is equal to zero..!");
		softAssert.assertEquals(flag, flag1);
		click(claimsPage.backButton());
		}
		
		click(dashboardclaimsPage.claimsInProcessExpand());
		for (int i=0; i<dashboardclaimsPage.claimsInProcessLinks().size();i++){
			String expData = dashboardclaimsPage.claimsInProcessLinks().get(i).getText();
			click(dashboardclaimsPage.claimsInProcessLinks().get(i));
			String actOpenAmount  = claimsPage.amountInProcess().getText();
			String actTotalAmount = claimsPage.amountTotal().getText();
			expStatus = "Process";
			actStatus = claimsPage.claimbyStatus().getText();
			actStatus1= claimsPage.claimStatus().getText();
			softAssert.assertEquals(actOpenAmount, expData);
			softAssert.assertEquals(actStatus, expStatus);
			softAssert.assertEquals(actStatus1, expStatus);
			softAssert.assertEquals(actOpenAmount, expData);
			softAssert.assertEquals(actTotalAmount, expData);
			click(claimsPage.backButton());
			
		}
		
	
		click(dashboardclaimsPage.claimsOnHoldExpand());
		for (int i=0; i<dashboardclaimsPage.claimsOnHoldLinks().size();i++){
			String expData = dashboardclaimsPage.claimsOnHoldLinks().get(i).getText();
			click(dashboardclaimsPage.claimsOnHoldLinks().get(i));
			String actOpenAmount  = claimsPage.amountHold().getText();
			expStatus = "Hold";
			actStatus = claimsPage.claimbyStatus().getText();
			actStatus1= claimsPage.claimStatus().getText();
			softAssert.assertEquals(actOpenAmount, expData);
			softAssert.assertEquals(actStatus, expStatus);
			softAssert.assertEquals(actStatus1, expStatus);
			click(claimsPage.backButton());
			
		}
		
		
	}
	
	@Test(priority = 2)
	public void ClaimsByStatusChart() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(6000);
		Reporter.log("Verifying Claims by Status Chart:");
		click(dashboardclaimsPage.claimsByStatus());
		click(dashboardclaimsPage.claimByStatusDataTable());
		String expOpenAmount = dashboardclaimsPage.openAmountClaimsbyStatus().getText();
		String expOpenCount = dashboardclaimsPage.openCount().getText();
		String expStatus0 = "Open";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(0));
		if (expOpenAmount.equals("$0.00") && expOpenCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		String actStatus = claimsPage.claimbyStatus().getText();
		softAssert.assertEquals(actStatus, expStatus0);
		String actOPenAmount = claimsPage.amountOpen().getText();
		String actAmountTotal = claimsPage.amountTotal().getText();
		String actNumberOpen = claimsPage.numberOpen().getText();
		String actNumberTotal = claimsPage.numberTotal().getText();
		softAssert.assertEquals(actOPenAmount, expOpenAmount);
		softAssert.assertEquals(actAmountTotal, expOpenAmount);
		softAssert.assertEquals(actNumberOpen, expOpenCount);
		softAssert.assertEquals(actNumberTotal, expOpenCount);
		click(claimsPage.backButton());
		
		
		waitForTime(6000);
		click(dashboardclaimsPage.claimsByStatus());
		click(dashboardclaimsPage.claimByStatusDataTable());
		String expInProcessAmount = dashboardclaimsPage.inProcessAmount().getText();
		String expinprocessCount  = dashboardclaimsPage.openCount().getText();
		String expStatus1 = "In Process";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(1));
		if (expInProcessAmount.equals("$0.00") && expinprocessCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		else{
				String actInProcessAmount = claimsPage.amountInProcess().getText();
				softAssert.assertEquals(actInProcessAmount,expInProcessAmount);
				String actStatus1 = claimsPage.claimbyStatus().getText();
				softAssert.assertEquals(actStatus1, expStatus1);
				click(claimsPage.backButton());		
			}
			
		
	waitForTime(8000);
	click(dashboardclaimsPage.claimsByStatus());
	click(dashboardclaimsPage.claimByStatusDataTable());
	waitForTime(3000);
	String expProcessedAmount = dashboardclaimsPage.processedAmount().getText();
	String expProcessedCount = dashboardclaimsPage.processedCount().getText();
	click(dashboardclaimsPage.claimByStatusTableLinks().get(2));
	String expStatus2 = "Processed";
	if (expProcessedAmount.equals("$0.00") && expProcessedCount.equals("0")){
		String ExpMessage = "There are no claims available";
		String actMessage = claimsPage.noClaimsText().getText();
		softAssert.assertEquals(ExpMessage, actMessage);
		click(claimsPage.backButtonInNoClaims());
	}
	else{
		String actProcessedAmount = claimsPage.amountProcessed().getText();
		String actProcessedAmount1 = claimsPage.amountTotal().getText();
		String actNumberProcessed = claimsPage.numberProcessed().getText();
		String actNumberProcessed1 = claimsPage.numberTotal().getText();
		String actStatus2 = claimsPage.claimbyStatus().getText();
		softAssert.assertEquals(actStatus2, expStatus2);
		softAssert.assertEquals(actProcessedAmount, expProcessedAmount);
		softAssert.assertEquals(actProcessedAmount1, expProcessedAmount);
		softAssert.assertEquals(actNumberProcessed, expProcessedCount);
		softAssert.assertEquals(actNumberProcessed1, expProcessedCount);
		click(claimsPage.backButton());		
		}
		
	waitForTime(8000);
	click(dashboardclaimsPage.claimsByStatus());
	click(dashboardclaimsPage.claimByStatusDataTable());
	waitForTime(3000);
	String expVoidAmount = dashboardclaimsPage.voidAmount().getText();
	String expVoidCount = dashboardclaimsPage.voidCount().getText();
	String expStatus3 = "Void";
	click(dashboardclaimsPage.claimByStatusTableLinks().get(3));
	if (expVoidAmount.equals("$0.00") && expVoidCount.equals("0")){
		String ExpMessage = "There are no claims available";
		String actMessage = claimsPage.noClaimsText().getText();
		softAssert.assertEquals(ExpMessage, actMessage);
		click(claimsPage.backButtonInNoClaims());
		
	}
	else{
		String actVoidAmount = claimsPage.amountVoid().getText();
		String actVoidAmount1 = claimsPage.amountTotal().getText();
		String actVoidCount = claimsPage.numberVoid().getText();
		String actVoidCount1 = claimsPage.numberTotal().getText();
		String actStatus3 = claimsPage.claimbyStatus().getText();
		softAssert.assertEquals(actStatus3, expStatus3);
		softAssert.assertEquals(actVoidAmount,expVoidAmount);
		softAssert.assertEquals(actVoidAmount1,expVoidAmount);
		softAssert.assertEquals(actVoidCount, expVoidCount);
		softAssert.assertEquals(actVoidCount1, expVoidCount);
		click(claimsPage.backButton());		
		}
	
	waitForTime(8000);
	click(dashboardclaimsPage.claimsByStatus());
	click(dashboardclaimsPage.claimByStatusDataTable());
	waitForTime(3000);
	String expOpenVoidedAmount = dashboardclaimsPage.voidAmount().getText();
	String expOpenVoidedCount = dashboardclaimsPage.voidCount().getText();
	String expStatus4 = "Open Voided";
	click(dashboardclaimsPage.claimByStatusTableLinks().get(4));
	if (expOpenVoidedAmount.equals("$0.00") && expOpenVoidedCount.equals("0")){
		String ExpMessage = "There are no claims available";
		String actMessage = claimsPage.noClaimsText().getText();
		softAssert.assertEquals(ExpMessage, actMessage);
		click(claimsPage.backButtonInNoClaims());
	}
	else{
		String actOpenVoidedAmount = claimsPage.amountopenVoided().getText();
		String actOpenVoidedAmount1 = claimsPage.amountTotal().getText();
		String actOpenVoidedCount = claimsPage.numberVoid().getText();
		String actOpenVoidedCount1 = claimsPage.numberTotal().getText();
		String actStatus4 = claimsPage.claimbyStatus().getText();
		softAssert.assertEquals(actStatus4, expStatus4);
		softAssert.assertEquals(actOpenVoidedAmount,expOpenVoidedAmount);
		softAssert.assertEquals(actOpenVoidedAmount1,expOpenVoidedAmount);
		softAssert.assertEquals(actOpenVoidedCount, expOpenVoidedCount);
		softAssert.assertEquals(actOpenVoidedCount1, expOpenVoidedCount);
		click(claimsPage.backButton());		
		}
	
	
	
	}
	
	@Test(priority = 3)
	public void AllClaimsChart() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(3000);
		Reporter.log("Verifying All Claims Chart :");
		click(dashboardclaimsPage.allClaimsSelectChart());
		click(dashboardclaimsPage.allClaimsDataTable());
		String expAmount = dashboardclaimsPage.amountValue().get(0).getAttribute("innerHTML");
		String expNumber = dashboardclaimsPage.numberValue().get(0).getAttribute("innerHTML");
		click(dashboardclaimsPage.amountLinks().get(0));
		String actAmount = claimsPage.amountTotal().getText();
		String actNUmber = claimsPage.numberTotal().getText();
		softAssert.assertEquals(actAmount,expAmount);
		softAssert.assertEquals(actNUmber, expNumber);
		click(claimsPage.backButton());
		
	}

	@Test(priority = 4)
	public void ClaimsByTypeChart() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(3000);
		Reporter.log("Verifying Claims By Type Chart");
		click(dashboardclaimsPage.claimsByTypeSelectChart());
		fluentwait(dashboardclaimsPage.claimsByTypeDataTable());
		click(dashboardclaimsPage.claimsByTypeDataTable());
		fluentwait(dashboardclaimsPage.duplicateAmount());
		String expDuplicateAmount = dashboardclaimsPage.duplicateAmount().getText();
		String expDuplicateCount  = dashboardclaimsPage.duplicateCount().getText();
		String expStatus1 = "Duplicate";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(0));
		if (expDuplicateAmount.equals("$0.00") && expDuplicateCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		else{
				String actAmountDuplicate = claimsPage.amountTotal().getText();
				softAssert.assertEquals(actAmountDuplicate,expDuplicateAmount);
				String actNumberTotal = claimsPage.numberTotal().getText();
				softAssert.assertEquals(actNumberTotal, expDuplicateCount);
				String actStatus1 = claimsPage.claimbyStatus().getText();
				softAssert.assertEquals(actStatus1, expStatus1);
				click(claimsPage.backButton());		
			}
		
		waitForTime(6000);
		click(dashboardclaimsPage.claimsByTypeSelectChart());
		click(dashboardclaimsPage.claimsByTypeDataTable());
		fluentwait(dashboardclaimsPage.miscAmount());
		String expMISCAmount = dashboardclaimsPage.miscAmount().getText();
		String expMISCCount  = dashboardclaimsPage.miscCount().getText();
		expStatus1 = "Misc";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(1));
		if (expMISCAmount.equals("$0.00") && expMISCCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		else{
			String actMISCAmount = claimsPage.amountTotal().getText();
			softAssert.assertEquals(actMISCAmount,expMISCAmount);
			String actMISCCount = claimsPage.numberTotal().getText();
			softAssert.assertEquals(actMISCCount, expMISCCount);
			String actStatus1 = claimsPage.claimbyStatus().getText();
			softAssert.assertEquals(actStatus1, expStatus1);
			click(claimsPage.backButton());
			}
		
		waitForTime(6000);
		click(dashboardclaimsPage.claimsByTypeSelectChart());
		click(dashboardclaimsPage.claimsByTypeDataTable());
		fluentwait(dashboardclaimsPage.overpaymentAmount());
		String expOverpaymentAmount = dashboardclaimsPage.overpaymentAmount().getText();
		String expOverpaymentCount  = dashboardclaimsPage.overPaymentCount().getText();
		expStatus1 = "Overpayment";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(2));
		if (expOverpaymentAmount.equals("$0.00") && expOverpaymentCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		else{
			String actOverpaymentAmount = claimsPage.amountTotal().getText();
			softAssert.assertEquals(actOverpaymentAmount,expOverpaymentAmount);
			String actOverpaymentCount = claimsPage.numberTotal().getText();
			softAssert.assertEquals(actOverpaymentCount, expOverpaymentCount);
			String actStatus1 = claimsPage.claimbyStatus().getText();
			softAssert.assertEquals(actStatus1, expStatus1);
			click(claimsPage.backButton());		
			
			
			}
		
		waitForTime(6000);
		click(dashboardclaimsPage.claimsByTypeSelectChart());
		click(dashboardclaimsPage.claimsByTypeDataTable());
		fluentwait(dashboardclaimsPage.rebateAmount());
		String expRebateAmount = dashboardclaimsPage.rebateAmount().getText();
		String expRebateCount  = dashboardclaimsPage.rebateCount().getText();
		expStatus1 = "Rebate";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(3));
		if (expRebateAmount.equals("$0.00") && expRebateCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		else{
			String actRebateAmount = claimsPage.amountTotal().getText();
			softAssert.assertEquals(actRebateAmount,expRebateAmount);
			String actRebateCount = claimsPage.numberTotal().getText();
			softAssert.assertEquals(actRebateCount, expRebateCount);
			String actStatus1 = claimsPage.claimbyStatus().getText();
			softAssert.assertEquals(actStatus1, expStatus1);
			click(claimsPage.backButton());		
		
		
		}
		
		waitForTime(6000);
		click(dashboardclaimsPage.claimsByTypeSelectChart());
		click(dashboardclaimsPage.claimsByTypeDataTable());
		fluentwait(dashboardclaimsPage.rebateAmount());
		String expReturnAmount = dashboardclaimsPage.rebateAmount().getText();
		String expReturnCount  = dashboardclaimsPage.rebateCount().getText();
		expStatus1 = "Return";
		click(dashboardclaimsPage.claimByStatusTableLinks().get(4));
		if (expReturnAmount.equals("$0.00") && expReturnCount.equals("0")){
			String ExpMessage = "There are no claims available";
			String actMessage = claimsPage.noClaimsText().getText();
			softAssert.assertEquals(ExpMessage, actMessage);
			click(claimsPage.backButtonInNoClaims());
		}
		else{
			String actReturnAmount = claimsPage.amountTotal().getText();
			softAssert.assertEquals(actReturnAmount,expReturnAmount);
			String actReturnCount = claimsPage.numberTotal().getText();
			softAssert.assertEquals(actReturnCount, expReturnCount);
			String actStatus1 = claimsPage.claimbyStatus().getText();
			softAssert.assertEquals(actStatus1, expStatus1);
			click(claimsPage.backButton());
		
			
			waitForTime(6000);
			click(dashboardclaimsPage.claimsByTypeSelectChart());
			click(dashboardclaimsPage.claimsByTypeDataTable());
			waitForTime(3000);
			String expUACAmount = dashboardclaimsPage.rebateAmount().getText();
			String expUACCount  = dashboardclaimsPage.rebateCount().getText();
			expStatus1 = "UAC";
			click(dashboardclaimsPage.claimByStatusTableLinks().get(5));
			if (expReturnAmount.equals("$0.00") && expReturnCount.equals("0")){
				String ExpMessage = "There are no claims available";
				String actMessage = claimsPage.noClaimsText().getText();
				softAssert.assertEquals(ExpMessage, actMessage);
				click(claimsPage.backButtonInNoClaims());
			}
			else{
				String actUACAmount = claimsPage.amountTotal().getText();
				softAssert.assertEquals(actUACAmount,expUACAmount);
				String actUACCount = claimsPage.numberTotal().getText();
				softAssert.assertEquals(actUACCount, expUACCount);
				actStatus1 = claimsPage.claimbyStatus().getText();
				softAssert.assertEquals(actStatus1, expStatus1);
				click(claimsPage.backButton());	
			
		}
		
	}
}
	
	@Test(priority = 6)
	public void ClaimsByOrganizationChart() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(3000);
		fluentwait(dashboardclaimsPage.claimsByOrganizationChart());
		click(dashboardclaimsPage.claimsByOrganizationChart());
		fluentwait(dashboardclaimsPage.dataTable());
		click(dashboardclaimsPage.dataTable());
		waitForTime(3000);
		String expBAUAmount = "";
		String expBAUCount = "";
		
		for(int i=0;i<dashboardclaimsPage.organizationLink().size();i++){
			String text=dashboardclaimsPage.organizationLink().get(i).getText();
			if(text.equalsIgnoreCase("Other")){
				expBAUAmount = dashboardclaimsPage.Amount().get(i).getAttribute("textContent");
				expBAUCount = dashboardclaimsPage.Count().get(i).getAttribute("textContent");
				click(dashboardclaimsPage.organizationLink().get(i));
				fluentwait(claimsPage.amountTotal());
				String actBAUAmount = claimsPage.amountTotal().getText();
				String actBAUCount = claimsPage.numberTotal().getText();
				String actStatus = claimsPage.claimbyStatus().getText();
				String actOrganization = claimsPage.claimsListOrganizationValue().getText();
				softAssert.assertEquals(actBAUAmount, expBAUAmount);
				softAssert.assertEquals(actBAUCount, expBAUCount);
				softAssert.assertEquals(actStatus, "Other");
				softAssert.assertEquals(actOrganization, " ");
				break;
			}
		}
	
		
	}

	@Test(priority = 5)
	public void BatchedClaimsInvoicesTable() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		waitForTime(6000);
		Reporter.log("Verifying Batched Claims Table: ");
		click(dashboardclaimsPage.batchedclaims());
		String expDate = dashboardclaimsPage.batchedClaimsLinks().get(0).getText();
		String expBatch = dashboardclaimsPage.batchId().get(0).getText();
		String expOpen = dashboardclaimsPage.openTotal().get(0).getText();
		String[] expectedOpen1 = expOpen.split("/");
		String expectedOpen = expectedOpen1[0];
		String expTotal = dashboardclaimsPage.openTotal().get(0).getText();
		String[] expectedTotal1 = expTotal.split("/");
		String expectedTotal = expectedTotal1[1];
		String expAmount = dashboardclaimsPage.batchedClaimsAmount().get(0).getText();
		String expBatchType = dashboardclaimsPage.batchType().get(0).getText();
		String[] expectedBatchType1 = expBatchType.split("-");
		String expectedBatchType = expectedBatchType1[0];
		
		
		click(dashboardclaimsPage.batchedClaimsLinks().get(0));
		
		String actualDate = claimsPage.startDate().getText();
		String actClaimId = claimsPage.claimId().get(0).getText();
		String actualClaimId = actClaimId.substring(0,5);
		String actualOpen = claimsPage.numberOpen().getText();
		String actTotal = claimsPage.numberProcessed().getText();
		String actTotal1 = claimsPage.numberTotal().getText();
		String actAmount = claimsPage.amountTotal().getText();
		String actAmount1 = claimsPage.amountProcessed().getText();
		String actOrganization = claimsPage.organization().get(0).getText();
		
		
		softAssert.assertEquals(actualDate, expDate);
		softAssert.assertEquals(actualClaimId, expBatch);
		softAssert.assertEquals(actualOpen, expectedOpen);
		softAssert.assertEquals(actTotal, expectedTotal);
		softAssert.assertEquals(actTotal1, expectedTotal);
		softAssert.assertEquals(actAmount, expAmount);
		softAssert.assertEquals(actAmount1, expAmount);
		softAssert.assertEquals(actOrganization, expectedBatchType);
		
		click(claimsPage.backButton());
		
		click(dashboardclaimsPage.invoicesLink());
		expDate = dashboardclaimsPage.invoicesDates().get(0).getText();
		String expNumber = dashboardclaimsPage.invoicesNumber().get(0).getText();
		expAmount = dashboardclaimsPage.invoicesAmount().get(0).getText();
		String expPaid = dashboardclaimsPage.invoicesPaid().get(0).getText();
		String expInvoiceType = dashboardclaimsPage.invoicesType().get(0).getText();
		
		String expectedInvoicetype = "";
		if(expInvoiceType.length()>1){
			expInvoiceType=expInvoiceType.substring(0,3);
		}
				
		
		click(dashboardclaimsPage.invoicesDates().get(0));
		actualDate = invoicePage.date().getText();
		softAssert.assertTrue(actualDate.contains(expDate));
		String actNumber = invoicePage.invoiceNumber1().getText();
		String actualNUmber1[] = actNumber.split("\\(");
		String actualNumber = actualNUmber1[0];
		String actualAmount = invoicePage.totalAmountDInvCost().getText();
		String actualPaid = invoicePage.datePaidD().getText();
		String actualInvoiceType = invoicePage.currencyD().getText();
		softAssert.assertEquals(actualNumber,expNumber);
		softAssert.assertEquals(actualAmount,expAmount);
		softAssert.assertEquals(actualPaid, expPaid);
		if(expInvoiceType.length()>1){
			softAssert.assertEquals(actualInvoiceType, expectedInvoicetype);
		}
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





		