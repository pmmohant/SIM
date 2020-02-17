/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */

package com.lavante.sim.customer.pageobjects.Login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.*;

public class SimAccRegistrationPage {
	String testCaseName=this.getClass().getSimpleName();
	GetExcelFile ge=new GetExcelFile();
	LavanteUtils lavanteUtils=new  LavanteUtils();
	String methodName="";
	private String[] parentWindow = {"",""};
	//Declare web driver

	private String ExpSimRegistrationPageTitle="Lavante SIM";
	
	private String ExpDefaultCountry="United States of America";

	
	@FindBy(id="country")
	private WebElement IDCountryName;
	@FindBy(id="contactName")
	private WebElement IDContactName;
	@FindBy(id="department")
	private WebElement IDDepartment;
	@FindBy(id="companyLegalName")
	private WebElement IDCompanyLegalName;
	@FindBy(id="tin")
	private WebElement IDTinField;
	@FindBy(id="confirm")
	private WebElement IDConfirm;
	@FindBy(id="companyLegalNameForCanada")
	private WebElement IDComLegalNameForCanada;
	@FindBy(id="province")
	private WebElement IDProvince;
	@FindBy(id="password")
	private WebElement IDPassword;
	@FindBy(id="qst")
	private WebElement IDQst;
	@FindBy(id="salesTaxId")
	private WebElement IDSalesTaxId;
	@FindBy(id="reset_button")
	private WebElement IDRegClearBtn;
	@FindBy(id="companyLegalNameForThatCountry")
	private WebElement IDCompanyLegalNameForNonUSCountry;
	@FindBy(id="tinForThatCountry")
	private WebElement IDTinForThatCountry;
	
	private String ClassLabelName="required";
	
