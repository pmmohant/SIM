package com.lavante.configurator.TestScripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.configurator.Common.Util.LavanteUtils;
import com.lavante.configurator.pageobjects.pageInitiator;

/**
 * @author Piramanayagam
 *
 */
public class ConfigSanity extends pageInitiator {
	String customerID="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();

		waitForTime(3000);
		String customerName=homePage.SelectBuyer("ANY");
		String query="select CustomerID from Customer where Name='"+customerName+"'";
		customerID=fetchDBdata(query);

		waitForTime(3000);
	}

	/**
	 * @author chaitra.s
	 * @throws Exception
	 */
	@Test(priority=1)
	public void SummaryPageTest() throws Exception{
		
		Reporter.log("Summary Page Test Started:"+currenttime(),true);
		
		SoftAssert softAssert =new SoftAssert();
		fluentwait(sanityTest.summary_Back_To_Buyers_Link());
		
		boolean flag=isElementDisplayed(sanityTest.summary_Back_To_Buyers_Link());
		Reporter.log("Summary Page: Back to Buyers link - Verification:"+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Back to Buyers link not Displayed");
		
		fluentwait(sanityTest.summary_Supplier_Name_Header()); //Waiting for the table to populate else script will fail
		flag=isElementDisplayed(sanityTest.summary_Supplier_Name_Header());
		Reporter.log("Summary Page: Supplier Name Header - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Supplier Name Header not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Progress_Label());
		Reporter.log("Summary Page: Progress Label - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Progress Label not Displayed");
		
		fluentwait(sanityTest.summary_Sections_Table_Header());
		flag=isElementDisplayed(sanityTest.summary_Sections_Table_Header());
		Reporter.log("Summary Page: Sections Table Header - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections Table Header not Displayed");
		
		fluentwait(sanityTest.summary_Actions_Table_Header());
		flag=isElementDisplayed(sanityTest.summary_Actions_Table_Header());
		Reporter.log("Summary Page: Actions Table Header - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions Table Header not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_General_Label());
		Reporter.log("Summary Page: Sections -> General Label  - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections -> General Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_General_GoToSection_Button());
		Reporter.log("Summary Page:  Actions -> General Go to Section Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions -> General Go to Section Button not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Preference_Label());
		Reporter.log("Summary Page: Sections -> Preference Label  - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections -> Preference Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Preference_GoToSection_Button());
		Reporter.log("Summary Page:  Actions -> Preference Go to Section Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions -> Preference Go to Section Button not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_FeatureSettings_Label());
		Reporter.log("Summary Page: Sections -> Feature Settings Label  - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections -> Feature Settings Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_FeatureSettings_GoToSection_Button());
		Reporter.log("Summary Page:  Actions -> Feature Settings Go to Section Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions -> Feature Settings Go to Section Button not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Outreach_Label());
		Reporter.log("Summary Page: Sections -> Outreach Label  - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections -> Outreach Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Outreach_GoToSection_Button());
		Reporter.log("Summary Page:  Actions -> Outreach Go to Section Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions -> Outreach Go to Section Button not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Role_Label());
		Reporter.log("Summary Page: Sections -> Role Label  - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections -> Role Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_Role_GoToSection_Button());
		Reporter.log("Summary Page:  Actions -> Role Go to Section Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions -> Role Go to Section Button not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_User_Label());
		Reporter.log("Summary Page: Sections -> User Label  - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Sections -> User Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.summary_User_GoToSection_Button());
		Reporter.log("Summary Page:  Actions -> User Go to Section Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Summary Page: Actions -> User Go to Section Button not Displayed");

		softAssert.assertAll();
		Reporter.log("Summary Page Test Ended:"+currenttime());
		
		
}
	
	/**
	 * @author chaitra.s
	 * @throws Exception
	 */
	@Test(priority=2)
	public void GeneralPageTest() throws Exception{
		
		Reporter.log("General Page Test Started:"+currenttime());
		
		fluentwait(sanityTest.general_Link());
		click(sanityTest.general_Link());

		fluentwait(sanityTest.general_GeneralInformation_Label());
		SoftAssert softAssert= new SoftAssert();
		
		boolean flag=isElementDisplayed(sanityTest.general_GeneralInformation_Label());
		
		String actual=sanityTest.general_GeneralInformation_Label().getText();
		String exp="GENERAL INFORMATION";
		Reporter.log("General Page: General Information Label - Verification: "+flag,true);
		System.out.println(actual);
		System.out.println(exp);
		softAssert.assertTrue(actual.contains(exp),"General Page: General Information Label not Displayed");
		
		flag=isElementDisplayed(sanityTest.general_Clear_Buttton());
		Reporter.log("General Page: Clear Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"General Page: Clear Button not Displayed");
		
		flag=isElementDisplayed(sanityTest.general_Save_Buttton());
		Reporter.log("General Page: Save Button - Verification: "+flag,true);
		softAssert.assertTrue(flag,"General Page: Save Button Not Displayed");
		
		flag=isElementDisplayed(sanityTest.general_buyerName_Label());
		actual=sanityTest.general_buyerName_Label().getText();
		exp="Buyer Name";
		Reporter.log("General Page: Buyer Name Label - Verification:  "+flag,true);
		softAssert.assertEquals(actual,exp,"General Page: Buyer Name Label Not Displayed");
		

		flag=isElementDisplayed(sanityTest.general_buyerName_Text());
		Reporter.log("General Page: Buyer Name Text Box - Verification: "+flag,true);
		softAssert.assertTrue(flag,"General Page: Buyer Name Text Box Not Displayed");
		
		flag=isElementDisplayed(sanityTest.general_Buyeroutreach_Letter_Signature_Label());
		actual=sanityTest.general_Buyeroutreach_Letter_Signature_Label().getText();
		exp="Buyer Outreach Letter Signature";
		Reporter.log("General Page: Letter Signature Label - Verification:  "+flag,true);
		softAssert.assertEquals(actual,exp,"General Page: Buyer Letter Signature Not Displayed");
		
		flag=isElementDisplayed(sanityTest.general_LetterSignature_Text());
		Reporter.log("General Page: Letter Signature Text Box - Verification: "+flag,true);
		softAssert.assertTrue(flag,"General Page: Letter Signature Text Box - Displayed");
		
		flag=isElementDisplayed(sanityTest.general_LogoUrl_Label());
		actual=sanityTest.general_LogoUrl_Label().getText();
		exp="Logo Url";
		Reporter.log("General Page: Logo Url Label - Verification: "+flag,true);
		Assert.assertEquals(actual, exp, "General Page: Logo URL Not Displayed");
		//softAssert.assertTrue(flag,"General Page: Logo Url Label Not Displayed");
			
		flag=isElementDisplayed(sanityTest.general_Irsidentifier_Label());
		actual=sanityTest.general_Irsidentifier_Label().getText();
		exp="IRS Identifier";
		Reporter.log("General Page: IRS Identifier Label - Verification: "+ flag,true);
		softAssert.assertEquals(actual,exp,"General Page: IRS Identifier Label Not Displayed");
		
		flag=isElementDisplayed(sanityTest.general_Irsidentifier_Text());
		Reporter.log("General Page: IRS Identifier Text Box - Verification: "+flag,true);
		softAssert.assertTrue(flag,"General Page: IRS Identifier Text Box Not Displayed");
		
		softAssert.assertAll();
		Reporter.log("General Page Test Ended:"+currenttime());
		
}
	
	/**
	 * @author chaitra.s Priyanka Nandini
	 * @throws Exception
	 */
	@Test(priority=3)
	public void PreferencePageTest() throws Exception{
		
		Reporter.log("Preference Page Test Started:"+currenttime());
		
		fluentwait(sanityTest.preference_Link());
		click(sanityTest.preference_Link());
		fluentwait(sanityTest.LavanteLogo());
		SoftAssert softAssert= new SoftAssert();
		
		fluentwait(sanityTest.preference_FileUploadtemplate_link());
		click(sanityTest.preference_FileUploadtemplate_link());


		fluentwait(sanityTest.file_Upload_Template_Chkbox_Header());
		boolean flag=isElementDisplayed(sanityTest.file_Upload_Template_Chkbox_Header());
		Reporter.log("Preference Page: File Upload Template -> Check Box Header - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Preference Page: File Upload Template -> Check Box Header not Displayed");
		
		flag=isElementDisplayed(sanityTest.file_Upload_Template_Filename_Header());
		Reporter.log("Preference Page: File Upload Template -> Filename Header - Verification: "+flag,true);
		softAssert.assertTrue(flag,"Preference Page: File Upload Template -> Filename Header not Displayed");
		
		List<String> exp=new ArrayList<String>();
		exp.add("Supplier_Template.csv");
		exp.add("Spend_Template.csv");
		exp.add("Invoice_Template.csv");
		exp.add("BulkDeactivate_Template.csv");
		exp.add("User_Creation_Template.csv");
	    exp.add("Address_Template.csv");
	    exp.add("Contact_Template.csv");
	    exp.add("Division_Template.csv");
	    exp.add("DivisionMapping_Template.csv");
	    exp.add("PaymentCenter_Template.csv");
		
		softAssert.assertEquals(10,sanityTest.file_Upload_Template_FileTemplate().size());
		
		for(int i=0;i<sanityTest.file_Upload_Template_FileTemplate().size();i++){
			String actual=sanityTest.file_Upload_Template_FileTemplate().get(i).getText();
			softAssert.assertEquals(actual, exp.get(i));
			
						
			flag=isElementDisplayed(sanityTest.file_Upload_Template_FileTemplate_Chkbox().get(i));
			Reporter.log("Preference Page: File Upload Template -> " + actual+ " Page 1- Verification: "+flag,true);
			softAssert.assertTrue(flag,"Summary Page: Actions -> Page-1 Not Displayed");
		}
		
		click(sanityTest.file_Upload_Template_Pageno());

		fluentwait(sanityTest.file_Upload_Template_Chkbox_Header());
		
		 exp=new ArrayList<String>();
		 exp.add("PaymentTerm_Template.csv");
		 exp.add("EFT_Template.csv");
		 softAssert.assertEquals(2,sanityTest.file_Upload_Template_FileTemplate().size());
			
			for(int i=0;i<sanityTest.file_Upload_Template_FileTemplate().size();i++){
				String actual=sanityTest.file_Upload_Template_FileTemplate().get(i).getText();
				Assert.assertEquals(actual, exp.get(i));
				
				flag=isElementDisplayed(sanityTest.file_Upload_Template_FileTemplate_Chkbox().get(i));
				Reporter.log("Preference Page: File Upload Template -> " + actual + " Page-2 - Verification"+flag,true);
				Assert.assertTrue(flag,"Summary Page: Actions -> Page 2 Not Displayed");
			}
			
			//Notification Type Verification
			
			click(sanityTest.preference_notificationtype_link());


			fluentwait(sanityTest.file_Upload_Template_Chkbox_Header());
			 flag=isElementDisplayed(sanityTest.file_Upload_Template_Chkbox_Header());
			Reporter.log("Preference Page: Notification Type -> Check Box Header - Verification: "+flag,true);
			softAssert.assertTrue(flag,"Preference Page: Notification Type -> Check Box Header not Displayed");
			
			
			flag=isElementDisplayed(sanityTest.file_Upload_Template_Filename_Header());
			Reporter.log("Preference Page: Notification Type -> Notification Type Header - Verification: "+flag,true);
			softAssert.assertTrue(flag,"Preference Page: Notification Type -> Notification Type Header not Displayed");
			
			flag=isElementDisplayed(sanityTest.preference_Language_Header());
			Reporter.log("Preference Page: Notification Type -> Language Header - Verification: "+flag,true);
			softAssert.assertTrue(flag,"Preference Page: Notification Type -> Language Header not Displayed");
			
			flag=isElementDisplayed(sanityTest.preference_NotificatinExpDays_Header());
			Reporter.log("Preference Page: Notification Type -> Notification Expiry Days Header- Verification: "+flag,true);
			softAssert.assertTrue(flag,"Preference Page: Notification Type ->Notification Expiry Days Header not Displayed");
			
			String query = "select distinct(NotificationType) from NotificationType where  CustomerID="+customerID;
			List<String> getNotificationsType = fetchDBlistdata(query);
			
		    List<String> actual=new ArrayList<String>();
		    String language="English (United States)";
		    
		    for(int i=1; i<sanityTest.preference_Pageno().size()-1;i++)
		    {
		    	if(i!=1){
		    		click(sanityTest.preference_Pageno().get(i));
		    	}
		    	fluentwait(sanityTest.file_Upload_Template_Chkbox_Header());
		    	for(int j=0; j<sanityTest.file_Upload_Template_FileTemplate().size();j++){
		    		actual.add(sanityTest.file_Upload_Template_FileTemplate().get(j).getText());
		    	}
		    	
		    }
			
		    softAssert.assertEquals(getNotificationsType.size(),actual.size(),"Notification Count is not matched with the DB");
			
			Collections.sort(getNotificationsType);
			Collections.sort(actual);
			
			
			for(int i=0;i<actual.size();i++){
				Reporter.log("Notification Report,Expected:"+getNotificationsType.get(i)+",Actuals:"+actual.get(i),true);
				Assert.assertEquals(actual.get(i),getNotificationsType.get(i));
			}
			
		softAssert.assertAll();
		Reporter.log("Preference Page Test Ended:"+currenttime());
			
	}

	/**
	 * Preferences Sanity Test Verify all tab and all Element
	 * 
	 * @author Priyanka.Mohanty
	 * @throws Exception
	 */
	@Test(priority=5)
	public void PreferencesSanityTest2() throws Exception{

		Reporter.log("Test Started at:"+currenttime());

		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		
		fluentwait(sanityTest.Menu_preferences());
		click(sanityTest.Menu_preferences()); // click on Preferences menu
		
		fluentwait(sanityTest.Menu_preferencesDivision());
		click(sanityTest.Menu_preferencesDivision()); // click on Preferences division menu
		

		fluentwait(sanityTest.preferences_divisionHeader());// select all divisions
		
		
		String divisionheader=sanityTest.preferences_divisionHeader().getText();//get division header name
		String exp="Division";
		Reporter.log("Preferences division Header ,Expected:"+exp+",Actuals:"+divisionheader,true);
		softAssert.assertEquals(divisionheader, exp,"Header Name Not Matched");
		
		flag=isElementDisplayed(sanityTest.preferences_divisionselectAll());// select all the divisions
		Reporter.log("Select All divisions in Preferences division page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Select All divisions in Preferences division page is not displayed");
		
        fluentwait(sanityTest.preferences_divisionAction());// select divisions action
		
		
		String divisionaction=sanityTest.preferences_divisionAction().getText();//get division action header name
		exp="Actions";
		Reporter.log("Preferences division Header ,Expected:"+exp+",Actuals:"+divisionaction,true);
		softAssert.assertEquals(divisionaction, exp,"Header Name Not Matched");
		
		
		flag=isElementDisplayed(sanityTest.preferences_addaDivision());// add a division
		Reporter.log("Add a divisions in Preferences division page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Add a divisions in Preferences division page is not displayed");
		
		
		flag=isElementDisplayed(sanityTest.preferences_deleteDivision());// delete a division
		Reporter.log("Delete a divisions in Preferences division page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Delete a divisions in Preferences division page is not displayed");
		
		// Eft currency
		
		fluentwait(sanityTest.Menu_eftCurrency());
		click(sanityTest.Menu_eftCurrency()); // click on Preferences eft currency menu

		fluentwait(sanityTest.preferences_eftCurrencyType());// select eft currency type
		
		
		String eftheader=sanityTest.preferences_eftCurrencyType().getText();//get eft currency type header name
		exp="Currency Type";
		Reporter.log("Preferences eft currency type Header name ,Expected:"+exp+",Actuals:"+eftheader,true);
		softAssert.assertEquals(eftheader, exp,"Preferences eft currency type Header Name Not Matched");
		
		
		fluentwait(sanityTest.preferences_eftCurrency());// select eft currency
		
		String eftcurrency=sanityTest.preferences_eftCurrency().getText();//get eft currency header name
		exp="Currency";
		Reporter.log("Preferences eft currency Header name ,Expected:"+exp+",Actuals:"+eftcurrency,true);
		softAssert.assertEquals(eftcurrency, exp,"Preferences eft currency Header Name Not Matched");
		
		
		flag=isElementDisplayed(sanityTest.preferences_selectallEftcurrency());// select all the eft currency 
		Reporter.log("Select All eft currency in Preferences eftcurrency page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Select All eft currency in Preferences eftcurrency page is not displayed");
		
		flag=isElementDisplayed(sanityTest.preferences_addEftCurrency());// add eft currency 
		Reporter.log("Add eft currency in Preferences eftcurrency page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Add eft currency in Preferences eftcurrency page  is not displayed");
		
		flag=isElementDisplayed(sanityTest.preferences_deleteEftCurrency());// delete eft currency 
		Reporter.log("Delete eft currency in Preferences eftcurrency page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Delete eft currency in Preferences eftcurrency page  is not displayed");
		
		//ERP System 
		
		fluentwait(sanityTest.Menu_erpSystem());
		click(sanityTest.Menu_erpSystem()); // click on Preferences erp system menu
		

		fluentwait(sanityTest.preferences_erpSystemName());//  erp system name
		
		
		String erpsystemheader=sanityTest.preferences_erpSystemName().getText();//get erp system header name
		exp="ERP System Name";
		Reporter.log("Preferences erp system Header name ,Expected:"+exp+",Actuals:"+erpsystemheader,true);
		softAssert.assertEquals(erpsystemheader, exp,"Preferences erp system Header name Not Matched");
		
		flag=isElementDisplayed(sanityTest.preferences_selectAllERP());// select all erp system  
		Reporter.log("Select all erp system in Preferences erp system page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Select all erp system in Preferences erp system page  is not displayed");
		
		// Location Type
		
		fluentwait(sanityTest.Menu_locationType());
		click(sanityTest.Menu_locationType()); // click on Preferences location type menu
		

		fluentwait(sanityTest.preferences_locationType());//  location type
		
		String locationtype=sanityTest.preferences_locationType().getText();//get location type header name
		exp="Location Type";
		Reporter.log("Preferences location type Header name ,Expected:"+exp+",Actuals:"+locationtype,true);
		softAssert.assertEquals(locationtype, exp,"Preferences location type header name Not Matched");
		
		fluentwait(sanityTest.preferences_locationRequired());//  location required
		
		String locationrequired=sanityTest.preferences_locationRequired().getText();//get location required header name
		exp="Location Type";
		Reporter.log("Preferences location required Header name ,Expected:"+exp+",Actuals:"+locationrequired,true);
		softAssert.assertEquals(locationrequired, exp,"Preferences location required header name Not Matched");
		
		flag=isElementDisplayed(sanityTest.preferences_selectAllLocation());// select all location type 
		Reporter.log("Select all location type in Preferences location type page ,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Select all location type in Preferences location type page  is not displayed");
		
		// end of Preferences page
	}
	
	/**
	 * Feature Sanity Test Verify all tab and all Element
	 * 
	 * @author Priyanka.Mohanty
	 * @throws Exception
	 */
	@Test(priority=4)
	public void FeatureSanityTest() throws Exception{
		
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		
		
		fluentwait(sanityTest.Menu_feature());
		click(sanityTest.Menu_feature());

		fluentwait(sanityTest.featuresettings_AlertsandNotification());
		
		//Integration Feature Settings
		
		fluentwait(sanityTest.featuresettings_Intergration());//wait for the tab
		
		String intergration = sanityTest.featuresettings_Intergration().getText();//get the header text name 
		String exp="Integration";
		Reporter.log("Integration Feature Setting,Expected:"+exp+"Actuals:"+intergration,true);
		softAssert.assertEquals(intergration,exp,"Integration in Feature Setting is not displayed");
		
		click(sanityTest.featuresettings_Intergration());//click integration tab
		
		// Multiple ERP Integration 
		flag=isElementDisplayed(sanityTest.featuresettings_ValidationStatus());  // validation status 
		Reporter.log("Validation Status in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Validation Status in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsERPintegrationdisabled());  // Is ERP integration disabled
		Reporter.log("Is ERP integration disabled in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is ERP integration disabled in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsSupplierERPIDnotshowninsearchresults()); // Is Supplier ERP ID not shown in search results
		Reporter.log("Is Supplier ERP ID not shown in search resultsin Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Supplier ERP ID not shown in search resultsin Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsMultiERPSystemsenabled()); //Is Multi ERP Systems enabled
		Reporter.log("Is Multi ERP Systems enabledin Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Multi ERP Systems enabledin Feature Setting is not displayed");
		
		// Integration(Polaris)
		
		flag=isElementDisplayed(sanityTest.featuresettings_PolarisGrantFileLocation()); //Polaris Grant File Location
		Reporter.log("Polaris Grant File Location in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Polaris Grant File Location in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_PolarisOutboundFileLocation()); // Polaris Outbound File Location
		Reporter.log("Polaris Outbound File Location in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Polaris Outbound File Location in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_UserGroupforPolarisemailnotification()); // User Group for Polaris email notification
		Reporter.log("User Group for Polaris email notification in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"User Group for Polaris email notification in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_ContactIdforpolarisintegrationoutreach()); // Contact Id for polaris integration outreach
		Reporter.log("Contact Id for polar is integration outreach in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Contact Id for polar is integration outreach in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_PolarisIntegrationOutboundFileNameformat()); // Polaris Integration Outbound File Name format
		Reporter.log("Polaris Integration Outbound File Name format in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Polaris Integration Outbound File Name format in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_CustomfieldmappingforPolarisIntegration()); // Custom field mapping for Polaris Integration
		Reporter.log("Custom field mapping for Polaris Integration in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Custom field mapping for Polaris Integration in Feature Setting is not displayed");
		
		//Experian Integration
		flag=isElementDisplayed(sanityTest.featuresettings_IsExperianintegrationEnabled()); // Is experian integration Enabled
		Reporter.log("IsExperianintegrationEnabled in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"IsExperianintegrationEnabled in Feature Setting is not displayed");
		
		//Invoice Feature Settings
		fluentwait(sanityTest.featuresettings_Invoice());//wait for the tab
		
		String invoice = sanityTest.featuresettings_Invoice().getText();
		exp = "Invoice";
		Reporter.log("Featuresettings Invoice,Expected:"+exp+"Actuals:"+invoice,true);
		softAssert.assertEquals(invoice,exp,"Invoice in Feature Setting is not matched");
		
		click(sanityTest.featuresettings_Invoice());//click invoice tab
		
		//Supplier Invoice Details
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableInvoiceDeliverable()); // Enable Invoice Deliverable
		Reporter.log("Enable Invoice Deliverable in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable Invoice Deliverable in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsUploadInvoiceButtonEnabled()); // Is Upload Invoice Button Enabled
		Reporter.log("Is Upload Invoice Button Enabled in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Upload Invoice Button Enabled in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnabletheInvoiceBatchPaymentModule()); // Enable the Invoice Batch Payment Module
		Reporter.log("Enable the Invoic eBatch Payment Module in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable the Invoic eBatch Payment Module in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Autocreateinvoicefordeliverable()); // Auto create invoice for deliverable
		Reporter.log("Auto create invoice for deliverable in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Auto create invoice for deliverable in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Autocreateinvoicequery()); //Auto create invoice query
		Reporter.log("Auto create invoice query in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Auto create invoice query in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Invoicenumberprefixforautocreatedinvoice()); // Invoice number prefix for auto created invoice
		Reporter.log("Invoice number prefix for auto created invoice in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Invoice number prefix for auto created invoice in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Enableinvoiceupload()); // Enable invoice upload
		Reporter.log("Enable invoice upload in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable invoice upload in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Includespendfrominvoice()); // Include spend from invoice
		Reporter.log("Include spend from invoice in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Include spend from invoice  in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Enableinvoiceviewforsupplier()); //Enable invoice view for supplier
		Reporter.log("Enable invoice view for supplier in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable invoice view for supplier in Feature Setting is not displayed");
		
		// Batch Invoice
		
		flag=isElementDisplayed(sanityTest.featuresettings_BatchInvoiceRollbackStatus()); //Batch Invoice Rollback Status
		Reporter.log("Batch Invoice Rollback Status in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Batch Invoice Rollback Status in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Blockmultipleclientnameinvoicebatching()); // Block multiple client name invoice batching
		Reporter.log("Block multiple client name invoice batching in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Block multiple client name invoice batching in Feature Setting is not displayed");
		
		
		//Supplier Feature Settings
		
		fluentwait(sanityTest.featuresettings_Supplier());//wait for the tab
		
		String supplier = sanityTest.featuresettings_Supplier().getText();
		exp = "Supplier";
		Reporter.log("FeatureSettings Supplier ,Expected:"+exp+"Actuals:"+supplier,true);
		softAssert.assertEquals(supplier,exp,"Supplier in Feature Setting is not matched");
		
		click(sanityTest.featuresettings_Supplier());//click supplier tab
		
		//Edit and View Profile
		
		flag=isElementDisplayed(sanityTest.featuresettings_HideDeleteW8W9button()); // Hide Delete W8/W9 button
		Reporter.log("Hide Delete W8W9 button in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Hide Delete W8W9 button  in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_HideInsuranceTableOrJustification()); //Hide Insurance Table/Justification
		Reporter.log("Hide Insurance Table Or Justification in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Hide Insurance Table Or Justification in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_PrescreenFooterMessageFailure()); //Prescreen Footer Message - Failure
		Reporter.log("Prescreen Footer Message Failure in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Prescreen Footer Message Failure in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_PrescreenFooterMessageSuccessOrPending()); //Prescreen Footer Message - Success/Pending
		Reporter.log("Prescreen Footer Message Success Or Pending in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Prescreen Footer Message Success Or Pending in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsPreferredPaymenttypeEFT()); //Is Preferred Payment type EFT
		Reporter.log("Is Preferred Payment type EFTin Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Preferred Payment type EFTin Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_SubstituteW9()); //Substitute W9
		Reporter.log("SubstituteW9 in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"SubstituteW9 in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_SupplierProfileIncompleteMessage()); //Supplier Profile- Incomplete Message
		Reporter.log("Supplier Profile Incomplete Message in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Supplier Profile Incomplete Message in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnabletheCreditCardVendorRecordOnly()); //Enable the Credit Card Vendor Record Only
		Reporter.log("Enable the Credit Card Vendor Record Only in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable the Credit Card Vendor Record Only in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsInvitingOrganizationEnabled()); // Is Inviting Organization Enabled
		Reporter.log("Is Inviting Organization Enabled in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Inviting Organization Enabled in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Providethecsvfileseparator()); // Provide the csv file separator
		Reporter.log("Providethecsvfileseparator in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Providethecsvfileseparator in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_PaymodeXEnrollmentLink()); //Paymode-X Enrollment Link
		Reporter.log("Pay mode X Enrollment Link in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Pay mode X Enrollment Link in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_PaymodeXEnrollmentNumber()); //Paymode-X Enrollment Number
		Reporter.log("Is Upload Invoice Button Enabled in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Upload Invoice Button Enabled in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_CreditCardPaymentemailnote()); // Credit Card payment email note
		Reporter.log("Credit Card Payment email note in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Credit Card Payment email notein Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Cardpaymenttermnote()); //Card payment term note
		Reporter.log("Card payment term note in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Card payment term note in Feature Setting is not displayed");
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_PaymodeXpaymenttermnote()); //Paymode X payment term note
		Reporter.log("Pay mode X payment term note in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Pay mode X payment term note in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_DisableSmallBusinessDiversityCheck()); //DISABLE_SMALLBUSINESS_DIVERSITY_CHECK
		Reporter.log("Disable Small Business Diversity Check in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Disable Small Business Diversity Check in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnablePaymentCenterDivisionbasedPayment()); //Enable Payment Center - Division based Payment
		Reporter.log("Enable Payment Center Division based Payment in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable Payment Center Division based Payment in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableMultiSelectforPaymentCenterPayment()); //Enable Multi Select for Payment Center Payment
		Reporter.log("Enable Multi Select for Payment Center Payment in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable Multi Select for Payment Center Payment in Feature Setting is not displayed");
		
		//Creation and Invitation
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsSupplierGroupRequired()); //Is Supplier Group Required
		Reporter.log("Is Supplier Group Required in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Supplier Group Required in Feature Setting is not displayed");
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsInviteJustificationRequired()); //Is Invite Justification Required
		Reporter.log("IsInviteJustificationRequired in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"IsInviteJustificationRequired in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_InviteSupplierEmailOrFaxCustomerSpecific()); //Invite Supplier Email/Fax - Customer Specific
		Reporter.log("Invite Supplier Email Or Fax Customer Specific in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Invite Supplier Email Or Fax Customer Specific in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_InviteSupplierEmailRequired());//Invite Supplier - Email Required
		Reporter.log("Invite Supplier Email Required in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Invite Supplier Email Required in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_InviteSupplierFaxRequired()); //Invite Supplier - Fax Required
		Reporter.log("Invite Supplier Fax Requiredin Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Invite Supplier Fax Required in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_SupplierRegistrationSuccessMessage()); //Supplier Registration - Success Message
		Reporter.log("Supplier Registration Success Message in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Supplier Registration Success Message in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsInviteConfirmationRequired());//Is Invite Confirmation Required
		Reporter.log("Is Multi ERP Systems enabledin Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Multi ERP Systems enabledin Feature Setting is not displayed");
		
		
		//Customer Suppliers Search
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsTalentAgentRequired()); //Is Talent Agent Required
		Reporter.log("Is Talent Agent Requiredin Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Talent Agent Requiredin Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_HideTakeControlButton());//Hide Take Control Button
		Reporter.log("Hide Take Control Button in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Hide Take Control Button in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IsDefaultsuppliersearchfilterconfigured());//Is Default supplier search filter configured
		Reporter.log("Is Default supplier search filter configured in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Default supplier search filter configured in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Allowmultiplecontactsforinvite());//Allow multiple contacts for invite
		Reporter.log("Allow multiple contacts for invite in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Allow multiple contacts for invite in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_AllowEditinviteafterinvitehasbeensent());//Allow Edit invite after invite has been sent
		Reporter.log("Allow Edit invite after invite has been sent in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Allow Edit invite after invite has been sent in Feature Setting page is not displayed");
		 
		flag=isElementDisplayed(sanityTest.featuresettings_IsInvitePrefixConfigured()); //Is Invite Prefix Configured
		Reporter.log("Is Invite Prefix Configured in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Invite Prefix Configured in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_DisableExtendInvite()); //Disable Extend Invite
		Reporter.log("Disable Extend Invite in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Disable Extend Invite in Feature Setting is not displayed");
		
		
		// Workflow Feature Settings
		
		fluentwait(sanityTest.featuresettings_Workflow());//wait for the tab
		
		String workflow = sanityTest.featuresettings_Workflow().getText();//get header name 
		exp = "Workflow";
		Reporter.log("Workflow ,Expected:"+exp+"Actuals:"+workflow,true);
		softAssert.assertEquals(workflow,exp,"Workflow in Feature Setting is not matched");
		
		click(sanityTest.featuresettings_Workflow()); // click on workflow
		
		//Workflow
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableTempApproval()); // Enable Temp Approval
		Reporter.log("Enable Temp Approval in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable Temp Approval in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_TempApprovalResetDays()); //Temp Approval Reset Days
		Reporter.log("Temp Approval Reset Days in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Temp Approval Reset Days in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Showonholdbutton()); // Show onhold button
		Reporter.log("Showonholdbutton in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Showonholdbutton in Feature Setting is not displayed");
		
		
		// Alerts and Notification Feature Settings
		
		fluentwait(sanityTest.featuresettings_AlertsandNotification());
		
		String alertsandNotification = sanityTest.featuresettings_AlertsandNotification().getText();
		exp = "Alerts and Notification";
		Reporter.log("Alerts And Notification,Expected:"+exp+"Actuals:"+alertsandNotification,true);
		softAssert.assertEquals(alertsandNotification,exp,"Alerts And Notification in Feature Setting is not displayed");
		
		click(sanityTest.featuresettings_AlertsandNotification());// click  on Alerts and Notification tab
		
		// Alerts and Notification
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_Groupstonotifysupplierprofiledatachange());//
		Reporter.log("Groups to notify supplier profile data change in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Groups to notify supplier profile data change in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Taskreminderfrequency()); //
		Reporter.log("Task reminder frequency in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Task reminder frequencyin Feature Setting is not displayed");
		
		
		
		// Regulatory Compliance Feature Settings
		
		fluentwait(sanityTest.featuresettings_RegulatoryCompliance());
		
		
		String regulatorycompliance =sanityTest.featuresettings_RegulatoryCompliance().getText();
		exp = "Regulatory Compliance";
		Reporter.log("RegulatoryCompliance Feature Setting ,Expected:"+exp+"Actauls:"+regulatorycompliance,true);
		softAssert.assertEquals(regulatorycompliance,exp,"RegulatoryCompliance in Feature Setting is not matched");
		click(sanityTest.featuresettings_RegulatoryCompliance());//click on Regulatory Compliance tab
		
		//Regulatory Compliance
		flag=isElementDisplayed(sanityTest.featuresettings_DisableVATValidation());//Disable VAT Validation
		Reporter.log("Disable VA Validation in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Disable VA Validation in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_AutoPassLegalIDValidation());//Auto Pass Legal ID Validation
		Reporter.log("Auto Pass LegalID Validation in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Auto Pass LegalID Validation in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_ProfileCompletenessExcludeVATValidationStatus());//Profile Completeness - Exclude VAT Validation Status
		Reporter.log("ProfileCompletenessExcludeVATValidationStatus in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"ProfileCompletenessExcludeVATValidationStatus in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_ProfileCompletenessExcludeSwissVATValidationStatus());//Profile Completeness - Exclude Swiss VAT Validation Status
		Reporter.log("Profile Completeness Exclude Swiss VAT Validation Status in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Profile Completeness Exclude Swiss VAT Validation Status in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_DisableVATorUIDValidation());//Disable VAT or UID Validation
		Reporter.log("Disable VAT or UIDValidation in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Disable VAT or UIDValidation in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableW8());//Enable W8
		Reporter.log("EnableW8 in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"EnableW8 in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableW9());//Enable W9
		Reporter.log("EnableW9 in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"EnableW9 in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Enableprescreening());//Enable prescreening
		Reporter.log("Enable prescreening in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable prescreening in Feature Setting is not displayed");
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableOIGFederalList());//Enable OIG (Federal List)
		Reporter.log("Enable OIG Federal List in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable OIG Federal List in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableOIGStateList());//Enable OIG (State List)
		Reporter.log("Enable OIG State List in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable OIG State List in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_EnableSAM()); //Enable SAM
		Reporter.log("Enable SAM in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Enable SAM in Feature Setting is not displayed");
		

		// Score card Feature settings
		
		fluentwait(sanityTest.featuresettings_ScoreCard());
		
		
		String scorecard= sanityTest.featuresettings_ScoreCard().getText();
		exp= "Score Card";
		Reporter.log("FeatureSetting ScoreCard,Expected:"+exp+"Actuals:"+scorecard,true);
		softAssert.assertEquals(scorecard,exp,"ScoreCard in Feature Setting is not matched");
		
		click(sanityTest.featuresettings_ScoreCard()); // click on Score card tab
		
		
		//Supplier Health Score

		flag=isElementDisplayed(sanityTest.featuresettings_IsHealthScoreEnabled());
		Reporter.log("Is Health Score Enabled in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Is Health Score Enabled in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_Healthscorespendfileduration());
		Reporter.log("Health score spend file duration in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Health score spend file duration in Feature Setting is not displayed");
		
		// Contract Management Feature settings
		
		fluentwait(sanityTest.featuresettings_ContractManagement());
		

		String contractmanagement = sanityTest.featuresettings_ContractManagement().getText();
		exp= "Contract Management";
		Reporter.log("Contract Management  Feature Setting ,Expected:"+exp+"Actauls:"+contractmanagement,true);
		softAssert.assertEquals(contractmanagement,exp,"Contract Management in Feature Setting is not matched");
		
		click(sanityTest.featuresettings_ContractManagement());// click on Contract Management tab
		
		//Supplier Profile - Contract Management
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_CustomUIFieldIdforMSANumber()); //Custom UI Field Id for MSA Number
		Reporter.log("Custom UI Field Id for MSA Number in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Custom UI Field Id for MSA Number in Feature Setting is not displayed");
		
		
		flag=isElementDisplayed(sanityTest.featuresettings_CustomUIFieldIdforSOWNumber()); //Custom UI Field Id for SOW Number
		Reporter.log("Custom UI Field Id for SOW Number in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Custom UI Field Id for SOW Number in Feature Setting is not displayed");

		
		flag=isElementDisplayed(sanityTest.featuresettings_IntegrationRest());
		Reporter.log("Integration Rest in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Integration Rest in Feature Setting is not displayed");
		
		flag=isElementDisplayed(sanityTest.featuresettings_IntegrationSave());
		Reporter.log("Integration Save in Feature Setting page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Integration Save in Feature Setting is not displayed");
		
		softAssert.assertAll();
		
		
		
		
	}

	/**
	 * Role Sanity Test Verify all tab and all Element
	 * 
	 * @author Priyanka.Mohanty
	 * @throws Exception
	 */
	@Test(priority=5)
	public void RoleSanityTest() throws Exception{

		Reporter.log("Test Started at:"+currenttime());

		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		
		fluentwait(sanityTest.Menu_role());
		click(sanityTest.Menu_role());

		fluentwait(sanityTest.role_HeaderName());
		
		
		String header=sanityTest.role_HeaderName().getText();
		String exp="Role Name";
		Reporter.log("Role Header ,Expected:"+exp+",Actuals:"+header,true);
		softAssert.assertEquals(header, exp,"Header Name Not Matched");
		
		header=sanityTest.role_HeaderDescription().getText();
		exp="Description";
		Reporter.log("Role Header Description ,Expected:"+exp+",Actuals:"+header,true);
		softAssert.assertEquals(header, exp,"Header Descriptionname Not Matched");
	
		String createdDate = sanityTest.role_HeaderCreatedDate().getText();
		exp = "Created Date";
		Reporter.log("Role Created Date,Expected:"+exp+",Actuals:"+createdDate,true);
		softAssert.assertEquals(createdDate,exp,"Header Created Date in Role page is not matched");
		
		String createdby = sanityTest.role_HeaderCreatedBy().getText();
		exp = "Created By";
		Reporter.log("Role Created Date,Expected:"+exp+",Actuals:"+createdby,true);
		softAssert.assertEquals(createdby,exp,"Header CreatedBy in Role page is not matched");
		
		String status = sanityTest.role_HeaderStatus().getText();
		exp = "Status";
		Reporter.log("Role Status,Expected:"+exp+"Actuals:"+status,true);
		softAssert.assertEquals(status,exp,"Role Status in Role page is not matched");
		
		String actions = sanityTest.role_HeaderActions().getText();
		exp = "Actions";
		Reporter.log("Role Actions,Expected:"+exp+"Actuals:"+actions,true);
		softAssert.assertEquals(actions,exp,"Role Actions in Role page is not matched");
		
		flag=isElementDisplayed(sanityTest.role_DeleteRoles());
		Reporter.log("Delete Roles in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Delete Roles in Role page is not displayed");
		
		flag=isElementDisplayed(sanityTest.role_AddRoles());
		Reporter.log("Add Roles in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Add Roles in Role page is not displayed");
		
		flag=isElementDisplayed(sanityTest.role_PageBacktoBuyers());
		Reporter.log("Page Back to Buyers in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Page Back to Buyers in Role page is not displayed");

		flag=isElementDisplayed(sanityTest.role_PreviousPage());
		Reporter.log("Previous Page in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Previous Page in Role page is not displayed");

		flag=isElementDisplayed(sanityTest.role_NextPage());
		Reporter.log("Next Page in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Next Page in Role page is not displayed");

		flag=isElementDisplayed(sanityTest.role_SelectAllCustomer());
		Reporter.log("Select All Customer in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Select All Customer in Role page is not displayed");
		
		flag=isElementDisplayed(sanityTest.role_FilterUserRoleName());
		Reporter.log("Filter User Role Name in Role page,display Status:"+flag,true);
		softAssert.assertTrue(flag,"Filter User Role Name in Role page is not displayed");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:"+currenttime());
		
	}

	/**
	 * checking header names and buttons in User page 
	 * 
	 * @author Nandini.R
	 */
	@Test(priority=6)
	public void ConfigSanityUserpage() throws Exception{
		Reporter.log("Test Started at:"+currenttime());	
		SoftAssert softassert=new SoftAssert();
		fluentwait(homePage.userMenu());
		click(homePage.userMenu());
		fluentwait(sanityTest.user_deletebttn());
		
		boolean flag= isElementDisplayed(sanityTest.user_deletebttn());
		Reporter.log("Delete button in User page:"+flag);
		softassert.assertTrue(flag,"Delete button in User page:"+flag);

		flag=isElementDisplayed(sanityTest.user_addbttn());
		Reporter.log("Add button present in User page:"+flag);
		softassert.assertTrue(flag,"Add button present in User page:"+flag);
		
		String actualheader1=sanityTest.user_headername().getText();
		String expheader1="Name";
		Reporter.log("Header name,Expected:"+expheader1+"Actual:"+actualheader1);
		
		softassert.assertEquals(actualheader1,expheader1,"Header Name not matched,Expected:"+expheader1+",Actuals:"+actualheader1);
		
		String actualheader2=sanityTest.user_headeruser().getText();
		String expheader2="User Role";
		Reporter.log("Header name,Expected:"+expheader2+"Actual:"+actualheader2);
		softassert.assertEquals(actualheader2, expheader2,"Header Name not matched,Expected:"+expheader2+",Actuals:"+actualheader2);
		
		String actualheader3=sanityTest.user_headeractive().getText();
		String expheader3="Active";
		Reporter.log("Header name,Expected:"+expheader3+"Actual:"+actualheader3);
		softassert.assertEquals(actualheader3, expheader3,"Header Name not matched,Expected:"+expheader3+",Actuals:"+actualheader3);
		
		String actualheader4=sanityTest.user_headeraccountcreated().getText();
		String expheader4="Account Created";
		Reporter.log("Header name,Expected:"+expheader4+"Actual:"+actualheader4);
		softassert.assertEquals(actualheader4, expheader4,"Header Name not matched,Expected:"+expheader4+",Actuals:"+actualheader4);
		
		String actualheader5=sanityTest.user_headeremail().getText();
		
		String expheader5="Email";
		Reporter.log("Header name,Expected:"+expheader5+"Actual:"+actualheader5);
		softassert.assertEquals(actualheader5, expheader5,"Header Name not matched,Expected:"+expheader5+",Actuals:"+actualheader5);
		
		String actualheader6=sanityTest.user_headerphone().getText();
		String expheader6="Phone";
		Reporter.log("Header name,Expected:"+expheader6+"Actual:"+actualheader6);
		softassert.assertEquals(actualheader6, expheader6,"Header Name not matched,Expected:"+expheader6+",Actuals:"+actualheader6);
		
		String actualheader7=sanityTest.user_headerfax().getText();
		String expheader7="Fax";
		Reporter.log("Header name,Expected:"+expheader7+"Actual:"+actualheader7);
		softassert.assertEquals(actualheader7, expheader7,"Header Name not matched,Expected:"+expheader7+",Actuals:"+actualheader7);
		
		String actualheader8=sanityTest.user_headeractions().getText();
		String expheader8="Actions";
		Reporter.log("Header name,Expected:"+expheader8+"Actual:"+actualheader8);
		softassert.assertEquals(actualheader8, expheader8,"Header Name not matched,Expected:"+expheader8+",Actuals:"+actualheader8);
		
		String actualheader9=sanityTest.user_username().getText();
		String expheader9="User Name";
		Reporter.log("Header name,Expected:"+expheader9+"Actual:"+actualheader9);
		softassert.assertEquals(actualheader8, expheader8,"Header Name not matched,Expected:"+expheader9+",Actuals:"+actualheader9);
		
		softassert.assertAll();
		Reporter.log("Test Ended at:"+currenttime());
	}
	
	/**
	 * checking header names and buttons in outreach set up
	 * 
	 * @author Nandini.R
	 */
	@Test(priority=7)
	public void ConfigSanityOutReach() throws Exception{
			
			SoftAssert softassert=new SoftAssert();
			
			Reporter.log("Test Started for OutReach at:"+currenttime());
			
			fluentwait(homePage.outreachMenu());
			click(homePage.outreachMenu());
			fluentwait(homePage.outreachsetupMenu());
			click(homePage.outreachsetupMenu());
			
			
			fluentwait(sanityTest.headeroutreachseq());
			
			boolean flag= isElementDisplayed(sanityTest.outset_deletebttn());
			Reporter.log("Delete button in User page:"+flag);
			softassert.assertTrue(flag,"Delete button in User page:"+flag);
			
			flag=isElementDisplayed(sanityTest.outset_addbttn());
			Reporter.log("Add button in User page:"+flag);
			softassert.assertTrue(flag,"Add button in User page:"+flag);
			
			String actualheader=sanityTest.headeroutreachseq().getText();
			String expHeader="Outreach Sequence";
			Reporter.log("Header Name,Expected:"+expHeader+",Actuals:"+actualheader);
			softassert.assertEquals(actualheader,expHeader,"Header Name not matched,Expected:"+expHeader+",Actuals:"+actualheader);
			
			actualheader=sanityTest.headerouttype().getText();
			expHeader="Outreach Type";
			Reporter.log("Header Name,Expected:"+expHeader+",Actuals:"+actualheader);
			softassert.assertEquals(actualheader, expHeader,"Header Name not matched,Expected:"+expHeader+",Actuals:"+actualheader);
			
			String actualheader3=sanityTest.headerwaitdays().getText();
			String expheader3="Wait Days";
			Reporter.log("Header Name,Expected:"+expheader3+",Actuals:"+actualheader3);
			softassert.assertEquals(actualheader3, expheader3,"Header Name not matched,Expected:"+expheader3+",Actuals:"+actualheader3);
			
			String actualheader4=sanityTest.headercreaby().getText();
			String expheader4="Created By";
			Reporter.log("Header Name,Expected:"+expheader4+",Actuals:"+actualheader4);
			softassert.assertEquals(actualheader4, expheader4,"Header Name not matched,Expected:"+expheader4+",Actuals:"+actualheader4);
			
			String actualheader5=sanityTest.headercreaon().getText();
			String expheader5="Created On";
			Reporter.log("Header Name,Expected:"+expheader5+",Actuals:"+actualheader5);
			softassert.assertEquals(actualheader5, expheader5,"Header Name not matched,Expected:"+expheader5+",Actuals:"+actualheader5);
			
			String actualheader6=sanityTest.headeractions().getText();
			String expheader6="Actions";
			Reporter.log("Header Name,Expected:"+expheader6+",Actuals:"+actualheader6);
			softassert.assertEquals(actualheader6, expheader6,"Header Name not matched,Expected:"+expheader6+",Actuals:"+actualheader6);
			
			click(homePage.outreachtempMenu());
			

			fluentwait(sanityTest.headergroupname());
			
			flag=isElementDisplayed(sanityTest.deleteoutreachbttn());
			Reporter.log("DeleteOutreach button in User page:"+flag);
			softassert.assertTrue(flag,"Deleteoutreach button in User page:"+flag);

			flag=isElementDisplayed(sanityTest.addoutreachbttn());
			Reporter.log("Addoutreach button in User page:"+flag);
			softassert.assertTrue(flag,"Addoutreach button in User page:"+flag);
			
			String actualheader1=sanityTest.headergroupname().getText();
			String expheader1="Group Name";
			Reporter.log("Header Name,Expected:"+expheader1+",Actuals:"+actualheader1);
			softassert.assertEquals(actualheader1,expheader1,"Header Name not matched,Expected:"+expheader1+",Actuals:"+actualheader1);
			
			String actualheader2=sanityTest.headerlanguage().getText();
			String expheader2="Language";
			Reporter.log("Header Name,Expected:"+expheader2+",Actuals:"+actualheader2);
			softassert.assertEquals(actualheader2, expheader2,"Header Name not matched,Expected:"+expheader2+",Actuals:"+actualheader2);
			
			 actualheader3=sanityTest.headeroutreachtype().getText();
			 expheader3="Outreach Type";
			Reporter.log("Header Name,Expected:"+expheader3+",Actuals:"+actualheader3);
			softassert.assertEquals(actualheader3, expheader3,"Header Name not matched,Expected:"+expheader3+",Actuals:"+actualheader3);
			
			 actualheader4=sanityTest.headertemplate().getText();
			 expheader4="Template";
			Reporter.log("Header Name,Expected:"+expheader4+",Actuals:"+actualheader4);
			softassert.assertEquals(actualheader4, expheader4,"Header Name not matched,Expected:"+expheader4+",Actuals:"+actualheader4);
			
			 actualheader5=sanityTest.headerpreview().getText();
			 expheader5="Preview";
			Reporter.log("Header Name,Expected:"+expheader5+",Actuals:"+actualheader5);
			softassert.assertEquals(actualheader5, expheader5,"Header Name not matched,Expected:"+expheader5+",Actuals:"+actualheader5);
			
			 actualheader6=sanityTest.headercreatedby().getText();
			 expheader6="Created By";
			Reporter.log("Header Name,Expected:"+expheader6+",Actuals:"+actualheader6);
			softassert.assertEquals(actualheader6, expheader6,"Header Name not matched,Expected:"+expheader6+",Actuals:"+actualheader6);
			
			String actualheader7=sanityTest.headercreatedon().getText();
			String expheader7="Created On";
			Reporter.log("Header Name,Expected:"+expheader7+",Actuals:"+actualheader7);
			softassert.assertEquals(actualheader7, expheader7,"Header Name not matched,Expected:"+expheader7+",Actuals:"+actualheader7);
			
			String actualheader8=sanityTest.headeraction().getText();
			String expheader8="Actions";
			Reporter.log("Header Name,Expected:"+expheader8+",Actuals:"+actualheader8);
			softassert.assertEquals(actualheader8, expheader8,"Header Name not matched,Expected:"+expheader8+",Actuals:"+actualheader8);
		
			softassert.assertAll();
			Reporter.log("Test Ended at:"+currenttime());
		}

	/**
	 * checking header names and buttons in Vendor Type page 
	 * 
	 * @author Nandini.R
	 */
	@Test(priority=9)
	public void ConfigPreferencepage() throws Exception{
		Reporter.log("Test Started at:"+currenttime());	
		SoftAssert softassert=new SoftAssert();
		fluentwait(homePage.preferenceMenu());
		click(homePage.preferenceMenu());
		
		fluentwait(homePage.vendortypeMenu());
		click(homePage.vendortypeMenu());
		
		fluentwait(sanityTest.vendoraddbttn());
		boolean flag= isElementDisplayed(sanityTest.vendordelbttn());
		Reporter.log("Delete button in User page:"+flag);
		softassert.assertTrue(flag,"Delete button in Vendor Type page:"+flag);

		flag=isElementDisplayed(sanityTest.vendoraddbttn());
		Reporter.log("Add button present in User page:"+flag);
		softassert.assertTrue(flag,"Add button present in Vendor Type page:"+flag);
		
		String actualheader1=sanityTest.vendortypeheader().getText();
		String expheader1="Vendor Type";
		Reporter.log("Header name,Expected:"+expheader1+"Actual:"+actualheader1);
		
		softassert.assertEquals(actualheader1,expheader1,"Header Name not matched,Expected:"+expheader1+",Actuals:"+actualheader1);
		
		String actualheader2=sanityTest.vendoractionsheader().getText();
		String expheader2="Actions";
		Reporter.log("Header name,Expected:"+expheader2+"Actual:"+actualheader2);
		softassert.assertEquals(actualheader2, expheader2,"Header Name not matched,Expected:"+expheader2+",Actuals:"+actualheader2);
		
		//Supplier Group
		click(homePage.suppliergroupMenu());

		
		 flag= isElementDisplayed(sanityTest.suppgroupdelbttn());
		Reporter.log("Delete button in User page:"+flag);
		softassert.assertTrue(flag,"Delete button in supplier Group page:"+flag);

		flag=isElementDisplayed(sanityTest.suppgroupaddbttn());
		Reporter.log("Add button present in User page:"+flag);
		softassert.assertTrue(flag,"Add button present in supplier group page:"+flag);
		
		 actualheader1=sanityTest.suppgroupheadtext().getText();
		 expheader1="Supplier Group";
		Reporter.log("Header name,Expected:"+expheader1+"Actual:"+actualheader1);
		
		softassert.assertEquals(actualheader1,expheader1,"Header Name not matched,Expected:"+expheader1+",Actuals:"+actualheader1);
		
		 actualheader2=sanityTest.suppgroupactionheadtext().getText();
		 expheader2="Actions";
		Reporter.log("Header name,Expected:"+expheader2+"Actual:"+actualheader2);
		softassert.assertEquals(actualheader2, expheader2,"Header Name not matched,Expected:"+expheader2+",Actuals:"+actualheader2);
		
		//Payment Settings
		fluentwait(homePage.paymentsettingsMenu());
		click(homePage.paymentsettingsMenu());

		fluentwait(sanityTest.paysetpayytypehead());
		 flag= isElementDisplayed(sanityTest.paysettdelbttn());
		Reporter.log("Delete button in User page:"+flag);
		softassert.assertTrue(flag,"Delete button in supplier Group page:"+flag);

		flag=isElementDisplayed(sanityTest.paysettaddbttn());
		Reporter.log("Add button present in User page:"+flag);
		softassert.assertTrue(flag,"Add button present in supplier group page:"+flag);
		
		 actualheader1=sanityTest.paysetpayytypehead().getText();
		 expheader1="Payment Type";
		Reporter.log("Header name,Expected:"+expheader1+"Actual:"+actualheader1);
		
		softassert.assertEquals(actualheader1,expheader1,"Header Name not matched,Expected:"+expheader1+",Actuals:"+actualheader1);
		
		 actualheader2=sanityTest.paysetpayytermhead().getText();
		 expheader2="Payment Term";
		Reporter.log("Header name,Expected:"+expheader2+"Actual:"+actualheader2);
		softassert.assertEquals(actualheader2, expheader2,"Header Name not matched,Expected:"+expheader2+",Actuals:"+actualheader2);
		
		String actualheader3=sanityTest.paysetactionhead().getText();
		String expheader3="Actions";
		Reporter.log("Header Name,Expected:"+expheader3+",Actuals:"+actualheader3);
		softassert.assertEquals(actualheader3, expheader3,"Header Name not matched,Expected:"+expheader3+",Actuals:"+actualheader3);
			
		softassert.assertAll();
		
		Reporter.log("Test Ended at:"+currenttime());
	}
	
	
	/**
	 * After Class Logout and Quit Method 
	 * 
	 * @author Piramanayagam.S
	 */
	
	@AfterClass
	  public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	  }
	
	
}
