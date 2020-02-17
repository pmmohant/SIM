/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy/ Venkata Ravi Majjari
 */


package com.lavante.sim.Common.Util;

import java.io.File;
import java.io.IOException;

public enum ConfigPathFile {

	//WeElement Names
	ID("id"),XPATH("xpath"),CLASSNAME("className"),CSS("css"),NAME("name"),HTML("html"),LINKTEXT("linkText"),PARTIALLINKTEXT("partialLinkText"),
	TAGNAME("tagName"),IN("in"),PST("PST"),MST("MST"),CST("CST"),EST("EST"),OPTION("option"),TITLE("Title"),URL("URL"),BACKPAGE("backpage"),
	FORWARDPAGE("forwardpage"),REFRESH("refresh"),INDEX("index"),TD("td"),ACCEPT("accept"),

	//Common Values for comparing
	None("None"),value("value"),YES("yes"),Quebec("Quebec"),Contains("Contains"),checkBox("checkBox"),Complete("Complete"),
	COMPLETED("Completed"),APPROVED("Approved"),PROFILECOMPLETE("Profile Complete"),OTHERACTION("Other Action"),
	MOVETOPROFILECOMPLETE("Move To Profile Complete"),PROFILE("Profile"),EDITPROFILE("Edit Profile"),TESTMESSAGE("Test"),
	BASICSEARCH("Basic Search"),ADVANCESEARCH("Advanced Search"),TAKECONTROL("Take Control"), DOWNLOADDOCUMENTS("DownLoad Documents"),
	UNKNOWNTEXTMESSAGE("Unknown"),FILENAME("VMF_With_Without_LegalID.csv"),FILENAMECOLHEADER("File Name"),SupplierNAME("Supplier Name"),
	LISTFIRSTSUPPLIER("LISTFIRSTSUPPLIER"),
	//TABs in Supplier Details pop-up
	Status_and_History("Status and History"),Supplier_Managed("Supplier Managed"),Enterprise_Owned("Enterprise-Owned"),
	//sub-TABs in supplier details Pop up
	Required_Fields("Required Fields"),Outreach_History("Outreach History"),Profile_n_Approval_History("Profile n Approval History"),Change_Log("Change Log"),Certifications("Certifications"),
	Notes_n_Comments("Notes & Comments"),
	//actions to be performed in TASKS approval page
	Approve("Approve"),Reject("Reject"),Reassign("Reassign"),EditProfile("Edit Profile"),AddSuppID("AddSuppID"),
	Read("read"),NoDelegate("No Delegate"),EditProf("EditProf"),
	Profileapproval("Post Profile Complete Approval Workflow for New Suppliers"),NO("No"),FieldName("Field Name"),
	NewSupplierInvite("New supplier invite approval"),
	
	
	//Country Names
	USA("United States of America"),Canada("Canada"),NonUS("NonUS"),SelectCountry("Select Country"),Click("Click"),

