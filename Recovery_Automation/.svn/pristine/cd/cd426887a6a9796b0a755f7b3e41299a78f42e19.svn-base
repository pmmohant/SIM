package lavante.recovery.pageobjects.Assignments;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class CreditsPage extends seleniumBaseClass{
	
	//Credits Link
	@FindBy(linkText="Credits")
	private WebElement creditsLink;
		
	public void verifycreditsLink() {
		fluentwait(creditsLink);	
		click("creditsLink",creditsLink);
		getHttpResponse();
	}
	
	//Credits search Data table
	@FindBy(css=".table_ab .table_ab_b")
	private WebElement creditsTable;
		
	public void verifycreditsTable() {
		fluentwait(creditsTable);
		isDisplayed("creditsTable",creditsTable);
		verifyError(creditsTable);
	}
	
	//Credits search filter
	@FindBy(css="button[title='Search']")
	private WebElement searchBtn;
		
	public void verifysearchBtn() {
		
		isDisplayed("searchBtn",searchBtn);
		verifyError(searchBtn);
	}
}
