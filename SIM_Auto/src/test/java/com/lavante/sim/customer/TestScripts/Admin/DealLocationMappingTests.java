package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class DealLocationMappingTests extends PageInitiator {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	String div="";
	String warehouse="";
	String CustomerID="";
	String dealLocation ="";

	/**
	 * This class all test starts using login page and driver initialization
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
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		CustomerID=(String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		

	}
	
	@BeforeMethod()
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException{
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab","Admin");
		LdataMap.put("subtab","dealLocation");
		enobjhomePage.selectTab(LdataMap);
		lavanteUtils.waitForTime(3000);
		
	/*	warehouse="Select MAX(OrganizationName) from CustomerOrganization where CustomerId="+CustomerID;
		warehouse=lavanteUtils.fetchDBdata(warehouse);
		
		div="Select MAX(OrganizationName) from CustomerOrganization where  OrganizationName not in ('"+warehouse+"') and CustomerId="+CustomerID;
		div=lavanteUtils.fetchDBdata(div);*/
		
		div="select MAX(u.UTFSTring) From UserTranslation u,CustomerOrganization co where u.I18nkey=co.OrganizationName_i18nKey "
				+ " and  u.LanguageID=50 and co.CustomerID="+CustomerID+" and co.isActive=1";
		div=lavanteUtils.fetchDBdata(div);
		
		warehouse =	"select MAX(u.UTFSTring) From UserTranslation u,CustomerOrganization co where u.I18nkey=co.OrganizationName_i18nKey "
				+ " and  u.LanguageID=50 and co.CustomerID="+CustomerID+" and co.isActive=1 and u.UTFSTring not in ('"+div+"')";
		warehouse=lavanteUtils.fetchDBdata(warehouse);
		
		String org="select MAX(co.CustomerOrganizationNumber) From UserTranslation u,CustomerOrganization co where u.I18nkey=co.OrganizationName_i18nKey "
				+ " and  u.LanguageID=50 and co.CustomerID="+CustomerID+" and co.isActive=1 and u.UTFSTring='"+div+"'";
		org=lavanteUtils.fetchDBdata(org);
		div=div+"-"+org;
	}
		
		
	/**
	 * ManageUsers- Add deal location mapping
	 * 
	 * @author Thejaswi
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addDealLocationMapping() throws Exception {
		Reporter.log("Test Started for addDealLocationMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		dealLocation="Auto"+currenttime();
		
		dataMap.put("AddNew","");
		dataMap.put("Division", div);
		dataMap.put("Warehouse", warehouse);
		dataMap.put("DealLocation", dealLocation);
		
		//adding deal location mapping
		
		objDealLocation.AddDealLocationMapping(dataMap);
		dataMap.remove("AddNew");
		
		//searching newly added deal location mapping
		dataMap.put("dealLocation", dealLocation );
		objDealLocation.searchDealLocationMapping(dataMap);
		
		boolean flagAdd = false;
		boolean flagEdit = false; 
		String actualDealLocation ="";
		String actualWarehouse= "";
		String actualDivision = "";
		
		int noRecords = objDealLocation.ListDivisionName.size();
		
		int k=0;
		while(flagAdd==false&& k<50){
				
		lavanteUtils.waitForTime(5000);		
			outr: for (int i = 0; i <noRecords ; i++) {
				actualDealLocation = objDealLocation.ListDealLocationName.get(i).getText();
				actualWarehouse=objDealLocation.ListWareHouseName.get(i).getText();
				actualDivision = objDealLocation.ListDivisionName.get(i).getText();
				
				// verifying deal location mapping 
				if (actualWarehouse.equals(warehouse) && actualDivision.contains(div)) {
					flagAdd = true;
					Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
					Reporter.log("Warehouse created " + actualWarehouse  + " Expected Warehouse name " + dataMap.get("Warehouse"),true);
					
					//edit deal location mapping
					click(objDealLocation.ListEditDealLocationMapping.get(i));

					dataMap.clear();
					dataMap.put("EditSave", "");
					dealLocation=dealLocation+"theas";
					dataMap.put("DealLocation", dealLocation);
					objDealLocation.fillDealLocationMapping(dataMap);
					objDealLocation.formAction(dataMap);
					lavanteUtils.waitForTime(5000);

					dataMap.put("dealLocation", dealLocation);
					objDealLocation.searchDealLocationMapping(dataMap);
					
					//verify edit
					int ek=0;
					while(flagEdit==false&& ek<50){
					for ( i = 0; i < noRecords; i++) {
							
							actualDivision = objDealLocation.ListDivisionName.get(i).getText();
							actualWarehouse = objDealLocation.ListWareHouseName.get(i).getText();
							actualDealLocation= objDealLocation.ListDealLocationName.get(i).getText();
							if (actualDealLocation.equals(actualDealLocation) && actualDealLocation.contains(dealLocation)) {
								Reporter.log("Deal Location name edited " + actualDealLocation + " Expected Deal Location " + dealLocation,true);
								Reporter.log("Division name edited " + actualDivision + " Expected Division name " + div,true);
								flagEdit = true;
								break outr;
							}
					}
					if(flagEdit==false){
						ek++;
						boolean flag=enobjhomePage.Pagination("Next");
						if(flag==false){
							ek=50001;
						}
					}
					
					}
				}
			}
			
			if(flagAdd==false){
					k++;
					boolean flag=enobjhomePage.Pagination("Next");
					if(flag==false){
						k=50001;
					}
			}
			
		}
				
		softAssert.assertTrue(flagAdd, "Deal Location name created doesn't match");
		softAssert.assertTrue(flagEdit, "Deal Location name edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/** 
	 * @author Priyanka
	 * 
	 * Test to verify addition and deletion of DealLocationMapping
	 * @throws Exception 
	 * 
	 */
	  @Test
	  public void addDeleteDealLocationMapping() throws Exception{
		    Reporter.log("Test Started for creation of dealLocationMapping and deletion of dealLocationMapping: "+ currenttime(),true);
		    SoftAssert softassert =new SoftAssert();
		    
		    LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
			
			dealLocation="Auto"+currenttime();
			
			dataMap.put("AddNew","");
			dataMap.put("Division", div);
			dataMap.put("Warehouse", warehouse);
			dataMap.put("DealLocation", dealLocation);
			
			//adding deal location mapping
			
			objDealLocation.AddDealLocationMapping(dataMap);
			dataMap.remove("AddNew");
			
			//searching newly added deal location mapping
			dataMap.put("dealLocation", dealLocation );
			objDealLocation.searchDealLocationMapping(dataMap);
			

			boolean flagAdd = false;
			boolean flagDelete = false; 
			String actualDealLocation ="";
			String actualWarehouse= "";
			String actualDivision = "";
			
			int noRecords = objDealLocation.ListDivisionName.size();
			
			int k=0;
			while(flagAdd==false&& k<50){
					
			lavanteUtils.waitForTime(5000);		
				outr: for (int i = 0; i <noRecords ; i++) {
					actualDealLocation = objDealLocation.ListDealLocationName.get(i).getText();
					actualWarehouse=objDealLocation.ListWareHouseName.get(i).getText();
					actualDivision = objDealLocation.ListDivisionName.get(i).getText();
					
					// verifying deal location mapping 
					if (actualWarehouse.equals(warehouse) && actualDivision.contains(div)) {
						
						Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
						Reporter.log("Warehouse created " + actualWarehouse  + " Expected Warehouse name " + dataMap.get("Warehouse"),true);
						flagAdd = true;
						
						lavanteUtils.waitForTime(5000);
						click(objDealLocation.ListDeleteDealLocationMapping.get(i));
						click(objDealLocation.DeleteLink());
						fluentwait(objDealLocation.DeleteBtn());
						click(objDealLocation.DeleteBtn());
						
						String query= "select DealLocation from Division_Warehouse_Deal_Location_Map where DealLocation like '"+dealLocation+"'";
						
						query=lavanteUtils.fetchDBdata(query);
		                if(query == null){
		                	flagDelete=true;
		                }
		                break outr;

					}
				}
			
			softassert.assertTrue(flagAdd, "Deal Location name is not created..!");
			softassert.assertTrue(flagDelete,"Deal Location name is not deleted. Please recheck..!");
			softassert.assertAll();
			Reporter.log("Test Ended for addDeleteDealLocationMapping at:" + currenttime());
			
			}
	  }
	
	
	  
		/**
		 *@author Priyanka
		 * 
		 * Test to verify duplicate of Deal Location Mapping 
		 */
		@Test
		public void duplicateDealLocationMapping (){
			Reporter.log("Test Started for duplicateDealLocationMapping: " + currenttime());
			SoftAssert softAssert = new SoftAssert();
			boolean dataFlag = false;
			boolean flagDuplicate = false;
			LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
			
			if (objDealLocation.ListDealLocationName.size() > 0) {
				String deallocationName = objDealLocation.ListDealLocationName.get(0).getText().trim();
				String divisionName = objDealLocation.ListDivisionName.get(0).getText().trim();
				String warehousename = objDealLocation.ListWareHouseName.get(0).getText().trim();
				
				dataMap.put("AddNew","");
				dataMap.put("Division", divisionName);
				dataMap.put("Warehouse", warehousename);
				dataMap.put("DealLocation", deallocationName);
				objDealLocation.AddDealLocationMapping(dataMap);
				
				lavanteUtils.waitForTime(4000);
				click(objDealLocation.Bannerclose());
				if (objDealLocation.Errormsg().isDisplayed()) {
					String exp = "The mapping already exists";
					 
					  String actual= objDealLocation.Errormsg().getText().trim();
					  softAssert.assertTrue(actual.contains(exp),"Error Msg Not matched".trim());
					  Reporter.log("Error message:"+exp+",Actual:"+actual, true);
					  flagDuplicate=true;
				} 
				dataFlag = true;
			} 
			
			softAssert.assertTrue(flagDuplicate, "Please recheck the test..!");
			softAssert.assertTrue(dataFlag,"No data available. Please retest after adding atleast one entry.");
			softAssert.assertAll();
			Reporter.log("Test Ended at:" + currenttime());
		}
		
		 /** 
		 * @author Priyanka
		 * 
		 * Test to verify associate of Deal Location
		 *
		 */
	 // @Test [JIRA Raised]
	  public void deleteAssociatedDealLocationMapping(){
		  
		  Reporter.log("Test Started for delete Associated DealLocation Mapping: "+ currenttime(),true);
		  SoftAssert softassert =new SoftAssert();
		  
	  }
		
		
		/**
	     * @author Priyanka
	     * 
	     * Test to verify Interrelation Deallocation Mapping 
	     * 
	     */
		//@Test [Discussed with Lakshmi, there is no scenario such as]
		public void interRelationDeallocationMapping(){
			
			Reporter.log("Test Started for interRelationDeallocationMapping: "+ currenttime());
			SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
			boolean flagAdd = false;
			boolean flag= false;
			
			String actualDeallocation;
			div="MICHIGAN KMA-018";
			warehouse="NEVADA CONSOLIDATION CENTER-031";
			
			dataMap.put("AddNew","");
			dataMap.put("Division", div);
			dataMap.put("Warehouse", warehouse);
			dataMap.put("DealLocation", dealLocation);
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(objDealLocation.AddDealLocationMapping());
			int noRecords = objDealLocation.ListDealLocationName.size();
			outr: for (int i = 0; i < noRecords; i++) {
				actualDeallocation = objDealLocation.ListDivisionName.get(i).getText().trim();
				if (actualDeallocation.equalsIgnoreCase(dealLocation.trim())) {
					
					flagAdd = true;
					Reporter.log("Division name created " + actualDeallocation + "Expected Division name " + dealLocation,true);
					
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
				for (int i = 0; i < el.size(); i++) {
					String divisionMapdata = el.get(i).getText().trim();
					if (dealLocation.equalsIgnoreCase(divisionMapdata)) {
						Reporter.log("Division name availabe to select is: " + divisionMapdata + ", Expected Division name : "+ dealLocation, true);
						flag = true;
						dealLocation=divisionMapdata;
						break;
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
		lavanteUtils.refreshPage();
		
		if(dealLocation.length()>0){
			String x="delete From Division_Warehouse_Deal_Location_Map where DealLocation='"+dealLocation+"'";
			lavanteUtils.UpdateDB(x);
		}
	}
	
	@AfterClass
	public void quitApp() {
		enobjhomePage.logout();
		quitBrowser();
	}
}

		
	
		
