package com.lavante.sim.customer.TestScripts.Admin;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ManageUsers;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class UserBasicSearch extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
	/**
	 * This class all test starts using login page and driver initialization
	 * SIM-10524 User Basic Search
	 *@author Piramanayagam.S 
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
		List<?> listofdatafrm = lavanteUtils.login("Search-INNOTIN", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		

	}
	
	@BeforeMethod()
	public void beforeMethod(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(LdataMap);
		
		LdataMap.put("ResetSearch","");
		objUserPage.formAction(LdataMap);
		
	}

	/**
	 * User Basic Search --All Search Criteria Search
	 * SIM-10524 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "UserSearchBasic", dataProviderClass = ManageUsers.class)
	public void UserSearchBasic(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for  Basic Search User:" + currenttime());
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		
		dataMap.put("CustomerID", customerID);
		dataMap= lavanteUtils.convertdatamap(dataMap);
		objUserPage.searchUserContactName(dataMap);
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		
		String appvalue="";
		
		if(objUserPage.iterateSearchHeaderFindColList("User Name").size()>0){
			
			Reporter.log("Data Returned for the search "+dataMap,true);
			
			if(!dataMap.containsKey("UserGroup")) {
			
				if(dataMap.containsKey("ContactName")){
					String exp=dataMap.get("ContactName");
					appvalue=objUserPage.iterateSearchHeaderFindColList("User Name").get(0).getText();
					Reporter.log("Table Data,Contact Name ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact Name Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("UserRole")){
					String exp=dataMap.get("UserRole");
					appvalue=objUserPage.iterateSearchHeaderFindColList("User Role").get(0).getText();
					Reporter.log("Table Data,Contact UserRole ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact UserRole Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("CreateAcc")){
					String exp=dataMap.get("CreateAcc").toLowerCase();
					appvalue=objUserPage.iterateSearchHeaderFindColList("Account Created").get(0).getText().toLowerCase();
					Reporter.log("Table Data,Contact CreateAcc ,Exp:"+exp+",App:"+appvalue,true);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact CreateAcc Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("Division")){
					String exp=dataMap.get("Division");
					appvalue=objUserPage.iterateSearchHeaderFindColList("Division").get(0).getText();
					Reporter.log("Table Data,Contact Email ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact Email Not matched,Exp:"+exp+",App:"+appvalue);
							
					flag=true;
				}if(dataMap.containsKey("Email")){
					String exp=dataMap.get("Email");
					appvalue=objUserPage.iterateSearchHeaderFindColList("Email").get(0).getText();
					Reporter.log("Table Data,Contact Email ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact Email Not matched,Exp:"+exp+",App:"+appvalue);
							
					flag=true;
				}if(dataMap.containsKey("ContactPhone")){
					String exp=dataMap.get("ContactPhone");
					appvalue=objUserPage.iterateSearchHeaderFindColList("Phone").get(0).getText();
					Reporter.log("Table Data,Contact Phone ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact Phone Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("ContactFax")){
					String exp=dataMap.get("ContactFax");
					appvalue=objUserPage.iterateSearchHeaderFindColList("Fax").get(0).getText();
					Reporter.log("Table Data,Contact Fax ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Table Data,Contact Fax Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("ShowInactive")){
					String exp=dataMap.get("ShowInactive");
					
					//Passing Yes In excel will select inactive Supplier checkbox, Hence changing exp value acc to the application
					if(exp.equalsIgnoreCase("Yes")){
						exp="No";
					}else{
						exp="Yes";
					}
					appvalue=objUserPage.iterateSearchHeaderFindColList("Active User").get(0).getText();
					Reporter.log(" Table Data,ShowInactive ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp)," Table Data,ShowInactive Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}
			}	

			//Page
			if(!dataMap.containsKey("ShowInactive")) {
				flag=false;
				lavanteUtils.click(objUserPage.iterateSearchHeaderFindColList("User Name").get(0));
				lavanteUtils.switchtoFrame(null);
				
				if(dataMap.containsKey("ContactName")){
					String exp=dataMap.get("ContactName");
					appvalue=objUserPage.iterateViewUser("User Name");
					Reporter.log("Popup Data,Contact Name ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact Name Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("Email")){
					String exp=dataMap.get("Email");
					appvalue=objUserPage.iterateViewUser("Email");
					Reporter.log("Popup Data,Contact Email ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact Email Not matched,Exp:"+exp+",App:"+appvalue);
							
					flag=true;
				}if(dataMap.containsKey("ContactPhone")){
					String exp=dataMap.get("ContactPhone");
					appvalue=objUserPage.iterateViewUser("Phone");
					Reporter.log("Popup Data,Contact Name ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact Name Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("ContactFax")){
					String exp=dataMap.get("ContactFax");
					appvalue=objUserPage.iterateViewUser("Fax");
					Reporter.log("Popup Data,Contact Fax ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact Fax Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("CreateAcc")){
					String exp=dataMap.get("CreateAcc").toLowerCase();
					appvalue=objUserPage.iterateViewUser("Account Created").toLowerCase();
					Reporter.log("Popup Data,Contact CreateAcc ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact CreateAcc Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("UserRole")){
					String exp=dataMap.get("UserRole");
					appvalue=objUserPage.iterateViewUser("Account Created");
					Reporter.log("Popup Data,Contact UserRole ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact UserRole Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("UserGroup")){
					String exp=dataMap.get("UserGroup");
					appvalue=objUserPage.iterateViewUser("User Group");
					Reporter.log("Popup Data,Contact Group ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact Group Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}if(dataMap.containsKey("Division")){
					String exp=dataMap.get("Division");
					appvalue=objUserPage.iterateViewUser("Division");
					Reporter.log("Popup Data,Contact Division ,Exp:"+exp+",App:"+appvalue);
					softAssert.assertTrue(appvalue.contains(exp),"Popup Data,Contact Division Not matched,Exp:"+exp+",App:"+appvalue);
					
					flag=true;
				}
			 }
		}else{
			softAssert.assertTrue(false,"Please Add test Data ");
			flag=true;
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"Please Re-check ");
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended for  Basic Search User:" + currenttime());
	}
	
	@AfterMethod
	public void SetfupAfterMethod(){
		lavanteUtils.refreshPage();
	}
	
	
	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
