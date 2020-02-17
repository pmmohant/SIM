package com.lavante.sim.customer.pageobjects.OFAC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.*;



public class OFACPage {
	String methodName = "";
	Properties props=null;
	//Declare web driver
	private WebDriver driver=null;
	LavanteUtils lavanteUtils=new  LavanteUtils();
	
/*	String LinkSuppliers="",LinkOFAC="",LinkOFACSDN="",TitleOFACPage="",XpathDetailsOFAC="",linkHelp="",linkOFACSDN="",IDChkInactiveCust="",
			XpathTxtInactiveCust="",IDSearchEdit="",IDSearchBtn="",XpathOFACMatchRun="",IDAll="",IDAwaitingCheck="",IDNoMatch="",
			IDRequiresDisposition="",IDOverridden="",IDDeactivated="",Xpathhelpframe="",Xpathclosehelp="",XpathSendEmail="",IDOverride="",
			IDDeactivate="",titleOFAChelp="",xpathhelpclose="",xpathchkShwInactiveCust="",xpathSendEmail="",xpathDeactivate="",xpathOverride="";*/
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	
	// Page objects 
	
	@FindBy(linkText="Suppliers")
	private WebElement LinkSuppliers;
	
	@FindBy(linkText="OFAC")
	private WebElement LinkOFAC ;
	
	@FindBy(linkText="What is OFAC SDN?")
	private WebElement LinkOFACSDN ;
	
	@FindBy(linkText="Help")
	private WebElement linkHelp;
	
	@FindBy(linkText="What is OFAC SDN?")
	private WebElement linkOFACSDN;
	
	private String TitleOFACPage = "Lavante SIM - OFAC";	
	private String titleOFAChelp = "Details of OFAC SDN Screening ";
	
	@FindBy(xpath="//form[@id='supplierofacsdnForm']/table/tbody/tr/td/div/div[1]/table/tbody/tr/td[1]")
	private WebElement XpathDetailsOFAC;
	
	@FindBy(xpath="//div[@class='deactivate-supplier float_right']/label")
	private WebElement XpathTxtInactiveCust;
	
	@FindBy(xpath="//table[@id='supplier_ofacsdn']/caption/div/div[@class='float_right']")	
	WebElement XpathOFACMatchRun ;
	
	@FindBy(xpath="/html/body/div[10]/iframe")	
	WebElement Xpathhelpframe;
	
	@FindBy(xpath="/html/body/div[11]/div[1]/button")	
	WebElement Xpathclosehelp;
	
	@FindBy(xpath="//form[@id='supplierofacsdnForm']/div/button[@class='button_gold open_popup']")
	WebElement XpathSendEmail;
	
	@FindBy(xpath="/html/body/div[11]/div[1]/button")
	WebElement xpathhelpclose;
	
	@FindBy(xpath="//div[@class='deactivate-supplier float_right']/label[@class='show-deactivate']")
	WebElement xpathchkShwInactiveCust;
	
	@FindBy(xpath="//form[@id='supplierofacsdnForm']/div/button[@class='button_gold open_popup']")
	WebElement xpathSendEmail;
	
	@FindBy(id="Deactivated")
	WebElement xpathDeactivate;
	
	@FindBy(xpath="ofacOverride")
	WebElement xpathOverride;
	
	@FindBy(id="searchFilter")
	WebElement IDSearchEdit;
	
	@FindBy(id="supplierSearchOFAC")
	WebElement IDSearchBtn;
	
	@FindBy(id="All")
	WebElement IDAll;
	
	@FindBy(id="Awaiting Check")
	WebElement IDAwaitingCheck;
	
	@FindBy(id="No Match")
	WebElement IDNoMatch;
	
	
	@FindBy(id="Requires Disposition")
	WebElement IDRequiresDisposition;
	
	@FindBy(id="Overridden")
	WebElement IDOverridden;
	
	@FindBy(id="Deactivated")
	WebElement IDDeactivated;
	
	@FindBy(id="showDeactivatedSuppliers")
	WebElement IDChkInactiveCust;
	
	@FindBy(id="ofacOverride")
	WebElement IDOverride;
	
	@FindBy(id="Deactivated")
	WebElement IDDeactivate;
	

