
/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

package com.lavante.sim.customer.pageobjects.Login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class NotRegisteredPage {
	
	//Declare web driver
	private WebDriver driver=null;
	LavanteUtils lavanteUtils =new LavanteUtils();
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	
	@FindBy(css="a[href*='specifySupplierInformation']")
	private WebElement LnkTxtNotRegisteredLink;
	@FindBy(id="contactName")
	private WebElement IdcontactName;
	
	public NotRegisteredPage(WebDriver driver) {
		
			lavanteUtils.driver=driver;
		}


	/**
	 * Method Name : validateNotRegisteredLnk
	 * Purpose: Public method which includes logic related to click on the 'Not Registered' Link and validate
	 * 			the respective page appears (or) not
	 * @param: None
	 * @return: None
	 */
	public void validateNotRegisteredLnk() {
			lavanteUtils.waitForTime(4000);
			lavanteUtils.click(LnkTxtNotRegisteredLink);
			Reporter.log("Click on 'Not Registered' link is successful");
			lavanteUtils.waitForTime(4000);
			System.out.println("CLicked on not registered");
			lavanteUtils.isElementDisplayed(IdcontactName );
			Reporter.log("Verified 'Contact Name' field on Account Request page");
			Reporter.log("Validation is successful for 'Not Registered' link on Login page ");
			lavanteUtils.waitForTime(2000);		
	}
}