	//Sheet Names
	UserCredentials("UserCredentials"),DASHBOARD("Dashboard"),LoginForResetPassword("LoginForResetPassword"),RESETPWD("ResetPassword"),
	Login("Login"),MyAccountTimeZoneUITest("MyAccTimeZone_UI_Control"),ChangeLanguageForSupplier("ChangeLanguageForSupplier"),ChangeLanguageForCustomer("ChangeLanguageForCustomer"),MANAGEUSERS("ManageUsers"),
	MANAGEADDRESS("ManageAddress"),SUPPLIERS("Suppliers"),validateMandateFields("validateMandateFields"),SupplierSubject("SupplierSubject"),
	DBQUERY("DatabaseQuery"),SUPPLIERSEARCH("Search"),CountryNames("CountryNames"),FieldLabelNames("FieldLabelNames"),
	ValidateFieldErrMsgs("ValidateFieldErrMsgs"),SupplierRegistration("SupplierRegistration"),validateAddresses("validateAddresses"),ViewProfile("ViewProfile"),
	RequiredFieldLists("RequiredFieldLists"),ViewProfileTabs("ViewProfileTabs"),LegalIDOptions("LegalIDOptions"),InActiveStatus("InActiveStatus"),
	WithLegalIDOptions("WithLegalIDOptions"),EditSupProfile("EditSupProfile"),ProfileTabLists("ProfileTabLists"),
	CompanyProfileDetails("CompanyProfileDetails"), Invite("invite"),InviteDecline("InviteDecline"),AddNewBtnOption("AddNewBtnOption"),
	ESignature("ESignature"),VerifyProfileDetails("VerifyProfileDetails"), CustomerProfileDetails("CustomerProfileDetails"),
	ADVANCESUPPLIERSEARCH("AdvanceSearch"),custsupnotifTC0001("custsupnotifTC0001"), OFACValidations("OFACValidations"),OIGValidations("OIGValidations"),SAMValidations("SAMValidations"),
	InviteAccept("inviteAccept"),VALIDATEREGISTRATION("validateRegistration"),DATEFIELD("DateField"),TimeZones("TimeZones"),
	SUPPLIERHOMEPAGEDETAILS("SupplierHomePageDetails"),UPLOADFILES("UploadFiles"),DOWNLOADFILES("DownLoadFiles"),
	VMFFILESHEETNAME("VMF_FILE_With_Without_LegalID"),PRESCREENING("PreScreening"),DBQueryWithLegalID("DBQueryWithLegalID"),
	DBQueryNoLegalID("DBQueryNoLegalID"),DBQueryAll("DBQueryAll"),ReassignTasks("ReassignTasks"),ReassignUser("ReassignUser"),
	AddSupplierMultiple("AddSupplierMultiple"),AddSupplierID("AddSupplierID"),AddExistingSupplierID("AddExistingSupplierID"),InsuranceInformation("InsuranceInformation"),CustomerLogin("CustomerLogin"),
	InviteSupplierTasks("InviteSupplierTasks"),UserLogin("UserLogin"),SanityLogin("SanityLogin"),
	
