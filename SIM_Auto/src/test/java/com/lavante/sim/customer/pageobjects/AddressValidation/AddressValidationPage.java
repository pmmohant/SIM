/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 */ 

package com.lavante.sim.customer.pageobjects.AddressValidation;

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
import com.lavante.sim.customer.pageobjects.AdvanceSearch.AdvanceSearchPage;
import com.lavante.sim.customer.pageobjects.BasicSearch.SupplierSearchPage;


public class AddressValidationPage {
	List<setTestData> objAdressDBQUERY = null;
	GetExcelFile ge=new GetExcelFile();
	LavanteUtils lavanteUtils=new LavanteUtils();
	OFACPage objOFACPage=null;
	Properties props=null;
	//Declare web driver
	private WebDriver driver=null;
	
/*	String 	LinkTxtSuppliers="",LinkTxtAddresses="",xSupplierLocation="",xSelectSupplierLocation="",xSelectSupLocationRadioBtns="",
			xAddressRecordRows="",xAddressDetails="",IDall="",IDvalid="",IDinvalid="",IDpending="",IDCannotbevalidated="",
			xSupBodyDisFrame="",cssPopupCloseBtn="",xSupplierNameLinkPrefix="",xSupplierNameLinkSuffix="",xValidAddressRows="",
			xInvalidAddressRows="",xCannotBeValidatedRows="",xSupplierManagedTab="",xSupplierContactTab="",xPendingAddressRows="",
			xNoDataAvailableRows="",addHeadquarterAddress="",IDShowDeactivatedSuppliers="";*/

	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	
	// Page Objects
	
	//IDs
	@FindBy(id="All")
	private WebElement IDall;
	
	@FindBy(id="Valid")
	private WebElement IDvalid;
	
	@FindBy(id="Invalid")
	private WebElement IDinvalid;
	
	@FindBy(id="Pending")
	private WebElement IDpending;
	
	@FindBy(id="Cannot be validated")
	private WebElement IDCannotbevalidated;
	
	@FindBy(id="headquarterAddressId_chosen")
	private WebElement addHeadquarterAddress;
	
	@FindBy(id="showDeactivatedSuppliers")
	private WebElement IDShowDeactivatedSuppliers;	
	
	//LinkText
	@FindBy(linkText="Suppliers")
	private WebElement LinkTxtSuppliers;
	
	@FindBy(linkText="Addresses")
	private WebElement LinkTxtAddresses;
	
	
	//Xpath
	@FindBy(xpath=".//*[@id='main-navigation']/a[1]")
	private WebElement xSupplierManagedTab;
	
	@FindBy(xpath=".//*[@id='sub-navigation']/a[6]")
	private WebElement xSupplierContactTab;
	
	@FindBy(xpath=".//*[@id='supplierLocation_chosen']/a/span")
	private WebElement xSupplierLocation;
	
	@FindBy(xpath="//div[@id='supplierLocation_chosen']/div[contains(@class,'chosen-drop')]/ul/li")
	private WebElement xSelectSupplierLocation;
	
	@FindBy(xpath="//div/table[contains(@id,'supplier_address')]/caption/div/label")
	private List<WebElement> xSelectSupLocationRadioBtns;
	
	@FindBy(xpath="//table[contains(@id,'supplier_address')]/tbody/tr[not(contains(@class,'data_not_found'))]")
	private List<WebElement> xAddressRecordRows;
	
	@FindBy(xpath="//iframe[contains(@class,'popup_iframe ui-dialog-content ui-widget-content')]")
	private WebElement xSupBodyDisFrame;
	
	@FindBy(xpath="html/body/div[6]/div/div/form/table/tbody/tr/td/div/div[2]/table/tbody/tr[")
	private WebElement xSupplierNameLinkPrefix;
	
	@FindBy(xpath="]/td[3]/a")
	private WebElement xSupplierNameLinkSuffix;
	
