package lavante.recovery.pageobjects.Audit;

import org.testng.Assert;
import org.testng.AssertJUnit;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


//import com.sun.glass.events.KeyEvent;



import lavante.recovery.utilities.seleniumBaseClass;
import lavante.recovery.utilities.LavanteUtils;

public class AuditInboundPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public AuditInboundPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	//Inbound Link
	@FindBy(linkText="Inbound")
	private WebElement inboundLink;
	public WebElement inboundLink(){  //added by Ramya
		return inboundLink;
	}
	
	public void verifyinboundLink() {
		lavanteUtils.fluentwait(inboundLink);
		lavanteUtils.click("inboundLink",inboundLink);
		lavanteUtils.isDisplayed("inboundLink",inboundLink);
		lavanteUtils.verifyError(inboundLink);	
	}

	//Inbounding Document Statistics table
	@FindBy(css="#inboundDocumentStatistics tr")
	private WebElement inboundDocumentStatistics;
	
	//Incoming Document Statistics table						//added by Ramya
		//@FindBy(css="#incomingDocumentStatistics tr")
		@FindBy(css="td:nth-child(1) >div:nth-child(1)")
		private WebElement incomingDocumentStatistics;
		public WebElement incomingDocumentStatistics(){
			return incomingDocumentStatistics;
		}
		
	
	
	public void verifyinboundDocumentStatistics() {
	
		lavanteUtils.isDisplayed("inboundDocumentStatistics",inboundDocumentStatistics);
		lavanteUtils.verifyError(inboundDocumentStatistics);	
	}
	
	
	@FindBy(css=".ui-dialog-titlebar")
	private WebElement FixOCRPopUp;
	public void FixOCRPopUp() {
		lavanteUtils. fluentwait(FixOCRPopUp);
		lavanteUtils.click("FixOCRPopUp",FixOCRPopUp);
		  selVerififrmDocType();
		  FixOCRwithSupplier();
		  SuppLookUpBtn();
		  
		  SuppLookUpAfterLoad();
		  selectSuppFromSuppList();
		  SelectBtninIFRAME();
		  fixOCRBtn();
	}
	
	//Select fax type
	@FindBy(css=".dashboard-subtab a")
	private List <WebElement> selFax;
	
	//Select Verification from drop down list in FIX OCR
	@FindBy(css="#fixocr-doctype-select option[value='2']")
	private WebElement selVerififrmDocType;
	public void selVerififrmDocType() {
		lavanteUtils.ExplicitWaitforelements(selVerififrmDocType);
		Actions act= new Actions(driver);
		act.moveToElement(selVerififrmDocType);
		act.click().build().perform();
	}
	
	//Selecting Verification from drop down for FIX OCR
	@FindBy(css="#fixocr-doctype-select")
	private WebElement FixOCRDocType;
	public void selectFixOCRDocType() {
		lavanteUtils.waitForTime(5000);
		lavanteUtils.click("FixOCRDocType",FixOCRDocType);
		lavanteUtils.selectByText("Verification",FixOCRDocType);
	}
	
	//Supplier Name in Supplier LookUp 
	@FindBy(css="#supplier-lookup-input")
	private WebElement suppLookUpwithSupplierName;
	public void FixOCRwithSupplier() {
		lavanteUtils.fluentwait(suppLookUpwithSupplierName);
		lavanteUtils.enterText("suppLookUpwithSupplierName", suppLookUpwithSupplierName, "AB");
	}
	
	//Supplier LookUp pop up --Supplier Name Search
	@FindBy(css="#txtSearchVendorName")
	private WebElement SuppNameinSuppLookUpPopUp;
	
	//Supplier Queue--Supplier Name
	@FindBy(css="#queue-navigation tr:nth-child(1) td:nth-child(1)")
	private WebElement suppNameinQueueDetails;

	//Supplier LookUp IFrame --Supplier List
	@FindBy(css="iframe[src*='supplierLookup']")
	private WebElement SuppLookUpAfterLoad;
	public void SuppLookUpAfterLoad() {
		lavanteUtils.switchtoFrame(SuppLookUpAfterLoad);	
	}
	
	//Select 1st supplier from supplier list After supplier lookup
	@FindBy(css="#supplierDetailsTable tr:nth-child(1) input")
	private WebElement selectSuppFromSuppList;
	public void selectSuppFromSuppList() {
		lavanteUtils.click("selectSuppFromSuppList",selectSuppFromSuppList);
	}

	//Click on Supplier Lookup button
	@FindBy(css="#popup-supplier-lookup-button")
	private WebElement SuppLookUpBtn;
	public void SuppLookUpBtn() {

		lavanteUtils.click("SuppLookUpBtn",SuppLookUpBtn);
		
	}
	
	
	//Click on Fix OCR button
	@FindBy(css="#fix-ocr")
	private WebElement fixOCRBtn;
	public void fixOCRBtn() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(fixOCRBtn);
		lavanteUtils.click("fixOCRBtn",fixOCRBtn);	
	}

	//Select supplier Button from supplier list After selecting supplier from supplier list
	@FindBy(css="#select-supplier")
	private WebElement clickonSelectBtn;
	public void SelectBtninIFRAME() {
		lavanteUtils.click("clickonSelectBtn",clickonSelectBtn);
	}

	//Document Summary
	@FindBy(css="#inboundDocumentSummary tr")
	private WebElement inboundDocumentSummary;
	public WebElement inboundDocumentSummary(){      //added by Ramya
		return inboundDocumentSummary;
	}
	
	public void verifyinboundDocumentSummary() {
	
		lavanteUtils.isDisplayed("inboundDocumentSummary",inboundDocumentSummary);
		lavanteUtils.verifyError(inboundDocumentSummary);	
	}
	
	//Recognized Fax
	@FindBy(id="recognized")
	private WebElement recognizedfax;
	public WebElement recognizedfax(){               //added by Ramya
		return recognizedfax;
	}
	
	//Recognized fax table
	@FindBy(css="#inbound-dashboard table")
	private WebElement recognizedfaxTable;
	public WebElement recognizedfaxTable(){               //added by Ramya
		return recognizedfaxTable;
	}
	
	
	public void RecognizedFax() {
		lavanteUtils.fluentwait(recognizedfax);
		lavanteUtils.click("recognizedfax",recognizedfax);
		
//		getHttpResponse();
	}
	
	//UnRecognized Fax
	@FindBy(id="unrecognized")						//added by Ramya
	private WebElement unrecognizedfax;
	public WebElement unrecognizedfax(){
		return unrecognizedfax;
	}
	
	
	//Unrecognized fax table
	@FindBy(css="#inbound-dashboard table")						//added by Ramya
	private WebElement unrecognizedfaxTable;
	public WebElement unrecognizedfaxTable(){
		return unrecognizedfaxTable;
	}
	
	public void UnrecognizedFax() {
		lavanteUtils.fluentwait(unrecognizedfax);
		lavanteUtils.click("unrecognizedfax",unrecognizedfax);
	}
	
	//Do not Audit (DNA) Fax
	@FindBy(id="dna")
	private WebElement dna;
	public WebElement dna(){                        //added by Ramya
		return dna;
	}
	
	@FindBy(css="#inbound-dashboard div table")
	private WebElement dnaTable;
	public WebElement dnaTable(){                        //added by Ramya
		return dna;
	}
	
	
	
	public void verifyDNAFax() {
		lavanteUtils.click("dna",dna);
		lavanteUtils.fluentwait(dna);
//		getHttpResponse();
	}
	
	//Statements
	@FindBy(id="statements")
	private WebElement statements;
	
	public void verifyStatements() {
		lavanteUtils.click("statements",statements);
		lavanteUtils.fluentwait(statements);
	//	getHttpResponse();
	}
	
	//Statements table 
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement statementsTable;
	
	public void verifyStatementsTable() {
		//verifyStatements();
		lavanteUtils.isDisplayed("statementsTable",statementsTable);
		lavanteUtils.verifyError(statementsTable);		
	}
	
	//Verifications
	@FindBy(id="verifications")
	private WebElement verifications;
		
	public void verifyVerifications() {
		lavanteUtils.click("verifications",verifications);
		lavanteUtils.fluentwait(verifications);
		lavanteUtils.isDisplayed("verifications",verifications);
		lavanteUtils.verifyError(verifications);
	}
	
	//Verifications table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement verificationsTable;
		
	public void verifyVerificationsTable() {
		//verifyVerifications();
		lavanteUtils.isDisplayed("verificationsTable",verificationsTable);
		lavanteUtils.verifyError(verificationsTable);
	}
	
	//Check request
	@FindBy(id="checks")
	private WebElement checks;
			
	public void verifyChecks() {
		lavanteUtils.click("checks",checks);
		lavanteUtils.fluentwait(checks);
	//	getHttpResponse();
	}
	
	//Check request table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement checksTable;
			
	public void verifyChecksTable() {
		lavanteUtils.isDisplayed("checksTable",checksTable);
		lavanteUtils.verifyError(checksTable);
	}
	
	//Correspondence
	@FindBy(id="correspondence")
	private WebElement correspondence;
	
	public void verifyCorrespondence(){
		lavanteUtils.click("correspondence", correspondence);
		lavanteUtils.fluentwait(correspondence);
	}
	
	//Correspondence table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement correspondenceTable;
	
	public void verifyCorrespondenceTable(){
		lavanteUtils.isDisplayed("correspondenceTable",correspondenceTable);
		lavanteUtils.verifyError(correspondenceTable);
	}
	
	//Duplicates
	@FindBy(id="duplicate")
	private WebElement duplicate;
	
	public void verifyDuplicate(){
		lavanteUtils.click("duplicate", duplicate);
		lavanteUtils.fluentwait(duplicate);
	//	getHttpResponse();
	}
	
	//Duplicates table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement duplicateTable;
	
	public void verifyDuplicateTable(){
		lavanteUtils.isDisplayed("duplicateTable",duplicateTable);
		lavanteUtils.verifyError(duplicateTable);
	}
	
	//Profiles
	@FindBy(id="profiles")
	private WebElement profiles;
	
	public void verifyProfiles(){
		lavanteUtils.click("profiles", profiles);
		lavanteUtils.fluentwait(profiles);
	//	getHttpResponse();
	}
	
	//Profiles table
	@FindBy(css="#inbound-dashboard-table tr td")
	private WebElement profilesTable;
	
	public void verifyprofilesTable(){
		lavanteUtils.click("profilesTable", profilesTable);
		lavanteUtils.fluentwait(profilesTable);
	//	getHttpResponse();
	}
	
	//Supplier main Table
	@FindBy(css="#inbound-dashboard-table tr td:nth-child(2) a")
	private List<WebElement> supplier;
	
	//Document Status--Supplier Queue table
	@FindBy(css="#inbound-dashboard-table tr td:nth-child(4)")
	private List<WebElement> docStatus;
	
	//Doc Action table--Document Status
	@FindBy(css="#doc-status")
	private WebElement docActiondocStatus;
	
	//Review button
	@FindBy(css="#need-review-button")
	private WebElement reviewBtn;
	
	
	@FindBy(css="iframe[data-iname*='awaitingResponsePopup']")
	private WebElement awaitingResponsepopUp;
	
	//Awaiting Response button
	@FindBy(css="#awaiting-response-button")
	private WebElement awaitingResponseBtn;
	
	//Save button
	@FindBy(css="#save-button")
	private WebElement saveBtn;
	
	//Save button After change - pop up -OK Button
	@FindBy(css="[class*='dialog'] [class*='green']")
	private WebElement popupOKBtn;
	
	//Save button After change - pop up
	@FindBy(css=".ui-dialog-titlebar #ui-id-3")
	private WebElement popUp;
	
	//Save and Dispose button
	@FindBy(css="#save-dispose-button")
	private WebElement saveAndDisposeBtn;
	
	//Cancel button
	@FindBy(css="#cancel-button")
	private WebElement cancelBtn;
	
	//Next button
	@FindBy(css="#next-button")
	private WebElement nextBtn;
	
	//Previous button
	@FindBy(css="#previous-button")
	private WebElement previousBtn;
	
	//SupplierDetails Table--Supplier Name
	@FindBy(css="input[name='supplierName']")
	private WebElement suppName;
		
	//Validate supplier pop up
	@FindBy(css=".validateUID td label")
	private WebElement validateSupplierPopUp;
	
	@FindBy(css="input[value='Validate']")
	private WebElement validateSupplierBtn;
	
	//Doc Action--Doc type
	@FindBy(css="#documentType option[ng-selected='true']")
	private WebElement defaultselectedVerification;
	
	//Awaiting Response pop up frame
	@FindBy(css="iframe[src*='awaitingResponse']")
	private WebElement iFrameAwaitingResponse;
	
	//Awaiting Response comment text box
	@FindBy(css="#needs-review-comment-textarea")
	private WebElement commentTxtBox;
	
	//Awaiting Response comment box--Submit
	@FindBy(css="#save-button")
	private WebElement submitBtn;

	//Supplier Details--Lavante UID field
	@FindBy(css="#lavanteUID")
	private WebElement lavanteUIDfield;
	
	//Validate supplier text box
	@FindBy(css="#validate-lavanteuid")
	private WebElement validateSuppliertxtbox;
	
	//Credit table
	@FindBy(css="#credit-claim-iframe")
	private WebElement creditTableiFrame;
	
	//Credit table--All Claims
	@FindBy(css=".All.active span")
	private WebElement allClaimsInCreditTable;
	
	//Credit table--Closed Claims
	@FindBy(css=".Close span")
	private WebElement closedClaimsInCreditTable;
	
	
	//Credit table--Claim Status Drop Down
	@FindBy(css="select[name*='claim-status']")
	private List<WebElement> claimStatusInCreditTable;
	
	//Credit table
	@FindBy(css="#credit-claim-table tr td")
	private List<WebElement> CreditTable;

	
	@FindBy(css="#credit-claim-table tbody tr input")
	private List<WebElement> CredittableFields;
	
	//Credit Table --Supplier Ref:
	@FindBy(css="input[name='supplier_ref']")
	private WebElement supplierRef;
	
	//Credit Table --All used Supplier Ref rows
	@FindBy(css="#credit-claim-table td:nth-child(1)")
	private List<WebElement> SupplierRefWithData;
	
	//Credit Table --Customer:
	@FindBy(css="input[name='customer']")
	private WebElement customerField;
	
	//Credit Table --Credit Date:
	@FindBy(css="input[name='credit_date']")
	private WebElement creditDate;
	
	//Credit Table --Amount
	@FindBy(css="input[name='amount']")
	private WebElement amount;
	
	//Alert pop up for void and refund claims closure
	@FindBy(css="#ui-id-4")
	private WebElement alertForVoidAndRefundClaimsClosure;
	
	//Close Claim 
	@FindBy(css=".no-chosen option[value='Close']")
	private WebElement closeClaim;
	
	//Void Claim 
	@FindBy(css=".no-chosen option[value='Void']")
	private WebElement voidClaim;
	
	//Refund Claim 
	@FindBy(css=".no-chosen option[value='Refund']")
	private WebElement refundClaim;
	
	//Close button in alert pop up 
	@FindBy(css=".ui-button span:nth-child(2)")
	private WebElement alertClose;
	
	//Void claims count in credit table
	@FindBy(css=".Void span")
	private WebElement voidClaimsCountinCreditTable;
	
	//Refund claims count in credit table
	@FindBy(css=".Refund span")
	private WebElement refundClaimsCountinCreditTable;
	
	//Comments Tab
	@FindBy(css="#comments-tab")
	private WebElement commentsTab;
	
	//Supplier Details--Address Line 1 
	@FindBy(css="input[ng-model*='addressLine1']")
	private WebElement address1;
	
	//Comments Table--Date Column
	@FindBy(css="#doc-action-comments-table td:nth-child(1)")
	private List <WebElement> commentDate;
	
	//Comments Table--Comment Details column
	@FindBy(css="#doc-action-comments-table td:nth-child(3)")
	private List <WebElement> commentDetails;
	
	//LogOut
	@FindBy(css="a[href*='logout']")
	private WebElement LogOutBtn;
	
	//Submit check box for batching
	@FindBy(css="input[name='submitted']")
	private WebElement chkboxCreditTableSubmit;
	
	public void submitChkBox(){
		lavanteUtils.click("chkboxCreditTableSubmit",chkboxCreditTableSubmit); 
	}
	
	//Link check box for batching
	@FindBy(css="input[name='link']")
	private WebElement chkboxCreditTableLink;
	
	public void linkChkBox(){
		lavanteUtils.click("chkboxCreditTableLink",chkboxCreditTableLink); 
	}
	
	 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	 
	public void EnterCredits(LinkedHashMap<String,String> dataMap) throws AWTException, ParseException{
		lavanteUtils.switchtoFrame(creditTableiFrame);

			Random rn = new Random();
			int nextInt = rn.nextInt(999);
			
			String beforeEnteringCredits = allClaimsInCreditTable.getText();
			
			String beforeEntringCreditsClosedClaims = closedClaimsInCreditTable.getText();
			
			if(dataMap.containsKey("SupplierRef")){
			//	waitforPageLoad(supplierRef);
				supplierRef.sendKeys(dataMap.get("SupplierRef") + nextInt);
				lavanteUtils.waitForTime(2000);
			}
			
			if(dataMap.containsKey("Customer")){
				customerField.sendKeys(dataMap.get("Customer") + nextInt);
				lavanteUtils.waitForTime(2000);
			}
			
			if(dataMap.containsKey("CreditDate")){

				String randomDate ="";// generateRandomDate();
				creditDate.sendKeys(randomDate);
				lavanteUtils.waitForTime(2000);
			}
			
			if(dataMap.containsKey("Amount")){
					amount.sendKeys(dataMap.get("Amount") + nextInt);
					lavanteUtils.waitForTime(2000);
			}
			
			if(dataMap.containsKey("Submit")){
				if(!chkboxCreditTableSubmit.isSelected()){
					chkboxCreditTableSubmit.click();
				}
				lavanteUtils.waitForTime(2000);
			}
			
			if(dataMap.containsKey("Link")){
				if(!chkboxCreditTableLink.isSelected()){
					chkboxCreditTableLink.click();
				}
				lavanteUtils.waitForTime(2000);
				chkboxCreditTableLink.sendKeys(Keys.ENTER);
				lavanteUtils.waitForTime(5000);
			}
			
			System.out.println(dataMap);
			
					String afterEnteringCredits = allClaimsInCreditTable.getText();
					String afterEntringCreditsClosedClaims = closedClaimsInCreditTable.getText();
					
					if(beforeEnteringCredits.equalsIgnoreCase(afterEnteringCredits)){
							
						if(beforeEntringCreditsClosedClaims.equalsIgnoreCase(afterEntringCreditsClosedClaims)){
							System.out.println("Credits are NOT auto closed");
							Reporter.log("Credits are NOT auto closed");
							AssertJUnit.assertTrue("Credits are NOT auto closed", false);
						}
						
						else{
							System.out.println("Credits are auto closed due to duplicate credits");
							Reporter.log("Credits are auto closed due to duplicate credits");
						}
						System.out.println("Credits are not saved in All claims");
						System.out.println(beforeEnteringCredits + afterEnteringCredits);
						Reporter.log("Credits NOT saved in All claims");
					}
					
					else
						System.out.println("Credits saved successfully");
						Reporter.log("Credits saved successfully");
			}
	
				
		
