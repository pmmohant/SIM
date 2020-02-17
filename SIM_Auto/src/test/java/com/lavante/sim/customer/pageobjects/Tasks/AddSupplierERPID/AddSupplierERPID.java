/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Tasks.AddSupplierERPID;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Navigate to Task - Invoices page & Save & approve an Invoice
 * @author tejaswini.ar
 */
public class AddSupplierERPID 
{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public AddSupplierERPID(WebDriver driver)
	{
		lavanteUtils.driver=driver;
	}
	
//Web Elements 
	
	
	@FindBy(css="iframe[src*='getERPSupplier']")
	private WebElement IFRAMEresolve;
	public WebElement IFRAMEresolve()
	{
		return IFRAMEresolve;
	}
	
	@FindBy(id="searchFilter")
	private WebElement searchName;
	public WebElement searchName()
	{
		return searchName;
	}
	
	@FindBy(id="supplierSearch")
	private WebElement searchbtn;
	public WebElement searchbtn()
	{
		return searchbtn;
	}
	
	
	@FindBy(id="supplier")
	private List<WebElement> ListSName;
	public List<WebElement> ListSName()
	{
		return ListSName;
	}


	@FindBy(css="input[name*='supplierErpId']")
	private List<WebElement> ERPID;
	public List<WebElement> ERPID()
	{
		return ERPID;
	}
	
	@FindBy(id="actionButton")
	private WebElement AddERPbtn;
	public WebElement AddERPbtn()
	{
		return AddERPbtn;
	}
	
	@FindBy(css="div[class*='dia'] button[class*='primary']")
	private WebElement OKBtn;
	public WebElement OKBtn()
	{
		return OKBtn;
	}
	
	@FindBy(css="a[href*='getERPSupplier']")
	private WebElement duplicateERPmsg;
	public WebElement duplicateERPmsg()
	{
		return duplicateERPmsg;
	}
	
	//Resolve
	
	@FindBy(id="comment")
	private WebElement Commenttxt;
	public WebElement Commenttxt()
	{
		return Commenttxt;
	}

	@FindBy(css="input[class*='primary']")
	private WebElement Resolvebtn;
	public WebElement Resolvebtn()
	{
		return Resolvebtn;
	}
	
	
	//Main Method
		
	public String AddERPID(LinkedHashMap<String, String> dataMap) throws IOException
	{
		String sname="";
		sname=Search(dataMap);
		fillERPID(dataMap);
		formActionERPID();
		lavanteUtils.fluentwait(searchName);
		return sname;
		
	}
	

	public String Search(LinkedHashMap<String, String> dataMap) throws IOException
	{
		if(dataMap.containsKey("supplierName"))
		{
			lavanteUtils.typeinEdit(dataMap.get("supplierName"), searchName());
			lavanteUtils.click(searchbtn);
			lavanteUtils.fluentwait(ListSName.get(0));
			lavanteUtils.waitForTime(4000);
		}	
		
		lavanteUtils.waitforPageload(searchbtn);
		
		String sname=ListSName.get(0).getText();
		return sname;
	}
	
	
	public void fillERPID(LinkedHashMap<String, String> dataMap) throws IOException 
	{
		
		if(dataMap.containsKey("ERPID"))
		{
			if(ERPID().size()>0){
				ERPID().get(0).clear();
				lavanteUtils.typeinEdit(dataMap.get("ERPID"), ERPID().get(0));
			}
		}
		
	}
		
		
	public void formActionERPID() throws IOException 
	{
		
		lavanteUtils.click(AddERPbtn());
		
		lavanteUtils.fluentwait(OKBtn);
		lavanteUtils.click(OKBtn);		
	}



	public void ResolveErpID(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(duplicateERPmsg);
		lavanteUtils.click(duplicateERPmsg);
		lavanteUtils.switchtoFrame(IFRAMEresolve);
		
		if(dataMap.containsKey("Resolve"))
		{
			lavanteUtils.typeinEdit(dataMap.get("Resolve"), Commenttxt);
			lavanteUtils.click(Resolvebtn);
			lavanteUtils.switchtoFrame(null);
		}
		
	}
	
}
