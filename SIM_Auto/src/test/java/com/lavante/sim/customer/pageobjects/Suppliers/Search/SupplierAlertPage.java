package com.lavante.sim.customer.pageobjects.Suppliers.Search;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Subhas.BV
 *
 */
public class SupplierAlertPage {

	public WebDriver driver;
	LavanteUtils lavanteUtils = new LavanteUtils();

	public SupplierAlertPage(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}

	// All alert
	// Add alert

	@FindBy(css="iframe[src*='addEditAlert']")
	private WebElement AlertIframe;

	public WebElement AlertIframe() {
		return AlertIframe;
	}

	@FindBy(css="div[class*='titlebar'] span")
	private WebElement AddAlertTitleBar;

	public WebElement AddAlertTitleBar() {
		return AddAlertTitleBar;
	}

	@FindBy(name="unsubscribe_manage_alert")
	private WebElement UnsubscribeAllAlertBtn;

	public WebElement UnsubscribeAllAlertBtn() {
		return UnsubscribeAllAlertBtn;
	}

	@FindBy(name="add_alert")
	private WebElement AllAddAlertBtn;

	public WebElement AllAddAlertBtn() {
		return AllAddAlertBtn;
	}
	
	@FindBy(css="[id*='entity']>a")
	private WebElement EntityDpdn;

	public WebElement EntityDpdn() {
		return EntityDpdn;
	}

	@FindBy(css="[id*='savedSearch']>a")
	private WebElement SavedQueryDropDwn;

	public WebElement SavedQueryDropDwn() {
		return SavedQueryDropDwn;
	}
	
	@FindBy(css="[id*='savedSearch'] input")
	private WebElement SavedQueryDropDwntxt;

	@FindBy(name="alertName")
	private WebElement AlertNameTxtBox;

	public WebElement AlertNameTxtBox() {
		return AlertNameTxtBox;
	}

	@FindBy(name="alertEmailSubject")
	private WebElement EmailSubjectTxtBox;

	public WebElement EmailSubjectTxtBox() {
		return EmailSubjectTxtBox;
	}

	@FindBy(name="alertEmailBody")
	private WebElement EmailBodyTxtArea;

	public WebElement EmailBodyTxtArea() {
		return EmailBodyTxtArea;
	}

	@FindBy(css="label[for*='sendToUser_role']")
	private WebElement RoleChkBox;

	public WebElement RoleChkBox() {
		return RoleChkBox;
	}

	@FindBy(css="[id*='sendToUser_role']")
	private WebElement RoleChkBoxinput;

	public WebElement RoleChkBoxinput() {
		return RoleChkBoxinput;
	}
	
	@FindBy(css="div[id*='sendToUser_roledrop'] input")
	private WebElement RoleDropDwn;

	public WebElement RoleDropDwn() {
		return RoleDropDwn;
	}
	
	@FindBy(css="[id*='sendToUser_role']")
	private WebElement UserChkBoxinput;

	public WebElement UserChkBoxinput() {
		return UserChkBoxinput;
	}

	@FindBy(css="label[for*='sendToUser_user']")
	private WebElement UserChkBox;

	public WebElement UserChkBox() {
		return UserChkBox;
	}

	@FindBy(css="[id*='sendToUser_userdrop']")
	private WebElement UserDropDwn;

	public WebElement UserDropDwn() {
		return UserDropDwn;
	}

	@FindBy(id="alertFrequency_number")
	private WebElement FrequencyEveryNoBox;

	public WebElement FrequencyEveryNoBox() {
		return FrequencyEveryNoBox;
	}

	@FindBy(css="[id*='alertFrequency']>a")
	private WebElement FrequencyEveryDropDwn;

	public WebElement FrequencyEveryDropDwn() {
		return FrequencyEveryDropDwn;
	}

	@FindBy(id="deliveryStartDate")
	private WebElement DeliveryStartDate;

	public WebElement DeliveryStartDate() {
		return DeliveryStartDate;
	}

	@FindBy(css="a[class*='highlight']")
	private WebElement todaydate;

	public WebElement todaydate() {
		return todaydate;
	}

	@FindBy(id="deliveryEndDate")
	private WebElement DeliveryEndDate;

	public WebElement DeliveryEndDate() {
		return DeliveryEndDate;
	}

	@FindBy(css="[id*='reportTemplate'] a")
	private WebElement AlertTemplateFormatDropDwn;

	public WebElement AlertTemplateFormatDropDwn() {
		return AlertTemplateFormatDropDwn;
	}

	@FindBy(css="iframe#search_results")
	private WebElement SearchListIFRAME;

