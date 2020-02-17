package com.lavante.sim.customer.pageobjects.OIG;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.OFAC.OFACPage;
import com.lavante.sim.Common.Util.*;

public class OIGPage {
	OFACPage objOFACPage=null;
	String methodName = "";
	LavanteUtils lavanteUtils=new  LavanteUtils();
	Properties props=null;
	//Declare web wdOigPage
	private WebDriver wdOigPage=null;
	
	
/*	String linkSuppliers="",linkOIG="",linkHelp="",xHelpLinkPopupCloseBtn="",linkWhatOIGLEIE="",classRecordsCount=""
			,iDShowDeactivatedSuppliers="",iDDeactivated="",iDOverridden="",iDRequiresDisposition="",iDNoMatch=""
			,iDAwaitingCheck="",iDAll="",xSendMailBtn="",xDeActivatedBtn="",xOverrideBtn="",iDSearchFilter="",
			iDSupplierSearchOIG="",xPopUpOIGLEIEHeadTxt="",xInActiveSupplierBox="",xLastRunOnTxt="";*/

	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the wdOigPage
	 */
	
	// Page Objects
	
	@FindBy(id="showDeactivatedSuppliers")
	WebElement iDShowDeactivatedSuppliers;
	
	@FindBy(id="Deactivated")
	WebElement iDDeactivated;
	
	@FindBy(id="Overridden")
	WebElement iDOverridden;
	
	@FindBy(id="Requires Disposition")
	WebElement iDRequiresDisposition;
	
	@FindBy(id="No Match")
	WebElement iDNoMatch;
	
	@FindBy(id="Awaiting Check")
	WebElement iDAwaitingCheck;
	
	@FindBy(id="All")
	WebElement iDAll;
	
	@FindBy(id="searchFilter")
	WebElement iDSearchFilter;
	
	@FindBy(id="supplierSearchOIG")
	WebElement iDSupplierSearchOIG;
	
	@FindBy(linkText="Suppliers")
	WebElement linkSuppliers;
	
	@FindBy(linkText="OIG")
	WebElement linkOIG;
	
	@FindBy(linkText="Help")
	WebElement linkHelp;
	
	@FindBy(linkText="What is OIG LEIE?")
	WebElement linkWhatOIGLEIE;
	
	@FindBy(xpath="/html/body/div[10]/div[1]/button")
	WebElement xHelpLinkPopupCloseBtn;
	
	@FindBy(xpath="//button[@class='button_gold open_popup']")
	WebElement xSendMailBtn;
	
	@FindBy(xpath="//input[@class='button_red open_popup']")
	WebElement xDeActivatedBtn;
	
	@FindBy(xpath="//input[@class='button_green open_popup']")
	WebElement xOverrideBtn;
	
	@FindBy(xpath="//form[@id='supplieroigForm']/table/tbody/tr/td/div/div[1]/table/tbody/tr/td[1]")
	WebElement xPopUpOIGLEIEHeadTxt;
	
	@FindBy(xpath="//label[@class='show-deactivate']")
	WebElement xInActiveSupplierBox;
	
	@FindBy(id="//table[@id='supplier_oig']/caption/div/div[@class='float_right']")
	WebElement xLastRunOnTxt;
	
	@FindBy(css="highlight_green")
	WebElement classRecordsCount;

	public OIGPage (WebDriver driver) {
		this.wdOigPage=driver;
	}

	/**
	 * Method: to navigate to OIG page
	 * @param: none
	 * @return: none
	 */
	public void navigatetoOIGPage(){
		try {
			lavanteUtils.click("linkSuppliers",linkSuppliers);
			Reporter.log("Clicked on the Supplier Link Tab Successfully");
			lavanteUtils.click("linkOIG",linkOIG);
			Reporter.log("Clicked on the OIG Link Sub Tab Successfully");
			if(lavanteUtils.assertPageTitle(""))
				Reporter.log("Successfully loaded the OIG page");
			else
				lavanteUtils.takeScreenshot(wdOigPage, "Navigation to OIG page");
		}catch(Exception e) {
			//log.severe("Exception in the method Navigate to OIG page due to "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method Navigate to OIG page due to "+e.getMessage());			
		}
	}

	/**
	 * Method: to validate page links and text for OIG
	 * @param: none 
	 * @return: boolean
	 */

