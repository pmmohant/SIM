package lavante.recovery.pageobjects;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class ReportsPage {
	

	LavanteUtils lavanteUtils=new LavanteUtils();
	public ReportsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	//Reports Link
	@FindBy(linkText="Reports")
	private WebElement reportsLink;
	public WebElement reportsLink(){   //added by Ramya
		return reportsLink;
	}
		
	public void verifyreportsLink() {
		
		lavanteUtils.click("reportsLink",reportsLink);
		lavanteUtils.fluentwait(reportsLink);
	}
	
	//Clients Report link
	@FindBy(css="#report-list tr:nth-child(1) td:nth-child(1)")
	private WebElement clientLink;
		
	public void verifyclientLink() {
		
		lavanteUtils.click("clientLink",clientLink);
		lavanteUtils.fluentwait(clientLink);
	}
	
	//Clients Report
	@FindBy(css="#report-list tr td a")
	private WebElement clientReportLink;
	public WebElement clientReportLink(){		//added by Ramya
		return clientReportLink;
	}
	
		public void verifyclientReportLink() {
		
		lavanteUtils.click("clientReportLink",clientReportLink);
		lavanteUtils.fluentwait(clientReportLink);
	}
	
	//Clients Report--Select drop down value
	@FindBy(css=".chosen-container a")
	private WebElement selectBatch;
	public WebElement selectBatch(){
		return selectBatch;
	}
		
	public void verifyselectBatch() {
		lavanteUtils.selectByVisibiletxt("LAF033- 2008-07-18- 12 Items",selectBatch);
	}
	
	//Clients Report--Run Button
	@FindBy(css="#run-button")
	private WebElement runBtn;
		
	public void verifyrunBtn() {
		
		lavanteUtils.click("runBtn",runBtn);
		lavanteUtils.fluentwait(runBtn);
	}
	
	//Clients Report--Data
	@FindBy(css=".content.chart_opt_collapse")
	private WebElement reportsData;
	public WebElement reportsData(){		//added by Ramya
		
		return reportsData;
	}
		
	public void verifyreportsData() {
		
		lavanteUtils.isDisplayed("reportsData",reportsData);
		lavanteUtils.verifyError(reportsData);
	}
}
