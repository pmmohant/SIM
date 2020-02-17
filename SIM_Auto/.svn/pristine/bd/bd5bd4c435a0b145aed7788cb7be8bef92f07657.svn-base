package com.lavante.sim.customer.TestScripts.Supplier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;

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

public class UATSupplierAccountSetupTests extends PageInitiator {

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
		List listofdatafrm = lavanteUtils.login("Profile", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * 
	 * Supplier Account Setup : Verify all required field validation messages
	 * appears properly.
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */

	//@Test(dataProvider = "InviteSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void validateSupplierAccoutRequiredFieldMsgsTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for validateSupplierAccoutRequiredFieldMsgsTest : " + LavanteUtils.currenttime());

		dataMap.put("invite", "");
		dataMap.put("reason", "any");
		String[] dataContent = enobjInvitenewSupplier.inviteNwSupp(dataMap);
		System.out.println(dataContent[0] + dataContent[1]);

		String currentURL = driver.getCurrentUrl();
		lavanteUtils.navigatetoAccSetup(dataContent);

		dataMap.put("nextbttn", "");
		objSimAccSetupPages.accSetup(dataMap);

		TreeSet<String> actualListErrors = new TreeSet<String>();
		int errorListSize = objSimAccSetupPages.ErrorMsgList().size();
		for (int i = 0; i < errorListSize; i++) {
			String errormsg = lavanteUtils.getText(objSimAccSetupPages.ErrorMsgList().get(i));
			actualListErrors.add(errormsg.trim());
		}

		TreeSet<String> expectedListErrors = new TreeSet<String>();
		expectedListErrors.add("'Set Password' cannot be left blank.");
		expectedListErrors.add("'Confirm Password' cannot be left blank.");
		expectedListErrors.add("'Challenge Question' cannot be left blank.");
		expectedListErrors.add("'Challenge Answer' cannot be left blank.");
		Boolean flag = false;
		if (actualListErrors.containsAll(expectedListErrors)) {
			flag = true;
		}

		Reporter.log("Verify all required field validation messages, Actual error msgs " + actualListErrors
				+ " , Expected error msgs " + expectedListErrors);
		Assert.assertTrue(flag, "Verify all required field validation messages, Actual error msgs " + actualListErrors
				+ " , Expected error msgs " + expectedListErrors);

		driver.navigate().to(currentURL);
		lavanteUtils.fluentwait(enobjhomePage.logoutbtn());
		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
	}

	/**
	 * 
	 * Supplier Account Setup : Verify if the Username field appears as
	 * non-editable appears properly.
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */

	//@Test(dataProvider = "InviteSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void verifyUserNameFieldNonEditableTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for verifyUserNameFieldNonEditableTest : " + LavanteUtils.currenttime());

		dataMap.put("invite", "");
		dataMap.put("reason", "any");
		String[] dataContent = enobjInvitenewSupplier.inviteNwSupp(dataMap);
		System.out.println(dataContent[0] + dataContent[1]);

		String currentURL = driver.getCurrentUrl();
		lavanteUtils.navigatetoAccSetup(dataContent);

		String actualValue = lavanteUtils.getValue(objSimAccSetupPages.UserNameTxtBox(), "readonly");
		String expectedValue = "true";

		Reporter.log(" Verify if the Username field appears as non-editable appears properly. Actual " + actualValue
				+ " , Expected " + expectedValue);
		Assert.assertEquals(actualValue, expectedValue,
				" Verify if the Username field appears as non-editable appears properly. Actual " + actualValue
						+ " , Expected " + expectedValue);

		driver.navigate().to(currentURL);
		lavanteUtils.fluentwait(enobjhomePage.logoutbtn());
		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
	}

	

	@AfterMethod
	public void SetupAftermethod() {
		enobjInvitenewSupplier.cancel();
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
