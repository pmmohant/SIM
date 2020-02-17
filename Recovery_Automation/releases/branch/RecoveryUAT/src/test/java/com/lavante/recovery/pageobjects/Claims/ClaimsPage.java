package com.lavante.recovery.pageobjects.Claims;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.lavante.recovery.Common.Util.LavanteUtils;


public class ClaimsPage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;
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
	
	@FindBy(css="table[class='data_table table_grid zebra toggle_section'] tr:nth-child(2) td:nth-child(11)")
	private WebElement amountTotal;
	public WebElement amountTotal(){
		return amountTotal;
	}
	
	
	//Claims list table
	
	//Select All check box
	@FindBy(css="table[id='claimDetailsTable'] thead input[type='checkbox']")
	private WebElement selectAllCheckBox;
	public WebElement selectAllCheckBox(){
		return selectAllCheckBox;
	}
	
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
	private WebElement claimStatus;
	public WebElement claimStatus(){
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
	
	@FindBy(id="bulk_update")
	private WebElement markAsProcessed;
	public WebElement markAsProcessed(){
		return markAsProcessed;
	}
		
	@FindBy(css="input[class='button_blue']")
	private WebElement backButton;
	public WebElement backButton(){
		return backButton;
	}
	
	
	@FindBy(id="claimstatus")
	private WebElement claimbyStatus;
	public WebElement claimbyStatus(){
		return claimbyStatus;
	}
	
	@FindBy(id="startDate")
	private WebElement startDate;
	public WebElement startDate(){
		return startDate;
	}
	
	
	@FindBy(css="div[class*='infoMessage']")
	private WebElement noClaimsText;
	public WebElement noClaimsText(){
		return noClaimsText;
	}
	
	@FindBy(css="input[value*='Back']")
	private WebElement backButtonInNoClaims;
	public WebElement backButtonInNoClaims(){
		return backButtonInNoClaims;
	}
	
	@FindBy(css="td:nth-child(11)")
	private WebElement claimsListOrganizationValue;
	public WebElement claimsListOrganizationValue(){
		return claimsListOrganizationValue;
	}
	
	
	//IFRAME
	@FindBy(css="iframe[src*='claimbulkupdatePreview']")
	private WebElement IFRAMEclaimbulkupdatePreview;
	public WebElement IFRAMEclaimbulkupdatePreview(){
		return IFRAMEclaimbulkupdatePreview;
	}
	
	//Comment section
	@FindBy(id="comment")
	private WebElement commentSection;
	public WebElement commentSection(){
		return commentSection;
	}
	
	//Save button
	@FindBy( name="save")
	private WebElement saveBtn;
	public WebElement saveBtn(){
		return saveBtn;
	}
	
	// Accept success or failure message dialog box
	@FindBy(css = "div[style*='bloc'] button[class*='button_green']")
	private WebElement confirmationBtn;

	public WebElement confirmationBtn() {
		return confirmationBtn;
	}
	
	//@FindBy(css="span[id='startDate']")
	//private WebElement startDate;
	//public WebElement startDate(){
	//	return startDate;
	
	//Methods
	public void verifydate(){
    	SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yy");
    	Date date = new Date();
    	String expDate = DtFormat.format(date).toString();
    	String actDate = startDate().getText();
    	String[] actualDate = actDate.split("/");
    	String actualMonth1 = actualDate[0];
    	String actualDate1 = actualDate[1];
    	String[] expectedDate = expDate.split("/");
    	String expectedMonth1 = expectedDate[0];
    	String expectedDate1 = expectedDate[1];
    	int actualmonth2 = Integer.parseInt((actualMonth1));
    	int actualdate2 = Integer.parseInt((actualDate1));
    	int expectedmonth2= Integer.parseInt(expectedMonth1);
    	int expecteddate2 = Integer.parseInt(expectedDate1);
    	int flag = 1;
    	int flag1= 1;
    	
}
	
	public void markAsProcessed(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(markAsProcessed);
		lavanteUtils.click(markAsProcessed);
		
		fillClaimsProcessComment(dataMap);
		formClaims(dataMap);		
	}

	private void formClaims(LinkedHashMap<String, String> dataMap) {
		// TODO Auto-generated method stub
		if(dataMap.containsKey("Save")){
			lavanteUtils.switchtoFrame(IFRAMEclaimbulkupdatePreview);
			lavanteUtils.click(saveBtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(confirmationBtn);
			
		}
	}

	private void fillClaimsProcessComment(LinkedHashMap<String, String> dataMap) {
		// TODO Auto-generated method stub
		lavanteUtils.switchtoFrame(IFRAMEclaimbulkupdatePreview);
		if(dataMap.containsKey("Comment")){
			lavanteUtils.typeString(dataMap.get("Comment"), commentSection);			
		}
		
	}
	
}








	

