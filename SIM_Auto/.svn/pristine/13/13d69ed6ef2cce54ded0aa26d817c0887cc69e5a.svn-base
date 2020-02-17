package com.lavante.sim.customer.TestScripts.Compliance.SAM;

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
 * Created on 28-10-2016 Created for SAM Search Ended on 28-10-2016
 * 
 * @author Piramanayagam.S
 *
 */
public class UATSAMSearchTest002 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
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
	public void BeforeMethod(){
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<>();
		LdataMap.put("maintab", "Risks");
		LdataMap.put("subtab", "customerSAM");
		enobjhomePage.selectTab(LdataMap);

		lavanteUtils.waitForTime(3000);

	}
	/**
	 * Verify the DB Count with UI for SAM for All Status
	 * 
	 * @author subhas
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of SAMPageValidationTC0001
	 */
	@Test(dataProvider = "DBCountSAM", dataProviderClass = SAMOFACOIGDataProvider.class)
	public void SAMCountDBVerify(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for SAM Count DB verify:" + currenttime()+dataMap,true);
		
		boolean flag = false;
		String url=driver.getCurrentUrl();
		enSAMdetails.fillSearch(dataMap);
		lavanteUtils.waitForTime(6000);
		lavanteUtils.fluentwait(enSAMdetails.rcrdCount());
		
		String nwurl=driver.getCurrentUrl();
		//if(!url.equalsIgnoreCase(nwurl))
		{
			System.out.println("URL NOT MATCHED"+url+","+nwurl);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.fluentwait(enSAMdetails.rcrdCount());
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(enSAMdetails.rcrdCount()));
		}
		lavanteUtils.waitforPageload(enSAMdetails.rcrdCount());
		if (dataMap.containsKey("FilterBY"))
		{
			String data = dataMap.get("FilterBY");
			 if (data.contains("Deactivated")) {
				 lavanteUtils.waitForTime(12000);
			}
		}
		if (dataMap.containsKey("QUERY")) {
			String query = dataMap.get("QUERY");
			query = query.replace("AUTOCUSTOMERID", customerid);
			query = lavanteUtils.fetchDBdata(query);
			String count = enSAMdetails.rcrdCount().getText();
			String countOnly = count.substring(1, count.length() - 1);
			Reporter.log(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:" + query	+ ",Actuals:" + countOnly);
			System.out.println(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:"+ query + ",Actuals:" + countOnly);
			Assert.assertTrue(Integer.parseInt(query) == Integer.parseInt(countOnly), dataMap.get("FilterBY") + ",Count Not Matched,Exp:" + query + ",Actuals:" + countOnly);
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
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
