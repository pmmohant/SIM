package lavante.recovery.pageobjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class InvoicesPage extends seleniumBaseClass{
	
	//Invoices Link
	@FindBy(linkText="Invoices")
	private WebElement invoicesLink;
		
	public void verifyinvoicesLink() {
		fluentwait(invoicesLink);
		click("invoicesLink",invoicesLink);
	}

	//Invoice Summary table
	@FindBy(css="#invoiceSummary tr td")
	private WebElement invoiceSummaryTable;
		
	public void verifyinvoiceSummaryTable() {
		fluentwait(invoiceSummaryTable);
		isDisplayed("invoiceSummaryTable",invoiceSummaryTable);
		verifyError(invoiceSummaryTable);	
	}
	
	//Invoice Summary Details table
	@FindBy(css="#invoiceSummaryDetails tr td")
	private WebElement invoiceSummaryDetailsTable;
		
	public void verifyinvoiceSummaryDetailsTable() {
		
		isDisplayed("invoiceSummaryDetailsTable",invoiceSummaryDetailsTable);
		verifyError(invoiceSummaryDetailsTable);	
	}
	
	//Invoices Credit Link
	@FindBy(css="a[data-tab*='credit']")
	private WebElement invoicesCreditLink;
		
	public void verifyinvoicesCreditLink() {
		fluentwait(invoicesCreditLink);
		click("invoicesCreditLink",invoicesCreditLink);
	}
	
	//Invoices Credit data table
	@FindBy(css="#credit tr td")
	private WebElement invoicesCreditTable;
		
	public void verifyinvoicesCreditTable() {
		fluentwait(invoicesCreditTable);
		isDisplayed("invoicesCreditTable",invoicesCreditTable);
		verifyError(invoicesCreditTable);	
	}
	
	//Invoices Void Link
	@FindBy(css="a[data-tab*='void']")
	private WebElement invoicesVoidLink;
		
	public void verifyinvoicesVoidLink() {
		fluentwait(invoicesVoidLink);
		click("invoicesVoidLink",invoicesVoidLink);
		getHttpResponse();
	}
	
	
	//Invoices Void data table
	@FindBy(css="#void tr td")
	private WebElement invoicesVoidTable;
		
	public void verifyinvoicesVoidTable() {
		fluentwait(invoicesVoidTable);
		isDisplayed("invoicesVoidTable",invoicesVoidTable);
		verifyError(invoicesVoidTable);	
	}
	
	//Invoices Refund Link
	@FindBy(css="a[data-tab*='refund']")
	private WebElement invoicesRefundLink;
		
	public void verifyinvoicesRefundLink() {
		fluentwait(invoicesVoidLink);
		click("invoicesRefundLink",invoicesRefundLink);
		getHttpResponse();
	}
	
	//Invoices Refund data table
	@FindBy(css="#refund tr td")
	private WebElement invoicesRefundTable;
		
	public void verifyinvoicesRefundTable() {
		fluentwait(invoicesRefundTable);
		isDisplayed("invoicesRefundTable",invoicesRefundTable);
		verifyError(invoicesRefundTable);	
	}
}
