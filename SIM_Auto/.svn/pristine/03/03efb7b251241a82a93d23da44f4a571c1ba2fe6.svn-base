package com.lavante.sim.customer.TestScripts.Transactions.Payments;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

public class SupplierPaymentsSearchTestCases extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String Email="";
	
	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
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

		List<?> listofdatafrm = lavanteUtils.login("KrogerSupplier", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		Email=LdataMap.get("username");
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod
	public void Before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "TRANSACTIONS");
		dataMap.put("subtab","Payment");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Clear","");
		objPaymentsPage.formAction(dataMap);
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Basic search Test case
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void BasicSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for BasicSearchTest search:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.click(objPaymentsPage.BasicSearchTab());
		
		String x=" select MAX(P.PONumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID "
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"'";
		x=lavanteUtils.fetchDBdata(x);
		
		dataMap.put("PONumber", x);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getPONumber = objPaymentsPage.getColumnText("PO Number", 0);

		Reporter.log("PO Number not equal to the searched PO Number, Expected : " + dataMap.get("PONumber")	+ ", Actual : " + getPONumber);
		softAssert.assertEquals(getPONumber, dataMap.get("PONumber"),"PO Number is not equal to the searched PO Number, Expected : " + dataMap.get("PONumber")	+ ", Actual : " + getPONumber);
		softAssert.assertAll();
		Reporter.log("Test Ended for BasicSearchTest search:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Multiple search field Test case
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void multipleSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for multipleSearchTest search:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.click(objPaymentsPage.BasicSearchTab());
		

		String x=" select MAX(P.PONumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID "
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"'";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PONumber", x);
		x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' and P.PONumber='"+x+"'";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", x);
		
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getSupplierName = objPaymentsPage.getColumnText("Invoice Number", 0);
		String getPONumber = objPaymentsPage.getColumnText("PO Number", 0);

		Reporter.log("Invoice number is not equal to the searched Invoice number, Expected : " 	+ dataMap.get("InvoiceNumber") + ", Actual : " + getSupplierName);
		softAssert.assertEquals(getSupplierName, dataMap.get("InvoiceNumber"),	"Invoice number is not equal to the searched Invoice number, Expected : " + dataMap.get("InvoiceNumber")	+ ", Actual : " + getSupplierName);

		Reporter.log("PO Number not equal to the searched PO Number, Expected : " + dataMap.get("PONumber")		+ ", Actual : " + getPONumber);
		softAssert.assertEquals(getPONumber, dataMap.get("PONumber"),"PO Number is not equal to the searched PO Number, Expected : " + dataMap.get("PONumber")	+ ", Actual : " + getPONumber);
		softAssert.assertAll();
		Reporter.log("Test Ended for multipleSearchTest search:" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Basic search clear Test case
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void clearSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for clear Search :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		dataMap.put("Clear", "");
		objPaymentsPage.formAction(dataMap);
		dataMap.remove("Clear");
		
		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		String getcount ="";
		if(objPaymentsPage.ShowCountLink().size()>0){
			lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			 getcount = lavanteUtils.getText(objPaymentsPage.GetCountNo());
			if (!getcount.contains("(")) {
				lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			}
		}
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String getCount1 = lavanteUtils.getText(objPaymentsPage.GetResultsCount());
		
		String x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' ";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", x);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.fluentwait(objPaymentsPage.GetResultsCount());
		String getCount2 = lavanteUtils.getText(objPaymentsPage.GetResultsCount());
		boolean flag = false;
		if (getCount1 != getCount2) {
			flag = true;
		}
		Reporter.log("Data not available , Expected :" + getCount1 + " , Actual : " + getCount2,true);
		softAssert.assertTrue(flag, "Data is not available , Expected :  " + getCount1 + ", Actual : " + getCount2);

		dataMap.clear();
		dataMap.put("Clear", "");
		objPaymentsPage.formAction(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		getcount = lavanteUtils.getText(objPaymentsPage.GetCountNo());
		if (!getcount.contains("(")) {
			lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
		}
		lavanteUtils.fluentwait(objPaymentsPage.GetResultsCount());
		String getCount3 = lavanteUtils.getText(objPaymentsPage.GetResultsCount());
		Reporter.log("Clear button is not working as expected, Expected :" + getCount1 + " , Actual : " + getCount3,true);
		softAssert.assertEquals(getCount1, getCount3,"Clear button is not working as expected, Expected :  "+getCount1+", Actual : " + getCount3);

		softAssert.assertAll();
		Reporter.log("Test Ended for clear Search :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Build query search by Supplier ERP ID and PO Number
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void buildQuerySearch() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for buildQuerySearch :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();


		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());

		String x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' ";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", "Equals To#"+x);
		dataMap.put("AdvSearch", "");
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());

		List<String> resultList = new ArrayList<String>();
		List<WebElement> InvoiceNumberList = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		String InvoiceNumber = dataMap.get("InvoiceNumber").split("#")[1];
		boolean flag = false;
		for (int i = 0; i < InvoiceNumberList.size(); i++) {
			String getTxt = InvoiceNumberList.get(i).getText();

			if (getTxt.equals(InvoiceNumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched Invoice Number :, Expected : " + InvoiceNumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched Invoice Number  doesn't match  :, Expected : " + InvoiceNumber	+ ", Actual : " + resultList);
		softAssert.assertAll();
		Reporter.log("Test Ended for buildQuerySearch :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Build query search by Supplier ERP ID and PO Number and save
	 *         query
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void buildQuerySaveSearch() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for buildQuerySaveSearch :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);
		
		String x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"'";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", "Equals To#"+x);
		dataMap.put("AdvSaveQuery", "");
		String saveQueryName = "AutoSP_" + currenttime();
		dataMap.put("EnterQueryName", saveQueryName);
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.refreshPage();
		boolean flag = false;
		String actualQueryName = null;
		List<WebElement> savedQuerylist = objPaymentsPage.ListSavedPrivateQuery();
		int size = savedQuerylist.size();

		for (int i = 0; i < size; i++) {
			actualQueryName = savedQuerylist.get(i).getText();
			if (actualQueryName.equals(dataMap.get("EnterQueryName"))) {
				flag = true;
				break;
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "	+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")	+ ", Actual : " + actualQueryName);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());

		List<String> resultList = new ArrayList<String>();
		List<WebElement> InvoiceNumberList = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		String InvoiceNumber = dataMap.get("InvoiceNumber").split("#")[1];
		flag = false;
			for (int i = 0; i < InvoiceNumberList.size(); i++) {
				String getTxt = InvoiceNumberList.get(i).getText();
				if (getTxt.equals(InvoiceNumber)) {
					resultList.add(i, getTxt);
					flag = true;
				} else {
					flag = false;
				}
			}
		
		Reporter.log("Advance Searched Invoice Number :, Expected : " + InvoiceNumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched Invoice Number  doesn't match  :, Expected : " + InvoiceNumber+ ", Actual : " + resultList);
		softAssert.assertAll();
		Reporter.log("Test Ended for buildQuerySaveSearch :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Build query search by PO Number and Delete query
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void deleteQuery() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for advanceSearch003 :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());
		
		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);

		String x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' ";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", "Equals To#"+x);
		dataMap.put("AdvSaveQuery", "");
		String saveQueryName = "AutoSP_" + currenttime();
		dataMap.put("EnterQueryName", saveQueryName);
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.refreshPage();
		boolean flag = false;
		String actualQueryName = null;
		List<WebElement> savedQuerylist = objPaymentsPage.ListSavedPrivateQuery();
		int size = savedQuerylist.size();
		for (int i = 0; i < size; i++) {
			String savedQeryName = savedQuerylist.get(i).getText();
			if (savedQeryName.equals(dataMap.get("EnterQueryName"))) {
				actualQueryName = savedQeryName;
				flag = true;
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "	+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")+ ", Actual : " + actualQueryName);
		List<String> resultList = new ArrayList<String>();
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> InvoiceNumberList = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		String InvoiceNumber = dataMap.get("InvoiceNumber").split("#")[1];
		flag = false;
		for (int i = 0; i < InvoiceNumberList.size(); i++) {
			String getTxt = InvoiceNumberList.get(i).getText();

			if (getTxt.equals(InvoiceNumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched Invoice Number :, Expected : " + InvoiceNumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched Invoice Number  doesn't match  :, Expected : " + InvoiceNumber+ ", Actual : " + resultList);
		lavanteUtils.switchtoFrame(null);

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", dataMap.get("EnterQueryName"));
		objPaymentsPage.deleteMyQuery(dataMap);

		flag = false;
		List<WebElement> savedPrivateQuery = objPaymentsPage.ListSavedPrivateQuery();
		if(savedPrivateQuery.size()>0){
			for (int i = 0; i <savedPrivateQuery.size(); i++) {
				String getSavedQueryName = savedPrivateQuery.get(i).getText();
				if (getSavedQueryName.equals(dataMap.get("EnterQueryName"))) {
					flag = false;
				} else {
					flag = true;
				}
			} 
		}else {
			flag=true;
		}
		
		Reporter.log("Verify saved query is deleted : Query Name" + dataMap.get("EnterQueryName") );
		softAssert.assertTrue(flag,"Saved query not deleted : Query Name" + dataMap.get("EnterQueryName") );

		softAssert.assertAll();
		Reporter.log("Test Ended for advanceSearch003 :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Build query search by PO Number and save in advance search page
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void saveQuery() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for advanceSearch004 :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);

		String x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' ";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", "Equals To#"+x);
		dataMap.put("AdvSearch", "");
		objPaymentsPage.buildQuerySearch(dataMap);

		List<String> resultList = new ArrayList<String>();
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> InvoiceNumberList = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		String InvoiceNumber = dataMap.get("InvoiceNumber").split("#")[1];
		boolean flag = false;
		for (int i = 0; i < InvoiceNumberList.size(); i++) {
			String getTxt = InvoiceNumberList.get(i).getText();

			if (getTxt.equals(InvoiceNumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched Invoice Number :, Expected : " + InvoiceNumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched Invoice Number  doesn't match  :, Expected : " + InvoiceNumber+ ", Actual : " + resultList);
		lavanteUtils.switchtoFrame(null);
		dataMap.clear();
		String saveQueryName = "AutoSP_" + generateRandomNumber9OnLength(8);
		dataMap.put("EnterQueryName", saveQueryName);
		dataMap.put("SaveQuery", "");
		objPaymentsPage.formAction(dataMap);

		lavanteUtils.refreshPage();
		flag = false;
		String actualQueryName = null;
		List<WebElement> savedQuerylist = objPaymentsPage.ListSavedPrivateQuery();
		int size = savedQuerylist.size();
		for (int i = 0; i < size; i++) {
			String savedQeryName = savedQuerylist.get(i).getText();
			if (savedQeryName.equals(dataMap.get("EnterQueryName"))) {
				actualQueryName = savedQeryName;
				flag = true;
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "
				+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")
				+ ", Actual : " + actualQueryName);

		softAssert.assertAll();
		Reporter.log("Test Ended for advanceSearch004 :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Build query search by PO Number save, clear and run query
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void runQuery() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for runQuery :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);

		String x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' ";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", "Equals To#"+x);
		dataMap.put("AdvSaveQuery", "");
		String saveQueryName = "AutoSP_" + generateRandomNumber9OnLength(8);
		dataMap.put("EnterQueryName", saveQueryName);
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.refreshPage();

		boolean flag = false;
		String actualQueryName = null;
		List<WebElement> savedQuerylist = objPaymentsPage.ListSavedPrivateQuery();
		int size = savedQuerylist.size();
		for (int i = 0; i < size; i++) {
			String savedQeryName = savedQuerylist.get(i).getText();
			if (savedQeryName.equals(dataMap.get("EnterQueryName"))) {
				actualQueryName = savedQeryName;
				flag = true;
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "	+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")+ ", Actual : " + actualQueryName);

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.clicks(objPaymentsPage.AdvanceClearSearchBtn());
		lavanteUtils.refreshPage();

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", saveQueryName);
		objPaymentsPage.runMyQuery(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<String> resultList = new ArrayList<String>();
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> InvoiceNumberList = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		String InvoiceNumber = dataMap.get("InvoiceNumber").split("#")[1];
		flag = false;
		for (int i = 0; i < InvoiceNumberList.size(); i++) {
			String getTxt = InvoiceNumberList.get(i).getText();

			if (getTxt.equals(InvoiceNumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched Invoice Number :, Expected : " + InvoiceNumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched Invoice Number  doesn't match  :, Expected : " + InvoiceNumber+ ", Actual : " + resultList);
		softAssert.assertAll();
		Reporter.log("Test Ended for runQuery :" + currenttime());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Build query search by PO Number save verify and Edit search
	 *         criteria save and verify
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void editQuery() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for editQuery :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);

		String x=" select MAX(P.PONumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID "
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"'";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
		dataMap.put("AdvSaveQuery", "");
		String saveQueryName = "AutoSP_" + generateRandomNumber9OnLength(8);
		dataMap.put("EnterQueryName", saveQueryName);
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = enobjsupplierPage.iterateSearchHeaderFindColList("PO Number");

		String actualPONumber = dataMap.get("PO Number").split("#")[1];
		int size = getPONumList.size();
		List<String> resultList = new ArrayList<String>();
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			String getTxt = getPONumList.get(i).getText();
			if (getTxt.equals(actualPONumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag,"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + resultList);

		lavanteUtils.refreshPage();
		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", saveQueryName);
		objPaymentsPage.editMyQuery(dataMap);

		dataMap.clear();
		x="select MAX(I.InvoiceNumber) from Contact C, Supplier_Contact_Map scm, InvoiceHeader I, Payment P where C.ContactID = scm.ContactID"
				+ " and I.LavanteUID=scm.LavanteUID and P.InvoiceHeaderID = I.InvoiceHeaderId and C.Email='"+Email+"' and P.PONumber='"+x+"'";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", "Equals To#"+x);
		objPaymentsPage.advanceFillSearchDetails(dataMap);

		dataMap.put("AdvSaveQuery", "");
		objPaymentsPage.formAction(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		resultList.clear();
		List<WebElement> InvoiceNumberList = enobjsupplierPage.iterateSearchHeaderFindColList("Invoice Number");
		String InvoiceNumber = dataMap.get("InvoiceNumber").split("#")[1];
		flag = false;
		for (int i = 0; i < InvoiceNumberList.size(); i++) {
			String getTxt = InvoiceNumberList.get(i).getText();
			if (getTxt.equals(InvoiceNumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched Invoice Number :, Expected : " + InvoiceNumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched Invoice Number  doesn't match  :, Expected : " + InvoiceNumber+ ", Actual : " + resultList);

		resultList.clear();
		getPONumList = enobjsupplierPage.iterateSearchHeaderFindColList("PO Number");

		size = getPONumList.size();
		flag = false;
		for (int i = 0; i < size; i++) {
			String getTxt = getPONumList.get(i).getText();
			if (getTxt.equals(actualPONumber)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag,"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + resultList);

		softAssert.assertAll();
		Reporter.log("Test Ended for editQuery :" + currenttime());
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
