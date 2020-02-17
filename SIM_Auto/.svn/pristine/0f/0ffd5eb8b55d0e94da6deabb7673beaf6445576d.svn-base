/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy/Venkata Ravi Majjari
 */

package com.lavante.sim.customer.pageobjects.Login;

import java.util.List;
import java.util.Properties;


//import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExpiredUserDataFromSQL;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.HomePage.HomePage;

public class LoginPage {

	String testCaseName=this.getClass().getSimpleName();
	Properties browserProps=null;
	String methodName="";
	HomePage objHomePage=null;

	
	LavanteUtils lavanteUtils=new LavanteUtils();
	public WebDriver driver=null;
	public LoginPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	// Page Objects 
	
	String APPURL = null;
	String expectedPageTitle = "Lavante SIM";	
	String ExpectedMsg = "Password Updated Successfully";
	String expExpiredMessage = "Please create a new password as your current password has expired";
	String expiredUserCredentials="Expired User credentials";
	String expDeactivatedUserMsg= "Your account has been deactivated. Please contact Lavante support or your customer for more information.";
	
	@FindBy(id="username")
	private WebElement IDuserName;

	@FindBy(id="password")
	private WebElement IDpassword;
	
	@FindBy(id="currentPassword")
	private WebElement IDcpassword;
	
	@FindBy(id="userName")
	private WebElement userName;
	
	@FindBy(how=How.CSS,using="a[class*='user-info']")
	private WebElement UserName;
	
	@FindBy(css="li [id*='logout']")
	private WebElement IDlogOut;
	
	@FindBy(id="newPassword")
	private WebElement IDnewPassword;
	
	@FindBy(id="confirmPassword")
	private WebElement IDconfirmPassword;
	
	@FindBy(id="status")
	
	private WebElement IDstatus;
	@FindBy(id="currentPassword")
	private WebElement IDcurrentPassword;
	
	@FindBy(id="resetPassword")
	private WebElement IDresetPassword;
	
	@FindBy(id="00J")
	private WebElement IDFrame;
	
	@FindBy(id="012")
	private WebElement IDFrame012;
	
	@FindBy(id="contactName")
	private WebElement contactName;
	
	@FindBy(id="Looking for Lavante Supplier Information Management (SIM)?")
	private WebElement RecoverySIM;
	
	@FindBy(xpath="html/body/div[2]/div/table/tbody/tr/td[1]/div/div[1]/table/tbody/tr/td[2]/div")
	private WebElement McafeeTrustedDate;
	
	@FindBy(id="todays-date")
	private WebElement DIgiCertTrustedDate;
	
	@FindBy(xpath="//td/span[contains(@class,'error')]")
	private WebElement xResetFieldErrorMsg;
	
