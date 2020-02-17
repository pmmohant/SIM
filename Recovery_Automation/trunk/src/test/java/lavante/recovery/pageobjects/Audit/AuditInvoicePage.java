package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditInvoicePage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	//public WebDriver driver=null;
	public AuditInvoicePage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	//Invoices Link
	@FindBy(linkText="Invoice")
	private WebElement invoiceLink;
	public WebElement invoiceLink(){         //added by Ramya
		return invoiceLink;
	}
	
	public void verifyinvoiceLink() {
		lavanteUtils.fluentwait(invoiceLink);
		lavanteUtils.click("invoiceLink",invoiceLink);
	}

	//Invoices table
	//@FindBy(css="#Invoice_List tr td")
	@FindBy(css="td:nth-child(1) >div:nth-child(1)  tr td:nth-child(1)")
	private WebElement invoicesTable;
	public WebElement invoicesTable(){       //added by Ramya
		return invoicesTable;
	}
	
	public void verifyinvoicesTable() {
		lavanteUtils.fluentwait(invoicesTable);
		lavanteUtils.isDisplayed("invoicesTable",invoicesTable);
		lavanteUtils.verifyError(invoicesTable);	
	}
	
	//Invoices Summary table
	@FindBy(css="#iframe_page tr")
	private WebElement invoiceSummaryTable;
	public WebElement invoiceSummaryTable(){     //added by Ramya
		return invoiceSummaryTable;
	}
	
	public void verifyinvoiceSummaryTable() {
		lavanteUtils.fluentwait(invoiceSummaryTable);
		lavanteUtils.isDisplayed("invoiceSummaryTable",invoiceSummaryTable);
		lavanteUtils.verifyError(invoiceSummaryTable);	
	}
	
	//Invoice Credit link
	@FindBy(css="a[href*='Credit']")
	private WebElement invoiceCreditLink;
	public WebElement invoiceCreditLink(){       //added by Ramya
		return invoiceCreditLink;
	}
	
	// iframe
	@FindBy(id="invoice_details")				//added by Ramya
	private WebElement iframeCredit;
	public WebElement iframeCredit(){
		return iframeCredit;
	}
	
	
	public void verifyinvoiceCreditLink() {
		lavanteUtils.fluentwait(invoiceCreditLink);
		lavanteUtils.click("invoiceCreditLink",invoiceCreditLink);
	//	getHttpResponse();
	}
	
	//Invoice Credit table
	@FindBy(css="#invoiceDetails tr td")
	private WebElement invoiceCreditTable;
	public WebElement invoiceCreditTable(){       //added by Ramya
		return invoiceCreditTable;
	}
	
	public void verifyinvoiceCreditTable() {
		lavanteUtils.fluentwait(invoiceCreditTable);
		lavanteUtils.isDisplayed("invoiceCreditTable",invoiceCreditTable);
		lavanteUtils.verifyError(invoiceCreditTable);	
	}
	
	//Invoice Void link
	@FindBy(css="a[href*='Void']")
	private WebElement invoiceVoidLink;
	public WebElement invoiceVoidLink(){          //added by Ramya
		return invoiceVoidLink;
	}
	
	public void verifyinvoiceVoidLink() {
		lavanteUtils.fluentwait(invoiceVoidLink);
		lavanteUtils.click("invoiceVoidLink",invoiceVoidLink);
	//	getHttpResponse();
	}
	
	//Invoice Void table
	@FindBy(css="#invoiceDetails tr td")
	private WebElement invoiceVoidTable;
	public WebElement invoiceVoidTable(){          //added by Ramya
		return invoiceVoidTable;
	}
	
	public void verifyinvoiceVoidTable() {
		lavanteUtils.fluentwait(invoiceVoidTable);
		lavanteUtils.isDisplayed("invoiceVoidTable",invoiceVoidTable);
		lavanteUtils.verifyError(invoiceVoidTable);	
	}
	//Invoice Refund link
	@FindBy(css="a[href*='Refund']")
	private WebElement invoiceRefundLink;
	public WebElement invoiceRefundLink(){        //added by Ramya
		return invoiceRefundLink;
	}
	
	public void verifyinvoiceRefundLink() {
		lavanteUtils.fluentwait(invoiceRefundLink);
		lavanteUtils.click("invoiceRefundLink",invoiceRefundLink);
	//	getHttpResponse();
	}
	
	//Invoice Refund table
	@FindBy(css="#invoiceDetails tr td")
	private WebElement invoiceRefundTable;
	public WebElement invoiceRefundTable(){       //added by Ramya
		return invoiceRefundTable;
	}
	
	public void verifyinvoiceRefundTable() {
		lavanteUtils.fluentwait(invoiceRefundTable);
		lavanteUtils.isDisplayed("invoiceRefundTable",invoiceRefundTable);
		lavanteUtils.verifyError(invoiceRefundTable);	
	}

}
