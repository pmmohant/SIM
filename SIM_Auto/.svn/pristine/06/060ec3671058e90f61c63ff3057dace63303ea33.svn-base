package com.lavante.sim.customer.TestScripts.Tasks.Reassignment;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 13-12-2016
 * SIM-9404
 * Ended on 13-12-2016
 * @author Piramanayagam.S
 *
 */
public class  UATReassignmentTC002 extends PageInitiator  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();	
	LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
	String email="";
	String role="";
	
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
		email=LdataMap.get("username");
	}

	/**
	 *  	Verify the Tab Reassignment
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void ConfiguredUserOnlyReassignmentTab() throws Exception
	{
		Reporter.log("Test Started for Configured User Only can view Reassignment Page :"+currenttime());
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		
		role="Select UserRoleID from Login where ContactID In (Select ContactID where Email='"+email+"')";
		role=lavanteUtils.fetchDBdata(role);
		
		String query="  delete from LoginRole_PageDefinition_Map  WHERE PageDefinitionID in (select PageDefinitionID From PageDefinition where PageURL='viewApprovalTasks.lvp') and LoginAccessTypeID=3 and UserRoleID="+role;

		lavanteUtils.UpdateDB(query);
		
		Reporter.log("Before Test,DB Setting updated");
		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		Reporter.log("Relogin Done");
	
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
	
		dataMap.put("maintab","Tasks");
		enobjhomePage.selectTab(dataMap);
		
		boolean expp=lavanteUtils.isElementDisplayed(enReassign.ReassignTAB());
		Reporter.log("ReAssignment visibility, for non configured user:"+expp);
		Assert.assertFalse(expp,"Reassignment Tab Available"+expp);
		
		query=" 	 insert into  LoginRole_PageDefinition_Map (PageDefinitionID, UserRoleID,LoginAccessTypeID, CreatedBy,IsActive) "
				+ "	 values ((select PageDefinitionID From PageDefinition   where PageURL='viewApprovalTasks.lvp'),"+role+",3,'SPiramu',1) ";
		
		lavanteUtils.UpdateDB(query);
		Reporter.log("After Test,DB Setting Reverted");
		
		softAssert.assertTrue(flag,"Please Retest");
		
		Reporter.log("Test Started for Configured User in Reassignment  Page :"+currenttime());
		
	}
	
	
	@AfterClass
	public void SetupafterClassmethod() throws FileNotFoundException, IOException, SQLException{
		
		String x="delete from LoginRole_PageDefinition_Map  WHERE PageDefinitionID in (select PageDefinitionID From PageDefinition   where PageURL='viewApprovalTasks.lvp') and LoginAccessTypeID=3 and UserRoleID="+role;
		lavanteUtils.UpdateDB(x);
	
		x=" 	 insert into  LoginRole_PageDefinition_Map (PageDefinitionID, UserRoleID,LoginAccessTypeID, CreatedBy,IsActive) "
				+ "	 values ((select PageDefinitionID From PageDefinition   where PageURL='viewApprovalTasks.lvp'),"+role+",3,'SPiramu',1) ";
		lavanteUtils.UpdateDB(x);

		enobjhomePage.logout();
		quitBrowser();
	}
}

