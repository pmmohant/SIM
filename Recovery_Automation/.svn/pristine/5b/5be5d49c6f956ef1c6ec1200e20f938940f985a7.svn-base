package lavante.recovery.pageobjects.Assignments;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class HoldsPage extends seleniumBaseClass{
	//Assignments Link
	@FindBy(linkText="Assignments")
	private WebElement assignmentsLink;
		
	public void verifyAssignmentsLink() {
		fluentwait(assignmentsLink);
		click("assignmentsLink",assignmentsLink);
		getHttpResponse();		
	}
	
	//Holds Link
	@FindBy(linkText="Holds")
	private WebElement holdsLink;
		
	public void verifyHoldsLink() {
		fluentwait(holdsLink);
		click("holdsLink",holdsLink);
		getHttpResponse();
	}
	
	@FindBy(css="#iframe_page")
	private WebElement holdsTableiFrame;
		
	public void verifyHoldsTableiFrame() {
		switchtoFrame(holdsTableiFrame);
		isDisplayed("holdsTableiFrame",holdsTableiFrame);
		verifyError(holdsTableiFrame);
	}	
	
	//Holds search Data table
	@FindBy(css=".table_ab .table_ab_b")
	private WebElement holdsTable;
		
	public void verifyHoldsTable() {
		fluentwait(holdsTable);
		isDisplayed("holdsTable",holdsTable);
		verifyError(holdsTable);
	}
	
	//Holds search filter
	@FindBy(css="button[title='Search']")
	private WebElement searchBtn;
		
	public void verifysearchBtn() {
		
		isDisplayed("searchBtn",searchBtn);
		verifyError(searchBtn);
	}
}
