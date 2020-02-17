package com.lavante.sim.customer.TestScripts.Compliance.LegalID;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
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
import com.lavante.sim.Common.Util.Report;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierRegistrationDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 20-09-2016
 * Created for  UAT View Supplier Test
 * Ended on 29-09-2016
 * @author Piramanayagam.S
 *
 */
public class UATLegalID02 extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String customerid="";
	String expsupplierName="";
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
		customerid=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
	}

	@BeforeMethod
	public void beforemethod(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Risks");
		dataMap.put("subtab","customerSupplierLegalID");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);

	}
	/**FOR US Supplier ,Verify the IRS TIN Error code message for Auto Validate and Mismatch
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void OverrideLegalID() throws Exception{	
		
	Reporter.log("Test Started for Override LegaL ID at:"+LavanteUtils.currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
	
	lavanteUtils.fluentwait(enobjLegalID.searchbtn());
	
	dataMap.put("SupplierLocation", "US");
	dataMap.put("FilterBY", "LegalID");
	dataMap.put("FilterSub", "Mismatch");
	enobjLegalID.searchSupplier(dataMap);

	if(enobjLegalID.ListSupplier().size()>0){
		
		expsupplierName=enobjLegalID.ListSupplier().get(0).getText();
		String comment="comm"+lavanteUtils.currenttime();
		dataMap.put("Override",comment);
		enobjLegalID.formAction(dataMap);
		
		lavanteUtils.waitforPageload(enobjLegalID.searchbtn());
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("supplierName",expsupplierName);
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);

		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(expsupplierName);
		
		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("maintab","ProfileStageHistory");
		dataMap.put("subtab","LegalId");
		enviewSupplier.selectTab(dataMap);
		
		lavanteUtils.fluentwait(enviewSupplier.ListLegalStatus().get(0));
		
		outr:for(int i=0;i<enviewSupplier.ListLegalStatus().size();){
			String expAction="Manually Validated";
			String actactionType=enviewSupplier.ListLegalStatus().get(i).getText();
			
			System.out.println(" Legal ID Status:"+expAction+",Actual :"+actactionType);
			Reporter.log(" Legal ID Status:"+expAction+",Actual :"+actactionType);
			softAssert.assertEquals(actactionType, expAction,"Legal ID Status,Expected:"+expAction+",Actuals:"+actactionType);
			
			expAction="United States";
			String actActionTaken=enviewSupplier.ListLegalCountry().get(i).getText();
			
			System.out.println("Country Verification  :"+expAction+",Actual :"+actActionTaken);
			Reporter.log(" Country Verification :"+expAction+",Actual :"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Country Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			expAction=comment;
			actActionTaken=enviewSupplier.ListLegalComments().get(i).getText();
			
			System.out.println("Comment Verification  :"+expAction+",Actual :"+actActionTaken);
			Reporter.log(" Comment Verification :"+expAction+",Actual :"+actActionTaken);
			softAssert.assertEquals(actActionTaken, expAction,"Comment Verification,Expected:"+expAction+",Actuals:"+actActionTaken);
			
			flag=true;
			break outr;
		}

	}
		
	
	
	softAssert.assertAll();
	
	Reporter.log("Test Ended for IRS TIN Reason :"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---for IRS TIN Reason --------");
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
		enobjhomePage.backtoSearch();
		if(expsupplierName.length()>0){
			String query="update Supplier set IsLegalIdentifierValidated=0 where SupplierName='"+expsupplierName+"'";
			lavanteUtils.UpdateDB(query);
			query=" update  Relationship set IsLegalIdentifierValidatedManually=null where customerID="+customerid+" "
					+ " and LavanteUID in (Select LavanteUID from Supplier where  SupplierName='"+expsupplierName+"') ";
			lavanteUtils.UpdateDB(query);
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

