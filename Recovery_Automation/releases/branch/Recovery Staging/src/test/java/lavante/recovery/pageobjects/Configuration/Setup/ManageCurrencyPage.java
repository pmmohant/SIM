package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class ManageCurrencyPage extends seleniumBaseClass{
	
	//Configuration--Setup--Manage Currency Link
	@FindBy(css="a[href*='manageCurrency']")
	private WebElement manCurrencyLink;
		
	public void verifyManageCurrencyLink() {
		fluentwait(manCurrencyLink);
		click("manCurrencyLink",manCurrencyLink);
		getHttpResponse();
	}
		
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
		
	public void verifysaveBtn() {
		fluentwait(saveBtn);
		click("saveBtn",saveBtn);
		getHttpResponse();
		isDisplayed("saveBtn",saveBtn);
		verifyError(saveBtn);
	}
	
	//Manage Currency table
	@FindBy(css="#addAuditCurrencyList tr")
	private WebElement manageCurrencyTable;
		
	public void verifyManageCurrencyTable() {
		fluentwait(manageCurrencyTable);
		isDisplayed("manageCurrencyTable",manageCurrencyTable);
		verifyError(manageCurrencyTable);
	}

}
