/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy/ Venkata Ravi Majjari
 */

package com.lavante.sim.Common.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.lavante.sim.Common.Util.ConfigPathFile;

public class GetExcelFile {
	static Vector<String> headers = new Vector<String>();
	static Vector<String> data = new Vector<String>();


	static int noOfRecordsToBeTested=0;
	//TestDataMethod
	public  List <setTestData> getData(String testDataPath, String sheetName){
		List <setTestData> objListOfTDAddJobIds = new ArrayList<setTestData>();
		int columnIndex = 0, sizeofHeaders = 0;
		String columnName = "", dataValue = "";
		setTestData objTDAddJobIds = new setTestData();
		// log.info("Method:GetTestData :: getTestData = " + testDataPath	+ " sheetname = " + sheetName);
		try {
			headers = fetchTableHeaderColumn(testDataPath,sheetName);
			data = fetchTableData(testDataPath,sheetName);
			noOfRecordsToBeTested = data.size();
			sizeofHeaders = headers.size();
			if (noOfRecordsToBeTested > 0 && sizeofHeaders > 0 ) {
				for (int row = 0; row < noOfRecordsToBeTested ; row++)	{
					columnName = headers.get(columnIndex).toString().trim();
					dataValue = data.get(row).toString();				
				/*	System.out.println("COL:"+columnName);
					System.out.println("DATA:"+dataValue);
				*/	
					if(dataValue.equalsIgnoreCase("English (United States)"))
					{
						//System.out.println("SEP");
					}
					if (columnName != null){
						if(columnName.equals(ConfigPathFile.ExecuteTests.getConstantValue()))				
							objTDAddJobIds.setExecutetest(dataValue);
						else if(columnName.equals(ConfigPathFile.UserName.getConstantValue()))							
							objTDAddJobIds.setUserName(dataValue);
						else if(columnName.equals(ConfigPathFile.Password.getConstantValue()))					
							objTDAddJobIds.setPassword(dataValue);
						else if(columnName.equals(ConfigPathFile.CurrentPassword.getConstantValue()))						
							objTDAddJobIds.setCurrentPassword(dataValue);
						else if(columnName.equals(ConfigPathFile.NewPassword.getConstantValue()))					
							objTDAddJobIds.setNewPassword(dataValue);
						else if(columnName.equals(ConfigPathFile.ConfirmPassword.getConstantValue()))				
							objTDAddJobIds.setConfirmPassword(dataValue);
						else if(columnName.equals(ConfigPathFile.Language.getConstantValue()))							
							objTDAddJobIds.setLanguage(dataValue);
						else if(columnName.equals(ConfigPathFile.INDEX.getConstantValue()))							
							objTDAddJobIds.setIndex(dataValue);
						else if(columnName.equals(ConfigPathFile.ExpLanguageText.getConstantValue()))							
							objTDAddJobIds.setExpLanguageText(dataValue);
						else if(columnName.equals(ConfigPathFile.UserDetails.getConstantValue()))							
							objTDAddJobIds.setUserDetails(dataValue);
						//Gmail Test Data Columns
						else if(columnName.equals(ConfigPathFile.PreferredLanguage.getConstantValue()))							
							objTDAddJobIds.setPreferredLanguage(dataValue);
						else if(columnName.equals(ConfigPathFile.SetPassword.getConstantValue()))							
							objTDAddJobIds.setSetPassword(dataValue);
						else if(columnName.equals(ConfigPathFile.ChallengeQ.getConstantValue()))							
							objTDAddJobIds.setChallengeQ(dataValue);
						else if(columnName.equals(ConfigPathFile.ChallengeA.getConstantValue()))							
							objTDAddJobIds.setChallengeA(dataValue);
						else if(columnName.equals(ConfigPathFile.TermsCheckBox.getConstantValue()))							
							objTDAddJobIds.setTermsCheckBox(dataValue);
						else if(columnName.equals(ConfigPathFile.AcceptDeclineSupplierName.getConstantValue()))							
							objTDAddJobIds.setAcceptDeclineSupplierName(dataValue);
						//EFT Columns
						else if(columnName.equals(ConfigPathFile.ABANUMBER.getConstantValue()))							
							objTDAddJobIds.setaBANumber(dataValue);
						else if(columnName.equals(ConfigPathFile.ACNUMBER.getConstantValue()))							
							objTDAddJobIds.setaCNumber(dataValue);
						else if(columnName.equals(ConfigPathFile.PAYEENAME.getConstantValue()))							
							objTDAddJobIds.setPayeeName(dataValue);
						else if(columnName.equals(ConfigPathFile.BANKNAME.getConstantValue()))							
							objTDAddJobIds.setBankName(dataValue);
						else if(columnName.equals(ConfigPathFile.PAYMENTTERMS.getConstantValue()))							
							objTDAddJobIds.setPaymentTerms(dataValue);



						//Add New..
						else if(columnName.equals(ConfigPathFile.ChosenID.getConstantValue()))							
							objTDAddJobIds.setChosenID(dataValue);
						else if(columnName.equals(ConfigPathFile.JobTitle.getConstantValue()))							
							objTDAddJobIds.setJobTitle(dataValue);
						else if(columnName.equals(ConfigPathFile.TabNames.getConstantValue()))							
							objTDAddJobIds.setTabNames(dataValue);
						else if(columnName.equals(ConfigPathFile.ProfileSubTabNames.getConstantValue()))							
							objTDAddJobIds.setProfileSubTabNames(dataValue);
						//AddNew Btn
						else if(columnName.equals(ConfigPathFile.Code.getConstantValue()))							
							objTDAddJobIds.setCode(dataValue);
						else if(columnName.equals(ConfigPathFile.Description.getConstantValue()))							
							objTDAddJobIds.setDescription(dataValue);
						else if(columnName.equals(ConfigPathFile.ExistingSupplierName.getConstantValue()))							
							objTDAddJobIds.setExistingSupplierName(dataValue);
						else if(columnName.equals(ConfigPathFile.ExpFieldLabelNames.getConstantValue()))							
							objTDAddJobIds.setExpFieldLabelNames(dataValue);
						else if(columnName.equals(ConfigPathFile.BusinessName.getConstantValue()))							
							objTDAddJobIds.setBusinessName(dataValue);
						else if(columnName.equals(ConfigPathFile.TaxID.getConstantValue()))							
							objTDAddJobIds.setTaxID(dataValue);
						else if(columnName.equals(ConfigPathFile.Department.getConstantValue()))							
							objTDAddJobIds.setDepartment(dataValue);
						else if(columnName.equals(ConfigPathFile.Province.getConstantValue()))							
							objTDAddJobIds.setProvince(dataValue);
						else if(columnName.equals(ConfigPathFile.QST.getConstantValue()))							
							objTDAddJobIds.setQst(dataValue);
						else if(columnName.equals(ConfigPathFile.GST.getConstantValue()))							
							objTDAddJobIds.setGst(dataValue);

						//Validate Addresses
						else if(columnName.equals(ConfigPathFile.SupplierLocation.getConstantValue()))							
							objTDAddJobIds.setSupplierLocation(dataValue);
						else if(columnName.equals(ConfigPathFile.All.getConstantValue()))							
							objTDAddJobIds.setAll(dataValue);
						else if(columnName.equals(ConfigPathFile.Valid.getConstantValue()))							
							objTDAddJobIds.setValid(dataValue);
						else if(columnName.equals(ConfigPathFile.InValid.getConstantValue()))							
							objTDAddJobIds.setInValid(dataValue);
						else if(columnName.equals(ConfigPathFile.Pending.getConstantValue()))							
							objTDAddJobIds.setPending(dataValue);
						else if(columnName.equals(ConfigPathFile.CannotBeValidated.getConstantValue()))							
							objTDAddJobIds.setCannotBeValidated(dataValue);
						else if(columnName.equals(ConfigPathFile.PaymentInfo.getConstantValue()))							
							objTDAddJobIds.setPaymentInfo(dataValue);
						else if(columnName.equals(ConfigPathFile.CommentType.getConstantValue()))							
							objTDAddJobIds.setCommentType(dataValue);
						else if(columnName.equals(ConfigPathFile.Comment.getConstantValue()))							
							objTDAddJobIds.setComment(dataValue);
						else if(columnName.equals(ConfigPathFile.getWebElements.getConstantValue()))							
							objTDAddJobIds.setWebElements(dataValue);
						else if(columnName.equals(ConfigPathFile.DBQueryForUS.getConstantValue()))							
							objTDAddJobIds.setDbQueryForUS(dataValue);
						else if(columnName.equals(ConfigPathFile.DBQueryForNonUS.getConstantValue()))							
							objTDAddJobIds.setDbQueryForNonUS(dataValue);
						//Legal ID
						else if(columnName.equals(ConfigPathFile.NoLegalID.getConstantValue()))							
							objTDAddJobIds.setNoLegalID(dataValue);
						else if(columnName.equals(ConfigPathFile.AutoValidated.getConstantValue()))
							objTDAddJobIds.setAutoValidated(dataValue);
						else if(columnName.equals(ConfigPathFile.Mismatch.getConstantValue()))
							objTDAddJobIds.setMismatch(dataValue);
						else if(columnName.equals(ConfigPathFile.ManuallyValidated.getConstantValue()))
							objTDAddJobIds.setManuallyValidated(dataValue);
						else if(columnName.equals(ConfigPathFile.PendingValidation.getConstantValue()))
							objTDAddJobIds.setPendingValidation(dataValue);
						else if(columnName.equals(ConfigPathFile.ButtonValidations.getConstantValue()))
							objTDAddJobIds.setButtonValidations(dataValue);
						else if(columnName.equals(ConfigPathFile.Buttons.getConstantValue()))
							objTDAddJobIds.setButtons(dataValue);
						else if(columnName.equals(ConfigPathFile.Comments.getConstantValue()))
							objTDAddJobIds.setComments(dataValue);
						else if(columnName.equals(ConfigPathFile.DBQueryForCanada.getConstantValue()))
							objTDAddJobIds.setdBQueryForCanada(dataValue);
						else if(columnName.equals(ConfigPathFile.DBQueryForEU.getConstantValue()))
							objTDAddJobIds.setdBQueryForEU(dataValue);
						else if(columnName.equals(ConfigPathFile.DBQueryForOthers.getConstantValue()))
							objTDAddJobIds.setdBQueryForOthers(dataValue);

						//AddProfileReqIncompleteData
						else if(columnName.equals(ConfigPathFile.OPERATIONNAME.getConstantValue()))
							objTDAddJobIds.setOperationName(dataValue);
						else if(columnName.equals(ConfigPathFile.PHONE.getConstantValue()))
							objTDAddJobIds.setPhone(dataValue);
						else if(columnName.equals(ConfigPathFile.CUSTOMERNAME.getConstantValue()))
							objTDAddJobIds.setCustomerName(dataValue);
						//CustomerDashboard
						else if(columnName.equals(ConfigPathFile.SupplierName.getConstantValue()))							
							objTDAddJobIds.setSupplierName(dataValue);
						else if(columnName.equals(ConfigPathFile.ContactName.getConstantValue()))							
							objTDAddJobIds.setContactName(dataValue);
						else if(columnName.equals(ConfigPathFile.ContactFax.getConstantValue()))							
							objTDAddJobIds.setContactFax(dataValue);
						else if(columnName.equals(ConfigPathFile.ContactEmail.getConstantValue()))						
							objTDAddJobIds.setContactEmail(dataValue);
						else if(columnName.equals(ConfigPathFile.InvitingOrganization.getConstantValue()))				
							objTDAddJobIds.setInvitingOrganization(dataValue);
						else if(columnName.equals(ConfigPathFile.SupplierGroup.getConstantValue()))							
							objTDAddJobIds.setSupplierGroup(dataValue);
						else if(columnName.equals(ConfigPathFile.ErrorMessage.getConstantValue()))					
							objTDAddJobIds.setErrorMessage(dataValue);
						else if(columnName.equals(ConfigPathFile.NewUserName.getConstantValue()))	
							objTDAddJobIds.setNewUserName(dataValue);
						else if(columnName.equals(ConfigPathFile.NewEmail.getConstantValue()))
							objTDAddJobIds.setNewEmail(dataValue);
						else if(columnName.equals(ConfigPathFile.UpdatedUserName.getConstantValue()))
							objTDAddJobIds.setUpdatedUserName(dataValue);
						//Profile Search
						else if(columnName.equals(ConfigPathFile.ExpProfileTabList.getConstantValue()))
							objTDAddJobIds.setExpProfileTabList(dataValue);

						//DBQUERY
						else if(columnName.equals(ConfigPathFile.TODOLISTQUERY.getConstantValue()))
							objTDAddJobIds.setToDoListQuery(dataValue);
						else if(columnName.equals(ConfigPathFile.LEGALIDQUERY.getConstantValue()))
							objTDAddJobIds.setLegalIDQuery(dataValue);
						else if(columnName.equals(ConfigPathFile.OUTREACHQUERY.getConstantValue()))
							objTDAddJobIds.setOutreachQuery(dataValue);
						else if(columnName.equals(ConfigPathFile.OFACSDNQUERY.getConstantValue()))
							objTDAddJobIds.setOFACSDNQuery(dataValue);

						//ManageAddress
						else if(columnName.equals(ConfigPathFile.ADDRESS.getConstantValue()))
							objTDAddJobIds.setAddress(dataValue);
						else if(columnName.equals(ConfigPathFile.CITY.getConstantValue()))
							objTDAddJobIds.setCity(dataValue);
						else if(columnName.equals(ConfigPathFile.COUNTRY.getConstantValue()))
							objTDAddJobIds.setCountry(dataValue);
						else if(columnName.equals(ConfigPathFile.COUNTRYKEY.getConstantValue()))
							objTDAddJobIds.setCountryKey(dataValue);
						else if(columnName.equals(ConfigPathFile.STATE.getConstantValue()))
							objTDAddJobIds.setState(dataValue);
						else if(columnName.equals(ConfigPathFile.STATEKEY.getConstantValue()))
							objTDAddJobIds.setStateKey(dataValue);
						else if(columnName.equals(ConfigPathFile.POSTALCODE.getConstantValue()))
							objTDAddJobIds.setPostalCode(dataValue);
						else if(columnName.equals(ConfigPathFile.UpdatedAddress.getConstantValue()))
							objTDAddJobIds.setUpdatedAddress(dataValue);

						//Suppliers-Search
						else if(columnName.equals(ConfigPathFile.PROFILESTATUS.getConstantValue()))
							objTDAddJobIds.setProfileStatus(dataValue);
						else if(columnName.equals(ConfigPathFile.ACTIVATION.getConstantValue()))
							objTDAddJobIds.setActivationComment(dataValue);
						else if(columnName.equals(ConfigPathFile.DEACTIVATION.getConstantValue()))
							objTDAddJobIds.setDeactivationComment(dataValue);

						//SendEmail
						else if(columnName.equals(ConfigPathFile.SENDEMAILSTATUS.getConstantValue()))
							objTDAddJobIds.setSendEmailStatus(dataValue);
						else if(columnName.equals(ConfigPathFile.FROM.getConstantValue()))
							objTDAddJobIds.setFromValue(dataValue);
						else if(columnName.equals(ConfigPathFile.KEYVALUE.getConstantValue()))
							objTDAddJobIds.setKeyValue(dataValue);
						else if(columnName.equals(ConfigPathFile.SUBJECT.getConstantValue()))
							objTDAddJobIds.setSubject(dataValue);
						else if(columnName.equals(ConfigPathFile.BODYMESSAGE.getConstantValue()))
							objTDAddJobIds.setBodyMessage(dataValue);
						//ReInvite
						else if(columnName.equals(ConfigPathFile.REINVITESTATUS.getConstantValue()))
							objTDAddJobIds.setReInviteStatus(dataValue);
						//Outreach
						else if(columnName.equals(ConfigPathFile.OUTREACHSTATUS.getConstantValue()))
							objTDAddJobIds.setOutreachStatus(dataValue);

						//Supplier Profile complete
						else if(columnName.equals(ConfigPathFile.SUPPLIERPROFILE.getConstantValue()))
							objTDAddJobIds.setgetSupplierProfileCompleteStatus(dataValue);

						//Advance Search
						else if(columnName.equals(ConfigPathFile.TAXIDNUMBER.getConstantValue()))
							objTDAddJobIds.setTaxIDNumberKey(dataValue);
						else if(columnName.equals(ConfigPathFile.LEGALIDDOC.getConstantValue()))
							objTDAddJobIds.setLegalIDDocKey(dataValue);
						else if(columnName.equals(ConfigPathFile.PRIVATEPUBLICQUERY.getConstantValue()))
							objTDAddJobIds.setPrivatePublicQuery(dataValue);
						else if(columnName.equals(ConfigPathFile.QUERYNAME.getConstantValue()))
							objTDAddJobIds.setQueryName(dataValue);
						else if(columnName.equals(ConfigPathFile.INVITEDBYEMAIL.getConstantValue()))
							objTDAddJobIds.setInvitedByEmail(dataValue);
						else if(columnName.equals(ConfigPathFile.INVITEDBYKEY.getConstantValue()))
							objTDAddJobIds.setInvitedByKey(dataValue);
						else if(columnName.equals(ConfigPathFile.APPROVEDKEY.getConstantValue()))
							objTDAddJobIds.setApprovedKey(dataValue);
						else if(columnName.equals(ConfigPathFile.APPROVEDNAME.getConstantValue()))
							objTDAddJobIds.setApprovedKey(dataValue);
						else if(columnName.equals(ConfigPathFile.CUSTOMERTAKECONTROLSTATUS.getConstantValue()))
							objTDAddJobIds.setCustomerTakeControl(dataValue);
						else if(columnName.equals(ConfigPathFile.CONTACTEMAILVMFOUTREACH.getConstantValue()))
							objTDAddJobIds.setContactEmailOutreach(dataValue);
						//invite and decline
						else if(columnName.equals(ConfigPathFile.RandomNum.getConstantValue()))
							objTDAddJobIds.setRandomNum(dataValue);
						else if(columnName.equals(ConfigPathFile.AcceptInvite.getConstantValue()))
							objTDAddJobIds.setAcceptInvite(dataValue);
						else if(columnName.equals(ConfigPathFile.DeclineInvite.getConstantValue()))
							objTDAddJobIds.setDeclineInvite(dataValue);
						else if(columnName.equals(ConfigPathFile.PROFILESTAGE.getConstantValue()))
							objTDAddJobIds.setProfilestage(dataValue);
						else if(columnName.equals(ConfigPathFile.DROPDOWNVALUE.getConstantValue()))
							objTDAddJobIds.setDropDownValue(dataValue);
						else if(columnName.equals(ConfigPathFile.DROPDOWNKEY.getConstantValue()))
							objTDAddJobIds.setDropDownKey(dataValue);
						else if(columnName.equals(ConfigPathFile.INSURANCEOPTION.getConstantValue()))
							objTDAddJobIds.setInsuranceDropDownValue(dataValue);
						else if(columnName.equals(ConfigPathFile.INSURANCEOPTIONKEY.getConstantValue()))
							objTDAddJobIds.setInsuranceDropDownKey(dataValue);
						else if(columnName.equals(ConfigPathFile.PRODUCTANDSERVICES.getConstantValue()))
							objTDAddJobIds.setProductAndServicesValue(dataValue);
						else if(columnName.equals(ConfigPathFile.PRODUCTANDSERVICESKEY.getConstantValue()))
							objTDAddJobIds.setProductAndServicesKey(dataValue);
						else if(columnName.equals(ConfigPathFile.GEOGRAPHICALSERVICESCOPE.getConstantValue()))
							objTDAddJobIds.setGeographicalServiceValue(dataValue);
						else if(columnName.equals(ConfigPathFile.CURRENCY.getConstantValue()))
							objTDAddJobIds.setCurrencyValue(dataValue);
						else if(columnName.equals(ConfigPathFile.BUSINESSETHICSPOLICY.getConstantValue()))
							objTDAddJobIds.setBusinessEthicsPolicy(dataValue);
						else if(columnName.equals(ConfigPathFile.FOREIGNTAX.getConstantValue()))
							objTDAddJobIds.setForeignTax(dataValue);
						else if(columnName.equals(ConfigPathFile.PAYMENTDISCOUNT.getConstantValue()))
							objTDAddJobIds.setPaymentDiscount(dataValue);
						else if(columnName.equals(ConfigPathFile.PAYMENTTYPE.getConstantValue()))
							objTDAddJobIds.setPaymentType(dataValue);
						else if(columnName.equals(ConfigPathFile.EFTTERMS.getConstantValue()))
							objTDAddJobIds.setEFTTerms(dataValue);
						else if(columnName.equals(ConfigPathFile.ADDRESSTYPE.getConstantValue()))
							objTDAddJobIds.setAddressType(dataValue);
						else if(columnName.equals(ConfigPathFile.CountRadio.getConstantValue()))
							objTDAddJobIds.setCountRadio(dataValue);

						//Latest Profile Update Date (Enterprise Generated Data)
						else if(columnName.equals(ConfigPathFile.LATESTPROFILEUPDATEDATE.getConstantValue()))
							objTDAddJobIds.setLatestProfileUpdateDate(dataValue);						
						else if(columnName.equals(ConfigPathFile.DATEOPTION.getConstantValue()))
							objTDAddJobIds.setDateOption(dataValue);
						else if(columnName.equals(ConfigPathFile.LATESTPROFILEDAYS.getConstantValue()))
							objTDAddJobIds.setLatestProfileDays(dataValue);

						//Approved Date (Enterprise Generated Data)
						else if(columnName.equals(ConfigPathFile.APPROVEDDATEOPTION.getConstantValue()))
							objTDAddJobIds.setApprovedDateOption(dataValue);
						else if(columnName.equals(ConfigPathFile.APPROVEDDATE.getConstantValue()))
							objTDAddJobIds.setApprovedDate(dataValue);
						else if(columnName.equals(ConfigPathFile.APPROVEDDATEKEY.getConstantValue()))
							objTDAddJobIds.setApprovedDateKey(dataValue);
						else if(columnName.equals(ConfigPathFile.APPROVEDDAYS.getConstantValue()))
							objTDAddJobIds.setProfileDays(dataValue);

						//Profile Complete Date (EnterPrise Generated Data)
						else if(columnName.equals(ConfigPathFile.PROFILECOMPLETEDATEOPTION.getConstantValue()))
							objTDAddJobIds.setProfileCompleteDateOption(dataValue);
						else if(columnName.equals(ConfigPathFile.PROFILECOMPLETEDATE.getConstantValue()))
							objTDAddJobIds.setProfileCompleteDate(dataValue);
						else if(columnName.equals(ConfigPathFile.PROFILECOMPLETEDATEKEY.getConstantValue()))
							objTDAddJobIds.setProfileCompleteDateKey(dataValue);						
						else if(columnName.equals(ConfigPathFile.PROFILEDAYS.getConstantValue()))
							objTDAddJobIds.setProfileDays(dataValue);

						//Invited On Date (EnterPrise Generated Data)
						else if(columnName.equals(ConfigPathFile.INVITEDONDATEOPTION.getConstantValue()))
							objTDAddJobIds.setInvitedOnDateOption(dataValue);
						else if(columnName.equals(ConfigPathFile.INVITEDONDATE.getConstantValue()))
							objTDAddJobIds.setInvitedOnDate(dataValue);
						else if(columnName.equals(ConfigPathFile.INVITEDONDATEKEY.getConstantValue()))
							objTDAddJobIds.setInvitedOnDateKey(dataValue);						
						else if(columnName.equals(ConfigPathFile.INVITEDONDAYS.getConstantValue()))
							objTDAddJobIds.setInvitedOnDays(dataValue);

						//Small Business Date (Diversity)
						else if(columnName.equals(ConfigPathFile.SMALLBUSINESSDATEOPTION.getConstantValue()))
							objTDAddJobIds.setSmlBusinessDateOption(dataValue);
						else if(columnName.equals(ConfigPathFile.SMALLBUSINESSDATE.getConstantValue()))
							objTDAddJobIds.setSmlBusinessDate(dataValue);
						else if(columnName.equals(ConfigPathFile.SMALLBUSINESSDATEKEY.getConstantValue()))
							objTDAddJobIds.setSmlBusinessDateKey(dataValue);						
						else if(columnName.equals(ConfigPathFile.SMALLBUSINESSDAYS.getConstantValue()))
							objTDAddJobIds.setSmlBusinessDays(dataValue);

						//Minority Business Date (Diversity)
						else if(columnName.equals(ConfigPathFile.MINORITYBUSINESSDATEOPTION.getConstantValue()))
							objTDAddJobIds.setMnrtBusinessDateOption(dataValue);
						else if(columnName.equals(ConfigPathFile.MINORITYBUSINESSDATE.getConstantValue()))
							objTDAddJobIds.setMnrtBusinessDate(dataValue);
						else if(columnName.equals(ConfigPathFile.MINORITYBUSINESSDATEKEY.getConstantValue()))
							objTDAddJobIds.setMnrtBusinessDateKey(dataValue);						
						else if(columnName.equals(ConfigPathFile.MINORITYBUSINESSDAYS.getConstantValue()))
							objTDAddJobIds.setMnrtBusinessDays(dataValue);
						//timezone
						else if(columnName.equals(ConfigPathFile.Region.getConstantValue()))
							objTDAddJobIds.setRegionTimezone(dataValue);
						else if(columnName.equals(ConfigPathFile.TimeZoneAbbreviation.getConstantValue()))
							objTDAddJobIds.setTimezoneAbbreviation(dataValue);

						//recovery customer 
						else if(columnName.equals(ConfigPathFile.RecoveryCustomer.getConstantValue()))
							objTDAddJobIds.setRecoveryCustomer(dataValue);
						else if(columnName.equals(ConfigPathFile.RecoverySubject.getConstantValue()))
							objTDAddJobIds.setRecoverySubject(dataValue);
						else if(columnName.equals(ConfigPathFile.MissingTabs.getConstantValue()))
							objTDAddJobIds.setMissingTabs(dataValue);
						//UPloadFiles
						else if(columnName.equals(ConfigPathFile.FILETYPE.getConstantValue()))
							objTDAddJobIds.setFileType(dataValue);
						else if(columnName.equals(ConfigPathFile.RandomNum.getConstantValue()))
							objTDAddJobIds.setRandomNum(dataValue);
						else if(columnName.equals(ConfigPathFile.AcceptInvite.getConstantValue()))
							objTDAddJobIds.setAcceptInvite(dataValue);
						else if(columnName.equals(ConfigPathFile.DeclineInvite.getConstantValue()))
							objTDAddJobIds.setDeclineInvite(dataValue);
						else if(columnName.equals(ConfigPathFile.PROFILESTAGE.getConstantValue()))
							objTDAddJobIds.setProfilestage(dataValue);
						else if(columnName.equals(ConfigPathFile.ActionTaken.getConstantValue()))
							objTDAddJobIds.setActionTaken(dataValue);
						else if(columnName.equals(ConfigPathFile.ActionType.getConstantValue()))
							objTDAddJobIds.setActionType(dataValue);
						else if(columnName.equals(ConfigPathFile.ReassignUserGrp.getConstantValue()))
							objTDAddJobIds.setReassignUserGrp(dataValue);
						else if(columnName.equals(ConfigPathFile.ReasignUserName.getConstantValue()))
							objTDAddJobIds.setReassignUserName(dataValue);
						else if(columnName.equals(ConfigPathFile.ReassignSubject.getConstantValue()))
							objTDAddJobIds.setReassignSubject(dataValue);
						else if(columnName.equals(ConfigPathFile.ReassignUserNameID.getConstantValue()))
							objTDAddJobIds.setReassignUserID(dataValue);
						else if(columnName.equals(ConfigPathFile.SupplierID.getConstantValue()))
							objTDAddJobIds.setSupplierID(dataValue);
						else if(columnName.equals(ConfigPathFile.InsuranceExpiryDate.getConstantValue()))
							objTDAddJobIds.setInsuranceExpiryDate(dataValue);
						else if(columnName.equals(ConfigPathFile.HaveInsurance.getConstantValue()))
							objTDAddJobIds.setHaveInsurance(dataValue);
						else if(columnName.equals(ConfigPathFile.InsuranceCertificateUploaded.getConstantValue()))
							objTDAddJobIds.setInsuranceCertificateUploaded(dataValue);
						else if(columnName.equals(ConfigPathFile.InsuranceInfoProvided.getConstantValue()))
							objTDAddJobIds.setInsuranceInfoProvided(dataValue);
						else if(columnName.equals(ConfigPathFile.policyType.getConstantValue()))
							objTDAddJobIds.setPolicyType(dataValue);
						else if(columnName.equals(ConfigPathFile.Date.getConstantValue()))
							objTDAddJobIds.setDate(dataValue);
						else if(columnName.equals(ConfigPathFile.calendardate.getConstantValue()))
							objTDAddJobIds.setCalendardate(dataValue);
						else if(columnName.equals(ConfigPathFile.calendardays.getConstantValue()))
							objTDAddJobIds.setCalendardays(dataValue);
						else if(columnName.equals(ConfigPathFile.calendarmonth.getConstantValue()))
							objTDAddJobIds.setCalendarmonth(dataValue);
						else if(columnName.equals(ConfigPathFile.CustomerName.getConstantValue()))
							objTDAddJobIds.setCustomerName(dataValue);						
						//Download Files
						else if(columnName.equals(ConfigPathFile.DATATOBEDOWNLOADED.getConstantValue()))
							objTDAddJobIds.setDataToBeDownloaded(dataValue);
						else if(columnName.equals(ConfigPathFile.DATACHANGEDATE.getConstantValue()))
							objTDAddJobIds.setDataChangeDate(dataValue);
						else if(columnName.equals(ConfigPathFile.DBQUERY.getConstantValue()))
							objTDAddJobIds.setDbquery(dataValue);
						//PreScreening
						else if(columnName.equals(ConfigPathFile.PRESCREENINGENABLE.getConstantValue()))
							objTDAddJobIds.setPreScreenEnable(dataValue);
						
						else if(columnName.equals(ConfigPathFile.newValue.getConstantValue()))
							objTDAddJobIds.setNewvalue(dataValue);
						else if(columnName.equals(ConfigPathFile.oldValue.getConstantValue()))
							objTDAddJobIds.setOldvalue(dataValue);
						else if(columnName.equals(ConfigPathFile.DetailAppearsForApproval.getConstantValue()))
							objTDAddJobIds.setDataappearsforapproval(dataValue);
						else if(columnName.equals(ConfigPathFile.UserNameSupplier.getConstantValue()))
							objTDAddJobIds.setUserNameSupplier(dataValue);
						
						else if(columnName.equals(ConfigPathFile.InviteAppearsForApproval.getConstantValue()))
							objTDAddJobIds.setInviteAppearsForApproval(dataValue);
						
						columnIndex = columnIndex + 1;
						if (columnIndex == sizeofHeaders)	{
							if ((objTDAddJobIds.getExecutetest().toLowerCase().contains("yes")) == true)
								objListOfTDAddJobIds.add(objTDAddJobIds);
							columnIndex = 0;
							objTDAddJobIds = new setTestData();
						}
						
						if(objTDAddJobIds.getFromValue().equalsIgnoreCase("SIM Admin Lavante QA (simsupplierqa4@gmail.com)"))
						{
							//if(dataValue.equalsIgnoreCase("SIM Admin Lavante QA (simsupplierqa4@gmail.com)"))	
							{
						//		System.out.println("fROMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
							}
						}
						if(objTDAddJobIds.getPreferredLanguage().equalsIgnoreCase("English (United States)"))
						{
							//if(dataValue.equalsIgnoreCase("SIM Admin Lavante QA (simsupplierqa4@gmail.com)"))	
							{
						//		System.out.println("LANGGGGGGGGGGGGGGGGGGGGGG");
							}
						}
					}
				}
			}
		} catch(Exception e) {
			//log.severe("Method:getTestDataForSearch :: exception = " + e.getMessage()  + e.getStackTrace());
			e.printStackTrace();
		}
		//log.info("Method:getTestDataForSearch :: returning size of test records = " + objListOfTDAddJobIds.size());	

		return objListOfTDAddJobIds;
	}

