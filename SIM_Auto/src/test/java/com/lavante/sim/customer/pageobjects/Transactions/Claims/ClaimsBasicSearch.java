package com.lavante.sim.customer.pageobjects.Transactions.Claims;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ClaimsBasicSearch {
	LavanteUtils lavanteUtils = new LavanteUtils();

	public ClaimsBasicSearch(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	@FindBy(id = "search_tab")
	private WebElement BasicSearchTab;

	public WebElement BasicSearchTab() {
		return BasicSearchTab;
	}

	@FindBy(id = "supplierERPID")
	private WebElement supplierIdTxt;

	public WebElement supplierIdTxt() {
		return supplierIdTxt;
	}

	@FindBy(id = "supplierName")
	private WebElement supplierNametxt;

	public WebElement supplierNametxt() {
		return supplierNametxt;
	}

	@FindBy(id = "claimID")
	private WebElement claimIdtxt;

	public WebElement claimIdtxt() {
		return claimIdtxt;
	}

	// Claim Type multiselect
	@FindBy(css = "div#claimTypeID_chosen>ul>li[class*='field']")
	private WebElement claimTypedpdn;

	public WebElement claimTypetxt() {
		return claimTypedpdn;
	}
	
	@FindBy(css = "div#claimTypeID_chosen>ul>li")
	private WebElement claimTypeDropdwntxt;

	public WebElement claimTypeDropdwntxt() {
		return claimTypeDropdwntxt;
	}

	@FindBy(css = "div#claimStatusID_chosen li input")
	private WebElement claimStatusDropdwn;

	public WebElement claimStatusDropdwn() {
		return claimStatusDropdwn;
	}

	@FindBy(css = "div#claimResolutionID_chosen ul li input")
	private WebElement ClaimResolutionDropdwn;

	public WebElement ClaimResolutionDropdwn() {
		return ClaimResolutionDropdwn;
	}

	@FindBy(id = "paymentRefNumber")
	private WebElement paymentRefNotxt;

	public WebElement paymentRefNotxt() {
		return paymentRefNotxt;
	}

	@FindBy(id = "invoiceNumber")
	private WebElement invoiceNumbertxt;

	public WebElement invoiceNumbertxt() {
		return invoiceNumbertxt;
	}

	// Division multiselect
	@FindBy(css = "div#divisionId_chosen>ul>li")
	private WebElement Divisiontxt;

	public WebElement Divisiontxt() {
		return Divisiontxt;
	}

	@FindBy(css = "div#divisionId_chosen ul li input")
	private WebElement DivisionDropdwn;

	public WebElement DivisionDropdwn() {
		return DivisionDropdwn;
	}

	@FindBy(id = "poNumber")
	private WebElement poNumbertxt;

	public WebElement poNumbertxt() {
		return poNumbertxt;
	}

	@FindBy(id = "fromClaimDate")
	private WebElement fromClaimDatetxt;

	public WebElement fromClaimDatetxt() {
		return fromClaimDatetxt;
	}

	@FindBy(id = "toClaimDate")
	private WebElement toClaimDatetxt;

	public WebElement toClaimDatetxt() {
		return toClaimDatetxt;
	}

	@FindBy(xpath = "//input[@id='myClaims']/../label")
	private WebElement myClaimsChkbox;

	public WebElement myClaimsChkbox() {
		return myClaimsChkbox;
	}
	
	@FindBy(id = "IsAttachmentAvailable")
	private WebElement isAtchment;

	@FindBy(css = "button[class*='prim']")
	private WebElement Searchbtn;

	public WebElement Searchbtn() {
		return Searchbtn;
	}

	@FindBy(css = "button[name='clear']")
	private WebElement Clearbtn;

	public WebElement Clearbtn() {
		return Clearbtn;
	}

	public void Search(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		fillSearchdetails(dataMap);
		formAction(dataMap);

	}

	public void clickBasicSearchTab() {
		lavanteUtils.click(BasicSearchTab);
	}

	public void fillSearchdetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(Searchbtn);
		if (dataMap.containsKey("SupplierId")) {
			lavanteUtils.typeinEdit(dataMap.get("SupplierId"), supplierIdTxt);

		}
		if (dataMap.containsKey("SupplierName")) {
			supplierNametxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("SupplierName"), supplierNametxt);
		}
		if (dataMap.containsKey("ClaimId")) {
			claimIdtxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("ClaimId"), claimIdtxt);

		}
		if (dataMap.containsKey("ClaimType")) {
			lavanteUtils.click(claimTypedpdn);
			lavanteUtils.selectFrmDpdn(dataMap.get("ClaimType"));
		}
		if (dataMap.containsKey("ClaimStatus")) {
			if (dataMap.get("ClaimStatus").contains("#")) {
				String getStatus[] = dataMap.get("ClaimStatus").split("#");
				for (int i = 0; i < getStatus.length; i++) {
					lavanteUtils.click(claimStatusDropdwn);
					lavanteUtils.selectValueFrmdropdown(getStatus[i]);
				}
			} else {
				lavanteUtils.click(claimStatusDropdwn);
				lavanteUtils.selectValueFrmdropdown(dataMap.get("ClaimStatus"));
			}
		}

		if (dataMap.containsKey("ClaimResolution")) {

			if (dataMap.get("ClaimResolution").contains("#")) {
				String getStatus[] = dataMap.get("ClaimResolution").split("#");
				for (int i = 0; i < getStatus.length; i++) {
					lavanteUtils.click(ClaimResolutionDropdwn);
					lavanteUtils.selectValueFrmdropdown(getStatus[i]);
				}
			} else {
				lavanteUtils.click(ClaimResolutionDropdwn);
				lavanteUtils.selectValueFrmdropdown(dataMap.get("ClaimResolution"));
			}
		}
		if (dataMap.containsKey("PaymentRefNo")) {
			paymentRefNotxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("PaymentRefNo"), paymentRefNotxt);

		}
		if (dataMap.containsKey("InvoiceNo")) {
			invoiceNumbertxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("InvoiceNo"), invoiceNumbertxt);

		}
		if (dataMap.containsKey("Division")) {
			lavanteUtils.click(Divisiontxt);
			lavanteUtils.selectFrmDpdn(dataMap.get("Division"));
		}
		if (dataMap.containsKey("PONumber")) {
			poNumbertxt.clear();
			lavanteUtils.typeinEdit(dataMap.get("PONumber"), poNumbertxt);
		}
		if (dataMap.containsKey("MyClaims")) {
			lavanteUtils.click(myClaimsChkbox);

		}
		if (dataMap.containsKey("Attachment")) {
			lavanteUtils.selectbyvisibiletxt(dataMap.get("Attachment"), isAtchment);

		}
	}

	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("Search")) {
			lavanteUtils.click(Searchbtn);
		}
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.click(Clearbtn);
		}
	}
}
