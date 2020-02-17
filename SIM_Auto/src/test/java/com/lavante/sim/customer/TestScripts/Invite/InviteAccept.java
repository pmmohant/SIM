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


public class InviteAccept extends PageInitiator{

	List<setTestData> objGmailTestData=null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
	
		objGmailTestData = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(),ConfigPathFile.SupplierSubject.getConstantValue());
	
		objGmailLoginPage.navigateToGmailApplication();

	}
	@Test
	public void testInviteAccept(){
		Reporter.log("Execution started for testing the InviteAccept functionality..");
		try{
			if(objGmailLoginPage.validateGMailLogin(objGmailTestData)==true){
				for(int i=0;i<objGmailTestData.size();i++){
					String str_link=objGmailLoginPage.readMails(objGmailTestData.get(i), objGmailTestData.get(i).getAcceptInvite().toString(),ConfigPathFile.Click.getConstantValue());
					objGmailLoginPage.clickLogoutBtn();
					driver.get(str_link);
					objSimAccountSetupPage.acceptInvite();
					Reporter.log("Accepted the invitation");
					objLoginPage.logout();
					Reporter.log("Logged out of the application");
				}
			}
		}catch(Exception e)
		{
			Reporter.log("Failed to accept invite from the customer due to the reason :"+e.getMessage());
		//	log.severe("Failure in the test InviteAccept due to : "+e.getCause());
			Assert.assertTrue(false,"The Invite accept method failed due to : "+e.getCause());
		}

	}
	
	@AfterClass
	public void closer(){
		quitBrowser();
	}

		

}
