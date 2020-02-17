package com.lavante.recovery.TestScripts.UAT;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

/**
 * @author Ramya.Raj
 *
 */
public class ConfigurationMailerRegistry extends pageInitiator {
	LavanteUtils lavanteUtils = new LavanteUtils();
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();
		
		lavanteUtils.driver=driver;
		loginPage.login();

		waitForTime(3000);
		homePage.verifyHomePageDisplayed();
		
		}
	

	@Test
	public void Mailerregistry() throws InterruptedException, FileNotFoundException, IOException{
		SoftAssert softAssert = new SoftAssert();

		lavanteUtils.fluentwait(configurationmailerregistryPage.configurationLink());
		lavanteUtils.click(configurationmailerregistryPage.configurationLink());
		waitForTime(3000);
		lavanteUtils.click(configurationmailerregistryPage.mailerRegistryLink());
		waitForTime(3000);
		
		
		String deposit = configurationmailerregistryPage.deposit().getAttribute("value");
		String expBalance = configurationmailerregistryPage.balance().getAttribute("value");
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		String audit=lavanteUtils.InitProperties("DefaultAudit");
		dataMap.put("AuditName",audit );
		dataMap.put("DateMailed","08/16/2017" );
		String Qty=""+randomnum(99);
		dataMap.put("LAVQty",Qty);
		dataMap.put("PMPQty","10");
		dataMap.put("USPSTotal", "100");
		dataMap.put("SaveRegistry", "");
		dataMap.put("SearchByAuditName", audit);
		
		waitForTime(6000);
		configurationmailerregistryPage.AddMailerRegistry(dataMap);
		
		configurationmailerregistryPage.SearchRegistry(dataMap);
		waitForTime(3000);
		
		for(int i=0;i<configurationmailerregistryPage.lavQtyValues().size();i++){
			String actName = configurationmailerregistryPage.lavQtyValues().get(i).getText();
			if(actName.equalsIgnoreCase(Qty)){
				softAssert.assertEquals(actName,Qty);
				
				String actauditName = configurationmailerregistryPage.auditNameValues().get(i).getText();
				String expauditName = dataMap.get("auditName");
				softAssert.assertEquals(actauditName, expauditName);
				
				String actuspsTotal = configurationmailerregistryPage.uspsTotalValues().get(i).getText();
				String expuspsTotal =dataMap.get("uspsTotal");
				softAssert.assertEquals(actuspsTotal, expuspsTotal);
				
				String actLAVQty = configurationmailerregistryPage.lavQtyValues().get(i).getText();
				String expLAVQty = dataMap.get("LAVQty");
				softAssert.assertEquals(actLAVQty, expLAVQty);
				
				String actPMPQty = configurationmailerregistryPage.pmpQtyValues().get(i).getText();
				String expPMPQty = dataMap.get("PMPQty");
				softAssert.assertEquals(actPMPQty, expPMPQty);
								
			}
		}
		waitForTime(3000);
		String actBalance1 = configurationmailerregistryPage.balance().getAttribute("value");
		System.out.println(actBalance1);
		
		waitForTime(3000);
		String B = dataMap.get("USPSTotal");
		
		double bal1 = Double.parseDouble(expBalance);
		double bal2 = Double.parseDouble(B);
		double expBalance1 = bal1-bal2;
		softAssert.assertEquals(expBalance1, actBalance1);
				
	}
	
	
	/**
		 * After Class Logout and Quit Method 
		 * 
		 * @author Ramya.Raj
		 */
		
		@AfterClass
		  public void QuitBrowser() {
			  homePage.logout();
			  quitBrowser();
		  }
		
		
		
	}


