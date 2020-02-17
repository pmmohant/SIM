package com.lavante.sim.customer.TestScripts.Dashboard;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 25-11-2016 Created for verify SupportContactDetils 
 * 
 * @author Subhash.BV
 *
 */

public class SupportContactDetails extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = null;

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
		List listofdatafrm = lavanteUtils.login("Discovery", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	/**SIM-9090
	 * Verify Customer Tooltip
	 * 
	 * @throws IOException
	 * @author Subhas.BV
	 */
	@Test
	public void verifySupportContactDetilsTest() throws Exception {
		Reporter.log("Test Started for verifySupportContactDetilsTest:" + LavanteUtils.currenttime());
		Boolean flag = lavanteUtils.isElementDisplayed(enobjhomePage.VerifyClientLogoToolTip);
		Reporter.log(" Customer logo tool tip " + flag);
		Assert.assertTrue(flag, " Customer logo tool tip not present/displayed ");
		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
	}


	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
