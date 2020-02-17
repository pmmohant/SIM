/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class EditProfLegalID {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public EditProfLegalID(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css="[id*='country_chosen'] a")
	private WebElement countryofReg;

	public WebElement countryofReg() {
		return countryofReg;
	}

	@FindBy(css="[id*='stateProvince'] a")
	private WebElement province;

	public WebElement province() {
		return province;
	}

	@FindBy(id="businessStructure")
	private WebElement businessStructure;

	public WebElement businessStructure() {
		return businessStructure;
	}

	@FindBy(css="[id*='Income'][value='Yes']")
	private WebElement incomerdbtn;

	public WebElement incomerdbtn() {
		return incomerdbtn;
	}

	@FindBy(css="input#usLegalCompanyName")
	private WebElement usLegalCompanyName;

	public WebElement usLegalCompanyName() {
		return usLegalCompanyName;
	}

	@FindBy(css="[name*='usIncomeCompanyName'] b")
	private WebElement usLegalCompanyNamehidden;

	public WebElement usLegalCompanyNamehidden() {
		return usLegalCompanyNamehidden;
	}

	@FindBy(css="[id*='euCountry'] a")
	private WebElement EUCountrydpdn;

	public WebElement EUCountrydpdn() {
		return EUCountrydpdn;
	}

	@FindBy(css="[name*='usIncomeTinNumber'] input")
	private WebElement usTinNumber;

	public WebElement usTinNumber() {
		return usTinNumber;
	}

	@FindBy(css="[name*='EUVATNumber'] input:nth-child(2)")
	private WebElement euVATNum;

	public WebElement euVATNum() {
		return euVATNum;
	}

	@FindBy(css="[name*='usIncomeTinNumber'] b")
	private WebElement usTinNumberhidden;

	public WebElement usTinNumberhidden() {
		return usTinNumberhidden;
	}

	@FindBy(css="[name*='eu_regNumber'] td:nth-child(2)")
	private WebElement eureghidden;

	public WebElement eureghidden() {
		return eureghidden;
	}

	@FindBy(id="euRegistrationNumber")
	private WebElement euregnumber;

	public WebElement euregnumber() {
		return euregnumber;
	}

	@FindBy(css="td:nth-child(2)>label[for*='taxIDType']")
	private List<WebElement> Tintype;

	public List<WebElement> Tintype() {
		return Tintype;
	}

	@FindBy(css="[id*='legalIdProvidedStatus']")
	private List<WebElement> VatRegNum;

	public List<WebElement> VatRegNum() {
		return VatRegNum;
	}

	@FindBy(css="[for*='canada_taxIDType']")
	private List<WebElement> LabelBusinessIDNum;

	public List<WebElement> LabelBusinessIDNum() {
		return LabelBusinessIDNum;
	}

	@FindBy(css="#legalIdentifier")
	private WebElement VATNum;

	public WebElement VATNum() {
		return VATNum;
	}

	// [href*='editCompanyLegalName']
	@FindBy(how = How.XPATH, using = "//*[@id='companyLegalName']/..//a")
	private WebElement EditBusinessNameLink;

	public WebElement EditBusinessNameLink() {
		return EditBusinessNameLink;
	}

	@FindBy(id="companyLegalName")
	private WebElement EditBusinessNameTxtBox;

	public WebElement EditBusinessNameTxtBox() {
		return EditBusinessNameTxtBox;
	}

	@FindBy(css="[id*='legalIdentifier']")
	private WebElement EditEINTxtBox;

	public WebElement EditEINTxtBox() {
		return EditEINTxtBox;
	}

	@FindBy(css="[name*='eu-legal-id'] input:nth-child(2)")
	private WebElement VAT;

	public WebElement VAT() {
		return VAT;
	}

	@FindBy(id="edit_country")
	private WebElement EditCoRLink;

	public WebElement EditCoRLink() {
		return EditCoRLink;
	}
	
	@FindBy(css="#legalIdentifier+a")
	private WebElement EditTaxIdLink;

	public WebElement EditTaxIdLink() {
		return EditTaxIdLink;
	}
	
	@FindBy(css="div[class*='dialog undefined'] textarea")
	private WebElement EditTaxPopup;

	public WebElement EditTaxPopup() {
		return EditTaxPopup;
	}
	
	@FindBy(css="div[class*='ui-dialog-buttonset']>button.button_primary")
	private WebElement EditTaxIdSubmit;

	public WebElement EditTaxIdSubmit() {
		return EditTaxIdSubmit;
	}

	@FindBy(css="[name*='prompt']")
	private WebElement EditTaxInfoCommentsTxtBox;

	public WebElement EditTaxInfoCommentsTxtBox() {
		return EditTaxInfoCommentsTxtBox;
	}

	@FindBy(how = How.XPATH, using = "//span[starts-with(text(),'Edit Tax Information')]/parent::div//..//button[@class='button_green']")
	private WebElement EditTaxInfoCommentsSubmitBtn;

	public WebElement EditTaxInfoCommentsSubmitBtn() {
		return EditTaxInfoCommentsSubmitBtn;
	}

	@FindBy(css="iframe[class*='popup_iframe']")
	private WebElement PopupIframe;

	public WebElement PopupIframe() {
		return PopupIframe;
	}
	
	@FindBy(css="iframe[class*='popup_iframe']")
	private List<WebElement> PopupIframeList;

	public List<WebElement> PopupIframeList() {
		return PopupIframeList;
	}

	@FindBy(css="[class*='align_right']>input[class='button_green']")
	private WebElement OkBtn;

	public WebElement OkBtn() {
		return OkBtn;
	}
	
	//  'Legal ID Merge' 
	@FindBy(css="iframe[data-iname*='showMergeDuplicateSupplier']")
	private WebElement Iframe_Merge_popup;

	public WebElement Iframe_Merge_popup() {
		return Iframe_Merge_popup;
	}
	
	@FindBy(css="[value='Yes']")
	private WebElement Yes_Merge;

	public WebElement Yes_Merge() {
		return Yes_Merge;
	}

	@FindBy(id="no")
	private WebElement No_Merge;
	public WebElement No_Merge() {
		return No_Merge;
	}
	
	@FindBy(css="iframe[data-iname*='getSupportAssistanceDialog']")
	private WebElement Iframe_ContactSupport_Popup;

	public WebElement Iframe_ContactSupport_Popup() {
		return Iframe_ContactSupport_Popup;
	}

	@FindBy(css="td:nth-child(1)")
	private WebElement getBusinessName;

	public WebElement getBusinessName() {
		return getBusinessName;
	}

	@FindBy(css="td:nth-child(4)")
	private WebElement getDuplicateLegalID;

	public WebElement getDuplicateLegalID() {
		return getDuplicateLegalID;
	}
	
	@FindBy(css = "#command>div.std_margin")
	public WebElement dupLegalIdTxt;

	public WebElement dupLegalIdTxt() {
		return dupLegalIdTxt;
	}
	
	@FindBy(id = "supportMail")
	public WebElement saveBtn;

	public WebElement saveBtn() {
		return saveBtn;
	}
	
	@FindBy(css = ".bannerMessage")
	public WebElement mergeBannerMsg;

	public WebElement mergeBannerMsg() {
		return mergeBannerMsg;
	}
	//End of Legal ID MErge Popup
	
	// W9
	@FindBy(id = "w9_button")
	private WebElement W9LaunchWizardBtn;

	public WebElement W9LaunchWizardBtn() {
		return W9LaunchWizardBtn;
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

	@FindBy(css="[class*='button_primary']")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}

	//@FindBy(css="table[id*='table_w9Tax_information'] a[href*='downloadFile']")
	@FindBy(css="table a[href*='downloadFile']")
	private List<WebElement> GetW9TaxUploadedFilesList;

	public List<WebElement> GetW9TaxUploadedFilesList() {
		return GetW9TaxUploadedFilesList;
	}

	@FindBy(css = "[id='table_w9Tax_information'] td:nth-child(6)")
	private List<WebElement> Deactivatew9Btn;

	public List<WebElement> Deactivatew9Btn() {
		return Deactivatew9Btn;
	}

	@FindBy(css = "div[class='ui-dialog-buttonset'] [class='button_green'] span")
	private WebElement okdeactivatew9btn;

	public WebElement okdeactivatew9btn() {
		return okdeactivatew9btn;
	}

	@FindBy(css = "[id='table_w9Tax_information'] tr>td>span")
	private List<WebElement> editw9statusdeac;

	public List<WebElement> editw9statusdeac() {
		return editw9statusdeac;
	}
	
	@FindBy(xpath = "//*[contains(text(),'Active')]")
	private List<WebElement> editw9statusactive;

	public List<WebElement> editw9statusactive() {
		return editw9statusactive;
	}

	// REUSABLE METHODS
	public String[] fillLegal(LinkedHashMap<String, String> dataMap) {
		String[] data = new String[10];
		if (dataMap.containsKey("CountryOfReg")) {
			lavanteUtils.clicks(countryofReg);
			lavanteUtils.waitForTime(4000);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("CountryOfReg"));
			lavanteUtils.waitForTime(4000);
			lavanteUtils.fluentwait(businessStructure);
		}
		if (dataMap.containsKey("Province")) {
			lavanteUtils.waitForTime(4000);
			lavanteUtils.click(province);
			lavanteUtils.waitForTime(4000);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Province"));
			lavanteUtils.fluentwait(businessStructure);
		}

		if (dataMap.containsKey("BusinessName")) {
			lavanteUtils.fluentwait(EditBusinessNameTxtBox);
			lavanteUtils.typeinEdit(dataMap.get("BusinessName"), EditBusinessNameTxtBox);
		}
		if (dataMap.containsKey("EditBusinessName")) {
			
			lavanteUtils.click(EditBusinessNameLink);
			//Suport Login ITs showing popup FOR rESET 
			data[0] = "BusinessName" + lavanteUtils.randomnum().substring(0, 5);
			lavanteUtils.fluentwait(PopupIframe);
			if(PopupIframeList.size()>0){
				lavanteUtils.switchtoFrame(PopupIframe);
				lavanteUtils.fluentwait(EditBusinessNameTxtBox);
				EditBusinessNameTxtBox.clear();
				lavanteUtils.typeinEdit( data[0], EditBusinessNameTxtBox);
				lavanteUtils.click(OkBtn); lavanteUtils.switchtoFrame(null);
			}else{
				EditBusinessNameTxtBox.clear();
				lavanteUtils.typeinEdit( data[0], EditBusinessNameTxtBox);
			}
			
		}

		if (dataMap.containsKey("EditEIN")) {
			lavanteUtils.click(EditTaxIdLink);
			if(lavanteUtils.verifyElementDisplayed("Edit Tax Id pop-up", EditTaxPopup)) {
				lavanteUtils.typeString(dataMap.get("EditTaxIdComment"), EditTaxPopup);
				lavanteUtils.click(EditTaxIdSubmit);
			}
			
			if(dataMap.containsKey("TINNum")) {
				EditEINTxtBox.clear();
				lavanteUtils.typeinEdit(dataMap.get("TINNum"), EditEINTxtBox);
			} else {
				data[1] = lavanteUtils.randomnum().substring(0, 9);
				lavanteUtils.fluentwait(PopupIframe);
				if(PopupIframeList.size()>0){ 
					lavanteUtils.switchtoFrame(PopupIframe);
					lavanteUtils.typeinEdit( data[1], EditEINTxtBox);
					lavanteUtils.click(OkBtn);
					lavanteUtils.switchtoFrame(null);
				}else{
					lavanteUtils.typeinEdit( data[1], EditEINTxtBox);
				}
			}
			
		}
		if (dataMap.containsKey("VAT")) {
			String content = dataMap.get("VAT");
			if (content.equalsIgnoreCase("YES")) {
				lavanteUtils.click(VatRegNum.get(0));
				if (dataMap.containsKey("VATNUM")) {
					String vatnum = dataMap.get("VATNUM");
					if (vatnum.equalsIgnoreCase("ANY")) {
						int x = Integer.parseInt(lavanteUtils.generateRandomNumber9OnLength(9));
						vatnum = "" + x;
					}

					data[1] = vatnum;
					if (dataMap.get("CountryOfReg").equalsIgnoreCase("Canada")) {
						lavanteUtils.typeinEdit(vatnum, EditEINTxtBox);
					} else {
						lavanteUtils.typeinEdit(vatnum, VAT);
					}
				}
			} else {
				lavanteUtils.click(VatRegNum.get(1));
			}

		}
		if (dataMap.containsKey("TIN")) {
			String content = dataMap.get("TIN");
			if (content.equalsIgnoreCase("YES")) {
				lavanteUtils.click(Tintype.get(2)); //xEIN num selectrion
				if (dataMap.containsKey("TINNum")) {
					String vatnum = dataMap.get("TINNum");
					if (vatnum.equalsIgnoreCase("ANY")) {
						int x = Integer.parseInt(lavanteUtils.generateRandomNumber9OnLength(9));
						vatnum = "" + x;
					}

					lavanteUtils.typeinEdit(vatnum, EditEINTxtBox);
				}
			} else {
				lavanteUtils.click(Tintype.get(2));
			}
		}

		if (dataMap.containsKey("EUIncome")) {
			data[3] = EUIncome(dataMap);
		}
		if (dataMap.containsKey("usIncome")) {
			String status = dataMap.get("usIncome");
			if (status.equalsIgnoreCase("Yes")) {
				lavanteUtils.selectChkBox(incomerdbtn, "yes");
				String name = "";
				if (dataMap.containsKey("businessName")) {
					String d = usLegalCompanyName().getAttribute("disabled");
					if (!d.equalsIgnoreCase("true")) {
						name = lavanteUtils.typeString(dataMap.get("businessName"), usLegalCompanyName);
					} else {
						// name = usLegalCompanyNamehidden.getText();
						name = usLegalCompanyName().getAttribute("value");
					}
					data[0] = name;
				}
				// EIN NUM TAX ID NUMBER
				if (dataMap.containsKey("VATNUM")) {
					String ein = "";
					String d = usTinNumber.getAttribute("disabled");

					if (!d.equalsIgnoreCase("true")) {
						ein = lavanteUtils.typeString(dataMap.get("VATNUM"), usTinNumber);
					} else {
						// ein = usTinNumberhidden.getText();
						ein = usTinNumber().getAttribute("value");
					}
					data[1] = ein;

				}

			}

		}
		if (dataMap.containsKey("euregnumber")) {
			String euregnumbertxt = "";
			String d = euregnumber.getAttribute("type");
			if (!d.equalsIgnoreCase("hidden")) {
				euregnumbertxt = lavanteUtils.typeString(dataMap.get("euregnumber"), euregnumber);
			} else {
				euregnumbertxt = eureghidden.getText();
			}
			data[0] = euregnumbertxt;

		}

		return data;
	}

	/**
	 * This Popup Comes when the legalID is entered same esp on support login
	 * @author Vidya.C
	 * 
	 */
	public void DuplicateLegalIdMerge(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(Iframe_Merge_popup);
		if(dataMap.containsKey("YesMerge")) {
			lavanteUtils.click(Yes_Merge);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(mergeBannerMsg);
			dataMap.put("MergeBanner", mergeBannerMsg.getText());
		}
		if(dataMap.containsKey("NoMerge")) {
			lavanteUtils.click(No_Merge);
			lavanteUtils.switchtoFrame(Iframe_ContactSupport_Popup);
			lavanteUtils.fluentwait(dupLegalIdTxt);
			dataMap.put("DupLegalIdText", dupLegalIdTxt.getText());
			lavanteUtils.click(saveBtn);
			lavanteUtils.switchtoFrame(null);
		}
	}
	
	private String EUIncome(LinkedHashMap<String, String> dataMap) {
		String status = dataMap.get("EUIncome");
		if (status.equalsIgnoreCase("Yes")) {
			lavanteUtils.selectChkBox(incomerdbtn, "yes");
			lavanteUtils.fluentwait(usLegalCompanyName);
			String name = "";
			if (dataMap.containsKey("EUCountry")) {
				lavanteUtils.click(EUCountrydpdn);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.selectvalueFrmDpdn(dataMap.get("EUCountry"));
				lavanteUtils.fluentwait(EUCountrydpdn);
			}

			if (dataMap.containsKey("EUbusinessName")) {
				String d = usLegalCompanyName.getAttribute("type");
				if (!d.equalsIgnoreCase("hidden")) {
					name = lavanteUtils.typeString(dataMap.get("EUbusinessName"), usLegalCompanyName);
				} else {
					name = usLegalCompanyNamehidden.getText();
				}

			}

			if (dataMap.containsKey("VATNUM")) {
				String ein = dataMap.get("VATNUM");

				if (dataMap.containsKey("EUCountry")) {
					String data = dataMap.get("EUCountry");
					if (data.contains("Sweden")) {
						if (ein.equalsIgnoreCase("ANY")) {
							int x = Integer.parseInt(lavanteUtils.generateRandomNumber9OnLength(9));
							ein = "" + x + "001";
						}
					}
				}
				System.out.println("ein:" + ein);
				String d = euVATNum.getAttribute("type");
				if (!d.equalsIgnoreCase("hidden")) {
					ein = lavanteUtils.typeString(ein, euVATNum);
				} else {
					ein = usTinNumberhidden.getText();
				}
				status = ein;
			}
		}
		return status;
	}

	public void uploadw9(String uploadFileName) throws IOException {
		lavanteUtils.click(W9UploadDocumentBtn);
		lavanteUtils.switchtoFrame(IframeW9DocUpload);
		lavanteUtils.uploadFile(uploadFileName, BrowseTaxW9Btn);
		lavanteUtils.click(SaveBtn);
		lavanteUtils.switchtoFrame(null);
	}

}
