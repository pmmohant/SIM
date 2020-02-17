package com.lavante.recovery.pageobjects.Dashboard;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.lavante.recovery.Common.Util.LavanteUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

public class ClaimsPage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public ClaimsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	
	
	@FindBy(linkText = "Dashboards")
	//@FindBy(css="a[href='/recovery/dashboard.lvp']']")
	private WebElement dashboardsLink;
	public WebElement dashboardsLink(){
		return dashboardsLink;
	}
	
	
	@FindBy(css="#content div[class*='box_rounded  align_left blue'] tr td a")
	private  List<WebElement> itemsForMyReviewLinks;
	public List<WebElement> itemsForMyReviewLinks(){
		return itemsForMyReviewLinks;
	}
	
	@FindBy(css="#open-claims td")
	private List<WebElement> openClaimsLavante;
	public List<WebElement> openClaimsLavante(){
		return openClaimsLavante;
	}
	
	@FindBy(css="#open-claims td a")
	private List<WebElement> openClaimsLavanteLinks;
	public List<WebElement> openClaimsLavanteLinks(){
		return openClaimsLavanteLinks;
	}
	
	@FindBy(css="#claim-process td a")
	private List<WebElement> claimsInProcessLinks;
	public List<WebElement> claimsInProcessLinks(){
		return claimsInProcessLinks;
	}
	
	@FindBy(css="#hold-claims td a ")
	private List<WebElement> claimsOnHoldLinks;
	public List<WebElement> claimsOnHoldLinks(){
		return claimsOnHoldLinks;
	}
	
	
	
	
	//@FindBy(linkText= "Claims")
	@FindBy(css="a[href='/recovery/claimDashboard.lvp']")
	private WebElement claimsLink;
	public WebElement claimsLink(){
		return claimsLink;
	}
	
	@FindBy(css="#open-claims td:nth-child(1)")
	private WebElement openClaimsFrmLavanteElement1;
	public WebElement openClaimsFrmLavanteElement1(){
		return openClaimsFrmLavanteElement1;
	}
	
	
	@FindBy(css="#open-claims td:nth-child(1) a span:nth-child(1)")
	private WebElement openClaimsFrmLavanteValue1;
	public WebElement openClaimsFrmLavanteValue1(){
		return openClaimsFrmLavanteValue1;
	}
	
	@FindBy(css="#open-claims td:nth-child(2)")
	private WebElement openClaimsFrmLavanteElement2;
	public WebElement openClaimsFrmLavanteElement2(){
		return openClaimsFrmLavanteElement2;
	}
	
	@FindBy(css="#open-claims td:nth-child(2) a span:nth-child(1)")
	private WebElement openClaimsFrmLavanteValue2;
	public WebElement openClaimsFrmLavanteValue2(){
		return openClaimsFrmLavanteValue2;
	}
	
	@FindBy(css="#open-claims td:nth-child(3)")
	private WebElement openClaimsFrmLavanteElement3;
	public WebElement openClaimsFrmLavanteElement3(){
		return openClaimsFrmLavanteElement3;
	}
	
	
	@FindBy(css="#open-claims td:nth-child(3) a span:nth-child(1)")
	private WebElement openClaimsFrmLavanteValue3;
	public WebElement openClaimsFrmLavanteValue3(){
		return openClaimsFrmLavanteValue3;
	}
	
	

	@FindBy(css="#claim-process td:nth-child(1)")
	private WebElement claimInProcessElement1;
	public WebElement claimInProcessElement1(){
		return claimInProcessElement1;
	}
	
	@FindBy(css="#claim-process td:nth-child(1) a span:nth-child(1)")
	private WebElement claimInProcessValue1;
	public WebElement claimInProcessValue1(){
		return claimInProcessValue1;
	}
	

	@FindBy(css="#claim-process td:nth-child(2)")
	private WebElement claimInProcessElement2;
	public WebElement claimInProcessElement2(){
		return claimInProcessElement2;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(2) a span:nth-child(1)")
	private WebElement claimInProcessValue2;
	public WebElement claimInProcessValue2(){
		return claimInProcessValue2;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(3)")
	private WebElement claimInProcessElement3;
	public WebElement claimInProcessElement3(){
		return claimInProcessElement3;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(3) a span:nth-child(1)")
	private WebElement claimInProcessValue3;
	public WebElement claimInProcessValue3(){
		return claimInProcessValue3;
	}
	

	@FindBy(css="#claim-process td:nth-child(1)")
	private WebElement claimsOnHoldElement1;
	public WebElement claimsOnHoldElement1(){
		return claimsOnHoldElement1;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(1) a span:nth-child(1)")
	private WebElement claimsOnHoldValue1;
	public WebElement claimsOnHoldValue1(){
		return claimsOnHoldValue1;
	}
	

	
	@FindBy(css="#claim-process td:nth-child(2)")
	private WebElement claimsOnHoldElement2;
	public WebElement claimsOnHoldElement2(){
		return claimsOnHoldElement2;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(2) a span:nth-child(1)")
	private WebElement claimsOnHoldValue2;
	public WebElement claimsOnHoldValue2(){
		return claimsOnHoldValue2;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(3) )")
	private WebElement claimsOnHoldElement3;
	public WebElement claimsOnHoldElement3(){
		return claimsOnHoldValue3;
	}
	
	@FindBy(css="#claim-process td:nth-child(3) a span:nth-child(1)")
	private WebElement claimsOnHoldValue3;
	public WebElement claimsOnHoldValue3(){
		return claimsOnHoldValue3;
	}
	
	
	@FindBy(css="#changed-claims td:nth-child(1) a")
	private WebElement claimsChangedValue1;
	public WebElement claimsChangedValue1(){
		return claimsChangedValue1;
	}
	
	@FindBy(css="#changed-claims td:nth-child(2) a")
	private WebElement claimsChangedValue2;
	public WebElement claimsChangedValue2(){
		return claimsChangedValue2;
	}
	
	@FindBy(css="#changed-claims td:nth-child(3) a")
	private WebElement claimsChangedValue3;
	public WebElement claimsChangedValue3(){
		return claimsChangedValue3;
	}
	
	
	@FindBy(css="#unpaid-invoice td:nth-child(1) a")
	private WebElement invoicesTobePaidValue1;
	public WebElement invoicesTobePaidValue1(){
		return invoicesTobePaidValue1;
	}
	
	@FindBy(css="#unpaid-invoice td:nth-child(2) a")
	private WebElement invoicesTobePaidValue2;
	public WebElement invoicesTobePaidValue2(){
		return invoicesTobePaidValue1;
	}
	
	@FindBy(css="#unpaid-invoice td:nth-child(3) a")
	private WebElement invoicesTobePaidValue3;
	public WebElement invoicesTobePaidValue3(){
		return invoicesTobePaidValue3;
	}
	
	
	@FindBy(css="#batchedClaims tr:nth-child(3) span")
	private WebElement claimsInProcessExpand;
	public WebElement claimsInProcessExpand(){
		return claimsInProcessExpand;
	}
	
	@FindBy(css="#batchedClaims tr:nth-child(5) span")
	private WebElement claimsOnHoldExpand;
	public WebElement claimsOnHoldExpand(){
		return claimsOnHoldExpand;
	}
	
	@FindBy(css="#batchedClaims tr:nth-child(7) span")
	private WebElement claimsChangedExpand;
	public WebElement claimsChangedExpand(){
		return claimsChangedExpand;
	}
	
	@FindBy(css="#batchedClaims tr:nth-child(9) span")
	private WebElement invoicestobePaidExpand;
	public WebElement invoicestobePaidExpand(){
		return invoicestobePaidExpand;
	}
	
	@FindBy(id="recKHf77AA_select_type")
	private WebElement claimsByStatus;
	public WebElement claimsByStatus(){
		return claimsByStatus;
	}
	
	@FindBy(css="#recKHf77AA_select_type a:nth-child(4)")
	private WebElement claimByStatusDataTable;
	public WebElement claimByStatusDataTable(){
		return claimByStatusDataTable;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody tr th a")
	private List<WebElement> claimByStatusTableLinks;
	public List<WebElement> claimByStatusTableLinks(){
		return claimByStatusTableLinks;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(1) td:nth-child(2)")
	private WebElement openAmountClaimsbyStatus;
	public WebElement openAmountClaimsbyStatus(){
		return openAmountClaimsbyStatus;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(4)  tr:nth-child(1) td:nth-child(2)")
	private WebElement openCountClaimsbyStatus;
	public WebElement openCountClaimsbyStatus(){
		return openCountClaimsbyStatus;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(2) td:nth-child(2)")
	private WebElement inProcessAmount;
	public WebElement inProcessAmount(){
		return inProcessAmount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(4)  tr:nth-child(2) td:nth-child(2)")
	private WebElement inProcessCount;
	public WebElement inProcessCount(){
		return inProcessCount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(3) td:nth-child(2)")
	private WebElement processedAmount;
	public WebElement processedAmount(){
		return processedAmount;
	}
		
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(3) td:nth-child(4)")
	private WebElement processedCount;
	public WebElement processedCount(){
		return processedCount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(4) td:nth-child(2)")
	private WebElement voidAmount;
	public WebElement voidAmount(){
		return voidAmount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(4) td:nth-child(4)")
	private WebElement voidCount;
	public WebElement voidCount(){
		return voidCount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(5) td:nth-child(2)")
	private WebElement openVoided;
	public WebElement openVoided(){
		return openVoided;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra']:nth-child(2) tbody:nth-child(2)  tr:nth-child(5) td:nth-child(4)")
	private WebElement openCount;
	public WebElement openCount(){
		return openCount;
	}
	
	
	@FindBy(css="#recKHf77CC_select_type")
	private WebElement allClaimsSelectChart;
	public WebElement allClaimsSelectChart(){
		return allClaimsSelectChart;
	}
	
	@FindBy(css="#recKHf77CC_select_type a[title='Data Table']")
	private WebElement allClaimsDataTable;
	public WebElement allClaimsDataTable(){
		return allClaimsDataTable;
	}
	
	@FindBy(css="table[class*='data_table table_grid zebra'] tbody:nth-child(1) tr:nth-child(1) th a")
	private List<WebElement> amountLinks;
	public List<WebElement> amountLinks(){
		return amountLinks;
	}
	
	@FindBy(css="table[class*='data_table table_grid zebra'] tbody:nth-child(1) tr:nth-child(2) th a")
	private List<WebElement> NumberLinks;
	public List<WebElement> NUmberLinks(){
		return NumberLinks;
	}
	
	
	@FindBy(css="table[class*='data_table table_grid zebra'] tbody:nth-child(1) tr:nth-child(1) td")
	private List<WebElement> amountValue;
	public List<WebElement> amountValue(){
		return amountValue;
	}
	
	@FindBy(css="table[class*='data_table table_grid zebra'] tbody:nth-child(1) tr:nth-child(2) td")
	private List<WebElement> numberValue;
	public List<WebElement> numberValue(){
		return numberValue;
	}
	
	
	@FindBy(id="recKHf77BB_select_type")
	private WebElement claimsByTypeSelectChart;
	public WebElement claimsByTypeSelectChart(){
		return claimsByTypeSelectChart;
	}
	
	@FindBy(css="#recKHf77BB_select_type a:nth-child(4)")
	private WebElement claimsByTypeDataTable;
	public WebElement claimsByTypeDataTable(){
		return claimsByTypeDataTable;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr th a")
	private List<WebElement> claimsByTypeAllLinks;
	public List<WebElement> claimsByTypeAllLinks(){
		return claimsByTypeAllLinks;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(1) td:nth-child(2)")
	private WebElement duplicateAmount;
	public WebElement duplicateAmount(){
		return duplicateAmount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(1) td:nth-child(4)")
	private WebElement duplicateCount;
	public WebElement duplicateCount(){
		return duplicateCount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(2) td:nth-child(2)")
	private WebElement miscAmount;
	public WebElement miscAmount(){
		return miscAmount;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(2) td:nth-child(4)")
	private WebElement miscCount;
	public WebElement miscCount(){
		return miscCount;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(3) td:nth-child(2)")
	private WebElement overPaymentAmount;
	public WebElement overpaymentAmount(){
		return overPaymentAmount;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(3) td:nth-child(4)")
	private WebElement overPaymentCount;
	public WebElement overPaymentCount(){
		return overPaymentCount;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(4) td:nth-child(2)")
	private WebElement rebateAmount;
	public WebElement rebateAmount(){
		return rebateAmount;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(4) td:nth-child(4)")
	private WebElement rebateCount;
	public WebElement rebateCount(){
		return rebateCount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(5) td:nth-child(2)")
	private WebElement returnAmount;
	public WebElement returnAmount(){
		return returnAmount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(5) td:nth-child(4)")
	private WebElement returnCount;
	public WebElement returnCount(){
		return returnCount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(6) td:nth-child(2)")
	private WebElement uacAmount;
	public WebElement uacAmount(){
		return uacAmount;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody tr:nth-child(6) td:nth-child(4)")
	private WebElement uacCount;
	public WebElement uacCount(){
		return uacCount;
	}
	
	@FindBy(css="div[id='recKHf77DD'] a[id='recKHf77DD_select_type']")
	private WebElement claimsByOrganizationChart;
	public WebElement claimsByOrganizationChart(){
		return claimsByOrganizationChart;
	}
	
	@FindBy(css="#recKHf77DD_select_type a[title*='Data Table']")
	private WebElement dataTable;
	public WebElement dataTable(){
		return dataTable;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra'] tbody:nth-child(2) a ")
	private List<WebElement> organizationLink;
	public List<WebElement> organizationLink(){
		return organizationLink;
	}

	@FindBy(css="#recKHf77DD table:nth-child(2) tbody td:nth-child(2)")
	private  List<WebElement> Amount;
	public  List<WebElement> Amount(){
		return Amount;
	}
	
	@FindBy(css="#recKHf77DD table:nth-child(2) tbody td:nth-child(4)")
	private List<WebElement> Count;
	public List<WebElement> Count(){
		return Count;
	}
	
	@FindBy(css="div[id='graphPeriod_chosen'] a")
	private WebElement graphPeriod;
	public WebElement graphPeriod(){
		return graphPeriod;
	}
	
	@FindBy(css="div[class='chosen-drop'] ul li:nth-child(6)")
	private WebElement graphPeriodDropdown;
	public WebElement graphPeriodDropdown(){
		return graphPeriodDropdown;
	}
	
	
	@FindBy(css="a[title='Claims Submitted']")
	private WebElement batchedClaims;
	public WebElement batchedclaims(){
		return batchedClaims;
	}
	
	
	@FindBy(css="table[id='claimsTable'] tr td a")
	private List<WebElement> batchedClaimsLinks;
	public List<WebElement> batchedClaimsLinks(){
		return batchedClaimsLinks;
	}
	
	
	@FindBy(css="table[id='claimsTable'] tr td:nth-child(2)")
	private List<WebElement> batchId;
	public List<WebElement> batchId(){
		return batchId;
	}
	
	@FindBy(css="table[id='claimsTable'] tr td:nth-child(3)")
	private List<WebElement> openTotal;
	public List<WebElement> openTotal(){
		return openTotal;
	}
	
	
	@FindBy(css="table[id='claimsTable'] tr td:nth-child(4)")
	private List<WebElement> batchedClaimsAmount;
	public List<WebElement> batchedClaimsAmount(){
		return batchedClaimsAmount;
	}
	
	@FindBy(css="table[id='claimsTable'] tr td:nth-child(5)")
	private List<WebElement> batchType;
	public List<WebElement> batchType(){
		return batchType;
	}
	
	
	@FindBy(css="a[href = '#invoices']")
	private WebElement invoicesLink;
	public WebElement invoicesLink(){
		return invoicesLink;
			
		}
	
	@FindBy(css="table[id='invoiceTable'] tr td a ")
	private List<WebElement> invoicesDates;
	public List<WebElement> invoicesDates(){
		return invoicesDates;
	}
	
	@FindBy(css="span[class='text-green']:nth-child(3)")
	private WebElement invoiceDated;
	public WebElement invoiceDated(){
		return invoiceDated;
	}
	
	@FindBy(css="table[id='invoiceTable'] tr td:nth-child(2)")
	private List<WebElement> invoicesNumber;
	public List<WebElement> invoicesNumber(){
		return invoicesNumber;
	}
	
	@FindBy(css="table[id='invoiceTable'] tr td:nth-child(3)")
	private List<WebElement> invoicesAmount;
	public List<WebElement> invoicesAmount(){
		return invoicesAmount;
	}
	
	@FindBy(css="table[id='invoiceTable'] tr td:nth-child(4)")
	private List<WebElement> invoicesPaid;
	public List<WebElement> invoicesPaid(){
		return invoicesPaid;
	}

	@FindBy(css="table[id='invoiceTable'] tr td:nth-child(5)")
	private List<WebElement> invoicesType;
	public List<WebElement> invoicesType(){
		return invoicesType;
	}
	
	
	public void expandButton_click(){
		claimsInProcessExpand().click();
		claimsOnHoldExpand().click();
		claimsChangedExpand().click();
		invoicestobePaidExpand().click();
	}
	
	public void getItemsForMyReviewValues1(WebElement Element) {
	
		String expOPenClaimsFromLavanteValue1 = Element.getText();
				
	}
	
	public void getItemsForMyReviewValues() {
		
	String expOPenClaimsFromLavanteValue1 = openClaimsFrmLavanteValue1().getText();
	String expOPenClaimsFromLavanteValue3 = openClaimsFrmLavanteValue3().getText();
	String expClaimsInProcessValue3 = claimInProcessValue3().getText();
	String expClaimsOnHoldValue3 = claimsOnHoldValue3().getText();
	String expClaimsChangedValue1 = claimsChangedValue1().getText();
	String expClaimsChangedValue2 = claimsChangedValue2().getText();
	String expClaimsChangedValue3 = claimsChangedValue3().getText();
	String expInvoicesPaidValue1 = invoicesTobePaidValue1().getText();
	String expInvoicesPaidValue2 = invoicesTobePaidValue2().getText();
	String expInvoicesPaidValue3 = invoicesTobePaidValue3().getText();
		
	}
	
	
}