	public OFACPage(WebDriver driver) {
		try{
/*			//initialize properties
			props=lavanteUtils.getPropertiesValues(ConfigPathFile.OFACValidationsPropsFile.getConstantValue());

			//Links
			LinkSuppliers=props.getProperty("Suppliers");
			LinkOFAC=props.getProperty("OFAC");
			LinkOFACSDN=props.getProperty("OFAC_SDN");
			linkHelp=props.getProperty("OFAChelp");  
			linkOFACSDN=props.getProperty("OFACSDN");

			//Text
			TitleOFACPage=props.getProperty("pagetitle");
			titleOFAChelp=props.getProperty("DetailsOFAC");

			//XPATH
			XpathDetailsOFAC=props.getProperty("detailsText");
			XpathTxtInactiveCust=props.getProperty("inactiveCustomersTxt");
			XpathOFACMatchRun=props.getProperty("OFACTxt");
			Xpathhelpframe=props.getProperty("helpFrame");
			Xpathclosehelp=props.getProperty("helpFrameClose");
			XpathSendEmail=props.getProperty("sendEmailBtn");
			xpathhelpclose=props.getProperty("helpClose");
			xpathchkShwInactiveCust=props.getProperty("chkshwInactivecust");
			xpathSendEmail=props.getProperty("SendEmail");
			xpathDeactivate=props.getProperty("Deactivate");
			xpathOverride=props.getProperty("Override");

			//IDs
			IDSearchEdit=props.getProperty("searchEditBx");
			IDSearchBtn=props.getProperty("searchBtn");
			IDAll=props.getProperty("radioAll");
			IDAwaitingCheck=props.getProperty("radioAwaitingCheck");
			IDNoMatch=props.getProperty("radioNoMatch");
			IDRequiresDisposition=props.getProperty("radioRequiresDisposition");
			IDOverridden=props.getProperty("radioOverridden");
			IDDeactivated=props.getProperty("radioDeactivated");
			IDChkInactiveCust=props.getProperty("chkInactiveCustomers");
			IDOverride=props.getProperty("OverrideBtn");
			IDDeactivate=props.getProperty("DeactivateBtn");*/

			this.driver=driver;
		}catch(Exception e){
			//Reporter.log("Value fetching from properties file failed: "+e.getLocalizedMessage());
			//log.severe("Failed to get the properties from the properties file");
		}
	}

	/**
	 * Method: to navigate to OFAC page
	 * @param: none
	 * @return: none
	 */

	public void navigatetoOFACPage(){
		try {
			lavanteUtils.click("LinkSuppliers",LinkSuppliers);
			Reporter.log("Clicked on the Supplier Link Tab Successfully");
			lavanteUtils.waitForTime(3000);
			lavanteUtils.click("LinkOFAC",LinkOFAC);
			Reporter.log(" Clicked on the OFAC Link Sub Tab Successfully");
			lavanteUtils.assertPageTitle(TitleOFACPage);
			Reporter.log(" Successfully loaded the OFAC page");
		}catch(Exception e) {
			//log.severe(" Exception in the method validateLegalIDStatus due to "+e.getMessage());
			//gp.assertFailure(driver, "Failed in navigating to OFAC page", ""+e.getMessage());
					
		}
	}



	/**
	 * Method: to validate page links and text for OFAC
	 * @param: List<TestData>
	 * @return: none
	 */

