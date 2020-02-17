/*package com.lavante.sim.customer.TestScripts.Invite;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ExtendInviteCustomFieldsTC extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String loginUser = "";

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
		List listofdatafrm = lavanteUtils.login("Sanity", browser);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		loginUser = dataMap.get("username");
		System.out.println("Login User " + loginUser);
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();
	}

	@Test
	public void extendInviteCustomFiledsTest() throws Exception {
		Reporter.log("Test Started for extendInviteCustomFiledsTest : " + LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		dataMap.put("maintab", "customerSupplierSearch");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());

		Reporter.log("Invite New Supplier:");
		String supName = "SupAuto" + lavanteUtils.generateRandomNumber9OnLength(9);
		String emailId = "A" + lavanteUtils.generateRandomNumber9OnLength(9) + "@gmail.com";

		dataMap.put("supplierName", supName);
		dataMap.put("inviteorg", "any");
		dataMap.put("contactName", supName);
		dataMap.put("email", emailId);
		dataMap.put("inviteorg", "any");

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.click(enobjInvitenewSupplier.InviteNewSupplierLinkKbtn());
		enobjInvitenewSupplier.fillInviteDetails(dataMap);
		dataMap.put("Next", "");
		enobjInvitenewSupplier.formSuppAction(dataMap);

		Properties config = readProperties("CustomFieldLocators.properties", "data");
		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(enobjInvitenewSupplier.NextBtn());
		driver.findElement(By.cssSelector(config.getProperty("GPCompanyDropDwn"))).click();
		lavanteUtils.selectFrmDpdn("any");
		driver.findElement(By.cssSelector(config.getProperty("VendorTypeDropDwn"))).click();
		lavanteUtils.selectFrmDpdn("GP");
		String proNumber = lavanteUtils.generateRandomNumber9OnLength(9);
		String clientComName = "ComName" + proNumber;
		driver.findElement(By.cssSelector(config.getProperty("ClientCompanyNameTxtBox"))).sendKeys(clientComName);
		driver.findElement(By.cssSelector(config.getProperty("ProjectNumberTxtBox"))).sendKeys(proNumber);

		driver.findElement(By.xpath(config.getProperty("GovernmentProjectRadioBtn"))).click();
		driver.findElement(By.xpath(config.getProperty("ProvideServicesRadioBtn"))).click();
		driver.findElement(By.xpath(config.getProperty("ConfidentialEmailRadioBtn"))).click();
		lavanteUtils.fluentwait(enobjInvitenewSupplier.NextBtn());
		lavanteUtils.click(enobjInvitenewSupplier.NextBtn());

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(enobjInvitenewSupplier.suppInvitebtn());
		driver.findElement(By.cssSelector(config.getProperty("ApprovedITSecurityLevelDropDwn"))).click();
		lavanteUtils.selectFrmDpdn("any");

		dataMap.clear();
		dataMap.put("invite", "");
		enobjInvitenewSupplier.formSuppAction(dataMap);

		lavanteUtils.waitForTime(3000);
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		dataMap.put("supplierName", supName);
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		String invitedID1 = enobjsupplierPage.getColumnText("Invitation ID", 0);
		enviewSupplier.clickOnSupplier(supName);

		dataMap.clear();
		dataMap.put("maintab", "viewEnterpriseInformation");
		enviewSupplier.selectTab(dataMap);

		String actualClientCompanyName = lavanteUtils.getText(enviewSupplier.GetClientCompanyName());
		String actualProjectNumber = lavanteUtils.getText(enviewSupplier.GetProjectNumber());
		Reporter.log("Custom fields validation :");
		softAssert.assertEquals(actualClientCompanyName, clientComName,
				" Verification failed for client company field custom field, Expected : " + clientComName
						+ " , Actual : " + actualClientCompanyName);
		softAssert.assertEquals(actualProjectNumber, proNumber,
				" Verification failed for project number field custom field, Expected : " + proNumber + " , Actual : "
						+ actualProjectNumber);
		String actualInviteIDSelectedByDefault = lavanteUtils.getText(enviewSupplier.GetInviteIdSelectedInDropDwn());

		Reporter.log("Invited supplier inviteID validation :");
		softAssert.assertEquals(actualInviteIDSelectedByDefault, invitedID1,
				" Verification failed for Invite ID, Expected : " + invitedID1 + " , Actual : "
						+ actualInviteIDSelectedByDefault);

		lavanteUtils.click(enviewSupplier.BackToSearchLink());

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		enobjsupplierPage.selectChangeView("Suppliers and Invites");

		dataMap.put("supplierName", supName);
		dataMap.put("Invitation", "");
		dataMap.put("ExtendInvite", "");
		Reporter.log("Supplier Selected for Extend invite :" + supName);
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.clear();
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(enobjInvitenewSupplier.PrimaryContactRadioBtn());
		dataMap.put("inviteorg", "any");
		dataMap.put("Next", "");
		enobjInvitenewSupplier.fillInviteDetails(dataMap);
		enobjInvitenewSupplier.formSuppAction(dataMap);

		lavanteUtils.fluentwait(enobjInvitenewSupplier.EnableCustomFields());
		lavanteUtils.click(enobjInvitenewSupplier.EnableCustomFields());

		proNumber = "Edit" + lavanteUtils.generateRandomNumber9OnLength(9);
		clientComName = "ComName" + proNumber;
		while (!driver.findElement(By.cssSelector(config.getProperty("ClientCompanyNameTxtBox"))).isEnabled()) {
			lavanteUtils.click(enobjInvitenewSupplier.EnableCustomFields());
			break;
		}
		lavanteUtils.waitForTime(2000);
		driver.findElement(By.cssSelector(config.getProperty("ClientCompanyNameTxtBox"))).clear();
		driver.findElement(By.cssSelector(config.getProperty("ClientCompanyNameTxtBox"))).sendKeys(clientComName);
		driver.findElement(By.cssSelector(config.getProperty("ProjectNumberTxtBox"))).clear();
		driver.findElement(By.cssSelector(config.getProperty("ProjectNumberTxtBox"))).sendKeys(proNumber);
		lavanteUtils.fluentwait(enobjInvitenewSupplier.NextBtn());
		lavanteUtils.click(enobjInvitenewSupplier.NextBtn());
		lavanteUtils.waitForTime(2000);
		dataMap.clear();
		dataMap.put("invite", "");
		enobjInvitenewSupplier.formSuppAction(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enobjsupplierPage.selectChangeView("Invites");
		String invitedID2 = enobjsupplierPage.getColumnText("Invitation ID", 0);

		enviewSupplier.clickOnSupplier(supName);

		dataMap.clear();
		dataMap.put("maintab", "viewEnterpriseInformation");
		enviewSupplier.selectTab(dataMap);

		actualClientCompanyName = lavanteUtils.getText(enviewSupplier.GetClientCompanyName());
		actualProjectNumber = lavanteUtils.getText(enviewSupplier.GetProjectNumber());
		Reporter.log("Custom fields validation :");
		softAssert.assertEquals(actualClientCompanyName, clientComName,
				" Verification failed for client company field custom field, Expected : " + clientComName
						+ " , Actual : " + actualClientCompanyName);
		softAssert.assertEquals(actualProjectNumber, proNumber,
				" Verification failed for project number field custom field, Expected : " + proNumber + " , Actual : "
						+ actualProjectNumber);
		actualInviteIDSelectedByDefault = lavanteUtils.getText(enviewSupplier.GetInviteIdSelectedInDropDwn());

		Reporter.log("Invited supplier inviteID validation :");
		softAssert.assertEquals(actualInviteIDSelectedByDefault, invitedID2,
				" Verification failed for Invite ID, Expected : " + invitedID2 + " , Actual : "
						+ actualInviteIDSelectedByDefault);

		lavanteUtils.click(enviewSupplier.GetInviteIdSelectedInDropDwn());
		int getInvitesSize = enviewSupplier.ListOfInvites().size();
		String invites = null;
		boolean flag = false;
		if (getInvitesSize <= 1) {
			softAssert.assertTrue(false, "InviteId s not listed in invites dropdown");
		} else {
			for (int i = 0; i < getInvitesSize; i++) {

				invites = lavanteUtils.getText(enviewSupplier.ListOfInvites().get(i));
				if (invitedID1.equals(invites) || invitedID2.equals(invites)) {
					flag = true;
				}
			}
			softAssert.assertTrue(flag, "InviteId s not listed in invites dropdown or invlid ids ");
		}

		lavanteUtils.click(enviewSupplier.BackToSearchLink());
		softAssert.assertAll();

		Reporter.log("Test Ended for extendInviteCustomFiledsTest : " + LavanteUtils.currenttime());

	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
*/