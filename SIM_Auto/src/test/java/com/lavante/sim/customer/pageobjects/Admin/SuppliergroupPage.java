package com.lavante.sim.customer.pageobjects.Admin;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

public class SuppliergroupPage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public SuppliergroupPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "a[href*='buyerSupplierGroup']")
	private WebElement SuppliergroupTab;
	public WebElement SuppliergroupTab(){
		return SuppliergroupTab;
	}

	@FindBy(css = "button[class*='add_suppliergroup']")
	private WebElement AddSuppliergroup;
	public WebElement AddSuppliergroup(){
		return AddSuppliergroup;
	}
	
	@FindBy(css = "input[data-label*='Supplier Group']")
	private WebElement SuppliergrpNameTxtBox;
	public WebElement SuppliergrpNameTxtBox(){
		return SuppliergrpNameTxtBox;
	}
	
	@FindBy(css = "div[class*='file_save']")
	private WebElement FileSaveBtn;
	public WebElement FileSaveBtn(){
		return FileSaveBtn;
	}
	@FindBy(css = "div[class*='dialog'] button[class*='primary']")
	private WebElement DeleteBtn;
	public WebElement DeleteBtn(){
		return DeleteBtn;
	}
	
	@FindBy(css = "span[class='error']")
	private WebElement Errormsg;
	public WebElement Errormsg(){
		return Errormsg;
	}
	
	@FindBy(css=".bannerMessage")
	private WebElement bannerMsg;
	public WebElement bannerMsg(){
		return bannerMsg;
	}

	@FindBy(css = "div[name='suppliergroup']")
	public List<WebElement> ListSuppliergroup;
		
	@FindBy(css = "div[class*='edit']")
	public List<WebElement> ListEditSuppliergroup;
	
	@FindBy(css = "div[class*='icon_file_save']")
	public List<WebElement> ListCheckedSuppliergroup;
		
	@FindBy(css = "a[href*='deleteBuyerData']")
	public List<WebElement> ListDeleteSuppliergroup;
	
	/**
	 * MethodName : addNewSupplierGroup : will add new supplier group
	 * 
	 * @param testData
	 *            : LinkedHashMap<String, String> testData
	 * @throws InterruptedException 
	 */

	public String addNewSupplierGroup(LinkedHashMap<String, String> testData) throws InterruptedException {

		Reporter.log("Adding new supplier group");
		
		clickAddSupplierGroup();
		String data = fillSuppliergroup(testData);
		formUserAction(testData);
		return data;
	}
	
/*	public String editSupplierGrp(LinkedHashMap<String, String> testData) {

		Reporter.log("Adding new supplier group");
		
		clickSupplierGroup();
		String data = fillSuppliergroup(testData);
		formUserAction(testData);
		return data;
	}*/

	private void clickSupplierGroup() {

		lavanteUtils.fluentwait(SuppliergroupTab);
		lavanteUtils.click(SuppliergroupTab());
	}
	
	private void clickAddSupplierGroup() {

		lavanteUtils.fluentwait(AddSuppliergroup);
		lavanteUtils.click(AddSuppliergroup());
	}

	public String fillSuppliergroup(LinkedHashMap<String, String> testData) {
		LinkedHashMap<String, String> testData1=new LinkedHashMap<>();
		String data = new String();
		if (testData.containsKey("SupplierGroupName")) {
			SuppliergrpNameTxtBox.clear();
			data = lavanteUtils.typeString(testData.get("SupplierGroupName"), SuppliergrpNameTxtBox);
			testData1.put("SupplierGroupName", data);
		}
		
		return data;
	}
	
	public void formUserAction(LinkedHashMap<String, String> testData) throws InterruptedException {
		lavanteUtils.fluentwait(FileSaveBtn);
		if (testData.containsKey("Save")) {
			lavanteUtils.clicks(FileSaveBtn);
			lavanteUtils.waitForTime(5000);
		}
		
	}
	

	/**
	 * Sanity
	 * 
	 * @author Thejaswi.Bhat
	 */
	public boolean verifyBuyerSupplierGroupPage() {
		boolean flag=false;
		lavanteUtils.switchtoFrame(null);
		flag=lavanteUtils.verifyElementDisplayed("Add New Supplier Group  Button", AddSuppliergroup);
		return flag;
	}
		
}