	GmailLogin("GmailLogin"),SearchDeclinedSupplier("SearchDeclinedSupplier"),ApprovalTasks("ApprovalTasks"),invite1("invite1"),invite2("invite2"),Registration_n_AccountSetup1("Registration_n_AccountSetup1"),
	Registration_n_AccountSetup2("Registration_n_AccountSetup2"),SupplierProfileInfo1("SupplierProfileInfo1"),SupplierProfileInfo2("SupplierProfileInfo2"),
	//recovery customer
	SearsCustomerInvite("SearsCustomerInvite"),RecoverySupplier("RecoverySupplier"),	
	EXPIREDUSERCREDENTIALS("ExpiredUserLoginQuery"),DEACTIVATEDSUPPLIER("DeactivatedUserCredentials"),MANAGEFILES("ManageFiles"),
	//approvaltasks sheets
	ProfileDataChange("ProfileDataChange"),SupplierProfileInfo("SupplierProfileInfo"),Registration_n_AccountSetup("Registration_n_AccountSetup"),SupplierLogin("SupplierLogin"),
	//ColumnName
	ExecuteTests("ExecuteTests"),UserName("UserName"),Password("Password"),CurrentPassword("CurrentPassword"),NewPassword("NewPassword"),
	ConfirmPassword("ConfirmPassword"),SupplierName("SupplierName"),ContactName("ContactName"),ContactFax("ContactFax"),
	ContactEmail("ContactEmail"),InvitingOrganization("InvitingOrganization"),SupplierGroup("SupplierGroup"),
	ErrorMessage("ErrorMessage"),Language("Language"),ExpLanguageText("ExpLanguageText"),UserDetails("UserDetails"),
	NewUserName("Name"),NewEmail("Email"),UpdatedUserName("UpdatedUserName"),ADDRESS("Address1"),CITY("City"),COUNTRY("Country"),
	COUNTRYKEY("CountryKey"),STATE("State"),STATEKEY("Statekey"),POSTALCODE("PostalCode"),UpdatedAddress("UpdatedAddress"),PreferredLanguage("PreferredLanguage"),
	SetPassword("SetPassword"),ChallengeQ("ChallengeQ"),ChallengeA("ChallengeA"),TermsCheckBox("TermsCheckBox"),ExistingSupplierName("ExistingSupplierName"),
	TODOLISTQUERY("ToDoList"),LEGALIDQUERY("LegalID"),OUTREACHQUERY("Outreach"),OFACSDNQUERY("OfacSDN"),PROFILESTATUS("ProfileStatus"),
	ExpFieldLabelNames("ExpFieldLabelNames"),ACTIVATION("Activation"),DEACTIVATION("Deactivation"),BusinessName("BusinessName"),
	TaxID("TaxID"),Department("Department"),Province("Province"),GST("GST"),QST("QST"),SupplierLocation("SupplierLocation"),All("All"),Valid("Valid"),
	InValid("InValid"),Pending("Pending"),CannotBeValidated("CannotBeValidated"),SENDEMAILSTATUS("SendEmailStatus"),PaymentInfo("PaymentInfo"),
	FROM("From"),KEYVALUE("KeyValue"),SUBJECT("Subject"),BODYMESSAGE("BodyMessage"),REINVITESTATUS("ReInviteStatus"),CommentType("CommentType"),
	getWebElements("WebElements"),Comment("Comment"),OUTREACHSTATUS("OutreachStatus"),SUPPLIERPROFILE("SupplierProfileCompleteStatus"),
	TAXIDNUMBER("TaxIDNumberKey"),LEGALIDDOC("LegalIDDocKey"),PRIVATEPUBLICQUERY("PrivatePublicProfileStage"),QUERYNAME("QueryName"),
	INVITEDBYEMAIL("InvitedByEmail"),INVITEDBYKEY("InvitedKey"),APPROVEDKEY("ApprovedKey"),APPROVEDNAME("ApprovedName"),
	NoLegalID("NoLegalID"),AutoValidated("AutoValidated"),Mismatch("Mismatch"),PendingValidation("PendingValidation"),ManuallyValidated("ManuallyValidated"),
	ExpProfileTabList("ExpProfileTabList"),ButtonValidations("ButtonValidations"),Buttons("Buttons"),Comments("Comments"),CUSTOMERTAKECONTROLSTATUS("CustTakeControlStatus"),
	CONTACTEMAILVMFOUTREACH("ContactEmailVMFOutreachStatus"),AcceptDeclineSupplierName("AcceptDeclineSupplierName"),ChosenID("ChosenID"),JobTitle("JobTitle"),
	TabNames("TabNames"),PROFILESTAGE("ProfileStage"),RandomNum("RandomNum"),AcceptInvite("AcceptInvite"),DeclineInvite("DeclineInvite"),
	Description("Description"),Code("Code"),DROPDOWNVALUE("DropDownValue"),DROPDOWNKEY("DropDownKey"),INSURANCEOPTION("InsuranceOption"),
	INSURANCEOPTIONKEY("InsuranceOptionkey"),PRODUCTANDSERVICES("ProductsAndServices"),PRODUCTANDSERVICESKEY("ProductsAndServicesKey"),
	ProfileSubTabNames("ProfileSubTabNames"),GEOGRAPHICALSERVICESCOPE("GeographicalServiceScope"),CURRENCY("Currency"),
	BUSINESSETHICSPOLICY("BusinessEthicsPolicy"),FOREIGNTAX("ForeignTax"),OPERATIONNAME("OperationName"),PHONE("Phone"),CountRadio("Count Radio"),
	UPDATEDONDATEOPTION("UpdatedOnDateOption"),UPDATEDONDATE("UpdatedOnDate"),UPDATEDONKEY("UpdatedOnDateKey"),
	ADDPROFILEDETAILS("AddProfileDetails"),CUSTOMERNAME("CustomerName"),PAYMENTTERMS("PaymentTerms"),ABANUMBER("ABANumber"),ACNUMBER("ACNumber"),
	PAYEENAME("PayeeName"),BANKNAME("BankName"), PAYMENTTYPE("PaymentType"),
	EFTTERMS("EFTTerms"),LATESTPROFILEUPDATEDATE("LatestProfileUpdateDate"),LATESTPROFILEDAYS("LatestProfileDays"),DATEOPTION("DateOption"),
	APPROVEDDATEOPTION("ApprovedDateOption"), APPROVEDDATE("ApprovedDate"),APPROVEDDATEKEY("ApprovedDateKey"),APPROVEDDAYS("ApprovedDays"),
	PAYMENTDISCOUNT("PaymentDiscount"), ADDRESSTYPE("AddressType"), PROFILECOMPLETEDATEOPTION("ProfileCompleteDateOption"),
	PROFILECOMPLETEDATE("ProfileCompleteDate"), PROFILECOMPLETEDATEKEY("ProfileCompleteDateKey"), PROFILEDAYS("ProfileDays"),
	INVITEDONDATEOPTION("InvitedOnDateOption"),INVITEDONDATE("InvitedOnDate"),INVITEDONDATEKEY("InvitedOnDatekey"),INVITEDONDAYS("InvitedOnDays"),
	SMALLBUSINESSDATEOPTION("SmallBusinessDateOption"),SMALLBUSINESSDATE("SmallBusinessDate"),SMALLBUSINESSDATEKEY("SmallBusinessDatekey"),
	SMALLBUSINESSDAYS("SmallBusinessDays"),MINORITYBUSINESSDATEOPTION("MinorityBusinessDateOption"), MINORITYBUSINESSDATE("MinorityBusinessDate"),
	MINORITYBUSINESSDATEKEY("MinorityBusinessDatekey"),MINORITYBUSINESSDAYS("MinorityBusinessDays"),
	TimeZoneAbbreviation("TimeZoneAbbreviation"),Region("Region"),FILETYPE("FileType"),SupplierID("SupplierID"),
	DATATOBEDOWNLOADED("DataToBeDownloaded"),DATACHANGEDATE("DataChangeDate"),DBQueryForNonUS("DBQueryForNonUS"),
	DBQueryForUS("DBQueryForUS"),DBQueryForEU("DBQueryForEU"),DBQueryForOthers("DBQueryForOthers"),DBQueryForCanada("DBQueryForCanada"),
	PRESCREENINGENABLE("PreScreenEnable"),

