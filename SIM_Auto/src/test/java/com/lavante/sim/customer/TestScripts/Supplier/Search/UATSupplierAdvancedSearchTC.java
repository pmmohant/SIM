package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
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
import com.lavante.sim.Common.Util.Report;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 24-11-2016 Created for Supplier Advanced Search Filter Test
 * Scenarios Enhancement covered SIM-9128 Ended on 24-11-2016
 * 
 * @author Piramanayagam.S
 *
 */
public class UATSupplierAdvancedSearchTC extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = "";

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

		List listofdatafrm = lavanteUtils.login("Search-Tax", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	@BeforeMethod
	public void before() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);

	}

	/**
	 * UI Verification in Build Query Popup
	 * 
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void UIFilterVerifyBuildPopup001() throws Exception {
		System.out.println("------------Test Started for UI Filter Verify-------------------");
		Reporter.log("Test Started for UI Filter Verify on Advanced  Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		lavanteUtils.click(ensupplierAdvanced.advtab());

		fluentwait(ensupplierAdvanced.buildqrybtn());
		click(ensupplierAdvanced.buildqrybtn());
		lavanteUtils.switchtoFrame(ensupplierAdvanced.IFRAMEBuildQry());

		System.out.println("Filter All Display,Status:" + lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterAll()));
		Reporter.log("Filter All Display,Status:" + lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterAll()));
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterAll()),	" Filter All display 		Status:" + ensupplierAdvanced.filterAll().isDisplayed());

		System.out.println("Filter ANY Display,Status:" + lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterANY()));
		Reporter.log("Filter ANY Display,Status:" + lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterANY()));
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterANY()),	" Filter Any Display Status:" + ensupplierAdvanced.filterANY().isDisplayed());

		System.out.println("Filter All Selection,Status:" + lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterAll()));
		Reporter.log("Filter All Selection,Status:" + lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterAll()));
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(ensupplierAdvanced.filterAll()),	" Filter All Selection Status:" + ensupplierAdvanced.filterAll().isSelected());

		softAssert.assertAll();

		System.out.println("------------Test Ended for UI Filter Verify-------------------");
		Reporter.log("Test Ended for UI Filter Verify on Advanced  Search:" + currenttime());
	}

	/**
	 * Do a Combi search on Any Filter
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AnyCombiSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void ANYCombiSearch002(LinkedHashMap<String, String> dataMap) throws Exception {
		System.out.println("------------Test Started for Combi Any Search-------------------");
		Reporter.log("Test Started for Any Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");
		dataMap.put("filterANY", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enobjsupplierPage.searchResultsFilterBy("ALL");
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			boolean flag1 = false;

			do {

				String y = dataMap.get("FAX");
				String[] split2 = ensupplierAdvanced.SplitSearchdata(y);

				lavanteUtils.fluentwait(enviewSupplier.CoresupplierFax());
				String suppname = enviewSupplier.supplierName().getAttribute("title");
				String fax = enviewSupplier.CoresupplierFax().getText();
				if (fax.contains(split2[1])) {
					System.out
							.println(suppname + ",Supplier data,Fax  ,Expected:" + split2[1] + ", Value,in app:" + fax);
					Reporter.log(suppname + ",Supplier data,Fax ,Expected:" + split2[1] + ", Value,in app:" + fax);
					softAssert.assertTrue(fax.contains(split2[1]),
							suppname + "Result Not Matched,Please Retest:" + fax + ",In app:" + split2[1]);
					flag = true;
				}
				String x = dataMap.get("CountryAddress");
				String[] split = ensupplierAdvanced.SplitSearchdata(x);

				for (int jk = 0; jk < enviewSupplier.Listcntactaddress1().size(); jk++) {
					String addressType = enviewSupplier.Listcntactaddress1().get(jk).getText();
					if (addressType.contains(split[1])) {
						System.out.println(suppname + ",Supplier data,Country ,Expected:" + split[1] + ", Value,in app:"
								+ addressType);
						Reporter.log(suppname + ",Supplier data,Country,Expected:" + split[1] + ", Value,in app:"
								+ addressType);
						softAssert.assertTrue(addressType.contains(split[1]),
								suppname + "Result Not Matched,Please Retest:" + x + ",In app:" + addressType);
						flag1 = true;
					}
					if (flag == true && flag1 == true) {
						break;
					}
				}
				if (flag != true || flag1 != true) {
					if (enobjhomePage.nextSupp().size() > 0) {
						lavanteUtils.click(enobjhomePage.nextSupp().get(0));
					} else {
						break;
					}
				}

			} while (flag != true || flag1 != true);

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertFalse(true);
		}

		if (flag == false) {
			softAssert.assertTrue(false, "DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}

		softAssert.assertAll();

		System.out.println("------------Test Ended for Combi All Search-------------------");
	}

	/**
	 * Do a Combi search on ALL Filter
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AllCombiSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void AllCombiSearch003(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			boolean flag1 = false;

			String y = dataMap.get("FAX");
			String[] split2 = ensupplierAdvanced.SplitSearchdata(y);

			lavanteUtils.fluentwait(enviewSupplier.CoresupplierFax());
			String suppname = enviewSupplier.supplierName().getAttribute("title");
			String fax = enviewSupplier.CoresupplierFax().getText();
			if (fax.contains(split2[1])) {
				System.out.println(suppname + ",Supplier data,Fax  ,Expected:" + split2[1] + ", Value,in app:" + fax);
				Reporter.log(suppname + ",Supplier data,Fax ,Expected:" + split2[1] + ", Value,in app:" + fax);
				softAssert.assertTrue(fax.contains(split2[1]),
						suppname + "Result Not Matched,Please Retest:" + fax + ",In app:" + split2[1]);
				flag = true;
			}
			String x = dataMap.get("CountryAddress");
			String[] split = ensupplierAdvanced.SplitSearchdata(x);

			for (int jk = 0; jk < enviewSupplier.Listcntactaddress1().size(); jk++) {
				String addressType = enviewSupplier.Listcntactaddress1().get(jk).getText();
				if (addressType.contains(split[1])) {
					System.out.println(suppname + ",Supplier data,Country ,Expected:" + split[1] + ", Value,in app:"
							+ addressType);
					Reporter.log(
							suppname + ",Supplier data,Country,Expected:" + split[1] + ", Value,in app:" + addressType);
					softAssert.assertTrue(addressType.contains(split[1]),
							suppname + "Result Not Matched,Please Retest:" + x + ",In app:" + addressType);
					flag1 = true;
					if (flag == true && flag1 == true) {
						break;
					}
				}

			}

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(false);
		}

		softAssert.assertAll();

		System.out.println("------------Test Ended for Combi All Search-------------------");
	}

	/**
	 * Do a Combi search on Any Filter and Save the query Run the query verify
	 * the result data
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AnyCombiSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void SaveANYCombiSearch004(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Any Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		String query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="
				+ customerID;
		lavanteUtils.UpdateDB(query);

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("filterANY", "");

		String qname = "AutoSP" + randomnum();

		dataMap.put("SaveQuery", "");
		dataMap.put("saveqryname", qname);
		dataMap.put("SavetheQuery", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(null);

		lavanteUtils.click(ensupplierAdvanced.formClearbtn());

		dataMap.put("RunQuery", "");
		ensupplierAdvanced.ActionForSavedQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			boolean flag1 = false;

			do {

				String y = dataMap.get("FAX");
				String[] split2 = ensupplierAdvanced.SplitSearchdata(y);

				lavanteUtils.fluentwait(enviewSupplier.CoresupplierFax());
				String suppname = enviewSupplier.supplierName().getAttribute("title");
				String fax = enviewSupplier.CoresupplierFax().getText();
				if (fax.contains(split2[1])) {
					Reporter.log(suppname + ",Supplier data,Fax ,Expected:" + split2[1] + ", Value,in app:" + fax);
					softAssert.assertTrue(fax.contains(split2[1]),	suppname + "Result Not Matched,Please Retest:" + fax + ",In app:" + split2[1]);
					flag = true;
				}
				String x = dataMap.get("CountryAddress");
				String[] split = ensupplierAdvanced.SplitSearchdata(x);

				for (int jk = 0; jk < enviewSupplier.Listcntactaddress1().size(); jk++) {
					String addressType = enviewSupplier.Listcntactaddress1().get(jk).getText();
					if (addressType.contains(split[1])) {
						Reporter.log(suppname + ",Supplier data,Country,Expected:" + split[1] + ", Value,in app:"			+ addressType);
						softAssert.assertTrue(addressType.contains(split[1]),		suppname + "Result Not Matched,Please Retest:" + x + ",In app:" + addressType);
						flag1 = true;
					}
					if (flag == true && flag1 == true) {
						break;
					}
				}
				if (flag != true || flag1 != true) {
					if (enobjhomePage.nextSupp().size() > 0) {
						lavanteUtils.click(enobjhomePage.nextSupp().get(0));
					} else {
						break;
					}
				}

			} while (flag != true || flag1 != true);

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertFalse(true);
		}

		enobjhomePage.backtoSearch();

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.remove("RunQuery");
		dataMap.put("OpenQuery", "");
		ensupplierAdvanced.ActionForSavedQuery(dataMap);

		Reporter.log("Query Popup" + qname);
		String actqname = ensupplierAdvanced.QueryPopupQname().getText();
		Reporter.log("Query Name,Saved,,Expected," + qname + "Actual:" + actqname);
		softAssert.assertEquals(actqname, qname, "Query Name Not Matched:" + actqname);

		String actqcriteria = ensupplierAdvanced.QueryPopupQCriteria().getText();
		Reporter.log("Query Criteria Saved,ExP:ANY,Actual:" + actqcriteria);
		softAssert.assertTrue(actqcriteria.contains("ANY"), "Query Criteria Not Matched:");

		query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="		+ customerID;
		lavanteUtils.UpdateDB(query);

		if (flag == false) {
			softAssert.assertTrue(false, "DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}

		softAssert.assertAll();

		Reporter.log("------------Test Ended for Combi Save Any Search-----"+currenttime());
	}

	/**
	 * Do a Combi search on ALL Filter and save the query Run the query and
	 * verify the data
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AllCombiSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void SaveAllCombiSearch005(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		String query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="+ customerID;
		lavanteUtils.UpdateDB(query);

		lavanteUtils.refreshPage();

		lavanteUtils.click(ensupplierAdvanced.advtab());

		String qname = "AutoSP" + randomnum();

		dataMap.put("SaveQuery", "");
		dataMap.put("saveqryname", qname);
		dataMap.put("SavetheQuery", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(null);

		lavanteUtils.click(ensupplierAdvanced.formClearbtn());

		dataMap.put("RunQuery", "");
		ensupplierAdvanced.ActionForSavedQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			boolean flag1 = false;

			String y = dataMap.get("FAX");
			String[] split2 = ensupplierAdvanced.SplitSearchdata(y);

			lavanteUtils.fluentwait(enviewSupplier.CoresupplierFax());
			String suppname = enviewSupplier.supplierName().getAttribute("title");
			String fax = enviewSupplier.CoresupplierFax().getText();
			if (fax.contains(split2[1])) {
				Reporter.log(suppname + ",Supplier data,Fax ,Expected:" + split2[1] + ", Value,in app:" + fax);
				softAssert.assertTrue(fax.contains(split2[1]),		suppname + "Result Not Matched,Please Retest:" + fax + ",In app:" + split2[1]);
				flag = true;
			}
			String x = dataMap.get("CountryAddress");
			String[] split = ensupplierAdvanced.SplitSearchdata(x);

			for (int jk = 0; jk < enviewSupplier.Listcntactaddress1().size(); jk++) {
				String addressType = enviewSupplier.Listcntactaddress1().get(jk).getText();
				if (addressType.contains(split[1])) {
					Reporter.log(suppname + ",Supplier data,Country,Expected:" + split[1] + ", Value,in app:" + addressType);
					softAssert.assertTrue(addressType.contains(split[1]),	suppname + "Result Not Matched,Please Retest:" + x + ",In app:" + addressType);
					flag1 = true;
					if (flag == true && flag1 == true) {
						break;
					}
				}

			}

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(false);
		}

		enobjhomePage.backtoSearch();
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		dataMap.remove("RunQuery");
		dataMap.put("OpenQuery", "");
		ensupplierAdvanced.ActionForSavedQuery(dataMap);
		
		Reporter.log("Query Popup" + qname);
		String actqname = ensupplierAdvanced.QueryPopupQname().getText();
		Reporter.log("Query Name,Saved,,Expected," + qname + "Actual:" + actqname);
		softAssert.assertEquals(actqname, qname, "Query Name Not Matched:" + actqname);

		String actqcriteria = ensupplierAdvanced.QueryPopupQCriteria().getText();
		Reporter.log("Query Criteria Saved," + qname + "Actual:" + actqcriteria);
		softAssert.assertTrue(actqcriteria.contains("ALL"), "Query Criteria Not Matched:");

		query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="
				+ customerID;
		lavanteUtils.UpdateDB(query);

		softAssert.assertAll();

		Reporter.log("------------Test Ended for Combi Save All Search-------------------"+currenttime());
	}

	/**
	 * Do a Combi search on Any Filter and Save the query Run the query verify
	 * the result data
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AllCombiSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void EditANYtoAllCombiSearch006(LinkedHashMap<String, String> dataMap) throws Exception {
		System.out.println("------------Test Started for Combi Edit ALL to  Any Search-------------------");
		Reporter.log("Test Started for Edit All to Any Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		String query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="+ customerID;
		lavanteUtils.UpdateDB(query);

		String y = dataMap.get("FAX");
		String[] split2 = ensupplierAdvanced.SplitSearchdata(y);

		String x = dataMap.get("CountryAddress");
		String[] split = ensupplierAdvanced.SplitSearchdata(x);

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("filterANY", "");

		String qname = "AutoSP" + randomnum();

		dataMap.put("SaveQuery", "");
		dataMap.put("saveqryname", qname);
		dataMap.put("SavetheQuery", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		String basiccount = enobjsupplierBasicSearch.searchcount().getText();
		String countBasic = "";
		if (basiccount.contains("(")) {
			String[] count = basiccount.split("\\(");

			String[] counts = count[1].split("\\)");
			countBasic = counts[0];
		}

		lavanteUtils.switchtoFrame(null);

		lavanteUtils.click(ensupplierAdvanced.formClearbtn());

		dataMap.put("EditQuery", "");
		ensupplierAdvanced.ActionForSavedQuery(dataMap);
		
		qname = qname+"New";
		dataMap.remove("filterANY");
		dataMap.put("filterAll", "");
		dataMap.put("saveqryname", qname);
		dataMap.put("SaveQuery", "");
		dataMap.put("SavetheQuery", "");

		ensupplierAdvanced.fillDetails(dataMap);
		ensupplierAdvanced.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		basiccount = enobjsupplierBasicSearch.searchcount().getText();
		String countadv = "";
		if (basiccount.contains("(")) {
			String[] count = basiccount.split("\\(");

			String[] counts = count[1].split("\\)");
			countBasic = counts[0];
		}

		System.out.println("Count Comparision,Expected:" + countadv + ",in app:" + countBasic);
		Reporter.log("Count Comparision,,Expected:" + countadv + ",in app:" + countBasic);
		softAssert.assertNotEquals(countBasic, countadv, " Basic Search");

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			boolean flag1 = false;

			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enviewSupplier.CoresupplierFax());
			String suppname = enviewSupplier.supplierName().getAttribute("title");
			String fax = enviewSupplier.CoresupplierFax().getText();
			if (fax.contains(split2[1])) {
				Reporter.log(suppname + ",Supplier data,Fax ,Expected:" + split2[1] + ", Value,in app:" + fax);
				softAssert.assertTrue(fax.contains(split2[1]),
						suppname + "Result Not Matched,Please Retest:" + fax + ",In app:" + split2[1]);
				flag = true;
			}

			for (int jk = 0; jk < enviewSupplier.Listcntactaddress1().size(); jk++) {
				String addressType = enviewSupplier.Listcntactaddress1().get(jk).getText();
				if (addressType.contains(split[1])) {
					Reporter.log(	suppname + ",Supplier data,Country,Expected:" + split[1] + ", Value,in app:" + addressType);
					softAssert.assertTrue(addressType.contains(split[1]),	suppname + "Result Not Matched,Please Retest:" + x + ",In app:" + addressType);
					flag1 = true;
					if (flag == true && flag1 == true) {
						break;
					}
				}

			}

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertFalse(true);
		}

		if (flag == false) {
			softAssert.assertTrue(false, "DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}

		query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="
				+ customerID;
		lavanteUtils.UpdateDB(query);

		softAssert.assertAll();

		Reporter.log("------------Test Ended for Combi Edit ALL to  Any Search-------------------");
	}

	/**
	 * Do a Combi search on Any Filter and Save the query Run the query verify
	 * the result data
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AnyCombiSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void EditAlltoANYCombiSearch007(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Edit All to Any Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		String query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="+ customerID;
		lavanteUtils.UpdateDB(query);

		lavanteUtils.click(ensupplierAdvanced.advtab());

		String y = dataMap.get("FAX");
		String[] split2 = ensupplierAdvanced.SplitSearchdata(y);

		String x = dataMap.get("CountryAddress");
		String[] split = ensupplierAdvanced.SplitSearchdata(x);

		String qname = "AutoSP" + randomnum();

		dataMap.put("SaveQuery", "");
		dataMap.put("saveqryname", qname);
		dataMap.put("SavetheQuery", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		String basiccount = enobjsupplierBasicSearch.searchcount().getText();
		String countBasic = "";
		if (basiccount.contains("(")) {
			String[] count = basiccount.split("\\(");

			String[] counts = count[1].split("\\)");
			countBasic = counts[0];
		}

		lavanteUtils.switchtoFrame(null);

		lavanteUtils.click(ensupplierAdvanced.formClearbtn());

		dataMap.put("EditQuery", "");
		ensupplierAdvanced.ActionForSavedQuery(dataMap);

		dataMap.clear();
		dataMap.put("filterANY", "");
		dataMap.put("SaveQuery", "");
		dataMap.put("SavetheQuery", "");

		ensupplierAdvanced.fillDetails(dataMap);
		ensupplierAdvanced.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		basiccount = enobjsupplierBasicSearch.searchcount().getText();
		String countadv = "";
		if (basiccount.contains("(")) {
			String[] count = basiccount.split("\\(");

			String[] counts = count[1].split("\\)");
			countBasic = counts[0];
		}

		Reporter.log("Count Comparision,,Expected:" + countadv + ",in app:" + countBasic);
		softAssert.assertNotEquals(countBasic, countadv, " Basic Search");

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			boolean flag1 = false;

			do {
				lavanteUtils.fluentwait(enviewSupplier.CoresupplierFax());
				String suppname = enviewSupplier.supplierName().getAttribute("title");
				String fax = enviewSupplier.CoresupplierFax().getText();
				if (fax.contains(split2[1])) {
					Reporter.log(suppname + ",Supplier data,Fax ,Expected:" + split2[1] + ", Value,in app:" + fax);
					softAssert.assertTrue(fax.contains(split2[1]),	suppname + "Result Not Matched,Please Retest:" + fax + ",In app:" + split2[1]);
					flag = true;
				}

				for (int jk = 0; jk < enviewSupplier.Listcntactaddress1().size(); jk++) {
					String addressType = enviewSupplier.Listcntactaddress1().get(jk).getText();
					if (addressType.contains(split[1])) {
						Reporter.log(suppname + ",Supplier data,Country,Expected:" + split[1] + ", Value,in app:"			+ addressType);
						softAssert.assertTrue(addressType.contains(split[1]),	suppname + "Result Not Matched,Please Retest:" + x + ",In app:" + addressType);
						flag1 = true;
					}
					if (flag == true && flag1 == true) {
						break;
					}
				}
				if (flag != true || flag1 != true) {
					if (enobjhomePage.nextSupp().size() > 0) {
						lavanteUtils.click(enobjhomePage.nextSupp().get(0));
					} else {
						break;
					}
				}

			} while (flag != true || flag1 != true);

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertFalse(true);
		}

		if (flag == false) {
			softAssert.assertTrue(false, "DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}

		query = "delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%fax%' and CustomerID="
				+ customerID;
		lavanteUtils.UpdateDB(query);

		softAssert.assertAll();

		Reporter.log("------------Test Ended for Combi Edit All to Any Search-------------------");
	}

	/**
	 * CountryStateAddress Search Replacement of CustomerSupplierSearchTC0013
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddressCountryStateSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void CountryStateAddressComboSearch001(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:"	+ currenttime());

		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		ensupplierAdvanced.buildQuery(dataMap);
		
		lavanteUtils.switchtoFrame(ensupplierAdvanced.IFRAMEBuildQry());
		lavanteUtils.clickJavaScript(ensupplierAdvanced.SearchQrybtn());
		

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		String[] data = new String[3];
		String actual = "";
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enviewSupplier.cntactaddress());
			actual = enviewSupplier.cntactaddress1().getText();
			data = ensupplierAdvanced.split(dataMap.get("CountryAddress"));
			if (data[0].equalsIgnoreCase("Equals To")) {
				Reporter.log("Country Search , Equals To Search ,Expected:"	+ data[1] + ",in app:" + actual);
				if (actual.contains(data[1])) {
					flag = true;
				}
			} else if (data[0].equalsIgnoreCase("Not Equal To")) {
				Reporter.log("Country Search ,Not Equals To Search Expected:"	+ data[1] + ",in app:" + actual);
				if (!actual.contains(data[1])) {
					flag = true;
				}
			} else if (data[0].equalsIgnoreCase("Is Empty")) {
				Reporter.log("Country Search ,Is Empty Search ,Expected:Empty Value,in app:"		+ actual);
				if (actual.length() == 0) {
					flag = true;
				}
			}

			softAssert.assertTrue(flag,	"Country Result Not Matched,Please Retest:" + data[0]	+ ",In app:" + actual);
			flag = false;
			data = ensupplierAdvanced.split(dataMap.get("StateAddress"));
			if (data[0].equalsIgnoreCase("Equals To")) {
				System.out.println("State , Equals To Search ,Expected:"+ data[1] + ",in app:" + actual);
				Reporter.log("State Search , Equals To Search ,Expected:"+ data[1] + ",in app:" + actual);
				if (actual.contains(data[1])) {
					flag = true;
				}
			} else if (data[0].equalsIgnoreCase("Not Equal To")) {
				System.out.println("State ,Not Equals To Search ,Expected:"	+ data[1] + ",in app:" + actual);
				Reporter.log("State Search ,Not Equals To Search Expected:"	+ data[1] + ",in app:" + actual);
				if (!actual.contains(data[1])) {
					flag = true;
				}
			} else if (data[0].equalsIgnoreCase("Is Empty")) {
				Reporter.log("State Search ,Is Empty Search ,Expected:Empty Value,in app:"		+ actual);
				if (actual.length() == 0) {
					flag = true;
				}
			}

			softAssert.assertTrue(flag,	"State Result Not Matched,Please Retest:" + data[0]	+ ",In app:" + actual);

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(flag, "No Supplier Found");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for  Country Combo Search at:"	+ currenttime());
	}

	/**
	 * Search Empty Supplier and Verify No Result
	 * 
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 *             Replacement of CustomerSupplierSearchTC0013
	 */
	@Test(dataProvider = "SupplierName", dataProviderClass = SupplierSearchDataProvider.class)
	public void SupplierNameSearch(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Payment Info Adv Search:"+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			flag = false;

		} else {
			Reporter.log("No Supplier Found for this Search");
			
			if(dataMap.containsKey("SupplierName")){
				String x=dataMap.get("SupplierName");
				if(x.equalsIgnoreCase("Is Empty")){
					flag=true;
					softAssert.assertTrue(flag, "Empty Search Not Matched");
				}
			}
			softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
			flag = true;
		}

		softAssert.assertTrue(flag, "DATA NOT AVAILABLE");

		softAssert.assertAll();

		Reporter.log("Test Ended for Supplier Payment Info Search at:"+ currenttime());
	}

	/**
	 * UsincomeYES Search Replacement of CustSupViewProfileTC0003
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "UsincomeYES", dataProviderClass = SupplierSearchDataProvider.class)
	public void USIncomeSearch(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:"	+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enviewSupplier.countryofReg());

			String countryofReg = enviewSupplier.countryofReg().getText();
			String x = dataMap.get("RegCountry");
			boolean result = ensupplierAdvanced.verifySearch(x, countryofReg);
			softAssert.assertTrue(result, "Result Not Matched,Please Retest:"+ x + ",In app:" + countryofReg);

			String actUsIncome = enviewSupplier.UsIncome().getText();
			String xx = dataMap.get("usincome");
			Reporter.log("Usincome , Equals To Search ,Expected:" + xx	+ ",in app:" + actUsIncome);
			softAssert.assertEquals(actUsIncome, xx,"Result Not Matched,Please Retest:" + xx + ",In app:"	+ countryofReg);

			String actTIN = enviewSupplier.EINNUM().getText();
			Reporter.log("TIN Num , Equals To Search ,Expected:Some Value,in app:"+ actTIN);
			softAssert.assertTrue(actTIN.length() > 0,"Result Not Matched,Please Retest:" + x + ",In app:"+ countryofReg);

			flag = true;

		}

		if (flag == false) {
			softAssert.assertTrue(false, "DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for Approved Search at:"+ currenttime());
	}

	

	/**
	 * Test script to verify the supplier advanced search results are in sync even after traversing back from supplier profile view.
	 * @param dataMap
	 * @throws Exception
	 * @author Girish.N
	 */
	@Test(dataProvider = "SupplierNameSingle", dataProviderClass = SupplierSearchDataProvider.class)
	public void AdvVwProfSyncTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("<---------------------Test Started for AdvVwProfSyncTest: " + currenttime(),true);
		SoftAssert softAssert = new SoftAssert();

		click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		int count = lavanteUtils.getCount();
		Reporter.log("<----------------Supplier Advanced Search Count: " + count,true);
		boolean flag = false;
		
		if (count > 1) {
			Reporter.log("Query Returned with Search data",true);
			
			List<WebElement> supLinks = enobjsupplierPage.iterateSearchHeaderFindColList("Supplier Name");
			String expFirstSupName = "";
			String expSecSupName = "";
			
			expFirstSupName=supLinks.get(0).getText().trim();
			expSecSupName=supLinks.get(1).getText().trim();
			
			//Click on the first supplier name link
			click(supLinks.get(0));
			lavanteUtils.switchtoFrame(null);
			waitforPageload(enviewSupplier.supplierName());
			String actFirstSupName = enviewSupplier.SuppNameCompany().getText().trim();
			softAssert.assertEquals(actFirstSupName, expFirstSupName,"Supplier Name Mismatch for the first supplier in Supplier Search Result and Supplier Profile");
			Reporter.log("<----------------Expected First Supplier Name:" + expFirstSupName+"::Actual  First Supplier Name:"+actFirstSupName,true);
			
			//Click on the next supplier link
				click(enviewSupplier.nextSupplierLink());
				waitforPageload(enviewSupplier.supplierName());
				String actSecSupName = enviewSupplier.SuppNameCompany().getText().trim();
				softAssert.assertEquals(actSecSupName, expSecSupName,"Supplier Name Mismatch for the second supplier in Supplier Search Result and Supplier Profile");
				Reporter.log("<----------------Expected Second Supplier Name:" + expSecSupName+"::Actual  Second Supplier Name:"+actSecSupName,true);
			
			//Click on back link on breadcrumb
			click(enviewSupplier.backToSearchLink());
			waitforPageload(ensupplierAdvanced.advtab());
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			int newCount = lavanteUtils.getCount();
			Reporter.log("<----------------Supplier Advanced Search Count (After return from Supplier Profile): " + newCount,true);
			softAssert.assertEquals(newCount,count,"SEARCH COUNT MISMATCH (after return from Supplier Profile)");
			Reporter.log("<----------------Old Supplier advanced Search Result count:" + count+"::Advanced Search Count after return from Supplier Profile:"+newCount,true);
			
			String expFirstSupName1 = "";
			String expSecSupName1 = "";
			
			supLinks = enobjsupplierPage.iterateSearchHeaderFindColList("Supplier Name");
			expFirstSupName1=supLinks.get(0).getText().trim();
			expSecSupName1=supLinks.get(1).getText().trim();

			softAssert.assertEquals(expFirstSupName1,expFirstSupName,"Search results doen't match for the first supplier");
			softAssert.assertEquals(expSecSupName1,expSecSupName,"Search results doen't match for the second supplier");
			flag = true;
						
		}else{
			softAssert.assertTrue(false,"Please Add Test Data or Change the Search Criteria");
			flag=true;
		}

		softAssert.assertTrue(flag, "DATA NOT AVAILABLE");

		softAssert.assertAll();

		Reporter.log("Test Ended for Supplier Payment Info Search at:"+ currenttime());
	}

	
	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod() {

		enobjhomePage.backtoSearch();
		lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(null);
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
