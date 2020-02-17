package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditSummaryPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditSummaryPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Summary Link
	@FindBy(linkText="Summary")
	private WebElement summaryLink;
	public WebElement summaryLink(){   //added by Ramya
		return summaryLink;
	}
		
	public void verifysummaryLink() {
		
		lavanteUtils.click("summaryLink",summaryLink);
		lavanteUtils.fluentwait(summaryLink);
	//	getHttpResponse();
	}

	//Current Month Credits table
	@FindBy(css="#current-month tr td")
	private WebElement currMonthTable;
	public WebElement currMonthTable(){	//added by Ramya
		return currMonthTable;
	}
		
	public void verifycurrMonthTable() {
		
		lavanteUtils.isDisplayed("currMonthTable",currMonthTable);
		lavanteUtils.verifyError(currMonthTable);	
	}
	
	//Customer Summary table
	@FindBy(css="#audit-details tr td")
	private WebElement custSummaryTable;
	public WebElement custSummaryTable(){   //added by Ramya
		return custSummaryTable;
	}
		
	public void verifycustSummaryTable() {
		
		lavanteUtils.isDisplayed("custSummaryTable",custSummaryTable);
		lavanteUtils.verifyError(custSummaryTable);	
	}
	
	//Outbound Outreach graph
	//@FindBy(css="#recKHf77SS div div:nth-child(2)")
	@FindBy(css="#recKHf77SS tr td span")
	private WebElement OutReachgrph;
	public WebElement OutReachgrph(){		//added by Ramya
		return OutReachgrph;
	}
		
	public void verifyOutReachgrph() {
		
		lavanteUtils.isDisplayed("OutReachgrph",OutReachgrph);
		lavanteUtils.verifyError(OutReachgrph);	
	}
	
	//Incoming Statements Processed
	//@FindBy(css="#recKHf77NN div div:nth-child(2)")
	@FindBy(css = "#recKHf77NN tr td span")
	private WebElement statementProcessedgrph;
	public WebElement statementProcessedgrph(){   //added by Ramya
		return statementProcessedgrph;
	}
		
	public void verifystatementProcessedgrph() {
		
		lavanteUtils.isDisplayed("statementProcessedgrph",statementProcessedgrph);
		lavanteUtils.verifyError(statementProcessedgrph);	
	}
	
	//Analysis of Open Claims - By Spend graph
	//@FindBy(css="#recKHf77OO div div:nth-child(2)")
	@FindBy(css="#recKHf77OO tr td span")		 // added by Ramya
	private WebElement openClaimsBySpendGrph;
	public WebElement openClaimsBySpendGrph(){   // added by Ramya
		return openClaimsBySpendGrph;
	}
		
	public void verifyopenClaimsBySpendGrph() {
		
		lavanteUtils.isDisplayed("openClaimsBySpendGrph",openClaimsBySpendGrph);
		lavanteUtils.verifyError(openClaimsBySpendGrph);	
	}
	
	//Analysis of Open Claims - By Count graph
	//@FindBy(css="#recKHf77PP div div:nth-child(2)")
	@FindBy(css="#recKHf77PP tr td span")
	private WebElement openClaimsByCountGrph;
	public WebElement openClaimsByCountGrph(){    //added by Ramya
		return openClaimsByCountGrph;
	}
		
	public void verifyopenClaimsByCountGrph() {
		
		lavanteUtils.isDisplayed("openClaimsByCountGrph",openClaimsByCountGrph);
		lavanteUtils.verifyError(openClaimsByCountGrph);	
	}
	
	//Analysis of Submitted Claims - By Spend graph
	//@FindBy(css="#recKHf77QQ div div:nth-child(2)")
	@FindBy(css="#recKHf77QQ tr td span")
	private WebElement subClaimsBySpendGrph;
	public WebElement subClaimsBySpendGrph(){     //added by Ramya
		return subClaimsBySpendGrph;
	}
		
	public void verifysubClaimsBySpendGrph() {
		
		lavanteUtils.isDisplayed("subClaimsBySpendGrph",subClaimsBySpendGrph);
		lavanteUtils.verifyError(subClaimsBySpendGrph);	
	}
	
	//Analysis of Submitted Claims - By Count graph
	//@FindBy(css="#recKHf77RR div div:nth-child(2)")
	@FindBy(css="#recKHf77RR tr td span")
	private WebElement subClaimsByCountGrph;
	public WebElement subClaimsByCountGrph(){     //added by Ramya
		return subClaimsByCountGrph;
	}
		
	public void verifysubClaimsByCountGrph() {
		
		lavanteUtils.isDisplayed("subClaimsByCountGrph",subClaimsByCountGrph);
		lavanteUtils.verifyError(subClaimsByCountGrph);	
	}
	
	//Total Credits Entered graph
	//@FindBy(css="#recKHf77MM div div:nth-child(2)")
	@FindBy(css="#recKHf77MM tr td span")
	private WebElement totalCreditsgrph;		//added by Ramya
	public WebElement totalCreditsgrph(){		//added by Ramya
		return totalCreditsgrph;
	}
		
	public void verifytotalCreditsgrph() {
		
		lavanteUtils.isDisplayed("totalCreditsgrph",totalCreditsgrph);
		lavanteUtils.verifyError(totalCreditsgrph);	
	}

}
