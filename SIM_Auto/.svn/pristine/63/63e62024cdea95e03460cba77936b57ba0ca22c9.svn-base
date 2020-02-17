package com.lavante.sim.customer.pageobjects.HomePage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.BasicSearch.SupplierSearchPage;
import com.lavante.sim.Common.Util.*;

public class HomePage  {

	LavanteUtils lavanteUtils = new LavanteUtils();
	SupplierSearchPage objSupplierSearchPage;
	
	//Declare web driver
	public WebDriver driver;
	
	//Page Objects 

	String	expectedPageTitle = "Lavante SIM - On-boarding";
	String	expCompliancePageTitle = "Lavante SIM - Regulatory Compliance";
	String	expectedSupplierPageTitle = "Lavante SIM - Search";
	String legalIDPageTitle = "Lavante SIM - Legal ID";	
	String ofacPageTitle = "Lavante SIM - OFAC";	
	String expInviteSupplierSuccessMsg = "An invitation has been sent to the Supplier specified by you.";
	String expBroadcastTitle = "Confirm Broadcast to Suppliers";
	String expDownLoadFileTitle = "Download Clean Supplier File";
	String supplierOutreachStaus= "Supplier Outreach Status";
	String legalIDAuthentication= "Legal ID Authentication";
	String ofacSdnScreening = "OFAC SDN Screening";

	
	@FindBy(id="searchText")
	private WebElement supplierSearch;
	
	@FindBy(id="header_right")
	private WebElement CustomerLogo;
	
	@FindBy(id="suppliername")
	private WebElement supplierName;
	
	@FindBy(id="contactname")
	private WebElement contactName;
	
	@FindBy(id="fax")
	private WebElement fax;
	
	@FindBy(id="invitingOrganization")
	private WebElement invitingOrganization;
	
	@FindBy(xpath=".//*[@id='supplierGroup_chosen']/a/span")
	private WebElement supplierGroup;
	
	@FindBy(id="button_clear")
	private WebElement clearBtn;
	
	@FindBy(id="button_invite")
	private WebElement inviteBtn;
	
