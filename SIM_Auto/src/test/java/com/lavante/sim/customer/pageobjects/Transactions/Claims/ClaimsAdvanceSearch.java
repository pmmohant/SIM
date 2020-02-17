package com.lavante.sim.customer.pageobjects.Transactions.Claims;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ClaimsAdvanceSearch {
	LavanteUtils lavanteUtils = new LavanteUtils();

	WebDriver driver;

	public ClaimsAdvanceSearch(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(id = "adv_search_tab")
	private WebElement AdvanceSearchTab;

	public WebElement AdvanceSearchTab() {
		return AdvanceSearchTab;
	}

	@FindBy(css = "button[href*='loadClaimAdvanceSearch']")
	private WebElement BuildQueryBtn;

	public WebElement BuildQueryBtn() {
		return BuildQueryBtn;
	}

	@FindBy(id = "save_queryAdv")
	private WebElement SaveQueryBtn;

	public WebElement SaveQueryBtn() {
		return SaveQueryBtn;
	}

	@FindBy(css = "div[class*='ui-dialog-buttonset']>button.button_primary")
	private WebElement deleteBtn;

	public WebElement deleteBtn() {
		return deleteBtn;
	}

	@FindBy(css = "iframe[src*='loadClaimAdvanceSearch']")
	private WebElement IframeClaimsAdvSearch;

	public WebElement IframeClaimsAdvSearch() {
		return IframeClaimsAdvSearch;
	}

	@FindBy(css = "button[title='Clear']")
	private WebElement ClearQuerybtn;

	public WebElement ClearQuerybtn() {
		return ClearQuerybtn;
	}

	@FindBy(id = "ClaimID")
	private WebElement ClaimIdDrpdwn;

	public WebElement ClaimIdDrpdwn() {
		return ClaimIdDrpdwn;
	}

	@FindBy(css = "input[name='ClaimID_field']")
	private WebElement ClaimIdTxt;

	public WebElement ClaimIdTxt() {
		return ClaimIdTxt;
	}

	@FindBy(css = "div#ClaimType_chosen>ul input")
	private WebElement ClaimTypeDrpdn;

	public WebElement ClaimTypeDrpdn() {
		return ClaimTypeDrpdn;
	}

	// Claim Status search
	@FindBy(css = "#ClaimStatus_chosen li a")
	private List<WebElement> ClaimStatusDrpdnlist;
	
	@FindBy(css = "div#ClaimStatus_chosen input")
	private WebElement ClaimStatusDrpdn;

	public WebElement ClaimStatusDrpdn() {
		return ClaimStatusDrpdn;
	}

	@FindBy(css = "div#ClaimResolution_chosen input")
	private WebElement ClaimResolutionDrpdn;

	public WebElement ClaimResolutionDrpdn() {
		return ClaimResolutionDrpdn;
	}

	@FindBy(css = "div#AssignTo_chosen input")
	private WebElement AssignToDrpdn;

	public WebElement AssignToDrpdn() {
		return AssignToDrpdn;
	}

	@FindBy(id = "PaymentReferenceNumber")
	private WebElement PaymentRefDrpdwn;

	public WebElement PaymentRefDrpdwn() {
		return PaymentRefDrpdwn;
	}

	@FindBy(css = "td>input[name='PaymentReferenceNumber_field']")
	private WebElement PaymentRefTxt;

	public WebElement PaymentRefTxt() {
		return PaymentRefTxt;
	}

	@FindBy(id = "InvoiceNumber")
	private WebElement InvoiceDrpdwn;

	public WebElement InvoiceDrpdwn() {
		return InvoiceDrpdwn;
	}

	@FindBy(css = "td>input[name='InvoiceNumber_field']")
	private WebElement InvoiceNumTxt;

	public WebElement InvoiceNumTxt() {
		return InvoiceNumTxt;
	}

	@FindBy(id = "SupplierName")
	private WebElement SuppNameDrpdwn;

	public WebElement SuppNameDrpdwn() {
		return SuppNameDrpdwn;
	}

	@FindBy(css = "td>input[name='SupplierName_field']")
	private WebElement SuppNameTxt;

	public WebElement SuppNameTxt() {
		return SuppNameTxt;
	}

	@FindBy(id = "save")
	private WebElement SaveQueryAdvSearch;

	public WebElement SaveQueryAdvSearch() {
		return SaveQueryAdvSearch;
	}

	@FindBy(css = "input[name='search']")
	private WebElement SearchBtn;

	public WebElement SearchBtn() {
		return SearchBtn;
	}

	@FindBy(css = "button[title='Cancel']")
	private WebElement CancelBtn;

	public WebElement CancelBtn() {
		return CancelBtn;
	}

	@FindBy(css = "div[class*='ui-dialog-content']")
	private WebElement AlertText;

	public WebElement AlertText() {
		return AlertText;
	}

	@FindBy(css = "div[class*='dialog'] button[class*='primary']")
	private WebElement AlertOk;

	public WebElement AlertOk() {
		return AlertOk;
	}

	@FindBy(css = "iframe[src*='loadAdvanceSavedSearch']")
	private WebElement IframeSavedSearch;

	public WebElement IframeSavedSearch() {
		return IframeSavedSearch;
	}

	@FindBy(id = "specify_query")
	private WebElement specifyQuery;

	public WebElement specifyQuery() {
		return specifyQuery;
	}

	@FindBy(css = "input[name='Save']")
	private WebElement saveSpecifyQuery;

	public WebElement saveSpecifyQuery() {
		return saveSpecifyQuery;
	}

	@FindBy(css = "span[data-messagebag-id*='adv_search']")
	private WebElement SpecifyQueryErrorTxt;

	public WebElement SpecifyQueryErrorTxt() {
		return SpecifyQueryErrorTxt;
	}

	@FindBy(css = "table#private_queries tr>td:nth-child(1)>span")
	private List<WebElement> queryNamecol;

	public List<WebElement> queryNamecol() {
		return queryNamecol;
	}

	@FindBy(css = "[id=public_queries] span.query_name")
	private List<WebElement> ListSavedPublicQuery;

	public List<WebElement> ListSavedPublicQuery() {
		return ListSavedPublicQuery;
	}

	@FindBy(css = "[id=private_queries] span.query_name")
	private List<WebElement> ListSavedPrivateQuery;

	public List<WebElement> ListSavedPrivateQuery() {
		return ListSavedPrivateQuery;
	}
	
	@FindBy(css="label[class='box-image']")
	private WebElement sharewithUsersChkbox;
	public WebElement sharewithUsersChkbox(){
		return sharewithUsersChkbox;
	}
	
	@FindBy(css="input[title='Clear']")
	private WebElement clear;
	public WebElement clear(){
		return clear;
	}
	
	@FindBy(css="div[class*='bannerError']")
	private WebElement alertDuplicateText;
	public WebElement alertDuplicateText(){
		return alertDuplicateText;
	}

	
	// End of Locators
	
	
	public void AdvanceSearch(LinkedHashMap<String, String> dataMap) throws IOException {

		if (dataMap.containsKey("ClearQuery")) {
			lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
			lavanteUtils.click(ClearQuerybtn);
		}

		BuildQuery(dataMap);
		formActions(dataMap);
	}

	public void BuildQuery(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
		lavanteUtils.fluentwait(ClearQuerybtn);

		if (dataMap.containsKey("ClaimId")) {
			lavanteUtils.selectDropDownValue(ClaimIdDrpdwn(), dataMap.get("ClaimId"));
			lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);

			lavanteUtils.fluentwait(ClaimIdTxt);
			lavanteUtils.typeinEdit(dataMap.get("ClaimIdValue"), ClaimIdTxt);
		}
		if (dataMap.containsKey("ClaimType")) {
			String claimType = dataMap.get("ClaimType");
			if (claimType.contains("#")) {
				String[] str = claimType.split("#");
				for (int i = 0; i < str.length; i++) {
					lavanteUtils.click(ClaimTypeDrpdn);
					lavanteUtils.selectFrmDpdn(str[i]);
					lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
				}
			} else {
				lavanteUtils.click(ClaimTypeDrpdn);
				lavanteUtils.selectFrmDpdn(dataMap.get("ClaimType"));
				lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
			}

		}
		if (dataMap.containsKey("ClaimStatus")) {
			String claimStatus = dataMap.get("ClaimStatus");
			while(ClaimStatusDrpdnlist.size()>0){
				lavanteUtils.click(ClaimStatusDrpdnlist.get(0));
			}
			if (claimStatus.contains("#")) {
				String[] str = claimStatus.split("#");
				for (int i = 0; i < str.length; i++) {
					lavanteUtils.click(ClaimStatusDrpdn);
					lavanteUtils.selectValueFrmdropdown(str[i]);
					lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
				}
			} else {
				lavanteUtils.click(ClaimStatusDrpdn);
				if (dataMap.get("ClaimStatus").equals("any")) {
					String cStatus = lavanteUtils.selectValueFrmdropdown(dataMap.get("ClaimStatus"));
					dataMap.put("ClaimStatus", cStatus);
				} else {
					lavanteUtils.selectValueFrmdropdown(dataMap.get("ClaimStatus"));
				}

				lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
			}
		}
		if (dataMap.containsKey("AssignTo")) {
			String assignTo = dataMap.get("AssignTo");
			if (assignTo.contains("#")) {
				String[] str = assignTo.split("#");
				for (int i = 0; i < str.length; i++) {
					lavanteUtils.click(AssignToDrpdn);
					lavanteUtils.selectValueFrmdropdown(str[i]);
					lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
				}
			} else {
				lavanteUtils.click(AssignToDrpdn);
				lavanteUtils.selectValueFrmdropdown(dataMap.get("AssignTo"));
				lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
			}

		}
	}

	public void formActions(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Search")) {
			lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
			lavanteUtils.click(SearchBtn);
		}
		if (dataMap.containsKey("SaveSearch")) {
			lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
			lavanteUtils.click(SaveQueryAdvSearch);
			
			lavanteUtils.switchtoFrame(IframeSavedSearch);
			if (dataMap.containsKey("SpecifyQuery")) {
				TypeQueryName(dataMap);
			} else {
				String qName = lavanteUtils.getValue(specifyQuery, "value");
				dataMap.put("SpecifyQuery", qName);
				lavanteUtils.click(saveSpecifyQuery);
				lavanteUtils.waitForTime(4000);
			}

		}
		if (dataMap.containsKey("SaveQuery")) {
			lavanteUtils.click(SaveQueryBtn);
			lavanteUtils.switchtoFrame(IframeSavedSearch);
			lavanteUtils.waitForTime(3000);

			if (dataMap.containsKey("SpecifyQuery")) {
				TypeQueryName(dataMap);
			} else {
				String qName = lavanteUtils.getValue(specifyQuery, "value");
				dataMap.put("SpecifyQuery", qName);
				lavanteUtils.click(saveSpecifyQuery);
				lavanteUtils.waitForTime(4000);
			}
		}
	}

	private void TypeQueryName(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("ErrMessage")) {
			lavanteUtils.click(saveSpecifyQuery);
			String errMsg = SpecifyQueryErrorTxt().getText();
			dataMap.put("ErrMessage", errMsg);
		}
		String query = dataMap.get("SpecifyQuery");
		lavanteUtils.typeinEdit(query, specifyQuery);
		if (dataMap.containsKey("SharewithUsers")) {
			lavanteUtils.click(sharewithUsersChkbox);
		}
		lavanteUtils.click(saveSpecifyQuery);
		lavanteUtils.waitForTime(4000);
	}

	public void savedQueryActions(LinkedHashMap<String, String> dataMap) {
	//	lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(BuildQueryBtn);
		// lavanteUtils.waitForTime(5000);

		if (dataMap.containsKey("SpecifyQuery")) {
			if (dataMap.containsKey("EditQuery")) {
				String edit = "//*[contains(text(),'" + dataMap.get("SpecifyQuery") + "')]/../../td[2]//a";
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(edit)));
			}
			if (dataMap.containsKey("DeleteQuery")) {
				String delete = "//*[contains(text(),'" + dataMap.get("SpecifyQuery") + "')]/../../td[3]//a";
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(delete)));
				lavanteUtils.click(deleteBtn);
			}
			if (dataMap.containsKey("RunQuery")) {
				String run = "//*[contains(text(),'" + dataMap.get("SpecifyQuery") + "')]/../../td[4]//a";
				lavanteUtils.click(lavanteUtils.driver.findElement(By.xpath(run)));
			}
		}
	}

	public void verifyClaimsAdvanceSearchTableDisplayed() {
		lavanteUtils.fluentwait(AdvanceSearchTab);
		lavanteUtils.click(AdvanceSearchTab);
		lavanteUtils.fluentwait(BuildQueryBtn);
		lavanteUtils.click(BuildQueryBtn);
		lavanteUtils.fluentwait(IframeClaimsAdvSearch);
		lavanteUtils.switchtoFrame(IframeClaimsAdvSearch);
	}


	/**
	 * Edit Query
	 * 
	 * @param LinkedHashMap<String,
	 *            String> dataMap queryType(PrivateQuery/PublicQuery)
	 *            queryName(queryName)
	 *
	 */

	public void editMyQuery(LinkedHashMap<String, String> dataMap) {
		List<WebElement> query = null;
		String editIconObject = "//table[@id='QueryType']/../../..//*[contains(text(),'name')]/..//following-sibling::td[2]/a";

		if (dataMap.containsKey("PublicQuery")) {
			query = ListSavedPublicQuery();
			editIconObject = editIconObject.replace("QueryType", "public_queries");
		}
		if (dataMap.containsKey("PrivateQuery")) {
			query = ListSavedPrivateQuery();
			editIconObject = editIconObject.replace("QueryType", "private_queries");
		}
		int size = query.size();
		for (int i = 0; i < size; i++) {
			String getSavedQueryName = query.get(i).getText();
			if (getSavedQueryName.equals(dataMap.get("QueryName"))) {
				editIconObject = editIconObject.replace("name", dataMap.get("QueryName"));
				WebElement queryEditBtn = driver.findElement(By.xpath(editIconObject));
				lavanteUtils.click(queryEditBtn);
				lavanteUtils.fluentwait(IframeClaimsAdvSearch);
			}
		}
	}
	
	/**
	 * Delete Query
	 * 
	 * @param LinkedHashMap<String,
	 *            String> dataMap queryType(PrivateQuery/PublicQuery)
	 *            queryName(queryName/subQueryName Example: SearchByStatus,
	 *            SearyBy )
	 *
	 */

	public void deleteMyQuery(LinkedHashMap<String, String> dataMap) {
		List<WebElement> query = null;
		String deleteIconObject = "//table[@id='QueryType']/../../..//*[contains(text(),'name')]/..//following-sibling::td[3]/a";

		if (dataMap.containsKey("PublicQuery")) {
			query = ListSavedPublicQuery();
			deleteIconObject = deleteIconObject.replace("QueryType", "public_queries");
		}
		if (dataMap.containsKey("PrivateQuery")) {
			query = ListSavedPrivateQuery();
			deleteIconObject = deleteIconObject.replace("QueryType", "private_queries");
		}
		int size = query.size();
		for (int i = 0; i < size; i++) {
			String getSavedQueryName = query.get(i).getText();
			if (getSavedQueryName.contains(dataMap.get("QueryName"))|| getSavedQueryName.equals(dataMap.get("QueryName"))) {
				deleteIconObject = deleteIconObject.replace("name", dataMap.get("QueryName"));
				lavanteUtils.waitForTime(5000);
				WebElement queryDeleteBtn = driver.findElement(By.xpath(deleteIconObject));
				lavanteUtils.clicks(queryDeleteBtn);
				lavanteUtils.fluentwait(deleteBtn);
				lavanteUtils.click(deleteBtn);
				lavanteUtils.waitForTime(5000);
				i = -1;
				size = query.size();
			}
		}
	}

	/**
	 * 
	 * Run Query
	 * 
	 * @param LinkedHashMap<String,
	 *            String> dataMap queryType(PrivateQuery/PublicQuery)
	 *            queryName(queryName)
	 *
	 */

	public void runMyQuery(LinkedHashMap<String, String> dataMap) {
		List<WebElement> query = null;
		String runIconObject = "//table[@id='QueryType']/../../..//*[contains(text(),'name')]/..//following-sibling::td[4]/a";

		if (dataMap.containsKey("PublicQuery")) {
			query = ListSavedPublicQuery();
			runIconObject = runIconObject.replace("QueryType", "public_queries");
		}
		if (dataMap.containsKey("PrivateQuery")) {
			query = ListSavedPrivateQuery();
			runIconObject = runIconObject.replace("QueryType", "private_queries");
		}
		int size = query.size();
		for (int i = 0; i < size; i++) {
			String getSavedQueryName = query.get(i).getText();
			if (getSavedQueryName.equals(dataMap.get("QueryName"))) {
				runIconObject = runIconObject.replace("name", dataMap.get("QueryName"));
				WebElement queryRunBtn = driver.findElement(By.xpath(runIconObject));
				lavanteUtils.click(queryRunBtn);
				break;
			}
		}
	}
}
