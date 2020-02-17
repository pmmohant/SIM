package com.lavante.sim.customer.TestScripts.Transactions.Claims;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ClaimsAddCommentsTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String uname = "";
	String customerID = "";
	String expSuppName = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Subhas.BV
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

	}

	/**
	 * @author subhas.bv
	 * 
	 *         Adding comments in claims view page Test case
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void verifyCustomerAddedCommentsTest()
			throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for verify Customer Added Comments Test:" + currenttime());

		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String Uname = LdataMap.get("username");
		customerID = fetchCustomer(LdataMap.get("username"));
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult"); 
		enobjhomePage.selectTab(dataMap);
		dataMap.clear();

		// Supplier login //
		LdataMap.clear();
		listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		String getSupplierName = "select max(SupplierName) From supplier where LavanteUID in (select LavanteUID From Supplier_Contact_Map where ContactID in (select ContactID From Contact "
				+ "where Email like '" + LdataMap.get("username") + "'))";
		getSupplierName = lavanteUtils.fetchDBdata(getSupplierName);
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		dataMap.put("SupplierName", getSupplierName);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.waitForTime(3000);

		List<WebElement> supplierNameList = enClaimsPage.iterateSearchHeaderFindColList("Supplier Name");
		if (supplierNameList.size() > 0) {
			for (int i = 0; i < supplierNameList.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("SupplierName") + " Actual: "			+ supplierNameList.get(i).getText());
				softAssert.assertEquals(supplierNameList.get(i).getText(), dataMap.get("SupplierName"),	"Search results are not matching, Expected: " + dataMap.get("SupplierName") + " Actual: "	+ supplierNameList.get(i).getText());
				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}
		String claimID = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();
		lavanteUtils.clicks(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
		lavanteUtils.waitForTime(4000);
		if (lavanteUtils.isElementPresent(objViewClaimsPage.GetUnreadCommentCount())) {
			lavanteUtils.click(objViewClaimsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewClaimsPage.MarkAllReadLink().get(0));
		}

		String addPrivateComment = "AutoBV_Private" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPrivateComment);
		dataMap.put("PrivateComment", "");
		objViewClaimsPage.addComment(dataMap);
		lavanteUtils.waitForTime(5000);

		flag = false;
		String actualComment = null;
		List<WebElement> privateComments = objViewClaimsPage.PrivateCommentsList();
		for (int i = 0; i < privateComments.size(); i++) {
			actualComment = privateComments.get(i).getText();
			if (actualComment.equals(addPrivateComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Comment added, Expected :" + addPrivateComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag, "Mismatch in the comment added and searched , Expected :" + addPrivateComment	+ ", Actual :" + actualComment);

		dataMap.clear();
		String addPublicComment = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment);
		dataMap.put("PublicComment", "");
		objViewClaimsPage.addComment(dataMap);
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		List<WebElement> publicComments = objViewClaimsPage.PublicCommentsList();
		String getBuyerBuyerRole = null;
		for (int i = 0; i < publicComments.size(); i++) {
			actualComment = publicComments.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				getBuyerBuyerRole = lavanteUtils.getText(objViewClaimsPage.ProfileCommentsList().get(i));
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added and searched , Expected :" + addPublicComment + ", Actual :"			+ actualComment);
		softAssert.assertTrue(flag, "Mismatch in the public comments added and searched , Expected :" + addPublicComment	+ ", Actual :" + actualComment);

		String buyer = "select [Name] from Customer where CustomerID=" + customerID + "";
		buyer = lavanteUtils.fetchDBdata(buyer);
		String buyerUserRole = "select ContactName from contact  Where Email = '" + Uname + "'";
		buyerUserRole = lavanteUtils.fetchDBdata(buyerUserRole);
		String expected = buyer + " : " + buyerUserRole;

		Reporter.log("Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :"				+ expected + ", Actual :" + getBuyerBuyerRole);

		softAssert.assertEquals(getBuyerBuyerRole, expected,"Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :" + expected						+ ", Actual :" + getBuyerBuyerRole);

		// logout
		enobjhomePage.logout();

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		customerID = fetchSupplierCustomer(LdataMap.get("username"));
		Uname = LdataMap.get("username");
		enobjhomePage.close();
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab", "ClaimResult");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.waitForTime(5000);

		List<WebElement> claimIDList = enobjsupplierPage.iterateSearchHeaderFindColList("Claim ID");
		if (claimIDList.size() > 0) {
			for (int i = 0; i < claimIDList.size(); i++) {
				Reporter.log("ClaimId Search results, Expected: " + dataMap.get("ClaimId") + " Actual: "	+ claimIDList.get(i).getText());
				softAssert.assertEquals(claimIDList.get(i).getText(), dataMap.get("ClaimId"),	"ClaimId Search results are not matching, Expected: " + dataMap.get("ClaimId") + " Actual: "	+ claimIDList.get(i).getText());
				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		String commentCountSearchPage = "";
		if (lavanteUtils.isElementDisplayed(objPaymentsPage.CommentImg().get(0))) {
			commentCountSearchPage = lavanteUtils.getText(objPaymentsPage.GetCommentCount().get(0));
		}

		Reporter.log("Verify comment count in search result page, Expected : 1 , Actual : "	+ Integer.parseInt(commentCountSearchPage));
		softAssert.assertEquals(Integer.parseInt(commentCountSearchPage), 1,"Verification failed - comment count in search result page, Expected : 1 , Actual : "+ Integer.parseInt(commentCountSearchPage));

		lavanteUtils.clicks(enClaimsPage.ListClaimId().get(0));
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		List<WebElement> privateComs = objViewClaimsPage.PrivateCommentsList();
		List<WebElement> publicComs = objViewClaimsPage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment = publicComs.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag,	"Mismatch in the public comments added by customer and searched by supplier, Expected :"						+ addPublicComment + ", Actual :" + actualComment);
		lavanteUtils.waitForTime(5000);
		for (int i = 0; i < privateComs.size(); i++) {
			actualComment = privateComs.get(i).getText();
			if (!actualComment.equals(addPrivateComment)) {
				flag = true;
			} else {
				flag = false;
				Reporter.log("Mismatch in the Private comments added by customer and searched by supplier, Expected :"		+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
				softAssert.assertTrue(flag,	"Mismatch in the Private comments added by customer and searched by supplier, Expected :"								+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
			}
		}
		softAssert.assertTrue(flag, "Mismatch in the Private comments added by customer and searched by supplier");

		String getCommentCount = lavanteUtils.getText(objViewClaimsPage.GetUnreadCommentCount().get(0));
		Reporter.log(" Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		softAssert.assertEquals(Integer.parseInt(getCommentCount), 1," Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		if (lavanteUtils.isElementDisplayed(objViewClaimsPage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewClaimsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewClaimsPage.MarkAllReadLink().get(0));
		}

		softAssert.assertAll();
		enobjhomePage.logout();
		Reporter.log("Test Ended for verify Customer Added Comments Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Adding comments in supplier claims view page Test case
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void verifySupplierAddedCommentsTest()
			throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for verify Supplier Added Comments Test:" + currenttime());

		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String Uname = LdataMap.get("username");
		customerID = fetchCustomer(LdataMap.get("username"));
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		boolean flag = false;
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab", "ClaimResult");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ClaimStatus", "Pending");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.waitForTime(5000);
		String claimID = enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0).getText();
		dataMap.put("ClaimId", claimID);

		List<WebElement> claimIDList = enobjsupplierPage.iterateSearchHeaderFindColList("Claim ID");
		if (claimIDList.size() > 0) {
			for (int i = 0; i < claimIDList.size(); i++) {
				Reporter.log("ClaimId Search results, Expected: " + dataMap.get("ClaimId") + " Actual: "		+ claimIDList.get(i).getText());
				softAssert.assertEquals(claimIDList.get(i).getText(), dataMap.get("ClaimId"),	"ClaimId Search results are not matching, Expected: " + dataMap.get("ClaimId") + " Actual: "		+ claimIDList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}
		String getInvoiceNumber = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();
		lavanteUtils.clicks(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
		lavanteUtils.waitForTime(5000);

		if (lavanteUtils.isElementPresent(objViewClaimsPage.GetUnreadCommentCount())) {
			lavanteUtils.click(objViewClaimsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewClaimsPage.MarkAllReadLink().get(0));
		}

		String addPrivateComment = "AutoBV_Private" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPrivateComment);
		dataMap.put("PrivateComment", "");
		objViewClaimsPage.addComment(dataMap);
		lavanteUtils.waitForTime(5000);
		flag = false;
		String actualComment = null;
		List<WebElement> privateComments = objViewClaimsPage.PrivateCommentsList();
		for (int i = 0; i < privateComments.size(); i++) {
			actualComment = privateComments.get(i).getText();
			if (actualComment.equals(addPrivateComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Comment added, Expected :" + addPrivateComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag, "Mismatch in the comment added and searched , Expected :" + addPrivateComment	+ ", Actual :" + actualComment);

		dataMap.clear();
		String addPublicComment = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment);
		dataMap.put("PublicComment", "");
		objViewClaimsPage.addComment(dataMap);
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		String getSuppSuppUser = null;
		List<WebElement> publicComments = objViewClaimsPage.PublicCommentsList();
		for (int i = 0; i < publicComments.size(); i++) {
			actualComment = publicComments.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				getSuppSuppUser = lavanteUtils.getText(objViewClaimsPage.ProfileCommentsList().get(i));
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added and searched , Expected :" + addPublicComment + ", Actual :"	+ actualComment);
		softAssert.assertTrue(flag, "Mismatch in the public comments added and searched , Expected :" + addPublicComment	+ ", Actual :" + actualComment);

		String supplierUserRole = "select ContactName from contact  Where Email = '" + Uname + "'";
		supplierUserRole = lavanteUtils.fetchDBdata(supplierUserRole);
		String getSupplierName = "select SupplierName from Supplier where  LavanteUID in (select LavanteUID from Supplier_Contact_Map where  LavanteUID in (select LavanteUID from invoiceheader where invoicenumber='"
				+ getInvoiceNumber + "') and ContactID in ( select ContactID from contact where Email='" + Uname+ "'))";
		getSupplierName = lavanteUtils.fetchDBdata(getSupplierName);
		String expected = getSupplierName + " : " + supplierUserRole;

		Reporter.log("Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :"	+ expected + ", Actual :" + getSuppSuppUser);

		softAssert.assertEquals(getSuppSuppUser, expected,	"Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :" + expected	+ ", Actual :" + getSuppSuppUser);

		// logout
		enobjhomePage.logout();

		// Customer Login
		LdataMap.clear();
		listofdatafrm = lavanteUtils.login("Kroger", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		dataMap.clear();
		flag = false;
		dataMap.put("ClaimId", claimID);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.waitForTime(5000);

		claimIDList = enobjsupplierPage.iterateSearchHeaderFindColList("Claim ID");
		if (claimIDList.size() > 0) {
			for (int i = 0; i < claimIDList.size(); i++) {
				Reporter.log("ClaimId Search results, Expected: " + dataMap.get("ClaimId") + " Actual: "		+ claimIDList.get(i).getText());
				softAssert.assertEquals(claimIDList.get(i).getText(), dataMap.get("ClaimId"),	"ClaimId Search results are not matching, Expected: " + dataMap.get("ClaimId") + " Actual: "	+ claimIDList.get(i).getText());
				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String commentCountSearchPage = "";
		if (lavanteUtils.isElementDisplayed(objPaymentsPage.CommentImg().get(0))) {
			commentCountSearchPage = lavanteUtils.getText(objPaymentsPage.GetCommentCount().get(0));
		}

		Reporter.log("Verify comment count in search result page, Expected : 1 , Actual : "	+ Integer.parseInt(commentCountSearchPage));
		softAssert.assertEquals(Integer.parseInt(commentCountSearchPage), 1,"Verification failed - comment count in search result page, Expected : 1 , Actual : "	+ Integer.parseInt(commentCountSearchPage));

		lavanteUtils.clicks(enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(0));
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		List<WebElement> privateComs = objViewClaimsPage.PrivateCommentsList();
		List<WebElement> publicComs = objViewClaimsPage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment = publicComs.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag,		"Mismatch in the public comments added by customer and searched by supplier, Expected :"						+ addPublicComment + ", Actual :" + actualComment);
		lavanteUtils.waitForTime(5000);
		for (int i = 0; i < privateComs.size(); i++) {
			actualComment = privateComs.get(i).getText();
			if (!actualComment.equals(addPrivateComment)) {
				flag = true;
				Reporter.log("Mismatch in the Private comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
				softAssert.assertTrue(flag,	"Mismatch in the Private comments added by customer and searched by supplier, Expected :"				+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
			} else {
				flag = false;
				Reporter.log("Mismatch in the Private comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
				softAssert.assertTrue(flag,	"Mismatch in the Private comments added by customer and searched by supplier, Expected :"		+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
			}
		}

		String getCommentCount = lavanteUtils.getText(objViewClaimsPage.GetUnreadCommentCount().get(0));
		Reporter.log(" Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		softAssert.assertEquals(Integer.parseInt(getCommentCount), 1," Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		if (lavanteUtils.isElementDisplayed(objViewClaimsPage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewClaimsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewClaimsPage.MarkAllReadLink().get(0));
		}

		softAssert.assertAll();
		enobjhomePage.logout();
		Reporter.log("Test Ended for verify Supplier Added Comments Test:" + currenttime());
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		quitBrowser();
	}

}
