package lavante.recovery.pageobjects.Configuration.Uploads;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.Report;
import lavante.recovery.utilities.seleniumBaseClass;
import lavante.recovery.pageobjects.GenericPageObjects;

public class UploadsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public UploadsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Configuration--Uploads Link
	@FindBy(css="a[title='Uploads']")
	private WebElement uploadsLink;
	public WebElement uploadsLink(){				//added by Ramya
		return uploadsLink;
	}
		
	public void verifyUploadsLink() {
		
		lavanteUtils.click("uploadsLink",uploadsLink);
	}
			
	//Uploads--Upload Files table
	@FindBy(css="form[commandname='vFile']")
	private WebElement uploadFilesTable;
	public WebElement uploadFilesTable(){			//added by Ramya
		return uploadFilesTable;
	}
		
	public void verifyUploadFilesTable() {
		
		lavanteUtils.isDisplayed("uploadFilesTable",uploadFilesTable);
		lavanteUtils.verifyError(uploadFilesTable);
	}
	
	//Uploads--Templates table
	@FindBy(css="#customer-template tr")
	private WebElement templatesTable;
	public WebElement templatesTable(){				//added by Ramya
		return templatesTable;
	}
		
	public void verifyTemplatesTable() {
		
		lavanteUtils.isDisplayed("templatesTable",templatesTable);
		lavanteUtils.verifyError(templatesTable);
	}

	
	//Uploads--Supplier Files link
	@FindBy(css="a[href='#supplier_files']")
	private WebElement uploadSuppFilesLink;
	public WebElement uploadSuppFilesLink(){		//added by Ramya
		return uploadSuppFilesLink;
	}
		
	public void verifyuploadSuppFilesLink() {
		
		lavanteUtils.click("uploadSuppFilesLink",uploadSuppFilesLink);
		lavanteUtils.fluentwait(uploadSuppFilesLink);
	}
	
	//Uploads--Supplier Files table
	//@FindBy(css="#batch-details tr td")
	@FindBy(css="#supplier_files tr td")			//added by Ramya
	private WebElement uploadSuppFilesTable;
	public WebElement uploadSuppFilesTable(){		//added by Ramya
		return uploadSuppFilesTable;
	}
		
	public void verifyUploadSuppFilesTable() {
		
		lavanteUtils.isDisplayed("uploadSuppFilesTable",uploadSuppFilesTable);
		lavanteUtils.verifyError(uploadSuppFilesTable);
	}
	
	//Uploads--Request Letter link
	@FindBy(css="a[href='#request_letter']")
	private WebElement uploadReqLetterLink;
	public WebElement uploadReqLetterLink(){		//added by Ramya
		return uploadReqLetterLink;
	}
		
	public void verifyUploadReqLetterLink() {
		lavanteUtils.fluentwait(uploadReqLetterLink);
		lavanteUtils.click("uploadReqLetterLink",uploadReqLetterLink);
	}
	
	//Uploads--Request Letter table
	//@FindBy(css="#batch-details tr td")
	@FindBy(css="#request_letter tr td")
	private WebElement uploadReqLetterTable;
	public WebElement uploadReqLetterTable(){		//added by Ramya
		return uploadReqLetterTable;
	}
		
	public void verifyUploadReqLetterTable() {
		
		lavanteUtils.isDisplayed("uploadReqLetterTable",uploadReqLetterTable);
		lavanteUtils.verifyError(uploadReqLetterTable);
	}
	
	//Uploads--Credit Files link
	@FindBy(css="a[href='#credit_files']")
	private WebElement uploadCreditFileLink;
	public WebElement uploadCreditFileLink(){		//added by Ramya
		return uploadCreditFileLink;
	}
		
	public void verifyuploadCreditFileLink() {
		
		lavanteUtils.click("uploadCreditFileLink",uploadCreditFileLink);	
	}
	
	//Uploads--Credit Files table
	//@FindBy(css="#batch-details tr td")
	@FindBy(css="#credit_files tr td")				//added by Ramya
	private WebElement creditFilesTable;
	public WebElement creditFilesTable(){			// added by Ramya
		return creditFilesTable;
	}
	
	
	//Uploads-Exchange Rate Files 
	
	@FindBy(css="a[href='#exchangeRate_files']")	//added by Ramya
	private WebElement exchangeRateFileLink;
	public WebElement exchangeRateFileLink(){
		return exchangeRateFileLink;
	}
	
	@FindBy(css="#exchangeRate_files tr td")			//added by Ramya
	private WebElement exchangeRateFilesTable;
	public WebElement exchangeRateFilesTable(){
		return exchangeRateFilesTable;
	}
		
	public void verifyCreditFilesTable() {
		
		lavanteUtils.isDisplayed("creditFilesTable",creditFilesTable);
		lavanteUtils.verifyError(creditFilesTable);
	}
	
	//Uploads--Doc types selection
	@FindBy(css="#fileType_chosen a")
	private WebElement docTypeSelection;
	
	//Uploads--Browse button
	@FindBy(css="#multipartFile")
	private WebElement browseBtn;
	
	//Uploads--Audit selection
	@FindBy(css="#creditAuditsSelect_chosen a")
	private WebElement auditSelect;
	
	//Uploads--Audit selection text box
	@FindBy(css="#creditAuditsSelect_chosen input")
	private WebElement auditSelecttxtbox;
	
	//Uploads--Upload button
	@FindBy(css="#upload_button")
	private WebElement uploadBtn;
	
	//Uploads--Upload button message
	@FindBy(css=".ui-dialog-buttons div:nth-child(2)")
	private WebElement uploadMsg;
	
	//Save button After change - pop up -OK Button
	@FindBy(css="[class*='dialog'] [class*='green']")
	private WebElement popupOKBtn;
	
	//Save button
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;

	//IFRAME- Credit File
	@FindBy(css="iframe[src*='creditFileDetails']")
	private WebElement iFrameCreditFile;
	
	//Credit File Entry
	@FindBy(css="#batch-details tr:nth-child(1) td")
	private List <WebElement> newCreditFile;
	
	//Credit File Refresh button
	@FindBy(css="#credit_files button")
	private WebElement creditFileRefreshBtn;
	public WebElement creditFileRefreshBtn(){			//added by Ramya
		return creditFileRefreshBtn;
	}
	
	//Credit File process Log
	@FindBy(css="#batch-details tr:nth-child(1) td:nth-child(8) a")
	private WebElement fileProcessLog;
	
	//Credit File process Log -IFRAME
	@FindBy(css="iframe[src*='showErrorLog']")
	private WebElement iFrameProcessLog;
	
	//Credit File process Log -IFRAME-Inside msg
	@FindBy(css=".data_table tr td")
	private WebElement iFrameProcessLogMsg;
	
	//Process Log pop up close button
	@FindBy(css="button[title='close'] span:nth-child(2)")
	private WebElement ProcessLogCloseBtn;
	
	//All images browse buttons
	@FindBy(css="input[type='file']")
	private List <WebElement> imageUpload;
	
	//All uploaded images
	@FindBy(css="img[src*='repoimages']")
	private List <WebElement> uploadedImages;
	
	//LogOut
	@FindBy(linkText="Logout")
	private WebElement logout;

	String uploadMessage = "";
	
	public void selectCreditFile() throws IOException{
		verifyUploadsLink();
		lavanteUtils.waitForTime(3000);
		verifyuploadCreditFileLink();
		lavanteUtils.waitForTime(3000);
		docTypeSelection.click();
		lavanteUtils.selectvalueFromDropdown("Add Credit File");	
		
		lavanteUtils.waitForTime(2000);
		auditSelect.click();
		lavanteUtils.enterText("auditSelecttxtbox",auditSelecttxtbox,"Cemex");
		lavanteUtils.ActionsTextBox(auditSelecttxtbox);
		lavanteUtils.waitForTime(2000);
		browseBtn.click();
		String presentWorkingDir = lavanteUtils.getPresentWorkingDir();
		System.out.println(presentWorkingDir);

		lavanteUtils.uploadFile(presentWorkingDir + "\\2_testing.txt");
		lavanteUtils.waitForTime(3000);
		uploadBtn.click();
		lavanteUtils.waitForTime(3000);
		 uploadMessage = uploadMsg.getText().toString();
		
		if(uploadMessage.equalsIgnoreCase("File uploaded successfully")){
			Reporter.log("File uploaded successfully");
			System.out.println("File uploaded successfully");
		}
		
		else{
			System.out.println("Error in uploading file");
			Reporter.log("Error in uploading file");
			Assert.assertTrue(false, "Error in uploading file");
		}
		
		lavanteUtils.ActionsforSingleClick(popupOKBtn);
	}
	
	public void verifyImagesUpload() throws IOException{
		lavanteUtils.scrollToBottom(driver);
		
		for(int i = 0; i<imageUpload.size(); i++){
			imageUpload.get(i).click();
			String presentWorkingDir = lavanteUtils.getPresentWorkingDir();
			System.out.println(presentWorkingDir);
			
			lavanteUtils.uploadFile(presentWorkingDir + "\\RequestLetterLogo.jpg");
		}
		saveBtn.click();
		
		uploadMessage = uploadMsg.getText().toString();
		
 		if(uploadMessage.equalsIgnoreCase("Updated Successfully")){
 			Reporter.log("Updated Successfully");
 			System.out.println("Updated Successfully");
 		}

 		else{
 			System.out.println("Error in uploading file");
 			Reporter.log("Error in uploading file");
 			Assert.assertTrue(false, "Error in uploading file");
 		}
		
 		lavanteUtils.ActionsforSingleClick(popupOKBtn);
 		lavanteUtils.waitForTime(5000);
		
				if(uploadedImages.size() ==4){
					System.out.println("All images have been uploaded");
					Reporter.log("All images have been uploaded");
				}
		
				else{
					System.out.println("Error in uploading images");
					Reporter.log("Error in uploading images");
					Assert.assertTrue(false, "Error in uploading images");
				}
	 
	}
	
	public void validtionPostFileUpload(){
		lavanteUtils.switchtoFrame(iFrameCreditFile);
		
		for(int count=0; count<= newCreditFile.size();count ++){
			String audit = newCreditFile.get(0).getText().toString();
			String filename = newCreditFile.get(1).getText().toString();
			String uploadedStatusbeforeProcessing = newCreditFile.get(2).getText().toString();

			if(audit.equalsIgnoreCase("Humana")){
				if(filename.equalsIgnoreCase("2_testing.txt")){
					System.out.println(uploadedStatusbeforeProcessing);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.waitForTime(40000);
					lavanteUtils.click(creditFileRefreshBtn);
					System.out.println("refresh clicked");
					
					lavanteUtils.switchtoFrame(iFrameCreditFile);
					String uploadedStatusafterProcessing = newCreditFile.get(2).getText().toString();

					System.out.println(uploadedStatusafterProcessing);
					
					lavanteUtils.waitForTime(2000);
					
					if(uploadedStatusafterProcessing.equalsIgnoreCase("Upload Process Completed")||uploadedStatusafterProcessing.equalsIgnoreCase("Upload in Progress")){
						lavanteUtils.click(fileProcessLog);
						
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.waitForTime(3000);
						lavanteUtils.switchtoFrame(iFrameProcessLog);
						String processLogMsg = iFrameProcessLogMsg.getText().toString();
						System.out.println(processLogMsg);
						
							if(processLogMsg.equalsIgnoreCase("No Data Available")){
								System.out.println("File has been processed successfully");
								Reporter.log("File has been processed successfully");
								lavanteUtils.switchtoFrame(null);
								lavanteUtils.click(ProcessLogCloseBtn);
								lavanteUtils.Scrollintoview(logout);
								lavanteUtils.click(logout);
							}
							
							else{
								System.out.println("File procesisng failed with errors : " + processLogMsg);
								Reporter.log("File procesisng failed with errors : " + processLogMsg);
								lavanteUtils.click(ProcessLogCloseBtn);
								lavanteUtils.Scrollintoview(logout);
								lavanteUtils.click(logout);
								Assert.assertTrue(false, "File procesisng failed with errors : " + processLogMsg);
							}
						
					}
					else{
						Reporter.log("Delay in processing file, please look for background jobs");
						Assert.assertTrue(false, "Delay in processing file, please look for background jobs");
					}
				}
			}
		}
		
	}
	
}
