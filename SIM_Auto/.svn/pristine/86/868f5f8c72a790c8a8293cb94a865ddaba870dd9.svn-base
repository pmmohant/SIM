package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 1-12-2016 Created for verify LaunchWizardW8W9 buttons
 * 
 * @author Subhash.BV
 *
 */

public class UIW8W9VerificationAdminLogin extends PageInitiator {

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
		List listofdatafrm = lavanteUtils.login("Sanity", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();


	}
	
	/**
	 * SIM-9679 Enable upload button for support user
	 * 
	 * @throws IOException
	 * @author Subhas.BV
	 */
	@Test
	public void verifyLaunchW9WizardButtonAdminLoginTest() throws Exception {
		Reporter.log("Test Started for verifyLaunchW9WizardButtonTest:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		String query="update Customer Set IsW8Enabled=1 , IsW9Enabled=1 where CustomerID="+customerid;
		lavanteUtils.UpdateDB(query);
		
		dataMap.put("Tab", "Legal");
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String sup=enobjsupplierPage.VerifyPendingWith();
		dataMap.put("supplierName",sup);
		
		Reporter.log("Supplier Selected for:"+sup);
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);
		boolean flag = false;
		if (lavanteUtils.isElementDisplayed(eneditLegal.W9LaunchWizardBtn())) {
			flag = true;
		}
		Reporter.log(" Launch W-9 Wizard verifed, Expected: true, Actual:" + flag);
		Assert.assertTrue(flag, " Launch W-9 Wizard verification Failed/Not Present , Expected: true, Actual:" + flag);

		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * SIM-9679 Enable upload button for support user
	 * 
	 * @throws IOException
	 * @author Subhas.BV
	 */
	@Test
	public void verifyLaunchW8WizardButtonAdminLoginTest() throws Exception {
		Reporter.log("Test Started for verifyLaunchW9WizardButtonTest:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		String query="update Customer Set IsW8Enabled=1 , IsW9Enabled=1 where CustomerID="+customerid;
		lavanteUtils.UpdateDB(query);
		dataMap.put("Tab", "Legal");
		dataMap.put("RegCountry", "Not Equal To,United States");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String sup=enobjsupplierPage.VerifyPendingWith();
		dataMap.put("supplierName",sup);
		
		Reporter.log("Supplier Selected for:"+sup);
		
		sup=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		Reporter.log("In Edit Profile of "+sup);
		
		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		boolean flag = false;
		if (lavanteUtils.isElementDisplayed(eneditCustomerProfile.W8LaunchWizardBtn())) {
			flag = true;
		}
		
		Reporter.log(" Launch W-8 Wizard verifed, Expected: true, Actual:" + flag);
		Assert.assertTrue(flag, " Launch W-8 Wizard verification Failed/Not Present , Expected: true, Actual:" + flag);

		
		Reporter.log("Test Ended at:" + currenttime());
	}

	@AfterMethod()
	public void das() throws FileNotFoundException, IOException, SQLException{
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);
		
		String query="update Customer Set IsW8Enabled=0,IsW9Enabled=0 where CustomerID="+customerid;
		lavanteUtils.UpdateDB(query);
	}
	
	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