	/**
	 * Method Name : fetchTableHeaderColumn
	 * Purpose: This method retrieves test data from excel and stores in vector objects
	 * @param filePath -> Path of the excel document
	 * @param testDataSheetName -> Name of the excel sheet 
	 * @return None
	 */
	public  Vector<String> fetchTableHeaderColumn(String filePath, String testDataSheetName)	{
	//	log.info("Method: fetchData :: filePath = " + filePath + " test data sheetname = " + testDataSheetName);
		Vector<String> headers = new Vector<String>();
		File file = new File(filePath);
		Workbook workbook = null;  
		try {
			workbook = Workbook.getWorkbook(file);
		} catch (BiffException e) {
		//	log.severe("Method: fetchData :: BiffException occured = " + e.getMessage()); 
		} 
		catch (IOException e) {
		//	log.severe("Method: fetchData :: IOException occured = " + e.getMessage());
		}
		try {
			Sheet sheet = workbook.getSheet(testDataSheetName);
			headers.clear();
			for (int i = 0; i < sheet.getColumns(); i++) {
				Cell cell1 = sheet.getCell(i, 0); 
				headers.add(cell1.getContents()); 
			}
		}
		catch(Exception e) {
			//log.severe("Method: fetchData :: exception = " + e);
		}
		return headers;
	}

