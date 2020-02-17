package com.lavante.recovery.pageobjects.configuration.Account;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.recovery.Common.Util.LavanteUtils;
/**
 * AccountPage Class
 * 
 * @author Girish Umesh Naik
 *  
 */
public class AccountPage {
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public AccountPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	//Configuration Link
	@FindBy(css="a[href='/recovery/configuration.lvp']")
	private WebElement configurationLink;
	public WebElement configurationLink(){
		return configurationLink;
	}
	
	//Configuration-->Account Link
	@FindBy(css="a[href='/recovery/accountConfiguration.lvp']")
	private WebElement accountConfigurationLink;
	public WebElement accountConfigurationLink(){
		return accountConfigurationLink;
	}
	//***********************************************************************//
	//Configuration-->Account-->Users Tab
	@FindBy(css="a[href='accountConfiguration.lvp']")
	private WebElement acctConfigUsersTab;
	public WebElement acctConfigUsersTab(){
		return acctConfigUsersTab;
	}
	
	//Configuration-->Account-->User Groups Tab
	@FindBy(css="a[href='userGroupConfiguration.lvp']")
	private WebElement acctConfigUserGroupsTab;
	public WebElement acctConfigUserGroupsTab(){
		return acctConfigUserGroupsTab;
	}
	
	//Configuration-->Account-->Audit Groups Tab
	@FindBy(css="a[href='auditGroupSetUp.lvp']")
	private WebElement acctConfigAuditGroupsTab;
	public WebElement acctConfigAuditGroupsTab(){
		return acctConfigAuditGroupsTab;
	}
	
	//Configuration-->Account-->Notification Tab
	@FindBy(css="a[href='batchInvoiceNotification.lvp']")
	private WebElement acctConfigNotificationTab;
	public WebElement acctConfigNotificationTab(){
		return acctConfigNotificationTab;
	}
	
	//Add New Button
	@FindBy(id="addNew")
	private WebElement addNewBtn;
	
	//Popup Frame

	@FindBy(css="iframe[src*='UserConfiguration.lvp']")
	private WebElement userConfigFrame;

	//Add New User/Edit User Popup
	
	@FindBy(id="userName")
	private WebElement userNameTxtBox;
	
	@FindBy(id="login")
	private WebElement loginTxtBox;
	
	@FindBy(css="#allAudits a")
	private WebElement auditsDDL;
	
	@FindBy(id="emailId")
	private WebElement emailIdTxtBox;
	
	@FindBy(css="input[name='save']")
	private WebElement saveBtn;
	
	
	@FindBy(css="iframe[src*='UserConfiguration.lvp'] + div input")
	private WebElement auditDDTxtBox;
	
	@FindBy(css="iframe[src*='UserConfiguration.lvp'] + div li")
	private List<WebElement> auditDDLOptions;
	
	@FindBy(xpath="//span[text()='Ok']")
	private WebElement confirmPopupOkBtn;
	
	//Search Acct User
	
	@FindBy(css="#searchSelectoption_chosen>a")
	private WebElement acctUserSearchDDL;
	
	@FindBy(css="#searchSelectoption_chosen li")
	private List<WebElement> acctUserSearchTypeDDLOptions;
	
	@FindBy(id="searchtxt")
	private WebElement acctUserSearchTxtBox;
	
	@FindBy(id="search-users")
	private WebElement acctUserSearchBtn;
	
	//Verifying search results
	

	@FindBy(css="#user-list td:nth-child(2)")
	private List<WebElement> acctUserNameList;
	public List<WebElement> acctUserNameList(){
		return acctUserNameList;
	}
	
	@FindBy(css="#user-list td:nth-child(3)")
	private List<WebElement> acctUserLoginList;
	public List<WebElement> acctUserLoginList(){
		return acctUserLoginList;
	}
	
	@FindBy(css="#user-list td:nth-child(5)")
	private List<WebElement> acctUserAuditList;
	public List<WebElement> acctUserAuditList(){
		return acctUserAuditList;
	}	

	@FindBy(css="#user-list td:nth-child(12)")
	private List<WebElement> acctUserEmailIdList;
	public List<WebElement> acctUserEmailIdList(){
		return acctUserEmailIdList;
	}	
	
