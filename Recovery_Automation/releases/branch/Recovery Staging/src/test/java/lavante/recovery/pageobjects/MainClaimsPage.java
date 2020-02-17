package lavante.recovery.pageobjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class MainClaimsPage extends seleniumBaseClass{
	
	//Main Claims Link
	@FindBy(linkText="Claims")
	private WebElement claimsLink;
		
	public void verifyclaimsLink() {
		fluentwait(claimsLink);
		click("claimsLink",claimsLink);
		getHttpResponse();
	}

	//Total Claims table
	@FindBy(css="#content div:nth-child(2) tbody tr td:nth-child(3) a")
	private WebElement totalClaimsTable;
		
	public void verifytotalClaimsTable() {
		
		isDisplayed("totalClaimsTable",totalClaimsTable);
		verifyError(totalClaimsTable);	
	}
	
	//Claims List table
	@FindBy(css="#claimDetailsTable tr td a")
	private WebElement claimsListTable;
		
	public void verifyclaimsListTable() {
		
		isDisplayed("claimsListTable",claimsListTable);
		verifyError(claimsListTable);	
	}

}




