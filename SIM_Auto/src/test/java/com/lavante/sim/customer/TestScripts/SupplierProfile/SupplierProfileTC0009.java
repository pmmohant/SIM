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

public class SupplierProfileTC0009 extends PageInitiator{

	List<setTestData> objProfileSearchTestData = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
		
		objProfileSearchTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.SUPPLIERHOMEPAGEDETAILS.getConstantValue());
				
	}

	/**
	 * Method Name : verifySupplierProfileCompletenessSts 
	 * Purpose: Verify the required fields, Tabs and validate the supplier name field is editable
	 * @param: None
	 * @return None
	 */

	@Test
	public void verifySupplierProfileCompletenessSts(){
		Reporter.log("SupplierProfileTC0009 Started: ");
		int profilePercentage=0;
		try {			
			for (int i = 0; i < objProfileSearchTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objProfileSearchTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					profilePercentage=objSupplierProfilePage.verifyProfilePercentage(objProfileSearchTestData.get(i).getCustomerName().toString());
					if(profilePercentage==100){
						Reporter.log("Profile completeness status is 100%");
					}else{
						Reporter.log("Profile completeness current status is : "+profilePercentage +" % ");
						objSupplierProfilePage.navigateToProfilePage();
						objSupplierProfilePage.inCompleteFieldList();
					}
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
			//log.severe("Exception in method verifySupplierProfileCompletenessSts: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileCompletenessSts: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0009 is completed: ");
	}


	@AfterClass
	public void close(){
		quitBrowser();
	}

	
}
