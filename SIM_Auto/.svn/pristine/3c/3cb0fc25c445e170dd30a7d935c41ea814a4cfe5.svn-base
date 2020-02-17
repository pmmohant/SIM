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
public class ClaimsDashboard {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public ClaimsDashboard(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(xpath = "//a[contains(@href,'2')][contains(@href,'claimsBasicSearch')]")
	public WebElement SubmitCountLink;

	public WebElement SubbmittedCountLink() {
		return SubmitCountLink;
	}

	@FindBy(xpath = "//a[contains(@href,'2')]/../../../div[@class='count']")
	public WebElement SubmitCount;

	public WebElement SubmitCount() {
		return SubmitCount;
	}

	@FindBy(xpath = "//a[contains(@href,'claimStatusID=4')]/../../../div[@class='count']")
	public WebElement ClosedCount;

	public WebElement ClosedCount() {
		return ClosedCount;
	}

}
