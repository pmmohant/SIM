/*package com.lavante.sim.customer.TestScripts.Transactions.Claims;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

*//**
 * LATM-568 SIM-17084 Allow "Actions" from View Details page(s)  @author Piramanayagam.S
 *
 *//*

public class ClaimsActionTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String uname = "";
	String customerID = "";
	String expSuppName = "";
	String claimID = "";
	String pclaimId = "";
	
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

	*//**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author subhas.bv
	 * 
	 *//*
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;
	}
	
	@BeforeMethod
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException{
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		// LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String,
		// String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		uname = LdataMap.get("username");
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerPaymentResult");
		enobjhomePage.selectTab(dataMap);
	}

	*//**
	 * @author subhas.bv
	 * 
	 *         deleteClaimTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *//*
	@Test
	public void deleteClaimTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for delete claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String getInvoiceNo = "select max(InvoiceNumber) from InvoiceHeader where CustomerID="+customerID+" and InvoiceHeaderID in (select InvoiceHeaderID from Payment where  PaymentID not in (Select PaymentID from Claim where PaymentID=PaymentID))";

		String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo).toString();

		dataMap.put("InvoiceNumber", invoiceNum.trim());
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
		Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")+ ", Actual : " + getInvoiceNum);
		softAssert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

		dataMap.put("CreateClaim", "");
		objPaymentsPage.selectPaymentAction(dataMap);

		dataMap.put("ClaimType", "WV - Wrong Vendor");
		dataMap.put("ClaimAmount", "10");
		dataMap.put("ClaimCurrency", "USD");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		dataMap.put("InvoiceNo", invoiceNum);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
		List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
		if (criteria.size() > 0) {
			for (int i = 0; i < criteria.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());
				softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),	"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());

				Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "		+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),	dataMap.get("ClaimType"),	"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: " 	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());

				flag = true;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		dataMap.put("DeleteClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		lavanteUtils.waitforPageload(objPaymentsPage.GetCountNo());
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String actual = enClaimsPage.VerifyNoResultTxt().getText();
		Reporter.log("Search results, Expected: No results Actual: " + actual);
		softAssert.assertEquals(actual, "No results","Search results are not matching, Expected: No results, Actual: " + actual);
		lavanteUtils.switchtoFrame(null);
		softAssert.assertAll();
		Reporter.log("Test Ended for delete claim:" + currenttime());
	}

	*//**
	 * @author subhas.bv
	 * 
	 *         createEditClaimTest
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *//*
	 @Test
	public void createEditClaimTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for create claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String getInvoiceNo = "select max(InvoiceNumber) from InvoiceHeader where CustomerID="+customerID+" and InvoiceHeaderID in (select InvoiceHeaderID from Payment where  PaymentID not in (Select PaymentID from Claim where PaymentID=PaymentID))";

		String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo).toString();

		dataMap.put("InvoiceNumber", invoiceNum.trim());
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
		Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")+ ", Actual : " + getInvoiceNum);
		softAssert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "	+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

		dataMap.put("CreateClaim","");
		objPaymentsPage.selectPaymentAction(dataMap);

		dataMap.put("ClaimType", "WV - Wrong Vendor");
		dataMap.put("ClaimAmount", "10");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		dataMap.put("InvoiceNo", invoiceNum);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
		List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
		if (criteria.size() > 0) {
			for (int i = 0; i < criteria.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());
				softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),	"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "			+ criteria.get(i).getText());

				Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),		dataMap.get("ClaimType"),			"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "					+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());

				flag = true;
				List<WebElement> claim = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
				claimID = claim.get(i).getText();
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		dataMap.put("EditClaim", "");
		enClaimsPage.selectClaimActions(dataMap);

		dataMap.clear();
		dataMap.put("ClaimType", "LC - List Cost");
		dataMap.put("SaveClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		flag = false;
		dataMap.put("InvoiceNo", invoiceNum);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
		criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
		if (criteria.size() > 0) {
			for (int i = 0; i < criteria.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());
				softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());

				Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),dataMap.get("ClaimType"),"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "		+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				
				List<WebElement> claims = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
				String actclaimID = claims.get(i).getText();
				
				Reporter.log("Claim ID, Expected: " + claimID + " Actual: "	+ actclaimID);
				softAssert.assertEquals(actclaimID,claimID,"Search results are not matching, Expected: " + claimID + " Actual: "+ actclaimID);
				
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		softAssert.assertAll();
		Reporter.log("Test Ended for create claim:" + currenttime());
	}

	*//**
	 * @author subhas.bv
	 * 
	 *         submitClaimTest >>Create Claim->Submit
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *//*
	 @Test
	public void submitClaimTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for submit claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String getInvoiceNo = "select max(InvoiceNumber) from InvoiceHeader where CustomerID="+customerID+" and InvoiceHeaderID in (select InvoiceHeaderID from Payment where  PaymentID not in (Select PaymentID from Claim ))";
		String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo);

		dataMap.put("InvoiceNumber", invoiceNum.trim());
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		
		String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
		Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")+ ", Actual : " + getInvoiceNum);
		softAssert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "	+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

		dataMap.put("CreateClaim", "");
		objPaymentsPage.selectPaymentAction(dataMap);

		dataMap.put("ClaimType", "SP - Stop Payment");
		dataMap.put("ClaimAmount", "100");
		dataMap.put("ClaimCurrency", "USD");
		dataMap.put("SubmitClaim", "");
		objCreateClaimPage.createClaim(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		dataMap.put("InvoiceNo", invoiceNum);
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
		List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
		List<WebElement> claim = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
		outr: if (criteria.size() > 0) {
			for (int i = 0; i < criteria.size(); i++) {
				Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "			+ criteria.get(i).getText());
				softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),	"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "			+ criteria.get(i).getText());

				Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "		+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),	dataMap.get("ClaimType"),	"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());

				flag = true;

				// Should not delete the Claim ID as it is used by other Methods
				// and reassigned as it is used by other method
				pclaimId = claim.get(i).getText();
				claimID = "";
				break outr;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}

		lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
		LdataMap.put("ClaimId", enClaimsPage.ListClaimId().get(0).getText());
		lavanteUtils.clicks(enClaimsPage.ListClaimId().get(0));

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objViewClaimsPage.claimStatuslink());
		
		String actual = lavanteUtils.getText(objViewClaimsPage.claimStatuslink());
		String expected = "Pending";

		Reporter.log("Claim Status, Expected: " + expected + " Actual: " + actual);
		softAssert.assertEquals(actual, expected,"Claim Status not matching, Expected: " + expected + ", Actual: " + actual);

		softAssert.assertAll();
		Reporter.log("Test Ended for Submit claim:" + currenttime());
	}
	 
	 *//**
	  * @author vidya.c
	  * 
	  *         submitClaimTest1 
	  *         Test to submit claims from Transactions >> Claims page>>Action Button Submit
	  * @throws SQLException
	  * @throws IOException
	  * @throws FileNotFoundException
	  * 
	  *//*
	 @Test
	 public void submitClaimTest1() throws FileNotFoundException, IOException, SQLException {
			Reporter.log("Test Started for submit claim in Claims page :" + currenttime());

			SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
			
			String getInvoiceNo = "select max(InvoiceNumber) from InvoiceHeader where CustomerID="+customerID+" and InvoiceHeaderID in (select InvoiceHeaderID from Payment where  PaymentID not in (Select PaymentID from Claim where PaymentID=PaymentID))";

			String invoiceNum = lavanteUtils.fetchDBdata(getInvoiceNo).toString();
			dataMap.put("InvoiceNumber", invoiceNum.trim());
			dataMap.put("Search", "");
			objPaymentsPage.basicSearch(dataMap);
			
			String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
			Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")+ ", Actual : " + getInvoiceNum);
			softAssert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

			dataMap.put("CreateClaim", "");
			objPaymentsPage.selectPaymentAction(dataMap);

			dataMap.put("ClaimType", "WV - Wrong Vendor");
			dataMap.put("ClaimAmount", "10");
			dataMap.put("ClaimCurrency", "USD");
			dataMap.put("SaveClaim", "");
			objCreateClaimPage.createClaim(dataMap);
			
			lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
			dataMap.put("maintab", "Transactions");
			dataMap.put("subtab", "customerClaimResult");
			enobjhomePage.selectTab(dataMap);
			lavanteUtils.waitForTime(3000);
			
			boolean flag = false;
			dataMap.put("InvoiceNo", invoiceNum);
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);

			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			String claimStatus = "Open";
			List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
			if (criteria.size() > 0) {
				for (int i = 0; i < criteria.size(); i++) {
					Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "+ criteria.get(i).getText(),true);
					softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());

					Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
					softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),dataMap.get("ClaimType"),"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "			+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
				
					Reporter.log("Search results, Expected: " + claimStatus + " Actual: "+ enClaimsPage.iterateSearchHeaderFindColList("Claim Status").get(i).getText());
					softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Status").get(i).getText(),claimStatus,"Search results are not matching, Expected: " + claimStatus + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Status").get(i).getText());

					flag = true;
				}
			} else {
				softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
				flag = true;
			}

			if (flag == false) {
				Reporter.log("Search results are not matching");
			}

			dataMap.put("SubmitClaim", "");
			enClaimsPage.selectClaimActions(dataMap);
			
			lavanteUtils.waitforPageload(objPaymentsPage.GetCountNo());
			lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
			claimStatus = "Pending";
			String actClaimStatus = lavanteUtils.getText(enClaimsPage.iterateSearchHeaderFindColList("Claim Status").get(0));
			Reporter.log("Claim Status after submitting, Expected: "+claimStatus+" Actual: " + actClaimStatus);
			softAssert.assertEquals(actClaimStatus, claimStatus,"Search results are not matching, Expected: "+claimStatus+" Actual: " + actClaimStatus);
			
			lavanteUtils.clicks(enClaimsPage.ListClaimId().get(0));

			lavanteUtils.switchtoFrame(null);
			String actual = lavanteUtils.getText(objViewClaimsPage.claimStatuslink());

			Reporter.log("Claim Status, Expected: " + claimStatus + " Actual: " + actual);
			softAssert.assertEquals(actual, claimStatus,"Claim Status not matching, Expected: " + claimStatus + ", Actual: " + actual);
			
			softAssert.assertAll();
			Reporter.log("Test Ended for Submit claim in Claims page:" + currenttime());
			
	 }

	*//**
	 * @author subhas.bv
	 * 
	 *         create Claim for closed claims
	 *         
	 *         Fnctionality : If the Payment has all closed Claim, then the claim can be created otherwise claims cannot be created.
	 *         
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *//*
	@Test
	public void createClaimForClosedClaimsTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for create claim for closed claims :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String invoiceNum = "select max(InvoiceNumber) from InvoiceHeader where CustomerID=" + customerID 	+ " and InvoiceHeaderID in (select InvoiceHeaderID from Payment where PaymentID  in (Select PaymentID from Claim where ClaimStatusID=4 ))";
		invoiceNum = lavanteUtils.fetchDBdata(invoiceNum).toString();

		dataMap.put("InvoiceNumber", invoiceNum.trim());
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		
		String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
		Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")+ ", Actual : " + getInvoiceNum);
		softAssert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "	+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

		lavanteUtils.clicks(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref").get(0));
		lavanteUtils.switchtoFrame(null);
		boolean create=false;
		for(int i=0;i<objPaymentsPage.ViewclaimstatusList().size();i++){
			String x=objPaymentsPage.ViewclaimstatusList().get(i).getText();
			if(!x.equalsIgnoreCase("Closed")){
				create=true;
			}
		}

		if(create==true){
			Assert.assertTrue(true,"Payment has both Closed and Other Status claims, Hence Could not create a new open Claim");
		}
		
		if(create==false){
			lavanteUtils.click(objPaymentsPage.CreateClaimLink());

			dataMap.put("ClaimType", "WV - Wrong Vendor");
			dataMap.put("ClaimAmount", "10");
			dataMap.put("SaveClaim", "");
			objCreateClaimPage.createClaim(dataMap);
	
			lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
			dataMap.put("maintab", "Transactions");
			dataMap.put("subtab", "customerClaimResult");
			enobjhomePage.selectTab(dataMap);
			lavanteUtils.waitForTime(3000);
	
			boolean flag = false;
			dataMap.put("InvoiceNo", invoiceNum);
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
	
			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
			if (criteria.size() > 0) {
				for (int i = 0; i < criteria.size(); i++) {
					Reporter.log("Search results, Expected: " + dataMap.get("InvoiceNo") + " Actual: "	+ criteria.get(i).getText());
					softAssert.assertEquals(criteria.get(i).getText(), dataMap.get("InvoiceNo"),"Search results are not matching, Expected: " + dataMap.get("InvoiceNo") + " Actual: "			+ criteria.get(i).getText());
	
					Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "		+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
					softAssert.assertEquals(enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText(),	dataMap.get("ClaimType"),	"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "		+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
	
					flag = true;
					List<WebElement> claim = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
					claimID = claim.get(i).getText();
				 }
			} else {
				softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
				flag = true;
			}
	
			if (flag == false) {
				Reporter.log("Search results are not matching");
			}
		}

	
		softAssert.assertAll();
		Reporter.log("Test Ended for create claim for closed claims :" + currenttime());
	}

	*//**
	 * @author vidya.c
	 * 
	 *        EditClaimRepayTest
	 *        
	 *        Doing Tasks >> Edit and  Repay, fill all the mandatory fields, 
	 *        GL code details and Submitting the claim
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException 
	 * @throws SQLException 
	 *//*
	@Test
	public void EditClaimRepayTest() throws FileNotFoundException, IOException, InterruptedException, SQLException {
		Reporter.log("Test Started for Repay claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		submitClaimTest();
		
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		boolean flag = false;
				
		if(pclaimId.length()>0){

			dataMap.put("ClaimId", pclaimId);
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
			
			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
			
			if (criteria.size() > 0) {
				lavanteUtils.click(criteria.get(0));
				dataMap.put("ActionTaken","Approval Pending");
				dataMap.put("Actor", "");
				objViewClaimsPage.viewDetails(dataMap);
				String email = objViewClaimsPage.email().getText();
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.click(objViewClaimsPage.closeDailog());
				Assert.assertTrue(email.length()>0,"Login Email has no value");
				Assert.assertTrue(email.contains("@"),"Login Email doesnot contains @");
				
				if(!uname.equalsIgnoreCase(email)){
					enobjhomePage.logout();
					dataMap.put("username", email);
					dataMap.put("password", InitProperties("password"));
					enobjloginpage.logintoAPP(dataMap);
				}
				
				dataMap.put("maintab", "Tasks");
				dataMap.put("subtab", "claimTasks");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("Action","EditClaim");
				objTasksClaimPage.actionOnTasksClaims(dataMap);
				lavanteUtils.waitForTime(3000);
				
				dataMap.put("Department", "ANY");
				dataMap.put("ClaimPriority", "Yes");
				dataMap.put("Repay", "");
				dataMap.put("SettlementAmt", "");
				dataMap.put("ClaimResolReason", "any");
				dataMap.put("GLCode", "any");
				dataMap.put("GLCodeAmount","");
				dataMap.put("SubmitClaim", "");
				dataMap.put("GLCODE", "");
				objCreateClaimPage.EditClaim(dataMap);
				
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("ClaimId", pclaimId);
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
				
				lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
				
				String expStatus = "Closed";
				String expResol = "Paid";
				List<WebElement> actClaimResol = enClaimsPage.iterateSearchHeaderFindColList("Claim Resolution");
				List<WebElement> actClaimStatus = enClaimsPage.iterateSearchHeaderFindColList("Claim Status");
				Reporter.log("Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus.get(0).getText());
				Reporter.log("Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol.get(0).getText());
				softAssert.assertEquals(actClaimStatus.get(0).getText(), expStatus,"Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus.get(0).getText());
				softAssert.assertEquals(actClaimResol.get(0).getText(), expResol,"Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol.get(0).getText());
			
				criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
				lavanteUtils.click(criteria.get(0));
				lavanteUtils.switchtoFrame(null);
				String actStatus = objViewClaimsPage.claimStatuslink().getText();
				Reporter.log("Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);
				softAssert.assertEquals(actStatus, expStatus, "Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);
				
				flag=true;
			}
		
		}else {
			softAssert.assertTrue(flag,"Claim ID which is created by other method not passed");
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Please Recheck");
		softAssert.assertAll();		
		Reporter.log("Test Ended for Repay claim:" + currenttime());
	}
	
	*//**
	 * @author vidya.c
	 * 
	 *        EditClaimPartialRepayTest
	 *        
	 *        Doing Transactions >> Edit, Partial Repay fill all the fields except GL code
	 *        handle the GL code warning then fill GL code and Submit the claim
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException 
	 * @throws SQLException 
	 *//*
	@Test
	public void EditClaimPartialRepayTest() throws FileNotFoundException, IOException, InterruptedException, SQLException {
		Reporter.log("Test Started for Partial Repay claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		submitClaimTest();
		
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		boolean flag = false;
				
		if(pclaimId.length()>0){

			dataMap.put("ClaimId", pclaimId);
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
			
			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
			
			if (criteria.size() > 0) {
				lavanteUtils.click(criteria.get(0));
				dataMap.put("ActionTaken","Approval Pending");
				dataMap.put("Actor", "");
				objViewClaimsPage.viewDetails(dataMap);
				
				String email = objViewClaimsPage.email().getText();
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.click(objViewClaimsPage.closeDailog());
				
				if(!uname.equalsIgnoreCase(email)){
					enobjhomePage.logout();
					dataMap.put("username", email);
					dataMap.put("password", InitProperties("password"));
					enobjloginpage.logintoAPP(dataMap);
					enobjhomePage.close();
				}
				
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("ClaimId", pclaimId);
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
				
				dataMap.put("EditClaim", "");
				enClaimsPage.selectClaimActions(dataMap);
				
				dataMap.put("Department", "ANY");
				dataMap.put("ClaimPriority", "Yes");
				dataMap.put("PartialRepay", "");
				dataMap.put("SettlementAmt", "ANY");
				dataMap.put("ClaimResolReason", "any");
				dataMap.put("GLCodeWarning","Yes");
				dataMap.put("SubmitClaim", "");
				dataMap.put("GLCODE", "any");
				objCreateClaimPage.EditClaim(dataMap);
				
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("ClaimId", pclaimId);
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
				
				lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());

				String expStatus = "Closed";
				String expResol = "Partially Paid";
			
				List<WebElement> actClaimResol = enClaimsPage.iterateSearchHeaderFindColList("Claim Resolution");
				List<WebElement> actClaimStatus = enClaimsPage.iterateSearchHeaderFindColList("Claim Status");
				Reporter.log("Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus.get(0).getText());
				Reporter.log("Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol.get(0).getText());
				softAssert.assertEquals(actClaimStatus.get(0).getText(), expStatus,"Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus.get(0).getText());
				softAssert.assertEquals(actClaimResol.get(0).getText(), expResol,"Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol.get(0).getText());

				criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
				lavanteUtils.click(criteria.get(0));
				lavanteUtils.switchtoFrame(null);
				String actStatus = objViewClaimsPage.claimStatuslink().getText();
				Reporter.log("Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);
				softAssert.assertEquals(actStatus, expStatus, "Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);
				
				
				flag=true;
			}

		}else {
			softAssert.assertTrue(flag,"Claim ID which is created by other method not passed");
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Please Recheck");
		softAssert.assertAll();		
		Reporter.log("Test Ended for Partial Repay claim:" + currenttime());
	}
	
	*//**
	 * @author vidya.c
	 * 
	 *        EditClaimDenyTest
	 *        
	 *        Doing Transactions >> Edit and  Deny fill all the fields and Submitting the claim
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException 
	 * @throws SQLException 
	 *//*
	@Test
	public void EditClaimDenyTest() throws FileNotFoundException, IOException, InterruptedException, SQLException {
		Reporter.log("Test Started for Partial Repay claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		submitClaimTest();
		
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		boolean flag = false;
				
		if(pclaimId.length()>0){

			lavanteUtils.click(enClaimsBasicSearch.Clearbtn());
			dataMap.put("ClaimId", pclaimId);
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
			
			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");
			
			if (criteria.size() > 0) {
				lavanteUtils.click(criteria.get(0));
				dataMap.put("ActionTaken","Approval Pending");
				dataMap.put("Actor", "");
				objViewClaimsPage.viewDetails(dataMap);
				
				String email = objViewClaimsPage.email().getText();
				Assert.assertTrue(email.contains("@"),"Email is not taken:"+email);
				lavanteUtils.refreshPage();
				
				if(!uname.equalsIgnoreCase(email)){
					enobjhomePage.logout();
					dataMap.put("username", email);
					dataMap.put("password", InitProperties("password"));
					enobjloginpage.logintoAPP(dataMap);
					enobjhomePage.close();
				}
				
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "customerClaimResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("ClaimId", pclaimId);
				dataMap.put("Search", "");
				enClaimsBasicSearch.Search(dataMap);
			
				dataMap.put("EditClaim", "");
				enClaimsPage.selectClaimActions(dataMap);
				
				dataMap.put("Department", "ANY");
				dataMap.put("ClaimPriority", "No");
				dataMap.put("Deny", "");
				dataMap.put("ClaimResolReason", "any");
				dataMap.put("DenyClaim", "");
				objCreateClaimPage.EditClaim(dataMap);
								
				lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			
				String expStatus = "Closed";
				String expResol = "Denied";
				
				List<WebElement> actClaimResol = enClaimsPage.iterateSearchHeaderFindColList("Claim Resolution");
				List<WebElement> actClaimStatus = enClaimsPage.iterateSearchHeaderFindColList("Claim Status");
				Reporter.log("Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus.get(0).getText(),true);
				Reporter.log("Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol.get(0).getText(),true);
				softAssert.assertEquals(actClaimStatus.get(0).getText(), expStatus,"Claim status in Claim Results page, Expected: "+expStatus+" Actual: "+actClaimStatus.get(0).getText());
				softAssert.assertEquals(actClaimResol.get(0).getText(), expResol,"Claim Resolution in Claim Results page, Expected: "+expResol+" Actual: "+actClaimResol.get(0).getText());
			
				criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim ID");

				lavanteUtils.click(criteria.get(0));
				lavanteUtils.switchtoFrame(null);
				String actStatus = objViewClaimsPage.claimStatuslink().getText();
				
				Reporter.log("Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus,true);
				softAssert.assertEquals(actStatus, expStatus, "Claim status in View Details page, Expected: "+expStatus+" Actual: "+actStatus);
				
				lavanteUtils.click(objViewClaimsPage.backLink());
				
				
				flag=true;
			
			}
			else {
				softAssert.assertTrue(flag,"Claim ID which is created by other method not passed");
				flag=true;
			}
			
			softAssert.assertTrue(flag,"Please Recheck");
			softAssert.assertAll();		
			Reporter.log("Test Ended for Deny claim:" + currenttime());
		}
	}

	*//**
	 * Concurrent Open Claim Test Done- In Payment Page, Create A duplicate Claim with Claim type, Error message verification,
	 * Create a Claim with unique Claim type,should create new
	 * 
	 * @author Piramanayagam.S     
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *//*
	 @Test
	public void concCurrentopenClaimTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for create claim :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		dataMap.put("ClaimStatus", "Open");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);
		
		String paymentRefNum="";
		boolean flag2=false;
		
		lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
		List<WebElement> actPayNum = enClaimsPage.iterateSearchHeaderFindColList("Payment Ref No");
		if (actPayNum.size() > 0) {
			for (int i = 0; i < actPayNum.size(); i++) {
				paymentRefNum=actPayNum.get(i).getText();
				
				String expClaim=enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(i).getText();
				
				lavanteUtils.click(actPayNum.get(i));
				
				lavanteUtils.fluentwait(objViewClaimsPage.backLink());
				
				String viewpaymentRefNum=objViewClaimsPage.fetchData("Payment Ref No");
				Reporter.log("paymentRefNum matched:"+paymentRefNum+",Act:"+viewpaymentRefNum,true);
				softAssert.assertEquals(viewpaymentRefNum, paymentRefNum,"paymentRefNum not matched");
				
				String claimType="";
				String errType="";
				int size=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").size();
				for (int j = 0; j < size; j++) {
					
						String actClaimID=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").get(j).getText();
						
						if(j==0){
							errType=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(j).getText();
							//errType=claimType;
						}else {
							claimType=claimType+"#"+objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(j).getText();
						}
						
						if(expClaim.equalsIgnoreCase(actClaimID)){
							softAssert.assertEquals(expClaim, actClaimID,"ClaimID not matched");
							Reporter.log("Claim ID Verifiation:Exp:"+expClaim+",Actual:"+actClaimID,true);
							
							actClaimID=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Status").get(j).getText();
							Reporter.log("Claim Status Verifiation:Exp:Open,Actual:"+claimType,true);
							softAssert.assertEquals(actClaimID, "Open","Claim sTatus not matched");
							
							flag2 = true;
						}
				}
				
				Assert.assertTrue(flag2,"Claim Not Available in View");
				
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.click(objViewClaimsPage.createClaimbtn());
				
				
				dataMap.put("ClaimType", errType);
				dataMap.put("ClaimAmount", "10");
				dataMap.put("SaveClaim", "");
				dataMap.put("Error", "");
				objCreateClaimPage.createClaim(dataMap);
				
				String x=dataMap.get("BannerMsg");
				Reporter.log("Error Expected:Claim Already Exist for this payment.Actual:"+x,true);
				softAssert.assertTrue(x.contains("claim already exists for this payment"),"Err msg not matched");
				
				dataMap.remove("Error");
				String OtherClaimType=objCreateClaimPage.getOtherClaimType(claimType);
				dataMap.put("ClaimType", OtherClaimType);
				objCreateClaimPage.createClaim(dataMap);
								
				lavanteUtils.fluentwait(objViewClaimsPage.backLink());
								
				int actsize=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").size();
				Reporter.log("Size,Actual:"+actsize+",Exp:"+size,true);
				softAssert.assertEquals(actsize,size,"Size not matched");
				
				for (int j = 0; j < actsize; j++) {
					String actClaimType=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(j).getText();
					if(actClaimType.equalsIgnoreCase(OtherClaimType)){
						
						Reporter.log("Claim Type Verifiation:Exp:"+expClaim+",Actual:"+OtherClaimType,true);
						softAssert.assertEquals(actClaimType, OtherClaimType,"Claim Type not matched");
						
						
						flag2 = true;
					}
				}
								
				break;
			}
		} else {
			softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
			Assert.assertTrue(false,"No Data in Open State");
			flag = true;
		}
		
		softAssert.assertTrue(flag2, "Newly Created Claim Not Available,Please REtest");
		softAssert.assertAll();
		Reporter.log("Test Ended for create claim:" + currenttime());
	}
	 
	*//**
	 * Concurrent Closed Claim Test Done- 
		 * In Payment Page, Create A duplicate Claim with Claim type which has been Closed 
		 * 
		 * @author Piramanayagam.S     
		 * @throws SQLException
		 * @throws IOException
		 * @throws FileNotFoundException
		 *//*
	 @Test
	public void concCurrentClosedClaimTest() throws FileNotFoundException, IOException, SQLException {
			Reporter.log("Test Started for create claim :" + currenttime());

			SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();


			lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
			dataMap.put("maintab", "Transactions");
			dataMap.put("subtab", "customerClaimResult");
			enobjhomePage.selectTab(dataMap);
			lavanteUtils.waitForTime(3000);

			boolean flag = false;
			dataMap.put("ClaimStatus", "Closed");
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
			String paymentRefNum="";
			boolean flag2=false;
			boolean flag3=false;
			
			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			List<WebElement> actPayNum = enClaimsPage.iterateSearchHeaderFindColList("Payment Ref No");
			if (actPayNum.size() > 0) {
				for (int i = 0; i < actPayNum.size(); i++) {
					paymentRefNum=actPayNum.get(i).getText();
					
					String expClaim=enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(i).getText();
					
					lavanteUtils.click(actPayNum.get(i));
					
					lavanteUtils.fluentwait(objViewClaimsPage.backLink());
					
					String viewpaymentRefNum=objViewClaimsPage.fetchData("Payment Ref No");
					Reporter.log("paymentRefNum matched:"+paymentRefNum+",Act:"+viewpaymentRefNum,true);
					softAssert.assertEquals(viewpaymentRefNum, paymentRefNum,"paymentRefNum not matched");
					String claimType="";

					int size=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").size();
					for (int j = 0; j < size; j++) {
							String ClaimID=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").get(j).getText();

							if(expClaim.equalsIgnoreCase(ClaimID)){
								Reporter.log("Claim ID Verification,Exp:"+expClaim+",Actual:"+ClaimID,true);
								softAssert.assertEquals(expClaim, ClaimID,"ClaimID not matched");
								
								claimType=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Status").get(j).getText();
								Reporter.log("Status Verification,Exp:Closed,Actual:"+claimType,true);
								softAssert.assertEquals("Closed", claimType,"Claim Status not matched");

								claimType=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(j).getText();
							}
					}
					
					
					for (int j = 0; j < size; j++) {
						String actClaimtype=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(j).getText();
						
							if(claimType.equalsIgnoreCase(actClaimtype)){
								Reporter.log("Claim Type Verification,Exp:"+claimType+",Actual:"+actClaimtype,true);
								softAssert.assertEquals(claimType, actClaimtype,"claimType not matched");
								
								String claimStatus=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Status").get(j).getText();
								if(!claimStatus.equalsIgnoreCase("Closed")){
									softAssert.assertNotEquals("Closed", claimStatus,"Claim Status matched");
									Reporter.log("This Claim Type,"+actClaimtype+",Payment has some other than closed State");
									flag3=true;
								}
							}
					}
					
					Assert.assertTrue(flag2,"Claim Not Available in View Page");
					Assert.assertFalse(flag3,"Another Claim Available in Same Status");
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.click(objViewClaimsPage.createClaimbtn());
					
					
					dataMap.put("ClaimType", claimType);
					dataMap.put("ClaimAmount", "10");
					dataMap.put("SaveClaim", "");
					objCreateClaimPage.createClaim(dataMap);
									
					lavanteUtils.fluentwait(objViewClaimsPage.backLink());
									
					int actsize=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").size();
					Reporter.log("Size,Actual:"+actsize+",Exp:"+size,true);
					softAssert.assertEquals(actsize,size,"Size not matched");
					
					for (int j = 0; j < actsize; j++) {
						
						String actClaimType=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(j).getText();
						if(actClaimType.equalsIgnoreCase(claimType)){

							String ClaimID=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID").get(j).getText();
							if(ClaimID.equalsIgnoreCase(expClaim)){
								flag2 = true;
								Reporter.log("Old Claim Found");
							}else{
								softAssert.assertEquals(expClaim, actClaimType,"Claim Type not matched");
								flag3=true;
							}
							
							if(flag3&&flag2){
								break;
							}
						}
					}
									
					break;
				}
			} else {
				softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
				Assert.assertTrue(false,"No Data in Open State");
				flag = true;
			}
			
			softAssert.assertTrue(flag, "No Data Available");
			softAssert.assertTrue(flag2, "Old Claim Not Available,Please REtest");
			softAssert.assertTrue(flag3, "Newly Created Claim Not Available,Please REtest");
			
			softAssert.assertAll();
			Reporter.log("Test Ended for create claim:" + currenttime());
		}

	*//**
		 * @author Piramanayagam.S
		 * 			View Payment,Create Claim ,edit from view claim
		 *         
		 * @throws SQLException
		 * @throws IOException
	     * @throws FileNotFoundException
		*//*
	@Test
	public void ViewClaimActionTest() throws FileNotFoundException, IOException, SQLException {
				Reporter.log("Test Started for create claim :" + currenttime());

				SoftAssert softAssert = new SoftAssert();
				LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

				dataMap.put("CustomerID",customerID);
				dataMap.put("ClaimType", "WV - Wrong Vendor");
				String invoiceNum = objPaymentsPage.fetchInv(dataMap);
				dataMap.remove("ClaimType");
				
				dataMap.put("InvoiceNumber", invoiceNum);
				dataMap.put("Search", "");
				objPaymentsPage.basicSearch(dataMap);
				
				String getInvoiceNum = objPaymentsPage.getColumnText("Invoice Number", 0);
				Reporter.log("Invoice is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")+ ", Actual : " + getInvoiceNum);
				Assert.assertEquals(getInvoiceNum, dataMap.get("InvoiceNumber"),"Invoice number is not equall to the searched Invoice number, Expected : "	+ dataMap.get("InvoiceNumber") + ", Actual : " + getInvoiceNum);

				lavanteUtils.click(objPaymentsPage.iterateSearchHeaderFindColList("Payment Ref No").get(0));
				lavanteUtils.switchtoFrame(null);
				
				lavanteUtils.click(objViewPaymentsPage.createClaim);
				
				dataMap.put("ClaimType", "WV - Wrong Vendor");
				dataMap.put("ClaimAmount", "10");
				dataMap.put("SaveClaim", "");
				objCreateClaimPage.createClaim(dataMap);
				
				boolean flag=false;
				lavanteUtils.fluentwait(objViewPaymentsPage.createClaim);
				List<WebElement> criteria = objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID");
				if (criteria.size() > 0) {
					for (int i = 0; i < criteria.size(); i++) {
						String actClaimType=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Type").get(i).getText();
						String actClaimStatus=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim Status").get(i).getText();
						
						if(actClaimType.equalsIgnoreCase(dataMap.get("ClaimType")) && actClaimStatus.equalsIgnoreCase("Open")){
							
							Reporter.log("Search results, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ actClaimType);
							softAssert.assertEquals(actClaimType,dataMap.get("ClaimType"),	"Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "					+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
		
							Reporter.log("Status, results, Expected: Open, Actual: "+ actClaimStatus);
							softAssert.assertEquals(actClaimStatus,"Open",	"Status, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
							
							flag = true;
						
							List<WebElement> claim = objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID");
							claimID = claim.get(i).getText();
							
							lavanteUtils.click(claim.get(i));
							
							lavanteUtils.switchtoFrame(null);
							lavanteUtils.fluentwait(objViewClaimsPage.ViewEdit);
							String xc=objViewClaimsPage.claimHeaderLabel().getText();
							
							Reporter.log("ID, results, Expected: "+claimID+", Actual: "	+ actClaimStatus);
							softAssert.assertTrue(xc.contains(claimID),	"ID, Expected: " + dataMap.get("ClaimType") + " Actual: "	+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
							
							lavanteUtils.click(objViewClaimsPage.ViewEdit);
							
							break;
						 }
						
					}
				} else {
					softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
					flag = true;
				}

				if (flag == false) {
					Reporter.log("Search results are not matching");
				}
				
				dataMap.clear();
				String expClaim="LC - List Cost";
				dataMap.put("ClaimType", "LC - List Cost");
				dataMap.put("SaveClaim", "");
				objCreateClaimPage.createClaim(dataMap);

				lavanteUtils.switchtoFrame(null);
				String actClaimID=objViewClaimsPage.claimHeaderLabel().getText();
				
				Reporter.log("Claim ID results, Expected: " + claimID + " Actual: "	+ actClaimID,true);
				softAssert.assertEquals(actClaimID,claimID,	"Claim ID results are not matching, Expected: " + claimID + " Actual: "			+ actClaimID);
			
				actClaimID=objViewClaimsPage.claimTypeTxt().getText();
				Reporter.log("Claim Type results, Expected: " + expClaim + " Actual: "	+ actClaimID,true);
				softAssert.assertEquals(actClaimID,expClaim,	"Claim Type results are not matching, Expected: " + claimID + " Actual: "			+ actClaimID);
				
				if (flag == false) {
					Reporter.log("Search results are not matching");
				}

				softAssert.assertAll();
				Reporter.log("Test Ended for create claim:" + currenttime());
			}

	*//**
	 * @author Piramanayagam.S
	 * 			Associate No of Claim count : Invoice Page as well as Payment Page
	 *         
	 * @throws SQLException
	 * @throws IOException
     * @throws FileNotFoundException
	*//*
	@Test
	public void AssociatedNofOfClaims() throws FileNotFoundException, IOException, SQLException {
			Reporter.log("Test Started for create claim :" + currenttime());

			SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

			dataMap.put("maintab", "Transactions");
			dataMap.put("subtab", "customerClaimResult");
			enobjhomePage.selectTab(dataMap);
			lavanteUtils.waitForTime(3000);

			boolean flag = false;
			String ClaimStatus="Open";
			dataMap.put("ClaimStatus", "Open");
			dataMap.put("Search", "");
			enClaimsBasicSearch.Search(dataMap);
			
			String expClaimID="";

			lavanteUtils.switchtoFrame(enClaimsPage.IFrameSearchResults());
			List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Invoice Number");
			if (criteria.size() > 0) {
				for (int i = 0; i < criteria.size(); i++) {
					
					String actClaimstatus=enClaimsPage.iterateSearchHeaderFindColList("Claim Status").get(i).getText();
					Reporter.log("Claim Status results, Expected: " + ClaimStatus + " Actual: "	+ actClaimstatus);
					softAssert.assertEquals(actClaimstatus,ClaimStatus,	"Claim Status Search results are not matching, Expected: " + dataMap.get("ClaimType") + " Actual: "					+ enClaimsPage.iterateSearchHeaderFindColList("Claim Type").get(i).getText());
					
					expClaimID=enClaimsPage.iterateSearchHeaderFindColList("Claim ID").get(i).getText();
										
					List<WebElement> payment = enClaimsPage.iterateSearchHeaderFindColList("Payment Ref No");
					lavanteUtils.click(payment.get(i));
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(objViewPaymentsPage.invoiceNumLink());
										
					flag = true;
					break;
					
				}
			} else {
				softAssert.assertEquals("No results", enClaimsPage.NoData().getText());
				flag = false;
			}
				
			Assert.assertTrue(flag,"Please retest , no Search");
			
		
			List<WebElement> e=objViewPaymentsPage.iterateAssociatedSearchHeaderFindColList("Claim ID");
			int paymentNofclaim=e.size();
			
			for(int i=0;i<paymentNofclaim;i++){
				String act=e.get(i).getText();
				
				if(act.equals(expClaimID)){
					Reporter.log("Claim Searched on claim page found on Payment Page"+expClaimID);
					flag=true;
				}
				
			}
			
			softAssert.assertTrue(flag,"Claim ID not found on Payment Page");
			flag=false;
			
			lavanteUtils.click(objViewPaymentsPage.invoiceNumLink());
			lavanteUtils.switchtoFrame(null);

			lavanteUtils.fluentwait(objViewInvoicePage.invoiceHeaderTxt());
			e=objViewInvoicePage.iterateAssociatedSearchHeaderFindColList("Claim ID");
			int actpaymentNofclaim=e.size();
			
			for(int i=0;i<actpaymentNofclaim;i++){
				String act=e.get(i).getText();
				
				if(act.equals(expClaimID)){
					Reporter.log("Claim Searched on claim page found on Invoice Page"+expClaimID);
					flag=true;
				}
				
			}
			
			softAssert.assertTrue(flag,"Claim ID not found on Invoice Page");
			
			Reporter.log("Invoice Associated Claim Count:"+actpaymentNofclaim+",Payment Ass Claim:"+paymentNofclaim,true);
			softAssert.assertTrue(actpaymentNofclaim>=paymentNofclaim,"Invoice Claim and Payment Associated Claim not matching");
			

			softAssert.assertAll();
			Reporter.log("Test Ended for create claim:" + currenttime());
		}
	
	*//**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 *//*
	@AfterMethod
	public void SetupAfterMethod() {
		enobjhomePage.logout();
	}

	*//**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 *//*
	@AfterClass
	public void SetupafterClassMethod() {
		quitBrowser();
	}

}
*/