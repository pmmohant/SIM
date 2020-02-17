package com.lavante.sim.customer.pageobjects.Campaign;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Ramya
 *
 */
public class CampaignBasicSearchPage {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public CampaignBasicSearchPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(id = "campaignID")
	private WebElement campaignID;

	public WebElement campaignID() {
		return campaignID;
	}

	@FindBy(id = "campaignName")
	private WebElement campaignName;

	public WebElement campaignName() {
		return campaignName;
	}

	@FindBy(css = "[id*='campaignType'] a")
	private WebElement campaignType;

	public WebElement campaignType() {
		return campaignType;
	}

	@FindBy(css = "div[id*='campaignStatus'] a")
	private WebElement CampaignStatusDropDwn;

	public WebElement CampaignStatusDropDwn() {
		return CampaignStatusDropDwn;
	}

	@FindBy(css = "#reqDivision_chosen a[class*='chosen-single']")
	private WebElement requestingDivision;

	public WebElement requestingDivision() {
		return requestingDivision;
	}

	@FindBy(css = "#campaignOwner_chosen a[class*='chosen-single'] span")
	private WebElement campaignOwner;

	public WebElement campaignOwner() {
		return campaignOwner;
	}

	@FindBy(id = "supplierPaymentRequierd")
	private WebElement supplierPaymentRequired;

	public WebElement supplierPaymentRequired() {
		return supplierPaymentRequired;
	}

	// No Href Avaialbale
	@FindBy(id = "search_results")
	private WebElement IframeSearchResult;

	public WebElement IframeSearchResult() {
		return IframeSearchResult;
	}

	@FindBy(css = "table[class*='data_table'] tbody tr:nth-child(1) td:nth-child(2)")
	private WebElement campaignIDValue;

	public WebElement campaignIDValue() {
		return campaignIDValue;
	}

	@FindBy(css = "button[class='button_flat']")
	private WebElement ClearBtn;

	public WebElement ClearBtn() {
		return ClearBtn;
	}

	@FindBy(id = "campaignMgmtSearch")
	private WebElement SearchBtn;

	public WebElement SearchBtn() {
		return SearchBtn;
	}

	@FindBy(css = "#campaignSearchResult tr.data_not_found>td")
	private WebElement NoData;

	public WebElement NoData() {
		return NoData;
	}

	@FindBy(css = "#campaignSearchResult thead tr th")
	private List<WebElement> Headers;

	public List<WebElement> Headers() {
		return Headers;
	}

	@FindBy(css = "table[id='campaignSearchResult'] td[class='status']")
	private List<WebElement> ListCampaignsStatus;

	public List<WebElement> ListCampaignsStatus() {
		return ListCampaignsStatus;
	}

	@FindBy(css = "#campaignSearchResult tbody td:nth-child(1) label")
	private List<WebElement> ListRadioBtn;

	public List<WebElement> ListRadioBtn() {
		return ListRadioBtn;
	}

	// Actions options
	@FindBy(css = "button[class*='action_buttons']")
	private WebElement ActionsDropDwn;

	public WebElement ActionsDropDwn() {
		return ActionsDropDwn;
	}

	@FindBy(css = "[id='campaignSearchResult'] a[id='dLabel']")
	private List<WebElement> ListActionsDropDwn;

	public List<WebElement> ListActionsDropDwn() {
		return ListActionsDropDwn;
	}

	@FindBy(id = "editCampaign")
	private WebElement EditCampaignLink;

	public WebElement EditCampaignLink() {
		return EditCampaignLink;
	}

	@FindBy(id = "deleteCampaign")
	private WebElement DeleteCampaignLink;

	public WebElement DeleteCampaignLink() {
		return DeleteCampaignLink;
	}

	@FindBy(css = "[href*='submitCampaignDetails']")
	private WebElement SubmitCampaignLink;

	public WebElement SubmitCampaignLink() {
		return SubmitCampaignLink;
	}

	@FindBy(id = "cloneCampaign")
	private WebElement CloneCampaignLink;

	public WebElement CloneCampaignLink() {
		return CloneCampaignLink;
	}

	@FindBy(id = "completeCampaign")
	private WebElement CompleteCampaignLink;

	public WebElement CompleteCampaignLink() {
		return CompleteCampaignLink;
	}

	@FindBy(id = "[href*='sendCampaignInvite']")
	private WebElement SendInviteLink;