	public boolean verifyLinks() {
		try{
			//help link verification
			lavanteUtils.verifyElementDisplayed("linkHelp", linkHelp);
			Reporter.log("The link |help| is present on the page");
			lavanteUtils.click("linkHelp", linkHelp);
			Reporter.log("The link |help| is present on the page");
			
			lavanteUtils.switchtoFrame(wdOigPage.findElement(By.xpath("/html/body/div[10]/iframe")));
			Reporter.log("Popup that appears after clicking on help is verified");
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click("xHelpLinkPopupCloseBtn", xHelpLinkPopupCloseBtn);

			//What is OIG LEIE? link
			lavanteUtils.verifyElementDisplayed("linkWhatOIGLEIE",linkWhatOIGLEIE);
			Reporter.log("The link |What is OIG LEIE?| is verified");
			//gp.clicks(wdOigPage,ConfigPathFile.LINKTEXT.getConstantValue(),linkWhatOIGLEIE);
			//handleFirstChildWindow(wdOigPage, true);
			//verify something
			//handleFirstChildWindow(wdOigPage, false);
			//verifying the text OIG LEIE Screening
			if(lavanteUtils.getText("xPopUpOIGLEIEHeadTxt",xPopUpOIGLEIEHeadTxt).equalsIgnoreCase("Details of OIG LEIE Screening"))
				Reporter.log("The text |Details of OIG LEIE Screening| is displayed on the webpage");
			//verify Show inactive suppliers link
			lavanteUtils.verifyElementDisplayed("xInActiveSupplierBox",xInActiveSupplierBox);
			Reporter.log("The text |Show Inactive suppliers| is verified|");
			//verifying text Match last run 
			lavanteUtils.verifyElementDisplayed("xLastRunOnTxt",xLastRunOnTxt);
			String str_text=lavanteUtils.getText("xLastRunOnTxt",xLastRunOnTxt);
			if(str_text.contains("OIG LEIE Match Last Run on:")){
				Reporter.log("The text |OIG LEIE Match Last Run on:| is verified on the webpage");
			}
		}catch(Exception e){
			//Reporter.log("Failure in verifying the links on the OIG page. "+e.getMessage());
			//log.severe("Failire in verifying the links on the OIG page due to :"+e.getCause());
		}
		return true;

	}

	/**
	 * Method: to validate page controls for OIG
	 * @param: List<TestData> for the elements
	 * @return: boolean 
	 */

	public boolean verifyControls(setTestData objOIGelements) {
		try{
			//verify check box
			lavanteUtils.verifyElementDisplayed("iDShowDeactivatedSuppliers", iDShowDeactivatedSuppliers);
			Reporter.log("The checkbox for |Show inactive suppliers| is verified");
			//verify the search edit box
			lavanteUtils.verifyElementDisplayed("iDSearchFilter",iDSearchFilter);
			Reporter.log("The |search edit box| is verified");
			//verify the search button
			lavanteUtils.verifyElementDisplayed("iDSupplierSearchOIG",iDSupplierSearchOIG);
			Reporter.log("The |search| button is verified|");
			//verify the radio buttons
			lavanteUtils.verifyElementDisplayed("iDAll",iDAll);
			Reporter.log("Radio button |All| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("iDAwaitingCheck",iDAwaitingCheck);
			Reporter.log("Radio button |Awaiting Check| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("iDNoMatch",iDNoMatch);
			Reporter.log("Radio button |No Match| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("iDRequiresDisposition", iDRequiresDisposition);
			Reporter.log("Radio button |Requires Disposition| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("iDOverridden", iDOverridden);
			Reporter.log("Radio button |Overridden| is verified on the webpage");
			lavanteUtils.verifyElementDisplayed("iDDeactivated", iDDeactivated);
			Reporter.log("Radio button |Deactivated| is verified on the webpage");
			String btns = ((setTestData) objOIGelements).getButtonValidations().toString();
			String[] split_btns = btns.split(",");// separate the button names in excel by a
			// comma in between
			List<String> list_btns = new ArrayList<String>(
					Arrays.asList(split_btns));
			for (int j = 0; j < list_btns.size(); j++) {	
				verifyButtons(clickOnRadioOFAC(list_btns.get(j)));
			}
		}catch(Exception e){
			//Reporter.log("Error in the validation on the controls available on the OFAC page due to: "+e.getCause());
			//log.severe("Error while verifying the controls on the OFAC page due to :"+e.getMessage());
		}
		return true;
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
					if(lavanteUtils.verifyElementDisplayed("xSendMailBtn",xSendMailBtn)){
						Reporter.log("The button |Send Email| is present on the webpage");
						bool_verify=true;
					}
					else{
						Reporter.log("The button |Send Email| is not present on the webpage");
						lavanteUtils.takeScreenshot(wdOigPage, "send email btn not present");
					}
					break;
				case "Deactivate":
					if(lavanteUtils.verifyElementDisplayed("xDeActivatedBtn",xDeActivatedBtn)){
						Reporter.log("The button |Deactivate| is present on the webpage");
						bool_verify=true;
					}
					else{
						Reporter.log("The button |Deactivate| is not present on the webpage");
						lavanteUtils.takeScreenshot(wdOigPage, "Deactivate btn not present");
					}
					break;
				case "Override":
					if(lavanteUtils.verifyElementDisplayed("xOverrideBtn",xOverrideBtn)){
						Reporter.log("The button |Override| is present on the webpage");
						bool_verify=true;
					}
					else{
						Reporter.log("The button |Override| is not present on the webpage");
						lavanteUtils.takeScreenshot(wdOigPage, "Override btn not present");
					}
					break;
				default:
					Reporter.log("The button mentioned is not present in the list. Please verify the data passed in the data sheet");
					//log.severe("The data passed to the method verifyButtons is improper");
					Assert.assertTrue(false,"Problem in the data passed to the method");
					break;
				}
			}
		}catch(Exception e){
			Reporter.log("Failed in verifying the buttons");
			//log.severe("Failed due to the verification failed : "+e.getMessage());
			Assert.assertTrue(false,"Failed due to the : "+e.getCause());
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
				lavanteUtils.click("iDAll", iDAll);
				list_btn.add("Send Email");
				break;
			case "Awaiting Check":
				lavanteUtils.click("iDAwaitingCheck",iDAwaitingCheck);
				list_btn.add("Send Email");
				break;
			case "No Match":
				lavanteUtils.click("iDNoMatch", iDNoMatch);
				list_btn.add("Send Email");
				break;
			case "Requires Disposition":
				lavanteUtils.click("iDRequiresDisposition",iDRequiresDisposition);
				list_btn.add("Send Email");
				list_btn.add("Deactivate");
				list_btn.add("Override");
				break;
			case "Overridden":
				lavanteUtils.click("iDOverridden", iDOverridden);
				list_btn.add("Send Email");
				list_btn.add("Deactivate");
				break;
			case "Deactivated":
				lavanteUtils.click("iDDeactivated", iDDeactivated);
				list_btn.add("Send Email");
				break;
			default:
				Assert.assertTrue(false,
						"The Radio Button mentioned in the data is not present on the OFAC page");
				list_btn.add("null");
				break;
			}

			lavanteUtils.waitForTime(3000);

		}catch(Exception e){
			Assert.assertFalse(true, "Failed due to the exception : "+e.getCause());
			//log.severe("Radio button gp.clicks failure for the : "+str_optionradiobtn+" radio button in the OFAC Page");
		}
		return list_btn;

	}


