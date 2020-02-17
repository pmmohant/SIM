package com.lavante.sim.customer.TestScripts.UserRoles;

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
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * @author Ramya.Raj SIM-19519 Do not allow Claims of Type 'Stop Payment' for check amount less than 1$
 *
 */
public class KrogerCustomerPropertyTest01 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String Uname = "";
	String customerID = "";
	String claimType="SP - Stop Payment";
	String CheckAmount ="2";
	String Currency = "USD";
	String ClaimAmnt="100";

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
		
		List<?> listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		Uname = LdataMap.get("username");
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerPaymentResult");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 *	  
	 * To verify PAYMENT_CHECK_AMOUNT_RESTRICTION  change the check amount to - the configured value and verify error msg and verify after +1 value to check the success
	 *  
	 *  @author Ramya        
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void paymentCheckAmountRestriction() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for Payment check amount restriction :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		String update  = "update CustomerPropertyValue SET IsActive = 'True' where CustomerID="+ customerID + " and CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='PAYMENT_CHECK_AMOUNT_RESTRICTION')";
     
		String getInvoiceNo = "select max(InvoiceNumber) from InvoiceHeader where CustomerID="+customerID+" and InvoiceHeaderID in (select InvoiceHeaderID from Payment where  PaymentID not in (Select PaymentID from Claim where PaymentID=PaymentID))";
		String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo).toString().trim();
		dataMap.put("InvoiceNumber", invoiceNum);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		
		dataMap.put("CreateClaim","");
		objPaymentsPage.selectPaymentAction(dataMap);
		
		String paymentRfe=dataMap.get("PaymentRefNo");
		String invnum=dataMap.get("InvoiceNumber");
		String noofClaims="";
		
		String PaymentID="";
		if(dataMap.containsKey("PaymentID")){
			PaymentID=dataMap.get("PaymentID");
			 noofClaims="select Count(ClaimID) from Claim where PaymentID="+PaymentID;
			 noofClaims=lavanteUtils.fetchDBdata(noofClaims);
			 
			 Integer xx=Integer.parseInt(CheckAmount);
			 xx=xx-1;
			 update  = "update payment set CheckAmount = "+xx+" where PaymentID ="+PaymentID;
	        lavanteUtils.UpdateDB(update);
	        
			lavanteUtils.refreshPage();
		}else{
			Assert.assertTrue(false,"Payment ID not found");
		}
		
		
		dataMap.put("ClaimType", claimType);
		dataMap.put("ClaimAmount",""+102);
		objCreateClaimPage.createClaimFillDetails(dataMap);
		
		dataMap.put("SubmitClaim","");
		objCreateClaimPage.formAction(dataMap);

		String expMessage = claimType+" cannot be submitted for the payment whose check amount is less than USD 1";
	    String actMessage = objCreateClaimPage.bannerMessage().getAttribute("innerText");
	    lavanteUtils.fluentwait(objCreateClaimPage.bannerMessage());
	    Boolean flag = false;
	    if (actMessage.contains(expMessage)) {
	    	flag = true;
	    }
	    
	    Integer xx=Integer.parseInt(CheckAmount);
		xx=xx+1;
		update  = "update payment set CheckAmount = "+xx+" where PaymentID ="+PaymentID;
        lavanteUtils.UpdateDB(update);
		lavanteUtils.refreshPage();
		
		dataMap.put("ClaimType", claimType);
		dataMap.put("ClaimAmount","102");
		dataMap.put("SubmitClaim","");
		objCreateClaimPage.createClaim(dataMap);
	    
	    dataMap.put("Search", "");
	    objPaymentsPage.basicSearch(dataMap);
	    
		String getSupplierERPID = objPaymentsPage.getColumnText("Payment Ref No", 0);
		Reporter.log("Payment Ref No is not equall to the searched , Expected : "				+paymentRfe + ", Actual : " + getSupplierERPID);
		softAssert.assertEquals(getSupplierERPID,paymentRfe,"Payment Ref No is not equall to the searched , Expected : "	+paymentRfe+ ", Actual : " + getSupplierERPID);

		 getSupplierERPID = objPaymentsPage.getColumnText("Invoice Number", 0);
		Reporter.log("Invoice Number is not equall to the searched , Expected : "+invnum + ", Actual : " + getSupplierERPID);
		softAssert.assertEquals(getSupplierERPID,invnum,	"Invoice Number is not equall to the searched , Expected : "	+invnum+ ", Actual : " + getSupplierERPID);

		 getSupplierERPID = objPaymentsPage.getColumnText("# Of Claims", 0);
		Reporter.log("# Of Claims is not equall to the searched , Expected : "+noofClaims + ", Actual : " + getSupplierERPID);
		softAssert.assertNotEquals(getSupplierERPID,noofClaims,	"# Of Claims is not equall to the searched , Expected : "	+noofClaims+ ", Actual : " + getSupplierERPID);

	    softAssert.assertTrue(flag);
	    softAssert.assertAll();
	    Reporter.log("Test ended for PAYMENT_CHECK_AMOUNT_RESTRICTION Test:" + currenttime());

	}

	
	
    
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
