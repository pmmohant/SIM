package com.lavante.configurator.TestScripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.configurator.Common.Util.LavanteUtils;
import com.lavante.configurator.pageobjects.pageInitiator;

/**
 * @author Piramanayagam
 *
 */
public class UserTest extends pageInitiator {
	String customerID="";
	
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
		String customerName=homePage.SelectBuyer("ANY");
		String query="select CustomerID from Customer where Name='"+customerName+"'";
		customerID=fetchDBdata(query);

		waitForTime(3000);
	}

	/**
	 * Add user and edit user
	 * 
	 * @author Priyanka 
	 */
	
	
	@Test(priority=1)
	public void AddEditUser() throws Exception{
		Reporter.log("Test Started at:"+currenttime());	
		SoftAssert softAssert= new SoftAssert();
		
		
		fluentwait(homePage.userMenu());
		click(homePage.userMenu());
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
		
		dataMap.put("UserName","piramu");
		dataMap.put("JobTitle", "SQA");
		dataMap.put("Department","Other");
		dataMap.put("Phone","98765734590" );
		dataMap.put("Fax","786890");
		dataMap.put("Email","pirmu@gmail.com" );
		dataMap.put("CreateUserAccount", "");
		dataMap.put("UserRole","Super SIM Customer" );
		dataMap.put("UserGroup","" );
		dataMap.put("Add","" );
		dataMap.put("FilterContactName","nandu");
		dataMap.put("Edit", "");
		userPage.addUser(dataMap);
	
	}
	@Test(priority=2)
	public void AddDeleteUser() throws Exception{
		
		AddEditUser(); //add user
		
		
	
		
	}
	
	
	
	/**
	 * After Class Logout and Quit Method 
	 * 
	 * @author Piramanayagam S
	 */
	
	@AfterClass
	  public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	  }
	
	
}
