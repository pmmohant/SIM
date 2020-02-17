package com.lavante.sim.customer.TestScripts.Transactions.Invoices;

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

public class InvoicesAddCommentsTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String addPublicComment = "";
	String addPrivateComment = "";
	String customerID = "";
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Subhas.BV
	 * 
	 */
	@SuppressWarnings("unchecked")
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

		/*
		 * List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		 * 
		 * LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0); //
		 * Login enobjloginpage.logintoAPP(LdataMap); enobjhomePage.close();
		 * 
		 * LdataMap.put("maintab", "Transactions"); LdataMap.put("subtab",
		 * "customerInvoiceSearchResult"); enobjhomePage.selectTab(LdataMap);
		 */

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
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		SoftAssert softAssert = new SoftAssert();

		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);

		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String Uname = LdataMap.get("username");
		customerID = fetchCustomer(LdataMap.get("username"));
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(LdataMap);

		listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Supplier Login Mapped for the customer
		String getSupplierName = "select MAX(SupplierName) From supplier where LavanteUID in "
				+ " (select LavanteUID From Supplier_Contact_Map where ContactID in (select ContactID From Contact where Email like '"
				+ dataMap.get("username") + "'))";
		getSupplierName = lavanteUtils.fetchDBdata(getSupplierName);

		boolean flag = false;
		dataMap.put("SuppName", getSupplierName);
		dataMap.put("InvStatus", "Approved");
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);
		lavanteUtils.waitForTime(5000);

		List<WebElement> invoiceStatusList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Status");
		if (invoiceStatusList.size() > 0) {
			for (int i = 0; i < invoiceStatusList.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvStatus") + " Actual: "		+ invoiceStatusList.get(i).getText());
				softAssert.assertEquals(invoiceStatusList.get(i).getText(), dataMap.get("InvStatus"),"Search results are not matching, Expected: " + dataMap.get("InvStatus") + " Actual: "+ invoiceStatusList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		String invoiceNum = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();
		String getCommentCountSearchPage = "";
		
		
		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));

		lavanteUtils.waitForTime(4000);
		if (lavanteUtils.isElementPresent(objViewInvoicePage.GetUnreadCommentCount())) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}
		addPrivateComment = "AutoSP_Private" + currenttime();
		dataMap.put("EnterComment", addPrivateComment);
		dataMap.put("PrivateComment", "");
		eninvoicePage.addCommentView(dataMap);

		lavanteUtils.waitForTime(5000);
		flag = false;
		String actualComment = null;
		List<WebElement> privateComments = eninvoicePage.PrivateCommentsList();
		for (int i = 0; i < privateComments.size(); i++) {
			actualComment = privateComments.get(i).getText();
			if (actualComment.equals(addPrivateComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Comment added, Expected :" + addPrivateComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag, "Mismatch in the comment added and searched , Expected :" + addPrivateComment
				+ ", Actual :" + actualComment);

		dataMap.clear();
		addPublicComment = "AutoSP_Public" + currenttime();
		dataMap.put("EnterComment", addPublicComment);
		dataMap.put("PublicComment", "");
		eninvoicePage.addCommentView(dataMap);

		lavanteUtils.waitForTime(5000);
		flag = false;
		String getBuyerBuyerRole = null;
		actualComment = null;
		List<WebElement> publicComments = eninvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComments.size(); i++) {
			actualComment = publicComments.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				getBuyerBuyerRole = lavanteUtils.getText(objViewInvoicePage.ProfileCommentsList().get(i));
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added and searched , Expected :" + addPublicComment + ", Actual :"		+ actualComment);
		softAssert.assertTrue(flag, "Mismatch in the public comments added and searched , Expected :" + addPublicComment+ ", Actual :" + actualComment);

		String buyer = "select [Name] from Customer where CustomerID=" + customerID + "";
		buyer = lavanteUtils.fetchDBdata(buyer);
		String buyerUserRole = "select ContactName from contact  Where Email = '" + Uname + "'";
		buyerUserRole = lavanteUtils.fetchDBdata(buyerUserRole);
		String expected = buyer + " : " + buyerUserRole;

		Reporter.log("Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :"+ expected + ", Actual :" + getBuyerBuyerRole);

		softAssert.assertEquals(getBuyerBuyerRole, expected,"Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :" + expected						+ ", Actual :" + getBuyerBuyerRole);

		// logout
		enobjhomePage.logout();

		// Supplier login
		listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(dataMap);
		// enobjhomePage.close();

		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab", "Invoice");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("InvNum", invoiceNum);
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);

		lavanteUtils.waitForTime(5000);

		List<WebElement> invoiceNumList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
		if (invoiceNumList.size() > 0) {
			for (int i = 0; i < invoiceNumList.size(); i++) {
				Reporter.log("Invoice number Search results, Expected: " + dataMap.get("InvNum") + " Actual: "
						+ invoiceNumList.get(i).getText());
				softAssert.assertEquals(invoiceNumList.get(i).getText(), dataMap.get("InvNum"),
						"Invoice number Search results are not matching, Expected: " + dataMap.get("InvNum")
								+ " Actual: " + invoiceNumList.get(i).getText());
				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		String commentCountSearchPage = "";
		if (lavanteUtils.isElementDisplayed(objPaymentsPage.CommentImg().get(0))) {
			commentCountSearchPage = lavanteUtils.getText(objPaymentsPage.GetCommentCount().get(0));
		}

		Reporter.log("Verify comment count in search result page, Expected : 1 , Actual : "
				+ Integer.parseInt(commentCountSearchPage));
		softAssert.assertEquals(Integer.parseInt(commentCountSearchPage), 1,
				"Verification failed - comment count in search result page, Expected : 1 , Actual : "
						+ Integer.parseInt(commentCountSearchPage));
		
		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		List<WebElement> privateComs = eninvoicePage.PrivateCommentsList();
		List<WebElement> publicComs = eninvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment = publicComs.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added by customer and searched by supplier, Expected :"
				+ addPublicComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag,
				"Mismatch in the public comments added by customer and searched by supplier, Expected :"
						+ addPublicComment + ", Actual :" + actualComment);
		lavanteUtils.waitForTime(5000);
		for (int i = 0; i < privateComs.size(); i++) {
			actualComment = privateComs.get(i).getText();
			if (!actualComment.equals(addPrivateComment)) {
				flag = true;
			} else {
				flag = false;
				Reporter.log("Mismatch in the Private comments added by customer and searched by supplier, Expected :"
						+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
				softAssert.assertTrue(flag,
						"Mismatch in the Private comments added by customer and searched by supplier, Expected :"
								+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
			}
		}
		softAssert.assertTrue(flag, "Mismatch in the Private comments added by customer and searched by supplier");

		String getCommentCount = lavanteUtils.getText(objViewInvoicePage.GetUnreadCommentCount().get(0));
		Reporter.log(" Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		softAssert.assertEquals(Integer.parseInt(getCommentCount), 1,
				" Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
	
		
		if (lavanteUtils.isElementDisplayed(objViewInvoicePage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}

		softAssert.assertAll();

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

		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		boolean flag = false;
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab", "Invoice");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("InvStatus", "Approved");
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		String invoiceNum = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> invoiceStatusList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Status");
		if (invoiceStatusList.size() > 0) {
			for (int i = 0; i < invoiceStatusList.size(); i++) {
				Reporter.log("Invoice status Search results, Expected: " + dataMap.get("InvStatus") + " Actual: "		+ invoiceStatusList.get(i).getText());
				softAssert.assertEquals(invoiceStatusList.get(i).getText(), dataMap.get("InvStatus"),	"Invoice status Search results are not matching, Expected: " + dataMap.get("InvStatus")		+ " Actual: " + invoiceStatusList.get(i).getText());
				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);

		addPrivateComment = "AutoSP_Private" + currenttime();
		dataMap.put("EnterComment", addPrivateComment);
		dataMap.put("PrivateComment", "");
		objViewInvoicePage.addComment(dataMap);
		lavanteUtils.waitForTime(5000);
		if (lavanteUtils.isElementPresent(objViewInvoicePage.GetUnreadCommentCount())) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}
		flag = false;
		String actualComment = null;
		List<WebElement> privateComments = eninvoicePage.PrivateCommentsList();
		for (int i = 0; i < privateComments.size(); i++) {
			actualComment = privateComments.get(i).getText();
			if (actualComment.equals(addPrivateComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Comment added, Expected :" + addPrivateComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag, "Mismatch in the comment added and searched , Expected :" + addPrivateComment
				+ ", Actual :" + actualComment);

		dataMap.clear();
		addPublicComment = "AutoSP_Public" + currenttime();
		dataMap.put("EnterComment", addPublicComment);
		dataMap.put("PublicComment", "");
		eninvoicePage.addCommentView(dataMap);
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		String getSuppSuppUser = null;
		List<WebElement> publicComments = eninvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComments.size(); i++) {
			actualComment = publicComments.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				getSuppSuppUser = lavanteUtils.getText(objViewInvoicePage.ProfileCommentsList().get(i));
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added and searched , Expected :" + addPublicComment + ", Actual :"		+ actualComment);
		softAssert.assertTrue(flag, "Mismatch in the public comments added and searched , Expected :" + addPublicComment+ ", Actual :" + actualComment);

		String supplierUserRole = "select ContactName from contact  Where Email = '" + Uname + "'";
		supplierUserRole = lavanteUtils.fetchDBdata(supplierUserRole);
		String getSupplierName = "select SupplierName from Supplier where  LavanteUID in (select LavanteUID from Supplier_Contact_Map where  LavanteUID in (select LavanteUID from invoiceheader where invoicenumber='"
				+ invoiceNum + "') and ContactID in ( select ContactID from contact where Email='" + Uname + "'))";
		getSupplierName = lavanteUtils.fetchDBdata(getSupplierName);
		String expected = getSupplierName + " : " + supplierUserRole;

		Reporter.log("Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :"+ expected + ", Actual :" + getSuppSuppUser);

		softAssert.assertEquals(getSuppSuppUser, expected,"Mismatch in the Buyer/SupplierName : Buyer Role/Supplier user role in comments , Expected :" + expected+ ", Actual :" + getSuppSuppUser);

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
		dataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(dataMap);

		dataMap.clear();
		flag = false;
		dataMap.put("InvNum", invoiceNum);
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);
		lavanteUtils.waitForTime(5000);

		List<WebElement> invoiceNumList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
		if (invoiceNumList.size() > 0) {
			for (int i = 0; i < invoiceNumList.size(); i++) {
				Reporter.log("Invoice number Search results, Expected: " + invoiceNum + " Actual: "
						+ invoiceNumList.get(i).getText());
				softAssert.assertEquals(invoiceNumList.get(i).getText(), invoiceNum,	"Invoice number Search results are not matching, Expected: " + dataMap.get("InvNum")	+ " Actual: " + invoiceNumList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No results", eninvoicePage.NoData().getText());
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
		
		
		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);
		flag = false;
		actualComment = null;
		List<WebElement> privateComs = eninvoicePage.PrivateCommentsList();
		List<WebElement> publicComs = eninvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment = publicComs.get(i).getText();
			if (actualComment.equals(addPublicComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the public comments added by customer and searched by supplier, Expected :"
				+ addPublicComment + ", Actual :" + actualComment);
		softAssert.assertTrue(flag,
				"Mismatch in the public comments added by customer and searched by supplier, Expected :"
						+ addPublicComment + ", Actual :" + actualComment);
		lavanteUtils.waitForTime(5000);
		for (int i = 0; i < privateComs.size(); i++) {
			actualComment = privateComs.get(i).getText();
			if (!actualComment.equals(addPrivateComment)) {
				flag = true;
				Reporter.log("Mismatch in the Private comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
				softAssert.assertTrue(flag,		"Mismatch in the Private comments added by customer and searched by supplier, Expected :"		+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
			} else {
				flag = false;
				Reporter.log("Mismatch in the Private comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
				softAssert.assertTrue(flag,	"Mismatch in the Private comments added by customer and searched by supplier, Expected :"	+ addPublicComment + ", Actual :" + privateComs.get(i).getText());
			}
		}

		String getCommentCount = lavanteUtils.getText(objViewInvoicePage.GetUnreadCommentCount().get(0));
		Reporter.log(" Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		softAssert.assertEquals(Integer.parseInt(getCommentCount), 1," Comment count mismatch, Expected : 1 , Actual : " + Integer.parseInt(getCommentCount));
		if (lavanteUtils.isElementDisplayed(objViewInvoicePage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}

		softAssert.assertAll();
		Reporter.log("Test Ended for verify Supplier Added Comments Test:" + currenttime());
	}

	@AfterMethod
	public void AfterMethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.logout();

		if (addPublicComment.length() > 0 && addPrivateComment.length() > 0) {
			String query = "delete From InvoiceNotes where NoteID in (select NoteID From Note where Note in ('"	+ addPublicComment + "','" + addPrivateComment + "'))";
			lavanteUtils.UpdateDB(query);
			query = "delete From Note where Note in ('" + addPublicComment + "','" + addPrivateComment + "')";
			lavanteUtils.UpdateDB(query);
		}
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
