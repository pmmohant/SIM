package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ManageAlertsTC001 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	LinkedHashMap<String, String> LdataMap = null;

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
		List listofdatafrm = lavanteUtils.login("PreScreen", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod()
	public void BeforeMethod(){
		enobjhomePage.Alertselect();
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test
	public void manageAllAlertsTest001() throws Exception {
		Reporter.log("Test Started for manageAllAlertsTest001 : " + currenttime());
		SoftAssert softAssert = new SoftAssert();

		String expectedHeader = "Notifications Details";
		String actualHeader = lavanteUtils.getText(objSupplierAlertPage.GetTableHeader());
		Reporter.log(" Verify Table header, Expected: " + expectedHeader + " ,Actual: " + actualHeader);
		softAssert.assertEquals(actualHeader, expectedHeader," Verify Table header, Expected: " + expectedHeader + " ,Actual: " + actualHeader);
		
		Reporter.log(" Verify AllAlert Tab displayed ");
		softAssert.assertTrue(objSupplierAlertPage.AllAlertTab().isDisplayed(), " Verify AllAlert Tab displayed ");

		String expectClassValue = "tab tab_active";
		String actualClassValue = lavanteUtils.getValue(objSupplierAlertPage.AllAlertTab(), "class");
		Reporter.log(" Verify AllAlert Tab is active by default, Expected : " + expectClassValue + " , Actual :"+ actualClassValue);
		softAssert.assertEquals(actualClassValue, expectClassValue," Verify AllAlert Tab is active by default, Expected : " + expectClassValue + " , Actual :"+ actualClassValue);

		String expectClassValue0 = "button button_primary open_popup";
		String actualClassValue0 = lavanteUtils.getValue(objSupplierAlertPage.AllAddAlertBtn(), "class");
		Reporter.log(" Verify AddAlert Button is active by default ");
		softAssert.assertEquals(actualClassValue0, expectClassValue0," Verify AddAlert Btn is active by default, Expected : " + expectClassValue0 + " Actual : "	+ actualClassValue0);

		String expectClassValue1 = "button button_flat unsubscribe_alert disabled";
		String actualClassValue1 = lavanteUtils.getValue(objSupplierAlertPage.UnsubscribeAllAlertBtn(), "class");
		Reporter.log(" Verify UnSubscribe Button is inactive by default ");
		softAssert.assertEquals(actualClassValue1, expectClassValue1," Verify Unsubscribe Btn is inactive by default, Expected : " + expectClassValue1 + " Actual : "+ actualClassValue1);

		List<String> expectedTableHeaders = new ArrayList<String>();
		expectedTableHeaders.add(0, "Alert Name");
		expectedTableHeaders.add(1, "Frequency");
		expectedTableHeaders.add(2, "Delivery Start");
		expectedTableHeaders.add(3, "Delivery End");
		expectedTableHeaders.add(4, "Send To");
		expectedTableHeaders.add(5, "Saved Query");
		expectedTableHeaders.add(6, "Active");
		List<String> actualTableHeaders = new ArrayList<String>();
		boolean flag = false;
		int columnHeadersSize = objSupplierAlertPage.AllAlertTableColumnHeaders().size();
		for (int i = 1; i <= columnHeadersSize - 1; i++) {
			String tableHeaderName = objSupplierAlertPage.AllAlertTableColumnHeaders().get(i).getText();
			actualTableHeaders.add((i - 1), tableHeaderName);
		}
		if (expectedTableHeaders.equals(actualTableHeaders)) {
			flag = true;
		}
		Reporter.log(" Verify AllAlert Tab Table Headers ");
		softAssert.assertTrue(flag, " Verification failed for AllAlert Tab Table Headers");
		softAssert.assertAll();

		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test
	public void manageMyAlertsTest002() throws Exception {
		Reporter.log("Test Started for manageMyAlertsTest002 : " + currenttime());
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.click(objSupplierAlertPage.MyAlertTab());
		lavanteUtils.waitForTime(4000);
		
		String expectedHeader = "My Notification Details";
		String actualHeader = lavanteUtils.getText(objSupplierAlertPage.GetMyAlertTableHeader());
		Reporter.log(" Verify Table header, Expected: " + expectedHeader + " ,Actual: " + actualHeader);
		softAssert.assertEquals(actualHeader, expectedHeader,	" Verify Table header, Expected: " + expectedHeader + " ,Actual: " + actualHeader);

		Reporter.log(" Verify MyAlert Tab displayed ");
		softAssert.assertTrue(objSupplierAlertPage.MyAlertTab().isDisplayed(), " Verify MyAlert Tab displayed ");

		lavanteUtils.waitForTime(2000);
		String expectClassValue = "tab tab_active";
		String actualClassValue = lavanteUtils.getValue(objSupplierAlertPage.MyAlertTab(), "class");
		Reporter.log(" Verify MyAlert Tab is active ");
		softAssert.assertEquals(actualClassValue, expectClassValue,	" Verify MyAlert Tab is active, Expected : " + expectClassValue + " , Actual : " + actualClassValue);

		String expectClassValue0 = "button button_flat unsubscribe_alert disabled";
		String actualClassValue0 = lavanteUtils.getValue(objSupplierAlertPage.UnsubscribeMyAlertBtn(), "class");
		Reporter.log(" Verify UnSubscribe Button is inactive by default ");
		softAssert.assertEquals(actualClassValue0, expectClassValue0,	" Verify UnSubscribe Button is inactive by default, Expected : " + expectClassValue + " ,Actual :  "	+ actualClassValue);

		String expectClassValue1 = "button button_primary open_popup";
		String actualClassValue1 = lavanteUtils.getValue(objSupplierAlertPage.MyAddAlertBtn(), "class");
		Reporter.log(" Verify MyAddAlert Button is active by default ");
		softAssert.assertEquals(actualClassValue1, expectClassValue1," Verify MyAddAlert Button is active by default ");

		String expectClassValue2 = "button button_secondary open_popup disabled";
		String actualClassValue2 = lavanteUtils.getValue(objSupplierAlertPage.EditAlertBtn(), "class");
		Reporter.log(" Verify Edit Button is inactive by default ");
		softAssert.assertEquals(actualClassValue2, expectClassValue2, " Verify Edit Button is inactive by default ");

		String expectClassValue3 = "button button_flat disabled";
		String actualClassValue3 = lavanteUtils.getValue(objSupplierAlertPage.DeleteAlertBtn(), "class");
		Reporter.log(" Verify Delete Button is inactive by default ");
		softAssert.assertEquals(actualClassValue3, expectClassValue3, " Verify Delete Button is inactive by default ");

		List<String> expectedTableHeaders = new ArrayList<String>();
		expectedTableHeaders.add(0, "Alert Name");
		expectedTableHeaders.add(1, "Frequency");
		expectedTableHeaders.add(2, "Delivery Start");
		expectedTableHeaders.add(3, "Delivery End");
		expectedTableHeaders.add(4, "Send To");
		expectedTableHeaders.add(5, "Saved Query");
		expectedTableHeaders.add(6, "Active");
		List<String> actualTableHeaders = new ArrayList<String>();
		boolean flag = false;
		int columnHeadersSize = objSupplierAlertPage.MyAlertTableColumnHeaders().size();
		for (int i = 1; i <= columnHeadersSize - 1; i++) {
			String tableHeaderName = objSupplierAlertPage.MyAlertTableColumnHeaders().get(i).getText();
			actualTableHeaders.add((i - 1), tableHeaderName);
		}
		if (expectedTableHeaders.equals(actualTableHeaders)) {
			flag = true;
		}
		Reporter.log(" Verify MyAlert Tab Table Headers ");
		softAssert.assertTrue(flag, " Verification failed for MyAlert Tab Table Headers");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test
	public void manageAlertsMandatoryFieldsTest003() throws Exception {
		Reporter.log("Test Started for manageAlertsTest003 : " + currenttime());
		
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.click(objSupplierAlertPage.AddAlertBtn());

		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(null);
		String expectedTitleBar = "Add Alert";
		lavanteUtils.fluentwait(objSupplierAlertPage.AddAlertTitleBar());
		String actualTitlebar = lavanteUtils.getText(objSupplierAlertPage.AddAlertTitleBar());
		Reporter.log("Verify PopUp Title Bar ");
		softAssert.assertEquals(actualTitlebar, expectedTitleBar," Verify PopUp Title Bar, Expected : " + expectedTitleBar + " ,Actual : " + actualTitlebar);

		lavanteUtils.switchtoFrame(objSupplierAlertPage.AlertIframe());
		lavanteUtils.click(objSupplierAlertPage.CancelBtn());

		lavanteUtils.click(objSupplierAlertPage.AddAlertBtn());
		lavanteUtils.switchtoFrame(objSupplierAlertPage.AlertIframe());

		boolean flag0 = false;
		String expectedType = "checkbox";
		String actualType = lavanteUtils.getValue(objSupplierAlertPage.RoleChkBoxinput(), "type");
		String actualType1 = lavanteUtils.getValue(objSupplierAlertPage.UserChkBoxinput(), "type");
		if (expectedType.equals(actualType) && expectedType.equals(actualType1)) {
			//if (!objSupplierAlertPage.RoleChkBox().isSelected() && !objSupplierAlertPage.UserChkBox().isSelected()) {
				flag0 = true;
			//}
		}
		Reporter.log(" Verify for Admin role user, show check box with 'Role' and 'User' selection, Expected : "+ expectedType + ", Actual : " + actualType + ", Actual1 : " + actualType1);
		softAssert.assertTrue(flag0," Verify for Admin role user, show check box with 'Role' and 'User' selection, Expected : "	+ expectedType + ", Actual : " + actualType + ", Actual1 : " + actualType1);

		lavanteUtils.click(objSupplierAlertPage.SavedQueryDropDwn());
		lavanteUtils.selectFrmDpdn("any");
		lavanteUtils.switchtoFrame(objSupplierAlertPage.AlertIframe());
		String getBeforeValue = lavanteUtils.getText(objSupplierAlertPage.SavedQueryDropDwn());
		//lavanteUtils.click(objSupplierAlertPage.ClearBtn());
		String getAfterValue = lavanteUtils.getText(objSupplierAlertPage.SavedQueryDropDwn());
		String expectedVaue = "Select the option";
		boolean flag = false;
		if (expectedVaue.equals(getAfterValue)) {
			flag = true;
		}
		Reporter.log(" Verification Of Clear Btn functionality, Before Drop Dwn Value : " + getBeforeValue	+ ", After Drop Dwn Value  : " + getAfterValue);
		softAssert.assertTrue(flag, " Verification Of Clear Btn functionality, Before Drop Dwn Value : "+ getBeforeValue + ", Actual : " + getAfterValue);

		List<String> expectedMandatoryFields = new ArrayList<String>();
		expectedMandatoryFields.add(0, "Entity:");
		expectedMandatoryFields.add(1, "Saved Query:");
		expectedMandatoryFields.add(2, "Alert Name:");
		expectedMandatoryFields.add(3, "Email Subject:");
		expectedMandatoryFields.add(4, "Send To:");
		expectedMandatoryFields.add(5, "Frequency:");
		expectedMandatoryFields.add(6, "Specify Time:");
		expectedMandatoryFields.add(7, "Delivery Start Date:");
		expectedMandatoryFields.add(8, "Alert Template Format Used:");
		Boolean flag1 = false;
		List<String> actualMandatoryFields = new ArrayList<String>();
		int mandatoryFieldsSize = objSupplierAlertPage.AddAlertMandatoryFieldsList().size();
		for (int i = 0; i < mandatoryFieldsSize; i++) {
			String mandatoryField = lavanteUtils.getText(objSupplierAlertPage.AddAlertMandatoryFieldsList().get(i));
			actualMandatoryFields.add(i, mandatoryField);
		}
		if (expectedMandatoryFields.equals(actualMandatoryFields)) {
			flag1 = true;
		}

		Reporter.log(" Verification for Mandatory Fields in AddAlert popup, Expected : " + expectedMandatoryFields	+ ", Actual : " + actualMandatoryFields);
		softAssert.assertTrue(flag1, " Verification failed for Mandatory Fields in AddAlert popup, Expected : "	+ expectedMandatoryFields + ", Actual : " + actualMandatoryFields);

		softAssert.assertAll();
		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test(dataProvider = "AddAlert", dataProviderClass = SupplierSearchDataProvider.class)
	public void addAlertTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for addAlertTest : " + currenttime());

		dataMap.put("AllAlertTab", "");
		dataMap.put("SavedQuery", "any");
		String expectedAlertName = "AutoSub" + randomnum();
		String emailSubject = "Sub" + randomnum() + "@gmail.com";
		dataMap.put("AlertName", expectedAlertName);
		dataMap.put("EmailSubject", emailSubject);
		dataMap.put("RoleAndOption", "yes#Super SIM Customer");
		dataMap.put("FrequencyAndOption", "1#any");
		dataMap.put("DeliveryStartDate", "");
		dataMap.put("AlertTemplateFormat", "any");
		dataMap.put("AlertSave", "");
		objSupplierAlertPage.addAlert(dataMap);

		boolean flag = false;
		String actualAlertName = null;
		int size = objSupplierAlertPage.AllAlertNameList().size();
		for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objSupplierAlertPage.AllAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName + " expectedAlertName  " + expectedAlertName);
			if (expectedAlertName.equals(actualAlertName)) {
				flag = true;
				break;
			}
		}
		Reporter.log("Verify that existing functionality should also work for newly added fields( Advanced search, Saved search and Alerts Jobs), Expected AlertName "	+ expectedAlertName + " Actual AlertName, " + actualAlertName);
		Assert.assertTrue(flag,"Verify that existing functionality should also work for newly added fields( Advanced search, Saved search and Alerts Jobs), Expected AlertName " + expectedAlertName + " Actual AlertName, " + actualAlertName);

		Reporter.log("Test Ended at: " + currenttime());

	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test(dataProvider = "AddAlert", dataProviderClass = SupplierSearchDataProvider.class)
	public void editAlertTest() throws Exception {
		Reporter.log("Test Started for editAlertTest : " + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		lavanteUtils.switchtoFrame(objSupplierAlertPage.SearchListIFRAME());
		dataMap.put("MyAlertTab", "");
		dataMap.put("SavedQuery", "any");
		String alertName = "AutoSub" + randomnum();
		String emailSubject = "Sub" + randomnum() + "@gmail.com";
		dataMap.put("AlertName", alertName);
		dataMap.put("EmailSubject", emailSubject);
		dataMap.put("RoleAndOption", "yes#Super SIM Customer");
		dataMap.put("FrequencyAndOption", "1#any");
		dataMap.put("DeliveryStartDate", "");
		dataMap.put("AlertTemplateFormat", "any");
		dataMap.put("AlertSave", "");
		objSupplierAlertPage.addAlert(dataMap);

		enobjhomePage.Alertselect();

		lavanteUtils.click(objSupplierAlertPage.MyAlertTab());
		lavanteUtils.waitForTime(3000);

		boolean flag = false;
		String actualAlertName = null;
		int size = objSupplierAlertPage.MyAlertNameList().size();
		for (int i = 0; i <= size; i++) {
			actualAlertName = lavanteUtils.getText(objSupplierAlertPage.MyAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName + "    expectedAlertName  " + alertName);
			if (alertName.equals(actualAlertName)) {
				lavanteUtils.selectChkBox(objSupplierAlertPage.MyAlertNameChkBoxList().get(i), "yes");
				break;
			}
		}
		dataMap.clear();
		String expectedAlertName = "AutoSub" + randomnum();
		String emailSubject1 = "Sub" + randomnum() + "@gmail.com";
		dataMap.put("AlertName", expectedAlertName);
		dataMap.put("EmailSubject", emailSubject1);
		dataMap.put("AlertSave", "");
		objSupplierAlertPage.editAlert(dataMap);

		enobjhomePage.Alertselect();
		
		lavanteUtils.click(objSupplierAlertPage.MyAlertTab());
		lavanteUtils.waitForTime(3000);

		String actualAlertName1 = null;
		int size1 = objSupplierAlertPage.MyAlertNameList().size();
		for (int i = 0; i <= size1 - 1; i++) {
			actualAlertName1 = lavanteUtils.getText(objSupplierAlertPage.MyAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName1 + " expectedAlertName  " + alertName);
			if (expectedAlertName.equals(actualAlertName1)) {
				flag = true;
				break;
			}
		}

		Reporter.log(
				"Verify that, Edit Alert is possible only for the users who have created the Alert , Expected AlertName "
						+ expectedAlertName + " Actual AlertName, " + actualAlertName1);
		Assert.assertTrue(flag,
				"Verify that, Edit Alert is possible only for the users who have created the Alert , Expected AlertName "
						+ expectedAlertName + " Actual AlertName, " + actualAlertName1);

		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test(dataProvider = "AddAlert", dataProviderClass = SupplierSearchDataProvider.class)
	public void deleteAlertTest() throws Exception {
		Reporter.log("Test Started for manageAlertsTest001 : " + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("MyAlertTab", "");
		dataMap.put("SavedQuery", "any");
		String alertName = "AutoSub" + randomnum();
		String emailSubject = "Sub" + randomnum() + "@gmail.com";
		dataMap.put("AlertName", alertName);
		dataMap.put("EmailSubject", emailSubject);
		dataMap.put("RoleAndOption", "yes#Super SIM Customer");
		dataMap.put("FrequencyAndOption", "1#any");
		dataMap.put("DeliveryStartDate", "");
		dataMap.put("AlertTemplateFormat", "any");
		dataMap.put("AlertSave", "");
		objSupplierAlertPage.addAlert(dataMap);

		enobjhomePage.Alertselect();
		
		lavanteUtils.click(objSupplierAlertPage.MyAlertTab());
		lavanteUtils.waitForTime(3000);

		String actualAlertName = null;
		int size = objSupplierAlertPage.MyAlertNameList().size();
		for (int i = 0; i <= size; i++) {
			actualAlertName = lavanteUtils.getText(objSupplierAlertPage.MyAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName + "    expectedAlertName  " + alertName);
			if (alertName.equals(actualAlertName)) {
				lavanteUtils.selectChkBox(objSupplierAlertPage.MyAlertNameChkBoxList().get(i), "yes");
				break;
			}
		}
		lavanteUtils.click(objSupplierAlertPage.DeleteAlertBtn());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objSupplierAlertPage.OkBtn());
		lavanteUtils.click(objSupplierAlertPage.OkBtn());
		lavanteUtils.fluentwait(objSupplierAlertPage.OkBtn());
		lavanteUtils.click(objSupplierAlertPage.OkBtn());
		lavanteUtils.waitForTime(3000);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		boolean flag1 = false;
		int size1 = objSupplierAlertPage.MyAlertNameList().size();
		for (int i = 0; i < size1; i++) {
			actualAlertName = lavanteUtils.getText(objSupplierAlertPage.MyAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName + "    expectedAlertName  " + alertName);
			if (!alertName.equals(actualAlertName)) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		Reporter.log("Verified, 'Delete' functionality is allowed only for the user who has created that Alert");
		Assert.assertTrue(flag1,
				"Verified, 'Delete' functionality is allowed only for the user who has created that Alert, Expected : true , Actual "
						+ flag1);

		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * 
	 * SIM-9147 Enable users to set and subscribe alerts
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 */
	@Test(dataProvider = "AddAlert", dataProviderClass = SupplierSearchDataProvider.class)
	public void unSubscribeAlertTest() throws Exception {
		Reporter.log("Test Started for unSubscribeAlertTest : " + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("MyAlertTab", "");
		dataMap.put("SavedQuery", "any");
		String alertName = "AutoSub" + randomnum();
		String emailSubject = "Sub" + randomnum() + "@gmail.com";
		dataMap.put("AlertName", alertName);
		dataMap.put("EmailSubject", emailSubject);
		dataMap.put("RoleAndOption", "yes#Super SIM Customer");
		dataMap.put("FrequencyAndOption", "1#any");
		dataMap.put("DeliveryStartDate", "");
		dataMap.put("AlertTemplateFormat", "any");
		dataMap.put("AlertSave", "");
		objSupplierAlertPage.addAlert(dataMap);

		enobjhomePage.Alertselect();
		
		lavanteUtils.click(objSupplierAlertPage.MyAlertTab());
		lavanteUtils.waitForTime(3000);

		String actualAlertName = null;
		int size = objSupplierAlertPage.MyAlertNameList().size();
		for (int i = 0; i <= size; i++) {
			actualAlertName = lavanteUtils.getText(objSupplierAlertPage.MyAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName + "    expectedAlertName  " + alertName);
			if (alertName.equals(actualAlertName)) {
				lavanteUtils.selectChkBox(objSupplierAlertPage.MyAlertNameChkBoxList().get(i), "yes");
				break;
			}
		}
		lavanteUtils.click(objSupplierAlertPage.UnsubscribeMyAlertBtn());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objSupplierAlertPage.OkBtn());
		lavanteUtils.click(objSupplierAlertPage.OkBtn());
		lavanteUtils.fluentwait(objSupplierAlertPage.GetPopUpMsg());
		String expectedMsg0 = "Alert(s) unsubscribed Successfully.";
		String actualMsg0 = lavanteUtils.getText(objSupplierAlertPage.GetPopUpMsg());
		lavanteUtils.fluentwait(objSupplierAlertPage.OkBtn());
		lavanteUtils.click(objSupplierAlertPage.OkBtn());
		lavanteUtils.waitForTime(3000);

		Reporter.log("Verified UnSubscribe functionality1, Expected : " + expectedMsg0 + " Actual : " + actualMsg0);
		Assert.assertEquals(actualMsg0, expectedMsg0,"Verified UnSubscribe functionality1, Expected : " + expectedMsg0 + " Actual : " + actualMsg0);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		int size1 = objSupplierAlertPage.MyAlertNameList().size();
		for (int i = 0; i <= size1; i++) {
			actualAlertName = lavanteUtils.getText(objSupplierAlertPage.MyAlertNameList().get(i));
			System.out.println("actualAlertName  " + actualAlertName + "    expectedAlertName  " + alertName);
			if (alertName.equals(actualAlertName)) {
				lavanteUtils.selectChkBox(objSupplierAlertPage.MyAlertNameChkBoxList().get(i), "yes");
				break;
			}
		}
		lavanteUtils.click(objSupplierAlertPage.UnsubscribeMyAlertBtn());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(objSupplierAlertPage.OkBtn());
		lavanteUtils.click(objSupplierAlertPage.OkBtn());
		lavanteUtils.fluentwait(objSupplierAlertPage.GetPopUpMsg());
		String expectedMsg = "You have not subscribed to the selected alert(s). Please select only those alerts for which you have subscribed.";
		String actualMsg = lavanteUtils.getText(objSupplierAlertPage.GetPopUpMsg());
		lavanteUtils.fluentwait(objSupplierAlertPage.OkBtn());
		lavanteUtils.click(objSupplierAlertPage.OkBtn());

		Reporter.log("Verified UnSubscribe functionality, Expected : " + expectedMsg + " Actual : " + actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg,"Verified UnSubscribe functionality, Expected : " + expectedMsg + " Actual : " + actualMsg);

		Reporter.log("Test Ended at: " + currenttime());
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author Subhas.BV
	 */
	@AfterClass
	public void setupAfterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
