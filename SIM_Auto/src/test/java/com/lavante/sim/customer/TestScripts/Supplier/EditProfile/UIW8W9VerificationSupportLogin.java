package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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
 * Created on 1-12-2016 Created for verify LaunchWizardW8W9 buttons
 * 
 * @author Subhash.BV
 *
 */

public class UIW8W9VerificationSupportLogin extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String getCustomerName = "";

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
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		getCustomerName = "select Name from customer where CustomerID in (select max(CustomerID) from CTIWebserviceProperties)";
		getCustomerName = lavanteUtils.fetchDBdata(getCustomerName);
		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(enobjhomePage.AllCustomersDropDwn());
		lavanteUtils.click(enobjhomePage.AllCustomersDropDwn());
		lavanteUtils.typeinEdit(getCustomerName, enobjhomePage.AllCustomersDropDwnTxtBox);
		lavanteUtils.selectvalueFrmDpdn(getCustomerName);
		lavanteUtils.waitForTime(5000);

		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * SIM-9679 Enable upload button for support user
	 * 
	 * @throws IOException
	 * @author Subhas.BV
	 */
	@Test
	public void verifyLaunchW9WizardAndUploadButtonSupportLoginTest() throws Exception {
		Reporter.log("Test Started for verifyLaunchW9WizardAndUploadButtonSupportLoginTest:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		String query="update Customer Set IsW8Enabled=1,IsW9Enabled=1 where Name='"+getCustomerName+"'";
		lavanteUtils.UpdateDB(query);
	
		dataMap.put("Tab", "Legal");
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		dataMap.put("supplierNameRandom", "");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String supplierName = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);
		boolean flag = false;
		if (lavanteUtils.isElementDisplayed(eneditLegal.W9LaunchWizardBtn())
				&& lavanteUtils.isElementDisplayed(eneditLegal.W9UploadDocumentBtn())) {
			flag = true;
		}
		SoftAssert softAssert= new SoftAssert();
		Reporter.log(" Launch W-9 Wizard verifed, Expected: true, Actual:" + flag);
		softAssert.assertTrue(flag, " Launch W-9 Wizard verification Failed/Not Present , Expected: true, Actual:" + flag);

		String uploadFileName = lavanteUtils.CopyFile("pdfSample.pdf");
		lavanteUtils.click(eneditLegal.W9UploadDocumentBtn());
		lavanteUtils.switchtoFrame(eneditLegal.IframeW9DocUpload());
		lavanteUtils.uploadFile(uploadFileName, eneditLegal.BrowseTaxW9Btn());
		lavanteUtils.click(eneditLegal.SaveBtn());
		lavanteUtils.switchtoFrame(null);

		boolean flag0 = false;
		String actualFile = null;
		List<WebElement> noW9TaxFiles = eneditLegal.GetW9TaxUploadedFilesList();
		for (WebElement element : noW9TaxFiles) {
			if (uploadFileName.equals(element.getText())) {
				flag0 = true;
				actualFile = element.getText();
				break;
			}
		}
		Reporter.log(" Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag0,"Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		dataMap.clear();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supplierName);
		
		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "Company Profile");
		enviewSupplier.selectTab(dataMap);
		boolean flag1 = false;
		String actualFileName = null;
		List<WebElement> noW9TaxFileNames = enviewSupplier.getListOfW9TaxFilesLink();
		for (WebElement element : noW9TaxFileNames) {
			if (uploadFileName.equals(element.getText())) {
				flag1 = true;
				actualFileName = element.getText();
				break;
			}
		}
		Reporter.log(" Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFileName);
		softAssert.assertTrue(flag1, "Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:"+ actualFileName);
		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		lavanteUtils.deleteFile(uploadFileName);
		
		softAssert.assertAll();

		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * SIM-9679 Enable upload button for support user
	 * 
	 * @throws IOException
	 * @author Subhas.BV
	 */
	@Test
	public void verifyLaunchW8WizardAndUploadButtonSupportLoginTest() throws Exception {
		Reporter.log("Test Started for verifyLaunchW8WizardAndUploadButtonSupportLoginTest:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		SoftAssert softAssert=new SoftAssert();
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());

		String query="update Customer Set IsW8Enabled=1,IsW9Enabled=1 where Name='"+getCustomerName+"'";
		lavanteUtils.UpdateDB(query);
		
		dataMap.put("Tab", "Legal");
		dataMap.put("RegCountry", "Not Equal To,United States");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		dataMap.put("supplierNameRandom", "");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String supplierName = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		boolean flag = false;
		if (lavanteUtils.isElementDisplayed(eneditCustomerProfile.W8LaunchWizardBtn())
				&& lavanteUtils.isElementDisplayed(eneditCustomerProfile.W8UploadDocumentBtn())) {
			flag = true;
		}

		Reporter.log(" Launch W-8 Wizard verifed, Expected: true, Actual:" + flag);
		softAssert.assertTrue(flag, " Launch W-8 Wizard verification Failed/Not Present , Expected: true, Actual:" + flag);
		
		String uploadFileName = lavanteUtils.CopyFile("pdfSample.pdf");
		lavanteUtils.fluentwait(eneditCustomerProfile.W8UploadDocumentBtn());
		lavanteUtils.click(eneditCustomerProfile.W8UploadDocumentBtn());

		dataMap.put("FileName", uploadFileName);
		dataMap.put("SelectCurrentDate", "");
		eneditCustomerProfile.uploadW8TaxDocument(dataMap);
		lavanteUtils.waitForTime(3000);
		boolean flag0 = false;
		String actualFile = null;
		List<WebElement> noW9TaxFiles = eneditCustomerProfile.GetW8TaxUploadedFilesList();
		for (WebElement element : noW9TaxFiles) {
			if (uploadFileName.equals(element.getText())) {
				flag0 = true;
				actualFile = element.getText();
				break;
			}
		}
		Reporter.log(" Tax (W-8) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag0,"Tax (W-8) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		dataMap.clear();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supplierName);
		lavanteUtils.waitForTime(3000);
		
		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewRelationshipSpecificDetails");
		enviewSupplier.selectTab(dataMap);

		boolean flag1 = false;
		String actualFileName = null;
		List<WebElement> noW8TaxFileNames = enviewSupplier.getListOfW8TaxFilesLink();
		for (WebElement element : noW8TaxFileNames) {
			if (uploadFileName.equals(element.getText())) {
				actualFileName = uploadFileName;
				flag1 = true;
				break;
			}
		}
		Reporter.log(" Tax (W-8) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFileName);
		softAssert.assertTrue(flag1, "Tax (W-8) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:"+ actualFileName);
		lavanteUtils.click(enviewSupplier.BackToSearchLink());

		lavanteUtils.deleteFile(uploadFileName);
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	@AfterMethod
	public void afterMethod() throws FileNotFoundException, IOException, SQLException{
		String query="update Customer Set IsW8Enabled=0,IsW9Enabled=0 where Name='"+getCustomerName+"'";
		lavanteUtils.UpdateDB(query);
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
