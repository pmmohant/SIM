package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class ClientPage extends seleniumBaseClass{
	
	//Configuration--Setup--Client Link
	@FindBy(linkText="Client")
	private WebElement clientLink;
		
	public void verifyClientLink() {
		fluentwait(clientLink);
		click("clientLink",clientLink);
		getHttpResponse();
	}
	
	//Client table
	@FindBy(css="#auto_config_form table tr")
	private WebElement clientTable;
		
	public void verifyclientTable() {
		
		isDisplayed("clientTable",clientTable);
		verifyError(clientTable);
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

}
