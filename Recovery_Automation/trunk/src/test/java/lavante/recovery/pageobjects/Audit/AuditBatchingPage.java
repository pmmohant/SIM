package lavante.recovery.pageobjects.Audit;

import java.util.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditBatchingPage {


	LavanteUtils lavanteUtils=new LavanteUtils();
	public AuditBatchingPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Batching Link
	@FindBy(linkText="Batching")
	private WebElement batchingLink;
	public WebElement batchingLink(){       //added by Ramya
		return batchingLink;
	}
	
	public void verifybatchingLink() {
	
		lavanteUtils.click("batchingLink",batchingLink);
		lavanteUtils.fluentwait(batchingLink);
	}

	//Un batched credits table frame
	@FindBy(tagName="iframe")
	private WebElement unBatchedCreditsTableFrame;
	
	
	
	public void verifyunBatchedCreditsTableFrame() {	
		lavanteUtils.switchtoFramebyID(0);
	   // switchtoFrame(unBatchedCreditsTableFrame);
		lavanteUtils.isDisplayed("unBatchedCreditsTableFrame",unBatchedCreditsTableFrame);
		lavanteUtils.verifyError(unBatchedCreditsTableFrame);	
	}
	
	//Un batched credits table
	//@FindBy(css=".data_table tr td")
	@FindBy(css="td:nth-child(1) >div:nth-child(1)  tr td:nth-child(1)")
	private WebElement unBatchedCreditsTable;
	public WebElement unBatchedCreditsTableFrame(){    //added by Ramya
		return unBatchedCreditsTable;
	}
	
	
	
	public void verifyunBatchedCreditsTable() {
		lavanteUtils.isDisplayed("unBatchedCreditsTable",unBatchedCreditsTable);
		lavanteUtils.verifyError(unBatchedCreditsTable);	
	}
	
	//Batched Claims table
	//@FindBy(css="#batched-claims tr td")
	@FindBy(css="td:nth-child(1) >div:nth-child(2)  tr td:nth-child(1)")
	private WebElement batchedClaimsTable;
	public WebElement batchedClaimsTable(){            //added by Ramya
		return batchedClaimsTable;
	}
	
	
	public void verifybatchedClaimsTable() {
		lavanteUtils.isDisplayed("batchedClaimsTable",batchedClaimsTable);
		lavanteUtils.verifyError(batchedClaimsTable);	
	}
	
	//Batch Summary table
	//@FindBy(css="#batch_summary tr td")
	@FindBy(css="td:nth-child(2) >div:nth-child(1)  tr td:nth-child(1)")
	private WebElement batchSummaryTable;
	public WebElement batchSummaryTable(){				//added by Ramya
		return batchSummaryTable;
	}
	
	public void verifybatchSummaryTable() {
	
		lavanteUtils.isDisplayed("batchSummaryTable",batchSummaryTable);
		lavanteUtils.verifyError(batchSummaryTable);	
	}
	
	//Batch Details table
	//@FindBy(css="#batch-details tr td")
	@FindBy(css="td:nth-child(2) >div:nth-child(2)  tr td:nth-child(1)")
	private WebElement batchedDetailsTable;
	public WebElement batchedDetailsTable(){            //added by Ramya
		return batchedDetailsTable;
	}
	
	public void verifybatchedDetailsTable() {
	
		lavanteUtils.isDisplayed("batchedDetailsTable",batchedDetailsTable);
		lavanteUtils.verifyError(batchedDetailsTable);	
	}
	

}
