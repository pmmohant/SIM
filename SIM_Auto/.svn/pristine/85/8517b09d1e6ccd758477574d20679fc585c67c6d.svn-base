package com.lavante.sim.customer.TestScripts.SupplierRegistration;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SupplierRegistration extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Srikanth
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
	/*	List<?> listofdatafrm = lavanteUtils.login("Omnicare", browser);
		
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);*/

	}

	/**
	 * Supplier Registration--Verify United Sates of America is selected by default
	 * @author Srikanth 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "ValidateErrorMessage", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void UIverifyRegistrationProcess(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Supplier Registration UI:" + currenttime());
		SoftAssert softAssert=new SoftAssert();
		
	/*	dataMap.put("invite", "");
		dataMap.put("checkconfirm", "");
		dataMap.put("nextbttn", "");
		dataMap.put("confirmChkBox", "");
		dataMap.put("accSetupnextBtn", "");

		String[] ns = enobjInvitenewSupplier.inviteNwSupp(dataMap);
	
		String url=lavanteUtils.navigatetoAccSetup(ns);
		
		objSimAccountSetupPage.accSetup(dataMap);*/
		driver.get("http://simdev.lavante.com:8080/sim/supplierRegistrationPage.lvp?/iNe/rwa6jQUDHhgMInlhuGtoybh90crtE/aCAw/cNCjB7N28ZuPBXXBdHRUfUC4gvwxsyLzCgtV9NHJVXDt8LQvyt4F3FQC+ZKAn5wkHx6jy450K7xAuEv6+NZS4cQBnMhuJD94gyA=");
		lavanteUtils.fluentwait(objSimAccountRegistrationPage.country());
		String expCountry = objSimAccountRegistrationPage.country().getText();
		String expW9formlabel = objSimAccountRegistrationPage.W9Label().getText();
		
		Reporter.log("In Registeration Page,Default Country:"+expCountry);
		softAssert.assertEquals(expCountry, "United States of America","In Registeration Page,Default Country USA not Matched");
		
		Reporter.log("US File Upload  Label:"+expW9formlabel);
		softAssert.assertEquals(expW9formlabel, "Upload W-9 Form","File Upload Not Matched");
		
		Reporter.log("US Source Income for US Country:"+objSimAccountRegistrationPage.USSourceIncome().size());
		softAssert.assertTrue(objSimAccountRegistrationPage.USSourceIncome().size()==0,"US Source Income is present for non-US Country");
		
		dataMap.put("country", "United Kingdom");
		dataMap.put("USIncomeOption", "YES");
		dataMap.put("VATNumber", "YES");
		objSimAccountRegistrationPage.fillRegisteration(dataMap);
		
			Reporter.log("VAT SIZE for non-US Country:"+objSimAccountRegistrationPage.VATNumber().size());				
			softAssert.assertTrue(objSimAccountRegistrationPage.VATNumber().size()>0,"VAT SIZE for Non-US Country");
			
			lavanteUtils.fluentwait(objSimAccountRegistrationPage.vatCountrylabel());
			String actVAtMSG = objSimAccountRegistrationPage.vatCountrylabel().getText();
			String actVATCountrymsg = "VAT Registration Number for ";
			String country = dataMap.get("country");
			String expVatMSG = actVATCountrymsg + country;
			
			Reporter.log("Label for non-US Country:"+expVatMSG);				
			softAssert.assertEquals(expVatMSG,actVAtMSG,"VAT Registration Number for country" + country + "is Not present");
		
			Reporter.log("US Source Income for non-US Country:"+objSimAccountRegistrationPage.NonUSSourceIncome().size());
			softAssert.assertTrue(objSimAccountRegistrationPage.NonUSSourceIncome().size()>0,"US Source Income is present for non-US Country");
			
			Reporter.log("Company Legal Name Non US :"+objSimAccountRegistrationPage.CompanyLegalNameNonUS().isDisplayed());				
			softAssert.assertTrue(objSimAccountRegistrationPage.CompanyLegalNameNonUS().isDisplayed(),"Company Legal Name Non US Not Present");
			
			Reporter.log("TIN Non US :"+objSimAccountRegistrationPage.tinNonUS().isDisplayed());				
			softAssert.assertTrue(objSimAccountRegistrationPage.tinNonUS().isDisplayed(),"TIN  Non US Not Present");
			
			dataMap.clear();
			dataMap.put("USIncomeOption", "No");
			objSimAccountRegistrationPage.fillRegisteration(dataMap);
				
			Reporter.log("Company Legal Name Non US :"+objSimAccountRegistrationPage.CompanyLegalNameNonUS().isDisplayed());				
			softAssert.assertFalse(objSimAccountRegistrationPage.CompanyLegalNameNonUS().isDisplayed(),"Company Legal Name  Non US Income NO  Present");
			
			Reporter.log("TIN Non US Income NO :"+objSimAccountRegistrationPage.tinNonUS().isDisplayed());				
			softAssert.assertFalse(objSimAccountRegistrationPage.tinNonUS().isDisplayed(),"TIN  Non US Income NO  Present");
				
			dataMap.put("country", "Algeria");
			dataMap.put("VATNumber", "YES");
			dataMap.put("VATOther", "Other");
			
			objSimAccountRegistrationPage.fillRegisteration(dataMap);
			
			Reporter.log("Legal ID /Tax ID for non-US Country:"+objSimAccountRegistrationPage.VATOther().size());				
			softAssert.assertTrue(objSimAccountRegistrationPage.VATOther().size()>0,"Legal ID /Tax ID for Non-US Country");
			
			lavanteUtils.fluentwait(objSimAccountRegistrationPage.ALLvatCountrylabel());
			 actVAtMSG = objSimAccountRegistrationPage.ALLvatCountrylabel().getText();
			 actVATCountrymsg = "Legal ID/Tax ID for ";
			 country = dataMap.get("country");
			 expVatMSG = actVATCountrymsg + country;
			
			Reporter.log("Label for non-US Country:"+actVAtMSG);				
			softAssert.assertEquals(expVatMSG,actVAtMSG,"VAT Registration Number for country" + country + "is Not present");
		
		softAssert.assertAll();
		Reporter.log("Test Ended for supplier Registration UI at:" + currenttime());	
	}
	

	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjInvitenewSupplier.cancel();
		quitBrowser();
	}
}