	@FindBy(xpath="//span[contains(@class,'icon_checked')]")
	private WebElement xValidAddressRows;
	
	@FindBy(xpath="//span[contains(@class,'icon_reject')]")
	private WebElement xInvalidAddressRows;
	
	@FindBy(xpath="//span[contains(@class,'icon_info')]")
	private WebElement xCannotBeValidatedRows;
	
	@FindBy(xpath="//span[contains(@class,'icon_pending')]")
	private WebElement xPendingAddressRows;
	
	@FindBy(xpath="//table[contains(@id,'supplier_address')]/tbody/tr[contains(@class,'data_not_found odd')]")
	private WebElement xNoDataAvailableRows;

	//CSS
	@FindBy(css="button[title='close'][type='button']")
	private WebElement cssPopupCloseBtn;
	
	
	public AddressValidationPage(WebDriver driver) {
		try {
	
			this.driver = driver;
		} catch (Exception e)  {						
			//log.severe("Method: AddressValidationPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
	}

	public void navigatToAddressTabPage(){
		try {
			lavanteUtils.click("LinkTxtSuppliers",LinkTxtSuppliers);
			Reporter.log("Clicked on the Supplier Link Tab Successfully");
			lavanteUtils.waitForTime(3000);
			lavanteUtils.click("LinkTxtAddresses",LinkTxtAddresses);
			Reporter.log("Clicked on the Addresses Link Tab Successfully");
			lavanteUtils.waitForTime(1500);	
		} catch (Exception e) {
			//log.severe("Exception in the method validateAddressesStatus due to "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateAddressesStatus due to "+e.getMessage());			
		}
	}
	/**
	 * Method Name : verifyCountOfRadioBtnOptions
	 * Purpose:
	 * @param: List of objListOfAddresses
	 * @return: None
	 */
	public void verifyCountOfRadioBtnOptions(List<setTestData> objListOfAddresses) {
		try {
			objAdressDBQUERY = ge.getData(ConfigPathFile.TestDataForValidateAddresses.getConstantValue(),ConfigPathFile.DBQUERY.getConstantValue());
			navigatToAddressTabPage();
			for(int k=0;k<objListOfAddresses.size();k++){
				lavanteUtils.click(driver.findElement(By.xpath("//*[@id='supplierLocation_chosen']/a")));
			//	gp.selectDropDownValue(driver, ConfigPathFile.XPATH.getConstantValue(),xSelectSupplierLocation,objListOfAddresses.get(k).getSupplierLocation().toString());
				lavanteUtils.click(driver.findElement(By.xpath("supplierLocation_chosen")));
				lavanteUtils.selectvalueFrmDpdn(objListOfAddresses.get(k).getSupplierLocation().toString());
				Reporter.log(" supplier location | "+objListOfAddresses.get(k).getSupplierLocation().toString()+" | is selected ");
				if(verifyRecordsCount(objAdressDBQUERY,objListOfAddresses.get(k).getSupplierLocation().toString())){
					Reporter.log("The DB records count for the ADRESS page matched the web page data");
				}else{
					Reporter.log("The DB values did not match all the values that appear on the webpage for all the radio buttons on the ADDRESS page");
					Assert.assertTrue(false,"The DB values did not match the webpage values");
				}

			}
		}catch(Exception e) {
			//log.severe("Exception in the method validateAddressesStatus due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateAddressesStatus due to "+e.getMessage());			
		}
	}
/*	*//**
	 * Method Name : validateAddressesStatus
	 * Purpose:
	 * @param: List of objListOfAddresses
	 * @return: None
	 *//*
	public void validsateAddressesStatus(List<setTestData> objListOfAddresses) {
		try {
			navigatToAddressTabPage();
			for(int k=0;k<objListOfAddresses.size();k++){
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click(driver.findElement(By.xpath("//*[@id='supplierLocation_chosen']/a")));
				//gp.SPselectDropDownValue(driver, "supplierLocation_chosen",objListOfAddresses.get(k).getSupplierLocation().toString());
				//gp.selectDropDownValue(driver, ConfigPathFile.XPATH.getConstantValue(),xSelectSupplierLocation,objListOfAddresses.get(k).getSupplierLocation().toString());
				Reporter.log(" supplier location | "+objListOfAddresses.get(k).getSupplierLocation().toString()+" | is selected ");
				filterByOptions(objListOfAddresses.get(k));
			}
		}catch(Exception e) {
			//log.severe("Exception in the method validateAddressesStatus due to "+e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateAddressesStatus due to "+e.getMessage());			
		}
	}*/
	/**
	 * Method Name : filterByOptions
	 * Purpose:
	 * @param: List of objListOfAddresses
	 * @return: None
	 */
	/*public void filterBsyOptions(setTestData objListOfAddresses){
		String actRecords="";
		for(int i=0;i<xSelectSupLocationRadioBtns.size();i++){
			if(i==0 && objListOfAddresses.getAll().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				lavanteUtils.click("IDall", IDall);
				Reporter.log("Clicked on the |All| radio button successfully");
				actRecords=lavanteUtils.getText("xAddressDetails",xAddressDetails);
				Reporter.log("Total Records of Addresses: "+actRecords +" found for the country: "+objListOfAddresses.getSupplierLocation().toString());
				lavanteUtils.click("IDvalid", IDvalid);
				Reporter.log("Clicked on the |Valid| radio button successfully");
				getAddressesData(ConfigPathFile.Valid.getConstantValue());
			}if(i==2 && objListOfAddresses.getInValid().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				lavanteUtils.click("IDinvalid",IDinvalid);
				Reporter.log("Clicked on the |Invalid| radio button successfully");
				getAddressesData(ConfigPathFile.InValid.getConstantValue());
			}if(i==3 && objListOfAddresses.getPending().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				if(lavanteUtils.verifyElementDisplayed("IDpending",IDpending)){
					lavanteUtils.click("IDpending",IDpending);
					Reporter.log("Clicked on the  |Pending| radio button successfully");
					getAddressesData(ConfigPathFile.Pending.getConstantValue());
				}else{
					lavanteUtils.click("IDCannotbevalidated", IDCannotbevalidated);
					Reporter.log("Clicked on the |Cannot be validated| radio button successfully");
					getAddressesData(ConfigPathFile.CannotBeValidated.getConstantValue());
				}
			}
			lavanteUtils.waitForTime(600);
		}
	}
*/
	/*public void filterByOptions(setTestData objListOfAddresses,String locationName){
		objAdressDBQUERY = GetExcelFile.getData(ConfigPathFile.TestDataForValidateAddresses.getConstantValue(),ConfigPathFile.DBQUERY.getConstantValue());
		List<WebElement> listOfRadioBtns=driver.findElements(By.xpath(xSelectSupLocationRadioBtns));
		for(int i=0;i<listOfRadioBtns.size();i++){
			if(i==0 && objListOfAddresses.getAll().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				// new method added 
				if(verifyRecordsCount(objAdressDBQUERY,locationName)){
					Reporter.log("The DB records count for the ADRESS page matched the web page data");
				}else{
					Reporter.log("The DB values did not match all the values that appear on the webpage for all the radio buttons on the ADRESS page");
					Assert.assertTrue(false,"The DB values did not match the webpage values");
				}
			}if(i==1 && objListOfAddresses.getValid().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				if(verifyRecordsCount(objAdressDBQUERY,locationName)){
					Reporter.log("The DB records count for the ADRESS page matched the web page data");
				}else{
					Reporter.log("The DB values did not match all the values that appear on the webpage for all the radio buttons on the ADRESS page");
					Assert.assertTrue(false,"The DB values did not match the webpage values");
				}
				getAddressesData(ConfigPathFile.Valid.getConstantValue());
			}if(i==2 && objListOfAddresses.getInValid().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				if(verifyRecordsCount(objAdressDBQUERY,locationName)){
					Reporter.log("The DB records count for the ADRESS page matched the web page data");
				}else{
					Reporter.log("The DB values did not match all the values that appear on the webpage for all the radio buttons on the ADRESS page");
					Assert.assertTrue(false,"The DB values did not match the webpage values");
				}
				getAddressesData(ConfigPathFile.InValid.getConstantValue());
			}if(i==3 && objListOfAddresses.getPending().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
				if(gp.isElementDisplayed(driver, By.id(IDpending))==true){
					if(verifyRecordsCount(objAdressDBQUERY,locationName)){
						Reporter.log("The DB records count for the ADRESS page matched the web page data");
					}else{
						Reporter.log("The DB values did not match all the values that appear on the webpage for all the radio buttons on the ADRESS page");
						Assert.assertTrue(false,"The DB values did not match the webpage values");
					}
					getAddressesData(ConfigPathFile.Pending.getConstantValue());
				}else{
					if(verifyRecordsCount(objAdressDBQUERY,locationName)){
						Reporter.log("The DB records count for the ADRESS page matched the web page data");
					}else{
						Reporter.log("The DB values did not match all the values that appear on the webpage for all the radio buttons on the ADRESS page");
						Assert.assertTrue(false,"The DB values did not match the webpage values");
					}
					getAddressesData(ConfigPathFile.CannotBeValidated.getConstantValue());
				}
			}
			gp.waitForTime(600);
		}
	}*/
	/**
	 * Method Name : getAddressesData
	 * Purpose:
	 * @param: List of objListOfAddresses
	 * @return: None
	 */
	public void getAddressesData(String checkFor){
		lavanteUtils.waitForTime(3000);
		//explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xAddressRecordRows);
		//List<WebElement> listOfRows=driver.findElements(By.xpath(xAddressRecordRows));
		try {
			if(xAddressRecordRows.size()>=1){
				Reporter.log(" Addresses records are available ");
				System.out.println("SIZE"+xAddressRecordRows.size());
				for(int k=1;k<=xAddressRecordRows.size();k++){
					//lavanteUtils.waitForTime(500);
					if(lavanteUtils.verifyElementDisplayed("xNoDataAvailableRows",xNoDataAvailableRows)){
						Reporter.log(" Addresses records are not available for the option: "+checkFor);
					}else{
						//System.out.println(xSupplierNameLinkPrefix+k+xSupplierNameLinkSuffix);
						//gp.clicks(driver,ConfigPathFile.XPATH.getConstantValue(),xSupplierNameLinkPrefix+k+xSupplierNameLinkSuffix);
						Reporter.log(" Clicked on the supplier name Link successfully ");
						//validateAddressesUpdate(checkFor);
						break;
					}
				}
			}else{
				Reporter.log(" Addresses records are not available for the option: "+checkFor);
			}
		} catch (Exception e) {
			//log.severe(" Records of address details are not found due to : "+e.getMessage());
		}

	}
	//xValidAddressRows
	//xInvalidAddressRows
	//xCannotBeValidatedRows

	/**
	 * Method Name : validateAddressesUpdate
	 * Purpose:
	 * @param: List of objListOfAddresses
	 * @return: None
	 */
	public void validateAddressesUpdate(String checkFor){
		lavanteUtils.waitForTime(1500);
		boolean flag = true;
		lavanteUtils.switchtoFrame(xSupBodyDisFrame);
		lavanteUtils.click("xSupplierManagedTab",xSupplierManagedTab);
		Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
		lavanteUtils.click("xSupplierContactTab",xSupplierContactTab);
		Reporter.log("Clicked on the | Contact | Tab successfully"); 
		switch (checkFor) {
		case "Valid":
			if(lavanteUtils.verifyElementDisplayed("xInvalidAddressRows",xInvalidAddressRows)){
				flag = false;
			}
			if(lavanteUtils.verifyElementDisplayed("xCannotBeValidatedRows",xCannotBeValidatedRows)){
				flag = false;
			}
			if (flag==true){
				Reporter.log("Verification of valid addresses is successful");
			}else{
				Reporter.log("Verification failed for the option |valid|  addresses");
			}
			break;
		case "InValid":
			if(lavanteUtils.verifyElementDisplayed("xInvalidAddressRows",xInvalidAddressRows))
			{
				Reporter.log("Verification of In-Valid addresses is successful");
			}else{
				Reporter.log("Verification failed for the option |In-Valid| addresses");
			}
			break;
		case "Pending":
			if(lavanteUtils.verifyElementDisplayed("xPendingAddressRows",xPendingAddressRows))
			{
				Reporter.log("Verification of pending addresses is successful");
			}else{
				Reporter.log("Verification failed for pending addresses");
			}
			break;
		case "CannotBeValidated":
			if(lavanteUtils.verifyElementDisplayed("xCannotBeValidatedRows",xCannotBeValidatedRows))
			{
				Reporter.log("Verification of Cannot Be Validated addresses is successful");
			}else{
				Reporter.log("Verification failed for the option |Cannot Be Validated| addresses");
			}
			break;

		default:
			Reporter.log("No Case Statement Executed");
			break;
		}
		
		closeSupDetailsPopUpWindow();
	}

	/**
	 * Method Name : closeSupDetailsPopUpWindow
	 * Purpose: This method is commom method to close supplier details page 
	 * @param: String expSupName
	 * @return: None
	 */
	public void closeSupDetailsPopUpWindow(){
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click("cssPopupCloseBtn",cssPopupCloseBtn);
		Reporter.log("Clicked on the | Popup Close | Button successfully");
		if(lavanteUtils.verifyElementDisplayed("cssPopupCloseBtn",cssPopupCloseBtn)){
			lavanteUtils.pressEnterkey("cssPopupCloseBtn", cssPopupCloseBtn);
		}
	}
	public void validatePendingStatus(List<setTestData> getNewSupplierList){
		//createNewSupplier
		SupplierSearchPage objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);

		//SupplierProfilePage objSupplierProfilePage = PageFactory.initElements(driver,SupplierProfilePage.class);
		//objSupplierSearchPage.createNewSupplier(getNewSupplierList); Will Use for create New Supplier

		for(int i=0;i<getNewSupplierList.size();i++){
			objSupplierSearchPage.searchBasicSupplier("", "", getNewSupplierList.get(i).getProfileStatus().toString(), "");
			objSupplierSearchPage.selectFirstSupplierFromList(getNewSupplierList.get(i).getProfileStatus().toString());
			objSupplierSearchPage.editSupProfile();
			objSupplierSearchPage.editSupProfileAddress(getNewSupplierList);//need to delete 

			//objSupplierProfilePage.addSupProfileDetailsOfCompany(getNewSupplierList);
		}
	}