	private String RegClass="class";
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/div/table/tbody/tr/td/label[contains(@for,'contactName')]")
	private WebElement xRegContactName;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/div/table/tbody/tr/td/label[contains(@for,'country')]")
	private WebElement xRegCountryName;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1]/table/tbody[2]/tr[1]/td[1]/label[contains(@for,'companyLegalName')]")
	private WebElement xRegCompanyLegalName;
	@FindBy(xpath="//*[@id='legalIdentifierType']//label[@for='taxIDType']")
	private WebElement xRegTinId;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/p/label[contains(@for,'confirm')]")
	private WebElement xRegConfirmRadioBtn;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1]/legend/span[contains(@class,'country_name highlight_green')]")
	private WebElement xRegUpdateCountryName;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2]/legend/span[contains(@class,'country_name highlight_green')]")
	private WebElement xRegUpdateCountryNameNonUS;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/div/table[2]/tbody/tr[4][contains(@class,'canada-only recovery_supplier')][contains(@style,'display: table-row;')]")
	private WebElement xRegDisplayProvince;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/div/table[2]/tbody[1]/tr[4]/td[1]/label[contains(@for,'province')]")
	private WebElement xRegProvince;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2][contains(@class,'non-us recovery_supplier')][contains(@style,'display: block;')]")
	private WebElement xRegDisplayNonUS;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2]/table/tbody[1]/tr[3]/td[1]/label")
	private WebElement xRegNonUSLegalID;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1][contains(@class,'us-only recovery_supplier')][contains(@style,'display: block;')]")
	private WebElement xRegUSCanadaTableDis;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1]/table/tbody[2]/tr")
	private List<WebElement> xRegRowRecordsOfUS;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1]/table/tbody[1]/tr")
	private List<WebElement> xRegRowRecordsOfCanada;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1]/table/tbody[1][contains(@class,'canada-only')][contains(@style,'display: table-row-group;')]")
	private WebElement xRegDisplayCanada;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2]/table/tbody[1]/tr")
	private List<WebElement> xRegRowRecordsOfNonUSCanada;
	@FindBy(xpath="//*[@id='accountRegistrationForm']//input[contains(@type,'submit')]")
	private WebElement xRegNextBtn;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/p[2]/span")
	private WebElement xErrCheckBoxBtn;
	@FindBy(xpath=".//*[@id='confirm_vat_other']/td[2]/span")
	private WebElement xErrLegalID_TaxID;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/fieldset[2]/table/tbody[1]/tr[1]/td[2]/span")
	private WebElement xErrName_BusinessNameNonUS;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/fieldset[1]/table/tbody[1]/tr[1]/td[2]/span")
	private WebElement xErrName_BusinessNameCanada;
	@FindBy(xpath=".//*[@id='legal_id_only']/td[2]/span")
	private WebElement xErrLegalID_TaxIDCanada;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/div[1]/table[2]/tbody/tr[4]/td[2]/span")
	private WebElement xErrProvince;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/div[1]/table[1]/tbody/tr[1]/td[2]/span")
	private WebElement xErrNameField;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/div[1]/table[1]/tbody/tr[4]/td[2]/span")
	private WebElement xErrCountryField;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/fieldset[1]/table/tbody[2]/tr[1]/td[2]/span")
	private WebElement xErrName_BusinessNameFieldForUS;
	@FindBy(xpath=".//*[@id='accountRegistrationForm']/fieldset[1]/table/tbody[2]/tr[2]/td[2]/span")
	private WebElement xErrTaxIDField;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1]/table/tbody[2][contains(@class,'US_income')][contains(@style,'display: table-row-group;')]")
	private WebElement xRegAnyUSIncomeTableData;
	@FindBy(xpath="//input[contains(@id,'US_income_yes')]")
	private WebElement xRegAnyUSIncomeRadioBtn;
	@FindBy(xpath="//input[contains(@id,'US_income_no')]")
	private WebElement xRegAnyUSIncomeRadioBtnNo;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2][contains(@class,'non-us recovery_supplier')]/table/tbody/tr[3]/td[2]/input[contains(@id,'VAT_yes')]")
	private WebElement xRegLagalIDTaxIDBtnYes;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2][contains(@class,'non-us recovery_supplier')]/table/tbody/tr[3]/td[2]/input[contains(@id,'VAT_no')]")
	private WebElement xRegLagalIDTaxIDBtnNo;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2]/table/tbody[1]/tr[contains(@id,'AllCountryList')][contains(@style,'display: table-row;')]")
	private WebElement xRegLegalIDFieldDis;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2]/table/tbody[1]/tr[contains(@id,'AllCountryList')]/td/label[contains(@for,'tinForThatCountry')]")
	private WebElement xRegLegalIDFieldLabel;
	@FindBy(xpath="//span[contains(@class,'error')]")
	private WebElement xCheckBoxPopupErrorMsg;
	@FindBy(xpath="//span[contains(@id,'ui-id')][contains(@class,'ui-dialog-title')]")
	private WebElement xCheckBoxPopupHeader;
	@FindBy(xpath="//iframe[contains(@class,'popup_iframe ui-dialog-content ui-widget-content')]")
	private WebElement xCheckBoxPopupIFrame;
	@FindBy(css="button[class='button button_green'][type='submit']")
	private WebElement xCheckBoxPopupOkBtn;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1][contains(@class,'us-only recovery_supplier')]/table/tbody/tr[2]/td[2]/input[contains(@id,'VAT_yes')]")
	private WebElement xRegLegalIDBtnCanadaYes;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[1][contains(@class,'us-only recovery_supplier')]/table/tbody/tr[2]/td[2]/input[contains(@id,'VAT_no')]")
	private WebElement xRegLegalIDBtnCanadaNo;
	@FindBy(xpath="//input[contains(@id,'US_income_yes2')]")
	private WebElement xRegAnyUSIncomeRadioBtnYes2;
	@FindBy(xpath="//form[contains(@id,'accountRegistrationForm')]/fieldset[2]/table/tbody[2]/tr[1]/td[1]/label[contains(@for,'companyLegalNameNonUS')]")
	private WebElement xRegCompanyLegalNameNonUS;
	@FindBy(xpath="//*[@id='usIncomeLegalIdentifierType']//label[@for='usIncomeTaxIDType']")
	private WebElement xRegTinNonUS;
	@FindBy(xpath="//input[contains(@id,'US_income_no2')]")
	private WebElement xRegAnyUSIncomeRadioBtnNo2;
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front dialog ui-dialog-buttons']/div[1]/span")
	private WebElement xpaththanksforreg;
	@FindBy(xpath=".//*[@class='dialog undefined ui-dialog-content ui-widget-content']")
	private WebElement xpathmessage;
	@FindBy(xpath="//button[@class='button_green'][@type='button']")
	private WebElement xpathOKbtnThanks;
	@FindBy(xpath="//a[@class='help_text']")
	private WebElement xCountryHelpLink;
	@FindBy(xpath="//a[@class='help_text legalInfoHelp']")
	private WebElement xCompanyLegalIDHelpLink;
	
	private String expCountryHelpLinkMsg="If you are a corporation, enter a country of incorporation";
	
	private String expCompanyLegalIDHelpLinkMsg="A Legal ID is a unique number provided by the governments of various countries as a means of tracking their citizens";
	
	private String expBusinessNameLabelTxt="Name/Business Name (As shown on your income tax return)";
	
	private String expTINIDLabelTxt="Taxpayer Identification Number [TIN] Type:";
	@FindBy(xpath="Tax Identification Number [TIN]:")
	private WebElement expTIN;
	private String txtNameField="'Name' cannot be left blank.";
	private String txtCountryField="'Country' cannot be left blank.";
	private String txtName_BusinessNameField="Name/Business Name (As shown on your income tax return) field cannot be left blank.";
	private String txtTaxIDField="'Tax Identification Number' cannot be left blank.";
	
	private String txtCheckBoxField="Certify the accuracy of information provided by you by selecting the above checkbox";
	private String txtProvinceField="'Province' cannot be left blank.";
	private String txtLegalID_TaxIDField="You need to specify a response to this question.";
	
	private String txtESignatureHeader="Electronic Signature";
	private String exp_gratitude="Thank you, your account has been successfully created";
	
	public WebDriver driver=null;


	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	public SimAccRegistrationPage(WebDriver driver) {
		try {
			this.driver = driver;
		} catch (Exception e)  {						
			//log.severe("Method: LoginPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
	}
	/**
	 * Method Name : validateMandateStarMarkFields
	 * Purpose: Method to Verify the Mandate Fields For a given Countries
	 * @param: Array List objSimRegistrationTestData
	 * @return: None
	 */
	public void validateMandateStarMarkFields(List<setTestData> objSimRegistrationTestData){
		checkForDefaultCountry();
		verifyCommonMandateFields();
		//Method to verify the HELP link text tip messages
		checkForHelpLinkTextMsg(xCountryHelpLink,expCountryHelpLinkMsg);
		checkForHelpLinkTextMsg(xCompanyLegalIDHelpLink,expCompanyLegalIDHelpLinkMsg);
		for(int i=0;i<objSimRegistrationTestData.size();i++){
			lavanteUtils.selectDropDownValue(IDCountryName,objSimRegistrationTestData.get(i).getCountry().toString());
			if(objSimRegistrationTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.USA.getConstantValue())){
				verifyPresenceOfStarMarkFields("Tax Identification Number [TIN]",objSimRegistrationTestData.get(i).getCountry().toString(),xRegUpdateCountryName,xRegDisplayProvince,xRegTinId,false);
			}else if(objSimRegistrationTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.Canada.getConstantValue())){
				verifyPresenceOfStarMarkFields("Province",objSimRegistrationTestData.get(i).getCountry().toString(),xRegUpdateCountryName,xRegDisplayProvince,xRegProvince,true);

			}else {
				verifyPresenceOfStarMarkFields("Do you have a Legal ID/Tax ID?",objSimRegistrationTestData.get(i).getCountry().toString(),xRegUpdateCountryNameNonUS,xRegDisplayNonUS,xRegNonUSLegalID,true);

			}
		}
	}

	/**
	 * Method Name : verifyPresenceOfStarMarkFields
	 * Purpose: Method to Verify the  Mandate Fields with star marks specific to country
	 * @param: String perform,String expCountryName,String strCountryName,String strDisTable,String strLabelTxt,boolean flag
	 * @return: None
	 */
	public void verifyPresenceOfStarMarkFields(String perform,String expCountryName,WebElement strCountryName,WebElement strDisTable,WebElement strLabelTxt,boolean flag){
		//Reporter.log("\n");
		String actCountryName="";
		actCountryName=lavanteUtils.getText(strCountryName);
		if(expCountryName.equalsIgnoreCase(actCountryName))
		{
			if(lavanteUtils.isElementDisplayed(strDisTable)==flag)
			{
				//actTINText=gp.getText(driver, ConfigPathFile.XPATH.getConstantValue(), strLabelTxt);
				//Verify Tax Identification Number [TIN] Field Label for US Country
				//if(expTINText.equalsIgnoreCase(actTINText)){
				if(validateRequiredFields(ClassLabelName, strLabelTxt)==true){			
					Reporter.log("Verification is successful for | " +perform+ " | mandatory field with |*| mark ");
				}else{
					//log.severe("Verification failed for | " +perform+ " | mandatory field ");
					Assert.assertTrue(false,"Verification failed for | " +perform+ " | mandatory field ");
				}
				/*}else{
					//log.severe("Verification failed for | " +perform+ " | field Label name ");
					Assert.assertTrue(false,"Verification failed for | " +perform+ " | field Label name ");
				}*/

			}else{
				//log.severe("Test failed due to verification failed for | " +perform+ " | mandatory field table records for US ");
				Assert.assertTrue(false,"Test failed due to verification failed for | " +perform+ " | mandatory field for US ");
			}
		}else{
			//log.severe("Test failed due to expected country name:  "+expCountryName+" but it displayed the country as: "+actCountryName);
			Assert.assertTrue(false,"Test failed due to expected country name:  "+expCountryName+" but it displayed the country as: "+actCountryName);
		}
	}

	/**
	 * Method Name : checkForHelpLinkMsg
	 * Purpose: Method to Verify the check For Help Link Messages
	 * @param: None
	 * @return: None
	 */
	public void checkForHelpLinkTextMsg(WebElement linkLocator,String expTipMsg){
		lavanteUtils.waitForTime(1500);
		String getActTipMsg="";
		Reporter.log("\n");
		//gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),linkLocator);
		//Reporter.log("Clicked on the |Help| link ");
		lavanteUtils.waitForTime(800);
		getActTipMsg=lavanteUtils.getValue(linkLocator,"title");
		try {
			if(getActTipMsg!=null){
				Reporter.log("Expected  Help Link Tip Message: "+getActTipMsg);
				if(getActTipMsg.contains(expTipMsg)){
					Reporter.log("Verification of 'Help' link text messages done successfully, and the actual 'Help' link Tip Message:  { "+getActTipMsg+" }");
				}else{
					Reporter.log("Verification failed for 'Help' link text messages, and the actual 'Help' link Tip Message:  { "+getActTipMsg+" }");
				}
			}else {
				Reporter.log("Actual Tool Tip Help Message is null due to tip text messages are hidden in the DOM structure:  "+getActTipMsg);
			}
		} catch (Exception e) {
			//log.severe("Tool Tip Help Message: "+e.getMessage());
		}
	}

	/**
	 * Method Name : checkForDefaultCountry
	 * Purpose: Method to Verify the default country 
	 * @param: None
	 * @return: None
	 */
	public void checkForDefaultCountry(){
		Reporter.log("\n");
		String defaultCountry=ExpDefaultCountry;
		WebElement option =null;
		Select select =null;
		WebElement web_Element =driver.findElement(By.xpath("//*[@id='country_chosen']/a/span"));
		/*select = new Select(web_Element);
		option = select.getFirstSelectedOption();*/
		if(defaultCountry.equalsIgnoreCase(web_Element.getText())){
			Reporter.log("Verification is Successful for selected default country:  "+web_Element.getText());
		}else{
			//log.severe("Test failed due to expected default country |"+defaultCountry+"| but found "+web_Element.gp.getText());
			Assert.assertTrue(false,"Test failed due to expected default country |"+defaultCountry+"| but found "+web_Element.getText());
		}
	}
	/**
	 * Method Name : verifyCommonMandateFields
	 * Purpose: Method to Verify the  Common Mandate Fields for aLL The countries
	 * @param: None
	 * @return: None
	 */
	public void verifyCommonMandateFields(){
		Reporter.log("\n");
		//Verify Name Field Label
		if(validateRequiredFields(ClassLabelName,xRegContactName)==true){			
			Reporter.log("Verification is successful for | Name | mandatory field with |*| mark ");
		}else{
			//log.severe("Verification failed for | Name | mandatory field ");
			Assert.assertTrue(false,"Verification failed for | Name | mandatory field ");
		}
		//Verify Country Field Label
		if(validateRequiredFields(ClassLabelName,xRegCountryName)==true){			
			Reporter.log("Verification is successful for | Country | mandatory field with |*| mark ");
		}else{
			//log.severe("Verification failed for | Country | mandatory field ");
			Assert.assertTrue(false,"Verification failed for | Country | mandatory field ");
		}

		//Verify Name/Business Name Field Label
		if(validateRequiredFields(ClassLabelName, xRegCompanyLegalName)==true){			
			Reporter.log("Verification is successful for | Name/Business Name | mandatory field with |*| mark ");
		}else{
			//log.severe("Verification failed for | Name/Business Name | mandatory field ");
			Assert.assertTrue(false,"Verification failed for | Name/Business Name | mandatory field ");
		}
		//Verify Confirm Check Box Field Label
		if(validateRequiredFields(ClassLabelName,xRegConfirmRadioBtn)==true){			
			Reporter.log(" Verification is successful for | Confirm Check Box | mandatory field with |*| mark ");
		}else{
			//log.severe("Verification failed for | Confirm Check Box | mandatory field ");
			Assert.assertTrue(false," Verification failed for | Confirm Check Box | mandatory field ");
		}
	}


	/**
	 * Method Name : validateRequiredFields
	 * Purpose: Method to Verify the Mandate Fields class name for a given Countries
	 * @param: String expClassLabel,String identifyBy, String locator
	 * @return: None
	 */
	public boolean  validateRequiredFields(String expClassLabel, WebElement locator){
		String actClassLabel="";
		actClassLabel=lavanteUtils.getValue(locator,RegClass);
		if(actClassLabel.contains(expClassLabel)){
			return true;
		}
		return false;
	}
	public void verifyHelpLinkMsg(String expTextStr){
	//	lavanteUtils.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),"");

	}
	//Calling Method Second
	/**
	 * Method Name : validateUIControls
	 * Purpose: Method to call the respective method based on condition matched
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void validateUIControls(List<setTestData> objSimRegistrationTestData){
		Reporter.log("\n");
		List<setTestData> objFieldLabelNamesTestData= ge.getData(ConfigPathFile.TestDataForSimRegistration.getConstantValue(), ConfigPathFile.FieldLabelNames.getConstantValue());
		for(int i=0;i<objSimRegistrationTestData.size();i++){
			lavanteUtils.selectDropDownValue(IDCountryName,objSimRegistrationTestData.get(i).getCountry().toString());
			if(objSimRegistrationTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.USA.getConstantValue())){
				verifyUIControlsOfCountries(objFieldLabelNamesTestData,xRegUSCanadaTableDis,ConfigPathFile.USA.getConstantValue(),xRegRowRecordsOfUS,ConfigPathFile.USA.getConstantValue());
			}else if(objSimRegistrationTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.Canada.getConstantValue())){
				verifyUIControlsOfCountries(objFieldLabelNamesTestData,xRegDisplayCanada,ConfigPathFile.Canada.getConstantValue(),xRegRowRecordsOfCanada,ConfigPathFile.Canada.getConstantValue());
			}else {
				verifyUIControlsOfCountries(objFieldLabelNamesTestData,xRegDisplayNonUS,ConfigPathFile.NonUS.getConstantValue(),xRegRowRecordsOfNonUSCanada,ConfigPathFile.NonUS.getConstantValue());
			}
		}
	}
	/**
	 * Method Name : verifyUIControlsOfUS
	 * Purpose: Method to verify the US country field labels 
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void verifyUIControlsOfCountries(List<setTestData> objSimRegistrationTestData,WebElement strTableRowsDis,String strCountryName,List<WebElement> strRowRecords,String strExpTxt){
		Reporter.log(" Verification of UI Controls Of "+ strCountryName +" Country Initiated");
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		List<String>expFieldLabelText=listExpFieldNamesTexts(objSimRegistrationTestData,strCountryName);
		if(lavanteUtils.isElementDisplayed(strTableRowsDis)==true)
		{
			lavanteUtils.fluentwait(strRowRecords.get(0));
			List<WebElement> actFieldLabelText=strRowRecords;
			for(int k=0;k<expFieldLabelText.size();k++)
			{
				for(int i=0;i<actFieldLabelText.size();i++)
				{
					if(!actFieldLabelText.get(i).getText().toString().equalsIgnoreCase(""))
					{
						if(expFieldLabelText.get(k).trim().toString().equalsIgnoreCase(actFieldLabelText.get(i).getText().trim().toString()))
						{
							Reporter.log("Verification of | " +actFieldLabelText.get(i).getText().toString() + "| is successful");
							break;
						}else {
							if (i + 1 == actFieldLabelText.size()) {
								//log.severe("Test is failed due to expected and actual label names are mismatched, expected is "+ expFieldLabelText.get(k).trim().toString()+ " but actual is "		+actFieldLabelText.get(i).gp.getText().trim().toString());
								lavanteUtils.takeScreenshot(methodName);
								Assert.assertTrue(false,"Test is failed due to expected and actual label names are mismatched, expected is "+ expFieldLabelText.get(k).trim().toString()+ " but actual is "		+actFieldLabelText.get(i).getText().trim().toString());
							}
						}
					}/*else{
						//log.severe(" Verification failed due to texts of the field labels are are not visible for the "+ strExpTxt +"Country: "+actFieldLabelText.get(i).gp.getText().toString());
						Assert.assertTrue(false," Verification failed due to texts of the field labels are are not visible for the "+ strExpTxt +"Country: "+actFieldLabelText.get(i).gp.getText().toString());
					}*/
				}
			}
			Reporter.log("\n");
		}else {
			//log.severe(" Test failed due to UI Controls of " +strCountryName +" country are not displayed on the page ");
			Assert.assertTrue(false," Test failed due to UI Controls of " +strCountryName +" country are not displayed on the page ");
		}

	}

	//Third Calling Method
	/**
	 * Method Name : validateUIControlOptionsForNonUS_Canada
	 * Purpose: Method to call the respective method based on condition matched
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void validateUIControlOptionsForNonUS_Canada(List<setTestData> objSimRegistrationTestData){
		Reporter.log("\n");
		for(int i=0;i<objSimRegistrationTestData.size();i++){
			lavanteUtils.selectDropDownValue(IDCountryName,objSimRegistrationTestData.get(i).getCountry().toString());
			if(objSimRegistrationTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.USA.getConstantValue())){
				continue;
			}else if(objSimRegistrationTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.Canada.getConstantValue())){
				if(verifyUIControlsOfOptions(objSimRegistrationTestData.get(i).getCountry().toString(),xRegUpdateCountryName,xRegDisplayCanada)==true){
					validateAnyUSOptions(objSimRegistrationTestData.get(i).getCountryKey().toString(),xRegAnyUSIncomeRadioBtn,xRegAnyUSIncomeTableData,xRegCompanyLegalName,xRegTinId,xRegAnyUSIncomeRadioBtnNo);
				}
			}else {				
				if(verifyUIControlsOfOptions(objSimRegistrationTestData.get(i).getCountry().toString(),xRegUpdateCountryNameNonUS,xRegDisplayNonUS)==true){
					validateLegalIDOptions(objSimRegistrationTestData.get(i).getCountryKey().toString(), objSimRegistrationTestData.get(i).getCountry().toString());
					validateAnyUSOptions(objSimRegistrationTestData.get(i).getCountryKey().toString(),xRegAnyUSIncomeRadioBtnYes2,xRegAnyUSIncomeTableData,xRegCompanyLegalNameNonUS,xRegTinNonUS,xRegAnyUSIncomeRadioBtnNo2);


				}
			}
		}

	}
	/**
	 * Method Name : validateAnyUSOptions
	 * Purpose: Method to call the respective method based on condition matched
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void validateAnyUSOptions(String option,WebElement strRadioBtnYes,WebElement tableRows,WebElement businessName,WebElement tinID,WebElement strRadioBtnNo){
		if(option.equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
			fieldsAppearForAnyUSIncomeOptionYes(strRadioBtnYes,tableRows,businessName,tinID);
		}else{
			fieldsAppearForAnyUSIncomeOptionNo(strRadioBtnNo,tableRows);
		}
	}
	/**
	 * Method Name : validateLegalIDOptions
	 * Purpose: Method to call the respective method based on condition matched
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void validateLegalIDOptions(String option,String expCountryName){
		if(option.equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
			fieldsAppearForNonUSLegalIDYes(expCountryName);
		}else{
			fieldsAppearForNonUSLegalIDNo();
		}
	}

	/**
	 * Method Name : verifyUIControlsOfNonUS_Canada
	 * Purpose: Method to verify the Canada country field labels 
	 * @param: String expCountryName
	 * @return: None
	 */
	public boolean verifyUIControlsOfOptions(String expCountryName,WebElement strCountryNameLocator,WebElement strDisCanadaTableRows){
		String actCountryName="";
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(" Verification of UI Controls Of |Any US Source Income| for "+expCountryName+" Country Initiated");
		actCountryName=lavanteUtils.getText(strCountryNameLocator);
		if(expCountryName.equalsIgnoreCase(actCountryName))
		{
			if(lavanteUtils.isElementDisplayed(strDisCanadaTableRows)==true)
			{
				return true;
			}else{
				//log.severe("Test failed due to expected to display "+strDisCanadaTableRows+" locator for the country fields table ");
				Assert.assertTrue(false,"Test failed due to expected to display "+strDisCanadaTableRows+" locator for the country fields table ");
			}
		}else{
			//log.severe("Test failed due to expected country name:  "+expCountryName+" but it displayed the country as: "+actCountryName);
			Assert.assertTrue(false,"Test failed due to expected country name:  "+expCountryName+" but it displayed the country as: "+actCountryName);
		}
		return false;
	}
	/**
	 * Method Name : fieldsAppearsForUSIncomeNo
	 * Purpose: Method to verify the fields Appears For USIncome while while user selects option "Yes" for US Income
	 * @param: None
	 * @return: None
	 */
	public void fieldsAppearForAnyUSIncomeOptionYes(WebElement locatorThree,WebElement locatorFour,WebElement locatorFive,WebElement locatorSix){
		String actBusinessNameTxt="",exptBusinessNameTxt=expBusinessNameLabelTxt,
				actTinIDTxt="",expTinIDTxt=expTINIDLabelTxt;
		try {
			lavanteUtils.click(locatorThree);
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.isElementDisplayed(locatorFour)==true)
			{
				actBusinessNameTxt=lavanteUtils.getText( locatorFive);
				actTinIDTxt=lavanteUtils.getText( locatorSix);
				
				
				if(exptBusinessNameTxt.equalsIgnoreCase(actBusinessNameTxt) && expTinIDTxt.equalsIgnoreCase(actTinIDTxt)){
					Reporter.log("Verification of | 'Company Legal Name' and 'Tax Identification Number [TIN]' fields appears while user selects option 'Yes' for US Income| is successful");
				}else{
					//log.severe("Verification failed for | 'Company Legal Name' and 'Tax Identification Number [TIN]' fields appears while user selects option 'Yes' for US Income");
					Assert.assertTrue(false,"Verification failed for | 'Company Legal Name' and 'Tax Identification Number [TIN]' fields appears while user selects option 'Yes' for US Income");
				}
			}else {
				//log.severe("Test failed due to expected to display Canada country fields table ");
				Assert.assertTrue(false,"Test failed due to expected to display Canada country fields table ");
			}
			Reporter.log("");
		} catch (Exception e) {
			//log.severe("Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
			Assert.assertTrue(false,"Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
		}

	}

	/**
	 * Method Name : fieldsAppearsForUSIncomeNo
	 * Purpose: Method to verify the fields Appears For USIncome while while user selects option "No" for US Income
	 * @param: None
	 * @return: None
	 */
	public void fieldsAppearForAnyUSIncomeOptionNo(WebElement locatorSeven,WebElement locatorEight){
		try {
			lavanteUtils.click(locatorSeven);
			if(lavanteUtils.isElementDisplayed(locatorEight)==false)
			{
				Reporter.log("Verification of | 'Company Legal Name' and 'Tax Identification Number [TIN]' fields should not appears while user selects option 'No' for US Income| is successful");
			}else {
				//log.severe("Test failed due to expected to disable the Canada country fields ");
				Assert.assertTrue(false,"Test failed due to expected to disable the Canada country fields ");
			}
		} catch (Exception e) {
			//log.severe("Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
			Assert.assertTrue(false,"Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
		}
	}



	/**
	 * Method Name : fieldsAppearForNonUSLegalIDYes
	 * Purpose: String expLegalIDForCountry
	 * @param: None
	 * @return: None
	 */
	public void fieldsAppearForNonUSLegalIDYes(String expLegalIDForCountry){
		String actLegalIDTxt="",expLegalIDTxt="Legal ID/Tax ID for "+expLegalIDForCountry;
		try {
			lavanteUtils.click(xRegLagalIDTaxIDBtnYes);
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.isElementDisplayed(xRegLegalIDFieldDis)==true)
			{
				actLegalIDTxt=lavanteUtils.getText(xRegLegalIDFieldLabel);
				if(expLegalIDTxt.trim().toString().contains(actLegalIDTxt.trim().toString())){
					Reporter.log("Verification of 'Legal ID/Tax ID ' field appears while user selects option 'Yes' for  NonUS and NonCanada  is successful");
				}else{
					//log.severe("Verification failed for 'Legal ID/Tax ID ' fields appears while user selects option 'Yes' for  NonUS and NonCanada  is successful");
					Assert.assertTrue(false,"Verification failed for 'Legal ID/Tax ID ' fields appears while user selects option 'Yes' for  NonUS and NonCanada  is successful");
				}
			}else {
				//log.severe("Test failed due to expected to display LegalID/Tax ID fields table ");
				Assert.assertTrue(false,"Test failed due to expected to display LegalID/Tax ID fields table ");
			}
		} catch (Exception e) {
			//log.severe("Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
			Assert.assertTrue(false,"Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
		}

	}
	/**
	 * Method Name : fieldsAppearForNonUSLegalIDNo
	 * Purpose: None
	 * @param: None
	 * @return: None
	 */
	public void fieldsAppearForNonUSLegalIDNo(){
		try {
			lavanteUtils.click( xRegLagalIDTaxIDBtnNo);
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.isElementDisplayed(xRegLegalIDFieldDis)==false)
			{
				Reporter.log("Verification of 'Legal ID/Tax ID for the selected country' fields should not appears while user selects option 'No' for Non US  is successful");
			}else {
				//log.severe("Test failed due to 'Legal ID/Tax ID for the selected country' fields should not appears while user selects option 'No' for Non US");
				Assert.assertTrue(false,"Test failed due to 'Legal ID/Tax ID for the selected country' fields should not appears while user selects option 'No' for Non US");
			}
		} catch (Exception e) {
			//log.severe("Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
			Assert.assertTrue(false,"Test failed due to exception in the method fieldsAppearsForUSIncomeYes due to "+e.getMessage());
		}

	}

	//--------------------------



	/**
	 * Method Name : listExpFieldNamesTexts
	 * Purpose: Method to get the expected fieldlabel names for excel
	 * @param: List<setTestData> objListfieldLabelNames,String fieldLabelText
	 * @return: None
	 */
	public List<String> listExpFieldNamesTexts(List<setTestData> objListfieldLabelNames,String fieldLabelText){
		List<String> listExpWebElmText =new ArrayList<String>();
		for(int i=0;i<objListfieldLabelNames.size();i++){
			if(objListfieldLabelNames.get(i).getCountry().toString().equals(fieldLabelText)){
				String expText[]=objListfieldLabelNames.get(i).getExpFieldLabelNames().trim().toString().split("###");
				for(int k=0;k<expText.length;k++){
					listExpWebElmText.add(expText[k]);
				}
			}
		}
		return listExpWebElmText;
	}

	/**
	 * Method Name : VerifyRequiredFieldErrMessages
	 * Purpose: Method to Verify the Required Field Error Messages
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void VerifyRequiredFieldErrMessages(List<setTestData> objSimRegTDForErrMsg){
		Reporter.log("Verification of Required Mandate Field Error Messages Initiated");
		String strName="";
		Reporter.log("\n");
		for(int i=0;i<objSimRegTDForErrMsg.size();i++){
			if(objSimRegTDForErrMsg.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.None.getConstantValue()))
			{
				//Verify the name field error messages by submitting the registration without name
				Reporter.log(" Verification of  ' Name ' field error messages Initiated");
				strName=lavanteUtils.getValue(IDContactName, ConfigPathFile.value.getConstantValue());
				IDContactName.clear();
				lavanteUtils.click(xRegNextBtn);
				validateFieldErrorMsgs(" Name Field ",txtNameField, xErrNameField,objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.typeinEdit( strName, IDContactName);
			}else if(objSimRegTDForErrMsg.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.SelectCountry.getConstantValue()))
			{
				//Verify the country field error messages by submitting the registration without country
				Reporter.log("\n");
				Reporter.log(" Verification of  'Country' field error messages Initiated for none country");
				lavanteUtils.selectDropDownValue(IDCountryName,objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.click(xRegNextBtn);
				validateFieldErrorMsgs(" Country Field",txtCountryField, xErrCountryField,objSimRegTDForErrMsg.get(i).getCountry().toString());
			}else if(objSimRegTDForErrMsg.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.USA.getConstantValue()))
			{
				//Verify the country field error messages by submitting the registration with US country without other required fields
				Reporter.log("\n");
				Reporter.log(" Verification of  'Country' field error messages Initiated for the country: "+objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.selectDropDownValue( IDCountryName,objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click(xRegNextBtn);
				lavanteUtils.waitForTime(2000);
				validateFieldErrorMsgs("Name/Business Name Field ",txtName_BusinessNameField, xErrName_BusinessNameFieldForUS,objSimRegTDForErrMsg.get(i).getCountry().toString());
				validateFieldErrorMsgs(" Tax Identification Number field ",txtTaxIDField, xErrTaxIDField,objSimRegTDForErrMsg.get(i).getCountry().toString());
				validateFieldErrorMsgs(" Check Box Field ",txtCheckBoxField,  xErrCheckBoxBtn,objSimRegTDForErrMsg.get(i).getCountry().toString());
			}else if(objSimRegTDForErrMsg.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.Canada.getConstantValue()))
			{
				//Verify the country field error messages by submitting the registration with Canada country without other required fields
				Reporter.log("\n");
				Reporter.log(" Verification of  'Country' field error messages Initiated for the country: "+objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.selectDropDownValue(IDCountryName,objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.click(xRegNextBtn);
				validateFieldErrorMsgs("Province Field ",txtProvinceField,xErrProvince,objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.selectDropDownValue(IDProvince,"Alberta");//objTDForSimRegInput.get(i).getProvince().toString()

				lavanteUtils.click(xRegNextBtn);
				validateFieldErrorMsgs("Name/Business Name Field ",txtName_BusinessNameField,xErrName_BusinessNameCanada,objSimRegTDForErrMsg.get(i).getCountry().toString());
				validateFieldErrorMsgs(" Do you have a legal ID/TaxID ",txtLegalID_TaxIDField,xErrLegalID_TaxIDCanada,objSimRegTDForErrMsg.get(i).getCountry().toString());
				validateFieldErrorMsgs(" Check Box Field ",txtCheckBoxField, xErrCheckBoxBtn,objSimRegTDForErrMsg.get(i).getCountry().toString());

			}else 
			{
				//Verify the country field error messages by submitting the registration with Non US and Non Canada countries without other required fields
				Reporter.log("\n");
				Reporter.log(" Verification of  'Country' field error messages Initiated for the country: "+objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.selectDropDownValue(IDCountryName,objSimRegTDForErrMsg.get(i).getCountry().toString());
				lavanteUtils.click(xRegNextBtn);
				validateFieldErrorMsgs("Name/Business Name Field ",txtName_BusinessNameField,  xErrName_BusinessNameNonUS,objSimRegTDForErrMsg.get(i).getCountry().toString());
				validateFieldErrorMsgs(" Do you have a legal ID/TaxID ",txtLegalID_TaxIDField, xErrLegalID_TaxID,objSimRegTDForErrMsg.get(i).getCountry().toString());
				validateFieldErrorMsgs(" Check Box Field ",txtCheckBoxField, xErrCheckBoxBtn,objSimRegTDForErrMsg.get(i).getCountry().toString());

			}
		}
		Reporter.log("\n");
	}

	/**
	 * Method Name : validateFieldErrorMsgs
	 * Purpose: Method to validate the Field Error Messages
	 * @param: String strOperation,String expErrorMsg,String identifyBy, String locator,String strCountryName
	 * @return: None
	 */
	public void  validateFieldErrorMsgs(String strOperation,String expErrorMsg, WebElement locator,String strCountryName){
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		String actErrorMsg="";
		try {
			actErrorMsg=lavanteUtils.getText(locator);
			if(actErrorMsg.equalsIgnoreCase(expErrorMsg)){
				Reporter.log(" Successfully verified the mandate field error messages for the | "+strOperation +" |");
			}else{
				//log.severe("Test failed due to expected error message: "+expErrorMsg + " but found: "+actErrorMsg +"  for the selected country: " +strCountryName );
				//gp.takeScreenshot(driver,methodName);
				Assert.assertTrue(false,"Test failed due to expected error message: "+expErrorMsg + " but found: "+actErrorMsg +"  for the selected country: " +strCountryName );
			}
		} catch (Exception e) {
			//log.severe("Exception occurred in the method rtnFieldErrorMsgs due to "+e.getMessage() );
			Assert.assertTrue(false,"Exception occurred in the method rtnFieldErrorMsgs due to "+e.getMessage() );

		}
	}

	/**
	 * Method Name : listExpErrorMsg
	 * Purpose: Method to split the column data and assign it to array list 
	 * @param: List<setTestData> objListfieldLabelNames, String fieldLabelText
	 * @return: None
	 */
	public List<String> listExpErrorMsg(List<setTestData> objListfieldLabelNames,String fieldLabelText){
		List<String> listExpWebElmText =new ArrayList<String>();
		for(int i=0;i<objListfieldLabelNames.size();i++){
			if(objListfieldLabelNames.get(i).getCountry().toString().equals(fieldLabelText)){
				String expText[]=objListfieldLabelNames.get(i).getErrorMessage().trim().toString().split("###");
				for(int k=0;k<expText.length;k++){
					listExpWebElmText.add(expText[k]);
					System.out.println("expText[k]: "+expText[k]);
				}
			}
		}
		return listExpWebElmText;
	}


	/**
	 * Method Name : supplierRegistrationUS
	 * Purpose: Method to Submit the supplier Registration with valid inputs for US
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void supplierRegistrationUS(setTestData objTDForSimRegInput){
		Reporter.log("Sim Supplier Registration for US Country Started");
		String errorMsgOnPopup="",expPageHeaderName="",actPageHeaderName="";
		lavanteUtils.click(IDRegClearBtn);
		lavanteUtils.waitForTime(1000);
		lavanteUtils.selectDropDownValue(IDDepartment,objTDForSimRegInput.getDepartment().toString());
		Reporter.log("Selected the value from the drop down |Department| Sucessfully ");
/*		SPselectDropDownValue(driver, "",objTDForSimRegInput.getCountry().toString());
		Reporter.log("Selected the value from the drop down |Country Name| Sucessfully ");
*/		lavanteUtils.typeinEdit( objTDForSimRegInput.getBusinessName().toString(), IDCompanyLegalName);
		Reporter.log("Entered the |Company Legal Name| Sucessfully ");
		lavanteUtils.typeinEdit(objTDForSimRegInput.getTaxID().toString(), IDTinField);
		Reporter.log("Entered the |Tin Number| Sucessfully ");

		lavanteUtils.click(IDConfirm);
		Reporter.log("Clicked on the |eSignature| Check Box Sucessfully ");
		actPageHeaderName=lavanteUtils.getText(xCheckBoxPopupHeader);
		System.out.println("actPageHeaderName: "+actPageHeaderName);
		if(expPageHeaderName.equalsIgnoreCase(actPageHeaderName)||txtESignatureHeader.equalsIgnoreCase(actPageHeaderName))
		{
			if(lavanteUtils.switchtoFrame(xCheckBoxPopupIFrame)==true);
			{
				lavanteUtils.typeinEdit(objTDForSimRegInput.getPassword().toString(), IDPassword);
				Reporter.log("Entered the |Password| Sucessfully ");
				lavanteUtils.click(xCheckBoxPopupOkBtn);
				Reporter.log("Clicked on the |Confirm eSignature| Button Sucessfully ");
				if(lavanteUtils.isElementDisplayed(xCheckBoxPopupErrorMsg)==true)
				{
					errorMsgOnPopup=lavanteUtils.getText(xCheckBoxPopupErrorMsg);
					//log.severe("Test failed due to : "+errorMsgOnPopup );
					Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
				}
			}
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(xRegNextBtn);
			Reporter.log("Clicked on the |Next Button| Button Sucessfully ");
			acceptDialogAfterReg();
			if(lavanteUtils.isElementDisplayed(xCheckBoxPopupErrorMsg)==true){
				errorMsgOnPopup=lavanteUtils.getText(xCheckBoxPopupErrorMsg);
				//log.severe("Test failed due to : "+errorMsgOnPopup );
				Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );		
			}

		}else{
			//log.severe("Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
			Assert.assertTrue(false,"Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
		}

	}
	/**
	 * Method Name : supplierRegistrationCanada
	 * Purpose: Method to Submit the supplier Registration with valid inputs for Canada
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void supplierRegistrationCanada(setTestData objTDForSimRegInput){
		Reporter.log("Sim Supplier Registration for Canada Country Started");
		String errorMsgOnPopup="",expPageHeaderName="",actPageHeaderName="";
		lavanteUtils.click(IDRegClearBtn);
		lavanteUtils.waitForTime(1000);
		lavanteUtils.selectDropDownValue(IDCountryName,objTDForSimRegInput.getCountry().toString());
		Reporter.log("Selected the value from the drop down | Country Name| Sucessfully ");

		lavanteUtils.selectDropDownValue(IDDepartment,objTDForSimRegInput.getDepartment().toString());
		Reporter.log("Selected the value from the drop down |Department| Sucessfully ");
		lavanteUtils.waitForTime(2000);
		lavanteUtils.selectDropDownValue(IDProvince,objTDForSimRegInput.getProvince().toString());
		Reporter.log("Selected the value from the drop down |Province| Sucessfully ");
		lavanteUtils.typeinEdit(objTDForSimRegInput.getBusinessName().toString(), IDComLegalNameForCanada);
		Reporter.log("Entered the | Company Legal Name For Canada | Sucessfully ");
		if(objTDForSimRegInput.getCountryKey().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue()))
		{
			lavanteUtils.click(xRegLegalIDBtnCanadaYes);
			Reporter.log("Clicked on the |Legal ID/Tax ID | 'Yes' Radio Button  Sucessfully ");
			if(objTDForSimRegInput.getProvince().toString().equalsIgnoreCase(ConfigPathFile.Quebec.getConstantValue())){
			//	gp.typeinEdit(driver, ConfigPathFile.ID.getConstantValue(),IDQst, objTDForSimRegInput.getQst().toString());
				Reporter.log("Entered the |QST Number| Sucessfully ");
			}else{
			//	gp.typeinEdit(driver, ConfigPathFile.ID.getConstantValue(),IDSalesTaxId, objTDForSimRegInput.getGst().toString());
				Reporter.log("Entered the |GST Number| Sucessfully ");
			}
		}else {
			lavanteUtils.click(xRegLegalIDBtnCanadaNo);
			Reporter.log("Clicked on the |Legal ID/Tax ID | 'No' Radio Button  Sucessfully ");
		}
		lavanteUtils.click(IDConfirm);
		Reporter.log("Clicked on the |confirm| Check Box Sucessfully ");
		actPageHeaderName=lavanteUtils.getText(xCheckBoxPopupHeader);
		if(expPageHeaderName.equalsIgnoreCase(actPageHeaderName)||txtESignatureHeader.equalsIgnoreCase(actPageHeaderName))
		{
			if(lavanteUtils.switchtoFrame(xCheckBoxPopupIFrame)==true);
			{
				lavanteUtils.typeinEdit(objTDForSimRegInput.getPassword().toString(), IDPassword);
				Reporter.log("Entered the | Password | Sucessfully ");
				lavanteUtils.click(xCheckBoxPopupOkBtn);
				Reporter.log("Clicked on the |Confirm eSignature | Button Sucessfully ");
				if(lavanteUtils.isElementDisplayed(xCheckBoxPopupErrorMsg)==true)
				{
					errorMsgOnPopup=lavanteUtils.getText(xCheckBoxPopupErrorMsg);
					//log.severe("Test failed due to : "+errorMsgOnPopup );
					Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
				}
			}
			lavanteUtils.switchtoFrame(null);
			//			gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), xRegNextBtn);
			//			Reporter.log("Clicked on the |Next Button| Button Sucessfully ");
			//			acceptDialogAfterReg();
			if(lavanteUtils.isElementDisplayed(xCheckBoxPopupErrorMsg)==true){
				errorMsgOnPopup=lavanteUtils.getText(xCheckBoxPopupErrorMsg);
				//log.severe("Test failed due to : "+errorMsgOnPopup );
				Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );		
			}
		}else{
			//log.severe("Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
			Assert.assertTrue(false,"Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
		}
	}
	/**
	 * Method Name : supplierRegistrationNonUS_NoCanada
	 * Purpose: Method to Submit the supplier Registration with valid inputs for supplierRegistrationNonUS_NoCanada
	 * @param: List<setTestData> objListfieldLabelNames
	 * @return: None
	 */
	public void supplierRegistrationNonUS_NoCanada(setTestData objTDForSimRegInput){
		Reporter.log("Sim Supplier Registration for Non US Non Canada Country Started");
		String errorMsgOnPopup="",expPageHeaderName="",actPageHeaderName="";
		lavanteUtils.click(IDRegClearBtn);
		lavanteUtils.waitForTime(1000);
		lavanteUtils.selectDropDownValue( IDDepartment,objTDForSimRegInput.getDepartment().toString());
		Reporter.log("Selected the value from the drop down |Department| Sucessfully ");
		lavanteUtils.selectDropDownValue(IDCountryName,objTDForSimRegInput.getCountry().toString());
		Reporter.log("Selected the value from the drop down | Country Name| Sucessfully ");
		lavanteUtils.typeinEdit(objTDForSimRegInput.getBusinessName().toString(), IDCompanyLegalNameForNonUSCountry);
		Reporter.log("Entered the | Business Name  | Sucessfully ");

		if(objTDForSimRegInput.getCountryKey().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue()))
		{
			lavanteUtils.click(xRegLagalIDTaxIDBtnYes);
			Reporter.log("Clicked on the |Legal ID/Tax ID | 'Yes' Radio Button  Sucessfully ");
			lavanteUtils.typeinEdit(objTDForSimRegInput.getTaxID().toString(), IDTinForThatCountry);
			Reporter.log("Entered the | Legal ID Tax ID for that country | Sucessfully ");
		}else {
			lavanteUtils.click(xRegLegalIDBtnCanadaNo);
			Reporter.log("Clicked on the |Legal ID/Tax ID | 'No' Radio Button  Sucessfully ");
		}
		lavanteUtils.click(IDConfirm);
		Reporter.log("Clicked on the |confirm| Check Box Sucessfully ");
		actPageHeaderName=lavanteUtils.getText(xCheckBoxPopupHeader);
		if(expPageHeaderName.equalsIgnoreCase(actPageHeaderName)||txtESignatureHeader.equalsIgnoreCase(actPageHeaderName))
		{
			if(lavanteUtils.switchtoFrame(xCheckBoxPopupIFrame)==true);
			{
				lavanteUtils.typeinEdit(objTDForSimRegInput.getPassword().toString(), IDPassword);
				Reporter.log("Entered the | Password | Sucessfully ");
				lavanteUtils.click(xCheckBoxPopupOkBtn);
				Reporter.log("Clicked on the |confirm| Check Box Sucessfully ");
				if(lavanteUtils.isElementDisplayed(xCheckBoxPopupErrorMsg)==true)
				{
					errorMsgOnPopup=lavanteUtils.getText(xCheckBoxPopupErrorMsg);
					//log.severe("Test failed due to : "+errorMsgOnPopup );
					Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
				}
			}
			lavanteUtils.switchtoFrame(null);
			//			gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), xRegNextBtn);
			//			Reporter.log("Clicked on the |Next Button| Button Sucessfully ");
			if(lavanteUtils.isElementDisplayed(xCheckBoxPopupErrorMsg)==true){
				errorMsgOnPopup=lavanteUtils.getText(xCheckBoxPopupErrorMsg);
				//log.severe("Test failed due to : "+errorMsgOnPopup );
				Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );	
			}

			//acceptDialogAfterReg();
		}else{
			//log.severe("Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
			Assert.assertTrue(false,"Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
		}

	}

	public void switchToRegWindow(){
		parentWindow=lavanteUtils.handlePopUpWindow( ExpSimRegistrationPageTitle, ConfigPathFile.TITLE.getConstantValue());
	}
	
	public void closeRegWindow(){
		lavanteUtils.closeChildWindow(parentWindow);
		lavanteUtils.switchToParentWindow(parentWindow);
	}
	/**
	 * Method Name : validateMandateFields
	 * Purpose: Method to Verify the Mandate Fields For a given Countries
	 * @param: Array List objSimRegistrationTestData
	 * @return: None
	 */
	public void validateSupplierRegistrations(List<setTestData> objSupplierRegTestData){
		Reporter.log("Sim Supplier Registration for multiple Countries Started");
		lavanteUtils.waitForTime(2000);
		for(int i=0;i<objSupplierRegTestData.size();i++){
			lavanteUtils.selectDropDownValue(IDCountryName,objSupplierRegTestData.get(i).getCountry().toString());
			
			if(objSupplierRegTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.USA.getConstantValue())){
				supplierRegistrationUS(objSupplierRegTestData.get(i));
			}else if(objSupplierRegTestData.get(i).getCountry().toString().equalsIgnoreCase(ConfigPathFile.Canada.getConstantValue())){
				supplierRegistrationCanada(objSupplierRegTestData.get(i));
			}else {
				supplierRegistrationNonUS_NoCanada(objSupplierRegTestData.get(i));
			}
		}
	}

	public boolean verifyLegalIDTabpresent(setTestData objTDlegalIDRecoveryCustomer){
		String clsreglegalIDUS="",clsreglegalIDnonUS="";
		clsreglegalIDUS="us-only recovery_supplier";
		clsreglegalIDnonUS="non-us recovery_supplier";
		boolean bool_ret=false;
		try{
			lavanteUtils.waitForTime(5000);
			lavanteUtils.assertPageTitle(ExpSimRegistrationPageTitle);
			lavanteUtils.click(IDRegClearBtn);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.selectDropDownValue( IDDepartment,objTDlegalIDRecoveryCustomer.getDepartment().toString());
			Reporter.log("\n Selected the value from the drop down |Department| Sucessfully ");
			lavanteUtils.selectDropDownValue( IDCountryName,objTDlegalIDRecoveryCustomer.getCountry().toString());
			Reporter.log("Selected the value from the drop down |Country Name| Sucessfully ");
			Reporter.log("Verifying if the legal ID section is present in the registration page");
			//verifying for the legal ID section 
			boolean bool_reglegalID=lavanteUtils.isElementDisplayed(driver.findElement(By.className(clsreglegalIDUS)));
			boolean bool_reglegalID2=lavanteUtils.isElementDisplayed(driver.findElement(By.className(clsreglegalIDnonUS)));
			if(bool_reglegalID||bool_reglegalID2){
				return false;
			}
			else{
				Reporter.log("Legal ID section is not present on the registration page as expected");
				lavanteUtils.click( xRegNextBtn);
				Reporter.log("Clicked on the |Next Button| Button Sucessfully ");
				bool_ret=true;
			}
			/*if(!isWebElementExists(driver,  ConfigPathFile.ID.getConstantValue(),IDTinField).isDisplayed()){
			Reporter.log("The legal ID section is not present on the registration page for the recovery customer as expected");
			gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), xRegNextBtn);
			Reporter.log("Clicked on the |Next Button| Button Sucessfully ");
			bool_ret=true;
		}*/
		}catch(Exception e){
			Reporter.log("Failure in the method to verify the Legal ID tab details for the recovery supplier");
			//log.severe("Exception while verifying the legal ID section on the registration page");
		}
		return bool_ret;
	}

	public void acceptDialogAfterReg(){

		try{
			lavanteUtils.waitForTime(3000);
			if(lavanteUtils.isElementDisplayed(xpaththanksforreg)){
				Reporter.log("pop-up appears after registering for the customer");
				String str_gratitude=lavanteUtils.getText( xpathmessage);
				if(str_gratitude.contains(exp_gratitude))
				{
					Reporter.log("The message for the pop-up is verified");
					lavanteUtils.click(xpathOKbtnThanks);
					Reporter.log("Clicked on the |OK | button in the pop-up");
				}
			}

		}catch(Exception e){
			Reporter.log("Failed to accept the dialog after registration due exception occured");
			//log.severe("Exception occured during accepting the Pop up after registration process");
			lavanteUtils.takeScreenshot("Accept_Reg_popup");
		}
	}

}
