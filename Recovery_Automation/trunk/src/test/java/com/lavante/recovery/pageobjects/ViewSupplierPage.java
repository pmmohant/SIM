package com.lavante.recovery.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;

public class ViewSupplierPage {
	
LavanteUtils lavanteUtils = new LavanteUtils();
	
	public ViewSupplierPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}


	//Suplier Details
		
	@FindBy(css="#contentTitle+label")
	private WebElement suppNameOnTitle;
	public WebElement suppNameOnTitle(){
		return suppNameOnTitle;
	}	

	@FindBy(css="#back-button input")
	private WebElement backBtn;
	public WebElement backBtn(){
		return backBtn;
	}	
	
	@FindBy(xpath="//td[contains(text(),'Name :')]/../td[2]")
	private WebElement supplierName;
	public WebElement supplierName(){
		return supplierName;
	}
	
	@FindBy(xpath="//td[contains(text(),'Supplier ID')]/../td[4]")
	private WebElement supplierID;
	public WebElement supplierID(){
		return supplierID;
	}
	
	@FindBy(xpath="//td[contains(text(),'Spend :')]/../td[4]")
	private WebElement spendAmt;
	public WebElement spendAmt(){
		return spendAmt;
	}
	
	@FindBy(xpath="//td[contains(text(),'Spend Rank :')]/../td[2]")
	private WebElement spendRank;
	public WebElement spendRank(){
		return spendRank;
	}
	
	@FindBy(xpath="//td[contains(text(),'Address :')]/../td[2]")
	private WebElement supplierAddress;
	public WebElement supplierAddress(){
		return supplierAddress;
	}
	
	@FindBy(xpath="//td[contains(text(),'Address 2:')]/../td[4]")
	private WebElement supplierAddress2;
	public WebElement supplierAddress2(){
		return supplierAddress2;
	}
	
	@FindBy(xpath="//td[contains(text(),'Address 3:')]/../td[2]")
	private WebElement supplierAddress3;
	public WebElement supplierAddress3(){
		return supplierAddress3;
	}
	
	@FindBy(xpath="//td[contains(text(),'City :')]/../td[4]")
	private WebElement supplierCity;
	public WebElement supplierCity(){
		return supplierCity;
	}		
	
	@FindBy(xpath="//td[contains(text(),'State :')]/../td[2]")
	private WebElement supplierState;
	public WebElement supplierState(){
		return supplierState;
	}		
	
	@FindBy(xpath="//td[contains(text(),'Country :')]/../td[4]")
	private WebElement supplierCountry;
	public WebElement supplierCountry(){
		return supplierCountry;
	}		
	
	@FindBy(xpath="//td[contains(text(),'Zip Code :')]/../td[2]")
	private WebElement supplierZipCode;
	public WebElement supplierZipCode(){
		return supplierZipCode;
	}
	
	@FindBy(xpath="//td[contains(text(),'Zip Code 2:')]/../td[4]")
	private WebElement supplierZipCode2;
	public WebElement supplierZipCode2(){
		return supplierZipCode2;
	}
	
	@FindBy(xpath="//td[text()='Phone :']/../td[2]")
	private WebElement supplierPhone;
	public WebElement supplierPhone(){
		return supplierPhone;
	}
	
	@FindBy(xpath="//td[text()='Fax :']/../td[4]")
	private WebElement supplierFax;
	public WebElement supplierFax(){
		return supplierFax;
	}

	@FindBy(xpath="//td[contains(text(),'Parent Lavante UID :')]/../td[2]")
	private WebElement supplierParentLavanteUID;
	public WebElement supplierParentLavanteUID(){
		return supplierParentLavanteUID;
	}
	
	@FindBy(xpath="//td[contains(text(),'Entity Type :')]/../td[4]")
	private WebElement supplierEntityType;
	public WebElement supplierEntityType(){
		return supplierEntityType;
	}

	@FindBy(xpath="//td[contains(text(),'TIN :')]/../td[2]")
	private WebElement supplierTIN;
	public WebElement supplierTIN(){
		return supplierTIN;
	}
	
	@FindBy(xpath="//td[contains(text(),'DUNS :')]/../td[4]")
	private WebElement supplierDUNS;
	public WebElement supplierDUNS(){
		return supplierDUNS;
	}

	@FindBy(xpath="//td[contains(text(),'Contact :')]/../td[2]")
	private WebElement supplierContact;
	public WebElement supplierContact(){
		return supplierContact;
	}
	
	@FindBy(xpath="//td[contains(text(),'Email :')]/../td[4]")
	private WebElement supplierEmail;
	public WebElement supplierEmail(){
		return supplierEmail;
	}		
	
	@FindBy(xpath="//td[contains(text(),'Contact Phone :')]/../td[2]")
	private WebElement supplierContactPhone;
	public WebElement supplierContactPhone(){
		return supplierContactPhone;
	}
	
	@FindBy(xpath="//td[contains(text(),'Ext :')]/../td[4]")
	private WebElement supplierExt;
	public WebElement supplierExt(){
		return supplierExt;
	}		

	@FindBy(xpath="//td[contains(text(),'Contact Fax :')]/../td[2]")
	private WebElement supplierContactFax;
	public WebElement supplierContactFax(){
		return supplierContactFax;
	}
	
	@FindBy(xpath="//td[text()='Lavante UID :']/../td[4]")
	private WebElement supplierLavanteUID;
	public WebElement supplierLavanteUID(){
		return supplierLavanteUID;
	}		

	
	//Claim Statistics 
	@FindBy(xpath="//th[text()='Claims']/../../..//tr[1]/td[1]")
	private WebElement claimCnt;
	public WebElement claimCnt(){
		return claimCnt;
	}
	
	@FindBy(xpath="//th[contains(text(),'Total')]/../../..//tr[1]/td[2]")
	private WebElement totalClaimAmt;
	public WebElement totalClaimAmt(){
		return totalClaimAmt;
	}
		
	@FindBy(xpath="//th[contains(text(),'Average Claim')]/../../..//tr[1]/td[3]")
	private WebElement avgClaimAmt;
	public WebElement avgClaimAmt(){
		return avgClaimAmt;
	}		

	//Documents
	
	@FindBy(css="#supplierDocument td:nth-child(1)")
	private List<WebElement> suppDocDate;
	public List<WebElement> suppDocDate(){
		return suppDocDate;
	}			
	
	@FindBy(css="#supplierDocument td:nth-child(2)")
	private List<WebElement> suppDocType;
	public List<WebElement> suppDocType(){
		return suppDocType;
	}				
	
	@FindBy(css="#supplierDocument td:nth-child(3)")
	private List<WebElement> suppDocPageCnt;
	public List<WebElement> suppDocPageCnt(){
		return suppDocPageCnt;
	}			
	
	@FindBy(css="a[href*='supplierDetail.pdf']")
	private List<WebElement> suppDocLinks;
	public List<WebElement> suppDocLinks(){
		return suppDocLinks;
	}				

	//Related Suppliers
	
	@FindBy(xpath="//th[contains(@title,'Supplier')]/../../..//td[1]")
	private List<WebElement> relSuppNames;
	public List<WebElement> relSuppNames(){
		return relSuppNames;
	}		
	
	@FindBy(xpath="//th[contains(@title,'Supplier ID')]/../../..//td[2]")
	private List<WebElement> relSuppIDs;
	public List<WebElement> relSuppIDs(){
		return relSuppIDs;
	}	
	
	@FindBy(xpath="//th[contains(@title,'Parent Lavante UID')]/../../..//td[3]")
	private List<WebElement> relSuppParentLavanteUIDs;
	public List<WebElement> relSuppParentLavanteUIDs(){
		return relSuppParentLavanteUIDs;
	}

	@FindBy(xpath="//th[contains(@title,'Contact')]/../../..//td[4]")
	private List<WebElement> relSuppContacts;
	public List<WebElement> relSuppContacts(){
		return relSuppContacts;
	}

	@FindBy(xpath="//th[contains(@title,'TIN')]/../../..//td[5]")
	private List<WebElement> relSuppTINs;
	public List<WebElement> relSuppTINs(){
		return relSuppContacts;
	}

	@FindBy(xpath="//th[contains(@title,'Statement')]/../../..//td[6]")
	private List<WebElement> relSuppStatementStatuses;
	public List<WebElement> relSuppStatementStatuses(){
		return relSuppStatementStatuses;
	}	

}
