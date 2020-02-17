package com.lavante.sim.customer.TestScripts.Campaign;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class PaidCampaignsTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String userName = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author subhas.bv
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
		// PaymentCenter-Campaigns
		List listofdatafrm = lavanteUtils.login("PaymentCenter", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		userName = LdataMap.get("username");
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	@BeforeMethod
	public void Before() throws FileNotFoundException, IOException, SQLException {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "CAMPAIGNS");
		dataMap.put("subtab", "campaignSearchSetup");
		enobjhomePage.selectTab(dataMap);

		String deleteQuery = "Delete from LoginRole_RoleType_Map where RoleTypeID=7 and UserRoleID in (select UserRoleID from Login where ContactID in (select ContactID from Contact where Email='"
				+ userName + "')) ";
		lavanteUtils.UpdateDB(deleteQuery);

		String insertQuery = "Insert into LoginRole_RoleType_Map (RoleTypeID, UserRoleID, CreatedBy, CreatedOn) values (7,14,'Admin',getdate())";
		lavanteUtils.UpdateDB(insertQuery);

	}

	/**
	 * Disable Paid Campaign from loginrole map and verify the same.
	 * @author subhas.bv
	 * 
	 *         verifyPaidSessionTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void UIPaidCampaignTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for verify Paid Session Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.clicks(objCampaignPage.CreateCampaignBtn());

		String expectedMsg = "Will the supplier be charged?:";
		String actualMsg = lavanteUtils.getText(objCampaignPage.PaidCampaignSection());

		Reporter.log("Verification : expected paid campaign section msg " + expectedMsg + "with actual paid campaign section msg " + actualMsg);
		softAssert.assertEquals(actualMsg, expectedMsg, "expected paid campaign section msg " + expectedMsg	+ "with actual paid campaign section msg " + actualMsg);

		String deleteQuery = "Delete from LoginRole_RoleType_Map where RoleTypeID=7 and UserRoleID in"
				+ " (select UserRoleID from Login where ContactID in (select ContactID from Contact where Email='"
				+ userName + "')) ";
		lavanteUtils.UpdateDB(deleteQuery);

		lavanteUtils.refreshPage();
		boolean flag = false;
		if (!lavanteUtils.isElementDisplayed(objCampaignPage.PaidCampaignSection())) {
			flag = true;
		}
		Reporter.log("Verification : paid campaign section should no be displayed expected : true , actual : " + flag);
		softAssert.assertTrue(flag," paid campaign section should no be displayed but it is expected : true , actual : " + flag);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for verify Paid Session  :" + currenttime());
	}
	
	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}


}
