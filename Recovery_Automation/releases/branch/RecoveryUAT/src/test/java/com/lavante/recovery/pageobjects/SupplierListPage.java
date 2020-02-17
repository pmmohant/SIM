package com.lavante.recovery.pageobjects;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

/**
 * 
 * @author girish.n
 *
 */
public class SupplierListPage {

LavanteUtils lavanteUtils = new LavanteUtils();
	
	public SupplierListPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	@FindBy(css="#contentTitle+label")
	private WebElement contentTitle;
	public WebElement contentTitle(){
		return contentTitle;
	}
	
	@FindBy(css="#supplierList th")
	private List<WebElement> headerList;
	public List<WebElement> headerList(){
		return headerList;
	}
	
	
	@FindBy(css="span[class='text-green']")
	private WebElement supplierListName;
	public WebElement supplierListName(){
		return supplierListName;
	}
	
	@FindBy(css="input[class='button_blue']")
	private WebElement backButton;
	public WebElement backButton(){
		return backButton;
	}
	
	@FindBy(css="table[id='supplierList'] tbody tr td:nth-child(1)")
	private WebElement matchingCriteria;
	public WebElement matchingCriteria(){
		return matchingCriteria;
	}
	
	@FindBy(css="table[id='supplierList'] tr td")
	private WebElement noDataAvailable;
	public WebElement noDataAvailable(){
		return noDataAvailable;
	}
	
	
	/**
	 * Method to locate the columns by taking Column Name as argument. Returns List<WebElement>
	 * @author girish.n
	 */
		public List<WebElement> getSupplier(String col) {
		
		int i;
		for(i=0;i<headerList.size();i++){
			if(headerList.get(i).getText().equalsIgnoreCase(col))
				break;
		}
		String css="#supplierList td:nth-child("+(i+1)+")";
		List<WebElement> dsa=lavanteUtils.driver.findElements(By.cssSelector(css));
		
		return dsa;
	}
	
}
