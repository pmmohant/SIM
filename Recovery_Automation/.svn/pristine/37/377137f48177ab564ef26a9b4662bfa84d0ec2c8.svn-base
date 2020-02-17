package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class RequestLettersPage extends seleniumBaseClass{
	
	//Configuration--Setup--Request Letters Link
	@FindBy(css="a[href*='request']")
	private WebElement reqLetterLink;
		
	public void verifyReqLetterLink() {
		fluentwait(reqLetterLink);
		click("reqLetterLink",reqLetterLink);
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
	
	//Request Letters table
	@FindBy(css="#requestLetter_config_form table tr")
	private WebElement reqLetterTable;
		
	public void verifyReqLetterTable() {
		fluentwait(reqLetterTable);
		isDisplayed("reqLetterTable",reqLetterTable);
		verifyError(reqLetterTable);
	}

}
