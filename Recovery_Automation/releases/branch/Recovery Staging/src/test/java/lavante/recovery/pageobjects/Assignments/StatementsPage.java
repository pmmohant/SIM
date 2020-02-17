package lavante.recovery.pageobjects.Assignments;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class StatementsPage extends seleniumBaseClass{
	
	//Statements Link
	@FindBy(linkText="Statements")
	private WebElement statementsLink;
		
	public void verifyStatementsLink() {
		fluentwait(statementsLink);
		click("statementsLink",statementsLink);
		getHttpResponse();
	}
	
	//Statements search Data table
	@FindBy(css=".table_ab .table_ab_b")
	private WebElement statementsTable;
		
	public void verifyStatementsTable() {
		fluentwait(statementsTable);
		isDisplayed("statementsTable",statementsTable);
		verifyError(statementsTable);
	}
	
	//Credits search filter
	@FindBy(css="button[title='Search']")
	private WebElement searchBtn;
		
	public void verifysearchBtn() {
		
		isDisplayed("searchBtn",searchBtn);
		verifyError(searchBtn);
	}

}
