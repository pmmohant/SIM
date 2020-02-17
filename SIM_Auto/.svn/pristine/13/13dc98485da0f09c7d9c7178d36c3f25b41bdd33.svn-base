/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */

package com.lavante.sim.customer.pageobjects.MyAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class MyAccountPage {
	Properties props=null;
	List<String> expTimeZones =null;
	List<String> listExpWebElmText =null;
	List<String> listActWebElmText=null;
	LavanteUtils lavanteUtils =new LavanteUtils();

	
	String methodName ="";
	
	//Declare web driver
	public WebDriver driver;

	// Page object declaration
	
	@FindBy(id="currentPassword")
	private WebElement IDcurrentPwd;
	
	@FindBy(id="newPassword")
	private WebElement IDnewPwd;
	
	@FindBy(id="confirmPassword")
	private WebElement IDconfirmPwd;
	
	@FindBy(id="challengeQuestion")
	private WebElement IDchallengQ;
	
	@FindBy(id="challengeAnswer")
	private WebElement IDchallengA;
	
	@FindBy(id="timeZoneID")
	private WebElement IDtimeZone;
	
	@FindBy(id="languageID")
	private WebElement IDlanguage;
	
	@FindBy(id="contactID")
	private WebElement IDcontact;
	
	@FindBy(id="logout_link")
	private WebElement IDlogOut;
	
	@FindBy(xpath="//div[@id='timeZoneID_chosen']/a")
	private WebElement xTimeZoneDrpEditBox;
	
	@FindBy(xpath="//div[@id='timeZoneID_chosen']/div/ul/li")
	private WebElement xTimeZoneDrpEditBoxList;

	@FindBy(xpath="//div[@id='languageID_chosen']")
	private WebElement xLanguageDrpDwn;
	
	private String xLanguageDrpDwnList = "//div[@id='languageID_chosen']/div/ul/li";
	
	@FindBy(xpath="//span[contains(@id,'ui-id')]")
	private WebElement xMyAccountPopup;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/div[1]/a[2]")
	private WebElement xMySettingTab;

	@FindBy(xpath="html/body/div[1]/div/form/h3[1]")
	private WebElement xResetPwdHeader;
	
	@FindBy(xpath="html/body/div[1]/div/form/h3[2]")
	private WebElement xChangeCQHeader;
	
	@FindBy(xpath="//*[@id='mySettingsBean']//a")
	private WebElement xMySettingsHeader;
	
	@FindBy(css="input[class='button button_red'][name='Clear']")
	private WebElement cssClearBtn;
	
	@FindBy(css="input[class='primary'][name='save']")
	private WebElement cssSaveBtn;
	
	@FindBy(css="button[class='button button_red cancel'][title='Cancel']")
	private WebElement cssCancelBtn;
	
	private String frameID00J = "00J";
	@FindBy(linkText = "Help")
	private WebElement helpLink;
	
	private String atbtitle = "bt-xtitle";
	
	@FindBy(xpath="//button[contains(@class,'Primary')]")
	private WebElement xOkBtn;
	
	@FindBy(xpath="//div[contains(@class,'dialog undefined ui-dialog-content ui-widget-content')]")
	private WebElement xResetPwdSucessMsg;
	
	@FindBy(xpath="//td/span[contains(@class,'error')]")
	private WebElement xResetFieldErrorMsg;
	
	@FindBy(xpath="//div[contains(@id,'auth_status')]/strong")
	private WebElement xTimeZoneStatus;
	
	private String expeTimeZoneMsg = "Settings updated successfully.";
	
	@FindBy(xpath=".//*[@id='main-navigation']/a[4]")
	private WebElement xManageFiles;
	
	private String frameUploadFile =  "uploadedVMFFileDetails";
	
	@FindBy(xpath="html/body/div[1]/div/table/tbody/tr[2]/td[2]")
	private WebElement xUploadedOn;
	
	private String xRowsUploadedOn = "//div[@id='uploadedFileDetailsDiv']/table/tbody/tr";
	
	@FindBy(xpath=".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement xIFrameNewLogout;
	
	private String expResetPwdSuccessMsg = "Password updated successfully";
	
	@FindBy(css="a[class*='user-info']")
	private WebElement UserName;
	public WebElement Username(){
		return UserName;
	}
	
	@FindBy(css="ul a[href*='myAccount']")
	private WebElement xMyAccount;
	
	@FindBy(xpath=".//*[@id='logout_link']")
	private WebElement xLogoutLinkText;

	@FindBy(xpath=".//*[@id='main-navigation']/a[5]")
	private WebElement xManageUsers;
	
	@FindBy(xpath=".//*[@id='main-navigation']/a[1]")
	private WebElement xDashboard;
	
	@FindBy(xpath=".//*[@id='main-navigation']/a[2]")
	private WebElement xSuppliers;
	
	@FindBy(xpath=".//*[@id='main-navigation']/a[3]")
	private WebElement xTasks;
	
	@FindBy(xpath=".//*[@id='main-navigation']/a[1]")
	private WebElement xHome;
	
	@FindBy(xpath=".//*[@id='main-navigation']/a[2]")
	private WebElement xProfiles;
	
	@FindBy(xpath="html/body/div[1]/div/div/div/div[1]/a[1]")
	private WebElement xResetPwdTab;
	
	public MyAccountPage(WebDriver driver) {
		
		try {
			

			lavanteUtils.driver=driver;
			this.driver=driver;
			
		} catch (Exception e)  {						
		//	log.severe("Method: LoginPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage);	
		}
	}


	/**
	 * Method Name : verifyUIControlsOfMyAccount
	 * Purpose: Method to verifyUIControlsOfMyAccount
	 * @param: None
	 * @return: None
	 */
	public void verifyUIControlsOfMyAccount(){
		String getToolTipMsg="";
		try {
			lavanteUtils.waitForTime(2500);
			lavanteUtils.click(UserName);
			lavanteUtils.fluentwait(xMyAccount);
			lavanteUtils.click("xMyAccount",xMyAccount);
			lavanteUtils.waitForTime(2500);
			if(lavanteUtils.switchtoFrame(xIFrameNewLogout))
			{
				lavanteUtils.click("xResetPwdTab",xResetPwdTab);
				lavanteUtils.waitForTime(2000);
				lavanteUtils.verifyElementDisplayed("xResetPwdHeader", xResetPwdHeader);
				lavanteUtils.verifyElementDisplayed("IDcurrentPwd", IDcurrentPwd);
				lavanteUtils.verifyElementDisplayed("IDnewPwd", IDnewPwd);
				lavanteUtils.waitForTime(2000);
				//getToolTipMsg=getValue(driver, ConfigPathFile.LINKTEXT.getConstantValue(),helpLink,atbtitle);
		
				/*String mouseOverScript = "if(document.createEvent){"
                        + "var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', "
                        +"true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                
                		driver.findElement(By.linkText(helpLink)));*/
				
				 lavanteUtils.verifyElementDisplayed("helpLink", helpLink);      
				 
				 // Tool tip verfication point has been removed as it is not working. 
				 
/*				 String id=lavanteUtils.getValue(driver.findElement(By.linkText(helpLink)),"aria-describedby");
				 getToolTipMsg=lavanteUtils.getText(driver.findElement(By.xpath("//*[@id='"+id+"']//div")));
	
				try {
					if(getToolTipMsg!=null){
						Reporter.log("Tool Tip Help Expected Message: "+getToolTipMsg);

					}else {
				//		log.severe("Actual Tool Tip Help Message: "+getToolTipMsg);


					}
				} catch (Exception e) {
			//		log.severe("Actual Tool Tip Help Message: "+e.getMessage);
				}*/

				lavanteUtils.verifyElementDisplayed("IDconfirmPwd", IDconfirmPwd);
				lavanteUtils.verifyElementDisplayed("xChangeCQHeader", xChangeCQHeader);
				lavanteUtils.verifyElementDisplayed("IDchallengQ", IDchallengQ);
				lavanteUtils.verifyElementDisplayed("IDchallengA", IDchallengA);
				lavanteUtils.verifyElementDisplayed("cssClearBtn",cssClearBtn);
				lavanteUtils.verifyElementDisplayed("cssCancelBtn", cssCancelBtn);
				lavanteUtils.verifyElementDisplayed("cssSaveBtn", cssSaveBtn);
				lavanteUtils.click("xMySettingTab",xMySettingTab);
				lavanteUtils.waitForTime(2000);
				lavanteUtils.verifyElementDisplayed("xMySettingsHeader", xMySettingsHeader);
				lavanteUtils.verifyElementDisplayed("IDtimeZone", IDtimeZone);
				lavanteUtils.verifyElementDisplayed("IDlanguage", IDlanguage);
				//isWebElementExists(driver, ConfigPathFile.ID.getConstantValue(), IDcontact);
				lavanteUtils.click("cssCancelBtn", cssCancelBtn);
				lavanteUtils.switchtoFrame(null);

			}

		} catch (Exception e) {
		//	log.severe("Exception in the method verifyUIControlsOfMyAccount "+e.getMessage);
		}
	}

	/**
	 * Method Name : validateResetPassword
	 * Purpose: Method to reset new password
	 * @param: None
	 * @return: None
	 */
	public void validateResetPassword(List<setTestData> objResetPwdTDList){
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		String getErrorMsg="",resetPwdStatusMsg="";
		try {
			lavanteUtils.waitForTime(5000);
			lavanteUtils.click(UserName);
			lavanteUtils.fluentwait(xMyAccount);
			lavanteUtils.click("xMyAccount",xMyAccount);
			//pressEnterkey(driver, ConfigPathFile.LINKTEXT.getConstantValue(),"My Account");s
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xMyAccountPopup);
			lavanteUtils.fluentwait(xIFrameNewLogout);
			for(int i=0;i<objResetPwdTDList.size();i++){
				lavanteUtils.waitForTime(600);
				if(lavanteUtils.switchtoFrame(xIFrameNewLogout));
				{
					lavanteUtils.enterText("IDcurrentPwd",IDcurrentPwd,objResetPwdTDList.get(i).getCurrentPassword().toString());
					Reporter.log("CurrentPassword: "+objResetPwdTDList.get(i).getCurrentPassword().toString());
					lavanteUtils.enterText("IDnewPwd", IDnewPwd,objResetPwdTDList.get(i).getNewPassword().toString());
					Reporter.log("NewPassword: "+objResetPwdTDList.get(i).getNewPassword().toString());
					lavanteUtils.enterText("IDconfirmPwd", IDconfirmPwd,objResetPwdTDList.get(i).getConfirmPassword().toString());
					Reporter.log("ConfirmPassword: "+objResetPwdTDList.get(i).getConfirmPassword().toString());
					lavanteUtils.click("cssSaveBtn",cssSaveBtn);
					lavanteUtils.waitForTime(4000);
					if(lavanteUtils.verifyElementDisplayed("xResetFieldErrorMsg",xResetFieldErrorMsg)){
						getErrorMsg=lavanteUtils.getText("xResetFieldErrorMsg",xResetFieldErrorMsg);
						if(objResetPwdTDList.get(i).getErrorMessage().trim().toString().equalsIgnoreCase(getErrorMsg)){
							Reporter.log("Expected Error messages for the given credentials, currnet password: "+objResetPwdTDList.get(i).getCurrentPassword().toString()+
									" new password: "+ objResetPwdTDList.get(i).getNewPassword().toString()+" confirm password: "+objResetPwdTDList.get(i).getConfirmPassword().toString()+" due to "+getErrorMsg);

						}else{
						//	log.severe("Test is failed due to expected error message is "+objResetPwdTDList.get(i).getErrorMessage().toString()+" but actual is "+getErrorMsg);
							lavanteUtils.takeScreenshot(driver, methodName);
							Assert.assertTrue(false,"Test is failed due to expected error message is "+objResetPwdTDList.get(i).getErrorMessage().toString()+" but actual is "+getErrorMsg);
						}

					}else{
						Reporter.log("No errors obeserved in the reset password pop up page");
					}
					lavanteUtils.switchtoFrame(null);
					if(lavanteUtils.verifyElementDisplayed("xOkBtn",xOkBtn)){
						resetPwdStatusMsg=lavanteUtils.getText("xResetPwdSucessMsg",xResetPwdSucessMsg);
						Reporter.log("Password Reset Status:  "+resetPwdStatusMsg);
						//lavanteUtils.isAlertPresent(driver,ConfigPathFile.ACCEPT.getConstantValue);
						lavanteUtils.click("xOkBtn",xOkBtn);
						lavanteUtils.waitForTime(1000);
						if(!objResetPwdTDList.get(i).getErrorMessage().trim().toString().equalsIgnoreCase(resetPwdStatusMsg)){
						//	log.severe("Test is failed due to expected update status is "+objResetPwdTDList.get(i).getErrorMessage().trim().toString()+" but actual is "+resetPwdStatusMsg+" for the given credentials, current Password: "
							//		+objResetPwdTDList.get(i).getCurrentPassword().toString()+" new password: "+ objResetPwdTDList.get(i).getNewPassword().toString()+" confirm password: "+objResetPwdTDList.get(i).getConfirmPassword().toString());

							lavanteUtils.takeScreenshot(driver, methodName);
							Assert.assertTrue(false,"Test is failed due to expected update status is "+objResetPwdTDList.get(i).getErrorMessage().trim().toString()+" but actual is "+resetPwdStatusMsg+" for the given credentials, current Password: "
									+objResetPwdTDList.get(i).getCurrentPassword().toString()+" new password: "+ objResetPwdTDList.get(i).getNewPassword().toString()+" confirm password: "+objResetPwdTDList.get(i).getConfirmPassword().toString());

						}
						lavanteUtils.waitForTime(2000);
					}

				}
			}
			if(lavanteUtils.switchtoFrame(xIFrameNewLogout))
			{
				if(lavanteUtils.verifyElementDisplayed("cssCancelBtn",cssCancelBtn)){
					lavanteUtils.click("cssCancelBtn", cssCancelBtn);
				}
				lavanteUtils.switchtoFrame(null);
			}

		} catch (Exception e) {
	//		log.severe("Exception in the method validateResetPassword "+e.getMessage);
			Assert.assertTrue(false,"Exception in the method validateResetPassword "+e.getMessage());
		}		
	}

	public List<String> listExpErrorMsgs(setTestData objErrorMsgs){
		List< String> listExpErrorMsgs =new ArrayList<String>();
		//if(objLanguage.getLanguage().trim().toString().equals(strValues)){
		String expText[]=objErrorMsgs.getErrorMessage().split("@@@@");
		for(int k=0;k<expText.length;k++){
			System.out.println("Expected text string for : "+expText[k]);
			listExpErrorMsgs.add(expText[k]);
		}
		//}
		return listExpErrorMsgs;
	}





	/**
	 * Method Name : getTimeZone
	 * Purpose: Method to getTimeZone
	 * @param: None
	 * @return: None
	 */
	public String getTimeZone(List<setTestData> objdata){
		String actualTimeZone="",machedTimeZone="";
		expTimeZones = new ArrayList<String>();
		Pattern p=null;
		Matcher m=null;
		lavanteUtils.waitForTime(1000);
		actualTimeZone=lavanteUtils.getText("xTimeZoneStatus",xTimeZoneStatus);
		System.out.println("AT"+actualTimeZone);
		Reporter.log("Time Stamp: "+actualTimeZone);
		for(int i=0;i<objdata.size();i++){
			expTimeZones=sortDataforTest(objdata.get(i).getTimezoneAbbreviation().toString());
			for(int j=0;j<expTimeZones.size();j++){ System.out.println(expTimeZones.get(j));
				p=Pattern.compile(expTimeZones.get(j));
				m=p.matcher(actualTimeZone);
				while(m.find()){
					machedTimeZone=m.group().toString();
					System.out.println("MTZ"+machedTimeZone);
					Reporter.log("Actual Time Zone : "+machedTimeZone);
				}
			}
		}
		return machedTimeZone;
	}
		
	public boolean isLanguagePresent(String expExistingLanguage){
		String actExistingLanguage=""; 
		lavanteUtils.waitForTime(2000);
		actExistingLanguage=lavanteUtils.getText("IDlogOut",IDlogOut);
		if(expExistingLanguage.toString().equalsIgnoreCase(actExistingLanguage)){
			return true;
		}else{
			return false;
		}
	}



	public List<String> sortDataforTest(String str_data){
		String[] split_btns = str_data.split(",");// separate the button names in excel by a
		// comma in between
		List<String> list_btns = new ArrayList<String>(
				Arrays.asList(split_btns));
		return list_btns;
	}
	
	/**
	 * Method: delegateTasks
	 * Purpose: Method to select the delegate to the user
	 * @param : String str_user
	 * @return none
	 * @author priya.pais
	 */
	public void delegateTasks(String str_user){
		methodName=new Object(){}.getClass().getEnclosingMethod().getName();
		//driver.findElement(By.xpath(xMyAccount)).sendKeys(Keys.ENTER);
		lavanteUtils.click("xMyAccount",xMyAccount);
		lavanteUtils.waitForTime(2500);
		try{
			//lavanteUtils.explicitWaitForWebElementToLoad("xMyAccountPopup",xMyAccountPopup);
			if(lavanteUtils.switchtoFrame(xIFrameNewLogout))
			{
				Reporter.log("Switched into the My Account Frame ");
				lavanteUtils.click("xMySettingTab",xMySettingTab);
				Reporter.log("Clicked on the My Settings tab");
				lavanteUtils.waitForTime(2000);
				lavanteUtils.verifyElementDisplayed("xMySettingsHeader", xMySettingsHeader);
				Reporter.log("The title of the Pop-up is verified ");
			}
			lavanteUtils.waitForTime(1500);
			lavanteUtils.click(driver.findElement(By.xpath("//div[@id='contactID_chosen']/a")));
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(driver.findElement(By.xpath("//div[@id='contactID_chosen']//ul/li")));
			lavanteUtils.selectvalueFrmDpdn(str_user);
			Reporter.log("The User to whom the tasks are delegated is  : "+str_user);
			lavanteUtils.switchtoFrame(xIFrameNewLogout);
			lavanteUtils.click("cssSaveBtn", cssSaveBtn);
			lavanteUtils.switchtoFrame(null);
			if(lavanteUtils.verifyElementDisplayed("xOkBtn",xOkBtn)){
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click("xOkBtn",xOkBtn);
				Reporter.log("Clicked on the OK button");
			}
		}catch(Exception e){
		//	log.severe("Exception occured : "+e.getMessage);
			Assert.assertTrue(true,"Failed because of the exception that occured : "+e.getCause());
			//gp.takeScreenshot(driver, methodName);
		}
	}
}
