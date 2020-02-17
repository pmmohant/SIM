package lavante.recovery.pageobjects.DashBoard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import lavante.recovery.utilities.LavanteUtils;
//import jdk.internal.instrumentation.ClassInstrumentation;
import lavante.recovery.utilities.seleniumBaseClass;

/**
 * @author tallury.srikanth
 *
 */
public class ClaimsPage {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public ClaimsPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Dashboard Link
	@FindBy(css="a[href*='dashboard']")
	private WebElement dashBoardLink;
	public WebElement dashBoardLink(){
		return dashBoardLink;
	}
	
	public WebElement verifyDashBoardLink() {
		//fluentwait(dashBoardLink);
		lavanteUtils.isDisplayed("dashBoardLink",dashBoardLink);
		return dashBoardLink;
	}
	
	//Dashboard--Claims Link
	@FindBy(css="a[title*='Claims']")
	private WebElement claimsLink;
	public WebElement claimsLink(){   //added by Ramya
		return claimsLink;
	}
	
	public WebElement verifyClaimsLink() {
		lavanteUtils.isDisplayed("claimsLink",claimsLink);
		return claimsLink;
	}
	
   //Items for My Review Section
	@FindBy(css="#open-claims td a")
	private WebElement openClaims;
	public WebElement openClaims(){
		return openClaims;
	}
	
	
   // Items for My Review section
   	@FindBy(css="td[title*='Items for My Review ] span")
   	public List <WebElement> itemsforMyReviewLink;
   	
   
	public void verifyItemsForMySection() {
		lavanteUtils.fluentwait(openClaims);
		lavanteUtils.isDisplayed("openClaims",openClaims);
		lavanteUtils.verifyError(openClaims);
	}
	
	//Batched Claims link
	@FindBy(css="a[data-tab='claims']")
	private WebElement batchedClaimslink;
	public WebElement batchedClaimslink(){
		return batchedClaimslink;
	}
	
	public void verifyBatchedClaimsLink() {
		lavanteUtils.fluentwait(batchedClaimslink);
		lavanteUtils.click("batchedClaimslink",batchedClaimslink);
		lavanteUtils.isDisplayed("batchedClaimslink",batchedClaimslink);
		lavanteUtils.verifyError(batchedClaimslink);	
	}
	
	//Batched Claims Data
	@FindBy(css="#claimsTable tr td")
	private WebElement batchedClaims;
	public WebElement batchedClaims(){
		return batchedClaims;
	}
	
	public void verifyBatchedClaims() {
		lavanteUtils.isDisplayed("batchedClaims",batchedClaims);
		lavanteUtils.verifyError(batchedClaims);	
	}
	
	//Invoices link
	@FindBy(css="a[data-tab='invoices']")
	private WebElement invoiceslink;
	public WebElement invoiceslink(){
		return invoiceslink;
	}
	
	public void verifyinvoicesLink() {
		lavanteUtils.fluentwait(invoiceslink);
		lavanteUtils.click("invoiceslink",invoiceslink);
		lavanteUtils.isDisplayed("invoiceslink",invoiceslink);
		lavanteUtils.verifyError(invoiceslink);	
	}
	
	//Invoices Data
	@FindBy(css="#invoiceTable tr td")
	private WebElement invoices;
	public WebElement invoices(){
		return invoices;
	}
	
	public void verifyInvoices() {
		lavanteUtils.fluentwait(invoices);
		lavanteUtils.isDisplayed("invoices",invoices);
		lavanteUtils.verifyError(invoices);	
	}
	
	//Charts--Claims By Status
	@FindBy(css="#recKHf77AA tr td span")
	private WebElement claimsByStatusChart;
	public WebElement claimsByStatusChart(){
		return claimsByStatusChart;
	}
	
	public void verifyclaimsByStatusChart() {
		lavanteUtils.fluentwait(claimsByStatusChart);
		lavanteUtils.isDisplayed("claimsByStatusChart",claimsByStatusChart);
		lavanteUtils.verifyError(claimsByStatusChart);	
	}
	
	//Charts--Claims By Type
	@FindBy(css="#recKHf77BB tr td span")
	private WebElement claimsByTypeChart;
	public WebElement claimsByTypeChart(){
		return claimsByTypeChart;
	}
	
