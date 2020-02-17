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

public class Config_Acct_User extends pageInitiator {

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
	 *  
	 */

	@Test()
	public void configuration_AddNewAccountUserTest() throws FileNotFoundException, IOException{

		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		
		String userName="UN"+currenttime();
		String login="Login"+currenttime();
		
		dataMap.put("UserName",userName);
		dataMap.put("Login",login);
		
		dataMap.put("AuditName",InitProperties("DefaultAudit").trim());
		dataMap.put("EmailId","abc@xyz.com");
		

		dataMap.put("SaveUser", "");
		
		configAcctPage.configAcctAddNewUser(dataMap);
		

		//Searching the Acct User
		dataMap.put("SearchType","UserName"); 
		dataMap.put("SearchValue",userName); 
	
		configAcctPage.searchUser(dataMap);
		
		//Verifying search results
		
		boolean flag=false;
		
		SoftAssert softAssert=new SoftAssert();
		

		for(int i=0;i<configAcctPage.acctUserNameList().size();i++){
			
			String actUserName=configAcctPage.acctUserNameList().get(i).getText();
			
			if(actUserName.equalsIgnoreCase(dataMap.get("UserName"))){
				
			
				softAssert.assertEquals(actUserName, userName);
				Reporter.log("User Name Expected:"+userName+"::User Name Actual:"+actUserName,true);
				
				String actLogin=configAcctPage.acctUserLoginList().get(i).getText();
				
				softAssert.assertEquals(actLogin, login,"Logins Not Matched"+login+"::Actual:"+actLogin);
				Reporter.log("Login Expected:"+login+"::Login Actual:"+actLogin,true);
				
				String actAuditName=configAcctPage.acctUserAuditList().get(i).getText();
				String expAuditName=dataMap.get("AuditName");
				
				softAssert.assertEquals(actAuditName,expAuditName, "Expected Audit Name:"+expAuditName+"::Actual Audit Name:"+actAuditName);
				Reporter.log("Expected Audit Name:"+expAuditName+"::Actual Audit Name:"+actAuditName,true);
				
				String actEmailId=configAcctPage.acctUserEmailIdList().get(i).getText();
				String expEmailId=dataMap.get("EmailId");
				
				softAssert.assertEquals(actEmailId,expEmailId, "Expected Email Id:"+expEmailId+"::Actual Email Id:"+actEmailId);
				Reporter.log("Expected:"+expEmailId+"::Actual:"+actEmailId,true);
				
				click(configAcctPage.acctUserEditLinks().get(i));
				String nwuser="Auto"+currenttime();
				dataMap.put("UserName",nwuser);
				configAcctPage.fillAcctUser(dataMap);
				configAcctPage.formAcctUser(dataMap);
				
				dataMap.put("SearchValue",nwuser); 
				
				configAcctPage.searchUser(dataMap);
				
				for( int j=0;j<configAcctPage.acctUserNameList().size();j++){
					
					actUserName=configAcctPage.acctUserNameList().get(j).getText();
					
					if(actUserName.equalsIgnoreCase(nwuser)){
						softAssert.assertEquals(actUserName, nwuser);
						Reporter.log("User Name Expected:"+nwuser+"::User Name Actual:"+actUserName,true);
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
