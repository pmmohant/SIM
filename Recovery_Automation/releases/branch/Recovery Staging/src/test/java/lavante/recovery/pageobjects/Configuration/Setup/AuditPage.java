package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditPage extends seleniumBaseClass{
	
	//Configuration link
	@FindBy(linkText="Configuration")
	private WebElement configurationLink;
		
	public void verifyconfigurationLink() {
		fluentwait(configurationLink);
		click("configurationLink",configurationLink);
		getHttpResponse();
	}
	
	//Configuration--Setup Link
	@FindBy(linkText="SetUp")
	private WebElement setUpLink;
		
	public void verifySetUpLink() {
		fluentwait(setUpLink);
	//	click("setUpLink",setUpLink);
		getHttpResponse();
	}
	
	//Configuration--Setup--Audit Link
	@FindBy(css="a[href='configuration.lvp']")
	private WebElement setUpAuditLink;
		
	public void verifysetUpAuditLink() {
		fluentwait(setUpAuditLink);
		click("setUpAuditLink",setUpAuditLink);
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
	
	//Alert--Close Button
	@FindBy(css="button[type='button'] span")
	private WebElement alertBtn;
		
	public void clickOnAlert() {
		clickOnAlert("alertBtn",alertBtn);
		fluentwait(alertBtn);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		fluentwait(addNewBtn);
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}
	

}
