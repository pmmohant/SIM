package com.lavante.recovery.pageobjects.Audit.Inbound;

import java.util.LinkedHashMap;
import java.util.List;

import com.lavante.recovery.Common.Util.LavanteUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuditInboundPage {
	LavanteUtils lavanteUtils = new LavanteUtils();
	//public WebDriver driver = null;

	public AuditInboundPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	// Incoming Document Statistics table
	@FindBy(css = "#inboundDocumentStatistics tr")
	private WebElement inboundDocumentStatistics;

	// Supplier status summary table
	// Active
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(1) td[ng-bind*='active']")
	private WebElement activeStatus;

	public WebElement activeStatus() {
		return activeStatus;
	}

	// Credits
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(1) td[ng-bind*='credits']")
	private WebElement creditStatus;

	public WebElement creditStatus() {
		return creditStatus;
	}

	// Do not audit
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(2) td[ng-bind*='doNotAudit']")
	private WebElement doNotAuditStatus;

	public WebElement doNotAuditStatus() {
		return doNotAuditStatus;
	}

	// Inactive
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(2) td[ng-bind*='inactive']")
	private WebElement inactiveStatus;

	public WebElement inactiveStatus() {
		return inactiveStatus;
	}

	// Need Address
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(3) td[ng-bind*='needAddress']")
	private WebElement needAddressVal;

	public WebElement needAddressVal() {
		return needAddressVal;
	}

	// Will Not Provide
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(3) td[ng-bind*='willNotProvide']")
	private WebElement willNotProvideVal;

	public WebElement willNotProvideVal() {
		return willNotProvideVal;
	}

	// Received
	@FindBy(css = "[id='inbound_supplier_status'] tbody tr:nth-child(4) td[ng-bind*='received']")
	private WebElement receivedVal;

	public WebElement receivedVal() {
		return receivedVal;
	}

	// Document status summary table - not required

	// Recognized Tab
	@FindBy(id = "recognized")
	private WebElement recognizedTab;

	public WebElement recognizedTab() {
		return recognizedTab;
	}

	// Unrecognized Tab
	@FindBy(id = "unrecognized")
	private WebElement unRecognizedTab;

	public WebElement unRecognizedTab() {
		return unRecognizedTab;
	}

	// DNA Tab
	@FindBy(id = "dna")
	private WebElement dnaTab;

	public WebElement dnaTab() {
		return dnaTab;
	}

	//Links of - Statements, Verifications, Checks, Correspondence, Duplicate, Profiles
	@FindBy(css=".dashboard-subtab a")
	private List<WebElement> selLinks;
	
	public List<WebElement> selLinks() {
		return selLinks;
	}
	
	// Statements
	@FindBy(id = "statements")
	private WebElement statementsCount;

	public WebElement statementsCount() {
		return statementsCount;
	}

	// Verifications
	@FindBy(id = "verifications")
	private WebElement verificationsCount;

	public WebElement verificationsCount() {
		return verificationsCount;
	}

	// Checks
	@FindBy(id = "checks")
	private WebElement checksCount;

	public WebElement checksCount() {
		return checksCount;
	}

	// Correspondence
	@FindBy(id = "correspondence")
	private WebElement correspondenceCount;

	public WebElement correspondenceCount() {
		return correspondenceCount;
	}

	// Duplicate
	@FindBy(id = "duplicate")
	private WebElement duplicateCount;

	public WebElement duplicateCount() {
		return duplicateCount;
	}

	// Profiles
	@FindBy(id = "profiles")
	private WebElement profilesCount;

	public WebElement profilesCount() {
		return profilesCount;
	}

	// Inbound dashborad table
	//Document count [id='supplier-queue-table'] span:nth-child(4)
	@FindBy(css = "[id='supplier-queue-table'] span:nth-child(4)")
	private WebElement docQueueSpan;

	public WebElement docQueueSpan() {
		return docQueueSpan;
	}
	
	// Validate button
		@FindBy(name = "btnValidate")
		private WebElement supPopUpValidateBtn;

		public WebElement supPopUpValidateBtn() {
			return supPopUpValidateBtn;
		}
	
	// supplierName
	@FindBy(css = "[id='inbound-dashboard-table'] td:nth-child(1) a")
	private List<WebElement> supplierName;

	public List<WebElement> supplierName() {
		return supplierName;
	}

	// Date
	@FindBy(css = "[id='inbound-dashboard-table'] td:nth-child(2) a")
	private List<WebElement> date;

	public List<WebElement> date() {
		return date;
	}

	// Recognized Document Queue table
	// supplierName
	@FindBy(css = "[id='queue-navigation'] td:nth-child(1) a")
	private List<WebElement> supplierNameLink;

	public List<WebElement> supplierNameLink() {
		return supplierNameLink;
	}

	// spend rank from table
	@FindBy(css = "[id='queue-navigation'] td:nth-child(5)")
	private List<WebElement> spendRank;

	public List<WebElement> spendRank() {
		return spendRank;
	}

	// Suplier details

	// Entry field for keying in the LavateID to validate
	@FindBy(id = "validate-lavanteuid")
	private WebElement supPopUpLavanteID;

	public WebElement supPopUpLavanteID() {
		return supPopUpLavanteID;
	}
	
	@FindBy(id = "validate-lavanteuid")
	private List<WebElement> supPopUpLavanteID1;

	public List<WebElement> supPopUpLavanteID1() {
		return supPopUpLavanteID1;
	}

	// Name
	@FindBy(css = "span[ng-bind*='.supplierName']")
	private WebElement supplierNameDetail;

	public WebElement supplierNameDetail() {
		return supplierNameDetail;
	}

	// Rank
	@FindBy(css = "span[ng-bind*='.rank']")
	private WebElement spendRankDetail;

	public WebElement spendRankDetail() {
		return spendRankDetail;
	}

	// Document type DDL
	@FindBy(css = "div[id*='fix_ocr_type'] a")
	private WebElement documentTypeDDL;

	public WebElement documentTypeDDL() {
		return documentTypeDDL;
	}

	// Supplier name search
	@FindBy(css = "button[id='fix-ocr-sup-name']")
	private WebElement supplierNameSearch;

	public WebElement supplierNameSearch() {
		return supplierNameSearch;
	}

	// Supplier look up button
	@FindBy(css = "button[id='fix-ocr-sup-name']")
	private WebElement supplierLookupBtn;

	public WebElement supplierLookupBtn() {
		return supplierLookupBtn;
	}

	// Fix OCR button
	@FindBy(css = "input[name='btnPrevious']")
	private WebElement fixOCRBtn;

	public WebElement fixOCRBtn() {
		return fixOCRBtn;
	}

	// Supplier ID
	@FindBy(css = "[ng-bind*='.lavanteUid']")
	private WebElement supplierID;

	public WebElement supplierID() {
		return supplierID;
	}

	// Audit
	@FindBy(css = "[ng-bind*='.audit']")
	private WebElement audit;

	public WebElement audit() {
		return audit;
	}
	
	//Added by Ramya
	@FindBy(css="tr[class='ng-scope'] td:nth-child(2) a")
	private List<WebElement> dateLinks;
	public List<WebElement> dateLinks(){
		return dateLinks;
	}
	
	@FindBy(css="button[id='save-button']")
	private WebElement saveButton;
	public WebElement saveButton(){
		return saveButton;
	}
	
	@FindBy(css="button[class='button_green']")
	private WebElement confirmationButton;
	public WebElement confirmationButton(){
		return confirmationButton;
		
	}
	
	// Lavante UID
	@FindBy(id = "lavanteUID")
	private WebElement lavanteUID;

	public WebElement lavanteUID() {
		return lavanteUID;
	}

	// Last Statement Date
	@FindBy(id = "statementDate")
	private WebElement lastStatementDate;

	public WebElement lastStatementDate() {
		return lastStatementDate;
	}

	// Supplier Details--Address Line 1
	@FindBy(css = "input[ng-model*='addressLine1']")
	private WebElement address1;

	public WebElement address1() {
		return address1;
	}

	// Supplier Details--City
	@FindBy(css = "input[ng-model*='.city']")
	private WebElement city;

	public WebElement city() {
		return city;
	}

	// Supplier Details--State
	@FindBy(css = "input[ng-model*='.state']")
	private WebElement state;

	public WebElement state() {
		return state;
	}

	// Supplier Details--zipcode1
	@FindBy(css = "input[ng-model*='.zipcode']")
	private WebElement zipcode1;

	public WebElement zipcode1() {
		return zipcode1;
	}

	// Supplier Details--zipcode2
	@FindBy(css = "input[ng-model*='.zipCode2']")
	private WebElement zipcode2;

	public WebElement zipcode2() {
		return zipcode2;
	}

	// Supplier Details--Country
	@FindBy(css = "input[ng-model*='.country']")
	private WebElement country;

	public WebElement country() {
		return country;
	}

	// Supplier Details--contactName
	@FindBy(css = "input[ng-model*='.contactName']")
	private WebElement contactName;

	public WebElement contactName() {
		return contactName;
	}

	// Supplier Details--contactPhone
	@FindBy(css = "input[ng-model*='.contactPhone']")
	private WebElement contactPhone;

	public WebElement contactPhone() {
		return contactPhone;
	}

	// Supplier Details--contactFax
	@FindBy(css = "input[ng-model*='.contactFax']")
	private WebElement contactFax;

	public WebElement contactFax() {
		return contactFax;
	}

	// Supplier Details--companyPhone
	@FindBy(css = "input[ng-model*='.companyPhone']")
	private WebElement companyPhone;

	public WebElement companyPhone() {
		return companyPhone;
	}

	// Supplier Details--companyFax
	@FindBy(css = "input[ng-model*='.companyFax']")
	private WebElement companyFax;

	public WebElement companyFax() {
		return companyFax;
	}

	// Buttons
	// Review button
	@FindBy(css = "#need-review-button")
	private WebElement reviewBtn;

	public WebElement reviewBtn() {
		return reviewBtn;
	}

	// Awaiting Response button
	@FindBy(css = "#awaiting-response-button")
	private WebElement awaitingResponseBtn;

	public WebElement awaitingResponseBtn() {
		return awaitingResponseBtn;
	}

	// Save button
	@FindBy(css = "#save-button")
	private WebElement saveBtn;

	public WebElement saveBtn() {
		return saveBtn;
	}

	// Save button After change - pop up -OK Button
	@FindBy(css = "[class*='dialog'] [class*='green']")
	private WebElement popupOKBtn;

	public WebElement popupOKBtn() {
		return popupOKBtn;
	}

	// Save button After change - pop up
	@FindBy(css = ".ui-dialog-titlebar #ui-id-3")
	private WebElement popUp;

	public WebElement popUp() {
		return popUp;
	}

	// Save and Dispose button
	@FindBy(css = "#save-dispose-button")
	private WebElement saveAndDisposeBtn;

	public WebElement saveAndDisposeBtn() {
		return saveAndDisposeBtn;
	}

	// Cancel button
	@FindBy(css = "#cancel-button")
	private WebElement cancelBtn;

	public WebElement cancelBtn() {
		return cancelBtn;
	}

	// Next button
	@FindBy(css = "#next-button")
	private WebElement nextBtn;

	public WebElement nextBtn() {
		return nextBtn;
	}

	// Previous button
	@FindBy(css = "#previous-button")
	private WebElement previousBtn;

	public WebElement previousBtn() {
		return previousBtn;
	}

	// Awaiting Response iFrame
	@FindBy(css = "iframe[data-iname*='awaitingResponsePopup']")
	private WebElement awaitingResponsepopUp;

	public WebElement awaitingResponsepopUp() {
		return awaitingResponsepopUp;
	}

	// Awaiting Response comment text box
	@FindBy(css = "#needs-review-comment-textarea")
	private WebElement commentTxtBox;

	public WebElement commentTxtBox() {
		return commentTxtBox;
	}

	// Awaiting Response comment box--Submit
	@FindBy(css = "#save-button")
	private WebElement submitBtn;

	public WebElement submitBtn() {
		return submitBtn;
	}

	// Credit table
	@FindBy(css = "#credit-claim-iframe")
	private WebElement creditTableiFrame;

	public WebElement creditTableiFrame() {
		return creditTableiFrame;
	}

	// Credit table--All Claims
	@FindBy(css = ".All.active span")
	private WebElement allClaimsInCreditTable;

	// Credit table--Closed Claims
	@FindBy(css = ".Close span")
	private WebElement closedClaimsInCreditTable;

	// Credit table--Credits Claims
	@FindBy(css = ".Credits span")
	private WebElement creditsClaimsInCreditTable;

	// Credit table-- Claims
	@FindBy(css = ".Claims span")
	private WebElement claimsInCreditTable;

	// Credit table -- Duplicate claims
	@FindBy(css = ".Duplicate span")
	private WebElement duplicateClaimsCountinCreditTable;

	// Credit table - Hold claims
	@FindBy(css = ".Hold span")
	private WebElement holdClaimsCountinCreditTable;

	// Credit table - Check claims
	@FindBy(css = ".Check span")
	private WebElement checkClaimsCountinCreditTable;

	// Credit table - Verify claims
	@FindBy(css = ".Verify span")
	private WebElement verifyClaimsCountinCreditTable;

	// Credit table - Pending claims
	@FindBy(css = ".Pending span")
	private WebElement pendingClaimsCountinCreditTable;

	// Credit table -- Void claims
	@FindBy(css = ".Void span")
	private WebElement voidClaimsCountinCreditTable;

	// Credit table - Refund claims
	@FindBy(css = ".Refund span")
	private WebElement refundClaimsCountinCreditTable;

	// Credit Table --Supplier Ref:
	@FindBy(css = "input[name='supplier_ref']")
	private WebElement supplierRef;

	public WebElement supplierRef() {
		return supplierRef;
	}

	// Credit Table --customer
	@FindBy(css = "input[name='customer']")
	private WebElement customer;

	public WebElement customer() {
		return customer;
	}

	// Credit Table --credit_date
	@FindBy(css = "input[name='credit_date']")
	private WebElement creditDate;

	public WebElement creditDate() {
		return creditDate;
	}

	// Credit Table --amount
	@FindBy(css = "input[name='amount']")
	private WebElement amount;

	public WebElement amount() {
		return amount;
	}

	// Credit Table --Type DDL
	@FindBy(css = "select[name='claim-type']")
	private WebElement typeDDL;

	public WebElement typeDDL() {
		return typeDDL;
	}
	
	// Credit Table --Type DDL options
		@FindBy(css = "select[name='claim-type'] option")
		private List<WebElement> typeDDLoptions;

		public List<WebElement> typeDDLoptions() {
			return typeDDLoptions;
		}

	// Credit Table --Currency DDL
	@FindBy(css = "select[name='currency']")
	private WebElement currencyDDL;

	public WebElement currencyDDL() {
		return currencyDDL;
	}
	
	// Credit Table --Currency DDL options
		@FindBy(css = "select[name='currency'] option")
		private List<WebElement> currencyDDLoptions;

		public List<WebElement> currencyDDLoptions() {
			return currencyDDLoptions;
		}

	// Credit Table --Location DDL
	@FindBy(css = "select[name='location']")
	private WebElement locationDDL;

	public WebElement locationDDL() {
		return locationDDL;
	}
	
	// Credit Table --Location DDL options
		@FindBy(css = "select[name='location'] option")
		private List<WebElement> locationDDLoptions;

		public List<WebElement> locationDDLoptions() {
			return locationDDLoptions;
		}

	// Credit Table --Claim Status DDL
	@FindBy(css = "select[name='claim-status']")
	private WebElement claimStatusDDL;

	public WebElement claimStatusDDL() {
		return claimStatusDDL;
	}
	
	// Credit Table --Claim Status DDL options
		@FindBy(css = "select[name='claim-status'] option")
		private List<WebElement> claimStatusDDLoptions;

		public List<WebElement> claimStatusDDLoptions() {
			return claimStatusDDLoptions;
		}

	// Submit check box for batching
	@FindBy(css = "input[name='submitted']")
	private WebElement chkboxCreditTableSubmit;

	public WebElement chkboxCreditTableSubmit() {
		return chkboxCreditTableSubmit;
	}

	// Link check box for Req check
	@FindBy(css = "input[name='check_req']")
	private WebElement chkboxCreditTableCheckReq;

	public WebElement chkboxCreditTableCheckReq() {
		return chkboxCreditTableCheckReq;
	}

	// Link check box for batching
	@FindBy(css = "input[name='link']")
	private WebElement chkboxCreditTableLink;

	public WebElement chkboxCreditTableLink() {
		return chkboxCreditTableLink;
	}

	//Credits Status - sub menus
	//Credits Status - All
	@FindBy(css = "[href='#'][class*='All']")
	private WebElement allCredits;

	public WebElement allCredits() {
		return allCredits;
	}
	
	//Credits Status - Closed
	@FindBy(css = "[href='#'][class='Close']")
	private WebElement closedCredits;

	public WebElement closedCredits() {
		return closedCredits;
	}

	//Credits Status - Credits
	@FindBy(css = "[href='#'][class='Credits']")
	private WebElement credits;

	public WebElement credits() {
		return credits;
	}

	//Credits Status - Claims
	@FindBy(css = "[href='#'][class='Claims']")
	private WebElement claims;

	public WebElement claims() {
		return claims;
	}

	//Credits Status - Duplicate
	@FindBy(css = "[href='#'][class='Duplicate']")
	private WebElement duplicate;

	public WebElement duplicate() {
		return duplicate;
	}

	//Credits Status - Hold
	@FindBy(css = "[href='#'][class='Hold']")
	private WebElement hold;

	public WebElement hold() {
		return hold;
	}

	//Credits Status - Check
	@FindBy(css = "[href='#'][class='Check']")
	private WebElement check;

	public WebElement check() {
		return check;
	}

	//Credits Status - Verify
	@FindBy(css = "[href='#'][class='Verify']")
	private WebElement verify;

	public WebElement verify() {
		return verify;
	}

	//Credits Status - Pending
	@FindBy(css = "[href='#'][class='Pending']")
	private WebElement pending;

	public WebElement pending() {
		return pending;
	}

	//Credits Status - Void
	@FindBy(css = "[href='#'][class='Void']")
	private WebElement voidStatus;

	public WebElement voidStatus() {
		return voidStatus;
	}

	//Credits Status - Refund
	@FindBy(css = "[href='#'][class='Refund']")
	private WebElement refund;

	public WebElement refund() {
		return refund;
	}

	//Credits Status - DuplicatePayment
	@FindBy(css = "[href='#'][class='DuplicatePayment']")
	private WebElement duplicatePayment;

	public WebElement duplicatePayment() {
		return duplicatePayment;
	}
	
	//Credit Table Supplier Reference List
	@FindBy(css = "#credit-claim-table td:nth-child(1)")
	private List<WebElement> suppRefList;
	public List<WebElement> suppRefList() {
		return suppRefList;
	}
	
	//Credit Table Supplier Reference List
	@FindBy(css = "#credit-claim-table td:nth-child(6)")
	private List<WebElement> currTypeList;
	public List<WebElement> currTypeList() {
		return currTypeList;
	}
	
	// Methods

	//Get the total count of all 3 tabs - Recognized, Unrecognized and DNA
	public int countOfDocuments(){
		int total=0;
		for(WebElement eachLink: selLinks){
			String link = eachLink.getText().toString();
			String[] linkCount = link.split("[\\(\\)]");
			int countVal=Integer.parseInt(linkCount[2]);
			total+=countVal;
		}
		return total;
	}
	
	//Validate Supplier PopUp
	public void validatePopup(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(docQueueSpan);
		String docspan = docQueueSpan.getText().trim();
		String count = "";
		if (docspan.contains("(")) {
			String[] dsa = docspan.split("[\\(\\)]");
			System.out.println("DSA: " + dsa);
			count = dsa[1];
			System.out.println("count: " + count + " length: " + count.length());
		}
		System.out.println("Count Validate: " + count + "doc span: " + docspan);
		if (count.length() > 0) {
			if (dataMap.containsKey("validate")) {
				lavanteUtils.fluentwait(lavanteUID);
				String x = lavanteUID.getText().toString();
				lavanteUtils.waitForTime(4000);
				if (supPopUpLavanteID1.size() > 0) {
					if (x.length() > 0) {
						System.out.println("Enter lavante id and validate: "+ x);
						lavanteUtils.typeString(x, supPopUpLavanteID);
						lavanteUtils.click(supPopUpValidateBtn);
					} else {
							lavanteUtils.typeString(Keys.ESCAPE, supPopUpLavanteID);
					}
				}
			}			
		} 
	}
	
	// Select Supplier from Inbound page for Recognized tab
	public boolean InboundPageSelection(LinkedHashMap<String, String> dataMap) {
		boolean flagData=false;
		tabSelection(dataMap);
		statusSelection(dataMap);
		lavanteUtils.waitForTime(3000);
	if(date.size() > 0){
		flagData=true;
		if (dataMap.containsKey("SuppName")) {
			String data = dataMap.get("SuppName");
			if (data.equalsIgnoreCase("ANY")) {
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click(date.get(0));
			}
			else{
				//code here to select the passed supplier
			}
		}
		validatePopup(dataMap);
	  }
	return flagData;
	}

	private void statusSelection(LinkedHashMap<String, String> dataMap) {
		// TODO Auto-generated method stub DocSelectionType
		if(dataMap.containsKey("DocSelectionType")){
			if(dataMap.get("DocSelectionType").equalsIgnoreCase("Statements")){
				lavanteUtils.click(statementsCount);
			}
			else if(dataMap.get("DocSelectionType").equalsIgnoreCase("Verifications")){
				lavanteUtils.click(verificationsCount);				
			}
			else if(dataMap.get("DocSelectionType").equalsIgnoreCase("Check")){
				lavanteUtils.click(checksCount);				
			}
			else if(dataMap.get("DocSelectionType").equalsIgnoreCase("Correspondence")){
				lavanteUtils.click(correspondenceCount);				
			}
			else if(dataMap.get("DocSelectionType").equalsIgnoreCase("DuplicatePayments")){
				lavanteUtils.click(duplicateCount);				
			}
			else if(dataMap.get("DocSelectionType").equalsIgnoreCase("Profiles")){
				lavanteUtils.click(profilesCount);				
			}
		}
		
	}

	public void tabSelection(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("TabName")){
			if(dataMap.get("TabName").equalsIgnoreCase("Recognized")){
				lavanteUtils.click(recognizedTab);
			}
			else if(dataMap.get("TabName").equalsIgnoreCase("Unrecognized")){
				lavanteUtils.click(unRecognizedTab);				
			}
			else{
				lavanteUtils.click(dnaTab);
			}
		}
		
	}

	// Enter Credits
	public void outboundCreditDataPages(LinkedHashMap<String, String> dataMap){
		creditStatusSelection(dataMap);
		fillCredits(dataMap);
		documentActionComments(dataMap);
		dataPageAction(dataMap);
	}
	
	private void creditStatusSelection(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("CreditStatus")){
			if(dataMap.get("CreditStatus").equalsIgnoreCase("All")){
				lavanteUtils.click(allCredits);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Closed")){
				lavanteUtils.click(closedCredits);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Credits")){
				lavanteUtils.click(credits);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Claims")){
				lavanteUtils.click(claims);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Duplicate")){
				lavanteUtils.click(duplicate);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Hold")){
				lavanteUtils.click(hold);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Check")){
				lavanteUtils.click(check);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Verify")){
				lavanteUtils.click(verify);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Pending")){
				lavanteUtils.click(pending);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Void")){
				lavanteUtils.click(voidStatus);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("Refund")){
				lavanteUtils.click(refund);
			}
			else if(dataMap.get("CreditStatus").equalsIgnoreCase("DuplicatePayment")){
				lavanteUtils.click(duplicatePayment);
			}
		}
		
	}

	private void documentActionComments(LinkedHashMap<String, String> dataMap) {
		// TODO Auto-generated method stub
		
	}

		// Fill Credits
		public void fillCredits(LinkedHashMap<String, String> dataMap){
			lavanteUtils.switchtoFrame(creditTableiFrame);
			if (dataMap.containsKey("SupplierRef")) {
				lavanteUtils.typeString(dataMap.get("SupplierRef"), supplierRef);
			}
	
			if (dataMap.containsKey("Customer")) {
				lavanteUtils.typeString(dataMap.get("Customer"), customer);
	
			}
			if (dataMap.containsKey("CreditDate")) {
				lavanteUtils.typeString(dataMap.get("CreditDate"), creditDate);
			}
	
			if (dataMap.containsKey("Amount")) {
				lavanteUtils.typeString(dataMap.get("Amount"), amount);
			}
						
			if (dataMap.containsKey("Type")) {
				String data=dataMap.get("Type");
				lavanteUtils.fluentwait(typeDDL);
				//lavanteUtils.waitForTime(10000);	
				lavanteUtils.click(typeDDL);
				//lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(typeDDLoptions.get(0));
				lavanteUtils.selectbyvisibiletxt(data,typeDDL);
				lavanteUtils.switchtoFrame(creditTableiFrame);
			}
			
			if (dataMap.containsKey("Currency")) {
				String data=dataMap.get("Currency");
				lavanteUtils.fluentwait(currencyDDL);
				//lavanteUtils.waitForTime(10000);	
				lavanteUtils.click(currencyDDL);
				//lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(currencyDDLoptions.get(0));
				lavanteUtils.selectbyvisibiletxt(data,currencyDDL);
				lavanteUtils.switchtoFrame(creditTableiFrame);
			}
			
			if (dataMap.containsKey("LocationBU")) {
				String data=dataMap.get("LocationBU");
				lavanteUtils.fluentwait(locationDDL);
				//lavanteUtils.waitForTime(10000);	
				lavanteUtils.click(locationDDL);
				//lavanteUtils.switchtoFrame(null);
				//lavanteUtils.fluentwait(locationDDLoptions.get(0));
				lavanteUtils.selectbyvisibiletxt(data,locationDDL );
				lavanteUtils.switchtoFrame(creditTableiFrame);
			}
			
			if (dataMap.containsKey("ClaimStatus")) {
				String data=dataMap.get("ClaimStatus");
				lavanteUtils.fluentwait(claimStatusDDL);
				//lavanteUtils.waitForTime(10000);	
				lavanteUtils.click(claimStatusDDL);
				//lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(claimStatusDDLoptions.get(0));
				lavanteUtils.selectbyvisibiletxt(data,claimStatusDDL);
				lavanteUtils.switchtoFrame(creditTableiFrame);
			}			
	
			if(dataMap.containsKey("Submit")){
				if(!chkboxCreditTableSubmit.isSelected()){
					lavanteUtils.click(chkboxCreditTableSubmit);
				}
			}
			
			if(dataMap.containsKey("ReqCheck")){
				if(!chkboxCreditTableCheckReq.isSelected()){
					lavanteUtils.click(chkboxCreditTableCheckReq);
				}
			}
			
			if(dataMap.containsKey("Link")){
				if(!chkboxCreditTableLink.isSelected()){
					lavanteUtils.click(chkboxCreditTableLink);
				}
			}
			
		}
		
	// Form Credits
		public void dataPageAction(LinkedHashMap<String, String> dataMap){
			lavanteUtils.switchtoFrame(null);
			 if(dataMap.containsKey("Save")){
				 lavanteUtils.fluentwait(saveBtn);
				 lavanteUtils.click(saveBtn);
				 lavanteUtils.click(popupOKBtn);				 
			 }
			 
			 if(dataMap.containsKey("Cancel")){
				 lavanteUtils.click(saveBtn);
			 } 
			 validatePopup(dataMap);			
		}
}