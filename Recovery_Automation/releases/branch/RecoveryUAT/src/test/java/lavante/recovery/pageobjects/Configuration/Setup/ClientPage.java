package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class ClientPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public ClientPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Setup--Client Link
	@FindBy(linkText="Client")
	private WebElement clientLink;
	public WebElement clientLink(){			//added by Ramya
		return clientLink;					
	}
		
	public void verifyClientLink() {
		lavanteUtils.fluentwait(clientLink);
		lavanteUtils.click("clientLink",clientLink);
	//	getHttpResponse();
	}
	
	//Client table
	@FindBy(css="#auto_config_form table tr")
	private WebElement clientTable;
	public WebElement clientTable(){		//added by Ramya
		return clientTable;
	}
		
	public void verifyclientTable() {
		
		lavanteUtils.isDisplayed("clientTable",clientTable);
		lavanteUtils.verifyError(clientTable);
	}
	
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
	public WebElement saveBtn(){			//added by Ramya
		return saveBtn;
	}
		
	public void verifysaveBtn() {
		lavanteUtils.fluentwait(saveBtn);
		lavanteUtils.click("saveBtn",saveBtn);
	//	getHttpResponse();
		lavanteUtils.isDisplayed("saveBtn",saveBtn);
		lavanteUtils.verifyError(saveBtn);
	}
	
	//Cancel button
	
	@FindBy(css="input[value='Cancel']")
	private WebElement cancelBtn;
	public WebElement cancelBtn(){			//added by Ramya
		return cancelBtn;
	}
	

}
