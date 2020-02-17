package com.lavante.recovery.pageobjects;

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

public class Dashboard_ClaimsPage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public Dashboard_ClaimsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	
	
	@FindBy(linkText = "Dashboards")
	//@FindBy(css="a[href='/recovery/dashboard.lvp']']")
	private WebElement dashboardsLink;
	public WebElement dashboardsLink(){
		return dashboardsLink;
	}
	
	//@FindBy(linkText= "Claims")
	@FindBy(css="a[href='/recovery/claimDashboard.lvp']")
	private WebElement claimsLink;
	public WebElement claimsLink(){
		return claimsLink;
	}
	
	@FindBy(css="#open-claims td:nth-child(1) a span:nth-child(1)")
	private WebElement openClaimsFrmLavanteValue1;
	public WebElement openClaimsFrmLavanteValue1(){
		return openClaimsFrmLavanteValue1;
	}
	
	@FindBy(css="#open-claims td:nth-child(2) a span:nth-child(1)")
	private WebElement openClaimsFrmLavanteValue2;
	public WebElement openClaimsFrmLavanteValue2(){
		return openClaimsFrmLavanteValue2;
	}
	
	@FindBy(css="#open-claims td:nth-child(3) a span:nth-child(1)")
	private WebElement openClaimsFrmLavanteValue3;
	public WebElement openClaimsFrmLavanteValue3(){
		return openClaimsFrmLavanteValue3;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(1) a span:nth-child(1)")
	private WebElement claimInProcessValue1;
	public WebElement claimInProcessValue1(){
		return claimInProcessValue1;
	}
	@FindBy(css="#claim-process td:nth-child(2) a span:nth-child(1)")
	private WebElement claimInProcessValue2;
	public WebElement claimInProcessValue2(){
		return claimInProcessValue1;
	}
	
	
	@FindBy(css="#claim-process td:nth-child(3) a span:nth-child(1)")
	private WebElement claimInProcessValue3;
	public WebElement claimInProcessValue3(){
		return claimInProcessValue3;
	}
	
	@FindBy(css="#claim-process td:nth-child(1) a span:nth-child(1)")
	private WebElement claimsOnHoldValue1;
	public WebElement claimsOnHoldValue1(){
		return claimsOnHoldValue1;
	}
	
	@FindBy(css="#claim-process td:nth-child(2) a span:nth-child(1)")
	private WebElement claimsOnHoldValue2;
	public WebElement claimsOnHoldValue2(){
		return claimsOnHoldValue2;
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
		//String expOpenClaimsFromLavanteValue2 = dashboard_claimsPage.openClaimsFrmLavanteValue2().getText();
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
