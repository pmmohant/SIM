package com.lavante.sim.customer.TestScripts.Invite;

import java.io.IOException;
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

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 25-11-2016 Created for UpdateInviteOrganization
 * 
 * @author Subhash.BV
 *
 */
public class UpdateInviteOrganization002 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String contactEmailId = null;

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
		List<?> listofdatafrm = lavanteUtils.login("UpdateInviteOrg", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		contactEmailId = LdataMap.get("supname");
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LdataMap.put("maintab", "Admin");
		LdataMap.put("subtab", "Division");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * SIM-9403 
	 * Create a inv org , Map to the user , Login and Verify whether its populated by default
	 * 
	 * @throws IOException
	 * @author Subhas.BV
	 */
	@Test
	public void validateInviteOrgInSupplierByCustomerLoginTest() throws Exception {
		Reporter.log("Test Started for validateInviteOrgInSupplierByCustomerLoginTest:" + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String creditName = "AutoSub" + lavanteUtils.randomnum() + customerID;
		String crediti18 = "Insert into I18NKey  (i18nKey) values ('" + creditName + "')";
		lavanteUtils.UpdateDB(crediti18);
		String uteft = "Insert into UserTranslation (i18nKey  ,LanguageID ,IsCustomerSpecific  ,UTFString) VALUES ( '"
				+ creditName + "'   ,50 ,0 ,'" + creditName + "')";
		lavanteUtils.UpdateDB(uteft);

		String CustOrgID = lavanteUtils.generateRandomNumber9OnLength(9);
		String insertNewOrg = "Insert into CustomerOrganization (CustomerOrganizationID, OrganizationName, CustomerID, CreatedBy, CreatedOn, OrganizationName_i18nKey) VALUES ("
				+ CustOrgID + ",'" + creditName + "', " + customerID + ", 'admin', getdate(), '" + creditName + "')";
		lavanteUtils.UpdateDB(insertNewOrg);

		String contactName = "select ContactName from Contact where Email='" + contactEmailId + "'";
		contactName = lavanteUtils.fetchDBdata(contactName);
		dataMap.put("ContactName", contactName);
		objUserPage.searchUserContactName(dataMap);
		
		objUserPage.editUser(dataMap);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(objUserPage.InvitingOrgSearchBox);
		lavanteUtils.waitForTime(3000);
		lavanteUtils.selectvalueFrmDpdn("" + creditName + "");
		lavanteUtils.click(objUserPage.AddNewUserSaveBtn);
		lavanteUtils.switchtoFrame(null);
	
		enobjhomePage.popupclose();
		enobjhomePage.logout();
		
		dataMap.put("username", contactEmailId);
		dataMap.put("password", InitProperties("password"));
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.fluentwait(enobjInvitenewSupplier.InviteNewSupplierLinkKbtn());
		lavanteUtils.click(enobjInvitenewSupplier.InviteNewSupplierLinkKbtn());

		String actualInvite = null;
		boolean flag = false;
		List<WebElement> invOrgs = enobjInvitenewSupplier.getSelectedInviteorgs();
		for (WebElement orgs : invOrgs) {
			if (creditName.equals(orgs.getText())) {
				System.out.println(creditName + " invite Supplier " + orgs);
				actualInvite = orgs.getText();
				flag = true;
				break;
			}
		}
		Reporter.log("All the inviting Orgs when inviting a supplier, a logged in user (other than admin or support) belongs to, would be selected by default, Expected : "	+ creditName + ", Actual : " + actualInvite);
		Assert.assertTrue(flag,"All the inviting Orgs when inviting a supplier, a logged in user (other than admin or support) belongs to, would be selected by default, Expected : "+ creditName + ", Actual : " + actualInvite);

		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjInvitenewSupplier.cancel();
		quitBrowser();
	}

}
