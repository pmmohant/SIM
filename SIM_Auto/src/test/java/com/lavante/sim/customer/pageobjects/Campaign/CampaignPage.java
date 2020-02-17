package com.lavante.sim.customer.pageobjects.Campaign;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * 
 * @author Subhas
 */
public class CampaignPage {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public CampaignPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	/**
	 * click on Campaign -> create campaign
	 */

	@FindBy(css = "a[class*='button_primary'][href*='createCampaignDetails']")
	private WebElement CreateCampaignBtn;

	public WebElement CreateCampaignBtn() {
		return CreateCampaignBtn;
	}

	@FindBy(id = "campaignName")
	private WebElement CampaignNameTxtBox;

	public WebElement CampaignNameText() {
		return CampaignNameTxtBox;
	}

	@FindBy(id = "campaignDescription")
	private WebElement CampaignDescriptionTxtBox;

	public WebElement CampaignDescriptionText() {
		return CampaignDescriptionTxtBox;
	}
	
	@FindBy(id = "campaignType")
	private WebElement CampaignTypeSel;

	public WebElement CampaignTypeSel() {
		return CampaignTypeSel;
	}

	@FindBy(css = "div[id*='campaignType'] a")
	private WebElement CampaignTypeDrpDwn;

	public WebElement CampaignTypeDrpdwn() {
		return CampaignTypeDrpDwn;
	}

	@FindBy(id = "plannedStartDate")
	private WebElement PlannedStartDate;

	public WebElement PlannedStartDate() {
		return PlannedStartDate;
	}

	@FindBy(id = "plannedEndDate")
	private WebElement PlannedEndDate;

	public WebElement PlannedEndDate() {
		return PlannedEndDate;
	}

	@FindBy(css = "div[id*='campaignOwnerContact'] a")
	private WebElement CampaignOwnerDrpdwn;

	public WebElement CampaignOwnerDrpdwn() {
		return CampaignOwnerDrpdwn;
	}

	@FindBy(css = "div[id*='campaignOwnerContact'] input")
	private WebElement CampaignOwnerDrpdwnTxt;

	public WebElement CampaignOwnerDrpdwnTxt() {
		return CampaignOwnerDrpdwnTxt;
	}

	@FindBy(css = "div[id*='allDivisions'] ul li")
	private WebElement RequestingDivisionDropDwn;

	public WebElement RequestingDivisionDropDwn() {
		return RequestingDivisionDropDwn;
	}

	@FindBy(css = "div[id='savedSearch_chosen'] a span")
	private WebElement SelectQueryDrpDwn;

	public WebElement SelectQueryDrpdwn() {
		return SelectQueryDrpDwn;
	}

	@FindBy(css = "span[class='query-name']")
	private WebElement GetQueryName;

	public WebElement GetQueryName() {
		return GetQueryName;
	}

	@FindBy(css = "a[href*='viewCampaignSupplierDetails']")
	private WebElement GetSupplierInScope;

	public WebElement GetSupplierInScope() {
		return GetSupplierInScope;
	}

	@FindBy(id = "recipients-all")
	private WebElement RecipientsallContacts;

	public WebElement RecipientsallContacts() {
		return RecipientsallContacts;
	}

	@FindBy(id = "recipients-contact-type")
	private WebElement ContactType;

	public WebElement ContactType() {
		return ContactType;
	}

	@FindBy(id = "contact_type_chosen")
	private WebElement SelectType;

	public WebElement SelectType() {
		return SelectType;
	}

	@FindBy(css = "[id*='selectTemplate'] a")
	private WebElement EmailTempleteDropDwn;

	public WebElement EmailTempleteDropDwn() {
		return EmailTempleteDropDwn;
	}

	@FindBy(css = "[class*='image'][for='supplierPaymentRequired_No']")
	private WebElement SupplierChargedNoRadioBtn;

	public WebElement SupplierChargedNoRadioBtn() {
		return SupplierChargedNoRadioBtn;
	}

	@FindBy(id = "preview")
	private WebElement PreviewEmail;

	public WebElement PreviewEmail() {
		return PreviewEmail;
	}

	@FindBy(id = "activities")
	private WebElement Activities;

	public WebElement Activities() {
		return Activities;
	}

	@FindBy(id = "supplierPaymentRequired_No")
	private WebElement PaymentRequired;

	public WebElement PaymentRequired() {
		return PaymentRequired;
	}

	@FindBy(id = "supplierPaymentRequired_Yes")
	private WebElement PaymentReq;

	public WebElement PaymentReq() {
		return PaymentReq;
	}

	@FindBy(name = "campaignCurrency")
	private WebElement CampaignCurrency;

	public WebElement CampaignCurrency() {
		return CampaignCurrency;
	}

	@FindBy(name = "chargePerSupplier")
	private WebElement AmountText;

	public WebElement AmountText() {
		return AmountText;
	}

	@FindBy(id = "chargeRenewal")
	private WebElement ChargeRenewal;

	public WebElement ChargeRenewal() {
		return ChargeRenewal;
	}

