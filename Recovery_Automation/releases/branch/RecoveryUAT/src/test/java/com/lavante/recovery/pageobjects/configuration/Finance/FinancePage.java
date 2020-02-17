package com.lavante.recovery.pageobjects.configuration.Finance;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;
/**
 * Configuration->Finance Page
 * @author girish.n
 *
 */
public class FinancePage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public FinancePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}	
	
	//Finance Tabs
	//Invoices Tab
	@FindBy(css="a[href*='financeConfiguration.lvp']")
	private WebElement invoicesTab;
	public WebElement invoicesTab(){
		return invoicesTab;
	}
	//Contract Details Tab
	@FindBy(css="a[href*='contractDetails.lvp']")
	private WebElement contractDetailsTab;
	public WebElement contractDetailsTab(){
		return contractDetailsTab;
	}
	//Search Drop Down List Link
	@FindBy(css="#searchSelectoption_chosen a")
	private WebElement srchDDLLink;
	public  WebElement srchDDLLink(){
		return srchDDLLink;
	}
	//Search Text Box
	@FindBy(css="#searchSelectoption_chosen+input")
	private WebElement srchTxtBox;
	public WebElement srchTxtBox(){
		return srchTxtBox;
	}
	//Search Button
	@FindBy(id="search-users")
	private WebElement srchBtn;
	public WebElement srchBtn(){
		return srchBtn;
	}
	//Add New Button 
	@FindBy(id="addNew")
	private WebElement addNewBtn;
	public WebElement addNewBtn(){
		return addNewBtn;
	}
	//Add and Edit Contract Details Frame
	@FindBy(css="iframe[src*='ContractDetails.lvp']")
	private WebElement addContractDetailsFrame;
	public WebElement addContractDetailsFrame(){
		return addContractDetailsFrame;
	}
	
	//Add Contract Deatails Popup Elements
	//Audit Name Text Box
	@FindBy(id="AuditName")
	private WebElement auditNameTxtBox;
	public WebElement auditNameTxtBox(){
		return auditNameTxtBox;
	}
	//Term Text Box
	@FindBy(id="Term")
	private WebElement termTxtBox;
	public WebElement termTxtBox(){
		return termTxtBox;
	}
	//Renewal Type Drop down list link
	@FindBy(id="RenewalType_chosen")
	private WebElement rnwlTypeDDL;
	public WebElement rnwlTypeDDL(){
		return rnwlTypeDDL;
	}
	//Renewal Length text box
	@FindBy(id="RenewalLength")
	private WebElement rnwlLengthTxtBox;
	public WebElement rnwlLengthTxtBox(){
		return rnwlLengthTxtBox;
	}
	//Renewal Length text box
	@FindBy(id="Rate")
	private WebElement rateTxtBox;
	public WebElement rateTxtBox(){
		return rateTxtBox;
	}
	//Renewal Length text box
	@FindBy(id="Notes")
	private WebElement notesTxtBox;
	public WebElement notesTxtBox(){
		return notesTxtBox;
	}
	//Add Button
	@FindBy(css="input[name='save']")
	private WebElement addBtn;
	public WebElement addBtn(){
		return addBtn;
	}
	
	//Confirmation Popup OK button
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement okBtn;
	public WebElement okBtn(){
		return okBtn;
	}
	
	//Audit Name List
	@FindBy(css="#contract-details tr td:nth-child(1)")
	private List<WebElement> auditNameList;
	public  List<WebElement> auditNameList(){
		return auditNameList;
	}
	//Term List
	@FindBy(css="#contract-details tr td:nth-child(4)")
	private List<WebElement> termList;
	public  List<WebElement> termList(){
		return termList;
	}
	//Renewal Type List
	@FindBy(css="#contract-details tr td:nth-child(5)")
	private List<WebElement> rnwlTypeList;
	public  List<WebElement> rnwlTypeList(){
		return rnwlTypeList;
	}
	//Renewal Type List
	@FindBy(css="#contract-details tr td:nth-child(6)")
	private List<WebElement> rnwlLengthList;
	public  List<WebElement> rnwlLengthList(){
		return rnwlLengthList;
	}
	//Rate List
	@FindBy(css="#contract-details tr td:nth-child(7)")
	private List<WebElement> rateList;
	public  List<WebElement> rateList(){
		return rateList;
	}
	//Notes List
	@FindBy(css="#contract-details tr td:nth-child(10)")
	private List<WebElement> notesList;
	public  List<WebElement> notesList(){
		return notesList;
	}
	//Edit Link List
	@FindBy(css="a[href*='editContractDetails.lvp']")
	private List<WebElement> editLinksList;
	public  List<WebElement> editLinksList(){
		return editLinksList;
	}
	//Delete Link List
	@FindBy(id="deletecontract")
	private List<WebElement> deleteLinksList;
	public  List<WebElement> deleteLinksList(){
		return deleteLinksList;
	}
	
	
	//Reusable Methods
	
	/**
	 * Method to add new contract details
	 * @author girish.n
	 * @param dataMap
	 */
	public void addContractDetails(LinkedHashMap<String,String> dataMap){
		lavanteUtils.fluentwait(addNewBtn);
		lavanteUtils.click(addNewBtn);
		fillContractDetails(dataMap);
		formContractDetails(dataMap);
	}

	/**
	 * Method to fill Contract Details Popup.
	 * @author girish.n
	 * @param dataMap
	 */
	public void fillContractDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(addContractDetailsFrame);
		if(dataMap.containsKey("AuditName")){
			String data=dataMap.get("AuditName");
			lavanteUtils.typeString(data,auditNameTxtBox);
		}
		
		if(dataMap.containsKey("Term")){
			String data=dataMap.get("Term");
			lavanteUtils.typeString(data,termTxtBox);
		}
		
		if(dataMap.containsKey("RenewalType")){
			String data=dataMap.get("RenewalType");
			lavanteUtils.fluentwait(rnwlTypeDDL);
			lavanteUtils.click(rnwlTypeDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.switchtoFrame(addContractDetailsFrame);
			lavanteUtils.fluentwait(rnwlTypeDDL);
		}
		
		if(dataMap.containsKey("RenewalLength")){
			String data=dataMap.get("RenewalLength");
			lavanteUtils.typeString(data,rnwlLengthTxtBox);
		}
		
		if(dataMap.containsKey("Rate")){
			String data=dataMap.get("Rate");
			lavanteUtils.typeString(data,rateTxtBox);
		}
		
		if(dataMap.containsKey("Notes")){
			String data=dataMap.get("Notes");
			lavanteUtils.typeString(data,notesTxtBox);
		}
		
	}

	/**
	 * Method to save the details in Contract Details Popup.
	 * @author girish.n
	 * @param dataMap
	 */
	public void formContractDetails(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("SaveContractDetails")){
			lavanteUtils.fluentwait(addBtn);
			lavanteUtils.click(addBtn);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(okBtn);
			lavanteUtils.click(okBtn);
			lavanteUtils.waitforPageload(contractDetailsTab);
		}
		
	}
	
	/**
	 * Method to search a Contract Details.
	 * @author girish.n
	 * @param dataMap
	 */
	public void searchContractDetails(LinkedHashMap<String, String> dataMap){
		
		String data="";

		if(dataMap.containsKey("SearchType")){
			data=dataMap.get("SearchType");
			lavanteUtils.waitForTime(3000);
			
			lavanteUtils.fluentwait(srchDDLLink);
			lavanteUtils.click(srchDDLLink);
			
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectFrmDpdn(data);
		}
		if(dataMap.containsKey("SearchValue")){
			
			data=dataMap.get("SearchValue");
			lavanteUtils.fluentwait(srchTxtBox);
			if(data.length()>0){
				lavanteUtils.typeString(data, srchTxtBox);
			}
		}
		lavanteUtils.fluentwait(srchBtn);
		lavanteUtils.click(srchBtn);
		lavanteUtils.waitforPageload(contractDetailsTab);
		
	}
}
