package com.lavante.sim.customer.pageobjects.Admin;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

public class PaymentTermsPage {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public PaymentTermsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css = "a[href*='buyerPaymentTerms']")
	private WebElement PaymentTermsTab;

	public WebElement PaymentTermsTab() {
		return PaymentTermsTab;
	}

	@FindBy(css = "button[href*='addEditPaymentTerms']")
	private WebElement AddPaymentTerms;

	public WebElement AddPaymentTerms() {
		return AddPaymentTerms;
	}

	@FindBy(css = "iframe[src*='addEditPaymentTerms']")
	public WebElement IframePaymentTerms;

	@FindBy(css = "div[id*='paymentCenterId'] a")
	private WebElement PaymentCenterDropDwn;

	public WebElement PaymentCenterDropDwn() {
		return PaymentCenterDropDwn;
	}

	@FindBy(css = "div[id*='paymentTypeId'] a")
	private WebElement PaymentTypeDropDwn;

	public WebElement PaymentTypeDropDwn() {
		return PaymentTypeDropDwn;
	}

	@FindBy(css = "input#paymentName")
	private WebElement PaymentTermsTxtBox;

	public WebElement PaymentTermsTxtBox() {
		return PaymentTermsTxtBox;
	}

	@FindBy(css = "button[value='Save']")
	private WebElement AddPayTermsSaveBtn;

	public WebElement AddPayTermsSaveBtn() {
		return AddPayTermsSaveBtn;
	}

	@FindBy(css = "div[class*='dialog'] [class*='primary']")
	private WebElement OkBtn;

	public WebElement OkBtn() {
		return OkBtn;
	}

	@FindBy(css = "button[value='Reset']")
	private WebElement AddPayTermsResetBtn;

	public WebElement AddPayTermsResetBtn() {
		return AddPayTermsResetBtn;
	}

	@FindBy(css = "button[class*='cancel']")
	private WebElement AddPayTermsCancelBtn;

	public WebElement AddPayTermsCancelBtn() {
		return AddPayTermsCancelBtn;
	}

	@FindBy(css = "table tbody td:nth-child(1)")
	public List<WebElement> ListPaymentCntrName;

	@FindBy(css = "table tbody td:nth-child(2)")
	public List<WebElement> ListPaymentType;

	@FindBy(css = "table tbody td:nth-child(3)")
	public List<WebElement> ListPaymentTerms;

	@FindBy(css = "a[href*='edit']")
	public List<WebElement> ListEditPaymentTerms;

	@FindBy(css = "a[href*='delete']")
	public List<WebElement> ListDeletePaymentTerms;
	
	@FindBy(css = "span[class='error']")
	private WebElement Errormsg;
	public WebElement Errormsg(){
		return Errormsg;
	}

	/**
	 * MethodName : addNewPaymentTerms : will add new payment terms *
	 * 
	 * @param testData
	 *            : LinkedHashMap<String, String> testData
	 */

	public LinkedHashMap<String, String> addNewPaymentTerms(
			LinkedHashMap<String, String> testData) {

		Reporter.log("Adding new payment terms");

		clickAddPaymentTerms();
		LinkedHashMap<String, String> dataMap = fillPaymentTerms(testData);
		formAction(testData);
		return dataMap;
	}

	private void clickAddPaymentTerms() {
		lavanteUtils.fluentwait(AddPaymentTerms);
		lavanteUtils.click(AddPaymentTerms);
	}

	public LinkedHashMap<String, String> fillPaymentTerms(
			LinkedHashMap<String, String> testData) {
		String data = "";
		lavanteUtils.waitForTime(2000);
		lavanteUtils.switchtoFrame(IframePaymentTerms);
		
		if (testData.containsKey("PaymentCenter")) {
			lavanteUtils.click(PaymentCenterDropDwn);
			data = lavanteUtils.selectvalueFrmDpdn(testData.get("PaymentCenter"));
			testData.put("PaymentCenter", data);
			lavanteUtils.switchtoFrame(IframePaymentTerms);
		}
		if (testData.containsKey("PaymentType")) {
			lavanteUtils.click(PaymentTypeDropDwn);
			data= lavanteUtils.selectvalueFrmDpdn(testData.get("PaymentType"));
			testData.put("PaymentType", data);
			lavanteUtils.switchtoFrame(IframePaymentTerms);
		}
		if (testData.containsKey("PaymentTerms")) {
			PaymentTermsTxtBox.clear();
			data = lavanteUtils.typeString(testData.get("PaymentTerms"),PaymentTermsTxtBox);
			testData.put("PaymentTerms", data);
		}
		return testData;
	}

	public void formAction(LinkedHashMap<String, String> testData) {
		lavanteUtils.switchtoFrame(IframePaymentTerms);
		if (testData.containsKey("Save")) {
			lavanteUtils.fluentwait(AddPayTermsSaveBtn);
			lavanteUtils.click(AddPayTermsSaveBtn);
			lavanteUtils.switchtoFrame(null);
			/*lavanteUtils.fluentwait(OkBtn);
			lavanteUtils.click(OkBtn);*/
		}

		if (testData.containsKey("Reset")) {
			lavanteUtils.click(AddPayTermsResetBtn);
			lavanteUtils.click(AddPayTermsResetBtn);
		}

		if (testData.containsKey("Cancel")) {
			lavanteUtils.click(AddPayTermsCancelBtn);
			lavanteUtils.switchtoFrame(null);
		}

	}
	
	/**Sanity
	 * 
	 * @author Thejaswi.Bhat
	 */
	public boolean verifyPaymentTermsPage() {
		boolean flag=false;
		lavanteUtils.switchtoFrame(null);
		flag=lavanteUtils.verifyElementDisplayed("Add Payment Terms Button", AddPaymentTerms);
		
		return flag;
	}
}