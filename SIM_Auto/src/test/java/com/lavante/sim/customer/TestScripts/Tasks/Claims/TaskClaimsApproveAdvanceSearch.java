package com.lavante.sim.customer.TestScripts.Tasks.Claims;

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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.DynamicSearch;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class TaskClaimsApproveAdvanceSearch extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID;
	String Email;
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
		
		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(LdataMap);

		lavanteUtils.fluentwait(objTasksClaimPage.taskSearchBtn());
		LdataMap.put("TaskView", "My Task");
		objTasksClaimPage.switchTasksClaimView(LdataMap);
		if(!(objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID").size()>4)){
			
			LdataMap.put("subtab", "viewApprovalTasks");
			enobjhomePage.selectTab(LdataMap);
			
			LdataMap.put("filterby","Claims to approve");
			LdataMap.put("ALLSupplier","");
			LdataMap.put("ReAssign","");
			LdataMap.put("AssginTo","User");
			String x="Select lr.UserRoleName From Login l,LoginRole lr where l.ContactID in (select ContactID From contact where Email ='"+LdataMap.get("username")+"') "
					+ " and lr.UserRoleID=l.UserRoleID";
			x=lavanteUtils.fetchDBdata(x);
			String uname=x+"("+LdataMap.get("username")+")";
			LdataMap.put("User",LdataMap.get("username")); 
			enReassign.selectSupplierFormAction(LdataMap);
		}
	
	}
	
	/**
	 * Before method to navigate to the Tasks->Claim tab
	 * 
	 */
	@BeforeMethod
	public void navigateToTaskClaimPage(){
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(LdataMap);
		waitforPageload(objTasksClaimPage.pageHeader());		
	}
	
	/**
	 * Test Script to Advance Search Claim to Approve
	 * 
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider = "ClaimsToApprove", dataProviderClass = DynamicSearch.class)
	public void AdvanceSearch(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("<---------------------Test Started for AdvanceSearch: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		
		dataMap.put("AutoEmail", Email);
		dataMap.put("AutoClaim", Email);
		dataMap= lavanteUtils.convertdatamap(dataMap);
		
		dataMap.put("Search","");
		dataMap.put("Advanced","");
		objTasksClaimPage.advanceSearch(dataMap);	
		boolean flag=false;
		
		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		for(int i=0;i<objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID").size();i++){
			String x=dataMap.get("SearchFields");
			String[] y=new String[20];
			
			if(x.contains("#")){
				y=x.split("#");
			}else{
				y[0]=x;
			}
				
			for(int ji=0;ji<y.length;ji++ ){
				String sefkey=y[ji];
				if(dataMap.containsKey(sefkey)){
					String act=objTasksClaimPage.iterateSearchHeaderFindColList(sefkey).get(i).getText().trim();
					String exp=dataMap.get(sefkey);
					boolean result = ensupplierAdvanced.verifySearch(exp, act);
					softAssert.assertTrue(result, "Result Not Matched,Please Retest:" + x+ ",In app:" + exp);
					flag=true;
				}
			
			}
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}

	/**
	 * Test Script to Advance Search Claim to Approve and Save the Query and Mark as Default
	 * 
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider = "SingleClaimsToApprove", dataProviderClass = DynamicSearch.class)
	public void SaveMarkasDefaultAdvanceSearch(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("<---------------------Test Started for AdvanceSearch: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		
		dataMap.put("AutoEmail", Email);
		dataMap.put("AutoClaim", Email);
		dataMap= lavanteUtils.convertdatamap(dataMap);
		
		dataMap.put("Advanced","");
		dataMap.put("Save","");
		
		dataMap.put("SaveSearchName","ANY");
		dataMap.put("MarkAsDefault","ANY");
		dataMap.put("SaveQuery","");
		objTasksClaimPage.advanceSearch(dataMap);	
		boolean flag=false;
		
		String x=dataMap.get("SaveSearchName");
		for(int i=0;i<objTasksClaimPage.SavedQNameList().size();i++){
			String act=objTasksClaimPage.SavedQNameList().get(i).getText().trim();
			if(act.equalsIgnoreCase(x)){
				Reporter.log("Saved Query Expected:"+x+",Actu:"+act,true);
				
				String cl=objTasksClaimPage.markDefaultIconList().get(i).getAttribute("class");
				softAssert.assertTrue(cl.contains("icon_makeDefault"), "Default Icon not set");
				
				flag=true;
			}
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		flag=false;
		
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		for(int i=0;i<objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID").size();i++){
			x=dataMap.get("SearchFields");
			String[] y=new String[20];
			
			if(x.contains("#")){
				y=x.split("#");
			}else{
				y[0]=x;
			}
				
			for(int ji=0;ji<y.length;ji++ ){
				String sefkey=y[ji];
				if(dataMap.containsKey(sefkey)){
					String act=objTasksClaimPage.iterateSearchHeaderFindColList(sefkey).get(i).getText().trim();
					String exp=dataMap.get(sefkey);
					boolean result = ensupplierAdvanced.verifySearch(exp, act);
					softAssert.assertTrue(result, "Result Not Matched,Please Retest:" + x+ ",In app:" + exp);
					flag=true;
				}
			
			}
			if(flag==true){
				break;
			}
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}

	/**
	 * Test Script to Advance Search Claim to Approve and Save the Query and Mark as Default
	 * 
	 * 
	 * @throws Exception
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider = "SingleClaimsToApprove", dataProviderClass = DynamicSearch.class)
	public void EditQuery(LinkedHashMap<String, String> dataMap) throws Exception {
		Reporter.log("<---------------------Test Started for AdvanceSearch: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		boolean flag=false;
		
		dataMap.put("AutoEmail", Email);
		dataMap.put("AutoClaim", Email);
		dataMap= lavanteUtils.convertdatamap(dataMap);
		
		dataMap.put("Advanced","");
		dataMap.put("Clear","");
		dataMap.put("Save","");
		dataMap.put("SaveSearchName","ANY");
		dataMap.put("SaveQuery","");
		dataMap.put("EditQuery","");
		objTasksClaimPage.advanceSearch(dataMap);	
		
		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		for(int i=0;i<objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID").size();i++){
			String x=dataMap.get("SearchFields");
			String[] y=new String[20];
			
			if(x.contains("#")){
				y=x.split("#");
			}else{
				y[0]=x;
			}
				
			for(int ji=0;ji<y.length;ji++ ){
				String sefkey=y[ji];
				if(dataMap.containsKey(sefkey)){
					String act=objTasksClaimPage.iterateSearchHeaderFindColList(sefkey).get(i).getText().trim();
					String exp=dataMap.get(sefkey);
					boolean result = ensupplierAdvanced.verifySearch(exp, act);
					softAssert.assertTrue(result, "Result Not Matched,Please Retest:" + x+ ",In app:" + exp);
					flag=true;
				}
			
			}
			if(flag==true){
				break;
			}
		}
		flag=false;
		

		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		for(int i=0;i<objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID").size();i++){
			String x=dataMap.get("SearchFields");
			String[] y=new String[20];
			
			if(x.contains("#")){
				y=x.split("#");
			}else{
				y[0]=x;
			}
				
			for(int ji=0;ji<y.length;ji++ ){
				String sefkey=y[ji];
				if(dataMap.containsKey(sefkey)){
					String act=objTasksClaimPage.iterateSearchHeaderFindColList(sefkey).get(i).getText().trim();
					String exp=dataMap.get(sefkey);
					boolean result = ensupplierAdvanced.verifySearch(exp, act);
					softAssert.assertTrue(result, "Result Not Matched,Please Retest:" + x+ ",In app:" + exp);
					flag=true;
				}
			
			}
			if(flag==true){
				break;
			}
		}
		
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended at:" + currenttime(),true);
	}
	
	
	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();		
	}
}
