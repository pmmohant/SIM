package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
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

public class AddressPageTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String address1="";
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
		List listofdatafrm = lavanteUtils.login("UserRoleId14", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "Address");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * MangeRoles- Add Address
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */

	@Test(dataProvider = "AddNwAddress", dataProviderClass = ManageUsers.class)
	public void addAddressTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for addNewUserTest:" + currenttime());
		lavanteUtils.fluentwait(objManageAddressesPage.AddressTab);
		String expectedTitle = "PRGX SIM - Addresses";
		String actualTitle = driver.getTitle();

		Reporter.log("Actual title is:" + actualTitle + " Expected Title is:" + expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle," Navigation failed to manage users page invalid page title:" + actualTitle);

		dataMap.put("Save", "");
		address1 = objManageAddressesPage.addUserAddress(dataMap);
		boolean flag = false;
		String actualAddress;
		int noRecords = objManageAddressesPage.GetAddress1.size();
		for (int i = noRecords; i >= 0; i--) {
			actualAddress = objManageAddressesPage.GetAddress1.get(i - 1).getAttribute("title");
			if (actualAddress.equals(address1)) {
				flag = true;
				Reporter.log("Address created " + actualAddress + "Expected address " + dataMap.get("Address1"));
				break;
			}
		}

		Assert.assertTrue(flag, "Address created doesn't match are not created");
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * MangeRoles- Edit Address
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */

	@Test(dataProvider = "AddNwAddress", dataProviderClass = ManageUsers.class)
	public void editAddressTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for addNewUserTest:" + currenttime());
		address1="";
		SoftAssert softAssert = new SoftAssert();
		lavanteUtils.fluentwait(objManageAddressesPage.AddressTab);
		
		String expectedTitle = "PRGX SIM - Addresses";
		String actualTitle = driver.getTitle();
		System.out.println("Actual title is " + actualTitle + " Expected Title is " + expectedTitle);
		Reporter.log("Actual title is " + actualTitle + " Expected Title is " + expectedTitle);
		softAssert.assertEquals(actualTitle, expectedTitle," Navigation failed to manage users page invalid page title:" + actualTitle);		
		
		dataMap.put("Save", "");
		address1 = objManageAddressesPage.addUserAddress(dataMap);
		Reporter.log("First Saved Address:"+address1);
		boolean flag = false;
		String actualAddress;
		int noRecords = objManageAddressesPage.GetAddress1.size()-1;
		for (int i = noRecords; i >= 0; i--) {
			actualAddress = objManageAddressesPage.GetAddress1.get(i).getAttribute("title");
			if (actualAddress.equals(address1)) {
				flag = true;
				Reporter.log("Added Address Available in the list");
				Assert.assertTrue(lavanteUtils.isElementDisplayed(objManageAddressesPage.GetAddressedit.get(i)),"Edit option is not displayed");
				lavanteUtils.click(objManageAddressesPage.GetAddressedit.get(i));
				break;
			}
		}
		dataMap.clear();
		String editAddress1 = address1 + "EditedAddress";
		dataMap.put("Address1", editAddress1);
		dataMap.put("Save", "");
		objManageAddressesPage.editUserAddress(dataMap);
		Reporter.log("Edited Address:"+address1);
		noRecords = objManageAddressesPage.GetAddress1.size()-1;
		outr:for (int i = noRecords; i >= 0; i--) {
			actualAddress = objManageAddressesPage.GetAddress1.get(i).getAttribute("title");
			if (actualAddress.equals(editAddress1)) {
				flag = true;
				Reporter.log("Address Edited Available in the list " + actualAddress + "Expected address " + editAddress1);
				address1=editAddress1;
				break outr;
			}
		}

		softAssert.assertAll();

		Assert.assertTrue(flag, "Address created doesn't match are not created");
		Reporter.log("Test Ended at:" + currenttime());
	}

	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		if(address1.length()>0){
			String delquery="delete from Customer_Address_Map where AddressID in (Select  AddressID   from Address where Address1='"+address1+"')";
			lavanteUtils.UpdateDB(delquery);
			delquery="delete from Address where Address1='"+address1+"'";
			lavanteUtils.UpdateDB(delquery);
		}
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
