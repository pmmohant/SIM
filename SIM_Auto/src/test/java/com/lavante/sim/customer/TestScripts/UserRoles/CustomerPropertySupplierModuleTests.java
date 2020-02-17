package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
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
import com.lavante.sim.customer.pageobjects.Suppliers.EditProfile.EditProfilePage;

public class CustomerPropertySupplierModuleTests extends PageInitiator {
	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	LinkedHashMap<String, String> LdataMap = null;

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhash.BV
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

		// Login
		List listofdatafrm = lavanteUtils.login("CustProperty", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		// Supplier Tab
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Customer Property IS_SUPPLIER_GROUP_REQUIRED (Verify Supplier
	 *         Group should be a mandatory field)
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_SUPPLIER_GROUP_REQUIREDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for IS_SUPPLIER_GROUP_REQUIRED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID=1 ";
		lavanteUtils.UpdateDB(delete);

		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "any");
		dataMap.put("reason", "any");
		dataMap.put("contactName", "any");
		dataMap.put("email", "any");
		dataMap.put("invite", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		String supplierName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		Reporter.log("Supplier not invited , Expected : " + dataMap.get("supplierName") + " , Actual :" + supplierName);
		softAssert.assertEquals(supplierName, dataMap.get("supplierName"),
				"Customer property IS_SUPPLIER_GROUP_REQUIRED not configured in customerPropertyValue, Supplier not invited , Expected : "
						+ dataMap.get(supplierName) + " , Actual :" + supplierName);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES (1, "
				+ customerID + ", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();
		dataMap.clear();
		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "any");
		dataMap.put("reason", "any");
		dataMap.put("contactName", "any");
		dataMap.put("email", "any");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		lavanteUtils.click(enobjInvitenewSupplier.suppInvitebtn());

		WebElement ele = driver.findElement(By.cssSelector("span[data-messagebag-id*='supplierGroup']"));
		String actualManMsg = lavanteUtils.getText(ele);
		String expectedManMsg = "'Supplier Group' cannot be left blank.";

		Reporter.log("Verification of Supplier Group mandatory msg , Expected : " + expectedManMsg + " , Actual :"
				+ actualManMsg);
		softAssert.assertEquals(actualManMsg, expectedManMsg,
				"Customer property IS_SUPPLIER_GROUP_REQUIRED not configured in customerPropertyValue, Verification of Supplier Group mandatory msg , Expected : "
						+ expectedManMsg + " , Actual :" + actualManMsg);
		softAssert.assertAll();
		Reporter.log("Test Ended for IS_SUPPLIER_GROUP_REQUIRED Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Customer Property IS_TALENT_AGENT_REQUIRED(Verify Create New
	 *         Supplier Agent displayed)
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_TALENT_AGENT_REQUIREDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for IS_TALENT_AGENT_REQUIRED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID=2 ";
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		boolean flag = false;
	/*	if (!lavanteUtils.isElementDisplayed(enobjsupplierPage.CreateNewSupAgentlink())) {
			flag = true;
		}*/
		Reporter.log(
				"Validation of customer property IS_TALENT_AGENT_REQUIRED not configured in customerPropertyValue : Expected : true , Actual : "
						+ flag);
		softAssert.assertTrue(flag,
				"Customer property IS_TALENT_AGENT_REQUIRED not configured in customerPropertyValue, verification failed : Expected : true , Actual : "
						+ flag);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES (2, "
				+ customerID + ", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		flag = false;
		/*if (lavanteUtils.isElementDisplayed(enobjsupplierPage.CreateNewSupAgentlink())) {
			flag = true;
		}*/
		Reporter.log(
				"Validation of customer property IS_TALENT_AGENT_REQUIRED with configured in customerPropertyValue : Expected : true , Actual : "
						+ flag);
		softAssert.assertTrue(flag,
				"Customer property IS_TALENT_AGENT_REQUIRED with configured in customerPropertyValue, verification failed  : Expected : true , Actual : "
						+ flag);

		softAssert.assertAll();
		Reporter.log("Test Ended for IS_TALENT_AGENT_REQUIRED Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Customer Property IS_JUSTIFY_INVITATION_REQUIRED(Verify Reason
	 *         for New Supplier should be a mandatory field)
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_JUSTIFY_INVITATION_REQUIREDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for IS_JUSTIFY_INVITATION_REQUIRED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID=3 ";
		lavanteUtils.UpdateDB(delete);

		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "any");
		dataMap.put("suppgrp", "any");
		dataMap.put("contactName", "any");
		dataMap.put("email", "any");
		dataMap.put("invite", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		String supplierName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		Reporter.log("Supplier not invited , Expected : " + dataMap.get("supplierName") + " , Actual :" + supplierName);
		softAssert.assertEquals(supplierName, dataMap.get("supplierName"),
				"Customer property IS_JUSTIFY_INVITATION_REQUIRED not configured in customerPropertyValue, Supplier not invited , Expected : "
						+ dataMap.get(supplierName) + " , Actual :" + supplierName);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES (3, "
				+ customerID + ", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		dataMap.clear();
		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "any");
		dataMap.put("suppgrp", "any");
		dataMap.put("contactName", "any");
		dataMap.put("email", "any");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		lavanteUtils.click(enobjInvitenewSupplier.suppInvitebtn());

		WebElement ele = driver.findElement(By.cssSelector("span[data-messagebag-id*='supplierInviteJustification']"));
		String actualManMsg = lavanteUtils.getText(ele);
		String expectedManMsg = "'Reason for New Supplier' cannot be left blank.";

		Reporter.log("Verification of Reason for New Supplier mandatory msg , Expected : " + expectedManMsg
				+ " , Actual :" + actualManMsg);
		softAssert.assertEquals(actualManMsg, expectedManMsg,
				"Customer property IS_JUSTIFY_INVITATION_REQUIRED not configured in customerPropertyValue, Verification of Reason for New Supplier mandatory msg , Expected : "
						+ expectedManMsg + " , Actual :" + actualManMsg);

		softAssert.assertAll();
		Reporter.log("Test Ended for IS_JUSTIFY_INVITATION_REQUIRED Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Customer Property IS_TAKECONTROL_HIDDEN
	 * @throws Exception
	 * 
	 */
	// @Test
	public void IS_TAKECONTROL_HIDDENTest() throws Exception {
		Reporter.log("Test Started for IS_TAKECONTROL_HIDDEN Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID=4 ";
		lavanteUtils.UpdateDB(delete);

		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "any");
		dataMap.put("suppgrp", "any");
		dataMap.put("reason", "any");
		dataMap.put("contactName", "any");
		dataMap.put("email", "any");
		dataMap.put("invite", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);

		String supplierName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		dataMap.put("supplierName", "supplierName");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		boolean flag = false;
		if (lavanteUtils.isElementDisplayed(enobjsupplierPage.TakeControlbtn())) {
			flag = true;
		}
		Reporter.log("Supplier not invited , Expected : true , Actual :" + flag);
		softAssert.assertEquals(supplierName, dataMap.get("supplierName"),
				"Customer property IS_TAKECONTROL_HIDDEN not configured in customerPropertyValue, Supplier not invited , Expected : true , Actual :"
						+ flag);

		lavanteUtils.fluentwait(enobjsupplierPage.TakeControlbtn());
		lavanteUtils.click(enobjsupplierPage.TakeControlbtn());
		lavanteUtils.switchtoFrame(null);

		Reporter.log("Supplier not invited , Expected : " + dataMap.get("supplierName") + " , Actual :" + supplierName);
		softAssert.assertEquals(supplierName, dataMap.get("supplierName"),
				"Customer property IS_TAKECONTROL_HIDDEN not configured in customerPropertyValue, Supplier not invited , Expected : "
						+ dataMap.get(supplierName) + " , Actual :" + supplierName);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES (4, "
				+ customerID + ", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		dataMap.clear();
		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "any");
		dataMap.put("suppgrp", "any");
		dataMap.put("reason", "any");
		dataMap.put("contactName", "any");
		dataMap.put("email", "any");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		lavanteUtils.click(enobjInvitenewSupplier.suppInvitebtn());

		WebElement ele = driver.findElement(By.cssSelector("div[class*='ui-dialog-content']"));
		String actualManMsg = lavanteUtils.getText(ele);
		String expectedManMsg = "You have successfully taken control of this supplier's profile. If you wish to edit the supplier's profile, click ‘Yes’ else click ‘No’.";

		Reporter.log("Verification of Reason for New Supplier mandatory msg , Expected : " + expectedManMsg
				+ " , Actual :" + actualManMsg);
		softAssert.assertEquals(actualManMsg, expectedManMsg,
				"Customer property IS_TAKECONTROL_HIDDEN not configured in customerPropertyValue, Verification of Reason for New Supplier mandatory msg , Expected : "
						+ expectedManMsg + " , Actual :" + actualManMsg);

		softAssert.assertAll();
		Reporter.log("Test Ended for IS_TAKECONTROL_HIDDEN Test:" + currenttime());
	}

	/*
	 * @author subhas.bv
	 * 
	 * Customer Property
	 * HIDE_INSURANCE_TABLE_AND_TEXTAREA_CORE_CERTIFICATIONS_TAB
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void HIDE_INSURANCE_TABLE_AND_TEXTAREA_CORE_CERTIFICATIONS_TABTest() throws Exception {
		Reporter.log(
				"Test Started for HIDE_INSURANCE_TABLE_AND_TEXTAREA_CORE_CERTIFICATIONS_TAB Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='HIDE_INSURANCE_TABLE_AND_TEXTAREA_CORE_CERTIFICATIONS_TAB' ) ";
		lavanteUtils.UpdateDB(delete);

		String supplierName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		dataMap.put("supplierName", "supplierName");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierProfileCertifications");
		dataMap.put("Leavethis", "");		
		eneditProfile.selectTab(dataMap);
		
		boolean flag = false;
		if (lavanteUtils.isElementDisplayed(enobjsupplierPage.TakeControlbtn())) {
			flag = true;
		}
		Reporter.log("Supplier not invited , Expected : true , Actual :" + flag);
		softAssert.assertEquals(supplierName, dataMap.get("supplierName"),
				"Customer property IS_TAKECONTROL_HIDDEN not configured in customerPropertyValue, Supplier not invited , Expected : true , Actual :"
						+ flag);

		lavanteUtils.fluentwait(enobjsupplierPage.TakeControlbtn());
		lavanteUtils.click(enobjsupplierPage.TakeControlbtn());
		lavanteUtils.switchtoFrame(null);

		Reporter.log("Supplier not invited , Expected : " + dataMap.get("supplierName") + " , Actual :" + supplierName);
		softAssert.assertEquals(supplierName, dataMap.get("supplierName"),
				"Customer property IS_TAKECONTROL_HIDDEN not configured in customerPropertyValue, Supplier not invited , Expected : "
						+ dataMap.get(supplierName) + " , Actual :" + supplierName);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES (11, "
				+ customerID + ", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		WebElement ele = driver.findElement(By.cssSelector("div[class*='ui-dialog-content']"));
		String actualManMsg = lavanteUtils.getText(ele);
		String expectedManMsg = "You have successfully taken control of this supplier's profile. If you wish to edit the supplier's profile, click ‘Yes’ else click ‘No’.";

		Reporter.log("Verification of Reason for New Supplier mandatory msg , Expected : " + expectedManMsg
				+ " , Actual :" + actualManMsg);
		softAssert.assertEquals(actualManMsg, expectedManMsg,
				"Customer property IS_TAKECONTROL_HIDDEN not configured in customerPropertyValue, Verification of Reason for New Supplier mandatory msg , Expected : "
						+ expectedManMsg + " , Actual :" + actualManMsg);

		softAssert.assertAll();
		Reporter.log("Test Ended for HIDE_INSURANCE_TABLE_AND_TEXTAREA_CORE_CERTIFICATIONS_TAB Test:" + currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
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
