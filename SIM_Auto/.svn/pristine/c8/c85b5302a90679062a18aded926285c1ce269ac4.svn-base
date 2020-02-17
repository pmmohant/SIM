package com.lavante.sim.customer.TestScripts.Campaign;

import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
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


public class CampaignAdvancedSearch extends PageInitiator{
	
	LavanteUtils lavanteUtils = new LavanteUtils();
				
	/**
	 * This class all test starts using login page and driver initialization
	 * @author Ramya Raj
	 * ;
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception
	{
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		lavanteUtils.driver=driver;
		
		List<?> listofdatafrm=lavanteUtils.login("PaymentCenter",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
				
	}
	
	@BeforeMethod
	public void setup() {
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Campaigns");
		dataMap.put("subtab", "campaignSearchSetup");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.click(objcampaignAdvancedSearchPage.AdvanceSearchTab());
	}
	
	/**
	 * Do an advance search using build query
	 * @author Ramya Raj 	 	 	 	
	 * @throws Exception
	 */
	@Test
	public void AdvanceSearchBuildQuery() throws Exception
	{
		Reporter.log("Test Started for Advance Search using Build Query: "+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
		dataMap.clear();
		dataMap.put("CampaignType", "Onboarding");
		dataMap.put("Search", "");
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
		
		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
		String data="";
		List<WebElement> campaignTypeList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
		if(campaignTypeList.size()>0){
			for(int i=0; i<campaignTypeList.size(); i++) {
				if(dataMap.containsKey("CampaignType")){
					data=dataMap.get("CampaignType");
					Reporter.log("Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText(),true);
					softassert.assertTrue(data.contains(campaignTypeList.get(i).getText()),"Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText());
					flag=true;
				}
			 }
	     }
				
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Advance Campaigns Search: "+currenttime());
	 
	}
	
	/**
	 * Do an advance search using Build query, Save search and delete the saved search
	 * @author Ramya
	 * @throws Exception
	 */
	@Test
	public void AdvanceSearchSaveDeleteQuery() throws Exception
	{
		Reporter.log("Test Started for Advance Search using Build Query , Saving the query and delete the query: "+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		dataMap.put("DeleteQuery", "");
		dataMap.put("SpecifyQuery", "testQuery");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		dataMap.remove("DeleteQuery");
		
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
		switchtoFrame(objcampaignAdvancedSearchPage.IframeCampaignsAdvSearch());
		
		dataMap.put("CampaignType", "Onboarding");
		dataMap.put("SaveQuery","");
		String qname = "testQuery"+randomnum();
		dataMap.put("SpecifyQuery", qname);
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);

		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
		String data="";
		List<WebElement> campaignTypeList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
		if(campaignTypeList.size()>0){
			for(int i=0; i<campaignTypeList.size(); i++) {
				if(dataMap.containsKey("CampaignType")){
					data=dataMap.get("CampaignType");
					Reporter.log("Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText(),true);
					softassert.assertTrue(data.contains(campaignTypeList.get(i).getText()),"Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText());
					flag=true;
				}
			 }
	     }
		
		dataMap.put("DeleteQuery", "");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		
		//Verifying query deletion
		String queryname  = dataMap.get("SpecifyQuery");
	    boolean flag1= lavanteUtils.isElementDisplayed("//span[@title= '" +qname+ "']/../..//td[3]/a");
	    softassert.assertFalse(flag1,"Query Exist:"+dataMap.get(queryname));
		
	    if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Advance Campaigns Search,save and delete query: "+currenttime());
	 
	}
	
	/**
	 * Do an advance search using Build query, Save the search and run saved search
	 * @author Ramya
	 * @throws Exception
	 */
    @Test
	public void AdvanceSearchSaveRunQuery() throws Exception
	{
		Reporter.log("Test Started for Advance Search using Build Query , Saving the query and run the query: "+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		dataMap.put("DeleteQuery", "");
		dataMap.put("SpecifyQuery", "testQuery");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		dataMap.remove("DeleteQuery");
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());

		dataMap.put("CampaignType", "Onboarding");
		dataMap.put("SaveQuery","");
		String qname = "testQuery"+randomnum();
		dataMap.put("SpecifyQuery", qname);
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
		
		dataMap.remove("DeleteQuery");
		dataMap.put("RunQuery", "");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		dataMap.remove("RunQuery");
		
		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
		String data="";
		List<WebElement> campaignTypeList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
		if(campaignTypeList.size()>0){
			for(int i=0; i<campaignTypeList.size(); i++) {
				if(dataMap.containsKey("CampaignType")){
					data=dataMap.get("CampaignType");
					Reporter.log("Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText(),true);
					softassert.assertTrue(data.contains(campaignTypeList.get(i).getText()),"Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText());
					flag=true;
				}
			 }
	     }
		
		dataMap.put("DeleteQuery", "");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Advance Campaigns Search,save and run query: "+currenttime());
	 
	}
	
	/**
	 * Do an advance search using build query , save query and edit query
	 * @author Ramya Raj 	 	 	 	
	 * @throws Exception
	 */
   @Test
     public void AdvanceSearchSaveEditQuery() throws Exception
 	{
 		Reporter.log("Test Started for Advance Search using Build Query , Save query and edit query: "+currenttime());
 		SoftAssert softassert=new SoftAssert();
 		boolean flag=false;
 		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
 		
 		dataMap.put("DeleteQuery", "");
 		dataMap.put("SpecifyQuery", "testQuery");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		dataMap.remove("DeleteQuery");
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
 		
 		String expCampaignType = "Survey";
 		dataMap.put("CampaignType", expCampaignType);
 		dataMap.put("SaveQuery","");
 		String qname = "testQuery"+randomnum();
 		dataMap.put("SpecifyQuery", qname);
 		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);

 		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
 		List<WebElement> campaignTypeList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
 		if(campaignTypeList.size()>0){
 			for(int i=0; i<campaignTypeList.size(); i++) {
 				if(dataMap.containsKey("CampaignType")){
 					Reporter.log("Search results of criteria1, Expected: "+expCampaignType+" Actual: "+campaignTypeList.get(i).getText(),true);
 					softassert.assertTrue(expCampaignType.contains(campaignTypeList.get(i).getText()),"Search results of criteria1, Expected: "+expCampaignType+" Actual: "+campaignTypeList.get(i).getText());
 					flag=true;
 				}
 			 }
 	     }
 		
 		dataMap.put("EditQuery", "");
 		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
 		dataMap.remove("EditQuery");
 		
 		String expCampaignStatus = "Completed";
 		dataMap.put("CampaignStatus", expCampaignStatus);
 		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
 		
 		//Verify edit query
 		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
		List<WebElement> campaignTypeList1 = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
 		if(campaignTypeList1.size()>0){
 			List<WebElement> campaignStatusList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Status");
 			for(int i=0; i<campaignTypeList1.size(); i++) {
 				    Reporter.log("Search results of criteria1, Expected: "+expCampaignType+" Actual: "+campaignTypeList1.get(i).getText(),true);
 					softassert.assertTrue(expCampaignType.contains(campaignTypeList1.get(i).getText()),"Search results of criteria1, Expected: "+expCampaignType+" Actual: "+campaignTypeList1.get(i).getText());
 					Reporter.log("Search results of criteria1, Expected: "+expCampaignStatus+" Actual: "+campaignStatusList.get(i).getText(),true);
 					softassert.assertTrue(expCampaignStatus.contains(campaignStatusList.get(i).getText()),"Search results of criteria1, Expected: "+expCampaignStatus+" Actual: "+campaignStatusList.get(i).getText());
 					flag=true;
 			}
 		}
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
		
        softassert.assertAll();
 		Reporter.log("Test Ended for Verification of Advance Campaigns Search,save and delete query: "+currenttime());
 	 
 	}

	/**
	 * Do an advance search using build query , save query and clear query
	 * @author Ramya Raj 	 	 	 	
	 * @throws Exception
	 */
     @Test
     public void AdvanceSearchClearQuery() throws Exception
 	{
 		Reporter.log("Test Started for Advance Search using Build Query , Save query and clear query: "+currenttime());
 		SoftAssert softassert=new SoftAssert();
 		boolean flag=false;
 		
 		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
 		dataMap.put("DeleteQuery", "");
 		dataMap.put("SpecifyQuery", "testQuery");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		dataMap.remove("DeleteQuery");
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
 		
 		dataMap.put("CampaignType", "Survey");
 		dataMap.put("SaveQuery","");
 		String qname = "testQuery"+randomnum();
 		dataMap.put("SpecifyQuery", qname);
 		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
 		
 		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
 		String data="";
 		List<WebElement> campaignTypeList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
 		if(campaignTypeList.size()>0){
 			for(int i=0; i<campaignTypeList.size(); i++) {
 				if(dataMap.containsKey("CampaignType")){
 					data=dataMap.get("CampaignType");
 					Reporter.log("Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText(),true);
 					softassert.assertTrue(data.contains(campaignTypeList.get(i).getText()),"Search results of criteria1, Expected: "+data+" Actual: "+campaignTypeList.get(i).getText());
 					flag=true;
 				}
 			 }
 	     }
 		
 		int expCampaignCount = campaignTypeList.size();
 		lavanteUtils.switchtoFrame(null);
 		click(objcampaignAdvancedSearchPage.clearButton());
 		lavanteUtils.switchtoFrame(objcampaignAdvancedSearchPage.IframeSearchResults());
		campaignTypeList = objCampaignBasicSearchPage.iterateSearchHeaderFindColList("Campaign Type");
		int actCampaignCount = campaignTypeList.size();
 		if(campaignTypeList.size()>0){
 			softassert.assertTrue(expCampaignCount!=actCampaignCount);
 			flag=true;
 		}
 		 		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
 		
		softassert.assertAll();
 		Reporter.log("Test Ended for Verification of Advance Campaigns Search,save and clear query: "+currenttime());
 	 
 	}
	
	/**
	 * Do an advance search using Build query, save and verify in private query
	 * @author Ramya
	 * @throws Exception
	 */
	//@Test [Dont know why commented]
	public void AdvanceSearchSavePrivateQuery() throws Exception
	{
		Reporter.log("Test Started for Advance Search using Build Query , Save query and verify in private query: "+currenttime());
		SoftAssert softassert=new SoftAssert();
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
		switchtoFrame(objcampaignAdvancedSearchPage.IframeCampaignsAdvSearch());
		dataMap.put("CampaignType", "Onboarding");
		dataMap.put("SaveQuery","");
		String qname = "testQuery"+randomnum();
		dataMap.put("SpecifyQuery", qname);
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
		
		boolean flag1= lavanteUtils.isElementDisplayed(lavanteUtils.driver.findElement(By.xpath("//table[@id='private_queries']/tbody/..//td[@title='"+dataMap.get("SpecifyQuery")+ "']")));
	    softassert.assertTrue(flag1,"Query exist in private queries:"+dataMap.get("SpecifyQuery"));
	    dataMap.put("DeleteQuery", "");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		    
	    softassert.assertAll();
		Reporter.log("Test Ended for Verification of Advance Campaigns save and verify in private queries: "+currenttime());
	    
	}
	
	/**
	 * Do an advance search using Build query, save and verify in public query
	 * @author Ramya
	 * @throws Exception
	 */
	//@Test[Dont know why commented
	public void AdvanceSearchSavePublicQuery() throws Exception
	{
		Reporter.log("Test Started for Advance Search using Build Query , Save query and verify in public query: "+currenttime());
		SoftAssert softassert=new SoftAssert();
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
		switchtoFrame(objcampaignAdvancedSearchPage.IframeCampaignsAdvSearch());
		dataMap.put("CampaignType", "Onboarding");
		dataMap.put("SaveQuery","");
		String qname = "testQuery"+randomnum();
		dataMap.put("SpecifyQuery", qname);
		dataMap.put("SharewithUsers","");
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);

		boolean flag1= lavanteUtils.isElementDisplayed(lavanteUtils.driver.findElement(By.xpath("//table[@id='public_queries']/tbody/..//td[@title='"+dataMap.get("SpecifyQuery")+ "']")));
	    softassert.assertTrue(flag1,"Query exist in private queries:"+dataMap.get("SpecifyQuery"));
	    dataMap.put("DeleteQuery", "");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		    
	    softassert.assertAll();
		Reporter.log("Test Ended for Verification of Advance Campaigns save and verify in public queries: "+currenttime());
	    
	}
	
	/**
	 * Do an advance search using Build query, save and verify duplicate error message
	 * @author Ramya
	 * @throws Exception
	 */
	@Test
	public void AdvanceSearchSaveDuplicateQuery() throws Exception
	{
		Reporter.log("Test Started for Advance Search using Build Query , Save query and verify duplicate error message: "+currenttime());
		SoftAssert softassert=new SoftAssert();
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
		dataMap.put("CampaignType", "Onboarding");
		dataMap.put("SaveQuery","");
		String qname = "testQuery"+randomnum();
		dataMap.put("SpecifyQuery", qname);
		dataMap.put("SharewithUsers","");
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
		
		lavanteUtils.click(objcampaignAdvancedSearchPage.clearButton());
		lavanteUtils.fluentwait(objcampaignAdvancedSearchPage.BuildQueryBtn());
		lavanteUtils.click(objcampaignAdvancedSearchPage.BuildQueryBtn());
		String qname1 = "testQuery"+randomnum();
		dataMap.put("SpecifyQuery", qname1);
		objcampaignAdvancedSearchPage.AdvanceSearch(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		String alertText = objcampaignAdvancedSearchPage.alertDuplicateText().getText().trim();
		Reporter.log("Error MSG Verification,Actuals:"+alertText+", Exp:Query is duplicate by search criteria, please enter a different query or use the saved query:",true);
		softassert.assertEquals(alertText,"Query is duplicate by search criteria, please enter a different query or use the saved query: " + qname);
				
		dataMap.put("SpecifyQuery",qname);
	    dataMap.put("DeleteQuery", "");
		objcampaignAdvancedSearchPage.savedQueryActions(dataMap);
		    
	    softassert.assertAll();
		Reporter.log("Test Ended for Verification of Advance Campaigns save and verify for duplicate error message: "+currenttime());
	    
	}
		

	@AfterMethod
	public void SetupAftermethod() {
		switchtoFrame(null);
	}
	
	@AfterClass
	public void close(){
	   enobjhomePage.logout();
	   quitBrowser();
	}
}


		

