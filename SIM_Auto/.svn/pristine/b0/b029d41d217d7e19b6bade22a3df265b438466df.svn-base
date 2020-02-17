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

public class SupplierProfileTC0007 extends PageInitiator  {

	List<setTestData> objProfileTestData = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objProfileTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.SUPPLIERHOMEPAGEDETAILS.getConstantValue());
		
	}



	/**
	 * Method Name : verifySupplierDataSavedForSpecificCustomer 
	 * Purpose: Verify the profile home page details logo's, %, customer specific logo's
	 * @param: None
	 * @return None
	 */

	@Test
	public void verifySupplierDataSavedForSpecificCustomer(){
		Reporter.log("SupplierProfileTC0007 Started: ");
		try {
			for (int i = 0; i < objProfileTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objProfileTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					objSupplierProfilePage.verifySuppliersDetailsSaved(objProfileTestData);
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
		//	log.severe("Exception in method verifySupplierDataSavedForSpecificCustomer: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierDataSavedForSpecificCustomer: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0007 is completed: ");
	}


	@AfterClass
	public void close(){
		quitBrowser();
	}

	
}
