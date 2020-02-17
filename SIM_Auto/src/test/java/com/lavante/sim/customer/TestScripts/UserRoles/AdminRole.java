package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 31-08-2016 Created for Verifying SIM User Roles
 * 
 * @author Subhash.BV 
 *
 */
public class AdminRole extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhash.BV
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List listofdatafrm = lavanteUtils.login("UserRoleId2", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * UserRoles: SIM-5_Lavante_Admin
	 * 
	 * @author Subhash.BV
	 * @throws IOException
	 */
	@Test
	public void AdminlavanteTest() throws Exception {

		Reporter.log("Test Started for lavanteAdminTest:" + currenttime());

		String propName = "mail.smtp.host";
		String query = "select PropertyValue from ApplicationProperties where PropertyName like '" + propName + "'";
		String data = lavanteUtils.fetchDBdata(query);
		String actvalue = enprop.getPropValue(propName);
		Reporter.log("Property " + propName + ",Expected" + data + ",Actual," + actvalue);
		Assert.assertEquals(actvalue, data,"Property " + propName + " Not Matched,Expected" + data + ",Actual," + actvalue);
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/**
	 * Lavante Background Task -LATM 502
	 * 
	 * @author Piramanayagam.S
	 * @throws IOException
	 */
	@Test
	public void BackGroundTask() throws Exception {

		Reporter.log("Test Started for BackGroundTask:" + currenttime());
		SoftAssert softAssert=new SoftAssert();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","APP");
		dataMap.put("subtab","Background");
		enobjhomePage.selectTab(dataMap);	
		
		lavanteUtils.waitForTime(4000);
		
		for(int i=0;i<enBackgroundTask.BackgroundName.size();i++){
			String x=enBackgroundTask.BackgroundName.get(i).getText();
			
			dataMap.put("BackgroundTask",x);
			dataMap.put("Pause","");
			enBackgroundTask.SelectBackgroundTaskAction(dataMap);
			dataMap.remove("Pause");
			lavanteUtils.refreshPage();

			String yx="select TRIGGER_STATE  from QRTZ_TRIGGERS where JOB_NAME='"+x+"'";
			yx=lavanteUtils.fetchDBdataPlatform(yx);
			Reporter.log("Trigger"+x+", is in "+yx+"state, Expected:PAUSED",true);
			softAssert.assertEquals(yx, "PAUSED","Not MAtched Paused States");
			
			dataMap.put("Resume","");
			enBackgroundTask.SelectBackgroundTaskAction(dataMap);
			dataMap.remove("Resume");
			lavanteUtils.refreshPage();
			
			yx="select TRIGGER_STATE  from QRTZ_TRIGGERS where JOB_NAME='"+x+"'";
			yx=lavanteUtils.fetchDBdataPlatform(yx);
			String exp="WAITING#BLOCKED";
			Reporter.log("Trigger, "+x+", is in "+yx+"state, Expected:"+exp,true);
			softAssert.assertTrue(exp.contains(yx),"Not MAtched Paused States");
			
			dataMap.put("ProcessImmediately","");
			enBackgroundTask.SelectBackgroundTaskAction(dataMap);
			dataMap.remove("ProcessImmediately");
			lavanteUtils.refreshPage();
			
			yx="select TRIGGER_STATE  from QRTZ_TRIGGERS where JOB_NAME='"+x+"'";
			yx=lavanteUtils.fetchDBdataPlatform(yx);
			exp="WAITING#BLOCKED";
			Reporter.log("Trigger, "+x+", is in "+yx+"state, Expected:"+exp,true);
			softAssert.assertTrue(exp.contains(yx),"Not Matched Process Immediately");
			
			exp="0 45 0 1/1 * ? *";
			dataMap.put("Reschedule",exp);
			enBackgroundTask.SelectBackgroundTaskAction(dataMap);
			dataMap.remove("Reschedule");
			lavanteUtils.refreshPage();
			
			yx=enBackgroundTask.BackgroundFreq.get(i).getText();
			Reporter.log("Trigger, "+x+", is in "+yx+"state, Expected:"+exp,true);
			softAssert.assertEquals(exp,yx,"Freq Not MAtched ");
			
			yx=enBackgroundTask.BackgroundDesc.get(i).getText();
			exp="At 0:45 AM";
			Reporter.log("Trigger, "+x+", is in "+yx+"state, Expected:"+exp,true);
			softAssert.assertEquals(exp,yx,"Desc Not MAtched");

			break;
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}

}