	//User Edit Links
	@FindBy(css="a[href*='editUserConfiguration.lvp']")
	private List<WebElement> acctUserEditLinks;
	public List<WebElement> acctUserEditLinks(){
		return acctUserEditLinks;	
	}
	
	
	//***********************************************************************//
	//Configuration-->Account-->User Group Tab
	
	//Popup Frame
		
	@FindBy(css="iframe[src*='UserGroupConfiguration.lvp']")
	private WebElement acctUserGroupConfigFrame;
	
	@FindBy(css="input[name='mainPages']")
	private List<WebElement> acctUserGroupsMainPagesCheckBoxes;
	
	@FindBy(css="input[name='active']")
	private WebElement acctUserGroupsActiveStatusCheckBox;

	@FindBy(css="#userSetup td:nth-child(1)")
	private List<WebElement> acctUserGroupNameList;
	public List<WebElement> acctUserGroupNameList(){
		return acctUserGroupNameList;
	}
	
	@FindBy(css="#userSetup td:nth-child(2)")
	private List<WebElement> acctUserGroupActiveStatusList;
	public List<WebElement> acctUserGroupActiveStatusList(){
		return acctUserGroupActiveStatusList;	
	}
	
	@FindBy(css="a[href*='editUserGroupConfiguration.lvp']")
	private List<WebElement> acctUserGroupEditLinks;
	public List<WebElement> acctUserGroupEditLinks(){
		return acctUserGroupEditLinks;	
	}
	
	//***********************************************************************//
	//Configuration-->Account-->Audit Group Tab
	
	//Popup Frame
	
		@FindBy(css="iframe[src*='AuditGroupSetUp.lvp']")
		private WebElement acctauditGroupConfigFrame;
		
		@FindBy(id="groupName")
		private WebElement groupNameTxtBox;
		
		@FindBy(css="#auditGroupList td:nth-child(1)")
		private List<WebElement> auditListChkBoxes;
		public List<WebElement> auditListChkBoxes(){
			return auditListChkBoxes;
		}
		@FindBy(css="#auditGroupList td:nth-child(2)")
		private List<WebElement> auditList;
		public List<WebElement> auditList(){
			return auditList;
		}
		
		@FindBy(css="#auditGroupList a[class*='mark-default']")
		private List<WebElement> markAsDefaultLinkList;
		public List<WebElement> markAsDefaultLinkList(){
			return markAsDefaultLinkList;
		}
		
		@FindBy(css="#auditGroupSetup td:nth-child(1)")
		private List<WebElement> acctAuditGroupNameList;
		public List<WebElement> acctAuditGroupNameList(){
			return acctAuditGroupNameList;
		}
		
		@FindBy(css="#auditGroupSetup td:nth-child(2)")
		private List<WebElement> acctAuditGroupDefaultAuditList;
		public List<WebElement> acctAuditGroupDefaultAuditList(){
			return acctAuditGroupDefaultAuditList;	
		}
		
		@FindBy(css="a[href*='editAuditGroupSetUp.lvp']")
		private List<WebElement> acctAuditGroupEditLinks;
		public List<WebElement> acctAuditGroupEditLinks(){
			return acctAuditGroupEditLinks;	
		}
		
		@FindBy(css="#auditGroupList th input")
		private WebElement acctSelectAllAuditsChkBox;
		public WebElement acctSelectAllAuditsChkBox(){
			return acctSelectAllAuditsChkBox;	
		}
	//***********************************************************************//
	//Configuration-->Account-->Notification Tab
	
	//Popup Frame
		@FindBy(css="iframe[src*='BatchInvoiceNotification.lvp']")
		private WebElement acctNotificationConfigFrame;

		@FindBy(css="#users a")
		private WebElement usersDDL;
		
		@FindBy(id="batch")
		private WebElement batchNotificationCheckBox;
		
		@FindBy(id="invoice")
		private WebElement invoiceNotificationCheckBox;
		
		@FindBy(css="userId_chosen")
		private WebElement userSelectTxtBox;
		