	public void verifyclaimsByTypeChart() {
		lavanteUtils.fluentwait(claimsByTypeChart);
		lavanteUtils.isDisplayed("claimsByTypeChart",claimsByTypeChart);
		lavanteUtils.verifyError(claimsByTypeChart);	
	}
	//Charts--All Claims
	@FindBy(css="#recKHf77CC tr td span")
	private WebElement allClaimsChart;
	public WebElement allClaimsChart(){
		return allClaimsChart;
	}
	
	public void verifyallClaimsChart() {
		lavanteUtils.fluentwait(allClaimsChart);
		lavanteUtils.isDisplayed("allClaimsChart",allClaimsChart);
		lavanteUtils.verifyError(allClaimsChart);	
	}
	//Charts--Claims By Organization
	@FindBy(css="#recKHf77DD tr td span")
	private WebElement claimsByOrgChart;
	public WebElement claimsByOrgChart(){
		return claimsByOrgChart;
	}
	
	public void verifyclaimsByOrgChart() {
		lavanteUtils.fluentwait(claimsByOrgChart);
		lavanteUtils.isDisplayed("claimsByOrgChart",claimsByOrgChart);
		lavanteUtils.verifyError(claimsByOrgChart);	
	}
	
	//Claims--Items for my review
	@FindBy(css=".triangle")
	private List <WebElement> itemsforMyReview;
	//	tr[data-elemid*='open-claims'] span
	
	//Claims--Items for my review--New open claims 
	@FindBy(css="td[title*='New open claims'] span")
	private WebElement newOpenClaims;
	
	//Items for My Review
	
	
	//Items for My Review (Days old)						//added by Ramya
	@FindBy(css="tr td div table span[title*='Items for My']")
	private WebElement itemsForMyReviewD;
	public WebElement itemsForMyReviewD(){
		return itemsForMyReviewD;
	}
			
	
	//Claims - New open claims from Lavante					//added by Ramya
	@FindBy(css="td[title*='New open claims']")
	private WebElement newOpenClaimsFromLavante;
	public WebElement newOpenClaimsFromLavante(){
		return newOpenClaimsFromLavante;
	}
	
	
	//Claims - Claims in process by Us						//added by Ramya
	@FindBy(css="td[title*='In process claims']")
	private WebElement claimsInPrcessByUs;
	public WebElement claimsInProcessByUs(){
		return newOpenClaimsFromLavante;
	}
	
	
	//Claims - Claims on Hold								//added by Ramya
	@FindBy(css="td[title*='Claims that has been ']")
	private WebElement claimsOnHold;
	public WebElement claimsOnHold(){
		return claimsOnHold;
	}
	
	//Claims- Claims that changed							//added by Ramya
	@FindBy(css="td[title*='Latest updated ']")
	private WebElement claimsthatChanged;
	public WebElement claimsthatChanged(){
		return claimsthatChanged;
	}
	
	
	//Claims - Invoices to be paid by us					//added by Ramya
	@FindBy(css="td[title*='Latest invoices that'])")
	private WebElement invoicesToBePaidByUs;
	public WebElement invoicesToBePaidByUs(){
		return invoicesToBePaidByUs;
	}
	
	
	
	//Claims 
	
	//Claims--Items for my review--claims in process
	@FindBy(css="td[title*='In process claims'] span")
	private WebElement claimsInProcess;
	
	//Claims--Items for my review--Claims on hold 
	@FindBy(css="td[title*='Claims that has been held'] span")
	private WebElement holdClaims;
	
	//Claims--Items for my review--Claims that changed 
	@FindBy(css="td[title*='Latest updated claims'] span")
	private WebElement changedClaims;
	
	//Claims--Items for my review--Invoices to be paid
	@FindBy(css="td[title*='Latest invoices'] span")
	private WebElement latestInvoices;
	
	//Main claims--Total Claims count
	@FindBy(css="table:nth-child(1) td:nth-child(1) span:nth-child(1)")
	private WebElement totalClaimsCount;
	
	
	//Main claims--Total Amount
	@FindBy(css=".data_table tr:nth-child(2) td:nth-child(11)")
	private WebElement totalClaimsAmt;
	

	//Claims--Items for my review--New open claims Links
	@FindBy(css="#open-claims td a")
	private List <WebElement> newOpenClaimsLinks;
	
	//Claims--Items for my review--Claims in process links
	@FindBy(css="#claim-process td a")
	private List <WebElement> inProcessClaimsLinks;
	
	//Claims--Items for my review--Claims on Hold links
	@FindBy(css="#hold-claims td a")
	private List <WebElement> holdClaimsLinks;
	
