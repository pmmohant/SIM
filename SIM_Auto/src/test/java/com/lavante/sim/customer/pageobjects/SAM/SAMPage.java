package com.lavante.sim.customer.pageobjects.SAM;

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

public class SAMPage {
	OFACPage objOFACPage=null;
	String methodName = "";
	Properties props=null;
	//Declare web driver
	private WebDriver driver=null;
	LavanteUtils lavanteUtils=new  LavanteUtils();
	/*
	String linkSuppliers="",linkSAM="",titleSAMpage="",linkhelp="",xpathframehelp="",xpathhelpclose="",linkwhat="",xpathdetails="",
			textdetails="",xpathshwinactive="",xpathrunon="",textrunon="",idshowinactive="",idsearchedit="",idsearchbtn="",idall="",
			idawaitingchk="",idnomatch="",idrequiresDispositon="",idoverriden="",iddeactivated="",xpathSendEmail="",xpathDeactivate="",
			xpathOverride="";*/

	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	
	// Page objects 
	
	@FindBy(linkText = "Suppliers")
	WebElement linkSuppliers;
	
	@FindBy(linkText = "SAM")
	WebElement linkSAM;
	
	@FindBy(linkText = "Help")
	WebElement  linkhelp;
	
	@FindBy(linkText = "What is SAM EPLS?")
	WebElement  linkwhat;
	
	String   titleSAMpage = "Lavante SIM - SAM";
	
	@FindBy(xpath = "/html/body/div[10]/iframe")
	WebElement  xpathframehelp;
	
	@FindBy(xpath = "/html/body/div[10]/div[1]/button")
	WebElement  xpathhelpclose;
	
	@FindBy(xpath = "//form[@id='suppliersamForm']/table/tbody/tr/td/div/div[1]/table/tbody/tr/td[1]")
	WebElement  xpathdetails;
	
	@FindBy(xpath = "//div[@class='deactivate-supplier float_right']/label[@class='show-deactivate']")
	WebElement  xpathshwinactive;
	
	@FindBy(xpath = "//table[@id='supplier_sam']/caption/div/div[@class='float_right']")
	WebElement  xpathrunon;
	
	@FindBy(xpath = "//button[@class='button_gold open_popup']")
	WebElement  xpathSendEmail;
	
	@FindBy(xpath = "//input[@class='button_red open_popup']")
	WebElement  xpathDeactivate;
	
	@FindBy(xpath = "//input[@class='button_green open_popup']")
	WebElement  xpathOverride;
	
	String  textdetails = "Details of SAM EPLS Screening";
	
	String  textrunon = "SAM EPLS Match Last Run on:";
	
	@FindBy(id = "showDeactivatedSuppliers")
	WebElement  idshowinactive;
	
	@FindBy(id = "searchFilter")
	WebElement idsearchedit;
	
	@FindBy(id = "supplierSearchSAM")
	WebElement  idsearchbtn;
	
	@FindBy(id = "All")
	WebElement  idall;
	
	@FindBy(id = "Awaiting Check")
	WebElement  idawaitingchk;
	
	@FindBy(id = "No Match")
	WebElement idnomatch;
	
	@FindBy(id = "Requires Disposition")
	WebElement  idrequiresDispositon;
	
	@FindBy(id = "Overridden")
	WebElement  idoverriden;
	
	@FindBy(id = "Deactivated")
	WebElement  iddeactivated;
	

	public SAMPage (WebDriver driver){

		this.driver=driver;
	}

	/**
	 * Method: to navigate to SAM page
	 * @param: none
	 * @return: none
	 */
	public void navigatetoSAMPage(){
		try {
			lavanteUtils.click("linkSuppliers",linkSuppliers);
			Reporter.log("Clicked on the Supplier Link Tab Successfully");
			lavanteUtils.click("linkSAM",linkSAM);
			Reporter.log("Clicked on the SAM Link Sub Tab Successfully");
			if(lavanteUtils.assertPageTitle(titleSAMpage))
				Reporter.log("Successfully loaded the SAM page");
			else
				lavanteUtils.takeScreenshot(driver, "Navigation to SAM page");
		}catch(Exception e) {
			//log.severe("Exception in the method validateLegalIDStatus due to "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateLegalIDStatus due to "+e.getMessage());			
		}
	}

