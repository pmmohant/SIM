package lavante.recovery.pageobjects.Configuration.Uploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.Report;
import lavante.recovery.utilities.seleniumBaseClass;

public class UploadsPage extends seleniumBaseClass{
	
	//Configuration--Uploads Link
	@FindBy(css="a[title='Uploads']")
	private WebElement uploadsLink;
		
	public void verifyUploadsLink() {
		fluentwait(uploadsLink);
		click("uploadsLink",uploadsLink);
		getHttpResponse();
	}
			
	//Uploads--Upload Files table
	@FindBy(css="form[commandname='vFile']")
	private WebElement uploadFilesTable;
		
	public void verifyUploadFilesTable() {
		
		isDisplayed("uploadFilesTable",uploadFilesTable);
		verifyError(uploadFilesTable);
	}
	
	//Uploads--Templates table
	@FindBy(css="#customer-template tr")
	private WebElement templatesTable;
		
	public void verifyTemplatesTable() {
		
		isDisplayed("templatesTable",templatesTable);
		verifyError(templatesTable);
	}

	
	//Uploads--Supplier Files link
	@FindBy(css="a[href='#supplier_files']")
	private WebElement uploadSuppFilesLink;
		
	public void verifyuploadSuppFilesLink() {
		fluentwait(uploadSuppFilesLink);
		click("uploadSuppFilesLink",uploadSuppFilesLink);
	}
	
	//Uploads--Supplier Files table
	@FindBy(css="#batch-details tr td")
	private WebElement uploadSuppFilesTable;
		
	public void verifyUploadSuppFilesTable() {
		
		isDisplayed("uploadSuppFilesTable",uploadSuppFilesTable);
		verifyError(uploadSuppFilesTable);
	}
	
	//Uploads--Request Letter link
	@FindBy(css="a[href='#request_letter']")
	private WebElement uploadReqLetterLink;
		
	public void verifyUploadReqLetterLink() {
		fluentwait(uploadReqLetterLink);
		click("uploadReqLetterLink",uploadReqLetterLink);
	}
	
	//Uploads--Request Letter table
	@FindBy(css="#batch-details tr td")
	private WebElement uploadReqLetterTable;
		
	public void verifyUploadReqLetterTable() {
		
		isDisplayed("uploadReqLetterTable",uploadReqLetterTable);
		verifyError(uploadReqLetterTable);
	}
	
	//Uploads--Credit Files link
	@FindBy(css="a[href='#credit_files']")
	private WebElement uploadCreditFileLink;
		
	public void verifyuploadCreditFileLink() {
		fluentwait(uploadCreditFileLink);
		click("uploadCreditFileLink",uploadCreditFileLink);	
	}
	
	//Uploads--Credit Files table
	@FindBy(css="#batch-details tr td")
	private WebElement creditFilesTable;
		
	public void verifyCreditFilesTable() {
		
		isDisplayed("creditFilesTable",creditFilesTable);
		verifyError(creditFilesTable);
	}
	

	
	
	
}