//	}
		
	public void verifyDiffClaimStatus(LinkedHashMap<String, String> dataMap) throws AWTException{
		
		String claimsCountBeforeClosure = closedClaimsInCreditTable.getText();
	
		WebElement firstclaimstatus = driver.findElement(By.cssSelector("#credit-claim-table tr:nth-child(1) td:nth-child(9)"));
		WebElement secondclaimstatus = driver.findElement(By.cssSelector("#credit-claim-table tr:nth-child(2) td:nth-child(9)"));
		Actions act = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
			
		firstclaimstatus.click();
		firstclaimstatus.click();
		
	Reporter.log("---------------Closed claims Started----------------------");
		
		//ActionsforDoubleClick(closeClaim);
	lavanteUtils.waitForTime(5000);
		secondclaimstatus.click();
		lavanteUtils.waitForTime(5000);
		
				String claimsCountAfterClosure = closedClaimsInCreditTable.getText();
				
				if(!claimsCountBeforeClosure.equalsIgnoreCase(claimsCountAfterClosure)){
					System.out.println("Claim closed successfully");
					Reporter.log("Claim closed successfully");
				}
				
				else{
					System.out.println("Claim NOT closed successfully");
					Reporter.log("Claim NOT closed successfully");
				}	
		allClaimsInCreditTable.click();
		
	Reporter.log("---------------Closed claims completed----------------------");
		
	Reporter.log("---------------Void claims Started----------------------");
	lavanteUtils.waitForTime(5000);
			//Void Claim Status	
			firstclaimstatus.click();
			firstclaimstatus.click();
			
		//	ActionsforDoubleClick(voidClaim);
			lavanteUtils.waitForTime(5000);
		//	act.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			secondclaimstatus.click();
			lavanteUtils.switchtoFrame(null);
		//	ExplicitWaitforelements(popupOKBtn);

			System.out.println("void: " +popupOKBtn.getText());
			lavanteUtils.click(popupOKBtn);
			
			System.out.println("Got valid error message for void claims");
			
	Reporter.log("---------------Void claims completed----------------------");
			
	Reporter.log("---------------Refund claims Started----------------------");
	lavanteUtils.fluentwait(creditTableiFrame);
	lavanteUtils.switchtoFrame(creditTableiFrame);
	lavanteUtils.waitForTime(10000);
			//Refund Claim Status	
			firstclaimstatus.click();
			firstclaimstatus.click();
			
		//	ActionsforDoubleClick(refundClaim);
			lavanteUtils.waitForTime(5000);
		
		//	act.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			secondclaimstatus.click();
			lavanteUtils.switchtoFrame(null);
		//	ExplicitWaitforelements(popupOKBtn);
			System.out.println("refund: " +popupOKBtn.getText());
			lavanteUtils.click(popupOKBtn);
			System.out.println("Got valid error message for Refund claims");	
	Reporter.log("---------------Refund claims completed----------------------");
	}

	
	public void validateFixOCR(){
		lavanteUtils.waitForTime(15000);
		lavanteUtils.Scrollintoview(suppName);
		String actSuppafterFixOCRinSuppDetails = suppName.getAttribute("value").toString();	
		System.out.println(actSuppafterFixOCRinSuppDetails);
		//String actSuppafterFixOCRinSuppLookup = suppLookUpwithSupplierName.getText();
		String actSuppafterFixOCRinQueDetails = suppNameinQueueDetails.getText().toString();
		System.out.println(actSuppafterFixOCRinQueDetails);
		
			if(actSuppafterFixOCRinSuppDetails.equalsIgnoreCase(actSuppafterFixOCRinQueDetails)){
				System.out.println("FIX OCR working as expected");
				Reporter.log("FIX OCR working as expected");
			}

			else{
				System.out.println("FIX OCR FAILED");
				Reporter.log("FIX OCR FAILED");
				Assert.assertTrue(false, "FIX OCR FAILED");
			}
			
	}
	
	public WebElement clickOnValidatesupplierpop() throws AWTException{
		
		lavanteUtils.fluentwait(validateSupplierPopUp);
		validateSupplierPopUp.click();
		
		lavanteUtils.fluentwait(lavanteUIDfield);
		lavanteUtils.enterText("Validate Supplier text box", validateSuppliertxtbox, lavanteUIDfield.getText());
		validateSupplierBtn.click();
		lavanteUtils.Scrollintoview(suppName);
		return validateSupplierPopUp;
	}
	
	public void skipValidateSupplierPopUp() throws AWTException{
		if(validateSupplierPopUp.isDisplayed()){
			lavanteUtils.fluentwait(validateSupplierPopUp);
			validateSupplierPopUp.click();
			Actions act = new Actions(lavanteUtils.driver);
			act.moveToElement(validateSuppliertxtbox);
			act.sendKeys(Keys.ESCAPE).build().perform();
		}

	}
	
	public void selectFax(){
		boolean flag = false;
		
		for(WebElement eachFax: selFax){
			String fax = eachFax.getText().toString();
			String[] faxType = fax.split("[\\(\\)]");
			
			for(String singleFaxType : faxType){
				if(singleFaxType.equalsIgnoreCase("")){
					continue;
				}
				
					int faxCount = Integer.parseInt(singleFaxType);
				
					if(faxCount > 0){
						eachFax.click();
						flag=true;
						break;
					}
					
					else
						flag= false;
			}
			
	System.out.println(flag);		
		if(flag == true){
			break;
		}
			
		}
	}
	
