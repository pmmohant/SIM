package com.lavante.sim.customer.TestScripts.UserRoles;

import java.util.LinkedHashMap;
import java.util.List;

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

/**
 * Created on 21-09-2016 Created for Verifying SIM User Roles
 * 
 * @author Subhash.BV
 *
 */

public class RecoveryCustomerTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

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
		List listofdatafrm = lavanteUtils.login("UserRoleId4", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	/**
	 * 
	 * UserRoles: Verify that only Recovery customer should not be able to
	 * Activate,Deactivate,Send Message, Download Documents Verify that Recovery
	 * Customer should not be able to Outreach
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */

	@Test
	public void verifyRecoveryCustomerActionsTest() throws Exception {
		Reporter.log("Test Started for verifyRecoveryCustomerActionsTest:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
		enobjsupplierPage.searchResultsFilterBy("ALL");

		dataMap.put("Invitation", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.fluentwait(enobjsupplierPage.sendEmailbtn());
		String actualValue = enobjsupplierPage.sendEmailbtn().getAttribute("disabled");
		String expectedValue = "disabled";

		if ((actualValue==null) || (!actualValue.contains(expectedValue))) {
			Reporter.log(" The Send Email btn should be available , Expected is actual value should not contain "+ expectedValue + " ,Actual " + actualValue);
			softAssert.assertTrue(true,	" The Send Email btn should be available ,  Expected is actual value should not contain  "	+ expectedValue + " ,Actual " + actualValue);
		} else {
			softAssert.assertTrue(false," The Send Email btn should be available , Expected is actual value should not contain  "+ expectedValue + " ,Actual " + actualValue);
		}

		/*	Discussed with ambarish and commented this , as there is no use case of recovery customer 
	 	Boolean actual = lavanteUtils.isElementDisplayed(enobjsupplierPage.StartOutreachBtn());
		Boolean expected = false;

		Reporter.log(" The Start OutReach btn should not be available , Expected " + expected + " ,Actual " + actual);
		softAssert.assertFalse(actual," The Start OutReach btn should not be available , Expected " + expected + " ,Actual "+actual );
	 	*/
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	@AfterMethod
	public void SetupAftermethod() {

		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
