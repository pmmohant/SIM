package com.lavante.recovery.TestScripts.UAT;

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

public class Config_Acct_UserGroup  extends pageInitiator {

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
	 */
	@Test
	public void ConfigAcctAddNwUserGroupTest(){
		
		click(configAcctPage.acctConfigUserGroupsTab());
		
		String userGrp="UserGroup"+currenttime();
	
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("UserGroupName",userGrp);
	
		
		dataMap.put("Dashboard","Yes");
		dataMap.put("Active","No");
		

		dataMap.put("SaveUser", "");
		
		configAcctPage.configAcctAddNewUserGroup(dataMap);
		

		//Verifying search results
		waitForTime(2000);
		boolean flag=false;
		
		SoftAssert softAssert=new SoftAssert();
		

		for(int i=0;i<configAcctPage.acctUserGroupNameList().size();i++){
			
			String actUserGrp=configAcctPage.acctUserGroupNameList().get(i).getText();
			
			if(actUserGrp.equalsIgnoreCase(dataMap.get("UserGroupName"))){
						
				softAssert.assertEquals(actUserGrp, userGrp);
				Reporter.log("User Group Name Expected:"+userGrp+"::User Group Name Actual"+actUserGrp,true);
								
				String actActiveStatus=configAcctPage.acctUserGroupActiveStatusList().get(i).getText();
				String expActiveStatus=dataMap.get("Active");
				
				softAssert.assertEquals(actActiveStatus,expActiveStatus);
				Reporter.log("Expected Active Status:"+expActiveStatus+"::Actual Active Status:"+actActiveStatus,true);
				
				//Edit User Group
				click(configAcctPage.acctUserGroupEditLinks().get(i));
				String nwusergrp="AutoGrp"+currenttime();
				dataMap.put("UserGroupName",nwusergrp);
				dataMap.put("Active","Yes");
				configAcctPage.fillAcctUserGroup(dataMap);
				configAcctPage.formAcctUserGroup(dataMap);
				waitForTime(3000);
				for( int j=0;j<configAcctPage.acctUserGroupNameList().size();j++){
							
					actUserGrp=configAcctPage.acctUserGroupNameList().get(j).getText();
					
					if(actUserGrp.equalsIgnoreCase(nwusergrp)){
						softAssert.assertEquals(actUserGrp, nwusergrp);
						Reporter.log("User Group Name Expected: "+nwusergrp+"::User Group Name Actual: "+actUserGrp,true);
						flag=true;
						
					}
				}
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
