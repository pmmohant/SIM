package lavante.recovery.pageobjects.DashBoard;

import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class ClaimsPage extends seleniumBaseClass{
	
	//Dashboard Link
	@FindBy(css="a[href*='dashboard']")
	private WebElement dashBoardLink;
	
	public void verifyDashBoardLink() {
		isDisplayed("dashBoardLink",dashBoardLink);
		fluentwait(dashBoardLink);
	}
	
	//Dashboard--Claims Link
	@FindBy(css="a[title*='Claims']")
	private WebElement claimsLink;
	
	public void verifyClaimsLink() {
		isDisplayed("claimsLink",claimsLink);
	}
	
   //Items for My Review Section
	@FindBy(css="#open-claims td a")
	private WebElement openClaims;
	
	public void verifyItemsForMySection() {
		fluentwait(openClaims);
		isDisplayed("openClaims",openClaims);
		verifyError(openClaims);
	}
	
	//Batched Claims link
	@FindBy(css="a[data-tab='claims']")
	private WebElement batchedClaimslink;
	
	public void verifyBatchedClaimsLink() {
		fluentwait(batchedClaimslink);
		click("batchedClaimslink",batchedClaimslink);
		isDisplayed("batchedClaimslink",batchedClaimslink);
		verifyError(batchedClaimslink);	
	}
	
	//Batched Claims Data
	@FindBy(css="#claimsTable tr td")
	private WebElement batchedClaims;
	
	public void verifyBatchedClaims() {
		isDisplayed("batchedClaims",batchedClaims);
		verifyError(batchedClaims);	
	}
	
	//Invoices link
	@FindBy(css="a[data-tab='invoices']")
	private WebElement invoiceslink;
	
	public void verifyinvoicesLink() {
		fluentwait(invoiceslink);
		click("invoiceslink",invoiceslink);
		isDisplayed("invoiceslink",invoiceslink);
		verifyError(invoiceslink);	
	}
	
	//Invoices Data
	@FindBy(css="#invoiceTable tr td")
	private WebElement invoices;
	
	public void verifyInvoices() {
		fluentwait(invoices);
		isDisplayed("invoices",invoices);
		verifyError(invoices);	
	}
	
	//Charts--Claims By Status
	@FindBy(css="#recKHf77AA")
	private WebElement claimsByStatusChart;
	
	public void verifyclaimsByStatusChart() {
		fluentwait(claimsByStatusChart);
		isDisplayed("claimsByStatusChart",claimsByStatusChart);
		verifyError(claimsByStatusChart);	
	}
	
	//Charts--Claims By Type
	@FindBy(css="#recKHf77BB")
	private WebElement claimsByTypeChart;
	
	public void verifyclaimsByTypeChart() {
		fluentwait(claimsByTypeChart);
		isDisplayed("claimsByTypeChart",claimsByTypeChart);
		verifyError(claimsByTypeChart);	
	}
	//Charts--All Claims
	@FindBy(css="#recKHf77CC")
	private WebElement allClaimsChart;
	
	public void verifyallClaimsChart() {
		fluentwait(allClaimsChart);
		isDisplayed("allClaimsChart",allClaimsChart);
		verifyError(allClaimsChart);	
	}
	//Charts--Claims By Organization
	@FindBy(css="#recKHf77DD")
	private WebElement claimsByOrgChart;
	
	public void verifyclaimsByOrgChart() {
		fluentwait(claimsByOrgChart);
		isDisplayed("claimsByOrgChart",claimsByOrgChart);
		verifyError(claimsByOrgChart);	
	}

}
