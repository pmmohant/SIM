package com.lavante.sim.customer.TestScripts.UserRoles;

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

public class CustomerPropertyEditProfileTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String sname = null;
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
	}
	
	/**
	 * @author vidya.c
	 * 
	 *         Customer Property ENABLE_MULTISELECT_PAYMENT_TYPE_FOR_PAYMENT_CENTER(Verify multiple selection of 
		payment types for a payment center)
	 * @throws Exception 
	 * 
	 */
	@Test
	public void ENABLE_MULTISELECT_PAYMENT_TYPE_FOR_PAYMENT_CENTERTest() throws Exception {
		Reporter.log("Test Started for ENABLE_MULTISELECT_PAYMENT_TYPE_FOR_PAYMENT_CENTER Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		// Login
		List<?> listofdatafrm = lavanteUtils.login("CHS", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		// Supplier Tab
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String query = "select customerpropertyid from CustomerProperty where PropertyName = 'ENABLE_MULTISELECT_PAYMENT_TYPE_FOR_PAYMENT_CENTER'";
		String custPropId = lavanteUtils.fetchDBdata(query);
		
		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID	+ " and CustomerPropertyID="+custPropId;
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Pending Validation");
		sname = dataMap.get("supname");
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierRelationshipTreasuryInfo");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);
		
		boolean flag = false;
		WebElement ele = driver.findElement(By.cssSelector("label[for*='paymentType_2'][class='box-image']"));
		if (lavanteUtils.isElementDisplayed(ele)) {
			flag = true;
		}
		Reporter.log("Payment Type is single select and its a radio button, Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Payment Type is single select, Expected: True, Actual: "+flag);
		
		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+custPropId+", "+customerID+", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		flag = false;
		 ele = driver.findElement(By.cssSelector("[id*='paymentType_2'][type='checkbox']"));
		if (lavanteUtils.isElementDisplayed(ele)) {
			flag = true;
		}
		
		Reporter.log("Payment Type multiselect is enabled and changed to Checkbox, Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Payment Type multiselect is enabled, Expected : true , Actual :" + flag);
		softAssert.assertAll();
		Reporter.log("Test Ended for ENABLE_MULTISELECT_PAYMENT_TYPE_FOR_PAYMENT_CENTER:" + currenttime());
	}
	
	/**
	 * @author vidya.c
	 * 
	 *         Customer Property ENABLE_EDIT_INVITE_POST_INVITE(Verify Edit invite after 
	 *         invite has been sent )
	 * @throws Exception 
	 * 
	 */
	@Test
	public void ENABLE_EDIT_INVITE_POST_INVITETest() throws Exception {
		Reporter.log("Test Started for ENABLE_EDIT_INVITE_POST_INVITE Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		// Login
		List<?> listofdatafrm = lavanteUtils.login("Sanity", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		// Supplier Tab
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		String query = "select customerpropertyid from CustomerProperty where PropertyName = 'ENABLE_EDIT_INVITE_POST_INVITE'";
		String custPropId = lavanteUtils.fetchDBdata(query);
		
		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID	+ " and CustomerPropertyID=" + custPropId;
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Pending Validation");
		sname = dataMap.get("supname");
		enobjsupplierBasicSearch.search(dataMap);
		
		dataMap.put("SearchOption", "Invites");
		enobjsupplierPage.searchView(dataMap);
				
		dataMap.put("profile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		lavanteUtils.waitForTime(2000);
		boolean flag = false;
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if (!enobjsupplierPage.EditInvitebtn().isEnabled()) {
			flag = true;
		}
		
		Reporter.log("Edit Invite is disabled after deleting the customerProperty, Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Edit Invite is disabled after deleting the customerProperty, Expected: True, Actual: "+flag);
		
		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+custPropId+", "+customerID+", 'true', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		
		dataMap.put("profile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		flag = false;
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if (enobjsupplierPage.EditInvitebtn().isEnabled()) {
			flag = true;
		}
		Reporter.log("Edit Invite is enabled , Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Edit Invite is enabled, Expected: True, Actual: "+flag);
		
		insert = "Update CustomerPropertyValue set PropertyValue='false' where  CustomerPropertyID="+custPropId+" and CustomerID= "+customerID;
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		dataMap.put("profile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		flag = false;
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if (!enobjsupplierPage.EditInvitebtn().isEnabled()) {
			flag = true;
		}
		
		Reporter.log("Edit Invite is disabled , Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "Edit Invite is disabled, Expected: True, Actual: "+flag);
		softAssert.assertAll();
		Reporter.log("Test Ended for ENABLE_EDIT_INVITE_POST_INVITE Test:" + currenttime());
	}
	
	/**
	 * @author vidya.c
	 * 
	 *         Customer Property INVITE_PREFIX(Set this to display prefix for invite )
	 *       
	 * @throws Exception 
	 * 
	 */
	@Test
	public void INVITE_PREFIXTest() throws Exception {
		Reporter.log("Test Started for INVITE_PREFIX Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		// Login
		List<?> listofdatafrm = lavanteUtils.login("Sanity", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		// Supplier Tab
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String query = "select customerpropertyid from CustomerProperty where PropertyName = 'INVITE_PREFIX'";
		String custPropId = lavanteUtils.fetchDBdata(query);
		
		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID	+ " and CustomerPropertyID="+custPropId;
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Pending Validation");
		sname = dataMap.get("supname");
		enobjsupplierBasicSearch.search(dataMap);
		
		dataMap.put("SearchOption", "Invites");
		enobjsupplierPage.searchView(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		List<WebElement> inviteIdList = enobjsupplierPage.iterateSearchHeaderFindColList("Invitation ID");
		String prefix = "IN";
		boolean flag = false;
		if(!inviteIdList.get(0).getText().contains(prefix)) {
			flag = true;
		}
		
		Reporter.log("Invite prefix is disabled after deleting the customerProperty, Expected : True , Actual :" + flag);
		softAssert.assertTrue(flag, "Invite prefix is disabled after deleting the customerProperty, Expected: True, Actual: "+flag);
		
		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+custPropId+", "+customerID+", '"+prefix+"', 1, 'Admin', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		inviteIdList = enobjsupplierPage.iterateSearchHeaderFindColList("Invitation ID");
		flag = false;
		if(inviteIdList.get(0).getText().contains(prefix)) {
			flag = true;
		}
		Reporter.log("Invite prefix is enabled and set to "+prefix+", Expected : True , Actual :" + flag);
		softAssert.assertTrue(flag, "Invite prefix is enabled and set to "+prefix+", Expected: True, Actual: "+flag);
		
		insert = "Update CustomerPropertyValue set PropertyValue='' where CustomerPropertyID="+custPropId+" and CustomerID="+customerID;
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		inviteIdList = enobjsupplierPage.iterateSearchHeaderFindColList("Invitation ID");
		flag = false;
		if(!inviteIdList.get(0).getText().contains(prefix)) {
			flag = true;
		}
		
		Reporter.log("Invite prefix is disabled , Expected : True , Actual :" + flag);
		softAssert.assertTrue(flag, "Invite prefix is disabled, Expected: True, Actual: "+flag);
		softAssert.assertAll();
		Reporter.log("Test Ended for INVITE_PREFIX Test:" + currenttime());
	}
	
	/**
	 * @author vidya.c
	 * 
	 *         Customer Property IS_EXTEND_INVITE_DISABLED(Set this to true to disable extend invite for the customer)
	 *       
	 * @throws Exception 
	 * 
	 */
	@Test
	public void IS_EXTEND_INVITE_DISABLEDTest() throws Exception {
		Reporter.log("Test Started for IS_EXTEND_INVITE_DISABLED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		// Login
		List<?> listofdatafrm = lavanteUtils.login("Sanity", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		// Supplier Tab
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String query = "select customerpropertyid from CustomerProperty where PropertyName = 'IS_EXTEND_INVITE_DISABLED'";
		String custPropId = lavanteUtils.fetchDBdata(query);
		
		String delete = "Delete from CustomerPropertyValue where CustomerID=" + customerID 	+ " and CustomerPropertyID="+custPropId;
		lavanteUtils.UpdateDB(delete);
		lavanteUtils.refreshPage();
		
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Pending Validation");
		sname = dataMap.get("supname");
		enobjsupplierBasicSearch.search(dataMap);
		
		dataMap.put("profile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		lavanteUtils.waitForTime(2000);
		boolean flag = false;
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if (enobjsupplierPage.ExtendInvitebtn().isDisplayed()) {
			flag = true;
		}
		
		Reporter.log("Extend Invite is enabled after deleting the customerProperty, Expected : True , Actual :" + flag);
		softAssert.assertTrue(flag, "Extend Invite is enabled after deleting the customerProperty, Expected: True, Actual: "+flag);
		
		String insert = "Insert into CustomerPropertyValue ( CustomerPropertyID, CustomerID, PropertyValue, IsActive,CreatedBy, CreatedOn ) VALUES ("+custPropId+", "+customerID+", 'True', 1, 'Vidya', getdate())";
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();
		
		dataMap.put("profile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		flag = false;
		try {
			if(enobjsupplierPage.ExtendInvitebtn().isDisplayed()) {
				flag = false;
			}
		} catch(Exception e) {
			flag = true;
		}

		Reporter.log("Extend Invite is disabled, Expected : True , Actual :" + flag);
		softAssert.assertTrue(flag, "Extend Invite is disabled, Expected: True, Actual: "+flag);
		
		insert = "Update CustomerPropertyValue set PropertyValue='false' where CustomerPropertyID="+custPropId+" and CustomerID= "+customerID;
		lavanteUtils.UpdateDB(insert);
		lavanteUtils.refreshPage();
		
		flag = false;
		dataMap.put("profile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if (enobjsupplierPage.ExtendInvitebtn().isDisplayed()) {
			flag = true;
		}
		
		Reporter.log("Extend Invite is enabled, Expected : True , Actual :" + flag);
		softAssert.assertTrue(flag, "Extend Invite is enabled, Expected: True, Actual: "+flag);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for IS_EXTEND_INVITE_DISABLED Test:" + currenttime());
	}
	
	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		enobjhomePage.logout();
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		quitBrowser();
	}

}
