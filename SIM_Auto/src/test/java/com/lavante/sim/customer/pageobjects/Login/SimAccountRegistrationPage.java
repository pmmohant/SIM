package com.lavante.sim.customer.pageobjects.Login;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

public class SimAccountRegistrationPage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public SimAccountRegistrationPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	//Legal ID block
		@FindBy(css="[id='isLegalDocExist']")
		private WebElement LegalDocExist;
		public WebElement LegalDocExist(){
			return LegalDocExist;
		}
		
		//Account Setup Next Button
		@FindBy(css="input[value*='Next']")
		private WebElement accSetupnextBtn;
		
		//Registration--Contact Name
		@FindBy(id="contactName")
		private WebElement contactName;
		
		//Registration--Contact Name left blank label
		@FindBy(css=".error")
		private List<WebElement> errorMsgMandateFields;
		public List<WebElement> errMsgs(){
			return errorMsgMandateFields;
		}
		
		//Registration--VAT number radio buttons
		
		@FindBy(css="[id='confirm_vat_other'] td:nth-child(1) label")
		private List<WebElement> LabelOtherVAT;
		public List<WebElement> LabelOtherVAT(){
			return LabelOtherVAT;
		}
		
		//@FindBy(css="[id='confirm_vat'] [id*='VAT_']")
		@FindBy(css="[id*='vat'] [id*='legalIdProvidedStatus']")
		private List<WebElement> VATNumber;
		public List<WebElement> VATNumber(){
			return VATNumber;
		}
		
		//@FindBy(css="[id='confirm_vat_other'] [id*='VAT_']")
		//Algeria Country
		@FindBy(css="[id='confirm_vat_other'] [id*='Id']")
		private List<WebElement> VATOther;
		public List<WebElement> VATOther(){
			return VATOther;
		}		
		
		//Registration--VAT Label
		//@FindBy(css="#EUCountryList label[for*='tinForThatCountry']")
		@FindBy(css="#EUCountryList label")
		private WebElement vatCountrylabel;
		public WebElement vatCountrylabel(){
			return vatCountrylabel;
		}
		
		@FindBy(css="#AllCountryList label[for*='tinForThatCountry']")
		private WebElement ALLvatCountrylabel;
		public WebElement ALLvatCountrylabel(){
			return ALLvatCountrylabel;
		}
		
		
		
		//Registration--Select Country
		@FindBy(css="#country_chosen a")
		private WebElement country;
		public WebElement country(){
			return country;
		}
				
		//Registration--W9 Form label
		@FindBy(css=".us_nonCanada-only label")
		private WebElement W9Label;
		public WebElement W9Label(){
			return W9Label;
		}
		
		//Registration--US Source Income label
		@FindBy(css="tbody[class*='US_income'] [id^='US_income']")
		private List<WebElement> USSourceIncome;
		public List<WebElement> USSourceIncome(){
			return USSourceIncome;
		}
		
		@FindBy(css="[class*='non-us '] [id*='US_income']")
		private List<WebElement> NonUSSourceIncome;
		public List<WebElement> NonUSSourceIncome(){
			return NonUSSourceIncome;
		}
		
		

		//Company Legal Name
		@FindBy(id="companyLegalName")
		private WebElement companyLegalName;
		
		//Company Legal Name-NOnUS
		@FindBy(id="companyLegalNameNonUS")
		private WebElement companyLegalNameNonUS;
		public WebElement CompanyLegalNameNonUS(){
			return companyLegalNameNonUS;
		}
		
		//Tin
		@FindBy(id="tin")
		private WebElement tinNumber;
		
		//Tin-nonUS
		@FindBy(id="tinNonUS")
		private WebElement tinNonUS;
		public WebElement tinNonUS(){
			return tinNonUS;
		}
		
		//Confirm Check Box
		@FindBy(id="confirm")
		private WebElement confirmChkBox;
		
		//OK button in confirmation pop up
		@FindBy(css=".ui-dialog-buttonpane .button_green")
		private WebElement confirmationDialog;
		
		//e-Signature pop up iframe
		@FindBy(css="iframe[src*='eSignatureRegistration']")
		private WebElement IFRAMEeSign;
		
		//Password text box in e-Signature pop up iframe
		@FindBy(css="#password")
		private WebElement eSignpassword;
		
		//Submit button in e-Signature pop up iframe
		@FindBy(css="button[title*='Confirm eSignature']")
		private WebElement eSignSubmit;
	
		
		@FindBy(css="[class*='dialog'] [class*='dialog-content']")
		private WebElement dialogContent;
		public WebElement dialogContenttxt(){
			return dialogContent;
		}
		
		@FindBy(css="[class*='dialog'] [class*='green']")
		private WebElement OKBtn;
		public WebElement OKBtn(){
			return OKBtn;
		}
		
				
		public void registrationPage(LinkedHashMap<String, String> dataMap) throws IOException {
			lavanteUtils.waitForTime(4000);
			fillRegisteration(dataMap);
			formRegisteration(dataMap);
		}
		
		
		
		public void fillRegisteration(LinkedHashMap<String, String> dataMap) {
			lavanteUtils.fluentwait(accSetupnextBtn);
			
			if(dataMap.containsKey("errmsg")){
				String err = dataMap.get("errmsg");
			
				if(dataMap.containsKey("#")){
					String[] expErrMsgList = err.split("#");
					System.out.println(expErrMsgList.length);
						for(int i=0;i<expErrMsgList.length;i++)
						{
						System.out.println(expErrMsgList[i]);
						//String loct="option[title='"+errMsgList[i]+"']";
						}
						
				}	
			}
			
			
			if(dataMap.containsKey("contactName")){
				lavanteUtils.typeinEdit(dataMap.get("contactName"), contactName);	
			}
			
			if(dataMap.containsKey("country")){
				lavanteUtils.click(country);
				lavanteUtils.selectvalueFrmDpdn(dataMap.get("country"));		
			}
			
			if(dataMap.containsKey("companyLegalName")){
				lavanteUtils.typeinEdit(dataMap.get("companyLegalName"), companyLegalName);
			}
			
			if(dataMap.containsKey("USIncomeOption")){
				String optionfromExcel = dataMap.get("USIncomeOption");
				
				if(NonUSSourceIncome.size()>0){
					if(optionfromExcel.equalsIgnoreCase("YES")){
						lavanteUtils.clickJavaScriptNoWait(NonUSSourceIncome.get(0));
					}
					else
						lavanteUtils.clickJavaScriptNoWait(NonUSSourceIncome.get(1));	
				}
			}
			
			if(dataMap.containsKey("VATNumber")){
				String optionfromExcel = dataMap.get("VATNumber");
				if(dataMap.containsKey("VATOther")){
				if(dataMap.get("VATOther").equalsIgnoreCase("Other")){
					if(VATNumber.size()>0){
						if(optionfromExcel.equalsIgnoreCase("YES")){
							lavanteUtils.clickJavaScriptNoWait(VATOther.get(0));
						}
						else
							lavanteUtils.clickJavaScriptNoWait(VATOther.get(1));	
					}
				}
				}else{
					if(VATNumber.size()>0){
						if(optionfromExcel.equalsIgnoreCase("YES")){
							lavanteUtils.clickJavaScriptNoWait(VATNumber.get(0));
						}
						else
							lavanteUtils.clickJavaScriptNoWait(VATNumber.get(1));	
					}
				} 
			}
			if(dataMap.containsKey("tinNumber")){
				String tinString = dataMap.get("tinNumber");
				if(tinString.equalsIgnoreCase("ANY")){
					tinString = "" + lavanteUtils.generateRandomNumberOnLength(9);
				}
				lavanteUtils.typeinEdit(tinString, tinNumber);
			}
			
			if(dataMap.containsKey("confirmChkBox")){
				lavanteUtils.Scrollintoview(confirmChkBox);
				lavanteUtils.selectChkBox(confirmChkBox,"yes");
				lavanteUtils.switchtoFrame(IFRAMEeSign);

				lavanteUtils.typeinEdit(dataMap.get("confirmpass"), eSignpassword);	
				lavanteUtils.click(eSignSubmit);
				lavanteUtils.switchtoFrame(null);
			}
		}
		
		private void formRegisteration(LinkedHashMap<String, String> dataMap) 
		{
			if(dataMap.containsKey("accSetupnextBtn")){
				lavanteUtils.click(accSetupnextBtn);
			}

		}
		
}
