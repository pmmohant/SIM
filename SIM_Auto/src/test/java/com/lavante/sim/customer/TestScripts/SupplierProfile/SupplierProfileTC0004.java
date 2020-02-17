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

public class SupplierProfileTC0004 extends PageInitiator {

	List<setTestData> objSupplierProfileTestData = null;
	GetExcelFile ge=new GetExcelFile();

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
	
		objSupplierProfileTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.ESignature.getConstantValue());


		
	}

	/**
	 * Method Name : verifySupplierProfileESignature 
	 * Purpose: Verify the required fields, Tabs and validate the supplier name field is editable
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfileESignature(){
		Reporter.log("SupplierProfileTC0004 Started: ");		
		try {
				for (int i = 0; i < objSupplierProfileTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objSupplierProfileTestData.get(i)) == true)
				{
					if(i==0){
						objSupplierProfilePage.assertSupplierHomePageTitle();
						objSupplierProfilePage.navigateToProfilePage();
						objSupplierProfilePage.navigateToCusSpecificProfileTabPage();
						objSupplierProfilePage.editEsignatureField(objSupplierProfileTestData.get(i).getConfirmPassword().toString());
						objLoginPage.logout();
					}else if(i==1){
						objSupplierProfilePage.navigateToSupProfileEditPage(objSupplierProfileTestData.get(i).getSupplierName().toString(),objSupplierProfileTestData.get(i).getProfileStatus().toString());		
						objSupplierProfilePage.navigateToCusSpecificProfileTabPage();
						objSupplierProfilePage.editEsignatureField(objSupplierProfileTestData.get(i).getConfirmPassword().toString());
					}
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
		//	log.severe("Exception in method verifySupplierProfileESignature: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileESignature: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0004 is completed: ");
	}

	@AfterClass
	public void close(){	
		quitBrowser();
	}

	

}
