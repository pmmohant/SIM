package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class ManageAlertsTC002 extends PageInitiator {

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
		List listofdatafrm = lavanteUtils.login("ManageAlert002", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		enobjhomePage.Alertselect();
		
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */

	@Test
	public void manageAlertsTest004() throws Exception {
		Reporter.log("Test Started for manageAlertsTest001 : " + currenttime());
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.click(objSupplierAlertPage.AddAlertBtn());
		lavanteUtils.switchtoFrame(objSupplierAlertPage.AlertIframe());

		boolean flag0 = false;
		String expectedType = "checkbox";
		String actualType = lavanteUtils.getValue(objSupplierAlertPage.RoleChkBoxinput(), "type");
		String actualType1 = lavanteUtils.getValue(objSupplierAlertPage.UserChkBoxinput(), "type");
		if (expectedType.equals(actualType) && expectedType.equals(actualType1)) {
		//	if (!objSupplierAlertPage.RoleChkBox().isSelected() && objSupplierAlertPage.UserChkBox().isSelected()) {
				flag0 = true;
		//	}
		}
		Reporter.log("Verify show radio button with 'Role' and 'User'. By default, the 'User' selection is selected, Expected : "	+ expectedType + ", Actual : " + actualType + ", Actual1 : " + actualType1);
		softAssert.assertTrue(flag0,"Verify show radio button with 'Role' and 'User'. By default, the 'User' selection is selected, Expected : "+ expectedType + ", Actual : " + actualType + ", Actual1 : " + actualType1);
	
		
		boolean flag1 = false;
		if (objSupplierAlertPage.CancelBtn().isDisplayed() 	&& objSupplierAlertPage.SaveBtn().isDisplayed()) {
			flag1 = true;
		}
		Reporter.log(" Verify the Cancel,  Save buttons exists ");
		softAssert.assertTrue(flag1, " Verify the Cancel, Save buttons exists");
		
		List<String> expectedMandatoryFields = new ArrayList<String>();
		expectedMandatoryFields.add(0, "Entity:");
		expectedMandatoryFields.add(1, "Saved Query:");
		expectedMandatoryFields.add(2, "Alert Name:");
		expectedMandatoryFields.add(3, "Email Subject:");
		expectedMandatoryFields.add(4, "Send To:");
		expectedMandatoryFields.add(5, "Frequency:");
		expectedMandatoryFields.add(6, "Specify Time:");
		expectedMandatoryFields.add(7, "Delivery Start Date:");
		expectedMandatoryFields.add(8, "Alert Template Format Used:");
		Boolean flag = false;
		List<String> actualMandatoryFields = new ArrayList<String>();
		int mandatoryFieldsSize = objSupplierAlertPage.AddAlertMandatoryFieldsList().size();
		for (int i = 0; i < mandatoryFieldsSize; i++) {
			String mandatoryField = lavanteUtils.getText(objSupplierAlertPage.AddAlertMandatoryFieldsList().get(i));
			actualMandatoryFields.add(i, mandatoryField);
		}
		System.out.println("expectedMandatoryFields "+expectedMandatoryFields +"\n actualMandatoryFields "+actualMandatoryFields);
		if (expectedMandatoryFields.equals(actualMandatoryFields)) {
			flag = true;
		}

		Reporter.log(" Verification for Mandatory Fields in AddAlert popup, Expected : " + expectedMandatoryFields	+ ", Actual : " + actualMandatoryFields);
		softAssert.assertTrue(flag, " Verification failed for Mandatory Fields in AddAlert popup, Expected : "+ expectedMandatoryFields + ", Actual : " + actualMandatoryFields);

		softAssert.assertAll();
		Reporter.log("Test Ended at: " + currenttime());
	}


	
	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author Subhas.BV
	 */
	@AfterClass
	public void setupAfterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
