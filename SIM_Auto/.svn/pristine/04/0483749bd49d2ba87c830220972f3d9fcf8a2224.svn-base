package com.lavante.sim.customer.TestScripts.Invite;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class UATAddAddressForPreScreenedTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhash.BV
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(
			@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		// List listofdatafrm = lavanteUtils.login("Omnicare", browser);
		List listofdatafrm = lavanteUtils.login("PreScreen", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	/**
	 * It is a bug, Need to fix it
	 * 
	 * Invite a new supplier and fill the prescreend address fields 
	 * and verify the supplier details and address entered in view supplier
	 * 
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	//@Test(bug das dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void inviteNewSupplierAddAddressForPrescreened(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for inviteNewSupplierAddAddressForPrescreened : "
				+ LavanteUtils.currenttime());

		SoftAssert softAssert = new SoftAssert();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		Reporter.log("Invite New Supplier:");
		dataMap.put("PreScreen", "");
		dataMap.put("SaveExit", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		String expStatus = "Prescreened";
		String actualStatus = enobjsupplierPage.getColumnText("Status", 0);
		softAssert.assertEquals(actualStatus, expStatus,"Supplier status is not matching");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());

	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
