package lavante.recovery.pageobjects.Audit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import lavante.recovery.utilities.LavanteUtils;
import lavante.recovery.utilities.seleniumBaseClass;

public class AuditContactEntryPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditContactEntryPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	
	//Contact Entry Link
	@FindBy(css="[href*='dataentry']")
	private WebElement contactEntry;
	private WebElement contactEntryLink;
	public WebElement contactEntry(){    //added by Ramya
		return contactEntry;
	}
	
	@FindBy(id="ui-id-1")
	private List<WebElement> ValidateSupplier;
	public List<WebElement> ValidateSupplier(){    //added by Ramya
		return ValidateSupplier;
	}
	
	public void verifycontactEntry() {
	
		lavanteUtils.click("contactEntry",contactEntry);
		lavanteUtils.fluentwait(contactEntry);
	}

	//Document Queue table
	@FindBy(css="#supplier-queue-table tr ")
	private WebElement docQueueTable;
	public WebElement docQueueTable(){       //added by Ramya
		return docQueueTable;
	}
	
	public void verifydocQueueTable() {
	
		lavanteUtils.isDisplayed("docQueueTable",docQueueTable);
		lavanteUtils.verifyError(docQueueTable);	
	}
	
	//Fix OCR button
	@FindBy(css=".button_blue.fix-ocr-save")
	private WebElement fixOCRBtn;
	
	public void contactEntryFixOCRBtn() {
		lavanteUtils.click("fixOCRBtn",fixOCRBtn);
	}
	
	//Supplier Details table
	@FindBy(css="#dataPageSupplierDetails tr")
	private WebElement supDetailsTable;
	public WebElement supDetailsTable(){      //added by Ramya
		return supDetailsTable;
	}
	
	public void verifysupDetailsTable() {
	
		lavanteUtils.isDisplayed("supDetailsTable",supDetailsTable);
		lavanteUtils.verifyError(supDetailsTable);	
	}
	
	//Validate supplier pop up
	@FindBy(css=".validateUID td label")
	private WebElement validateSupplierPopUp;
	
	//Document details pdf frame
	@FindBy(css="#document-details #pdf-iframe")
	private WebElement docDetails;
	
	public void verifydocDetails() {
	
		lavanteUtils.isDisplayed("docDetails",docDetails);
		lavanteUtils.verifyError(docDetails);	
	}
	
	//Validate supplier text box
	@FindBy(css="#validate-lavanteuid")
	private WebElement validateSuppliertxtbox;
	
	//Validate Button in Validate supplier pop up
	@FindBy(css="input[value='Validate']")
	private WebElement validateSupplierBtn;
	
	//Fix OCR supp name text box
	@FindBy(css="input[id='fix-ocr-sup-name']")
	private WebElement fixOCRsuppName;
	private WebElement fixOCRsuppName1;
	public WebElement fixOCRsuppName1(){
		return fixOCRsuppName1;
	}
	
	public void fixOCRsuppName() {
		Actions act = new Actions(driver);
		if(validateSupplierPopUp.isDisplayed()){
			act.moveToElement(validateSuppliertxtbox);
			act.click().build().perform();
			act.sendKeys(Keys.ESCAPE).build().perform();
			lavanteUtils.waitForTime(2000);
			act.moveToElement(fixOCRsuppName);
			act.click().build().perform();
			lavanteUtils.waitForTime(2000);
			lavanteUtils.enterText("fixOCRsuppName", fixOCRsuppName, "ABC");
		}
		else{
			act.moveToElement(fixOCRsuppName);
			act.click().build().perform();
			lavanteUtils.waitForTime(2000);
			lavanteUtils.enterText("fixOCRsuppName", fixOCRsuppName, "ABC");
		}
	}
	

	
	@FindBy(css="button[href*='supplierLookup']")
	private WebElement suppLookUpbtn;
	public WebElement suppLookUpbtn1(){         //added by Ramya
		return suppLookUpbtn;
	}
	
	public void suppLookUpbtn() {
		lavanteUtils.click("suppLookUpbtn", suppLookUpbtn);
	}
	
	//Supp Details--Sup Name
	@FindBy(css="td[ng-bind*='supplierName']")
	private WebElement suppDetailsSuppName;
	public WebElement suppDetailsSuppName(){	//added by Ramya
		return suppDetailsSuppName;
	}

	
	//Supp Details--Contact Name
	@FindBy(css="input[ng-model*='contactName']")
	private WebElement suppDetailsContactName;
	public WebElement suppDetailsContactName(){    //added by Ramya
		return suppDetailsContactName;
	}
	
	//Supp Details--Contact Phone
	@FindBy(css="input[ng-model*='contactPhone']")
	private WebElement suppDetailsContactPhone;
	public WebElement suppDetailsContactPhone(){   //added by Ramya
		return suppDetailsContactPhone;
	}
	
	//Supp Details--E-mail
	@FindBy(css="input[ng-model*='email']")
	private WebElement suppDetailscontactEmail;
	public WebElement suppDetailscontactEmail(){   //added by Ramya
		return suppDetailscontactEmail;
	}
	
	//Supp Details--Contact Fax
	@FindBy(css="input[ng-model*='contactFax']")
	private WebElement suppDetailsContactFax;
	public WebElement suppDetailsContactFax(){     //added by Ramya
		return suppDetailsContactFax;
	}
	

	//Doc Queue--Sup Name
	@FindBy(css="#queue-navigation tr:nth-child(1) td:nth-child(1)")
	private WebElement docQueueSuppName;
	public WebElement docQueueSuppName(){         //added by Ramya
		return docQueueSuppName;
	}
	
	//Save button
	@FindBy(css="#save-button")              
	private WebElement saveBtn;
	public WebElement saveBtn(){			      // added by Ramya
		return saveBtn;
		
	}
	
	//Next button
	@FindBy(css="#next-button")
	private WebElement nextBtn;
	public WebElement nextBtn(){				 // added by Ramya
		return nextBtn;
	}
	
	//Previous button
	@FindBy(css="#previous-button")
	private WebElement previousBtn;
	public WebElement previousBtn(){             // added by Ramya
		return previousBtn;
		
	}
	
	//Save button After change - pop up -OK Button
	@FindBy(css="[class*='dialog'] [class*='green']")
	private WebElement popupOKBtn;
	
	//Save and Dispose button
	@FindBy(css="#save-dispose-button")
	private WebElement saveAndDisposeBtn;
	public WebElement saveAndDisposeBtn(){        // added by Ramya
		return saveAndDisposeBtn;
	}
	
	//Review button
	@FindBy(css="#need-review-button")
	private WebElement reviewBtn;
	public WebElement reviewBtn(){				 // added by Ramya
		return reviewBtn;
	}
	
	//Review comment text box
	@FindBy(css="#needs-review-comment-textarea")  //added by Ramya
	private WebElement commentTxtBox;
	public WebElement commentTxtBox(){
		return commentTxtBox;
		
	}
	
	
	//Review pop up IFRAME
	@FindBy(css="iframe[data-iname*='awaitingResponsePopup']")
	private WebElement awaitingResponsepopUp;
	
	public void contactEntryProcess(){
		fixOCRsuppName();
	}
	
	public void verifySuppNameUpdated(){
		
		String suppDetailsinSuppName = suppDetailsSuppName.getAttribute("value").toString();
		String docSupName = docQueueSuppName.getAttribute("value").toString();
		
		System.out.println(suppDetailsinSuppName  + "," + docSupName);
		
		if(suppDetailsinSuppName.equalsIgnoreCase(docSupName)){
			System.out.println("Supp detailed updated");
			Reporter.log("Supp detailed updated");
		}
		
		else
			Assert.assertTrue(false, "Unable to update supplier details");
	}
	
	Random rn = new Random();
	int nextInt = rn.nextInt(999);
	String email = "SUPP" + nextInt + "@" + "SUPP" + nextInt + ".com";
	
	public void updateContactDetails(LinkedHashMap<String, String> dataMap){
		
		if(dataMap.containsKey("ContactName")){
			suppDetailsContactName.sendKeys(dataMap.get("ContactName") + nextInt);
		}
		
		if(dataMap.containsKey("ContactPhone")){
			suppDetailsContactPhone.sendKeys(dataMap.get("ContactPhone") + nextInt);
		}
		
		if(dataMap.containsKey("Email")){
			suppDetailscontactEmail.sendKeys(dataMap.get("Email") + email);
		}
		
		if(dataMap.containsKey("ContactFax")){
			suppDetailsContactFax.sendKeys(dataMap.get("Email"));
		}
	}

	
	public void profileAction(LinkedHashMap<String, String> dataMap){
		
/*		if(nextBtn.getAttribute("disabled").toString().equals("disabled")){
			if(previousBtn.getAttribute("disabled").toString().equals("disabled")){
				
			}
		}*/

		if(dataMap.containsKey("Save")){
			lavanteUtils.scrollToBottom(driver);
			lavanteUtils.waitForTime(5000);
			  saveBtn.click();
			  
			  lavanteUtils.ActionsforSingleClick(popupOKBtn);
			  lavanteUtils.waitForTime(5000);

        /*	  supNameBeforeChange = suppName.getAttribute("value").toString();
        	  
     		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
     			 System.out.println("Suplier details are updated with with Save button");
     			 Reporter.log("Suplier details are updated with with Save button");
     		 }
     		 
     		 else{
     			System.out.println("Suplier details are NOT updated with with Save button");
     			 Reporter.log("Suplier details are NOT updated with with Save button");
     			 Assert.assertTrue(false, "Suplier details are NOT updated with with Save button");
     		 } */
			
			
		}
		
		if(dataMap.containsKey("Save & Dispose")){
			saveAndDisposeBtn.click();
		}
	
		if(dataMap.containsKey("Review")){
			reviewBtn.click();
			lavanteUtils.scrollToBottom(driver);
			lavanteUtils.waitForTime(5000);
        	reviewBtn.click();
        	lavanteUtils.fluentwait(reviewBtn);
        	  
        	lavanteUtils.ActionsforSingleClick(popupOKBtn);
        	  
        	lavanteUtils.switchtoFrame(awaitingResponsepopUp);
        	commentTxtBox.sendKeys("Testing comment for review");
        	saveBtn.click(); 
        	lavanteUtils.switchtoFrame(null);
        	lavanteUtils.waitForTime(5000);
        	
        	if(suppDetailsSuppName.getAttribute("value").toString().equalsIgnoreCase(docQueueSuppName.getAttribute("value").toString()))
        		Reporter.log("Supplier details updated");
			}
			else{
				Reporter.log("Supplier details NOT updated");
				Assert.assertTrue(false, "Supplier details NOT updated");
			}
			
	
		if(dataMap.containsKey("Previous")){
			updateContactDetails(dataMap);
			saveBtn.click();
		}
		
		if(dataMap.containsKey("Next")){
			updateContactDetails(dataMap);
			lavanteUtils.scrollToBottom(driver);
			lavanteUtils.waitForTime(5000);
        	 nextBtn.click();
        	 
        	 lavanteUtils.ActionsforSingleClick(popupOKBtn);
      	   	  
     	  	  if(validateSupplierPopUp.isDisplayed()){
     	  		validateSupplierPopUp.click();
     	  		lavanteUtils.waitForTime(5000);
     	  	  }

   		  previousBtn.click();
 
   		lavanteUtils.waitForTime(5000);
		}
	}

}
