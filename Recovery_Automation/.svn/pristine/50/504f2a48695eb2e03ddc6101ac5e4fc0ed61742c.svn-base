package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class UsersPage extends seleniumBaseClass{
	
	//Configuration--Account Link
	@FindBy(css="a[title='Account']")
	private WebElement accountLink;
		
	public void verifyAccountLink() {
		fluentwait(accountLink);
		click("accountLink",accountLink);
		getHttpResponse();
	}
	
	//Configuration--Account--Users Link
	@FindBy(css="a[href='accountConfiguration.lvp']")
	private WebElement usersLink;
		
	public void verifyUsersLink() {
		fluentwait(usersLink);
		//click("usersLink",usersLink);
		getHttpResponse();
	}
			
	//Users table table
	@FindBy(css="#user-list tr")
	private WebElement usersListTable;
		
	public void verifyUsersListTable() {
		fluentwait(usersListTable);
		isDisplayed("usersListTable",usersListTable);
		verifyError(usersListTable);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}


}
