package com.lavante.configurator.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.configurator.Common.Util.LavanteUtils;


public class HomePage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public HomePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	
	@FindBy(how=How.CSS,using="[href*='logout']")
	private WebElement logoutbtn;
	
	@FindBy(how=How.CSS,using="[class*='head'] a[class*='drop']")
	private WebElement LoginName;
	
	@FindBy(css="td:nth-child(1) span")
	private List<WebElement> CustomerName;
	
	@FindBy(css="tr button")
	private List<WebElement> editBtn;
	
	@FindBy(how=How.CSS,using="a[id*='feature']")
	private WebElement FeatureMenulnk;
	public WebElement FeatureMenulnk(){
		return FeatureMenulnk;
	}
	
	@FindBy(how=How.CSS,using="a[href*='#Supplier']")
	private WebElement SupplierMenu;
	public WebElement SupplierMenu(){
		return SupplierMenu;
	}
	@FindBy(how=How.CSS,using="[id*='user']")
	private WebElement userMenu;
	public WebElement userMenu(){
		return userMenu;
	}
	@FindBy(how=How.CSS,using="a[href*='#outreach-template']")
	private WebElement outreachMenu;
	public WebElement outreachMenu(){
		return outreachMenu;
	}
	@FindBy(how=How.CSS,using="[id='outreach-template']")
	private WebElement outreachtempMenu;
	public WebElement outreachtempMenu(){
		return outreachtempMenu;
	}
	@FindBy(how=How.CSS,using="[id='outreach']")
	private WebElement outreachsetupMenu;
	public WebElement outreachsetupMenu(){
		return outreachsetupMenu;
	}
	@FindBy(how=How.CSS,using="a[href*='#file-upload-template']")
	private WebElement preferenceMenu;
	public WebElement preferenceMenu(){
		return preferenceMenu;
	}
	@FindBy(how=How.CSS,using="[id*='vendor']")
	private WebElement vendortypeMenu;
	public WebElement vendortypeMenu(){
		return vendortypeMenu;
	}
	@FindBy(how=How.CSS,using="[id*='group']")
	private WebElement suppliergroupMenu;
	public WebElement suppliergroupMenu(){
		return suppliergroupMenu;
	}
	@FindBy(how=How.CSS,using="[id*='paym']")
	private WebElement paymentsettingsMenu;
	public WebElement paymentsettingsMenu(){
		return paymentsettingsMenu;
	}
	
	
	//Methods
		
	/**
	 * Selection of Buyer 
	 * 
	 * @author Piramanayagam.S
	 * @param buyerName
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String SelectBuyer(String buyerName) throws FileNotFoundException, IOException {
		String customerName="";
		System.out.println(editBtn.size());
		if(editBtn.size()>0){
			if(buyerName.equalsIgnoreCase("ANY")){
				customerName=CustomerName.get(0).getText();
				lavanteUtils.click(editBtn.get(0));
				
			}
		}
		return customerName;
	}
	
	/**
	 * Logout Application
	 * 
	 * @author Piramanayagam.S
	 */
	public void logout() {
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(LoginName);
		lavanteUtils.fluentwait(logoutbtn);
		lavanteUtils.click(logoutbtn);

	}
	
	
}
