package com.lavante.sim.customer.pageobjects.Admin;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;


public class DealLocationMapping{
	
	LavanteUtils lavanteUtils = new LavanteUtils();

	public DealLocationMapping(WebDriver driver) {
		lavanteUtils.driver = driver;
		
	}
		
	/**
	 * 
	 * @author Thejaswi
	 */
	/**
	 * click on Admin -> DealLocationMapping
	 */
		@FindBy(css = "a[href*='dealLocationMapping']")
		private WebElement DealLocationMappingTab;
		public WebElement DealLocationMappingTab(){
			return DealLocationMappingTab ;
		
		}
				
		@FindBy(css = "button-group button[type='AddNew']")
		private WebElement AddDealLocationMapping;
		public WebElement AddDealLocationMapping(){
			return AddDealLocationMapping;
		}
		
		
		
		@FindBy(xpath = "//pop-up//label[contains(text(),'Division')]")
		private WebElement Divisiontxt;
		public WebElement Divisiontxt(){
			return Divisiontxt;
			
		}
		
		
				
		//Division search box
		////*[@id="addNew"]//div[2]//multi-select[1]//div[2]/button[contains(@class,'dropdown')]
		@FindBy(xpath = "//pop-up//label[contains(text(),'Division')]/../..//button[contains(class,'')]")
		private WebElement DivisionSelection;
		public WebElement DivisionSelection(){
			return DivisionSelection;
			
		}
		
		//Warehouse selection
		//@FindBy(css = "div[id*='claimTypes']>ul>li")
		
		@FindBy(xpath = "//pop-up//label[contains(text(),'Warehouse')]/../..//button[contains(class,'')]")
		private WebElement WarehouseSelection;
		public WebElement WarehouseSelection(){
			return WarehouseSelection;
		}
		
		//Deal Location field name in popup
		//@FindBy(css= "input[id*= 'inputData']")
		
		@FindBy(xpath = "//pop-up//label[contains(text(),'Deal Location')]/../..//input")
		private WebElement dealLocation;
		public WebElement dealLocation(){
			return dealLocation;
		}
		
		//edit popup save button
		@FindBy(css = "pop-up button[type*='Submit']")
		private WebElement popUpSaveButton;
		public WebElement popUpSaveButton(){
			return popUpSaveButton;
		}
		
		//edit popup save button
		
		@FindBy(css="pop-up button[class*='primary']")
		private WebElement editNewDeal;
		public WebElement editNewDeal(){
			return editNewDeal;
		}
		
		@FindBy(css="pop-up #addNew button[type*='Submit']")
		private WebElement addNewDeal;
		public WebElement addNewDeal(){
			return addNewDeal;
		}
		
		
		//editing dealLocation Field
		@FindBy(css="pop-up #editRow input[id *= 'input']")
		private WebElement editDealLocation;
		public WebElement editDealLocation(){
			return editDealLocation;
		}
		//cancel button
		@FindBy(css = "button[class*='cancel']")
		private WebElement CancelBtn;
		public WebElement CancelBtn(){
			return CancelBtn;
			
		}
		
		//delete icon
		@FindBy(css = "span[class *='delete']")
		private WebElement DeleteLink;
		public WebElement DeleteLink(){
			return DeleteLink;
			
		}
		
		//delete icon
		@FindBy(css = "div[class*='modal-footer ng-scope'] button[class*='primary']")
		private WebElement DeleteBtn;
		public WebElement DeleteBtn(){
		return DeleteBtn;
					
		}
		
		//edit 		
		@FindBy(css="span[class*='edit']")
		private WebElement editBtn;
		public WebElement editBtn(){
			return editBtn;
		}
		
		//search
		@FindBy(css = "button[class*= 'primary']")
		private WebElement searchBtn;
		public WebElement searchBtn(){
			return searchBtn;
		}
		
		
		@FindBy(css = "span[ng-bind*='error']")
		private WebElement Errormsg;
		public WebElement Errormsg(){
			return Errormsg;
		}
		
		//@FindBy(css = "div[class='bootstrap-wrapper bannerError']")
		@FindBy(id="bannerDiv")
		private WebElement BannerMessage;
		public WebElement BannerMessage(){
			return BannerMessage;
			
		}
		//Deal location text box basic search
		@FindBy(id = "dealLocation")
		private WebElement dealLocationTextBox;
		public WebElement dealLocationTextBox(){
			return dealLocationTextBox;
		}
		
