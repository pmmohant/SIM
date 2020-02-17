package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class PaymentCenterMappingPageTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();
	String payCntr1="";
	String customerID="";

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Vidya C
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
		List<?> listofdatafrm = lavanteUtils.login("Discovery", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=  lavanteUtils.fetchCustomer(LdataMap.get("username"));
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "PaymentCenterMapping");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * MangeRoles- Add & Edit Payment center mapping
	 * 
	 * @author Vidya C
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addEditPaymentCntrMapping() throws Exception {
		Reporter.log("Test Started for addNewPaymentCenterMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenterMaping", "any");
		dataMap.put("Division", "any");
		
		objPayCntrMapPage.addNewMapping(dataMap);
		
		lavanteUtils.waitForTime(3000);	
		lavanteUtils.waitforPageload(objPayCntrMapPage.AddMapping());
		boolean flag = false;
		boolean flag2 = false;
		payCntr1= dataMap.get("PaymentCenterMaping");
		String division1= dataMap.get("Division");
		String actualPaymentCntr,actualDivision;
		int noRecords = objPayCntrMapPage.ListPaymentCntrName.size();

		for (int i = 0; i <noRecords ; i++) {
			actualPaymentCntr = objPayCntrMapPage.ListPaymentCntrName.get(i).getText();
			actualDivision = objPayCntrMapPage.ListDivisionName.get(i).getText();
			Reporter.log("Payment Center name created " + actualPaymentCntr + " Expected Payment center name " + dataMap.get("PaymentCenterMaping"),true);
			Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);

			if (actualPaymentCntr.equals(payCntr1) && actualDivision.contains(division1)) {
				flag = true;
				Reporter.log("Payment Center name created " + actualPaymentCntr + " Expected Payment center name " + dataMap.get("PaymentCenterMaping"),true);
				Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);

				dataMap.put("Save", "");
				dataMap.put("Division", "ANY");
				click(objPayCntrMapPage.ListEditPaymentCntrMapping.get(i));
				objPayCntrMapPage.fillPaymentMapping(dataMap);
				objPayCntrMapPage.formAction(dataMap);
			
				lavanteUtils.waitForTime(3000);	
				lavanteUtils.waitforPageload(objPayCntrMapPage.AddMapping());
				String payCntr2=dataMap.get("PaymentCenterMaping");
				String division2=dataMap.get("Division");
				Reporter.log("Payment center name edited " + actualPaymentCntr + " Expected payment center name " + dataMap.get("PaymentCenter"),true);
				Reporter.log("Division name edited " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
				
				noRecords = objPayCntrMapPage.ListPaymentCntrName.size();
				for ( i = 0; i < noRecords; i++) {
					actualPaymentCntr = objPayCntrMapPage.ListPaymentCntrName.get(i).getText();
					actualDivision = objPayCntrMapPage.ListDivisionName.get(i).getText();
					if (actualPaymentCntr.equals(payCntr2) && actualDivision.contains(division2)) {
						flag2 = true;
						Reporter.log("Payment center name edited " + actualPaymentCntr + " Expected payment center name " + dataMap.get("PaymentCenter"),true);
						Reporter.log("Division name edited " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
						payCntr1=payCntr2;
					}
				}				
				
			}
		}
		
		softAssert.assertTrue(flag, "Payment center name created doesn't match");
		softAssert.assertTrue(flag2, "Payment center name edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
     * AddDelete PaymentCenterMapping - Will add a payment center mapping and delete the payment center mapping
      * Verification of Comments
     * 
      * @author Priyanka
     * @throws SQLException 
      * @throws IOException 
      * @throws FileNotFoundException 
      */
	@Test
	public void addDeletePaymentCenterMapping()throws Exception {
		
		Reporter.log("Test Started for addDeletePaymentCenterMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenterMaping", "any");
		dataMap.put("Division", "any");
		
		objPayCntrMapPage.addNewMapping(dataMap);
		
		lavanteUtils.waitForTime(3000);	
		lavanteUtils.waitforPageload(objPayCntrMapPage.AddMapping());
		boolean flagadd = false;
		boolean flagdelete = false;
		payCntr1= dataMap.get("PaymentCenterMaping");
		String division1= dataMap.get("Division");
		String actualPaymentCntr,actualDivision;
		int noRecords = objPayCntrMapPage.ListPaymentCntrName.size();

		for (int i = 0; i <noRecords ; i++) {
			actualPaymentCntr = objPayCntrMapPage.ListPaymentCntrName.get(i).getText();
			actualDivision = objPayCntrMapPage.ListDivisionName.get(i).getText();
			Reporter.log("Payment Center name created " + actualPaymentCntr + " Expected Payment center name " + dataMap.get("PaymentCenterMaping"),true);
			Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);

			if (actualPaymentCntr.equals(payCntr1) && actualDivision.contains(division1)) {
				flagadd = true;
				Reporter.log("Payment Center name created " + actualPaymentCntr + " Expected Payment center name " + dataMap.get("PaymentCenterMaping"),true);
				Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);

				
				click(objPayCntrMapPage.ListDeletePaymentCntrMapping.get(i));
				click (objPayCntrMapPage.DeleteBtn());
				
				fluentwait(objPayCntrMapPage.AddMapping());
				String query="select PaymentCenterID from PaymentCenter_Division_Map where PaymentCenterID in "+
				"(select PaymentCenterID from PaymentCenter where PaymentCenterName='"+payCntr1+"')";
				System.out.println("QUERY: " + query);
				query=lavanteUtils.fetchDBdata(query);
                if(query == null){
                       flagdelete=true;
                }
                break;
		}
		
			softAssert.assertTrue(flagadd, "Payment center mapping is not created..!");
			softAssert.assertTrue(flagdelete, "Payment center mapping is not deleted. Please recheck..!");
			softAssert.assertAll();
			Reporter.log("Test Ended for addDeletePaymentCenterMapping at:" + currenttime());	
		}
	}
	
	/**
     * Duplicate check PaymentcenterMapping - will check the duplicate  payment center mapping
      * 
      * @author Priyanka
     * @throws SQLException 
      * @throws IOException 
      * @throws FileNotFoundException 
      */
	//@Test  [Enable after the FIX of SIM-20166]
	public void duplicatePaymentCenterMapping() throws Exception {
		Reporter.log("Test Started for duplicatePaymentCenterMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flagduplicate = false;
		boolean dataflag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		if(!(objPayCntrMapPage.ListPaymentCntrName.size()>2))
		{
			dataMap.put("Save", "");
			dataMap.put("PaymentCenterMaping", "any");
			dataMap.put("Division", "any");
			objPayCntrMapPage.addNewMapping(dataMap);
			
		}
		
		if (objPayCntrMapPage.ListPaymentCntrName.size() > 0) {
			String paymentcnrtmaping= objPayCntrMapPage.ListPaymentCntrName.get(0).getText();
			click(objPayCntrMapPage.ListEditPaymentCntrMapping.get(0));
			dataMap.put("Save", "");
			dataMap.put("PaymentCenterMaping", paymentcnrtmaping);
			dataMap.put("Division", "any");
			
			objPayCntrMapPage.fillPaymentMapping(dataMap);
			objPayCntrMapPage.formAction(dataMap);
			lavanteUtils.waitForTime(4000);
			
			if (lavanteUtils.isElementDisplayed(objPayCntrMapPage.Errormsg())) {
				softAssert.assertTrue(objPayCntrMapPage.Errormsg().getText().trim().contains("Selected division is already mapped to payment center"),"Error Msg Not matched");
				Reporter.log("Error message:"+ objPayCntrMapPage.Errormsg().getText(), true);
				flagduplicate = true;
		}
			
			dataflag = true;
		}
		softAssert.assertTrue(flagduplicate, "Please recheck the test..!");
		softAssert.assertTrue(dataflag,"No data available. Please retest after adding atleast one entry.");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
     * Delete Associated Payment CenterMapping  - will check the AssociatedPaymentCenterMapping  
     * Verification of Comments
     * 
     * @author Priyanka
     * @throws SQLException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	//@Test  [Enable after the FIX of SIM-20166]
	public void deleteAssociatedPaymentCenterMapping() throws Exception {

		Reporter.log("Test Started for associatedPaymentCenterMapping: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		boolean dataflag = false;
		
		String actualPaymentCntr = "";		
		String expectpaymentCntr = "select paymentcentername from PaymentCenter where PaymentCenterID in "
				       + "(select top 1 PaymentCenterID from PaymentCenter_Division_Map) and CustomerID ="+customerID;
		expectpaymentCntr = lavanteUtils.fetchDBdata(expectpaymentCntr);
		Reporter.log("PaymentCenterName: " + expectpaymentCntr, true);
		
		if(expectpaymentCntr!=null){
		int noRecords = objPayCntrMapPage.ListPaymentCntrName.size();
		outr: for (int i = 0; i < noRecords; i++) {
			actualPaymentCntr = objPayCntrMapPage.ListPaymentCntrName.get(i).getText();
			if (actualPaymentCntr.equalsIgnoreCase(expectpaymentCntr)) {
				Reporter.log("Payment Center name matched " + actualPaymentCntr+ "Expected Payment center name from DB  "+ expectpaymentCntr, true);
				flag = true;
				click(objPayCntrMapPage.ListDeletePaymentCntrMapping.get(i));
				fluentwait(objPayCntrMapPage.DeleteBtn());
				click(objPayCntrMapPage.DeleteBtn());
				lavanteUtils.waitForTime(4000);
				if (lavanteUtils.isElementDisplayed(objPayCntrMapPage.bannerMsg())) {
					softAssert.assertTrue(objPayCntrMapPage.bannerMsg().getText().contains("Payment Center "+ expectpaymentCntr+ " cannot be deleted as it is already associated with supplier/division/payment terms"),"Error Msg Not matched");
					Reporter.log("Error message: "+ objPayCntrMapPage.bannerMsg().getText(), true);
					dataflag = true;
				}
				break outr;
			}
		}
	} else{
		softAssert.assertTrue(dataflag,"No data available in DB. Please add data and re-run the test.");
		dataflag = true;
	}
		softAssert.assertTrue(dataflag,"Please re-run the test.");
		softAssert.assertTrue(flag,"Data available in paymnet center page is not matching query result. Please recheck the data.");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	
	/**
     * Interrelation  Payment Center Mapping  - will check the data flow of PaymentCenterMapping
     * Verification of Comments
     * 
     * @author Priyanka
     */
	//@Test [Need Info]
	public void interRelationPaymentCenterMapping(){
		
		Reporter.log("Test Started for interRelationPaymentCenter: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		boolean flagAdd = false;
		boolean flag = false;
	
		String actualPaymentCntr="";
		String expctPayCntr = "AutoSG" + currenttime();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenter", expctPayCntr);
		objPayCntrMapPage.addNewMapping(dataMap);
	
		int noRecords = objPayCntrMapPage.ListPaymentCntrName.size();
		for (int i = 0; i < noRecords; i++) {
			actualPaymentCntr = objPayCntrMapPage.ListPaymentCntrName.get(i).getText();
			System.out.println("Actual paymet center " + actualPaymentCntr);
			if (actualPaymentCntr.equalsIgnoreCase(expctPayCntr)) {
				Reporter.log("Payment Center name created " + actualPaymentCntr + " Expected Payment center name:" + expctPayCntr, true);
				flagAdd = true;
				break;
			}
		}
		if (flagAdd) {
			dataMap.put("maintab", "Admin");
			dataMap.put("subtab", "PaymentCenterMapping");
			enobjhomePage.selectTab(dataMap);
			
			click(objPayCntrMapPage.AddMapping());
			switchtoFrame(objPayCntrMapPage.IframePaymentCenter);
			click(objPayCntrMapPage.PaymentCntrMapDropDwn());
			switchtoFrame(null);
			for (int i = 0; i < objPayCntrMapPage.Selectpymntcenter().size(); i++) {
				String paymntCntrMapdata = objPayCntrMapPage.Selectpymntcenter().get(i).getText().trim();
				if (expctPayCntr.equalsIgnoreCase(paymntCntrMapdata)) {
					Reporter.log("Actual Payment Center name availabe to select is: " + paymntCntrMapdata + ", Expected Payment center name : "+ expctPayCntr, true);
					flag = true;
					//PaymentCenter=expctPayCntr;
					break;
				}
			}
		}

		softAssert.assertTrue(flagAdd, "Add Payment Center is failed");
		softAssert.assertTrue(flag, "Payment center is not avilable");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		if(payCntr1.length()>0){
			String delquery="delete From PaymentCenter_Division_Map where PaymentCenterID in ( "
					+ " select PaymentCenterID from PaymentCenter where PaymentCenterName='"+payCntr1+"' )"; 
			lavanteUtils.UpdateDB(delquery);
		}
	}

	
	
	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
