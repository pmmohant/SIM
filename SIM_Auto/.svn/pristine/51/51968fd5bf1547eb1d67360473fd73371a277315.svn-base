package com.lavante.sim.supplier.TestScripts;

import java.util.ArrayList;
import java.util.Collections;
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
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SupplierHomePageTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

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
		List<?> listofdatafrm = lavanteUtils.login("SupplierTest", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}

	@Test
	public void verifySupplierHomePageTest() {
		SoftAssert softAssert = new SoftAssert();
		Reporter.log("Test Started Home Page Test :"+currenttime());

		softAssert.assertTrue(enObjSupplierHomePage.StatusInvitationDropDwn().isDisplayed(),"Verification failed for status of invitation drop down not displayed");

		/*String actualTxt = enObjSupplierHomePage.StatusInvitationDropDwn().getText();
		String expectedTxt = "All";
		softAssert.assertEquals(actualTxt, expectedTxt,	"By default status of invitation is not displaying All in drop down");
*/
		softAssert.assertTrue(enObjSupplierHomePage.PublicProfileSettingsLink().isDisplayed(),"Verification failed Public Profile Settings Link is not displayed");

		softAssert.assertTrue(enObjSupplierHomePage.CustNameDropDwn().isDisplayed(),"Verification failed for customer name drop down not displayed");
		
/*		softAssert.assertTrue(enObjSupplierHomePage.SharePublicInfoChkBox().isDisplayed(),"Verification failed share public information check box is not displayed");

		selectChkBox(enObjSupplierHomePage.SharePublicInfoChkBox(), "no");
		if (enObjSupplierHomePage.ListOkBtn().size() > 0) {
			lavanteUtils.fluentwait(enObjSupplierHomePage.OkBtn());
			lavanteUtils.click(enObjSupplierHomePage.OkBtn());
		}
		selectChkBox(enObjSupplierHomePage.SharePublicInfoChkBox(), "Yes");
		lavanteUtils.fluentwait(enObjSupplierHomePage.GetPopUpMsgTxt());
		String publicInfoMsgActual = enObjSupplierHomePage.GetPopUpMsgTxt().getText();
		String publicInfoMsgExpected = "Your general public information is now available to other customers";
		softAssert.assertEquals(publicInfoMsgActual, publicInfoMsgExpected,"Public Information message is not valid after enabling checkbox ");
		lavanteUtils.fluentwait(enObjSupplierHomePage.OkBtn());
		lavanteUtils.click(enObjSupplierHomePage.OkBtn());

		lavanteUtils.fluentwait(enObjSupplierHomePage.SharePublicInfoChkBox());
		selectChkBox(enObjSupplierHomePage.SharePublicInfoChkBox(), "no");
		lavanteUtils.fluentwait(enObjSupplierHomePage.GetPopUpMsgTxt());
		String publicInfoMsgActual1 = enObjSupplierHomePage.GetPopUpMsgTxt().getText();
		String publicInfoMsgExpected1 = "Your general public information will no longer be available to other customers";
		softAssert.assertEquals(publicInfoMsgActual1, publicInfoMsgExpected1,"Public Information message is not valid after disabling checkbox ");
		lavanteUtils.fluentwait(enObjSupplierHomePage.OkBtn());
		lavanteUtils.click(enObjSupplierHomePage.OkBtn());*/

		List<String> expectedHeaders = new ArrayList<String>();
		expectedHeaders.add("Customer Name");
		expectedHeaders.add("Invitation ID");
		expectedHeaders.add("Activities");
		expectedHeaders.add("Division(s)");
		expectedHeaders.add("% Completed");
		expectedHeaders.add("Invitation Status");
		expectedHeaders.add("Actions");
		List<String> actualHeaders = new ArrayList<String>();
		for (int i = 0; i < enObjSupplierHomePage.GetTableHeaders().size(); i++) {
			//There is a note icon, we cant verify
			if(enObjSupplierHomePage.GetTableHeaders().get(i).getText().trim().length()>0){
				actualHeaders.add(enObjSupplierHomePage.GetTableHeaders().get(i).getText().trim());
			}
		}
		Collections.sort(expectedHeaders);
		Collections.sort(actualHeaders);
		
		boolean flag = false;
		if (expectedHeaders.equals(actualHeaders)) {
			Reporter.log("Actual Headers:"+actualHeaders+",Expected:"+expectedHeaders);
			flag = true;
		}
		softAssert.assertTrue(flag, "Table Headers are not valid");
		Reporter.log("Invite Link Display, Actual:"+enObjSupplierHomePage.ListInvite().get(0).isDisplayed()+",Expected:true",true);
		softAssert.assertTrue(enObjSupplierHomePage.ListInvite().get(0).isDisplayed(),	"Verification failed invite link is not displayed");
		
		Reporter.log("Edit Profile Display, Actual:"+enObjSupplierHomePage.EditList().get(0).isDisplayed()+",Expected:true",true);
		softAssert.assertTrue(enObjSupplierHomePage.EditList().get(0).isDisplayed(),"Edit Profile button is not displayed");
		
		Reporter.log("Note List Display, Actual:"+enObjSupplierHomePage.AddNotesList().get(0).isDisplayed()+",Expected:true",true);
		softAssert.assertTrue(enObjSupplierHomePage.AddNotesList().get(0).isDisplayed(),"Note List button is not displayed");

		softAssert.assertAll();
		Reporter.log("Test Ended Home Page Test :"+currenttime());
		
	}

	@Test
	public void verifyEditProfileTest() {
		SoftAssert softAssert = new SoftAssert();
		lavanteUtils.fluentwait(enObjSupplierHomePage.EditList().get(0));
		String invitation = lavanteUtils.getText(enObjSupplierHomePage.ListInvite().get(0));
	//	String customername = lavanteUtils.getText(enObjSupplierHomePage.ListCustomer().get(0));

		lavanteUtils.click(enObjSupplierHomePage.EditList().get(0));

		Reporter.log("Edit Profile Button ClickeD");
		
		/*lavanteUtils.fluentwait(eneditProfile.GetInviteIdSelectedInDropDwn());
		String actualInviteIdFromUI = eneditProfile.getInvitedIdFromUI();
		String actualCustomerName = eneditProfile.getSupplierOrCustomerName();

		softAssert.assertEquals(actualInviteIdFromUI, invitation,
				" Invite id is invalid, Expected: " + invitation + ", Actual: " + actualInviteIdFromUI);
		softAssert.assertEquals(actualCustomerName, customername,
				" Customer name invalid, Expected: " + customername + ", Actual: " + actualCustomerName);*/
		
		softAssert.assertAll();
	}

	@Test
	public void verifyAddNotesTest() {
		SoftAssert softAssert = new SoftAssert();
		Reporter.log("Test Started Add Note Test :"+currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
	//	String actualInviteID = lavanteUtils.getText(enObjSupplierHomePage.ListInvite().get(0));
	//	String actualcustomerName = lavanteUtils.getText(enObjSupplierHomePage.ListCustomer().get(0));

		lavanteUtils.click(enObjSupplierHomePage.AddNotesList().get(0));
		lavanteUtils.fluentwait(enviewSupplier.GetCustomerSupplierName());
		//String expectedCustomerName = lavanteUtils.getText(enviewSupplier.GetCustomerSupplierName()).split(":")[0];
	//	String expectedInviteID = lavanteUtils.getText(enviewSupplier.GetCustomerSupplierName()).split(":")[1];

	//	softAssert.assertEquals(actualInviteID.trim(), expectedInviteID.trim(),"Invalid InviteID in notes and Comments page, Expected: " + expectedInviteID + ", Actual :"+ actualInviteID);
	//	softAssert.assertEquals(actualcustomerName.trim(), expectedCustomerName.trim(),"Invalid customer name in notes and Comments page, Expected: " + expectedCustomerName + ", Actual :"	+ actualcustomerName);

		String comment = "Auto" + currenttime();
		dataMap.put("NoteDesc", comment);
		String commentAdded = null;
		enviewSupplier.addNotes(dataMap);
		boolean flag = false;
		lavanteUtils.waitForTime(4000);
		for (int i = 0; i < enviewSupplier.ListSupplierPrivateNotes().size(); i++) {
			commentAdded = lavanteUtils.getText(enviewSupplier.ListSupplierPrivateNotes().get(i));
			if (comment.equals(commentAdded)) {
				Reporter.log("Added Notes,Expected:"+comment+",Actual:"+commentAdded);
				flag = true;
				break;
			}
		}
		softAssert.assertTrue(flag, " Notes as not been added in Add Notes comment page, Expected: " + comment+ ", Actual :" + commentAdded);
		Reporter.log("Test Ended Add Note Test :"+currenttime());
		softAssert.assertAll();
		
	}
	
	/**
	 * Edit the supplier in Supplier Login
	 * W9 Upload Deactivate Verify in View
	 * 
	 * @author Subhash.BV
	 * @param dataMap
	 * @throws Exception
	 */
	@Test
	public void UploadW9Deactivate() throws Exception {
		Reporter.log("Test Started for UploadW9Deactivate Test:" + currenttime());
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		SoftAssert softAssert = new SoftAssert();

		//dataMap.put("CustomerName", "XPO Logistics");
		//enObjSupplierHomePage.editCustomer(dataMap);
		
		lavanteUtils.click(enObjSupplierHomePage.EditList().get(0));

		boolean flag = false;
		String uploadFileName = CopyFile("pdfSample.pdf");
		eneditLegal.uploadw9(uploadFileName);

		lavanteUtils.fluentwait(eneditLegal.GetW9TaxUploadedFilesList().get(0));
		String actualFile = "";
		String Expw9status = "Inactive";
		String actualStatus = "";

		flag = false;
		ooutr:for (int i = 0; i < eneditLegal.GetW9TaxUploadedFilesList().size(); i++) {
			actualFile = eneditLegal.GetW9TaxUploadedFilesList().get(i).getText();  
			if (actualFile.equalsIgnoreCase(uploadFileName)) {
				innr:for (int j = 0; j < eneditLegal.editw9statusdeac().size(); j++) { 
					actualStatus = eneditLegal.editw9statusdeac().get(i).getText();
					if (actualStatus.equalsIgnoreCase("Active")) {
						int m=eneditLegal.editw9statusactive().size()-1;
						lavanteUtils.click(eneditCompanyProfile.GetW9TaxUploadedActionList().get(m));
						lavanteUtils.click(eneditCompanyProfile.OKbtn());
						lavanteUtils.fluentwait(eneditLegal.editw9statusdeac().get(0));
						actualStatus = eneditLegal.editw9statusdeac().get(i).getText();
						flag = true;
						break ooutr;
					}
				}
			}
		}

		
		Reporter.log(" Edit PRofile Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag,"Edit PRofile Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		Reporter.log(" Edit Profile w 9 status verification in view profile, Expected: " + Expw9status + ", Actual:" + actualStatus);
		Assert.assertEquals(actualStatus, Expw9status,"w 9 status verification in view profile, Expected: " + Expw9status + ", Actual:" + actualStatus);

		dataMap.put("SupplierHomePage", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.fluentwait(enObjSupplierHomePage.EditList().get(0));
		actualStatus = null;
		flag = false;
		outr:if(enObjSupplierHomePage.ListInvite().size()>0){
			lavanteUtils.click(enObjSupplierHomePage.ListInvite().get(0));
			lavanteUtils.fluentwait(enviewSupplier.supplierName());
			for (int i = 0; i < enviewSupplier.getListOfW9TaxFilesLink().size(); i++) {
				actualFile = enviewSupplier.getListOfW9TaxFilesLink().get(i).getText();
				if (actualFile.equalsIgnoreCase(uploadFileName)) {
					actualStatus = enviewSupplier.getListOfW9TaxStatusLink().get(i).getText();
					flag = true;
					break outr;
				}
			}
		}
		
		Reporter.log("View Profile Tax (W-9) Uploaded File verifcation , Expected: " + uploadFileName + ", Actual:" + actualFile);
		softAssert.assertTrue(flag,"Tax (W-9) Uploaded file verifcation failed, Expected: " + uploadFileName + ", Actual:" + actualFile);

		Reporter.log("View Profile w 9 status verification in view profile, Expected: " + Expw9status + ", Actual:" + actualStatus);
		softAssert.assertEquals(actualStatus, Expw9status,"w 9 status verification in view profile, Expected: " + Expw9status + ", Actual:" + actualStatus);

		softAssert.assertAll();
		Reporter.log("Test Ended:"+currenttime());
	
	}
	

	@Test
	public void OutstandingTaskCountVerificationTest(){
		Reporter.log("Test Started for OutstandingTaskCountVerificationTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		boolean flag=false;
		
		if(enobjhomePage.OSTaskIcon().getText().trim().length()>0){
			flag=false;
			softAssert.assertTrue(flag,"Data Found");
			Reporter.log("There is outstanding tasks for the Supplier Logged in user,It should not be there",flag);
		}else{
			flag=true;
			softAssert.assertTrue(flag,"No Data Found");
			Reporter.log("There is no outstanding tasks for the Supplier Logged in user",true);
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		
		Reporter.log("Test Ended at:" + currenttime(),true);
	}
	
	
	@AfterMethod
	public void afterMethod(){
		lavanteUtils.click(enObjSupplierHomePage.HomeTab());
	}
	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}
}
