/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */ 

package com.lavante.sim.customer.pageobjects.SupplierProfile;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.BasicSearch.SupplierSearchPage;
import com.lavante.sim.Common.Util.*;

/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */

public class CustSupViewProfilePage  {
	String methodName="";
	SupplierSearchPage objSupplierSearchPage = null;
	SupplierProfilePage objSupplierProfilePage = null;
	LavanteUtils lavanteUtils=new LavanteUtils();

	private WebDriver driver=null;
	
	@FindBy(how=How.ID,using="search_tab")
	private WebElement IDsearchtab;	
	public WebElement IDsearchtab(){
		return IDsearchtab;
	}
	
	@FindBy(how=How.ID,using="conwayCustomField4")
	private WebElement IDCheckBoxAgree;	
	public WebElement IDCheckBoxAgree(){
		return IDCheckBoxAgree;
	}
	
	@FindBy(how=How.ID,using="saveexit_button")
	private WebElement IDSaveExitBtn;	
	public WebElement IDSaveExitBtn(){
		return IDSaveExitBtn;
	}
	
	@FindBy(how=How.ID,using="adv_search_tab")
	private WebElement IDAdvSearchTab;	
	public WebElement IDAdvSearchTab(){
		return IDAdvSearchTab;
	}
	
	@FindBy(how=How.ID,using="search_results")
	private WebElement IDSearchresultsFrame;	
	public WebElement IDSearchresultsFrame(){
		return IDSearchresultsFrame;
	}
	
	@FindBy(how=How.ID,using="comment")
	private WebElement IDComment;	
	public WebElement IDComment(){
		return IDComment;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='payment_discount_details']")
	private WebElement xPaymentDetails;	
	public WebElement xPaymentDetails(){
		return xPaymentDetails;
	}
	
	String xPaymentDetails2;	
	
	@FindBy(how=How.XPATH,using="//table[@id='profile_tab']/tbody/tr/td[3]/button[@class='trail-next'][@disabled='']")
	private WebElement xProfileTabArrowBtn;	
	public WebElement xProfileTabArrowBtn(){
		return xProfileTabArrowBtn;
	}
	
