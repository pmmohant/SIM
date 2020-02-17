package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;


public class CustomerPropertyHelpFAQ extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = "";
	String prop = "";
	String supCustomerID="";
	String supprop = "";
	

	@BeforeTest
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(
			@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		lavanteUtils.driver = driver;

	}

	/**
	 *
	 * @author Thejaswi.Bhat
	 * Test case to check whether Help/FAQ is present in the home page
	 */
	@Test
	public void HelpFaqVisibility() throws Exception {

		Reporter.log("Test started for verifying whether Help/FAQ is present in the logged in buyerhome page or not.." 	+ currenttime());
		SoftAssert softAssert = new SoftAssert();

		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		prop = "SELECT CustomerPropertyID FROM CustomerProperty WHERE PropertyName = 'FAQ_HELP_ENABLED_CUSTOMER'";
		prop = lavanteUtils.fetchDBdata(prop);

		String x = "Select CustomerID from CustomerPropertyValue where CustomerID="+ customerid + " and CustomerPropertyID=" + prop;
		x = lavanteUtils.fetchDBdata(x);

		if(x==null){
			x="INSERT INTO CustomerPropertyValue(CustomerPropertyID,IsActive,CustomerID,PropertyValue,CreatedBy, CreatedOn) VALUES("+prop+", 1, "+customerid+",'FAQ_HELP_ENABLED_CUSTOMER' ,'thejaswi',getUTCdate())";
			lavanteUtils.UpdateDB(x);
		}

		String activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "+ customerid + " and CustomerPropertyID = " + prop;
		lavanteUtils.UpdateDB(activeQuery);
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(enobjhomePage.UserName());
		
		boolean flag = lavanteUtils.isElementDisplayed(enobjhomePage.HelpFAQtext());
		softAssert.assertTrue(flag, "Help/FAQ's is available");

		// Inactive
		String inactiveQuery = "Update CustomerPropertyValue set IsActive = 0 where CustomerID = " + customerid + " and CustomerPropertyID = "+prop;
		lavanteUtils.UpdateDB(inactiveQuery);

		lavanteUtils.refreshPage();
        lavanteUtils.fluentwait(enobjhomePage.UserName());
		
		flag= lavanteUtils.isElementDisplayed(enobjhomePage.HelpFAQtext());
		softAssert.assertFalse(flag, "Help/FAQ is not available");
		
		softAssert.assertAll();
		Reporter.log("Test Ended:"	+ currenttime());
	}
	
	
	/**
	 * 
	 * @author Thejaswi.Bhat
	 * Test case to check whether Help/FAQ is present in the home page
	 */
	@Test
	public void HelpFaqSuppVisibility() throws Exception {

		Reporter.log("Test started for verifying whether Help/FAQ is present in the logged in supplier home page or not.."	+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = (String) listofdatafrm.get(1);
		
		String Email=LdataMap.get("username");
		supCustomerID=lavanteUtils.fetchSupplierCustomer(Email);
		customerid=supCustomerID;

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		prop = "SELECT CustomerPropertyID FROM CustomerProperty WHERE PropertyName = 'FAQ_HELP_ENABLED_SUPPLIER'";
		prop = lavanteUtils.fetchDBdata(prop);
		supprop=prop;
		
		String x = "Select CustomerID from CustomerPropertyValue where CustomerID="+ customerid + " and CustomerPropertyID=" + prop;
		x = lavanteUtils.fetchDBdata(x);

		if(x==null){
			x="INSERT INTO CustomerPropertyValue(CustomerPropertyID,IsActive,CustomerID,PropertyValue,CreatedBy, CreatedOn) VALUES("+prop+", 1, "+customerid+",'FAQ_HELP_ENABLED_SUPPLIER' ,'thejaswi', getUTCdate())";
			lavanteUtils.UpdateDB(x);
		}

		String activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "+ customerid + " and CustomerPropertyID = " + prop;
		lavanteUtils.UpdateDB(activeQuery);
		
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(enobjhomePage.UserName());
		
		boolean flag = lavanteUtils.isElementDisplayed(enobjhomePage.HelpFAQtext());
		softAssert.assertTrue(flag, "Help/FAQ's is available");

		// Inactive
		String inactiveQuery = "Update CustomerPropertyValue set IsActive = 0 where CustomerID = " + customerid + " and CustomerPropertyID = "+prop;
		lavanteUtils.UpdateDB(inactiveQuery);
		lavanteUtils.refreshPage();
        lavanteUtils.fluentwait(enobjhomePage.UserName());
		
		flag= lavanteUtils.isElementDisplayed(enobjhomePage.HelpFAQtext());
		softAssert.assertFalse(flag, "Help/FAQ is not available");
		
		softAssert.assertAll();
		Reporter.log("Test Ended:"	+ currenttime());
	}
	
	
	/**
	 *
	 * @author Thejaswi.Bhat
	 * Test case to check whether List cost is enabled in the home page
	 */
	@Test
	public void ListCostChangeVisibility() throws Exception {

		Reporter.log("Test started for verifying whether List cost is enabled when the logged as supplier page or not.." 	+ currenttime());
		SoftAssert softAssert = new SoftAssert();

		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		supCustomerID = (String) listofdatafrm.get(1);
		
		String Email=LdataMap.get("username");
		supCustomerID=lavanteUtils.fetchSupplierCustomer(Email);
		customerid=supCustomerID;

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		supprop = "SELECT CustomerPropertyID FROM CustomerProperty WHERE PropertyName= 'IS_LIST_COST_CHANGES_ENABLED'";
		supprop = lavanteUtils.fetchDBdata(supprop);

		String x = "Select CustomerID from CustomerPropertyValue where CustomerID="+ customerid+ " and CustomerPropertyID=" + supprop;
		x = lavanteUtils.fetchDBdata(x);

		if(x==null){
			x="INSERT INTO CustomerPropertyValue(CustomerPropertyID,IsActive,CustomerID,PropertyValue,CreatedBy, CreatedOn) "
					+ "VALUES("+supprop+", 1, "+customerid+",'true' ,'thejaswi',getUTCdate())";
			lavanteUtils.UpdateDB(x);
		}

		String activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "+ supCustomerID + " and CustomerPropertyID = " + supprop;
		lavanteUtils.UpdateDB(activeQuery);
		lavanteUtils.refreshPage();

		lavanteUtils.click(enobjhomePage.Agreements());
		boolean flag = lavanteUtils.isElementDisplayed(enobjhomePage.listCostChange());
		softAssert.assertTrue(flag, "List cost change is available");

		// Inactive
		String inactiveQuery = "Update CustomerPropertyValue set IsActive = 0 where CustomerID = " + customerid + " and CustomerPropertyID = "+supprop;
		lavanteUtils.UpdateDB(inactiveQuery);

		lavanteUtils.refreshPage();
       lavanteUtils.fluentwait(enobjhomePage.UserName());
		
		flag= lavanteUtils.isElementDisplayed(enobjhomePage.Agreements());
		softAssert.assertFalse(flag, "Agreements menu item is not available and hence List cost change is not available");
		
		softAssert.assertAll();
		Reporter.log("Test Ended:"	+ currenttime());
	}
	
	
	@AfterMethod
	public void After() throws FileNotFoundException, IOException, SQLException{
		String activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "+ customerid + " and CustomerPropertyID = " + prop;
		lavanteUtils.UpdateDB(activeQuery);
		
		activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "+ supCustomerID + " and CustomerPropertyID = " + supprop;
		lavanteUtils.UpdateDB(activeQuery);
		
		enobjhomePage.logout();
	}
	
	@AfterClass
	public void SetupafterClassmethod() {
		quitBrowser();
	}

}
