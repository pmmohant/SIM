package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class UserGroupsPage {

	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public UserGroupsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Account--User Groups Link
	@FindBy(css="a[href*='userGroupConfiguration']")
	private WebElement userGroupsLink;
	public WebElement userGroupsLink(){						//added  by Ramya
		return userGroupsLink;
	}
		
	public void verifyUserGroupsLink() {
		lavanteUtils.fluentwait(userGroupsLink);
		lavanteUtils.click("userGroupsLink",userGroupsLink);
	//	getHttpResponse();
	}
			
	//Users table table
	@FindBy(css="#userSetup table tr")
	private WebElement userGroupsTable;
	public WebElement userGroupsTable(){					//added by Ramya
		return userGroupsTable;
	}
		
	public void verifyUserGroupsTable() {
		lavanteUtils.fluentwait(userGroupsTable);
		lavanteUtils.isDisplayed("userGroupsTable",userGroupsTable);
		lavanteUtils.verifyError(userGroupsTable);
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