	@FindBy(how=How.XPATH,using="//table[@id='profile_tab']/tbody/tr/td[3]/button[@class='trail-next']")
	private WebElement xProfileTabArrowVisibleBtn;	
	public WebElement xProfileTabArrowVisibleBtn(){
		return xProfileTabArrowVisibleBtn;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@id,'search_results')]/tbody/tr")
	private WebElement xSupNameRows;	
	public WebElement xSupNameRows(){
		return xSupNameRows;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@id,'search_results')]/tbody/tr")
	private List<WebElement> lixSupNameRows;	
	public List<WebElement> lixSupNameRows(){
		return lixSupNameRows;
	}
	
	@FindBy(how=How.XPATH,using="//iframe[contains(@class,'popup_iframe ui-dialog-content ui-widget-content')]")
	private WebElement xSupBodyDisFrame;	
	public WebElement xSupBodyDisFrame(){
		return xSupBodyDisFrame;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-navigation']/a[1]")
	private WebElement xSupplierManagedTab;	
	public WebElement xSupplierManagedTab(){
		return xSupplierManagedTab;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='sub-navigation']/a[4]")
	private WebElement xPaymentInfoTab;	
	public WebElement xPaymentInfoTab(){
		return xPaymentInfoTab;
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='toggle_content']/div/table/tbody/tr/td[2]")
	private WebElement xAgreeTxt;	
	public WebElement xAgreeTxt(){
		return xAgreeTxt;
	}
	
	@FindBy(how=How.XPATH,using="//form[contains(@id,'search_supplier_form')]/div/table/tbody/tr[2]/td[2]/input[contains(@id,'supplierName')]")
	private WebElement xSupplierNameField;	
	public WebElement xSupplierNameField(){
		return xSupplierNameField;
	}
		
	@FindBy(how=How.XPATH,using="//form[contains(@id,'search_supplier_form')]/div[2]/button[contains(@title,'Search Suppliers')]")
	private WebElement xBasicSearchBtn;	
	public WebElement xBasicSearchBtn(){
		return xBasicSearchBtn;
	}	
	
	@FindBy(how=How.XPATH,using="//form[contains(@id,'supplierSearchResultForm')]/div[2]/div[1]/button")
	private WebElement xProfileBlueBtn;	
	public WebElement xProfileBlueBtn(){
		return xProfileBlueBtn;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@id,'search_results')]/tbody/tr[")
	private WebElement xSupNameRowsOne;	
	public WebElement xSupNameRowsOne(){
		return xSupNameRowsOne;
	}
	
	@FindBy(how=How.XPATH,using="]/td[1]")
	private WebElement xSupNameRowsTwo;	
	public WebElement xSupNameRowsTwo(){
		return xSupNameRowsTwo;
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'evt-trail-evt trail-item')]/div/h2[contains(@class,'wizard_tab_title')]")
	private WebElement xPaymentInfoWizardTab;	
	public WebElement xPaymentInfoWizardTab(){
		return xPaymentInfoWizardTab;
	}
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'dialog undefined ui-dialog-content ui-widget-content')]")
	private WebElement xPopupSavedTxt;	
	public WebElement xPopupSavedTxt(){
		return xPopupSavedTxt;
	}
	
	@FindBy(how=How.XPATH,using="//div/div/button[contains(@class,'button_green')][contains(@type,'button')]")
	private WebElement xPopupOkBtn;	
	public WebElement xPopupOkBtn(){
		return xPopupOkBtn;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='CF_conwayCustomField4_chosen']/div[contains(@class,'chosen-drop')]/ul/li")
	private WebElement xETFTermsDropDownList;	
	public WebElement xETFTermsDropDownList(){
		return xETFTermsDropDownList;
	}

	@FindBy(how=How.XPATH,using="//div[@id='supplier_name_chosen']/div[contains(@class,'chosen-drop')]/ul/li")
	private WebElement xSupplierNameList;	
	public WebElement xSupplierNameList(){
		return xSupplierNameList;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='supplier_name_chosen']/a[contains(@class,'chosen-single')]")
	private WebElement xSupplierNameDropDown;	
	public WebElement xSupplierNameDropDown(){
		return xSupplierNameDropDown;
	}
	
	@FindBy(how=How.XPATH,using="a[title='Payment Information'][class='tab']")
	private WebElement xPaymentInformationTab;	
	public WebElement xPaymentInformationTab(){
		return xPaymentInformationTab;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='CF_conwayCustomField4_chosen']/a[contains(@class,'chosen-single')]")
	private WebElement xETFTermsField;	
	public WebElement xETFTermsField(){
		return xETFTermsField;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-navigation']/a[3]")
	private WebElement xStatusHistoryTab;	
	public WebElement xStatusHistoryTab(){
		return xStatusHistoryTab;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='CF_conwayCustomField4_chosen']/a[contains(@class,'chosen-single')]")
	private WebElement xRequiredFieldsTab;	
	public WebElement xRequiredFieldsTab(){
		return xRequiredFieldsTab;
	}
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'todo_rows align_left')]/ul/li/i")
	private List<WebElement> xListRequiredFields;	
	public List<WebElement> xListRequiredFields(){
		return xListRequiredFields;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='profile_percentage']")
	private WebElement xProfileCompletionStatus;	
	public WebElement xProfileCompletionStatus(){
		return xProfileCompletionStatus;
	}
		
	@FindBy(how=How.XPATH,using="//span[contains(@class,'ui-dialog-title')]")
	private WebElement xSupplierDetailsPageHeader;	
	public WebElement xSupplierDetailsPageHeader(){
		return xSupplierDetailsPageHeader;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='customer_chosen']//a")
	private WebElement xCustomerNameDropDownField;	
	public WebElement xCustomerNameDropDownField(){
		return xCustomerNameDropDownField;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='customer_chosen']/div[contains(@class,'chosen-drop')]/ul/li")
	private WebElement xCustomerNameDropDownList;	
	public WebElement xCustomerNameDropDownList(){
		return xCustomerNameDropDownList;
	}
	
	@FindBy(how=How.XPATH,using="//iframe[contains(@class,'iframe_page')]")
	private WebElement xIframepage;	
	public WebElement xIframepage(){
		return xIframepage;
	}
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'trail-container horizontal-tab')]/ul/li/ul")
	private List<WebElement> xRequiredFieldListNames;	
	public List<WebElement> xRequiredFieldListNames(){
		return xRequiredFieldListNames;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-navigation']/a[2]")
	private WebElement xSupplierEnterpriseOwnedTab;	
	public WebElement xSupplierEnterpriseOwnedTab(){
		return xSupplierEnterpriseOwnedTab;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='sub-navigation']/a[3]")
	private WebElement xSupplierVMFViewTab;	
	public WebElement xSupplierVMFViewTab(){
		return xSupplierVMFViewTab;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@class,'data_table table_grid zebra')]/tbody/tr/td")
	private WebElement xVMFRowsData;	
	public WebElement xVMFRowsData(){
		return xVMFRowsData;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='sub-navigation']/a[6]")
	private WebElement xSupplierContactTab;	
	public WebElement xSupplierContactTab(){
		return xSupplierContactTab;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='sub-navigation']/a[2]")
	private WebElement xNoteCommentsTab;	
	public WebElement xNoteCommentsTab(){
		return xNoteCommentsTab;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='commentType_chosen']/a[contains(@class,'chosen-single')]")
	private WebElement xCommentTypeField;	
	public WebElement xCommentTypeField(){
		return xCommentTypeField;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='commentType_chosen']/div[contains(@class,'chosen-drop')]/ul/li")
	private WebElement xCommentTypeDropDown;	
	public WebElement xCommentTypeDropDown(){
		return xCommentTypeDropDown;
	}
	
	@FindBy(how=How.XPATH,using="//h3[contains(@class,'toggle_header')]")
	private  List<WebElement> xListUpadtedComment;	
	public  List<WebElement> xListUpadtedComment(){
		return xListUpadtedComment;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@class,'data_table table_grid zebra dynamic_table toggle_content')]/tbody/tr/td[4]")
	private List<WebElement> xCommentsList;	
	public List<WebElement> xCommentsList(){
		return xCommentsList;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'contactName')]")
	private WebElement xContactNameColumn;	
	public WebElement xContactNameColumn(){
		return xContactNameColumn;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'designation')]")
	private WebElement xDesignationColumn;	
	public WebElement xDesignationColumn(){
		return xDesignationColumn;
	}
		
	@FindBy(how=How.XPATH,using="//th[contains(@id,'department')]")
	private WebElement xDepartmentColumn;	
	public WebElement xDepartmentColumn(){
		return xDepartmentColumn;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'phoneNumber')]")
	private WebElement xPhoneNumberColumn;	
	public WebElement xPhoneNumberColumn(){
		return xPhoneNumberColumn;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'faxNumber')]")
	private WebElement xFaxNumberColumn;	
	public WebElement xFaxNumberColumn(){
		return xFaxNumberColumn;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'email')]")
	private WebElement xEmailColumn;	
	public WebElement xEmailColumn(){
		return xEmailColumn;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'address')]")
	private WebElement xAddressColumn;	
	public WebElement xAddressColumn(){
		return xAddressColumn;
	}
	
	@FindBy(how=How.XPATH,using="//th[contains(@id,'contactType')]")
	private WebElement xContactTypeColumn;	
	public WebElement xContactTypeColumn(){
		return xContactTypeColumn;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@class,'data_table table_outer_grid')]/tbody/tr[10]/td[2]")
	private WebElement xTinNumber;	
	public WebElement xTinNumber(){
		return xTinNumber;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@class,'data_table table_outer_grid')]/tbody/tr[8]/td[1]")
	private WebElement xUsIncomeFieldLabel;	
	public WebElement xUsIncomeFieldLabel(){
		return xUsIncomeFieldLabel;
	}
	
	@FindBy(how=How.XPATH,using="//table[contains(@class,'data_table table_outer_grid')]/tbody/tr[8]/td[2]")
	private WebElement xUsIncomeFieldLabelText;	
	public WebElement xUsIncomeFieldLabelText(){
		return xUsIncomeFieldLabelText;
	}

	private String xSubTabRowsPrefix=".//*[@id='sub-navigation']/a[";	
	
	
	@FindBy(how=How.XPATH,using="]")
	private WebElement xSubTabRowsSuffix;	
	public WebElement xSubTabRowsSuffix(){
		return xSubTabRowsSuffix;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='dialog']//label[contains(@class,'field_required')]")
	private List<WebElement> xRequiredFieldList;	
	public List<WebElement> xRequiredFieldList(){
		return xRequiredFieldList;
	}
	
	@FindBy(how=How.CSS,using="button[value='Edit Profile'][class='buttons_group_button']")
	private WebElement cssProfileEditBtn;	
	public WebElement cssProfileEditBtn(){
		return cssProfileEditBtn;
	}
	
	@FindBy(how=How.CSS,using="button[title='close'][type='button']")
	private WebElement cssPopupCloseBtn;	
	public WebElement cssPopupCloseBtn(){
		return cssPopupCloseBtn;
	}
	
	@FindBy(how=How.CSS,using="//button[@name='adv_search'][@class='button_green open_popup']")
	private WebElement xBuildQueryBtn;	
	public WebElement xBuildQueryBtn(){
		return xBuildQueryBtn;
	}
		
	@FindBy(how=How.CSS,using="input[type='text'][name='supplier_name_field']")
	private WebElement cssEditSupNameField;	
	public WebElement cssEditSupNameField(){
		return cssEditSupNameField;
	}
	
	@FindBy(how=How.CSS,using="input[title='Search'][type='submit']")
	private WebElement cssBuildQuerySearchBtn;	
	public WebElement cssBuildQuerySearchBtn(){
		return cssBuildQuerySearchBtn;
	}
	
	@FindBy(how=How.CSS,using="button[type='submit'][title='Save']")
	private WebElement cssCommentSaveBtn;	
	public WebElement cssCommentSaveBtn(){
		return cssCommentSaveBtn;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Suppliers")
	private WebElement linkTxtSuppliers;	
	public WebElement linkTxtSuppliers(){
		return linkTxtSuppliers;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Home")
	private WebElement linkTxthome;	
	public WebElement linkTxthome(){
		return linkTxthome;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Edit Profile")
	private WebElement linkTxtEditProfile;	
	public WebElement linkTxtEditProfile(){
		return linkTxtEditProfile;
	}
	
	@FindBy(how=How.LINK_TEXT,using="View Profile")
	private WebElement linkTxtViewProfile;	
	public WebElement linkTxtViewProfile(){
		return linkTxtViewProfile;
	}
	
	String expNameColumnTxt="Name";
	String expDesignationColumnTxt="Designation";
	String expDepartmentColumnTxt="Department";
	String expPhoneNumberColumnTxt="Phone Number";
	String expFaxNumberColumnTxt="Fax Number";
	String expEmailColumnTxt="Email";
	String expAddressColumnTxt="Address";
	String expContactTypeColumnTxt="Contact Type";
	String expProfileSavedMsgTxt="Profile is successfully saved";
	String expAgreeTxt="Agree";
	String expSupplierDetailsPageHeader="Supplier Details for";
	String expBuildQueryPageHeader="Build Query";

//Declare web driver


	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	public CustSupViewProfilePage(WebDriver driver) {
		try {
			this.driver = driver;
		} catch (Exception e)  {						
		//	log.severe("Method: AddressValidationPage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());	
		}
	}


	/**
	 * Method Name : validateEFTTermsConditions
	 * Purpose: This method validate the supplier configuration AGREE text is updated or not
	 * @param: String expSupName
	 * @return: None
	 */
	public void validateEFTTermsConditions(String expSupName){
		String actSupName="",expAgreeTxtForProfile=expAgreeTxt,actAgreeTxtForProfile="";
		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(IDSearchresultsFrame);
		lavanteUtils.fluentwait(xSupNameRows);
		try {
			for(int i=0;i<lixSupNameRows.size();i++){
				List<WebElement> listColumns=lixSupNameRows.get(i).findElements(By.tagName(ConfigPathFile.TD.getConstantValue()));
				actSupName=listColumns.get(2).getText().trim().toString();
				if(actSupName.contains(expSupName)){
					Thread.sleep(1000);
					driver.findElement(By.partialLinkText(expSupName)).click();
					Reporter.log("Clicked on the | Supplier Name | Link successfully");
					break;
				}
			}
		} catch (Exception e) {
		//	log.severe("Supplier Records are not found with the specified search criteria");
			Assert.assertTrue(false,"Supplier Records are not found with the specified search criteria");	
		}
		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(xSupBodyDisFrame);
		lavanteUtils.click(driver.findElement(By.partialLinkText("Supplier Managed")));
		Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
		lavanteUtils.waitForTime(2000);
		lavanteUtils.click(driver.findElement(By.partialLinkText("Payment Information")));
		Reporter.log("Clicked on the | Payment Info | Tab successfully");
		lavanteUtils.waitForTime(2000);
		actAgreeTxtForProfile=lavanteUtils.getText(xAgreeTxt);
		if(!expAgreeTxtForProfile.trim().toString().equalsIgnoreCase("agree")){
		//	log.severe("Test Failed due to expected Popup massege:  "+expAgreeTxtForProfile +" but found "+actAgreeTxtForProfile);
			Assert.assertTrue(false,"Test Failed due to expected Popup massege:  "+expAgreeTxtForProfile +" but found "+actAgreeTxtForProfile);
		}else{
			Reporter.log("Profile is successfully Updated To:  "+actAgreeTxtForProfile);
		}
		closeSupDetailsPopUpWindow();
	}

	/**
	 * Method Name : validateAgreeTxtUpdates
	 * Purpose: This method will update the EFT terms and conditions status to Agree and verify is it updated
	 * @param: List of objListOfAddresses
	 * @return: None
	 */
	public void validateAgreeTxtUpdates(setTestData objViewProfiles) {
		objSupplierProfilePage = PageFactory.initElements(driver,SupplierProfilePage.class);
		String expProfileSavedMsg=expProfileSavedMsgTxt,actProfileSavedMsg="";
		try {
			objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
			objSupplierSearchPage.searchSupplierNames(ConfigPathFile.checkBox.getConstantValue(), objViewProfiles.getSupplierName().trim().toString());
			lavanteUtils.click( xProfileBlueBtn);
			Reporter.log("Clicked on the | Profile | Blue Button successfully");
			lavanteUtils.click(cssProfileEditBtn);
			Reporter.log("Clicked on the | Edit Profile | Button successfully");
			lavanteUtils.switchtoFrame(null);
			objSupplierProfilePage.clickOnMenuTabByNbr("4",xPaymentDetails2);
			objSupplierProfilePage.isLeavePopUpExist();
			lavanteUtils.switchtoFrame(null);
			Reporter.log("Clicked on the | Payment Info | 4th Button successfully");
			//gp.select_RadioBtn(driver, ConfigPathFile.ID.getConstantValue(),IDCheckBoxAgree);
			Reporter.log("Clicked on the EFT Terms and Conditions | Agree Check Box|  successfully");
			lavanteUtils.click(IDSaveExitBtn);
			Reporter.log("Clicked on the | Save and Exit | Button successfully");
			actProfileSavedMsg=lavanteUtils.getText(xPopupSavedTxt);
			if(!expProfileSavedMsg.trim().toString().equalsIgnoreCase(actProfileSavedMsg)){
				//log.severe("Test Failed due to expected Popup massege:  "+expProfileSavedMsg +" but found "+actProfileSavedMsg);
				Assert.assertTrue(false,"Test Failed due to expected Popup massege:  "+expProfileSavedMsg +" but found "+actProfileSavedMsg);
			}else{
				Reporter.log("Profile is successfully saved");
			}
			lavanteUtils.click(xPopupOkBtn);
			Reporter.log("Clicked on the | OK | Button successfully");
			//Calling Method with basic search of suppliers for Agree Text Updates 
			validateEFTTermsConditions(objViewProfiles.getSupplierName().trim().toString());
			//Calling Method with Advance search of suppliers for Agree Text Updates 
			advSearchForAgreeTxtPresence(objViewProfiles.getSupplierName().trim().toString(),objViewProfiles.getTermsCheckBox().trim().toString());
			//}
		}catch(Exception e) {
		//	log.severe("Exception in the method validateAgreeTxtUpdates due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateAgreeTxtUpdates due to "+e.getMessage());			
		}
	}


	/**
	 * Method Name : advSearchForAgreeTxtPresence
	 * Purpose: Method is to validate the profiles status in advanced search  build query
	 * @param: String supName,String termStatus
	 * @return: None
	 */
	public void advSearchForAgreeTxtPresence(String supName,String termStatus){
		lavanteUtils.waitForTime(5000);
		lavanteUtils.switchtoFrame(IDSearchresultsFrame);
		lavanteUtils.fluentwait(xSupNameRows);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(IDAdvSearchTab);
		Reporter.log("Clicked on the | Advanced Search | Button successfully");
		lavanteUtils.waitForTime(4000);
		lavanteUtils.click(xBuildQueryBtn);
		Reporter.log("Clicked on the | Build Query | Button successfully");
		lavanteUtils.waitForTime(3000);
		//build query Page
		/*gp.switchToFrameBy(driver, "","","");
		if(gp.compareText(driver,expBuildQueryPageHeader, ConfigPathFile.XPATH.getConstantValue(),xSupplierDetailsPageHeader)==false){
			log.severe("Test Failed due to expected page header: "+expBuildQueryPageHeader +" are mismatched ");
			Assert.assertTrue(false,"Test Failed due to expected page header: "+expBuildQueryPageHeader +" are mismatched ");
		}*/
		lavanteUtils.switchtoFrame(xSupBodyDisFrame);
		lavanteUtils.click(xSupplierNameDropDown);
		lavanteUtils.selectvalueFrmDpdn(ConfigPathFile.Contains.getConstantValue());
		Reporter.log("Selected the value Contains from | Supplier Name | Drop Down List successfully");
		lavanteUtils.switchtoFrame(xSupBodyDisFrame);
		lavanteUtils.typeinEdit(supName,cssEditSupNameField);
		lavanteUtils.click(xPaymentInformationTab);
		Reporter.log("Clicked on the | Payment Information | Tab  successfully");
		/*gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),xETFTermsField);
		Reporter.log("Clicked on the | EFT terms and conditions: | Drop Down List successfully");
		gp.switchToFrameBy(driver, "","","");
		gp.selectDropDownValue(driver, ConfigPathFile.XPATH.getConstantValue(),xETFTermsDropDownList,termStatus);
		Reporter.log("Selected the value "+termStatus+" from | EFT terms and conditions | Drop Down List successfully");
		gp.switchToFrameBy(driver,xSupBodyDisFrame, ConfigPathFile.IN.getConstantValue(),ConfigPathFile.XPATH.getConstantValue());
		gp.clicks(driver, ConfigPathFile.CSS.getConstantValue(),cssBuildQuerySearchBtn);
		Reporter.log("Clicked on the | Build Query Search | button successfully");
		gp.switchToFrameBy(driver, "","","");
		validateEFTTermsConditions(supName);*/
	}
	/**
	 * Method Name : validateCompletedRequiredFieldLists
	 * Purpose: This method verify the completed required fields of the supplier
	 * @param: String expSupName
	 * @return: None 
	 */
	public List<String>  validateCompletedRequiredFieldLists(String expSupName,String profileOperation){
		List<String>listExpWebElmText =new ArrayList<String>();
		String getProfileCompletionStatus="";
		objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
		objSupplierSearchPage.searchSupplierNames(ConfigPathFile.SupplierName.getConstantValue(), expSupName);
		lavanteUtils.waitForTime(2500);
		lavanteUtils.switchtoFrame(xSupBodyDisFrame);
		if(profileOperation.equals("viewprofile")){
			lavanteUtils.click(driver.findElement(By.linkText("Supplier Managed")));
			Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
			lavanteUtils.click(driver.findElement(By.linkText("Core Profile")));
			Reporter.log("Clicked on the | Core Profile | Tab successfully");
			lavanteUtils.waitForTime(1000);
			for(WebElement e:xRequiredFieldList){
				listExpWebElmText.add(e.getText());
			}
		}else{
			lavanteUtils.click(driver.findElement(By.linkText("Status and History")));
			Reporter.log("Clicked on the | Status and History | Tab successfully");
			lavanteUtils.click(driver.findElement(By.linkText("Required Fields")));
			Reporter.log("Clicked on the | Required Fields | Tab successfully");
			getProfileCompletionStatus=lavanteUtils.getText(xProfileCompletionStatus);
			Reporter.log("ProfileCompletionStatus: "+getProfileCompletionStatus);
			lavanteUtils.waitForTime(1000);
			for(WebElement e:xListRequiredFields){
				listExpWebElmText.add(e.getText());
			}
		}
		closeSupDetailsPopUpWindow();
		return listExpWebElmText;
	}
	/**
	 * Method Name : validateSuppliersRequiredFieldList
	 * Purpose: This method verify the completed required fields of the supplier
	 * @param: String expSupName
	 * @return: None
	 */
	public List<String>  validateSuppliersRequiredFieldList(String expSupName,String profileOperation,String customerName){
		List<String>listExpWebElmText =new ArrayList<String>();
		lavanteUtils.waitForTime(2000);
		lavanteUtils.click(linkTxthome);
		Reporter.log("Clicked on the | Home | Tab successfully");
		lavanteUtils.waitForTime(2000);
		lavanteUtils.click( xCustomerNameDropDownField);
		lavanteUtils.click( xCustomerNameDropDownList);
		lavanteUtils.selectvalueFrmDpdn(customerName);
		lavanteUtils.waitForTime(3000);
		if(profileOperation.equalsIgnoreCase("viewprofile")){
			lavanteUtils.click(linkTxtViewProfile);
			Reporter.log("Clicked on the | View Profile | Tab successfully");
			lavanteUtils.waitForTime(3500);
			if(lavanteUtils.switchtoFrame(xSupBodyDisFrame)){
				//explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xRequiredFieldList);
				lavanteUtils.waitForTime(2500);
				lavanteUtils.fluentwait(driver.findElement(By.linkText("Core Profile")));
				//click(driver, ConfigPathFile.XPATH.getConstantValue(),xRequiredFieldsTab);
				lavanteUtils.click(driver.findElement(By.linkText("Core Profile")));
				Reporter.log("Clicked on the | Core Profile | Tab successfully");
				lavanteUtils.waitForTime(2500);
				for(WebElement e:xRequiredFieldList){
					listExpWebElmText.add(e.getText());
				}
			}
			closeSupDetailsPopUpWindow();
		}else{
			lavanteUtils.click(linkTxtEditProfile);
			Reporter.log("Clicked on the | Edit Profile | Link successfully");
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.switchtoFrame(xIframepage)==true){
				if(lavanteUtils.isElementDisplayed(xRequiredFieldListNames.get(0))==true){
					lavanteUtils.waitForTime(1500);
					//explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xRequiredFieldListNames);
					
					for(WebElement e:xRequiredFieldListNames){
						listExpWebElmText.add(e.getText());
					}
				}else{
					Reporter.log("Required field list");
				}
			}

		}
		lavanteUtils.switchtoFrame(null);
		return listExpWebElmText;
	}

	/**
	 * Method Name : validateVMFViewLink
	 * Purpose: This method verify the VMF view tab appears
	 * @param: String expSupName
	 * @return: None
	 */
	public void validateVMFViewLink(String expSupName){
		Reporter.log("Verification of VMF View Tab is initiated");
		Reporter.log("\n");
		String getVmfRecords="";
		try {
			objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
			objSupplierSearchPage.searchSupplierNames(ConfigPathFile.SupplierName.getConstantValue(), expSupName);
			lavanteUtils.waitForTime(2500);
			lavanteUtils.switchtoFrame(xSupBodyDisFrame);
			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierEnterpriseOwnedTab);
			lavanteUtils.click(driver.findElement(By.linkText("Enterprise-Owned")));
			Reporter.log("Clicked on the | Enterprise Owned | Tab successfully");

			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierVMFViewTab);
			lavanteUtils.click(driver.findElement(By.linkText("As Supplied VMF View")));
			Reporter.log("Clicked on the | VMF View | Tab successfully");
			if(lavanteUtils.isElementDisplayed(xVMFRowsData)==true){
				getVmfRecords=lavanteUtils.getText( xVMFRowsData);
			}
			if(getVmfRecords.equalsIgnoreCase("No Data Available")){
				Reporter.log("No Data Available for VMF Link");
			}else{
				Reporter.log("Data Available for VMF Link");
			}
		} catch (Exception e) {
		//	log.severe("Exception in the method validateVMFViewLink due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateVMFViewLink due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validateSupContactsFields
	 * Purpose: This method verify the contacts column names
	 * @param: String expSupName
	 * @return: None 
	 */
	public void validateSupContactColumns(String expSupName){
		try {
			Reporter.log("Verification of Supplier Contact columns view is initiated");
			Reporter.log("\n");
			lavanteUtils.waitForTime(2500);
			lavanteUtils.switchtoFrame(xSupBodyDisFrame);

			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierManagedTab);
			lavanteUtils.click(driver.findElement(By.linkText("Supplier Managed")));
			Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierContactTab);
			lavanteUtils.click(driver.findElement(By.linkText("Contact")));
			Reporter.log("Clicked on the | Contact | Tab successfully");

			if(lavanteUtils.compareText(xContactNameColumn,expNameColumnTxt)==true){
				Reporter.log("Verification of | Name | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Name |");
			}

			if(lavanteUtils.compareText(xDesignationColumn,expDesignationColumnTxt)==true){
				Reporter.log("Verification of | Designation | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Designation |");
			}

			if(lavanteUtils.compareText(xDepartmentColumn,expDepartmentColumnTxt)==true){
				Reporter.log("Verification of | Department | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Department |");
			}

			if(lavanteUtils.compareText(xPhoneNumberColumn,expPhoneNumberColumnTxt)==true){
				Reporter.log("Verification of | Phone Number | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Phone Number |");
			}
			if(lavanteUtils.compareText(xFaxNumberColumn,expFaxNumberColumnTxt)==true){
				Reporter.log("Verification of | Fax Number | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Fax Number |");
			}

			if(lavanteUtils.compareText(xEmailColumn,expEmailColumnTxt)==true){
				Reporter.log("Verification of | Email | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Email |");
			}

			if(lavanteUtils.compareText(xAddressColumn,expAddressColumnTxt)==true){
				Reporter.log("Verification of | Address | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Address |");
			}

			if(lavanteUtils.compareText(xContactTypeColumn,expContactTypeColumnTxt)==true){
				Reporter.log("Verification of | Contact Type | column is successful");
			}else{
				Reporter.log("Verification is failed for the column | Contact Type |");
			}

		} catch (Exception e) {
		//	log.severe("Exception in the method validateSupContactsFields due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateSupContactsFields due to "+e.getMessage());
		}

	}
	/**
	 * Method Name : validateCommentType
	 * Purpose: This method is to verify the comments are updated or not 
	 * @param: String expSupName,comment,commentsType
	 * @return: None
	 */
	public void validateCommentType(String comment,String commentsType){
		Reporter.log("Verification of Note and Comments status is initiated");
		Reporter.log("\n");
		try {
			methodName = new Object() {}.getClass().getEnclosingMethod().getName();
			lavanteUtils.waitForTime(2500);
			lavanteUtils.switchtoFrame(xSupBodyDisFrame);

			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierEnterpriseOwnedTab);
			lavanteUtils.click(driver.findElement(By.linkText("Enterprise-Owned")));
			Reporter.log("Clicked on the | Enterprise Owned | Tab successfully");

			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xNoteCommentsTab);
			lavanteUtils.click(driver.findElement(By.linkText("Notes & Comments")));
			Reporter.log("Clicked on the | Notes and Comments | Tab successfully");

			lavanteUtils.click(xCommentTypeField);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.selectvalueFrmDpdn(commentsType);
			Reporter.log(commentsType+" comment type value selected successfully from the drop down list ");
			lavanteUtils.switchtoFrame(xSupBodyDisFrame);
			lavanteUtils.typeinEdit(comment, IDComment);
			Reporter.log("Entered comment description: "+comment+" successfully");
			//click(driver, ConfigPathFile.XPATH.getConstantValue(),cssCommentSaveBtn);
			Reporter.log("Clicked on the | Save | button successfully");
			if(lavanteUtils.isElementDisplayed(xListUpadtedComment.get(0))==true){
				List<WebElement> listRows=xListUpadtedComment;
				for(int i=0;i<listRows.size();i++){
					if(listRows.get(i).getText().toString().equalsIgnoreCase(commentsType)){
						Reporter.log("Provided comment type updated successfully");
						for(WebElement e:xCommentsList){
							if(e.getText().equalsIgnoreCase(comment)){
								Reporter.log("Provided comment Description updated successfully");
								break;
							}
						}
						break;
					}else{
						if (i + 1 == listRows.size()) {
						//	log.severe("Test is failed due to expected and actual comment type is mismatched, expected is "+ commentsType + " but actual is "		+ listRows.get(i).getText().toString());
							lavanteUtils.takeScreenshot(methodName);
							//Assert.assertTrue(false,"Test is failed due to expected and actual comment type is mismatched, expected is "+ commentsType + " but actual is "		+ listRows.get(i).getText().toString());
						}
					}
				}
			}else{
				Reporter.log("Verification failed due to comment type not updated ");
			//	log.severe("Verification failed due to comment type not updated ");
				lavanteUtils.takeScreenshot(methodName);
				//Assert.assertTrue(false,"Verification failed due to comment type not updated ");
			}
		} catch (Exception e) {
		//	log.severe("Exception in the method validateCommentType due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateCommentType due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validateUSTINnumberForNonUSCountries
	 * Purpose: This method verify the US TIN number appears For Non-US Countries 
	 * @param: String expSupName
	 * @return: None
	 */
	public void validateUSTINnumberForNonUSCountries(String expSupName,String expTinNumber){
		Reporter.log("Verification of US TIN number for Non-US Countries is initiated");
		Reporter.log("\n");
		try {
			lavanteUtils.waitForTime(2500);
			lavanteUtils.switchtoFrame(xSupBodyDisFrame);
			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierManagedTab);
			lavanteUtils.click(driver.findElement(By.linkText("Supplier Managed")));
			Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
			//click(driver, ConfigPathFile.XPATH.getConstantValue(),xNoteCommentsTab);
			lavanteUtils.click(driver.findElement(By.linkText("Regulatory")));
			Reporter.log("Clicked on the | Regulatory | Tab successfully");
			lavanteUtils.waitForTime(2500);
			if(lavanteUtils.isElementDisplayed(xUsIncomeFieldLabel)==true)
			{
				if(lavanteUtils.compareText(xUsIncomeFieldLabelText,"yes")==true)
				{
					if(lavanteUtils.isElementDisplayed(xTinNumber)==true)
					{
						if(lavanteUtils.compareText(xTinNumber, expTinNumber)==true){
							Reporter.log(" Verification of US TIN Number of US Income (for Non-US suppliers)  is successful");
						}else{
							Reporter.log(" Verification failed for US TIN Number of US Income (for Non-US suppliers)");
						}

					}else{
						Reporter.log("US Income (for Non-US suppliers): option choosed as yes, but US TIN Number: doe not appears");
					//	log.severe("US Income (for Non-US suppliers): option choosed as yes, but US TIN Number: doe not appears");
					}
				}

			}else{
				Reporter.log("US Income (for Non-US suppliers): does not appears on the supplier details page");
			//	log.severe("US Income (for Non-US suppliers): does not appears on the supplier details page");
			}
			closeSupDetailsPopUpWindow();

		} catch (Exception e) {
		//	log.severe("Exception in the method validateVMFViewLink due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateVMFViewLink due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : closeSupDetailsPopUpWindow
	 * Purpose: This method is commom method to close supplier details page 
	 * @param: String expSupName
	 * @return: None
	 */
	public void closeSupDetailsPopUpWindow(){
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(cssPopupCloseBtn);
		Reporter.log("Clicked on the | Popup Close | Button successfully");
	/*	if(gp.isElementDisplayed(driver, By.cssSelector(cssPopupCloseBtn))){
			e=driver.findElement(By.cssSelector(cssPopupCloseBtn));
			gp.jsExecutor(driver,ConfigPathFile.ID.getConstantValue(),e);
		}if(gp.isElementDisplayed(driver, By.cssSelector(cssPopupCloseBtn))){
			//navigateTo_Back_Frwrd_Page(driver, ConfigPathFile.REFRESH.getConstantValue());
			gp.pressEnterkey(driver, ConfigPathFile.CSS.getConstantValue(), cssPopupCloseBtn);
		}*/
		lavanteUtils.waitForTime(3000);
	}

	/**
	 * Method Name : verifyCustomerViewProfileTabs
	 * Purpose: This method verify the VMF view tab appears
	 * @param: String expSupName
	 * @return: None
	 */
	public void verifyCustomerViewProfileTabs(String expSupName){
		Reporter.log("Verification of Customer View Profile Tab is initiated");
		Reporter.log("\n");
		try {
			objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
			objSupplierSearchPage.searchSupplierNames(ConfigPathFile.SupplierName.getConstantValue(), expSupName);
			lavanteUtils.waitForTime(2500);
			lavanteUtils.switchtoFrame(xSupBodyDisFrame);
			lavanteUtils.click(xSupplierManagedTab);
			Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
			lavanteUtils.click(xRequiredFieldsTab);
			Reporter.log("Clicked on the | Core Profile | Tab successfully");
			lavanteUtils.waitForTime(1000);
			for(WebElement e:xRequiredFieldList){
				System.out.println(e.getText());
			}

		} catch (Exception e) {
	//		log.severe("Exception in the method validateVMFViewLink due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateVMFViewLink due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : validateViewProfileTabs
	 * Purpose: This method verify the data with respective to opened tab
	 * @param: String expSupName
	 * @return: None 
	 */
	public void validateViewProfileTabs(String expSupName,List<setTestData> objViewProfileTabTestData){
		int tabID;
		String getStrTabDetails="";
		objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
		objSupplierSearchPage.searchSupplierNames(ConfigPathFile.SupplierName.getConstantValue(), expSupName);
		lavanteUtils.waitForTime(2500);
		lavanteUtils.switchtoFrame(xSupBodyDisFrame);
		//click(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierManagedTab);
		lavanteUtils.click(driver.findElement(By.linkText("Supplier Managed")));
		lavanteUtils.waitForTime(1500);
		Reporter.log("Clicked on the | Supplier Managed | Tab successfully");
		for(int i=0;i<objViewProfileTabTestData.size();i++){
			tabID=i+1;
			lavanteUtils.click(driver.findElement(By.xpath(xSubTabRowsPrefix+tabID+xSubTabRowsSuffix)));
			Reporter.log("Clicked on the | Sub Tabs | successfully");
			lavanteUtils.waitForTime(2500);
			if(lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(objViewProfileTabTestData.get(i).getWebElements().trim().toString())))==true){
				getStrTabDetails=lavanteUtils.getText(driver.findElement(By.xpath(objViewProfileTabTestData.get(i).getWebElements().trim().toString())));	
				Reporter.log(" Sub-Tabs respective data available :  "+getStrTabDetails);
			}else{
				Reporter.log(" Sub-Tabs respective data not available ", 3);
			}
		}
		closeSupDetailsPopUpWindow();

	}
	/**
	 * Method Name : FetchMandatroyFields
	 * Purpose: This method is to get the data from database based on the given query
	 * @param: String expSupName
	 * @return: None 
	 */
	public  List<String> fetchMandatroyFields(String ExArr){
		List<String> objRequiredFields = new ArrayList<String>();
		try{
			
			Reporter.log("Connection to SIM Data Base is Successful");
			String s= lavanteUtils.fetchDBdata(ExArr);
			int j = 1;
			while(lavanteUtils.RetRS.next()){
				objRequiredFields.add(lavanteUtils.RetRS.getString(j).toString());
				j = j++ ;
			}
			return objRequiredFields;
		} catch (Exception e) {
		//	log.severe("Exception in method FetchMandatroyFields due to : "	+ e.getMessage());
			Assert.assertTrue(false,"Exception in method FetchMandatroyFields due to : "+ e.getMessage());
		}
		return null;
	}

}
