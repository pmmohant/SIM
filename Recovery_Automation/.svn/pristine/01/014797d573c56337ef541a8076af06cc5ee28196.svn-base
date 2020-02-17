package lavante.recovery.testsuites;

import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Sanity Test Suite for Recovery Application and Covers all the page of recovery Application
 * This Class can be used after the build deployment/Nightly run as first suite to check the application at Sanity Level 
 * 
 * @author Ramya.Raj
 *
 */
public class SanityTestSuite extends pageInitiator {

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();

		waitForTime(10000);
		homePage.verifyHomePageDisplayed();

		homePage.SelectAudit("ANY");

		waitForTime(3000);

	}

	/**
	 * 
	 * @author Ramya.Raj
	 */
	@Test(priority = 1)
	public void SanityDashboardPage() {

		Reporter.log("Sanity ,Dashboard Test starts at:" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		waitForTime(3000);
		fluentwait(dashboardclaimsPage.dashBoardLink());
		boolean verify = isElementDisplayed(dashboardclaimsPage.dashBoardLink());
		softAssert
				.assertTrue(verify, "Dashboard link display Status:" + verify);
		Reporter.log("Dashboard link display status:" + verify);

		fluentwait(dashboardclaimsPage.batchedClaimslink());
		verify = isElementDisplayed(dashboardclaimsPage.batchedClaimslink());
		softAssert.assertTrue(verify, "Batched claims link display status:"
				+ verify);
		Reporter.log("Batched claims link display status :" + verify);

		fluentwait(dashboardclaimsPage.invoiceslink());
		verify = isElementDisplayed(dashboardclaimsPage.invoiceslink());
		softAssert.assertTrue(verify, "Invoices link display status:" + verify);
		Reporter.log("Invoices link display status:" + verify);

		// Claim graphs

		fluentwait(dashboardclaimsPage.claimsByStatusChart());
		verify = isElementDisplayed(dashboardclaimsPage.claimsByStatusChart());
		String expChart = dashboardclaimsPage.claimsByStatusChart().getText();
		String actChart = "Claims by Status";
		softAssert.assertEquals(expChart, actChart);
		Reporter.log("Claims By Status Chart display status:" + verify);

		fluentwait(dashboardclaimsPage.allClaimsChart());
		verify = isElementDisplayed(dashboardclaimsPage.allClaimsChart());
		String expChart1 = dashboardclaimsPage.allClaimsChart().getText();
		String actChart1 = "All Claims";
		softAssert.assertEquals(expChart1, actChart1, "All Claims Chart,Exp:"
				+ expChart1 + ",Actuals:" + actChart1);
		Reporter.log("All Claims Chart ,Exp:" + expChart1 + ",Actuals:"
				+ actChart1);

		fluentwait(dashboardclaimsPage.claimsByTypeChart());
		verify = isElementDisplayed(dashboardclaimsPage.claimsByTypeChart());
		String expChart2 = dashboardclaimsPage.claimsByTypeChart().getText();
		String actChart2 = "Claims by Type";
		softAssert.assertEquals(expChart2, actChart2);
		Reporter.log("All Claims chart display status:" + verify);

		fluentwait(dashboardclaimsPage.claimsByOrgChart());
		verify = isElementDisplayed(dashboardclaimsPage.claimsByOrgChart());
		String expChart3 = dashboardclaimsPage.claimsByOrgChart().getText();
		String actChart3 = "Claims by Organization";
		softAssert.assertEquals(expChart3, actChart3);
		Reporter.log("Claims by organisation chart display status:" + verify);

		// Verifying Items for My Review

		fluentwait(dashboardclaimsPage.itemsForMyReviewD());
		verify = isElementDisplayed(dashboardclaimsPage.itemsForMyReviewD());
		softAssert.assertTrue(verify,
				"Items for My Review (Days Old) display status:" + verify);
		Reporter.log("Items for My Review (Days Old) display status :" + verify);

		// New open claims
		fluentwait(dashboardclaimsPage.newOpenClaimsFromLavante());
		verify = isElementDisplayed(dashboardclaimsPage
				.newOpenClaimsFromLavante());
		softAssert.assertTrue(verify, "New open claims from lavante status:"
				+ verify);
		Reporter.log("New open claims from lavante status :" + verify);

		// Claims in process by us
		fluentwait(dashboardclaimsPage.claimsInProcessByUs());
		verify = isElementDisplayed(dashboardclaimsPage.claimsInProcessByUs());
		softAssert.assertTrue(verify, "Claims in process by us status:"
				+ verify);
		Reporter.log("Claims in process by us display status :" + verify);

		// Claims on hold
		fluentwait(dashboardclaimsPage.claimsOnHold());
		verify = isElementDisplayed(dashboardclaimsPage.claimsOnHold());
		softAssert
				.assertTrue(verify, "Claims on hold display status:" + verify);
		Reporter.log("Claims on hold display status :" + verify);

		// Claims that changed
		fluentwait(dashboardclaimsPage.claimsthatChanged());
		verify = isElementDisplayed(dashboardclaimsPage.claimsthatChanged());
		softAssert.assertTrue(verify, "Claims that changed display status"
				+ verify);
		Reporter.log("Claims that changed display status :" + verify);

		// Invoices to be paid by us
		// fluentwait(dashboardclaimsPage.invoicesToBePaidByUs());
		// verify =
		// isElementDisplayed(dashboardclaimsPage.invoicesToBePaidByUs());
		// softAssert.assertTrue(verify,"Invoices to be paid by us display status:"+verify);
		// Reporter.log("Invoices to be paid by us display status :"+verify);

		// Verifying Supplier submenu
		fluentwait(dashboardsupplierPage.supplierLink());
		verify = isElementDisplayed(dashboardsupplierPage.supplierLink());
		softAssert.assertTrue(verify, "Supplier link displayed" + verify);
		Reporter.log("Supplier link display status:" + verify);
		click(dashboardsupplierPage.supplierLink());

		waitForTime(3000);
		fluentwait(dashboardsupplierPage.supplierCreditLink());
		verify = isElementDisplayed(dashboardsupplierPage.supplierCreditLink());
		softAssert.assertTrue(verify, "Supplier Credid link display status"
				+ verify);
		Reporter.log("Supplier Credit link display status:" + verify);
		click(dashboardsupplierPage.supplierCreditLink());

		fluentwait(dashboardsupplierPage.CreditTopSuppliers());
		verify = isElementDisplayed(dashboardsupplierPage.CreditTopSuppliers());
		softAssert.assertTrue(verify,
				"Top 100 Suppliers by table display status");
		Reporter.log("Top 100 Suppliers by table display status:" + verify);

		// fluentwait(dashboardsupplierPage.FileStatistics());
		// verify = isElementDisplayed(dashboardsupplierPage.FileStatistics());
		// softAssert.assertTrue(verify,"Supplier File Statistics table");
		// Reporter.log("Supplier File Statistics table display status:"+verify);

		fluentwait(dashboardsupplierPage.supplierExcludedChart());
		verify = isElementDisplayed(dashboardsupplierPage
				.supplierExcludedChart());
		softAssert.assertTrue(verify, "Supplier Excluded Chart displayed");
		Reporter.log("Supplier EXcluded Chart display status" + verify);

		fluentwait(dashboardsupplierPage.supplierChangeChart());
		verify = isElementDisplayed(dashboardsupplierPage.supplierChangeChart());
		softAssert.assertTrue(verify,
				"Supplier Change Statistics Chart displayed");
		Reporter.log("Supplier Change Statistics Chart display status" + verify);

		fluentwait(dashboardsupplierPage.supplierTargetchart());
		verify = isElementDisplayed(dashboardsupplierPage.supplierTargetchart());
		softAssert.assertTrue(verify, "Suppliers Targeted Chart displayed");
		Reporter.log("Suppliers Targeted Chart display status" + verify);

		fluentwait(dashboardsupplierPage.supplierTargetchart());
		verify = isElementDisplayed(dashboardsupplierPage.supplierTargetchart());
		softAssert.assertTrue(verify, "Suppliers Targeted Chart displayed");
		Reporter.log("Suppliers Targeted Chart display status:" + verify);

		fluentwait(dashboardsupplierPage.relSupChart());
		verify = isElementDisplayed(dashboardsupplierPage.relSupChart());
		softAssert.assertTrue(verify,
				"Related Supplier Analysis Chart displayed");
		Reporter.log("Related Supplier Analysis Chart display status:" + verify);

		// Verifying Spend sub menu

		fluentwait(dashboardsupplierPage.supplierSpendLink());
		verify = isElementDisplayed(dashboardsupplierPage.supplierSpendLink());
		softAssert
				.assertTrue(verify, "Supplier Spend link displayed:" + verify);
		Reporter.log("Supplier spend link display status:" + verify);
		click(dashboardsupplierPage.supplierSpendLink());

		fluentwait(dashboardsupplierPage.SpendTopSuppliers());
		verify = isElementDisplayed(dashboardsupplierPage.SpendTopSuppliers());
		softAssert.assertTrue(verify,
				"Spend Top 100 Suppliers by table displayed:" + verify);
		Reporter.log("Spend Top 100 Suppliers by table display status:"
				+ verify);

		// fluentwait(dashboardsupplierPage.spendSupplierFileStatistics());
		// verify =
		// isElementDisplayed(dashboardsupplierPage.spendSupplierFileStatistics());
		// softAssert.assertTrue(verify,"Spend Supplier File Statistics table displayed:"
		// +verify);
		// Reporter.log("Spend Supplier Table Statistics display status:"+verify);

		fluentwait(dashboardsupplierPage.supplierExcludedChart());
		verify = isElementDisplayed(dashboardsupplierPage
				.supplierExcludedChart());
		softAssert.assertTrue(verify,
				"Spend Suppliers Excluded Chart displayed:" + verify);
		Reporter.log("Spend Suppliers Excluded Chart display status:" + verify);

		fluentwait(dashboardsupplierPage.supplierTargetchart());
		verify = isElementDisplayed(dashboardsupplierPage.supplierTargetchart());
		softAssert.assertTrue(verify,
				"Spend Suppliers Targeted Chart displayed" + verify);
		Reporter.log("Spend Suppliers Targeted Chart display status:" + verify);

		fluentwait(dashboardsupplierPage.relSupChart());
		verify = isElementDisplayed(dashboardsupplierPage.relSupChart());
		softAssert.assertTrue(verify,
				"Related Supplier Analysis Chart displayed" + verify);
		Reporter.log("Related Supplier Aanlysis Chart display status:" + verify);

		// Verifying Check Request sub menu

		fluentwait(dashboardsupplierPage.chkReqLink());
		verify = isElementDisplayed(dashboardsupplierPage.chkReqLink());
		softAssert.assertTrue(verify, "Check Request link displayed" + verify);
		Reporter.log("Check Request link display status:" + verify);
		click(dashboardsupplierPage.chkReqLink());

		fluentwait(dashboardsupplierPage.chkReqTopSuppliers());
		verify = isElementDisplayed(dashboardsupplierPage.chkReqTopSuppliers());
		softAssert.assertTrue(verify,
				"Check Request Top 100 Suppliers by table displayed" + verify);
		Reporter.log("Check Request Top 100 Suppliers by table display status:"
				+ verify);

		fluentwait(dashboardsupplierPage.supplierExcludedChart());
		verify = isElementDisplayed(dashboardsupplierPage
				.supplierExcludedChart());
		softAssert.assertTrue(verify,
				"Check Request Supplier EXcluded Chart displayed" + verify);
		Reporter.log("Check Request Supplier Excludec Chart display status:"
				+ verify);

		fluentwait(dashboardsupplierPage.supplierChangeChart());
		verify = isElementDisplayed(dashboardsupplierPage.supplierChangeChart());
		softAssert.assertTrue(verify,
				"Check Request Supplier Change Chart displayed" + verify);
		Reporter.log("Check Request Supplier Change Chart display status:"
				+ verify);

		fluentwait(dashboardsupplierPage.supplierTargetchart());
		verify = isElementDisplayed(dashboardsupplierPage.supplierTargetchart());
		softAssert.assertTrue(verify,
				"Check Request Supplier Target Chart displayed" + verify);
		Reporter.log("Check Request Supplier Target Chart display status:"
				+ verify);

		fluentwait(dashboardsupplierPage.relSupChart());
		verify = isElementDisplayed(dashboardsupplierPage.relSupChart());
		softAssert.assertTrue(verify, "Check Request Related Supplier Chart "
				+ verify);
		Reporter.log("Check Request Related Supplier Chart display status:"
				+ verify);

		// Verifying compliance sub menu
		fluentwait(compliancePage.complianceLink());
		verify = isElementDisplayed(compliancePage.complianceLink());
		softAssert.assertTrue(verify, "Compliance link is displayed" + verify);
		Reporter.log("Compliance link display status:" + verify);
		click(compliancePage.complainceLink());

		fluentwait(compliancePage.compliantLink());
		verify = isElementDisplayed(compliancePage.compliantLink());
		softAssert.assertTrue(verify, "Compliant link  displayed" + verify);
		Reporter.log("Compliant link display status:" + verify);
		// compliancePage.compliantLink());
		WebElement compliantlink = compliancePage.compliantLink();
		click(compliantlink);

		fluentwait(compliancePage.compliantTable());
		verify = isElementDisplayed(compliancePage.compliantTable());
		softAssert.assertTrue(verify, "Compliant table  displayed" + verify);
		Reporter.log("Compliant table display status:" + verify);

		fluentwait(compliancePage.complianceSummary());
		verify = isElementDisplayed(compliancePage.complianceSummary());
		softAssert.assertTrue(verify, "Compliance Summary  displayed" + verify);
		Reporter.log("Compliance Summary display status:" + verify);

		fluentwait(compliancePage.complianceBySpendChart());
		verify = isElementDisplayed(compliancePage.complianceBySpendChart());
		softAssert.assertTrue(verify, "Compliance by Spend Chart displayed"
				+ verify);
		Reporter.log("Compliance by Spend Chart display status:" + verify);

		fluentwait(compliancePage.complianceByCountChart());
		verify = isElementDisplayed(compliancePage.complianceByCountChart());
		softAssert.assertTrue(verify, "Compliance by count Chart displayed"
				+ verify);
		Reporter.log("Compliance by count Chart display status:" + verify);

		fluentwait(compliancePage.complianceBySpendRankChart());
		verify = isElementDisplayed(compliancePage.complianceBySpendRankChart());
		softAssert.assertTrue(verify,
				"Compliance by Spend Rank Chart displayed" + verify);
		Reporter.log("Compliance by Spend Rank Chart display status:" + verify);

		fluentwait(compliancePage.OFACHart());
		verify = isElementDisplayed(compliancePage.OFACHart());
		softAssert.assertTrue(verify,
				"Compliance  Suppliers on OFAC DSN displayed" + verify);
		Reporter.log("Compliance  Suppliers on OFAC DSN display status"
				+ verify);

		// Verifying Non- compliant sub menu
		fluentwait(compliancePage.noncompliantLink());
		verify = isElementDisplayed(compliancePage.noncompliantLink());
		softAssert.assertTrue(verify, "NOn compliant link displayed" + verify);
		Reporter.log("Non compliant link display status: " + verify);
		// compliancePage.noncompliantLink());
		WebElement noncompliantlink = compliancePage.noncompliantLink();
		click(noncompliantlink);

		fluentwait(compliancePage.complianceBySpendChart());
		verify = isElementDisplayed(compliancePage.complianceBySpendChart());
		softAssert.assertTrue(verify, "Compliance by Spend Chart displayed"
				+ verify);
		Reporter.log("Compliance by Spend chart display status:" + verify);

		fluentwait(compliancePage.complianceBySpendRankChart());
		verify = isElementDisplayed(compliancePage.complianceBySpendRankChart());
		softAssert.assertTrue(verify,
				"Compliance by Spend Rank Chart displayed" + verify);
		Reporter.log("Compliance by Spend Rank chart display status :" + verify);

		fluentwait(compliancePage.complianceByCountChart());
		verify = isElementDisplayed(compliancePage.complianceByCountChart());
		softAssert.assertTrue(verify, "Compliance by Count chart displayed"
				+ verify);
		Reporter.log("Compliance by Count Chart display status: " + verify);

		fluentwait(compliancePage.OFACHart());
		verify = isElementDisplayed(compliancePage.complianceByCountChart());
		softAssert.assertTrue(verify, "Compliance by Count chart displayed"
				+ verify);
		Reporter.log("Compliance by Count Chart display status:" + verify);

		softAssert.assertAll();
		Reporter.log("Sanity ,Dashboard Test Ends at:" + currenttime());

	}
	
	/**
	 * Sanity Test Suite on Audit Page
	 * Verification of All Links and Tabs
	 * 
	 * @author Ramya.Raj
	 */
	@Test(priority = 2)
	public void SanityAuditPage() {

		Reporter.log("Sanity ,Audit Test starts at:" + currenttime());
		System.out.println("Sanity ,Audit Test starts at:" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		waitForTime(3000);

		// Audit link
		Reporter.log("Navigated to Audit->OutBound Page:");

		fluentwait(auditOutboundPage.auditLink());
		boolean verify = isElementDisplayed(auditOutboundPage.auditLink());
		softAssert.assertTrue(verify, "Audit link display status:" + verify);
		Reporter.log("Audit link display status:" + verify);

		click(auditOutboundPage.auditLink());
		waitForTime(3000);

		// Verifying Outbound link
		fluentwait(auditOutboundPage.outboundLink());
		verify = isElementDisplayed(auditOutboundPage.outboundLink());
		softAssert.assertTrue(verify, "Outbound link display status:" + verify);
		Reporter.log("Outblound link display status" + verify);

		click(auditOutboundPage.outboundLink());

		fluentwait(auditOutboundPage.currentMonCredits());
		verify = isElementDisplayed(auditOutboundPage.currentMonCredits());
		softAssert.assertTrue(verify,
				"Current Mon Credits table display status:" + verify);
		Reporter.log("Current Mon Credits table display status:" + verify);

		fluentwait(auditOutboundPage.auditContactDetails());
		verify = isElementDisplayed(auditOutboundPage.auditContactDetails());
		softAssert.assertTrue(verify,
				"Audit Contact Details table display status:" + verify);
		Reporter.log("Audit Contact Details table display status:" + verify);

		fluentwait(auditOutboundPage.claimHistoryGrph());
		verify = isElementDisplayed(auditOutboundPage.claimHistoryGrph());
		softAssert.assertTrue(verify, "Claim history graph display status :"
				+ verify);
		Reporter.log("Claim history grapth display status :" + verify);

		fluentwait(auditOutboundPage.supplierStatus());
		verify = isElementDisplayed(auditOutboundPage.supplierStatus());
		softAssert.assertTrue(verify,
				"Supplier status by Spend Rank graph display status:" + verify);
		Reporter.log("Supplier Status by Spend Rank graph display status: "
				+ verify);

		fluentwait(auditOutboundPage.pendingCorrespondence());
		verify = isElementDisplayed(auditOutboundPage.pendingCorrespondence());
		softAssert.assertTrue(verify,
				"Pending Correspondence graph display status :" + verify);
		Reporter.log("Pending Correspondence graph display status :" + verify);

		// Verifying Inbound link
		Reporter.log("Navigated to Audit->InBound Page:");
		fluentwait(auditInboundPage.inboundLink());
		verify = isElementDisplayed(auditInboundPage.inboundLink());
		softAssert.assertTrue(verify, "Audit Inbound link display status :"
				+ verify);
		Reporter.log("Audit Inbound link display status :" + verify);

		click(auditInboundPage.inboundLink());
		fluentwait(auditInboundPage.incomingDocumentStatistics());

		verify = isElementDisplayed(auditInboundPage
				.incomingDocumentStatistics());
		softAssert.assertTrue(verify,
				"Incoming Document Statistics table display:" + verify);
		Reporter.log("Incoming Document Statistics table display status :"
				+ verify);

		fluentwait(auditInboundPage.inboundDocumentSummary());
		verify = isElementDisplayed(auditInboundPage.inboundDocumentSummary());
		softAssert.assertTrue(verify,
				"Inbound Document Summary table display status :" + verify);
		Reporter.log("Inbound Document Summary table display status :" + verify);

		fluentwait(auditInboundPage.recognizedfax());
		verify = isElementDisplayed(auditInboundPage.recognizedfax());
		softAssert.assertTrue(verify, "Recognized fax table display status :"
				+ verify);
		Reporter.log("Recognized fax table display status :" + verify);
		click(auditInboundPage.recognizedfax());

		fluentwait(auditInboundPage.recognizedfaxTable());
		verify = isElementDisplayed(auditInboundPage.recognizedfaxTable());
		softAssert.assertTrue(verify, "Recognized fax table display status :"+ verify);
		Reporter.log("Recognized fax table display status :" + verify);

		fluentwait(auditInboundPage.unrecognizedfax());
		verify = isElementDisplayed(auditInboundPage.unrecognizedfax());
		softAssert.assertTrue(verify, "Unrecognized fax table status :"
				+ verify);
		Reporter.log("Unrecognized fax table display status :" + verify);
		click(auditInboundPage.unrecognizedfax());

		fluentwait(auditInboundPage.unrecognizedfaxTable());
		verify = isElementDisplayed(auditInboundPage.unrecognizedfaxTable());
		softAssert.assertTrue(verify, "Unrecognized fax table display status :"
				+ verify);
		Reporter.log("Unrecognized fax table display status :" + verify);

		fluentwait(auditInboundPage.dna());
		verify = isElementDisplayed(auditInboundPage.dna());
		softAssert.assertTrue(verify, "DNA table display status :" + verify);
		Reporter.log("DNA table display status :" + verify);
		click(auditInboundPage.dna());

		fluentwait(auditInboundPage.dnaTable());
		verify = isElementDisplayed(auditInboundPage.dnaTable());
		softAssert.assertTrue(verify, "DNA table display status :" + verify);
		Reporter.log("DNA table display status :" + verify);

		switchtoFrame(null);
		// Verifying Contact Entry link
		waitForTime(3000);
		fluentwait(auditContactEntryPage.contactEntry());
		verify = isElementDisplayed(auditContactEntryPage.contactEntry());
		softAssert.assertTrue(verify,"Audit Contact Entry link display status :" + verify);
		Reporter.log("Audit Contact Entry link display status :" + verify);
	
		click(auditContactEntryPage.contactEntry());

		waitForTime(5000);
		if(auditContactEntryPage.ValidateSupplier().size()>0){
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ESCAPE).build().perform();
		}

		fluentwait(auditContactEntryPage.docQueueTable());
		verify = isElementDisplayed(auditContactEntryPage.docQueueTable());
		softAssert.assertTrue(verify, "Document Queue Table display status :"+ verify);
		Reporter.log("Document Queue table display status :" + verify);

		fluentwait(auditContactEntryPage.supDetailsTable());
		verify = isElementDisplayed(auditContactEntryPage.supDetailsTable());
		softAssert.assertTrue(verify, "Supplier Details table display status :"+ verify);
		Reporter.log("Supplier Details table display status " + verify);

		fluentwait(auditContactEntryPage.suppLookUpbtn1());
		verify = isElementDisplayed(auditContactEntryPage.suppLookUpbtn1());
		softAssert.assertTrue(verify,
				"Supplier Look up button display status :" + verify);
		Reporter.log("Supplier Look Up button display status :" + verify);

		// fluentwait(auditContactEntryPage.fixOCRsuppName1());
		// verify=isElementDisplayed(auditContactEntryPage.fixOCRsuppName1());
		// softAssert.assertTrue(verify,"Fix OCR button display status :"+verify);
		// Reporter.log("Fix OCR button display status : "+verify);

		fluentwait(auditContactEntryPage.suppDetailsSuppName());
		verify = isElementDisplayed(auditContactEntryPage.suppDetailsSuppName());
		softAssert.assertTrue(verify, "Supplier Name field display status :"
				+ verify);
		Reporter.log("Supplier Name field display status :" + verify);

		fluentwait(auditContactEntryPage.suppDetailsContactName());
		verify = isElementDisplayed(auditContactEntryPage
				.suppDetailsContactName());
		softAssert.assertTrue(verify,
				"Supplier Details Contact Name display status :" + verify);
		Reporter.log("Supplier Details Contact Name display status : " + verify);

		fluentwait(auditContactEntryPage.suppDetailsContactPhone());
		verify = isElementDisplayed(auditContactEntryPage
				.suppDetailsContactPhone());
		softAssert.assertTrue(verify,
				"Supplier Details Contact Phone display status :" + verify);
		Reporter.log("Supplier Details Contact Phone display status :" + verify);

		fluentwait(auditContactEntryPage.suppDetailscontactEmail());
		verify = isElementDisplayed(auditContactEntryPage
				.suppDetailscontactEmail());
		softAssert.assertTrue(verify,
				"Supplier Details Contact Email display status :" + verify);
		Reporter.log("Supplier Details Contact Email display status:  "
				+ verify);

		fluentwait(auditContactEntryPage.suppDetailsContactFax());
		verify = isElementDisplayed(auditContactEntryPage
				.suppDetailsContactFax());
		softAssert.assertTrue(verify,
				"Supplier Details Contact Fax display status :" + verify);
		Reporter.log("Supplier Details Contact Fax display status : " + verify);

		fluentwait(auditContactEntryPage.docQueueSuppName());
		verify = isElementDisplayed(auditContactEntryPage.docQueueSuppName());
		softAssert.assertTrue(verify,
				"Documeny queue supplier  name display status :" + verify);
		Reporter.log("Document queue supplier name display status : " + verify);

		fluentwait(auditContactEntryPage.saveBtn());
		verify = isElementDisplayed(auditContactEntryPage.saveBtn());
		softAssert.assertTrue(verify, "Save button display status :" + verify);
		Reporter.log("Save button display status : " + verify);

		fluentwait(auditContactEntryPage.previousBtn());
		verify = isElementDisplayed(auditContactEntryPage.previousBtn());
		softAssert.assertTrue(verify, "Previous button display status :"
				+ verify);
		Reporter.log("Previous button display status : " + verify);

		fluentwait(auditContactEntryPage.saveAndDisposeBtn());
		verify = isElementDisplayed(auditContactEntryPage.saveAndDisposeBtn());
		softAssert.assertTrue(verify,
				"Save and Dispose button display status :" + verify);
		Reporter.log("Save and Dispose button display status : " + verify);

		fluentwait(auditContactEntryPage.reviewBtn());
		verify = isElementDisplayed(auditContactEntryPage.reviewBtn());
		softAssert
				.assertTrue(verify, "Review button display status :" + verify);
		Reporter.log("Review button display status : " + verify);

		refreshPage();
		// Verifying Batching link
		fluentwait(auditBatchingPage.batchingLink());
		verify = isElementDisplayed(auditBatchingPage.batchingLink());
		softAssert.assertTrue(verify, "Audit Batching link display status :"
				+ verify);
		Reporter.log("Audit Batching link display status :" + verify);
		click(auditBatchingPage.batchingLink());

		fluentwait(auditBatchingPage.unBatchedCreditsTableFrame());
		verify = isElementDisplayed(auditBatchingPage
				.unBatchedCreditsTableFrame());
		softAssert.assertTrue(verify,
				"Unbatched Credits table display status :" + verify);
		Reporter.log("Unbatched Credits table display status :" + verify);

		fluentwait(auditBatchingPage.batchedClaimsTable());
		verify = isElementDisplayed(auditBatchingPage.batchedClaimsTable());
		softAssert.assertTrue(verify, "Batched claims table display status :"
				+ verify);
		Reporter.log("Batched Claims table display status :" + verify);

		fluentwait(auditBatchingPage.batchSummaryTable());
		verify = isElementDisplayed(auditBatchingPage.batchSummaryTable());
		softAssert.assertTrue(verify, "Batch Summary table display status :"
				+ verify);
		Reporter.log("Batch Summary table display status " + verify);

		fluentwait(auditBatchingPage.batchedDetailsTable());
		verify = isElementDisplayed(auditBatchingPage.batchedDetailsTable());
		softAssert.assertTrue(verify, "Batch Details table display status :"
				+ verify);
		Reporter.log("Batch details table display status :" + verify);

		// Verifying Invoice link
		fluentwait(auditInvoicePage.invoiceLink());
		verify = isElementDisplayed(auditInvoicePage.invoiceLink());
		softAssert.assertTrue(verify, "Audit Invoice link display status :"
				+ verify);
		Reporter.log("Audit Invoice link display status :" + verify);
		click(auditInvoicePage.invoiceLink());

		fluentwait(auditInvoicePage.invoicesTable());
		verify = isElementDisplayed(auditInvoicePage.invoicesTable());
		softAssert.assertTrue(verify, "Audit Invoice table display status :"
				+ verify);
		Reporter.log("Audit Invoice table display status :" + verify);

		switchtoFrame( auditInvoicePage.iframeCredit());
		fluentwait(auditInvoicePage.invoiceCreditLink());
		verify = isElementDisplayed(auditInvoicePage.invoiceCreditLink());
		softAssert.assertTrue(verify,
				"Audit Invoice Credit Link display status :" + verify);
		Reporter.log("Audit Invoice Credit Link display status :" + verify);
		click(auditInvoicePage.invoiceCreditLink());

		fluentwait(auditInvoicePage.invoiceCreditTable());
		verify = isElementDisplayed(auditInvoicePage.invoiceCreditTable());
		softAssert.assertTrue(verify,
				"Audit Invoice Credit table display status :" + verify);
		Reporter.log("Audit Invoice Credit table display status :" + verify);

		fluentwait(auditInvoicePage.invoiceVoidLink());
		verify = isElementDisplayed(auditInvoicePage.invoiceVoidLink());
		softAssert.assertTrue(verify,"Audit Invoice Void Link display status :" + verify);
		Reporter.log("Audit Invoice Void Link display status : " + verify);
		click(auditInvoicePage.invoiceVoidLink());

		fluentwait(auditInvoicePage.invoiceVoidTable());
		verify = isElementDisplayed(auditInvoicePage.invoiceVoidTable());
		softAssert.assertTrue(verify,
				"Audit Invoice Void table display status :" + verify);
		Reporter.log("Audit Invoice Void table display status :" + verify);

		fluentwait(auditInvoicePage.invoiceRefundLink());
		verify = isElementDisplayed(auditInvoicePage.invoiceRefundLink());
		softAssert.assertTrue(verify,
				"Audit Invoice Refund link display status :" + verify);
		Reporter.log("Audit Invoice Refund link display status :" + verify);
		click(auditInvoicePage.invoiceRefundLink());

		fluentwait(auditInvoicePage.invoiceRefundTable());
		verify = isElementDisplayed(auditInvoicePage.invoiceRefundTable());
		softAssert.assertTrue(verify,
				"Audit Invoice Refund table display status :" + verify);
		Reporter.log("Audit Invoice Refund table display status :" + verify);

		switchtoFrame(null);
		// Verifying Possible dupes link
		WebElement IFRAMEpossibleDupesLink = auditPossibleDupesPage
				.possibleDupesLinkiframe();

		fluentwait(auditPossibleDupesPage.possibleDupesLink());
		verify = isElementDisplayed(auditPossibleDupesPage.possibleDupesLink());
		softAssert.assertTrue(verify,
				"Audit Possible Dupes link display status :" + verify);
		Reporter.log("Audit Possible Dupes link display status " + verify);
		WebElement possibledupesLink = auditPossibleDupesPage
				.possibleDupesLink();
		// auditPossibleDupesPage.possibleDupesLink());
		click(possibledupesLink);

		// switchtoFrame(IFRAMEpossibleDupesLink);
		// fluentwait(auditPossibleDupesPage.possibleDupesTable());
		// verify=isElementDisplayed(auditPossibleDupesPage.possibleDupesTable());
		// softAssert.assertTrue(verify,"Possible dupes table display  status:"+verify);
		// Reporter.log("Possible dupes table display status:"+verify);

		switchtoFrame(null);

		// Verifying Summary link
		fluentwait(auditSummaryPage.summaryLink());
		verify = isElementDisplayed(auditSummaryPage.summaryLink());
		softAssert.assertTrue(verify, "Audit Summary link display status:"
				+ verify);
		Reporter.log("Audit Summary link display status " + verify);
		click(auditSummaryPage.summaryLink());

		fluentwait(auditSummaryPage.currMonthTable());
		verify = isElementDisplayed(auditSummaryPage.currMonthTable());
		softAssert.assertTrue(verify,
				"Current Month Credits table display status :" + verify);
		Reporter.log("Current Month Credits table display status " + verify);

		fluentwait(auditSummaryPage.custSummaryTable());
		verify = isElementDisplayed(auditSummaryPage.custSummaryTable());
		softAssert.assertTrue(verify, "Customer Summary table display status :"
				+ verify);
		Reporter.log("Customer Summary table display status ;" + verify);

		fluentwait(auditSummaryPage.OutReachgrph());
		verify = isElementDisplayed(auditSummaryPage.OutReachgrph());
		softAssert.assertTrue(verify, "Outbound Reach graph display status :"
				+ verify);
		Reporter.log("Outbound Reach graph display status : " + verify);

		fluentwait(auditSummaryPage.statementProcessedgrph());
		verify = isElementDisplayed(auditSummaryPage.statementProcessedgrph());
		softAssert
				.assertTrue(verify,
						"Incoming Statements Processed graph display status :"
								+ verify);
		Reporter.log("Incoming Statements Processed graph display status : "
				+ verify);

		fluentwait(auditSummaryPage.openClaimsBySpendGrph());
		verify = isElementDisplayed(auditSummaryPage.openClaimsBySpendGrph());
		softAssert.assertTrue(verify,
				"Analysis of Open Claims - By Spend graph display status :"
						+ verify);
		Reporter.log("Analysis of Open Claims - By Spend graph display status : "
				+ verify);

		fluentwait(auditSummaryPage.openClaimsByCountGrph());
		verify = isElementDisplayed(auditSummaryPage.openClaimsByCountGrph());
		softAssert.assertTrue(verify,
				"Analysis of Open Claims - By Count graph display status :"
						+ verify);
		Reporter.log("Analysis of Open Claims - By Count graph display status : "
				+ verify);

		fluentwait(auditSummaryPage.subClaimsBySpendGrph());
		verify = isElementDisplayed(auditSummaryPage.openClaimsBySpendGrph());
		softAssert.assertTrue(verify,
				"Analysis of Submitted Claims - By Spend graph display status:"
						+ verify);
		Reporter.log("Analysis of Submitted Claims - By Spend graph display status : "
				+ verify);

		fluentwait(auditSummaryPage.subClaimsByCountGrph());
		verify = isElementDisplayed(auditSummaryPage.openClaimsByCountGrph());
		softAssert.assertTrue(verify,
				"Analysis of Submitted Claims - By Count graph display status :"
						+ verify);
		Reporter.log("Analysis of Submitted Claims - By Count graph display status : "
				+ verify);

		fluentwait(auditSummaryPage.totalCreditsgrph());
		verify = isElementDisplayed(auditSummaryPage.totalCreditsgrph());
		softAssert.assertTrue(verify,
				"Total Credits Entered graph display status :" + verify);
		Reporter.log("Total Creditd Entered graph display status : " + verify);

		// Verifying Check Registry link
		fluentwait(auditCheckRegistryPage.chkRegLink());
		verify = isElementDisplayed(auditCheckRegistryPage.chkRegLink());
		softAssert.assertTrue(verify,
				"Audit Check Registry link display status :" + verify);
		Reporter.log("Audit Check Registry link display status :" + verify);
		click(auditCheckRegistryPage.chkRegLink());

		fluentwait(auditCheckRegistryPage.chkRegList());
		verify = isElementDisplayed(auditCheckRegistryPage.chkRegList());
		softAssert.assertTrue(verify, "Check Registry table display status :"
				+ verify);
		Reporter.log("Check Registry table display status : " + verify);

		fluentwait(auditCheckRegistryPage.addNewBtn());
		verify = isElementDisplayed(auditCheckRegistryPage.addNewBtn());
		softAssert.assertTrue(verify, "Add New button display status :"+ verify);
		Reporter.log("Add new button display status " + verify);

		// Verifying Customer KPI link
		fluentwait(auditCustomerKPIPage.customerKPILink());
		verify = isElementDisplayed(auditCustomerKPIPage.customerKPILink());
		softAssert.assertTrue(verify, "Customer KPI link display status :"+ verify);
		Reporter.log("Customer KPI link display status :" + verify);

		click(auditCustomerKPIPage.customerKPILink());

		fluentwait(auditCustomerKPIPage.customerKPILink());
		verify = isElementDisplayed(auditCustomerKPIPage.customerKPILink());
		softAssert.assertTrue(verify, "Customer KPI link display status :"
				+ verify);
		Reporter.log("Customer KPI link display status :" + verify);

		softAssert.assertAll();
		Reporter.log("Sanity ,Audit Test Ends at:" + currenttime());

	}

	// Verifying main claims link
	@Test(priority = 3)
	public void SanityClaimsPage() {

		Reporter.log("Sanity ,Claims Test starts at:" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		waitForTime(3000);
		fluentwait(mainClaimsPage.claimsLink());
		boolean verify = isElementDisplayed(mainClaimsPage.claimsLink());
		softAssert.assertTrue(verify, "Main Claims link display status :"
				+ verify);
		Reporter.log("Main Claims link display status :" + verify);
		click(mainClaimsPage.claimsLink());
		waitforPageload(mainClaimsPage.totalClaimsTable());
		fluentwait(mainClaimsPage.totalClaimsTable());
		verify = isElementDisplayed(mainClaimsPage.totalClaimsTable());
		softAssert.assertTrue(verify, "Total Claims table display status :"
				+ verify);
		Reporter.log("Total Claims table display status :" + verify);

		fluentwait(mainClaimsPage.claimsListTable());
		verify = isElementDisplayed(mainClaimsPage.claimsListTable());
		softAssert.assertTrue(verify, "Claims List table display status:"
				+ verify);
		Reporter.log("Claims List table display status :" + verify);

		fluentwait(mainClaimsPage.doIconClaimsList());
		verify = isElementDisplayed(mainClaimsPage.doIconClaimsList());
		softAssert.assertTrue(verify, "Doc Icon Claims List display status :"
				+ verify);
		Reporter.log("Doc Icon Claims List display status :" + verify);

		fluentwait(mainClaimsPage.docIconReference());
		verify = isElementDisplayed(mainClaimsPage.docIconReference());
		softAssert.assertTrue(verify, "Doc Icon Claims List reference status :"
				+ verify);
		Reporter.log("Doc Icon Reference status:" + verify);

		fluentwait(mainClaimsPage.docIconAmt());
		verify = isElementDisplayed(mainClaimsPage.docIconAmt());
		softAssert.assertTrue(verify, "Doc Icon Amount display status :"
				+ verify);
		Reporter.log("Doc Icon Amount display status " + verify);

		fluentwait(mainClaimsPage.claimListSuppRefence());
		verify = isElementDisplayed(mainClaimsPage.claimListSuppRefence());
		softAssert.assertTrue(verify, "Supplier reference display status:"
				+ verify);
		Reporter.log("Supplier reference display status :" + verify);

		fluentwait(mainClaimsPage.claimListSuppRefence());
		verify = isElementDisplayed(mainClaimsPage.claimListSuppRefence());
		softAssert.assertTrue(verify, "Supplier reference display status :"
				+ verify);
		Reporter.log("Supplier reference display status :" + verify);

		fluentwait(mainClaimsPage.claimListAmt());
		verify = isElementDisplayed(mainClaimsPage.claimListAmt());
		softAssert.assertTrue(verify, "Claim List Amount display status :"
				+ verify);
		Reporter.log("Claim List Amount displayed" + verify);

		fluentwait(mainClaimsPage.claimListAmt());
		verify = isElementDisplayed(mainClaimsPage.claimListAmt());
		softAssert.assertTrue(verify, "Claim List Amount display status :"
				+ verify);
		Reporter.log("Claim List Amount display status :" + verify);

		fluentwait(mainClaimsPage.claimListStatus());
		verify = isElementDisplayed(mainClaimsPage.claimListStatus());
		softAssert.assertTrue(verify, "Claim List Status display :" + verify);
		Reporter.log("Claim List Status display :" + verify);

		fluentwait(mainClaimsPage.editClaimsIcon());
		verify = isElementDisplayed(mainClaimsPage.editClaimsIcon());
		softAssert.assertTrue(verify, "Edit Claims Icon display status :"
				+ verify);
		Reporter.log("Edit Claims Icon displayed display status :" + verify);

		softAssert.assertAll();
		Reporter.log("Sanity ,Claim Test Ends at:" + currenttime());

	}

	// Verifying main Invoices link
	@Test(priority = 4)
	public void SanityInvoicePage() {

		Reporter.log("Sanity ,Invoices Test starts at:" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		waitForTime(3000);
		fluentwait(invoicesPage.invoicesLink());
		boolean verify = isElementDisplayed(invoicesPage.invoicesLink());
		softAssert
				.assertTrue(verify, "Invoices link display status :" + verify);
		Reporter.log("Invoices link display status :" + verify);
		click(invoicesPage.invoicesLink());

		fluentwait(invoicesPage.invoiceSummaryTable());
		verify = isElementDisplayed(invoicesPage.invoiceSummaryTable());
		softAssert.assertTrue(verify, "Invoice Summary Table display status :"
				+ verify);
		Reporter.log("Invoice Summary Table display status :" + verify);

		fluentwait(invoicesPage.invoiceSummaryDetailsTable());
		verify = isElementDisplayed(invoicesPage.invoiceSummaryDetailsTable());
		softAssert.assertTrue(verify,
				"Invoice Summary Details Table display status :" + verify);
		Reporter.log("Invoice Summary Details Table display status :" + verify);

		fluentwait(invoicesPage.invoicesCreditLink());
		verify = isElementDisplayed(invoicesPage.invoicesCreditLink());
		softAssert.assertTrue(verify, "Invoice Credit Link display status :"
				+ verify);
		Reporter.log("Invoice Credit Link display status :" + verify);
		click(invoicesPage.invoicesCreditLink());

		fluentwait(invoicesPage.invoicesCreditTable());
		verify = isElementDisplayed(invoicesPage.invoicesCreditTable());
		softAssert.assertTrue(verify, "Invoice Credit table display status :"
				+ verify);
		Reporter.log("Invoice Credit table display status :" + verify);

		fluentwait(invoicesPage.invoicesVoidLink());
		verify = isElementDisplayed(invoicesPage.invoicesVoidLink());
		softAssert.assertTrue(verify, "Invoice Void link display status :"
				+ verify);
		Reporter.log("Invoice Void link display status :" + verify);
		click(invoicesPage.invoicesVoidLink());

		fluentwait(invoicesPage.invoicesVoidTable());
		verify = isElementDisplayed(invoicesPage.invoicesVoidTable());
		softAssert.assertTrue(verify, "Invoice Void table display status :"
				+ verify);
		Reporter.log("Invoice Void table display status :" + verify);

		fluentwait(invoicesPage.invoicesRefundLink());
		verify = isElementDisplayed(invoicesPage.invoicesRefundLink());
		softAssert.assertTrue(verify, "Invoice Refund Link display status :"
				+ verify);
		Reporter.log("Invoice Refund Link display status :" + verify);

		click(invoicesPage.invoicesRefundLink());

		fluentwait(invoicesPage.invoicesRefundTable());
		verify = isElementDisplayed(invoicesPage.invoicesRefundTable());
		softAssert.assertTrue(verify, "Invoice Refund table display status :"
				+ verify);
		Reporter.log("Invoice Refund table display status :" + verify);

		softAssert.assertAll();
		Reporter.log("Sanity ,Invoices Test Ends at:" + currenttime());

	}

	// Verifying Reports link
	@Test(priority = 5)
	public void SanityReportsPage() {

		Reporter.log("Sanity ,Reports Test starts at:" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		waitForTime(6000);
		fluentwait(reportsPage.reportsLink());
		boolean verify = isElementDisplayed(reportsPage.reportsLink());
		softAssert.assertTrue(verify, "Report link display status :" + verify);
		Reporter.log("Report link display status :" + verify);
		click(reportsPage.reportsLink());

		// fluentwait(reportsPage.clientReportLink());
		// verify=isElementDisplayed(reportsPage.clientReportLink());
		// softAssert.assertTrue(verify,"Client Report link displayed:"+verify);
		// Reporter.log("Client Report link displayed"+verify);

		fluentwait(reportsPage.selectBatch());
		verify = isElementDisplayed(reportsPage.selectBatch());
		softAssert.assertTrue(verify, "Select Report link display status :"
				+ verify);
		Reporter.log("Select Report link display status :" + verify);

		fluentwait(reportsPage.reportsData());
		verify = isElementDisplayed(reportsPage.reportsData());
		softAssert.assertTrue(verify, "Reports data display status :" + verify);
		Reporter.log("Reports data display status :" + verify);

		softAssert.assertAll();
		Reporter.log("Sanity ,Reports Test Ends at:" + currenttime());

	}

	// Verifying Configuration link
	@Test(priority = 6)
	public void SanityConfigurationPage() throws InterruptedException {

		Reporter.log("Sanity ,Configuration Test starts at:" + currenttime());

		SoftAssert softAssert = new SoftAssert();

		waitForTime(6000);
		fluentwait(configurationPage.configurationLink());
		boolean verify = isElementDisplayed(configurationPage
				.configurationLink());
		softAssert.assertTrue(verify, "Configuration link display status :"
				+ verify);
		Reporter.log("Configuration link display status :" + verify);
		click(configurationPage.configurationLink());

		waitForTime(6000);
		fluentwait(auditPage.setUpLink());
		verify = isElementDisplayed(auditPage.setUpLink());
		softAssert.assertTrue(verify, "Set Up link display status :" + verify);
		Reporter.log("Set Up link display status :" + verify);
		click(auditPage.setUpLink());

		waitForTime(6000);
		fluentwait(auditPage.setUpAuditLink());
		verify = isElementDisplayed(auditPage.setUpAuditLink());
		softAssert.assertTrue(verify, "Set Up Audit link display status :"
				+ verify);
		Reporter.log("Set Up Audit link display status :" + verify);
		click(auditPage.setUpAuditLink());

		// fluentwait(auditPage.setUpAuditLink());
		// verify=isElementDisplayed(auditPage.setUpAuditLink());
		// softAssert.assertTrue(verify,"Set Up Audit link displayed:"+verify);
		// Reporter.log("Set Up Audit link displayed"+verify);

		fluentwait(auditPage.saveBtn());
		verify = isElementDisplayed(auditPage.saveBtn());
		softAssert.assertTrue(verify, "Save button display status :" + verify);
		Reporter.log("Save button display status :" + verify);

		fluentwait(auditPage.addNewBtn());
		verify = isElementDisplayed(auditPage.addNewBtn());
		softAssert.assertTrue(verify, "Add new button display status :"
				+ verify);
		Reporter.log("Add new button display status :" + verify);

		fluentwait(auditPage.vrlCredits());
		verify = isElementDisplayed(auditPage.vrlCredits());
		softAssert.assertTrue(verify, "VRL credits field display status :"
				+ verify);
		Reporter.log("VRL credits field display status :" + verify);

		// Client link
		waitForTime(6000);
		fluentwait(clientPage.clientLink());
		verify = isElementDisplayed(clientPage.clientLink());
		softAssert.assertTrue(verify, "Client link display status :" + verify);
		Reporter.log("Client link display status " + verify);
		click(clientPage.clientLink());

		fluentwait(clientPage.clientTable());
		verify = isElementDisplayed(clientPage.clientTable());
		softAssert.assertTrue(verify, "Client table display status :" + verify);
		Reporter.log("Client table  display status :" + verify);

		fluentwait(clientPage.saveBtn());
		verify = isElementDisplayed(clientPage.saveBtn());
		softAssert.assertTrue(verify, "Save button display status :" + verify);
		Reporter.log("Save button display status :" + verify);

		fluentwait(clientPage.cancelBtn());
		verify = isElementDisplayed(clientPage.cancelBtn());
		softAssert
				.assertTrue(verify, "Cancel button display status :" + verify);
		Reporter.log("Cancel button display status :" + verify);

		// Business Unit link

		fluentwait(businessUnitPage.businessUnitLink());
		verify = isElementDisplayed(businessUnitPage.businessUnitLink());
		softAssert.assertTrue(verify, "Business units link displayed:" + verify);
		Reporter.log("Business Units link display status :" + verify);
		click(businessUnitPage.businessUnitLink());

		fluentwait(businessUnitPage.businessUnitTable());
		verify = isElementDisplayed(businessUnitPage.businessUnitTable());
		softAssert.assertTrue(verify, "Business units table display status :"
				+ verify);
		Reporter.log("Business Unit table display status :" + verify);

		// Preferences link
		fluentwait(preferencesPage.preferencesLink());
		verify = isElementDisplayed(preferencesPage.preferencesLink());
		softAssert.assertTrue(verify, "Preferences link display status :"
				+ verify);
		Reporter.log("Preferences link display status :" + verify);
		preferencesPage.verifypreferencesLink();
		//preferencesPage.preferencesLink());

		fluentwait(preferencesPage.preferncesTable());
		verify = isElementDisplayed(preferencesPage.preferncesTable());
		softAssert.assertTrue(verify, "Preferences table display status :"
				+ verify);
		Reporter.log("Preferences table displayed" + verify);

		fluentwait(preferencesPage.saveBtn());
		verify = isElementDisplayed(preferencesPage.saveBtn());
		softAssert.assertTrue(verify, "Save button display status :" + verify);
		Reporter.log("Save button display status :" + verify);

		fluentwait(preferencesPage.resetBtn());
		verify = isElementDisplayed(preferencesPage.resetBtn());
		softAssert.assertTrue(verify, "Reset button display status :" + verify);
		Reporter.log("Reset button display status :" + verify);

		// Request letter
		fluentwait(requestLettersPage.reqLetterLink());
		verify = isElementDisplayed(requestLettersPage.reqLetterLink());
		softAssert.assertTrue(verify, "Request link display status :" + verify);
		Reporter.log("Request link display status :" + verify);
		click(requestLettersPage.reqLetterLink());

		fluentwait(requestLettersPage.reqLetterTable());
		verify = isElementDisplayed(requestLettersPage.reqLetterTable());
		softAssert.assertTrue(verify, "Request letter table display status :"
				+ verify);
		Reporter.log("Request letter table display status :" + verify);

		fluentwait(requestLettersPage.saveBtn());
		verify = isElementDisplayed(requestLettersPage.saveBtn());
		softAssert.assertTrue(verify, "Save button display status :" + verify);
		Reporter.log("Save button display status :" + verify);

		fluentwait(requestLettersPage.resetBtn());
		verify = isElementDisplayed(requestLettersPage.resetBtn());
		softAssert.assertTrue(verify, "Reset button display status :" + verify);
		Reporter.log("Reset button display status :" + verify);

		// Manage Currency
		fluentwait(manageCurrencyPage.manCurrencyLink());
		verify = isElementDisplayed(manageCurrencyPage.manCurrencyLink());
		softAssert.assertTrue(verify, "Manage Currencyy link display status :"
				+ verify);
		Reporter.log("Manage Currency link display status :" + verify);
		click(manageCurrencyPage.manCurrencyLink());

		fluentwait(manageCurrencyPage.manageCurrencyTable());
		verify = isElementDisplayed(manageCurrencyPage.manageCurrencyTable());
		softAssert.assertTrue(verify, "Manage Currencyy table display status :"
				+ verify);
		Reporter.log("Manage Currency table display status :" + verify);

		fluentwait(manageCurrencyPage.saveBtn());
		verify = isElementDisplayed(manageCurrencyPage.saveBtn());
		softAssert.assertTrue(verify, "Save button display status :" + verify);
		Reporter.log("Save button display status :" + verify);

		fluentwait(manageCurrencyPage.resetBtn());
		verify = isElementDisplayed(manageCurrencyPage.resetBtn());
		softAssert.assertTrue(verify, "Reset button display status :" + verify);
		Reporter.log("Reset button display status :" + verify);

		// Jobs Sub menu
		waitForTime(6000);
		fluentwait(faxJobPage.configurationJobsLink());
		verify = isElementDisplayed(faxJobPage.configurationJobsLink());
		softAssert.assertTrue(verify, "Jobs link display status :" + verify);
		Reporter.log("Jobs link display status :" + verify);
		click(faxJobPage.configurationJobsLink());

		waitForTime(3000);
		fluentwait(faxJobPage.faxJobsLink());

		verify = isElementDisplayed(faxJobPage.faxJobsLink());
		softAssert
				.assertTrue(verify, "Fax Jobs link display sttaus :" + verify);
		Reporter.log("Fax Jobs link display status :" + verify);
		WebElement faxl = faxJobPage.faxJobsLink();
		click(faxl);

		fluentwait(faxJobPage.faxJobsTable());
		verify = isElementDisplayed(faxJobPage.faxJobsTable());
		softAssert.assertTrue(verify, "Fax Jobs table display status :"
				+ verify);
		Reporter.log("Fax Jobs table display status :" + verify);

		// Background jobs
		/*fluentwait(backGroundJobsPage.backgroundJobsLink());
		verify = isElementDisplayed(backGroundJobsPage.backgroundJobsLink());
		softAssert.assertTrue(verify, "Background Jobs link display status :"
				+ verify);
		Reporter.log("Background jobs link display status :" + verify);
		WebElement backgroundJobsl = backGroundJobsPage.backgroundJobsLink();
		click(backgroundJobsl);

		fluentwait(backGroundJobsPage.backgroundJobsTable());
		verify = isElementDisplayed(backGroundJobsPage.backgroundJobsTable());
		softAssert.assertTrue(verify, "Background Jobs link display status :"
				+ verify);
		Reporter.log("Background jobs link display status :" + verify);*/

		// Account

		waitForTime(3000);
		fluentwait(usersPage.accountLink());
		verify = isElementDisplayed(usersPage.accountLink());
		softAssert.assertTrue(verify, "Account link display status :" + verify);
		Reporter.log("Account link display status :" + verify);
		WebElement accountl = usersPage.accountLink();
		click(accountl);

		// Users link
		fluentwait(usersPage.usersLink());
		verify = isElementDisplayed(usersPage.usersLink());
		softAssert.assertTrue(verify, "Users link display status :" + verify);
		Reporter.log("Users link display status :" + verify);
		WebElement usersl = usersPage.usersLink();
		click(usersl);

		fluentwait(usersPage.usersListTable());
		verify = isElementDisplayed(usersPage.usersListTable());
		softAssert.assertTrue(verify, "Users list table display status :"
				+ verify);
		Reporter.log("Users list table display status :" + verify);

		fluentwait(usersPage.addNewBtn());
		verify = isElementDisplayed(usersPage.addNewBtn());
		softAssert.assertTrue(verify, "Add New button display status :"
				+ verify);
		Reporter.log("Add new button display status :" + verify);

		// User groups
		waitForTime(6000);
		fluentwait(userGroupsPage.userGroupsLink());
		verify = isElementDisplayed(userGroupsPage.userGroupsLink());
		softAssert.assertTrue(verify, "Add New button display status :"
				+ verify);
		Reporter.log("Add new button display status :" + verify);

		WebElement userGroups = userGroupsPage.userGroupsLink();
		click(userGroups);

		fluentwait(userGroupsPage.userGroupsTable());
		verify = isElementDisplayed(userGroupsPage.userGroupsTable());
		softAssert.assertTrue(verify, "User groups table display status :"
				+ verify);
		Reporter.log("User groups table display status :" + verify);

		fluentwait(userGroupsPage.addNewBtn());
		verify = isElementDisplayed(userGroupsPage.addNewBtn());
		softAssert
				.assertTrue(verify, "Add new button display status:" + verify);
		Reporter.log("Add new button display status :" + verify);

		// Audit groups
		waitForTime(3000);
		fluentwait(auditGroupsPage.auditGroupsLink());
		verify = isElementDisplayed(auditGroupsPage.auditGroupsLink());
		softAssert.assertTrue(verify, "Audit groups link display status :"
				+ verify);
		Reporter.log("Audit groups link display status :" + verify);

		WebElement auditGroups = auditGroupsPage.auditGroupsLink();
		click(auditGroups);

		fluentwait(auditGroupsPage.auditGroupsTable());
		verify = isElementDisplayed(auditGroupsPage.auditGroupsTable());
		softAssert.assertTrue(verify, "Audit groups table display status :"
				+ verify);
		Reporter.log("Audit groups table display status :" + verify);

		fluentwait(auditGroupsPage.addNewBtn());
		verify = isElementDisplayed(auditGroupsPage.addNewBtn());
		softAssert.assertTrue(verify, "Add New button display status :"
				+ verify);
		Reporter.log("Add New button display status :" + verify);

		// Notification link
		waitForTime(3000);
		fluentwait(notificationPage.notifictionsLink());

		verify = isElementDisplayed(notificationPage.notifictionsLink());
		softAssert.assertTrue(verify, "Notifiction link display status :"
				+ verify);
		Reporter.log("Notification link display status :" + verify);

		WebElement notificationsl = notificationPage.notifictionsLink();
		click(notificationsl);

		fluentwait(notificationPage.notificationsTable());
		verify = isElementDisplayed(notificationPage.notificationsTable());
		softAssert.assertTrue(verify, "Notifiction table display status :"
				+ verify);
		Reporter.log("Notification table display status :" + verify);

		fluentwait(notificationPage.addNewBtn());
		verify = isElementDisplayed(notificationPage.addNewBtn());
		softAssert.assertTrue(verify, "Add New button display status :"
				+ verify);
		Reporter.log("Add New button display status :" + verify);

		// Finance Link

		waitForTime(3000);
		fluentwait(financeInvoicesPage.financeLink());
		verify = isElementDisplayed(financeInvoicesPage.financeLink());
		softAssert.assertTrue(verify, "Finance link display status :" + verify);
		Reporter.log("Finance link display status :" + verify);

		WebElement financel = financeInvoicesPage.financeLink();
		click(financel);

		fluentwait(financeInvoicesPage.finInvoicesLink());
		verify = isElementDisplayed(financeInvoicesPage.finInvoicesLink());
		softAssert.assertTrue(verify, "Finance Invoice link display status :"
				+ verify);
		Reporter.log("Finance Invoice link display status :" + verify);

		WebElement invoicesl = financeInvoicesPage.finInvoicesLink();
		click(invoicesl);

		fluentwait(financeInvoicesPage.finInvoicesTable());
		verify = isElementDisplayed(financeInvoicesPage.finInvoicesTable());
		softAssert.assertTrue(verify, "Finance Invoice table display status :"
				+ verify);
		Reporter.log("Finance Invoice table display status :" + verify);

		// Contract Details
		fluentwait(contractDetailsPage.finContractDetailsLink());
		verify = isElementDisplayed(contractDetailsPage
				.finContractDetailsLink());
		softAssert.assertTrue(verify, "Contract details link display status :"
				+ verify);
		Reporter.log("Contract Details link display status :" + verify);

		WebElement contractDetailsl = contractDetailsPage
				.finContractDetailsLink();
		click(contractDetailsl);

		fluentwait(contractDetailsPage.finContractDetailsTable());
		verify = isElementDisplayed(contractDetailsPage
				.finContractDetailsTable());
		softAssert.assertTrue(verify, "Contract details table display status:"
				+ verify);
		Reporter.log("Contract Details table display status :" + verify);

		// Uploads
		waitForTime(6000);
		fluentwait(uploadsPage.uploadsLink());
		verify = isElementDisplayed(uploadsPage.uploadsLink());
		softAssert.assertTrue(verify, "Uploads link display status :" + verify);
		Reporter.log("Uploads link display status :" + verify);
		WebElement uploadsl = uploadsPage.uploadsLink();
		click(uploadsl);

		fluentwait(uploadsPage.uploadFilesTable());
		verify = isElementDisplayed(uploadsPage.uploadFilesTable());
		softAssert.assertTrue(verify, "Upload Files table display status :"
				+ verify);
		Reporter.log("Upload Files table display status :" + verify);

		fluentwait(uploadsPage.templatesTable());
		verify = isElementDisplayed(uploadsPage.templatesTable());
		softAssert.assertTrue(verify, "Templates table display status :"
				+ verify);
		Reporter.log("Templates table display status :" + verify);

		fluentwait(uploadsPage.templatesTable());
		verify = isElementDisplayed(uploadsPage.templatesTable());
		softAssert.assertTrue(verify, "Templates table display status :"
				+ verify);
		Reporter.log("Templates table display status :" + verify);

		// Supplier Files
		waitForTime(3000);
		fluentwait(uploadsPage.uploadSuppFilesLink());
		verify = isElementDisplayed(uploadsPage.uploadSuppFilesLink());
		softAssert.assertTrue(verify,
				"Upload Supplier Files link display status :" + verify);
		Reporter.log("Upload Supplier Files link display status :" + verify);

		WebElement supplierFileslink = uploadsPage.uploadSuppFilesLink();
		click(supplierFileslink);

		fluentwait(uploadsPage.uploadSuppFilesTable());
		verify = isElementDisplayed(uploadsPage.uploadSuppFilesTable());
		softAssert.assertTrue(verify,
				"Upload Supplier Files table display status :" + verify);
		Reporter.log("Upload Supplier Files table display status :" + verify);

		// Request letter
		waitForTime(3000);
		fluentwait(uploadsPage.uploadReqLetterLink());
		verify = isElementDisplayed(uploadsPage.uploadSuppFilesTable());
		softAssert.assertTrue(verify,
				"Upload Supplier Files table display status :" + verify);
		Reporter.log("Upload Supplier Files table display status :" + verify);

		WebElement requestLetter = uploadsPage.uploadReqLetterLink();
		click(requestLetter);

		fluentwait(uploadsPage.uploadReqLetterTable());
		verify = isElementDisplayed(uploadsPage.uploadReqLetterTable());
		softAssert.assertTrue(verify, "Request letter table display status :"
				+ verify);
		Reporter.log("Request letter table display status :" + verify);

		// Credit Files
		fluentwait(uploadsPage.uploadCreditFileLink());
		verify = isElementDisplayed(uploadsPage.uploadCreditFileLink());
		softAssert.assertTrue(verify, "Credit File link display status :"
				+ verify);
		Reporter.log("Credit file link display status :" + verify);

		WebElement creditFiles = uploadsPage.uploadCreditFileLink();
		click(creditFiles);

		fluentwait(uploadsPage.creditFilesTable());
		verify = isElementDisplayed(uploadsPage.creditFilesTable());
		softAssert.assertTrue(verify, "Credit File table display status :"
				+ verify);
		Reporter.log("Credit file tabe display status :" + verify);

		// Exchange Rate Files
		fluentwait(uploadsPage.exchangeRateFileLink());
		verify = isElementDisplayed(uploadsPage.exchangeRateFileLink());
		softAssert.assertTrue(verify, "Exchange Rate File display status :"
				+ verify);
		Reporter.log("Exchange Rate File display status :" + verify);

		WebElement exchangeRateFiles = uploadsPage.exchangeRateFileLink();
		click(exchangeRateFiles);

		fluentwait(uploadsPage.exchangeRateFilesTable());
		verify = isElementDisplayed(uploadsPage.exchangeRateFilesTable());
		softAssert.assertTrue(verify, "Exchange Rate File table displayed:"
				+ verify);
		Reporter.log("Exchange Rate File table displayed" + verify);

		// Others link

		fluentwait(faxCommentsPage.othersLink());
		verify = isElementDisplayed(faxCommentsPage.othersLink());
		softAssert.assertTrue(verify, "Others link display status :" + verify);
		Reporter.log("Others link display status :" + verify);

		WebElement othersl = faxCommentsPage.othersLink();
		click(othersl);

		// Fax comments

		fluentwait(faxCommentsPage.othersFaxCommentsLink());
		verify = isElementDisplayed(faxCommentsPage.othersFaxCommentsLink());
		softAssert.assertTrue(verify, "Fax comments link display status :"
				+ verify);
		Reporter.log("Fax comments link display status :" + verify);

		WebElement faxCommentsl = faxCommentsPage.othersFaxCommentsLink();
		click(faxCommentsl);

		fluentwait(faxCommentsPage.othersFaxCommentsTable());
		verify = isElementDisplayed(faxCommentsPage.othersFaxCommentsTable());
		softAssert.assertTrue(verify, "Fax comments table display status :"
				+ verify);
		Reporter.log("Fax comments table display status :" + verify);

		fluentwait(faxCommentsPage.addNewBtn());
		verify = isElementDisplayed(faxCommentsPage.addNewBtn());
		softAssert.assertTrue(verify, "Add New button display status :"
				+ verify);
		Reporter.log("Add New button display status :" + verify);

		// Credit Rejection Reasons
		fluentwait(creditRejectionPage.othersCreditRejectionLink());
		verify = isElementDisplayed(creditRejectionPage
				.othersCreditRejectionLink());
		softAssert.assertTrue(verify,
				"Credit rejection Reasons link display status :" + verify);
		Reporter.log("Credit rejection reasons link display status :" + verify);

		WebElement creditRejectionReasonsl = creditRejectionPage
				.othersCreditRejectionLink();
		//click(creditRejectionReasonsl);
		creditRejectionPage.verifyOthersCreditRejectionLink();
		

		fluentwait(creditRejectionPage.othersCreditRejectionTable());
		verify = isElementDisplayed(creditRejectionPage
				.othersCreditRejectionTable());
		softAssert.assertTrue(verify, "Credit rejection table display status :"
				+ verify);
		Reporter.log("Credit rejection table display status :" + verify);

		fluentwait(creditRejectionPage.addNewBtn());
		verify = isElementDisplayed(creditRejectionPage.addNewBtn());
		softAssert.assertTrue(verify, "Add new button display status :"
				+ verify);
		Reporter.log("Add new button display status :" + verify);

		// Phone Extension
		fluentwait(phoneExtensionPage.othersPhoneExtensionLink());
		verify = isElementDisplayed(phoneExtensionPage
				.othersPhoneExtensionLink());
		softAssert.assertTrue(verify, "Phone Extension link display status :"
				+ verify);
		Reporter.log("Phone Extension link display status :" + verify);

		WebElement phoneExtension = phoneExtensionPage
				.othersPhoneExtensionLink();
		click(phoneExtension);

		fluentwait(phoneExtensionPage.othersPhoneExtensionTable());
		verify = isElementDisplayed(phoneExtensionPage
				.othersPhoneExtensionTable());
		softAssert.assertTrue(verify, "Phone Extension table display status :"
				+ verify);
		Reporter.log("Phone Extension table display status :" + verify);

		fluentwait(phoneExtensionPage.addNewBtn());
		verify = isElementDisplayed(phoneExtensionPage.addNewBtn());
		softAssert.assertTrue(verify, "Add new button display status :"
				+ verify);
		Reporter.log("Add new button display status :" + verify);

		// Mailer Registry
		fluentwait(mailerRegistryPage.mailerRegistryLink());
		verify = isElementDisplayed(mailerRegistryPage.mailerRegistryLink());
		softAssert.assertTrue(verify, "Mailer Registry link display status :"
				+ verify);
		Reporter.log("Mailer Registry link display status :" + verify);

		WebElement mailerRegistryl = mailerRegistryPage.mailerRegistryLink();
		click(mailerRegistryl);

		fluentwait(mailerRegistryPage.mailerRegistryTable());
		verify = isElementDisplayed(mailerRegistryPage.mailerRegistryTable());
		softAssert.assertTrue(verify, "Mailer Registry table display status :"
				+ verify);
		Reporter.log("Mailer Registry table display status :" + verify);

		fluentwait(mailerRegistryPage.addNewBtn());
		verify = isElementDisplayed(mailerRegistryPage.addNewBtn());
		softAssert.assertTrue(verify, "Add new button display status :"
				+ verify);
		Reporter.log("Add new button display status :" + verify);

		softAssert.assertAll();
		Reporter.log("Sanity ,Configuration Test Ends at:" + currenttime());

	}

	
	@Test(priority = 7)
	public void SanityAssignmentPage() {

		Reporter.log("Sanity ,Assignments Test starts at:" + currenttime());

		SoftAssert softassert = new SoftAssert();

		waitForTime(8000);
		fluentwait(holdsPage.assignmentsLink());
		boolean verify = isElementDisplayed(holdsPage.assignmentsLink());
		softassert.assertTrue(verify, "Assignments link display status :"
				+ verify);
		Reporter.log("Assignments link display status " + verify);
		click(holdsPage.assignmentsLink());

		// Holds link
		fluentwait(holdsPage.holdsLink());
		verify = isElementDisplayed(holdsPage.holdsLink());
		softassert.assertTrue(verify, "Holds link display status :" + verify);
		Reporter.log("Holds link display status :" + verify , true);
		holdsPage.verifyHoldsLink();

		fluentwait(holdsPage.holdsTable());
		verify = isElementDisplayed(holdsPage.holdsTable());
		softassert.assertTrue(verify, "Holds table display status :" + verify);
		Reporter.log("Holds table display status :" + verify);

		fluentwait(holdsPage.searchBtn());
		verify = isElementDisplayed(holdsPage.searchBtn());
		softassert
				.assertTrue(verify, "Search button display status :" + verify);
		Reporter.log("Search button display status :" + verify);

		// Credits link
		fluentwait(creditsPage.creditsLink());
		verify = isElementDisplayed(creditsPage.creditsLink());
		softassert.assertTrue(verify, "Credits link display status :" + verify);
		Reporter.log("Credits link display status :" + verify);
		click(creditsPage.creditsLink());

		fluentwait(creditsPage.creditsTable());
		verify = isElementDisplayed(creditsPage.creditsTable());
		softassert
				.assertTrue(verify, "Credits table display status :" + verify);
		Reporter.log("Credits table display status " + verify);

		fluentwait(creditsPage.searchBtn());
		verify = isElementDisplayed(creditsPage.searchBtn());
		softassert
				.assertTrue(verify, "Search button display status :" + verify);
		Reporter.log("Search button display status :" + verify);

		// Statements link
		fluentwait(statementsPage.statementsLink());
		verify = isElementDisplayed(statementsPage.statementsLink());
		softassert.assertTrue(verify, "Statements link display status :"
				+ verify);
		Reporter.log("Statements link display status :" + verify);
		click(statementsPage.statementsLink());

		fluentwait(statementsPage.statementsTable());
		verify = isElementDisplayed(statementsPage.statementsTable());
		softassert.assertTrue(verify, "Statements table display status :"
				+ verify);
		Reporter.log("Statements table display status :" + verify);

		fluentwait(statementsPage.searchBtn());
		verify = isElementDisplayed(statementsPage.searchBtn());
		softassert
				.assertTrue(verify, "Search button display status :" + verify);
		Reporter.log("Search button display status :" + verify);

		// Audit Statistics
		fluentwait(auditStatisticsPage.auditsStatisticsLink());
		verify = isElementDisplayed(auditStatisticsPage.auditsStatisticsLink());
		softassert.assertTrue(verify, "Audit Statistics link display status :"
				+ verify);
		Reporter.log("Audit Statistics link display status :" + verify);
		click(auditStatisticsPage.auditsStatisticsLink());

		fluentwait(auditStatisticsPage.auditStatsTable());
		verify = isElementDisplayed(auditStatisticsPage.auditStatsTable());
		softassert.assertTrue(verify, "Audit Statistics table display status :"
				+ verify);
		Reporter.log("Audit Statistics table display status :" + verify);

		softassert.assertAll();
		Reporter.log("Sanity ,Assignments Test Ends at:" + currenttime());

	}

	/**
	 * After Class Logout and Quit Method 
	 * 
	 * @author Piramanayagam.S
	 */
	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }
	
	
}
