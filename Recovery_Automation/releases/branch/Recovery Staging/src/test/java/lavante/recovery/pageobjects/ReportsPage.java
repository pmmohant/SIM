package lavante.recovery.pageobjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class ReportsPage extends seleniumBaseClass{
	
	//Reports Link
	@FindBy(linkText="Reports")
	private WebElement reportsLink;
		
	public void verifyreportsLink() {
		
		click("reportsLink",reportsLink);
		fluentwait(reportsLink);
		getHttpResponse();
	}
	
	//Clients Report link
	@FindBy(css="#report-list tr:nth-child(1) td:nth-child(1)")
	private WebElement clientLink;
		
	public void verifyclientLink() {
		
		click("clientLink",clientLink);
		fluentwait(clientLink);
		getHttpResponse();
	}
	
	//Clients Report
	@FindBy(css="#report-list tr td a")
	private WebElement clientReportLink;
		
	public void verifyclientReportLink() {
		
		click("clientReportLink",clientReportLink);
		fluentwait(clientReportLink);
		getHttpResponse();
	}
	
	//Clients Report--Select drop down value
	@FindBy(css=".chosen-container a")
	private WebElement selectBatch;
		
	public void verifyselectBatch() {
		selectByVisibiletxt("LAF033- 2008-07-18- 12 Items",selectBatch);
	}
	
	//Clients Report--Run Button
	@FindBy(css="#run-button")
	private WebElement runBtn;
		
	public void verifyrunBtn() {
		
		click("runBtn",runBtn);
		fluentwait(runBtn);
		getHttpResponse();
	}
	
	//Clients Report--Data
	@FindBy(css=".content.chart_opt_collapse")
	private WebElement reportsData;
		
	public void verifyreportsData() {
		
		isDisplayed("reportsData",reportsData);
		verifyError(reportsData);
	}
}
