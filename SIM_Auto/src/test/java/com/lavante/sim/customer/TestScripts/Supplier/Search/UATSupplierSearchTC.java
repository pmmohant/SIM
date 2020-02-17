package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.ReportDataProvider;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 20-08-2016
 * Created for Supplier Search 
 * UAT
 * Ended on 25-08-2016
 * @author Piramanayagam.S
 *
 */

public class UATSupplierSearchTC extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String CustomerID="";

	/**
	 * This class all test starts using login page and driver intilization
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
	
		List listofdatafrm=lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		CustomerID=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
	}
		
	@BeforeMethod
	public void before(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		enobjsupplierBasicSearch.formAction(dataMap);
		
		enobjsupplierPage.searchResultsFilterBy("ALL");

	}
	
	/** 
	 * Sync Search between basic And advanced
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of CustomerSupplierSearchTC0009->verify_Sync_AdvancedSearch_BasicSearch
	 * Added Test Scenario of CustomerSupplierSearchTC0001 Hence Combination of Both Test -UI Verification only -Basic and Advanace Search tab exist or not
	 */
	@Test(dataProvider="ProfStatus",dataProviderClass=SupplierSearchDataProvider.class)
	public void BasicadvanceSync001(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Sync Basic Search verify:"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		softAssert.assertTrue(lavanteUtils.isElementDisplayed(enobjsupplierBasicSearch.BasicSearchTab));
		Reporter.log("Basic Search tab Presence:"+lavanteUtils.isElementDisplayed(enobjsupplierBasicSearch.BasicSearchTab));
		
		softAssert.assertTrue(lavanteUtils.isElementDisplayed(ensupplierAdvanced.advtab()));
		Reporter.log("Advance Search tab Presence:"+lavanteUtils.isElementDisplayed(ensupplierAdvanced.advtab()));
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		String basiccount=enobjsupplierBasicSearch.searchcount().getText();
		String countBasic="";
		if(basiccount.contains("(")){
			String[] count=basiccount.split("\\(");
			
			String[] counts=count[1].split("\\)");
			countBasic=counts[0];
		}
		
		Reporter.log("Basic Search Count:"+countBasic);
		lavanteUtils.switchtoFrame(null);
		
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		dataMap.put("Tab", "Enterprise");
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);	
					
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		String advbasiccount=enobjsupplierBasicSearch.searchcount().getText();
		String countadv="";
		if(advbasiccount.contains("(")){
			String[] count=basiccount.split("\\(");
			
			String[] counts=count[1].split("\\)");
			
			countadv=counts[0];
		}
		Reporter.log("Syn Advance Search,Expected:"+countadv+",in app:"+countBasic,true);
		softAssert.assertEquals(countBasic,countadv," Basic Search");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for Sync Basic Search at:"+currenttime());
	}
	
	/** 
	 * do a search and take the count
	 * Do a edit profile and take the count post
	 * Compare both
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of CustomerSupplierSearchTC0012
	 */
	@Test(dataProvider="Approved",dataProviderClass=SupplierSearchDataProvider.class)
	public void BasicSearchCountEditProfileCount002(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Sync Basic Edit Profile -------------------");
		Reporter.log("Test Started for Sync Basic Search verify:"+currenttime());
		
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		String basiccount=enobjsupplierBasicSearch.searchcount().getText();
		
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		lavanteUtils.fluentwait(eneditProfile.cancelBtn());
		dataMap.put("EditCancel", "");		
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		String countafteredit=enobjsupplierBasicSearch.searchcount().getText();
		
		System.out.println("Syn Basic Search,Expected:"+countafteredit+",in app:"+basiccount);
		Reporter.log("Syn Basic Search,Expected:"+countafteredit+",in app:"+basiccount);
		Assert.assertEquals(basiccount,countafteredit," Basic Search");
	
		Reporter.log("Test Ended for Sync Basic Search at:"+currenttime());
}

	/** 
	 * do advance search and take the count
	 * Do a edit profile and take the count post
	 * Compare both
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of CustomerSupplierSearchTC0012
	 */
	@Test(dataProvider="CountryOfReg",dataProviderClass=SupplierSearchDataProvider.class)
	public void AdvSearchCntEdtProfCntCmpare002(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Adv Search:"+currenttime());
	
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Search", "");
		
		ensupplierAdvanced.buildQuery(dataMap);			
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
			String firstCount=enobjsupplierBasicSearch.searchcount().getText();
		
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");		
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
			lavanteUtils.fluentwait(eneditProfile.cancelBtn());
			dataMap.put("EditCancel", "");		
			eneditProfile.formAction(dataMap);
		
			lavanteUtils.waitforPageload(ensupplierAdvanced.advtab());
		
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			String countafteredit=enobjsupplierBasicSearch.searchcount().getText();
		
		System.out.println("Syn Advance Search,Expected:"+countafteredit+",in app:"+firstCount);
		Reporter.log("Syn Advance Search,Expected:"+countafteredit+",in app:"+firstCount);
		Assert.assertEquals(firstCount,countafteredit," Basic Search");
	
		Reporter.log("Test Ended for Sync Basic Search at:"+currenttime());
}
	
	/** 
	 * Do a Profile Complete
	 * Verify the Status
	 * 	 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of CustomerSupplierSearchTC0011
	 */
	@Test(dataProvider="Incomplete",dataProviderClass=SupplierSearchDataProvider.class)
	public void EditProfileComp003(LinkedHashMap<String,String> dataMap) throws Exception{	
	System.out.println("------------Test Started for Profile Complete-------------------");
	Reporter.log("Test Started for Profile Complete verify:"+currenttime());
	
	dataMap.put("Search", "");
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	enobjsupplierPage.selectChangeView("Suppliers and Invites"); 
	
	String sup=enobjsupplierPage.VerifyPendingWith();
	enobjsupplierPage.selectChangeView("Invites"); 
	
	dataMap.put("supplierName", sup);
	dataMap.put("OtherAction","");
	dataMap.put("profileComplete","");
	enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	Reporter.log("Supplier :"+sup+",Changed to profile status,"+dataMap.get("ProfStatus"));
	
	dataMap.clear();
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.formAction(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	
	dataMap.put("supplierName", sup);
	dataMap.put("Search", "");	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	enviewSupplier.clickOnSupplier(sup);
	
	lavanteUtils.switchtoFrame(null);
	
	dataMap.put("maintab","Status and History");
	dataMap.put("subtab","StatusProfile");
	enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.waitForTime(3000);

	String expstatus="Profile Complete";
	String status=enviewSupplier.ListProfileStage().get(0).getText();
		
	System.out.println("Supplier :"+sup+",Status,Expected:"+expstatus+",in app:"+status);
	Reporter.log("Supplier :"+sup+",Status,Expected:"+expstatus+",in app:"+status);
	Assert.assertEquals(status,expstatus," Supplier Status not changed");

	Reporter.log("Test Ended for Profile Complete at:"+currenttime());
}

	/** 
	 * Do a Edit Profile 
	 * Enter duplicate Email
	 * Verify whether it can be saved
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of CustomerSupplierSearchTC0010
	 */
	//@Test(dataProvider="Approved",dataProviderClass=SupplierSearchDataProvider.class)
	public void EditDuplicateEmail004(LinkedHashMap<String,String> dataMap) throws Exception{	
	System.out.println("------------Test Started for Sync Edit Profile Search-------------------");
	Reporter.log("Test Started for Sync Basic Search verify:"+currenttime());
	
	dataMap.put("Search", "");
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	
	dataMap.put("profile", "");
	dataMap.put("editProfile", "");		
	enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
	dataMap.put("tab", "supplierRelationshipEnterpriseInfo");	
	eneditProfile.selectTab(dataMap);
	
	String query="select Max(Email) from Contact where Email like 'a%@%com%'";
	String email=lavanteUtils.fetchDBdata(query);
			
	lavanteUtils.fluentwait(eneditProfile.cancelBtn());
	
	dataMap.put("UserName",LavanteUtils.randomnum());
	dataMap.put("UserEmail",email);
	dataMap.put("SaveUser","");
	eneditEnterprise.addnwuser(dataMap);
	
	lavanteUtils.switchtoFrame(eneditEnterprise.IFRAMEaddUser());
	lavanteUtils.fluentwait(eneditEnterprise.errormsg());
	
	String experrmsg="Another contact with the same Email exists";
	String apperrmsg=eneditEnterprise.errormsg().getText();
	
	
	System.out.println("Duplicate Emails,Expected:"+experrmsg+",in app:"+apperrmsg);
	Reporter.log("Duplicate Emails,Expected:"+experrmsg+",in app:"+apperrmsg);
	Assert.assertEquals(experrmsg,apperrmsg," Basic Search");

	lavanteUtils.refreshPage();
	
	Reporter.log("Test Ended for Sync Basic Search at:"+currenttime());
}

	/** 
	 * To do List  for incomplete
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	//@Test(dataProvider="Incomplete",dataProviderClass=SupplierSearchDataProvider.class)
	public void EditTodoInComp005(LinkedHashMap<String,String> dataMap) throws Exception{	
	System.out.println("------------Test Started for  Edit To Do In complete-------------------"+dataMap);
	Reporter.log("Test Started for Edit To Do In complete verify:"+currenttime());
	
	dataMap.put("Search", "");
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	enobjsupplierPage.selectChangeView("Suppliers and Invites");
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	String sup=enobjsupplierPage.VerifyManagedBywithoutNetwork(CustomerID);
	if(!(sup.length()>0)){
		Assert.assertTrue(false,"1st Sup Not found:");
	}
	dataMap.put("supplierName", sup);
	dataMap.put("profile", "");
	dataMap.put("editProfile", "");		
	enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	Reporter.log("Selected Supplier:"+sup+"in Customer:"+CustomerID);
	
	lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
	
	List<String> explist = new ArrayList<String>();
	for(int i=0;i<eneditProfile.todolist().size();i++){
		String todo=eneditProfile.todolist().get(i).getText();
		System.out.println(todo);
		explist.add(todo);
	}
	

	dataMap.put("EditCancel", "");		
	eneditProfile.formAction(dataMap);	
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	String nwsup="";
	int size=enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()-1;
	outr:for(int i=0;i<=size;i++){
		 String Managedby=enobjsupplierPage.getColumnText("Managed",0);
		 if(Managedby.length()>3){
			 nwsup = enobjsupplierPage.getSupplierName("Name",i);
			 if(!sup.equalsIgnoreCase(nwsup)){
					String x=" select count(LavanteUID) from Relationship where LavanteUID in ( select LavanteUID from Relationship where LavanteUID in ("
							+ " select LavanteUID from Supplier where SupplierName='"+nwsup+"')"
							+ " and CustomerID="+CustomerID+")";
					x=lavanteUtils.fetchDBdata(x);
					int xs=Integer.parseInt(x);
					if(xs>1){
						
					}else{
						break outr;
					}
				}
		 }
		
		System.out.println(nwsup);
	}
	
	if(!(nwsup.length()>0)){
		Assert.assertTrue(false,"Sup Not found:");
	}
	dataMap.put("supplierName", nwsup);
	String sup2=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	Reporter.log("Second Supplier"+nwsup);
	
	
	lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
	
	List<String> actlist = new ArrayList<String>();
	for(int i=0;i<eneditProfile.todolist().size();i++){
		String todo=eneditProfile.todolist().get(i).getText();
		System.out.println("2"+todo);
		actlist.add(todo);
	}
	

	eneditProfile.formAction(dataMap);	

	boolean matched=true;
	int a=explist.size();
	int b=actlist.size();
	if((a==0)==(b==0)){
		matched=false;
	}
    List<String> sourceList = new ArrayList<String>(explist);
    List<String> destinationList = new ArrayList<String>(actlist);
    
    sourceList.removeAll( actlist );
    destinationList.removeAll( explist );
    
    if(sourceList.size()>0){
    	matched=false;
    }
    if (destinationList.size()>0 ){
    	matched=false;
    } /*else {
		for(int i=0;i<explist.size();i++){
			String exp=explist.get(i);
			System.out.println("To Do list, Expected:"+exp+",Actual :"+actlist.get(i)+",Verification Status:"+actlist.contains(exp));
			Reporter.log("To Do list, Expected:"+exp+",Actual :"+actlist.get(i)+",Verification Status:"+actlist.contains(exp));
			if(actlist.contains(exp)){
				matched =true;
			}else{
				matched =false;
				break;
			}
			
		}
	}*/
	
	System.out.println("Supplier 1 :"+sup+",Mis Matched Content,Expected:"+sourceList+",in app:"+destinationList);
	System.out.println("Supplier 2 :"+sup2+",Status,Expected:"+sourceList+",in app:"+destinationList);
	Reporter.log("Supplier 1 :"+sup+",Mis Matched Content,Expected:"+sourceList+",in app:"+destinationList);
	Reporter.log("Supplier 2 :"+sup2+",Status,Expected:"+sourceList+",in app:"+destinationList);
	Assert.assertFalse(matched," Supplier Todo List Matched");

	Reporter.log("Test Ended for Edit To Do In complete at:"+currenttime());

	}

	/** Pagination and Search Criteria Verification
	 * Do a Basic Search,Do a Page navigate,
	 * Send Email
	 * Verify the Search criteria ,
	 * Verify the Page Navigated 
	 * 
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SendEmail",dataProviderClass=EditProfDataProvider.class)
	public void SearchCriteriaVerification009(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Search Criteria and Pagination verify:"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		
		String expsname="S";
		String status="Approved";
		dataMap.put("Search", "");
		dataMap.put("ProfStatus", status);
		dataMap.put("supplierName", expsname);
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		
		enobjsupplierPage.selectChangeView("Suppliers");
		
		int x=enobjhomePage.TotalPage().size();
		int exppage=2;
		if(exppage<x){
			lavanteUtils.click(enobjhomePage.TotalPage().get(exppage-1));
			lavanteUtils.fluentwait(enobjsupplierPage.selviewDrpdwn());
			enobjsupplierPage.selectAllSupplier();
		
			dataMap.put("Invitation", "");
			dataMap.put("sendEmail", "");
			dataMap.put("mailSend", "");
			dataMap.put("confirmMailSend", "");
			dataMap.put("mailFrom", "ANY");
			enobjsupplierPage.ProfileAction(dataMap);
		
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			String actSName=enobjsupplierPage.getColumnText("Name",0);
			Reporter.log("Supplier Name ,Search:"+expsname+",Actual:"+actSName,true);
			softAssert.assertTrue( actSName.contains(expsname),"After Send Email,Supplier Name ,Search");
			
			String actPage=enobjsupplierBasicSearch.gotopage().getText();
			Reporter.log("Current Page After Send Email:"+exppage+",Actual:"+actPage,true);
			softAssert.assertEquals( actPage,""+exppage,"After Send Email,Current Page,");
		
			for(int i=0;i<enobjsupplierPage.iterateSearchHeaderFindColList("Name").size();i++){
					flag=enobjsupplierPage.supchkbx().get(i).isSelected();
					Reporter.log(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(i).getText()+",Supp"+enobjsupplierPage.supchkbx().get(i).isSelected());
					softAssert.assertTrue( flag,"After Send Email,Supplier Checkbox Selection");
					flag=true;
					break;
			}
		
		}else {
			softAssert.assertTrue(false,"No Multiple Page Data");
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for  Search Criteria and Pagination at:"+currenttime());
	
	}
	
	/** 
	 * Get Supplier Search Report Template
	 * Get Report Template of User Defined
	 * Verify Both
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 *Commenting the report as need to alter
	 */
	//@Test 
	public void ReportTemplate011() throws Exception{	
		
		System.out.println("------------Test Started for Report Template -------------------");
		Reporter.log("Test Started for Report Template verify:"+currenttime());
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
					
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.fluentwait(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
		
		ensupplierAdvanced.clickCustomExport();
		
		lavanteUtils.click(ensupplierAdvanced.customExportTemplatedpdn());
		
		List<String> explist= new ArrayList<String>();
		explist=lavanteUtils.listelement(null);
		
		enobjhomePage.popupclose();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Reports");
		enobjhomePage.selectTab(dataMap);
		
		enReportuserDefined.ClickAddNew();
		
		lavanteUtils.click(enReportuserDefined.addTemplatedpdn());
		
		List<String> actlist= new ArrayList<String>();
		actlist=lavanteUtils.listelement(null);
		
		boolean matched=false;
		for(int i=1;i<explist.size();i++){
			String exp=explist.get(i);
			System.out.println(exp+"EXPECt");
			if(actlist.get(i).contains(exp)){
				Reporter.log("Report :"+exp+",Matched in the list");
				matched =true;
			}else{
				Reporter.log("FAIL Report :"+exp+",Not Matched in the list");
				matched =false;
				break;
			}
			
		}
		
		
		Reporter.log("Custom Export Reports availability status in User Defined Report Page:"+matched);
		
		Assert.assertTrue(matched," Custom Export Reports availability status in User Defined Report Page not matched");
		Reporter.log("Test Ended for Custom export report Match at:"+currenttime());
	}
	
	/** 
	 * Verify Report Format in Adminstrative Customer Specific User Defined
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Commenting the Report as need to alter
	 */
	//@Test 
	public void ReportFormat012() throws Exception{	
			
			System.out.println("------------Test Started for Reports Format-------------------");
			Reporter.log("Test Started for Reports Format-:"+currenttime());
			SoftAssert softAssert=new SoftAssert();
			LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
			dataMap.put("maintab","Reports");
			enobjhomePage.selectTab(dataMap);
			Reporter.log("In Reports Adminstravtive Reports Page:");
						
			lavanteUtils.fluentwait(enReportuserDefined.pdfExport());
			
			String pdf=enReportuserDefined.pdfExport().getAttribute("href");
			String xls=enReportuserDefined.xlsExport().getAttribute("href");
			String csv=enReportuserDefined.csvExport().getAttribute("href");
			
			Reporter.log("PDF format Verification,Expected PDF,In app,"+pdf);
			softAssert.assertTrue(pdf.contains("PDF"),"PDF not matched in "+pdf);
			Reporter.log("XLS format Verification,Expected XLS,In app,"+xls);
			softAssert.assertTrue(xls.contains("XLS"),"XLS not matched in "+xls);
			Reporter.log("CSV format Verification,Expected CSV,In app,"+csv);
			softAssert.assertTrue(csv.contains("CSV"),"CSV not matched in "+csv);
			
			
			/*
			dataMap.put("subtab","DefinedReports");
			enobjhomePage.selectTab(dataMap);
			
			enUserDefined.ClickAddNew();
			
			lavanteUtils.click(enUserDefined.addTemplatedpdn());
			
			
			
			
			dataMap.put("subtab","customerSpecificReports");
			enobjhomePage.selectTab(dataMap);
			
			 */

			softAssert.assertAll();
			Reporter.log("Test Ended for Report Export Type at:"+currenttime());
		}
	
	/** 
	 * Verify Custom Report Creation
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Report should be modified
	 */
	//@Test(dataProvider="CustomReport",dataProviderClass=ReportDataProvider.class)
	public void CustomReportCreation014(LinkedHashMap<String,String> dataMap) throws Exception{	
			
			System.out.println("------------Test Started for Custom Report creation-------------------");
			Reporter.log("Test Started for  Custom Report Creation-:"+currenttime());
			boolean flag=false;
			dataMap.put("maintab","Reports");
			enobjhomePage.selectTab(dataMap);
			
			dataMap.put("CustomerID",CustomerID);
			dataMap.put("ReportSave","");
			String Name=enReportuserDefined.AddnewReport(dataMap);
			Reporter.log("Created a  New Report :"+Name);
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enReportuserDefined.addReportbtn());
			
			int size=enReportuserDefined.tblreportname().size()-1;
			for(int i=size;i>=0;i--){
				
				String actrname=enReportuserDefined.tblreportname().get(i).getText();
				if(actrname.equalsIgnoreCase(Name)){
					String type=dataMap.get("ReportType");
					String actrtype=enReportuserDefined.tblreporttype().get(i).getText();
					Reporter.log("Report Type,Exp,"+type+"Actual,"+actrtype);
					Assert.assertEquals(actrtype,type,"Report Type Not Matched "+actrtype);
					Reporter.log("Report Name,Exp,"+Name+"Actual,"+actrname);
					Assert.assertEquals(actrname,Name,"Report Name Not Matched "+actrtype);
					
					String query="delete from ReportCustomExtract where ReportCustomExtractName='"+actrname+"'";
					lavanteUtils.UpdateDB(query);
					Reporter.log("Created Report Deleted from DB:"+actrname);
				
					
					flag=true;
					break;
				}
			}
			
			dataMap.clear();
			dataMap.put("maintab","Supplier");
			
			if(flag==false){
				Assert.assertTrue(false,"Report not matched,Retest");
			}
			Reporter.log("Test Ended for Custom Report at:"+currenttime());
		}

	/**
	 * Test script to verify the supplier basic search results are in sync even after traversing back from supplier profile view.
	 * @param dataMap
	 * @throws Exception
	 * @author Girish.N
	 */
	@Test(dataProvider="SupName",dataProviderClass=SupplierSearchDataProvider.class)
	public void BasicSearchVwProfileInSyncTest(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("<---------------------Test Started for BasicSearchResInSyncTest: " + currenttime(),true);
		SoftAssert softAssert=new SoftAssert();

		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		softAssert.assertTrue(lavanteUtils.isElementDisplayed(enobjsupplierBasicSearch.BasicSearchTab));
		Reporter.log("<----------------Basic Search tab Presence:"+lavanteUtils.isElementDisplayed(enobjsupplierBasicSearch.BasicSearchTab),true);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		int count = lavanteUtils.getCount();
		Reporter.log("<----------------Supplier Basic Search Count: " + count,true);
		boolean flag=false;
		
		if(count>1){
			List<WebElement> supLinks = enobjsupplierPage.iterateSearchHeaderFindColList("Supplier Name");
			String expFirstSupName = "";
			String expSecSupName = "";
			
			expFirstSupName=supLinks.get(0).getText().trim();
			expSecSupName=supLinks.get(1).getText().trim();
			
			//Click on the first supplier name link
			click(supLinks.get(0));
			lavanteUtils.switchtoFrame(null);
			waitforPageload(enviewSupplier.supplierName());
			String actFirstSupName = enviewSupplier.SuppNameCompany().getText().trim();
			softAssert.assertEquals(actFirstSupName, expFirstSupName,"Supplier Name Mismatch for the first supplier in Supplier Search Result and Supplier Profile");
			Reporter.log("<----------------Expected First Supplier Name:" + expFirstSupName+"::Actual  First Supplier Name:"+actFirstSupName,true);
			
			//Click on the next supplier link
				click(enviewSupplier.nextSupplierLink());
				waitforPageload(enviewSupplier.supplierName());
				String actSecSupName = enviewSupplier.SuppNameCompany().getText().trim();
				softAssert.assertEquals(actSecSupName, expSecSupName,"Supplier Name Mismatch for the second supplier in Supplier Search Result and Supplier Profile");
				Reporter.log("<----------------Expected Second Supplier Name:" + expSecSupName+"::Actual  Second Supplier Name:"+actSecSupName,true);
			
			//Click on back link on breadcrumb
			click(enviewSupplier.backToSearchLink());
			waitforPageload(ensupplierAdvanced.advtab());
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			int newCount = lavanteUtils.getCount();
			Reporter.log("<----------------Basic Search Count after return from Supplier Profile: " + newCount,true);
			softAssert.assertEquals(newCount,count,"SEARCH COUNT MISMATCH (after return from Supplier Profile");
			Reporter.log("<----------------Old Supplier Search Result count:" + count+"::Basic Search Count after return from Supplier Profile:"+newCount,true);
			
			String expFirstSupName1 = "";
			String expSecSupName1 = "";
			
			supLinks = enobjsupplierPage.iterateSearchHeaderFindColList("Supplier Name");
			expFirstSupName1=supLinks.get(0).getText().trim();
			expSecSupName1=supLinks.get(1).getText().trim();

			softAssert.assertEquals(expFirstSupName1,expFirstSupName,"Search results doen't match for the first supplier");
			softAssert.assertEquals(expSecSupName1,expSecSupName,"Search results doen't match for the second supplier");
			flag=true;
		}else{
			softAssert.assertTrue(false,"Please Add Test Data");
			flag=true;
		}
		
		
		softAssert.assertTrue(flag,"Please Recheck");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for Sync Basic Adv View Profile Search at:"+currenttime());
	}

	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		lavanteUtils.refreshPage();
		enobjhomePage.backtoSearch();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);	
		
	}
	
	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();		
		quitBrowser();
	}


}

