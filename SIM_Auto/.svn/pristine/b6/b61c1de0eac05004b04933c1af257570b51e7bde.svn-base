package com.lavante.sim.customer.TestScripts.Transactions.Invoices;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.InvoiceDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 25-11-2016
 * Created for Invoice Test case
 * Enhancement covered SIM - 9507
 * Ended on 25-11-2016
 * @author Piramanayagam.S
 *
 */
public class  UATInvoiceTC004 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String customerid="";
	
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
		List listofdatafrm=lavanteUtils.login("Invoice",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		
	}
	
	/**
	 * In this Class all test starts from Edit profile -Supplier contract management tab,hence navigated to the page
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@BeforeMethod
	public void beforeClassMethod() throws FileNotFoundException, IOException, SQLException{
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		String query="update CustomerPropertyValue SET PropertyValue='true' where CustomerPropertyID=41 and CustomerID="+customerid;
		lavanteUtils.UpdateDB(query);
		dataMap.put("maintab","Invoice");
		dataMap.put("subtab", "InvoiceSearchResult");
		
		enobjhomePage.selectTab(dataMap);
		
	}
	
	/**
	 * Enhancement-SIM-9507 
	 * Upload Invoice SOW with Deliverable with split amount for Multiple Deliverable
	 * Verify the same in Invoice and payment Search view
	 * 
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws Exception 
	 */
	@Test(dataProvider="SplitInvoiceAmnt",dataProviderClass=InvoiceDataProvider.class)
	public void SplitDeliverableInvoiceTC001(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Verification of Split Deliverable Invoice:"+currenttime());
		
		dataMap.put("Upload", "");
		eninvoicePage.formAction(dataMap);
		
		String invnum="AutoSP"+randomnum()+customerid;
		dataMap.put("InvNum", invnum);
		dataMap.put("uploadSave","");
		dataMap.put("SelectSupplier","");
		dataMap.put("ANYSplit", "");
		dataMap.put("supplierName",eninvoicePage.fetchDelSupplier(customerid));
		dataMap.put("InvSOWNum","ANY");
		int[] s=enuploadInvoice.UploadInvoice(dataMap);

		eninvoicePage.ViewSelection("Payments");
		Reporter.log("Viewing Invoice "+invnum+",in Invoice and Payment View");
		
		dataMap.put("InvNum",invnum);
		dataMap.put("Search","");	
		eninvoiceBasicSearch.Search(dataMap);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		
		for(int i=0;i<eninvoicePage.TBLPayinvamnt().size();i++){
			String appStatus=eninvoicePage.TBLPayinvamnt().get(i).getText();
			appStatus=LavanteUtils.replaceString(appStatus,",","");
			appStatus=LavanteUtils.replaceString(appStatus,".00","");
			int Totalinvamount=Integer.parseInt(appStatus);
			System.out.println("Delievrable Split, Amount matched"+s[i]+","+Totalinvamount);
			Reporter.log("Delievrable Split, Amount matched"+s[i]+","+Totalinvamount);
			Assert.assertEquals(Totalinvamount, s[i],"Deliverable Split,Amount Not matched"+s[i]+","+appStatus);
		}
		
		Reporter.log("Test Ended for Verification of SplitDeliverableInvoice:"+currenttime());
	
	}

	/**
	 * Enhancement-SIM-9507 
	 * Upload Invoice SOW with Deliverable with split amount for Single Deliverable
	 * Verify the same in Invoice and payment Search view
	 * 
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws Exception 
	 */
	@Test(dataProvider="SubmitInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void SplitSingleDeliverableInvoiceTC002(LinkedHashMap<String, String> dataMap) throws Exception
	{
		Reporter.log("Test Started for Verification of Split Single Deliverable Invoice:"+currenttime());
		
		dataMap.put("Upload", "");
		eninvoicePage.formAction(dataMap);
		
		String invnum="AutoSP"+randomnum()+customerid;
		dataMap.put("InvNum", invnum);
		dataMap.put("uploadSave","");
		dataMap.put("SelectSupplier","");
		dataMap.put("supplierName",eninvoicePage.fetchDelSupplier(customerid));
		dataMap.put("InvSOWNum","ANY");
		dataMap.put("SingleSplit", "");
		int[] s=enuploadInvoice.UploadInvoice(dataMap);
		
		Reporter.log("Viewing Invoice, "+invnum+",in Invoice and Payment View");
		
		eninvoicePage.ViewSelection("Payments");
		
		dataMap.put("InvNum",invnum);
		dataMap.put("Search","");	
		eninvoiceBasicSearch.Search(dataMap);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		
		for(int i=0;i<eninvoicePage.TBLPayinvamnt().size();i++){
			String appStatus=eninvoicePage.TBLPayinvamnt().get(i).getText();
			appStatus=LavanteUtils.replaceString(appStatus,",","");
			appStatus=LavanteUtils.replaceString(appStatus,".00","");
			int Totalinvamount=Integer.parseInt(appStatus);
		
			System.out.println("Delievrable,Single Split, Amount matched"+s[i]+","+Totalinvamount);
			Reporter.log("Delievrable,Single Split, Amount matched"+s[i]+","+Totalinvamount);
			Assert.assertEquals(Totalinvamount, s[i],"Deliverable Split,Amount Not matched"+s[i]+","+appStatus);
		}
		
		Reporter.log("Test Ended for Verification of Split Single Deliverable Invoice:"+currenttime());
	
	}

	
	@AfterMethod
	public void SetupAftermethod()
	{
		enobjhomePage.popupclose();
	}
	
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}



}

