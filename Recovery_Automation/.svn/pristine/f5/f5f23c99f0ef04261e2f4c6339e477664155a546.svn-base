package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class PreferencesPage extends seleniumBaseClass{
	
	//Configuration--Setup--Preferences Link
	@FindBy(css="a[href='automationConfiguration.lvp']")
	private WebElement preferencesLink;
		
	public void verifypreferencesLink() {
		fluentwait(preferencesLink);
		click("preferencesLink",preferencesLink);
		getHttpResponse();
	}
		
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
		
	public void verifysaveBtn() {
		fluentwait(saveBtn);
		click("saveBtn",saveBtn);
		isDisplayed("saveBtn",saveBtn);
		verifyError(saveBtn);
	}
	
	//Preferences table
	@FindBy(css="#auto_config_form table tr")
	private WebElement preferencesTable;
		
	public void verifyPreferencesTable() {
		
		isDisplayed("preferencesTable",preferencesTable);
		verifyError(preferencesTable);
	}
}
