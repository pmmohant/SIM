package com.lavante.sim.customer.TestScripts.Transactions.Invoices;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.InvoiceSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 20-09-2016
 * Created for Invoice status - Basic search as part of SIM UAT.
 * @author tejaswini ar
 */
public class  Invoice_BasicSearch extends PageInitiator  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();	
	
	/**
	 * This class all test starts using login page and driver initialization
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception
	{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		lavanteUtils.driver=driver;
		
		List listofdatafrm=lavanteUtils.login("Invoice",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Invoice");
		dataMap.put("subtab", "InvoiceSearchResult");
		
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
			
	}
	
	/**
	 * As part of SIM UAT
	 * TC_01: Search for different Basic Search. 
	 * 
	 * @author tejaswini ar
	 * @param dataMap
	 * @throws Exception 
	 */	
	@Test(dataProvider="BasicSearch",dataProviderClass=InvoiceSearchDataProvider.class)
	public void BasicSearch(LinkedHashMap<String, String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Basic Search:"+currenttime());
		
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		dataMap.put("Search","");
		eninvoiceBasicSearch.Search(dataMap);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		lavanteUtils.fluentwait(eninvoicePage.Listinvnum().get(0));
		
		if(eninvoicePage.Listinvnum().size()>0){
			
			String expStatus = dataMap.get("InvStatus");
			String appStatus = eninvoicePage.getColumnText("Invoice Status",0);
			Reporter.log("Status for Uploaded Invoice"+eninvoicePage.Listinvnum().get(0)+",Verification,Expected:"+expStatus+"In app,"+appStatus);
			softassert.assertEquals(appStatus, expStatus,"Status Not Matched for the Invoice,"+expStatus);
			flag=true;
			
		}else
		{
			softassert.assertTrue(flag,"Please Add Data for the Search");
			
		}
		
		softassert.assertTrue(flag,"Please Retest");
		
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Invoice Search:"+currenttime());
		
	}
	
	
	@AfterMethod
	public void SetupAftermethod()
	{
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(eninvoiceBasicSearch.Clearbtn());
		lavanteUtils.waitForTime(4000);
		lavanteUtils.refreshPage();
	}
	
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}
	
	


}