	public boolean verifyLinks(){
		boolean ret=false;
		try{
			//help link verification
			lavanteUtils.verifyElementDisplayed("linkHelp", linkHelp);
			Reporter.log("The link |help| is present on the page ");
			//gp.clicks(driver, ConfigPathFile.LINKTEXT.getConstantValue(), linkHelp);
			//Reporter.log("The link |help| is present on the page ");
			/*if(switchToFrameBy(driver, Xpathhelpframe, ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue())==true){
		Reporter.log("Popup that appears after clicking on help is verified ");
		}
		switchToFrameBy(driver, "", "", "");*/
			//gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), xpathhelpclose);

			//What is OFAC SDN? link
			lavanteUtils.verifyElementDisplayed("linkOFACSDN",linkOFACSDN);
			Reporter.log("The link |What is OFAC SDN?| is verified ");
			//gp.clicks(driver, ConfigPathFile.LINKTEXT.getConstantValue(), linkOFACSDN);
			//handleFirstChildWindow(driver, true);
			//handleFirstChildWindow(driver, false);
			//verifying the text OFAC SDN screening
			/*if(gp.getText(driver, ConfigPathFile.XPATH.getConstantValue(), XpathDetailsOFAC).contains(titleOFAChelp))
			Reporter.log("The text |Details of OFAC SDN Screening| is displayed on the webpage ");*/
			//verify Show inactive suppliers link
			lavanteUtils.verifyElementDisplayed("xpathchkShwInactiveCust", xpathchkShwInactiveCust);
			Reporter.log("The text |Show Inactive suppliers| is verified ");
			//verifying text Match last run text with today's date
			lavanteUtils.verifyElementDisplayed("XpathOFACMatchRun", XpathOFACMatchRun);
			String str_text=lavanteUtils.getText("XpathOFACMatchRun", XpathOFACMatchRun);
			if(str_text.contains("OFAC Match Last Run on:")){
				Reporter.log("The text |OFAC Match Last Run on:| is verified on the webpage ");
			}
			ret=true;
		}catch(Exception e){
			//log.severe("The verification of the links and text on the OFAC page failed due to the reason : "+e.getLocalizedMessage());
			//Reporter.log("The verification for the links failed due to "+e.getCause());
			//gp.assertFailure(driver, "Failure to verify the links", " due to  : "+e.getCause());
		}
		return ret;
	}

	/**
	 * Method: to validate page controls for OFAC
	 * @param: List<TestData> for the elements
	 * @return: boolean 
	 */

