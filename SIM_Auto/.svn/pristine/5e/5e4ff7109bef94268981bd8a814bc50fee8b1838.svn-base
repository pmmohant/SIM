package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ManageUsers;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 31-08-2016 Created for Verifying SIM User Roles
 * 
 *
 */
public class UserPageTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String username="";
	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhash.BV
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
		List<?> listofdatafrm = lavanteUtils.login("UserRoleId14", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		
	}
	
	@BeforeMethod
	public void Before(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * UserRoles- Super User - Account management
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws Exception
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class)
	public void addNewUserTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for addNewUserTest:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		dataMap.put("Save", "");
		objUserPage.addNewUser(dataMap);
		
		username=dataMap.get("ContactName");
		dataMap.clear();
		Reporter.log("Created User:"+username);
		objUserPage.searchUserContactName(dataMap);

		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualContactName = lavanteUtils.getText(objUserPage.iterateSearchHeaderFindColList("User Name").get(0));
		Reporter.log("User name created " + username + "and actual user name from UI while search " + actualContactName);
		softAssert.assertEquals(actualContactName, username, " User " + username + " is not Created ");
		
		//	String actualUserRole = lavanteUtils.getText(objUserPage.GetUserRole);
		//Reporter.log("User Role " + data[1] + " actual user role from UI while search" + actualUserRole);
		//softAssert.assertEquals(actualUserRole, data[1]," Assigned user role is " + dataMap.get("UserRole") + " but the actual is " + actualUserRole + "");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * UserRoles- Super User - Account management
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class)
	public void removeCreatedUserTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for removeUserTest:" + currenttime());

		dataMap.put("Save", "");
		objUserPage.addNewUser(dataMap);
		
		username=dataMap.get("ContactName");
		dataMap.clear();
		Reporter.log("Created User:"+username);
		dataMap.put("ContactName", username);
		dataMap.put("DeleteUser", "");
		objUserPage.searchPerfromActions(dataMap);
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());

		objUserPage.searchUserContactName(dataMap);
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualMsg = lavanteUtils.getText(objUserPage.GetNoDataAvailableTxt);
		
		Reporter.log("The " + username + " should be deleted, after searching the msg:" + actualMsg + ",should be displayed ");
		Assert.assertEquals(actualMsg, "No results",	"User still exists not deleted which shouldn't be the case,Actual:"+actualMsg);

		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * UserRoles- Super User - Account management
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class)
	public void enableOrActivteUserTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for enableOrActivteUserTest:" + currenttime());

		dataMap.put("Save", "");
		objUserPage.addNewUser(dataMap);
		
		username=dataMap.get("ContactName");
		dataMap.clear();
		Reporter.log("Created User:"+username);
		dataMap.put("ContactName", username);
		dataMap.put("ShowInactive", "No");
		dataMap.put("Deactivate", "");
		objUserPage.searchPerfromActions(dataMap);

		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		objUserPage.searchUserContactName(dataMap);
		
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualMsg = lavanteUtils.getText(objUserPage.GetNoDataAvailableTxt);
		Reporter.log("The " + username + " should be deleted, after searching the msg " + actualMsg + "should be displayed ");
		softAssert.assertEquals(actualMsg, "No results","User still exists not deleted which shouldn't be the case,Exp:No results,Actuals:"+actualMsg);

		dataMap.clear();
		dataMap.put("ContactName", username);
		dataMap.put("ShowInactive", "Yes");
		objUserPage.searchUserContactName(dataMap);
		lavanteUtils.waitForTime(3000);
	
		objUserPage.otherActions(dataMap);
		
		Boolean flag = lavanteUtils.isElementDisplayed(objUserPage.EditUserInformationIcon);
		Assert.assertTrue(flag,"Edit Option Not Displayed"+flag);
		String x=objUserPage.EditUserInformationIcon.getAttribute("class");
		Reporter.log("The edit option should be displayed as disabled:"+x,true);
		softAssert.assertTrue(x.contains("disabled")," The edit option is displayed which should not be the cases for the user deactivated"+x);

		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * UserRoles- Super User - Account management
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class, description = "Firefox Edit Issue")
	public void disableOrDeactivteUserTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for disableOrDeactivteUserTest:" + currenttime());

		dataMap.put("Save", "");
		objUserPage.addNewUser(dataMap);
		
		username=dataMap.get("ContactName");
		dataMap.clear();
		Reporter.log("Created User:"+username);
		dataMap.put("ContactName", username);
		dataMap.put("Deactivate", "");
		objUserPage.searchPerfromActions(dataMap);
		Reporter.log("Searched User:"+username);
		
		dataMap.put("ContactName", username);
		dataMap.put("ShowInactive", "Yes");
		objUserPage.searchUserContactName(dataMap);
		
		SoftAssert softAssert = new SoftAssert();
		
		objUserPage.otherActions(dataMap);
		
		Boolean flag = lavanteUtils.isElementDisplayed(objUserPage.EditUserInformationIcon);
		softAssert.assertTrue(flag,"Edit Option Not Displayed"+flag);
		
		String x=objUserPage.EditUserInformationIcon.getAttribute("class");
		Reporter.log("The edit option should not be displayed "+x,true);
		softAssert.assertEquals(x,"disabled"," The edit option is displayed which should not be the cases for the user deactivated"+x);

		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * MangeRoles- Edit User
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class, description = "Firefox Edit Issue")
	public void editUserTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for editUserTest:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		dataMap.put("Save", "");
		objUserPage.addNewUser(dataMap);
		
		username=dataMap.get("ContactName");
		dataMap.clear();
		dataMap.put("ContactName",username);
		objUserPage.searchUserContactName(dataMap);
		
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualContactName = lavanteUtils.getText(objUserPage.iterateSearchHeaderFindColList("User Name").get(0));
		Reporter.log("User name Created: " + username + ",and actual user name from UI while search "+ actualContactName);
		Assert.assertEquals(actualContactName, username,"User Name not matched after Save");

		String userEditedName = username + "editedUserConatctName";
		dataMap.put("ContactName", userEditedName);
		objUserPage.otherActions(dataMap);
		
		
		dataMap.remove("UserRole");
		dataMap.remove("InvitingOrg");
		lavanteUtils.fluentwait(objUserPage.EditUserInformationIcon);
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(objUserPage.EditUserInformationIcon),	"Edit option is not displayed");
		
		dataMap.put("Save", "");
		objUserPage.editUser(dataMap);
		dataMap.put("ContactName", userEditedName);
		objUserPage.searchUserContactName(dataMap);
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		actualContactName = lavanteUtils.getText(objUserPage.iterateSearchHeaderFindColList("User Name").get(0));

		Reporter.log("User name Edited " + userEditedName + "and actual user name from UI while search "+ actualContactName);
		softAssert.assertEquals(actualContactName, userEditedName, " User " + username + " is not Created ");

		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * MangeRoles- viewUserActionTest create a user view the user edit the user
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class)
	public void viewUserActionTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for viewUserActionTest:" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		dataMap.put("Save", "");
		objUserPage.addNewUser(dataMap);
		
		username=dataMap.get("ContactName");
		dataMap.clear();
		dataMap.put("ContactName",username);
		objUserPage.searchUserContactName(dataMap);
		
		lavanteUtils.switchtoFrame(objUserPage.IFRAMESearchResult());
		String actualContactName = lavanteUtils.getText(objUserPage.iterateSearchHeaderFindColList("User Name").get(0));
		Reporter.log("User name Created: " + username + ",and actual user name from UI while search "+ actualContactName,true);
		Assert.assertEquals(actualContactName, username,"User Name not matched after Save,ACtuals:"+actualContactName+",Exp:"+username);
		
		
		lavanteUtils.click(objUserPage.iterateSearchHeaderFindColList("User Name").get(0));
		
		String actUserName=objUserPage.iterateViewUser("User Name");
		Reporter.log("User name Created: " + username + ",and actual user name from View:"+ actUserName,true);
		Assert.assertEquals(actUserName,username,	"User Name is not displayed");
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(objUserPage.ViewEdit),	"Edit option is not displayed");
		
		lavanteUtils.click(objUserPage.ViewEdit);
		
		String userEditedName = username + "editedUserConatctName";
		username=userEditedName;
		
		dataMap.put("ContactName", userEditedName);
		dataMap.remove("UserRole");
		dataMap.remove("InvitingOrg");
		dataMap.put("Save", "");
		objUserPage.nwfillUserDetail(dataMap);
		objUserPage.formUserAction(dataMap);
		
		actUserName=objUserPage.iterateViewUser("User Name");
		Reporter.log("User name Created: " + username + ",and actual user name from View:"+ actUserName,true);
		softAssert.assertEquals(actUserName,username,	"User Name is not displayed");
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(objUserPage.ViewEdit),	"Edit option is not displayed");
		
		username=userEditedName;
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
		
		if(username.length()>0){
			String q = " delete from LoginInvitingOrgMap where LoginID in (select LoginID from [Login]  where ContactID in (select ContactID from Contact where ContactName='" + username+ "'))";
			String q1 = "delete from ReceiverMessage where RecieverLoginID in (select LoginID From Login where ContactID in (select ContactID from Contact where ContactName='" + username+ "'))";
			String q2 = "delete from Login where ContactID in (select ContactID from Contact where ContactName='" + username+ "')";
			String q3 = "delete from Customer_Contact_Map  where ContactID in (select ContactID from Contact where ContactName='"+ username + "')";
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
