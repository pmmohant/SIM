package lavante.recovery.pageobjects.DashBoard;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class SupplierPage extends seleniumBaseClass{
	
	//Supplier Link
	@FindBy(css="a[title*='Supplier']")
	private WebElement supplierLink;
	
	public void verifySupplierLink() {
	
		click("supplierLink",supplierLink);
		fluentwait(supplierLink);
		isDisplayed("supplierLink",supplierLink);
		verifyError(supplierLink);	
	}
	
	//Supplier--Credit Tab
	@FindBy(css="a[data-tab='Credit']")
	private WebElement supplierCreditLink;
	
	public void verifySupplierCreditLink() {
	
		click("supplierCreditLink",supplierCreditLink);
		fluentwait(supplierCreditLink);
		isDisplayed("supplierCreditLink",supplierCreditLink);
		verifyError(supplierCreditLink);	
	}
	
	//Supplier--Credit Tab--Top 100 Suppliers table
	@FindBy(css="#Credit tr td")
	private WebElement CreditTopSuppliers;
	
	public void verifySupplierCreditTopSuppliers() {
		fluentwait(supplierCreditLink);
		isDisplayed("CreditTopSuppliers",CreditTopSuppliers);
		verifyError(CreditTopSuppliers);	
	}
	
	
	//Supplier--Credit Supplier File Statistics Table
	@FindBy(css=".scrollable_wrapper tr td")
	private WebElement FileStatistics;
	
	public void verifyCreditFileStatistics() {
	
		isDisplayed("FileStatistics",FileStatistics);
		verifyError(FileStatistics);	
	}
	
	//Supplier--Spend Tab
	@FindBy(css="a[data-tab='Spend']")
	private WebElement supplierSpendLink;
	
	public void verifySupplierSpendLink() {
		fluentwait(supplierSpendLink);
		click("supplierSpendLink",supplierSpendLink);
		isDisplayed("supplierSpendLink",supplierSpendLink);
		verifyError(supplierSpendLink);	
	}	
	
	//Supplier--Spend Tab--Top 100 Suppliers table
	@FindBy(css="#Spend tr td")
	private WebElement SpendTopSuppliers;
	
	public void verifySupplierSpendTopSuppliers() {
	
		isDisplayed("SpendTopSuppliers",SpendTopSuppliers);
		verifyError(SpendTopSuppliers);	
	}
	
	//Supplier--Spend--File Statistics
	public void verifySpendFileStatistics() {
		
		isDisplayed("FileStatistics",FileStatistics);
		verifyError(FileStatistics);	
	}

	//Supplier--Check Request Tab
	@FindBy(css="a[data-tab*='CheckRequest']")
	private WebElement chkReqLink;
	
	public void verifychkReqLink() {
		fluentwait(chkReqLink);
		click("chkReqLink",chkReqLink);
		isDisplayed("chkReqLink",chkReqLink);
		verifyError(chkReqLink);	
	}	
	
	//Supplier--Check Request Tab--Top 100 Suppliers table
	@FindBy(css="#CheckRequest tr td")
	private WebElement chkReqTopSuppliers;
	
	public void verifychkReqTopSuppliers() {
	
		isDisplayed("chkReqTopSuppliers",chkReqTopSuppliers);
		verifyError(chkReqTopSuppliers);	
	}
	
	//Supplier--Check Request--File Statistics
	public void verifyChkReqFileStatistics() {
		
		isDisplayed("FileStatistics",FileStatistics);
		verifyError(FileStatistics);	
	}

	//Charts--Suppliers Excluded
	@FindBy(css="#recKHf77EE")
	private WebElement supplierExcludedChart;
	
	public void verifysupplierExcludedChart() {
	
		isDisplayed("supplierExcludedChart",supplierExcludedChart);
		verifyError(supplierExcludedChart);	
	}
	
	//Charts--Supplier Targeted
	@FindBy(css="#recKHf77FF")
	private WebElement supplierTargetChart;
	
	public void verifysupplierTargetChart() {
	
		isDisplayed("supplierTargetChart",supplierTargetChart);
		verifyError(supplierTargetChart);	
	}
	
	//Charts--Supplier Change Statistics
	@FindBy(css="#recKHf77GG")
	private WebElement supplierChangeChart;
	
	public void verifysupplierChangeChart() {
	
		isDisplayed("supplierChangeChart",supplierChangeChart);
		verifyError(supplierChangeChart);	
	}
	//Charts--Related Supplier Analysis
	@FindBy(css="#recKHf77HH")
	private WebElement relSupChart;
	
	public void verifyrelSupChart() {
	
		isDisplayed("relSupChart",relSupChart);
		verifyError(relSupChart);	
	}
}