	public boolean verifyRecordsCount(List<setTestData> objTDForOFACDBQuery) {
		objOFACPage= PageFactory.initElements(wdOigPage,OFACPage.class);
		String strExpValue="",strActValue="";
		int actRecordsCount=0,expRecordCount=0;
		boolean bool_match=false;
		try {
			for (int i = 0; i < objTDForOFACDBQuery.size(); i++) {
				clickOnRadioOFAC(objTDForOFACDBQuery.get(i).getCountRadio().toString());
				if(objTDForOFACDBQuery.get(i).getKeyValue().toString().equalsIgnoreCase("yes")){
					lavanteUtils.click( iDShowDeactivatedSuppliers);
					Reporter.log("Successfully checked 'Show Inactive Supplier ' check box ");
					lavanteUtils.waitForTime(3000);
				}else{
					//WebElement web_Element = lavanteUtils.verifyElementDisplayed("iDShowDeactivatedSuppliers",iDShowDeactivatedSuppliers);
					if (iDShowDeactivatedSuppliers.isSelected()) {
						iDShowDeactivatedSuppliers.click();
						Reporter.log("Successfully Un-checked 'Show Inactive Supplier ' check box ");
					}
					lavanteUtils.waitForTime(3000);
				}
				//add the compare method
				strExpValue=objOFACPage.dBconnect(objTDForOFACDBQuery.get(i).getDbquery().toString());
				strActValue=getRecordsCount();
				expRecordCount=lavanteUtils.convertStringToNbr(strExpValue);
				actRecordsCount=lavanteUtils.convertStringToNbr(strActValue);
				Reporter.log("\n");
				if (expRecordCount==actRecordsCount) {
					Reporter.log("The expected database query result { "+expRecordCount+" } is matched with the actual result of the application { "+actRecordsCount+" }for the selected radio button "+objTDForOFACDBQuery.get(i).getCountRadio().toString());
					//log.info("DB count results matched on the OIG page");
					bool_match=true;
				} else {
					bool_match=false;
					Reporter.log("The expected database query result { "+expRecordCount+" } is not matched with the actual result of the application { "+actRecordsCount+" }for the selected radio button "+objTDForOFACDBQuery.get(i).getCountRadio().toString());
					break;
				}


			}
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Failed to verify the webpage result with the database results due to : "+e.getMessage());
			//log.severe("Failure in verifying the webpage results against the database results ");
			Assert.assertFalse(true, "Failed due to the exception : "+e.getCause());
		}
		return bool_match;

	}

	/**
	 * Method: This method returns the result of the query  executed
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


	/**
	 * Method: To get the count of the records of the suppliers from the main page 
	 * @param: none 
	 * @return: String value giving the count of the records of the suppliers present in the web page
	 */
	public String getRecordsCount() {
		String retstr_Count = "";
		String Count = "";
		Count = lavanteUtils.getText("classRecordsCount",classRecordsCount);
		//gets the count from the web page and removes the brackets to get the complete number only
		Count = Count.replace("(", "");
		Count = Count.replace(")", "");
		Count = Count.replace(" ", "");
		retstr_Count = Count;
		return retstr_Count;
	}

	public List<String> sortDataforTest(String str_data){
		String[] split_btns = str_data.split(",");// separate the button names in excel by a
		// comma in between
		List<String> list_btns = new ArrayList<String>(Arrays.asList(split_btns));
		return list_btns;
	}

}
