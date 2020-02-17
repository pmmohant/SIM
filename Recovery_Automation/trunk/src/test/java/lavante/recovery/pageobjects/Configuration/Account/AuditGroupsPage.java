package lavante.recovery.pageobjects.Configuration.Account;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditGroupsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditGroupsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Account--Audit Groups Link
	@FindBy(css="a[href*='auditGroupSetUp']")
	private WebElement auditGroupsLink;
	public WebElement auditGroupsLink(){			//added by Ramya
		return auditGroupsLink;
	}
		
	public void verifyAuditGroupsLink() {
		lavanteUtils.fluentwait(auditGroupsLink);
		lavanteUtils.click("auditGroupsLink",auditGroupsLink);
	}
	
			
	//Audit Groups table table						//added by Ramya
	@FindBy(css="#auditGroupSetup table tr")
	private WebElement auditGroupsTable;
	public WebElement auditGroupsTable(){
		return auditGroupsTable;
	}
		
	public void verifyAuditGroupsTable() {
		lavanteUtils.fluentwait(auditGroupsTable);
		lavanteUtils.isDisplayed("auditGroupsTable",auditGroupsTable);
		lavanteUtils.verifyError(auditGroupsTable);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){					//added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}
}
