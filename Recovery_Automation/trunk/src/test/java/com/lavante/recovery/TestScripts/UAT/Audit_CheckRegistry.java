package com.lavante.recovery.TestScripts.UAT;

import java.util.LinkedHashMap;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Audit_CheckRegistry extends pageInitiator {

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();

		waitForTime(3000);

		homePage.verifyHomePageDisplayed();
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		
		dataMap.put("maintab","audit");
        dataMap.put("subtab","checkRequest");
        homePage.selectTab(dataMap);

	}
	/**
	 * Test Method 
	 * 
	 * @author Girish Umesh Naik
	 *  
	 */
	@Test
	public void AddeditCheckRegistryTest(){
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		
		String supName="AutoCheck"+currenttime();
		dataMap.put("SupplierName", supName);
		dataMap.put("CheckNo", "1414125");
		dataMap.put("CheckAmount", "252");
		dataMap.put("CheckDate", "ANY");
		
		dataMap.put("SaveRegistry", "");
		
		auditCheckRegPage.addRegistry(dataMap);
	
		//Searching the Check Registry
		dataMap.put("SearchType","Supplier Name"); 
		dataMap.put("SearchValue",supName); 
		
		auditCheckRegPage.searchRegistrty(dataMap);
		
		boolean flag=false;
		
		SoftAssert softAssert=new SoftAssert();
		
		//Edit Check Registry Data
		LinkedHashMap<String,String> dataMap1 = new LinkedHashMap<String,String>();
		String newSupName="EditCheck"+currenttime();
		
		dataMap1.put("SupplierName", newSupName);
		dataMap1.put("CheckNo", "2323212");
		dataMap1.put("CheckAmount", "399");
		dataMap1.put("CheckDate", "ANY");
		
		dataMap1.put("SaveRegistry", "");
	

		for(int i=0;i<auditCheckRegPage.auditCheckRegistrySuppNames().size();i++){
			
			String actName=auditCheckRegPage.auditCheckRegistrySuppNames().get(i).getText();
			if(actName.equalsIgnoreCase(dataMap.get("SupplierName"))){
				
				
				String actAmnt=auditCheckRegPage.auditCheckRegistryCheckAmounts().get(i).getText();
				String expAmnt="$"+dataMap.get("CheckAmount");
				if(!expAmnt.contains("."))
					expAmnt=expAmnt+".00";
				
				String actCheckNo=auditCheckRegPage.auditCheckRegistryCheckNums().get(i).getText();
				String expCheckNo=dataMap.get("CheckNo");
				
				if(actAmnt.equalsIgnoreCase(expAmnt)&&actCheckNo.equalsIgnoreCase(expCheckNo))
					flag=true;
				
				if(flag){
					click(auditCheckRegPage.auditCheckRegistryEditLinks().get(i));
					auditCheckRegPage.fillAddRegistry(dataMap1);
					auditCheckRegPage.formAddRegistry(dataMap1);
					
					break;
				}
				
			}
	
			
		}
		
		//Verify Edited check registry
		dataMap1.put("SearchType","Supplier Name"); 
		dataMap1.put("SearchValue",newSupName); 
		auditCheckRegPage.searchRegistrty(dataMap1);
		
		flag=false;
		
		
		for(int i=0;i<auditCheckRegPage.auditCheckRegistrySuppNames().size();i++){
			
			String actName=auditCheckRegPage.auditCheckRegistrySuppNames().get(i).getText();
			if(actName.equalsIgnoreCase(dataMap1.get("SupplierName"))){
				
				softAssert.assertEquals(actName, newSupName);
				Reporter.log("Expected:"+supName+"::Actual:"+actName,true);
				
				String actAmnt=auditCheckRegPage.auditCheckRegistryCheckAmounts().get(i).getText();
				String expAmnt="$"+dataMap1.get("CheckAmount");
				if(!expAmnt.contains("."))
					expAmnt=expAmnt+".00";
				
				softAssert.assertEquals(actAmnt, expAmnt,"Amount Not Matched:"+expAmnt+"::Actual:"+actAmnt);
				Reporter.log("Amount Expected:"+expAmnt+"::Actual:"+actAmnt,true);
				
				String actCheckNo=auditCheckRegPage.auditCheckRegistryCheckNums().get(i).getText();
				String expCheckNo=dataMap1.get("CheckNo");
				
				softAssert.assertEquals(actCheckNo,expCheckNo, "Expected:"+expCheckNo+"::Actual:"+actCheckNo);
				Reporter.log("Expected:"+expCheckNo+"::Actual:"+actCheckNo,true);
				
				flag=true;
				
			}
		}
		
		
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	/**
	 * After Class Logout and Quit Method 
	 * 
	 * @author Piramanayagam.S
	 */
	
	@AfterClass
	  public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	  }
	
	
}
