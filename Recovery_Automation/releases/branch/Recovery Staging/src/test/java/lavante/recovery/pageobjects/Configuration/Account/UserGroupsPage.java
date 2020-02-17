package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class UserGroupsPage extends seleniumBaseClass{
	
	//Configuration--Account--User Groups Link
	@FindBy(css="a[href*='userGroupConfiguration']")
	private WebElement userGroupsLink;
		
	public void verifyUserGroupsLink() {
		fluentwait(userGroupsLink);
		click("userGroupsLink",userGroupsLink);
		getHttpResponse();
	}
			
	//Users table table
	@FindBy(css="#userSetup table tr")
	private WebElement userGroupsTable;
		
	public void verifyUserGroupsTable() {
		fluentwait(userGroupsTable);
		isDisplayed("userGroupsTable",userGroupsTable);
		verifyError(userGroupsTable);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}
}
