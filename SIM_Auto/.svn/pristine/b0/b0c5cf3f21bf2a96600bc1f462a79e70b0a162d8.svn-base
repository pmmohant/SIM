package com.lavante.sim.customer.TestScripts.Transactions.Invoices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

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

public class InvoiceSubmitQuestionsTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();
	String username="";
	String supName="";
	
	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Subhas.BV
	 * 
	 */
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
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException {
		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0); 
		username = LdataMap.get("username");
				
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab", "Invoice");
		enobjhomePage.selectTab(dataMap);
	}
	
	/**
	 * @author: Vidya.C
	 * 	Supplier submits a question and buyer responds to the submitted questions
	 * @throws Exception 
	 * 
	 * @FileNotFoundException
	 * @IOException
	 * @SQLException
	 * 
	 */
	@Test 
	public void VerifySupplierSubmitQuestionTest() throws Exception {
		Reporter.log("Test Started for VerifySupplierSubmitQuestionTest: "+currenttime());
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap< String, String> dataMap = new LinkedHashMap<>();
		
		boolean flag = false;
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		List<WebElement> invList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
		String invoiceNo = "";
		
		if(invList.size()>0) {
			invoiceNo = invList.get(0).getText();
			Reporter.log("Supplier Login, List of Invoice search results: "	+ invoiceNo);
			flag = true;
			
		} else {
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			flag = true;
		}

		if (flag == false) {
			Reporter.log("Search results are not matching");
		}
		
		String quest = "AutoSP_Question"+currenttime();
		dataMap.put("Question", quest);
		dataMap.put("SubmitQuestion", "");
		eninvoicePage.selectSupplierFormAction(dataMap);
		Reporter.log("Message after submitting the question, Expected: 'Question has been submitted successfully' Actual: "+dataMap.get("QuesBannerMsg"));
		softAssert.assertEquals(dataMap.get("QuesBannerMsg"), "Question has been submitted successfully","Message after submitting the question, Expected: 'Question has been submitted successfully' Actual: "+dataMap.get("QuesBannerMsg"));
		
		enobjhomePage.logout();

		List<?> listofdatafrm = lavanteUtils.login("KrogerPRGXClerk", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "InvoiceQuesToAns");
		enobjhomePage.selectTab(dataMap);
		
		String resp = "AutoSP_Response"+currenttime();
		dataMap.put("InvNum", invoiceNo);
		dataMap.put("Respond", "");
		dataMap.put("Response", resp);
		dataMap.put("ResponseError","");
		enInvoiceQntoAnswer.selectSupplierFormAction(dataMap);
		
		Reporter.log("Mandatory check message for Response, Expected: 'Response' cannot be left blank. Actual: "+dataMap.get("ResponseError"),true);
		Assert.assertEquals(dataMap.get("ResponseError"), "'Response' cannot be left blank.","Mandatory check message for Response, Expected: 'Response' cannot be left blank. Actual: "+dataMap.get("ResponseError"));
	
		Reporter.log("Message after submitting the response, Expected: Response sent successfully Actual: "+dataMap.get("BannerMsg"),true);
		softAssert.assertEquals(dataMap.get("BannerMsg").trim(), "Response sent successfully","Message after submitting the response, Expected: 'Response sent successfully' Actual: "+dataMap.get("BannerMsg"));
		
		enInvoiceQntoAnswer.Search(dataMap);
		
		flag=false;
		invList = enInvoiceQntoAnswer.iterateSearchHeaderFindColList("Invoice Number");
		if(invList.size()>0) {
			flag = false;
		} else {
			softAssert.assertEquals("No Results", enInvoiceQntoAnswer.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Responded Invoice is still in Invoice Questions Page");
			softAssert.assertTrue(flag, "Responded Invoice is still in Invoice Questions Page");
		}
		
		//Transaction->Invoices->check in view invoice page
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(dataMap);	
		
		supName = dataMap.get("SuppName");
		dataMap.put("SuppName", supName);
		dataMap.put("Search","");
		eninvoiceBasicSearch.Search(dataMap);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		lavanteUtils.click(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		
		flag = false;
		String actualComment = null;
		List<WebElement> commentList = eninvoicePage.PublicCommentsList();
		for (int i = 0; i < commentList.size(); i++) {
			actualComment = commentList.get(i).getText();
			if (actualComment.equals(resp)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the response added by customer, Expected :"+ resp + ", Actual :" + actualComment);
		softAssert.assertTrue(flag,"Mismatch in the response added by customer, Expected :"	+ resp + ", Actual :" + actualComment);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for VerifySupplierSubmitQuestionTest: "+currenttime());
			
	}
		
	/**
	 * @author: Vidya.C
	 * 	Supplier submits a question and buyer responds to the submitted questions on View Page
	 * @throws Exception 
	 * 
	 * @FileNotFoundException
	 * @IOException
	 * @SQLException
	 * 
	 */
	@Test 
	public void VerifySupplierSubmitQuestionInDetailsPageTest() throws Exception {
		Reporter.log("Test Started for Verify Supplier Submit Question In Details Page Test: "+currenttime());
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap< String, String> dataMap = new LinkedHashMap<>();
		
		boolean flag = false;
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		List<WebElement> invList = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
		String invoiceNo = "";
		
		if(invList.size()>0) {
			invoiceNo = invList.get(0).getText();
			Reporter.log("Supplier Login, List of Invoice search results: "	+ invoiceNo);
			flag = true;
			
		} else {
			Assert.assertEquals("No results", eninvoicePage.NoData().getText());
			Assert.assertTrue(flag, eninvoicePage.NoData().getText());
		}

		lavanteUtils.click(invList.get(0));
		flag = false;
		String quest = "AutoSP_Question"+currenttime();
		dataMap.put("Question", quest);
		objViewInvoicePage.SubmitQuestion(dataMap);
		
		lavanteUtils.fluentwait(objViewInvoicePage.invoiceHeaderTxt());
		lavanteUtils.waitForTime(7000);
		List<WebElement> questTagList = objViewInvoicePage.QuestionTagList();
		List<WebElement> questionList = objViewInvoicePage.QuestionCommentsList();
		for(int i=0; i<questionList.size(); i++) {
			if(questionList.get(i).getText().equals(quest) && questTagList.get(i).getText().equals("Question")) {
				Reporter.log("Question submitted from supplier: "+questionList.get(i).getText(), true);
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag,"Submitted QN by supplier not found");
		flag=false;
		
		Reporter.log("Message after submitting the question, Expected: 'Question has been submitted successfully' Actual: "+dataMap.get("QuesBannerMsg"));
		softAssert.assertEquals(dataMap.get("QuesBannerMsg"), "Question has been submitted successfully","Message after submitting the question, Expected: 'Question has been submitted successfully' Actual: "+dataMap.get("QuesBannerMsg").trim());
		
		enobjhomePage.logout();
		LdataMap.clear();
		List<?> listofdatafrm = lavanteUtils.login("KrogerPRGXClerk", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "InvoiceQuesToAns");
		enobjhomePage.selectTab(dataMap);
		
		String resp = "AutoSP_Response"+currenttime();
		dataMap.put("InvNum", invoiceNo);
		dataMap.put("Respond", "");
		dataMap.put("Response", resp);
		enInvoiceQntoAnswer.selectSupplierFormAction(dataMap);
	
		Reporter.log("Mandatory check message for Response, Expected: 'Response' cannot be left blank. Actual: "+dataMap.get("ResponseError"),true);
		Assert.assertEquals(dataMap.get("ResponseError"), "'Response' cannot be left blank.","Mandatory check message for Response, Expected: 'Response' cannot be left blank. Actual: "+dataMap.get("ResponseError"));
	
		Reporter.log("Message after submitting the response, Expected: Response sent successfully Actual: "+dataMap.get("BannerMsg"),true);
		softAssert.assertEquals(dataMap.get("BannerMsg").trim(), "Response sent successfully","Message after submitting the response, Expected: 'Response sent successfully' Actual: "+dataMap.get("BannerMsg"));
		
		enInvoiceQntoAnswer.Search(dataMap);
		
		flag=false;
		invList = enInvoiceQntoAnswer.iterateSearchHeaderFindColList("Invoice Number");
		if(invList.size()>0) {
			flag = false;
		} else {
			softAssert.assertEquals("No Results", enInvoiceQntoAnswer.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Responded Invoice is still in Invoice Questions Page");
			softAssert.assertTrue(flag, "Responded Invoice is still in Invoice Questions Page");
		}
		
		//Transaction->Claim->check in view invoice page
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "customerInvoiceSearchResult");
		enobjhomePage.selectTab(dataMap);	

		supName = dataMap.get("SuppName");
		dataMap.put("SuppName", supName);
		dataMap.put("Search","");
		eninvoiceBasicSearch.Search(dataMap);
		
		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		lavanteUtils.click(eninvoicePage.iterateSearchHeaderFindColList("Invoice Number").get(0));
		
		flag = false;
		String actualComment = null;
		List<WebElement> commentList = eninvoicePage.PublicCommentsList();
		for (int i = 0; i < commentList.size(); i++) {
			actualComment = commentList.get(i).getText();
			if (actualComment.equals(resp)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Mismatch in the response added by customer, Expected :"+ resp + ", Actual :" + actualComment);
		softAssert.assertTrue(flag,"Mismatch in the response added by customer, Expected :"	+ resp + ", Actual :" + actualComment);
		
		softAssert.assertAll();
		Reporter.log("Test Ended for VerifySupplierSubmitQuestionTest: "+currenttime());
	}
	
	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		enobjhomePage.logout();
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		quitBrowser();
	}

}
