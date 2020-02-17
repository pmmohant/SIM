package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 01-02-2017 Created for EditPaymentTerms
 * 
 * @author Subhash.BV
 *
 */

public class PaymentCenter03  extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String sname = null;
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

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
		List listofdatafrm = lavanteUtils.login("PaymentCenter", browser);
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();

		String getPropertyValue = "select PropertyValue from CustomerPropertyValue where CustomerPropertyID=79 and CustomerID="+customerID;
		getPropertyValue = lavanteUtils.fetchDBdata(getPropertyValue);
		if ("true".equalsIgnoreCase(getPropertyValue)) {
			String updateQuery = "update CustomerPropertyValue set PropertyValue='false' where CustomerPropertyID=79 and CustomerID="+customerID;
			lavanteUtils.UpdateDB(updateQuery);
		}
	}

	@BeforeMethod
	public void setup() throws Exception {
		
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
	
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Approved");
		sname = dataMap.get("supname");
	//	dataMap.put("supplierName", sname);
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierRelationshipTreasuryInfo");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);
	}

	/**
	 * SIM-9516 Associate payment types and terms based on Payment Facility Code
	 * (Payment Center)
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void ccPaymentTermTest() throws Exception {
		System.out.println(	"------------Test Started for verify credit card PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify credit card PaymentTerm Test in Edit Profile at :"+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("PaymentType", "CreditCard");
		dataMap.put("CCPaymentTerms", "any");
		dataMap.put("CCVisa", "");
		LinkedHashMap<String, String> dataMap1 = eneditPayment.fillPayMentType(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = dataMap1.get("CCPaymentTerms");
		String actualPaymentTerm = lavanteUtils.getText(enviewSupplier.CCPaymentAuth());
		actualPaymentTerm = actualPaymentTerm.split(":")[1].trim();
		Reporter.log(
				"The Credit Card payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out.println(
				"The Credit Card payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,
				"The Credit Card payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log(
				"Test end for verify credit card PaymentTerm Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-9516 Associate payment types and terms based on Payment Facility Code
	 * (Payment Center)
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 * 
	 */
	@Test
	public void cPaymentTermTest() throws Exception {
		System.out.println(	"------------Test Started for verify check PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify check PaymentTerm Test in Edit Profile at :" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("PaymentType", "Check");
		dataMap.put("CPaymentTerms", "any");
		LinkedHashMap<String, String> dataMap1 = eneditPayment.fillPayMentType(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = dataMap1.get("CPaymentTerms");
		String actualPaymentTerm = lavanteUtils.getText(enviewSupplier.CPaymentAuth());
		actualPaymentTerm = actualPaymentTerm.split(":")[1].trim();
		Reporter.log("The check payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out
				.println("The check payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,
				"The check payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("Test end for verify check PaymentTerm Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/***
	 * SIM-9516
	 * 
	 * Associate payment types and terms based on Payment Facility Code*(
	 * Payment Center)**
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void eftPaymentTermTest() throws Exception {
		System.out.println("------------Test Started for verify eft PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify eft PaymentTerm Test in Edit Profile at :" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("PaymentType", "EFT");
		dataMap.put("EFTPaymentTerms", "any");
		LinkedHashMap<String, String> dataMap1 = eneditPayment.fillPayMentType(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = dataMap1.get("EFTPaymentTerms");
		String actualPaymentTerm = lavanteUtils.getText(enviewSupplier.EFTPaymentAuth());
		actualPaymentTerm = actualPaymentTerm.split(":")[1].trim();
		Reporter.log("The eft payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out.println("The eft payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,
				"The eft payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("Test end for verify eft PaymentTerm Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/***
	 * SIM-9516
	 * 
	 * Associate payment types and terms based on Payment Facility Code*(
	 * Payment Center)**
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void ccNegotiatedPaymentTermTest() throws Exception {
		System.out.println(	"------------Test Started for verify credit card Negotiated PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify credit card Negotiated PaymentTerm Test in Edit Profile at :"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("PaymentType", "CreditCard");
		dataMap.put("CCNegotiatedPaymentTerms", "");
		dataMap.put("CCMasterCard", "");
		dataMap.put("CCDiscount", "7");
		eneditPayment.fillPayMentType(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = dataMap.get("CCDiscount") + "%";
		String actualPaymentTerm = lavanteUtils.getText(enviewSupplier.CCPaymentAuth());
		actualPaymentTerm = actualPaymentTerm.split(":")[1].trim();
		Reporter.log("The Credit Card Negotiated payment term is , Exp:" + expectedPaymentTerm + ", Actuals:"	+ actualPaymentTerm);
		System.out.println("The Credit Card Negotiated payment term is , Exp:" + expectedPaymentTerm + ", Actuals:"		+ actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,	"The Credit Card payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("Test end for verify credit card Negotiated PaymentTerm Test in Edit Profile- at:"	+ currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/***
	 * SIM-9516
	 * 
	 * Associate payment types and terms based on Payment Facility Code*(
	 * Payment Center)**
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void cNegotiatedPaymentTermTest() throws Exception {
		System.out.println("------------Test Started for verify check Negotiated PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify check Negotiated PaymentTerm Test in Edit Profile at :"+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("PaymentType", "Check");
		dataMap.put("CNegotiatedPaymentTerms", "");
		dataMap.put("CDiscount", "17");
		eneditPayment.fillPayMentType(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(null);
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = dataMap.get("CDiscount") + "%";
		String actualPaymentTerm = lavanteUtils.getText(enviewSupplier.CPaymentAuth());
		actualPaymentTerm = actualPaymentTerm.split(":")[1].trim();
		Reporter.log("The check Negotiated payment term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out.println(	"The check Negotiated payment term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,	"The check payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("Test end for verify check Negotiated PaymentTerm Test in Edit Profile- at:"+ currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/***
	 * SIM-9516
	 * 
	 * Associate payment types and terms based on Payment Facility Code*(
	 * Payment Center)**
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void eftNegotiatedPaymentTermTest() throws Exception {
		System.out.println(	"------------Test Started for verify eft Negotiated PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify eft Negotiated PaymentTerm Test in Edit Profile at :"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("PaymentType", "EFT");
		dataMap.put("EFTNegotiatedPaymentTerms", "");
		dataMap.put("EFTDiscount", "18");
		eneditPayment.fillPayMentType(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = dataMap.get("EFTDiscount") + "%";
		String actualPaymentTerm = lavanteUtils.getText(enviewSupplier.EFTPaymentAuth());
		actualPaymentTerm = actualPaymentTerm.split(":")[1].trim();
		Reporter.log(
				"The eft Negotiated payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out.println(
				"The eft Negotiated payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,
				"The eft payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("Test end for verify eft Negotiated PaymentTerm Test in Edit Profile- at:"
				+ currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-9516 Associate payment types and terms based on Payment Facility Code
	 * (Payment Center)
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */

	@Test
	public void multiplePaymentsTermTest() throws Exception {
		System.out.println("------------Test Started for verify multiplePaymentsTermTest Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify multiplePaymentsTermTest Test in Edit Profile at :" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String getPropertyValue = "select PropertyValue from CustomerPropertyValue where CustomerPropertyID=79 and CustomerID="+customerID;
		getPropertyValue = lavanteUtils.fetchDBdata(getPropertyValue);
		if ("false".equalsIgnoreCase(getPropertyValue)) {
			String updateQuery = "update CustomerPropertyValue set PropertyValue='true' where CustomerPropertyID=79 and CustomerID="+customerID;
			lavanteUtils.UpdateDB(updateQuery);
		}
		lavanteUtils.refreshPage();

		lavanteUtils.selectChkBox(eneditPayment.PaymentCreditCardChkBox(), "yes");
		lavanteUtils.selectChkBox(eneditPayment.PaymentCheckChkBox(), "yes");
		lavanteUtils.selectChkBox(eneditPayment.PaymentEFTChkBox(), "yes");

		dataMap.put("CCPaymentTerms", "any");
		dataMap.put("CCVisa", "");
		dataMap.put("CPaymentTerms", "any");
		dataMap.put("EFTNegotiatedPaymentTerms", "");
		dataMap.put("EFTDiscount", "9");

		LinkedHashMap<String, String> dataMap1 = eneditPayment.fillPaymentTerms(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(5000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipTreasuryDetails");
		enviewSupplier.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		String expectedCCPaymentTerm = dataMap1.get("CCPaymentTerms");
		String expectedCPaymentTerm = dataMap1.get("CPaymentTerms");
		String expectedEFTNegotiatedPaymentTerm = dataMap.get("EFTDiscount")+"%";

		String actualCCPaymentTerm = lavanteUtils.getText(enviewSupplier.CCPaymentAuth());
		actualCCPaymentTerm = actualCCPaymentTerm.split(":")[1].trim();
		String actualCPaymentTerm = lavanteUtils.getText(enviewSupplier.CPaymentAuth());
		actualCPaymentTerm = actualCPaymentTerm.split(":")[1].trim();
		String actualEFTNegotiatedPaymentTerm = lavanteUtils.getText(enviewSupplier.EFTPaymentAuth());
		actualEFTNegotiatedPaymentTerm = actualEFTNegotiatedPaymentTerm.split(":")[1].trim();

		SoftAssert softAssert = new SoftAssert();

		Reporter.log("The PaymentTerms is , Exp:" + expectedCCPaymentTerm + ", Actuals:" + actualCCPaymentTerm);
		System.out.println("The PaymentTerms is , Exp:" + expectedCCPaymentTerm + ", Actuals:" + actualCCPaymentTerm);

		softAssert.assertEquals(actualCCPaymentTerm, expectedCCPaymentTerm,
				"The PaymentTerms is , Exp:" + expectedCCPaymentTerm + ", Actuals:" + actualCCPaymentTerm);

		Reporter.log("The PaymentTerms is , Exp:" + expectedCPaymentTerm + ", Actuals:" + actualCPaymentTerm);
		System.out.println("The PaymentTerms is , Exp:" + expectedCPaymentTerm + ", Actuals:" + actualCPaymentTerm);

		softAssert.assertEquals(actualCPaymentTerm, expectedCPaymentTerm,	"The PaymentTerms is , Exp:" + expectedCPaymentTerm + ", Actuals:" + actualCPaymentTerm);

		Reporter.log("The Negotiated PaymentTerm is , Exp:" + expectedEFTNegotiatedPaymentTerm + ", Actuals:"			+ actualEFTNegotiatedPaymentTerm);
		System.out.println("The Negotiated PaymentTerm is , Exp:" + expectedEFTNegotiatedPaymentTerm + ", Actuals:"		+ actualEFTNegotiatedPaymentTerm);

		softAssert.assertEquals(actualEFTNegotiatedPaymentTerm, expectedEFTNegotiatedPaymentTerm,
				"The Negotiated PaymentTerm is , Exp:" + expectedEFTNegotiatedPaymentTerm + ", Actuals:"
						+ actualEFTNegotiatedPaymentTerm);

		getPropertyValue = "select PropertyValue from CustomerPropertyValue where CustomerPropertyID=79 and CustomerID="+customerID;
		getPropertyValue = lavanteUtils.fetchDBdata(getPropertyValue);
		if ("true".equalsIgnoreCase(getPropertyValue)) {
			String updateQuery = "update CustomerPropertyValue set PropertyValue='false' where CustomerPropertyID=79 and CustomerID="+customerID;
			lavanteUtils.UpdateDB(updateQuery);
		}
		lavanteUtils.refreshPage();
		Reporter.log("Test end for verify multiplePaymentsTermTest Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	@AfterMethod
	public void aftermethod() {
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();

	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
