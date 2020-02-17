/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

package com.lavante.sim.customer.pageobjects.Login;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class McafeePage   {

	//Declare web driver
	LavanteUtils lavanteUtils =new LavanteUtils();
	
	@FindBy(xpath="//img[contains(@alt,'McAf')]")
	private WebElement XpathMcAfeeLink;
	@FindBy(xpath="//*[@class='verifydate']")
	private WebElement IdMcafeeTrustedDate;
	
	private String McafeeDateFormat="yyyy-MM-dd";
	private String GenericTimeZone="GMT-7:00";
	
	private String strReplaceText="VERIFIED";
	
	
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	
	public McafeePage(WebDriver driver) {
		try {
			lavanteUtils.driver=driver;
		} catch (Exception e)  {						
		///	log.severe("Method: LoginPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
	}

	/**
	 * Method Name : validateMcafeeLnk
	 * Purpose: Public method which includes logic related to click on the Mcafee image and validates the Respective 
	 * 			trusted page appears with up to date
	 * @param: None
	 * @return: None
	 */
	public void validateMcafeeLnk() {
		//Initialize the variable
		String StrMcafeeDt ="";
		try {
			lavanteUtils.waitForTime(4000);
			if(XpathMcAfeeLink.isDisplayed()==true) {
				lavanteUtils.click(XpathMcAfeeLink);
			Reporter.log("Click on 'McAfee' link is successful");
			lavanteUtils.waitForTime(8000);
			}
			lavanteUtils.handleFirstChildWindow(true);
			lavanteUtils.waitForTime(4000);
			StrMcafeeDt = lavanteUtils.getText(IdMcafeeTrustedDate);
			lavanteUtils.waitForTime(4000);
			lavanteUtils.handleFirstChildWindow(false);
			lavanteUtils.waitForTime(4000);
			String strActual = getDateValue(McafeeDateFormat,GenericTimeZone);
			StrMcafeeDt = StrMcafeeDt.replace(strReplaceText,"");
			lavanteUtils.waitForTime(3000);
			if(strActual.equals(StrMcafeeDt)){
				Reporter.log("Verified that Lavante site is McAfee secure certified till date: " +StrMcafeeDt);
			} else {
			//	log.severe("Mcafee site is not up to date:" +StrMcafeeDt);
			}
		} catch(Exception e) {
			//log.severe("Exception in the method validate_McafeeLnk: "+e.getMessage());
			/*lavanteUtils.takeScreenshot("validate_McafeeLnk");
			Assert.assertTrue(false,"Exception in the method validateMcafeeLnk due to "+e.getMessage());*/
		}
	}

	/**
	 * Method Name : getDateValue
	 * Purpose: Public method which includes logic related to click on the Digicert image and validates the Respective 
	 * 			trusted page appears with up to date
	 * @param: None
	 * @return 
	 * @return: None
	 */
	public  String getDateValue(String strFormat, String strTimeZone) {
		String CalDate ="";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
			dateFormat.setTimeZone(TimeZone.getTimeZone(strTimeZone));
			CalDate = dateFormat.format(new Date());			
		}catch (Exception e){
		//	log.severe("Exception in the method getDateValue: "+e.getMessage());	
		}
		return CalDate;

	}

}
