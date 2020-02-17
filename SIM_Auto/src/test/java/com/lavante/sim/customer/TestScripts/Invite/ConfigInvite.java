package com.lavante.sim.customer.TestScripts.Invite;

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
 * Created 
 * for Verifying Config Invite
 * 
 * @author Piramanayagam.S
 *
 */

public class ConfigInvite extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID="";
	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Piramanayagam.S
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) 	throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Config", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod
	public void before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);
		
		enobjsupplierBasicSearch.formAction(dataMap);

	}

	/**
	 * RoleBasedEditInviteConfig -Enables the Edit Invite Option ,irrespective of IF the invite has already been sent 
	 * 
	 * @author Piramanayagam.S 
	 * @throws Exception
	 * 
	 */
	@Test
	public void RoleBasedEditInviteConfig() throws Exception {
		Reporter.log("Test Started for Role Based Edit Config : "+ currenttime(),true);
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		String query=" update CustomerPropertyValue set IsActive=1 where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='ENABLE_EDIT_INVITE_POST_INVITE')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);
		
		dataMap.put("ProfStatus", "Pending Invite");
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);

		enobjsupplierPage.searchResultsFilterBy("Any");
		boolean flag=false,flag2=false;
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("supplierNameRandom", "ANY");
			dataMap.put("Invitation", "ANY");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			String x=enobjsupplierPage.hiddenisEditInviteEnabledPostInvite().getAttribute("value");
			String exp="true";
			Reporter.log("Property for Edit Button,Expected:"+exp+",Actuals:"+x);
			softAssert.assertEquals(x,exp,"Property of Edit Button Not Set to true");
			flag=true;
			
		}
		
		
		query=" update CustomerPropertyValue set IsActive=0 where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='ENABLE_EDIT_INVITE_POST_INVITE')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);
		dataMap.remove("ProfStatus");
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("supplierNameRandom", "ANY");
			dataMap.put("Invitation", "ANY");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			String x=enobjsupplierPage.hiddenisEditInviteEnabledPostInvite().getAttribute("value");
			String exp="false";
			Reporter.log("Property for Edit Button,Expected:"+exp+",Actuals:"+x);
			softAssert.assertEquals(x,exp,"Property of Edit Button Not Set to true");
			flag2=true;
			
		}
		
		softAssert.assertTrue(flag,"Property of Edit Button Not Set to true");
		softAssert.assertTrue(flag2,"Property of Edit Button Not Set to true");

		softAssert.assertAll();
		Reporter.log("Test Ended for Role Based Config at:" + currenttime(),true);
	}
	
	/**
	 * RoleBasedInvitePrefixConfig -Sets the Invite id with a prefix set by the value
	 * 
	 * @author Piramanayagam.S 
	 * @throws Exception
	 * 
	 */
	@Test
	public void RoleBasedInvitePrefixConfig() throws Exception {
		Reporter.log("Test Started for Role Prefix Config : "+ currenttime(),true);
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		String random="AutoConf"+randomnum();
		String query=" update CustomerPropertyValue set PropertyValue='"+random+"' where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='INVITE_PREFIX')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);

		enobjsupplierPage.selectChangeView("Invites");
		
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		enobjsupplierPage.searchResultsFilterBy("Any");
		
		boolean flag=false;
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			enobjsupplierPage.selectChangeView("Invites");
			
			String x=enobjsupplierPage.getColumnText("Invitation ID", 0);
			Reporter.log("Invite ID Prefix:,Exp:"+random+",Actuals:"+x);
			softAssert.assertTrue(x.startsWith(random),"Invite ID Prefix Starts With Failed");
			flag=true;
			
			query=" update CustomerPropertyValue set PropertyValue='I' where CustomerPropertyID "
					+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='INVITE_PREFIX')"
					+ " and CustomerID="+customerID;
			lavanteUtils.UpdateDB(query);
			
		}
		
		
		softAssert.assertTrue(flag);

		softAssert.assertAll();
		Reporter.log("Test Ended for Role Based Config at:" + currenttime(),true);
	}

	/**
	 * RoleBasedEditInviteConfig -Enables the Edit Invite Option ,irrespective of IF the invite has already been sent 
	 * 
	 * @author Piramanayagam.S 
	 * @throws Exception
	 * 
	 */
	@Test
	public void RoleBasedExtendConfig() throws Exception {
		Reporter.log("Test Started for Role Extend Config : "+ currenttime(),true);
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		String query=" update CustomerPropertyValue set IsActive=0 where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='IS_EXTEND_INVITE_DISABLED')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);

		dataMap.put("ProfStatus", "Loaded");
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		enobjsupplierPage.searchResultsFilterBy("Any");
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		dataMap.put("SearchOption", "Suppliers");
		enobjsupplierPage.searchView(dataMap);
		
		boolean flag=false,flag2=true;
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("supplierNameRandom", "ANY");
			dataMap.put("Invitation", "ANY");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			String x=enobjsupplierPage.ExtendInvitebtn().getAttribute("href");
			String exp="extendInvite";
			Reporter.log("Property for Extend Invite Button,Enabled:"+exp+",Actuals:"+x,true);
			softAssert.assertTrue(x.contains(exp),"Property of Extend Invite Not Set to true");
			flag=true;
			
		}
		
		query=" update CustomerPropertyValue set IsActive=1 where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='IS_EXTEND_INVITE_DISABLED')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);
		dataMap.remove("ProfStatus");
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("supplierNameRandom", "ANY");
			dataMap.put("Invitation", "ANY");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			String exp="false";
			
			flag2=isElementDisplayed(enobjsupplierPage.ExtendInvitebtn());
			Reporter.log("Property for Extend Invite Button,Expected:"+exp+",Actuals:"+flag2,true);
			softAssert.assertFalse(flag2,"Extend Invite button is available");
			flag2=false;
		}
		
		query=" update CustomerPropertyValue set IsActive=0 where CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where  PropertyName='IS_EXTEND_INVITE_DISABLED') and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);
			
		softAssert.assertTrue(flag,"Property of Extend Invite Not Set to true");
		softAssert.assertFalse(flag2,"Extend Invite button is available");

		softAssert.assertAll();
		Reporter.log("Test Ended for Role Based Config at:" + currenttime(),true);
	}

	/**
	 * RoleBasedEditInviteConfig -Enables the Edit Invite Option ,irrespective of IF the invite has already been sent 
	 * 
	 * @author Piramanayagam.S 
	 * @throws Exception
	 * 
	 */
	@Test
	public void DefaultFilter() throws Exception {
		Reporter.log("Test Started for Default Filter : "+ currenttime(),true);
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		String query=" update CustomerPropertyValue set PropertyValue=14801 where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='IS_DEFAULT_SEARCHFILTER_CONFIGURED')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);
		//14801 is ALL

		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		boolean flag=false;
		if (enobjsupplierPage.iterateSearchHeaderFindColList("Name").size() > 0) {
			Reporter.log("Query Returned with Search data");
			
			String yx=enobjsupplierPage.InputFilterByAllRadiobtn().getAttribute("checked");
			Reporter.log("Property for All Option,Enabled:False,Actuals:"+yx);
			softAssert.assertEquals(yx,"true","Property of All Not Set to true");
			
			yx=enobjsupplierPage.InputFilterByMyInvitesRadiobtn().getAttribute("checked");
			Reporter.log("Property for My Invites Option,Enabled:False,Actuals:"+yx);
			softAssert.assertEquals(yx, null,"Property of MY Invite Not Set to true");
			
        	 yx=enobjsupplierPage.InputFilterByMyDivisionRadiobtn().getAttribute("checked");
			Reporter.log("Property for My Division Option,Enabled:False,Actuals:"+yx);
			softAssert.assertEquals(yx,null , "Property of My Division Not Set to true");
			
			flag=true;
		}
		
		query=" update CustomerPropertyValue set PropertyValue=14803 where CustomerPropertyID "
				+ " in (select CustomerPropertyID from CustomerProperty where  PropertyName='IS_DEFAULT_SEARCHFILTER_CONFIGURED')"
				+ " and CustomerID="+customerID;
		lavanteUtils.UpdateDB(query);
			
		softAssert.assertTrue(flag);

		softAssert.assertAll();
		Reporter.log("Test Ended for Role Based Config at:" + currenttime(),true);
	}

	@AfterClass
	public void SetupafterClassmethod() {

		enobjhomePage.logout();
		quitBrowser();
	}


}