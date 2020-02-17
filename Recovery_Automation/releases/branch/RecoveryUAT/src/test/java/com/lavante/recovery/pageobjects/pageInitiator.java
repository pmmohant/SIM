package com.lavante.recovery.pageobjects;

import lavante.recovery.pageobjects.DashBoard.ClaimsPage;

import org.openqa.selenium.support.PageFactory;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.Dashboard.SupplierPage;
import com.lavante.recovery.pageobjects.Dashboard.CompliancePage;
import com.lavante.recovery.pageobjects.Invoice.InvoicePage;
import com.lavante.recovery.pageobjects.Audit.CheckRegistry.CheckRegistry;
import com.lavante.recovery.pageobjects.Audit.Batching.AuditBatchingPage;
import com.lavante.recovery.pageobjects.Audit.Inbound.AuditInboundPage;
import com.lavante.recovery.pageobjects.Audit.Invoice.AuditInvoicePage;
import com.lavante.recovery.pageobjects.Audit.ContactEntry.AuditContactEntryPage;
import com.lavante.recovery.pageobjects.configuration.Account.AccountPage;
import com.lavante.recovery.pageobjects.configuration.Finance.FinancePage;
import com.lavante.recovery.pageobjects.configuration.Others.OthersPage;
import com.lavante.recovery.pageobjects.configuration.SetUp.SetupPage;
import com.lavante.recovery.pageobjects.configuration.Uploads.UploadsPage;
import com.lavante.recovery.pageobjects.configuration.OutReach.OutReachPage;

public class pageInitiator extends LavanteUtils {
	
	public LoginPage loginPage;
	public HomePage homePage;

	public CompliancePage dashCompliancePage;
	public com.lavante.recovery.pageobjects.Dashboard.ClaimsPage dashboardclaimsPage;
	public SupplierPage suppDashboardPage;	

	public com.lavante.recovery.pageobjects.Claims.ClaimsPage claimsPage;
	
	public AuditBatchingPage auditBatchingPage;
	public AuditInboundPage auditInboundPage;
	public AuditContactEntryPage auditContactEntryPage;
	public AuditInvoicePage auditInvoicePage;
	public OthersPage configurationOthersPage;
	
	public CheckRegistry auditCheckRegPage;

	public InvoicePage invoicePage;
	
	public ConfigurationMailerRegistryPage configurationmailerregistryPage;
	public AccountPage configAcctPage;
	public SetupPage configSetUpPage;
	public FinancePage configFinancePage;
	public UploadsPage configUploadsPage;
	public OutReachPage configurationOutReachPage;	

	public ViewSupplierPage supplierPage;
	public SupplierListPage suppListPage;
	
	
	
	
	public void initiate()
	{

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
	    
	    dashboardclaimsPage = PageFactory.initElements(driver,com.lavante.recovery.pageobjects.Dashboard.ClaimsPage.class);
	    dashCompliancePage = PageFactory.initElements(driver,CompliancePage.class);
	    
	    
	    claimsPage = PageFactory.initElements(driver,com.lavante.recovery.pageobjects.Claims.ClaimsPage.class);
	    
	    auditInvoicePage = PageFactory.initElements(driver, AuditInvoicePage.class);
	    auditContactEntryPage = PageFactory.initElements(driver, AuditContactEntryPage.class);
	    auditCheckRegPage=PageFactory.initElements(driver, CheckRegistry.class);
	    
		configurationOthersPage = PageFactory.initElements(driver, OthersPage.class);
	    configAcctPage=PageFactory.initElements(driver, AccountPage.class);
	    configurationmailerregistryPage = PageFactory.initElements(driver , ConfigurationMailerRegistryPage.class);
	    

		auditInboundPage= PageFactory.initElements(driver, AuditInboundPage.class);
		auditBatchingPage = PageFactory.initElements(driver, AuditBatchingPage.class);

		invoicePage =PageFactory.initElements(driver, InvoicePage.class);
		
		configurationOutReachPage = PageFactory.initElements(driver, OutReachPage.class);
		configSetUpPage=PageFactory.initElements(driver,SetupPage.class);
	    configFinancePage=PageFactory.initElements(driver, FinancePage.class);
	    configUploadsPage=PageFactory.initElements(driver, UploadsPage.class);
		    
		
	    suppDashboardPage=PageFactory.initElements(driver, SupplierPage.class);
	    supplierPage=PageFactory.initElements(driver, ViewSupplierPage.class);
	    suppListPage=PageFactory.initElements(driver, SupplierListPage.class);
	}

}
