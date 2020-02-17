package com.lavante.sim.customer.TestScripts.Tasks.AddSupplierERPID;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 14-09-2016 Created for UAT Ended on 18-09-2016
 * 
 * @author Piramanayagam.S
 *
 *
 *
 *         select LavanteUID from Supplier where SupplierName='' select
 *         RelationshipID from Relationship where LavanteUID =315416 select *
 *         From Relationship_ERP_Map where RelationshipID=325996 select * from
 *         WF_ProcessDetails where RelationShipID=325996 select status from
 *         Jbpm_Task where processInstanceId=4423314 update Jbpm_Task set
 *         status='Reserved' where processInstanceId in (4423314)
 * 
 */
public class UATAddSupplierIDTC extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String uname = "";
	String customerID = "";
	String expSuppName = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
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

		List listofdatafrm = lavanteUtils.login("AddSupplierID", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		uname = LdataMap.get("username");
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "viewApprovalTasks");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("filterby", "Supplier ERP ID’s to update");
		dataMap.put("ALLSupplier", "");
		dataMap.put("ReAssign", "");
		dataMap.put("AssginTo", "Role");
		String query = "Select UserRoleName from LoginRole where UserRoleID=(select  UserRoleID from [Login] "
				+ "	where ContactID=(select ContactID from Contact where Email like '" + uname + "' ))";
		String role = lavanteUtils.fetchDBdata(query);

		dataMap.put("Role", role);
		enReassign.selectSupplierFormAction(dataMap);

		lavanteUtils.waitForTime(6000);
		dataMap.clear();

	}

	@BeforeMethod
	public void beforeMethod() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

	}

	/**
	 * Search a Supp with ERP ID and enter the same in the Add Supplier ID Page
	 * to verify duplicateness Verify the error message
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 *             Replacement of AddSupplierIDTC0003
	 */
	@Test
	public void DuplicateERPID() throws Exception {

		Reporter.log("Test Started for Duplicate ERP ID Check at:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("SupplierID", "1");
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		String sid = enobjsupplierPage.getColumnText("ERP", 0);
		String sname = enobjsupplierPage.getColumnText("Name", 0);

		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "addSupplierERPID");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("ERPID", sid);
		enaddSupplierERP.AddERPID(dataMap);

		String nwsname = enaddSupplierERP.ListSName().get(0).getText();
		expSuppName = nwsname;

		String x = enaddSupplierERP.duplicateERPmsg().getText();
		Reporter.log("Duplicate ERP ID entered:" + sid + ",Actual Error message for the same:" + x);
		softAssert.assertTrue(x.contains(sid), "Error message for addding duplicate ERP ID did not show up" + x);

		dataMap.put("Resolve", "Auto" + randomnum());
		enaddSupplierERP.ResolveErpID(dataMap);

		dataMap.clear();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("SupplierID", sid);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		String actsname = enobjsupplierPage.getColumnText("Name", 0);
		Reporter.log("Supplier name:" + nwsname + ",Actual:" + actsname);
		softAssert.assertEquals(actsname, nwsname, "Supplier name test,Expected:" + nwsname + ",Actuals:" + actsname);

		String actsid = enobjsupplierPage.getColumnText("ERP", 0);
		Reporter.log(" ERP ID entered:" + sid + ",Actual ERP ID:" + actsid);
		softAssert.assertTrue(actsid.contains(sid), "ERP ID test,Expected:" + sid + ",Actuals:" + actsid);

		dataMap.clear();
		dataMap.put("SupplierID", sid);
		dataMap.put("supplierName", sname);
		dataMap.put("Search", "");
		dataMap.put("InactiveSup", "");
		enobjsupplierBasicSearch.search(dataMap);

		Reporter.log("Old Resolved Deactivated supplier Test Verification:" + sname);
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		actsname = enobjsupplierPage.getColumnText("Name", 0);
		Reporter.log("Old Supplier name:" + sname + ",Actual :" + actsname);
		softAssert.assertEquals(actsname, sname, "Supplier name test,Expected:" + nwsname + ",Actuals:" + actsname);

		actsid = enobjsupplierPage.getColumnText("ERP", 0);
		Reporter.log(" ERP ID entered:" + sid + ",Actual ERP ID:" + actsid);
		softAssert.assertTrue(actsid.contains(sid), "ERP ID Multiple test,Expected:" + sid + ",Actuals:" + actsid);

		String actstatus = enobjsupplierPage.getColumnText("Status", 0);
		String expStatus = "Inactive";
		Reporter.log("  Old SupplierProfile Status:" + expStatus + ",Actual ERP ID:" + actstatus);
		softAssert.assertEquals(actstatus, expStatus,	" Old SupplierProfile Status ,Expected:" + expStatus + ",Actuals:" + actstatus);

		Reporter.log("Test Ended for Duplicate ERP ID Check at:" + currenttime());
		System.out.println("----------Test Ended---for Duplicate ERP ID Check--------");
	}

	/**
	 * Enter Erp id in the Add Supplier ID Page for multiple supplier at a time
	 * Verify the Erp id on the supplier page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 *             Replacement of -AddSupplierIDTC0001 -AddSupplierIDTC0002
	 * 
	 */
	@Test
	public void AddERPID() throws Exception {

		Reporter.log("Test Started for Multiple ERP ID  at:" + currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		boolean flag = false;
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "addSupplierERPID");
		enobjhomePage.selectTab(dataMap);

		String expERPID = "" + lavanteUtils.generateRandomNumber9OnLength(9);
		SoftAssert softAssert = new SoftAssert();
		if (enaddSupplierERP.ERPID().size() > 0) {

			dataMap.put("ERPID", expERPID);
			expSuppName = enaddSupplierERP.AddERPID(dataMap);

			dataMap.clear();

			dataMap.put("maintab", "Supplier");
			enobjhomePage.selectTab(dataMap);

			dataMap.put("supplierName", expSuppName);
			dataMap.put("Search", "");
			lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
			enobjsupplierBasicSearch.search(dataMap);

			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

			String actSname = enobjsupplierPage.getColumnText("Name", 0);
			Reporter.log("Supplier name:" + expSuppName + ",Actual ERP ID:" + actSname);
			softAssert.assertEquals(actSname, expSuppName,	"Supplier name test,Expected:" + expSuppName + ",Actuals:" + actSname);

			String actERPID = enobjsupplierPage.getColumnText("ERP", 0);
			Reporter.log(" ERP ID entered:" + expERPID + ",Actual ERP ID:" + actERPID);
			softAssert.assertEquals(actERPID, expERPID,"ERP ID Multiple test,Expected:" + expERPID + ",Actuals:" + actERPID);

			enviewSupplier.clickOnSupplier(expSuppName);

			dataMap.put("maintab", "Enterprise");
			dataMap.put("subtab", "viewEnterpriseHeaderInformation");
			enviewSupplier.selectTab(dataMap);
			lavanteUtils.fluentwait(enviewSupplier.suppliererpid());

			String appERPID = enviewSupplier.suppliererpid().getText();
			Reporter.log(" ERP ID entered:" + expERPID + ",Actual ERP ID:" + appERPID);
			softAssert.assertEquals(appERPID, expERPID,		"ERP ID Multiple test,Expected:" + expERPID + ",Actuals:" + appERPID);

			dataMap.clear();
			dataMap.put("maintab", "Status");
			dataMap.put("subtab","ProfileStage");
			enviewSupplier.selectTab(dataMap);

			lavanteUtils.fluentwait(enviewSupplier.StatusProfApprovalListType().get(0));
			outr: for (int i = 0; i < enviewSupplier.StatusProfApprovalListType().size();) {
				String expAction = "ERP ID assigned";
				String actactionType = enviewSupplier.StatusProfApprovalListType().get(i).getText();

				Reporter.log(" ERP ID Status:" + expAction + ",Actual ERP ID:" + actactionType);
				softAssert.assertEquals(actactionType, expAction,"ERP ID Status,Expected:" + expAction + ",Actuals:" + actactionType);

				expAction = "Update SupplierERPID";
				String actActionTaken = enviewSupplier.StatusProfApprovalListAction().get(i).getText();

				Reporter.log(" ActionTaken Verification :" + expAction + ",Actual ERP ID:" + actActionTaken);
				softAssert.assertEquals(actActionTaken, expAction,		"Action taken Verification,Expected:" + expERPID + ",Actuals:" + actActionTaken);
				flag = true;
				break outr;
			}

		} else {
			softAssert.assertTrue(false, "Supplier ID Page does not have content to do Add ERP ID");
			flag = true;
		}

		if (flag == false) {
			softAssert.assertTrue(false, "ERP ID Data Not Matched");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for Add ERP ID  at:" + currenttime());
		System.out.println("----------Test Ended---for Add ERP ID --------");
	}

	/**
	 * Search a Approved Supplier Who has ERPID Verify the Erp id on the Edit
	 * Profile page has editable text box
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * 
	 */
//	@Test
	public void ApprovedERPID() throws Exception {

		Reporter.log("Test Started for Approved Supplier ERP ID  at:" + currenttime());

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		dataMap.put("SupplierID", "1");
		dataMap.put("ProfStatus", "Approved");
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		expSuppName = enobjsupplierPage.getColumnText("Name", 0);
		String sid = enobjsupplierPage.getColumnText("ERP", 0);

		dataMap.put("supplierName", expSuppName);
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "EnterpriseInfo");
		eneditProfile.selectTab(dataMap);
		String nwsuppid = LavanteUtils.randomnum();

		dataMap.put("ERPID", nwsuppid);
		eneditEnterprise.fillkeySupplierInfo(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		dataMap.clear();
		enobjsupplierBasicSearch.formAction(dataMap);

		dataMap.put("supplierName", expSuppName);
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		SoftAssert softAssert = new SoftAssert();
		String appsname = enobjsupplierPage.getColumnText("Name", 0);
		String appsid = enobjsupplierPage.getColumnText("ERP", 0);
		Reporter.log(	" Modified ERP ID for the Supplier:" + appsname + ",entered:" + nwsuppid + ",Actual ERP ID:" + appsid);
		softAssert.assertEquals(appsid, nwsuppid,		"Modified ERP ID for the Supplier:" + appsname + ",entered:" + nwsuppid + ",Actuals:" + appsid);

		Reporter.log(" Modified ERP ID for the Supplier:" + appsname + ",Old Supplier ERP ID:" + sid + ",Actual ERP ID:"			+ appsid);
		softAssert.assertNotEquals(appsid, sid,		"Modified ERP ID for the Supplier:" + appsname + ",OLD ERP entered:" + sid + ",Actuals:" + appsid);

		enviewSupplier.clickOnSupplier(expSuppName);

		lavanteUtils.switchtoFrame(null);

		dataMap.clear();
		dataMap.put("maintab", "Enterprise");
		dataMap.put("subtab", "Header");
		enviewSupplier.selectTab(dataMap);

		lavanteUtils.fluentwait(enviewSupplier.suppliererpid());

		appsid = enviewSupplier.suppliererpid().getText();

		Reporter.log(" Modified ERP ID for the View Supplier:" + appsname + ",entered:" + nwsuppid + ",Actual ERP ID:"				+ appsid);
		softAssert.assertEquals(appsid, nwsuppid,"Modified ERP ID for the View Supplier:" + appsname + ",entered:" + nwsuppid + ",Actuals:" + appsid);

		Reporter.log(" Modified ERP ID for the View Supplier:" + appsname + ",Old Supplier ERP ID:" + sid+ ",Actual ERP ID:" + appsid);
		softAssert.assertNotEquals(appsid, sid,	"Modified ERP ID for the View Supplier:" + appsname + ",OLD ERP entered:" + sid + ",Actuals:" + appsid);

		softAssert.assertAll();
		// No need to delete the ERP ID
		expSuppName = "";
		Reporter.log("Test Ended for APPROVED ERP ID  at:" + currenttime());
		System.out.println("----------Test Ended---for APPROVED ERP ID --------");
	}

	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author Piramanayagam.S
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.backtoSearch();

		if (expSuppName.length() > 0) {
			String query = "update Jbpm_Task set status='Reserved' where processInstanceId in (select ProcessInstanceId from WF_ProcessDetails where RelationShipID in "
					+ " (select RelationshipID from Relationship where CustomerID=" + customerID
					+ " and LavanteUID in (select LavanteUID from Supplier where SupplierName='" + expSuppName + "')))";
			lavanteUtils.UpdateDB(query);
			query = " delete  from Relationship_ERP_Map where RelationshipID in (select RelationshipID from Relationship where CustomerID="
					+ customerID + " and LavanteUID in (select LavanteUID from Supplier where SupplierName='"
					+ expSuppName + "'))";
			lavanteUtils.UpdateDB(query);
			query = " update WF_ProcessDetails set ProcessStatus_KVID=1902  where RelationShipID in (select RelationshipID from Relationship where CustomerID="
					+ customerID + " and LavanteUID in (select LavanteUID from Supplier where SupplierName='"
					+ expSuppName + "'))";
			lavanteUtils.UpdateDB(query);
		}
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
