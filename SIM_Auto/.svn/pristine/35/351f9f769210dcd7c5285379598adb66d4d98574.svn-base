package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 25-11-2016 Created for EditPaymentTerms
 * 
 * @author Subhash.BV
 *
 */

public class PaymentDefaultTerms05 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String supname = null;

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
		List listofdatafrm = lavanteUtils.login("DefaultPayments", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		supname = LdataMap.get("supname");
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());

		LdataMap.put("Tab", "PaymentInfo,Enterprise");
		LdataMap.put("PaymentType", "Is Empty");
		LdataMap.put("ProfStatus", "Approved");
		LdataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(LdataMap);

		supname = enobjsupplierPage.VerifyManagedBy("Profile Managed By");
		LdataMap.put("supplierName", supname);
		LdataMap.put("profile", "");
		LdataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(LdataMap);

		LdataMap.put("tab", "supplierRelationshipTreasuryInfo");
		eneditProfile.selectTab(LdataMap);
	}

	/**
	 * SIM-9205 Verify Default Payment Term
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void verifyDefaultPaymentTermTest() throws Exception {
		System.out.println("------------Test Started for verifyDefaultPaymentTermTest in Edit Profile-------------------");
		Reporter.log("Test Started for verifyDefaultPaymentTermTest in Edit Profile at :" + currenttime());

		String getPaymentTermId = "Select  MAX(PaymentTermID) from PaymentTerms where TargetPage_KVID=1131 and CustomerID="
				+ customerID + " and PaymentTypeID=11";
		getPaymentTermId = lavanteUtils.fetchDBdata(getPaymentTermId);

		String updatePayement = "Update RelationshipPaymentTerm SET PaymentTermId = " + getPaymentTermId
				+ " WHERE  PaymentTypeId=11 and RelationshipId in (Select RelationshipID from Relationship where CustomerID="
				+ customerID + ")";
		lavanteUtils.UpdateDB(updatePayement);

		String deletePaymentTerms = "Delete from PaymentTerms where TargetPage_KVID=1131 and CustomerID=" + customerID
				+ " and PaymentTypeID=11 and PaymentTermID not in (" + getPaymentTermId + ")";
		lavanteUtils.UpdateDB(deletePaymentTerms);

		lavanteUtils.refreshPage();
		lavanteUtils.waitForTime(3000);
		String expectedPaymentTerm = "select UTFString from UserTranslation where i18nKey in (select PaymentName_i18nKey from PaymentTerms where TargetPage_KVID=1131 and CustomerID="
				+ customerID + " and PaymentTypeID=11 and PaymentTermID=" + getPaymentTermId + ") and LanguageID=50";
		expectedPaymentTerm = lavanteUtils.fetchDBdata(expectedPaymentTerm);

		lavanteUtils.click(eneditPayment.paymentypedpdn());
		lavanteUtils.selectvalueFrmDpdn("Credit Card");
		lavanteUtils.selectChkBox(eneditPayment.CheckChkBox(), "yes");
		lavanteUtils.waitForTime(2000);
		String actualPaymentTerm = lavanteUtils.getText(eneditPayment.GetCheckPaymentTermDefaultValueDropdwn());

		Reporter.log("The default payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out.println(	"The default payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,	"The default payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		Reporter.log("Test Ended for verifyDefaultPaymentTermTest in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-9205 Verify Payment Terms
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void verifyPaymentTermsTest() throws Exception {
		System.out.println("------------Test Started for verifyPaymentTermsTest in Edit Profile-------------------");
		Reporter.log("Test Started for verifyPaymentTermsTest in Edit Profile at :" + currenttime());

		String getPaymentTermCount = "Select  count(*) from PaymentTerms where TargetPage_KVID=1131 and CustomerID="
				+ customerID + " and PaymentTypeID=11";
		getPaymentTermCount = lavanteUtils.fetchDBdata(getPaymentTermCount);

		if (Integer.parseInt(getPaymentTermCount) <= 1) {
			String getPaymentTermId = "Select  MAX(PaymentTermID) from PaymentTerms where TargetPage_KVID=1131 and CustomerID="
					+ customerID + " and PaymentTypeID=11";
			getPaymentTermId = lavanteUtils.fetchDBdata(getPaymentTermId);
			String creditName = "AutoSP" + LavanteUtils.randomnum() + customerID;

			String crediti18 = "Insert into I18NKey  (i18nKey) values ('" + creditName + "')";
			lavanteUtils.UpdateDB(crediti18);
			String uteft = "Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific  ,UTFString) VALUES ( '"
					+ creditName + "'   ,50 ,0 ,'" + creditName + "')";
			lavanteUtils.UpdateDB(uteft);
			String insertPayemntType = "Insert into PaymentTerms "
					+ "(CustomerID, PaymentTypeID, PaymentName, Createdby, PaymentName_i18nKey, TargetPage_KVID,DisplayOrder) "
					+ "VALUES (" + customerID + ", 11, 'AutoSub', 'Admin', '" + creditName + "',1131 ,11)";
			lavanteUtils.UpdateDB(insertPayemntType);
		}

		lavanteUtils.refreshPage();
		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(eneditPayment.paymentypedpdn());
		lavanteUtils.selectvalueFrmDpdn("Check");
		lavanteUtils.waitForTime(2000);
		String expectedPaymentTerm = "Select Payment Terms";
		String actualPaymentTerm = lavanteUtils.getText(eneditPayment.GetCheckPaymentTermDefaultValueDropdwn());

		Reporter.log("The default payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		System.out.println("The default payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);
		Assert.assertEquals(actualPaymentTerm, expectedPaymentTerm,	"The default payement term is , Exp:" + expectedPaymentTerm + ", Actuals:" + actualPaymentTerm);

		Reporter.log("Test Ended for verifyPaymentTermsTest in Edit Profile at:" + currenttime());
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
