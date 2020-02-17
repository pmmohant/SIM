/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Admin;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import com.lavante.sim.Common.Util.LavanteUtils;

public class ClaimTypePage {
		
	public LavanteUtils lavanteUtils=new LavanteUtils();
	
	public ClaimTypePage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	@FindBy(css="button[class*='add_Gl_codes']")
	private WebElement addGLCodeButton;
	public WebElement addGLCodeButton(){
		return addGLCodeButton;
	}
	
	@FindBy(css="button[class*='add_claim_type']")
	private WebElement addClaimType;
	public WebElement addClaimType(){
		return addClaimType;
	}
	
	@FindBy(css="input[id='claimType']")
	private WebElement searchTextbox;
	public WebElement searchTextbox(){
		return searchTextbox;
	}
	
	@FindBy(css="input[class*='button_primary']")
	private WebElement searchButton;
	public WebElement searchButton(){
		return searchButton;
	}
	
	@FindBy(id="dLabel")
	private WebElement actionsButton;
	public WebElement actionsButton(){
		return actionsButton;
	}

	@FindBy(css="a[href*='EditClaimType']")
	private WebElement editButton;
	public WebElement editButton(){
		return editButton;
	}
	
	@FindBy(css="a[href*='deleteClaimTyp']")
	private WebElement deleteButton;
	public WebElement deleteButton(){
		return deleteButton;
	}
	
	@FindBy(css="a[href*='activateDeactivate']")
	private WebElement Deactivatebtn;
	public WebElement Deactivatebtn(){
		return Deactivatebtn;
	}
	
	@FindBy(css="div[class*='ui-dialog-buttonset'] button[class*='button_primary']")
	private WebElement popupDeleteButton;
	public WebElement popupDeleteButton(){
		return popupDeleteButton;
	}
	
	@FindBy(id ="claimType")
	private WebElement claimTypeEditbox;
	public WebElement claimTypeEditbox(){
		return claimTypeEditbox;
	}
	
	@FindBy(id="#description")
	private WebElement description;
	public WebElement description(){
		return description;
	}
	
	@FindBy(css = "iframe[src*='addEditClaimType']")
	private WebElement IframeAddClaimType;
	public WebElement IframeAddClaimType(){
		
		return IframeAddClaimType;
	}
	
	
	@FindBy(css="button[class*='button_primary']")
	private WebElement saveButton;
    public WebElement saveButton(){
    	return saveButton;
    }
		
    @FindBy(css="button[title*='Cancel']")
    private WebElement cancelButton;
    public WebElement cancelButton(){
    	return cancelButton;
    }
	
	@FindBy(css = "table[class*='table_grid zebra'] tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement claimTypeValue;
	public WebElement claimTypeValue(){
		return claimTypeValue;
	}
    
	@FindBy(css="tr[class*='data_not_found'] td")
	private WebElement noResultsText;
	public WebElement noResultsText(){
		return noResultsText;
	}
	
	@FindBy(css = "tbody td:nth-child(1)")
	public List<WebElement> ListClaimTypeName;
	
	@FindBy(css = "tbody td:nth-child(3)")
	public List<WebElement> ListClaimTypeStatus;
	
	@FindBy(css = "span[class*='error']")
	public WebElement Errrmsg;
	
	@FindBy(css=".bannerMessage")
	private WebElement bannerMsg;
	public WebElement bannerMsg(){
		return bannerMsg;
	}
	
	@FindBy(css="select[class *='no-chosen'][data-filter-params]")
	private WebElement filterDropdown;
	public WebElement filterDropdown(){
		return filterDropdown;
	}
	
	
  public void addClaimType(LinkedHashMap<String, String> dataMap) {
		
		Reporter.log("Add ClaimType Mapping");
		clickAddClaimType();
		fillClaimtype(dataMap);
		formAction(dataMap);
	}
	
	private void clickAddClaimType() {
		lavanteUtils.click(addClaimType);
	}
	
	public void fillClaimtype(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IframeAddClaimType);
		lavanteUtils.fluentwait(claimTypeEditbox);
				
		if (dataMap.containsKey("ClaimType")) {
			String data = dataMap.get("ClaimType");
			claimTypeEditbox.clear();
			lavanteUtils.typeString(data,claimTypeEditbox);
		}
		if (dataMap.containsKey("ClaimType")) {
			String data = dataMap.get("ClaimType");
			claimTypeEditbox.clear();
			lavanteUtils.typeString(data,claimTypeEditbox);
		}
		
	}
	
	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IframeAddClaimType);
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(saveButton);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(searchTextbox);
			lavanteUtils.waitForTime(4000);
		}
		if(dataMap.containsKey("Cancel")) {
			lavanteUtils.click(cancelButton);
		}
			
	}
	
	public void searchClaimtype(LinkedHashMap<String, String> dataMap) throws IOException {
		String searchText="";
		lavanteUtils.switchtoFrame(null);
        if(dataMap.containsKey("SearchText")){
			searchText=dataMap.get("SearchText");
			lavanteUtils.fluentwait(searchTextbox);
			searchTextbox.clear();
			lavanteUtils.typeString(searchText, searchTextbox);
			lavanteUtils.click(searchButton);
			lavanteUtils.waitForTime(4000);
		}	
	}
	
	public void Actions(LinkedHashMap<String, String> dataMap) throws IOException {
	
		if(dataMap.containsKey("DeleteAction")){
			lavanteUtils.click(actionsButton);
			lavanteUtils.click(deleteButton);
			lavanteUtils.click(popupDeleteButton);
		}  
		if(dataMap.containsKey("EditAction")){
			lavanteUtils.click(actionsButton);
			lavanteUtils.click(editButton);
		} 
		if(dataMap.containsKey("Deactivate")){
			lavanteUtils.click(actionsButton);
			lavanteUtils.click(Deactivatebtn);
			lavanteUtils.waitForTime(4000);
		} 
	
	}
	
	/**
	 * 
	 * Use this Method for Sanity
	 * 
	 * @author Thejaswi.Bhat
	 * 
	 */
	public boolean verifyClaimTypePageIsDisplayed() {
		boolean flag=false;
		lavanteUtils.switchtoFrame(null);
		boolean flag1=lavanteUtils.verifyElementDisplayed("Add Claim Type", addClaimType);
		boolean flag2=lavanteUtils.verifyElementDisplayed("searchTxtBox", searchTextbox);
		boolean flag3=lavanteUtils.verifyElementDisplayed("searchBtn", searchButton);
		boolean flag4=lavanteUtils.verifyElementDisplayed("Filter Dropdown", filterDropdown);
		
		if(flag1 && flag2 && flag3 && flag4){
			flag=true;
		}
		return flag;
	}

}
	
    	
	