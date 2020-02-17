package com.lavante.sim.customer.TestScripts.Invite;

import java.util.ArrayList;
import java.util.Collections;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 07-10-2016 Created for Verifying SIM User Roles
 * 
 * @author Subhash.BV
 *
 */

public class UATInviteNewSupplierTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String loginemail="";
	String customerid="";
	
	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhash.BV
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(
			@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		// List listofdatafrm = lavanteUtils.login("Omnicare", browser);
		List listofdatafrm = lavanteUtils.login("Discovery", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		loginemail=LdataMap.get("username");
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	
	@BeforeMethod()
	public void before(){
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		enobjsupplierBasicSearch.formAction(dataMap);
	}

	/**
	 * 
	 * Verify that duplicate records of same supplier[ie same Supplier ID and
	 * same Supplier Name] does not exist in Contacts table showing duplicate
	 * contact email ids
	 * 
	 * @author Subhash.BV
	 * @throws Exception
	 * 
	 *     Replacement of CustomerSupplierSearchTC0007 -Auto Suggest
	 */
	 //@Test
	public void verifyDuplicateContactEmailIdTest() throws Exception {
		Reporter.log("Test Started for verifyDuplicateContactEmailIdTest : "	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("supplierName", "Autoo"+currenttime());
		dataMap.remove("suppgrp");
		String query = "select max(email) from Contact";
		String emailId = lavanteUtils.fetchDBdata(query);
		dataMap.put("email", emailId);
		dataMap.put("inviteorg", "ANY");
		dataMap.put("contactName", "ANY");
		dataMap.put("SaveExit", "");
		enobjInvitenewSupplier.inviteNwSupplier(dataMap);

		lavanteUtils.switchtoFrame(enobjInvitenewSupplier.IFRAMEverifyEmail().get(0));
		String actualMSG = lavanteUtils.getText(enobjInvitenewSupplier.GetMSGEmailExist());
		String expectedMSG = "This supplier may already exist";
		// Based on the supplier details provided by you, it appears that the
		// supplier you would like to invite already exists in the system. Take
		// a look at the supplier list below and resolve the same.</caption>
		System.out.println("Verify that duplicate records of same supplier does not exist in Contacts table showing duplicate contact email ids, Expected , "	+ expectedMSG + " ,Actual: , " + actualMSG);
		Reporter.log("Verify that duplicate records of same supplier does not exist in Contacts table showing duplicate contact email ids, Expected , "	+ expectedMSG + " ,Actual , " + actualMSG);
		Assert.assertTrue(	actualMSG.contains(expectedMSG),	"Verify that duplicate records of same supplier does not exist in Contacts table showing duplicate contact email ids, Expected , "	+ expectedMSG + " ,Actual , " + actualMSG);

		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * Invite new supplier Save & Exit Verify all the details entered for new
	 * supplier under view supplier
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void SaveExit(LinkedHashMap<String, String> dataMap)		throws Exception {
		Reporter.log("Test Started for inviteNewSupplierSaveExitTest : "+ currenttime());

		SoftAssert softAssert = new SoftAssert();

		Reporter.log("Invite New Supplier:");
		dataMap.put("SaveExit", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);

		String suppName = dataMap.get("supplierName");
		String inviteOrg = dataMap.get("inviteorg");
		String suppGroup = dataMap.get("suppgrp");
		String contactName = dataMap.get("contactName");
		String email = dataMap.get("email");
		dataMap.clear();
		dataMap.put("supplierName", suppName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		enobjsupplierPage.selectChangeView("Invites");
		String actualSuppName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		softAssert.assertEquals(actualSuppName, suppName," Supplier Name doesn't match");
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Division", 0),		inviteOrg, "Business Unit doesn't match");
		softAssert.assertEquals(	enobjsupplierPage.getColumnText("Supplier Contact", 0),		contactName, "Contactname doesn't match");
		String expStatus = enobjsupplierPage.getColumnText("Status", 0);
		Reporter.log("Invited new supplier, Save & Exit with supplier name, Expected , "		+ suppName + " ,Actual, " + actualSuppName);
		Reporter.log("Invited new supplier, Save & Exit with business unit, Expected , "	+ inviteOrg + " ,Actual, " + enobjsupplierPage.getColumnText("Division", 0));

		enviewSupplier.clickOnSupplier(suppName);

		String data = enviewSupplier.InviteStatus().getText().trim();
		if (data.contains(":")) {
			String actualStatus[] = data.split(":");
			data = actualStatus[1];
			System.out.println("Invite ActualStatus:" + actualStatus[1]);
		}
		softAssert.assertEquals(data.trim(), expStatus," Invite profile status doesn't match");
		Reporter.log("Invite profile status, Expected , " + expStatus+ " ,Actual, " + data.trim());

		dataMap.put("maintab", "Enterprise");
		dataMap.put("subtab", "Onboarding");
		enviewSupplier.selectTab(dataMap);

		softAssert.assertEquals(enviewSupplier.BusinessUnit().get(0).getText(),inviteOrg, "Business unit doesn't match");
		softAssert.assertEquals(enviewSupplier.SuppContactName().get(0).getText(), contactName, "Supplier Contact Name doesn't match");
		softAssert.assertEquals(enviewSupplier.Email().get(0).getText(), email,	"Supplier email doesn't match");

		dataMap.put("maintab", "Enterprise");
		dataMap.put("subtab", "HeaderInformation");
		enviewSupplier.selectTab(dataMap);
		lavanteUtils.fluentwait(enviewSupplier.SuppGroup());

		softAssert.assertEquals(enviewSupplier.SuppContactName().get(0).getText(), contactName,	"Supplier Contact Name doesn't match under Header information");
	//	softAssert.assertEquals(enviewSupplier.SuppGroup().getText(),suppGroup,	"Supplier Group Name doesn't match under Header information");
		softAssert.assertEquals(enviewSupplier.BusinessUnit().get(0).getText(),	inviteOrg,	"Business unit doesn't match under Header information");
		softAssert.assertEquals(enviewSupplier.Email().get(0).getText(), email,	"Supplier email doesn't match under Header information");

		
		dataMap.put("maintab", "Status");
		dataMap.put("subtab", "ProfileStage");
		enviewSupplier.selectTab(dataMap);
		lavanteUtils.fluentwait(enviewSupplier.supplierName());
		
		//SIM-20018
		softAssert.assertTrue(enviewSupplier.ListProfileStage().size()==1,"Only Loaded should be shown");
		softAssert.assertTrue(enviewSupplier.ListProfileStage().get(0).getText().equalsIgnoreCase("Loaded"),"Only Loaded should be shown");
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * Invite new supplier Save & Exit with duplicate email Select none of the
	 * above option under Supplier Information dialog Verify all the details
	 * entered for new supplier in the supplier search table
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void DuplicateEmailSaveExitNONE(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for verifyDuplicateEmailNoneSaveExit : "	+ currenttime());

		SoftAssert softAssert = new SoftAssert();

		String query = "select MAX(c.Email) from Contact c,supplier_contact_map sm, Relationship r "
				+ "where c.ContactID = sm.ContactID and sm.LavanteUID = r.LavanteUID and r.CustomerID="+customerid;
		String emailId = lavanteUtils.fetchDBdata(query);

		Reporter.log("Invite New Supplier:");

		dataMap.put("email", emailId);
		dataMap.put("SaveExit", "");
		dataMap.put("DuplicateEmail", "None");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		query="select ContactName from contact where email='"+emailId+"'";
		String contactName = fetchDBdata(query);
		/*String expectedMsg ="Supplier has been created . You will now see this invitation on the supplier search screen ";
		String actualMsg = dataMap.get("ErrorMsg");
		softAssert.assertTrue(actualMsg.contains(expectedMsg), "Verify that new supplier has been created for 'None of the above' option "
				+ "Expected, "+expectedMsg+ " Actual, "+actualMsg);
		*/
		String actualSuppName;
		String suppName = dataMap.get("supplierName");
		dataMap.put("supplierName", suppName);
		dataMap.put("BusinessName", contactName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		enobjsupplierPage.selectChangeView("Invites");
		
		String inviteOrg = dataMap.get("inviteorg");
		
		actualSuppName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		softAssert.assertEquals(actualSuppName, suppName," Supplier Name doesn't match in the table");
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Division", 0),	inviteOrg, "Business Unit doesn't match in the table");
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Supplier Contact", 0),contactName, "Contactname doesn't match in the table");
		
		Reporter.log("A new supplier is invited when \"None of the above\" is selected in Supplier Information dialog with Supplier Name, Expected, "+ suppName+" Actual, "+actualSuppName);
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * Invite new supplier Save & Exit with duplicate email 
	 * Select existing supplier option under Supplier Information dialog 
	 * Verify message displayed for extended supplier
	 * Verify supplier name and invite org for extended supplier in the supplier search table
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void DeleteDuplicateInvite(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for verifyDuplicateEmailWithSupplierSaveExitAndDelete : "+ currenttime());

		SoftAssert softAssert = new SoftAssert();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		//query to get already existing email id
		String query = "select MAX(c.Email) from Contact c,supplier_contact_map sm, Relationship r "
				+ "where c.ContactID = sm.ContactID and sm.LavanteUID = r.LavanteUID and r.CustomerID="+customerid;
		String emailId = lavanteUtils.fetchDBdata(query);

		//query to get existing supplier from email id fetched from db
		String query1 = "select MAX(s.SupplierName) from Contact c,supplier_contact_map sm, Relationship r,"
				+ "Supplier s	where c.ContactID = sm.ContactID and sm.LavanteUID = r.LavanteUID and r.CustomerID="+customerid
				+ " and s.LavanteUID = r.LavanteUID and c.Email='"+ emailId + "'";
		String suppName = lavanteUtils.fetchDBdata(query1);

		// query to get inviting org which is not associated with the supplier
		String query2 = "select min(ut.UTFString) from CustomerOrganization co,UserTranslation ut where ut.i18nKey=co.OrganizationName_i18nKey"
				+ " and co.CustomerID="	+customerid
				+ " and ut.LanguageID=50 and ut.UTFString not in (select ut.UTFString from CustomerOrganization co , "
				+ "UserTranslation ut,Supplier s,Relationship r,Invite i,Relationship_CustomerOrganization_Map rc where "
				+ "ut.i18nKey = co.OrganizationName_i18nKey AND ut.languageId = 50  and s.LavanteUID = r.LavanteUID "
				+ "and i.RelationshipId = r.RelationshipID and rc.CustomerOrganizationID = co.CustomerOrganizationID "
				+ "and rc.RelationshipID = r.RelationshipID and r.CustomerID="+  customerid 
				+ "  and s.SupplierName='" + suppName + "');";

		String inviteOrg = lavanteUtils.fetchDBdata(query2);
		Reporter.log("Invite New Supplier:");

		dataMap.put("inviteorg", inviteOrg.trim());
		dataMap.put("email", emailId);
		dataMap.put("SaveExit", "");
		dataMap.put("DuplicateEmail", suppName);
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		
	/*	String expectedMsg ="The selected supplier "+suppName+" already exists and the "+ "invite has been extended to this supplier with selected divisions.";
		String actualMsg = dataMap.get("ErrorMsg");
		softAssert.assertTrue(actualMsg.contains(expectedMsg), "Verify that duplicate records of same supplier does not exist and the "
				+ "invite has been extended to the supplier with selected division, Expected, "+expectedMsg+ " Actual, "+actualMsg);*/

		dataMap.put("supplierName", suppName);
		dataMap.put("InviteOrg", inviteOrg.trim());
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		enobjsupplierPage.selectChangeView("Invites");
		
		//Verify the merged inviting org with the supplier
		String actualSuppName, actualInviteOrg;
		actualSuppName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		actualInviteOrg = enobjsupplierPage.getColumnText("Division", 0);
		String iactualInviteOrg = enobjsupplierPage.getColumnText("Invitation", 0);
		softAssert.assertEquals(actualSuppName, suppName," Supplier Name doesn't match in the table");
		softAssert.assertEquals(actualInviteOrg, inviteOrg.trim(), "Business Unit doesn't match in the table");

		Reporter.log("Invite new supplier with already existing email id and a Supplier is selected in Supplier Information dialog with Supplier Name, Expected, "
				+ suppName+" Actual, "+actualSuppName+" and Inviting Org, Expected, "+inviteOrg.trim()+" Actual, "+actualInviteOrg);
		
		dataMap.clear();
		dataMap.put("Search", "");
		dataMap.put("invitationId",iactualInviteOrg);
		enobjsupplierBasicSearch.search(dataMap);
		
		
		dataMap.put("supplierName", suppName);
		dataMap.put("Invitation", "");
		dataMap.put("DeleteInvite", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		softAssert.assertEquals(enobjsupplierPage.noDataFound().getText(), "No results","Supplier data is not deleted");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * Invite new supplier Save & Exit with duplicate email and inviting org 
	 * select existing supplier option under Supplier Information dialog  
	 * and verify the error message
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	//@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void DuplicateInviteOrgandEmail(	LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for verifyDuplicateEmailWithSupplierSaveExitNoMerge : "	+ currenttime());

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		String query = "select MAX(c.Email) from Contact c,supplier_contact_map sm, Relationship r "
				+ "where c.ContactID = sm.ContactID and sm.LavanteUID = r.LavanteUID and r.CustomerID="
				+ customerid;
		String emailId = lavanteUtils.fetchDBdata(query);

		String query1 = "select MAX(s.SupplierName) from Contact c,supplier_contact_map sm, Relationship r,"
				+ "Supplier s	where c.ContactID = sm.ContactID and sm.LavanteUID = r.LavanteUID and r.CustomerID="+ customerid
				+ " and s.LavanteUID = r.LavanteUID and c.Email='"+ emailId + "'";
		String suppName = lavanteUtils.fetchDBdata(query1);

		String query2 = "select max(ut.UTFString) from CustomerOrganization co , UserTranslation ut,Supplier s,Relationship r,"
				+ "Invite i,Relationship_CustomerOrganization_Map rc where ut.i18nKey = co.OrganizationName_i18nKey "
				+ "AND ut.languageId = 50  and s.LavanteUID = r.LavanteUID and i.RelationshipId = r.RelationshipID "
				+ "and rc.CustomerOrganizationID = co.CustomerOrganizationID and rc.RelationshipID = r.RelationshipID "
				+ "and r.CustomerID="+customerid+"  and s.SupplierName='"+suppName+"'"; 
		String inviteOrg = lavanteUtils.fetchDBdata(query2);

		Reporter.log("Invite New Supplier:");

		dataMap.put("inviteorg", inviteOrg.trim());
		dataMap.put("email", emailId);
		dataMap.put("SaveExit", "");
		dataMap.put("DuplicateEmail", suppName);
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
/*
		String expectedMsg = suppName+" has already been invited by "+inviteOrg.trim();
		String actualMsg = dataMap.get("ErrorMsg");
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Verify that profile has been merged with existing supplier and you can extend invite to other divisions, Expected, "
				+ expectedMsg+" Actaul, "+actualMsg);
		Reporter.log("Verify that profile has been merged with existing supplier and you can extend invite to other divisions, Expected, "
				+ expectedMsg+" Actaul, "+actualMsg);*/
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * Send Invite-  Invite new supplier Send Invitation Verify all the details entered for
	 * 					new supplier under view supplier
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void SendInvite(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for inviteNewSupplierSendInvite : "+ currenttime());

		SoftAssert softAssert = new SoftAssert();

		Reporter.log("Invite New Supplier:");
		dataMap.put("Next", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);
		dataMap.remove("Next");
		click(enobjInvitenewSupplier.NextBtn());
		lavanteUtils.waitForTime(4000);
		dataMap.put("invite", "");
		enobjInvitenewSupplier.formSuppAction(dataMap);

		String actualSuppName;
		String suppName = dataMap.get("supplierName");
		String inviteOrg = dataMap.get("inviteorg");
		//String suppGroup = dataMap.get("suppgrp");
		String contactName = dataMap.get("contactName");
		String email = dataMap.get("email");
		System.out.println("suppName is: " + suppName + " ContactName: "+ contactName);
		dataMap.put("supplierName", suppName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		enobjsupplierPage.selectChangeView("Invites");
		
		actualSuppName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		softAssert.assertEquals(actualSuppName, suppName," Supplier Name doesn't match in the table");
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Division", 0),		inviteOrg, "Business Unit doesn't match in the table");
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Supplier Contact", 0),		contactName, "Contactname doesn't match in the table");
		String expStatus = enobjsupplierPage.getColumnText("Status", 0);
		
		Reporter.log("Invited new supplier, Send Invite with supplier name, Expected , "		+ suppName + " ,Actual, " + actualSuppName);
		Reporter.log("Invited new supplier, Send Invite with business unit, Expected , "	+ inviteOrg + " ,Actual, " + enobjsupplierPage.getColumnText("Division", 0));

		enviewSupplier.clickOnSupplier(suppName);

		lavanteUtils.fluentwait(enviewSupplier.InviteStatus());
		String data = enviewSupplier.InviteStatus().getText().trim();
		if (data.contains(":")) {
			String actualStatus[] = data.split(":");
			data = actualStatus[1];
			System.out.println("Invite ActualStatus:" + actualStatus[1]);
		}
		softAssert.assertEquals(data.trim(), expStatus,	" Invite profile status doesn't match");
		Reporter.log("Invite profile status, Expected , " + expStatus+ " ,Actual, " + data.trim());

		dataMap.put("maintab", "Enterprise");
		dataMap.put("subtab", "Onboarding");
		enviewSupplier.selectTab(dataMap);

		softAssert.assertEquals(enviewSupplier.BusinessUnit().get(0).getText(),		inviteOrg, "Business unit doesn't match");
		softAssert.assertEquals(enviewSupplier.SuppContactName().get(0)		.getText(), contactName, "Supplier Contact Name doesn't match");
		softAssert.assertEquals(enviewSupplier.Email().get(0).getText(), email,	"Supplier email doesn't match");

		dataMap.put("subtab", "HeaderInformation");
		enviewSupplier.selectTab(dataMap);
		lavanteUtils.fluentwait(enviewSupplier.SuppGroup());

		softAssert.assertEquals(enviewSupplier.SuppContactName().get(0).getText(), contactName,		"Supplier Contact Name doesn't match under Header information");
		//softAssert.assertEquals(enviewSupplier.SuppGroup().getText(),			suppGroup,				"Supplier Group Name doesn't match under Header information");
		softAssert.assertEquals(enviewSupplier.BusinessUnit().get(0).getText(),	inviteOrg,	"Business unit doesn't match under Header information");
		softAssert.assertEquals(enviewSupplier.Email().get(0).getText(), email,"Supplier email doesn't match under Header information");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
	 * 
	 * Edit Invite -  Invite new supplier, SaveExit 
 	 *				  edit the created supplier
	 * 				  Verify all the edited details entered for new supplier under view supplier
	 *
	 * 
	 * @author Vidya C
	 * @throws Exception
	 * 
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void EditInvite(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for inviteNewSupplierSendInviteAndEdit : "	+ currenttime());

		SoftAssert softAssert = new SoftAssert();

		Reporter.log("Invite New Supplier:");
		dataMap.put("SaveExit", "");
		dataMap = enobjInvitenewSupplier.inviteNwSupplier(dataMap);

		String actualEditedSuppName;
		String expStatus = "Loaded";
		String suppName = dataMap.get("supplierName");
		String inviteOrg = dataMap.get("inviteorg");

		dataMap.put("supplierName", suppName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		enobjsupplierPage.selectChangeView("Invites");
			
		dataMap.put("supplierName", suppName);
		dataMap.put("Invitation", "");
		dataMap.put("EditInvite", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.clear();
		dataMap.put("supplierName", "any");
		dataMap.put("inviteorg", "01.01.018");
		dataMap.put("SaveExit", "");
		dataMap = enobjInvitenewSupplier.fillNewInviteDetails(dataMap);
		dataMap = enobjInvitenewSupplier.formSuppAction(dataMap);
		 
		suppName = dataMap.get("supplierName");
		//inviteOrg =inviteOrg+"#"+dataMap.get("inviteorg");
		
		dataMap.put("supplierName", suppName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		inviteOrg = dataMap.get("inviteorg");
		
		actualEditedSuppName = enobjsupplierPage.getColumnText("Supplier Name", 0);
		String actualInviteOrg = inviteOrg.replaceAll("#", " ");
		softAssert.assertEquals(actualEditedSuppName, suppName," Supplier Name doesn't match in the table");
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Division", 0),actualInviteOrg, "Business Unit doesn't match in the table");
		
		softAssert.assertEquals(enobjsupplierPage.getColumnText("Status", 0),expStatus,"Status doesn't match in the table");
		
		Reporter.log("Edited the supplier, Save Exit with edited supplier name, Expected , "+ suppName + " ,Actual, " + actualEditedSuppName);
		Reporter.log("Edited the supplier, Save Exit with edited business unit, Expected , "+ inviteOrg + " ,Actual, " + enobjsupplierPage.getColumnText("Division", 0));

		enviewSupplier.clickOnSupplier(suppName);
		
		String data = enviewSupplier.InviteStatus().getText().trim();
		if (data.contains(":")) {
			String actualStatus[] = data.split(":");
			data = actualStatus[1];
			System.out.println("Invite ActualStatus:" + actualStatus[1]);
		}
		softAssert.assertEquals(data.trim(), expStatus,	" Invite profile status doesn't match");
		Reporter.log("Invite profile status, Expected , " + expStatus+ " ,Actual, " + data.trim());

		dataMap.put("maintab", "Enterprise");
		dataMap.put("subtab", "Onboarding");
		enviewSupplier.selectTab(dataMap);

		List<String> exp=new ArrayList<String>();
		String[] division = inviteOrg.split("#");
		for(int i=0,j=division.length-1;i<division.length;i++) {
			exp.add(division[i]);
		}
		
		List<String> act=new ArrayList<String>();
		for(int i=0;i<enviewSupplier.BusinessUnit().size();i++) {
			act.add(enviewSupplier.BusinessUnit().get(i).getText());
		}
		
		Collections.sort(act);
		Collections.sort(exp);
		boolean flag=false;
		for(int i=0;i<enviewSupplier.BusinessUnit().size();i++) {
			softAssert.assertEquals(act.get(i),exp.get(i),"Divison Not Matched,Actuals:"+act.get(i)+",EXp:"+exp.get(i));
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Please Recheck");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.refreshPage();
		enobjInvitenewSupplier.cancel();
		enobjhomePage.popupclose();
			
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}
}