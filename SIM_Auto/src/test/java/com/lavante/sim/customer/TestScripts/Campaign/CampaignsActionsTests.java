package com.lavante.sim.customer.TestScripts.Campaign;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * 
 * @author Subhas.BV
 *
 */
public class CampaignsActionsTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = "";

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
		// PaymentCenter-Campaigns
		List listofdatafrm = lavanteUtils.login("Campaigns", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	@BeforeMethod
	public void Before() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "CAMPAIGNS");
		dataMap.put("subtab", "campaignSearchSetup");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * @author subhas.bv
	 * 
	 *         deleteCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void deleteCampaignTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for delete Campaign Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("CampaignStatus", "Draft");
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);

		boolean flag = false;
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String count = "" + lavanteUtils.getCount();
		if (Integer.parseInt(count) > 0) {
			List<WebElement> campignsStatusList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Status");
			if (campignsStatusList.size() > 0) {
				for (int i = 0; i < campignsStatusList.size(); i++) {
					Reporter.log("Campaign status search results, Expected: " + dataMap.get("CampaignStatus")
							+ " Actual: " + campignsStatusList.get(i).getText());
					softAssert.assertEquals(campignsStatusList.get(i).getText(), dataMap.get("CampaignStatus"),
							"Campaign status search results are not matching, Expected: "
									+ dataMap.get("CampaignStatus") + " Actual: "
									+ campignsStatusList.get(i).getText());
					flag = true;
				}
			} else {
				softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}
			String campaignName = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Name").get(0)
					.getText();

			dataMap.put("SelectRecord", "any");
			dataMap.put("DeleteCampaign", "");
			objCampaignBasicSearchPage.selectCampaignAction(dataMap);

			dataMap.put("CampaignName", campaignName);
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);

			lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			Reporter.log("Campaign name deleted, Expected: No results, Actual: "
					+ objCampaignBasicSearchPage.NoData().getText());
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText(),
					"Campaign as not been deleted, Expected: No results, Actual: "
							+ objCampaignBasicSearchPage.NoData().getText());
		} else {
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
			flag = true;
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for delete Campaign Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         editCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void editCampaignTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for edit Campaign Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String campaignName = "select CampaignName from campaignDetails where PlannedStartDate > getUTCdate() and campaignstatusID=1 and CustomerID="
				+ customerID + "";
		campaignName = lavanteUtils.fetchDBdata(campaignName);
		boolean flag = false;
		if (campaignName != null) {
			dataMap.put("CampaignName", campaignName);
			dataMap.put("CampaignStatus", "Draft");
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);

			lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			List<WebElement> campignsStatusList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Status");
			if (campignsStatusList.size() > 0) {
				for (int i = 0; i < campignsStatusList.size(); i++) {
					Reporter.log("Campaign status search results, Expected: " + dataMap.get("CampaignStatus")
							+ " Actual: " + campignsStatusList.get(i).getText());
					softAssert.assertEquals(campignsStatusList.get(i).getText(), dataMap.get("CampaignStatus"),
							"Campaign status search results are not matching, Expected: "
									+ dataMap.get("CampaignStatus") + " Actual: "
									+ campignsStatusList.get(i).getText());
					flag = true;
				}
			} else {
				softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}
			dataMap.put("SelectRecord", "any");
			dataMap.put("EditCampaign", "");
			objCampaignBasicSearchPage.selectCampaignAction(dataMap);

			String editedCampaignName = "Auto_SP" + lavanteUtils.generateRandomNumber9OnLength(7);
			dataMap.put("CampaignName", editedCampaignName);
			dataMap.put("SaveExit", "");
			objCampaignPage.createCampaign(dataMap);

			lavanteUtils.fluentwait(objCampaignBasicSearchPage.SearchBtn());
			dataMap.put("CampaignName", editedCampaignName);
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);

			lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			List<WebElement> campaignsNameList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Name");
			if (campaignsNameList.size() > 0) {
				for (int i = 0; i < campaignsNameList.size(); i++) {
					Reporter.log("Campaign name search results, Expected: " + dataMap.get("CampaignName") + " Actual: "
							+ campaignsNameList.get(i).getText());
					softAssert.assertEquals(campaignsNameList.get(i).getText(), dataMap.get("CampaignName"),
							"Campaign name search results are not matching, Expected: " + dataMap.get("CampaignName")
									+ " Actual: " + campaignsNameList.get(i).getText());
					flag = true;
					break;
				}
			} else {
				softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}
		} else {
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
			flag = true;
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for edit Campaign Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         editCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@Test
	public void createCampaignTest() throws FileNotFoundException, IOException, SQLException, ParseException {
		Reporter.log("Test Started for create Campaign Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("AddCampaign", "");
		dataMap.put("EmailTemplate", "any");
		dataMap.put("CampaignName", "any");
		dataMap.put("CampaignType", "any");
		String startDate = lavanteUtils.AddSubDateWithFormat(5, "dd-MM-yyyy").replace("-", "/");
		String completionDate = lavanteUtils.AddSubDateWithFormat(10, "dd-MM-yyyy").replace("-", "/");
		dataMap.put("PlannedStartDate", startDate);
		dataMap.put("PlannedEndDate", completionDate);
		dataMap.put("CampaignOwner", "any");
		dataMap.put("RequestingDivision", "any");
		dataMap.put("SelectQuery", "any");

		dataMap.put("SelectActivities", "Your Company Information");
		dataMap.put("SupplierChargedNo", "");
		dataMap.put("SaveExit", "");
		objCampaignPage.createCampaign(dataMap);

		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);

		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String actCampaignName = objCampaignBasicSearchPage.getColumnText("Campaign Name", 0);
		Reporter.log("Verification : expected  campaign name " + dataMap.get("CampaignName")
				+ "with actual campaign name " + actCampaignName);
		softAssert.assertEquals(actCampaignName, dataMap.get("CampaignName"), "Expected campaign name "
				+ dataMap.get("CampaignName") + "is not matching with actual campaign name " + actCampaignName);

		dataMap.put("maintab", "SUPPLIERS");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.clicks(ensupplierAdvanced.advtab());
		dataMap.put("RunQuery", "");
		dataMap.put("saveqryname", dataMap.get("SelectedQuery"));
		ensupplierAdvanced.ActionForSavedQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		String expected = "(" + dataMap.get("SuppliersInScope") + ")";
		String actual = lavanteUtils.getText(enobjsupplierPage.searchResults());
		Reporter.log("Verification : expected  suppliers in scope " + expected + "with actual suppliers in scope "
				+ actCampaignName);
		softAssert.assertEquals(actual, expected, " expected  suppliers in scope " + expected
				+ "is not matching with actual suppliers in scope " + actCampaignName);

		softAssert.assertAll();
		Reporter.log("Test Ended for create Campaign Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         duplicateCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@Test
	public void duplicateCampaignTest() throws FileNotFoundException, IOException, SQLException, ParseException {
		Reporter.log("Test Started for duplicate Campaign Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String campaignName = "select max(CampaignName) from campaignDetails where  CustomerID="+ customerID + "";
		campaignName = lavanteUtils.fetchDBdata(campaignName);
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		dataMap.put("SelectRecord", "any");
		dataMap.put("CloneCampaign", "");
		objCampaignBasicSearchPage.selectCampaignAction(dataMap);
		lavanteUtils.switchtoFrame(null);

		lavanteUtils.typeString(campaignName, objCampaignPage.CampaignNameText());
		lavanteUtils.clicks(objCampaignPage.SaveExitBtn());

		lavanteUtils.fluentwait(objCampaignPage.CampaignNameErrorMsg());
		String expectedErrorMsg = "Campaign with name '" + campaignName+ "' already exists. Please provide a unique name";
		String actualErrorMsg = lavanteUtils.getText(objCampaignPage.CampaignNameErrorMsg());

		Reporter.log("Verification : expected duplicate campaign name error msg " + expectedErrorMsg + "with actual duplicate campaign name error msg " + actualErrorMsg);
		softAssert.assertEquals(actualErrorMsg, expectedErrorMsg, "Expected duplicate campaign name error msg "+ expectedErrorMsg + "is not matching with actual duplicate campaign name error msg " + actualErrorMsg);

		softAssert.assertAll();
		Reporter.log("Test Ended for duplicate Campaign Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         editApprovedCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@Test
	public void editApprovedCampaignTest() throws FileNotFoundException, IOException, SQLException, ParseException {
		Reporter.log("Test Started for edit approved Campaign Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("CampaignStatus", "Approved");
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);
		boolean flag = false;
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String count = "" + lavanteUtils.getCount();
		if (Integer.parseInt(count) > 0) {
			List<WebElement> campaignsStatusList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Status");
			if (campaignsStatusList.size() > 0) {
				for (int i = 0; i < campaignsStatusList.size(); i++) {
					Reporter.log("Campaign name search results, Expected: " + dataMap.get("CampaignStatus")
							+ " Actual: " + campaignsStatusList.get(i).getText());
					softAssert.assertEquals(campaignsStatusList.get(i).getText(), dataMap.get("CampaignStatus"),
							"Campaign name search results are not matching, Expected: " + dataMap.get("CampaignStatus")
									+ " Actual: " + campaignsStatusList.get(i).getText());
					flag = true;
					break;
				}
			} else {
				Assert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}

			String campaignID = lavanteUtils
					.getText(objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign ID").get(0));
			dataMap.put("SelectRecord", "any");
			dataMap.put("EditCampaign", "");
			objCampaignBasicSearchPage.selectCampaignAction(dataMap);

			lavanteUtils.switchtoFrame(null);
			String expMsg = "The campaign you are trying to modify is already approved. Modifying the campaign will reset the approval. Would you like to edit the campaign?";
			String actMsg = lavanteUtils.getText(objCampaignBasicSearchPage.GetPopupMsg());

			Reporter.log("Popup msg, Expected: " + expMsg + " Actual: " + actMsg);
			softAssert.assertEquals(actMsg, expMsg,
					"Popup msg not matching, Expected: " + expMsg + " Actual: " + actMsg);

			lavanteUtils.clicks(objCampaignBasicSearchPage.YesBtn());
			dataMap.put("SelectActivities", "W9 Form Certification");
			dataMap.put("SaveExit", "");
			objCampaignPage.createCampaign(dataMap);

			lavanteUtils.fluentwait(objCampaignBasicSearchPage.SearchBtn());
			dataMap.put("CampaignId", campaignID);
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);

			lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			List<WebElement> campaignsIDList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign ID");
			List<WebElement> campignsStatusList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Status");
			if (campaignsIDList.size() > 0) {
				for (int i = 0; i < campaignsIDList.size(); i++) {
					Reporter.log("Campaign name search results, Expected: " + dataMap.get("CampaignId") + " Actual: "
							+ campaignsIDList.get(i).getText());
					softAssert.assertEquals(campaignsIDList.get(i).getText(), dataMap.get("CampaignId"),
							"Campaign name search results are not matching, Expected: " + dataMap.get("CampaignId")
									+ " Actual: " + campaignsIDList.get(i).getText());
					String expected = "Draft";
					Reporter.log("Campaign status search results, Expected: " + expected + " Actual: "
							+ campignsStatusList.get(i).getText());
					softAssert.assertEquals(campignsStatusList.get(i).getText(), expected,
							"Campaign status search results are not matching, Expected: " + expected + " Actual: "
									+ campignsStatusList.get(i).getText());
					flag = true;
					break;
				}
			} else {
				softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}

		} else {
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
			flag = true;
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for edit approved Campaign Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         verify Approved Campaign Flow
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 * 
	 */
	@Test
	public void submitCampaignTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for verify Approved Campaign Flow Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		boolean flag = false;

		dataMap.put("CampaignStatus", "Draft");
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);

		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String count = "" + lavanteUtils.getCount();
		if (Integer.parseInt(count) > 0) {
			List<WebElement> campaignsNameList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Status");
			if (campaignsNameList.size() > 0) {
				for (int i = 0; i < campaignsNameList.size(); i++) {
					Reporter.log("Campaign status search results, Expected: " + dataMap.get("CampaignStatus")
							+ " Actual: " + campaignsNameList.get(i).getText());
					softAssert.assertEquals(campaignsNameList.get(i).getText(), dataMap.get("CampaignStatus"),
							"Campaign status search results are not matching, Expected: "
									+ dataMap.get("CampaignStatus") + " Actual: " + campaignsNameList.get(i).getText());
					flag = true;
					break;
				}
			} else {
				Assert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}
			String campaignName = lavanteUtils
					.getText(objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Name").get(0));
			dataMap.put("SelectRecord", "any");
			dataMap.put("SubmitCampaign", "");
			objCampaignBasicSearchPage.selectCampaignAction(dataMap);

			dataMap.put("maintab", "TASKS");
			dataMap.put("subtab", "viewCampaignTasks");
			enobjhomePage.selectTab(dataMap);
			lavanteUtils.refreshPage();
			List<WebElement> campaignNameList = objTasksCampaignsPage.iterateSearchHeaderFindColList("Campaign Name");
			for (int i = 0; i < campaignNameList.size(); i++) {
				if (campaignNameList.get(i).getText().equals(campaignName)) {
					lavanteUtils.clicks(objTasksCampaignsPage.ListCheckBox().get(i));
					break;
				}
			}

			dataMap.put("Approve", "");
			objTasksCampaignsPage.selectAction(dataMap);

			dataMap.put("maintab", "CAMPAIGNS");
			dataMap.put("subtab", "campaignSearchSetup");
			enobjhomePage.selectTab(dataMap);

			dataMap.put("CampaignName", campaignName);
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);

			lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			List<WebElement> campaignsStatusList = objCampaignBasicSearchPage
					.iterateSearchHeaderFindColList("Campaign Status");
			campaignsNameList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Name");
			if (campaignsStatusList.size() > 0) {
				for (int i = 0; i < campaignsStatusList.size(); i++) {
					Reporter.log("Campaign status search results, Expected: Approved , Actual: "
							+ campaignsStatusList.get(i).getText());
					softAssert.assertEquals(campaignsStatusList.get(i).getText(), "Approved",
							"Campaign status search results are not matching, Expected: Approved ," + " Actual: "
									+ campaignsStatusList.get(i).getText());
					Reporter.log("Campaign name search results, Expected: " + dataMap.get("CampaignName") + " Actual: "
							+ campaignsNameList.get(i).getText());
					softAssert.assertEquals(campaignsNameList.get(i).getText(), dataMap.get("CampaignName"),
							"Campaign name search results are not matching, Expected: " + dataMap.get("CampaignName")
									+ " Actual: " + campaignsNameList.get(i).getText());
					flag = true;
					break;
				}
			} else {
				Assert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}
		} else {
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
			flag = true;
		}
		softAssert.assertAll();
		Reporter.log("Test ended for verify Approved Campaign Flow Test :" + currenttime());

	}

	/**
	 * @author subhas.bv
	 * 
	 *         cloneCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void cloneCampaignTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for clone Campaign Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());

		String campaignID = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign ID").get(0).getText();
		String query = "update CampaignDetails set PlannedStartDate= getdate()+1, PlannedCompletionDate= getdate()+5 where CampaignID="
				+ campaignID + "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String campaignStatus = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Status").get(0)	.getText();
		String campaignOwner = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Owner").get(0).getText();
		String requestingDivs = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Requesting Division(s)")	.get(0).getText();

		dataMap.put("SelectRecord", "any");
		dataMap.put("CloneCampaign", "");
		objCampaignBasicSearchPage.selectCampaignAction(dataMap);
		lavanteUtils.switchtoFrame(null);

		String camNam = "AutoBV_" + lavanteUtils.generateRandomNumber9OnLength(8);
		lavanteUtils.typeinEdit(camNam, objCampaignPage.CampaignNameText());
		lavanteUtils.clicks(objCampaignPage.SaveExitBtn());

		lavanteUtils.fluentwait(objCampaignBasicSearchPage.ClearBtn());
		dataMap.put("CampaignName", camNam);
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);

		boolean flag = false;
		List<WebElement> campignsNameList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Name");

		if (campignsNameList.size() > 0) {
			for (int i = 0; i < campignsNameList.size(); i++) {

				List<WebElement> campignsStatusList = objCampaignBasicSearchPage
						.iterateSearchHeaderFindColList("Campaign Status");
				campaignStatus = "Draft";
				List<WebElement> campignsOwnerList = objCampaignBasicSearchPage
						.iterateSearchHeaderFindColList("Campaign Owner");
				List<WebElement> requestingDivList = objCampaignBasicSearchPage
						.iterateSearchHeaderFindColList("Requesting Division(s)");

				Reporter.log("Campaign Name search results, Expected: " + dataMap.get("CampaignName") + " Actual: "
						+ campignsNameList.get(i).getText());
				softAssert.assertEquals(campignsNameList.get(i).getText(), dataMap.get("CampaignName"),
						"Campaign Name search results are not matching, Expected: " + dataMap.get("CampaignName")
								+ " Actual: " + campignsNameList.get(i).getText());
				Reporter.log("Campaign Status search results, Expected: " + campaignStatus + " Actual: "
						+ campignsStatusList.get(i).getText());
				softAssert.assertEquals(campignsStatusList.get(i).getText(), campaignStatus,
						"Campaign Status search results are not matching, Expected: " + campaignStatus + " Actual: "
								+ campignsStatusList.get(i).getText());
				Reporter.log("Campaign Owner search results, Expected: " + campaignOwner + " Actual: "
						+ campignsOwnerList.get(i).getText());
				softAssert.assertEquals(campignsOwnerList.get(i).getText(), campaignOwner,
						"Campaign Owner search results are not matching, Expected: " + campaignOwner + " Actual: "
								+ campignsOwnerList.get(i).getText());

				Reporter.log("Requesting Division search results, Expected: " + requestingDivs + " Actual: "
						+ requestingDivList.get(i).getText());
				softAssert.assertEquals(requestingDivList.get(i).getText(), requestingDivs,
						"Requesting Division  search results are not matching, Expected: " + requestingDivs
								+ " Actual: " + requestingDivList.get(i).getText());

				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for clone Campaign Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         completeCampaignTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void completeCampaignTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for complete Campaign Test :" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String campaignID = "select MAX(CampaignID) from CampaignDetails where CustomerID =" + customerID
				+ " and CampaignStatusID in (1,4,5)";
		campaignID = lavanteUtils.fetchDBdata(campaignID);

		dataMap.put("CampaignId", campaignID);
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);

		dataMap.put("SelectRecord", "any");
		dataMap.put("CompleteCampaign", "");
		objCampaignBasicSearchPage.selectCampaignAction(dataMap);

		lavanteUtils.refreshPage();
		dataMap.remove("CampaignStatus");
		dataMap.put("CampaignId", campaignID);
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);

		boolean flag = false;
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		List<WebElement> campignsIDList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign ID");
		List<WebElement> campignsStatusList = objCampaignBasicSearchPage
				.iterateSearchHeaderFindColList("Campaign Status");
		String expectedCampaignStatus = "Completed";
		if (campignsIDList.size() > 0) {
			for (int i = 0; i < campignsIDList.size(); i++) {
				Reporter.log("Campaign ID search results, Expected: " + dataMap.get("CampaignId") + " Actual: "
						+ campignsIDList.get(i).getText());
				softAssert.assertEquals(campignsIDList.get(i).getText(), dataMap.get("CampaignId"),
						"Campaign ID search results are not matching, Expected: " + dataMap.get("CampaignId")
								+ " Actual: " + campignsIDList.get(i).getText());
				Reporter.log("Campaign Status search results, Expected: " + expectedCampaignStatus + " Actual: "
						+ campignsStatusList.get(i).getText());
				softAssert.assertEquals(campignsStatusList.get(i).getText(), expectedCampaignStatus,
						"Campaign Status search results are not matching, Expected: " + expectedCampaignStatus
								+ " Actual: " + campignsStatusList.get(i).getText());
				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", objCampaignBasicSearchPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for complete Campaign Test :" + currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(null);

	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
