package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class BusinessUnitPage extends seleniumBaseClass{
	
	//Configuration--Setup--Business Unit Link
	@FindBy(css="a[href='businessUnit.lvp']")
	private WebElement businessUnitLink;
		
	public void verifyBusinessUnitLink() {
		fluentwait(businessUnitLink);
		click("businessUnitLink",businessUnitLink);
		getHttpResponse();
	}
	
	//Business Unit table
	@FindBy(css="#business_unit_form tr")
	private WebElement businessUnitTable;
		
	public void verifybusinessUnitTable() {
		fluentwait(businessUnitTable);
		isDisplayed("businessUnitTable",businessUnitTable);
		verifyError(businessUnitTable);
	}

}
