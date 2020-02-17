package com.lavante.recovery.TestScripts.UAT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;
/** 
 * @author Nagappa
 * Test script class for Phone Extension tab
 * 
 */
public class Config_PhoneExtension extends pageInitiator{
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	String phoneComment="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();
		lavanteUtils.driver=driver;
		loginPage.login();
		waitForTime(3000);
		homePage.SelectAudit("ANY");
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","configuration");
		dataMap.put("subtab","otherConfiguration");
		homePage.selectTab(dataMap);
	
		lavanteUtils.click(configurationOthersPage.phoneExtensionTab());
	 }
	
	
	/**
	 * This method is for Adding and editing of the newly added Phone Extension 
	 * @author nagappa.vaddebail
	 * 
	 */
	
	@Test
	public void addEditPhoneExtension()
	{
		 Reporter.log("Test Started for adding and Phone Extension: " + LavanteUtils.currenttime());
		 SoftAssert softAssert = new SoftAssert();
		 //Adding new fax comment
		 String userName = "*AaName1"+currenttime();
		 String dID = "8"+currenttime();
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		 dataMap.put("UserName", userName);
		 dataMap.put("DID", dID);
		 dataMap.put("Save", "");
		 //dataMap.put("Cancel", "");
		 Reporter.log("Adding new phone Extension");
		 configurationOthersPage.addPhoneExtension(dataMap);
		 
		 boolean flagAdd=false;
		 boolean flagEdit=false;
	
		 System.out.println("Adding new phone Extension" + " size: " +  configurationOthersPage.userName().size());
		 
		 for(int i=0; i < configurationOthersPage.userName().size(); i++)
		 {
			 String actUserName = configurationOthersPage.userName().get(i).getText().trim();
			 String actDID = configurationOthersPage.DID().get(i).getText().trim();
			 
			 System.out.println("Expected: " + userName + " , Actual: " + actUserName);
			 if(userName.equalsIgnoreCase(actUserName) ) //&& dID.equalsIgnoreCase(actDID))
			 {	
		 
				 softAssert.assertEquals(actUserName, userName);
				 Reporter.log("Expected user name: " + userName + "Actual user name: " + actUserName);
				 softAssert.assertEquals(actDID, dID);
				 Reporter.log("Expected DID: " + dID + "Actual DID: " + actDID);
				 Reporter.log("New Phone Extension added successfully..!");
				 flagAdd=true;
				 //changing the name for edit action
				 userName = "*AaName1Edit"+currenttime();
				 dID = "9"+currenttime();
				 dataMap.put("UserName", userName);
				 dataMap.put("DID", dID);
				 phoneComment=userName;
				
				 lavanteUtils.click(configurationOthersPage.editPhone().get(i));
				 lavanteUtils.switchtoFrame(configurationOthersPage.IFRAMEaddNewFramePhone());
				 configurationOthersPage.fillPhoneExtension(dataMap);
				 configurationOthersPage.formPhoneExtension(dataMap);
				 
				 System.out.println("Entering validation loop..!" + "size: " + configurationOthersPage.userName().size());
				 lavanteUtils.waitForTime(4000);
				 for(i=0; i < configurationOthersPage.userName().size(); i++)
				 {
					 String actEditUserName = configurationOthersPage.userName().get(i).getText().trim();
					 String actEditDID = configurationOthersPage.DID().get(i).getText().trim();
					 System.out.println("Expected after edit: " + userName + " , Actual after edit: " + actEditUserName);
					 
					 if(userName.equalsIgnoreCase(actEditUserName) && dID.equalsIgnoreCase(actEditDID))
					 {				
						 softAssert.assertEquals(actEditUserName, userName);
						 Reporter.log("Expected after edit: " + userName + "Actual after edit: " + actEditUserName);
						 softAssert.assertEquals(actEditDID, dID);
						 Reporter.log("Expected DID after edit: " + dID + "Actual DID after edit: " + actEditDID);
						 flagEdit=true;
						 break;
					 }						 
				 }
				 break;
			 }
		 }
		 System.out.println("flagAdd: " + flagAdd + " flagEdit: " + flagEdit);
			softAssert.assertTrue(flagAdd); 
			softAssert.assertTrue(flagEdit);
			softAssert.assertAll();
			Reporter.log("Test Ended for adding and editing Phone Extension: "+LavanteUtils.currenttime());
	}
	
	
	/**
	 * 
	 * This method is for Adding and Deleting of the newly added Phone Extension 
	 * 
	 * @author nagappa.vaddebail
	 * 
	 */
	
	@Test
	public void addDeletePhoneExtension()
	{
		 System.out.println("In test...!");
		 Reporter.log("Test Started for adding and deleting Phone Extension: " + LavanteUtils.currenttime());
		 SoftAssert softAssert = new SoftAssert();
		 //Adding new fax comment
		 String userName = "*A2Delete"+currenttime();
		 String dID = "9"+currenttime();
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 dataMap.put("UserName", userName);
		 dataMap.put("DID", dID);
		 dataMap.put("Save", "");
		 //dataMap.put("Cancel", "");
		 Reporter.log("Adding new phone Extension");
		 configurationOthersPage.addPhoneExtension(dataMap);
		 
		 boolean flagAdd=false;
		 boolean flagDelete=true;
		 lavanteUtils.waitForTime(2000);
		 System.out.println("Adding new phone Extension" + " size: " +  configurationOthersPage.userName().size());
		 for(int i=0; i < configurationOthersPage.userName().size(); i++)
		 {
			 String actUserName = configurationOthersPage.userName().get(i).getText().trim();
			 String actDID = configurationOthersPage.DID().get(i).getText().trim();
			 
			 System.out.println("Expected: " + userName + " , Actual: " + actUserName);
			 if(userName.equalsIgnoreCase(actUserName) && dID.equalsIgnoreCase(actDID))
			 {	
		 
				 softAssert.assertEquals(actUserName, userName);
				 Reporter.log("Expected user name: " + userName + "Actual user name: " + actUserName);
				 softAssert.assertEquals(actDID, dID);
				 Reporter.log("Expected DID: " + dID + "Actual DID: " + actDID);
				 flagAdd=true;
				 
				 lavanteUtils.click(configurationOthersPage.deletePhone().get(i));
				 lavanteUtils.click(configurationOthersPage.OkbtnPhone());
				 
				 System.out.println("Entering validation loop..!" + "size: " + configurationOthersPage.userName().size());
				 lavanteUtils.waitForTime(4000);
				 for(int j=0; j < configurationOthersPage.userName().size(); j++)
				 {
					 String actDeleteUserName = configurationOthersPage.userName().get(j).getText().trim();
					 String actDeleteDID = configurationOthersPage.DID().get(j).getText().trim();
					 System.out.println("Expected after edit: " + userName + " , Actual after edit: " + actDeleteUserName);
					 
					 if(userName.equalsIgnoreCase(actDeleteUserName) )
					 {				
						 softAssert.assertEquals(actDeleteUserName, userName);
						 Reporter.log("Expected after edit: " + userName + "Actual after edit: " + actDeleteUserName);
						 softAssert.assertEquals(actDeleteDID, dID);
						 Reporter.log("Expected DID after edit: " + dID + "Actual DID after edit: " + actDeleteDID);
						 flagDelete=false;
						 break;
					 }						 
				 }
				 break;
			 }
		 }
		 	System.out.println("flagAdd: " + flagAdd + " flagDelete: " + flagDelete);
			softAssert.assertTrue(flagAdd); 
			softAssert.assertTrue(flagDelete);
			softAssert.assertAll();
			Reporter.log("Test Ended for adding and deleting Phone Extension: "+LavanteUtils.currenttime());
	}
	
	@AfterMethod
	public void AfterMethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
		/*
		 *  Commented as the delete query is not working.
		 * Uncomment this code once the delete query is functioning.
		 * 
		if(phoneComment.length()>0){
			String query="delete from as_phone_extensions where [Name] = '"+phoneComment+"'";
			String resultSet = lavanteUtils.fetchDBdata(query);
			System.out.println("resultSet:: " + resultSet);
		}*/
	}
 	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }
	
}
