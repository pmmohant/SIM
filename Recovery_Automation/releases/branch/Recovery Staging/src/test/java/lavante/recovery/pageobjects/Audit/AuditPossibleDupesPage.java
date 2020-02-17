package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditPossibleDupesPage extends seleniumBaseClass{
	
	//Possible Dupes Link
	@FindBy(linkText="Possible Dupes")
	private WebElement possibleDupesLink;
		
	public void verifypossibleDupesLink() {
		
		click("possibleDupesLink",possibleDupesLink);
		fluentwait(possibleDupesLink);
		getHttpResponse();
	}

	//Possible Duplicates Summary table
	@FindBy(css="#possible_dup_summary tr td a")
	private WebElement possDupSummaryTable;
		
	public void verifypossDupSummaryTable() {
		
		isDisplayed("possDupSummaryTable",possDupSummaryTable);
		verifyError(possDupSummaryTable);	
	}

	//Pre-Batch Summary table
	@FindBy(css="#iframe_page table tr td")
	private WebElement preBatchTable;
		
	public void verifypreBatchTable() {
		
		isDisplayed("preBatchTable",preBatchTable);
		verifyError(preBatchTable);	
	}
	
	//Post-Batch Summary table
	@FindBy(css="#iframe_page table tr td")
	private WebElement postBatchTable;
		
	public void verifypostBatchTable() {
		
		isDisplayed("postBatchTable",postBatchTable);
		verifyError(postBatchTable);	
	}
	
	//Possible Duplicates Details table
	@FindBy(css=".data_table tr")
	private WebElement possDupDetailsTable;
		
	public void verifypossDupDetailsTable() {
		
		isDisplayed("possDupDetailsTable",possDupDetailsTable);
		verifyError(possDupDetailsTable);	
	}
}
