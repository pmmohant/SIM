package lavante.recovery.pageobjects.DashBoard;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class CompliancePage extends seleniumBaseClass{
	
	//Compliance Link
	@FindBy(css="a[title*='Compliance']")
	private WebElement complainceLink;
	
	public void verifycomplainceLink() {
		fluentwait(complainceLink);
		click("complainceLink",complainceLink);
		isDisplayed("complainceLink",complainceLink);
		verifyError(complainceLink);	
	}
	
	//Complaint Tab
	@FindBy(css="a[data-tab='Compliant']")
	private WebElement compliantLink;
	
	public void verifycompliantLink() {
		fluentwait(compliantLink);
		click("compliantLink",compliantLink);
		isDisplayed("compliantLink",compliantLink);
		verifyError(compliantLink);	
	}
	
	//Complaint Tab--Table
	@FindBy(css="#Compliant tr td")
	private WebElement compliantTable;
	
	public void verifycompliantTable() {
	
		isDisplayed("compliantTable",compliantTable);
		verifyError(compliantTable);	
	}
	
	//Complaint Tab--Compliance Summary
	@FindBy(css=".scrollable_wrapper tr td")
	private WebElement complianceSummary;
	
	public void verifycomplianceSummary() {
	
		isDisplayed("complianceSummary",complianceSummary);
		verifyError(complianceSummary);	
	}
	
	//Non-Complaint Tab
	@FindBy(css="a[data-tab='NonCompliant']")
	private WebElement noncompliantLink;
	
	public void verifynoncompliantLink() {
		fluentwait(noncompliantLink);
		click("noncompliantLink",noncompliantLink);
		isDisplayed("noncompliantLink",noncompliantLink);
		verifyError(noncompliantLink);	
	}
	
	//Non-Complaint Tab--Table
	@FindBy(css="#NonCompliant tr td")
	private WebElement noncompliantTable;
	
	public void verifynoncompliantTable() {
	
		isDisplayed("noncompliantTable",noncompliantTable);
		verifyError(noncompliantTable);	
	}
	
	//Non-Complaint Tab--Compliance Summary
	public void verifynoncomplianceSummary() {
	
		isDisplayed("complianceSummary",complianceSummary);
		verifyError(complianceSummary);	
	}
	
	//Charts--Compliance by Spend
	@FindBy(css="#recKHf77II")
	private WebElement complianceBySpendChart;
	
	public void verifycomplianceBySpendChart() {
	
		isDisplayed("complianceBySpendChart",complianceBySpendChart);
		verifyError(complianceBySpendChart);	
	}
	
	//Charts--Compliance by Count
	@FindBy(css="#recKHf77JJ")
	private WebElement complianceByCountChart;
	
	public void verifycomplianceByCountChart() {
	
		isDisplayed("complianceByCountChart",complianceByCountChart);
		verifyError(complianceByCountChart);	
	}
	
	//Charts--Compliance by Spend Rank
	@FindBy(css="#recKHf77KK")
	private WebElement complianceBySpendRankChart;
	
	public void verifycomplianceBySpendRankChart() {
	
		isDisplayed("complianceBySpendRankChart",complianceBySpendRankChart);
		verifyError(complianceBySpendRankChart);	
	}
	
	//Charts--Suppliers on OFAC SDN
	@FindBy(css="#recKHf77LL")
	private WebElement OFACChart;
	
	public void verifyOFACChart() {
	
		isDisplayed("OFACChart",OFACChart);
		verifyError(OFACChart);	
	}
}
