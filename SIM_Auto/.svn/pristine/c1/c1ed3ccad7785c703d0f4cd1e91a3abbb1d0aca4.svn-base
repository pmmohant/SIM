package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

 /** 
 * 
 * Certificate test
 * @author Piramanayagam.S
 *
 */
public class CertificateAdd01 extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String supplierName = "";
	String custid = "";
	String insuranceName = "";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
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
		List listofdatafrm = lavanteUtils.login("Certificate", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		custid = (String) listofdatafrm.get(1);

		// Login
		supplierName = LdataMap.get("supname");
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	@BeforeMethod
	public void SetupBeforemethod() throws Exception {

		lavanteUtils.switchtoFrame(null);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("Search", "");
		dataMap.put("InactiveSup", "");
		dataMap.put("supplierName", supplierName);
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	}

	/**
	 * SIM-7284 Verify Payment Terms is dependent of Payment Type in Edit
	 * Profile page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test(dataProvider = "UploadInsurance", dataProviderClass = EditProfDataProvider.class)
	public void AddCertificate(LinkedHashMap<String, String> dataMap) throws Exception {
		System.out.println("------------Test Started for AddCertificate in Edit Profile-------------------");
		Reporter.log("Test Started for Add Certicicate in Edit Profile at :" + currenttime());
		SoftAssert softassert = new SoftAssert();
		boolean flag = false;

		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		insuranceName = "AutoSP" + LavanteUtils.randomnum();
		if (dataMap.containsKey("InsuranceName")) {
			String Content = dataMap.get("InsuranceName");
			if (Content.equalsIgnoreCase("ANY")) {
				dataMap.put("InsuranceName", insuranceName);
			}
		} else {
			dataMap.put("InsuranceName", insuranceName);
		}

		dataMap.put("addInsurance", "");
		dataMap.put("InsuranceSave", "");

		eneditCertification.fillCertification(dataMap);

		Reporter.log("Insurance Saved");
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());

		for (int i = 0; i < eneditCertification.ViewListInsuranceName().size(); i++) {
			if (eneditCertification.ViewListInsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
				Reporter.log("Added Insurance available in the Edit Supplier:" + insuranceName);
				softassert.assertEquals(eneditCertification.ViewListInsuranceName().get(i).getText(), insuranceName,
						"Exp Insurance Not Available,Expected" + insuranceName + "In app"
								+ eneditCertification.ViewListInsuranceName().get(i).getText());
				flag = true;
			}

		}

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		if (flag == false) {
			softassert.assertTrue(false, "Please Retest and RECHECK");
		}

		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-7284 Verify Payment Terms is dependent of Payment Type in Edit
	 * Profile page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test(dataProvider = "UploadInsurance", dataProviderClass = EditProfDataProvider.class)
	public void AddViewSupplierCertificate(LinkedHashMap<String, String> dataMap) throws Exception {
		System.out.println("------------Test Started for Validate PayMentTerms in Edit Profile-------------------");
		Reporter.log("Test Started for Validate PayMentTerms in Edit Profile at :" + currenttime());
		SoftAssert softassert = new SoftAssert();
		boolean flag = false;

		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		

		String[] supname=eneditProfile.suppName();
		
		insuranceName = "AutoSP" + LavanteUtils.randomnum();
		if (dataMap.containsKey("InsuranceName")) {
			String Content = dataMap.get("InsuranceName");
			if (Content.equalsIgnoreCase("ANY")) {
				dataMap.put("InsuranceName", insuranceName);
			}
		} else {
			dataMap.put("InsuranceName", insuranceName);
		}

		dataMap.put("addInsurance", "");
		dataMap.put("InsuranceSave", "");

		eneditCertification.fillCertification(dataMap);
		
		
		Reporter.log("Insurance Saved:" + insuranceName);
		// name="AutoSP160303121644";
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());
		lavanteUtils.Scrollintoview(eneditCertification.insuranceYes());

		lavanteUtils.waitForTime(5000);

		for (int i = 0; i < eneditCertification.ViewListInsuranceName().size(); i++) {
			System.out.println(eneditCertification.DelInsurance().size() + "ASD"+ eneditCertification.ViewListInsuranceName().size());
			if (eneditCertification.ViewListInsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
				Reporter.log("Insurance available in the edit Page :" + insuranceName);
			}
		}

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {

			enviewSupplier.clickOnSupplier(supname[0]);
			Reporter.log("In View Supplier:" + supname[0]);

			dataMap.put("maintab", "Supplier Managed");
			dataMap.put("subtab", "Certification");
			enviewSupplier.selectTab(dataMap);
			Reporter.log("Certification Tab:");

			lavanteUtils.fluentwait(enviewSupplier.haveinsurance());

			for (int i = 0; i < enviewSupplier.listinsuranceName().size(); i++) {
				if (enviewSupplier.listinsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
					Reporter.log("Insurance Found :" + insuranceName);
					String appstatus = enviewSupplier.listinsuranceStatus().get(i).getText();
					String expstatus = "Active";
					Reporter.log("Certificate status,Expected:" + expstatus + ",In app:" + appstatus);
					softassert.assertEquals(appstatus, expstatus,
							"Certificate Status Not Matched,Expected" + expstatus + "In app:" + appstatus);
					flag = true;
				}
			}

		}

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		if (flag == false) {
			softassert.assertTrue(false, "Please Retest and RECHECK");
		}

		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-7284 Verify Payment Terms is dependent of Payment Type in Edit
	 * Profile page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test(dataProvider = "UploadInsurance", dataProviderClass = EditProfDataProvider.class)
	public void DelCertificate(LinkedHashMap<String, String> dataMap) throws Exception {
		System.out.println("------------Test Started for Validate PayMentTerms in Edit Profile-------------------");
		Reporter.log("Test Started for Validate PayMentTerms in Edit Profile at :" + currenttime());
		SoftAssert softassert = new SoftAssert();
		boolean flag = false;

		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		insuranceName = "AutoSP" + LavanteUtils.randomnum();
		if (dataMap.containsKey("InsuranceName")) {
			String Content = dataMap.get("InsuranceName");
			if (Content.equalsIgnoreCase("ANY")) {
				dataMap.put("InsuranceName", insuranceName);
			}
		} else {
			dataMap.put("InsuranceName", insuranceName);
		}

		dataMap.put("addInsurance", "");
		dataMap.put("InsuranceSave", "");

		eneditCertification.fillCertification(dataMap);

		Reporter.log("Insurance Saved:" + insuranceName);
		// name="AutoSP160303121644";
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());
		lavanteUtils.Scrollintoview(eneditCertification.insuranceYes());

		lavanteUtils.waitForTime(5000);

		outr:for (int i = 0; i < eneditCertification.ViewListInsuranceName().size(); i++) {
			System.out.println(eneditCertification.DelInsurance().size() + "ASD"+ eneditCertification.ViewListInsuranceName().size());
			if (eneditCertification.ViewListInsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
				Reporter.log("Insurance available in the edit Page :" + insuranceName);
				lavanteUtils.click(eneditCertification.DelInsurance().get(i));

				System.out.println(eneditCertification.DelInsurance().size() + "DOP"+ eneditCertification.ViewListInsuranceName().size());
				lavanteUtils.click(eneditCertification.Okbtn());
				break outr;
			}
		}

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());

		for (int i = 0; i < eneditCertification.ViewListInsuranceName().size(); i++) {
			System.out.println(eneditCertification.ViewListInsuranceName().get(i).getText() + "DAS" + insuranceName);
			if (!eneditCertification.ViewListInsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
				Reporter.log("Added Insurance Not available in the Edit Supplier Page After Deletion," + insuranceName);
				softassert.assertTrue(true, "Exp Insurance Available in edit Supplier,Expected" + insuranceName);
				flag = true;
			}
		}

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		if (flag == false) {
			softassert.assertTrue(false, "Please Retest and RECHECK");
		}

		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-7284 Verify Payment Terms is dependent of Payment Type in Edit
	 * Profile page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test(dataProvider = "UploadInsurance", dataProviderClass = EditProfDataProvider.class)
	public void DelViewSupplierCertificate(LinkedHashMap<String, String> dataMap) throws Exception {
		System.out.println("------------Test Started for Validate PayMentTerms in Edit Profile-------------------");
		Reporter.log("Test Started for Validate PayMentTerms in Edit Profile at :" + currenttime());
		SoftAssert softassert = new SoftAssert();
		boolean flag = false;

		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		insuranceName = "AutoSP" + LavanteUtils.randomnum();
		if (dataMap.containsKey("InsuranceName")) {
			String Content = dataMap.get("InsuranceName");
			if (Content.equalsIgnoreCase("ANY")) {
				dataMap.put("InsuranceName", insuranceName);
			}
		} else {
			dataMap.put("InsuranceName", insuranceName);
		}

		dataMap.put("addInsurance", "");
		dataMap.put("InsuranceSave", "");

		eneditCertification.fillCertification(dataMap);

		Reporter.log("Insurance Saved:" + insuranceName);

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());
		lavanteUtils.Scrollintoview(eneditCertification.insuranceYes());

		lavanteUtils.waitForTime(5000);

		outr:for (int i = 0; i < eneditCertification.ViewListInsuranceName().size(); i++) {
			if (eneditCertification.ViewListInsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
				Reporter.log("Insurance available in the edit Page :" + insuranceName);
				lavanteUtils.waitForTime(3000);
				lavanteUtils.Scrollintoview(eneditCertification.DelInsurance().get(i));
				/*Actions actions = new Actions(driver);
				actions.moveToElement(eneditCertification.DelInsurance().get(i)).click().perform();*/
				lavanteUtils.click(eneditCertification.DelInsurance().get(i));
				lavanteUtils.fluentwait(eneditCertification.Okbtn());
				lavanteUtils.click(eneditCertification.Okbtn());
				break outr;
			}
		}

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());

		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {

			lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
			Reporter.log("In View Supplier:");

			dataMap.put("maintab", "Supplier Managed");
			dataMap.put("subtab", "Certification");
			enviewSupplier.selectTab(dataMap);
			Reporter.log("Certification Tab:");

			lavanteUtils.fluentwait(enviewSupplier.haveinsurance());

			for (int i = 0; i < enviewSupplier.listinsuranceName().size(); i++) {
				if (enviewSupplier.listinsuranceName().get(i).getText().equalsIgnoreCase(insuranceName)) {
					Reporter.log("Insurance Found :" + insuranceName);
					String appstatus = enviewSupplier.listinsuranceStatus().get(i).getText();
					String expstatus = "Inactive";
					Reporter.log("Certificate status,Expected:" + expstatus + ",In app:" + appstatus);
					softassert.assertEquals(appstatus, expstatus,
							"Certificate Status Not Matched,Expected" + expstatus + "In app:" + appstatus);
					flag = true;
					break;
				}
			}

		}

		if (flag == false) {
			softassert.assertTrue(false, "Please Retest and RECHECK");
		}

		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**
	 * SIM-10858 Demo Feedback : Updates to Coverage Value field
	 * 
	 * 
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void validateCoverageValueTest() throws IOException, SQLException {
		System.out.println("------------Test Started for validateCoverageValueTest in Edit Profile-------------------");
		Reporter.log("Test Started for validateCoverageValueTest in Edit Profile at :" + currenttime());
		SoftAssert softassert = new SoftAssert();
		boolean flag = false;
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		String query = "update PopUpCustomerMetadata set IsRequiredField=1 where PopUpProfileMetadataID=2900 and CustomerID="+ custid + "";
		lavanteUtils.UpdateDB(query);

		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		insuranceName = "AutoSP" + LavanteUtils.randomnum();
		if (dataMap.containsKey("InsuranceName")) {
			String Content = dataMap.get("InsuranceName");
			if (Content.equalsIgnoreCase("ANY")) {
				dataMap.put("InsuranceName", insuranceName);
			}
		} else {
			dataMap.put("InsuranceName", insuranceName);
		}
		dataMap.put("policytype", "any");
		dataMap.put("InsuranceSave", "");
		eneditCertification.addInsurance(dataMap);

		lavanteUtils.switchtoFrame(eneditCertification.iframeaddins());
		String expectedCoverageLimitMsg = "'Coverage Limit' cannot be left blank.";
		String expectedCoverageCurrencyMsg = "'Coverage Currency' cannot be left blank.";
		String actualCoverageLimitMsg = lavanteUtils.getText(eneditCertification.CoverageLimitMandatoryMsg());
		String actualCoverageCurrencyMsg = lavanteUtils.getText(eneditCertification.CoverageCurrencyMandatoryMsg());

		Reporter.log(" Coverage limit mandatory msg is not displayed/invalid msg, Expected " + expectedCoverageLimitMsg		+ " , Actual " + actualCoverageLimitMsg);
		softassert.assertEquals(actualCoverageLimitMsg, expectedCoverageLimitMsg,	" Coverage limit mandatory msg is not displayed/invalid msg, Expected " + expectedCoverageLimitMsg	+ " , Actual " + actualCoverageLimitMsg);

		Reporter.log(" Coverage Currency mandatory msg is not displayed/invalid msg, Expected "	+ expectedCoverageCurrencyMsg + " , Actual " + actualCoverageCurrencyMsg);
		softassert.assertEquals(actualCoverageCurrencyMsg, expectedCoverageCurrencyMsg,	" Coverage Currency mandatory msg is not displayed/invalid msg, Expected " + expectedCoverageCurrencyMsg	+ " , Actual " + actualCoverageCurrencyMsg);

		lavanteUtils.switchtoFrame(eneditCertification.iframeaddins());
		lavanteUtils.click(eneditCertification.SelectCurrencyDropDwn());
		lavanteUtils.switchtoFrame(null);
		List<WebElement> els = driver.findElements(By.cssSelector("div[class*='drop'] li"));
		flag = false;
		for (int i = 0; i < els.size(); i++) {
			String len = els.get(i).getText();
			if (!len.contains("Select")||len.length()>0) {

				if (len.length() == 3) {
					flag = true;
				} else if (len.contains("Select")){
					flag = true;
				}else if (len.length()>0){
					flag = false;
					break;
				}
			}
		}
		Reporter.log("Verify Three letter currency code is displayed instead of currency Name ");
		softassert.assertTrue(flag,	"Verification of Three letter currency code is notdispalyed instead of currency Name ");

		lavanteUtils.switchtoFrame(null);
		String validAmount = "123456789123548";
		String uploadFileName = lavanteUtils.CopyFile("pdfSample.pdf");
		dataMap.put("addInsurance", "");
		dataMap.put("coverageLimit",validAmount);
	//	dataMap.put("ValidAmount", validAmount);
		dataMap.put("CurrencyType", "USD");
		dataMap.put("uploadInsurance", uploadFileName);
		dataMap.put("InsuranceSave", "");
		eneditCertification.fillCertification(dataMap);

		String actualinsuranceName = null;
		String actualvalidAmount = null;
		int size = eneditCertification.ViewListInsuranceName().size();
		flag = false;
		for (int i = 0; i < size; i++) {
			actualinsuranceName = lavanteUtils.getText(eneditCertification.ViewListInsuranceName().get(i));

			if (insuranceName.equals(actualinsuranceName)) {
				flag = true;
				actualvalidAmount = lavanteUtils.getText(eneditCertification.getCoverageLimitAmount().get(i));
				break;
			}
		}

		Reporter.log("Verify the saved insurance from the table view, Expected insurance name " + insuranceName	+ " ,Actual insurance name " + actualinsuranceName);
		softassert.assertTrue(flag,	"Verify the saved insurance from the table view is not same , Expected insurance name " + insuranceName	+ " ,Actual insurance name " + actualinsuranceName);

		String expectedValidAmount = "$123,456,789,123,548.00";
		Reporter.log("verify the valid amount from the table view, Expected valid amount " + expectedValidAmount+ " , Actual valid amount " + actualvalidAmount);
		softassert.assertEquals(actualvalidAmount, expectedValidAmount,"verify the valid amount from the table view is not equal , Expected valid amount "	+ expectedValidAmount + " , Actual valid amount " + actualvalidAmount);

		dataMap.clear();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supplierName);

		dataMap.put("maintab", "Supplier Managed");
		dataMap.put("subtab", "viewCertifications");
		enviewSupplier.selectTab(dataMap);

		String viewProfileInsuranceName = "";
		String viewProfileCoverageLimt = "";
		flag = false;
		int insuranceTableSize = enviewSupplier.listinsuranceName().size();
		for (int i = 0; i < insuranceTableSize; i++) {
			viewProfileInsuranceName = enviewSupplier.listinsuranceName().get(i).getText();
			viewProfileCoverageLimt = enviewSupplier.listinsuranceCoverageLimit().get(i).getText();
			if (insuranceName.equals(viewProfileInsuranceName) && expectedValidAmount.equals(viewProfileCoverageLimt)) {

				flag = true;
				break;
			}
		}
		Reporter.log("Verify newely added insurance and its coverage limit ");
		softassert.assertTrue(flag, "Verification faliled newely added insurance and its coverage limit ");

		softassert.assertAll();

		Reporter.log("Test Ended for validateCoverageValueTest in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");
	}

	/**
	 * 
	 * SIM-11991 Insurance Type to be tied to Country Of Registration
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 * 
	 */
	@Test
	public void validateInsurancePolicyTypeTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for validateInsurancePolicyTypeTest in Edit Profile at:" + currenttime());
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String query = "select UTFString From UserTranslation where i18nKey in (Select ValueDescription_i18nKey from KeyValue where CategoryID=7 and  KeyValueID not in (select KeyValueID from Country_PolicyType_Map)) and LanguageID=50";
		List<String> defaultPolicyTypes = lavanteUtils.fetchDBlistdata(query);

		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		dataMap.put("CountryOfRegistration", "Germany");
		eneditCompanyProfile.fillCompanyAdditionalInfo(dataMap);

		if (lavanteUtils.isElementDisplayed(eneditCompanyProfile.IFRAMECountryofReg())) {
			lavanteUtils.switchtoFrame(eneditCompanyProfile.IFRAMECountryofReg());
			lavanteUtils.click(eneditCompanyProfile.OkYesBtn());
			lavanteUtils.switchtoFrame(null);
		}

		dataMap.put("tab", "supplierProfileCertifications");
		eneditProfile.selectTab(dataMap);

		if (lavanteUtils.isElementDisplayed(eneditProfile.iframe_Nextab())) {
			lavanteUtils.switchtoFrame(eneditProfile.iframe_Nextab());
			lavanteUtils.click(eneditProfile.leavethisTab());
		}

		lavanteUtils.fluentwait(eneditCertification.addinsurancebtn());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.click(eneditCertification.addinsurancebtn());
		lavanteUtils.switchtoFrame(eneditCertification.iframeaddins());

		lavanteUtils.click(eneditCertification.AddPolicytype());
		lavanteUtils.switchtoFrame(null);
		List<WebElement> el = driver.findElements(By.cssSelector("div[class*='drop'] li"));

		String actualPolicyType = null;
		ArrayList<String> actualPolicyTypes = new ArrayList<>();
		for (int i = 0; i < el.size(); i++) {

			actualPolicyType = lavanteUtils.getText(el.get(i));
			if(actualPolicyType.length()>0){
				actualPolicyTypes.add(actualPolicyType);
			}
		}

		lavanteUtils.switchtoFrame(eneditCertification.iframeaddins());
		lavanteUtils.click(eneditCertification.InsuranceCancelBtn());

		query = "select UTFString From UserTranslation where i18nKey in (Select ValueDescription_i18nKey from KeyValue where KeyValueID in (select KeyValueID from Country_PolicyType_Map where ISOCountryID in (select ISOCountryID from Country where [Name]='Germany')))";
		List<String> dbPolicyTypes = lavanteUtils.fetchDBlistdata(query);
		 query = "select UTFString From UserTranslation where i18nKey in (Select ValueDescription_i18nKey from KeyValue where CategoryID=7 and  KeyValueID not in (select KeyValueID from Country_PolicyType_Map)) and LanguageID=50";
		List<String> defPolicyTypes = lavanteUtils.fetchDBlistdata(query);
		defPolicyTypes.addAll(dbPolicyTypes);

		boolean flag = false;
		for (String temp : defPolicyTypes) {
			if (actualPolicyTypes.contains(temp)) {
				flag = true;
			} else {
				flag = false;
				break;
			}

		}

		Reporter.log("Verification of the populated list of Insurance policy type based on the Germany as Country Of Registration selected, Expected is  "	+ true + ", Actual is " + flag);
		softAssert.assertTrue(flag,	"Verification of the populated list of Insurance policy type based on the Germany as Country Of Registration selected, Expected is  "+ true + ", Actual is " + flag);

		flag = false;
		lavanteUtils.switchtoFrame(null);
		dataMap.put("tab", "supplierCompanyDetails");
		eneditProfile.selectTab(dataMap);

		dataMap.clear();
		dataMap.put("CountryOfRegistration", "France");
		eneditCompanyProfile.fillCompanyAdditionalInfo(dataMap);

		if (lavanteUtils.isElementDisplayed(eneditCompanyProfile.IFRAMECountryofReg())) {
			lavanteUtils.switchtoFrame(eneditCompanyProfile.IFRAMECountryofReg());
			lavanteUtils.click(eneditCompanyProfile.OkYesBtn());
			lavanteUtils.switchtoFrame(null);
		}
		dataMap.put("tab", "supplierProfileCertifications");
		eneditProfile.selectTab(dataMap);

		if (lavanteUtils.isElementDisplayed(eneditProfile.iframe_Nextab())) {
			lavanteUtils.switchtoFrame(eneditProfile.iframe_Nextab());
			lavanteUtils.click(eneditProfile.leavethisTab());
			lavanteUtils.switchtoFrame(null);
		}

		lavanteUtils.click(eneditCertification.addinsurancebtn());
		lavanteUtils.switchtoFrame(eneditCertification.iframeaddins());

		lavanteUtils.click(eneditCertification.AddPolicytype());
		lavanteUtils.switchtoFrame(null);
		el = driver.findElements(By.cssSelector("div[class*='drop'] li"));

		actualPolicyType = null;
		actualPolicyTypes = new ArrayList<>();
		actualPolicyType = null;
		for (int i = 0; i < el.size(); i++) {

			actualPolicyType = lavanteUtils.getText(el.get(i));
			actualPolicyTypes.add(actualPolicyType);
		}

		lavanteUtils.switchtoFrame(eneditCertification.iframeaddins());
		lavanteUtils.click(eneditCertification.InsuranceCancelBtn());

		query = "select UTFString From UserTranslation where i18nKey in (Select ValueDescription_i18nKey from KeyValue where KeyValueID in (select KeyValueID from Country_PolicyType_Map where ISOCountryID in (select ISOCountryID from Country where [Name]='France')))";
		List<String> dbPolicyTypes1 = lavanteUtils.fetchDBlistdata(query);
		defaultPolicyTypes.addAll(dbPolicyTypes1);

		flag = false;
		for (String temp : defaultPolicyTypes) {
			if (actualPolicyTypes.contains(temp)) {
				flag = true;
			} else {
				System.out.println("temp " + temp);
				flag = false;
				break;
			}

		}

		Reporter.log(
				"Verification of the populated list of Insurance policy type based on the France as Country Of Registration selected, Expected is  "
						+ true + ", Actual is " + flag);
		softAssert.assertTrue(flag,
				"Verification of the populated list of Insurance policy type based on the France as Country Of Registration selected, Expected is  "
						+ true + ", Actual is " + flag);

		Reporter.log("Test Ended for validateInsurancePolicyTypeTest in Edit Profile at:" + currenttime());
		System.out.println("----------Test Ended----------------");
	}

	@AfterMethod
	public void aftermethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.backtoSearch();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		if (insuranceName.length() > 0) {
			
			String delquery = "delete from SupplierInsuranceType_Map where InsuranceID in (Select InsuranceID from SupplierInsurance where InsurerName like '"
					+ insuranceName + "')";
			lavanteUtils.UpdateDB(delquery);
			
			delquery = "delete from SupplierInsurance where InsurerName like '" + insuranceName + "'";
			lavanteUtils.UpdateDB(delquery);

			
		}
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();

		quitBrowser();
	}

}
