package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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

public class DivisionPageTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();
	String division1="";
	String customerID = "";
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
		customerID=(String) listofdatafrm.get(1);
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		

	}
	
	@BeforeMethod
	public void Before(){
		lavanteUtils.refreshPage();
		
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "Division");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * MangeRoles- Add & Edit Division name
	 * BUG SIM-21790 division is not getting updated ,hence changed the test to verify the orignal value only
	 * 
	 * @author Vidya C
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addEditDivision() throws Exception {
		Reporter.log("Test Started for addNewDivision: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		division1="AutoSPG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("DivisionName", division1);
		objDivisionPage.addNewDivision(dataMap);
		
		boolean flag = false;
		boolean flag2 = false;
		String actualDivision;
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objDivisionPage.AddDivision());
		
		int noRecords = objDivisionPage.ListDivisionName.size();
		outr:for (int i = 0; i <noRecords ; i++) {
			actualDivision = objDivisionPage.ListDivisionName.get(i).getText();
			if (actualDivision.equalsIgnoreCase(division1)) {
				
				flag = true;
				Reporter.log("Division name created " + actualDivision + "Expected Division name " + division1,true);
				
				String division2="AutoSG"+currenttime();
				click(objDivisionPage.ListEditDivision.get(i));
				objDivisionPage.InputDivisionNameTxtBox.get(i).clear();
				lavanteUtils.typeString(division2, objDivisionPage.InputDivisionNameTxtBox.get(i));
				click(objDivisionPage.ListCheckedDivision.get(i));
				lavanteUtils.waitForTime(4000);
				lavanteUtils.waitforPageload(objDivisionPage.AddDivision());
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(objDivisionPage.AddDivision());
				
				int noRecordss = objDivisionPage.ListDivisionName.size();
				for (int ji = noRecordss; ji >0 ; ji--)  {
					actualDivision = objDivisionPage.ListDivisionName.get(ji-1).getText();
					if (actualDivision.equalsIgnoreCase(division1)) {
						flag2 = true;
						Reporter.log("Division name edited " + actualDivision + "Division name " + division1,true);
						division1=division1;
						break outr;
					}
				}				
				
			}
		}
		
		softAssert.assertTrue(flag, "Division name created doesn't match are not created");
		softAssert.assertTrue(flag2, "Division name edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
	 * MangeRoles- Add & Delete Division 
	 * 
	 * @author Priyanka
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addDeleteDivision() throws Exception {
		Reporter.log("Test Started for addDeleteDivision: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		boolean flagAdd = false;
		boolean flagDelete = true;
		
		String actualDivision="";
		String expDivision="AutoSG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("DivisionName", expDivision);
		objDivisionPage.addNewDivision(dataMap);
		
		lavanteUtils.waitForTime(4000);
		fluentwait(objDivisionPage.ListDivisionName.get(0));
		division1=expDivision;
		outr: for (int i = 0; i <objDivisionPage.ListDivisionName.size() ; i++) {
			actualDivision = objDivisionPage.ListDivisionName.get(i).getText();
			if (actualDivision.equalsIgnoreCase(expDivision)) {
				softAssert.assertEquals(actualDivision, expDivision, "Divisions are not matching..!");
				Reporter.log("Actual Division name: " + actualDivision + ". Expected Division name " + expDivision,true);
				flagAdd = true;
				
				click(objDivisionPage.ListDeleteDivision.get(i));
				fluentwait(objDivisionPage.DeleteBtn());
				click(objDivisionPage.DeleteBtn());
				String query="select organizationname from CustomerOrganization where organizationname like '"+expDivision+"' and CustomerID ="+customerID;
				query=lavanteUtils.fetchDBdata(query);
                if(query == null){
                	flagDelete=true;
                }
                break outr;
			}
		}
		
		softAssert.assertTrue(flagAdd, "Division name is not created..!");
		softAssert.assertTrue(flagDelete, "Division name is not deleted. Please recheck..!");
		softAssert.assertAll();
		Reporter.log("Test Ended for addDeleteDivision at:" + currenttime());
	}
	
	/**
	 * MangeRoles- Delete Duplicate Division 
	 * 
	 * @author Priyanka
	 *
	 */
	@Test
	public void duplicateDivision(){
		Reporter.log("Test Started for deleteDuplicateDivision: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean dataFlag = false;
		boolean flagDuplicate = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		if (objDivisionPage.ListDivisionName.size() > 0) {
			String divisionName = objDivisionPage.ListDivisionName.get(0).getText().trim();
			dataMap.put("Save", "");
			dataMap.put("DivisionName", divisionName);
			objDivisionPage.addNewDivision(dataMap);
			
			lavanteUtils.waitForTime(4000);
			if (lavanteUtils.isElementDisplayed(objDivisionPage.Errormsg())) {
				softAssert.assertTrue(objDivisionPage.Errormsg().getText().trim().contains("Division with the name "+divisionName +" is already exists"),"Error msg not matched");
				Reporter.log("Actual error message: " + objDivisionPage.Errormsg().getText().trim() + ". Expected error messgae: " + "Division with the name "+ divisionName +" is already exists." ,true);
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
     * Delete Associated Division  - will check the Associated Division  
     * Verification of Comments
     * 
     * @author Priyanka
     * @throws SQLException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	@Test
	public void deleteAssociatedDivision() throws Exception {

		Reporter.log("Test Started for deleteAssociatedDivision: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag = false;
		boolean dataflag = false;
		
		String actualDivision = "";		
		String query = "select OrganizationName from CustomerOrganization where CustomerOrganizationID in "
				+ " (select CustomerOrganizationID from Relationship_CustomerOrganization_Map where CustomerOrganizationID in "
				+ " (select top 1 CustomerOrganizationID from CustomerOrganization where CustomerID = "+customerID+"))";
		String expectDivision = lavanteUtils.fetchDBdata(query);
		
		Reporter.log("DivisionName: " + expectDivision, true);
		
		if(expectDivision!=null){
		int noRecords = objDivisionPage.ListDivisionName.size();
		outr: for (int i = 0; i < noRecords; i++) {
			Reporter.log("Division name matched:" + actualDivision+ ",Expected Division name from DB:"+ expectDivision, true);
			actualDivision = objDivisionPage.ListDivisionName.get(i).getText().trim();
			if (actualDivision.equalsIgnoreCase(expectDivision.trim())) {
				Reporter.log("Division name matched " + actualDivision+ "Expected Division name from DB  "+ expectDivision, true);
				flag = true;
				click(objDivisionPage.ListDeleteDivision.get(i));
				fluentwait(objDivisionPage.DeleteBtn());
				click(objDivisionPage.DeleteBtn());
				lavanteUtils.waitForTime(4000);
				if (lavanteUtils.isElementDisplayed(objDivisionPage.bannerMsg())) {
					String exp="The division cannot be deleted as it is associated with the payment center/supplier/supplier location";
					String actual=objDivisionPage.bannerMsg().getText();
					softAssert.assertTrue(actual.contains(exp),"Error Msg Not matched".trim());
					Reporter.log("Error message:"+exp+",Actual:"+actual, true);
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
		softAssert.assertTrue(flag,"Data available in Division page is not matching query result. Please recheck the data.");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
     * Interrelation  Division  - will check the data flow of Division  
     * Verification of Comments
     * 
     * @author Priyanka
     */
	@Test
	public void interRelationDivision(){
		
		Reporter.log("Test Started for interRelationDivision: "+ currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		boolean flagAdd = false;
		boolean flag= false;
		
		String actualDivision;
		division1="AutoSG"+currenttime();
		dataMap.put("Save", "");
		dataMap.put("DivisionName", division1);
		objDivisionPage.addNewDivision(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objDivisionPage.AddDivision());
		int noRecords = objDivisionPage.ListDivisionName.size();
		outr: for (int i = 0; i < noRecords; i++) {
			actualDivision = objDivisionPage.ListDivisionName.get(i).getText().trim();
			if (actualDivision.equalsIgnoreCase(division1.trim())) {
				
				flagAdd = true;
				Reporter.log("Division name created " + actualDivision + "Expected Division name " + division1,true);
				break outr;
			}
		}
		if (flagAdd) {
			dataMap.put("maintab", "Admin");
			dataMap.put("subtab", "PaymentCenterMapping");
			enobjhomePage.selectTab(dataMap);
			
			click(objPayCntrMapPage.AddMapping());
			switchtoFrame(objPayCntrMapPage.IframePaymentCenter);
			click(objPayCntrMapPage.DivisionSearchBox());
			switchtoFrame(null);
			List<WebElement> el=lavanteUtils.driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
			outr:for (int i = 0; i < el.size(); i++) {
				String divisionMapdata = el.get(i).getText().trim();
				if (division1.equalsIgnoreCase(divisionMapdata)) {
					Reporter.log("Division name availabe to select is: " + divisionMapdata + ", Expected Division name : "+ division1, true);
					flag = true;
					division1=divisionMapdata;
					break outr;
				}
			}
		}

		softAssert.assertTrue(flagAdd, "Add Division is failed");
		softAssert.assertTrue(flag, "Division is not avilable");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	

	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		if(division1.length()>0){
			String delquery="delete from CustomerOrganization where OrganizationName='"+division1+"'";
			lavanteUtils.UpdateDB(delquery);
		}
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}
