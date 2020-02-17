package com.lavante.recovery.pageobjects.Audit.Invoice;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

public class AuditInvoicePage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;

	public AuditInvoicePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	// IFRAME - Invoice Summary
	@FindBy(css = "iframe[id='invoice_summary']")
	private WebElement IFRAMEinvoiceSummary;

	public WebElement IFRAMEinvoiceSummary() {
		return IFRAMEinvoiceSummary;
	}

	// Invoice Number from Invoice Summary
	@FindBy(css = "div[id*='invoice_date']:nth-child(3) span")
	private WebElement invoiceNumber;

	public WebElement invoiceNumber() {
		return invoiceNumber;
	}
	
	//Currency type
	@FindBy(css = "table[class='data_table'] tbody tr:nth-child(4) td")
	private WebElement currencyType;

	public WebElement currencyType() {
		return currencyType;
	}
		
	//Invoice Date
		@FindBy(css = "table[class='data_table'] tbody tr:nth-child(5) td")
		private WebElement invoiceDate;

		public WebElement invoiceDate() {
			return invoiceDate;
		}
		
		//Total Amount
		@FindBy(css = "table[id='auditInvoiceSummaryDetails'] tbody tr:nth-child(8) td:nth-child(2)")
		private WebElement totalAmount;

		public WebElement totalAmount() {
			return totalAmount;
		}

	// IFRAME - Invoice details
	@FindBy(css = "iframe[id='invoice_details']")
	private WebElement IFRAMEinvoiceDetails;

	public WebElement IFRAMEinvoiceDetails() {
		return IFRAMEinvoiceDetails;
	}

	// Credit tab
	@FindBy(css = "a[href*='Credit']")
	private WebElement creditTab;

	public WebElement creditTab() {
		return creditTab;
	}

	// Void tab
	@FindBy(css = "a[href*='Void']")
	private WebElement voidTab;

	public WebElement voidTab() {
		return voidTab;
	}

	// Refund tab
	@FindBy(css = "a[href*='Refund']")
	private WebElement refundTab;

	public WebElement refundTab() {
		return refundTab;
	}

	// Credit table
	// Supplier name
	@FindBy(css = "table[id='invoiceDetails'] tbody td:nth-child(1)")
	private List<WebElement> suppName;

	public List<WebElement> suppName() {
		return suppName;
	}

	// Claim ID
	@FindBy(css = "table[id='invoiceDetails'] tbody td:nth-child(2)")
	private List<WebElement> claimID;

	public List<WebElement> claimID() {
		return claimID;
	}

	// Supplier Reference
	@FindBy(css = "table[id='invoiceDetails'] tbody td:nth-child(3)")
	private List<WebElement> supplierReference;

	public List<WebElement> supplierReference() {
		return supplierReference;
	}

	// Credit Date
	@FindBy(css = "table[id='invoiceDetails'] tbody td:nth-child(4)")
	private List<WebElement> creditDate;

	public List<WebElement> creditDate() {
		return creditDate;
	}

	// Amount
	@FindBy(css = "table[id='invoiceDetails'] tbody td:nth-child(5)")
	private List<WebElement> amount;

	public List<WebElement> amount() {
		return amount;
	}

	// Currency Code
	@FindBy(css = "table[id='invoiceDetails'] tbody td:nth-child(6)")
	private List<WebElement> currencyCode;

	public List<WebElement> currencyCode() {
		return currencyCode;
	}

	// Preview button
	@FindBy(id = "Preview")
	private WebElement previewBtn;

	public WebElement previewBtn() {
		return previewBtn;
	}

	// Create button
	@FindBy(id = "commit")
	private WebElement createBtn;

	public WebElement createBtn() {
		return createBtn;
	}

	// IFRAME - Audit Invoice Batch Preview
	@FindBy(css = "iframe[src*='auditInvoiceBatchPreview']")
	private WebElement IFRAMEauditInvoicePreview;

	public WebElement IFRAMEauditInvoicePreview() {
		return IFRAMEauditInvoicePreview;
	}

	// BatchID from Select batches frame
	@FindBy(css = "table[id='Select_Batches'] tbody td:nth-child(2)")
	private WebElement selectBatchID;

	public WebElement selectBatchID() {
		return selectBatchID;
	}

	// BatchDate from Select batches frame
	@FindBy(css = "table[id='Select_Batches'] tbody td:nth-child(3)")
	private WebElement selectBatchDate;

	public WebElement selectBatchDate() {
		return selectBatchDate;
	}

	// BatchType from Select batches frame
	@FindBy(css = "table[id='Select_Batches'] tbody td:nth-child(4)")
	private WebElement selectBatchType;

	public WebElement selectBatchType() {
		return selectBatchType;
	}

	// Ok button
	@FindBy(id = "SubmitBatch")
	private WebElement okayBtn;

	public WebElement okayBtn() {
		return okayBtn;
	}

	// Cancel button
	@FindBy(id = "cancel")
	private WebElement cancelBtn;

	public WebElement cancelBtn() {
		return cancelBtn;
	}

	// IFRAME - Audit Invoice Summary Preview
	@FindBy(css = "iframe[src*='auditInvoiceSummaryPreview']")
	private WebElement IFRAMEinvoiceSummaryPreview;

	public WebElement IFRAMEinvoiceSummaryPreview() {
		return IFRAMEinvoiceSummaryPreview;
	}

	// Invoice Summary Preview
	// Invoice number from Invoice Summary Preview
	@FindBy(css = "table[id='Select_Batches'] td:nth-child(1)")
	private WebElement invoiceNumberPreview;

	public WebElement invoiceNumberPreview() {
		return invoiceNumberPreview;
	}

	// Invoice Date from Invoice Summary Preview
	@FindBy(css = "table[id='Select_Batches'] td:nth-child(2)")
	private WebElement invoiceDatePreview;

	public WebElement invoiceDatePreview() {
		return invoiceDatePreview;
	}

	// Invoice Amount from Invoice Summary Preview
	@FindBy(css = "table[id='Select_Batches'] td:nth-child(3)")
	private WebElement invoiceAmountPreview;

	public WebElement invoiceAmountPreview() {
		return invoiceAmountPreview;
	}

	// Invoice Type from Invoice Summary Preview
	@FindBy(css = "table[id='Select_Batches'] td:nth-child(4)")
	private WebElement invoiceTypePreview;

	public WebElement invoiceTypePreview() {
		return invoiceTypePreview;
	}
	
	//Commit Invoice Button
	@FindBy(id="commitInvoice")
	private WebElement commitInvoiceBtn;
	
	public WebElement commitInvoiceBtn(){
		return commitInvoiceBtn;
	}
	
	//Count of pages
	@FindBy(id="total_pages")
	private WebElement totalPages;
	
	public WebElement totalPages(){
		return totalPages;
	}
	
	//Next page link
	@FindBy(css="div[class='pagination'] a[title*='Go to next']")
	private WebElement nextPageLink;
	
	public WebElement nextPageLink(){
		return nextPageLink;
	}
	
	
	//Last page link
		@FindBy(css="div[class='pagination'] a[title*='Go to last']")
		private WebElement lastPageLink;
		
		public WebElement lastPageLink(){
			return lastPageLink;
		}
		
		//currentPage input field
		@FindBy(id="currentPage")
		private WebElement currentPage;
		
		public WebElement currentPage(){
			return currentPage;
		}
		
		
	//Methods
	//Method for pagination
	public LinkedHashMap<String, String> pagination(LinkedHashMap<String, String> dataMap){
		//get that size value=2
		int count = Integer.parseInt(dataMap.get("size"));
		int csize=0;
		lavanteUtils.switchtoFrame(IFRAMEinvoiceDetails);
		if(Integer.parseInt(totalPages.getText().trim()) > 0 ){
			System.out.println("Pagination exists..!");
			//look in for the value in the current page and if it does not exists, then click on next page icon
			String searchKey="";
			String searchKey1 = dataMap.get("ClaimId");
			String s[] = searchKey1.split("_ClaimId#");
			for(String s2: s)
			{
				System.out.println("s2: "+s2);
				searchKey=s2;
			int size=claimID.size();
			System.out.println("claimID.size(): " + claimID.size());
			for(int i=0; i<size; i++){
				if(claimID.get(i).getText().trim().equalsIgnoreCase(searchKey)){
					dataMap.put(claimID.get(i).getText().trim()+"_SupplierName", suppName.get(i).getText().trim());
					dataMap.put(claimID.get(i).getText().trim()+"_ClaimId", claimID.get(i).getText().trim());
					dataMap.put(claimID.get(i).getText().trim()+"_Reference", supplierReference.get(i).getText().trim());
					dataMap.put(claimID.get(i).getText().trim()+"_CreditDate", creditDate.get(i).getText().trim());
					dataMap.put(claimID.get(i).getText().trim()+"_Amount", amount.get(i).getText().trim());
					dataMap.put(claimID.get(i).getText().trim()+"_CurrencyCode", currencyCode.get(i).getText().trim());
					csize=csize+1;
					
					//navigate to 1st page to search for the second element
					if(Integer.parseInt(totalPages.getText().trim()) > 1){
					lavanteUtils.typeString("1", currentPage);
					currentPage.sendKeys(Keys.ENTER);
					}
					
					lavanteUtils.waitForTime(1000);
					break;
				}
				if(i==claimID.size()-1 && nextPageLink.isEnabled()){
					i=0;
					lavanteUtils.click(nextPageLink);
					lavanteUtils.waitForTime(1000);
					size=claimID.size();
					System.out.println("claimID.size(): " + claimID.size());					
				}				
			}
		}
	}
		lavanteUtils.switchtoFrame(null);
		dataMap.put("flag", ""+(count==csize));
		return dataMap;
	}
		
	public void auditInvoiceActions(LinkedHashMap<String, String> dataMap){
		formInvoices(dataMap);
	}
		
	public void fillInvoices(LinkedHashMap<String, String> dataMap){
		
	}
	
	public void formInvoices(LinkedHashMap<String, String> dataMap){
		if(dataMap.containsKey("Preview")){
			lavanteUtils.click(previewBtn);
		}
		
		if(dataMap.containsKey("Create")){
			lavanteUtils.click(createBtn);
		}
		
		if(dataMap.containsKey("Cancel")){
			lavanteUtils.click(cancelBtn);
		}
		
		if(dataMap.containsKey("Commit")){
			lavanteUtils.switchtoFrame(IFRAMEinvoiceSummaryPreview);
			lavanteUtils.click(commitInvoiceBtn);
		}
	}
} 
