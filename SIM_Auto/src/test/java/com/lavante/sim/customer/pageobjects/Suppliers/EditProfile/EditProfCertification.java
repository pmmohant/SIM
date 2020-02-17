/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.EditProfile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class EditProfCertification {

	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;

	public EditProfCertification(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(css="iframe[src*='Insurance']")
	private WebElement iframeaddins;

	public WebElement iframeaddins() {
		return iframeaddins;
	}

	@FindBy(css="iframe[src*='minority']")
	private WebElement IFRAMEAddMinority;

	public WebElement IFRAMEAddMinority() {
		return IFRAMEAddMinority;
	}

	@FindBy(css="iframe[src*='small']")
	private WebElement IFRAMESmallBusiness;

	public WebElement IFRAMESmallBusiness() {
		return IFRAMESmallBusiness;
	}

	// Insurance

	@FindBy(css="label[for*='insuranceYes']~label")
	private WebElement insuranceYes;

	public WebElement insuranceYes() {
		return insuranceYes;
	}

	@FindBy(css="a[href*='table_insurance']")
	private WebElement addinsurancebtn;

	public WebElement addinsurancebtn() {
		return addinsurancebtn;
	}

	// ADD INSURANCE

	@FindBy(id="insurerName")
	private WebElement AddInsuranceName;

	public WebElement AddInsuranceName() {
		return AddInsuranceName;
	}

	@FindBy(css="[id*='supplierInsuranceTypes'] input")
	private WebElement AddPolicytype;

	public WebElement AddPolicytype() {
		return AddPolicytype;
	}

	@FindBy(css="[id*='supplierInsuranceTypes']")
	private WebElement AddPolicytype1;

	public WebElement AddPolicytype1() {
		return AddPolicytype1;
	}

	@FindBy(css="div[class*='drop'] li")
	private WebElement dpddn;

	public WebElement dpddn() {
		return dpddn;
	}

	@FindBy(id="coverageLevel")
	private WebElement CoverageLimitTxtBox;

	public WebElement CoverageLimitTxtBox() {
		return CoverageLimitTxtBox;
	}

	@FindBy(css="span[data-messagebag-id*='coverageLevel']")
	private WebElement CoverageLimitMandatoryMsg;

	public WebElement CoverageLimitMandatoryMsg() {
		return CoverageLimitMandatoryMsg;
	}

	@FindBy(css="div[id*='coverageCurrency'] a")
	private WebElement SelectCurrencyDropDwn;

	public WebElement SelectCurrencyDropDwn() {
		return SelectCurrencyDropDwn;
	}

	@FindBy(id="insuranceCertificate")
	private WebElement uploadInsurance;

	public WebElement uploadInsurance() {
		return uploadInsurance;
	}

	@FindBy(css="#command [type='submit']")
	private WebElement Insurancesavebtn;

	public WebElement Insurancesavebtn() {
		return Insurancesavebtn;
	}

	@FindBy(css="#command button[class*='cancel']")
	private WebElement InsuranceCancelBtn;

	public WebElement InsuranceCancelBtn() {
		return InsuranceCancelBtn;
	}

	// View
	@FindBy(css="[id*='insurance_info'] td:nth-child(1)")
	private List<WebElement> ViewListInsuranceName;

	public List<WebElement> ViewListInsuranceName() {
		return ViewListInsuranceName;
	}

	@FindBy(css="[id*='insurance_info'] td:nth-child(6)")
	private List<WebElement> getCoverageLimitAmount;

	public List<WebElement> getCoverageLimitAmount() {
		return getCoverageLimitAmount;
	}

	@FindBy(css="div[id*='coverageCurrency']+span.error")
	private WebElement CoverageCurrencyMandatoryMsg;

	public WebElement CoverageCurrencyMandatoryMsg() {
		return CoverageCurrencyMandatoryMsg;
	}

	@FindBy(css="a[class*='delete'][href*='delete']")
	private List<WebElement> DelInsurance;

	public List<WebElement> DelInsurance() {
		return DelInsurance;
	}

	@FindBy(css="[class*='dialog'] button[class*='primary']")
	private WebElement Okbtn;

	public WebElement Okbtn() {
		return Okbtn;
	}

	// Small Business
	@FindBy(css="[id*='small_business_information']~div p:nth-child(1)")
	private List<WebElement> smallBusinessInfoLabel;	
	public List<WebElement>  smallBusinessInfoLabel(){
		return smallBusinessInfoLabel;
	}
	
	@FindBy(css="[name*='isSmall']~label")
	private WebElement smallBusinessYes;

	public WebElement smallBusinessYes() {
		return smallBusinessYes;
	}

	@FindBy(css="a[href*='small']")
	private WebElement addSmallBusinessBtn;

	public WebElement addSmallBusinessBtn() {
		return addSmallBusinessBtn;
	}

	// Minority Business
	@FindBy(css="[name*='isMinorityBusinessAgencyCertified']~label")
	private WebElement minorityYes;

	public WebElement minorityYes() {
		return minorityYes;
	}

	@FindBy(css="a[href*='minority']")
	private WebElement addMinorityBtn;

	public WebElement addMinorityBtn() {
		return addMinorityBtn;
	}

	// ADD Minorty Fields //Add Small Business field Both share same locator

	@FindBy(css="[id*='diversity'] a")
	private WebElement BusinessType;

	public WebElement BusinessType() {
		return BusinessType;
	}

	@FindBy(css="[id*='agency'] a")
	private WebElement Agency;

	public WebElement Agency() {
		return Agency;
	}

	// REUSABLE METHODS

	/**
	 * MAin method to fill Certification
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws IOException
	 */
	public void fillCertification(LinkedHashMap<String, String> dataMap) throws IOException {

		lavanteUtils.fluentwait(insuranceYes);
		lavanteUtils.waitForTime(5000);

		if (dataMap.containsKey("addInsurance")) {

			lavanteUtils.click(insuranceYes);
			addInsurance(dataMap);
		}

	}

	public void addInsurance(LinkedHashMap<String, String> dataMap) throws IOException {

		lavanteUtils.fluentwait(addinsurancebtn);
		lavanteUtils.click(addinsurancebtn);
		fillInsurancedetails(dataMap);
		formInsurance(dataMap);

	}

	public void fillInsurancedetails(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.switchtoFrame(iframeaddins);
		if (dataMap.containsKey("InsuranceName")) {
			AddInsuranceName().clear();
			lavanteUtils.typeinEdit(dataMap.get("InsuranceName"), AddInsuranceName);
		}
		if (dataMap.containsKey("policytype")) {
			String content = dataMap.get("policytype");
			if (content.contains("#")) {

			} else {
				lavanteUtils.click(AddPolicytype);
				if (!dataMap.get("policytype").equalsIgnoreCase("any")) {

					lavanteUtils.typeinEdit(content, AddPolicytype);
				}
				lavanteUtils.waitForTime(3000);
				lavanteUtils.selectvalueFrmDpdn(content);
				lavanteUtils.switchtoFrame(iframeaddins);
				/*
				 * lavanteUtils.switchtoFrame(null);
				 * lavanteUtils.waitfortime(3000);
				 * lavanteUtils.fluentwait(dpddn);
				 * lavanteUtils.clickJavaScript(dpddn); Actions actions = new
				 * Actions(lavanteUtils.driver);
				 * actions.moveToElement(dpddn).click().perform();
				 */
				

				/*
				 * while (!lavanteUtils.isElementPresent(
				 * driver.findElements(By.cssSelector(
				 * "[id*='invitingOrganization']>ul>li>span")))) {
				 * 
				 * lavanteUtils.click(AddPolicytype);
				 * lavanteUtils.waitForTime(5000);
				 * lavanteUtils.selectvalueFrmDpdn(content);
				 * lavanteUtils.switchtoFrame(iframeaddins); }
				 */

				/*
				 * Select s=new Select(AddPolicytype1); List<WebElement>
				 * ss=s.getOptions(); for(int i=0;i<ss.size();i++){
				 * System.out.println(ss.get(i).getText()+":"+content); if(
				 * ss.get(i).getText().equalsIgnoreCase(content)){
				 * s.selectByVisibleText(content); }else {
				 * //lavanteUtils.click(ss.get(i)); s.selectByValue("707"); } }
				 */

			}
		}
		if (dataMap.containsKey("policyNum")) {

		}
		if (dataMap.containsKey("effectiveDate")) {

		}
		if (dataMap.containsKey("expirationDate")) {

		}
		if (dataMap.containsKey("coverageLimit")) {
		//	if (dataMap.containsKey("ValidAmount")) 
			{
				lavanteUtils.typeinEdit(dataMap.get("coverageLimit"), CoverageLimitTxtBox);
			}
			
		}
		if (dataMap.containsKey("CurrencyType")) {

			lavanteUtils.click(SelectCurrencyDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("CurrencyType"));
			lavanteUtils.switchtoFrame(iframeaddins);
		}
		if (dataMap.containsKey("uploadInsurance")) {
			lavanteUtils.uploadFile(dataMap.get("uploadInsurance"), uploadInsurance);
		}

	}

	public void formInsurance(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.waitForTime(4000);
		if (dataMap.containsKey("InsuranceSave")) {
			lavanteUtils.click(Insurancesavebtn);
			lavanteUtils.switchtoFrame(null);
			// lavanteUtils.refreshPage();
		}
	}

	/**
	 * Main Method to do Fill Minority Method
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	public void fillSmallBusiness(LinkedHashMap<String, String> dataMap) throws IOException {

		lavanteUtils.fluentwait(smallBusinessYes);
		lavanteUtils.waitForTime(5000);

		if (dataMap.containsKey("addSmallBusiness")) {

			lavanteUtils.click(smallBusinessYes);
			addSmallBusiness(dataMap);
		}

	}

	/**
	 * Add Minority Method
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	private void addSmallBusiness(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(addSmallBusinessBtn);
		lavanteUtils.click(addSmallBusinessBtn);

		EnterSmallBusiness(dataMap);
		formMinority(dataMap);

	}

	private void EnterSmallBusiness(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMESmallBusiness);
		if (dataMap.containsKey("BusinessType")) {
			String content = dataMap.get("BusinessType");
			lavanteUtils.click(BusinessType);
			// lavanteUtils.typeinEdit(content,MinorityBusinessType);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectvalueFrmDpdn(content);
			lavanteUtils.switchtoFrame(IFRAMESmallBusiness);
		}
		if (dataMap.containsKey("Agency")) {
			String content = dataMap.get("Agency");
			lavanteUtils.click(Agency);
			// lavanteUtils.typeinEdit(content,MinorityAgency);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectvalueFrmDpdn(content);
			lavanteUtils.switchtoFrame(IFRAMESmallBusiness);
		}
	}

	private void formSmallBusiness(LinkedHashMap<String, String> dataMap) {

	}

	/**
	 * Main Method to do -Fill SmallBusiness Method
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	public void fillMinorityBusiness(LinkedHashMap<String, String> dataMap) throws IOException {

		lavanteUtils.fluentwait(minorityYes);
		lavanteUtils.waitForTime(5000);

		if (dataMap.containsKey("addMinority")) {

			lavanteUtils.click(minorityYes);
			addMinority(dataMap);
		}

	}

	/**
	 * Add Minority Method
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	private void addMinority(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(addMinorityBtn);
		lavanteUtils.click(addMinorityBtn);

		EnterMinority(dataMap);
		formMinority(dataMap);

	}

	private void EnterMinority(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEAddMinority);
		if (dataMap.containsKey("BusinessType")) {
			String content = dataMap.get("BusinessType");
			lavanteUtils.click(BusinessType);
			// lavanteUtils.typeinEdit(content,MinorityBusinessType);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectvalueFrmDpdn(content);
			lavanteUtils.switchtoFrame(IFRAMEAddMinority);
		}
		if (dataMap.containsKey("Agency")) {
			String content = dataMap.get("Agency");
			lavanteUtils.click(Agency);
			// lavanteUtils.typeinEdit(content,MinorityAgency);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectvalueFrmDpdn(content);
			lavanteUtils.switchtoFrame(IFRAMEAddMinority);
		}
	}

	private void formMinority(LinkedHashMap<String, String> dataMap) {

	}

}
