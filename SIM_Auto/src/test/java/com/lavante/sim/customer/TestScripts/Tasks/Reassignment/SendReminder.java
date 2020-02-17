package com.lavante.sim.customer.TestScripts.Tasks.Reassignment;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 08-02-2017
 * 
 * @author Subhas.B V
 *
 */
public class SendReminder extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
	String customerID = "";

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhas.B V
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
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "viewApprovalTasks");
		enobjhomePage.selectTab(LdataMap);
		lavanteUtils.waitForTime(3000);

	}

	/**
	 * SIM-9895 Ability to send notifications to pending approvers from
	 * re-assignment
	 * 
	 * @author Subhas. B V
	 * @throws IOException
	 */
	@Test
	public void sendReminder01Test() throws Exception {

		Reporter.log("Test Started for sendRemainder001Test :" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		SoftAssert softAssert=new SoftAssert();
		
		String Filterby="Post Profile Complete Approval Workflow for New Suppliers"; //Sup Reg to approve
		dataMap.put("filterby", Filterby);
		dataMap.put("SendReminder", "");
		String getSupplierName = enReassign.selectSupplierFormAction(dataMap);

		lavanteUtils.waitForTime(6000);
		String query = "select Top 1 MergedNotificationContent from [Notification] where NotificationTypeID in (select NotificationTypeID from NotificationType where NotificationType like 'TASK_REMINDER_NOTIFICATION_TEMPLATE' and CustomerID="
				+ customerID + " ) order by CreatedOn desc";
		query = lavanteUtils.fetchDBdata(query);
		String xFilterby="Registered Suppliers to approve";
		Boolean flag1 = false;
		if (query.contains(getSupplierName) && query.contains(xFilterby)) {
			flag1 = true;
		}

		softAssert.assertTrue(flag1, "Expected Supplier Name: " + getSupplierName + " Filter By ," + xFilterby+ " ,Actual From DB " + query);
		dataMap.put("filterby", "Update SupplierERPID");
		getSupplierName = enReassign.selectSupplierFormAction(dataMap);

		query = "select Top 1 MergedNotificationContent from [Notification] where NotificationTypeID in (select NotificationTypeID from NotificationType where NotificationType like 'TASK_REMINDER_NOTIFICATION_TEMPLATE' and CustomerID="
				+ customerID + " ) order by CreatedOn desc";

		//Waiting for the Mail Entry in Notifcation Table
		lavanteUtils.waitForTime(6000);
		query = lavanteUtils.fetchDBdata(query);
		Boolean flag2 = false;
		if (query.contains(getSupplierName) && query.contains(xFilterby)) {
			flag2 = true;
		}

		softAssert.assertTrue(flag2, "Expected Supplier Name " + getSupplierName + " Filter By ,"  + xFilterby+ " , Actual From DB " + query);
		dataMap.put("filterby", "New supplier invite approval");
		getSupplierName = enReassign.selectSupplierFormAction(dataMap);

		query = "select Top 1 MergedNotificationContent from [Notification] where NotificationTypeID in (select NotificationTypeID from NotificationType where NotificationType like 'TASK_REMINDER_NOTIFICATION_TEMPLATE' and CustomerID="
				+ customerID + " ) order by CreatedOn desc";

		//Waiting for the Mail Entry in Notifcation Table
		lavanteUtils.waitForTime(6000);
		query = lavanteUtils.fetchDBdata(query);
		Boolean flag3 = false;
		if (query.contains(getSupplierName) && query.contains(xFilterby)) {
			flag3 = true;
		}

		softAssert.assertTrue(flag3, "Expected Supplier Name " + getSupplierName + " Filter By ,"  + xFilterby+ " ,Actual From DB " + query);
		
		softAssert.assertAll();
		Reporter.log("Test Stoped MergedNotificationContent  :" + currenttime());
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
