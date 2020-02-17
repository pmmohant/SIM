package com.lavante.sim.customer.TestScripts.Supplier.NetWorkSupplier;



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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 04-10-2016 Created for Edit Profile Test case Ended on 04-02-2016
 * 
 * @author Piramanayagam.S
 *
 */
public class EditBuyerAsSupplier01 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = "";
	String userName="";
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

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

		List listofdatafrm = lavanteUtils.login("BuyerAsSupplier", browser);

		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		userName = LdataMap.get("username");
		customerID = (String) listofdatafrm.get(1);
	}

	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException {

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		lavanteUtils.switchtoFrame(null);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
	}

	/**
	 * SIM-12774 Provide privileges for buyer to act on behalf of network
	 * supplier
	 * 
	 * Change the Role to "Buyer as Supplier"- Fetch Network Supplier Verify the
	 * TABS and Fields in the tabs -->Should be available
	 * 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test
	public void ChangeRoleasBuyerVerify() throws Exception {
		System.out.println("------------Test Started for BuyerAs Supplier--for Network Supplier-----------------");

		Reporter.log("Test Started for BuyerAs Supplier Profile at :" + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String query = "update LoginRole set RoleTypeId= 3  where UserRoleName='Buyer As Supplier'";
		lavanteUtils.UpdateDB(query);
		query = "select CustomerID From CustomerLoginRoleMap  where UserRoleID in ( select UserRoleID From LoginRole where RoleTypeId=3) "
				+ " and CustomerID=" + customerID;
		if (!(lavanteUtils.fetchDBdata(query).length() > 0)) {
			Assert.assertTrue(false, "Loggin Customer is not Mapped to role 3,CustomerID:" + customerID);
		}

		BeforeMethod();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		String supname = "SCRre Wallace NOW RR DONNELLY";
		supname = " select max(SupplierName) from supplier where SupplierName='" + supname
				+ "' and LavanteUID in ( select LavanteUID "
				+ " from Relationship where lavanteuid in (select LavanteUID From Relationship where CustomerID= "
				+ customerID + ") and CustomerID not in (" + customerID + "))";
		supname = lavanteUtils.fetchDBdata(supname);
		if (!(supname.length() > 0)) {
			Assert.assertTrue(false, "Please Retest,There is no Network Supplier for the customer:" + customerID);
		}

		dataMap.put("Search", "");
		dataMap.put("supplierName", supname);
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		Reporter.log("Supplier Name:" + supname);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		supname = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);

		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.Scrollintoview(eneditCompanyProfile.MajorityOwnershipDropDwn());

		SoftAssert softAssert = new SoftAssert();

		boolean flag = lavanteUtils.isElementDisplayed(eneditCompanyProfile.MajorityOwnershipDropDwn());
		boolean flag2 = lavanteUtils.isElementDisplayed(eneditCompanyProfile.noofEmployeedpdn());
		softAssert.assertTrue(flag, "Majority Button Not avaialble for buyer as supplier");
		softAssert.assertTrue(flag2, "No Of Emp Drop Down Not avaialble for buyer as supplier");

		dataMap.put("Leavethis", "");
		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);

		flag = lavanteUtils.isElementDisplayed(eneditCertification.insuranceYes());
		softAssert.assertTrue(flag, "Ceritification not Available for buyer as supplier");

		softAssert.assertAll();
		Reporter.log("Test Ended for Role Buyer as Supplier for Network Supplier at:" + LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-12774 Provide privileges for buyer to act on behalf of network
	 * supplier
	 * 
	 * Change the Role from Buyer Role to Other Role Verify the TABS and Fields
	 * in the tabs-->Should not be available
	 * 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test
	public void ChangeRoleasSuperSIMVerify() throws Exception {
		System.out.println("------------Test Started for Role as SuperSIM for Network Supplier-------------------");

		String query = "update LoginRole set RoleTypeId= 2  where UserRoleName='Buyer As Supplier'";
		lavanteUtils.UpdateDB(query);
		BeforeMethod();
		Reporter.log("Test Started for BuyerAs Supplier Profile at :" + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		String supname = "SCRre Wallace NOW RR DONNELLY";
		supname = " select max(SupplierName) from supplier where SupplierName='" + supname
				+ "' and LavanteUID in ( select LavanteUID "
				+ " from Relationship where lavanteuid in (select LavanteUID From Relationship where CustomerID= "
				+ customerID + ") and CustomerID not in (" + customerID + "))";
		supname = lavanteUtils.fetchDBdata(supname);
		if (!(supname.length() > 0)) {
			Assert.assertTrue(false, "Please Retest,There is no Network Supplier for the customer:" + customerID);
		}

		dataMap.put("Search", "");
		dataMap.put("supplierName", supname);
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		Reporter.log("Supplier Name:" + supname);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		supname = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.switchtoFrame(null);

		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(null);

		SoftAssert softAssert = new SoftAssert();

		boolean flag = lavanteUtils.isElementDisplayed(eneditCompanyProfile.MajorityOwnershipDropDwn());
		boolean flag2 = lavanteUtils.isElementDisplayed(eneditCompanyProfile.noofEmployeedpdn());

		Reporter.log("Majority Button Not avaialble for other role buyer as supplier" + flag);
		Reporter.log("No of Employee Not avaialble for other role buyer as supplier" + flag2);
		softAssert.assertFalse(flag, "Majority Ownership Not avaialble for other role buyer as supplier");
		softAssert.assertFalse(flag2, "No of Employee  Not avaialble for other role  buyer as supplier");

		softAssert.assertAll();
		Reporter.log("Test Ended for Role as SuperSIM for Network at:" + LavanteUtils.currenttime());
		System.out.println("----------Test Ended ----------------");

	}

	/**
	 * SIM-12947 Allow edit of Legal ID fields post Supplier Profile Approval
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void legalIdFieldsBuyerVerifyTest001() throws Exception {
		System.out.println("------------Test Started for Role as SuperSIM for Network Supplier-------------------");
		String query = "update Login set UserRoleID=14 where ContactID in (select ContactID from Contact where Email='"+userName+"')";
		
		lavanteUtils.UpdateDB(query);
		BeforeMethod();
		Reporter.log("Test Started for legalIdFieldsBuyerVerifyTest at :" + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Approved");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String supname = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		Reporter.log("Supplier Name:" + supname);
		lavanteUtils.switchtoFrame(null);

		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		boolean flag = false;

		if (!lavanteUtils.isElementPresent(eneditCompanyProfile.ListEditBtn())) {
			flag = true;
		}
		Reporter.log("Verify Country of Registration and Name/Business Name as no eidt icon/fields can't be editable ");
		softAssert.assertTrue(flag,
				"Verify Country of Registration and Name/Business Name as no eidt icon/fields can't be editable");

		flag = false;
		if (!lavanteUtils.isElementDisplayed(eneditCompanyProfile.EINTxtBox())) {
			flag = true;
		}
		Reporter.log("Verify Legal ID field can't be editable");
		softAssert.assertTrue(flag, "Verify Legal ID field can't be editable ");

		softAssert.assertAll();
		System.out.println("------------Test legalIdFieldsBuyerVerifyTest Ended -------------------");

	}

	/**
	 * SIM-12947 Allow edit of Legal ID fields post Supplier Profile Approval
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void legalIdFieldsBuyerVerifyTest002() throws Exception {
		System.out.println("------------Test Started for Role as SuperSIM for Network Supplier-------------------");
		String query = "update Login set UserRoleID=47 where ContactID in (select ContactID from Contact where Email='"+userName+"')";
		lavanteUtils.UpdateDB(query);
		BeforeMethod();
		Reporter.log("Test Started for legalIdFieldsBuyerVerifyTest at :" + LavanteUtils.currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Approved");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String supname = enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		Reporter.log("Supplier Name:" + supname);
		lavanteUtils.switchtoFrame(null);

		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		boolean flag = false;

		if (lavanteUtils.isElementPresent(eneditCompanyProfile.ListEditBtn())) {
			flag = true;
		}
		Reporter.log("Verify Country of Registration and Name/Business Name as eidt icon/fields can be editable ");
		softAssert.assertTrue(flag,
				"Verify Country of Registration and Name/Business Name as eidt icon/fields can be editable");

		flag = false;
		if (lavanteUtils.isElementDisplayed(eneditCompanyProfile.EINTxtBox())) {
			flag = true;
		}
		Reporter.log("Verify Legal ID field can be editable");
		softAssert.assertTrue(flag, "Verify Legal ID field can be editable ");

		softAssert.assertAll();
		System.out.println("------------Test legalIdFieldsBuyerVerifyTest Ended -------------------");

	}

	@AfterMethod
	public void aftermethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.logout();
		String query = "update LoginRole set RoleTypeId= 3  where UserRoleName='Buyer As Supplier'";
		lavanteUtils.UpdateDB(query);
	}

	@AfterClass
	public void SetupafterClassmethod() {
		quitBrowser();
	}

}
