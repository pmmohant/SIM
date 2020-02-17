package com.lavante.sim.customer.TestScripts.SanityTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SIMSanityTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();	
		openAPP();
		lavanteUtils.driver = driver;

	}

	@Test
	public void loginsTest() throws FileNotFoundException, IOException,SQLException {

		// Verifying Login Page Displayed

		objLoginPage.verifyLoginPageDisplayed();
		List<?> listofdatafrm = lavanteUtils.login("Sanity", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		objHomePage.verifyHomePageDisplayed();
		lavanteUtils.fluentwait(enobjhomePage.UserName());

	}

	@Test(priority = 2, dependsOnMethods = { "loginsTest" })
	public void dashboardTest() throws InterruptedException {
		Reporter.log("Test Started for Dashboard Test:" + currenttime(), true);
		SoftAssert softAssert =new SoftAssert();

		lavanteUtils.fluentwait(enobjdashBoard.QuickLinksSection);
		lavanteUtils.verifyElementDisplayed("FrequentlyAskedQuestionsSection", enobjdashBoard.FrequentlyAskedQuestionsSection);
		lavanteUtils.verifyElementDisplayed("QuickLinksSection", enobjdashBoard.QuickLinksSection);
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		 // Navigating sub menu items under Dashboard menu
		dataMap.put("Dashboard", "Onboarding");
		enobjdashBoard.switchDashboard(dataMap);
		
		boolean flag=enobjdashBoard.verifyOnBoardingDashboardItemsDisplayed();
		softAssert.assertTrue(flag,"Onboarding Failed");
		
		dataMap.put("Dashboard", "Validation Results");
		enobjdashBoard.switchDashboard(dataMap);
		
		flag=enobjdashBoard.verifyValidationsItemsDisplayed();
		softAssert.assertTrue(flag,"Validation Result Failed");
		
		dataMap.put("Dashboard", "Expiring Certifications");
		enobjdashBoard.switchDashboard(dataMap);
		
		flag=enobjdashBoard.verifyExpiringCeritifcationDisplayed();
		softAssert.assertTrue(flag,"Expiring Failed");

		 // Navigating sub menu items under Dashboard menu
		dataMap.put("Dashboard", "Regulatory Compliance");
		enobjdashBoard.switchDashboard(dataMap);
		   
		flag=enobjdashBoard.verifyRegulatoryComplianceItemsDisplayed();
		softAssert.assertTrue(flag,"Regulatory Failed");
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Dashboard Test:" + currenttime(), true);
	}

	@Test(priority = 3, dependsOnMethods = { "loginsTest" })
	public void TaskPageTest() {

		SoftAssert softAssert =new SoftAssert();
		
		// Tasks -> Supplier registrations to approve
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "customerApprovals");
		enobjhomePage.selectTab(dataMap);
		boolean flag=objtaskapproval.verifySuppRegToAprvPageDtlsDisplayed();
		softAssert.assertTrue(flag,"Customer Approval Failed");

		// Tasks -> Supplier ERP IDs to update
		dataMap.put("subtab", "addSupplierERPID");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifySuppERPIDToUpdtPageDtlsDisplayed();
		softAssert.assertTrue(flag,"ERP ID Failed");
		
		// Tasks -> Supplier Invoices to Approve
		dataMap.put("subtab", "getInvoiceTasks");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifyInvoicesToAprvPageDtlsDisplayed();
		softAssert.assertTrue(flag,"Invoice Approval Failed");

		// Tasks -> Profile Data change approvals to approve
		dataMap.put("subtab", "supplierDataChangesToApprove");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifySuppDataChngsToAprvPageDtlsDisplayed();
		softAssert.assertTrue(flag,"Supp Data Change Failed");

		// Tasks -> Reassignment
		dataMap.put("subtab", "viewApprovalTasks");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifyReassignmentPageDtlsDisplayed();
		softAssert.assertTrue(flag,"Reassignment Failed");
		
		// Tasks ->Supp reg pending update
		dataMap.put("subtab", "ProfileChangesToUpdate");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifySupplierRegistrationsPendingUpdate();
		softAssert.assertTrue(flag,"Profile Changes Failed");

		// Tasks -> Invoice Questions to Answer
	/* G  P Login dont have invvoice qn to ans enabled	if (!lavanteUtils.driver.getCurrentUrl().contains("simstaging.westus2")) {
			dataMap.put("subtab", "getInvoiceQuesToAns");
			enobjhomePage.selectTab(dataMap);
			flag=objtaskapproval.verifyInvoiceQuestsToAnsPageDtlsDisplayed();
			softAssert.assertTrue(flag,"Inv Qn To ans Failed");
		}
		
		// Tasks -> Invoice Pending Updates
		dataMap.put("subtab", "getInvoicePendingUpdate");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifyInvoicesToUpdatePageDtlsDisplayed();
		softAssert.assertTrue(flag,"Invoice to Update Failed");
		
		*/

		// Tasks -> Supplier invites to approve
		dataMap.put("subtab", "supplierInvitesToApprove");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifySuppInvitesToAprvPageDtlsDisplayed();
		softAssert.assertTrue(flag,"Supp Invite Failed");

		// Tasks -> Track/Reassign Task
		dataMap.put("subtab", "taskTracker");
		enobjhomePage.selectTab(dataMap);
		flag=objtaskapproval.verifyTaskTrackerPageDtlsDisplayed();
		softAssert.assertTrue(flag,"Task Tracker Failed");

		
		
		softAssert.assertAll();

	}

	@Test(priority = 4, dependsOnMethods = { "loginsTest" })
	public void supplierTest() {
		Reporter.log("Test Started for supplier Test:" + currenttime(), true);
		SoftAssert softAssert=new SoftAssert();
		
		dataMap.put("maintab", "Suppliers");
		enobjhomePage.selectTab(dataMap);
	
		boolean flag=objSupplierSearchPage.verifyBasicSearchTableDisplayed();
		softAssert.assertTrue(flag,"Basic Search failed");
		
		flag=objSupplierSearchPage.verifyAdvanceSearchTableDisplayed();
		softAssert.assertTrue(flag,"Advance Search failed");
		
		softAssert.assertAll();
		Reporter.log("Test Ended for supplier Test:" + currenttime(), true);
	}

	// Campaign needs to be entered here

	@Test(priority = 5, dependsOnMethods = { "loginsTest" })
	public void RiskPageTest() {
		SoftAssert softAssert=new SoftAssert();
		
		dataMap.put("maintab", "Risks");
		dataMap.put("subtab", "Legal");
		enobjhomePage.selectTab(dataMap);
		boolean flag=objSupplierSearchPage.verifyLegalIDSeachDetailsDisplayed();
		softAssert.assertTrue(flag,"Legal ID Not Displayed");

		dataMap.put("subtab", "OFAC");
		enobjhomePage.selectTab(dataMap);
		 flag=objSupplierSearchPage.verifyOFACPageDetailsDisplayed();
		 softAssert.assertTrue(flag,"OFAC Not Displayed");

		dataMap.put("subtab", "Address");
		enobjhomePage.selectTab(dataMap);
		 flag=objSupplierSearchPage.verifyAddressDetailsPageDetailsDisplayed();
		 softAssert.assertTrue(flag,"Address Not Displayed");
		
		softAssert.assertAll();

	}

	@Test(priority = 6, dependsOnMethods = { "loginsTest" })
	public void TransactionTest() {
		SoftAssert softAssert=new SoftAssert();
		
		dataMap.put("maintab", "Invoices");
		dataMap.put("subtab", "Contract");
		enobjhomePage.selectTab(dataMap);
		boolean flag=encontractManagement.verifyContractManagementPage();
		softAssert.assertTrue(flag,"Contract Failed");
		
		dataMap.put("subtab", "Invoice");
		enobjhomePage.selectTab(dataMap);
		flag=eninvoicePage.verifyInvoicePage();
		softAssert.assertTrue(flag,"Invoice Failed");

		
		dataMap.put("subtab", "Payment");
		enobjhomePage.selectTab(dataMap);
		flag=objPaymentsPage.verifyPaymentsPage();
		softAssert.assertTrue(flag,"Payment Failed");

		/*
		 * as of now it is not showing the menu in simdev env only
		 * dataMap.put("subtab", "BatchPayment");
		 * enobjhomePage.selectTab(dataMap);
		 * objSupplierSearchPage.verifyPaymentDetailsPageDisplayed();
		 */
		
		softAssert.assertAll();
		
	}

	@Test(priority = 7, dependsOnMethods = { "loginsTest" })
	public void ReportsTest() {
		dataMap.clear();
		dataMap.put("maintab", "reports");
		enobjhomePage.selectTab(dataMap);

		enReportuserDefined.verifyAdminTablePresent();
		/*
		 * enReportuserDefined.verifyCustomerTablePresent();
		 * enReportuserDefined.verifyUserDefineTablePresent();
		 */
	}

	// Vendor Request needs to be entered

	@Test(priority = 8, dependsOnMethods = { "loginsTest" })
	public void MessageTest() {
		dataMap.clear();
		dataMap.put("maintab", "message");
		enobjhomePage.selectTab(dataMap);

		boolean flag=enMessage.sanityCheck();
		
		Assert.assertTrue(flag,"Message Failed");
		
	}

	@Test(priority = 9, dependsOnMethods = { "loginsTest" })
	public void AdminPageTest() {
		Reporter.log("Test Started for sanity test in Admin page  : "+ currenttime(), true);
		SoftAssert softAssert=new SoftAssert();
		
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "Upload");
		enobjhomePage.selectTab(dataMap);
		boolean flag=objManageFilesPage.verifyUploadFilesPageDetailsDisplayed();
		softAssert.assertTrue(flag,"Upload Page Failed");
		
		dataMap.put("subtab", "Download");
		enobjhomePage.selectTab(dataMap);
		flag=objManageFilesPage.verifyDownloadFilesPageDetailsDisplayed();
		softAssert.assertTrue(flag,"Download Page Failed");

		dataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(dataMap);
		flag=objUserPage.verifyUsersSectionDisplayed();
		softAssert.assertTrue(flag,"User Page Failed");
		
		dataMap.put("subtab", "Address");
		enobjhomePage.selectTab(dataMap);
		flag=objManageAddressesPage.verifyAddressPageDisplayed();
		softAssert.assertTrue(flag,"Address Page Failed");

		// Department
		dataMap.put("subtab", "department");
		enobjhomePage.selectTab(dataMap);
		flag=objDepartments.verifyDepartmentSectionIsDisplayed();
		softAssert.assertTrue(flag,"Department Page Failed");

		// Division
		dataMap.put("subtab", "Division");
		enobjhomePage.selectTab(dataMap);
		flag=objDivisionPage.verifyDivisionPage();
		softAssert.assertTrue(flag,"Division Page Failed");

		// Payment Center
		dataMap.put("subtab", "buyerPaymentCenter");
		enobjhomePage.selectTab(dataMap);
		flag=objPaymentCenterPage.verifyPaymentCenterPage();
		softAssert.assertTrue(flag,"Payment Center Page Failed");

		// Payment Center Mapping
		dataMap.put("subtab", "buyerPaymentCenterMapping");
		enobjhomePage.selectTab(dataMap);
		flag=objPayCntrMapPage.verifyPaymentCenterMappingPage();
		softAssert.assertTrue(flag,"Payment Center mapping Page Failed");

		// Payment Terms Group
		dataMap.put("subtab", "buyerPaymentTerms");
		enobjhomePage.selectTab(dataMap);
		flag=objPaymentTermPage.verifyPaymentTermsPage();
		softAssert.assertTrue(flag,"Payment Term Page Failed");

		// Buyer Supplier Group
		dataMap.put("subtab", "buyerSupplierGroup");
		enobjhomePage.selectTab(dataMap);
		flag=objSupplierGroupPage.verifyBuyerSupplierGroupPage();
		softAssert.assertTrue(flag,"Supplier Group Page Failed");

		Reporter.log("Test Ended for sanity test in Admin page :"+ currenttime(), true);

	}

	@AfterClass
	public void close() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
