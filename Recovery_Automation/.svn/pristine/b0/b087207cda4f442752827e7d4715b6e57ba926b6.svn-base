package com.lavante.recovery.pageobjects.configuration.Uploads;



import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

/**
 * Configuration->UploadsPage
 * @author girish.n
 *
 */
public class UploadsPage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public UploadsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	//Supplier Files Tabs
	@FindBy(css="a[href='#supplier_files']")
	private WebElement suppFilesTab;
	public WebElement suppFilesTab(){
		return suppFilesTab;
	}
	
	//Outreach Tabs
	@FindBy(css="a[href='#request_letter']")
	private WebElement outreachTab;
	public WebElement outreachTab(){
		return outreachTab;
	}

	//Credit Files Tabs
	@FindBy(css="a[href='#credit_files']")
	private WebElement credFilesTab;
	public WebElement credFilesTab(){
		return credFilesTab;
	}

	//Exchange Rate Files Tabs
	@FindBy(css="a[href='#exchangeRate_files']")
	private WebElement exRateFilesTab;
	public WebElement exRateFilesTab(){
		return exRateFilesTab;
	}

	//Upload Type DDL
	@FindBy(css="#fileType_chosen a")
	private WebElement uploadTypeDDL;
	public WebElement uploadTypeDDL(){
		return uploadTypeDDL;
	}	
	
	//Upload File Browse Button
	@FindBy(id="multipartFile")
	private WebElement browseBtn;
	public WebElement browseBtn(){
		return browseBtn;
	}
	
	//Outreach Type DDL
	@FindBy(css="#outreachType_chosen a")
	private WebElement outreachTypeDDL;
	public WebElement outreachTypeDDL(){
		return outreachTypeDDL;
	}
	
	//Outreach Type DDL
	@FindBy(css="#requestId_chosen a")
	private WebElement outreachDDL;
	public WebElement outreachDDL(){
		return outreachDDL;
	}
	
	//Outreach Audit DDL
	@FindBy(css="#auditsSelect_chosen a")
	private WebElement auditOutreachDDL;
	public WebElement auditOutreachDDL(){
		return auditOutreachDDL;
	}

	//Outreach Email Type DDL
	@FindBy(css="#templateId_chosen a")
	private WebElement emailTypeDDL;
	public WebElement emailTypeDDL(){
		return emailTypeDDL;
	}
	
	//Language DDL
	@FindBy(css="#language_chosen a")
	private WebElement langDDL;
	public WebElement langDDL(){
		return langDDL;
	}
	
	//Credit Audit DDL
	@FindBy(css="#creditAuditsSelect_chosen a")
	private WebElement auditCreditDDL;
	public WebElement auditCreditDDL(){
		return auditCreditDDL;
	}
	
	//Upload Button
	@FindBy(id="upload_button")
	private WebElement uploadBtn;
	public WebElement uploadBtn(){
		return uploadBtn;
	}
	
	//Refresh Buttons
	@FindBy(css="button[target='uploadedVMFFileDetails']")
	private WebElement refreshSuppFilesBtn;
	public WebElement refreshSuppFilesBtn(){
		return refreshSuppFilesBtn;
	}
		
	@FindBy(css="button[target='uploadedCreitFileDetails']")
	private WebElement refreshCredFilesBtn;
	public WebElement refreshCredFilesBtn(){
		return refreshCredFilesBtn;
	}
		
	@FindBy(css="button[target='uploadedRequestLetterDetails']")
	private WebElement refreshOutreachBtn;
	public WebElement refreshOutreachBtn(){
		return refreshOutreachBtn;
	}
		
	@FindBy(css="button[target='uploadedExchangeRateFileDetails']")
	private WebElement refreshExRatesFilesBtn;
	public WebElement refreshExRatesFilesBtn(){
		return refreshExRatesFilesBtn;
	}
			
	//Upload Files Frames
	@FindBy(css="iframe[src*='fileUploadDetails.lvp']")
	private WebElement frameSuppFiles;
	public WebElement frameSuppFiles(){
		return frameSuppFiles;
	}
	
	@FindBy(css="iframe[src*='requestLetterDetails.lvp']")
	private WebElement frameOutreach;
	public WebElement frameOutreach(){
		return frameOutreach;
	}
	
	@FindBy(css="iframe[src*='creditFileDetails.lvp']")
	private WebElement frameCredFiles;
	public WebElement frameCredFiles(){
		return frameCredFiles;
	}
	
	@FindBy(css="iframe[src*='exchangeRateHistory.lvp']")
	private WebElement frameExRatesFiles;
	public WebElement frameExRatesFiles(){
		return frameExRatesFiles;
	}
	
	//Supplier Files -> File Upload Details
	@FindBy(css="#batch-details td:nth-child(1)")
	private List<WebElement> suppFileNameList;
	public List<WebElement> suppFileNameList(){
		return suppFileNameList;
	}
	
	@FindBy(css="#batch-details td:nth-child(2)")
	private List<WebElement> suppUpldStatusList;
	public List<WebElement> suppUpldStatusList(){
		return suppUpldStatusList;
	}
	
	@FindBy(css="a[href*='showErrorLog.lvp']")
	private List<WebElement> suppFileProcessLogList;
	public List<WebElement> suppFileProcessLogList(){
		return suppFileProcessLogList;
	}
	
	//Outreach File Upload details
	@FindBy(css="#batch-details td:nth-child(1)")
	private List<WebElement> outreachAuditList;
	public List<WebElement> outreachAuditList(){
		return outreachAuditList;
	}
	
	@FindBy(css="#batch-details td:nth-child(2)")
	private List<WebElement> outreachFileNameList;
	public List<WebElement> outreachFileNameList(){
		return outreachFileNameList;
	}
	
	@FindBy(css="#batch-details td:nth-child(3)")
	private List<WebElement> outreachCategoryList;
	public List<WebElement> outreachCategoryList(){
		return outreachCategoryList;
	}
	
	@FindBy(css="#batch-details td:nth-child(4)")
	private List<WebElement> outreachTypeList;
	public List<WebElement> outreachTypeList(){
		return outreachTypeList;
	}
	
	@FindBy(css="#batch-details td:nth-child(5)")
	private List<WebElement> outreachEmailTemplateList;
	public List<WebElement> outreachEmailTemplateList(){
		return outreachEmailTemplateList;
	}
	
	@FindBy(css="#batch-details td:nth-child(6)")
	private List<WebElement> outreachLanguageList;
	public List<WebElement> outreachLanguageList(){
		return outreachLanguageList;
	}
	
	@FindBy(css="#batch-details td:nth-child(7)")
	private List<WebElement> outreachUpldStatusList;
	public List<WebElement> outreachUpldStatusList(){
		return outreachUpldStatusList;
	}
	
	@FindBy(css="a[href*='requestLetterPreview.lvp']")
	private List<WebElement> outreachPreviewLinkList;
	public List<WebElement> outreachPreviewLinkList(){
		return outreachPreviewLinkList;
	}
	
	@FindBy(css="a[href*='deleteRequestLetter.lvp']")
	private List<WebElement> outreachDeleteLinkList;
	public List<WebElement> outreachDeleteLinkList(){
		return outreachDeleteLinkList;
	}
	
	//Credit Files Upload details
	@FindBy(css="#batch-details td:nth-child(1)")
	private List<WebElement> credFileAuditList;
	public List<WebElement> credFileAuditList(){
		return credFileAuditList;
	}
	
	@FindBy(css="#batch-details td:nth-child(2)")
	private List<WebElement> credFileNameList;
	public List<WebElement> credFileNameList(){
		return credFileNameList;
	}
	
	@FindBy(css="#batch-details td:nth-child(3)")
	private List<WebElement> credFileUpldStatusList;
	public List<WebElement> credFileUpldStatusList(){
		return credFileUpldStatusList;
	}
	
	@FindBy(css="a[href*='showErrorLog.lvp']")
	private List<WebElement> credFileUpldProcessLogList;
	public List<WebElement> credFileUpldProcessLogList(){
		return credFileUpldProcessLogList;
	}
	
	//Exchange Rates Files Upload Details
	@FindBy(css="#batch-details td:nth-child(1)")
	private List<WebElement> exRateFileNameList;
	public List<WebElement> exRateFileNameList(){
		return exRateFileNameList;
	}
	
	@FindBy(css="#batch-details td:nth-child(2)")
	private List<WebElement> exRateFileUpldStatusList;
	public List<WebElement> exRateFileUpldStatusList(){
		return exRateFileUpldStatusList;
	}
	
	//OK Button
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement okBtn;
	public WebElement okBtn(){
		return okBtn;
	}
	
	//Upload File Method
	/**
	 * Method to upload file
	 * @author girish.n
	 * @param dataMap
	 */
	public void uploadFile(LinkedHashMap<String, String> dataMap){
		fillUploadFile(dataMap);
		formUploadFile(dataMap);
	
	}
	
	public void fillUploadFile(LinkedHashMap<String, String> dataMap){
		if(dataMap.containsKey("UploadType")){
			String data=dataMap.get("UploadType");
			lavanteUtils.fluentwait(uploadTypeDDL);
			lavanteUtils.click(uploadTypeDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(uploadTypeDDL);
		}
		if(dataMap.containsKey("OutreachType")){
			String data=dataMap.get("OutreachType");
			lavanteUtils.fluentwait(outreachTypeDDL);
			lavanteUtils.click(outreachTypeDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(outreachTypeDDL);
		}
		
		if(dataMap.containsKey("Outreach")){
			String data=dataMap.get("Outreach");
			lavanteUtils.fluentwait(outreachDDL);
			lavanteUtils.click(outreachDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(outreachDDL);
		}
		
		if(dataMap.containsKey("EmailType")){
			String data=dataMap.get("EmailType");
			lavanteUtils.fluentwait(emailTypeDDL);
			lavanteUtils.click(emailTypeDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(emailTypeDDL);
		}
		
		if(dataMap.containsKey("OutreachAudit")){
			String data=dataMap.get("OutreachAudit");
			lavanteUtils.fluentwait(auditOutreachDDL);
			lavanteUtils.click(auditOutreachDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(auditOutreachDDL);
		}
		
		if(dataMap.containsKey("CreditFileAudit")){
			String data=dataMap.get("CreditFileAudit");
			lavanteUtils.fluentwait(auditCreditDDL);
			lavanteUtils.click(auditCreditDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(auditCreditDDL);
		}
		
		if(dataMap.containsKey("Language")){
			String data=dataMap.get("Language");
			lavanteUtils.fluentwait(langDDL);
			lavanteUtils.click(langDDL);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectFrmDpdn(data);
			lavanteUtils.waitforPageload(langDDL);
		}
		
		if(dataMap.containsKey("UploadFile")){
			String data=dataMap.get("UploadFile");
			lavanteUtils.fluentwait(browseBtn);
			lavanteUtils.click(browseBtn);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.uploadFile(data);
			lavanteUtils.waitforPageload(browseBtn);
		}
	}
	
	public void formUploadFile(LinkedHashMap<String, String> dataMap){
		lavanteUtils.fluentwait(uploadBtn);
		lavanteUtils.click(uploadBtn);
		lavanteUtils.fluentwait(okBtn);
		lavanteUtils.click(okBtn);
		lavanteUtils.waitforPageload(uploadBtn);
	}
	
}
