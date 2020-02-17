package com.lavante.sim.customer.TestScripts.UserRoles;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ShadowProxyTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String selctedCust = "";

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * 
	 */
	String customerID = null;
	String customerName = null;
	String supplier = null;

	@SuppressWarnings("unchecked")
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
		// SupKroger
		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		customerID = lavanteUtils.fetchSupplierCustomer(dataMap.get("username"));
		customerName = "select name from customer where customerid= " + customerID + " ";
		customerName = lavanteUtils.fetchDBdata(customerName);
		supplier = lavanteUtils.fetchSupFromSupCustomer(dataMap.get("username"));
		// Login
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();
	}

	/**
	 * Supplier Search Act Behalf
	 * 
	 * 
	 * SIM 7.2
	 * 
	 * @author Subhas.BV
	 * @throws Exception
	 */
	@Test
	public void supplierActBehalfTest() throws Exception {
		Reporter.log("Test Started for supplierActBehalf Test : " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		ArrayList<String> supTasks = new ArrayList<String>();
		ArrayList<String> supProxyTasks = new ArrayList<String>();
		lavanteUtils.fluentwait(enObjSupplierHomePage.EditList().get(0));
		String expinvitation = lavanteUtils.getText(enObjSupplierHomePage.ListInvite().get(0));

		List<WebElement> eles = enObjSupplierHomePage.TasksDescList();
		for (int i = 0; i < eles.size(); i++) {
			supTasks.add(lavanteUtils.getText(eles.get(i)));
		}
		enobjhomePage.logout();

		// Login
		List<?> listofdatafrm = lavanteUtils.login("LavanteSupportRole", browser);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		enobjloginpage.logintoAPP(dataMap);

		lavanteUtils.click(enobjhomePage.AllCustomersDropDwn());
		lavanteUtils.typeinEdit(customerName, enobjhomePage.AllCustomersDropDwnTxtBox);
		lavanteUtils.selectvalueFrmDpdn(customerName);

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("supplierName", supplier);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enobjsupplierPage.selectSupplier(dataMap);

		dataMap.put("profile", "");
		String x="select PropertyValue From ApplicationPropertiesCustomer where ApplicationPropertyID in ( "
				+ " select ApplicationPropertyID from ApplicationProperties where PropertyName='SupplierLoginRoles')"
				+ " and CustomerID in (Select CustomerID from Customer where Name='"+customerName+"')";
		x=lavanteUtils.fetchDBdata(x);
		if(x.contains(",")){
			String[] asd=x.split(",");
			dataMap.put("ActBehalf",asd[0]);
			enobjsupplierPage.ProfileAction(dataMap);
		}

		lavanteUtils.fluentwait(enObjSupplierHomePage.EditList().get(0));
		String actinvitation = lavanteUtils.getText(enObjSupplierHomePage.ListInvite().get(0));
		Reporter.log("Verify ID " + expinvitation + " ,Actuals:" + actinvitation);
		softAssert.assertEquals(actinvitation, expinvitation,"Invitiation not matched");
		
		eles = enObjSupplierHomePage.TasksDescList();
		for (int i = 0; i < eles.size(); i++) {
			supProxyTasks.add(lavanteUtils.getText(eles.get(i)));
		}

		for (String temp : supProxyTasks)
			for (int i = 0; i < supTasks.size(); i++) {
				if (temp.equals(supTasks.get(i))) {
					flag = true;
					Reporter.log("Verify task " + temp + " is present in " + supTasks);
					softAssert.assertTrue(flag, " Task " + temp + " is not present in " + supTasks);
					break;
				}
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended at supplierActBehalf Test:" + currenttime());
	}


	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
