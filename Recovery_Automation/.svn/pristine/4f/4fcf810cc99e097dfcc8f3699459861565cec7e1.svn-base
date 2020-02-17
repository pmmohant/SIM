package lavante.recovery.testsuites.UAT;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lavante.recovery.pageobjects.pageInitiator;
import lavante.recovery.pageobjects.Audit.AuditCheckRegistryPage;
import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class SanityTestSuiteWithSeparateTestMethods extends pageInitiator {
	
  @BeforeClass
  @Parameters({ "Platform", "Browser", "Version" })
  public void preCondition(@Optional (LavanteUtils.Platform) String platform , @Optional (LavanteUtils.browser) String browser,@Optional (LavanteUtils.browserVersion) String version) throws Exception  {
 //public void preCondition() throws IOException {
	 
	  
	  launchAppThroughPOM(platform,browser,version);

	  initiate();
	  
	 // startTest("loginWithValidCredentials");
	    
	  loginPage.enterUserName("grace.yu");
	  loginPage.enterPassWord("Lavante#123");	
	  
	  waitForTime(5000);

	  loginPage.clickLoginButton();  
	  
	  waitForTime(5000);
      
	  homePage.verifyHomePageDisplayed();

	  //Close the pop up for Browser specific info
	  verifyBrowserStartPopUp();
	  
	  waitForTime(3000);
	  genericPageObjects.verifyAuditSelectBox();
	  genericPageObjects.verifyAuditSelectBoxTextBox();
	  	 
	//  endTest("loginWithValidCredentials");	 
  }

  //DashBoard Page
  @Test(priority = -1)
  public void verifyDashBoardLink(){
	  dashboardclaimsPage.verifyDashBoardLink();
  }
  
   //DashBoard--Claims
  @Test(priority = 0, dependsOnMethods = {"verifyDashBoardLink"})
  public void verifyDashBoardClaims(){ 
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
  }
  
  
  //DashBoard--Supplier
 @Test(priority = 1, dependsOnMethods = {"verifyDashBoardLink"})
  public void verifyDashBoardSupplier(){
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
  }
 
  //Dashboard--Compliance
  @Test(priority =2 , dependsOnMethods = {"verifyDashBoardLink"})
  public void verifyDashBoardCompliance(){
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
  
  @Test(priority = 3)
  public void verifyAuditLink(){
	  waitForTime(3000);
	  auditOutboundPage.verifyauditLink();  
  }  
 
  //Audit--Outbound page
  @Test(priority =4, dependsOnMethods = {"verifyAuditLink"})
  public void verifyauditOutboundPage(){
	 // auditOutboundPage.verifyoutboundLink();
	  auditOutboundPage.verifycurrentMonCredits();
	  auditOutboundPage.verifyauditContactDetails();
	  auditOutboundPage.verifyfurureCreditsGrph();
	  auditOutboundPage.verifyclaimHistoryGrph();
	  auditOutboundPage.verifysupplierStatus();
	  auditOutboundPage.verifypendingCorrespondence();
  }
  

  //Audit--Inbound page
  @Test(priority =5, dependsOnMethods = {"verifyAuditLink"})
  public void verifyauditInboundPage(){
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
  }
  
  //Audit--Contact Entry Page
  @Test(priority = 6, dependsOnMethods = {"verifyAuditLink"})
  public void verifycontactEntryPage(){  
	  //auditContactEntryPage.verifycontactEntryLink();
	  auditContactEntryPage.verifydocQueueTable();
	  auditContactEntryPage.verifysupDetailsTable();
	  auditContactEntryPage.verifydocDetails();  
  }

   
  //Audit--Batching page
  @Test(priority = 7, dependsOnMethods = {"verifyAuditLink"})
  public void verifyBatchingPage(){
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
  }    

  //Audit--Invoice page
  @Test(priority = 8, dependsOnMethods = {"verifyAuditLink"})
  public void verifyInvoicePage(){
	  
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
  }
  
  
  //Audit--Possible Dupes page
  @Test(priority = 9 , dependsOnMethods = {"verifyAuditLink"})
  public void verifyPossibleDupesPage(){  
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
  } 
  
  //Audit--Summary page
  @Test(priority = 10, dependsOnMethods = {"verifyAuditLink"})
  public void verifySummaryPage(){ 
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
  }
  
  //Audit--Check Registry page
  @Test(priority=11, dependsOnMethods = {"verifyAuditLink"})
  public void verifyCheckRegistryPage(){  
	  auditCheckRegistryPage.verifychkRegLink();
	  auditCheckRegistryPage.verifychkRegList();
	  auditCheckRegistryPage.verifyaddNewBtn();
  }  
  
  
  //Claims Page
  @Test(priority=12 ,alwaysRun = true)
  public void verifyClaimsPage(){  
	  waitForTime(3000);
	  mainClaimsPage.verifyclaimsLink();
	  mainClaimsPage.verifytotalClaimsTable();
	  mainClaimsPage.verifyclaimsListTable();
  } 
  
  //Invoices Page
  @Test(priority=13, alwaysRun = true)
  public void verifyInvoicesPage(){ 
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
  @Test(priority=14,alwaysRun = true)
  public void verifyReportsPage(){  
	  waitForTime(3000);
	  reportsPage.verifyreportsLink();
	  reportsPage.verifyreportsData();
  }
 
  //Configuration tab
 @Test(priority=15)
  public void verifyConfigTab(){
	 waitForTime(3000);
	  auditPage.verifyconfigurationLink();
  }
  
 
  //Configuration--Setup Page
  @Test(priority=16, dependsOnMethods = {"verifyConfigTab"})
  public void verifySetupPage(){
	auditPage.verifySetUpLink();
  }
  
  //Configuration--Setup Page--Audit page
  @Test(priority=17, dependsOnMethods = {"verifySetupPage"})
  public void verifySetupAuditPage(){
	 // auditPage.verifysetUpAuditLink(); 
	  auditPage.verifyaddNewBtn();
  }

  //Configuration--Setup--Client page
  @Test(priority=18, dependsOnMethods = {"verifySetupPage"})
  public void verifySetupClientPage(){
	  clientPage.verifyClientLink();
	  clientPage.verifyclientTable();
  }
  
  //Configuration--Setup--Business Unit Page
  @Test(priority=19, dependsOnMethods = {"verifySetupPage"})
  public void verifySetupBUPage(){
	  waitForTime(3000);
	  businessUnitPage.verifyBusinessUnitLink();
	  businessUnitPage.verifybusinessUnitTable();
  }
  
  //Configuration--Setup--Preferences page
  @Test(priority=20, dependsOnMethods = {"verifySetupPage"})
  public void verifySetupPreferencesPage(){
	  preferencesPage.verifypreferencesLink();
	  preferencesPage.verifyPreferencesTable();
  }
  
  //Configuration--Setup--Request Letters page
  @Test(priority=21, dependsOnMethods = {"verifySetupPage"})
  public void verifySetupReqLetterPage(){
	  requestLettersPage.verifyReqLetterLink();
	  requestLettersPage.verifyReqLetterTable();
  }
  
  //Configuration--Setup--Manage Currency page
  @Test(priority=22, dependsOnMethods = {"verifySetupPage"})
  public void verifySetupManageCurrencyPage(){
	  manageCurrencyPage.verifyManageCurrencyLink();
	  manageCurrencyPage.verifyManageCurrencyTable();
  }
  
  //Configuration--Jobs--Fax Jobs page
  @Test(priority=23, dependsOnMethods = {"verifyConfigTab"})
  public void verifyFaxJobsPage(){
	  faxJobPage.verifyConfigurationJobsLink();
	  waitForTime(10000);
	  faxJobPage.verifyFaxJobsTable();
  }
 
  //Configuration--Jobs--Background Jobs page
  @Test(priority=24, dependsOnMethods = {"verifyFaxJobsPage"})
  public void verifyBackGroundJobsPage(){
	  backGroundJobsPage.verifyBackgroundJobsLink();
	  backGroundJobsPage.verifyBackgroundJobsTable();
  }
  
  //Configuration--Account page
  @Test(priority=25, dependsOnMethods = {"verifyConfigTab"})
  public void verifyAccountPage(){
	  waitForTime(5000);
	  usersPage.verifyAccountLink();
  }
  
  //Configuration--Account--Users page
  @Test(priority=26, dependsOnMethods = {"verifyAccountPage"})
  public void verifyAccountUsersPage(){
	  usersPage.verifyUsersListTable();
	  usersPage.verifyaddNewBtn();
  }
  
  //Configuration--Account--User groups page
  @Test(priority=27, dependsOnMethods = {"verifyAccountPage"})
  public void verifyAccountUserGroupsPage(){
	  userGroupsPage.verifyUserGroupsLink();
	  userGroupsPage.verifyUserGroupsTable();
	  userGroupsPage.verifyaddNewBtn();
  }
  
  //Configuration--Account--Audit groups page
  @Test(priority=28, dependsOnMethods = {"verifyAccountPage"})
  public void verifyAccountAuditGroupsPage(){
	  auditGroupsPage.verifyAuditGroupsLink();
	  auditGroupsPage.verifyAuditGroupsTable();
	  auditGroupsPage.verifyaddNewBtn();
  }	  
  
  //Configuration--Account--Notification page
  @Test(priority=29, dependsOnMethods = {"verifyAccountPage"})
  public void verifyAccountNotificationPage(){ 
	  notificationPage.verifyNotificationsLink();
	  notificationPage.verifyNotificationsTable();
	  notificationPage.verifyaddNewBtn();
  }
  
  //Configuration--Finance page
  @Test(priority=30, dependsOnMethods = {"verifyConfigTab"})
  public void verifyFinancePage(){ 
	  financeInvoicesPage.verifyFinanceLink();
  }
  
  //Configuration--Finance--Invoices page
  @Test(priority=31, dependsOnMethods = {"verifyFinancePage"})
  public void verifyFinInvoicesPage(){ 
	  financeInvoicesPage.verifyFinInvoicesTable();
  }
  
  //Configuration--Finance--Contract Details page
  @Test(priority=32, dependsOnMethods = {"verifyFinancePage"})
  public void verifyFinContractDetailsPage(){ 
	  contractDetailsPage.verifyFinanaceContractDetailsLink();
	  contractDetailsPage.verifyfinContractDetailsTable();
  }   
  
  
  //Configuration--Uploads Page
  @Test(priority=33, dependsOnMethods = {"verifyConfigTab"})
  public void verifyUploadsPage(){ 
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
  }
   
 
  //Configuration--Others Page
  @Test(priority=34, dependsOnMethods = {"verifyConfigTab"})
  public void verifyOthersPage(){ 
	  waitForTime(3000);
	  faxCommentsPage.verifyOthersLink();
  }
  
  //Configuration--Others-Fax Comments Page
  @Test(priority=35, dependsOnMethods = {"verifyOthersPage"})
  public void verifyOthersFaxCommentsPage(){ 
	  waitForTime(5000);
	  faxCommentsPage.verifyOthersFaxCommentsLink();
	  faxCommentsPage.verifyOthersFaxCommentsTable();
	  faxCommentsPage.verifyaddNewBtn();
  }
  
  //Configuration--Others-Credit Rejection Reason Page
  @Test(priority=36, dependsOnMethods = {"verifyOthersPage"})
  public void verifyCreditrejectionPage(){
	  creditRejectionPage.verifyOthersCreditRejectionLink();
	  creditRejectionPage.verifyOthersCreditRejectionTable();
	  creditRejectionPage.verifyaddNewBtn();
  }
  
  //Configuration--Others-Phone Extension Reason Page
  @Test(priority=37, dependsOnMethods = {"verifyOthersPage"})
  public void verifyPhoneExtensionPage(){
	  phoneExtensionPage.verifyOthersPhoneExtensionLink();
	  phoneExtensionPage.verifyOthersPhoneExtensionTable();
	  phoneExtensionPage.verifyaddNewBtn();
  }
 
 
  //Configuration--Mailer Registry page
  @Test(priority=38, dependsOnMethods = {"verifyConfigTab"})
  public void verifyMailerRegistryPage(){
	  mailerRegistryPage.verifyMailerRegistryLink();
	  mailerRegistryPage.verifyMailerRegistryTable();
	  mailerRegistryPage.verifyaddNewBtn();  
  }
  
  //Assignments page
  @Test(priority=39)
  public void verifyAssignmentsPage(){ 
	  waitForTime(3000);
	  holdsPage.verifyAssignmentsLink();
  }
  
  //Assignments--Audit Statistics page
  @Test(priority=40, dependsOnMethods = {"verifyAssignmentsPage"})
  public void verifyauditStatisticsAssignmentsPage(){
	 // auditStatisticsPage.verifyauditStatisticsLink();
	  auditStatisticsPage.verifyauditStatsTable();
  }
  
//Assignments--Holds page
  @Test(priority=41, dependsOnMethods = {"verifyAssignmentsPage"})
  public void verifyHoldsAssignmentsPage(){ 
	  holdsPage.verifyHoldsLink();
	  holdsPage.verifyHoldsTable();
	  holdsPage.verifysearchBtn();
  }
  
  //Assignments--Credits page
  @Test(priority=42, dependsOnMethods = {"verifyAssignmentsPage"})
  public void verifyCreditsAssignmentsPage(){ 
	  creditsPage.verifycreditsLink();
	  creditsPage.verifycreditsTable();
	  creditsPage.verifysearchBtn();
  }
  
  //Assignments--Statements tab
  @Test(priority=43, dependsOnMethods = {"verifyAssignmentsPage"})
  public void verifyStatementsAssignmentsPage(){  
	  statementsPage.verifyStatementsLink();
	  statementsPage.verifyStatementsTable();
	  statementsPage.verifysearchBtn();
  }
  
  @AfterClass
  public void clean() {
	  quitBrowser();
  }
  
}
