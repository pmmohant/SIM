package lavante.recovery.pageobjects.Configuration.Others;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class PhoneExtensionPage extends seleniumBaseClass{
	
	//Configuration--Others--Phone Extension Link
	@FindBy(css="a[href*='phoneExtension']")
	private WebElement othersPhoneExtensionLink;
		
	public void verifyOthersPhoneExtensionLink() {
		fluentwait(othersPhoneExtensionLink);
		click("othersPhoneExtensionLink",othersPhoneExtensionLink);
		getHttpResponse();
	}
			
	//Others--Phone Extension table
	@FindBy(css="#phoneExtension tr")
	private WebElement othersPhoneExtensionTable;
		
	public void verifyOthersPhoneExtensionTable() {
		fluentwait(othersPhoneExtensionTable);
		isDisplayed("othersPhoneExtensionTable",othersPhoneExtensionTable);
		verifyError(othersPhoneExtensionTable);
	}
	
	//Add New Button
	@FindBy(css="input[title='Add New Phone Extension']")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}

}
