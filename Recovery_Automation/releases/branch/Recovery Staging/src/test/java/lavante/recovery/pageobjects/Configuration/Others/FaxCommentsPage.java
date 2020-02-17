package lavante.recovery.pageobjects.Configuration.Others;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class FaxCommentsPage extends seleniumBaseClass{
	
	//Configuration--Others Link
	@FindBy(css="a[title='Others']")
	private WebElement othersLink;
		
	public void verifyOthersLink() {
		fluentwait(othersLink);
		click("othersLink",othersLink);
		getHttpResponse();
	}
	
	//Configuration--Others--Fax Comments Link
	@FindBy(css="a[href*='otherConfiguration']")
	private WebElement othersFaxCommentsLink;
		
	public void verifyOthersFaxCommentsLink() {
		fluentwait(othersFaxCommentsLink);
		click("othersFaxCommentsLink",othersFaxCommentsLink);
		getHttpResponse();
	}
			
	//Others--Fax Comments table
	@FindBy(css="#fax_comment tr")
	private WebElement othersFaxCommentsTable;
		
	public void verifyOthersFaxCommentsTable() {
		fluentwait(othersFaxCommentsTable);
		isDisplayed("othersFaxCommentsTable",othersFaxCommentsTable);
		verifyError(othersFaxCommentsTable);
	}
	
	//Add New Button
	@FindBy(css="input[title='Add New Fax Comment']")
	private WebElement addNewBtn;
		
	public void verifyaddNewBtn() {
		
		isDisplayed("addNewBtn",addNewBtn);
		verifyError(addNewBtn);
	}

}
