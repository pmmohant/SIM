package lavante.recovery.pageobjects;

import org.openqa.selenium.support.PageFactory;

import lavante.recovery.pageobjects.Assignments.AuditStatisticsPage;
import lavante.recovery.pageobjects.Assignments.CreditsPage;
import lavante.recovery.pageobjects.Assignments.HoldsPage;
import lavante.recovery.pageobjects.Assignments.StatementsPage;
import lavante.recovery.pageobjects.Audit.AuditBatchingPage;
import lavante.recovery.pageobjects.Audit.AuditCheckRegistryPage;
import lavante.recovery.pageobjects.Audit.AuditContactEntryPage;
import lavante.recovery.pageobjects.Audit.AuditInboundPage;
import lavante.recovery.pageobjects.Audit.AuditInvoicePage;
import lavante.recovery.pageobjects.Audit.AuditOutboundPage;
import lavante.recovery.pageobjects.Audit.AuditPossibleDupesPage;
import lavante.recovery.pageobjects.Audit.AuditSummaryPage;
import lavante.recovery.pageobjects.Configuration.Account.AuditGroupsPage;
import lavante.recovery.pageobjects.Configuration.Account.NotificationPage;
import lavante.recovery.pageobjects.Configuration.Account.UserGroupsPage;
import lavante.recovery.pageobjects.Configuration.Account.UsersPage;
import lavante.recovery.pageobjects.Configuration.Finance.ContractDetailsPage;
import lavante.recovery.pageobjects.Configuration.Finance.FinanceInvoicesPage;
import lavante.recovery.pageobjects.Configuration.Jobs.BackGroundJobsPage;
import lavante.recovery.pageobjects.Configuration.Jobs.FaxJobPage;
import lavante.recovery.pageobjects.Configuration.MailerRegistry.MailerRegistryPage;
import lavante.recovery.pageobjects.Configuration.Others.CreditRejectionPage;
import lavante.recovery.pageobjects.Configuration.Others.FaxCommentsPage;
import lavante.recovery.pageobjects.Configuration.Others.PhoneExtensionPage;
import lavante.recovery.pageobjects.Configuration.Setup.AuditPage;
import lavante.recovery.pageobjects.Configuration.Setup.BusinessUnitPage;
import lavante.recovery.pageobjects.Configuration.Setup.ClientPage;
import lavante.recovery.pageobjects.Configuration.Setup.ManageCurrencyPage;
import lavante.recovery.pageobjects.Configuration.Setup.PreferencesPage;
import lavante.recovery.pageobjects.Configuration.Setup.RequestLettersPage;
import lavante.recovery.pageobjects.Configuration.Uploads.UploadsPage;
import lavante.recovery.pageobjects.DashBoard.ClaimsPage;
import lavante.recovery.pageobjects.DashBoard.CompliancePage;
import lavante.recovery.pageobjects.DashBoard.SupplierPage;
import lavante.recovery.utilities.seleniumBaseClass;


