package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 1-12-2016 Created for verify LaunchWizardW8W9 buttons
 * 
 * @author Nandini.R
 *
 */

public class Companyw9w8Deactivate01 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = null;
	String getCustomerName = null;

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Ramireddy.Nandini
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
		List listofdatafrm = lavanteUtils.login("LavanteSupportRole", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		getCustomerName = "select [Name] from customer where CustomerID in (select max(CustomerID) from CTIWebserviceProperties)";
		getCustomerName = lavanteUtils.fetchDBdata(getCustomerName);
		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(enobjhomePage.AllCustomersDropDwn());
		lavanteUtils.click(enobjhomePage.AllCustomersDropDwn());
		lavanteUtils.typeinEdit(getCustomerName, enobjhomePage.AllCustomersDropDwnTxtBox);
		lavanteUtils.selectvalueFrmDpdn(getCustomerName);
		lavanteUtils.waitForTime(5000);


	}
	
	@BeforeMethod
	public void BeforeMethod(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * Deactivate W9
	 * 
	 * @throws IOException
	 * @author Nandini.R
	 */
	@Test
	public void verifyw9deactivateTest() throws Exception {
		Reporter.log("Test Started for verifyw9deactivateTest:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert = new SoftAssert();

		String updateQuery = "update customer set Registration_ISOCountryID=null where [Name]='" + getCustomerName		+ "'";
		lavanteUtils.UpdateDB(updateQuery);

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());

		dataMap.put("Tab", "Legal");
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		dataMap.put("supplierNameRandom", "");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String supplierName = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(null);
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		boolean flag = false;
		String uploadFileName = lavanteUtils.CopyFile("pdfSample.pdf");
		eneditLegal.uploadw9(uploadFileName);

		lavanteUtils.fluentwait(eneditLegal.GetW9TaxUploadedFilesList().get(0));
		String actualFile = null;
		String Expw9status = "Active";
		String actualStatus = null;

		flag = false;
		for (int i = 0; i < eneditLegal.GetW9TaxUploadedFilesList().size(); i++) {
			actualFile = eneditLegal.GetW9TaxUploadedFilesList().get(i).getText();
			if (actualFile.equalsIgnoreCase(uploadFileName)) {
				flag = true;
			}
			lavanteUtils.click(eneditCompanyProfile.GetW9TaxUploadedActionList().get(i));
			lavanteUtils.fluentwait(eneditLegal.editw9statusdeac().get(0));
			actualStatus = eneditLegal.editw9statusdeac().get(i).getText();
		}

		Reporter.log(" Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag,"Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		Reporter.log(" w 9 status verification in edit profile, Expected: " + Expw9status + ", Actual:" + actualStatus);
		softAssert.assertEquals(actualStatus, Expw9status,"w 9 status verification in edit profile, Expected: " + Expw9status + ", Actual:" + actualStatus);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supplierName);
		lavanteUtils.switchtoFrame(null);
		actualStatus = null;
		flag = false;
		for (int i = 0; i < enviewSupplier.getListOfW9TaxFilesLink().size(); i++) {
			actualFile = enviewSupplier.getListOfW9TaxFilesLink().get(i).getText();
			if (actualFile.equalsIgnoreCase(uploadFileName)) {
				actualStatus = enviewSupplier.getListOfW9TaxStatusLink().get(i).getText();
				flag = true;
				break;
			}

		}
		Reporter.log(" Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag,	"Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		Reporter.log(" w 9 status verification in view profile, Expected: " + Expw9status + ", Actual:" + actualStatus);
		softAssert.assertEquals(actualStatus, Expw9status,"w 9 status verification in view profile, Expected: " + Expw9status + ", Actual:" + actualStatus);

		softAssert.assertAll();
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * Deactivate w8
	 * 
	 * @throws IOException
	 * @author Nandini.R
	 */
	@Test
	public void verifydeactivatew8Test() throws Exception {
		Reporter.log("Test Started for verifydeactivatew8Test:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());

		  dataMap.put("Tab", "Legal");
		  dataMap.put("RegCountry","Not Equal To,United States"); 
		  dataMap.put("Search", "");
		 ensupplierAdvanced.buildQuery(dataMap);
		 
		dataMap.put("supplierNameRandom", "");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String supplierName = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(null);
		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);

		String uploadFileName = lavanteUtils.CopyFile("pdfSample.pdf");
		lavanteUtils.fluentwait(eneditCustomerProfile.W8UploadDocumentBtn());
		lavanteUtils.click(eneditCustomerProfile.W8UploadDocumentBtn());

		dataMap.put("FileName", uploadFileName);
		dataMap.put("SelectCurrentDate", "");
		eneditCustomerProfile.uploadW8TaxDocument(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag0 = false;
		String actualFile = null;
		String Expw8status = "Inactive";
		List<WebElement> noW8TaxFiles = eneditCustomerProfile.GetW8TaxUploadedFilesList();

		for (int i = 0; i < eneditCustomerProfile.GetW8TaxUploadedFilesList().size(); i++) {
			actualFile = eneditCustomerProfile.GetW8TaxUploadedFilesList().get(i).getText();
			if (actualFile.equalsIgnoreCase(uploadFileName)) {
				flag0=true;
				Reporter.log(" Tax (W-8) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:"			+ actualFile);
				softAssert.assertTrue(flag0, "Tax (W-8) Uploaded file verifcation failed, Expected: " + uploadFileName	+ ", Actual:" + actualFile);
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath("//*[text()='"+actualFile+"']/../..//td[8]//a")));
				lavanteUtils.click(eneditCustomerProfile.okdeactivatew8btn());
				lavanteUtils.refreshPage();
				actualFile = eneditCustomerProfile.GetW8TaxUploadedStatusList().get(i).getText();
				String Expw8st = "Inactive";
				Reporter.log(" w 8 status verification in edit profile, Expected: " + Expw8st + ", Actual:" + actualFile);
				softAssert.assertTrue(flag0,"w 8 status verification in edit profile, Expected: " + Expw8st + ", Actual:" + actualFile);
				flag0=true;

			}
		}

		softAssert.assertTrue(flag0, "Deactivate File not found");
		flag0=false;

		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supplierName);
		
		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipSpecificDetails");
		enviewSupplier.selectTab(dataMap);

		for (int i = 0; i < eneditCustomerProfile.GetW8TaxUploadedFilesList().size(); i++) {
			actualFile = eneditCustomerProfile.GetW8TaxUploadedFilesList().get(i).getText();
			if (actualFile.equalsIgnoreCase(uploadFileName)) {

				Reporter.log(" Tax (W-8) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:"	+ actualFile);
				softAssert.assertTrue(flag0, "Tax (W-8) Uploaded file verifcation failed, Expected: " + uploadFileName	+ ", Actual:" + actualFile);
				flag0=true;

			}
		}

		softAssert.assertTrue(flag0, "View Supplier Not Found the file");
		softAssert.assertAll();
		
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * SIM-12438 W8/W9 Visibility should be dependent on Buyer Country
	 * 
	 * @throws Exception
	 */

	@Test
	public void w9VisibilityBuyerCountryTest() throws Exception {

		Reporter.log("Test started at w9VisibilityBuyerCountryTest : " + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert = new SoftAssert();

		String updateQuery = "update customer set Registration_ISOCountryID=null where [Name]='" + getCustomerName	+ "'";
		lavanteUtils.UpdateDB(updateQuery);

		String supplierName = "FAAXYSUP";
		dataMap.put("supplierName", supplierName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(null);
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		boolean flag = false;
		// Verify buyer country i.e Registration_ISOCountryID=null
		if (lavanteUtils.isElementDisplayed(eneditCompanyProfile.GetW9SecHeader())) {
			flag = true;
		}

		Reporter.log(" Verify Your Tax (W-9) Information section is not displayed Registration_ISOCountryID=null ");
		softAssert.assertTrue(flag,
				" Your Tax (W-9) Information section is not displayed Registration_ISOCountryID=null");

		String expectedHeader = "Your Tax (W-9) Information (Note: Your W-9 will not be considered valid unless it is signed and dated)";
		String actualHeader = lavanteUtils.getText(eneditCompanyProfile.GetW9SecHeader());

		Reporter.log(" verify Your Tax (W-9) Information section is displayed with invalid header name");
		softAssert.assertEquals(actualHeader, expectedHeader," Your Tax (W-9) Information section is displayed with invalid header name ");

		// Verify buyer country not US/null i.e Registration_ISOCountryID=8
		updateQuery = "update customer set Registration_ISOCountryID=8 where [Name]='" + getCustomerName + "'";
		lavanteUtils.UpdateDB(updateQuery);
		lavanteUtils.refreshPage();
		flag = false;
		if (!lavanteUtils.isElementDisplayed(eneditCompanyProfile.GetW9SecHeader())) {
			flag = true;
		}

		Reporter.log(" Verify Your Tax (W-9) Information section is displayed for Registration_ISOCountryID=8 ");
		softAssert.assertTrue(flag, " Your Tax (W-9) Information section is displayed for Registration_ISOCountryID=8");

		// Verify buyer country is US i.e Registration_ISOCountryID=840
		updateQuery = "update customer set Registration_ISOCountryID=840 where [Name]='" + getCustomerName + "'";
		lavanteUtils.UpdateDB(updateQuery);
		lavanteUtils.refreshPage();
		flag = false;
		if (lavanteUtils.isElementDisplayed(eneditCompanyProfile.GetW9SecHeader())) {
			flag = true;
		}

		Reporter.log("Verify Your Tax (W-9) Information section is not displayed Registration_ISOCountryID=null");
		softAssert.assertTrue(flag,
				" Your Tax (W-9) Information section is not displayed Registration_ISOCountryID=null");

		actualHeader = lavanteUtils.getText(eneditCompanyProfile.GetW9SecHeader());

		Reporter.log(" Verify  Your Tax (W-9) Information section is displayed with invalid header name ");
		softAssert.assertEquals(actualHeader, expectedHeader," Your Tax (W-9) Information section is displayed with invalid header name ");

		flag = false;
		if (lavanteUtils.isElementDisplayed(eneditLegal.W9LaunchWizardBtn())
				&& lavanteUtils.isElementDisplayed(eneditLegal.W9UploadDocumentBtn())) {
			flag = true;
		}
		Reporter.log("Verify Launch W-9 Wizard verifed, Expected: true, Actual:" + flag);
		softAssert.assertTrue(flag," Launch W-9 Wizard verification Failed/Not Present , Expected: true, Actual:" + flag);

		softAssert.assertAll();
		Reporter.log("Test Ended at w9VisibilityBuyerCountryTest :" + currenttime());
	}

	/**
	 * SIM-12438 W8/W9 Visibility should be dependent on Buyer Country
	 * 
	 * @throws Exception
	 */

	@Test
	public void w8VisibilityBuyerCountryTest() throws Exception {

		Reporter.log("Test started at W8W9VisibilityBuyerCountryTest : " + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert = new SoftAssert();

		String updateQuery = "update customer set Registration_ISOCountryID=null where [Name]='" + getCustomerName	+ "'";
		lavanteUtils.UpdateDB(updateQuery);

		dataMap.put("ProfStatus", "Pending Validation");
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(null);
		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		boolean flag = false;
		// Verify buyer country i.e Registration_ISOCountryID=null
		if (lavanteUtils.isElementDisplayed(eneditCustomerProfile.GetW8SecHeader())) {
			flag = true;
		}

		Reporter.log(" Verify Your Tax (W-8) Information section is not displayed Registration_ISOCountryID=null ");
		softAssert.assertTrue(flag,	" Your Tax (W-8) Information section is not displayed Registration_ISOCountryID=null");

		String expectedHeader = "Your US IRS W-8 Foreign Tax Information (If Applicable)";
		String actualHeader = lavanteUtils.getText(eneditCustomerProfile.GetW8SecHeader());

		Reporter.log(" verify Your Tax (W-8) Information section is displayed with invalid header name");
		softAssert.assertEquals(actualHeader, expectedHeader," Your Tax (W-8) Information section is displayed with invalid header name ");

		// Verify buyer country not US/null i.e Registration_ISOCountryID=8
		updateQuery = "update customer set Registration_ISOCountryID=8 where [Name]='" + getCustomerName + "'";
		lavanteUtils.UpdateDB(updateQuery);
		lavanteUtils.refreshPage();
		lavanteUtils.waitForTime(4000);
		flag = false;
		if (!lavanteUtils.isElementDisplayed(eneditCustomerProfile.GetW8SecHeader())) {
			flag = true;
		}

		Reporter.log(" Verify Your Tax (W-8) Information section is displayed for Registration_ISOCountryID=8 ");
		softAssert.assertTrue(flag, " Your Tax (W-8) Information section is displayed for Registration_ISOCountryID=8");

		// Verify buyer country is US i.e Registration_ISOCountryID=840
		updateQuery = "update customer set Registration_ISOCountryID=840 where [Name]='" + getCustomerName + "'";
		lavanteUtils.UpdateDB(updateQuery);
		lavanteUtils.refreshPage();
		lavanteUtils.waitForTime(4000);
		flag = false;
		if (lavanteUtils.isElementDisplayed(eneditCustomerProfile.GetW8SecHeader())) {
			flag = true;
		}

		Reporter.log("Verify Your Tax (W-8) Information section is not displayed Registration_ISOCountryID=null");
		softAssert.assertTrue(flag," Your Tax (W-8) Information section is not displayed Registration_ISOCountryID=null");
		actualHeader = null;
		actualHeader = lavanteUtils.getText(eneditCustomerProfile.GetW8SecHeader());

		Reporter.log(" Verify  Your Tax (W-8) Information section is displayed with invalid header name ");
		softAssert.assertEquals(actualHeader, expectedHeader," Your Tax (W-8) Information section is displayed with invalid header name ");

		softAssert.assertAll();

		Reporter.log("Test Ended at W8VisibilityBuyerCountryTest :" + currenttime());
	}
	
	@AfterMethod
	public void aftermethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.backtoSearch();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
