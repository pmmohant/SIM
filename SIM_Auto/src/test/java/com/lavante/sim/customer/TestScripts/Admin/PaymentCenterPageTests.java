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

public class PaymentCenterPageTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();
	String PaymentCenter="";
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
		//List listofdatafrm = lavanteUtils.login("UserRoleId14", browser);
		List<?> listofdatafrm = lavanteUtils.login("Discovery", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=  lavanteUtils.fetchCustomer(LdataMap.get("username"));

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "PaymentCenter");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * MangeRoles- Add & Edit Payment center
	 * 
	 * @author Vidya C
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addEditPaymentCenter() throws Exception {
		Reporter.log("Test Started for addNewPaymentCenter: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		String payCntr1="AutoSG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenter", payCntr1);
		objPaymentCenterPage.addNewPaymentCenter(dataMap);
		
		boolean flag = false;
		boolean flag2 = false;
		String actualPaymentCntr;
		lavanteUtils.waitforPageload(objPaymentCenterPage.AddPaymentCenter());
		int noRecords = objPaymentCenterPage.ListPaymentCenterName.size();
		outr:for (int i = 0; i <noRecords ; i++) {
			actualPaymentCntr = objPaymentCenterPage.ListPaymentCenterName.get(i).getText();
			if (actualPaymentCntr.equals(payCntr1)) {
				flag = true;
				Reporter.log("Payment Center name created " + actualPaymentCntr + "Expected Payment center name " + dataMap.get("PaymentCenter"),true);
				
				String payCntr2="AutoSG"+currenttime();
				dataMap.put("PaymentCenter", payCntr2);
				click(objPaymentCenterPage.ListEditPaymentCenter.get(i));

				objPaymentCenterPage.fillPaymentCenter(dataMap);
				click(objPaymentCenterPage.ListCheckedPaymentCenter.get(0));
				lavanteUtils.waitForTime(4000);
				lavanteUtils.fluentwait(objPaymentCenterPage.ListPaymentCenterName.get(0));
				int xnoRecords = objPaymentCenterPage.ListPaymentCenterName.size();
				for (int ji = 0; ji < xnoRecords; ji++) {
					actualPaymentCntr = objPaymentCenterPage.ListPaymentCenterName.get(ji).getText();
					if (actualPaymentCntr.equals(payCntr2)) {
						flag2 = true;
						Reporter.log("Payment center name edited " + actualPaymentCntr + "payment center name " + dataMap.get("PaymentCenter"),true);
						PaymentCenter=payCntr2;
						break outr;
					}
				}				
				
			}
		}
		
		softAssert.assertTrue(flag, "Payment center name created doesn't match are not created");
		softAssert.assertTrue(flag2, "Payment center name edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
     * AddDelete Paymentcenter - Will add a payment center and delete the payment center
      * Verification of Comments
     * 
      * @author Priyanka
     * @throws SQLException 
      * @throws IOException 
      * @throws FileNotFoundException 
      */
	@Test
	public void addDeletePaymentCenter()throws Exception {
		
		Reporter.log("Test Started for addDeletePaymentCenter: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flagadd = false;
		boolean flagdelete = false;
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String payCntr1="AutoSG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenter", payCntr1);
		
		objPaymentCenterPage.addNewPaymentCenter(dataMap);
		PaymentCenter=payCntr1;
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(objPaymentCenterPage.AddPaymentCenter());
		for (int i = 0; i <objPaymentCenterPage.ListPaymentCenterName.size(); i++) {
			String actualPaymentCntr = objPaymentCenterPage.ListPaymentCenterName.get(i).getText();
			if (actualPaymentCntr.equals(payCntr1)) {
				Reporter.log("Payment Center name created " + actualPaymentCntr + "Expected Payment center name " + dataMap.get("PaymentCenter"),true);
				flagadd = true;

				click(objPaymentCenterPage.ListDeletePaymentCenter.get(i));
				click(objPaymentCenterPage.DeleteBtn());
				
				fluentwait(objPaymentCenterPage.AddPaymentCenter());
				String query="select PaymentCenterName from PaymentCenter where PaymentCenterName='"+payCntr1+"'";
				query=lavanteUtils.fetchDBdata(query);
                if(query == null){
                       flagdelete=true;
                }
                break;
		    }
			
		}
		softAssert.assertTrue(flagadd, "Payment center name is not created..!");
		softAssert.assertTrue(flagdelete, "Payment center not deleted. Please recheck..!");
		softAssert.assertAll();
		Reporter.log("Test Ended for addDeletePaymentCenter at:" + currenttime());
		
	}
	
	/**
     * Duplicate check Paymentcenter - will check the duplicate  payment center
      * Verification of Comments
     * 
      * @author Priyanka
     * @throws SQLException 
      * @throws IOException 
      * @throws FileNotFoundException 
      */
	@Test
	public void duplicatePaymentCenter() throws Exception {
		Reporter.log("Test Started for duplicatePaymentCenter: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flagduplicate = false;
		boolean dataflag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		if (objPaymentCenterPage.ListPaymentCenterName.size() > 0) {
			String paymentcentername = objPaymentCenterPage.ListPaymentCenterName.get(0).getText();
			dataMap.put("Save", "");
			dataMap.put("PaymentCenter", paymentcentername);
			objPaymentCenterPage.addNewPaymentCenter(dataMap);

			if (objPaymentCenterPage.Errormsg().isDisplayed()) {
				softAssert.assertTrue(objPaymentCenterPage.Errormsg().getText().trim().contains("Payment Center with the name "+ paymentcentername +" is already exists"),"Error Msg Not matched");
				Reporter.log("Error message:"+ objPaymentCenterPage.Errormsg().getText(), true);
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
     * Delete Associated Payment Center  - will check the AssociatedPaymentCenter  
     * Verification of Comments
     * 
     * @author Priyanka
     * @throws SQLException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	@Test
	public void deleteAssociatedPaymentCenter() throws Exception {

		Reporter.log("Test Started for associatedPaymentCenter: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		boolean dataflag = false;
		
		String actualPaymentCntr = "";		
		String expectpaymentCntr = "select paymentcentername from PaymentCenter where PaymentCenterID in "
				       + "(select top 1 PaymentCenterID from PaymentCenter_Division_Map) and CustomerID ="+customerID;
		expectpaymentCntr = lavanteUtils.fetchDBdata(expectpaymentCntr);
		Reporter.log("PaymentCenterName: " + expectpaymentCntr, true);
		
		if(expectpaymentCntr!=null){
		int noRecords = objPaymentCenterPage.ListPaymentCenterName.size();
		outr: for (int i = 0; i < noRecords; i++) {
			actualPaymentCntr = objPaymentCenterPage.ListPaymentCenterName.get(i).getText();
			if (actualPaymentCntr.equalsIgnoreCase(expectpaymentCntr)) {
				Reporter.log("Payment Center name matched " + actualPaymentCntr+ "Expected Payment center name from DB  "+ expectpaymentCntr, true);
				flag = true;
				click(objPaymentCenterPage.ListDeletePaymentCenter.get(i));
				fluentwait(objPaymentCenterPage.DeleteBtn());
				click(objPaymentCenterPage.DeleteBtn());
				lavanteUtils.waitForTime(4000);
				if (lavanteUtils.isElementDisplayed(objPaymentCenterPage.bannerMsg())) {
					softAssert.assertTrue(objPaymentCenterPage.bannerMsg().getText().contains("Payment Center "+ expectpaymentCntr+ " cannot be deleted as it is already associated with supplier/division/payment terms"),"Error Msg Not matched");
					Reporter.log("Error message: "+ objPaymentCenterPage.bannerMsg().getText(), true);
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
     * Interrelation  Payment Center  - will check the data flow of PaymentCenter  
     * Verification of Comments
     * 
     * @author Priyanka
     */
	@Test
	public void interRelationPaymentCenter(){
		
		Reporter.log("Test Started for interRelationPaymentCenter: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		boolean flagAdd = false;
		boolean flag = false;
	

		String actualPaymentCntr="";
		String expctPayCntr = "AutoSG" + currenttime();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenter", expctPayCntr);
		objPaymentCenterPage.addNewPaymentCenter(dataMap);
	
		int noRecords = objPaymentCenterPage.ListPaymentCenterName.size();
		for (int i = 0; i < noRecords; i++) {
			actualPaymentCntr = objPaymentCenterPage.ListPaymentCenterName.get(i).getText();
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
					PaymentCenter=expctPayCntr;
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
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		if(PaymentCenter.length()>0){
			String delquery="delete from PaymentCenter where PaymentCenterName='"+PaymentCenter+"'";
			lavanteUtils.UpdateDB(delquery);
		}
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
