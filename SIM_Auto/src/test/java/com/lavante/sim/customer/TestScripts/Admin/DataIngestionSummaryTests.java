package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

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
 * 
 * @author subhas.bv
 *
 */
public class DataIngestionSummaryTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author subhas.bv
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

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "ADMIN");
		dataMap.put("subtab", "dataIngestionReport");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Basic Search
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void basicSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for  Single Search Data Ingestion Search  Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("FileName", "Promo");
		dataMap.put("Search", "");
		objDataIngestionSummaryPage.basicSearch(dataMap);

		String getFileName = objDataIngestionSummaryPage.getColumnText("File Name", 0);
		Reporter.log("File Name is not equal to the searched File Name, Expected : " + dataMap.get("FileName")+ ", Actual : " + getFileName);
		softAssert.assertTrue(getFileName.contains(dataMap.get("FileName")),"File Name is not equal to the searched file Name, Expected : " + dataMap.get("FileName")+ ", Actual : " + getFileName);

		softAssert.assertAll();
		Reporter.log("Test Ended for Single Search Data Ingestion Search Test :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Multiple search
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void multipleSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for Multi Search Data Ingestion Search Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("FileName", "Promo");
		dataMap.put("FileTemplate", "PromoSummary");
		dataMap.put("Search", "");
		objDataIngestionSummaryPage.basicSearch(dataMap);

		String getFileName = objDataIngestionSummaryPage.getColumnText("File Name", 0);
		Reporter.log("File Name is not equal to the searched File Name, Expected : " + dataMap.get("FileName")+ ", Actual : " + getFileName);
		softAssert.assertTrue(getFileName.contains(dataMap.get("FileName")),"File Name is not equal to the searched file Name, Expected : " + dataMap.get("FileName")	+ ", Actual : " + getFileName);

		String getStatus = objDataIngestionSummaryPage.getColumnText("File Template", 0);
		Reporter.log("Template searched, Expected : PromoSummary, Actual : " + getStatus);
		softAssert.assertEquals(getStatus, "PromoSummary","template  searched is mismatch with the result, Expected : " + dataMap.get("FileTemplate") + ", Actual : "	+ getStatus);

		softAssert.assertAll();

		Reporter.log("Test Ended for Multi Search Data Ingestion Search Test :" + currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(null);

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
