package com.lavante.recovery.pageobjects;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.lavante.recovery.Common.Util.LavanteUtils;


public class ConfigurationMailerRegistryPage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;
	public ConfigurationMailerRegistryPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	
	
	//Configuration link
	//@FindBy(linkText= "Configuration")
	@FindBy(css="a[href*='configuration.lvp']")
	private WebElement configurationLink;
	public WebElement configurationLink(){
		return configurationLink;
	}
		
	//Mailer Registry link
	//@FindBy(css="a[href='/recovery/mailerRegistry.lvp']")
	@FindBy(linkText= "Mailer Registry")
	private WebElement mailerRegistryLink;
	public WebElement mailerRegistryLink(){
	return mailerRegistryLink;
		}
		
	@FindBy(css="input[name='search']")
	private WebElement searchByAuditNameTextbox;
	public WebElement searchByAuditNameTextbox(){
		return searchByAuditNameTextbox;
	}
	
	
	@FindBy(name ="search_users")
	private WebElement searchButton;
	public WebElement searchButton(){
		return searchButton;
	}
	
	@FindBy(id="deposit")
	private WebElement deposit;
	public WebElement deposit(){
		return deposit;
	}
	
	
	@FindBy(id="balance")
	private WebElement balance;
	public WebElement balance(){
		return balance;
		
		}
	
	@FindBy(css="thead tr th:nth-child(1)")
	private WebElement auditNameH;
	public WebElement auditNameH(){						//H- stands for header
		return auditNameH;
	}
	
	
	@FindBy(css="thead tr th:nth-child(2)")
	private WebElement sIMH;
	public WebElement sIMH(){
		return sIMH;
	}
	
	@FindBy(css="thead tr th:nth-child(3)")
	private WebElement dateMailedH;
	public WebElement dateMailedH(){
		return dateMailedH;
	}
	
	
	@FindBy(css="thead tr th:nth-child(4)")
	private WebElement lavQtyH;
	public WebElement lavQtyH(){
		return lavQtyH;
	}
	
	@FindBy(css="thead tr th:nth-child(5)")
	private WebElement pmpQtyH;
	public WebElement pmpQtyH(){
		return pmpQtyH;
	}
	
	
	@FindBy(css="thead tr th:nth-child(6)")
	private WebElement taxH;
	public WebElement taxH(){
		return taxH;
	}
	
	@FindBy(css="thead tr th:nth-child(7)")
	private WebElement totalH;
	public WebElement totalH(){
		return totalH;
	}
	
	@FindBy(css="thead tr th:nth-child(8)")
	private WebElement uspsTotalH;
	public WebElement uspsTotalH(){
		return uspsTotalH;
	}
	
	
	@FindBy(css="thead tr th:nth-child(9)")
	private WebElement amtPerPieceH;
	public WebElement amtPerPieceH(){
		return amtPerPieceH;
	}
	
	@FindBy(css="thead tr th:nth-child(10)")
	private WebElement actionH;
	public WebElement actionH(){
		return actionH;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement auditNameV;				// V stands for value
	public WebElement auditNameV(){
		return auditNameV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(2)")
	private WebElement sIMV;
	public WebElement sImV(){
		return sIMV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(3)")
	private WebElement dateMailedV;
	public WebElement dateMailedV(){
		return dateMailedV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(4)")
	private WebElement lavQtyV;
	public WebElement lavQtyV(){
		return lavQtyV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(5)")
	private WebElement pmpQtyV;
	public WebElement pmpQtyV(){
		return pmpQtyV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(6)")
	private WebElement taxV;
	public WebElement taxV(){
		return taxV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(7)")
	private WebElement totalV;
	public WebElement totalV(){
		return totalV;
	}
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(8)")
	private WebElement uspsTotalV;
	public WebElement uspsTotalV(){
		return uspsTotalV;
	}
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td:nth-child(9)")
	private WebElement amtPerPieceV;
	public WebElement amtPerPieceV(){
		return lavQtyV;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td a:nth-child(1)")
	private WebElement actionEditIcon;
	public WebElement actionEditIcon(){
		return actionEditIcon;
	}
	
	
	@FindBy(css="table[id='registry-list'] tbody tr:nth-child(1) td a:nth-child(2)")
	private WebElement actionDeleteIcon;
	public WebElement actionDeleteIcon(){
		return actionDeleteIcon;
	}
	
	
	@FindBy(id="addNew")
	private WebElement addNewButton;
	public WebElement addNewButton(){
		return addNewButton;
	}
	
	//@FindBy(id="auditId_chosen")
	@FindBy(css="a[class='chosen-single']")
	private WebElement auditName;
	public WebElement auditName(){
		return auditName;
	}
	
	
	@FindBy(id="simcheck")
	private WebElement simCheckbox;
	public WebElement simCheckbox(){
		return simCheckbox;
	}
	
	@FindBy(id="maildate")
	private WebElement dateMailed;
	public WebElement dateMailed(){
		return dateMailed;
	}
	
	@FindBy(css="button[data-handler*='today']")
	private WebElement dateMailedToday;
	public WebElement dateMailedToday(){
		return dateMailedToday;
	}
	
	@FindBy(name="mailQty")
	private WebElement lavQty;
	public WebElement lavQty(){
		return lavQty;
	}
	
	
	@FindBy(id="pmpQty")
	private WebElement pmpQty;
	public WebElement pmpQty(){
		return pmpQty;
	}
	
	
	@FindBy(id="mailertax")
	private WebElement tax;
	public WebElement tax(){
		return tax;
	}
	
	@FindBy(id="mailertotal")
	private WebElement total;
	public WebElement total(){
		return total;
	}
	
	
	@FindBy(id="maileruspcs")
	private WebElement uspsTotal;
	public WebElement uspsTotal(){
		return uspsTotal;
	}
	
	@FindBy(name="save")
	private WebElement addButton;
	public WebElement addButton(){
		return addButton;
	}
	
	@FindBy(name = "Cancel")
	private WebElement cancelButton;
	public WebElement cancelButton(){
		return cancelButton;
	}
	
	
	@FindBy(css="iframe[src*='/addMailerRegistry.lvp']")
	private WebElement addNewRegistryFrame;
	public WebElement addNewRegistryFrame(){
		return addNewRegistryFrame;
	}
	
	
	@FindBy(css="#auditId_chosen input")
	private WebElement auditNameTextbox;
	public WebElement auditNameTextbox(){
		return auditNameTextbox;
	}
	
	//LinkedHashMap<String, String> dataMap1 = new LinkedHashMap<String, String>();
	//dataMap1.put("invoiceNumber","08/09/17*LP10091" );
	
	//waitForTime(6000);
	//invoicePage.InvoiceFilling(dataMap1);
	//public void InvoiceFilling(LinkedHashMap<String,String> dataMap) throws InterruptedException{
	//fillInvoice(dataMap);
	//}
	
	
	
	public void AddMailerRegistry(LinkedHashMap<String,String> dataMap) throws InterruptedException{
		clickMailerRegistry();
		fillMailerReg(dataMap);
		formAction(dataMap);
	}

	


	public void clickMailerRegistry() throws InterruptedException {
		lavanteUtils.click(addNewButton);
			
		
	}


	public void fillMailerReg(LinkedHashMap<String, String> dataMap) throws InterruptedException {
		lavanteUtils.switchtoFrame(addNewRegistryFrame());
		if(dataMap.containsKey("AuditName")){
			String data=dataMap.get("AuditName");
			lavanteUtils.click(auditName);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(auditNameTextbox);
			lavanteUtils.typeString(dataMap.get("AuditName"),auditNameTextbox);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.switchtoFrame(addNewRegistryFrame());
	
		}
		if(dataMap.containsKey("DateMailed")){
			//lavanteUtils.typeString(dataMap.get("DateMailed"),dateMailed);
			lavanteUtils.click(dateMailed);
			lavanteUtils.click(dateMailedToday);
			lavanteUtils.waitForTime(3000);
		}
		
		if(dataMap.containsKey("LAVQty")){
			lavanteUtils.waitForTime(3000);
			lavanteUtils.typeString(dataMap.get("LAVQty"),lavQty);
		}
		
		if(dataMap.containsKey("PMPQty")){
			lavanteUtils.typeString(dataMap.get("PMPQty"),pmpQty);
		}
		
		if(dataMap.containsKey("USPSTotal")){
			lavanteUtils.typeString(dataMap.get("USPSTotal"),uspsTotal1);
		}
		
			
	}

		private void formAction(LinkedHashMap<String, String> dataMap) {
			if(dataMap.containsKey("SaveRegistry")){
				lavanteUtils.click(addButton);
				lavanteUtils.waitForTime(6000);
				lavanteUtils.click(okConfirmationButton);
			}
			
		}
		
		@FindBy(id="maileruspcs")
		private WebElement uspsTotal1;
		public WebElement uspsTotal1(){
			return uspsTotal1;
		}
		
		@FindBy(css="button[class='button_green'] span")
		private WebElement okConfirmationButton;
		public WebElement okConfirmationButton(){
			return okConfirmationButton;
		}
		
		
		@FindBy(name="search")
		private WebElement searchTextbox;
		public WebElement searchTextbox(){
			return searchTextbox;
		}
		
		@FindBy(name="search_users")
		private WebElement searchButtonfield;
		public WebElement searchButtonfield(){
			return searchButtonfield;
		}
		
		
		@FindBy(id="registry-list")
		private WebElement auditTable;
		public WebElement auditTable(){
			return auditTable;
		}
		
		
		@FindBy(css="#registry-list tbody tr td:nth-child(1)")
		private List<WebElement> auditNameValues;
		public List<WebElement> auditNameValues(){
			return auditNameValues;
		}
		
		@FindBy(css="#registry-list tbody tr td:nth-child(3)")
		private List<WebElement> dateMailedValues;
		public List<WebElement> dateMailedValues(){
			return dateMailedValues;
		}
		
		@FindBy(css="#registry-list tbody tr td:nth-child(4)")
		private List<WebElement> lavQtyValues;
		public List<WebElement> lavQtyValues(){
			return lavQtyValues;
		}
		
		@FindBy(css="#registry-list tbody tr td:nth-child(5)")
		private List<WebElement> pmpQtyValues;
		public List<WebElement> pmpQtyValues(){
			return pmpQtyValues;
		}
		
		@FindBy(css="#registry-list tbody tr td:nth-child(8)")
		private List<WebElement> uspsTotalValues;
		public List<WebElement> uspsTotalValues(){
			return uspsTotalValues;
		}
		
		public void SearchRegistry(LinkedHashMap<String, String> dataMap) throws InterruptedException {
			lavanteUtils.switchtoFrame(null);
			if(dataMap.containsKey("SearchByAuditName")){
				lavanteUtils.typeString(dataMap.get("SearchByAuditName"),searchByAuditNameTextbox);
			}

			lavanteUtils.click(searchButtonfield);
		}
		
}