package lavante.recovery.pageobjects.Configuration.Finance;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class FinanceInvoicesPage extends seleniumBaseClass{
	
	//Configuration--Finance--Link
	@FindBy(css="a[title='Finance']")
	private WebElement financeLink;
		
	public void verifyFinanceLink() {
		fluentwait(financeLink);
		click("financeLink",financeLink);
		getHttpResponse();
	}
	
	//Configuration--Finance--Invoices Link
	@FindBy(css="a[href='financeConfiguration.lvp']")
	private WebElement finInvoicesLink;
		
	public void verifyFinInvoicesLink() {
		fluentwait(finInvoicesLink);
		click("finInvoicesLink",finInvoicesLink);
		getHttpResponse();
	}
			
	//Finance--Invoices table
	@FindBy(css="#invoice-details tr")
	private WebElement finInvoicesTable;
		
	public void verifyFinInvoicesTable() {
		fluentwait(finInvoicesTable);
		isDisplayed("finInvoicesTable",finInvoicesTable);
		verifyError(finInvoicesTable);
	}

}
