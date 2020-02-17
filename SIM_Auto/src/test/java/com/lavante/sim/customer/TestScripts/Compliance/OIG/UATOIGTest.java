package com.lavante.sim.customer.TestScripts.Compliance.OIG;

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
 * Created on 08-10-2016
 * Created for  UAT Notification
 * Ended on 10-10-2016
 * @author Piramanayagam.S
 *
 */
public class UATOIGTest extends PageInitiator{
	
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
	 * Verify in OIG-Require Dispostion State
	 * Deactivate the Supplier
	 * Verify in Deactivated State
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "InviteNewSuppliers", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void OIGDeactivate(LinkedHashMap<String,String> dataMap) throws Exception{	
	Reporter.log("Test Started for OIG Deactiavte verify:"+LavanteUtils.currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log(" Search Create New Supplier:");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());

	enobjsupplierPage.searchResultsFilterBy("ANY");

	String supp=enobjsupplierPage.getColumnText("Name",0);
	System.out.println("Supplier Name ,Expected:"+s[0]+",Actuals::"+supp);
	Reporter.log("Supplier Name ,Expected:"+s[0]+",Actuals::"+supp);
	softAssert.assertEquals(s[0], supp,"Supplier Name Not Matched,Expected:"+s[0]+",Actuals::"+supp);
	
	String query="select LavanteUID From Supplier where SupplierName like  '"+s[0]+"'";
	String id=lavanteUtils.fetchDBdata(query);
	
	query="select RelationshipID from Relationship where LavanteUID='"+id+"'";
	String rid=lavanteUtils.fetchDBdata(query);
	
	query="select MAX(SupplierAddressMapID) from Supplier_Address_Map ";
	String addid=lavanteUtils.fetchDBdata(query);
	
	String query2="update Supplier set IsOIGSLEIESupplier=1 where SupplierName like '"+s[0]+"'";
	
	String query3=" Insert into Supplier_OIGS_LEIE (  MatchType  ,LavanteUID ,RelationshipID,SupplierAddressMapID,CustomerID ,CreatedOn ,CreatedBy  ,Supplier_MatchCriteria ) VALUES ("
			+ "   'OIG'   ,"+id+" ,"+rid+" ,"+addid+" ,"+customerid+",'12/10/2016','AutoSP' ,'ADULTCARE SOLUTIONS LLC'  )";
	
	lavanteUtils.UpdateDB(query2);
	lavanteUtils.UpdateDB(query3);
	
	dataMap.put("maintab", "Risks");
	dataMap.put("subtab","customerOIG");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enOIGdetails.searchbtn());
	softAssert.assertTrue(enOIGdetails.filterBYALL().isDisplayed(),"Filter BY ALL Not available:"+enOIGdetails.filterBYALL().isDisplayed());
	softAssert.assertTrue(enOIGdetails.filterBYAwaiting().isDisplayed(),"Filter BY Awaiting Not available:"+enOIGdetails.filterBYAwaiting().isDisplayed());	
	softAssert.assertTrue(enOIGdetails.filterBYNoMatch().isDisplayed(),"Filter BY No Match Not available:"+enOIGdetails.filterBYNoMatch().isDisplayed());
	softAssert.assertTrue(enOIGdetails.filterByRequiredis().isDisplayed(),"Filter BY Required Disposition Not Available:"+enOIGdetails.filterByRequiredis().isDisplayed());
	softAssert.assertTrue(enOIGdetails.filterByDeactivated().isDisplayed(),"Filter BY ALL Not available:"+enOIGdetails.filterByDeactivated().isDisplayed());
	softAssert.assertTrue(enOIGdetails.filterByOverridden().isDisplayed(),"Filter BY ALL Not available:"+enOIGdetails.filterByOverridden().isDisplayed());
	
	
	dataMap.put("supplierName", s[0]);
	dataMap.put("FilterBY", "Disposition");
	enOIGdetails.searchSupplier(dataMap);
	
