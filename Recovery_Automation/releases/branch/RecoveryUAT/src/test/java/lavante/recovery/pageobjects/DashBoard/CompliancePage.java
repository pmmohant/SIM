package lavante.recovery.pageobjects.DashBoard;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class CompliancePage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public CompliancePage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Compliance Link
	@FindBy(css="a[title*='Compliance']")
	private WebElement complianceLink;
	public WebElement complianceLink(){
		return complianceLink;
	}
	
	//Compliance Link
		@FindBy(css="a[title*='Complance']")
		private WebElement complainceLink;
		public WebElement complainceLink(){
			return complianceLink;
		}
	
	
	public WebElement verifycomplainceLink() {
	lavanteUtils.fluentwait(complainceLink);
	lavanteUtils.click("complainceLink",complainceLink);
	lavanteUtils.isDisplayed("complainceLink",complainceLink);
	lavanteUtils.verifyError(complainceLink);	
	return complainceLink;
	}
	
	//Complaint Tab
	@FindBy(css="a[data-tab='Compliant']")
	private WebElement compliantLink;
	public WebElement compliantLink(){    //added by Ramya
		return compliantLink;
	}
	
	public void verifycompliantLink() {
		lavanteUtils.fluentwait(compliantLink);
		lavanteUtils.click("compliantLink",compliantLink);
		lavanteUtils.isDisplayed("compliantLink",compliantLink);
		lavanteUtils.verifyError(compliantLink);	
	}
	
	//Complaint Tab--Table
	@FindBy(css="#Compliant tr td")
	private WebElement compliantTable;
	public WebElement compliantTable(){  //added by Ramya
		return compliantTable;
	}
	
	public void verifycompliantTable() {
	
		lavanteUtils.isDisplayed("compliantTable",compliantTable);
		lavanteUtils.verifyError(compliantTable);	
	}
	
	//Complaint Tab--Compliance Summary
	@FindBy(css=".scrollable_wrapper tr td")
	private WebElement complianceSummary;
	public WebElement complianceSummary(){   //added by Ramya
		return complianceSummary;
	}
	
	public void verifycomplianceSummary() {
	
		lavanteUtils.isDisplayed("complianceSummary",complianceSummary);
		lavanteUtils.verifyError(complianceSummary);	
	}
	
	//Non-Complaint Tab
	@FindBy(css="a[data-tab='NonCompliant']")
	private WebElement noncompliantLink;
	public WebElement noncompliantLink(){    //added by Ramya
		return noncompliantLink;
	}
	
	public void verifynoncompliantLink() {
		lavanteUtils.fluentwait(noncompliantLink);
		lavanteUtils.click("noncompliantLink",noncompliantLink);
		lavanteUtils.isDisplayed("noncompliantLink",noncompliantLink);
		lavanteUtils.verifyError(noncompliantLink);	
	}
	
	//Non-Complaint Tab--Table
	@FindBy(css="#NonCompliant tr td")
	private WebElement noncompliantTable;
	public WebElement noncompliantTable(){     //added by Ramya
		return noncompliantTable;
	}
	
	public void verifynoncompliantTable() {
	
		lavanteUtils.isDisplayed("noncompliantTable",noncompliantTable);
		lavanteUtils.verifyError(noncompliantTable);	
	}
	
	//Non-Complaint Tab--Compliance Summary
	public void verifynoncomplianceSummary() {
	
		lavanteUtils.isDisplayed("complianceSummary",complianceSummary);
		lavanteUtils.verifyError(complianceSummary);	
	}
	
	//Charts--Compliance by Spend
	@FindBy(css="#recKHf77II")
	private WebElement complianceBySpendChart;
	public WebElement complianceBySpendChart(){   //added by Ramya
		return complianceBySpendChart;
	}
	
	public void verifycomplianceBySpendChart() {
	
		lavanteUtils.isDisplayed("complianceBySpendChart",complianceBySpendChart);
		lavanteUtils.verifyError(complianceBySpendChart);	
	}
	
	//Charts--Compliance by Count
	@FindBy(css="#recKHf77JJ")
	private WebElement complianceByCountChart;
	public WebElement complianceByCountChart(){  //added by Ramya
		return complianceByCountChart;
	}
	
	public void verifycomplianceByCountChart() {
	
		lavanteUtils.isDisplayed("complianceByCountChart",complianceByCountChart);
		lavanteUtils.verifyError(complianceByCountChart);	
	}
	
	//Charts--Compliance by Spend Rank
	@FindBy(css="#recKHf77KK")
	private WebElement complianceBySpendRankChart;
	public WebElement complianceBySpendRankChart(){   //added by Ramya
		return complianceBySpendRankChart;
	}
	
	public void verifycomplianceBySpendRankChart() {
	
		lavanteUtils.isDisplayed("complianceBySpendRankChart",complianceBySpendRankChart);
		lavanteUtils.verifyError(complianceBySpendRankChart);	
	}
	
	//Charts--Suppliers on OFAC SDN
	@FindBy(css="#recKHf77LL")
	private WebElement OFACChart;
	public WebElement OFACHart(){      //added by Ramya
		return OFACChart;
	}
	
	public void verifyOFACChart() {
	
		lavanteUtils.isDisplayed("OFACChart",OFACChart);
		lavanteUtils.verifyError(OFACChart);	
	}
}
