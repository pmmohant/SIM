package com.lavante.sim.customer.TestScripts.Dashboard;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * 
 * @author Subhas.BV
 *
 */
public class CampaignDashboardTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;

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

		List listofdatafrm = lavanteUtils.login("Campaigns", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * @author subhas.bv
	 * 
	 *         Campaign status , a.Draft b.Pending c.Pending Update d.Approved
	 *         f.Intiated g.Rejected h.Completed and count in the campaign basic
	 *         search page
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void verifyCamapignDashboardTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for verifyCamapignDashboardTest Test :" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.click(objCampaignDashboard.ViewCampaignDashboard());
		LinkedHashMap<String, String> campStatusCountUI = new LinkedHashMap<>();
		List<WebElement> camStatus = objCampaignDashboard.GetCampaignStatusList();
		List<WebElement> campStatCount = objCampaignDashboard.GetCampaignStatusCountList();
		for (int i = 0; i < camStatus.size(); i++) {
			campStatusCountUI.put(camStatus.get(i).getText(), campStatCount.get(i).getText());
		}

		dataMap.put("maintab", "CAMPAIGNS");
		dataMap.put("subtab", "campaignSearchSetup");
		enobjhomePage.selectTab(dataMap);

		String getTotalCampaigns = "select count(*) from CampaignDetails where CustomerID=" + customerID + "";
		getTotalCampaigns = lavanteUtils.fetchDBdata(getTotalCampaigns);
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String count = ""+lavanteUtils.getCount();
		Reporter.log(" Campaigns total count , Expected : " + getTotalCampaigns + " , ACtual : " + count);
		softAssert.assertEquals(count, getTotalCampaigns,
				" Campaigns total count not matching , Expected : " + getTotalCampaigns + " , ACtual : " + count);

		List<String> campaignStatus = new ArrayList<String>();
		campaignStatus.add("Draft");
		campaignStatus.add("Pending");
		campaignStatus.add("Pending Update");
		campaignStatus.add("Approved");
		campaignStatus.add("Initiated");
		campaignStatus.add("Rejected");
		campaignStatus.add("Completed");

		String status = null;
		for (int i = 0; i < campaignStatus.size(); i++) {
			
			status = campaignStatus.get(i);
			dataMap.put("CampaignStatus", status);
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);
			
			lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			count = ""+lavanteUtils.getCount(); 
			Reporter.log(" Campaign status " + status
					+ " in dashboard count and in the campaign basic search page count, Expected : "
					+ campStatusCountUI.get(status) + " , ACtual : " + count);
			softAssert.assertEquals(count, campStatusCountUI.get(status),
					" Campaign status " + status
							+ " in dashboard count is not matching with the campaign basic search page count, Expected : "
							+ campStatusCountUI.get(status) + " , ACtual : " + count);
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for verifyCamapignDashboardTest Test :" + currenttime());
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
