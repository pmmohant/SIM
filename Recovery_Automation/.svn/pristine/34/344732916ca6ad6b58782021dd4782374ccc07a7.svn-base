package com.lavante.recovery.pageobjects.configuration.OutReach;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

public class OutReachPage {
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver = null;

	public OutReachPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	// Outreach Setup Tab
	@FindBy(css = "a[href='outreachSetup.lvp']")
	private WebElement outreachSetupTab;

	public WebElement outreachSetupTab() {
		return outreachSetupTab;
	}

	// Outreach Statistic Tab
	@FindBy(css = "a[href*='FaxStatistic']")
	private WebElement outreachStatisticTab;

	public WebElement outreachStatisticTab() {
		return outreachStatisticTab;
	}

	// Outreach sequence
	@FindBy(css = "[id='user-list'] tbody td:nth-child(1)")
	private List<WebElement> outreachSequence;

	public List<WebElement> outreachSequence() {
		return outreachSequence;
	}

	// Outreach Type
	@FindBy(css = "[id='user-list'] tbody td:nth-child(2)")
	private List<WebElement> outreachType;

	public List<WebElement> outreachType() {
		return outreachType;
	}

	// Wait days
	@FindBy(css = "[id='user-list'] tbody td:nth-child(3)")
	private List<WebElement> waitDays;

	public List<WebElement> waitDays() {
		return waitDays;
	}

	// Email template
	@FindBy(css = "[id='user-list'] tbody td:nth-child(4)")
	private List<WebElement> emailTemplate;

	public List<WebElement> emailTemplate() {
		return emailTemplate;
	}

	// Category
	@FindBy(css = "[id='user-list'] tbody td:nth-child(5)")
	private List<WebElement> category;

	public List<WebElement> category() {
		return category;
	}

	// Rank Cut off
	@FindBy(css = "[id='user-list'] tbody td:nth-child(6)")
	private List<WebElement> rankCutOff;

	public List<WebElement> rankCutOff() {
		return rankCutOff;
	}

	// Edit Outreach Action
	@FindBy(css = "a[href*='editOutreachSetup']")
	private List<WebElement> editAction;

	public List<WebElement> editAction() {
		return editAction;
	}

	// Delete Outreach Action
	@FindBy(id = "deleteOutreach")
	private List<WebElement> deleteAction;

	public List<WebElement> deleteAction() {
		return deleteAction;
	}
	
	// Start Outreach Button
	@FindBy(id = "startOutreach")
	private WebElement startOutreachBtn;

	public WebElement startOutreachBtn() {
		return startOutreachBtn;
	}

	// AddNew Button
	@FindBy(id = "addNew")
	private WebElement addNewBtn;

	public WebElement addNewBtn() {
		return addNewBtn;
	}
		
	// IFRAME
	@FindBy(css = "iframe[src*='OutreachSetup']")
	private WebElement IFRAMEOutreachSetup;
	public WebElement IFRAMEOutreachSetup() {
		return IFRAMEOutreachSetup;
	}	
		
	// Outreach type DDL
	@FindBy(css = "[id*='outReachTypeId'] a")
	private WebElement outreachTypeDDL;

	public WebElement outreachTypeDDL() {
		return outreachTypeDDL;
	}
	
	// Outreach type DDL Values
	@FindBy(css = "[id*='outReachTypeId'] li")
	private List<WebElement> outreachTypeDDLOptions;

	public List<WebElement> outreachTypeDDLOptions() {
		return outreachTypeDDLOptions;
	}

	// Outreach Sequence DDL
	@FindBy(css="[id*='outreachSequence'] a")
	private WebElement outreachSequenceDDL;

	public WebElement outreachSequenceDDL() {
		return outreachSequenceDDL;
	}

	// Outreach Sequence DDL options
	@FindBy(css = "[id*='outreachSequence'] li")
	private List<WebElement> outreachSequenceDDLOptions;

	public List<WebElement> outreachSequenceDDLOptions() {
		return outreachSequenceDDLOptions;
	}

	// Category DDL
	@FindBy(css = "[id*='requestId'] a")
	private WebElement categoryDDL;

	public WebElement categoryDDL() {
		return categoryDDL;
	}

	// Category DDL options
	@FindBy(css = "[id*='requestId'] li")
	private List<WebElement> categoryDDLOptions;

