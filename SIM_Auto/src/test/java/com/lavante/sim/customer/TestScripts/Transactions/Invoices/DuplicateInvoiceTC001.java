package com.lavante.sim.customer.TestScripts.Transactions.Invoices;


import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
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
 * Created on 24-01-2017
 * Created for Duplicate Invoice TC
 * Enhancement covered SIM 9447
 * Ended on 26-01-2017
 * @author Piramanayagam.S
 *
 */
public class  DuplicateInvoiceTC001 extends PageInitiator {
	
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
		List<?> listofdatafrm=lavanteUtils.login("Invoice",browser);
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
	 * 
	 */
	@BeforeMethod
	public void beforeClassMethod(){
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Invoice");
		dataMap.put("subtab", "InvoiceSearchResult");
		
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
	}
	
	/**
	 * * Enhancement: SIM-9447	
	 * Duplicate Invoice
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws Exception 
	 */
	@Test(dataProvider="POInvoice",dataProviderClass=InvoiceDataProvider.class)
	public void DupInvoice001(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Verification of Status:"+currenttime());
		LinkedHashMap<String, String> dataMaps=dataMap;
		SoftAssert softassert=new SoftAssert();
		
		dataMap.remove("InvNum");
		
		String supp=eninvoicePage.fetchPoSupplier(customerid);
		dataMaps.put("SuppName",supp);
		
		dataMaps.put("Search","");
		eninvoiceBasicSearch.Search(dataMaps);
		
		String orginv="";
		dataMap.put("uploadSave","");
		dataMap.put("PONum", currenttime());
		dataMap.put("supplierName",supp);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		boolean flag=lavanteUtils.isElementDisplayed(eninvoicePage.TBLInvoicenumber());
		if(flag==false){
			dataMap.put("Upload", "");
			dataMap.put("SelectSupplier","");
			eninvoicePage.formAction(dataMap);
			
			orginv="Auto"+currenttime();
			dataMap.put("InvNum",orginv);
			enuploadInvoice.UploadInvoice(dataMap);
			
		}else {
			lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
			orginv=eninvoicePage.TBLInvoicenumber().getText();
			dataMap.put("supplierName",supp);
		}
		dataMap.put("Upload", "");
		eninvoicePage.formAction(dataMaps);
		
		dataMap.put("InvNum", orginv);
		dataMap.put("SelectSupplier","");
		
		enuploadInvoice.UploadInvoice(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(enuploadInvoice.Uploadinvoicebtn());
		
		lavanteUtils.waitForTime(4000);
		String acterrmsg=enuploadInvoice.errmsg().getText();
		
		String expErrmsg="The invoice number is already in use for this supplier. Please enter a unique Invoice Number";
		
		Reporter.log("Error Message for Duplicate Invoice match Status,Exp:"+expErrmsg+",Actual:"+acterrmsg,true);
		softassert.assertEquals(acterrmsg,expErrmsg,"Error Message for Duplicate Invoice not matched,Exp:"+expErrmsg+",Actual:"+acterrmsg);
		
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Status and TotalInvoiceAmount:"+currenttime());
		
		
	}
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}



}

