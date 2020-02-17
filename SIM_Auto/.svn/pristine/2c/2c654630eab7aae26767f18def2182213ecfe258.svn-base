package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.InvoiceDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class DivisonFieldForInvoice extends PageInitiator {

		LavanteUtils lavanteUtils = new LavanteUtils();
		String customerid = "";
		String prop = "";
		/*String supCustomerID = "";
		String supprop = "";*/

		@BeforeTest
		@Parameters({ "Platform", "Browser", "Version" })
		public void navigateToLoginPage(
				@Optional(LavanteUtils.Platform) String Platform,
				@Optional(LavanteUtils.browser) String browser,
				@Optional(LavanteUtils.browserVersion) String Version)
				throws Exception {

			launchAppFromPOM(Platform, browser, Version);
			initiate();
			openAPP();
			lavanteUtils.driver = driver;

		}

		/**
		 *Test case to check whether Division field is made mandatory in upload invoice page by setting customerproperty
		 * @author Thejaswi.Bhat 
		 *         
		 */
		@Test(dataProvider="POInvoice",dataProviderClass=InvoiceDataProvider.class)
		public void IsDivisionFieldcheck(LinkedHashMap<String, String> dataMap ) throws Exception {

			Reporter.log("Test started for verifying whether Division field is enabled in Upload Invoice page.."+ currenttime());
			SoftAssert softAssert = new SoftAssert();

			List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
			LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
			LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
			customerid = (String) listofdatafrm.get(1);

			// Login
			enobjloginpage.logintoAPP(LdataMap);
			enobjhomePage.close();

			prop = "SELECT CustomerPropertyID FROM CustomerProperty WHERE PropertyName = 'DIVISION_FIELD_REQUIRED_FOR_UPLOAD_INVOICE'";
			prop = lavanteUtils.fetchDBdata(prop);

			String x = "Select CustomerID from CustomerPropertyValue where CustomerID="
					+ customerid + " and CustomerPropertyID=" + prop;
			x = lavanteUtils.fetchDBdata(x);

			if (x == null) {
				x = "INSERT INTO CustomerPropertyValue(CustomerPropertyID,IsActive,CustomerID,PropertyValue,CreatedBy, CreatedOn) VALUES("
						+ prop
						+ ", 1, "
						+ customerid
						+ ",'true' ,'Automation',getUTCdate())";
				lavanteUtils.UpdateDB(x);
			}

			String activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "
					+ customerid + " and CustomerPropertyID = " + prop;
			lavanteUtils.UpdateDB(activeQuery);
			lavanteUtils.fluentwait(enobjhomePage.UserName());
			
			LdataMap.put("maintab","Invoice");
			LdataMap.put("subtab", "InvoiceSearchResult");
			enobjhomePage.selectTab(LdataMap);
			dataMap.put("Upload", "");
			eninvoicePage.formAction(dataMap);
			
			String invnum="TEJ"+randomnum();
			String supp=eninvoicePage.fetchPoSupplier(customerid);
			dataMap.remove("Division");
			dataMap.put("SuppName",supp);
			dataMap.put("Upload", "");
			dataMap.put("SelectSupplier","");
			dataMap.put("supplierName",supp);
			dataMap.put("PONum", currenttime());
			dataMap.put("InvNum",invnum);
			dataMap.put("SaveAndSubmit","");
			dataMap.put("errorMsg", "");
			enuploadInvoice.UploadInvoice(dataMap);
			dataMap.remove("errorMsg");

			lavanteUtils.fluentwait(enuploadInvoice.errmsg());
			String actMsg=enuploadInvoice.errmsg().getText();
			String  expMsg="'Division (Ship-To)' cannot be left blank.";
			Reporter.log("Exp Banner,:"+expMsg+",Actuals:"+actMsg,true);
			softAssert.assertEquals(actMsg, expMsg,"Err message not matched");
			
        //Not making Division mandatory property 
		    String inactiveQuery = "Update CustomerPropertyValue set IsActive = 0 where CustomerID = " + customerid + " and CustomerPropertyID = " + prop;
			lavanteUtils.UpdateDB(inactiveQuery);
			lavanteUtils.refreshPage();
			lavanteUtils.fluentwait(enobjhomePage.UserName());

			 invnum="TEJ"+randomnum();
			 supp=eninvoicePage.fetchPoSupplier(customerid);
			dataMap.remove("Division");
			dataMap.put("SuppName",supp);
			dataMap.put("Upload", "");
			dataMap.put("SelectSupplier","");
			dataMap.put("supplierName",supp);
			dataMap.put("PONum", currenttime());
			dataMap.put("InvNum",invnum);
			dataMap.put("SaveAndSubmit","");
			enuploadInvoice.UploadInvoice(dataMap);
			
			 actMsg= dataMap.get("BannerMsg");
			 expMsg="Invoice has been submitted for approval.";
			Reporter.log("Exp Banner,:"+expMsg+",Actuals:"+actMsg,true);
			softAssert.assertEquals(actMsg, expMsg,"inv msg incorrect");
			
			dataMap.put("InvNum",invnum);
			dataMap.put("Search","");
			eninvoiceBasicSearch.Search(dataMap);
			
			lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
			String expStatus="Under Review";
			String appStatus=eninvoicePage.getColumnText("Invoice Status",0);
			Reporter.log("Status for Uploaded Invoice,Verification,Expected:"+expStatus+"In app,"+appStatus);
			softAssert.assertEquals(appStatus, expStatus,"Status Not Matched for the Invoice");
			
			appStatus=eninvoicePage.getColumnText("Invoice Number",0);
			Reporter.log("Number for Uploaded Invoice,Verification,Expected:"+invnum+"In app,"+appStatus);
			softAssert.assertEquals(appStatus, invnum,"Number Not Matched for the Invoice");

			softAssert.assertAll();
			Reporter.log("Test Ended:" + currenttime());
		} 

		
		@AfterClass
		public void SetupafterClassmethod() throws FileNotFoundException, IOException, SQLException {
			String activeQuery = "Update CustomerPropertyValue set IsActive =  1 where CustomerID = "
					+ customerid + " and CustomerPropertyID = " + prop;
			lavanteUtils.UpdateDB(activeQuery);
			
			enobjhomePage.logout();
			quitBrowser();
		}

	

}

