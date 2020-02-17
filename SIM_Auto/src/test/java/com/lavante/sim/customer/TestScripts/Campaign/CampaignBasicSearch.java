package com.lavante.sim.customer.TestScripts.Campaign;

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

/**
 * Created for basic search in campaign
 * 
 * @author Ramya
 *
 */
public class CampaignBasicSearch extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	 launchAppFromPOM(Platform,browser,Version);
	 initiate();	
	 openAPP();
	 waitForTime(4000);
	 objLoginPage.verifyLoginPageDisplayed();
	 List listofdatafrm=lavanteUtils.login("PaymentCenter", browser);
	 LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
	 LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	 enobjloginpage.logintoAPP(LdataMap);
	 
	 lavanteUtils.driver=driver;
	 
	 waitForTime(3000);
	 objHomePage.verifyHomePageDisplayed();
	}
	
	@BeforeMethod
	public void before() {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Campaigns");
		dataMap.put("subtab", "campaignSearchSetup");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Clear", "");
		objCampaignBasicSearchPage.formAction(dataMap);
	}
	
	/** 
	 * @author Ramya
	 * 
	 *         Test to verify basic search of a campaign based on campaign id
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	
	@Test
	  public void CampaignBasicSearchTest() throws FileNotFoundException, IOException, SQLException{
		    Reporter.log("Test Started for basic search of a campaign based on campaign id :"+ currenttime(),true);
		  	SoftAssert softassert =new SoftAssert();
			waitForTime(4000);
					
			String expCampaignId  = "select Top 1 * from CampaignDetails order by CampaignID DESC;";
      		expCampaignId = lavanteUtils.fetchDBdata(expCampaignId);
			LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
			dataMap.put("CampaignId", expCampaignId);
			dataMap.put("Search", "");
			objCampaignBasicSearchPage.search(dataMap);
			
			//Verifying expected campaign id with actual campaign id
			waitForTime(4000);
			switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
			String actCampaignID = objCampaignBasicSearchPage.getColumnText("Campaign ID", 0);
				
			softassert.assertEquals(actCampaignID, expCampaignId,"expected campaign id " +expCampaignId + "is not matching with actual campaign id " +actCampaignID);
			Reporter.log("Verification : expected  campaign id "+ expCampaignId + "with actual campaign id " +actCampaignID);
			softassert.assertAll();
			Reporter.log("Test Ended for basic search of campaign id :" + currenttime(),true);
		}
	
	/**
	 * Do a basic search using single criteria and clear the search and 
	 * verify whether the search is getting cleared
	 * @author Ramya Raj
	 * @throws Exception
	 */
	// @Test[Dont knw why it is commented]
	public void VerifyBasicSearchClear() throws Exception
	{
		
		Reporter.log("Test Started for Basic Search for single criteria and clear the search: "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		
		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String expcount = ""+lavanteUtils.getCount();
		
		switchtoFrame(null);
		String expCampaignId  = "select Top 1 * from CampaignDetails order by CampaignID DESC;";
  		expCampaignId = lavanteUtils.fetchDBdata(expCampaignId);
		dataMap.put("CampaignId", expCampaignId);
		dataMap.put("Search", "");
		objCampaignBasicSearchPage.search(dataMap);
		
		switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String searchCount = ""+lavanteUtils.getCount();
		softassert.assertFalse(expcount.equals(searchCount), "After search count is equal to no search count");

		dataMap.put("Clear", "");
		objCampaignBasicSearchPage.formAction(dataMap);
		lavanteUtils.waitForTime(4000);

		lavanteUtils.switchtoFrame(objCampaignBasicSearchPage.IframeSearchResult());
		String clearCount = ""+lavanteUtils.getCount();
		Reporter.log("After clear count is not equal to no search count,Exp:"+expcount+",ACtual :"+clearCount,true);
		softassert.assertTrue(expcount.equals(clearCount), "After clear count is not equal to no search count,Exp:"+expcount+",ACtual :"+clearCount);
				
		softassert.assertAll();
		Reporter.log("Test Ended for verification of clearing the search: "+currenttime());
	}
	
	
	@AfterMethod
	public void SetupAftermethod() {
		refreshPage();
	}
	
	@AfterClass
	public void close(){
	   enobjhomePage.logout();
	   quitBrowser();
	}
}
  

