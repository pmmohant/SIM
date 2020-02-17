package com.lavante.recovery.TestScripts.UAT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

/** 
 * @author Nagappa
 * Test script class for Credit Rejection tab
 * 
 */

public class Config_CreditRejection extends pageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String creditRejectReason ="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();
		lavanteUtils.driver = driver;
		loginPage.login();
		waitForTime(3000);
		
		homePage.SelectAudit("ANY");
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","configuration");
		dataMap.put("subtab","otherConfiguration");
		homePage.selectTab(dataMap);
		
		lavanteUtils.click(configurationOthersPage.creditRejectionReasonTab());
	}

	/**
	 * 
	 * This method is for Adding and Editing of the newly added credit reason 
	 * 
	 * @author nagappa.vaddebail
	 * 
	 */
	
	@Test
	public void addEditCreditReason() {
		Reporter.log("Test Started for adding and editing credit reason: "+ LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		// Adding new fax comment
		String rejectReason = "*AutoReson1"+currenttime();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("CreditReason", rejectReason);
		dataMap.put("Active", "true");
		dataMap.put("Save", "");
		Reporter.log("Adding new rejection comment");
		configurationOthersPage.addCreditReason(dataMap);
		
		boolean flagAdd = false;
		boolean flagEdit = false;
		lavanteUtils.waitForTime(4000);
		for (int i = 0; i < configurationOthersPage.creditRejectionReasons().size(); i++) {
			String actRejectionReason = configurationOthersPage.creditRejectionReasons().get(i).getText().trim();

			System.out.println("Excpected: " + rejectReason + " , Actual: "+ actRejectionReason);
			if (rejectReason.equalsIgnoreCase(actRejectionReason)) {
				softAssert.assertEquals(actRejectionReason, rejectReason);
				Reporter.log("Excpected: " + rejectReason + "Actual: "
						+ actRejectionReason);
				Reporter.log("New credit reason added successfully..!");
				flagAdd = true;
				rejectReason = "*AutoReson1Edit"+currenttime();
				dataMap.put("CreditReason", rejectReason);
				creditRejectReason=rejectReason;
				lavanteUtils.click(configurationOthersPage.editCredit().get(i));
				lavanteUtils.switchtoFrame(configurationOthersPage
						.IFRAMEopenAddEditCreditReasonPop());
				configurationOthersPage.fillCreditReasons(dataMap);
				configurationOthersPage.formCreditReasons(dataMap);
				System.out.println("Entering validation loop..!"
						+ "size: "
						+ configurationOthersPage.creditRejectionReasons()
								.size());
				lavanteUtils.waitForTime(4000);
				for (i = 0; i < configurationOthersPage
						.creditRejectionReasons().size(); i++) {
					String actEditCreditReason = configurationOthersPage
							.creditRejectionReasons().get(i).getText().trim();
					System.out.println("Excpected after edit: " + rejectReason
							+ " , Actual after edit: " + actEditCreditReason);
					Reporter.log("Excpected: " + rejectReason + " , Actual: "
							+ actEditCreditReason);
					if (rejectReason.equalsIgnoreCase(actEditCreditReason)) {
						softAssert.assertEquals(actEditCreditReason,
								rejectReason);
						Reporter.log("Excpected after edit: " + rejectReason
								+ "Actual after edit: " + actEditCreditReason);
						Reporter.log("Credit reason edited successfully..!");
						flagEdit = true;
						break;
					}
				}
				break;
			}
		}
		System.out.println("flagAdd: " + flagAdd + " flagEdit: " + flagEdit);
		softAssert.assertTrue(flagAdd);
		softAssert.assertTrue(flagEdit);
		softAssert.assertAll();
		Reporter.log("Test Ended for adding and editing credit reason: "
				+ LavanteUtils.currenttime());
	}

	/**
	 * 
	 * This method is for Adding and Deleting of the newly added credit reason
	 * 
	 *  @author nagappa.vaddebail
	 * 
	 */
	
	@Test
	public void addDeleteCreditReason() {
		Reporter.log("Test Started for adding and deleting credit reason: "
				+ LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		// Adding new fax comment
		String rejectReason = "*AutoReson2Add"+currenttime();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("CreditReason", rejectReason);
		dataMap.put("Active", "true");
		dataMap.put("Save", "");
		Reporter.log("Adding new rejection comment");
		configurationOthersPage.addCreditReason(dataMap);
		
		boolean flagAdd = false;
		boolean flagDelete = true;
		lavanteUtils.waitForTime(4000);
		for (int i = 0; i < configurationOthersPage.creditRejectionReasons()
				.size(); i++) {
			String actRejectionReason = configurationOthersPage
					.creditRejectionReasons().get(i).getText().trim();

			System.out.println("Excpected: " + rejectReason + " , Actual: "
					+ actRejectionReason);
			if (rejectReason.equalsIgnoreCase(actRejectionReason)) {
				softAssert.assertEquals(actRejectionReason, rejectReason);
				Reporter.log("Excpected: " + rejectReason + "Actual: "
						+ actRejectionReason);
				Reporter.log("New credit reason added successfully..!");
				flagAdd = true;
				lavanteUtils.click(configurationOthersPage.deleteCredit()
						.get(i));
				lavanteUtils.click(configurationOthersPage.OkbtnCredit());
				lavanteUtils.waitForTime(4000);
				for ( i = 0; i < configurationOthersPage
						.creditRejectionReasons().size(); i++) {
					String actDeleteCreditReason = configurationOthersPage
							.creditRejectionReasons().get(i).getText().trim();
					System.out.println("Excpected after delete: "
							+ rejectReason + " , Actual after delete: "
							+ actDeleteCreditReason);
					Reporter.log("Excpected: " + rejectReason + " , Actual: "
							+ actDeleteCreditReason);
					if (rejectReason.equalsIgnoreCase(actDeleteCreditReason)) {
						softAssert.assertEquals(actDeleteCreditReason,
								rejectReason);
						Reporter.log("Excpected after delete: " + rejectReason
								+ "Actual after delete: "
								+ actDeleteCreditReason);
						Reporter.log("Credit reason not deleted successfully..!");
						flagDelete = false;
						break;
					}
				}
				break;
			}
		}
		System.out.println("flagAdd: " + flagAdd + " flagDelete: " + flagDelete);
		softAssert.assertTrue(flagAdd);
		softAssert.assertAll();
		Reporter.log("Test Ended for adding and editing credit reason: "+ LavanteUtils.currenttime());
	}

	@AfterMethod
	public void AfterMethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
		/* Commented as the delete query is not working.
		 * Uncomment this code once the delete query is functioning.
		if(creditRejectReason.length()>0)
		{
			String query="delete from  as2_Credit_Rejected_Reasons where [reason] = '"+creditRejectReason+"'";
			String resultSet = lavanteUtils.fetchDBdata(query);
			System.out.println("resultSet:: " + resultSet);
		}*/
	}
 	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }


}
