/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari 
 */

package com.lavante.sim.customer.TestScripts.BasicSearch;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class CustomerSupplierSearchTC0017 extends  PageInitiator {

	List<setTestData> objPreScreeningSearchData = null;
	List<setTestData> objLogin = null;
	List<setTestData> objGmailTestData =null;
	GetExcelFile ge= new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	launchAppFromPOM(Platform,browser,Version);
	initiate();
	
	openAPP();
	
	objLogin = ge.getData(ConfigPathFile.TestDataForPreScreening.getConstantValue(),
			ConfigPathFile.Login.getConstantValue());
	objPreScreeningSearchData = ge.getData(ConfigPathFile.TestDataForPreScreening.getConstantValue(),
			ConfigPathFile.PRESCREENING.getConstantValue());
	objGmailTestData = ge.getData(ConfigPathFile.TestDataForGmail.getConstantValue(),
			ConfigPathFile.Login.getConstantValue());
	
	}
	
	/**
	 * Method Name : verifyCreateNewSupplierPrescreening
	 * Purpose: Public method which includes logic related to verify Create New Supplier PreScreening
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifyCreateNewSupplierPrescreening() {
		Reporter.log("CustomerSupplierSearchTC0017 Started: ");

		try {


			for (int i=0;i<objLogin.size();i++) {
				if (objLoginPage.userLogin(objLogin.get(i)) == true) {
				/*			String sSupplierName=objSupplierSearchPage.verifyPreScreeningFunctionality(objPreScreeningSearchData);
					

					objGmailLoginPage.navigateToGmailApplication();

					if(objGmailLoginPage.validateGMailLogin(objGmailTestData)==true){
					for(int j=0;j<objPreScreeningSearchData.size();j++){
							objGmailLoginPage.readMails(objPreScreeningSearchData.get(j), sSupplierName, "PreScreening");
							break;
						}
					}
					objGmailLoginPage.clickLogoutBtn();*/
				}
				objLoginPage.logout();
			}
		} catch (Exception e) {
		//	log.severe("Exception in method verifyCreateNewSupplierPrescreening: " + e.getMessage());
			Assert.assertTrue(false,"Exception in method verifyCreateNewSupplierPrescreening: " + e.getMessage());
		}
		Reporter.log("Execution of Test Case CustomerSupplierSearchTC0017 is completed: ");
	}
	
	@AfterClass
	public void close(){
		quitBrowser();
	}


}
