package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 19-2-2016 Created for Supplier Search Enhancement covered SIM
 * -7614,SIM-7604 Ended on 19-02-2016
 * 
 * @author Piramanayagam.S
 *
 */
public class SupplierAdvancedSearchTC extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String emailID = "";
	String custid = "";
	String aftermethd = null;

	/**
	 * This class all test starts using login page and driver intilization
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
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("Search-Tax", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		emailID = LdataMap.get("username");
		custid = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	@BeforeMethod
	public void before() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

	}

	/**
	 * SIM -7604 Form Validation field a multi select in Adv Search
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void ValidForm001() throws Exception {
		System.out.println("------------Test Started for Valid Form Search-------------------");
		Reporter.log("Test Started for  Valid Form:"+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Clear", "");
		dataMap.put("Tab", "Tax");
		ensupplierAdvanced.buildQuery(dataMap);

		Reporter.log("FORM Validation field available in Advanced Search,Expected:True,in app:"	+ ensupplierAdvanced.formValidation().isDisplayed());
		Assert.assertTrue(ensupplierAdvanced.formValidation().isDisplayed(),"FORM Validation field not available in Advanced Search");

		String att = ensupplierAdvanced.formValidationUI()	.getAttribute("class");

		Reporter.log("FORM Validation field available in Advanced Search,Expected:Multiple,in app:"	+ att);
		Assert.assertTrue(att.contains("multi"),
				"FORM Validation field not an multi Select available in Advanced Search"+ att);

		lavanteUtils.click(ensupplierAdvanced.Cancelsearch());

		Reporter.log("Test Ended for ValidForm Search at:"	+ currenttime());
		System.out.println("Test Ended for valid form");
	}

	/**
	 * SIM -7604 Form Validation -Multi Adv Search
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "ValidForm", dataProviderClass = SupplierSearchDataProvider.class)
	public void ValidFormSearch002(LinkedHashMap<String, String> dataMap)	throws Exception {
		Reporter.log("Test Started for  Valid Form  Search:"+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.fluentwait(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			String suppname = enobjsupplierPage.getColumnText("Name", 0);
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Enterprise");
			dataMap.put("subtab", "W8Tax");
			enviewSupplier.selectTab(dataMap);

			lavanteUtils.fluentwait(enviewSupplier.formValid());

			String formValid = enviewSupplier.formValid().getText();

			Reporter.log(suppname	+ "had Valid Form ,Data for Valid Form Expected:"	+ dataMap.get("ValidForm") + ",in app:" + formValid);
			softAssert.assertTrue(	dataMap.get("ValidForm").contains(formValid),	" Valid Form not Matched ,Expected"		+ dataMap.get("ValidForm") + ",But in app:"	+ formValid);
			flag = true;

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(false, "DATA NOT AVAILABLE");
			flag=true;

		}
		softAssert.assertTrue(flag, "Please Retest");

		softAssert.assertAll();

		Reporter.log("Test Ended for ValidForm Search at:"+ currenttime());
	}

	/**
	 * SIM -7614 CTI Status Adv Search
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void VerifyCTI003() throws Exception {
		Reporter.log("Test Started for Adv Search:"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Tab", "Tax");
		dataMap.put("Clear", "");
		ensupplierAdvanced.buildQuery(dataMap);
		Reporter.log("Cti Status ,Expected:True,in app:"+ ensupplierAdvanced.CTI().isDisplayed());
		Assert.assertTrue(ensupplierAdvanced.CTI().isDisplayed(),"CTI Status not matched expected:"		+ ensupplierAdvanced.CTI().isDisplayed());

		String att = ensupplierAdvanced.CTIUI().getAttribute("class");
		Reporter.log("Cti Status ,Expected:Multi,in app:" + att);
		Assert.assertTrue(att.contains("multi"),"CTI Status not Matched ,Expected:Multiple,in APP:" + att);

		lavanteUtils.click(ensupplierAdvanced.Cancelsearch());
		Reporter.log("Test Ended for CTI Multi verification  at:"+ currenttime());
	}

	/**
	 * SIM -7614 CTI Status Adv Search
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "CTIAdvSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void CTIMultiSearch004(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:"	+ currenttime());

		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Enterprise");
			dataMap.put("subtab", "W8");
			enviewSupplier.selectTab(dataMap);

			lavanteUtils.fluentwait(enviewSupplier.ctiStatus());

			String ctiStatus = enviewSupplier.ctiStatus().getText();
			Reporter.log("Cti Status ,Expected:" + dataMap.get("CTI")+ ",in app:" + ctiStatus);
			softAssert.assertTrue(dataMap.get("CTI").contains(ctiStatus),"CTI not Matched ,Expected" + dataMap.get("CTI")+ ",But in app:" + ctiStatus);
			flag = true;

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
			flag=true;
		}

		softAssert.assertTrue(flag, "Please Re-test");

		softAssert.assertAll();

		Reporter.log("Test Ended for CTI Search at:"+ currenttime());
	}

	/**
	 * Country Search Replica of CustomerSupplierAdvanceSearchTC0001
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "CountrySearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void countrySearch001(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:"	+ currenttime());

		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enviewSupplier.countryofReg());

			String countryofReg = enviewSupplier.countryofReg().getText();
			String x = dataMap.get("RegCountry");
			boolean result = ensupplierAdvanced.verifySearch(x, countryofReg);
			Assert.assertTrue(result, "Result Not Matched,Please Retest:" + x+ ",In app:" + countryofReg);

			flag = true;

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
			flag=true;

		}

		softAssert.assertTrue(flag, "Please Retest");

		softAssert.assertAll();

		Reporter.log("Test Ended for Country Search at:"+ currenttime());
	}

	/**
	 * Supplier Insurance Search
	 * 
	 * Replica of customer advanced search 2
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "InsuranceSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void insuranceSearch002(LinkedHashMap<String, String> dataMap) 	throws Exception {
		Reporter.log("Test Started for Adv Search:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");
			
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			dataMap.put("maintab", "Supplier Managed");
			dataMap.put("subtab", "Certification");
			enviewSupplier.selectTab(dataMap);

			lavanteUtils.fluentwait(enviewSupplier.haveinsurance());
			String suppInsurance = enviewSupplier.haveinsurance().getText();
			String x = dataMap.get("SuppInsurance");
			Reporter.log("Supp Insurance,Expected:" + x + ", Value,in app:"	+ suppInsurance);
			Assert.assertEquals(suppInsurance, x,"Result Not Matched,Please Retest:" + x + ",In app:"+ suppInsurance);

			flag = true;

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
			flag=true;
		}
		
		softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
		softAssert.assertAll();

		Reporter.log("Test Ended for Supplier Insurance Search at:"	+ currenttime());
	}

	/**
	 * Supplier Address Type search
	 * 
	 * Replica of CustomerSupplierAdvanceSearchTC0011
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddressSearch", dataProviderClass = SupplierSearchDataProvider.class)
	public void addressTypeSearch011(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for Adv Search:"	+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");

		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			lavanteUtils.fluentwait(enviewSupplier.supplierName());
			for (int i = 0; i < enviewSupplier.ListContactHeader().size(); i++) {

				String header = enviewSupplier.ListContactHeader().get(i).getText();
				if (header.contains("Location Type")) {
					String x = dataMap.get("AddressType");

					if (header.contains(x)) {
						System.out.println("Address Type ,Expected:" + x+ ", Value,in app:" + header);
						Reporter.log("Address Type,Expected:" + x+ ", Value,in app:" + header);
						Assert.assertTrue(header.contains(x),"Result Not Matched,Please Retest:" + x+ ",In app:" + header);
						flag = true;
						break;
					}
				}
			}

		} else {
			Reporter.log("No Supplier Found for this Search");
			softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
			flag=true;

		}
		
		softAssert.assertTrue(flag, "DATA NOT AVAILABLE");
		softAssert.assertAll();

		Reporter.log("Test Ended for Supplier Insurance Search at:"	+ currenttime());
	}
	
	/**
	 * Search US Supplier Verify in the DB US INCOME
	 * 
	 * Actually Valid TC but as per implemeentation, it is invalid. for US
	 * Supplier, US Income wont be set hence invalid .
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	// @Test(dataProvider="CountryOfReg",dataProviderClass=SupplierSearchDataProvider.class)
	public void USIncome012(LinkedHashMap<String, String> dataMap)throws Exception {
		System.out.println("------------Test Started for US Income-------------------"	+ dataMap);
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
			
			String supp = enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText();
			Reporter.log("Supplier Name,Selected:"+supp);
			String query = "select USIncome from Supplier where SupplierName='"	+ supp + "'";
			query = lavanteUtils.fetchDBdata(query);

			Reporter.log("US Supplier" + supp + " US Income is  SET as "+ query);
			softAssert.assertEquals(query, "YES","US Supplier US Income is not SET as YES");

			flag = true;

		} else {
			Reporter.log("No Supplier Found for this Search");

		}

		softAssert.assertTrue(flag, "DATA NOT AVAILABLE");

		softAssert.assertAll();

		Reporter.log("Test Ended for Supplier Payment Info Search at:"+ currenttime());

	}

	/**
	 * SIM-10580 Demo Feedback : Deactivate W8 and W9
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "W8Deactivated", dataProviderClass = SupplierSearchDataProvider.class)
	public void verifyW8DeactivateTest001(LinkedHashMap<String, String> dataMap)	throws Exception {
		Reporter.log("Test verifyW8DeactivateTest001 Started for Adv Search:"+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));

			lavanteUtils.switchtoFrame(null);

			lavanteUtils.fluentwait(enviewSupplier.countryofReg());

			String countryofReg = enviewSupplier.countryofReg().getText();
			String x = "";
			if (dataMap.get("RegCountry").contains(",")) {
				x = dataMap.get("RegCountry").split(",")[1];
			} else {
				x = dataMap.get("RegCountry");
			}
			if (!x.equalsIgnoreCase(countryofReg)) {
				flag = true;
			}
			Reporter.log("Result should not match " + x + " and " 	+ countryofReg);
			softAssert.assertTrue(flag, "Result Matched,Please Retest: " + x	+ " and  " + countryofReg);
		
			dataMap.put("maintab", "supplier");
			dataMap.put("subtab", "viewRelationshipSpecificDetails");
			enviewSupplier.selectTab(dataMap);

			String status = "";
			int size = enviewSupplier.getListTaxInfoStatus().size();
			for (int i = 0; i < size; i++) {
				status = enviewSupplier.getListTaxInfoStatus().get(i).getText();
				if ("Deactivated".equals(status)) {
					flag = true;
					break;
				}
			}

			Reporter.log("Tax information status is " + status);
			softAssert.assertTrue(flag,"Tax information status should be Deactivated, but it is "+ status);

		}
		softAssert.assertAll();

		Reporter.log("Test verifyW8DeactivateTest001 Ended for Approved Search at:"	+ currenttime());
	}

	/**
	 * SIM-10580 Demo Feedback : Deactivate W8 and W9
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "W8Deactivated", dataProviderClass = SupplierSearchDataProvider.class)
	public void verifyW8DeactivateTest002(LinkedHashMap<String, String> dataMap)	throws Exception {
		Reporter.log("Test verifyW8DeactivateTest002 Started for Adv Search:"+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		String query = "update Customer set IsW8Enabled=0 where CustomerID="+ custid + "";
		lavanteUtils.UpdateDB(query);

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			
			String Sup = enobjsupplierPage.VerifyManagedBywithoutNetwork(custid);
			dataMap.put("supplierName",Sup);
			enobjsupplierPage.selectSupplier(dataMap);
			dataMap.put("editProfile", "");
			dataMap.put("profile", "");
			enobjsupplierPage.ProfileAction(dataMap);
			lavanteUtils.switchtoFrame(null);

			lavanteUtils.fluentwait(eneditProfile.confirm_Yes_Button());

			dataMap.put("tab", "supplierRelationshipInfo");
			eneditProfile.selectTab(dataMap);

			lavanteUtils.click(eneditCustomerProfile.W8UploadDocumentBtn());

			String uploadFileName = CopyFile("pdfSample.pdf");
			dataMap.put("FileName", uploadFileName);
			dataMap.put("SelectCurrentDate", "");
			eneditCustomerProfile.uploadW8TaxDocument(dataMap);

			String status = "";
			String fileName = "";
			int size = eneditCustomerProfile.GetW8TaxUploadedFilesList().size();
			for (int i = 0; i < size; i++) {

				fileName = eneditCustomerProfile.GetW8TaxUploadedFilesList().get(i).getText();
				status = eneditCustomerProfile.GetW8TaxUploadedStatusList().get(i).getText();
				if (uploadFileName.equals(fileName) && "Active".equals(status)) {
					flag = true;
					Reporter.log("Uploaded File Name Exp :"+uploadFileName+",Actuals:"+fileName);
					Reporter.log("Uploaded File Status Exp :Active,Actuals:"+status);
					lavanteUtils.click(eneditCustomerProfile.GetW8TaxUploadedActionList().get(i));
				/*	lavanteUtils.fluentwait(eneditCustomerProfile.OkYesBtn());
					lavanteUtils.click(eneditCustomerProfile.OkYesBtn());
				*/	break;
				}
			}

			for (int i = 0; i < size; i++) {
				fileName = eneditCustomerProfile.GetW8TaxUploadedFilesList().get(i).getText();
				status = eneditCustomerProfile.GetW8TaxUploadedStatusList().get(i).getText();
				if (uploadFileName.equals(fileName)	&& "Deactivated".equals(status)) {
					Reporter.log("Deactivated,Uploaded File Name Exp :"+uploadFileName+",Actuals:"+fileName);
					Reporter.log("Deactivated,Uploaded File Status Exp :Deactivated,Actuals:"+status);
					flag = true;
					break;
				} else {
					flag = false;
				}
			}

			String x="select AssetID from Asset where FileName='"+uploadFileName+"' ";
			x=lavanteUtils.fetchDBdata(x);
			if(x!=null && x.length()>0){
				String y="delete From SupplierW8Docs where W8_AssetID="+x;
				lavanteUtils.UpdateDB(x);
				y="delete From Asset where AssetID="+x;
				lavanteUtils.UpdateDB(y);
			}
			
			Reporter.log("Tax information status is " + status);
			softAssert.assertTrue(flag,"Tax information status should be Deactivated, but it is "+ status);

		}
		softAssert.assertAll();

		Reporter.log("Test verifyW8DeactivateTest002 Ended for Approved Search at:"	+ currenttime());
	}

	/**
	 * SIM-10580 Demo Feedback : Deactivate W8 and W9
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "W9Deactivated", dataProviderClass = SupplierSearchDataProvider.class)
	public void verifyW9DeactivateTest003(LinkedHashMap<String, String> dataMap)throws Exception {
		Reporter.log("Test verifyW9DeactivateTest003 Started for Adv Search:"+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			Reporter.log("Supplier Name,Selected:"+enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0).getText());
			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enviewSupplier.countryofReg());
			String countryofReg = enviewSupplier.countryofReg().getText();
			String x = "";
			if (dataMap.get("RegCountry").contains(",")) {
				x = dataMap.get("RegCountry").split(",")[1];
			} else {
				x = dataMap.get("RegCountry");
			}
			if (x.equalsIgnoreCase(countryofReg)) {
				flag = true;
			}
			Reporter.log("Result should not match " + x + " and "	+ countryofReg);
			softAssert.assertTrue(flag, "Result Matched,Please Retest: " + x	+ " and  " + countryofReg);

			String status = "";
			int size = enviewSupplier.getListOfW9TaxStatusLink().size();
			for (int i = 0; i < size; i++) {
				status = enviewSupplier.getListOfW9TaxStatusLink().get(i).getText();
				if ("Deactivated".equals(status)) {
					flag = true;
					break;
				}
			}
			Reporter.log("Tax information status is " + status);
			softAssert.assertTrue(flag,"Tax information status should be Deactivated, but it is "+ status);

		}
		
		softAssert.assertAll();

		Reporter.log("Test verifyW9DeactivateTest003 Ended for Approved Search at:"	+ currenttime());
	}

	/**
	 * SIM-10580 Demo Feedback : Deactivate W8 and W9
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "W9Deactivated", dataProviderClass = SupplierSearchDataProvider.class)
	public void verifyW9DeactivateTest004(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test verifyW9DeactivateTest004 Started for Adv Search:"+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		String query = "update Customer set IsW9Enabled=0 where CustomerID="+ custid + "";
		lavanteUtils.UpdateDB(query);

		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");

			String Sup = enobjsupplierPage.VerifyManagedBywithoutNetwork(custid);
			dataMap.put("supplierName",Sup);
			dataMap.put("editProfile", "");
			dataMap.put("profile", "");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			lavanteUtils.switchtoFrame(null);

			lavanteUtils.fluentwait(eneditProfile.Finish_Profile_Button());

			dataMap.put("tab", "supplierCompanyDetails");
			eneditProfile.selectTab(dataMap);

			lavanteUtils.fluentwait(eneditCompanyProfile.W9UploadDocumentBtn());
			lavanteUtils.click(eneditCompanyProfile.W9UploadDocumentBtn());
			String uploadFileName = CopyFile("pdfSample.pdf");
			dataMap.put("FileName", uploadFileName);
			eneditCompanyProfile.uploadW9TaxDocument(dataMap);

			String status = "";
			String fileName = "";
			int size = eneditCompanyProfile.GetW9TaxUploadedFilesList().size();
			for (int i = 0; i < size; i++) {

				fileName = eneditCompanyProfile.GetW9TaxUploadedFilesList().get(i).getText();
				status = eneditCompanyProfile.GetW9TaxUploadedStatusList().get(i).getText();
				if (uploadFileName.equals(fileName)		&& "Active".equalsIgnoreCase(status)) {
					flag = true;
					int m=eneditLegal.editw9statusactive().size()-1;
					lavanteUtils.click(eneditCompanyProfile.GetW9TaxUploadedActionList().get(m));
					lavanteUtils.click(eneditCompanyProfile.OkYesBtn());
					break;
				}
			}

			for (int i = 0; i < size; i++) {

				fileName = eneditCompanyProfile.GetW9TaxUploadedFilesList().get(i).getText();
				status = eneditCompanyProfile.GetW9TaxUploadedStatusList().get(i).getText();
				if (uploadFileName.equals(fileName)	&& "Deactivated".equalsIgnoreCase(status)) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
			String x="select AssetID from Asset where FileName='"+fileName+"' ";
			x=lavanteUtils.fetchDBdata(x);
			if(x!=null && x.length()>0){
				String y="delete From SupplierW9Docs where W9_AssetID="+x;
				lavanteUtils.UpdateDB(x);
				y="delete From Asset where AssetID="+x;
				lavanteUtils.UpdateDB(y);
			}
			
			Reporter.log("Tax information status is " + status);
			softAssert.assertTrue(flag,	"Tax information status should be Deactivated, but it is "	+ status);
		}
		
		softAssert.assertAll();

		Reporter.log("Test verifyW9DeactivateTest004 Ended for Approved Search at:"	+ currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.refreshPage();
		{
			enobjhomePage.backtoSearch();
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
			dataMap.put("EditCancel", "");
			eneditProfile.formAction(dataMap);
		}
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
