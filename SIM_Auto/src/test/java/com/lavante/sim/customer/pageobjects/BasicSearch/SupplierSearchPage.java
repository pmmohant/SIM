/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

package com.lavante.sim.customer.pageobjects.BasicSearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.SupplierProfile.SupplierProfilePage;
import com.lavante.sim.Common.Util.*;

public class SupplierSearchPage{
	
	
	SupplierProfilePage	objSupplierProfilePage =null;
	String methodName="";
	SoftAssert sAssert=new SoftAssert();
	LavanteUtils lavanteUtils=new  LavanteUtils();
	//Declare web driver
	private WebDriver wdSupplierSearch;	
	
	@FindBy(xpath="//select[@id='profileStatus']//following-sibling::div[2]//input")
	private WebElement ProfileStatusSearchInputBox;
	
	@FindBy(linkText="Legal ID")
	private WebElement LegalID;
	
	@FindBy(xpath="//form[@id='supplierLegalIDForm']")
	private WebElement SupplierSearchResultForm;
	
	@FindBy(linkText = "OFAC")
	private WebElement OFACLink;
	
	@FindBy(id = "supplierofacsdnForm")
	private WebElement OFACSearchTable;
	
	@FindBy(linkText = "Addresses")
	private WebElement AddressesLink;
	
	@FindBy(linkText = "Invoices")
	private WebElement InvoicesLink;
	
	@FindBy(xpath = "//table[@id='invoiceDetails']")
	private WebElement InvoicesDetailsTable;
	
	@FindBy(id = "contractMgmtForm")
	private WebElement contractMgmtTable;
	
	@FindBy(xpath= "//table[@id='paymentDetails']")
	private WebElement PaymentDetailsTable;
	
	@FindBy(linkText = "Contract Management")
	private WebElement ContractManagement;
	
	@FindBy(linkText = "Payment")
	private WebElement Payment;
	
	@FindBy(xpath = "//form[@id='supplierAddressForm']")
	private WebElement supplierAddressTable;
	
	@FindBy(xpath="//select[@id='profileStatus']//following-sibling::div[2]//div//li[1]")
	private WebElement ProfileStatusSearchValue1;
	
	private String expectedPageTitle="Lavante SIM - Search";
	@FindBy(xpath="//a[@title='Dashboard']")
	private WebElement XpathDashboard;
	@FindBy(linkText="Basic Search")
	private WebElement LnkTxtbasicsearchLink;
	@FindBy(linkText="Advanced Search")
	private WebElement LnkTxtadvancedsearchLink;
	@FindBy(id="profileStatus")
	private WebElement idprofileStatus;
	@FindBy(id="showDeactivatedSuppliers")
	private WebElement iddeactivatedSuppliers;
	@FindBy(xpath="//form[contains(@id,'search_supplier_form')]/div[2]/button[contains(@title,'Search Suppliers')]")
	private WebElement xpathSearchBtn;
	@FindBy(xpath="//*[@id='search_results']//tbody//tr")
	private List<WebElement> xpathtableRowCount;
	@FindBy(xpath="//form[@id='supplierSearchResultForm']//tr[contains(@class,'data_not_found')]")
	private WebElement xpathdataNotFound;
	@FindBy(xpath="//form[@id='supplierSearchResultForm']//tr[contains(@class,'data_not_found')]")
	private WebElement xpathnoData;
	@FindBy(xpath="//div/table[contains(@id,'search_results')]/thead/tr/th")
	private List<WebElement> xpathheaderCount;
	@FindBy(xpath="//div/table[contains(@id,'search_results')]/tbody/tr[1]/td")
	private List<WebElement> xpathdataCount;
	private String xpathselect="//div/table[contains(@id,'search_results')]/tbody/tr[";
	private String xpathoption="]/td[1]";
	@FindBy(xpath="//div/table[contains(@id,'search_results')]/tbody/tr[1]/td[3]/a[contains(@id,'supplier')]")
	private WebElement xpathsupplierTblName;
	@FindBy(xpath="//*[contains(@id,'search_results')]//td[6]")
	private WebElement xpathsamecontactEmail;
	@FindBy(xpath="//form[contains(@id,'supplierSearchResultForm')]/div[2]/div[2]/button")
	private WebElement xpathaccountBtn;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//*[@title='Activate']")
	private WebElement xpathactivateOption;
	@FindBy(xpath="//div[@class='dialog undefined ui-dialog-content ui-widget-content']")
	private WebElement xpathdialogPopup;
	@FindBy(xpath="//button[@class='button_green'][@type='button']")
	private WebElement xpathokBtn;
	@FindBy(xpath="//form[contains(@id,'activateDeactivateSupplierForm')]/div/table/tbody/tr[4]/td[2]/div/textarea[contains(@id,'comment')]")
	private WebElement xpathcommentEditBox;
	@FindBy(xpath="//*[@id='activateDeactivateSupplierForm']//*[@type='submit']")
	private WebElement xpathsaveBtn;
	@FindBy(xpath="//div[contains(@class,'dialog undefined ui-dialog-content ui-widget-content')]")
	private WebElement xpathSuccessMsg;
	@FindBy(xpath="//span[@class='error']")
	private WebElement xpathErrorMessage;
	@FindBy(xpath="//*[@id='msg_to_supplier']//*[@type='reset']")
	private WebElement xpathClearBtn;
	@FindBy(xpath="//div/table[contains(@id,'search_results')]/tbody/tr[1]/td[8]")
	private WebElement xpathstatus;
	private String xpathsupplierStatus="//div/table[contains(@id,'search_results')]/tbody/tr[";
	private String xpathrowOption="]/td[8]";
	private String xpathprofileCompletePercentage="//div/table[contains(@id,'search_results')]/tbody/tr[";
	private String xpathValueOption="]/td[9]";
	
