package com.lavante.sim.customer.TestScripts.Transactions.Invoices;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class SupplierInvoiceAddDocumentsTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,@Optional(LavanteUtils.browserVersion) String Version)throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	@BeforeMethod()
	public void BeforeMethod() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab", "Invoice");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * Test to upload documents through Add documents in Invoice view page
	 * 
	 * @author Vidya.C
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test
	public void VerifySupInvoiceAddDocument() throws IOException, AWTException {
		Reporter.log("Test Started for VerifySupInvoiceAddDocument :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		List<WebElement> invoiceNo = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");

		if (invoiceNo.size() > 0) {
			lavanteUtils.click(invoiceNo.get(0));
			lavanteUtils.fluentwait(objViewInvoicePage.invoiceHeaderTxt());

			String pngfile = CopyFile("a.png");
			String pdffile = CopyFile("pdfSample.pdf");
			String jpgfile = CopyFile("DUP.JPG");
			String xlfile = CopyFile("SampleExcel.xlsx");
			String docfile = CopyFile("sampleDoc.docx");

			dataMap.put("Document", pngfile + "#" + pdffile + "#" + jpgfile	+ "#" + xlfile + "#" + docfile);
			dataMap.put("DocumentType", "Price Sheet");
			dataMap.put("Delete", "");
			dataMap.put("Save", "");
			objViewInvoicePage.addDocuments(dataMap);

			String uploadErr = "*You can upload a maximum of 5 files / file size not greater than 100 MB at a time";
			softAssert.assertEquals(dataMap.get("UploadError"), uploadErr,"Upload error message is not matching");

			lavanteUtils.waitForTime(5000);

			String docName = dataMap.get("Document");
			List<String> docArr = new ArrayList<String>();
			if (docName.contains("#")) {
				docArr = Arrays.asList(docName.split("#"));
			} else {
				docArr.add(docName);
			}

			String docType = dataMap.get("DocumentType");
			List<String> typeArr = new ArrayList<String>();
			if (docType.contains("#")) {
				typeArr = Arrays.asList(docType.split("#"));
			} else {
				typeArr.add(docType);
			}

			for (int i = 0; i < docArr.size(); i++) {
				dataMap.put("DocumentName", "");
				dataMap.put("TableDocumentType", "");
				dataMap.put("UploadedBy", "");
				objViewInvoicePage.getDocumentDetails(dataMap, docArr.get(i));
				String actDocName = dataMap.get("DocumentName");
				String actDocType = dataMap.get("TableDocumentType");
				String actUploadedBy = dataMap.get("UploadedBy");

				Reporter.log("Document Name, Expected: " + docArr.get(i)+ " Actual: " + actDocName, true);
				softAssert.assertEquals(actDocName,docArr.get(i),"Document Name does not match, Expected: "	+ docArr.get(i) + " Actual: " + actDocName);
				Reporter.log("Document Type, Expected: " + typeArr.get(i) + " Actual: " + actDocType, true);
				softAssert.assertEquals(actDocType,typeArr.get(i),"Document Type does not match, Expected: "+ typeArr.get(i) + " Actual: " + actDocType);
				Reporter.log("Document Uploaded by, Expected: Supplier Actual: "+ actUploadedBy, true);
				softAssert.assertEquals(actUploadedBy, "Supplier","Document uploaded by doen't match, Expected: Supplier Actual: "+ actUploadedBy);
			}
		}
		softAssert.assertAll();
		Reporter.log("Test Ended for VerifySupInvoiceAddDocument :" + currenttime());
	}

	/**
	 * Test to upload documents through Add documents in Invoice view page and
	 * delete the uploaded document and verify it
	 * 
	 * @author Vidya.C
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test
	public void VerifySupInvoiceDeleteDocument() throws IOException, AWTException {
		Reporter.log("Test Started for VerifySupInvoiceDeleteDocument :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		List<WebElement> invoiceNo = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");

		Boolean flag = false;
		if (invoiceNo.size() > 0) {
			lavanteUtils.click(invoiceNo.get(0));
			lavanteUtils.fluentwait(objViewInvoicePage.invoiceHeaderTxt());

			String pngfile = CopyFile("a.png");

			dataMap.put("Document", pngfile);
			dataMap.put("DocumentType", "Price Sheet");
			dataMap.put("Save", "");
			objViewInvoicePage.addDocuments(dataMap);

			lavanteUtils.waitforPageload(objViewInvoicePage.invoiceHeaderTxt());
			dataMap.put("DeleteDoc", "");
			objViewInvoicePage.getDocumentDetails(dataMap, pngfile);

			WebElement delFile = lavanteUtils.driver.findElement(By.xpath(dataMap.get("DeleteDoc")));
			lavanteUtils.click(delFile);
			lavanteUtils.click(objViewInvoicePage.fileDeleteBtn());

			lavanteUtils.waitForTime(5000);
			
			List<WebElement> docList = objViewInvoicePage.docNameList();
			for (int i = 0; i < docList.size(); i++) {
				if (docList.get(i).getText().equals(pngfile)) {
					Reporter.log("Document is not deleted, DocName: " + pngfile);
					flag = false;
					break;
				} else {
					flag = true;
					Reporter.log("Document is deleted successfully, DocName: "+ pngfile);
				}
			}

			softAssert.assertTrue(flag, "Document is not deleted");

			softAssert.assertAll();
			Reporter.log("Test Ended for VerifySupInvoiceDeleteDocument :"+ currenttime());
		}
	}
	
	/**
	 * Test to upload documents in Supplier login through Add documents in Invoice
	 * view page and verify file cannot be deleted in Buyer login
	 * 
	 * @author Vidya.C
	 * @throws IOException
	 * @throws AWTException
	 */
	@Test
	public void VerifyInvoiceSuppAddDocInBuyerLogin() throws IOException,AWTException, SQLException {
		Reporter.log("Test Started for VerifyInvoiceSuppAddDocInBuyerLogin :"+ currenttime());

		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
		List<WebElement> invoiceNo = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
		String invNum = invoiceNo.get(0).getText();
		Boolean flag = false;

		if (invoiceNo.size() > 0) {
			lavanteUtils.clicks(invoiceNo.get(0));
			lavanteUtils.fluentwait(objViewInvoicePage.invoiceHeaderTxt());

			String pngfile = CopyFile("a.png");

			dataMap.put("Document", pngfile);
			dataMap.put("DocumentType", "Payment");
			dataMap.put("Save", "");
			objViewInvoicePage.addDocuments(dataMap);

			enobjhomePage.logout();
			LdataMap.clear();
			//Buyer login
			List listofdatafrm = lavanteUtils.login("Kroger", browser);
			LdataMap = new LinkedHashMap<String, String>();
			LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

			enobjloginpage.logintoAPP(LdataMap);
			enobjhomePage.close();

			dataMap.put("maintab", "Transactions");
			dataMap.put("subtab", "customerInvoiceSearchResult");
			enobjhomePage.selectTab(dataMap);

			dataMap.put("InvoiceNumber", invNum);
			dataMap.put("Search", "");
			eninvoiceBasicSearch.Search(dataMap);

			lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
			invoiceNo = eninvoicePage.iterateSearchHeaderFindColList("Invoice Number");
			lavanteUtils.clicks(invoiceNo.get(0));
			lavanteUtils.fluentwait(objViewInvoicePage.invoiceHeaderTxt());

			dataMap.put("DeleteDoc", "");
			objViewInvoicePage.getDocumentDetails(dataMap, pngfile);

			List<WebElement> delFile = lavanteUtils.driver.findElements(By.xpath(dataMap.get("DeleteDoc")));
			if (delFile.size() > 0) {
				flag = false;
				Reporter.log("File uploaded by Supplier can be deleted");
			} else {
				flag = true;
				Reporter.log(
						"File uploaded by Supplier cannot be deleted by Buyer",	true);
			}

			softAssert.assertTrue(flag, "Supplier Document can be deleted");
			softAssert.assertAll();

			Reporter.log("Test Ended for VerifyInvoiceSuppAddDocInBuyerLogin :"	+ currenttime());
		}
	}


	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author vidya.c
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author vidya.c
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
