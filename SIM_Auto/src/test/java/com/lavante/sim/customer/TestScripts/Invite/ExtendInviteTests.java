package com.lavante.sim.customer.TestScripts.Invite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ExtendInviteTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String loginUser = "";

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
		List listofdatafrm = lavanteUtils.login("AddSupplierID", browser);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		loginUser = dataMap.get("username");
		System.out.println("Login User " + loginUser);
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();
	}

	/**
	 * 
	 * @author subhas.bv
	 */
	@Test
	public void SendInviteSupplierLogin() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for inviteSupplierValidateTest : " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());

		Reporter.log("Invite New Supplier:");
		String supName = "SupAuto" + lavanteUtils.currenttime();
		String emailId = "A" + lavanteUtils.currenttime() + "@gmail.com";

		dataMap.put("supplierName", supName);
		dataMap.put("inviteorg", "any");
		dataMap.put("contactName", supName);
		dataMap.put("email", emailId);
		dataMap.put("inviteorg", "any");
		dataMap.put("invite", "");
		enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		String[] dataContent = null;
		enobjsupplierPage.selectChangeView("Invites");
		String inviteID = "";
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		if (supName.equals(enobjsupplierPage.getColumnText("Supplier Name", 0))) {
			inviteID = enobjsupplierPage.getColumnText("Invitation ID", 0);
		} else {
			Assert.assertTrue(false, "Invited supplier not found in search table");
		}
		
		enobjhomePage.logout();

		Reporter.log("Get Registration Strong Link Url :");
		lavanteUtils.navigatetoAccSetup(dataContent);

		Reporter.log("Fill account setup page :");
		String password = "Lavante@123";
		dataMap.put("setpass", password);
		dataMap.put("confirmpass", password);
		dataMap.put("chquestion", "any");
		dataMap.put("chanswer", "Test");
		dataMap.put("checkconfirm", "");
		dataMap.put("nextbttn", "");
		objSimAccSetupPages.accSetup(dataMap);

		Reporter.log("Fill company registration page :");
		String EINID = lavanteUtils.generateRandomNumber9OnLength(9);

		dataMap.put("BusinessName", "BusNam" + EINID);
		dataMap.put("EINNum", EINID);
		dataMap.put("nextbttn", "");
		objSimAccSetupPages.CompanyRegistration(dataMap);

		lavanteUtils.fluentwait(enObjSupplierHomePage.OkBtn());
		lavanteUtils.click(enObjSupplierHomePage.OkBtn());

		String customerName = lavanteUtils.getText(enObjSupplierHomePage.ListCustomer().get(0));
		String getInviteID = lavanteUtils.getText(enObjSupplierHomePage.ListInvite().get(0));

		String getCustomerName = "select [Name] from Customer where CustomerID in(select CustomerID from Customer_Contact_Map where ContactID in(select ContactID from Contact where Email='"
				+ loginUser + "' ) )";
		getCustomerName = lavanteUtils.fetchDBdata(getCustomerName);
		Reporter.log("Validating customer name and invite id from Supplier portal :");

		softAssert.assertEquals(customerName, getCustomerName,
				"Invalid Customer name in the supplier portal, Expected : " + getCustomerName + ", Actual : "
						+ customerName);
		softAssert.assertEquals( getInviteID,inviteID,
				"Invalid InviteID in the supplier portal, Expected : " + inviteID + ", Actual : " + getInviteID);
		
		softAssert.assertAll();
		Reporter.log("Test completed for inviteSupplierValidateTest : " + currenttime());
	}

	/**
	 * 
	 * @author subhas.bv
	 */
	@Test
	public void extendInviteSupplierLogin() throws Exception {
		Reporter.log("Test Started for extendSupplierValidateTest : " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());

		Reporter.log("Invite New Supplier:");
		String supName = "SupAuto" + lavanteUtils.generateRandomNumber9OnLength(9);
		String emailId = "A" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com";

		dataMap.put("supplierName", supName);
		dataMap.put("inviteorg", "any");
		dataMap.put("contactName", supName);
		dataMap.put("email", emailId);
		dataMap.put("inviteorg", "any");
		dataMap.put("invite", "");
		String[] dataContent = enobjInvitenewSupplier.inviteNwSupp(dataMap);

		enobjsupplierPage.selectChangeView("Suppliers and Invites");
		
		supName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		dataMap.put("supplierName", supName);
		dataMap.put("Invitation", "");
		dataMap.put("ExtendInvite", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		Reporter.log("Supplier Selected for Extend invite :" + supName);

		dataMap.clear();
		lavanteUtils.click(enobjInvitenewSupplier.PrimaryContactRadioBtn());
		dataMap.put("inviteorg", "any");
		dataMap.put("invite", "");
		enobjInvitenewSupplier.fillInviteDetails(dataMap);
		enobjInvitenewSupplier.formSuppAction(dataMap);
		
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		enobjsupplierPage.selectChangeView("Invites");
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		String inviteID = "";
		if (supName.equals(enobjsupplierPage.getColumnText("Supplier Name", 0))) {
			inviteID = enobjsupplierPage.getColumnText("Invitation ID", 0);
			dataContent[2] = inviteID;
		} else {
			softAssert.assertTrue(false, "Invited supplier not found in search table");

		}
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.logout();

		Reporter.log("Get Registration Strong Link Url :");
		lavanteUtils.navigatetoAccSetup(dataContent);

		Reporter.log("Fill account setup page :");
		String password = "Lavante@123";
		dataMap.put("setpass", password);
		dataMap.put("confirmpass", password);
		dataMap.put("chquestion", "any");
		dataMap.put("chanswer", "Test");
		dataMap.put("checkconfirm", "");
		dataMap.put("nextbttn", "");
		objSimAccSetupPages.accSetup(dataMap);

		Reporter.log("Fill company registration page :");
		String EINID = lavanteUtils.generateRandomNumber9OnLength(9);

		dataMap.put("BusinessName", "BusNam" + EINID);
		dataMap.put("EINNum", EINID);
		dataMap.put("nextbttn", "");
		objSimAccSetupPages.CompanyRegistration(dataMap);

		lavanteUtils.fluentwait(enObjSupplierHomePage.OkBtn());
		lavanteUtils.click(enObjSupplierHomePage.OkBtn());

		String customerName = lavanteUtils.getText(enObjSupplierHomePage.ListCustomer().get(0));
		String getInviteID = lavanteUtils.getText(enObjSupplierHomePage.ListInvite().get(0));

		String getCustomerName = "select [Name] from Customer where CustomerID in(select CustomerID from Customer_Contact_Map where ContactID in(select ContactID from Contact where Email='"
				+ loginUser + "' ) )";
		getCustomerName = lavanteUtils.fetchDBdata(getCustomerName);
		Reporter.log("Validating customer name and invite id from Supplier portal :");

		softAssert.assertEquals(customerName, getCustomerName,				"Invalid Customer name in the supplier portal, Expected : " + getCustomerName + ", Actual : "
						+ customerName);
		softAssert.assertEquals(inviteID, getInviteID,				"Invalid InviteID in the supplier portal, Expected : " + inviteID + ", Actual : " + getInviteID);
		softAssert.assertAll();
		Reporter.log("Test completed for extendSupplierValidateTest : " + currenttime());
	}



	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
