package lavante.recovery.pageobjects.Configuration.Others;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class PhoneExtensionPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public PhoneExtensionPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Others--Phone Extension Link
	@FindBy(css="a[href*='phoneExtension']")
	private WebElement othersPhoneExtensionLink;
	public WebElement othersPhoneExtensionLink(){		//added by Ramya
		return othersPhoneExtensionLink;
	}
	public WebElement otherPhoneExt(){
		return othersPhoneExtensionLink;
	}
		
	public void verifyOthersPhoneExtensionLink() {
		lavanteUtils.fluentwait(otherPhoneExt());
		lavanteUtils.click("othersPhoneExtensionLink",othersPhoneExtensionLink);
	//	getHttpResponse();
	}
			
	//Others--Phone Extension table
	@FindBy(css="#phoneExtension tr")
	private WebElement othersPhoneExtensionTable;
	public WebElement othersPhoneExtensionTable(){
		return othersPhoneExtensionTable;
	}
		
	public void verifyOthersPhoneExtensionTable() {
		lavanteUtils.fluentwait(othersPhoneExtensionTable());
		lavanteUtils.isDisplayed("othersPhoneExtensionTable",othersPhoneExtensionTable);
		lavanteUtils.verifyError(othersPhoneExtensionTable);
	}
	
	//Add New Button
	@FindBy(css="input[title='Add New Phone Extension']")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){				//added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}

}
