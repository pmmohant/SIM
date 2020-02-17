package lavante.recovery.pageobjects.Audit;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lavante.recovery.utilities.seleniumBaseClass;

public class AuditOutboundPage extends seleniumBaseClass{
	
	//Audit Link
	@FindBy(linkText="Audit")
	private WebElement auditLink;
	
	public void verifyauditLink() {
	
		click("auditLink",auditLink);
		fluentwait(auditLink);
		getHttpResponse();
		isDisplayed("auditLink",auditLink);
		verifyError(auditLink);	
	}	
	
	//Outbound Link
	@FindBy(linkText="Outbound")
	private WebElement outboundLink;
	
	public void verifyoutboundLink() {
	
		click("outboundLink",outboundLink);
		getHttpResponse();
		isDisplayed("outboundLink",outboundLink);
		verifyError(outboundLink);	
	}
	
	//Current Month Credits
	@FindBy(css="a[href*='CurrentMonthCredits']")
	private WebElement currentMonCredits;
	
	public void verifycurrentMonCredits() {
	
		isDisplayed("currentMonCredits",currentMonCredits);
		verifyError(currentMonCredits);	
	}
	
	//Audit Contact Details
	@FindBy(css="#calling-reference tr")
	private WebElement auditContactDetails;
	
	public void verifyauditContactDetails() {
	
		isDisplayed("auditContactDetails",auditContactDetails);
		verifyError(auditContactDetails);	
	}
	
	//Future Credits Graph
	@FindBy(css="#recKHf77UU")
	private WebElement furureCreditsGrph;
	
	public void verifyfurureCreditsGrph() {
	
		isDisplayed("furureCreditsGrph",furureCreditsGrph);
		verifyError(furureCreditsGrph);	
	}
	
	//Claim History graph
	@FindBy(css="#recKHf77TT")
	private WebElement claimHistoryGrph;
	
	public void verifyclaimHistoryGrph() {
	
		click("claimHistoryGrph",claimHistoryGrph);
		getHttpResponse();
		isDisplayed("claimHistoryGrph",claimHistoryGrph);
		verifyError(claimHistoryGrph);	
	}
	
	//Supplier Status by Spend Rank
	@FindBy(css="a[href*='SupplierStatus']")
	private WebElement supplierStatus;
	
	public void verifysupplierStatus() {
	
		isDisplayed("supplierStatus",supplierStatus);
		verifyError(supplierStatus);	
	}
	
	//Pending Correspondence
	@FindBy(css="a[href*='Correspondence']")
	private WebElement pendingCorrespondence;
	
	public void verifypendingCorrespondence() {
	
		isDisplayed("pendingCorrespondence",pendingCorrespondence);
		verifyError(pendingCorrespondence);	
	}

}
