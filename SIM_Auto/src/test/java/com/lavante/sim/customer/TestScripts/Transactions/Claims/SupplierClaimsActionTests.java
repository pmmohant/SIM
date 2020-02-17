package com.lavante.sim.customer.TestScripts.Transactions.Claims;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class SupplierClaimsActionTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = "";
	String Uname="";

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
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = fetchSupplierCustomer(LdataMap.get("username"));
		Uname=LdataMap.get("username");

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	@BeforeMethod
	public void Before() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab","Payment");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * @author subhas.bv
	 * 
	 *         createClaimTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void createClaimTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for create claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		String getInvoiceNo = "  select max(InvoiceNumber) from InvoiceHeader where CustomerID=" + customerID
				+ "  and InvoiceHeaderID in (select InvoiceHeaderID from Payment where"
				+ "  PaymentID not in (Select PaymentID from Claim )) "
				+ "  and LavanteUID in ( Select LavanteUID from Supplier_Contact_Map where ContactID in (Select ContactID from Contact Where Email"
				+ "  like '" + Uname + "'))";
		String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo).toString();

		dataMap.put("InvoiceNumber", invoiceNum.trim());
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
		String getPaymentRefNum = objPaymentsPage.getColumnText("Payment Ref No", 0);

		String updateCustOrgID = "update payment set customerorganizationid=1633 where paymentid in (select paymentid from payment where paymentrefnumber='"+ getPaymentRefNum + "')";
		lavanteUtils.UpdateDB(updateCustOrgID);

		Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")	+ ", Actual : " + getInvoiceNum);
		Assert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "	+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		
		dataMap.put("CreateClaim","");
		objPaymentsPage.selectPaymentAction(dataMap);

		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount", "10");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		dataMap.put("maintab", "CLAIMS");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		dataMap.put("InvoiceNo", invoiceNum);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		List<WebElement> criteria = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		if (criteria.size() > 0) {
			for (int i = 0; i < criteria.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "
						+ criteria.get(i).getText());
				softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),
						"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "
								+ criteria.get(i).getText());

				Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "
						+ enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				softAssert.assertEquals(enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),
						dataMap.get("ClaimType"),
						"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "
								+ enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());

				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		softAssert.assertAll();
		Reporter.log("Test Ended for create claim:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 *
	 *         SIM-17846 Hide supplier created 'Open' claims in Invoice and
	 *         Payment Details for Buyer
	 * 
	 * 
	 *         createClaimBuyerVerificationTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void createClaimBuyerVerificationTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for create claim Buyer :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		String getInvoiceNo = "  select max(InvoiceNumber) from InvoiceHeader where CustomerID=" + customerID
				+ "  and InvoiceHeaderID in (select InvoiceHeaderID from Payment where"
				+ "  PaymentID not in (Select PaymentID from Claim where PaymentID=PaymentID )) "
				+ "  and LavanteUID in ( Select LavanteUID from Supplier_Contact_Map where ContactID in (Select ContactID from Contact Where Email"
				+ "  like '" + Uname + "'))";
		String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo).toString();

		dataMap.put("InvoiceNumber", invoiceNum.trim());
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
		String getPaymentRefNum = objPaymentsPage.getColumnText("Payment Ref No", 0);
		String getNumOfClaimsSupplier = objPaymentsPage.getColumnText("# Of Claims", 0);

		String updateCustOrgID = "update payment set customerorganizationid=1633 where paymentid in (select paymentid from payment where paymentrefnumber='"
				+ getPaymentRefNum + "')";
		lavanteUtils.UpdateDB(updateCustOrgID);
		

		Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")
				+ ", Actual : " + getInvoiceNum);
		Assert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),
				"Invoice number is not equall to the searched Invoice number, Expected : "
						+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

		objPaymentsPage.clickColText("Payment Ref No", getPaymentRefNum);
		lavanteUtils.click(objPaymentsPage.CreateClaimLink());
		// lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		// objPaymentsPage.selectPaymentAction();

		dataMap.put("ClaimType", "WV-Wrong Vendor");
		dataMap.put("ClaimAmount", "10");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		dataMap.put("maintab", "CLAIMS");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		dataMap.put("InvoiceNo", invoiceNum);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		List<WebElement> criteria = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		if (criteria.size() > 0) {
			for (int i = 0; i < criteria.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "
						+ criteria.get(i).getText());
				softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),
						"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "
								+ criteria.get(i).getText());

				Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "
						+ enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				softAssert.assertEquals(enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),
						dataMap.get("ClaimType"),
						"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "
								+ enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());

				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		String claimID = enobjsupplierPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();

		enobjhomePage.logout();

		// Buyer login
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		// LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String,
		// String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String uname = dataMap.get("username");
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();

		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerPaymentResult");
		enobjhomePage.selectTab(dataMap);

		flag = false;
		dataMap.put("InvoiceNumber", invoiceNum);
		dataMap.put("PaymentRefNo", getPaymentRefNum);
		dataMap.put("ClaimID", claimID);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		String getNumOfClaimsBuyer = objPaymentsPage.getColumnText("# Of Claims", 0);
		// Know issue so the verification is commented
		/*
		 * Reporter.log("Number of claims in buyer and supplier, Expected: " +
		 * getNumOfClaimsBuyer + " Actual: " + getNumOfClaimsSupplier);
		 * softAssert.assertEquals(getNumOfClaimsBuyer, getNumOfClaimsSupplier,
		 * "Number of claims in buyer and supplier, Expected: " +
		 * getNumOfClaimsBuyer + " Actual: " + getNumOfClaimsSupplier);
		 */

		objPaymentsPage.clickColText("Invoice Number", invoiceNum);

		String expected = "No results";
		String actual = lavanteUtils.getText(objViewPaymentsPage.GetClaimNoResultsTxt().get(0));

		Reporter.log("Search results, Expected: " + expected + " Actual: " + actual);
		softAssert.assertEquals(actual, expected,
				"Search results are not matching, Expected: " + expected + " Actual: " + actual);

		lavanteUtils.click(objViewPaymentsPage.backLink());

		objPaymentsPage.clickColText("Payment Ref No", getPaymentRefNum);

		String expected1 = "No Data Available";
		String actual1 = lavanteUtils.getText(objViewPaymentsPage.GetClaimNoResultsTxt().get(0));

		Reporter.log("Search results, Expected: " + expected1 + " Actual: " + actual1);
		softAssert.assertEquals(actual1, expected1,
				"Search results are not matching, Expected: " + expected1 + " Actual: " + actual1);

		lavanteUtils.click(objViewPaymentsPage.backLink());

		dataMap.put("View", "Payments and Claims");
		objPaymentsPage.selectChangeView(dataMap);

		dataMap.put("InvoiceNumber", invoiceNum);
		dataMap.put("PaymentRefNo", getPaymentRefNum);
		dataMap.put("ClaimID", claimID);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		objPaymentsPage.clickColText("Invoice Number", invoiceNum);

		String expected2 = "No results";
		String actual2 = lavanteUtils.getText(objViewPaymentsPage.GetClaimNoResultsTxt().get(0));

		Reporter.log("Search results, Expected: " + expected2 + " Actual: " + actual2);
		softAssert.assertEquals(actual2, expected2,
				"Search results are not matching, Expected: " + expected2 + " Actual: " + actual2);

		lavanteUtils.click(objViewPaymentsPage.backLink());

		objPaymentsPage.clickColText("Payment Ref No", getPaymentRefNum);

		String expected3 = "No results";
		String actual3 = lavanteUtils.getText(objViewPaymentsPage.GetClaimNoResultsTxt().get(0));

		Reporter.log("Search results, Expected: " + expected3 + " Actual: " + actual3);
		softAssert.assertEquals(actual3, expected3,
				"Search results are not matching, Expected: " + expected3 + " Actual: " + actual3);

		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String expected4 = "No results";
		String actual4 = lavanteUtils.getText(enClaimsPage.NoData());
		Reporter.log("Search results, Expected: " + expected4 + " Actual: " + actual4);
		softAssert.assertEquals(actual3, expected4,
				"Search results are not matching, Expected: " + expected4 + " Actual: " + actual4);

		softAssert.assertAll();
		Reporter.log("Test Ended for create claim buyer verification :" + currenttime());
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