	//Claims--Items for my review--Claims that changed links
	@FindBy(css="#changed-claims td a")
	private List <WebElement> changedClaimsLinks;
	
	//Claims--Items for my review--Invoices to be paid
	@FindBy(css="#unpaid-invoice td a")
	private List <WebElement> unpaidInvoicesLinks;
	
	//Claims--All links in items for my review
	@FindBy(css="tr[style*='display: table-row'] td a")
	private List <WebElement> itemsforMyReviewLinks;
	
	//Claims--Back button
	@FindBy(css="input[onclick*='backButton']")
	private WebElement backBtn;
	
	//Claims--Last page button
	@FindBy(css=".last")
	private WebElement lastPgBtn;
	
	//Claims--Total pages
	@FindBy(css="#total_pages")
	private WebElement totalPages;
	
	//Claims--Amount for Hold Claims
	@FindBy(css="tr:nth-child(2) td:nth-child(9)")
	private WebElement holdClaimsAmt;
	
	//Claims--Latest Updated Claims
	@FindBy(css="#claimChanges td:nth-child(1)")
	private List <WebElement> changedClaimsList;
	
	//Invoices--Unpaid invoices
	@FindBy(css="#invoiceNumber option")
	private List <WebElement> unpaidInvoicesList;
	
	public void verifyNewOpenClaims() {
	//	click(newOpenClaims);
		System.out.println(newOpenClaimsLinks.size());
		
		if(newOpenClaimsLinks.size() > 0){
			for(WebElement openClaimsLink : newOpenClaimsLinks){
				System.out.println(openClaimsLink.getText().toString());
				String eachClaimsLinkinDashboard = openClaimsLink.getText().toString();
				lavanteUtils.click(openClaimsLink);
				
				String totClaimsCount = totalClaimsCount.getText().toString();
				String totClaimsAmt = totalClaimsAmt.getText().toString();
				
					if(eachClaimsLinkinDashboard.contains(totClaimsCount) && eachClaimsLinkinDashboard.contains(totClaimsAmt)){
						System.out.println(eachClaimsLinkinDashboard + "," + totClaimsCount + "," + totClaimsAmt);
						Reporter.log("Count matched with before and after drilling with claims amount");
						lavanteUtils.click(backBtn);
					}
					
					else{
						Assert.assertTrue(false, "Count and Claims amount not matched with dashboard");
					}
			}
		}
		
		else{
			Reporter.log("No drillable links available");
		}
		
	}
	
	public void verifyclaimsINProcess() {
		lavanteUtils.click(claimsInProcess);
			System.out.println(inProcessClaimsLinks.size());
			
			if(inProcessClaimsLinks.size() > 0){
				for(WebElement inProcessClaim : inProcessClaimsLinks){
					System.out.println(inProcessClaim.getText().toString());
					String eachClaimsLinkinDashboard = inProcessClaim.getText().toString();
					lavanteUtils.click(inProcessClaim);
					
					String totClaimsCount = totalClaimsCount.getText().toString();
					String totClaimsAmt = totalClaimsAmt.getText().toString();
					
						if(eachClaimsLinkinDashboard.contains(totClaimsCount) && eachClaimsLinkinDashboard.contains(totClaimsAmt)){
							System.out.println(eachClaimsLinkinDashboard + "," + totClaimsCount + "," + totClaimsAmt);
							Reporter.log("Count matched with before and after drilling with claims amount");
							lavanteUtils.click(backBtn);
						}
						
						else{
							Assert.assertTrue(false, "Count and Claims amount not matched with dashboard");
						}
				}
			}
			
			else{
				Reporter.log("No drillable links available");
			}
		}
	
	public void verifyclaimsonHold() {
		lavanteUtils.click(holdClaims);
		System.out.println(holdClaimsLinks.size());
		
		if(holdClaimsLinks.size() > 0){
			for(int i=0; i<holdClaimsLinks.size();i++){
				{
					lavanteUtils.click(holdClaimsLinks.get(i));
				}
				System.out.println(holdClaimsLinks.get(i).getText().toString());
				String eachClaimsLinkinDashboard = holdClaimsLinks.get(i).getText().toString();
				lavanteUtils.click(holdClaimsLinks.get(i));
				
				String totClaimsCount = totalClaimsCount.getText().toString();
				String totClaimsAmt = holdClaimsAmt.getText().toString();
				
					if(eachClaimsLinkinDashboard.contains(totClaimsCount) && eachClaimsLinkinDashboard.contains(totClaimsAmt)){
						System.out.println(eachClaimsLinkinDashboard + "," + totClaimsCount + "," + totClaimsAmt);
						Reporter.log("Count matched with before and after drilling with claims amount");
						lavanteUtils.click(backBtn);
					}
					
					else{
						Assert.assertTrue(false, "Count and Claims amount not matched with dashboard");
					}
			}
		}
		
		else{
			Reporter.log("No drillable links available");
		}
	}
	
