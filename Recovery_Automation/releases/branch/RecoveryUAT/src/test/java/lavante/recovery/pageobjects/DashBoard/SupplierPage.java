package lavante.recovery.pageobjects.DashBoard;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class SupplierPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public SupplierPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Supplier Link
	@FindBy(css="a[title*='Supplier']")
	private WebElement supplierLink;
	public WebElement supplierLink(){
		return supplierLink;
	}
	
	public WebElement verifySupplierLink() {
	
		lavanteUtils.click("supplierLink",supplierLink);
		lavanteUtils.fluentwait(supplierLink);
		lavanteUtils.isDisplayed("supplierLink",supplierLink);
		lavanteUtils.verifyError(supplierLink);	
		return supplierLink;
	}
	
	//Supplier--Credit Tab
	@FindBy(css="a[data-tab='Credit']")
	private WebElement supplierCreditLink;
	public WebElement supplierCreditLink(){     //added by Ramya
		return supplierCreditLink;
	}
	
	
	public void verifySupplierCreditLink() {
	
		lavanteUtils.click("supplierCreditLink",supplierCreditLink);
		lavanteUtils.fluentwait(supplierCreditLink);
		lavanteUtils.isDisplayed("supplierCreditLink",supplierCreditLink);
		lavanteUtils.verifyError(supplierCreditLink);	
	}
	
	//Supplier--Credit Tab--Top 100 Suppliers table
	@FindBy(css="#Credit tr td")
	private WebElement CreditTopSuppliers;
	public WebElement CreditTopSuppliers(){
		return CreditTopSuppliers;
	}
	
	public void verifySupplierCreditTopSuppliers() {
		lavanteUtils.fluentwait(supplierCreditLink);
		lavanteUtils.isDisplayed("CreditTopSuppliers",CreditTopSuppliers);
		lavanteUtils.verifyError(CreditTopSuppliers);	
	}
	
	
	//Supplier--Credit Supplier File Statistics Table
	@FindBy(css=".scrollable_wrapper tr td")
	private WebElement FileStatistics;
	public WebElement FileStatistics(){
		return FileStatistics;
	}
	
	public void verifyCreditFileStatistics() {
	
		lavanteUtils.isDisplayed("FileStatistics",FileStatistics);
		lavanteUtils.verifyError(FileStatistics);	
	}
	
	//Supplier--Spend Tab
	@FindBy(css="a[data-tab='Spend']")
	private WebElement supplierSpendLink;
	public WebElement supplierSpendLink(){
		return supplierSpendLink;
	}
	
	public void verifySupplierSpendLink() {
		lavanteUtils.fluentwait(supplierSpendLink);
		lavanteUtils.click("supplierSpendLink",supplierSpendLink);
		lavanteUtils.isDisplayed("supplierSpendLink",supplierSpendLink);
		lavanteUtils.verifyError(supplierSpendLink);	
	}	
	
	//Supplier--Spend Tab--Top 100 Suppliers table
	@FindBy(css="#Spend tr td")
	private WebElement SpendTopSuppliers;
	public WebElement SpendTopSuppliers(){
		return SpendTopSuppliers;
	}
	
	public void verifySupplierSpendTopSuppliers() {
	
		lavanteUtils.isDisplayed("SpendTopSuppliers",SpendTopSuppliers);
		lavanteUtils.verifyError(SpendTopSuppliers);	
	}
	
	
	//Supplier -Spend File Statistics
	
	@FindBy(css=".separator_wrapper tr td")                 //added by Ramya
	private WebElement spendSupplierFileStatistics;
	public WebElement spendSupplierFileStatistics(){
		return spendSupplierFileStatistics;
	}
	
	
	//Supplier--Spend--File Statistics
	public void verifySpendFileStatistics() {
		
		lavanteUtils.isDisplayed("FileStatistics",FileStatistics);
		lavanteUtils.verifyError(FileStatistics);	
	}

	//Supplier--Check Request Tab
	@FindBy(css="a[data-tab*='CheckRequest']")
	private WebElement chkReqLink;
	public WebElement chkReqLink(){
		return chkReqLink;
	}
	
	public void verifychkReqLink() {
		lavanteUtils.fluentwait(chkReqLink);
		lavanteUtils.click("chkReqLink",chkReqLink);
		lavanteUtils.isDisplayed("chkReqLink",chkReqLink);
		lavanteUtils.verifyError(chkReqLink);	
	}	
	
	//Supplier--Check Request Tab--Top 100 Suppliers table
	@FindBy(css="#CheckRequest tr td")
	private WebElement chkReqTopSuppliers;
	public WebElement chkReqTopSuppliers(){
		return chkReqTopSuppliers;
	}
	
	public void verifychkReqTopSuppliers() {
	
		lavanteUtils.isDisplayed("chkReqTopSuppliers",chkReqTopSuppliers);
		lavanteUtils.verifyError(chkReqTopSuppliers);	
	}
	
	//Supplier--Check Request--File Statistics
	public void verifyChkReqFileStatistics() {
		
		lavanteUtils.isDisplayed("FileStatistics",FileStatistics);
		lavanteUtils.verifyError(FileStatistics);	
	}

	//Charts--Suppliers Excluded
	@FindBy(css="#recKHf77EE")
	private WebElement supplierExcludedChart;
	public WebElement supplierExcludedChart(){     //added by Ramya
		return supplierExcludedChart;
	}
	
	public void verifysupplierExcludedChart() {
	
		lavanteUtils.isDisplayed("supplierExcludedChart",supplierExcludedChart);
		lavanteUtils.verifyError(supplierExcludedChart);	
	}
	
	//Charts--Supplier Targeted
	@FindBy(css="#recKHf77FF")
	private WebElement supplierTargetChart;
	public WebElement supplierTargetchart(){    //added by Ramya
		return supplierTargetChart;
	}
	
	public void verifysupplierTargetChart() {
	
		lavanteUtils.isDisplayed("supplierTargetChart",supplierTargetChart);
		lavanteUtils.verifyError(supplierTargetChart);	
	}
	
	//Charts--Supplier Change Statistics
	@FindBy(css="#recKHf77GG")
	private WebElement supplierChangeChart;
	public WebElement supplierChangeChart(){       //added by Ramya
		return supplierChangeChart;
	}
	
	public void verifysupplierChangeChart() {
	
		lavanteUtils.isDisplayed("supplierChangeChart",supplierChangeChart);
		lavanteUtils.verifyError(supplierChangeChart);	
	}
	//Charts--Related Supplier Analysis
	@FindBy(css="#recKHf77HH")
	private WebElement relSupChart;
	public WebElement relSupChart(){             //added by Ramya
		return relSupChart;
	}
	
	public void verifyrelSupChart() {
	
		lavanteUtils.isDisplayed("relSupChart",relSupChart);
		lavanteUtils.verifyError(relSupChart);	
	}
}
