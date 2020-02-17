package com.lavante.sim.customer.TestScripts.Dashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;
import com.lavante.sim.customer.pageobjects.HomePage.HomePage;

/**
 * SIM-12641
 * 
 * @author subhas.bv
 *
 */
public class OnboardingProgressTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author subhas.bv
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod
	public void before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","Home");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.click(enobjdashBoard.customerDashboardlnk());
	}

	/***
	 * SIM-12641 File Cleanse Statistics should display the count of duplicate
	 * records
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 * 
	 */
	@Test
	public void verifyFileCleanseStatsReportTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("------Test Started for verifyFileCleanseStatsReportTest --------"+currenttime());
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.click(enobjOnboardingProgress.FileCleanseStatsChartDropDwnVbar());
		lavanteUtils.click(enobjOnboardingProgress.FileCleanseStatsChartDropDwn());
		lavanteUtils.click(enobjOnboardingProgress.DataTableView());

		lavanteUtils.fluentwait(enobjOnboardingProgress.fileCleanseStatisticsTableHeader().get(0));
		HashMap<String, Integer> tableValues = new HashMap<>();
		int size = enobjOnboardingProgress.fileCleanseStatisticsTableHeader().size();

		for (int i = 0; i < size; i++) {

			String key = lavanteUtils.getText(enobjOnboardingProgress.fileCleanseStatisticsTableHeader().get(i));
			String value = lavanteUtils.getText(enobjOnboardingProgress.fileCleanseStatisticsTableData().get(i));

			key = key.replaceAll("\\s", "");
			System.out.println(" Key " + key + " Value " + value);
			tableValues.put(key, Integer.parseInt(value));
		}

		String ErroneousRecords = "select sum(ErrorCount) from FileLoad where CustomerID=" + customerID			+ " and FileLoadType_KVID=101";
		ErroneousRecords = lavanteUtils.fetchDBdata(ErroneousRecords);
		String PotentialNetworkMatch = "select sum(PotentialMatchCount) from FileLoad where CustomerID=" + customerID		+ " and FileLoadType_KVID=101";
		PotentialNetworkMatch = lavanteUtils.fetchDBdata(PotentialNetworkMatch);
		String UpdatedRecords = "select sum(MergedCount) from FileLoad where CustomerID=" + customerID	+ " and FileLoadType_KVID=101";
		UpdatedRecords = lavanteUtils.fetchDBdata(UpdatedRecords);
		String UniquelyImportedRecords = "select sum(UniqueCount) from FileLoad where CustomerID=" + customerID	+ " and FileLoadType_KVID=101";
		UniquelyImportedRecords = lavanteUtils.fetchDBdata(UniquelyImportedRecords);
		String PotentialDuplicates = "select sum(DuplicateCount) from FileLoad where CustomerID=" + customerID	+ " and FileLoadType_KVID=101";
		PotentialDuplicates = lavanteUtils.fetchDBdata(PotentialDuplicates);
		boolean flag = false;
		if (tableValues.get("ErroneousRecords") == Integer.parseInt(ErroneousRecords)) {
			flag = true;
		}
		softAssert.assertTrue(flag,
				" Verification failed in File Cleanse Statistics ErroneousRecords value in UI is not equal to value from DB ");

		flag = false;
		if (tableValues.get("PotentialNetworkMatch") == Integer.parseInt(PotentialNetworkMatch)) {
			flag = true;
		}

		softAssert.assertTrue(flag,
				" Verification failed in File Cleanse Statistics PotentialNetworkMatch value in UI is not equal to value from DB ");

		flag = false;
		if (tableValues.get("UpdatedRecords") == Integer.parseInt(UpdatedRecords)) {
			flag = true;
		}
		softAssert.assertTrue(flag,
				" Verification failed in File Cleanse Statistics UpdatedRecords value in UI is not equal to value from DB ");

		flag = false;
		if (tableValues.get("UniquelyImportedRecords") == Integer.parseInt(UniquelyImportedRecords)) {
			flag = true;
		}
		softAssert.assertTrue(flag,
				" Verification failed in File Cleanse Statistics UniquelyImportedRecords value in UI is not equal to value from DB ");

		flag = false;
		if (tableValues.get("PotentialDuplicates") == Integer.parseInt(PotentialDuplicates)) {
			flag = true;
		}
		softAssert.assertTrue(flag,
				" Verification failed in File Cleanse Statistics PotentialDuplicates value in UI is not equal to value from DB ");
		softAssert.assertAll();

		Reporter.log("------------Test ended for verifyFileCleanseStatsReportTest ---------"+currenttime());
	}


	
	/**
	 * Verify the Headlines values under Onboarding Progress in Supplier tab
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */

	@Test
	public void HeadlinesCountTest() throws Exception {
		Reporter.log("Test Started for dashboardTest : "+ currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		SoftAssert softAssert=new SoftAssert();

		String suppLoaded = enobjdashBoard.supplierLoaded().getText().replaceAll(",", "");
		String suppInvited = enobjdashBoard.supplierInvited().getText().replaceAll(",", "");
		String suppNeedToComplete = enobjdashBoard.supplierCompleteInv().getText().replaceAll(",", "");
		String suppCompleted = enobjdashBoard.supplierCompleteAllInv().getText().replaceAll(",", "");
		String suppApproved = enobjdashBoard.supplierApprovedByAll().getText().replaceAll(",", "");

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		enobjsupplierPage.searchResultsFilterBy("All");
		enobjsupplierPage.selectChangeView("Suppliers");

		String results = enobjsupplierPage.searchResults().getText();
		Reporter.log(results+"Suppliers loaded is not matching"+suppLoaded,true);
		softAssert.assertTrue(results.contains(suppLoaded), "Suppliers loaded is not matching");

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("filterAll", "");
		dataMap.put("Tab", "Invite");
		dataMap.put("InviteProfStatus", "Invited#Incomplete#Approved#Pending#Pending Validation#No Response");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		results = enobjsupplierPage.searchResults().getText();
		Reporter.log(results+"Suppliers needing to suppInvited, count :"+suppInvited,true);
		softAssert.assertTrue(results.contains(suppInvited), "Suppliers Invited count is not matching");
		
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("filterAll", "");
		dataMap.put("Tab", "Invite");
		dataMap.put("InviteProfStatus", "Incomplete#Pending Validation");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		results = enobjsupplierPage.searchResults().getText();
		Reporter.log(results+"Suppliers needing to complete invitations, count :"+suppNeedToComplete,true);
		softAssert.assertTrue(results.contains(suppNeedToComplete), "Suppliers needing to complete invitations, count is not matching"+results);
		
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("filterAll", "");
		dataMap.put("Tab", "Enterprise");
		dataMap.put("ProfStatus", "Approved");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		results = enobjsupplierPage.searchResults().getText();
		Reporter.log(results+"Suppliers completed all invitations count :"+suppApproved,true);
		softAssert.assertTrue(results.contains(suppApproved), "Suppliers completed all invitations, count is not matching,Actual:"+results);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Headlines Count Test at:" + currenttime());
	}
	
	
	
	
	@AfterClass
	public void close() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
