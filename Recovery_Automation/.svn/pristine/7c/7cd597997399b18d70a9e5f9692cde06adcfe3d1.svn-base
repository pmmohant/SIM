package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditContactEntryPage extends seleniumBaseClass{
	
	//Contact Entry Link
	@FindBy(linkText="Contact Entry")
	private WebElement contactEntry;
	
	public void verifycontactEntryLink() {
	
		click("contactEntry",contactEntry);
		fluentwait(contactEntry);
		getHttpResponse();
	}

	//Document Queue table
	@FindBy(css="#supplier-queue-table tr ")
	private WebElement docQueueTable;
	
	public void verifydocQueueTable() {
	
		isDisplayed("docQueueTable",docQueueTable);
		verifyError(docQueueTable);	
	}
	
	//Supplier Details table
	@FindBy(css="#dataPageSupplierDetails tr")
	private WebElement supDetailsTable;
	
	public void verifysupDetailsTable() {
	
		isDisplayed("supDetailsTable",supDetailsTable);
		verifyError(supDetailsTable);	
	}
	
	//Document details pdf frame
	@FindBy(css="#document-details #pdf-iframe")
	private WebElement docDetails;
	
	public void verifydocDetails() {
	
		isDisplayed("docDetails",docDetails);
		verifyError(docDetails);	
	}

}