	public WebElement SearchListIFRAME() {
		return SearchListIFRAME;
	}

	// Form Actions
	@FindBy(css="[class*='cancel']")
	private WebElement CancelBtn;

	public WebElement CancelBtn() {
		return CancelBtn;
	}

	@FindBy(css="button[class*='primary']")
	private WebElement SaveBtn;

	public WebElement SaveBtn() {
		return SaveBtn;
	}

	@FindBy(css="div[class*='dialog'] button[class*='primary']")
	private WebElement OkBtn;

	public WebElement OkBtn() {
		return OkBtn;
	}

	// Table

	@FindBy(css="th td[class*='align_left']")
	private WebElement GetTableHeader;

	public WebElement GetTableHeader() {
		return GetTableHeader;
	}
	
	@FindBy(css="#myAlert th td[class*='align_left']")
	private WebElement GetMyAlertTableHeader;

	public WebElement GetMyAlertTableHeader() {
		return GetMyAlertTableHeader;
	}

	@FindBy(xpath="//div[@id='allAlert']/table/descendant::th")
	private List<WebElement> AllAlertTableColumnHeaders;

	public List<WebElement> AllAlertTableColumnHeaders() {
		return AllAlertTableColumnHeaders;
	}

	@FindBy(css="[id*='allAlert'] a[href*='viewAlert']")
	private List<WebElement> AllAlertNameList;

	public List<WebElement> AllAlertNameList() {
		return AllAlertNameList;
	}
	
	@FindBy(css="table[id*='my_alert_table'] tbody input:nth-child(1)")
	private List<WebElement> MyAlertNameChkBoxList;

	public List<WebElement> MyAlertNameChkBoxList() {
		return MyAlertNameChkBoxList;
	}
	
	@FindBy(css="[id*='my_alert_table'] a[href*='viewAlert']")
	private List<WebElement> MyAlertNameList;

	public List<WebElement> MyAlertNameList() {
		return MyAlertNameList;
	}

	@FindBy(css="[id*='my_alert_table'] td:nth-child(3)")
	private List<WebElement> MyAlertFreqList;

	@FindBy(css="a[href*='#allAlert']")
	private WebElement AllAlertTab;

	// Tabs
	public WebElement AllAlertTab() {
		return AllAlertTab;
	}

	@FindBy(id="myAlertTab")
	private WebElement MyAlertTab;

	public WebElement MyAlertTab() {
		return MyAlertTab;
	}

	// My Alert Tab page
	@FindBy(name="unsubscribe_alert")
	private WebElement UnsubscribeMyAlertBtn;

	public WebElement UnsubscribeMyAlertBtn() {
		return UnsubscribeMyAlertBtn;
	}

	@FindBy(name="create_new_alert")
	private WebElement MyAddAlertBtn;

	public WebElement MyAddAlertBtn() {
		return MyAddAlertBtn;
	}

	@FindBy(id="edit_alert")
	private WebElement EditAlertBtn;

	public WebElement EditAlertBtn() {
		return EditAlertBtn;
	}

	@FindBy(id="delete_alert")
	private WebElement DeleteAlertBtn;

	public WebElement DeleteAlertBtn() {
		return DeleteAlertBtn;
	}

	@FindBy(xpath="//div[@id='myAlert']/table/descendant::th")
	private List<WebElement> MyAlertTableColumnHeaders;

	public List<WebElement> MyAlertTableColumnHeaders() {
		return MyAlertTableColumnHeaders;
	}

	@FindBy(css="button[href*='addEditAlert']")
	private WebElement AddAlertBtn;

	public WebElement AddAlertBtn() {
		return AddAlertBtn;
	}

	@FindBy(css="form[action*='saveAlert'] label[class='required_field']")
	private List<WebElement> AddAlertMandatoryFieldsList;

	public List<WebElement> AddAlertMandatoryFieldsList() {
		return AddAlertMandatoryFieldsList;
	}
	
	@FindBy(css="div[class*='dialog undefined ui-dialog-content']")
	private WebElement GetPopUpMsg;

	public WebElement GetPopUpMsg() {
		return GetPopUpMsg;
	}
	

	public void addAlert(LinkedHashMap<String, String> dataMap) {
		selectTab(dataMap);
		lavanteUtils.click(AddAlertBtn);
		fillDetails(dataMap);
		formActions(dataMap);

	}
	
	public void editAlert(LinkedHashMap<String, String> dataMap) {
		//lavanteUtils.fluentwait(EditAlertBtn);
		lavanteUtils.click(EditAlertBtn);
	//	lavanteUtils.switchtoFrame(AlertIframe);
		fillDetails(dataMap);
		formActions(dataMap);

	}

