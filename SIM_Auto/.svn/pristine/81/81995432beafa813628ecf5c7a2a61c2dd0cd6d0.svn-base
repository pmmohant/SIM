package com.lavante.sim.customer.TestScripts.SanityTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

public class SIMSanityTestAdmin03 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

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

		List<?> listofdatafrm = lavanteUtils.login("UserRoleId2", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * lavanteAdminTest Test Verification
     * 	@author Piramanayagam.S
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void SystemLogin() throws FileNotFoundException, IOException, SQLException {

		Reporter.log("Test Started for SystemLogin:" + currenttime());

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();

		enprop.verifyTablePresent();
		
		dataMap.put("maintab","APP");
		dataMap.put("subtab","Background");
		enobjhomePage.selectTab(dataMap);	
		
		lavanteUtils.waitForTime(4000);
		boolean flag=enBackgroundTask.BackGround();
		
		dataMap.put("subtab","cache");
		enobjhomePage.selectTab(dataMap);	
		
		enCache.CacheSanity();
		
		dataMap.clear();
		dataMap.put("maintab","CUSTOMER SETUP");
		enobjhomePage.selectTab(dataMap);	
		
		enCustomerSetup.customerSanity();
		
		Reporter.log("Test Ended for SystemLogin at:" + currenttime());
	}

	@AfterClass
	public void close() {
		enobjhomePage.logout();
		quitBrowser();
	}
}