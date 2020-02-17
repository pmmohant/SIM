package com.lavante.recovery.pageobjects.configuration.Others;

import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.lavante.recovery.Common.Util.LavanteUtils;

/**
 * @author Nagappa Date - 09/08/2017 This class is to capture page objects of
 *         Others page from Configuration tab
 *
 */
public class OthersPage {
	LavanteUtils lavanteUtils = new LavanteUtils();
	public WebDriver driver = null;

	public OthersPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}

	//Others menu from Configuration tab
	@FindBy(css="a[title='Others']")
	private WebElement othersTab;
	public WebElement othersTab(){
		return othersTab;
	}
	public void othersTabClick() {	
		lavanteUtils.click(othersTab);			  
	}
	
	/*************** Fax Comments Tab  **************************/
	// Fax comments tab
	@FindBy(css = "a[href='otherConfiguration.lvp']")
	private WebElement faxCommentsTab;
	public List<WebElement> faxComment() {
		return faxComment;
	}
	public void faxCommentsTabClick(){
		lavanteUtils.click(faxCommentsTab);
	}

	// Fax Comments table - Comment column
	@FindBy(css = "#fax_comment tbody td:nth-child(1)")
	private List<WebElement> faxComment;
	public WebElement faxCommentsTab() {
		return faxCommentsTab;
	}

	// Fax Comments table - Active column
	@FindBy(css = "#fax_comment tbody td:nth-child(2)")
	private List<WebElement> faxCommentActive;
	public List<WebElement> faxCommentActive() {
		return faxCommentActive;
	}

	// Fax Comments table - Action column
	@FindBy(css = "#fax_comment tbody td:nth-child(3)")
	private List<WebElement> faxCommentAction;
	public List<WebElement> faxCommentAction() {
		return faxCommentAction;
	}

	// addNew button
	@FindBy(css = "input[href*='table_id=fax_comment']")
	private WebElement addNewBtnFax;
	public WebElement addNewBtnFax() {
		return addNewBtnFax;
	}

	// iFrame
	@FindBy(css = "iframe[src*='openAddEditFaxCommentPop']")
	private WebElement IFRAMEaddNewFrameFax;
	public WebElement IFRAMEaddNewFrameFax() {
		return IFRAMEaddNewFrameFax;
	}

	// Comment entry box from the frame
	@FindBy(id = "Change")
	private WebElement editCommentFax;
	public WebElement editCommentFax() {
		return editCommentFax;
	}

	// Active check box from the frame
	@FindBy(css = "input[type='checkbox'][name='status']")
	private WebElement activeCheckBoxFax;
	public WebElement activeCheckBoxFax() {
		return activeCheckBoxFax;
	}

	// OK button from the Frame
	@FindBy(id = "OK")
	private WebElement submitBtnFax;
	public WebElement submitBtnFax() {
		return submitBtnFax;
	}

	// Cancel button from the Frame
	@FindBy(id = "cancel")
	private WebElement cancelBtnFax;
	public WebElement cancelBtnFax() {
		return cancelBtnFax;
	}

	// Success or failure message after adding comment
	@FindBy(css = "div[class*='dialog-content']")
	private WebElement messgaeValue;
	public WebElement messgaeValue() {
		return messgaeValue;
	}

	// Accept success or failure message dialog box
	@FindBy(css = "div[style*='bloc'] button[class*='button_green']")
	private WebElement OkbtnFax;
	public WebElement OkbtnFax() {
		return OkbtnFax;
	}

	// edit icon for fax comment editing
	@FindBy(css = "a[href*='openAddEditFaxComment']")
	private List<WebElement> editFax;
	public List<WebElement> editFax() {
		return editFax;
	}

	// delete icon for fax comment deletion
	@FindBy(css = "a[href*='deleteComment.lvp']")
	private List<WebElement> deleteFax;
	public List<WebElement> deleteFax() {
		return deleteFax;
	}

	/*************** Credit Rejection Reasons Tab  **************************/

	// Credit Rejection Reason tab
	@FindBy(css = "a[href='creditRejectionReason.lvp']")
	private WebElement creditRejectionReasonTab;
	public WebElement creditRejectionReasonTab() {
		return creditRejectionReasonTab;
	}
	
	public void creditRejectionTabClick(){
		creditRejectionReasonTab.click();
	}

	// Credit Rejection Reasons table rows
	@FindBy(css = "table[id='credit_rejection'] tbody tr")
	private List<WebElement> creditRejectionAllRows;
	public List<WebElement> creditRejectionAllRows() {
		return creditRejectionAllRows;
	}

	// Credit Rejection Reasons table - Reasons column
	@FindBy(css = "#credit_rejection tbody td:nth-child(1)")
	private List<WebElement> creditRejectionReasons;
	public List<WebElement> creditRejectionReasons() {
		return creditRejectionReasons;
	}

	// Credit Rejection Reasons table - Active column
	@FindBy(css = "#credit_rejection tbody td:nth-child(2)")
	private List<WebElement> creditRejectionActive;
	public List<WebElement> creditRejectionActive() {
		return creditRejectionActive;
	}

	// Credit Rejection Reasons table - Action column
	@FindBy(css = "#credit_rejection tbody td:nth-child(3)")
	private List<WebElement> creditRejectionAction;
	public List<WebElement> creditRejectionAction() {
		return creditRejectionAction;
	}

	// addNew button - Credit Rejection
	@FindBy(css = "input[href*='table_id=credit_rejection']")
	private WebElement addNewBtnCredit;
	public WebElement addNewBtnCredit() {
		return addNewBtnCredit;
	}

	// iFrame
	@FindBy(css = "iframe[src*='openAddEditCreditReasonPop']")
	private WebElement IFRAMEopenAddEditCreditReasonPop;
	public WebElement IFRAMEopenAddEditCreditReasonPop() {
		return IFRAMEopenAddEditCreditReasonPop;
	}

	// Reasons input text box
	@FindBy(id = "reason")
	private WebElement reason;
	public WebElement reason() {
		return reason;
	}

	// active check box
	@FindBy(css = "input[type='checkbox'][name='status']")
	private WebElement activeCheckBoxCredit;
	public WebElement activeCheckBoxCredit() {
		return activeCheckBoxCredit;
	}

	// OK button from the Frame
	@FindBy(id = "OK")
	private WebElement submitBtnCredit;
	public WebElement submitBtnCredit() {
		return submitBtnCredit;
	}

	// Cancel button from the Frame
	@FindBy(id = "cancel")
	private WebElement cancelBtnCredit;
	public WebElement cancelBtnCredit() {
		return cancelBtnCredit;
	}

	// Success or failure message after adding reasons
	@FindBy(css = "div[class*='dialog-content']")
	private WebElement messgaeValueCredit;
	public WebElement messgaeValueCredit() {
		return messgaeValueCredit;
	}

	// Accept success or failure message dialogue box -credit
	@FindBy(css = "div[style*='bloc'] button[class*='button_green']")
	private WebElement OkbtnCredit;
	public WebElement OkbtnCredit() {
		return OkbtnCredit;
	}

	// edit icon for credit reasons editing
	@FindBy(css = "a[href*='openAddEditCreditReasonPop']")
	private List<WebElement> editCredit;
	public List<WebElement> editCredit() {
		return editCredit;
	}

	// delete icon for credit reasons deletion
	@FindBy(css = "a[href*='DeleteCreditReason']")
	private List<WebElement> deleteCredit;
	public List<WebElement> deleteCredit() {
		return deleteCredit;
	}

	/*************** Phone Extension Tab  **************************/

	// Phone Extension tab
	@FindBy(css = "a[href='phoneExtension.lvp']")
	private WebElement phoneExtensionTab;
	public WebElement phoneExtensionTab() {
		return phoneExtensionTab;
	}
	// UserName - Phone
	@FindBy(css = "table[id='phoneExtension'] tbody tr td:nth-child(1)")
	private List<WebElement> userName;
	public List<WebElement> userName() {
		return userName;
	}

	// DID - Phone
	@FindBy(css = "table[id='phoneExtension'] tbody tr td:nth-child(5)")
	private List<WebElement> DID;
	public List<WebElement> DID() {
		return DID;
	}

	// Edit action - Phone
	@FindBy(css = "a[class*='icon_note_edit']")
	private List<WebElement> editPhone;
	public List<WebElement> editPhone() {
		return editPhone;
	}

	// Delete action - Phone
	@FindBy(css = "a[href*='deletePhoneExtension']")
	private List<WebElement> deletePhone;
	public List<WebElement> deletePhone() {
		return deletePhone;
	}

	// Add New action - Phone
	@FindBy(css = "input[href*='AddEditPhoneExtension']")
	private WebElement addNewPhone;
	public WebElement addNewPhone() {
		return addNewPhone;
	}

	// iframe for addnew - Phone
	@FindBy(css = "iframe[src*='AddEditPhoneExtension']")
	private WebElement IFRAMEaddNewFramePhone;
	public WebElement IFRAMEaddNewFramePhone() {
		return IFRAMEaddNewFramePhone;
	}

	// userName from iFrame
	@FindBy(id = "name")
	private WebElement enterUserNamePhone;
	public WebElement enterUserNamePhone() {
		return enterUserNamePhone;
	}

	// DID from iFrame
	@FindBy(id = "diD")
	private WebElement enterdiDPhone;
	public WebElement enterdiDPhone() {
		return enterdiDPhone;
	}

	// Save from iFrame
	@FindBy(id = "OK")
	private WebElement saveBtnPhone;
	public WebElement saveBtnPhone() {
		return saveBtnPhone;
	}

	// Cancel from iFrame
	@FindBy(id = "cancel")
	private WebElement cancelBtnPhone;
	public WebElement cancelBtnPhone() {
		return cancelBtnPhone;
	}

	// Success or failure message after adding Phone details
	@FindBy(css = "div[class*='dialog-content']")
	private WebElement messgaeValuePhone;
	public WebElement messgaeValuePhone() {
		return messgaeValuePhone;
	}

	// Accept success or failure message dialogue box - Phone
	@FindBy(css = "div[class*='ui-dialog-buttonpane'] button[class*='button_green']")
	private WebElement OkbtnPhone;
	public WebElement OkbtnPhone() {
		return OkbtnPhone;
	}

	/******************** Methods for Fax Comments Tab ********************/

	public void addFaxComment(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(addNewBtnFax);
		lavanteUtils.switchtoFrame(IFRAMEaddNewFrameFax);
		fillFaxComment(dataMap);
		formFaxComment(dataMap);
	}

	/*public void editFaxComment(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("FaxComment")) {
			if (dataMap.get("FaxComment").equalsIgnoreCase("ANY")) {
				lavanteUtils.click(editFax.get(0));
			} else {
				for (int i = 0; i < faxComment.size(); i++) {
					if (faxComment.get(i).getText().equalsIgnoreCase(dataMap.get("FaxComment"))) {
						lavanteUtils.click(editFax.get(i));
					}
				}
			}
			lavanteUtils.switchtoFrame(IFRAMEaddNewFrameFax);
			fillFaxComment(dataMap);
			formFaxComment(dataMap);
		}
	}*/
	public void editFaxComment(LinkedHashMap<String, String> dataMap) {
		int i=Integer.parseInt(dataMap.get("Index"));
								lavanteUtils.click(editFax.get(i));
					
			lavanteUtils.switchtoFrame(IFRAMEaddNewFrameFax);
			fillFaxComment(dataMap);
			formFaxComment(dataMap);					
		}
	
	public void fillFaxComment(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("FaxComment")) {
			lavanteUtils.typeString(dataMap.get("FaxComment"), editCommentFax);
		}
		if (dataMap.containsKey("Active")) {
			if(!activeCheckBoxFax.isSelected() && dataMap.get("Active") == "true")
			lavanteUtils.click(activeCheckBoxFax);
		}
	}

	public void formFaxComment(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(submitBtnFax);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OkbtnFax);
		}
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.click(cancelBtnFax);
			lavanteUtils.switchtoFrame(null);
		}
	}

	public void deleteFaxComment(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("FaxComment")) {
			if (dataMap.get("FaxComment").equalsIgnoreCase("ANY")) {
				lavanteUtils.click(deleteFax.get(0));
			} else {
				for (int i = 0; i < faxComment.size(); i++) {
					if (faxComment.get(i).getText().equalsIgnoreCase(dataMap.get("FaxComment"))) {
						lavanteUtils.click(deleteFax.get(i));
					}
				}
			}
		}
	}
	
	/******************** Methods for Credit Rejection Reasons Tab ********************/
	public void addCreditReason(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(addNewBtnCredit);
		lavanteUtils.switchtoFrame(IFRAMEopenAddEditCreditReasonPop);
		fillCreditReasons(dataMap);
		formCreditReasons(dataMap);
	}

	public void editCreditReason(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Reason")) {
			if (dataMap.get("Reason").equalsIgnoreCase("ANY")) {
				lavanteUtils.click(editCredit.get(0));
			} else {
				for (int i = 0; i < creditRejectionReasons.size(); i++) {
					if (creditRejectionReasons.get(i).getText()
							.equalsIgnoreCase(dataMap.get("Reason"))) {
						lavanteUtils.click(editCredit.get(i));
					}
				}
			}
			fillCreditReasons(dataMap);
			formCreditReasons(dataMap);
			
		}
	}

	public void fillCreditReasons(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("CreditReason")) {
			lavanteUtils.typeString(dataMap.get("CreditReason"), reason);
		}
		if (dataMap.containsKey("Active")) {
			if(!activeCheckBoxCredit.isSelected() && dataMap.get("Active") == "true")
			lavanteUtils.click(activeCheckBoxCredit);
		}
	}

	public void formCreditReasons(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(submitBtnCredit);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OkbtnCredit); // this is to accept the success/failure msg
			
		}
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.click(cancelBtnCredit);
			lavanteUtils.switchtoFrame(null);
		}
	}
	
	public void deleteCreditReason(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("Reason")) {
			if (dataMap.get("Reason").equalsIgnoreCase("ANY")) {
				lavanteUtils.click(deleteCredit.get(0));
			} else {
				for (int i = 0; i < creditRejectionReasons.size(); i++) {
					if (creditRejectionReasons.get(i).getText()
							.equalsIgnoreCase(dataMap.get("Reason"))) {
						lavanteUtils.click(deleteCredit.get(i));
					}
				}
			}
		}
	}

	/********************  Methods for Phone Extensions Tab  ********************/
	public void addPhoneExtension(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.click(addNewPhone);
		lavanteUtils.switchtoFrame(IFRAMEaddNewFramePhone);
		fillPhoneExtension(dataMap);
		formPhoneExtension(dataMap);		
	}

	public void editPhoneExtension(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("UserName")) {
			if (dataMap.get("UserName").equalsIgnoreCase("ANY")) {
				lavanteUtils.click(editPhone.get(0));
			} else {
				for (int i = 0; i < userName.size(); i++) {
					if (userName.get(i).getText()
							.equalsIgnoreCase(dataMap.get("UserName"))) {
						lavanteUtils.click(editPhone.get(i));
					}
				}
			}
			// Switch to edit frame
			lavanteUtils.switchtoFrame(IFRAMEaddNewFramePhone);
			fillPhoneExtension(dataMap);
			formPhoneExtension(dataMap);
		}
	}

	public void fillPhoneExtension(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("UserName")) {
			lavanteUtils.typeString(dataMap.get("UserName"), enterUserNamePhone);
		}
		if (dataMap.containsKey("DID")) {
			lavanteUtils.typeString(dataMap.get("DID"), enterdiDPhone);
		}
	}

	public void formPhoneExtension(LinkedHashMap<String, String> dataMap) {

		if (dataMap.containsKey("Save")) {
			lavanteUtils.click(saveBtnPhone);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(OkbtnPhone);					
		}
		if (dataMap.containsKey("Cancel")) {
			lavanteUtils.click(cancelBtnPhone);
			lavanteUtils.switchtoFrame(null);
		}
	}
	public void deletePhoneExtension(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("UserName")) {
			if (dataMap.get("UserName").equalsIgnoreCase("ANY")) {
				lavanteUtils.click(deletePhone.get(0));
			} else {
				for (int i = 0; i < userName.size(); i++) {
					if (userName.get(i).getText()
							.equalsIgnoreCase(dataMap.get("UserName"))) {
						lavanteUtils.click(deletePhone.get(i));
					}
				}
			}
		}
	}

}