	/**
	 * Method: to validate page links and text for SAM
	 * @param: none
	 * @return: boolean
	 */

	public boolean verifyLinks(){
		try{
			lavanteUtils.verifyElementDisplayed("linkhelp", linkhelp);
			Reporter.log("The link |help| is present on the page");
			lavanteUtils.click("linkhelp",linkhelp);
			Reporter.log("The link |help| is present on the page");
			if(lavanteUtils.switchtoFrame( xpathframehelp)){
				Reporter.log("Popup that appears after clicking on |help| is verified");
			}
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click("xpathhelpclose", xpathhelpclose);
			lavanteUtils.verifyElementDisplayed("linkwhat",linkwhat);
			Reporter.log("The link |What is SAM EPLS?| is verified");
			//gp.clicks(driver, ConfigPathFile.LINKTEXT.getConstantValue(), "What is SAM EPLS?");
			//handleFirstChildWindow(driver, true);
			//handleFirstChildWindow(driver, false);
			if(lavanteUtils.getText("xpathdetails", xpathdetails).equalsIgnoreCase(textdetails))
				Reporter.log("The text |Details of SAM EPLS Screening| is displayed on the webpage");

			lavanteUtils.verifyElementDisplayed("xpathshwinactive", xpathshwinactive);
			Reporter.log("The text |Show Inactive suppliers| is verified|");

			lavanteUtils.verifyElementDisplayed("xpathrunon", xpathrunon);
			String str_text=lavanteUtils.getText("xpathrunon",xpathrunon);
			if(str_text.contains(textrunon)){
				Reporter.log("The text |"+textrunon+"| is verified on the webpage");

			}

		}catch(Exception e)
		{
			/*e.printStackTrace();
			gp.assertFailure(driver, "Failed to verify : ", ""+e.getCause());*/
			//log.severe("Failed due to : "+e.getMessage());
		}
		return true;
	}

	/**
	 * Method: to validate page controls for SAM
	 * @param: List<TestData> for the elements
	 * @return: boolean 
	 */

	public boolean verifyControls(setTestData objSAMelements){
		try{

			lavanteUtils.verifyElementDisplayed("idshowinactive", idshowinactive);
			lavanteUtils.verifyElementDisplayed("idsearchedit", idsearchedit);
			lavanteUtils.verifyElementDisplayed("idsearchbtn", idsearchbtn);
			lavanteUtils.verifyElementDisplayed("idall", idall);
			lavanteUtils.verifyElementDisplayed("idawaitingchk", idawaitingchk);
			lavanteUtils.verifyElementDisplayed("idnomatch", idnomatch);
			lavanteUtils.verifyElementDisplayed("idrequiresDispositon", idrequiresDispositon);
			lavanteUtils.verifyElementDisplayed("idoverriden", idoverriden);
			lavanteUtils.verifyElementDisplayed("iddeactivated", iddeactivated);

			String btns = ((setTestData) objSAMelements).getButtonValidations().toString();
			String[] split_btns = btns.split(",");// separate the button names in excel by a
			// comma in between
			List<String> list_btns = new ArrayList<String>(
					Arrays.asList(split_btns));
			for (int j = 0; j < list_btns.size(); j++) {	
				System.out.println(list_btns.get(j)+" in  "+j);
				verifyButtons(clickOnRadioSAM(list_btns.get(j)));
			}

		}catch(Exception e){
			//Reporter.log("Error in the validation on the controls available on the SAM page due to: "+e.getCause());
			//log.severe("Error while verifying the controls on the SAM page due to :"+e.getMessage());
		}
		return true;
	}

