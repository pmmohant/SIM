package com.lavante.sim.supplier.pageobjects;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

public class SupplierHomePage {
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;

	public SupplierHomePage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	
	
	@FindBy(css = "div[class*='content']  table[class*='data_table'] td:nth-child(1) a")
	private List<WebElement> TasksList;

	public List<WebElement> TasksDescList() {
		return TasksList;
	}
	
	@FindBy(css = "a[href*='supplierDashboard']")
	private WebElement HomeTab;

	public WebElement HomeTab() {
		return HomeTab;
	}

	@FindBy(css = "[class^='customer']")
	private WebElement CustDropDwn;

	public WebElement CustDropDwn() {
		return CustDropDwn;
	}
	

	@FindBy(css = "#header_middle")
	private WebElement GetLoginHeaderTxt;

	public WebElement GetLoginHeaderTxt() {
		return GetLoginHeaderTxt;
	}

	@FindBy(css = "[href*='supplierInvoiceSearchResult']")
	private WebElement InvoicesTab;

	public WebElement InvoicesTab() {
		return InvoicesTab;
	}

	@FindBy(id = "customer")
	private WebElement CustNameDropDwn;

	public WebElement CustNameDropDwn() {
		return CustNameDropDwn;
	}

	@FindBy(id = "statusofinvitation")
	private WebElement StatusInvitationDropDwn;

	public WebElement StatusInvitationDropDwn() {
		return StatusInvitationDropDwn;
	}

	@FindBy(css = "a[href*='supplierProfilePublishConfigure']")
	private WebElement PublicProfileSettingsLink;

	public WebElement PublicProfileSettingsLink() {
		return PublicProfileSettingsLink;
	}

	@FindBy(xpath = "//span[starts-with(text(),'Lavante Supplier Information Management')]/parent::div/following-sibling::div[1]")
	private WebElement GetPopUpMsgTxt;

	public WebElement GetPopUpMsgTxt() {
		return GetPopUpMsgTxt;
	}

	@FindBy(css = "#share_profile")
	private WebElement SharePublicInfoChkBox;

	public WebElement SharePublicInfoChkBox() {
		return SharePublicInfoChkBox;
	}

	@FindBy(css = "table[class*='outer_table'] th")
	private List<WebElement> GetTableHeaders;

	public List<WebElement> GetTableHeaders() {
		return GetTableHeaders;
	}

	@FindBy(xpath = "//a[starts-with(@href,'viewSupplierProfile') and contains(text(),'I-151733')]")
	private WebElement InvitationId;

	public WebElement InvitationId() {
		return InvitationId;
	}

	@FindBy(css = "a[href*='supplierProfilePublishConfigure']")
	private WebElement PublishProfileLink;

	public WebElement PublishProfileLink() {
		return PublishProfileLink;
	}

	@FindBy(css = "table[class*='outer_table data_table table_grid zebra'] tr td:nth-child(1)")
	private List<WebElement> ListCustomer;

	public List<WebElement> ListCustomer() {
		return ListCustomer;
	}

	@FindBy(css = "a[href*='invite'][href*='CompanyDetails']")
	private List<WebElement> ListInvite;

	public List<WebElement> ListInvite() {
		return ListInvite;
	}

	@FindBy(css = "button[href*='Company']")
	private List<WebElement> EditList;

	public List<WebElement> EditList() {
		return EditList;
	}

	@FindBy(css = "a[class*='buttons_group_button'][href*='viewSupplierProfile']")
	private List<WebElement> AddNotesList;

	public List<WebElement> AddNotesList() {
		return AddNotesList;
	}

	@FindBy(css = "button[class*='green']")
	private WebElement OkBtn;

	public WebElement OkBtn() {
		return OkBtn;
	}

	@FindBy(css = "button[class*='green']")
	private List<WebElement> ListOkBtn;

	public List<WebElement> ListOkBtn() {
		return ListOkBtn;
	}

	@FindBy(css = "button[class*='primary']")
	private WebElement YesBtn;

	public WebElement YesBtn() {
		return YesBtn;
	}

	@FindBy(css = ".data_table.table_grid.zebra.table th")
	private List<WebElement> Headers;

	

	/**
	 * Edit a customer by customer name
	 * 
	 * @param dataMap
	 * 
	 */
	public void editCustomer(LinkedHashMap<String, String> dataMap) {

		for (int i = 0; i < ListInvite.size(); i++) {
			if (ListInvite.get(i).getText().equals(dataMap.get("CustomerName"))) {
				EditList.get(i).click();
				break;
			}
		}
	}

	/**
	 * Add notes for a customer
	 * 
	 * @param dataMap
	 * 
	 */
	public void editToAddNotes(LinkedHashMap<String, String> dataMap) {

		for (int i = 0; i < ListInvite.size(); i++) {
			if (ListInvite.get(i).getText().equals(dataMap.get("CustomerName"))) {
				AddNotesList.get(i).click();
				break;
			}
		}
	}

