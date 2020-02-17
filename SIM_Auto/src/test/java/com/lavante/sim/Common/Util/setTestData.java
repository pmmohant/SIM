/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy/Venkata Ravi Majjari
 */

package com.lavante.sim.Common.Util;

public class setTestData {

	private String executetest = "", userName = "", password = "",currentPassword = "", newPassword = "", confirmPassword = "",
			language = "", expLanguageText = "", index = "", suppliername = "",contactname = "", invitingOrganization = "", supplierGroup = "",
			fax = "", email = "", ErrorMsg = "",UserDetails="",NewUserName="",NewEmail="",UpdatedUserName="",Address="",
			City="",Country="",CountryKey="",State="",StateKey="",PostalCode="",UpdatedAddress="",preferredLanguage="",
			setPassword="",challengeQ="",challengeA="",termsCheckBox="",ToDOList="",LegalID="",Outreach="",OFACSDN="",
			expFieldLabelNames="",Comment="",existingSupplierName="",ProfileStatus="",ActivationComment="",
			DeactivationComment="",businessName="",taxID="",department="",province="",qst="",gst="",SendEmailStatus="",			
			supplierLocation="",all="",valid="",inValid="",pending="",PaymentInfo="",cannotBeValidated="",FromValue="",KeyValue="",
			Subject="",BodyMessage="",ReInviteStatus="",CommentType="",webElements="",advOutreach="",supplierProfileStatus="",
			TaxIDNumber="",LegalIDDoc="",PrivatePublicQuery="",QueryName="",InvitedByEmail="",InvitedByKey="",ApprovedKey="",
			ApprovedName="",noLegalID="",AutoValidated="",ManuallyValidated="",PendingValidation="",Mismatch="",NotProvided=""
			,ExpProfileTabList="",Unknown="",ButtonValidations="",Buttons="",Comments="",CustomerTakeControl="",ContactEmailOutreach=""
			,AcceptDeclineSupplierName="",ChosenID="",JobTitle="",tabNames="",RandomNum="",acceptInvite="", declineInvite="",
			profilestage="",code="",description="",DropDownKey="",DropDownValue="",InsuranceDropDownKey="",InsuranceDropDownValue="",
			ProductAndServicesKey="",ProductAndServicesValue="",ProfileSubTabNames="",GeographicalServiceValue="",ForeignTax="",
			CountRadio="",OFACdBquery="",CurrencyValue="",BusinessEthicsPolicy="",PaymentType="",EFTTerms="",OperationName="",phone="",
			aBANumber="",aCNumber="",payeeName="",bankName="",LatestProfileUpdateDate="",DateOption="",ApprovedDateOption="",
			ApprovedDate="",ApprovedDateKey="",PaymentDiscount="",AddressType="",customerName="",paymentTerms="",
			ProfileCompleteDateOption="",FileType="",ProfileCompleteDate="",ProfileCompleteDateKey="",ProfileDays="",ApprovedDays="",LatestProfileDays="",InvitedOnDateOption="",
			InvitedOnDate="",InvitedOnDateKey="",InvitedOnDays="",SmlBusinessDateOption="",SmlBusinessDate="",SmlBusinessDateKey="",
			SmlBusinessDays="",MnrtBusinessDateOption="",MnrtBusinessDate="",MnrtBusinessDateKey="",MnrtBusinessDays="",
			regionTimezone="",timezoneAbbreviation="", recoveryCustomer="",recoverySubject="",missingTabs="",
			HaveInsurance="",InsuranceInfoProvided="", policyType="",InsuranceExpiryDate="",Date="",InsuranceCertificateUploaded="",
			calendarmonth="",calendardate="",calendardays="",supplierID="",reassignUserID="",reassignSubject="",
			reassignUserGrp="",reassignUserName="",actionType="", dbquery="",dbQueryForUS="",actionTaken="",
			DataToBeDownloaded="",DataChangeDate="",PreScreenEnable="",newvalue="",oldvalue="",dataappearsforapproval="",
			userNameSupplier="",inviteAppearsForApproval="", dbQueryForNonUS="",dBQueryForEU="",dBQueryForOthers="",
			dBQueryForCanada="";

