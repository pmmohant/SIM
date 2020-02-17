package com.lavante.sim.supplier.pageobjects.Items;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class CreateItemPage {
	LavanteUtils lavanteUtils = new LavanteUtils();

	// Created for addSupplierItemDetails.lvp //editSupplierItem.lvp

	public CreateItemPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "button[class*='primary']")
	private WebElement Savebtn;

	public WebElement Savebtn() {
		return Savebtn;
	}

	@FindBy(css = "div button[ng-class*='drop']")
	private WebElement AddItem;

	public WebElement AddItem() {
		return AddItem;
	}

	@FindBy(css = "button[class*='flat']")
	private WebElement Clearbtn;

	public WebElement Clearbtn() {
		return Clearbtn;
	}

	public void CreateItem(Map<String, String> dataMap) {
		fillItem(dataMap);
		formAction(dataMap);
	}

	public void fillItem(Map<String, String> dataMap) {
		// Created Dummy Text
		lavanteUtils.fluentwait(Savebtn);
		String y = "DUMMY";
		String textField = "//*[text()='" + y + "']/../following-sibling::div//input";
		String drpdwn = "//*[text()='" + y + "']/../following-sibling::div//select";

		if (dataMap.containsKey("ItemCode")) {
			if (!dataMap.get("ItemCode").equalsIgnoreCase("ANY")) {
				String z = textField;
				z = z.replace(y, "Item Code");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("ItemCode"));
			}
		}
		if (dataMap.containsKey("GTINType")) {
			if (!dataMap.get("GTINType").equalsIgnoreCase("ANY")) {
				String z = drpdwn;
				z = z.replace(y, "GTIN Type");
				lavanteUtils.selectbyvisibiletxt(dataMap.get("GTINType"), lavanteUtils.driver.findElement(By.xpath(z)));
			}
		}

		if (dataMap.containsKey("ItemDesc")) {
			if (!dataMap.get("ItemDesc").equalsIgnoreCase("ANY")) {
				String z = textField;
				z = z.replace(y, "Item Description");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("ItemDesc"));
			}
		}

		if (dataMap.containsKey("CaseGTIN")) {
			if (!dataMap.get("CaseGTIN").equalsIgnoreCase("ANY")) {
				String z = textField;
				z = z.replace(y, "Case GTIN");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("CaseGTIN"));
			}
		}

	}

	public void formAction(Map<String, String> dataMap) {
		// lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(Savebtn);
			lavanteUtils.waitForTime(2000);
		}
	}

}