	public List<WebElement> categoryDDLOptions() {
		return categoryDDLOptions;
	}

	// Email Template DDL
	@FindBy(css = "[id*='templateId'] a")
	private WebElement emailTemplateDDL;

	public WebElement emailTemplateDDL() {
		return emailTemplateDDL;
	}

	// Email Template DDL options
	@FindBy(css = "[id*='templateId'] li")
	private List<WebElement> emailTemplateDDLOptions;

	public List<WebElement> emailTemplateDDLOptions() {
		return emailTemplateDDLOptions;
	}

	// RankCut off DDL
	@FindBy(id = "rankCutOff")
	private WebElement rankCutOffDDL;

	public WebElement rankCutOffDDL() {
		return rankCutOffDDL;
	}

	// Wait days DDL
	@FindBy(id = "waitdays")
	private WebElement waitdaysDDL;

	public WebElement waitdaysDDL() {
		return waitdaysDDL;
	}
	
	// Save button in the frame
	@FindBy(css = "input[name='save']")
	private WebElement saveBtn;

	public WebElement saveBtn() {
		return saveBtn;
	}

	// Cancel button in the frame
	@FindBy(css = "input[name='Cancel']")
	private WebElement cancelBtn;

	public WebElement cancelBtn() {
		return cancelBtn;
	}
	
	// Accept success or failure message dialog box
	@FindBy(css = "div[style*='bloc'] button[class*='button_green']")
	private WebElement OkbtnOutReach;

	public WebElement OkbtnOutReach() {
		return OkbtnOutReach;
	}

	/******************** Methods  ********************/

	public void addNewOutReach(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(addNewBtn);
		lavanteUtils.click(addNewBtn);
		fillOutReach(dataMap);
		formOutReach(dataMap);		
	}


	public void formOutReach(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(saveBtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OkbtnOutReach); 
		}
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.click(cancelBtn);
			lavanteUtils.switchtoFrame(null);
		}
	}

	public void fillOutReach(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEOutreachSetup);
		if (dataMap.containsKey("OutReachType")) {
			String data=dataMap.get("OutReachType");
			lavanteUtils.fluentwait(outreachTypeDDL);
			//lavanteUtils.waitForTime(10000);	
			lavanteUtils.click(outreachTypeDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(outreachTypeDDLOptions.get(0));
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEOutreachSetup);
		}		
		if (dataMap.containsKey("OutReachSequence")) {
			String data=dataMap.get("OutReachSequence");
			lavanteUtils.fluentwait(outreachSequenceDDL);
			//lavanteUtils.waitForTime(10000);	
			lavanteUtils.click(outreachSequenceDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(outreachSequenceDDLOptions.get(0));
			lavanteUtils.selectFrmDpdn(data);	
			lavanteUtils.switchtoFrame(IFRAMEOutreachSetup);
			
		}		
		if (dataMap.containsKey("Category")) {
			String data=dataMap.get("Category");
			lavanteUtils.fluentwait(categoryDDL);
			//lavanteUtils.waitForTime(10000);
			lavanteUtils.click(categoryDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(categoryDDLOptions.get(0));
			lavanteUtils.selectFrmDpdn(data);			
			lavanteUtils.switchtoFrame(IFRAMEOutreachSetup);
		}		
		if (dataMap.containsKey("EmailTemplate") && dataMap.containsKey("OutReachType")) {
			if (!dataMap.get("OutReachType").equalsIgnoreCase("Fax")) {
			String data=dataMap.get("EmailTemplate");
			lavanteUtils.fluentwait(emailTemplateDDL);
			//lavanteUtils.waitForTime(10000);
			lavanteUtils.click(emailTemplateDDL);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(emailTemplateDDLOptions.get(0));
			lavanteUtils.selectFrmDpdn(data);			
			lavanteUtils.switchtoFrame(IFRAMEOutreachSetup);		
		}
		}
		if (dataMap.containsKey("RankCutOFf")) {
			lavanteUtils.typeString(dataMap.get("RankCutOFf"), rankCutOffDDL);
		}		
		if (dataMap.containsKey("WaitDays")) {
			lavanteUtils.typeString(dataMap.get("WaitDays"), waitdaysDDL);
		}
	}	
}
