package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;
/**
 * Created on 16-12-2015
 * Created for Deliverable Test case
 * Enhancement covered SIM -7108 ,SIM-7340,SIM-7341
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class PaymentEFT02 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
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
			
		//Login
		List listofdatafrm=lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		
		//Login
		String supname=LdataMap.get("supname");
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		lavanteUtils.switchtoFrame(null);
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
	}

	/**EFTAgree Search
	 * Replacement of CustSupViewProfileTC0001
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replaced with CustSupViewProfileTC0001
	 */
	@Test(dataProvider="EFT",dataProviderClass=SupplierSearchDataProvider.class)
	public void EFTAgree(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for EFT Agree:"+currenttime());
		SoftAssert softAssert =new SoftAssert();
		boolean flag=false;
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		dataMap.put("Search", "");
		ensupplierAdvanced.buildQuery(dataMap);			
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");		
			String sup=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

			dataMap.put("tab", "Treasury");
			eneditProfile.selectTab(dataMap);
			
			dataMap.put("EFTAgree","YES");
			dataMap.put("paymentTypeSupport","EFT");
			eneditPayment.fillPayMentInfo(dataMap);
			
			dataMap.put("SaveExit", "");
			eneditProfile.formAction(dataMap);	
			
			lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			enviewSupplier.clickOnSupplier(sup);
			
			lavanteUtils.switchtoFrame(null);
			
			dataMap.put("subtab", "Treasury");
			enviewSupplier.selectTab(dataMap);
			
			lavanteUtils.fluentwait(enviewSupplier.GetPaymentEFTTC());

			String act=enviewSupplier.GetPaymentEFTTC().getText();
			String exp="Yes";
			System.out.println("EFT Agree  Expected:"+exp+",actual:"+act);
			Reporter.log("EFT Agree  Expected:"+exp+",actual:"+act);
			softAssert.assertEquals(act,exp,"EFT Agree Not Matched,Expected:"+exp+",actual:"+act);
			
			
			flag=true;
			
		}else{
			Reporter.log("Please Add test data for this Search and RETEST");
			softAssert.assertTrue(false,"Please Add test data for this Search and RETEST");
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"Test issue");
		}
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for Approved Search at:"+currenttime());
	}
	
	
	@AfterMethod
	public void aftermethod(){
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
		
	}
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		
		quitBrowser();
	}


}

