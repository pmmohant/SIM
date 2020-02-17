package com.lavante.sim.customer.TestScripts.Compliance.OFAC;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 12-10-2016
 * Created for  UAT OFAC test
 * Ended on 14-10-2016
 * @author Piramanayagam.S
 *
 */
public class UATOFACTest extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String customerid="";

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
		
		List listofdatafrm=lavanteUtils.login("Omnicare", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
	
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	}
	
	@BeforeMethod
	public void beforemethod(){
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		
	}
	
	
	
	/**Create a Supplier
	 * Add in DB<SKIP This Step later after background job automated,if Necessary>
	 * Verify in OFAC-Require Dispostion State
	 * Deactivate the Supplier
	 * Verify in Deactivated State
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void OFACDeactivate(LinkedHashMap<String,String> dataMap) throws Exception{	
	Reporter.log("Test Started for  OFAC Deactivate verify:"+LavanteUtils.currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log("Invite New Supplier:");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierPage.searchResultsFilterBy("ANY");
	
	String supp=enobjsupplierPage.getColumnText("Name",0);
	System.out.println("Supplier Name ,Expected:"+s[0]+",Actuals::"+supp);
	Reporter.log("Supplier Name ,Expected:"+s[0]+",Actuals::"+supp);
	softAssert.assertEquals(s[0], supp,"Supplier Name Not Matched,Expected:"+s[0]+",Actuals::"+supp);
	
	String query="select LavanteUID From Supplier where SupplierName like '"+s[0]+"'";
	String id=lavanteUtils.fetchDBdata(query);
	String expOfacReason="SDN AKA Match;";
	String expFname="AutoSP";
	String expLname="Mation";
	String expAKA="SP";
	String query2="update Supplier SET IsOFACSupplier =1 where SupplierName like '"+s[0]+"'";
	String query3="insert into SupplierOFAC ( LavanteUID  ,OFACMatchCriteria  ,SDN_UID   ,SDN_FirstName  ,SDN_LastName  ,SDN_AKA  ,SDN_Address  ,SupplierAddressMapID"
			+ "  ,SDN_MatchColumn) VALUES (   "+id+"   ,'"+expOfacReason+"'   ,18601    ,'"+expFname+"'  ,'"+expLname+"'   ,'"+expAKA+"'   ,NULL  ,NULL  ,'SDN_AKA' )";
	
	lavanteUtils.UpdateDB(query2);
	lavanteUtils.UpdateDB(query3);
	
	dataMap.put("maintab","Risks");
	dataMap.put("subtab","OFACList");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enOFACdetails.searchbtn());
	
	softAssert.assertTrue(enOFACdetails.filterBYALL().isDisplayed(),"Filter BY ALL Not available:"+enOFACdetails.filterBYALL().isDisplayed());
	softAssert.assertTrue(enOFACdetails.filterBYAwaiting().isDisplayed(),"Filter BY Awaiting Not available:"+enOFACdetails.filterBYAwaiting().isDisplayed());	
	softAssert.assertTrue(enOFACdetails.filterBYNoMatch().isDisplayed(),"Filter BY No Match Not available:"+enOFACdetails.filterBYNoMatch().isDisplayed());
	softAssert.assertTrue(enOFACdetails.filterByRequiredis().isDisplayed(),"Filter BY Required Disposition Not Available:"+enOFACdetails.filterByRequiredis().isDisplayed());
	softAssert.assertTrue(enOFACdetails.filterByDeactivated().isDisplayed(),"Filter BY ALL Not available:"+enOFACdetails.filterByDeactivated().isDisplayed());
	softAssert.assertTrue(enOFACdetails.filterByOverridden().isDisplayed(),"Filter BY ALL Not available:"+enOFACdetails.filterByOverridden().isDisplayed());
	
	dataMap.put("supplierName", s[0]);
	dataMap.put("FilterBY", "Disposition");
	enOFACdetails.searchSupplier(dataMap);
	
	if(enOFACdetails.ListSupplier().size()>0){
		
		Reporter.log(s[0]+",Supplier Found in Disposition");
		lavanteUtils.click(enOFACdetails.expandall());
		
		String actual=enOFACdetails.OFACReason().getText();
		System.out.println("OFAC Reason,Expected:"+expOfacReason+",Actual:"+actual);
		Reporter.log("OFAC Reason,Expected:"+expOfacReason+",Actual:"+actual);
		softAssert.assertEquals(actual, expOfacReason,"OFAC reason,Not matched,Expected:"+expOfacReason+",Actual:"+actual);
		
		actual=enOFACdetails.OFACFirstName().getText();
		System.out.println("OFAC FirstName,Expected:"+expFname+",Actual:"+actual);
		Reporter.log("OFAC FirstName,Expected:"+expFname+",Actual:"+actual);
		softAssert.assertEquals(actual, expFname,"OFAC FirstName,Not matched,Expected:"+expFname+",Actual:"+actual);
		
		actual=enOFACdetails.OFACLastName().getText();
		System.out.println("OFAC Last Name,Expected:"+expLname+",Actual:"+actual);
		Reporter.log("OFAC Last Name,Expected:"+expLname+",Actual:"+actual);
		softAssert.assertEquals(actual, expLname,"OFAC Last Name,Not matched,Expected:"+expLname+",Actual:"+actual);

		actual=enOFACdetails.OFACAlsoknwn().getText();
		System.out.println("OFAC AKA,Expected:"+expAKA+",Actual:"+actual);
		Reporter.log("OFAC AKA,Expected:"+expAKA+",Actual:"+actual);
		softAssert.assertEquals(actual, expAKA,"OFAC AKA,Not matched,Expected:"+expAKA+",Actual:"+actual);
		
		dataMap.put("Deactivate", "Deactivated");
		enOFACdetails.formAction(dataMap);
		
		dataMap.put("FilterBY", "Deactivated");
		enOFACdetails.searchSupplier(dataMap);
		
		if(enOFACdetails.ListSupplier().size()>0){
			Reporter.log(s[0]+",Supplier Found in Deactivated");
			actual=enOFACdetails.ListSupplier().get(0).getText();
			System.out.println("OFAC Deactivated Supplier,Expected:"+s[0]+",Actual:"+actual);
			Reporter.log("OFAC Deactivated Supplier,Expected:"+s[0]+",Actual:"+actual);
			softAssert.assertEquals(actual, s[0],"OFAC Deactivated Supplier,Not matched,Expected:"+s[0]+",Actual:"+actual);
			flag=true;
		}
		
		
	}
	if(flag==false){
		softAssert.assertTrue(false,"Please retet");
	}


	
	softAssert.assertAll();
	
	
	Reporter.log("Test Ended for OFAC Deactivate at:"+LavanteUtils.currenttime());
	
	
	}

	/**Create a Supplier
	 * Add in DB<SKIP This Step later after background job automated,if Necessary>
	 * Verify in OFAC-Require Dispostion State
	 * Deactivate the Supplier
	 * Verify in Override State
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	//@Test(dataProvider = "InviteNewSupplier", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void OFACOverride(LinkedHashMap<String,String> dataMap) throws Exception{	
	System.out.println("------------Test Started for OFACOverride-------------------"+dataMap);
	
	Reporter.log("Test Started for OFACOverride verify:"+LavanteUtils.currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log("Create New Supplier:");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierPage.searchResultsFilterBy("ANY");
	
	String supp=enobjsupplierPage.getColumnText("Name",0);
	System.out.println("Supplier Name ,Expected:"+s[0]+",Actuals::"+supp);
	Reporter.log("Supplier Name ,Expected:"+s[0]+",Actuals::"+supp);
	softAssert.assertEquals(s[0], supp,"Supplier Name Not Matched,Expected:"+s[0]+",Actuals::"+supp);
	
	String query="select LavanteUID From Supplier where SupplierName like '"+s[0]+"'";
	String id=lavanteUtils.fetchDBdata(query);
	String expOfacReason="SDN AKA Match;";
	String expFname="AutoSP";
	String expLname="Mation";
	String expAKA="SP";
	String query2="update Supplier SET IsOFACSupplier =1 where SupplierName like '"+s[0]+"'";
	String query3="insert into SupplierOFAC ( LavanteUID  ,OFACMatchCriteria  ,SDN_UID   ,SDN_FirstName  ,SDN_LastName  ,SDN_AKA  ,SDN_Address  ,SupplierAddressMapID"
			+ "  ,SDN_MatchColumn) VALUES (   "+id+"   ,'"+expOfacReason+"'   ,18601    ,'"+expFname+"'  ,'"+expLname+"'   ,'"+expAKA+"'   ,NULL  ,NULL  ,'SDN_AKA' )";
	
	lavanteUtils.UpdateDB(query2);
	lavanteUtils.UpdateDB(query3);
	
	dataMap.put("maintab","Risks");
	dataMap.put("subtab","OFACList");
	enobjhomePage.selectTab(dataMap);
	Reporter.log("Navigated to OFAC TAB:");
	
	dataMap.put("supplierName", s[0]);
	dataMap.put("FilterBY", "Disposition");
	enOFACdetails.searchSupplier(dataMap);
	Reporter.log("Supplier Searched:"+s[0]+", at OFAC Disposition State");
	
	if(enOFACdetails.ListSupplier().size()>0){
		
		Reporter.log(s[0]+",Supplier Found in Disposition");
		lavanteUtils.click(enOFACdetails.expandall());
			
		dataMap.put("Override", "Override");
		enOFACdetails.formAction(dataMap);
		
		dataMap.put("FilterBY", "Override");
		enOFACdetails.searchSupplier(dataMap);
		
		if(enOFACdetails.ListSupplier().size()>0){
			Reporter.log(s[0]+",Supplier Found in Override");
			String actual=enOFACdetails.ListSupplier().get(0).getText();
			System.out.println("OFAC Override Supplier,Expected:"+s[0]+",Actual:"+actual);
			Reporter.log("OFAC Override Supplier,Expected:"+s[0]+",Actual:"+actual);
			softAssert.assertEquals(actual, s[0],"OFAC Override Supplier,Not matched,Expected:"+s[0]+",Actual:"+actual);
			flag=true;
		}
		
		
	}
	if(flag==false){
		softAssert.assertTrue(false,"Please retet");
	}


	
	softAssert.assertAll();
	
	
	Reporter.log("Test Ended for OFACOverride at:"+LavanteUtils.currenttime());
	
	
	}
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		enobjInvitenewSupplier.cancel();
		enobjhomePage.popupclose();	
		lavanteUtils.refreshPage();
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

