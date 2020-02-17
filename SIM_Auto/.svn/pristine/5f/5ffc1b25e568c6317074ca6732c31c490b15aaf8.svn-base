/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 */

package com.lavante.sim.customer.TestScripts.ManageAccount;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
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
import com.lavante.sim.customer.pageobjects.Login.LoginPage;
import com.lavante.sim.customer.pageobjects.MyAccount.MyAccountPage;
public class MyAccountTC0001_VerifyUIElementOfMyAccount extends PageInitiator  {

	List<setTestData> objResetPassword = null;
	List<setTestData> objUserCredentials = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		
		objResetPassword = ge.getData(ConfigPathFile.TestDataForMyAccTimeZoneUIControl.getConstantValue(),
				ConfigPathFile.MyAccountTimeZoneUITest.getConstantValue());
		
		
		objLoginPage = PageFactory.initElements(driver, LoginPage.class);
		objMyAccountPage = PageFactory.initElements(driver,
				MyAccountPage.class);
	}

	/**
	 * Method Name : verifyMyAccountUIControls Purpose: Method for
	 * verifyMyAccountUIControls
	 * 
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifyMyAccountUIControls() {
		Reporter.log("MyAccountTC0001 Started: ");
		try {
			
			for (int i = 0; i < objResetPassword.size(); i++) {
				if (objLoginPage.userLogin(objResetPassword.get(i)) == true) {
					objMyAccountPage.verifyUIControlsOfMyAccount();
					objLoginPage.logout();
					if (i == 1) {
						break;
					}
				} 
			}

		} catch (Exception e) {
		}
	}
	
	@AfterClass
	public void close(){
	
		quitBrowser();
	}


}
