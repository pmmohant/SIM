package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditCheckRegistryPage extends seleniumBaseClass{
	
	//Check Registry Link
	@FindBy(css="a[href*='checkRequest.lvp']")
	private WebElement chkRegLink;
		
	public void verifychkRegLink() {
		
		click("chkRegLink",chkRegLink);
		fluentwait(chkRegLink);
		getHttpResponse();
	}

	//Registry list
	@FindBy(css="#registry-list tr td")
	private WebElement chkRegList;
		
	public void verifychkRegList() {
		
		isDisplayed("chkRegList",chkRegList);
		verifyError(chkRegList);	
	}
	
	//Add New Button
	@FindBy(css="#addNew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);	
	}
}