	public WebElement SendInviteLink() {
		return SendInviteLink;
	}

	@FindBy(css = "button[class*='button_primary']")
	private WebElement DeleteBtn;

	public WebElement DeleteBtn() {
		return DeleteBtn;
	}

	@FindBy(css = "div[class*='undefined ui-dialog-content']")
	private WebElement GetPopupMsg;

	public WebElement GetPopupMsg() {
		return GetPopupMsg;
	}

	@FindBy(css = "button[class='button_primary']")
	private WebElement YesBtn;

	public WebElement YesBtn() {
		return YesBtn;
	}

	@FindBy(css = "iframe[src*='viewCompleteCampaign']")
	private WebElement IframePopUp;

	@FindBy(id = "saveexit_button")
	private WebElement CompleteCampSaveBtn;

	public WebElement CompleteCampSaveBtn() {
		return CompleteCampSaveBtn;
	}

	public void search(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(ClearBtn);
		fillDetails(dataMap);
		formAction(dataMap);
	}

	public void fillDetails(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("CampaignId")) {
			campaignID.clear();
			lavanteUtils.typeinEdit(dataMap.get("CampaignId"), campaignID);
		}
		if (dataMap.containsKey("CampaignName")) {
			campaignName.clear();
			lavanteUtils.typeinEdit(dataMap.get("CampaignName"), campaignName);
		}
		if (dataMap.containsKey("CampaignStatus")) {
			lavanteUtils.clicks(CampaignStatusDropDwn);
			lavanteUtils.selectFrmDpdn(dataMap.get("CampaignStatus"));
		}

	}

	public void formAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("Search")) {
			lavanteUtils.clicks(SearchBtn);
		}
		if (dataMap.containsKey("Clear")) {
			lavanteUtils.clicks(ClearBtn);
		}
	}

	public String getColumnText(String colname, int count) {
		String x = "";
		lavanteUtils.switchtoFrame(IframeSearchResult);
		int size = iterateSearchHeaderFindColList(colname).size();
		List<WebElement> sx = iterateSearchHeaderFindColList(colname);
		outr: for (int i = 0; i < size; i++) {
			x = sx.get(i).getText();
			if (count == 0) {
				if (x.length() > 0) {
					break outr;
				}
			} else {
				x = sx.get(count).getText();
				break outr;
			}
		}
		return x;
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		lavanteUtils.switchtoFrame(IframeSearchResult);

		List<WebElement> s = null;
		int j = ColIdentify(col);
		int y = j + 1;

		String x = "#campaignSearchResult tbody td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate Search Col:" + col + ":" + s.size());
		if (col.contains("Campaign ID")) {
			x = "#campaignSearchResult tbody td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		return s;
	}

	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().trim().toLowerCase();
				if (x.contains(col.toLowerCase())) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
					System.out.println(col + ",Col Found at " + ki);
					found = true;
					break;
				}
			}
		}

		if (found == false) {
			Assert.assertTrue(false, "Col name not found" + col);
		}
		return ki;

	}

	/**
	 * @author Subhas.BV
	 * 
	 *         Select options from the actions drop down
	 */
	public void selectCampaignAction(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IframeSearchResult);
		if (dataMap.containsKey("SelectRecord")) {
			if (dataMap.get("SelectRecord").equalsIgnoreCase("any")) {

				lavanteUtils.clicks(ListRadioBtn().get(0));
			}
		}
		lavanteUtils.clicks(ActionsDropDwn);

		if (dataMap.containsKey("EditCampaign")) {
			lavanteUtils.clicks(EditCampaignLink);
		}
		if (dataMap.containsKey("DeleteCampaign")) {
			lavanteUtils.clicks(DeleteCampaignLink);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.clicks(DeleteBtn);
		}
		if (dataMap.containsKey("SubmitCampaign")) {
			lavanteUtils.clicks(SubmitCampaignLink);
		}
		if (dataMap.containsKey("CloneCampaign")) {
			lavanteUtils.clicks(CloneCampaignLink);
		}
		if (dataMap.containsKey("CompleteCampaign")) {
			lavanteUtils.clicks(CompleteCampaignLink);
			lavanteUtils.switchtoFrame(IframePopUp);
			lavanteUtils.click(CompleteCampSaveBtn);
		}
		if (dataMap.containsKey("SendInvite")) {
			lavanteUtils.clicks(SendInviteLink);
		}
	}

}
