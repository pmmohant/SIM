package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class CompanyEthnicDiversity04 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String supName = null;

	/**
	 * SIM-12296, SIM-12192 and SIM-12377
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

		List listofdatafrm = lavanteUtils.login("Sanity", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	@BeforeMethod
	public void setup() throws Exception {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
	}

	/***
	 * SIM-12296 Support selection of multiple values for Ethnicity
	 * Search Ireland Supplier edit and verify ethnicity
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void validateEthnicityDropDwnTest() throws Exception {
		Reporter.log("------------Test Started for validateEthnicityDropDwnTest :"+ currenttime());
		SoftAssert softassert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("RegCountry", "Equals To,Ireland");
		dataMap.put("Search", "");
		dataMap.put("Tab","Legal");
		ensupplierAdvanced.buildQuery(dataMap);
		
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		supName=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);
		
		dataMap.put("MajorityOwnership", "United States");
		eneditCompanyProfile.fillCompanyAdditionalInfo(dataMap);

		dataMap.put("MinorityChkBox", "yes");
		eneditCompanyProfile.diversitySection(dataMap);

		List<String> ethnicitySelected = new ArrayList<String>();
		ethnicitySelected.add("Alaskan Native");
		ethnicitySelected.add("Caucasian");

		if (lavanteUtils.isElementPresent(eneditCompanyProfile.ClearEthnicityDropDwn())) {
			int sizeClear = eneditCompanyProfile.ClearEthnicityDropDwn().size();
			for (int i = 0; i < sizeClear; i++) {
				lavanteUtils.fluentwait(eneditCompanyProfile.ClearEthnicityDropDwn().get(0));
				lavanteUtils.click(eneditCompanyProfile.ClearEthnicityDropDwn().get(0));
			}
		}

		for (int i = 0; i < ethnicitySelected.size(); i++) {
			lavanteUtils.fluentwait(eneditCompanyProfile.EthnicityDropDwn());
			eneditCompanyProfile.EthnicityDropDwn().sendKeys(ethnicitySelected.get(i));
			lavanteUtils.click(eneditCompanyProfile.EthnicityDropDwn());
			lavanteUtils.selectvalueFrmDpdn(ethnicitySelected.get(i));
		}
		lavanteUtils.fluentwait(eneditCompanyProfile.EthnicityDropDwn());
		eneditCompanyProfile.EthnicityDropDwn().sendKeys("Other");
		lavanteUtils.click(eneditCompanyProfile.EthnicityDropDwn());
		lavanteUtils.selectvalueFrmDpdn("Other");

		String specifyEthnicity = "SpecifyEthnicity" + lavanteUtils.generateRandomNumber9OnLength(7);
		lavanteUtils.fluentwait(eneditCompanyProfile.SpecifyEthnicityTxtBox());
		eneditCompanyProfile.SpecifyEthnicityTxtBox().clear();
		lavanteUtils.typeinEdit(specifyEthnicity, eneditCompanyProfile.SpecifyEthnicityTxtBox());

		dataMap.clear();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supName);

		lavanteUtils.fluentwait(enviewSupplier.GetEthnicityInfo());
		String getEthnicityInfo = lavanteUtils.getText(enviewSupplier.GetEthnicityInfo());

		String getSelectedEthnicity[] = getEthnicityInfo.split(",");
		List<String> actualEthnicitySelected = new ArrayList<String>();
		String specificEth = null;
		for (int i = 0; i < getSelectedEthnicity.length; i++) {

			if (!getSelectedEthnicity[i].contains("Other")) {
				actualEthnicitySelected.add(getSelectedEthnicity[i]);
			} else {
				specificEth = getSelectedEthnicity[i];
			}
		}

		boolean flag = false;
		for (int i = 0; i < ethnicitySelected.size(); i++) {
			if (ethnicitySelected.get(i).equals(actualEthnicitySelected.get(0))
					|| ethnicitySelected.get(i).equals(actualEthnicitySelected.get(1))) {
				flag = true;
			} else {
				flag = false;
			}
		}

		Reporter.log(" Verification selection of multiple values for Ethnicity Expected," + ethnicitySelected+ " Other, " + specifyEthnicity + " Actual, " + getEthnicityInfo);
		softassert.assertTrue(flag, " Verification selection of multiple values for Ethnicity failed,  Expected,"+ ethnicitySelected + " Other, " + specifyEthnicity + " Actual, " + getEthnicityInfo);

		flag = false;
		if (specifyEthnicity.equals(specificEth.split("-")[1])) {
			flag = true;
		}

		Reporter.log(" Verification Specific Ethnicity Expected," + specifyEthnicity + " Actual, " + specificEth);
		softassert.assertTrue(flag,	" Verification Specific Ethnicity Expected," + specifyEthnicity + " Actual, " + specificEth);

		softassert.assertAll();

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("------------Test ended for validateEthnicityDropDwnTest -------------------"	+ currenttime());
	}

	/***
	 * SIM-12192 Provide "Country" Selection Option for "Majority Ownership"
	 * Field in Core Profile
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void validateMajorityOwnershipDropDwnTest() throws Exception {
		Reporter.log("----Test Started for validateMajorityOwnershipDropDwnTest :"+ currenttime());

		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("RegCountry", "Is Empty");
		dataMap.put("Search", "");
		dataMap.put("ProfStatus","Pending Validation");
		dataMap.put("Tab","Legal#Enterprise");
		
		ensupplierAdvanced.buildQuery(dataMap);	
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		supName=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);
		
/*		lavanteUtils.fluentwait(eneditCompanyProfile.EditCountryOfRegi());
		if (lavanteUtils.isElementDisplayed(eneditCompanyProfile.EditCountryOfRegi())) {
			lavanteUtils.click(eneditCompanyProfile.EditCountryOfRegi());
		}*/
		lavanteUtils.clicks(eneditCompanyProfile.CountryOfRegiDropDwn());
		String getValue = null;
		List<String> valuesCOR = new ArrayList<>();
		List<WebElement> el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
		for (int i = 0; i < el.size(); i++) {
			getValue = lavanteUtils.getText(el.get(i));
			valuesCOR.add(getValue);
		}

		lavanteUtils.selectFrmDpdn("Canada");
		lavanteUtils.waitforPageload(eneditCompanyProfile.MajorityOwnershipDropDwn());
		lavanteUtils.fluentwait(eneditCompanyProfile.MajorityOwnershipDropDwn());
		lavanteUtils.clicks(eneditCompanyProfile.MajorityOwnershipDropDwn());

		List<String> valuesMajorityOwnnership = new ArrayList<>();
		el = driver.findElements(By.cssSelector("div[class*='drop'] li"));
		for (int i = 0; i < el.size(); i++) {
			getValue = lavanteUtils.getText(el.get(i));
			valuesMajorityOwnnership.add(getValue);
		}

		lavanteUtils.selectFrmDpdn("United States");
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		if (valuesCOR.containsAll(valuesMajorityOwnnership)) {
			flag = true;
		}

		Reporter.log(" Verify country of registration and majority ownership drop down as same list of countries, COR : "	+ valuesCOR + " ,Majoriy Ownership : " + valuesMajorityOwnnership);
		softAssert.assertTrue(flag," Verification failed country of registration and majority ownership drop down as different list of countries, COR : "	+ valuesCOR + " ,Majoriy Ownership : " + valuesMajorityOwnnership);

		if (isElementDisplayed(eneditCompanyProfile.DiverseDisadBusinessYesRadioBtn())&& isElementDisplayed(eneditCompanyProfile.DiverseDisadBusinessNoRadioBtn())) {
			flag = true;
		}

		Reporter.log(" Verification Your Company's Diversity Information section appeared only while United States is selected as country for Majority Ownership ");
		softAssert.assertTrue(flag," Verification Your Company's Diversity Information section appeared only while United States is selected as country for Majority Ownership");

		flag = false;
		lavanteUtils.fluentwait(eneditCompanyProfile.MajorityOwnershipDropDwn());
		lavanteUtils.clicks(eneditCompanyProfile.MajorityOwnershipDropDwn());
		lavanteUtils.selectFrmDpdn("Zambia");
		lavanteUtils.fluentwait(eneditCompanyProfile.GetConfirmPopUpMsg());
		String expectedMsg = "Changing Majority Ownership will result in the loss of Diversity Information, Minority and Small Business certification. Would you like to continue changing majority Ownership country?";
		String actualMsg = lavanteUtils.getText(eneditCompanyProfile.GetConfirmPopUpMsg());

		Reporter.log(" Verify by changing United States from Majority Ownership drop-down to other country, the Msg displayed is, Actual-Msg, "	+ actualMsg + " ,Expected-Msg, " + expectedMsg);
		softAssert.assertEquals(actualMsg, expectedMsg," Verify by changing United States from Majority Ownership drop-down to other country, the Msg displayed is, Actual-Msg, "+ actualMsg + " ,Expected-Msg, " + expectedMsg);
		softAssert.assertAll();

		Reporter.log("------------Test ended for validateMajorityOwnershipDropDwnTest --"+ currenttime());
	}

	/***
	 * SIM-12377 Exchange Traded On should be a selection list Field in Core
	 * Profile
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void validateExchangeTradedOnDropDwnTest() throws Exception {
		Reporter.log("------------Test Started for validateExchangeTradedOnDropDwnTest ------"	+ currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("RegCountry", "Equals To,Ireland");
		dataMap.put("Search", "");
		dataMap.put("Tab","Legal");
		ensupplierAdvanced.buildQuery(dataMap);	
		
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		supName=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);
		
		List<String> exchangeTradedOnSelect = new ArrayList<String>();
		exchangeTradedOnSelect.add("SIX Swiss Exchange");
		exchangeTradedOnSelect.add("NASDAQ");
		exchangeTradedOnSelect.add("Euronext");

		lavanteUtils.fluentwait(eneditCompanyProfile.PubliclyTradedYesRadioBtn());
		lavanteUtils.click(eneditCompanyProfile.PubliclyTradedYesRadioBtn());
		lavanteUtils.fluentwait(eneditCompanyProfile.ExchangeTradedOnDropDwn());
		lavanteUtils.click(eneditCompanyProfile.ExchangeTradedOnDropDwn());
		if (lavanteUtils.isElementPresent(eneditCompanyProfile.ClearExchangeTradedOnDropDwn())) {
			int sizeClear = eneditCompanyProfile.ClearExchangeTradedOnDropDwn().size();
			for (int i = 0; i < sizeClear; i++) {
				lavanteUtils.fluentwait(eneditCompanyProfile.ClearExchangeTradedOnDropDwn().get(0));
				lavanteUtils.click(eneditCompanyProfile.ClearExchangeTradedOnDropDwn().get(0));
			}
		}

		for (int i = 0; i < exchangeTradedOnSelect.size(); i++) {
			lavanteUtils.fluentwait(eneditCompanyProfile.ExchangeTradedOnDropDwn());
			lavanteUtils.click(eneditCompanyProfile.ExchangeTradedOnDropDwn());
			lavanteUtils.selectvalueFrmDpdn(exchangeTradedOnSelect.get(i));
		}

		dataMap.clear();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supName);

		lavanteUtils.fluentwait(enviewSupplier.GetExchangeTradedOnInfo());
		boolean flag = false;
		String getExchangeTradedOnInfo = lavanteUtils.getText(enviewSupplier.GetExchangeTradedOnInfo());
		String getSelectedExchangeTradedOn[] = getExchangeTradedOnInfo.split(",");
		Set<String> options = new LinkedHashSet<>();
		for (String getValue : getSelectedExchangeTradedOn) {
			options.add(getValue.trim());
		}
		for (String getValue : exchangeTradedOnSelect) {
			options.add(getValue.trim());
		}

		if (options.size() == 3) {
			flag = true;
		}

		Reporter.log(" Verification of Exchange Traded on MultiSelect drop down, Expected," + exchangeTradedOnSelect	+ " Actual, " + getSelectedExchangeTradedOn);
		Assert.assertTrue(flag, " Verification of Exchange Traded on MultiSelect drop down, Expected," + exchangeTradedOnSelect+ " Actual, " + getSelectedExchangeTradedOn);
		
		Reporter.log("------------Test ended for validateExchangeTradedOnDropDwnTest -------------------"	+ currenttime());
	}
	
	@AfterMethod
	public void aftermethod(){
		refreshPage();
		enobjhomePage.backtoSearch();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<>();
		 dataMap.put("EditCancel", "");
		 eneditProfile.formAction(dataMap);
	}

	@AfterClass
	public void close() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