public class pageInitiator extends seleniumBaseClass {
	
	
	public LoginPage loginPage;
	public HomePage homePage;
	public InboundLandingPage inboundLandingPage;
	public ClaimsPage dashboardclaimsPage;
	public SupplierPage dashboardsupplierPage;
	public CompliancePage compliancePage;
	public AuditOutboundPage auditOutboundPage; 
	public AuditInboundPage auditInboundPage;
	public AuditContactEntryPage auditContactEntryPage;
	public AuditBatchingPage auditBatchingPage;
	public AuditInvoicePage auditInvoicePage;
	public AuditSummaryPage auditSummaryPage;
	public AuditPossibleDupesPage auditPossibleDupesPage;
	public AuditCheckRegistryPage auditCheckRegistryPage;
	public MainClaimsPage mainClaimsPage;
	public InvoicesPage invoicesPage;
	public ReportsPage reportsPage;
	public AuditStatisticsPage auditStatisticsPage;
	public CreditsPage creditsPage;
	public HoldsPage holdsPage;
	public StatementsPage statementsPage;
	public UsersPage usersPage;
	public UserGroupsPage userGroupsPage;
    public AuditGroupsPage auditGroupsPage;
	public NotificationPage notificationPage;
	public CreditRejectionPage creditRejectionPage;
	public FaxCommentsPage faxCommentsPage;
	public PhoneExtensionPage phoneExtensionPage;
	public MailerRegistryPage mailerRegistryPage;
	public ContractDetailsPage contractDetailsPage;
	public FinanceInvoicesPage financeInvoicesPage;
	public UploadsPage uploadsPage;
	public AuditPage auditPage;
	public BusinessUnitPage businessUnitPage;
	public ClientPage clientPage;
	public ManageCurrencyPage manageCurrencyPage;
	public PreferencesPage preferencesPage;
	public RequestLettersPage requestLettersPage;
	public GenericPageObjects genericPageObjects;
	public FaxJobPage faxJobPage;
	public BackGroundJobsPage backGroundJobsPage;
	
	
	public void initiate()
	{
		backGroundJobsPage = PageFactory.initElements(driver, BackGroundJobsPage.class);
		faxJobPage = PageFactory.initElements(driver, FaxJobPage.class);
		genericPageObjects = PageFactory.initElements(driver, GenericPageObjects.class);
	    loginPage = PageFactory.initElements(driver, LoginPage.class);
	    homePage = PageFactory.initElements(driver, HomePage.class);
	    inboundLandingPage = PageFactory.initElements(driver, InboundLandingPage.class);
	    dashboardclaimsPage = PageFactory.initElements(driver, ClaimsPage.class);
	    dashboardsupplierPage = PageFactory.initElements(driver, SupplierPage.class);
	    compliancePage = PageFactory.initElements(driver, CompliancePage.class);
	    auditOutboundPage = PageFactory.initElements(driver, AuditOutboundPage.class);
	    auditInboundPage = PageFactory.initElements(driver, AuditInboundPage.class);
	    auditContactEntryPage = PageFactory.initElements(driver, AuditContactEntryPage.class);
	    auditBatchingPage = PageFactory.initElements(driver, AuditBatchingPage.class);
	    auditInvoicePage = PageFactory.initElements(driver, AuditInvoicePage.class);
	    auditSummaryPage = PageFactory.initElements(driver, AuditSummaryPage.class);
	    auditPossibleDupesPage = PageFactory.initElements(driver, AuditPossibleDupesPage.class);
	    auditCheckRegistryPage = PageFactory.initElements(driver, AuditCheckRegistryPage.class);
	    mainClaimsPage = PageFactory.initElements(driver, MainClaimsPage.class);
	    invoicesPage = PageFactory.initElements(driver, InvoicesPage.class);
	    reportsPage = PageFactory.initElements(driver, ReportsPage.class);
	    auditStatisticsPage = PageFactory.initElements(driver, AuditStatisticsPage.class);
	    creditsPage = PageFactory.initElements(driver, CreditsPage.class);
	    holdsPage = PageFactory.initElements(driver, HoldsPage.class);
	    statementsPage = PageFactory.initElements(driver, StatementsPage.class);
	    usersPage = PageFactory.initElements(driver, UsersPage.class);
	    userGroupsPage = PageFactory.initElements(driver, UserGroupsPage.class);
	    auditGroupsPage = PageFactory.initElements(driver, AuditGroupsPage.class);
	    notificationPage = PageFactory.initElements(driver, NotificationPage.class);
	    auditPage = PageFactory.initElements(driver, AuditPage.class);
	    clientPage = PageFactory.initElements(driver, ClientPage.class);
	    businessUnitPage = PageFactory.initElements(driver, BusinessUnitPage.class);
	    preferencesPage = PageFactory.initElements(driver, PreferencesPage.class);
	    requestLettersPage = PageFactory.initElements(driver, RequestLettersPage.class);
	    manageCurrencyPage = PageFactory.initElements(driver, ManageCurrencyPage.class);
	    
	    financeInvoicesPage = PageFactory.initElements(driver, FinanceInvoicesPage.class);
	    contractDetailsPage = PageFactory.initElements(driver, ContractDetailsPage.class);
	    
	    uploadsPage = PageFactory.initElements(driver, UploadsPage.class);
	    
	    faxCommentsPage = PageFactory.initElements(driver, FaxCommentsPage.class);
	    creditRejectionPage = PageFactory.initElements(driver, CreditRejectionPage.class);
	    phoneExtensionPage = PageFactory.initElements(driver, PhoneExtensionPage.class);
	    
	    mailerRegistryPage = PageFactory.initElements(driver, MailerRegistryPage.class);
	    
	    
	}

}
