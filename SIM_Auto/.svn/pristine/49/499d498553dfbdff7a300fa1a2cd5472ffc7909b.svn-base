/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 *///

package com.lavante.sim.customer.TestScripts.ManageAccount;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.MyAccountDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class MyAccountTC0002_VerifyMyAccountPasswordReset extends PageInitiator  {

	LavanteUtils lavanteUtils=new LavanteUtils();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
	
		//Login
		List listofdatafrm=lavanteUtils.login("DEL-1", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(enMyAccountPages.myAccLink());
		lavanteUtils.click(enMyAccountPages.myAccLink());

	}


	/**
	 * Method Name : verifyMyAccountResetPassword Purpose: Method for
	 * verifyMyAccountResetPassword
	 * 
	 * @param: None
	 * @return None
	 */
	@Test(dataProvider="ResetPWdErrorMsg",dataProviderClass=MyAccountDataProvider.class)
	public void verifyMyAccountResetPassword(LinkedHashMap<String,String> dataMap) {
		Reporter.log("MyAccountTC0002 Started: ");
		
		dataMap.put("Clear","");
		enMyAccountPages.formAction(dataMap);
		dataMap.remove("Clear");
		dataMap.put("Save", "");
		enMyAccountPages.AccSettings(dataMap);
	
		lavanteUtils.switchtoFrame(enMyAccountPages.IFRAMEMyAcc());
		lavanteUtils.fluentwait(enMyAccountPages.ErrorMsg());
		String errmsg=enMyAccountPages.ErrorMsg().getText();
		String exp=dataMap.get("VerifyMsg");
		
		System.out.println("Exp Error Msg,"+exp+",Actuals:"+errmsg);
		Reporter.log("Exp Error Msg,"+exp+",Actuals:"+errmsg);
		Assert.assertEquals(errmsg,exp, "Error Message Not Matched,Exp Error Msg,"+exp+",Actuals:"+errmsg);
		
		System.out.println("-=----Test Ended for Verify Reset Password-----------");
		Reporter.log("Execution of Test Case MyAccountTC0002 is completed: ");
	}
	
	
	@AfterClass
	public void close(){
			quitBrowser();
	}

}