	/**
	 * 
	 * 
	 * @param dataMap
	 * 
	 */
	public void fillInfo(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.fluentwait(CustNameDropDwn());
		if (dataMap.containsKey("SelectCustomer")) {
			selCustomerName(dataMap);
		}
		if (dataMap.containsKey("SharePublicInfo")) {
			lavanteUtils.selectChkBox(SharePublicInfoChkBox(), dataMap.get("SharePublicInfo"));
		}
		if (dataMap.containsKey("PublishProfile")) {
			lavanteUtils.click(PublishProfileLink());
		}
	}
	
	/**
	 * Select a customer name from drop down
	 * 
	 * @param dataMap
	 */
	public void selCustomerName(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(CustNameDropDwn());
		lavanteUtils.selectFrmDpdn(dataMap.get("SelectCustomer"));
	}

	/**
	 * Select a customer name from drop down
	 * 
	 * @param dataMap
	 */
	public void selCustomerfromDropdown(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(CustDropDwn());
		lavanteUtils.selectFrmDpdn(dataMap.get("SelectCustomer"));
	}

	/**
	 * Select status of invitation
	 * 
	 * @param dataMap
	 * 
	 */
	public void selStatusOfInvitation(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(CustNameDropDwn());
		lavanteUtils.selectFrmDpdn(dataMap.get("InviatationStatus"));
	}

	/**
	 * @author Subhas.BV
	 * 
	 *         Select actions
	 */
	public void selectProfileActions(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("InviteID")) {
			if (dataMap.containsKey("EditProfile")) {
				for (int i = 0; i < ListInvite.size(); i++) {
					if (ListInvite.get(i).getText().equals(dataMap.get("InviteID"))) {
						EditList.get(i).click();
						break;
					}
				}
			}
			if (dataMap.containsKey("AddNotes")) {
				for (int i = 0; i < ListInvite.size(); i++) {
					if (ListInvite.get(i).getText().equals(dataMap.get("InviteID"))) {
						AddNotesList.get(i).click();
						break;
					}
				}
			}
		}
	}

	/**
	 * Editing an paid campaing customer, and proceed to Activities Payments
	 * page
	 * 
	 * @author Subhas.BV
	 * @param dataMap
	 */
	public void editPaidCampaignCustomer(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("InviteID")) {
			for (int i = 0; i < ListInvite.size(); i++) {
				if (ListInvite.get(i).getText().equals(dataMap.get("InviteID"))) {
					EditList.get(i).click();
					acceptNaviagteToPaymentPage();
					break;
				}
			}
		}
	}

	/**
	 * Verify Payment confirm message and proceed with payment
	 * 
	 * @author Subhas.BV
	 */
	public void acceptNaviagteToPaymentPage() {
		String expectedMsg = "";
		String actualMsg = "";
		Reporter.log("The confirm message validation for Paid Campaign, Expected : " + expectedMsg + " , Actual :"
				+ actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg, "The confirm message is not valid for Paid Campaign, Expected : "
				+ expectedMsg + " , Actual :" + actualMsg);
		lavanteUtils.clicks(YesBtn);
	}

	public String getColumnText(String colname, int count) {
		String x = "";
		int size = iterateSearchHeaderFindColList(colname).size();
		List<WebElement> sx = iterateSearchHeaderFindColList(colname);
		outr: for (int i = 0; i < size; i++) {
			System.out.println(sx.get(i) + "," + i + "COL TExt size:" + sx.size());
			x = sx.get(i).getText();
			System.out.println("Col Text:" + x);
			if (count == 0) {
				if (x.length() > 0) {
					break outr;
				}
			} else {
				x = sx.get(count).getText();
				System.out.println("Exact I Value in col :" + x);
				break outr;
			}
		}
		return x;
	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		String x = ".data_table.table_grid.zebra.table tr td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		System.out.println("Iterate col locator:" + x + ",Size:" + s.size());
		if ( col.contains("Invition ID") || col.equals("ID") || col.contains("Task Description")) {
			x = ".data_table.table_grid.zebra.table tr td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		} 
		System.out.println("Iterate Search Col:" + col + ":" + s.size());
		return s;
	}

	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText();
				if (x.contains(col)) {
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

	/***
	 * Method Used for OutStanding Table
	 * 
	 * @author Vidya.C
	 * @param dataMap
	 */
	public void OutStandingTaskSelection(LinkedHashMap<String, String> dataMap) {
		
		lavanteUtils.fluentwait(HomeTab);
		if(dataMap.containsKey("Id")){
			List<WebElement> Id = iterateSearchHeaderFindColList("ID");
			int row = 0;
			for(int i=0; i<Id.size(); i++) {
				if(Id.get(i).getText().equals(dataMap.get("Id"))) {
					row = i;
					dataMap.put("flag", "true");
					break;
				}
			}
			
			if(dataMap.containsKey("flag")){
				if(dataMap.containsKey("TaskDescription")){
					List<WebElement> taskDesp = iterateSearchHeaderFindColList("Task Description");
					lavanteUtils.click(taskDesp.get(row));
				}
				if(dataMap.containsKey("Task")){
					List<WebElement> ID = iterateSearchHeaderFindColList("ID");
					lavanteUtils.click(ID.get(row));
				}
			}
		}
	}
}
