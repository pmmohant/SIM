/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari 
 */ 

package com.lavante.sim.customer.pageobjects.Login;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.*;

/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

public class ForgotPasswordPage {

	//Declare web driver
	private WebDriver driver=null;
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	@FindBy(id="UserName")
	private WebElement IduserName;
	
	@FindBy(css="[href*='forgot']")
	private WebElement LnkTxtForgotPasswordLink;
	

	/**
	 * Method Name : validateForgotPasswdLnk
	 * Purpose: Public method which includes logic related to click on the 'Forgot Password' Link and validate
	 * 			the respective page appears (or) not
	 * @param: None
	 * @return: None
	 */
	public void validateForgotPasswdLnk() {
		
		try {
			lavanteUtils.waitForTime(4000);
			lavanteUtils.click("LnkTxtForgotPasswordLink",LnkTxtForgotPasswordLink);			
			Reporter.log("Click on 'Forgot Password' link is successful");
			lavanteUtils.waitForTime(2000);	
			lavanteUtils.verifyElementDisplayed("IduserName",IduserName);
			Reporter.log("Verified 'User Name' field on Forgot your password? page");
			Reporter.log("Validation is successful for 'Forgot Password' link on Login page ");
			lavanteUtils.waitForTime(2000);
		}catch(Exception e) {
		// log.severe("Exception in the method validate_ForgotPasswdLnk: "+e.getMessage());
			/*lavanteUtils.takeScreenshot(driver,"validate_ForgotPasswdLnk");
			Assert.assertTrue(false,"Exception in the method validateForgotPasswdLnk due to "+e.getMessage());*/
		}
	}	
}