/*	public void selectFax(){
		String verificationInboundLandingPage = verifications.getText().toString();
		System.out.println(verificationInboundLandingPage);
		String[] ver = verificationInboundLandingPage.split("[\\(\\)]");
		
		String statementInboundLandingPage = statements.getText().toString();
		System.out.println(statementInboundLandingPage);
		
		String[] stat = verificationInboundLandingPage.split("[\\(\\)]");
		
		String correspondanceInboundLandingPage = correspondence.getText().toString();
		System.out.println(correspondanceInboundLandingPage);
		
		String[] corres = correspondanceInboundLandingPage.split("[\\(\\)]");
		
		
		for(String v: ver){
			if(v.equalsIgnoreCase("")){
				continue;
			}
			
			System.out.println(v);
			 int verificationsCount = Integer.parseInt(v);
			 
				if(verificationsCount > 0){
					verifications.click();
				}
				
				else{
					for(String s: stat){
						if(s.equalsIgnoreCase("")){
							continue;
						}
						
						int statementsCount = Integer.parseInt(s);
							if(statementsCount > 0){
								statements.click();
							}
							
							else{
								for(String c: corres){
									if(c.equalsIgnoreCase("")){
										continue;
									}
									
									int coresCount = Integer.parseInt(c);
										if(coresCount > 0){
											correspondence.click();
										}
								}
							}
						
					}
				}
		}
	}*/
	
	public void selectSupplierfromInboundPageforRecognized() throws AWTException{
	
		if(supplier.size()>0){
			if(docStatus.size()>0){
				int count = 0;

				 for(count = 0 ; count<docStatus.size(); count++){
					 WebElement eachDocStatus = docStatus.get(count);
	 
					 if(!eachDocStatus.getText().equalsIgnoreCase("Received")){
						 
						 WebElement eachSupplier = supplier.get(count);
						 eachSupplier.click();
						 break;
					 }
					 
					 else{
						
						 WebElement eachSupplier = supplier.get(count);
						 eachSupplier.click();
						 lavanteUtils.waitForTime(5000);
						 clickOnValidatesupplierpop();
					}
				}
			}
		}
	}
	
	public void navigateToVerifications() throws AWTException{
		RecognizedFax();
		verifications.click();

		selectSupplierfromInboundPageforRecognized();
		
		if(defaultselectedVerification.getText().toString().equalsIgnoreCase("Verification")){
			Reporter.log("Correctly selected verification doc type, proceed with entering credits for batching");
			System.out.println("Correctly selected verification doc type, proceed with entering credits for batching");
		}
		
		else{
			Reporter.log("Verification doc type not selected, please change it to verification");
			AssertJUnit.assertTrue("Verification doc type not selected, please change it to verification", false);
		}	
	}
		
		public void selectSupplierfromInboundPageforUnRecognized() throws AWTException{
			
			if(supplier.size()>0){
				if(docStatus.size()>0){
					int count = 0;

					 for(count = 0 ; count<docStatus.size(); count++){
						 WebElement eachDocStatus = docStatus.get(count);
		 
						 if(!eachDocStatus.getText().equalsIgnoreCase("Received")){
							 
							 WebElement eachSupplier = supplier.get(count);
							 eachSupplier.click();
							 break;
						 }
						 
						 else{
							
							 WebElement eachSupplier = supplier.get(count);
							 eachSupplier.click();
							 
							 lavanteUtils.waitForTime(3000);
								
							 }
						 }
					 }
				}
					
		else{

				Reporter.log("No data available");
				
		}
			
	}
	
	String supNameBeforeChange = null;
	String supNameAfterChange = null;
	String address1BeforeChange = null;
	 String add1AfterChange = null;
	
	//Update supplier details
	public void updateSupplierDetails(){
	//	 waitforPageLoad(suppName);
	//	 scrollingToElementofAPage(suppName);
		
		  address1BeforeChange = address1.getAttribute("value").toString();
		  supNameBeforeChange = suppName.getAttribute("value").toString();
		 
		 System.out.println("Before name" + supNameBeforeChange);
		 System.out.println("Before address" + address1BeforeChange);
		 
		 Reporter.log("Before updating supplier name:" + supNameBeforeChange );
		 Reporter.log("Before updating supplier address:" + address1BeforeChange);
		 
		  supNameAfterChange = generateSupplierName();
		  
		  lavanteUtils. fluentwait(address1);
		 add1AfterChange = generateSupplierAddress();
		 
		 System.out.println("After name" + supNameAfterChange);
		 System.out.println("After address" + add1AfterChange);
		 
		 Reporter.log("After updating supplier name:" + supNameAfterChange );
		 Reporter.log("After updating supplier address:" + add1AfterChange);
		 
		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange) && (!address1BeforeChange.equalsIgnoreCase(add1AfterChange))){
			 System.out.println("Supplier details updated successfully");
			 Reporter.log("Supplier details updated successfully");
		 }
		 else{
			 System.out.println("Supplier details NOT updated successfully");
			 Reporter.log("Supplier details NOT updated successfully");
			 AssertJUnit.assertTrue("Supplier details NOT updated successfully", false);
		 }
			 
	}
	
	Random rn = new Random();

	String newSuppName = null;
	//Generate new supplier Name with random number
	public String generateSupplierName(){
		
		String supplierName = suppName.getAttribute("value").toString();
		String newSuppName= supplierName + "" + rn.nextInt(99);
		suppName.sendKeys(newSuppName);
		return newSuppName;
	}
	
	String newAdd1 = null;
	//Generate new supplier Address 1with random number
	public String generateSupplierAddress(){
		lavanteUtils.fluentwait(address1);
		String add1 = address1.getAttribute("value").toString();
		String newAdd1 = add1 + "" + rn.nextInt(99);
		address1.sendKeys(newAdd1);
		return newAdd1 ;
	}

	
	/**
	 * @param dataMap
	 * @throws AWTException
	 */
	/**
	 * @param dataMap
	 * @throws AWTException
	 */
	/**
	 * @param dataMap
	 * @throws AWTException
	 */
	/**
	 * @param dataMap
	 * @throws AWTException
	 */
	public void selectAction(LinkedHashMap<String, String> dataMap) throws AWTException{
		
		/**
		 * @Purpose Verify Save functionality in data page
		 * @author Srikanth
		*/
         if(dataMap.containsKey("Save")){
        	  updateSupplierDetails();
        //	  scrollToBottom(driver);
        	  
        	  lavanteUtils. waitForTime(5000);
        	  saveBtn.click();
  
        //	  ActionsforSingleClick(popupOKBtn);
        	  lavanteUtils.  waitForTime(5000);

     		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
     			 System.out.println("Suplier details are updated with with Save button");
     			 Reporter.log("Suplier details are updated with with Save button");
         		 suppName.clear();
         		 address1.clear();
     		 }
     		 
     		 else{
     			System.out.println("Suplier details are NOT updated with with Save button");
     			 Reporter.log("Suplier details are NOT updated with with Save button");
     			 Assert.assertTrue(false, "Suplier details are NOT updated with with Save button");
     		 }
          }
         
         
 		/**
 		 * @Purpose This is to verify Next button functionality in data page
 		 * @author Srikanth
 		*/

         lavanteUtils.waitForTime(5000);
  /*      String attribute = "";
         try{
        	  attribute = nextBtn.getAttribute("disabled");
        	  System.out.println(attribute); 
        	  
        	  if(attribute.equalsIgnoreCase("true")){
             	 System.out.println("Need more test data to test this functionality");
             	 Reporter.log("Need more test data to test this functionality");
             	// Assert.assertTrue(false, "Need more test data to test this functionality");
              }
        	  
         }catch(Exception e){
             if(dataMap.containsKey("Next")){
            	 updateSupplierDetails();
            	 scrollToBottom(driver);
            	 waitForTime(5000);
            	 nextBtn.click();

          	  	  ActionsforSingleClick(popupOKBtn);
          	   	  
          	  	  if(validateSupplierPopUp.isDisplayed()){
          	  		validateSupplierPopUp.click();
          	  		waitForTime(5000);
          	  		clickOnValidatesupplierpop();
          	  		waitForTime(5000);
          	  	  }
          	  	  
          	  	  else{
          	  		 previousBtn.click();
          	  		 waitForTime(5000);
          	  	  }

        		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
        			 nextBtn.click();
        			 System.out.println("Suplier details are updated with Next button");
        			 Reporter.log("Suplier details are updated with Next button");
            		 suppName.clear();
             		 address1.clear();
        		 }
        		 
        		 else{
        			 Reporter.log("Suplier details are NOT updated with Next button");
        			 nextBtn.click();
        			 Assert.assertTrue(false,"Suplier details are NOT updated with with Next button"); 
        		 }
            }
         }
         */
  
  		/**
  		 * @Purpose This is to verify Previous button functionality in data page
  		 * @author Srikanth
  		*/
     /*    if(previousBtn.getAttribute("disabled").equalsIgnoreCase("true")){
        	 System.out.println("Need more test data to test this functionality");
        	 Reporter.log("Need more test data to test this functionality");
        	// Assert.assertTrue(false, "Need more test data to test this functionality");
         }
         else if(dataMap.containsKey("Previous")){
        	 updateSupplierDetails();
        	 scrollToBottom(driver);
        	 waitForTime(5000);
        	 previousBtn.click();
        	 ActionsforSingleClick(popupOKBtn);
        	
        	 if(validateSupplierPopUp.isDisplayed()){
    	  		validateSupplierPopUp.click();
    	  		waitForTime(5000);
    	  		clickOnValidatesupplierpop();
        	 }
      	  
    		  nextBtn.click();
    		  waitForTime(5000);

    		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
    			 System.out.println("Suplier details are updated with Previous button");
    			 Reporter.log("Suplier details are updated with Previous button");
        		 suppName.clear();
         		 address1.clear();
    		 }
    		 
    		 else{
    			 Reporter.log("Suplier details are NOT updated with Previous button");
    			 Assert.assertTrue(false,"Suplier details are NOT updated with with Previous button");
    		 }
        }*/
          
         lavanteUtils.waitForTime(5000);
          
    	/**
    	 * @Purpose This is to verify Awaiting Response button functionality in data page
    	 * @author Srikanth
    	*/
          if(dataMap.containsKey("Awaiting Response")){
             
        	  updateSupplierDetails();
        	  awaitingResponseBtn.click();
        	  
        //	  ActionsforSingleClick(popupOKBtn);
        	  
        	  lavanteUtils. switchtoFrame(awaitingResponsepopUp);
        	  commentTxtBox.sendKeys("Testing comment for Awaiting Response");
        	  saveBtn.click(); 
        	  lavanteUtils.switchtoFrame(null);
        	  lavanteUtils.waitForTime(5000);
        	  
/*        	  if(validateSupplierPopUp.isDisplayed()){
      	  		validateSupplierPopUp.click();
      	  		clickOnValidatesupplierpop();
      	  	  }*/
      		 
      		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
      			 
      			String script = "return document.getElementById('pre-doc-status').getAttribute('value');";
     			String value = ((JavascriptExecutor) driver).executeScript(script).toString();
     			
     			 //if(value.equalsIgnoreCase("Awaiting Response")){
     			 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
     				 System.out.println("Awaiting Response working fine");
         			 Reporter.log("Awaiting Response working fine");
     			 }
     			 else{
     				 System.out.println("Awaiting Response NOT working");
     			 	 Reporter.log("Awaiting Response NOT working");
     			 	 Assert.assertTrue(false,"Awaiting Response NOT working");
          		}
      		 }
      		 
      		 else{
      			 Reporter.log("Awaiting Response status NOT updated");
      		 }   
          }  
          
     //     waitForTime(5000);
          
      	/**
      	 * @Purpose This is to verify Review button functionality in data page
      	 * @author Srikanth
      	*/
          if(dataMap.containsKey("Review")){
       	  updateSupplierDetails();
      // 	  scrollToBottom(driver);
       	lavanteUtils. waitForTime(5000);
       	  reviewBtn.click();
       	lavanteUtils. fluentwait(reviewBtn);
       	  
      // 	  ActionsforSingleClick(popupOKBtn);
       	  
       	lavanteUtils. waitForTime(3000);
       	lavanteUtils. switchtoFrame(awaitingResponsepopUp);
       	  commentTxtBox.sendKeys("Testing comment for review");
       	  saveBtn.click(); 
       	lavanteUtils. switchtoFrame(null);
       	  
       	lavanteUtils. waitForTime(5000);
       	  
     		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
     			 
     			String script = "return document.getElementById('pre-doc-status').getAttribute('value');";
    			String value = ((JavascriptExecutor) driver).executeScript(script).toString();
    			

    				if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){
    					System.out.println("Statement Review working fine");
    					Reporter.log("Statement Review working fine");
    				}
    				else{
    					System.out.println("Statement Review NOT working");
    					Reporter.log("Statement Review NOT working");
    					Assert.assertTrue(false, "Statement Review NOT working");
    				}
     		 }
     		 
     		 else{
     			 Reporter.log("Suplier details are NOT updated since there is no change");
     		 } 
         }


        	/**
        	 * @Purpose This is to verify Save and Dispose button functionality in data page
        	 * @author Srikanth
        	*/
         /* 	waitForTime(5000);

           if(dataMap.containsKey("Save & Dispose")){
        	  updateSupplierDetails();
        	  scrollToBottom(driver);
        	  saveAndDisposeBtn.click(); 
        	  ActionsforSingleClick(popupOKBtn);
        	  waitForTime(8000);
     		 
     		 boolean displayed = validateSupplierPopUp.isDisplayed();
     		System.out.println(displayed);
     		
    		 if(displayed=true){
     			fluentwait(validateSupplierPopUp);
     	  		validateSupplierPopUp.click();
     	  		clickOnValidatesupplierpop();
     	  	  }
     		 
     		 else{
        	  
     		waitforPageLoad(docActiondocStatus);
     		
     		try{
     			 if(previousBtn.getAttribute("disabled").equalsIgnoreCase("true")){
                 	
                	 String docaction = docActiondocStatus.getAttribute("value");
                	 System.out.println(docaction);
                	 
                	 if(docaction.equalsIgnoreCase("Disposed")){
                		 Reporter.log("Disposed successfully");
                	 }
                	 else{
                		 Assert.assertTrue(false, "Dispose Failed");
                	 }
                	// Assert.assertTrue(false, "Need more test data to test this functionality");
                 }
     		}catch(Exception e){
     			previousBtn.click();
     		}
     		
     		fluentwait(docActiondocStatus);
     		
     		 if(!supNameBeforeChange.equalsIgnoreCase(supNameAfterChange)){

     			String script = "return document.getElementById('pre-doc-status').getAttribute('value');";
    			String value = ((JavascriptExecutor) driver).executeScript(script).toString();
     			
     			System.out.println(value);
     			
     			 if(value.equalsIgnoreCase("Disposed")){
     				 System.out.println("Save & Dispose working fine");
         			 Reporter.log("Save & Dispose working fine");
     			 }
     			 else{
     				 System.out.println("Doc status not updated to Disposed");
     			 	 Reporter.log("Doc status not updated to Disposed");
     			 	 Assert.assertTrue(false,"Save and Dispose not working");
     			 }
     		 }
     		 
     		 else{
     			 Reporter.log("No change in supplier details");
     		 }
          }
          

           waitForTime(5000);
      }        */   
        
	}
	
	public void verifyComments(){
		String dateTime = "";//getCurrentDateTime();

		System.out.println(commentDate.size()  + "," + commentDetails.size());
		
		commentsTab.click();
		lavanteUtils.waitForTime(3000);
		
		for(int i = 0 ; i<commentDate.size(); i++){
			String todayCommentDate = commentDate.get(i).getAttribute("title");
			
			String str = todayCommentDate;
			
			String[] splitStr = str.trim().split(" ");
			
			String split_one=splitStr[0];
		    String split_three=splitStr[2];
		    String split_four=splitStr[3];
		    
		    String newFormattedCommentDate = split_one + " " + split_three +" " + split_four;
		    
		    System.out.println(newFormattedCommentDate + ":::" + dateTime);
		    	    
			if(newFormattedCommentDate.equalsIgnoreCase(dateTime)){
				
				for(int j=0; j<=commentDetails.size(); j++){

						String todayComment = commentDetails.get(j).getAttribute("title");
						
					if(todayComment.contains(add1AfterChange) || todayComment.contains(supNameAfterChange)){
						break;
					}
					else
						continue;	
				}	
			}
			else
				AssertJUnit.assertTrue("No comments are added today", false);
	
		}
	}

}

		
	
	