		@FindBy(css="iframe[src*='BatchInvoiceNotification.lvp'] + div input")
		private WebElement auditSelectTxtBox;
		
		
	// Notification Contents Table
		@FindBy(css="#batchInvoice_noti td:nth-child(1)")
		private List<WebElement> auditNameList;
		public List<WebElement> auditNameList(){
			return auditNameList;
		}
		
		@FindBy(css="#batchInvoice_noti td:nth-child(2)")
		private List<WebElement> userNameList;
		public List<WebElement> userNameList(){
			return userNameList;
		}
		
		@FindBy(css="#batchInvoice_noti td:nth-child(4)")
		private List<WebElement> batchNotificationList;
		public List<WebElement> batchNotificationList(){
			return batchNotificationList;
		}
		
		@FindBy(css="#batchInvoice_noti td:nth-child(5)")
		private List<WebElement> invoiceNotificationList;
		public List<WebElement> invoiceNotificationList(){
			return invoiceNotificationList;
		}
		
		@FindBy(css="a[href*='editBatchInvoiceNotification.lvp']")
		private List<WebElement> editNotificationLinkList;
		public List<WebElement> editNotificationLinkList(){
			return editNotificationLinkList;
		}
		
	//Methods
			
	//***********************************************************************//
	//Configuration-->Account-->Users Tab
	//To add new Acct user 
	public void configAcctAddNewUser(LinkedHashMap<String,String> dataMap){
		
		lavanteUtils.fluentwait(addNewBtn);
		lavanteUtils.click(addNewBtn);
		fillAcctUser(dataMap);
		formAcctUser(dataMap);
		
	}

	//Fill add/edit user details
	public void fillAcctUser(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(userConfigFrame);
		
		if(dataMap.containsKey("UserName")){
			String data=dataMap.get("UserName");
			lavanteUtils.typeString(data,userNameTxtBox);
		}
		
		if(dataMap.containsKey("Login")){
			String data=dataMap.get("Login");
			lavanteUtils.typeString(data,loginTxtBox);
		}
		
		if(dataMap.containsKey("AuditName")){
			String data=dataMap.get("AuditName");
			lavanteUtils.fluentwait(auditsDDL);
			lavanteUtils.click(auditsDDL);
			
			//Switch to Back Frame
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(auditDDTxtBox);
			lavanteUtils.typeString(data,auditDDTxtBox);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectContainFrmDpdn(data);
			
			//Switch to Popup Frame
			lavanteUtils.switchtoFrame(userConfigFrame);
		}
		
		if(dataMap.containsKey("EmailId")){
			
			String data=dataMap.get("EmailId");
			lavanteUtils.fluentwait(emailIdTxtBox);
			lavanteUtils.typeString(data,emailIdTxtBox);
		}
		
		
		
	}

	//Save acct user
	public void formAcctUser(LinkedHashMap<String, String> dataMap) {
		
		if(dataMap.containsKey("SaveUser")){
			lavanteUtils.fluentwait(saveBtn);
			lavanteUtils.click(saveBtn);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(confirmPopupOkBtn);
			lavanteUtils.click(confirmPopupOkBtn);
			lavanteUtils.fluentwait(acctConfigUsersTab);
		}
		
	}
	
	//Searching User
	public void searchUser(LinkedHashMap<String, String> dataMap){
		
		
		String data="";

		if(dataMap.containsKey("SearchType")){
			data=dataMap.get("SearchType");
			lavanteUtils.fluentwait(acctUserSearchDDL);
			lavanteUtils.waitForTime(10000);
			//lavanteUtils.click(acctUserSearchDDL);
			acctUserSearchDDL.click();
			lavanteUtils.fluentwait(acctUserSearchTypeDDLOptions.get(0));
			lavanteUtils.selectFrmDpdn(data);
		}
		if(dataMap.containsKey("SearchValue")){
			
			data=dataMap.get("SearchValue");
			lavanteUtils.fluentwait(acctUserSearchTxtBox);
			if(data.length()>0){
				lavanteUtils.typeString(data, acctUserSearchTxtBox);
			}
		}
		lavanteUtils.fluentwait(acctUserSearchBtn);
		lavanteUtils.click(acctUserSearchBtn);
		lavanteUtils.fluentwait(acctUserSearchBtn);
		//lavanteUtils.refreshPage();
		
		lavanteUtils.waitForTime(10000);
	}
	
	
	//***********************************************************************//
	//Configuration-->Account-->User Group Tab

