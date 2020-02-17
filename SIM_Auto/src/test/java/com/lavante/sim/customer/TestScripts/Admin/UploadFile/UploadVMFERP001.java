package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class UploadVMFERP001 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerid = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Subhas.BV
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

		List listofdatafrm = lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	@BeforeMethod
	public void before() {

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Files");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
	}

	/**
	 * Upload VMF with Empty ERPName and verify the Erroneous records and file
	 * process log message(ERP System Name column is required field)
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadEmptyERPNameTest() throws Exception {
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Upload VMF with Empty ERPName and verify the Erroneous records and file:"
				+ LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");
		String id = "" + LavanteUtils.randomnum();
		String expSname = "AutoSub" + LavanteUtils.randomnum();
		LavanteUtils.editcsv(nwfile, 0, "");
		LavanteUtils.editcsv(nwfile, 1, id);
		LavanteUtils.editcsv(nwfile, 2, expSname);
		LavanteUtils.editcsv(nwfile, 4, "" + lavanteUtils.generateRandomNumber9OnLength(9));
		LavanteUtils.editcsv(nwfile, 9, "");
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 24, "" + lavanteUtils.generateRandomNumber9OnLength(9));

		String add2 = LavanteUtils.Readcsv(nwfile, 10);
		String add3 = LavanteUtils.Readcsv(nwfile, 11);

		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("UploadFile", nwfile);

		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Previous File Status not Matched");

		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		Status = enobjuploadFiles.uploadFileGrid(dataMap);

		Assert.assertTrue(Status, "Current File Status not Matched");
		Reporter.log("Upload File:" + nwfile);
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		boolean status0 = false;
		boolean status1 = false;
		String expectedErrorMsg = "ERP System Name column is required field";
		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			Reporter.log("Uploaded file available in the list");
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();
			if (fname.equalsIgnoreCase(nwfile)) {
				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");
				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");
				Status = true;
				Assert.assertTrue(Status, "Current File Verification Status not Matched");
				String count = enobjuploadFiles.VMFUploadListerrrecord().get(i).getText();
				Reporter.log("Uploaded file Erroneous records count ,Expected: 1 ,Actuals:" + count);
				if (Integer.parseInt(count) == 1) {
					status0 = true;
				}
				Assert.assertTrue(status0, "Uploaded file Erroneous records count not Matched");
				enobjuploadFiles.VMFUploadListTotalCount().get(i).click();
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.switchtoFrame(enobjuploadFiles.IframeFileProcessLogMsg());
				String actualErrorMsg = lavanteUtils.getValue(enobjuploadFiles.GetVMFFileProcessLogMsg(), "title");
				Reporter.log("ERP System Name column is required field msg  ,Expected: " + expectedErrorMsg
						+ " ,Actuals:" + actualErrorMsg);

				if (actualErrorMsg.contains(expectedErrorMsg)) {
					status1 = true;
				}
				Assert.assertTrue(status1,
						" ERP System Name column is required field msg not displayed in error log file");
				break;
			}
		}

		Reporter.log("Test Ended for Upload VMF with Empty ERPName and verify the Erroneous records and file"
				+ LavanteUtils.currenttime());
		System.out.println("----------Test Ended-Upload VMF verify Empty ERPName-------");
	}

	/**
	 * Upload VMF and search with the Supplier name and ERPID
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Subhas.BV
	 * @throws SQLException
	 * 
	 */
	@Test
	public void uploadVMFFileSearchBySupplierNameERPIDTest() throws Exception {
		SoftAssert softassert = new SoftAssert();
		Reporter.log("Test Started for Upload VMF and search by ERPID:" + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");

		String supplierERPID = "" + LavanteUtils.randomnum();
		String supplierName = "AutoSub" + LavanteUtils.randomnum();

		String ERPName = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID=" + customerid + "))  and LanguageID=50";
		ERPName = lavanteUtils.fetchDBdata(ERPName);

		LavanteUtils.editcsv(nwfile, 0, ERPName);
		LavanteUtils.editcsv(nwfile, 1, supplierERPID);
		LavanteUtils.editcsv(nwfile, 2, supplierName);
		LavanteUtils.editcsv(nwfile, 4, "" + lavanteUtils.generateRandomNumber9OnLength(9));
		LavanteUtils.editcsv(nwfile, 9, "");
		LavanteUtils.editcsv(nwfile, 18, "" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 24, "" + lavanteUtils.generateRandomNumber9OnLength(9));

		String add2 = LavanteUtils.Readcsv(nwfile, 10);
		String add3 = LavanteUtils.Readcsv(nwfile, 11);

		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("UploadFile", nwfile);

		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Previous File Status not Matched");

		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);

		Status = enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status, "Current File Status not Matched");

		Reporter.log("Upload File:" + nwfile);

		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

		for (int i = 0; i < enobjuploadFiles.ListUploadFile().size(); i++) {
			Reporter.log("Uploaded file available in the list");
			String fname = enobjuploadFiles.ListUploadFile().get(i).getText();
			if (fname.equalsIgnoreCase(nwfile)) {
				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus = "Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File Status not matched");
				Status = true;
				break;
			}
		}
		Assert.assertTrue(Status, "Current File Verification Status not Matched");

		dataMap.clear();
		dataMap.put("maintab", "customerSupplierSearch");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("supplierName", supplierName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		boolean status0 = false;
		String actualSupplierName = null;
		for (int i = 0; i < enobjsupplierPage.supplist().size(); i++) {
			actualSupplierName = enobjsupplierPage.supplist().get(i).getText();
			if (supplierName.equalsIgnoreCase(actualSupplierName)) {
				status0 = true;
				break;
			}
		}
		Reporter.log("Basic search by supplier name, Expected : " + supplierName + " , Actual : " + actualSupplierName);
		Assert.assertTrue(status0,
				"Basic search by supplier name, Expected : " + supplierName + " , Actual : " + actualSupplierName);

		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(ensupplierAdvanced.advtab());
		lavanteUtils.waitForTime(2000);
		dataMap.clear();
		dataMap.put("Tab", "CustomerProfile");
		dataMap.put("CustomerProfile", "");
		String suppErpid = "Equals To," + supplierERPID;
		System.out.println(suppErpid + " sssss");
		dataMap.put("SupplierERPID", suppErpid);
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		boolean status1 = false;
		String actualERPID = null;
		for (int i = 0; i < enobjsupplierPage.suppid().size(); i++) {
			actualERPID = enobjsupplierPage.suppid().get(i).getText();
			if (supplierERPID.equalsIgnoreCase(actualERPID)) {
				status1 = true;
				break;
			}
		}
		Reporter.log("Advance search by ERPID name, Expected : " + supplierERPID + " , Actual : " + actualERPID);
		Assert.assertTrue(status1,
				"Advance search by ERPID , Expected : " + supplierERPID + " , Actual : " + actualERPID);

		Reporter.log("Test Ended for Upload VMF and search by ERPID " + LavanteUtils.currenttime());
		System.out.println("----------Test Ended-Upload VMF and search by ERPID-------");
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author Subhas.BV
	 */
	@AfterMethod
	public void SetupAftermethod() {
		enobjhomePage.backtoSearch();
		enobjhomePage.popupclose();

	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author Subhas.BV
	 */
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
