package com.lavante.sim.customer.pageobjects.Admin;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;


/**
 * Admin->Claim Resolution Page
 * @author girish.n
 *
 */
public class ClaimResolutionPage {

	LavanteUtils lavanteUtils=new LavanteUtils();

	public ClaimResolutionPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(css=".page-header")
	private WebElement pageHeader;
	public WebElement pageHeader(){
		return pageHeader;
	}
	
	@FindBy(css="button[class*='add_claimResolution']")
	private WebElement addClaimResolutionBtn;
	public WebElement addClaimResolutionBtn(){
		return addClaimResolutionBtn;
	}
	
	@FindBy(id="glCode")
	private WebElement searchTxtBox;
	public WebElement searchTxtBox(){
		return searchTxtBox;
	}
	
	@FindBy(id="searchGLCode")
	private WebElement searchBtn;
	public WebElement searchBtn(){
		return searchBtn;
	}
	
	
	@FindBy(css="input[name='add_input_paymentcentername']")
	private WebElement addClaimResReasonTxtBox;
	public WebElement addClaimResReasonTxtBox(){
		return addClaimResReasonTxtBox;
	}
	
	@FindBy(css="[id*='claim'] div[class*='save']")
	private WebElement saveIcon;
	public WebElement saveIcon(){
		return saveIcon;
	}
	
	@FindBy(css="a[href*='deleteClaimResolution.lvp']")
	private List<WebElement> deleteLinks;
	public List<WebElement> deleteLinks(){
		return deleteLinks;
	}
	
	@FindBy(css=".icon_edit")
	private List<WebElement> editLinks;
	public List<WebElement> editLinks(){
		return editLinks;
	}	
	
	@FindBy(css="tr[class='editMode'] input[editname='edit_input_paymentcentername']")
	private WebElement editClaimResReasonTxtBox;
	public WebElement editClaimResReasonTxtBox(){
		return editClaimResReasonTxtBox;
	}
	
	@FindBy(css="div[name='paymentcentername']")
	private List<WebElement> claimResReasonList;
	public List<WebElement> claimResReasonList(){
		return claimResReasonList;
	}
	
	@FindBy(css=".bannerMessage")
	private WebElement bannerMsg;
	public WebElement bannerMsg(){
		return bannerMsg;
	}
	
	@FindBy(css="div[class*='dialog'] button[class*='primary']")
	private WebElement deleteBtn;
	public WebElement deleteBtn(){
		return deleteBtn;
	}
	
	
	/**
	 * Method to add new Claim Resolution Reason
	 * @author girish.n
	 */
	
	public void addClaimResolution(LinkedHashMap<String, String> dataMap) throws IOException {
		ClickAddBtn(dataMap);
		fillClaimResReason(dataMap);
		formClaimResReason(dataMap);
			
	}

	private void ClickAddBtn(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("AddOrEdit")){
			if(dataMap.get("AddOrEdit").equalsIgnoreCase("Add")){
			lavanteUtils.click(addClaimResolutionBtn);
			}
		}
	}


	public void fillClaimResReason(LinkedHashMap<String, String> dataMap) {

		String data="";
		if(dataMap.containsKey("ClaimResReason")){
			data=dataMap.get("ClaimResReason");
			if(dataMap.containsKey("AddOrEdit")){
				if(dataMap.get("AddOrEdit").equalsIgnoreCase("Add")){
					addClaimResReasonTxtBox.clear();
					lavanteUtils.typeString(data,addClaimResReasonTxtBox);
				}
				else if(dataMap.get("AddOrEdit").equalsIgnoreCase("Edit")){
					editClaimResReasonTxtBox.clear();
					lavanteUtils.typeString(data,editClaimResReasonTxtBox);
				}
			}
		}
	}

	public void formClaimResReason(LinkedHashMap<String, String> dataMap) {

		if(dataMap.containsKey("Save")){
			lavanteUtils.fluentwait(saveIcon);
			lavanteUtils.click(saveIcon);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.waitforPageload(pageHeader);
		
		}
	}	
	
	/**
	 * Method to search claim resolution reason
	 * @author girish.n
	 * @param dataMap
	 * @throws IOException
	 */
	public void searchClaimResReason(LinkedHashMap<String, String> dataMap) throws IOException {
	
		String searchText="";
		if(dataMap.containsKey("SearchText")){
			searchText=dataMap.get("SearchText");
			lavanteUtils.fluentwait(searchTxtBox);
			lavanteUtils.click(searchTxtBox);
			searchTxtBox.clear();
			lavanteUtils.typeString( searchText, searchTxtBox);
			lavanteUtils.fluentwait(searchBtn);
			lavanteUtils.click(searchBtn);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.waitforPageload(pageHeader);
		}	
	}
	
	/**
	 * 
	 * Use this Method for Sanity
	 * 
	 * @author Thejaswi.Bhat
	 * 
	 */
	public boolean verifyClaimResolutionIsDisplayed() {
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(null);
		boolean flag1=lavanteUtils.verifyElementDisplayed("Add Claim Resolution", addClaimResolutionBtn);
		boolean flag2=lavanteUtils.verifyElementDisplayed("searchTxtBox", searchTxtBox);
		boolean flag3=lavanteUtils.verifyElementDisplayed("searchBtn", searchBtn);
		
		if(flag1 && flag2 && flag3){
			flag=true;
		}
		return flag;
		
	}
	
	}
