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


public class SupplierProfileTC0008 extends PageInitiator{

	List<setTestData> objProfileSearchTestData = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objProfileSearchTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.RequiredFieldLists.getConstantValue());
		
	}
	
	/**
	 * Method Name : verifySupplierProfileNameEditable 
	 * Purpose: Verify the required fields, Tabs and validate the supplier name field is editable
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfileNameEditable(){
		Reporter.log("SupplierProfileTC0008 Started: ");		
		try {
		
			for (int i = 0; i < objProfileSearchTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objProfileSearchTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					objSupplierProfilePage.navigateToProfilePage();
					objSupplierProfilePage.validateSupProfileRequiredFields(objProfileSearchTestData);
					objSupplierProfilePage.verifyProfilePageTabs(objProfileSearchTestData);
					//objSupplierProfilePage.isSupplierNameEditable(objProfileSearchTestData.get(i).getSupplierName().toString());
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
		//	log.severe("Exception in method verifySupplierProfileNameEditable: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileNameEditable: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0008 is completed: ");
	}


	@AfterClass
	public void close(){
			quitBrowser();
	}

}