	//recovery customer
	RecoverySubject("RecoverySubject"),RecoveryCustomer("RecoveryCustomer"),MissingTabs("MissingTABS"),

	calendarmonth("Calendarmonth"),calendardays("CalendarDays"),calendardate("Calendardate"),
	//to be added

	ActionType("Action Type"),ActionTaken("Action Taken"),Actor("Actor"),Action_data_n_time("Action Date and Time"),ReasignUserName("ReassignUserName"),ReassignUserGrp("ReassignUsrGrp"),
	ReassignUserNameID("ReassignUserNameID"),ReassignUserPassword("ReassignUserPassword"),
	ReassignSubject("ReassignSubject"),HaveInsurance("HaveInsurance"),InsuranceInfoProvided("InsuranceInfoProvided"),policyType("Policy Type"),InsuranceExpiryDate("Expiration Date"),Date("Date"),
	InsuranceCertificateUploaded("InsuranceCertificateUploaded"),CustomerName("CustomerName"),
	oldValue("OldValue"),newValue("NewValue"),DetailAppearsForApproval("DetailAppearsForApproval"),UserNameSupplier("UserNameSupplier")
	,InviteAppearsForApproval("InviteAppearsForApproval"),
	
	
	//Path for Properties File
	//Commented -It may affect need to recheck 
	
	/*	BrowserPropsFile("./src/test/resources/config/browserconfig.properties"),
	LoginPropsFile("./src/test/resources/object_repository/loginPage.properties"),
	RecoveryPropsFile("./src/test/resources/object_repository/recoveryPage.properties"),
	ForgotPasswordPropsFile("./src/test/resources/object_repository/forgotpasswordPage.properties"),
	NotRegisteredPropsFile("./src/test/resources/object_repository/notregisteredPage.properties"),
	DigCertPropsFile("./src/test/resources/object_repository/digcertPage.properties"),
	McafeePropsFile("./src/test/resources/object_repository/mcafeePage.properties"),
	HomePropsFile("./src/test/resources/object_repository/homePage.properties"),
	GmailPropsFile("./src/test/resources/object_repository/gmail.properties"),
	SimAccSetupPropsFile("./src/test/resources/object_repository/simAccSetupPage.properties"),
	MyAccountPropsFile("./src/test/resources/object_repository/myAccountPage.properties"),	
	ManageUsersPropsFile("./src/test/resources/object_repository/manageusersPage.properties"),
	ManageFilesPropsFile("./src/test/resources/object_repository/managefilesPage.properties"),
	SupplierSearchPropFile("./src/test/resources/object_repository/suppliersearchPage.properties"),
	SimAccRegistrationPropsFile("./src/test/resources/object_repository/simAccRegistrationPage.properties"),
	CustSupViewProfilePropsFile("./src/test/resources/object_repository/custSupViewProfilePage.properties"),
	validateAddressPropsFile("./src/test/resources/object_repository/validateAddressPage.properties"),
	legalIDValidationPropsFile("./src/test/resources/object_repository/legalIDValidationPage.properties"),
	SupplierPropsFile("./src/test/resources/object_repository/SupplierProfilePage.properties"),
	AdvanceSearchPropsFile("./src/test/resources/object_repository/advanceSearchPage.properties"),
	OFACValidationsPropsFile("./src/test/resources/object_repository/validateOFACPage.properties"),
	OIGValidationsPropsFile("./src/test/resources/object_repository/validateOIGPage.properties"),
	SAMPagePropsFile("./src/test/resources/object_repository/validateSAMPage.properties"),
	TasksApprovalsPropsFile("./src/test/resources/object_repository/taskApprovalPage.properties"),
	AddSupplierIDTasksPage("./src/test/resources/object_repository/addSupplierIDPage.properties"),*/

