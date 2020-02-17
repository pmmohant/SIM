/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

package com.lavante.sim.customer.TestScripts.ManageFiles;

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


public class ManageUsersTC0002 extends PageInitiator{

	List<setTestData> objManageUsers = null;
	List<setTestData> objManageAddress = null;
	
	GetExcelFile ge=new GetExcelFile();
	

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		
		objManageUsers = ge.getData(ConfigPathFile.ManageUsersTestDataFile.getConstantValue(),
				ConfigPathFile.MANAGEUSERS.getConstantValue());
		objManageUsers = ge.getData(ConfigPathFile.ManageUsersTestDataFile.getConstantValue(),ConfigPathFile.MANAGEUSERS.getConstantValue());
		objManageAddress = ge.getData(ConfigPathFile.ManageUsersTestDataFile.getConstantValue(),ConfigPathFile.MANAGEADDRESS.getConstantValue());

	}		

	/**
	 * Method Name : validateUsersTblAndAdressTblOnManageUsersPage
	 *  Purpose: Public method which includes logic related to validate the Users and Address tables on Manage Users page 
	 * @param: None
	 * @return None
	 */
	@Test
	public void validateUsersTblAndAdressTblOnManageUsersPage() { System.out.println("TEST STWARTED");
		Reporter.log("ManageUsersTC0002 Started: ");
		try {

			for (int i = 0; i < objManageUsers.size(); i++) {
				if (objLoginPage.userLogin(objManageUsers.get(i)) == true) {
				//	objManageUsersPage.addNewUserAndEditDetails(objManageUsers);
					objManageUsersPage.addNewAddressAndEditDetails(objManageAddress);
					objLoginPage.logout();
				}
			}
		} catch (Exception e) {
		//	log.severe("Exception in method validateUsersTblAndAdressTblOnManageUsersPage: " + e.getMessage());
			//Assert.assertTrue(false,"Exception in method validateUsersTblAndAdressTblOnManageUsersPage: " + e.getMessage());
		}
		Reporter.log("Execution of Test Case ManageUsersTC0002 is completed: ");
	}
	
	@AfterClass
	public void close(){
		quitBrowser();
	}

}
