/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Tasks.Invoice;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Navigate to Task - Invoices page & Save & approve an Invoice
 * @author tejaswini.ar
 */
public class SplitInvoices 
{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public SplitInvoices(WebDriver driver)
	{
		lavanteUtils.driver=driver;
	}
	
//Web Elements for Split Invoice 
	
	@FindBy(css="div[class*='dialog'][style*='vis'] div>span")
	private WebElement SplitInvoiceheader;
	public WebElement SplitInvoiceheader()
	{
		return SplitInvoiceheader;
	}
	
	@FindBy(css="iframe[src*='splitInvoiceForm']")
	private WebElement IFRAMESplitInvoice;
	public WebElement IFRAMESplitInvoice()
	{
		return IFRAMESplitInvoice;
	}
	
	@FindBy(css="[class*='add_new']")
	private WebElement SplitAddNew;
	public WebElement SplitAddNew()
	{
		return SplitAddNew;
	}
	
	@FindBy(css="[title*='Cancel']")
	private WebElement Cancelbtn;
	public WebElement Cancelbtn()
	{
		return Cancelbtn;
	}
	
	@FindBy(how=How.ID,using="button_clear")
	private WebElement Clearbtn;
	public WebElement Clearbtn()
	{
		return Clearbtn;
	}
	
	@FindBy(how=How.ID,using="uploadSupplierInvoice")
	private WebElement Savebtn;
	public WebElement Savebtn()
	{
		return Savebtn;
	}
		
	@FindBy(css="div[class*='dialog-buttons'] div[class*='set'] button span")
	private WebElement OKbtn;
	public WebElement OKbtn()
	{
		return OKbtn;
	}
	
	//split invoice popup
	
	
	@FindBy(css="button[class*='action']")
	private WebElement Actnbtn;
	public WebElement Actnbtn()
	{
		return Actnbtn;
	}
	
	@FindBy(css="input[ng-click][value*='Split']")
	private WebElement SplitInvoicebtn;
	public WebElement SplitInvoicebtn()
	{
		return SplitInvoicebtn;
	}
	
	@FindBy(css="[for='invoiceNumber']")
	private WebElement SplitInvoicenumber;
	public WebElement SplitInvoicenumber()
	{
		return SplitInvoicenumber;
	}
	@FindBy(css="[for='invoiceDate']")
	private WebElement SplitInvoicedate;
	public WebElement SplitInvoicedate()
	{
		return SplitInvoicedate;
	}
	@FindBy(css="[for='invoiceNetAmount']")
	private WebElement Splitnetamnt;
	public WebElement Splitnetamnt()
	{
		return Splitnetamnt;
	}
	@FindBy(css="[for='invoiceTaxAmount']")
	private WebElement Splittaxamnt;
	public WebElement Splittaxamnt()
	{
		return Splittaxamnt;
	}
	@FindBy(css="[for='invoiceShippingAmount']")
	private WebElement Splitfreightamnt;
	public WebElement Splitfreightamnt()
	{
		return Splitfreightamnt;
	}
	@FindBy(css="[for='invoiceCurrency']")
	private WebElement Splitcurrency;
	public WebElement Splitcurrency()
	{
		return Splitcurrency;
	}
	@FindBy(css="[for='invoiceAmount']")
	private WebElement Splittotinvoiceamnt;
	public WebElement Splittotinvoiceamnt()
	{
		return Splittotinvoiceamnt;
	}
	@FindBy(css="[for='invoiceStatus']")
	private WebElement Splitinvoicesta;
	public WebElement Splitinvoicesta()
	{
		return Splitinvoicesta;
	}
	
	@FindBy(css="[for='invoiceSubmissionDate']")
	private WebElement Splitsubdate;
	public WebElement Splitsubdate()
	{
		return Splitsubdate;
	}
	
	@FindBy(css="[for*='invoiceType']")
	private WebElement Splitinvtype;
	public WebElement Splitinvtype()
	{
		return Splitinvtype;
	}
	
	@FindBy(xpath="//*[@id='editSupplierInvoice']//tr[6]/td[2]")
	private WebElement TotalInvAmount;
	public WebElement TotalInvAmount()
	{
		return TotalInvAmount;
	}
	
	@FindBy(css="[id*='editSupplierInvoice'] button")
	private WebElement addNwbtn;
	public WebElement addNwbtn()
	{
		return addNwbtn;
	}
	
	@FindBy(css="[id*='editSupplierInvoice'] button[class*='add']")
	private WebElement SplitaddNwbtn;
	public WebElement SplitaddNwbtn()
	{
		return SplitaddNwbtn;
	}
	
	
	
	@FindBy(css="[data-label*='Amount']")
	private List<WebElement> invamountlist;
	public  List<WebElement> invamountlist()
	{
		return invamountlist;
		
	}
	@FindBy(css="[id*='customerOrganizationId']")
	private List<WebElement> orgnum;
	public  List<WebElement> orgnum()
	{
		return orgnum;
		
	}
	@FindBy(css="[name*='projectNumber']")
	private List<WebElement> prjnumtxt;
	public  List<WebElement> prjnumtxt()
	{
		return prjnumtxt;
		
	}
	@FindBy(css="[id*='accountNumberId']")
	public List<WebElement> accnumdpdn;
	public  List<WebElement> accnumdpdn()
	{
		return accnumdpdn;
		
	}
	
