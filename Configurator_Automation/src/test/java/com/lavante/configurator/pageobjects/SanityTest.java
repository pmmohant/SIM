package com.lavante.configurator.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.configurator.Common.Util.LavanteUtils;


public class SanityTest {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	public SanityTest(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	

	@FindBy(css="a[href='#general']")
	private WebElement general_Link;
	public WebElement general_Link(){
		return general_Link;
	}
	
	
	@FindBy(css="[id='Preferences']")
	private WebElement preference_Link;
	public WebElement preference_Link(){
		return preference_Link;
	}
	
	@FindBy(css="[href*='#feature-settings']")
	private WebElement featuresetting_Link;
	public WebElement featuresetting_Link(){
		return featuresetting_Link;
	}
	
	@FindBy(css="[href*='#outreach-template']")
	private WebElement outreachtemplate_Link;
	public WebElement outreachtemplate_Link(){
		return outreachtemplate_Link;
	}
	
	@FindBy(css="[href*='#outreach']")
	private WebElement outreach_Outreachtemplate_Link;
	public WebElement outreach_Outreachtemplate_Link(){
		return outreach_Outreachtemplate_Link;
	}
	
	@FindBy(css="[href*='#role']")
	private WebElement role_Link;
	public WebElement role_Link(){
		return role_Link;
	}
	
	@FindBy(css="[href*='#user']")
	private WebElement user_Link;
	public WebElement user_Link(){
		return user_Link;
	}
	
	
	
	
	@FindBy(id = "feature-settings")
	private WebElement Menu_feature;
	public WebElement Menu_feature(){
		return Menu_feature;
	}
	
	
	@FindBy(css = "#role")
	private WebElement Menu_role;
	public WebElement Menu_role(){
		return Menu_role;
	}
	
	
	
	//Dashboard Page Locator
	
	//Configurator home page
	
	@FindBy(id="logo-application")
	private WebElement LavanteLogo;
	public WebElement LavanteLogo(){
		return LavanteLogo;
	}
			
	@FindBy(css="#NavBar span")
	private WebElement Lastlogin;
	public WebElement Lastlogin(){
	return Lastlogin;
	}
	
	@FindBy(css="[ng-click*='logout']")
	private WebElement Logout;
	public WebElement Logout(){
	return Logout;
	}
	
	
	/*
	@FindBy(css="[tableparams='tableParams'] th:nth-child(1) span")
	private WebElement Buyerpagination;
	public WebElement Buyerpagination(){
	return Buyerpagination;
	}
	*/
	
	@FindBy(css="[tableparams='tableParams'] th:nth-child(1) span")
	private WebElement Buyernametableheader;
	public WebElement Buyernametableheader(){
	return Buyernametableheader;
	}
	
	@FindBy(css="[tableparams='tableParams'] th:nth-child(2) span")
	private WebElement IRSidentifierheader;
	public WebElement IRSidentifierheader(){
	return IRSidentifierheader;
	}
	
	@FindBy(css="[tableparams='tableParams'] th:nth-child(3) span")
	private WebElement Logoheader;
	public WebElement Logoheader(){
	return Logoheader;
	}
	
	@FindBy(css="[tableparams='tableParams'] th:nth-child(4) span")
	private WebElement Actionheader;
	public WebElement Actionheader(){
	return Actionheader;
	}
	
	@FindBy(css="[tableparams='tableParams'] th:nth-child(1) input")
	private WebElement Filterbuyer;
	public WebElement Filterbuyer(){
	return Filterbuyer;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] th:nth-child(2) input")
	private WebElement Filterirsidentifier;
	public WebElement Filterirsidentifier(){
	return Filterirsidentifier;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(4) button")
	private WebElement Editbuyerbutton;
	public WebElement Editbuyerbutton(){
	return Editbuyerbutton;
	}
	
	@FindBy(id="copyright_year")
	private WebElement footer_Copyright;
	public WebElement footer_Copyright(){
		return footer_Copyright;
	}
	
	//Dashboard Locator Ended
	
	//Summary Page Objects Started
	
	@FindBy(css="[href*='#/dashboard']")
	private WebElement summary_Back_To_Buyers_Link;
	public WebElement summary_Back_To_Buyers_Link(){
		return summary_Back_To_Buyers_Link;
	}
	
	@FindBy(css="[class*='title']")
	private WebElement summary_Supplier_Name_Header;
	public WebElement summary_Supplier_Name_Header(){
		return summary_Supplier_Name_Header;
	}
	
	@FindBy(css="a[class*='title'] span")
	private WebElement summary_Progress_Label;
	public WebElement summary_Progress_Label(){
		return summary_Progress_Label;
	}
	
	@FindBy(id="prevbutton")
	private WebElement previous_Button;
	public WebElement previous_Button(){
		return previous_Button;
	}
	
	@FindBy(id="nextbutton")
	private WebElement next_Button;
	public WebElement next_Button(){
		return next_Button;
	}
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(1)")
	private WebElement summary_Sections_Table_Header;
	public WebElement summary_Sections_Table_Header(){
		return summary_Sections_Table_Header;
	}
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(2)")
	private WebElement summary_Actions_Table_Header;
	public WebElement summary_Actions_Table_Header(){
		return summary_Actions_Table_Header;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(1) td:nth-child(1) span")
	private WebElement summary_General_Label;
	public WebElement summary_General_Label(){
		return summary_General_Label;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(1) td:nth-child(2) button")
	private WebElement summary_General_GoToSection_Button;
	public WebElement summary_General_GoToSection_Button(){
		return summary_General_GoToSection_Button;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(2) td:nth-child(1) span")
	private WebElement summary_Preference_Label;
	public WebElement summary_Preference_Label(){
		return summary_Preference_Label;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(2) td:nth-child(2) button")
	private WebElement summary_Preference_GoToSection_Button;
	public WebElement summary_Preference_GoToSection_Button(){
		return summary_Preference_GoToSection_Button;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(3) td:nth-child(1) span")
	private WebElement summary_FeatureSettings_Label;
	public WebElement summary_FeatureSettings_Label(){
		return summary_FeatureSettings_Label;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(3) td:nth-child(2) button")
	private WebElement summary_FeatureSettings_GoToSection_Button;
	public WebElement summary_FeatureSettings_GoToSection_Button(){
		return summary_FeatureSettings_GoToSection_Button;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(4) td:nth-child(1) span")
	private WebElement summary_Outreach_Label;
	public WebElement summary_Outreach_Label(){
		return summary_Outreach_Label;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(4) td:nth-child(2) button")
	private WebElement summary_Outreach_GoToSection_Button;
	public WebElement summary_Outreach_GoToSection_Button(){
		return summary_Outreach_GoToSection_Button;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(5) td:nth-child(1) span")
	private WebElement summary_Role_Label;
	public WebElement summary_Role_Label(){
		return summary_Role_Label;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(5) td:nth-child(2) button")
	private WebElement summary_Role_GoToSection_Button;
	public WebElement summary_Role_GoToSection_Button(){
		return summary_Role_GoToSection_Button;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(6) td:nth-child(1) span")
	private WebElement summary_User_Label;
	public WebElement summary_User_Label(){
		return summary_User_Label;
	}
	
	@FindBy(css="[tableparams='tableParams'] tr:nth-child(6) td:nth-child(2) button")
	private WebElement summary_User_GoToSection_Button;
	public WebElement summary_User_GoToSection_Button(){
		return summary_User_GoToSection_Button;
	}
	
	//Summary Ended
	
	//Genearal
	

	
    @FindBy(xpath="//*[contains(@class,'prgx-shadow-pane-top')]//button/../..")
	
	private WebElement general_GeneralInformation_Label;
	public WebElement general_GeneralInformation_Label(){
		return general_GeneralInformation_Label;
	}
	
	@FindBy(css="[ng-click*='clear()']")
	private WebElement general_Clear_Buttton;
	public WebElement general_Clear_Buttton(){
		return general_Clear_Buttton;
	}
	
	@FindBy(css="[ng-click*='submit()']")
	private WebElement general_Save_Buttton;
	public WebElement general_Save_Buttton(){
		return general_Clear_Buttton;
	}
	
	@FindBy(css="[uid*='txtName'] label")
	private WebElement general_buyerName_Label;
	public WebElement general_buyerName_Label(){
		return general_buyerName_Label;
	}
	
	@FindBy(css="#txtName")
	private WebElement general_buyerName_Text;
	public WebElement general_buyerName_Text(){
		return general_buyerName_Text;
	}
	
	
	@FindBy(css="[uid*='txtLetterSignature'] label")
	private WebElement general_Buyeroutreach_Letter_Signature_Label;
	public WebElement general_Buyeroutreach_Letter_Signature_Label(){
		return general_Buyeroutreach_Letter_Signature_Label;
	}
	
	@FindBy(css="#txtLetterSignature")
	private WebElement general_LetterSignature_Text;
	public WebElement general_LetterSignature_Text(){
		return general_LetterSignature_Text;
	}
	

	@FindBy(css="[uid*='txtLogoUrl'] label")
	private WebElement general_LogoUrl_Label;
	public WebElement general_LogoUrl_Label(){
		return general_LogoUrl_Label;
	}
	
	@FindBy(css="#txtLogoUrl")
	private WebElement general_LogoUrl_Text;
	public WebElement general_LogoUrl_Text(){
		return general_LogoUrl_Text;
	}
	
	@FindBy(css="[uid*='txIRSIdentifier'] label")
	private WebElement general_Irsidentifier_Label;
	public WebElement general_Irsidentifier_Label(){
		return general_Irsidentifier_Label;
	}
	
	@FindBy(css="#txIRSIdentifier")
	private WebElement general_Irsidentifier_Text;
	public WebElement general_Irsidentifier_Text(){
		return general_Irsidentifier_Text;
	}
	
	
	
	//Genearal Ended
	
	//Prefereance Started
	

	@FindBy(css="[id='file-upload-template']")
	private WebElement preference_FileUploadtemplate_link;
	public WebElement preference_FileUploadtemplate_link(){
		return preference_FileUploadtemplate_link;
	}
	
	@FindBy(css="[href*='#division']")
	private WebElement preference_division_link;
	public WebElement preference_division_link(){
		return preference_division_link;
	}
	
	@FindBy(css="[href*='#erp']")
	private WebElement preference_erpsystem_link;
	public WebElement preference_erpsystem_link(){
		return preference_erpsystem_link;
	}
	
	@FindBy(css="[href*='#eft-currency']")
	private WebElement preference_eftcurrency_link;
	public WebElement preference_eftcurrency_link(){
		return preference_eftcurrency_link;
	}
	
	
	@FindBy(css="[href*='#location']")
	private WebElement preference_locationtype_link;
	public WebElement preference_locationtype_link(){
		return preference_locationtype_link;
	}
	
	@FindBy(css="[href*='#payment']")
	private WebElement preference_paymentsetting_link;
	public WebElement preference_paymentsetting_link(){
		return preference_paymentsetting_link;
	}
	
	@FindBy(css="[href*='#notification']")
	private WebElement preference_notificationtype_link;
	public WebElement preference_notificationtype_link(){
		return preference_notificationtype_link;
	}
	
	@FindBy(css="[href*='#supplier-group']")
	private WebElement preference_suppliergroup_link;
	public WebElement preference_suppliergroup_link(){
		return preference_suppliergroup_link;
	}
	
	@FindBy(css="#vendor-type")
	private WebElement preference_vendortype_link;
	public WebElement preference_vendortype_link(){
		return preference_vendortype_link;
	}
	
	

	
	@FindBy(css="li:nth-child(3) a[ng-click*='page']")
	private WebElement file_Upload_Template_Pageno;
	public WebElement file_Upload_Template_Pageno(){
	return file_Upload_Template_Pageno;
	}
	
	@FindBy(id="reset")
	private WebElement file_Upload_Template_Reset_Btn;
	public WebElement file_Upload_Template_Reset_Btn(){
	return file_Upload_Template_Reset_Btn;
	}
	
	@FindBy(id="save")
	private WebElement file_Upload_Template_Save_Btn;
	public WebElement file_Upload_Template_Save_Btn(){
	return file_Upload_Template_Reset_Btn;
	}
	
	@FindBy(css="[tableparams='tableParams'] td:nth-child(1)")
	private List<WebElement> file_Upload_Template_FileTemplate_Chkbox;
	public List<WebElement> file_Upload_Template_FileTemplate_Chkbox(){
	return  file_Upload_Template_FileTemplate_Chkbox;
	}

	@FindBy(css="[tableparams='tableParams'] td:nth-child(2)")
	private List<WebElement> file_Upload_Template_FileTemplate;
	public List<WebElement> file_Upload_Template_FileTemplate(){
	return file_Upload_Template_FileTemplate;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(1) [type*='checkbox']")
	private WebElement file_Upload_Template_Chkbox_Header;
	public WebElement file_Upload_Template_Chkbox_Header(){
	return file_Upload_Template_Chkbox_Header;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(2) span")
	private WebElement file_Upload_Template_Filename_Header;
	public WebElement file_Upload_Template_Filename_Header(){
	return file_Upload_Template_Chkbox_Header;
	}
	
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(1) td:nth-child(2) span")
	private WebElement file_Upload_Template_Supplier_Template;
	public WebElement file_Upload_Template_Supplier_Template(){
	return file_Upload_Template_Supplier_Template;
	}
		
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(2) td:nth-child(1) input")
	private WebElement file_Upload_Template_Spend_Template_Chkbox;
	public WebElement file_Upload_Template_Spend_Template_Chkbox(){
	return file_Upload_Template_Spend_Template_Chkbox;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(1) td:nth-child(2) span")
	private WebElement file_Upload_Template_Spend_Template;
	public WebElement file_Upload_Template_Spend_Template(){
	return file_Upload_Template_Spend_Template;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(3) td:nth-child(1) input")
	private WebElement file_Upload_Template_Invoice_Template_Chkbox;
	public WebElement file_Upload_Template_Invoice_Template_Chkbox(){
	return file_Upload_Template_Invoice_Template_Chkbox;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(3) td:nth-child(2) span")
	private WebElement file_Upload_Template_Invoice_Template;
	public WebElement file_Upload_Template_Invoice_Template(){
	return file_Upload_Template_Invoice_Template;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(4) td:nth-child(1) input")
	private WebElement file_Upload_Template_BulkDeactivate_Template_Chkbox;
	public WebElement file_Upload_Template_BulkDeactivate_Template_Chkbox(){
	return file_Upload_Template_BulkDeactivate_Template_Chkbox;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(4) td:nth-child(2) span")
	private WebElement file_Upload_Template_BulkDeactivate_Template;
	public WebElement file_Upload_Template_BulkDeactivate_Template(){
	return file_Upload_Template_BulkDeactivate_Template;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(5) td:nth-child(1) input")
	private WebElement file_Upload_Template_UserCreation_Template_Chkbox;
	public WebElement file_Upload_Template_UserCreation_Template_Chkbox(){
	return file_Upload_Template_UserCreation_Template_Chkbox;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(5) td:nth-child(2) span")
	private WebElement file_Upload_Template_UserCreation_Template;
	public WebElement file_Upload_Template_UserCreation_Template(){
	return file_Upload_Template_UserCreation_Template;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(6) td:nth-child(1) input")
	private WebElement file_Upload_Template_Address_Template_Chkbox;
	public WebElement file_Upload_Template_Address_Template_Chkbox(){
	return file_Upload_Template_Address_Template_Chkbox;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(6) td:nth-child(2) span")
	private WebElement file_Upload_Template_Address_Template;
	public WebElement file_Upload_Template_Address_Template(){
	return file_Upload_Template_Address_Template;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(7) td:nth-child(1) input")
	private WebElement file_Upload_Template_Contact_Template_Chkbox;
	public WebElement file_Upload_Template_Contact_Template_Chkbox(){
	return file_Upload_Template_Contact_Template_Chkbox;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(7) td:nth-child(2) span")
	private WebElement file_Upload_Template_Contact_Template;
	public WebElement file_Upload_Template_Contact_Template(){
	return file_Upload_Template_Contact_Template;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(8) td:nth-child(1) input")
	private WebElement file_Upload_Template_Division_Template_Chkbox;
	public WebElement file_Upload_Template_Division_Template_Chkbox(){
	return file_Upload_Template_Division_Template_Chkbox;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(8) td:nth-child(2) span")
	private WebElement file_Upload_Template_Division_Template;
	public WebElement file_Upload_Template_Division_Template(){
	return file_Upload_Template_Division_Template;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(9) td:nth-child(1) input")
	private WebElement file_Upload_Template_DivisionMapping_Template_Chkbox;
	public WebElement file_Upload_Template_DivisionMapping_Template_Chkbox(){
	return file_Upload_Template_DivisionMapping_Template_Chkbox;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(9) td:nth-child(2) span")
	private WebElement file_Upload_Template_DivisionMapping_Template;
	public WebElement file_Upload_Template_DivisionMapping_Template(){
	return file_Upload_Template_DivisionMapping_Template;
	}
	
	

	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(10) td:nth-child(1) input")
	private WebElement file_Upload_Template_PaymentCenter_Template_Chkbox;
	public WebElement file_Upload_Template_PaymentCenter_Template_Chkbox(){
	return file_Upload_Template_PaymentCenter_Template_Chkbox;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(10) td:nth-child(2) span")
	private WebElement file_Upload_Template_PaymentCenter_Template;
	public WebElement file_Upload_Template_PaymentCenter_Template(){
	return file_Upload_Template_PaymentCenter_Template;
	}
	
	
	
	@FindBy(css="[tableparams='tableParams'] li:nth-child(3) a")
	private WebElement file_Upload_Template_2_Pagination;
	public WebElement file_Upload_Template_2_Pagination(){
	return file_Upload_Template_2_Pagination;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(1) td:nth-child(1) input")
	private WebElement file_Upload_Template_PaymentTerm_Template_Chkbox;
	public WebElement file_Upload_Template_PaymentTerm_Template_Chkbox(){
	return file_Upload_Template_PaymentTerm_Template_Chkbox;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(1) td:nth-child(2) span")
	private WebElement file_Upload_Template_PaymentTerm_Template;
	public WebElement file_Upload_Template_PaymentTerm_Template(){
	return file_Upload_Template_PaymentTerm_Template;
	}
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(2) td:nth-child(1) input")
	private WebElement file_Upload_Template_EFT_Template_Chkbox;
	public WebElement file_Upload_Template_EFT_Template_Chkbox(){
	return file_Upload_Template_EFT_Template_Chkbox;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] tbody tr:nth-child(2) td:nth-child(2) span")
	private WebElement file_Upload_Template_EFT_Template;
	public WebElement file_Upload_Template_EFT_Template(){
	return file_Upload_Template_EFT_Template;
	}
	
	


	
	//Notification Type Page Objects
	
	
	
	
	
	
	@FindBy(css="ul[class*='pagination'] li a")
	private List<WebElement>  preference_Pageno;
	public List<WebElement> preference_Pageno(){
	return preference_Pageno;
	}
	
	@FindBy(css="li:nth-child(4) a[ng-click*='page']")
	private WebElement preference_NotificationType_Pageno3;
	public WebElement preference_NotificationType_Pageno3(){
	return preference_NotificationType_Pageno3;
	}
	
	@FindBy(css="li:nth-child(5) a[ng-click*='page']")
	private WebElement preference_NotificationType_Pageno4;
	public WebElement preference_NotificationType_Pageno4(){
	return preference_NotificationType_Pageno4;
	}
	
	@FindBy(css="li:nth-child(6) a[ng-click*='page']")
	private WebElement preference_NotificationType_Pageno5;
	public WebElement preference_NotificationType_Pageno5(){
	return preference_NotificationType_Pageno5;
	}
	
	@FindBy(css="li:nth-child(7) a[ng-click*='page']")
	private WebElement preference_NotificationType_Pageno6;
	public WebElement preference_NotificationType_Pageno6(){
	return preference_NotificationType_Pageno6;
	}
	
	@FindBy(css="li:nth-child(8) a[ng-click*='page']")
	private WebElement preference_NotificationType_Pageno7;
	public WebElement preference_NotificationType_Pageno7(){
	return preference_NotificationType_Pageno7;
	}
	
	@FindBy(css="li:nth-child(9) a[ng-click*='page']")
	private WebElement preference_NotificationType_Pageno8;
	public WebElement preference_NotificationType_Pageno8(){
	return preference_NotificationType_Pageno8;
	}
	
	/*
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(1) [type*='checkbox']")
	private WebElement file_Upload_Template_Chkbox_Header;
	public WebElement file_Upload_Template_Chkbox_Header(){
	return file_Upload_Template_Chkbox_Header;
	}
	
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(2) span")
	private WebElement file_Upload_Template_Filename_Header;
	public WebElement file_Upload_Template_Filename_Header(){
	return file_Upload_Template_Chkbox_Header;
	}
	*/
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(3) span")
	private WebElement preference_Language_Header;
	public WebElement preference_Language_Header(){
	return preference_Language_Header;
	}
	
	@FindBy(css="[tableparams='tableParams'] thead th:nth-child(3) span")
	private WebElement preference_NotificatinExpDays_Header;
	public WebElement preference_NotificatinExpDays_Header(){
	return preference_NotificatinExpDays_Header;
	}
	

	
	//Preference Ended
	
	
	
	

	// Role page locator  started
	
	@FindBy(xpath = "//div/span[text() = 'Role Name']")
	private WebElement role_HeaderName;
	public WebElement role_HeaderName(){
		return role_HeaderName;
	}
	
	
	@FindBy(xpath="//div/span[text() = 'Description']")
	private WebElement role_HeaderDescription;
	public WebElement role_HeaderDescription(){
		return role_HeaderDescription;
	}
	
	@FindBy(xpath="//div/span[text() = 'Created Date']")
	private WebElement role_HeaderCreatedDate;
	public WebElement role_HeaderCreatedDate(){
		return role_HeaderCreatedDate;
	}
	
	@FindBy(xpath="//div/span[text() = 'Created By']")
	private WebElement role_HeaderCreatedBy;
	public WebElement role_HeaderCreatedBy(){
		return role_HeaderCreatedBy;
	}
	
	@FindBy(xpath="//div/span[text() = 'Status']")
	private WebElement role_HeaderStatus;
	public WebElement role_HeaderStatus(){
		return role_HeaderStatus;
	}
	
	@FindBy(xpath="//div/span[text() = 'Actions']")
	private WebElement role_HeaderActions;
	public WebElement role_HeaderActions(){
		return role_HeaderActions;
	}
	
	@FindBy(css = "[ng-click*='deleteRoles']")
	private WebElement role_DeleteRoles;
	public WebElement role_DeleteRoles(){
		return role_DeleteRoles;
	}
	

	@FindBy(css= "[ng-click*='dialogAddRoles']")
	private WebElement role_AddRoles;
	public WebElement role_AddRoles(){
		return role_AddRoles;
	}
	

	@FindBy(css="[href*= 'dashboard']")
	private WebElement role_PageBacktoBuyers;
	public WebElement role_PageBacktoBuyers(){
		return role_PageBacktoBuyers;
	}
	@FindBy(css="[ng-click*='prev']")
	private WebElement role_PreviousPage;
	public WebElement role_PreviousPage(){
		return role_PreviousPage;
	}
	@FindBy(css="[ng-click*='next']")
	private WebElement role_NextPage;
	public WebElement role_NextPage(){
		return role_NextPage;
	}

	@FindBy(css="[ng-model*='checkboxdata.checked']")
	private WebElement role_SelectAllCustomer;
	public WebElement role_SelectAllCustomer(){
		return role_SelectAllCustomer;
	}
	
	
	@FindBy(css="[name*='userRoleName']")
	private WebElement role_FilterUserRoleName;
	public WebElement role_FilterUserRoleName(){
		return role_FilterUserRoleName;
	}
	//Role page locator ended
	

	// Feature setting page locator started 
	
	
	@FindBy(css="[href*= '#Integration']")
	private WebElement featuresettings_Intergration;
	public WebElement featuresettings_Intergration(){
		return featuresettings_Intergration;
	}
	
	@FindBy(css="[href*= '#Invoice']")
	private WebElement featuresettings_Invoice;
	public WebElement featuresettings_Invoice(){
		return featuresettings_Invoice;
	}
	
	@FindBy(css="[href*= '#Supplier']")
	private WebElement featuresettings_Supplier;
	public WebElement featuresettings_Supplier(){
		return featuresettings_Supplier;
	}
	
	@FindBy(css="[href*= '#Workflow']")
	private WebElement featuresettings_Workflow;
	public WebElement featuresettings_Workflow(){
		return featuresettings_Workflow;
	}
	@FindBy(css="[href*= '#AlertsandNotification']")
	private WebElement featuresettings_AlertsandNotification;
	public WebElement featuresettings_AlertsandNotification(){
		return featuresettings_AlertsandNotification;
	}
	
	@FindBy(css="[href*= '#RegulatoryCompliance']")
	private WebElement featuresettings_RegulatoryCompliance;
	public WebElement featuresettings_RegulatoryCompliance(){
		return featuresettings_RegulatoryCompliance;
	}
	@FindBy(css="[href*= '#ScoreCard']")
	private WebElement featuresettings_ScoreCard;
	public WebElement featuresettings_ScoreCard(){
		return featuresettings_ScoreCard;
	}
	
	@FindBy(css="[href*= '#ContractManagement']")
	private WebElement featuresettings_ContractManagement;
	public WebElement featuresettings_ContractManagement(){
		return featuresettings_ContractManagement;
	}
	
	@FindBy(css="[href*= '#MultipleERPIntegration']")
	private WebElement featuresettings_MultipleERPIntegration;
	public WebElement featuresettings_MultipleERPIntegration(){
		return featuresettings_MultipleERPIntegration;
	}
	
	@FindBy(css="[ng-click*='reset']")
	private WebElement featuresettings_IntegrationRest;
	public WebElement featuresettings_IntegrationRest(){
		return featuresettings_IntegrationRest;
	}
	
	@FindBy(css="[ng-click*='save']")
	private WebElement featuresettings_IntegrationSave;
	public WebElement featuresettings_IntegrationSave(){
		return featuresettings_IntegrationSave;
	}
	
	@FindBy(id="IS_ERPLOCATIONID_ENABLED")
	private WebElement featuresettings_ValidationStatus;
	public WebElement featuresettings_ValidationStatus(){
		return featuresettings_ValidationStatus;
	}
	
	@FindBy(id="DISABLE_ERP_INTEGRATION")
	private WebElement featuresettings_IsERPintegrationdisabled;
	public WebElement featuresettings_IsERPintegrationdisabled(){
		return featuresettings_IsERPintegrationdisabled;
	}
	
	@FindBy(id="DISABLE_ERP_SEARCHRESULTS")
	private WebElement featuresettings_IsSupplierERPIDnotshowninsearchresults;
	public WebElement featuresettings_IsSupplierERPIDnotshowninsearchresults(){
		return featuresettings_IsSupplierERPIDnotshowninsearchresults;
	}

	@FindBy(id="ENABLE_MULTI_ERP")
	private WebElement featuresettings_IsMultiERPSystemsenabled;
	public WebElement featuresettings_IsMultiERPSystemsenabled(){
		return featuresettings_IsMultiERPSystemsenabled;
	}
	@FindBy(id="POLARIS_INTEGRATION_GRANT_FILE_LOCATION")
	private WebElement featuresettings_PolarisGrantFileLocation;
	public WebElement featuresettings_PolarisGrantFileLocation(){
		return featuresettings_PolarisGrantFileLocation;
	}
	@FindBy(id="POLARIS_INTEGRATION_OUTBOUND_FILE_LOCATION")
	private WebElement featuresettings_PolarisOutboundFileLocation;
	public WebElement featuresettings_PolarisOutboundFileLocation(){
		return featuresettings_PolarisOutboundFileLocation;
	}
	@FindBy(id="POLARIS_INTEGRATION_EMAIL_NOTIFICATION_USER_GROUP")
	private WebElement featuresettings_UserGroupforPolarisemailnotification;
	public WebElement featuresettings_UserGroupforPolarisemailnotification(){
		return featuresettings_UserGroupforPolarisemailnotification;
	}
	
	@FindBy(id="POLARIS_INTEGRATION_OUTREACH_CONTACT_ID")
	private WebElement featuresettings_ContactIdforpolarisintegrationoutreach;
	public WebElement featuresettings_ContactIdforpolarisintegrationoutreach(){
		return featuresettings_ContactIdforpolarisintegrationoutreach;
	}
	
	@FindBy(id="POLARIS_INTEGRATION_OUTBOUND_FILE_NAME_FORMAT")
	private WebElement featuresettings_PolarisIntegrationOutboundFileNameformat;
	public WebElement featuresettings_PolarisIntegrationOutboundFileNameformat(){
		return featuresettings_PolarisIntegrationOutboundFileNameformat;
	}
	@FindBy(id="POLARIS_INTEGRATION_CUSTOM_FIELD_MAPPING_JSON")
	private WebElement featuresettings_CustomfieldmappingforPolarisIntegration;
	public WebElement featuresettings_CustomfieldmappingforPolarisIntegration(){
		return featuresettings_CustomfieldmappingforPolarisIntegration;
	}
	@FindBy(id="IS_EXPERIAN_INTEGRATION_ENABLED")
	private WebElement featuresettings_IsExperianintegrationEnabled;
	public WebElement featuresettings_IsExperianintegrationEnabled(){
		return featuresettings_IsExperianintegrationEnabled;
	}
	@FindBy(id="SUPPLIER_INVOICE_DELIVERABLE_ENABLE")
	private WebElement featuresettings_EnableInvoiceDeliverable;
	public WebElement featuresettings_EnableInvoiceDeliverable(){
		return featuresettings_EnableInvoiceDeliverable;
	}
	
	@FindBy(id="IS_UPLOAD_INVOICE_ENABLED")
	private WebElement featuresettings_IsUploadInvoiceButtonEnabled;
	public WebElement featuresettings_IsUploadInvoiceButtonEnabled(){
		return featuresettings_IsUploadInvoiceButtonEnabled;
	}
	
	@FindBy(id="ENABLE_INVOICE_BATCH_PAYMENT_MODULE")
	private WebElement featuresettings_EnabletheInvoiceBatchPaymentModule;
	public WebElement featuresettings_EnabletheInvoiceBatchPaymentModule(){
		return featuresettings_EnabletheInvoiceBatchPaymentModule;
	}
	@FindBy(id="AUTO_CREATE_INVOICE_FOR_DELIVERABLE")
	private WebElement featuresettings_Autocreateinvoicefordeliverable;
	public WebElement featuresettings_Autocreateinvoicefordeliverable(){
		return featuresettings_Autocreateinvoicefordeliverable;
	}
	
	@FindBy(id="AUTO_CREATE_INVOICE_FOR_DELIVERABLE_QUERY")
	private WebElement featuresettings_Autocreateinvoicequery;
	public WebElement featuresettings_Autocreateinvoicequery(){
		return featuresettings_Autocreateinvoicequery;
	}
	@FindBy(id="AUTO_CREATE_INVOICE_INVOICE_NUMBER_PREFIX")
	private WebElement featuresettings_Invoicenumberprefixforautocreatedinvoice;
	public WebElement featuresettings_Invoicenumberprefixforautocreatedinvoice(){
		return featuresettings_Invoicenumberprefixforautocreatedinvoice;
	}
	
	@FindBy(id="IS_INVOICE_UPLOAD_ENABLED")
	private WebElement featuresettings_Enableinvoiceupload;
	public WebElement featuresettings_Enableinvoiceupload(){
		return featuresettings_Enableinvoiceupload;
	}
	@FindBy(id="IS_INCLUDE_SPEND_FROM_INVOICE_ENABLED")
	private WebElement featuresettings_Includespendfrominvoice;
	public WebElement featuresettings_Includespendfrominvoice(){
		return featuresettings_Includespendfrominvoice;
	}
	
	@FindBy(id="IS_INVOICE_VIEW_FOR_SUPPLIER_ENABLED")
	private WebElement featuresettings_Enableinvoiceviewforsupplier;
	public WebElement featuresettings_Enableinvoiceviewforsupplier(){
		return featuresettings_Enableinvoiceviewforsupplier;
	}
	
	@FindBy(id="BATCH_INVOICE_ROLLBACK_ON_INVALID_DATE_STATUS")
	private WebElement featuresettings_BatchInvoiceRollbackStatus;
	public WebElement featuresettings_BatchInvoiceRollbackStatus(){
		return featuresettings_BatchInvoiceRollbackStatus;
	}
	@FindBy(id="BLOCK_MULTIPLE_CLIENT_NAME_INVOICE_BATCHING")
	private WebElement featuresettings_Blockmultipleclientnameinvoicebatching;
	public WebElement featuresettings_Blockmultipleclientnameinvoicebatching(){
		return featuresettings_Blockmultipleclientnameinvoicebatching;
	}
	
	@FindBy(id="IS_DELETE_W8_W9_DISABLED")
	private WebElement featuresettings_HideDeleteW8W9button;
	public WebElement featuresettings_HideDeleteW8W9button(){
		return featuresettings_HideDeleteW8W9button;
	}
	@FindBy(id="HIDE_INSURANCE_TABLE_AND_TEXTAREA_CORE_CERTIFICATIONS_TAB")
	private WebElement featuresettings_HideInsuranceTableOrJustification;
	public WebElement featuresettings_HideInsuranceTableOrJustification(){
		return featuresettings_HideInsuranceTableOrJustification;
	}
	@FindBy(id="PRESCREEN_FAILED_FOOTER_MSG_I18NKEY")
	private WebElement featuresettings_PrescreenFooterMessageFailure;
	public WebElement featuresettings_PrescreenFooterMessageFailure(){
		return featuresettings_PrescreenFooterMessageFailure;
	}
	
	@FindBy(id="PRESCREEN_FOOTER_MSG_I18NKEY")
	private WebElement featuresettings_PrescreenFooterMessageSuccessOrPending;
	public WebElement featuresettings_PrescreenFooterMessageSuccessOrPending(){
		return featuresettings_PrescreenFooterMessageSuccessOrPending;
	}
	@FindBy(id="IS_PREFERRED_PAYMENT_EFT")
	private WebElement featuresettings_IsPreferredPaymenttypeEFT;
	public WebElement featuresettings_IsPreferredPaymenttypeEFT(){
		return featuresettings_IsPreferredPaymenttypeEFT;
	}
	@FindBy(id="SUBSTITUTE_W9_ENABLED")
	private WebElement featuresettings_SubstituteW9;
	public WebElement featuresettings_SubstituteW9(){
		return featuresettings_SubstituteW9;
	}
	
	@FindBy(id="SUPPLIER_PROFILE_INCOMPLETE_MSG")
	private WebElement featuresettings_SupplierProfileIncompleteMessage;
	public WebElement featuresettings_SupplierProfileIncompleteMessage(){
		return featuresettings_SupplierProfileIncompleteMessage;
	}
	@FindBy(id="ENABLE_CREDIT_CARD_VENDOR_RECORD_ONLY")
	private WebElement featuresettings_EnabletheCreditCardVendorRecordOnly;
	public WebElement featuresettings_EnabletheCreditCardVendorRecordOnly(){
		return featuresettings_EnabletheCreditCardVendorRecordOnly;
	}
	@FindBy(id="IS_INVITE_ORGANIZATION_ENABLED")
	private WebElement featuresettings_IsInvitingOrganizationEnabled;
	public WebElement featuresettings_IsInvitingOrganizationEnabled(){
		return featuresettings_IsInvitingOrganizationEnabled;
	}
	@FindBy(id="CSV_FILE_SEPARATOR")
	private WebElement featuresettings_Providethecsvfileseparator;
	public WebElement featuresettings_Providethecsvfileseparator(){
		return featuresettings_Providethecsvfileseparator;
	}
	@FindBy(id="PAYMODEX_ENROLLMENT_LINK")
	private WebElement featuresettings_PaymodeXEnrollmentLink;
	public WebElement featuresettings_PaymodeXEnrollmentLink(){
		return featuresettings_PaymodeXEnrollmentLink;
	}
	@FindBy(id="PAYMODEX_ENROLLMENT_NUMBER")
	private WebElement featuresettings_PaymodeXEnrollmentNumber;
	public WebElement featuresettings_PaymodeXEnrollmentNumber(){
		return featuresettings_PaymodeXEnrollmentNumber;
	}
	@FindBy(id="CARDPAYMENT_EMAIL_NOTE")
	private WebElement featuresettings_CreditCardPaymentemailnote;
	public WebElement featuresettings_CreditCardPaymentemailnote(){
		return featuresettings_CreditCardPaymentemailnote;
	}
	@FindBy(id="PAYMENT_TERMS_NOTE_CREDIT_CARD")
	private WebElement featuresettings_Cardpaymenttermnote;
	public WebElement featuresettings_Cardpaymenttermnote(){
		return featuresettings_Cardpaymenttermnote;
	}
	@FindBy(id="PAYMENT_TERMS_NOTE_PAYMODE_X")
	private WebElement featuresettings_PaymodeXpaymenttermnote;
	public WebElement featuresettings_PaymodeXpaymenttermnote(){
		return featuresettings_PaymodeXpaymenttermnote;
	}
	@FindBy(id="DISABLE_SMALLBUSINESS_DIVERSITY_CHECK")
	private WebElement featuresettings_DisableSmallBusinessDiversityCheck;
	public WebElement featuresettings_DisableSmallBusinessDiversityCheck(){
		return featuresettings_DisableSmallBusinessDiversityCheck;
	}
	@FindBy(id="ENABLE_PAYMENT_CENTER_AND_DIVISION_BASED_PAYMENT")
	private WebElement featuresettings_EnablePaymentCenterDivisionbasedPayment;
	public WebElement featuresettings_EnablePaymentCenterDivisionbasedPayment(){
		return featuresettings_EnablePaymentCenterDivisionbasedPayment;
	}
	@FindBy(id="ENABLE_MULTISELECT_PAYMENT_TYPE_FOR_PAYMENT_CENTER")
	private WebElement featuresettings_EnableMultiSelectforPaymentCenterPayment;
	public WebElement featuresettings_EnableMultiSelectforPaymentCenterPayment(){
		return featuresettings_EnableMultiSelectforPaymentCenterPayment;
	}
	
	@FindBy(id="IS_SUPPLIER_GROUP_REQUIRED")
	private WebElement featuresettings_IsSupplierGroupRequired;
	public WebElement featuresettings_IsSupplierGroupRequired(){
		return featuresettings_IsSupplierGroupRequired;
	}
	@FindBy(id="IS_JUSTIFY_INVITATION_REQUIRED")
	private WebElement featuresettings_IsInviteJustificationRequired;
	public WebElement featuresettings_IsInviteJustificationRequired(){
		return featuresettings_IsInviteJustificationRequired;
	}
	@FindBy(id="IS_INVITE_NEW_SUPPLIER_POPUP_EMAIL_FAX_CUSTOMER_SPECIFIC_BEHAVIOR")
	private WebElement featuresettings_InviteSupplierEmailOrFaxCustomerSpecific;
	public WebElement featuresettings_InviteSupplierEmailOrFaxCustomerSpecific(){
		return featuresettings_InviteSupplierEmailOrFaxCustomerSpecific;
	}
	
	@FindBy(id="IS_INVITE_NEW_SUPPLIER_POPUP_EMAIL_REQUIRED")
	private WebElement featuresettings_InviteSupplierEmailRequired;
	public WebElement featuresettings_InviteSupplierEmailRequired(){
		return featuresettings_InviteSupplierEmailRequired;
	}
	@FindBy(id="IS_INVITE_NEW_SUPPLIER_POPUP_FAX_REQUIRED")
	private WebElement featuresettings_InviteSupplierFaxRequired;
	public WebElement featuresettings_InviteSupplierFaxRequired(){
		return featuresettings_InviteSupplierFaxRequired;
	}
	
	@FindBy(id="SUPPLIER_REGISTRATION_SUCCESS_MSG")
	private WebElement featuresettings_SupplierRegistrationSuccessMessage;
	public WebElement featuresettings_SupplierRegistrationSuccessMessage(){
		return featuresettings_SupplierRegistrationSuccessMessage;
	}
	
	@FindBy(id="IS_INVITE_CONFIRMATION_REQUIRED")
	private WebElement featuresettings_IsInviteConfirmationRequired;
	public WebElement featuresettings_IsInviteConfirmationRequired(){
		return featuresettings_IsInviteConfirmationRequired;
	}
	@FindBy(id="IS_TALENT_AGENT_REQUIRED")
	private WebElement featuresettings_IsTalentAgentRequired;
	public WebElement featuresettings_IsTalentAgentRequired(){
		return featuresettings_IsTalentAgentRequired;
	}
	@FindBy(id="IS_TAKECONTROL_HIDDEN")
	private WebElement featuresettings_HideTakeControlButton;
	public WebElement featuresettings_HideTakeControlButton(){
		return featuresettings_HideTakeControlButton;
	}
	@FindBy(id="IS_DEFAULT_SEARCHFILTER_CONFIGURED")
	private WebElement featuresettings_IsDefaultsuppliersearchfilterconfigured;
	public WebElement featuresettings_IsDefaultsuppliersearchfilterconfigured(){
		return featuresettings_IsDefaultsuppliersearchfilterconfigured;
	}
	
	@FindBy(id="INVITE_SUPPLIER_ALLOW_MULTIPLE_CONTACT")
	private WebElement featuresettings_Allowmultiplecontactsforinvite;
	public WebElement featuresettings_Allowmultiplecontactsforinvite(){
		return featuresettings_Allowmultiplecontactsforinvite;
	}
	@FindBy(id="ENABLE_EDIT_INVITE_POST_INVITE")
	private WebElement featuresettings_AllowEditinviteafterinvitehasbeensent;
	public WebElement featuresettings_AllowEditinviteafterinvitehasbeensent(){
		return featuresettings_AllowEditinviteafterinvitehasbeensent;
	}
	@FindBy(id="INVITE_PREFIX")
	private WebElement featuresettings_IsInvitePrefixConfigured;
	public WebElement featuresettings_IsInvitePrefixConfigured(){
		return featuresettings_IsInvitePrefixConfigured;
	}
	
	@FindBy(id="IS_EXTEND_INVITE_DISABLED")
	private WebElement featuresettings_DisableExtendInvite;
	public WebElement featuresettings_DisableExtendInvite(){
		return featuresettings_DisableExtendInvite;
	}
	@FindBy(id="ENABLE_TEMP_APPROVAL")
	private WebElement featuresettings_EnableTempApproval;
	public WebElement featuresettings_EnableTempApproval(){
		return featuresettings_EnableTempApproval;
	}
	@FindBy(id="TEMP_APPROVAL_RESET_DAYS")
	private WebElement featuresettings_TempApprovalResetDays;
	public WebElement featuresettings_TempApprovalResetDays(){
		return featuresettings_TempApprovalResetDays;
	}
	@FindBy(id="SHOW_ON_HOLD_BUTTON")
	private WebElement featuresettings_Showonholdbutton;
	public WebElement featuresettings_Showonholdbutton(){
		return featuresettings_Showonholdbutton;
	}
	@FindBy(id="PROFILEDATACHANGE_NOTIFYGROUP")
	private WebElement featuresettings_Groupstonotifysupplierprofiledatachange;
	public WebElement featuresettings_Groupstonotifysupplierprofiledatachange(){
		return featuresettings_Groupstonotifysupplierprofiledatachange;
	}
	@FindBy(id="TASK_REMINDER_FREQUENCY")
	private WebElement featuresettings_Taskreminderfrequency;
	public WebElement featuresettings_Taskreminderfrequency(){
		return featuresettings_Taskreminderfrequency;
	}
	
	@FindBy(id="DISABLE_VAT_VALIDATION")
	private WebElement featuresettings_DisableVATValidation;
	public WebElement featuresettings_DisableVATValidation(){
		return featuresettings_DisableVATValidation;
	}
	
	@FindBy(id="AUTO_PASS_LEGALID_VALIDATION")
	private WebElement featuresettings_AutoPassLegalIDValidation;
	public WebElement featuresettings_AutoPassLegalIDValidation(){
		return featuresettings_AutoPassLegalIDValidation;
	}
	
	@FindBy(id="EXCLUDE_VAT_VALIDATION_STATUS_FROM_PROFILE_COMPLETENESS_CHECK")
	private WebElement featuresettings_ProfileCompletenessExcludeVATValidationStatus;
	public WebElement featuresettings_ProfileCompletenessExcludeVATValidationStatus(){
		return featuresettings_ProfileCompletenessExcludeVATValidationStatus;
	}
	
	@FindBy(id="EXCLUDE_SWISS_VAT_VALIDATION_STATUS_FROM_PROFILE_COMPLETENESS_CHECK")
	private WebElement featuresettings_ProfileCompletenessExcludeSwissVATValidationStatus;
	public WebElement featuresettings_ProfileCompletenessExcludeSwissVATValidationStatus(){
		return featuresettings_ProfileCompletenessExcludeSwissVATValidationStatus;
	}
	
	@FindBy(id="DISABLE_SWISS_VAT_VALIDATION")
	private WebElement featuresettings_DisableVATorUIDValidation;
	public WebElement featuresettings_DisableVATorUIDValidation(){
		return featuresettings_DisableVATorUIDValidation;
	}
	@FindBy(id="IS_W8_ENABLED")
	private WebElement featuresettings_EnableW8;
	public WebElement featuresettings_EnableW8(){
		return featuresettings_EnableW8;
	}
	@FindBy(id="IS_W9_ENABLED")
	private WebElement featuresettings_EnableW9;
	public WebElement featuresettings_EnableW9(){
		return featuresettings_EnableW9;
	}
	@FindBy(id="IS_PRESCREENING_ENABLED")
	private WebElement featuresettings_Enableprescreening;
	public WebElement featuresettings_Enableprescreening(){
		return featuresettings_Enableprescreening;
	}
	@FindBy(id="IS_OIG_FEDERAL_LIST_ENABLED")
	private WebElement featuresettings_EnableOIGFederalList;
	public WebElement featuresettings_EnableOIGFederalList(){
		return featuresettings_EnableOIGFederalList;
	}
	
	@FindBy(id="IS_OIG_STATE_LIST_ENABLED")
	private WebElement featuresettings_EnableOIGStateList;
	public WebElement featuresettings_EnableOIGStateList(){
		return featuresettings_EnableOIGStateList;
	}
	
	@FindBy(id="IS_SAM_ENABLED")
	private WebElement featuresettings_EnableSAM;
	public WebElement featuresettings_EnableSAM(){
		return featuresettings_EnableSAM;
	}
	
	@FindBy(id="IS_LAVANTE_HEALTHSCORE_ENABLED")
	private WebElement featuresettings_IsHealthScoreEnabled;
	public WebElement featuresettings_IsHealthScoreEnabled(){
		return featuresettings_IsHealthScoreEnabled;
	}
	
	@FindBy(id="HEALTH_SCORE_SPEND_DURATION_IN_MONTH")
	private WebElement featuresettings_Healthscorespendfileduration;
	public WebElement featuresettings_Healthscorespendfileduration(){
		return featuresettings_Healthscorespendfileduration;
	}
	
	@FindBy(id="MSA_CLIENTNAME_UIFIELDID")
	private WebElement featuresettings_CustomUIFieldIdforMSANumber;
	public WebElement featuresettings_CustomUIFieldIdforMSANumber(){
		return featuresettings_CustomUIFieldIdforMSANumber;
	}
	
	@FindBy(id="SOW_CUSTOM_NUMBER_GENERATION_UIFIELDID")
	private WebElement featuresettings_CustomUIFieldIdforSOWNumber;
	public WebElement featuresettings_CustomUIFieldIdforSOWNumber(){
		return featuresettings_CustomUIFieldIdforSOWNumber;
	}
	
	// Feature setting page locator ended 
	
	
	
	
	//Preferences page locator start 
	
	
	
	@FindBy(css = "a[href*='#file-upload-template']") // click on preference menu
	private WebElement Menu_preferences;
	public WebElement Menu_preferences(){
		return Menu_preferences;
	}
	
	@FindBy(id="division") // click on preference division menu
	private WebElement Menu_preferencesDivision;
	public WebElement Menu_preferencesDivision(){
		return Menu_preferencesDivision;
	}
	
	@FindBy(name="select-all ng-pristine ng-untouched ng-valid ng-scope ng-empty") // click on preference select all divisions
	private WebElement preferences_divisionselectAll;
	public WebElement preferences_divisionselectAll(){
		return preferences_divisionselectAll;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[2]/div/span[text()= 'Division']") // click on preference division header
	private WebElement preferences_divisionHeader;
	public WebElement preferences_divisionHeader(){
		return preferences_divisionHeader;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[3]/div/span[text() = 'Actions']") // click on preference action
	private WebElement preferences_divisionAction;
	public WebElement preferences_divisionAction(){
		return preferences_divisionAction;
	}
	
	@FindBy(css = "[ng-click* ='dialogAddDivision()']") // click on preference to add a division
	private WebElement preferences_addaDivision;
	public WebElement preferences_addaDivision(){
		return preferences_addaDivision;
	}
	
	@FindBy(css = "[ng-click*='deleteDivision()']") // click on preference to add a division
	private WebElement preferences_deleteDivision;
	public WebElement preferences_deleteDivision(){
		return preferences_deleteDivision;
	}
	
	@FindBy(css ="[ng-model*='params.filter()'") // click on preference place holder division name
	private WebElement preferences_divisionPlaceholderName;
	public WebElement preferences_divisionPlaceholderName(){
		return preferences_divisionPlaceholderName;
	}
	
	//Preference eft currency 
	
	@FindBy(id = "eft-currency") // click on preference place holder division name
	private WebElement Menu_eftCurrency;
	public WebElement Menu_eftCurrency(){
		return Menu_eftCurrency;
	}
	
	@FindBy(name = "select-all ng-pristine ng-untouched ng-valid ng-scope ng-empty") // click on preference select all eft currency 
	private WebElement preferences_selectallEftcurrency;
	public WebElement preferences_selectallEftcurrency(){
		return preferences_selectallEftcurrency;
	}
	
	@FindBy(xpath= "//table/thead/tr[1]/th[2]/div/span[text() ='Currency Type']") // click on preference eft currency type
	private WebElement preferences_eftCurrencyType;
	public WebElement preferences_eftCurrencyType(){
		return preferences_eftCurrencyType;
	}
	
	@FindBy(xpath= "//table/thead/tr[1]/th[3]/div/span[text()='Currency']") // click on preference eft currency 
	private WebElement preferences_eftCurrency;
	public WebElement preferences_eftCurrency(){
		return preferences_eftCurrency;
	}
	
	@FindBy(css= "[ng-click*='dialogAddEftCurrency(alldata)']") // click on preference add eft currency 
	private WebElement preferences_addEftCurrency;
	public WebElement preferences_addEftCurrency(){
		return preferences_addEftCurrency;
	}
	
	@FindBy(css= "[ng-click*='deleteEFT()']") // click on preference delete eft currency 
	private WebElement preferences_deleteEftCurrency;
	public WebElement preferences_deleteEftCurrency(){
		return preferences_deleteEftCurrency;
	}
	
	// Preference ERP System 
	

	@FindBy(id = "erp") // click on preference erp system menu
	private WebElement Menu_erpSystem;
	public WebElement Menu_erpSystem(){
		return Menu_erpSystem;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[1]/div/input") // click on preference All erp system 
	private WebElement preferences_selectAllERP;
	public WebElement preferences_selectAllERP(){
		return preferences_selectAllERP;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[2]/div/span[text() = 'ERP System Name']") // click on preference erp system name
	private WebElement preferences_erpSystemName;
	public WebElement preferences_erpSystemName(){
		return preferences_erpSystemName;
	}
	
	// Preference location type
	
	@FindBy(id = "location") // click on preference location type menu
	private WebElement Menu_locationType;
	public WebElement Menu_locationType(){
		return Menu_locationType;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[1]/div/input") // click on preference location type menu
	private WebElement preferences_selectAllLocation;
	public WebElement preferences_selectAllLocation(){
		return preferences_selectAllLocation;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[2]/div/span[text()='Location Type']") // click on preference location type 
	private WebElement preferences_locationType;
	public WebElement preferences_locationType(){
		return preferences_locationType;
	}
	
	@FindBy(xpath = "//table/thead/tr[1]/th[3]/div/span[text()='Required']") // click on preference location required
	private WebElement preferences_locationRequired;
	public WebElement preferences_locationRequired(){
		return preferences_locationRequired;
	}
	
	// End of preference locator page
	
	//user Page Locators Started
	
	@FindBy(id="btn-delete")
	private WebElement user_deletebttn;
	public WebElement user_deletebttn(){
		return user_deletebttn;
	}
	@FindBy(id="btn-add")
	private WebElement user_addbttn;
	public WebElement user_addbttn(){
		return user_addbttn;
	}
	@FindBy(css="th:nth-child(2) span")
	private WebElement user_headername;
	public WebElement user_headername(){
		return user_headername;
	}
	@FindBy(css="th:nth-child(3) span")
	private WebElement user_headeruser;
	public WebElement user_headeruser(){
		return user_headeruser;
	}
	@FindBy(css="th:nth-child(4) span")
	private WebElement user_headeractive;
	public WebElement user_headeractive(){
		return user_headeractive;
	}
	
	@FindBy(css="th:nth-child(5) span")
	private WebElement user_headeraccountcreated;
	public WebElement user_headeraccountcreated(){
		return user_headeraccountcreated;
	}
	
	@FindBy(css="th:nth-child(6) span")
	private WebElement user_headeremail;
	public WebElement user_headeremail(){
		return user_headeremail;
	}
	@FindBy(css="th:nth-child(7) span")
	private WebElement user_headerphone;
	public WebElement user_headerphone(){
		return user_headerphone;
	}
	@FindBy(css="th:nth-child(8) span")
	private WebElement user_headerfax;
	public WebElement user_headerfax(){
		return user_headerfax;
	}
	@FindBy(css="th:nth-child(9) span")
	private WebElement user_headeractions;
	public WebElement user_headeractions(){
		return user_headeractions;
	}
	@FindBy(css="[name='filter-contactName']")
	private WebElement user_username;
	public WebElement user_username(){
		return user_username;
	}
	
	
	
	//user Page Locators Ended
	
	
	//Outreach template page locators started
	
	@FindBy(css="[ng-click*='del']")
	private WebElement deleteoutreachbttn;
	public WebElement deleteoutreachbttn(){
		return deleteoutreachbttn;
	}
	
	
	@FindBy(css="[ng-click*='dialog']")
	private WebElement addoutreachbttn;
	public WebElement addoutreachbttn(){
		return addoutreachbttn;
	}
	
	@FindBy(css="th:nth-child(2) span")
	private WebElement headergroupname;
	public WebElement headergroupname(){
		return headergroupname;
	}
	
	@FindBy(css="th:nth-child(3) span")
	private WebElement headerlanguage;
	public WebElement headerlanguage(){
		return headerlanguage;
	}
	@FindBy(css="th:nth-child(4) span")
	private WebElement headeroutreachtype;
	public WebElement headeroutreachtype(){
	return headeroutreachtype;
}
	
	@FindBy(css="th:nth-child(5) span")
	private WebElement headertemplate;
	public WebElement headertemplate(){
	return headertemplate;
}
	
	@FindBy(css="th:nth-child(6) span")
	private WebElement headerpreview;
	public WebElement headerpreview(){
	return headerpreview;
}
	
	@FindBy(css="th:nth-child(7) span")
	private WebElement headercreatedby;
	public WebElement headercreatedby(){
	return headercreatedby;
}
	
	@FindBy(css="th:nth-child(8) span")
	private WebElement headercreatedon;
	public WebElement headercreatedon(){
	return headercreatedon;
}
	@FindBy(css="th:nth-child(9) span")
	private WebElement headeraction;
	public WebElement headeraction(){
	return headeraction;
}
	

	//Outreach template page locators ended
	
	
	//outreach setup page locators started
	
	
	@FindBy(css="[ng-click*='de']")
	private WebElement outset_deletebttn;
	public WebElement outset_deletebttn(){
	return outset_deletebttn;
}
	
	@FindBy(css="[ng-click*='dia']")
	private WebElement outset_addbttn;
	public WebElement  outset_addbttn(){
	return  outset_addbttn;
}
	
	@FindBy(css="th:nth-child(2) span")
	private WebElement headeroutreachseq;
	public WebElement  headeroutreachseq(){
	return  headeroutreachseq;
}
	
	@FindBy(css="th:nth-child(3) span")
	private WebElement headerouttype;
	public WebElement  headerouttype(){
	return  headerouttype;
}
	@FindBy(css="th:nth-child(4) span")
	private WebElement headerwaitdays;
	public WebElement  headerwaitdays(){
	return  headerwaitdays;
}
	@FindBy(css="th:nth-child(5) span")
	private WebElement headercreaby;
	public WebElement  headercreaby(){
	return  headercreaby;
}
	@FindBy(css="th:nth-child(6) span")
	private WebElement headercreaon;
	public WebElement  headercreaon(){
	return  headercreaon;
}
	@FindBy(css="th:nth-child(7) span")
	private WebElement headeractions;
	public WebElement  headeractions(){
	return  headeractions;
}
	
	//outreach setup page locators ended
	
	//Vendor Type Page objects started
	
	@FindBy(css="[ng-click*='delete']")
	private WebElement vendordelbttn;
	public WebElement  vendordelbttn(){
	return  vendordelbttn;
}
	
	@FindBy(css="[ng-click*='dialogAdd']")
	private WebElement vendoraddbttn;
	public WebElement  vendoraddbttn(){
	return  vendoraddbttn;
}
	
	@FindBy(css="th:nth-child(2) span")
	private WebElement vendortypeheader;
	public WebElement  vendortypeheader(){
	return  vendortypeheader;
}
	
	@FindBy(css="th:nth-child(3) span")
	private WebElement vendoractionsheader;
	public WebElement  vendoractionsheader(){
	return  vendoractionsheader;
}
	//Vendor Type Page objects Ended
	
	//supplier Group page locators started
	
	@FindBy(css="[ng-click*='delete']")
	private WebElement suppgroupdelbttn;
	public WebElement  suppgroupdelbttn(){
	return  suppgroupdelbttn;
}

	@FindBy(css="[ng-click*='dialog']")
	private WebElement suppgroupaddbttn;
	public WebElement  suppgroupaddbttn(){
	return  suppgroupaddbttn;
}
	@FindBy(css="th:nth-child(2) span")
	private WebElement suppgroupheadtext;
	public WebElement  suppgroupheadtext(){
	return  suppgroupheadtext;
}
	
	@FindBy(css="th:nth-child(3) span")
	private WebElement suppgroupactionheadtext;
	public WebElement  suppgroupactionheadtext(){
	return  suppgroupactionheadtext;
}

//supplier Group page locators ended
	
	//Payment Setting Page locators Started
	
	@FindBy(css="[ng-click*='del']")
	private WebElement paysettdelbttn;
	public WebElement  paysettdelbttn(){
	return  paysettdelbttn;
}
	@FindBy(css="[ng-click*='dial']")
	private WebElement paysettaddbttn;
	public WebElement  paysettaddbttn(){
	return  paysettaddbttn;
}
	
	@FindBy(css="th:nth-child(2) span")
	private WebElement paysetpayytypehead;
	public WebElement  paysetpayytypehead(){
	return  paysetpayytypehead;
}
	@FindBy(css="th:nth-child(3) span")
	private WebElement paysetpayytermhead;
	public WebElement  paysetpayytermhead(){
	return  paysetpayytermhead;
}
	@FindBy(css="th:nth-child(4) span")
	private WebElement paysetactionhead;
	public WebElement  paysetactionhead(){
	return  paysetactionhead;
}
	
	
}
