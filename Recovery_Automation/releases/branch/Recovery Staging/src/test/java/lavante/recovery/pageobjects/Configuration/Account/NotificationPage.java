package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class NotificationPage extends seleniumBaseClass{
	
	//Configuration--Account--Notifications Link
	@FindBy(css="a[href*='batchInvoiceNotification']")
	private WebElement notificationsLink;
		
	public void verifyNotificationsLink() {
		fluentwait(notificationsLink);
		click("notificationsLink",notificationsLink);
		getHttpResponse();
	}
			
	//Notification table
	@FindBy(css="#batchInvoice_noti tr")
	private WebElement notificationsTable;
		
	public void verifyNotificationsTable() {
		fluentwait(notificationsTable);
		isDisplayed("notificationsTable",notificationsTable);
		verifyError(notificationsTable);
	}
	
	//Add New Button
	@FindBy(id="addnew")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}

}
