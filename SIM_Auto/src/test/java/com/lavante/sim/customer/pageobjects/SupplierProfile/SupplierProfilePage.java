/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy
 */

package com.lavante.sim.customer.pageobjects.SupplierProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.AdvanceSearch.AdvanceSearchPage;
import com.lavante.sim.customer.pageobjects.BasicSearch.SupplierSearchPage;
import com.lavante.sim.customer.pageobjects.Login.LoginPage;
import com.lavante.sim.Common.Util.*;

public class SupplierProfilePage {
	CustSupViewProfilePage objCustSupViewProfilePage=null;
	SupplierSearchPage objSupplierSearchPage =null;
	LavanteUtils lavanteUtils=new  LavanteUtils();
	LoginPage objLoginPage = null;
	List<setTestData> objAddNewAddressTestData = null;
	List<Integer> arrListOfCount =null;
	Properties props=null;
	String methodName="";
	//Declare web driver
	private WebDriver driver=null;
	/*String 	expProfileDataSavedMsg="",xSupplierWelcomeName="",xSupplierManuTabList="",xProfileMenuTab="",xSupplierNameField="",
			xProfileDataSaveBtn="",xProfileDataSavedSuccessMsg="",xProfileMsgPopupOkBtn="",xProfileTabNamesList="",xProfilePageMandateFieldList="",
			xProfilePageTabIndexNo="",xProfilePageTabBtnPrefix="",xProfilePageTabBtnSuffix="",supplierHomePageTitle="",
			linkTxtProfile="",linkTxtHome="",supplierProfilePageTitle="",xSupplierName="",expProfileSavedPopupsMsg="",IdBtnSaveExit="",
			xBtnOk="",xpathactivatePopupFrame="",xErrorMsg="",xBtnCancel="",xAddNewDrpDwnBtnPrefix="",xAddNewDrpDwnBtnSuffix="",
			xAddNewDrpDwnListSuffix="",IdLeavePopupBtn="",XpatheEditProfileTabTitlesList="",XpathBtnSaveAddress="",IdZipCode="",
			XpathStateDrpDwnList="",XpathStateDrpDwn="",XpathCountryDrpDwnList="",XpathCountryDrpDwn="",IdCityEditField="",
			IdAddress1EditField="",xDepartmentDrpDwn="",xDepartmentDrpDwnEditFld="",xAddressDrpDwnEditFld="",xAddressDrpDwn="",xProfileTab5=""
			,xProfileTabledata="",xProfileSubMenus="",xProfileContactHeaders="",xProfileContactDetails="",xCountryRegNo="",
			xProvinceName="",xBusinessName="",xGstNo="",xQstNo="",txtESignatureHeader="",IdESignatureCheckBox="",xESignaturePopUpHeader="",
			IdEPasswordField="",cssESignatureOkBtn="",xSupplierPageTable="",xProfileTabTableRow="",
			xProfileTabArrowBtn="",xProfileTabArrowVisibleBtn="",uNSPSCPageHeader="",sicPageHeader="",nAICSPageHeader="",
			addNewTableRowUNSPSC="",addNewTableRowSIC="",addNewTableRowNAICS="",xAddNewBtnPopupHeader="",IdCode="",IdDescription="",
			xAddNewBtnSave="",xAddNewYellowBtnPrefix="",xAddNewYellowBtnSuffix="",xCusRefAddNewBtn="",IdReferenceName="",
			IdJobTitle="",IdErpversion="",xERPSystemNameDrpDwn="",xERPSystemNameField="",xAddNewERPBtn="",xToDoListFrame="",
			xCutProfileMenuTab="",xComProfileMenuTab="",xPaymentInfoMenuTab="",xCertificationMenuTab="",xLegalIDMenuTab="",
			IdHeadquartersInfo="",IdLegalIformation="",IdInsuranceInformation="",IdPaymentInfo="",IdContactDetails="",
			tabNameProfile="",tabNameLegalID="",subTabNameYourCompany="",subTabNameCustomerSpecific="",subTabNameEnterpriseOwned="",
			xDoingBusinessAs="",xProfileBtnPrevious="",xProfileBtnNext="",IdServicesMaterialSummary="",xProfileBtnSave="",
			xProfileToDoListlegalIDBtn="",xProfileMenuTabBtnRowList="",xProfileSubMenuTabBtnRowList="",xToDoReqFieldList="",
			xToDoReqFieldInputDataList="",IdHeadQuarterPhone="",xPaymentTypeDrp="",xPaymentTypeDrpList="",IdCheckPaymentDesc="",
			xCurrencyDrpList="",xCurrencyDrp="",xToDoReqFieldHeaderList="",xW9UploadBtn="",xLegalIDInfoHeader="",xW9browseFileBtn="",
			xW9SaveBtn="",xW9CancelBtn="",IdEtfCheckBox="",xAddNewEFTBtn="",IdABANumber="",IdAccountNumber="",IdPayeeName="",
			IdBankName="",IdBranchAddress="",IdCity="",IdPostalCode="",IdCheckBox="",IdSwiftCode="",IdRemittanceEmail="",
			xEFTType="",xCurrency="",xEFTcurrencyDrpList="",xBankCountry="",xBankCountryDrpList="",xStateId="",xStateIdDrpList="",
			xSaveBtn="",xCancelBtn="",xCustomerNameDropDownField="",xCustomerNameDropDownList="",IdProfilePercentage="",
			xProfileCompletenessBtn="",IdSupplierEmail="",xMajorityRadioBtnYes="",xMajorityRadioBtnNo="",xSigInterestRadioBtnYes="",
			xSigInterestRadioBtnNo="",xProductServiceTypeDrpBtn="",xProductServiceTypeDrpList="",xARecContactDrpBtn="",xARecContactDrpList="",
			xBusinessStrDrpBtn="",xBusinessStrDrpBtnList="",IdPaymentInfoType="",xPaymentContractBrowseBtn="",xPaymentContractBtnYes="",
			xPaymentContractBtnNo="",IdLegalIdField="",IdLegalBtnYes="",IdLegalBtnNo="",xAddressReqLabel="",xPhoneReqLabel="",
			xCompanyEmailLabel="",xRemitToLabel="",xOrderFromLabel="",xLegalNoticeLabel="",xPaymentContractRadioBtnYesLabel="",
			xPaymentContractBrowseBtnLabel="",xAccountReceivableContactLabel="",xProductServiceTypeLabel="",xConflictofInterestLabel="",
			xESigatureCompleteLabel="",xBusinessStructureLabel="",xTaxIdentificationLabel="",xMajorityUSOwnershipLabel="",
			IdGoodsRadioBtn="",IdAgreeCheckBox="",IdNameFieldCT="",IdTitleField="",xPaymentTermDrpBtn="",xPaymentTermDrpList="",
			xpathoption="",xpathName="",xpathClose="",xpathselect="",xpathdateRowCount="",xpathmonthDropDownOption="",xpathyearDropDownOption="",
			xDateField="",xDateFieldLabel="",xTitleFieldLabel="",xNameFieldLabel="",xAgreeTermsFieldLabel="",xProductServicesLabel=""
			,xPaymentTermsDrpLabel="",xCompletenessPopupOkBtn="",xAddressDrpDwnList="",upLoadW9File="",xConwayLogo="",xOmnicareLogo="",xGPStrategiesLogo="",
			xToDoListInCompleteProfile="",xToDoListCompleteProfile="",expTextToDoListInComPrfExpMsg="",expTextToDoListComPrfExpMsg="",
			xProfileSummary="",IdClientAvgNo="",xpathlasttab="",idbusinesssalescontact="",xpathbusinesscontactdropdwn="",xpathname="",
			xpathemail="",idvisa="",xpathTabListOfProfile="",IdeditproductsServicesPerformed="";*/

	// Page Objects
	
	String upLoadW9File = ".\\src\\test\\resources\\config\\W-9.pdf";
	
	//Common
	@FindBy(xpath="")
	private WebElement xpathoption;
	
	@FindBy(xpath="//input[@id='contactName']")
	private WebElement xpathName;
	
	@FindBy(xpath="")
	private WebElement sxProductServicesLabel;
	
	@FindBy(xpath="")
	private WebElement xpathClose;
	
	@FindBy(xpath="")
	private WebElement xpathselect;
	
	@FindBy(xpath="")
	private WebElement xpathdateRowCount;
	
	private String xpathTabListOfProfile;

	//Date Field (Common)
	@FindBy(xpath="//div[contains(@id,'ui-datepicker-div')]/div[1]/div[1]/select[1]/option")
	private WebElement xpathmonthDropDownOption;
	
	@FindBy(xpath="//div[contains(@id,'ui-datepicker-div')]/div[1]/div[1]/select[2]/option")
	private WebElement xpathyearDropDownOption;
	
	//@FindBy(xpath="//*[@id='omnicareCustomField10']")
	String xDateField = "//*[@id='omnicareCustomField10']";

	//ID
	String IdeditproductsServicesPerformed = "productsServicesPerformed";
	
	@FindBy(id="productsServicesPerformed")
	private WebElement IdeditproductsServicesPerformed1;
	
	@FindBy(id="gpstrategiesCustomField6")
	private WebElement IdClientAvgNo;
	
	@FindBy(id="omnicareCustomField6")
	private WebElement IdGoodsRadioBtn;
	
	@FindBy(id="omnicareCustomField7")
	private WebElement IdAgreeCheckBox;
	
	@FindBy(id="omnicareCustomField8")
	private WebElement IdNameFieldCT;
	
	@FindBy(id="omnicareCustomField9")
	private WebElement IdTitleField;
	
	@FindBy(id="legalIdentifier_1")
	private WebElement IdLegalIdField;
	
	@FindBy(id="VAT_yes")
	private WebElement IdLegalBtnYes;
	
	@FindBy(id="VAT_no")
	private WebElement IdLegalBtnNo;
	
	String IdPaymentInfoType = "payment_discount_details";
	
	@FindBy(id="supplierEmail")
	private WebElement IdSupplierEmail;
	
	@FindBy(id="etf")
	private WebElement IdEtfCheckBox;
	
	@FindBy(id="routingNumber")
	private WebElement IdABANumber;
	
	@FindBy(xpath="accountNumber")
	private WebElement IdAccountNumber;
	
	@FindBy(id="payeeName")
	private WebElement IdPayeeName;
	
	@FindBy(id="bankName")
	private WebElement IdBankName;
	
	@FindBy(xpath="branchAddress")
	private WebElement IdBranchAddress;
	
	@FindBy(id="city")
	private WebElement IdCity;
	
	@FindBy(id="zip")
	private WebElement IdPostalCode;
	
	@FindBy(id="isDirectDepositAuthorized")
	private WebElement IdCheckBox;
	
	@FindBy(id="swiftCode")
	private WebElement IdSwiftCode;
	
	@FindBy(id="emailAddress1")
	private WebElement IdRemittanceEmail;
	
	@FindBy(id="profile_percentage")
	private WebElement IdProfilePercentage;
	
	@FindBy(xpath="checkPaymentDesc")
	private WebElement IdCheckPaymentDesc;
	
	String IdHeadQuarterPhone = "headQuarterPhone";
	
	@FindBy(id="servicesMaterialSummary")
	private WebElement headQuarterPhone1;
	
	@FindBy(id="servicesMaterialSummary")
	private WebElement IdServicesMaterialSummary ;
	
	String IdHeadquartersInfo = "headquarters_information";

	String IdLegalIformation = "legal_id_information";
	
	String IdInsuranceInformation = "insurance_information";
	
	String IdPaymentInfo = "payment_discount_details";
	
	String IdContactDetails = "contact_details";
	
	@FindBy(id="erpversion")
	private WebElement IdErpversion;
	
	@FindBy(id="referenceName")
	private WebElement IdReferenceName;
	
	@FindBy(id="jobTitle")
	private WebElement IdJobTitle;
	
	@FindBy(id="code")
	private WebElement IdCode;
	
	@FindBy(id="description")
	private WebElement IdDescription;
	
	@FindBy(id="password")
	private WebElement IdEPasswordField;
	
	@FindBy(id="isESigatureComplete")
	private WebElement IdESignatureCheckBox;
	
	@FindBy(id="zipCode")
	private WebElement IdZipCode;
	
	@FindBy(id="saveexit_button")
	private WebElement IdBtnSaveExit;
	
	//CSS
	@FindBy(css="button[class='button button_green'][type='submit']")
	private WebElement cssESignatureOkBtn;
	//Page Header
	String uNSPSCPageHeader ="Add UNSPSC Information";
	String sicPageHeade = "Add SIC Information";
	String nAICSPageHeader = "Add NAICS Information";
	//Exp Text
	String expProfileDataSavedMsg = "";
	//Xpath

	@FindBy(xpath="//textarea[@id='productsServicesPerformedDescription']")
	private WebElement xProfileSummary;
	
	@FindBy(xpath="//*[@class='customer_logo']/img[contains(@src,'conway_logo')]")
	private WebElement xConwayLogo;
	
	@FindBy(xpath="//*[@class='customer_logo']/img[contains(@src,'Omni_Logo')]")
	private WebElement xOmnicareLogo;
	
	@FindBy(xpath="/*[@class='customer_logo']/img[contains(@src,'GPstrategies_Logo')]")
	private WebElement xGPStrategiesLogo;
	

	@FindBy(xpath="//table[@class='data_table table_grid zebra']/tbody/tr/td[1]")
	private WebElement xToDoListCompleteProfile;
	
	@FindBy(xpath="//table[@class='data_table table_grid zebra']/tbody/tr/td[1]/a")
	private WebElement xToDoListInCompleteProfile;
	
