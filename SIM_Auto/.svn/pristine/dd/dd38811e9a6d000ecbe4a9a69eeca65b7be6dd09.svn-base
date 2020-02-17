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

public class SupplierProfileTC0003 extends PageInitiator {

	List<setTestData> objSupplierProfileTestData = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		
		objSupplierProfileTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.ProfileTabLists.getConstantValue());
				
	}

	
	/**
	 * Method Name : verifySupplierProfileBtns 
	 * Purpose: Verify the profile page buttons works properly
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfileBtns(){
		Reporter.log("SupplierProfileTC0003 Started: ");		
		try {
			
			for (int i = 0; i < objSupplierProfileTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objSupplierProfileTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					objSupplierProfilePage.navigateToProfilePage();
					objSupplierProfilePage.validateNextBtn("Next"+objSupplierProfileTestData.get(i).getComments().trim().toString());
			//		objSupplierProfilePage.validatePreviousBtn("Previous"+objSupplierProfileTestData.get(i).getComments().trim().toString());
					objSupplierProfilePage.validateSaveBtn("Save"+objSupplierProfileTestData.get(i).getComments().trim().toString());
					objSupplierProfilePage.validateMenuTab("Menu"+objSupplierProfileTestData.get(i).getComments().trim().toString());
					objSupplierProfilePage.validateToDoListMenuTab("ToDoList"+objSupplierProfileTestData.get(i).getComments().trim().toString());

				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
	//		log.severe("Exception in method verifySupplierProfileBtns: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileBtns: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0003 is completed: ");
	}

	@AfterClass
	public void close(){
		quitBrowser();
	}


}
