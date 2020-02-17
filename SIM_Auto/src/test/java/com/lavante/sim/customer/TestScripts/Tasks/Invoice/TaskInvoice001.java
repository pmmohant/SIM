package com.lavante.sim.customer.TestScripts.Tasks.Invoice;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.InvoiceDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 28-03-2016
 * Created for Split Invoice Enhancement
 * Enhancement covered SIM -7178
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class  TaskInvoice001 extends PageInitiator  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();	
	String CustomerID="";
	
	/**
	 * This class all test starts using login page and driver initialization
	 * @author Piramanayagam.S
	 * 
	 */
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		List<?> listofdatafrm=lavanteUtils.login("Task-Invoice", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		CustomerID=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
	}

	@BeforeMethod
	public void Before(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Tasks");
		dataMap.put("subtab", "getInvoiceTasks");
		enobjhomePage.selectTab(dataMap);
	}
	
	 /** Enhancement: SIM-7178 - split invoice button for NON-PO
	  * point 4
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test
	public void splitinvbuttNonpoUI() throws Exception
	{
		
		Reporter.log("Test Started for to check split invoice button is enabled or not for Nonpo:"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		boolean flag = false,poinv=false,invfound=false;

		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		dataMap.put("InvoiceType","Non PO");
		enTaskinvoicestoApprve.Search(dataMap);

		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
				if(invtype.equalsIgnoreCase("Non PO")){
					invfound=true;
					Reporter.log("Found NON PO Invoice for Split:"+enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i).getText());
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
					//ti.invtype().get(i)
					Reporter.log("NON PO Split Invoicebtn:"+ensplitInvoice.SplitInvoicebtn().isEnabled());
					softAssert.assertTrue(ensplitInvoice.SplitInvoicebtn().isEnabled(),"NON PO SPlit Button is not Enabled/Disabled:"+ensplitInvoice.SplitInvoicebtn().isEnabled());
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
					flag=true;
					break outr;
				}else if(invtype.equalsIgnoreCase("PO")){
					poinv=true;
					Reporter.log("Found PO Invoice for Split:"+enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i).getText());
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
					Reporter.log("PO Split Invoice btn:"+ensplitInvoice.SplitInvoicebtn().isEnabled());
					softAssert.assertFalse(ensplitInvoice.SplitInvoicebtn().isEnabled(),"PO Split Button is not Enabled/Disabled:"+ensplitInvoice.SplitInvoicebtn().isEnabled());
					flag=true;
					break outr;
				}
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
	
		if(flag==false){
			softAssert.assertTrue(false,"Please add data and RETEST");
		}
		
		softAssert.assertAll();
		Reporter.log("Test ended for to check split invoice button is enabled or not for Nonpo :"+currenttime());
		
	}
	
	 /** Enhancement: SIM-7178 - ‘Split Invoice’ Popup with the header: ‘Split Invoice’ gets popped up on click of ‘Split Invoice’ button for ‘Non-PO’ Invoice.
	  * point 7,6,5
		 * @author Piramanayagam S
		 * @param dataMap
		 * @throws IOException 
		 */	
	@Test
	public void splitinvpopupUI() throws Exception
		{
			
		Reporter.log("Test Started to check Split Invoice’ POPUP UI Verification :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false,invfound=false;
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		dataMap.put("InvoiceType","Non PO");
		enTaskinvoicestoApprve.Search(dataMap);
	
		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
			String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
			if(invtype.equalsIgnoreCase("Non PO")){
				Reporter.log("Found NON PO Invoice for Split");
				invfound=true;
				lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
				//NON PO
				lavanteUtils.click(ensplitInvoice.Actnbtn());
				lavanteUtils.click(ensplitInvoice.SplitInvoicebtn());
				
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(ensplitInvoice.SplitInvoiceheader());
				
				String splitpop=ensplitInvoice.SplitInvoiceheader().getText();
				Reporter.log("split invoice popup Header, Expected:Split Invoice, Actual:"+splitpop);
				softassert.assertEquals( splitpop,"Split Invoice","header not matched for split invoice,Expected: ,Actual:"+splitpop);
				
				lavanteUtils.switchtoFrame(ensplitInvoice.IFRAMESplitInvoice());
				lavanteUtils.fluentwait(ensplitInvoice.SplitInvoicenumber());
				
				String splitinv=ensplitInvoice.SplitInvoicenumber().getText();
				splitinv=splitinv.substring(0,splitinv.length()-1);
				Reporter.log("Split invoice Number, Expected:Invoice Number, Actual:"+splitinv);
				softassert.assertEquals( splitinv,"Invoice Number","invoice number not matched,Expected: ,Actual:"+splitinv);
					
				String splitdate=ensplitInvoice.SplitInvoicedate().getText();
				splitdate=splitdate.substring(0,splitdate.length()-1);
				Reporter.log("split invoice date, Expected:Invoice Date, Actual:"+splitdate);
				softassert.assertEquals( splitdate,"Invoice Date","invoice date not matched,Expected: ,Actual:"+splitdate);
					
				String splitamnt=ensplitInvoice.Splitnetamnt().getText();
				splitamnt=splitamnt.substring(0,splitamnt.length()-1);
				Reporter.log("split invoice amount, Expected:Net Amount, Actual:"+splitamnt);
				softassert.assertEquals( splitamnt,"Net Amount","invoice net amount not matched,Expected:Net Amount ,Actual:"+splitamnt);
					
				String splitax=ensplitInvoice.Splittaxamnt().getText();
				splitax=splitax.substring(0,splitax.length()-1);
				Reporter.log("split invoice tax amount, Expected:Tax Amount, Actual:"+splitax);
				softassert.assertEquals( splitax,"Tax Amount","tax amount not matched,Expected: ,Actual:"+splitax);
		
				String splitframnt=ensplitInvoice.Splitfreightamnt().getText();
				splitframnt=splitframnt.substring(0,splitframnt.length()-1);
				Reporter.log("split invoice freight amount, Expected:Freight Amount, Actual:"+splitframnt);
				softassert.assertEquals( splitframnt,"Freight Amount","freight amount not matched,Expected: ,Actual:"+splitframnt);
		
				String splitcurr=ensplitInvoice.Splitcurrency().getText();
				splitcurr=splitcurr.substring(0,splitcurr.length()-1);
				Reporter.log("split invoice currency, Expected:Currency, Actual:"+splitcurr);
				softassert.assertEquals( splitcurr,"Currency","currency not matched,Expected: ,Actual:"+splitcurr);
				
				String splitot=ensplitInvoice.Splittotinvoiceamnt().getText();
				splitot=splitot.substring(0,splitot.length()-1);
				Reporter.log("split total invoice, Expected:Total Invoice Amount, Actual:"+splitot);
				softassert.assertEquals( splitot,"Total Invoice Amount","total invoice amount not matched,Expected: ,Actual:"+splitot);
				
				String splitsta=ensplitInvoice.Splitinvoicesta().getText();	
				splitsta=splitsta.substring(0,splitsta.length()-1);
				Reporter.log("split invoice status, Expected:Invoice Status, Actual:"+splitsta);
				softassert.assertEquals( splitsta,"Invoice Status","status not matched,Expected: ,Actual:"+splitsta);
				
				String splittyp=ensplitInvoice.Splitinvtype().getText();
				splittyp=splittyp.substring(0,splittyp.length()-1);
				Reporter.log("split invoice type, Expected:Invoice Type, Actual:"+splittyp);
				softassert.assertEquals( splittyp,"Invoice Type","type not matched,Expected: ,Actual:"+splittyp);
			
				String cancelbutt=ensplitInvoice.Cancelbtn().getText();
				Reporter.log("split invoice cancel button, Expected:Cancel, Actual:"+cancelbutt);
				softassert.assertEquals( cancelbutt,"Cancel","not matched,Expected: ,Actual:"+cancelbutt);
				
				String s1=ensplitInvoice.Savebtn().getText();
				Reporter.log(" Expected:Save, Actual:"+s1);
				softassert.assertEquals( s1,"Save","not matched,Expected: ,Actual:"+s1);
				
				lavanteUtils.click(ensplitInvoice.Cancelbtn());
				Reporter.log("Split Invoice’ popup gets closed on click of ‘Cancel’ button");
				flag=true;
				break outr;
				}
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}

		softassert.assertAll();
		Reporter.log("Test ended to check Split Invoice’ POPUP UI Verification :"+currenttime());
			
	}	
		
	/** Enhancement: SIM-7178 - On Edit Invoice popup - For the Invoice Type = SOW  – The Invoice Coding info’ section gets displayed
	 * point 18,20
	* @author Piramanayagam S
	* @param dataMap
	* @throws IOException 
	*/	
	@Test
	public void UILABELinvtypesowedit() throws Exception
	{
			
		Reporter.log("Test Started to check coding details header and edit invoice page header :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false,invfound=false;
		
		LinkedHashMap<String,String > dataMap=new LinkedHashMap<>();
		enTaskinvoicestoApprve.Search(dataMap);
	
		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
				if(invtype.equalsIgnoreCase("SOW")){
					Reporter.log("Edit invoice in task page of type sow,Supplier Name:"+enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Supplier Name").get(i).getText());

					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Task ID").get(i));
					lavanteUtils.click(ensplitInvoice.Actnbtn());
					lavanteUtils.click(enTaskinvoicestoApprve.EditInvoice());
					
					lavanteUtils.switchtoFrame(enTaskinvoicestoApprve.IFRAMEEditInvoice());
					lavanteUtils.fluentwait(enTaskinvoicestoApprve.labeledittaxamnt());
					Reporter.log("EDIT Invoice page:");
					
					String codingheader=enTaskinvoicestoApprve.Labeleditcodingheader().getText();
					Reporter.log(" Expected:Invoice Coding Details, Actual:"+codingheader);
					softassert.assertEquals( codingheader,"Invoice Coding Details","not matched,Expected:Invoice Coding Details ,Actual:"+codingheader);
					
					String editinv=enTaskinvoicestoApprve.labeleditInvoicenumber().getText();
					editinv=editinv.substring(0,editinv.length()-1);
					Reporter.log("Expected:Invoice Number, Actual:"+editinv);
					softassert.assertEquals( editinv,"Invoice Number","invoice number not matched,Expected:Invoice Number ,Actual:"+editinv);
				
					String editdate=enTaskinvoicestoApprve.labeleditInvoicedate().getText();
					editdate=editdate.substring(0,editdate.length()-1);
					Reporter.log(" Expected:Invoice Date, Actual:"+editdate);
					softassert.assertEquals( editdate,"Invoice Date","invoice date not matched,Expected:Invoice Date ,Actual:"+editdate);
										
					String editamnt=enTaskinvoicestoApprve.labeleditnetamnt().getText();
					editamnt=editamnt.substring(0,editamnt.length()-1);
					Reporter.log(" Expected:Net Amount, Actual:"+editamnt);
					softassert.assertEquals( editamnt,"Net Amount","invoice net amount not matched,Expected:Net Amount ,Actual:"+editamnt);
									
					String edittax=enTaskinvoicestoApprve.labeledittaxamnt().getText();
					edittax=edittax.substring(0,edittax.length()-1);
					Reporter.log(" Expected:Tax Amount, Actual:"+edittax);
					softassert.assertEquals( edittax,"Tax Amount","tax amount not matched,Expected:Tax Amount ,Actual:"+edittax);
				
					String editframnt=enTaskinvoicestoApprve.labeleditfreightamnt().getText();
					editframnt=editframnt.substring(0,editframnt.length()-1);
					Reporter.log("Expected:Freight Amount, Actual:"+editframnt);
					softassert.assertEquals( editframnt,"Freight Amount","freight amount not matched,Expected:Freight Amount ,Actual:"+editframnt);
				
					String editcurr=enTaskinvoicestoApprve.labeleditcurrency().getText();
					editcurr=editcurr.substring(0,editcurr.length()-1);
					Reporter.log(" Expected:Currency, Actual:"+editcurr);
					softassert.assertEquals( editcurr,"Currency","currency not matched,Expected:Currency ,Actual:"+editcurr);
					
					String edittot=enTaskinvoicestoApprve.labeledittotinvoiceamnt().getText();
					edittot=edittot.substring(0,edittot.length()-1);
					Reporter.log("Expected:Total Invoice Amount, Actual:"+edittot);
					softassert.assertEquals( edittot,"Total Invoice Amount","total invoice amount not matched,Expected:Total Invoice Amount ,Actual:"+edittot);
					
					String editsta=enTaskinvoicestoApprve.labeleditinvoicesta().getText();	
					editsta=editsta.substring(0,editsta.length()-1);
					Reporter.log(" Expected:Invoice Status, Actual:"+editsta);
					softassert.assertEquals( editsta,"Invoice Status","status not matched,Expected:Invoice Status ,Actual:"+editsta);
					
					String editDate=enTaskinvoicestoApprve.labeleditinvsubdate().getText();
					editDate=editDate.substring(0,editDate.length()-1);
					Reporter.log(" Expected:Invoice Submission Date, Actual:"+editDate);
					softassert.assertEquals( editDate,"Invoice Submission Date","Date not matched,Expected:Invoice Submission Date ,Actual:"+editDate);
				
					String edittyp=enTaskinvoicestoApprve.labeleditinvtype().getText();
					edittyp=edittyp.substring(0,edittyp.length()-1);
					Reporter.log(" Expected:Invoice Type, Actual:"+edittyp);
					softassert.assertEquals( edittyp,"Invoice Type","Invoice type not matched,Expected:Invoice Type ,Actual:"+edittyp);
					
					/*
					String editamnt1=eninvoices.labeleditinvamnt().getText();
					Reporter.log(" Expected:Amount, Actual:"+editamnt1);
					softassert.assertEquals( editamnt1,"Amount","Invoice amnt not matched,Expected:Amount ,Actual:"+editamnt1);*/
				
					String editsow=enTaskinvoicestoApprve.labeleditinvsow().getText();
					editsow=editsow.substring(0,editsow.length()-1);
					Reporter.log(" Expected:SOW Number, Actual:"+editsow);
					softassert.assertEquals( editsow,"SOW Number","SOW Number not matched,Expected:SOW Number ,Actual:"+editsow);
				/*
					String editline=eninvoices.editinvlineitem().getText();
					Reporter.log(" Expected:Line Item - Item Type - Description, Actual:"+editline);
					softassert.assertEquals( editline,"Line Item - Item Type - Description","Item Type not matched,Expected: ,Actual:"+editline);*/
				
				/*	String editl=eninvoices.editinvlaborcode().getText();
					Reporter.log(" Expected:Labor Code, Actual:"+editl);
					softassert.assertEquals( editl,"Labor Code","Labor Code not matched,Expected: ,Actual:"+editl);
				
					String editv=eninvoices.editinvvendor().getText();
					Reporter.log(" Expected:Vendor Employee, Actual:"+editv);
					softassert.assertEquals( editv,"Vendor Employee","Employee not matched,Expected: ,Actual:"+editv);
					
					String editpl=eninvoices.editinvplc().getText();
					Reporter.log(" Expected:PLC, Actual:"+editpl);
					softassert.assertEquals( editpl,"PLC","PLC not matched,Expected: ,Actual:"+editpl);
							
					String edith=eninvoices.editinvhrs().getText();
					Reporter.log(" Expected:Hours, Actual:"+edith);
					softassert.assertEquals( edith,"Hours","Hours not matched,Expected: ,Actual:"+edith);*/
					flag=true;
					break outr;
				}
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck,NO data Available");
		}
		
		softassert.assertAll();
		Reporter.log("Test ended to check coding details header and edit invoice page header :"+currenttime());
	
	}	
	
	/** Enhancement: SIM-7178 - On Edit Invoice popup - For the Invoice Type = PO  – The Invoice Coding info’ section gets displayed
	 * point 19,18
	* @author Piramanayagam S
	* @param dataMap
	* @throws IOException 
	*/	
	@Test
	public void LabelinvtypePOeditUIVerify() throws Exception	{
			
		Reporter.log("Test Started to check coding details header and edit invoice page header of type po :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false,invfound=false;
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		dataMap.put("InvoiceType","PO");
		enTaskinvoicestoApprve.Search(dataMap);

		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
			String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
			if(invtype.equalsIgnoreCase("PO")){
				invfound=true;
				Reporter.log("Found PO Invoice:"+enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i).getText());
				lavanteUtils.waitForTime(3000);
				lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Task ID").get(i));
				lavanteUtils.click(ensplitInvoice.Actnbtn());
				
				lavanteUtils.click(enTaskinvoicestoApprve.EditInvoice());
				Reporter.log("Edit invoice in task page of type PO");
				
				lavanteUtils.switchtoFrame(enTaskinvoicestoApprve.IFRAMEEditInvoice());
				lavanteUtils.waitForTime(3000);
				
				Reporter.log("EDIT Invoice page:");
			
				
				String editinv=enTaskinvoicestoApprve.labeleditInvoicenumber().getText();
				editinv=editinv.substring(0,editinv.length()-1);
				Reporter.log("Expected:Invoice Number, Actual:"+editinv);
				softassert.assertEquals( editinv,"Invoice Number","invoice number not matched,Expected: ,Actual:"+editinv);
							
				String editdate=enTaskinvoicestoApprve.labeleditInvoicedate().getText();
				editdate=editdate.substring(0,editdate.length()-1);
				Reporter.log(" Expected:Invoice Date, Actual:"+editdate);
				softassert.assertEquals( editdate,"Invoice Date","invoice date not matched,Expected: ,Actual:"+editdate);
								
				String editamnt=enTaskinvoicestoApprve.labeleditnetamnt().getText();
				editamnt=editamnt.substring(0,editamnt.length()-1);
				Reporter.log(" Expected:Net Amount, Actual:"+editamnt);
				softassert.assertEquals( editamnt,"Net Amount","invoice net amount not matched,Expected:Net Amount ,Actual:"+editamnt);
								
				String edittax=enTaskinvoicestoApprve.labeledittaxamnt().getText();
				edittax=edittax.substring(0,edittax.length()-1);
				Reporter.log(" Expected:Tax Amount, Actual:"+edittax);
				softassert.assertEquals( edittax,"Tax Amount","tax amount not matched,Expected:Tax Amount ,Actual:"+edittax);
			
				String editframnt=enTaskinvoicestoApprve.labeleditfreightamnt().getText();
				editframnt=editframnt.substring(0,editframnt.length()-1);
				Reporter.log("Expected:Freight Amount, Actual:"+editframnt);
				softassert.assertEquals( editframnt,"Freight Amount","freight amount not matched,Expected:Freight Amount ,Actual:"+editframnt);
			
				String editcurr=enTaskinvoicestoApprve.labeleditcurrency().getText();
				editcurr=editcurr.substring(0,editcurr.length()-1);
				Reporter.log(" Expected:Currency, Actual:"+editcurr);
				softassert.assertEquals( editcurr,"Currency","currency not matched,Expected:Currency ,Actual:"+editcurr);
				
				String edittot=enTaskinvoicestoApprve.labeledittotinvoiceamnt().getText();
				edittot=edittot.substring(0,edittot.length()-1);
				Reporter.log("Expected:Total Invoice Amount, Actual:"+edittot);
				softassert.assertEquals( edittot,"Total Invoice Amount","total invoice amount not matched,Expected:Total Invoice Amount ,Actual:"+edittot);
				
				String editsta=enTaskinvoicestoApprve.labeleditinvoicesta().getText();	
				editsta=editsta.substring(0,editsta.length()-1);
				Reporter.log(" Expected:Invoice Status, Actual:"+editsta);
				softassert.assertEquals( editsta,"Invoice Status","status not matched,Expected:Invoice Status ,Actual:"+editsta);
				
				String editDate=enTaskinvoicestoApprve.labeleditinvsubdate().getText();
				editDate=editDate.substring(0,editDate.length()-1);
				Reporter.log(" Expected:Invoice Submission Date, Actual:"+editDate);
				softassert.assertEquals( editDate,"Invoice Submission Date","Invoice Submission Date not matched,Expected: Invoice Submission Date,Actual:"+editDate);
			
				String edittyp=enTaskinvoicestoApprve.labeleditinvtype().getText();
				edittyp=edittyp.substring(0,edittyp.length()-1);
				Reporter.log(" Expected:Invoice Type, Actual:"+edittyp);
				softassert.assertEquals( edittyp,"Invoice Type","type not matched,Expected: Invoice Type,Actual:"+edittyp);
			
				String codingheader=enTaskinvoicestoApprve.Labeleditcodingheader().getText();
				Reporter.log(" Expected:Invoice Coding Details, Actual:"+codingheader);
				softassert.assertEquals( codingheader,"Invoice Coding Details","not matched,Expected:Invoice Coding Details ,Actual:"+codingheader);
				
				String editamnt1=enTaskinvoicestoApprve.labeleditinvamnt().getText();
				Reporter.log(" Expected:Amount, Actual:"+editamnt1);
				softassert.assertEquals( editamnt1,"Amount","Amount not matched,Expected:Expected:Amount ,Actual:"+editamnt1);
			
				String editsow=enTaskinvoicestoApprve.Labeleditinvpo().getText();
				Reporter.log(" Expected:PO Number, Actual:"+editsow);
				softassert.assertEquals( editsow,"PO Number","PO Num not matched,Expected:PO Number ,Actual:"+editsow);
			
				String editline=enTaskinvoicestoApprve.labeleditinvrcvrnum().getText();
				Reporter.log(" Expected:Reciever Number, Actual:"+editline);
				softassert.assertEquals( editline,"Receiver Number","Not matched,Expected:Receiver Number ,Actual:"+editline);
				
				String editl=enTaskinvoicestoApprve.labeleditinvlaborcode().getText();
				Reporter.log(" Expected:Labor Code, Actual:"+editl);
				softassert.assertEquals( editl,"Labor Code","type not matched,Expected:Labor Code ,Actual:"+editl);
			
				String editv=enTaskinvoicestoApprve.labeleditinvvendor().getText();
				Reporter.log(" Expected:Vendor Employee, Actual:"+editv);
				softassert.assertEquals( editv,"Vendor Employee","type not matched,Expected: Vendor Employee,Actual:"+editv);
				
				String editpl=enTaskinvoicestoApprve.labeleditinvplc().getText();
				Reporter.log(" Expected:PLC, Actual:"+editpl);
				softassert.assertEquals( editpl,"PLC","PLC not matched,Expected:PLC ,Actual:"+editpl);
							
				String edith=enTaskinvoicestoApprve.labeleditinvhrs().getText();
				Reporter.log(" Expected:Hours, Actual:"+edith);
				softassert.assertEquals( edith,"Hours","type not matched,Expected:Hours ,Actual:"+edith);
				
				flag=true;
				break outr;
				}
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		
		if(invfound==false){
			softassert.assertTrue(false,"Please Add PO Invoice");
			flag=true;
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}
		softassert.assertAll();
	
		Reporter.log("Test ended to check coding details header and edit invoice page header of type po :"+currenttime());
	
	}	
	
	/** Enhancement: SIM-7178 -On Customer Portal – Supplier View Profile – Enterprise Owned Invoice page gets displayed with all the invoice info uploaded per Supplier
	 * point 27,28
	 * UI Verification
	* @author Piramanayagam S
	* @param dataMap
	* @throws IOException
	*/	
	@Test
	public void viewInvoiceVerifyUI() throws Exception
	{
		Reporter.log("Test Started View Invoice Verification :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		enTaskinvoicestoApprve.Search(dataMap);
		
		Reporter.log("View Supplier:"+enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Supplier Name").get(0).getText(),true);
		lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Supplier Name").get(0));
		
		lavanteUtils.switchtoFrame(null);
		String supname=enviewSupplier.BusinessName().getText();
		
		dataMap.put("maintab","Enterprise");
		dataMap.put("subtab","Invoices");
		enviewSupplier.selectTab(dataMap);
		Reporter.log("Invoice Tab:");
	
		lavanteUtils.waitForTime(3000);
		
		lavanteUtils.switchtoFrame(enviewSupplier.IFRAMEINV());

		String id=enviewSupplier.getInvoiceColumnText("ERP ID", 0);
		String name=enviewSupplier.getInvoiceColumnText("Supplier Name", 0);
		String num=enviewSupplier.getInvoiceColumnText("Number", 0);
		String date=enviewSupplier.getInvoiceColumnText("Date", 0);
		String net=enviewSupplier.getInvoiceColumnText("Net Amount", 0);
		String tax=enviewSupplier.getInvoiceColumnText("Tax Amount", 0);
		String freamnt=enviewSupplier.getInvoiceColumnText("Freight Amount", 0);
		String invamnt=enviewSupplier.getInvoiceColumnText("Total", 0);
		String curr=enviewSupplier.getInvoiceColumnText("Currency", 0);
		String sta=enviewSupplier.getInvoiceColumnText("Status", 0);
		
		Reporter.log("clicked on invoice number");
		lavanteUtils.click(enviewSupplier.TBLinvnumb());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.waitForTime(3000);
		
		Reporter.log("invoice detail page:");
		
		String id1=eninvoicePage.suppid().getText();
		String name1=eninvoicePage.suppname().getText();
		String num1=eninvoicePage.invnumb().getText();
		String date1=eninvoicePage.invdate().getText();
		String net1=eninvoicePage.netamnt().getText();
		String tax1=eninvoicePage.taxamnt().getText();
		String freamnt1=eninvoicePage.freightamnt().getText();
		String invamnt1=eninvoicePage.totinvamnt().getText();
		String curr1=eninvoicePage.currency().getText();
		curr1=curr1.substring(0,3);
		String sta1=eninvoicePage.invstatus().getText();
		
		Reporter.log("ID Expected:"+id+", Actual:"+id1);
		softassert.assertEquals(id,id1,"ID not Matched" );
		
		Reporter.log("Supp Name Expected :"+supname+", Actual:"+name1);
		softassert.assertEquals(supname,name1,"Name not matched" );
		
		Reporter.log("Expected Num:"+num+", Actual:"+num1);
		softassert.assertEquals(num,num1,"Num Not Matched" );
		
		Reporter.log("Expected Date:"+date+", Actual:"+date1);
		softassert.assertEquals(date,date1,"Date Not Matched"  );
		
		Reporter.log("Expected Net Amnt:"+net+", Actual:"+net1);
		softassert.assertEquals(net,net1,"Net Amnt Not Matched" );
		
		Reporter.log("Expected Tax Amnt:"+tax+", Actual:"+tax1);
		softassert.assertEquals(tax,tax1 ,"Tax Amnt Not Matched");
		
		Reporter.log("Expected Frieght Amnt:"+freamnt+", Actual:"+freamnt1);
		softassert.assertEquals(freamnt,freamnt1,"Freight amnt Not Matched" );
		
		Reporter.log("Expected Inv Amnt:"+invamnt+", Actual:"+invamnt1);
		softassert.assertTrue(invamnt.contains(invamnt1) ,"Inv Amnt Not Matched");
		
		Reporter.log("Expected Currency:"+curr+", Actual:"+curr1);
		softassert.assertEquals(curr,curr1 ,"Curr Not Matched");
		
		Reporter.log("Expected Status:"+sta+", Actual:"+sta1);
		softassert.assertEquals(sta,sta1,"Status Not Matched" );
		
		softassert.assertAll();
	
		Reporter.log("Test ended to invoice info uploaded per Supplier :"+currenttime());
	
	}	
	
	/** Enhancement: SIM-7178 - ‘Split Invoice’ popup gets closed on click of ‘Cancel’ button
	 * point 15
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test(dataProvider="SplitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void SplitOneRow(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started to check split invoice in one row :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false,invfound=false;
		dataMap.put("InvoiceType","Non PO");
		dataMap.remove("supplierName");
		enTaskinvoicestoApprve.Search(dataMap);
		
		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
				if(invtype.equalsIgnoreCase("Non PO"))
				{
					invfound=true;
					Reporter.log("Found NON PO Invoice for Split");
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
					Reporter.log("Split Invoice page");
					
					dataMap.put("AddCount","1");
					ensplitInvoice.SplitInvoice(dataMap);

					String amnt1=ensplitInvoice.TotalInvAmount().getText();
					if(amnt1.contains(","))
			    	{
						amnt1=amnt1.replace(",","");
			    	}
					dataMap.put("SplitAmount",amnt1);
					lavanteUtils.waitForTime(3000);
					ensplitInvoice.fillInvoice(dataMap);
					
					Reporter.log("Split Invoice save button display:"+ensplitInvoice.Savebtn().isDisplayed());
					softassert.assertTrue(ensplitInvoice.Savebtn().isDisplayed(), "Save Button is not shown");
					
					dataMap.put("SaveSplit", "");
					ensplitInvoice.formAction(dataMap);
					
					lavanteUtils.switchtoFrame(null);
					
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i));
					lavanteUtils.fluentwait(eninvoicePage.suppname());
					lavanteUtils.waitForTime(6000);
					String app1=enTaskinvoicestoApprve.VIEWinvamnt().get(0).getText();
					if(app1.contains(","))
			    	{
						app1=app1.replace(",","");
			    	}
					Reporter.log("In app,Amnt:"+app1+",Amnt:"+amnt1);
					softassert.assertEquals( app1,amnt1,"not matched,Expected:"+amnt1+",Actual:"+app1);
					
					String app3=enTaskinvoicestoApprve.VIEWinvorg().get(0).getText();
					String org=dataMap.get("OrgNumber");
					Reporter.log("In app,orgapp:"+app3+",org:"+org);
					softassert.assertEquals( app3,org,"not matched,Expected: ,Actual:"+app3);
					
					String app5=enTaskinvoicestoApprve.VIEWinvpro().get(0).getText();
					String proj=dataMap.get("ProjNumber");
					Reporter.log("In app,proapp:"+app5+",pro:"+proj);
					softassert.assertEquals( app5,proj,"not matched,Expected: ,Actual:"+app5);
				
					String app7=enTaskinvoicestoApprve.VIEWinvacc().get(0).getText();
					String aac=dataMap.get("AccNumber");
					Reporter.log("In app,accapp:"+app7+",acc:"+aac);
					softassert.assertEquals( app7,aac,"not matched,Expected: ,Actual:"+app7);
					flag=true;
					break outr;
					}
			} if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		
		if(invfound==false){
			softassert.assertTrue(false,"Test Data Not avaialble,Please ADD NON PO ");
			flag=true;
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}
		softassert.assertAll();
		Reporter.log("Test ended to check split invoice in one row :"+currenttime());
		
	}	
	
	/**Enhancement: SIM-7178 
	 * -The ‘Invoice Coding info’ details gets saved properly & the same gets reflected with the ‘Split Invoice’ details on 
	 *  ‘View Invoice’ popup for Invoice Type=’Non-PO’. 
	 * point 15
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test(dataProvider="SplitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void SplitMultiRow(LinkedHashMap<String, String> dataMap) throws Exception
	{
			Reporter.log("Test Started to check split multiple row in split invoice:"+currenttime());
			SoftAssert softassert=new SoftAssert();
			boolean flag=false,invfound=false;
			dataMap.put("InvoiceType","Non PO");
			dataMap.remove("supplierName");
			enTaskinvoicestoApprve.Search(dataMap);
		
			int x=enobjhomePage.TotalPageNw().size();
			if(x==0){
				x=1;
			}
			outr:for(int ji=0;ji<x;ji++){
			for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
					String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
					if(invtype.equalsIgnoreCase("Non PO")){
					
						String invAmnt=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i).getText();
						if(invAmnt.length()>4){
					
						Reporter.log("Found NON PO Invoice for Split");
						invfound=true;
						lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
						
						//NON PO
						Reporter.log("NON PO invoice available:");
						Reporter.log("Split Invoice page:");

						dataMap.put("AddCount","2");
						ensplitInvoice.SplitInvoice(dataMap);
						
						String totlaamnt=ensplitInvoice.TotalInvAmount().getText();
						totlaamnt=totlaamnt.replace(",","");
						float ttlmnt=Float.parseFloat(totlaamnt);

						float intialamnt=ttlmnt-1;
						
						String amnt1=""+intialamnt+"0";
						String amnt2="1.00";
						
						String xx=ensplitInvoice.TotalInvAmount().getText();
						xx=xx.replaceAll("\\,", "");
						
						Reporter.log("Invoice Total:"+xx);
						
						dataMap.put("SplitAmount",amnt1+"#"+amnt2);
						ensplitInvoice.fillInvoice(dataMap);
						
						dataMap.put("SaveSplit","");
						ensplitInvoice.formAction(dataMap);
						Reporter.log("New Split-1 Amnt Entered:"+amnt1);
						Reporter.log("New Split-2 Amnt Entered:"+amnt2);
						
						Reporter.log("Split invoice Saved");
						
						lavanteUtils.switchtoFrame(null);
				
						lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i));
						lavanteUtils.fluentwait(eninvoicePage.suppname());
						lavanteUtils.fluentwait(enTaskinvoicestoApprve.VIEWinvamnt().get(0));
						String app1=enTaskinvoicestoApprve.VIEWinvamnt().get(0).getText();
						String app2=enTaskinvoicestoApprve.VIEWinvamnt().get(1).getText();
						if(app1.contains(","))
				    	{
							app1=app1.replace(",","");
				    	}
						Reporter.log("In app,New Amnt:"+app1+",Amnt:"+amnt1);
						softassert.assertEquals( app1,amnt1,"not matched,Expected:"+amnt1+",Actual:"+app1);
						Reporter.log("In app,New Amnt:"+app2+",Amnt:"+amnt2);
						softassert.assertEquals( app2,amnt2,"not matched,Expected:"+app2+" ,Actual:"+app2);
						
						String app3=enTaskinvoicestoApprve.VIEWinvorg().get(0).getText();
						String org=dataMap.get("OrgNumber");
						String app4=enTaskinvoicestoApprve.VIEWinvorg().get(1).getText();
						
						
						Reporter.log("In app,orgapp:"+app3+",org:"+org);
						softassert.assertEquals( app3,org,"not matched,Expected: ,Actual:"+app3);
						Reporter.log("In app,New Amnt:"+app4+",Amnt:"+org);
						softassert.assertEquals( app4,org,"not matched,Expected: ,Actual:"+app4);
						
						
						String app5=enTaskinvoicestoApprve.VIEWinvpro().get(0).getText();
						String proj=dataMap.get("ProjNumber");
						String app6=enTaskinvoicestoApprve.VIEWinvpro().get(1).getText();
						
						
						Reporter.log("In app,proapp:"+app5+",pro:"+proj);
						softassert.assertEquals( app5,proj,"not matched,Expected: ,Actual:"+app5);
						Reporter.log("In app,projapp:"+app6+",pro:"+proj);
						softassert.assertEquals( app6,proj,"not matched,Expected: ,Actual:"+app6);
						
					
						String app7=enTaskinvoicestoApprve.VIEWinvacc().get(0).getText();
						String aac=dataMap.get("AccNumber");
						String app8=enTaskinvoicestoApprve.VIEWinvacc().get(1).getText();
						
						
						Reporter.log("In app,accapp:"+app7+",acc:"+aac);
						softassert.assertEquals( app7,aac,"not matched,Expected: ,Actual:"+app7);
						Reporter.log("In app,accapp:"+app8+",acc:"+aac);
						softassert.assertEquals( app8,aac,"not matched,Expected: ,Actual:"+app8);
					flag=true;
					break outr;
					}
				}	
				}if(invfound==false){
					int y=ji+1;
					if(y<x){
						lavanteUtils.click(enobjhomePage.TotalPage().get(y));
					}
				}
			}	
			
		if(invfound==false){
			softassert.assertTrue(false,"Test Data Not avaialble,Please ADD NON PO ");
			flag=true;
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}
			
			softassert.assertAll();
			Reporter.log("Test ended to check split multiple row in split invoice :"+currenttime());
		
	}	
		
	/** Enhancement: SIM-7178 - ‘Split Invoice’ popup gets closed on click of ‘Cancel’ button
	 * point 16
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test
	public void NONPOSplitAmntVerification() throws Exception
	{
		
		Reporter.log("Test Started for split amount verification :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false,invfound=false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		
		dataMap.put("InvoiceType","Non PO");
		enTaskinvoicestoApprve.Search(dataMap);
		
		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
				if(invtype.equalsIgnoreCase("Non PO")){
					
					String invAmnt=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Total Invoice Amount").get(i).getText();
					String invnum=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i).getText();
					System.out.println(invnum+",Inv which has amnt:"+invAmnt);
					Reporter.log(invnum+",Inv which has amnt:"+invAmnt);
					if(invAmnt.length()>4){

						Reporter.log("Found NON PO Invoice for Split");
						invfound=true;
						lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
						
						//NON PO
						Reporter.log("NON PO invoice available:");
						lavanteUtils.click(ensplitInvoice.Actnbtn());
						lavanteUtils.click(ensplitInvoice.SplitInvoicebtn());
						Reporter.log("Split Invoice page");
						
						dataMap.put("AddCount","2");
						ensplitInvoice.SplitInvoice(dataMap);
						
						String xx=ensplitInvoice.TotalInvAmount().getText();
						xx=xx.replaceAll("\\,", "");
						Float ttlmnt=Float.parseFloat(xx);
						String Attlmnt=""+ttlmnt;
						
						
						Reporter.log("Testing for greater than Total Inv Amnt:");
						String amnt1=""+1;
						
						dataMap.put("SplitAmount",Attlmnt+"#"+amnt1);
						dataMap.put("OrgNumber","ANY");
						dataMap.put("AccNumber","ANY");
						dataMap.put("ProjNumber","ANY");
						ensplitInvoice.fillInvoice(dataMap);
						
						dataMap.put("SaveError", "");
						ensplitInvoice.formAction(dataMap);
						lavanteUtils.switchtoFrame(ensplitInvoice.IFRAMESplitInvoice());
						Reporter.log("Total Inv Amnt:"+ttlmnt+",Entered Amnt:"+amnt1);
						String error=ensplitInvoice.spliterrmess().getText();
						String exp="Sum of split amount should be same as Total invoice amount";
						Reporter.log("Expected:"+exp+",Actual:"+error);
						softassert.assertEquals( error,exp,"More invoice amount not matched,Expected:"+exp+" ,Actual:"+error);
					
						Reporter.log("Testing for Less than Total Inv Amnt:");
						
						Float intialamnts=ttlmnt-2;	
						String amnt2=""+intialamnts+"0";
					
						dataMap.put("SplitAmount",amnt2+"#"+amnt1);
						ensplitInvoice.fillInvoice(dataMap);
						ensplitInvoice.formAction(dataMap);
						lavanteUtils.switchtoFrame(ensplitInvoice.IFRAMESplitInvoice());
						Reporter.log("Total Inv Amnt:"+ttlmnt+",Entered Amnt:"+amnt2);
						error=ensplitInvoice.spliterrmess().getText();
						Reporter.log("Expected:"+exp+",Actual:"+error);
						softassert.assertEquals( error,exp,"Less invoice net amount not matched,Expected:"+exp+" ,Actual:"+error);
						flag=true;
						break outr;
					}
				}
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		
		if(!invfound){
			softassert.assertTrue(false,"Test Data Not avaialble,Please ADD NON PO ");
			flag=true;
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}

		softassert.assertAll();
		Reporter.log("Test ended for split amount verification :"+currenttime());
		
	}	
		
	/** Enhancement: SIM-7178 - ‘Split Invoice’ popup gets closed on click of ‘Cancel’ button
	 * Point No 20
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test(dataProvider="SplitErrorMSG",dataProviderClass=InvoiceDataProvider.class)
	public void DataValidation(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Err msg in Split invoice :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false,invfound=false;
		
		
		lavanteUtils.click(enTaskinvoicestoApprve.clear());
		
		dataMap.put("InvoiceType","Non PO");
		dataMap.remove("supplierName");
		enTaskinvoicestoApprve.Search(dataMap);
		
		int x=enobjhomePage.TotalPageNw().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
			String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
			if(invtype.equalsIgnoreCase("Non PO")){
				Reporter.log("Found NON PO Invoice for Split");
				invfound=true;
				lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Task ID").get(i));

				//NON PO
				Reporter.log("NON PO invoice available:");
				
				ensplitInvoice.SplitInvoice(dataMap);
				
				Reporter.log("Split Invoice page:");
				
				String xx=dataMap.get("NetAmnt");
				
				lavanteUtils.Scrollintoview(ensplitInvoice.addNwbtn());
				lavanteUtils.click(ensplitInvoice.addNwbtn());
				Reporter.log("CLICKED ADD NEW");
				
				dataMap.put("SplitAmount",xx);
				
				ensplitInvoice.fillInvoice(dataMap);
				lavanteUtils.click(ensplitInvoice.Savebtn());
				
				lavanteUtils.waitForTime(3000);
				
				String error=ensplitInvoice.spliterrmess().getText();
				String exp=dataMap.get("ErrorMsg");
				Reporter.log("Expected:"+exp+",Actual:"+error);
				softassert.assertEquals( error,exp,"invoice net amount not matched,Expected:"+exp+" ,Actual:"+error);
				flag=true;
				break  outr;
				}
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		
		if(invfound==false)
		{
			softassert.assertTrue(false,"Please Configure NON PO Invoice for the user");
			flag=true;
		}
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}
		
		softassert.assertAll();
		Reporter.log("Test ended for Err msg in Split invoice :"+currenttime());
		
	}	

	@AfterMethod
	public void SetupAftermethod()
	{
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
	}
		
	@AfterClass
	public void SetupafterClassmethod(){
		
		enobjhomePage.logout();
		quitBrowser();
	}



}

