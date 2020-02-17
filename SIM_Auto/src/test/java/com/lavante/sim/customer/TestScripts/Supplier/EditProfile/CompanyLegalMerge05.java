package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class CompanyLegalMerge05 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String username = null;
	String supName = null;
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

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
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		username = LdataMap.get(username);
		customerID = (String) listofdatafrm.get(1);

	}

	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException {

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		supName = LdataMap.get("supname");

		lavanteUtils.switchtoFrame(null);
		LdataMap.put("maintab", "customerSupplierSearch");
		LdataMap.put("subtab", "customerSupplierLegalID");
		enobjhomePage.selectTab(LdataMap);

	}

	/***
	 * SIM-12790 Need to show the contact information who is merging supplier
	 * record
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void validateMergingSupplierRecordTest() throws Exception {
		Reporter.log("------------Test started for validateMergingSupplierRecordTest -------------------"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert = new SoftAssert();

		String query = "update login set UserRoleID=47 where LoginID in (select LoginID from [Login] where ContactID in (select ContactID from Contact where  Email='"
				+ username + "'))";
		lavanteUtils.UpdateDB(query);

		String updateQuery = "update Customer set Registration_ISOCountryID=null, IsW9Enabled=0 where CustomerID in (select CustomerID from Customer_Contact_Map where ContactID in (select ContactID from Contact where  Email='"
				+ username + "'))";
		lavanteUtils.UpdateDB(updateQuery);

		BeforeMethod();

		lavanteUtils.fluentwait(enobjLegalID.filterByWithLegalID());
		lavanteUtils.click(enobjLegalID.filterByWithLegalID());
		lavanteUtils.fluentwait(enobjLegalID.filterByPendingValidation());
		lavanteUtils.click(enobjLegalID.filterByPendingValidation());

		lavanteUtils.fluentwait(enobjLegalID.ListSupplier().get(0));

		String supplierNameA = lavanteUtils.getText(enobjLegalID.ListSupplier().get(0));
		String SupplierLegalNameA = lavanteUtils.getText(enobjLegalID.ListSupplierLegalName().get(0));
		String supplierNameB = lavanteUtils.getText(enobjLegalID.ListSupplier().get(1));
		String SupplierLegalNameB = lavanteUtils.getText(enobjLegalID.ListSupplierLegalName().get(1));
		String legalID = lavanteUtils.getText(enobjLegalID.ListSupplierLegalID().get(1));

		dataMap.put("subtab", "customerSupplierSearch");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("supplierName", supplierNameA);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		dataMap.put("Name", supplierNameA);
		enobjsupplierPage.selectSupplier(dataMap);

		dataMap.clear();
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.ProfileAction(dataMap);

		lavanteUtils.switchtoFrame(null);
		if (lavanteUtils.isElementDisplayed(eneditProfile.TakecontrolBtn())) {
			lavanteUtils.click(eneditProfile.TakecontrolBtn());
		}
		lavanteUtils.fluentwait(eneditProfile.saveExitbtn());
		dataMap.clear();
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		// Upload W9 Document
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
			actualStatus = eneditLegal.editw9statusdeac().get(i).getText();
		}

		Reporter.log(" Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag,
				"Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		Reporter.log(" w 9 status verification in edit profile, Expected: " + Expw9status + ", Actual:" + actualStatus);
		softAssert.assertEquals(actualStatus, Expw9status,
				"w 9 status verification in edit profile, Expected: " + Expw9status + ", Actual:" + actualStatus);

		lavanteUtils.fluentwait(eneditCompanyProfile.ListEditBtn().get(0));
		lavanteUtils.click(eneditCompanyProfile.ListEditBtn().get(2));

		lavanteUtils.fluentwait(eneditLegal.EditEINTxtBox());
		eneditLegal.EditEINTxtBox().clear();
		lavanteUtils.typeinEdit(legalID, eneditLegal.EditEINTxtBox());

		lavanteUtils.fluentwait(eneditProfile.Finish_Profile_Button());
		dataMap.clear();
		dataMap.put("Save", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.fluentwait(eneditLegal.Iframe_Merge_popup());
		lavanteUtils.switchtoFrame(eneditLegal.Iframe_Merge_popup());

		String getSupplierNameB = lavanteUtils.getText(eneditLegal.getBusinessName());
		lavanteUtils.click(eneditLegal.Yes_Merge());

		Reporter.log("Verify the supplier that is getting merged, Actual supplier : " + SupplierLegalNameB
				+ ", Expected supplier : " + getSupplierNameB);

		softAssert.assertEquals(getSupplierNameB, SupplierLegalNameB,
				"Verify the supplier that is getting merged falied, Actual supplier : " + SupplierLegalNameB
						+ ", Expected supplier : " + getSupplierNameB);

		String actualConfirmationMsg = "Supplier profile of " + SupplierLegalNameA + " has been merged with "
				+ SupplierLegalNameB + " successfully";
		WebElement ele = driver.findElement(By.cssSelector("div[class*='dialog undefined']"));
		String expectedConfirmationMsg = lavanteUtils.getText(ele);

		Reporter.log("Verify the supplier legal name that is getting merged, Actual supplier : " + SupplierLegalNameB
				+ ", Expected supplier : " + getSupplierNameB);

		softAssert.assertEquals(actualConfirmationMsg, expectedConfirmationMsg,
				"Verify the supplier legal name that is getting merged, Actual supplier : " + SupplierLegalNameB
						+ ", Expected supplier : " + getSupplierNameB);

		lavanteUtils.fluentwait(eneditCompanyProfile.OkYesBtn());
		lavanteUtils.click(eneditCompanyProfile.OkYesBtn());

		dataMap.clear();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		dataMap.clear();
		dataMap.put("supplierName", supplierNameB);
		dataMap.put("InactiveSup", "");
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supplierNameB);
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
		Reporter.log(" Tax (W-9) Uploaded File verifcation for the merged supplier record , Expected: " + uploadFileName
				+ ", Actual:" + actualFile);
		softAssert.assertTrue(flag,
				"Tax (W-9) Uploaded file verifcation failed for the merged supplier record , Expected: "
						+ uploadFileName + ", Actual:" + actualFile);

		Reporter.log(" w 9 status verification in view profile for the merged supplier record , Expected: "
				+ Expw9status + ", Actual:" + actualStatus);
		softAssert.assertEquals(actualStatus, Expw9status,
				"w 9 status verification in view profile failed for the merged supplier record , Expected: "
						+ Expw9status + ", Actual:" + actualStatus);

		softAssert.assertAll();

		Reporter.log("------------Test ended for validateMergingSupplierRecordTest -------------------"	+ currenttime());
	}

	@AfterMethod
	public void aftermethod() throws FileNotFoundException, IOException, SQLException {
		String query = "update login set UserRoleID=14 where LoginID in (select LoginID from [Login] where ContactID in (select ContactID from Contact where  Email='"
				+ username + "'))";
		lavanteUtils.UpdateDB(query);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);
	}

	@AfterClass
	public void close() {
		enobjhomePage.logout();
		quitBrowser();

	}

}