	//Path for Test Data workbook
	TestDataForMyAccResetPassword(filePath()+"MyAccResetPassword.xls"),
	TestDataForMyAccTimeZoneUIControl(filePath()+"MyAccTimeZone_UI_Control.xls"),
	TestDataForGmail(filePath()+"GmailTestData.xls"),
	TestDataForSupplierAccSetup(filePath()+"SupplierAccSetup.xls"),
	DashboardTestDataFile(filePath()+"DashboardTestdata.xls"),
	ManageUsersTestDataFile(filePath()+"ManageUsers.xls"),
	ManageFilesTestDataFile(filePath()+"ManageFiles.xls"),
	SupplierSearchTestDataFile(filePath() +"SupplierSearch.xls"),
	AdvanceSearchTestDataFile(filePath() +"AdvanceSearch.xls"),
	TestDataForLanguageValidate(filePath() +"LanguageValidate.xls"),
	TestDataForMultipleUserLogins(filePath() +"MultipleUserLogins.xls"),
	TestDataForSimRegistration(filePath() +"SimRegistration.xls"),
	TestDataForValidateAddresses(filePath() +"ValidateAddresses.xls"),
	TestDataForCustSupViewProfile(filePath() +"CustSupViewProfile.xls"),
	TestDataForLegalIDValidation(filePath() +"LegalIDValidation.xls"),
	TestDataForSupplierProfile(filePath() +"SupplierProfile.xls"),
	TestDataForInviteNewSupplier(filePath() +"InviteNewSupplier.xls"),
	TestDataIntegration(filePath() +"SuppliersMasterData.xls"),
	TestDataForCustomerSupplierNotif(filePath() +"CustSupNotif.xls"),
	TestDataForCustomerSupplierTasks(filePath() +"CustomerSupplierTasks.xls"),
	TestDataForAddSupplierIDs(filePath() +"AddSupplierIDs.xls"),
	TestDataForInviteApproval(filePath() +"InviteApproval.xls"),
	TestDataForVMFFILE(filePath() +"VMF_With_without_LegalID.xls"),
	TestDataForPreScreening(filePath() +"PreScreeningTestData.xls"),
	SanityTestDataFile(filePath() +"SanityTest.xls"),

	//Path for Upload Documents and other files
	W9File("C:\\LavanteDrivers\\W-9.pdf"),
	//VMF FIle with Legal ID
	VMFFile("C:\\LavanteDrivers\\VMF_With_Without_LegalID.csv"),
	//Auto IT
	WinPopupFile("C:\\LavanteDrivers\\Download_Popup_Template.exe");

	private String statusCode;

	private ConfigPathFile(String s) 
	{
		statusCode = s;
	}

	public String getConstantValue() 
	{
		return statusCode;
	}
	
	public  static String filePath()  {
		File directory = new File(".");
		String x="";
		try {
			System.out.println("Get Present" + directory.getCanonicalPath());
			x=directory.getCanonicalPath() + File.separator + System.getProperty("TestData") + File.separator + "data"+ File.separator ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}


}
