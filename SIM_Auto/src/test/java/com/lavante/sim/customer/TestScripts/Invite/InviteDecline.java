package com.lavante.sim.customer.TestScripts.Invite;

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

public class InviteDecline extends PageInitiator {

	List<setTestData> objGmaildata=null;
	List<setTestData> objSupplierdata=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();

		objGmaildata=ge.getData(ConfigPathFile.TestDataForGmail.getConstantValue(),ConfigPathFile.SupplierSubject.getConstantValue() );
		objSupplierdata=ge.getData(ConfigPathFile.SupplierSearchTestDataFile.getConstantValue(), ConfigPathFile.InviteDecline.getConstantValue());
		
		objGmailLoginPage.navigateToGmailApplication();
	}

	@Test
	public void testInviteDecline(){
		Reporter.log("The test Decline invite started");
		try{
			if(objGmailLoginPage.validateGMailLogin(objGmaildata)==true){
				Reporter.log("Logged into Gmail");
				String str_link=objGmailLoginPage.readMails(objGmaildata.get(0), objGmaildata.get(0).getDeclineInvite().toString(), ConfigPathFile.Click.getConstantValue());
				Reporter.log("Read the Mail with the subject specified for declining the Invite");
				objGmailLoginPage.clickLogoutBtn();
				driver.get(str_link);
				objSimAccountSetupPage.declineInvite();
				Reporter.log("Declined the invite");
				//objGmailLoginPage.clickLogoutBtn();
				openAPP();
				objLoginPage.userLogin(objSupplierdata.get(0));
				objSupplierSearchPage.navigatetoAdvncdSearchPage();
				objSupplierSearchPage.supplDeclinedInvite(objSupplierdata.get(0));
				Reporter.log("Verified that the supplier who declined invitation is in 'invite declined' category");
				objLoginPage.logout();
				Reporter.log("Execution of the Decline invite of the supplier complete");
			}

		}catch(Exception e){
			Reporter.log("Failed to execute test InviteDecline due to : "+e.getMessage());
		//	log.severe("Failure in execution of test InviteDecline due to : "+e.getCause());
			Assert.assertTrue(false,"Failed in the execution of Invite Decline test case due to the reason : "+e.getMessage());
		}

	}

	@AfterClass
	public void closer(){
	
		quitBrowser();
	}

	

}
