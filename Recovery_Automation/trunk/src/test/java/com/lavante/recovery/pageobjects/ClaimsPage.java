package com.lavante.recovery.pageobjects;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.lavante.recovery.Common.Util.LavanteUtils;


public class ClaimsPage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public ClaimsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	
	//Invoices link
	//FindBy(linkText = "Invoices")
	@FindBy(css="a[href*='/recovery/invoice.lvp']")
	private WebElement invoicesLink;
	public WebElement invoicesLink(){
		return invoicesLink;
	}
	
	@FindBy(linkText= "Claims")
	private WebElement claims;
	public WebElement claims(){
		return claims;
	}
	
	@FindBy(id="startDate")
	private WebElement startDate;
	public WebElement startDate(){
		return startDate;
	}
	
	
	@FindBy(css="span[title*='Currency in USD']")
	private WebElement usd;
	public WebElement usd(){
		return usd;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(2)")
	private WebElement numberOpen;
	public WebElement numberOpen(){
		return numberOpen;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(3)")
	private WebElement numberProcess;
	public WebElement numberProcess(){
		return numberProcess;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(4)")
	private WebElement numberProcessed;
	public WebElement numberProcessed(){
		return numberProcessed;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(5)")
	private WebElement numberOpenVoided;
	public WebElement numberOpenVoided(){
		return numberOpenVoided;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(6)")
	private WebElement numberOpenRefunded;
	public WebElement numberOpenRefunded(){
		return numberOpenRefunded;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(7)")
	private WebElement numberVoid;
	public WebElement numberVoid(){
		return numberVoid;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(8)")
	private WebElement numberRefund;
	public WebElement numberRefund(){
		return numberRefund;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(9)")
	private WebElement numberHold;
	public WebElement numberHold(){
		return numberHold;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(10)")
	private WebElement numberClosed;
	public WebElement numberClosed(){
		return numberClosed;
		
	}
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(1) td:nth-child(11)")
	private WebElement numberTotal;
	public WebElement numberTotal(){
		return numberTotal;
		
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(2)")
	private WebElement amountOpen;
	public WebElement amountOpen(){
		return amountOpen;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(3)")
	private WebElement amountInProcess;
	public WebElement amountInProcess(){
		return amountInProcess;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(3)")
	private WebElement amountProcessed;
	public WebElement amountProcessed(){
		return amountProcessed;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(4)")
	private WebElement amountopenVoided;
	public WebElement amountopenVoided(){
		return amountProcessed;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(5)")
	private WebElement amountopenRefunded;
	public WebElement amountopenRefunded(){
		return amountProcessed;
	}
	
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(6)")
	private WebElement amountVoid;
	public WebElement amountVoid(){
		return amountVoid;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(7)")
	private WebElement amountRefund;
	public WebElement amountRefund(){
		return amountRefund;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(8)")
	private WebElement amountHold;
	public WebElement amountHold(){
		return amountHold;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(9)")
	private WebElement amountClosed;
	public WebElement amountClosed(){
		return amountClosed;
	}
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(10)")
	private WebElement amountTotal;
	public WebElement amountTotal(){
		return amountTotal;
	}
	
	
	//Claims list table
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(3)")
	private List<WebElement> supplierName;
	public List<WebElement> supplierName(){
		return supplierName;
	}
	
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(4)")
	private List<WebElement> supplierId;
	public List<WebElement> supplierId(){
		return supplierId;
	}
	
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(5)")
	private List<WebElement> claimId;
	public List<WebElement> claimId(){
		return claimId;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(6)")
	private List<WebElement> supplierReference;
	public List<WebElement> supplierReference(){
		return supplierReference;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(7)")
	private List<WebElement> creditDate;
	public List<WebElement> creditDate(){
		return creditDate;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(8)")
	private List<WebElement> claimAmount;
	public List<WebElement> claimAmount(){
		return claimAmount;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(9)")
	private List<WebElement> currency;
	public List<WebElement> currency(){
		return currency;
	}
	
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(10)")
	private List<WebElement> dateSubmitted;
	public List<WebElement> dateSubmitted(){
		return dateSubmitted;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(11)")
	private List<WebElement> organization;
	public List<WebElement> organization(){
		return organization;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(12)")
	private List<WebElement> claimStatus;
	public List<WebElement> claimStatus(){
		return claimStatus;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(13)")
	private List<WebElement> reason;
	public List<WebElement> reason(){
		return reason;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(14)")
	private List<WebElement> type;
	public List<WebElement> type(){
		return type;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(15)")
	private List<WebElement> comment;
	public List<WebElement> comment(){
		return comment;
	}
	
	@FindBy(css="table[id='claimDetailsTable'] tbody tr td:nth-child(16)")
	private List<WebElement> doc;
	public List<WebElement> doc(){
		return doc;
	}
	
	@FindBy(css="bulk_update")
	private WebElement markAsProcessed;
	public WebElement markAsProcessed(){
		return markAsProcessed;
	}
		
	@FindBy(css="input[class='button_blue']")
	private WebElement backButton;
	public WebElement backButton(){
		return backButton;
	}
	
	
	
}







	

