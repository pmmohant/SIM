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
	
	//Manage Currency
	//Select All Currency Check box
	@FindBy(css="#addAuditCurrencyList th input[type='checkbox']")
	private WebElement selAllCurrChkBox;
	public WebElement selAllCurrChkBox(){
		return selAllCurrChkBox;
	}
	
	//Currency Select Check boxes list
	@FindBy(css="#addAuditCurrencyList tbody input[type='checkbox']")
	private List<WebElement> currChkBoxList;
	public List<WebElement> currChkBoxList(){
		return currChkBoxList;
	}
	
	//Currency Type List
	@FindBy(css="#addAuditCurrencyList td:nth-child(2)")
	private List<WebElement> currTypeList;
	public List<WebElement> currTypeList(){
		return currTypeList;
	}
	
	//Currency Type List
	@FindBy(css="a.mark-default")
	private List<WebElement> markAsDefLinkList;
	public List<WebElement> markAsDefLinkList(){
		return markAsDefLinkList;
	}
	
	//Save Button
	@FindBy(css="input[title='Save']")
	private WebElement saveBtn;
	public WebElement saveBtn(){
		return saveBtn;
	}
	
	//Reset Button
	@FindBy(css="input[title='Reset']")
	private WebElement resetBtn;
	public WebElement resetBtn(){
		return resetBtn;
	}

	//Search Currency Text Box
	@FindBy(css="input[name='search']")
	private WebElement currTypeTxtBox;
	public WebElement currTypeTxtBox(){
		return currTypeTxtBox;
	}
	
	//Search Button
	@FindBy(css="input[name='search_users']")
	private WebElement searchBtn;
	public WebElement searchBtn(){
		return searchBtn;
	}
	
	
	//Preferences
	//Batch By BU Check Box
	@FindBy(id="batchByBU")
	private WebElement batchByBUChkBox;
	public WebElement batchByBUChkBox(){
		return batchByBUChkBox;
	}
	
	//Batch By Currency Check Box
	@FindBy(id="batchByCurrency")
	private WebElement batchByCurrChkBox;
	public WebElement batchByCurrChkBox(){
		return batchByCurrChkBox;
	}
	
	//Batch By Void Check Box
	@FindBy(id="batchByVoid")
	private WebElement batchByVoidChkBox;
	public WebElement batchByVoidChkBox(){
		return batchByVoidChkBox;
	}
	
	//Invoice By BU Check Box
	@FindBy(id="Invoice_ByBU")
	private WebElement invoiceByBUChkBox;
	public WebElement invoiceByBUChkBox(){
		return invoiceByBUChkBox;
	}
	
	//Invoice By Currency Check Box
	@FindBy(id="invoiceByCurrency")
	private WebElement invoiceByCurrChkBox;
	public WebElement invoiceByCurrChkBox(){
		return invoiceByCurrChkBox;
	}
	
	//Batch Cut off date text box
	@FindBy(id="Invoice_BatchCutoffDate")
	private WebElement batchCutOffDateChkBox;
	public WebElement batchCutOffDateChkBox(){
		return batchCutOffDateChkBox;
	}
	
	//Month for Periodic Invoice text box
	@FindBy(id="Invoice_FrequencyByMonth")
	private WebElement monthPerInvoiceTxtBox;
	public WebElement monthPerInvoiceTxtBox(){
		return monthPerInvoiceTxtBox;
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
	
	/**
	 * Method to select customer preferred currency. USD will be set as Default Currency if no currency is set as default currency.
	 * @author girish.n
	 */
	
	public void configPreferredCurrencies(LinkedHashMap<String, String> dataMap){
		
		lavanteUtils.selectChkBox(selAllCurrChkBox, "yes");
		lavanteUtils.waitForTime(500);
		lavanteUtils.UnselectChkBox(selAllCurrChkBox, "unselect");
		
		if(dataMap.containsKey("USD")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("USD".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));	
					break;
				}
				
			}
		}
		
		if(dataMap.containsKey("CAD")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("CAD".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));				
					break;
				}
			}
		}
		
		if(dataMap.containsKey("EUR")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("EUR".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));				
					break;
				}
			}
		}
		
		if(dataMap.containsKey("ALL")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("ALL".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));	
					break;
				}
			}
		}
		
		if(dataMap.containsKey("ARS")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("ARS".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));				
					break;
				}
			}
		}
		
		if(dataMap.containsKey("BAM")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("BAM".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));				
					break;
				}
			}
		}
		
		if(dataMap.containsKey("BMD")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("BMD".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));
					break;
				}
			}
		}
		
		if(dataMap.containsKey("CNY")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("CNY".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));
					break;
				}
			}
		}
		
		if(dataMap.containsKey("DZD")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("DZD".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));				
					break;
				}
			}
		}
		
		if(dataMap.containsKey("GBP")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("GBP".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));
					break;
				}
			}
		}
		
		if(dataMap.containsKey("JPY")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("JPY".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));
					break;
				}
			}
		}
		
		if(dataMap.containsKey("MXN")){
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("MXN".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));
					break;
				}
			}
		}
		
		if(dataMap.containsKey("DefaultCurrencyType")){
			String defCurr="";
			if(dataMap.get("DefaultCurrencyType").length()>0)
				defCurr=dataMap.get("DefaultCurrencyType");
			else
				defCurr="USD";
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if(defCurr.equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(markAsDefLinkList.get(i));
					lavanteUtils.click(markAsDefLinkList.get(i));
					break;
				}
			}
		}
		else{
			for(int i=0;i<currTypeList.size();i++){
				String currType=currTypeList.get(i).getText().trim();
				if("USD".equalsIgnoreCase(currType)){
					lavanteUtils.fluentwait(currChkBoxList.get(i));
					lavanteUtils.click(currChkBoxList.get(i));
				}
			}
		}
		
		lavanteUtils.fluentwait(saveBtn);
		lavanteUtils.click(saveBtn);
		lavanteUtils.fluentwait(okBtn);
		lavanteUtils.click(okBtn);
		lavanteUtils.waitforPageload(manageCurrencyTab);
	}
	
	/**
	 * Method to configure batch preferences.
	 * 
	 * @author girish.n
	 * @param dataMap
	 */
	public void configBatchPreference(LinkedHashMap<String, String> dataMap){
		//Removing previous preferences
		lavanteUtils.fluentwait(batchByBUChkBox);
		lavanteUtils.UnselectChkBox(batchByBUChkBox, "UnSelect");
		
		lavanteUtils.fluentwait(batchByCurrChkBox);
		lavanteUtils.UnselectChkBox(batchByCurrChkBox, "UnSelect");
		
		lavanteUtils.fluentwait(batchByVoidChkBox);
		lavanteUtils.UnselectChkBox(batchByVoidChkBox, "UnSelect");
		
		if(dataMap.containsKey("BatchByBU")){
			lavanteUtils.fluentwait(batchByBUChkBox);
			lavanteUtils.click(batchByBUChkBox);
		}
		
		if(dataMap.containsKey("BatchByCurrency")){
			lavanteUtils.fluentwait(batchByCurrChkBox);
			lavanteUtils.click(batchByCurrChkBox);
		}
		
		if(dataMap.containsKey("MonthForPeriodicInvoice")){
			String data=dataMap.get("MonthForPeriodicInvoice");
			lavanteUtils.fluentwait(monthPerInvoiceTxtBox);
			lavanteUtils.typeString(data,monthPerInvoiceTxtBox);
		}
		else{
			lavanteUtils.fluentwait(monthPerInvoiceTxtBox);
			lavanteUtils.typeString("1",monthPerInvoiceTxtBox);
		}
		
		if(dataMap.containsKey("Save")){
			lavanteUtils.fluentwait(saveBtn);
			lavanteUtils.click(saveBtn);
		}
		
		lavanteUtils.fluentwait(okBtn);
		lavanteUtils.click(okBtn);
		lavanteUtils.waitforPageload(preferencesTab);
	}

	/**
	 * Method to configure invoice preferences.
	 * 
	 * @author girish.n
	 * @param dataMap
	 */
	public void configInvoicePreference(LinkedHashMap<String, String> dataMap){
		
		//Removing previous preferences
		lavanteUtils.fluentwait(invoiceByBUChkBox);
		lavanteUtils.UnselectChkBox(invoiceByBUChkBox, "UnSelect");
		
		lavanteUtils.fluentwait(invoiceByCurrChkBox);
		lavanteUtils.UnselectChkBox(invoiceByCurrChkBox, "UnSelect");
		
		if(dataMap.containsKey("InvoiceByBU")){
			lavanteUtils.fluentwait(invoiceByBUChkBox);
			lavanteUtils.click(invoiceByBUChkBox);
		}
		
		if(dataMap.containsKey("InvoiceByCurrency")){
			lavanteUtils.fluentwait(invoiceByCurrChkBox);
			lavanteUtils.click(invoiceByCurrChkBox);
		}
		
		if(dataMap.containsKey("MonthForPeriodicInvoice")){
			String data=dataMap.get("MonthForPeriodicInvoice");
			lavanteUtils.fluentwait(monthPerInvoiceTxtBox);
			lavanteUtils.typeString(data,monthPerInvoiceTxtBox);
		}
		else{
			lavanteUtils.fluentwait(monthPerInvoiceTxtBox);
			lavanteUtils.typeString("1",monthPerInvoiceTxtBox);
		}
		
		if(dataMap.containsKey("Save")){
			lavanteUtils.fluentwait(saveBtn);
			lavanteUtils.click(saveBtn);
			lavanteUtils.fluentwait(okBtn);
			lavanteUtils.click(okBtn);
			lavanteUtils.waitforPageload(preferencesTab);
		}
		
	}
}