	@FindBy(xpath=".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement xIFrameNewLogout;
	
	@FindBy(xpath="//h4")
	private WebElement XpathResetPwdMsg;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement XloginBtn;
	
	@FindBy(xpath="//input[contains(@class,'button button_green')]")
	private WebElement XpathSaveBtn;
	
	@FindBy(xpath = "//div[@class='align_right button_set']/a[@class='button button_blue']")
	private WebElement xpathPopupLogout;
	
	@FindBy(xpath = "//form[contains(@id,'command')]/div[1]/span")
	private WebElement expiredText;
	
	@FindBy(xpath = "//div[contains(@id,'content')]/table/tbody/tr[1]/td[2]/div")
	private WebElement deactivateMsg;
	
	@FindBy(xpath = "//table/tbody/tr/td/div[2]")
	private WebElement CopyRights;
	
	@FindBy(xpath = "//a/img[contains(@alt,'McAfee SECURE')]")
	private WebElement McAfeeLink;
	
	@FindBy(xpath = "//img[contains(@src,'digicert')]")
	private WebElement DigiCertLink;
	
	@FindBy(linkText="here")
	private WebElement LinkClickHere;
	
	@FindBy(linkText="Not Registered")
	private WebElement NotRegisteredLink;
	
	@FindBy(linkText="Forgot Password")
	private WebElement ForgotPasswordLink;
	
	@FindBy(linkText="Looking for Lavante Recovery?")
	private WebElement RecoveryLink;
	
	@FindBy(css="*[value='Ok'][class='button button_green ajax']")
	private WebElement CSSPopupOkBtn;
	
	
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
/*	public LoginPage(WebDriver driver) {
		
	//	objHomePage = PageFactory.initElements(driver, HomePage.class);
		
		try {
			this.driver=driver;
			
		} catch (Exception e)  {						
			
		//	log.severe("Method: LoginPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
		
	}*/
	
	
	/**
	 * Method Name : navigateToApplication
	 * Purpose: Method to navigate to navigateToApplication URL
	 * @param: None
	 * @return: None
	 */
	public void navigateToSIMApplication(){
		try {  System.out.println("INTIALTE URL"+driver);
			driver.get(APPURL);
			//driver.get("");
			lavanteUtils.waitForTime(2000);
			//gp.assertPageTitle(driver,expectedPageTitle);
			Reporter.log("Navigation is successful to SIM Application and verified expected page title as: '" + expectedPageTitle + "'");
			System.out.println("SIM"+driver);
		} catch (Exception e) {
		//	log.severe("Exception in the method navigateToSIMApplication due to "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method navigateToSIMApplication due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : validateUserLogin
	 * Purpose: Method to validate login Credentials
	 * @param: None
	 * @return: None used the same method as dummy created by me
	 */
	public void validateUserLogin(List<setTestData> getUserCredentials){
		try {
			
			int i;
			
			for(i=0;i<getUserCredentials.size();i++){
				lavanteUtils.waitForTime(2000);
				/*driver.findElement(By.id("username")).sendKeys(getUserCredentials.get(i).getUserName().toString());
				driver.findElement(By.id("password")).sendKeys(getUserCredentials.get(i).getPassword().toString());*/
				
				lavanteUtils.enterText("IDuserName", IDuserName, getUserCredentials.get(i).getUserName().toString());
				lavanteUtils.enterText("IDpassword", IDpassword, getUserCredentials.get(i).getUserName().toString());
				driver.findElement(By.xpath("//*[@name='submit']")).click();
				
				//click(driver,ConfigPathFile.XPATH.getConstantValue(),XloginBtn);
				Reporter.log("click on Login button is successful");
			//	verifyMultipleLogins(getUserCredentials.get(i).getUserDetails().toString(),getUserCredentials,i);
				
			}
		} catch (Exception e) {
	//		log.severe("Exception in the method validateUserLogin "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateUserLogin "+e.getMessage());
		}
	}
	
	/**
	 * Method Name : verify_ExpiredUser_Login
	 * Purpose: Public method which includes logic related to get the Expired User credentials from the data base and validate
	 * @param:  List<setTestData> getDataBaseQuery
	 * @return: None
	 */
	public void verify_ExpiredUser_Login(List<setTestData> getDataBaseQuery){
		List<String> expiredUserData=null; int k=0;
		try{
			//SQL Data base object creation for expired user credentials of Login
			GetExpiredUserDataFromSQL objDataBase=new GetExpiredUserDataFromSQL();
			expiredUserData = objDataBase.expiredUserDataExtract(getDataBaseQuery, expiredUserCredentials);
			Reporter.log("Fetched 'Expired Users' Count from Data base:" + expiredUserData.size());
			lavanteUtils.waitForTime(2000);
			for(int j=0;j<expiredUserData.size();j++) {
				if(!(expiredUserData.get(j).toString().isEmpty()) ){
					Reporter.log("\n");
					String sUserName=expiredUserData.get(j).trim().toString();
					String SPassword= getDataBaseQuery.get(k).getPassword().trim().toString();
					verify_ExpiredLogin(sUserName,SPassword);
					lavanteUtils.waitForTime(3000);
					driver.navigate().back();
					lavanteUtils.waitForTime(4000);
				}
				if(j==1){
					break;
				}
			}
		} catch(Exception e){
		//	log.severe("Exception in the method verify_ExpiredUser_Login " +e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_ExpiredUser_Login "+e.getMessage());
		}
	}

	/**
	 * Method Name : verify_Deactivated_Supplier
	 * Purpose: Public method which includes logic related to verify the Deactivated supplier has to be associated 
	 * 			with only one Customer.
	 * @param:  List<setTestData> getUserCredentials
	 * @return: None
	 */
	public void verify_Deactivated_Supplier(List<setTestData> getUserCredentials){
		try{
			for (int i=0;i<getUserCredentials.size();i++){
				if(!(getUserCredentials.get(i).getUserName().trim().toString().equalsIgnoreCase(""))){
					String sUserName=getUserCredentials.get(i).getUserName().trim().toString();
					String sPassword=getUserCredentials.get(i).getPassword().trim().toString();
					lavanteUtils.waitForTime(2000);
					lavanteUtils.enterText("IDuserName",IDuserName, sUserName);
					lavanteUtils.enterText("IDpassword", IDpassword,sPassword);
					lavanteUtils.click("XloginBtn",XloginBtn);
					
					if(lavanteUtils.isElementDisplayed(driver.findElement(By.xpath("//div[@id='status']")))){
						String strExpMsg=lavanteUtils.getText(driver.findElement(By.xpath( "//div[@id='status']")));
						if(strExpMsg.trim().toString().equalsIgnoreCase(expDeactivatedUserMsg.trim().toString())){
							Reporter.log("Verification is successful for Deactivated User name: " + sUserName +
									" with Expected: " + strExpMsg + " And Actual: " + expDeactivatedUserMsg);
							break;
						} else {
						//	log.severe("Test failed due to validation failed: for Deactivated User name: " + sUserName +
							//		" with Expected: " + strExpMsg + " And Actual: " + expDeactivatedUserMsg);
							lavanteUtils.takeScreenshot(driver, "verify_ExpiredLogin");
							/*Assert.assertTrue(false,"Test failed due to validation failed: for Deactivated User name: "
									+ sUserName + " with Expected: " + strExpMsg + " And Actual: " + expDeactivatedUserMsg);	*/
						}
					} else {
						//log.severe("verification failed due to page did not navigate to De-activate page:");
						//lavanteUtils.takeScreenshot(driver, "verify_ExpiredLogin");
						//Assert.assertTrue(false,"Test failed due to did not navigate to de-activate supplier page:");
					}
				} else {
					continue;
				}
			}
		}catch(Exception e){
		//	log.severe("Exception in the method verify_Deactivated_Supplier "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_Deactivated_Supplier "+e.getMessage());
		}
	}

	/**
	 * Method Name : verify_ExpiredLogin
	 * Purpose: Public method which includes logic related to verify the Expired User Credentials
	 * @param:  String sUserName, String sPassword
	 * @return: None
	 */
	public void verify_ExpiredLogin(String sUserName, String sPassword) {

		try{
			if(!(sUserName.trim().toString().equalsIgnoreCase(""))){
				lavanteUtils.waitForTime(2000);
				lavanteUtils.enterText("IDuserName",IDuserName, sUserName);
				lavanteUtils.enterText("IDpassword", IDpassword,sPassword);
				lavanteUtils.click("XloginBtn",XloginBtn);
				Reporter.log("clicked on the Login button");
				lavanteUtils.verifyElementDisplayed("expiredText",expiredText);
				String strExpMsg=lavanteUtils.getText("expiredText",expiredText);
					if(strExpMsg.trim().toString().equalsIgnoreCase(expExpiredMessage.trim().toString())){
						Reporter.log("Verification is successful for Expired User name: " + sUserName +
								" with Expected: " + strExpMsg + " And Actual: " + expExpiredMessage);						
					} else {
					//	log.severe("Test failed due to validation failed: for Expired Usder name: " + sUserName +
					//			" with Expected: " + strExpMsg + " And Actual: " + expExpiredMessage);
						lavanteUtils.takeScreenshot(driver, "verify_ExpiredLogin");
						/*Assert.assertTrue(false,"Test failed due to validation failed: for Expired User name: " + sUserName +
								" with Expected: " + strExpMsg + " And Actual: " + expExpiredMessage);*/
					}
				}

		}catch(Exception e){
		//	log.severe("Exception in the method verify_ExpiredLogin "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_ExpiredLogin "+e.getMessage());
		}
	}

	/**
	 * Method Name : validateUsersLogin
	 * Purpose: Public method which validates the User Login with invalid and valid inputs
	 * @param:  None
	 * @return: None
	 */
	public void verifyMultipleLogins(String operation,List<setTestData> getUserCredentials, int i){

		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		String getErrorMsg="";
		switch (operation) {
		case "InvalidUsers":
			if(lavanteUtils.verifyElementDisplayed("IDstatus",IDstatus)==true){
				getErrorMsg=lavanteUtils.getText("IDstatus",IDstatus);
				if((getErrorMsg.toString().contains(getUserCredentials.get(i).getErrorMessage().toString()))){
					Reporter.log("Validadtion message is as expected as : '"+getErrorMsg + "'"); // for the given user name: "+getUserCredentials.get(i).getUserName()+"  and password: "+getUserCredentials.get(i).getPassword());	
				}else{
			//		log.severe("Test is failed as validation message is not same as expected: Expected is '"+getUserCredentials.get(i).getErrorMessage().toString()+"'. Actual message is: '"+getErrorMsg +"'");
					lavanteUtils.takeScreenshot(driver, methodName);
					//Assert.assertTrue(false,"Test is failed as validation message is not same as expected: Expected is '"+getUserCredentials.get(i).getErrorMessage().toString()+"' Actual message is: '"+getErrorMsg+"'");
				}
			}else{
			//	log.severe("Test failed as there are no error messages displayed for the given login credentials");
				lavanteUtils.takeScreenshot(driver, methodName);
				//Assert.assertTrue(false,"Test failed as there are no error messages displayed for the given login credentials");
			}
			break;

		case "ValidUsers":
			if(lavanteUtils.verifyElementDisplayed("IDlogOut",IDlogOut)==true){
				Reporter.log("Login is successful. Logout link is verified successfully on Home page");
				logout();
			}else{
			//	log.severe("Test is failed. Login is not successful");
				lavanteUtils.takeScreenshot(driver, methodName);
				//Assert.assertTrue(false,"Test is failed. Login is not successful");
			}

			break;

		case "ExpiredUsersPwd":
			Reporter.log("Validate Reset Password");
			if (lavanteUtils.verifyElementDisplayed("IDlogOut",IDcurrentPassword)==true)
			{ 
	//			validateResetPassword(getUserCredentials,i);
			}else{
		//		log.severe("Test is failed for the given user name: "+getUserCredentials.get(i).getUserName()+"  and password "+getUserCredentials.get(i).getPassword()
			//			+" expected system should navigate to reset password page for the above valid users");
				lavanteUtils.takeScreenshot(driver, methodName);
				/*Assert.assertTrue(false,"Test is failed for the given user name: "+getUserCredentials.get(i).getUserName()+"  and password "+getUserCredentials.get(i).getPassword()
						+" expected system should navigate to reset password page for the above valid users");*/
			}

			break;

		default:
			break;
		}
	}

	/**
	 * Method Name : validate_resetPassword
	 * Purpose: Method to reset new password
	 * @param: None
	 * @return: None
	 */
	public void validateResetPassword(List<setTestData> getUserCredentials, int i){
		String getErrorMsg="";
		try {
			lavanteUtils.waitForTime(1500);
			if(lavanteUtils.verifyElementDisplayed("IDcurrentPassword",IDcurrentPassword))
			{
				lavanteUtils.enterText("IDcpassword",IDcpassword,getUserCredentials.get(i).getCurrentPassword().toString());
				lavanteUtils.enterText("IDnewPassword",IDnewPassword,getUserCredentials.get(i).getNewPassword().toString());
				lavanteUtils.enterText("IDconfirmPassword", IDconfirmPassword,getUserCredentials.get(i).getConfirmPassword().toString());
				Reporter.log("Data Entry to ConfirmPassword field: "+getUserCredentials.get(i).getConfirmPassword().toString());
				lavanteUtils.click(ConfigPathFile.XPATH.getConstantValue(),XpathSaveBtn);
				Reporter.log("click on Save button is successful");
				lavanteUtils.waitForTime(1500);

				if(lavanteUtils.verifyElementDisplayed("xResetFieldErrorMsg",xResetFieldErrorMsg)==true){
					getErrorMsg=lavanteUtils.getText("xResetFieldErrorMsg", xResetFieldErrorMsg);
					Reporter.log("Expected error messages for the given invalid credentials, currnet password: "+getUserCredentials.get(i).getCurrentPassword().toString()+
							" new password: "+ getUserCredentials.get(i).getNewPassword().toString()+" confirm password: "+getUserCredentials.get(i).getConfirmPassword().toString()+" due to "+getErrorMsg);
				}
				lavanteUtils.waitForTime(1500);
				getErrorMsg=lavanteUtils.getText("XpathResetPwdMsg",XpathResetPwdMsg);
				Reporter.log("Reset Password Status: "+getErrorMsg);
				if(!getErrorMsg.equalsIgnoreCase(ExpectedMsg)){
				//	log.severe(" Test Failed Due To: "+getErrorMsg);
					/*Assert.assertTrue(false,"Test is Failed Due To: "+getErrorMsg+" for a given credentials, CurrentPassword: "+ getUserCredentials.get(i).getCurrentPassword().toString()+
							" NewPassword: "+getUserCredentials.get(i).getNewPassword().toString()+" ConfirmPassword: "+getUserCredentials.get(i).getConfirmPassword().toString());*/
				}


				lavanteUtils.click( ConfigPathFile.LINKTEXT.getConstantValue(),LinkClickHere);

				lavanteUtils.enterText("IDuserName",IDuserName,getUserCredentials.get(i).getUserName().toString());
				Reporter.log("User Name: "+getUserCredentials.get(i).getUserName().toString());
				lavanteUtils.enterText("IDpassword", IDpassword,getUserCredentials.get(i).getConfirmPassword().toString());
				Reporter.log("ConfirmPassword: "+getUserCredentials.get(i).getConfirmPassword().toString());
				lavanteUtils.click(ConfigPathFile.XPATH.getConstantValue(),XloginBtn);


				if(lavanteUtils.verifyElementDisplayed("IDstatus",IDstatus)==true){
					getErrorMsg=lavanteUtils.getText("IDstatus",IDstatus);
				//	log.severe("Test is Failed Due To: "+getErrorMsg+" for a new updated users credentials , user Name: "+getUserCredentials.get(i).getUserName().toString()+" new password: "+getUserCredentials.get(i).getConfirmPassword().toString());
					lavanteUtils.takeScreenshot(driver, methodName);
					//Assert.assertTrue(false,"Test is Failed Due To: "+getErrorMsg+" for a new updated credentials, user Name: "+getUserCredentials.get(i).getUserName().toString()+" new password: "+getUserCredentials.get(i).getConfirmPassword().toString());
				}else if (lavanteUtils.verifyElementDisplayed("IDcurrentPassword",IDcurrentPassword)==true){
					lavanteUtils.navigateTo_Back_Frwrd_Page(driver,ConfigPathFile.BACKPAGE.getConstantValue());
					lavanteUtils.navigateTo_Back_Frwrd_Page(driver,ConfigPathFile.BACKPAGE.getConstantValue());
				}else if(lavanteUtils.verifyElementDisplayed("IDlogOut",IDlogOut)==true){
					Reporter.log("User Successfully login to home page ");
					logout();

				}

			}

		} catch (Exception e) {
		//	log.severe("Exception in the method validateResetPassword "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateResetPassword "+e.getMessage());
		}		

	}

	public boolean  userLogin(setTestData getUserCredentials){
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		String getErrorMsg="";
		boolean rtnStatus=false;
		try {
			
			
			//gp.waitForTime(2000);
			if(!getUserCredentials.getUserName().equals("")){
				//gp.waitForTime(2000);
				System.out.println(getUserCredentials.getUserName().toString());
				lavanteUtils.enterText("IDuserName",IDuserName,getUserCredentials.getUserName().toString());
				lavanteUtils.enterText("IDpassword", IDpassword,getUserCredentials.getPassword().toString());
				
				System.out.println(getUserCredentials.getUserName().toString()+getUserCredentials.getPassword().toString());
				
				Reporter.log("Entered User Name: " + getUserCredentials.getUserName().toString() + " And Password: "+ getUserCredentials.getPassword().toString());				
				lavanteUtils.click("XloginBtn",XloginBtn);
				lavanteUtils.waitForTime(2000);
				//objHomePage.handle_BroswerCheckPopUp();
				//gp.waitForTime(2000);
				//gp.explicitWaitForWebElementToLoad(driver, ConfigPathFile.ID.getConstantValue(), IDlogOut);
				
				/*if(gp.isElementDisplayed(driver, By.id(IDstatus))==true){
					getErrorMsg=gp.getText(driver, ConfigPathFile.ID.getConstantValue(),IDstatus);
				//	log.severe("Test is Failed Due To: "+getErrorMsg+" for a given users credentials , user Name: "+getUserCredentials.getUserName().toString()+" password: "+getUserCredentials.getPassword().toString());
					//gp.takeScreenshot(driver, methodName);
					Assert.assertTrue(false,"Test is Failed Due To: "+getErrorMsg+" for a given user credentials, user Name: "+getUserCredentials.getUserName().toString()+" password: "+getUserCredentials.getPassword().toString());
				}else if (gp.isElementDisplayed(driver, By.id(IDcurrentPassword))==true){
					Reporter.log("Login Method Navigated to Reset Password Page ");
					gp.navigateTo_Back_Frwrd_Page(driver,ConfigPathFile.BACKPAGE.getConstantValue());
					gp.navigateTo_Back_Frwrd_Page(driver,ConfigPathFile.BACKPAGE.getConstantValue());
				}else*/ 
					
				if(lavanteUtils.verifyElementDisplayed("IDlogOut",UserName)==true){					
					Reporter.log("User Login Successful");
					rtnStatus=true;
				}else if(lavanteUtils.isElementDisplayed(driver.findElement( By.id("supplier_logout")))==true){					
					Reporter.log("User Login Successful");
					rtnStatus=true;
				}
				else{
				//	log.severe("Test is Failed due to user is not able to login to Sim Application, for a given users credentials , user Name: "+getUserCredentials.getUserName().toString()+" password: "+getUserCredentials.getPassword().toString());
					//gp.takeScreenshot(driver, methodName);
					//Assert.assertTrue(false,"Test is Failed due to user is not able to login to Sim Application, for a given users credentials , user Name: "+getUserCredentials.getUserName().toString()+" password: "+getUserCredentials.getPassword().toString());
				}
			}
		} catch (Exception e) {
		//	log.severe("Exception in the method validateUserLogin "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateUserLogin "+e.getMessage());
		}
		return rtnStatus;
	}

	public void logout(){ 
		lavanteUtils.scrollup();
		lavanteUtils.fluentwait(UserName);
		lavanteUtils.click(UserName);
		if(lavanteUtils.verifyElementDisplayed("IDlogOut",IDlogOut)==true){
			lavanteUtils.fluentwait(IDlogOut);
			lavanteUtils.click("IDlogOut",IDlogOut);
		}else {
			Reporter.log("In Logout method web Element Logout is not present ");
		}
	}

	/**
	 * Method Name : verifyUIControl
	 * Purpose: Public method which includes logic related to verify the controls on Login page
	 * @param: None
	 * @return: None
	 */
	public void verifyUIControlsOnLoginPage(){
		//declare the Instance variable
		String strTextValue="";
		try {	
			lavanteUtils.waitForTime(7000);
			//Verify the UI control for Not Registered Link
			lavanteUtils.verifyElementDisplayed("NotRegisteredLink",NotRegisteredLink);
			Reporter.log("	Verified 'Not Registered' link on Login page ",true);
			lavanteUtils.waitForTime(1000);
			//Verify the UI control for Forgot Password Link
			lavanteUtils.verifyElementDisplayed("ForgotPasswordLink",ForgotPasswordLink);
			Reporter.log("	Verified 'Forgot Password' link on Login page ",true);
			lavanteUtils.waitForTime(1000);
			//Verify the UI control for Recovery Link
			lavanteUtils.verifyElementDisplayed("RecoveryLink",RecoveryLink);
			Reporter.log("	Verified 'Looking for Lavante Recovery?' link on Login page ",true);
			strTextValue=lavanteUtils.getText("CopyRights", CopyRights);
			Reporter.log("	Verified Copyrights text link on Login page as '"+ strTextValue + "'",true);
		//	log.info("Copyright information: " + strTextValue);
			lavanteUtils.waitForTime(2000);
			//Verify the UI control for Mcafee Link
			lavanteUtils.verifyElementDisplayed("McAfeeLink",McAfeeLink);
			Reporter.log("	Verified 'McAfee' link on Login page",true);
			lavanteUtils.waitForTime(1000);
			//Verify the UI control for DigiCert Link
			lavanteUtils.verifyElementDisplayed("DigiCertLink",DigiCertLink);
			Reporter.log("	Verified 'DigiCert trusted' link on Login page",true);
			Reporter.log("Verification of the UI controls on Login page is Successful: ",true);
		} catch (Exception e) {
		//	log.severe("Exception in the method verifyUIControlsOnLoginPage: " +e.getMessage());
			lavanteUtils.takeScreenshot(driver,"verifyUIControlsOnLoginPage");
			//Assert.assertTrue(false,"Exception in the method verifyUIControlsOnLoginPage due to "+e.getMessage());
		}
	}
	
	public void LoginValidation(List<setTestData> objUserCredentials) {
	System.out.println(objUserCredentials.size());
		for(int i=0;i<objUserCredentials.size();i++){
			
			lavanteUtils.typeinEdit(objUserCredentials.get(i).getUserName().toString(),driver.findElement(By.xpath("//*[@id='username']")) );
			lavanteUtils.typeinEdit(objUserCredentials.get(i).getPassword().toString(),driver.findElement(By.xpath("//*[@id='password']")) );
			lavanteUtils.click(driver.findElement(By.xpath("//*[@name='submit']")));
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				
			}
			verifyMultipleLogins(objUserCredentials.get(i).getUserDetails().toString(),objUserCredentials,i);
		//	objLoginPage.validateUserLogin(objUserCredentials);
		}
	}
	
	public void verifyLoginPageDisplayed()
	{
		lavanteUtils.verifyElementDisplayed("XloginBtn", XloginBtn);
	}

}
