/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class ViewSupplier {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public ViewSupplier(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}
	
	@FindBy(css = "div[id='viewprofile_inviteID_chosen'] ul li")
	public List<WebElement> ListOfInvites;

	public List<WebElement> ListOfInvites() {
		return ListOfInvites;
	}

	@FindBy(css = "div[id='viewprofile_inviteID_chosen'] a")
	public WebElement GetInviteIdSelectedInDropDwn;

	public WebElement GetInviteIdSelectedInDropDwn() {
		return GetInviteIdSelectedInDropDwn;
	}

	@FindBy(css="iframe[src*='contact']")
	private WebElement IFRAMEContact;

	public WebElement IFRAMEContact() {
		return IFRAMEContact;
	}

	@FindBy(css="iframe[id*='invoice_results']")
	private WebElement IFRAMEINV;
	public WebElement IFRAMEINV() {
		return IFRAMEINV;
	}

	//Supplier Portal
	@FindBy(css = "[id='content']>div>div:nth-child(1)>label:nth-child(1)")
	private WebElement GetCustomerSupplierName;
	public WebElement GetCustomerSupplierName() {
		return GetCustomerSupplierName;
	}
	
	@FindBy(css = "a[href*='viewSupplierProfile.lvp']")
	private WebElement nextSupplierLink;
	public WebElement nextSupplierLink() {
		return nextSupplierLink;
	}
	
	@FindBy(css = "div.page-breadcrumb>a")
	private WebElement backToSearchLink;
	public WebElement backToSearchLink() {
		return backToSearchLink;
	}
		
	// Supplier  Info
	@FindBy(css="div#content table tr:nth-child(3)>td:nth-child(2)")
	private WebElement InviteStatus;
	public WebElement InviteStatus() {
		return InviteStatus;
	}
	
	@FindBy(css="[class*='card-sub-section'] [class*='notification'] ")
	private List<WebElement> notificationdisabled;

	public List<WebElement> Listnotificationdisabledicon() {
		return notificationdisabled;
	}

	// Supplier Managed

	@FindBy(css="div[class='contact-erp-section'] div[class*='erp'] strong")
	private List<WebElement> GetLocationERPIDList;

	public List<WebElement> GetLocationERPIDList() {
		return GetLocationERPIDList;
	}

	// Core Profile
	//Header Details
	@FindBy(css="#content div[class*='header'] span")
	private WebElement supplierName;

	public WebElement supplierName() {
		return supplierName;
	}
	
	// Company Info
	@FindBy(xpath="//*[contains(@for,'supplierName')]/../..//td[2]")
	private WebElement SuppNameCompany;

	public WebElement SuppNameCompany() {
		return SuppNameCompany;
	}

	@FindBy(xpath="//*[@for='supplierFax']/../..//td[2]")
	private WebElement CoresupplierFax;

	public WebElement CoresupplierFax() {
		return CoresupplierFax;
	}

	// Location and contact

	@FindBy(css="#treeForm div[class*='location-type-icon']")
	private List<WebElement> ListContactHeader;

	public List<WebElement> ListContactHeader() {
		return ListContactHeader;
	}

	@FindBy(css="#treeForm div[class*='address-icon']")
	private List<WebElement> Listcntactaddress1;

	public List<WebElement> Listcntactaddress1() {
		return Listcntactaddress1;
	}

	@FindBy(css="#treeForm div[class*='address-icon']")
	private WebElement cntactaddress1;

	public WebElement cntactaddress1() {
		return cntactaddress1;
	}

	@FindBy(css="#treeForm div[class*='address'][class*='icon']")
	private WebElement cntactaddress;

	public WebElement cntactaddress() {
		return cntactaddress;
	}

	@FindBy(css="#treeForm div[class*='location'][class*='icon']")
	private List<WebElement> cntactaddressloctn;

	public List<WebElement> cntactaddressloctn() {
		return cntactaddressloctn;
	}

	@FindBy(css="#treeForm div[class*='contact'][class*='icon']")
	private List<WebElement> cntactaddresscntct;

	public List<WebElement> cntactaddresscntct() {
		return cntactaddresscntct;
	}

	@FindBy(css="#treeForm div[class*='contact'] a")
	private List<WebElement> cntactaddresscntctname;

	public List<WebElement> cntactaddresscntctname() {
		return cntactaddresscntctname;
	}

	@FindBy(css="#view_consolidate td:nth-child(5)")
	private WebElement cntactName;

	public WebElement cntactName() {
		return cntactName;
	}

	@FindBy(css="#view_consolidate td:nth-child(6)")
	private WebElement cntactEmail;

	public WebElement cntactEmail() {
		return cntactEmail;
	}

	// Contact Popup

	@FindBy(xpath="//*[contains(@for,'Name')]/../..//td[2]")
	private WebElement cntactPopupName;

	public WebElement cntactPopupName() {
		return cntactPopupName;
	}

	@FindBy(xpath="//*[contains(@for,'phone')]/../..//td[2]")
	private WebElement cntactPopupPhone;

	public WebElement cntactPopupPhone() {
		return cntactPopupPhone;
	}

	@FindBy(xpath="//*[contains(@for,'fax')]/../..//td[2]")
	private WebElement cntactPopupFax;

	public WebElement cntactPopupFax() {
		return cntactPopupFax;
	}

	@FindBy(xpath="//*[contains(@for,'email')]/../..//td[2]")
	private WebElement cntactPopupEmail;

	public WebElement cntactPopupEmail() {
		return cntactPopupEmail;
	}

	// Core Profile->Your Additional Company Profile Information

	@FindBy(xpath="//*[contains(@for,'isDuns')]/../..//td[2]")
	private WebElement doyouhaveDuns;

	public WebElement doyouhaveDuns() {
		return doyouhaveDuns;
	}

	@FindBy(xpath="//*[contains(@for,'dunsNumber')]/../..//td[2]")
	private WebElement DUNSNum;

	public WebElement DUNSNum() {
		return DUNSNum;
	}

	@FindBy(xpath="//*[contains(@for,'currency')]/../..//td[2]")
	private WebElement currencytype;

	public WebElement currencytype() {
		return currencytype;
	}

	@FindBy(xpath="//*[contains(@for,'geoServiceScope')]/../..//td[2]")
	private WebElement geoScope;

	public WebElement geoScope() {
		return geoScope;
	}

	@FindBy(css="[id*='primaryNAICS'] td:nth-child(1)")
	private WebElement primaryNAICScode;

	public WebElement primaryNAICScode() {
		return primaryNAICScode;
	}

	@FindBy(css="[id*='primaryNAICS'] td:nth-child(2)")
	private WebElement primaryNAICSdesc;

	public WebElement primaryNAICSdesc() {
		return primaryNAICSdesc;
	}

	@FindBy(css="[id*='secondaryNAICS'] td:nth-child(1)")
	private List<WebElement> secondaryNAICScode;

	public List<WebElement> secondaryNAICScode() {
		return secondaryNAICScode;
	}

	@FindBy(css="[id*='secondaryNAICS'] td:nth-child(2)")
	private List<WebElement> secondaryNAICSdesc;

	public List<WebElement> secondaryNAICSdesc() {
		return secondaryNAICSdesc;
	}

	// Regulatory
	@FindBy(xpath="//*[@for='country']/../..//td[2]")
	private WebElement countryofReg;

	public WebElement countryofReg() {
		return countryofReg;
	}

	@FindBy(xpath="//*[@for='legalIdProvidedStatus']/../..//td[2]")
	private WebElement legalIDstatus;

	public WebElement legalIDstatus() {
		return legalIDstatus;
	}

	@FindBy(xpath="//*[@for='taxIDType']/../..//td[2]")
	private WebElement taxIDtype;

	public WebElement taxIDtype() {
		return taxIDtype;
	}

	@FindBy(xpath="//*[@for='legalIdentifier']/../..//td[2]")
	private WebElement taxIDNum;

	public WebElement taxIDNum() {
		return taxIDNum;
	}

	@FindBy(xpath="//*[@for='usIncome']/../..//td[2]")
	private WebElement UsIncome;

	public WebElement UsIncome() {
		return UsIncome;
	}

	@FindBy(xpath="//*[@for='euRegistrationNumber']/../..//td[2]")
	private WebElement LegalregNum;

	public WebElement LegalregNum() {
		return LegalregNum;
	}

	@FindBy(xpath="//*[@for='companyLegalName']/../..//td[2]")
	private WebElement BusinessName;

	public WebElement BusinessName() {
		return BusinessName;
	}

	@FindBy(xpath="//*[@for='usLegalCompanyName']/../..//td[2]")
	private WebElement USIncomeBusinessName;

	public WebElement USIncomeBusinessName() {
		return USIncomeBusinessName;
	}

	@FindBy(xpath="//*[contains(@for,'usTinNumber')]/../..//td[2]")
	private WebElement EINNUM;

	public WebElement EINNUM() {
		return EINNUM;
	}

	@FindBy(css="[class*='data_table'] span[title='Validated']")
	private WebElement VATRegistrationTickMark;

	public WebElement VATRegistrationTickMark() {
		return VATRegistrationTickMark;
	}

	@FindBy(css="a[href*='download']")
	private WebElement LegalIDDoc;

	public WebElement LegalIDDoc() {
		return LegalIDDoc;
	}

	//@FindBy(xpath="//*[text()='File name']/../../..//a")
	//Supplier Login [sup home page test]
	@FindBy(css="table a[href*='downloadFile']")
	private List<WebElement> getListOfW9TaxFilesLink;

	public List<WebElement> getListOfW9TaxFilesLink() {
		return getListOfW9TaxFilesLink;
	}
	// Core Profile->Diversity Info

	@FindBy(xpath="//label[@for='ethnicity']/parent::td[1]/following-sibling::td[1]")
	private WebElement GetEthnicityInfo;

	public WebElement GetEthnicityInfo() {
		return GetEthnicityInfo;
	}

	// Core Profile->Financial Info
	@FindBy(xpath="//label[@for='exchangeTradedOn']/parent::td[1]/following-sibling::td[1]")
	private WebElement GetExchangeTradedOnInfo;

	public WebElement GetExchangeTradedOnInfo() {
		return GetExchangeTradedOnInfo;
	}

	// Certificate

	@FindBy(xpath="//*[contains(@for,'Insurance')]/../..//td[2]")
	private WebElement haveinsurance;

	public WebElement haveinsurance() {
		return haveinsurance;
	}

	@FindBy(xpath="//*[contains(@for,'Insurance')]/../../../../following-sibling::table[1]//tbody//td[1]")
	private List<WebElement> listinsuranceName;

	public List<WebElement> listinsuranceName() {
		return listinsuranceName;
	}

	@FindBy(xpath="//*[contains(@for,'Insurance')]/../../../../following-sibling::table[1]//tbody//td[6]")
	private List<WebElement> listinsuranceCoverageLimit;

	public List<WebElement> listinsuranceCoverageLimit() {
		return listinsuranceCoverageLimit;
	}

	@FindBy(xpath="//*[contains(@for,'Insurance')]/../../../../following-sibling::table[1]//tbody//td[8]")
	private List<WebElement> listinsuranceStatus;

	public List<WebElement> listinsuranceStatus() {
		return listinsuranceStatus;
	}

	// Documents

	@FindBy(css="[id*='your'] tbody td:nth-child(1)")
	private List<WebElement> doctype;

	public List<WebElement> doctype() {
		return doctype;
	}

	@FindBy(css="[id*='your'] tbody td:nth-child(2)")
	private List<WebElement> doccertifiedStatus;

	public List<WebElement> doccertifiedStatus() {
		return doccertifiedStatus;
	}

	// Payment Info

	@FindBy(xpath="//*[contains(@for,'isEarlyPaymentDiscountOffered')]/../../td[2]")
	private WebElement Discountoffer;

	public WebElement Discountoffer() {
		return Discountoffer;
	}

	@FindBy(xpath="//*[contains(@for,'paymentType')]/../../td[2]")
	private WebElement PaymentType;

	public WebElement PaymentType() {
		return PaymentType;
	}

	@FindBy(css="#payment_authorization_check+div tr:nth-child(1) td:nth-child(2)")
	private WebElement GetPayableToValue;

	public WebElement GetPayableToValue() {
		return GetPayableToValue;
	}

	@FindBy(css="#payment_authorization_check+div tr:nth-child(2) td:nth-child(2)")
	private WebElement GetPaymentTermsValue;

	public WebElement GetPaymentTermsValue() {
		return GetPaymentTermsValue;
	}

	// EFT
	@FindBy(xpath="//*[contains(@for,'eftTermsAndConditionsBox')]/../../td[2]")
	private WebElement GetPaymentEFTTC;

	public WebElement GetPaymentEFTTC() {
		return GetPaymentEFTTC;
	}

	// EFT Table

	@FindBy(xpath="//*[contains(@href,'EFT')]/../../..//td[2]/a[1]")
	private List<WebElement> ListEFTEMail;

	public List<WebElement> ListEFTEMail() {
		return ListEFTEMail;
	}

	@FindBy(xpath="//*[contains(@href,'EFT')]/../../..//td[6]")
	private List<WebElement> ListEFTAccNum;

	public List<WebElement> ListEFTAccNum() {
		return ListEFTAccNum;
	}

	@FindBy(xpath="//*[contains(@href,'EFT')]/../../..//td[7]")
	private List<WebElement> ListEFTAddress;

	public List<WebElement> ListEFTAddress() {
		return ListEFTAddress;
	}

	// Payment Authorization
	@FindBy(css="label[for='ccPaymentTerms']")
	private WebElement CCPaymentAuth;

	public WebElement CCPaymentAuth() {
		return CCPaymentAuth;
	}

	@FindBy(css="label[for='checkPaymentTerms']")
	private WebElement CPaymentAuth;

	public WebElement CPaymentAuth() {
		return CPaymentAuth;
	}

	@FindBy(css="label[for='eftPaymentTerms']")
	private WebElement EFTPaymentAuth;

	public WebElement EFTPaymentAuth() {
		return EFTPaymentAuth;
	}

	// Credit Card Details
	@FindBy(xpath="//label[starts-with(text(),'Selected Card:')]/parent::td/../td[@class='align_left']")
	private WebElement CCSelectedCard;

	public WebElement CCSelectedCard() {
		return CCSelectedCard;
	}

	// Check Details
	@FindBy(xpath="//label[starts-with(text(),'Payable To:')]/parent::td/../td[@class='align_left']")
	private WebElement CPayableTo;

	public WebElement CPayableTo() {
		return CPayableTo;
	}

	// Relation Specific Profile

	@FindBy(xpath="//*[contains(@for,'productServiceType')]/../..//td[2]")
	private WebElement TypeofProduct;

	public WebElement TypeofProduct() {
		return TypeofProduct;
	}

	@FindBy(xpath="//*[contains(@for,'productsServicesPerformed')]/../..//td[2]")
	private WebElement ProductServices;

	public WebElement ProductServices() {
		return ProductServices;
	}

	@FindBy(xpath="//label[@for='w8Tax_information']/../..//a")
	private List<WebElement> getListOfW8TaxFilesLink;

	public List<WebElement> getListOfW8TaxFilesLink() {
		return getListOfW8TaxFilesLink;
	}

	@FindBy(xpath="//label[@for='w8Tax_information']/../..//td[7]")
	private List<WebElement> getListTaxInfoStatus;

	public List<WebElement> getListTaxInfoStatus() {
		return getListTaxInfoStatus;
	}

	@FindBy(xpath="//label[@for='w9Tax_information']/../../..//div[2]//td[5]")
	private List<WebElement> getListOfW9TaxStatusLink;

	public List<WebElement> getListOfW9TaxStatusLink() {
		return getListOfW9TaxStatusLink;
	}

	// EnterPrise OWned
	//Onboarding
	@FindBy(xpath="//*[contains(@title,'Business Unit')]/../../..//td")
	private List<WebElement> BusinessUnit;
	public List<WebElement> BusinessUnit() {
		return BusinessUnit;
	}
	
	@FindBy(xpath="//th[@title='User Name']/../../..//td[1]")
	private List<WebElement> SuppContactName;
	public List<WebElement> SuppContactName() {
		return SuppContactName;
	}
	
	@FindBy(xpath="//*[contains(@title,'Email')]/../../..//a[@href]")
	private List<WebElement> Email;
	public List<WebElement> Email() {
		return Email;
	}
	
	@FindBy(xpath="//*[contains(text(),'Client Company Name:')]/parent::td[1]/following-sibling::td[1]")
	private WebElement GetClientCompanyName;
	public WebElement GetClientCompanyName() {
		return GetClientCompanyName;
	}
	
	@FindBy(xpath="//*[contains(text(),'Project Number:')]/parent::td[1]/following-sibling::td[1]")
	private WebElement GetProjectNumber;
	public WebElement GetProjectNumber() {
		return GetProjectNumber;
	}

	//Header Information
	@FindBy(xpath="//*[contains(@for,'supplierAliasName')]/../..//td[2]")
	private WebElement SuppName;
	public WebElement SuppName() {
		return SuppName;
	}
	
	@FindBy(xpath="//*[contains(@for,'supplierGroup')]/../..//td[2]")
	private WebElement SuppGroup;
	public WebElement SuppGroup() {
		return SuppGroup;
	}
	// Key Supplier Info

	@FindBy(xpath="//*[contains(@for,'supplierID')]/../..//td[2]")
	private WebElement suppliererpid;

	public WebElement suppliererpid() {
		return suppliererpid;
	}

	@FindBy(xpath="//*[contains(@for,'invitedBy')]/../..//td[2]")
	private WebElement invitedBY;

	public WebElement invitedBY() {
		return invitedBY;
	}

	@FindBy(xpath="//*[contains(@for,'profileControlTakenBy')]/../..//td[2]")
	private WebElement takeControlBy;

	public WebElement takeControlBy() {
		return takeControlBy;
	}

	@FindBy(xpath="//*[contains(@title,'Busine')]/../../..//tbody//td[1]")
	private List<WebElement> invteorglist;

	public List<WebElement> invteorglist() {
		return invteorglist;
	}

	@FindBy(xpath="//*[contains(@for,'totalSpendLastYear')]/../..//td[2]")
	private List<WebElement> totalSpend;

	public List<WebElement> totalSpend() {
		return totalSpend;
	}

	// Supplier Contact Info table
	@FindBy(xpath="//*[contains(text(),'Supplier Contact Info')]/following-sibling::table//td[1]")
	private List<WebElement> ContactsupplierName;
	public List<WebElement> ContactsupplierName() {
		return ContactsupplierName;
	}

	@FindBy(xpath="//*[contains(text(),'Supplier Contact Info')]/following-sibling::table//td[5]")
	private List<WebElement> ContactsupplierPhone;
	public List<WebElement> ContactsupplierPhone() {
		return ContactsupplierPhone;
	}
	
	@FindBy(xpath="//*[contains(text(),'Supplier Contact Info')]/following-sibling::table//td[6]")
	private List<WebElement> ContactsupplierFax;
	public List<WebElement> ContactsupplierFax() {
		return ContactsupplierFax;
	}
	
	@FindBy(xpath="//*[contains(text(),'Supplier Contact Info')]/following-sibling::table//td[7]")
	private List<WebElement> ContactsupplierEmail;
	public List<WebElement> ContactsupplierEmail() {
		return ContactsupplierEmail;
	}

	// w8
	@FindBy(xpath="//*[@for='ctiSupplierStatus']/../..//td[2]")
	private WebElement ctiStatus;

	public WebElement ctiStatus() {
		return ctiStatus;
	}

	@FindBy(xpath="//*[contains(text(),'Form Validation')]/../..//td[2]")
	private WebElement formValid;

	public WebElement formValid() {
		return formValid;
	}

	// Contact
	@FindBy(xpath="//*[contains(@id,'contactName')]/../../..//td[1]")
	private WebElement ContactName;

	public WebElement ContactName() {
		return ContactName;
	}

	// List of contact name
	@FindBy(css="span[contact] tbody td:nth-child(1)")
	private List<WebElement> ContactNameList;

	public List<WebElement> ContactNameList() {
		return ContactNameList;
	}

	// Re invited by
	@FindBy(xpath="//*[contains(@for,'reInvitedBy')]/../..//td[2]")
	private WebElement reInvitedBy;

	public WebElement reInvitedBy() {
		return reInvitedBy;
	}

	// invited by
	@FindBy(xpath="//*[contains(text(),'Invited By')]/../..//td[2]")
	private WebElement invitedby;

	public WebElement invitedby() {
		return invitedby;
	}

	// Notes

	@FindBy(css="[id*='commentType'] a")
	private WebElement notetypedpdn;

	public WebElement notetypedpdn() {
		return notetypedpdn;
	}

	@FindBy(id="comment")
	private WebElement notedesc;

	public WebElement notedesc() {
		return notedesc;
	}

	@FindBy(css="[type*='submit']")
	private WebElement savebtn;

	public WebElement savebtn() {
		return savebtn;
	}

	@FindBy(xpath="//*[contains(text(),'Supplier Private Notes')]/../../..//tbody//td[2]")
	private List<WebElement> ListSupplierPrivateNotes;

	public List<WebElement> ListSupplierPrivateNotes() {
		return ListSupplierPrivateNotes;
	}

	// invoice subtab
	@FindBy(css="iframe[src*='doInvoiceBasicSearchExecute']")
	private WebElement IframeInvoiceSearchPage;

	public WebElement IframeInvoiceSearchPage() {
		return IframeInvoiceSearchPage;
	}

	@FindBy(css="iframe[src*='doInvoiceBasicSearchExecute']")
	private WebElement IframeInvoicePopUp;

	public WebElement IframeInvoicePopUp() {
		return IframeInvoicePopUp;
	}

	// As Supplied VNF
	@FindBy(xpath="//*[contains(text(),'Supplier Name')]/../../following-sibling::tbody//td[2]")

	private WebElement VMFsuppname;

	public WebElement VMFsuppname() {
		return VMFsuppname;
	}

	@FindBy(xpath="//*[contains(text(),'Supplier Name')]/../../following-sibling::tbody//td[9]")

	private WebElement VMFAddress;

	public WebElement VMFAddress() {
		return VMFAddress;
	}

	// Status and History

	// Profile and Approval

	// New implementation on View Supplier Text->Approval N/A-->Hence Changed
	@FindBy(xpath="//*[@id='content']//table[1]//td[2]")
	private List<WebElement> StatusProfStatusListType;

	public List<WebElement> StatusProfApprovalListType() {
		return StatusProfStatusListType;
	}

	@FindBy(xpath="//*[@id='content']//table[1]//td[3]")
	private List<WebElement> StatusProfStatusListActor;

	public List<WebElement> StatusProfApprovalListActor() {
		return StatusProfStatusListActor;
	}

	@FindBy(xpath="//*[@id='content']//table[1]//td[4]")
	private List<WebElement> StatusProfStatusListAction;

	public List<WebElement> StatusProfApprovalListAction() {
		return StatusProfStatusListAction;
	}

	@FindBy(xpath="//*[@id='content']//table[1]//td[6]")
	private List<WebElement> StatusProfStatusListComment;

	public List<WebElement> StatusProfApprovalListComment() {
		return StatusProfStatusListComment;
	}

	// ProfileStage MileStone Section
	@FindBy(xpath="//*[contains(text(),'Profile Stage Milestone')]/../..//td[2]")
	private List<WebElement> ListProfileStage;
	public List<WebElement> ListProfileStage() {
		return ListProfileStage;
	}

	// LegalID Tab

	@FindBy(xpath="//*[contains(text(),'Legal Name')]/../../..//td[3]")
	private List<WebElement> ListLegalCountry;

	public List<WebElement> ListLegalCountry() {
		return ListLegalCountry;
	}

	@FindBy(xpath="//*[contains(text(),'Legal Name')]/../../..//td[6]")
	private List<WebElement> ListLegalStatus;

	public List<WebElement> ListLegalStatus() {
		return ListLegalStatus;
	}

	@FindBy(xpath="//*[contains(text(),'Legal Name')]/../../..//td[7]")
	private List<WebElement> ListLegalComments;

	public List<WebElement> ListLegalComments() {
		return ListLegalComments;
	}

	// Required FieldsTab

	@FindBy(id="profile_percentage")
	private WebElement ProfPercent;

	public WebElement ProfPercent() {
		return ProfPercent;
	}

	@FindBy(css="[class*='to'] i")
	private List<WebElement> ListReqdField;

	public List<WebElement> ListReqdField() {
		return ListReqdField;
	}

	// supplier invoice details Table data page objects

	@FindBy(css="a[href*='invoice']")
	private WebElement TBLinvnumb;

	public WebElement TBLinvnumb() {
		return TBLinvnumb;
	}
	
	@FindBy(css = "table#invoiceDetails th")
	private List<WebElement> Headers;

	//End of invoice page
	
	
	@FindBy(css="a[href*='customerSupplierSearch']")
	private WebElement BackToSearchLink;

	public WebElement BackToSearchLink() {
		return BackToSearchLink;
	}

	@FindBy(css="a[href*='supplierDashboard']")
	private WebElement BackToSupplierHomePageLink;

	public WebElement BackToSupplierHomePageLink() {
		return BackToSupplierHomePageLink;
	}
	

	// Status and History --> Change Log --> Data Chnage Log

	@FindBy(css="table[class*='dynamic_table'] td:nth-child(2)")
	private List<WebElement> ListDataOperationTypeValue;

	public List<WebElement> ListDataOperationTypeValue() {
		return ListDataOperationTypeValue;
	}

	@FindBy(css="table[class*='dynamic_table'] td:nth-child(3)")
	private List<WebElement> ListDataChangeLogOldValue;

	public List<WebElement> ListDataChangeLogOldValue() {
		return ListDataChangeLogOldValue;
	}

	@FindBy(css="table[class*='dynamic_table'] td:nth-child(4)")
	private List<WebElement> ListDataChangeLogNewValue;

	public List<WebElement> ListDataChangeLogNewValue() {
		return ListDataChangeLogNewValue;
	}
	
	
	//MainTab
	@FindBy(css="div[class*='drop']>a[title]")
	private List<WebElement> mainTab;
	public List<WebElement> mainTab(){
		return mainTab;
	}
	
	
	// Reusable Methods
	
	
	/**
	 * Default Invite
	 * 
	 * @author subhas.bv
	 */
	public String getDefaultInviteIdSelected() {
		String inviteId = null;
		if (ListOfInvites().size() > 0) {
			for (int i = 0; i < ListOfInvites().size(); i++) {
				String classAttribute = ListOfInvites.get(i).getAttribute("class");
				if (classAttribute.equals("active-result result-selected")) {
					inviteId = ListOfInvites.get(i).getText();
				}
			}
		}
		return inviteId;
	}
	
	
	public void selectTab(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("maintab")) {
			for(int i=0;i<mainTab.size();i++){
				String x=mainTab.get(i).getAttribute("Title");
				if(x.contains(dataMap.get("maintab"))){
					lavanteUtils.click(mainTab.get(i));
					break;
				}
			}
		}
		lavanteUtils.waitForTime(6000);
		if (dataMap.containsKey("subtab")) {

			String sub = "div[class*='drop']  a[href*='" + dataMap.get("subtab").toString() + "']";
			lavanteUtils.click(driver.findElement(By.cssSelector(sub)));
		}
		lavanteUtils.waitForTime(2000);
	}

	public void addNotes(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("NoteType")) {
			lavanteUtils.click(notetypedpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("NoteType"));
		}

		if (dataMap.containsKey("NoteDesc")) {
			lavanteUtils.typeString(dataMap.get("NoteDesc"), notedesc);
		}
		lavanteUtils.click(savebtn);

	}

	public void clickOnSupplier(String suplierName) {
		String object = "//a[starts-with(normalize-space(text()),'" + suplierName.trim()
				+ "') and starts-with(normalize-space(.),'" + suplierName.trim() + "')]";
		WebElement ele = lavanteUtils.driver.findElement(By.xpath(object));
		lavanteUtils.click(ele);
		lavanteUtils.switchtoFrame(null);
	}
	

	public String getInvoiceColumnText(String colname, int count) {
		String x = "";
		lavanteUtils.switchtoFrame(IFRAMEINV);
		List<WebElement> sx = InvoiceiterateSearchHeaderFindColList(colname);
		outr: for (int i = 0; i < InvoiceiterateSearchHeaderFindColList(colname).size(); i++) {
			x = sx.get(i).getText();
			if (count == 0) {
				if (x.length() > 0) {
					break outr;
				}
			} else {
				x = sx.get(count).getText();
				break outr;
			}
		}
		return x;
	}
	
	private List<WebElement> InvoiceiterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = InvoiceColIdentify(col);
		int y = j + 1;

		String x = "#invoiceDetails tr td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		return s;
	}
	
	private int InvoiceColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase();
				if (x.contains(col.toLowerCase())) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
					found = true;
					break;
				}
			}
		}

		if (found == false) {
			Assert.assertTrue(false, "Col name not found" + col);
		}
		return ki;

	}
	

}