	//Add New User Group
	public void configAcctAddNewUserGroup(LinkedHashMap<String,String> dataMap){
		
		lavanteUtils.fluentwait(addNewBtn);
		lavanteUtils.click(addNewBtn);
		fillAcctUserGroup(dataMap);
		formAcctUserGroup(dataMap);
		
	}

	public void fillAcctUserGroup(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(acctUserGroupConfigFrame);
		
		if(dataMap.containsKey("UserGroupName")){
			String data=dataMap.get("UserGroupName");
			lavanteUtils.typeString(data,userNameTxtBox);
		}
		
		if(dataMap.containsKey("Dashboard")){
			String data = dataMap.get("Dashboard");
			lavanteUtils.fluentwait(acctUserGroupsMainPagesCheckBoxes.get(0));
			lavanteUtils.selectChkBox(acctUserGroupsMainPagesCheckBoxes.get(0),data);
		}
		
		if(dataMap.containsKey("Active")){
			String data = dataMap.get("Active");
			lavanteUtils.fluentwait(acctUserGroupsActiveStatusCheckBox);
			lavanteUtils.selectChkBox(acctUserGroupsActiveStatusCheckBox,data);
		}
		
	}
	
	public void formAcctUserGroup(LinkedHashMap<String, String> dataMap) {
		
		if(dataMap.containsKey("SaveUser")){
			lavanteUtils.fluentwait(saveBtn);
			lavanteUtils.click(saveBtn);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(confirmPopupOkBtn);
			lavanteUtils.click(confirmPopupOkBtn);
			lavanteUtils.fluentwait(acctConfigUserGroupsTab);
		}
		
		
	}

	//***********************************************************************//
	//Configuration-->Account-->Audit Group Tab
	
	//Add New User Group
	public void configAcctAddNewAuditGroup(LinkedHashMap<String,String> dataMap){
		
		lavanteUtils.fluentwait(addNewBtn);
		lavanteUtils.click(addNewBtn);
		fillAcctAuditGroup(dataMap);
		formAcctAuditGroup(dataMap);
		
	}


	public void fillAcctAuditGroup(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(acctauditGroupConfigFrame);

		//
		if(dataMap.containsKey("AuditGroupName")){
			String data=dataMap.get("AuditGroupName");
			lavanteUtils.typeString(data,groupNameTxtBox);
		}
		
		lavanteUtils.selectChkBox(acctSelectAllAuditsChkBox, "Yes");
		lavanteUtils.UnselectChkBox(acctSelectAllAuditsChkBox, "Unselect");
		
		//To select Audits from the list
		if(dataMap.containsKey("AuditName")){
			String data=dataMap.get("AuditName");
			if(data.contains("#")){
				String[] audits = data.split("#");
				for(int i=0;i<audits.length;i++){
					String audit = audits[i];
					for(int j=0;j<auditList.size();j++){
						if(audit.equalsIgnoreCase(auditList.get(j).getText().trim())){
							lavanteUtils.fluentwait(auditList.get(j));
							lavanteUtils.selectChkBox(auditListChkBoxes.get(j), "Yes");
							break;
						}
					}
				}
			}
			else{
				for(int i=0;i<auditList.size();i++){
					if(data.equalsIgnoreCase(auditList.get(i).getText().trim())){
						lavanteUtils.fluentwait(auditList.get(i));
						lavanteUtils.click(auditListChkBoxes.get(i));
						break;
					}
				}
			}
		}
		
		//To select Default Audit
		if(dataMap.containsKey("DefaultAudit")){
			String data=dataMap.get("DefaultAudit");
			for(int i=0;i<auditList.size();i++){
				if(data.equalsIgnoreCase(auditList.get(i).getText().trim())){
					lavanteUtils.waitForTime(3000);
					lavanteUtils.fluentwait(markAsDefaultLinkList.get(i));
					lavanteUtils.click(markAsDefaultLinkList.get(i));
					break;
				}
			}
		}

	}

