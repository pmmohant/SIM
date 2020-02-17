package com.lavante.sim.customer.TestScripts.Compliance.OFAC;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SAMOFACOIGDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 04-11-2016 Created for OFAC Search Ended on 04-11-2016
 * 
 * @author Subhas.BV
 *
 */

public class UATOFACSearchTest002  extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Subhas.BV
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

		List listofdatafrm = lavanteUtils.login("Omnicare", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		

	}
	
	@BeforeMethod
	public void before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Risks");
		dataMap.put("subtab", "manageOFACList");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}

	/**
	 * Verify the DB Count with UI for OFAC for All Status
	 * 
	 * @author Subhas.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of OFACPageValidationTC0001
	 */
	@Test(dataProvider = "DBCountOFAC", dataProviderClass = SAMOFACOIGDataProvider.class)
	public void OFACCountDBVerify(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for OFAC Count DB verify:" + currenttime());

		boolean flag = false;
		String url=driver.getCurrentUrl();
		enOFACdetails.fillSearch(dataMap);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(enOFACdetails.rcrdCount());
		String nwurl=driver.getCurrentUrl();
		//if(!url.equalsIgnoreCase(nwurl))
		{
			System.out.println("URL NOT MATCHED"+url+","+nwurl);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.fluentwait(enOFACdetails.rcrdCount());
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(enOFACdetails.rcrdCount()));
		}
			
		if (dataMap.containsKey("QUERY")) {
			String query = dataMap.get("QUERY");
			query = query.replace("AUTOCUSTOMERID", customerid);
			query = lavanteUtils.fetchDBdata(query);
			String count = enOFACdetails.rcrdCount().getText();
			String countOnly = count.substring(1, count.length() - 1);
			System.out.println(dataMap.get("FilterBY") + ",Count Match,Exp:" + query + ",Actuals:" + countOnly);
			Reporter.log(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:" + query	+ ",Actuals:" + countOnly);
			System.out.println(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:"+ query + ",Actuals:" + countOnly);
			Assert.assertTrue(Integer.parseInt(query) == Integer.parseInt(countOnly),dataMap.get("FilterBY") + ",Count Not Matched,Exp:" + query + ",Actuals:" + countOnly);
			flag = true;
		}
		if (flag == false) {
			Assert.assertTrue(false, "Please retet");
		}

		Reporter.log("Test Ended for SAM DB Count Verify at:" + currenttime());
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author Subhas.BV
	 */
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

	
}
