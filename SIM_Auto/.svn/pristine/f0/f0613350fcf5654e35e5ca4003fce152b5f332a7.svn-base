/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

package com.lavante.sim.customer.pageobjects.Recovery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class RecoveryPage {
	//Declare web driver
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	@FindBy(linkText="Looking for Lavante Supplier Information Management (SIM)?")
	private WebElement LnkTxtRecoverySIM;
	
	@FindBy(css="[href*='recovery']")
	private WebElement LnkTxtRecoveryLink;
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;

	public RecoveryPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}
	
	/**
	 * Method Name : validateRecoveryLnk
	 * Purpose: Public method which includes logic related to click on the 'Recovery Page' Link and validate
	 * 			the respective page appears (or) not
	 * @param: None
	 * @return: None
	 */
	public void validateRecoveryLnk() {

		try {
			lavanteUtils.waitForTime(4000);
			lavanteUtils.click(LnkTxtRecoveryLink);
			Reporter.log("Click on 'Looking for Lavante Recovery?' link is successful");
			lavanteUtils.waitForTime(5000);
			lavanteUtils.handleFirstChildWindow( true);
			lavanteUtils.waitForTime(4000);
			lavanteUtils.isElementDisplayed( LnkTxtRecoverySIM );
			Reporter.log("Verified 'Looking for Lavante Supplier Information Management (SIM)?' link on Lavante Recovery page");
			lavanteUtils.waitForTime(4000);			
			lavanteUtils.handleFirstChildWindow(false);
			lavanteUtils.waitForTime(2000);
			Reporter.log("Validation is successful for 'Looking for Lavante Recovery?' link on Login page ");
			lavanteUtils.waitForTime(4000);			
		}catch(Exception e) {
		//	log.severe("Exception in the method validate_RecoveryLnk: "+e.getMessage());
		//	lavanteUtils.takeScreenshot("validate_RecoveryLnk");
			Assert.assertTrue(false,"Exception in the method validateRecoveryLnk due to "+e.getMessage());
		}
	}	
}
