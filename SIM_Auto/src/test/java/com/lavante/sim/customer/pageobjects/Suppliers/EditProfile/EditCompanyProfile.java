/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class EditCompanyProfile {

	public WebDriver driver;
	LavanteUtils lavanteUtils = new LavanteUtils();;

	public EditCompanyProfile(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}

	// Your Company Information

	@FindBy(id="edit_country")
	private WebElement EditCountryOfRegi;

	public WebElement EditCountryOfRegi() {
		return EditCountryOfRegi;
	}

	@FindBy(css="div[id*='country'] a")
	private WebElement CountryOfRegiDropDwn;

	public WebElement CountryOfRegiDropDwn() {
		return CountryOfRegiDropDwn;
	}

	@FindBy(css="div[id*='majorityOwnershipCountry'] a")
	private WebElement MajorityOwnershipDropDwn;

	public WebElement MajorityOwnershipDropDwn() {
		return MajorityOwnershipDropDwn;
	}

	@FindBy(xpath="//span[starts-with(text(),'Confirm')]/parent::div[1]/following-sibling::div[1]")
	private WebElement GetConfirmPopUpMsg;

	public WebElement GetConfirmPopUpMsg() {
		return GetConfirmPopUpMsg;
	}

	@FindBy(css="iframe[src*='changeCountryOfRegistration']")
	private WebElement IFRAMECountryofReg;

	public WebElement IFRAMECountryofReg() {
		return IFRAMECountryofReg;
	}

	@FindBy(css="[id='taxIDType_1']")
	private WebElement EINRadioBtn;

	public WebElement EINRadioBtn() {
		return EINRadioBtn;
	}

	@FindBy(css="[id='taxIDType_2']")
	private WebElement SSNRadioBtn;

	public WebElement SSNRadioBtn() {
		return SSNRadioBtn;
	}

	@FindBy(css="[id='legalIdentifier']")
	private WebElement EINTxtBox;

	public WebElement EINTxtBox() {
		return EINTxtBox;
	}

	@FindBy(css="button[ng-click*='addNewLocation']")
	private WebElement AddAddress;

	public WebElement AddAddress() {
		return AddAddress;
	}

	@FindBy(css="a[href*='deleteLocationAndContactsDetails']")
	private List<WebElement> Listdeladdress;

	public List<WebElement> Listdeladdress() {
		return Listdeladdress;
	}

	@FindBy(css="div[class*='dialog'] button[class*='primary']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}

	@FindBy(css="input[data-label*='Location ERP']")
	private List<WebElement> ListERPID;

	public List<WebElement> ListERPID() {
		return ListERPID;
	}

	@FindBy(css="[id*='addressType']")
	private List<WebElement> ListLocatnType;

	public List<WebElement> ListLocatnType() {
		return ListLocatnType;
	}

	@FindBy(css="[id*='supplierAddressMapId']")
	private List<WebElement> LisLocatnaddress;

	public List<WebElement> LisLocatnaddress() {
		return LisLocatnaddress;
	}

	@FindBy(css="a[href*='addEditAddress']")
	private List<WebElement> ListAddAddress;

	public List<WebElement> ListAddAddress() {
		return ListAddAddress;
	}

	@FindBy(css="iframe[src*='addEditAddress']")
	private WebElement IFRAMEaddeditAddress;

	public WebElement IFRAMEaddeditAddress() {
		return IFRAMEaddeditAddress;
	}

	@FindBy(id="address1")
	private WebElement addrestxt;

	public WebElement addrestxt() {
		return addrestxt;
	}

	@FindBy(id="city")
	private WebElement citytxt;

	public WebElement citytxt() {
		return citytxt;
	}

	@FindBy(id="countryId_chosen")
	private WebElement countryId_chosen;

	public WebElement countryId_chosen() {
		return countryId_chosen;
	}

	@FindBy(id="stateId_chosen")
	private WebElement stateId_chosen;

	public WebElement stateId_chosen() {
		return stateId_chosen;
	}

	@FindBy(id="zipCode")
	private WebElement zipCode;

	public WebElement zipCode() {
		return zipCode;
	}

	@FindBy(css="[type*='submit']")
	private WebElement savebtn;

	public WebElement savebtn() {
		return savebtn;
	}

	@FindBy(xpath="//div[starts-with(text(),'The address provided by you is invalid.')]")
	private WebElement saveThisTxt;

	public WebElement saveThisTxt() {
		return saveThisTxt;
	}

	// Contact

	@FindBy(css="[id*='supplierContactId']")
	private List<WebElement> ListContact;

	public List<WebElement> ListContact() {
		return ListContact;
	}
	
	
	@FindBy(css="[id*='contact'] option[selected]")
	private List<WebElement> ListSelectedContact;

	public List<WebElement> ListSelectedContact() {
		return ListSelectedContact;
	}
			
	@FindBy(css="[href*='addEditContact']")
	private List<WebElement> ListAddContactbtn;

	public List<WebElement> ListAddContactbtn() {
		return ListAddContactbtn;
	}

	@FindBy(css="iframe[src*='addEditContact']")
	private WebElement IFRAMEaddeditContact;

	public WebElement IFRAMEaddeditContact() {
		return IFRAMEaddeditContact;
	}

	@FindBy(id="contactName")
	private WebElement contactName;

	public WebElement contactName() {
		return contactName;
	}

	@FindBy(id="email")
	private WebElement email;

	public WebElement email() {
		return email;
	}

	// NEW

	@FindBy(xpath="//*[@class='address-section ng-scope']/input[@type='radio']")
	private List<WebElement> ListaddressListrdbtn;

	public List<WebElement> ListaddressListrdbtn() {
		return ListaddressListrdbtn;
	}

	@FindBy(xpath="//*[@class='address-section ng-scope']/select")
	private List<WebElement> ListaddressListdrpdn;

	public List<WebElement> ListaddressListdrpdn() {
		return ListaddressListdrpdn;
	}

	@FindBy(xpath="//*[@class='address-section ng-scope']//input[contains(@ng-click,'locationTypeNode')]")
	private List<WebElement> ListLocationTyperdbdtn;

	public List<WebElement> ListLocationTyperdbdtn() {
		return ListLocationTyperdbdtn;
	}

	@FindBy(xpath="//*[@class='address-section ng-scope']//select[contains(@id,'locat')]")
	private List<WebElement> ListLocationTypedpdn;

	public List<WebElement> ListLocationTypedpdn() {
		return ListLocationTypedpdn;
	}

	@FindBy(xpath="//*[@class='address-section ng-scope']//input[contains(@ng-click,'contactNode')]")
	private List<WebElement> ListContactrdbdtn;

	public List<WebElement> ListContactrdbdtn() {
		return ListContactrdbdtn;
	}

	@FindBy(xpath="//*[@class='address-section ng-scope']//select[contains(@id,'contact_')]")
	private List<WebElement> ListContactTypedpdn;

	public List<WebElement> ListContactTypedpdn() {
		return ListContactTypedpdn;
	}

	@FindBy(xpath="//*[@class='address-section ng-scope']//select[contains(@id,'contactType')]")
	private List<WebElement> ListContactsContactTypedpdn;

	public List<WebElement> ListContactsContactTypedpdn() {
		return ListContactsContactTypedpdn;
	}

	@FindBy(css="button[ng-click*='addressNode'][ng-click*='add']")
	private List<WebElement> AddNode;

	public List<WebElement> AddNode() {
		return AddNode;
	}

	@FindBy(css="a[ng-click*='addressNode'][ng-click*='remove']")
	private List<WebElement> DeleteNode;

	public List<WebElement> DeleteNode() {
		return DeleteNode;
	}

	@FindBy(css="div[class*='card'] a[href*='manageContacts']")
	private WebElement ManageSupplierContactsBtn;

	public WebElement ManageSupplierContactsBtn() {
		return ManageSupplierContactsBtn;
	}

	@FindBy(css="a[href*='manageAddress']")
	private WebElement AddressTab;

	public WebElement AddressTab() {
		return AddressTab;
	}

	// Company Additional Info

	@FindBy(css="[id*='numberOfEmployees'] a")
	private WebElement noofEmployeedpdn;

	public WebElement noofEmployeedpdn() {
		return noofEmployeedpdn;
	}

	@FindBy(css="[id*='annualSales'] a")
	private WebElement annualSaledpdn;

	public WebElement annualSaledpdn() {
		return annualSaledpdn;
	}

	// NAICS
	@FindBy(id="addPrimaryNAICS")
	private WebElement primaryNaicsCode;
	public WebElement primaryNaicsCode() {
		return primaryNaicsCode;
	}

	@FindBy(css="iframe[src*='getNACE']")
	private WebElement iframeNAICS;
	public WebElement iframeNAICS() {
		return iframeNAICS;
	}

	@FindBy(css="a:nth-child(3)")
	private List<WebElement> HeaderExpandNAICS;
	public List<WebElement> HeaderExpandNAICS() {
		return HeaderExpandNAICS;
	}

	@FindBy(css="span[class*='expander']")
	private List<WebElement> headerexpander;

	public List<WebElement> headerexpander() {
		return headerexpander;
	}

	@FindBy(css="a:nth-child(4)")
	private List<WebElement> HeaderChildNAICS;

	public List<WebElement> HeaderChildNAICS() {
		return HeaderChildNAICS;
	}

	@FindBy(xpath="//span[@class='dynatree-checkbox']/..")
	private List<WebElement> childcheckboxAttribute;

	@FindBy(css="span[class*='checkbox']")
	private List<WebElement> childcheckbox;

	public List<WebElement> childcheckbox() {
		return childcheckbox;
	}

	@FindBy(css="button[href*='secondary']")
	private WebElement secondaryNaicsCode;

	public WebElement secondaryNaicsCode() {
		return secondaryNaicsCode;
	}

	@FindBy(css="button[id*='save']")
	private WebElement Savebtn;

	public WebElement Savebtn() {
		return Savebtn;
	}

	@FindBy(css="div[class*='bannerMessage']")
	private WebElement dialogmsg;

	public WebElement dialogmsg() {
		return dialogmsg;
	}
	
	@FindBy(css="button[id*='cancel']")
	private WebElement cancelbtn;
	public WebElement cancelbtn() {
		return cancelbtn;
	}
	
	@FindBy(id="searchNodeText")
	private WebElement naicssearchtxt;
	public WebElement naicssearchtxt() {
		return naicssearchtxt;
	}
	
	@FindBy(css="button[class*='primary']")
	private WebElement searchbtn;
	public WebElement naicssearchbtn() {
		return searchbtn;
	}
	
	// End NAICS
	//UNSPSC
	
	@FindBy(css="button[href*='UNSPSC']")
	private WebElement addUNSPSCCode;
	public WebElement addUNSPSCCode() {
		return addUNSPSCCode;
	}

	//ENDUNSPC
	
	//NACE
	
	@FindBy(css="button[href*='NACE']")
	private WebElement addNACECode;
	public WebElement addNACECode() {
		return addNACECode;
	}

	//END NACE
	

	@FindBy(css="a[href*='supplierCompanyDetails']")
	private WebElement editBtn;

	public WebElement editBtn() {
		return editBtn;
	}

	@FindBy(css="a[class*='icon_edit']")
	private List<WebElement> ListEditBtn;

	public List<WebElement> ListEditBtn() {
		return ListEditBtn;
	}

	// Tax W9 section

	@FindBy(css = "#w9Tax_information")
	private WebElement GetW9SecHeader;

	public WebElement GetW9SecHeader() {
		return GetW9SecHeader;
	}

	@FindBy(css = "a[href*='addSupplierw9Doc']")
	private WebElement W9UploadDocumentBtn;

	public WebElement W9UploadDocumentBtn() {
		return W9UploadDocumentBtn;
	}

	@FindBy(css="iframe[src*='addSupplierw9Doc']")
	private WebElement IframeW9DocUpload;

	public WebElement IframeW9DocUpload() {
		return IframeW9DocUpload;
	}

	@FindBy(id="multipartFile")
	private WebElement BrowseTaxW9Btn;

	public WebElement BrowseTaxW9Btn() {
		return BrowseTaxW9Btn;
	}

	@FindBy(css="div[id*='dialog'] input[class='button_primary']")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}

	@FindBy(css="table[id*='table_w9Tax_information'] a[href*='downloadFile']")
	private List<WebElement> GetW9TaxUploadedFilesList;

	public List<WebElement> GetW9TaxUploadedFilesList() {
		return GetW9TaxUploadedFilesList;
	}

	@FindBy(css="table[id*='table_w9Tax_information'] td:nth-child(5)")
	private List<WebElement> GetW9TaxUploadedStatusList;

	public List<WebElement> GetW9TaxUploadedStatusList() {
		return GetW9TaxUploadedStatusList;
	}

	@FindBy(css="table[id*='table_w9Tax_information'] td:nth-child(6) a")
	private List<WebElement> GetW9TaxUploadedActionList;

	public List<WebElement> GetW9TaxUploadedActionList() {
		return GetW9TaxUploadedActionList;
	}

	@FindBy(css="[class*='dialog'] [class*='green']")
	private WebElement OkBtn;

	public WebElement OkYesBtn() {
		return OkBtn;
	}
	
	// Your Company's Additional Profile Information
	
	@FindBy(css="#isDunsNumberExists[value='false']")
	private WebElement DunsNumNoRadioBtn;

	public WebElement DunsNumNoRadioBtn() {
		return DunsNumNoRadioBtn;
	}
	
	
	// Your Company's Diversity Information

	@FindBy(css="#diverse_business_enterprise")
	private WebElement getCompanyDiversityInfoLabel1;

	public WebElement getCompanyDiversityInfoLabel1() {
		return getCompanyDiversityInfoLabel1;
	}

	@FindBy(css="#small_business_classification")
	private WebElement getCompanyDiversityInfoLabel2;

	public WebElement getCompanyDiversityInfoLabel2() {
		return getCompanyDiversityInfoLabel2;
	}

	@FindBy(css="#DBEnterpriseYes~label[for='DBEnterpriseYes']")
	private WebElement DiverseDisadBusinessYesRadioBtn;

	public WebElement DiverseDisadBusinessYesRadioBtn() {
		return DiverseDisadBusinessYesRadioBtn;
	}

	@FindBy(css="#DBEnterpriseNo~label[for='DBEnterpriseNo']")
	private WebElement DiverseDisadBusinessNoRadioBtn;

	public WebElement DiverseDisadBusinessNoRadioBtn() {
		return DiverseDisadBusinessNoRadioBtn;
	}

	
	@FindBy(id="minorityBusinessEnterprise")
	private WebElement InputMinorityChkBox;

	public WebElement InputMinorityChkBox() {
		return InputMinorityChkBox;
	}
	
	@FindBy(css="#minorityBusinessEnterprise~label[for='minorityBusinessEnterprise']")
	private WebElement MinorityChkBox;

	public WebElement MinorityChkBox() {
		return MinorityChkBox;
	}

	@FindBy(css="[id*='ethnicity'] input")
	private WebElement EthnicityDropDwn;

	public WebElement EthnicityDropDwn() {
		return EthnicityDropDwn;
	}

	@FindBy(css="div[id*='ethnicity'] a[class*='close']")
	private List<WebElement> ClearEthnicityDropDwn;

	public List<WebElement> ClearEthnicityDropDwn() {
		return ClearEthnicityDropDwn;
	}

	@FindBy(css="#ethnicityOther")
	private WebElement SpecifyEthnicityTxtBox;

	public WebElement SpecifyEthnicityTxtBox() {
		return SpecifyEthnicityTxtBox;
	}

	// Your Company's Financial information

	@FindBy(css="#publiclyTradedYes~label[for*='publiclyTradedYes']")
	private WebElement PubliclyTradedYesRadioBtn;

	public WebElement PubliclyTradedYesRadioBtn() {
		return PubliclyTradedYesRadioBtn;
	}

	@FindBy(css="#exchangeTradedOn_chosen input")
	private WebElement ExchangeTradedOnDropDwn;

	public WebElement ExchangeTradedOnDropDwn() {
		return ExchangeTradedOnDropDwn;
	}

	@FindBy(css="div[id*='exchangeTradedOn'] a")
	private List<WebElement> ClearExchangeTradedOnDropDwn;

	public List<WebElement> ClearExchangeTradedOnDropDwn() {
		return ClearExchangeTradedOnDropDwn;
	}

	// Tax W9 section
	public void uploadW9TaxDocument(LinkedHashMap<String, String> dataMap) throws Exception {

		lavanteUtils.switchtoFrame(IframeW9DocUpload);
		if (dataMap.containsKey("FileName")) {
			lavanteUtils.uploadFile(dataMap.get("FileName"), BrowseTaxW9Btn);
		}
		lavanteUtils.click(SaveBtn);
		lavanteUtils.switchtoFrame(null);
	}

	// End of Naics Selection

	// End of Company Additional Info

	public LinkedHashMap<String, String> AddLocationContact(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String> entereddata = new LinkedHashMap<String, String>();

		lavanteUtils.fluentwait(AddNode.get(0));
		lavanteUtils.waitForTime(7000);
		// lavanteUtils.fluentwait(ListaddressListrdbtn.get(0));

		if (dataMap.containsKey("DelPrevious")) {
			if(DeleteNode.size()>1){
			for (int i = 0; i < ListaddressListrdbtn.size(); i++) {
					String HQStatus = ListLocationTypedpdn.get(0).getAttribute("disabled");
					
						if(HQStatus==null||!HQStatus.contains("disabled")){
							lavanteUtils.click(ListaddressListrdbtn.get(i));
							lavanteUtils.click(DeleteNode.get(0));
							//lavanteUtils.click(OKbtn);
							lavanteUtils.fluentwait(AddNode.get(0));
						}
				}
			}

			for (int i = 0; i < ListLocationTypedpdn.size(); i++) {
				if(ListLocationTypedpdn.size()>1){
				String HQStatus = ListLocationTypedpdn.get(i).getAttribute("disabled");
					if (!HQStatus.contains("disabled")) {
						lavanteUtils.click(ListLocationTyperdbdtn.get(i));
						lavanteUtils.click(DeleteNode.get(0));
					//	lavanteUtils.click(OKbtn);
					}
				}
			}
			
			for (int i = 0; i < ListContactrdbdtn.size(); i++) {
				if(ListContactrdbdtn.size()>1){
					if (ListContactTypedpdn.size() > 1) {
						lavanteUtils.click(ListContactrdbdtn.get(i));
						lavanteUtils.click(DeleteNode.get(0));
					//	lavanteUtils.click(OKbtn);
					}
				}
			}

			int x = 0;
			if (dataMap.containsKey("AddNode")) {

				entereddata = detailsAddress(dataMap, x);
		/*		x = 1;
				lavanteUtils.click(ListaddressListrdbtn.get(0));
				lavanteUtils.click(AddNode);
				lavanteUtils.fluentwait(ListaddressListdrpdn.get(1));
				entereddata = detailsAddress(dataMap, x);*/

			} else {
				lavanteUtils.click(ListaddressListrdbtn.get(0));
				entereddata = detailsAddress(dataMap, x);
			}
		}

		return entereddata;
	}

	public LinkedHashMap<String, String> detailsAddress(LinkedHashMap<String, String> dataMap, int x) {
		LinkedHashMap<String, String> enter = new LinkedHashMap<String, String>();
		if (dataMap.containsKey("AddAddress")) {
			String addAddress = dataMap.get("AddAddress");
			lavanteUtils.fluentwait(ListaddressListdrpdn.get(x));
			if (addAddress.equalsIgnoreCase("Add New")) {
				lavanteUtils.selectbyvisibiletxt(addAddress, ListaddressListdrpdn.get(x));
				enter = AddAddress(dataMap);
			} else {
				Select s = new Select(ListaddressListdrpdn.get(x));
				String xd = s.getFirstSelectedOption().getText();
				lavanteUtils.selectbyvisibiletxt(xd, ListaddressListdrpdn.get(x));
			}
		}
		
		if (dataMap.containsKey("LocationType")) {
			String d = dataMap.get("LocationType");
			d = dataMap.get("LocationType");
			if (!d.equalsIgnoreCase("HeadQuarters")) {
				lavanteUtils.fluentwait(ListLocationTypedpdn.get(x));
				lavanteUtils.selectbyvisibiletxt(d, ListLocationTypedpdn.get(x));
			}
		}
		
		if (dataMap.containsKey("AddContact")) {
			String AddContact = dataMap.get("AddContact");
			lavanteUtils.fluentwait(ListContactTypedpdn.get(x));
			if (AddContact.equalsIgnoreCase("Add New")) {
				lavanteUtils.selectbyvisibiletxt(AddContact, ListContactTypedpdn.get(x));
				AddContact(dataMap);
			} else {
				lavanteUtils.selectbyvisibiletxt(AddContact, ListContactTypedpdn.get(x));
			}
		}
		if (dataMap.containsKey("ContactType")) {
			String ContactType = dataMap.get("ContactType");
			lavanteUtils.fluentwait(ListContactsContactTypedpdn.get(x));
			lavanteUtils.selectbyvisibiletxt(ContactType, ListContactsContactTypedpdn.get(x));
		}
		
		
		
		return enter;

	}

	private LinkedHashMap<String, String> AddAddress(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String> entereddata = new LinkedHashMap<>();
		lavanteUtils.switchtoFrame(IFRAMEaddeditAddress);
		if (dataMap.containsKey("Address1")) {
			String add1=dataMap.get("Address1");
			if(add1.equalsIgnoreCase("Any")){
				add1="Add1" + lavanteUtils.randomnum();
			}
			lavanteUtils.typeString(add1, addrestxt);
			entereddata.put("Address1",add1 );
		}
		if (dataMap.containsKey("City")) {
			String city=dataMap.get("City");
			if(city.equalsIgnoreCase("Any")){
				city="AddCity" + lavanteUtils.randomnum();
			}
			lavanteUtils.typeString(city, citytxt);
			entereddata.put("City",city );
		}
		if (dataMap.containsKey("Country")) {
			lavanteUtils.click(countryId_chosen);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Country"));
			entereddata.put("Country", dataMap.get("Country"));
			lavanteUtils.switchtoFrame(IFRAMEaddeditAddress);
		}
		if (dataMap.containsKey("State")) {
			lavanteUtils.click(stateId_chosen);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("State"));
			lavanteUtils.switchtoFrame(IFRAMEaddeditAddress);
			entereddata.put("State", dataMap.get("State"));
		}
		if (dataMap.containsKey("PostalCode")) {
			String postalCode=dataMap.get("PostalCode");
			if(postalCode.equalsIgnoreCase("Any")){
				postalCode="PC" + lavanteUtils.randomnum();
			}
			lavanteUtils.typeString(postalCode, zipCode);
			entereddata.put("PostalCode",postalCode );
		}
		if (dataMap.containsKey("AddAddress")) {
			lavanteUtils.click(savebtn);
			lavanteUtils.switchtoFrame(null);
		}

		return entereddata;
	}

	private LinkedHashMap<String, String> AddContact(LinkedHashMap<String, String> dataMap) {

		lavanteUtils.switchtoFrame(IFRAMEaddeditContact);
		if (dataMap.containsKey("Name")) {
			lavanteUtils.typeString(dataMap.get("Name"), contactName);
		}
		if (dataMap.containsKey("Email")) {
			String data = dataMap.get("Email");
			if (data.equalsIgnoreCase("ANY")) {
				data = LavanteUtils.randomnum() + "@SP.com";
			}
			lavanteUtils.typeString(data, email);
		}
		if (dataMap.containsKey("AddContact")) {
			lavanteUtils.click(savebtn);
			lavanteUtils.switchtoFrame(null);
		}
		return dataMap;
	}
	/*
	 * public LinkedHashMap<String, String>
	 * AddLocationContact(LinkedHashMap<String, String> dataMap) {
	 * LinkedHashMap<String, String> entereddata=new LinkedHashMap<String,
	 * String>(); lavanteUtils.fluentwait(AddAddress);
	 * lavanteUtils.click(AddAddress); lavanteUtils.waitForTime(4000);
	 * lavanteUtils.fluentwait(AddAddress);
	 * entereddata=fillAddLocationContact(dataMap); return entereddata; }
	 */

	private LinkedHashMap<String, String> fillAddLocationContact(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String> entereddata = new LinkedHashMap<String, String>();
		if (dataMap.containsKey("DelPrevious")) {
			int size = Listdeladdress.size();
			for (int i = 0; i < size; i++) {
				lavanteUtils.waitForTime(4000);
				lavanteUtils.click(Listdeladdress.get(0));
			//	lavanteUtils.fluentwait(OKbtn);
			//	lavanteUtils.click(OKbtn);
				lavanteUtils.waitForTime(4000);
			}
		}

		if (dataMap.containsKey("AddAddress")) {
			lavanteUtils.click(AddAddress);
			lavanteUtils.fluentwait(ListERPID.get(0));
			if (Listdeladdress.size() == 0) {

			} else {

			}
		}

		if (dataMap.containsKey("ERPID")) {

			if (dataMap.containsKey("AddAddress")) {
				for (int i = 0; i < ListERPID.size(); i++) {
					lavanteUtils.typeString(dataMap.get("ERPID"), ListERPID.get(0));
				}
			}
		}
		if (dataMap.containsKey("LocationType")) {
			if (dataMap.containsKey("AddAddress")) {
				for (int i = 0; i < ListERPID.size(); i++) {
					// lavanteUtils.click(ListLocatnType().get(0));
					lavanteUtils.fluentwait(ListLocatnType.get(0));
					lavanteUtils.selectbyvisibiletxt(dataMap.get("LocationType"), ListLocatnType.get(0));
				}
			}
		}
		if (dataMap.containsKey("Address")) {
			if (dataMap.containsKey("AddAddress")) {
				for (int i = 0; i < ListERPID.size();) {
					lavanteUtils.click(ListAddAddress.get(0));
					lavanteUtils.switchtoFrame(IFRAMEaddeditAddress);
					if (dataMap.containsKey("Address1")) {
						entereddata.put("Address1", lavanteUtils.typeString(dataMap.get("Address1"), addrestxt));
					}
					if (dataMap.containsKey("City")) {
						entereddata.put("City", lavanteUtils.typeString(dataMap.get("City"), citytxt));
					}
					if (dataMap.containsKey("Country")) {
						lavanteUtils.click(countryId_chosen);
						lavanteUtils.selectvalueFrmDpdn(dataMap.get("Country"));
						entereddata.put("Country", dataMap.get("Country"));
						lavanteUtils.switchtoFrame(IFRAMEaddeditAddress);
					}
					if (dataMap.containsKey("State")) {
						lavanteUtils.click(stateId_chosen);
						lavanteUtils.selectvalueFrmDpdn(dataMap.get("State"));
						lavanteUtils.switchtoFrame(IFRAMEaddeditAddress);
						entereddata.put("State", dataMap.get("State"));
					}
					if (dataMap.containsKey("PostalCode")) {
						entereddata.put("PostalCode", lavanteUtils.typeString(dataMap.get("PostalCode"), zipCode));
					}
					if (dataMap.containsKey("AddAddress")) {
						lavanteUtils.click(savebtn);
						lavanteUtils.switchtoFrame(null);
				//		lavanteUtils.click(OKbtn);
					}
					break;

				}
			} else {
				for (int i = 0; i < LisLocatnaddress.size(); i++) {
					lavanteUtils.fluentwait(LisLocatnaddress.get(0));
					lavanteUtils.selectbyvisibiletxt(dataMap.get("Address"), LisLocatnaddress.get(0));
				}
			}
		}
		if (dataMap.containsKey("Contact")) {
			if (dataMap.containsKey("AddContact")) {
				for (int i = 0; i < ListERPID.size();) {
					lavanteUtils.fluentwait(ListAddContactbtn.get(0));
					lavanteUtils.click(ListAddContactbtn.get(0));
					lavanteUtils.switchtoFrame(IFRAMEaddeditContact);
					if (dataMap.containsKey("Name")) {
						lavanteUtils.typeString(dataMap.get("Name"), contactName);
					}
					if (dataMap.containsKey("Email")) {
						String data = dataMap.get("Email");
						if (data.equalsIgnoreCase("ANY")) {
							data = LavanteUtils.randomnum() + "@SP.com";
						}
						lavanteUtils.typeString(data, email);
					}
					if (dataMap.containsKey("AddContact")) {
						lavanteUtils.click(savebtn);
						lavanteUtils.switchtoFrame(null);
					}
					break;
				}
			} else {
				for (int i = 0; i < ListContact.size(); i++) {
					lavanteUtils.fluentwait(ListContact.get(0));
					lavanteUtils.selectbyvisibiletxt(dataMap.get("Contact"), ListContact.get(0));
				}
			}
		}
		return entereddata;

	}

	// Comapny Additional Info
	public void diversitySection(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("NoofEmployee")) {
			lavanteUtils.click(noofEmployeedpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("NoofEmployee"));
		}
		if (dataMap.containsKey("AnnualSales")) {
			lavanteUtils.click(annualSaledpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("AnnualSales"));
		}

		if (dataMap.containsKey("MinorityChkBox")) {
			lavanteUtils.fluentwait(DiverseDisadBusinessYesRadioBtn);
			lavanteUtils.click(DiverseDisadBusinessYesRadioBtn);
			
			String x=InputMinorityChkBox.getAttribute("Checked");
			if(x==null&&dataMap.get("MinorityChkBox").equalsIgnoreCase("YES")){
				lavanteUtils.click(MinorityChkBox);
				}
			{
			
				
			}

		}
	}

	public void fillCompanyAdditionalInfo(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("CountryOfRegistration")) {
			if (lavanteUtils.isElementDisplayed(EditCountryOfRegi)) {
				lavanteUtils.click(EditCountryOfRegi);
			}
			lavanteUtils.fluentwait(CountryOfRegiDropDwn);
			lavanteUtils.click(CountryOfRegiDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("CountryOfRegistration"));
		}
		if (dataMap.containsKey("MajorityOwnership")) {
			lavanteUtils.fluentwait(MajorityOwnershipDropDwn);
			lavanteUtils.click(MajorityOwnershipDropDwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("MajorityOwnership"));
		}

	}

	public void createPrimaryNaics(LinkedHashMap<String, String> dataMap)	throws FileNotFoundException, IOException, SQLException {

		lavanteUtils.click(primaryNaicsCode);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(iframeNAICS);
		lavanteUtils.waitForTime(4000);

		fillNAICS(dataMap);
		formActionNAICS(dataMap);

	}

	public void fillNAICS(LinkedHashMap<String, String> dataMap) {

		int hsize = HeaderExpandNAICS.size();
		int csize = HeaderChildNAICS.size();
		if (dataMap.containsKey("ParentNAICS") && dataMap.containsKey("ParentNAICS")|| dataMap.containsKey("CountNAICS")) {
			String expheaders = dataMap.get("ParentNAICS");
			String expChild = dataMap.get("ChildNAICS");
			int count = 0;
			boolean found = false;
			String header = "";
			outr: while (hsize > 0 && count < Integer.parseInt(dataMap.get("CountNAICS"))) {
				hsize = HeaderExpandNAICS.size();
				csize = HeaderChildNAICS.size();
				System.out.println(header + expheaders);
				System.out.println(expheaders.contains(header));
				for (int i = 0; i < hsize; i++) {
					if (csize > 0) {
						for (int j = 0; j < csize; j++) {
							String childheader = HeaderChildNAICS.get(j).getText().trim();
							childheader = HeaderChildNAICS.get(j).getText().trim();
							if(childheader.contains(" - ")){
								String[] x=childheader.split(" - ");
								childheader=x[1];
							}
							if (expChild.contains(childheader)) {
								// To not remove the checked
								if (!childcheckboxAttribute.get(j).getAttribute("class").contains("selected")) {
									lavanteUtils.click(childcheckbox.get(j));
									found=true;
									count = count + 1;
									if (count == Integer.parseInt(dataMap.get("CountNAICS"))) {
										break outr;
									}
								}
							}
						}
					}
					header = HeaderExpandNAICS.get(i).getText().trim();
					if(header.contains(" - ")){
						String[] x=header.split(" - ");
						header=x[1];
					}
					if (expheaders.contains(header)) {
						//lavanteUtils.Scrollintoview(headerexpander().get(i));
						//lavanteUtils.click(headerexpander().get(i));
						headerexpander.get(i).click();
						lavanteUtils.waitForTime(2000);
						hsize = HeaderExpandNAICS.size();
						csize = HeaderChildNAICS.size();
					}
				}
				count =10;
			}
		}

	}

	private void formActionNAICS(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("SaveNAICS")) {
			lavanteUtils.click(Savebtn);
			if (dataMap.containsKey("ErrorMsg")) {

			}
		}

		lavanteUtils.switchtoFrame(null);
	}

	public void createSecondaryNaics(LinkedHashMap<String, String> dataMap)
			throws FileNotFoundException, IOException, SQLException {

		lavanteUtils.fluentwait(secondaryNaicsCode);
		lavanteUtils.click(secondaryNaicsCode);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(iframeNAICS);
		lavanteUtils.waitForTime(4000);

		fillNAICS(dataMap);
		formActionNAICS(dataMap);

	}

	
	public void SearchNAICS(LinkedHashMap<String, String> dataMap){
		lavanteUtils.switchtoFrame(iframeNAICS);
		if(dataMap.containsKey("SearchKey")){
			naicssearchtxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("SearchKey"), naicssearchtxt);
		}
		if(dataMap.containsKey("Search")){
			lavanteUtils.click(searchbtn);
			lavanteUtils.waitForTime(4000);
		}
	}
	
	
	
}
