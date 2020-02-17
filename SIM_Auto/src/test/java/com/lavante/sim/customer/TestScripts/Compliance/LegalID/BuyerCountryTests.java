package com.lavante.sim.customer.TestScripts.Compliance.LegalID;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
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
 * SIM-13062
 * 
 * @author subhas.bv
 *
 */
public class BuyerCountryTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	int regISOCountryID = 840;

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

		List listofdatafrm = lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "RISK");
		LdataMap.put("subtab", "customerSupplierLegalID");
		enobjhomePage.selectTab(LdataMap);

	}

	/***
	 * SIM-13062 Default selection of country in Legal ID based on buyer country
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 * 
	 */
	@Test
	public void verifyLocationForBuyersCountryTest001() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("------------Test Started for verifyLocationForBuyersCountryTest001 --"+ currenttime());
		SoftAssert softAssert = new SoftAssert();

		HashMap<String, Integer> buyerCountry = new HashMap<>();
		buyerCountry.put("US", regISOCountryID);
		buyerCountry.put("EU", 276);
		buyerCountry.put("Canada", 124);
		buyerCountry.put("Swiss", 756);
		buyerCountry.put("Others", 8);

		boolean flag = false;
		regISOCountryID = buyerCountry.get("US");
		String query = "update Customer set Registration_ISOCountryID=" + regISOCountryID + " where CustomerID="+ customerID + "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjLegalID.supplrlocatindpdn());
		String supplierLocation = lavanteUtils.getText(enobjLegalID.supplrlocatindpdn());

		if ("US".equals(supplierLocation)) {
			flag = true;
		}
		Reporter.log("Verifications of Supplier location for the US buyers, with Registration_ISOCountryID "+ buyerCountry.get("US") + " the supplier location dropdown value is " + supplierLocation);

		softAssert.assertTrue(flag, " Verifications failed supplier loaction " + supplierLocation+ " is not same as the configured Registration_ISOCountryID " + regISOCountryID);

		flag = false;
		regISOCountryID = buyerCountry.get("EU");
		query = "update Customer set Registration_ISOCountryID=" + regISOCountryID + " where CustomerID=" + customerID	+ "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjLegalID.supplrlocatindpdn());
		supplierLocation = lavanteUtils.getText(enobjLegalID.supplrlocatindpdn());

		if ("EU".equals(supplierLocation)) {
			flag = true;
		}
		Reporter.log("Verifications of Supplier location for the EU buyers, with Registration_ISOCountryID "+ buyerCountry.get("EU") + " the supplier location dropdown value is " + supplierLocation);

		softAssert.assertTrue(flag, " Verifications failed supplier loaction " + supplierLocation+ " is not same as the configured Registration_ISOCountryID " + regISOCountryID);

		flag = false;
		regISOCountryID = buyerCountry.get("Canada");
		query = "update Customer set Registration_ISOCountryID=" + regISOCountryID + " where CustomerID=" + customerID
				+ "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjLegalID.supplrlocatindpdn());
		supplierLocation = lavanteUtils.getText(enobjLegalID.supplrlocatindpdn());

		if ("Canada".equals(supplierLocation)) {
			flag = true;
		}
		Reporter.log("Verifications of Supplier location for the Canada buyers, with Registration_ISOCountryID "	+ buyerCountry.get("Canada") + " the supplier location dropdown value is " + supplierLocation);

		softAssert.assertTrue(flag, " Verifications failed supplier loaction " + supplierLocation+ " is not same as the configured Registration_ISOCountryID " + regISOCountryID);

		flag = false;
		regISOCountryID = buyerCountry.get("Swiss");
		query = "update Customer set Registration_ISOCountryID=" + regISOCountryID + " where CustomerID=" + customerID	+ "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjLegalID.supplrlocatindpdn());
		supplierLocation = lavanteUtils.getText(enobjLegalID.supplrlocatindpdn());

		if ("Swiss".equals(supplierLocation)) {
			flag = true;
		}
		Reporter.log("Verifications of Supplier location for the Swiss buyers, with Registration_ISOCountryID "	+ buyerCountry.get("Swiss") + " the supplier location dropdown value is " + supplierLocation);

		softAssert.assertTrue(flag, " Verifications failed supplier loaction " + supplierLocation+ " is not same as the configured Registration_ISOCountryID " + regISOCountryID);

		flag = false;
		regISOCountryID = buyerCountry.get("Others");
		query = "update Customer set Registration_ISOCountryID=" + regISOCountryID + " where CustomerID=" + customerID+ "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjLegalID.supplrlocatindpdn());
		supplierLocation = lavanteUtils.getText(enobjLegalID.supplrlocatindpdn());

		if ("Others".equals(supplierLocation)) {
			flag = true;
		}
		Reporter.log("Verifications of Supplier location for the Others buyers, with Registration_ISOCountryID "+ buyerCountry.get("US") + " the supplier location dropdown value is " + supplierLocation);

		softAssert.assertTrue(flag, " Verifications failed supplier loaction " + supplierLocation+ " is not same as the configured Registration_ISOCountryID " + regISOCountryID);

		softAssert.assertAll();

		Reporter.log("-----Test ended for verifyLocationForBuyersCountryTest001 ----------"+ currenttime());
	}

	@AfterClass
	public void close() throws FileNotFoundException, IOException, SQLException {
		String query = "update Customer set Registration_ISOCountryID=840 where CustomerID="
				+ customerID + "";
		lavanteUtils.UpdateDB(query);
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.logoutbtn();
		quitBrowser();
	}
}
