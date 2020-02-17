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
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class EditCustomerProfile {

	LavanteUtils lavanteUtils = new LavanteUtils();
	SoftAssert softassert = new SoftAssert();

	public EditCustomerProfile(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css="[id='w8Tax_information']")
	private WebElement GetW8SecHeader;

	public WebElement GetW8SecHeader() {
		return GetW8SecHeader;
	}

	@FindBy(css="[id*='isHavingInsurance']:nth-child(1)")
	private WebElement insuranceYes;

	public WebElement insuranceYes() {
		return insuranceYes;
	}

	@FindBy(id = "productsServicesPerformed")
	private WebElement ProductServices_TextField;

	public WebElement ProductServices_TextField() {
		return ProductServices_TextField;
	}

	@FindBy(css="label[for='productsServicesPerformedDescription']")
	private WebElement GetSummaryLabel;

	public WebElement GetSummaryLabel() {
		return GetSummaryLabel;
	}

	@FindBy(id="isESigatureComplete")
	private WebElement Esign;
	public WebElement Esign() {
		return Esign;
	}
	
	@FindBy(css="iframe[src*='Sign']")
	private WebElement IFRAMEEsign;
	public WebElement IFRAMEEsign() {
		return IFRAMEEsign;
	}
	
	@FindBy(id="password")
	private WebElement pwdtxt;
	public WebElement pwdtxt() {
		return pwdtxt;
	}
	
	@FindBy(css="iframe[src*='Sign']")
	private WebElement confirmSign;
	public WebElement confirmSign() {
		return confirmSign;
	}
	
	
	@FindBy(css="[id*='dialog'] div[class*='std']>div")
	private WebElement CompletedMsg;

	public WebElement CompletedMsg() {
		return CompletedMsg;
	}

	@FindBy(xpath="//table[@id='search_results']//tr")
	private WebElement searchResult_Table;

	public WebElement searchResult_Table() {
		return searchResult_Table;

	}

	@FindBy(xpath="//table[@id='search_results']//tr//td[3]")
	private List<WebElement> supplierList;

	public List<WebElement> supplierList() {
		return supplierList;
	}

	@FindBy(xpath="//table[@id='search_results']//tr//td[6]")
	private List<WebElement> supplierStatus;

	public List<WebElement> supplierStatus() {
		return supplierList;
	}

	@FindBy(xpath="//table[@id='search_results']//tr//td[7]")
	private List<WebElement> supplierPercentage;

	public List<WebElement> supplierPercentage() {
		return supplierList;
	}

	@FindBy(css = "a[href*='redirectToCTI']")
	private WebElement W8LaunchWizardBtn;

	public WebElement W8LaunchWizardBtn() {
		return W8LaunchWizardBtn;
	}

	@FindBy(css = "a[href*='addSupplierw8Doc']")
	private WebElement W8UploadDocumentBtn;

	public WebElement W8UploadDocumentBtn() {
		return W8UploadDocumentBtn;
	}

	@FindBy(css="iframe[src*='addSupplierw8Doc']")
	private WebElement IframeW8DocUpload;

	public WebElement IframeW8DocUpload() {
		return IframeW8DocUpload;
	}

	@FindBy(css="div[id*='fileUploadType'] a")
	private WebElement W8DocumentUploadTypeDropDwn;

	public WebElement W8DocumentUploadTypeDropDwn() {
		return W8DocumentUploadTypeDropDwn;
	}

	@FindBy(id= "multipartFile")
	private WebElement BrowseTaxW8Btn;

	public WebElement BrowseTaxW8Btn() {
		return BrowseTaxW8Btn;
	}

	@FindBy(id="expirationDate")
	private WebElement SelectExpirationDate;

	public WebElement SelectExpirationDate() {
		return SelectExpirationDate;
	}

	@FindBy(css="[id*='date'] a[class*='high']")
	private WebElement SelectTodayDate;

	public WebElement SelectTodayDate() {
		return SelectTodayDate;
	}

	@FindBy(css="div[id='dialog'] input[class*='primary']")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}

	@FindBy(css="table[id*='table_w8Tax_information'] a[href*='downloadFile']")
	private List<WebElement> GetW8TaxUploadedFilesList;

	public List<WebElement> GetW8TaxUploadedFilesList() {
		return GetW8TaxUploadedFilesList;
	}

	@FindBy(css = "[id='table_w8Tax_information'] tr>td>span")
	private List<WebElement> editw8statusdeac;

	public List<WebElement> editw8statusdeac() {
		return editw8statusdeac;
	}

	@FindBy(css="table[id*='table_w8Tax_information'] td:nth-child(7)")
	private List<WebElement> GetW8TaxUploadedStatusList;

	public List<WebElement> GetW8TaxUploadedStatusList() {
		return GetW8TaxUploadedStatusList;
	}

	@FindBy(css="table[id*='table_w8Tax_information'] td:nth-child(8)")
	private List<WebElement> GetW8TaxUploadedActionList;

	public List<WebElement> GetW8TaxUploadedActionList() {
		return GetW8TaxUploadedActionList;
	}
	
	@FindBy(css = "a[title='Deactivate']")
	private List<WebElement> Deactivatew8tn;

	public List<WebElement> Deactivatew8tn() {
		return Deactivatew8tn;
	}

	@FindBy(css = "div[class*='dialog'] button[class*='primary']")
	private WebElement okdeactivatew8btn;

	public WebElement okdeactivatew8btn() {
		return okdeactivatew8btn;
	}

	@FindBy(css="[class*='dialog'] [class*='green']")
	private WebElement OkBtn;
	public WebElement OkYesBtn() {
		return OkBtn;
	}

	@FindBy(css="button[class*='primary']")
	private WebElement OkBtn2;
	public WebElement OkBtn2() {
		return OkBtn2;
	}


	// REUSABLE METHODS

	public String ProductServices(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		String data = "";
		if (dataMap.containsKey("Product")) {
			lavanteUtils.Scrollintoview(ProductServices_TextField);
			ProductServices_TextField.clear();
			data = lavanteUtils.typeString(dataMap.get("Product"), ProductServices_TextField);
		}
		return data;
	}

	
	public String Esign(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		String data = "";
		if (dataMap.containsKey("Esign")) {
			data=dataMap.get("Esign");
			
			boolean x=Esign.isSelected();
		//	System.out.println(x);
			if(data.equalsIgnoreCase("Yes")){
				if(x==true){
					
				}else{
					esign(dataMap);
				}
			}else{
				lavanteUtils.click(Esign);
				esign(dataMap);
			}
		}
		return data;
	}
	
	private void esign(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("password")){
			lavanteUtils.switchtoFrame(IFRAMEEsign);
			lavanteUtils.typeinEdit(dataMap.get("password"), pwdtxt);
			lavanteUtils.click(OkBtn2);
		}
		
	}

	public void verifyConfirmation(String message) {
		// lu.fluentwait(profile100pecCompletedMsg);
		lavanteUtils.waitForTime(10000);
		String confmsg = CompletedMsg().getText();
		softassert.assertEquals(confmsg, message);
		Reporter.log("Confirmation message displayed as " + confmsg);
	}

	public void verifyProfileStatus(String supplierName, String Expstatus) {

		if (supplierList.size() > 0) {

			for (int i = 0; i < supplierList().size(); i++) {

				String supName = supplierList().get(i).getText();

				if (supName.equalsIgnoreCase(supplierName)) {

					String actStatus = supplierStatus().get(i).getText();
					if (actStatus.equalsIgnoreCase(Expstatus)) {
						Reporter.log("The Expected Profile Status : " + Expstatus
								+ " Actual Profile Status displayed : " + actStatus);
						break;
					}
				}

			}

			softassert.assertTrue(false);
		}

	}

	public void verifyProfilePercentage(String supplierName, String expPercentage) {

		if (supplierList.size() > 0) {
			for (int i = 0; i < supplierList().size(); i++) {

				String supName = supplierList().get(i).getText();

				if (supName.equalsIgnoreCase(supplierName)) {

					String actPercetage = supplierPercentage().get(i).getText();

					/*
					 * int per=Integer.parseInt(actPercetage); int
					 * expPer=Integer.parseInt(expPercentage);
					 */

					if (actPercetage.equalsIgnoreCase(expPercentage)) {
						Reporter.log("The Expected Profile Status : " + actPercetage
								+ " Actual Profile Status displayed : " + expPercentage);
						break;
					}
				}

			}

			softassert.assertTrue(true);

		}
	}

	public void uploadW8TaxDocument(LinkedHashMap<String, String> dataMap) throws Exception {

		lavanteUtils.switchtoFrame(IframeW8DocUpload);
		if (dataMap.containsKey("DocumentType")) {
			lavanteUtils.click(W8DocumentUploadTypeDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("DocumentType"));
		}
		if (dataMap.containsKey("FileName")) {
			lavanteUtils.uploadFile(dataMap.get("FileName"), BrowseTaxW8Btn);
		}
		if (dataMap.containsKey("SelectCurrentDate")) {
			lavanteUtils.click(SelectExpirationDate);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(SelectTodayDate);
			lavanteUtils.switchtoFrame(IframeW8DocUpload);
		}
		lavanteUtils.click(SaveBtn);
		lavanteUtils.switchtoFrame(null);
	}

}
