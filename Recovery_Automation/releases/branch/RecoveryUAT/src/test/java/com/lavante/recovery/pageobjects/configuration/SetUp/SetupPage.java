package com.lavante.recovery.pageobjects.configuration.SetUp;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;
/**
 * Configation->SetUP Page objects and Methods
 * @author girish.n
 *
 */
public class SetupPage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public SetupPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	//SetUp Tabs
	//Audit Tab
	@FindBy(css="a[href='configuration.lvp']")
	private WebElement auditTab;
	public WebElement auditTab(){
		return auditTab;
	}
	
	//Client Tab
	@FindBy(css="a[href='clientConfiguration.lvp']")
	private WebElement clientTab;
	public WebElement clientTab(){
		return clientTab;
	}
		
	//Business Unit Tab
	@FindBy(css="a[href='businessUnit.lvp']")
	private WebElement buUnitTab;
	public WebElement buUnitTab(){
		return buUnitTab;
	}
		
	//Preferences Tab
	@FindBy(css="a[href='automationConfiguration.lvp']")
	private WebElement preferencesTab;
	public WebElement preferencesTab(){
		return preferencesTab;
	}
		
	//Request Letters
	@FindBy(css="a[href='requestLetters.lvp']")
	private WebElement reqLettersTab;
	public WebElement reqLettersTab(){
		return reqLettersTab;
	}
		
	//Manage Currency
	@FindBy(css="a[href='manageCurrency.lvp']")
	private WebElement manageCurrencyTab;
	public WebElement manageCurrencyTab(){
		return manageCurrencyTab;
	}
		
	//Business Unit
	//BU Inputs (Text box and Check box) - Textbox and check box to add and edit business units
	@FindBy(css="#bu_unit input")
	private List<WebElement> buUnitInputList;
	public List<WebElement> buUnitInputList(){
		return buUnitInputList;
	}
	
	// Header List
	@FindBy(css="#bu_unit th")
	private List<WebElement> headerList;
	public List<WebElement> headerList(){
		return headerList;
	}
	
	//Delete Links
	@FindBy(css="a[href*='deleteBU.lvp']")
	private List<WebElement> delLinkList;
	public List<WebElement> delLinkList(){
		return delLinkList;
	}
	
	//OK Button
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement okBtn;
	public WebElement okBtn(){
		return okBtn;
	}

	//Business Unit list
	@FindBy(css="#bu_unit td:nth-child(1)")
	private List<WebElement> buUnitList;
	public List<WebElement> buUnitList(){
		return buUnitList;
	}
	
	//Report BU list
	@FindBy(css="#bu_unit td:nth-child(2)")
	private List<WebElement> repBUList;
	public List<WebElement> repBUList(){
		return repBUList;
	}
	
	//Location list
	@FindBy(css="#bu_unit td:nth-child(3)")
	private List<WebElement> locationList;
	public List<WebElement> locationList(){
		return locationList;
	}
	
	//Active Status list
	@FindBy(css="#bu_unit td:nth-child(4)")
	private List<WebElement> actStatusList;
	public List<WebElement> actStatusList(){
		return actStatusList;
	}
	
	/**
	 * Method to enter Business Unit details and save
	 * @author girish.n
	 */
	
	public void enterBusinessUnit(LinkedHashMap<String, String> dataMap){
		
		if(dataMap.containsKey("BusinessUnit")){
			String data=dataMap.get("BusinessUnit");
			lavanteUtils.click(buUnitInputList.get(0));
			lavanteUtils.typeString(data,buUnitInputList.get(0));
		}
		
		if(dataMap.containsKey("ReportBU")){
			String data=dataMap.get("ReportBU");
			lavanteUtils.click(buUnitInputList.get(1));
			lavanteUtils.typeString(data,buUnitInputList.get(1));
		}
		
		if(dataMap.containsKey("Location")){
			String data=dataMap.get("Location");
			lavanteUtils.click(buUnitInputList.get(2));
			lavanteUtils.typeString(data,buUnitInputList.get(2));
		}
		
		if(dataMap.containsKey("Active")){
			String data=dataMap.get("Active");
			lavanteUtils.selectChkBox(buUnitInputList.get(3),data);
					
		}
		
		lavanteUtils.pressEnterkey("", buUnitInputList.get(0));
	}
}
