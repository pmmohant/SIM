/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Madhumurthy
 */

package com.lavante.sim.customer.TestScripts.SupplierProfile;

import java.util.List;

import org.openqa.selenium.WebDriver;
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


public class SupplierProfileTC0001 extends PageInitiator {


	List<setTestData> objVerifyProfileDtsTestData = null;
	GetExcelFile ge=new GetExcelFile();
	public WebDriver driver=null;
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		
		objVerifyProfileDtsTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.VerifyProfileDetails.getConstantValue());
		
	}
	

	/**
	 * Method Name : verifySupplierProfileDetails 
	 * Purpose: Verify the required fields, Tabs and validate the supplier name field is editable
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfileDetails(){
		Reporter.log("SupplierProfileTC0001 Started: ");		
		try {
			for (int i = 0; i < objVerifyProfileDtsTestData.size(); i++)
			{							
				if (objLoginPage.userLogin(objVerifyProfileDtsTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					objSupplierProfilePage.naviagteToViewProfilePage();
					objSupplierProfilePage.openProfileSubMenu("Regulatory");
					objSupplierProfilePage.verifyRegDetailsOfSupProfile(objVerifyProfileDtsTestData);
					objSupplierProfilePage.openProfileSubMenu("Contact");
					objSupplierProfilePage.verifyContactDetails(objVerifyProfileDtsTestData);
					objCustSupViewProfilePage.closeSupDetailsPopUpWindow();
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
			//log.severe("Exception in method verifySupplierProfileDetails: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileDetails: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0001 is completed: ");
	}

	@AfterClass
	public void closer(){
		quitBrowser();
	}

}
