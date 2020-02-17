package com.lavante.sim.supplier.pageobjects.Items;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

public class SupplierItemSearch {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public SupplierItemSearch(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css="thead th")
	private List<WebElement> Headers;

	@FindBy(css = "button[class*='primary']")
	private WebElement Searchbtn;

	public WebElement Searchbtn() {
		return Searchbtn;
	}

	@FindBy(css = "div button[ng-class*='drop']")
	private WebElement AddItem;

	public WebElement AddItem() {
		return AddItem;
	}

	@FindBy(css = "div[class*='bar'] button[class*='action_button']")
	private WebElement Actnbtn;

	public WebElement Actnbtn() {
		return Actnbtn;
	}
	
	@FindBy(css = "div[class*='dialog'] button[class*='primary']")
	private WebElement okBtn;

	public WebElement okBtn() {
		return okBtn;
	}
			
	@FindBy(css = "button[class*='flat']")
	private WebElement Clearbtn;

	public WebElement Clearbtn() {
		return Clearbtn;
	}
	
	//View Page
	
	@FindBy(css = "a[href*='viewItem']:nth-child(2)")
	public List<WebElement> nextRecord;
	
	@FindBy(css = "dl dt")
	public List<WebElement> ViewItem;
	
	@FindBy(css = "a[href*='edit'][class*='button']")
	public WebElement ViewEdit;
	
	//End of View 
	//End of Page Object
	
	public void basicSearch(Map<String, String> dataMap) {
			fillBasicSearchDetails(dataMap);
			formBasicSearchDetails(dataMap);
	}
	
	private void fillBasicSearchDetails(Map<String, String> dataMap) {
		//Created Dummy Text
		lavanteUtils.fluentwait(Searchbtn);
		String y="DUMMY";
		String x="//*[text()='"+y+"']/../following-sibling::div//input";
		
		if(dataMap.containsKey("ItemCode")){
			if(!dataMap.get("ItemCode").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Item Code");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("ItemCode"));
			}
		}
		
		if(dataMap.containsKey("CaseGTIN")){
			if(!dataMap.get("CaseGTIN").equalsIgnoreCase("ANY")){
				String z=x;
				z=z.replace(y, "Case GTIN");
				lavanteUtils.driver.findElement(By.xpath(z)).clear();
				lavanteUtils.driver.findElement(By.xpath(z)).sendKeys(dataMap.get("CaseGTIN"));
			}
		}
		
	}

	public void formBasicSearchDetails(Map<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if(dataMap.containsKey("Search")){
			lavanteUtils.click(Searchbtn);
			lavanteUtils.waitForTime(2000);
		}
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.click(Clearbtn);
		}
	}

	public void AddItem(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(AddItem);
		if(dataMap.containsKey("ManualItem")){
			lavanteUtils.click(AddItem);
			lavanteUtils.selectvalueFrmDpdnAction("Enter details manually");
		}
		
		
	}

	public void ItemSelectionAction(LinkedHashMap<String, String> dataMap) {
		ItemSelection(dataMap);
		if(dataMap.containsKey("Action")){
			String x=dataMap.get("Action");
			lavanteUtils.click(Actnbtn);
			lavanteUtils.selectvalueFrmDpdnAction(x);
			
			if(!x.contains("Edit")){
				lavanteUtils.click(okBtn);
			}
		}
		
		
		
	}

	private void ItemSelection(LinkedHashMap<String, String> dataMap) {
		String appitemCode = ""; 
		basicSearch(dataMap);
		int size = iterateSearchHeaderFindColList("Item Code").size() ;
		if (size> 0) {
			if (dataMap.containsKey("ItemCode")) {
				String x=dataMap.get("ItemCode");
				outr:for (int i = 0; i <= size; i++) {
					appitemCode = iterateSearchHeaderFindColList("Item Code").get(i).getText();
					if (appitemCode.contains(x)) {
						lavanteUtils.click(iterateSearchHeaderFindColList("Case GTIN").get(i));
						break outr;
					}else if (x.contains("ANY")){
						lavanteUtils.click(iterateSearchHeaderFindColList("Case GTIN").get(i));
						dataMap.put("Item Code",appitemCode);
						break outr;
					}
					if (i == size) {
						lavanteUtils.click(iterateSearchHeaderFindColList("Case GTIN").get(0));
					}
				}
			}

		}
		lavanteUtils.waitForTime(2000);
		
	}
	
	//View User

		public String iterateViewItem(String col) {
			String s = null;
			lavanteUtils.switchtoFrame(null);
			int j = viewItemIdentify(col);
			//int y = j + 1;
			String x = "//dl["+j+"]//dt/..//dd";
			s=lavanteUtils.driver.findElements(By.xpath(x)).get(0).getText().trim();
			return s;
		}
		
		private int viewItemIdentify(String col) {
			int ki = 0;
			boolean found = false;
			lavanteUtils.fluentwait(ViewItem.get(0));
			if (ViewItem.size() > 0) {
				for (int i = 0; i < ViewItem.size(); i++) {
					String x = ViewItem.get(i).getText();
					if (x.contains(col)) {
						ki = i;
						// List start with 0 but need a number more than that to
						// fetch in xpath
						ki = i + 1;
						found = true;
						break;
					}
				}
			}

			if (found == false) {
				Assert.assertTrue(found, "Label name not found" + col);
			}
			return ki;

		}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = "tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		if (col.contains("Item Code") ) {
			x = "tbody td:nth-child(" + j + ") a";
			System.out.println("Iterate for name/contact:" + x);
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		System.out.println("Iterate Search Col:" + col + ":" + s.size());
		return s;
	}
	
	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase();
				if (x.contains(col.toLowerCase())) {
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
