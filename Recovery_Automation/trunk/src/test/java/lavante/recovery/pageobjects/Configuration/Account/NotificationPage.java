package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class NotificationPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public NotificationPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Account--Notifications Link
	@FindBy(css="a[href*='batchInvoiceNotification']")
	private WebElement notificationsLink;
	public WebElement notifictionsLink(){            //added  by Ramya
		return notificationsLink;
	}
		
	public void verifyNotificationsLink() {
		lavanteUtils.fluentwait(notificationsLink);
		lavanteUtils.click("notificationsLink",notificationsLink);
	//	getHttpResponse();
	}
			
	//Notification table
	@FindBy(css="#batchInvoice_noti tr")
	private WebElement notificationsTable;
	public WebElement notificationsTable(){			//added by Ramya
		return notificationsTable;
	}
		
	public void verifyNotificationsTable() {
		lavanteUtils.fluentwait(notificationsTable);
		lavanteUtils.isDisplayed("notificationsTable",notificationsTable);
		lavanteUtils.verifyError(notificationsTable);
	}
	
	//Add New Button
	@FindBy(id="addnew")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){					//added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}

}
