package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

import static org.testng.Assert.assertEquals;

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

/**
 * Created on 23-3-2017
 * 
 * @author Subhash BV
 *
 */
public class UploadVMFFileDUNSField extends PageInitiator {

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
	 * SIM-9336 Add DUNS# As part of VMF Upload
	 * 
	 * (Without DUNS number)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFemptyDUNS001() throws Exception {
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
		LavanteUtils.editcsv(nwfile, 4, "" + lavanteUtils.generateRandomNumber9OnLength(9));
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

		String expectedDUNSno = "";
		String actualDUNSno = enviewSupplier.doyouhaveDuns().getText();

		Reporter.log(
				"Actual : " + actualDUNSno + " Expected : " + expectedDUNSno + " Verification of Without DUNS number");
		assertEquals(actualDUNSno, expectedDUNSno, " Verification of Without DUNS number");

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
	 * SIM-9336 Add DUNS# As part of VMF Upload
	 * 
	 * (With already existing DUNS number)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFExistingDUNS002() throws Exception {
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
		String dunsquery = "Select Top 1 DunsNumber  from Supplier Where Len( IsNull(DunsNumber,0))>8 and LavanteUID in (select LavanteUID from Relationship where customerID="
				+ customerid + ") ";
		dunsquery = lavanteUtils.fetchDBdata(dunsquery);
		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4, "" + lavanteUtils.generateRandomNumber9OnLength(9));

		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "United States");
		LavanteUtils.editcsv(nwfile, 24, "" + dunsquery);

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

		String actual = "";
		String expected = "" + 1;
		for (int j = 0; j < enobjuploadFiles.ListUploadFile().size(); j++) {
			String fileName = enobjuploadFiles.ListUploadFile().get(j).getText();
			if (nwfile.equals(fileName)) {
				actual = enobjuploadFiles.VMFUploadListntwrkmatchrecord().get(j).getText();
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
	 * SIM-9336 Add DUNS# As part of VMF Upload
	 * 
	 * (With invalid DUNS number 12-65-6565-8)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFInvalidDUNS003() throws Exception {
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
		LavanteUtils.editcsv(nwfile, 4, "" + lavanteUtils.generateRandomNumber9OnLength(9));
		LavanteUtils.editcsv(nwfile, 16, "USA");

		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "");
		LavanteUtils.editcsv(nwfile, 24, "" + "12-65-6565-8");

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
	 * SIM-9336 Add DUNS# As part of VMF Upload
	 * 
	 * (with valid DUNS no)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFValidDUNS004() throws Exception {
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
		LavanteUtils.editcsv(nwfile, 4, "" + lavanteUtils.generateRandomNumber9OnLength(9));
		LavanteUtils.editcsv(nwfile, 16, "USA");

		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 21, "USA");
		LavanteUtils.editcsv(nwfile, 22, "");
		String DunsNo = lavanteUtils.generateRandomNumber9OnLength(9);
		LavanteUtils.editcsv(nwfile, 24, "" + DunsNo);

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

		String expectedDUNSno = DunsNo;
		String actualDUNSno = enviewSupplier.DUNSNum().getText();

		Reporter.log(
				"Actual : " + actualDUNSno + " Expected : " + expectedDUNSno + " Verification of Without DUNS number");
		assertEquals(actualDUNSno, expectedDUNSno, " Verification of Without DUNS number");

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
