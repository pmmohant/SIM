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

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 28-09-2016 Created for Verifying SIM User Roles
 * 
 * @author Subhash.BV
 *
 */

public class RecoverySupplierTests extends PageInitiator {

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
		List listofdatafrm = lavanteUtils.login("UserRoleId3", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * 
	 * UserRoles: Verify that for Recovery Supplier on registration page the
	 * Legal ID block and electronic signature block should not be shown.Same
	 * expectation should also hold on Recovery Supplier profile.
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */

	//@Test(dataProvider = "RecoveryManagerInviteSupplier", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void verifyRecoverySupplierLegalIDBlockTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for verifyRecoverySupplierLegalIDBlockTest : " + LavanteUtils.currenttime());

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		dataMap.remove("suppgrp");
		dataMap.remove("inviteorg");
		dataMap.put("invite", "");
		
		String[] dataContent = enobjInvitenewSupplier.inviteNwSupp(dataMap);
		Reporter.log("Invited New Supplier:"+dataContent[0]);

		String currentURL = driver.getCurrentUrl();
		 lavanteUtils.navigatetoAccSetup(dataContent);
		 Reporter.log("Navigate to Acc Setup:");
		dataMap.put("setpass", "lavante@1234");
		dataMap.put("confirmpass", "lavante@1234");
		dataMap.put("chquestion", "What was your childhood nickname?");
		dataMap.put("chanswer", "name");
		dataMap.put("checkconfirm", "");
		dataMap.put("nextbttn", "");
		objSimAccSetupPages.accSetup(dataMap);

		lavanteUtils.switchtoFrame(null);
		String actual = lavanteUtils.getValue(objSimAccountRegistrationPage.LegalDocExist(), "type");
		String expected = "hidden";
		Reporter.log("Verify Legal ID block and electronic signature block should not be shown. Expected, " + expected
				+ " Actual , " + actual);
		Assert.assertEquals(actual, expected,
				"Verify Legal ID block and electronic signature block should not be shown. Expected, " + expected
						+ " Actual , " + actual);

		driver.navigate().to(currentURL);
		lavanteUtils.fluentwait(enobjhomePage.logoutbtn());
		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
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
