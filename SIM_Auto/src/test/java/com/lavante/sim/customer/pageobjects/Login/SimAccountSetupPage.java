/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */

package com.lavante.sim.customer.pageobjects.Login;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class SimAccountSetupPage {
	String testCaseName = this.getClass().getSimpleName();
	String methodName = "";

	LavanteUtils lavanteUtils = new LavanteUtils();

	@SuppressWarnings("unused")
	private String[] parentWindow = { "", "" };
	// Declare web driver

	@FindBy(xpath = "username")
	private WebElement IDUserName;
	/*
	 * @FindBy(xpath="language") private WebElement IDPreferredLanguage;
	 */
	@FindBy(id = "password")
	private WebElement IDPassword;
	@FindBy(id = "confirmPassword")
	private WebElement IDConfirmPassword;
	@FindBy(id = "question")
	private WebElement IDChallengeQ;
	@FindBy(id = "answer")
	private WebElement IDChallengeAnswer;
	@FindBy(id = "tc")
	private WebElement IDCheckBox;
	@FindBy(id = "tin")
	private WebElement IDTinEField;
	@FindBy(xpath = "//form[contains(@id,'command')]/table/tbody/tr/td/label[contains(@for,'language')]")
	private WebElement xPreferredLanguage;
	@FindBy(xpath = "//form[contains(@id,'command')]/table/tbody/tr/td/label[contains(@for,'username')]")
	private WebElement xUserNameField;
	@FindBy(xpath = "//form[contains(@id,'command')]/table/tbody/tr/td/label[contains(@for,'password')]")
	private WebElement xSetPwdField;
	@FindBy(xpath = "//form[contains(@id,'command')]/table/tbody/tr/td/label[contains(@for,'confirmPassword')]")
	private WebElement xConfermPwdField;
	@FindBy(xpath = "//form[contains(@id,'command')]/table/tbody/tr/td/label[contains(@for,'question')]")
	private WebElement xQuestionField;
	@FindBy(xpath = "//form[contains(@id,'command')]/table/tbody/tr/td/label[contains(@for,'answer')]")
	private WebElement xAnswerField;
	@FindBy(xpath = "//div/label[contains(@for,'tc')]")
	private WebElement xTermConditionsField;
	@FindBy(xpath = "//h2[contains(@class,'sim_title')]")
	private WebElement xAccountSetupHeader;
	@FindBy(xpath = "//span[contains(@class,'error')]")
	private WebElement xFieldErrorMsg;
	@FindBy(xpath = "//span[contains(@class,'ui-dialog-title')]")
	private WebElement xHeaderNotYourEmail;
	@FindBy(xpath = ".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement xIframeEmailPopup;
	@FindBy(xpath = "//span/a[contains(@title,'Email Terms And Condition Document')]")
	private WebElement xEmailTerms;
	@FindBy(xpath = "//span/a[contains(@title,'Print Terms And Condition Document')]")
	private WebElement xPrintTerms;
	@FindBy(xpath = "//div[contains(@class,'align_left')]/h2")
	private WebElement xAcceptDeclineHeader;
	@FindBy(xpath = "//div/span[contains(@class,'radio')]")
	private WebElement xAcceptDeclineRadio;
	@FindBy(xpath = ".//*[@id='invite_supplier_accept']/div[2]/span[1]")
	private WebElement xAcceptRadioBtnText;
	@FindBy(xpath = ".//*[@id='invite_supplier_accept']/div[2]/span[2]")
	private WebElement xDeclineRadioBtnText;
	@FindBy(xpath = ".//*[@id='invite_supplier_accept']/div[2]/input[1]")
	private WebElement xAcceptRadioBtn;
	@FindBy(xpath = ".//*[@id='invite_supplier_accept']/div[2]/input[2]")
	private WebElement xDeclineRadioBtn;
	@FindBy(xpath = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front dialog ui-dialog-buttons']/div[1]/span")
	private WebElement xGratitude;
	@FindBy(xpath = ".//*[@class='dialog undefined ui-dialog-content ui-widget-content']")
	private WebElement xOkBtn;

	private String expAccountsetupPageTitle = "Lavante SIM";
	private String expRegPageHeader = "Registration";
	private String expPageHeader = "Account Setup:";
	private String expTextNotYourMail = "Not your e-mail ID?";

	private String classNameMandateField = "required_field";

	@FindBy(linkText = "( Not your e-mail ID? )")
	private WebElement linkTextNotYourEmail;
	@FindBy(xpath = ".//*[@id='command']/table/tbody/tr[5]/td[2]/a")
	private WebElement linkTextHelpSetPwd;
	@FindBy(xpath = ".//*[@id='command']/table/tbody/tr[3]/td[2]/a")
	private WebElement linkTextHelpChangeQ;
	@FindBy(linkText = "Terms And Conditions.")
	private WebElement linkTextTermsCondition;
	@FindBy(css = "input[class='button button_blue'][type='submit']")
	private WebElement CssBtnNext;
	@FindBy(css = "[class='button_green'][type='button']")
	private WebElement CssBtnOkEmailPopup;
	@FindBy(css = "input[class='button_red'][type='reset']")
	private WebElement CssBtnAcceptReset;
	@FindBy(css = "input[class='button_green'][type='submit']")
	private WebElement CssBtnAcceptSubmit;
	public WebDriver driver;

	// Account set up page

	@FindBy(css = "[id*='language'] a")
	private WebElement preflanguage;

	@FindBy(css = "input[id*='password']")
	private WebElement setpass;

	@FindBy(css = "input[id*='confirmPassword']")
	private WebElement confirmpass;

	@FindBy(css = "[id*='question'] a")
	private WebElement chquestion;

	@FindBy(css = "[id*='answer']")
	private WebElement chanswer;

	@FindBy(css = "[id*='tc']")
	private WebElement checkconfirm;

	@FindBy(css = "input[type='reset']")
	private WebElement clearbttn;

	@FindBy(css = "input[type='submit']")
	private WebElement nextbttn;

	/**
	 * Method Name : Constructor method Purpose: Constructor method where we
	 * initialize the driver
	 */
	public SimAccountSetupPage(WebDriver driver) {
		try {
			lavanteUtils.driver = driver;
		} catch (Exception e) {
			// log.severe("Method: LoginPage :: " + "Exception = " + e + " Line
			// Number = " + e.getMessage());
		}
	}
	
	
	

	// Reusable Methods
	public void accSetup(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.waitForTime(4000);
		fillRegisteration(dataMap);
		formRegisteration(dataMap);
	}

	private void fillRegisteration(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(nextbttn);
		if (dataMap.containsKey("preflanguage")) {
			lavanteUtils.click(preflanguage);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("preflanguage"));

		}
		if (dataMap.containsKey("setpass")) {
			lavanteUtils.typeinEdit(dataMap.get("setpass"), setpass);

		}
		if (dataMap.containsKey("confirmpass")) {
			lavanteUtils.typeinEdit(dataMap.get("confirmpass"), confirmpass);
		}
		if (dataMap.containsKey("chquestion")) {
			lavanteUtils.click(chquestion);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("chquestion"));
		}
		if (dataMap.containsKey("chanswer")) {
			lavanteUtils.typeinEdit(dataMap.get("chanswer"), chanswer);

		}
		if (dataMap.containsKey("checkconfirm")) {
			lavanteUtils.selectChkBox(checkconfirm, "yes");
		}
	}

	private void formRegisteration(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("nextbttn")) {
			lavanteUtils.click(nextbttn);
		}
		if (dataMap.containsKey("clearbttn")) {
			lavanteUtils.click(clearbttn);
		}
	}
	
	/**
	 * Method Name : validateMandateControls Purpose: Method to Validation on
	 * Account Setup page with multiple inputs
	 * 
	 * @param: None
	 * @return: None
	 */
	public boolean validateMandateControls(List<setTestData> objMandateFieldTDList) {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			WebElement checkBox = null;
			String getErrorMsg = "", actPageHeader = "";
			lavanteUtils.navigateTo_Back_Frwrd_Page(ConfigPathFile.REFRESH.getConstantValue());
			lavanteUtils.fluentwait(xAccountSetupHeader);
			if (IDUserName.isDisplayed() == false) {
				Reporter.log("Verification of |Username| field as Non-Editable is successful");
			} else {
				// log.severe("Test failed due to user is able to edit the non
				// editable field, expected user should not allowed to edit the
				// user name field ");
				// gp.takeScreenshot(driver, methodName);
				// Assert.assertTrue(false,"Test failed due to user is able to
				// edit the non editable field, expected user should not allowed
				// to edit the user name field ");
			}
			Reporter.log(" ");
			Reporter.log("Validation on Account Setup page for multiple inputs");
			for (int i = 0; i < objMandateFieldTDList.size(); i++) {
				// IDPreferredLanguage="language_chosen";
				lavanteUtils.switchtoFrame(null);
				// gp.SPDselectDropDownValue(driver, "",
				// IDPreferredLanguage,objMandateFieldTDList.get(i).getPreferredLanguage().toString());
				lavanteUtils.typeinEdit(objMandateFieldTDList.get(i).getSetPassword().toString(), IDPassword);
				Reporter.log("Set Password: " + objMandateFieldTDList.get(i).getSetPassword().toString());
				System.out.println("SET PASSWERD");
				lavanteUtils.typeinEdit(objMandateFieldTDList.get(i).getConfirmPassword().toString(),
						IDConfirmPassword);
				Reporter.log("Confirm Password: " + objMandateFieldTDList.get(i).getConfirmPassword().toString());

				lavanteUtils.waitForTime(2000);
				lavanteUtils.selectDropDownValue(driver.findElement(By.id("question")),
						objMandateFieldTDList.get(i).getChallengeQ().toString());
				lavanteUtils.typeinEdit(objMandateFieldTDList.get(i).getChallengeA().toString(), IDChallengeAnswer);
				Reporter.log("ChallengeAnswer: " + objMandateFieldTDList.get(i).getChallengeA().toString());

				checkBox = IDCheckBox;

				if (objMandateFieldTDList.get(i).getTermsCheckBox().toString().equals("")) {
					if (checkBox.isSelected()) {
						checkBox.click();
					}
				} else if (objMandateFieldTDList.get(i).getTermsCheckBox().toString().equals("check")) {
					if (!checkBox.isSelected()) {
						checkBox.click();
					}
				}

				lavanteUtils.click(CssBtnNext);
				Reporter.log("Clicked on |Next|");
				lavanteUtils.waitForTime(2000);
				if (!objMandateFieldTDList.get(i).getErrorMessage().toString().equals("")) {
					if (lavanteUtils.isElementDisplayed(xFieldErrorMsg) == true) {
						getErrorMsg = lavanteUtils.getText(xFieldErrorMsg);
						if (objMandateFieldTDList.get(i).getErrorMessage().trim().toString()
								.equalsIgnoreCase(getErrorMsg)) {
							Reporter.log("Verified validation message - " + getErrorMsg);

						} else {
							// log.severe("Test failed due to expected error
							// message
							// "+objMandateFieldTDList.get(i).getErrorMessage().toString()+"
							// is not same as actual message "+getErrorMsg);
							lavanteUtils.takeScreenshot(methodName);
							Assert.assertTrue(false,
									"Test failed due to expected error message "
											+ objMandateFieldTDList.get(i).getErrorMessage().toString()
											+ " is not same as actual message " + getErrorMsg);
						}

					} else {
						// log.severe("Test failed due to expected to display
						// error messages for the mandate fields ");
						lavanteUtils.takeScreenshot(methodName);
						Assert.assertTrue(false,
								"Test failed due to expected to display error messages for the mandate fields");
					}

				} else if (objMandateFieldTDList.get(i).getErrorMessage().toString().equals("")) {
					if (lavanteUtils.isElementDisplayed(IDTinEField) == true) {
						lavanteUtils.fluentwait(IDTinEField);
						actPageHeader = lavanteUtils.getText(xAccountSetupHeader);
						if (actPageHeader.contains(expRegPageHeader)) {
							Reporter.log("Account Setup done successfully");
						} else {
							// log.severe("Test failed due to expected
							// Registration page header: "+expRegPageHeader+"
							// but found: "+actPageHeader+" in supplier
							// registration window ");
							lavanteUtils.takeScreenshot(methodName);
							Assert.assertTrue(false,
									"Test failed due to expected Registration page header: " + expRegPageHeader
											+ " but found: " + actPageHeader + " in supplier registration window ");
						}
					} else {
						// log.severe("Test failed due to registration page does
						// not appears");
						// gp.takeScreenshot(driver, methodName);
						// Assert.assertTrue(false,"Test failed due to
						// registration page does not appears");

					}

				}
				Reporter.log(" ");
			}

			// closeChildWindow(driver, parentWindow);
			lavanteUtils.waitForTime(500);
			// switchToParentWindow(driver, parentWindow);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Method Name : verifyACCSetupPageUIControls Purpose: Method to verify
	 * Account Setup Page UI Controls
	 * 
	 * @param: None
	 * @return: None
	 */
	public void verifyACCSetupPageUIControls() {
		String actPageHeader = "", actNotYourEmailMsg = "", strEmailText = "", strPrintText = "";
		parentWindow = lavanteUtils.handlePopUpWindow(expAccountsetupPageTitle,
				ConfigPathFile.TITLE.getConstantValue());
		lavanteUtils.assertPageTitle(expAccountsetupPageTitle);
		lavanteUtils.fluentwait(xAccountSetupHeader);
		actPageHeader = lavanteUtils.getText(xAccountSetupHeader);
		if (expPageHeader.equalsIgnoreCase(actPageHeader)) {
			Reporter.log("Verified |Account Setup| page header");
			validateStarMarkFields();
			lavanteUtils.waitForTime(1000);
			lavanteUtils.click(linkTextNotYourEmail);
			Reporter.log("Clicked on the |Not Your Email ID?| link successfully");
			actNotYourEmailMsg = lavanteUtils.getText(xHeaderNotYourEmail);

			if (!expTextNotYourMail.equalsIgnoreCase(actNotYourEmailMsg)) {
				// log.severe("Test faile due to expected header:
				// "+expTextNotYourMail+" but found "+actNotYourEmailMsg+" in a
				// popup dialog for the link Not Your e-mail ID");
				// Assert.assertTrue(false,"Test faile due to expected header:
				// "+expTextNotYourMail+" but found "+actNotYourEmailMsg+" in a
				// popup dialog for the link Not Your e-mail ID");
			} else {
				Reporter.log("Verified |" + actNotYourEmailMsg + "| Header");
			}
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(CssBtnOkEmailPopup);
			lavanteUtils.waitForTime(2000);
			System.out.println("POP");
			/*
			 * gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),
			 * "//*[@type='password']/../..//a"); Reporter.log(
			 * "Clicked on the |Help| link for password");
			 * getToolTipMsgPwd=gp.getValue(driver,
			 * ConfigPathFile.XPATH.getConstantValue(),linkTextHelpSetPwd,
			 * "title"); try { if(getToolTipMsgPwd!=null){ Reporter.log(
			 * "Expected Tool Tip Help Message: "+getToolTipMsgPwd); }else {
			 * //log.severe("Actual Tool Tip Help Message: "+getToolTipMsgPwd);
			 * } } catch (Exception e) { //log.severe(
			 * "Actual Tool Tip Help Message: "+e.getMessage()); }
			 * gp.waitForTime(600); gp.clicks(driver,
			 * ConfigPathFile.XPATH.getConstantValue(),linkTextHelpChangeQ);
			 * Reporter.log("Clicked on the |Help| link for Change Question");
			 * getToolTipMsgChangeQ=gp.getValue(driver,
			 * ConfigPathFile.XPATH.getConstantValue(),linkTextHelpChangeQ,
			 * "title"); try { if(getToolTipMsgChangeQ!=null){ Reporter.log(
			 * "Expected Tool Tip Help Message: "+getToolTipMsgChangeQ); }else {
			 * //log.severe("Actual Tool Tip Help Message: "
			 * +getToolTipMsgChangeQ); } } catch (Exception e) { //log.severe(
			 * "Actual Tool Tip Help Message: "+e.getMessage()); }
			 */
			lavanteUtils.click(linkTextTermsCondition);
			Reporter.log("Clicked on the |Terms and Conditions| link successfully");
			lavanteUtils.waitForTime(1000);
			if (lavanteUtils.switchtoFrame(xIframeEmailPopup) == true) {
				Reporter.log("Navigation to |Terms and Conditions| page successfully");
				strEmailText = lavanteUtils.getText(xEmailTerms);
				Reporter.log(strEmailText + " option on Terms and Condition page verified successfully ");
				strPrintText = lavanteUtils.getText(xPrintTerms);
				Reporter.log(strPrintText + " option on Terms and Condition page verified successfully ");
				lavanteUtils.navigateTo_Back_Frwrd_Page(ConfigPathFile.REFRESH.getConstantValue());
				lavanteUtils.switchtoFrame(null);
			}

		} else {
			// log.severe("Test failed due to expected Account Setup page
			// header: "+expPageHeader+" but found: "+actPageHeader+" in an
			// account setup window ");
			// Assert.assertTrue(false,"Test failed due to expected header:
			// "+expPageHeader+" but found: "+actPageHeader+" in an account
			// setup window ");

		}

	}

	public void validateStarMarkFields() {
		String expClassName = classNameMandateField, actPreferedLanguage = "", actUserName = "", actSetPwd = "",
				actConfirmPwd = "", actChangeQuestion = "", actChangeAnswer = "", actTermsConditions = "";

		actPreferedLanguage = lavanteUtils.getValue(xPreferredLanguage, "class");
		if (expClassName.equalsIgnoreCase(actPreferedLanguage)) {
			Reporter.log("Verification is successful for |Prefered Language| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |Prefered Language| mandatory
			// field ");
		}
		actUserName = lavanteUtils.getValue(xUserNameField, "class");
		if (expClassName.equalsIgnoreCase(actUserName)) {
			Reporter.log("Verification is successful for |User Name| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |User Name| mandatory field
			// ");
		}
		actSetPwd = lavanteUtils.getValue(xSetPwdField, "class");
		if (expClassName.equalsIgnoreCase(actSetPwd)) {
			Reporter.log("Verification is successful for |Set Password| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |Set Password| mandatory
			// field ");
		}
		actConfirmPwd = lavanteUtils.getValue(xConfermPwdField, "class");
		if (expClassName.equalsIgnoreCase(actConfirmPwd)) {
			Reporter.log("Verification is successful for |Confirm Password| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |Confirm Password| mandatory
			// field ");
		}
		actChangeQuestion = lavanteUtils.getValue(xQuestionField, "class");
		if (expClassName.equalsIgnoreCase(actChangeQuestion)) {
			Reporter.log("Verification is successful for |Change Question| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |Change Question| mandatory
			// field ");
		}
		actChangeAnswer = lavanteUtils.getValue(xAnswerField, "class");
		if (expClassName.equalsIgnoreCase(actChangeAnswer)) {
			Reporter.log("Verification is successful for |Change Answer| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |Change Answer| mandatory
			// field ");
		}
		actTermsConditions = lavanteUtils.getValue(xTermConditionsField, "class");
		if (expClassName.equalsIgnoreCase(actTermsConditions)) {
			Reporter.log("Verification is successful for |Terms and Conditions| mandatory field with |*| mark ");

		} else {
			// log.severe("Verification failed for |Terms and Conditions|
			// mandatory field ");
		}

	}

	/**
	 * Method Name : verifyAcceptDeclinePageUIControls Purpose: Method to verify
	 * Accept and Decline Page UI Controls
	 * 
	 * @param: None
	 * @return: None
	 */
	public void verifyAcceptDeclinePageUIControls() {
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String actPageHeader = "", strExpAcceptText = "Accept", strActAcceptText = "", strActDeclineText = "",
				strExpDeclineText = "Decline";
		String expPage = "Lavante Connect Account";
		parentWindow = lavanteUtils.handlePopUpWindow(expAccountsetupPageTitle,
				ConfigPathFile.TITLE.getConstantValue());
		lavanteUtils.assertPageTitle(expAccountsetupPageTitle);
		lavanteUtils.fluentwait(xAcceptDeclineHeader);
		actPageHeader = lavanteUtils.getText(xAcceptDeclineHeader);
		if (actPageHeader.contains(expPage)) {
			Reporter.log("Verified |Accept and Decline page| header: " + actPageHeader);
			strActAcceptText = lavanteUtils.getText(xAcceptRadioBtnText);
			strActDeclineText = lavanteUtils.getText(xDeclineRadioBtnText);

			if (strExpAcceptText.equalsIgnoreCase(strActAcceptText)) {
				Reporter.log("Verified |Accept Radio Button|");
			} else {
				// log.severe("Test failed due to |Accept| radio button text
				// does not matched with expected text: "+strExpAcceptText+ "
				// but actual: "+ strActAcceptText+" in the Accept and Decline
				// page ");
				lavanteUtils.takeScreenshot(methodName);
				Assert.assertTrue(false,
						"Test failed due to |Accept| radio button text does not matched with expected text: "
								+ strExpAcceptText + " but actual: " + strActAcceptText
								+ "  in the Accept and Decline page ");
			}

			if (strExpDeclineText.equalsIgnoreCase(strActDeclineText)) {
				Reporter.log("Verified |Decline Radio Button|");
			} else {
				// log.severe("Test failed due to |Accept| radio button text
				// does not matched with expected text: "+strExpDeclineText+ "
				// but actual: "+ strActDeclineText+" in the Accept and Decline
				// page ");
				lavanteUtils.takeScreenshot(methodName);
				Assert.assertTrue(false,
						"Test failed due to |Accept| radio button text does not matched with expected text: "
								+ strExpDeclineText + " but actual: " + strActDeclineText
								+ "  in the Accept and Decline page ");
			}

			lavanteUtils.isElementDisplayed(xAcceptRadioBtn);
			lavanteUtils.isElementDisplayed(xDeclineRadioBtn);
			lavanteUtils.isElementDisplayed(CssBtnAcceptReset);
			lavanteUtils.isElementDisplayed(CssBtnAcceptSubmit);

			// acceptMultipleInvites();

			// closeChildWindow(driver, parentWindow);
			lavanteUtils.waitForTime(500);
			// switchToParentWindow(driver, parentWindow);

		} else {
			// log.severe("Test failed due to expected |Accept and Decline| page
			// header: "+expPage+" but found: "+actPageHeader+" in an accept and
			// decline page ");
			lavanteUtils.takeScreenshot(methodName);
			Assert.assertTrue(false, "Test failed due to expected |Accept and Decline| page header: " + expPage
					+ " but found: " + actPageHeader + " in an accept and decline page ");
		}

	}

	public void acceptMultipleInvites() {
		String actRegPageHeader = "";
		WebElement webElmRadioBtn = null;
		webElmRadioBtn = xAcceptRadioBtn;
		if (!webElmRadioBtn.isSelected()) {
			webElmRadioBtn.click();
		}
		lavanteUtils.click(CssBtnAcceptSubmit);
		Reporter.log("Clicked on the |Submit| button successfully");
		if (lavanteUtils.isElementDisplayed(IDTinEField) == true) {
			lavanteUtils.fluentwait(IDTinEField);
			actRegPageHeader = lavanteUtils.getText(xAccountSetupHeader);
			if (actRegPageHeader.contains(expRegPageHeader)) {
				Reporter.log("Verification is successful for supplier accept invites from multiple customers");
			} else {
				// log.severe("Test failed due to expected Registration page
				// header: "+expRegPageHeader+" but found: "+actRegPageHeader+"
				// in supplier registration window ");
				lavanteUtils.takeScreenshot(methodName);
				Assert.assertTrue(false, "Test failed due to expected Registration page header: " + expRegPageHeader
						+ " but found: " + actRegPageHeader + " in supplier registration window ");
			}
		} else {
			// log.severe("Test failed due to registration page does not appears
			// after accept the invitaion from customer");
			lavanteUtils.takeScreenshot(methodName);
			Assert.assertTrue(false,
					"Test failed due to registration page does not appears after accept the invitaion from customer");

		}

	}

	/**
	 * Method: acceptInvite Description: Accepts invite from a customer
	 * 
	 * @param:
	 * @return:
	 * @author: madhu
	 */
	public void acceptInvite() {
		try {
			parentWindow = lavanteUtils.handlePopUpWindow(expAccountsetupPageTitle,
					ConfigPathFile.TITLE.getConstantValue());
			lavanteUtils.click(xAcceptRadioBtn);
			Reporter.log("Clicked on the |Accept| radio button");
			lavanteUtils.click(CssBtnAcceptSubmit);
			Reporter.log("Clicked on the |submit| button");
			lavanteUtils.waitForTime(2000);
			String str_titlepage = driver.getTitle();
			if (str_titlepage.contains(expAccountsetupPageTitle))
				Reporter.log("The landing page after accepting the invite is as expected and is: " + str_titlepage);
			else {
				Reporter.log("The landing page is not as expected and is : " + str_titlepage);
				Assert.assertFalse(true, "The landing page is incorrect.Title of the page : " + str_titlepage);
			}
			if (lavanteUtils.isElementDisplayed(xGratitude)) {
				Reporter.log("pop-up appears after registering for the customer");
				String str_gratitude = lavanteUtils.getText(xOkBtn);
				String exp_gratitude = "Thank you, your account has been successfully created";
				if (str_gratitude.contains(exp_gratitude)) {
					Reporter.log("The message for the pop-up is verified");
					lavanteUtils.click(driver.findElement(By.xpath("//button[@class='button_green'][@type='button']")));
					Reporter.log("Clicked on the |OK | button in the pop-up");
				}
			}
			// closeChildWindow(driver, parentWindow);
			lavanteUtils.waitForTime(500);
			// switchToParentWindow(driver, parentWindow);
		} catch (Exception e) {
			Reporter.log("Failure in the method accept Invite due to : " + e.getCause());
			// log.severe("Failure in the method accept invite due to :
			// "+e.getCause());
			Assert.assertFalse(true, "Error in invite accept : " + e.getMessage());
		}
	}

	/**
	 * Method: declineInvite Description: Declines invite from a customer
	 * 
	 * @param:
	 * @return:
	 * @author: madhu
	 */
	public void declineInvite() {
		try {
			// log.info("Decline Invite started : ");
			parentWindow = lavanteUtils.handlePopUpWindow(expAccountsetupPageTitle,
					ConfigPathFile.TITLE.getConstantValue());
			lavanteUtils.click(xDeclineRadioBtn);
			Reporter.log("\n Clicked on the |Decline| radio button");
			if (lavanteUtils.isElementDisplayed(driver.findElement(By.id("comment")))) {
				Reporter.log("The comment edit box is displayed after the decline radio button is selected");
				lavanteUtils.typeinEdit("Test for decline Invite", driver.findElement(By.id("comment")));
			} else {
				Reporter.log("The comment edit box is not displayed when decline radio button is clicked");
			}
			lavanteUtils.click(CssBtnAcceptSubmit);
			Reporter.log("Clicked on the |submit| button");
			lavanteUtils.waitForTime(500);
			lavanteUtils.assertPageTitle("Lavante SIM");
			String str_message = lavanteUtils.getText(driver.findElement(By.id("content")));
			if (str_message.equalsIgnoreCase(
					"Thank you. We appreciate the time taken by you to provide your valuable comments.")) {
				Reporter.log("The message is verified and is as expected : " + str_message);
				// log.info("Correct landing page ");

			} else {
				Reporter.log("Failed to land on the page expected");
				Assert.assertFalse(true,
						"Failure to land on the expected page :Title of the landing page : " + str_message);
			}
			// closeChildWindow(driver, parentWindow);
			lavanteUtils.waitForTime(500);
			// switchToParentWindow(driver, parentWindow);
		} catch (Exception e) {
			Reporter.log("Failure occured in the method due to the reason: " + e.getMessage());
			// log.severe("Failure in decline invite due to : "+e.getCause());
			Assert.assertFalse(true, "Failure in the method decline invite Reason : " + e.getCause());
		}

	}

	
	
}
