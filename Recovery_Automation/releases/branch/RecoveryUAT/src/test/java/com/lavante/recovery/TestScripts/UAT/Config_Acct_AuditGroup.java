package com.lavante.recovery.TestScripts.UAT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class Config_Acct_AuditGroup  extends pageInitiator {

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
		
		dataMap.put("maintab","configuration");
        dataMap.put("subtab","accountConfiguration");
        homePage.selectTab(dataMap);

	}

	/**
	 * Test Method 
	 * 
	 * @author Girish Umesh Naik
	 * @throws IOException 
	 * @throws FileNotFoundException  
	 */
	@Test
	public void ConfigAcctAddNwAuditGroupTest() throws FileNotFoundException, IOException{
		
		click(configAcctPage.acctConfigAuditGroupsTab());
		
		String auditGrp="AuditGroup"+currenttime();
	
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("AuditGroupName",auditGrp);
		
		dataMap.put("AuditName",InitProperties("DefaultAudit").trim());
		dataMap.put("DefaultAudit",InitProperties("DefaultAudit").trim());

		dataMap.put("SaveUser", "");
		
		configAcctPage.configAcctAddNewAuditGroup(dataMap);
		
		//Verifying search results
		waitForTime(2000);
		boolean flag=false;
		
		SoftAssert softAssert=new SoftAssert();
		
		for(int i=0;i<configAcctPage.acctAuditGroupNameList().size();i++){
			
			String actAuditGrp=configAcctPage.acctAuditGroupNameList().get(i).getText().trim();
			
			if(actAuditGrp.equalsIgnoreCase(dataMap.get("AuditGroupName"))){
					
				softAssert.assertEquals(actAuditGrp, auditGrp);
				Reporter.log("Audit Group Name Expected:"+auditGrp+"::Audit Group Name Actual:"+actAuditGrp,true);
					
				String actDefAudit=configAcctPage.acctAuditGroupDefaultAuditList().get(i).getText().trim();
				String expDefAudit=dataMap.get("DefaultAudit");
				softAssert.assertEquals(actDefAudit, expDefAudit);
				Reporter.log("Default Audit Expected:"+expDefAudit+"::Default Audit Actual:"+actDefAudit,true);
				
				//Edit Audit Group
				click(configAcctPage.acctAuditGroupEditLinks().get(i));
				String nwAuditgrp="AutoGrp"+currenttime();
				dataMap.put("AuditGroupName",nwAuditgrp);
				
				configAcctPage.fillAcctAuditGroup(dataMap);
				configAcctPage.formAcctAuditGroup(dataMap);
				
				for( int j=0;j<configAcctPage.acctAuditGroupNameList().size();j++){
							
					actAuditGrp=configAcctPage.acctAuditGroupNameList().get(j).getText().trim();
					
					if(actAuditGrp.equalsIgnoreCase(nwAuditgrp)){
						softAssert.assertEquals(actAuditGrp, nwAuditgrp);
						Reporter.log("Audit Group Name Expected: "+nwAuditgrp+"::Audit Group Name Actual: "+actAuditGrp,true);
						
						actDefAudit=configAcctPage.acctAuditGroupDefaultAuditList().get(j).getText().trim();
						expDefAudit=dataMap.get("DefaultAudit");
						softAssert.assertEquals(actDefAudit, expDefAudit);
						Reporter.log("Default Audit Expected:"+expDefAudit+"::Default Audit Actual:"+actDefAudit,true);
						flag=true;
						break;
					}
				}
				break;
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
