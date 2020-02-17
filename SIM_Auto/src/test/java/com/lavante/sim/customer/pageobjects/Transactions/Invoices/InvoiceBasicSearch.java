/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Transactions.Invoices;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class InvoiceBasicSearch {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public InvoiceBasicSearch(WebDriver driver){
		lavanteUtils.driver=driver;
		
	}
	
	@FindBy(id="search_tab")
	private WebElement BasicSearchTab;
	public WebElement BasicSearchTab(){
		return BasicSearchTab;
	}
	
	@FindBy(css="[id*='hasPromotion'] a")
	private WebElement PromoBillingsDropdown;
	public WebElement PromoBillingsDropdown(){
		return PromoBillingsDropdown;
	}

	@FindBy(css="[id*='hasDeduction_chosen'] a")
	private WebElement AssociatedDeductionsDropdown;
	public WebElement AssociatedDeductionsDropdown(){
		return AssociatedDeductionsDropdown;
	}
	
	@FindBy(id="supplierID")
	private WebElement supplierIDtxt;
	public WebElement supplierIDtxt(){
		return supplierIDtxt;
	}
	
	@FindBy(id="supplierName")
	private WebElement supplierNmetxt;
	public WebElement supplierNmetxt(){
		return supplierNmetxt;
	}	
	
	@FindBy(id="invoiceNumber")
	private WebElement EnterinvoiceNumber;
	public WebElement EnterinvoiceNumber()
	{
		return EnterinvoiceNumber;
	}
	
	@FindBy(css="[id*='invoiceStatusId'] input")
	private WebElement invStatus;
	public WebElement invStatus()
	{
		return invStatus;
	}
	
	@FindBy(id="invoiceAmount")
	private WebElement TotalInvAmnt;
	public WebElement TotalInvAmnt()
	{
		return TotalInvAmnt;
	}
	
	@FindBy(id = "isAttachmentAvailable")
	private WebElement isAtchment;
	
	@FindBy(css="form input[name*='clear']")
	private WebElement Clearbtn;
	public WebElement Clearbtn(){
		return Clearbtn;
	}
	
	
	
	@FindBy(id="invoiceSearch")
	private WebElement Searchbtn;
	public WebElement Searchbtn(){
		return Searchbtn;
	}
	
	//Method starts here
	
	public void Search(LinkedHashMap<String,String> dataMap)
	{
		lavanteUtils.switchtoFrame(null);
		fillSearchdetails(dataMap);
		formAction(dataMap);
		
	}

	public void clickBasicSearchTab() 
	{
		lavanteUtils.click(BasicSearchTab);
	}


	public void fillSearchdetails(LinkedHashMap<String, String> dataMap)
	{
		lavanteUtils.fluentwait(BasicSearchTab);
		if(dataMap.containsKey("SuppID"))
		{
			supplierIDtxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("SuppID"), supplierIDtxt);
		
		}
		if(dataMap.containsKey("SuppName"))
		{
			supplierNmetxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("SuppName"), supplierNmetxt);
		}
		
		if(dataMap.containsKey("InvNum"))
		{
			EnterinvoiceNumber.clear();
			lavanteUtils.typeinEdit(dataMap.get("InvNum"), EnterinvoiceNumber);
		}
		
		if(dataMap.containsKey("InvStatus"))
		{
			invStatus.click();
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("InvStatus"));
		}
		
		if(dataMap.containsKey("TotalInvAmnt"))
		{
			TotalInvAmnt.clear();
			lavanteUtils.typeinEdit(dataMap.get("TotalInvAmnt"), TotalInvAmnt);
		}
		if(dataMap.containsKey("Attachment"))
		{
			lavanteUtils.selectbyvisibiletxt(dataMap.get("Attachment"), isAtchment);
		}
	}


	public void formAction(LinkedHashMap<String, String> dataMap) 
	{
		lavanteUtils.switchtoFrame(null);
		if(dataMap.containsKey("Search"))
		{
			lavanteUtils.click(Searchbtn);
		}else{
			lavanteUtils.click(Clearbtn);
		}
		
	}
	
	
	
	
	
}
