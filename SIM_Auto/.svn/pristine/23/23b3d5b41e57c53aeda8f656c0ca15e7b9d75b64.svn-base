package com.lavante.sim.supplier.pageobjects.Agreements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ViewDetailsListCostChangePage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public ViewDetailsListCostChangePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "thead th")
	private List<WebElement> Headers;
	String getHeaderInfoValue = "//*[contains(text(),'$')]/parent::dt[1]/following-sibling::dd[1]";

	@FindBy(css = "a[class='prgx-text-link stopNavigation']")
	public WebElement BackLink;

	@FindBy(id = "editListCost")
	private WebElement EditBtn;

	public WebElement EditBtn() {
		return EditBtn;
	}

	public String getHeaderInfoValue(String headerLabel) {
		String obj = getHeaderInfoValue.replace("$", headerLabel);
		WebElement ele = lavanteUtils.driver.findElement(By.xpath(obj));
		return lavanteUtils.getText(ele).trim();
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		return s;
	}

	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText();
				if (x.contains(col)) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
					System.out.println(col + ",Col Found at " + ki);
					found = true;
					break;
				}
			}
		}
		if (found == false) {
			Assert.assertTrue(false, "Col name not found" + col);
		}
		return ki;
	}

}
