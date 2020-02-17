package com.lavante.sim.customer.TestScripts.UserRoles;

import java.util.LinkedHashMap;
import java.util.List;

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
 * Created on 07-09-2016 Created for Promo billing invoice deductions
 * 
 * @author Thejaswi
 * LATM-552
 * SIM-20596 Promo billing and Invoice Deduction search filters should be Kroger specific
 * 
 */
public class KrogerCustomerPropertyTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid="";
	String prop="";

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(
			@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		lavanteUtils.driver = driver;

		List listofdatafrm = lavanteUtils.login("Invoice", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		prop="SELECT CustomerPropertyID FROM CustomerProperty WHERE PropertyName = 'CUSTOMER_SPECIFIC_FIELDS'";
		prop=lavanteUtils.fetchDBdata(prop);
		
		String x="Select CustomerID from CustomerPropertyValue where CustomerID="+customerid
				+ " and CustomerPropertyID="+prop ;
		x=lavanteUtils.fetchDBdata(x);
		if(x==null){
			x="INSERT INTO CustomerPropertyValue(CustomerPropertyID,IsActive,CustomerID,PropertyValue, CreatedBy, CreatedOn) VALUES("+prop+", 1, "+customerid+",'HasDeduction,HasPromotion' ,'thejaswi',getUTCdate())";
			lavanteUtils.UpdateDB(x);
		}

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Invoice");
		dataMap.put("subtab", "InvoiceSearchResult");

		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		String activeQuery = "update CustomerPropertyValue SET IsActive = 1,PropertyValue='HasDeduction,HasPromotion' where CustomerID = "+customerid+ "and CustomerPropertyID ="+prop;
		lavanteUtils.UpdateDB(activeQuery);
		
	}
	
	/**
	 * Test case: Promo Billng and In voice Deduction search should be Kroger specific
	 * Setting Customer Property To Actvie and Verifying the field, and setting to inactive to see the field is hidden
	 * 
	 *  @author Thejaswi.Bhat 
	 */
	@Test
	public void PromoBillingFieldVisibility() 	throws Exception {
		
		Reporter.log("Test Started for Promo Billing and Associated Search:" + currenttime());
		SoftAssert softassert = new SoftAssert();
	
		boolean flag = lavanteUtils.isElementDisplayed(eninvoiceBasicSearch.PromoBillingsDropdown());
		softassert.assertTrue(flag, "Promo billing is Available");
		flag = lavanteUtils.isElementDisplayed(eninvoiceBasicSearch.AssociatedDeductionsDropdown());
		softassert.assertTrue(flag, "Associated Deduction is Available");
		
		//Inactive 
		String inactiveQuery = "Update CustomerPropertyValue set IsActive = 0 where CustomerID = "+customerid+" and CustomerPropertyID ="+prop;
		System.out.println(inactiveQuery);
		lavanteUtils.UpdateDB(inactiveQuery);
		
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(eninvoiceBasicSearch.Searchbtn());
		
		flag= lavanteUtils.isElementDisplayed(eninvoiceBasicSearch.PromoBillingsDropdown());
		softassert.assertFalse(flag, "Promo billing is Not Available");
		flag = lavanteUtils.isElementDisplayed(eninvoiceBasicSearch.AssociatedDeductionsDropdown());
		softassert.assertFalse(flag, "Associated Deduction is Not Available");
		
		
	    String deleteQuery=	"delete CustomerPropertyValue where CustomerID = (SELECT CustomerID FROM Customer WHERE Name = 'GP Strategies') and CustomerPropertyID=(select CustomerPropertyID from CustomerProperty where PropertyName like '%CUSTOMER_SPECIFIC_FIEL%')";
		UpdateDB(deleteQuery);
		softassert.assertAll();
		Reporter.log("Test Ended for Promo Billing and Associated Search:" + currenttime());

	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}


}
