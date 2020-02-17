package lavante.recovery.pageobjects.Configuration.Finance;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class ContractDetailsPage extends seleniumBaseClass{
		
	//Configuration--Finance--Contract Details Link
	@FindBy(css="a[href*='contractDetails']")
	private WebElement finContractDetailsLink;
		
	public void verifyFinanaceContractDetailsLink() {
		fluentwait(finContractDetailsLink);
		click("finContractDetailsLink",finContractDetailsLink);
		getHttpResponse();
	}
			
	//Finance--Contract Details table
	@FindBy(css="#contract-details tr")
	private WebElement finContractDetailsTable;
		
	public void verifyfinContractDetailsTable() {
		fluentwait(finContractDetailsTable);
		isDisplayed("finContractDetailsTable",finContractDetailsTable);
		verifyError(finContractDetailsTable);
	}
}