		@FindBy(css = "span[ng-click='vm.closeBanner()']")
		private WebElement Bannerclose;
		public WebElement Bannerclose(){
			return Bannerclose;
		}
		
		
		@FindBy(css ="button[type*='reset']")
		private WebElement clearButton;
		public WebElement clearButton(){
			return clearButton;
		}
		
		
		@FindBy(css = "table[class*='table_grid zebra'] tbody td:nth-child(2) div")
		public List<WebElement> ListDivisionName;
		
		@FindBy(css = "table[class*='table_grid zebra'] tbody td:nth-child(3) div")
		public List<WebElement> ListWareHouseName;
		
		@FindBy(css = "table[class*='table_grid zebra'] tbody td:nth-child(4) div")
		public List<WebElement> ListDealLocationName;
		
		
		
		@FindBy(css = "span[class*='edit']")
		public List<WebElement> ListEditDealLocationMapping;
		
	
		@FindBy(css = "a[href*='delete']")
		public List<WebElement> ListDeleteDealLocationMapping;
		
		/**
		 * MethodName : AddClaimTypeMapping : will add claim type mapping 
		 * @param testData
		 *            : LinkedHashMap<String, String> testData
		 *            
		 * @author Thejaswi.Bhat
		 */

		public void AddDealLocationMapping(LinkedHashMap<String, String> testData) {
			
			Reporter.log("Add ClaimType Mapping");
			
			clickAddDealLocationMapping();
			fillDealLocationMapping(testData);
			formAction(testData);
		}
		
		private void clickAddDealLocationMapping() {
			lavanteUtils.clickJavaScript(AddDealLocationMapping);
		}
		
		public void fillDealLocationMapping(LinkedHashMap<String, String> testData) {
			String[] data = new String[6];
			lavanteUtils.fluentwait(dealLocation);
			
			if (testData.containsKey("Division")) {
				String org = testData.get("Division");
				lavanteUtils.click(DivisionSelection);
				data[1]=lavanteUtils.NwselectvalueFrmDpdnValue(org);
				testData.put("Division", data[1]);
				lavanteUtils.click(Divisiontxt);
			}
			
			if (testData.containsKey("Warehouse")) {
				String claimtype = testData.get("Warehouse");
				lavanteUtils.click(WarehouseSelection);
				data[1]=lavanteUtils.NwselectvalueFrmDpdnValue(claimtype);
				testData.put("WareHouse", data[1]);
				lavanteUtils.click(Divisiontxt);
			}
			if(testData.containsKey("DealLocation")){
				dealLocation.clear();
				lavanteUtils.typeinEdit(testData.get("DealLocation"), dealLocation);
				
			}
		
		}
		
		public void formAction(LinkedHashMap<String, String> testData) {
			
			if (testData.containsKey("EditSave")) {
				lavanteUtils.click(editNewDeal);
				lavanteUtils.switchtoFrame(null);
			}
			
			if(testData.containsKey("AddNew")){
				lavanteUtils.click(addNewDeal);
				lavanteUtils.switchtoFrame(null);
			}
			
			if(testData.containsKey("Cancel")) {
				lavanteUtils.click(CancelBtn);
				lavanteUtils.switchtoFrame(null);
			}
				
		}
		
		public void searchDealLocationMapping(LinkedHashMap<String, String> testData) throws IOException {
			String searchText="";
			lavanteUtils.switchtoFrame(null);

			if(testData.containsKey("dealLocation")){
				searchText=testData.get("dealLocation");
				lavanteUtils.fluentwait(dealLocationTextBox);
				dealLocationTextBox().clear();
				lavanteUtils.typeString(searchText, dealLocationTextBox );
				lavanteUtils.click(searchBtn);
				lavanteUtils.waitForTime(3000);
			}	
		}
			
		
		/*
		 * Thejaswi Bhat
		 Sanity
		 */
		
		//Sanity

		public boolean verifyDealLocationMappingSectionDisplayed() {
			boolean flag=false;
			lavanteUtils.switchtoFrame(null);
			boolean flag1=lavanteUtils.verifyElementDisplayed("AddDealLocation", AddDealLocationMapping);
			boolean flag2=lavanteUtils.verifyElementDisplayed("searchBtn", searchBtn);
			boolean flag3=lavanteUtils.verifyElementDisplayed("Clear Button", clearButton);
			
			if(flag1 && flag2 && flag3 ){
				flag=true;
			}
			return flag;
		}
		

	}
	

