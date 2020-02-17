package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * 
 * @author Subhash.BV
 *
 */


public class CustomTabFields01 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String sname = null;
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	int subSectionID01 = 202;
	int subSectionID02 = 204;

	String query = null;

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
		List listofdatafrm = lavanteUtils.login("CollectionOfFileds", browser);
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();
	}

	/*
	 * @BeforeMethod public void setup() throws Exception { // Login List
	 * listofdatafrm = lavanteUtils.login("CollectionOfFileds", browser);
	 * dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
	 * customerID = (String) listofdatafrm.get(1); // Login
	 * enobjloginpage.logintoAPP(dataMap); enobjhomePage.close(); sname =
	 * dataMap.get("supname"); dataMap.put("maintab", "Supplier");
	 * enobjhomePage.selectTab(dataMap);
	 * 
	 * dataMap.put("Search", ""); dataMap.put("supplierName", sname);
	 * enobjsupplierBasicSearch.search(dataMap);
	 * 
	 * }
	 */
	
	@BeforeMethod
	public void BeforeMehtod(){

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Pending Validation");
		enobjsupplierBasicSearch.search(dataMap);
	}

	private void insertIntoI18nkeyUserTranslation(String[] i18nkey)
			throws FileNotFoundException, IOException, SQLException {

		for (int i = 0; i < i18nkey.length; i++) {
			query = " Insert into I18NKey ( i18nKey) VALUES (   '" + i18nkey[i] + "')";
			lavanteUtils.UpdateDB(query);
			query = " INSERT INTO UserTranslation (i18nKey  ,LanguageID  ,UTFString  ,IsCustomerSpecific) VALUES "
					+ " ('" + i18nkey[i] + "'   ,50    ,'" + i18nkey[i] + "'   ,'' )";
			lavanteUtils.UpdateDB(query);
		}
	}

	private String[] insertIntoCustomerFieldVGMetadata(String[] i18nkey)
			throws FileNotFoundException, IOException, SQLException {

		String[] fieldid = new String[i18nkey.length];
		for (int i = 0; i < i18nkey.length; i++) {
			query = "Select FieldId from CustomerFieldDefinition where EditProfile_i18nKey like '%" + i18nkey[i] + "%'";
			fieldid[i] = lavanteUtils.fetchDBdata(query);
			query = " Insert into CustomerFieldVGMetadata (  FieldDefinitionID  ,IsVisible)  VALUES (  " + fieldid[i]
					+ "   ,1 )";
			lavanteUtils.UpdateDB(query);
		}
		return fieldid;
	}

	private void clearCustomFields(String[] fieldsIDS, String[] i18nkeyss, String[] keyvalueI18nkeys)
			throws FileNotFoundException, IOException, SQLException {

		for (int i = 0; i < fieldsIDS.length; i++) {
			query = "delete from FieldValue where FieldId = " + fieldsIDS[i] + "";
			lavanteUtils.UpdateDB(query);
			query = "delete from CustomerFieldVGMetadata where FieldDefinitionID = " + fieldsIDS[i] + "";
			lavanteUtils.UpdateDB(query);
			query = "delete from CustomerFieldDefinition where FieldId = " + fieldsIDS[i] + "";
			lavanteUtils.UpdateDB(query);
		}

		for (int i = 0; i < keyvalueI18nkeys.length; i++) {
			query = "delete from KeyValue where CategoryID=23 and ValueDescription_i18nKey='" + keyvalueI18nkeys[i]
					+ "'";
			lavanteUtils.UpdateDB(query);
		}

		for (int i = 0; i < i18nkeyss.length; i++) {
			query = "delete from UserTranslation where LanguageID=50 and i18nKey='" + i18nkeyss[i] + "'";
			lavanteUtils.UpdateDB(query);
			query = "delete from keyvalue where ValueDescription_i18nKey='" + i18nkeyss[i] + "'";
			lavanteUtils.UpdateDB(query);
			query = "delete from I18NKey where i18nKey='" + i18nkeyss[i] + "'";
			lavanteUtils.UpdateDB(query);
		}

	}

	/**
	 * SIM-9908 As a customer user, I can configure visibility option for a
	 * custom field based on collection of other custom field values
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void editConfigureFields001Test() throws Exception {
		System.out.println("------------Test Started for verify edit configure fields Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify edit configure fields Test in Edit Profile at :" + currenttime());

		// DB queries to create collection of custom fields
		String i18nkey1 = "OrginalField" + randomnum();
		String i18nkey2 = "SecondDepField" + randomnum();
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Calendar cal = Calendar.getInstance();
		String keyValueId = dateFormat.format(cal.getTime());
		String[] i18nkeys = { i18nkey1, i18nkey2 };

		insertIntoI18nkeyUserTranslation(i18nkeys);
		query = "update CustomerFieldDefinition SET  FieldDataTypeId=2 , KeyCategoryId =null  where SubSectionDefinitionId=202";
		lavanteUtils.UpdateDB(query);
		query = "update CustomerSubSectionDefinition set ConditionValue = null where SectionID=86 and SubSectionDefinitionId=204";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId, KeyCategoryId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove  ,isViewableBySupplier ,SubSectionDefinitionId, CreatedBy  )  VALUES "
				+ " ( '" + i18nkey1 + "'   ,5    ,0    ,'" + i18nkey1 + "',23    ,'" + i18nkey1 + "'    ,'" + i18nkey1
				+ "'   ,0   ,0" + "   ,1   ,0   ,0      ,1  ," + subSectionID01 + ", 'EditConfigureFields' )";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier,CreatedBy)  VALUES "
				+ " ( '" + i18nkey2 + "'   ,2    ,0    ,'" + i18nkey2 + "'    ,'" + i18nkey2 + "'    ,'" + i18nkey2
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID02 + "    ,1  ,'EditConfigureFields' )";
		lavanteUtils.UpdateDB(query);

		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId + ",23, 'AutoField', 1,1, '" + i18nkey1 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey1 + "'";
		keyValue = lavanteUtils.fetchDBdata(keyValue);

		String jason = "  {\"Conditions\":[{\"UIFieldId\":\"" + i18nkey1 + "\",\"Value\":\"" + keyValue
				+ "\",\"Type\":\"Checkbox\"}]}";

		query = "update CustomerSubSectionDefinition set ConditionValue ='" + jason
				+ "' where SubSectionDefinitionId = 204";
		lavanteUtils.UpdateDB(query);

		String fieldIDs[] = insertIntoCustomerFieldVGMetadata(i18nkeys);

		// Testing functionality starts

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		
		lavanteUtils.waitForTime(4000);
		WebElement ele = driver.findElement(By.xpath("//label[starts-with(text(),'" + i18nkey1 + "')]/preceding-sibling::input[1]"));
		lavanteUtils.fluentwait(ele);
		lavanteUtils.selectChkBox(ele, "yes");
		lavanteUtils.waitForTime(1000);
		WebElement ele1 = driver.findElement(By.cssSelector("textarea[id='" + i18nkey2 + "']"));
		lavanteUtils.fluentwait(ele1);
		ele1.sendKeys(i18nkey1 + i18nkey2);
		lavanteUtils.waitForTime(2000);
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.waitForTime(2000);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);
		
		dataMap.put("maintab","Enterprise");
		dataMap.put("subtab", "CustomFields");
		enviewSupplier.selectTab(dataMap);
		lavanteUtils.waitForTime(4000);

		String expectedFields = i18nkey1;
		WebElement obj1 = driver.findElement(By.xpath("//label[@for='" + i18nkey1 + "']/parent::td[1]/following-sibling::td[1]"));
		String actaulFields = lavanteUtils.getText(obj1);
		Boolean flag = false;
		if (expectedFields.equals(actaulFields)) {
			flag = true;
		}
		Reporter.log("Verifying one to one mapping custom field in view supplier page, Expected : " + expectedFields
				+ " Actual :" + actaulFields);
		Assert.assertTrue(flag, "Verifying one to one mapping custom field in view supplier page, Expected : "
				+ expectedFields + " Actual :" + actaulFields);

		String secExpectedField = i18nkey1 + i18nkey2;
		WebElement obj2 = driver
				.findElement(By.xpath("//label[@for='" + i18nkey2 + "']/parent::td[1]/following-sibling::td[1]"));
		String secActaulField = lavanteUtils.getText(obj2);
		Boolean flag1 = false;
		if (secExpectedField.equals(secActaulField)) {
			flag1 = true;
		}
		Reporter.log("Verifying one to one mapping seconday section custom field in view supplier page, Expected : "
				+ secExpectedField + " Actual :" + secActaulField);
		Assert.assertTrue(flag1,
				"Verifying one to one mapping seconday section custom field in view supplier page, Expected : "
						+ secExpectedField + " Actual :" + secActaulField);

		// Clearing created custom fields
		String[] keyValues = { keyValue };
		clearCustomFields(fieldIDs, i18nkeys, keyValues);

		Reporter.log("Test end for verify edit configure fields Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-9908 As a customer user, I can configure visibility option for a
	 * custom field based on collection of other custom field values
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void editConfigureFields002Test() throws Exception {
		System.out.println("------------Test Started for verify edit configure fields Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify edit configure fields Test in Edit Profile at :" + currenttime());

		// DB queries to create collection of custom fields
		String i18nkey1 = "OrginalField" + randomnum();
		String i18nkey2 = "SecondDepField" + randomnum();
		DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
		Calendar cal = Calendar.getInstance();
		String keyValueId = dateFormat.format(cal.getTime());
		String[] i18nkeys = { i18nkey1, i18nkey2 };

		insertIntoI18nkeyUserTranslation(i18nkeys);
		query = "update CustomerFieldDefinition SET  FieldDataTypeId=2 , KeyCategoryId =null  where SubSectionDefinitionId=202";
		lavanteUtils.UpdateDB(query);
		query = "update CustomerSubSectionDefinition set ConditionValue = null where SectionID=86 and SubSectionDefinitionId=204";
		lavanteUtils.UpdateDB(query);

		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId, KeyCategoryId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove  ,isViewableBySupplier ,SubSectionDefinitionId  )  VALUES "
				+ " ( '" + i18nkey1 + "'   ,5    ,0    ,'" + i18nkey1 + "',23    ,'" + i18nkey1 + "'    ,'" + i18nkey1
				+ "'   ,0   ,0" + "   ,1   ,0   ,0      ,1  ," + subSectionID01 + " )";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '" + i18nkey2 + "'   ,2    ,0    ,'" + i18nkey2 + "'    ,'" + i18nkey2 + "'    ,'" + i18nkey2
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID02 + "    ,1   )";
		lavanteUtils.UpdateDB(query);
		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId + ",23, 'AutoField', 1,1, '" + i18nkey1 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey1 + "'";
		keyValue = lavanteUtils.fetchDBdata(keyValue);

		String keyValueId1 = keyValueId + 9;
		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId1 + ",23, 'AutoField', 1,1, '" + i18nkey2 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue1 = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey2 + "'";
		keyValue1 = lavanteUtils.fetchDBdata(keyValue1);

		String jason = "  {\"Conditions\":[{\"UIFieldId\":\"" + i18nkey1 + "\",\"Value\":\"" + keyValue + ","
				+ keyValue1 + "\",\"Type\":\"Checkbox\"}]}";

		query = "update CustomerSubSectionDefinition set ConditionValue ='" + jason
				+ "' where SubSectionDefinitionId = 204";
		lavanteUtils.UpdateDB(query);
		String fieldIDs[] = insertIntoCustomerFieldVGMetadata(i18nkeys);

		// Testing functionality starts

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		
		lavanteUtils.refreshPage();
		WebElement ele = driver
				.findElement(By.xpath("//label[starts-with(text(),'" + i18nkey1 + "')]/preceding-sibling::input[1]"));
		lavanteUtils.fluentwait(ele);
		lavanteUtils.selectChkBox(ele, "yes");
		lavanteUtils.waitForTime(1000);

		WebElement ele1 = driver.findElement(By.cssSelector("textarea[id='" + i18nkey2 + "']"));
		lavanteUtils.fluentwait(ele1);
		ele1.sendKeys(i18nkey1 + i18nkey2);
		lavanteUtils.waitForTime(2000);
		Reporter.log(
				"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"
						+ ele1.isDisplayed());
		Assert.assertTrue(ele1.isDisplayed(),
				"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"
						+ ele1.isDisplayed());
		lavanteUtils.selectChkBox(ele, "no");

		WebElement ele0 = driver
				.findElement(By.xpath("//label[starts-with(text(),'" + i18nkey2 + "')]/preceding-sibling::input[1]"));
		lavanteUtils.fluentwait(ele0);
		lavanteUtils.selectChkBox(ele0, "yes");
		lavanteUtils.waitForTime(1000);
		WebElement ele2 = driver.findElement(By.cssSelector("textarea[id='" + i18nkey2 + "']"));
		lavanteUtils.fluentwait(ele2);
		ele1.sendKeys(i18nkey1 + i18nkey2);
		lavanteUtils.waitForTime(2000);
		Reporter.log(
				"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"
						+ ele2.isDisplayed());
		Assert.assertTrue(ele2.isDisplayed(),
				"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"
						+ ele2.isDisplayed());

		String[] keyValues = { keyValue, keyValue1 };
		// Clearing created custom fields
		clearCustomFields(fieldIDs, i18nkeys, keyValues);

		Reporter.log(
				"Test end for verify edit configure fields Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");
	}

	/**
	 * SIM-9908 As a customer user, I can configure visibility option for a
	 * custom field based on collection of other custom field values
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void editConfigureFields003Test() throws Exception {
		System.out.println(
				"------------Test Started for verify edit configure fields Test in Edit Profile-------------------");
		Reporter.log(
				"Test Started for verify edit configure fields Test in Edit Profile at :" + currenttime());
		// DB queries to create collection of custom fields
		String i18nkey1 = "OrgField" + randomnum();
		String i18nkey2 = "FirstDepField" + randomnum();
		String i18nkey3 = "SecDepField" + randomnum();
		DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
		Calendar cal = Calendar.getInstance();
		String keyValueId = dateFormat.format(cal.getTime());
		String[] i18nkeys = { i18nkey1, i18nkey2, i18nkey3 };

		insertIntoI18nkeyUserTranslation(i18nkeys);
		query = "update CustomerFieldDefinition SET  FieldDataTypeId=2 , KeyCategoryId =null  where SubSectionDefinitionId=202";
		lavanteUtils.UpdateDB(query);
		query = "update CustomerSubSectionDefinition set ConditionValue = null where SectionID=86 and SubSectionDefinitionId=204";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId, KeyCategoryId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove  ,isViewableBySupplier ,SubSectionDefinitionId  )  VALUES "
				+ " ( '" + i18nkey1 + "'   ,5    ,0    ,'" + i18nkey1 + "',23    ,'" + i18nkey1 + "'    ,'" + i18nkey1
				+ "'   ,0   ,0" + "   ,1   ,0   ,0      ,1  ," + subSectionID01 + " )";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '" + i18nkey2 + "'   ,2    ,0    ,'" + i18nkey2 + "'    ,'" + i18nkey2 + "'    ,'" + i18nkey2
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID02 + "    ,1   )";
		lavanteUtils.UpdateDB(query);

		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,KeyCategoryId,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '" + i18nkey3 + "'   ,4    ,0    ,'" + i18nkey3 + "',23    ,'" + i18nkey3 + "'    ,'" + i18nkey3
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID01 + "    ,1   )";
		lavanteUtils.UpdateDB(query);

		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId + ",23, 'AutoField', 1,1, '" + i18nkey1 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey1 + "'";
		keyValue = lavanteUtils.fetchDBdata(keyValue);

		String keyValueId1 = keyValueId + 7;
		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId1 + ",23, 'AutoField', 1,1, '" + i18nkey3 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue1 = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey3 + "'";
		keyValue1 = lavanteUtils.fetchDBdata(keyValue1);

		String jason = "  {\"Conditions\":[{\"UIFieldId\":\"" + i18nkey1 + "\",\"Value\":\"" + keyValue
				+ "\",\"Type\":\"Checkbox\"},{\"UIFieldId\":\"" + i18nkey3 + "\",\"Value\":\"" + keyValue
				+ "\",\"Type\":\"Radio\"}]}";

		query = "update CustomerSubSectionDefinition set ConditionValue ='" + jason
				+ "' where SubSectionDefinitionId = 204";
		lavanteUtils.UpdateDB(query);
		String fieldIDs[] = insertIntoCustomerFieldVGMetadata(i18nkeys);

		// Testing functionality starts
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		WebElement ele = driver.findElement(By.cssSelector("input[type='checkbox'][value='" + keyValue + "']"));
		lavanteUtils.fluentwait(ele);
		lavanteUtils.selectChkBox(ele, "yes");
		lavanteUtils.waitForTime(1000);
		WebElement ele1 = driver.findElement(By.cssSelector("input[type='radio'][value='" + keyValue + "']"));
		lavanteUtils.fluentwait(ele1);
		lavanteUtils.click(ele1);
		lavanteUtils.waitForTime(1000);

		WebElement ele2 = driver.findElement(By.cssSelector("textarea[id='" + i18nkey2 + "']"));
		lavanteUtils.fluentwait(ele2);
		ele2.sendKeys(i18nkey1 + i18nkey2);
		lavanteUtils.waitForTime(2000);
		Reporter.log(
				"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"
						+ ele2.isDisplayed());
		Assert.assertTrue(ele2.isDisplayed(),
				"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"
						+ ele2.isDisplayed());

		String[] keyValues = { keyValue, keyValue1 };
		// Clearing created custom fields
		clearCustomFields(fieldIDs, i18nkeys, keyValues);

		Reporter.log(
				"Test end for verify edit configure fields Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");
	}

	/**
	 * SIM-9908 As a customer user, I can configure visibility option for a
	 * custom field based on collection of other custom field values
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void editConfigureFields004Test() throws Exception {
		System.out.println(	"------------Test Started for verify edit configure fields Test in Edit Profile-------------------");
		Reporter.log(				"Test Started for verify edit configure fields Test in Edit Profile at :" + currenttime());
		// DB queries to create collection of custom fields
		String i18nkey1 = "OrgField" + randomnum();
		String i18nkey2 = "FirstDepField" + randomnum();
		String i18nkey3 = "SecDepField1" + randomnum();
		String i18nkey4 = "SecDepField2" + randomnum();
		DateFormat dateFormat = new SimpleDateFormat("ddHHmmss");
		Calendar cal = Calendar.getInstance();
		String keyValueId = dateFormat.format(cal.getTime());
		String[] i18nkeys = { i18nkey1, i18nkey2, i18nkey3, i18nkey4 };

		insertIntoI18nkeyUserTranslation(i18nkeys);
		query = "update CustomerFieldDefinition SET  FieldDataTypeId=2 , KeyCategoryId =null  where SubSectionDefinitionId=202";
		lavanteUtils.UpdateDB(query);
		query = "update CustomerSubSectionDefinition set ConditionValue = null where SectionID=86 and SubSectionDefinitionId=204";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId, KeyCategoryId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove  ,isViewableBySupplier ,SubSectionDefinitionId  )  VALUES "
				+ " ( '" + i18nkey1 + "'   ,5    ,0    ,'" + i18nkey1 + "',23    ,'" + i18nkey1 + "'    ,'" + i18nkey1
				+ "'   ,0   ,0" + "   ,1   ,0   ,0      ,1  ," + subSectionID01 + " )";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '" + i18nkey2 + "'   ,2    ,0    ,'" + i18nkey2 + "'    ,'" + i18nkey2 + "'    ,'" + i18nkey2
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID02 + "    ,1   )";
		lavanteUtils.UpdateDB(query);
		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '" + i18nkey4 + "'   ,2    ,1    ,'" + i18nkey4 + "'    ,'" + i18nkey4 + "'    ,'" + i18nkey4
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID02 + "    ,1   )";
		lavanteUtils.UpdateDB(query);

		query = "Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,KeyCategoryId,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '" + i18nkey3 + "'   ,4    ,0    ,'" + i18nkey3 + "',23    ,'" + i18nkey3 + "'    ,'" + i18nkey3
				+ "'   ,0   ,0" + "   ,1   ,0   ,0   ," + subSectionID01 + "    ,1   )";
		lavanteUtils.UpdateDB(query);

		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId + ",23, 'AutoField', 1,1, '" + i18nkey1 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey1 + "'";
		keyValue = lavanteUtils.fetchDBdata(keyValue);

		String keyValueId1 = keyValueId + 7;
		query = "Insert into KeyValue ( KeyValueID,CategoryID, ValueDescription, IsVisible, DisplayOrder,ValueDescription_i18nKey) VALUES ("
				+ keyValueId1 + ",23, 'AutoField', 1,1, '" + i18nkey3 + "' )";
		lavanteUtils.UpdateDB(query);
		String keyValue1 = "select KeyValueID from KeyValue where ValueDescription_i18nKey = '" + i18nkey3 + "'";
		keyValue1 = lavanteUtils.fetchDBdata(keyValue1);

		String jason = "  {\"Conditions\":[{\"UIFieldId\":\"" + i18nkey1 + "\",\"Value\":\"" + keyValue
				+ "\",\"Type\":\"Checkbox\"},{\"UIFieldId\":\"" + i18nkey3 + "\",\"Value\":\"" + keyValue
				+ "\",\"Type\":\"Radio\"}]}";

		query = "update CustomerSubSectionDefinition set ConditionValue ='" + jason
				+ "' where SubSectionDefinitionId = 204";
		lavanteUtils.UpdateDB(query);
		String fieldIDs[] = insertIntoCustomerFieldVGMetadata(i18nkeys);

		// Testing functionality starts
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		WebElement ele = driver.findElement(By.cssSelector("input[type='checkbox'][value='" + keyValue + "']"));
		lavanteUtils.fluentwait(ele);
		lavanteUtils.selectChkBox(ele, "yes");
		lavanteUtils.waitForTime(1000);
		WebElement ele1 = driver.findElement(By.cssSelector("input[type='radio'][value='" + keyValue + "']"));
		lavanteUtils.fluentwait(ele1);
		lavanteUtils.click(ele1);
		lavanteUtils.waitForTime(1000);

		WebElement ele2 = driver.findElement(By.cssSelector("textarea[id='" + i18nkey2 + "']"));
		lavanteUtils.fluentwait(ele2);
		ele2.sendKeys(i18nkey1 + i18nkey2);
		lavanteUtils.waitForTime(2000);
		WebElement ele3 = driver.findElement(By.cssSelector("textarea[id='" + i18nkey4 + "']"));
		lavanteUtils.fluentwait(ele3);
		ele3.sendKeys(i18nkey2 + i18nkey3);
		lavanteUtils.waitForTime(2000);
		Reporter.log("Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"	+ ele2.isDisplayed());
		Assert.assertTrue(ele2.isDisplayed(),"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"	+ ele2.isDisplayed());
		Reporter.log("Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :"	+ ele3.isDisplayed());
		Assert.assertTrue(ele3.isDisplayed(),"Verifying one to two mapping seconday section custom field in view supplier page, Expected : true, Actual :" + ele3.isDisplayed());

		String[] keyValues = { keyValue, keyValue1 };
		// Clearing created custom fields
		clearCustomFields(fieldIDs, i18nkeys, keyValues);

		Reporter.log("Test end for verify edit configure fields Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");
	}
	
	@AfterMethod
	public void Setupaftermethod(){
				
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("Cancel", "");
		eneditProfile.formAction(dataMap);
		
	}

	@AfterClass
	public void SetupafterClassmethod() {
		lavanteUtils.refreshPage();
		enobjhomePage.logout();
		quitBrowser();
	}

}
