package com.lavante.sim.customer.TestScripts.Tasks.Reassignment;


import java.io.IOException;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ManageUsers;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 12-12-2016
 * Enhancement SIM-9404
 * Ended on 14-12-2016
 * @author Piramanayagam.S
 *
 */
public class  UATReassignmentTC001 extends PageInitiator  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();	
	LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
	String customerID="";
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
		List<?> listofdatafrm=lavanteUtils.login("Task-Invoice", browser);
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
	}
	
	@BeforeMethod
	public void before(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		
		dataMap.put("maintab","Tasks");
		dataMap.put("subtab","viewApprovalTasks");
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.waitForTime(3000);
		
	}

	 /**
	  * Goto task Reassignment
	  * Verify the Multi dropdown value for user based on Inviting Org
	  * 
	 * @author Piramanayagam.S
	 * @throws IOException
	 */	
	@Test
	public void UIUserMultiValue() throws Exception
	{
		
		Reporter.log("Test Started for Multi Single Value in Reassignment  Page :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		String query="select Top 1 OrganizationName from CustomerOrganization where CustomerOrganizationID in ("
				+ " select CustomerOrganizationID from LoginInvitingOrgMap "
				+ " group by CustomerOrganizationID having count(*)>1 ) and  CustomerID="+customerID;
		
		query=lavanteUtils.fetchDBdata(query);
		
		String usequery="   SELECT C.ContactName FROM LoginInvitingOrgMap LIOM "
				+ "    INNER JOIN [Login] L ON L.LoginID = LIOM.LoginID"
				+ "    INNER JOIN Customer_Contact_Map CCM ON L.ContactID = CCM.ContactID"
				+ "    INNER JOIN Contact C ON C.ContactID = CCM.ContactID"
				+ "    WHERE LIOM.CustomerOrganizationID=(select CustomerOrganizationID"
				+ "    from CustomerOrganization where OrganizationName='"+query+"')"
				+ "    AND CCM.CustomerID="+customerID+" AND L.IsActive=1";
		
		List<String> x=lavanteUtils.fetchDBlistdata(usequery);
		
		if(usequery!=null){
			
				dataMap.put("AssginTo","User");
				dataMap.put("InvitingOrg",query.trim());	
				
				enReassign.selectSupplierFormAction(dataMap);
				
				dataMap.put("ReAssign","");
				dataMap.put("ReAssignError","");
				enReassign.formAction(dataMap);

				lavanteUtils.switchtoFrame(enReassign.IFRAMEReassign());
				String app=enReassign.UserDrpdn().getText();
				Reporter.log("First Record for multiple data First Value ,Expected, 'Select',Actuals:"+app);
				softAssert.assertEquals(app,"Select","First Record Select Not Matched as first record"+app);
				
				lavanteUtils.click(enReassign.UserDrpdn());
				
				List<String> xs=lavanteUtils.listelement(null);
				//Size will not match as the above is returning empty string
				if(xs.size()>1){
						int j=0;
						for(int i=1;i<xs.size();i++){
							if(xs.get(i).length()>0){
								if(xs.get(i).contains(x.get(j))){
									Reporter.log("User Name ,Expected, "+x.get(j)+",Actuals:"+xs.get(i),true);
									softAssert.assertTrue(xs.get(i).contains(x.get(j)),"User List Not Matched"+x.get(j));
									j++;
									flag=true;
								}
							}
						}
					}
				
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();		
		
		Reporter.log("Test Started for Multi SingleValue in Reassignment  Page :"+currenttime());
		
	}
	
	/**
	 *  Goto task Reassignment
	 * 	Verify the Single dropdown value for User
	 * 
	 * @throws Exception
	 */
	@Test
	public void UIUserSingleValue() throws Exception
	{
		
		Reporter.log("Test Started for UserSingleValue in Reassignment Page :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		String query="select MAX(OrganizationName) from CustomerOrganization where CustomerOrganizationID in ("
				+ " select CustomerOrganizationID from LoginInvitingOrgMap where CustomerOrganizationID in (select"
				+ " CustomerOrganizationID from CustomerOrganization where CustomerID="+customerID+")"
				+ " group by CustomerOrganizationID having count(*)=1)";
		
		query=lavanteUtils.fetchDBdata(query);
		
		if(query!=null){
				dataMap.put("AssginTo","User");
				dataMap.put("InvitingOrg",query.trim());	
				dataMap.put("ReAssign","");
				dataMap.put("ReAssignError","");
				enReassign.selectSupplierFormAction(dataMap);
				
				lavanteUtils.switchtoFrame(enReassign.IFRAMEReassign());
				String app=enReassign.UserDrpdn().getText();
				Reporter.log("First Record for Single data Expected, Some Value,Actuals:"+app);
				softAssert.assertNotEquals(app,"Select","First Record Some Value Not Matched as first record");
				flag=true;
		}	else{
			softAssert.assertTrue(false,"Query Didnot returned the result, Please Add Test Data");
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("Test Started for Single SingleValue in Reassignment  Page :"+currenttime());
		
	}

	/**
	 *  Goto task Reassignment->Approval Task->Reassign to the Logged in User
	 *  Verify in Table Data
	 *  Verify in view Supplier 
	 * 
	 * @throws Exception
	 */
	@Test
	public void ApprovalTaskReassignToUser() throws Exception
	{
		
		Reporter.log("Test Started for Approval Task Reassignment to User :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		String query="Select Top 1 OrganizationName From CustomerOrganization Where CustomerOrganizationID In (Select CustomerOrganizationID"
				+ " From LoginInvitingOrgMap where LoginID in (select LoginID from [Login] where ContactID in "
				+ "(Select ContactID from Contact where Email='"+LdataMap.get("username")+"') )"
				+ "Group by CustomerOrganizationID ) AND CustomerID="+customerID;
		
		query=lavanteUtils.fetchDBdata(query);
		
		String cname="select ContactName from Contact where Email='"+LdataMap.get("username")+"'";
		cname=lavanteUtils.fetchDBdata(cname)+"("+LdataMap.get("username")+")";
		
		if(query!=null){
				dataMap.put("AssginTo","User");
				dataMap.put("InvitingOrg",query.trim());
				dataMap.put("User",cname);
				dataMap.put("ReAssign","");
				String sname=enReassign.selectSupplierFormAction(dataMap);
				
				dataMap.put("supplierName", sname);
				dataMap.put("search", "");
				enReassign.Search(dataMap);

				lavanteUtils.fluentwait(enReassign.listSName().get(0));
				String actsname=enReassign.listSName().get(0).getText();
				String assgned= enReassign.listAssignedTo().get(0).getText();
				
				Reporter.log("Supp Name,Exp: "+sname+",Actuals: "+actsname);
				softAssert.assertEquals(actsname,sname," Supp Name Not Matched");
				
				Reporter.log("Assigned to,Exp"+LdataMap.get("username")+",Actuals:"+assgned);
				softAssert.assertEquals(assgned,LdataMap.get("username")," Assigned to Not Matched");
				
				lavanteUtils.click(enReassign.listSName().get(0));
				
				dataMap.put("maintab","Status and History");
				dataMap.put("subtab","ProfileStage");
				enviewSupplier.selectTab(dataMap);
				
				lavanteUtils.fluentwait(enviewSupplier.StatusProfApprovalListActor().get(0));
				assgned=enviewSupplier.StatusProfApprovalListType().get(1).getText();
				String exp="Reassign";
				outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();i++){
					String actual=enviewSupplier.StatusProfApprovalListType().get(i).getText();
					 exp="Reassign";
					if(actual.equalsIgnoreCase(exp)){
						Reporter.log("Type,Exp"+exp+",Actuals:"+assgned);
						softAssert.assertEquals(assgned,exp,"Type to Not Matched");
						
						assgned=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
						cname="Select ContactName From Contact where Email='"+LdataMap.get("username")+"'";
						cname=lavanteUtils.fetchDBdata(cname);
						Reporter.log("Actor,Exp"+cname+",Actuals:"+assgned);
						softAssert.assertTrue(assgned.contains(cname),"Actor to Not Matched");
						
						assgned=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
						exp="Suppliers registration to approve";
						Reporter.log("Action,Exp"+exp+",Actuals:"+assgned);
						softAssert.assertEquals(assgned,exp,"Action to Not Matched");
						
						assgned=enviewSupplier.StatusProfApprovalListComment().get(i).getText();
						exp="Task is reassigned to "+LdataMap.get("username");
						Reporter.log("Comments,Exp"+exp+",Actuals:"+assgned);
						softAssert.assertEquals(assgned,exp,"Comment to Not Matched");
		
						flag=true;
						break outr;
					}
				}
		}	
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("Test Started for Approval Task Reassignment to User  :"+currenttime());
		
	}

	/**
	 *  Goto task Reassignment->Approval Task->Reassign to the Logged in User Group
	 *  Verify in Table Data
	 *  Verify in view Supplier 
	 * 
	 * @throws Exception
	 */
	@Test
	public void ApprovalTaskReassignToGroup() throws Exception
	{
		
		Reporter.log("Test Started for Approval Task Reassignment to Group :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		String query="Select Top 1 OrganizationName From CustomerOrganization Where CustomerOrganizationID In (Select CustomerOrganizationID"
				+ " From LoginInvitingOrgMap where LoginID in (select LoginID from [Login] where ContactID in "
				+ "(Select ContactID from Contact where Email='"+LdataMap.get("username")+"') )"
				+ "Group by CustomerOrganizationID ) AND CustomerID="+customerID;
		
		query=lavanteUtils.fetchDBdata(query);
		
		String grpname="select Top 1 GroupName from UserGroup where CustomerID="+customerID;
		grpname=lavanteUtils.fetchDBdata(grpname);
		
		if(grpname!=null){
				dataMap.put("AssginTo","Group");
				dataMap.put("InvitingOrg","All");
				dataMap.put("Group",grpname);
				dataMap.put("ReAssign","");
				String sname=enReassign.selectSupplierFormAction(dataMap);
				
				dataMap.put("supplierName", sname);
				dataMap.put("search", "");
				enReassign.Search(dataMap);

				lavanteUtils.waitForTime(4000);
				lavanteUtils.waitforPageload(enReassign.listSName().get(0));
				lavanteUtils.fluentwait(enReassign.listSName().get(0));
				String actsname=enReassign.listSName().get(0).getText();
				String actual=enReassign.listAssignedTo().get(0).getText();
				
				Reporter.log("Supp Name,Exp"+sname+",Actuals:"+actsname);
				softAssert.assertEquals(actsname,sname,"Supp Name Not Matched");
				
				Reporter.log("Assigned to,Exp"+grpname+",Actuals:"+actual);
				softAssert.assertEquals(actual,grpname,"Assigned to Group Not Matched");
				
				lavanteUtils.click(enReassign.listSName().get(0));
				
				dataMap.put("maintab","Status and History");
				dataMap.put("subtab","ProfileStage");
				enviewSupplier.selectTab(dataMap);
				
				outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();i++){
				actual=enviewSupplier.StatusProfApprovalListType().get(i).getText();
				String exp="Reassign";
				if(actual.equalsIgnoreCase(exp)){
					Reporter.log("Type,Exp"+exp+",Actuals:"+actual);
					softAssert.assertEquals(actual,exp,"Type to Not Matched");
					
					actual=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
					String cname="Select ContactName From Contact where Email='"+LdataMap.get("username")+"'";
					cname=lavanteUtils.fetchDBdata(cname);
					Reporter.log("Actor,Exp"+cname+",Actuals:"+actual);
					softAssert.assertTrue(actual.contains(cname),"Actor to Not Matched");
					
					actual=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
					exp="Suppliers registration to approve";
					Reporter.log("Action,Exp"+exp+",Actuals:"+actual);
					softAssert.assertEquals(actual,exp,"Action to Not Matched");
					
					actual=enviewSupplier.StatusProfApprovalListComment().get(i).getText();
					exp="Task is reassigned to "+grpname;
					Reporter.log("Comments,Exp"+exp+",Actuals:"+actual);
					softAssert.assertEquals(actual,exp,"Comment to Not Matched");
	
					flag=true;
					break outr;
					}
				}

		}	
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		
		Reporter.log("Test Started for Approval Task Reassignment to Group  :"+currenttime());
		
	}

	/**
	 *  Goto task Reassignment->Approval Task->Reassign to the Logged in User Role
	 *  Verify in Table Data
	 *  Verify in view Supplier 
	 * 
	 * @throws Exception
	 */
	@Test
	public void ApprovalTaskReassignToRole() throws Exception
	{
		
		Reporter.log("Test Started for Approval Task Reassignment to Role :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		String query="Select Top 1 OrganizationName From CustomerOrganization Where CustomerOrganizationID In (Select CustomerOrganizationID"
				+ " From LoginInvitingOrgMap where LoginID in (select LoginID from [Login] where ContactID in "
				+ "(Select ContactID from Contact where Email='"+LdataMap.get("username")+"') )"
				+ "Group by CustomerOrganizationID ) AND CustomerID="+customerID;
		
		query=lavanteUtils.fetchDBdata(query);
		
		String grpname="select UTFString from UserTranslation where i18nKey in ( select  RoleName_i18nKey From LoginRole where UserRoleID in ("
				+ " select  UserRoleID from [Login] where ContactID in (select ContactID from Contact where Email='"+LdataMap.get("username")+"' )"
				+ " )  ) and LanguageID=50";
		
		grpname=lavanteUtils.fetchDBdata(grpname);
		
		if(grpname!=null){
				dataMap.put("AssginTo","Role");
				dataMap.put("InvitingOrg","All");
				dataMap.put("Role",grpname);
				dataMap.put("ReAssign","");
				String sname=enReassign.selectSupplierFormAction(dataMap);
				
				lavanteUtils.fluentwait(enReassign.searchbtn());
				dataMap.put("supplierName", sname);
				dataMap.put("search", "");
				enReassign.Search(dataMap);

				lavanteUtils.waitForTime(5000);
				lavanteUtils.waitforPageload(enReassign.listSName().get(0));
				lavanteUtils.fluentwait(enReassign.listSName().get(0));
				String actsname=enReassign.listSName().get(0).getText();
				String actual=enReassign.listAssignedTo().get(0).getText();
				
				Reporter.log("Supp Name,Exp"+sname+",Actuals:"+actsname);
				softAssert.assertEquals(actsname,sname,"Supp Name Not Matched");
				
				Reporter.log("Assigned to,Exp"+grpname+",Actuals:"+actual);
				softAssert.assertEquals(actual,grpname,"Assigned to Group Not Matched");
				
				lavanteUtils.click(enReassign.listSName().get(0));
				
				dataMap.put("maintab","Status and History");
				dataMap.put("subtab","ProfileStage");
				enviewSupplier.selectTab(dataMap);
				
				outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();i++){
					actual=enviewSupplier.StatusProfApprovalListType().get(i).getText();
					String exp="Reassign";
					if(actual.equalsIgnoreCase(exp)){
						Reporter.log("Type,Exp"+exp+",Actuals:"+actual);
						softAssert.assertEquals(actual,exp,"Type to Not Matched");
						
						actual=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
						String cname="Select ContactName From Contact where Email='"+LdataMap.get("username")+"'";
						cname=lavanteUtils.fetchDBdata(cname);
						Reporter.log("Actor,Exp"+cname+",Actuals:"+actual);
						softAssert.assertTrue(actual.contains(cname),"Actor to Not Matched");
						
						actual=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
						exp="Suppliers registration to approve";
						Reporter.log("Action,Exp"+exp+",Actuals:"+actual);
						softAssert.assertEquals(actual,exp,"Action to Not Matched");
						
						actual=enviewSupplier.StatusProfApprovalListComment().get(i).getText();
						exp="Task is reassigned to "+grpname;
						Reporter.log("Comments,Exp"+exp+",Actuals:"+actual);
						softAssert.assertEquals(actual,exp,"Comment to Not Matched");
		
						flag=true;
						break outr;
					}
				}
		}	
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		
		Reporter.log("Test Started for Approval Task Reassignment to Group  :"+currenttime());
		
	}

	/**
	 * Upload Contact File -User with Inviting Org and Group via File
	 *  Goto task Reassignment->Approval Task->Reassign to the Created User Group 
	 *  Verify in Table Data
	 *  Verify in view Supplier 
	 * 
	 * @throws Exception
	 */
	//@Test
	public void FileUploadInvitingOrgUser() throws Exception
	{
		
		Reporter.log("Test Started for Approval Task Reassignment to Group :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		dataMap.put("maintab","Admin");
		dataMap.put("subtab","UploadFiles");
		enobjhomePage.selectTab(dataMap);
		
		String nwfile=LavanteUtils.CopyFile("User_Template.csv");
		String ran=LavanteUtils.randomnum();
		String username="AutoSP"+ran;
		
		String email=username+"@"+username+".com";
		
		String role="select UTFString from UserTranslation where i18nKey in ( select  RoleName_i18nKey From LoginRole where UserRoleID in ("
				+ " select  UserRoleID from [Login] where ContactID in (select ContactID from Contact where Email='"+LdataMap.get("username")+"' )"
				+ " )  ) and LanguageID=50";
		role=lavanteUtils.fetchDBdata(role);	
		
		String usrgrp="select Top 1 GroupName from UserGroup where CustomerID="+customerID;
		usrgrp=lavanteUtils.fetchDBdata(usrgrp);	
		
		String InvOrg="select Top 1 OrganizationName from CustomerOrganization where CustomerID="+customerID;
		InvOrg=lavanteUtils.fetchDBdata(InvOrg);	
		InvOrg=InvOrg.trim();
		
		LavanteUtils.editcsv(nwfile, 0,username );
		LavanteUtils.editcsv(nwfile, 1,email );
		LavanteUtils.editcsv(nwfile, 2,"Yes" );
		LavanteUtils.editcsv(nwfile, 3,role );
		LavanteUtils.editcsv(nwfile, 4,usrgrp );
		LavanteUtils.editcsv(nwfile, 5,InvOrg );
		
		dataMap.put("UploadType", "User Creation File");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEuserFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softAssert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softAssert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softAssert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.UserUploadListNoofrecord().get(i).getText();
				Reporter.log("Uploaded file Record Count,Expected:1,Actuals:"+count);
				softAssert.assertEquals(count,"1","File Record Count not matched");
				flag=true;
				break;
			
			}
			
		}
		
		Assert.assertTrue(flag,"File Status Not Expected");
		
		dataMap.put("maintab","customerApprovals");
		dataMap.put("subtab","viewApprovalTasks");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("InvitingOrg",InvOrg);
		dataMap.put("Group",usrgrp);
		String dusername=username+"("+email+")";
		dataMap.put("User",dusername);
		dataMap.put("ReAssign","");
		String sname=enReassign.selectSupplierFormAction(dataMap);
		
		lavanteUtils.fluentwait(enReassign.searchbtn());
		dataMap.put("supplierName", sname);
		dataMap.put("search", "");
		enReassign.Search(dataMap);

		lavanteUtils.fluentwait(enReassign.listSName().get(0));
		String actsname=enReassign.listSName().get(0).getText();
		String actual=enReassign.listAssignedTo().get(0).getText();
		
		Reporter.log("Supp Name,Exp"+sname+",Actuals:"+actsname);
		softAssert.assertEquals(actsname,sname,"Supp Name Not Matched");
	
		username=email+"("+usrgrp+")";
		Reporter.log("Assigned to,Exp"+username+",Actuals:"+actual);
		softAssert.assertEquals(actual,username,"Assigned to Group Not Matched");
		
		lavanteUtils.click(enReassign.listSName().get(0));
		
		dataMap.put("maintab","Status and History");
		dataMap.put("subtab","ProfileStage");
		enviewSupplier.selectTab(dataMap);
		
		outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();i++){
			actual=enviewSupplier.StatusProfApprovalListType().get(i).getText();
			String exp="Reassign";
			if(actual.equalsIgnoreCase(exp)){
				System.out.println("Type,Exp"+exp+",Actuals:"+actual);
				Reporter.log("Type,Exp"+exp+",Actuals:"+actual);
				softAssert.assertEquals(actual,exp,"Type to Not Matched");
				
				actual=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
				String cname="Select ContactName From Contact where Email='"+LdataMap.get("username")+"'";
				cname=lavanteUtils.fetchDBdata(cname);
				Reporter.log("Actor,Exp,"+cname+",Actuals:"+actual);
				softAssert.assertTrue(actual.contains(cname),"Actor to Not Matched");
				
				actual=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
				exp="Suppliers registration to approve";
				Reporter.log("Action,Exp,"+exp+",Actuals:"+actual);
				softAssert.assertEquals(actual,exp,"Action to Not Matched");
				
				actual=enviewSupplier.StatusProfApprovalListComment().get(i).getText();
				exp="Task is reassigned to "+username;
				Reporter.log("Comments,Exp,"+exp+",Actuals:"+actual);
				softAssert.assertEquals(actual,exp,"Comment to Not Matched");
		
				flag=true;
				break outr;
			}
		}
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		
		Reporter.log("Test Started for Approval Task Reassignment to Group  :"+currenttime());
		
	}

	/**
	 * Create New USer assign Inviting Org and Group
	 *  Goto task Reassignment->Approval Task->Reassign to the Created User
	 *  Verify in Table Data
	 *  Verify in view Supplier 
	 * 
	 * @throws Exception
	 */
	@Test(dataProvider = "AddNwUser", dataProviderClass = ManageUsers.class)
	public void CreateNwUserReassign(LinkedHashMap<String,String> dataMap) throws Exception
	{
		
		Reporter.log("Test Started for Reassignment to Newly Created User :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "Contacts");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("Save", "");

		String InvOrg="Select Top 1 OrganizationName From CustomerOrganization Where CustomerOrganizationID In (Select CustomerOrganizationID"
				+ " From LoginInvitingOrgMap where LoginID in (select LoginID from [Login] where ContactID in "
				+ "(Select ContactID from Contact where Email='"+LdataMap.get("username")+"') )"
				+ "Group by CustomerOrganizationID ) AND CustomerID="+customerID;
		
		InvOrg=lavanteUtils.fetchDBdata(InvOrg).trim();
		
		String usrgrp="select Top 1 GroupName from UserGroup where CustomerID="+customerID;
		usrgrp=lavanteUtils.fetchDBdata(usrgrp).trim();

		dataMap.put("InvitingOrg",InvOrg);
		dataMap.put("Group",usrgrp);
		objUserPage.addNewUser(dataMap);
		String x=dataMap.get("ContactName");
		String y=dataMap.get("Email");
		String username=x;
		String email=y;
		
		dataMap.put("maintab","Tasks");
		dataMap.put("subtab","viewApprovalTasks");
		enobjhomePage.selectTab(dataMap);

		String dusername=username+"("+email+")";
		dataMap.put("User",dusername);
		dataMap.put("ReAssign","");
		String sname=enReassign.selectSupplierFormAction(dataMap);

		lavanteUtils.fluentwait(enReassign.searchbtn());
		dataMap.put("supplierName", sname);
		dataMap.put("search", "");
		enReassign.Search(dataMap);

		lavanteUtils.fluentwait(enReassign.listSName().get(0));
		String actsname=enReassign.listSName().get(0).getText();
		String actual=enReassign.listAssignedTo().get(0).getText();
		
		Reporter.log("Supp Name,Exp"+sname+",Actuals:"+actsname);
		softAssert.assertEquals(actsname,sname,"Supp Name Not Matched");
	
		username=email+"("+usrgrp+")";
		Reporter.log("Assigned to,Exp:"+username+",Actuals:"+actual);
		softAssert.assertTrue(actual.contains(usrgrp),"Assigned to Group Not Matched");
		
		lavanteUtils.click(enReassign.listSName().get(0));
		
		dataMap.put("maintab","Status and History");
		dataMap.put("subtab","ProfileStage");
		enviewSupplier.selectTab(dataMap);
		
		outr:for(int i=0;i<enviewSupplier.StatusProfApprovalListType().size();i++){
			actual=enviewSupplier.StatusProfApprovalListType().get(i).getText();
			String exp="Reassign";
			if(actual.equalsIgnoreCase(exp)){
				Reporter.log("Type,Exp"+exp+",Actuals:"+actual);
				softAssert.assertEquals(actual,exp,"Type to Not Matched");
				
				actual=enviewSupplier.StatusProfApprovalListActor().get(i).getText();
				String cname="Select ContactName From Contact where Email='"+LdataMap.get("username")+"'";	
				cname=lavanteUtils.fetchDBdata(cname);
				Reporter.log("Actor,Exp,"+cname+",Actuals:"+actual);
				softAssert.assertTrue(actual.contains(cname),"Actor to Not Matched");
				
				actual=enviewSupplier.StatusProfApprovalListAction().get(i).getText();
				exp="Suppliers registration to approve";
				Reporter.log("Action,Exp,"+exp+",Actuals:"+actual);
				softAssert.assertEquals(actual,exp,"Action to Not Matched");
		
				actual=enviewSupplier.StatusProfApprovalListComment().get(i).getText();
				exp="Task is reassigned to "+username;
				Reporter.log("Comments,Exp,"+exp+",Actuals:"+actual,true);
				softAssert.assertEquals(actual,exp,"Comment to Not Matched");
		
				flag=true;
				break outr;
			}
		}
				
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		
		Reporter.log("Test Started for Reassignment to Newly Created User :"+currenttime());
		
	}

	/**
	 * SIM-9423 
	 *  Goto task Reassignment->Invoice->Reassign
	 *  Verify Approval History details in view Invoice 
	 * 
	 * @throws Exception
	 */
	@Test
	public void InvoiceTaskReassignToRole() throws Exception
	{
		
		Reporter.log("Test Started for Invoice Task Reassignment to Group :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		dataMap.put("filterby","Invoice Approvals");
        dataMap.put("ReAssign","");
        dataMap.put("AssginTo","Role");

		String query="select UTFString from UserTranslation where i18nKey in ( select  RoleName_i18nKey From LoginRole where UserRoleID in ("
				+ " select  UserRoleID from [Login] where ContactID in (select ContactID from Contact where Email='"+LdataMap.get("username")+"' )"
				+ " )  ) and LanguageID=50";
		
		query=lavanteUtils.fetchDBdata(query);
        String role=query;                      
        dataMap.put("Role",query);
        String inv = enReassign.selectSupplierFormAction(dataMap);
        
        lavanteUtils.fluentwait(enReassign.searchbtn());
        dataMap.put("maintab","TASKS");
        dataMap.put("subtab","getInvoiceTasks");
		enobjhomePage.selectTab(dataMap);
		
		 query="Declare @InvoiceNumber Varchar(50) ='"+inv+"'"
				+ " Select Distinct S.SupplierName From (Select CustomerId,LavanteUID,InvoiceNumber From InvoiceDetails Where InvoiceNumber=@InvoiceNumber"
				+ " Union Select CustomerId, LavanteUID,InvoiceNumber From SupplierInvoiceDetails Where InvoiceNumber=@InvoiceNumber) As Der_tbl"
				+ " INNER JOIN Relationship R On R.LavanteUID=Der_tbl.LavanteUID AND R.CustomerId=Der_tbl.CustomerId "
				+ " Inner Join Supplier S On S.LavanteUID=R.LavanteUID";
		
		String sname="";
		sname=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("supplierName",sname);
		dataMap.put("InvoiceNumber",inv);
		enTaskinvoicestoApprve.Search(dataMap);
	
		lavanteUtils.waitforPageload(enTaskinvoicestoApprve.Search());
		lavanteUtils.waitForTime(4000);
		
		boolean invfound=false;
		int x=enobjhomePage.TotalPage().size();
		if(x==0){
			x=1;
		}
		int ji=0;
		outr:for(ji=0;ji<x;ji++){
			for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").size();i++){
				String actinv=enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i).getText();
				if(inv.equalsIgnoreCase(actinv)){
					invfound=true;
					Reporter.log("Reassigned Invoice Num:"+inv,true);
					lavanteUtils.click(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Number").get(i));
					lavanteUtils.fluentwait(eninvoicePage.suppname());
					
					for(i=0;i<enTaskinvoicestoApprve.VIEWinvStatusProfStatusListAction().size();i++){
						String actual=enTaskinvoicestoApprve.VIEWinvStatusProfStatusListAction().get(i).getText();
						String exp="Reassign";
						if(actual.equalsIgnoreCase(exp)){
							
							Reporter.log("Type,Exp"+exp+",Actuals:"+actual);
							softAssert.assertEquals(actual,exp,"Type to Not Matched");
							
							String sx="select ContactName from Contact where Email='"+LdataMap.get("username")+"'";
							sx=lavanteUtils.fetchDBdata(sx);
							actual=enTaskinvoicestoApprve.VIEWinvStatusProfStatusListActor().get(1).getText();
							Reporter.log("Actor,Exp"+sx+",Actuals:"+actual);
							softAssert.assertTrue(actual.contains(sx),"Actor to Not Matched");
							
							actual=enTaskinvoicestoApprve.VIEWinvStatusProfStatusListAction().get(1).getText();
							exp="Reassign";
							Reporter.log("Action,Exp"+exp+",Actuals:"+actual);
							softAssert.assertEquals(actual,exp,"Action to Not Matched");
							
							actual=enTaskinvoicestoApprve.VIEWinvStatusProfStatusListComment().get(1).getText();
							exp="Task is reassigned to "+role;
							Reporter.log("Comments,Exp"+exp+",Actuals:"+actual);
							softAssert.assertEquals(actual,exp,"Comment to Not Matched");
				
							 flag=true;
							 break outr;
						}
					}
					 
				}
			}		
			}if(invfound==false){
				int y=ji+1;
				if(y<x){
				lavanteUtils.click(enobjhomePage.TotalPage().get(y));
			}
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		
		Reporter.log("Test Started for Approval Task Reassignment to Group  :"+currenttime());
		
	}

	
	@AfterMethod
	public void SetupAftermethod()
	{
		enobjhomePage.backtoSearch();
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
	}
		
	@AfterClass
	public void SetupafterClassmethod(){
		
		enobjhomePage.logout();
		quitBrowser();
	}



}

