/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */

package com.lavante.sim.customer.pageobjects.Login;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.*;

public class GmailLoginPage {
	String testCaseName=this.getClass().getSimpleName();
	Properties props=null;
	Properties browserProps=null;
	String methodName="";
	LavanteUtils lavanteUtils=new LavanteUtils();
	//Declare web driver
	private WebDriver driver=null;
	String 	GMAILURL="",expectedPageTitle="",expectedGoogleAccountsPageTitle="",IDEmail="",IDPasswd="",IDBtnsignIn="",IDRadioBtn="",xExpInvalidLoginErrors="",
			expGmailHomePageTitle="",xBtnInbox="",xBtnPrimaryMailTab="",xInboxMailRows="",xInboxMailRowsPrefix="",xInboxMailRowsSuffix=""
			,xSubjectLine="",linkTextAccountSetupPage="",linkTextHere="",xAccountSetupHeader="",
			expAccountsetupPageTitle="",expPageHeader="",IDPreferredLanguage="",IDUserName="",IDPassword="",IDConfirmPassword="",
			IDChallengeQ="",IDChallengeAnswer="",linkTextNotYourEmail="",linkTextTermsCondition="",linkTextHelpSetPwd="",
			linkTextHelpChangeQ="",expTextNotYourMail="",xIframeEmailPopup="",xEmailTerms="",xPrintTerms="",
			CssBtnOkEmailPopup="",xHeaderNotYourEmail="",xFieldErrorMsg="",CssBtnNext="",IDCheckBox="",expRegPageHeader="",
			IDTinEField="",xSignOutBtn="",xLogoutLogoBtn="",IDNextBtn="";

	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	public GmailLoginPage(WebDriver driver) {
		try {
			//initialize properties
			GMAILURL=browserProps.getProperty("GMAILURL");
			//ID properties

			IDNextBtn=props.getProperty("next");
			IDEmail=props.getProperty("email");
			IDPasswd=props.getProperty("passwd");
			IDBtnsignIn=props.getProperty("btnsignIn");
			IDRadioBtn=props.getProperty("radioBtn");
			IDPreferredLanguage=props.getProperty("preferredLanguage");
			IDUserName=props.getProperty("userName");
			IDPassword=props.getProperty("password");
			IDConfirmPassword=props.getProperty("confirmPassword");
			IDChallengeQ=props.getProperty("challengeQ");
			IDChallengeAnswer=props.getProperty("challengeAnswer");
			IDCheckBox=props.getProperty("checkBox");
			IDTinEField=props.getProperty("tinEField");
			// XPath Properties
			xSignOutBtn=props.getProperty("signOutBtn");
			xLogoutLogoBtn=props.getProperty("logoutLogoBtn");
			xFieldErrorMsg=props.getProperty("fieldErrorMsg");
			xEmailTerms=props.getProperty("emailTerms");
			xPrintTerms=props.getProperty("printTerms");
			xHeaderNotYourEmail=props.getProperty("headerNotYourEmail");
			xIframeEmailPopup=props.getProperty("iframeEmailPopup");
			xExpInvalidLoginErrors=props.getProperty("expInvalidLoginErrors");
			xBtnInbox=props.getProperty("btnInbox");
			xBtnPrimaryMailTab=props.getProperty("btnPrimaryMailTab");
			xInboxMailRows=props.getProperty("inboxMailRows");
			xInboxMailRowsPrefix=props.getProperty("inboxMailRowsPrefix");
			xInboxMailRowsSuffix=props.getProperty("inboxMailRowsSuffix");
			xAccountSetupHeader=props.getProperty("accountSetupHeader");
			xSubjectLine=props.getProperty("subjectLine");
			// Link Text Properties
			linkTextNotYourEmail=props.getProperty("notYourEmail");
			linkTextAccountSetupPage=props.getProperty("accountSetupPage");
			linkTextHere=props.getProperty("clickHere");
			linkTextTermsCondition=props.getProperty("linkTextTermsCondition");
			linkTextHelpSetPwd=props.getProperty("helpSetPwd");
			linkTextHelpChangeQ=props.getProperty("helpChangeQ");
			//CSS Properties
			CssBtnOkEmailPopup=props.getProperty("btnOkEmailPopup");
			CssBtnNext=props.getProperty("btnNext");
			//#Expected text values 
			expGmailHomePageTitle=props.getProperty("expGmailHomePageTitle");
			expectedPageTitle=props.getProperty("expectedPageTitle");
			expectedGoogleAccountsPageTitle=props.getProperty("expectedGoogleAccountsPageTitle");
			expTextNotYourMail=props.getProperty("expTextNotYourMail");
			expAccountsetupPageTitle=props.getProperty("expAccountsetupPageTitle");
			expPageHeader=props.getProperty("expPageHeader");
			expRegPageHeader=props.getProperty("expRegPageHeader");

		
		} catch (Exception e)  {						
			//log.severe("Method: LoginPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
	}
	/**
	 * Method Name : navigateToGmailApplication
	 * Purpose: Method to navigate to navigateToGmailApplication URL
	 * @param: None
	 * @return: None
	 * @throws MalformedURLException 
	 */
	public void navigateToGmailApplication() throws MalformedURLException{
		this.driver=chrsetup();
	//	Reporter.log("\n");
	//	driver=chrsetup();
		//log.info("Navigation to G-Mail is successful with URL: " + GMAILURL);
		String actualPageTitle = "";
		try {
			System.out.println(driver+GMAILURL);
			driver.get(GMAILURL);
			lavanteUtils.waitForTime(30000);
			actualPageTitle = driver.getTitle().trim().toString();
			if (actualPageTitle.endsWith(expectedPageTitle)) {
				Reporter.log("Navigation to G-Mail is successful with URL: " + GMAILURL);
			} else if (actualPageTitle.endsWith(expectedGoogleAccountsPageTitle)) {
				Reporter.log("Navigation to G-Mail is successful with URL: " + GMAILURL);
			} else {
				//log.severe("Expected page doesn't displayed   "	+ "    Actual title:   " + actualPageTitle	+ " Expected title:   " + expectedPageTitle +" or "+ expectedGoogleAccountsPageTitle);
				Assert.assertTrue(false, "  Actual page title:    " + actualPageTitle + "    Expected page title:    " + expectedPageTitle +" or "+ expectedGoogleAccountsPageTitle);
			}
		} catch (Exception e) {
			//log.severe("Exception in the method navigateToGmailApplication due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method navigateToGmailApplication due to "+e.getMessage());
		}
	}



	/**
	 * Method Name : validateGMailLogin
	 * Purpose: Method to validate G mail login with valid Credentials
	 * @param: None
	 * @return: None
	 */

	public boolean validateGMailLogin(List<setTestData> objTDForGmailUsers){
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		WebElement radioBtn=null;
		String getErrorMsg="";
		try {
			for(int i=0;i<objTDForGmailUsers.size();i++){
				lavanteUtils.waitForTime(2000);
					lavanteUtils.typeinEdit(objTDForGmailUsers.get(i).getUserName().toString(),driver.findElement(By.xpath(IDEmail)));
					//gp.typeinEdit(driver,ConfigPathFile.ID.getConstantValue(),IDEmail,objTDForGmailUsers.get(i).getUserName().toString());
					Reporter.log("Entered G-mail User Name: "+objTDForGmailUsers.get(i).getUserName().toString());
				
				if(lavanteUtils.isElementDisplayed(driver.findElement(By.id(IDNextBtn)))==true){
					lavanteUtils.click(driver.findElement(By.id(IDNextBtn)));
					lavanteUtils.waitForTime(2000);
				}
				lavanteUtils.typeinEdit(objTDForGmailUsers.get(i).getPassword().toString(),driver.findElement(By.id(IDPasswd)));
				Reporter.log("Entered G-mail Password: "+objTDForGmailUsers.get(i).getPassword().toString());
				if(lavanteUtils.isElementDisplayed(driver.findElement( By.id(IDRadioBtn)))==true){
					radioBtn=driver.findElement(By.id(IDRadioBtn));
					if(radioBtn.isSelected()){
						radioBtn.click();
					}
				}
				lavanteUtils.click(driver.findElement(By.id(IDBtnsignIn)));
				Reporter.log("Clicked on the SignIn Button");
				if(lavanteUtils.isElementDisplayed(driver.findElement( By.xpath(xExpInvalidLoginErrors)))==true){
					getErrorMsg=lavanteUtils.getText(driver.findElement(By.xpath(xExpInvalidLoginErrors)));
					//log.severe("Test Failed Due To: "+getErrorMsg+" for a given users credentials , G-mail user Name: "+objTDForGmailUsers.get(i).getUserName().toString()+" G-mail password: "+objTDForGmailUsers.get(i).getPassword().toString());
					lavanteUtils.takeScreenshot(driver, methodName);
					Assert.assertTrue(false,"Test is Failed Due To: "+getErrorMsg+" for a given user credentials, G-mail user Name: "+objTDForGmailUsers.get(i).getUserName().toString()+" G-mail password: "+objTDForGmailUsers.get(i).getPassword().toString());
				}else if(lavanteUtils.isElementDisplayed(driver.findElement( By.xpath(xBtnInbox)))==true){
					lavanteUtils.assertPageTitle(expGmailHomePageTitle);
					Reporter.log("Logged into G-mail successfully");
					return true;
				}else{
					//log.severe("Test Failed due to user is not able to login to Gmail Application, for a given users credentials , user Name: "+objTDForGmailUsers.get(i).getUserName().toString()+" password: "+objTDForGmailUsers.get(i).getPassword().toString());
					lavanteUtils.takeScreenshot(driver, methodName);
					Assert.assertTrue(false,"Test is Failed due to user is not able to login to Gmail Application, for a given users credentials , user Name: "+objTDForGmailUsers.get(i).getUserName().toString()+" password: "+objTDForGmailUsers.get(i).getPassword().toString());

				}

			}
		} catch (Exception e) {
			//log.severe("Exception in the method validateUserLogin "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateUserLogin "+e.getMessage());
		}
		return false;

	}

	/**
	 * Method Name : readMails
	 * Purpose: Method to read G-mail with respective subject line and verify there are no mails received from a given supplier
	 * @param: objSupplierSubTestData,String subject
	 * @return: None
	 */
	public void verifyReadMails(setTestData objSupplierSubTestData,String subject){
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(driver.findElement(By.xpath(xBtnInbox)));
		lavanteUtils.click(driver.findElement(By.xpath(xBtnInbox)));
		lavanteUtils.fluentwait(driver.findElement(By.xpath(xInboxMailRows)));
		List<WebElement>listRecMails=driver.findElements(By.xpath(xInboxMailRows));
		//loop
		for(int i=1;i<=listRecMails.size();i++){
			lavanteUtils.waitForTime(1000);
			if(driver.findElement(By.xpath(xInboxMailRowsPrefix+i+xInboxMailRowsSuffix)).getText().contains(subject)){
				//log.severe("Test failed due to Invitation Email received from a given supplier: " + subject);
				lavanteUtils.takeScreenshot(driver, methodName);
				Assert.assertTrue(false,"Test failed due to Invitation Email received from a given supplier: " + subject);				
				break;
			} else {
				if(i==listRecMails.size()){				
					Reporter.log("Verification is successful due to there are no mails received from a given supplier: " + subject);
				}
			}
		}
	}

	/**
	 * Method Name : readMails
	 * Purpose: Method to read G-mail with respective subline 
	 * @param: List setTestData,String supplierSubKey
	 * @return: None
	 */
	public String readMails(setTestData objSupplierSubTestData,String subject,String operation){
		String str_ret="";
		boolean bool_bl=false;
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		String actSubjectLine="";
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(driver.findElement(By.xpath(xBtnInbox)));;
		lavanteUtils.click(driver.findElement(By.xpath(xBtnInbox)));
		//gp.clicks(driver,ConfigPathFile.XPATH.getConstantValue(),xBtnPrimaryMailTab);
		lavanteUtils.fluentwait(driver.findElement(By.xpath(xInboxMailRows)));
		List<WebElement>listRecMails=driver.findElements(By.xpath(xInboxMailRows));
		System.out.println(listRecMails.size());
		String exp_sub="";
		int x=0;
		int j=0;
		int retrycount=50;
		while(bool_bl==false){ System.out.println("Entering While loop");
		if(j<retrycount) { System.out.println("Trying for"+j);
		j++;
		
		lavanteUtils.waitForTime(2500);
		driver.findElement(By.xpath("//*[contains(@title,'Inbox')]")).click();
		lavanteUtils.waitForTime(2500);
		listRecMails=driver.findElements(By.xpath(xInboxMailRows));
		for(int i=1;i<=listRecMails.size();i++){
			List<String> lst_sub=new ArrayList<String>();
			lst_sub.clear();
			lst_sub=sortDataforTest(subject);
			
			exp_sub=driver.findElement(By.xpath(xInboxMailRowsPrefix+i+xInboxMailRowsSuffix)).getText();			
			System.out.println(exp_sub+":APP SUB");
			System.out.println(subject+":B4_SPLIT");
			System.out.println(lst_sub.get(0)+":lst_sub.get(0)");
			System.out.println(lst_sub.get(1)+":lst_sub.get(1)");
			if(!(lst_sub.size()==1)){
				if(exp_sub.contains(lst_sub.get(0)) && exp_sub.contains(lst_sub.get(1)))
				{	bool_bl=true;
					x=i;
				break;
				}
			}		
		}
		}if(j==retrycount){
			break;
		}
		}
		System.out.println("OOL");	
			if(bool_bl||exp_sub.contains(subject)){
				lavanteUtils.click(driver.findElement(By.xpath(xInboxMailRowsPrefix+x+xInboxMailRowsSuffix)));
				Reporter.log(" Invitation Email received from | " + subject + " | and able to open the Email successfully ");
				
			}else{
				clickLogoutBtn();
				//log.severe("Test failed due to there are no mails received from a given supplier: "+subject);
				lavanteUtils.takeScreenshot(driver, methodName);
				Assert.assertTrue(false,"Test failed due to there are no mails received from a given supplier: "+subject);
			}
		
		
		
		if(lavanteUtils.isElementDisplayed(driver.findElement( By.xpath(xSubjectLine)))) {
			actSubjectLine=lavanteUtils.getText(driver.findElement(By.xpath(xSubjectLine)));
			List<String> lst_sub=new ArrayList<String>();
			lst_sub.clear();
			lst_sub=sortDataforTest(subject);

			if(!(lst_sub.size()==1)){
				if(actSubjectLine.contains(lst_sub.get(0)) && actSubjectLine.contains(lst_sub.get(1)))
					bool_bl=true;
				else
					bool_bl=false;
			}

			if(bool_bl||actSubjectLine.contains(subject)){ System.out.println(operation);
				switch (operation) { 
				case "Subject":
					Reporter.log("Validation is successful for 'Send Email' functionality: ");
					break;
				case "ReInviteStatus":
					//if (subject.equalsIgnoreCase(subject)){
					Reporter.log("Validation is successful for 'Re Invite' functionality: ");
					//}
					break;
				case "PreScreening":
					Reporter.log("Validation is successful for 'PreScreening' functionality: ");
					break;
				case "Click":
					str_ret=clickOnAcctSetupPageLink();
					break;
				default:
					break;
				}	
			}else{
				//log.severe("Test failed due to expected subject: "+subject+" does not matched with the actual: "+actSubjectLine);
				lavanteUtils.takeScreenshot(driver, methodName);
				Assert.assertTrue(false,"Test failed due to expected subject: "+subject+" does not matched with the actual: "+actSubjectLine);
			}


		}else {
			lavanteUtils.fluentwait(driver.findElement(By.xpath(xBtnInbox)));
			lavanteUtils.click(driver.findElement(By.xpath(xBtnInbox)));
		}
		return str_ret;

	}

	/**
	 * Method Name : clickOnAcctSetupPageLink
	 * Purpose: Method to gp.clicks On AcctSetupPage Link 
	 * @param: None
	 * @return: None
	 */
	public String clickOnAcctSetupPageLink(){
		String str_ret="";
		lavanteUtils.waitForTime(2000);
		if(lavanteUtils.isElementDisplayed(driver.findElement( By.linkText(linkTextAccountSetupPage)))){ 
			//gp.clicks(driver,ConfigPathFile.LINKTEXT.getConstantValue(), linkTextAccountSetupPage);
			str_ret=driver.findElement(By.xpath("//a[contains(@href,'/sim/supplierAccountSetup.lvp')]")).getAttribute("href");
			//str_ret=driver.getCurrentUrl();
		}else if(lavanteUtils.isElementDisplayed(driver.findElement( By.linkText(linkTextHere)))){
			//gp.clicks(driver,ConfigPathFile.LINKTEXT.getConstantValue(),linkTextHere);
			str_ret=driver.findElement(By.xpath("//a[contains(@href,'https://test.lavante.com/sim/supplierAccountSetup.lvp')]")).getAttribute("href");
			//str_ret=driver.getCurrentUrl();
			Reporter.log("Clicked on the |Account Setup Page| link successfully");
		}else{
			//log.severe("Test failed due to no expected links are not available to open the account setup page ");
			lavanteUtils.takeScreenshot(driver, methodName);
			Assert.assertTrue(false,"Test failed due to expected links are not available to open the account setup page ");
		}
		return str_ret;
	}
	/**
	 * Method Name : clickLogoutBtn
	 * Purpose: Method to gp.clicks On Logout Button
	 * @param: None
	 * @return: None
	 */
	public void clickLogoutBtn(){
		lavanteUtils.waitForTime(1500);
		lavanteUtils.click(driver.findElement(By.xpath(xLogoutLogoBtn)));
		Reporter.log("Clicked on the |G mail Logout| Logo successfully");
		lavanteUtils.click(driver.findElement(By.xpath( xSignOutBtn)));
		Reporter.log("Clicked on the |G mail Sign Out| Button successfully");
		lavanteUtils.waitForTime(2500);
		driver.manage().deleteAllCookies();
		driver.close();
		if(!driver.equals(null)){
			driver.quit();
		}
	}

	public List<String> sortDataforTest(String str_data){

		String[] split_btns = str_data.split(",");// separate the button names in excel by a
		// comma in between
		List<String> list_btns = new ArrayList<String>(
				Arrays.asList(split_btns));
		return list_btns;
	}

	public static WebDriver chrsetup() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "D:\\Lavante_automation_workspace\\SIM_UAT\\src\\test\\resources\\ChromeDriver.exe");
		
		//System.setProperty("webdriver.chrome.driver", ".."+File.separator+"Automation_UAT_60"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ChromeDriver.exe");
		
		ChromeDriver chrdriver=new ChromeDriver();
		chrdriver.manage().window().maximize();
		return chrdriver;
		
		/*if(System.getProperty("RemoteExecution").equalsIgnoreCase("true")){
			String strRemoteURL=System.getProperty("RemoteURL");
			DesiredCapabilities caps = new DesiredCapabilities();
			URL remoteAddress = new URL(strRemoteURL + "/wd/hub");
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--test-type");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			return new RemoteWebDriver(remoteAddress, caps);
		}else{
			ChromeDriver chrdriver=new ChromeDriver();
			chrdriver.manage().window().maximize();
			return chrdriver;
		}*/
	}

}
