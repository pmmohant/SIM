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

public class InviteNewSupplier extends PageInitiator{

	List<setTestData> objTestNewSuppl = null;
	GetExcelFile ge=new GetExcelFile();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
		
		objTestNewSuppl = ge.getData(ConfigPathFile.TestDataIntegration.getConstantValue(),ConfigPathFile.Invite.getConstantValue());
		
		
	}

	/**
	 * Method Name : InviteNewSupplier 
	 * Purpose: Invites a new supplier from the Supplier Search Page
	 * @param: None
	 * @return None
	 */
	@Test
	public void testInviteNewSupplier(){
		Reporter.log("Invite New Supplier test started ");
		try{
			for(int i=0;i<objTestNewSuppl.size();i++){
				if(objLoginPage.userLogin(objTestNewSuppl.get(i))==true){
					Reporter.log("\n Successfully Logged into LAVANTE");
					objSupplierSearchPage.navigateToSuplPage();
					if(objSupplierSearchPage.inviteNewSupplier(objTestNewSuppl.get(i))==true)
					{	
						if(objTestNewSuppl.get(i).getInviteAppearsForApproval().toString().equalsIgnoreCase(ConfigPathFile.YES.getConstantValue())){
							Thread.sleep(360000);
							objtaskapprovalpage.navigatetoTasksApproval();
							objtaskapprovalpage.filterByOption(ConfigPathFile.NewSupplierInvite.getConstantValue());
							objtaskapprovalpage.searchSupplierwithHeader(objTestNewSuppl.get(i).getSupplierName().toString(), ConfigPathFile.SupplierNAME.getConstantValue());
							objtaskapprovalpage.taskOptionType(ConfigPathFile.Approve.getConstantValue());
							objtaskapprovalpage.frameApprove("Test Comment", ConfigPathFile.Comment.getConstantValue());
						}
						Reporter.log("\n Successfully invited a supplier");
					}
					else
						Reporter.log("\n Failure in inviting new supplier");
					objLoginPage.logout();
					Reporter.log("\n Successfully logged out of LAVANTE application");
				}
			}
		}catch(Exception e){
			Reporter.log("\n The test to Invite a new supplier changed due to: "+e.getMessage());
		//	log.severe("The test failed due to :"+e.getMessage());
			Assert.assertTrue(false,"Failure in the test run for Inviting new customer");
		}


	}

	@AfterClass
	public void close(){
	
		quitBrowser();
	}


}
