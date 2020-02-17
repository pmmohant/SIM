package com.lavante.sim.customer.TestScripts.Compliance.Address;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 06-10-2016
 * Created for  UAT Address Test
 * Ended on 06-10-2016
 * @author Piramanayagam.S
 *
 */
public class UATAddressTest extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String expaddrss1="";
	String suppName="";
	String customerID="";
	
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
		customerID=""+listofdatafrm.get(1);
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}
		
	/**Add Address for Pending Approval Supplier
	 * Verify in Address TAB
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test(dataProvider="AddLocation",dataProviderClass=EditProfDataProvider.class)
	public void addressVerify(LinkedHashMap<String,String> dataMap) throws Exception{	
		
	Reporter.log("Test Started for Supplier Address at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	dataMap.put("Search", "");
	dataMap.put("ProfStatus", "Approved");
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	dataMap.put("profile","");
	dataMap.put("editProfile","");
	suppName=enobjsupplierPage.VerifyManagedBywithoutNetwork(customerID);
	if(suppName.length()>0){
		dataMap.put("supplierName",suppName);
	}
	suppName=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
	dataMap.put("tab", "CompanyDetails");
	eneditProfile.selectTab(dataMap);
	
	dataMap.put("Address","");
	dataMap.put("DelPrevious", "");
	dataMap.put("AddAddress", "Add New");
	dataMap.put("AddNode","");
	dataMap.put("Contact","ANY");
	dataMap.put("AddContact","Add New");
	
	LinkedHashMap<String, String> entereddata=eneditCompanyProfile.AddLocationContact(dataMap);
	expaddrss1=entereddata.get("Address1");
	Reporter.log("Added address:"+expaddrss1);
	dataMap.put("SaveExit", "");
	eneditProfile.formAction(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	
	dataMap.put("subtab","customerSupplierAddress");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enAddressDetail.searchbtn());
	System.out.println("All Option Filter Visibility Status:"+enAddressDetail.filterBYALL().isDisplayed());
	Reporter.log("All Option Filter Visibility Status:"+enAddressDetail.filterBYALL().isDisplayed());	
	softAssert.assertTrue(enAddressDetail.filterBYALL().isDisplayed(), "All Option Not Available");

	System.out.println("Valid Option Filter Visibility Status:"+enAddressDetail.filterBYValid().isDisplayed());
	Reporter.log("Valid Option Filter Visibility Status:"+enAddressDetail.filterBYValid().isDisplayed());
	softAssert.assertTrue(enAddressDetail.filterBYValid().isDisplayed(), "Valid Option Not Available");

	System.out.println("Invalid Option Filter Visibility Status:"+enAddressDetail.filterBYinValid().isDisplayed());
	Reporter.log("Invalid Option Filter Visibility Status:"+enAddressDetail.filterBYinValid().isDisplayed());
	softAssert.assertTrue(enAddressDetail.filterBYinValid().isDisplayed(), "Invalid Option Not Available");
/*
	System.out.println("Pending Option Filter Visibility Status:"+enAddressDetail.filterByPending().isDisplayed());
	Reporter.log("Pending Option Filter Visibility Status:"+enAddressDetail.filterByPending().isDisplayed());
	Assert.assertTrue(enAddressDetail.filterByPending().isDisplayed(), "Pending Option Not Available");*/
	
	dataMap.put("supplierName",suppName);
	//dataMap.put("SupplierLocation","US");
	dataMap.put("FilterBY","ANY");
	dataMap.put("ShowInactive","");
	enAddressDetail.searchSupplier(dataMap);
	
	//Supplier Selected can be of any Country,To Verify that 
	if(enAddressDetail.ListSupplier().size()>0){
		
	}else{
		dataMap.put("SupplierLocation","NON US");
		enAddressDetail.searchSupplier(dataMap);
	}
	
	lavanteUtils.waitForTime(5000);
	lavanteUtils.waitforPageload(enAddressDetail.searchbtn());
	
	if(enAddressDetail.ListSupplier().size()>0){
		
		String actsup=enAddressDetail.ListSupplier().get(0).getText();
		String addrss1=enAddressDetail.ListAddress1().get(0).getText();
		String city=enAddressDetail.Listcity().get(0).getText();
		String state=enAddressDetail.ListState().get(0).getText();
		String country=enAddressDetail.ListCountry().get(0).getText();
		String pc=enAddressDetail.ListPostalCode().get(0).getText();
		
		
		String expcity=entereddata.get("City");
		String expstate=entereddata.get("State");
		String expcountry=entereddata.get("Country");
		String exppc=entereddata.get("PostalCode");
		
		System.out.println("Supplier Name, expected,"+suppName+",Actuals:"+actsup);
		Reporter.log("Supplier Name, expected,"+suppName+",Actuals:"+actsup);
		softAssert.assertEquals(actsup, suppName,"Postal Code Not matched");
		
		System.out.println("Address 1, expected,"+expaddrss1+",Actuals:"+addrss1);
		Reporter.log("Address 1, expected,"+expaddrss1+",Actuals:"+addrss1);
		softAssert.assertEquals(addrss1, expaddrss1,"Address 1, Not matched");
		
		System.out.println("City expected,"+expcity+",Actuals:"+city);
		Reporter.log("City expected,"+expcity+",Actuals:"+city);
		softAssert.assertEquals(city, expcity,"City Not matched");
		
		System.out.println("State expected,"+expstate+",Actuals:"+state);
		Reporter.log("State expected,"+expstate+",Actuals:"+state);
		softAssert.assertEquals(state, expstate,"State Not matched");
		
		System.out.println("Country expected,"+expcountry+",Actuals:"+country);
		Reporter.log("Country expected,"+expcountry+",Actuals:"+country);
		softAssert.assertEquals(country, expcountry,"Country Code Not matched");
		
		System.out.println("Postal Code expected,"+exppc+",Actuals:"+pc);
		Reporter.log("Postal Code expected,"+exppc+",Actuals:"+pc);
		softAssert.assertEquals(pc, exppc,"Postal Code Not matched");
		
		flag=true;
	}

	
	softAssert.assertTrue(flag,"Search of Supplier not shown in Address Page,Please retest");
	
	
	softAssert.assertAll();
	Reporter.log("Test Ended for Supplier Address :"+currenttime());
	System.out.println("----------Test Ended---for Supplier Address  --------");
}

	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException{
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		enobjhomePage.popupclose();	
		
		if(suppName.length()>0){
			if(expaddrss1.length()>0){
				String query=" delete from  SupplierAddress_AddressType_Map where SupplierAddressMapID in ( "
						+ " select  SupplierAddressMapID from Supplier_Address_Map where AddressID in ( "
						+ " select AddressID from Address where Address1='"+expaddrss1+"'))";
				lavanteUtils.UpdateDB(query);
				
				query="  delete from SupplierCustomerAddressMap where SupplierCustomerAddressMapID in "
						+ " (select AddressID from Address where Address1='"+expaddrss1+"')";
				lavanteUtils.UpdateDB(query);
				
				query=" delete from  Supplier_Address_Map where SupplierAddressMapID in (select AddressID from Address where Address1='"+expaddrss1+"')";
				lavanteUtils.UpdateDB(query);
				
				/*query=" delete from Address where Address1='"+expaddrss1+"'";
				
				lavanteUtils.UpdateDB(query);*/
							
			}
		}
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

