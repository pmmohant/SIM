package com.lavante.sim.customer.TestScripts.Dashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * SIM-13064
 * 
 * @author subhas.bv
 *
 */
public class ExpiringCertificationsChart001 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;

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
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/***
	 * SIM-13064 Expiring Certifications Dashboard : Hide Diversity charts for NON-US buyers
	 * 
	 * 840/Null all chart will be shown
	 * Some other country it wont be shown.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 * 
	 */
	@Test
	public void verifyChartsNonUSBuyersTest001() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("----Test Started for verifyChartsNonUSBuyersTest001 -----"+currenttime());

		SoftAssert softAssert = new SoftAssert();
		String query = "update Customer set Registration_ISOCountryID=840 where CustomerID=" + customerID + "";
		lavanteUtils.UpdateDB(query);
		
		 LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		 dataMap.put("Dashboard", "Expiring Certifications");
		 enobjdashBoard.switchDashboard(dataMap);

		List<String> expectedChartheaderslist = new ArrayList<String>();
		expectedChartheaderslist.add("Insurance certificate expiry");
		expectedChartheaderslist.add("Women-owned certificate expiry");
		expectedChartheaderslist.add("Other disadvantaged certificate expiry");
		expectedChartheaderslist.add("Spend by diversity");
		expectedChartheaderslist.add("Diverse & disadvantaged certificate expiry");
		expectedChartheaderslist.add("Minority-owned certificate expiry");
		expectedChartheaderslist.add("Small business expiry");
		boolean flag = false;
		
		lavanteUtils.fluentwait(enObjExpiringCertifications.chartsHeaderList().get(0));
		List<String> actualChartheaderslist = new ArrayList<String>();
		int size = enObjExpiringCertifications.chartsHeaderList().size();
		if (size == 7) {

			for (int j = 0; j < size; j++) {
				String chartsHeader = lavanteUtils.getText(enObjExpiringCertifications.chartsHeaderList().get(j));
				actualChartheaderslist.add(chartsHeader);
			}

			if (actualChartheaderslist.containsAll(expectedChartheaderslist)) {
				flag = true;
			}

			Reporter.log(" Verifications of charts for the buyer country is US " + actualChartheaderslist);
			softAssert.assertTrue(flag,
					" Verification failed of charts for the buyer country is US " + actualChartheaderslist);

		} else {
			softAssert.assertTrue(false, " Verification failed of charts for the buyer country is US ");
		}

		query = "update Customer set Registration_ISOCountryID=null where CustomerID=" + customerID + "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();
		actualChartheaderslist.clear();
		lavanteUtils.fluentwait(enObjExpiringCertifications.chartsHeaderList().get(0));
		int size1 = enObjExpiringCertifications.chartsHeaderList().size();
		if (size1 == 7) {

			for (int j = 0; j < size1; j++) {
				String chartsHeader = lavanteUtils.getText(enObjExpiringCertifications.chartsHeaderList().get(j));
				actualChartheaderslist.add(chartsHeader);
			}

			flag = false;
			if (actualChartheaderslist.containsAll(expectedChartheaderslist)) {
				flag = true;
			}

			Reporter.log(" Verifications of charts for the buyers country is null " + actualChartheaderslist);
			softAssert.assertTrue(flag,
					" Verification failed of charts for the buyers country is null " + actualChartheaderslist);

		} else {
			softAssert.assertTrue(false, "  Verification failed of charts for the buyers country is null  ");
		}

		query = "update Customer set Registration_ISOCountryID=540 where CustomerID=" + customerID + "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(enObjExpiringCertifications.chartsHeaderList().get(0));
		size = enObjExpiringCertifications.chartsHeaderList().size();
		flag = false;
		if (size == 1) {
			String chartsHeader = null;
			for (int j = 0; j < size; j++) {

				chartsHeader = lavanteUtils.getText(enObjExpiringCertifications.chartsHeaderList().get(j));
				if ("Insurance certificate expiry".equals(chartsHeader)) {
					flag = true;
				}
			}

			Reporter.log("Verifications of charts for the US buyers " + chartsHeader);
			softAssert.assertTrue(flag, " Verifications of charts for the US buyers are invalid " + chartsHeader);
		} else {
			softAssert.assertTrue(false, " Verifications of charts for the US buyers are invalid ");
		}
		
		softAssert.assertAll();
		Reporter.log("------Test ended for verify ChartsNonUSBuyersTest001 -----------"+currenttime());
	}

	@AfterClass
	public void close() throws FileNotFoundException, IOException, SQLException {
		String query = "update Customer set Registration_ISOCountryID=840 where CustomerID=" + customerID + "";
		lavanteUtils.UpdateDB(query);
		enobjhomePage.logout();
		quitBrowser();
	}

}
