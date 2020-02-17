package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditInvoicePage extends seleniumBaseClass{
	
	//Invoices Link
	@FindBy(linkText="Invoice")
	private WebElement invoiceLink;
	
	public void verifyinvoiceLink() {
		fluentwait(invoiceLink);
		click("invoiceLink",invoiceLink);
	}

	//Invoices table
	@FindBy(css="#Invoice_List tr td")
	private WebElement invoicesTable;
	
	public void verifyinvoicesTable() {
		fluentwait(invoicesTable);
		isDisplayed("invoicesTable",invoicesTable);
		verifyError(invoicesTable);	
	}
	
	//Invoices Summary table
	@FindBy(css="#iframe_page tr")
	private WebElement invoiceSummaryTable;
	
	public void verifyinvoiceSummaryTable() {
		fluentwait(invoiceSummaryTable);
		isDisplayed("invoiceSummaryTable",invoiceSummaryTable);
		verifyError(invoiceSummaryTable);	
	}
	
	//Invoice Credit link
	@FindBy(css="a[href*='Credit']")
	private WebElement invoiceCreditLink;
	
	public void verifyinvoiceCreditLink() {
		fluentwait(invoiceCreditLink);
		click("invoiceCreditLink",invoiceCreditLink);
		getHttpResponse();
	}
	
	//Invoice Credit table
	@FindBy(css="#invoiceDetails tr td")
	private WebElement invoiceCreditTable;
	
	public void verifyinvoiceCreditTable() {
		fluentwait(invoiceCreditTable);
		isDisplayed("invoiceCreditTable",invoiceCreditTable);
		verifyError(invoiceCreditTable);	
	}
	
	//Invoice Void link
	@FindBy(css="a[href*='Void']")
	private WebElement invoiceVoidLink;
	
	public void verifyinvoiceVoidLink() {
		fluentwait(invoiceVoidLink);
		click("invoiceVoidLink",invoiceVoidLink);
		getHttpResponse();
	}
	
	//Invoice Void table
	@FindBy(css="#invoiceDetails tr td")
	private WebElement invoiceVoidTable;
	
	public void verifyinvoiceVoidTable() {
		fluentwait(invoiceVoidTable);
		isDisplayed("invoiceVoidTable",invoiceVoidTable);
		verifyError(invoiceVoidTable);	
	}
	//Invoice Refund link
	@FindBy(css="a[href*='Refund']")
	private WebElement invoiceRefundLink;
	
	public void verifyinvoiceRefundLink() {
		fluentwait(invoiceRefundLink);
		click("invoiceRefundLink",invoiceRefundLink);
		getHttpResponse();
	}
	
	//Invoice Refund table
	@FindBy(css="#invoiceDetails tr td")
	private WebElement invoiceRefundTable;
	
	public void verifyinvoiceRefundTable() {
		fluentwait(invoiceRefundTable);
		isDisplayed("invoiceRefundTable",invoiceRefundTable);
		verifyError(invoiceRefundTable);	
	}

}
