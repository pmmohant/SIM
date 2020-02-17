package com.lavante.sim.supplier.TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
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

/**
 * Created on 19-07-2018 Created for Verifying 
 * 
 * SIM-16596 Deactivating Supplier and Deleting Mapped Supplier
 * SIM-16123 Add new Contact type  Blackhaul
 * 
 * Paused in Middle due to ISE and Started again and closed
 * Ended on 01-08-2018
 *
 */
public class SupplierUserPageTests01 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String username="";
	String loggedContactNme="";
	
	/**
	 * This class all test starts using login page and driver initialization
	 * 
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
		List<?> listofdatafrm = lavanteUtils.login("SupplierAgent", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		loggedContactNme=LdataMap.get("username");
		loggedContactNme="select MAX(ContactName) from Contact where Email ='"+loggedContactNme+"' ";
		loggedContactNme=lavanteUtils.fetchDBdata(loggedContactNme);
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod
	public void before(){
		lavanteUtils.clicks(enObjSupplierHomePage.EditList().get(0));
		Reporter.log("Edit Profile Button Clicked");
	}

	
	/**
	 * Remove Linked User-App Should not allow to delete the Linked user and Also should not allow to delete the logged in user
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void removelinkedUserTest() throws Exception {
		Reporter.log("Test Started for remove linked UserTest:" + currenttime());
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		boolean flag=false;
		
		String userName="Ram"+randomnum();
		lavanteUtils.loaderIcon(null);
		lavanteUtils.fluentwait(eneditProfile.iframe_todo());
		
		String contactType="BackHaul";
		dataMap.put("AddContact","Add New");
		dataMap.put("Name",userName);
		dataMap.put("Email","ANY");
		dataMap.put("ContactType",contactType);
		eneditCompanyProfile.detailsAddress(dataMap,0);
		
		dataMap.put("AddContact",userName);
		eneditCompanyProfile.detailsAddress(dataMap,0);
		
		dataMap.put("Save", "");
		eneditProfile.formAction(dataMap);
				
		for(int i=0;i<eneditCompanyProfile.ListSelectedContact().size();i++){
			String xx=eneditCompanyProfile.ListSelectedContact().get(i).getText();
			if(!xx.contains("Select")){
				userName=xx+"#";
			}
		}
		
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(dataMap);
		
		boolean flag2=false;
		
		SoftAssert softAssert=new SoftAssert();
		
		lavanteUtils.fluentwait(objUserPage.AddNewUserBtn);
		for(int i=0;i<objUserPage.iterateSearchHeaderFindColList("User Name").size();i++){
			String actualContactName = objUserPage.iterateSearchHeaderFindColList("User Name").get(i).getText();
			
			if(userName.contains(actualContactName)){
				Reporter.log("User name Found,Contains " + userName + "in Admin Contact Page " + actualContactName,true);
				softAssert.assertTrue(userName.contains(actualContactName), " User " + userName + " is not Created ");
				
				lavanteUtils.click(objUserPage.iterateSearchHeaderFindColList("User Name").get(i));
				
				flag=true;
			}
			if(loggedContactNme.contains(actualContactName)){
				Reporter.log("Login User name Found,Contains " + loggedContactNme + "in Admin Contact Page " + actualContactName,true);
				softAssert.assertTrue(loggedContactNme.contains(actualContactName), " User " + userName + " is not Created ");
				
				lavanteUtils.click(objUserPage.iterateSearchHeaderFindColList("User Name").get(i));
				
				flag2=true;
			}
			
		}
		
		Assert.assertTrue(flag,"Edit Profile User Not Found");
		softAssert.assertTrue(flag2,"Logged in User not found");
		
		Reporter.log("Created User:"+userName);		
		
		lavanteUtils.click(objUserPage.ActionsDropDwn());
		
		dataMap.put("DeleteUserAction", "");
		objUserPage.Action(dataMap);
		
		flag=false;
		String x="";
		lavanteUtils.fluentwait(objUserPage.AddNewUserBtn);	
		for(int i=0;i<objUserPage.ReasonContactName.size();i++){
			x=objUserPage.ReasonContactName.get(i).getText();
			if(loggedContactNme.contains(x)){
				String y=objUserPage.ReasonContactReason.get(i).getText();
				softAssert.assertEquals(y, "Logged in contact",x+"Logged in contact reason not shown");
				flag=true;
				break;
			}
		}
		
		softAssert.assertTrue(flag,"Logged in Contact Failed");
		
		flag=false;
		for(int i=0;i<objUserPage.ReasonContactName.size();i++){
			x=objUserPage.ReasonContactName.get(i).getText();
			if(userName.contains(x)){
				String y=objUserPage.ReasonContactReason.get(i).getText();
				softAssert.assertEquals(y, "Mapped to customer locations",x+"Mapped to customer locations not shown");
				flag=true;
				break;
			}
		}
		
		softAssert.assertTrue(flag,"Mapped in Contact Failed");
		lavanteUtils.refreshPage();
		
		//To delete the created user
		username=x;
		
		//Contact Name and Type Verification
		flag=false;
		dataMap.put("maintab", "Home");
		enobjhomePage.selectTab(dataMap);
		
		Reporter.log("In View Profile:");
		
		lavanteUtils.fluentwait(enObjSupplierHomePage.EditList().get(0));
		outr:if(enObjSupplierHomePage.ListInvite().size()>0){
			lavanteUtils.click(enObjSupplierHomePage.ListInvite().get(0));
			lavanteUtils.fluentwait(enviewSupplier.supplierName());
			for (int i = 0; i < enviewSupplier.cntactaddresscntctname().size(); i++) {
				String actContactName = enviewSupplier.cntactaddresscntctname().get(i).getText();
				if (actContactName.equalsIgnoreCase(username)) {
					Reporter.log("Contact type ,Expected:"+username+",Actuals:"+actContactName);
					softAssert.assertEquals(actContactName,username,"Contact Name not Available in View Profile");
					
					String actualType = enviewSupplier.cntactaddresscntct().get(i).getText();
					Reporter.log("Contact type ,Expected:"+contactType+",Actuals:"+actualType);
					softAssert.assertTrue(actualType.contains(contactType),"Contact type not saved");
					flag = true;
					break outr;
				}
			}
		}
		
		softAssert.assertTrue(flag,"Please Recheck");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for Linked User Mapping:" + currenttime());
	}

	
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.refreshPage();
		
		if(username.length()>0){
			String q = " delete from LoginInvitingOrgMap where LoginID in (select LoginID from [Login]  where ContactID in (select ContactID from Contact where ContactName='" + username+ "'))";
			String q1 = "delete from ReceiverMessage where RecieverLoginID in (select LoginID From Login where ContactID in (select ContactID from Contact where ContactName='" + username+ "'))";
			String q2 = "delete from Login where ContactID in (select ContactID from Contact where ContactName='" + username+ "')";
			String q3 = "delete from Supplier_Contact_Map  where ContactID in (select ContactID from Contact where ContactName='"+ username + "')";
			String q4 = "delete from  Contact where ContactName='" + username + "'";
	
			lavanteUtils.UpdateDB(q);
			lavanteUtils.UpdateDB(q1);
			lavanteUtils.UpdateDB(q2);
			lavanteUtils.UpdateDB(q3);
			lavanteUtils.UpdateDB(q4);
		}
		
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
