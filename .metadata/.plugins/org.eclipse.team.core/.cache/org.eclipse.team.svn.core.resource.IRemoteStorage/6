package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class CustomerPropertyInvoice extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	LinkedHashMap<String, String> LdataMap = null;

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Ramya Raj
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {
		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Sanity", browser);
		LdataMap = new LinkedHashMap<String, String>();
				
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

        InsertCustomerProperty("IS_OIG_STATE_LIST_ENABLED");
        InsertCustomerProperty("IS_SAM_ENABLED");
        InsertCustomerProperty("ENABLE_INVOICE_BATCH_PAYMENT_MODULE");
        InsertCustomerProperty("IS_UPLOAD_INVOICE_ENABLED");
        
        
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		

	}

	private void InsertCustomerProperty(String customerProperty) throws FileNotFoundException, IOException, SQLException {
		
		String y="select CustomerPropertyID from CustomerProperty where PropertyName='"+customerProperty+"'";
        y=lavanteUtils.fetchDBdata(y);
        
		String update = "delete customerPropertyValue where CustomerID="+ customerID + " and CustomerPropertyID="+y;
		lavanteUtils.UpdateDB(update);
		
        String x="insert into CustomerPropertyValue (   CustomerPropertyID  ,CustomerID  ,PropertyValue  ,IsActive   ,CreatedBy  ,CreatedOn ) VALUES ( "
        		+ y+","+customerID +",'TRUE',1,'Piramu',getUTCDate() )";
        lavanteUtils.UpdateDB(x);
		
	}

	/**
	 * @author Ramya Raj
	 * 
	 * Invoice batch payment module test  - Customer property
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_ENABLE_INVOICE_BATCH_PAYMENT_MODULETest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("ENABLE_INVOICE_BATCH_PAYMENT_MODULE Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String update  = "update CustomerPropertyValue SET IsActive = 'False' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='ENABLE_INVOICE_BATCH_PAYMENT_MODULE' )";
        lavanteUtils.UpdateDB(update);
		lavanteUtils.refreshPage();
		
		//Verify Payment tab is displayed
		// Transactions Tab-->
		LdataMap.put("maintab", "Transactions");
		enobjhomePage.selectTab(LdataMap);
		boolean flag = false;
		flag = lavanteUtils.isElementDisplayed("a[href='customerPaymentResult.lvp'");
		
		Reporter.log("Payments tab display status , Expected : false , Actual :" + flag);
		softAssert.assertFalse(flag, "Payments tab display status , Expected : false , Actual :" + flag);
		lavanteUtils.refreshPage();
		
		//Transactions Tab-->Invoices
		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(LdataMap);
		
		flag = false;
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		flag = lavanteUtils.isElementDisplayed(eninvoicePage.ViewDrpdwn());
		Reporter.log("View dropdown available status in invoices  , Expected : false , Actual :" + flag);
		softAssert.assertFalse(flag, "View dropdown available status in invoices , Expected : false , Actual :" + flag);
	
		//Verify payment tab is not displayed
		update  = "update CustomerPropertyValue SET IsActive = 'True' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='ENABLE_INVOICE_BATCH_PAYMENT_MODULE' )";
		lavanteUtils.UpdateDB(update);
		lavanteUtils.refreshPage();
		
		LdataMap.clear();
		LdataMap.put("maintab", "Transactions");
		enobjhomePage.selectTab(LdataMap);
		flag = false;
		
		flag = lavanteUtils.isElementDisplayed("//a[@href='customerPaymentResult.lvp']");
		Reporter.log("Payments tab display status , Expected : false , Actual :" + flag);
		softAssert.assertTrue(flag, "Payments tab display status , Expected : true , Actual :" + flag);
		
		lavanteUtils.refreshPage();
		
		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(LdataMap);
		lavanteUtils.waitForTime(5000);
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		flag = false;
		
		flag = lavanteUtils.isElementDisplayed(eninvoicePage.ViewDrpdwn());
		Reporter.log("View dropdown is not available in invoices , Expected : false , Actual :" + flag);
		softAssert.assertTrue(flag, "View dropdown is available in invoices , Expected : true , Actual :" + flag);
		
		update  = "update CustomerPropertyValue SET IsActive = 'True' where CustomerID = "+ customerID + "and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='ENABLE_INVOICE_BATCH_PAYMENT_MODULE' )";
		lavanteUtils.UpdateDB(update);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for IS_ENABLE_INVOICE_BATCH_PAYMENT_MODULETest:" + currenttime());
	}
	
	/**
	 * @author Ramya Raj
	 * 
	 * Upload invoice enabled test  - Customer property
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_UPLOAD_INVOICE_ENABLED() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("UPLOAD INVOICE ENABLED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String update  = "update CustomerPropertyValue SET IsActive = 'True' where CustomerID = "+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_UPLOAD_INVOICE_ENABLED' )";
        lavanteUtils.UpdateDB(update);
		lavanteUtils.refreshPage();
		
		//Verify upload invoice button is displayed
		// Transactions Tab-->Invoices
		LdataMap.put("maintab", "Transactions");
		LdataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(LdataMap);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		lavanteUtils.switchtoFrame(null);
		boolean flag = lavanteUtils.isElementDisplayed(eninvoicePage.uploadInvoicebtn());
		Reporter.log("upload invoice button display status , Expected : true , Actual :" + flag,true);
		softAssert.assertTrue(flag, "upload invoice button display status , Expected : true , Actual :" + flag);
		
		update  = "update CustomerPropertyValue SET IsActive = 'False' where CustomerID = "+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_UPLOAD_INVOICE_ENABLED' )";
        lavanteUtils.UpdateDB(update);
		
		//Verify upload invoice button is not displayed
		lavanteUtils.refreshPage();
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		lavanteUtils.switchtoFrame(null);
		flag = lavanteUtils.isElementDisplayed(eninvoicePage.uploadInvoicebtn());
		Reporter.log("upload invoice button displayed status , Expected : false , Actual :" + flag,true);
		softAssert.assertFalse(flag, "upload invoice button display status , Expected : false , Actual :" + flag);
		
		update  = "update CustomerPropertyValue SET IsActive = 'True' where CustomerID = "+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_UPLOAD_INVOICE_ENABLED' )";
        lavanteUtils.UpdateDB(update);
		
        softAssert.assertAll();
        Reporter.log("Test Ended for IS_UPLOAD_INVOICE_ENABLED Test:" + currenttime());
	}

	/**
	 * @author Ramya Raj
	 * 
	 * Verifying Customer property OIG
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_OIG_ENABLEDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test started for IS_OIG_ENABLED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
        
		String update = "update customerPropertyValue SET IsActive = 'True' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_OIG_STATE_LIST_ENABLED')";
		lavanteUtils.UpdateDB(update);
        update = "update  Customer set IsOIGSLEIEValidationEnabled = 'True' where CustomerID="+ customerID  ;
        lavanteUtils.UpdateDB(update);
		
        //Login to app	
        enobjhomePage.logout();
		enobjloginpage.logintoAPP(LdataMap);
		
		//Navigate to Compliance
		LdataMap.put("maintab", "Compliance");
		enobjhomePage.selectTab(LdataMap);	
	    boolean flag = lavanteUtils.isElementDisplayed(enOIGdetails.OIGlink());
		Reporter.log("OIG availabilty status , Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "OIG availibilty status , Expected : true , Actual :" + flag);
		
		update = "update customerPropertyValue SET IsActive = 'False' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_OIG_STATE_LIST_ENABLED')";
		lavanteUtils.UpdateDB(update);
        update = "update  Customer set IsOIGSLEIEValidationEnabled = 'False' where CustomerID="+ customerID ;
	    lavanteUtils.UpdateDB(update);
		
		enobjhomePage.logout();
	    enobjloginpage.logintoAPP(LdataMap);
	    
		LdataMap.put("maintab", "Compliance");
		enobjhomePage.selectTab(LdataMap);	

		flag = lavanteUtils.isElementDisplayed(enOIGdetails.OIGlink());
		Reporter.log("OIG availabilty status , Expected : false , Actual :" + flag);
		softAssert.assertFalse(flag, "OIG availibilty status , Expected : false , Actual :" + flag);
		
			
		softAssert.assertAll();
	    Reporter.log("Test ended for IS_OIG_ENABLED Test :" + currenttime());
	    
		    
	}
	
	/**
	 * @author Ramya Raj
	 * 
	 * Verifying Customer property SAM
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void IS_SAM_ENABLEDTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test started for IS_SAM_ENABLED Test:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
        
		String update = "";

		//Navigate to Compliance
		LdataMap.put("maintab", "Compliance");
		enobjhomePage.selectTab(LdataMap);	
	    boolean flag = lavanteUtils.isElementDisplayed(enSAMdetails.SAMlink());
		Reporter.log("SAM availabilty status , Expected : true , Actual :" + flag);
		softAssert.assertTrue(flag, "SAM availibilty status , Expected : true , Actual :" + flag);
		
		update = "update customerPropertyValue SET IsActive = 'False' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_SAM_ENABLED')";
		lavanteUtils.UpdateDB(update);
	    update = "update  Customer set IsSAMEPLSValidationEnabled = 'False' where CustomerID=" + customerID ;
	    lavanteUtils.UpdateDB(update);
		
		enobjhomePage.logout();
		enobjloginpage.logintoAPP(LdataMap);
		   
		LdataMap.put("maintab", "Compliance");
		enobjhomePage.selectTab(LdataMap);	

		flag = lavanteUtils.isElementDisplayed(enSAMdetails.SAMlink());
		Reporter.log("SAM availabilty status , Expected : false , Actual :" + flag);
		softAssert.assertFalse(flag, "SAM availibilty status , Expected : false , Actual :" + flag);
		
		softAssert.assertAll();
	    Reporter.log("Test ended for IS_SAM_ENABLED Test :" + currenttime());
	    
		    
	}
	
	/**
	 * @author Ramya Raj
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@AfterMethod
	public void SetupAfterMethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.refreshPage();

		String update = "update customerPropertyValue SET IsActive = 'True' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_OIG_STATE_LIST_ENABLED')";
		lavanteUtils.UpdateDB(update);
		update = "update  Customer set IsOIGSLEIEValidationEnabled = 'True' where CustomerID="+ customerID ;
		lavanteUtils.UpdateDB(update);
		
		update = "update customerPropertyValue SET IsActive = 'True' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_SAM_ENABLED')";
		lavanteUtils.UpdateDB(update);
		update = "update  Customer set IsSAMEPLSValidationEnabled = 'True' where CustomerID=" + customerID ;
		lavanteUtils.UpdateDB(update);
		
		update  = "update CustomerPropertyValue SET IsActive = 'True' where CustomerID = "+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='IS_UPLOAD_INVOICE_ENABLED' )";
        lavanteUtils.UpdateDB(update);

		
	}

    
	 /* @author Ramya Raj
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
