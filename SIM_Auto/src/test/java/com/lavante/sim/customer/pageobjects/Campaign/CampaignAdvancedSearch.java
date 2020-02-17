package com.lavante.sim.customer.pageobjects.Campaign;

import java.io.IOException;
import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.lavante.sim.Common.Util.LavanteUtils;

public class CampaignAdvancedSearch {
	LavanteUtils lavanteUtils = new LavanteUtils();

	WebDriver driver;

	public CampaignAdvancedSearch(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}
	
	@FindBy(id = "adv_search_tab")
	private WebElement AdvanceSearchTab;
	public WebElement AdvanceSearchTab() {
		return AdvanceSearchTab;
	}
	
	@FindBy(css = "button[href*='loadCampaignAdvanceSearch.lvp']")
	private WebElement BuildQueryBtn;
	public WebElement BuildQueryBtn() {
		return BuildQueryBtn;
	}
	
	@FindBy(css = "div[id='CampaignTypeID_chosen'] ul li input")
	private WebElement campaignTypeDrpdwn;
	public WebElement campaignTypeDrpdwn(){
		return campaignTypeDrpdwn;
	}
	
	@FindBy(css = "div[id='CampaignStatusID_chosen'] ul li")
	private WebElement campaignStatusDrpdwn;
	public WebElement campaignStatusDrpdwn(){
		return campaignStatusDrpdwn;
	}
	
	@FindBy(css = "iframe[src*='loadCampaignAdvanceSearch']")
	private WebElement IframeCampaignsAdvSearch;
	public WebElement IframeCampaignsAdvSearch() {
		return IframeCampaignsAdvSearch;
	}
	
	//Not used href becuase href is showing as blank
	@FindBy(id = "search_results")
	private WebElement IframeSearchResults;
	public WebElement IframeSearchResults(){
		return IframeSearchResults;
	}
	
	@FindBy(css = "input[class= 'button_secondary']")
	private WebElement search;
	public WebElement search(){
		return search;
	}
	
	@FindBy(id = "save")
	private WebElement saveQuery;
	public WebElement saveQuery(){
		return saveQuery;
	}
	
	@FindBy(css = "input[title='Save']")
	private WebElement editSaveQuery;
	public WebElement editSaveQuery(){
		return editSaveQuery;
	}
	
	@FindBy(css="div[class*='ui-dialog-content']")
	private WebElement alertText;
	public WebElement alertText(){
		return alertText;
	}
	
	@FindBy(css="div[class*='ui-dialog-buttonset'] span.ui-button-text")
	private WebElement alertOk;
	public WebElement alertOk(){
		return alertOk;
	}
	
	@FindBy(css="iframe[src*='loadAdvanceSavedSearch']")
	private WebElement iframeAdvancedSaveSearch;
	public WebElement iframeAdvancedSaveSearch(){
		return iframeAdvancedSaveSearch;
	}
	
    @FindBy(id = "specify_query")
	private WebElement specifyQuery;

	public WebElement specifyQuery() {
		return specifyQuery;
	}

	@FindBy(css = "input[title='Save']")
	private WebElement saveSpecifyQuery;

	public WebElement saveSpecifyQuery() {
		return saveSpecifyQuery;
	}
	
	@FindBy(css="button[class='button_primary']")
	private WebElement deleteButton;
	public WebElement deleteButton(){
		return deleteButton;
	}
	
	@FindBy(css="input[class='button_tertiary']")
	private WebElement clearButton;
	public WebElement clearButton(){
		return clearButton;
	}
	
	@FindBy(css="label[class='box-image']")
	private WebElement sharewithUsersChkbox;
	public WebElement sharewithUsersChkbox(){
		return sharewithUsersChkbox;
	}
	
	@FindBy(css="div[class*='bannerError']")
	private WebElement alertDuplicateText;
	public WebElement alertDuplicateText(){
		return alertDuplicateText;
	}

	public void AdvanceSearch(LinkedHashMap<String, String> dataMap) throws IOException {
		BuildQuery(dataMap);
		formActions(dataMap);
	}

    public void BuildQuery(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IframeCampaignsAdvSearch);
		if (dataMap.containsKey("CampaignType")) {
			lavanteUtils.click(campaignTypeDrpdwn);
			lavanteUtils.waitForTime(4000);
		    lavanteUtils.selectFrmDpdn(dataMap.get("CampaignType"));
			lavanteUtils.switchtoFrame(IframeCampaignsAdvSearch);
		}	
		
		if (dataMap.containsKey("CampaignStatus")) {
			lavanteUtils.click(campaignStatusDrpdwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("CampaignStatus"));
			lavanteUtils.switchtoFrame(IframeCampaignsAdvSearch);
		}
		
	}
		
	public void formActions(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IframeCampaignsAdvSearch());
		if (dataMap.containsKey("Search")) {
			lavanteUtils.click(search);
		}
		if (dataMap.containsKey("SaveQuery")) {
			lavanteUtils.switchtoFrame(IframeCampaignsAdvSearch());
			lavanteUtils.click(saveQuery);
			SaveQuery(dataMap);
		}
	
	}
	
	public void SaveQuery(LinkedHashMap<String, String> dataMap){
		lavanteUtils.switchtoFrame(iframeAdvancedSaveSearch);
		if (dataMap.containsKey("SpecifyQuery")) {
			String query = dataMap.get("SpecifyQuery");
	     	lavanteUtils.typeinEdit(query, specifyQuery);
		}
		
		if (dataMap.containsKey("SharewithUsers")) {
			lavanteUtils.click(sharewithUsersChkbox);
		}
	     	lavanteUtils.waitForTime(3000);
			lavanteUtils.clicks(saveSpecifyQuery);
		    lavanteUtils.waitForTime(5000);
		    lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(BuildQueryBtn);
		
	}
	
	public void savedQueryActions(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(BuildQueryBtn);
		if (dataMap.containsKey("DeleteQuery")) {
				String delete = "//*[contains(@title, '"+dataMap.get("SpecifyQuery") + "')]/../..//td[3]/a";
				boolean flag=lavanteUtils.isElementDisplayed(delete);
				if(flag){
					lavanteUtils.clicks(lavanteUtils.driver.findElement(By.xpath(delete)));
					lavanteUtils.fluentwait(deleteButton);
					lavanteUtils.click(deleteButton);
					lavanteUtils.fluentwait(BuildQueryBtn);
				}
		}
		if (dataMap.containsKey("RunQuery")) {
				lavanteUtils.fluentwait(BuildQueryBtn);
				String run = "//*[@title= '"+dataMap.get("SpecifyQuery") + "']/../..//td[4]/a";
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(run)));
				lavanteUtils.fluentwait(BuildQueryBtn);
		}
	    if (dataMap.containsKey("EditQuery")) {
	    	lavanteUtils.fluentwait(BuildQueryBtn);
	    	String edit = "//*[@title='"+dataMap.get("SpecifyQuery")+ "']/../td[2]/a";
	    	lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(edit)));
	    	lavanteUtils.fluentwait(BuildQueryBtn);	
	    }
	
	}
}
	

	