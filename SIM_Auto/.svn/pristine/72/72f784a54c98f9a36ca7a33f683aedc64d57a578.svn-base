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

public class PaymentTermsPageTests extends PageInitiator {
	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = "";
	String paymentName="";
	

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Vidya C
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(
			@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		// List listofdatafrm = lavanteUtils.login("UserRoleId14", browser);
		List listofdatafrm = lavanteUtils.login("Discovery", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "PaymentTerm");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * MangeRoles- Add & Edit Payment Terms
	 * 
	 * @author Vidya C
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addEditPaymentTerms() throws Exception {
		Reporter.log("Test Started for addEditPaymentTerms: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String payTerms1 = "AutoSG" + currenttime();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenter", "any");
		dataMap.put("PaymentType", "any");
		dataMap.put("PaymentTerms", payTerms1);
		
		//Add new payment terms and the details
		objPaymentTermPage.addNewPaymentTerms(dataMap);

		boolean flag = false;
		boolean flag2 = false;
		String payCntr1 = dataMap.get("PaymentCenter");
		String payType1 = dataMap.get("PaymentType");
		String actualPaymentCntr, actualPaymentType, actualPaymentTerms;
		int noRecords = objPaymentTermPage.ListPaymentCntrName.size();
		for (int i = 0; i < noRecords; i++) {
			lavanteUtils.waitForTime(5000);
			actualPaymentCntr = objPaymentTermPage.ListPaymentCntrName.get(i).getText();
			actualPaymentType = objPaymentTermPage.ListPaymentType.get(i).getText();
			actualPaymentTerms = objPaymentTermPage.ListPaymentTerms.get(i).getText();
			System.out.println("Actual paymet center " + actualPaymentCntr);
			if (actualPaymentCntr.equals(payCntr1)	&& actualPaymentType.equals(payType1)	&& actualPaymentTerms.equals(payTerms1)) {
				flag = true;
				Reporter.log("Payment Center name created, Actual: "	+ actualPaymentCntr + " Expected Payment center name "	+ dataMap.get("PaymentCenter"), true);
				Reporter.log("Payment Type created, Actual: "	+ actualPaymentType + " Expected Payment Type "	+ dataMap.get("PaymentType"), true);
				Reporter.log("Payment Terms created, Actual: "	+ actualPaymentTerms + " Expected Payment Terms "	+ dataMap.get("PaymentTerms"), true);

				String payTerms2 = "AutoSG" + currenttime();
				dataMap.put("Save", "");
				dataMap.put("PaymentCenter", "any");
				dataMap.put("PaymentType", "Check");
				dataMap.put("PaymentTerms", payTerms2);

				// Click on edit button and fill the details
				click(objPaymentTermPage.ListEditPaymentTerms.get(i));
				lavanteUtils.switchtoFrame(null);
				
				objPaymentTermPage.fillPaymentTerms(dataMap);
				objPaymentTermPage.formAction(dataMap);
				String payCntr2 = dataMap.get("PaymentCenter");
				String payType2 = dataMap.get("PaymentType");
				lavanteUtils.waitForTime(3000);

				for (int ji = 0; ji < noRecords; ji++) {
					actualPaymentCntr = objPaymentTermPage.ListPaymentCntrName.get(ji).getText();
					actualPaymentType = objPaymentTermPage.ListPaymentType	.get(ji).getText();
					actualPaymentTerms = objPaymentTermPage.ListPaymentTerms.get(ji).getText();
					if (actualPaymentCntr.equals(payCntr2)	&& actualPaymentType.contains(payType2)) {
						flag2 = true;
						Reporter.log(		"Payment center name edited "		+ actualPaymentCntr		+ " Expected payment center name "+ dataMap.get("PaymentCenter"), true);
						Reporter.log("Payment Type edited " + actualPaymentType		+ " Expected Payment Type "		+ dataMap.get("PaymentType"), true);
						Reporter.log(	"Payment Terms edited, Actual: "		+ actualPaymentTerms		+ " Expected Payment Terms "		+ dataMap.get("PaymentTerms"), true);
						paymentName = payCntr2;
					}
				}

			}
		}

		softAssert.assertTrue(flag, "Payment Terms created doesn't match");
		softAssert.assertTrue(flag2, "Payment Terms edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * MangeRoles- Add & Delete Payment Terms
	 * 
	 * @author Piramanayagam.S
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addDeletePaymentTerms() throws Exception {
		Reporter.log("Test Started for addEditPaymentTerms: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		String payTerms1 = "AutoSG" + currenttime();
		dataMap.put("Save", "");
		dataMap.put("PaymentCenter", "any");
		dataMap.put("PaymentType", "any");
		dataMap.put("PaymentTerms", payTerms1);
		objPaymentTermPage.addNewPaymentTerms(dataMap);

		boolean flag = false;
		boolean flagdelete = false;
		String payCntr1 = dataMap.get("PaymentCenter");
		String payType1 = dataMap.get("PaymentType");
		String actualPaymentCntr, actualPaymentType, actualPaymentTerms;
		int noRecords = objPaymentTermPage.ListPaymentCntrName.size();
		outr:for (int i = 0; i < noRecords; i++) {
			lavanteUtils.waitForTime(5000);
			actualPaymentCntr = objPaymentTermPage.ListPaymentCntrName.get(i).getText();
			actualPaymentType = objPaymentTermPage.ListPaymentType.get(i).getText();
			actualPaymentTerms = objPaymentTermPage.ListPaymentTerms.get(i).getText();
			if (actualPaymentCntr.equals(payCntr1)	&& actualPaymentType.equals(payType1)&&actualPaymentTerms.equals(payTerms1)) {
				flag = true;
				Reporter.log("Payment Center name created, Actual: "+ actualPaymentCntr + " Expected Payment center name "		+ dataMap.get("PaymentCenter"), true);
				Reporter.log("Payment Type created, Actual: "+ actualPaymentType + " Expected Payment Type "		+ dataMap.get("PaymentType"), true);
				Reporter.log("Payment Terms created, Actual: "+ actualPaymentTerms + " Expected Payment Terms "		+ dataMap.get("PaymentTerms"), true);
				paymentName=payTerms1;
				// Click on delete button and fill the details
				click(objPaymentTermPage.ListDeletePaymentTerms.get(i));
				lavanteUtils.switchtoFrame(null);
				//fluentwait(objDivisionPage.DeleteBtn());
				click(objDivisionPage.DeleteBtn());
				
				lavanteUtils.waitForTime(4000);
				lavanteUtils.fluentwait(objPaymentTermPage.AddPaymentTerms());
				
				String query="select ut.UTFString from PaymentTerms pt, UserTranslation ut where pt.PaymentName_i18nKey=ut.i18nKey and ut.UTFString='"+actualPaymentTerms+"' and pt.CustomerID="+customerID;
				query=lavanteUtils.fetchDBdata(query);
                if(query == null){
                	flagdelete=true;
                	paymentName="";
                }
                break outr;
                
			}
		}

		softAssert.assertTrue(flag, "Payment Terms created doesn't match");
		softAssert.assertTrue(flagdelete, "Payment Terms Deleted doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * MangeRoles- DuplicatePaymentTerms
	 * 
	 * @author Piramanayagam.S
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void DuplicatePaymentTerms() throws Exception {
		Reporter.log("Test Started for addEditPaymentTerms: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		boolean flag = false;
		int noRecords = objPaymentTermPage.ListPaymentCntrName.size();
		outr:for (int i = 0; i < noRecords; i++) {
			String actualPaymentCntr = objPaymentTermPage.ListPaymentCntrName.get(i).getText();
			String actualPaymentType = objPaymentTermPage.ListPaymentType.get(i).getText();
			String actualPaymentTerms = objPaymentTermPage.ListPaymentTerms.get(i).getText();

			
			dataMap.put("Save", "");
			dataMap.put("PaymentCenter", actualPaymentCntr);
			dataMap.put("PaymentType", actualPaymentType);
			dataMap.put("PaymentTerms", actualPaymentTerms);

			break outr;
		}
		objPaymentTermPage.addNewPaymentTerms(dataMap);
		
		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(objPaymentTermPage.IframePaymentTerms);
		if (lavanteUtils.isElementDisplayed(objPaymentTermPage.Errormsg())) {
			softAssert.assertTrue(objPaymentTermPage.Errormsg().getText().trim().contains("is already associated with Payment Type"),"Error msg not matched");
			Reporter.log("Actual error message: " + objPaymentTermPage.Errormsg().getText().trim() + ". Expected error messgae: " + "is already associated with Payment Type" ,true);
			flag=true;
		} 

		softAssert.assertTrue(flag, "Payment Terms Duplicate failed");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException,		SQLException {
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		if(paymentName.length()>0){
			String query="select PaymentName_i18nKey From PaymentTerms where CustomerID="+customerID+" and PaymentName='"+paymentName+"'";
			String iquery=lavanteUtils.fetchDBdata(query);
			query="delete from PaymentTerms where CustomerID="+customerID+" and PaymentName='"+paymentName+"'";
			lavanteUtils.UpdateDB(query);
			query="delete From UserTranslation where i18nkey='"+iquery+"'";
			lavanteUtils.UpdateDB(query);
			query="delete From  i18nkey where i18nkey='"+iquery+"'";
			lavanteUtils.UpdateDB(query);
		}
		
		
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
