package com.lavante.sim.customer.TestScripts.Transactions.Payments;

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

public class PaymentsEditDeleteComments extends PageInitiator {

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
		dataMap.put("maintab", "PAYMENTS");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		lavanteUtils.waitForTime(5000);
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String paymentReferenceNo = objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0).getText();
		String invoiceNo = objPaymentsPage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> claimCount = objPaymentsPage.iterateSearchHeaderFindColList("# Of Claims");
		if (claimCount.size() > 0) {
			for (int i = 0; i < claimCount.size(); i++) {
				Reporter.log("Supplier Login,Claim Count Search results, Expected: Greater than 0 Actual: "
						+ claimCount.get(i).getText());
				softAssert.assertTrue(Integer.parseInt(claimCount.get(i).getText()) > 0,
						"Supplier Login,Claim Count Search results, Expected: Greater than 0 Actual: "
								+ claimCount.get(i).getText());
				flag = true;
				break;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", objPaymentsPage.NoData().getText());
			flag = true;
		}
		
		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0));
		lavanteUtils.waitForTime(5000);
		if (!lavanteUtils.isElementDisplayed(objViewPaymentsPage.addCommentBtn())) {
			if (lavanteUtils.isElementPresent(objViewPaymentsPage.GetUnreadCommentCount())) {
				lavanteUtils.click(objViewPaymentsPage.CommentDropDwn().get(0));
				lavanteUtils.click(objViewPaymentsPage.MarkAllReadLink().get(0));
			}
		}

		// Adding public comments
		String addPublicComment1 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment1);
		dataMap.put("PublicComment", "");
		objViewPaymentsPage.addComment(dataMap);
		lavanteUtils.refreshPage();
		lavanteUtils.waitforPageload(objViewPaymentsPage.addCommentTxt());

		// Editing a comment
		flag = false;
		lavanteUtils.fluentwait(objViewPaymentsPage.PublicCommentsList().get(0));
		String coomentIcon = objViewPaymentsPage.CommentOptionIcon.replace("$", addPublicComment1);
		WebElement CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.clicks(CommentOptionIcon);
		String options = objViewPaymentsPage.ListCommentOptions.replace("$", addPublicComment1);
		List<WebElement> opt = lavanteUtils.driver.findElements(By.xpath(options));

		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Edit")) {
				lavanteUtils.clicks(opt.get(j));
				flag = true;
				break;
			}
		}
		Reporter.log("Edit link to edit the comment , Expected : true , Actual : " + flag);
		Assert.assertTrue(flag, " Comment not Edited sucessfully , Expected : true, Actual: ," + flag);
		
		String editedComment = "AutoBV_Public" + generateRandomNumber9OnLength(7);
		WebElement editElement = lavanteUtils.driver
				.findElement(By.xpath(objViewPaymentsPage.EditCommentTxtArea.replace("$", addPublicComment1)));
		editElement.clear();
		lavanteUtils.typeinEdit(editedComment, editElement);
		WebElement saveElement = lavanteUtils.driver
				.findElement(By.xpath(objViewPaymentsPage.SaveComment.replace("$", addPublicComment1)));
		lavanteUtils.clicks(saveElement);
		lavanteUtils.fluentwait(objViewPaymentsPage.PublicCommentsList().get(0));
		
		String actualComment = "";
		List<WebElement> publicComs = objViewPaymentsPage.PublicCommentsList();
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
		coomentIcon = objViewPaymentsPage.CommentOptionIcon.replace("$", editedComment);
		CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.fluentwait(CommentOptionIcon);
		lavanteUtils.clicks(CommentOptionIcon);
		options = objViewPaymentsPage.ListCommentOptions.replace("$", editedComment);
		opt = lavanteUtils.driver.findElements(By.xpath(options));
		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Delete")) {
				lavanteUtils.clicks(opt.get(j));
				lavanteUtils.fluentwait(objViewPaymentsPage.AddCommentsBtn());
				lavanteUtils.click(objViewPaymentsPage.DeleteBtn());
				flag = true;
				break;
			}
		}
		Reporter.log("No Delete link to delete the comment , Expected : true , Actual : " + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);

		flag = false;
		lavanteUtils.fluentwait(objViewPaymentsPage.PublicCommentsList().get(0));
		publicComs = objViewPaymentsPage.PublicCommentsList();
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
		objViewPaymentsPage.addComment(dataMap);

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
		dataMap.put("subtab", "customerPaymentResult");
		enobjhomePage.selectTab(dataMap);
		dataMap.clear();
		flag = false;
		dataMap.put("InvoiceNumber", invoiceNo);
		dataMap.put("PaymentRefNo", paymentReferenceNo);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.waitForTime(5000);
		List<WebElement> paymentRefNoList = objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No");
		int i = 0;
		if (paymentRefNoList.size() > 0) {
			for (i = 0; i < paymentRefNoList.size(); i++) {
				String actInvoice = objPaymentsPage.iterateSearchHeaderFindColList("Invoice Number").get(i).getText();
				Reporter.log("Customer Login,Payment Reference number Search results, Expected: " + paymentReferenceNo
						+ " Actual: " + paymentRefNoList.get(i).getText(), true);
				softAssert.assertEquals(paymentRefNoList.get(i).getText(), paymentReferenceNo,
						"Customer Login,Payment Reference number Search results are not matching, Expected: "
								+ paymentReferenceNo + " Actual: " + paymentRefNoList.get(i).getText());
				Reporter.log("Invoice number Search results, Expected: " + invoiceNo + " Actual: " + actInvoice, true);
				softAssert.assertEquals(actInvoice, invoiceNo,
						"Customer Login,Invoice number Search results are not matching, Expected: " + invoiceNo
								+ " Actual: " + actInvoice);
				flag = true;
				break;
			}
		} else {
			Reporter.log("Customer Login,Search results are not matching");
			Assert.assertEquals("Customer Login,No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(i));
		lavanteUtils.waitForTime(5000);

		flag = false;
		boolean flag2=false;
		publicComs = objViewPaymentsPage.PublicCommentsList();
		for (int k = 0; k < publicComs.size(); k++) {
			actualComment = publicComs.get(k).getText();
			if (actualComment.equals(publicComment)) {
				flag = true;
				
				String obj = objViewPaymentsPage.CommentOptionIcon.replace("$", publicComment);
				opt = lavanteUtils.driver.findElements(By.xpath(obj));
				if (!lavanteUtils.isElementPresent(opt)) {
					flag2 = true;
				}
				break;
			}
		}

		Reporter.log("Public comments added by customer and searched by supplier, Expected :" + publicComment
				+ ", Actual :" + actualComment);
		softAssert.assertTrue(flag,
				"Mismatch in the public comments added by customer and searched by supplier, Expected :" + publicComment
						+ ", Actual :" + actualComment);

		
		Reporter.log("Verify edit or delete option , Expected : true,  Actual :" + flag2);
		softAssert.assertTrue(flag2," Edit/Delete option is displayed which should not be the case, Expected : true,  Actual :" + flag);
	
		//Can be removed if needed
		if (lavanteUtils.isElementDisplayed(objViewPaymentsPage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewPaymentsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewPaymentsPage.MarkAllReadLink().get(0));
		}
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Verify EditDeleteComments Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Verify Role EDIT_COMMENT_ROLE  mapped to login role
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
		dataMap.put("maintab", "PAYMENTS");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		lavanteUtils.waitForTime(5000);
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String paymentReferenceNo = objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0).getText();
		String invoiceNo = objPaymentsPage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> claimCount = enobjsupplierPage.iterateSearchHeaderFindColList("# Of Claims");
		if (claimCount.size() > 0) {
			for (int i = 0; i < claimCount.size(); i++) {
				Reporter.log("Supplier Login,Claim Count Search results, Expected: Greater than 0 Actual: "
						+ claimCount.get(i).getText());
				softAssert.assertTrue(Integer.parseInt(claimCount.get(i).getText()) > 0,
						"Supplier Login,Claim Count Search results, Expected: Greater than 0 Actual: "
								+ claimCount.get(i).getText());
				flag = true;
				break;
			}
		} else {
			Reporter.log("No Search results");
			Assert.assertEquals("No results", objPaymentsPage.NoData().getText());
			flag = true;
		}
		
		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0));
		lavanteUtils.waitForTime(5000);
		if (!lavanteUtils.isElementDisplayed(objViewPaymentsPage.addCommentBtn())) {
			if (lavanteUtils.isElementPresent(objViewPaymentsPage.GetUnreadCommentCount())) {
				lavanteUtils.click(objViewPaymentsPage.CommentDropDwn().get(0));
				lavanteUtils.click(objViewPaymentsPage.MarkAllReadLink().get(0));
			}
		}

		// Adding public comments
		String addPublicComment1 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment1);
		dataMap.put("PublicComment", "");
		objViewPaymentsPage.addComment(dataMap);

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

		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerPaymentResult");
		enobjhomePage.selectTab(dataMap);
		dataMap.clear();
		flag = false;
		dataMap.put("InvoiceNumber", invoiceNo);
		dataMap.put("PaymentRefNo", paymentReferenceNo);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.waitForTime(5000);
		List<WebElement> paymentRefNoList = objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No");
		int i = 0;
		if (paymentRefNoList.size() > 0) {
			for (i = 0; i < paymentRefNoList.size(); i++) {
				String actInvoice = objPaymentsPage.iterateSearchHeaderFindColList("Invoice Number").get(i).getText();
				Reporter.log("Customer Login,Payment Reference number Search results, Expected: " + paymentReferenceNo
						+ " Actual: " + paymentRefNoList.get(i).getText(), true);
				softAssert.assertEquals(paymentRefNoList.get(i).getText(), paymentReferenceNo,
						"Customer Login,Payment Reference number Search results are not matching, Expected: "
								+ paymentReferenceNo + " Actual: " + paymentRefNoList.get(i).getText());
				Reporter.log("Invoice number Search results, Expected: " + invoiceNo + " Actual: " + actInvoice, true);
				softAssert.assertEquals(actInvoice, invoiceNo,
						"Customer Login,Invoice number Search results are not matching, Expected: " + invoiceNo
								+ " Actual: " + actInvoice);
				flag = true;
				break;
			}
		} else {
			Reporter.log("Customer Login,Search results are not matching");
			Assert.assertTrue(false, "Customer Login,Search results are not matching");
		}

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(i));
		lavanteUtils.waitForTime(5000);

		flag = false;
		String actualComment1 = null;
		actualComment1 = null;
		List<WebElement> publicComs = objViewPaymentsPage.PublicCommentsList();
		for (int j = 0; j < publicComs.size(); j++) {
			actualComment1 = publicComs.get(j).getText();
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
		lavanteUtils.fluentwait(objViewPaymentsPage.PublicCommentsList().get(0));
		String coomentIcon = objViewPaymentsPage.CommentOptionIcon.replace("$", addPublicComment1);
		WebElement CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.clicks(CommentOptionIcon);
		String options = objViewPaymentsPage.ListCommentOptions.replace("$", addPublicComment1);
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
				.findElement(By.xpath(objViewPaymentsPage.EditCommentTxtArea.replace("$", addPublicComment1)));
		editElement.clear();
		lavanteUtils.typeinEdit(editedComment, editElement);
		WebElement saveElement = lavanteUtils.driver
				.findElement(By.xpath(objViewPaymentsPage.SaveComment.replace("$", addPublicComment1)));
		lavanteUtils.clicks(saveElement);
		lavanteUtils.fluentwait(objViewPaymentsPage.PublicCommentsList().get(0));
		String actualComment = "";
		publicComs = objViewPaymentsPage.PublicCommentsList();
		for (int j = 0; j < publicComs.size(); j++) {
			actualComment = publicComs.get(j).getText();
			if (actualComment.equals(editedComment)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Verify edited comment, Expected : " + editedComment + ", Actual : " + actualComment);
		softAssert.assertEquals(actualComment, editedComment,
				" Edited comment is not same/displayed , Expected : " + editedComment + ", Actual : " + actualComment);

		if (lavanteUtils.isElementDisplayed(objViewPaymentsPage.GetUnreadCommentCount().get(0))) {
			lavanteUtils.click(objViewPaymentsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewPaymentsPage.MarkAllReadLink().get(0));
		}

		softAssert.assertAll();
		Reporter.log("Test Ended for Verify Edit Comments Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Verify Role DELETE_COMMENT_ROLE  mapped to login role
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
		dataMap.put("maintab", "PAYMENTS");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		lavanteUtils.waitForTime(5000);
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String paymentReferenceNo = objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0).getText();
		String invoiceNo = objPaymentsPage.iterateSearchHeaderFindColList("Invoice Number").get(0).getText();

		List<WebElement> claimCount = enobjsupplierPage.iterateSearchHeaderFindColList("# Of Claims");
		if (claimCount.size() > 0) {
			for (int i = 0; i < claimCount.size(); i++) {
				Reporter.log("Supplier Login,Claim Count Search results, Expected: Greater than 0 Actual: "
						+ claimCount.get(i).getText());
				softAssert.assertTrue(Integer.parseInt(claimCount.get(i).getText()) > 0,
						"Supplier Login,Claim Count Search results, Expected: Greater than 0 Actual: "
								+ claimCount.get(i).getText());
				flag = true;
				break;
			}
		} else {
			Reporter.log("Search results are not matching");
			Assert.assertTrue(false, " Search results are not matching");
			flag = true;
		}
		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0));
		lavanteUtils.waitForTime(5000);
		if (!lavanteUtils.isElementDisplayed(objViewPaymentsPage.addCommentBtn())) {
			if (lavanteUtils.isElementPresent(objViewPaymentsPage.GetUnreadCommentCount())) {
				lavanteUtils.click(objViewPaymentsPage.CommentDropDwn().get(0));
				lavanteUtils.click(objViewPaymentsPage.MarkAllReadLink().get(0));
			}
		}

		// Adding public comments
		String addPublicComment1 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment1);
		dataMap.put("PublicComment", "");
		objViewPaymentsPage.addComment(dataMap);
		String addPublicComment2 = "AutoBV_Public" + lavanteUtils.generateRandomNumber9OnLength(7);
		dataMap.put("EnterComment", addPublicComment2);
		dataMap.put("PublicComment", "");
		objViewPaymentsPage.addComment(dataMap);
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

		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerPaymentResult");
		enobjhomePage.selectTab(dataMap);
		dataMap.clear();
		flag = false;
		dataMap.put("InvoiceNumber", invoiceNo);
		dataMap.put("PaymentRefNo", paymentReferenceNo);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.waitForTime(5000);
		List<WebElement> paymentRefNoList = objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No");
		int i = 0;
		if (paymentRefNoList.size() > 0) {
			for (i = 0; i < paymentRefNoList.size(); i++) {
				String actInvoice = objPaymentsPage.iterateSearchHeaderFindColList("Invoice Number").get(i).getText();
				Reporter.log("Customer Login,Payment Reference number Search results, Expected: " + paymentReferenceNo
						+ " Actual: " + paymentRefNoList.get(i).getText(), true);
				softAssert.assertEquals(paymentRefNoList.get(i).getText(), paymentReferenceNo,
						"Customer Login,Payment Reference number Search results are not matching, Expected: "
								+ paymentReferenceNo + " Actual: " + paymentRefNoList.get(i).getText());
				Reporter.log("Invoice number Search results, Expected: " + invoiceNo + " Actual: " + actInvoice, true);
				softAssert.assertEquals(actInvoice, invoiceNo,
						"Customer Login,Invoice number Search results are not matching, Expected: " + invoiceNo
								+ " Actual: " + actInvoice);
				flag = true;
				break;
			}
		} else {
			Reporter.log("Customer Login,Search results are not matching");
			Assert.assertEquals("Customer Login,No results", enClaimsPage.NoData().getText());
			flag = true;
		}
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());

		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(i));
		lavanteUtils.waitForTime(5000);

		flag = false;
		String actualComment1 = null;
		actualComment1 = null;
		List<WebElement> publicComs = objViewPaymentsPage.PublicCommentsList();
		for (int j = 0; j < publicComs.size(); j++) {
			actualComment1 = publicComs.get(j).getText();
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
		lavanteUtils.fluentwait(objViewPaymentsPage.PublicCommentsList().get(0));
		String coomentIcon = objViewPaymentsPage.CommentOptionIcon.replace("$", addPublicComment1);
		WebElement CommentOptionIcon = lavanteUtils.driver.findElement(By.xpath(coomentIcon));
		lavanteUtils.clicks(CommentOptionIcon);
		String options = objViewPaymentsPage.ListCommentOptions.replace("$", addPublicComment1);
		List<WebElement> opt = lavanteUtils.driver.findElements(By.xpath(options));
		for (int j = 0; j < opt.size(); j++) {
			String getTxt = lavanteUtils.getText(opt.get(j));
			if (getTxt.equals("Delete")) {
				lavanteUtils.clicks(opt.get(j));
				lavanteUtils.fluentwait(objViewPaymentsPage.AddCommentsBtn());
				lavanteUtils.clicks(objViewPaymentsPage.DeleteBtn());
				flag = true;
				break;
			}
		}
		Reporter.log("No Delete link to delete the comment , Expected : true , Actual : " + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);
		lavanteUtils.waitforPageload(objViewPaymentsPage.PublicCommentsList().get(0));
		flag = false;
		publicComs = objViewPaymentsPage.PublicCommentsList();
		for (int j = 0; j < publicComs.size(); j++) {
			if (!publicComs.get(j).getText().equals(addPublicComment1)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		Reporter.log("Verify comment deleted sucessfully , Expected : true, Actual: ," + flag);
		softAssert.assertTrue(flag, " Comment not deleted sucessfully , Expected : true, Actual: ," + flag);

		if (lavanteUtils.isElementPresent(objViewPaymentsPage.GetUnreadCommentCount())) {
			lavanteUtils.click(objViewPaymentsPage.CommentDropDwn().get(0));
			lavanteUtils.click(objViewPaymentsPage.MarkAllReadLink().get(0));
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
