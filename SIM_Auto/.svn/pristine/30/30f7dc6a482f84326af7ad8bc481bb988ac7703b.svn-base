package com.lavante.sim.customer.TestScripts.Transactions.Claims;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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

public class ClaimBasicSearchTest extends PageInitiator{

	LavanteUtils lavanteUtils=new LavanteUtils();	
	
	/**
	 * This class all test starts using login page and driver initialization
	 * @author Vidya.C
	 * 
	 */
	@BeforeMethod
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception
	{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP1();	
		lavanteUtils.driver=driver;
		
		List listofdatafrm=lavanteUtils.login("Kroger",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
	}
	
	@BeforeMethod
	public void setup() {
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Invoice");
		dataMap.put("subtab", "customerClaimResult");
		
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
		
		dataMap.put("Clear","");
		enClaimsBasicSearch.formAction(dataMap);
	}
	
	/**
	 * Do a basic search using single criteria
	 * @author Vidya.C
	 * @throws Exception
	 */
	@Test
	public void BasicSearchSingleCriteria() throws Exception
	{
		
		Reporter.log("Test Started for Basic Search for single criteria: "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		String expdata = "FR - Freight";
		dataMap.put("ClaimType", expdata);
		dataMap.put("Search","");
		enClaimsBasicSearch.Search(dataMap);
		
		lavanteUtils.waitForTime(5000);
		
		List<WebElement> criteria = enClaimsPage.iterateSearchHeaderFindColList("Claim Type");
		if(criteria.size()>0) {
			for(int i=0;i<criteria.size();i++) {
				System.out.println("Search results, Expected: "+expdata+" Actual: "+criteria.get(i).getText());
				Reporter.log("Search results, Expected: "+expdata+" Actual: "+criteria.get(i).getText());
				softassert.assertEquals(criteria.get(i).getText(), expdata,"Search results are not matching, Expected: "+expdata+" Actual: "+criteria.get(i).getText());
				flag = true;
			}
		} else {
			softassert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for single criteria: "+currenttime());
	}
	
	/**
	 * Do a basic search using multiple criteria
	 * @author Vidya.C
	 * @throws Exception
	 */
	@Test
	public void BasicSearchMultipleCriteria() throws Exception
	{
		
		Reporter.log("Test Started for Basic Search for multiple criteria: "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		String expClaimType = "FR - Freight";
		String expClaimStatus = "Pending";
		dataMap.put("ClaimType", expClaimType);
		dataMap.put("ClaimStatus",expClaimStatus);
		dataMap.put("Search","");
		enClaimsBasicSearch.Search(dataMap);
		
		lavanteUtils.waitForTime(5000);
		
		dataMap.put("ClaimTypeCol", "");
		List<WebElement> claimTypeList = enobjsupplierPage.iterateSearchHeaderFindColList("Claim Type");
		List<WebElement> claimStatusList = enobjsupplierPage.iterateSearchHeaderFindColList("Claim Status");
		if(claimTypeList.size()>0) {
			for(int i=0;i<claimTypeList.size();i++) {
				System.out.println("Search results, Expected: "+expClaimType+" Actual: "+claimTypeList.get(i).getText());
				Reporter.log("Search results, Expected: "+expClaimType+" Actual: "+claimTypeList.get(i).getText());
				softassert.assertEquals(claimTypeList.get(i).getText(), expClaimType,"Search results are not matching, Expected: "+expClaimType
						+" Actual: "+claimTypeList.get(i).getText());
				softassert.assertEquals(claimStatusList.get(i).getText(), expClaimStatus,"Search results are not matching, Expected: "+expClaimStatus
						+" Actual: "+claimStatusList.get(i).getText());
				flag = true;
			}
		} else {
			softassert.assertEquals("No results", enClaimsPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for multiple criteria: "+currenttime());
	}
	
	/**
	 * Do a basic search using single criteria and clear the search and 
	 * verify whether the search is getting cleared
	 * @author Vidya.C
	 * @throws Exception
	 */
	@Test
	public void VerifyBasicSearchClear() throws Exception
	{
		
		Reporter.log("Test Started for Basic Search for single criteria and clear the search: "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		
		lavanteUtils.click(enClaimsPage.showCountlink());
		String expcount = enClaimsPage.GetResultsCount().getText();
		lavanteUtils.switchtoFrame(null);
		
		String expdata = "1022";
		dataMap.put("ClaimId", expdata);
		dataMap.put("Search","");
		enClaimsBasicSearch.Search(dataMap);
		
		lavanteUtils.waitForTime(5000);
		String searchCount = enClaimsPage.GetResultsCount().getText();
		lavanteUtils.switchtoFrame(null);

		dataMap.put("Clear", "");
		enClaimsBasicSearch.Search(dataMap);
		
		lavanteUtils.waitForTime(5000);
		String clearCount = enClaimsPage.GetResultsCount().getText();
		softassert.assertFalse(expcount.equals(searchCount), "After search count is equal to no search count");
		softassert.assertTrue(expcount.equals(clearCount), "After clear count is not equal to no search count");

		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for single criteria and clear the search: "+currenttime());
	}
	
	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
	}
	
	@AfterMethod
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}
}