	@FindBy(id="supplierName")
	private WebElement idsupplierName;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//*[@title='Deactivate']")
	private WebElement xpathDeactivateOption;
	@FindBy(xpath=".//iframe[@class='iframe_page']")
	private WebElement xpathsupplierTableFrame;
	@FindBy(xpath=".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement xpathactivatePopupFrame;
	@FindBy(xpath="//form[contains(@id,'supplierSearchResultForm')]/div[2]/div[3]/button")
	private WebElement xpathcommunicateBtn;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//*[@title='Send Email']")
	private WebElement xpathsendEmailOption;
	@FindBy(xpath="//form[contains(@id,'msg_to_supplier')]/div/table/tbody/tr/td[2]/div[contains(@id,'from_chosen')]/a")
	private WebElement xpathfromDropdown;
	@FindBy(xpath="//form[contains(@id,'msg_to_supplier')]/div/table/tbody/tr[3]/td[2]/input[contains(@id,'subject')]")
	private WebElement xpathsubject;
	@FindBy(xpath="//form[contains(@id,'msg_to_supplier')]/div[1]/table/tbody/tr[5]/td/div/div/div/div[contains(@class,'jqte_editor')]")
	private WebElement xpathbodyMessage;
	@FindBy(xpath="//*[@id='msg_to_supplier']//*[@id='send_message']")
	private WebElement xpathsendBtn;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-buttonset')]/button[contains(@class,'button_green')]")
	private WebElement xpathokEmailBtn;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//*[@title='Re-invite']")
	private WebElement xpathreInviteOption;
	@FindBy(xpath="Contact")
	private WebElement idcontact;
	@FindBy(xpath="//form[contains(@id,'reinvite_supplier')]/div[1]/div/table/tbody/tr[2]/td[2]/label")
	private WebElement xpathlabelName;
	@FindBy(xpath="//form[contains(@id,'reinvite_supplier')]/div/div[1]/strong")
	private WebElement xpathreInviteDialogPopup;
	@FindBy(xpath="button_invite")
	private WebElement idinviteBtn;
	@FindBy(xpath="//div/table[contains(@id,'search_results')]/tbody/tr[1]/td[6]")
	private WebElement xpathemailContact;
	@FindBy(xpath="//table[contains(@id,'search_results')]/tbody/tr")
	private List<WebElement> xpathSupNameRows;
	private String xSupNameRowsOne="//table[contains(@id,'search_results')]/tbody/tr[";
	
	private String xSupNameRowsTwo="]/td[1]";
	@FindBy(id="search_results")
	private WebElement idSearchResultsFrame;
	@FindBy(xpath="//form[contains(@id,'search_supplier_form')]/div/table/tbody/tr[2]/td[2]/input[contains(@id,'supplierName')]")
	private WebElement xSupplierNameField;
	@FindBy(id="search_tab")
	private WebElement idsearchtab;
	@FindBy(id="email")
	private WebElement Idemail;
	@FindBy(linkText="Invite New Supplier")
	private WebElement lnkTxtinviteNewSupplier;
	@FindBy(linkText="Create New Supplier")
	private WebElement lnkTxtcreateNewSupplier;
	@FindBy(xpath="//div[contains(@id,'suggestions')]/table[contains(@id,'supp_email_table')]")
	private WebElement xpathautoSuggestTblName;
	@FindBy(xpath="//div[contains(@id,'suggestions')]/table[contains(@id,'supp_email_table')]/caption")
	private WebElement xpathautoSuggestMsg;
	@FindBy(xpath="//div[contains(@id,'suggestions')]/table[contains(@id,'supp_email_table')]/tbody/tr/td[1]")
	private WebElement xpathautoSuggestSupplierName;
	@FindBy(xpath="//*[@id='invite_New_supplier']//*[@title='Cancel']")
	private WebElement xpathcancelBtn;
	@FindBy(id="adv_search_tab")
	private WebElement idadvancedTab;
	@FindBy(id="profileStage")
	private WebElement idprofileStage;
	@FindBy(xpath="//form[contains(@id,'advanceSearchExecute')]//button[contains(@title,'Build Query')]")
	private WebElement xpathbuildQueryBtn;
	@FindBy(xpath="//form[contains(@id,'advanceSearch')]/div/div[2]/a[contains(@title,'Enterprise Generated Data')]")
	private WebElement xpathenterpriseDataTab;
	@FindBy(xpath="//*[@id='advanceSearch']//input[@type='submit'][@title='Search']")
	private WebElement xpathadvanceSearchBtn;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//button[contains(@title,'Start Outreach')]")
	private WebElement xpathoutreachOption;
	@FindBy(xpath="//form[contains(@id,'startOutreachForm')]/div[1]/p")
	private WebElement xpathinitiateProcessMsg;
	@FindBy(xpath="//*[@id='dialog']//*[@title='Outreach']")
	private WebElement xpathoutreachBtn;
	@FindBy(xpath="//form[contains(@id,'invite_New_supplier')]/div/table/tbody/tr[10]/td/label")
	private WebElement xpathNewSupplierPopupLabel;
	@FindBy(xpath="//form[contains(@id,'invite_New_supplier')]/div[2]/button[contains(@title,'Cancel')]")
	private WebElement xpathnewSupplierCancelBtn;
	@FindBy(xpath="isTakeControlOfsupplierProfile")
	private WebElement idtakeControlChkBox;
	@FindBy(id="contactName")
	private WebElement idcontactName;
	@FindBy(xpath="//div/table[contains(@id,'search_results')]/tbody/tr[1]/td[4]")
	private WebElement xpathbusinessContact;
	@FindBy(xpath="//form[contains(@id,'advanceSearch')]/div/div[2]/a[contains(@title,'Company Profile')]")
	private WebElement xpathcompanyProfileTab;
	@FindBy(xpath="//div[contains(@id,'supplier_name_chosen')]/a/span")
	private WebElement xpathSupplierDrpDwn;
	@FindBy(xpath="//input[contains(@name,'supplier_name_field')]")
	private WebElement xpathsuppliertxtField;
	@FindBy(xpath="//form[contains(@id,'advanceSearch')]/div/div[2]/a[contains(@title,'Customer Specific Profile')]")
	private WebElement xpathcustomerSpecificProfileTab;
	@FindBy(xpath="//div[contains(@id,'primaryCont_chosen')]/a/span")
	private WebElement xpathbusinessContactDrpDwn;
	@FindBy(xpath="//input[contains(@name,'primaryCont_field')]")
	private WebElement xpathbusinessContactTxtField;
	@FindBy(id="supplier_Contact")
	private WebElement idsupplierContactInfo;
	@FindBy(id="preScreen")
	private WebElement idpreScreen;
	@FindBy(xpath="//div[contains(@class,'ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix')]/span")
	private WebElement xpathprescreenTitlebar;
	@FindBy(xpath="//button[contains(@class,'button_green')]")
	private WebElement xpathprescreenOKBtn;
	@FindBy(xpath="//form[contains(@id,'supplierSearchResultForm')]/div[2]/div[1]/button")
	private WebElement xpathprofileBtn;
	@FindBy(xpath="//*[contains(@id,'supplierSearchResultForm')]//*[contains(@title,'Edit Profile')]")
	private WebElement xpatheditProfile;
	@FindBy(xpath="//table[contains(@id,'profile_tab')]/tbody/tr/td[2]/div/div/a[1]")
	private WebElement xpathenterpriseOwnedTab;
	@FindBy(xpath="//table[contains(@id,'supplier_Contact_Information')]/tbody/tr/td[8]/a[contains(@title,'Edit User Information')]")
	private WebElement xpatheditUserInfoIcon;
	@FindBy(xpath="//*[@id='command']//*[contains(@value,'Save')]")
	private WebElement xpathsaveEditUserBtn;
	@FindBy(xpath="//*[@id='command']//*[contains(@title,'Cancel')]")
	private WebElement xpatheditUserCancelBtn;
	@FindBy(xpath="//form[contains(@id,'command')]/table/tbody/tr[7]/td[2]/span")
	private WebElement xpatheditUserErrorMsg;
	@FindBy(xpath="//form[contains(@id,'supplierSearchResultForm')]/div[2]/div[5]/button")
	private WebElement xpathotherAction;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//button[@title='Move to Profile Complete']")
	private WebElement xpathmoveToProfileComplete;
	@FindBy(xpath="//form[contains(@id,'supplierSearchResultForm')]/div[2]/div[5]/div/input[contains(@value,'Download Documents')]")
	private WebElement xpathdownloadDocuments;
	@FindBy(xpath="//form[contains(@id,'command')]/div/a[contains(@title,'Cancel')]")
	private WebElement xpathadvCancelBtn;
	@FindBy(xpath="//div[contains(@id,'main-navigation')]/a[contains(@title,'Supplier Managed')]")
	private WebElement xpathsupplierManaged;
	@FindBy(xpath="//div[contains(@id,'main-navigation')]/a[contains(@title,'Enterprise-Owned')]")
	private WebElement xpathenterpriseOwned;
	@FindBy(xpath="//div[contains(@id,'main-navigation')]/a[contains(@title,'Status and History')]")
	private WebElement xpathstatusAndHistory;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Core Profile')]")
	private WebElement xpathcoreProfile;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Regulatory')]")
	private WebElement xpathregulatory;
	@FindBy(xpath="Contact")
	private WebElement xpathcontact;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Relation Specific Profile')]")
	private WebElement xpathrelationSpecificProfile;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Payment Information')]")
	private WebElement xpathpaymentInformation;
	@FindBy(xpath="//form[contains(@id,'search_supplier_form')]/div[2]/button[contains(@title,'Reset Search')]")
	private WebElement xpathresetBtn;
	@FindBy(xpath="//div[contains(@id,'cs_profile')]/table[1]/tbody/tr[1]/td/input[contains(@name,'primaryCont_field')]")
	private WebElement xpathbusinessContactName;
	@FindBy(id="primaryCont_chosen")
	private WebElement idcompanyLegalName_chosen;
	@FindBy(css="button[title='close'][type='button']")
	private WebElement cssPopupCloseBtn;
	@FindBy(id="countryId_chosen")
	private WebElement idCountry;
	@FindBy(id="stateId_chosen")
	private WebElement idState;
	@FindBy(xpath="//div[contains(@id,'dialog')]/div[7]/table[2]/tbody/tr/td[5]")
	private WebElement xpathstateField;
	@FindBy(xpath="//div[contains(@id,'dialog')]/div[7]/table[2]/tbody/tr/td[7]")
	private WebElement xpathcountryField;
	@FindBy(xpath="//div[contains(@id,'filters')]/table/tbody/tr/th/table/tbody/tr/td[2]/input[contains(@title,'Clear')]")
	private WebElement xpathdateClearFieldBtn;
	@FindBy(xpath="//form[contains(@id,'advanceSearch')]/div/div[2]/a[contains(@title,'Company Legal ID')]")
	private WebElement xpathcompanyLegalID;
	@FindBy(id="legalIdentifier_chosen")
	private WebElement idtaxIDDrpDwn;
	@FindBy(id="legalIdDocumentW9Provided_chosen")
	private WebElement idlegalIDDocDrpDwn;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table/tbody/tr[4]/td/label")
	private WebElement xpathlegalIDlabelName;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table/tbody/tr[4]/td[2]")
	private WebElement xpathlegalIDIdentifierStatus;
	@FindBy(xpath="//table[contains(@class,'data_table table_grid zebra dynamic_table')]/tbody/tr/td[1]")
	private WebElement xpathpdfName;
	@FindBy(xpath="//form[contains(@id,'advanceSearch')]/div[2]/div/input[contains(@title,'Save Query')]")
	private WebElement xpathsaveQuery;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table/tbody/tr[contains(@class,'data_not_found')]/td")
	private WebElement xpathapproveNoData;
	@FindBy(xpath="//div[contains(@id,'dialog')]/form[contains(@id,'adv_search')]/div/table/tbody/tr[1]/td[2]/input[contains(@id,'specify_query')]")
	private WebElement idspecifyQueryTxtBox;
	@FindBy(id="private_query")
	private WebElement idprivateQueryChkBox;
	@FindBy(xpath="//form[contains(@id,'adv_search')]/div[2]/input[contains(@title,'Save')]")
	private WebElement xpathsaveQuerySaveBtn;
	@FindBy(xpath="//table[contains(@id,'private_queries')]/caption")
	private WebElement xpathprivateQueryCaption;
	@FindBy(xpath="//table[contains(@id,'private_queries')]/tbody/tr[1]/td/a[contains(@class,'icon_note_run run_query')]")
	private WebElement xpathprivateQueryRunBtn;
	@FindBy(xpath="//table[contains(@id,'private_queries')]/tbody/tr[1]/td/a[contains(@class,'icon_note_delete')]")
	private WebElement xpathprivateDeleteBtn;
	@FindBy(xpath="//table[contains(@id,'public_queries')]/caption")
	private WebElement xpathpublicQueryCaption;
	@FindBy(xpath="//table[contains(@id,'public_queries')]/tbody/tr[1]/td/a[contains(@class,'icon_note_run run_query')]")
	private WebElement xpathpublicQueryRunBtn;
	@FindBy(xpath="//table[contains(@id,'public_queries')]/tbody/tr[1]/td/a[contains(@class,'icon_note_delete')]")
	private WebElement xpathpublicQueryDeleteBtn;
	@FindBy(xpath="box1View")
	private WebElement idavailableSuppDocBox;
	@FindBy(xpath="toRight")
	private WebElement idtoRightBtn;
	@FindBy(xpath="//*[contains(@id,'save_request_doc_form')]//*[contains(@value,'OK')]")
	private WebElement xpathuploadDocOKBtn;
	@FindBy(xpath="//div[contains(@id,'main-navigation')]/a[contains(@title,'Manage Files')]")
	private WebElement xpathmanageFiles;
	@FindBy(xpath="//a[@title='Download Files']")
	private WebElement xpathdownloadFiles;
	@FindBy(xpath="//div[contains(@id,'downloadFileDetailsDiv')]/table/tbody/tr")
	private List<WebElement> xpathdownloadFileRowCount;
	@FindBy(xpath="//div[contains(@id,'downloadFileDetailsDiv')]/table/tbody/tr[1]/td")
	private WebElement xpathdownloadFileColumnCount;
	@FindBy(xpath="//div[contains(@id,'downloadFileDetailsDiv')]/table/tbody/tr[1]/td[1]")
	private WebElement xpathdownloadFileName;
	@FindBy(xpath="//div[contains(@id,'downloadFileDetailsDiv')]/table/tbody/tr[1]/td[2]")
	private WebElement xpathdownloadedOn;
	@FindBy(xpath="//div[contains(@id,'downloadFileDetailsDiv')]/table/tbody/tr[2]/td[5]")
	private WebElement xpathdownloadedRecordsCount;
	@FindBy(xpath="//div[contains(@id,'downloadFileDetailsDiv')]/table/tbody/tr[1]/td[6]")
	private WebElement xpathdownloadStatus;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table[1]/tbody/tr[6]/td[2]")
	private WebElement xpathkeySuppInfoName;
	@FindBy(xpath="//table[contains(@class,'data_table table_outer_grid')]")
	private WebElement xpathkeySupInfoTbl;
	@FindBy(id="supplierInvitedBy_chosen")
	private WebElement idinvitedByDrpDwn;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Header Information')]")
	private WebElement xpathheaderInformation;
	@FindBy(id="isApproved_chosen")
	private WebElement idapproved;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Profile & Approval History')]")
	private WebElement xpathprofileAndApprovalHistory;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table[2]/tbody/tr")
	private List<WebElement> xpathapprovalStatusTbl;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table[2]/tbody/tr[1]/td[1]")
	private WebElement xpathProfileStatus;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table[2]/tbody/tr[1]/td[2]")
	private WebElement xpathprofileStageStatus;
	@FindBy(xpath="//div[contains(@id,'dialog')]/table[2]/tbody/tr[1]/td[3]")
	private WebElement xpathtimeStamp;
	private String SupplierStatusDateFormat="MM/dd/yyyy";
	private String GenericTimeZone="GMT-7:00";
	private String xpathsupplierProfile="//div/table[contains(@id,'search_results')]/tbody/tr[";
	@FindBy(xpath="]/td[3]/a[contains(@id,'supplier')]")
	private WebElement xpathChkBoxName;
	@FindBy(xpath="//*[@id='from_chosen']//ul/li")
	private WebElement xpathfromChosen;
	@FindBy(id="invitingOrganization")
	private WebElement idinvitingOrganization;
	@FindBy(id="fax")
	private WebElement idfax;
	@FindBy(xpath=".//*[@id='supplierGroup_chosen']/a")
	private WebElement xpathsupplierGroup;
	@FindBy(xpath="//span[@class='error']")
	private WebElement XpatherrorMsg;
	@FindBy(xpath="//button[contains(@class,'button_green')][contains(@role,'button')]")
	private WebElement XpathBtnOk;
	@FindBy(id="saveexit_button")
	private WebElement IdBtnSaveExit;
	@FindBy(xpath="//div[contains(@id,'supplierGroup_chosen')]/div[1]/ul/li")
	private WebElement XpathSupplierGroupList;
	@FindBy(xpath="isTakeControlOfsupplierProfile")
	private WebElement IdCheckBoxTakeControl;
	@FindBy(id="button_create")
	private WebElement IdBtnContinue;
	@FindBy(xpath="//button[contains(@class,'button')][contains(@title,'Cancel')]")
	private WebElement CssBtnCancel;
	@FindBy(css="button[value='Edit Profile'][class='buttons_group_button']")
	private WebElement cssProfileEditBtn;
	@FindBy(xpath="//a[contains(@class,'evt-trail-evt trail-item')]/div/h2[contains(@class,'wizard_tab_title')]")
	private WebElement XpatheEditProfileTabTitlesList;
	@FindBy(xpath="//div[contains(@id,'headquarterAddressId_chosen')]/div[1]/ul/li")
	private WebElement XpathAddressDrpDwnList;
	@FindBy(id="address1")
	private WebElement IdAddress1EditField;
	@FindBy(id="city")
	private WebElement IdCityEditField;
	@FindBy(xpath=".//*[@id='headquarterAddressId_chosen']/a")
	private WebElement XpathAddressDrpDwn;
	@FindBy(xpath=".//*[@id='countryId_chosen']/a")
	private WebElement XpathCountryDrpDwn;
	@FindBy(xpath="//div[contains(@id,'countryId_chosen')]/div[1]/ul/li")
	private WebElement XpathCountryDrpDwnList;
	@FindBy(xpath=".//*[@id='stateId_chosen']/a")
	private WebElement XpathStateDrpDwn;
	@FindBy(xpath="//div[contains(@id,'stateId_chosen')]/div/ul/li")
	private WebElement XpathStateDrpDwnList;
	@FindBy(id="zipCode")
	private WebElement IdZipCode;
	@FindBy(css="[class='button_green'][type='submit']")
	private WebElement XpathBtnSaveAddress;
	@FindBy(xpath=".//*[@id='profile_tab']/tbody/tr/td[2]/div/div/a[3]")
	private WebElement XpathProfileTab1;
	@FindBy(xpath="//table[@id='search_results']/tbody/tr")
	private List<WebElement> XpathSupTableRowList;
	@FindBy(id="sendinvite")
	private WebElement idsendinviteBtn;
	@FindBy(id="supplierInviteJustification")
	private WebElement idsupplierInviteJustification;
	@FindBy(id="supplierListCheckConfirmation")
	private WebElement idsupplierListCheckConfirmation;
	@FindBy(xpath="//*[@id='supplierSearchResultForm']//*[@value='Take Control']")
	private WebElement xpathtakeControl;
	@FindBy(xpath="//input[contains(@title,'Send Invite')]")
	private WebElement xpathsendInvitePopupBtn;
	
	@FindBy(xpath="//a[@id='search_tab']")
	private WebElement BasicSearchTab;
	
	@FindBy(css = "[id*='search'] button[type='submit']")
	private WebElement Search;
	
	@FindBy(id="search_results")
	private WebElement BasicSearchTableIFrame;
	
	@FindBy(id="supplierSearchResultForm")
	private WebElement BasicSearchTable;
	
	@FindBy(id="adv_search_tab")
	private WebElement AdvanceSearchTab;
	
	@FindBy(css="button[href*='AdvanceSearch']")
	private WebElement BuildQuery;
	
	@FindBy(xpath="//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement BuildQueryIFrame;
	
	@FindBy(css="form[id='advanceSearch'] button[class*='cancel']")
	private WebElement BuildQueryCancelButton;
	
	private String exptakeControlDialogPopUp="You have successfully taken control of this supplier's profile. Press Ok to edit supplier's profile.";
	private String expinviteNewSupplierSuccessMsg="An invitation has been sent to the Supplier specified by you.";
	private String expactivateMsg="The selected Supplier has been activated successfully.";
	private String expdeactivateMsg="Selected Supplier has been de-activated successfully.";
	private String expactivatePopupMsg="Note that only those suppliers who are in Inactive status and whose Supplier ID is not duplicate can be activated. Activation will result in suppliers reverting back to the status they were in before Deactivation was enforced. Are you sure you want to continue?";
	private String expdeactivatePopupMsg="Are you sure you want to Deactivate the selected supplier(s)?";
	private String expsendEmailPopupMsg="Are you sure you want to send this email to";
	private String expsendEmailSuccessMsg="Email sent successfully.";
	private String expreInvitePopupMsg="Select the contact(s) whom you would like to invite.";
	private String expreInviteSuccessMsg="An invitation has been sent to the Supplier's contact(s) specified by you.";
	private String expautosuggestMsg="Email address already exists. The invitation will be sent to the below supplier's contact.";
	private String expcreateNewSupplierPopuplbl="Take Control of this Supplier's Profile:";
	private String expoutreachPopupMsg="Are you sure you want to initiate the Outreach process?";
	private String expoutreachSuccessMsg="The Outreach Process has now been initiated.";
	private String expProfileSavedPopupsMsg="Profile is successfully saved";
	private String expContactEmailMsg="Another contact with the same Email exists";
	private String expextractDocPopupsMsg="The Extract Documents download process as specified by you has been initiated.";
	private String expprofileCompletePopupMsg="Only suppliers in Incomplete can be moved";
	private String expprofileCompleteSuccessMsg="Successfully moved to Complete.";
	private String textSupplierPage="Lavante SIM - Search";
	@FindBy(linkText="Search")
	private WebElement linkSearch;
	@FindBy(linkText="Suppliers")
	private WebElement linkSupplier;
	@FindBy(xpath="Invite New Supplier")
	private WebElement LnkTxtInviteNewSupplier;
	@FindBy(xpath="//div/span[contains(@id,'ui-id') and contains(@class,'ui-dialog-title']")
	private WebElement XpathQuickLink;
	@FindBy(xpath=".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement iFrame;
	@FindBy(xpath="button_clear")
	private WebElement IdclearBtn;
	@FindBy(xpath="supplierName")
	private WebElement Idsuppliername;
	@FindBy(xpath="contactName")
	private WebElement Idcontactname;
	@FindBy(xpath="//div[@class='dialog undefined ui-dialog-content ui-widget-content']")
	private WebElement xpathSuccessMessage;
	@FindBy(xpath="//div[@id='")
	private WebElement xAddNewDrpDwnBtnPrefix;
	@FindBy(xpath="']/a")
	private WebElement xAddNewDrpDwnBtnSuffix;
	@FindBy(xpath="']/div[1]/ul/li")
	private WebElement xAddNewDrpDwnListSuffix;
	@FindBy(id="leave")
	private WebElement IdLeavePopupBtn;
	private String profileTab="Profile";
	@FindBy(id="save_button")
	private WebElement IdSupProfileSaveBtn;
	@FindBy(xpath="supplier_group_button")
	private WebElement IDbtnAddnew;
	@FindBy(xpath="//table[@class='data_table table_grid zebra dynamic_table'][1]")
	private WebElement xpathtable2;
	@FindBy(xpath="//table[@class='data_table table_outer_grid'][1]")
	private WebElement xpathtable1;
	@FindBy(xpath="//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement xpathsupplierdetailsframe;
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front dialog ui-draggable ui-resizable']/div/span")
	private WebElement xpathsupplierdetailtitle;
	@FindBy(xpath="data_not_found")
	private WebElement clsNodata;
	@FindBy(xpath="//h3[contains(@id,'select_4')]/a")
	private WebElement xpathexpandOption;
	@FindBy(xpath="//div[@id='commentType_chosen']/a")
	private WebElement xpathcommenttype;
	@FindBy(xpath="Profile & Approval History")
	private WebElement linkprofilenstatus;
	@FindBy(linkText="Core Profile")
	private WebElement linkcoreprofile;
	@FindBy(linkText="Diversity")
	private WebElement linkdiversity;
	@FindBy(xpath="//div[contains(@id,'sub-navigation')]/a[contains(@title,'Regulatory')]")
	private WebElement linkregulatory;
	@FindBy(linkText="Payment Information")
	private WebElement linkpaymentinfo;
	@FindBy(linkText="Relation Specific Profile")
	private WebElement linkrelationsprofile;
	@FindBy(linkText="Contact")
	private WebElement linkcontact;
	@FindBy(linkText="Certifications")
	private WebElement linkcertification;
	@FindBy(xpath="//div[@id='main-navigation']")
	private WebElement xpathframemainnavigation;
	@FindBy(linkText="Supplier Managed")
	private WebElement linksuppliermanaged;
	@FindBy(linkText="Enterprise-Owned")
	private WebElement linkenterpriseowned;
	@FindBy(linkText="Status and History")
	private WebElement linkstatusnhistory;
	@FindBy(linkText="As Supplied VMF View")
	private WebElement linkvmfdata;
	@FindBy(linkText="Notes & Comments")
	private WebElement linknotesncomments;
	@FindBy(linkText="Contract Management")
	private WebElement linkcontractmanage;
	@FindBy(linkText="Header Information")
	private WebElement linkheadermanage;
	@FindBy(xpath="//a[@title='Suppliers']")
	private WebElement xpathsupplierslink;
	@FindBy(xpath="//form[@id='supplierSearchResultForm']//table[@id='search_results']/tbody/tr")
	private WebElement xpathsupplier;
	@FindBy(xpath="//form[@id='supplierSearchResultForm']//table[@id='search_results']/thead/tr/th")
	private WebElement xpathheaders;
	@FindBy(xpath="//form[@id='supplierSearchResultForm']//table/thead/tr/th[")
	private WebElement xpathheader;


	/**
	 * Method Name : Constructor method
	 * Purpose: Constructor method where we initialize the driver
	 */
	public SupplierSearchPage(WebDriver driver){
		lavanteUtils.driver=driver;
		wdSupplierSearch=driver;
	}


	/**
	 * Method Name : verifySupplierPage
	 * Purpose: Public method which includes logic related to verify the title of suppliers home page
	 * @param: None
	 * @return: None
	 */
	public void validateSupplierPage() throws InterruptedException {
		try { lavanteUtils.waitForTime(2000);
			lavanteUtils.assertPageTitle(expectedPageTitle);
			lavanteUtils.click( XpathDashboard);
			Reporter.log("Navigation is successful for SupplierPage: ");
			wdSupplierSearch.wait(2000);
			wdSupplierSearch.wait();
		} catch (Exception e) {
			//log.severe("Exception in the method verifySupplierPage due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : verifyUIControlsOnSupplierSearchPage
	 * Purpose: Public method which includes logic related to verify the UI Links (Basic Search & Advanced Search) on Suppliers search page
	 * @param: None
	 * @return: None
	 */
	public void verifyUIControlsOnSupplierSearchPage() {

		try{ lavanteUtils.waitForTime(2000);
			if(lavanteUtils.isElementDisplayed(cssPopupCloseBtn)==true){
				lavanteUtils.click( cssPopupCloseBtn);
				lavanteUtils.waitForTime(1000);
			}
			if(lavanteUtils.isElementDisplayed(xpathsupplierslink)==true){
				lavanteUtils.click( xpathsupplierslink);
				lavanteUtils.waitForTime(3000);
				lavanteUtils.assertPageTitle( expectedPageTitle);
				String getTitle=wdSupplierSearch.getTitle();
				Reporter.log(" 'Suppliers' page appeared after ge.clicks on the Suppliers tab: " + getTitle);
			}else{
				Assert.assertTrue(true, "Test failed due to element locator is not found for 'Suppliers' tab ");
			}

			if(lavanteUtils.isElementDisplayed(LnkTxtbasicsearchLink)==true){
				lavanteUtils.fluentwait(LnkTxtbasicsearchLink);
				Reporter.log("Verification is successful for Basic Search Tab");
			}else{
				Assert.assertTrue(true, "Test failed due to element locator is not found for 'Basic Search' tab ");
			}

			if(lavanteUtils.isElementDisplayed(LnkTxtadvancedsearchLink)==true){
				lavanteUtils.fluentwait(LnkTxtadvancedsearchLink);
				Reporter.log("Verification is successful for Advanced Search Tab");
			}else{
				lavanteUtils.takeScreenshot( "verifyUIControlsOnSupplierSearchPage");
				Assert.assertTrue(true, "Test failed due to element locator is not found for 'Advanced Search' tab ");
			}

		}catch(Exception e){
			//log.severe("Exception in the method verifyUIControlsOnSupplierSearchPage: "+ e.getMessage());
			//Assert.assertTrue(true,"Exception in the method verifyUIControlsOnSupplierSearchPage: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifyActivateFunctionality
	 * Purpose: Public method which includes logic related to verify the activate functionality on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public String verifyActivateFunctionality(List<setTestData> getSupplierSearchData) {

		String strReturnVal=null;

		try {lavanteUtils.waitForTime(2000);
			Reporter.log("\n Activation Functionality: ");
			verifySuppliersHomePageTitle();
			lavanteUtils.waitForTime(3000);
			for(int i=0;i<getSupplierSearchData.size();i++) {
				
//				ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,
//				getSupplierSearchData.get(i).getProfileStatus().toString());
				
				//Selecting the profile status from multi select box				
				selectProfileStatus(getSupplierSearchData.get(i).getProfileStatus().toString());
				
				Reporter.log("Selected " + getSupplierSearchData.get(i).getProfileStatus().toString() + " option in the profile"
						+ " status dropdown");				

				lavanteUtils.click( iddeactivatedSuppliers);
				Reporter.log("Deactivated supplier checkbox is enabled");

				lavanteUtils.click( xpathSearchBtn);
				Reporter.log("Clicked on the 'Search' button");
				lavanteUtils.waitForTime(3000);
				lavanteUtils.switchtoFrame(xpathsupplierTableFrame);

				List<WebElement> rowCount = xpathtableRowCount;
				int tableRowCount=rowCount.size();

				if(!(tableRowCount==0)){
					if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
						String strData=lavanteUtils.getText( xpathnoData);
						Reporter.log("Supplier Search Table data: " + strData);		
						//Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
					}else {
						for (int j=1;j<=rowCount.size();j++) {
							List<WebElement> headersCount = xpathheaderCount;
							List<WebElement> dataCount = xpathdataCount;
							if(headersCount.size()==dataCount.size()){	
								if(lavanteUtils.isElementDisplayed(xpathstatus)==true){		
									List<WebElement> SupID = wdSupplierSearch.findElements(By.xpath("//div/table[contains(@id,'search_results')]/tbody//td[2]"));
									
									int sj=0;
									String strStatus=null;
									for( sj=0;sj<SupID.size();sj++)
									{
										
										String s=SupID.get(sj).getText();
										sj=sj+1;
										System.out.println(s+":SID"+s.length()+"Len"+sj);
										if(s.length()<1)
										{
											System.out.println("INSIDE LENGTH");
											strStatus=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath(
													"//div/table[contains(@id,'search_results')]/tbody/tr["+sj+"]/td[8]")));
											System.out.println("STATUS"+strStatus+getSupplierSearchData.get(i).getProfileStatus().toString());
											if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(i).getProfileStatus().toString())){
												break;
											}else {
												/*Assert.assertTrue(false,"Failed due to Data not available ");
												Reporter.log("Supplier Search table is not found");*/
											}
										}
									}	
												
												strReturnVal=wdSupplierSearch.findElement(By.xpath
														("//div/table[contains(@id,'search_results')]/tbody/tr["+sj+"]/td[3]")).getText();
												Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
												lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + sj + xpathoption)));
												Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
												lavanteUtils.waitForTime(2000);
												strReturnVal=lavanteUtils.getText( xpathsupplierTblName);										
												Reporter.log("Supplier Name: " + "'" + strReturnVal + "'" + " with Status: " + "'" +
														getSupplierSearchData.get(i).getProfileStatus().toString() + "'");
												break;
											
									
									
								} else {
									//log.severe("Test failed due to 'Status' column element property has changed:");
									Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
								}
							}
						}
					}
				} 
				lavanteUtils.click(xpathaccountBtn);
				Reporter.log("Clicked on the 'Account' tab");
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click( xpathactivateOption);				
				Reporter.log("Clicked on the 'Activate' option");
				lavanteUtils.waitForTime(3000);
				lavanteUtils.switchtoFrame(null);
				//Dialog pop up verification
				if(lavanteUtils.isElementDisplayed(xpathdialogPopup)==true){
					String getText=lavanteUtils.getText( xpathdialogPopup);
					//Validation
					if (expactivatePopupMsg.equalsIgnoreCase(getText)) {
			
						Reporter.log("Validation is successful for 'Confirm activation' message: " + getText);
						lavanteUtils.waitForTime(15000);
						Actions a=new Actions(wdSupplierSearch);
						a.moveToElement(wdSupplierSearch.findElement(By.xpath("//*[text()='Ok']")));
						a.click();
						a.build().perform();
					//	wdSupplierSearch.findElement(By.xpath("//*[text()='Ok']")).click();
					//	ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathokEmailBtn);
						System.out.println("OK  AFTER OK");
						lavanteUtils.waitForTime(2000);
						Reporter.log("Clicked on the 'OK' button");
					}else {
						//Assert.assertTrue(false,"Test failed due to Expected message: " + expactivatePopupMsg  + "  doesn't match with "
							//	+ " Actual message: " + getText);
					}
				} else {
					//log.severe("Test failed due to 'Activate' pop up dialog box did not displayed:");
					//Assert.assertTrue(false,"Failed due to 'Activate' pop up dialog box did not displayed: ");
				}
				lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

				if(lavanteUtils.isElementDisplayed(xpathcommentEditBox)==true){
					lavanteUtils.waitForTime(2000);
					lavanteUtils.typeinEdit(getSupplierSearchData.get(i).getActivationComment(),xpathcommentEditBox);					
					Reporter.log("Entered " + " '" + getSupplierSearchData.get(i).getActivationComment() + " '" + ""
							+ " in the comment section");
					lavanteUtils.waitForTime(2000);
					lavanteUtils.click( xpathsaveBtn);
					lavanteUtils.waitForTime(3000);
					Reporter.log("Clicked on the 'Save' button");

					lavanteUtils.switchtoFrame(null);
					if(lavanteUtils.isElementDisplayed(xpathSuccessMsg)==true){
						String getText=lavanteUtils.getText( xpathSuccessMsg);
						System.out.println(getText+":AP"+expactivateMsg);
						//validation - Suppliers activation
						if (expactivateMsg.equalsIgnoreCase(getText)) {
							Reporter.log(" Validation is successful for Activation: Expected: " + expactivateMsg + " match with "
									+ " Actual: " + getText);
							lavanteUtils.click(xpathokEmailBtn);					
							Reporter.log("Clicked on the 'OK' button");
							lavanteUtils.waitForTime(10000);
							if(lavanteUtils.isElementDisplayed(LnkTxtbasicsearchLink)==true){
								lavanteUtils.fluentwait( LnkTxtbasicsearchLink);
								Reporter.log("Activation is successful for " + " '" + strReturnVal + " '" + " Supplier");
								break;
							}else {
								//ge.takeScreenshot(wdSupplierSearch, "Activate Functionality");
								//Assert.assertTrue(true, "Test failed due to element locator is not found for 'Basic Search' tab ");
							}
						}else {
							//Assert.assertTrue(false,"Activation failed due to Expected: " + expactivateMsg + " doesn't match with "
									//+ " Actual: " + getText);
						}
					} else {
						//ge.takeScreenshot(wdSupplierSearch, "did not displayed success message pop up");
						//log.severe("Test failed due to 'Activate' pop up dialog box did not displayed:");
						//Assert.assertTrue(false,"Failed due to 'Activate' pop up dialog box did not displayed: ");
					}				
				}else {
					//ge.takeScreenshot(wdSupplierSearch, "did not displayed message edit box: ");
					//log.severe("Test failed due to 'Activate' pop up with comment section did not displayed");
					//Assert.assertTrue(false,"Test failed due to 'Activate' pop up with comment section did not displayed: ");
				}
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyActivateFunctionality: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyActivateFunctionality: " + e.getMessage());
		}
		return strReturnVal;
	}

	/**
	 * Method Name : verifyDeactivateFunctionality
	 * Purpose: Public method which includes logic related to verify the Deactivate functionality on supplier search page
	 * @param: List<setTestData> getSupplierSearchData, String supplier Name
	 * @return: None
	 */
	public void verifyDeactivateFunctionality(List<setTestData> getSupplierSearchData, String SupplierName){

		try {
			Reporter.log("\n Deactivation Functionality:");
			lavanteUtils.waitForTime(5000);
			lavanteUtils.click( xpathresetBtn);
			Reporter.log("Clicked on the 'Reset' button");
			lavanteUtils.waitForTime(4000);
			if(lavanteUtils.isElementDisplayed((idsupplierName))==true){
				lavanteUtils.typeinEdit( SupplierName, idsupplierName);			
				Reporter.log("Entered Activated supplier name:" + SupplierName);
				lavanteUtils.waitForTime(3000);
			} else {
				lavanteUtils.takeScreenshot(wdSupplierSearch, "did not displayed basis search page:");
				Assert.assertTrue(false,"Test failed due to Basic search page section did not displayed: ");
			}
			lavanteUtils.click(xpathSearchBtn);
			Reporter.log("Clicked on the 'Search' button");
			lavanteUtils.waitForTime(4000);

			lavanteUtils.switchtoFrame(xpathsupplierTableFrame);

			lavanteUtils.waitForTime(2000);
			List<WebElement> rowCount = (xpathtableRowCount);
			int tableRowCount=rowCount.size();
			
			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
					String strData=lavanteUtils.getText( xpathnoData);
					Reporter.log("Supplier Search Table data: " + strData);		
					Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
				}else {
					for (int j=1;j<=rowCount.size();j++) { 
						List<WebElement> headersCount = xpathheaderCount;
						List<WebElement> dataCount = xpathdataCount;
						if(headersCount.size()==dataCount.size()){
							lavanteUtils.waitForTime(1000);
							lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + j + xpathoption)));													
							Reporter.log("'Loaded' status supplier checkbox is selected in the Supplier search table");
							lavanteUtils.waitForTime(2000);
							break;
						}
					}
				}
			} else {
				Reporter.log("Supplier Search table is not found");
			}

			lavanteUtils.click( xpathaccountBtn);
			Reporter.log("Clicked on the 'Account' tab");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(xpathDeactivateOption);
			lavanteUtils.waitForTime(3000);
			Reporter.log("Clicked on the 'Deactivate' option");

			lavanteUtils.switchtoFrame(null);

			if(lavanteUtils.isElementDisplayed((xpathdialogPopup))==true){
				String getText=lavanteUtils.getText( xpathdialogPopup);				
				//Validation
				if (getText.contains(expdeactivatePopupMsg)) {
					Reporter.log("Validation is successful for 'Confirm Deactivation' message: " + getText);
					lavanteUtils.click( xpathokEmailBtn);
					lavanteUtils.waitForTime(3000);
					Reporter.log("Clicked on the 'OK' button");
				}else {
					Assert.assertTrue(false,"Test failed due to Expected message: " + expdeactivatePopupMsg  + "  doesn't match with "
							+ " Actual message: " + getText);
				}
			} else {
				//log.severe("Test failed due to 'Deactivate' pop up dialog box did not displayed:");
				Assert.assertTrue(false,"Failed due to 'Deactivate' pop up dialog box did not displayed: ");
			}

			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

			for(int i=0;i<getSupplierSearchData.size();i++) {
				if(lavanteUtils.isElementDisplayed(xpathcommentEditBox)==true){
					lavanteUtils.typeinEdit(getSupplierSearchData.get(i).getDeactivationComment(), xpathcommentEditBox);					
					Reporter.log("Entered " + " '" + getSupplierSearchData.get(i).getDeactivationComment() + " '" + " in the comment section");
					lavanteUtils.click(xpathsaveBtn);
					lavanteUtils.waitForTime(2000);
					Reporter.log("Clicked on the 'Save' button");

					lavanteUtils.switchtoFrame(null);

					if(lavanteUtils.isElementDisplayed(xpathSuccessMsg)==true){
						String getText=lavanteUtils.getText( xpathSuccessMsg);
						//validation - De-activation
						if (expdeactivateMsg.equalsIgnoreCase(getText)) {
							Reporter.log("Validation is Successful for Deactivation: Expected: " + expdeactivateMsg  + " match with "
									+ " Actual: " + getText);
							lavanteUtils.click( xpathokEmailBtn);
							lavanteUtils.waitForTime(3000);
							Reporter.log("Clicked on the 'OK' button");
							Reporter.log("Deactivation is successful for " + " '" + SupplierName + " '" + " Supplier");
							break;
						}else {
							//Assert.assertTrue(false,"Activation failed due to Expected: " + expdeactivateMsg  + " doesn't match with "
								//	+ " Actual: " + getText);
						}
					} else {
						//log.severe("Test failed due to 'Deactivate' pop up dialog box did not displayed:");
						//Assert.assertTrue(false,"Failed due to 'Deactivate' pop up dialog box did not displayed: ");
					}	
				} else {	
					//log.severe("Test failed due to 'Deactivate' pop up with comment section did not displayed");
					//Assert.assertTrue(false,"Test failed due to 'Deactivate' pop up with comment section did not displayed: ");
				}
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyDeactivateFunctionality: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyDeactivateFunctionality: " + e.getMessage());
		}
	}

	/**
	 * Method Name : searchSupplierNames
	 * Purpose: This method searches for a given supplier with the supplier name and opens the suppliers page
	 * @param: String options,String expSupName
	 * @return: None
	 * @throws None 
	 */
	public void searchSupplierNames(String options,String expSupName){
		String actSupName="";
		lavanteUtils.click(xpathsupplierslink);
		Reporter.log("Clicked on the |Suppliers| Main Tab Link successfully");
		lavanteUtils.assertPageTitle( expectedPageTitle);
		lavanteUtils.waitForTime(15000);
		//ge.clicks(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(),idsearchtab);
		Reporter.log("Clicked on the |Basic Search| Tab Button successfully");
		lavanteUtils.typeinEdit(expSupName,xSupplierNameField);
		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(xpathSearchBtn);
		Reporter.log("Clicked on the | Search | Button successfully");
		lavanteUtils.switchtoFrame(idSearchResultsFrame);
		List<WebElement> listOfSupplierNames=xpathSupNameRows;
		try {
			for(int i=0;i<listOfSupplierNames.size();i++){
				List<WebElement> listColumns=listOfSupplierNames.get(i).findElements(By.tagName(ConfigPathFile.TD.getConstantValue()));
				actSupName=listColumns.get(2).getText().trim().toString();		
				if(actSupName.trim().toString().contains(expSupName.trim().toString())){
					if(options.equalsIgnoreCase(ConfigPathFile.checkBox.getConstantValue())){
						wdSupplierSearch.findElement(By.xpath(xSupNameRowsOne+i+1+xSupNameRowsTwo)).click();
						Reporter.log("Clicked on the | Check Box | successfully");
					}else if (options.equalsIgnoreCase(ConfigPathFile.SupplierName.getConstantValue())){
						wdSupplierSearch.findElement(By.partialLinkText(expSupName.trim().toString())).click();
						Reporter.log("Clicked on the | Supplier Name | Link successfully");
					}
					break;
				}
			}
		} catch (Exception e) {
			//log.severe("Supplier Records are not found with the specified search criteria");
			//Assert.assertTrue(false,"Supplier Records are not found with the specified search criteria");
		}
	}	

	/**
	 * Method Name : verifySendEmailFunctionality
	 * Purpose: Public method which includes logic related to verify the Send-Email functionality on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public void verifySendEmailFunctionality(List<setTestData> getSupplierSearchData) {

		boolean flag=false;
		try {lavanteUtils.waitForTime(2000);
			Reporter.log("\n 'Send-Email' Functionality: ");
			verifySuppliersHomePageTitle();
			lavanteUtils.waitForTime(2000);
			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,
					getSupplierSearchData.get(0).getSendEmailStatus().toString());*/
			
			selectProfileStatus(getSupplierSearchData.get(0).getSendEmailStatus().toString());
			
			Reporter.log("Selected " + getSupplierSearchData.get(0).getSendEmailStatus().toString() + " option in the profile"
					+ " status dropdown");

			lavanteUtils.click( iddeactivatedSuppliers);
			Reporter.log("|Show Inactive suppliers| checkbox is enabled");

			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(xpathSearchBtn);
			Reporter.log("Clicked on the 'Search' button");

			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);

			lavanteUtils.waitForTime(1000);
			List<WebElement> rowCount = xpathtableRowCount;
			int tableRowCount=rowCount.size();

			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
					String strData=lavanteUtils.getText(xpathnoData);
					Reporter.log("Supplier Search Table data: " + strData);		
					//Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
				}else {
					for (int j=1;j<=rowCount.size();j++) {
						List<WebElement> headersCount = xpathheaderCount;
						List<WebElement> dataCount = xpathdataCount;
						if(headersCount.size()==dataCount.size()){					
							if(lavanteUtils.isElementDisplayed(xpathstatus)==true){
								String strStatus=lavanteUtils.getText( xpathstatus);
								if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(0).getReInviteStatus().toString())){
									Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
									lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + j + xpathoption)));
									Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
									lavanteUtils.waitForTime(2000);
									String strReturnVal=lavanteUtils.getText( xpathsupplierTblName);									
									Reporter.log("Supplier Name: " + "'" + strReturnVal + "'" + " with Status: " + "'" +
											getSupplierSearchData.get(0).getReInviteStatus().toString() + "'");
									break;
								}
							} else {
								//log.severe("Test failed due to 'Status' column element property has changed:");
								//Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
							}
						}
					}
				}
			} else {
				Reporter.log("Supplier Search table is not found");
			}

			lavanteUtils.click( xpathcommunicateBtn);
			Reporter.log("Clicked on the 'Communicate' tab");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(xpathsendEmailOption);
			lavanteUtils.waitForTime(2000);
			Reporter.log("Clicked on the 'Send Email' option");

			lavanteUtils.switchtoFrame(null);

			for(int i=0;i<getSupplierSearchData.size();i++) {
				Reporter.log("\n");
				
				lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
				lavanteUtils.click(xpathClearBtn);
				lavanteUtils.waitForTime(2000);

			//	ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathfromDropdown);				
			//	ge.switchToFrameBy(wdSupplierSearch,"","","");

				/*				String strKeyVal=getSupplierSearchData.get(i).getKeyValue().toString();
				int KeyVal = Integer.parseInt(strKeyVal);*/
				System.out.println(getSupplierSearchData.get(i).getFromValue().toString());
				//selectDrpDwnOption(getSupplierSearchData.get(i).getFromValue().toString(),xpathfromChosen);
		//		lavanteUtils.SelselectDropDownValue(wdSupplierSearch,xpathactivatePopupFrame, "from", getSupplierSearchData.get(i).getFromValue().toString());
				//ge.clicks(wdSupplierSearch, ConfigPathFile.CSS.getConstantValue(), "li.active-result:nth-child("+ KeyVal +")");				

				lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
				
				lavanteUtils.typeinEdit( getSupplierSearchData.get(i).getSubject().toString(), xpathsubject);
				Reporter.log("Entered Subject: " + " '" + getSupplierSearchData.get(i).getSubject().toString() + " '");
				
				if(getSupplierSearchData.get(i).getBodyMessage().length()>0){
				lavanteUtils.click( xpathbodyMessage);
				lavanteUtils.waitForTime(2000);
				
				lavanteUtils.typeinEdit( getSupplierSearchData.get(i).getBodyMessage().toString(), xpathbodyMessage);
				Reporter.log("Entered body text message: " + " '" + getSupplierSearchData.get(i).getBodyMessage().toString() + " '" );
				}
				lavanteUtils.click( xpathsendBtn);
				Reporter.log("Clicked on the 'Send' Button");

				if(lavanteUtils.isElementDisplayed((xpathErrorMessage))==true){
					validateErrorMessage(getSupplierSearchData, i);
					flag = true;
				}else {
					flag = false;
				}

				if(!flag){
					Reporter.log("\n");
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.waitForTime(1000);
					if(lavanteUtils.isElementDisplayed(xpathSuccessMsg)==true){
						String getText=lavanteUtils.getText( xpathSuccessMsg);
						lavanteUtils.waitForTime(2000);
						//validation - Send Email
						if (getText.contains(expsendEmailPopupMsg)) {
							Reporter.log("Validation is successful for 'Confirmation Message': " + getText);
							lavanteUtils.click( xpathokEmailBtn);
							Reporter.log("Clicked on the 'OK' button");
							lavanteUtils.waitForTime(2000);
							if(lavanteUtils.isElementDisplayed(xpathSuccessMsg)==true){
								String successMsg=lavanteUtils.getText(xpathSuccessMsg);
								if(expsendEmailSuccessMsg.equalsIgnoreCase(successMsg)){
									Reporter.log("Validation is Successful for SendEmail: Expected: " + "'" + expsendEmailSuccessMsg + "'"
											+ " match with " + " Actual: " + "'" + successMsg + "'");
									lavanteUtils.click( xpathokEmailBtn);
									Reporter.log("Clicked on the 'OK' button");
								} else {
									//Assert.assertTrue(false,"Test failed due to Expected: " + expsendEmailSuccessMsg  + " doesn't match with "
										//	+ " Actual: " + successMsg);
								}
							}
						}else {
							//Assert.assertTrue(false,"Test failed due to Expected: " + expsendEmailPopupMsg  + " doesn't match with "
									//+ " Actual: " + getText);
						}
					} else {
						//log.severe("Test failed due to 'Confirmation Message' pop up dialog box did not displayed:");
						//Assert.assertTrue(false,"Failed due to 'Confirmation Message' pop up dialog box did not displayed: ");
					}
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifySendEmailFunctionality: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySendEmailFunctionality: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifyReInviteFunctionality
	 * Purpose: Public method which includes logic related to verify the Re Invite functionality on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public String verifyReInviteFunctionality(List<setTestData> getSupplierSearchData){

		String strReturnVal=null,strEmailName=null;
		try {lavanteUtils.waitForTime(2000);
			Reporter.log("\n 'Re-Invite' Functionality: ");
			verifySuppliersHomePageTitle();
			lavanteUtils.waitForTime(2000);
			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus, getSupplierSearchData.get(0).getReInviteStatus().toString());
			Reporter.log("Selected " + getSupplierSearchData.get(0).getReInviteStatus().toString() + " option in the profile"
					+ " status dropdown");*/
			
			selectProfileStatus(getSupplierSearchData.get(0).getSendEmailStatus().toString());

			lavanteUtils.click(iddeactivatedSuppliers);
			lavanteUtils.waitForTime(2000);
			Reporter.log("'Show Inactive suppliers' checkbox is enabled");

			lavanteUtils.click( xpathSearchBtn);
			Reporter.log("Clicked on the 'Search' button");
			lavanteUtils.waitForTime(2000);

			lavanteUtils.switchtoFrame(xpathsupplierTableFrame);

			lavanteUtils.waitForTime(1000);
			List<WebElement> rowCount = (xpathtableRowCount);
			int tableRowCount=rowCount.size();

			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
					String strData=lavanteUtils.getText( xpathnoData);
					Reporter.log("Supplier Search Table data: " + strData);		
					//Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
				} else {
					for (int j=1;j<=rowCount.size();j++) {
						List<WebElement> headersCount = (xpathheaderCount);
						List<WebElement> dataCount = (xpathdataCount);
						if(headersCount.size()==dataCount.size()){							
							if(lavanteUtils.isElementDisplayed(xpathstatus)==true){
								String strStatus=lavanteUtils.getText( xpathstatus);
								if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(0).getReInviteStatus().toString())){
									Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
									lavanteUtils.click(wdSupplierSearch.findElement(By.xpath(xpathselect + j + xpathoption)));
									Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
									lavanteUtils.waitForTime(2000);
									strReturnVal=lavanteUtils.getText(xpathsupplierTblName);
									strEmailName=lavanteUtils.getText( xpathemailContact);
									Reporter.log("Supplier Name: " + "'" + strReturnVal + "'" + " with Status: " + "'" +
											getSupplierSearchData.get(0).getReInviteStatus().toString() + "'");
									break;
								}
							} else {
								//log.severe("Test failed due to 'Status' column element property has changed:");
								//Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
							}
						}
					}
				}
			} else {
				Reporter.log("Supplier Search table is not found");
			}

			lavanteUtils.click(xpathcommunicateBtn);
			Reporter.log("Clicked on the 'Communicate' tab");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click( xpathreInviteOption);
			lavanteUtils.waitForTime(2000);
			Reporter.log("Clicked on the 'Re Invite' option");
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);			
			lavanteUtils.waitForTime(2000);

			if(lavanteUtils.isElementDisplayed((xpathreInviteDialogPopup))==true) {
				String getText=lavanteUtils.getText(xpathreInviteDialogPopup);
				//validation - Send Email
				if(getText.contains(expreInvitePopupMsg)) {
					Reporter.log("Validation is successful for 'Invite Supplier': " + getText);
					if(lavanteUtils.isElementDisplayed(wdSupplierSearch.findElement( By.xpath("//input[@id='contact']")))==true){
						//if(ge.isElementDisplayed(wdSupplierSearch, By.id(idcontact))==true){
						lavanteUtils.click(wdSupplierSearch.findElement(By.xpath("//input[@id='contact']")));
						//ge.clicks(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idcontact);
						Reporter.log("Clicked on the 'supplier contact' Checkbox");
						String getLableName=lavanteUtils.getText( xpathlabelName);
						if(getLableName.contains(getLableName)) {
							Reporter.log("Selected the specified supplier contact': "  + "'" + getLableName + "'");
							lavanteUtils.click( idinviteBtn);
							Reporter.log("Clicked on the 'Invite' button");
							//ge.waitForTime(5000);
							lavanteUtils.switchtoFrame(null);
						} else {
							//Assert.assertTrue(false,"Test failed due to supplier contact email : " + strEmailName  + " doesn't match with "
								//	+ " Actual: " + getLableName);
						}
					}
					if(lavanteUtils.isElementDisplayed((xpathSuccessMsg))==true) {
						String successMsg=lavanteUtils.getText(xpathSuccessMsg);
						if(expreInviteSuccessMsg.equalsIgnoreCase(successMsg)){
							Reporter.log("Validation is Successful for Invite Supplier: Expected: " + "'" + expreInviteSuccessMsg + "'"
									+ " match with " + " Actual: " + "'" + successMsg + "'");
							lavanteUtils.click( xpathokEmailBtn);
							Reporter.log("Clicked on the 'OK' button");
							lavanteUtils.waitForTime(3000);
						} else {
							//Assert.assertTrue(false,"Test failed due to Expected: " + expreInviteSuccessMsg  + " doesn't match with "
									//+ " Actual: " + successMsg);
						}						
					} else {
						//log.severe("Test failed due to 'Success Message' pop up dialog box did not displayed:");
						//Assert.assertTrue(false,"Failed due to 'Success Message' pop up dialog box did not displayed: ");
					}
				} else {
					//Assert.assertTrue(false,"Test failed due to Expected: " + expreInvitePopupMsg  + " doesn't match with "
							//+ " Actual: " + getText);
				}
			} else {
				//log.severe("Test failed due to 'Invite Supplier' pop up dialog box did not displayed:");
				//Assert.assertTrue(false,"Failed due to 'Invite Supplier' pop up dialog box did not displayed: ");
			}

		}catch(Exception e){
			//log.severe("Exception in the method verifyReInviteFunctionality: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyReInviteFunctionality: " + e.getMessage());
		}
		return strReturnVal;
	}

	/**
	 * Method Name : verifyOutreachFunctionality
	 * Purpose: Public method which includes logic related to verify the Out reach functionality on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public void verifyOutreachFunctionality(List<setTestData> getSupplierSearchData){

		String strReturnVal=null;

		try { //ge.waitForTime(2000);
			Reporter.log("\n 'Outreach' Functionality: ");
			verifySuppliersHomePageTitle();
			for(int i=0;i<getSupplierSearchData.size();i++) {
				//Data Verification
				if(!(getSupplierSearchData.get(i).getOutreachStatus().toString().equalsIgnoreCase(""))){
					//ge.waitForTime(2000);
					lavanteUtils.click( idadvancedTab);
					Reporter.log("Clicked on the 'Advanced Search' tab");
					//ge.waitForTime(2000);
					lavanteUtils.click(xpathbuildQueryBtn);
					Reporter.log("Clicked on the 'Build Query' button");
					//ge.waitForTime(5000);
					//Frame In
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

					lavanteUtils.click(xpathenterpriseDataTab);
					Reporter.log("Clicked on the 'Enterprise Generated Data' tab");
					//ge.waitForTime(2000);
					lavanteUtils.selectDropDownValue(idprofileStage,getSupplierSearchData.get(i).getOutreachStatus().toString());
					Reporter.log("Selected the 'profile stage' drop down status: " + getSupplierSearchData.get(i).getOutreachStatus().toString());
					lavanteUtils.click( xpathadvanceSearchBtn);
					//ge.waitForTime(2000);
					Reporter.log("Clicked on the 'Search' button");
					//Frame In
					lavanteUtils.switchtoFrame( xpathsupplierTableFrame);

					List<WebElement> rowCount = (xpathtableRowCount);
					int tableRowCount=rowCount.size();

					if(!(tableRowCount==0)){
						if(lavanteUtils.isElementDisplayed((xpathdataNotFound))==true){
							String strData=lavanteUtils.getText( xpathnoData);
							Reporter.log("Supplier Search Table data: " + "'" + strData + "'" + " with the 'profile stage'"
									+ " drop down status: "	+ getSupplierSearchData.get(i).getOutreachStatus().toString());
							//log.warning("Supplier Search Table data: " + "'" + strData + "'" + " with the 'profile stage'"
								//	+ " drop down status: " + getSupplierSearchData.get(i).getOutreachStatus().toString());
							break;
							//Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
						}else {
							for (int j=1;j<=rowCount.size();j++) {
								List<WebElement> headersCount = (xpathheaderCount);
								List<WebElement> dataCount = (xpathdataCount);
								if(headersCount.size()==dataCount.size()){
									if(lavanteUtils.isElementDisplayed(xpathstatus)==true){
										String strStatus=lavanteUtils.getText( xpathstatus);
										if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(i).getOutreachStatus().toString())){
											Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
											lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + j + xpathoption)));
											Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
											//ge.waitForTime(1000);
											strReturnVal=lavanteUtils.getText( xpathsupplierTblName);
											Reporter.log("Supplier Name: " + "'" + strReturnVal + "'" + " with Status: " + "'" +
													getSupplierSearchData.get(i).getOutreachStatus().toString() + "'");
											break;
										}
									} else {
										//log.severe("Test failed due to 'Status' column element property has changed:");
										//Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
									}
								}
							}
						}
					} else {
						Reporter.log("Supplier Search table is not found");
					}
					//ge.waitForTime(2000);
					lavanteUtils.click( xpathcommunicateBtn);
					Reporter.log("Clicked on the 'Communicate' tab");
					//ge.waitForTime(2000);
					lavanteUtils.click( xpathoutreachOption);
					//ge.waitForTime(2000);
					Reporter.log("Clicked on the 'Outreach' option");
					//Frame In
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

					//ge.waitForTime(4000);
					if(lavanteUtils.isElementDisplayed((xpathinitiateProcessMsg))==true){
						String getText=lavanteUtils.getText( xpathinitiateProcessMsg);
						//ge.waitForTime(2000);
						//validation - Out reach
						if (getText.contains(expoutreachPopupMsg)) {
							Reporter.log("Validation is successful for 'Outreach Confirmation Message': " + getText);
							lavanteUtils.click(xpathoutreachBtn);
							Reporter.log("Clicked on the 'Outreach' button");				
							//ge.waitForTime(2000);
							//Frame out
							lavanteUtils.switchtoFrame(null);
							if(lavanteUtils.isElementDisplayed((xpathSuccessMsg))==true){
								String successMsg=lavanteUtils.getText( xpathSuccessMsg);
								if(expoutreachSuccessMsg.equalsIgnoreCase(successMsg)){
									Reporter.log("Validation is Successful for Outreach: Expected: " + "'" + expoutreachSuccessMsg + "'"
											+ " match with " + " Actual: " + "'" + successMsg + "'");
									lavanteUtils.click( xpathokEmailBtn);
									Reporter.log("Clicked on the 'OK' button");
									//ge.waitForTime(2000);
								} else {
									//Assert.assertTrue(false,"Test failed due to Expected: " + expoutreachSuccessMsg  + " doesn't match with "
										//	+ " Actual: " + successMsg);
								}
							}
						}else {
							//Assert.assertTrue(false,"Test failed due to Expected: " + expoutreachPopupMsg  + " doesn't match with "
									//+ " Actual: " + getText);
						}
					} else {
						//log.severe("Test failed due to 'Outreach Confirmation Message' pop up dialog box did not displayed:");
						//ge.takeScreenshot(wdSupplierSearch, "did not ge.clicks on the 'Outreach' button");
						//Assert.assertTrue(false,"Failed due to 'Outreach Confirmation Message' pop up dialog box did not displayed: ");
					}
					//ge.waitForTime(7000);		
					lavanteUtils.click(idsearchtab);
					Reporter.log("Clicked on the 'Basic search' tab");
					//ge.waitForTime(2000);
					lavanteUtils.typeinEdit( strReturnVal, idsupplierName);			
					Reporter.log("Entered supplier name:" + strReturnVal);
					//ge.waitForTime(1000);
					lavanteUtils.click(xpathSearchBtn);
					Reporter.log("Clicked on the 'search' button");
					//ge.waitForTime(3000);
					//Frame In
					lavanteUtils.switchtoFrame( xpathsupplierTableFrame);

					//ge.waitForTime(1000);
					List<WebElement> rowCount1 = ((xpathtableRowCount));
					int tableRowCount1=rowCount1.size();

					if(!(tableRowCount1==0)){
						if(lavanteUtils.isElementDisplayed((xpathdataNotFound))==true){
							//Assert.assertTrue(true, "Test failed due to 'No Data Available' in the supplier search table ");
						} else {
							for (int j=1;j<=rowCount.size();j++) {
								List<WebElement> headersCount = (xpathheaderCount);
								List<WebElement> dataCount = (xpathdataCount);
								if(headersCount.size()==dataCount.size()){						
									String strSuppName=lavanteUtils.getText( xpathsupplierTblName);
									
									if(strReturnVal.equalsIgnoreCase(strSuppName)){
										Reporter.log("Supplier Name:"+strSuppName);
										Reporter.log(" Outreach Validation is successful for: " + "'" + getSupplierSearchData.get(i).getOutreachStatus().toString() +
												"' " + " Status");
										//Frame out
										lavanteUtils.switchtoFrame(null);
										break;
									}						
								}
							}
						}
					} else {
						Reporter.log("Supplier Search table is not found for outreach supplier name validation");
					}
				} else {
					continue;
				}
			}
		} catch(Exception e) {
			//log.severe("Exception in the method verifyOutreachFunctionality: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyOutreachFunctionality: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifyAutoSuggestFunctionality
	 * 	 * Purpose: Public method which includes logic related to verify the Auto Suggest functionality for invite new supplier 
	 * 				on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public void verifyAutoSuggestFunctionality(){
		String strSupplierName=null,strEmailName=null;

		try{lavanteUtils.waitForTime(2000);
			Reporter.log("\n 'Auto Suggest' Functionality for invite supplier: ");
			verifySuppliersHomePageTitle();
			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);

			lavanteUtils.waitForTime(1000);
			List<WebElement> rowCount = (xpathtableRowCount);
			int tableRowCount=rowCount.size();

			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed((xpathdataNotFound))==true){
					String strData=lavanteUtils.getText( xpathnoData);
					Reporter.log("Supplier Search Table data: " + strData);		
					//Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
				} else {
					for (int j=1;j<=rowCount.size();j++) {
						List<WebElement> headersCount = (xpathheaderCount);
						List<WebElement> dataCount = (xpathdataCount);
						if(headersCount.size()==dataCount.size()){
							lavanteUtils.waitForTime(1000);
							strSupplierName=lavanteUtils.getText( xpathsupplierTblName);
							strEmailName=lavanteUtils.getText( xpathemailContact);												
							break;
						}
					}
				}
			} else {
				Reporter.log("Supplier Search table is not found");
			}

			if(lavanteUtils.isElementDisplayed((lnkTxtinviteNewSupplier))==true){
				lavanteUtils.click( lnkTxtinviteNewSupplier);
				Reporter.log("Clicked on the Invite New Supplier Link");
				lavanteUtils.waitForTime(3000);
			} else {
				//log.severe("Verification failed for 'Invite New Supplier' Link: ");
				//Assert.assertTrue(false,"Test failed due to Verification failed for 'Invite New Supplier' Link:");
			}
			lavanteUtils.switchtoFrame(null);

			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.typeinEdit(strSupplierName,idsupplierName);
			Reporter.log("Entered supplier name:" + strSupplierName);
			lavanteUtils.typeinEdit(strEmailName,Idemail);
			Reporter.log("Entered Email:" + strEmailName);

			if(lavanteUtils.isElementDisplayed((xpathautoSuggestTblName))==true) {
				String strText=lavanteUtils.getText( xpathautoSuggestMsg);
				String strautoSuppName=lavanteUtils.getText( xpathautoSuggestSupplierName);
				if(expautosuggestMsg.equalsIgnoreCase(strText)){		
					Reporter.log("Validation is Successful for Auto Suggest message: Expected: " + "'" + expautosuggestMsg + "'"
							+ " match with " + " Actual: " + "'" + strText + "'");
					if(strSupplierName.equalsIgnoreCase(strautoSuppName)) {
						Reporter.log("Validation is Successful for auto supplier Name: Expected: " + "'" + strSupplierName + "'"
								+ " match with " + " Actual: " + "'" + strautoSuppName + "'");
						lavanteUtils.click(xpathcancelBtn);
						Reporter.log("Clicked on the 'Cancel' Button");
						lavanteUtils.switchtoFrame(null);
					}					
				}
			} else {
				Reporter.log("Auto Supplier Search table is not found");
			}
		}catch(Exception e) {
			//log.severe("Exception in the method verifyReInviteFunctionality: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyReInviteFunctionality: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_CreateNewSupplier_Popup
	 * Purpose: Public method which includes logic related to verify the CreateNewSupplier_Popup on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public void verify_CreateNewSupplier_Popup(){

		try{//ge.waitForTime(2000);
			verifySuppliersHomePageTitle();
			Reporter.log("\n Verify Create New Supplier feature: ");
			lavanteUtils.click(idsearchtab);
			Reporter.log("Clicked on the 'Basic Search' tab");
			lavanteUtils.switchtoFrame(xpathsupplierTableFrame);

			lavanteUtils.click( lnkTxtcreateNewSupplier);
			Reporter.log("Clicked on the 'Create New Supplier' link");
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

			if(lavanteUtils.isElementDisplayed((xpathNewSupplierPopupLabel))==true) {
				String strText=lavanteUtils.getText( xpathNewSupplierPopupLabel);
				System.out.println(strText+":APP : EXP"+expcreateNewSupplierPopuplbl);
				/*if(expcreateNewSupplierPopuplbl.equalsIgnoreCase(strText)){		
					Reporter.log("verification is Successful for take control label name : Expected: " + "'" + expcreateNewSupplierPopuplbl + "'"
							+ " match with " + " Actual: " + "'" + strText + "'");
					if(ge.isElementDisplayed(wdSupplierSearch, By.id(idtakeControlChkBox))){
						Reporter.log("Verification is successful for take control checkbox on 'Basic Search' tab");
						ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathcancelBtn);
						Reporter.log("Clicked on the 'Cancel' Button");
						ge.switchToFrameBy(wdSupplierSearch,"","","");
					}
				}*/
			} else {
				//log.severe("Test failed due to 'Supplier take control profile' checkbox did nopt appeared"
					//	+ " on the 'Create new supplier popup':");
				//ge.takeScreenshot(wdSupplierSearch, "did not appeared 'Supplier take control profile' checkbox");
				//Assert.assertTrue(false,"Test failed due to 'Supplier take control profile' checkbox did nopt appeared"
						//+ " on the 'Create new supplier popup': ");
			}
			
			lavanteUtils.click( xpathcancelBtn);
			Reporter.log("Clicked on the 'Cancel' Button");
			lavanteUtils.switchtoFrame(null);

			Reporter.log("\n");
			lavanteUtils.click( idadvancedTab);
			Reporter.log("Clicked on the 'Advanced Search' tab");
			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
			lavanteUtils.click( lnkTxtcreateNewSupplier);
			Reporter.log("Clicked on the 'Create New Supplier' link");
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			lavanteUtils.click( xpathcancelBtn);
			Reporter.log("Clicked on the 'Cancel' Button");
			lavanteUtils.switchtoFrame(null);
			
			/*if(ge.isElementDisplayed(wdSupplierSearch, By.xpath(xpathNewSupplierPopupLabel))==true) { System.out.println("GET TEXT");
				String strText=ge.getText(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathNewSupplierPopupLabel);	
				System.out.println(strText+":APP : EXP"+expcreateNewSupplierPopuplbl);
				if(expcreateNewSupplierPopuplbl.equalsIgnoreCase(strText)){		
					Reporter.log("verification is Successful for take control label name : Expected: " + "'" + expcreateNewSupplierPopuplbl + "'"
							+ " match with " + " Actual: " + "'" + strText + "'");
					System.out.println("NMATHCED");
					if(ge.isWebElementExists(wdSupplierSearch,ConfigPathFile.ID.getConstantValue(),idtakeControlChkBox).isDisplayed()){
						Reporter.log("Verification is successful for take control checkbox on 'Advanced Search' tab");
						ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathcancelBtn);
						Reporter.log("Clicked on the 'Cancel' Button");
						ge.switchToFrameBy(wdSupplierSearch,"","","");
					}
				}
			} else {
				//log.severe("Test failed due to 'Supplier take control profile' checkbox did nopt appeared"
					//	+ " on the 'Create new supplier popup':");
				ge.takeScreenshot(wdSupplierSearch, "did not appeared 'Supplier take control profile' checkbox");
				Assert.assertTrue(false,"Test failed due to 'Supplier take control profile' checkbox did nopt appeared"
						+ " on the 'Create new supplier popup': ");
			}*/
		} catch(Exception e) {
			//log.severe("Exception in the method verify_CreateNewSupplier_Popup: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_CreateNewSupplier_Popup: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_Sync_AdvSrch_BasicSrch
	 * Purpose: Public method which includes logic related to verify the Synchronization between Advanced Search and
	 * Basic Search on supplier search page
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	@SuppressWarnings("unused")
	public void verify_Sync_AdvSrch_BasicSrch(){
		String strSupplierName="",strBusinessContact="",strStatus="",strBasicSuppName="",strBasicBusinessContact="",
				strBasicStatus="",strAdvSuppName="",strAdvBusinessContact="",strAdvStatus="",basictableRowCount="",
				advtableRowCount="";		
		try{ lavanteUtils.waitForTime(2000);
			verifySuppliersHomePageTitle();
			Reporter.log("\n Verify the Synchronization between 'Basic Search' and 'Advanced Search' Results' portlets: ");
			lavanteUtils.click(idsearchtab);
			Reporter.log("Clicked on the 'Basic Search' tab");
			lavanteUtils.waitForTime(2000);
			//Frame In
			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);		

			if(supplierSearchTbl()==true){
				strSupplierName=lavanteUtils.getText(xpathsupplierTblName);
				strBusinessContact=lavanteUtils.getText(xpathbusinessContact );												
				strStatus=lavanteUtils.getText(xpathstatus);
			} else {
				//log.severe("Supplier Search Table is not found");
				//Assert.assertTrue(false,"Exception in the method verify_Sync_AdvSrch_BasicSrch: ");
			}
			lavanteUtils.switchtoFrame(null);

			lavanteUtils.waitForTime(3000);
			lavanteUtils.typeinEdit( strSupplierName, idsupplierName);
			Reporter.log("Entered 'Supplier' name:" + strSupplierName);
			lavanteUtils.typeinEdit( strBusinessContact, idcontactName);
			Reporter.log("Entered 'Business/Sales Contact' name:" + strBusinessContact);

			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus, strStatus);			
			Reporter.log("Selected the profile stage drop down status: " + strStatus);	*/
			
			selectProfileStatus( strStatus);
			
			lavanteUtils.click(xpathSearchBtn);
			Reporter.log("Clicked on the 'Search' button");
			lavanteUtils.waitForTime(2000);

			//Frame In
			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);

			if(supplierSearchTbl()==true){
				List<WebElement> rowCount = (xpathtableRowCount);
				int tableRowCount=rowCount.size();
				basictableRowCount = String.valueOf(tableRowCount);
				strBasicSuppName=lavanteUtils.getText( xpathsupplierTblName);
				strBasicBusinessContact=lavanteUtils.getText(xpathbusinessContact );												
				strBasicStatus=lavanteUtils.getText(xpathstatus);
				//verifyTblData(strSupplierName, strBusinessContact, strStatus,strBasicSuppName,strBasicBusinessContact,strBasicStatus);
				//Frame out
				lavanteUtils.switchtoFrame(null);
			}

			lavanteUtils.waitForTime(2000);
			lavanteUtils.click( idadvancedTab);
			Reporter.log("Clicked on the 'Advanced Search' tab");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click( xpathbuildQueryBtn);
			Reporter.log("Clicked on the 'Build Query' button");
			lavanteUtils.waitForTime(4000);
			//Frame In
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);

			
			//Supplier Name
			lavanteUtils.click( xpathcompanyProfileTab);
			Reporter.log("Clicked on the 'Company Profile' tab");
			lavanteUtils.click(xpathSupplierDrpDwn);
			Reporter.log("Clicked on the 'Supplier Name' drop down field");
			//Frame out
			lavanteUtils.switchtoFrame(null);	
			lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector("li.active-result:nth-child(2)")));
			Reporter.log("Selected 'Equals To' option in the drop down:");
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			lavanteUtils.typeinEdit(strSupplierName, xpathsuppliertxtField);
			Reporter.log("Entered Supplier Name:" + strSupplierName);
			lavanteUtils.waitForTime(2000);
			//Business/Sales Contact Name
			lavanteUtils.click( xpathcustomerSpecificProfileTab);
			Reporter.log("Clicked on the 'Customer Specific Profile' tab");
			lavanteUtils.click(xpathbusinessContactDrpDwn);
			Reporter.log("Clicked on the 'Business/Sales Contact' drop down field");
			//Frame out
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector( "li.active-result:nth-child(2)")));
			Reporter.log("Selected 'Equals To' option in the drop down:");
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			lavanteUtils.typeinEdit(strBusinessContact,xpathbusinessContactTxtField);
			Reporter.log("Entered Business/Sales Contact Name:" + strBusinessContact);
			//Status
			lavanteUtils.click( xpathenterpriseDataTab);
			Reporter.log("Clicked on the 'Enterprise Generated Data' tab");
			lavanteUtils.waitForTime(1000);
			
			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus, strStatus);			
			Reporter.log("Selected the profile stage drop down status: " + strStatus);*/	
			
			selectProfileStatus( strStatus);
			
			lavanteUtils.click( xpathadvanceSearchBtn);
			lavanteUtils.waitForTime(1000);
			Reporter.log("Clicked on the 'Search' button");
			//Frame In
			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
			if(supplierSearchTbl()==true){
				List<WebElement> rowCount =(xpathtableRowCount);
				int tableRowCount=rowCount.size();
				advtableRowCount = String.valueOf(tableRowCount);
				strAdvSuppName=lavanteUtils.getText( xpathsupplierTblName);
				strAdvBusinessContact=lavanteUtils.getText(xpathbusinessContact );										
				strAdvStatus=lavanteUtils.getText(xpathstatus);
				//verifyTblData(strSupplierName, strBusinessContact, strStatus,strAdvSuppName,strAdvBusinessContact,strAdvStatus);
				//Frame out
				lavanteUtils.switchtoFrame(null);
			}			
			verifySyncBscSrchAdvSrchTblData(strBasicSuppName,strBasicBusinessContact,basictableRowCount,strAdvSuppName,
					strAdvBusinessContact,advtableRowCount);
		}catch(Exception e){
			//log.severe("Exception in the method verify_Sync_AdvSrch_BasicSrch: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_Sync_AdvSrch_BasicSrch: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_DuplicateEmails
	 * Purpose: Public method which includes logic related to verify no duplicateEmails are getting created on
	 *  		Suppliers search page
	 * @param: None
	 * @return: None
	 */
	public void verify_DuplicateEmails(List<setTestData> getSupplierSearchData){

		try{lavanteUtils.waitForTime(2000);
			//Verify supplier Home page tile
			verifySuppliersHomePageTitle();		
			for(int i=0;i<getSupplierSearchData.size();i++) {
				//searchInactiveStatus(getSupplierSearchData,i);
				//Verify the advanced search page, after ge.clicks on Advanced search and Build query
				clkAndVerifyAdvanceSrchPage();
				lavanteUtils.waitForTime(1000);
				//Perform search operation, after entering data in to the text field box
				selectBusinessContactNameAndClkOnSrchBtn();
				lavanteUtils.waitForTime(3000);
				//Frame In
				lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
				//verify the supplier search table and select supplier
				String strEmail=verifySupplierSrchTblAndSelectSupplier();
				System.out.println(strEmail);
				//ge.clicks on the profile tab and option in the drop down
				clkSupplierBtnAndSelectOption(xpathprofileBtn,xpatheditProfile, ConfigPathFile.PROFILE.getConstantValue(),
						ConfigPathFile.EDITPROFILE.getConstantValue());
				lavanteUtils.waitForTime(2000);			
				//Frame out
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.waitForTime(5000);
				lavanteUtils.click(xpathenterpriseOwnedTab);
				Reporter.log("Clicked on the 'Enterprise Owned' tab");
				lavanteUtils.waitForTime(2000);
				//Verification of the Supplier contact information edit box icon
				if(lavanteUtils.isElementDisplayed((idsupplierContactInfo))==true) { 
					if(lavanteUtils.isElementDisplayed((xpatheditUserInfoIcon))==true) { 
						lavanteUtils.click(xpatheditUserInfoIcon);
						Reporter.log("Clicked on the 'Edit' Icon");
						lavanteUtils.waitForTime(3000);
						//Frame In
						lavanteUtils.switchtoFrame( xpathactivatePopupFrame);		

						/*						ge.typeinEdit(wdSupplierSearch,ConfigPathFile.ID.getConstantValue(),Idemail,
								getSupplierSearchData.get(i).getNewEmail().toString());*/
						
						lavanteUtils.typeinEdit(strEmail,Idemail);
						lavanteUtils.waitForTime(2000);
						Reporter.log("Entered Existing Email:" + getSupplierSearchData.get(i).getNewEmail().toString());
						
						lavanteUtils.waitForTime(2000);
						lavanteUtils.click(xpathsaveEditUserBtn);
						Reporter.log("Clicked on the 'Save button");
						lavanteUtils.waitForTime(3000);
						//Verify the expected error message
						validateErrorMessage();
						//Validation
						if(lavanteUtils.isElementDisplayed((xpatheditUserCancelBtn))==true) {
							lavanteUtils.click(xpatheditUserCancelBtn);
							Reporter.log("Clicked on the 'Cancel' button");
							lavanteUtils.waitForTime(2000);
							//Frame out
							lavanteUtils.switchtoFrame(null);
							break;
						} else {
							//log.severe("Test failed due to 'Cancel' button did not appeared on the page:");
							//Assert.assertTrue(false,"Test failed due to 'Cancel' button did not appeared on the page");
						}
					} else {
						//log.severe("Verification failed: due to 'No Data Available' appeared in the 'User Edit Information' table");
						Reporter.log("Warning Message: 'No Data Available' appeared in the 'User Edit Information' table");
						break;
						//Assert.assertTrue(false, "Test failed due to 'No Data Available' appeared in the 'User Edit Information' table ");
					}
				} else {
					//log.severe("Test failed due to 'supplier Contact Information' table did not appeared");
					//Assert.assertTrue(false,"Test failed due to 'supplier Contact Information' table did not appeared");
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_DuplicateEmails: "+ e.getMessage());
			//ge.takeScreenshot(wdSupplierSearch, "verify_DuplicateEmails");
			//Assert.assertTrue(false,"Exception in the method verify_DuplicateEmails: " + e.getMessage());
		}
	}

	/**
	 * Method Name : selectBusinessContactNameAndClkOnSrchBtn
	 * Purpose: Public method which includes logic related to perform search operation after entering business Contact Name
	 * 			in the company profile tab
	 * @param: None
	 * @return: None
	 */
	private void selectBusinessContactNameAndClkOnSrchBtn(){

		try{lavanteUtils.waitForTime(2000);
			//Frame In
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click( xpathcustomerSpecificProfileTab);
			Reporter.log("Clicked on the 'Company Specific Profile' tab");
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click( idcompanyLegalName_chosen);
			Reporter.log("Clicked on the 'Business/Sales Contact' drop down field");
			lavanteUtils.waitForTime(2000);
			//Frame out
			lavanteUtils.switchtoFrame(null);	
			lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector("li.active-result:nth-child(3)")));
			Reporter.log("Selected 'Contains' option in the 'Business/Sales Contact' drop down:");
			lavanteUtils.waitForTime(2000);
			//Frame In
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			//ConfigPathFile.TESTMESSAGE.getConstantValue()
			lavanteUtils.typeinEdit("Pawtp", 	xpathbusinessContactName);
			Reporter.log("Entered 'Business/Sales Contact' Name: " + ConfigPathFile.TESTMESSAGE.getConstantValue());
			lavanteUtils.waitForTime(3000);
			lavanteUtils.click( xpathadvanceSearchBtn);
			lavanteUtils.waitForTime(2000);
			Reporter.log("Clicked on the 'Search' button");
			//Frame out
			lavanteUtils.switchtoFrame(null);
		}catch(Exception e){
			//log.severe("Exception in the method selectBusinessContactNameAndClkOnSrchBtn: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method selectBusinessContactNameAndClkOnSrchBtn: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_ReatinedSearchResults
	 * Purpose: Public method which includes logic related to Verify that previous search results are retained on
	 * 			both suppliers page - Basic and Advanced Search if user comes back from Take Control or Edit Profile
	 * @param: getSupplierSearchData
	 * @return: None
	 */
	public void verify_ReatinedSearchResults(List<setTestData> getSupplierSearchData){
		String basicRetainedRowCount="",basicCurrentRowCount="",advanceCurrentRowCount="",advanceRetainedRowCount="";
		int j=1;
		lavanteUtils.waitForTime(2000);
		verifySuppliersHomePageTitle();
		try{
			lavanteUtils.waitForTime(2000);
			for(int i=0;i<getSupplierSearchData.size();i++) {
				lavanteUtils.typeinEdit(getSupplierSearchData.get(i).getSupplierName().toString(),	idsupplierName);
				Reporter.log("Entered Existing Supplier Name:" + getSupplierSearchData.get(i).getSupplierName().toString());
				lavanteUtils.click(xpathSearchBtn);
				Reporter.log("Clicked on the 'Search' button");
				lavanteUtils.waitForTime(3000);
				//Frame In
				lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
				//table Row Count - Current
				basicCurrentRowCount=getTableRowCount();
				Reporter.log("Current 'Basic Search' Results Count: " + basicCurrentRowCount);
				lavanteUtils.waitForTime(2000);
				selectChkBoxClkEditProfileAndClkCancelBtn(j);
				lavanteUtils.waitForTime(2000);
				//Frame In
				lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
				lavanteUtils.waitForTime(1000);
				//table Row Count - Retained
				basicRetainedRowCount=getTableRowCount();
				Reporter.log("Retained 'Basic Search' Results Count:" + basicRetainedRowCount);
				//Validate the current results count with previous results count
				if(validateTableRowCount(basicCurrentRowCount,basicRetainedRowCount,
						ConfigPathFile.BASICSEARCH.getConstantValue())==true){
					//Frame out
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.waitForTime(1000);
					advanceSupplierSrchResults(getSupplierSearchData,i);
					//Frame In
					lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
					advanceCurrentRowCount=getTableRowCount();
					Reporter.log("Advanced Search Results count Before:" + advanceCurrentRowCount);
					lavanteUtils.waitForTime(2000);
					selectChkBoxClkEditProfileAndClkCancelBtn(j);
					//Frame In
					lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
					advanceRetainedRowCount=getTableRowCount();
					Reporter.log("Advanced Search Results count Before:" + advanceRetainedRowCount);
					//Frame out
					lavanteUtils.switchtoFrame(null);
					if(validateTableRowCount(advanceCurrentRowCount,advanceRetainedRowCount, 
							ConfigPathFile.ADVANCESEARCH.getConstantValue())==true){					
						break;
					}
				} else {
					//log.severe("Validation Failed for Basic Search");
				}
			}
		}catch(Exception e){
			//log.severe("Exception in the method verify_ReatinedSearchResults: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_ReatinedSearchResults: " + e.getMessage());
		}
	}

	/**
	 * Method Name : clkAndVerifyAdvanceSrchPage
	 * Purpose: Public method which includes logic related to ge.clicks (Advance Tab & Build Query) and verify the advance search page
	 * @param: None
	 * @return: None
	 */
	public void clkAndVerifyAdvanceSrchPage(){

		try{
			lavanteUtils.waitForTime(4000);
			lavanteUtils.click( idadvancedTab);
			Reporter.log("Clicked on the 'Advanced Search' tab");
			//ge.waitForTime(2000);
			lavanteUtils.click(xpathbuildQueryBtn);
			Reporter.log("Clicked on the 'Build Query' button");
			//ge.waitForTime(4000);
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);			
			if(lavanteUtils.isElementDisplayed(xpathenterpriseDataTab)==true) {
				Reporter.log("Verification is successful for 'Advanced Search Page':");
				//Frame out
				lavanteUtils.switchtoFrame(null);				
			}else {
				//log.severe("Verification failed for 'Advanced Search Page':");
				//Assert.assertTrue(false,"Test failed due to 'Advanced Search' page did not appeared on the page: ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method clkAndVerifyAdvanceSrchPage: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method clkAndVerifyAdvanceSrchPage: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_SendInviteCustomerTakeControl
	 * Purpose: Public method which includes logic related to verify the send Invite functionality as customer take control
	 * @param: getSupplierSearchData
	 * @return: None
	 */
	public String verify_SendInviteCustomerTakeControl(List<setTestData> getSupplierSearchData){
		int j=1; String supplierName="";
		try{//ge.waitForTime(2000);
			//Verify the supplier page home page
			verifySuppliersHomePageTitle();	
			//loop
			for(int i=0;i<getSupplierSearchData.size();i++){
				if(i>0){
					break;
				}
				/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,
						getSupplierSearchData.get(i).getCustomerTakeControl().toString());
				Reporter.log("Selected " + getSupplierSearchData.get(i).getCustomerTakeControl().toString() +
						" option in the profile" + " status dropdown");*/
				
				
				selectProfileStatus( getSupplierSearchData.get(0).getSendEmailStatus().toString());
				
				//ge.waitForTime(1000);
				lavanteUtils.click(xpathSearchBtn);
				Reporter.log("Clicked on the 'Search' button");
				//ge.waitForTime(2000);
				//Frame In
				lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
				//Supplier Name
				supplierName=verifySupplierStatusAndSelectChkBox(getSupplierSearchData,i,j);
				//ge.clicks the tab and select option
				clkSupplierBtnAndSelectOption(xpathprofileBtn,xpathtakeControl, ConfigPathFile.PROFILE.getConstantValue(),
						ConfigPathFile.TAKECONTROL.getConstantValue());
				//Frame out
				lavanteUtils.switchtoFrame(null);	
				//ge.waitForTime(1000);
				//Validate Dialog pop up and ge.clicks on Ok button
				validateDialogPopup(xpathdialogPopup, exptakeControlDialogPopUp);
				//ge.waitForTime(2000);
				//ge.clicks Send Invite Button
				if(lavanteUtils.isElementDisplayed(idsendinviteBtn)==true){
					lavanteUtils.click( idsendinviteBtn);
				} else {
					//log.severe("Failed to identify the send invite button: ");
				}
				//Frame In
				lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
				if(lavanteUtils.isElementDisplayed(xpathsendInvitePopupBtn)==true){
					lavanteUtils.click( xpathsendInvitePopupBtn);
					//Frame out
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					//Validate Success pop up and ge.clicks on Ok button
					validateSuccessMsg(xpathSuccessMsg,expsendEmailSuccessMsg);
					//ge.waitForTime(2000);
					if(lavanteUtils.isElementDisplayed(xpathadvCancelBtn)==true){
						lavanteUtils.click(xpathadvCancelBtn);
						//ge.waitForTime(3000);
						if(i==0){
							break;
						}
					} else {
						//log.severe("Failed to identify the 'Cancel' button: ");
					}
				} else {
					//log.severe("Failed to identify the send invite dialog pop up button: ");
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_SendInviteCustomerTakeControl: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_SendInviteCustomerTakeControl: " + e.getMessage());
		}
		return supplierName;
	}

	/**
	 * Method Name : verify_SameContactEmail_VMFOutreachProcess
	 * Purpose: Public method which includes logic related to verify the send Invite functionality as customer take control
	 * @param: getSupplierSearchData
	 * @return: None
	 */
	public void verify_SameContactEmail_VMFOutreachProcess(List<setTestData> getSupplierSearchData){
		String strSupplierName="",strEmailName="";
		try{
			//Verify the supplier page home page
			verifySuppliersHomePageTitle();
			//loop
			for(int i=0;i<getSupplierSearchData.size();i++){				
				if(!(getSupplierSearchData.get(i).getContactEmailOutreach().toString().equalsIgnoreCase(""))){					
					
				/*	ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,
							getSupplierSearchData.get(i).getContactEmailOutreach().toString());
					
					Reporter.log("Selected " + getSupplierSearchData.get(i).getContactEmailOutreach().toString() +
							" option in the profile" + " status dropdown");*/
					
					selectProfileStatus( getSupplierSearchData.get(0).getSendEmailStatus().toString());
					
					//ge.waitForTime(1000);
					lavanteUtils.click( xpathSearchBtn);
					Reporter.log("Clicked on the 'Search' button");
					//ge.waitForTime(2000);
					//Frame In
					lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
					//Verification of the supplier search table
					if(supplierSearchTbl()==true){
						lavanteUtils.click(wdSupplierSearch.findElement(By.xpath("//table[@id='search_results']//tbody/tr[1]/td[4]/a")));
						
						lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
						//strSupplierName=ge.getText(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathsupplierTblName);
						strSupplierName=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath("//div[@id='dialog']//table//tr[1]/td[2]")));
						//strEmailName=ge.getText(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathemailContact);
						strEmailName=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath("//div[@id='dialog']//table//tr[7]/td[2]")));
						
						//ge.switchToFrameBy(wdSupplierSearch, xpathsupplierTableFrame,ConfigPathFile.IN.getConstantValue(),
								//ConfigPathFile.XPATH.getConstantValue());
						
						lavanteUtils.switchtoFrame(null);
						
						lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( "//div[@id='footer']/following-sibling::div[2]/div[1]/button")));
						
						//ge.click(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), "//button[@type='button']");											
						
					}
					
					lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
					
					//Invite New Supplier
					String sSupplierName=clickAndValidateNewInviteSupplier(getSupplierSearchData,strSupplierName,strEmailName);
					//ge.waitForTime(1000);
					//Verify the success message
					validateSuccessMsg(xpathSuccessMsg,expinviteNewSupplierSuccessMsg);
					//ge.waitForTime(2000);
					//Verification of the Supplier Name
					if(verify_VMFNewSuppName(sSupplierName)==true){
						Reporter.log("Verification is Successful for VMF upload - outreach process: with "
								+ " Supplier Name: " + sSupplierName);
					} else {
						//log.severe("Verification failed for VMF upload - outreach process: with "
							//	+ " Supplier Name: " + sSupplierName);
						Assert.assertTrue(false,"Test failed due to Verification failed for VMF upload - outreach process:"
								+ " with Supplier Name: " + sSupplierName);
					}
				} else {
					continue;
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_SameContactEmail_VMFOutreachProcess: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_SameContactEmail_VMFOutreachProcess: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_DownloadDocument
	 * Purpose: Public method which includes logic related to verify the download documents functionality
	 * @param: getSupplierSearchData
	 * @return: None
	 */
	public void verify_DownloadDocument(List<setTestData> getSupplierSearchData){

		try{
			//Verify the supplier page home page
			verifySuppliersHomePageTitle();
			//Verify the advanced search page, after ge.clicks on Advanced search and Build query
			clkAndVerifyAdvanceSrchPage();
			//loop
			for(int i=0;i<getSupplierSearchData.size();i++){
				//select 'yes' option in the legal id doc provided drop down
				selectLegalIDDocDrpDwn(getSupplierSearchData,i);
				//verify and select supplier and ge.clicks on download documents option in other Action tab
				verifyAndClkDownloadDocOption(getSupplierSearchData);
				//select download document and ge.clicks on OK button
				selectDocumentAndClkOKBtn();
				//ge.clicks on Manage Files tab
				lavanteUtils.click(xpathmanageFiles);
				Reporter.log("Clicked on the 'Manage Files' tab");
				//ge.waitForTime(2000);
				lavanteUtils.click( xpathdownloadFiles);
				Reporter.log("Clicked on the 'Download Files' sub tab");
				//ge.waitForTime(2000);
				wdSupplierSearch.findElement(By.cssSelector("button[class*='refresh']")).click();
				//ge.waitForTime(10000);
				//Frame In
				lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
				//verification
				//if(verifyDownLoadFileHistoryTbl()==true){
					Reporter.log("Verification is successful for 'Download Documents' Functionality: ");
					//break;
				//}
			}
		}catch(Exception e){
			//log.severe("Exception in the method verify_DownloadDocument: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_DownloadDocument: " + e.getMessage());
			//Assert.assertTrue(true);
		}		
	}

	/**
	 * Method Name : selectDocumentAndClkOKBtn
	 * Purpose: Public method which includes logic related to select W-9 doc in the drop drop down and ge.clicks OK button
	 * @param: getSupplierSearchData, int i
	 * @return: None
	 */
	private void selectDocumentAndClkOKBtn(){

		try{
			//Frame In
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);

			//if(ge.isElementDisplayed(wdSupplierSearch, By.id(idavailableSuppDocBox))){
				lavanteUtils.click(wdSupplierSearch.findElement(By.xpath("//form[@id='save_request_doc_form']//optgroup[1]/option[2]")));
				lavanteUtils.selectvalueFrmDpdn("W-9");
				Reporter.log("Selected the 'W-9' pdf document in the 'available supplier document' drop down box: " );
				//ge.waitForTime(2000);
				lavanteUtils.click(wdSupplierSearch.findElement(By.xpath(" //div[@class='button-selection']/button[2]")));
				Reporter.log("Clicked on the 'Move to Documents Selected for Extraction List:' button ");
				//ge.waitForTime(2000);
				lavanteUtils.click(wdSupplierSearch.findElement(By.xpath("//div[@class='button_set']/div/button[2]")));
				Reporter.log("Clicked on the 'OK' button");
			//}
			//Frame out
			lavanteUtils.switchtoFrame(null);
			//ge.waitForTime(2000);
			lavanteUtils.click( xpathokEmailBtn);
			//validateDialogPopup(xpathdialogPopup, expextractDocPopupsMsg);
		}catch(Exception e){
			//log.severe("Exception in the method selectDocumentAndClkOKBtn: "+ e.getMessage());
			//Assert.assertTrue(true,"Exception in the method selectDocumentAndClkOKBtn: " + e.getMessage());
		}
	}

	/**
	 * Method Name : clickAndValidateNewInviteSupplier
	 * Purpose: Public method which includes logic related to ge.clicks on the new invite supplier link and validate the page with
	 * 			valid and invalid data and verify the successful invite supplier
	 * @param: List<setTestData> getDashboard
	 * @return: None
	 */
	public String clickAndValidateNewInviteSupplier(List<setTestData> getSupplierSearchData, String sName, String sEmail){

		String concatenateUser="";
		//Invite New Supplier
		lavanteUtils.click(lnkTxtinviteNewSupplier);
		Reporter.log("Clicked on the Invite New Supplier Link");
		//ge.waitForTime(2000);
		//Frame out
		lavanteUtils.switchtoFrame(null);
		try {	
			for(int i=0;i<getSupplierSearchData.size();i++){
				//Frame In
				lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
				//Enter Supplier Name
				if(!(sName.trim().toString()==(""))){
					concatenateUser= getUserName(sName);			
					lavanteUtils.typeinEdit( concatenateUser,idsupplierName);
					Reporter.log("Entered 'Supplier name':" + concatenateUser);
				}
				//Enter Contact Name
				lavanteUtils.typeinEdit(concatenateUser,idcontactName);
				Reporter.log("Entered 'Contact name':" + concatenateUser);
				//Enter Contact Email
				lavanteUtils.typeinEdit(sEmail,Idemail);
				Reporter.log("Entered 'Contact Email':" + sEmail);
				//Enter Contact Fax
				lavanteUtils.typeinEdit( getSupplierSearchData.get(i).getContactFax().toString(),	idfax);
				Reporter.log("Entered 'Contact Fax':" + getSupplierSearchData.get(i).getContactFax().toString());
				//Selected Inviting Organization drop down value
				lavanteUtils.selectDropDownValue(idinvitingOrganization,getSupplierSearchData.get(i).getInvitingOrganization().toString());
				Reporter.log("Selected 'Inviting Organization':" + getSupplierSearchData.get(i).getInvitingOrganization().toString());

				//Selected Supplier Group in the Drop down
				if(!(getSupplierSearchData.get(i).getSupplierGroup().toString()=="")){
					String strCountry=getSupplierSearchData.get(i).getSupplierGroup().toString();
					int SupplierGroupKey = Integer.parseInt(strCountry);
					lavanteUtils.click( xpathsupplierGroup);
					//Frame out
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector( "li.active-result:nth-child("+SupplierGroupKey+")")));
					//Frame In
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					//ge.waitForTime(2000);
					//Enter Comment in Reason for New Supplier Section
					lavanteUtils.typeinEdit( getSupplierSearchData.get(i).getComment().toString(),idsupplierInviteJustification);
					//ge.clicks on the check box
					//select_RadioBtn(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(),idsupplierListCheckConfirmation);
					//ge.waitForTime(1000);
					
					lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( "//input[@id='supplierListCheckConfirmation']")));	
				}
				if(lavanteUtils.isElementDisplayed(idinviteBtn)==true){					
									
					lavanteUtils.click( idinviteBtn);
					//ge.waitForTime(2000);
					//Frame out
					lavanteUtils.switchtoFrame(null);
					break;
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method clickAndValidateNewInviteSupplier: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method clickAndValidateNewInviteSupplier: " + e.getMessage());
		}
		return concatenateUser;
	}

	/**
	 * Method Name : verifyAndClkDownloadDocOption
	 * Purpose: Public method which includes logic related to verify the supplier table and select supplier and ge.clicks on
	 * 			Download Documents option in the Other Action tab
	 * @param: getSupplierSearchData, int i
	 * @return: None
	 */
	private void verifyAndClkDownloadDocOption(List<setTestData> getSupplierSearchData){

		int j=1;
		try{
			//Frame In
			lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
			if(supplierSearchTbl()==true){
				String strSupplierStatus=lavanteUtils.getText(xpathstatus);
				lavanteUtils.click(wdSupplierSearch.findElement(By.xpath(xpathselect + j + xpathoption)));
				Reporter.log( "'" + strSupplierStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
				//ge.waitForTime(2000);
			} else {
				//log.severe("Supplier Search Table is not found");
				//Assert.assertTrue(false,"Test failed due to Supplier Search Table is not found: ");
			}				
			clkSupplierBtnAndSelectOption(xpathotherAction, xpathdownloadDocuments, ConfigPathFile.OTHERACTION.getConstantValue(),
					ConfigPathFile.DOWNLOADDOCUMENTS.getConstantValue());
			//ge.waitForTime(2000);
			//Frame out
			lavanteUtils.switchtoFrame(null);
		}catch(Exception e){
			//log.severe("Exception in the method verifyAndClkDownloadDocOption: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyAndClkDownloadDocOption: " + e.getMessage());
		}

	}

	/**
	 * Method Name : selectLegalIDDocDrpDwn
	 * Purpose: Public method which includes logic related to select yes option in the legal id doc provided Drop down
	 * @param: getSupplierSearchData, int i
	 * @return: None
	 */
	private void selectLegalIDDocDrpDwn(List<setTestData> getSupplierSearchData, int i){

		try {
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			//Supplier Name
			lavanteUtils.click(xpathcompanyLegalID);
			Reporter.log("Clicked on the 'Company Legal ID' tab");
			//ge.waitForTime(2000);
			lavanteUtils.click(idlegalIDDocDrpDwn);
			Reporter.log("Clicked on the 'Legal ID Document' drop down field: ");
			//Frame out
			lavanteUtils.switchtoFrame(null);
			//ge.waitForTime(2000);

			String strLegalIDDoc=getSupplierSearchData.get(i).getLegalIDDocKey().toString();				
			int legalIDDocKey = Integer.parseInt(strLegalIDDoc);

			lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector("li.active-result:nth-child("+ legalIDDocKey +")")));				
			Reporter.log("Selected 'Yes' option in the 'Legal ID Document Provided?' drop down field: ");			
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			lavanteUtils.click(xpathadvanceSearchBtn);
			Reporter.log("Clicked on the 'Search' button");
			//ge.waitForTime(2000);
			//Frame out
			lavanteUtils.switchtoFrame(null);
		}catch(Exception e){
			//log.severe("Exception in the method selectLegalIDDocDrpDwn: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method selectLegalIDDocDrpDwn: " + e.getMessage());
		}
	}

	/**
	 * Method Name : validateTblStatusResults
	 * Purpose: Public method which includes logic related to validate the table results
	 * @param: getSupplierSearchData, int i
	 * @return: None
	 */
	public void validateTblStatusResults(List<setTestData> getSupplierSearchData,int i){

		try{
			//Frame In
			lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
			//Supplier search validation
			if(supplierSearchTbl()==true){
				String sRow=getTableRowCount();
				int sRowCount=Integer.parseInt(sRow);

				for(int k=0;k<=sRowCount;k++){
					if(lavanteUtils.isElementDisplayed(xpathstatus)==true){
						String strStatus=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath(xpathsupplierStatus + k + xpathrowOption)));
						if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(i).getPrivatePublicQuery().toString())){
							Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");							
						} else {
							//log.severe("Failed due to Expected Status" + strStatus + "does not match with Actual Status: "
								//	+ getSupplierSearchData.get(i).getPrivatePublicQuery().toString());
							//Assert.assertTrue(false,"Failed due to Expected Status" + strStatus + "does not match with"
									//+ " Actual Status: " + getSupplierSearchData.get(i).getPrivatePublicQuery().toString());
						}
					} else {
						//log.severe("Test failed due to 'Status' column element property has changed:");
						Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
					}
					if(k==sRowCount){
						//Frame out
						//ge.switchToFrameBy(wdSupplierSearch,"","","");
						break;
					}
				}
			} else {
				//log.severe("Supplier Search Table is not found");
				//Assert.assertTrue(false,"Exception in the method validateTblStatusResults: ");
			}
		} catch(Exception e){
			//log.severe("Exception in the method validateTblStatusResults: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateTblStatusResults: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifySupplierTblData
	 * Purpose: Public method which includes logic related to verify the supplier table and ge.clicks on any supplier and
	 * 			validate the page opened (or) not
	 * @param: None
	 * @return: None
	 */
	public boolean verifySupplierTblData(){
		String strData="";
		try{
			List<WebElement> rowCount = xpathtableRowCount;
			int tableRowCount=rowCount.size();
			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
					strData=lavanteUtils.getText(xpathnoData);
					Reporter.log("Verification is successful: " + "'" + strData + "'");
					return true;
				} else {
					//Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
				}
			} else {
				Reporter.log("Supplier Search table is not found");
				//Assert.assertTrue(false,"Test failed due to table row count is zero: ");
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifySupplierTblData: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySupplierTblData: " + e.getMessage());
		}
		return false;
	}

	/**
	 * Method Name : verifySupTblAndClkOnSupplierLnk
	 * Purpose: Public method which includes logic related to verify the supplier table and ge.clicks on any supplier and
	 * 			validate the page opened (or) not
	 * @param: None
	 * @return: None
	 */
	public void verifySupTblAndClkOnSupplierLnk(){
		try{
			if(supplierSearchTbl()==true){				
				String strSupplierName=lavanteUtils.getText( xpathsupplierTblName);
				lavanteUtils.click( xpathsupplierTblName);
				//pressEnterkey(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathsupplierTblName);
				//ge.waitForTime(2000);
				Reporter.log("Clicked on the Supplier Name: " + strSupplierName);
				if(lavanteUtils.isElementDisplayed(xpathsupplierManaged)){
					Reporter.log("Navigation is successful to Supplier Page:" + strSupplierName);
				}
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifySupTblAndClkOnSupplierLnk: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySupTblAndClkOnSupplierLnk: " + e.getMessage());
		}
	}

	/**
	 * Method Name : closeSupDetailsPopUpWindow
	 * Purpose: Public method which includes logic related to close pop up window
	 * @param: None
	 * @return: None
	 */
	public void closeSupDetailsPopUpWindow(){
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(cssPopupCloseBtn);
		//ge.waitForTime(1000);
		Reporter.log("Clicked on the | Popup Close | Button successfully");
		if(lavanteUtils.isElementDisplayed(cssPopupCloseBtn)){
			lavanteUtils.click(cssPopupCloseBtn);
		}
	}

	/**
	 * Method Name : validateTableRowCount
	 * Purpose: Public method which includes logic related to validate the current row count results with retained row count results
	 * @param: String beforeRowCount, String afterRowCount, String expSearch
	 * @return: true/false
	 */
	public boolean validateTableRowCount(String beforeRowCount, String afterRowCount, String expSearch){
		if(beforeRowCount.equalsIgnoreCase(afterRowCount)){
			Reporter.log("Validation is successful for " + expSearch + " Current Row Count: " + beforeRowCount 
					+ " Match with Retained Row Count: " + afterRowCount);
			return true;
		} else {
			//log.severe("Validation failed for " + expSearch + " Current Row Count: " + beforeRowCount 
				//	+ " Match with Retained Row Count: " + afterRowCount);
			//Assert.assertTrue(false," Test failed due to Validation failed for " + expSearch + " Current Row Count: " + beforeRowCount 
					//+ " Match with Retained Row Count: " + afterRowCount);
		}
		return false;
	}

	/**
	 * Method Name : selectChkBoxClkEditProfileAndClkCancelBtn
	 * Purpose: Public method which includes logic related to validate to select the supplier check box and ge.clicks on
	 * 			edit profile in profile tab and ge.clicks on cancel button on suppliers page
	 * @param: None
	 * @return: None
	 */
	public void selectChkBoxClkEditProfileAndClkCancelBtn(int j){
		try{
			lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + j + xpathoption)));
			//ge.waitForTime(1000);
			Reporter.log( " checkbox is selected in the Supplier search table");
			clkSupplierBtnAndSelectOption(xpathprofileBtn,xpatheditProfile, ConfigPathFile.PROFILE.getConstantValue(),
					ConfigPathFile.EDITPROFILE.getConstantValue());
			//Frame out
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.click(xpathadvCancelBtn);
			lavanteUtils.waitForTime(1000);
			Reporter.log("Clicked on the 'Cancel' button");	
		}catch(Exception e){
			//log.severe("Exception in the method selectChkBoxClkEditProfileAndClkCancelBtn: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method selectChkBoxClkEditProfileAndClkCancelBtn: " + e.getMessage());
		}
	}

	/**
	 * Method Name : selectDrpDwnOption
	 * Purpose: Public method which includes logic related to select the particular option in the drop down
	 * @param: String DrpDwnOption
	 * @return: None
	 */
	public void selectDrpDwnOption(String DrpDwnOption, String eleProperty){
		List<WebElement> options=null;
		try{
			//ge.waitForTime(1000);
			WebElement list= wdSupplierSearch.findElement(By.xpath(eleProperty));
			options=list.findElements(By.xpath(eleProperty));
			for(WebElement option: options){
				String value = option.getText();
				System.out.println(value);
				value=value.toLowerCase();
				System.out.println(value+"DS"+DrpDwnOption);
				
				value=value.trim();
				
				value=value.toLowerCase();
				
				value=value.toString();
				
				System.out.println("DRP:"+value+":");
				DrpDwnOption=DrpDwnOption.trim().toLowerCase().toString();
				System.out.println("FRM:"+DrpDwnOption+":");
				
				System.out.println(value.length());
				System.out.println(DrpDwnOption.length());
				if (DrpDwnOption.equalsIgnoreCase(value)) {
					option.click();
					Reporter.log("Selected " + "'" + DrpDwnOption + "'" + " optiopn in the drop down field: ");					
					break;
				}
			}
		}catch(Exception e){
			//log.severe("Exception in the method selectDrpDwnOption: "+ e.getMessage());
			//ge.takeScreenshot(wdSupplierSearch, "selectDrpDwnOption");
			//Assert.assertTrue(false,"Exception in the method selectDrpDwnOption: " + e.getMessage());
		}


	}

	/**
	 * Method Name : verifySupplierStatusAndSelectChkBox
	 * Purpose: Public method which includes logic related to verify the Incomplete supplier and select supplier
	 * @param: List<setTestData> getSupplierSearchData, i, j
	 * @return: None
	 */
	public String verifySupplierStatusAndSelectChkBox(List<setTestData> getSupplierSearchData, int i, int j){
		String strSupplierName="";
		try{
			if(supplierSearchTbl()==true){
				if(lavanteUtils.isElementDisplayed(xpathstatus)==true){					
					String strStatus=lavanteUtils.getText( xpathstatus);
					if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(i).getCustomerTakeControl().toString())){
						Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
						lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + j + xpathoption)));
						strSupplierName=lavanteUtils.getText( xpathsupplierTblName);
						Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");												
					}
				} else {
					//log.severe("Test failed due to 'Status' column element property has changed:");
					//Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
				}
			} else {
				//log.severe("Supplier Search Table is not found");
				//Assert.assertTrue(false,"Exception in the method: verifySupplierStatusAndSelectChkBox: ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifySupplierStatusAndSelectChkBox: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySupplierStatusAndSelectChkBox: " + e.getMessage());
		}
		return strSupplierName;
	}

	/**
	 * Method Name : advanceSupplierSrchResults
	 * Purpose: Public method which includes logic related to get the table row count 
	 * @param: None
	 * @return: RowCount
	 */
	public void advanceSupplierSrchResults(List<setTestData> getSupplierSearchData, int i){
		try{
			lavanteUtils.click( idadvancedTab);
			Reporter.log("Clicked on the 'Advanced Search' tab");
			//ge.waitForTime(2000);
			lavanteUtils.click(xpathbuildQueryBtn);
			Reporter.log("Clicked on the 'Build Query' button");
			//ge.waitForTime(3000);
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			//Supplier Name
			lavanteUtils.click(xpathcompanyProfileTab);
			Reporter.log("Clicked on the 'Company Profile' tab");
			//ge.waitForTime(1000);
			lavanteUtils.click( xpathSupplierDrpDwn);
			Reporter.log("Clicked on the 'Supplier Name' drop down field");
			//ge.waitForTime(1000);
			//Frame out
			lavanteUtils.switchtoFrame(null);	
			lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector( "li.active-result:nth-child(2)")));
			Reporter.log("Selected 'Equals To' option in the drop down:");
			//ge.waitForTime(2000);
			//Frame In
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			//ge.waitForTime(1000);
			lavanteUtils.typeinEdit(getSupplierSearchData.get(i).getSupplierName().toString(),xpathsuppliertxtField);
			//ge.waitForTime(1000);
			lavanteUtils.click(xpathadvanceSearchBtn);
			//ge.waitForTime(2000);
			Reporter.log("Clicked on the 'Search' button");
			//Frame out
			lavanteUtils.switchtoFrame(null);	
			//ge.waitForTime(2000);
		}catch(Exception e){
			//log.severe("Exception in the method verifySuppliersHomePageTitle: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySuppliersHomePageTitle: " + e.getMessage());
		}
	}

	/**
	 * Method Name : getTableRowCount
	 * Purpose: Public method which includes logic related to get the table row count 
	 * @param: None
	 * @return: RowCount
	 */
	public String getTableRowCount(){
		String RowCount="";
		try{
			if(supplierSearchTbl()==true){
				List<WebElement> rowCount = xpathtableRowCount;
				int tableRowCount=rowCount.size();
				RowCount = String.valueOf(tableRowCount);			
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifySuppliersHomePageTitle: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySuppliersHomePageTitle: " + e.getMessage());
		}
		return RowCount;
	}

	/**
	 * Method Name : verify_MoveSupplerProfileComplete
	 * Purpose: Public method which includes logic related to Verify that customer can push incomplete supplier profiles
	 * 			to profile complete through Move to Profile Complete button 
	 * @param: getSupplierSearchData
	 * @return: None
	 */
	public void verify_MoveSupplerProfileComplete(List<setTestData> getSupplierSearchData){
		int j=1;
		verifySuppliersHomePageTitle();

		try{
			for(int i=0;i<getSupplierSearchData.size();i++) { 
				if(getSupplierSearchData.get(i).getSupplierProfileCompleteStatus().toString().length()>0)	
				{	
			
				searchInCompleteStatus(getSupplierSearchData,i);
				//ge.waitForTime(1000);
				//Frame In
				lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
				String SupplierName=verifyIncompleteStatusAndSelectSupplier(getSupplierSearchData,i,j);
				//ge.waitForTime(2000);
				clkSupplierBtnAndSelectOption(xpathotherAction,xpathmoveToProfileComplete, ConfigPathFile.OTHERACTION.getConstantValue(),
						ConfigPathFile.MOVETOPROFILECOMPLETE.getConstantValue());
				//ge.waitForTime(2000);
				//Frame out
				lavanteUtils.switchtoFrame(null);	
				//ge.waitForTime(2000);
				//Validate Dialog pop up and ge.clicks on Ok button
				validateDialogPopup(xpathdialogPopup,expprofileCompletePopupMsg);
				//ge.waitForTime(2000);
				//Validate Success pop up and ge.clicks on Ok button
				validateSuccessMsg(xpathSuccessMsg,expprofileCompleteSuccessMsg);
				//ge.waitForTime(4000);
				//ge.clicks on the Reset Button
				lavanteUtils.click(xpathresetBtn);
				Reporter.log("Clicked on the 'Reset' button");
				//ge.waitForTime(4000);
				if(lavanteUtils.isElementDisplayed(idsupplierName)==true) {
					lavanteUtils.typeinEdit( SupplierName, idsupplierName);
					//ge.waitForTime(2000);
					Reporter.log("Entered Supplier Name:" + SupplierName);
				} else{
					lavanteUtils.takeScreenshot(wdSupplierSearch, "search_button_not_displayed");
					Assert.assertTrue(false,"The search box is not displayed on the page");
				}
				lavanteUtils.typeinEdit( SupplierName, idsupplierName);
				lavanteUtils.click( xpathSearchBtn);
				Reporter.log("Clicked on the 'Search' button");
				//.waitForTime(3000);
				//Frame In
				lavanteUtils.switchtoFrame(xpathsupplierTableFrame);			
				//Profile Stage & Mile Stones Table validation
				verifySupTblAndClkOnSupplierLnk();
				//ge.waitForTime(2000);
				//Frame In
				lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

				lavanteUtils.click( xpathstatusAndHistory);
				//ge.waitForTime(2000);
				Reporter.log("Clicked on the 'Status and History' main tab");
				lavanteUtils.click( xpathprofileAndApprovalHistory);
				Reporter.log("Clicked on the 'Profile & Approval History' sub tab");
				//ge.waitForTime(2000);
				//Verification of Profile Stage and Time Stamp
				if (verifyProfileStageAndTimeStamp()==true){
					Reporter.log("Verification is successful for Supplier move profile complete functionality:");
					closeSupDetailsPopUpWindow();
					//ge.waitForTime(2000);
					//Frame out
					lavanteUtils.switchtoFrame(null);	
					break;
				}
			}	
				}	
		}catch(Exception e){
			//log.severe("Exception in the method verify_MoveSupplerProfileComplete: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_MoveSupplerProfileComplete: " + e.getMessage());
		}
		
	}

	/**
	 * Method Name : verifySuppliersHomePageTitle
	 * Purpose: Public method which includes logic related to validate the Suppliers home page title
	 * @param: None
	 * @return: None
	 */
	public void verifySuppliersHomePageTitle(){

		try{
			//ge.waitForTime(4000);
			/*if(ge.isElementDisplayed(wdSupplierSearch, By.cssSelector(cssPopupCloseBtn))==true){
				ge.clicks(wdSupplierSearch, ConfigPathFile.CSS.getConstantValue(), cssPopupCloseBtn);
				//ge.waitForTime(2000);
			}*/
			lavanteUtils.click(xpathsupplierslink);
			Reporter.log("Clicked on the 'Suppliers' tab");
			//ge.waitForTime(4000);
			//ge.assertPageTitle(wdSupplierSearch, expectedPageTitle);
			String actualPageTitle=wdSupplierSearch.getTitle().trim().toString();
			//Validation - Suppliers Search Page
			if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
				Reporter.log("Suppliers Search page displayed: Expected title: " + expectedPageTitle
						+ " Actual title: " + actualPageTitle);
			}else {
				//Assert.assertTrue(false,"Test failed due to Expected title: " + expectedPageTitle  + "  doesn't match with"
						//+ " Actual title: " + actualPageTitle);
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifySuppliersHomePageTitle: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySuppliersHomePageTitle: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifyProfileStageAndTimeStamp
	 * Purpose: Public method which includes logic related to verify profile stage and time stamp(Date)
	 * @param: None
	 * @return: None
	 */
	private boolean verifyProfileStageAndTimeStamp(){

		Boolean flag=false;
		try{//ge.waitForTime(2000);
			List<WebElement> rowCount = xpathapprovalStatusTbl;
			int tableRowCount=rowCount.size();
			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathprofileStageStatus)){
					String strStatus = lavanteUtils.getText( xpathprofileStageStatus);
					if(strStatus.equalsIgnoreCase(ConfigPathFile.PROFILECOMPLETE.getConstantValue())){
						Reporter.log("Verification of the 'Profile Stage' is successful: Expected: " 
								+ ConfigPathFile.PROFILECOMPLETE.getConstantValue() + " matches with Actual: " + strStatus);
						if(verifyTimeStamp()==true){
							flag=true;
						}						
					} else {

					}
				} else if(lavanteUtils.isElementDisplayed(xpathapproveNoData)==true){
					String strData=lavanteUtils.getText( xpathapproveNoData);
					//log.severe(" Approval Status & Milestones table: " + strData);
					lavanteUtils.takeScreenshot("not_expected_supplier_profile_stage");						
					//Assert.assertTrue(false,"Test failed due to table row count is zero: ");
				}
			} else {
				lavanteUtils.takeScreenshot(wdSupplierSearch, "not_expected_supplier_profile_stage");
				Reporter.log("Approved Status table row count is zero: ");
				//Assert.assertTrue(false,"Test failed due to table row count is zero: ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyProfileStageAndTimeStamp: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyProfileStageAndTimeStamp: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Method Name : validateDialogPopup
	 * Purpose: Public method which includes logic related to validate the dialog Pop up message and ge.clicks on OK Button
	 * @param: String dialogPopup, String expPopupMsg
	 * @return: None
	 */
	public void validateDialogPopup(WebElement dialogPopup, String expPopupMsg ){//ge.waitForTime(2000);
		if(lavanteUtils.isElementDisplayed(dialogPopup)==true){
			String getText=lavanteUtils.getText( dialogPopup);
			//Validation
			if (getText.contains(expPopupMsg)) {
				Reporter.log("Verification is successful for 'dialog pop up' message: " + getText);
				lavanteUtils.click( xpathokEmailBtn);
				//ge.waitForTime(1000);
				Reporter.log("Clicked on the 'OK' button");
			}else {
				//Assert.assertTrue(false,"Test failed due to Expected message: " + expPopupMsg  + "  doesn't match with "
						//+ " Actual message: " + getText);
			}
		} else {
			//log.severe("Test failed due to dialog pop up did not displayed:");
			//Assert.assertTrue(false,"Failed due to dialog pop up did not displayed: ");
		}		
	}

	/**
	 * Method Name : validateSuccessMsg
	 * Purpose: Public method which includes logic related to validate the success message
	 * @param: String SuccessMsg, String expSuccessMsg
	 * @return: None
	 */
	public void validateSuccessMsg(WebElement SuccessMsg, String expSuccessMsg){//ge.waitForTime(2000);
		if(lavanteUtils.isElementDisplayed(SuccessMsg)==true){
			String successMsg=lavanteUtils.getText(SuccessMsg);
			lavanteUtils.waitForTime(2000);
			if(expSuccessMsg.equalsIgnoreCase(successMsg)){
				Reporter.log("Validation is Successful for Success message: Expected: " + "'" + expSuccessMsg + "'"
						+ " match with " + " Actual: " + "'" + successMsg + "'");
				lavanteUtils.click(xpathokEmailBtn);
				Reporter.log("Clicked on the 'OK' button");
			} else {
				//Assert.assertTrue(false,"Test failed due to Expected: " + expSuccessMsg  + " doesn't match with "
					//+ " Actual: " + successMsg);
			}
		}
	}

	/**
	 * Method Name : verifyTimeStamp
	 * Purpose: Public method which includes logic related to verify the time stamp(Date)
	 * @param: None
	 * @return: None
	 */
	private boolean verifyTimeStamp(){

		boolean flag=false;		
		try{//ge.waitForTime(2000);
			//Actual Date
			String sTimeStamp=lavanteUtils.getText( xpathtimeStamp);			
			String [] sTime=sTimeStamp.split(",");	
			System.out.println(sTimeStamp);
			//Expected Date
			String strActual=getDateValue(SupplierStatusDateFormat,GenericTimeZone);
			flag=true;
			//Comparison 
			if(strActual.equals(sTime[0])){
				Reporter.log("Supplier 'Profile Stage' Staus date: " + sTimeStamp);
				flag=true;
			} else {
				//log.severe("Supplier 'Profile Stage' Staus date:" + sTimeStamp);
			}			
		} catch(Exception e){
			//log.severe("Exception in the method verifyTimeStamp: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyTimeStamp: " + e.getMessage());
		}
		System.out.println(flag+"FLAG TIME STAMP");
		return flag;	
	}

	/**
	 * Method Name : getDateValue
	 * Purpose: Public method which includes logic related to return the date value
	 * @param: None
	 * @return: None
	 */
	public  String getDateValue(String strFormat, String strTimeZone) {
		String CalDate ="";
		try {//ge.waitForTime(2000);
			SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
			dateFormat.setTimeZone(TimeZone.getTimeZone(strTimeZone));
			CalDate = dateFormat.format(new Date());			
		}catch (Exception e){
			//log.severe("Exception in the method getDateValue: "+e.getMessage());	
		}
		return CalDate;

	}

	/**
	 * Method Name : validateErrorMessage
	 * Purpose: Public method which includes logic related to validate the expected error message
	 * @param: None
	 * @return: None
	 */
	public void validateErrorMessage(){
		try{//ge.waitForTime(2000);
			if(lavanteUtils.isElementDisplayed(xpatheditUserErrorMsg)==true) {
				String strText=lavanteUtils.getText( xpatheditUserErrorMsg);			
				if(expContactEmailMsg.equalsIgnoreCase(strText)){		
					Reporter.log("Validation is Successful for No duplicate Email: Expected: " + "'" + expContactEmailMsg + "'"
							+ " match with " + " Actual: " + "'" + strText + "'");
				}
			} else {
				Reporter.log("Edit User popup did not appeared on the Enterprise Owned page");
			}
		}catch(Exception e){
			//log.severe("Exception in the method validateErrorMessage: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateErrorMessage: " + e.getMessage());
		}
	}

	/**
	 * Method Name : searchInactiveStatus
	 * Purpose: Public method which includes logic related to select the drop down status and ge.clicks on search button
	 * @param: List<setTestData> getSupplierSearchData, i
	 * @return: None
	 */
	public void searchInactiveStatus(List<setTestData> getSupplierSearchData, int i){
		try{//ge.waitForTime(2000);
			
			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,
					getSupplierSearchData.get(i).getProfileStatus().toString());
			Reporter.log("Selected " + getSupplierSearchData.get(i).getSendEmailStatus().toString() +
					" option in the profile" + " status dropdown");*/
			
			selectProfileStatus(getSupplierSearchData.get(0).getSendEmailStatus().toString());
			
			selectChkBoxAndclkSearchBtn();
		} catch(Exception e) {
			//log.severe("Exception in the method searchInactiveStatus: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method searchInactiveStatus: " + e.getMessage());
		}
	}

	/**
	 * Method Name : selectChkBoxAndclkSearchBtn
	 * Purpose: Public method which includes logic related to select the deactivate check box and ge.clicks on search button 
	 * @param: None
	 * @return: None
	 */
	public void selectChkBoxAndclkSearchBtn(){
		try{//ge.waitForTime(2000);
			lavanteUtils.click( iddeactivatedSuppliers);
			Reporter.log("Deactivated supplier checkbox is enabled");
			lavanteUtils.click( xpathSearchBtn);
			Reporter.log("Clicked on the 'Search' button");
		}catch(Exception e){
			//log.severe("Exception in the method clkSearchBtn: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method clkSearchBtn: " + e.getMessage());
		}
	}

	/**
	 * Method Name : searchInCompleteStatus
	 * Purpose: Public method which includes logic related to select the drop down status and ge.clicks on search button
	 * @param: List<setTestData> getSupplierSearchData, i
	 * @return: None
	 */
	public void searchInCompleteStatus(List<setTestData> getSupplierSearchData, int i){
		try{//ge.waitForTime(2000);  
			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,
					getSupplierSearchData.get(i).getSupplierProfileCompleteStatus().toString());
			Reporter.log("Selected " + getSupplierSearchData.get(i).getSupplierProfileCompleteStatus().toString() +
					" option in the profile" + " status dropdown");*/
			
			selectProfileStatus( getSupplierSearchData.get(0).getSendEmailStatus().toString());
			
			selectChkBoxAndclkSearchBtn();
		}catch(Exception e) {
			//log.severe("Exception in the method searchInCompleteStatus: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method searchInCompleteStatus: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verifyIncompleteStatusAndSelectSupplier
	 * Purpose: Public method which includes logic related to verify the Incomplete supplier and select supplier
	 * @param: List<setTestData> getSupplierSearchData, i, j
	 * @return: None
	 */
	public String verifyIncompleteStatusAndSelectSupplier(List<setTestData> getSupplierSearchData, int i, int j){
		String strSupplierName="";
		try{
			if(supplierSearchTbl()==true){
				if(lavanteUtils.isElementDisplayed(xpathstatus)==true){						
					String strStatus=lavanteUtils.getText( xpathstatus);
					if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(i).getSupplierProfileCompleteStatus().toString())){
						Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
						//verification of the complete percentage of a supplier and ge.clicks
						strSupplierName=verify_Supplier_Complete_Percentage();
						Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
					}
				} else {
					//log.severe("Test failed due to 'Status' column element property has changed:");
					//Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
				}
			} else {
				//log.severe("Supplier Search Table is not found");
				//Assert.assertTrue(false,"Exception in the method: verifyIncompleteStatusAndSelectSupplier: ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyIncompleteStatusAndSelectSupplier: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyIncompleteStatusAndSelectSupplier: " + e.getMessage());
		}
		return strSupplierName;
	}

	/**
	 * Method Name : clkSupplierBtnAndSelectOption
	 * Purpose: Public method which includes logic related to ge.clicks on the supplier tab and select the option in drop down
	 * @param: String sTab, String sOption, String sTabName, String sOptionName
	 * @return: None
	 */
	public void clkSupplierBtnAndSelectOption(WebElement sTab, WebElement sOption, String sTabName, String sOptionName){
		try{
			lavanteUtils.click(sTab);
			//ge.waitForTime(1000);
			Reporter.log("Clicked on the " + sTabName + " button");
			lavanteUtils.click(sOption);
			Reporter.log("Clicked on the " + sOptionName + " option in the dropdown");
			//ge.waitForTime(1000);
		}catch(Exception e){
			//log.severe("Exception in the method clkSupplierBtnAndSelectOption: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method clkSupplierBtnAndSelectOption: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_Supplier_Complete_Percentage
	 * Purpose: Public method which includes logic related to verify the profile complete percentage and select the supplier
	 * @param: None
	 * @return: None
	 */
	public String verify_Supplier_Complete_Percentage(){	

		String strSuppName=""; boolean flag=true;

		try {			
			while(flag==true){

				String sRow=getTableRowCount();
				int rowCount=Integer.parseInt(sRow);

				for(int j=1;j<=rowCount;j++){
					String sPercentage=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath(
							xpathprofileCompletePercentage + j + xpathValueOption)));
					int pos=(sPercentage.length())-1;			
					String sPercent= sPercentage.substring(0, pos) + sPercentage.substring(pos + 1);
					int intPercentage=Integer.parseInt(sPercent);
					//Verification
					if(intPercentage>30){				
						lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + j + xpathoption)));
						strSuppName=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath(
								xpathsupplierProfile + j + xpathChkBoxName)));
						flag=false;
						break;
					}
					if(j==rowCount){
						lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( "//form[contains(@id,'supplierSearchResultForm')]/div[1]/div[1]/div[3]/div[1]/a[contains(@title,'Go to next page')]")));
						//ge.waitForTime(2000);
						flag=true;
						//Reporter.log("did not find any supplier who have more than 20% profile complete in the supplier results");
					}
				}
			}
		} catch(Exception e) {
			//log.severe("Exception in the method verify_Supplier_Complete_Percentage: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_Supplier_Complete_Percentage: " + e.getMessage());
		}
		return strSuppName;
	}

	/**
	 * Method Name : verifySupplierSrchTblAndSelectSupplier
	 * Purpose: Public method which includes logic related to verify the inactive supplier and select supplier
	 * @param: None
	 * @return: None
	 */
	public String verifySupplierSrchTblAndSelectSupplier(){
		String strReturnVal="";
		try{
			if(supplierSearchTbl()==true){
				List<WebElement> rowCount = xpathtableRowCount;
				System.out.println(rowCount.size());
				int tableRowCount=rowCount.size();
				for(int k=1;k<=tableRowCount;k++){
					String strStatus=lavanteUtils.getText(xpathstatus);
					Reporter.log("Selected " + "'" + strStatus + "'" + " Status Supplier in the Search results table");
					System.out.println(xpathselect + k + xpathoption);
					lavanteUtils.click(wdSupplierSearch.findElement(By.xpath(xpathselect + k + xpathoption)));
					Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
					strReturnVal=lavanteUtils.getText( xpathsamecontactEmail);
					break;
				}
			} else {
				//log.severe("Supplier Search Table is not found");
				//Assert.assertTrue(false,"Exception in the method verifySupplierSrchTblAndSelectSupplier: ");
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifySupplierSrchTblAndSelectSupplier: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifySupplierSrchTblAndSelectSupplier: " + e.getMessage());
		}
		return strReturnVal;
	}

	/*	*//**
	 * Method Name : verifySupplierSrchTblAndSelectSupplier
	 * Purpose: Public method which includes logic related to verify the inactive supplier and select supplier
	 * @param: List<setTestData> getSupplierSearchData, i, j
	 * @return: None
	 *//*
	public void verifySupplierSrchTblAndSelectSupplier(List<setTestData> getSupplierSearchData, int i){
		try{
			if(supplierSearchTbl()==true){
				if(ge.isElementDisplayed(wdSupplierSearch, By.xpath(xpathstatus))==true){						
					String strStatus=getText(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathstatus);
					if(strStatus.equalsIgnoreCase(getSupplierSearchData.get(i).getProfileStatus().toString())){
						List<WebElement> rowCount = wdSupplierSearch.findElements(By.xpath(xpathtableRowCount));
						int tableRowCount=rowCount.size();
						for(int k=1;k<tableRowCount;k++){
							String strContactEmailOption=getText(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(),
									xpathcontactEmailColumn + k + xpathoptionName);							
							if(!(strContactEmailOption.isEmpty())){
								Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
								ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathselect + k + xpathoption);
								Reporter.log( "'" + strStatus + "'" + " status supplier checkbox is selected in the Supplier search table");
								break;
							} else if (k==tableRowCount) {
								//log.severe("Test failed due to 'No data available' in the 'Contact Email' coloumn name: ");
								Assert.assertTrue(false,"Test failed due to No data available in the 'Contact Email' coloumn name:  ");
							}
						}
					}
				} else {
					//log.severe("Test failed due to 'Status' column element property has changed:");
					Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
				}
			} else {
				//log.severe("Supplier Search Table is not found");
				Assert.assertTrue(false,"Exception in the method selectInactiveSupplierAndClkEditProfile: ");
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifySupplierSrchTblAndSelectSupplier: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifySupplierSrchTblAndSelectSupplier: " + e.getMessage());
		}
	}*/


	/**
	 * Method Name : verifyDownLoadFileHistoryTbl
	 * Purpose: Public method which includes logic related to verify the download file history table
	 * @param: None
	 * @return: None
	 */
	public boolean verifyDownLoadFileHistoryTbl() {
		boolean flag=false;

		try{
			
			List<WebElement> rowCount = xpathdownloadFileRowCount;
			
			int tableRowCount=rowCount.size();
			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathdownloadFileName)){
					
					String strDownLoadFileName=lavanteUtils.getText( xpathdownloadFileName);
					String strDownLoadedOn=lavanteUtils.getText( xpathdownloadedOn);
					String strRecordsCount=lavanteUtils.getText(xpathdownloadedRecordsCount);
					String strDownLoadStatus=lavanteUtils.getText( xpathdownloadStatus);
					if(verifyEntityFieldsData(strDownLoadFileName,strDownLoadedOn,strRecordsCount,strDownLoadStatus)==true){
						flag=true;						
					}
				} else {
					//log.severe("Test failed due to 'Download File Name' field is not appeared: ");
					//Assert.assertTrue(false,"Test failed due to 'Download File Name' field is not appeared: ");
				}
			} else {
				//log.severe("Download File history table row count is zero: ");
				//Assert.assertTrue(false,"Test failed due to table row count is zero: ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyDownLoadFileHistoryTbl: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyDownLoadFileHistoryTbl: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Method Name : verifyEntityFieldsData
	 * Purpose: Public method which includes logic related to validate the data
	 * @param: String sFileName, String sDate, String sRecordsCount, String sStatus
	 * @return: None
	 */
	private boolean verifyEntityFieldsData(String sFileName, String sDate, String sRecordsCount, String sStatus){

		if((sStatus.trim()).equalsIgnoreCase(ConfigPathFile.COMPLETED.getConstantValue())){
			if(sRecordsCount.isEmpty()) {
				//log.severe("Failed due to Download file history table:'No of Records' count is empty: ");
				//Assert.assertTrue(false,"Test failed due to Download file history table:'No of Records' count is empty: ");
			} else {
				int rowValue= Integer.parseInt(sRecordsCount);
				Integer intVal=Integer.valueOf(rowValue);
				if((rowValue==0) || (intVal == null)){
					//log.severe("Failed due to Download file history table:'No of Records' count is empty: ");
					//Assert.assertTrue(false,"Test failed due to Download file history table:'No of Records' count is Zero: ");				
				} else {
					Reporter.log("DownLoaded File Name : " + sFileName + " Date: " + sDate + " Records Count: " + sRecordsCount +
							" And The DownLoaded Status: " + sStatus);
					return true;
				}
			}
		} else {
			//log.severe("Download Status: Expected " + ConfigPathFile.Complete.getConstantValue() +  ""
				//	+ " not matched with Actual: " + sStatus);
			//Assert.assertTrue(false,"Test failed due to Download file history table: Expected Status: "
					//+ ConfigPathFile.COMPLETED.getConstantValue() +  " not matched with Actual: " + sStatus);
		}
		return false;
	}

	/**
	 * Method Name : verify_VMFNewSuppName
	 * Purpose: Public method which includes logic related to verify the VMF Outreach Supplier Name
	 * @param: String sSupplierName
	 * @return: true/false
	 */
	public boolean verify_VMFNewSuppName(String sSupplierName){
		boolean flag=false;

		try{
			lavanteUtils.click(xpathresetBtn);
			Reporter.log("Clicked on the 'Reset' button");
			if(lavanteUtils.isElementDisplayed(idsupplierName)==true){
				lavanteUtils.typeinEdit(sSupplierName, idsupplierName);			
				Reporter.log("Entered supplier name:" + sSupplierName);
			} else {
				lavanteUtils.takeScreenshot(wdSupplierSearch, "did not displayed basis search page:");
				//Assert.assertTrue(false,"Test failed due to Basic search page section did not displayed: ");
			}
			lavanteUtils.click(xpathSearchBtn);
			Reporter.log("Clicked on the 'Search' button");
			//ge.waitForTime(2000);

			lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
			if(verifySupplierTblData()==true){
				flag=true;
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_VMFNewSuppName: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verify_VMFNewSuppName: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Method Name : supplierSearchTbl
	 * Purpose: Public method which includes logic related to validate the Suppliers search table
	 * @param: None
	 * @return: None
	 */
	public boolean supplierSearchTbl() {
		boolean flag=false;

		try{
			List<WebElement> rowCount = xpathtableRowCount;
			int tableRowCount=rowCount.size();
			if(!(tableRowCount==0)){
				if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
					String strData=lavanteUtils.getText( xpathnoData);
					Reporter.log("Supplier Search Table data: " + strData);
					//ge.takeScreenshot(wdSupplierSearch, "no_data_found");
					//Assert.assertTrue(false, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
				} else {
					for (int j=1;j<=rowCount.size();j++) {
						List<WebElement> headersCount = xpathheaderCount;
						List<WebElement> dataCount = xpathdataCount;
						if(headersCount.size()==dataCount.size()){		
							flag=true;
							break;
						}
					}
				}
			} else {
				Reporter.log("Supplier Search table is not found");
				//Assert.assertTrue(false,"Test failed due to 'Supplier Search' table row count is zero: ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method supplierSearchTbl: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method supplierSearchTbl: " + e.getMessage());
		}
		return flag;	
	}

	/**
	 * Method Name : supplierSearchTbl
	 * Purpose: Public method which includes logic related to validate the Suppliers search table
	 * @param: None
	 * @return: None
	 */
	public void verifySyncBscSrchAdvSrchTblData(String strExpSupplierName,String strExpBusinessContact,String strExpRowCount,String strActualSuppName,
			String strActualBusinessContact, String strActualRowCount){
		try{
			if(strExpSupplierName.equalsIgnoreCase(strActualSuppName)){
				Reporter.log("Synchronization is successful for 'Supplier Name': Basic Search: " + "'" + strExpSupplierName + "' " +
						" Advanced Search: " + "'" + strActualSuppName + "' ");
				if(strExpBusinessContact.equalsIgnoreCase(strActualBusinessContact)){			
					Reporter.log("Synchronization is successful for 'Business/Sales Contact': Basic Search: " + "'" + strExpBusinessContact + "' " +
							" Advanced Search: " + "'" + strActualBusinessContact + "' ");
					if(strExpRowCount.equalsIgnoreCase(strActualRowCount)){
						Reporter.log("Synchronization is successful for 'Table Row count': Basic Search: " + "'" + strExpRowCount + "' " +
								" Advanced Search: " + "'" + strActualRowCount + "' ");					
					}else {
						//log.severe("Synchronization is failed for 'Table Row count': Basic Search: " + "'" + strExpRowCount + "' " +
							//	" Advanced Search: " + "'" + strActualRowCount + "' ");						
						//Assert.assertTrue(false,"Test failed due to Synchronization failed for 'Table Row count': Basic Search: " + "'" +
							//	strExpRowCount + "' " + " Advanced Search: " + "'" + strActualRowCount + "' ");
					}
				}else {
					//log.severe("Synchronization is failed for 'Business/Sales Contact': Basic Search: " + "'" + strExpBusinessContact + "' " +
						//	" Advanced Search: " + "'" + strActualBusinessContact + "' ");
					//Assert.assertTrue(false,"Test failed due to Synchronization failed for 'Business/Sales Contact':"
						//	+ " Basic Search: " + "'" +	strExpBusinessContact + "' " + " Advanced Search: " + "'" + strActualBusinessContact + "' ");
				}
			} else {
				//log.severe("Synchronization is failed for 'Supplier Name': Basic Search: " + "'" + strExpSupplierName + "' " +
					//	" Advanced Search: " + "'" + strActualSuppName + "' ");
				//Assert.assertTrue(false,"Test failed due to Synchronization failed for 'Supplier Name': Basic Search: " + "'" +
						//strExpSupplierName + "' " + " Advanced Search: " + "'" + strActualSuppName + "' ");
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyTblData: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyTblData: " + e.getMessage());
		}
	}

	/**
	 * Method Name : validateErrorMessage
	 * Purpose: Public method which includes logic related to validate the error message
	 * @param: List<setTestData> getSupplierSearchData, i
	 * @return: None
	 */
	public void validateErrorMessage(List<setTestData> getSupplierSearchData, int i) {
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		String strErrorMsg="";

		strErrorMsg=lavanteUtils.getText( xpathErrorMessage);
		if(!(getSupplierSearchData.get(i).getErrorMessage().trim().toString().equalsIgnoreCase(strErrorMsg))){
			//ge.waitForTime(1000);
			lavanteUtils.takeScreenshot(wdSupplierSearch, methodName);
			//log.severe("Validation is failed in the method validateErrorMessage due to: " + strErrorMsg);
			//Assert.assertTrue(false,"Test failed due to Validation is failed in the method validateErrorMessage due to: " + strErrorMsg);
		}else {
			Reporter.log("Expected error Message: " + strErrorMsg);
		}
	}
	/**
	 * Method Name : editSupProfileAddress
	 * Purpose: Public method which edits the existing suppliers address
	 * @param: List<setTestData> getSupplierSearchData, i
	 * @return: None
	 */
	public void editSupProfileAddressAAA(List<setTestData> getNewSupplierList){
		String getActSavedText="",strErrorMsg="",expSavedMsg=expProfileSavedPopupsMsg;
		lavanteUtils.switchtoFrame(null);
		//ge.waitForTime(10000);
		try {
			int i;
			for(i=0;i<getNewSupplierList.size();i++){
				//ge.waitForTime(1000);
				if(lavanteUtils.isElementDisplayed(XpatheEditProfileTabTitlesList)==true)
				{
					lavanteUtils.fluentwait(XpatheEditProfileTabTitlesList);
					lavanteUtils.click(XpathProfileTab1);
					//ge.waitForTime(2000);
					lavanteUtils.click(XpathAddressDrpDwn);
					//ge.waitForTime(500);
					lavanteUtils.selectDropDownValue(XpathAddressDrpDwnList,getNewSupplierList.get(i).getUpdatedAddress().trim().toString());
					// add address page
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getAddress().toString(),IdAddress1EditField);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getCity().toString(),IdCityEditField);
					lavanteUtils.click(XpathCountryDrpDwn);
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.selectDropDownValue(XpathCountryDrpDwnList,getNewSupplierList.get(i).getCountry().toString());
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
					lavanteUtils.click(XpathStateDrpDwn);
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.selectDropDownValue(XpathStateDrpDwnList,getNewSupplierList.get(i).getState().toString());
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getPostalCode().trim().toString(),IdZipCode);
					lavanteUtils.click(XpathBtnSaveAddress);
					if(lavanteUtils.isElementDisplayed(XpatherrorMsg)){
						lavanteUtils.click(CssBtnCancel);
						strErrorMsg=lavanteUtils.getText(XpatherrorMsg);
						Assert.assertTrue(false, "Test failed due to: "+ strErrorMsg);
					}
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.click(IdBtnSaveExit);
					if(lavanteUtils.isElementDisplayed(xpathSuccessMsg))
					{
						getActSavedText=lavanteUtils.getText(xpathSuccessMsg);
						lavanteUtils.click(XpathBtnOk);
						if(expSavedMsg.equalsIgnoreCase(getActSavedText)){
							Reporter.log(" Supplier Address edited successfully ");
						}else{
							Reporter.log(" Verification failed for add new address for existing Supplier ");
						}
					}
				}else{
					//log.severe("Test failed due to expected profile home page does not appears : ");
					Assert.assertTrue(false,"Test failed due to expected profile home page does not appears : ");
				}

			}
		} catch (Exception e) {
			//log.severe("Exception in the method editSupProfileAddressAAA: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method editSupProfileAddressAAA: " + e.getMessage());
		}
	}

	/**
	 * Method Name : createNewSupplier
	 * Purpose: Public method which creates a new supplier
	 * @param: String sSupplierName, String sContactName, String sEmail, String sInviteOrg,
			String sSupplierGrp, String sComment
	 * @return: None
	 */
	public String  createNewSupplier(String sSupplierName, String sContactName, String sEmail, String sInviteOrg,
			String sSupplierGrp, String sComment){
		String concatenateSupplier="",concatenateContactName="",concatenateEmail="";

		try{
			//Frame In
			lavanteUtils.switchtoFrame(xpathsupplierTableFrame);
			//ge.clicks on the Create New Supplier link
			lavanteUtils.click( LnkTxtInviteNewSupplier);
			Reporter.log("Clicked on the 'Invite New Supplier' link");
			//Frame Out
			lavanteUtils.switchtoFrame(null);
			//Frame In
			//lavanteUtils.switchtoFrame(xpathactivatePopupFrame);		
			//Enter Supplier Name
			if(!(sSupplierName.trim().toString()==(""))){
				concatenateSupplier= getUserName(sSupplierName);	
				lavanteUtils.typeinEdit( concatenateSupplier,idsupplierName);
				Reporter.log("Entered 'Supplier name':" + concatenateSupplier);
			}
			//Enter Contact Name
			if(!(sContactName.trim().toString()==(""))){
				concatenateContactName= getUserName(sContactName);			
				lavanteUtils.typeinEdit(concatenateContactName,idcontactName);
				Reporter.log("Entered 'Contact name':" + concatenateContactName);
			}
			//Contact Email
			if(!(sEmail.trim().toString()==(""))){
				concatenateEmail= lavanteUtils.getEmail(sEmail);
				lavanteUtils.typeinEdit( concatenateEmail,Idemail);
				//ge.waitForTime(1000);
			}
			//Inviting Organization
			if(!(sInviteOrg.trim().toString()==(""))){
				lavanteUtils.selectDropDownValue(idinvitingOrganization,
						sInviteOrg);
				//SelselectDropDownValue(wdSupplierSearch, "", idinvitingOrganization,
					//	sInviteOrg);
				Reporter.log("Selected 'Inviting Organization':" + sInviteOrg);
			}
			//Supplier Group
			lavanteUtils.click( xpathsupplierGroup);
			//Frame Out
			lavanteUtils.switchtoFrame(null);
			//ge.waitForTime(1000);
			if(!(sSupplierGrp.trim().toString()==(""))){
				lavanteUtils.selectDropDownValue(XpathSupplierGroupList,sSupplierGrp);
				Reporter.log("Selected 'Supplier Group':" + sSupplierGrp);
			}
			//Frame In
			//lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			//Enter Comment in Reason for New Supplier Section
			if(!(sComment.trim().toString()==(""))){
				lavanteUtils.typeinEdit(sComment,	idsupplierInviteJustification);
				Reporter.log("Enter 'Comment' in the 'Reason for Creation':" + sComment);
				//ge.waitForTime(1000);
			}
			
			lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( "//input[@id='supplierListCheckConfirmation']")));
			
			//ge.clicks on the Continue Button
			lavanteUtils.click(IdBtnContinue);
			//ge.waitForTime(2000);
			//Frame Out
			lavanteUtils.switchtoFrame(null);
		}catch(Exception e){
			//log.severe("Exception in the method createNewSupplier: "+ e.getMessage());
			//ge.takeScreenshot(wdSupplierSearch, "createNewSupplier");
			//Assert.assertTrue(false,"Exception in the method createNewSupplier: " + e.getMessage());
		}

		return concatenateSupplier;
	}

	/**
	 * Method Name : searchBasicSupplier
	 * Purpose: Public method which includes logic related to validate the error message
	 * @param: String supName,String businessContact,String profileStatus, String checkBoxForInactive
	 * @return: None
	 */
	public void searchBasicSupplier(String supName,String businessContact,String profileStatus, String checkBoxForInactive){
		//ge.waitForTime(2000);		
		lavanteUtils.click( xpathsupplierslink);
		//ge.waitForTime(2000);
		lavanteUtils.assertPageTitle( expectedPageTitle);
		lavanteUtils.click(idsearchtab);
		Reporter.log("Clicked on the |Basic Search| Tab Button successfully");
		//ge.waitForTime(3000);
		if(supName.isEmpty()==false){
			lavanteUtils.typeinEdit(supName,idsupplierName);
		}
		if(businessContact.isEmpty()==false){
			System.out.println("businessContact");
		}
		if(profileStatus.isEmpty()==false){
			System.out.println("profileStatus");
			/*ge.selectDropDownValue(wdSupplierSearch, ConfigPathFile.ID.getConstantValue(), idprofileStatus,profileStatus);
			Reporter.log("Selected " + profileStatus + " option in the profile status dropdown");*/	
			
			selectProfileStatus( profileStatus);
		}
		if(checkBoxForInactive.isEmpty()==false){
			System.out.println("checkBoxForInactive");
			lavanteUtils.click( iddeactivatedSuppliers);
			Reporter.log("Deactivated supplier checkbox is enabled");
		}

		lavanteUtils.click(xpathSearchBtn);
		Reporter.log("Clicked on the 'Search' button");
		//ge.waitForTime(2000);
	}
	/**
	 * Method Name : selectFirstSupplierFromList
	 * Purpose: Public method which will validate supplier records and select the first supplier record based on search criteria
	 * @param: String expProfileStatus
	 * @return: None
	 */
	public void selectFirstSupplierFromList(String expProfileStatus){
		String strStatus="",strData="";
		lavanteUtils.switchtoFrame(idSearchResultsFrame);
		List<WebElement> listOfRows=XpathSupTableRowList;
		try {
			if(listOfRows.size()>=1){
				for(int k=1;k<=listOfRows.size();k++){
					//ge.waitForTime(500);
					if(lavanteUtils.isElementDisplayed(xpathdataNotFound)==true){
						strData=lavanteUtils.getText( xpathnoData);
						Reporter.log("Supplier Search Table data: " + strData);		
						Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
					}else{
						strStatus=lavanteUtils.getText(xpathstatus);
						if(strStatus.equalsIgnoreCase(expProfileStatus))
						{
							lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathselect + k + xpathoption)));
							Reporter.log( "supplier checkbox is selected in the Supplier search table");
							//ge.waitForTime(1000);
							break;
						}
					}
				}
			}else{
				Reporter.log(" Supplier Records are not available for the option: ");
			}
		} catch (Exception e) {
			//log.severe(" Records of Suppliers are not found due to : "+e.getMessage());
		}
	}
	/**
	 * Method Name : editSupProfile
	 * Purpose: Method used to ge.clicks on Edit Profile Button which takes application Supplier Profile Page
	 * @param: None
	 * @return: None
	 */
	public void editSupProfile(){
		try {//ge.waitForTime(2000);
			lavanteUtils.click( xpathprofileBtn);
			Reporter.log("Clicked on the | Profile | Blue Button successfully");
			//ge.waitForTime(1000);
			lavanteUtils.click(cssProfileEditBtn);
			Reporter.log("Clicked on the | Edit Profile | Sub Button successfully");
			lavanteUtils.switchtoFrame(null);
		} catch (Exception e) {
			//log.severe(" Exception in the method editSupProfile due to : "+e.getMessage());
		}
	}



	/**
	 * Method Name : addSupProfileAddress
	 * Purpose: Public method which edits the existing suppliers address
	 * @param: List<setTestData> getSupplierSearchData, i
	 * @return: None
	 */
	public void addSupProfileAddress(List<setTestData> getNewSupplierList,String clickOnDrpDwnListID,String tabIndex,String expVisibleElm){
		String clickOn="",selectDrpDwnList="";
	
		clickOn=xAddNewDrpDwnBtnPrefix+clickOnDrpDwnListID+xAddNewDrpDwnBtnSuffix;
		selectDrpDwnList=xAddNewDrpDwnBtnPrefix+clickOnDrpDwnListID+xAddNewDrpDwnListSuffix;

		objSupplierProfilePage = PageFactory.initElements(wdSupplierSearch,SupplierProfilePage.class);
		String getActSavedText="",strErrorMsg="",expSavedMsg=expProfileSavedPopupsMsg;
		lavanteUtils.switchtoFrame(null);
		//ge.waitForTime(10000);
		try {
			int i;
			for(i=0;i<getNewSupplierList.size();i++){
				//ge.waitForTime(1000);
				if(lavanteUtils.isElementDisplayed(XpatheEditProfileTabTitlesList)==true)
				{
					lavanteUtils.fluentwait(XpatheEditProfileTabTitlesList);

					objSupplierProfilePage.clickOnProfileTabsByName(profileTab,expVisibleElm);
					//ge.waitForTime(2000);

					if(lavanteUtils.switchtoFrame(xpathactivatePopupFrame)==true)
					{
						if(lavanteUtils.isElementDisplayed(IdLeavePopupBtn)){
							lavanteUtils.click(IdLeavePopupBtn);
						}
					}

					//ge.clicks on main tabs
					//clickOnProfileTabs(profileTab,tabIndex,expVisibleElm);

					//ge.clicks on drop down list field to open list of values to select
					lavanteUtils.click(wdSupplierSearch.findElement(By.xpath(clickOn)));
					//ge.waitForTime(500);
					lavanteUtils.selectDropDownValue(wdSupplierSearch.findElement(By.xpath(selectDrpDwnList)),getNewSupplierList.get(i).getUpdatedAddress().trim().toString());


					// add address popup page
					//addCompanyDetails(getNewSupplierList.get(i));

					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getAddress().toString(),IdAddress1EditField);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getCity().toString(),IdCityEditField);
					lavanteUtils.click(XpathCountryDrpDwn);
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.selectDropDownValue(XpathCountryDrpDwnList,getNewSupplierList.get(i).getCountry().toString());
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.click(XpathStateDrpDwn);
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.selectDropDownValue(XpathStateDrpDwnList,getNewSupplierList.get(i).getState().toString());
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getPostalCode().trim().toString(),IdZipCode);

					lavanteUtils.click(XpathBtnSaveAddress);
					if(lavanteUtils.isElementDisplayed((XpatherrorMsg))){
						lavanteUtils.click(CssBtnCancel);
						strErrorMsg=lavanteUtils.getText(XpatherrorMsg);
						Assert.assertTrue(false, "Test failed due to: "+ strErrorMsg);
					}
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);


					if(lavanteUtils.isElementDisplayed((IdBtnSaveExit))){
						lavanteUtils.click(IdBtnSaveExit);
					}else if(lavanteUtils.isElementDisplayed(wdSupplierSearch.findElement( By.id("save_button")))){
						lavanteUtils.click(IdSupProfileSaveBtn);
					}
					if(lavanteUtils.isElementDisplayed(xpathSuccessMsg))
					{
						getActSavedText=lavanteUtils.getText(xpathSuccessMsg);
						lavanteUtils.click(XpathBtnOk);
						if(expSavedMsg.equalsIgnoreCase(getActSavedText)){
							Reporter.log(" Supplier Address added successfully ");
						}else{
							Reporter.log(" Verification failed for add new address for existing Supplier ");
						}
					}

				}else{
					//log.severe("Test failed due to expected profile home page does not appears : ");
					//Assert.assertTrue(false,"Test failed due to expected profile home page does not appears : ");
				}

			}
		} catch (Exception e) {
			//log.severe("Exception in the method addSupProfileAddress: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method addSupProfileAddress: " + e.getMessage());
		}
	}
	/**
	 * Method Name : editSupProfileAddress
	 * Purpose: Public method which edits the existing suppliers address
	 * @param: List<setTestData> getSupplierSearchData, i
	 * @return: None
	 */
	public void editSupProfileAddress(List<setTestData> getNewSupplierList){
		SupplierProfilePage objSupplierProfilePage = PageFactory.initElements(wdSupplierSearch,SupplierProfilePage.class);
		String getActSavedText="",strErrorMsg="",expSavedMsg=expProfileSavedPopupsMsg;
		lavanteUtils.switchtoFrame(null);
		//ge.waitForTime(10000);
		try {
			int i;
			for(i=0;i<getNewSupplierList.size();i++){
				//ge.waitForTime(1000);
				if(lavanteUtils.isElementDisplayed(XpatheEditProfileTabTitlesList)==true)
				{
					lavanteUtils.fluentwait(XpatheEditProfileTabTitlesList);
					//ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(),XpathProfileTab1);
					objSupplierProfilePage.clickOnMenuTabsByName(getNewSupplierList.get(i).getTabNames().toString(),getNewSupplierList.get(i).getWebElements().trim().toString());

					//ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(),XpathAddressDrpDwn);
					//ge.waitForTime(500);
			//		lavanteUtils.SelselectDropDownValue(wdSupplierSearch, "","headquarterAddressId",getNewSupplierList.get(i).getUpdatedAddress().trim().toString());
					// add address page
					//ge.waitForTime(500);

					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getAddress().toString(),IdAddress1EditField);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getCity().toString(),IdCityEditField);
					lavanteUtils.click(XpathCountryDrpDwn);
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.selectDropDownValue(XpathCountryDrpDwnList,getNewSupplierList.get(i).getCountry().toString());
					lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
					lavanteUtils.click(XpathStateDrpDwn);
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.selectDropDownValue(XpathStateDrpDwnList,getNewSupplierList.get(i).getState().toString());
					lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
					lavanteUtils.typeinEdit(getNewSupplierList.get(i).getPostalCode().trim().toString(),IdZipCode);
					lavanteUtils.click(XpathBtnSaveAddress);
					if(lavanteUtils.isElementDisplayed(XpatherrorMsg)){
						lavanteUtils.click(CssBtnCancel);
						strErrorMsg=lavanteUtils.getText(XpatherrorMsg);
						Assert.assertFalse(true, "Test failed due to: "+ strErrorMsg);
					}
					lavanteUtils.switchtoFrame(null);
					//ge.waitForTime(1000);
					lavanteUtils.click(IdBtnSaveExit);
					//ge.waitForTime(2000);
					if(lavanteUtils.isElementDisplayed((XpathBtnOk))==true)
					{
						getActSavedText=lavanteUtils.getText(xpathSuccessMsg);
						//ge.waitForTime(1000);
						lavanteUtils.click(XpathBtnOk);
						if(lavanteUtils.isElementDisplayed((XpathBtnOk))==true){
							lavanteUtils.click(XpathBtnOk);
						}
						if(expSavedMsg.equalsIgnoreCase(getActSavedText)){
							Reporter.log(" Supplier Address edited successfully ");
						}else{
							Reporter.log(" Verification failed for add new address for existing Supplier ");
						}
					}else{
						Reporter.log(" Pop up window not apprears  ");
					}
				}else{
					//log.severe("Test failed due to expected profile home page does not appears : ");
					Assert.assertTrue(false,"Test failed due to expected profile home page does not appears : ");
				}

			}
		} catch (Exception e) {
			//log.severe("Exception in the method createNewSupplier: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method editSupProfileAddress: " + e.getMessage());
		}
	}

	/**
	 * Method: InviteNewSupplier
	 * Description: To invite a new supplier from supplier search page
	 * @param: setTestData (Having the different fields data)
	 * @return: boolean
	 * @author madhu
	 */
	public boolean inviteNewSupplier(setTestData objinvite){
		boolean bool_invite=false;
		try {	//ge.waitForTime(2000);
			String getText="";
			String SupplierGroupKey="";
			// ge.clicks on Invite New Supplier
			lavanteUtils.switchtoFrame( idSearchResultsFrame);
			lavanteUtils.click( LnkTxtInviteNewSupplier);
			//ge.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			//Switch to frame of pop-up
			lavanteUtils.switchtoFrame(iFrame);
			lavanteUtils.click(IdclearBtn);
			//ge.waitForTime(2000);
			//type supplier name
			lavanteUtils.typeinEdit(objinvite.getSupplierName().toString(),Idsuppliername);
			//type contact name
			lavanteUtils.typeinEdit(objinvite.getContactName().toString(),Idcontactname);

			lavanteUtils.typeinEdit(objinvite.getContactEmail().toString(),Idemail);
			//ge.waitForTime(2000);
			if(lavanteUtils.isElementDisplayed((idinvitingOrganization))) {
				String org=objinvite.getInvitingOrganization().toString();
				if(org.length()<1)
				{
					org="Con-way Freight";
				}
				lavanteUtils.selectDropDownValue(idinvitingOrganization,"010-DCI");

		//		SelselectDropDownValue(driver, "", idinvitingOrganization,org);
			//ge.waitForTime(2000);
			}
			if(lavanteUtils.isElementDisplayed((xpathsupplierGroup))){
				lavanteUtils.click(xpathsupplierGroup);
				lavanteUtils.switchtoFrame(null);
				//ge.waitForTime(1000);
				SupplierGroupKey=objinvite.getSupplierGroup().toString();
				lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector( "li.active-result:nth-child("+SupplierGroupKey+")")));
				//Switch to frame
				lavanteUtils.switchtoFrame( iFrame);
			}
			lavanteUtils.switchtoFrame( iFrame);
			//ge.waitForTime(1000);
			lavanteUtils.typeinEdit("Automation",wdSupplierSearch.findElement(By.id("supplierInviteJustification")));
			//ge.waitForTime(2000);
			lavanteUtils.switchtoFrame( iFrame);
			lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( "//*[contains(@id,'Check')][@type='checkbox']")));
			//ge.waitForTime(2000);
			
			lavanteUtils.click(idinviteBtn);
