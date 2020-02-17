package com.lavante.sim.customer.pageobjects.Transactions.NCH;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ViewNCHPage {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public ViewNCHPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "[href*='couponDeduction'][class*='high']")
	private WebElement backLink;

	public WebElement backLink() {
		return backLink;
	}
	
//	@FindBy(css = "div[class*='work']  [class*='button']")
//	public WebElement ViewEdit;

	@FindBy(css = "span[_ngcontent-c25]")
	private WebElement deductionHeaderLabel;

	public WebElement deductionHeaderLabel() {
		return deductionHeaderLabel;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Supplier ERP')]/../..//div[2]/span")
	private WebElement supplierERPID;

	public WebElement supplierERPID() {
		return supplierERPID;
	}


	@FindBy(xpath = "//span[contains(text(),'NCH manufacturer #')]/../..//div[2]/span")
	private WebElement nchManufacturer;

	public WebElement nchManufacturer() {
		return nchManufacturer;
	}

	
	@FindBy(xpath = "//span[contains(text(),'Report date')]/../..//div[2]/span")
	private WebElement reportDate;

	public WebElement reportDate() {
		return reportDate;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Supplier name')]/../..//div[2]/span")
	private WebElement supplierName;

	public WebElement supplierName() {
		return supplierName;
	}
	
	@FindBy(xpath = "//span[contains(text(),'NCH manufacturer name')]/../..//div[2]/span")
	private WebElement nchManufName;

	public WebElement nchManufName() {
		return nchManufName;
	}
	@FindBy(xpath = "//span[contains(text(),'Total deduction amount')]/../..//div[2]/span")
	private WebElement totalDeductionAmount;

	public WebElement totalDeductionAmount() {
		return totalDeductionAmount;
	}
	@FindBy(xpath = "//span[contains(text(),'Associated NCH Invoices')]/../..//div[2]/span")
	private WebElement associatedNCHInvoices;

	public WebElement associatedNCHInvoices() {
		return associatedNCHInvoices;
	}
	@FindBy(xpath = "//span[contains(text(),'Export')]")
	private WebElement nchInvoicesExport;

	public WebElement nchInvoicesExport() {
		return nchInvoicesExport;
	}
	


	
	/**
	 * Fetch data  from view page
	 * 
	 * @param Col
	 * @return
	 */
	public String fetchData(String Col){
		WebElement e=lavanteUtils.driver.findElement(By.xpath("//*[contains(text(),'"+Col+"')]/../..//dd"));
		boolean f=lavanteUtils.isElementDisplayed(e);
		
		String act="";
		if(Col.equalsIgnoreCase("Invoice Number")){
			 e=lavanteUtils.driver.findElement(By.xpath("//*[contains(text(),'"+Col+"')]/../..//dd//a"));
		}
		
		if(f==true){
			act=e.getText().trim();
		}
		
		return act;
	}
	

	
	
}