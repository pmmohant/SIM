package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditGroupsPage extends seleniumBaseClass{
	
	//Configuration--Account--Audit Groups Link
	@FindBy(css="a[href*='auditGroupSetUp']")
	private WebElement auditGroupsLink;
		
	public void verifyAuditGroupsLink() {
		fluentwait(auditGroupsLink);
		click("auditGroupsLink",auditGroupsLink);
		getHttpResponse();
	}
			
	//Audit Groups table table
	@FindBy(css="#auditGroupSetup table tr")
	private WebElement auditGroupsTable;
		
	public void verifyAuditGroupsTable() {
		fluentwait(auditGroupsTable);
		isDisplayed("auditGroupsTable",auditGroupsTable);
		verifyError(auditGroupsTable);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}
}
