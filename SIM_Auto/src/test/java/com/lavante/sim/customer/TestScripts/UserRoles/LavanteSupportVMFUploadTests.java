package com.lavante.sim.customer.TestScripts.UserRoles;

import java.util.LinkedHashMap;
import java.util.List;

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

public class LavanteSupportVMFUploadTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	LinkedHashMap<String, String> LdataMap = null;

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
		List listofdatafrm = lavanteUtils.login("LavanteSupportRole", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * 
	 * UserRoles: Lavante support role should be able to resolve potential
	 * network match for suppliers.
	 * 
	 * Commented as the code is not complete
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	//@Test
	public void resolveNetworkPotentialMatchTest() throws Exception {
		Reporter.log("Test Started for resolveNetworkPotentialMatchTest : " + LavanteUtils.currenttime());

		boolean flag = false;
		SoftAssert softassert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String nwfile = LavanteUtils.CopyFile("VMF_Template.csv");

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("Search", "");
		dataMap.put("SupplierID", "1");
		dataMap.put("ProfStatus", "Pending Validation");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		String suppname = enobjsupplierPage.supplist().get(0).getText();
		String supid = enobjsupplierPage.suppid().get(0).getText();

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(enobjhomePage.AllCustomersDropDwn());
		
		List<String> customers = lavanteUtils.listelement(null);
		int random = lavanteUtils.randomnum(customers.size());
		String customerName = customers.get(random);
		lavanteUtils.typeinEdit(customers.get(random), enobjhomePage.AllCustomersDropDwnTxtBox);
		lavanteUtils.selectvalueFrmDpdn(customerName);

		// Manage Files Tab
		LdataMap.put("maintab", "customerUploadFiles");
		enobjhomePage.selectTab(LdataMap);

		String getCustomerid = "select CustomerID from Customer where [Name]='" + customerName + "'";
		getCustomerid = lavanteUtils.fetchDBdata(getCustomerid);
		String ERPNAMe = "select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select ERPID from  ERPCustomerMap where CustomerID=" + getCustomerid + "))  and LanguageID=50";
		ERPNAMe = lavanteUtils.fetchDBdata(ERPNAMe);

		String getLegalId = "select max(dbo.lcfn_decrypt(s.legalidentifier,'TripTheLightFandango')) from supplier s inner join relationship r on s.LavanteUID = r.LavanteUID where s.SupplierName='"
				+ suppname + "'";
		getLegalId = lavanteUtils.fetchDBdata(getLegalId);

		LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
		LavanteUtils.editcsv(nwfile, 1, supid);
		LavanteUtils.editcsv(nwfile, 2, suppname);
		LavanteUtils.editcsv(nwfile, 4, getLegalId);
		LavanteUtils.editcsv(nwfile, 18, "AutoSP" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com");
		LavanteUtils.editcsv(nwfile, 24, "" + lavanteUtils.generateRandomNumber9OnLength(9));

		Reporter.log("Edit CSV:");

		dataMap.put("UploadType", "Supplier File");
		dataMap.put("UploadFile", nwfile);

		dataMap.put("Status", "Process Completed");
		boolean Status = enobjuploadFiles.uploadFileGrid(dataMap);
		if (Status == true) {

			dataMap.put("UploadOK", "OK");
			enobjuploadFiles.UploadFile(dataMap);

			enobjuploadFiles.uploadFileGrid(dataMap);
			Reporter.log("Upload File:");

			lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

			for (int i = 0; i < enobjuploadFiles.ListUploadFile().size();) {

				Reporter.log("Uploaded file available in the list");
				String fname = enobjuploadFiles.ListUploadFile().get(0).getText();
				Reporter.log("Uploaded file,Expected:" + fname + ",Actuals:" + nwfile);
				softassert.assertEquals(fname, nwfile, "File name not matched");

				String status = enobjuploadFiles.ListuploadStatus().get(0).getText();
				String expsttaus = "Update Process Completed";
				Reporter.log("Uploaded file status,Expected:" + expsttaus + ",Actuals:" + status);
				softassert.assertEquals(status, expsttaus, "File name not matched");
				break;

			}

		}
		if (flag == false) {
			softassert.assertTrue(false, "Data not matched");

		}

		LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
		dataMaps.put("maintab", "Files");
		enobjhomePage.selectTab(dataMaps);

		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
	}


	@AfterMethod
	public void SetupAftermethod() {
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