	public void selectTab(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("AllAlertTab")) {
			lavanteUtils.click(AllAlertTab);
		}
		if (dataMap.containsKey("MyAlertTab")) {
			lavanteUtils.click(MyAlertTab);
		}
	}

	private void fillDetails(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(AlertIframe);
		lavanteUtils.fluentwait(SaveBtn);
		if (dataMap.containsKey("Entity")) {
			//lavanteUtils.Scrollintoview(SavedQueryDropDwn);
			lavanteUtils.click(EntityDpdn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("Entity"));
			lavanteUtils.switchtoFrame(AlertIframe);
		}
		if (dataMap.containsKey("SavedQuery")) {
			//lavanteUtils.Scrollintoview(SavedQueryDropDwn);
			lavanteUtils.click(SavedQueryDropDwn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.typeinEdit(dataMap.get("SavedQuery"), SavedQueryDropDwntxt);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("SavedQuery"));
			lavanteUtils.switchtoFrame(AlertIframe);
		}
		if (dataMap.containsKey("AlertName")) {
			String alerName = "" + lavanteUtils.typeinEdit(dataMap.get("AlertName"), AlertNameTxtBox);
			dataMap.put("AlertName", alerName);
		}
		if (dataMap.containsKey("EmailSubject")) {
			lavanteUtils.typeinEdit(dataMap.get("EmailSubject"), EmailSubjectTxtBox);
		}
		if (dataMap.containsKey("EmailMessageBody")) {
			lavanteUtils.typeinEdit(dataMap.get("EmailMessageBody"), EmailBodyTxtArea);
		}
		if (dataMap.containsKey("RoleAndOption")) {
			String[] data = dataMap.get("RoleAndOption").split("#");
			lavanteUtils.selectChkBox(RoleChkBox, data[0]);
			// lavanteUtils.Scrollintoview(RoleDropDwn);
			lavanteUtils.click(RoleDropDwn);
			lavanteUtils.selectvalueFrmDpdn(data[1]);
			lavanteUtils.switchtoFrame(AlertIframe);
		}
		if (dataMap.containsKey("UserAndOption")) {
			String[] data = dataMap.get("UserAndOption").split("#");
			lavanteUtils.selectChkBox(UserChkBox, data[0]);
			lavanteUtils.Scrollintoview(UserDropDwn);
			lavanteUtils.click(UserDropDwn);
			lavanteUtils.selectvalueFrmDpdn(data[1]);
			lavanteUtils.switchtoFrame(AlertIframe);
		}
		if (dataMap.containsKey("FrequencyAndOption")) {
			String[] data = dataMap.get("FrequencyAndOption").split("#");
			lavanteUtils.typeinEdit(data[0], FrequencyEveryNoBox);
			//lavanteUtils.Scrollintoview(FrequencyEveryDropDwn);
			lavanteUtils.click(FrequencyEveryDropDwn);
			lavanteUtils.selectvalueFrmDpdn(data[1]);
			lavanteUtils.switchtoFrame(AlertIframe);
		}
		if (dataMap.containsKey("DeliveryStartDate")) {
			lavanteUtils.click(DeliveryStartDate);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(2000);
			lavanteUtils.click(todaydate);
			lavanteUtils.switchtoFrame(AlertIframe);
		}
		if (dataMap.containsKey("AlertTemplateFormat")) {
			lavanteUtils.Scrollintoview(AlertTemplateFormatDropDwn);
			lavanteUtils.click(AlertTemplateFormatDropDwn);
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("AlertTemplateFormat"));
			lavanteUtils.switchtoFrame(AlertIframe);
		}
	}

	private void formActions(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(AlertIframe);
		if (dataMap.containsKey("AlertCancel")) {
			lavanteUtils.click(CancelBtn);
		}
		if (dataMap.containsKey("AlertSave")) {
			lavanteUtils.click(SaveBtn);
			lavanteUtils.switchtoFrame(null);
		}
	}

	public void deleteAlertFromTable(String alertName) {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("MyAlertTab", "");
		selectTab(dataMap);

		int alertNamesSize = MyAlertFreqList.size();
		for (int i = 0; i < alertNamesSize; i++) {
			WebElement obj = MyAlertNameList.get(0);
			if (lavanteUtils.getText(obj).startsWith(alertName) || lavanteUtils.getText(obj).contains(alertName)) {
				lavanteUtils.click(MyAlertFreqList.get(0));
				lavanteUtils.click(DeleteAlertBtn);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.click(OkBtn);
				lavanteUtils.waitForTime(4000);
			}
		}
	}

}