	//DQQuery Tests
	public String getInviteAppearsForApproval() {
		return inviteAppearsForApproval;
	}
	public void setInviteAppearsForApproval(String inviteAppearsForApproval) {
		this.inviteAppearsForApproval = inviteAppearsForApproval;
	}
	public String getUserNameSupplier() {
		return userNameSupplier;
	}
	public void setUserNameSupplier(String userNameSupplier) {
		this.userNameSupplier = userNameSupplier;
	}
	public String getDataappearsforapproval() {
		return dataappearsforapproval;
	}
	public void setDataappearsforapproval(String dataappearsforapproval) {
		this.dataappearsforapproval = dataappearsforapproval;
	}
	public String getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
	public String getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}
	
	public String getDbQueryForNonUS() {
		return dbQueryForNonUS;
	}
	public String getdBQueryForEU() {
		return dBQueryForEU;
	}
	public void setdBQueryForEU(String dBQueryForEU) {
		this.dBQueryForEU = dBQueryForEU;
	}
	public String getdBQueryForOthers() {
		return dBQueryForOthers;
	}
	public void setdBQueryForOthers(String dBQueryForOthers) {
		this.dBQueryForOthers = dBQueryForOthers;
	}
	public String getdBQueryForCanada() {
		return dBQueryForCanada;
	}
	public void setdBQueryForCanada(String dBQueryForCanada) {
		this.dBQueryForCanada = dBQueryForCanada;
	}
	public void setDbQueryForNonUS(String dbQueryForNonUS) {
		this.dbQueryForNonUS = dbQueryForNonUS;
	}
	public String getDbQueryForUS() {
		return dbQueryForUS;
	}
	public void setDbQueryForUS(String dbQueryForUS) {
		this.dbQueryForUS = dbQueryForUS;
	}
	public String getDbquery() {
		return dbquery;
	}
	public void setDbquery(String dbquery) {
		this.dbquery = dbquery;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getReassignUserID() {
		return reassignUserID;
	}
	public void setReassignUserID(String reassignUserID) {
		this.reassignUserID = reassignUserID;
	}
	public String getReassignSubject() {
		return reassignSubject;
	}
	public void setReassignSubject(String reassignSubject) {
		this.reassignSubject = reassignSubject;
	}
	public String getReassignUserGrp() {
		return reassignUserGrp;
	}
	public void setReassignUserGrp(String reassignUserGrp) {
		this.reassignUserGrp = reassignUserGrp;
	}
	public String getReassignUserName() {
		return reassignUserName;
	}
	public void setReassignUserName(String reassignUserName) {
		this.reassignUserName = reassignUserName;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	public String getCode() {
		return code;
	}

	public String getCalendarmonth() {
		return calendarmonth;
	}
	public void setCalendarmonth(String calendarmonth) {
		this.calendarmonth = calendarmonth;
	}
	public String getCalendardate() {
		return calendardate;
	}
	public void setCalendardate(String calendardate) {
		this.calendardate = calendardate;
	}
	public String getCalendardays() {
		return calendardays;
	}
	public void setCalendardays(String calendardays) {
		this.calendardays = calendardays;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getHaveInsurance() {
		return HaveInsurance;
	}
	public void setHaveInsurance(String haveInsurance) {
		HaveInsurance = haveInsurance;
	}
	public String getInsuranceInfoProvided() {
		return InsuranceInfoProvided;
	}
	public void setInsuranceInfoProvided(String insuranceInfoProvided) {
		InsuranceInfoProvided = insuranceInfoProvided;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getInsuranceExpiryDate() {
		return InsuranceExpiryDate;
	}
	public void setInsuranceExpiryDate(String insuranceExpiryDate) {
		InsuranceExpiryDate = insuranceExpiryDate;
	}
	public String getInsuranceCertificateUploaded() {
		return InsuranceCertificateUploaded;
	}
	public void setInsuranceCertificateUploaded(String insuranceCertificateUploaded) {
		InsuranceCertificateUploaded = insuranceCertificateUploaded;
	}
	public String getProfileSubTabNames() {
		return ProfileSubTabNames;
	}
	public void setProfileSubTabNames(String profileSubTabNames) {
		ProfileSubTabNames = profileSubTabNames;
	}
	public String getOperationName() {
		return OperationName;
	}
	public void setOperationName(String operationName) {
		OperationName = operationName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountRadio() {
		return CountRadio;
	}
	public void setCountRadio(String countRadio) {
		CountRadio = countRadio;
	}
	public String getOFACdBquery() {
		return OFACdBquery;
	}
	public void setOFACdBquery(String oFACdBquery) {
		OFACdBquery = oFACdBquery;
	}

	//Drop Down Key
	public String getDropDownKey() {
		return DropDownKey;
	}
	public void setDropDownKey(String DropDownKey) {
		this.DropDownKey = DropDownKey;
	}	
	//Drop Down Value
	public String getDropDownValue() {
		return DropDownValue;
	}
	public void setDropDownValue(String DropDownValue) {
		this.DropDownValue = DropDownValue;
	}
	//Insurance Drop Down Key
	public String getInsuranceDropDownKey() {
		return InsuranceDropDownKey;
	}
	public void setInsuranceDropDownKey(String InsuranceDropDownKey) {
		this.InsuranceDropDownKey = InsuranceDropDownKey;
	}	
	//Insurance Drop Down Value
	public String getInsuranceDropDownValue() {
		return InsuranceDropDownValue;
	}
	public void setInsuranceDropDownValue(String InsuranceDropDownValue) {
		this.InsuranceDropDownValue = InsuranceDropDownValue;
	}

	public String getMissingTabs() {
		return missingTabs;
	}

	public void setMissingTabs(String missingTabs) {
		this.missingTabs = missingTabs;
	}

	public String getRecoverySubject() {
		return recoverySubject;
	}

	public void setRecoverySubject(String recoverySubject) {
		this.recoverySubject = recoverySubject;
	}

	public String getRecoveryCustomer() {
		return recoveryCustomer;
	}

	public void setRecoveryCustomer(String recoveryCustomer) {
		this.recoveryCustomer = recoveryCustomer;
	}

	public String getTimezoneAbbreviation() {
		return timezoneAbbreviation;
	}

	public void setTimezoneAbbreviation(String timezoneAbbreviation) {
		this.timezoneAbbreviation = timezoneAbbreviation;
	}

	public String getRegionTimezone() {
		return regionTimezone;
	}

	public void setRegionTimezone(String regionTimezone) {
		this.regionTimezone = regionTimezone;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}
	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getaBANumber() {
		return aBANumber;
	}
	public void setaBANumber(String aBANumber) {
		this.aBANumber = aBANumber;
	}
	public String getaCNumber() {
		return aCNumber;
	}
	public void setaCNumber(String aCNumber) {
		this.aCNumber = aCNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRandomNum() {
		return RandomNum;
	}
	public void setRandomNum(String randomNum) {
		RandomNum = randomNum;
	}
	public String getAcceptInvite() {
		return acceptInvite;
	}
	public void setAcceptInvite(String acceptInvite) {
		this.acceptInvite = acceptInvite;
	}
	public String getDeclineInvite() {
		return declineInvite;
	}
	public void setDeclineInvite(String declineInvite) {
		this.declineInvite = declineInvite;
	}
	public String getProfilestage() {
		return profilestage;
	}
	public void setProfilestage(String profilestage) {
		this.profilestage = profilestage;
	}
	public String getTabNames() {
		return tabNames;
	}
	public void setTabNames(String tabNames) {
		this.tabNames = tabNames;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getChosenID() {
		return ChosenID;
	}
	public void setChosenID(String chosenID) {
		ChosenID = chosenID;
	}
	public String getAcceptDeclineSupplierName() {
		return AcceptDeclineSupplierName;
	}
	public void setAcceptDeclineSupplierName(String acceptDeclineSupplierName) {
		AcceptDeclineSupplierName = acceptDeclineSupplierName;
	}
	public String getExpProfileTabList() {
		return ExpProfileTabList;
	}
	public void setExpProfileTabList(String expProfileTabList) {
		ExpProfileTabList = expProfileTabList;
	}
	public String getLegalID() {
		return LegalID;
	}
	public String getManuallyValidated() {
		return ManuallyValidated;
	}
	public void setManuallyValidated(String manuallyValidated) {
		ManuallyValidated = manuallyValidated;
	}
	public String getPendingValidation() {
		return PendingValidation;
	}
	public void setPendingValidation(String pendingValidation) {
		PendingValidation = pendingValidation;
	}
	public String getMismatch() {
		return Mismatch;
	}
	public void setMismatch(String mismatch) {
		Mismatch = mismatch;
	}
	public String getNotProvided() {
		return NotProvided;
	}
	public void setNotProvided(String notProvided) {
		NotProvided = notProvided;
	}
	public String getUnknown() {
		return Unknown;
	}
	public void setUnknown(String unknown) {
		Unknown = unknown;
	}
	public void setLegalID(String legalID) {
		LegalID = legalID;
	}
	public String getNoLegalID() {
		return noLegalID;
	}
	public void setNoLegalID(String noLegalID) {
		this.noLegalID = noLegalID;
	}
	public String getWebElements() {
		return webElements;
	}
	public String getAutoValidated() {
		return AutoValidated;
	}
	public void setAutoValidated(String autoValidated) {
		AutoValidated = autoValidated;
	}
	public String getButtonValidations() {
		return ButtonValidations;
	}
	public void setButtonValidations(String buttonValidations) {
		ButtonValidations = buttonValidations;
	}
	public String getButtons() {
		return Buttons;
	}
	public void setButtons(String buttons) {
		Buttons = buttons;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public void setWebElements(String webElements) {
		this.webElements = webElements;
	}
	public String getCommentType() {
		return CommentType;
	}
	public void setCommentType(String commentType) {
		CommentType = commentType;
	}
	public String getPaymentInfo() {
		return PaymentInfo;
	}
	public void setPaymentInfo(String paymentInfo) {
		PaymentInfo = paymentInfo;
	}

	public String getSupplierLocation() {
		return supplierLocation;
	}
	public void setSupplierLocation(String supplierLocation) {
		this.supplierLocation = supplierLocation;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getInValid() {
		return inValid;
	}
	public void setInValid(String inValid) {
		this.inValid = inValid;
	}
	public String getPending() {
		return pending;
	}
	public void setPending(String pending) {
		this.pending = pending;
	}
	public String getCannotBeValidated() {
		return cannotBeValidated;
	}
	public void setCannotBeValidated(String cannotBeValidated) {
		this.cannotBeValidated = cannotBeValidated;
	}
	public String getQst() {
		return qst;
	}
	public void setQst(String qst) {
		this.qst = qst;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	//Login
	public String getUserDetails() {
		return UserDetails;
	}
	public void setUserDetails(String userDetails) {
		UserDetails = userDetails;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getExpLanguageText() {
		return expLanguageText;
	}
	public void setExpLanguageText(String expLanguageText) {
		this.expLanguageText = expLanguageText;
	}

	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}

	public String getExpFieldLabelNames() {
		return expFieldLabelNames;
	}
	public void setExpFieldLabelNames(String expFieldLabelNames) {
		this.expFieldLabelNames = expFieldLabelNames;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getExecutetest() {
		return executetest;
	}
	public void setExecutetest(String executetest) {
		this.executetest = executetest;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	//Customer Dash board

	// Supplier Name
	public String getSupplierName() {
		return suppliername;
	}
	public void setSupplierName(String suppliername) {
		this.suppliername = suppliername;
	}

	// Contact Name
	public String getContactName() {
		return contactname;
	}
	public void setContactName(String contactname) {
		this.contactname = contactname;
	}

	// invitingOrganization
	public String getInvitingOrganization() {
		return invitingOrganization;
	}
	public void setInvitingOrganization(String invitingOrganization) {
		this.invitingOrganization = invitingOrganization;
	}

	// supplierGroup
	public String getSupplierGroup() {
		return supplierGroup;
	}
	public void setSupplierGroup(String supplierGroup) {
		this.supplierGroup = supplierGroup;
	}

	// Fax
	public String getContactFax() {
		return fax;
	}
	public void setContactFax(String fax) {
		this.fax = fax;
	}

	// Email
	public String getContactEmail() {
		return email;
	}
	public void setContactEmail(String email) {
		this.email = email;
	}

	// Error Message
	public String getErrorMessage() {
		return ErrorMsg;
	}
	public void setErrorMessage(String ErrorMsg) {
		this.ErrorMsg = ErrorMsg;
	}

	//DBQuery - Customer Dash board
	public String getToDoListQuery() {
		return ToDOList;
	}
	public void setToDoListQuery(String ToDOList) {
		this.ToDOList = ToDOList;
	}

	public String getLegalIDQuery() {
		return LegalID;
	}
	public void setLegalIDQuery(String LegalID) {
		this.LegalID = LegalID;
	}

	public String getOutreachQuery() {
		return Outreach;
	}
	public void setOutreachQuery(String Outreach) {
		this.Outreach = Outreach;
	}

	public String getOFACSDNQuery() {
		return OFACSDN;
	}
	public void setOFACSDNQuery(String OFACSDN) {
		this.OFACSDN = OFACSDN;
	}


	//ManageUsers
	public String getNewUserName() {
		return NewUserName;
	}
	public void setNewUserName(String NewUserName) {
		this.NewUserName = NewUserName;
	}

	public String getExistingSupplierName() {
		return existingSupplierName;
	}	
	public void setExistingSupplierName(String existingSupplierName) {
		this.existingSupplierName = existingSupplierName;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public String getSetPassword() {
		return setPassword;
	}
	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}

	public String getChallengeQ() {
		return challengeQ;
	}
	public void setChallengeQ(String challengeQ) {
		this.challengeQ = challengeQ;
	}

	public String getChallengeA() {
		return challengeA;
	}
	public void setChallengeA(String challengeA) {
		this.challengeA = challengeA;
	}

	public String getTermsCheckBox() {
		return termsCheckBox;
	}
	public void setTermsCheckBox(String termsCheckBox) {
		this.termsCheckBox = termsCheckBox;
	}

	public String getNewEmail() {
		return NewEmail;
	}
	public void setNewEmail(String NewEmail) {
		this.NewEmail = NewEmail;
	}

	public String getUpdatedUserName() {
		return UpdatedUserName;
	}
	public void setUpdatedUserName(String UpdatedUserName) {
		this.UpdatedUserName = UpdatedUserName;
	}

	//ManageAddress
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}	
	public String getCountryKey() {
		return CountryKey;
	}
	public void setCountryKey(String CountryKey) {
		this.CountryKey = CountryKey;
	}	
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}

	public String getStateKey() {
		return StateKey;
	}
	public void setStateKey(String StateKey) {
		this.StateKey = StateKey;
	}

	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String PostalCode) {
		this.PostalCode = PostalCode;
	}
	public String getUpdatedAddress() {
		return UpdatedAddress;
	}
	public void setUpdatedAddress(String UpdatedAddress) {
		this.UpdatedAddress = UpdatedAddress;
	}

	//Suppliers-Search
	public String getProfileStatus() {
		return ProfileStatus;
	}
	public void setProfileStatus(String ProfileStatus) {
		this.ProfileStatus = ProfileStatus;
	}
	//Send Email
	public String getSendEmailStatus() {
		return SendEmailStatus;
	}
	public void setSendEmailStatus(String SendEmailStatus) {
		this.SendEmailStatus = SendEmailStatus;
	}

	public String getFromValue() {
		return FromValue;
	}
	public void setFromValue(String FromValue) {
		this.FromValue = FromValue;
	}

	public String getKeyValue() {
		return KeyValue;
	}
	public void setKeyValue(String KeyValue) {
		this.KeyValue = KeyValue;
	}

	public String getSubject() {
		return Subject;
	}
	public void setSubject(String Subject) {
		this.Subject = Subject;
	}

	public String getBodyMessage() {
		return BodyMessage;
	}
	public void setBodyMessage(String BodyMessage) {
		this.BodyMessage = BodyMessage;
	}

	//ReInvite
	public String getReInviteStatus() {
		return ReInviteStatus;
	}
	public void setReInviteStatus(String ReInviteStatus) {
		this.ReInviteStatus = ReInviteStatus;
	}
	//Outreach
	public String getOutreachStatus() {
		return advOutreach;
	}
	public void setOutreachStatus(String advOutreach) {
		this.advOutreach = advOutreach;
	}

	//Supplier Profile Completeness
	public String getSupplierProfileCompleteStatus() {
		return supplierProfileStatus;
	}
	public void setgetSupplierProfileCompleteStatus(String supplierProfileStatus) {
		this.supplierProfileStatus = supplierProfileStatus;
	}

	//Activation & Deactivation
	public String getActivationComment() {
		return ActivationComment;
	}
	public void setActivationComment(String ActivationComment) {
		this.ActivationComment = ActivationComment;
	}
	public String getDeactivationComment() {
		return DeactivationComment;
	}
	public void setDeactivationComment(String DeactivationComment) {
		this.DeactivationComment = DeactivationComment;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String Comment) {
		this.Comment = Comment;
	}

	//Advance Search
	public String getTaxIDNumberKey() {
		return TaxIDNumber;
	}
	public void setTaxIDNumberKey(String TaxIDNumber) {
		this.TaxIDNumber = TaxIDNumber;
	}
	public String getLegalIDDocKey() {
		return LegalIDDoc;
	}
	public void setLegalIDDocKey(String LegalIDDoc) {
		this.LegalIDDoc = LegalIDDoc;
	}	
	public String getPrivatePublicQuery() {
		return PrivatePublicQuery;
	}
	public void setPrivatePublicQuery(String PrivatePublicQuery) {
		this.PrivatePublicQuery = PrivatePublicQuery;
	}

	public String getQueryName() {
		return QueryName;
	}
	public void setQueryName(String QueryName) {
		this.QueryName = QueryName;
	}

	public String getInvitedByEmail() {
		return InvitedByEmail;
	}
	public void setInvitedByEmail(String InvitedByEmail) {
		this.InvitedByEmail = InvitedByEmail;
	}

	public String getInvitedByKey() {
		return InvitedByKey;
	}
	public void setInvitedByKey(String InvitedByKey) {
		this.InvitedByKey = InvitedByKey;
	}

	public String getApprovedKey() {
		return ApprovedKey;
	}
	public void setApprovedKey(String ApprovedKey) {
		this.ApprovedKey = ApprovedKey;
	}

	public String getApprovedName() {
		return ApprovedName;
	}
	public void setApprovedName(String ApprovedName) {
		this.ApprovedName = ApprovedName;
	}

	public String getCustomerTakeControl() {
		return CustomerTakeControl;
	}
	public void setCustomerTakeControl(String CustomerTakeControl) {
		this.CustomerTakeControl = CustomerTakeControl;
	}

	public String getContactEmailOutreach() {
		return ContactEmailOutreach;
	}
	public void setContactEmailOutreach(String ContactEmailOutreach) {
		this.ContactEmailOutreach = ContactEmailOutreach;
	}

	//Products & Services Drop Down Key
	public String getProductAndServicesKey() {
		return ProductAndServicesKey;
	}
	public void setProductAndServicesKey(String ProductAndServicesKey) {
		this.ProductAndServicesKey = ProductAndServicesKey;
	}

	//Insurance Drop Down Value
	public String getProductAndServicesValue() {
		return ProductAndServicesValue;
	}
	public void setProductAndServicesValue(String ProductAndServicesValue) {
		this.ProductAndServicesValue = ProductAndServicesValue;
	}

	//Geographical Service scope Drop Down Value
	public String getGeographicalServiceValue() {
		return GeographicalServiceValue;
	}
	public void setGeographicalServiceValue(String GeographicalServiceValue) {
		this.GeographicalServiceValue = GeographicalServiceValue;
	}

	//Currency Drop Down Value
	public String getCurrencyValue() {
		return CurrencyValue;
	}
	public void setCurrencyValue(String CurrencyValue) {
		this.CurrencyValue = CurrencyValue;
	}

	//Business Ethics Policy Drop Down Value
	public String getBusinessEthicsPolicy() {
		return BusinessEthicsPolicy;
	}
	public void setBusinessEthicsPolicy(String BusinessEthicsPolicy) {
		this.BusinessEthicsPolicy = BusinessEthicsPolicy;
	}

	//Foreign Tax Information provided Drop Down Value
	public String getForeignTax() {
		return ForeignTax;
	}
	public void setForeignTax(String ForeignTax) {
		this.ForeignTax = ForeignTax;
	}
	//Payment Discount? Drop Down Value
	public String getPaymentDiscount() {
		return PaymentDiscount;
	}
	public void setPaymentDiscount(String PaymentDiscount) {
		this.PaymentDiscount = PaymentDiscount;
	}
	//Payment Type Supported Drop Down Value
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String PaymentType) {
		this.PaymentType = PaymentType;
	}
	//EFT Terms and Conditions Drop Down Value
	public String getEFTTerms() {
		return EFTTerms;
	}
	public void setEFTTerms(String EFTTerms) {
		this.EFTTerms = EFTTerms;
	}


	//Address Type Drop Down Value
	public String getAddressType() {
		return AddressType;
	}
	public void setAddressType(String AddressType) {
		this.AddressType = AddressType;
	}

	//Latest Profile Update Date Field
	public String getLatestProfileUpdateDate() {
		return LatestProfileUpdateDate;

	}
	public void setLatestProfileUpdateDate(String LatestProfileUpdateDate) {
		this.LatestProfileUpdateDate = LatestProfileUpdateDate;
	}	
	public String getDateOption() {
		return DateOption;
	}
	public void setDateOption(String DateOption) {
		this.DateOption = DateOption;
	}
	public String getLatestProfileDays() {
		return LatestProfileDays;
	}
	public void setLatestProfileDays(String LatestProfileDays) {
		this.LatestProfileDays = LatestProfileDays;
	}
	//Approved Date field	
	public String getApprovedDateOption() {
		return ApprovedDateOption;
	}
	public void setApprovedDateOption(String ApprovedDateOption) {
		this.ApprovedDateOption = ApprovedDateOption;
	}

	public String getApprovedDate() {
		return ApprovedDate;
	}
	public void setApprovedDate(String ApprovedDate) {
		this.ApprovedDate = ApprovedDate;
	}

	public String getApprovedDateKey() {
		return ApprovedDateKey;
	}
	public void setApprovedDateKey(String ApprovedDateKey) {
		this.ApprovedDateKey = ApprovedDateKey;
	}

	public String getApprovedDays() {
		return ApprovedDays;
	}
	public void setApprovedDays(String ApprovedDays) {
		this.ApprovedDays = ApprovedDays;
	}

	//Profile Complete Date Field
	public String getProfileCompleteDateOption() {
		return ProfileCompleteDateOption;
	}
	public void setProfileCompleteDateOption(String ProfileCompleteDateOption) {
		this.ProfileCompleteDateOption = ProfileCompleteDateOption;
	}

	public String getProfileCompleteDate() {
		return ProfileCompleteDate;
	}
	public void setProfileCompleteDate(String ProfileCompleteDate) {
		this.ProfileCompleteDate = ProfileCompleteDate;
	}

	public String getProfileCompleteDateKey() {
		return ProfileCompleteDateKey;
	}
	public void setProfileCompleteDateKey(String ProfileCompleteDateKey) {
		this.ProfileCompleteDateKey = ProfileCompleteDateKey;
	}

	public String getProfileDays() {
		return ProfileDays;
	}
	public void setProfileDays(String ProfileDays) {
		this.ProfileDays = ProfileDays;
	}
	//InvitedOn Date Field	
	public String getInvitedOnDateOption() {
		return InvitedOnDateOption;
	}
	public void setInvitedOnDateOption(String InvitedOnDateOption) {
		this.InvitedOnDateOption = InvitedOnDateOption;
	}

	public String getInvitedOnDate() {
		return InvitedOnDate;
	}
	public void setInvitedOnDate(String InvitedOnDate) {
		this.InvitedOnDate = InvitedOnDate;
	}

	public String getInvitedOnDateKey() {
		return InvitedOnDateKey;
	}
	public void setInvitedOnDateKey(String InvitedOnDateKey) {
		this.InvitedOnDateKey = InvitedOnDateKey;
	}

	public String getInvitedOnDays() {
		return InvitedOnDays;
	}
	public void setInvitedOnDays(String InvitedOnDays) {
		this.InvitedOnDays = InvitedOnDays;
	}

	//Small Business Date Field	
	public String getSmlBusinessDateOption() {
		return SmlBusinessDateOption;
	}
	public void setSmlBusinessDateOption(String SmlBusinessDateOption) {
		this.SmlBusinessDateOption = SmlBusinessDateOption;
	}

	public String getSmlBusinessDate() {
		return SmlBusinessDate;
	}
	public void setSmlBusinessDate(String SmlBusinessDate) {
		this.SmlBusinessDate = SmlBusinessDate;
	}

	public String getSmlBusinessDateKey() {
		return SmlBusinessDateKey;
	}
	public void setSmlBusinessDateKey(String SmlBusinessDateKey) {
		this.SmlBusinessDateKey = SmlBusinessDateKey;
	}

	public String getSmlBusinessDays() {
		return SmlBusinessDays;
	}
	public void setSmlBusinessDays(String SmlBusinessDays) {
		this.SmlBusinessDays = SmlBusinessDays;
	}

	//Minority Business Date Field	
	public String getMnrtBusinessDateOption() {
		return MnrtBusinessDateOption;
	}
	public void setMnrtBusinessDateOption(String MnrtBusinessDateOption) {
		this.MnrtBusinessDateOption = MnrtBusinessDateOption;
	}

	public String getMnrtBusinessDate() {
		return MnrtBusinessDate;
	}
	public void setMnrtBusinessDate(String MnrtBusinessDate) {
		this.MnrtBusinessDate = MnrtBusinessDate;
	}

	public String getMnrtBusinessDateKey() {
		return MnrtBusinessDateKey;
	}
	public void setMnrtBusinessDateKey(String MnrtBusinessDateKey) {
		this.MnrtBusinessDateKey = MnrtBusinessDateKey;
	}

	public String getMnrtBusinessDays() {
		return MnrtBusinessDays;
	}
	public void setMnrtBusinessDays(String MnrtBusinessDays) {
		this.MnrtBusinessDays = MnrtBusinessDays;
	}

	//UPload Files
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String FileType) {
		this.FileType = FileType;
	}

	//DownloadFiles
	public String getDataToBeDownloaded() {
		return DataToBeDownloaded;
	}
	public void setDataToBeDownloaded(String DataToBeDownloaded) {
		this.DataToBeDownloaded = DataToBeDownloaded;
	}

	public String getDataChangeDate() {
		return DataChangeDate;
	}
	public void setDataChangeDate(String DataChangeDate) {
		this.DataChangeDate = DataChangeDate;
	}

	//PreScreening
	public String getPreScreenEnable() {
		return PreScreenEnable;
	}
	public void setPreScreenEnable(String PreScreenEnable) {
		this.PreScreenEnable = PreScreenEnable;
	}
}