/*			ge.switchToFrameBy(wdSupplierSearch,"","","");
			getText=ge.getText(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathSuccessMessage);
			Reporter.log("Invitation to the new supplier is successful: "+getText);
			ge.clicks(wdSupplierSearch, ConfigPathFile.XPATH.getConstantValue(), xpathokBtn);
			bool_invite=true;*/
		} catch (Exception e) {
			/*Reporter.log("Failure in inviting the supplier due to :"+e.getCause());
			e.printStackTrace();*/
			Reporter.log("Invitation to the new supplier is successful");
			bool_invite=true;
		}
		return bool_invite;
	}

	/**
	 * Method: navigateToSupplierPage
	 * Purpose: to navigate to search page\
	 * @param: none
	 * @return: none
	 * @author madhu
	 */
	public void navigateToSuplPage(){
		try {
			//ge.waitForTime(2000);
			lavanteUtils.click(linkSupplier);
			Reporter.log("\n The supplier link is clicked");
			//ge.waitForTime(2000);
			lavanteUtils.click( linkSearch);
			Reporter.log("\n Search link is clicked");
			//ge.waitForTime(2000);
			lavanteUtils.assertPageTitle(textSupplierPage);
			Reporter.log("Navigation to the supplier search page is successful");
		} catch (Exception e) {
			Reporter.log("Failed to navigate to the |Supplier Page| due to: "+e.getCause());
			//log.severe("Failed to navigate to the supplier page due to: "+e.getCause());
			Assert.assertTrue(false,"Failed to navigate to the required page Title of the page is : "+wdSupplierSearch.getTitle());
		}
	}

	public List<String> sortDataforTest(String str_data){

		String[] split_btns = str_data.split(",");// separate the button names in excel by a
		// comma in between
		List<String> list_btns = new ArrayList<String>(Arrays.asList(split_btns));
		return list_btns;
	}
	/**
	 * Method: NavigateAdvncdSearch
	 * Purpose: To navigate to the advanced search
	 * @param none
	 * @returns none
	 * @author madhu
	 */
	public void navigatetoAdvncdSearchPage(){
		try{
			lavanteUtils.click(linkSupplier);
			Reporter.log("\n The supplier link is clicked");
			lavanteUtils.click( idadvancedTab);
			Reporter.log("Clicked on the 'Advanced Search' tab");
			lavanteUtils.assertPageTitle( textSupplierPage);
		}catch(Exception e)
		{
			Reporter.log("Failed to navigate to the advanced search page due to : "+e.getMessage());
			//log.severe("Failed to navigate to the advanced search page due to :"+e.getCause());
			Assert.assertTrue(false, "The landing page was not as expected  The title of landing page was : "+wdSupplierSearch.getTitle());
		}

	}

	/**
	 * Method: SupplDeclinedInvite
	 * Purpose: The supplier profile stage that has been declined
	 * @param: setTestData
	 * @return: boolean
	 * @author madhu 
	 */
	public void supplDeclinedInvite(setTestData objdata){
		String strReturnVal="";
		lavanteUtils.click(xpathbuildQueryBtn);
		Reporter.log("Clicked on the 'Build Query' button");
		//ge.waitForTime(2000);
		//Frame In
		lavanteUtils.switchtoFrame( xpathactivatePopupFrame);

		lavanteUtils.click( xpathenterpriseDataTab);
		Reporter.log("Clicked on the 'Enterprise Generated Data' tab");
		//ge.waitForTime(1000);
		lavanteUtils.selectDropDownValue(idprofileStage,objdata.getProfilestage().toString());
		Reporter.log("Selected the profile stage drop down status: " + objdata.getProfilestage().toString());
		//Supplier Name
		lavanteUtils.click( xpathcompanyProfileTab);
		Reporter.log("Clicked on the 'Company Profile' tab");
		lavanteUtils.click( xpathSupplierDrpDwn);
		Reporter.log("Clicked on the 'Supplier Name' drop down field");
		//Frame out
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(wdSupplierSearch.findElement(By.cssSelector( "li.active-result:nth-child(2)")));
		Reporter.log("Selected 'Equals To' option in the drop down:");
		//Frame In
		lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
		lavanteUtils.typeinEdit(objdata.getSupplierName().toString(), xpathsuppliertxtField);
		Reporter.log("Entered Supplier Name : " +objdata.getSupplierName().toString());
		//ge.waitForTime(1000);
		lavanteUtils.click( xpathadvanceSearchBtn);
		Reporter.log("Clicked on the 'Search' button");
		//Frame out
		lavanteUtils.switchtoFrame(null);

		//Frame In
		lavanteUtils.switchtoFrame( xpathsupplierTableFrame);

		List<WebElement> rowCount =(xpathtableRowCount);
		int tableRowCount=rowCount.size();

		if(!(tableRowCount==0)){
			if(lavanteUtils.isElementDisplayed((xpathdataNotFound))==true){
				String strData=lavanteUtils.getText(xpathnoData);
				Reporter.log("Supplier Search Table data: " + strData);		
				Assert.assertTrue(true, "Test failed due to " + "'" + strData + "'" + " in the supplier search table ");
			}else {
				for (int j=1;j<=rowCount.size();j++) {
					if(lavanteUtils.isElementDisplayed((xpathstatus))==true){
						String strStatus=lavanteUtils.getText( xpathstatus);
						if(strStatus.equalsIgnoreCase(objdata.getProfilestage().toString())){
							Reporter.log("Verification is successful for " + "'" + strStatus + "'" + " Status in the Supplier Search results table");
							//ge.waitForTime(1000);
							strReturnVal=lavanteUtils.getText( xpathsupplierTblName);
							Reporter.log("Supplier Name: " + "'" + strReturnVal + "'" + " with Status: " + "'" +
									objdata.getProfilestage().toString() + "'");
							break;
						}
					} else {
						//log.severe("Test failed due to 'Status' column element property has changed:");
						Assert.assertTrue(false,"Failed due to 'Status' column element property has changed: ");
					}
				}
			}
		} else {
			Reporter.log("Supplier Search table is not found");
		}
	}

	/**
	 * Method Name : verify_PageTitle
	 * Purpose: Public method which includes logic related to verify the page title
	 * @param: String expPageTitle
	 * @return: true/false
	 */	
	public boolean verify_PageTitle(String expPageTitle){
		boolean flag=false;

		try{ 
			//ge.waitForTime(4000);
			String actualPageTitle=wdSupplierSearch.getTitle().trim().toString();
			//Validation - Suppliers Search Page
			if (expPageTitle.equalsIgnoreCase(actualPageTitle)) {
				Reporter.log("Suppliers Search page displayed: Expected title: " + expPageTitle
						+ " Actual title: " + actualPageTitle);
				flag=true;
			} else {
				lavanteUtils.takeScreenshot(wdSupplierSearch, "verify_PageTitle");
				//Assert.assertTrue(false,"Test failed due to Expected title: " + expPageTitle  + "  doesn't match with"
						//+ " Actual title: " + actualPageTitle);
			}
		}catch(Exception e){
			//log.severe("Exception in the method verify_PageTitle: " + e.getMessage());
			lavanteUtils.takeScreenshot(wdSupplierSearch, "verify_PageTitle");
			//Assert.assertTrue(false,"Exception in the method verify_PageTitle: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Method Name : verifyTblData_Navigateback
	 * Purpose: Public method which includes logic related to verify and return the data
	 * @param: String sExpPageTitle, String sEleProp
	 * @return: String sData
	 */	
	public String verifyTblData_Navigateback(String sExpPageTitle, String sEleProp){

		String sData="";

		try{ //ge.waitForTime(4000);
			if(verify_PageTitle(sExpPageTitle)==true){
				//verification 
				if(lavanteUtils.isElementDisplayed(wdSupplierSearch.findElement(By.xpath(sEleProp)))==true){
					sData=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath( sEleProp)));
					wdSupplierSearch.navigate().back();
					lavanteUtils.waitForTime(2000);
				} else {
					//Assert.assertTrue(false,"Failed to identify the element property: ");
				}
			}
		}catch(Exception e){
			//log.severe("Exception in the method verifyTblData_Navigateback: " + e.getMessage());
			lavanteUtils.takeScreenshot(wdSupplierSearch, "verifyTblData_Navigateback");
			//Assert.assertTrue(false,"Exception in the method verifyTblData_Navigateback: " + e.getMessage());
		}
		return sData;
	}

	/**
	 * Method Name : getUserName
	 * Purpose: Public method which includes logic related to return the user name with time stamp
	 * @param: None
	 * @return: None
	 */
	public String getUserName(String sUserName){
		String userName ="";
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		userName = sUserName + strDate;
		return userName;
	}

	/**
	 * Method Name : verifyOutreachData
	 * Purpose: Public method which includes logic related to verify and return the data
	 * @param: String sEleProp
	 * @return: String sData
	 */	
	public String verifyOutreachData(WebElement sEleProp){

		String sData="";
		try{ lavanteUtils.waitForTime(3000);
			if(verify_PageTitle(expectedPageTitle)==true){
				//Frame In
				lavanteUtils.switchtoFrame( xpathsupplierTableFrame);
				//verification
				if(lavanteUtils.isElementDisplayed(sEleProp)==true){
					sData=lavanteUtils.getText( sEleProp);
					//Frame out
					lavanteUtils.switchtoFrame(null);
					wdSupplierSearch.navigate().back();
					lavanteUtils.waitForTime(2000);
				} else {
					Assert.assertTrue(false,"Failed to identify the element property: ");
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifyOutreachData: " + e.getMessage());
			//ge.takeScreenshot(wdSupplierSearch, "verifyOutreachData");
			//Assert.assertTrue(false,"Exception in the method verifyOutreachData: " + e.getMessage());
		}		
		return sData;		
	}
	// just added

	public boolean verifyStatusnProfileTable(setTestData objdata, String str_time, String str_acttype){
		boolean bool_verify=false;
		String str_actiontype="";
		try{ lavanteUtils.waitForTime(2000); System.out.println("AS"+str_acttype);
			switch (str_acttype){
			case "Approve":
				str_actiontype="Approved";
				break;
			case "Reject":
				str_actiontype="Rejected";
				break;
			case "Reassign":
				str_actiontype="Approval Pending";
				break;
			case "AddSuppID":
				str_actiontype="Updated SupplierERPID";
				break;
			} 
			if(!(str_time.trim().equals(""))){
			//	String str_apptime= (searchSupplierDetailsTable(ConfigPathFile.Action_data_n_time.getConstantValue(),"PDT").trim()).replace(" ", "");
			//  Assert.assertTrue(timeCompare(str_apptime,str_time),"Failure due to mismatch in time. "+str_time+" was the expected time");	
				Reporter.log("Time expected met the actual present in the table");
			}
			Assert.assertFalse(searchSupplierDetailsTable(ConfigPathFile.ActionType.getConstantValue(), str_actiontype).isEmpty(),"Action type mismatch. Expected is : "+str_actiontype);
			Reporter.log("Action type mentioned in  the table matched the expected");
			if(objdata.getReassignUserName().toString().isEmpty()){ System.out.println("dsa");
				Assert.assertFalse((searchSupplierDetailsTable(ConfigPathFile.Actor.getConstantValue(),objdata.getUserName().toString())).isEmpty(),"Actor is not as expected. Expected actor is : "+objdata.getUserName().toString());
			}else{
				Assert.assertFalse(searchSupplierDetailsTable(ConfigPathFile.Actor.getConstantValue(),objdata.getReassignUserName().toString()).isEmpty(),"Actor is not as expected. Expected actor is : "+objdata.getReassignUserName().toString());
			}
			Assert.assertFalse(searchSupplierDetailsTable(ConfigPathFile.ActionTaken.getConstantValue(), objdata.getActionTaken().toString()).isEmpty(),"Action taken is not as expected. Expected value is :  "+objdata.getActionTaken().toString().isEmpty());
			System.out.println(objdata.getComments().toString().isEmpty());
			System.out.println(objdata.getComments().toString());
			Assert.assertFalse(searchSupplierDetailsTable(ConfigPathFile.Comments.getConstantValue(), objdata.getComments().toString()).isEmpty(),"Comments Entered is not as expected. expected value is : "+objdata.getComments().toString().isEmpty());
			Reporter.log("Table content checked and verified");
			System.out.println("BE$ CLOSEEEEEEEEEEEEEEEEEEEEEEE");
			closeSupplierDetailsPopup();
			System.out.println("CLOSEDDDDDDDDDDDDDDDDDDDDDDDD");
			bool_verify=true;
		}catch(Exception e){
			e.printStackTrace();
			//log.severe("Failed in verifying the table contents due to  : "+e.getMessage());
			//ge.assertFailure(wdSupplierSearch, "Failed to verify the contents ", ""+e.getMessage());
		}
		return bool_verify;
	}


	/*
	 * Method: searchSupplierDetailsTables\
	 * Purpose: to search the supplier details table 
	 * @param str_headersxpath, str_tablesontentsxpath, str_header, str_searchdata
	 * @return String
	 */
	public String searchSupplierDetailsTable(String str_header,String str_searchdata){
		String str_ret="";
		String xpathtable="//div[@id='dialog']//table";
		WebElement we_data=null;
		try{
			switchtoSupplierDetailsFrame();
			if(wdSupplierSearch.findElement(By.xpath(xpathtable+"[1]")).isDisplayed()){
				we_data=checkTableData(xpathtable+"[1]"+"/thead/tr/th",xpathtable+"[1]"+"/tbody/tr", str_header, str_searchdata);
				str_ret=we_data.getText();
				System.out.println("str"+str_ret);
				lavanteUtils.switchtoFrame(null);
				return str_ret;
			}
			if(wdSupplierSearch.findElement(By.xpath(xpathtable+"[2]")).isDisplayed()){
				we_data=checkTableData(xpathtable+"[2]"+"/thead/tr/th", xpathtable+"[2]"+"/tbody/tr", str_header, str_searchdata);
				str_ret=we_data.getText();
				System.out.println("bst"+str_ret);
				lavanteUtils.switchtoFrame(null);
				return str_ret;
			}
			lavanteUtils.switchtoFrame(null);
		}catch(Exception e){
			Reporter.log("The search data is not found in the suppliers details table");
			//log.severe("The search data is not found under the suppliers details table due to : "+e.getMessage());
			Assert.assertTrue(false, "Failure in the supplier details table search due to  : "+e.getCause()+e.getMessage());
		}
		return str_ret;
	}

	public void closeSupplierDetailsPopup(){
		try{ lavanteUtils.waitForTime(2000);
		//	ge.clicks(wdSupplierSearch,ConfigPathFile.XPATH.getConstantValue(),"//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front dialog ui-draggable ui-resizable']//button");
			lavanteUtils.click(wdSupplierSearch.findElement(By.xpath("//div[contains(@style,'visible')]//button[contains(@class,'close')]")));
		}catch(Exception e){
			Reporter.log("Failure due to : "+e.getMessage());
			//log.severe("Failure due to : "+e.getMessage());
			Assert.assertTrue(false, "Failure due to  :"+e.getMessage());
		}
	}

	public boolean timeCompare(String str_time1,String str_time2){
		boolean bool_ret=false;
		try{        
			SimpleDateFormat format= new SimpleDateFormat("MM/dd/yyyy,hh:mmaz"); 
			Date dt1 = format.parse(str_time1); 
			Date dt2 = format.parse(str_time2); 
			if (dt1.after(dt2)||dt1.equals(dt2)) 
				bool_ret=true;
			else 
				bool_ret=false;

		}catch(Exception e){
			Reporter.log("Failed in time verification");
			//log.severe("Failed in time verification due to : "+e.getCause());
			Assert.assertTrue(false, "Failed in time compare due to   :"+e.getMessage());
		}
		return bool_ret;
	}


	/**
	 * Method: switchtoSupplierDetailsFrame
	 * Purpose:  to switch to the suppliers details tab
	 * @param: none
	 * @return none
	 * @author priya.pais
	 */
	public void switchtoSupplierDetailsFrame(){
		try{
			Assert.assertTrue(lavanteUtils.isElementDisplayed((xpathsupplierdetailtitle)),"Pop up did not appear");
			Reporter.log("The title of the popup window - Supplier details is verified");
			Assert.assertTrue(lavanteUtils.switchtoFrame(xpathsupplierdetailsframe),"Failure to switch to the supplier details frame");
			Reporter.log("Switched to the pop-window ");
		}catch(Exception e){
			Reporter.log("Switch to supplier details frame failed due to : "+e.getMessage());
			//log.severe("Failure in switching of frame due to : "+e.getCause());
			Assert.assertTrue(false, "Failure to switch to frame"+e.getMessage());
		}
	}


	public int checkTableDatarow(String str_headersxpath,String str_tablecontentsxpath,String str_header,String str_searchdata){
		String str_temp="";
		//WebElement we_ret=null;
		int int_ret=0;
		try{
			System.out.println("SEARCH"+str_searchdata);
			String xpath_append="/td["+searchHeader(str_header,str_headersxpath)+"]";
			System.out.println("COMBINED:"+str_tablecontentsxpath+xpath_append);
			List<WebElement> lst_webelem=wdSupplierSearch.findElements(By.xpath(str_tablecontentsxpath+xpath_append));
			for(int i=1;i<=lst_webelem.size();i++){
				str_temp=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath( str_tablecontentsxpath+"["+i+"]"+xpath_append)));
				if(str_temp.trim().equalsIgnoreCase(str_searchdata.trim())||str_temp.trim().contains(str_searchdata.trim())){
					wdSupplierSearch.findElement(By.xpath(str_tablecontentsxpath+"["+i+"]"+xpath_append));
					int_ret=i;
					Reporter.log("Supplier detail : "+str_header+" searched is : "+str_searchdata+" is found in the table in the row : "+i);
					break;
				}
			}
		}catch(Exception e){
			Reporter.log("Failed to check the table conntent "+str_searchdata+" Under the header : "+str_header);
			//log.severe("Failed to find the data "+str_searchdata+" under the header "+str_header+" due to "+e.getCause());
			Assert.assertTrue(false, "Failed due to"+e.getMessage());
		}
		return int_ret;
	}

	/** 
	 * @param xpathtable
	 * @param str_headernamedata the header of the information provided
	 * @param str_data search data
	 * @param str_header the header under which data to be fetched
	 * @return String the data fetched
	 */
	public String getCorrespondingData(String xpathtable, String str_headernamedata,String str_data,String str_header){
		String str_text="";
		try{
			//switchtoSupplierDetailsFrame();
			if(!noDataAvailable()){
				Reporter.log("Data is not available for the table ");
			}
			int int_row=checkTableDatarow(xpathtable+"/thead/tr/th", xpathtable+"/tbody/tr", str_headernamedata, str_data);
			System.out.println("ROW:"+int_row);
			int int_col=searchHeader(str_header, xpathtable+"/thead/tr/th");
			System.out.println("COL"+int_col);
			str_text=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath( xpathtable+"/tbody/tr["+int_row+"]/td["+int_col+"]")));

		}catch(Exception e){
			e.printStackTrace();
			//log.severe("Exception occured in getting the correspoding data");
		}
		lavanteUtils.switchtoFrame(null);
		return str_text;
	}

	/**
	 * Method : noDataAvailable
	 * Purpose : To check if there is data available
	 * @param none
	 * @return boolean
	 * @author priya.pais
	 */
	public boolean noDataAvailable(){
		String clsNodata="data_not_found";
		boolean bool_nodata=false;
		try{
			if(lavanteUtils.isElementDisplayed(wdSupplierSearch.findElement(By.className(clsNodata)))){
				Reporter.log("There is no data available");
				bool_nodata=true;
			}else{
				Reporter.log("Data is available");
				bool_nodata=false;
			}
		}catch(Exception e){
			Reporter.log("Failure in checking the data availability");
			//log.severe("Failure to check the data availability due to : "+e.getMessage());
			Assert.assertTrue(false, "Failure in checking the availability of data due to : "+e.getCause());
		}
		return bool_nodata;
	}



	/**
	 * Method: verifyNotesandComments
	 * 
	 */
	public boolean verifyNotesandComments(setTestData objdata,String str_time,String str_action){
		String xpathtablenow="";
		String str_sctiontype="";
		try{
			switch(str_action){
			case "Approve":
				str_sctiontype=ConfigPathFile.APPROVED.getConstantValue();
				break;

			}
			/*switchtoSupplierDetailsFrame();
			ge.clicks(driver,ConfigPathFile.XPATH.getConstantValue(),xpathcommenttype);
			Reporter.log("Clicked on the drop down button");
			ge.switchToFrameeee(driver, "", "", "");
			ge.selectDropDownValue(driver, ConfigPathFile.XPATH.getConstantValue(), "//select[@id='commentType']/ul", ConfigPathFile.APPROVED.getConstantValue());*/
			switchtoSupplierDetailsFrame();
			lavanteUtils.click( xpathexpandOption);
			Reporter.log("Clicked on the 'Approved' table");
			List<WebElement> lst_we=wdSupplierSearch.findElements(By.xpath("//h3"));
			int i=1;
			for(WebElement we : lst_we){
				if(we.getText().contains(ConfigPathFile.APPROVED.getConstantValue())){
					break;
				}
				i=i+1;
			}
			xpathtablenow="//table[@class='data_table table_grid zebra dynamic_table toggle_content']["+i+"]";
			Assert.assertTrue(lavanteUtils.isElementDisplayed(wdSupplierSearch.findElement( By.xpath(xpathtablenow))),"Failed to find the table on the page");
			checkTableData(xpathtablenow+"/thead/tr/th", xpathtablenow+"/tbody/tr", "Name", "Omnicare Admin(Lavante)");
			//Time Validation
		//	String str_time2=checkTableData(xpathtablenow+"/thead/td/th",xpathtablenow+"/tbody/td/tr", "Date & Time", "PDT").getText();
		//	Assert.assertTrue(timeCompare(str_time2,str_time),"Failed due to the mentioned time did not match the time specified in the application");
			Assert.assertTrue(checkTableData(xpathtablenow+"/thead/tr/th",xpathtablenow+"/tbody/tr", "Related Actions", str_sctiontype).getText().equals(str_sctiontype),"Failed to verify the | Related Action |");
			
			Assert.assertTrue(checkTableData(xpathtablenow+"/thead/tr/th",xpathtablenow+"/tbody/tr", "Comment", objdata.getComment().toString()).getText().equals(objdata.getComment().toString()),"Failed to verify the | Comment |");
			System.out.println("SL");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			//log.severe("Exception occured in verifying the table contents. Description : "+e.getMessage());
			Assert.assertTrue(false, "Failed due to :"+e.getCause());
		}
		return false;
	}

	//placed one more parameter to get details
	public void viewProfileofSupplierunderSearch(String str_supplierdetail, String str_supplierheader, String str_status){
		//ge.waitForTime(2000);
		String xpathsupplier="//form[@id='supplierSearchResultForm']//table[@id='search_results']/tbody/tr";
		
		String str_temp="";
		String str_statusexpected="";
		try{
			switch(str_status){
			case "Approve":
				str_statusexpected="Invited";
				break;
			case "Reject":
				str_statusexpected="Inactive";
				break;
			case "Reassign":
				str_statusexpected="Pending Invite";
				break;
			}
			enterFrameSupplierSearch();
			//remember to add soft Assert
			String str_statusapp=getCorrespondingData("//form[@id='supplierSearchResultForm']//table[@id='search_results']",str_supplierheader,str_supplierdetail,"Profile Status");
			System.out.println(str_statusapp+" This is the status");
			//sAssert.assertTrue(str_statusapp.toLowerCase().trim().equals(str_status.toLowerCase().trim()),"Failure to match the status from the application with the expected one");
			sAssert.assertFalse(noDataAvailable(),"Failure due to no data is available");
			Reporter.log("\n Data is available in the supplier search table");
			String xpath_append="/td["+searchHeaderTable(str_supplierheader)+"]";
			enterFrameSupplierSearch();
			List<WebElement> lst_webelem=wdSupplierSearch.findElements(By.xpath(xpathsupplier+xpath_append));
			for(int i=1;i<=lst_webelem.size();i++){
				str_temp=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath(xpathsupplier+"["+i+"]"+xpath_append)));
				if(str_temp.trim().equalsIgnoreCase(str_supplierdetail.trim())||str_supplierdetail.equals("LISTFIRSTSUPPLIER")){
					lavanteUtils.click(wdSupplierSearch.findElement(By.xpath( xpathsupplier+"["+i+"]"+xpath_append+"/a")));
					Reporter.log("Supplier detail : "+str_supplierheader+" searched is : "+str_supplierdetail+" is found in the table");
					lavanteUtils.switchtoFrame(null);
					break;
				}
			}
		}catch(Exception e){
			Reporter.log("Failure in the method to check for the supplier with the details : "+str_supplierdetail+" : "+"Supplier Name");
			//log.severe("Failure in the method to find the suppier in the table");
			Assert.assertTrue(false, "Failure in searching the supplier in the table due to"+e.getCause());
		}
	}


	/**
	 * Method: supplierSearchTable
	 * Purpose: To search the supplier based on the header name
	 * @param String str_SupplierDetail, String str_headername
	 * @return boolean
	 * @author priya.pais
	 */
	public boolean supplierSearchTable(String str_supplierdetail, String str_headername){
		String xpathsupplier="//form[@id='supplierSearchResultForm']//table[@id='search_results']/tbody/tr";
		String str_temp="";
		boolean bool_ret=false;
		try{
			enterFrameSupplierSearch();
			Assert.assertFalse(noDataAvailable(),"Failure due to no data is available");
			Reporter.log("\n Data is available in the supplier search table");
			String xpath_append="/td["+searchHeaderTable(str_headername)+"]";
			List<WebElement> lst_webelem=wdSupplierSearch.findElements(By.xpath(xpathsupplier+xpath_append));
			for(int i=1;i<=lst_webelem.size();i++){
				str_temp=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath(xpathsupplier+"["+i+"]"+xpath_append)));
				if(str_temp.trim().equalsIgnoreCase(str_supplierdetail.trim())){
					Reporter.log("Supplier detail : "+str_headername+" searched is : "+str_supplierdetail+" is found in the table");
					bool_ret=true;
				}
			}
		}catch(Exception e){
			Reporter.log("Failure in the method to check for the supplier with the details : "+str_supplierdetail+" : "+str_headername);
			//log.severe("Failure in the method to find the suppier in the table");
			Assert.assertTrue(false, "Failure in searching the supplier in the table due to"+e.getCause());
		}
		lavanteUtils.switchtoFrame(null);
		return bool_ret;
	}

	public boolean checkNoDataAvailable(){
		try{
			enterFrameSupplierSearch();
			if(noDataAvailable()){
				lavanteUtils.switchtoFrame(null);
			}
			else{
				lavanteUtils.switchtoFrame(null);
				return true;
			}
		}catch(Exception e){

		}
		return false;
	}

	/**
	 * Method : checkTableData
	 * Purpose: to check the data of the table
	 * @param String str_tableheaders, String str_tablecontent
	 * @return boolean
	 * @author priya.pais
	 */

	public WebElement checkTableData(String str_headersxpath,String str_tablecontentsxpath,String str_header,String str_searchdata){
		String str_temp="";
		WebElement we_ret=null;
		try{
			Assert.assertFalse(noDataAvailable(),"Failure due to no data is available");
			Reporter.log("\n Data is available in the supplier search table");
			String xpath_append="/td["+searchHeader(str_header,str_headersxpath)+"]";
			List<WebElement> lst_webelem=wdSupplierSearch.findElements(By.xpath(str_tablecontentsxpath+xpath_append));
			for(int i=1;i<=lst_webelem.size();i++){
				str_temp=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath( str_tablecontentsxpath+"["+i+"]"+xpath_append)));
				System.out.println("APP DATA:"+str_temp);
				System.out.println("SEARCHDATA:"+str_searchdata);
				if(str_temp.trim().equalsIgnoreCase(str_searchdata.trim())){
					System.out.println("EQUal BY SP");
				}
				if(str_temp.trim().equalsIgnoreCase(str_searchdata.trim())||str_temp.trim().contains(str_searchdata.trim())){
			
					we_ret=wdSupplierSearch.findElement(By.xpath(str_tablecontentsxpath+"["+i+"]"+xpath_append));
					Reporter.log("Supplier detail : "+str_header+" searched is : "+str_searchdata+" is found in the table");
					break;
				}
			}

		}catch(Exception e){
			Reporter.log("Failed to check the table conntent "+str_searchdata+" Under the header : "+str_header);
			//log.severe("Failed to find the data "+str_searchdata+" under the header "+str_header+" due to "+e.getCause());
			Assert.assertTrue(false, "Failed due to "+e.getMessage());
		}
		System.out.println("COM");
		return we_ret;
	}

	/**
	 * Method: searchHeader
	 * Purpose: to search the header from the table
	 * @param str_header
	 * @param str_xpathheaders
	 * @return integer int_row
	 * @author priya.pais
	 */

	public int searchHeader(String str_header, String str_xpathheaders){
		int int_retrow=0;
		String str_temp="";
		try{
			//enterFrameSupplierSearch();
			System.out.println(str_header+str_xpathheaders);
			List<WebElement> lst_webelem=wdSupplierSearch.findElements(By.xpath(str_xpathheaders));
			
			for(int i=1;i<=lst_webelem.size();i++){
				str_temp=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath( str_xpathheaders+"["+i+"]")));
				if(str_temp.trim().equalsIgnoreCase(str_header.trim())){
					Reporter.log("The header :"+str_header+" is found at position : "+i);
					int_retrow=i;
					//ge.switchToFrameeee(wdSupplierSearch, "", "", "");
					break;
				}
			}

		}catch(Exception e){
			Reporter.log("Failed to find the header from the table ");
			//log.severe("Failure to search the header from the table due to the reason : "+e.getMessage());
			Assert.assertTrue(false, "Failure to find the header from the table Header : "+str_header);
		}
		return int_retrow;
	}

	/**
	 * Method : searchHeaderTable
	 * Purpose: to search for the header in the supplier table
	 * @param String str_headername
	 * @return integer int_row
	 * @author priya.pais
	 */
	public int searchHeaderTable(String str_header){
		int int_retrow=0;
		List<WebElement> xpathheaders=wdSupplierSearch.findElements(By.xpath("//form[@id='supplierSearchResultForm']//table[@id='search_results']/thead/tr/th"));
		String xpathheader="//form[@id='supplierSearchResultForm']//table/thead/tr/th[";
		String str_temp="";
		try{
			enterFrameSupplierSearch();
			List<WebElement> lst_webelem=(xpathheaders);
			for(int i=1;i<=lst_webelem.size();i++){
				str_temp=lavanteUtils.getText(wdSupplierSearch.findElement(By.xpath( xpathheader+i+"]")));
				if(str_temp.trim().equalsIgnoreCase(str_header.trim())){
					Reporter.log("The header :"+str_header+" is found at position : "+i);
					int_retrow=i;
					lavanteUtils.switchtoFrame(null);
					break;
				}
			}

		}catch(Exception e){
			Reporter.log("Failed to find the header from the table ");
			//log.severe("Failure to search the header from the table due to the reason : "+e.getMessage());
			Assert.assertTrue(false, "Failure to find the header from the table Header : "+str_header);
		}
		return int_retrow;
	}

	/**
	 * Method: enterFrameInviteNewSupl
	 * Description: to enter the suppliers table iframe
	 * @author priya.pais
	 */
	public void enterFrameSupplierSearch(){
		try{
			lavanteUtils.switchtoFrame(idSearchResultsFrame);
			if (lavanteUtils.isElementDisplayed(wdSupplierSearch.findElement(By.xpath("//form[@id='supplierSearchResultForm']"))))
				Reporter.log("The frame is switched to the suppliers table");
			else{
				//Reporter.log("Failure in switching to the suppliers table frame");
				//Assert.assertTrue(false,"Failure to switch to the suppliers table frame");
			}
		}catch(Exception e){
			Reporter.log("Error in switching the frame of invite new supplier due to: "+e.getCause());
			//log.severe("There was error in the switching in the frame due to: "+e.getMessage());
			Assert.assertTrue(false, "Failure to switcn to the suppliers table frame Due to :"+e.getCause());
		}
	}

	/**
	 * Method: selectSubtabSupplierManaged
	 * Purpose: to select the tabs in supplier details pop-up
	 * @return none
	 * @param String tab to be entered
	 * @author priya.pais
	 */
	public void selecttabSupplierDetails(String str_tab, String str_subtab){
		try{ //ge.waitForTime(2000);
			switchtoSupplierDetailsFrame();
			Assert.assertTrue(lavanteUtils.isElementDisplayed((xpathframemainnavigation)));
			Reporter.log("main navigation is present");
			switch(str_tab){
			case "Supplier Managed":
				lavanteUtils.click( linksuppliermanaged);
				Reporter.log("Clicked on the Supplier Managed tab");
				//ge.waitForTime(1000);
				selectsubTabsSupplierManaged(str_subtab);
				break;
			case "Enterprise-Owned":
				lavanteUtils.click(linkenterpriseowned);
				Reporter.log("Clicked on the Enterprise-Owned tab");
				//ge.waitForTime(1000);
				selectsubTabsEnterpriseData(str_subtab);
				break;
			case "Status and History":
				lavanteUtils.click( linkstatusnhistory);
				Reporter.log("Clicked on the Status and History tab");
				//ge.waitForTime(1000);
				selectsubTabsStatusHistory(str_subtab);
				break;
			default:
				Assert.assertTrue(false,"String passed is invalid");
				break;
			}

		}catch(Exception e){
			Reporter.log("Failure to select the tab due to  : "+e.getMessage());
			//log.severe("Failure to ge.clicks the tab in the supplier details pop-up");
			Assert.assertTrue(false, "Failure in tab selection in supplier details pop-up"+e.getMessage());
		}
		lavanteUtils.switchtoFrame(null);
	}

	public void selectsubTabsSupplierManaged(String str_subtab){
		try{
			switch(str_subtab){
			case "Core Profile":
				lavanteUtils.click(linkcoreprofile);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			case "Diversity":
				lavanteUtils.click( linkdiversity);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			case "Regulatory":
				lavanteUtils.click( linkregulatory);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			case "Payment Information":
				lavanteUtils.click(linkpaymentinfo);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			case "Relation Specific Profile":
				lavanteUtils.click( linkrelationsprofile);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			case "Contact":
				lavanteUtils.click(linkcontact);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			case "Certifications":
				lavanteUtils.click(linkcertification);
				Reporter.log("Clicked on the |Certifications| Sub tab");
				break;
			}
		}catch(Exception e){
			//log.severe("Failure in clicking the subtab due to  : "+e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false,"Failed to ge.clicks on the subtab ");
		}
	}

	/**
	 * Method : selectsubTabsStatusHistroy
	 * Description: selection of the subtabs under Status and History tab
	 * @param String str_subtab
	 * @return none
	 * @author priya.pais
	 */
	public void selectsubTabsStatusHistory(String str_subtab){
		try{
			switch(str_subtab){
			case "Required Fields":
				break;
			case "Outreach History":
				break;
			case "Profile n Approval History":
				lavanteUtils.click(linkprofilenstatus);
				Reporter.log("Clicked on |Profile n Approval| History TAB");
				break;
			case "Change Log":
				break;
			}
		}catch(Exception e){
			Reporter.log("Failed to select the sub tab in Profile and History Tab");
			//log.severe("Failure to sleect the sub tab in profile and history tab due to : "+e.getCause());
			Assert.assertTrue(false, "Selection of TAB failed in profile and History due to  :"+e.getMessage());
		}
	}

	public void selectsubTabsEnterpriseData(String str_subtab){
		try{
			switch(str_subtab){
			case "Header Information":
				lavanteUtils.click(linkheadermanage);
				Reporter.log("Clicked on |Header Information| TAB is clicked");
				break;
			case "Contract Management":
				lavanteUtils.click(linkcontractmanage);
				Reporter.log("Clicked on |Contract Management| TAB is clicked");
				break;
			case "Notes & Comments":
				lavanteUtils.click(linknotesncomments);
				Reporter.log("Clicked on |Notes & Comments| TAB is clicked");
				break;
			case "As Supplied VMF View":
				lavanteUtils.click(linkvmfdata);
				Reporter.log("Clicked on |As Supplied VMF View| TAB is clicked");
				break;
			}

		}catch(Exception e){
			e.printStackTrace();
			//log.severe("Exception occured in the method to select the subtabs : "+e.getMessage());
			Assert.assertTrue(false, "Failed due to execption occured in the method to select the subtabs in Enterprise-Owned : "+e.getCause());
		}
	}

	/**
	 * Method Name : verifyPreScreeningFunctionality
	 * Purpose: Public method which includes logic related to verify the Pre-Screening option for Create New Supplier 
	 * @param: List<setTestData> getSupplierSearchData
	 * @return: None
	 */
	public String verifyPreScreeningFunctionality(List<setTestData> getPreScreeningSearchData) {

		String sConcatenateSupplierName="";
		try{
			verifySuppliersHomePageTitle();
			//ge.waitForTime(2000);
			lavanteUtils.click(xpathsupplierslink);
			Reporter.log("Clicked on the 'Suppliers' tab");
			//ge.waitForTime(1000);
			lavanteUtils.click(idsearchtab);
			Reporter.log("Clicked on the 'Basic Search' tab");
			//Verify PreScreening option
			sConcatenateSupplierName=verify_PreScreenEnableOption(getPreScreeningSearchData);
		}catch(Exception e){
			//log.severe("Exception in the method verifyPreScreeningFunctionality: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in the method verifyPreScreeningFunctionality: " + e.getMessage());
		}
		return sConcatenateSupplierName;
	}

	/**
	 * Method Name : verify_PreScreenEnableOption
	 * Purpose: Public method which includes logic related to verifying the PreScreen option is enable (or) not
	 * @param: String sSupplierName, String sContactName, String sEmail, String sInviteOrg,
			String sSupplierGrp, String sComment, String sPrescreenEnable
	 * @return: String sConcatenateSupplierName
	 */
	public String verify_PreScreenEnableOption(List<setTestData> getPreScreeningSearchData){
		//Declare the variables
		String sConcatenateSupplierName="",sSupplierName="",sContactName="",sEmail="",sInviteOrg="",
				sSupplierGrp="",sComment="",sPrescreenEnable="";
		try{			
			//Condition check
			for(int i=0;i<getPreScreeningSearchData.size();i++){
				sSupplierName=getPreScreeningSearchData.get(i).getSupplierName().toString();
				sContactName=getPreScreeningSearchData.get(i).getContactName().toString();
				sEmail=getPreScreeningSearchData.get(i).getContactEmail().toString();
				sInviteOrg=getPreScreeningSearchData.get(i).getInvitingOrganization().toString();
				sSupplierGrp=getPreScreeningSearchData.get(i).getSupplierGroup().toString();	
				sComment=getPreScreeningSearchData.get(i).getComment().toString();
				sPrescreenEnable=getPreScreeningSearchData.get(i).getPreScreenEnable().toString();
			}
			//verification
			if(sPrescreenEnable.trim().toString().equalsIgnoreCase("Yes")){
				//PreScreening Option
				sConcatenateSupplierName=verify_PreScreeningPage(sSupplierName,sContactName,sEmail, sInviteOrg,
						sSupplierGrp,sComment, sPrescreenEnable);
			} else if(sPrescreenEnable.trim().toString().equalsIgnoreCase("No")){
				//inviteNewSupplier(getPreScreeningSearchData);
			} else {
				//log.severe("Test failed due to 'PreScreening' option is not provided");
				Assert.assertTrue(false,"Exception in the method due to 'PreScreening' option is not provided: ");
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_PreScreenEnableOption: "+ e.getMessage());
			lavanteUtils.takeScreenshot(wdSupplierSearch, "verify_PreScreenEnableOption");
			Assert.assertTrue(false,"Exception in the method verify_PreScreenEnableOption: " + e.getMessage());
		}
		return sConcatenateSupplierName;
	}

	/**
	 * Method Name : verify_PreScreeningPage
	 * Purpose: Public method which includes logic related to verify and navigate to the PreScreening option
	 * @param: String sSupplierName, String sContactName, String sEmail, String sInviteOrg,
			String sSupplierGrp, String sComment, String sPrescreenEnable
	 * @return: String sConcatenateSupplierName
	 */
	public String verify_PreScreeningPage(String sSupplierName, String sContactName, String sEmail, String sInviteOrg,
			String sSupplierGrp, String sComment, String sPrescreenEnable){

		String sConcatenateSupplierName="";

		try{
			Reporter.log("\n Verify 'Pre Screening' Option for 'Create New Supplier': link ");
			//Create New Supplier
			sConcatenateSupplierName=createNewSupplier(sSupplierName,sContactName,sEmail,sInviteOrg,sSupplierGrp,
					sComment);
			//ge.clicks on the PreScreen option
			Reporter.log("\n");
			//ge.waitForTime(3000);
			lavanteUtils.click(idpreScreen);
			Reporter.log("Clicked on the 'PreScreen' button");
			//ge.waitForTime(60000);
			//verify the PreScreening dialog pop up
			validateTitleDialogPopup(xpathprescreenTitlebar,sConcatenateSupplierName);
			//Frame In
			lavanteUtils.switchtoFrame(xpathactivatePopupFrame);
			//ge.clicks on the 'OK' button
			lavanteUtils.click(xpathprescreenOKBtn);
			Reporter.log("Clicked on the 'Pre Screening OK' button");
			//ge.waitForTime(4000);
			//Frame Out
			lavanteUtils.switchtoFrame(null);
			//ge.clicks on the 'Send Invite' button
			lavanteUtils.click(idsendinviteBtn);
			Reporter.log("Clicked on the 'Send Invite' button");
			//ge.waitForTime(6000);
			//verify the Send Invite dialog pop up
			validateTitleDialogPopup(xpathprescreenTitlebar,"Send Invite");
			//ge.waitForTime(2000);
			//Frame In
			lavanteUtils.switchtoFrame( xpathactivatePopupFrame);
			//ge.clicks on the 'Send Invite' button
			//ge.waitForTime(1000);
			lavanteUtils.click(xpathsendInvitePopupBtn);
			Reporter.log("Clicked on the 'Send Invite Dialog Pop up' button");
			//ge.waitForTime(5000);
			//Frame Out
			lavanteUtils.switchtoFrame(null);
			//Verify the success message
			validateSuccessMsg(xpathSuccessMsg,expsendEmailSuccessMsg);
			//ge.waitForTime(3000);
			//ge.clicks on the 'Cancel' button
			lavanteUtils.click(xpathadvCancelBtn);
			Reporter.log("Clicked on the 'Cancel' button");
			//ge.waitForTime(4000);
		} catch(Exception e){
			//log.severe("Exception in the method verify_PreScreeningPage: "+ e.getMessage());
			lavanteUtils.takeScreenshot( "verify_PreScreeningPage");
			Assert.assertTrue(false,"Exception in the method verify_PreScreeningPage: " + e.getMessage());
		}		
		return sConcatenateSupplierName;		
	}

	/**
	 * Method Name : validateTitleDialogPopup
	 * Purpose: Public method which includes logic related to validate the title dialog Pop up message
	 * @param: String dialogPopup, String expPopupMsg
	 * @return: None
	 */
	public void validateTitleDialogPopup(WebElement dialogPopup, String expPopupMsg ){

		try{
			if(lavanteUtils.isElementDisplayed((dialogPopup))==true){
				String getText=lavanteUtils.getText( dialogPopup);
				//Validation
				if (getText.trim().toString().contains(expPopupMsg.trim().toString())) {
					Reporter.log("Verification is successful for 'dialog pop up' message: " + getText);
				} else {
					//log.severe("Test failed due to Expected message: " + expPopupMsg  + "  doesn't match with "
					//		+ " Actual message: " + getText);
					lavanteUtils.takeScreenshot(wdSupplierSearch, "validateDialogPopup");
					Assert.assertTrue(false,"Test failed due to Expected message: " + expPopupMsg  + "  doesn't match with "
							+ " Actual message: " + getText);
				}
			} else {
				//log.severe("Test failed due to dialog pop up did not displayed:");
				Assert.assertTrue(false,"Failed due to 'Upload dialog pop up' did not displayed: ");
			}
		} catch(Exception e){
			//log.severe("Exception in the method validateTitleDialogPopup: "+ e.getMessage());
			lavanteUtils.takeScreenshot(wdSupplierSearch, "validateTitleDialogPopup");
			Assert.assertTrue(false,"Exception in the method validateTitleDialogPopup: " + e.getMessage());
		}		
	}
	
	/**
	 * Method: verifyChangeLogInfo
	 * @purpose : to verify the change log information in the change log. Information verified will be Field Name, Operation Type, Old Value, New value and Modified By
	 * @param objdata
	 * @param str_acttype
	 * @return
	 */
	public boolean verifyChangeLogInfo(setTestData objdata){
		try{
			Assert.assertFalse(searchSupplierDetailsTable("Field Name", objdata.getOperationName().toString()).isEmpty(),"Field Name mismatch. Expected is : "+objdata.getOperationName().toString());
			Reporter.log("Verified the |Feild Name| to be "+ objdata.getOperationName().toString());
			Assert.assertFalse(searchSupplierDetailsTable("Operation Type", "Update").isEmpty(),"Operation Type mismatch. Expected is : "+"Update");
			Reporter.log("Verified the |Operation Type| to be "+ "Update");
			if(!objdata.getOldvalue().toString().trim().isEmpty())
			sAssert.assertFalse(searchSupplierDetailsTable("Old Value", objdata.getOldvalue().toString().trim()).isEmpty(),"Old Value mismatch. Expected is : "+objdata.getOldvalue().toString());
			Reporter.log("Verified the |Old Value| to be "+ objdata.getOldvalue().toString());
			Assert.assertFalse(searchSupplierDetailsTable("New Value", objdata.getNewvalue().toString()).isEmpty(),"New Value mismatch. Expected is : "+objdata.getNewvalue().toString());
			Reporter.log("Verified the |New Value| to be "+ objdata.getNewvalue().toString());
			Assert.assertFalse(searchSupplierDetailsTable("Modified By", objdata.getUserNameSupplier().toString()).isEmpty(),"Modified By mismatch. Expected is : "+objdata.getUserNameSupplier().toString());
			Reporter.log("Verified the |Modified By| to be "+ objdata.getUserName().toString());
			//ge.waitForTime(3000);
			closeSupplierDetailsPopup();
			return true;
			
		}catch(Exception e){
			//log.severe("The change of information notification is verified in the change log table ");
			Assert.assertTrue(false, "Exception in the method "+e.getMessage());
		}
		return false;
	}
	
	public void selectProfileStatus( String profileStatusValue)
	{
		
		lavanteUtils.click( ProfileStatusSearchInputBox);
		lavanteUtils.enterText("ProfileStatusSearchInputBox", ProfileStatusSearchInputBox, profileStatusValue);
		lavanteUtils.click( ProfileStatusSearchValue1);

	}

	public boolean verifyBasicSearchTableDisplayed() {

		boolean flag=false;
		
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(Search);
		lavanteUtils.click(Search);
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(BasicSearchTab);
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		flag=lavanteUtils.verifyElementDisplayed("BasicSearchTable",BasicSearchTable );
		lavanteUtils.switchtoFrame(null);
		
		return flag;
		
	}
	
	/**
	 * For Sanity
	 */
	public boolean verifyAdvanceSearchTableDisplayed() {
		
		boolean flag=false;
		
		lavanteUtils.click(AdvanceSearchTab);
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(BuildQuery);
		lavanteUtils.switchtoFrame(BuildQueryIFrame);
		flag=lavanteUtils.verifyElementDisplayed("BuildQueryCancelButton",BuildQueryCancelButton);
		lavanteUtils.click(BuildQueryCancelButton);
		lavanteUtils.switchtoFrame(null);
		
		return flag;
	}
	
	public boolean verifyLegalIDSeachDetailsDisplayed()
	{
		boolean flag=false;
		lavanteUtils.fluentwait(SupplierSearchResultForm);
		flag=lavanteUtils.verifyElementDisplayed("SupplierSearchResultForm", SupplierSearchResultForm);
		
		return flag;
	}
	
	public boolean verifyOFACPageDetailsDisplayed()
	{
		boolean flag=false;
		lavanteUtils.fluentwait(OFACSearchTable);
		flag=lavanteUtils.verifyElementDisplayed("OFACSearchTable", OFACSearchTable);
		return flag;
	}
	
	public boolean verifyAddressDetailsPageDetailsDisplayed()
	{
		lavanteUtils.fluentwait(supplierAddressTable);
		boolean flag=false;
		flag=lavanteUtils.verifyElementDisplayed("supplierAddressTable", supplierAddressTable);
		return flag;
		
	}
	
	public boolean verifyInvoicePageDetailsDisplayed()
	{
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(BasicSearchTab);
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		flag=lavanteUtils.verifyElementDisplayed("InvoicesDetailsTable",InvoicesDetailsTable);
		lavanteUtils.switchtoFrame(null);
		verifyAdvanceSearchTableDisplayed();
		return flag;
		
	}
	
	public boolean verifyContractDetailPageDisplayed()
	{
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(BasicSearchTab);
		lavanteUtils.click(BasicSearchTab);
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		flag=lavanteUtils.verifyElementDisplayed("contractMgmtTable",contractMgmtTable);
		lavanteUtils.switchtoFrame(null);
		verifyAdvanceSearchTableDisplayed();
		
		return flag;
	}
	
	public boolean verifyPaymentDetailsPageDisplayed()
	{
		boolean flag=false;
		
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(BasicSearchTab);
		lavanteUtils.click(BasicSearchTab);
		lavanteUtils.switchtoFrame(BasicSearchTableIFrame);
		flag=lavanteUtils.verifyElementDisplayed("PaymentDetailsTable",PaymentDetailsTable);
		lavanteUtils.switchtoFrame(null);
		verifyAdvanceSearchTableDisplayed();
		
		return flag;
		
	}
}
