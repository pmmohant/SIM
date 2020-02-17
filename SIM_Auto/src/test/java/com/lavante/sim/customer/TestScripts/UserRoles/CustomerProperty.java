package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class CustomerProperty extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	LinkedHashMap<String, String> LdataMap = null;

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
		openQAAPP3();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * @author subhas.bv
	 * 
	 *         Campaign Management - MODEL Customer Property -
	 *         IS_CAMPAIGN_MANAGEMENT_ENABLED
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_CAMPAIGN_MANAGEMENT_ENABLEDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for IS_CAMPAIGN_MANAGEMENT_ENABLED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String propID="select CustomerPropertyID from CustomerProperty where PropertyName='IS_CAMPAIGN_MANAGEMENT_ENABLED'";
		propID=lavanteUtils.fetchDBdata(propID);		
				
		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID in ("+propID+" ) ";
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		boolean flag = false;
		if (!lavanteUtils.isElementDisplayed("//a[@href='campaignSearchSetup.lvp']")) {
			flag = true;
		}

		Reporter.log("Campaigns tab dispalyed , Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Campaigns tab dispalyed , Expected : true , Actual :" + flag);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+propID+" , "
				+ customerID + ", 'true', 1, 'Admin', getUTCdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		flag = false;
		WebElement ele = driver.findElement(By.cssSelector("a[href*='campaignSearchSetup']"));
		if (lavanteUtils.isElementDisplayed(ele)) {
			flag = true;
		}

		Reporter.log("Campaigns tab not dispalyed, Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Campaigns tab not dispalyed, Expected : true , Actual :" + flag);
		softAssert.assertAll();
		Reporter.log("Test Ended for IS_CAMPAIGN_MANAGEMENT_ENABLED Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         IS_CLAIMS_PAYMENTS_ENABLED
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_CLAIMS_PAYMENTS_ENABLEDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for IS_CLAIMS_PAYMENTS_ENABLED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		String custPropID="select CustomerPropertyID from CustomerProperty where PropertyName='IS_CLAIMS_PAYMENTS_ENABLED' ";
		custPropID=lavanteUtils.fetchDBdata(custPropID);

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID in ("+custPropID+" ) ";
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		// Transactions Tab
		LdataMap.put("maintab", "Transactions");
		enobjhomePage.selectTab(LdataMap);
		boolean flag = false;
		if (!lavanteUtils.isElementDisplayed("//a[@href='customerPaymentResult.lvp']")
				&& !lavanteUtils.isElementDisplayed("//a[@href='customerClaimResult.lvp']']")) {
			flag = true;
		}

		Reporter.log("Payments and Claims tab not enabled , Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Payments and Claims tab not enabled, Expected : true , Actual :" + flag);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) "
				+ " VALUES ("+custPropID+", "+ customerID + ", 'true', 1, 'Admin', getUTCdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		flag = false;
		// Transactions Tab
		LdataMap.put("maintab", "Transactions");
		enobjhomePage.selectTab(LdataMap);
		WebElement ele1 = driver.findElement(By.cssSelector("a[href*='customerPaymentResult']"));
		WebElement ele2 = driver.findElement(By.cssSelector("a[href*='customerClaimResult']"));
		if (lavanteUtils.isElementDisplayed(ele1) && lavanteUtils.isElementDisplayed(ele2)) {
			flag = true;
		}

		Reporter.log("Payments and Claims tab enabled dispalyed, Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Payments and Claims tab enabled dispalyed, Expected : true , Actual :" + flag);
		softAssert.assertAll();
		Reporter.log("Test Ended for IS_CLAIMS_PAYMENTS_ENABLED Test:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         CLAIMID_PREFIX and CLAIMID_SUFFIX
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void CLAIMID_PREFIX_SUFFIXTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for CLAIMID_PREFIX_SUFFIX Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='CLAIMID_PREFIX' ) ";
		lavanteUtils.UpdateDB(delete);
		delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='CLAIMID_SUFFIX' ) ";
		lavanteUtils.UpdateDB(delete);

		// Transactions Tab-->Claims
		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(LdataMap);

		lavanteUtils.waitForTime(5000);
		String claimID = enobjsupplierPage.getColumnText("Claim ID", 0);
		boolean flag = false;
		if (Character.isDigit(claimID.charAt(0)) && !claimID.contains("-")) {
			flag = true;
		}
		Reporter.log("Verify ClaimID without any prefix and suffix, Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Verify ClaimID without any prefix and suffix, Expected : true , Actual :" + flag);

		String pre="select CustomerPropertyID from CustomerProperty where PropertyName='CLAIMID_SUFFIX' ";
		pre=lavanteUtils.fetchDBdata(pre);
		
		String suf="select CustomerPropertyID from CustomerProperty where PropertyName='CLAIMID_SUFFIX' ";
		suf=lavanteUtils.fetchDBdata(suf);
		
		String pref="KRO";
		String suff="ID";
		String split="-";
		
		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+pre+", "
				+ customerID + ", '"+pref+"-', 'true', 'Admin', getUTCdate())";
		lavanteUtils.UpdateDB(insert);
		insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+suf+", "
				+ customerID + ", '-"+suff+"', 'true', 'Admin', getUTCdate())";
		lavanteUtils.UpdateDB(insert);

		lavanteUtils.refreshPage();

		flag = false;
		lavanteUtils.waitForTime(5000);
		claimID = enobjsupplierPage.getColumnText("Claim ID", 0);
		String splitClaimID[] = claimID.split(split);
		flag = false;
		if (splitClaimID[0].equals(pref) && splitClaimID[2].equals(suff)) {
			flag = true;
		}
		
		Reporter.log("Verify ClaimID with prefix as "+pref+" and as "+suff+", Expected : true , Actual :" + claimID);
		softAssert.assertTrue(flag, "Verify ClaimID with prefix as "+pref+" and as "+suff+", Expected : true , Actual :" + flag);

		softAssert.assertAll();
		Reporter.log("Test Ended for CLAIMID_PREFIX_SUFFIX Test:" + currenttime());
	}

	/**
	 * @author Piramanayagam.S
	 * 
	 *         IS_COUPON_DEDUCTIONS_ENABLED
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void CouponMenu_Test() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for CouponMenu_Test Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID
				+ " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_COUPON_DEDUCTIONS_ENABLED' ) ";
		lavanteUtils.UpdateDB(delete);

		// Transactions Tab-->Claims
		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "couponDeductionSearchResult");
		enobjhomePage.selectTab(LdataMap);
		
		boolean flag=lavanteUtils.isElementDisplayed("//a[@href='couponDeductionSearchResult']");

		Reporter.log("Verify Menu,Coupon  : false , Actual :" + flag);
		softAssert.assertFalse(flag, "Verify ,Coupon  :Expected : false , Actual :" + flag);

		String pre="select CustomerPropertyID from CustomerProperty where PropertyName='IS_COUPON_DEDUCTIONS_ENABLED' ";
		pre=lavanteUtils.fetchDBdata(pre);

		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+pre+", "
				+ customerID + ", 'true', 'true', 'Automation', getUTCdate())";
		lavanteUtils.UpdateDB(insert);

		lavanteUtils.refreshPage();
		
		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "couponDeductionSearchResult");
		enobjhomePage.selectTab(LdataMap);

		flag=lavanteUtils.isElementDisplayed(objNCHInvoicePage.SearchBtn());

		Reporter.log("Verify Menu,Coupon  : true , Actual :" + flag,true);
		softAssert.assertTrue(flag, "Verify ,Coupon  :Expected : true , Actual :" + flag);	
		
		softAssert.assertAll();
		Reporter.log("Test Ended for CouponMenu_Test:" + currenttime());
	}

	
	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
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
