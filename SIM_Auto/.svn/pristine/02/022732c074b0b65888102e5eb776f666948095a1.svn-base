package com.lavante.sim.customer.TestScripts.Tasks.Approvals;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
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
 * Created on 24-10-2016
 * Ended on 24-10-2016
 * @author Piramanayagam.S
 *
 */
public class  ApprovalTC001 extends PageInitiator  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();	
	String customerid="";
	String expSuppName="";
	String uname="";
	
	/**
	 * This class all test starts using login page and driver initialization
	 * @author Piramanayagam.S
	 * 
	 */
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
		List listofdatafrm=lavanteUtils.login("Task-Invoice", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=""+listofdatafrm.get(1);
		uname=LdataMap.get("username");
				
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
	}

	
	@BeforeMethod
	public void BeforeMethod(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "customerApprovals");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.waitForTime(3000);
	}
	
	/**
	  * Goto task approval page
	  * Select any supplier-> Goto Edit Profile 
	  * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test
	public void UIEditProfileApprovalPage01() throws Exception
	{
		
		Reporter.log("Test Started for UI Verification of Edit profile in Task Page :"+currenttime());
		
			LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
			dataMap.put("EditProfile","");
			String sname=enapproval.selectSupplierFormAction(dataMap);
			if(!(sname.length()>0)){
				Assert.assertTrue(false,"Supplier Not Found in the list,Please add and Retest");
			}
			Reporter.log("Supplier Selected for edit:"+sname);
			Assert.assertTrue(lavanteUtils.isElementDisplayed(eneditProfile.saveExitbtn()),"Edit Profile page not displayed");

		Reporter.log("Test Started for UI Verification of Edit profile in Task Page :"+currenttime());
		
	}
	

	/**
	 * Send EMail from Task Page
	 * 
	 * No Verification Handled bcz Email Verification in GMAIL not handeled.
	 * Not Stored in DB/History too.
	 * 
	 * @throws Exception
	 */
	@Test
	public void SendEmail() throws Exception {

		Reporter.log("Test Started for Send Email  in Task Page :"+currenttime());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
			
		dataMap.put("SendEmail","");
		String rejectcomm="comments"+currenttime();
		dataMap.put("mailFrom",uname);
		dataMap.put("mailSubject",rejectcomm);
		dataMap.put("mailMessage",rejectcomm);
		
		dataMap.put("mailSend","");
		expSuppName=enapproval.selectSupplierFormAction(dataMap);
		Reporter.log("Supplier Name:"+expSuppName);
		if(!(expSuppName.length()>0)){
			Assert.assertTrue(false,"Supplier Not Found in the list,Please add and Retest");
		}
		
		lavanteUtils.waitforPageload(enapproval.searchbtn());
		dataMap.put("Search","");
		dataMap.put("supplierName",expSuppName);
		enapproval.Search(dataMap);
		lavanteUtils.waitforPageload(enapproval.searchbtn());
		if(enapproval.iterateSearchHeaderFindColList("Supplier Name").size()>0){
				flag=true;
				//Verification Cant be done anywhere
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"Please Recheck");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for Send Email in Task Page :"+currenttime());
		
	}

	
	
	 /**
	  * Goto task approval page
	  * Select any Supplier Managed supplier-> Request Update->Verify in Edit Profile 
	  * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test
	public void RequestUpdateManagebySup01() throws Exception
	{
		Reporter.log("Test Started for Req Update in Task Page :"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("CustomerID", customerid);
		dataMap.put("Managedby","Supplier");
		String sup=enapproval.Managedby(dataMap);
		if(!(sup.length()>0)){
			Assert.assertTrue(false,"Supplier Managed by Supplier Not Found in the list,Please add and Retest");
		}
		
		String sub="Auto Sub "+currenttime();
		String msg="This was trigger by the  automation script on"+currenttime();
		dataMap.put("ReqUpdate","");
		dataMap.put("Subject",sub);
		dataMap.put("Message",msg);
		dataMap.put("SubmitRequestUpdate","");
		dataMap.put("supplierName",sup);
		sup=enapproval.selectSupplierFormAction(dataMap);
		
		Reporter.log("Selected  Supplier:"+sup,true);
		String query="select MergedNotificationContent from Notification where NotificationTypeID=3160 and CustomerID="+customerid+" and NotificationSubject like '%"+sub+"%'" ;
		Reporter.log(query,true);
		query=lavanteUtils.fetchDBdata(query);
		if(query!=null){
			Reporter.log("Message from DB:"+query+",Exp:"+msg);
			softAssert.assertTrue(query.contains(msg),"Sub Not Matched from DB");
		}
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("supplierName", sup);
		enobjsupplierBasicSearch.search(dataMap);	

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		Reporter.log("In Edit Profile:");
		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		
		dataMap.put("Finish", "");
		eneditProfile.formAction(dataMap);	
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_Profile_Popup());
		
		String actmsg=eneditProfile.CompletedMsg().getText();

		
		Reporter.log("Actual Message in finish Profile"+actmsg+",Expected:"+sub,true);
		softAssert.assertTrue(actmsg.contains(sub),"Finish msg doesnot contain the req update data");

		lavanteUtils.click(eneditProfile.confirm_Yes_Button());
		
		dataMap.remove("Finish");
		dataMap.put("ConfrmNO", "");		
		eneditProfile.formAction(dataMap);
		
		softAssert.assertAll();
		Reporter.log("Test Started for Req Update in Task Page :"+currenttime());
		
		
	}

	 /**
	  * Goto task approval page
	  * Select any Customer Managed supplier-> Request Update->Verify in Edit Profile -->Verify in Pending Update Page
	  * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test
	public void RequestUpdateManagebyCust02() throws Exception
	{
		
		Reporter.log("Test Started for Req Update in Task Page :"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
	
		dataMap.put("Managedby","Customer");
		dataMap.put("CustomerID", customerid);
		String sup=enapproval.Managedby(dataMap);
		if(!(sup.length()>0)){
			Assert.assertTrue(false,"Supplier Managed by Customer Not Found in the list,Please add and Retest");
		}
		dataMap.put("supplierName",sup);
		String sub="Auto Sub "+currenttime();
		String msg="This was trigger by the  automation script on"+currenttime();
		dataMap.put("ReqUpdate","");
		dataMap.put("Subject",sub);
		dataMap.put("Message",msg);
		dataMap.put("SubmitRequestUpdate","");
		dataMap.put("Managedby","Customer");
		sup=enapproval.selectSupplierFormAction(dataMap);
	
		String query="select MergedNotificationContent from Notification where NotificationTypeID=3160 and CustomerID="+customerid+" and NotificationSubject like '%"+sub+"%'" ;
		query=lavanteUtils.fetchDBdata(query);
		Reporter.log(query);
		if(query!=null){
			Reporter.log("Message from DB:"+query+",Exp:"+msg,true);
			softAssert.assertTrue(query.contains(msg),"Sub Not Matched from DB");
		}
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("supplierName", sup);
		enobjsupplierBasicSearch.search(dataMap);	
		/*
		dataMap.remove("ReqUpdate");
		dataMap.put("EditProfile","");
		enapproval.selectSupplierFormAction(dataMap);*/
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		Reporter.log("In Edit Profile:");
		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		
		dataMap.put("Finish", "");
		eneditProfile.formAction(dataMap);	
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_Profile_Popup());
		
		String actmsg=eneditProfile.CompletedMsg().getText();
		Reporter.log("Actual Message in finish Profile"+actmsg+",Expected:"+sub,true);
		softAssert.assertTrue(actmsg.contains(sub),"Finish msg doesnot contain the req update data");

		lavanteUtils.click(eneditProfile.confirm_Yes_Button());
		
		dataMap.remove("Finish");
		dataMap.put("ConfrmNO", "");		
		eneditProfile.formAction(dataMap);
		
		
		dataMap.put("maintab","Approval");
		dataMap.put("subtab","SupplierTasks");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(enobjhomePage.TotalCount());
		String x=enobjhomePage.TotalCount().getText();

		System.out.println("Not Expected:(0),Actual:"+x);
		Reporter.log("Not Expected:(0),Actual:"+x);
		softAssert.assertNotEquals(x,"(0)","Total Page equals to 0 on Pending Update Page");
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Req Update in Task Page :"+currenttime());
		
	}

	/**
	 * Reject The Approval Verify in View Supplier
	 * 
	 * @throws Exception
	 */
	@Test
	public void RejectApporval() throws Exception {

		Reporter.log("Test Started for Reject Approval  in Task Page :"+currenttime());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
			
		dataMap.put("Reject","");
		String rejectcomm="comments"+currenttime();
		dataMap.put("RejectComment",rejectcomm);
		dataMap.put("RejectSupplier","");
		expSuppName=enapproval.selectSupplierFormAction(dataMap);
		Reporter.log("Supplier Name:"+expSuppName);
		if(!(expSuppName.length()>0)){
			Assert.assertTrue(false,"Supplier Not Found in the list,Please add and Retest");
		}
		lavanteUtils.waitforPageload(enapproval.searchbtn());
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("supplierName",expSuppName);
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(expSuppName);
		
		dataMap.put("maintab","Status");
		dataMap.put("subtab","ProfileStage");
		enviewSupplier.selectTab(dataMap);
		
		lavanteUtils.fluentwait(enviewSupplier.StatusProfApprovalListType().get(0));
		
		outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();){
			String expAction="Rejected";
			String actactionType=enviewSupplier.StatusProfApprovalListType().get(i).getText();
			
			Reporter.log(" Rejected Approval Status:"+expAction+",Actual :"+actactionType);
			softAssert.assertEquals(actactionType, expAction,"Rejected Approval Status,Expected:"+expAction+",Actuals:"+actactionType);
			
			expAction="Post Profile Complete Approval Workflow for New Suppliers";
			String actActionTaken=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
			
			Reporter.log(" ActionTaken Verification :"+expAction+",Actual:"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Action taken Verification,Expected:"+expAction+",Actuals:"+actActionTaken);

			expAction=uname;
			actActionTaken=enviewSupplier.StatusProfApprovalListActor().get(i+1).getText();
			
			Reporter.log(" Actor Verification :"+expAction+",Actual :"+actActionTaken);
			softAssert.assertEquals(actActionTaken.contains(expAction),"Actor taken Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			expAction=rejectcomm;
			actActionTaken=enviewSupplier.StatusProfApprovalListComment().get(i+1).getText();
			
			Reporter.log(" Comemnt Verification :"+expAction+",Actual:"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Comemnt Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			flag=true;
			break outr;
		}

		
		if(flag==false){
			softAssert.assertTrue(false,"Please Recheck");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for Reject Approval in Task Page :"+currenttime());
		
	}

	/**
	 * Approve The Approval Verify in View Supplier
	 * 
	 * @throws Exception
	 */
	@Test
	public void ApproveApporval() throws Exception {

		Reporter.log("Test Started for Reject Approval  in Task Page :"+currenttime());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
			
		dataMap.put("Approve","");
		String approveComm="comments"+currenttime();
		dataMap.put("ApprovalComment",approveComm);
		dataMap.put("SubmitApproval","");
		expSuppName=enapproval.selectSupplierFormAction(dataMap);
		Reporter.log("Supp Name:"+expSuppName);
		if(!(expSuppName.length()>0)){
			Assert.assertTrue(false,"Supplier Not Found in the list,Please add and Retest");
		}
		
		lavanteUtils.waitforPageload(enapproval.searchbtn());
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("supplierName",expSuppName);
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(expSuppName);
		
		dataMap.put("maintab","Status");
		dataMap.put("subtab","ProfileStage");
		enviewSupplier.selectTab(dataMap);
		
		lavanteUtils.fluentwait(enviewSupplier.StatusProfApprovalListType().get(0));
		
		outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();){
			String expAction="Approved";
			String actactionType=enviewSupplier.StatusProfApprovalListType().get(i).getText();
			
			Reporter.log(" Approved Approval Status:"+expAction+",Actual :"+actactionType);
			softAssert.assertEquals(actactionType, expAction,"Approved Approval Status,Expected:"+expAction+",Actuals:"+actactionType);
			
			expAction="Post Profile Complete Approval Workflow for New Suppliers";
			String actActionTaken=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
			
			Reporter.log(" ActionTaken Verification :"+expAction+",Actual ERP ID:"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Action taken Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			expAction=uname;
			actActionTaken=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
			
			System.out.println("Actor Verification  :"+expAction+",Actual :"+actActionTaken);
			Reporter.log(" Actor Verification :"+expAction+",Actual :"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Actor taken Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			expAction=approveComm;
			actActionTaken=enviewSupplier.StatusProfApprovalListComment().get(i).getText();
			
			System.out.println("Comment Verification  :"+expAction+",Actual :"+actActionTaken);
			Reporter.log(" Comment Verification :"+expAction+",Actual:"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Comment Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			flag=true;
			break outr;
		}

		
		if(flag==false){
			softAssert.assertTrue(false,"Please Recheck");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for Approve Approval in Task Page :"+currenttime());
		
	}

	/**
	 * Reassign The Approval Verify in View Supplier
	 * 
	 * @throws Exception
	 */
	@Test
	public void ReassignApporval() throws Exception {

		Reporter.log("Test Started for Reassign Approval  in Task Page :"+currenttime());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
			
		dataMap.put("Reassign","");
		expSuppName=enapproval.selectSupplierFormAction(dataMap);
		Reporter.log("Supp Name:"+expSuppName);
		if(!(expSuppName.length()>0)){
			Assert.assertTrue(false,"Supplier Not Found in the list,Please add and Retest");
		}
		String grpname="select UTFString from UserTranslation where i18nKey in ( select  RoleName_i18nKey From LoginRole where UserRoleID in ("
				+ " select  UserRoleID from [Login] where ContactID in (select ContactID from Contact where Email='"+uname+"' )"
				+ " )  ) and LanguageID=50";
		
		grpname=lavanteUtils.fetchDBdata(grpname);
		
		dataMap.put("Role",grpname);
		dataMap.put("AssginTo","Role");
		enReassign.Reassigning(dataMap);
		
		lavanteUtils.click(enReassign.Reassignbtn());
		lavanteUtils.waitForTime(4000);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.waitforPageload(enapproval.searchbtn());
		dataMap.clear();
		
		dataMap.put("supplierName",expSuppName);
		enapproval.Search(dataMap);
		
		lavanteUtils.waitforPageload(enapproval.searchbtn());
		if(enapproval.iterateSearchHeaderFindColList("Supplier Name").size()>0){
			lavanteUtils.click(enapproval.iterateSearchHeaderFindColList("Supplier Name").get(0));
			
			dataMap.put("maintab","Status");
			dataMap.put("subtab","ProfileStage");
			enviewSupplier.selectTab(dataMap);
			
			lavanteUtils.fluentwait(enviewSupplier.StatusProfApprovalListType().get(0));
			
			outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();){
				String expAction="Approval Pending";
				String actactionType=enviewSupplier.StatusProfApprovalListType().get(i).getText();
				
				Reporter.log(" Approved Approval Status:"+expAction+",Actual :"+actactionType);
				softAssert.assertEquals(actactionType, expAction,"Approved Approval Status,Expected:"+expAction+",Actuals:"+actactionType);
				
				expAction="Post Profile Complete Approval Workflow for New Suppliers";
				String actActionTaken=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
				
				Reporter.log(" ActionTaken Verification :"+expAction+",Actual :"+actActionTaken);
				softAssert.assertEquals(actActionTaken, expAction,"Action taken Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
				
				expAction=grpname;
				actActionTaken=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
				
				Reporter.log(" Actor Verification :"+expAction+",Actual :"+actActionTaken);
				softAssert.assertEquals(actActionTaken, expAction,"Actor taken Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
				
				flag=true;
				break outr;
			}
		}

		
		if(flag==false){
			softAssert.assertTrue(false,"Please Recheck");
		}

		softAssert.assertAll();

		Reporter.log("Test Ended for Reassign Approval in Task Page :"+currenttime());
		
	}
	
	 /**SIM-10114
	  * TempApprovalValidation-->Goto task approval page 
	  * Configure a date for temp approval
	  * Enter the date within the date Verify the Validation Error Msg
	  * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws IOException 
	 */	
	@Test
	public void TempApprovalValidation01() throws Exception
	{
		Reporter.log("Test Started for  Temp Approval Validation in Task Page :"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		if(enapproval.iterateSearchHeaderFindColList("Supplier Name").size()>0){
			String random=""+randomnum(99);
			int dbValue=Integer.parseInt(random);
			
			String query="update CustomerPropertyValue SET PropertyValue='true' where CustomerPropertyID=17 and CustomerID="+customerid;
			lavanteUtils.UpdateDB(query);
			
			query="update CustomerPropertyValue SET PropertyValue="+dbValue+" where CustomerPropertyID=18 and CustomerID="+customerid;
			lavanteUtils.UpdateDB(query);
			
			LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
			dataMap.put("Approve", "");
			dataMap.put("TempApprovalChk","yes");
			random=""+randomnum(dbValue);
			int gx=Integer.parseInt(random);
			String addDate=AddSubDate(gx);
			dataMap.put("TempApprovalDate",addDate);
			dataMap.put("ApprovalComment","ErrorMsg");
			dataMap.put("SubmitApproval","ErrorMsg");
			enapproval.selectSupplierFormAction(dataMap);
	
			String x="Approved Through Date should be greater than "+dbValue+" day(s) from today";
			
			lavanteUtils.switchtoFrame(enapproval.IFRAMEApprove());
			String acterror=enapproval.Errormsg().getText();
			
			Reporter.log("Error Msg for Approval,Expected:"+x+",Actuals:"+acterror);
			softAssert.assertEquals(acterror, x,"Error Msg for Approval,Expected:"+x+",Actuals:"+acterror);
			
		} else{
			softAssert.assertTrue(false,"Please Add Test Data on Task ->Approval Page");
		}
		
		softAssert.assertAll();
		Reporter.log("Test Started for Req Update in Task Page :"+currenttime());
		
		
	}
	
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException
	{
		lavanteUtils.refreshPage();
		enobjhomePage.popupclose();
		enobjhomePage.backtoSearch();
		//Request Update Test uses edit profile hence this code added
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();	
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);
		if(expSuppName.length()>0){
			String query="update Jbpm_Task set status='Reserved' where processInstanceId in (select ProcessInstanceId from WF_ProcessDetails where RelationShipID in "
					+ " (select RelationshipID from Relationship where CustomerID="+customerid+" and LavanteUID in (select LavanteUID from Supplier where SupplierName='"+expSuppName+"')))";
			lavanteUtils.UpdateDB(query);
			
			query="delete from WF_HTDetails where ProcessdetailID in (select ProcessdetailID from WF_ProcessDetails where RelationShipID in (select RelationshipID from Relationship where CustomerID="+customerid+" and LavanteUID in (select LavanteUID from Supplier where SupplierName='"+expSuppName+"')))";
			lavanteUtils.UpdateDB(query);
			query="delete  from Note where RelationshipID in (select RelationshipID from Relationship where CustomerID="+customerid+" and LavanteUID in (select LavanteUID from Supplier where SupplierName='"+expSuppName+"'))";
			lavanteUtils.UpdateDB(query);
		}
	}
		
	@AfterClass
	public void SetupafterClassmethod(){
		
		enobjhomePage.logout();
		quitBrowser();
	}


}

