package com.lavante.sim.supplier.TestScripts;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ListCostChangesTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

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

		// Login
		// SupKroger
		List<?> listofdatafrm = lavanteUtils.login("SupplierKroger", browser);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(dataMap);
	}

	public void Before() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Agreements");
		dataMap.put("subtab", "manageListCostChanges");
		enobjhomePage.selectTab(dataMap);
	}

	@Test
	public void addEditCostChangeTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script addEditCostChange Test " + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		List<WebElement> costChaID = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID");
		String cChange = costChaID.get(0).getText().trim();

		dataMap.put("ActEdit", "");
		objListCostChangePage.actions(dataMap);

		dataMap.clear();
		costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		lavanteUtils.fluentwait(objCostChangePage.SaveAndSubmitBtn());
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.editCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		lavanteUtils.click(objListCostChangePage.ClearLink());
		dataMap.put("CostChangeID", cChange);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		costChaID = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID");
		String actcChange = costChaID.get(0).getText().trim();
		Reporter.log(
				"List cost change not created/Invalid cost change ID, Expected: " + cChange + " Actual: " + actcChange);
		softAssert.assertEquals(actcChange, cChange,
				"List cost change not created/Invalid cost change ID, Expected: " + cChange + " Actual: " + actcChange);

		costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		softAssert.assertAll();
		Reporter.log("End test script addEditCostChange Test " + currenttime());
	}

	/**
	 * Add Cost Change and Add Delete
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void addDeleteCostChangeTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script addDeleteCostChange Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);
		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		dataMap.put("ActDelete", "");
		objListCostChangePage.actions(dataMap);

		dataMap.clear();
		lavanteUtils.clicks(objListCostChangePage.ClearLink());
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		String expected = "No Results";
		actual = lavanteUtils.getText(objListCostChangePage.VeirfyNoResultTxt());
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, expected,
				"List cost change not created/Invalid cost change description, Expected: " + expected + " Actual: "
						+ actual);
		softAssert.assertAll();
		Reporter.log("End test script addDeleteCostChange Test " + currenttime());
	}

	@Test
	public void addSubmitCostChangeTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script addSubmitCostChange Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Agreements");
		dataMap.put("subtab", "manageListCostChanges");
		enobjhomePage.selectTab(dataMap);

		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		dataMap.put("ActSubmit", "");
		objListCostChangePage.actions(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.ClearLink());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		List<WebElement> costChaStatus = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Status");
		actual = lavanteUtils.getText(costChaStatus.get(0));
		String expected = "Pending";
		Reporter.log("Invalid status, Expected: " + costChangeDesc + " Actual: " + actual);
		softAssert.assertEquals(actual, expected, "Invalid status, Expected: " + expected + " Actual: " + actual);

		softAssert.assertAll();
		Reporter.log("End test script addSubmitCostChange Test " + currenttime());
	}

	/**
	 * Add Comment via Public Comment on Cost change
	 * 
	 * Note: Comment is not verified on other login,Will cover with Private
	 * Comment Scenario
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void addCostChangeWithPublicCommentsTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script addCostChangeWithComments Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String costChangeDesc = "AutoCostChangeDesc" + currenttime();
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.ClearLink());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		dataMap.put("ActAddComments", "");
		objListCostChangePage.actions(dataMap);

		String comments = "AutoComments" + currenttime();
		lavanteUtils.fluentwait(objListCostChangePage.ComSecCloseIcon());
		dataMap.put("EnterComment", comments);
		dataMap.put("PublicComment", "");
		objListCostChangePage.addComment(dataMap);
		lavanteUtils.clicks(objListCostChangePage.ComSecCloseIcon());

		lavanteUtils.fluentwait(objListCostChangePage.ClearLink());
		dataMap.put("ActAddComments", "");
		objListCostChangePage.actions(dataMap);

		Boolean flag = false;
		String actualComment = "";
		List<WebElement> publicComments = objListCostChangePage.PublicCommentsList();
		for (int i = 0; i < publicComments.size(); i++) {
			actualComment = publicComments.get(i).getText();
			if (actualComment.equals(comments)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added and searched , Expected :" + comments + ", Actual :"
				+ actualComment);
		softAssert.assertTrue(flag, "Mismatch in the public comments added and searched , Expected :" + comments
				+ ", Actual :" + actualComment);

		softAssert.assertAll();
		Reporter.log("End test script addCostChangeWithComments Test " + currenttime());
	}

	/**
	 * Create CostChange via ItemsTest
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void createCostChangeFromItemsTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script createCostChangeFromItems Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("maintab", "Items");
		enobjhomePage.selectTab(dataMap);

		WebElement itemCodeObj = objItemSearch.iterateSearchHeaderFindColList("Item Code").get(0);
		String itemCode = lavanteUtils.getText(itemCodeObj);
		WebElement caseGTINObj = objItemSearch.iterateSearchHeaderFindColList("Case GTIN").get(0);
		lavanteUtils.clicks(caseGTINObj);

		dataMap.put("Action", "Create cost change");
		objItemSearch.ItemSelectionAction(dataMap);

		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("CaseGTINDesc", "");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.editCostChange(dataMap);

		dataMap.put("maintab", "Agreements");
		dataMap.put("subtab", "manageListCostChanges");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		assertEquals(actual, costChangeDesc, "List cost change not created/Invalid cost change description, Expected: "
				+ costChangeDesc + " Actual: " + actual);

		List<WebElement> costChaID = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID");
		lavanteUtils.clicks(costChaID.get(0));

		lavanteUtils.fluentwait(objListCostViewPage.BackLink);
		actual = objListCostViewPage.getHeaderInfoValue("Cost Change Description");
		Reporter.log("Invalid cost change description, Expected: " + costChangeDesc + " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"Invalid cost change description, Expected: " + costChangeDesc + " Actual: " + actual);

		softAssert.assertAll();
		Reporter.log("End test script createCostChangeFromItems Test " + currenttime());

	}

	/**
	 * Edit and verify value of Create Cost Change
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void editValueCreateCostChangeTest() throws FileNotFoundException, IOException, SQLException {

		Reporter.log("Start test script eidtValueCreateCostChange Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.waitForTime(3000);
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);
		lavanteUtils.waitForTime(2000);
		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		dataMap.put("ActEdit", "");
		objListCostChangePage.actions(dataMap);

		lavanteUtils.fluentwait(objCostChangePage.SaveAsDraftLink());
		lavanteUtils.clicks(objCostChangePage.ListItemsCheckBox().get(0));

		dataMap.put("EditValue", "");
		objCostChangePage.itemActions(dataMap);

		lavanteUtils.fluentwait(objCostChangePage.ApplyBtn());
		dataMap.put("EditBracketMin", "31");
		dataMap.put("EditBracketMax", "40");
		dataMap.put("EditCurrency", "USD");
		objCostChangePage.editfillItemsCostChange(dataMap);

		lavanteUtils.clicks(objCostChangePage.SaveAsDraftLink());

		lavanteUtils.waitForTime(3000);
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);
		lavanteUtils.fluentwait(objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID").get(0));
		lavanteUtils.clicks(objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID").get(0));

		String actualBracketMin = lavanteUtils
				.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Min").get(0)).trim();
		String actualBracketMax = lavanteUtils
				.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Max").get(0)).trim();
		String actualCurrency = lavanteUtils
				.getText(objListCostViewPage.iterateSearchHeaderFindColList("Currency").get(0)).trim();

		Reporter.log("Edited Bracket Min value in items, Expected: " + dataMap.get("EditBracketMin") + " Actual: "
				+ actualBracketMin);
		softAssert.assertEquals(actualBracketMin, dataMap.get("EditBracketMin"),
				"Edited Bracket Min value in items not matching, Expected: " + dataMap.get("EditBracketMin")
						+ " Actual: " + actualBracketMin);
		Reporter.log("Edited Bracket Max value in items, Expected: " + dataMap.get("EditBracketMax") + " Actual: "
				+ actualBracketMax);
		softAssert.assertEquals(actualBracketMax, dataMap.get("EditBracketMax"),
				"Edited Bracket Max value in items not matching, Expected: " + dataMap.get("EditBracketMax")
						+ " Actual: " + actualBracketMax);
		Reporter.log(
				"Edited Currency in items, Expected: " + dataMap.get("EditCurrency") + " Actual: " + actualCurrency);
		softAssert.assertTrue(actualCurrency.contains(dataMap.get("EditCurrency")),
				"Edited Currency in items not matching, Expected: " + dataMap.get("EditCurrency") + " Actual: "
						+ actualCurrency);
		softAssert.assertAll();
		Reporter.log("End test script eidtValueCreateCostChange Test " + currenttime());
	}

	/**
	 * Verify Duplicate Lines option in create cost change
	 * 
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void verifyDuplicateLinesTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script verifyDuplicateLines Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");

		objCostChangePage.createCostChange(dataMap);
		lavanteUtils.waitForTime(3000);

		lavanteUtils.clicks(objCostChangePage.ListItemsCheckBox().get(0));

		dataMap.put("Duplicate", "");
		objCostChangePage.itemActions(dataMap);

		lavanteUtils.fluentwait(objCostChangePage.ListCaseGTINDescTxtBox().get(1));
		/*
		 * String dupCaseGTIN =
		 * lavanteUtils.getText(objCostChangePage.ListCaseGTINDescTxtBox().get(1
		 * )); String dupBracketMin =
		 * lavanteUtils.getText(objCostChangePage.ListBracketMinTxtBox().get(1))
		 * ; String dupBracketMax =
		 * lavanteUtils.getText(objCostChangePage.ListBracketMaxTxtBox().get(1))
		 * ; String dupNewCost =
		 * lavanteUtils.getText(objCostChangePage.ListNewCostTxtBox().get(1));
		 * String dupCurrency =
		 * lavanteUtils.getText(objCostChangePage.ListCurrencyDropDwn().get(1));
		 * 
		 * Reporter.log(
		 * "Verify Duplicate line Item value : CaseGTIN, Expected: " +
		 * dataMap.get("CaseGTINDesc") + " Actual: " + dupCaseGTIN);
		 * softAssert.assertEquals(dupCaseGTIN, dataMap.get("CaseGTINDesc"),
		 * "Duplicate line Item value : CaseGTIN not valid, Expected: " +
		 * dataMap.get("CaseGTINDesc") + " Actual: " + dupCaseGTIN);
		 * 
		 * Reporter.log(
		 * "Verify Duplicate line Item value : BracketMin, Expected: " +
		 * dataMap.get("BracketMin") + " Actual: " + dupBracketMin);
		 * softAssert.assertEquals(dupBracketMin, dataMap.get("BracketMin"),
		 * "Duplicate line Item value : BracketMin not valid, Expected: " +
		 * dataMap.get("BracketMin") + " Actual: " + dupBracketMin);
		 * 
		 * Reporter.log(
		 * "Verify Duplicate line Item value : BracketMax, Expected: " +
		 * dataMap.get("BracketMax") + " Actual: " + dupBracketMax);
		 * softAssert.assertEquals(dupBracketMax, dataMap.get("BracketMax"),
		 * "Duplicate line Item value : BracketMax not valid, Expected: " +
		 * dataMap.get("BracketMax") + " Actual: " + dupBracketMax);
		 * 
		 * Reporter.log("Verify Duplicate line Item value : NewCost, Expected: "
		 * + dataMap.get("CaseGTINDesc") + " Actual: " + dupNewCost);
		 * softAssert.assertEquals(dupNewCost, dataMap.get("CaseGTINDesc"),
		 * "Duplicate line Item value : NewCost not valid, Expected: " +
		 * dataMap.get("CaseGTINDesc") + " Actual: " + dupNewCost);
		 * 
		 * Reporter.log(
		 * "Verify Duplicate line Item value : Currency, Expected: " +
		 * dataMap.get("CaseGTINDesc") + " Actual: " + dupCurrency);
		 * softAssert.assertEquals(dupCurrency, dataMap.get("CaseGTINDesc"),
		 * "Duplicate line Item value : Currency not valid, Expected: " +
		 * dataMap.get("CaseGTINDesc") + " Actual: " + dupCurrency);
		 */

		int size = objCostChangePage.ListItemsCheckBox().size();
		Reporter.log("Duplicate lines added from items, Expected : 1 , Actual : " + size);
		softAssert.assertTrue(size > 1, " Duplicate lines added from items");

		softAssert.assertAll();
		Reporter.log("End test script verifyDuplicateLines Test " + currenttime());
	}

	/**
	 * Verify removed Lines option in create cost change
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void verifyRemoveLinesTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script verifyRemoveLines Test " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String costChangeDesc = "AutoCostChangeDesc" + lavanteUtils.generateRandomNumber9OnLength(8);
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.clicks(objCostChangePage.ListItemsCheckBox().get(0));
		dataMap.put("Duplicate", "");
		objCostChangePage.itemActions(dataMap);

		int size = objCostChangePage.ListItemsCheckBox().size();
		Reporter.log("Duplicate lines added from items, Expected : 1 , Actual : " + size);
		softAssert.assertTrue(size > 1, " Duplicate lines added from items not working as expected");

		lavanteUtils.clicks(objCostChangePage.ListItemsCheckBox().get(0));
		dataMap.put("Remove", "");
		objCostChangePage.itemActions(dataMap);
		size = objCostChangePage.ListItemsCheckBox().size();
		Reporter.log("Remove lines from items, Expected : 1 , Actual : " + size);
		softAssert.assertTrue(size == 1, " Remove lines from items not working as expected");

		softAssert.assertAll();
		Reporter.log("End test script verifyRemoveLines Test " + currenttime());
	}

	/**
	 * Verify add and edit cost change
	 * 
	 * @author Subhas.BV
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void viewAddEditCostChangeTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Start test script addEditCostChange Test " + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String costChangeDesc = "AutoCostChangeDesc" + currenttime();
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409");
		dataMap.put("BracketMin", "10");
		dataMap.put("BracketMax", "20");
		dataMap.put("NewCost", "7000");
		dataMap.put("Currency", "EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		dataMap.clear();
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		List<WebElement> costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		String actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		List<WebElement> costChaID = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID");
		lavanteUtils.clicks(costChaID.get(0));

		lavanteUtils.fluentwait(objListCostViewPage.BackLink);
		actual = objListCostViewPage.getHeaderInfoValue("Cost Change Description");
		Reporter.log("Invalid cost change description, Expected: " + costChangeDesc + " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"Invalid cost change description, Expected: " + costChangeDesc + " Actual: " + actual);
		lavanteUtils.clicks(objListCostViewPage.BackLink);

		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		WebElement costChaStaObj = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Status").get(0);
		lavanteUtils.clicks(costChaStaObj);
		lavanteUtils.fluentwait(objListCostChangePage.ActionsDropDwn());
		dataMap.put("ActEdit", "");
		objListCostChangePage.actions(dataMap);
		dataMap.clear();
		costChangeDesc = "AutoCostChangeDesc" + currenttime();
		lavanteUtils.fluentwait(objCostChangePage.SaveAndSubmitBtn());
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.editCostChange(dataMap);
		lavanteUtils.fluentwait(objListCostChangePage.SearchBtn());
		lavanteUtils.click(objListCostChangePage.ClearLink());
		dataMap.put("CostChangeDes", costChangeDesc);
		dataMap.put("Search", "");
		objListCostChangePage.searchListcostChanges(dataMap);

		costChaDes = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change Description");
		actual = lavanteUtils.getText(costChaDes.get(0));
		Reporter.log("List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
				+ " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"List cost change not created/Invalid cost change description, Expected: " + costChangeDesc
						+ " Actual: " + actual);

		costChaID = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID");
		lavanteUtils.clicks(costChaID.get(0));

		lavanteUtils.fluentwait(objListCostViewPage.BackLink);
		actual = objListCostViewPage.getHeaderInfoValue("Cost Change Description");
		Reporter.log("Invalid cost change description, Expected: " + costChangeDesc + " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"Invalid cost change description, Expected: " + costChangeDesc + " Actual: " + actual);
		softAssert.assertAll();
		Reporter.log("End test script addEditCostChange Test " + currenttime());
	}

	/**
	 * Verify edit list cost change in view details page
	 * 
	 * @author Subhas.BV
	 */
	@Test
	public void editListCostInViewDetailsTest() {
		Reporter.log("Start test script editListCostViewDetailsTest Test " + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		List<WebElement> costChaID = objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID");
		lavanteUtils.clicks(costChaID.get(0));

		lavanteUtils.clicks(objListCostViewPage.EditBtn());
		String costChangeDesc = "AutoCostChangeDesc" + currenttime();
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.editCostChange(dataMap);
		lavanteUtils.fluentwait(objListCostViewPage.EditBtn());

		String actual = objListCostViewPage.getHeaderInfoValue("Cost Change Description");
		Reporter.log("Verify edited cost change des, Expected: " + costChangeDesc + " Actual: " + actual);
		softAssert.assertEquals(actual, costChangeDesc,
				"Cost change des is not updated in view details page, Expected: " + costChangeDesc + " Actual: "
						+ actual);

		softAssert.assertAll();
		Reporter.log("End test script editListCostViewDetails Test " + currenttime());

	}

	/**
	 * Verify creating Multiple ListCost Items
	 * 
	 * @author Subhas.BV
	 * 
	 */
	@Test
	public void createMultipleListCostItemsTest() {
		Reporter.log("Start test script createMultipleListCostItems Test " + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String costChangeDesc = "AutoCostChangeDesc" + currenttime();
		dataMap.put("EnterManually", "");
		dataMap.put("CostChangeDesc", costChangeDesc);
		dataMap.put("EffectiveDataType", "Ship");
		dataMap.put("EffectiveStartDate", "18-11-2019");
		dataMap.put("CaseGTINDesc", "3409#3409#3409#3409");
		dataMap.put("BracketMin", "10#30#50#70");
		dataMap.put("BracketMax", "20#40#60#80");
		dataMap.put("NewCost", "70#80#90#100");
		dataMap.put("Currency", "EUR#EUR#EUR#EUR");
		dataMap.put("SaveAsDraft", "");
		objCostChangePage.createCostChange(dataMap);

		lavanteUtils.fluentwait(objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID").get(0));
		lavanteUtils.clicks(objListCostChangePage.iterateSearchHeaderFindColList("Cost Change ID").get(0));
		lavanteUtils.fluentwait(objListCostViewPage.EditBtn());
		int size = dataMap.get("CaseGTINDesc").split("#").length;
		String caseGTIN[] = dataMap.get("CaseGTINDesc").split("#");
		String bracketMin[] = dataMap.get("BracketMin").split("#");
		String bracketMax[] = dataMap.get("BracketMax").split("#");
		String newCost[] = dataMap.get("NewCost").split("#");
		String currency[] = dataMap.get("Currency").split("#");
		for (int i = 0; i < size; i++) {

			Reporter.log("Verify caseGTIN in view details page, Expected : " + caseGTIN[i] + ", Actual : "
					+ lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Case GTIN").get(i)));
			softAssert.assertEquals(
					lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Case GTIN").get(i)),
					caseGTIN[i],
					" caseGTIN in view details page not matching , Expected : " + caseGTIN[i] + ", Actual : "
							+ lavanteUtils
									.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Min").get(i)));

			Reporter.log("Verify bracketMin in view details page, Expected : " + bracketMin[i] + ", Actual : "
					+ lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Min").get(i)));
			softAssert.assertEquals(
					lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Min").get(i)),
					bracketMin[i],
					" bracketMin in view details page not matching , Expected : " + bracketMin[i] + ", Actual : "
							+ lavanteUtils
									.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Min").get(i)));

			Reporter.log("Verify bracketMax in view details page, Expected : " + bracketMax[i] + ", Actual : "
					+ lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Max").get(i)));
			softAssert.assertEquals(
					lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Max").get(i)),
					bracketMax[i],
					" bracketMax in view details page not matching , Expected : " + bracketMax[i] + ", Actual : "
							+ lavanteUtils
									.getText(objListCostViewPage.iterateSearchHeaderFindColList("Bracket Max").get(i)));

			/*
			 * Reporter.log("Verify newCost in view details page, Expected : " +
			 * newCost[i] + ", Actual : " +
			 * lavanteUtils.getText(objListCostViewPage.
			 * iterateSearchHeaderFindColList("New Cost").get(i)));
			 * softAssert.assertEquals(
			 * lavanteUtils.getText(objListCostViewPage.
			 * iterateSearchHeaderFindColList("New Cost").get(i)), newCost[i],
			 * " newCost in view details page not matching , Expected : " +
			 * newCost[i] + ", Actual : " + lavanteUtils
			 * .getText(objListCostViewPage.iterateSearchHeaderFindColList(
			 * "New Cost").get(i)));
			 */

			Reporter.log("Verify currency in view details page, Expected : " + currency[i] + "(€)" + ", Actual : "
					+ lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Currency").get(i)));
			softAssert.assertEquals(
					lavanteUtils.getText(objListCostViewPage.iterateSearchHeaderFindColList("Currency").get(i)),
					currency[i] + "(€)",
					" currency in view details page not matching , Expected : " + currency[i] + "(€)" + ", Actual : "
							+ lavanteUtils
									.getText(objListCostViewPage.iterateSearchHeaderFindColList("Currency").get(i)));

		}
		softAssert.assertAll();
		Reporter.log("End test script createMultipleListCostItems Test " + currenttime());
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
