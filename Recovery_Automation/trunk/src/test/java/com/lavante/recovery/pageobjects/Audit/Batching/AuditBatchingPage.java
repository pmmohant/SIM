package com.lavante.recovery.pageobjects.Audit.Batching;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

public class AuditBatchingPage {
	LavanteUtils lavanteUtils = new LavanteUtils();

	// public WebDriver driver = null;

	public AuditBatchingPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	// iFrame for Un-Batched Credits
	@FindBy(css = "iframe[id*='unbatch_credits']")
	private WebElement IFRAMEUnBatchedCredits;

	public WebElement IFRAMEUnBatchedCredits() {
		return IFRAMEUnBatchedCredits;
	}

	// Open Credits
	// [id='iframe_page'] table:nth-child(2) tbody td:nth-child(1)
	@FindBy(css = "a[href*='referer=batchingPage.lvp']")
	private List<WebElement> openCredits;

	public List<WebElement> openCredits() {
		return openCredits;
	}

	// Batch Summary
	// iFrame for Batch Summary
	@FindBy(css = "iframe[id*='batch_summary']")
	private WebElement IFRAMEBatchSummary;

	public WebElement IFRAMEBatchSummary() {
		return IFRAMEBatchSummary;
	}

	// Batch ID
	@FindBy(css = "table[id='batch_summary'] tbody td:nth-child(1)")
	private WebElement batchID;

	public WebElement batchID() {
		return batchID;
	}

	// Summary Date
	@FindBy(css = "table[id='batch_summary'] tbody td:nth-child(2)")
	private WebElement summaryDate;

	public WebElement summaryDate() {
		return summaryDate;
	}

	// Summary - Claims Total
	@FindBy(css = "table[id='batch_summary'] tbody td:nth-child(3)")
	private WebElement claimsTotal;

	public WebElement claimsTotal() {
		return claimsTotal;
	}

	// Summary - Total Number of Claims
	@FindBy(css = "table[id='batch_summary'] tbody td:nth-child(4)")
	private WebElement numberofClaims;

	public WebElement numberofClaims() {
		return numberofClaims;
	}
	
	@FindBy(css = "#batch_summary td:nth-child(4)")
	private List<WebElement> noOfClaimsList;

	public List<WebElement> noOfClaimsList() {
		return noOfClaimsList;
	}

	// Summary - Batch type
	@FindBy(css = "table[id='batch_summary'] tbody td:nth-child(5)")
	private WebElement batchType;

	public WebElement batchType() {
		return batchType;
	}
	
	@FindBy(css = "#batch_summary td:nth-child(5)")
	private List<WebElement> batchTypeList;

	public List<WebElement> batchTypeList() {
		return batchTypeList;
	}

	// Batch Details table
	// iFrame for Batch Details table
	@FindBy(css = "iframe[id*='batch_details']")
	private WebElement IFRAMEauditBatchingDetails;

	public WebElement IFRAMEauditBatchingDetails() {
		return IFRAMEauditBatchingDetails;
	}

	// Supplier name
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(1)")
	private List<WebElement> supplierName;

	public List<WebElement> supplierName() {
		return supplierName;
	}

	// Line Item
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(2)")
	private List<WebElement> lineItem;

	public List<WebElement> lineItem() {
		return lineItem;
	}

	// Reference
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(3)")
	private List<WebElement> reference;

	public List<WebElement> reference() {
		return reference;
	}

	// Credit Date
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(4)")
	private List<WebElement> creditDate;

	public List<WebElement> creditDate() {
		return creditDate;
	}

	// Location
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(5)")
	private List<WebElement> location;

	public List<WebElement> location() {
		return location;
	}

	// Amount
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(6)")
	private List<WebElement> amount;

	public List<WebElement> amount() {
		return amount;
	}

	// Currency
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(7)")
	private List<WebElement> currency;

	public List<WebElement> currency() {
		return currency;
	}

	// Claim Status
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(9)")
	private List<WebElement> claimStatus;

	public List<WebElement> claimStatus() {
		return claimStatus;
	}

	// Submit
	@FindBy(css = "[id*='batch-details'] tbody tr td:nth-child(10)")
	private List<WebElement> submit;

