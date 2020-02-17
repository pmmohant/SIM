package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

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

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 13-02-2017 Created for EFT Change Notification
 * 
 * @author Subhash.BV
 *
 */

public class PaymentEFTChangeNotifcation04 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String sname = null;
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

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
		List listofdatafrm = lavanteUtils.login("PaymentCenter", browser);
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		String query1 = "update CustomerMetadata set IsNotifyField=1 where ProfileMetadataID=9900 and CustomerID="
				+ customerID + "";
		lavanteUtils.UpdateDB(query1);

	}

	@BeforeMethod
	public void setup() throws Exception {
		sname = dataMap.get("supname");
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Approved");
	//	dataMap.put("supplierName", sname);
		
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		sname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		dataMap.put("tab", "supplierRelationshipTreasuryInfo");
		eneditProfile.selectTab(dataMap);
	}

	/**
	 * SIM-9717 Change information for upload banking or EFT doc in EFT
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void addEFTDetailsAddTest() throws Exception {
		System.out.println(	"------------Test Started for verify Change information for upload banking or EFT doc in EFT Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify Change information for upload banking or EFT doc in EFT Test in Edit Profile at :"	+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		lavanteUtils.click(eneditPayment.PreferedPayementTypedpdn());
		lavanteUtils.selectFrmDpdn("any");

		dataMap.put("AddEFT", "");
		dataMap.put("Currency", "USD (United States dollar)");
		String email1 = "AutoSub" + randomnum() + "@lav.com";
		dataMap.put("RCEmail1", email1);
		dataMap.put("BankCountry", "United States");
		dataMap.put("ABARoutingNumber", generateRandomNumber9OnLength(9));
		dataMap.put("AccountNumber", randomnum());
		dataMap.put("AccountType", "Savings");
		dataMap.put("SwiftCode", "abcmnj25154");
		dataMap.put("BankName", "Other#otherbank");
		String branchAddress = "BranchAddress" + randomnum();
		dataMap.put("BranchAddress", branchAddress);
		String city = "NewCity" + randomnum();
		dataMap.put("City", city);
		dataMap.put("State", "any");
		dataMap.put("IBANNumber", "BE45096920886089");

		dataMap.put("Save", "");
		eneditPayment.addOrEditEFT(dataMap);

		int bankDetailsSize = eneditPayment.ListBankDetails().size();
		String getAddress = null;
		boolean flag = false;
		for (int i = 0; i < bankDetailsSize; i++) {
			getAddress = lavanteUtils.getText(eneditPayment.ListBankDetails().get(i));
			if (getAddress.contains(branchAddress) && getAddress.contains(city)) {
				flag = true;
				break;
			}
		}

		Reporter.log(" Added new EFT details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		Assert.assertTrue(flag," Added new EFT details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		dataMap.remove("Save");
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		enviewSupplier.clickOnSupplier(sname);

		lavanteUtils.switchtoFrame(null);
		dataMap.put("maintab", "ProfileStageHistory");
		dataMap.put("subtab", "viewNotifications");
		enviewSupplier.selectTab(dataMap);

		int tableSize = enviewSupplier.ListDataChangeLogNewValue().size();
		String getNewValue = null;
		boolean flag1 = false;
		for (int i = 0; i < tableSize; i++) {
			getNewValue = lavanteUtils.getText(enviewSupplier.ListDataChangeLogNewValue().get(i));
			if (getNewValue.contains(email1) && getNewValue.contains(branchAddress) && getNewValue.contains(city)) {
				flag1 = true;
				break;
			}
		}

		Reporter.log(" Data Change Log details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		Assert.assertTrue(flag1,
				" Data Change Log details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);

		Reporter.log(
				"Test end for verify Change information for upload banking or EFT doc in EFT Test in Edit Profile- at:"
						+ currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-9717 Change information for upload banking or EFT doc in EFT
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void addEFTDetailsEditTest() throws Exception {
		System.out.println(	"------------Test Started for verify credit card PaymentTerm Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify credit card PaymentTerm Test in Edit Profile at :"		+ currenttime());
		String query1 = "update CustomerMetadata set IsNotifyField=1 where ProfileMetadataID=9900 and CustomerID="		+ customerID + "";
		lavanteUtils.UpdateDB(query1);

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		lavanteUtils.click(eneditPayment.PreferedPayementTypedpdn());
		lavanteUtils.selectFrmDpdn("any");

		dataMap.put("AddEFT", "");
		dataMap.put("Currency", "USD (United States dollar)");
		String email1 = "AutoSub" + randomnum() + "@lav.com";
		dataMap.put("RCEmail1", email1);
		dataMap.put("BankCountry", "United States");
		dataMap.put("ABARoutingNumber", generateRandomNumber9OnLength(9));
		dataMap.put("AccountNumber", randomnum());
		dataMap.put("AccountType", "Savings");
		dataMap.put("SwiftCode", "abcmnj25154");
		dataMap.put("BankName", "Other#otherbank");
		String branchAddress = "BranchAddress" + randomnum();
		dataMap.put("BranchAddress", branchAddress);
		String city = "NewCity" + randomnum();
		dataMap.put("City", city);
		dataMap.put("State", "any");
		dataMap.put("IBANNumber", "BE45096920886089");

		dataMap.put("Save", "");
		eneditPayment.addOrEditEFT(dataMap);

		dataMap.clear();
		// Edit
		int bankDetailsSize = eneditPayment.ListBankDetails().size();
		String getAddress = null;
		boolean flag = false;
		for (int i = 0; i < bankDetailsSize; i++) {
			getAddress = lavanteUtils.getText(eneditPayment.ListBankDetails().get(i));
			if (getAddress.contains(branchAddress) && getAddress.contains(city)) {
				eneditPayment.ListEFTEditBtn().get(i).click();
				flag = true;
				break;
			}
		}

		String branchAddress1 = "BranchAddNew" + randomnum();
		dataMap.put("BranchAddress", branchAddress1);
		String city1 = "CityNew" + randomnum();
		dataMap.put("City", city1);
		dataMap.put("Save", "");
		eneditPayment.addOrEditEFT(dataMap);

		for (int i = 0; i < bankDetailsSize; i++) {
			getAddress = lavanteUtils.getText(eneditPayment.ListBankDetails().get(i));
			if (getAddress.contains(branchAddress1) && getAddress.contains(city1)) {
				flag = true;
				break;
			}
		}

		Reporter.log(" Added new EFT details, Expected : " + branchAddress1 + " " + city1 + " Actual : " + getAddress);
		Assert.assertTrue(flag,
				" Added new EFT details, Expected : " + branchAddress1 + " " + city1 + " Actual : " + getAddress);

		dataMap.clear();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		dataMap.put("maintab", "Status and History");
		dataMap.put("subtab", "viewNotifications");
		enviewSupplier.selectTab(dataMap);

		int tableSize = enviewSupplier.ListDataChangeLogNewValue().size();
		String getNewValue = null;
		boolean flag1 = false;
		for (int i = 0; i < tableSize; i++) {
			getNewValue = lavanteUtils.getText(enviewSupplier.ListDataChangeLogNewValue().get(i));
			if (getNewValue.contains(email1) && getNewValue.contains(branchAddress1) && getNewValue.contains(city1)) {
				flag1 = true;
				break;
			}
		}

		Reporter.log(" Data Change Log details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		Assert.assertTrue(flag1,
				" Data Change Log details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		String chkContent = "%" + email1 + "%";
		String queryEmailNotify = "select Top 1 MergedNotificationContent from [Notification] where NotificationTypeID =2507 and CustomerID="
				+ customerID + " order by CreatedOn desc";

		queryEmailNotify = lavanteUtils.fetchDBdata(queryEmailNotify);
		boolean flag2 = false;
		if (queryEmailNotify.contains(branchAddress1) && queryEmailNotify.contains(email1)
				&& queryEmailNotify.contains(city1)) {
			flag2 = true;
		}
		Reporter.log(" Verify MergedNotificationContent from notification table is triggered , Expected : "
				+ branchAddress + " " + city + " Actual : " + getAddress);
		Assert.assertTrue(flag2, " Verify MergedNotificationContent from notification table is triggered , Expected :  "
				+ branchAddress + " " + city + " Actual : " + queryEmailNotify);

		enobjhomePage.backtoSearch();
		Reporter.log(
				"Test end for verify credit card PaymentTerm Test in Edit Profile- at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-9717 Change information for upload banking or EFT doc in EFT
	 * 
	 * @param dataMap
	 * @throws Exception
	 * @author Subhas.BV
	 */
	@Test
	public void addEFTDetailsDeleteTest() throws Exception {
		System.out.println(	"------------Test Started for verify Change information for upload banking or EFT doc in EFT Test in Edit Profile-------------------");
		Reporter.log("Test Started for verify Change information for upload banking or EFT doc in EFT Test in Edit Profile at :"+ currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();

		lavanteUtils.click(eneditPayment.PreferedPayementTypedpdn());
		lavanteUtils.selectFrmDpdn("any");

		dataMap.put("AddEFT", "");
		dataMap.put("Currency", "USD (United States dollar)");
		String email1 = "AutoSub" + randomnum() + "@lav.com";
		dataMap.put("RCEmail1", email1);
		dataMap.put("BankCountry", "United States");
		dataMap.put("ABARoutingNumber", generateRandomNumber9OnLength(9));
		dataMap.put("AccountNumber", randomnum());
		dataMap.put("AccountType", "Savings");
		dataMap.put("SwiftCode", "abcmnj25154");
		dataMap.put("BankName", "Other#otherbank");
		String branchAddress = "BranchAddress" + randomnum();
		dataMap.put("BranchAddress", branchAddress);
		String city = "NewCity" + randomnum();
		dataMap.put("City", city);
		dataMap.put("State", "any");
		dataMap.put("IBANNumber", "BE45096920886089");

		dataMap.put("Save", "");
		eneditPayment.addOrEditEFT(dataMap);

		int bankDetailsSize = eneditPayment.ListBankDetails().size();
		String getAddress = null;
		boolean flag = false;
		for (int i = 0; i < bankDetailsSize; i++) {
			getAddress = lavanteUtils.getText(eneditPayment.ListBankDetails().get(i));
			if (getAddress.contains(branchAddress) && getAddress.contains(city)) {
				flag = true;
				lavanteUtils.click(eneditPayment.ListEFTDeleteBtn().get(i));
				lavanteUtils.fluentwait(eneditPayment.deleteCommentTxtArea());
				break;
			}
		}
		String comment = "comm" + generateRandomNumber9OnLength(6);
		lavanteUtils.typeinEdit(comment, eneditPayment.deleteCommentTxtArea());
		lavanteUtils.click(eneditPayment.OkBtn());

		Reporter.log(" Added new EFT details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		Assert.assertTrue(flag,
				" Added new EFT details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);

		dataMap.remove("Save");
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(sname);

		lavanteUtils.switchtoFrame(null);
		dataMap.put("maintab", "Status and History");
		dataMap.put("subtab", "viewNotifications");
		enviewSupplier.selectTab(dataMap);

		int tableSize = enviewSupplier.ListDataChangeLogOldValue().size();
		String getNewValue = null;
		boolean flag1 = false;
		for (int i = 0; i < tableSize; i++) {
			getNewValue = lavanteUtils.getText(enviewSupplier.ListDataChangeLogOldValue().get(i));

			if (getNewValue.contains(email1) && getNewValue.contains(branchAddress) && getNewValue.contains(city)) {

				String getOperationType = lavanteUtils.getText(enviewSupplier.ListDataOperationTypeValue().get(i));
				if (getOperationType.equals("Delete")) {
					flag1 = true;
					break;
				}
			}
		}

		Reporter.log(" Data Change Log details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);
		Assert.assertTrue(flag1,
				" Data Change Log details, Expected : " + branchAddress + " " + city + " Actual : " + getAddress);

		enobjhomePage.backtoSearch();
		System.out.println("----------Test Ended----------------");
		Reporter.log("Test end for verify Change information for upload banking or EFT doc in EFT Test in Edit Profile- at:"+ currenttime());
		

	}

	
	@AfterMethod
	public void Setupaftermethod(){
		enobjhomePage.backtoSearch();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);	
		
	}
	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
