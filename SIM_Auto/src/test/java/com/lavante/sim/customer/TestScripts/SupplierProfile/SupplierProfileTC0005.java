/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Madhumurthy
 */

package com.lavante.sim.customer.TestScripts.SupplierProfile;

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

public class SupplierProfileTC0005 extends PageInitiator{
	
	List<setTestData> objCompanyProfileDetailsTestData = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objCompanyProfileDetailsTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.CompanyProfileDetails.getConstantValue());
		
	}
	

	/**
	 * Method Name : verifySupplierProfilesAddNewOption
	 * Purpose: Verify the required fields on profile page
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfilesAddNewOption(){
		Reporter.log("SupplierProfileTC0005 Started: ");		
		try {
			for (int i = 0; i < objCompanyProfileDetailsTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objCompanyProfileDetailsTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					objSupplierProfilePage.navigateToProfilePage();
					objSupplierProfilePage.addSupProfileDetailsOfCompany(objCompanyProfileDetailsTestData.get(i));
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
	//		log.severe("Exception in method verifySupplierProfilesAddNewOptions: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfilesAddNewOptions: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0005 is completed: ");
	}


	@AfterClass
	public void close(){
		quitBrowser();
	}

}
