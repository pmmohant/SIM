package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class ConfigViewInSupplierSearch extends PageInitiator {

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
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Sanity", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		
		
	}
	
	@BeforeMethod
	public void BeforeMethods() throws FileNotFoundException, IOException, SQLException{

		String query="update CustomerPropertyValue SET PropertyValue='True'  where CustomerID="+customerID+" and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_ERPLOCATIONID_ENABLED')";
		lavanteUtils.UpdateDB(query);
		
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
		lavanteUtils.waitForTime(3000);
	}

	/**
	 * 
	 * SIM-9161 Add New View in Supplier Search Results
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test
	public void supplierSearchViewTest001() throws Exception {
		Reporter.log("Test Started for supplierSearchViewTest001 : " + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String locationID="S1921";
		dataMap.put("SupplierID", "1");
		dataMap.put("LocationID", "S1921"); 
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		String expectedSearchView = "Organization";
		dataMap.put("SearchOption", expectedSearchView);
		
		String actuaslSearchView = enobjsupplierPage.searchView(dataMap);
		Reporter.log(" Verify Profile Status is default View in search reault page, Expected : " + expectedSearchView + " , Actual : " + actuaslSearchView);
		Assert.assertEquals(actuaslSearchView, expectedSearchView,"Verify Profile Status is default View in search reault page, Expected : " + expectedSearchView	+ " , Actual : " + actuaslSearchView);

		String supplierERPID = enobjsupplierPage.getColumnText("ERP ID",0);
		Boolean flag = false;
		if (supplierERPID.contains("1")) {
			flag = true;
		}
		Reporter.log(" Verifying Basic Search with Supplier ERPID working as expected, Actual searched Supplier ERPID : "+ supplierERPID);
		Assert.assertTrue(flag," Verifying Basic Search with Supplier ERPID working as expected, Actual searched Supplier ERPID : "+ supplierERPID);
		
		supplierERPID = enobjsupplierPage.getColumnText("Location ID",0);
		flag = false;
		if (supplierERPID.contains("1")) {
			flag = true;
		}
		Reporter.log(" Verifying Basic Search with Location ID working as expected, Actual searched  : "+ supplierERPID);
		Assert.assertTrue(flag," Verifying Basic Search with Location ID working as expected, Actual searched  : "+ supplierERPID);
				
		lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
		lavanteUtils.switchtoFrame(null);
		Boolean flag1 = false;
		String actualLocationERPID = null;
		lavanteUtils.fluentwait(enviewSupplier.GetLocationERPIDList().get(0));
		List<WebElement> locationERPId = enviewSupplier.GetLocationERPIDList();
		for (WebElement getLocationERPId : locationERPId) {
			if (getLocationERPId.getText().contains(locationID)) {
				actualLocationERPID = getLocationERPId.getText();
				flag1 = true;
			}
		}
		Reporter.log(" Verifying Basic Search with Location ERP ID working as expected, Actual searched Location ERPID : "+ actualLocationERPID);
		Assert.assertTrue(flag1," Verifying Basic Search with Location ERP ID working as expected, Actual searched Location ERPID : "+ actualLocationERPID);

		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * 
	 * SIM-9161 Add New View in Supplier Search Results
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test
	public void supplierSearchViewTest002() throws Exception {
		Reporter.log("Test Started for supplierSearchViewTest001 : " + currenttime());

		enobjsupplierPage.selectChangeView("Invites");
		lavanteUtils.Scrollintoview(enobjsupplierPage.totalsearchcount());
		enobjsupplierPage.SearchViewDropDwn().click();
		List<String> viewOptions = lavanteUtils.listelement("");
		boolean flag = false;
		if (viewOptions.size() > 1) {
			for (String options : viewOptions) {
				if (options.equals("Organization")) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		Reporter.log(" Verifying search view with 2 options Profile status view and Organization view  :"+flag);
		Assert.assertTrue(flag, " Verifying search view with 2 options Profile status view and Organization view  failed");

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("Clear", "");
		dataMap.put("Tab", "CustomerProfile");
		dataMap.put("SupplierERPID", "Contains,1");
		dataMap.put("LocationERPID", "Contains,S");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		String supplierERPID = enobjsupplierPage.iterateSearchHeaderFindColList("ERP").get(0).getText();
		Boolean flag0 = false;
		if (supplierERPID.contains("1")) {
			flag0 = true;
		}
		Reporter.log(" Verifying advance Search with Location ERP ID and Supplier ERPID , Actual searched Supplier ERPID : "	+ supplierERPID);
		Assert.assertTrue(flag0," Verifying advance Search with Location ERP ID and Supplier ERPID , Actual searched Supplier ERPID : "	+ supplierERPID);
		lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
		
		lavanteUtils.switchtoFrame(null);
		Boolean flag1 = false;
		String actualLocationERPID = null;
		lavanteUtils.fluentwait(enviewSupplier.GetLocationERPIDList().get(0));
		List<WebElement> locationERPId = enviewSupplier.GetLocationERPIDList();
		for (WebElement getLocationERPId : locationERPId) {
			if (getLocationERPId.getText().contains("S")) {
				actualLocationERPID = getLocationERPId.getText();
				flag1 = true;
			}
		}
		Reporter.log(" Verifying Advance Search with Location ERP ID , Actual searched Location ERPID : "	+ actualLocationERPID);
		Assert.assertTrue(flag1," Verifying Advance Search with Location ERP ID , Actual searched Location ERPID : "+ actualLocationERPID);

		Reporter.log("Test Ended at: " + currenttime());
	}
	
	@AfterMethod
	public void aftermethod(){
		enobjhomePage.backtoSearch();
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author Subhas.BV
	 */
	@AfterClass
	public void setupAfterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}