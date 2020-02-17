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

public class SupplierProfileTC0002 extends PageInitiator {

	List<setTestData> objSupplierProfileTestData = null;
	GetExcelFile ge=new GetExcelFile();
	public WebDriver driver=null;
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		
		objSupplierProfileTestData = ge.getData(ConfigPathFile.TestDataForSupplierProfile.getConstantValue(),ConfigPathFile.AddNewBtnOption.getConstantValue());
		
	}



	/**
	 * Method Name : verifySupplierProfileToDoListTabs 
	 * Purpose: Verify the To Do List Buttons opens the respective page
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifySupplierProfileToDoListTabs(){
		Reporter.log("SupplierProfileTC0002 Started: ");		
		try {
			for (int i = 0; i < objSupplierProfileTestData.size(); i++)
			{
				if (objLoginPage.userLogin(objSupplierProfileTestData.get(i)) == true)
				{
					objSupplierProfilePage.assertSupplierHomePageTitle();
					objSupplierProfilePage.navigateToProfilePage();
					objSupplierProfilePage.validateTodoListLinks();
				}
			}
			objLoginPage.logout();
		} catch (Exception e) {
		//	log.severe("Exception in method verifySupplierProfileToDoListTabs: "+ e.getMessage());
			Assert.assertTrue(false,"Exception in method verifySupplierProfileToDoListTabs: "+ e.getMessage());
		}
		Reporter.log("Execution of Test Case SupplierProfileTC0002 is completed: ");
	}

	@AfterClass
	public void close(){
	
		quitBrowser();
	}

}
