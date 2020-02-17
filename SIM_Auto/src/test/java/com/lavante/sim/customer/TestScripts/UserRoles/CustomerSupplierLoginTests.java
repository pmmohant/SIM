package com.lavante.sim.customer.TestScripts.UserRoles;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class CustomerSupplierLoginTests extends PageInitiator {
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
		List listofdatafrm = lavanteUtils.login("LavanteSupportRole", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		// Supplier Tab
		LdataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(LdataMap);

	}

	/**
	 * Customer Supplier Login : Verify Customers should be required to change
	 * the password after their first login
	 * 
	 * 
	 * @author Subhash.BV
	 * 
	 * @param dataMap
	 * 
	 * @throws Exception
	 */
	//@Test(dataProvider = "InviteSupplierEmail", dataProviderClass = SupplierRegistrationDataProvider.class,groups="InviteSupplier")
	public void customerSupplierChangePasswordPageTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for customerSupplierChangePasswordPageTest : " + LavanteUtils.currenttime());

		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		int customerId = 53;
		String query = "SELECT  max(C.Email) FROM [Login] L INNER JOIN Supplier_Contact_Map SCM ON L.ContactID = SCM.ContactID INNER JOIN "
				+ " Contact C ON C.ContactID = L.ContactID INNER JOIN Relationship R ON SCM.LavanteUID = R.LavanteUID WHERE C.IsActive =1 AND "
				+ " L.IsActive= 1 AND L.IsLocked=0 AND C.IsTalentAgent=0 AND R.ProfileStatusID=4 AND  R.ProfileManagedBy_KVID=5102 and R.CustomerID not in ("
				+ customerId + ") ";
		String emailId = lavanteUtils.fetchDBdata(query);

		String getRelationshipId = "select * from Relationship where CustomerID=" + customerId + " and LavanteUID in "
				+ "(select LavanteUID from Supplier_Contact_Map where ContactID in "
				+ "(select ContactID from Contact where email='" + emailId + "'))";
		getRelationshipId = lavanteUtils.fetchDBdata(getRelationshipId);

		System.out.println(getRelationshipId);
		if (getRelationshipId != null) {
			String deleteQuery = "delete from ProfileStageProgress where RelationshipID=" + getRelationshipId + ""
					+ "delete from Relationship_CustomerOrganization_Map where RelationshipID=" + getRelationshipId + ""
					+ "delete from SupplierOutreach where RelationshipID=" + getRelationshipId + ""
					+ "delete from SupplierOutreachAccessCode where RelationshipID=" + getRelationshipId + ""
					+ "delete from SupplierOutreachLog where RelationshipID=" + getRelationshipId + ""
					+ "delete from Relationship where RelationshipID=" + getRelationshipId + " and CustomerID = "
					+ customerId + "";
			lavanteUtils.UpdateDB(deleteQuery);
		} // BY NEWID()
		dataMap.put("email", emailId);
		dataMap.put("SelectExistingMailId", "");
		dataMap.put("invite", "");
		dataMap.put("inviteorg", "Waste");
		
		String[] dataContent = enobjInvitenewSupplier.inviteNwSupp(dataMap);
		Reporter.log("Invite New Supp:"+dataContent[0]);

		String getContactName = "select ContactName from Contact where email='" + emailId + "'";
		dataContent[1] = lavanteUtils.fetchDBdata(getContactName);
		System.out.println(dataContent[0] + dataContent[1]);

		lavanteUtils.fluentwait(enobjhomePage.logoutbtn());
		enobjhomePage.logout();

		lavanteUtils.navigatetoAccSetup(dataContent);

		lavanteUtils.fluentwait(objSimAccSetupPages.nextbttn());
		lavanteUtils.click(objSimAccSetupPages.nextbttn());

		boolean flag = false;
		lavanteUtils.switchtoFrame(null);
		if (driver.getPageSource().contains("Please create a new password as your current password has expired")
				&& driver.getPageSource().contains("Reset Password")) {
			flag = true;
		}

		Reporter.log(" Verify Customers should be required to change the password after their first login");
		Assert.assertTrue(flag, " Verify Customers should be required to change the password after their first login");

	

		Reporter.log("Test Ended at:" + LavanteUtils.currenttime());
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjInvitenewSupplier.cancel();
		quitBrowser();
	}
	

}
