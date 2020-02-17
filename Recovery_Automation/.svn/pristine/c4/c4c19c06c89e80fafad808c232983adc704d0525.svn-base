package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditSummaryPage extends seleniumBaseClass{
	
	//Summary Link
	@FindBy(linkText="Summary")
	private WebElement summaryLink;
		
	public void verifysummaryLink() {
		
		click("summaryLink",summaryLink);
		fluentwait(summaryLink);
		getHttpResponse();
	}

	//Current Month Credits table
	@FindBy(css="#current-month tr td")
	private WebElement currMonthTable;
		
	public void verifycurrMonthTable() {
		
		isDisplayed("currMonthTable",currMonthTable);
		verifyError(currMonthTable);	
	}
	
	//Customer Summary table
	@FindBy(css="#audit-details tr td")
	private WebElement custSummaryTable;
		
	public void verifycustSummaryTable() {
		
		isDisplayed("custSummaryTable",custSummaryTable);
		verifyError(custSummaryTable);	
	}
	
	//Outbound Outreach graph
	@FindBy(css="#recKHf77SS div div:nth-child(2)")
	private WebElement OutReachgrph;
		
	public void verifyOutReachgrph() {
		
		isDisplayed("OutReachgrph",OutReachgrph);
		verifyError(OutReachgrph);	
	}
	
	//Incoming Statements Processed
	@FindBy(css="#recKHf77NN div div:nth-child(2)")
	private WebElement statementProcessedgrph;
		
	public void verifystatementProcessedgrph() {
		
		isDisplayed("statementProcessedgrph",statementProcessedgrph);
		verifyError(statementProcessedgrph);	
	}
	
	//Analysis of Open Claims - By Spend graph
	@FindBy(css="#recKHf77OO div div:nth-child(2)")
	private WebElement openClaimsBySpendGrph;
		
	public void verifyopenClaimsBySpendGrph() {
		
		isDisplayed("openClaimsBySpendGrph",openClaimsBySpendGrph);
		verifyError(openClaimsBySpendGrph);	
	}
	
	//Analysis of Open Claims - By Count graph
	@FindBy(css="#recKHf77PP div div:nth-child(2)")
	private WebElement openClaimsByCountGrph;
		
	public void verifyopenClaimsByCountGrph() {
		
		isDisplayed("openClaimsByCountGrph",openClaimsByCountGrph);
		verifyError(openClaimsByCountGrph);	
	}
	
	//Analysis of Submitted Claims - By Spend graph
	@FindBy(css="#recKHf77QQ div div:nth-child(2)")
	private WebElement subClaimsBySpendGrph;
		
	public void verifysubClaimsBySpendGrph() {
		
		isDisplayed("subClaimsBySpendGrph",subClaimsBySpendGrph);
		verifyError(subClaimsBySpendGrph);	
	}
	
	//Analysis of Submitted Claims - By Count graph
	@FindBy(css="#recKHf77RR div div:nth-child(2)")
	private WebElement subClaimsByCountGrph;
		
	public void verifysubClaimsByCountGrph() {
		
		isDisplayed("subClaimsByCountGrph",subClaimsByCountGrph);
		verifyError(subClaimsByCountGrph);	
	}
	
	//Total Credits Entered graph
	@FindBy(css="#recKHf77MM div div:nth-child(2)")
	private WebElement totalCreditsgrph;
		
	public void verifytotalCreditsgrph() {
		
		isDisplayed("totalCreditsgrph",totalCreditsgrph);
		verifyError(totalCreditsgrph);	
	}

}