	@FindBy(css="span[class*='error']")
	private WebElement spliterrmess;
	public  WebElement spliterrmess()
	{
		return spliterrmess;
		
	}
	@FindBy(css="[class*='delete']")
	private List<WebElement> splitdelete;
	public  List<WebElement> splitdelete()
	{
		return splitdelete;
		
	}
	
	@FindBy(xpath="//*[contains(@class,'dialog undefined ui-dialog-content ui-widget-content')]")
	private WebElement spliterrdelete;
	public  WebElement spliterrdelete()
	{
		return spliterrdelete;
		
	}
	
	public void SplitInvoice(LinkedHashMap<String, String> dataMap) throws IOException
	{	
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(Actnbtn);
		lavanteUtils.click(SplitInvoicebtn);
		lavanteUtils.switchtoFrame(IFRAMESplitInvoice);
		lavanteUtils.fluentwait(SplitInvoicenumber);
		lavanteUtils.waitForTime(5000);
		lavanteUtils.fluentwait(invamountlist().get(invamountlist().size()-1));
		String x="";
		outr:if(dataMap.containsKey("AddCount")){

			if(splitdelete().size()>1){
				for(int ij=0;ij<splitdelete().size();ij++){
					lavanteUtils.click(splitdelete().get(0));
				}
			}
			
			x=""+invamountlist().size();
			int i=0;
			String data=dataMap.get("AddCount");
			while(!x.equalsIgnoreCase(data)){
				lavanteUtils.click(SplitaddNwbtn);
				x=""+invamountlist().size();
				i=i+1;
				if(i==10){
					break outr;
				}
			}
		}
		
	}

	public void addbtn(){
		lavanteUtils.click(addNwbtn);
	}

	/**
	 * 
	 * @param dataMap
	 */
	public void fillInvoice(LinkedHashMap<String, String> dataMap) {
		
		if(dataMap.containsKey("SplitAmount")){
			String toyype="";
			String invAmnt=TotalInvAmount.getText();
			invAmnt=invAmnt.replace(",", "");
			Float xx=Float.parseFloat(invAmnt)-orgnum.size();
			
			for(int i=0;i<orgnum.size();i++){
				String orgValue=dataMap.get("SplitAmount");
				String[] xdata=new String[10];
				
				if(orgValue.equalsIgnoreCase("ANY")){
					if(i==0){
						//IF 2 size, one should be 1 and other should 99  [100-1]
						xx=Float.parseFloat(invAmnt)-orgnum.size()+1;
						toyype=""+xx;
					}else{
						toyype=""+1;
					}
				}
				if(orgValue.contains("#")){
					xdata=orgValue.split("#");
					toyype=xdata[i];
				}else if(!orgValue.contains("ANY")){
					toyype=orgValue;
				}
				
				invamountlist().get(i).clear();
				lavanteUtils.typeinEdit(toyype,invamountlist().get(i));
				
			}
		}
		if(dataMap.containsKey("OrgNumber")){
			
			for(int i=0;i<orgnum.size();i++){
				String x=dataMap.get("OrgNumber");
				if(x.equalsIgnoreCase("ANY")){
					lavanteUtils.selectbyNumber(1, orgnum().get(i));
				}else{
					lavanteUtils.selectbyvisibiletxt(x, orgnum().get(i));
				}
			}
		}
		if(dataMap.containsKey("AccNumber")){
			for(int i=0;i<accnumdpdn.size();i++){
				String x=dataMap.get("AccNumber");
				if(x.equalsIgnoreCase("ANY")){
					lavanteUtils.selectbyNumber(1, accnumdpdn().get(i));
				}else{
					lavanteUtils.selectbyvisibiletxt(dataMap.get("AccNumber"), accnumdpdn().get(i));
				}
			}
		}
		if(dataMap.containsKey("ProjNumber")){
			for(int i=0;i<prjnumtxt.size();i++){
				String x=dataMap.get("ProjNumber");
				if(x.equalsIgnoreCase("ANY")){
					prjnumtxt().get(i).clear();
					lavanteUtils.typeinEdit("349",prjnumtxt().get(i));
				}else{
					prjnumtxt().get(i).clear();
					lavanteUtils.typeinEdit(dataMap.get("ProjNumber"),prjnumtxt().get(i));
				}
			}
			
		}/*if(dataMap.containsKey("labourcode")){
			
		}if(dataMap.containsKey("vendorEmployee")){
			
		}if(dataMap.containsKey("PLC")){
			
		}if(dataMap.containsKey("Hours")){
			
		}*/
	}

	public void formAction(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("SaveSplit")){
			lavanteUtils.click(Savebtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(3000);
			/*lavanteUtils.fluentwait(OKbtn);
			lavanteUtils.click(OKbtn);*/
		}
		if(dataMap.containsKey("Cancelbtn")){
			lavanteUtils.click(Cancelbtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(3000);
		}
		if(dataMap.containsKey("SaveError")){
			lavanteUtils.click(Savebtn);
			lavanteUtils.waitForTime(3000);
		}
	}


		
}

