package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class PreferencesPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public PreferencesPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Setup--Preferences Link
	@FindBy(css="a[href='automationConfiguration.lvp']")
	private WebElement preferencesLink;
	public WebElement preferencesLink(){		//added by Ramya
		return preferencesLink;
	}
		
	public void verifypreferencesLink() {
		lavanteUtils.fluentwait(preferencesLink);
		lavanteUtils.click("preferencesLink",preferencesLink);
	//	getHttpResponse();
	}
		
	//Save Button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
	public WebElement saveBtn(){				//added by Ramya
		return saveBtn;
	}
		
	
	public void verifysaveBtn() {
		lavanteUtils.fluentwait(saveBtn);
		lavanteUtils.click("saveBtn",saveBtn);
		lavanteUtils.isDisplayed("saveBtn",saveBtn);
		lavanteUtils.verifyError(saveBtn);
	}
	
	//Reset button										//added by Ramya
	@FindBy(css="input[value='Reset']")
	private WebElement resetBtn;
	public WebElement resetBtn(){
		return resetBtn;
	}
	
	//Preferences table
	@FindBy(css="#auto_config_form table tr")
	private WebElement preferencesTable; 
	public WebElement preferncesTable(){     //added by Ramya
		return preferencesTable;
	}
		
	public void verifyPreferencesTable() {
		
		lavanteUtils.isDisplayed("preferencesTable",preferencesTable);
		lavanteUtils.verifyError(preferencesTable);
	}
}
