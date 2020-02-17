package com.lavante.recovery.pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.recovery.Common.Util.LavanteUtils;


public class HomePage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;
	public HomePage(WebDriver drivers) {
		lavanteUtils.driver = drivers;
		driver=lavanteUtils.driver;
	}

	
	@FindBy(how=How.CSS,using="[href*='logout']")
	private WebElement logoutbtn;
	
	@FindBy(id="frmQuickSearch")
	private WebElement quickSearch_Form;
	
	
	@FindBy(css="#audit_chosen a div")
	private WebElement auditSelectbox;

	@FindBy(css="[id*='audit'] input[type='text']")
	private WebElement auditdrpDownTextBox;

	//Audit Drop down list
	@FindBy(css="#audit")
	private WebElement auditList;

	//Audit Tab
	@FindBy(css="a[title='Audit']")
	private WebElement auditTab;
	
	public void verifyAuditTab() {	
		auditTab.click();
		  
	}
	
	
	//Click on audit drop down list
	@FindBy(css="[id='audit_chosen'] a[class='chosen-single']")
	private WebElement auditDropDownList;
	
	public void verifyAuditList() {	
		auditDropDownList.click();
		  
	}
	
	//Inbound Tab
	@FindBy(css="a[title='Inbound']")
	private WebElement inboundLandingPage;
	
	public void verifyInboundTab() {	
		inboundLandingPage.click();
		  
	}
    //Configuration Tab
	@FindBy(css="a[title='Configuration']")
	private WebElement configurationTab;
	
	public void configurationTab() {	
		configurationTab.click();
		  
	}
	//Quick Search -> Added by Girish Umesh Naik
	@FindBy(css="#searchSelect_chosen>a")
	private WebElement quickSearchDDL;
	
	@FindBy(id="searchText")
	private WebElement quickSrchTxtBox;
	
	@FindBy(id="searchButton")
	private WebElement quickSrchBtn;	
	
	
	//Methods Starts
	
	/**
	 * Selection of Audit 
	 * 
	 * @author Piramanayagam.S
	 * @param expAudit
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void SelectAudit(String expAudit) throws FileNotFoundException, IOException {
		
		verifyHomePageDisplayed();
		lavanteUtils.fluentwait(auditSelectbox);
		
		if(expAudit.length()>0){
			lavanteUtils.click(auditSelectbox);
			if(expAudit.equalsIgnoreCase("ANY")){
				expAudit=lavanteUtils.InitProperties("DefaultAudit");
				expAudit=expAudit.trim();
			}
			lavanteUtils.fluentwait(auditdrpDownTextBox);
			lavanteUtils.typeinEdit(expAudit,auditdrpDownTextBox);
			lavanteUtils.selectvalueFrmDpdn(expAudit);
			lavanteUtils.waitforPageload(auditSelectbox);
			lavanteUtils.fluentwait(auditSelectbox);
		}
	}
	

	public void verifyHomePageDisplayed() {
		lavanteUtils.fluentwait(quickSearch_Form);
		lavanteUtils.isElementDisplayed(quickSearch_Form);
		 verifyBrowserStartPopUp();
	}
	
	public void verifyBrowserStartPopUp() {
		lavanteUtils.fluentwait(quickSearchDDL);
		 List<WebElement> popUp = lavanteUtils.driver.findElements(By.cssSelector("div[style*='block'] [title*='close']"));
		 lavanteUtils.waitForTime(3000);
		 if(popUp.size() > 0){
			 lavanteUtils.click(popUp.get(0));
		 }	
		 
		 else
			lavanteUtils.waitForTime(3000);
	}
	
	
	/**
	 * Quick Search Method works on all pages
	 * 
	 * @author Girish.N
	 */
	public void quickSearch(LinkedHashMap<String, String> dataMap) {
		String data="";

		if(dataMap.containsKey("SearchType")){
			data=dataMap.get("SearchType");
			lavanteUtils.fluentwait(quickSearchDDL);
		//	lavanteUtils.waitForTime(10000);
			lavanteUtils.fluentwait(quickSearchDDL);
			lavanteUtils.click(quickSearchDDL);
			lavanteUtils.waitForTime(2000);
			lavanteUtils.selectFrmDpdn(data);
		}
		if(dataMap.containsKey("SearchValue")){
			
			data=dataMap.get("SearchValue");
			lavanteUtils.fluentwait(quickSrchTxtBox);
			if(data.length()>0){
				lavanteUtils.typeString(data, quickSrchTxtBox);
			}
		}
		lavanteUtils.fluentwait(quickSrchBtn);
		lavanteUtils.click(quickSrchBtn);
		lavanteUtils.waitForTime(10000);
		
	}
	
	/**
	 * Select Tab for navigation on multiple tabs
	 * @author Piramanaygam S
	 * @param dataMap
	 */
	public void selectTab(LinkedHashMap<String, String> dataMap) {
		  lavanteUtils.switchtoFrame(null);
		  if(dataMap.containsKey("subtab")){
		   String url=driver.getCurrentUrl();
		   if(!url.contains(dataMap.get("subtab"))){
		    if (dataMap.containsKey("maintab")) {
		     String main = "[id*='main'] [href*='" + dataMap.get("maintab").toString() + "']";
		     WebElement e=driver.findElement(By.cssSelector(main));
		     lavanteUtils.waitforPageload(e);
		     lavanteUtils.fluentwait(e);
		     lavanteUtils.click(e);
		    }
		    lavanteUtils.waitForTime(4000);
		    if (dataMap.containsKey("subtab")) {
		     lavanteUtils.waitForTime(3000);
		     String sub = "[id*='sub'] [href*='" + dataMap.get("subtab").toString() + ".lvp']";
		     WebElement e=driver.findElement(By.cssSelector(sub));
		     lavanteUtils.waitforPageload(e);
		     lavanteUtils.fluentwait(e);
		     lavanteUtils.click(e);
		    }
		    lavanteUtils.waitForTime(4000);
		   }
		  }else {
		   if (dataMap.containsKey("maintab")) {
		    String main = "[id*='main'] [href*='" + dataMap.get("maintab").toString() + "']";
		    WebElement e=driver.findElement(By.cssSelector(main));
		    lavanteUtils.waitforPageload(e);
		    lavanteUtils.fluentwait(e);
		    lavanteUtils.click(e);
		   }
		   lavanteUtils.waitForTime(4000);
		  }
		  System.out.println("SELECTED TAB");
	}
	
	/**
	 * Logout Application
	 * 
	 * @author Piramanayagam.S
	 */
	public void logout() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(logoutbtn);
		lavanteUtils.click(logoutbtn);

	}
	
	
}
