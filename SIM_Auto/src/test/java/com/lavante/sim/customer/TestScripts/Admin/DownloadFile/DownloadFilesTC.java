package com.lavante.sim.customer.TestScripts.Admin.DownloadFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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

/**
 * Created on 24-08-2016
 * Created for  UAT
 * Ended on 28-08-2016
 * @author Piramanayagam.S
 *
 */
public class DownloadFilesTC extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String uname="";
	String customerID = "";
	
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openQAAPP3();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		List listofdatafrm=lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		uname=LdataMap.get("username");
		customerID = fetchCustomer(LdataMap.get("username"));

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
			
	}
	
	/**
	 * @author Piramanayagam.S
	 * 
	 *         downloading Records from claims page veifying the pop up
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void verifyClaimDownloadTest() throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for verify Claim Download Test:" + currenttime());

		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult"); 
		enobjhomePage.selectTab(dataMap);
		
		SoftAssert softAssert=new SoftAssert();

		boolean flag = false;
		dataMap.put("Attachment", "Yes");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		dataMap.put("CustomerID", customerID);
		dataMap.put("DownloadRecords", "");
		enClaimsPage.selectClaimActions(dataMap);
		
		lavanteUtils.waitForTime(3000);

		String exp="Supplier Claim documents";
		String expct="Completed";
		String xx=dataMap.get("FileName");
		
		Reporter.log(xx+",Status Expected:Completed,Actuals:"+ dataMap.get("FileStatus")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileStatus"), expct,"File status not matched");
		
		Reporter.log(xx+",Type Expected:"+ exp+",Actuals"+dataMap.get("FileType")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileType"), exp,"File Type not matched");
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for verify Claim Download Test:" + currenttime());
	}

	/**
	 * @author Piramanayagam.S
	 * 
	 *         downloading Records from Invoice page veifying the pop up
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void verifyInvoiceDownloadTest() throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for verify Invoice Download Test:" + currenttime());
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "InvoiceSearchResult"); 
		enobjhomePage.selectTab(dataMap);
		
		SoftAssert softAssert=new SoftAssert();

		boolean flag = false;
		dataMap.put("Attachment", "Yes");
		dataMap.put("Search", "");
		eninvoiceBasicSearch.Search(dataMap);

		dataMap.put("CustomerID", customerID);
		dataMap.put("DownloadRecords", "");
		eninvoicePage.selectSupplierFormAction(dataMap);
		
		lavanteUtils.waitForTime(3000);

		String exp="Supplier invoice documents";
		String expct="Completed";
		String xx=dataMap.get("FileName");
		
		Reporter.log(xx+",Status Expected:Completed,Actuals:"+ dataMap.get("FileStatus")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileStatus"), expct,"File status not matched");
		
		Reporter.log(xx+",Type Expected:"+ exp+",Actuals"+dataMap.get("FileType")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileType"), exp,"File Type not matched");
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for verify Invoice Download Test:" + currenttime());
	}

	/**
	 * @author Piramanayagam.S
	 * 
	 *         downloading Records from Payment page veifying the pop up
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void verifyPaymentDownloadTest() throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for verify Payment Download Test:" + currenttime());
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "PaymentResult"); 
		enobjhomePage.selectTab(dataMap);
		
		SoftAssert softAssert=new SoftAssert();

		boolean flag = false;
		dataMap.put("Attachment", "Yes");
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		dataMap.put("CustomerID", customerID);
		dataMap.put("DownloadRecords", "");
		objPaymentsPage.selectPaymentAction(dataMap);
		
		lavanteUtils.waitForTime(3000);

		String exp="Supplier payment documents";
		String expct="Completed";
		String xx=dataMap.get("FileName");
		
		Reporter.log(xx+",Status Expected:Completed,Actuals:"+ dataMap.get("FileStatus")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileStatus"), expct,"File status not matched");
		
		Reporter.log(xx+",Type Expected:"+ exp+",Actuals"+dataMap.get("FileType")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileType"), exp,"File Type not matched");
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for verify Payment Download Test:" + currenttime());
	}

	/**
	 * @author Piramanayagam.S
	 * 
	 *         downloading Records from Promo page veifying the pop up
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@Test
	public void verifyPromoDownloadTest() throws FileNotFoundException, IOException, SQLException, InterruptedException {
		Reporter.log("Test Started for verify Promo Download Test:" + currenttime());
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "Promo"); 
		enobjhomePage.selectTab(dataMap);
		
		SoftAssert softAssert=new SoftAssert();

		boolean flag = false;
		dataMap.put("Action","DownloadRecords");
		dataMap.put("Attachment", "Yes");
		dataMap.put("Search", "");
		objPromoPage.Search(dataMap);

		dataMap.put("CustomerID", customerID);
		objPromoPage.action(dataMap);
		
		lavanteUtils.waitForTime(3000);

		String exp="Supplier promo documents";
		String expct="Completed";
		String xx=dataMap.get("FileName");
		
		Reporter.log(xx+",Status Expected:Completed,Actuals:"+ dataMap.get("FileStatus")+"File status  matched",true);
		softAssert.assertEquals(dataMap.get("FileStatus"), expct,"File status not matched");
		
		Reporter.log(xx+",Type Expected:"+ exp+",Actuals"+dataMap.get("FileType")+"File Type  matched",true);
		softAssert.assertEquals(dataMap.get("FileType"), exp,"File Type not matched");
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for verify Promo Download Test:" + currenttime());
	}
	
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		enobjhomePage.popupclose();		
		lavanteUtils.refreshPage();
	}
	
	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();		
		quitBrowser();
	}


}

