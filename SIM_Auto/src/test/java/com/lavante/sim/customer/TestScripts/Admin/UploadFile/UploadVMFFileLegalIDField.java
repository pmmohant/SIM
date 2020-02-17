package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;
import com.lavante.sim.customer.pageobjects.Suppliers.EditProfile.EditCompanyProfile;

/**
 * Created on 06-04-2017
 * 
 * @author Subhash BV
 *
 */
public class UploadVMFFileLegalIDField extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

	String dir = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "data";
	String customerid = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Subhash BV
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
		List listofdatafrm = lavanteUtils.login("VMF", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = "" + listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "customerUploadFiles");
		enobjhomePage.selectTab(dataMap);

	}

	/**
	 * SIM-10471 Add Legal ID Type column in VMF Template
	 * 
	 * (Without LegalID)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFWithoutLegalId001() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4, "");
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;

				break;
			}

		}
		// Second verification
		if (flag == true) {

			flag = false;
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			dataMap.put("supplierName", expSname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			Reporter.log("In Search page");

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
				String suppname = enobjsupplierPage.getColumnText("Name", 0);
				Reporter.log("Added Supplier via VMF File," + expSname + ",In app:" + suppname);
				softassert.assertEquals(suppname, expSname, "Supplier name not matched");
				flag = true;
			}
		}

		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}
		softassert.assertAll();
		enviewSupplier.clickOnSupplier(expSname);
		lavanteUtils.waitForTime(2000);

		String expectedLegalID = "Unknown";
		String actualLegalID = enviewSupplier.legalIDstatus().getText();

		Reporter.log(
				"Actual : " + actualLegalID + " Expected : " + expectedLegalID + " Verification of Without LegalID");
		assertEquals(actualLegalID, expectedLegalID, " Verification of Without LegalID");

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.waitForTime(2000);
		// Navigating to ManageFiles Tab
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10471 Add Legal ID Type column in VMF Template
	 * 
	 * (With already existing LegalID)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFExistingLegalId002() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);
		String legalquery="Select  Top 1 dbo.lcfn_decrypt(LegalIdentifier,'TripTheLightFandango') From Supplier  where LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") ";
		 legalquery=lavanteUtils.fetchDBdata(legalquery);
		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4,legalquery);
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "United States");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "0";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;

				break;
			}

		}
		// Second verification

		String actual = "";
		String expected = "" + 1;
		for (int j = 0; j < enobjuploadFiles.ListUploadFile().size(); j++) {
			String fileName = enobjuploadFiles.ListUploadFile().get(j).getText();
			if (nwfile.equals(fileName)) {
				actual = enobjuploadFiles.LocationErrorLog().get(j).getText();
				break;
			}
		}
		Reporter.log("Actual : " + actual + " Expected : " + expected + " Verification Potential Network match");
		assertEquals(actual, expected, " Verification Potential Network match");
		Reporter.log("Actual : " + actual + " Expected : " + expected + " Verification of Potential Network match");
		assertEquals(actual, expected, " Verification of Potential Network match");
		softassert.assertAll();
		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10471 Add Legal ID Type column in VMF Template
	 * 
	 * (With invalid LegalID )
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFInvalidLegalId003() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4, "454548455454");
		LavanteUtils.editcsv(nwfile, 16, "USA");

		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;
				break;
			}
		}
		// Second verification

		String actual = "";
		String expected = "" + 1;
		for (int j = 0; j < enobjuploadFiles.ListUploadFile().size(); j++) {
			String fileName = enobjuploadFiles.ListUploadFile().get(j).getText();
			if (nwfile.equals(fileName)) {
				actual = enobjuploadFiles.VMFUploadListerrrecord().get(j).getText();
				break;
			}
		}
		Reporter.log("Actual : " + actual + " Expected : " + expected + " Verification Potential Network match");
		assertEquals(actual, expected, " Verification Potential Network match");
		Reporter.log("Actual : " + actual + " Expected : " + expected + " Verification of Potential Network match");
		assertEquals(actual, expected, " Verification of Potential Network match");
		softassert.assertAll();
		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10471 Add Legal ID Type column in VMF Template
	 * 
	 * (with valid LegalID)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFValidLegalId004() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		String legalID = lavanteUtils.generateRandomNumber9OnLength(9);
		LavanteUtils.editcsv(nwfile, 4, legalID);
		LavanteUtils.editcsv(nwfile, 16, "USA");

		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 22, "");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListerrrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;

				break;
			}

		}
		// Second verification
		if (flag == true) {

			flag = false;
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			dataMap.put("supplierName", expSname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			Reporter.log("In Search page");

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
				String suppname = enobjsupplierPage.getColumnText("Name", 0);
				Reporter.log("Added Supplier via VMF File," + expSname + ",In app:" + suppname);
				softassert.assertEquals(suppname, expSname, "Supplier name not matched");
				flag = true;
			}
		}

		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}
		softassert.assertAll();
		enviewSupplier.clickOnSupplier(expSname);
		lavanteUtils.waitForTime(2000);

		String expectedLegalID = legalID;
		String actualLegalID = enviewSupplier.taxIDNum().getText();

		Reporter.log("Actual : " + actualLegalID + " Expected : " + expectedLegalID + " Verification of LegalID");
		assertEquals(actualLegalID, expectedLegalID, " Verification of LegalID");

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.waitForTime(2000);
		// Navigating to ManageFiles Tab
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10727 Demo Feedback : Legal ID to be displayed irrespective of Legal
	 * ID Type
	 * 
	 * (Without LegalID and without LegalID type)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */

	@Test
	public void uploadVMFNoLegalIdType001() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4, "");
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 22, "");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");

				flag = true;
				break;
			}

		}
		// Second verification
		if (flag == true) {

			flag = false;
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			dataMap.put("supplierName", expSname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			Reporter.log("In Search page");

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
				String suppname = enobjsupplierPage.getColumnText("Name", 0);
				Reporter.log("Added Supplier via VMF File," + expSname + ",In app:" + suppname);
				softassert.assertEquals(suppname, expSname, "Supplier name not matched");
				flag = true;
			}
		}

		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}
		softassert.assertAll();

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("TakeControl", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.waitForTime(4000);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		boolean flag0 = false;
		if (!eneditCompanyProfile.EINRadioBtn().isSelected()) {
			flag0 = true;
		}
		boolean flag1 = false;
		if (!eneditCompanyProfile.SSNRadioBtn().isSelected()) {
			flag1 = true;
		}
		Reporter.log(flag1 + "  Verification of EIN radio btn not selected");

		assertTrue(flag0, " Verification of EIN radio btn is selected");
		Reporter.log(flag1 + "  Verification of SSN radio btn not selected");

		assertTrue(flag1, " Verification of SSN radio btn is selected");

		String expectedLegalIDValue = "";
		String actualLegalIDValue = eneditCompanyProfile.EINTxtBox().getAttribute("value");
		Reporter.log("Actual : " + actualLegalIDValue + " Expected : " + expectedLegalIDValue

				+ " Verification of LegalID in edit profile");
		assertEquals(actualLegalIDValue, expectedLegalIDValue, " Verification of LegalID in edit profile");

		lavanteUtils.click(eneditProfile.cancelBtn());
		lavanteUtils.waitForTime(4000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(expSname);
		lavanteUtils.waitForTime(2000);

		String expectedLegalIDStatus = "Unknown";
		String actualLegalIDStatus = enviewSupplier.legalIDstatus().getText();

		String expectedLegalID = "";
		String actualLegalID = enviewSupplier.taxIDNum().getText();
		String expectedLegalIDType = "";
		String actualLegalIDType = enviewSupplier.taxIDtype().getText();

		Reporter.log("Actual : " + actualLegalIDStatus + " Expected : " + expectedLegalIDStatus
				+ " Verification of LegalID status");
		assertEquals(actualLegalIDStatus, expectedLegalIDStatus, " Verification of LegalID satus failed");
		Reporter.log("Actual : " + actualLegalIDType + " Expected : " + expectedLegalIDType
				+ " Verification of LegalID type not displayed");
		assertEquals(actualLegalIDType, expectedLegalIDType, " Verification of LegalID type is displayed");

		Reporter.log(
				"Actual : " + actualLegalID + " Expected : " + expectedLegalID + " Verification of Without LegalID");
		assertEquals(actualLegalID, expectedLegalID, " Verification of Without LegalID");

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.waitForTime(2000);
		// Navigating to ManageFiles Tab
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10727 Demo Feedback : Legal ID to be displayed irrespective of Legal
	 * ID Type
	 * 
	 * (With valid LegalID and Empty LegalID type)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */

	@Test
	public void uploadVMFNoLegalIdType002() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		String legalID = lavanteUtils.generateRandomNumber9OnLength(9);
		LavanteUtils.editcsv(nwfile, 4, legalID);
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 22, "");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;
				break;
			}

		}
		// Second verification
		if (flag == true) {

			flag = false;
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			dataMap.put("supplierName", expSname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			Reporter.log("In Search page");

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
				String suppname = enobjsupplierPage.getColumnText("Name", 0);
				Reporter.log("Added Supplier via VMF File," + expSname + ",In app:" + suppname);
				softassert.assertEquals(suppname, expSname, "Supplier name not matched");
				flag = true;
			}
		}

		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}
		softassert.assertAll();

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("TakeControl", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.waitForTime(4000);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		boolean flag0 = false;
		if (!eneditCompanyProfile.EINRadioBtn().isSelected()) {
			flag0 = true;
		}
		boolean flag1 = false;
		if (!eneditCompanyProfile.SSNRadioBtn().isSelected()) {
			flag1 = true;
		}
		Reporter.log(flag1 + "  Verification of EIN radio btn not selected");

		assertTrue(flag0, " Verification of EIN radio btn is selected");
		Reporter.log(flag1 + "  Verification of SSN radio btn not selected");

		assertTrue(flag1, " Verification of SSN radio btn is selected");

		String expectedLegalIDValue = legalID;
		String actualLegalIDValue = eneditCompanyProfile.EINTxtBox().getAttribute("value");
		Reporter.log("Actual : " + actualLegalIDValue + " Expected : " + expectedLegalIDValue

				+ " Verification of LegalID in edit profile");
		assertEquals(actualLegalIDValue, expectedLegalIDValue, " Verification of LegalID in edit profile");

		lavanteUtils.click(eneditProfile.cancelBtn());
		lavanteUtils.waitForTime(4000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(expSname);
		lavanteUtils.waitForTime(2000);

		String expectedLegalIDStatus = "Provided";
		String actualLegalIDStatus = enviewSupplier.legalIDstatus().getText();

		String expectedLegalID = legalID;
		String actualLegalID = enviewSupplier.taxIDNum().getText();
		String expectedLegalIDType = "";
		String actualLegalIDType = enviewSupplier.taxIDtype().getText();

		Reporter.log(
				"Actual : " + actualLegalID + " Expected : " + expectedLegalID + " Verification of LegalID displayed");
		assertEquals(actualLegalID, expectedLegalID, " Verification of LegalID not displayed");
		Reporter.log("Actual : " + actualLegalIDType + " Expected : " + expectedLegalIDType
				+ " Verification of LegalID type not displayed");
		assertEquals(actualLegalIDType, expectedLegalIDType, " Verification of LegalID type is displayed");

		Reporter.log("Actual : " + actualLegalIDStatus + " Expected : " + expectedLegalIDStatus
				+ " Verification of LegalID Status");
		assertEquals(actualLegalIDStatus, expectedLegalIDStatus, " Verification of LegalID Status failed");

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.waitForTime(2000);
		// Navigating to ManageFiles Tab
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10727 Demo Feedback : Legal ID to be displayed irrespective of Legal
	 * ID Type
	 * 
	 * (With valid LegalID and LegalID type)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */

	@Test
	public void uploadVMFNoLegalIdType003() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		String legalID = lavanteUtils.generateRandomNumber9OnLength(9);
		LavanteUtils.editcsv(nwfile, 4, legalID);
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;
				break;
			}

		}
		// Second verification
		if (flag == true) {

			flag = false;
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			dataMap.put("supplierName", expSname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			Reporter.log("In Search page");

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
				String suppname = enobjsupplierPage.getColumnText("Name", 0);
				Reporter.log("Added Supplier via VMF File," + expSname + ",In app:" + suppname);
				softassert.assertEquals(suppname, expSname, "Supplier name not matched");
				flag = true;
			}
		}

		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}
		softassert.assertAll();

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("TakeControl", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.waitForTime(4000);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		boolean flag0 = false;
		if (eneditCompanyProfile.EINRadioBtn().isSelected()) {
			flag0 = true;
		}
		boolean flag1 = false;
		if (!eneditCompanyProfile.SSNRadioBtn().isSelected()) {
			flag1 = true;
		}
		Reporter.log(flag1 + "  Verification of EIN radio btn not selected");

		assertTrue(flag0, " Verification of EIN radio btn is selected");
		Reporter.log(flag1 + "  Verification of SSN radio btn not selected");

		assertTrue(flag1, " Verification of SSN radio btn is selected");

		String expectedLegalIDValue = legalID;
		String actualLegalIDValue = eneditCompanyProfile.EINTxtBox().getAttribute("value");
		Reporter.log("Actual : " + actualLegalIDValue + " Expected : " + expectedLegalIDValue

				+ " Verification of LegalID in edit profile");
		assertEquals(actualLegalIDValue, expectedLegalIDValue, " Verification of LegalID in edit profile");

		lavanteUtils.click(eneditProfile.cancelBtn());
		lavanteUtils.waitForTime(4000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		enviewSupplier.clickOnSupplier(expSname);
		lavanteUtils.waitForTime(2000);

		String expectedLegalIDStatus = "Provided";
		String actualLegalIDStatus = enviewSupplier.legalIDstatus().getText();
		String expectedLegalID = legalID;
		String actualLegalID = enviewSupplier.taxIDNum().getText();
		String expectedLegalIDType = "Employer Identification Number(EIN)";
		String actualLegalIDType = enviewSupplier.taxIDtype().getText();

		Reporter.log(
				"Actual : " + actualLegalID + " Expected : " + expectedLegalID + " Verification of LegalID displayed");
		assertEquals(actualLegalID, expectedLegalID, " Verification of LegalID not displayed");
		Reporter.log("Actual : " + actualLegalIDType + " Expected : " + expectedLegalIDType
				+ " Verification of LegalIDtype displayed");
		assertEquals(actualLegalIDType, expectedLegalIDType, " Verification of LegalIDtype not displayed");

		Reporter.log("Actual : " + actualLegalIDStatus + " Expected : " + expectedLegalIDStatus
				+ " Verification of LegalID Status");
		assertEquals(actualLegalIDStatus, expectedLegalIDStatus, " Verification of LegalID Status failed");

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.waitForTime(2000);
		// Navigating to ManageFiles Tab
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * SIM-10727 Demo Feedback : Legal ID to be displayed irrespective of Legal
	 * ID Type
	 * 
	 * (With Empty LegalID and with LegalID type)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */

	@Test
	public void uploadVMFNoLegalIdType004() throws Exception {
		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Unique Upload VMF at:" + LavanteUtils.currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		Reporter.log("File:" + nwfile);

		String id = "" + LavanteUtils.randomnum(9999999);
		String expSname = "AutoSP" + LavanteUtils.randomnum();
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4, "");
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 24, "");

		Reporter.log("File 2:" + nwfile);
		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status Before upload");

		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Status after upload");
		Reporter.log("Upload File:");

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();

			if (fname.equalsIgnoreCase(nwfile)) {

				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");

				String apperrrecrd = enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				String experrrcrd = "1";
				Reporter.log("Uploaded file Unique Record Count,Expected:" + experrrcrd + ",Actuals:" + apperrrecrd);
				softassert.assertEquals(apperrrecrd, experrrcrd, "Unique record not matched");
				flag = true;
				break;
			}

		}
		// Second verification
		if (flag == true) {

			flag = false;
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(null);

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			dataMap.put("supplierName", expSname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			Reporter.log("In Search page");

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
				String suppname = enobjsupplierPage.getColumnText("Name", 0);
				Reporter.log("Added Supplier via VMF File," + expSname + ",In app:" + suppname);
				softassert.assertEquals(suppname, expSname, "Supplier name not matched");
				flag = true;
			}
		}

		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}
		softassert.assertAll();
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("TakeControl", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.waitForTime(4000);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		boolean flag0 = false;
		if (eneditCompanyProfile.EINRadioBtn().isSelected()) {
			flag0 = true;
		}
		boolean flag1 = false;
		if (!eneditCompanyProfile.SSNRadioBtn().isSelected()) {
			flag1 = true;
		}
		Reporter.log(flag1 + "  Verification of EIN radio btn not selected");

		assertTrue(flag0, " Verification of EIN radio btn is selected");
		Reporter.log(flag1 + "  Verification of SSN radio btn not selected");

		assertTrue(flag1, " Verification of SSN radio btn is selected");

		String expectedLegalIDValue = "";
		String actualLegalIDValue = eneditCompanyProfile.EINTxtBox().getAttribute("value");
		Reporter.log("Actual : " + actualLegalIDValue + " Expected : " + expectedLegalIDValue

				+ " Verification of LegalID in edit profile");
		assertEquals(actualLegalIDValue, expectedLegalIDValue, " Verification of LegalID in edit profile");

		lavanteUtils.click(eneditProfile.cancelBtn());
		lavanteUtils.waitForTime(4000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		enviewSupplier.clickOnSupplier(expSname);
		lavanteUtils.waitForTime(2000);

		String expectedLegalIDStatus = "Unknown";
		String actualLegalIDStatus = enviewSupplier.legalIDstatus().getText();
		String expectedLegalIDType = "Employer Identification Number(EIN)";
		String actualLegalIDType = enviewSupplier.taxIDtype().getText();
		String expectedLegalID = "";
		String actualLegalID = enviewSupplier.taxIDNum().getText();

		Reporter.log("Actual : " + actualLegalID + " Expected : " + expectedLegalID
				+ " Verification of LegalID not displayed");
		assertEquals(actualLegalID, expectedLegalID, " Verification of LegalID displayed");
		Reporter.log("Actual : " + actualLegalIDStatus + " Expected : " + expectedLegalIDStatus
				+ " Verification of LegalID Status");
		assertEquals(actualLegalIDStatus, expectedLegalIDStatus, " Verification of LegalID Status failed");

		Reporter.log("Actual : " + actualLegalIDType + " Expected : " + expectedLegalIDType
				+ " Verification of LegalIDtype displayed");
		assertEquals(actualLegalIDType, expectedLegalIDType, " Verification of LegalIDtype not displayed");

		lavanteUtils.fluentwait(enviewSupplier.BackToSearchLink());
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.waitForTime(2000);
		// Navigating to ManageFiles Tab
		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended for Upload VMF at:" + LavanteUtils.currenttime());

	}

	/**
	 * After method is to refresh the page
	 * 
	 * @author Subhash.BV
	 */
	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.refreshPage();
		enobjhomePage.popupclose();

	}

	/**
	 * After Class logout and driver quitting
	 * 
	 * @author Subhash.BV
	 */
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
