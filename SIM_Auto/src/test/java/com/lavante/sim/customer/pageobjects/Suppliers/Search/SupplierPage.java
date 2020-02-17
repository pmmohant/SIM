/**
 * 
 */
package com.lavante.sim.customer.pageobjects.Suppliers.Search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
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

/**
 * @author Piramanayagam.S
 *
 */
public class SupplierPage {

	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver;

	public SupplierPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	// Link on the page

	@FindBy(css = "a[href*='inviteNewSupplier'][accesskey*='i']")
	private WebElement inviteNwlink;

	public WebElement inviteNwlink() {
		return inviteNwlink;
	}

	// Header details of supplier page
	@FindBy(css = "th:nth-child(1) label[for*='bulk']")
	private WebElement selectAllSupp;

	// Header details of supplier ID

	@FindBy(id = "SupplierERPID")
	private WebElement headsupplierID;

	public WebElement headsupplierID() {
		return headsupplierID;
	}

	// Header details of supplier Name
	@FindBy(id = "supplierName")
	private WebElement headsupplierName;

	public WebElement headsupplierName() {
		return headsupplierName;
	}

	// Header details of supplier contact
	@FindBy(id = "ContactName")
	private WebElement headsuppliercontact;

	public WebElement headsuppliercontact() {
		return headsuppliercontact;
	}

	// Header details of Requestedby Renamed to Invited BY
	@FindBy(id = "InviteBy")
	private WebElement headInvitedBY;

	public WebElement headInvitedBy() {
		return headInvitedBY;
	}

	// Header details of profilestatus
	@FindBy(id = "ProfileStatus")
	private WebElement headprofilestatus;

	public WebElement headprofilestatus() {
		return headprofilestatus;
	}

	// Header details of profilecompletepercentage
	@FindBy(id = "ProfilePercentage")
	private WebElement headprofilecompletepercentage;

	public WebElement headprofilecompletepercentage() {
		return headprofilecompletepercentage;
	}

	// Header details of profilemanagedby
	@FindBy(id = "ProfileOwner")
	private WebElement headprofilemanagedby;

	public WebElement headprofilemanagedby() {
		return headprofilemanagedby;
	}

	// Header details of Notes&history
	@FindBy(css = "[title*='Notes']")
	private WebElement headNotesandhistory;

	public WebElement headNotesandhistory() {
		return headNotesandhistory;
	}

	@FindBy(css = "iframe#search_results")
	private WebElement SearchListIFRAME;

	public WebElement SearchListIFRAME() {
		return SearchListIFRAME;
	}

	@FindBy(id = "total_records")
	private WebElement total_records;

	public WebElement searchResults() {
		return total_records;
	}

	@FindBy(css = "iframe[src*='Doc']")
	private WebElement IFRAMEdownloadoc;

	public WebElement IFRAMEdownloadoc() {
		return IFRAMEdownloadoc;
	}

	@FindBy(css = "#save_request_doc_form optgroup")
	private List<WebElement> requestdocgrp;

	public List<WebElement> requestdocgrp() {
		return requestdocgrp;
	}

	@FindBy(css = "iframe[src*='reInvite']")
	private WebElement IFRAMEreinvite;

	public WebElement IFRAMEreinvite() {
		return IFRAMEreinvite;
	}

	@FindBy(css = "[ng-model*='unselected'] option")
	private List<WebElement> MoveDocToSelect;

	public List<WebElement> MoveDocToSelect() {
		return MoveDocToSelect;
	}

	@FindBy(css = "[ng-model^='selected'] option")
	private List<WebElement> MoveDocSelected;

	public List<WebElement> MoveDocSelected() {
		return MoveDocSelected;
	}

	@FindBy(css = "button[ng-click][title*='selected from left to right']")
	private WebElement moveSelectedtoLeft;

	public WebElement moveSelectedtoLeft() {
		return moveSelectedtoLeft;
	}

	@FindBy(css = "[id*='save'] [class*='primary']")
	private WebElement moveDocOKbtn;

	public WebElement moveDocOKbtn() {
		return moveDocOKbtn;
	}

	@FindBy(css = "[role*='dia'] button[class*='button_primary']")
	private WebElement OKbtn;

	public WebElement OKbtn() {
		return OKbtn;
	}

	@FindBy(css = "[role*='dia'] button[class*='button_flat']")
	private WebElement Cancelbtn;

	public WebElement Cancelbtn() {
		return Cancelbtn;
	}

	@FindBy(css = "div[class*='dialog'] div[class*='dialog-content']")
	private WebElement OKdialogmsg;

	public WebElement OKdialogmsg() {
		return OKdialogmsg;
	}

	@FindBy(css = "button[ng-click*='reset']")
	private WebElement resetBtn;

	public WebElement resetBtn() {
		return resetBtn;
	}

	@FindBy(css = "span[class*='error']")
	private WebElement errormsg;

	public WebElement errormsg() {
		return errormsg;
	}

	// Search Option Invite Division All
	@FindBy(id = "All")
	private List<WebElement> ANYoption;

	public List<WebElement> ANYoption() {
		return ANYoption;
	}

	// Filter By
	@FindBy(css = "input[id*='All']")
	private WebElement InputFilterByAllRadiobtn;

	public WebElement InputFilterByAllRadiobtn() {
		return InputFilterByAllRadiobtn;
	}

	@FindBy(css = "label[for*='All']")
	private WebElement FilterByAllRadiobtn;

	public WebElement FilterByAllRadiobtn() {
		return FilterByAllRadiobtn;
	}

	@FindBy(css = "input[id*='My Division']")
	private WebElement InputFilterByMyDivisionRadiobtn;

	public WebElement InputFilterByMyDivisionRadiobtn() {
		return InputFilterByMyDivisionRadiobtn;
	}

	@FindBy(css = "label[for*='My Division']")
	private WebElement FilterByMyDivisionRadiobtn;

	public WebElement FilterByMyDivisionRadiobtn() {
		return FilterByMyDivisionRadiobtn;
	}

	@FindBy(css = "input[id*='My Invites']")
	private WebElement InputFilterByMyInvitesRadiobtn;

