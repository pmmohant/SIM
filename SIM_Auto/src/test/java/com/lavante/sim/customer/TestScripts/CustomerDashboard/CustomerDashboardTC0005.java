/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari 
 */ 

package com.lavante.sim.customer.TestScripts.CustomerDashboard;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class CustomerDashboardTC0005 extends PageInitiator {

	List<setTestData> objDashboard=null;
	List<setTestData> objDatabaseQuery=null;
	GetExcelFile ge=new GetExcelFile();

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		objDashboard = ge.getData(ConfigPathFile.DashboardTestDataFile.getConstantValue(), ConfigPathFile.DASHBOARD.getConstantValue());
		objDatabaseQuery = ge.getData(ConfigPathFile.DashboardTestDataFile.getConstantValue(), ConfigPathFile.DBQUERY.getConstantValue());

	}
	
	/**
	 * Method Name : validateLegalIdPieChartDataOnDashboardPage
	 * Purpose:  Public method which includes logic related to validate Legal ID Authentication data with the data base data
	 * @param: None
	 * @return None
	 */
	@Test
	public void validateLegalIdPieChartDataOnDashboardPage() {
		Reporter.log("CustomerDashboardTC0005 Started: ");
		
		try {
		
			for(int i=0;i<objDashboard.size();i++) {
				if(objLoginPage.userLogin(objDashboard.get(i))==true) {
					objHomePage.validateLegalIDAuthentication(objDatabaseQuery);
					objLoginPage.logout();
				}
			}
		} catch (Exception e) {
			//	log.severe("Exception in method validateLegalIdPieChartDataOnDashboardPage: " +e.getMessage());
			Assert.assertTrue(false,"Exception in method validateLegalIdPieChartDataOnDashboardPage: " +e.getMessage());
		}
		Reporter.log("Execution of Test Case CustomerDashboardTC0005 is completed: ");
	}

	@AfterMethod
	public void close(){
		quitBrowser();
	}

}
