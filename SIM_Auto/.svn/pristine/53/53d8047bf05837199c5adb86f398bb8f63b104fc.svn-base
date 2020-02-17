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

public class SupplierProfileTC0010 extends PageInitiator{
	
	List<setTestData> objProfileSearchTestData = null;
	List<setTestData> objCompanyProfileDetailsTestData = null;
	GetExcelFile ge=new GetExcelFile();
		
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();	
	
		objProfileSearchTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(),ConfigPathFile.ADDPROFILEDETAILS.getConstantValue());

	}

	/**
	 * Method Name : verifySupplierProfileCompletenessSts 
	 * Purpose: Verify the required fields, Tabs and validate the supplier name field is editable
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfileComplete(){
		Reporter.log("SupplierProfileTC0010 Started: ");
		int profilePercentage=0;
		try {
			for (int i = 0; i < objProfileSearchTestData.size(); i++){
				if (objLoginPage.userLogin(objProfileSearchTestData.get(i)) == true){
					objSupplierProfilePage.assertSupplierHomePageTitle();
					profilePercentage=objSupplierProfilePage.verifyProfilePercentage(objProfileSearchTestData.get(i).getCustomerName().toString());
					if(profilePercentage==100){
						Reporter.log("Profile completeness status is already completed to 100%");
					}else{
						Reporter.log("Profile completeness current status is : "+profilePercentage +" % ");
						objSupplierProfilePage.clickCompleteComProfile();
						objSupplierProfilePage.provideProfileDetailsToComplete(objProfileSearchTestData);
						objSupplierProfilePage.provideProfileTaxDetailsToComplete(objProfileSearchTestData);
						profilePercentage=objSupplierProfilePage.verifyProfilePercentage(objProfileSearchTestData.get(i).getCustomerName().toString());
						if(profilePercentage==100){
							Reporter.log("Profile status is successfully completed to : " +profilePercentage +" % ");
						}else{
							Reporter.log("Profile status is not completed to 100% :  only " +profilePercentage +" % field informations are provided");
							Assert.assertTrue(false,"Test failed due to profile status is not completed to 100% :  only " +profilePercentage +" % field informations are provided");
						}
					}
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
		//	log.severe("Exception in method verifySupplierProfileCompletenessSts: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileCompletenessSts: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0010 is completed: ");
	}

	@AfterClass
	public void close(){	
		quitBrowser();
	}

	

}
