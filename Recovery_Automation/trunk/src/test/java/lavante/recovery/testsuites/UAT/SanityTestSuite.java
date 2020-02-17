package lavante.recovery.testsuites.UAT;

import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.utilities.LavanteUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SanityTestSuite extends pageInitiator {
	
  @BeforeClass
  @Parameters({ "Platform", "Browser", "Version" })
  public void preCondition(@Optional (LavanteUtils.Platform) String platform , @Optional (LavanteUtils.browser) String browser,@Optional (LavanteUtils.browserVersion) String version) throws Exception  {

	  launchAppThroughPOM(platform,browser,version);
	  initiate();
	  openAPP();
	  
	  loginPage.login();
	  homePage.verifyHomePageDisplayed();

	  waitForTime(3000);
	  
	  genericPageObjects.SelectAudit("Brinker");
	  
  }

  //DashBoard Page
  @Test(priority = 0)
  public void verifyDashBoardLink(){
	  waitForTime(3000);
	  dashboardclaimsPage.verifyDashBoardLink();
	  //DashBoard--Claims
	  dashboardclaimsPage.verifyItemsForMySection();
	  dashboardclaimsPage.verifyBatchedClaimsLink();
	  dashboardclaimsPage.verifyBatchedClaims();
	  dashboardclaimsPage.verifyinvoicesLink();
	  dashboardclaimsPage.verifyInvoices();
	  
	  //Claim Graphs
	  dashboardclaimsPage.verifyclaimsByStatusChart();
	  dashboardclaimsPage.verifyclaimsByTypeChart();
	  dashboardclaimsPage.verifyallClaimsChart();
	  dashboardclaimsPage.verifyclaimsByOrgChart();
	  
	  //DashBoard--Supplier
	  dashboardsupplierPage.verifySupplierLink();
	  
	  //Supplier--Credit tab
	  dashboardsupplierPage.verifySupplierCreditTopSuppliers();
	  dashboardsupplierPage.verifyCreditFileStatistics();
	  
	  //Supplier--Spend tab
	  dashboardsupplierPage.verifySupplierSpendLink();
	  dashboardsupplierPage.verifySupplierSpendTopSuppliers();
	  dashboardsupplierPage.verifySpendFileStatistics();
	  
	  //Supplier--Check Request tab
	  dashboardsupplierPage.verifychkReqLink();
	  dashboardsupplierPage.verifychkReqTopSuppliers();
	  dashboardsupplierPage.verifyChkReqFileStatistics();
	  
	  //Supplier Graphs
	  dashboardsupplierPage.verifysupplierExcludedChart();
	  dashboardsupplierPage.verifysupplierTargetChart();
	  dashboardsupplierPage.verifysupplierChangeChart();
	  dashboardsupplierPage.verifyrelSupChart(); 
	  
	  //Dashboard--Compliance
	  //Compliance--Compliant
	  compliancePage.verifycomplainceLink();
	  compliancePage.verifycompliantTable();
	  compliancePage.verifycomplianceSummary();
	  
	 //Compliance--Non Compliant
	  waitForTime(2000);
	  compliancePage.verifynoncompliantLink();
	  compliancePage.verifynoncompliantTable();
	  compliancePage.verifynoncomplianceSummary();
	  
	  //Compliance Graphs
	  compliancePage.verifycomplianceBySpendChart();
	  compliancePage.verifycomplianceByCountChart();
	  compliancePage.verifycomplianceBySpendRankChart();
	  compliancePage.verifyOFACChart();
  }
  
  @Test(priority = 1)
  public void verifyAuditLink(){
	  waitForTime(3000);
	  auditOutboundPage.verifyauditLink(); 
	  
	  //Audit--Outbound page
	  // auditOutboundPage.verifyoutboundLink();
	  auditOutboundPage.verifycurrentMonCredits();
	  auditOutboundPage.verifyauditContactDetails();
	  auditOutboundPage.verifyfurureCreditsGrph();
	  auditOutboundPage.verifyclaimHistoryGrph();
	  auditOutboundPage.verifysupplierStatus();
	  auditOutboundPage.verifypendingCorrespondence();
	  
	  //Audit--Inbound page
	  //auditOutboundPage.verifyauditLink();
	  auditInboundPage.verifyinboundLink();
	  auditInboundPage.verifyinboundDocumentStatistics();
	  auditInboundPage.verifyinboundDocumentSummary();
	  
	  //Recognized faxes
	  auditInboundPage.RecognizedFax();
	  auditInboundPage.verifyStatements();
	  
	  auditInboundPage.verifyVerifications();
	  auditInboundPage.verifyVerificationsTable();
	  
	  auditInboundPage.verifyChecks();
	  auditInboundPage.verifyChecksTable();
	  
	  auditInboundPage.verifyCorrespondence();
	  auditInboundPage.verifyCorrespondenceTable();
	  
	  auditInboundPage.verifyDuplicate();
	  auditInboundPage.verifyDuplicateTable();
	  
	  auditInboundPage.verifyProfiles();
	  auditInboundPage.verifyprofilesTable();
	  
	  //Unrecognized faxes
	  auditInboundPage.UnrecognizedFax();
	  auditInboundPage.verifyStatements();
	  
	  auditInboundPage.verifyVerifications();
	  auditInboundPage.verifyVerificationsTable();
	  
	  auditInboundPage.verifyChecks();
	  auditInboundPage.verifyChecksTable();
	  
	  auditInboundPage.verifyCorrespondence();
	  auditInboundPage.verifyCorrespondenceTable();
	  
	  auditInboundPage.verifyDuplicate();
	  auditInboundPage.verifyDuplicateTable();
	  
	  auditInboundPage.verifyProfiles();
	  auditInboundPage.verifyprofilesTable();
	  
	  //DNA Fax
	  auditInboundPage.verifyDNAFax();
	  auditInboundPage.verifyStatements();
	  
	  auditInboundPage.verifyVerifications();
	  auditInboundPage.verifyVerificationsTable();
	  
	  auditInboundPage.verifyChecks();
	  auditInboundPage.verifyChecksTable();
	  
	  auditInboundPage.verifyCorrespondence();
	  auditInboundPage.verifyCorrespondenceTable();
	
	  auditInboundPage.verifyDuplicate();
	  auditInboundPage.verifyDuplicateTable();
	  
	  auditInboundPage.verifyProfiles();
	  auditInboundPage.verifyprofilesTable();
  
	  //Audit--Contact Entry Page
	//  auditContactEntryPage.verifycontactEntryLink();
	  auditContactEntryPage.verifydocQueueTable();
	  auditContactEntryPage.verifysupDetailsTable();
	  auditContactEntryPage.verifydocDetails();  

	  //Audit--Batching page
	  auditBatchingPage.verifybatchingLink(); 
	  
	  switchtoFramebyID(0);
	  auditBatchingPage.verifyunBatchedCreditsTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(1);
	  auditBatchingPage.verifybatchedClaimsTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(2);
	  auditBatchingPage.verifybatchSummaryTable();
	  switchBackDefault();

	  switchtoFramebyID(3);
	  auditBatchingPage.verifybatchedDetailsTable();  
	  switchBackDefault();  
    
	  //Audit--Invoice page
	  //auditOutboundPage.verifyauditLink(); 
	  auditInvoicePage.verifyinvoiceLink();
	  
	  switchtoFramebyID(0);
	  auditInvoicePage.verifyinvoicesTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(1);
	  auditInvoicePage.verifyinvoiceSummaryTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(2);
	  auditInvoicePage.verifyinvoiceCreditLink();
	  auditInvoicePage.verifyinvoiceCreditTable();  
	  switchBackDefault();
	  
	  switchtoFramebyID(2);
	  auditInvoicePage.verifyinvoiceVoidLink();
	  auditInvoicePage.verifyinvoiceVoidTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(2);
	  auditInvoicePage.verifyinvoiceRefundLink();
	  auditInvoicePage.verifyinvoiceRefundTable();
	  switchBackDefault();		
  
	  //Audit--Possible Dupes page
	  auditPossibleDupesPage.verifypossibleDupesLink();
	  
	  switchtoFramebyID(0);
	  auditPossibleDupesPage.verifypossDupSummaryTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(1);
	  auditPossibleDupesPage.verifypreBatchTable();
	  switchBackDefault();
	  
	  switchtoFramebyID(2);
	  auditPossibleDupesPage.verifypostBatchTable(); 
	  switchBackDefault();
	  
	  switchtoFramebyID(3);
	  auditPossibleDupesPage.verifypossDupDetailsTable();
	  switchBackDefault();
  
	  //Audit--Summary page
	  auditSummaryPage.verifysummaryLink();
	  auditSummaryPage.verifycurrMonthTable();
	  auditSummaryPage.verifycustSummaryTable();
	  auditSummaryPage.verifyOutReachgrph();  
	  auditSummaryPage.verifystatementProcessedgrph(); 
	  auditSummaryPage.verifyopenClaimsBySpendGrph(); 
	  auditSummaryPage.verifyopenClaimsByCountGrph(); 
	  auditSummaryPage.verifysubClaimsBySpendGrph(); 
	  auditSummaryPage.verifysubClaimsByCountGrph(); 
	  auditSummaryPage.verifytotalCreditsgrph(); 
  
	  //Audit--Check Registry page 
	  auditCheckRegistryPage.verifychkRegLink();
	  auditCheckRegistryPage.verifychkRegList();
	  auditCheckRegistryPage.verifyaddNewBtn();
  }  
  
  //Claims Page
  @Test(priority=2)
  public void verifyClaimsPage(){  
	  waitForTime(3000);
	  mainClaimsPage.verifyclaimsLink();
	  mainClaimsPage.verifytotalClaimsTable();
	  mainClaimsPage.verifyclaimsListTable();
  } 
  
  //Invoices Page
  @Test(priority=3)
  public void verifyInvoicesPage(){ 
	  waitForTime(3000);
	  invoicesPage.verifyinvoicesLink();
	  invoicesPage.verifyinvoiceSummaryTable();
	  invoicesPage.verifyinvoiceSummaryDetailsTable();
	  
	 //switchtoFramebyID(0);
	  invoicesPage.verifyinvoicesCreditLink();
	  invoicesPage.verifyinvoicesCreditTable();
	 //switchBackDefault();
	 
	  //switchtoFramebyID(1)
	  invoicesPage.verifyinvoicesVoidLink();
	  invoicesPage.verifyinvoicesVoidTable();
	  //switchBackDefault();
	  
	  //switchtoFramebyID(2);
	  invoicesPage.verifyinvoicesRefundLink();
	  invoicesPage.verifyinvoicesRefundTable();
	  //switchBackDefault();
  } 
  
  //Reports page 
  @Test(priority=4)
  public void verifyReportsPage(){  
	  waitForTime(3000);
	  reportsPage.verifyreportsLink();
	  reportsPage.verifyreportsData();
  }
 
  //Configuration tab
 @Test(priority=5)
  public void verifyConfigTab(){
	 waitForTime(3000);
	  auditPage.verifyconfigurationLink();
 
	  //Configuration--Setup Page
	  auditPage.verifySetUpLink();
  
	  //Configuration--Setup Page--Audit page
	  auditPage.verifyaddNewBtn();
 
	  //Configuration--Setup--Client page
	  clientPage.verifyClientLink();
	  clientPage.verifyclientTable();
  
	  //Configuration--Setup--Business Unit Page
	  waitForTime(3000);
	  businessUnitPage.verifyBusinessUnitLink();
	  businessUnitPage.verifybusinessUnitTable();
  
	  //Configuration--Setup--Preferences page
	  preferencesPage.verifypreferencesLink();
	  preferencesPage.verifyPreferencesTable();

	  //Configuration--Setup--Request Letters page
	  requestLettersPage.verifyReqLetterLink();
	  requestLettersPage.verifyReqLetterTable();
  
	  //Configuration--Setup--Manage Currency page
	  manageCurrencyPage.verifyManageCurrencyLink();
	  manageCurrencyPage.verifyManageCurrencyTable();
 
  
	  //Configuration--Jobs--Fax Jobs page
	  faxJobPage.verifyConfigurationJobsLink();
	  waitForTime(10000);
	  faxJobPage.verifyFaxJobsTable();
 
	  //Configuration--Jobs--Background Jobs page
	  backGroundJobsPage.verifyBackgroundJobsLink();
	  backGroundJobsPage.verifyBackgroundJobsTable();
  
	  //Configuration--Account page
	  waitForTime(5000);
	  usersPage.verifyAccountLink();
  
	  //Configuration--Account--Users page
	  usersPage.verifyUsersListTable();
	  usersPage.verifyaddNewBtn();		
  
	  //Configuration--Account--User groups page
	  userGroupsPage.verifyUserGroupsLink();
	  userGroupsPage.verifyUserGroupsTable();
	  userGroupsPage.verifyaddNewBtn();
  
	  //Configuration--Account--Audit groups page
	  auditGroupsPage.verifyAuditGroupsLink();
	  auditGroupsPage.verifyAuditGroupsTable();
	  auditGroupsPage.verifyaddNewBtn();
    
	  //Configuration--Account--Notification page
	  notificationPage.verifyNotificationsLink();
	  notificationPage.verifyNotificationsTable();
	  notificationPage.verifyaddNewBtn();
	  
	  //Configuration--Finance page
	  financeInvoicesPage.verifyFinanceLink();
  
	  //Configuration--Finance--Invoices page
	  financeInvoicesPage.verifyFinInvoicesTable();
  
	  //Configuration--Finance--Contract Details page 
	  contractDetailsPage.verifyFinanaceContractDetailsLink();
	  contractDetailsPage.verifyfinContractDetailsTable();

	  //Configuration--Uploads Page	
	  uploadsPage.verifyUploadsLink();
	  uploadsPage.verifyUploadFilesTable();
	  uploadsPage.verifyTemplatesTable();
  	  
	  uploadsPage.verifyuploadSuppFilesLink();
	  switchtoFramebyID(0);
	  uploadsPage.verifyUploadSuppFilesTable();
	  switchBackDefault();
	  
	  uploadsPage.verifyUploadReqLetterLink();
	  switchtoFramebyID(1);
	  uploadsPage.verifyUploadReqLetterTable();
	  switchBackDefault();
	  
	  uploadsPage.verifyuploadCreditFileLink();
	  switchtoFramebyID(2);
	  uploadsPage.verifyCreditFilesTable();
	  switchBackDefault();

	  //Configuration--Others Page
	  waitForTime(3000);
	  faxCommentsPage.verifyOthersLink();
  
	  //Configuration--Others-Fax Comments Page
	  waitForTime(5000);
	  faxCommentsPage.verifyOthersFaxCommentsLink();
	  faxCommentsPage.verifyOthersFaxCommentsTable();
	  faxCommentsPage.verifyaddNewBtn();

	  //Configuration--Others-Credit Rejection Reason Page
	  creditRejectionPage.verifyOthersCreditRejectionLink();
	  creditRejectionPage.verifyOthersCreditRejectionTable();
	  creditRejectionPage.verifyaddNewBtn();
  
	  //Configuration--Others-Phone Extension Reason Page
	  phoneExtensionPage.verifyOthersPhoneExtensionLink();
	  phoneExtensionPage.verifyOthersPhoneExtensionTable();
	  phoneExtensionPage.verifyaddNewBtn();
 
	  //Configuration--Mailer Registry page
	  mailerRegistryPage.verifyMailerRegistryLink();
	  mailerRegistryPage.verifyMailerRegistryTable();
	  mailerRegistryPage.verifyaddNewBtn();  
 }
 
   //Assignments page
  @Test(priority=6)
  public void verifyAssignmentsPage(){ 
	  waitForTime(3000);
	  holdsPage.verifyAssignmentsLink();
  
	  //Assignments--Audit Statistics page
	 // auditStatisticsPage.verifyauditStatisticsLink();
	  auditStatisticsPage.verifyauditStatsTable();
  
	  //Assignments--Holds page
	  holdsPage.verifyHoldsLink();
	  holdsPage.verifyHoldsTable();
	  holdsPage.verifysearchBtn();
  
	  //Assignments--Credits page
	  creditsPage.verifycreditsLink();
	  creditsPage.verifycreditsTable();
	  creditsPage.verifysearchBtn();
  
	  //Assignments--Statements tab
	  statementsPage.verifyStatementsLink();
	  statementsPage.verifyStatementsTable();
	  statementsPage.verifysearchBtn();
  }
  
  @AfterClass
  public void clean() {
	  quitBrowser();
  }
  
}
