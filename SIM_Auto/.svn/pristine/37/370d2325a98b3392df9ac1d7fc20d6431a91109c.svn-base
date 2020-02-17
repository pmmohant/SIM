package com.lavante.sim.customer.TestScripts.Dashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class ClaimsDashboardTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author subhas.bv
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
	}
	
	@BeforeMethod
	public void before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Home");
		enobjhomePage.selectTab(dataMap);
		waitforPageload(enobjhomePage.pageHeader());
	}

	/**
	 * @author subhas.bv
	 * 
	 *         Submit and closed count
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void verifyClaimsDashboardChartCountTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("Test Started for verifyClaimsDashboardChartCount Test :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

		String expectedSubmitCount = lavanteUtils.getText(objClaimsDashboard.SubmitCount);
		expectedSubmitCount = "(" + expectedSubmitCount + ")";
		String expectedClosedCount = lavanteUtils.getText(objClaimsDashboard.ClosedCount);
		expectedClosedCount = "(" + expectedClosedCount + ")";
		lavanteUtils.clicks(objClaimsDashboard.SubbmittedCountLink());

		String actualSubmitCount = "";
		if (objPaymentsPage.ShowCountLink().size() > 0) {
			lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			actualSubmitCount = lavanteUtils.getText(objPaymentsPage.GetCountNo());
			if (!actualSubmitCount.contains("(")) {
				lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			}
		}
		actualSubmitCount = lavanteUtils.getText(objPaymentsPage.GetCountNo());
		Reporter.log("Claims dashboard chart submit count, Expected : " + expectedSubmitCount + ", Actual : "
				+ actualSubmitCount);
		softAssert.assertEquals(actualSubmitCount, expectedSubmitCount,
				"Claims dashboard chart submit count mismatch , Expected : " + expectedSubmitCount + ", Actual : "
						+ actualSubmitCount);

		lavanteUtils.switchtoFrame(null);
		lavanteUtils.clicks(enClaimsBasicSearch.Clearbtn());

		dataMap.put("ClaimStatus", "Closed");
		dataMap.put("Search", "");
		enClaimsBasicSearch.Search(dataMap);

		String actualClosedCount = "";
		if (objPaymentsPage.ShowCountLink().size() > 0) {
			lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			actualClosedCount = lavanteUtils.getText(objPaymentsPage.GetCountNo());
			if (!actualClosedCount.contains("(")) {
				lavanteUtils.clicks(objPaymentsPage.ShowCountLink().get(0));
			}
		}
		actualClosedCount = lavanteUtils.getText(objPaymentsPage.GetCountNo());
		Reporter.log("Claims dashboard chart closed count, Expected : " + expectedClosedCount + ", Actual : "
				+ actualClosedCount);
		softAssert.assertEquals(actualClosedCount, expectedClosedCount,
				"Claims dashboard chart closed count mismatch , Expected : " + expectedClosedCount + ", Actual : "
						+ actualClosedCount);

		softAssert.assertAll();

		Reporter.log("Test Ended for verifyClaimsDashboardChartCount Test :" + currenttime());
	}
	
	
	/** Dashboard Task
	 * @author Girish.N
	 */
	@Test
	public void OutstandingTaskCountVerificationTest(){
		Reporter.log("<---------------------Test Started for OutstandingTaskCountVerificationTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		boolean flag=false;
		
		
		if(enobjhomePage.OSTaskIcon().getText().trim().length()>0){
			Reporter.log("<------------- Outstanding Task Verification on Page Header Notification Icon",true);
			
			enobjhomePage.getOutstdngTsksOnPH(dataMap);	
			
			String outStandingTasksOnDDL = dataMap.get("OutstandingTaskOnDDL");
			String outStandingTaskCountsOnDDL = dataMap.get("OutstandingTaskCountsOnDDL");
			String actualTaskCount = dataMap.get("ActualTaskCounts");
			String actualTotalCount = dataMap.get("ActualTotalCountPH");
			
			Reporter.log("OutstandingTaskOnDDL: "+outStandingTasksOnDDL,true);
			Reporter.log("OutstandingTaskCountsOnDDL: "+outStandingTaskCountsOnDDL,true);
			Reporter.log("ActualTaskCounts: "+actualTaskCount,true);
			Reporter.log("ActualTotalCountPH: "+actualTotalCount,true);
				
			String[] expOutTasksOnDDL=outStandingTasksOnDDL.split("#");
			String[] expOutTaskCountsOnDDL=outStandingTaskCountsOnDDL.split("#");
			String[] actTaskCounts=actualTaskCount.split("#");
			Reporter.log("Outstanding Vs Actual Page Header Count Verification,Expected:"+outStandingTaskCountsOnDDL+",Actuals:"+actualTaskCount,true);
			softAssert.assertEquals(outStandingTaskCountsOnDDL, actualTaskCount,"Outstanding Vs Actual Page Header Count Verification failed");
			
			int actTaskCountTotal=0;
			for(int i=0;i<expOutTaskCountsOnDDL.length;i++){
				actTaskCountTotal = actTaskCountTotal + Integer.parseInt(expOutTaskCountsOnDDL[i]);
				Reporter.log("Outstanding Task: "+expOutTasksOnDDL[i],true);
				Reporter.log("Outstanding Task Count on DDL: "+expOutTaskCountsOnDDL[i],true);
				Reporter.log("Outstanding Task Count on the Table: "+actTaskCounts[i],true);
			}
			String totalTasksCountOnIcon="";
			totalTasksCountOnIcon=enobjhomePage.totalOSTasksCountOnPH().getText().trim();
			Reporter.log("Outstanding Task Expected(Displayed on Icon): "+totalTasksCountOnIcon,true);
			softAssert.assertEquals(actualTotalCount,totalTasksCountOnIcon,"Total On Icon");
			Reporter.log("Total Outstanding Task Count Expected (Displayed on Icon):"+totalTasksCountOnIcon+"::Actual Total Count:"+actualTotalCount,true);
			
			softAssert.assertEquals(actualTotalCount,String.valueOf(actTaskCountTotal),"Total on DDL");
			Reporter.log("Total Outstanding Task Count Expected (Displayed on DDL):"+String.valueOf(actTaskCountTotal)+"::Actual Total Count:"+actualTotalCount,true);
			
			dataMap.put("maintab", "Home");
			enobjhomePage.selectTab(dataMap);
			waitforPageload(enobjhomePage.pageHeader());
			
			Reporter.log("<------------- Outstanding Task Verification on Home Page",true);
			
			enobjhomePage.getOutstdngTsksOnHomePage(dataMap);	
			
			String outStandingTasksOnHP = dataMap.get("OutstandingTaskOnHomePage");
			String outStandingTaskCountsOnHP = dataMap.get("OutstandingTaskCountsOnHomePage");
			String actualTaskCount1 = dataMap.get("ActualTaskCounts1");
			String actualTotalCount1 = dataMap.get("ActualTotalCountHomePage");
			
			Reporter.log("OutstandingTaskOnHomePage: "+outStandingTasksOnHP,true);
			Reporter.log("OutstandingTaskCountsOnHomePage: "+outStandingTaskCountsOnHP,true);
			Reporter.log("ActualTaskCounts1: "+actualTaskCount1,true);
			Reporter.log("ActualTotalCountHomePage: "+actualTotalCount1,true);
			
			String[] expOutTasksOnHP=outStandingTasksOnHP.split("#");
			String[] expOutTaskCountsOnHP=outStandingTaskCountsOnHP.split("#");
			String[] actTaskCounts1=actualTaskCount1.split("#");
			
			Reporter.log("After Verification,Expected:"+outStandingTaskCountsOnDDL+",Actuals:"+actualTaskCount,true);
			softAssert.assertEquals(outStandingTaskCountsOnDDL, actualTaskCount,"After");
			
			int expTotalcountHp=0;
			for(int i=0;i<expOutTaskCountsOnHP.length;i++){
				expTotalcountHp = expTotalcountHp + Integer.parseInt(expOutTaskCountsOnHP[i]);
				Reporter.log("Outstanding Task: "+expOutTasksOnHP[i],true);
				Reporter.log("Outstanding Task Count in Home Page: "+expOutTaskCountsOnHP[i],true);
				Reporter.log("Outstanding Task Count on the Table: "+actTaskCounts1[i],true);
			}

			String totalTasksCountOnHP=enobjhomePage.totalOSTasksInHomePage().getText().trim().replace("Outstanding Tasks", "").trim();
			Reporter.log("Total Outstanding Task Count Header Expected:"+expTotalcountHp+"::Actual Total Count:"+totalTasksCountOnHP,true);
			softAssert.assertEquals(totalTasksCountOnHP,""+expTotalcountHp,"Total Header");
			
			Reporter.log("Total Outstanding Task Count List (Displayed on Home Page) with Search Page:"+expTotalcountHp+"::Actual Total Count:"+actualTotalCount1,true);
			softAssert.assertEquals(actualTotalCount1,""+expTotalcountHp,"Total List");
			
			flag=true;
		}else{
			flag=true;
			dataMap.put("maintab", "Tasks");
			dataMap.put("subtab", "taskTracker");
			enobjhomePage.selectTab(dataMap);
			
			softAssert.assertEquals(enTasksTracker.NoResulttxt().getText(),"No results");
			Reporter.log("There is no outstanding tasks for the logged in user",true);
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}

	
	
	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 */
	@AfterMethod
	public void SetupAfterMethod() {
		lavanteUtils.refreshPage();
		lavanteUtils.switchtoFrame(null);

	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
