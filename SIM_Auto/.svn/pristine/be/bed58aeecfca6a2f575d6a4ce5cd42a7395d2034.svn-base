package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 06-02-2017 Created for EditPaymentTerms
 * 
 * @author Subhash.BV
 *
 */
public class CompanyDissociationOfSupplierContact03 extends PageInitiator {

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
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		dataMap.put("ProfStatus","Pending Validation");
		dataMap.put("Tab","Legal#Enterprise");
		
		ensupplierAdvanced.buildQuery(dataMap);	
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);
	}

	@Test
	public void dissociationOfSupplierContact001Test() {
		Reporter.log("Test Started for dissociationOfSupplierContact001Test Test in Edit Profile at :"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("DelPrevious", "");
		dataMap.put("AddAddress", "Add New");
		dataMap.put("LocationType", "Legal Notices");
		String addressName = "Addr" + randomnum();
		dataMap.put("Address1", addressName);
		dataMap.put("City", "City1" + generateRandomNumber9OnLength(7));
		dataMap.put("Country", "United States");
		dataMap.put("State", "Alabama");
		dataMap.put("PostalCode", "pin" + generateRandomNumber9OnLength(7));
		dataMap.put("AddContact", "Add New");
		String contactName = "ContNam" + randomnum();
		dataMap.put("Name", contactName);
		dataMap.put("Email", "ANY");
		eneditCompanyProfile.AddLocationContact(dataMap);

		dataMap.put("Save", "");
		eneditProfile.formAction(dataMap);
		lavanteUtils.click(eneditCompanyProfile.ManageSupplierContactsBtn());
		lavanteUtils.waitForTime(2000);
		lavanteUtils.fluentwait(eneditCompanyProfile.OkYesBtn());
		boolean flag=isElementDisplayed(eneditCompanyProfile.OkYesBtn());
		if(flag==true){
			lavanteUtils.click(eneditCompanyProfile.OkYesBtn());
		}
		lavanteUtils.fluentwait(eneditCompanyProfile.AddressTab());
		lavanteUtils.fluentwait(eneditCompanyProfile.editBtn());
		int size = objUserPage.ListOfContactName.size();
		String actualContactUserName = "";
		for (int i = 0; i < size; i++) {
			actualContactUserName = lavanteUtils.getText(objUserPage.ListOfContactName.get(i));
			if (actualContactUserName.equals(contactName)) {
				click(objUserPage.ListDeleteUserIcon.get(i));
				break;
			}
		}
		Reporter.log("Actual " + actualContactUserName + "Expected " + contactName + " Verification contact saved ");
		assertEquals(actualContactUserName, contactName, " Verification failed contact not saved ");
		lavanteUtils.click(eneditCompanyProfile.OKbtn());
		lavanteUtils.fluentwait(eneditCompanyProfile.OKbtn());
		String getMsg = driver.findElement(By.cssSelector("div[class*='undefined']")).getText();
		flag = false;
		if (getMsg.contains("The contact you are trying to delete is already associated with following customer and locations")) {
			lavanteUtils.click(eneditCompanyProfile.OKbtn());
			flag = true;
		}

		Reporter.log("verifying the contact cant be deleted " + flag);
		assertTrue(flag, " Verification failed, the contact is deleted  ");
		String actualAdressUserName = "";
		lavanteUtils.fluentwait(eneditCompanyProfile.AddressTab());
		lavanteUtils.click(eneditCompanyProfile.AddressTab());
		lavanteUtils.waitforPageload(eneditCompanyProfile.AddressTab());
		lavanteUtils.fluentwait(eneditCompanyProfile.editBtn());
		lavanteUtils.fluentwait(eneditCompanyProfile.AddressTab());
		lavanteUtils.waitForTime(3000);
		size = objUserPage.ListOfAddressName.size();
		for (int i = 0; i < size; i++) {
			actualAdressUserName = lavanteUtils.getText(objUserPage.ListOfAddressName.get(i));
			if (actualAdressUserName.equals(addressName)) {
				click(objUserPage.ListDeleteAdressIcon.get(i));
				break;
			}
		}
		Reporter.log("Actual " + actualAdressUserName + "Expected " + addressName + " Verification addressName saved ");
		assertEquals(actualAdressUserName, addressName, " Verification failed addressName not saved ");
		lavanteUtils.click(eneditCompanyProfile.OKbtn());
		lavanteUtils.waitForTime(3000);
		getMsg = driver.findElement(By.cssSelector("div[class*='undefined ']")).getText();

		boolean flag1 = false;
		if (getMsg.contains("Address deleted successfully")) {
			lavanteUtils.click(eneditCompanyProfile.OKbtn());
			flag1 = true;
		}
		Reporter.log("Verifying the contact deleted " + flag);
		assertTrue(flag, " Verification failed, the contact not deleted  ");

		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(eneditCompanyProfile.editBtn());
		dataMap.clear();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);
		
		Reporter.log("Test end for dissociationOfSupplierContact001Test Test in Edit Profile- at:"+ currenttime());
	}

	@Test
	public void dissociationOfSupplierContact002Test() {
		Reporter.log("Test Started for dissociationOfSupplierContact001Test Test in Edit Profile at :"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("DelPrevious", "");
		dataMap.put("AddAddress", "Add New");
		dataMap.put("LocationType", "Legal Notices");
		String addressName = "Addr" + lavanteUtils.randomnum();
		dataMap.put("Address1", addressName);
		dataMap.put("City", "City1" + lavanteUtils.generateRandomNumber9OnLength(7));
		dataMap.put("Country", "United States");
		dataMap.put("State", "Alabama");
		dataMap.put("PostalCode", "pin" + lavanteUtils.generateRandomNumber9OnLength(7));
		dataMap.put("AddContact", "Add New");
		String contactName = "ContNam" + lavanteUtils.randomnum();
		dataMap.put("Name", contactName);
		dataMap.put("Email", "ANY");
		eneditCompanyProfile.AddLocationContact(dataMap);

		String addressName1 = "Addr" + lavanteUtils.randomnum();
		dataMap.put("Address1", addressName1);
		String contactName1 = "ContNam" + lavanteUtils.randomnum();
		dataMap.put("Name", contactName1);
		eneditCompanyProfile.AddLocationContact(dataMap);

		dataMap.put("Save", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.click(eneditCompanyProfile.ManageSupplierContactsBtn());
		lavanteUtils.waitForTime(2000);
		
		boolean flag=isElementDisplayed(eneditCompanyProfile.OkYesBtn());
		if(flag==true){
			lavanteUtils.click(eneditCompanyProfile.OkYesBtn());
		}
		lavanteUtils.fluentwait(eneditCompanyProfile.AddressTab());
		lavanteUtils.fluentwait(eneditCompanyProfile.editBtn());

		int size = objUserPage.ListOfContactName.size();
		String actualContactUserName = "";
		for (int i = 0; i < size; i++) {
			actualContactUserName = lavanteUtils.getText(objUserPage.ListOfContactName.get(i));
			if (actualContactUserName.equals(contactName)) {
				objUserPage.ListDeleteUserIcon.get(i).click();
				break;
			}
		}
		Reporter.log("Actual " + actualContactUserName + "Expected " + contactName + " Verification contact saved ");
		assertEquals(actualContactUserName, contactName, " Verification failed contact not saved ");
		lavanteUtils.click(eneditCompanyProfile.OKbtn());
		lavanteUtils.fluentwait(eneditCompanyProfile.OKbtn());
		String getMsg = driver.findElement(By.cssSelector("div[class*='undefined ']")).getText();
		flag = false;
		if (getMsg.contains("User deleted successfully")) {
			lavanteUtils.click(eneditCompanyProfile.OKbtn());
			flag = true;
		}

		Reporter.log("verifying the contact deleted " + flag);
		assertTrue(flag, " Verification failed, the contact is not deleted  ");
		String actualAdressUserName = "";
		lavanteUtils.click(eneditCompanyProfile.AddressTab());
		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(eneditCompanyProfile.AddressTab());
		lavanteUtils.waitforPageload(eneditCompanyProfile.AddressTab());
		size = objUserPage.ListOfAddressName.size();
		for (int i = 0; i < size; i++) {
			actualAdressUserName = lavanteUtils.getText(objUserPage.ListOfAddressName.get(i));
			if (actualAdressUserName.equals(addressName)) {
				click(objUserPage.ListDeleteAdressIcon.get(i));
				break;
			}
		}
		Reporter.log("Actual " + actualAdressUserName + "Expected " + addressName + " Verification addressName saved ");
		assertEquals(actualAdressUserName, addressName, " Verification failed addressName not saved ");
		lavanteUtils.click(eneditCompanyProfile.OKbtn());
		lavanteUtils.waitForTime(3000);
		getMsg = driver.findElement(By.cssSelector("div[class*='undefined ']")).getText();

		flag = false;
		if (getMsg.contains("Address deleted successfully")) {
			lavanteUtils.click(eneditCompanyProfile.OKbtn());
			flag = true;
		}
		Reporter.log("Verifying the contact not deleted " + flag);
		assertTrue(flag, " Verification failed, the contact deleted  ");

		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(eneditCompanyProfile.editBtn());
		dataMap.clear();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);
		
		Reporter.log("Test end for dissociationOfSupplierContact002Test Test in Edit Profile- at:"+ currenttime());
	}

	@AfterMethod
	public void aftermethod() {
			enobjhomePage.backtoSearch();
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
			dataMap.put("SaveExit", "");
			eneditProfile.formAction(dataMap);
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}