	if(enOIGdetails.ListSupplier().size()>0){
		
		Reporter.log(s[0]+",Supplier Found in Disposition");
		lavanteUtils.click(enOIGdetails.expandall());
			
		dataMap.put("Deactivate", "Deactivate");
		enOIGdetails.formAction(dataMap);
		
		dataMap.put("FilterBY", "Deactivated");
		enOIGdetails.searchSupplier(dataMap);
		
		if(enOIGdetails.ListSupplier().size()>0){
			Reporter.log(s[0]+",Supplier Found in Deactivate");
			String actual=enOIGdetails.ListSupplier().get(0).getText();
			System.out.println("OIG Deactivate Supplier,Expected:"+s[0]+",Actual:"+actual);
			Reporter.log("OIG Deactivate Supplier,Expected:"+s[0]+",Actual:"+actual);
			softAssert.assertEquals(actual, s[0],"OIG Deactivate Supplier,Not matched,Expected:"+s[0]+",Actual:"+actual);
			flag=true;
		}
		
		
	}
	if(flag==false){
		softAssert.assertTrue(false,"Please retet");
	}


	
	softAssert.assertAll();
	
	
	Reporter.log("Test Ended for OIG Deactiavte at:"+LavanteUtils.currenttime());
	
	
	}
	
	/**Create a Supplier
	 * Add in DB<SKIP This Step later after background job automated,if Necessary>
	 * Verify in OIG-Require Dispostion State
	 * Override the Supplier
	 * Verify in Override State
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider = "InviteNewSupplier", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void OIGOverride(LinkedHashMap<String,String> dataMap) throws Exception{	
	Reporter.log("Test Started for OIG Override verify:"+LavanteUtils.currenttime());
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
	
	String query="select LavanteUID From Supplier where SupplierName like  '"+s[0]+"'";
	String id=lavanteUtils.fetchDBdata(query);
	
	query="select RelationshipID from Relationship where LavanteUID='"+id+"'";
	String rid=lavanteUtils.fetchDBdata(query);
	
	query="select MAX(SupplierAddressMapID) from Supplier_Address_Map ";
	String addid=lavanteUtils.fetchDBdata(query);
	
	String query2="update Supplier set IsOIGSLEIESupplier=1 where SupplierName like '"+s[0]+"'";
	
	String query3=" Insert into Supplier_OIGS_LEIE (  MatchType  ,LavanteUID ,RelationshipID,SupplierAddressMapID,CustomerID ,CreatedOn ,CreatedBy  ,Supplier_MatchCriteria ) VALUES ("
			+ "   'OIG'   ,"+id+" ,"+rid+" ,"+addid+" ,"+customerid+",'12/10/2016','AutoSP' ,'ADULTCARE SOLUTIONS LLC'  )";
	
	lavanteUtils.UpdateDB(query2);
	lavanteUtils.UpdateDB(query3);
	
	dataMap.put("maintab", "Risks");
	dataMap.put("subtab","customerOIG");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("supplierName", s[0]);
	dataMap.put("FilterBY", "Disposition");
	enOIGdetails.searchSupplier(dataMap);
	
	if(enOIGdetails.ListSupplier().size()>0){
		
		Reporter.log(s[0]+",Supplier Found in Disposition");
		lavanteUtils.click(enOIGdetails.expandall());
			
		dataMap.put("Override", "Override");
		enOIGdetails.formAction(dataMap);
		
		dataMap.put("FilterBY", "Override");
		enOIGdetails.searchSupplier(dataMap);
		
		if(enOIGdetails.ListSupplier().size()>0){
			Reporter.log(s[0]+",Supplier Found in Override");
			String actual=enOIGdetails.ListSupplier().get(0).getText();
			System.out.println("OIG Override Supplier,Expected:"+s[0]+",Actual:"+actual);
			Reporter.log("OIG Override Supplier,Expected:"+s[0]+",Actual:"+actual);
			softAssert.assertEquals(actual, s[0],"OIG Override Supplier,Not matched,Expected:"+s[0]+",Actual:"+actual);
			flag=true;
		}
		
		
	}
	if(flag==false){
		softAssert.assertTrue(false,"Please retet");
	}


	
	softAssert.assertAll();
	
	
	Reporter.log("Test Ended for OIG Override at:"+LavanteUtils.currenttime());
	
	
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

