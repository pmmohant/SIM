package com.lavante.sim.customer.TestScripts.Transactions.Payments;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class PaymentsSearchTestCases extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String CustomerID="";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		CustomerID=(String) listofdatafrm.get(1);
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod()
	public void BeforeMethod(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Transactions");
		dataMap.put("subtab", "PaymentResult");
		enobjhomePage.selectTab(dataMap);
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
		Reporter.log("Test Started for supplierERPID search:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		lavanteUtils.click(objPaymentsPage.BasicSearchTab());
		String ERPID="select MAX(REM.SupplierERPID) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID and R.CustomerID="+CustomerID;
		ERPID=lavanteUtils.fetchDBdata(ERPID);
		dataMap.put("SupplierERPID", ERPID);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		
		String getSupplierERPID = objPaymentsPage.getColumnText("Supplier ERP ID", 0);

		Reporter.log("Supplier ERP ID is not equall to the searched Supplier ERP ID, Expected : "				+ERPID + ", Actual : " + getSupplierERPID);
		softAssert.assertEquals(getSupplierERPID,ERPID,	"Supplier ERP ID is not equall to the searched Supplier ERP ID, Expected : "	+ERPID+ ", Actual : " + getSupplierERPID);
		softAssert.assertAll();
		Reporter.log("Test Ended for supplierERPID search:" + currenttime());
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

		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PONumber", x);
		x=" select SupplierName From Supplier Where LavanteUID in ( select LavanteUID From InvoiceHeader where InvoiceHeaderID in ( "
				+ " select InvoiceHeaderID From Payment where PONumber='"+x+"'))";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("SupplierName", x);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		String getSupplierName = objPaymentsPage.getColumnText("Supplier Name", 0);
		String getPONumber = objPaymentsPage.getColumnText("PO Number", 0);

		Reporter.log("Supplier Name is not equal to the searched Supplier Name, Expected : "	+ dataMap.get("SupplierName") + ", Actual : " + getSupplierName);
		softAssert.assertEquals(getSupplierName, dataMap.get("SupplierName"),	"Supplier Name is not equal to the searched Supplier Name, Expected : " + dataMap.get("SupplierName")		+ ", Actual : " + getSupplierName);

		Reporter.log("PO Number not equal to the searched PO Number, Expected : " + dataMap.get("PONumber")	+ ", Actual : " + getPONumber);
		softAssert.assertEquals(getPONumber, dataMap.get("PONumber"),"PO Number is not equal to the searched PO Number, Expected : " + dataMap.get("PONumber")			+ ", Actual : " + getPONumber);
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
		
		lavanteUtils.click(objPaymentsPage.BasicSearchTab());
		
		dataMap.put("Clear", "");
		objPaymentsPage.formAction(dataMap);
		dataMap.remove("Clear");
		
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		if(objPaymentsPage.ShowCountLink().size()>0){
			lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			String getcountStatus = lavanteUtils.getValue(objPaymentsPage.ShowCountLink().get(0), "style");
			if (!getcountStatus.equals("display: none;")) {

			}
		}

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		String getCount1 = lavanteUtils.getText(objPaymentsPage.GetResultsCount());
		
		String x="select MAX(InvoiceNumber) From InvoiceHeader where InvoiceHeaderID in ( select InvoiceHeaderID From Payment) ";
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("InvoiceNumber", x);
		dataMap.put("Search", "");
		objPaymentsPage.basicSearch(dataMap);
		dataMap.remove("Search");
		
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		lavanteUtils.fluentwait(objPaymentsPage.GetResultsCount());
		String getCount2 = lavanteUtils.getText(objPaymentsPage.GetResultsCount());
		boolean flag = false;
		if (getCount1 != getCount2) {
			flag = true;
		}
		Reporter.log("Data  available , Expected :" + getCount1 + " , Actual : " + getCount2,true);
		softAssert.assertTrue(flag, "Data is not available , Expected :  " + getCount1 + ", Actual : " + getCount2);

		dataMap.clear();
		dataMap.put("Clear", "");
		objPaymentsPage.formAction(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
	/*	getcountStatus = lavanteUtils.getValue(objPaymentsPage.ShowCountLink(), "style");
		if (!getcountStatus.equals("display: none;")) {
			lavanteUtils.clicks(objPaymentsPage.ShowCountLink());
		}*/
		String getCount3 = lavanteUtils.getText(objPaymentsPage.GetResultsCount());
		Reporter.log("Clear button is not working as expected, Expected :" + getCount1 + " , Actual : " + getCount3,true);
		softAssert.assertEquals(getCount1, getCount3,"Clear button is not working as expected, Expected :  getCount1, Actual : " + getCount3);

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
		Reporter.log("Test Started for advanceSearch001 :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
		String ERPID="select MAX(REM.SupplierERPID) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and P.PONumber='"+x+"' and R.CustomerID="+CustomerID;
		ERPID=lavanteUtils.fetchDBdata(ERPID);
		dataMap.put("AdvSupplierERPID", "Equals To#"+ERPID);

		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());
		
		dataMap.put("AdvSearch", "");
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");

		String actualPONumber = dataMap.get("PO Number").split("#")[1];
		int size = getPONumList.size();
		List<String> resultList = new ArrayList<String>();
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			String getTxt = getPONumList.get(i).getText();
			if (getTxt.equals(actualPONumber)) {
				flag = true;
				Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + getTxt);
				softAssert.assertTrue(flag,"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + getTxt);
				break;
			} else {
				flag = false;
			}
		}
		softAssert.assertTrue(flag,"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + resultList);
		resultList.clear();
		List<WebElement> getSupplierERPIDList = objPaymentsPage.iterateSearchHeaderFindColList("Supplier ERP ID");
		String actualSupplierERPID = dataMap.get("AdvSupplierERPID").split("#")[1];
		flag = false;
		for (int i = 0; i < getSupplierERPIDList.size(); i++) {
			String getTxt = getSupplierERPIDList.get(i).getText();

			if (getTxt.equals(actualSupplierERPID)) {
				resultList.add(i, getTxt);
				flag = true;
			} else {
				flag = false;
			}
		}
		Reporter.log("Advance Searched Supplier ERP ID :, Expected : " + actualSupplierERPID + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched supplier ERP ID doesn't match  :, Expected : "+ actualSupplierERPID + ", Actual : " + resultList);
		softAssert.assertAll();
		Reporter.log("Test Ended for advanceSearch001 :" + currenttime());
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
	
		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
		String ERPID="select MAX(REM.SupplierERPID) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and P.PONumber='"+x+"' and R.CustomerID="+CustomerID;
		ERPID=lavanteUtils.fetchDBdata(ERPID);
		if(ERPID!=null && ERPID.length()>0){
			dataMap.put("AdvSupplierERPID", "Equals To#"+ERPID);
		}
		dataMap.put("AdvSaveQuery", "");
		String saveQueryName = "AutoSP_" + currenttime();
		dataMap.put("EnterQueryName", saveQueryName);
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.refreshPage();
		boolean flag = false;
		String actualQueryName = null;
		List<WebElement> savedQuerylist = objPaymentsPage.ListSavedPrivateQuery();
		int size = savedQuerylist.size();
		String getTxt="";
		for (int i = 0; i < size; i++) {
			actualQueryName = savedQuerylist.get(i).getText();
			if (actualQueryName.equals(dataMap.get("EnterQueryName"))) {
				flag = true;
				break;
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "		+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")	+ ", Actual : " + actualQueryName);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");
		size = getPONumList.size();
		
		String actualPONumber ="";
		String actualSupplierERPID ="";
		if(size>0){
			actualPONumber= dataMap.get("PO Number").split("#")[1];
			flag = false;
			getTxt = "";
			for (int i = 0; i < size; i++) {
				getTxt = getPONumList.get(i).getText();
				if (getTxt.equals(actualPONumber)) {
					Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + getTxt);
					flag = true;
					
				} else {
					flag = false;
				}
			}
			softAssert.assertTrue(flag,"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + getTxt);
			Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + getTxt);
			
			List<WebElement> getSupplierERPIDList = objPaymentsPage.iterateSearchHeaderFindColList("Supplier ERP ID");
			actualSupplierERPID = dataMap.get("AdvSupplierERPID").split("#")[1];
			flag = false;
			for (int i = 0; i < getSupplierERPIDList.size(); i++) {
				getTxt = getSupplierERPIDList.get(i).getText();
				if (getTxt.equals(actualSupplierERPID)) {
					flag = true;
					Reporter.log("Advance Searched Supplier name :, Expected : " + actualSupplierERPID + ", Actual : " + getTxt);
					softAssert.assertTrue(flag, "Advance Searched supplier name doesn't match  :, Expected : " + actualSupplierERPID+ ", Actual : " + getTxt);
					
				} else {
					flag = false;
				}
			}
		}
		
		softAssert.assertTrue(flag, "Advance Searched supplier name doesn't match  :, Expected : " + actualSupplierERPID+ ", Actual : " + getTxt);
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
		Reporter.log("Test Started for deleteQuery :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());
		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);

		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
		
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
				break;
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "	+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")	+ ", Actual : " + actualQueryName);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");
		size = getPONumList.size();
		if(size>0){
			String actualPONumber = dataMap.get("PO Number").split("#")[1];
			List<String> resultList = new ArrayList<String>();
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
	
			lavanteUtils.switchtoFrame(null);
	
			dataMap.put("PrivateQuery", "");
			dataMap.put("QueryName", dataMap.get("EnterQueryName"));
			objPaymentsPage.deleteMyQuery(dataMap);
	
			flag = false;
			List<String> result = new ArrayList<>();
			List<WebElement> savedPrivateQuery = objPaymentsPage.ListSavedPrivateQuery();
			if(savedPrivateQuery.size()>0){
				for (int i = 0; i < savedPrivateQuery.size(); i++) {
					String getSavedQueryName = savedPrivateQuery.get(i).getText();
					if (getSavedQueryName.equals(dataMap.get("EnterQueryName"))) {
						flag = false;
					} else {
						result.add(getSavedQueryName);
						flag = true;
					}
				}
			}else{
				flag=true;
			}
		}
		Reporter.log("Verify saved query is deleted : Query Name" + dataMap.get("EnterQueryName") );
		softAssert.assertTrue(flag,"Saved query not deleted : Query Name" + dataMap.get("EnterQueryName") );
		softAssert.assertAll();
		Reporter.log("Test Ended for deleteQuery :" + currenttime());
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
		Reporter.log("Test Started for saveQuery :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		lavanteUtils.clicks(objPaymentsPage.AdvanceSearchTab());

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", "AutoSP");
		objPaymentsPage.deleteMyQuery(dataMap);
		
		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
		dataMap.put("AdvSearch", "");
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.fluentwait(objPaymentsPage.IframeResultsPage());
		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");
		int size = getPONumList.size();
		boolean flag = false;
		String actualQueryName="";
		if(size>0){
			String actualPONumber = dataMap.get("PO Number").split("#")[1];
			
			List<String> resultList = new ArrayList<String>();
			for (int i = 0; i < size; i++) {
				String getTxt = getPONumList.get(i).getText();
				if (getTxt.equals(actualPONumber)) {
					flag = true;
					Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + getTxt);
					softAssert.assertTrue(flag,	"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + getTxt);
					
				} else {
					flag = false;
					break;
				}
			}
			Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + resultList);
			softAssert.assertTrue(flag,	"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + resultList);
	
			dataMap.clear();
			String saveQueryName = "AutoSP_" + currenttime();
			dataMap.put("EnterQueryName", saveQueryName);
			dataMap.put("SaveQuery", "");
			objPaymentsPage.formAction(dataMap);
	
			lavanteUtils.refreshPage();
			flag = false;
			List<WebElement> savedQuerylist = objPaymentsPage.ListSavedPrivateQuery();
			size = savedQuerylist.size();
			for (int i = 0; i < size; i++) {
				String savedQeryName = savedQuerylist.get(i).getText();
				if (savedQeryName.equals(dataMap.get("EnterQueryName"))) {
					actualQueryName = savedQeryName;
					flag = true;
				}
			}
		}
		Reporter.log("Verify saved query name :, Expected : " + dataMap.get("EnterQueryName") + ", Actual : "	+ actualQueryName);
		softAssert.assertTrue(flag, "Saved query name is not matching :, Expected : " + dataMap.get("EnterQueryName")	+ ", Actual : " + actualQueryName);

		softAssert.assertAll();
		Reporter.log("Test Ended for saveQuery :" + currenttime());
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

		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
				+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
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

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.clicks(objPaymentsPage.AdvanceClearSearchBtn());

		lavanteUtils.refreshPage();

		dataMap.put("PrivateQuery", "");
		dataMap.put("QueryName", saveQueryName);
		objPaymentsPage.runMyQuery(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");
		size = getPONumList.size();
		String actualPONumber ="";
		List<String> resultList = new ArrayList<String>();
		if(size>0){
			actualPONumber = dataMap.get("PO Number").split("#")[1];
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
		}
		Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + resultList);
		softAssert.assertTrue(flag,	"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + resultList);

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

		String x="select MAX(P.PONumber) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
					+ " and REM.SupplierERPID is not null and P.PONumber is not null and R.CustomerID="+CustomerID;
		x=lavanteUtils.fetchDBdata(x);
		dataMap.put("PO Number", "Equals To#"+x);
		dataMap.put("AdvSaveQuery", "");
		String saveQueryName = "AutoSP_" + currenttime();
		dataMap.put("EnterQueryName", saveQueryName);
		objPaymentsPage.buildQuerySearch(dataMap);

		lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
		List<WebElement> getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");
		int size = getPONumList.size();
		List<String> resultList = new ArrayList<String>();
		boolean flag = false;
		String actualPONumber ="";
		String actualSupplierERPID="";
		if(size>0){
			for (int i = 0; i < size; i++) {
				actualPONumber = dataMap.get("PO Number").split("#")[1];
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
			String ERPID="select MAX(REM.SupplierERPID) from Payment P,Relationship_ERP_Map rem ,Relationship R  where p.RelationshipERPMapID=rem.RelationshipERPMapID and R.RelationShipID=REM.RelationshipID "
					+ " and REM.SupplierERPID is not null and P.PONumber='"+x+"' and R.CustomerID="+CustomerID;
			ERPID=lavanteUtils.fetchDBdata(ERPID);
			dataMap.put("AdvSupplierERPID", "Equals To#"+ERPID);
			objPaymentsPage.advanceFillSearchDetails(dataMap);
	
			lavanteUtils.fluentwait(objPaymentsPage.SaveQueryBtn());
			lavanteUtils.clicks(objPaymentsPage.SaveQueryBtn());
	
			lavanteUtils.switchtoFrame(objPaymentsPage.IframeAdvanceSavedSearch());
			lavanteUtils.clicks(objPaymentsPage.SaveQuerySaveBtn());
	
			lavanteUtils.switchtoFrame(objPaymentsPage.IframeResultsPage());
			getPONumList = objPaymentsPage.iterateSearchHeaderFindColList("PO Number");
			dataMap.put("PO Number", "Equals To#"+x);
			actualPONumber = dataMap.get("PO Number").split("#")[1];
			size = getPONumList.size();
			resultList = new ArrayList<String>();
			
			flag = false;
			for (int i = 0; i < size; i++) {
				String getTxt = getPONumList.get(i).getText();
				if (getTxt.contains(actualPONumber)) {
					resultList.add(i, getTxt);
					flag = true;
				} else {
					flag = false;
				}
			}
			Reporter.log("Advance Searched PO Num :, Expected : " + actualPONumber + ", Actual : " + resultList);
			softAssert.assertTrue(flag,"Advance Searched PO Num doesn't match  :, Expected : " + actualPONumber + ", Actual : " + resultList);
	
			resultList.clear();
	
			List<WebElement> getSupplierERPIDList = objPaymentsPage.iterateSearchHeaderFindColList("Supplier ERP ID");
			actualSupplierERPID = dataMap.get("AdvSupplierERPID").split("#")[1];
			flag = false;
			for (int i = 0; i < getSupplierERPIDList.size(); i++) {
				String getTxt = getSupplierERPIDList.get(i).getText();
				if (getTxt.equals(actualSupplierERPID)) {
					resultList.add(i, getTxt);
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		Reporter.log("Advance Searched Supplier ERP ID : Expected : " + actualSupplierERPID + ", Actual : " + resultList);
		softAssert.assertTrue(flag, "Advance Searched supplier ERP ID doesn't match  :, Expected : "+ actualSupplierERPID + ", Actual : " + resultList);

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
