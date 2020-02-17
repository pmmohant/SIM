package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

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

public class ClaimType extends PageInitiator {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	String expClaimtype="";

	/**
	 * This class starts using login page and driver initialization
	 * 
	 * @author Ramya
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
		List<?> listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
    }
	
	@BeforeMethod()
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException{
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab","Admin");
		LdataMap.put("subtab","manageClaimType");
		enobjhomePage.selectTab(LdataMap);
		lavanteUtils.waitForTime(3000);
	}

	/**
	 *Test to verify Add Edit claim type
	 * 
	 * @author Piramanayagam.S
	 * 
	 * 
	 */
	@Test
	public void addeditClaimType() throws Exception {
		Reporter.log("Test Started for addEditClaimType: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	
		expClaimtype ="AutoTest1"+randomnum();
		dataMap.put("ClaimType",expClaimtype);
		dataMap.put("Save", "");
		//add claim type
		objClaimTypePage.addClaimType(dataMap);
		
		//search claim type
		dataMap.put("SearchText", expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
	
		//Compare claim type
		String actClaimtype = objClaimTypePage.claimTypeValue().getText();
		Reporter.log("Claim type ,Created:"+expClaimtype+",Actuals:"+actClaimtype,true);
		softAssert.assertEquals(actClaimtype, expClaimtype);
		
		//Delete claim type
		dataMap.put("EditAction", "");
		objClaimTypePage.Actions(dataMap);
		
		expClaimtype ="AutoTest1"+randomnum();
		dataMap.put("ClaimType",expClaimtype);
		objClaimTypePage.fillClaimtype(dataMap);
		objClaimTypePage.formAction(dataMap);
		
		dataMap.put("SearchText",expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
		
		lavanteUtils.waitForTime(4000);
		for(int i=0;i<objClaimTypePage.ListClaimTypeName.size();i++){
			String actClaimType = objClaimTypePage.ListClaimTypeName.get(0).getText();
			Reporter.log("Claim type ,Created:"+expClaimtype+",Actuals:"+actClaimtype,true);
			softAssert.assertEquals(actClaimType, expClaimtype,"Claim Type Not matched");
			
			actClaimType = objClaimTypePage.ListClaimTypeStatus.get(0).getText();
			Reporter.log("Claim Status ,Active,Actuals:"+actClaimtype,true);
			softAssert.assertEquals(actClaimType, "Active","Claim Type Not matched");
			break;
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended  for addEditClaimType :" + currenttime());
	}
	
	/**
	 *Test to verify Add Delete claim type
	 * 
	 * @author Ramya
	 * 
	 * 
	 */
	@Test
	public void addDeleteClaimType() throws Exception {
		Reporter.log("Test Started for addNewClaimType: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	
		expClaimtype ="AutoTest1"+randomnum();
		dataMap.put("ClaimType",expClaimtype);
		dataMap.put("Save", "");
		//add claim type
		objClaimTypePage.addClaimType(dataMap);
		
		//search claim type
		dataMap.put("SearchText", expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
	
		//Compare claim type
		String actClaimtype = objClaimTypePage.claimTypeValue().getText();
		Reporter.log("Claim type ,Created:"+expClaimtype+",Actuals:"+actClaimtype,true);
		softAssert.assertEquals(actClaimtype, expClaimtype);
		
		//Delete claim type
		dataMap.put("DeleteAction", "");
		objClaimTypePage.Actions(dataMap);
		
		//Check whether deletion is successfull
		dataMap.put("SearchText",expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
		
		lavanteUtils.waitForTime(4000);
		String expMessage = "No results";
		String actMessage = objClaimTypePage.noResultsText().getAttribute("innerText");
		softAssert.assertEquals(actMessage, expMessage);
		
		softAssert.assertAll();
		Reporter.log("Test Ended  for addNewClaimType :" + currenttime());
	}

	/**
	 *Test to verify Duplicate claim type
	 * 
	 * @author Piramanayagam.S
	 * 
	 * 
	 */
	@Test
	public void DuplicateClaimType() throws Exception {
		Reporter.log("Test Started for addEditClaimType: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	
		expClaimtype ="AutoTest1"+randomnum();
		dataMap.put("ClaimType",expClaimtype);
		dataMap.put("Save", "");
		//add claim type
		objClaimTypePage.addClaimType(dataMap);
		
		//search claim type
		dataMap.put("SearchText", expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
	
		//Compare claim type
		String actClaimtype = objClaimTypePage.claimTypeValue().getText();
		Reporter.log("Claim type ,Created:"+expClaimtype+",Actuals:"+actClaimtype,true);
		softAssert.assertEquals(actClaimtype, expClaimtype);
		
		objClaimTypePage.addClaimType(dataMap);
		
		lavanteUtils.switchtoFrame(objClaimTypePage.IframeAddClaimType());
		
		
		String err="ClaimType already exists!";
		String actErr=objClaimTypePage.Errrmsg.getText();
		softAssert.assertEquals(actErr, err,"Error message Not matched");
		
		softAssert.assertAll();
		Reporter.log("Test Ended  for Duplicate ClaimTYpe :" + currenttime());
	}

	/**
	 *Test to verify deleteAssociatedClaim
	 * 
	 * @author Piramanayagam.S
	 * 
	 * 
	 */
	@Test
	public void deleteAssociatedClaim() throws Exception {
		Reporter.log("Test Started for deleteAssociatedClaim: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	
		String expClaimtype="select ClaimType from ClaimType where ClaimTypeID in (Select ClaimTypeID from Claim)";
		expClaimtype=lavanteUtils.fetchDBdata(expClaimtype);
		//searc claim type
		dataMap.put("SearchText", expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
	
		//Compare claim type
		
		//Delete claim type
		dataMap.put("DeleteAction", "");
		objClaimTypePage.Actions(dataMap);
		lavanteUtils.waitForTime(4000);
		
		boolean dataflag=false;
		if (lavanteUtils.isElementDisplayed(objClaimTypePage.bannerMsg())) {
			softAssert.assertTrue(objClaimTypePage.bannerMsg().getText().contains("ClaimType cannot be deleted as it is associated with a claim."),"Error Msg Not matched");
			Reporter.log("Error message: "+ objPaymentCenterPage.bannerMsg().getText(), true);
			dataflag = true;
		}
		
		softAssert.assertTrue(dataflag,"Error message Not matched");
		//Should not delete in after method
		expClaimtype="";
		softAssert.assertAll();
		
		Reporter.log("Test Ended  for delete Associated Claim :" + currenttime());
	}

	/**
	 *Test to verify interReleation ClaimType
	 * 
	 * @author Piramanayagam.S
	 * 
	 * 
	 */
	@Test
	public void interReleationClaimType() throws Exception {
		Reporter.log("Test Started for interReleationClaimType: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	
		expClaimtype ="AutoTest1"+randomnum();
		dataMap.put("ClaimType",expClaimtype);
		dataMap.put("Save", "");
		//add claim type
		objClaimTypePage.addClaimType(dataMap);
		
		//search claim type
		dataMap.put("SearchText", expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
	
		//Compare claim type
		String actClaimtype = objClaimTypePage.claimTypeValue().getText();
		Reporter.log("Claim type ,Created:"+expClaimtype+",Actuals:"+actClaimtype,true);
		softAssert.assertEquals(actClaimtype, expClaimtype);
		
		dataMap.put("maintab","TRANSACTIONS");
		dataMap.put("subtab","customerClaimResult");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("ClaimType",expClaimtype);
		enClaimsBasicSearch.fillSearchdetails(dataMap);
		
		String app=enClaimsBasicSearch.claimTypeDropdwntxt().getText();
		Reporter.log("First Record for Single data Expected, Some Value,Actuals:"+app,true);
		softAssert.assertNotEquals(app,"Select","First Record Select Value Not Matched as first record");
		softAssert.assertEquals(app,expClaimtype,"First Record Value Not Matched as first record");
		
		softAssert.assertAll();
		Reporter.log("Test Ended  for interReleationClaimType :" + currenttime());
	}
	

	/**
	 *Test to verify Deactivate ClaimType
	 * 
	 * @author Piramanayagam.S
	 * 
	 * 
	 */
	@Test
	public void DeactivateClaimType() throws Exception {
		Reporter.log("Test Started for DeactivateClaimType: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	
		expClaimtype ="AutoTest1"+randomnum();
		dataMap.put("ClaimType",expClaimtype);
		dataMap.put("Save", "");
		//add claim type
		objClaimTypePage.addClaimType(dataMap);
		
		//search claim type
		dataMap.put("SearchText", expClaimtype);
		objClaimTypePage.searchClaimtype(dataMap);
	
		lavanteUtils.waitForTime(4000);
		//Compare claim type
		String actClaimtype = objClaimTypePage.claimTypeValue().getText();
		Reporter.log("Claim type ,Created:"+expClaimtype+",Actuals:"+actClaimtype,true);
		softAssert.assertEquals(actClaimtype, expClaimtype);
		actClaimtype = objClaimTypePage.ListClaimTypeStatus.get(0).getText();
		Reporter.log("Claim type ,Status:Active,Actuals:"+actClaimtype,true);
		softAssert.assertEquals("Active", actClaimtype,"Initial Status not matched");
		
		//Deactivate claim type
		dataMap.put("Deactivate", "");
		objClaimTypePage.Actions(dataMap);
		
		//Check whether deletion is successfull
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(objClaimTypePage.ListClaimTypeStatus.get(0));
		actClaimtype = objClaimTypePage.ListClaimTypeStatus.get(0).getText();
		Reporter.log("Claim type ,Status:Inactive,Actuals:"+actClaimtype,true);
		softAssert.assertEquals("Inactive", actClaimtype,"After Deactivate, Status Not Matched");
		
		//Deactivate claim type
		dataMap.put("Deactivate", "");
		objClaimTypePage.Actions(dataMap);
		
		//Check whether deletion is successfull
		
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(objClaimTypePage.ListClaimTypeStatus.get(0));
		actClaimtype = objClaimTypePage.ListClaimTypeStatus.get(0).getText();
		Reporter.log("Claim type ,Status:Active,Actuals:"+actClaimtype,true);
		softAssert.assertEquals("Active", actClaimtype,"After Activate ,Status Not Matched");
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended  for DeactivateClaimType :" + currenttime());
	}

	
	@AfterMethod
	public void after() throws FileNotFoundException, IOException, SQLException{
		lavanteUtils.refreshPage();
		if(expClaimtype.length()>0){
			String query="";

			String iquery="select ClaimType_I18nKey from ClaimType where ClaimType='"+expClaimtype+"'";
			iquery=lavanteUtils.fetchDBdata(iquery);

			query="delete from ClaimType where ClaimType='"+expClaimtype+"'";
			lavanteUtils.UpdateDB(query);
			query="delete From UserTranslation where i18nkey='"+iquery+"'";
			lavanteUtils.UpdateDB(query);
			query="delete From  i18nkey where i18nkey='"+iquery+"'";
			lavanteUtils.UpdateDB(query);
			
		}
	}
	
	  @AfterClass
	 public void close(){
		   enobjhomePage.logout();
	       quitBrowser();
		}
  
}


		
	
		