	public void formAcctAuditGroup(LinkedHashMap<String, String> dataMap) {
			
		if(dataMap.containsKey("SaveUser")){
			lavanteUtils.fluentwait(saveBtn);
			lavanteUtils.click(saveBtn);
			lavanteUtils.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(confirmPopupOkBtn);
			lavanteUtils.click(confirmPopupOkBtn);
			lavanteUtils.fluentwait(acctConfigUserGroupsTab);
		}
	
	}


	//***********************************************************************//
	//Configuration-->Account-->Notification Tab

	//Add New Notification
		public void configAcctAddNewNotification(LinkedHashMap<String,String> dataMap){
			
			lavanteUtils.fluentwait(addNewBtn);
			lavanteUtils.click(addNewBtn);
			fillAcctNotification(dataMap);
			formAcctNotification(dataMap);
			
		}

		public void fillAcctNotification(LinkedHashMap<String, String> dataMap) {
			lavanteUtils.switchtoFrame(acctNotificationConfigFrame);
			
			if (dataMap.containsKey("UserName")){
				String data=dataMap.get("UserName");
				lavanteUtils.fluentwait(usersDDL);
				lavanteUtils.click(usersDDL);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(userSelectTxtBox);
				lavanteUtils.typeString(data, userSelectTxtBox);
				lavanteUtils.waitForTime(2000);
				lavanteUtils.selectFrmDpdn(data);
				lavanteUtils.switchtoFrame(acctNotificationConfigFrame);
			}
			
			if(dataMap.containsKey("AuditName")){
				String data=dataMap.get("AuditName");
				lavanteUtils.fluentwait(auditsDDL);
				lavanteUtils.click(auditsDDL);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(auditSelectTxtBox);
				lavanteUtils.typeString(data, auditSelectTxtBox);
				lavanteUtils.waitForTime(2000);
				lavanteUtils.selectFrmDpdn(data);
				lavanteUtils.switchtoFrame(acctNotificationConfigFrame);
			}
			

			if(dataMap.containsKey("BatchNotification")){
				lavanteUtils.fluentwait(batchNotificationCheckBox);
				lavanteUtils.click(batchNotificationCheckBox);
			}
			
			if(dataMap.containsKey("InvoiceNotification")){
				lavanteUtils.fluentwait(invoiceNotificationCheckBox);
				lavanteUtils.click(invoiceNotificationCheckBox);
			}
		}

		public void formAcctNotification(LinkedHashMap<String, String> dataMap) {
			
			if(dataMap.containsKey("SaveUser")){
				lavanteUtils.fluentwait(saveBtn);
				lavanteUtils.click(saveBtn);
				lavanteUtils.waitForTime(5000);
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(confirmPopupOkBtn);
				lavanteUtils.click(confirmPopupOkBtn);
				lavanteUtils.fluentwait(acctConfigNotificationTab);
			}
			
		}
	
		//Searching Notification
		public void searchNotification(LinkedHashMap<String, String> dataMap){
			
			
			String data="";

			if(dataMap.containsKey("SearchType")){
				data=dataMap.get("SearchType");
				lavanteUtils.fluentwait(acctUserSearchDDL);
				lavanteUtils.waitForTime(10000);
				//lavanteUtils.click(acctUserSearchDDL);
				acctUserSearchDDL.click();
				lavanteUtils.fluentwait(acctUserSearchTypeDDLOptions.get(0));
				lavanteUtils.selectFrmDpdn(data);
			}
			if(dataMap.containsKey("SearchValue")){
				
				data=dataMap.get("SearchValue");
				lavanteUtils.fluentwait(acctUserSearchTxtBox);
				if(data.length()>0){
					lavanteUtils.typeString(data, acctUserSearchTxtBox);
				}
			}
			lavanteUtils.fluentwait(acctUserSearchBtn);
			lavanteUtils.click(acctUserSearchBtn);
			lavanteUtils.fluentwait(acctUserSearchBtn);
			//lavanteUtils.refreshPage();
			
			lavanteUtils.waitForTime(10000);
		}
		

		
	
}