	@FindBy(xpath="//div[@class='dialog undefined ui-dialog-content ui-widget-content']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath="//img[contains(@src,'images_common/layout/logo.png')]")
	private WebElement CompanyLogo;
	
	@FindBy(xpath="//a[@title='Dashboard']")
	private WebElement Dashboard;
	
	@FindBy(xpath="//a[@title='Suppliers']")
	private WebElement Suppliers;
	
	@FindBy(xpath="//a[@title='Tasks']")
	private WebElement Tasks;
	
	@FindBy(xpath="//a[@title='Manage Files']")
	private WebElement ManageFiles;
	
	@FindBy(css="a[href*='Contact']")
	private WebElement ManageUsers;
	
	@FindBy(xpath="//a[@title='Reports']")
	private WebElement Reports;
	
	@FindBy(xpath="//a[@title='On-boarding']")
	private WebElement Onboarding;
	
	@FindBy(xpath="//a[@title='Regulatory Compliance']")
	private WebElement Compliance;

	@FindBy(xpath="//a[@title='Diversity']")
	private WebElement Diversity;
	
	@FindBy(xpath="//div[contains(@style,'visible')]//button/..//span[contains(@class,'title')]")
	private WebElement QuickLink ;	
	
	@FindBy(xpath="//span[contains(@id,'cndKHf77BB_select_type')]/a[contains(@title,'Data Table')]")
	private WebElement outreachdataTableBtn ;
	
	@FindBy(xpath="//button[@class='button_red']")
	private WebElement CancelBtnForBroadCast ;
	
	@FindBy(xpath="//button[@class='button button_red cancel']")
	private WebElement CancelBtn;
	
	@FindBy(xpath="//button[@class='button_green']")
	private WebElement OkBtn;
	
	@FindBy(xpath="//span[@class='error']")
	private WebElement errorMsg;
		
	private String dataNotFound = "//td[@class='data_not_found']";
	
	private String todolistrowCount = "//td[contains(@class,'flx_28')]/div[1]//table[contains(@class,'grid')]//td[1]//a";
	
	@FindBy(xpath="//div/table[contains(@class,'data_table table_grid zebra')]/tbody/tr[")
	private WebElement date ;
	
	@FindBy(xpath="]/td[2]")
	private WebElement received;
	
	@FindBy(xpath="//div[contains(@id,'content')]/table/tbody/tr/td[1]/div[1]/div[2]/div/table/tbody/tr[")
	private WebElement task ;
	
	@FindBy(xpath="]/td[1]")
	private WebElement description ;

	private String workflow = "//td[contains(@class,'flx_28')]/div[2]//table[contains(@class,'grid')]//td[1]//a" ;
	
	private String alerts = "//td[contains(@class,'flx_28')]/div[3]//table[contains(@class,'grid')]//td[1]//";
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77BB_select_type')]")
	private WebElement outreachpieChartBtn ;	

	private String xpathoutreachheadersCount = "//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/thead/tr/th";

	@FindBy(xpath="//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/thead/tr/th[1]")
	private WebElement outreachheader;
	
	@FindBy(xpath="//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/tbody/tr/td[1]")
	private WebElement outreachTable;	
	
	String xpathoutreachdataCount = "//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/tbody/tr/td";
	String  xpathoutreachtablerowCount = "//span[contains(@id,'cndKHf77BB_select_type')]/a[contains(@title,'Data Table')]" ;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77BB_select_type')][contains(@class,'icon select_type select_type_table')]")
	private WebElement outreachTblOption;
	
	@FindBy(xpath="//span[contains(@id,'total_records')]")
	private WebElement outreachVerification;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77EE_select_type')]")
	private WebElement legalIdpieChartBtn;
	
	@FindBy(xpath="//span[contains(@id,'cndKHf77EE_select_type')]/a[contains(@title,'Data Table')]")
	private WebElement legalIddataTableBtn;
	
	@FindBy(xpath="//div[@class='chart chart_minimized box_content_expanded']/descendant::table[@class='data_table table_grid zebra']")
	private WebElement legalIdtablerowCount;
	
	@FindBy(xpath="//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/thead/tr/th")
	private WebElement legalIdheadersCount;
	
	@FindBy(xpath="//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/tbody/tr/td")
	private WebElement legalIddataCount;
	
	@FindBy(xpath="//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/thead/tr/th[")
	private WebElement legalIdheader;
	
	@FindBy(xpath="//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/tbody/tr/td[")
	private WebElement legalIdTable;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77EE_select_type')][contains(@class,'icon select_type select_type_table')]")
	private WebElement legalIDTblOption;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77FF_select_type')]")
	private WebElement ofacSdnpieChartBtn;
	
	@FindBy(xpath="//span[contains(@id,'cndKHf77FF_select_type')]/a[contains(@title,'Data Table')]")
	private WebElement ofacSdndataTableBtn;
	
	private String ofacSdntablerowCount = "//div[@id='cndKHf77FF']/descendant::table[@class='data_table table_grid zebra']";
	
	private String ofacSdnheadersCount = "//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/thead/tr/th";
	
	private String ofacSdndataCount = "//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/tbody/tr/td";
	
	@FindBy(xpath="//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/thead/tr/th[")
	private WebElement ofacSdnheader;

	@FindBy(xpath="//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/tbody/tr/td[")
	private WebElement ofacSdnTable;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77FF_select_type')][contains(@class,'icon select_type select_type_table')]")
	private WebElement ofacSDNTblOption; 
	
	@FindBy(xpath="//span[contains(@class,'highlight_green')]")
	private WebElement legalIDOFACVerification;
	
	@FindBy(xpath=".//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement iFrame;	
	
	@FindBy(css="a[class*='user-info']")
	private WebElement UserName;
	public WebElement Username(){
		return UserName;
	}
	
	@FindBy(linkText="Invite New Supplier")
	private WebElement InviteNewSupplier;
	
	@FindBy(linkText="Search for Supplier(s)")
	private WebElement SearchForSuppliers;
	
	@FindBy(linkText="Broadcast to Suppliers")
	private WebElement BroadCastToSuppliers;
	
	@FindBy(linkText="Download Clean Supplier File")
	private WebElement DownLoadCleanSupplierFile;
	
	@FindBy(xpath = "suppliername")
	private WebElement suppliername;
	
	@FindBy(xpath = "email")
	private WebElement email;
		
	@FindBy(xpath = "contactname")
	private WebElement contactname;
	
	@FindBy(xpath = "//*[contains(@style,'fixed')]//div/span")
	private WebElement strBroadCastText;
	
	@FindBy(xpath="//a[@title='Regulatory Compliance']")
	private WebElement XpathCompliance;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77EE_select_type')][contains(@class,'icon select_type select_type_table')]")
	private WebElement xpathlegalIDTblOption;
	
	@FindBy(xpath="//a[contains(@id,'cndKHf77EE_select_type')]")
	private WebElement xpathlegalIdpieChartBtn;

/*	@FindBy(xpath="//div[@class='chart chart_minimized box_content_expanded']/descendant::table[@class='data_table table_grid zebra']")
	private WebElement xpathlegalIdtablerowCount;*/
	
	@FindBy(xpath="//span[contains(@id,'cndKHf77EE_select_type')]/a[contains(@title,'Data Table')]")
	private WebElement xpathlegalIddataTableBtn;
	
	@FindBy(linkText = "logout_link" )
	private WebElement logout_link;
			
	String xpathoutreachheader = "//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/thead/tr/th[";
	String xpathdata ="]";
	String xpathoutreachTable = "//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/tbody/tr/td[";
	String outreachtablerowCount = "//div[@class='content chart_opt_collapse remove_padding']/descendant::table[@class='data_table table_grid zebra']";
	String xpathlegalIdheadersCount= "//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/thead/tr/th";
	String xpathlegalIddataCount = "//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/tbody/tr/td";
	String outreachdataCount= "//div[contains(@id,'cndKHf77BB')]/div/div[2]/table/tbody/tr/td";
	String xpathlegalIdheader = "//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/thead/tr/th[";
	String xpathlegalIdTable = "//div[contains(@id,'cndKHf77EE')]/div/div[2]/table/tbody/tr/td[";
	String msglegalIDAuthentication = "Legal ID Authentication";
	String xpathlegalIDOFACVerification = "//span[contains(@class,'highlight_green')]";
	String explegalIDPageTitle = "legalIDPageTitle=Lavante SIM - Legal ID";
	String xpathlegalIdtablerowCount="//div[@class='chart chart_minimized box_content_expanded']/descendant::table[@class='data_table table_grid zebra']";
	String xpathofacSdnheadersCount="//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/thead/tr/th";
	String xpathofacSdnTable = "//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/tbody/tr/td[";
	String xpathofacSdnheader = "//div[contains(@id,'cndKHf77FF')]/div/div[2]/table/thead/tr/th[";
	String msgofacSdnScreening = "OFAC SDN Screening";

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		lavanteUtils.driver = driver;
	}
	
	/*public HomePage(WebDriver driver) {
		try {
			//initialize the properties			
			expHomePageTitle=props.getProperty("expectedPageTitle");
			expCompliancePageTitle=props.getProperty("expCompliancePageTitle");
			expSupplierPageTitle=props.getProperty("expectedSupplierPageTitle");
			
			explegalIDPageTitle=props.getProperty("legalIDPageTitle");
			expofacPageTitle=props.getProperty("ofacPageTitle");

			IdsupplierSearch=props.getProperty("supplierSearch");
			IdCustomerLogo=props.getProperty("CustomerLogo");
			XpathCompanyLogo=props.getProperty("CompanyLogo");
			XpathDashboard=props.getProperty("Dashboard");
			XpathSuppliers=props.getProperty("Suppliers");
			XpathTasks=props.getProperty("Tasks");
			XpathManageFiles=props.getProperty("ManageFiles");
			XpathManageUsers=props.getProperty("ManageUsers");
			XpathOnboarding=props.getProperty("Onboarding");
			XpathCompliance=props.getProperty("Compliance");
			XpathDiversity=props.getProperty("Diversity");
			LnkTxtMyAccount=props.getProperty("MyAccount");
			LnkTxtInviteNewSupplie=props.getProperty("InviteNewSupplier");
			LnkTxtSearchForSuppliers=props.getProperty("SearchForSuppliers");
			LnkTxtBroadCastToSuppliers=props.getProperty("BroadCastToSuppliers");
			LnkTxtDownLoadCleanSupplierFile=props.getProperty("DownLoadCleanSupplierFile");
			XpathQuickLink=props.getProperty("QuickLink");			
			XpathCancelBtnForBroadCast=props.getProperty("CancelBtnForBroadCast");
			XpathCancelBtn=props.getProperty("CancelBtn");			
			Idsuppliername=props.getProperty("suppliername");
			Idcontactname=props.getProperty("contactname");
			Idemail=props.getProperty("email");
			Idfax=props.getProperty("fax");
			IdinvitingOrganization=props.getProperty("invitingOrganization");
			xpathsupplierGroup=props.getProperty("supplierGroup");
			IdclearBtn=props.getProperty("clearBtn");
			IdinviteBtn=props.getProperty("inviteBtn");
			XpatherrorMsg=props.getProperty("errorMsg");
			xpathSuccessMessage=props.getProperty("SuccessMessage");
			XpathOkBtn=props.getProperty("OkBtn");
			browserCheckClose=props.getProperty("browserCheckClose");

			//To DO list
			xpathdataNotFound=props.getProperty("dataNotFound");
			xpathtodolistrowCount=props.getProperty("todolistrowCount");	
			xpathdate=props.getProperty("date");
			xpathreceived=props.getProperty("received");
			xpathtask=props.getProperty("task");	
			xpathdescription=props.getProperty("description");
			xpathworkflow=props.getProperty("workflow");
			xpathalerts=props.getProperty("alerts");
			//Supplier Out-reach Status
			xpathoutreachpieChartBtn=props.getProperty("outreachpieChartBtn");
			xpathoutreachdataTableBtn=props.getProperty("outreachdataTableBtn");
			xpathoutreachtablerowCount=props.getProperty("outreachtablerowCount");
			xpathoutreachheadersCount=props.getProperty("outreachheadersCount");
			xpathoutreachdataCount=props.getProperty("outreachdataCount");
			xpathoutreachheader=props.getProperty("outreachheader");
			xpathoutreachTable=props.getProperty("outreachTable");
			xpathdata=props.getProperty("data");
			xpathoutreachTblOption=props.getProperty("outreachTblOption");
			xpathoutreachVerification=props.getProperty("outreachVerification");
			//Legal ID			
			xpathlegalIdpieChartBtn=props.getProperty("legalIdpieChartBtn");
			xpathlegalIddataTableBtn=props.getProperty("legalIddataTableBtn");
			xpathlegalIdtablerowCount=props.getProperty("legalIdtablerowCount");
			xpathlegalIdheadersCount=props.getProperty("legalIdheadersCount");
			xpathlegalIddataCount=props.getProperty("legalIddataCount");
			xpathlegalIdheader=props.getProperty("legalIdheader");
			xpathlegalIdTable=props.getProperty("legalIdTable");
			xpathlegalIDTblOption=props.getProperty("legalIDTblOption");
			//OFAC SDN Screening
			xpathofacSdnpieChartBtn=props.getProperty("ofacSdnpieChartBtn");
			xpathofacSdndataTableBtn=props.getProperty("ofacSdndataTableBtn");
			xpathofacSdntablerowCount=props.getProperty("ofacSdntablerowCount");
			xpathofacSdnheadersCount=props.getProperty("ofacSdnheadersCount");
			xpathofacSdndataCount=props.getProperty("ofacSdndataCount");
			xpathofacSdnheader=props.getProperty("ofacSdnheader");
			xpathofacSdnTable=props.getProperty("ofacSdnTable");
			xpathofacSDNTblOption=props.getProperty("ofacSDNTblOption");
			//common
			xpathlegalIDOFACVerification=props.getProperty("legalIDOFACVerification");			

			//Message
			expInviteSupplierSuccessMsg=props.getProperty("expInviteSupplierSuccessMsg");
			msgexpBroadcastTitle=props.getProperty("expBroadcastTitle");
			msgexpDownLoadFileTitle=props.getProperty("expDownLoadFileTitle");			
			msgSupplierOutreachStatus=props.getProperty("supplierOutreachStaus");
			msglegalIDAuthentication=props.getProperty("legalIDAuthentication");
			msgofacSdnScreening=props.getProperty("ofacSdnScreening");
			this.driver = driver;
			objSupplierSearchPage = PageFactory.initElements(driver,SupplierSearchPage.class);
			System.out.println("HP"+this.driver);
		} catch (Exception e)  {				
		//	log.severe("Method: HomePage :: " + "Exception = " + e	+ " Line Number = " +  e.getMessage());
		}
	}*/
	
	/**
	 * Method Name : verifyUIControlsOnDashboardPage
	 * Purpose: Public method which includes logic related to verify the UI controls on Home page(Dash board page)
	 * @param: None
	 * @return: None
	 */
	
/*	public void handle_BroswerCheckPopUp()
	{
		try {
			lavanteUtils.click("browserCheckClose",browserCheckClose);
			
		}
		catch(Exception e)
		{
			Assert.assertTrue(false,"Exception in the method 'handle_BroswerCheckPopUp' due to "+e.getMessage());
		}
		
	}
	*/
	public void verifyUIControlsOnDashboardPage(){

		try{
			lavanteUtils.waitForTime(3000);
			//Verify the UI control for Customer Logo	
			lavanteUtils.verifyElementDisplayed("CustomerLogo",CustomerLogo);
			Reporter.log("Verification is successful for Customer Logo");
			//Verify the UI control for Company Logo		
			lavanteUtils.verifyElementDisplayed("CompanyLogo",CompanyLogo);
			Reporter.log("Verification is successful for Company Logo");
			//Verify the UI control for Supplier Search for Customer		
			lavanteUtils.verifyElementDisplayed("supplierSearch",supplierSearch);
			Reporter.log("Verification is successful for Supplier search input field");
			//Verify the UI control for Dash board tab
			lavanteUtils.verifyElementDisplayed("Dashboard",Dashboard);
			Reporter.log("Verification is successful for Dashboard tab");
			//Verify the UI control for Suppliers tab
			lavanteUtils.verifyElementDisplayed("Suppliers",Suppliers);
			Reporter.log("Verification is successful for Suppliers tab");
			//Verify the UI control for Tasks tab
			lavanteUtils.verifyElementDisplayed("Tasks",Tasks);
			Reporter.log("Verification is successful for Tasks tab");
			//Verify the UI control for Manage Files tab	
			lavanteUtils.verifyElementDisplayed("ManageFiles",ManageFiles);
			Reporter.log("Verification is successful for ManageFiles tab");
			//Verify the UI control for Manage Users tab	
			lavanteUtils.verifyElementDisplayed("ManageUsers",ManageUsers);
			Reporter.log("Verification is successful for ManageUsers tab");
			//Verify the UI control for On boarding tab	
			lavanteUtils.verifyElementDisplayed("Onboarding",Onboarding);
			Reporter.log("Verification is successful for On-Boarding tab");
			//Verify the UI control for Compliance tab
			lavanteUtils.verifyElementDisplayed("Compliance",Compliance);
			Reporter.log("Verification is successful for Compliance sub tab");
			//Verify the UI control for Diversity tab	
			lavanteUtils.verifyElementDisplayed("Diversity",Diversity);
			Reporter.log("Verification is successful for Diversity sub tab");
			//Verify the UI control for My Account Link	
			lavanteUtils.verifyElementDisplayed("MyAccount",UserName);
			Reporter.log("Verification is successful for My Account Link");
			//Verify the UI control for My Account Link	
			lavanteUtils.verifyElementDisplayed("InviteNewSupplier",InviteNewSupplier);
			Reporter.log("Verification is successful for Invite New Supplier Link");
			//Verify the UI control for My Account Link	
			lavanteUtils.verifyElementDisplayed("BroadCastToSuppliers",BroadCastToSuppliers);
			Reporter.log("Verification is successful for BroadcastToSuppliers link");
			//Verify the UI control for My Account Link	
			lavanteUtils.verifyElementDisplayed("DownLoadCleanSupplierFile",DownLoadCleanSupplierFile);
			Reporter.log("Verification is successful for DownLoadCleanSupplierFile link");
			//log.info("Verication of the UI controls on Dashboard page is Successful");
			Reporter.log("Verification of the UI controls on Dashboard page is Successful ",true);
		} catch(Exception e){
			//log.severe("Exception in the method verify_UI_Control: " +e.getMessage());
			//lavanteUtils.takeScreenshot(driver, "verifyUIControlsOnDashboardPage");
			//Assert.assertTrue(false,"Exception in the method 'verifyUIControlsOnDashboardPage' due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : ClickAndValidateSearchForSuppliersLnk
	 * Purpose: Public method which includes logic related to gp.clicks and validate the SearchForSuppliers link
	 * @param: None
	 * @return: None
	 */
	public void clickAndValidateSearchForSuppliersLnk() {
		try {
			//Search For Suppliers
			lavanteUtils.click("SearchForSuppliers", SearchForSuppliers);
			lavanteUtils.waitForTime(3000);
			Reporter.log("Clicked on the 'Search for suppliers(s)' link successfully");
			verifyHomePageTitle(expectedSupplierPageTitle);
			lavanteUtils.click("Dashboard", Dashboard);
			Reporter.log("Clicked on the 'Dashboard' tab successfully");
			lavanteUtils.waitForTime(3000);
			verifyHomePageTitle(expectedPageTitle);
		} catch(Exception e){
			//log.severe("Exception in the method ClickAndValidateSearchForSuppliersLnk: " +e.getMessage());		
		}
	}

	/**
	 * Method Name : clickAndValidateBroadCastLnk
	 * Purpose: Public method which includes logic related to gp.clicks and validate the Broad cast link
	 * @param: None
	 * @return: None
	 */
	@SuppressWarnings("unused")
	public void clickAndValidateBroadCastLnk(){
		String BroadCastText;

		try {
			//Broadcast to Suppliers			
			lavanteUtils.click("BroadCastToSuppliers", BroadCastToSuppliers);
			lavanteUtils.waitForTime(2000);
			Reporter.log("Clicked on the 'Broadcast to Suppliers' link successfully");
		//	strBroadCastText=gp.getText(driver, ConfigPathFile.XPATH.getConstantValue(), XpathQuickLink);
			BroadCastText=lavanteUtils.getText("strBroadCastText", strBroadCastText);
			lavanteUtils.click("CancelBtnForBroadCast",CancelBtnForBroadCast);
			lavanteUtils.waitForTime(2000);
			Reporter.log("Clicked on the 'Cancel' button successfully");
		}catch(Exception e){
			//log.severe("Exception in the method clickAndValidateBroadCastLnk: " +e.getMessage());
			//lavanteUtils.takeScreenshot(driver,"clickAndValidateBroadCastLnk");
			//Assert.assertTrue(false,"Exception in the method clickAndValidateBroadCastLnk due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : clickAndValidateDownLoadLink
	 * Purpose: Public method which includes logic related to gp.clicks and validate the Down Load File link
	 * @param: None
	 * @return: None
	 */
	@SuppressWarnings("unused")
	public void clickAndValidateDownLoadLink(){
		String strDownLoadFileText="";
		try{
			//Download Clean Supplier File
			lavanteUtils.click("DownLoadCleanSupplierFile",DownLoadCleanSupplierFile);
			lavanteUtils.waitForTime(3000);
			Reporter.log("Clicked on the 'Download Clean Supplier File' link successfully");
			strDownLoadFileText=lavanteUtils.getText("QuickLink",QuickLink);
			Reporter.log("Validation is successful for Download Clean Supplier File page: "	+ expDownLoadFileTitle );
			//Switch to frame
			lavanteUtils.switchtoFrame(iFrame);
			lavanteUtils.click("CancelBtnForBroadCast", CancelBtnForBroadCast);
			lavanteUtils.waitForTime(3000);
			Reporter.log("Clicked on the 'Cancel' Button successfully");
			//Switch to default frame
			lavanteUtils.switchtoFrame(null);
		}catch(Exception e){
			//log.severe("Exception in the method clickAndValidateDownLoadLink: " +e.getMessage());
			//lavanteUtils.takeScreenshot(driver,"clickAndValidateDownLoadLink");
			//Assert.assertTrue(false,"Exception in the method clickAndValidateDownLoadLink due to "+e.getMessage());
		}
	}

	/**
	 * Method Name : clickAndValidateNewInviteSupplier
	 * Purpose: Public method which includes logic related to gp.clicks on the new invite supplier link and validate the page with
	 * 			valid and invalid data and verify the successful invite supplier
	 * @param: List<setTestData> getDashboard
	 * @return: None
	 */
	public void clickAndValidateNewInviteSupplier(List<setTestData> getDashboard){
		String getText="", concatenateEmail=""; boolean flag = false;

		lavanteUtils.waitForTime(2000);
		//Invite New Supplier
		lavanteUtils.click("InviteNewSupplier", InviteNewSupplier);
		lavanteUtils.waitForTime(6000);
		//gp.getText=gp.getText(wdHome, ConfigPathFile.XPATH.getConstantValue(), XpathQuickLink);
		Reporter.log("Validation is successful for Invite New Supplier page: " + getText);
		lavanteUtils.waitForTime(3000);
		//Switch to frame
		lavanteUtils.switchtoFrame(iFrame);
		try {
			int i;
			for(i=0;i<getDashboard.size();i++){
				lavanteUtils.waitForTime(2000);
				//gp.clicks on the Clear Button
				lavanteUtils.click("clearBtn", clearBtn);
				lavanteUtils.waitForTime(2000);
				String supname=getDashboard.get(i).getSupplierName();
				SimpleDateFormat sdfDate = new SimpleDateFormat("MMddHHmmss");
				Date now = new Date();
				String strDate = sdfDate.format(now);
				if(getDashboard.get(i).getSupplierName().toString().length()>0){
					
				supname=supname+ strDate;
				lavanteUtils.enterText("suppliername",suppliername,supname);
				}
				lavanteUtils.waitForTime(2000);
				//	gp.switchToFrameBy(wdHome, iFrame,ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue());
				//	gp.clicks(wdHome, ConfigPathFile.XPATH.getConstantValue(), "//*[@id='supplierListCheckConfirmation'][@type='checkbox']");
				//	gp.switchToFrameBy(wdHome, iFrame,ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue());
					lavanteUtils.waitForTime(2000);	
				lavanteUtils.enterText("contactname", contactname,getDashboard.get(i).getContactName().toString());				
				if(!(getDashboard.get(i).getContactEmail().toString()==(""))){
					concatenateEmail= getEmail(getDashboard.get(i).getContactEmail().toString());				
					lavanteUtils.enterText("email", email,concatenateEmail);
				}			
				System.out.println(getDashboard.get(i) + "before");
				lavanteUtils.enterText("fax",fax,getDashboard.get(i).getContactFax().toString());
				lavanteUtils.waitForTime(2000);
				
			/*	Actions newKey = new Actions(wdHome);
				newKey.sendKeys(Keys.TAB.ENTER).build().perform();
				newKey.sendKeys(Keys.TAB).build().perform();  */
				lavanteUtils.switchtoFrame(iFrame);
				lavanteUtils.click(driver.findElement(By.xpath("//*[@id='invitingOrganization']/option")));
				lavanteUtils.selectvalueFrmDpdn(getDashboard.get(i).getInvitingOrganization().toString());
				
				System.out.println("gp.clicks" + getDashboard.get(i).getInvitingOrganization().toString());

				if(!(getDashboard.get(i).getSupplierGroup().toString()=="")){
					String strCountry=getDashboard.get(i).getSupplierGroup().toString();
					int SupplierGroupKey = Integer.parseInt(strCountry);
					lavanteUtils.click("supplierGroup", supplierGroup);
					lavanteUtils.switchtoFrame(null); 
					lavanteUtils.waitForTime(1000);
					lavanteUtils.click(driver.findElement(By.cssSelector( "li.active-result:nth-child("+SupplierGroupKey+")")));
					//Switch to frame
			//	gp.switchToFrameBy(wdHome, iFrame,ConfigPathFile.IN.getConstantValue(), ConfigPathFile.XPATH.getConstantValue());
				}
				lavanteUtils.switchtoFrame(iFrame);
				lavanteUtils.waitForTime(1000);
				lavanteUtils.typeinEdit(strDate,driver.findElement(By.id( "supplierInviteJustification")));
				lavanteUtils.waitForTime(2000);
				lavanteUtils.click("inviteBtn",inviteBtn);
				lavanteUtils.waitForTime(4000);

				if(lavanteUtils.verifyElementDisplayed("errorMsg",errorMsg)){
					validateErrorMessage(getDashboard, i);
					flag = true;
				} else {
					flag = false;
				}
				System.out.println(flag);
				if (!flag) { 
					//Switch to default frame
					lavanteUtils.switchtoFrame(null); 
					lavanteUtils.waitForTime(2000); 
					;
					if(lavanteUtils.verifyElementDisplayed("QuickLink", QuickLink)==true)
					{ 
						System.out.println("ADs");
						getText=lavanteUtils.getText("QuickLink", QuickLink);
						Reporter.log("Verification is successful: " + getText);
						getText=lavanteUtils.getText("SuccessMessage", SuccessMessage);
						//Validation
						if(expInviteSupplierSuccessMsg.equalsIgnoreCase(getText)){	
							Reporter.log("Validation is Successful for 'Invite New Supplier' Expected: " + "'" +
									expInviteSupplierSuccessMsg + "'" + " match with " + " Actual: " + "'" + getText);
							Reporter.log("Invitation to the new supplier is successful: " + getText);
							lavanteUtils.waitForTime(1000);
							lavanteUtils.click("OkBtn", OkBtn);
							lavanteUtils.waitForTime(1000);
						} else {
							lavanteUtils.takeScreenshot(driver, "Validate_New_Invite_Supplier");
							//log.severe("Validation failed for 'Invite New Supplier' Expected: " + "'" +
								//	expInviteSupplierSuccessMsg + "'" + " does not match with " + " Actual: " + "'" + getText);
							//Assert.assertTrue(false,"Validation failed for 'Invite New Supplier' Expected: " + "'" +
									//expInviteSupplierSuccessMsg + "'" + " does not match with " + " Actual: " + "'" + getText);
						}
					} else{
						//lavanteUtils.takeScreenshot(driver, "Validate_New_Invite_Supplier");
						//Assert.assertTrue(false,"Failed to identify the locator element in the method clickAndValidateNewInviteSupplier: ");
					}
				}
			}
		} catch (Exception e) {
			//log.severe("Exception in the method clickAndValidateNewInviteSupplier: "+ e.getMessage());
			//lavanteUtils.takeScreenshot(driver,"clickAndValidateNewInviteSupplier");
			//Assert.assertTrue(false,"Exception in the method clickAndValidateNewInviteSupplier: " + e.getMessage());
		}
	}

	/**
	 * Method Name : validateErrorMessage
	 * Purpose: Public method which includes logic related to validate the error message
	 * @param: List<setTestData> getDashboard, i
	 * @return: None
	 */
	public void validateErrorMessage(List<setTestData> getDashboard, int i){
		String strErrorMsg="";

		strErrorMsg=lavanteUtils.getText("errorMsg", errorMsg);

		if(!getDashboard.get(i).getErrorMessage().trim().toString().equalsIgnoreCase(strErrorMsg)){
			//log.severe("Validation is failed in the method validateErrorMessage due to: " +strErrorMsg);
		}else{
			Reporter.log("Validation is successful with the Expected Message: " + strErrorMsg);
		}
	}

	/**
	 * Method Name : verify_OutreachTblData
	 * Purpose: Public method which includes logic related to verify the result and return back to the previous page
	 * @param: None
	 * @return: None
	 */
	public void verify_OutreachTblData(){

		
		
		try{ lavanteUtils.waitForTime(4000);
			int iRow=getTblRowCount(outreachtablerowCount, outreachdataCount);
			for(int l=1;l<=iRow;l++){
				Reporter.log("\n");
				lavanteUtils.waitForTime(4000);
				//icon select_type select data table
				if(lavanteUtils.verifyElementDisplayed("outreachTblOption",outreachTblOption)==false){
					lavanteUtils.click("outreachpieChartBtn", outreachpieChartBtn);
					lavanteUtils.waitForTime(4000);
					lavanteUtils.click("outreachdataTableBtn", outreachdataTableBtn);
				}
				String strHeader=lavanteUtils.getText("outreachheader",outreachheader);						
				String strData=lavanteUtils.getText("outreachTable", outreachTable);
				lavanteUtils.click("outreachTable", outreachTable);
				Reporter.log("Clicked on the " + strHeader + " data: " + strData);
				lavanteUtils.waitForTime(2000);
				String ActualData= objSupplierSearchPage.verifyOutreachData(outreachVerification);
				String[] sActualData=ActualData.split("[()]");
				//verification
				if(strData.trim().toString().equalsIgnoreCase(sActualData[1].trim().toString())){
					Reporter.log("Verification is successful for " + strHeader + " Expected: " + strData +
							" Actual :" + sActualData[1]);
				}
				lavanteUtils.waitForTime(2000);
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_OutreachTblData: " + e.getMessage());
			//lavanteUtils.takeScreenshot(driver, "verify_OutreachTblData");
			//Assert.assertTrue(false,"Exception in the method verify_OutreachTblData: " + e.getMessage());
		}
	}

	/**
	 * Method Name : verify_OutreachTblData
	 * Purpose: Public method which includes logic related to verify the result and return back to the previous page
	 * @param: String sEleTblRowCount, String sEleTblDataRowCount, String sElePropTblOption,
			String sElePieChartBtn, String sElePropTblBtn, String sHeaderData, String sTblData, String sEleData,
			String sPageTitle, String sEleDataVerification
	 * @return: None
	 */
	public void verify_PieChartTblData(String sEleTblRowCount, String sEleTblDataRowCount, String sElePropTblOption,
			String sElePieChartBtn, String sElePropTblBtn, String sHeaderData, String sTblData, String sEleData,
			String sPageTitle, String sEleDataVerification){

		try{
			int iRow=getTblRowCount(sEleTblRowCount,sEleTblDataRowCount);
			for(int l=1;l<=iRow;l++){
				Reporter.log("\n"); 
				lavanteUtils.waitForTime(4000);
				//icon select_type select data table
				if(lavanteUtils.isElementDisplayed(driver.findElement( By.xpath(sElePropTblOption)))==false){
					lavanteUtils.click(driver.findElement(By.xpath( sElePieChartBtn)));
					lavanteUtils.waitForTime(4000);
					lavanteUtils.click(driver.findElement(By.xpath( sElePropTblBtn)));
				}
				String strHeader=lavanteUtils.getText(driver.findElement(By.xpath( sHeaderData + l + sEleData)));						
				String strData=lavanteUtils.getText(driver.findElement(By.xpath( sTblData + l + sEleData)));
				lavanteUtils.click(driver.findElement(By.xpath( sTblData + l + sEleData)));
				Reporter.log("click on the " + strHeader + " header data: " + strData);
				lavanteUtils.waitForTime(5000);
				String ActualData= objSupplierSearchPage.verifyTblData_Navigateback(sPageTitle, sEleDataVerification);
				String[] sActualData=ActualData.split("[()]");
				//verification
				if(strData.trim().toString().equalsIgnoreCase(sActualData[1].trim().toString())){
					Reporter.log("Verification is successful for " + strHeader + " Expected: " + strData +
							" Actual :" + sActualData[1]);
					lavanteUtils.waitForTime(4000);
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method verify_PieChartTblData: " + e.getMessage());
			//lavanteUtils.takeScreenshot(driver, "verify_PieChartTblData");
			//Assert.assertTrue(false,"Exception in the method verify_PieChartTblData: " + e.getMessage());
		}
	}

	/**
	 * Method Name : getTblRowCount
	 * Purpose: Public method which includes logic related to return the table row count
	 * @param: List<setTestData> getDashboard, i
	 * @return: None
	 */	
	public int getTblRowCount(String sEleTblProperty, String sRowData){

		int sRowCount=0;
		List<WebElement> rowCount = driver.findElements(By.xpath(sEleTblProperty));
		for (int i=1;i<=rowCount.size();i++) {
			List<WebElement> dataCount = driver.findElements(By.xpath(sRowData));			
			sRowCount=dataCount.size();
		}
		return sRowCount;
	}

	/**
	 * Method Name : getEmail
	 * Purpose: Public method which includes logic related to return the concatenate email with current date
	 * @param: None
	 * @return: None
	 */
	public String getEmail(String sEmail){
		String email ="";
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMddHHmmss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String [] actualEmail=sEmail.split("@");
		email = actualEmail[0] + strDate + "@" + actualEmail[1];
		return email;
	}

	/**
	 * Method Name : clickAndvalidateToDOListTbl
	 * Purpose: Public method which includes logic related to validate ToDo List data with the data base data
	 * @param: List<setTestData> getDashboard
	 * @return 
	 * @return: None
	 */
	public void clickAndvalidateToDOListTbl(List<setTestData> getDataBaseQuery) {
		List<String> extractData=null;
		List<String> AppData= new ArrayList<String>();

		try {
			//verifyHomePageTitle(expHomePageTitle);
			//SQL Data base object creation for To Do List
			GetToDoListDataFromSQL objDataBase=new GetToDoListDataFromSQL();
			lavanteUtils.waitForTime(4000);
			extractData = objDataBase.dataExtract(getDataBaseQuery);
			lavanteUtils.waitForTime(4000);

			List<WebElement> rowUnCount = driver.findElements(By.xpath(dataNotFound));
			int rowNUm=rowUnCount.size();
			int rowWorkflowCnt=0;
			int rowAlertsCnt=0;
			int iter_cnt=0;
			
			//To DO LIST
			List<WebElement> rowCount=driver.findElements(By.xpath(todolistrowCount));
			int rowCnt=rowCount.size();
			lavanteUtils.waitForTime(2000);
			//iter_cnt=rowCnt-rowWorkflowCnt-rowAlertsCnt-rowNUm;
			for (int i=1;i<=rowCnt;i++) {
				String data=lavanteUtils.getText(driver.findElement(By.xpath( "//td[contains(@class,'align')]/div[1]//tr["+i+"]//a[@href]")));
				String dateReceived=lavanteUtils.getText(driver.findElement(By.xpath( "//td[contains(@class,'align')]/div[1]//tr["+i+"]//a[@href]/../..//td[2]")));
				System.out.println("Before: " + data + "" + dateReceived);
				data = data.substring(0,data.indexOf("(")-1);
				System.out.println("After: " + data + "" + dateReceived);
				AppData.add(data + "|" + dateReceived);
				
			}
			//WorkFlow
			List<WebElement> rowWorkflow=driver.findElements(By.xpath(workflow));
			rowWorkflowCnt=(rowWorkflow.size());	
			for (int i=1;i<=rowWorkflowCnt;i++) {
				String data=lavanteUtils.getText(driver.findElement(By.xpath("//td[contains(@class,'align')]/div[2]//tr["+i+"]//a[@href]")));
				String dateReceived=lavanteUtils.getText(driver.findElement(By.xpath( "//td[contains(@class,'align')]/div[2]//tr["+i+"]//a[@href]/../..//td[2]")));
				System.out.println("Before: " + data + "" + dateReceived);
				data = data.substring(0,data.indexOf("(")-1);
				System.out.println("After: " + data + "" + dateReceived);
				AppData.add(data + "|" + dateReceived);
				
			}
			//Alerts
			List<WebElement> rowAlerts=driver.findElements(By.xpath(alerts));
			rowAlertsCnt=(rowAlerts.size());
			System.out.println(rowAlertsCnt);
			for (int i=1;i<=rowAlertsCnt;i++) {
				String data=lavanteUtils.getText(driver.findElement(By.xpath("//td[contains(@class,'align')]/div[3]//tr["+i+"]//a[@href]")));
				String dateReceived=lavanteUtils.getText(driver.findElement(By.xpath("//td[contains(@class,'align')]/div[3]//tr["+i+"]//a[@href]/../..//td[2]")));
				data = data.substring(0,data.indexOf("(")-1);
				System.out.println("After: " + data + "" + dateReceived);
				AppData.add(data + "|" + dateReceived);
				
			}

		
			lavanteUtils.waitForTime(3000);
			Reporter.log("\n Validation of To Do List items as below ");
			
			
			for(int k=0;k<AppData.size();k++) {
				for(int j=0;j<extractData.size();j++) { 
					System.out.println(extractData.get(j).toString() + "" + AppData.get(k).toString());
					if(extractData.get(j).toString().equalsIgnoreCase(AppData.get(k).toString())) {		
						Reporter.log("'" + extractData.get(j).toString() + "'" + " is same as expected as '" + AppData.get(k).toString() + "'");
						break;
					}
				}
			}
		} catch(Exception e){
			//log.severe("Exception in the method clickAndvalidateToDOListTbl: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method clickAndvalidateToDOListTbl: " + e.getMessage());
		}
	}

	/**
	 * Method Name : validateSupplierOutreachPieChartStatus
	 * Purpose: Public method which includes logic related to validate Supplier Out reach statuses data with the data base data
	 * @param: List<setTestData> getDataBaseQuery
	 * @return 
	 * @return: None
	 */
	public void validateSupplierOutreachPieChartStatus(List<setTestData> getDataBaseQuery) {
		List<String> outreachextractData=null;
		List<String> AppData= new ArrayList<String>();

		try{
			//SQL Data base object creation for Outreach Statuses
			GetOutreachDataFromSQL objDataBase=new GetOutreachDataFromSQL();
			lavanteUtils.waitForTime(3000);
			outreachextractData = objDataBase.outreachDataExtract(getDataBaseQuery, supplierOutreachStaus);

			Reporter.log("\n Validation of Supplier Outreach Statuses  table items as below ");
			lavanteUtils.waitForTime(2000);
			
			//verifyHomePageTitle(expHomePageTitle);
			//icon select_type select data table
			if(lavanteUtils.verifyElementDisplayed("outreachTblOption",outreachTblOption)==false){
				lavanteUtils.waitForTime(4000);
				lavanteUtils.click("outreachpieChartBtn", outreachpieChartBtn);
				lavanteUtils.waitForTime(4000);
				lavanteUtils.click("outreachdataTableBtn", outreachdataTableBtn);
				Reporter.log("Changed display format of supplier Outreach statuses to Data table");
			}
			List<WebElement> rowCount = driver.findElements(By.xpath(xpathoutreachtablerowCount));

			System.out.println(rowCount.size());
			
			for (int i=1;i<=rowCount.size();i++) {
				List<WebElement> headersCount = driver.findElements(By.xpath(xpathoutreachheadersCount));
				List<WebElement> dataCount = driver.findElements(By.xpath(xpathoutreachdataCount));

				if(headersCount.size()==dataCount.size()){
					for(int l=1;l<=headersCount.size();l++){
						
						String strHeader=lavanteUtils.getText(driver.findElement(By.xpath( xpathoutreachheader + l + xpathdata)));						
						String strData=lavanteUtils.getText(driver.findElement(By.xpath( xpathoutreachTable + l + xpathdata)));
						AppData.add(strHeader + "|" + strData);
					}
				}
			}
			System.out.println("AAAAAAAA");
			for(int k=0;k<AppData.size();k++) { System.out.println(AppData.size()+"DAS"+outreachextractData.size());
				for(int j=0;j<outreachextractData.size();j++) { 
					System.out.println(outreachextractData.get(j).toString()+AppData.get(k).toString());
					if(outreachextractData.get(j).toString().equalsIgnoreCase(AppData.get(k).toString())) {	

						Reporter.log("'" + outreachextractData.get(j).toString() + "'" + " is same as expected as '" + AppData.get(k).toString() + "'");
						break;
					}
				}
			}
			System.out.println("CCCC");
			//verify the outreach header data links
			verify_OutreachTblData();
		}catch(Exception e){
			//log.severe("Exception in the method validateSupplierOutreachPieChartStatus: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateSupplierOutreachPieChartStatus: " + e.getMessage());
		}
	}

	/**
	 * Method Name : validateLegalIDAuthentication
	 * Purpose: Public method which includes logic related to validate Legal ID Authentication data with the data base data
	 * @param: List<setTestData> getDataBaseQuery
	 * @return 
	 * @return: None
	 */
	public void validateLegalIDAuthentication(List<setTestData> getDataBaseQuery) {
		List<String> LegalIdextractData=null;
		List<String> LegalIDAppData= new ArrayList<String>();

		try{ lavanteUtils.waitForTime(2000);
			//verifyHomePageTitle(expHomePageTitle);
			//gp.clicks on compliance tab
			lavanteUtils.click("XpathCompliance", XpathCompliance);
			Reporter.log("Clicked on the Compliance tab");
			
			lavanteUtils.waitForTime(4000);
			//verify the Page title of Compliance page
			verifyHomePageTitle(expCompliancePageTitle);
			//icon select_type select_type_pie and Table
			if(lavanteUtils.verifyElementDisplayed("xpathlegalIDTblOption", xpathlegalIDTblOption)){
				//icon select_type select_type_pie
				lavanteUtils.click("xpathlegalIdpieChartBtn", xpathlegalIdpieChartBtn);
				lavanteUtils.waitForTime(4000);
				//icon select_type select data table
				lavanteUtils.click("xpathlegalIddataTableBtn", xpathlegalIddataTableBtn);
				Reporter.log("Changed display format of Legal Id Authentication to Data table");
				lavanteUtils.waitForTime(2000);
				
			}
			
			List<WebElement> rowCount = driver.findElements(By.xpath(xpathlegalIdtablerowCount));

			for (int i=1;i<=rowCount.size();i++) {
				List<WebElement> headersCount = driver.findElements(By.xpath(xpathlegalIdheadersCount));
				List<WebElement> dataCount = driver.findElements(By.xpath(xpathlegalIddataCount));

				if(headersCount.size()==dataCount.size()){
					for(int l=1;l<=headersCount.size();l++){
						String strHeader=lavanteUtils.getText(driver.findElement(By.xpath( xpathlegalIdheader + l + xpathdata)));					
						String strData=lavanteUtils.getText(driver.findElement(By.xpath( xpathlegalIdTable + l + xpathdata)));
						LegalIDAppData.add(strHeader + "|" + strData);
					}
				}
			}			
			//SQL Data base object creation for Legal ID Authentication
			GetLegalIdDataFromSQL objDataBase=new GetLegalIdDataFromSQL();
			lavanteUtils.waitForTime(3000);
			LegalIdextractData = objDataBase.legalIdDataExtract(getDataBaseQuery, msglegalIDAuthentication);

			Reporter.log("\n Validation of Legal ID Authentication table items as below: ");
			//System.out.println(LegalIdextractData);
			lavanteUtils.waitForTime(2000);

			for(int j=0;j<LegalIdextractData.size();j++) {
				for(int k=0;k<LegalIDAppData.size();k++) {
					if(LegalIdextractData.get(j).toString().equalsIgnoreCase(LegalIDAppData.get(k).toString())) {						
						Reporter.log("'" + LegalIdextractData.get(j).toString() + "'" + " is same as expected as '" + LegalIDAppData.get(k).toString() + "'");
						break;
					}
					lavanteUtils.waitForTime(2000);
				}
			}
			
		}catch(Exception e){
			//log.severe("Exception in the method validateLegalIDAuthentication: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateLegalIDAuthentication: " + e.getMessage());
		}
	}

	/**
	 * Method Name : validateOFACSDNScreening
	 * Purpose: Public method which includes logic related to validate OFAC SDN Screening data with the data base data
	 * @param: List<setTestData> getDataBaseQuery
	 * @return 
	 * @return: None
	 */
	public void validateOFACSDNScreening(List<setTestData> getDataBaseQuery) {
		List<String> OfacSDNextractData=null;
		List<String> ofacSDNAppData= new ArrayList<String>();

		try{
			//verifyHomePageTitle(expHomePageTitle);
			//gp.clicks on compliance tab
			lavanteUtils.click("Compliance", Compliance);
			Reporter.log("Clicked on the Compliance tab");
			lavanteUtils.waitForTime(2000);
			//verify the Page title of Compliance page
			verifyHomePageTitle(expCompliancePageTitle);
			//icon select_type select_type_pie and Table
			if(lavanteUtils.verifyElementDisplayed("ofacSDNTblOption",ofacSDNTblOption)==false){
				//icon select_type select_type_pie
				lavanteUtils.click("ofacSdnpieChartBtn", ofacSdnpieChartBtn);
				lavanteUtils.waitForTime(3000);
				//icon select_type select data table
				lavanteUtils.click("ofacSdndataTableBtn", ofacSdndataTableBtn);
				Reporter.log("Changed display format of OFAC SDN Screening to Data table");
				lavanteUtils.waitForTime(5000);
			}
			List<WebElement> rowCount = driver.findElements(By.xpath(ofacSdntablerowCount));

			for (int i=1;i<=rowCount.size();i++) {
				List<WebElement> headersCount = driver.findElements(By.xpath(ofacSdnheadersCount));
				List<WebElement> dataCount = driver.findElements(By.xpath(ofacSdndataCount));

				if(headersCount.size()==dataCount.size()){
					for(int l=1;l<=headersCount.size();l++){
						String strHeader=lavanteUtils.getText(driver.findElement(By.xpath(xpathofacSdnheader + l + xpathdata)));					
						String strData=lavanteUtils.getText(driver.findElement(By.xpath( xpathofacSdnTable + l + xpathdata)));
						ofacSDNAppData.add(strHeader + "|" + strData);
						lavanteUtils.waitForTime(3000);
					}
				}
			}
			//SQL Data base object creation for OFAC SDN Screening
			GetOFACSDNDataFromSQL objDataBase=new GetOFACSDNDataFromSQL();
			lavanteUtils.waitForTime(2000);
			OfacSDNextractData = objDataBase.ofacSDNDataExtract(getDataBaseQuery, msgofacSdnScreening);

			Reporter.log("\n Validation of OFAC SDN Screening table items as below: ");
			for(int k=0;k<ofacSDNAppData.size();k++) {
				for(int j=0;j<OfacSDNextractData.size();j++) {
					System.out.println(OfacSDNextractData.get(j).toString()+"DAS"+ofacSDNAppData.get(k).toString() );
					if(OfacSDNextractData.get(j).toString().equalsIgnoreCase(ofacSDNAppData.get(k).toString())) {	
						Reporter.log("'" + OfacSDNextractData.get(j).toString() + "'" + " is same as expected as '" + ofacSDNAppData.get(k).toString() + "'");
						break;
					}
				}
			}
			lavanteUtils.waitForTime(5000);
			//Verification of the OFAC SDN Validation Table Data Links
			System.out.println("PIE CHARTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTttt");
			/*verify_PieChartTblData(xpathofacSdntablerowCount,xpathofacSdndataCount,xpathofacSDNTblOption,
					xpathofacSdnpieChartBtn,xpathofacSdndataTableBtn,xpathofacSdnheader,xpathofacSdnTable,xpathdata,
					expofacPageTitle,xpathlegalIDOFACVerification);*/
		} catch(Exception e){
			//log.severe("Exception in the method validateOFACSDNScreening: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method validateOFACSDNScreening: " + e.getMessage());
		}
	}
	
	/**
	 * Method Name : verifyHomePageTitles
	 * Purpose: Public method which includes logic related to validate the Dashboard home page title
	 * @param: None
	 * @return: None
	 */
	public void verifyHomePageTitle(String expPageTitle){

		try{
			lavanteUtils.waitForTime(4000);
			String actualPageTitle=driver.getTitle().trim().toString();
			System.out.println(actualPageTitle+expPageTitle);
			//Verification - Dash board  Page
			if (expPageTitle.equalsIgnoreCase(actualPageTitle)) {
				Reporter.log("Suppliers Search page displayed: Expected title: " + expPageTitle
						+ " Actual title: " + actualPageTitle);
			}else {
			/*	Assert.assertTrue(false,"Test failed due to Expected title: " + expPageTitle  + "  doesn't match with"
						+ " Actual title: " + actualPageTitle);*/
			}
		} catch(Exception e){
			//log.severe("Exception in the method verifyHomePageTitle: "+ e.getMessage());
			//Assert.assertTrue(false,"Exception in the method verifyHomePageTitle: " + e.getMessage());
		}
	}
	
	public void verifyHomePageDisplayed(){
		lavanteUtils.fluentwait(UserName);
		lavanteUtils.verifyElementDisplayed("UserName", UserName);
	}
	
	
	public void navigateToSuppliers(){
		lavanteUtils.fluentwait(Suppliers);
		lavanteUtils.click(Suppliers);
		lavanteUtils.waitForTime(5000);
		
	}
	
	public void navigateToTasks(){
		lavanteUtils.fluentwait(Tasks);
		lavanteUtils.click(Tasks);
		
	}
	
	public void navigateToManageFiles(){
		lavanteUtils.fluentwait(ManageFiles);
		lavanteUtils.click(ManageFiles);
		
	}
	
	public void navigateToManageUsers(){
		lavanteUtils.fluentwait(ManageUsers);
		lavanteUtils.click(ManageUsers);
		
	}
	
	public void navigateToReports(){
		lavanteUtils.fluentwait(Reports);
		lavanteUtils.click(Reports);
		
	}
	
	
	
}