	public WebElement InputFilterByMyInvitesRadiobtn() {
		return InputFilterByMyInvitesRadiobtn;
	}

	@FindBy(css = "label[for*='My Invites']")
	private WebElement FilterByMyInvitesRadiobtn;

	public WebElement FilterByMyInvitesRadiobtn() {
		return FilterByMyInvitesRadiobtn;
	}

	@FindBy(css = "[id*='ViewFilter'] a")
	private WebElement viewDrpdwn;

	public WebElement viewDrpdwn() {
		return viewDrpdwn;
	}

	@FindBy(css = "[id*='ViewFilter']")
	private WebElement selviewDrpdwn;

	public WebElement selviewDrpdwn() {
		return selviewDrpdwn;
	}

	/*
	 * @FindBy(css=" #search_results a[class*='collapse']") private
	 * List<WebElement> collapsebtn; public List<WebElement> collapsebtn() {
	 * return collapsebtn; }
	 */

	@FindBy(css = "#search_results td")
	private WebElement noDataFound;

	public WebElement noDataFound() {
		return noDataFound;
	}

	@FindBy(css = "#search_results td:nth-child(2)")
	private List<WebElement> suppid;

	public List<WebElement> suppid() {
		return suppid;
	}

	@FindBy(css = "#search_results  a")
	private WebElement suppwait;

	@FindBy(css = "#search_results td:nth-child(3) a")
	private List<WebElement> supplist;

	public List<WebElement> supplist() {
		return supplist;
	}

	@FindBy(css = "#search_results td:nth-child(4)")
	private List<WebElement> suppcontactlist;

	public List<WebElement> suppcontactlist() {
		return suppcontactlist;
	}

	@FindBy(css = "#search_results td:nth-child(5)")
	private List<WebElement> suppreqlist;

	public List<WebElement> suppreqlist() {
		return suppreqlist;
	}

	@FindBy(css = "#search_results td:nth-child(6)")
	private List<WebElement> ProfStatus;

	public List<WebElement> ProfStatus() {
		return ProfStatus;
	}

	@FindBy(css = "#search_results th")
	private List<WebElement> Headers;

	@FindBy(css = "#search_results td:nth-child(7)")
	private List<WebElement> ProfPercent;

	public List<WebElement> ProfPercent() {
		return ProfPercent;
	}

	@FindBy(css = "#search_results td:nth-child(8)")
	private List<WebElement> ProfManaged;

	public List<WebElement> ProfManaged() {
		return ProfManaged;
	}

	@FindBy(css = "tbody [type='checkbox']")
	private List<WebElement> supchkbx;

	public List<WebElement> supchkbx() {
		return supchkbx;
	}

	@FindBy(css = "button[class*='action']")
	private WebElement actionBtn;

