package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.util.LinkedHashMap;
import java.util.List;

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
 * Created on 31-03-2016
 * Verify Finish Profile and Confirmation Message 
 * Enhancement covered SIM-6789
 * @author Hariprasad.MS
 *
 */
public class CompleteProfile01 extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String suppname="";
	
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Hariprasad.M.S
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
		List listofdatafrm=lavanteUtils.login("100Percent",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	//	custid=(String) listofdatafrm.get(1);
		
		//Login
		
		suppname=LdataMap.get("supname");
		suppname="SCRrmann Printing Company";
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
	}
	
	
	@BeforeMethod
	public void beforemethod() throws Exception{
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);	
		
		dataMap.put("Search", "");
		dataMap.put("InactiveSup", "");
		dataMap.put("supplierName", suppname);
		enobjsupplierBasicSearch.search(dataMap);		
		
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		
		Reporter.log("In Product and Service Page:");
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		String profpercent=eneditProfile.profpercent().getText();
		if(!profpercent.equalsIgnoreCase("100%")){
		
			dataMap.put("Product","ASDs");
			eneditCustomerProfile.ProductServices(dataMap);		
			
			dataMap.put("Finish", "");
			eneditProfile.formAction(dataMap);	
			
			lavanteUtils.switchtoFrame(eneditProfile.iframe_Profile_Popup());
			
	//		eneditCustomerProfile.verifyConfirmation("Profile has not reached 100% completion. Would you like to complete remaining required fields ?");
			
			dataMap.remove("Finish");
			dataMap.put("ConfrmNO", "");		
			eneditProfile.formAction(dataMap);
			
		/*	dataMap.remove("ConfrmNO");
			dataMap.put("SaveExit", "");
			eneditProfile.formAction(dataMap);*/
			
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");		
			
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		}
	
	}

	/**
	 * Verify Complete a profile 100% and Its Confirmation Message 
	 * Less than 100Percent
	 * 
	 * @author Piramanayagam.S
	 **/	
	@Test
	public void profileWithlessThan100perc() throws Exception{	
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		Reporter.log("Test to validate Finish Button and confirmation message for 100% complete profile "+currenttime());
		
		Reporter.log("In Product and Service Page:");
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		String profpercent=eneditProfile.profpercent().getText();
		if(profpercent.equalsIgnoreCase("100%")){
		
			dataMap.put("Product","");
			eneditCustomerProfile.ProductServices(dataMap);		
			
			dataMap.put("Finish", "");
			eneditProfile.formAction(dataMap);	
			
			lavanteUtils.switchtoFrame(eneditProfile.iframe_Profile_Popup());
			
			eneditCustomerProfile.verifyConfirmation("Profile has not reached 100% completion. Would you like to complete remaining required fields ?");
			
			dataMap.remove("Finish");
			dataMap.put("ConfrmNO", "");		
			eneditProfile.formAction(dataMap);
			
			dataMap.remove("ConfrmNO");
			dataMap.put("SaveExit", "");
			eneditProfile.formAction(dataMap);
			
			Reporter.log("In Search Page:");
			
			lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
			
			dataMap.put("Search", "");		
			dataMap.put("supplierName", suppname);
			enobjsupplierBasicSearch.search(dataMap);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			eneditCustomerProfile.verifyProfileStatus(suppname,"Incomplete");
			eneditCustomerProfile.verifyProfilePercentage(suppname,"83%");
			flag=true;
		}
		
		softAssert.assertTrue(flag,"Data Not found");
		Reporter.log("Test Ended for less than 100% :"+currenttime());
	
	}
		
	/**SIM-6789
	 * Verify Complete a profile 100% and Its Confirmation Message 
	 * Equals to 100Percent
	 * @author Hariprasad.M.S
	 **/	
	@Test
	public void profileWith100perc() throws Exception
	{

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();				
		Reporter.log("Test to validate Finish Button and confirmation message for less than 100% complete profile "+currenttime());
	
		Reporter.log("In Product  and Service page");
		dataMap.put("Product",""+LavanteUtils.randomnum(99));
		System.out.println("100%"+dataMap);
		eneditCustomerProfile.ProductServices(dataMap);
		
		dataMap.put("Finish", "");
		eneditProfile.formAction(dataMap);	
		
		dataMap.remove("Finish");
		dataMap.put("ConfrmNO", "");		
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		
		lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
		Reporter.log("In Search Page:");
		dataMap.put("Search", suppname);		
		dataMap.put("supplierName", suppname);
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		eneditCustomerProfile.verifyProfileStatus(suppname,"Approved");
		eneditCustomerProfile.verifyProfilePercentage(suppname,"100%");
		
		Reporter.log("Test Ended for 100%:"+currenttime());
	}
	

	@AfterMethod
	public void aftermethod(){
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();	
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
	}
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

