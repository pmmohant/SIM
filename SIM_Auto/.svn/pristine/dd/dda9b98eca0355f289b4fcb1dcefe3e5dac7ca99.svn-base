package com.lavante.sim.customer.pageobjects.Dashboard;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Subhas.BV
 *
 */
public class CampaignDashboard {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public CampaignDashboard(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(css = "div[class='status']")
	public List<WebElement> GetCampaignStatusList;

	public List<WebElement> GetCampaignStatusList() {
		return GetCampaignStatusList;
	}

	@FindBy(css = "div[class='count']")
	public List<WebElement> GetCampaignStatusCountList;

	public List<WebElement> GetCampaignStatusCountList() {
		return GetCampaignStatusCountList;
	}

	@FindBy(css = "a[href*='campaignDashboard']")
	public WebElement ViewCampaignDashboard;

	public WebElement ViewCampaignDashboard() {
		return ViewCampaignDashboard;
	}
}