	public WebElement actionBtn() {
		return actionBtn;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'wrapper')]/div[1]/button")
	private WebElement prflebtn;

	public WebElement prflebtn() {
		return prflebtn;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'wrapper')]/div[3]/button")
	private WebElement communicatebtn;

	public WebElement communicatebtn() {
		return communicatebtn;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'wrapper')]/div[4]/button")
	private WebElement notificationbtn;

	public WebElement notificationbtn() {
		return notificationbtn;
	}

	@FindBy(how = How.XPATH, using = "//button[starts-with(text(),'Other Actions')]")
	private WebElement otheractnbtn;

	public WebElement otheractnbtn() {
		return otheractnbtn;
	}

	@FindBy(css = "button[value*='Edit Profile']")
	private WebElement editprflebtn;

	public WebElement editprflebtn() {
		return editprflebtn;
	}

	@FindBy(css = "button[href*='Primary']")
	private WebElement ChangePrimary;

	public WebElement ChangePrimary() {
		return ChangePrimary;
	}

	@FindBy(css = "button[value*='Take Control']")
	private WebElement TakeControlbtn;

	public WebElement TakeControlbtn() {
		return TakeControlbtn;
	}

	@FindBy(css = "button[value*='Activate']")
	private WebElement activatebtn;

	public WebElement activatebtn() {
		return activatebtn;
	}

	@FindBy(css = "button[value*='Deactivate']")
	private WebElement Deactivatebtn;

	public WebElement Deactivatebtn() {
		return Deactivatebtn;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'wrapper')]/div[2]/button")
	private WebElement Accountbtn;

	public WebElement Accountbtn() {
		return Accountbtn;
	}

	// PRimary

	@FindBy(css = "iframe[src*='Prima']")
	private WebElement IFRAMEPrimary;

	public WebElement IFRAMEPrimary() {
		return IFRAMEPrimary;
	}

	@FindBy(css = "#dialog td:nth-child(1) span")
	private List<WebElement> ContactRdioSpan;

	@FindBy(css = "#dialog td:nth-child(1) input")
	private List<WebElement> ContactRdio;

	public List<WebElement> ContactRdio() {
		return ContactRdio;
	}

	@FindBy(css = "a[ng-click*='addContact']")
	private WebElement AddContact;

	public WebElement AddContact() {
		return AddContact;
	}

	@FindBy(css = "#dialog td:nth-child(2)")
	private List<WebElement> ContactName2;

	public List<WebElement> ContactName2() {
		return ContactName2;
	}

	@FindBy(css = "#dialog td:nth-child(2) input")
	private WebElement ContactName;

	public WebElement ContactName() {
		return ContactName;
	}

	@FindBy(css = "#dialog td:nth-child(3) input")
	private WebElement ContactPhone;

	public WebElement ContactPhone() {
		return ContactPhone;
	}

	@FindBy(css = "#dialog td:nth-child(4) input")
	private WebElement ContactEmail;

	public WebElement ContactEmail() {
		return ContactEmail;
	}

	@FindBy(css = "#dialog td:nth-child(5) input")
	private WebElement ContactFax;

	public WebElement ContactFax() {
		return ContactFax;
	}

	@FindBy(css = "button[class*='button_primary']")
	private WebElement SaveBtn2;

	public WebElement SaveBtn2() {
		return SaveBtn2;
	}

	// End

	// EMAIL

	@FindBy(css = "button[href*='sendMsg']")
	private WebElement sendEmailbtn;

	public WebElement sendEmailbtn() {
		return sendEmailbtn;
	}

	@FindBy(css = "iframe[src*='sendMsg']")
	private WebElement IFRAMEsendEmail;

	public WebElement IFRAMEsendEmail() {
		return IFRAMEsendEmail;
	}

	@FindBy(css = "iframe[src*='activate']")
	private WebElement IFRAMEactDeact;

	public WebElement IFRAMEactDeact() {
		return IFRAMEactDeact;
	}

	@FindBy(css = "[id*='from']")
	private WebElement mailFrombtn;

	public WebElement mailFrombtn() {
		return mailFrombtn;
	}

	@FindBy(css = "[id*='emailTemplate'] a")
	private WebElement mailTemplate;

	public WebElement mailTemplate() {
		return mailTemplate;
	}

	@FindBy(css = "label[for*='selectAllContacts']")
	private WebElement AllContactRadioBtn;

	public WebElement AllContactRadioBtn() {
		return AllContactRadioBtn;
	}

	@FindBy(css = "label[for*='chooseRecipients']")
	private WebElement SpecificContactsRadioBtn;

	public WebElement SpecificContactsRadioBtn() {
		return SpecificContactsRadioBtn;
	}

	@FindBy(css = "[value='Select Location Types']")
	private WebElement LocationTypeDropDwn;

	public WebElement LocationTypeDropDwn() {
		return LocationTypeDropDwn;
	}

	@FindBy(css = "[value='All Contacts']")
	private WebElement ContactDropDwn;

	public WebElement ContactDropDwn() {
		return ContactDropDwn;
	}

	@FindBy(id = "subject")
	private WebElement mailsubtxt;

	public WebElement mailsubtxt() {
		return mailsubtxt;
	}

	@FindBy(css = "div[class*='editor']")
	private WebElement mailmsgtxt;

	public WebElement mailmsgtxt() {
		return mailmsgtxt;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'emailAttachment')][last()]")
	private WebElement mailUploadbtn;

	public WebElement mailUploadbtn() {
		return mailUploadbtn;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'emailAttachment')][last()]")
	private List<WebElement> mailUploadlstbtn;

	public List<WebElement> mailUploadlstbtn() {
		return mailUploadlstbtn;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'MultiFile-title')]")
	private List<WebElement> mailAttchdfilname;

	public List<WebElement> mailAttchdfilname() {
		return mailAttchdfilname;
	}

	@FindBy(id = "send_message")
	private WebElement mailSendbtn;

	public WebElement mailSendbtn() {
		return mailSendbtn;
	}

	@FindBy(id = "save_as_template")
	private WebElement mailSavebtn;

	public WebElement mailSavebtn() {
		return mailSavebtn;
	}

	@FindBy(css = "[type*='reset']")
	private WebElement mailClearbtn;

	public WebElement mailClearbtn() {
		return mailClearbtn;
	}

	@FindBy(css = "input[name*='prompt']")
	private WebElement mailTemplateNametxt;

	public WebElement mailTemplateNametxt() {
		return mailTemplateNametxt;
	}

	// Outreach

	@FindBy(css = "button[href*='Outreach']")
	private WebElement StartOutreachBtn;

	public WebElement StartOutreachBtn() {
		return StartOutreachBtn;
	}

	@FindBy(css = "iframe[src*='Outreach']")
	private WebElement IFRAMEOutreach;

	public WebElement IFRAMEOutreach() {
		return IFRAMEOutreach;
	}

	@FindBy(css = "input[type*='submit']")
	private WebElement outReachbtn;

	public WebElement outReachbtn() {
		return outReachbtn;
	}

	// Other Actions-Download Doc

	@FindBy(css = "button[href*='AssociateAgent']")
	private WebElement associateAgent;

	public WebElement associateAgent() {
		return associateAgent;
	}

	// Associate Locators

	@FindBy(css = "[class*='big_dialog_message'] p")
	private WebElement dialogmsg;

	public WebElement dialogmsg() {
		return dialogmsg;
	}

	@FindBy(css = "[href*='requestDoc']")
	private WebElement downloaddoc;

	public WebElement downloaddoc() {
		return downloaddoc;
	}

	@FindBy(css = "button[href*='Complete']")
	private WebElement profcomplete;

	public WebElement profcomplete() {
		return profcomplete;
	}

	@FindBy(css = "button[href*='associateVendorRequest']")
	private WebElement associateVendor;

	public WebElement associateVendor() {
		return associateVendor;
	}

	@FindBy(css = "input[name*='isEditInviteEnabledPostInvite']")
	private WebElement hiddenisEditInviteEnabledPostInvite;

	public WebElement hiddenisEditInviteEnabledPostInvite() {
		return hiddenisEditInviteEnabledPostInvite;
	}

	@FindBy(css = "button[value*='Edit Invite']")
	private WebElement EditInvitebtn;

	public WebElement EditInvitebtn() {
		return EditInvitebtn;
	}

	@FindBy(css = "button[href*='extendInvite']")
	private WebElement ExtendInvitebtn;

	public WebElement ExtendInvitebtn() {
		return ExtendInvitebtn;
	}

	@FindBy(css = "button[href*='DeleteSupplier']")
	private WebElement DeleteInvitebtn;

	public WebElement DeleteInvitebtn() {
		return DeleteInvitebtn;
	}

	@FindBy(css = "div[class*='dialog']>button[class*='primary']")
	private WebElement OkButton;

	public WebElement OkButton() {
		return OkButton;
	}

	@FindBy(css = "button[value*='invite']")
	private WebElement Reinvitebtn;

	public WebElement Reinvitebtn() {
		return Reinvitebtn;
	}

	@FindBy(id = "comment")
	private WebElement DeactivateComments;

	public WebElement DeactivateComments() {
		return DeactivateComments;
	}

	@FindBy(css = "button[name*='enableNotifications']")
	private WebElement enablebtn;

	public WebElement enablebtn() {
		return enablebtn;
	}

	@FindBy(css = "button[href*='moveToProfileComplete.lvp']")
	private WebElement movToProCompBtn;

	public WebElement movToProCompBtn() {
		return movToProCompBtn;
	}

	@FindBy(xpath = "//a[contains(text(),'Act on behalf of.')]")
	private WebElement actBehalf;

	

	@FindBy(css = "div[class='dropdown supplierCustomerList']>ul")
	private WebElement actBehalf1;
	public WebElement actBehalf1() {
		return actBehalf1;
	}

	@FindBy(css = "div[class='dropdown supplierCustomerList']  ul li a[onclick*='click']")
	private List<WebElement> ListActBehalf;

	@FindBy(css = "div[class*='sup'] ul li a")
	private WebElement supRoledpdn;

	public WebElement supRoledpdn() {
		return supRoledpdn;
	}

	@FindBy(css = "button[name*='disableNotifications']")
	private WebElement disablebtn;

	public WebElement disablebtn() {
		return disablebtn;
	}

	@FindBy(css = "input[class*='primary'][type='submit']")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}

	@FindBy(css = "input[type='submit']")
	private WebElement SaveBtn1;

	public WebElement SaveBtn1() {
		return SaveBtn1;
	}

	@FindBy(css = "table#search_results tr>td:nth-child(1)>a")
	private List<WebElement> ListExpandSupplier;

	public List<WebElement> ListExpandSupplier() {
		return ListExpandSupplier;
	}

	@FindBy(css = "[id*='contactInformation'] td:nth-child(2)")
	private List<WebElement> ListContact;

	public List<WebElement> ListContact() {
		return ListContact;
	}

	@FindBy(how = How.XPATH, using = "//table[@id='search_results']//tr//td[6]")
	private List<WebElement> supplierStatus;

	public List<WebElement> supplierStatus() {
		return supplierStatus;
	}

	@FindBy(how = How.XPATH, using = "//table[@id='search_results']//tr//td[7]")
	private List<WebElement> supplierPercentage;

	public List<WebElement> supplierPercentage() {
		return supplierPercentage;
	}

	@FindBy(css = "a[href*='Note']")
	private List<WebElement> ListNotes;

	public List<WebElement> ListNotes() {
		return ListNotes;
	}

	// For Reinvte iframe
	@FindBy(css = "iframe[src*='reInviteSupplier']")
	private WebElement reinviteIFrame;

	public WebElement reinviteIFrame() {
		return reinviteIFrame;
	}

	@FindBy(css = "#button_invite")
	private WebElement popupInviteBtn;

	public WebElement popupInviteBtn() {
		return popupInviteBtn;
	}

	// For Reinvte Contact
	@FindBy(id = "contact")
	private WebElement ReinviteSupplierContact;

	public WebElement ReinviteSupplierContact() {
		return ReinviteSupplierContact;
	}

	@FindBy(id = "contactName")
	private WebElement ReinvitecontactName;

	public WebElement ReinvitecontactName() {
		return ReinvitecontactName;
	}

	@FindBy(id = "email")
	private WebElement ReinvitecontactEmail;

	public WebElement ReinvitecontactEmail() {
		return ReinvitecontactEmail;
	}

	@FindBy(css = "[for*='contacts']")
	private List<WebElement> contactlist;

	public List<WebElement> contactlist() {
		return contactlist;
	}

	@FindBy(css = "div[id*='supplierViewFilter'] a")
	private WebElement SearchViewDropDwn;

	public WebElement SearchViewDropDwn() {
		return SearchViewDropDwn;
	}

	@FindBy(id = "total_pages")
	private WebElement totalsearchcount;

	public WebElement totalsearchcount() {
		return totalsearchcount;
	}

	// Reusable Methods
	public String searchView(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		String byDefaultSelected = lavanteUtils.getText(SearchViewDropDwn);
		if (dataMap.containsKey("SearchOption")) {
			String act = dataMap.get("SearchOption");
			if (!act.equalsIgnoreCase(byDefaultSelected)) {
				byDefaultSelected = act;
				lavanteUtils.scrollup();
				String dum = act;
				if (act.equalsIgnoreCase("Invites")) {
					act = "" + 4903;
				}
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.scrollup();
				lavanteUtils.switchtoFrame(SearchListIFRAME);
				lavanteUtils.Scrollintoview(totalsearchcount);
				SearchViewDropDwn.click();
				lavanteUtils.SameFrameselectvalueFrmDpdn(dum);
				lavanteUtils.switchtoFrame(SearchListIFRAME);
			}
		}
		return byDefaultSelected;
	}

	public String supplierSelectionandProfileAction(LinkedHashMap<String, String> dataMap) throws Exception {
		lavanteUtils.waitForTime(2000);
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		String sup = selectSupplier(dataMap);
		if (sup.length() > 0) {
			ProfileAction(dataMap);
		}
		Reporter.log("Selected Supplier:" + sup);
		return sup;

	}

	public void ProfileAction(LinkedHashMap<String, String> dataMap) throws Exception {
		selectAction(dataMap);
		selectProfileSubAction(dataMap);
		lavanteUtils.switchtoFrame(null);
	}

	public String VerifyManagedBy() {
		String sup = "";
		String col = "Pending With";
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		outr: if (iterateSearchHeaderFindColList("Name").size() > 0) {
			for (int i = 0; i <= size; i++) {
				sup = getSupplierName("Name", i);// iterateSearchHeaderFindColList("Name").get(i).getText();
				System.out.println("Pending With:" + sup);
				if (sup.length() > 0) {
					String Managedby = getColumnAttribute(i, col, "title");
					System.out.println("Supplier:" + sup + "," + col + ":" + Managedby);
					if (Managedby.length() > 3) {
						sup = getSupplierName("Name", i);
						sup = sup.trim();
						break outr;
					}
				}
			}

		}
		if (!(sup.length() > 0)) {
			// Assert.assertTrue("Supplier Not found", false);
		}
		return sup;
	}

	public String VerifyPendingWith() {
		String sup = "";
		String col = "Profile Managed By";
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		outr: if (iterateSearchHeaderFindColList("Name").size() > 0) {
			for (int i = 0; i <= size; i++) {
				sup = getSupplierName("Name", i);// iterateSearchHeaderFindColList("Name").get(i).getText();
				System.out.println("ManageBY:" + sup);
				if (sup.length() > 0) {
					String Managedby = getColumnAttribute(i, col, "title");
					System.out.println("Supplier:" + sup + "," + col + ":" + Managedby);
					if (Managedby.length() > 3) {
						sup = getSupplierName("Name", i);
						sup = sup.trim();
						break outr;
					}
				}
			}

		}
		if (!(sup.length() > 0)) {
			// Assert.assertTrue("Supplier Not found", false);
		}
		return sup;
	}

	public String VerifyManagedBy(String col) {
		String sup = "";

		lavanteUtils.switchtoFrame(SearchListIFRAME);
		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		outr: if (iterateSearchHeaderFindColList("Name").size() > 0) {
			for (int i = 0; i <= size; i++) {
				sup = getSupplierName("Name", i);// iterateSearchHeaderFindColList("Name").get(i).getText();
				System.out.println("ManageBY:" + sup);
				if (sup.length() > 0) {
					String Managedby = getColumnAttribute(i, col, "title");
					System.out.println("Supplier:" + sup + "," + col + ":" + Managedby);
					if (Managedby.length() > 3) {
						sup = getSupplierName("Name", i);
						sup = sup.trim();
						break outr;
					}
				}
			}

		}
		if (!(sup.length() > 0)) {
			// Assert.assertTrue("Supplier Not found", false);
		}
		return sup;
	}

	public String getSupplierName(String string, int org) {
		String sup = "";
		int colnamecount = ColIdentify("Name");
		int invitecol = colnamecount + 1;
		invitecol = invitecol - 1;
		// int Supcount = org + 1;
		/*
		 * List<WebElement> axs=lavanteUtils.driver.findElements(By.cssSelector(
		 * "#search_results tr:nth-child("+Supcount+") td:nth-child("
		 * +colnamecount+") a," + ""+ " #search_results tr:nth-child("+Supcount+
		 * ") td:nth-child("+invitecol+") a"));
		 * 
		 */
		// List<WebElement>
		// axs=lavanteUtils.driver.findElements(By.cssSelector("#search_results
		// tr:nth-child("+Supcount+") td:nth-child("+invitecol+") a"));
		List<WebElement> listSupp = lavanteUtils.driver
				.findElements(By.cssSelector("#search_results a[id='supplier'][href*='redirect'][href*='Comp']"));
		/*
		 * if(org==0){ Supcount=0; }
		 */
		sup = listSupp.get(org).getAttribute("title");
		if (sup.contains("for ")) {
			String[] ads = sup.split("for ");
			sup = ads[1];
			if (sup.contains(" -")) {
				String[] aads = sup.split(" -");
				sup = aads[0];
			}
		}
		if (sup != null) {
			if (sup.length() == 0) {
				sup = "";
			}
		}
		return sup;
	}

	public int VerifyRequestedBY() {
		int k = 0;

		lavanteUtils.switchtoFrame(SearchListIFRAME);
		outr: if (ColIdentify("Name") > 0) {
			List<WebElement> s = lavanteUtils.driver
					.findElements(By.cssSelector("#search_results td:nth-child(" + ColIdentify("Name") + ") a"));
			System.out.println(s.size());
			for (int i = 0; i <= s.size(); i++) {
				String Requestedby = getColumnAttribute(i, "Invited", "title");
				if (Requestedby.length() > 3) {
					k = i;
					break outr;
				}
			}

		}
		return k;
	}

	public String VerifyManagedBywithoutNetwork(String customerID)
			throws FileNotFoundException, IOException, SQLException {
		String sup = "";
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		outr: if (size > 0) {
			for (int i = 0; i <= size; i++) {
				String Managedby = getColumnAttribute(i, "Pending With", "title");
				if (Managedby.length() > 3) {
					sup = getSupplierName("Name", i).trim();
					int cust = Integer.parseInt(customerID);
					String x = " select count(LavanteUID) from Relationship where LavanteUID in( select LavanteUID from Relationship where LavanteUID in ("
							+ " select LavanteUID from Supplier where SupplierName='" + sup + "')" + " and CustomerID="
							+ cust + ")";
					x = lavanteUtils.fetchDBdata(x);
					int xs = Integer.parseInt(x);
					if (xs > 1) {

					} else {
						break outr;
					}
				}
			}

		}
		return sup;
	}

	public String VerifyContact() {
		String sup = "";

		lavanteUtils.switchtoFrame(SearchListIFRAME);

		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		outr: if (iterateSearchHeaderFindColList("Name").size() > 0) {
			for (int i = 0; i <= size; i++) {
				sup = getSupplierName("Name", i);
				String contact = getColumnAttribute(i, "Contact", "title");
				if (contact.length() > 3) {
					sup = getSupplierName("Name", i);
					break outr;
				}
			}

		}
		return sup;
	}

	public String selectSupplier(LinkedHashMap<String, String> dataMap) {
		String sup = "";
		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		if (iterateSearchHeaderFindColList("Name").size() > 0) {
			if (dataMap.containsKey("supplierName")) {
				outr: for (int i = 0; i <= size; i++) {
					sup = getSupplierName("Name", i);
					if (sup.contains(dataMap.get("supplierName"))) {
						lavanteUtils.click(iterateSearchHeaderFindColList("Status").get(i));
						break outr;
					}
					if (i == size) {
						lavanteUtils.click(iterateSearchHeaderFindColList("Status").get(0));
					}
				}
			} else if (dataMap.containsKey("supplierNameRandom")) {
				int i = lavanteUtils.randomnum(size);
				sup = iterateSearchHeaderFindColList("Name").get(i).getText();
				lavanteUtils.click(iterateSearchHeaderFindColList("Status").get(i));
			} else {
				sup = iterateSearchHeaderFindColList("Name").get(0).getText();
				lavanteUtils.click(iterateSearchHeaderFindColList("Status").get(0));
			}

		}
		lavanteUtils.waitForTime(2000);
		return sup;
	}

	public String expandSupplier(LinkedHashMap<String, String> dataMap) {
		String sup = "";
		int size = iterateSearchHeaderFindColList("Name").size() - 1;
		if (iterateSearchHeaderFindColList("Name").size() > 0) {
			if (dataMap.containsKey("supplierName")) {
				for (int i = 0; i <= size; i++) {
					// sup =
					// iterateSearchHeaderFindColList("Name").get(i).getText();
					sup = getSupplierName("Name", i);
					System.out.println("App Sup:" + sup + ",Expected:" + dataMap.get("supplierName"));
					if (sup.contains(dataMap.get("supplierName"))) {
						lavanteUtils.click(ListExpandSupplier.get(i));
						break;
					}
					if (i == size) {
						lavanteUtils.click(ListExpandSupplier.get(0));
					}
				}
			}

		}
		lavanteUtils.waitForTime(1000);
		return sup;
	}

	public void selectAllSupplier() {
		int size = iterateSearchHeaderFindColList("Name").size();
		if (size > 0) {
			lavanteUtils.click(selectAllSupp);
		}
	}

	private void selectAction(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("profile") || dataMap.containsKey("Account") || dataMap.containsKey("OtherAction")
				|| dataMap.containsKey("Invitation") || dataMap.containsKey("Notification")) {
			lavanteUtils.click(actionBtn);
		}
	}

	private void selectProfileSubAction(LinkedHashMap<String, String> dataMap) throws Exception {
		// Profile Action
		if (dataMap.containsKey("editProfile")) {
			lavanteUtils.click(editprflebtn);
		}
		if (dataMap.containsKey("TakeControl")) {
			lavanteUtils.click(TakeControlbtn);
			lavanteUtils.switchtoFrame(null);
			if (dataMap.containsKey("NoEdit")) {
				lavanteUtils.click(Cancelbtn);
			} else {
				lavanteUtils.click(OKbtn);
			}
		}
		if (dataMap.containsKey("ChangePrimary")) {
			lavanteUtils.click(ChangePrimary);
			lavanteUtils.switchtoFrame(IFRAMEPrimary);
			ChangePrimaryContact(dataMap);
			SelectPrimaryContact(dataMap);
			formContact(dataMap);
		}
		if (dataMap.containsKey("Activate")) {
			lavanteUtils.click(activatebtn);
			Deactivate(dataMap);
		}
		if (dataMap.containsKey("Deactivate")) {
			lavanteUtils.click(Deactivatebtn);
			Deactivate(dataMap);
		}
		// Other Action
		if (dataMap.containsKey("AssociateAgent")) {
			lavanteUtils.click(associateAgent);
			AssociateAgent(dataMap);
		}
		if (dataMap.containsKey("downloaddoc")) {
			lavanteUtils.click(downloaddoc);
			selectDownloadType(dataMap);

		}
		if (dataMap.containsKey("profileComplete")) {
			lavanteUtils.click(profcomplete);
			Movetocomplete(dataMap);

		}
		if (dataMap.containsKey("AssociateVendor")) {
			lavanteUtils.click(associateVendor);
		}
		// Notification
		if (dataMap.containsKey("enable")) {
			lavanteUtils.click(enablebtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OKbtn);
			/*
			 * lavanteUtils.fluentwait(OKbtn); lavanteUtils.click(OKbtn);
			 */
		}
		if (dataMap.containsKey("disable")) {
			lavanteUtils.click(disablebtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OKbtn);
			/*
			 * lavanteUtils.fluentwait(OKbtn); lavanteUtils.click(OKbtn);
			 */
		}
		// Invitation
		if (dataMap.containsKey("EditInvite")) {
			lavanteUtils.click(EditInvitebtn);
		}

		if (dataMap.containsKey("ExtendInvite")) {
			lavanteUtils.click(ExtendInvitebtn);
		}

		if (dataMap.containsKey("DeleteInvite")) {
			lavanteUtils.click(DeleteInvitebtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OkButton);
			/*
			 * lavanteUtils.fluentwait(OkButton); lavanteUtils.click(OkButton);
			 */
		}
		if (dataMap.containsKey("Reinvite")) {
			lavanteUtils.click(Reinvitebtn);
			ReinviteForm(dataMap);
		}
		if (dataMap.containsKey("sendEmail")) {
			lavanteUtils.click(sendEmailbtn);
			sendEmail(dataMap);
		}
		if (dataMap.containsKey("Outreach")) {
			lavanteUtils.click(StartOutreachBtn);
			outreach(dataMap);
		}
		// Move to Profile Complete
		if (dataMap.containsKey("MoveToProfileComplete")) {
			lavanteUtils.click(movToProCompBtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OKbtn);
		}
		if (dataMap.containsKey("ActBehalf")) {
			String x = dataMap.get("ActBehalf");
			lavanteUtils.waitForTime(5000);
			lavanteUtils.moveToElement(actBehalf1);
			lavanteUtils.moveToElement(actBehalf);
			List<WebElement> ele = ListActBehalf;
			String option = null;
			for (int i = 0; i < ele.size(); i++) {
				option = lavanteUtils.getText(ele.get(i));
				if (x.contains(option)) {
					lavanteUtils.click(ele.get(i));
					break;
				}
			}
		}
	}

	private void SelectPrimaryContact(LinkedHashMap<String, String> dataMap) {
		for (int i = 0; i < ContactRdio.size(); i++) {
			boolean u = ContactRdio.get(i).isSelected();
			String x = ContactName2.get(i).getText();
			if (u) {
				dataMap.put("OrgPrimary", x);
			}

			if (!(x.length() > 0)) {
				x = ContactName.getAttribute("value");
			}

			if (x.equalsIgnoreCase(dataMap.get("ChangePrimary"))) {
				lavanteUtils.clicks(ContactRdioSpan.get(i));
			}
		}

	}

	private void formContact(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(SaveBtn2);
		}
	}

	private void ChangePrimaryContact(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("ContactName")) {

			lavanteUtils.click(AddContact);

			if (dataMap.containsKey("ContactName")) {
				String x = dataMap.get("ContactName");
				lavanteUtils.typeinEdit(x, ContactName);
			}
			if (dataMap.containsKey("ContactPhone")) {
				String x = dataMap.get("ContactEmail");
				if (x.equalsIgnoreCase("ANY")) {
					x = lavanteUtils.randomnum();
				}
				lavanteUtils.typeinEdit(x, ContactPhone);
				dataMap.put("ContactPhone", x);
			}
			if (dataMap.containsKey("ContactEmail")) {
				String x = dataMap.get("ContactEmail");
				if (x.equalsIgnoreCase("ANY")) {
					x = "SP@" + lavanteUtils.randomnum() + ".com";
				}

				lavanteUtils.typeinEdit(x, ContactEmail);
				dataMap.put("ContactEmail", x);
			}

			if (dataMap.containsKey("ContactFax")) {
				String x = dataMap.get("ContactFax");
				if (x.equalsIgnoreCase("ANY")) {
					x = lavanteUtils.randomnum();
				}
				lavanteUtils.typeinEdit(x, ContactFax);
				dataMap.put("ContactFax", x);
			}

		}
	}

	private void Deactivate(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(OKbtn);

		lavanteUtils.switchtoFrame(IFRAMEactDeact);
		if (dataMap.containsKey("Comments")) {
			lavanteUtils.typeinEdit(dataMap.get("Comments"), DeactivateComments);
		}
		if (dataMap.containsKey("DeactivateSave")) {
			lavanteUtils.fluentwait(SaveBtn1);
			lavanteUtils.click(SaveBtn1);
		}

	}

	public void sendEmail(LinkedHashMap<String, String> dataMap) throws Exception {

		lavanteUtils.switchtoFrame(IFRAMEsendEmail);
		fillformEmail(dataMap);
		formActionEmail(dataMap);

	}

	public void fillformEmail(LinkedHashMap<String, String> dataMap) throws Exception {

		if (dataMap.containsKey("mailFrom")) {
			String x = dataMap.get("mailFrom");
			if (x.equalsIgnoreCase("any")) {
				lavanteUtils.selectbyNumber(2, mailFrombtn);
			} else {
				lavanteUtils.selectbyvalue(x, mailFrombtn);
			}
			lavanteUtils.switchtoFrame(IFRAMEsendEmail);
		}
		if (dataMap.containsKey("mailTemplate")) {
			lavanteUtils.click(mailTemplate);
			lavanteUtils.selectFrmDpdn(dataMap.get("mailTemplate"));
			lavanteUtils.switchtoFrame(IFRAMEsendEmail);
		}

		if (dataMap.containsKey("AllContacts")) {
			lavanteUtils.click(AllContactRadioBtn);
		}
		if (dataMap.containsKey("SpecificContacts")) {
			lavanteUtils.click(SpecificContactsRadioBtn);
			lavanteUtils.fluentwait(LocationTypeDropDwn);
			if (dataMap.containsKey("LocationType")) {
				lavanteUtils.click(LocationTypeDropDwn);
				lavanteUtils.selectFrmDpdn(dataMap.get("LocationType"));
				lavanteUtils.switchtoFrame(IFRAMEsendEmail);
			}
			if (dataMap.containsKey("Contacts")) {
				lavanteUtils.click(ContactDropDwn);
				lavanteUtils.selectFrmDpdn(dataMap.get("Contacts"));
				lavanteUtils.switchtoFrame(IFRAMEsendEmail);
			}

		}

		if (dataMap.containsKey("mailSubject")) {
			lavanteUtils.typeinEdit(dataMap.get("mailSubject"), mailsubtxt);
		}
		if (dataMap.containsKey("mailMessage")) {
			lavanteUtils.click(mailmsgtxt);
			lavanteUtils.typeinEdit(dataMap.get("mailMessage"), mailmsgtxt);
		}
		if (dataMap.containsKey("attachFile")) {
			String file = dataMap.get("attachFile");
			if (file.contains("#")) {
				String[] f = file.split("#");
				for (int i = 0; i < f.length; i++) {
					String x = f[i];
					lavanteUtils.uploadFile(x, mailUploadbtn);
				}

			} else {
				lavanteUtils.uploadFile(file, mailUploadbtn);
			}

		}
	}

	public void formActionEmail(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEsendEmail);
		if (dataMap.containsKey("mailSend")) {
			lavanteUtils.click(mailSendbtn);
			confirmsendEmail(dataMap);
		}
		if (dataMap.containsKey("mailSave")) {
			lavanteUtils.click(mailSavebtn);
			SaveTemplate(dataMap);
		}
		if (dataMap.containsKey("mailClear")) {
			lavanteUtils.click(mailClearbtn);
		}

	}

	public void confirmsendEmail(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if (dataMap.containsKey("mailSend")) {
			lavanteUtils.click(OKbtn);
			if (dataMap.containsKey("confirmMailSend")) {

			} else {
				// lavanteUtils.click(OKbtn);
			}
		}
	}

	public void outreach(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEOutreach);
		if (dataMap.containsKey("Success")) {
			lavanteUtils.click(outReachbtn);
			if (dataMap.containsKey("OKBtn")) {

			} else {
				// lavanteUtils.click(OKbtn);
			}
		}
	}

	private void SaveTemplate(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(OKbtn);
		if (dataMap.containsKey("mailTemplateName")) {
			lavanteUtils.typeinEdit(dataMap.get("mailTemplateName"), mailTemplateNametxt);
		}
		if (dataMap.containsKey("mailSave")) {
			lavanteUtils.click(OKbtn);
		}

	}

	public void Movetocomplete(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);

		if (dataMap.containsKey("ProfCancel")) {

		} else {
			lavanteUtils.click(OKbtn);
		}

	}

	private void AssociateAgent(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(OKbtn);

		// No Assoicate Not Written due to the test needs to read the msg

	}

	// For Reinvite
	public void ReinviteForm(LinkedHashMap<String, String> dataMap) {
		fillFormReinvite(dataMap);
		formActionReinvite(dataMap);
	}

	private void fillFormReinvite(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEreinvite);
		if (dataMap.containsKey("NewContact")) {
			if (dataMap.containsKey("ContactName")) {
				lavanteUtils.typeinEdit(dataMap.get("ContactName"), ReinvitecontactName);
			}
			if (dataMap.containsKey("ContactEmail")) {
				lavanteUtils.typeinEdit(dataMap.get("ContactEmail"), ReinvitecontactEmail);
			}
		}

	}

	public void formActionReinvite(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEreinvite);
		if (dataMap.containsKey("Invite")) {
			lavanteUtils.click(popupInviteBtn);
			lavanteUtils.switchtoFrame(null);
			/*
			 * lavanteUtils.fluentwait(OKbtn); lavanteUtils.click(OKbtn);
			 */
		}
	}

	// For Download
	private void selectDownloadType(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(IFRAMEdownloadoc);
		/*
		 * for(int i=0;i<requestdocgrp.size();i++){ String
		 * see=requestdocgrp.get(i).getText(); System.out.println(see);
		 * 
		 * }
		 */

	}

	public void Movedoc(LinkedHashMap<String, String> dataMap) {

		lavanteUtils.switchtoFrame(IFRAMEdownloadoc);

		if (dataMap.containsKey("LefttoRight")) {
			String leftdocs = dataMap.get("LefttoRight");
			String org = leftdocs;
			if (org.contains("#")) {
				String[] sp = leftdocs.split("#");
				for (int j = 0; j < sp.length; j++) {
					for (int k = 0; k < MoveDocToSelect.size(); k++) {
						String see = MoveDocToSelect.get(k).getText();
						leftdocs = sp[j];
						if (leftdocs.equalsIgnoreCase(see)) {
							lavanteUtils.click(MoveDocToSelect.get(k));
							lavanteUtils.click(moveSelectedtoLeft);
							break;
						}

					}
				}

			} else {
				for (int i = 0; i < MoveDocToSelect.size(); i++) {
					String see = MoveDocToSelect.get(i).getText();
					if (leftdocs.equalsIgnoreCase(see)) {
						lavanteUtils.click(MoveDocToSelect.get(i));
						lavanteUtils.click(moveSelectedtoLeft);
					}
				}
			}

			formActionMove(dataMap);

		}

	}

	private void formActionMove(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("OK")) {
			lavanteUtils.click(moveDocOKbtn);
			lavanteUtils.switchtoFrame(null);
		}
		if (dataMap.containsKey("Reset")) {
			lavanteUtils.click(resetBtn);
		}
	}

	public int ColIdentify(String col) {
		int ki = 0;
		boolean found = false;
		lavanteUtils.fluentwait(Headers.get(0));
		if (Headers.size() > 0) {
			for (int i = 0; i < Headers.size(); i++) {
				String x = Headers.get(i).getText().toLowerCase();
				if (x.contains(col.toLowerCase())) {
					ki = i;
					// List start with 0 but need a number more than that to
					// fetch in xpath
					ki = i + 1;
					found = true;
					break;
				}
			}
		}

		if (found == false) {
			/*
			 * Reporter.log(
			 * "Col name not found,Will be trying with Other Column," + col,
			 * found); ColIdentify("Pending");
			 */
			Assert.assertTrue(found, "Col name not found" + col);
		}
		return ki;

	}

	public List<WebElement> iterateSearchHeaderFindColList(String col) {
		List<WebElement> s = null;
		int j = ColIdentify(col);
		int y = j + 1;
		String x = "#search_results tr td:nth-child(" + j + ")";
		s = lavanteUtils.driver.findElements(By.cssSelector(x));
		if (col.contains("Contact") || col.contains("Name")) {

			x = "#search_results tr td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		} else if (col.contains("Notes")) {
			x = "#search_results tr td:nth-child(" + j + ") a";
			s = lavanteUtils.driver.findElements(By.cssSelector(x));
		}
		return s;
	}

	public String getColumnText(String colname, int invitecount) {
		String x = "";
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		int size = iterateSearchHeaderFindColList(colname).size();
		List<WebElement> sx = iterateSearchHeaderFindColList(colname);
		outr: for (int i = 0; i < size; i++) {
			x = sx.get(i).getText();
			if (invitecount == 0) {
				if (x.length() > 0) {
					break outr;
				}
			} else {
				x = sx.get(invitecount).getText();
				break outr;
			}
		}
		return x;
	}

	public String getColumnAttribute(int Supcount, String colname, String attribute) {
		String x = "";
		int colheadermatch = ColIdentify(colname);
		// Adding one for Invite Supplier
		int nwcol = colheadermatch + 1;
		Supcount = Supcount + 1;
		System.out.println("#search_results tr:nth-child(" + Supcount + ") td:nth-child(" + colheadermatch + ")");
		List<WebElement> xs = lavanteUtils.driver.findElements(
				By.cssSelector("#search_results tr:nth-child(" + Supcount + ") td:nth-child(" + colheadermatch + ")"));

		outr: for (int p = xs.size() - 1; p >= 0; p--) {

			x = xs.get(p).getAttribute(attribute);
			System.out.println("ATtr:" + x);
			if (x.length() > 0) {
				break outr;
			}
		}
		return x;
	}

	public void searchResultsFilterBy(String type) {
		lavanteUtils.switchtoFrame(SearchListIFRAME);
		if (type.equalsIgnoreCase("All") || type.equalsIgnoreCase("Any")) {
			lavanteUtils.click(FilterByAllRadiobtn);
		} else if (type.equalsIgnoreCase("My Division")) {
			lavanteUtils.click(FilterByMyDivisionRadiobtn);
		} else if (type.equalsIgnoreCase("My Invites")) {
			lavanteUtils.click(FilterByMyInvitesRadiobtn);
		}
	}

	public void selectChangeView(String type) {
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("SearchOption", type);
		searchView(LdataMap);
	}
}
