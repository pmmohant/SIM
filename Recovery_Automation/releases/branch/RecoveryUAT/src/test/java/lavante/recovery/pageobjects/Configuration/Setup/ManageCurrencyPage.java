package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class ManageCurrencyPage{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public ManageCurrencyPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Setup--Manage Currency Link
	@FindBy(css="a[href*='manageCurrency']")
	private WebElement manCurrencyLink;
	public WebElement manCurrencyLink(){		//added by Ramya
		return manCurrencyLink;
	}
		
	public void verifyManageCurrencyLink() {
		lavanteUtils.fluentwait(manCurrencyLink);
		lavanteUtils.click("manCurrencyLink",manCurrencyLink);
	//	getHttpResponse();
	}
		
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
	public WebElement saveBtn(){				//added by Ramya
		return saveBtn;
	}
	
	@FindBy(css="input[value='Reset']")
	private WebElement resetBtn;
	public WebElement resetBtn(){				//added by Ramya
		return saveBtn;
	}
	
	
		
	public void verifysaveBtn() {
		lavanteUtils.fluentwait(saveBtn);
		lavanteUtils.click("saveBtn",saveBtn);
	//	getHttpResponse();
		lavanteUtils.isDisplayed("saveBtn",saveBtn);
		lavanteUtils.verifyError(saveBtn);
	}
	
	//Manage Currency table
	@FindBy(css="#addAuditCurrencyList tr")
	private WebElement manageCurrencyTable;
	public WebElement manageCurrencyTable(){    //added by Ramya
		return manageCurrencyTable;
	}
		
	public void verifyManageCurrencyTable() {
		lavanteUtils.fluentwait(manageCurrencyTable);
		lavanteUtils.isDisplayed("manageCurrencyTable",manageCurrencyTable);
		lavanteUtils.verifyError(manageCurrencyTable);
	}

}
