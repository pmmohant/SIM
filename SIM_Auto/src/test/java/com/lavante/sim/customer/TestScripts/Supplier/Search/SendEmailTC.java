package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SendEmailTC extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
	String mailFrom="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;
		// Login
		List listofdatafrm = lavanteUtils.login("PaymentEFT", browser);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		enobjloginpage.logintoAPP(dataMap);
		enobjhomePage.close();

		mailFrom=dataMap.get("username");
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
	}
	
	/**
	 * 
	 * @author subhas.bv
	 */
	@Test
	public void sendEmailForSpecificContactsTest() throws Exception {
		Reporter.log("Test Started for sendEmailForSpecificContactsTest : " + currenttime());
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		dataMap.put("Clear", "");
		dataMap.put("Tab", "CompanyProfile");
		dataMap.put("ContactEmail", "Contains,@");
		dataMap.put("AddressType", "Headquarter");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);

		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.click(enobjsupplierPage.FilterByAllRadiobtn());
		enobjsupplierPage.selectChangeView("Suppliers and Invites");

		String supName = enobjsupplierPage.selectSupplier(dataMap);
		dataMap.put("Invitation", "");
		dataMap.put("sendEmail", "");
		String subject = "MailSubject" + lavanteUtils.generateRandomNumber9OnLength(9);

		String selectContact = " select MAX(C.ContactName) from SupplierCustomerAddressMap scam,Relationship r,Supplier S,Supplier_Contact_Map scm, "
				+ " SupplierLocationContactMap  slam ,Supplier_Address_Map sam,Contact C where  r.LavanteUID = s.LavanteUID "
				+ " and sam.SupplierAddressMapID=scam.SupplierAddressMapID and slam.SupplierCustomerAddressMapID=scam.SupplierCustomerAddressMapID "
				+ " and slam. SupplierContactMapID=scm.SupplierContactMapID "
				+ " and C.ContactID=scm.ContactID and r.CustomerID="+customerID+" and S.SupplierName='"+supName+"' and scam.AddressTypeId= 1" ;
		selectContact=lavanteUtils.fetchDBdata(selectContact);
		
		Assert.assertTrue(selectContact!=null,"DB returned for Select Contact is Empty,:"+selectContact);
		dataMap.put("mailFrom", mailFrom);
		dataMap.put("mailSubject", subject);
		dataMap.put("mailMessage", "Automation SP");
		dataMap.put("SpecificContacts", "");
		dataMap.put("Contacts", selectContact);
		dataMap.put("mailSend", "");
		enobjsupplierPage.ProfileAction(dataMap);

		Reporter.log("Test completed for sendEmailForSpecificContactsTest : " + currenttime());
	}

	/**
	 * 
	 * @author subhas.bv
	 */
	@Test(dataProvider = "SpecificContacts", dataProviderClass = EditProfDataProvider.class)
	public void sendEmailForLocationTypeTest(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("Test Started for sendEmailForLocationTypeTest : " + currenttime());
		
		String getAddressTypeID = "select AddressTypeID from AddressType where AddressType='"+ dataMap.get("LocationType").trim() + "'";
		getAddressTypeID = lavanteUtils.fetchDBdata(getAddressTypeID).trim();

		String suppName=" select MAX(S.SupplierName) from SupplierCustomerAddressMap scam,Relationship r,Supplier S,Supplier_Contact_Map scm, "
				+ " SupplierLocationContactMap  slam ,Supplier_Address_Map sam,Contact C where  r.LavanteUID = s.LavanteUID "
				+ " and sam.SupplierAddressMapID=scam.SupplierAddressMapID and slam.SupplierCustomerAddressMapID=scam.SupplierCustomerAddressMapID "
				+ " and slam. SupplierContactMapID=scm.SupplierContactMapID "
				+ " and C.ContactID=scm.ContactID and r.CustomerID="+customerID+" and scam.AddressTypeId= "+getAddressTypeID; 
		suppName=lavanteUtils.fetchDBdata(suppName);
		
		Assert.assertTrue(suppName!=null,"Supp Name Returned from DB is Empty,:"+suppName);
		
		lavanteUtils.click(enobjsupplierBasicSearch.BasicSearchTab);
		dataMap.put("supplierName", suppName);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		String x=" select MAX(C.ContactName) from SupplierCustomerAddressMap scam,Relationship r,Supplier S,Supplier_Contact_Map scm, "
				+ " SupplierLocationContactMap  slam ,Supplier_Address_Map sam,Contact C where  r.LavanteUID = s.LavanteUID "
				+ " and sam.SupplierAddressMapID=scam.SupplierAddressMapID and slam.SupplierCustomerAddressMapID=scam.SupplierCustomerAddressMapID "
				+ " and slam. SupplierContactMapID=scm.SupplierContactMapID "
				+ " and C.ContactID=scm.ContactID and r.CustomerID="+customerID+" and S.SupplierName='"+suppName+"' and scam.AddressTypeId= "+getAddressTypeID ;

		x=lavanteUtils.fetchDBdata(x);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.click(enobjsupplierPage.FilterByAllRadiobtn());
		
		enobjsupplierPage.selectChangeView("Suppliers and Invites");
		boolean flag=false; 
		
		dataMap.put("Invitation", "");
		dataMap.put("sendEmail", "");
		String subject = "MailSubject" + lavanteUtils.generateRandomNumber9OnLength(9);
		
		SoftAssert softAssert=new SoftAssert();
		
		if( (x!=null) && (x.length()>0)){
			dataMap.put("mailFrom", mailFrom);
			dataMap.put("mailSubject", subject);
			dataMap.put("mailMessage", "Automation SP");
			dataMap.put("SpecificContacts", "");
			dataMap.put("LocationType", dataMap.get("LocationType").trim());
			dataMap.put("Contacts", x);
			dataMap.put("mailSend", "");
			dataMap.put("mailSend", "");
			dataMap.put("supplierName", suppName);
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			flag=true;
		} else{
			softAssert.assertTrue(flag,"No Data Avaliable");
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Please Recheck");
		Reporter.log("Test completed for sendEmailForLocationTypeTest : " + currenttime());
	}

	@AfterMethod
	public void aftermethod(){
		lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(null);
	}
	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
