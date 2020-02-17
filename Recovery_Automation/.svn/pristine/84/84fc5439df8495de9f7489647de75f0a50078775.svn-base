package lavante.recovery.pageobjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class InvoicesPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public InvoicesPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Invoices Link
	@FindBy(linkText="Invoices")
	private WebElement invoicesLink;
	public WebElement invoicesLink(){    //added by Ramya
		
		return invoicesLink;
	}
		
	public void verifyinvoicesLink() {
		lavanteUtils.fluentwait(invoicesLink);
		lavanteUtils.click("invoicesLink",invoicesLink);
	}

	//Invoice Summary table
	@FindBy(css="#invoiceSummary tr td")
	private WebElement invoiceSummaryTable;
	public WebElement invoiceSummaryTable(){		//added by Ramya
		return invoiceSummaryTable;
	}
	
		
	public void verifyinvoiceSummaryTable() {
		lavanteUtils.fluentwait(invoiceSummaryTable);
		lavanteUtils.isDisplayed("invoiceSummaryTable",invoiceSummaryTable);
		lavanteUtils.verifyError(invoiceSummaryTable);	
	}
	
	//Invoice Summary Details table
	@FindBy(css="#invoiceSummaryDetails tr td")
	private WebElement invoiceSummaryDetailsTable;
	public WebElement invoiceSummaryDetailsTable(){		//added by Ramya
		return invoiceSummaryDetailsTable;
	}
		
	public void verifyinvoiceSummaryDetailsTable() {
		
		lavanteUtils.isDisplayed("invoiceSummaryDetailsTable",invoiceSummaryDetailsTable);
		lavanteUtils.verifyError(invoiceSummaryDetailsTable);	
	}
	
	//Invoices Credit Link
	@FindBy(css="a[data-tab*='credit']")
	private WebElement invoicesCreditLink;
	public WebElement invoicesCreditLink(){        //added by Ramya
		return invoicesCreditLink;
	}
		
	public void verifyinvoicesCreditLink() {
		lavanteUtils.fluentwait(invoicesCreditLink);
		lavanteUtils.click("invoicesCreditLink",invoicesCreditLink);
	}
	
	//Invoices Credit data table
	@FindBy(css="#credit tr td")
	private WebElement invoicesCreditTable;
	public WebElement invoicesCreditTable(){      //added by Ramya
		return invoicesCreditTable;
	}
		
	public void verifyinvoicesCreditTable() {
		lavanteUtils.fluentwait(invoicesCreditTable);
		lavanteUtils.isDisplayed("invoicesCreditTable",invoicesCreditTable);
		lavanteUtils.verifyError(invoicesCreditTable);	
	}
	
	//Invoices Void Link
	@FindBy(css="a[data-tab*='void']")
	private WebElement invoicesVoidLink;
	public WebElement invoicesVoidLink(){		//added by Ramya
		return invoicesVoidLink;
	}
			
	
		
	public void verifyinvoicesVoidLink() {
		lavanteUtils.fluentwait(invoicesVoidLink);
		lavanteUtils.click("invoicesVoidLink",invoicesVoidLink);
	}
	
	
	//Invoices Void data table
	@FindBy(css="#void tr td")
	private WebElement invoicesVoidTable;
	public WebElement invoicesVoidTable(){ 		// added by Ramya
		return invoicesVoidTable;
	}
		
	public void verifyinvoicesVoidTable() {
		lavanteUtils.fluentwait(invoicesVoidTable);
		lavanteUtils.isDisplayed("invoicesVoidTable",invoicesVoidTable);
		lavanteUtils.verifyError(invoicesVoidTable);	
	}
	
	//Invoices Refund Link
	@FindBy(css="a[data-tab*='refund']")
	private WebElement invoicesRefundLink;
	public WebElement invoicesRefundLink(){		// added by Ramya
		return invoicesRefundLink;
	}
		
	public void verifyinvoicesRefundLink() {
		lavanteUtils.fluentwait(invoicesVoidLink);
		lavanteUtils.click("invoicesRefundLink",invoicesRefundLink);
	}
	
	//Invoices Refund data table
	@FindBy(css="#refund tr td")
	private WebElement invoicesRefundTable;
	public WebElement invoicesRefundTable(){		//added by Ramya
		return invoicesRefundTable;
	}
		
	public void verifyinvoicesRefundTable() {
		lavanteUtils.fluentwait(invoicesRefundTable);
		lavanteUtils.isDisplayed("invoicesRefundTable",invoicesRefundTable);
		lavanteUtils.verifyError(invoicesRefundTable);	
	}
}
