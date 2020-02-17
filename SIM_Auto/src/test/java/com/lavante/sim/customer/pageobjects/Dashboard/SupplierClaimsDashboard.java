package com.lavante.sim.customer.pageobjects.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * 
 * 
 * @author subhas.bv
 *
 */
public class SupplierClaimsDashboard {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public SupplierClaimsDashboard(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(xpath = "//a[starts-with(text(),'Claims To Be Submitted')]")
	public WebElement ClaimsToBeSubmittedLink;

	public WebElement ClaimsToBeSubmittedLink() {
		return ClaimsToBeSubmittedLink;
	}

	@FindBy(xpath = "//a[starts-with(text(),'Claims To Be Submitted')]/ancestor::div[@class='flexItem']/span")
	public WebElement ClaimsToBeSubmittedCount;

	public WebElement ClaimsToBeSubmittedCount() {
		return ClaimsToBeSubmittedCount;
	}

	@FindBy(xpath = "//a[starts-with(text(),'Claims Awaiting Approval')]/ancestor::div[@class='flexItem']/span")
	public WebElement ClaimsAwaitingApprovalCount;

	public WebElement ClaimsAwaitingApprovalCount() {
		return ClaimsAwaitingApprovalCount;
	}

	@FindBy(xpath = "//a[starts-with(text(),'Claims Repaid')]/ancestor::div[@class='flexItem']/span")
	public WebElement ClaimsRepaidCount;

	public WebElement ClaimsRepaidCount() {
		return ClaimsRepaidCount;
	}

	@FindBy(xpath = "//a[starts-with(text(),'Claims Denied')]/ancestor::div[@class='flexItem']/span")
	public WebElement ClaimsDeniedCount;

	public WebElement ClaimsDeniedCount() {
		return ClaimsDeniedCount;
	}

}
