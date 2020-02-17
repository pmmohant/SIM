package com.lavante.sim.customer.TestScripts.Login;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 24-08-2016
 * Created for UAT TC
 * Ended on 28-08-2016
 * @author Nandini.R
 *
 */
public class UATLogoutTC extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 */
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		List<?> listofdatafrm=lavanteUtils.login("VMF", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
				
	
	}
	
	/**
	 * @author Nandini.R
	 */
	@Test
	public void logoutTC() throws Exception{
		
		Reporter.log("Test Started for logoutTC:"+currenttime());
		enobjhomePage.logout();
		lavanteUtils.fluentwait(enobjloginpage.usernameTxt());
		boolean a=enobjloginpage.usernameTxt().isDisplayed();
		Reporter.log("User Name Text Display Status Expected , True ,Actual:"+a);
		Assert.assertTrue(a,"Logout didnt happen properly");
		
		Reporter.log("Test Ended for logoutTC:"+currenttime());
	
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		quitBrowser();
		
	}
	
}










		




