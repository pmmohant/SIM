package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
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
 * SIM-19040 Do not Allow Pickup Allowance  @author Subhas.BV
 *
 */
public class ClaimAmountPropertyTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String Uname = "";
	String customerID = "";
	String CustProp="";
	String expSuppName = "";
	String claimID = "";
	String pclaimId = "";
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

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
	}

	@BeforeMethod
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException {
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		Uname = LdataMap.get("username");
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		CustProp="select CustomerPropertyID from CustomerProperty where PropertyName='CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED'";
		CustProp=lavanteUtils.fetchDBdata(CustProp);
		
		
		String delete = "Delete from CustomerPropertyValue where CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED') and CustomerID="
				+ customerID + " ";
		lavanteUtils.UpdateDB(delete);

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Without customer property
	 *         "CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED" for the following
	 *         buyer
	 * 
	 *         Validate Customer Property
	 *         "CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED"
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void claimAmountValidation1Test() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for Claim Amount validation 1 Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimID = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		String amnt="10";
		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount",amnt);
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimAmount = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();
		Reporter.log("Added amount is not matching with the result page, Expected : " + amnt + " Actual :"
				+ claimAmount);
		softAssert.assertTrue(claimAmount.contains(amnt),
				"Added amount is not matching with the result, Expected : " + amnt + " Actual :" + claimAmount);

		lavanteUtils.click(lavanteUtils.driver.findElement(By.linkText(claimID)));

		String actualClaimID = lavanteUtils.getText(objViewClaimsPage.claimHeaderLabel());
		String actualAmountViewPage = lavanteUtils.getText(objViewClaimsPage.getClaimAmount());

		Reporter.log("Claim ID is the view details page, Expected : " + dataMap.get("ClaimId") + " Actual :"+ actualClaimID.split(":")[1].trim());
		softAssert.assertEquals(actualClaimID.split(":")[1].trim(), dataMap.get("ClaimId"),	"Claim ID is not matching with the view details page, Expected : " + dataMap.get("ClaimId")	+ " Actual :" + actualClaimID.split(":")[1].trim());

		Reporter.log("Added amount view details page, Expected : " + amnt + " Actual :" + actualAmountViewPage);
		softAssert.assertTrue(claimAmount.contains(amnt),	"Added amount is not matching with the view details page, Expected : " + amnt + " Actual :"	+ actualAmountViewPage);

		softAssert.assertAll();
		Reporter.log("Test Ended for Claim Amount validation 1 :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Claim Type 500 RestAll anything Claim Type < 500 Claim Type > 500
	 * 
	 *         Validate Customer Property
	 *         "CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED"
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void claimAmountValidation2Test() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for Claim Amount validation 2 Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount", "10");

		String insert = "Insert into CustomerPropertyValue (CustomerPropertyID,CustomerID,PropertyValue,IsActive,CreatedBy,CreatedOn)  "
				+ " VALUES ("+CustProp+","+customerID+", '{\"claimRestrictions\":   {\"claimRestriction\": [{ \"claimType\": \""
				+ dataMap.get("ClaimType")
				+ "\",\"minClaimValue\": \"500\",\"currency\":\"\"},{\"claimType\": \"RestAll\",\"minClaimValue\": \"75\",\"currency\": \"USD\"}]}}', 1, 'Auto', getdate())";
		lavanteUtils.UpdateDB(insert);

		dataMap.clear();
		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimID = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount", "10");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(objCreateClaimPage.GLCodeBannerMsg().get(0));
		String expectedMsg = "WV-Wrong Vendor claim under 500 cannot be updated";
		String actualMsg = lavanteUtils.getText(objCreateClaimPage.GLCodeBannerMsg().get(0));

		Reporter.log("Claim type : " + dataMap.get("ClaimType") + " less then 10 is able to updated , Expected : "
				+ expectedMsg + " Actual :" + actualMsg);
		softAssert.assertEquals(actualMsg, expectedMsg,
				"Claim type : " + dataMap.get("ClaimType") + " less then " + dataMap.get("ClaimAmount")
						+ " is able to updated is invalid , Expected : " + expectedMsg + " Actual :" + actualMsg);

		dataMap.put("ClaimAmount", "501");
		objCreateClaimPage.createClaim(dataMap);
		
		dataMap.remove("ClaimType");
		dataMap.remove("ClaimStatus");
		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimAmount = enClaimsPage.iterateSearchHeaderFindColList("Claim Amount").get(0).getText();
		String actual = claimAmount.split(" ")[1].trim();
		String expected = dataMap.get("ClaimAmount") + ".00";

		Reporter.log(
				"Added amount is not matching with the result page, Expected : " + expected + " Actual :" + actual);
		softAssert.assertEquals(actual, expected,
				"Added amount is not matching with the result, Expected : " + expected + " Actual :" + actual);

		lavanteUtils.click(lavanteUtils.driver.findElement(By.linkText(claimID)));
		String actualClaimID = lavanteUtils.getText(objViewClaimsPage.claimHeaderLabel());
		String actualAmountViewPage = lavanteUtils.getText(objViewClaimsPage.getClaimAmount()).split(" ")[1].trim();

		Reporter.log("Claim ID is the view details page, Expected : " + dataMap.get("ClaimId") + " Actual :"
				+ actualClaimID.split(":")[1].trim());
		softAssert.assertEquals(actualClaimID.split(":")[1].trim(), dataMap.get("ClaimId"),
				"Claim ID is not matching with the view details page, Expected : " + dataMap.get("ClaimId")
						+ " Actual :" + actualClaimID.split(":")[1].trim());

		Reporter.log("Added amount view details page, Expected : " + expected + " Actual :" + actualAmountViewPage);
		softAssert.assertEquals(actualAmountViewPage, expected,
				"Added amount is not matching with the view details page, Expected : " + expected + " Actual :"
						+ actualAmountViewPage);

		softAssert.assertAll();
		Reporter.log("Test Ended for Claim Amount validation 2 :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Claim Type1 - 500 RestAll - 100 Claim Type1 < 500 Claim Type1 >
	 *         500 RestAll < 100 RestAll > 100
	 * 
	 *         Validate Customer Property
	 *         "CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED"
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void claimAmountValidation3Test() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for Claim Amount validation 3 Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("ClaimType", "WV-Wrong Vendor");
		String insert = "Insert into CustomerPropertyValue (CustomerPropertyID,CustomerID,PropertyValue,IsActive,CreatedBy,CreatedOn)  "
				+ " VALUES ("+CustProp+","+customerID+", '{\"claimRestrictions\":   {\"claimRestriction\": [{ \"claimType\": \""
				+ dataMap.get("ClaimType")
				+ "\",\"minClaimValue\": \"500\",\"currency\":\"\"},{\"claimType\": \"RestAll\",\"minClaimValue\": \"100\",\"currency\": \"USD\"}]}}', 1, 'Auto', getdate())";
		lavanteUtils.UpdateDB(insert);

		dataMap.clear();
		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimID = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount", "101");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(objCreateClaimPage.GLCodeBannerMsg().get(0));
		String expectedMsg = "WV-Wrong Vendor claim under 500 cannot be updated";
		String actualMsg = lavanteUtils.getText(objCreateClaimPage.GLCodeBannerMsg().get(0));

		Reporter.log("Claim type : " + dataMap.get("ClaimType") + " less then 10 is able to updated , Expected : "
				+ expectedMsg + " Actual :" + actualMsg);
		softAssert.assertEquals(actualMsg, expectedMsg,
				"Claim type : " + dataMap.get("ClaimType") + " less then " + dataMap.get("ClaimAmount")
						+ " is able to updated is invalid , Expected : " + expectedMsg + " Actual :" + actualMsg);

		dataMap.clear();
		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount", "501");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);


		dataMap.remove("ClaimType");
		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimAmount = enClaimsPage.iterateSearchHeaderFindColList("Claim Amount").get(0).getText();
		String actual = claimAmount.split(" ")[1].trim();
		String expected = dataMap.get("ClaimAmount") + ".00";

		Reporter.log(
				"Added amount is not matching with the result page, Expected : " + expected + " Actual :" + actual);
		softAssert.assertEquals(actual, expected,
				"Added amount is not matching with the result, Expected : " + expected + " Actual :" + actual);

		lavanteUtils.click(lavanteUtils.driver.findElement(By.linkText(claimID)));
		String actualClaimID = lavanteUtils.getText(objViewClaimsPage.claimHeaderLabel());
		String actualAmountViewPage = lavanteUtils.getText(objViewClaimsPage.getClaimAmount()).split(" ")[1].trim();

		Reporter.log("Claim ID is the view details page, Expected : " + dataMap.get("ClaimId") + " Actual :"
				+ actualClaimID.split(":")[1].trim());
		softAssert.assertEquals(actualClaimID.split(":")[1].trim(), dataMap.get("ClaimId"),
				"Claim ID is not matching with the view details page, Expected : " + dataMap.get("ClaimId")
						+ " Actual :" + actualClaimID.split(":")[1].trim());

		Reporter.log("Added amount view details page, Expected : " + expected + " Actual :" + actualAmountViewPage);
		softAssert.assertEquals(actualAmountViewPage, expected,
				"Added amount is not matching with the view details page, Expected : " + expected + " Actual :"
						+ actualAmountViewPage);

		lavanteUtils.click(objViewClaimsPage.backLink());

		dataMap.clear();
		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		dataMap.put("ClaimType", "NC-Non Compliance");
		dataMap.put("ClaimAmount", "99");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(objCreateClaimPage.GLCodeBannerMsg().get(0));
		expectedMsg = "Claims under USD 100 cannot be updated";
		actualMsg = lavanteUtils.getText(objCreateClaimPage.GLCodeBannerMsg().get(0));

		Reporter.log("Claim type : " + dataMap.get("ClaimType") + " less then 10 is able to updated , Expected : "
				+ expectedMsg + " Actual :" + actualMsg);
		softAssert.assertEquals(actualMsg, expectedMsg,
				"Claim type : " + dataMap.get("ClaimType") + " less then " + dataMap.get("ClaimAmount")
						+ " is able to updated is invalid , Expected : " + expectedMsg + " Actual :" + actualMsg);

		dataMap.clear();
		dataMap.put("ClaimType", "NC-Non Compliance");
		dataMap.put("ClaimAmount", "101");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		claimAmount = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();
		actual = claimAmount.split(" ")[1].trim();
		expected = dataMap.get("ClaimAmount") + ".00";

		Reporter.log(
				"Added amount is not matching with the result page, Expected : " + expected + " Actual :" + actual);
		softAssert.assertEquals(actual, expected,
				"Added amount is not matching with the result, Expected : " + expected + " Actual :" + actual);

		lavanteUtils.click(lavanteUtils.driver.findElement(By.linkText(claimID)));
		actualClaimID = lavanteUtils.getText(objViewClaimsPage.claimHeaderLabel());
		actualAmountViewPage = lavanteUtils.getText(objViewClaimsPage.getClaimAmount()).split(" ")[1].trim();

		Reporter.log("Claim ID is the view details page, Expected : " + dataMap.get("ClaimId") + " Actual :"
				+ actualClaimID.split(":")[1].trim());
		softAssert.assertEquals(actualClaimID.split(":")[1].trim(), claimID,
				"Claim ID is not matching with the view details page, Expected : " + claimID + " Actual :"
						+ actualClaimID.split(":")[1].trim());

		Reporter.log("Added amount view details page, Expected : " + expected + " Actual :" + actualAmountViewPage);
		softAssert.assertEquals(actualAmountViewPage, expected,
				"Added amount is not matching with the view details page, Expected : " + expected + " Actual :"
						+ actualAmountViewPage);

		softAssert.assertAll();
		Reporter.log("Test Ended for Claim Amount validation 3 :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Claim Type1 - 500 Claim Type2 - 500 RestAll - 100 Claim Type1 <
	 *         500 Claim Type2 < 500 Claim Type1 > 500 Claim Type2 > 500 RestAll
	 *         - 100
	 *         
	 *         Need to be edited for view claim edit except first test
	 *         
	 * 
	 *         Validate Customer Property
	 *         "CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED"
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void MultipleclaimAmountTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for Claim Amount validation 4 Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String insert = "Insert into CustomerPropertyValue (CustomerPropertyID,CustomerID,PropertyValue,IsActive,CreatedBy,CreatedOn)   VALUES ("+CustProp+","+customerID+", '{\"claimRestrictions\":{\"claimRestriction\":[{\"claimType\":\"EC-EDI Non Compliance\",\"minClaimValue\":\"500\",\"currency\":\"\"},{\"claimType\":\"NC-Non Compliance\",\"minClaimValue\":\"500\",\"currency\":\"\"},{\"claimType\":\"RestAll\",\"minClaimValue\":\"100\",\"currency\": \"USD\"}]}}', 1, 'Auto', getdate())";
		lavanteUtils.UpdateDB(insert);

		dataMap.clear();
		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String claimID = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		dataMap.put("ClaimType", "EC-EDI Non Compliance");
		dataMap.put("ClaimAmount", "499");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(objCreateClaimPage.GLCodeBannerMsg().get(0));
		String expectedMsg = "EC-EDI Non Compliance claim under 500 cannot be updated";
		String actualMsg = lavanteUtils.getText(objCreateClaimPage.GLCodeBannerMsg().get(0));

		Reporter.log("Claim type : " + dataMap.get("ClaimType") + " less then 10 is able to updated , Expected : "
				+ expectedMsg + " Actual :" + actualMsg);
		softAssert.assertEquals(actualMsg, expectedMsg,
				"Claim type : " + dataMap.get("ClaimType") + " less then " + dataMap.get("ClaimAmount")
						+ " is able to updated is invalid , Expected : " + expectedMsg + " Actual :" + actualMsg);

		dataMap.clear();
		dataMap.put("ClaimType", "EC-EDI Non Compliance");
		dataMap.put("ClaimAmount", "501");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);
		lavanteUtils.waitForTime(4000);
		dataMap.remove("ClaimType");
		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);
		String claimAmount = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();
		String actual = claimAmount.split(" ")[1].trim();
		String expected = dataMap.get("ClaimAmount") + ".00";

		Reporter.log(
				"Added amount is not matching with the result page, Expected : " + expected + " Actual :" + actual);
		softAssert.assertEquals(actual, expected,
				"Added amount is not matching with the result, Expected : " + expected + " Actual :" + actual);

		lavanteUtils.click(lavanteUtils.driver.findElement(By.linkText(claimID)));
		String actualClaimID = lavanteUtils.getText(objViewClaimsPage.claimHeaderLabel());
		String actualAmountViewPage = lavanteUtils.getText(objViewClaimsPage.getClaimAmount()).split(" ")[1].trim();

		Reporter.log("Claim ID is the view details page, Expected : " + dataMap.get("ClaimId") + " Actual :"
				+ actualClaimID.split(":")[1].trim());
		softAssert.assertEquals(actualClaimID.split(":")[1].trim(), dataMap.get("ClaimId"),
				"Claim ID is not matching with the view details page, Expected : " + dataMap.get("ClaimId")
						+ " Actual :" + actualClaimID.split(":")[1].trim());

		Reporter.log("Added amount view details page, Expected : " + expected + " Actual :" + actualAmountViewPage);
		softAssert.assertEquals(actualAmountViewPage, expected,
				"Added amount is not matching with the view details page, Expected : " + expected + " Actual :"
						+ actualAmountViewPage);

		lavanteUtils.click(objViewClaimsPage.backLink());

		/*
		 * dataMap.clear(); dataMap.put("ClaimId", claimID);
		 * dataMap.put("Search", ""); enClaimsBasicSearch.Search(dataMap);
		 */

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		dataMap.put("ClaimType", "NC-Non Compliance");
		dataMap.put("ClaimAmount", "499");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(objCreateClaimPage.GLCodeBannerMsg().get(0));
		expectedMsg = "NC-Non Compliance claim under 500 cannot be updated";
		actualMsg = lavanteUtils.getText(objCreateClaimPage.GLCodeBannerMsg().get(0));

		Reporter.log("Claim type : " + dataMap.get("ClaimType") + " less then 10 is able to updated , Expected : "
				+ expectedMsg + " Actual :" + actualMsg);
		softAssert.assertEquals(actualMsg, expectedMsg,
				"Claim type : " + dataMap.get("ClaimType") + " less then " + dataMap.get("ClaimAmount")
						+ " is able to updated is invalid , Expected : " + expectedMsg + " Actual :" + actualMsg);

		dataMap.clear();
		dataMap.put("ClaimType", "NC-Non Compliance");
		dataMap.put("ClaimAmount", "501");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);
		claimAmount = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();
		actual = claimAmount.split(" ")[1].trim();
		expected = dataMap.get("ClaimAmount") + ".00";

		Reporter.log(
				"Added amount is not matching with the result page, Expected : " + expected + " Actual :" + actual);
		softAssert.assertEquals(actual, expected,
				"Added amount is not matching with the result, Expected : " + expected + " Actual :" + actual);

		lavanteUtils.click(lavanteUtils.driver.findElement(By.linkText(claimID)));
		actualClaimID = lavanteUtils.getText(objViewClaimsPage.claimHeaderLabel());
		actualAmountViewPage = lavanteUtils.getText(objViewClaimsPage.getClaimAmount()).split(" ")[1].trim();

		Reporter.log("Claim ID is the view details page, Expected : " + claimID + " Actual :"
				+ actualClaimID.split(":")[1].trim());
		softAssert.assertEquals(actualClaimID.split(":")[1].trim(), claimID,
				"Claim ID is not matching with the view details page, Expected : " + claimID + " Actual :"
						+ actualClaimID.split(":")[1].trim());

		Reporter.log("Added amount view details page, Expected : " + expected + " Actual :" + actualAmountViewPage);
		softAssert.assertEquals(actualAmountViewPage, expected,
				"Added amount is not matching with the view details page, Expected : " + expected + " Actual :"
						+ actualAmountViewPage);

		softAssert.assertAll();
		Reporter.log("Test Ended for Claim Amount validation 4 :" + currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@AfterMethod
	public void SetupAfterMethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.logout();
		String delete = "Delete from CustomerPropertyValue where CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='CLAIM_AMOUNT_AND_CURRENCY_VALIDATION_ENABLED') and CustomerID="
				+ customerID + " ";
		lavanteUtils.UpdateDB(delete);
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
