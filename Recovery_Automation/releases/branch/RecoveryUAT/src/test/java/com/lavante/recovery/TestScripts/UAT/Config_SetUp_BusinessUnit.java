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

public class Config_SetUp_BusinessUnit extends pageInitiator {
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
		homePage.verifyHomePageDisplayed();
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("maintab","configuration");
        dataMap.put("subtab","configurationSetup");
        homePage.selectTab(dataMap);		
	}

	/**
	 * Method to add and edit Business Unit (Configuration ->SetUp ->Business Unit). 
	 * @author girish.n
	 */
	@Test
	public void addEditBuUnitTest(){
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		boolean flag=false;
		
		String expBuUnit="BU"+currenttime();
		String expRepBU="RepBU"+currenttime();
		String expLoc="Location"+currenttime();
		String expActStatus="Yes";
		SoftAssert softAssert=new SoftAssert();
		
		dataMap.put("BusinessUnit", expBuUnit);
		dataMap.put("ReportBU", expRepBU);
		dataMap.put("Location", expLoc);
		dataMap.put("Active", expActStatus);
		
		click(configSetUpPage.buUnitTab());
		
		waitForTime(5000);

		//Adding New Business Unit
		configSetUpPage.enterBusinessUnit(dataMap);
		
		//Verifying the Business Unit
		waitForTime(5000);
		
		for(int i=0;i<configSetUpPage.buUnitList().size();i++){
		
			String actBuUnit=configSetUpPage.buUnitList().get(i).getText().trim();
			if(actBuUnit.equals(expBuUnit)){
		
				softAssert.assertEquals(actBuUnit, expBuUnit);
				Reporter.log("Expected Business Unit:" + expBuUnit+"::Actual Business Unit:"+actBuUnit,true);
				
				String actRepBU=configSetUpPage.repBUList().get(i).getText().trim();
				softAssert.assertEquals(actRepBU, expRepBU);
				Reporter.log("Expected Report BU:" + expBuUnit+"::Actual Report BU:"+actRepBU,true);
				
				String actLoc=configSetUpPage.locationList().get(i).getText().trim();
				softAssert.assertEquals(actLoc, expLoc);
				Reporter.log("Expected Location:" + expLoc+"::Actual Location:"+actLoc,true);
				
				//Actual Active Status
				String actActStatus=configSetUpPage.actStatusList().get(i).getText().trim();
				softAssert.assertEquals(actActStatus, expActStatus);
				Reporter.log("Expected Active Status:" + expActStatus+"::Actual Active Status:"+actActStatus,true);
				
				//Edit business Unit
				expBuUnit="EditBU"+currenttime();
				expRepBU="EditRepBU"+currenttime();
				expLoc="EditLocation"+currenttime();
				expActStatus="Yes";
				
				dataMap.put("BusinessUnit", expBuUnit);
				dataMap.put("ReportBU", expRepBU);
				dataMap.put("Location", expLoc);
				dataMap.put("Active", expActStatus);
				
				click(configSetUpPage.buUnitList().get(i));
				configSetUpPage.enterBusinessUnit(dataMap);
				
				waitForTime(5000);
				
				for(int j=0;j<configSetUpPage.buUnitList().size();j++){
						
					actBuUnit=configSetUpPage.buUnitList().get(j).getText().trim();
					if(actBuUnit.equals(expBuUnit)){
				
						softAssert.assertEquals(actBuUnit, expBuUnit);
						Reporter.log("Expected Business Unit:" + expBuUnit+"::Actual Business Unit:"+actBuUnit,true);
						
						actRepBU=configSetUpPage.repBUList().get(j).getText().trim();
						softAssert.assertEquals(actRepBU, expRepBU);
						Reporter.log("Expected Report BU:" + expBuUnit+"::Actual Report BU:"+actRepBU,true);
						
						actLoc=configSetUpPage.locationList().get(j).getText().trim();
						softAssert.assertEquals(actLoc, expLoc);
						Reporter.log("Expected Location:" + expLoc+"::Actual Location:"+actLoc,true);
						
						//Actual Active Status
						actActStatus=configSetUpPage.actStatusList().get(j).getText().trim();
						softAssert.assertEquals(actActStatus, expActStatus);
						Reporter.log("Expected Active Status:" + expActStatus+"::Actual Active Status:"+actActStatus,true);
						
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
	 * Method to add and delete business unit(Configuration ->SetUp - >Business Unit)
	 * @author girish.n
	 */
	@Test
	public void addDeleteBuUnitTest(){
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		boolean flag=false;
		boolean delFlag=true;
		
		String expBuUnit="BU"+currenttime();
		String expRepBU="RepBU"+currenttime();
		String expLoc="Location"+currenttime();
		String expActStatus="Yes";
		
		dataMap.put("BusinessUnit", expBuUnit);
		dataMap.put("ReportBU", expRepBU);
		dataMap.put("Location", expLoc);
		dataMap.put("Active", expActStatus);
		
		click(configSetUpPage.buUnitTab());
		waitForTime(5000);
		//Adding New Business Unit
		configSetUpPage.enterBusinessUnit(dataMap);
		
		//Verifying the Business Unit
		
		SoftAssert softAssert=new SoftAssert();
		waitForTime(5000);
		
		for(int i=0;i<configSetUpPage.buUnitList().size();i++){
			
			String actBuUnit=configSetUpPage.buUnitList().get(i).getText().trim();
			if(actBuUnit.equals(expBuUnit)){
		
				softAssert.assertEquals(actBuUnit, expBuUnit);
				Reporter.log("Expected Business Unit:" + expBuUnit+"::Actual Business Unit:"+actBuUnit,true);
				
				String actRepBU=configSetUpPage.repBUList().get(i).getText().trim();
				softAssert.assertEquals(actRepBU, expRepBU);
				Reporter.log("Expected Report BU:" + expBuUnit+"::Actual Report BU:"+actRepBU,true);
				
				String actLoc=configSetUpPage.locationList().get(i).getText().trim();
				softAssert.assertEquals(actLoc, expLoc);
				Reporter.log("Expected Location:" + expLoc+"::Actual Location:"+actLoc,true);
				
				//Actual Active Status
				String actActStatus=configSetUpPage.actStatusList().get(i).getText().trim();
				softAssert.assertEquals(actActStatus, expActStatus);
				Reporter.log("Expected Active Status:" + expActStatus+"::Actual Active Status:"+actActStatus,true);
				
				//Delete Business Unit
				fluentwait(configSetUpPage.delLinkList().get(i));
				click(configSetUpPage.delLinkList().get(i));
				fluentwait(configSetUpPage.okBtn());
				click(configSetUpPage.okBtn());
				
				waitForTime(5000);
				for(int j=0;j<configSetUpPage.buUnitList().size();j++){
					actBuUnit=configSetUpPage.buUnitList().get(j).getText().trim();
					if(actBuUnit.equals(expBuUnit))
						delFlag=false;
				}	
				if(delFlag)
					flag=true;
				break;
			}
		}
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}
	
	@AfterClass
	public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	}
}

