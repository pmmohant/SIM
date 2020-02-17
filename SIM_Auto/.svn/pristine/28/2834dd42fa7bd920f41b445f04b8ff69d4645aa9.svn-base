package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ManageUsers;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SupplierGroupPageTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	
	String sname = "";
	String customerID="";
	String SuppGrp="";
	
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
		customerID=(String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "buyerSupplierGroup");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * MangeRoles- Add & Edit Supplier group
	 * 
	 * @author Vidya C
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addEditSuppGrp() throws Exception {
		Reporter.log("Test Started for addNewSupplierGroup:" + currenttime());
		String expectedTitle = "PRGX SIM - Supplier Group";
		String actualTitle = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		
		Reporter.log("Actual title is:" + actualTitle + " Expected Title is:" + expectedTitle);
		softAssert.assertEquals(actualTitle, expectedTitle," Navigation failed to manage users page invalid page title:" + actualTitle);

		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		String suppliergrp1="AutoSG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("SupplierGroupName", suppliergrp1);
		objSupplierGroupPage.addNewSupplierGroup(dataMap);
		
		boolean flag = false;
		boolean flag2 = false;
		String actualSupplierGrp;
		int noRecords = objSupplierGroupPage.ListSuppliergroup.size();
		SuppGrp=suppliergrp1;
		
		for (int i = 0; i <noRecords ; i++) {
			actualSupplierGrp = objSupplierGroupPage.ListSuppliergroup.get(i).getText();
			System.out.println("Actual sup group "+actualSupplierGrp);
			if (actualSupplierGrp.equals(suppliergrp1)) {
				flag = true;
				Reporter.log("Supplier group created " + actualSupplierGrp + "Expected supplier group " + dataMap.get("SupplierGroupName"),true);
				
				String suppliergrp2="AutoSG"+currenttime();
				dataMap.put("SupplierGroupName", suppliergrp2);
				click(objSupplierGroupPage.ListEditSuppliergroup.get(i));
				objSupplierGroupPage.fillSuppliergroup(dataMap);
				
				click(objSupplierGroupPage.ListCheckedSuppliergroup.get(0));
				lavanteUtils.waitForTime(5000);
				
				for ( i = 0; i < noRecords; i++) {
					actualSupplierGrp = objSupplierGroupPage.ListSuppliergroup.get(i).getText();
					SuppGrp=suppliergrp2;
					if (actualSupplierGrp.equals(suppliergrp2)) {
						flag2 = true;
						Reporter.log("Supplier group edited " + actualSupplierGrp + " Expected supplier group " + dataMap.get("SupplierGroupName"),true);
						suppliergrp1=suppliergrp2;
					}
				}				
				
			}
		}
		
		softAssert.assertTrue(flag, "Supplier group created doesn't match are not created");
		softAssert.assertTrue(flag2, "Supplier group edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
	 * Manage users  - Add & Delete Supplier group
	 * 
	 * @author Priyanka
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addDeleteSuppGrp() throws Exception {
		
		Reporter.log("Test Started for addDeleteSupplierGroup:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		boolean flagadd = false;
		boolean flagdelete = true;
		
		String expctsuppliergrp="AutoSG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("SupplierGroupName", expctsuppliergrp);
		objSupplierGroupPage.addNewSupplierGroup(dataMap);
		SuppGrp=expctsuppliergrp;
		
		outr: for (int i = 0; i<objSupplierGroupPage.ListSuppliergroup.size(); i++) {
			String actualSupplierGrp = objSupplierGroupPage.ListSuppliergroup.get(i).getText();

			if (actualSupplierGrp.equalsIgnoreCase(expctsuppliergrp)) {
				Reporter.log("Actual Supplier group created: " + actualSupplierGrp + ". Expected Supplier group " + dataMap.get("SupplierGroupName"),true);
				flagadd = true;
				
				click(objSupplierGroupPage.ListDeleteSuppliergroup.get(i));
				fluentwait(objSupplierGroupPage.DeleteBtn());
				click(objSupplierGroupPage.DeleteBtn());
				
				lavanteUtils.waitForTime(4000);
				String query="select CustomerSupplierGroup from CustomerSupplierGroup where CustomerSupplierGroup like '"+expctsuppliergrp+"'";
				query=lavanteUtils.fetchDBdata(query);
                if(query == null){
                      flagdelete=true;
                }
                break outr;
		    }
			
		}
		
		softAssert.assertTrue(flagadd, "Supplier group name is not created..!");
		softAssert.assertTrue(flagdelete, "Supplier group name is not deleted. Please recheck..!");
		softAssert.assertAll();
		Reporter.log("Test Ended for addDeleteSupplierGroup at:" + currenttime());
		
	}
	
	/**
	 * Manage users - Delete Duplicate Supplier group
	 * 
	 * @author Priyanka
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void duplicateSupplierGroup() throws Exception {
		Reporter.log("Test Started for duplicateSupplierGroup: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flagDuplicate = false;
		boolean dataFlag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		if (objSupplierGroupPage.ListSuppliergroup.size() > 0) {
			String suppliergrpname = objSupplierGroupPage.ListSuppliergroup.get(0).getText().trim();
			dataMap.put("Save", "");
			dataMap.put("SupplierGroupName", suppliergrpname);
			objSupplierGroupPage.addNewSupplierGroup(dataMap);

			if (objSupplierGroupPage.Errormsg().isDisplayed()) {
				System.out.println("objSupplierGroupPage.Errormsg().getText(): "+ objSupplierGroupPage.Errormsg().getText());
				softAssert.assertTrue(objSupplierGroupPage.Errormsg().getText().trim().contains("Supplier Group with the name "+ suppliergrpname +" is already exists"),"Error msg not matched");
				Reporter.log("Actual error message: " + objSupplierGroupPage.Errormsg().getText().trim() + ". Expected error messgae: " + "Supplier Group with the name "+ suppliergrpname +" is already exists" ,true);
				flagDuplicate = true;
			} 
			
			dataFlag = true;
		} 
		
		softAssert.assertTrue(flagDuplicate, "Please recheck the test..!");
		softAssert.assertTrue(dataFlag,"No data available. Please retest after adding atleast one entry.");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
	 * Manage users - Delete Associated Supplier group
	 * 
	 * @author Priyanka
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void deleteAssociateSuppGrp() throws Exception {
			Reporter.log("Test Started for Delete Associate Supplier Group:" + currenttime());
			SoftAssert softAssert = new SoftAssert();
			boolean flag = false;
			boolean dataflag = false;
			
			String actualSupplierGrp = "";		
			String query = "select CustomerSupplierGroup from CustomerSupplierGroup where CustomerID = "+ customerID +"and CustomerSupplierGroupID in (select distinct CustomerSupplierGroupID from Relationship)";
			String expctSupplierGrp = lavanteUtils.fetchDBdata(query);
			Reporter.log("SupplierGroupName : " + expctSupplierGrp, true);
			
			if(query!=null){
				outr: for (int i = 0; i < objSupplierGroupPage.ListSuppliergroup.size(); i++) {
				actualSupplierGrp = objSupplierGroupPage.ListSuppliergroup.get(i).getText();
				if (actualSupplierGrp.equalsIgnoreCase(expctSupplierGrp)) {
					Reporter.log("Payment Center name matched " + actualSupplierGrp+ "Expected Payment center name from DB  "+ expctSupplierGrp, true);
					flag = true;
					
					click(objSupplierGroupPage.ListDeleteSuppliergroup.get(i));
					fluentwait(objSupplierGroupPage.DeleteBtn());
					click(objSupplierGroupPage.DeleteBtn());
					
					if (lavanteUtils.isElementDisplayed(objSupplierGroupPage.bannerMsg())) {
						softAssert.assertTrue(objSupplierGroupPage.bannerMsg().getText().contains("The Supplier Group cannot be deleted as it is already associated with the supplier."),"Error Msg Not matched");
						Reporter.log("Actual Banner  message: "+ objSupplierGroupPage.bannerMsg().getText()+ ",Expected Bananer message: " + "The Supplier Group cannot be deleted as it is already associated with the supplier.", true);
						break outr;
					}
				}
			}
			dataflag = true;
		} 
			softAssert.assertTrue(dataflag,"No data available in DB. Please add data and re-run the test.");
			softAssert.assertTrue(flag,"Data available in supplier group page is not matching query result. Please recheck the data.");
			softAssert.assertAll();
			Reporter.log("Test Ended at:" + currenttime());
	}
		
		/**
		 *Manage users - Interrelated  Supplier group
		 * Verification of Comments
		 * @author Priyanka
		 * @throws Exception 
		 *
		 */
	@Test
	public void interRelationSuppGrp() throws Exception{
		
			Reporter.log("Test Started for interRelationPaymentCenter: "+ currenttime());
			SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
			boolean flagAdd = false;
			boolean flag = false;
			
			String actualSupplierGrp="";
			String expSupplierGrp="AutoSG"+currenttime();
			dataMap.put("Save", "");
			dataMap.put("SupplierGroupName", expSupplierGrp);
			objSupplierGroupPage.addNewSupplierGroup(dataMap);
			SuppGrp=expSupplierGrp;
			
			lavanteUtils.waitForTime(4000);
			lavanteUtils.waitforPageload(objSupplierGroupPage.AddSuppliergroup());
			
			outr: for (int i = 0; i < objSupplierGroupPage.ListSuppliergroup.size(); i++) {
				actualSupplierGrp = objSupplierGroupPage.ListSuppliergroup.get(i).getText();
				if (actualSupplierGrp.equalsIgnoreCase(expSupplierGrp)) {
					Reporter.log("Supplier Group name created:" + actualSupplierGrp + ",Expected Supplier Group name:" + expSupplierGrp, true);
					flagAdd = true;
					break outr;
				}
			}
			if (flagAdd) {
				dataMap.put("maintab", "Supplier");
				enobjhomePage.selectTab(dataMap);
				click(enobjsupplierBasicSearch.SupplierGrpDrpDown());
				
				List<String> x=lavanteUtils.listelement(null);
				
				if(x.contains(expSupplierGrp)){
					Reporter.log("Actual Supplier Group name availabe to select is: " + x + " Expected Supplier Group name :"+ expSupplierGrp, true);
					flag = true;
				}
				
			}
			
			softAssert.assertTrue(flagAdd, "Add Supplier Group is failed");
			softAssert.assertTrue(flag, "Supplier Group is not avilable in Supplier Search Page");
			
			softAssert.assertAll();
			Reporter.log("Test Ended at:" + currenttime());
		}
	
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		if(SuppGrp.length()>0){
			String query="";

			String iquery="select i18nKey_CustomerSupplierGroup from CustomerSupplierGroup where CustomerSupplierGroup='"+SuppGrp+"'";
			iquery=lavanteUtils.fetchDBdata(iquery);

			query="delete from CustomerSupplierGroup where CustomerSupplierGroup='"+SuppGrp+"'";
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
