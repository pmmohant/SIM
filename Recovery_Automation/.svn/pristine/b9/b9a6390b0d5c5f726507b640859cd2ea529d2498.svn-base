package com.lavante.recovery.pageobjects.Audit.CheckRegistry;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

/**
 * CheckRegistry Class
 * 
 * @author Girish Umesh Naik
 *  
 */

public class CheckRegistry {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public CheckRegistry(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	//Check Audit Link
	@FindBy(linkText="Audit")
	private WebElement auditLinkTab;
	public void clickOnAuditLinkTab(){
		lavanteUtils.fluentwait(auditLinkTab);
		lavanteUtils.click(auditLinkTab);
	}
	
	//Check Registry Link
	@FindBy(css="a[href='/recovery/checkRequest.lvp']")
	private WebElement chkRegLink;

	
	//Click on Check Registry Link
	public void clickOnChkRegLink(){
		lavanteUtils.fluentwait(chkRegLink);
		lavanteUtils.click(chkRegLink);
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewCheckRegisrtryBtn;

	//popup frame
	@FindBy(css="iframe[src*='CheckRequest.lvp']")
	private WebElement addCheckRequestFrame;

	
	//Add Check Request form elements
	
	@FindBy(id="Suppname")
	private WebElement suppNameTxtbox;

	
	@FindBy(id="Suppid")
	private WebElement suppIdTxtbox;
	
	

	@FindBy(id="auditId_chosen")
	private WebElement auditsList;
	
	@FindBy(css="#auditId_chosen input")
	private WebElement auditsSearchTxtBox;


	@FindBy(id="Checkno")
	private WebElement chkNumTxtbox;

	
	@FindBy(id="Cdate")
	private WebElement chkDateTxtbox;

	@FindBy(css="button[data-handler='today']")
	private WebElement selectTodaysDateBtn;
	
	@FindBy(id="Camount")
	private WebElement chkAmtTxtbox;

	
	@FindBy(id="Cdate")
	private WebElement chkExpDateTxtbox;

		
	public void selectChkExpDate(){
		lavanteUtils.fluentwait(chkExpDateTxtbox);
		lavanteUtils.selectDate("Any", chkExpDateTxtbox, selectTodaysDateBtn);
	}
	

	@FindBy(css="input[name='save']")
	private WebElement saveRegistryCheckBtn;
	
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement confirmPopupOkBtn;
	
	
	//Search Check Registry

	@FindBy(css="#searchSelectoption_chosen>a")
	private WebElement auditRegistrySearchTypeDDL;
	
	@FindBy(css="#searchSelectoption_chosen li")
	private List<WebElement> auditRegistrySearchTypeDDLOptions;
	
	@FindBy(id="searchtxt")
	private WebElement auditRegistrySearchTxtBox;
	
	@FindBy(id="search-users")
	private WebElement auditRegistrySearchBtn;
	
	@FindBy(css="#registry-list th")
	private WebElement auditCheckRegistryColNames;

	@FindBy(css="#registry-list td:nth-child(4)")
	private List<WebElement> auditCheckRegistrySuplierNameList;
	public List<WebElement> auditCheckRegistrySuplierNameList(){
		return auditCheckRegistrySuplierNameList;
	}
	
	@FindBy(css="#registry-list td:nth-child(8)")
	private List<WebElement> auditCheckRegistryCheckAmountList;
	public List<WebElement> auditCheckRegistryCheckAmountList(){
		return auditCheckRegistryCheckAmountList;
	}
	
	@FindBy(css="#registry-list td:nth-child(6)")
	private List<WebElement> auditCheckRegistryCheckNumList;
	public List<WebElement> auditCheckRegistryCheckNumList(){
		return auditCheckRegistryCheckAmountList;
	}	
	
	@FindBy(css="#registry-list tbody tr")
	private List<WebElement> auditCheckRegistryRows;
	public List<WebElement> auditCheckRegistryRows(){
		return auditCheckRegistryRows;
	}	
	
	@FindBy(css="#registry-list tbody tr td:nth-child(4)")
	private List<WebElement> auditCheckRegistrySuppNames;
	public List<WebElement> auditCheckRegistrySuppNames(){
		return auditCheckRegistrySuppNames;
	}
	
	@FindBy(css="#registry-list tbody tr td:nth-child(6)")
	private List<WebElement> auditCheckRegistryCheckNums;
	public List<WebElement> auditCheckRegistryCheckNums(){
		return auditCheckRegistryCheckNums;
	}

	@FindBy(css="#registry-list tbody tr td:nth-child(8)")
	private List<WebElement> auditCheckRegistryCheckAmounts;
	public List<WebElement> auditCheckRegistryCheckAmounts(){
		return auditCheckRegistryCheckAmounts;
	}

	//Edit Registry	
	@FindBy(css="a[href*='editCheckRequest.lvp']")
	private List<WebElement> auditCheckRegistryEditLinks;
	public List<WebElement> auditCheckRegistryEditLinks(){
		return auditCheckRegistryEditLinks;
	}
	
	//Edit popup frame
	
	@FindBy(css="iframe[src*='editCheckRequest.lvp']")
	private WebElement editCheckRequestFrame;

	
/*
	@FindBy(css="input[name='Cancel']")
	private WebElement cancelBtn;
	public WebElement cancelBtn(){
		return cancelBtn;
	}
*/	
	
	//Methods
	
	public void addRegistry(LinkedHashMap<String,String> dataMap){
		lavanteUtils.fluentwait(addNewCheckRegisrtryBtn);
		lavanteUtils.click(addNewCheckRegisrtryBtn);
		fillAddRegistry(dataMap);
		formAddRegistry(dataMap);
	}

	public void fillAddRegistry(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(addCheckRequestFrame);
		if(dataMap.containsKey("SupplierName")){
			String data=dataMap.get("SupplierName");
			lavanteUtils.typeString(data,suppNameTxtbox);
		}
		
		if(dataMap.containsKey("CheckNo")){
			String data=dataMap.get("CheckNo");
			lavanteUtils.typeString(data,chkNumTxtbox);
		}
		
		if(dataMap.containsKey("CheckDate")){
			String data=dataMap.get("CheckDate");
			
			lavanteUtils.fluentwait(chkDateTxtbox);
			lavanteUtils.click(chkDateTxtbox);
			if(data.equalsIgnoreCase("ANY")){
				lavanteUtils.fluentwait(selectTodaysDateBtn);
				lavanteUtils.click(selectTodaysDateBtn);
			}
		}
		
		if(dataMap.containsKey("CheckAmount")){
			String data=dataMap.get("CheckAmount");
			lavanteUtils.typeString(data,chkAmtTxtbox);
		}
		
	}

	public void formAddRegistry(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("SaveRegistry")){
			lavanteUtils.fluentwait(saveRegistryCheckBtn);
			lavanteUtils.click(saveRegistryCheckBtn);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(confirmPopupOkBtn);
			lavanteUtils.click(confirmPopupOkBtn);
			lavanteUtils.fluentwait(chkRegLink);
		}
	}
	
	//Method to search audit check registry
	public void searchRegistrty(LinkedHashMap<String, String> dataMap){
		
		
		String data="";

		if(dataMap.containsKey("SearchType")){
			data=dataMap.get("SearchType");
			lavanteUtils.fluentwait(auditRegistrySearchTypeDDL);
			lavanteUtils.waitForTime(10000);
			//lavanteUtils.click(auditRegistrySearchTypeDDL);
			auditRegistrySearchTypeDDL.click();
			lavanteUtils.fluentwait(auditRegistrySearchTypeDDLOptions.get(0));
			lavanteUtils.selectFrmDpdn(data);
		}
		if(dataMap.containsKey("SearchValue")){
			
			data=dataMap.get("SearchValue");
			lavanteUtils.fluentwait(auditRegistrySearchTxtBox);
			if(data.length()>0){
				lavanteUtils.typeString(data, auditRegistrySearchTxtBox);
			}
		}
		lavanteUtils.fluentwait(auditRegistrySearchBtn);
		lavanteUtils.click(auditRegistrySearchBtn);
		lavanteUtils.fluentwait(auditRegistrySearchBtn);
		//lavanteUtils.refreshPage();
		
		lavanteUtils.waitForTime(10000);
	}

}