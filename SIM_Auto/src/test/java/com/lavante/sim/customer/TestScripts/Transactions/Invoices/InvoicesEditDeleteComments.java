package com.lavante.sim.customer.TestScripts.Transactions.Invoices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class InvoicesEditDeleteComments extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String Uname = "";
	String customerID = "";
	String expSuppName = "";
	String userRoleID = "";

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
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		Uname = LdataMap.get("username");

		userRoleID = "select UserRoleID from [Login] where ContactID in(select ContactID from Contact where Email='"
				+ Uname + "')";
		userRoleID = lavanteUtils.fetchDBdata(userRoleID);

		String delEditDeleteRole = "Delete from LoginRole_RoleType_Map WHERE UserRoleID=" + userRoleID
				+ " AND RoleTypeID in (select RoleTypeId from RoleType where RoleType in ('EDIT_COMMENT_ROLE','DELETE_COMMENT_ROLE'))";
		lavanteUtils.UpdateDB(delEditDeleteRole);
		LdataMap.clear();
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Verify Role EDIT_COMMENT_ROLE and DELETE_COMMENT_ROLE without
	 *         mapping to login role
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void VerifyEditDeleteCommentsTest()
			throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for Verify EditDeleteComments Test:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String Uname = LdataMap.get("username");
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		boolean flag = false;
		dataMap.put("maintab", "INVOICES");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("InvStatus", "Approved");
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		String invoiceNum = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> invoiceStatusList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Status");
		if (invoiceStatusList.size() > 0) {
			for (int i = 0; i < invoiceStatusList.size(); i++) {
				Reporter.log("Invoice status Search results, Expected: " + dataMap.get("InvStatus") + " Actual: "
						+ invoiceStatusList.get(i).getText());
				softAssert.assertEquals(invoiceStatusList.get(i).getText(), dataMap.get("InvStatus"),
						"Invoice status Search results are not matching, Expected: " + dataMap.get("InvStatus")
								+ " Actual: " + invoiceStatusList.get(i).getText());
				flag = true;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		if (flag == false) {

		}

		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);

		if (!lavanteUtils.isElementDisplayed(objViewInvoicePage.addCommentBtn())) {
			if (lavanteUtils.isElementPresent(objViewInvoicePage.GetUnreadCommentCount())) {
				lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
				lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
			}
		}

		// Adding public comments
		String addPublicComment1 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment1);
		dataMap.put("PublicComment", "");
		objViewInvoicePage.addComment(dataMap);
		lavanteUtils.refreshPage();
		lavanteUtils.waitforPageload(objViewInvoicePage.addCommentTxt());

		// Editing a comment
		flag = false;
		lavanteUtils.fluentwait(objViewInvoicePage.PublicCommentsList().get(0));
		String coomentIcon = objViewInvoicePage.CommentOptionIcon.replace("$", addPublicComment1);
		WebElement CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.clicks(CommentOptionIcon);
		String options = objViewInvoicePage.ListCommentOptions.replace("$", addPublicComment1);
		List<WebElement> opt = lavanteUtils.driver.findElements(By.xpath(options));

		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Edit")) {
				lavanteUtils.clicks(opt.get(j));
				flag = true;
				break;
			}
		}
		Reporter.log("No Edit link to edit the comment , Expected : true , Actual : " + flag);
		softAssert.assertTrue(flag, " Comment not Edited sucessfully , Expected : true, Actual: ," + flag);
		String editedComment = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		WebElement editElement = lavanteUtils.driver
				.findElement(By.xpath(objViewInvoicePage.EditCommentTxtArea.replace("$", addPublicComment1)));
		editElement.clear();
		lavanteUtils.typeinEdit(editedComment, editElement);
		WebElement saveElement = lavanteUtils.driver
				.findElement(By.xpath(objViewInvoicePage.SaveComment.replace("$", addPublicComment1)));
		lavanteUtils.clicks(saveElement);
		lavanteUtils.fluentwait(objViewInvoicePage.PublicCommentsList().get(0));
		String actualComment = "";
		List<WebElement> publicComs = objViewInvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment = publicComs.get(i).getText();
			if (actualComment.equals(editedComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Verify edited comment, Expected : " + editedComment + ", Actual : " + actualComment);
		softAssert.assertEquals(actualComment, editedComment,
				" Edited comment is not same/displayed , Expected : " + editedComment + ", Actual : " + actualComment);

		// Deleting a comment
		flag = false;
		coomentIcon = objViewInvoicePage.CommentOptionIcon.replace("$", editedComment);
		CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.fluentwait(CommentOptionIcon);
		lavanteUtils.clicks(CommentOptionIcon);
		options = objViewInvoicePage.ListCommentOptions.replace("$", editedComment);
		opt = lavanteUtils.driver.findElements(By.xpath(options));
		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Delete")) {
				lavanteUtils.clicks(opt.get(j));
				lavanteUtils.fluentwait(objViewInvoicePage.AddCommentsBtn());
				lavanteUtils.click(objViewInvoicePage.DeleteBtn());
				flag = true;
				break;
			}
		}
		Reporter.log("No Delete link to delete the comment , Expected : true , Actual : " + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);

		flag = false;
		lavanteUtils.fluentwait(objViewInvoicePage.PublicCommentsList().get(0));
		publicComs = objViewInvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			if (!publicComs.get(i).getText().equals(editedComment)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		Reporter.log("Verify comment deleted sucessfully , Expected : true, Actual: ," + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);
		String publicComment = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", publicComment);
		dataMap.put("PublicComment", "");
		objViewInvoicePage.addComment(dataMap);

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
				softAssert.assertEquals(invoiceNumList.get(i).getText(), invoiceNum,
						"Invoice number Search results are not matching, Expected: " + dataMap.get("InvNum")
								+ " Actual: " + invoiceNumList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
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

		publicComs = objViewInvoicePage.PublicCommentsList();
		for (int k = 0; k < publicComs.size(); k++) {
			actualComment = publicComs.get(k).getText();
			if (actualComment.equals(publicComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Public comments added by customer and searched by supplier, Expected :" + publicComment
				+ ", Actual :" + actualComment);
		softAssert.assertTrue(flag,
				"Mismatch in the public comments added by customer and searched by supplier, Expected :" + publicComment
						+ ", Actual :" + actualComment);

		flag = false;
		publicComs = objViewInvoicePage.PublicCommentsList();
		for (int m = 0; m < publicComs.size(); m++) {
			actualComment = publicComs.get(m).getText();
			if (actualComment.equals(publicComment)) {
				String obj = objViewInvoicePage.CommentOptionIcon.replace("$", publicComment);
				opt = lavanteUtils.driver.findElements(By.xpath(obj));
				if (!lavanteUtils.isElementPresent(opt)) {
					flag = true;
					break;
				}
			}
		}
		Reporter.log("Verify edit or delete option , Expected : true,  Actual :" + flag);
		softAssert.assertTrue(flag,
				" Edit/Delete option is displayed which should not be the case, Expected : true,  Actual :" + flag);
		if (lavanteUtils.isElementDisplayed(objViewInvoicePage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for Verify EditDeleteComments Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Verify Role EDIT_COMMENT_ROLE mapped and DELETE_COMMENT_ROLE
	 *         without mapped to login role
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void VerifyEditCommentsTest() throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for Verify Edit Comments Test:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String Uname = LdataMap.get("username");
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		boolean flag = false;
		dataMap.put("maintab", "INVOICES");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("InvStatus", "Approved");
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		String invoiceNum = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> invoiceStatusList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Status");
		if (invoiceStatusList.size() > 0) {
			for (int i = 0; i < invoiceStatusList.size(); i++) {
				Reporter.log("Invoice status Search results, Expected: " + dataMap.get("InvStatus") + " Actual: "
						+ invoiceStatusList.get(i).getText());
				softAssert.assertEquals(invoiceStatusList.get(i).getText(), dataMap.get("InvStatus"),
						"Invoice status Search results are not matching, Expected: " + dataMap.get("InvStatus")
								+ " Actual: " + invoiceStatusList.get(i).getText());
				flag = true;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);
		if (!lavanteUtils.isElementDisplayed(objViewInvoicePage.addCommentBtn())) {
			if (lavanteUtils.isElementPresent(objViewInvoicePage.GetUnreadCommentCount())) {
				lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
				lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
			}
		}

		// Adding public comments
		String addPublicComment1 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment1);
		dataMap.put("PublicComment", "");
		objViewInvoicePage.addComment(dataMap);

		// logout
		enobjhomePage.logout();

		String roleId = "select RoleTypeId from RoleType where RoleType='EDIT_COMMENT_ROLE'";
		roleId = lavanteUtils.fetchDBdata(roleId);

		String editRole = "Insert into LoginRole_RoleType_Map(RoleTypeID,UserRoleID,CreatedBy,CreatedOn) VALUES ("
				+ roleId + "," + userRoleID + ",'Auto_BV',getdate())";
		lavanteUtils.UpdateDB(editRole);
		LdataMap.clear();
		listofdatafrm = lavanteUtils.login("Kroger", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		dataMap.clear();
		flag = false;
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
				softAssert.assertEquals(invoiceNumList.get(i).getText(), invoiceNum,
						"Invoice number Search results are not matching, Expected: " + dataMap.get("InvNum")
								+ " Actual: " + invoiceNumList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		if (flag == false) {

		}

		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);
		flag = false;
		String actualComment1 = null;
		actualComment1 = null;
		List<WebElement> publicComs = objViewInvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment1 = publicComs.get(i).getText();
			if (actualComment1.equals(addPublicComment1)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Public comments added by customer and searched by supplier, Expected :" + addPublicComment1
				+ ", Actual :" + actualComment1);
		softAssert.assertTrue(flag,
				"Mismatch in the public comments added by customer and searched by supplier, Expected :"
						+ addPublicComment1 + ", Actual :" + actualComment1);

		// Editing a comment
		flag = false;
		lavanteUtils.fluentwait(objViewInvoicePage.PublicCommentsList().get(0));
		String coomentIcon = objViewInvoicePage.CommentOptionIcon.replace("$", addPublicComment1);
		WebElement CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.clicks(CommentOptionIcon);
		String options = objViewInvoicePage.ListCommentOptions.replace("$", addPublicComment1);
		List<WebElement> opt = lavanteUtils.driver.findElements(By.xpath(options));

		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Edit")) {
				lavanteUtils.clicks(opt.get(j));
				flag = true;
				break;
			}
		}
		Reporter.log("No Edit link to edit the comment , Expected : true , Actual : " + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);
		String editedComment = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		WebElement editElement = lavanteUtils.driver
				.findElement(By.xpath(objViewInvoicePage.EditCommentTxtArea.replace("$", addPublicComment1)));
		editElement.clear();
		lavanteUtils.typeinEdit(editedComment, editElement);
		WebElement saveElement = lavanteUtils.driver
				.findElement(By.xpath(objViewInvoicePage.SaveComment.replace("$", addPublicComment1)));
		lavanteUtils.clicks(saveElement);
		lavanteUtils.fluentwait(objViewInvoicePage.PublicCommentsList().get(0));
		String actualComment = "";
		publicComs = objViewInvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment = publicComs.get(i).getText();
			if (actualComment.equals(editedComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Verify edited comment, Expected : " + editedComment + ", Actual : " + actualComment);
		softAssert.assertEquals(actualComment, editedComment,
				" Edited comment is not same/displayed , Expected : " + editedComment + ", Actual : " + actualComment);

		if (lavanteUtils.isElementDisplayed(objViewInvoicePage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}

		softAssert.assertAll();
		Reporter.log("Test Ended for Verify Edit Comments Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Verify Role EDIT_COMMENT_ROLE mapped and DELETE_COMMENT_ROLE
	 *         without mapped to login role
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void VerifyDeleteCommentsTest()
			throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for Verify Delete Comments Test:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		String Uname = LdataMap.get("username");
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		boolean flag = false;
		dataMap.put("maintab", "INVOICES");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("InvStatus", "Approved");
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		String invoiceNum = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> invoiceStatusList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Status");
		if (invoiceStatusList.size() > 0) {
			for (int i = 0; i < invoiceStatusList.size(); i++) {
				Reporter.log("Invoice status Search results, Expected: " + dataMap.get("InvStatus") + " Actual: "
						+ invoiceStatusList.get(i).getText());
				softAssert.assertEquals(invoiceStatusList.get(i).getText(), dataMap.get("InvStatus"),
						"Invoice status Search results are not matching, Expected: " + dataMap.get("InvStatus")
								+ " Actual: " + invoiceStatusList.get(i).getText());
				flag = true;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}
		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);
		if (!lavanteUtils.isElementDisplayed(objViewInvoicePage.addCommentBtn())) {
			if (lavanteUtils.isElementPresent(objViewInvoicePage.GetUnreadCommentCount())) {
				lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
				lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
			}
		}

		// Adding public comments
		String addPublicComment1 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment1);
		dataMap.put("PublicComment", "");
		objViewInvoicePage.addComment(dataMap);
		String addPublicComment2 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment2);
		dataMap.put("PublicComment", "");
		objViewInvoicePage.addComment(dataMap);

		// logout
		enobjhomePage.logout();

		String roleId = "select RoleTypeId from RoleType where RoleType='DELETE_COMMENT_ROLE'";
		roleId = lavanteUtils.fetchDBdata(roleId);

		String deleteRole = "Insert into LoginRole_RoleType_Map(RoleTypeID,UserRoleID,CreatedBy,CreatedOn) VALUES ("
				+ roleId + "," + userRoleID + ",'Auto_BV',getdate())";
		lavanteUtils.UpdateDB(deleteRole);
		LdataMap.clear();
		listofdatafrm = lavanteUtils.login("Kroger", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		flag = false;
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("InvNum", invoiceNum);
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);
		lavanteUtils.waitForTime(5000);

		List<WebElement> invoiceNumList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
		if (invoiceNumList.size() > 0) {
			for (int i = 0; i < invoiceNumList.size(); i++) {
				Reporter.log("Invoice number Search results, Expected: " + invoiceNum + " Actual: "
						+ invoiceNumList.get(i).getText());
				softAssert.assertEquals(invoiceNumList.get(i).getText(), invoiceNum,
						"Invoice number Search results are not matching, Expected: " + dataMap.get("InvNum")
								+ " Actual: " + invoiceNumList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			Reporter.log("No Search results");
			softAssert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.clicks(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		lavanteUtils.waitForTime(5000);

		flag = false;
		String actualComment1 = null;
		actualComment1 = null;
		List<WebElement> publicComs = objViewInvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			actualComment1 = publicComs.get(i).getText();
			if (actualComment1.equals(addPublicComment1)) {
				flag = true;
				break;
			}
		}

		Reporter.log("Public comments added by customer and searched by supplier, Expected :" + addPublicComment1
				+ ", Actual :" + actualComment1);
		softAssert.assertTrue(flag,
				"Mismatch in the public comments added by customer and searched by supplier, Expected :"
						+ addPublicComment1 + ", Actual :" + actualComment1);

		// Deleting a comment
		flag = false;
		lavanteUtils.fluentwait(objViewInvoicePage.PublicCommentsList().get(0));
		String coomentIcon = objViewInvoicePage.CommentOptionIcon.replace("$", addPublicComment1);
		WebElement CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.clicks(CommentOptionIcon);
		String options = objViewInvoicePage.ListCommentOptions.replace("$", addPublicComment1);
		List<WebElement> opt = lavanteUtils.driver.findElements(By.xpath(options));
		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Delete")) {
				lavanteUtils.clicks(opt.get(j));
				lavanteUtils.fluentwait(objViewInvoicePage.AddCommentsBtn());
				lavanteUtils.clicks(objViewInvoicePage.DeleteBtn());
				flag = true;
				break;
			}
		}
		Reporter.log("No Delete link to delete the comment , Expected : true , Actual : " + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);
		lavanteUtils.waitforPageload(objViewInvoicePage.PublicCommentsList().get(0));
		flag = false;
		publicComs = objViewInvoicePage.PublicCommentsList();
		for (int i = 0; i < publicComs.size(); i++) {
			if (!publicComs.get(i).getText().equals(addPublicComment1)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		Reporter.log("Verify comment deleted sucessfully , Expected : true, Actual: ," + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);

		if (lavanteUtils.isElementPresent(objViewInvoicePage.GetUnreadCommentCount())) {
			lavanteUtils.click(objViewInvoicePage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewInvoicePage.MarkAllReadLink().get(0));
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for Verify Delete CommentsTest:" + currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		enobjhomePage.logout();

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
