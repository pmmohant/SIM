package com.lavante.sim.customer.TestScripts.Messages;

import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class MessageSearchActionTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
	String Email="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
	
		lavanteUtils.driver = driver;

		List<?> listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		Email=LdataMap.get("username");
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}
	
	/**
	 * Before method to navigate to the Message Tab
	 * 
	 */
	@BeforeMethod
	public void navigateToMessage(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

		LdataMap.put("maintab", "message");
		enobjhomePage.selectTab(LdataMap);
		enMessage.switchView(LdataMap);
		waitforPageload(enMessage.pageHeader());		
	}
	
	/**
	 * Test Script for Message Inbox Single Search.
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void MessageInboxSingleSearchTest() throws Exception {
		Reporter.log("<------------Test Started for MessageInbox SingleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		dataMap.put("Tab","Inbox");
		enMessage.switchTabandView(dataMap);
		
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
			String x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
			dataMap.put("Subject",x );
			dataMap.put("InboxSearch","");
			enMessage.search(dataMap);
		
			if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
				Reporter.log("Search Returned the Result");
				String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
				Reporter.log("Inbox Subject ,Expected:"+x+",Actual:"+y);
				softAssert.assertEquals(y, x,"Subject Not Matched");
				flag=true;
			}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at MessageInbox SingleSearchTest:" + currenttime(),true);
	}

	/**
	 * Test Script for Message Inbox Multi Search.
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void MessageMultipleSearchTest() throws Exception {
		Reporter.log("<---------------------Test Started for MessageInbox MultipleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		dataMap.put("Tab","Inbox");
		enMessage.switchTabandView(dataMap);
		
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
				
			String x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
			String xx=enMessage.iterateSearchHeaderFindColList("Type").get(0).getText().trim();
		dataMap.put("Subject", x);
		dataMap.put("Type", xx);
		dataMap.put("InboxSearch","");
		enMessage.search(dataMap);
		
			if(enTasksTracker.iterateSearchHeaderFindColList("Subject").size()>0){
				Reporter.log("Search Returned the Result");
				String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
				Reporter.log("Inbox Subject ,Expected:"+x+",Actual:"+y);
				softAssert.assertEquals(y, x,"Subject Not Matched");
				y=enMessage.iterateSearchHeaderFindColList("Type").get(0).getText().trim();
				Reporter.log("Inbox Subject ,Expected:"+xx+",Actual:"+y);
				softAssert.assertEquals(y, xx,"Type Not Matched");

				flag=true;
			}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("--Test Ended at MessageInbox MultipleSearchTest:" + currenttime(),true);
	}
	
	/**
	 * Test Script for Message Sent Single Search.
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */	
	@Test
	public void MessageSentSingleSearchTest() throws Exception {
		Reporter.log("<---------------------Test Started for MessageSentSingleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		enMessage.switchTabandView(dataMap);
		
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
			String x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
			dataMap.put("Subject",x );
			dataMap.put("SentSearch","");
			enMessage.search(dataMap);
		
			if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
				Reporter.log("Search Returned the Result");
				String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
				Reporter.log("Sent Subject ,Expected:"+x+",Actual:"+y);
				softAssert.assertEquals(y, x,"Subject Not Matched");
				flag=true;
			}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at Message Sent SingleSearchTest:" + currenttime(),true);
	}

	/**
	 * Test Script for Message Sent Multi Search.
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void MessageSentMultipleSearchTest() throws Exception {
		Reporter.log("<---------------------Test Started for Message Sent MultipleSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		enMessage.switchTabandView(dataMap);
		
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
			String x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
			String xx=enMessage.iterateSearchHeaderFindColList("Type").get(0).getText().trim();
			dataMap.put("Subject", x);
			dataMap.put("Type", xx);
			dataMap.put("SentSearch","");
			enMessage.search(dataMap);
		
			if(enTasksTracker.iterateSearchHeaderFindColList("Subject").size()>0){
				Reporter.log("Search Returned the Result");
				String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
				Reporter.log("Sent Subject ,Expected:"+x+",Actual:"+y);
				softAssert.assertEquals(y, x,"Subject Not Matched");
				y=enMessage.iterateSearchHeaderFindColList("Type").get(0).getText().trim();
				Reporter.log("Sent Type ,Expected:"+xx+",Actual:"+y);
				softAssert.assertEquals(y, xx,"Type Not Matched");

				flag=true;
			}
		
		}else{
			softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("--Test Ended at Message Sent MultipleSearchTest:" + currenttime(),true);
	}

	/**
	 * Test Script for Sent Resent Items
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void InboxForward() throws Exception {
		Reporter.log("<--Test Started for Inbox Forward: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		dataMap.put("Tab","Sent");
		enMessage.switchTabandView(dataMap);
		
		lavanteUtils.fluentwait(enMessage.pageHeader());
		lavanteUtils.fluentwait(enMessage.sentSearchbtn());
		lavanteUtils.waitForTime(4000);
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
		
			String x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText();
			
			String to="SP"+currenttime()+"@gmail.com";
			dataMap.put("Subject", x);
			dataMap.put("Action", "SentForward");
			dataMap.put("SentForward",to );
			enMessage.actiononMessages(dataMap);
			
			lavanteUtils.fluentwait(enMessage.pageHeader());
			lavanteUtils.fluentwait(enMessage.sentSearchbtn());
			lavanteUtils.waitForTime(4000);
			
			dataMap.put("Recipient",to);
			dataMap.put("SentSearch","");
			enMessage.search(dataMap);
		
			if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
					Reporter.log("Search Returned the Result");
					String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
					Reporter.log("Inbox Forwarded Subject ,Expected:"+x+",Actual:"+y);
					softAssert.assertEquals(y, x,"Subject Not Matched");
					y=enMessage.iterateSearchHeaderFindColList("Recipients").get(0).getText().trim();
					Reporter.log("Inbox Forwarded To ,Expected:"+to+",Actual:"+y);
					softAssert.assertEquals(y,to,"Reciepent Not Matched");
					flag=true;
					
			}
			
		}else{
				softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------Test Ended at SentForward:" + currenttime(),true);
	}
	
	/**
	 * Test Script for Sent Resent Items
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void SentResent() throws Exception {
		Reporter.log("<-------Test Started for SentResent: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		enMessage.switchTabandView(dataMap);
		
		lavanteUtils.fluentwait(enMessage.pageHeader());
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
		
			String x=enMessage.iterateSearchHeaderFindColList("Resent Count").get(0).getText();
			Integer xx=Integer.parseInt(x)+1;
			x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText();
			
			dataMap.put("Subject", x);
			dataMap.put("Action", "SentResent");
			enMessage.actiononMessages(dataMap);
			
			dataMap.put("SentSearch","");
			enMessage.search(dataMap);
		
			if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
					Reporter.log("Search Returned the Result");
					String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
					Reporter.log("Sent Resent Subject ,Expected:"+x+",Actual:"+y);
					softAssert.assertEquals(y, dataMap.get("Subject"),"Task ID Not Matched");
					y=enMessage.iterateSearchHeaderFindColList("Resent Count").get(0).getText().trim();
					Integer yxx=Integer.parseInt(y);
					Reporter.log("Sent Resent Count ,Expected:"+xx+",Actual:"+yxx);
					softAssert.assertEquals(yxx,xx,"Resent Count Not Matched");
					flag=true;
			}
			
		}else{
				softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------Test Ended at SentResent:" + currenttime(),true);
	}
	
	/**
	 * Test Script for Sent Resent Items
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test
	public void SentForward() throws Exception {
		Reporter.log("<--Test Started for SentForward: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		boolean flag=false;
		
		dataMap.put("Tab","Sent");
		enMessage.switchTabandView(dataMap);
		
		lavanteUtils.fluentwait(enMessage.pageHeader());
		lavanteUtils.fluentwait(enMessage.sentSearchbtn());
		lavanteUtils.waitForTime(4000);
		if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
		
			String x=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText();
			
			String to="SP"+currenttime()+"@gmail.com";
			dataMap.put("Subject", x);
			dataMap.put("Action", "SentForward");
			dataMap.put("SentForward",to );
			enMessage.actiononMessages(dataMap);
			
			lavanteUtils.fluentwait(enMessage.pageHeader());
			lavanteUtils.fluentwait(enMessage.sentSearchbtn());
			lavanteUtils.waitForTime(4000);
			
			dataMap.put("Recipient",to);
			dataMap.put("SentSearch","");
			enMessage.search(dataMap);
		
			if(enMessage.iterateSearchHeaderFindColList("Subject").size()>0){
					Reporter.log("Search Returned the Result");
					String y=enMessage.iterateSearchHeaderFindColList("Subject").get(0).getText().trim();
					Reporter.log("Sent Forward Subject ,Expected:"+x+",Actual:"+y);
					softAssert.assertEquals(y, x,"Subject Not Matched");
					y=enMessage.iterateSearchHeaderFindColList("Recipients").get(0).getText().trim();
					Reporter.log("Sent Forward To ,Expected:"+to+",Actual:"+y);
					softAssert.assertEquals(y,to,"Reciepent Not Matched");
					flag=true;
					
			}
			
		}else{
				softAssert.assertTrue(flag,"Search Has no Data to search,No Search Operation Done");
		}

		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------Test Ended at SentForward:" + currenttime(),true);
	}
	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();		
	}
}