	public void verifyChangedClaims() {
		lavanteUtils.click(changedClaims);
		System.out.println(changedClaimsLinks.size());
		
		if(changedClaimsLinks.size() > 0){
			
			for(int i=0; i<changedClaimsLinks.size();i++){
				if(i>=1){
					lavanteUtils.click(changedClaims);
				}
				System.out.println(changedClaimsLinks.get(i).getText().toString());
				String eachClaimsLinkinDashboard = changedClaimsLinks.get(i).getText().toString();
				lavanteUtils.click(changedClaimsLinks.get(i));
						
				lavanteUtils.waitforPageLoad(lastPgBtn);
				int totchangedClaimsPerPage = changedClaimsList.size();
				lavanteUtils.scrollingToElementofAPage(lastPgBtn);
				lavanteUtils.fluentwait(lastPgBtn);
				lavanteUtils.click(lastPgBtn);
				
				 if(changedClaimsList.size()!=totchangedClaimsPerPage){
					 String totpages = totalPages.getText().toString();
					 int totpagesInInteger = Integer.parseInt(totpages);
					 int lastpageRecords = changedClaimsList.size();
					 
					int finalcount =  ((totpagesInInteger-1)* totchangedClaimsPerPage + lastpageRecords);
					String newformatedCount = String.valueOf(finalcount);
					
						if(eachClaimsLinkinDashboard.contains(newformatedCount)){
							System.out.println(eachClaimsLinkinDashboard + "," + newformatedCount);
							Reporter.log("Count matched with before and after drilling");
							lavanteUtils.click(backBtn);
						}
					
						else{
							Assert.assertTrue(false, "Count and not matched with dashboard");
						}
				 }
				 
				 else{
					 String totpages = totalPages.getText().toString();
					 int totpagesInInteger = Integer.parseInt(totpages);

					 int finalcount =  ((totpagesInInteger)* totchangedClaimsPerPage);
					 String newformatedCount = String.valueOf(finalcount);
					 
						if(eachClaimsLinkinDashboard.contains(newformatedCount)){
							System.out.println(eachClaimsLinkinDashboard + "," + newformatedCount);
							Reporter.log("Count matched with before and after drilling");
							lavanteUtils.click(backBtn);
						}
					
						else{
							Assert.assertTrue(false, "Count and not matched with dashboard");
						}
				 }
				 
					
			}
		}
		
		else{
			Reporter.log("No drillable links available");
		}
	}
	
	public void verifyUnpaidInvoices() {
		lavanteUtils.click(latestInvoices);
		System.out.println(unpaidInvoicesLinks.size());
		
		if(unpaidInvoicesLinks.size() > 0){
			
			for(int i=0; i<unpaidInvoicesLinks.size();i++){
				if(i>=1){
					lavanteUtils.click(latestInvoices);
				}
				System.out.println(unpaidInvoicesLinks.get(i).getText().toString());
				String eachInvoiceLinkinDashboard = unpaidInvoicesLinks.get(i).getText().toString();
				int intUnpaidInvoices = Integer.parseInt(eachInvoiceLinkinDashboard);
				
			/*for(WebElement unpaidInvoice : unpaidInvoicesLinks){
				System.out.println(unpaidInvoice.getText().toString());
				String eachClaimsLinkinDashboard = unpaidInvoice.getText().toString();
				int intUnpaidInvoices = Integer.parseInt(eachClaimsLinkinDashboard);*/
				
				lavanteUtils.click(unpaidInvoicesLinks.get(i));
				
				int totUnpaidInvoiceCount = unpaidInvoicesList.size();
				
				
					if(intUnpaidInvoices==totUnpaidInvoiceCount){
						System.out.println(intUnpaidInvoices + "," + totUnpaidInvoiceCount);
						Reporter.log("Invoice Count matched with before and after drilling");
						lavanteUtils.click(backBtn);
					}
					
					else{
						Assert.assertTrue(false, "Invoice Count not matched with dashboard and invoices");
					}
			}
		}
		
		else{
			Reporter.log("No drillable links available");
		}
	}

}

