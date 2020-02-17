package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ManageUsers;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 21-09-2016 Created for Verifying SIM User Roles
 * 
 * @author Subhash.BV
 *
 */

public class RecoveryAccountManagerTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String username="";

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
		List<?> listofdatafrm = lavanteUtils.login("UserRoleId3", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * UserRoles- Verify that Recovery Customer is created with UserRoleID=4 and
	 * there should be a new flag isRecovery in Customer table to indicate that
	 * the customer(ie Recovery Customer) is for Recovery.
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUserRecCustomer", dataProviderClass = ManageUsers.class)
	public void addNwUserinRcvryLogin(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for addNwUserinRcvryLogin:" + currenttime());

		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("Save", "");
		dataMap.remove("InvitingOrg");
		dataMap.put("UserRole", "ANY");
		objUserPage.addNewUser(dataMap);
		
		String xdata=dataMap.get("ContactName");
		dataMap.clear();
		dataMap.put("ContactName", xdata);
		username=xdata;
		objUserPage.searchUserContactName(dataMap);
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualContactName = objUserPage.iterateSearchHeaderFindColList("User Name").get(0).getText();
		Assert.assertEquals(actualContactName, xdata," The user contact not created, Expected , " + xdata+ " Actual, " + actualContactName);

		String query = "select c.IsRecoveryCustomer from Customer c , Contact ct, Customer_Contact_Map cm where cm.ContactID = ct.ContactID  and c.CustomerID = cm.CustomerID and ct.ContactName='"
				+ xdata + "'";
		String actualValue = lavanteUtils.fetchDBdata(query);
		int expectedValue = 1;

		Reporter.log(" Verify Recovery Customer flag isRecovery in Customer table is true, Expected " + expectedValue+ " Actual " + actualValue);
		Assert.assertEquals(Integer.parseInt(actualValue), expectedValue,	" Verify Recovery Customer flag isRecovery in Customer table is true, Expected " + expectedValue						+ " Actual " + actualValue);

		Reporter.log("Test Ended for Verify addNwUserinRcvryLogin Test at:" + currenttime(),true);
	}

	/**
	 * UserRoles- Verify that Recovery/Lavante Account Manager is created with
	 * UserRoleID=3 and there should be a new flag isRecovery in Customer table
	 * to indicate that the customer(ie Recovery Account Manager) is for
	 * Recovery.
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUserRecAccManager", dataProviderClass = ManageUsers.class)
	public void addNwUserinRcvryLavanteManager(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for verifyRecoveryLavanteAccountManagerTest:" + currenttime());

		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("Save", "");
		dataMap.put("UserRole","ANY");
		objUserPage.addNewUser(dataMap);
		String xdata=dataMap.get("ContactName");
		
		dataMap.clear();
		dataMap.put("ContactName",xdata);
		objUserPage.searchUserContactName(dataMap);
		username=xdata;
		
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualContactName = objUserPage.iterateSearchHeaderFindColList("User Name").get(0).getText();
		Assert.assertEquals(actualContactName, xdata," The user contact not created, Expected , " + xdata + " Actual, " + actualContactName);

		String query = "select c.IsRecoveryCustomer from Customer c , Contact ct, Customer_Contact_Map cm where cm.ContactID = ct.ContactID  and c.CustomerID = cm.CustomerID and ct.ContactName='"
				+ xdata + "'";
		String actualValue = lavanteUtils.fetchDBdata(query);
		int expectedValue = 1;

		Reporter.log(" Verify Recovery Account Manager flag isRecovery in Customer table is true, Expected "+ expectedValue + " Actual " + actualValue);
		Assert.assertEquals(Integer.parseInt(actualValue), expectedValue," Verify Recovery Account Manager flag isRecovery in Customer table is true, Expected " + expectedValue	+ " Actual " + actualValue);

		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * UserRoles: Verify that only Recovery Account Manager should be able to
	 * Activate,Deactivate,Send Message, Download Documents Outreach
	 * 
	 * Verify that Recovery Account Manager should be able to Outreach
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test
	public void verifyRecoveryAccountManagerActionsTest() throws Exception {
		Reporter.log("Test Started for verifyRecoveryAccountManagerActionsTest:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert=new SoftAssert();
		// Navigating to Supplier page
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.waitForTime(3000);
		enobjsupplierPage.searchResultsFilterBy("ALL");
		
		dataMap.put("Account", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		boolean actualActivateBtn = lavanteUtils.isElementDisplayed(enobjsupplierPage.activatebtn());
		boolean expectedActivateBtn = true;
		Reporter.log(" The Activate btn should be displayed , Expected " + expectedActivateBtn + " ,Actual "+ actualActivateBtn);
		softAssert.assertEquals(actualActivateBtn, expectedActivateBtn, " The Activate btn should be displayed , Expected "+ expectedActivateBtn + " ,Actual " + actualActivateBtn);

		boolean actualDeactivateBtn = lavanteUtils.isElementDisplayed(enobjsupplierPage.activatebtn());
		boolean expectedDeactivateBtn = true;
		Reporter.log(" The Deactivate btn should be displayed , Expected " + expectedDeactivateBtn + " ,Actual "+ actualDeactivateBtn);
		softAssert.assertEquals(actualDeactivateBtn, expectedDeactivateBtn,	" The Deactivate btn should be displayed , Expected " + expectedDeactivateBtn + " ,Actual "	+ actualDeactivateBtn);

		String actualValue = enobjsupplierPage.sendEmailbtn().getAttribute("class");
		String expectedValue = "buttons_group_button";
		Reporter.log(" The Send Email btn should be available , Expected " + expectedValue + " ,Actual " + actualValue);
		softAssert.assertEquals(expectedValue, actualValue," The Send Email btn should be available , Expected " + expectedValue + " ,Actual " + actualValue);

		Boolean actual = lavanteUtils.isElementDisplayed(enobjsupplierPage.StartOutreachBtn());
		Boolean expected = true;

		Reporter.log(" The Start Out Reach btn should be available , Expected " + expected + " ,Actual " + actual);
		softAssert.assertTrue(expected,	" The Start Out Reach btn should be available , Expected " + expected + " ,Actual " + actual);
		
		boolean downloadoption = lavanteUtils.isElementDisplayed(enobjsupplierPage.downloaddoc());
		boolean expecteddownloadoptionBtn = true;
		Reporter.log(" The Download btn should be displayed , Expected " + expectedActivateBtn + " ,Actual "+ actualActivateBtn);
		softAssert.assertEquals(downloadoption, expecteddownloadoptionBtn, " The Download btn should be displayed , Expected "	+ expecteddownloadoptionBtn + " ,Actual " + downloadoption);

		softAssert.assertAll();
		Reporter.log("Test Ended for verifyRecoveryAccountManagerActionsTest at:" + currenttime());

	}

	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.refreshPage();
		enobjhomePage.popupclose();
		if(username.length()>0){
			String q = " delete from LoginInvitingOrgMap where LoginID in (select LoginID from [Login]  where ContactID in (select ContactID from Contact where ContactName='" + username+ "'))";
			String q1 = "delete from ReceiverMessage where RecieverLoginID in (select LoginID From Login where ContactID in (select ContactID from Contact where ContactName='" + username+ "'))";
			String q2 = "delete from Login where ContactID in (select ContactID from Contact where ContactName='" + username+ "')";
			String q3 = "delete from Customer_Contact_Map  where ContactID in (select ContactID from Contact where ContactName='"+ username + "')";
			String q4 = "delete from  Contact where ContactName='" + username + "'";
	
			lavanteUtils.UpdateDB(q);
			lavanteUtils.UpdateDB(q1);
			lavanteUtils.UpdateDB(q2);
			lavanteUtils.UpdateDB(q3);
			lavanteUtils.UpdateDB(q4);
		}
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
