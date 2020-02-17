package com.lavante.recovery.TestScripts.UAT;


import java.util.LinkedHashMap;

import com.lavante.recovery.Common.Util.LavanteUtils;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.pageobjects.pageInitiator;

public class Audit_ContactEntry extends pageInitiator{

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();
		String audit=loginPage.login("UATContactEntry",browser);
		waitForTime(3000);
		homePage.SelectAudit(audit);

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","audit");
		dataMap.put("subtab","dataentry");
		homePage.selectTab(dataMap);
	
		
	}

	/**
	 * 
	 * This method is to capture the basic validation steps
	 * 
	 * @author nagappa.vaddebail
	 * 
	 */
	
	 @Test
	  public void ContactEntryPageActions() throws Exception{
		Reporter.log("Test Started for ContactEntry page actions:" + LavanteUtils.currenttime());
		SoftAssert softAssert = new SoftAssert();
		boolean flag=false;
		
		String contactName = "Auto"+currenttime();
		String contactPhone = "8090";
		String contactExtension = "080";
		String contactEmail = "name123@gmail.com";
		String contactFax = "090";
			
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 dataMap.put("validate", "");
		
		 //Accept or escape the pop-up
		 auditContactEntryPage.validatePopup(dataMap);
		 
		 //select the Supplier
		System.out.println("Entered Contact Entry Page actions..!");
		dataMap.put("SuppName", "ANY");
		String suppName= auditContactEntryPage.SelectSupplier(dataMap);
		waitForTime(2000);
		System.out.println("clicked on --> " + suppName);
		if(suppName.length()>2){
			
			String arrVal[] = suppName.split("#");
			String supplierName= arrVal[0];
			String spendRank= arrVal[1];
			String pages= arrVal[2];
			
			// Validating the Supplier name and spend rank with data present in Document table and Supplier Details available below the same table.
			Reporter.log("Supplier Name Excpected: " + auditContactEntryPage.supName().getText() +", Actual: "+  supplierName,true);
			softAssert.assertEquals(supplierName,auditContactEntryPage.supName().getText(), "Supplier Name Excpected: " + auditContactEntryPage.supName().getText() +", Actual: "+  supplierName);
			Reporter.log("Spend Rank Excpected: " + auditContactEntryPage.spendRank().getText() +", Actual: "+  spendRank);
			softAssert.assertEquals(spendRank,auditContactEntryPage.spendRank().getText(), "Spend Rank Excpected: " + auditContactEntryPage.spendRank().getText() +", Actual: "+  spendRank);
			
			// Validating Supplier pages and audit
			Reporter.log("Supplier Pages Excpected: " + auditContactEntryPage.stmtPages().getText().trim().substring(0,1) +", Actual: "+  pages);
			softAssert.assertEquals(pages,auditContactEntryPage.stmtPages().getText().trim().substring(0,1), "Supplier Pages Excpected: " + auditContactEntryPage.stmtPages().getText().trim().substring(0,1) +", Actual: "+  pages);
			Reporter.log("Audit Excpected: " + auditContactEntryPage.audit().getText() +", Actual: "+  auditContactEntryPage.choosenAudit().getText());
			softAssert.assertEquals(auditContactEntryPage.choosenAudit().getText(),auditContactEntryPage.audit().getText(), "Audit Excpected: " + auditContactEntryPage.audit().getText() +", Actual: "+  auditContactEntryPage.choosenAudit().getText());
			
			//Saving the details
			 dataMap.put("Save", "");
			 dataMap.put("ContactName",contactName);
			 dataMap.put("ContactPhone",contactPhone);
			 dataMap.put("ContactExtension",contactExtension);
			 dataMap.put("ContactEmail",contactEmail);
			 dataMap.put("ContactFax",contactFax);
			 auditContactEntryPage.contactEntry(dataMap);
		
			
			System.out.println("Test Edit Values: " + auditContactEntryPage.editName().getText());
			waitForTime(5000);
			//validate the details after saving.
			Reporter.log("Contact Name Excpected: " + contactName +", Actual: "+  auditContactEntryPage.contactName().getText());
			softAssert.assertEquals(auditContactEntryPage.contactName().getText(),contactName, "Contact Name Excpected: " + contactName +", Actual: "+  auditContactEntryPage.contactName().getText());
			Reporter.log("Contact Phone Excpected: " + contactPhone +", Actual: "+  auditContactEntryPage.contactPhone().getText());
			softAssert.assertEquals(auditContactEntryPage.contactPhone().getText(),contactPhone, "Contact Phone Excpected: " + contactPhone +", Actual: "+  auditContactEntryPage.contactPhone().getText());
			Reporter.log("Contact Extension Excpected: " + contactExtension +", Actual: "+  auditContactEntryPage.contactExtension().getText());
			softAssert.assertEquals(auditContactEntryPage.contactExtension().getText(),contactExtension, "Contact Extension Excpected: " + contactExtension +", Actual: "+  auditContactEntryPage.contactExtension().getText());
			Reporter.log("Contact Email Excpected: " + contactEmail +", Actual: "+  auditContactEntryPage.contactEmail().getText());
			softAssert.assertEquals(auditContactEntryPage.contactEmail().getText(),contactEmail, "Contact Email Excpected: " + contactEmail +", Actual: "+  auditContactEntryPage.contactEmail().getText());
			Reporter.log("Contact Fax Excpected: " + contactFax +", Actual: "+  auditContactEntryPage.contactFax().getText());
			softAssert.assertEquals(auditContactEntryPage.contactFax().getText(),contactFax, "Contact Fax Excpected: " + contactFax +", Actual: "+  auditContactEntryPage.contactFax().getText());
			flag=true;
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());	
	 }
	 	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }
	
}