	@FindBy(css = "[id='activities-tree'] span[class='dynatree-checkbox']")
	private List<WebElement> ListActivitiesChkBox;

	public List<WebElement> ListActivitiesChkBox() {
		return ListActivitiesChkBox;
	}

	@FindBy(css = "	[id='activities-tree'] a[class='dynatree-title']")
	private List<WebElement> ListActivitiesLabel;

	public List<WebElement> ListActivitiesLabel() {
		return ListActivitiesLabel;
	}

	@FindBy(id = "saveexit_button")
	private WebElement SaveExitBtn;

	public WebElement SaveExitBtn() {
		return SaveExitBtn;
	}

	@FindBy(id = "save_button")
	private WebElement SubmitApprovalBtn;

	public WebElement SubmitApprovalBtn() {
		return SubmitApprovalBtn;
	}

	@FindBy(css = "a[clas*='button_flat'][href*='campaignSearchSetup']")
	private WebElement CancelBtn;

	public WebElement Cancel() {
		return CancelBtn;
	}

	@FindBy(css = "input[id='campaignName']+span[class='error']")
	private WebElement CampaignNameErrorMsg;

	public WebElement CampaignNameErrorMsg() {
		return CampaignNameErrorMsg;
	}

	@FindBy(css = "[for='supplierPaymentRequired']")
	private WebElement PaidCampaignSection;

	public WebElement PaidCampaignSection() {
		return PaidCampaignSection;
	}

	public void createCampaign(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("AddCampaign")) {
			clickAddCampaign();
		}
		fillCampaignDetails(dataMap);
		formAction(dataMap);
	}

	public void clickAddCampaign() {
		lavanteUtils.clicks(CreateCampaignBtn);
	}

	public void fillCampaignDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(SubmitApprovalBtn);
		if (dataMap.containsKey("CampaignName")) {
			CampaignNameTxtBox.clear();
			String name = "";
			name = lavanteUtils.typeString(dataMap.get("CampaignName"), CampaignNameTxtBox);
			if (dataMap.get("CampaignName").equalsIgnoreCase("Any")) {
				dataMap.put("CampaignName", name);
			}
		}
		if (dataMap.containsKey("CampaignDescription")) {
			CampaignDescriptionTxtBox.clear();
			lavanteUtils.typeString(dataMap.get("CampaignDescription"), CampaignDescriptionTxtBox);
		}
		if (dataMap.containsKey("CampaignType")) {
			lavanteUtils.clicks(CampaignTypeDrpDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("CampaignType"));
		}
		if (dataMap.containsKey("PlannedStartDate")) {
			lavanteUtils.clicks(PlannedStartDate);
			lavanteUtils.typeinEdit(dataMap.get("PlannedStartDate"), PlannedStartDate);
		}
		if (dataMap.containsKey("PlannedEndDate")) {
			lavanteUtils.clicks(PlannedEndDate);
			lavanteUtils.typeinEdit(dataMap.get("PlannedEndDate"), PlannedEndDate);
		}
		if (dataMap.containsKey("CampaignOwner")) {
			lavanteUtils.clicks(CampaignOwnerDrpdwn);
			lavanteUtils.selectValueFrmdropdown(dataMap.get("CampaignOwner"));
		}

		if (dataMap.containsKey("RequestingDivision")) {
			lavanteUtils.clicks(RequestingDivisionDropDwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("RequestingDivision"));
		}
		if (dataMap.containsKey("SelectQuery")) {
			lavanteUtils.click(PlannedStartDate);
			lavanteUtils.clicks(SelectQueryDrpDwn);
			String selectquerytxt = lavanteUtils.selectValueFrmdropdown(dataMap.get("SelectQuery"));
			dataMap.put("SelectedQuery", selectquerytxt);
			String supCurrentlyInScope = lavanteUtils.getText(GetSupplierInScope);
			dataMap.put("SuppliersInScope", supCurrentlyInScope);
		}
		if (dataMap.containsKey("EmailTemplate")) {
			lavanteUtils.clicks(EmailTempleteDropDwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("EmailTemplate"));
		}

		if (dataMap.containsKey("SelectActivities")) {
			if (dataMap.get("SelectActivities").contains("#")) {

			} else {
				List<WebElement> listLabel = ListActivitiesLabel;
				for (int i = 0; i < listLabel.size(); i++) {
					String label = listLabel.get(i).getText();
					if (label.equals(dataMap.get("SelectActivities"))) {
						lavanteUtils.selectChkBox(ListActivitiesChkBox.get(i), "yes");
						break;
					}
				}
			}
		}
		if (dataMap.containsKey("SupplierChargedNo")) {
			if (lavanteUtils.isElementDisplayed(SupplierChargedNoRadioBtn)) {
				lavanteUtils.click(SupplierChargedNoRadioBtn);
			}
		}
	}

	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(SubmitApprovalBtn);
		if (dataMap.containsKey("SaveExit")) {
			lavanteUtils.click(SaveExitBtn);
		}
		if (dataMap.containsKey("SubmitApproval")) {
			lavanteUtils.click(SubmitApprovalBtn);
		}
	}

}
