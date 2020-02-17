package lavante.recovery.pageobjects.Configuration.Others;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class FaxCommentsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public FaxCommentsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	//Configuration--Others Link
	@FindBy(css="a[title='Others']")
	private WebElement othersLink;
	public WebElement othersLink(){			//added by Ramya
		return othersLink;
	}
		
	public void verifyOthersLink() {
		lavanteUtils.fluentwait(othersLink);
		lavanteUtils.click("othersLink",othersLink);
	//	getHttpResponse();
	}
	
	//Configuration--Others--Fax Comments Link
	@FindBy(css="a[href*='otherConfiguration']")
	private WebElement othersFaxCommentsLink;
	public WebElement othersFaxCommentsLink(){	//added by Ramya
		return othersFaxCommentsLink;
	}
		
	public void verifyOthersFaxCommentsLink() {
		lavanteUtils.fluentwait(othersFaxCommentsLink);
		lavanteUtils.click("othersFaxCommentsLink",othersFaxCommentsLink);
	//	getHttpResponse();
	}
			
	//Others--Fax Comments table
	@FindBy(css="#fax_comment tr")
	private WebElement othersFaxCommentsTable;
	public WebElement othersFaxCommentsTable(){			//added by Ramya
		return othersFaxCommentsTable;
	}
		
	public void verifyOthersFaxCommentsTable() {
		lavanteUtils.fluentwait(othersFaxCommentsTable);
		lavanteUtils.isDisplayed("othersFaxCommentsTable",othersFaxCommentsTable);
		lavanteUtils.verifyError(othersFaxCommentsTable);
	}
	
	//Add New Button
	@FindBy(css="input[title='Add New Fax Comment']")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){					//added by Ramya
		return addNewBtn;
	}
		
	public void verifyaddNewBtn() {
		
		lavanteUtils.isDisplayed("addNewBtn",addNewBtn);
		lavanteUtils.verifyError(addNewBtn);
	}

}
