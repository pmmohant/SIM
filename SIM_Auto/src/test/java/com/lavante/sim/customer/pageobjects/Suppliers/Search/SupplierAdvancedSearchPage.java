/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.Search;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class SupplierAdvancedSearchPage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public SupplierAdvancedSearchPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	
	@FindBy(css="iframe#search_results")
	private WebElement SearchListIFRAME;

	public WebElement SearchListIFRAME() {
		return SearchListIFRAME;
	}

	
	// Tab
	@FindBy(id="adv_search_tab")
	private WebElement advtab;

	public WebElement advtab() {
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		lavanteUtils.switchtoFrame(null);
		return advtab;
	}

	@FindBy(css="#advanceSearchExecute input[type*='reset']")
	private WebElement formClearbtn;

	public WebElement formClearbtn() {
		return formClearbtn;
	}
	
	// Build Query
	@FindBy(css="button[href='loadAdvanceSearch.lvp']")
	private WebElement buildqrybtn;

	public WebElement buildqrybtn() {
		return buildqrybtn;
	}

	@FindBy(css="iframe[id*='search']")
	private WebElement IFRAMESearch;
	
	@FindBy(css="iframe[src*='loadAdvanceSearch']")
	private WebElement IFRAMEBuildQry;

	public WebElement IFRAMEBuildQry() {
		return IFRAMEBuildQry;
	}
	
	@FindBy(css="iframe[src*='savedSearch']")
	private WebElement IFRAMEQryPopup;

	public WebElement IFRAMEQryPopup() {
		return IFRAMEQryPopup;
	}
	
	//Build Query Popup
	@FindBy(css="label[for*='build_filter_AND']")
	private WebElement filterAll;

	public WebElement filterAll() {
		return filterAll;
	}
	
	@FindBy(css="label[for*='build_filter_OR']")
	private WebElement filterANY;

	public WebElement filterANY() {
		return filterANY;
	}
	
	@FindBy(css="[id*='searchAcrossLavanteNetwork']~label")
	private WebElement searchAcrossNwrk;

	public WebElement searchAcrossNwrk() {
		return searchAcrossNwrk;
	}

	@FindBy(css="#advanceSearch div[class*='head'] button")
	private WebElement clearBtn;

	public WebElement clearBtn() {
		return clearBtn;
	}

	@FindBy(css="[id*='advance'] input[type='submit'][title*='Search']")
	private WebElement Buildsearch;

	public WebElement Buildsearch() {
		return Buildsearch;
	}

	@FindBy(css="[id*='advance'] button[title*='Cancel']")
	private WebElement Cancelsearch;

	public WebElement Cancelsearch() {
		return Cancelsearch;
	}

	// TABS

	@FindBy(id = "profileSelection")
	private WebElement TabSelection;

	public WebElement TabSelection() {
		return TabSelection;
	}
	
	@FindBy(css="a[href*='legal_id']")
	private WebElement TabCompanyLegal;

	public WebElement TabCompanyLegal() {
		return TabCompanyLegal;
	}

	@FindBy(css="a[href*='cert']")
	private WebElement TabCompanycertificate;

	public WebElement TabCompanycertificate() {
		return TabCompanycertificate;
	}

	@FindBy(css="a[href*='payment']")
	private WebElement TabPayment;

	public WebElement TabPayment() {
		return TabPayment;
	}

	@FindBy(css="a[href*='eg_data']")
	private WebElement TabEnterprise;

	public WebElement TabEnterprise() {
		return TabEnterprise;
	}
	
	@FindBy(css="a[href*='eg_data_invite']")
	private WebElement TabEnterpriseInvite;

	public WebElement TabEnterpriseInvite() {
		return TabEnterpriseInvite;
	}

	@FindBy(css="a[href*='TaxInfo']")
	private WebElement TabTax;

	public WebElement TabTax() {
		return TabTax;
	}

	// Company Profile

	@FindBy(css="[id*='supplier_name'] a")
	private WebElement SupplierNamedpdn;

	public WebElement SupplierNamedpdn() {
		return SupplierNamedpdn;
	}
	
	@FindBy(css="[name*='supplier_name_field']")
	private WebElement SuppNameTxtbx;

	public WebElement SuppNameTxtbx() {
		return SuppNameTxtbx;
	}


	@FindBy(css="[id*='addressType'] a")
	private WebElement AddressTypedpdn;

	public WebElement AddressTypedpdn() {
		return AddressTypedpdn;
	}
	
	@FindBy(css="[id*='city'] a")
	private WebElement cityAddressdpdntype;

	public WebElement cityAddressdpdntype() {
		return cityAddressdpdntype;
	}
	
	@FindBy(css="[name*='city_field']")
	private WebElement CityAddTxtbx;

	public WebElement CityAddTxtbx() {
		return CityAddTxtbx;
	}

	@FindBy(css="[id*='Country'] a")
	private WebElement countryAddressdpdntype;

	public WebElement countryAddressdpdntype() {
		return countryAddressdpdntype;
	}

	@FindBy(css="[id*='rel_country'] a")
	private WebElement countryAddressdpdn;

	public WebElement countryAddressdpdn() {
		return countryAddressdpdn;
	}

	@FindBy(css="[id*='state'] a")
	private WebElement stateAddressdpdntype;

	public WebElement stateAddressdpdntype() {
		return stateAddressdpdntype;
	}
	
	@FindBy(css="[id*='rel_state'] a")
	private WebElement stateAddressdpdn;

	public WebElement stateAddressdpdn() {
		return stateAddressdpdn;
	}
	
	@FindBy(css="[id*='rel_state'] input")
	private WebElement stateAddresstypetext;

	public WebElement stateAddresstypetext() {
		return stateAddresstypetext;
	}

	@FindBy(css="[id*='fax'] a")
	private WebElement Faxdpdn;

	public WebElement Faxdpdn() {
		return Faxdpdn;
	}

	@FindBy(css="[name*='fax_field']")
	private WebElement FaxTxtbx;

	public WebElement FaxTxtbx() {
		return FaxTxtbx;
	}
	
	@FindBy(css="[id*='email'] a")
	private WebElement Emaildpdn;

	public WebElement Emaildpdn() {
		return Emaildpdn;
	}

	@FindBy(css="[name*='email_field']")
	private WebElement EmailTxtbx;

	public WebElement EmailTxtbx() {
		return CEmailTxtbx;
	}
	
	
	//Contact
	@FindBy(css="[id*='ContactName'] a")
	private WebElement CNamedpdn;

	public WebElement CNamedpdn() {
		return CNamedpdn;
	}

	@FindBy(css="[name*='ContactName_field']")
	private WebElement CNameTxtbx;
	public WebElement CNameTxtbx() {
		return CNameTxtbx;
	}
	
	@FindBy(css="[id*='ContactEmail'] a")
	private WebElement CEmaildpdn;
	public WebElement CEmaildpdn() {
		return CEmaildpdn;
	}

	@FindBy(css="[name*='ContactEmail_field']")
	private WebElement CEmailTxtbx;
	public WebElement CEmailTxtbx() {
		return CEmailTxtbx;
	}

	@FindBy(css="[id*='ContactFax'] a")
	private WebElement CFaxdpdn;

	public WebElement CFaxdpdn() {
		return CFaxdpdn;
	}
	
	@FindBy(css="[name*='ContactFax_field']")
	private WebElement CFaxTxtbx;

	public WebElement CFaxTxtbx() {
		return CFaxTxtbx;
	}

	
	@FindBy(css="[id*='service_scope'] a")
	private WebElement GeoScopedpdn;

	public WebElement GeoScopedpdn() {
		return GeoScopedpdn;
	}
	
	@FindBy(css="[id*='isocurrencyId'] a")
	private WebElement Currencydpdn;

	public WebElement Currencydpdn() {
		return Currencydpdn;
	}
	
	// Customer Specific Profile
	@FindBy(css="a[href*='cs_profile']")
	private WebElement CustomerProfileTab;

	public WebElement CustomerProfileTab() {
		return CustomerProfileTab;
	}

	@FindBy(css="div[id*='supplierID']>a")
	private WebElement SupplierERPIdDropDwn;

	public WebElement SupplierERPIdDropDwn() {
		return SupplierERPIdDropDwn;
	}

	@FindBy(how = How.NAME   , using = "supplierID_field")
	private WebElement SupplierERPIdTxtBox;

	public WebElement SupplierERPIdTxtBox() {
		return SupplierERPIdTxtBox;
	}

	@FindBy(css="div[id*='ERPLocationID']>a")
	private WebElement LocationERPIdDropDwn;

	public WebElement LocationERPIdDropDwn() {
		return LocationERPIdDropDwn;
	}
	
	@FindBy(how = How.NAME, using = "ERPLocationID_field")
	private WebElement LocationERPIdTxtBox;

	public WebElement LocationERPIdTxtBox() {
		return LocationERPIdTxtBox;
	}
	
	@FindBy(css="div[id*='foreignTaxInformationW8Provided']>a")
	private WebElement ForeignTaxInfoDocW8ProvidedDropDwn;

	public WebElement ForeignTaxInfoDocW8ProvidedDropDwn() {
		return ForeignTaxInfoDocW8ProvidedDropDwn;
	}

	@FindBy(css="div[id*='W8DocumentStatus']>a")
	private WebElement ForeignTaxInfoDocStatusDropDwn;

	public WebElement ForeignTaxInfoDocStatusDropDwn() {
		return ForeignTaxInfoDocStatusDropDwn;
	}

	
	@FindBy(css="[id*='prodServType'] a")
	private WebElement TypeofProductServicedpdn;

	public WebElement TypeofProductServicedpdn() {
		return TypeofProductServicedpdn;
	}
	
	@FindBy(css="[id*='prodServ_'] a")
	private WebElement ProductServicedpdn;

	public WebElement ProductServicedpdn() {
		return ProductServicedpdn;
	}
	
	@FindBy(css="input[name*='prodServ_']")
	private WebElement ProductServicetxtbx;

	public WebElement ProductServicetxtbx() {
		return ProductServicetxtbx;
	}
	
	// Enterprise TAB Locators
	@FindBy(css="[id^='ctiStatus'][id*='chosen']")
	private WebElement CTIUI;

	public WebElement CTIUI() {
		return CTIUI;
	}

	@FindBy(css="[id*='ctiStatus'] input")
	private WebElement CTI;

	public WebElement CTI() {
		return CTI;
	}

	/*
	 * @FindBy(xpath = "//*[@id='ctiStatus_chosen']//li//em") private WebElement
	 * ctiStatus;
	 */

	/*
	 * @FindBy(xpath = "//*[@id='profileStatus_chosen']//li//em") private
	 * WebElement ProfState;
	 */
	// TAX INFO LOCATORS

	@FindBy(css="[id^='formValidationResultCode'][id*='chosen']")
	private WebElement formValidationUI;

	public WebElement formValidationUI() {
		return formValidationUI;
	}

	@FindBy(css="[id*='formValidation'] input")
	private WebElement formValidation;

	public WebElement formValidation() {
		return formValidation;
	}

	@FindBy(xpath = "//select[@id='formValidation']//following-sibling::div[2]//input")
	private WebElement formValidationInputBox;

	@FindBy(xpath = "//*[@id='formValidationResultCode1_chosen']//li//em")
	private WebElement formValidationValue1;

	// For Company Legal ID tab

	@FindBy(css="[id*='countryOfRegistration'] a")
	private WebElement regCountrydpdn;

	public WebElement regCountrydpdn() {
		return regCountrydpdn;
	}

	@FindBy(css="[id*='countryReg'] a")
	private WebElement regtypCountrydpdn;

	public WebElement regtypCountrydpdn() {
		return regtypCountrydpdn;
	}

	@FindBy(css="[id*='usIncome'] a")
	private WebElement USINCOMEDPDN;

	public WebElement USINCOMEDPDN() {
		return USINCOMEDPDN;
	}

	@FindBy(css="[id*='additionalBusinessName']>a")
	private WebElement BusinessNameDropDwn;

	public WebElement BusinessNameDropDwn() {
		return BusinessNameDropDwn;
	}

	@FindBy(css="input[name*='additionalBusinessName']")
	private WebElement BusinessNameTxtBox;

	public WebElement BusinessNameTxtBox() {
		return BusinessNameTxtBox;
	}

	@FindBy(css="[id*='businessStructureId']>a")
	private WebElement BusinessStructureDropDwn;

	public WebElement BusinessStructureDropDwn() {
		return BusinessStructureDropDwn;
	}

	@FindBy(css=".chosen-search>input")
	private WebElement BusinessStructureTxtBox;

	public WebElement BusinessStructureTxtBox() {
		return BusinessStructureTxtBox;
	}

	@FindBy(css="[id*='taxIDType_chosen']")
	private WebElement TaxIDTypeDropDwn;

	public WebElement TaxIDTypeDropDwn() {
		return TaxIDTypeDropDwn;
	}

	@FindBy(css="[id*='legalIdentifier_chosen']>a")
	private WebElement TaxIDNumberDropDwn;

	public WebElement TaxIDNumberDropDwn() {
		return TaxIDNumberDropDwn;
	}

	@FindBy(css="input[name*='legalIdentifier']")
	private WebElement TaxIDNumberTxtBox;

	public WebElement TaxIDNumberTxtBox() {
		return TaxIDNumberTxtBox;
	}

	@FindBy(css="[id*='legalIdProvidedStatus']>a")
	private WebElement LegalIdentifierstatusDropDwn;

	public WebElement LegalIdentifierstatusDropDwn() {
		return LegalIdentifierstatusDropDwn;
	}

	@FindBy(css="[id*='legalIdDocumentW9Provided'] a")
	private WebElement legalDocdrpdn;

	public WebElement legalDocdrpdn() {
		return legalDocdrpdn;
	}
	
	
	@FindBy(css="div[id*='W9DocumentStatus'] a")
	private WebElement legalDocStatusdrpdn;

	public WebElement legalDocStatusdrpdn() {
		return legalDocStatusdrpdn;
	}

	// Certificate Tab
	@FindBy(css="[id*='supplierHavingInsurance']>a")
	private WebElement SuppInsurancedpdn;

	public WebElement SuppInsurancedpdn() {
		return SuppInsurancedpdn;
	}

	//Business Policy Section
	@FindBy(css="[id*='CRT_600_InfoProvided'] a")
	private WebElement bussnessEthicdpdn;

	public WebElement bussnessEthicdpdn() {
		return bussnessEthicdpdn;
	}

	@FindBy(css="[id*='CRT_600_Uploaded'] a")
	private WebElement bussnessDocuploaddpdn;

	public WebElement bussnessDocuploaddpdn() {
		return bussnessDocuploaddpdn;
	}

	
	// Payment Info Tab

	@FindBy(css="[id*='offerearlypaymentdiscounts'] a")
	private WebElement PaymentOfferDiscdpdn;

	public WebElement PaymentOfferDiscdpdn() {
		return PaymentOfferDiscdpdn;
	}

	@FindBy(css="[id*='paymentTypeSupportedId'] a")
	private WebElement PaymentPaymentTypepdn;

	public WebElement PaymentPaymentTypepdn() {
		return PaymentPaymentTypepdn;
	}

	// Enterprise Generated Data

	// Enterprise-Basic
	@FindBy(css="[id*='supplierInvitedBy'] a")
	private WebElement EnterpriseInvitedByDrpdn;

	public WebElement EnterpriseInvitedByDrpdn() {
		return EnterpriseInvitedByDrpdn;
	}

	@FindBy(css="[id*='isApproved'] a")
	private WebElement EnterpriseApprovedDrpdn;

	public WebElement EnterpriseApprovedDrpdn() {
		return EnterpriseApprovedDrpdn;
	}

	@FindBy(css="[id*='profileStatus'] input")
	private WebElement ProfStatus;

	public WebElement ProfStatus() {
		return ProfStatus;
	}
	
	@FindBy(css="[id*='isProfileManagedBy'] a")
	private WebElement EnterpriseMangedByDrpdn;

	public WebElement EnterpriseMangedByDrpdn() {
		return EnterpriseMangedByDrpdn;
	}
	
	@FindBy(id="agencyName")
	private WebElement EnterpriseSupAgenttxt;

	public WebElement EnterpriseSupAgenttxt() {
		return EnterpriseSupAgenttxt;
	}

	// Enterprise-Supplier Validation
	@FindBy(css="[id*='TaxIDValidationStatus']>a")
	private WebElement TaxIDValidationStatusDropDwn;

	public WebElement TaxIDValidationStatusDropDwn() {
		return TaxIDValidationStatusDropDwn;
	}
	
	//Invite Specific
	@FindBy(css = "[id*='inviteId'] a")
	private WebElement EnterpriseInviteIDDropDwn;

	public WebElement EnterpriseInviteIDDropDwn() {
		return EnterpriseInviteIDDropDwn;
	}

	@FindBy(css = "input[name*='inviteId']")
	private WebElement EnterpriseInviteIDTxt;

	public WebElement EnterpriseInviteIDTxt() {
		return EnterpriseInviteIDTxt;
	}
	
	@FindBy(css = "[id*='inviteProfileStatus'] input")
	private WebElement EnterpriseInviteProfStatus;

	public WebElement EnterpriseInviteProfStatus() {
		return EnterpriseInviteIDDropDwn;
	}

	

	// advance search save query
	
	@FindBy(css="a[href*='viewSavedSearch']")
	private List<WebElement> ListSavedQuery;

	public List<WebElement> ListSavedQuery() {
		return ListSavedQuery;
	}
	
	@FindBy(css="a[class*='run_query']")
	private List<WebElement> ListSavedRunQuery;

	public List<WebElement> ListSavedRunQuery() {
		return ListSavedRunQuery;
	}
	
	@FindBy(css="a[class*='edit open']")
	private List<WebElement> ListEditQuery;

	public List<WebElement> ListEditQuery() {
		return ListEditQuery;
	}
	
	@FindBy(css="#private_queries a[href*='viewSavedSearch']")
	private List<WebElement> ListSavedPrivateQuery;

	public List<WebElement> ListSavedPrivateQuery() {
		return ListSavedPrivateQuery;
	}

	@FindBy(css="#private_queries a[href*='deleteAdvanceSavedSearch']")
	private List<WebElement> ListSavedPrivateQueryDeleteIcon;

	public List<WebElement> ListSavedPrivateQueryDeleteIcon() {
		return ListSavedPrivateQueryDeleteIcon;
	}

	@FindBy(css="[class*='dialog'] button[class='primary']")
	private WebElement Okbtn;

	public WebElement Okbtn() {
		return Okbtn;
	}

	@FindBy(id="save")
	private WebElement saveQrybtn;

	public WebElement saveQrybtn() {
		return saveQrybtn;
	}

	@FindBy(css="input[type='submit'][value*='Search']")
	private WebElement SearchQrybtn;

	public WebElement SearchQrybtn() {
		return SearchQrybtn;
	}

	@FindBy(css="[class*='button_red cancel']")
	private WebElement Cancelbtn;

	public WebElement Cancelbtn() {
		return Cancelbtn;
	}

	@FindBy(css="iframe[src*='loadAdvanceSavedSearch']")
	private WebElement IFRAMEsave;

	public WebElement IFRAMEsave() {
		return IFRAMEsave;
	}

	// specify query name
	@FindBy(id="specify_query")
	private WebElement SAVEqrynamtxt;

	public WebElement SAVEqrynamtxt() {
		return SAVEqrynamtxt;
	}

	// to save a query
	@FindBy(css="input[type='button'][title='Save'")
	private WebElement SAVEsavebtn;

	public WebElement SAVEsavebtn() {
		return SAVEsavebtn;
	}

	@FindBy(css="a[href*='ReportsMainPopup.lvp']")
	private WebElement customexportbtn;

	public WebElement customexportbtn() {
		return customexportbtn;
	}

	@FindBy(css="IFRAME[src*='Reports']")
	private WebElement IFRAMEcustomExport;

	public WebElement IFRAMEcustomExport() {
		return IFRAMEcustomExport;
	}

	@FindBy(css="[id*='template'] a")
	private WebElement customExportTemplatedpdn;

	public WebElement customExportTemplatedpdn() {
		return customExportTemplatedpdn;
	}
	
	//Query Popup
	@FindBy(css="#viewSavedSearch tr:nth-child(1) td:nth-child(2)")
	private WebElement QueryPopupQname;

	public WebElement QueryPopupQname() {
		return QueryPopupQname;
	}
	
	@FindBy(css="#filters strong")
	private WebElement QueryPopupQCriteria;

	public WebElement QueryPopupQCriteria() {
		return QueryPopupQCriteria;
	}
	
	
	// Methods for advanced SEARCH

	public void ActionForSavedQuery(LinkedHashMap<String, String> dataMap) {
		
		String savedQueryName=dataMap.get("saveqryname");		
		
		int noOfQueries = ListSavedQuery().size();
		for (int i = 0; i < noOfQueries; i++) {
			WebElement ele = ListSavedQuery().get(i);
			if (lavanteUtils.getText(ele).startsWith(savedQueryName)
					|| lavanteUtils.getText(ele).contains(savedQueryName)) {
				String x = ele.getAttribute("href");
				String[] sx = x.split("savedSearchID=");
				if(dataMap.containsKey("DeleteQuery")){
					for (int ji = 0; ji < ListSavedPrivateQueryDeleteIcon().size(); ji++) {
						String f = ListSavedPrivateQueryDeleteIcon().get(ji).getAttribute("href");
						if (f.contains(sx[1])) {
							lavanteUtils.click(ListSavedPrivateQueryDeleteIcon().get(ji));
							lavanteUtils.waitForTime(4000);
							lavanteUtils.click(Okbtn);
						}
	
					}
				}
				if(dataMap.containsKey("RunQuery")){
					for (int ji = 0; ji < ListSavedRunQuery().size(); ji++) {
						String f = ListSavedRunQuery().get(ji).getAttribute("href");
						if (f.contains(sx[1])) {
							lavanteUtils.click(ListSavedRunQuery().get(ji));
							lavanteUtils.waitForTime(4000);
							break;
						}
	
					}
				}
				if(dataMap.containsKey("EditQuery")){
					for (int ji = 0; ji < ListEditQuery().size(); ji++) {
						String f = ListEditQuery().get(ji).getAttribute("href");
						if (f.contains(sx[1])) {
							lavanteUtils.click(ListEditQuery().get(ji));
							lavanteUtils.waitForTime(4000);
							break;
						}
	
					}
				}
				if(dataMap.containsKey("OpenQuery")){
					for (int ji = 0; ji < ListSavedQuery().size(); ji++) {
						String f = ListSavedQuery().get(ji).getAttribute("href");
						if (f.contains(sx[1])) {
							lavanteUtils.click(ListSavedQuery().get(ji));
							lavanteUtils.waitForTime(4000);
							lavanteUtils.fluentwait(IFRAMEQryPopup);
							lavanteUtils.switchtoFrame(IFRAMEQryPopup);
							break;
						}
	
					}
				}
			}
		}
	}
	
	public void deleteSavedQueryByName(String savedQueryName) {
		int noOfQueries = ListSavedPrivateQuery().size();
		for (int i = 0; i < noOfQueries; i++) {
			WebElement ele = ListSavedPrivateQuery().get(i);
			if (lavanteUtils.getText(ele).startsWith(savedQueryName)
					|| lavanteUtils.getText(ele).contains(savedQueryName)) {
				String x = ele.getAttribute("href");
				String[] sx = x.split("savedSearchID=");
				for (int ji = 0; ji < ListSavedPrivateQueryDeleteIcon().size(); ji++) {
					String f = ListSavedPrivateQueryDeleteIcon().get(ji).getAttribute("href");
					if (f.contains(sx[1])) {
						lavanteUtils.click(ListSavedPrivateQueryDeleteIcon().get(ji));
						lavanteUtils.fluentwait(Okbtn);
						lavanteUtils.click(Okbtn);
					}

				}

			}
		}
	}

	public void deleteSavedQuery(String savedQueryName) {
		int noOfQueries = ListSavedPrivateQuery().size();
		for (int i = 0; i < noOfQueries; i++) {
			WebElement ele = ListSavedPrivateQuery().get(i);
			if (lavanteUtils.getText(ele).startsWith(savedQueryName)
					|| lavanteUtils.getText(ele).contains(savedQueryName)) {
				String x = ele.getAttribute("href");
				String[] sx = x.split("savedSearchID=");
				for (int ji = 0; ji < ListSavedPrivateQueryDeleteIcon().size(); ji++) {
					String f = ListSavedPrivateQueryDeleteIcon().get(ji).getAttribute("href");
					if (f.contains(sx[1])) {
						lavanteUtils.click(ListSavedPrivateQueryDeleteIcon().get(ji));
						lavanteUtils.fluentwait(Okbtn);
						lavanteUtils.click(Okbtn);
						break;
					}

				}

			}
		}
	}

	public void buildQuery(LinkedHashMap<String, String> dataMap) {
		String x=lavanteUtils.currenttime();
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(buildqrybtn);
		fillDetails(dataMap);
		formAction(dataMap);
		String y=lavanteUtils.currenttime();
		Integer z=Integer.parseInt(y)-Integer.parseInt(x);
		Reporter.log("*************Time Taken for Build Query Supplier Advance Search:"+z+"******",true);
	}

	public void fillDetails(LinkedHashMap<String, String> dataMap) {

		lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		/*lavanteUtils.fluentwait(clearBtn);
		lavanteUtils.click(clearBtn);
		lavanteUtils.waitforPageload(clearBtn);*/
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.fluentwait(clearBtn);
			lavanteUtils.click(clearBtn);
			lavanteUtils.waitForTime(4000);
		}
		//OR Criteria
		if(dataMap.containsKey("filterANY")){
			lavanteUtils.click(filterANY);
		}
		//And Criteria
		if(dataMap.containsKey("filterAll")){
			lavanteUtils.click(filterAll);
		}
		if(dataMap.containsKey("SearchAcrossNW")){
			lavanteUtils.click(searchAcrossNwrk);
		}
		selectTab(dataMap);

	}

	public void selectTab(LinkedHashMap<String, String> dataMap) {
		String tab = null;
		if (dataMap.containsKey("Tab")) {
			tab = dataMap.get("Tab");
			if (tab.contains("#")) {
				String[] s = tab.split("#");
				for (int i = 0; i < s.length; i++) {
					tab = s[i];
					tabs(dataMap, tab);
				}
			} else {

				tabs(dataMap, tab);
			}

		}
	}

	private void tabs(LinkedHashMap<String, String> dataMap, String tab) {
		lavanteUtils.fluentwait(TabSelection);
		if (tab.contains("CompanyProfile")) {
			CompanyProfileFillDetails(dataMap);
		}
		if (tab.contains("Certificate")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("company_cert",TabSelection);
			CertificateFillDetails(dataMap);
		}
		if (tab.contains("Legal")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			CompanyLegalFillDetails(dataMap);
		}
		if (tab.contains("PaymentInfo")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("payment_info",TabSelection);
			PaymentInfoFillDetails(dataMap);
		}
		if (tab.contains("Enterprise")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("eg_data",TabSelection);
			EnterpriseFillDetails(dataMap);
		}
		if (tab.contains("Invite")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("eg_data_invite",TabSelection);
			EnterpriseInviteFillDetails(dataMap);
		}
		if (tab.contains("Tax")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("w8TaxInfo_data",TabSelection);
			TaxFillDetails(dataMap);
		}
		if (tab.contains("CustomerProfile")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("cs_profile",TabSelection);
			CustomerProfileFillDetails(dataMap);
		}
		if (tab.contains("Campaign")) {
			lavanteUtils.selectbyvalue("legal_id",TabSelection);
			lavanteUtils.selectbyvalue("campaign_data",TabSelection);
			CustomerProfileFillDetails(dataMap);
		}
		
	}

	

	// For Company Profile
	private void CompanyProfileFillDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.waitForTime(4000);
		if (dataMap.containsKey("SupplierName")) {
			String data = dataMap.get("SupplierName");
			lavanteUtils.fluentwait(SupplierNamedpdn);
			lavanteUtils.click(SupplierNamedpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
					if (!sp[0].contains("Is")) {
						lavanteUtils.fluentwait(SuppNameTxtbx);
						lavanteUtils.typeinEdit(sp[1], SuppNameTxtbx);
					}

			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}

		}
		if (dataMap.containsKey("AddressType")) {
			String data = dataMap.get("AddressType");
			lavanteUtils.fluentwait(AddressTypedpdn);
			lavanteUtils.click(AddressTypedpdn);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("CityAddress")) {
			String data = dataMap.get("CityAddress");
			lavanteUtils.fluentwait(cityAddressdpdntype);
			lavanteUtils.click(cityAddressdpdntype);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
					if (!sp[0].contains("Is")) {
						lavanteUtils.fluentwait(CityAddTxtbx);
						lavanteUtils.typeinEdit(sp[1], CityAddTxtbx);
					}

			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		if (dataMap.containsKey("CountryAddress")) {
			String data = dataMap.get("CountryAddress");
			lavanteUtils.fluentwait(countryAddressdpdntype);
			lavanteUtils.click(countryAddressdpdntype);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(countryAddressdpdn);
					lavanteUtils.click(countryAddressdpdn);
					lavanteUtils.selectvalueFrmDpdn(sp[1]);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);

				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		if (dataMap.containsKey("StateAddress")) {
			String data = dataMap.get("StateAddress");
			lavanteUtils.fluentwait(stateAddressdpdntype);
			lavanteUtils.click(stateAddressdpdntype);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(stateAddressdpdn);
					lavanteUtils.click(stateAddressdpdn);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.typeString(sp[1], stateAddresstypetext);
					lavanteUtils.selectvalueFrmDpdn(sp[1]);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		//CompanyFAX
		if (dataMap.containsKey("FAX")) {
			String data = dataMap.get("FAX");
			lavanteUtils.fluentwait(Faxdpdn);
			lavanteUtils.click(Faxdpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					FaxTxtbx.clear();
					lavanteUtils.fluentwait(FaxTxtbx);
					lavanteUtils.typeinEdit(sp[1], FaxTxtbx);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		//Supplier EMAIL
		if (dataMap.containsKey("ContactEmail")) {
			String data = dataMap.get("ContactEmail");
			lavanteUtils.fluentwait(Emaildpdn);
			lavanteUtils.Scrollintoview(Emaildpdn);
			lavanteUtils.click(Emaildpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					EmailTxtbx.clear();
					lavanteUtils.fluentwait(EmailTxtbx);
					lavanteUtils.typeinEdit(sp[1], EmailTxtbx);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		//Contact 
		if (dataMap.containsKey("ContactName")) {
			String data = dataMap.get("ContactName");
			lavanteUtils.fluentwait(CNamedpdn);
			lavanteUtils.Scrollintoview(CNamedpdn);
			lavanteUtils.click(CNamedpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					CNameTxtbx.clear();
					lavanteUtils.fluentwait(CNameTxtbx);
					lavanteUtils.typeinEdit(sp[1], CNameTxtbx);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		if (dataMap.containsKey("CContactEmail")) {
			String data = dataMap.get("CContactEmail");
			lavanteUtils.fluentwait(CEmaildpdn);
			lavanteUtils.Scrollintoview(CEmaildpdn);
			lavanteUtils.click(CEmaildpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					CEmailTxtbx.clear();
					lavanteUtils.fluentwait(CEmailTxtbx);
					lavanteUtils.typeinEdit(sp[1], CEmailTxtbx);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		if (dataMap.containsKey("ContactFAX")) {
			String data = dataMap.get("ContactFAX");
			lavanteUtils.fluentwait(CFaxdpdn);
			lavanteUtils.click(CFaxdpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					CFaxTxtbx.clear();
					lavanteUtils.fluentwait(CFaxTxtbx);
					lavanteUtils.typeinEdit(sp[1], CFaxTxtbx);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		
		//Material/Classification

		if (dataMap.containsKey("GeoScope")) {
			String data = dataMap.get("GeoScope");
			lavanteUtils.click(GeoScopedpdn);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("Currency")) {
			String data = dataMap.get("Currency");
			lavanteUtils.click(Currencydpdn);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		

	}

	// For Company Legal fill detail
	private void CompanyLegalFillDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.waitForTime(4000);
		if (dataMap.containsKey("RegCountry")) {
			String data = dataMap.get("RegCountry");
			lavanteUtils.fluentwait(regtypCountrydpdn);
			lavanteUtils.click(regtypCountrydpdn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					//lavanteUtils.fluentwait(regCountrydpdn);
					lavanteUtils.click(regCountrydpdn);
					lavanteUtils.selectContainFrmDpdn(sp[1]);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}

		if (dataMap.containsKey("usincome")) {
			String data = dataMap.get("usincome");
			lavanteUtils.click(USINCOMEDPDN);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		// Business name
		if (dataMap.containsKey("BusinessName")) {
			String data = dataMap.get("BusinessName");
			lavanteUtils.click(BusinessNameDropDwn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					//lavanteUtils.fluentwait(BusinessNameTxtBox);
					lavanteUtils.typeinEdit(sp[1], BusinessNameTxtBox);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		// Business Structure
		if (dataMap.containsKey("BusinessStructure")) {
			lavanteUtils.fluentwait(BusinessStructureDropDwn);
			lavanteUtils.click(BusinessStructureDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("BusinessStructure"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}

		// TaxID Type:
		if (dataMap.containsKey("TaxIDType")) {
			lavanteUtils.fluentwait(regtypCountrydpdn);
			lavanteUtils.click(regtypCountrydpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TaxIDType"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		// Tax ID Number
		if (dataMap.containsKey("TaxIDNumber")) {
			String data = dataMap.get("TaxIDNumber");
			lavanteUtils.click(TaxIDNumberDropDwn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(TaxIDNumberTxtBox);
					lavanteUtils.typeinEdit(sp[1], TaxIDNumberTxtBox);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		if (dataMap.containsKey("LegalIdentifierStatus")) {
			lavanteUtils.fluentwait(LegalIdentifierstatusDropDwn);
			lavanteUtils.click(LegalIdentifierstatusDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("LegalIdentifierStatus"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("LegalDoc")) {
			lavanteUtils.fluentwait(legalDocdrpdn);
			lavanteUtils.click(legalDocdrpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("LegalDoc"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("LegalDocStatus")) {
			lavanteUtils.fluentwait(legalDocStatusdrpdn);
			lavanteUtils.click(legalDocStatusdrpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("LegalDocStatus"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		
	}

	// For Certificate Tab
	private void CertificateFillDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.waitForTime(4000);
		if (dataMap.containsKey("SuppInsurance")) {
			String data = dataMap.get("SuppInsurance");
			lavanteUtils.fluentwait(SuppInsurancedpdn);
			lavanteUtils.click(SuppInsurancedpdn);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("BusinessEthics")) {
			String data = dataMap.get("BusinessEthics");
			lavanteUtils.fluentwait(bussnessEthicdpdn);
			lavanteUtils.click(bussnessEthicdpdn);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("BusinessEthicsUploaded")) {
			String data = dataMap.get("BusinessEthicsUploaded");
			lavanteUtils.fluentwait(bussnessDocuploaddpdn);
			lavanteUtils.click(bussnessDocuploaddpdn);
			lavanteUtils.selectvalueFrmDpdn(data);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
	}

	// For Payment Info
	private void PaymentInfoFillDetails(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("OfferEarlyDiscount")) {
			lavanteUtils.click(PaymentOfferDiscdpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("OfferEarlyDiscount"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("PaymentType")) {
			lavanteUtils.click(PaymentPaymentTypepdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("PaymentType"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
	}

	// For Enterprise Suppliers
	private void EnterpriseFillDetails(LinkedHashMap<String, String> dataMap) {

		//Moved to Invite Tab ,Can be removed
		if (dataMap.containsKey("Approved")) {
			lavanteUtils.fluentwait(EnterpriseApprovedDrpdn);
			lavanteUtils.Scrollintoview(EnterpriseApprovedDrpdn);
			lavanteUtils.click(EnterpriseApprovedDrpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Approved"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}

		if (dataMap.containsKey("ProfStatus")) {
			String data = dataMap.get("ProfStatus");

			if (data.contains("#")) {
				String[] d = data.split("#");
				for (int i = 0; i < d.length; i++) {
					lavanteUtils.Scrollintoview(ProfStatus);
					lavanteUtils.click(ProfStatus);
					//ProfStatus().sendKeys(d[i]);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.Scrollintoview(ProfStatus);
				lavanteUtils.click(ProfStatus);
				//ProfStatus().sendKeys(data);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}

		}
		
		if (dataMap.containsKey("ManagedBy")) {
			String x=dataMap.get("ManagedBy");
			
			lavanteUtils.fluentwait(EnterpriseMangedByDrpdn);
			lavanteUtils.Scrollintoview(EnterpriseMangedByDrpdn);
			lavanteUtils.click(EnterpriseMangedByDrpdn);
			lavanteUtils.selectvalueFrmDpdn(x);
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			if (dataMap.containsKey("SupplierAgent")) {
				lavanteUtils.fluentwait(EnterpriseSupAgenttxt);
				lavanteUtils.typeinEdit(dataMap.get("SupplierAgent"), EnterpriseSupAgenttxt);
			}
			
		}
		
		if (dataMap.containsKey("TaxIDValidationStatus")) {
			lavanteUtils.fluentwait(TaxIDValidationStatusDropDwn);
			lavanteUtils.Scrollintoview(ProfStatus);
			lavanteUtils.click(TaxIDValidationStatusDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("TaxIDValidationStatus"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}

	}

	
	// For Enterprise Invite Tab
	private void EnterpriseInviteFillDetails(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("InviteID")) {
			String data = dataMap.get("InviteID");
			lavanteUtils.click(EnterpriseInviteIDDropDwn);
			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(EnterpriseInviteIDTxt);
					lavanteUtils.typeinEdit(sp[1], EnterpriseInviteIDTxt);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} 
			
		}
		if (dataMap.containsKey("InviteProfStatus")) {
				String data = dataMap.get("InviteProfStatus");
				if (data.contains("#")) {
					String[] d = data.split("#");
					for (int i = 0; i < d.length; i++) {
						lavanteUtils.Scrollintoview(EnterpriseInviteProfStatus);
						lavanteUtils.click(EnterpriseInviteProfStatus);
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.selectvalueFrmDpdn(d[i]);
						lavanteUtils.switchtoFrame(IFRAMEBuildQry);
					}
				} else {
					lavanteUtils.Scrollintoview(EnterpriseInviteProfStatus);
					lavanteUtils.click(EnterpriseInviteProfStatus);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectvalueFrmDpdn(data);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
		}
		if (dataMap.containsKey("Approved")) {
			lavanteUtils.fluentwait(EnterpriseApprovedDrpdn);
			lavanteUtils.Scrollintoview(EnterpriseApprovedDrpdn);
			lavanteUtils.click(EnterpriseApprovedDrpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Approved"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}

		if (dataMap.containsKey("InvitedBY")) {
			lavanteUtils.fluentwait(EnterpriseInvitedByDrpdn);
			lavanteUtils.Scrollintoview(EnterpriseInvitedByDrpdn);
			lavanteUtils.click(EnterpriseInvitedByDrpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("InvitedBY"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
	}

	
	// Customer Profile Fill Details
	private void CustomerProfileFillDetails(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("SupplierERPID")) {
			String data = dataMap.get("SupplierERPID");
			lavanteUtils.fluentwait(SupplierERPIdDropDwn);

			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.click(SupplierERPIdDropDwn);
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(SupplierERPIdTxtBox);
					lavanteUtils.typeinEdit(sp[1], SupplierERPIdTxtBox);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.click(SupplierERPIdDropDwn);
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		
		if (dataMap.containsKey("LocationERPID")) {
			String data = dataMap.get("LocationERPID");
			lavanteUtils.fluentwait(LocationERPIdDropDwn);

			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.click(LocationERPIdDropDwn);
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(LocationERPIdTxtBox);
					lavanteUtils.typeinEdit(sp[1], LocationERPIdTxtBox);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.click(LocationERPIdDropDwn);
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		//Tax Info Section
		if(dataMap.containsKey("ForeignTaxInfoDocW8Provided")){
			lavanteUtils.click(ForeignTaxInfoDocW8ProvidedDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("ForeignTaxInfoDocW8Provided"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if(dataMap.containsKey("ForeignTaxInfoDocStatus")){
			lavanteUtils.click(ForeignTaxInfoDocStatusDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("ForeignTaxInfoDocStatus"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		//Products services Section
		//Product Service Type
		if(dataMap.containsKey("ProductType")){
			lavanteUtils.click(TypeofProductServicedpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("ProductType"));
			lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		}
		if (dataMap.containsKey("ProductServices")) {
			String data = dataMap.get("ProductServices");
			lavanteUtils.fluentwait(ProductServicedpdn);

			if (data.contains(",")) {
				String[] sp = data.split(",");
				lavanteUtils.click(ProductServicedpdn);
				lavanteUtils.selectvalueFrmDpdn(sp[0]);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				if (!sp[0].contains("Is")) {
					lavanteUtils.fluentwait(ProductServicetxtbx);
					lavanteUtils.typeinEdit(sp[1], ProductServicetxtbx);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {
				lavanteUtils.click(ProductServicedpdn);
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}
		}
		
	}

	// For Tax info only
	private void TaxFillDetails(LinkedHashMap<String, String> dataMap) {
		System.out.println(dataMap);
		if (dataMap.containsKey("ValidForm")) {
			String data = dataMap.get("ValidForm");

			if (data.contains("#")) {
				String[] d = data.split("#");
				for (int i = 0; i < d.length; i++) {
					lavanteUtils.click(formValidation);
				//	formValidation.sendKeys(d[i]);
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);

				}
			} else {

				lavanteUtils.click(formValidation);
			//	formValidation.sendKeys(data);
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);

			}

		}

		if (dataMap.containsKey("CTI")) {
			String data = dataMap.get("CTI");

			if (data.contains("#")) {
				String[] d = data.split("#");
				for (int i = 0; i < d.length; i++) {
					lavanteUtils.click(CTI);
				//	CTI().sendKeys(d[i]);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectvalueFrmDpdn(d[i]);
					lavanteUtils.switchtoFrame(IFRAMEBuildQry);
				}
			} else {

				lavanteUtils.click(CTI);
			//	CTI().sendKeys(data);
				lavanteUtils.selectvalueFrmDpdn(data);
				lavanteUtils.switchtoFrame(IFRAMEBuildQry);
			}

		}

	}

	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEBuildQry);
		if (dataMap.containsKey("Search")) {
			lavanteUtils.clickJavaScript(SearchQrybtn);
		}
		if (dataMap.containsKey("SaveQuery")) {
			lavanteUtils.click(saveQrybtn);
			savequery(dataMap);
		}
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.click(Cancelbtn);
		}
		lavanteUtils.waitForTime(4000);
	}

	private void savequery(LinkedHashMap<String, String> dataMap) {

		lavanteUtils.switchtoFrame(IFRAMEsave);
		if (dataMap.containsKey("saveqryname")) {
			lavanteUtils.typeinEdit(dataMap.get("saveqryname"), SAVEqrynamtxt);

		}

		if (dataMap.containsKey("SavetheQuery")) {
			lavanteUtils.click(SAVEsavebtn);
		}

	}

	public void CustomExport(LinkedHashMap<String, String> dataMap) {
		clickCustomExport();

	}

	public void clickCustomExport() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(customexportbtn);
		lavanteUtils.click(customexportbtn);
		lavanteUtils.switchtoFrame(IFRAMEcustomExport);
	}

	public String[] split(String exp) {
		String[] data = new String[3];
		String expString = "";
		if (exp.contains(",")) {
			String[] spdata = exp.split(",");
			data[0] = spdata[0];
			data[1] = spdata[1];
		} else {
			data[0] = exp;
			data[1] = exp;
		}
		return data;
	}

	public String[] SplitSearchdata(String exp){
		String[] data =new String[2];
		if (exp.contains("#")) {
			String[] spdata = exp.split("#");
			data[0] = spdata[0];
			data[1] = spdata[1];
		} else if (exp.contains(",")) {
			String[] spdata = exp.split(",");
			data[0] = spdata[0];
			data[1] = spdata[1];
		} else {
			data[0] = exp;
			data[1] = exp;
		}
		
		return data;

	}
	
	public boolean verifySearch(String exp, String actual) {
		
		boolean flag = false;
		String[] x=SplitSearchdata(exp);
		String data=x[0];
		String expString="";
		if(x.length>0){
			 expString=x[1];
		}
		expString=expString.replace(".0000", "");
		expString=expString.replace(".000", "");
		expString=expString.replace(".00", "");
		
		if (data.equalsIgnoreCase("Equals To")||data.equalsIgnoreCase("EqualsTo")||data.equalsIgnoreCase("Equals")) {
			Reporter.log("Search , Equals To Search ,Expected:" + expString + ",in app:" + actual,true);
			if (expString.equalsIgnoreCase(actual)) {
				flag = true;
			}
		} else if (data.equalsIgnoreCase("Not Equal To")) {
			Reporter.log("Search ,Not Equals To Search Expected:" + expString + "should not match,in app:" + actual,true);
			if (!expString.equalsIgnoreCase(actual)) {
				flag = true;
			}
		} else if (data.equalsIgnoreCase("Is Empty")) {
			Reporter.log("Search ,Is Empty Search ,Expected:Empty Value,in app:" + actual,true);
			if (actual.length() == 0) {
				flag = true;
			}
		}  else if (data.equalsIgnoreCase("IN")) {
			Reporter.log("Search ,IN  Search ,Expected::" + expString + ",in app:" + actual,true);
			if (expString.contains(actual)) {
				flag = true;
			}
		} else {
			Reporter.log("Search ,Is Empty Search ,Expected:" + data + ", Value,in app:" + actual,true);
			if (data.equalsIgnoreCase(actual)) {
				flag = true;
			}
		}
		return flag;

	}

}
