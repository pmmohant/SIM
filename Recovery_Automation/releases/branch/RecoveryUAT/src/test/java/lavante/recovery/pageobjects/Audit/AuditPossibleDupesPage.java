package lavante.recovery.pageobjects.Audit;

import java.awt.List;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditPossibleDupesPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditPossibleDupesPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Possible Dupes Link
	//@FindBy(linkText="Possible Dupes")
	@FindBy(css="a[href='/recovery/creditMatch.lvp']")
	private WebElement possibleDupesLink;
	public WebElement possibleDupesLink(){      //added  by Ramya
		return possibleDupesLink;
	}
		
	//iframe
	@FindBy(id="IFRAME_PossibleSummary")		//added by Ramya
	private WebElement possibleDupesLinkiframe;
	public WebElement possibleDupesLinkiframe(){
		return possibleDupesLinkiframe;
	}
	
	public void verifypossibleDupesLink() {
		
		lavanteUtils.click("possibleDupesLink",possibleDupesLink);
		lavanteUtils.fluentwait(possibleDupesLink);
	//	getHttpResponse();
	}

	//Possible Duplicates Summary table
	@FindBy(css="#possible_dup_summary tr td a")
	private WebElement possDupSummaryTable;
	public WebElement possSupSummaryTable(){				//added by Ramya
		return possDupDetailsTable;
	}
		
	public void verifypossDupSummaryTable() {
		
		lavanteUtils.isDisplayed("possDupSummaryTable",possDupSummaryTable);
		lavanteUtils.verifyError(possDupSummaryTable);	
	}
	
	
	//Possible dupes link
	@FindBy(css="table tr td div table tbody  tr td")		//added by Ramya
	private WebElement possibleDupesTable;
	public WebElement possibleDupesTable(){
		return possibleDupesLink;
	}
	
	
	//Pre-Batch Summary table
	@FindBy(css="#iframe_page table tr td")
	private WebElement preBatchTable;
	public WebElement prebatchTable(){						//added by Ramya
		return preBatchTable;
	}
		
	public void verifypreBatchTable() {
		
		lavanteUtils.isDisplayed("preBatchTable",preBatchTable);
		lavanteUtils.verifyError(preBatchTable);	
	}
	
	//Post-Batch Summary table
	@FindBy(css="#iframe_page table tr td")
	private WebElement postBatchTable;
	public WebElement postBatchTable(){				//added by Ramya
		return postBatchTable;
	}
		
	public void verifypostBatchTable() {
		
		lavanteUtils.isDisplayed("postBatchTable",postBatchTable);
		lavanteUtils.verifyError(postBatchTable);	
	}
	
	//Possible Duplicates Details table
	@FindBy(css=".data_table tr")
	private WebElement possDupDetailsTable;
	public WebElement possDupDetailsTable(){		//added by Ramya
		return possDupDetailsTable;
	}
		
	public void verifypossDupDetailsTable() {
		
		lavanteUtils.isDisplayed("possDupDetailsTable",possDupDetailsTable);
		lavanteUtils.verifyError(possDupDetailsTable);	
	}
}