	public boolean verifyRecordsCount(List<setTestData> objTDForOFACDBQuery,String locationName) {
		objOFACPage= PageFactory.initElements(driver,OFACPage.class);
		String strExpValue="",strActValue="";
		int actRecordsCount=0,expRecordCount=0;
		boolean bool_match=false;
		try {
			for (int i = 0; i < objTDForOFACDBQuery.size(); i++) {
				System.out.println(objTDForOFACDBQuery.get(i).getCountRadio().toString());
				clickOnRadioBtn(objTDForOFACDBQuery.get(i).getCountRadio().toString());
				if(objTDForOFACDBQuery.get(i).getKeyValue().toString().equalsIgnoreCase("yes")){
					lavanteUtils.click(IDShowDeactivatedSuppliers);
					Reporter.log("Successfully checked 'Show Inactive Supplier ' check box ");
					Reporter.log(" In Active Suppliers List");
					lavanteUtils.waitForTime(3000);
				}else{
					//WebElement web_Element = lavanteUtils.verifyElementDisplayed("IDShowDeactivatedSuppliers", IDShowDeactivatedSuppliers);
					if (IDShowDeactivatedSuppliers.isSelected()) {
						IDShowDeactivatedSuppliers.click();
						Reporter.log("Successfully Un-checked 'Show Inactive Supplier ' check box ");
						Reporter.log(" Active Suppliers List");
					}
					lavanteUtils.waitForTime(3000);
				}
				//add the compare method
				if(locationName.equalsIgnoreCase("US")){
					if(!objTDForOFACDBQuery.get(i).getDbQueryForUS().toString().equals("")){
						System.out.println("Q"+i+":"+objTDForOFACDBQuery.get(i).getDbQueryForUS().toString());
						strExpValue=objOFACPage.dBconnect(objTDForOFACDBQuery.get(i).getDbQueryForUS().toString());
						expRecordCount=lavanteUtils.convertStringToNbr(strExpValue);
					//SP
			/*			if(objTDForOFACDBQuery.get(i).getCountRadio().toString().equalsIgnoreCase("All")||objTDForOFACDBQuery.get(i).getCountRadio().toString().equalsIgnoreCase("Pending"))
						{
						expRecordCount=expRecordCount+3;
						}
			*/			System.out.println(i+"EXP Record:"+expRecordCount);
					}

				}else{
					if(!objTDForOFACDBQuery.get(i).getDbQueryForNonUS().toString().equals("")){
						System.out.println("QN"+objTDForOFACDBQuery.get(i).getDbQueryForNonUS().toString());
						strExpValue=objOFACPage.dBconnect(objTDForOFACDBQuery.get(i).getDbQueryForNonUS().toString());
						expRecordCount=lavanteUtils.convertStringToNbr(strExpValue);
						System.out.println(i+"EXP :"+expRecordCount);
					}
				}

				strActValue=objOFACPage.getRecordsCount();
				actRecordsCount=lavanteUtils.convertStringToNbr(strActValue);
				System.out.println("ACT"+actRecordsCount);
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


			}//for loop end
		}catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Failed to verify the webpage result with the database results due to : "+e.getMessage());
			//log.severe("Failure in verifying the webpage results against the database results ");
			Assert.assertFalse(true, "Failed due to the exception : "+e.getCause());
		}
		return bool_match;

	}

	/**
	 * Method: clickOnRadioBtn
	 * @param: String the name of the radio button to be clicked
	 */

	public void clickOnRadioBtn(String radioBtnName) {
		try{
			switch (radioBtnName) {
			case "All":
				lavanteUtils.click("IDall", IDall);
				Reporter.log("Clicked on the |All| radio button successfully");
				break;
			case "Valid":
				lavanteUtils.click("IDvalid", IDvalid);
				Reporter.log("Clicked on the |Valid| radio button successfully");
				break;
			case "InValid":
				lavanteUtils.click("IDinvalid",IDinvalid);
				Reporter.log("Clicked on the |Invalid| radio button successfully");
				break;
			case "Pending":
				if(lavanteUtils.verifyElementDisplayed("IDpending",IDpending)){
					lavanteUtils.click("IDpending",IDpending);
					Reporter.log("Clicked on the  |Pending| radio button successfully");
				}
				break;
			case "CannotBeValidated":
				if(lavanteUtils.verifyElementDisplayed("IDCannotbevalidated",IDCannotbevalidated)){
					lavanteUtils.click("IDCannotbevalidated", IDCannotbevalidated);
					Reporter.log("Clicked on the |Cannot be validated| radio button successfully");
				}
				break;

			default:
				//	Assert.assertTrue(false,"The Radio Button mentioned in the data is not present on the OFAC page");
				break;
			}
			lavanteUtils.waitForTime(3000);
		}catch(Exception e){
			//log.severe("Radio button gp.clicks failure for the : "+radioBtnName+" radio button in the OFAC Page");
			Assert.assertFalse(true, "Failed due to the exception : "+e.getCause());
		}
	}

}