	//Properties add completeness
	String xCompletenessPopupOkBtn = "//button[@title='Ok'][@name='Submit'][@class='button button_blue cancel']";
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'headquarterAddressId')]")
	private WebElement xAddressReqLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'headQuarterPhone')]")
	private WebElement xPhoneReqLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'supplierEmail')]")
	private WebElement xCompanyEmailLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'remitToAddressId')]")
	private WebElement xRemitToLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'orderFromAddressId')]")
	private WebElement xOrderFromLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'legalNoticesAddressId')]")
	private WebElement xLegalNoticeLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'omnicareCustomField3')]")
	private WebElement xPaymentContractRadioBtnYesLabel;
	
	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField4')]")
	private WebElement xPaymentContractBrowseBtnLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'accountReceivableContactMap')]")
	private WebElement xAccountReceivableContactLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'productServiceType')]")
	private WebElement xProductServiceTypeLabel;
	
	@FindBy(xpath="//label[contains(@class,'no_lineheight field_required')][contains(@for,'isConflictofInterest')]")
	private WebElement xConflictofInterestLabel;
	
	@FindBy(xpath="//label[contains(@class,'no_lineheight field_required')][contains(@for,'isESigatureComplete')]")
	private WebElement xESigatureCompleteLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'businessStructure')]")
	private WebElement xBusinessStructureLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'tax_identification_number')]")
	private WebElement xTaxIdentificationLabel;
	
	@FindBy(xpath="//label[contains(@class,'field_required')][contains(@for,'isMajorityUSOwnership')]")
	private WebElement xMajorityUSOwnershipLabel;
	
	@FindBy(xpath="//div[@id='omnicareCustomField5_chosen']/a")
	private WebElement xPaymentTermDrpBtn;
	
	String xPaymentTermDrpList;

	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField10')]")
	private WebElement xDateFieldLabel;
	
	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField9')]")
	private WebElement xTitleFieldLabel;
	
	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField8')]")
	private WebElement xNameFieldLabel;
	
	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField7')]")
	private WebElement xAgreeTermsFieldLabel;
	
	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField6')]")
	private WebElement xProductServicesLabel;
	
	@FindBy(xpath="//label[contains(@class,'required_field')][contains(@for,'omnicareCustomField5')]")
	private WebElement xPaymentTermsDrpLabel;

	@FindBy(xpath="//input[1][@id='omnicareCustomField3']")
	private WebElement xPaymentContractBtnYes;
	
	@FindBy(xpath="//input[2][@id='omnicareCustomField3']")
	private WebElement xPaymentContractBtnNo;
	
	@FindBy(xpath="//input[@id='omnicareCustomField4']")
	private WebElement xPaymentContractBrowseBtn;
	
	String  xBusinessStrDrpBtn = "//div[@id='businessStructure_chosen']/a";
	
	@FindBy(xpath="//div[@id='businessStructure_chosen']/a")
	private WebElement xBusinessStrDrpBtn2 ;
	
	@FindBy(xpath="businessStructure_chosen")
	private WebElement xBusinessStrDrpBtnList;
	
	String xARecContactDrpBtn = "//div[@id='accountReceivableContactMap_chosen']/a";
	
	@FindBy(xpath="//div[@id='accountReceivableContactMap_chosen']/div/ul/li")
	private WebElement xARecContactDrpList;
	
	String xProductServiceTypeDrpBtn = "//div[@id='productServiceType_chosen']/a";
	
	@FindBy(xpath="productServiceType_chosen")
	private WebElement xProductServiceTypeDrpList;
	

	@FindBy(xpath="//input[@id='isConflictofInterest'][@value='true']")
	private WebElement xSigInterestRadioBtnYes;
	
	@FindBy(xpath="//input[@id='isConflictofInterest'][@value='false']")
	private WebElement xSigInterestRadioBtnNo;
	
	@FindBy(xpath="//input[@id='isMajorityUSOwnership'][@value='true']")
	private WebElement xMajorityRadioBtnYes;

	String xMajorityRadioBtnNo = "//input[@id='isMajorityUSOwnership'][@value='false']";

	//Properties EFT
	@FindBy(xpath="//div[@id='stateId_chosen']/a")
	private WebElement xStateId;
	
	@FindBy(xpath="//div[@id='stateId_chosen']/div/ul/li")
	private WebElement xStateIdDrpList;
	
	@FindBy(xpath="//button[@class='button button_green'][@type='submit']")
	private WebElement xSaveBtn;
	
	@FindBy(xpath="//button[@class='button button_red cancel'][@title='Cancel']")
	private WebElement xCancelBtn;

	@FindBy(xpath="//div[@class='align_right']/a[@title='Add New ERP Information']")
	private WebElement xAddNewEFTBtn;
	
	@FindBy(xpath="//input[@value='ACH'][@name='eftSubType']")
	private WebElement xEFTType;
	
	@FindBy(xpath="//div[@id='paymentEFTCurrencyID_chosen']/a")
	private WebElement xCurrency;
	
	@FindBy(xpath="//div[@id='paymentEFTCurrencyID_chosen']/div/ul/li")
	private WebElement xEFTcurrencyDrpList;
	
	@FindBy(xpath="//div[@id='countryId_chosen']/a")
	private WebElement xBankCountry;
	
	@FindBy(xpath="//div[@id='countryId_chosen']/div/ul/li")
	private WebElement xBankCountryDrpList;
	
	@FindBy(xpath="//div[@class='complete_profile_component']/input[@class='button_blue'][@value='Complete Company Profile']")
	private WebElement xProfileCompletenessBtn;
	
	@FindBy(xpath="//div[@id='customer_chosen']/a[contains(@class,'chosen-single')]")
	private WebElement xCustomerNameDropDownField;
	
	@FindBy(xpath="//div[@id='customer_chosen']/div[contains(@class,'chosen-drop')]/ul/li")
	private List<WebElement> xCustomerNameDropDownList;
	
	@FindBy(xpath="//*[@id='multipartFile']")
	private WebElement xW9browseFileBtn;
	
	@FindBy(xpath="//input[@type='submit'][@value='Save']")
	private WebElement xW9SaveBtn;
	
	@FindBy(xpath="//input[@class='button button_red cancel'][@title='Cancel']")
	private WebElement xW9CancelBtn;
	
	@FindBy(xpath="//*[@id='legal_id_information']")
	private WebElement xLegalIDInfoHeader;
	
	@FindBy(xpath="//a[@class='button_gold std_margin open_popup'][@name='Add_New']")
	private WebElement xW9UploadBtn;
	
	@FindBy(xpath="//div[@class='trail-container horizontal-tab']/ul/li/a")
	private List<WebElement> xToDoReqFieldHeaderList;
	
	@FindBy(xpath="//div[@id='currency_chosen']/a")
	private WebElement xCurrencyDrp;
	
	@FindBy(xpath="//div[@id='currency_chosen']/div/ul/li")
	private WebElement xCurrencyDrpList;
	
	@FindBy(xpath="//div[@id='preferredPaymentType_chosen']/a")
	private WebElement xPaymentTypeDrp;
	
	String xPaymentTypeDrp1 = "//div[@id='preferredPaymentType_chosen']/a";
	
	String xPaymentTypeDrp2 = "//div[@id='preferredPaymentType_chosen']/a";
	
	@FindBy(xpath="")
	private WebElement xPaymentTypeDrpList;
	
	@FindBy(xpath="")
	private List<WebElement> xToDoReqFieldInputDataList;
	
	@FindBy(xpath="")
	private List<WebElement> xToDoReqFieldList;
	
	@FindBy(xpath="")
	private WebElement xProfileSubMenuTabBtnRowList;
	
	private String xProfileMenuTabBtnRowList;
	
	@FindBy(xpath="")
	private WebElement xProfileToDoListlegalIDBtn;
	
	@FindBy(xpath="")
	private WebElement xProfileBtnSave;
	
	@FindBy(xpath="")
	private WebElement xProfileBtnNext;
	
	@FindBy(xpath="")
	private WebElement xProfileBtnPrevious;
	
	String xDoingBusinessAs;
	
	String xLegalIDMenuTab;
	
	String xCertificationMenuTab;
	
	String xPaymentInfoMenuTab;
	
	String  xCutProfileMenuTab;
	
	String xComProfileMenuTab;
	
	@FindBy(xpath = "")
	private WebElement xAddNewERPBtn;
	
	@FindBy(xpath="")
	private WebElement xERPSystemNameField;
	
	@FindBy(xpath="")
	private WebElement xERPSystemNameDrpDwn;
	
	@FindBy(xpath="")
	private WebElement xCusRefAddNewBtn;
	

	String addNewTableRowUNSPSC;
	
	@FindBy(xpath="")
	private WebElement addNewTableRowSIC;
	
	String addNewTableRowNAICS;
	
	@FindBy(xpath="")
	private WebElement xAddNewYellowBtnPrefix;
	
	@FindBy(xpath="")
	private WebElement xAddNewYellowBtnSuffix;
	
	@FindBy(xpath="")
	private WebElement xAddNewBtnSave;
	@FindBy(xpath="")
	private WebElement xAddNewBtnPopupHeader;
	
	@FindBy(xpath="")
	private WebElement xSupplierPageTable;
	
	@FindBy(xpath="")
	private WebElement xProfileTabTableRow;
	
	private String xProfileTabArrowBtn;
	
	@FindBy(xpath="")
	private WebElement xProfileTabArrowVisibleBtn;
	
	@FindBy(xpath="")
	private WebElement xESignaturePopUpHeader;
	
	@FindBy(xpath="")
	private WebElement IdAddress1EditField;
	
	@FindBy(xpath="")
	private WebElement IdCityEditField;
	
	@FindBy(xpath="")
	private WebElement XpathCountryDrpDwn;
	
	@FindBy(xpath="")
	private WebElement XpathCountryDrpDwnList;
	
	@FindBy(xpath="")
	private WebElement XpathStateDrpDwn;
	
	@FindBy(xpath="")
	private WebElement XpathStateDrpDwnList;
	
	@FindBy(xpath="")
	private WebElement xBtnCancel;
	
	@FindBy(xpath="")
	private WebElement xErrorMsg;
	
	@FindBy(xpath="")
	private WebElement xBtnOk;
	
	String  xSupplierName;
	
	String xSupplierWelcomeName;
	
	@FindBy(xpath="")
	private WebElement xSupplierManuTabList;
	
	@FindBy(xpath="")
	private WebElement xProfileMenuTab;
	
	@FindBy(xpath="")
	private WebElement xSupplierNameField;
	
	@FindBy(xpath="")
	private WebElement xProfileDataSaveBtn;
	
	@FindBy(xpath="")
	private WebElement xProfileDataSavedSuccessMsg;
	
	@FindBy(xpath="")
	private WebElement xProfileMsgPopupOkBtn;
	
	String xProfileTabNamesList = "";
	
	String  xProfilePageMandateFieldList;
	
	@FindBy(xpath="")
	private WebElement xProfilePageTabIndexNo;
	
	private String xProfilePageTabBtnPrefix;
	
	@FindBy(xpath="")
	private WebElement xProfilePageTabBtnSuffix;
	
	@FindBy(xpath="")
	private WebElement xpathactivatePopupFrame;
	
	@FindBy(xpath="")
	private WebElement XpatheEditProfileTabTitlesList;
	
	@FindBy(xpath="")
	private WebElement XpathBtnSaveAddress;
	
	@FindBy(xpath="")
	private WebElement xDepartmentDrpDwn;
	
	@FindBy(xpath="")
	private WebElement xDepartmentDrpDwnEditFld;
	
	@FindBy(xpath="")
	private WebElement xAddressDrpDwnEditFld;
	
	@FindBy(xpath="")
	private WebElement xAddressDrpDwn;
	
	@FindBy(xpath="")
	private WebElement xAddressDrpDwnList;

	String xpathlasttab;
	
	@FindBy(xpath="")
	private WebElement idbusinesssalescontact;
	
	@FindBy(xpath="")
	private WebElement xpathbusinesscontactdropdwn;
	
	@FindBy(xpath="")
	private WebElement xpathname;
	
	@FindBy(xpath="")
	private WebElement xpathemail;
	
	@FindBy(xpath="")
	private WebElement idvisa;
	
	@FindBy(xpath="")
	private WebElement xProfileTab5;
	
	@FindBy(xpath="")
	private WebElement xProfileTabledata;
	
	String xProfileSubMenus;
	
	String xProfileContactHeaders;

	String xProfileContactDetails;
	
	@FindBy(xpath="")
	private WebElement xCountryRegNo;
	
	@FindBy(xpath="")
	private WebElement xProvinceName;
	
	@FindBy(xpath="")
	private WebElement xBusinessName;
	
	@FindBy(xpath="")
	private WebElement xGstNo;
	
	@FindBy(xpath="")
	private WebElement xQstNo;
	
	@FindBy(xpath="")
	private WebElement xToDoListFrame;
	
	//Page Titles
	String supplierHomePageTitle = "Lavante SIM - Home";
	String supplierProfilePageTitle = "Lavante SIM - Profile";
	
	//Link Texts
	@FindBy(linkText="")
	private WebElement linkTxtProfile;
	
	@FindBy(linkText="")
	private WebElement linkTxtHome;
	
	String expProfileSavedPopupsMsg;
	
	@FindBy(xpath="")
	private WebElement xAddNewDrpDwnBtnPrefix;
	
	@FindBy(xpath="")
	private WebElement xAddNewDrpDwnBtnSuffix;
	
	@FindBy(xpath="")
	private WebElement xAddNewDrpDwnListSuffix;
	
	@FindBy(id="")
	private WebElement IdLeavePopupBtn;
	
	String txtESignatureHeader;

	
	// Exp Text comparing Msg
	String expTextToDoListInComPrfExpMsg = "";
	String expTextToDoListComPrfExpMsg = "";
	
	//text values
	String tabNameProfile = "Profile";
	String tabNameLegalID = "Legal ID";
	String subTabNameYourCompany = "(Your Company)";
	String subTabNameCustomerSpecific = "(Customer Specific)";
	String subTabNameEnterpriseOwned = "(Enterprise Owned)";

	
	
	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	public SupplierProfilePage(WebDriver driver) {
		/*try {
			//initialize properties
			props=lavanteUtils.getPropertiesValues(ConfigPathFile.SupplierPropsFile.getConstantValue());		

			//uploadFile
			upLoadW9File=props.getProperty("upLoadW9File");
			//Common
			xpathoption=props.getProperty("rowClose");
			xpathName=props.getProperty("columnNumber");
			xpathClose=props.getProperty("columnClose");
			xpathselect=props.getProperty("rowNumber");
			xpathdateRowCount=props.getProperty("dateRowCount");
			xpathTabListOfProfile=props.getProperty("tabListOfProfile");

			//Date Field (Common)
			xpathmonthDropDownOption=props.getProperty("monthDropDownOption");
			xpathyearDropDownOption=props.getProperty("yearDropDownOption");
			xDateField=props.getProperty("dateField");

			//ID
			IdeditproductsServicesPerformed=props.getProperty("editproductsServicesPerformed");
			IdClientAvgNo=props.getProperty("clientAvgNo");
			IdGoodsRadioBtn=props.getProperty("goodsRadioBtn");
			IdAgreeCheckBox=props.getProperty("agreeCheckBox");
			IdNameFieldCT=props.getProperty("nameFieldCT");
			IdTitleField=props.getProperty("titleField");

			IdLegalIdField=props.getProperty("legalIdField");
			IdLegalBtnYes=props.getProperty("legalBtnYes");
			IdLegalBtnNo=props.getProperty("legalBtnNo");
			IdPaymentInfoType=props.getProperty("paymentInfoType");
			IdSupplierEmail=props.getProperty("supplierEmail");
			IdEtfCheckBox=props.getProperty("etfCheckBox");
			IdABANumber=props.getProperty("aBANumber");
			IdAccountNumber=props.getProperty("accountNumber");
			IdPayeeName=props.getProperty("payeeName");
			IdBankName=props.getProperty("bankName");
			IdBranchAddress=props.getProperty("branchAddress");
			IdCity=props.getProperty("city");
			IdPostalCode=props.getProperty("postalCode");
			IdCheckBox=props.getProperty("checkBox");
			IdSwiftCode=props.getProperty("swiftCode");
			IdRemittanceEmail=props.getProperty("remittanceEmail");
			IdProfilePercentage=props.getProperty("profilePercentage");
			IdCheckPaymentDesc=props.getProperty("checkPaymentDesc");
			IdHeadQuarterPhone=props.getProperty("headQuarterPhone");
			IdServicesMaterialSummary=props.getProperty("servicesMaterialSummary");
			IdHeadquartersInfo=props.getProperty("headquartersInfo");
			IdLegalIformation=props.getProperty("legalIformation");
			IdInsuranceInformation=props.getProperty("insuranceInformation");
			IdPaymentInfo=props.getProperty("paymentInfo");
			IdContactDetails=props.getProperty("contactDetails");
			IdErpversion=props.getProperty("erpversion");
			IdReferenceName=props.getProperty("referenceName");
			IdJobTitle=props.getProperty("jobTitle");
			IdCode=props.getProperty("code");
			IdDescription=props.getProperty("description");
			IdEPasswordField=props.getProperty("ePasswordField");
			IdESignatureCheckBox=props.getProperty("eSignatureCheckBox");
			IdZipCode=props.getProperty("zipCode");
			IdBtnSaveExit=props.getProperty("btnSaveExit");
			//CSS
			cssESignatureOkBtn=props.getProperty("eSignatureOkBtn");
			//Page Header
			uNSPSCPageHeader=props.getProperty("uNSPSCPageHeader");
			sicPageHeader=props.getProperty("sicPageHeader");
			nAICSPageHeader=props.getProperty("nAICSPageHeader");
			//Exp Text
			expProfileDataSavedMsg=props.getProperty("profileSavedPopupsMsg");	
			//Xpath

			xProfileSummary=props.getProperty("profileSummary");
			xConwayLogo=props.getProperty("conwayLogo");
			xOmnicareLogo=props.getProperty("omnicareLogo");
			xGPStrategiesLogo=props.getProperty("gpStrategiesLogo");

			xToDoListCompleteProfile=props.getProperty("toDoListCompleteProfile");
			xToDoListInCompleteProfile=props.getProperty("toDoListInCompleteProfile");



			//Properties add completeness
			xCompletenessPopupOkBtn=props.getProperty("completenessPopOkBtn");
			xAddressReqLabel=props.getProperty("addressReqLabel");
			xPhoneReqLabel=props.getProperty("phoneReqLabel");
			xCompanyEmailLabel=props.getProperty("companyEmailLabel");
			xRemitToLabel=props.getProperty("remitToLabel");
			xOrderFromLabel=props.getProperty("orderFromLabel");
			xLegalNoticeLabel=props.getProperty("legalNoticeLabel");
			xPaymentContractRadioBtnYesLabel=props.getProperty("paymentContractRadioBtnYesLabel");
			xPaymentContractBrowseBtnLabel=props.getProperty("paymentContractBrowseBtnLabel");
			xAccountReceivableContactLabel=props.getProperty("accountReceivableContactLabel");
			xProductServiceTypeLabel=props.getProperty("productServiceTypeLabel");
			xConflictofInterestLabel=props.getProperty("conflictofInterestLabel");
			xESigatureCompleteLabel=props.getProperty("eSigatureCompleteLabel");
			xBusinessStructureLabel=props.getProperty("businessStructureLabel");
			xTaxIdentificationLabel=props.getProperty("taxIdentificationLabel");
			xMajorityUSOwnershipLabel=props.getProperty("majorityUSOwnershipLabel");
			xPaymentTermDrpBtn=props.getProperty("paymentTermDrpBtn");
			xPaymentTermDrpList=props.getProperty("paymentTermDrpList");

			xDateFieldLabel=props.getProperty("dateFieldLabel");
			xTitleFieldLabel=props.getProperty("titleFieldLabel");
			xNameFieldLabel=props.getProperty("nameFieldLabel");
			xAgreeTermsFieldLabel=props.getProperty("agreeTermsFieldLabel");
			xProductServicesLabel=props.getProperty("productServicesLabel");
			xPaymentTermsDrpLabel=props.getProperty("paymentTermsDrpLabel");



			xPaymentContractBtnYes=props.getProperty("paymentContractBtnYes");
			xPaymentContractBtnNo=props.getProperty("paymentContractBtnNo");
			xPaymentContractBrowseBtn=props.getProperty("paymentContractBrowseBtn");

			xBusinessStrDrpBtn=props.getProperty("businessStrDrpBtn");
			xBusinessStrDrpBtnList=props.getProperty("businessStrDrpList");

			xARecContactDrpBtn=props.getProperty("aRecContactDrpBtn");
			xARecContactDrpList=props.getProperty("aRecContactDrpList");

			xProductServiceTypeDrpBtn=props.getProperty("productServiceTypeDrpBtn");
			xProductServiceTypeDrpList=props.getProperty("productServiceTypeDrpList");

			xSigInterestRadioBtnYes=props.getProperty("sigInterestRadioBtnYes");
			xSigInterestRadioBtnNo=props.getProperty("sigInterestRadioBtnNo");

			xMajorityRadioBtnYes=props.getProperty("majorityRadioBtnYes");
			xMajorityRadioBtnNo=props.getProperty("majorityRadioBtnNo");

			//Properties EFT
			xStateId=props.getProperty("stateId");
			xStateIdDrpList=props.getProperty("stateIdDrpList");
			xSaveBtn=props.getProperty("saveBtn");
			xCancelBtn=props.getProperty("cancelBtn");

			xAddNewEFTBtn=props.getProperty("addNewEFTBtn");
			xEFTType=props.getProperty("eFTType");
			xCurrency=props.getProperty("currency");
			xEFTcurrencyDrpList=props.getProperty("eFTcurrencyDrpList");
			xBankCountry=props.getProperty("bankCountry");	
			xBankCountryDrpList=props.getProperty("bankCountryDrpList");

			xProfileCompletenessBtn=props.getProperty("profileCompletenessBtn");
			xCustomerNameDropDownField=props.getProperty("customerNameDropDownField");
			xCustomerNameDropDownList=props.getProperty("customerNameDropDownList");
			xW9browseFileBtn=props.getProperty("w9browseFileBtn");
			xW9SaveBtn=props.getProperty("w9SaveBtn");
			xW9CancelBtn=props.getProperty("w9CancelBtn");
			xLegalIDInfoHeader=props.getProperty("legalIDInfoHeader");
			xW9UploadBtn=props.getProperty("w9UploadBtn");
			xToDoReqFieldHeaderList=props.getProperty("toDoReqFieldHeaderList");
			xCurrencyDrp=props.getProperty("currencyDrp");
			xCurrencyDrpList=props.getProperty("currencyDrpList");
			xPaymentTypeDrp=props.getProperty("paymentTypeDrp");
			xPaymentTypeDrpList=props.getProperty("paymentTypeDrpList");
			xToDoReqFieldInputDataList=props.getProperty("toDoReqFieldInputDataList");
			xToDoReqFieldList=props.getProperty("toDoReqFieldList");
			xProfileSubMenuTabBtnRowList=props.getProperty("profileSubMenuTabBtnRowList");
			xProfileMenuTabBtnRowList=props.getProperty("profileMenuTabBtnRowList");
			xProfileToDoListlegalIDBtn=props.getProperty("profileToDoListlegalIDBtn");
			xProfileBtnSave=props.getProperty("profileBtnSave");
			xProfileBtnNext=props.getProperty("profileBtnNext");
			xProfileBtnPrevious=props.getProperty("profileBtnPrevious");
			xDoingBusinessAs=props.getProperty("doingBusinessAs");
			xLegalIDMenuTab=props.getProperty("legalIDMenuTab");
			xCertificationMenuTab=props.getProperty("certificationMenuTab");
			xPaymentInfoMenuTab=props.getProperty("paymentInfoMenuTab");
			xCutProfileMenuTab=props.getProperty("cutProfileMenuTab");
			xComProfileMenuTab=props.getProperty("comProfileMenuTab");
			xAddNewERPBtn=props.getProperty("addNewERPBtn");
			xERPSystemNameField=props.getProperty("eRPSystemNameField");
			xERPSystemNameDrpDwn=props.getProperty("eRPSystemNameDrpDwn");
			xCusRefAddNewBtn=props.getProperty("cusRefAddNewBtn");
			addNewTableRowUNSPSC=props.getProperty("addNewTableRowUNSPSC");
			addNewTableRowSIC=props.getProperty("addNewTableRowSIC");
			addNewTableRowNAICS=props.getProperty("addNewTableRowNAICS");
			xAddNewYellowBtnPrefix=props.getProperty("addNewYellowBtnPrefix");
			xAddNewYellowBtnSuffix=props.getProperty("addNewYellowBtnSuffix");
			xAddNewBtnSave=props.getProperty("addNewBtnSave");
			xAddNewBtnPopupHeader=props.getProperty("addNewBtnPopupHeader");
			xSupplierPageTable=props.getProperty("supplierPageTable");
			xProfileTabTableRow=props.getProperty("profileTabTableRow");
			xProfileTabArrowBtn=props.getProperty("profileTabArrowBtn");
			xProfileTabArrowVisibleBtn=props.getProperty("profileTabArrowVisibleBtn");
			xESignaturePopUpHeader=props.getProperty("eSignaturePopUpHeader");
			IdAddress1EditField=props.getProperty("address1EditField");
			IdCityEditField=props.getProperty("cityEditField");
			XpathCountryDrpDwn=props.getProperty("countryDrpDwn");
			XpathCountryDrpDwnList=props.getProperty("countryDrpDwnList");
			XpathStateDrpDwn=props.getProperty("stateDrpDwn");
			XpathStateDrpDwnList=props.getProperty("stateDrpDwnList");
			xBtnCancel=props.getProperty("btnCancel");
			xErrorMsg=props.getProperty("errorMsg");
			xBtnOk=props.getProperty("btnOk");
			xSupplierName=props.getProperty("supplierName");
			xSupplierWelcomeName=props.getProperty("supplierWelcomeName");
			xSupplierManuTabList=props.getProperty("supplierManuTabList");
			xProfileMenuTab=props.getProperty("profileMenuTab");
			xSupplierNameField=props.getProperty("supplierNameField");
			xProfileDataSaveBtn=props.getProperty("profileDataSaveBtn");
			xProfileDataSavedSuccessMsg=props.getProperty("profileDataSavedSuccessMsg");
			xProfileMsgPopupOkBtn=props.getProperty("profileMsgPopupOkBtn");
			xProfileTabNamesList=props.getProperty("profileTabNamesList");
			xProfilePageMandateFieldList=props.getProperty("profilePageMandateFieldList");
			xProfilePageTabIndexNo=props.getProperty("profilePageTabIndexNo");
			xProfilePageTabBtnPrefix=props.getProperty("profilePageTabBtnPrefix");
			xProfilePageTabBtnSuffix=props.getProperty("profilePageTabBtnSuffix");
			xpathactivatePopupFrame=props.getProperty("activatePopupFrame");
			XpatheEditProfileTabTitlesList=props.getProperty("editProfileTabTitlesList");
			XpathBtnSaveAddress=props.getProperty("btnSaveAddress");
			xDepartmentDrpDwn=props.getProperty("departmentDrpDwn");
			xDepartmentDrpDwnEditFld=props.getProperty("departmentDrpDwnEditFld");
			xAddressDrpDwnEditFld=props.getProperty("addressDrpDwnEditFld");
			xAddressDrpDwn=props.getProperty("addressDrpDwn");
			xAddressDrpDwnList=props.getProperty("addressDrpDwnList");

			xpathlasttab=props.getProperty("lasttab");
			idbusinesssalescontact=props.getProperty("businesssalescontact");
			xpathbusinesscontactdropdwn=props.getProperty("businesscontactdropdwn");
			xpathname=props.getProperty("name");
			xpathemail=props.getProperty("email");
			idvisa=props.getProperty("visa");

			xProfileTab5=props.getProperty("profileTab5");
			xProfileTabledata=props.getProperty("profileTabledata");
			xProfileSubMenus=props.getProperty("profileSubMenus");
			xProfileContactHeaders=props.getProperty("profileContactHeaders");
			xProfileContactDetails=props.getProperty("profileContactDetails");
			xCountryRegNo=props.getProperty("countryRegNo");
			xProvinceName=props.getProperty("provinceName");
			xBusinessName=props.getProperty("businessName");
			xGstNo=props.getProperty("gstNo");
			xQstNo=props.getProperty("qstNo");
			xToDoListFrame=props.getProperty("toDoListFrame");

			//Page Titles
			supplierHomePageTitle=props.getProperty("supplierHomePageTitle");
			supplierProfilePageTitle=props.getProperty("supplierProfilePageTitle");
			//Link Texts
			linkTxtProfile=props.getProperty("profile");
			linkTxtHome=props.getProperty("home");
			expProfileSavedPopupsMsg=props.getProperty("profileSavedPopupsMsg");
			xAddNewDrpDwnBtnPrefix=props.getProperty("addNewDrpDwnBtnPrefix");
			xAddNewDrpDwnBtnSuffix=props.getProperty("addNewDrpDwnBtnSuffix");
			xAddNewDrpDwnListSuffix=props.getProperty("addNewDrpDwnListSuffix");
			IdLeavePopupBtn=props.getProperty("leavePopupBtn");
			txtESignatureHeader=props.getProperty("eSignatureHeader");
			//text values
			tabNameProfile=props.getProperty("tabNameProfile");
			tabNameLegalID=props.getProperty("tabNameLegalID");
			subTabNameYourCompany=props.getProperty("subTabNameYourCompany");
			subTabNameCustomerSpecific=props.getProperty("subTabNameCustomerSpecific");
			subTabNameEnterpriseOwned=props.getProperty("subTabNameEnterpriseOwned");
			// Exp Text comparing Msg
			expTextToDoListInComPrfExpMsg=props.getProperty("toDoListInComPrfExpMsg");
			expTextToDoListComPrfExpMsg=props.getProperty("toDoListComPrfExpMsg");

			this.driver = driver;
		} catch (Exception e)  {						
			//log.severe("Exception in the method SupplierProfilePage due to:  "+  e.getMessage());	

		}*/
	}

	/**
	 * Method Name : assertSupplierHomePage
	 * Purpose: Method to assertSupplierHomePage
	 * @param: None
	 * @return: None
	 */
	public void assertSupplierHomePageTitle(){
		lavanteUtils.assertPageTitle(supplierHomePageTitle);
		Reporter.log("Supplier home verification is done successfully");
	}
	/**
	 * Method Name : naviagteToProfilePage
	 * Purpose: Method to naviagteToProfilePage
	 * @param: None
	 * @return: None
	 */
	public void navigateToProfilePage(){
		lavanteUtils.click("linkTxtProfile",linkTxtProfile);
		Reporter.log("Clicked on the link text 'Profile ' successfully ");
		lavanteUtils.waitForTime(1500);
		lavanteUtils.assertPageTitle(supplierProfilePageTitle);
		Reporter.log(" Successfully navigated to Supplier Profile Page ");
	}

	public void navigateToHomePage(){
		lavanteUtils.click(linkTxtHome);
		Reporter.log("Clicked on the link text 'Home ' successfully ");
		lavanteUtils.waitForTime(1500);
		lavanteUtils.assertPageTitle(supplierHomePageTitle);
		Reporter.log("Supplier home verification is done successfully");
	}


	/**
	 * Method Name : clickCompleteComProfile
	 * Purpose: Method to naviagteToProfilePage
	 * @param: None
	 * @return: None
	 */
	public void clickCompleteComProfile(){
		lavanteUtils.click("xProfileCompletenessBtn",xProfileCompletenessBtn);
		Reporter.log("Successfully gp.clicks on Profile Completeness Button");
		lavanteUtils.waitForTime(1500);
		Reporter.log("Successfully navigated to Supplier Profile Page");
	}


	/**
	 * Method Name : naviagteToProfilePage
	 * Purpose: Method to naviagteToProfilePage
	 * @param: None
	 * @return: None
	 */
	public void naviagteToViewProfilePage(){
		lavanteUtils.click(driver.findElement(By.linkText("View Profile")));
		lavanteUtils.waitForTime(1500);
		if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame)){
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileSubMenus);
			Reporter.log("Successfully navigated to Supplier's View Profile Page");
		}
	}
	/**
	 * Method Name : validateSupProfileRequiredFields
	 * Purpose: Method to verify the star mark fields names
	 * @param:  List objListOfRequiredData
	 * @return: None
	 */
	public void validateSupProfileRequiredFields(List <setTestData> objListOfRequiredData){
		Reporter.log("\n");
		try {
			List<String> rtnExpReqFieldNames =null;
			for(int i=0;i<objListOfRequiredData.size();i++){
				rtnExpReqFieldNames = listExpTextValues(objListOfRequiredData.get(i).getExpFieldLabelNames().toString(),",");
			}
			//slavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierManuTabList);
			//clickOnProfileTabsByName(objListOfRequiredData.get(0).getTabNames().toString(),xSupplierName);
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfilePageMandateFieldList);
		 	List< WebElement> listOfRequireds=driver.findElements(By.xpath(xProfilePageMandateFieldList));
			for (int k = 0; k < rtnExpReqFieldNames.size(); k++) {
				for (int j = 0; j < listOfRequireds.size(); j++){
					if (listOfRequireds.get(j).getText().toString().contains(rtnExpReqFieldNames.get(k).toString())){
						Reporter.log("Expected Supplier Profile RequiredField Name: { "+ (rtnExpReqFieldNames.get(k).toString()	+ " } is matched with actual Supplier Profile RequiredField Name: { " + listOfRequireds.get(j).getText().toString()+" }"));
						break;
					} else {
						if (j + 1 == listOfRequireds.size()) {
							//log.severe("Expected Supplier Profile RequiredField Name: { "+ (rtnExpReqFieldNames.get(k).toString()	+ " } is not matched with actual Supplier Profile RequiredField Name: { " + listOfRequireds.get(j).gp.getText().toString()+" }"));
							lavanteUtils.takeScreenshot(driver,methodName);
							Assert.assertTrue(false," Test is failed due to expected Supplier Profile RequiredField Name: { "+ (rtnExpReqFieldNames.get(k).toString()	+ " } is not matched with actual Supplier Profile RequiredField Name: { " + listOfRequireds.get(j).getText().toString()+" }"));
						}
					}

				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method validateSupProfileRequiredFields due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateSupProfileRequiredFields due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : verifyProfilePageTabs
	 * Purpose: Method to verify the names of the profile tab
	 * @param:  List objListOfRequiredData
	 * @return: None
	 */
	public void verifyProfilePageTabs(List <setTestData> objListOfRequiredData){
		Reporter.log("\n");
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		try {
			List<String> rtnListOfExpTextValues =null;
			for(int i=0;i<objListOfRequiredData.size();i++){
				rtnListOfExpTextValues = listExpTextValues(objListOfRequiredData.get(i).getExpProfileTabList().toString(),",");
			}
			lavanteUtils.fluentwait(driver.findElement(By.xpath(xProfileTabNamesList)));
			List< WebElement> listOfProfilePageTabs=driver.findElements(By.xpath(xProfileTabNamesList));
			for (int k = 0; k < rtnListOfExpTextValues.size(); k++) {
				for (int j = 0; j < listOfProfilePageTabs.size(); j++){

					if (rtnListOfExpTextValues.get(k).toString().equalsIgnoreCase(listOfProfilePageTabs.get(j).getText().toString())){
						Reporter.log("Expected Supplier Profile Tab Name: { "+ (rtnListOfExpTextValues.get(k).toString()	+ " } is matched with actual Supplier Profile Tab Name : { " + listOfProfilePageTabs.get(j).getText().toString() +" }"));
						break;
					} else {
						if (j + 1 == listOfProfilePageTabs.size()){
							//log.severe("Test is failed due to expected Supplier Profile Tab Name: { "+ (rtnListOfExpTextValues.get(k).toString()	+ " } is not matched with actual Supplier Profile Tab Name : { " + listOfProfilePageTabs.get(j).gp.getText().toString() +" } "));
							lavanteUtils.takeScreenshot(driver,methodName);
							Assert.assertTrue(false,"Test is failed due to expected Supplier Profile Tab Name: { "+ (rtnListOfExpTextValues.get(k).toString()	+ " } is not matched with actual Supplier Profile Tab Name : { " + listOfProfilePageTabs.get(j).getText().toString() +" } "));
						}
					}
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method verifyProfilePageTabs due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyProfilePageTabs due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : isSupplierNameEditable
	 * Purpose: Method to validate supplier name is updated or not
	 * @param: String strExpSupName
	 * @return: None
	 */
	public void isSupplierNameEditable(String strExpSupName){
		Reporter.log("\n");
		try {
			methodName = new Object() {}.getClass().getEnclosingMethod().getName();
			boolean flag=false;
			String actSupName="",updatedSupName="",getActProfileSavedText="",inputSupName="",timeStamp="";
			timeStamp=lavanteUtils.getSystemTimeStamp();
			inputSupName=strExpSupName+timeStamp;
			actSupName=lavanteUtils.getText(driver.findElement(By.xpath(xSupplierWelcomeName)));
			Reporter.log(" Actual supplier name before updation { "+actSupName+" }");
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierManuTabList);

			if(strExpSupName.equalsIgnoreCase(actSupName)){
				flag=true;
				Reporter.log(" Same Supplier name already exist in the system, Please provide the alternate supplier name");
				if(lavanteUtils.isTextFieldEditable(xSupplierNameField, inputSupName)==true){
					Reporter.log("Supplier name text field edited successfully with the new supplier name { "+inputSupName + " }");
				}else {
					Reporter.log("Supplier name text field failed to edit due to the above text field is non editable mode ");
				}
			}else{
				flag=true;
				if(lavanteUtils.isTextFieldEditable( xSupplierNameField, strExpSupName)==true){
					Reporter.log("Supplier name text field edited successfully with the new supplier name { "+strExpSupName + " }");
				}else {
					Reporter.log("Supplier name text field failed to edit due to the above text field is non editable mode ");
				}
			}
			lavanteUtils.waitForTime(1000);
			lavanteUtils.click("xProfileDataSaveBtn",xProfileDataSaveBtn);
			Reporter.log("Clicked on the | Save | Button successfully");
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.verifyElementDisplayed("xProfileDataSavedSuccessMsg",xProfileDataSavedSuccessMsg))
			{
				getActProfileSavedText=lavanteUtils.getText(xProfileDataSavedSuccessMsg);
				lavanteUtils.click(xProfileMsgPopupOkBtn);
				Reporter.log("Clicked on the Pop up | Save | Button successfully");
				if(expProfileDataSavedMsg.equalsIgnoreCase(getActProfileSavedText)){
					Reporter.log(" Supplier Name edited successfully ' " +getActProfileSavedText+" '");
				}else{
					Reporter.log(" Failed to edit supplier Name due to: "+getActProfileSavedText);
				}
			}
			lavanteUtils.waitForTime(5000);
			lavanteUtils.fluentwait(driver.findElement(By.xpath(xSupplierWelcomeName)));
			updatedSupName=lavanteUtils.getText(driver.findElement(By.xpath(xSupplierWelcomeName)));

			if(flag==true){
				if(actSupName.equalsIgnoreCase(updatedSupName)){
					Reporter.log(" Verification failed for the supplier name modification due to supplier name does not updated ");
					lavanteUtils.takeScreenshot(driver, methodName);
					Assert.assertTrue(false,"  Verification failed for the supplier name modification due to supplier name does not updated ");	
				}else{
					Reporter.log("\n");
					Reporter.log(" Actual supplier name after updation { "+updatedSupName+" }");
					Reporter.log("Verification of supplier name modification is done successfully");
				}
			}else{
				Reporter.log("Supplier name not edited ");
			}
		} catch (Exception e) {
			//log.severe("Exception in the method isSupplierNameEditable due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isSupplierNameEditable due to "+e.getMessage());	
		}
	}
	/**
	 * Method Name : listExpTextValues
	 * Purpose: Method to listExpTextValues
	 * @param:  listobjLanguage
	 * @return: None
	 */
	public List<String> listExpTextValues(String objExpData,String splitWith)
	{
		ArrayList<String> listExpData =new ArrayList<String>();
		String expText[]=objExpData.split(splitWith);
		for(int k=0;k<expText.length;k++){
			listExpData.add(expText[k]);
		}
		return listExpData;
	}

	/**
	 * Method Name : clickOnProfileTabsByName
	 * Purpose: Method to verify the names of the profile tab and gp.clicks on the tab
	 * @param:  List objListOfRequiredData
	 * @return: None
	 */
	public void clickOnProfileTabsByName(String strTabName,String expTabTableHeaderElm){
		try {
			methodName = new Object() {}.getClass().getEnclosingMethod().getName();
			jsForRefreshDOM(By.xpath(xProfileTabNamesList));
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileTabNamesList);
			List< WebElement> listOfProfilePageTabNames=driver.findElements(By.xpath(xProfileTabNamesList));
			for (int k = 0; k < listOfProfilePageTabNames.size(); k++)
			{
				if ((listOfProfilePageTabNames.get(k).getText().trim().toString().equalsIgnoreCase(strTabName)))
				{
					int m=k+1;
						lavanteUtils.click(driver.findElement(By.xpath( xProfilePageTabBtnPrefix+m+xProfilePageTabBtnSuffix)));
						Reporter.log("Clicked on the | "+strTabName+" | Tab successfully");
					break;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method verifyProfilePageTabs due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyProfilePageTabs due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : clickOnProfilePageTabsByNbrs
	 * Purpose: Method to verify the names of the profile tab and gp.clicks on the tab
	 * @param: String strTabName,String tabSubName,String expTabTableHeaderElm
	 * @return: None
	 */
	@SuppressWarnings("unused")
	public void clickOnProfilePageTabsByNbrs(String indexNbr,String expTabTableHeaderElm){
		try {
			methodName = new Object() {}.getClass().getEnclosingMethod().getName();
			jsForRefreshDOM(By.xpath(xProfileTabNamesList));
			lavanteUtils.fluentwait(driver.findElement(By.xpath(xProfileTabNamesList)));
			List< WebElement> listOfTabIndex=driver.findElements(By.xpath(xpathTabListOfProfile));
			for (int j = 0; j < listOfTabIndex.size(); j++)
			{
				if (listOfTabIndex.get(j).getText().trim().toString().equalsIgnoreCase(indexNbr))
				{
					int m=j+1;
					if(lavanteUtils.isElementDisplayed(driver.findElement( By.xpath(expTabTableHeaderElm)))==false){
						listOfTabIndex.get(j).click();
						Reporter.log("Clicked on the Tab | "+indexNbr+" |successfully");
					}
					break;
				}else 
					if(j + 1 == listOfTabIndex.size()) {
						Reporter.log("Tab not available");
					}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method clickOnProfilePageTabsByNbrs due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method clickOnProfilePageTabsByNbrs due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : clickOnMenuTabs
	 * Purpose: Method to save the supplier profile details
	 * @param:  String tabName,tabIndex ,expVisibleElm
	 * @return: None
	 */
	public void clickOnMenuTabsByName(String tabName,String expVisibleElm){
		try {
			lavanteUtils.waitForTime(5000);
			driver.switchTo().defaultContent();
			List<WebElement> sizeOfMenuTab=driver.findElements(By.xpath(xProfileMenuTabBtnRowList));
			int size=sizeOfMenuTab.size();
			while (lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(xProfileTabArrowBtn)))==false && size>4){
				lavanteUtils.waitForTime(1000);
				lavanteUtils.click("xProfileTabArrowVisibleBtn",xProfileTabArrowVisibleBtn);
			}
			clickOnProfileTabsByName(tabName,expVisibleElm);
			isLeavePopUpExist();
			lavanteUtils.waitForTime(5000);
		} catch (Exception e) {
			//log.severe("Exception in the method clickOnMenuTabs due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method clickOnMenuTabs due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : clickOnMenuTabs
	 * Purpose: Method to save the supplier profile details
	 * @param:  String tabName,tabIndex ,expVisibleElm
	 * @return: None
	 */
	public void clickOnMenuTabByNbr(String tabIndex,String expVisibleElm){
		try {
			lavanteUtils.waitForTime(5000);
			driver.switchTo().defaultContent();
			List<WebElement> sizeOfMenuTab=driver.findElements(By.xpath(xProfileMenuTabBtnRowList));
			int size=sizeOfMenuTab.size();
			while (lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(xProfileTabArrowBtn)))==false && size>4){
				lavanteUtils.waitForTime(1000);
				lavanteUtils.click("xProfileTabArrowVisibleBtn",xProfileTabArrowVisibleBtn);

			}
			clickOnProfilePageTabsByNbrs(tabIndex,expVisibleElm);
			isLeavePopUpExist();
			lavanteUtils.waitForTime(5000);
		} catch (Exception e) {
			//log.severe("Exception in the method clickOnMenuTabs due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method clickOnMenuTabs due to "+e.getMessage());
		}
	}



	/**
	 * Method Name : verifyDrpDwnCount
	 * Purpose: Method to save the supplier profile details
	 * @param:  List getSupplierProfileList
	 * @return: None
	 */
	void verifyDrpDwnCount(String clickOnDrpDwn, String selectDrpDwnListCount,int actDrpDwnListCount){
		Reporter.log("\n");
		lavanteUtils.waitForTime(2500);
		List<WebElement>list=null;
		int countSavedDrpDwnList=0;
		lavanteUtils.fluentwait(driver.findElement(By.xpath(clickOnDrpDwn)));
		lavanteUtils.click(driver.findElement(By.xpath( clickOnDrpDwn)));
		lavanteUtils.waitForTime(500);
		list=driver.findElements(By.xpath(selectDrpDwnListCount));
		countSavedDrpDwnList=list.size();
		Reporter.log("Drop Down List Count after add new option  : "+countSavedDrpDwnList);
		if(countSavedDrpDwnList==actDrpDwnListCount){
			Reporter.log(" Verification failed due to data not added in the system for Add New.. options, drop down list count after save "+countSavedDrpDwnList+" and drop down list count before save "+actDrpDwnListCount);
		}else{
			Reporter.log("Verification is done successfully for Add New.. options, drop down list count after save "+countSavedDrpDwnList+" and drop down list count before save "+actDrpDwnListCount);
		}
		lavanteUtils.click(driver.findElement(By.xpath( clickOnDrpDwn)));
	}

	/**
	 * Method Name : addSupProfileDetailsOfCompany
	 * Purpose: Method to save the supplier profile details
	 * @param:  List getSupplierProfileList
	 * @return: None
	 */

	public void addSupProfileDetailsOfCompany(setTestData getSupplierProfileList){	
		List<WebElement> list=null;
		//arrListOfCount = new ArrayList<>();
		int countDrpDwnList=0;
		String strErrorMsg="";
		//for(int i =0;i<getSupplierProfileList.size();i++)
		//{
		if(getSupplierProfileList.getKeyValue().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue()))
		{
			String clickOn=xAddNewDrpDwnBtnPrefix+getSupplierProfileList.getChosenID().toString()+xAddNewDrpDwnBtnSuffix;
			//String selectDrpDwnList=xAddNewDrpDwnBtnPrefix+getSupplierProfileList.getChosenID().toString()+xAddNewDrpDwnListSuffix;
			String selectDrpDwnList=getSupplierProfileList.getChosenID().toString();
			clickOnMenuTabsByName(getSupplierProfileList.getTabNames().toString(),getSupplierProfileList.getWebElements().trim().toString());
			System.out.println(selectDrpDwnList);
			lavanteUtils.waitForTime(6000);
			lavanteUtils.fluentwait(driver.findElement(By.xpath(clickOn)));
			lavanteUtils.click(driver.findElement(By.xpath( clickOn)));
			lavanteUtils.waitForTime(500);
			list=driver.findElements(By.xpath(selectDrpDwnList));
			countDrpDwnList=list.size();
			Reporter.log("Drop Down List Count before add new option  : "+countDrpDwnList);
			//arrListOfCount.add(countDrpDwnList);
			System.out.println(selectDrpDwnList);
			System.out.println(clickOn);
			//selectDrpDwnList
			driver.findElement(By.xpath(selectDrpDwnList)).click();
			lavanteUtils.selectvalueFrmDpdn(getSupplierProfileList.getUpdatedAddress().trim().toString());
			// need to count the rows 
			Reporter.log("Clicked on the | Add New.. | drop down list successfully");
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			lavanteUtils.typeinEdit(getSupplierProfileList.getAddress().toString(),IdAddress1EditField);
			Reporter.log("Entered  address : "+getSupplierProfileList.getAddress().toString());
			lavanteUtils.typeinEdit(getSupplierProfileList.getCity().toString(),IdCityEditField);
			Reporter.log("Entered  city: " +getSupplierProfileList.getCity().toString());
			lavanteUtils.click("XpathCountryDrpDwn",XpathCountryDrpDwn);
			lavanteUtils.waitForTime(2000);
			//XpathCountryDrpDwnList
			driver.findElement(By.xpath("countryId_chosen")).click();
			lavanteUtils.selectvalueFrmDpdn(getSupplierProfileList.getCountry().toString());
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			Reporter.log("Selected the country: "+getSupplierProfileList.getCountry().toString());
			lavanteUtils.click("XpathStateDrpDwn",XpathStateDrpDwn);
			//gp.switchToFrameBy(driver,"","","");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			//XpathStateDrpDwnList
			driver.findElement(By.xpath("stateId_chosen")).click();
			lavanteUtils.selectvalueFrmDpdn(getSupplierProfileList.getState().toString());
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			Reporter.log("Selected the state as :"+getSupplierProfileList.getState().toString());
			lavanteUtils.typeinEdit(getSupplierProfileList.getPostalCode().trim().toString(),IdZipCode);
			Reporter.log("Entered  postal code"+getSupplierProfileList.getPostalCode().trim().toString());
			lavanteUtils.click("XpathBtnSaveAddress",XpathBtnSaveAddress);
			Reporter.log("Clicked on the | Save | button successfully");
			if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg)){
				lavanteUtils.click("xBtnCancel",xBtnCancel);
				strErrorMsg=lavanteUtils.getText("xErrorMsg",xErrorMsg);
				Assert.assertFalse(true, "Failed due to the exception : "+strErrorMsg);
			}
			lavanteUtils.switchtoFrame(null);
			verifyDrpDwnCount(clickOn, selectDrpDwnList,countDrpDwnList);
			lavanteUtils.waitForTime(1000);
		}else{
			//continue;
		}
		//}
		saveProfileDetailsOfCompany();
	}

	/**
	 * Method Name : addSupProfileDetailsOfCustomer
	 * Purpose: Method to save the supplier profile details
	 * @param:  List getSupplierProfileList
	 * @return: None
	 */
	public void addSupProfileDetailsOfCustomer(List<setTestData> getSupplierProfileList){
		Reporter.log("\n");
		try {
			List<WebElement> list=null;
			//arrListOfCount = new ArrayList<>();
			int countDrpDwnList=0;
			String strErrorMsg="";
			String clickOn="",selectDrpDwnList="";
			for(int i =0;i<getSupplierProfileList.size();i++)
			{
				if(getSupplierProfileList.get(i).getKeyValue().toString().equalsIgnoreCase("yes"))
				{
					clickOn=xAddNewDrpDwnBtnPrefix+getSupplierProfileList.get(i).getChosenID().toString()+xAddNewDrpDwnBtnSuffix;
					selectDrpDwnList=xAddNewDrpDwnBtnPrefix+getSupplierProfileList.get(i).getChosenID().toString()+xAddNewDrpDwnListSuffix;
					clickOnMenuTabByNbr("5", getSupplierProfileList.get(i).getWebElements().trim().toString());
					isLeavePopUpExist();

					lavanteUtils.waitForTime(6000);
					lavanteUtils.click(driver.findElement(By.xpath( clickOn)));
					lavanteUtils.waitForTime(500);
					list=driver.findElements(By.xpath(selectDrpDwnList));
					countDrpDwnList=list.size();
					Reporter.log("Drop Down List Count before add new option  : "+countDrpDwnList);
					lavanteUtils.click(driver.findElement(By.xpath(selectDrpDwnList)));
					lavanteUtils.selectvalueFrmDpdn(getSupplierProfileList.get(i).getUpdatedAddress().trim().toString());
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					Reporter.log("Clicked on the | Add New.. | drop down list successfully");
					lavanteUtils.typeinEdit(getSupplierProfileList.get(i).getContactName().toString(),driver.findElement(By.id("contactName")));
					Reporter.log("Entered  ContactName : "+getSupplierProfileList.get(i).getContactName().toString());
					lavanteUtils.typeinEdit(getSupplierProfileList.get(i).getJobTitle().toString(),driver.findElement(By.id("jobTitle")));
					Reporter.log("Entered JobTitle : "+getSupplierProfileList.get(i).getJobTitle().toString());

					lavanteUtils.click("xDepartmentDrpDwn",xDepartmentDrpDwn);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.typeinEdit(getSupplierProfileList.get(i).getDepartment().toString(),xDepartmentDrpDwnEditFld);
					lavanteUtils.keyTab(xDepartmentDrpDwnEditFld);
					Reporter.log("Selected  Department : "+getSupplierProfileList.get(i).getDepartment().toString());

					/*gp.switchToFrameBy(driver, xpathactivatePopupFrame,ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue());
				gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),xAddressDrpDwn);
				gp.waitForTime(1000);
				gp.switchToFrameBy(driver,"","","");
				gp.typeinEdit(driver, ConfigPathFile.XPATH.getConstantValue(),xAddressDrpDwnEditFld,getSupplierProfileList.get(i).getAddress().trim().toString());
				keyTab(driver, ConfigPathFile.XPATH.getConstantValue(), xAddressDrpDwnEditFld);
				Reporter.log("Selected  Address : "+getSupplierProfileList.get(i).getAddress().toString());*/

					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getSupplierProfileList.get(i).getContactEmail().trim().toString(),driver.findElement(By.id("email")));
					Reporter.log("Entered ContactEmail : "+getSupplierProfileList.get(i).getContactEmail().toString());

					lavanteUtils.click("XpathBtnSaveAddress",XpathBtnSaveAddress);
					Reporter.log("Clicked on the | Save | button successfully");
					if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg)){
						strErrorMsg=lavanteUtils.getText("xErrorMsg",xErrorMsg);
						lavanteUtils.click("xBtnCancel",xBtnCancel);
						Assert.assertFalse(true,"Test failed due to: "+strErrorMsg);
					}
					lavanteUtils.switchtoFrame(null);
					verifyDrpDwnCount(clickOn, selectDrpDwnList,countDrpDwnList);
					lavanteUtils.waitForTime(1000);
				}else{
					continue;
				}
			}
			saveProfileDetailsOfCustomer();
		} catch (Exception e) {
			//log.severe("Exception in the method addSupProfileDetailsOfCustomer due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method addSupProfileDetailsOfCustomer due to : " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifyProfileSuccessPopup
	 * Purpose: method to provide mandate field information 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	void verifyProfileSuccessPopup(){
		try {
			lavanteUtils.waitForTime(6000);
			if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
			{
				jsForRefreshDOM(By.xpath(xCompletenessPopupOkBtn));
				lavanteUtils.click(driver.findElement(By.xpath( xCompletenessPopupOkBtn)));
				Reporter.log("Profile is successfully completed to 100% ");
				lavanteUtils.switchtoFrame(null);
			}else{
				lavanteUtils.waitForTime(1500);
				lavanteUtils.switchtoFrame(null);
			}
		} catch (Exception e) {
			//log.severe("Exception in the method verifyProfileSuccessPopup due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyProfileSuccessPopup due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : saveProfileDetailsOfCustomer
	 * Purpose: Method to save the supplier profile details
	 * @param:  List objListOfRequiredData
	 * @return: None
	 */
	void saveProfileDetailsOfCustomer(){
		try {
			String strErrorMsg="";
			if(lavanteUtils.verifyElementDisplayed("IdBtnSaveExit",IdBtnSaveExit))
				lavanteUtils.click(IdBtnSaveExit);
				Reporter.log("Clicked on the | Save and Exit | button successfully");
				lavanteUtils.click(xProfileDataSaveBtn);
			lavanteUtils.waitForTime(5000);
			verifyProfileSuccessPopup();
			if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg)==true){
				strErrorMsg=lavanteUtils.getText(xErrorMsg);
				Assert.assertFalse(true,"Test failed due to: "+strErrorMsg);
			}else{
				System.out.println("No Error messages found");
			}
		} catch (Exception e) {
			//log.severe("Exception in the method saveProfileDetailsOfCustomer due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method saveProfileDetailsOfCustomer due to : " + e.getMessage());
		}
	}
	/**
	 * Method Name : saveProfileDetailsOfCompany
	 * Purpose: Method to save the supplier profile details
	 * @param:  List objListOfRequiredData
	 * @return: None
	 */
	void saveProfileDetailsOfCompany(){
		try {
			String strErrorMsg="",getActSavedText="",expSavedMsg=expProfileSavedPopupsMsg;
			if(lavanteUtils.verifyElementDisplayed("IdBtnSaveExit",IdBtnSaveExit)){
				lavanteUtils.click("IdBtnSaveExit",IdBtnSaveExit);
				Reporter.log("Clicked on the | Save and Exit | button successfully");
			}else if(lavanteUtils.verifyElementDisplayed("xProfileDataSaveBtn",xProfileDataSaveBtn)){
				lavanteUtils.click("xProfileDataSaveBtn",xProfileDataSaveBtn);
				Reporter.log("Clicked on the | Save | button successfully");
			}
			lavanteUtils.waitForTime(2000);
			if(lavanteUtils.verifyElementDisplayed("xProfileDataSavedSuccessMsg",xProfileDataSavedSuccessMsg)==true){
				getActSavedText=lavanteUtils.getText(xProfileDataSavedSuccessMsg);
				lavanteUtils.click(xBtnOk);
				Reporter.log("Clicked on the | Ok | button successfully");
				if(expSavedMsg.equalsIgnoreCase(getActSavedText)){
					Reporter.log(getActSavedText);
				}else{
					Reporter.log(" Verification failed for add new details for the Supplier ");
				}
			}
			lavanteUtils.waitForTime(3000);
			verifyProfileSuccessPopup();
			lavanteUtils.waitForTime(2000);
			if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg)==true){
				strErrorMsg=lavanteUtils.getText(xErrorMsg);
				Assert.assertFalse(true,"Test failed due to: "+strErrorMsg);
			}
		} catch (Exception e) {
			//log.severe("Exception in the method saveProfileDetailsOfCompany due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method saveProfileDetailsOfCompany due to : " + e.getMessage());
		}
	}
	public void openProfileSubMenu(String expMenuName){
		List<WebElement> menuList=driver.findElements(By.xpath(xProfileSubMenus));
		for(int i=0;i<=menuList.size();i++){
			if(menuList.get(i).getText().toString().equalsIgnoreCase(expMenuName)){
				menuList.get(i).click();
				break;
			}
		}
	}
	/**
	 * Method Name : verifyContactDetails
	 * Purpose: Method to verify the registered supplier registration data in supplier contact page
	 * @param:  List <setTestData> objListOfExpTestData
	 * @return: None
	 */
	public void verifyContactDetails(List <setTestData> objListOfExpTestData){
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		List<String> rtnActContactDetails =new ArrayList<>();
		List<String> rtnExpContactDetails =null;
		List<String> rtnExpContactHeaders =null;
		//return expected contact details
		for(int i=0;i<objListOfExpTestData.size();i++){
			rtnExpContactDetails = listExpTextValues(objListOfExpTestData.get(i).getExpProfileTabList().toString(),",");
		}
		//return expected header details
		for(int i=0;i<objListOfExpTestData.size();i++){
			rtnExpContactHeaders = listExpTextValues(objListOfExpTestData.get(i).getExpFieldLabelNames().toString(),",");
		}
		//List ContactHeaders
		lavanteUtils.waitForTime(2000);
		//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileContactHeaders);
		List< WebElement> actContactHeaders=driver.findElements(By.xpath(xProfileContactHeaders));
		//List ContactDetails
		//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileContactDetails);
		List< WebElement> listOfContactDetails=driver.findElements(By.xpath(xProfileContactDetails));

		if(lavanteUtils.isElementDisplayed(driver.findElement(By.xpath("//table[@class='data_table table_grid zebra']/tbody/tr[@class='data_not_found odd']")))){
			Reporter.log("No Data Found ");
		}else{
			for (int k = 0; k < rtnExpContactHeaders.size(); k++) {
				for (int j = 0; j < actContactHeaders.size(); j++){
					if (actContactHeaders.get(j).getText().trim().toString().equalsIgnoreCase(rtnExpContactHeaders.get(k).trim().toString())){
						rtnActContactDetails.add(listOfContactDetails.get(j).getText().toString());
						Reporter.log("Expected Supplier Profile Contact header { "+ (rtnExpContactHeaders.get(k).toString()	+ " } is matched with the actual Supplier Profile Contact header details: { " + actContactHeaders.get(j).getText().toString()+" }"));
						break;
					} else {
						if (j + 1 == actContactHeaders.size()){
							//log.severe("Expected Supplier Profile Contact header { "+ (rtnExpContactHeaders.get(k).toString()	+ " } is not matched with the actual Supplier Profile Contact header details: { " + actContactHeaders.get(j).gp.getText().toString()+" }"));
							lavanteUtils.takeScreenshot(driver,methodName);
							Assert.assertTrue(false,"Expected Supplier Profile Contact header  { "+ (rtnExpContactHeaders.get(k).toString()	+ " } is not matched with the actual Supplier Profile Contact header details: { " + actContactHeaders.get(j).getText().toString()+" }"));
						}
					}
				}
			}
			//Mapping expected contact details with actual contact details
			for (int e = 0; e < rtnExpContactDetails.size(); e++) {
				for (int a = 0; a < rtnActContactDetails.size(); a++){
					if (rtnExpContactDetails.get(e).toString().equalsIgnoreCase(rtnActContactDetails.get(a).toString())){
						Reporter.log("Expected Supplier Profile Contact details { "+ (rtnExpContactDetails.get(e).toString()	+ " } are matched with the actual Supplier Profile Contact details { " + rtnActContactDetails.get(a).toString()+" }"));
						break;
					} else {
						if (a + 1 == actContactHeaders.size()){
							//log.severe("Expected Supplier Profile Contact details: { "+ (rtnExpContactDetails.get(e).toString()	+ " } are not matched with the actual Supplier Profile Contact details { " + rtnActContactDetails.get(a).toString()+" }"));
							lavanteUtils.takeScreenshot(driver,methodName);
							Assert.assertTrue(false," Test is failed due to expected Supplier Profile Contact details { "+ (rtnExpContactDetails.get(e).toString()	+ " } are not matched with the actual Supplier Profile Contact details { " + rtnActContactDetails.get(a).toString()+" }"));
						}
					}
				}
			}

		}
	}

	/**
	 * Method Name : verifyRegDetailsOfSupProfile
	 * Purpose: Method to verify the registered supplier registration data in supplier specific portal
	 * @param:  String compilerValue, matcherValue
	 * @return: None
	 */
	public void verifyRegDetailsOfSupProfile(List <setTestData> objListOfExpTestData){
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		try {
			String actCountryRegNo="",actProvinceName="",actBusinessName="",actQstNo="",actGstNo="",actNewQstNo="",actNewGstNo="";
			lavanteUtils.waitForTime(2000);
			if(lavanteUtils.verifyElementDisplayed("xCountryRegNo",xCountryRegNo)==true){
				actCountryRegNo=lavanteUtils.getText(xCountryRegNo);
			}
			if(lavanteUtils.verifyElementDisplayed("xProvinceName",xProvinceName)==true){
				actProvinceName=lavanteUtils.getText(xProvinceName);
			}
			if(lavanteUtils.verifyElementDisplayed("xBusinessName",xBusinessName)==true){
				actBusinessName=lavanteUtils.getText(xBusinessName);
			}
			if(lavanteUtils.verifyElementDisplayed("xQstNo",xQstNo)==true){
				actQstNo=lavanteUtils.getText("xQstNo",xQstNo);	
			}
			actNewQstNo=rtnRegExpValue("\\w", actQstNo);
			if(lavanteUtils.verifyElementDisplayed("xGstNo",xGstNo)==true){
				actGstNo=lavanteUtils.getText("xGstNo",xGstNo);
			}
			actNewGstNo=rtnRegExpValue("\\w", actGstNo);
			for(int i=0;i<objListOfExpTestData.size();i++)
			{
				if(objListOfExpTestData.get(i).getCountry().toString().equalsIgnoreCase(actCountryRegNo)&&(!actCountryRegNo.isEmpty())){
					Reporter.log("Expected registered country name { "+objListOfExpTestData.get(i).getCountry().toString() +" } is matched with the actual country name { " +actCountryRegNo+" }");
				}else{
					Reporter.log("Expected registered country name { "+objListOfExpTestData.get(i).getCountry().toString() +" } is not matched with the actual country name { " +actCountryRegNo+" }");
				}

				if(objListOfExpTestData.get(i).getProvince().toString().equalsIgnoreCase(actProvinceName)&&(!actProvinceName.isEmpty())){
					Reporter.log("Expected province name { "+objListOfExpTestData.get(i).getProvince().toString() +" } is matched with the actual province name { " +actProvinceName+" }");
				}else{
					Reporter.log("Expected province name { "+objListOfExpTestData.get(i).getProvince().toString() +" } is not matched with the actual province name { " +actProvinceName+" }");
				}

				if(objListOfExpTestData.get(i).getBusinessName().toString().equalsIgnoreCase(actBusinessName)&&(!actBusinessName.isEmpty())){
					Reporter.log("Expected BusinessName { "+objListOfExpTestData.get(i).getBusinessName().toString() +" } is matched with the actual Business Name  { " +actBusinessName+" }");
				}else{
					Reporter.log("Expected BusinessName { "+objListOfExpTestData.get(i).getBusinessName().toString() +" } is not matched with the actual Business Name { " +actBusinessName+" }");
				}

				if(objListOfExpTestData.get(i).getQst().toString().endsWith(actNewQstNo)&&(!actNewQstNo.isEmpty())){
					Reporter.log("Expected QST number { "+objListOfExpTestData.get(i).getQst().toString() +" } is matched with the actual QST number { " +actNewQstNo+" }");
				}else{
					Reporter.log("Expected QST number { "+objListOfExpTestData.get(i).getQst().toString() +" } is not matched with the actual QST number { " +actNewQstNo+" }");
				}

				if(objListOfExpTestData.get(i).getGst().toString().endsWith(actNewGstNo)&&(!actNewGstNo.isEmpty())){
					Reporter.log("Expected GST number { "+objListOfExpTestData.get(i).getGst().toString() +" } is matched with the actual GST number { "+actNewGstNo+" }");
				}else{  
					Reporter.log("Expected GST number { "+objListOfExpTestData.get(i).getGst().toString() +" } is not matched with the actual GST number { " +actNewGstNo+" }");
				}

			}
		} catch (Exception e) {
			//log.severe("Exception in the method verifyRegDetails due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyRegDetails due to : " + e.getMessage());
		}
	}
	/**
	 * Method Name : rtnRegExpValue
	 * Purpose: Method to return matched string value
	 * @param:  String compilerValue, matcherValue
	 * @return: None
	 */
	public String rtnRegExpValue(String compilerValue,String matcherValue){
		String rtnValue="";
		Pattern pattern = Pattern.compile(compilerValue);
		Matcher matcher = pattern.matcher(matcherValue);
		while (matcher.find()){
			rtnValue+=matcher.group();
		}
		return rtnValue;
	}

	/**
	 * Method Name : editEsignatureField
	 * Purpose: Method to edit eSignature of supplier on pop up page
	 * @param: None
	 * @return: None
	 */
	public void editEsignatureField(String ePassword){
		try {
			WebElement we=null;
			objCustSupViewProfilePage = PageFactory.initElements(driver,CustSupViewProfilePage.class);
			String errorMsgOnPopup="",expPageHeaderName="",actPageHeaderName="";
			lavanteUtils.waitForTime(6000);
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileDataSaveBtn);
			//we = driver.findElement(By.xpath(xProfileDataSaveBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", xProfileDataSaveBtn);
			//clickOncheckBoxBtnByJsExecutor(driver, ConfigPathFile.XPATH.getConstantValue(),"//div[@class='toggle_content std_margin']/p/input[@id='isESigatureComplete'][contains(@class,'e_signature e_signature_static')]");
			lavanteUtils.click(IdESignatureCheckBox);
			Reporter.log("Clicked on the |eSignature| Check Box Sucessfully ");
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.isElementDisplayed(xESignaturePopUpHeader)==true){
				actPageHeaderName=lavanteUtils.getText(xESignaturePopUpHeader);
			}

			if(expPageHeaderName.equalsIgnoreCase(actPageHeaderName)||txtESignatureHeader.equalsIgnoreCase(actPageHeaderName))
			{
				if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
				{
					lavanteUtils.typeinEdit(ePassword,IdEPasswordField);
					Reporter.log("Entered the |Password| Sucessfully ");
					lavanteUtils.click("cssESignatureOkBtn",cssESignatureOkBtn);
					Reporter.log("Clicked on the |Confirm eSignature| Button Sucessfully ");
					if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg))
					{
						errorMsgOnPopup=lavanteUtils.getText(xErrorMsg);
						//log.severe("Test failed due to : "+errorMsgOnPopup );
						objCustSupViewProfilePage.closeSupDetailsPopUpWindow();
						Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
					}
					lavanteUtils.switchtoFrame(null);
				}

			}else{
				//log.severe("Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
				Assert.assertTrue(false,"Test failed due to expected pop up page header : "+txtESignatureHeader +" but found : "+actPageHeaderName);
			}	

		} catch (Exception e) {
			//log.severe("Exception in the method editEsignatureField due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method editEsignatureField due to : " + e.getMessage());
		}
	}
	/**
	 * Method Name : navigateToSupProfileEditPage
	 * Purpose: Method to navigate To Supplier Profile Edit Page
	 * @param: None
	 * @return: None
	 */
	public void navigateToSupProfileEditPage(String supName,String supStatus){
		objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
		objSupplierSearchPage.searchBasicSupplier(supName, "", "", "");
		objSupplierSearchPage.selectFirstSupplierFromList(supStatus);
		objSupplierSearchPage.editSupProfile();
	}
	/**
	 * Method Name : verifyAddNewBtnOperation
	 * Purpose: Method to verifying the AddNew Button Operations in profile's available tabs
	 * @param: None
	 * @return: None
	 */
	public void verifyAddNewBtnOperation(String operation,String strCode,String strDescription)
	{
		clickOnMenuTabsByName(tabNameProfile,xSupplierName);
		lavanteUtils.waitForTime(4000);
		switch (operation) {
		case "UNSPSCCode":
			checkAddNewButtonOperation(uNSPSCPageHeader,uNSPSCPageHeader,strCode,strDescription,addNewTableRowUNSPSC);
			break;
		case "SICCode":
			//checkAddNewButtonOperation(sicPageHeader,sicPageHeader,strCode,strDescription,addNewTableRowSIC);
			break;
		case "NAICSCode":
			checkAddNewButtonOperation(nAICSPageHeader,nAICSPageHeader,strCode,strDescription,addNewTableRowNAICS);
			break;
		case "CusReferences":
			addCusReferencesDetails(strCode,strDescription);
			break;
		case "ERPDetails":
			addERPDetails(strCode,strDescription);
			break;
		default:
			break;
		}
	}
	/**
	 * Method Name : checkAddNewButtonOperation
	 * Purpose: Method to verifying the AddNew Button Operations pop up dialog in profile's available tabs and provide the information
	 * @param: None
	 * @return: None
	 */
	public void checkAddNewButtonOperation(String expPageHeaderName,String addTo,String strCode,String strDescription,String tableRowLocator){
		String btnLocator=addTo,actPopUpHeaderName="",expPageHeaderNullName="",errorMsgOnPopup="";
		lavanteUtils.click(driver.findElement(By.xpath( xAddNewYellowBtnPrefix+btnLocator+xAddNewYellowBtnSuffix)));
		Reporter.log("Clicked on the |AddNew| Button Sucessfully ");
		lavanteUtils.waitForTime(1000);
		actPopUpHeaderName=lavanteUtils.getText(xAddNewBtnPopupHeader);
		if(expPageHeaderName.equalsIgnoreCase(actPopUpHeaderName)||expPageHeaderNullName.equalsIgnoreCase(actPopUpHeaderName))
		{
			if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
			{
				lavanteUtils.typeinEdit( strCode,IdCode);
				Reporter.log("Entered the |Code| Value Sucessfully ");

				lavanteUtils.typeinEdit(strDescription,IdDescription);
				Reporter.log("Entered the |Description| Value Sucessfully ");
				lavanteUtils.click(xAddNewBtnSave);
				Reporter.log("Clicked on the |Save| Button Sucessfully ");

				if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg))
				{
					errorMsgOnPopup=lavanteUtils.getText(xErrorMsg);
					//log.severe("Test failed due to : "+errorMsgOnPopup );
					objCustSupViewProfilePage.closeSupDetailsPopUpWindow();
					Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
				}
			}
			lavanteUtils.switchtoFrame(null);
		}else{
			//log.severe("Test failed due to expected pop up page header : "+expPageHeaderName +" but found : "+actPopUpHeaderName);
			Assert.assertTrue(false,"Test failed due to expected pop up page header : "+expPageHeaderName +" but found : "+actPopUpHeaderName);
		}
		verifyIsDataAdded(strCode,tableRowLocator);
	}
	/**
	 * Method Name : verifyIsDataAdded
	 * Purpose: Method to verify the data is added in table format
	 * @param: None
	 * @return: None
	 */
	public void verifyIsDataAdded(String expInputValue,String tableRowLocator){
		int addedRowSize=0;
		String actInputValue="";
		lavanteUtils.waitForTime(3000);
		List<WebElement> listAddedData=driver.findElements(By.xpath("//table[@id='"+tableRowLocator+"']/tbody/tr"));
		addedRowSize=listAddedData.size();
		actInputValue=lavanteUtils.getText(driver.findElement(By.xpath("//table[@id='"+tableRowLocator+"']/tbody/tr["+addedRowSize+"]/td[1]")));
		if(actInputValue.equalsIgnoreCase("No data available")){
			//log.severe("Test failed due to  "+actInputValue +" in the add new options table");
			Assert.assertTrue(false,"Test failed due to : "+actInputValue +" in the add new options table");
		}else if(actInputValue.equalsIgnoreCase(expInputValue)){
			Reporter.log("Data is added successfully in the system : "+actInputValue);
		}
	}
	/**
	 * Method Name : addCusReferencesDetails
	 * Purpose: Method to verify the data is added in table format
	 * @param: None
	 * @return: None
	 */
	public void addCusReferencesDetails(String strReferenceName,String strJobTitle){
		String expPageHeaderName="Add New Customer References", actPopUpHeaderName="",expPageHeaderNullName="",errorMsgOnPopup="";
		lavanteUtils.click("xCusRefAddNewBtn",xCusRefAddNewBtn);
		Reporter.log("Clicked on the |AddNew| Button Sucessfully ");
		lavanteUtils.waitForTime(1000);
		actPopUpHeaderName=lavanteUtils.getText("xAddNewBtnPopupHeader",xAddNewBtnPopupHeader);
		if(expPageHeaderName.equalsIgnoreCase(actPopUpHeaderName)||expPageHeaderNullName.equalsIgnoreCase(actPopUpHeaderName))
		{
			if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
			{
				lavanteUtils.typeinEdit(strReferenceName,IdReferenceName);
				Reporter.log("Entered the |Code| Value Sucessfully ");
				lavanteUtils.typeinEdit("strJobTitle",IdJobTitle);
				Reporter.log("Entered the |Description| Value Sucessfully ");
				lavanteUtils.click("xAddNewBtnSave",xAddNewBtnSave);
				Reporter.log("Clicked on the |Save| Button Sucessfully ");
				if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg)){
					errorMsgOnPopup=lavanteUtils.getText(xErrorMsg);
					//log.severe("Test failed due to : "+errorMsgOnPopup );
					objCustSupViewProfilePage.closeSupDetailsPopUpWindow();
					Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
				}
			}
			lavanteUtils.switchtoFrame(null);
		}else{
			//log.severe("Test failed due to expected pop up page header : "+expPageHeaderName +" but found : "+actPopUpHeaderName);
			Assert.assertTrue(false,"Test failed due to expected pop up page header : "+expPageHeaderName +" but found : "+actPopUpHeaderName);
		}
		verifyReferenceDataAdded(strReferenceName,"table_customer_references");
	}

	/**
	 * Method Name : verifyReferenceDataAdded
	 * Purpose: Method to verify the data is added in table format
	 * @param: None
	 * @return: None
	 */
	public void verifyReferenceDataAdded(String expInputValue,String tableRowLocator){
		int addedRowSize=0;
		String actInputValue="";
		lavanteUtils.waitForTime(3000);
		List<WebElement> listAddedData=driver.findElements(By.xpath("//table[@id='"+tableRowLocator+"']/tbody/tr"));
		addedRowSize=listAddedData.size();
		actInputValue=lavanteUtils.getText(driver.findElement(By.xpath("//table[@id='"+tableRowLocator+"']/tbody/tr["+addedRowSize+"]/td[2]")));
		if(actInputValue.equalsIgnoreCase("No data available")){
			//log.severe("Test failed due to  "+actInputValue +" in the add new options table");
			Assert.assertTrue(false,"Test failed due to : "+actInputValue +" in the add new options table");
		}else if(actInputValue.equalsIgnoreCase(expInputValue)){
			Reporter.log("Data is added successfully in the system : "+actInputValue);
		}
	}
	/**
	 * Method Name : addERPDetails
	 * Purpose: Method to verify the data is added in table format
	 * @param: None
	 * @return: None
	 */
	public void addERPDetails(String strERPSystemName,String strERPSystemVersion){
		String expPageHeaderName="", actPopUpHeaderName="",expPageHeaderNullName="",errorMsgOnPopup="";

		lavanteUtils.click(xAddNewERPBtn);
		Reporter.log("Clicked on the |AddNew| Button Sucessfully ");
		lavanteUtils.waitForTime(1000);
		actPopUpHeaderName=lavanteUtils.getText(xAddNewBtnPopupHeader);
		if(expPageHeaderName.equalsIgnoreCase(actPopUpHeaderName)||expPageHeaderNullName.equalsIgnoreCase(actPopUpHeaderName))
		{
			lavanteUtils.click(xERPSystemNameField);
			if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
			{

				lavanteUtils.selectDropDownValue( xERPSystemNameDrpDwn, strERPSystemName);
				Reporter.log("Entered the |ERPSystemName| Value selected Sucessfully ");
				lavanteUtils.typeinEdit(strERPSystemVersion,IdErpversion);
				Reporter.log("Entered the |ERPSystemVersion| Value Sucessfully ");
				lavanteUtils.click(xAddNewBtnSave);
				Reporter.log("Clicked on the |Save| Button Sucessfully ");
				if(lavanteUtils.verifyElementDisplayed("xErrorMsg",xErrorMsg))
				{
					errorMsgOnPopup=lavanteUtils.getText(xErrorMsg);
					//log.severe("Test failed due to : "+errorMsgOnPopup );
					objCustSupViewProfilePage.closeSupDetailsPopUpWindow();
					Assert.assertTrue(false,"Test failed due to : "+errorMsgOnPopup );
				}
			}
			lavanteUtils.switchtoFrame(null);
		}else{
			//log.severe("Test failed due to expected pop up page header : "+expPageHeaderName +" but found : "+actPopUpHeaderName);
			Assert.assertTrue(false,"Test failed due to expected pop up page header : "+expPageHeaderName +" but found : "+actPopUpHeaderName);
		}
		verifyReferenceDataAdded(strERPSystemName,"table_erp_information");
	}
	/**
	 * Method Name : openToDoListLinks
	 * Purpose: Method opens the menu tab and verify the expected tab page display
	 * @param: None
	 */
	void openToDoListLinks(String TabNamelocator, String colHeaderlocator,String strOutPutMsg){
		try {

			lavanteUtils.waitForTime(6000);
			if(lavanteUtils.switchtoFrame(xToDoListFrame))
			{
				//gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), TabNamelocator);
				WebElement we=driver.findElement(By.xpath(TabNamelocator));
				lavanteUtils.click(we);
				isLeavePopUpExist();
				lavanteUtils.switchtoFrame(null);
				if(lavanteUtils.isElementDisplayed(driver.findElement( By.id(colHeaderlocator)))==true){
					Reporter.log("Verification is successful for the 'To Do List' "+strOutPutMsg);
				}else{
					Reporter.log("Verification failed for the 'To Do List' "+strOutPutMsg);
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method openToDoListLinks due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method openToDoListLinks due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : clickToDoListReqField
	 * Purpose: Method opens the menu tab and verify the expected tab page display
	 * @param: None
	 */
	void clickToDoListReqField(String TabNamelocator, String colHeaderlocator){
		try {
			lavanteUtils.waitForTime(10000);
			lavanteUtils.switchtoFrame(null);
			if(lavanteUtils.isElementDisplayed(driver.findElement( By.id(colHeaderlocator)))==true){
				Reporter.log("Already we are on the same page ");
			}else{
				if(lavanteUtils.switchtoFrame(xToDoListFrame))
				{
					//gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), TabNamelocator);
					WebElement we=driver.findElement(By.xpath(TabNamelocator));
					lavanteUtils.click(we);
					Reporter.log("Successfully Clicked on |To Do List Menu| Tab");
					isLeavePopUpExist();
					lavanteUtils.switchtoFrame(null);
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method clickToDoListReqField due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method clickToDoListReqField due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : verifyProfileLinkForCompany
	 * Purpose: Method to call the specific methods which verify the links working properly
	 * @param: None
	 * @return: None
	 */
	void verifyProfileLinkForCompany(){
		openToDoListLinks(xComProfileMenuTab,IdHeadquartersInfo,"'Profile (your Company )'");
	}
	/**
	 * Method Name : verifyProfileLinkForLegalID
	 * Purpose: Method to call the specific methods which verify the links working properly
	 * @param: None
	 * @return: None
	 */
	void verifyProfileLinkForLegalID(){
		openToDoListLinks(xLegalIDMenuTab,IdLegalIformation,"'Menu link 'Legal ID'");

	}
	/**
	 * Method Name : verifyProfileLinkForCertification
	 * Purpose: Method to call the specific methods which verify the links working properly
	 * @param: None
	 * @return: None
	 */
	void verifyProfileLinkForCertification(){
		openToDoListLinks(xCertificationMenuTab,IdInsuranceInformation,"'Certification'");

	}
	/**
	 * Method Name : verifyProfileLinkForPaymentInfo
	 * Purpose: Method to call the specific methods which verify the links working properly
	 * @param: None
	 * @return: None
	 */
	void verifyProfileLinkForPaymentInfo(){
		openToDoListLinks(xPaymentInfoMenuTab,IdPaymentInfo,"'Payment Info'");

	}
	/**
	 * Method Name : verifyProfileLinkForCustomer
	 * Purpose: Method to call the specific methods which verify the links working properly
	 * @param: None
	 * @return: None
	 */
	void verifyProfileLinkForCustomer(){
		openToDoListLinks(xCutProfileMenuTab,IdContactDetails,"'Profile (Customer Specific )'");

	}
	/**
	 * Method Name : validateTodoListLinks
	 * Purpose: Method to call the methods which verify the links working properly
	 * @param: None
	 * @return: None
	 */
	public void validateTodoListLinks(){
		verifyProfileLinkForCompany();
		verifyProfileLinkForLegalID();
		verifyProfileLinkForCertification();
		verifyProfileLinkForPaymentInfo();
		verifyProfileLinkForCustomer();
	}
	/**
	 * Method Name : isLeavePopUpExist
	 * Purpose: Method checks is any pop up exists or not, and it close the pop up if exists 
	 * @param: None
	 * @return: None
	 */
	void isLeavePopUpExist(){
		try {
			lavanteUtils.waitForTime(6000);
			if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
			{
				if(lavanteUtils.verifyElementDisplayed("IdLeavePopupBtn",IdLeavePopupBtn)){
					lavanteUtils.click("IdLeavePopupBtn",IdLeavePopupBtn);
					Reporter.log("Clicked on the | Leave this page  | button successfully");
					lavanteUtils.waitForTime(4000);
				}else{
					Reporter.log("Leave This Page| Button Popup does not appear");
				}
				lavanteUtils.switchtoFrame(null);
			}else{
				//log.info(" No Frame Found ");
			}
			lavanteUtils.waitForTime(5000);
		} catch (Exception e) {
			//log.severe("Exception in the method isLeavePopUpExist due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isLeavePopUpExist due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : clickOkBtnOnPopupWindow
	 * Purpose: Method to handle pop up window
	 * @param: None
	 * @return: None
	 */
	void clickOkBtnOnPopupWindow(){
		try {

			String getActProfileSavedText="";
			lavanteUtils.waitForTime(1000);
			if(lavanteUtils.verifyElementDisplayed("xProfileDataSavedSuccessMsg",xProfileDataSavedSuccessMsg))
			{
				getActProfileSavedText=lavanteUtils.getText(xProfileDataSavedSuccessMsg);
				lavanteUtils.click("xProfileMsgPopupOkBtn",xProfileMsgPopupOkBtn);
				Reporter.log("Clicked on the Pop up | Save | Button successfully");
				if(expProfileDataSavedMsg.equalsIgnoreCase(getActProfileSavedText)){
					Reporter.log(" Supplier details saved successfully ' " +getActProfileSavedText+" '");
				}else{
					Reporter.log(" Failed to saved the supplier details due to: "+getActProfileSavedText);
				}
			}else{
				Reporter.log("Pop up window with Ok button appears for save operation ");
			}	
		} catch (Exception e) {
			//log.severe("Exception in the method clickOkBtnOnPopupWindow due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method clickOkBtnOnPopupWindow due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : verifyBtnFunctionality
	 * Purpose: Method used to provide some information in the edit field and gp.clicks on the buttons "save,next,previous"
	 * @param: String locatorForEdit, clickOnBtn,inputValue
	 * @return: None
	 */
	public void verifyBtnFunctionality(String IndentifyBy,String locatorForEdit,String clickOnBtn,String inputValue){
		try {
			lavanteUtils.waitForTime(2000);
			lavanteUtils.typeinEdit(inputValue, driver.findElement(By.xpath(locatorForEdit)));
			Reporter.log("Entered the input data: "+inputValue);
			lavanteUtils.click(driver.findElement(By.xpath( clickOnBtn)));
			Reporter.log("Clicked on the button successfully");
			isLeavePopUpExist();
		} catch (Exception e) {
			//log.severe("Exception in the method verifyBtnFunctionality due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyBtnFunctionality due to "+e.getMessage());
		}
	}
	public void verifySaveBtnFunctionality(WebElement locatorForEdit,WebElement clickOnBtn,String inputValue){
		try {
			lavanteUtils.waitForTime(2000);
			lavanteUtils.typeinEdit(inputValue,locatorForEdit);
			Reporter.log("Entered the input data: "+inputValue);
			lavanteUtils.click(clickOnBtn);
			Reporter.log("Clicked on the button successfully");
			isLeavePopUpExist();
			clickOkBtnOnPopupWindow();
		} catch (Exception e) {
			//log.severe("Exception in the method verifyBtnFunctionality due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyBtnFunctionality due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validateToDoListMenuTab
	 * Purpose: Method to verify the data is saved in the system for the ToDoListMenuTab button operation
	 * @param: String inputData
	 * @return: None
	 */
	public void validateToDoListMenuTab(String inputData){
		try {
			Reporter.log("\n");
			Reporter.log(" 'Save' operation method intiated for the Button 'To Do List Menu' ");
			lavanteUtils.waitForTime(2500);
			clickOnMenuTabsByName(tabNameProfile,xSupplierName);
			lavanteUtils.typeinEdit("IdServicesMaterialSummary",IdServicesMaterialSummary);
			Reporter.log("Entered the input data: "+inputData);
			if(lavanteUtils.switchtoFrame(xToDoListFrame))
			{
				lavanteUtils.click(xProfileToDoListlegalIDBtn);
				Reporter.log("Clicked on the |To Do List Menu | button successfully");
				lavanteUtils.switchtoFrame(null);
				isLeavePopUpExist();
			}
			isDataSaved(inputData,tabNameProfile,subTabNameYourCompany, xSupplierName,ConfigPathFile.ID.getConstantValue(), IdServicesMaterialSummary);
			Reporter.log(" 'Save' operation method completed for the Button 'To Do List Menu' ");
		} catch (Exception e) {
			//log.severe("Exception in the method validateNextBtn due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateNextBtn due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validateSaveBtn
	 * Purpose: Method to verify the data is saved in the system for the save button operation
	 * @param: String inputData
	 * @return: None
	 */
	public void validateSaveBtn(String inputData){
		try {
			Reporter.log("\n");
			Reporter.log(" 'Save' operation method intiated for the Button 'Save' ");
			lavanteUtils.waitForTime(2500);
			clickOnMenuTabsByName(tabNameProfile,xSupplierName);
			verifySaveBtnFunctionality(IdServicesMaterialSummary,xProfileBtnSave,inputData);
			clickOnMenuTabsByName(tabNameLegalID,xDoingBusinessAs);
			isDataSaved(inputData,tabNameProfile,subTabNameYourCompany, xSupplierName,ConfigPathFile.ID.getConstantValue(), IdServicesMaterialSummary);
			Reporter.log(" 'Save' operation method completed for the Button 'Save' ");
		} catch (Exception e) {
			//log.severe("Exception in the method validateNextBtn due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateNextBtn due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validateMenuTab
	 * Purpose: Method to verify the data is saved in the system for the main menu button operation
	 * @param: String inputData
	 * @return: None
	 */
	public void validateMenuTab(String strInputData){
		try {
			Reporter.log("\n");
			Reporter.log(" 'Save' operation method intiated for the Button 'Main Menu' ");
			lavanteUtils.waitForTime(2500);
			clickOnMenuTabsByName(tabNameLegalID, xDoingBusinessAs);
			lavanteUtils.typeinEdit(strInputData, driver.findElement(By.xpath(xDoingBusinessAs)));
			Reporter.log("Entered the input data: "+strInputData);
			clickOnMenuTabsByName(tabNameProfile,xSupplierName);
			//isDataSaved(strInputData,tabNameLegalID,subTabNameYourCompany, xDoingBusinessAs,ConfigPathFile.XPATH.getConstantValue(), xDoingBusinessAs);
			Reporter.log(" 'Save' operation method completed for the Button 'Main Menu' ");
		} catch (Exception e) {
			//log.severe("Exception in the method validateNextBtn due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateNextBtn due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validateNextBtn
	 * Purpose: Method to verify the data is saved in the system for the next button operation
	 * @param: String inputData
	 * @return: None
	 */
	public void validateNextBtn(String inputData){	
		try {
			Reporter.log("\n");
			Reporter.log(" 'Save' operation method intiated for the Button 'Next' ");
			lavanteUtils.waitForTime(2500);
			clickOnMenuTabsByName(tabNameProfile,xSupplierName);
			//verifyBtnFunctionality(ConfigPathFile.ID.getConstantValue(),IdServicesMaterialSummary,xProfileBtnNext, inputData);
			isDataSaved(inputData,tabNameProfile,subTabNameYourCompany, xSupplierName,ConfigPathFile.ID.getConstantValue(), IdServicesMaterialSummary);
			Reporter.log(" 'Save' operation method completed for the Button 'Next' ");
		} catch (Exception e) {
			//log.severe("Exception in the method validateNextBtn due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateNextBtn due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : validatePreviousBtn
	 * Purpose: Method to verify the data is saved in the system for the previous button operation
	 * @param: String inputData
	 * @return: None
	 */
	public void validatePreviousBtn(String inputData){
		try {
			Reporter.log("\n");
			Reporter.log(" 'Save' operation method intiated for the Button 'Previous' ");
			lavanteUtils.waitForTime(2500);
			clickOnMenuTabsByName(tabNameLegalID,xDoingBusinessAs);
			//verifyBtnFunctionality(ConfigPathFile.XPATH.getConstantValue(),xDoingBusinessAs, xProfileBtnPrevious,inputData);
			//isDataSaved(inputData,tabNameLegalID,subTabNameYourCompany, xDoingBusinessAs,ConfigPathFile.XPATH.getConstantValue(),xDoingBusinessAs);
			Reporter.log(" 'Save' operation method completed for the Button 'Previous' ");
		} catch (Exception e) {
			//log.severe("Exception in the method validateNextBtn due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateNextBtn due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : isDataSaved
	 * Purpose: Method to verify the data is saved in the system
	 * @param: String expInputValue, strTabName,strSubTabName,tabLocator,identifyBy,atbLocator
	 * @return: None
	 */
	public void isDataSaved(String expInputValue,String strTabName,String strSubTabName,String tabLocator,String identifyBy,WebElement atbLocator){
		try {
			lavanteUtils.waitForTime(2500);
			Reporter.log("\n");
			String strActValue="";
			clickOnMenuTabsByName(strTabName,tabLocator);
			strActValue=lavanteUtils.getValue( atbLocator,ConfigPathFile.value.getConstantValue());
			if(expInputValue.equalsIgnoreCase(strActValue)){
				Reporter.log("|Data is saved in the system successfully for the Save operation");
			}else {
				Reporter.log("Verification failed for the Save operation and |Data is not saved in the system|");
			}

		} catch (Exception e) {
			//log.severe("Exception in the method isDataSaved due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isDataSaved due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : verifySupplierHomePageDetailsOld
	 * Purpose: Method to verify the supplier home page details and verify the customer specific logo's 
	 * @param: List objTDListForSupplier
	 * @return: None
	 */
	public void verifySupplierHomePageDetailsOld(List<setTestData> objTDListForSupplier){
		int profilePercentage=0;
		String custName="";
		try {
			lavanteUtils.click("xCustomerNameDropDownField", xCustomerNameDropDownField);
			lavanteUtils.waitForTime(500);
			//List<WebElement> drpList=driver.findElements(By.xpath(xCustomerNameDropDownList));
			for(int i=1;i<=xCustomerNameDropDownList.size();i++){
				clickOnHomeLink();
				custName=selectCustomer2(objTDListForSupplier.get(i).getCustomerName().toString(),i);
				verifyCustomerLogo(custName);
				profilePercentage=verifySupplierProfilePercentage();
				if(profilePercentage==100){
					verifyToDoListAppearsForCompleteProfile();
					Reporter.log("Profile completeness status is 100%");
				}else{
					verifyToDoListAppearsForInCompleteProfile();
					Reporter.log("\n");
					Reporter.log("Profile completeness current status is : "+profilePercentage +" % ");
				}
				clickOnProfileLink();
				//verifyCustomerLogoInTabsSpcPage("5", objTDListForSupplier.get(i).getCustomerName().toString());
				//verifyCustomerLogoInTabsSpcPage("4", objTDListForSupplier.get(i).getCustomerName().toString());
				lavanteUtils.waitForTime(1000);
			}
		} catch (Exception e) {
			//log.severe("Exception in the method isDataSaved due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isDataSaved due to "+e.getMessage());
		}


	}
	public void verifySupplierHomePageDetails(List<setTestData> objTDListForSupplier){
		int profilePercentage=0;
		try {
			for(int i=0;i<objTDListForSupplier.size();i++){
				clickOnHomeLink();
				selectCustomer(objTDListForSupplier.get(i).getCustomerName().toString());
				verifyCustomerLogo(objTDListForSupplier.get(i).getCustomerName().toString());
				profilePercentage=verifySupplierProfilePercentage();
				if(profilePercentage==100){
					verifyToDoListAppearsForCompleteProfile();
					Reporter.log("Profile completeness status is 100%");
				}else{
					verifyToDoListAppearsForInCompleteProfile();
					Reporter.log("\n");
					Reporter.log("Profile completeness current status is : "+profilePercentage +" % ");
				}
				clickOnProfileLink();
				verifyCustomerLogoInTabsSpcPage("5", objTDListForSupplier.get(i).getCustomerName().toString());
				verifyCustomerLogoInTabsSpcPage("4", objTDListForSupplier.get(i).getCustomerName().toString());
				lavanteUtils.waitForTime(1000);
			}
		} catch (Exception e) {
			//log.severe("Exception in the method isDataSaved due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isDataSaved due to "+e.getMessage());
		}


	}

	/**
	 * Method Name : verifySuppliersDetailsSaved
	 * Purpose: Method to verify the supplier given data is saved for specific to customer not to other customer
	 * @param: List objTDListForSupplier
	 * @return: None
	 */
	public void verifySuppliersDetailsSaved(List<setTestData> objTDListForSupplier){
		try {
			Reporter.log("\n");
			String inputData="";
			ArrayList<String> arrSaved=new ArrayList<String>();
			ArrayList<String> arrChecked=new ArrayList<String>();
			for(int k=0;k<objTDListForSupplier.size();k++){
				arrSaved.clear();
				arrChecked.clear();
				for(int i=0;i<objTDListForSupplier.size();i++){
					if(objTDListForSupplier.get(i).getCustomerName().trim().toString().equalsIgnoreCase(objTDListForSupplier.get(k).getCustomerName().trim().toString())){
						arrSaved.add(objTDListForSupplier.get(k).getCustomerName().toString().trim());
					}else{
						arrChecked.add(objTDListForSupplier.get(i).getCustomerName().toString().trim());
					}
				}
				for(int m=0;m<arrSaved.size();m++){
					clickOnHomeLink();
					selectCustomer(arrSaved.get(m).trim().toString());
					lavanteUtils.waitForTime(2000);
					inputData=arrSaved.get(m).trim().toString();
					clickOnProfileLink();
					clickOnMenuTabByNbr("5",xARecContactDrpBtn);
					lavanteUtils.waitForTime(1000);
					Reporter.log("\n");
					provideCustomerSpcData(arrSaved.get(m).trim().toString(),inputData);
					Reporter.log("\n");
				}
				for(int r=0;r<arrChecked.size();r++){
					clickOnHomeLink();
					selectCustomer(arrChecked.get(r).trim().toString());
					lavanteUtils.waitForTime(2000);
					clickOnProfileLink();
					clickOnMenuTabByNbr("5",xARecContactDrpBtn);
					lavanteUtils.waitForTime(1000);
					Reporter.log("\n");
					isCustomerSpcDataSaved(inputData);
					Reporter.log("\n");
				}

			}
		} catch (Exception e) {
			//log.severe("Exception in the method verifySuppliersDetailsSaved due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifySuppliersDetailsSaved due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : provideCustomerSpcData
	 * Purpose: Method to verify the supplier given data is saved for specific to customer not to other customer
	 * @param: List objTDListForSupplier
	 * @return: None
	 */
	void provideCustomerSpcData(String customerName,String strExpTextData){
		try {
			if(lavanteUtils.isElementDisplayed(xProfileSummary)){
				lavanteUtils.typeinEdit(strExpTextData,xProfileSummary);
				if(customerName.contains("GP")){
					lavanteUtils.typeinEdit( "1",IdClientAvgNo);
				}
				saveProfileDetailsOfCustomer();
			}else{
				Reporter.log(" Given web control is not available in the page");
			}
		} catch (Exception e) {
			//log.severe("Exception in the method isCustomerSpcDataSaved due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isCustomerSpcDataSaved due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : isCustomerSpcDataSaved
	 * Purpose: Method to verify the supplier given data is saved for specific to customer not to other customer
	 * @param: List objTDListForSupplier
	 * @return: None
	 */
	void isCustomerSpcDataSaved(String strExpTextData){
		String actTextData="";
		try {
			if(lavanteUtils.isElementDisplayed(xProfileSummary))
			{
				actTextData=lavanteUtils.getText(xProfileSummary);
				if(strExpTextData.equalsIgnoreCase(actTextData)){
					Reporter.log("verification failed due to expected given text value is available for other customer");
				}else{
					Reporter.log(" Verification is successful, data is not saved in the system for the other customer");
				}
			}else{
				Reporter.log(" Given web control is not available in the page");
			}
		} catch (Exception e) {
			//log.severe("Exception in the method isCustomerSpcDataSaved due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method isCustomerSpcDataSaved due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : selectCustomer
	 * Purpose: Method to select the specified Customer 
	 * @param: String strCustomerNameList
	 * @return: None
	 */
	void selectCustomer(String strCustomerNameList){
		try {
			Reporter.log("\n");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(xCustomerNameDropDownField);
			//lavanteUtils.selectDropDownValue(CustomerNameDropDownList,strCustomerNameList);
			Reporter.log(" Customer "+strCustomerNameList+" is selected from the list successfully");
			lavanteUtils.waitForTime(6000);
		} catch (Exception e) {
			//log.severe("Exception in the method selectCustomer due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method selectCustomer due to "+e.getMessage());
		}
	}


	public String selectCustomer2(String strCustomerNameList,int i){
		String selectListValue=null;
		try {
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(xCustomerNameDropDownField);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.click(xCustomerNameDropDownField);
			//lavanteUtils.selectDrpValuesByListNumber(xCustomerNameDropDownList,i);
			/*gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), xCustomerNameDropDownField);
			WebElement we=driver.findElement(By.xpath(xCustomerNameDropDownList));
			Select select=new Select(we);
			selectListValue=select.getFirstSelectedOption().gp.getText().trim().toString();*/
			selectListValue=lavanteUtils.getText( xCustomerNameDropDownField);
			Reporter.log(" Customer "+strCustomerNameList+" is selected from the list successfully");
			lavanteUtils.waitForTime(6000);
		} catch (Exception e) {
			//log.severe("Exception in the method selectCustomer due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method selectCustomer due to "+e.getMessage());
		}
		return selectListValue;
	}
	/**
	 * Method Name : verifySupplierProfilePercentage
	 * Purpose: Method to verify the profile completeness percentage 
	 * @param: None
	 * @return: None
	 */
	public int verifySupplierProfilePercentage(){
		int intActPercentage=0;
		String strActPercentage="",numPercentage;
		try {
			Reporter.log("\n");
			strActPercentage=lavanteUtils.getText(IdProfilePercentage);
			numPercentage=lavanteUtils.getStrRegExpValue("\\w",strActPercentage);
			intActPercentage=Integer.parseInt(numPercentage);
		} catch (Exception e) {
			//log.severe("Exception in the method verifyProfilePercentage due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyProfilePercentage due to "+e.getMessage());
		}
		return intActPercentage;
	}

	/**
	 * Method Name : verifyProfilePercentage
	 * Purpose: Method to verify the profile completeness percentage status
	 * @param: None
	 * @return: None
	 */
	public int verifyProfilePercentage(String strCustomerName){
		int intActPercentage=0;
		try {
			Reporter.log("\n");
			String strActPercentage="",numPercentage;
			lavanteUtils.click(linkTxtHome);
			Reporter.log("Clicked on link text 'Home' Successfully ");
			//selectCustomer(strCustomerName);
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click( xCustomerNameDropDownField);
			lavanteUtils.selectDropDownValue(xCustomerNameDropDownList.get(1), strCustomerName);
			Reporter.log(" Customer "+strCustomerName+" is selected from the list successfully");
			lavanteUtils.waitForTime(6000);
			strActPercentage=lavanteUtils.getText(IdProfilePercentage);
			numPercentage=lavanteUtils.getStrRegExpValue("\\w",strActPercentage);
			intActPercentage=Integer.parseInt(numPercentage);
		} catch (Exception e) {
			//log.severe("Exception in the method verifyProfilePercentage due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyProfilePercentage due to "+e.getMessage());
		}
		return intActPercentage;
	}


	/**
	 * Method Name : addPaymentTypeDetails
	 * Purpose: Method to add new PaymentType Details 
	 * @param: None
	 * @return: None
	 */
	public	void addPaymentTypeDetails(setTestData objProfilePaymentList,String checkFor){
		try {
			switch (checkFor) {
			case "Check":
				lavanteUtils.click("xPaymentTypeDrp",xPaymentTypeDrp);
				lavanteUtils.waitForTime(1000);
				//lavanteUtils.SPDselectDropDownValue(driver, "",xPaymentTypeDrpList,objProfilePaymentList.getPaymentType().toString());
				Reporter.log(" Selected the payament type option "+checkFor);
				saveProfileDetailsOfCompany();
				break;
			case "EFT":
				eFTDetails(objProfilePaymentList);
				saveProfileDetailsOfCompany();
				break;
			case "Credit Card":
				lavanteUtils.click(xPaymentTypeDrp);
				lavanteUtils.waitForTime(1000);
				//lavanteUtils.SPDselectDropDownValue(driver, "",xPaymentTypeDrpList,objProfilePaymentList.getPaymentType().toString());
				Reporter.log(" Selected the payament type option "+checkFor);
				lavanteUtils.waitForTime(2000);
				if(lavanteUtils.isElementDisplayed(driver.findElement( By.id("visa")))==true){
					lavanteUtils.click(driver.findElement(By.id("visa")));
					Reporter.log(" Payable To information : "+objProfilePaymentList.getPaymentInfo().toString());	
				}
				lavanteUtils.waitForTime(2000);
				if(lavanteUtils.isElementDisplayed(driver.findElement(By.id("pcardPaymentTermId_chosen")))==true){
					lavanteUtils.click(driver.findElement(By.id("pcardPaymentTermId")));
					lavanteUtils.selectvalueFrmDpdn("Net 01");
					Reporter.log(" Payment terms  : "+"Net 01");	
				}
				lavanteUtils.waitForTime(2000);
				saveProfileDetailsOfCompany();
				break;
			default:
				break;
			}

		} catch (Exception e) {
			//log.severe("Exception in the method addPhoneContactDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addPhoneContactDetails due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : addAddressDetails
	 * Purpose: Method to add new address details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void addAddressDetails(List<setTestData> getSupplierProfileList){
		try {
			for(int i=0;i<getSupplierProfileList.size();i++){
				if(getSupplierProfileList.get(i).getOperationName().trim().toString().equalsIgnoreCase("Address")){
					addSupProfileDetailsOfCompany(getSupplierProfileList.get(i));
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addAddressDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addAddressDetails due to "+e.getMessage());
		}
	}

	/*	public void addLegalIDdetails(){
		if(gp.isElementDisplayed(driver, By.xpath("//table[@id='table_w9Tax_information']/tbody/tr/td"))==true){
			Reporter.log("No data available");
			gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(), "//div[@class='toggle_content']/div/a[@class='button button_blue ajax']");


		}
	}*/
	/**
	 * Method Name : addTaxInformation
	 * Purpose: Method to add new addTaxInformation 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addTaxInformation(List<setTestData> objListContactDetails){
		try {
			clickToDoListReqField(xLegalIDMenuTab,IdLegalIformation);
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("TaxInfo")){
					uploadW9FileDoc();
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addPhoneContactDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addPhoneContactDetails due to "+e.getMessage());
		}
	}
	public void uploadW9FileDoc(){
		lavanteUtils.waitForTime(2000);
		String path=ConfigPathFile.W9File.getConstantValue();
		//String path=upLoadW9File;
		String errorMsg="";
		lavanteUtils.click(xW9UploadBtn);
		if(lavanteUtils.isFileExist(path)==true){
			lavanteUtils.waitForTime(3000);
			if(lavanteUtils.switchtoFrame( xpathactivatePopupFrame)){
				//lavanteUtils.uploadFileBySendKeys(driver, ConfigPathFile.XPATH.getConstantValue(),xW9browseFileBtn,path);
				lavanteUtils.click(xW9SaveBtn);
				Reporter.log(" Successfully clicked on Save button ob browse pop up ");
				if(lavanteUtils.isElementDisplayed(xErrorMsg)){
					errorMsg=lavanteUtils.getText(xErrorMsg);
					lavanteUtils.click(xW9CancelBtn);
					Reporter.log("operation failed due to "+errorMsg);
					Assert.assertTrue(false,"Test failed due to : "+errorMsg );	
				}
			}
		}
	}
	/**
	 * Method Name : addPhoneContactDetails
	 * Purpose: Method to add new phone contact details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addPhoneContactDetails(List<setTestData> objListContactDetails){
		try {
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("Phone")){
					lavanteUtils.typeinEdit(objListContactDetails.get(i).getPhone().toString(),driver.findElement(By.id(IdHeadQuarterPhone)));
					Reporter.log("Entered Phone Contact Number: "+objListContactDetails.get(i).getPhone().toString());
					jsForRefreshDOM(By.id(IdHeadQuarterPhone));
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addPhoneContactDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addPhoneContactDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addEmailDetails
	 * Purpose: Method to add new Email contact details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addEmailDetails(List<setTestData> objListContactDetails){
		try {
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("Email")){
					lavanteUtils.typeinEdit(objListContactDetails.get(i).getNewEmail().toString(),IdSupplierEmail);
					Reporter.log("Entered Company Email ID: "+objListContactDetails.get(i).getNewEmail().toString());
					//jsForRefreshDOM(By.id(IdSupplierEmail));
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addEmailDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addEmailDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addProductDetails
	 * Purpose: Method to add Product details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addProductDetails(List<setTestData> objListContactDetails){
		try {
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("Products and Services")){
					lavanteUtils.click(driver.findElement(By.xpath( xProductServiceTypeDrpBtn)));
					lavanteUtils.waitForTime(1500);
					//lavanteUtils.SPDselectDropDownValue(driver,"",xProductServiceTypeDrpList,objListContactDetails.get(i).getProductAndServicesValue().toString());
					Reporter.log("Selected the Product Service Type List "+objListContactDetails.get(i).getProductAndServicesValue().toString());
					jsForRefreshDOM(By.xpath(xProductServiceTypeDrpBtn));
					saveProfileDetailsOfCustomer();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addProductDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addProductDetails due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : addBusinessStrDetails
	 * Purpose: Method to add Business Structure Details details
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */

	public	void addBusinessStrDetails(List<setTestData> objListContactDetails){
		try {
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("BusinessStr")){
					lavanteUtils.click(xBusinessStrDrpBtn2);
					lavanteUtils.waitForTime(1500);
					//lavanteUtils.SPDselectDropDownValue(driver, "" ,xBusinessStrDrpBtnList,objListContactDetails.get(i).getTaxIDNumberKey().trim().toString());
					Reporter.log(" Selected Business Structure "+objListContactDetails.get(i).getTaxIDNumberKey().toString());
					jsForRefreshDOM(By.xpath(xBusinessStrDrpBtn));
					saveProfileDetailsOfCompany();
					break;
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addBusinessStrDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addBusinessStrDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addARContactDetails
	 * Purpose: Method to add Account information details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addARContactDetails(List<setTestData> objListContactDetails){
		try {
			String strErrorMsg="";
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("Account Receivable Contact")){
					lavanteUtils.click(driver.findElement(By.xpath( xARecContactDrpBtn)));
					lavanteUtils.waitForTime(1500);
					lavanteUtils.selectDropDownValue(xARecContactDrpList,(objListContactDetails.get(i).getUpdatedAddress().trim().toString()));
					Reporter.log("Entered Company Email ID: "+objListContactDetails.get(i).getNewEmail().toString());
					lavanteUtils.waitForTime(3000);
					if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame))
					{
						lavanteUtils.typeinEdit(objListContactDetails.get(i).getNewUserName().toString(),driver.findElement(By.id("contactName")));
						Reporter.log("Entered contact name");
						lavanteUtils.typeinEdit(objListContactDetails.get(i).getPhone().toString(),driver.findElement(By.id("phone")));
						Reporter.log("Entered phone number");

						lavanteUtils.click(xAddressDrpDwn);//it will always select the second value from drop down list

						lavanteUtils.switchtoFrame(null);
					}
					lavanteUtils.waitForTime(1500);
					//lavanteUtils.selectDrpValuesByListNumber(driver, ConfigPathFile.XPATH.getConstantValue(), xAddressDrpDwnList,2);
					if(lavanteUtils.switchtoFrame( xpathactivatePopupFrame))
					{
						lavanteUtils.typeinEdit(objListContactDetails.get(i).getNewEmail().toString(),driver.findElement(By.id("email")));
						Reporter.log("Entered contact email");

						lavanteUtils.click(xAddNewBtnSave);
						//gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),xBtnCancel);
						Reporter.log("Successfully clicked Save button");
						if(lavanteUtils.isElementDisplayed(xErrorMsg)){
							lavanteUtils.click(xBtnCancel);
							strErrorMsg=lavanteUtils.getText(xErrorMsg);
							Assert.assertFalse(true,"Test failed due to: "+strErrorMsg);
						}
						lavanteUtils.switchtoFrame(null);
					}
					jsForRefreshDOM(By.xpath(xARecContactDrpBtn));
					saveProfileDetailsOfCustomer();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addARContactDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addARContactDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addMajorityDetails
	 * Purpose: Method to add new phone contact details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addMajorityDetails(List<setTestData> objListContactDetails){
		try {	
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("Majority")){
					if(objListContactDetails.get(i).getChosenID().trim().toString().equalsIgnoreCase("No")){
						lavanteUtils.click(driver.findElement(By.xpath(xMajorityRadioBtnNo)));
						Reporter.log("Selected the Majority Radio button as |No|");
					}else{
						lavanteUtils.click(xMajorityRadioBtnYes);
						Reporter.log("Selected the Majority Radio button as |Yes|");
					}
					jsForRefreshDOM(By.xpath(xMajorityRadioBtnNo));
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addMajorityDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addMajorityDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addMajorityDetails
	 * Purpose: Method to add new phone contact details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addPaymentContractDetails(List<setTestData> objListContactDetails){
		try {
			AdvanceSearchPage objAdvanceSearchPage = PageFactory.initElements(driver,AdvanceSearchPage.class);
			String path=ConfigPathFile.W9File.getConstantValue();
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("PaymentContract")){
					if(objListContactDetails.get(i).getChosenID().trim().toString().equalsIgnoreCase("No")){
						lavanteUtils.click(xPaymentContractBtnNo);
						Reporter.log("Payment Contract Radio button No");
						if(lavanteUtils.isElementDisplayed(xPaymentTermsDrpLabel)){
							lavanteUtils.click(xPaymentTermDrpBtn);
							lavanteUtils.waitForTime(1500);
							lavanteUtils.click(driver.findElement(By.xpath(xPaymentTermDrpList)));
							lavanteUtils.selectvalueFrmDpdn(objListContactDetails.get(i).getPaymentTerms().toString());
							Reporter.log(" Entered Business Structure "+objListContactDetails.get(i).getPaymentTerms().toString());
						}else{
							Reporter.log(" Payment Term is not reflected as mandate field with star mark ");
						}

						if(lavanteUtils.isElementDisplayed(sxProductServicesLabel)){
							lavanteUtils.click(IdGoodsRadioBtn);
						}else{
							Reporter.log(" Type of products and service is not reflected as mandate field");
						}

						if(lavanteUtils.isElementDisplayed(xAgreeTermsFieldLabel)){
							lavanteUtils.click(IdAgreeCheckBox);
						}else{
							Reporter.log("Agree to terms and conditions is not reflected as mandate field");
						}

						if(lavanteUtils.isElementDisplayed(xNameFieldLabel)){
							lavanteUtils.typeinEdit(objListContactDetails.get(i).getNewUserName().toString(),IdNameFieldCT);
						}else{
							Reporter.log(" Name edit filed is not reflected as mandate field");
						}

						if(lavanteUtils.isElementDisplayed(xTitleFieldLabel)){
							lavanteUtils.typeinEdit(objListContactDetails.get(i).getJobTitle().toString(),IdTitleField);
						}else{
							Reporter.log(" Title edit filed is not reflected as mandate field");
						}

						if(lavanteUtils.isElementDisplayed(xDateFieldLabel)){
							/*objAdvanceSearchPage.selectDateField("Jun","2008","5",xDateField,xpathmonthDropDownOption, xpathyearDropDownOption,
									xpathdateRowCount, xpathselect, xpathoption, xpathName, xpathClose);*/
						}else{
							Reporter.log(" Date edit filed is not reflected as mandate field");
						}

					}else{
						lavanteUtils.click(xPaymentContractBtnYes);
						Reporter.log("Payment Contract Radio button Yes");
						lavanteUtils.waitForTime(1000);
						if(lavanteUtils.isElementDisplayed(xPaymentContractBrowseBtnLabel)){
							if(lavanteUtils.isFileExist(path)==true){
								lavanteUtils.typeinEdit(path,xPaymentContractBrowseBtn);
							}
						}else{
							Reporter.log("Signed Payment Contract is not reflected as mandate field");
						}
					}
					Reporter.log("selected Majority Option radio button: ");
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addMajorityDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addMajorityDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addLegalTaxDetails
	 * Purpose: Method to add new phone contact details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	//tax_identification_number for legalIdentifier
	//legalIdProvidedStatus

	public	void addLegalTaxDetails(List<setTestData> objListContactDetails){
		try {	
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("Tax Identification Number")){
					if(objListContactDetails.get(i).getChosenID().trim().toString().equalsIgnoreCase("No")){
						lavanteUtils.click(IdLegalBtnNo);
						Reporter.log("Radio button |NO| is selected ");
					}else{
						lavanteUtils.click(IdLegalBtnYes);
						Reporter.log("Radio button |YES| is selected ");
						lavanteUtils.waitForTime(1000);
						lavanteUtils.typeinEdit(objListContactDetails.get(i).getTaxID().trim().toString(),IdLegalIdField);
						Reporter.log("Entered Tax Number");
					}
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addLegalTaxDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addLegalTaxDetails due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : addSignificantInterestDetails
	 * Purpose: Method to add new phone contact details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public	void addSignificantInterestDetails(List<setTestData> objListContactDetails){
		try {
			verifyProfileLinkForCustomer();
			for(int i=0;i<objListContactDetails.size();i++){
				if(objListContactDetails.get(i).getOperationName().trim().toString().equalsIgnoreCase("SignificantInterest")){
					if(objListContactDetails.get(i).getChosenID().trim().toString().equalsIgnoreCase("No")){
						lavanteUtils.click(xSigInterestRadioBtnNo);
						Reporter.log("selected Significant Interest Option radio button 'NO'");
					}else{
						lavanteUtils.click(xSigInterestRadioBtnYes);
						Reporter.log("selected Significant Interest Option radio button 'YES'");
					}

					saveProfileDetailsOfCustomer();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addSignificantInterestDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addSignificantInterestDetails due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : addRemitToDetails
	 * Purpose: Method to add add RemitTo Details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void addRemitToDetails(List<setTestData> getSupplierProfileList){
		try {
			for(int i=0;i<getSupplierProfileList.size();i++){
				if(getSupplierProfileList.get(i).getOperationName().trim().toString().equalsIgnoreCase("RemitTo")){
					addSupProfileDetailsOfCompany(getSupplierProfileList.get(i));
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addRemitToDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addRemitToDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addLegalNoticeDetails
	 * Purpose: Method to add add RemitTo Details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void addLegalNoticeDetails(List<setTestData> getSupplierProfileList){
		try {
			for(int i=0;i<getSupplierProfileList.size();i++){
				if(getSupplierProfileList.get(i).getOperationName().trim().toString().equalsIgnoreCase("LegalNotices")){
					addSupProfileDetailsOfCompany(getSupplierProfileList.get(i));
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addLegalNoticeDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addLegalNoticeDetails due to "+e.getMessage());
		}
	}
	/**
	 * Method Name : addOrderDetails
	 * Purpose: Method to add add RemitTo Details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void addOrderDetails(List<setTestData> getSupplierProfileList){
		try {
			for(int i=0;i<getSupplierProfileList.size();i++){
				if(getSupplierProfileList.get(i).getOperationName().trim().toString().equalsIgnoreCase("OrderFrom")){
					addSupProfileDetailsOfCompany(getSupplierProfileList.get(i));
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addOrderDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addOrderDetails due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : addCurrencyDetails
	 * Purpose: Method to add new Currency Details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void addCurrencyDetails(List<setTestData> objListCurrency){
		try {
			for(int i=0;i<objListCurrency.size();i++){
				if(objListCurrency.get(i).getOperationName().trim().toString().equalsIgnoreCase(ConfigPathFile.CURRENCY.getConstantValue())){
					lavanteUtils.click(xCurrencyDrp);
					lavanteUtils.waitForTime(1000);
					lavanteUtils.selectDropDownValue(xCurrencyDrpList,objListCurrency.get(i).getCurrencyValue().trim().toString());
					Reporter.log(" Selected the Currency details as: "+objListCurrency.get(i).getCurrencyValue().trim().toString());
					saveProfileDetailsOfCompany();
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method addCurrencyDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method addCurrencyDetails due to "+e.getMessage());
		}
	}

	//
	public void verifyToDoListAppearsForInCompleteProfile(){
		Reporter.log("\n");
		String actToDoListMsgForInCompleteProfile="";
		actToDoListMsgForInCompleteProfile=lavanteUtils.getText(xToDoListInCompleteProfile);
		if(expTextToDoListInComPrfExpMsg.equalsIgnoreCase(actToDoListMsgForInCompleteProfile)){
			Reporter.log("Verification for To Do List details appears for In-Complete Profile is done successfully: { "+actToDoListMsgForInCompleteProfile+" }");
		}else{
			Reporter.log("Verification for To Do List details appears for In-Complete Profile is failed: { "+actToDoListMsgForInCompleteProfile+" }");
			//log.severe("Verification for To Do List details appears for In-Complete Profile is failed: { "+actToDoListMsgForInCompleteProfile+" }");
			Assert.assertTrue(false,"Verification for To Do List details appears for In-Complete Profile is failed: { "+actToDoListMsgForInCompleteProfile+" }");
		}
	}
	public void verifyToDoListAppearsForCompleteProfile(){
		Reporter.log("\n");
		String actToDoListMsgForCompleteProfile="";
		actToDoListMsgForCompleteProfile=lavanteUtils.getText(xToDoListCompleteProfile);
		if(expTextToDoListComPrfExpMsg.equalsIgnoreCase(actToDoListMsgForCompleteProfile)){
			Reporter.log("Verification for 'To Do List' details appears for  Complete Profile is done successfully: { "+actToDoListMsgForCompleteProfile+" }");
		}else{
			Reporter.log("Verification for 'To Do List' details appears for  Complete Profile is failed: { "+actToDoListMsgForCompleteProfile+" }");
			//log.severe("Verification for 'To Do List' details appears for  Complete Profile is failed: { "+actToDoListMsgForCompleteProfile+" }");
			Assert.assertTrue(false,"Verification for 'To Do List' details appears for  Complete Profile is failed: { "+actToDoListMsgForCompleteProfile+" }");	
		}
	}

	public void clickOnProfileLink(){
		if(lavanteUtils.isElementDisplayed(driver.findElement( By.xpath(xProfileMenuTabBtnRowList)))==true){
			Reporter.log("In Profile page");
		}else{
			navigateToProfilePage();
			Reporter.log("Successfully Navigated to Profile page");
		}
	}

	public void clickOnHomeLink(){
		if(lavanteUtils.isElementDisplayed(xCustomerNameDropDownField)){
			Reporter.log("In Home page");
		}else{
			navigateToHomePage();
			Reporter.log("Successfully Navigated to Home page");
		}
	}

	public void verifyCustomerLogoInTabsSpcPage(String tabNbr,String strCustomerName){
		lavanteUtils.waitForTime(2000);
		Reporter.log("\n");
		if(tabNbr.equals("5")){
			clickOnMenuTabByNbr("5",xARecContactDrpBtn);
			verifyCustomerLogo(strCustomerName);	
		}else{
			clickOnMenuTabByNbr("4",xPaymentTypeDrp1);
			verifyCustomerLogo(strCustomerName);
		}
	}
	public void verifyCustomerLogo(String customerName){
		Reporter.log("Calling 'Logo verification method'");
		WebElement locator = null;
		switch (customerName) {
		case "Con-way":
			locator=xConwayLogo;
			break;
		case "Omnicare":
			locator=xOmnicareLogo;
			break;
		case "GP Strategies":
			locator=xGPStrategiesLogo;
			break;

		default:
			break;
		}
		lavanteUtils.waitForTime(500);
		if(lavanteUtils.isElementDisplayed(locator)){
			Reporter.log("Logo verification is done successfully for the selected customer : " +customerName);
		}else{
			Reporter.log("Logo verification is failed for the selected customer : " +customerName);
			//log.severe("Logo verification is failed for the selected customer : " +customerName);
			Assert.assertTrue(false,"Logo verification is failed for the selected customer : " +customerName);
		}
	}

	/**
	 * Method Name : inCompleteFieldList
	 * Purpose: method to list out the required field names to complete the profile status
	 * @param: None
	 * @return: None
	 */
	public void inCompleteFieldList(){
		if(lavanteUtils.switchtoFrame(xToDoListFrame))
		{
			//List<WebElement > listOfIncompleteTab=driver.findElements(By.xpath(xToDoReqFieldInputDataList));
			try {
				for(int i=0;i<xToDoReqFieldInputDataList.size();i++){
					Reporter.log("ToDoList Required Fields to Complete the profile: "+xToDoReqFieldInputDataList.get(i).getText());
				}
			} catch (Exception e) {

			}
			lavanteUtils.switchtoFrame(null);
		}
	}

	/**
	 * Method Name : requiredFieldListToComplete
	 * Purpose: method return list of required field names
	 * @param: None
	 * @return: None
	 */
	public List<String> requiredFieldListToComplete(){
		List<String> incompleteFieldList=new ArrayList<>();
		if(lavanteUtils.switchtoFrame(xToDoListFrame))
		{
			//List<WebElement > listOfIncompleteTab=driver.findElements(By.xpath(xToDoReqFieldList));
			for(int i=0;i<xToDoReqFieldList.size();i++){
				incompleteFieldList.add(xToDoReqFieldList.get(i).getText().trim().toString());
				System.out.println("requiredFieledListToComplete: "+xToDoReqFieldList.get(i).getText());
			}
			lavanteUtils.switchtoFrame(null);
		}
		return incompleteFieldList;
	}
	/**
	 * Method Name : requiredFieldListToComplete
	 * Purpose: method return list of required field names
	 * @param: None
	 * @return: None
	 */
	public List<String> requiredFieldHeaderListToComplete(){
		List<String> incompleteHeaderList=new ArrayList<>();
		if(lavanteUtils.switchtoFrame(xToDoListFrame))
		{
			//List<WebElement > listOfIncompleteTab=driver.findElements(By.xpath(xToDoReqFieldHeaderList));
			for(int i=0;i<xToDoReqFieldHeaderList.size();i++){
				incompleteHeaderList.add(xToDoReqFieldHeaderList.get(i).getText().trim().toString());
				System.out.println("requiredFieledListToComplete: "+xToDoReqFieldHeaderList.get(i).getText());
			}
			lavanteUtils.switchtoFrame(null);	
		}
		return incompleteHeaderList;
	}


	/**
	 * Method Name : provideProfileDetailsToComplete
	 * Purpose: method return list of required field names
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void provideProfileTaxDetailsToComplete(List<setTestData> objListReqTestData){

		List<String> incompleteProfileList=new ArrayList<>();
		incompleteProfileList=requiredFieldHeaderListToComplete();
		try {
			for(int i=0;i<incompleteProfileList.size();i++){
				if(incompleteProfileList.get(i).trim().toString().contains("Your Tax (W-9)")){
					addTaxInformation(objListReqTestData);
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method provideProfileTaxDetailsToComplete due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method provideProfileTaxDetailsToComplete due to : " + e.getMessage());
		}
	}
	/**
	 * Method Name : navigateToLegalIDPage
	 * Purpose: Method to navigate To Customer Specific Profile Tab Page
	 * @param: None
	 * @return: None
	 */
	public void navigateToLegalIDPage(){
		try {
			lavanteUtils.waitForTime(2000);
			/*lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierPageTable);
			lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileTabTableRow);*/
			while (lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(xProfileTabArrowBtn)))==false){
				lavanteUtils.waitForTime(1000);
				lavanteUtils.click("xProfileTabArrowVisibleBtn",xProfileTabArrowVisibleBtn);
			}
			clickOnMenuTabsByName(tabNameLegalID,xDoingBusinessAs);
			isLeavePopUpExist();
			lavanteUtils.waitForTime(4000);
		} catch (Exception e) {
			//log.severe("Exception in the method validateEsignatureOp due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateEsignatureOp due to : " + e.getMessage());
		}
	}




	/**
	 * Method Name : add EFT Details
	 * Purpose: Method to add new address details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void addProfileEFTDetails(List<setTestData> getSupplierProfileList){
		for(int i=0;i<getSupplierProfileList.size();i++){
			if(getSupplierProfileList.get(i).getOperationName().trim().toString().equalsIgnoreCase("Preferred Payment Type")){
				addPaymentTypeDetails(getSupplierProfileList.get(i),getSupplierProfileList.get(i).getPaymentType().toString());
			}else{
				continue;
			}
		}

	}
	/**
	 * Method Name : add EFT Details
	 * Purpose: Method to add EFT details 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	void eFTDetails(setTestData objListOfEFTData){
		try {
			if(objListOfEFTData.getKeyValue().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue()))
			{
				if(lavanteUtils.isElementDisplayed(xPaymentTypeDrp)){
					lavanteUtils.click("xPaymentTypeDrp",xPaymentTypeDrp);
					lavanteUtils.waitForTime(1000);
					lavanteUtils.selectDropDownValue(xPaymentTypeDrpList,objListOfEFTData.getPaymentType().toString());
					Reporter.log(" Selected the payament type option ");
				}/*else if(gp.isElementDisplayed(driver, By.id(IdEtfCheckBox))){
					gp.select_RadioBtn(driver, ConfigPathFile.ID.getConstantValue(),IdEtfCheckBox);
				}*/
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click("xAddNewEFTBtn",xAddNewEFTBtn);
				lavanteUtils.waitForTime(2000);

				if(lavanteUtils.switchtoFrame( xpathactivatePopupFrame))
				{
					if(lavanteUtils.isElementDisplayed(xEFTType)){
						lavanteUtils.click(xEFTType);
					}	
					lavanteUtils.typeinEdit(objListOfEFTData.getNewEmail().toString(),IdRemittanceEmail);
					lavanteUtils.typeinEdit(objListOfEFTData.getaBANumber().toString(),IdABANumber);
					lavanteUtils.typeinEdit(objListOfEFTData.getaCNumber().toString(),IdAccountNumber);
					lavanteUtils.typeinEdit(objListOfEFTData.getBankName().toString(),IdBankName);
					lavanteUtils.typeinEdit(objListOfEFTData.getAddress().toString(),IdBranchAddress);
					lavanteUtils.typeinEdit(objListOfEFTData.getCity().toString(),IdCity);
					lavanteUtils.typeinEdit(objListOfEFTData.getPostalCode().toString(),IdPostalCode);
					lavanteUtils.typeinEdit(objListOfEFTData.getCode().toString(),IdSwiftCode);

					//select currency value from currency 
					lavanteUtils.click("xCurrency",xCurrency);
					lavanteUtils.waitForTime(600);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectDropDownValue(xEFTcurrencyDrpList,objListOfEFTData.getCurrencyValue().toString());

					//select currency value from Bank Country 
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.click(xBankCountry);
					lavanteUtils.waitForTime(600);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectDropDownValue(xBankCountryDrpList,objListOfEFTData.getCountry().toString());

					//select currency value from State 
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
					lavanteUtils.click(xStateId);
					lavanteUtils.waitForTime(600);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectDropDownValue(xStateIdDrpList,objListOfEFTData.getState().toString());

					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.click(IdCheckBox);
					lavanteUtils.click("xSaveBtn",xSaveBtn);
					lavanteUtils.waitForTime(1000);
					if(lavanteUtils.isElementDisplayed(xErrorMsg)){
						lavanteUtils.click(xCancelBtn);
					}
					lavanteUtils.switchtoFrame(null);
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method eFTDetails due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method eFTDetails due to "+e.getMessage());
		}
	}


	/**
	 * Method Name : provideProfileDetailsToComplete
	 * Purpose: method to provide mandate field information 
	 * @param: Array list of Supplier Profile details
	 * @return: None
	 */
	public void provideProfileDetailsToComplete(List<setTestData> objListReqTestData){
		List<String> incompleteProfileList=new ArrayList<>();
		incompleteProfileList=requiredFieldListToComplete();
		try {
			boolean flag=false;
			for(int i=0;i<incompleteProfileList.size();i++){
				lavanteUtils.waitForTime(3000);
				switch (incompleteProfileList.get(i).trim().toString()){
				case "Address":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for address details");
					if(lavanteUtils.isElementDisplayed(xAddressReqLabel)){
						addAddressDetails(objListReqTestData);
					}else{
						Reporter.log("Address is not reflected as mandate field with star mark");
					}
					break;
				case "Phone":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for phone details");
					if(lavanteUtils.isElementDisplayed(xPhoneReqLabel)){
						addPhoneContactDetails(objListReqTestData);
					}else{
						Reporter.log("Phone Number is not reflected as mandate field with star mark");
					}
					break;
				case "Company Email":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for Company Email details");
					if(lavanteUtils.isElementDisplayed(xCompanyEmailLabel)){
						addEmailDetails(objListReqTestData);
					}else{
						Reporter.log("Company Email is not reflected as mandate field with star mark");
					}
					break;
				case "Remit To":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for Remit To details");
					if(lavanteUtils.isElementDisplayed(xRemitToLabel)){
						addRemitToDetails(objListReqTestData);
					}else{
						Reporter.log("Remit To is not reflected as mandate field with star mark");
					}
					break;
				case "Order From":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for Order From details");
					if(lavanteUtils.isElementDisplayed(xOrderFromLabel)){
						addOrderDetails(objListReqTestData);
					}else{
						Reporter.log("Order From is not reflected as mandate field with star mark");
					}
					break;
				case "Legal Notices":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for Legal Notices details");
					if(lavanteUtils.isElementDisplayed(xLegalNoticeLabel)){
						addLegalNoticeDetails(objListReqTestData);
					}else{
						Reporter.log("Legal Notices is not reflected as mandate field with star mark");
					}
					break;
				case "Majority US/Canada Ownership":
					clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
					Reporter.log("Clicked on profile tab for Majority US/Canada Ownership details");
					if(lavanteUtils.isElementDisplayed(xMajorityUSOwnershipLabel)){
						addMajorityDetails(objListReqTestData);
					}else{
						Reporter.log("Majority US/Canada Ownership is not reflected as mandate field with star mark");
					}
					break;
				case "Preferred Payment Type":
					clickToDoListReqField(xPaymentInfoMenuTab,IdPaymentInfoType);
					Reporter.log("Clicked on profile tab for Preferred Payment Type details");
					if(lavanteUtils.isElementDisplayed(xPaymentContractRadioBtnYesLabel)){
						addPaymentContractDetails(objListReqTestData);
						flag=true;
					}else{
						Reporter.log("Preferred Payment Type is not reflected as mandate field with star mark");
					}
					addProfileEFTDetails(objListReqTestData);
					break;
				case "Do you have an Omnicare signed payment contract?":
					if(flag==false){
						clickToDoListReqField(xPaymentInfoMenuTab,IdPaymentInfoType);
						Reporter.log("Clicked on profile tab for Do you have an Omnicare signed payment contract details");
						if(lavanteUtils.isElementDisplayed(xPaymentContractRadioBtnYesLabel)){
							addPaymentContractDetails(objListReqTestData);
						}else{
							Reporter.log("Preferred Payment Type is not reflected as mandate field with star mark");
						}
					}
					break;
					//Tab5 Details
				case "Validate eSignature":
					clickToDoListReqField(xCutProfileMenuTab,IdContactDetails);
					Reporter.log("Clicked on profile tab for Validate eSignature details");
					if(lavanteUtils.isElementDisplayed(xESigatureCompleteLabel)){
						editEsignatureField(objListReqTestData.get(0).getPassword().toString()); //need to find
						saveProfileDetailsOfCustomer();
					}else{
						Reporter.log("Validate eSignature is not reflected as mandate field with star mark");
					}
					break;
				case "Account Receivable Contact":
					clickToDoListReqField(xCutProfileMenuTab,IdContactDetails);
					Reporter.log("Clicked on profile tab for Account Receivable Contact details");
					if(lavanteUtils.isElementDisplayed(xAccountReceivableContactLabel)){
						addARContactDetails(objListReqTestData);
					}else{
						Reporter.log("Account Receivable Contact is not reflected as mandate field with star mark");
					}
					break;
				case "Type of Products and Services":
					clickToDoListReqField(xCutProfileMenuTab,IdContactDetails);
					Reporter.log("Clicked on profile tab for Products and Services details");
					if(lavanteUtils.isElementDisplayed(xProductServiceTypeLabel)){
						addProductDetails(objListReqTestData);
					}else{
						Reporter.log("Products and Services is not reflected as mandate field with star mark");
					}
					break;
				case "Conflict Of Interest":
					clickToDoListReqField(xCutProfileMenuTab,IdContactDetails);
					Reporter.log("Clicked on profile tab for Conflict Of Interest details");
					if(lavanteUtils.isElementDisplayed(xConflictofInterestLabel)){
						addSignificantInterestDetails(objListReqTestData);
					}else{
						Reporter.log("Conflict Of Interest is not reflected as mandate field with star mark");
					}
					break;

				case "Business Structure (Tax Classification)":
					clickToDoListReqField(xLegalIDMenuTab,IdLegalIformation);
					Reporter.log("Clicked on profile tab for Business Structure (Tax Classification) details");
					if(lavanteUtils.isElementDisplayed(xBusinessStructureLabel)){
						addBusinessStrDetails(objListReqTestData);
					}else{
						Reporter.log("Business Structure is not reflected as mandate field with star mark");
					}
					break;
				case "Tax Identification Number":
					clickToDoListReqField(xLegalIDMenuTab,IdLegalIformation);
					Reporter.log("Clicked on profile tab for Tax Identification Number details");
					if(lavanteUtils.isElementDisplayed(xTaxIdentificationLabel)){
						addLegalTaxDetails(objListReqTestData);
					}else{
						Reporter.log("Tax Identification Number is not reflected as mandate field with star mark");
					}
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method provideProfileDetailsToComplete due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method provideProfileDetailsToComplete due to "+e.getMessage());
		}
	}


	//-----------------------------------------------------------------
	//ManageFile
	public void uploadManageUsersFile(){
		
		lavanteUtils.waitForTime(2000);
		String path="D:\\LAVANTE_M_13022015\\LAVANTE_SVN\\LAVANTE\\src\\test\\resources\\config\\upload.txt";
		//gp.clicks(driver, ConfigPathFile.XPATH.getConstantValue(),btnClick);
		if(lavanteUtils.isFileExist(path)==true){
			//if(gp.switchToFrameBy(driver, xpathactivatePopupFrame,ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue())==true){
			//lavanteUtils.uploadFileBySendKeys("//*[@id='multipartFile']",path);


			//}
		}
	}
	public void naviagteToManageFilePage(){
		lavanteUtils.click(driver.findElement(By.linkText( "Manage Files")));
		lavanteUtils.waitForTime(1500);
		//gp.assertPageTitle(driver,supplierProfilePageTitle);
		Reporter.log("Successfully navigated to Supplier Profile Page");
	}

	/**
	 * Method: verifypresenceAbsenceTAB 
	 * Purpose : to verify the presence of the TAB presence and absence of TAB provided in the excelsheet
	 * @param objdata
	 * @return boolean
	 */ 

	public boolean verifypresenceAbsenceTAB(setTestData objdata){
		List<String> lstOfExpTextValues=new ArrayList<String>();
		List<String> lstOfTABsTobeabsent=new ArrayList<String>();
		boolean bool_flag=false;
		boolean bool_absent=false;
		boolean bool_temp=true;
		try {
			lstOfExpTextValues=listExpTextValues(objdata.getExpProfileTabList().toString(),",");
			lstOfTABsTobeabsent=listExpTextValues(objdata.getMissingTabs().toString(),",");
			lavanteUtils.fluentwait(driver.findElement(By.xpath(xProfileTabNamesList)));
			List< WebElement> listOfProfilePageTabs=driver.findElements(By.xpath(xProfileTabNamesList));
			//log.info("\n The number of TABs present on the page are  : "+listOfProfilePageTabs.size()+" and are : { ");
			//String str_temp=driver.findElement(By.xpath("//div[@class='wizard_tab_info']")).gp.getText();
			//for printing the 
			for(WebElement we:listOfProfilePageTabs)
				//log.info(we.gp.getText().toString());
			Reporter.log(" } ");
			//for verifying the TABs that are present on the page
			for(int i=0;i<lstOfExpTextValues.size();i++){
				for(int k=0;k<listOfProfilePageTabs.size();k++)
				{
					if(listOfProfilePageTabs.get(k).getText().toString().equals(lstOfExpTextValues.get(i))){
						Reporter.log("Verified the presence of : { "+lstOfExpTextValues.get(i)+" } ");
						bool_flag=true;
						break;
					}
				}
			}
			if(bool_flag){
				Reporter.log("The TAB that is required is present on the page as Expected");
				lstOfExpTextValues.clear();
			}
			else {
				Reporter.log("Failed to find the specified TABs on the profile page");
				return false;
			}
			//for verifying the TABs NOT present on the profile page
			for(int i=0;i<lstOfTABsTobeabsent.size();i++){
				for(int k=0;k<listOfProfilePageTabs.size();k++)
				{
					if(listOfProfilePageTabs.get(k).getText().toString().equals(lstOfTABsTobeabsent.get(i))){
						bool_temp=false;
					}
				}
				if(!bool_temp){
					bool_absent=false;
					break;
				}
				else{
					Reporter.log("Verified the absence of : { "+lstOfTABsTobeabsent.get(i)+" } ");
					bool_absent=true;
				}
			}
			if(bool_absent){
				Reporter.log("The TAB required to be missing from the profile page is missing as expected");
				lstOfTABsTobeabsent.clear();
			}
			else {
				Reporter.log("The unexpected TABs appear on the profile page");
				return false;
			}

		}catch(Exception e){
			Reporter.log("Failed to do the verification of the TABs on the Profile page");
			Assert.assertFalse(true,"Test failed due to: "+e.getCause());
			
		}
		return bool_flag&&bool_absent;
	}
	/**
	 * Method Name : navigateToCusSpecificProfileTabPage
	 * Purpose: Method to navigate To Customer Specific Profile Tab Page
	 * @param: None
	 * @return: None
	 */
	public void navigateToCusSpecificProfileTabPage(){
		try {
			lavanteUtils.waitForTime(2000);
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xSupplierPageTable);
			//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileTabTableRow);
			while (lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(xProfileTabArrowBtn)))==false){
				lavanteUtils.waitForTime(1000);
				lavanteUtils.click("xProfileTabArrowVisibleBtn",xProfileTabArrowVisibleBtn);
			}
			clickOnProfilePageTabsByNbrs("5",xpathlasttab);
			isLeavePopUpExist();
			lavanteUtils.waitForTime(4000);
		} catch (Exception e) {
			//log.severe("Exception in the method validateEsignatureOp due to : "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method validateEsignatureOp due to : " + e.getMessage());
		}
	}
	/**
	 * Method: jsForRefreshDOM 
	 * Purpose : method is used to refresh the HTML DOM Structure
	 * @param None
	 * @return None
	 */ 
	void jsForRefreshDOM(By locator){
		try {
			WebElement element=null;
			element=driver.findElement(locator);
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("$(arguments[0]).change();",element);
			lavanteUtils.waitForTime(2000);
		} catch (Exception e) {
			//log.severe("Exception in the method due to "+e.getMessage());
			Assert.assertTrue(false,"Exception in the method due to "+e.getMessage());
		}
	}


	/**
	 * Method : updateProfileCustomerSpecific
	 * Description: update the details given in the excel sheet
	 * @param : detail, detailupdatedvalue
	 */
	public void updatedProfileCustomerSpecific(String strdetail, setTestData objTDupdate){


		try{
			switch(strdetail){

			case "Address":
				clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
				Reporter.log("Clicked on profile tab for address details");
				if(lavanteUtils.verifyElementDisplayed("xAddressReqLabel",xAddressReqLabel)){
					addSupProfileDetailsOfCompany(objTDupdate);
					Reporter.log("Updated the address ");
				}else{
					Reporter.log("Address is not reflected as mandate field with star mark");
				}
				break;
			case "Remit To":
				clickToDoListReqField(xComProfileMenuTab, IdHeadquartersInfo);
				Reporter.log("Clicked on profile tab for Remit To details");
				if(lavanteUtils.verifyElementDisplayed("xRemitToLabel",xRemitToLabel)){
					addSupProfileDetailsOfCompany(objTDupdate);
					Reporter.log("Updated the Remit to address");
				}else{
					Reporter.log("Remit To is not reflected as mandate field with star mark");
				}
				break;
			case "Business Structure (Tax Classification)":
				clickToDoListReqField(xLegalIDMenuTab,IdLegalIformation);
				Reporter.log("Clicked on profile tab for Business Structure (Tax Classification) details");
				if(lavanteUtils.verifyElementDisplayed("xBusinessStructureLabel",xBusinessStructureLabel)==true){

					lavanteUtils.click(driver.findElement(By.xpath(xBusinessStrDrpBtn)));
					lavanteUtils.waitForTime(1500);
					lavanteUtils.selectDropDownValue(xBusinessStrDrpBtnList,objTDupdate.getNewvalue().trim().toString());
					Reporter.log("Updated the Business Structure "+objTDupdate.getNewvalue().toString());
					saveProfileDetailsOfCompany();
					break;
				}else{
					Reporter.log("Business Structure is not reflected as mandate field with star mark");
				}
				break;
			case "Business/Sales Contact":
				//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileTabTableRow);
				while (lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(xProfileTabArrowBtn)))==false){
					lavanteUtils.waitForTime(1000);
					lavanteUtils.click(xProfileTabArrowVisibleBtn);
				}
				clickOnProfilePageTabsByNbrs("5",xpathlasttab);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.click("idbusinesssalescontact",idbusinesssalescontact);
				lavanteUtils.waitForTime(4000);
				WebElement we = idbusinesssalescontact;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", we);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.selectDropDownValue(xpathbusinesscontactdropdwn, objTDupdate.getUpdatedAddress().toString());
				lavanteUtils.waitForTime(3000);
				if(lavanteUtils.switchtoFrame( xpathactivatePopupFrame)){
					lavanteUtils.typeinEdit(objTDupdate.getNewvalue().toString(),xpathname);
					Reporter.log("Entered the updated contact name ");
					lavanteUtils.typeinEdit(objTDupdate.getNewEmail().toString(),xpathemail);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.click("XpathBtnSaveAddress",XpathBtnSaveAddress);
					Reporter.log("Clicked on the | Save | button successfully");
					lavanteUtils.switchtoFrame(null);
				}
				lavanteUtils.click("idbusinesssalescontact",idbusinesssalescontact);
				lavanteUtils.waitForTime(1000);
				lavanteUtils.selectDropDownValue( xpathbusinesscontactdropdwn, objTDupdate.getNewvalue().toString());
				lavanteUtils.waitForTime(4000);
				saveProfileDetailsOfCustomer();
				Reporter.log("Changed the Business/Sales Contact to : "+objTDupdate.getNewvalue().toString());
				break;
			case "Product / Services":
				//lavanteUtils.explicitWaitForWebElementToLoad(driver, ConfigPathFile.XPATH.getConstantValue(),xProfileTabTableRow);
				clickOnProfilePageTabsByNbrs("5",xpathlasttab);
				while (lavanteUtils.isElementDisplayed(driver.findElement(By.xpath(xProfileTabArrowBtn)))==false){
					lavanteUtils.waitForTime(1000);
					lavanteUtils.click("xProfileTabArrowVisibleBtn",xProfileTabArrowVisibleBtn);
				}
				clickOnProfilePageTabsByNbrs("5",xpathlasttab);
				lavanteUtils.waitForTime(4000);

				lavanteUtils.typeinEdit(objTDupdate.getNewvalue().toString(),IdeditproductsServicesPerformed1);
				Reporter.log("Entered the updated value of the product and services");
				jsForRefreshDOM(By.id(IdeditproductsServicesPerformed));
				saveProfileDetailsOfCustomer();
				Reporter.log("Changed the Product / Services Contact to : "+objTDupdate.getNewvalue().toString());
				break;
			case "Phone":
				clickOnProfilePageTabsByNbrs("1","//input[@id='"+IdHeadQuarterPhone+"']");
				lavanteUtils.waitForTime(4000);
				lavanteUtils.typeinEdit(objTDupdate.getNewvalue().toString(),headQuarterPhone1);
				Reporter.log("Entered Phone Contact Number: "+ objTDupdate.getNewvalue().toString());
				jsForRefreshDOM(By.id(IdHeadQuarterPhone));
				saveProfileDetailsOfCompany();
				Reporter.log("Changed the Phone number to : "+objTDupdate.getNewvalue().toString());
				break;
			case "Payment type":
				clickOnProfilePageTabsByNbrs("4", xPaymentTypeDrp2);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.click("xPaymentTypeDrp",xPaymentTypeDrp);
				lavanteUtils.waitForTime(1000);
				lavanteUtils.selectDropDownValue(xPaymentTypeDrpList, objTDupdate.getNewvalue().toString());
				Reporter.log(" Selected the payament type option "+ objTDupdate.getNewvalue().toString());
				if(lavanteUtils.verifyElementDisplayed("idvisa",idvisa)){
					lavanteUtils.click( idvisa);
					Reporter.log(" Payable To information : "+ objTDupdate.getNewvalue().toString());	
				}
				saveProfileDetailsOfCompany();
				Reporter.log("Changed the Payment type to : "+objTDupdate.getNewvalue().toString());
				break;
			}
		}catch(Exception e){
			//log.severe("Failed due to exception : "+e.getMessage());
			Assert.assertFalse(true,"Test failed due to: "+e.getMessage());
		}
	}


	

	public void updateprofile(List<setTestData> objTDprofileupdate){
		try{
			navigateToProfilePage();
			for(int i=0;i<objTDprofileupdate.size();i++){
				updatedProfileCustomerSpecific(objTDprofileupdate.get(i).getOperationName().toString(),objTDprofileupdate.get(i));
			}
		}catch(Exception e){
			//log.severe("Failed due to exception : "+e.getMessage());
			Assert.assertFalse(true,"Test failed due to: "+e.getMessage());
		}
	}

	

}
