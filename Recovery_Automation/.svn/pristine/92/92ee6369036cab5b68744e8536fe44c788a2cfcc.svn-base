package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class UsersPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public UsersPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Account Link
	@FindBy(css="a[title='Account']")
	private WebElement accountLink;
	public WebElement accountLink(){						//added by Ramya
		return accountLink;
	}
		
	public void verifyAccountLink() {
		lavanteUtils.fluentwait(accountLink);
		lavanteUtils.click("accountLink",accountLink);
	//	getHttpResponse();
	}
	
	//Configuration--Account--Users Link
	@FindBy(css="a[href='accountConfiguration.lvp']")
	private WebElement usersLink;
	public WebElement usersLink(){							//added by Ramya
		return usersLink;
	}
		
	public void verifyUsersLink() {
		lavanteUtils.fluentwait(usersLink);
		//click("usersLink",usersLink);
	//	getHttpResponse();
	}
			
	//Users table table
	@FindBy(css="#user-list tr")
	private WebElement usersListTable;
	public WebElement usersListTable(){						//added by Ramya
		return usersListTable;
	}
		
	public void verifyUsersListTable() {
		lavanteUtils.fluentwait(usersListTable);
		lavanteUtils.isDisplayed("usersListTable",usersListTable);
		lavanteUtils.verifyError(usersListTable);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){							//added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}


}
