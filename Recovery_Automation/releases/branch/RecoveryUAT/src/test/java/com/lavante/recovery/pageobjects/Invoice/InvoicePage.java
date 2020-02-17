package com.lavante.recovery.pageobjects.Invoice;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.lavante.recovery.Common.Util.LavanteUtils;


public class InvoicePage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public InvoicePage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	
	//Invoices link
	//FindBy(linkText = "Invoices")
	@FindBy(css="a[href*='/recovery/invoice.lvp']")
	private WebElement invoicesLink;
	public WebElement invoicesLink(){
		return invoicesLink;
	}
	
	//USD link
	@FindBy(css="a[href*='#']")
	private WebElement usdLink;
	public WebElement usdLink(){
		return usdLink;
	}
	
	//Invoice Summary table
	@FindBy(css="ShowSummary")
	private WebElement showSummaryTable;
	public WebElement showSummaryTable(){
		return showSummaryTable;
	}
	
	
	//Invoice number dropdown
	@FindBy(id ="invoiceNumber_chosen")
	private WebElement invoiceNumber;
	public WebElement invoiceNumber(){
		return invoiceNumber;
	}
	
	@FindBy(css="div[id='invoiceNumber_chosen'] a[class='chosen-single'] span")
	private WebElement invoiceNumberDropdown;
	public WebElement invoiceNumberDropdown(){
		return invoiceNumberDropdown;
		
	}
	
	//Invoice Summary
	
	
	//Invoice summary title
	@FindBy(css="table tr td span")
	private WebElement invoiceSummaryTitle;
	public WebElement invoiceSummaryTitle(){
		return invoiceSummaryTitle;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement invoiceNumberH;
	public WebElement invoiceNumberH(){
		return invoiceNumberH;
	}
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(1) td:nth-child(2)")
	private WebElement invoiceNumberD;
	public WebElement invoiceNumberD(){
		return invoiceNumberD;
	}
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(2) td:nth-child(1)")
	private WebElement poNumberForLavanteH;
	public WebElement poNUmberForLavanteH(){
		return poNumberForLavanteH;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(2) td:nth-child(2)")
	private WebElement poNumberForLavanteD;
	public WebElement poNumberForLavanteD(){
		return poNumberForLavanteD;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(3) td:nth-child(1)")
	private WebElement vendorH;
	public WebElement vendorH(){
		return vendorH;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(3) td:nth-child(2)")
	private WebElement vendorD;
	public WebElement vendorD(){
		return vendorD;
	}
	
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(4) td:nth-child(1)")
	private WebElement currencyH;
	public WebElement currencyH(){
		return currencyH;
	}
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(4) td:nth-child(2)")
	private WebElement currencyD;
	public WebElement currencyD(){
		return currencyD;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(5) td:nth-child(1)")
	private WebElement paymentTFLH;
	public WebElement paymentTFLH(){
		return paymentTFLH;
	}
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(5) td:nth-child(2)")
	private WebElement paymentTFLD;
	public WebElement paymentTFLD(){
		return paymentTFLD;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(6) td:nth-child(1)")
	private WebElement datePaidH;
	public WebElement datePaidH(){
		return datePaidH;
	}
	
	
	@FindBy(css="table[id='invoiceSummary'] tbody tr:nth-child(6) td:nth-child(2)")
	private WebElement datePaidD;
	public WebElement datePaidD(){
		return datePaidD;
	}
	
	
	
	
	//Recovery Billable Amount Calculation
	
	
	@FindBy(css="strong[style*='vertical-align: -6px;font-size: 12px;']")
	private WebElement recoveryBillableACTitle;
	public WebElement recoveryBillableACTitle(){
		return recoveryBillableACTitle;
	}
	
	@FindBy(css="a[href*='exchangeRatePopUp.lvp?q9s2Yhd7W3=6495']")
	private WebElement exchangeRateLink;
	public WebElement exchangeRateLink(){
		return exchangeRateLink;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(1) td")
	private WebElement batchesValue;
	public WebElement batchesValue(){
		return batchesValue;
	}
	
	
	
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(2) td:nth-child(2)")
	private WebElement totalFindingsForPCost;
	public WebElement totalFindingsForPCost(){
		return totalFindingsForPCost;
	}
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(2) td:nth-child(3)")
	private WebElement totalFindingsForPCrncy;
	public WebElement totalFoindingsForPCrncy(){
		return totalFindingsForPCrncy;
	}
	
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(3) td:nth-child(2)")
	private WebElement totalLessRefundsCost;
	public WebElement totalLessRefundsCost(){
		return totalLessRefundsCost;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(3) td:nth-child(2)")
	private WebElement totalLessRefundsCrncy;
	public WebElement totalLessRefundsCrncy(){
		return totalLessRefundsCrncy;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(4) td:nth-child(2)")
	private WebElement totalLessVoids;
	public WebElement totalLessVoids(){
		return totalLessVoids;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(4) td:nth-child(3)")
	private WebElement totalLessVoidsCrncy;
	public WebElement totalLessVoidCrncy(){
		return totalLessVoidsCrncy;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(5) td:nth-child(2)")
	private WebElement netFindingsCost;
	public WebElement netFindingsCost(){
		return netFindingsCost;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(5) td:nth-child(2)")
	private WebElement netFindingsCrncy;
	public WebElement netFindingsCrncy(){
		return netFindingsCrncy;
	}
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(6) td:nth-child(2)")
	private WebElement rateCost;
	public WebElement rateCost(){
		return rateCost;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(6) td:nth-child(3)")
	private WebElement rateCrncy;
	public WebElement rateCrncy(){
		return rateCrncy;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(7) td:nth-child(2)")
	private WebElement amountCost;
	public WebElement amountCost(){
		return amountCost;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(7) td:nth-child(3)")
	private WebElement amountCrncy;
	public WebElement amountCrncy(){
		return amountCrncy;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(8) td:nth-child(2)")
	private WebElement totalAmountDInvCost;
	public WebElement totalAmountDInvCost(){
		return totalAmountDInvCost;
	}
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(8) td:nth-child(3)")
	private WebElement totalAmountDInvCrncy;
	public WebElement totalAmountDInvCrncy(){
		return totalAmountDInvCrncy;
	}
	
	
	
	//Credit link
	@FindBy(css="a[href*='credit']")
	private WebElement creditLink;
	public WebElement creditLink(){
		return creditLink;
	}
	
	//Void link
	@FindBy(css="a[href*='void']")
	private WebElement voidLink;
	public WebElement voidLink(){
		return voidLink;
	}
	
	//Refund link
	@FindBy(css="a[href*='refund']")
	public WebElement refundLink;
	public WebElement refundLink(){
		return refundLink;
	}
	
	
	//Supplier details table
	@FindBy(id="00V")
	private WebElement supplierDetailsTable;
	public WebElement supplierDetailsTable(){
		return supplierDetailsTable;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(1)")
	private WebElement supplierH;
	public WebElement supplierH(){
		return supplierH;
	}
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(2)")
	private WebElement supplierIDH;
	public WebElement supplierIDH(){
		return supplierIDH;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(3)")
	private WebElement commentsH;
	public WebElement commentsH(){
		return commentsH;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(4)")
	private WebElement organizationH;
	public WebElement organizationH(){
		return organizationH;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(5)")
	private WebElement claimId;
	public WebElement claimId(){
		return claimId;
	}
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(6)")
	private WebElement refernceH;
	public WebElement referenceH(){
		return refernceH;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(7)")
	private WebElement creditDateH;
	public WebElement creditDateH(){
		return creditDateH;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(8)")
	private WebElement amountH;
	public WebElement amountH(){
		return amountH;
	}
	
	
	@FindBy(css="table[id= '00V'] tr th:nth-child(9)")
	private WebElement currencyHSupplierTable;
	public WebElement currencyHSupplierTable(){
		return currencyH;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(1)")
	private WebElement supplierD;
	public WebElement supplierD(){
		return supplierD;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(2)")
	private WebElement supplierIdD;
	public WebElement supplierIdD(){
		return supplierIdD;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(3)")
	private WebElement commentsD;
	public WebElement commentsD(){
		return commentsD;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(4)")
	private WebElement organizationD;
	public WebElement organzationD(){
		return organizationD;
	}
	
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(5)")
	private WebElement claimIdD;
	public WebElement claimIdD(){
		return claimIdD;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(6)")
	private WebElement reference;
	public WebElement reference(){
		return reference;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(7)")
	private WebElement creditDateD;
	public WebElement creditDateD(){
		return creditDateD;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(8)")
	private WebElement amountD;
	public WebElement amountD(){
		return amountD;
	}
	
	
	@FindBy(css="table[id='00V'] tbody tr td:nth-child(9)")
	private WebElement currencyDSupplierDetails;
	public WebElement currencyDSupplierDetails(){
		return currencyD;
	}
	
	
	//Back button
	@FindBy(css="input[class*='button_blue']")
	private WebElement backButton;
	public WebElement backButton(){
		return backButton;
	}
	
	
	@FindBy(css="span[class='text-green']:nth-child(3)")
	private WebElement date;
	public WebElement date(){
		return date;
	}
	
	@FindBy(css="td[class='caption'] span:nth-child(1)")
	private WebElement invoiceNumber1;
	public WebElement invoiceNumber1(){
		return invoiceNumber1;
	}

	public void InvoiceFilling(LinkedHashMap<String,String> dataMap) throws InterruptedException{
		fillInvoice(dataMap);
	}



	private void fillInvoice(LinkedHashMap<String, String> dataMap) throws InterruptedException {
		if(dataMap.containsKey("invoiceNumber")){
			//wait(3000);
			String data=dataMap.get("invoiceNumber");
			invoiceNumber().click();
			//lavanteUtils.selectvalueFrmDpdn(data);
			//lavanteUtils.selectbyvisibiletxt(data, invoiceNumber);
			lavanteUtils.selectFrmDpdn(data);
		}
		
	}	
	
	
	@FindBy(css="table[id='invoiceSummaryDetails'] tbody tr:nth-child(1) td")
	private WebElement recoveryBillableAC;
	public WebElement recoveryBillableAC(){
		return recoveryBillableAC;
	}
		
			
			
		
		/*if(dataMap.containsKey("InvoiceNumber")){
			InvoiceType.sendKeys(dataMap.get("InvoiceType")));
			
			String das=dataMap.get("InvoiceType");
			if(das.equalsIgnoreCase("Credit")){
			//	lavanteUtils.click(creditTab);	
			}
			
		}
		if(dataMap.containsKey("SupplierRef")){
			//	waitforPageLoad(supplierRef);
				supplierRef.sendKeys(dataMap.get("SupplierRef") + nextInt);
				lavanteUtils.waitForTime(2000);
			}
			
			if(dataMap.containsKey("Customer")){
				customerField.sendKeys(dataMap.get("Customer") + nextInt);
				lavanteUtils.waitForTime(2000);*/
			}
		
		
	
	
	
	
	
	
	

