/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
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
public class EditProfPaymentInfo {

	public WebDriver driver;
	LavanteUtils lavanteUtils = new LavanteUtils();

	public EditProfPaymentInfo(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}

	// -----CreditCard--------------------------------------------

	@FindBy(css="#p_card~label")
	private WebElement PaymentCreditCardChkBox;

	public WebElement PaymentCreditCardChkBox() {
		return PaymentCreditCardChkBox;
	}

	@FindBy(xpath="//label[@for='ccPaymentTerms']/preceding-sibling::input")
	private WebElement CreditCardPaymentTermsRadioBtn;

	public WebElement CreditCardPaymentTermsRadioBtn() {
		return CreditCardPaymentTermsRadioBtn;
	}

	@FindBy(css="[id*='ccPaymentTerms']>a")
	private WebElement CreditCardPaymentTermsDropDwn;

	public WebElement CreditCardPaymentTermsDropDwn() {
		return CreditCardPaymentTermsDropDwn;
	}

	@FindBy(css="input[class*='paymentTermsSelection'][data-elem='pcard']")
	private WebElement CreditCardNegotiatedPaymentTermsRadioBtn;

	public WebElement CreditCardNegotiatedPaymentTermsRadioBtn() {
		return CreditCardNegotiatedPaymentTermsRadioBtn;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Discount %')]/../input")
	private WebElement CreditCardDiscount;

	public WebElement CreditCardDiscount() {
		return CreditCardDiscount;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Discount Days')]/../input")
	private WebElement CreditCardDiscountDays;

	public WebElement CreditCardDiscountDays() {
		return CreditCardDiscountDays;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Net Days')]/../input")
	private WebElement CreditCardNetDays;

	public WebElement CreditCardNetDays() {
		return CreditCardNetDays;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Current Month Day')]/../input")
	private WebElement CreditCardCurrentMonthDay;

	public WebElement CreditCardCurrentMonthDay() {
		return CreditCardCurrentMonthDay;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Next Month Day')]/../input")
	private WebElement CreditCardNextMonthDay;

	public WebElement CreditCardNextMonthDay() {
		return CreditCardNextMonthDay;
	}

	// --------Check-----------------------------------------------

	@FindBy(css="#check~label")
	private WebElement PaymentCheckChkBox;

	public WebElement PaymentCheckChkBox() {
		return PaymentCheckChkBox;
	}

	@FindBy(xpath="//label[@for='checkPaymentTerms']/preceding-sibling::input")
	private WebElement CheckPaymentTermsRadioBtn;

	public WebElement CheckPaymentTermsRadioBtn() {
		return CheckPaymentTermsRadioBtn;
	}

	@FindBy(css="[id*='checkPaymentTerms']>a")
	private WebElement CheckPaymentTermsDropDwn;

	public WebElement CheckPaymentTermsDropDwn() {
		return CheckPaymentTermsDropDwn;
	}

	@FindBy(xpath="//input[@data-elem='check']/parent::div/../div[2]/div[@class='negotiated-payments']/input[@class='paymentTermsSelection']")
	private WebElement CheckNegotiatedPaymentTermsRadioBtn;

	public WebElement CheckNegotiatedPaymentTermsRadioBtn() {
		return CheckNegotiatedPaymentTermsRadioBtn;
	}

	@FindBy(xpath="//input[@data-elem='check']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Discount %')]/../input")
	private WebElement CheckDiscount;

	public WebElement CheckDiscount() {
		return CheckDiscount;
	}

	@FindBy(xpath="//input[@data-elem='check']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Discount Days')]/../input")
	private WebElement CheckDiscountDays;

	public WebElement CheckDiscountDays() {
		return CheckDiscountDays;
	}

	@FindBy(xpath="//input[@data-elem='check']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Net Days')]/../input")
	private WebElement CheckNetDays;

	public WebElement CheckNetDays() {
		return CheckNetDays;
	}

	@FindBy(xpath="//input[@data-elem='check']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Current Month Day')]/../input")
	private WebElement CheckCurrentMonthDay;

	public WebElement CheckCurrentMonthDay() {
		return CheckCurrentMonthDay;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Next Month Day')]/../input")
	private WebElement CheckNextMonthDay;

	public WebElement CheckNextMonthDay() {
		return CheckNextMonthDay;
	}

	// --EFT----------------------------------------------------

	@FindBy(css="#etf~label")
	private WebElement PaymentEFTChkBox;

	public WebElement PaymentEFTChkBox() {
		return PaymentEFTChkBox;
	}

	@FindBy(xpath="//label[@for='eftPaymentTerms']/preceding-sibling::input")
	private WebElement EFTPaymentTermsRadioBtn;

	public WebElement EFTPaymentTermsRadioBtn() {
		return EFTPaymentTermsRadioBtn;
	}

	@FindBy(css="[id*='eftPaymentTerms']>a")
	private WebElement EFTPaymentTermsDropDwn;

	public WebElement EFTPaymentTermsDropDwn() {
		return EFTPaymentTermsDropDwn;
	}

	@FindBy(xpath="//input[@data-elem='etf']/parent::div/../div[2]/div[@class='negotiated-payments']/input[@class='paymentTermsSelection']")
	private WebElement EFTNegotiatedPaymentTermsRadioBtn;

	public WebElement EFTNegotiatedPaymentTermsRadioBtn() {
		return EFTNegotiatedPaymentTermsRadioBtn;
	}

	@FindBy(xpath="//input[@data-elem='etf']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Discount %')]/../input")
	private WebElement EFTDiscount;

	public WebElement EFTDiscount() {
		return EFTDiscount;
	}

	@FindBy(xpath="//input[@data-elem='etf']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Discount Days')]/../input")
	private WebElement EFTDiscountDays;

	public WebElement EFTDiscountDays() {
		return EFTDiscountDays;
	}

	@FindBy(xpath="//input[@data-elem='etf']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Net Days')]/../input")
	private WebElement EFTNetDays;

	public WebElement EFTNetDays() {
		return EFTNetDays;
	}

	@FindBy(xpath="//input[@data-elem='check']/parent::div/../div[2]/div[@class='negotiated-payments']/div[@class='negotiated-section']/div/label[starts-with(text(),'Current Month Day')]/../input")
	private WebElement EFTCurrentMonthDay;

	public WebElement EFTCurrentMonthDay() {
		return EFTCurrentMonthDay;
	}

	@FindBy(xpath="//input[@data-elem='pcard']/following-sibling::div/div/label[starts-with(text(),'Next Month Day')]/../input")
	private WebElement EFTNextMonthDay;

	public WebElement EFTNextMonthDay() {
		return EFTNextMonthDay;
	}

	// ---Credit Card Details --------------------------------------

	@FindBy(id="visa")
	private WebElement CCVisaRadioBtn;

	public WebElement CCVisaRadioBtn() {
		return CCVisaRadioBtn;
	}

	@FindBy(id="master_card")
	private WebElement CCMasterCardRadioBtn;

	public WebElement CCMasterCardRadioBtn() {
		return CCMasterCardRadioBtn;
	}

	@FindBy(id="other_card_radio")
	private WebElement CCOther;

	public WebElement CCOther() {
		return CCOther;
	}

	@FindBy(id="cardTermsAndConditionsBox")
	private WebElement CCTermsConditions;

	public WebElement CCTermsConditions() {
		return CCTermsConditions;
	}

	// -----------------------------------------------------------------

	@FindBy(css="[id*='PaymentType'] a")
	private WebElement paymentypedpdn;

	public WebElement paymentypedpdn() {
		return paymentypedpdn;
	}
	
	@FindBy(css="div[id*='preferredPaymentType'] a")
	private WebElement PreferedPayementTypedpdn;

	public WebElement PreferedPayementTypedpdn() {
		return PreferedPayementTypedpdn;
	}

	@FindBy(css="[id*='pcardPaymentTermId'] a")
	private WebElement creditpaymentermsdpdn;

	public WebElement creditpaymentermsdpdn() {
		return creditpaymentermsdpdn;
	}

	@FindBy(css="[id*='pcardPaymentTermId'] a span")
	private WebElement creditpaymentermslabel;

	public WebElement creditpaymentermslabel() {
		return creditpaymentermslabel;
	}

	@FindBy(css="[id*='eftPaymentTermId'] a")
	private WebElement eftpaymentermsdpdn;

	public WebElement eftpaymentermsdpdn() {
		return eftpaymentermsdpdn;
	}

	@FindBy(css="div[id='checkPaymentTermId_chosen'] a span")
	private WebElement GetCheckPaymentTermDefaultValueDropdwn;

	public WebElement GetCheckPaymentTermDefaultValueDropdwn() {
		return GetCheckPaymentTermDefaultValueDropdwn;
	}

	@FindBy(css="[id*='eftPaymentTermId'] a span")
	private WebElement eftpaymentermslabel;

	public WebElement eftpaymentermlabel() {
		return eftpaymentermslabel;
	}

	@FindBy(css="[id*='checkPaymentTermId'] a")
	private WebElement CHKpaymentermsdpdn;

	public WebElement CHKpaymentermsdpdn() {
		return CHKpaymentermsdpdn;
	}

	@FindBy(css="[id*='checkPaymentTermId'] a span")
	private WebElement CHKpaymentermslabel;

	public WebElement CHKpaymentermslabel() {
		return CHKpaymentermslabel;
	}

	@FindBy(css="#payment_types input")
	private List<WebElement> paymntTypeSupport;

	public List<WebElement> paymntTypeSupport() {
		return paymntTypeSupport;
	}

	@FindBy(css="#payment_types input")
	private List<WebElement> paymntTypeSupporttxt;

	public List<WebElement> paymntTypeSupporttxt() {
		return paymntTypeSupporttxt;
	}

	@FindBy(css="[class='data_not_found']>td")
	private WebElement GetTableErrorMsg;

	public WebElement GetTableErrorMsg() {
		return GetTableErrorMsg;
	}

	@FindBy(css="[name='etfPaymentCheckboxOption']")
	private WebElement EFTChkBox;

	public WebElement EFTChkBox() {
		return EFTChkBox;
	}

	@FindBy(css="[name='cardPaymentCheckboxOption']")
	private WebElement CreditCardChkBox;

	public WebElement CreditCardChkBox() {
		return CreditCardChkBox;
	}

	@FindBy(css="[name='checkPaymentCheckboxOption']")
	private WebElement CheckChkBox;

	public WebElement CheckChkBox() {
		return CheckChkBox;
	}

	@FindBy(css="[name='checkPaymentDesc']")
	private WebElement PayableToTxtBox;

	public WebElement PayableToTxtBox() {
		return PayableToTxtBox;
	}

	
	
	@FindBy(css="[id*='eftTermsAndConditionsBox']")
	private WebElement eftagreeInput;

			
	@FindBy(css="[id*='eftTermsAndConditionsBox']~label")
	private WebElement eftagree;

	public WebElement eftagree() {
		return eftagree;
	}

	
	//EFT TABLE
	@FindBy(css="[id*='etf_table'] tbody td:nth-child(6)")
	//For Login on GP this wont work @FindBy(css="[id*='etf_table'] tbody td:nth-child(6)")
	private List<WebElement> ListBankDetails;

	public List<WebElement> ListBankDetails() {
		return ListBankDetails;
	}	
	
	@FindBy(css="[id*='etf_table'] tbody td:nth-child(3)")
	private List<WebElement> ListBankCodeFlag;

	public List<WebElement> ListBankCodeFlag() {
		return ListBankCodeFlag;
	}
	
	@FindBy(css="[id*='etf_table'] tbody td:nth-child(3) img")
	private List<WebElement> ListBankCodeFlagstatus;

	public List<WebElement> ListBankCodeFlagstatus() {
		return ListBankCodeFlagstatus;
	}
	
	@FindBy(css="[id*='etf_table'] tbody td:nth-child(4)")
	private List<WebElement> ListAccountNumberFlag;

	public List<WebElement> ListAccountNumberFlag() {
		return ListAccountNumberFlag;
	}
				
	@FindBy(css="table[id*='etf_table_'] tr td:nth-child(7) a[href*='deleteSupplierPaymentEftInfo']")
	private List<WebElement> ListEFTDeleteBtn;

	public List<WebElement> ListEFTDeleteBtn() {
		return ListEFTDeleteBtn;
	}

	@FindBy(css="table[id*='etf_table_'] tr td:nth-child(7) a[href*='addEditSupplierPaymentEftInfo']")
	private List<WebElement> ListEFTEditBtn;

	public List<WebElement> ListEFTEditBtn() {
		return ListEFTEditBtn;
	}
	
	@FindBy(css="a[href*='paymentEftID=&']")
	private WebElement AddEFTBtn;

	public WebElement AddEFTBtn() {
		return AddEFTBtn;
	}
	
	@FindBy(css="button[href*='Validation']")
	private WebElement MarkasValidatedbtn;

	public WebElement MarkasValidatedbtn() {
		return MarkasValidatedbtn;
	}
	
	//Mark as Validated
	@FindBy(css="iframe[src*='eftManual']")
	private WebElement IFRAMEMarkValidated;

	public WebElement IFRAMEMarkValidated() {
		return IFRAMEMarkValidated;
	}
	
	@FindBy(id="eftValidationComment")
	private WebElement commenttxt;

	public WebElement commenttxt() {
		return commenttxt;
	}
	
	@FindBy(css="textarea[name*='prompt']")
	private WebElement deleteCommentTxtArea;

	public WebElement deleteCommentTxtArea() {
		return deleteCommentTxtArea;
	}
	@FindBy(css="[class*='dialog'] button[class*='green']")
	private WebElement OkBtn;

	public WebElement OkBtn() {
		return OkBtn;
	}
	
	@FindBy(css="button[class*='green']")
	private WebElement commentSavebtn;

	public WebElement commentSavebtn() {
		return commentSavebtn;
	}
	
	

	// Add EFT POPUP

		@FindBy(css="iframe[src*='addEditSupplierPaymentEftInfo']")
		private WebElement IframeADDEFT;

		public WebElement IframeADDEFT() {
			return IframeADDEFT;
		}

		@FindBy(css="input[type*='radio'][value='ACH']")
		private WebElement EFTEFTTypeACH;

		@FindBy(css="div[id*='paymentEFTCurrencyID'] a")
		private WebElement CurrencyDropDwn;

		public WebElement CurrencyDropDwn() {
			return CurrencyDropDwn;
		}

		@FindBy(id="emailAddress1")
		private WebElement RCEmail1TxtBox;

		public WebElement RCEmail1TxtBox() {
			return RCEmail1TxtBox;
		}

		@FindBy(css="div[id*='countryId'] a")
		private WebElement BankCountryDropDwn;

		public WebElement BankCountryDropDwn() {
			return BankCountryDropDwn;
		}

		@FindBy(id="routingNumber")
		private WebElement ABARoutingNoTxtBox;

		public WebElement ABARoutingNoTxtBox() {
			return ABARoutingNoTxtBox;
		}

		@FindBy(id="accountNumber")
		private WebElement AccountNoTxtBox;

		public WebElement AccountNoTxtBox() {
			return AccountNoTxtBox;
		}

		@FindBy(css="div[id*='accountTypeID'] a")
		private WebElement AccountTypeDropDwn;

		public WebElement AccountTypeDropDwn() {
			return AccountTypeDropDwn;
		}

		@FindBy(css="input[id='swiftCode']")
		private WebElement SwiftCodeTxtBox;

		public WebElement SwiftCodeTxtBox() {
			return SwiftCodeTxtBox;
		}
		
		@FindBy(css="div[id*='bankName'] a")
		private WebElement BankNameDropDwn;

		public WebElement BankNameDropDwn() {
			return BankNameDropDwn;
		}

		@FindBy(id="bankNameOther")
		private WebElement BankNameTxtBox;

		public WebElement BankNameTxtBox() {
			return BankNameTxtBox;
		}

		@FindBy(id="branchAddress")
		private WebElement BranchAddressTxtBox;

		public WebElement BranchAddressTxtBox() {
			return BranchAddressTxtBox;
		}

		@FindBy(id="city")
		private WebElement CityTxtBox;

		public WebElement CityTxtBox() {
			return CityTxtBox;
		}

		@FindBy(css="div[id*='stateId'] a")
		private WebElement StateDropDwn;

		public WebElement StateDropDwn() {
			return StateDropDwn;
		}

		@FindBy(id="zip")
		private WebElement  EFTBankPostal;

		@FindBy(css="input[id='ibanNumber']")
		private WebElement IBANNumberTxtBox;

		public WebElement IBANNumberTxtBox() {
			return IBANNumberTxtBox;
		}

		@FindBy(css="button[class*='cancel']")
		private WebElement CancelBtn;

		public WebElement CancelBtn() {
			return CancelBtn;
		}

		@FindBy(css="button[title*='clear']")
		private WebElement ClearBtn;

		public WebElement ClearBtn() {
			return ClearBtn;
		}

		@FindBy(css="button[class*='primary']")
		private WebElement SaveBtn;

		public WebElement SaveBtn() {
			return SaveBtn;
		}


	
	
	
	//ADD EFT POPUP

		
	// REUSABLE METHODS

	public void fillPayMentInfo(LinkedHashMap<String, String> dataMap)
			throws FileNotFoundException, IOException, SQLException {

		lavanteUtils.switchtoFrame(null);

		if (dataMap.containsKey("paymentTypeSupport")) {
			String All = dataMap.get("paymentTypeSupport");
			if (All.contains("#")) {
				String[] sp = All.split("#");

				for (int i = 0; i < sp.length; i++) {
					lavanteUtils.fluentwait(paymentypedpdn);
					lavanteUtils.click(paymentypedpdn);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.selectFrmDpdn(sp[i]);
				}

			} else {
				lavanteUtils.fluentwait(paymentypedpdn);
				lavanteUtils.click(paymentypedpdn);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.selectFrmDpdn(All);

			}

		}

		if (dataMap.containsKey("paymentTypeSupports")) {
			String All = dataMap.get("paymentTypeSupport");
			if (All.contains("#")) {

			} else {
				for (int i = 0; i < paymntTypeSupport().size(); i++) {
					boolean xx = paymntTypeSupport().get(i).isSelected();
					if (xx == false) {
						int j = i + 1;
						driver.findElement(By.cssSelector("#payment_types input:nth-child(" + j + ")")).click();
					}
				}
			}
		}
		lavanteUtils.waitForTime(3000);
		if (dataMap.containsKey("eftpaymentType")) {
			lavanteUtils.fluentwait(eftpaymentermsdpdn);
			lavanteUtils.click(eftpaymentermsdpdn);
			lavanteUtils.selectFrmDpdn(dataMap.get("eftpaymentType"));
		}

		if (dataMap.containsKey("checkpaymentType")) {

			lavanteUtils.fluentwait(CHKpaymentermsdpdn);
			lavanteUtils.click(CHKpaymentermsdpdn);
			lavanteUtils.selectFrmDpdn(dataMap.get("checkpaymentType"));

		}

		if (dataMap.containsKey("creditpaymentType")) {
			lavanteUtils.fluentwait(creditpaymentermsdpdn);
			lavanteUtils.click(creditpaymentermsdpdn);
			lavanteUtils.selectFrmDpdn(dataMap.get("creditpaymentType"));
		}

		if (dataMap.containsKey("CheckPayableTo")) {
			String y = "" + lavanteUtils.typeinEdit(dataMap.get("CheckPayableTo"), PayableToTxtBox);
			dataMap.put("CheckPayableTo", y);

		}
		if (dataMap.containsKey("CheckPaymentTerms")) {
			lavanteUtils.click(CheckPaymentTermsDropDwn);
			String x = lavanteUtils.selectFrmDpdn(dataMap.get("CheckPaymentTerms"));
			dataMap.put("CheckPaymentTerms", x);
		}
		if (dataMap.containsKey("EFTAgree")) {
			String data = dataMap.get("EFTAgree");
			if (data.contains("YES")) {
				String value=eftagreeInput.getAttribute("checked");
				if(value==null){
					lavanteUtils.selectChkBox(eftagree, data);
				}else if(!value.equalsIgnoreCase("checked")){
					lavanteUtils.selectChkBox(eftagree, data);
				}
			}
		}

	}


	public void addOrEditEFT(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("AddEFT")) {
			lavanteUtils.fluentwait(AddEFTBtn);
			lavanteUtils.click(AddEFTBtn);
		}
		
		lavanteUtils.switchtoFrame(IframeADDEFT);
		
		 if(dataMap.containsKey("EFTEFTTYPE")){
			 String data=dataMap.get("EFTEFTTYPE");
			 if(data.contains("ACH")){
				 lavanteUtils.click(EFTEFTTypeACH);
			 }
		 }
		
		
		if (dataMap.containsKey("Currency")) {
			lavanteUtils.click(CurrencyDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Currency"));
			lavanteUtils.switchtoFrame(IframeADDEFT);
		}
		if (dataMap.containsKey("RCEmail1")) {
			lavanteUtils.typeinEdit(dataMap.get("RCEmail1"), RCEmail1TxtBox);
		}
		if (dataMap.containsKey("BankCountry")) {
			lavanteUtils.click(BankCountryDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("BankCountry"));
			lavanteUtils.switchtoFrame(IframeADDEFT);
		}
		if (dataMap.containsKey("ABARoutingNumber")) {
			lavanteUtils.typeinEdit(dataMap.get("ABARoutingNumber"), ABARoutingNoTxtBox);
		}
		if (dataMap.containsKey("AccountNumber")) {
			lavanteUtils.typeinEdit(dataMap.get("AccountNumber"), AccountNoTxtBox);
		}
		if (dataMap.containsKey("AccountType")) {
			lavanteUtils.click(AccountTypeDropDwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("AccountType"));
			lavanteUtils.switchtoFrame(IframeADDEFT);
		}
		
		if (dataMap.containsKey("SwiftCode")) {
			lavanteUtils.typeinEdit(dataMap.get("SwiftCode"), SwiftCodeTxtBox);
		}
		if (dataMap.containsKey("BankName")) {
			lavanteUtils.click(BankNameDropDwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("BankName").split("#")[0]);
			lavanteUtils.switchtoFrame(IframeADDEFT);
			lavanteUtils.typeinEdit(dataMap.get("BankName").split("#")[1], BankNameTxtBox);
		}
		if (dataMap.containsKey("BranchAddress")) {
			lavanteUtils.typeinEdit(dataMap.get("BranchAddress"), BranchAddressTxtBox);
		}
		if (dataMap.containsKey("City")) {
			lavanteUtils.typeinEdit(dataMap.get("City"), CityTxtBox);

		}
		if (dataMap.containsKey("State")) {
			lavanteUtils.click(StateDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("State"));
			lavanteUtils.switchtoFrame(IframeADDEFT);
		}
		 if(dataMap.containsKey("EFTBankPostal")){
			 lavanteUtils.typeinEdit(dataMap.get("EFTBankPostal"),EFTBankPostal);
		 }
		if (dataMap.containsKey("IBANNumber")) {
			lavanteUtils.typeinEdit(dataMap.get("IBANNumber"), IBANNumberTxtBox);
		}

		formEFTAction(dataMap);
	}

	private void formEFTAction(LinkedHashMap<String, String> data) {
		if (data.containsKey("Save")) {
			lavanteUtils.click(SaveBtn);
			lavanteUtils.waitForTime(3000);
		}
		if (data.containsKey("Cancel")) {
			lavanteUtils.click(CancelBtn);
		}
		if (data.containsKey("Clear")) {
			lavanteUtils.click(ClearBtn);
		}
		lavanteUtils.switchtoFrame(null);
	}
	
	
	// Payment Types

	public LinkedHashMap<String, String> fillPayMentType(LinkedHashMap<String, String> dataMap) {
		if ("CreditCard".contains(dataMap.get("PaymentType"))) {
			lavanteUtils.click(PaymentCreditCardChkBox);
		}
		if ("Check".contains(dataMap.get("PaymentType"))) {
			lavanteUtils.click(PaymentCheckChkBox);
		}
		if ("EFT".contains(dataMap.get("PaymentType"))) {
			lavanteUtils.click(PaymentEFTChkBox);
		}
		return fillPaymentTerms(dataMap);
	}

	String selectedPaymentTerm;

	public LinkedHashMap<String, String> fillPaymentTerms(LinkedHashMap<String, String> dataMap) {
		LinkedHashMap<String, String> dataMap1 = new LinkedHashMap<String, String>();
		if (dataMap.containsKey("CCPaymentTerms")) {
			lavanteUtils.click(CreditCardPaymentTermsRadioBtn);
			lavanteUtils.click(CreditCardPaymentTermsDropDwn);
			selectedPaymentTerm = lavanteUtils.selectFrmDpdn(dataMap.get("CCPaymentTerms"));
			dataMap1.put("CCPaymentTerms", selectedPaymentTerm);
		}
		if (dataMap.containsKey("CCNegotiatedPaymentTerms")) {
			lavanteUtils.click(CreditCardNegotiatedPaymentTermsRadioBtn);

			if (dataMap.containsKey("CCDiscount")) {
				lavanteUtils.typeinEdit(dataMap.get("CCDiscount"), CreditCardDiscount);
			}
			if (dataMap.containsKey("CCDiscountDays")) {
				lavanteUtils.typeinEdit(dataMap.get("CCDiscountDays"), CreditCardDiscountDays);
			}
			if (dataMap.containsKey("CCNetDays")) {
				lavanteUtils.typeinEdit(dataMap.get("CCNetDays"), CreditCardNetDays);
			}
			if (dataMap.containsKey("CCCurrentMonthDay")) {
				lavanteUtils.typeinEdit(dataMap.get("CCCurrentMonthDay"), CreditCardCurrentMonthDay);
			}
			if (dataMap.containsKey("CCNextMonthDay")) {
				lavanteUtils.typeinEdit(dataMap.get("CCNextMonthDay"), CreditCardDiscount);
			}
		}

		if (dataMap.containsKey("CPaymentTerms")) {
			lavanteUtils.click(CheckPaymentTermsRadioBtn);
			lavanteUtils.click(CheckPaymentTermsDropDwn);
			selectedPaymentTerm = lavanteUtils.selectFrmDpdn(dataMap.get("CPaymentTerms"));
			dataMap1.put("CPaymentTerms", selectedPaymentTerm);
		}
		if (dataMap.containsKey("CNegotiatedPaymentTerms")) {
			lavanteUtils.click(CheckNegotiatedPaymentTermsRadioBtn);

			if (dataMap.containsKey("CDiscount")) {
				lavanteUtils.typeinEdit(dataMap.get("CDiscount"), CheckDiscount);
			}
			if (dataMap.containsKey("CDiscountDays")) {
				lavanteUtils.typeinEdit(dataMap.get("CDiscountDays"), CheckDiscountDays);
			}
			if (dataMap.containsKey("CNetDays")) {
				lavanteUtils.typeinEdit(dataMap.get("CNetDays"), CheckNetDays);
			}
			if (dataMap.containsKey("CCurrentMonthDay")) {
				lavanteUtils.typeinEdit(dataMap.get("CCurrentMonthDay"), CheckCurrentMonthDay);
			}
			if (dataMap.containsKey("CNextMonthDay")) {
				lavanteUtils.typeinEdit(dataMap.get("CNextMonthDay"), CheckNextMonthDay);
			}
		}
		if (dataMap.containsKey("EFTPaymentTerms")) {
			lavanteUtils.click(EFTPaymentTermsRadioBtn);
			lavanteUtils.click(EFTPaymentTermsDropDwn);
			selectedPaymentTerm = lavanteUtils.selectFrmDpdn(dataMap.get("EFTPaymentTerms"));
			dataMap1.put("EFTPaymentTerms", selectedPaymentTerm);
		}
		if (dataMap.containsKey("EFTNegotiatedPaymentTerms")) {
			lavanteUtils.click(EFTNegotiatedPaymentTermsRadioBtn);

			if (dataMap.containsKey("EFTDiscount")) {
				lavanteUtils.typeinEdit(dataMap.get("EFTDiscount"), EFTDiscount);
			}
			if (dataMap.containsKey("EFTDiscountDays")) {
				lavanteUtils.typeinEdit(dataMap.get("EFTDiscountDays"), EFTDiscountDays);
			}
			if (dataMap.containsKey("EFTNetDays")) {
				lavanteUtils.typeinEdit(dataMap.get("EFTNetDays"), EFTNetDays);
			}
			if (dataMap.containsKey("EFTCurrentMonthDay")) {
				lavanteUtils.typeinEdit(dataMap.get("EFTCurrentMonthDay"), EFTCurrentMonthDay);
			}
			if (dataMap.containsKey("EFTNextMonthDay")) {
				lavanteUtils.typeinEdit(dataMap.get("EFTNextMonthDay"), EFTNextMonthDay);
			}
		}
		creditCardDetailsInfo(dataMap);
		return dataMap1;
	}

	private void creditCardDetailsInfo(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("CCVisa")) {
			lavanteUtils.click(CCVisaRadioBtn);
		}
		if (dataMap.containsKey("CCMasterCard")) {
			lavanteUtils.click(CCMasterCardRadioBtn);
		}
		if (dataMap.containsKey("CCOther")) {
			lavanteUtils.click(CCOther);
		}
		lavanteUtils.selectChkBox(CCTermsConditions(), "yes");
	}

	public void MarkasValidatedbtn(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(MarkasValidatedbtn);
		lavanteUtils.switchtoFrame(IFRAMEMarkValidated);
		if(dataMap.containsKey("Comment")){
			lavanteUtils.typeinEdit(dataMap.get("Comment"),commenttxt );
		}
		if(dataMap.containsKey("Save")){
			lavanteUtils.click(commentSavebtn);
		}
	}

}
