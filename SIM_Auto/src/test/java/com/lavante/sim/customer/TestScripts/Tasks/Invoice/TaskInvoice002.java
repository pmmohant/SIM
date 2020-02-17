package com.lavante.sim.customer.TestScripts.Tasks.Invoice;


import java.io.IOException;
import java.sql.SQLException;
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
public class  TaskInvoice002 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> loginDataMap=new LinkedHashMap<String, String>();
	String customerID="";
	
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
		lavanteUtils.driver=driver;
		
		//Login
		List<?> listofdatafrm=lavanteUtils.login("Task-Invoice", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID= (String) listofdatafrm.get(1);
		
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
		
	
	/** Enhancement: SIM-7178 - ‘Split Invoice’ popup gets closed on click of ‘Cancel’ button
	 * Point No 20
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 * @throws SQLException 
	 */	
	@Test(dataProvider="SplitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void OrgNumberConfigure001(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Configurable Split invoice :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		dataMap.put("InvoiceType","Non PO");
		dataMap.remove("supplierName");
		enTaskinvoicestoApprve.Search(dataMap);
		

		String key="AutoSP"+LavanteUtils.randomnum();
		
		String Query=" Insert into I18NKey (   i18nKey) VALUES (  '"+key+"' )";
		String Query2="Insert into UserTranslation (   i18nKey  ,LanguageID  ,UTFString,IsCustomerSpecific) VALUES ("
				+ "   '"+key+"'   ,50   ,'"+key+"',1  )";
		String Query3="insert into InvoiceOrganizationNumbers (   InvoiceOrganizationNumber  ,InvoiceOrganizationNumber_i18nKey  ,CustomerID) "
				+ "VALUES (   '"+key+"'   ,'"+key+"'  ,"+customerID+"  )";
		
		boolean invfound=false;
		
		int x=enobjhomePage.TotalPage().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
				if(invtype.equalsIgnoreCase("Non PO")){
					invfound=true;
					Reporter.log("Found NON PO Invoice for Split");
			
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
					lavanteUtils.UpdateDB(Query);
					lavanteUtils.UpdateDB(Query2);
					lavanteUtils.UpdateDB(Query3);
					Reporter.log("Inserted into DB Org number:"+key);
					
					//NON PO
					Reporter.log("NON PO invoice available:");
					
					Reporter.log("Split Invoice page");
					ensplitInvoice.SplitInvoice(dataMap);
					for(int j=1;j<ensplitInvoice.splitdelete().size();j++){
							lavanteUtils.click(ensplitInvoice.splitdelete().get(0));
					}
					
					dataMap.put("OrgNumber",""+key);
					ensplitInvoice.fillInvoice(dataMap);
					dataMap.put("SaveSplit", "");
					ensplitInvoice.formAction(dataMap);
	
					//lavanteUtils.waitForTime(3000);
					//enobjhomePage.popupclose();
					
					Reporter.log("Split invoice Saved");
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i));
					lavanteUtils.fluentwait(eninvoicePage.suppname());
					String app3=enTaskinvoicestoApprve.VIEWinvorg().get(enTaskinvoicestoApprve.VIEWinvorg().size()-1).getText();
					String org=dataMap.get("OrgNumber");
					
					
					Reporter.log("In app,orgapp:"+app3+",org:"+org);
					softassert.assertEquals( app3,org,"not matched,Expected: ,Actual:"+app3);
					enobjhomePage.popupclose();
					
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
			String query=" delete from InvoiceCodingDetails where InvoiceOrganizationNumberID in "
			+ " (select InvoiceOrganizationNumberID from InvoiceOrganizationNumbers where InvoiceOrganizationNumber_i18nKey='"+key+"') ";
			lavanteUtils.UpdateDB(query);
			query="delete from InvoiceOrganizationNumbers where InvoiceOrganizationNumber_i18nKey='"+key+"'";
			lavanteUtils.UpdateDB(query);
			query="delete from UserTranslation where i18nKey='"+key+"'";
			lavanteUtils.UpdateDB(query);
			query="delete From I18NKey where i18nKey='"+key+"'";
			lavanteUtils.UpdateDB(query);
		
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}
		
		softassert.assertAll();
		Reporter.log("Test ended to check cancel button in split invoice :"+currenttime());
		
	}	

	/** Enhancement: SIM-7178 - ‘Split Invoice’ popup gets closed on click of ‘Cancel’ button
	 * Point No 20
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 * @throws SQLException 
	 */	
	@Test(dataProvider="SplitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void AccNumberConfigure002(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Configurable Split invoice :"+currenttime());
		
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;

		dataMap.put("InvoiceType","Non PO");
		dataMap.remove("supplierName");
		enTaskinvoicestoApprve.Search(dataMap);
		
		String key="AutoSP"+randomnum();
		String Query=" Insert into I18NKey (   i18nKey) VALUES (  '"+key+"' )";
		String Query2="Insert into UserTranslation (   i18nKey  ,LanguageID  ,UTFString,IsCustomerSpecific) VALUES ("
				+ "   '"+key+"'   ,50   ,'"+key+"',1  )";
		String Query3="Insert into AccountNumbers (AccountNumber    ,CustomerID    ,AccountNumber_i18nKey  )"
				+ " VALUES (  '"+key+"'  ,"+customerID+" ,'"+key+"'    )";
	
		
		boolean invfound=false;
		int x=enobjhomePage.TotalPage().size();
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
				
				Reporter.log("Split Invoice page");
				lavanteUtils.UpdateDB(Query);
				lavanteUtils.UpdateDB(Query2);
				lavanteUtils.UpdateDB(Query3);
				
				Reporter.log("insert into db:"+key);
			
				ensplitInvoice.SplitInvoice(dataMap);
				
				lavanteUtils.switchtoFrame(ensplitInvoice.IFRAMESplitInvoice());
				for(int j=1;j<ensplitInvoice.splitdelete().size();j++){
					lavanteUtils.click(ensplitInvoice.splitdelete().get(0));
				}
				
				dataMap.put("AccNumber",""+key);
				dataMap.put("SplitAmount",ensplitInvoice.TotalInvAmount().getText());
				ensplitInvoice.fillInvoice(dataMap);
				dataMap.put("SaveSplit", "");
				ensplitInvoice.formAction(dataMap);
				
				Reporter.log("Split invoice Saved");
				lavanteUtils.switchtoFrame(null);
		
				lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i));
				lavanteUtils.fluentwait(eninvoicePage.suppname());
				String app3=enTaskinvoicestoApprve.VIEWinvacc().get(enTaskinvoicestoApprve.VIEWinvacc().size()-1).getText();
				String acc=dataMap.get("AccNumber");
				
				Reporter.log("In app AccNumber,accapp:"+app3+",acc:"+acc);
				softassert.assertEquals( app3,acc,"AccNumber not matched,Expected: "+acc+",Actual:"+app3);
				
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
			 softassert.assertTrue(false,"Please Add NON PO ");
			 flag=true;
		}
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}

		String query=" delete from InvoiceCodingDetails where AccountNumberID in "
				+ " (select AccountNumberID from AccountNumbers where AccountNumber_i18nKey='"+key+"') ";
		lavanteUtils.UpdateDB(query);
		query="delete from AccountNumbers where AccountNumber_i18nKey='"+key+"'";
		lavanteUtils.UpdateDB(query);
		query="delete from UserTranslation where i18nKey='"+key+"'";
		lavanteUtils.UpdateDB(query);
		query="delete From I18NKey where i18nKey='"+key+"'";
		lavanteUtils.UpdateDB(query);

		
		softassert.assertAll();
		Reporter.log("Test ended to check cancel button in split invoice :"+currenttime());
		
	}	

	/** Enhancement: SIM-7178 - Adding net amount value to special characters and checking after clicking on cancel button that was getting displayed or not in view invoice
	 * point 
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test(dataProvider="SubmitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void splitcancel003(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for split cancel:"+currenttime());
		boolean flag=false;		
		SoftAssert softassert=new SoftAssert();

		dataMap.put("InvoiceType","Non PO");
		dataMap.remove("supplierName");
		enTaskinvoicestoApprve.Search(dataMap);
		
		boolean invfound=false;
		int xx=enobjhomePage.TotalPage().size();
		if(xx==0){
			xx=1;
		}
		outr:for(int ji=0;ji<xx;ji++){
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
				if(invtype.equalsIgnoreCase("Non PO")){
					Reporter.log("Found NON PO Invoice for Split");
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
					invfound=true;
					lavanteUtils.waitForTime(3000);
				
					ensplitInvoice.SplitInvoice(dataMap);
					Reporter.log("Split Invoice page");
					
					lavanteUtils.switchtoFrame(ensplitInvoice.IFRAMESplitInvoice());
					String x=ensplitInvoice.TotalInvAmount().getText();
					x=x.replaceAll("\\,", "");
					Float ttlmnt=Float.parseFloat(x);
					Reporter.log("before adding total invoice amount is :"+ttlmnt);
					Float intialamnt=ttlmnt+1000;	
					String xamnt=intialamnt+"";
					
					dataMap.put("SplitAmount",xamnt);
					Reporter.log("after adding 1000 to  total invoice amnt:"+xamnt);
					
					ensplitInvoice.fillInvoice(dataMap);
					dataMap.put("Cancelbtn","");
					ensplitInvoice.formAction(dataMap);
					
					Reporter.log("click on cancel button");
	
					lavanteUtils.switchtoFrame(null);
					
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i));
					lavanteUtils.waitForTime(3000);
					lavanteUtils.fluentwait(eninvoicePage.suppname());
					for(int j=0;j<enTaskinvoicestoApprve.VIEWinvamnt().size();){
						String app1=enTaskinvoicestoApprve.VIEWinvamnt().get(j).getText();
						Reporter.log("Splitview:"+app1);
						softassert.assertNotEquals(app1,xamnt,"total invoice amount not matched,Expected: ,Actual:"+app1);
						flag=true;
						break outr;
					}
			  }
			}if(invfound==false){
				int y=ji+1;
				if(y<xx){
					lavanteUtils.click(enobjhomePage.TotalPage().get(y));
				}
			}
		}
		
		 if(invfound==false){
			 softassert.assertTrue(false,"Please Add NON PO ");
			 flag=true;
		}
		 
		if(flag==false){
			softassert.assertTrue(false,"Please Recheck");
		}
		softassert.assertAll();
		Reporter.log("Test ended for split cancel:"+currenttime());
		
	}	
	
	/** Enhancement: SIM-7178 -deleting the rows in split invoice
	 * point 
	 * @author Piramanayagam S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test(dataProvider="SplitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void splitdelete004(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for split delete:"+currenttime());
		boolean flag = false,invfound=false;		
		SoftAssert softassert=new SoftAssert();
		
		dataMap.put("InvoiceType","Non PO");
		dataMap.remove("supplierName");
		enTaskinvoicestoApprve.Search(dataMap);
		
		int x=enobjhomePage.TotalPage().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){ 
		for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
			String invtype=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i).getText();
			if(invtype.equalsIgnoreCase("Non PO")){
				invfound=true;
				Reporter.log("Found NON PO Invoice for Split");
				lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").get(i));
				lavanteUtils.waitForTime(3000);
				ensplitInvoice.SplitInvoice(dataMap);
				
				Reporter.log("Split Invoice page");
				
				int k=ensplitInvoice.splitdelete().size();
                for(int j=0;j<k;j++){	
					lavanteUtils.click(ensplitInvoice.splitdelete().get(0));
					Reporter.log("Split coding details is deleted");
					if(j==k-1){
						lavanteUtils.switchtoFrame(null);
						String error=ensplitInvoice.spliterrdelete().getText();
						String exp="This row cannot be deleted.";
						Reporter.log("Expected error message, when all Split is deleted:"+exp+",Actual:"+error);
						softassert.assertEquals( error,exp,"error message not matched,Expected:"+exp+" ,Actual:"+error);
						lavanteUtils.fluentwait(ensplitInvoice.OKbtn());
						lavanteUtils.click(ensplitInvoice.OKbtn());
						Reporter.log("click on ok button");
						flag=true;
						break outr;
					}
					
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
			 softassert.assertTrue(false,"Please Add NON PO ");
			 flag=true;
		}
		 
		if(flag==false){
				softassert.assertTrue(false,"Please Recheck");
		}
				
		softassert.assertAll();
		Reporter.log("Test ended for split delete:"+currenttime());
		
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