	public boolean verifyControls(setTestData objOFACelements){
		boolean ret=false;
		try{
			lavanteUtils.verifyElementDisplayed("IDChkInactiveCust", IDChkInactiveCust);
			Reporter.log("The checkbox for |Show inactive suppliers| is verified ");
			lavanteUtils.verifyElementDisplayed("IDSearchEdit", IDSearchEdit);
			Reporter.log(" The |search edit box| is verified");
			lavanteUtils.verifyElementDisplayed("IDSearchBtn", IDSearchBtn);
			Reporter.log(" The |search| button is verified|");
			lavanteUtils.verifyElementDisplayed("IDAll", IDAll);
			Reporter.log(" Radio button |All| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("IDAwaitingCheck", IDAwaitingCheck);
			Reporter.log(" Radio button |Awaiting Check| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("IDNoMatch", IDNoMatch);
			Reporter.log(" Radio button |No Match| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("IDRequiresDisposition", IDRequiresDisposition);
			Reporter.log(" Radio button |Requires Disposition| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("IDOverridden", IDOverridden);
			Reporter.log(" Radio button |Overridden| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("IDDeactivated", IDDeactivated);
			Reporter.log(" Radio button |Deactivated| is verified on the webpage");
			String btns = objOFACelements.getButtonValidations().toString();
			String[] split_btns = btns.split(",");
			List<String> list_btns = new ArrayList<String>(
					Arrays.asList(split_btns));
			for (int j = 0; j < list_btns.size(); j++) {	
				verifyButtons(clickOnRadioOFAC(list_btns.get(j)));
			}
			ret=true;
		}catch(Exception e){
			//Reporter.log("Error in the validation on the controls available on the OFAC page due to: "+e.getCause());
			//log.severe("Error while verifying the controls on the OFAC page due to :"+e.getMessage());
			//gp.assertFailure(driver,"Failed due to failure to check the controls on the page"," due to : "+e.getCause());
		}
		return ret;
	}


	/**
	 * Method: To verify the buttons that appear on the OFAC page
	 * @param: List<String> containing the list of the buttons for corresponding radio buttons
	 * @return: boolean
	 */
	public boolean verifyButtons(List<String> list_button){
		boolean bool_verify=false;
		try{
			for(int i=0; i<list_button.size();i++){
				switch(list_button.get(i)){
				case "Send Email":
					if(lavanteUtils.verifyElementDisplayed("xpathSendEmail",xpathSendEmail)){
						Reporter.log(" The button |Send Email| is present on the webpage");
						bool_verify=true;
					}
					else{
						Reporter.log(" The button |Send Email| is not present on the webpage");
						lavanteUtils.takeScreenshot(driver, "send email btn not present");
					}
					break;
				case "Deactivate":
					if(lavanteUtils.verifyElementDisplayed("xpathDeactivate",xpathDeactivate)){
						Reporter.log(" The button |Deactivate| is present on the webpage");
						bool_verify=true;
					}
					else{
						Reporter.log(" The button |Deactivate| is not present on the webpage");
						lavanteUtils.takeScreenshot(driver, "Deactivate btn not present");
					}
					break;
				case "Override":
					if(lavanteUtils.verifyElementDisplayed("xpathOverride",xpathOverride)){
						Reporter.log(" The button |Override| is present on the webpage");
						bool_verify=true;
					}
					else{
						Reporter.log(" The button |Override| is not present on the webpage");
						lavanteUtils.takeScreenshot(driver, "Override btn not present");
					}
					break;
				default:
					Reporter.log(" The button mentioned is not present in the list. Please verify the data passed in the data sheet");
					//log.info(" The data passed to the method verifyButtons is improper");
					Assert.assertTrue(false,"The button value passed is null");
				}
			}
		}catch(Exception e){
			//Reporter.log("Failure to gp.clicks on radio buttons due to  : "+e.getMessage());
			//log.severe("Failed to gp.clicks on the radio buttons due to  : "+e.getMessage());
			//gp.assertFailure(driver, "Failed due to ", ""+e.getCause());
		}
		return bool_verify;
	}

	/**
	 * Method: to navigate to OFAC page
	 * @param: String the name of the radio button to be clicked
	 * @return: List<String> lists of the button which appear when the radio button is clicked
	 */

	public List<String> clickOnRadioOFAC(String str_optionradiobtn) {

		List<String> list_btn=new ArrayList<String>();
		list_btn.clear();
		try{
			switch (str_optionradiobtn) {
			case "All":
				lavanteUtils.click("IDAll", IDAll);
				Reporter.log("clicked on radio button |All|");
				list_btn.add("Send Email");
				break;
			case "Awaiting Check":
				lavanteUtils.click("IDAwaitingCheck",IDAwaitingCheck);
				Reporter.log("clicked on radio button |Awaiting Check|");
				list_btn.add("Send Email");
				break;
			case "No Match":
				lavanteUtils.click("IDNoMatch", IDNoMatch);
				Reporter.log("clicked on radio button |No Match|");
				list_btn.add("Send Email");
				break;
			case "Requires Disposition":
				lavanteUtils.click(driver.findElement(By.id( "Requires Disposition")));
				Reporter.log(" clicked on radio button |Requires Disposition|");
				list_btn.add("Send Email");
				list_btn.add("Deactivate");
				list_btn.add("Override");
				break;
			case "Overridden":
				lavanteUtils.click("IDOverridden", IDOverridden);
				Reporter.log(" clicked on radio button |Overridden|");
				list_btn.add("Send Email");
				list_btn.add("Deactivate");
				break;
			case "Deactivated":
				lavanteUtils.click("IDDeactivated", IDDeactivated);
				Reporter.log(" clicked on radio button |Deactivated|");
				list_btn.add("Send Email");
				break;
			default:
				Assert.assertTrue(false,"The Radio Button mentioned in the data is not present on the OFAC page");
				list_btn.add("null");
				break;
			}
			lavanteUtils.waitForTime(3000);
		}catch(Exception e){
			//log.severe("Radio button gp.clicks failure for the : "+str_optionradiobtn+" radio button in the OFAC Page");
			//gp.assertFailure(driver, "Radio Button was supposed to be clicked. ", "Radio button not clicked");
		}
		return list_btn;

	}

	public boolean verifyRecordsCount(List<setTestData> objTDForOFACDBQuery) {
		lavanteUtils.waitForTime(2500);
		String strExpValue="",strActValue="";
		int actRecordsCount=0,expRecordCount=0;
		boolean bool_match=false;
		try {
			for (int i = 0; i < objTDForOFACDBQuery.size(); i++) {
				lavanteUtils.waitForTime(3500);
				clickOnRadioOFAC(objTDForOFACDBQuery.get(i).getCountRadio().toString());
				if(objTDForOFACDBQuery.get(i).getKeyValue().toString().equalsIgnoreCase("yes")){
					//lavanteUtils.select_RadioBtn(driver, ConfigPathFile.ID.getConstantValue(), IDChkInactiveCust);
					Reporter.log("Successfully checked 'Show Inactive Supplier ' check box ");
					lavanteUtils.waitForTime(3500);
				}else{
					lavanteUtils.verifyElementDisplayed("IDChkInactiveCust", IDChkInactiveCust);
					if (IDChkInactiveCust.isSelected()) {
						IDChkInactiveCust.click();
						Reporter.log("Successfully Un-checked 'Show Inactive Supplier ' check box ");
					}
					lavanteUtils.waitForTime(3500);
				}
				//add the compare method
				strExpValue=dBconnect(objTDForOFACDBQuery.get(i).getDbquery().toString());
				strActValue=getRecordsCount();
				expRecordCount=lavanteUtils.convertStringToNbr(strExpValue);
				actRecordsCount=lavanteUtils.convertStringToNbr(strActValue);
				if (expRecordCount==actRecordsCount) {
					Reporter.log("\n");
					Reporter.log("The expected database query result { "+expRecordCount+" } is matched with the actual result of the application { "+actRecordsCount+" }for the selected radio button "+objTDForOFACDBQuery.get(i).getCountRadio().toString());
					//log.info("DB count results matched on the OFAC page");
					bool_match=true;
				} else {
					bool_match=false;
					Reporter.log("The expected database query result { "+expRecordCount+" } is  not matched with the actual result of the application { "+actRecordsCount+" }for the selected radio button "+objTDForOFACDBQuery.get(i).getCountRadio().toString());
					break;
				}


			}
		} catch (Exception e) {
			//e.printStackTrace();
			//Reporter.log("Failed to verify the webpage result with the database results due to : "+e.getMessage());
			//log.severe("Failure in verifying the webpage results against the database results ");
			//gp.assertFailure(driver, "Failed in verifying the webpage results against the database results due to:  ", ""+e.getCause());
		}
		return bool_match;

	}




	/**
	 * Method: To get the count of the records of the suppliers from the main page 
	 * @param: none 
	 * @return: String value giving the count of the records of the suppliers present in the web page
	 */
	public String getRecordsCount() {
		String retstr_Count = "";
		String Count = "";
		try{
			Count = lavanteUtils.getText(driver.findElement(By.className("highlight_green")));
			//gets the count from the web page and removes the brackets to get the complete number only
			Count = Count.replace("(", "");
			Count = Count.replace(")", "");
			Count = Count.replace(" ", "");
			retstr_Count = Count;
		}catch(Exception e){
			//Reporter.log("Failed to get the record count due to : "+e.getMessage());
			//log.severe("FAiled to get the record count from the application");
			//Assert.assertTrue(false,"Failed to get the count from the application due to : "+e.getMessage());
		}
		return retstr_Count;
	}

	public List<String> sortDataforTest(String str_data){

		String[] split_btns = str_data.split(",");// separate the button names in excel by a
		// comma in between
		List<String> list_btns = new ArrayList<String>(
				Arrays.asList(split_btns));
		return list_btns;
	}


	public String dBconnect(String test_query){
		String str_result="";
		try{
			
				/*while(res_query.next()){
					lst.add(res_query.getString(i++));
				}*/
				str_result=lavanteUtils.fetchDBdata(test_query);
			
		}catch(Exception e)
		{
			//log.severe("DB query execution error due to :"+e.getMessage());
			Assert.assertTrue(false,"DB query execution error");
		}
		

		return str_result;
	}



	/**
	 * Method: dbValueOFAC
	 * Purpose: This method returns the result of the query  executed
	 * @param: query to be executed
	 * @return: String value of the count
	 */
	public String dbValueOFAC(String test_query) {
		String str_cnt="";
		try {
			/*res_query = lavanteUtils.DBResultSet(lavanteUtils.ConnectToDB(), test_query);
			while (res_query.next()) {
				cnt.add(res_query.getString("columnname"));
			}
			//takes count of the data base records
			int_cnt=cnt.size();
			//converts that value to string
			str_cnt=String.valueOf(int_cnt);*/
			str_cnt=lavanteUtils.fetchDBdata(test_query);
		} catch (Exception e) {
			//log.severe("DB query execution error due to :" + e.getCause());
			Assert.assertTrue(false, "DB query execution error");
		}
		return str_cnt;
	}

}
