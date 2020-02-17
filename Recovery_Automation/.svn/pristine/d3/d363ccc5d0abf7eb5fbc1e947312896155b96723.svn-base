package com.lavante.recovery.TestScripts.UAT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class Config_OutReachSetup extends pageInitiator{
	
LavanteUtils lavanteUtils = new LavanteUtils();
String outReachSeq="";
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();
		lavanteUtils.driver=driver;
		loginPage.login();
		waitForTime(3000);
		homePage.SelectAudit("ANY");
		
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab","configuration");
		dataMap.put("subtab","outreachSetup");
		homePage.selectTab(dataMap);
			
		}
	
	/**
	 * AddEdit OutReach - Will add an OutReach and Edit the OutReach 
	 * Verification of Comments
	 * 
	 * @author nagappa.vaddebail
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	
	@Test(priority=1, groups={"Configuration","OutReach"})
	public void addEditOutReach() throws FileNotFoundException, IOException, SQLException{
		 Reporter.log("Test Started for adding and editing New outreach: " + LavanteUtils.currenttime());
		 SoftAssert softAssert = new SoftAssert();
		 //Below query is used to get the max outreach sequence
		 String qry = "select max(OutreachSequence)+1 from lc_OutreachSetup";
		 String maxOutreachSeq=lavanteUtils.fetchDBdata(qry);
		 
		 //Adding new outreach
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 String expOutReachType="Fax";
		 String expOutReachSequence=maxOutreachSeq;
		 String expCategory="Statement";
		 String expEmailTemplate="Email Statement";
		 String expRankCutOFf="88";
		 String expWaitDays="18";
		 
		 dataMap.put("OutReachType", expOutReachType);
		 dataMap.put("OutReachSequence", expOutReachSequence);
		 dataMap.put("Category", expCategory);
		 dataMap.put("EmailTemplate", expEmailTemplate);
		 dataMap.put("RankCutOFf", expRankCutOFf);
		 dataMap.put("WaitDays", expWaitDays);
		 
		 dataMap.put("Save", "");
		 configurationOutReachPage.addNewOutReach(dataMap);
		 
		 Reporter.log("Added new OutReach:"+expOutReachType);
		 
		 boolean flagAdd=false;
		 boolean flagEdit=false;
		 waitForTime(5000);
		 int indexAdd=Integer.parseInt(expOutReachSequence);
		 int i=indexAdd-1;
		 System.out.println("index value= " +indexAdd + " i= " + i +" configurationOutReachPage.outreachType().size() " + configurationOutReachPage.outreachType().size());
		
		 	 int countOfTotalRows = configurationOutReachPage.outreachType().size();
		 	 if(countOfTotalRows>i){
		 		 
			 String actOutReachType = configurationOutReachPage.outreachType().get(i).getText().trim();
			 String actOutreachSeq = configurationOutReachPage.outreachSequence().get(i).getText().trim();
			 String actWaitDays = configurationOutReachPage.waitDays().get(i).getText().trim();
			 String actRankCutOFf = configurationOutReachPage.rankCutOff().get(i).getText().trim();
			 String actEmailTemplate = configurationOutReachPage.emailTemplate().get(i).getText().trim();
			 String actCategory = configurationOutReachPage.category().get(i).getText().trim();
			 System.out.println(" actOutReachType= "+ actOutReachType + " actWaitDays= " + actWaitDays
					 + " actRankCutOFf= " + actRankCutOFf + " actEmailTemplate= " + actEmailTemplate
					 + " actCategory= " + actCategory + " countOfTotalRows= " + countOfTotalRows);
			 
			 expEmailTemplate= expEmailTemplate.replace(" ", "")+".vm";
			
				 if(actOutreachSeq.equalsIgnoreCase(expOutReachSequence)){
					 flagAdd=true;
					 
					 softAssert.assertEquals(expOutReachType, actOutReachType);
					 Reporter.log("Out Reach Type, Expected: " + expOutReachType + "Out Reach Type, Actual: " + actOutReachType);

					 softAssert.assertEquals(expWaitDays, actWaitDays);
					 Reporter.log("Wait Days, Expected: " + expWaitDays + "Wait Days, Actual: " + actWaitDays);
					 
					 //Email template will be available only for Email outreach
					 if(expOutReachType.equalsIgnoreCase("Email")){
					 softAssert.assertEquals(expEmailTemplate, actEmailTemplate);
					 Reporter.log("Email Template, Expected: " + expEmailTemplate + "Email Template, Actual: " + actEmailTemplate);
					 }
					 softAssert.assertEquals(expCategory, actCategory);
					 Reporter.log("Edit Category, Expected: " + expCategory + "Edit Category, Actual: " + actCategory);
					 
					 softAssert.assertEquals(expRankCutOFf, actRankCutOFf);
					 Reporter.log("Rank CutOff, Expected: " + expRankCutOFf + "Rank CutOff, Actual: " + actRankCutOFf);
					 
					 //updating the data for edit action and passing the same data to dataMap.
					 expOutReachType="Email";
					 expOutReachSequence=maxOutreachSeq;
					 expRankCutOFf="100";
					 expWaitDays="20";
					 dataMap.put("OutReachType", expOutReachType);
					 dataMap.put("OutReachSequence", expOutReachSequence);
					 //dataMap.put("Category", expCategory);
					 //dataMap.put("EmailTemplate", expEmailTemplate);
					 dataMap.put("RankCutOFf", expRankCutOFf);
					 dataMap.put("WaitDays", expWaitDays);
					 outReachSeq=expOutReachSequence;
					 int indexEdit=Integer.parseInt(expOutReachSequence);
					 i=indexEdit-1;
					 
					 lavanteUtils.click(configurationOutReachPage.editAction().get(i));
					 configurationOutReachPage.fillOutReach(dataMap);
					 configurationOutReachPage.formOutReach(dataMap);
					 waitForTime(3000);
					
						 String actEditOutReachType = configurationOutReachPage.outreachType().get(i).getText().trim();
						 String actEditOutreachSeq = configurationOutReachPage.outreachSequence().get(i).getText().trim();
						 String actEditWaitDays = configurationOutReachPage.waitDays().get(i).getText().trim();
						 String actEditRankCutOFf = configurationOutReachPage.rankCutOff().get(i).getText().trim();
						 String actEditEmailTemplate = configurationOutReachPage.emailTemplate().get(i).getText().trim();
						 String actEditCategory = configurationOutReachPage.category().get(i).getText().trim();
						
						 if(actEditOutreachSeq.equalsIgnoreCase(expOutReachSequence))
						 {
							 flagEdit=true;	
							 softAssert.assertEquals(expOutReachType, actEditOutReachType);
							 Reporter.log("Out Reach Type, Expected: " + expOutReachType + "Out Reach Type, Actual: " + actEditOutReachType);

							 softAssert.assertEquals(expWaitDays, actEditWaitDays);
							 Reporter.log("Wait Days, Expected: " + expWaitDays + "Wait Days, Actual: " + actEditWaitDays);
							
							 //Email template will be available only for Email outreach
							 if(expOutReachType.equalsIgnoreCase("Email")){
  							 softAssert.assertEquals(expEmailTemplate, actEditEmailTemplate);
							 Reporter.log("Email Template, Expected: " + expEmailTemplate + "Email Template, Actual: " + actEditEmailTemplate);
							 }
							 softAssert.assertEquals(expCategory, actEditCategory);
							 Reporter.log("Edit Category, Expected: " + expCategory + "Edit Category, Actual: " + actEditCategory);
							 
							 softAssert.assertEquals(expRankCutOFf, actEditRankCutOFf);
							 Reporter.log("Rank CutOff, Expected: " + expRankCutOFf + "Rank CutOff, Actual: " + actEditRankCutOFf);
						}				
				 }
			 
		System.out.println("flagAdd: " + flagAdd + " flagEdit: " + flagEdit);
		softAssert.assertTrue(flagAdd,"Please Recheck the Test"); 
		softAssert.assertTrue(flagEdit,"Please Recheck the Test for Edit");
			
		softAssert.assertAll();
		Reporter.log("Test Ended for adding and editing OutReach: "+LavanteUtils.currenttime());	
		
	}
}
	
	/**
	 * AddDelete OutReach - Will add an OutReach and Delete the OutReach 
	 * Verification of Comments
	 * 
	 * @author nagappa.vaddebail
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	
	@Test(priority=2, groups={"Configuration","OutReach"})
	public void addDeleteOutReach() throws FileNotFoundException, IOException, SQLException{
		 Reporter.log("Test Started for adding and deleting New outreach: " + LavanteUtils.currenttime());
		 SoftAssert softAssert = new SoftAssert();
		//Below query is used to get the max outreach sequence
		 String qry = "select max(OutreachSequence)+1 from lc_OutreachSetup";
		 String maxOutreachSeq=lavanteUtils.fetchDBdata(qry);
		 
		 //Adding new outreach
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 String expOutReachType="Email";
		 String expOutReachSequence=maxOutreachSeq;
		 String expCategory="Statement";
		 String expEmailTemplate="Email Statement";
		 String expRankCutOFf="29";
		 String expWaitDays="7";
		 
		 dataMap.put("OutReachType", expOutReachType);
		 dataMap.put("OutReachSequence", expOutReachSequence);
		 dataMap.put("Category", expCategory);
		 dataMap.put("EmailTemplate", expEmailTemplate);
		 dataMap.put("RankCutOFf", expRankCutOFf);
		 dataMap.put("WaitDays", expWaitDays);
		 
		 dataMap.put("Save", "");
		 configurationOutReachPage.addNewOutReach(dataMap);
		 
		 Reporter.log("Added new OutReach:"+expOutReachType);
		 
		 boolean flagAdd=false;
		 boolean flagDelete=true;
		 waitForTime(5000);
		 int index=Integer.parseInt(expOutReachSequence);
		 int i=index-1;
		 
		 int countOfTotalRows = configurationOutReachPage.outreachType().size();
	 	 if(countOfTotalRows>i){
		 	 String actOutReachType = configurationOutReachPage.outreachType().get(i).getText().trim();
		 	 String actOutreachSeq = configurationOutReachPage.outreachSequence().get(i).getText().trim();
			 String actWaitDays = configurationOutReachPage.waitDays().get(i).getText().trim();
			 String actRankCutOFf = configurationOutReachPage.rankCutOff().get(i).getText().trim();
			 String actEmailTemplate = configurationOutReachPage.emailTemplate().get(i).getText().trim();
			 String actCategory = configurationOutReachPage.category().get(i).getText().trim();
			 System.out.println(" actOutReachType "+ actOutReachType + " actWaitDays " + actWaitDays
					 + " actRankCutOFf " + actRankCutOFf + " actEmailTemplate " + actEmailTemplate
					 + " actCategory " + actCategory);
			 expEmailTemplate= expEmailTemplate.replace(" ", "")+".vm";
			 
			 if(actOutreachSeq.equalsIgnoreCase(expOutReachSequence))
				 {
					 flagAdd=true;
					 softAssert.assertEquals(expOutReachType, actOutReachType);
					 Reporter.log("Out Reach Type, Expected: " + expOutReachType + "Out Reach Type, Actual: " + actOutReachType);

					 softAssert.assertEquals(expWaitDays, actWaitDays);
					 Reporter.log("Wait Days, Expected: " + expWaitDays + "Wait Days, Actual: " + actWaitDays);

					//Email template will be available only for Email outreach
					 if(expOutReachType.equalsIgnoreCase("Email")){
					 softAssert.assertEquals(expEmailTemplate, actEmailTemplate);
					 Reporter.log("Email Template, Expected: " + expEmailTemplate + "Email Template, Actual: " + actEmailTemplate);
					 }
					 softAssert.assertEquals(expCategory, actCategory);
					 Reporter.log("Edit Category, Expected: " + expCategory + "Edit Category, Actual: " + actCategory);
					 
					 softAssert.assertEquals(expRankCutOFf, actRankCutOFf);
					 Reporter.log("Rank CutOff, Expected: " + expRankCutOFf + "Rank CutOff, Actual: " + actRankCutOFf);
						
					 lavanteUtils.click(configurationOutReachPage.deleteAction().get(i));
					 lavanteUtils.click(configurationOutReachPage.OkbtnOutReach());
					 String query = "select OutreachSequence from lc_OutreachSetup where OutreachSequence='" + expOutReachSequence +"'";;
					 String queryResult=lavanteUtils.fetchDBdata(query);
						
						System.out.println("Query= " + query + " result = " + queryResult);
						 if(queryResult != null){
							 flagDelete=false;
						 }
					 }
				  			 
		System.out.println("flagAdd: " + flagAdd + " flagDelete: " + flagDelete);
		softAssert.assertTrue(flagAdd,"Please Recheck the Test"); 
		softAssert.assertTrue(flagDelete,"Please Recheck the Test for delete");
			
		softAssert.assertAll();
		Reporter.log("Test Ended for adding and editing OutReach: "+LavanteUtils.currenttime());	
	}
	}
	
	/**
	 * In this method, added the code to delete the newly added/edited out reach 
	 * to validate Add and Edit functionality. 
	 *  
	 * @author nagappa.vaddebail
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@AfterMethod
	public void afterMethod() throws FileNotFoundException, IOException, SQLException  {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
		if(outReachSeq.length()>0){
			String query="delete from lc_OutreachSetup where OutreachSequence='"+ outReachSeq +"'";
			System.out.println("Query is before delete is: " + query);
			String resultSet = lavanteUtils.fetchDBdata(query);
			System.out.println("resultSet:: " + resultSet);
		}
	}
	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }
	
}
