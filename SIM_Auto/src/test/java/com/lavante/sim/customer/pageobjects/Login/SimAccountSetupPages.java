
package com.lavante.sim.customer.pageobjects.Login;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Subhas.BV
 *
 */
public class SimAccountSetupPages {

	LavanteUtils lavanteUtils = new LavanteUtils();

	public SimAccountSetupPages(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='error']/parent::td[1]/preceding-sibling::td[1]/label")
	private List<WebElement> ErrorMsgFiledsList;

	public List<WebElement> ErrorMsgFiledsList() {
		return ErrorMsgFiledsList;
	}

	@FindBy(how = How.CLASS_NAME, using = "error")
	private List<WebElement> ErrorMsgList;

	public List<WebElement> ErrorMsgList() {
		return ErrorMsgList;
	}

	// Account set up page
	@FindBy(id = "username")
	private WebElement UserNameTxtBox;

	public WebElement UserNameTxtBox() {
		return UserNameTxtBox;
	}

	@FindBy(css = "[id*='language'] a")
	private WebElement preflanguage;

	public WebElement preflanguage() {
		return preflanguage;
	}

	@FindBy(css = "input[id*='password']")
	private WebElement setpass;

	public WebElement setpass() {
		return setpass;
	}

	@FindBy(css = "input[id*='confirmPassword']")
	private WebElement confirmpass;

	public WebElement confirmpass() {
		return confirmpass;
	}

	@FindBy(css = "[id*='question'] a")
	private WebElement chquestion;

	public WebElement chquestion() {
		return chquestion;
	}

	@FindBy(css = "[id*='answer']")
	private WebElement chanswer;

	public WebElement chanswer() {
		return chanswer;
	}

	@FindBy(css = "[id*='tc']")
	private WebElement checkconfirm;

	public WebElement checkconfirm() {
		return checkconfirm;
	}

	@FindBy(css = "input[type='reset']")
	private WebElement clearbttn;

	public WebElement clearbttn() {
		return clearbttn;
	}

	@FindBy(css = "input[type='submit']")
	private WebElement nextbttn;

	public WebElement nextbttn() {
		return nextbttn;
	}

	@FindBy(xpath = "//span[starts-with(text(),'Decline')]")
	private WebElement VerifyDelcineRadioBtn;

	public WebElement VerifyDelcineRadioBtn() {
		return VerifyDelcineRadioBtn;
	}
	// Company Information Webelements

	@FindBy(id = "companyLegalName")
	private WebElement BusinessnameTxtBox;

	public WebElement BusinessnameTxtBox() {
		return BusinessnameTxtBox;
	}

	@FindBy(id = "tin")
	private WebElement EmployerIdTxtBox;

	public WebElement EmployerIdTxtBox() {
		return EmployerIdTxtBox;
	}

	@FindBy(id = "confirm")
	private WebElement ElectronicSigChkBox;

	public WebElement ElectronicSigChkBox() {
		return ElectronicSigChkBox;
	}

	@FindBy(css = "iframe[src*='eSignatureRegistration']")
	private WebElement IframeElectronicSig;

	public WebElement IframeElectronicSig() {
		return IframeElectronicSig;
	}

	@FindBy(css = "button[title='Confirm eSignature']")
	private WebElement ConfirmESigBtn;

	public WebElement ConfirmESigBtn() {
		return ConfirmESigBtn;
	}
	

	// Reusable Methods
	public void accSetup(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.waitForTime(4000);
		fillRegisteration(dataMap);
		formRegisteration(dataMap);
		lavanteUtils.getSystemTimeStamp();
	}

	private void fillRegisteration(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(nextbttn);
		if (dataMap.containsKey("preflanguage")) {
			lavanteUtils.click(preflanguage);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("preflanguage"));

		}
		if (dataMap.containsKey("setpass")) {
			lavanteUtils.typeinEdit(dataMap.get("setpass"), setpass);

		}
		if (dataMap.containsKey("confirmpass")) {
			lavanteUtils.typeinEdit(dataMap.get("confirmpass"), confirmpass);
		}
		if (dataMap.containsKey("chquestion")) {
			lavanteUtils.click(chquestion);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("chquestion"));
		}
		if (dataMap.containsKey("chanswer")) {
			lavanteUtils.typeinEdit(dataMap.get("chanswer"), chanswer);

		}
		if (dataMap.containsKey("checkconfirm")) {
			lavanteUtils.selectChkBox(checkconfirm, "yes");
		}
	}
	
	/**
	 * Company Registeration
	 * 
	 * @author subhas.bv
	 * @param dataMap
	 */
	public void CompanyRegistration(LinkedHashMap<String, String> dataMap) {
		fillCompanyRegistration(dataMap);
		formRegisteration(dataMap);
	}
	

	public void fillCompanyRegistration(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("BusinessName")) {
			lavanteUtils.typeinEdit(dataMap.get("BusinessName"), BusinessnameTxtBox());
		}
		if (dataMap.containsKey("EINNum")) {
			lavanteUtils.typeinEdit(dataMap.get("EINNum"), EmployerIdTxtBox);
		}
		lavanteUtils.click(ElectronicSigChkBox());
		lavanteUtils.fluentwait(IframeElectronicSig());
		lavanteUtils.switchtoFrame(IframeElectronicSig());
		lavanteUtils.typeinEdit(dataMap.get("setpass"), setpass);
		lavanteUtils.click(ConfirmESigBtn());
		lavanteUtils.switchtoFrame(null);

		
	}
	

	private void formRegisteration(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("nextbttn")) {
			lavanteUtils.click(nextbttn);
		}
		if (dataMap.containsKey("clearbttn")) {
			lavanteUtils.click(clearbttn);
		}
	}

}
