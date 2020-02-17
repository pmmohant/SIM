package com.lavante.sim.customer.TestScripts.Compliance.LegalID;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ManageUsers;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SAMOFACOIGDataProvider;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 21-11-2016 Created for Verifying LegalID count from DB
 * 
 * @author Subhash.BV
 *
 */

public class UATLegalIDDBCount extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = null;

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
		List listofdatafrm = lavanteUtils.login("Discovery", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod
	public void BeforeMEthod(){
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		dataMap.put("maintab", "Risks");
		dataMap.put("subtab", "customerSupplierLegalID");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * 
	 * Method Name : validate LegalID
	 * 
	 * @author Subhash.BV
	 * @throws IOException
	 */
	@Test(dataProvider = "DBCountLegalID", dataProviderClass = SAMOFACOIGDataProvider.class)
	public void legalIdVerificationTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for legalId Count Test:" + currenttime(),true);
		
		boolean flag = false;
		String countOnly = null;
		String url=driver.getCurrentUrl();
		enobjLegalID.fillSearch(dataMap);
		
		lavanteUtils.waitForTime(4000);
		lavanteUtils.waitforPageload(enobjLegalID.searchtxt());
		lavanteUtils.fluentwait(enobjLegalID.rcrdCount());
		String nwurl=driver.getCurrentUrl();
		//if(!url.equalsIgnoreCase(nwurl))
		{
			System.out.println("URL NOT MATCHED"+url+","+nwurl);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.fluentwait(enobjLegalID.rcrdCount());
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(enobjLegalID.rcrdCount()));
		}
		
		if (dataMap.containsKey("QUERY")) {
			String query = dataMap.get("QUERY");
			query = query.replace("AUTOCUSTOMERID", customerid);
			query = lavanteUtils.fetchDBdata(query);
			String count = enobjLegalID.rcrdCount().getText();
			countOnly = count.substring(1, count.length() - 1);
			System.out.println(dataMap.get("FilterBY") + ",Count Match,Exp:" + query + ",Actuals:" + countOnly);
			Reporter.log(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:" + query	+ ",Actuals:" + countOnly);
			System.out.println(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:"+ query + ",Actuals:" + countOnly);
			Assert.assertTrue(Integer.parseInt(query) == Integer.parseInt(countOnly),dataMap.get("FilterBY") + ",Count Not Matched,Exp:" + query + ",Actuals:" + countOnly);
			flag = true;
		}
		if (!dataMap.get("FilterBY").equalsIgnoreCase("All") && dataMap.get("ShowInactive").equalsIgnoreCase("NO")) {
			dataMap.put("maintab", "customerDashboard");
			dataMap.put("subtab", "customerUSPSValidationDashboard");
			enobjhomePage.selectTab(dataMap);
			objRegulatoryCompliance.selectCountryInLegalIdAuthentication(dataMap);
			dataMap.put("LegalIDAuthentication", "");
			dataMap.put("SelectChart", "table");
			objRegulatoryCompliance.selectChartCategory(dataMap);
			int value = objRegulatoryCompliance.getValueFromLegalIdAuthentication(dataMap.get("FilterSub"));
			System.out.println(	dataMap.get("FilterBY") + ",Count Match,Exp:" + value + ",Actuals:" + Integer.parseInt(countOnly));
			Reporter.log(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:" + value	+ ",Actuals:" + Integer.parseInt(countOnly));
			System.out.println(dataMap.get("FilterBY") + " " + dataMap.get("ShowInactive") + ",Count Match ,Exp:"	+ value + ",Actuals:" + Integer.parseInt(countOnly));
			Assert.assertTrue(value == Integer.parseInt(countOnly),dataMap.get("FilterBY") + ",Count Not Matched,Exp:" + value + ",Actuals:" + countOnly);
			flag = true;
		}

		if (flag == false) {
			Assert.assertTrue(false, "Please retet");
		}
		System.out.println("-----------Test Ended for Legal ID Count---------------");
		Reporter.log("Test Ended at:" + currenttime());
	}

	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