	public List<WebElement> submit() {
		return submit;
	}

	// Preview button
	@FindBy(id = "create")
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
	
	// Cancel Batch button
	@FindBy(id = "batch_cancel")
	private WebElement cancelBatchBtn;

	public WebElement cancelBatchBtn() {
		return cancelBatchBtn;
	}

	// Batch summary preview Frame
	// iFRAME
	@FindBy(css = "iframe[src*='preCommitPreview.lvp']")
	private WebElement IFRAMEpreview;

	public WebElement IFRAMEpreview() {
		return IFRAMEpreview;
	}

	// Preview - Batch ID
	@FindBy(css = "table[id='preview_batch_summary'] tbody td:nth-child(1)")
	private WebElement previewBatchID;

	public WebElement previewBatchID() {
		return previewBatchID;
	}

	// Preview - Date
	@FindBy(css = "table[id='preview_batch_summary'] tbody td:nth-child(2)")
	private WebElement previewDate;

	public WebElement previewDate() {
		return previewDate;
	}

	// Preview - Claims Total
	@FindBy(css = "table[id='preview_batch_summary'] tbody td:nth-child(3)")
	private WebElement previewClaimsTotal;

	public WebElement previewClaimsTotal() {
		return previewClaimsTotal;
	}
	
	

	// Preview - Total Number of Claims
	@FindBy(css = "table[id='preview_batch_summary'] tbody td:nth-child(4)")
	private WebElement previewNumberofClaims;

	public WebElement previewNumberofClaims() {
		return previewNumberofClaims;
	}

	// Preview - Batch type
	@FindBy(css = "table[id='preview_batch_summary'] tbody td:nth-child(5)")
	private WebElement previewBatchType;

	public WebElement previewBatchType() {
		return previewBatchType;
	}

	// Commit button
	@FindBy(id = "commit")
	private WebElement commitBtn;

	public WebElement commitBtn() {
		return commitBtn;
	}

	// Cancel button
	@FindBy(id = "cancel")
	private WebElement cancelBtn;

	public WebElement cancelBtn() {
		return cancelBtn;
	}

	// Batched claims
	// IFRAME for batched claims
	@FindBy(css = "iframe[id='batch_claims']")
	private WebElement IFRAMEbatchedClaims;

	public WebElement IFRAMEbatchedClaims() {
		return IFRAMEbatchedClaims;
	}

	// Batched claims - Date
	@FindBy(css = "table[id='batched-claims'] tbody td:nth-child(1) a")
	private List<WebElement> batchedClaimsDate;

	public List<WebElement> batchedClaimsDate() {
		return batchedClaimsDate;
	}

	// Batched claims - Batch ID
	@FindBy(css = "table[id='batched-claims'] tbody td:nth-child(2)")
	private List<WebElement> batchedClaimsID;

	public List<WebElement> batchedClaimsID() {
		return batchedClaimsID;
	}

	// Batched claims - Open/Total
	@FindBy(css = "table[id='batched-claims'] tbody td:nth-child(3)")
	private List<WebElement> batchedClaimsTotal;

	public List<WebElement> batchedClaimsTotal() {
		return batchedClaimsTotal;
	}

	// Batched claims - Amount
	@FindBy(css = "table[id='batched-claims'] tbody td:nth-child(4)")
	private List<WebElement> batchedClaimsAmount;

	public List<WebElement> batchedClaimsAmount() {
		return batchedClaimsAmount;
	}

	// Batched claims - Type
	@FindBy(css = "table[id='batched-claims'] tbody td:nth-child(5)")
	private List<WebElement> batchedClaimsType;

	public List<WebElement> batchedClaimsType() {
		return batchedClaimsType;
	}

	// Methods

	// Form batching
	public void formBatching(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Preview")) {
			lavanteUtils.click(previewBtn);
			lavanteUtils.waitForTime(4000);
		}

		if (dataMap.containsKey("Create")) {
			lavanteUtils.click(createBtn);
			lavanteUtils.waitForTime(4000);
		}

		if (dataMap.containsKey("Commit")) {
			lavanteUtils.switchtoFrame(IFRAMEpreview);
			lavanteUtils.click(commitBtn);
			lavanteUtils.waitForTime(4000);
		}
	}

}
