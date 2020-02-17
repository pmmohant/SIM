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

public class Config_FaxComments extends pageInitiator {
	
String faxComment="";
LavanteUtils lavanteUtils = new LavanteUtils();
	
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
		dataMap.put("subtab","otherConfiguration");
		homePage.selectTab(dataMap);
		
		configurationOthersPage.faxCommentsTabClick();
		
		}

	/**
	 * AddEdit Fax Comment -Will add a Fax comment and edit the fax 
	 * Verification of Comments
	 * 
	 * @author nagappa.vaddebail
	 */
	@Test
	public void addEditFaxComment()
	{
		 Reporter.log("Test Started for adding and editing Fax Comment: " + LavanteUtils.currenttime());
		 SoftAssert softAssert = new SoftAssert();
		 
		 //Adding new fax comment
		 String expFaxComment = "*AutoTest"+currenttime();
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 dataMap.put("FaxComment", expFaxComment);
		 dataMap.put("Active", "false");
		 dataMap.put("Save", "");
		
		 configurationOthersPage.addFaxComment(dataMap);
		 Reporter.log("Added new fax comment:"+expFaxComment);
		 waitForTime(4000);
		 boolean flagAdd=false;
		 boolean flagEdit=false;
		 for(int i=0; i < configurationOthersPage.faxComment().size(); i++)
		 {
			 String actFaxComment = configurationOthersPage.faxComment().get(i).getText().trim();
			 
			 System.out.println("Fax Comment,Excpected: " + expFaxComment + " , Actual: " + actFaxComment);
			 if(expFaxComment.equalsIgnoreCase(actFaxComment))
			 {				
				 softAssert.assertEquals(actFaxComment, expFaxComment);
				 Reporter.log("Fax Comment, Excpected: " + expFaxComment + "Actual: " + actFaxComment);
				 flagAdd=true;
				 expFaxComment = "*AutoTestComment3Edit"+currenttime();
				 dataMap.put("FaxComment", expFaxComment);
				 faxComment=expFaxComment;
				 lavanteUtils.click(configurationOthersPage.editFax().get(i));
				 lavanteUtils.switchtoFrame(configurationOthersPage.IFRAMEaddNewFrameFax());
				 configurationOthersPage.fillFaxComment(dataMap);
				 configurationOthersPage.formFaxComment(dataMap);
				 waitForTime(4000);
				 for( i=0; i < configurationOthersPage.faxComment().size(); i++)
				 {
					 String actEditFaxComment = configurationOthersPage.faxComment().get(i).getText().trim();
					 System.out.println("Excpected after edit: " + expFaxComment + " , Actual after edit: " + actFaxComment);
					// Reporter.log("Excpected: " + faxComment + " , Actual: " + actEditFaxComment);
					 if(expFaxComment.equalsIgnoreCase(actEditFaxComment))
					 {				
						 softAssert.assertEquals(actEditFaxComment, expFaxComment,"Fax Comments,Excpected after edit: " + expFaxComment + "Actual after edit: " + actEditFaxComment);
						 Reporter.log("Fax Comments,Excpected after edit: " + expFaxComment + "Actual after edit: " + actEditFaxComment);
						 flagEdit=true;
						 break;
					 }
				 }
				 break;
			 }
		 }
		System.out.println("flagAdd: " + flagAdd + " flagEdit: " + flagEdit);
		softAssert.assertTrue(flagAdd,"Please Recheck the Test"); 
		softAssert.assertTrue(flagEdit,"Please Recheck the Test for Edit");
		
		softAssert.assertAll();
		Reporter.log("Test Ended for adding and editing Fax Comment: "+LavanteUtils.currenttime());	
	}
	
	/**
	 * AddDelete Fax Comment - Will add a Fax comment and delete the fax 
	 * Verification of Comments
	 * 
	 * @author nagappa.vaddebail
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
		
	@Test
	public void addDeleteFaxComment() throws FileNotFoundException, IOException, SQLException{
		Reporter.log("Test Started for adding and deleting Fax Comment: " + LavanteUtils.currenttime());
		
		 SoftAssert softAssert = new SoftAssert();
		 //Adding new fax comment
		 String expFaxComment = "*AutoTestComment4"+currenttime();
		 LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		 dataMap.put("FaxComment", expFaxComment);
		 dataMap.put("Active", "true");
		 dataMap.put("Save", "");
		 Reporter.log("Adding new fax comment");
		 configurationOthersPage.addFaxComment(dataMap);
		 waitForTime(4000);
		 boolean flagAdd=false;
		 boolean flagDelete=true;
	
		 outr:for(int i=0; i < configurationOthersPage.faxComment().size(); i++)
		 {
			 String actFaxComment = configurationOthersPage.faxComment().get(i).getText().trim();			 
			 System.out.println("Excpected: " + expFaxComment + " , Actual: " + actFaxComment);
			 if(expFaxComment.equalsIgnoreCase(actFaxComment))
			 {				
				 softAssert.assertEquals(actFaxComment, expFaxComment);
				 Reporter.log("Excpected: " + expFaxComment + "Actual: " + actFaxComment);
				 flagAdd=true;
				 
				 click(configurationOthersPage.deleteFax().get(i));
				 lavanteUtils.click(configurationOthersPage.OkbtnFax());
				 
					String query="select Name from as_phone_extensions where [Name] like '"+expFaxComment+"'";
					String queryResult=lavanteUtils.fetchDBdata(query);
					
					System.out.println("Query= " + query + " result = " + queryResult);
					 if(queryResult != null){
						 flagDelete=false;
					 }
				 break outr;
			 }
		 }
		System.out.println("flagAdd: " + flagAdd + " flagDelete: " + flagDelete);
		softAssert.assertTrue(flagAdd); 
		softAssert.assertTrue(flagDelete);
		
		softAssert.assertAll();
		
		 Reporter.log("Test Ended for adding and deleting Fax Comment: "+LavanteUtils.currenttime());
		 }
	
	@AfterMethod
	public void AfterMethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
		
	/*	 Commented as the delete query is not working.
	 *   Uncomment this code once the delete query is functioning.
	 * if(faxComment.length()>0){
			String query="delete from as2_Fax_Changes where [change] like '"+faxComment+"'";
			System.out.println("Query is before delete is: " + query);
			String resultSet = lavanteUtils.fetchDBdata(query);
			System.out.println("resultSet:: " + resultSet);
		}*/
	}
	
	@AfterClass
	  public void QuitBrowser() {
		homePage.logout();
		quitBrowser();
	  }
	
}