	/**
	 * Method: To verify the buttons that appear on the SAM page
	 * @param: List<String> containing the list of the buttons for corresponding radio buttons
	 * @return: boolean
	 */
	public boolean verifyButtons(List<String> list_button){
		boolean bool_verify=false;
		for(int i=0; i<list_button.size();i++){
			switch(list_button.get(i)){
			case "Send Email":
				if(lavanteUtils.verifyElementDisplayed("xpathSendEmail",xpathSendEmail)){
					bool_verify=true;
				}
				else{
					lavanteUtils.takeScreenshot(driver, "send mail btn not present");
				}
				break;
			case "Deactivate":
				if(lavanteUtils.verifyElementDisplayed("xpathDeactivate",xpathDeactivate)){
					Reporter.log("The button |Deactivate| is present on the webpage");
					bool_verify=true;
				}
				else{
					Reporter.log("The button |Deactivate| is not present on the webpage");
					lavanteUtils.takeScreenshot(driver, "Deactivate btn not present");
				}
				break;
			case "Override":
				if(lavanteUtils.verifyElementDisplayed("xpathOverride",xpathOverride)){
					Reporter.log("The button |Override| is present on the webpage");
					bool_verify=true;
				}
				else{
					Reporter.log("The button |Override| is not present on the webpage");
					lavanteUtils.takeScreenshot(driver, "Override btn not present");
				}
				break;

			default:
				Reporter.log("The button mentioned is not present in the list. Please verify the data passed in the data sheet");
				//log.info("The data passed to the method verifyButtons is improper");
				Assert.assertTrue(false,"Button String passed in the method is not available");
				break;
			}
		}
		return bool_verify;
	}

	/**
	 * Method: to navigate to SAM page
	 * @param: String the name of the radio button to be clicked
	 * @return: List<String> lists of the button which appear when the radio button is clicked
	 */

	public List<String> clickOnRadioSAM(String str_optionradiobtn) {
		List<String> list_btn=new ArrayList<String>();
		try{
			switch (str_optionradiobtn) {
			case "All":
				lavanteUtils.click("idall", idall);
				list_btn.add("Send Email");
				break;
			case "Awaiting Check":
				lavanteUtils.click("idawaitingchk",idawaitingchk);
				list_btn.add("Send Email");
				break;
			case "No Match":
				lavanteUtils.click("idnomatch", idnomatch);
				list_btn.add("Send Email");
				break;
			case "Requires Disposition":
				lavanteUtils.click("idrequiresDispositon",idrequiresDispositon);
				list_btn.add("Send Email");
				list_btn.add("Deactivate");
				list_btn.add("Override");
				break;
			case "Overridden":
				lavanteUtils.click("idoverriden", idoverriden);
				list_btn.add("Send Email");
				list_btn.add("Deactivate");
				break;
			case "Deactivated":
				lavanteUtils.click("iddeactivated", iddeactivated);
				list_btn.add("Send Email");
				break;
			}
		}catch(Exception e){
			Assert.assertFalse(true, "Failed due to the exception : "+e.getCause());
			//log.severe("Radio button gp.clicks failure for the : "+str_optionradiobtn+" radio button in the SAM Page");
		}
		return list_btn;

	}

	public boolean verifyRecordsCount(List<setTestData> objTDForOFACDBQuery) {
		objOFACPage= PageFactory.initElements(driver,OFACPage.class);
		String strExpValue="",strActValue="";
		int actRecordsCount=0,expRecordCount=0;
		boolean bool_match=false;
		try {
			for (int i = 0; i < objTDForOFACDBQuery.size(); i++) {
				objOFACPage.clickOnRadioOFAC(objTDForOFACDBQuery.get(i).getCountRadio().toString());
				if(objTDForOFACDBQuery.get(i).getKeyValue().toString().equalsIgnoreCase("yes")){
					lavanteUtils.click(idshowinactive);
					Reporter.log("Successfully checked 'Show Inactive Supplier ' check box ");
					lavanteUtils.waitForTime(3000);
				}else{
					//WebElement web_Element = lavanteUtils.verifyElementDisplayed("idshowinactive",idshowinactive);
					if (idshowinactive.isSelected()) {
						idshowinactive.click();
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
	public String dbValueSAM(String test_query) {
		List<String> cnt = new ArrayList<String>();
		int int_cnt=0;
		String str_cnt="";
		ResultSet res_query = null;
		try {
			/*res_query = lavanteUtils.DBResultSet(lavanteUtils.ConnectToDB(), test_query);
			while (res_query.next()) {
				cnt.add(res_query.getString("columnname"));
			}
			//takes count of the data base records
			int_cnt=cnt.size();
			//converts that value to string
*/			str_cnt=lavanteUtils
		.fetchDBdata(test_query);
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
		Count = lavanteUtils.getText(driver.findElement(By.className(
				"highlight_green")));
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
		List<String> list_btns = new ArrayList<String>(
				Arrays.asList(split_btns));
		return list_btns;
	}

}
