package lavante.recovery.pageobjects.Configuration.MailerRegistry;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class MailerRegistryPage extends seleniumBaseClass{
	
	//Configuration--Mailer Registry Link
	@FindBy(css="a[title='Mailer Registry']")
	private WebElement mailerRegistryLink;
		
	public void verifyMailerRegistryLink() {
		fluentwait(mailerRegistryLink);
		click("mailerRegistryLink",mailerRegistryLink);
		getHttpResponse();
	}
			
	//Configuration--Mailer Registry table
	@FindBy(css="#registry-list tbody tr")
	private WebElement mailerRegistryTable;
		
	public void verifyMailerRegistryTable() {
		
		isDisplayed("mailerRegistryTable",mailerRegistryTable);
		verifyError(mailerRegistryTable);
	}
	
	//Add New Button
	@FindBy(css="#addNew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}
}
