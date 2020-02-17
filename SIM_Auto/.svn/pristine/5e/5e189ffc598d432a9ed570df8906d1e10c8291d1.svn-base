package com.lavante.sim.customer.pageobjects.Dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

public class OnboardingProgress {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public OnboardingProgress(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(xpath = "//span[contains(text(),'File cleanse statistics')]/parent::td/following-sibling::td//..//div")
	public WebElement firstDropDwnInfileCleanseStats;

	public WebElement firstDropDwnInfileCleanseStats() {
		return firstDropDwnInfileCleanseStats;
	}

	@FindBy(xpath = "//th[text()='Erroneous Records']/../../..//th")
	public List<WebElement> fileCleanseStatisticsTableHeader;

	public List<WebElement> fileCleanseStatisticsTableHeader() {
		return fileCleanseStatisticsTableHeader;
	}

	@FindBy(xpath = "//th[text()='Erroneous Records']/../../..//td")
	public List<WebElement> fileCleanseStatisticsTableData;

	public List<WebElement> fileCleanseStatisticsTableData() {
		return fileCleanseStatisticsTableData;
	}
	
	@FindBy(xpath = "//span[contains(text(),'File cleanse statistics')]/../../div/button")
	public WebElement FileCleanseStatsChartDropDwnVbar;

	public WebElement FileCleanseStatsChartDropDwnVbar() {
		return FileCleanseStatsChartDropDwnVbar;
	}

	@FindBy(xpath = "//span[contains(text(),'File cleanse statistics')]/../../div[2]//a[contains(@class,'type')]")
	public WebElement FileCleanseStatsChartDropDwn;

	public WebElement FileCleanseStatsChartDropDwn() {
		return FileCleanseStatsChartDropDwn;
	}

	@FindBy(css = "span[style*='bloc'] a[rel*='tab']")
	public WebElement DataTableView;

	public WebElement DataTableView() {
		return DataTableView;
	}

}
