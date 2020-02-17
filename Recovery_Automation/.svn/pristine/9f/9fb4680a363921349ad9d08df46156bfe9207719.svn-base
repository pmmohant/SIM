package lavante.recovery.pageobjects.Audit;

import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditBatchingPage extends seleniumBaseClass{

	//Batching Link
	@FindBy(linkText="Batching")
	private WebElement batchingLink;
	
	public void verifybatchingLink() {
	
		click("batchingLink",batchingLink);
		fluentwait(batchingLink);
		getHttpResponse();
	}

	//Un batched credits table frame
	@FindBy(tagName="iframe")
	private WebElement unBatchedCreditsTableFrame;
	
	public void verifyunBatchedCreditsTableFrame() {	
		switchtoFramebyID(0);
	   // switchtoFrame(unBatchedCreditsTableFrame);
		isDisplayed("unBatchedCreditsTableFrame",unBatchedCreditsTableFrame);
		verifyError(unBatchedCreditsTableFrame);	
	}
	
	//Un batched credits table
	@FindBy(css=".data_table tr td")
	private WebElement unBatchedCreditsTable;
	
	public void verifyunBatchedCreditsTable() {
		isDisplayed("unBatchedCreditsTable",unBatchedCreditsTable);
		verifyError(unBatchedCreditsTable);	
	}
	
	//Batched Claims table
	@FindBy(css="#batched-claims tr td")
	private WebElement batchedClaimsTable;
	
	public void verifybatchedClaimsTable() {
		isDisplayed("batchedClaimsTable",batchedClaimsTable);
		verifyError(batchedClaimsTable);	
	}
	
	//Batch Summary table
	@FindBy(css="#batch_summary tr td")
	private WebElement batchSummaryTable;
	
	public void verifybatchSummaryTable() {
	
		isDisplayed("batchSummaryTable",batchSummaryTable);
		verifyError(batchSummaryTable);	
	}
	
	//Batch Details table
	@FindBy(css="#batch-details tr td")
	private WebElement batchedDetailsTable;
	
	public void verifybatchedDetailsTable() {
	
		isDisplayed("batchedDetailsTable",batchedDetailsTable);
		verifyError(batchedDetailsTable);	
	}
	

}