	/**
	 * Method Name : fetchTableData
	 * Purpose: This method retrieves test data from excel and stores in vector objects
	 * @param filePath -> Path of the excel document
	 * @param testDataSheetName -> Name of the excel sheet 
	 * @return None
	 */

	public  Vector<String> fetchTableData(String filePath, 
			String testDataSheetName)	{

		Vector<String> data = new Vector<String>();

		//log.info("Method: fetchData :: filePath = " + filePath + " test data sheetname = " + testDataSheetName);

		File file = new File(filePath);
		Workbook workbook = null;  
		try {
			workbook = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			//log.severe("Method: fetchData :: BiffException occured = " + e.getMessage()); 
		} 
		catch (IOException e) {
		//	log.severe("Method: fetchData :: IOException occured = " + e.getMessage());
		}

		try {
			Sheet sheet = workbook.getSheet(testDataSheetName);

			data.clear(); 
			for (int j = 1; j < sheet.getRows() ; j ++)  {
				for (int i = 0; i < sheet.getColumns(); i++) {
					jxl.Cell  cell = sheet.getCell(i, j);
					data.add(cell.getContents()); 
				}
			}
		}
		catch(Exception e) {
		//	log.severe("Method: fetchData :: exception = " + e);
		}
		return data;
	}

}
