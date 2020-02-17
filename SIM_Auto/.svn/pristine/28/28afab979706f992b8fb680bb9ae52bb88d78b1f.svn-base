/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 */

package com.lavante.sim.customer.TestScripts.AccountSetup;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.AccSetupDataProvider;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.CMDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class SimAccSetupTC0004 extends PageInitiator {

	List<setTestData> objGmailTestData = null;
	List<setTestData> objSupplierSubTestData = null;
	List<setTestData> objAccSetupTestData = null;
	List<setTestData> objinvitedata=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	launchAppFromPOM(Platform,browser,Version);
	initiate();
	
	/*openAPP();
		
		objGmailTestData = ge.getData(
				ConfigPathFile.TestDataIntegration.getConstantValue(),
				ConfigPathFile.GmailLogin.getConstantValue());
		objSupplierSubTestData = ge.getData(
				ConfigPathFile.TestDataIntegration.getConstantValue(),
				ConfigPathFile.SupplierSubject.getConstantValue());
		objAccSetupTestData = ge.getData(
				ConfigPathFile.TestDataIntegration
				.getConstantValue(),
				ConfigPathFile.validateMandateFields.getConstantValue());
		objinvitedata =ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(), ConfigPathFile.InviteAccept.getConstantValue());
*/	}
	

	/**
	 * Method Name : verifySimAccountSetup Purpose: Method is used to read the
	 * received mail and click on the link to open Account setup page
	 * 
	 * @param: None
	 * @return None
	 */
	
	@Test(dataProvider="AccSetup",dataProviderClass=AccSetupDataProvider.class)
	public void VerifyAdvSearch0001(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("SimAccSetupTC0001_0002 Started: ");
		try {
		
			String str_link=null;
			
			// This URL should be moved to config file. 
			str_link="http://simqa.lavante.com:8080/sim/supplierAccountSetup.lvp?ODbJFKzfqHckqteDV5TxnZMPMgVwe6mp7pbXFpOud204HF5XsURWTE7geiS4JKZd0CLDKCtIbZfrxSC/fz4GrpIE4MJU2W/oHGUWzO72vlQC9CUqfehyag==";
			driver.get(str_link);
		
		//	objSimAccountSetupPages.accSetup(dataMap);
			
		
			

		} catch (Exception e) {
		//	log.severe("Exception in method verifyMyAccountUIControls due To "
		//			+ e.getMessage());
		}
		Reporter.log("\n Successfully logged out of LAVANTE application");
		Reporter.log("Execution of Test Case SimAccSetupTC0001_0002 is completed: ");
	}
	
	@AfterClass
	public void close(){
	
		quitBrowser();
	}

}
