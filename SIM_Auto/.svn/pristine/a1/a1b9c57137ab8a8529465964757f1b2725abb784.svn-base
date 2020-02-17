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
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class DigCertPage {
	
	@FindBy(how=How.XPATH,using="//img[contains(@alt,'Digi')]")
	private WebElement XpathDigiCertLink;
	public WebElement XpathDigiCertLink(){
		return XpathDigiCertLink;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='todays-date']")
	private WebElement IdDIgiCertTrustedDate;
	public WebElement IdDIgiCertTrustedDate(){
		return IdDIgiCertTrustedDate;
	}
	
	String GenericTimeZone="GMT-7:00";
	String DigCertDateFormat="MMM-dd-yyyy";
	
	
	//Declare web driver
	private WebDriver driver=null;
	LavanteUtils lavanteUtils=new LavanteUtils();
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	public DigCertPage(WebDriver driver) {
		try {
			//this.driver = driver;
			lavanteUtils.driver=driver;
		} catch (Exception e)  {						
		//	log.severe("Method: LoginPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
	}

	/**
	 * Method Name : validateDigiCertLnk
	 * Purpose: Public method which includes logic related to click on the Digicert image and validates the Respective 
	 * 			trusted page appears with up to date
	 * @param: None
	 * @return: None
	 */
	public void validateDigiCertLnk() {
		//Initialize the variable
			String StrDigiCertDt="";
			lavanteUtils.waitForTime(4000);
			lavanteUtils.click(XpathDigiCertLink);
			Reporter.log("Click on 'digicert trusted secure' link is successful");
			lavanteUtils.waitForTime(10000);
			lavanteUtils.handleFirstChildWindow( true);
			lavanteUtils.waitForTime(8000);
			StrDigiCertDt = lavanteUtils.getText(IdDIgiCertTrustedDate);
			lavanteUtils.waitForTime(4000);
			lavanteUtils.handleFirstChildWindow( false);
			lavanteUtils.waitForTime(4000);
			String strActual = getDateValue(DigCertDateFormat,GenericTimeZone);
			lavanteUtils.waitForTime(3000);
			if(strActual.equalsIgnoreCase(StrDigiCertDt)){
				Reporter.log("Lavante SIM is digicertified till date: " + StrDigiCertDt);
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
			//log.info("California Current Date: " + CalDate);
		}catch (Exception e){
			//log.severe("Exception in the method getDateValue: "+e.getMessage());	
		}
		return CalDate;
	}

}
