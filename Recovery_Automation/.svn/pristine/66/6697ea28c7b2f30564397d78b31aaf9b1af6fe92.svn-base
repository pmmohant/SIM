package lavante.recovery.pageobjects.Configuration.Setup;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class BusinessUnitPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public BusinessUnitPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Setup--Business Unit Link
	@FindBy(css="a[href='businessUnit.lvp']")
	private WebElement businessUnitLink;
	public WebElement businessUnitLink(){	//added by Ramya
		return businessUnitLink;
	}
		
	public void verifyBusinessUnitLink() {
		lavanteUtils.fluentwait(businessUnitLink);
		lavanteUtils.click("businessUnitLink",businessUnitLink);
	//	getHttpResponse();
	}
	
	//Business Unit table
	@FindBy(css="#business_unit_form tr")
	private WebElement businessUnitTable;
	public WebElement businessUnitTable(){		//added by Ramya
		return businessUnitTable;
	}
		
	public void verifybusinessUnitTable() {
		lavanteUtils.fluentwait(businessUnitTable);
		lavanteUtils.isDisplayed("businessUnitTable",businessUnitTable);
		lavanteUtils.verifyError(businessUnitTable);
	}

}
