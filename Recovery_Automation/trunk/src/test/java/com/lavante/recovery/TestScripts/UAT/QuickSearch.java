package com.lavante.recovery.TestScripts.UAT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.DataProvider.SearchDataProvider;
import com.lavante.recovery.pageobjects.HomePage;
import com.lavante.recovery.pageobjects.pageInitiator;

public class QuickSearch extends pageInitiator {
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();
		
		waitForTime(2000);

		homePage.SelectAudit(InitProperties("DefaultAudit").trim());
		
	}
	
	/**
	 * Method to test Quick search using Supplier Name
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="SupplierNameSearch",dataProviderClass=SearchDataProvider.class)
	public void SupplierNameQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;

		//Search By Supplier Name
		String searchType =dataMap.get("SearchType");
		String expSuppName=dataMap.get("SearchValue");
		homePage.quickSearch(dataMap);

		waitforPageLoad(suppListPage.contentTitle());
		String contentTitle=suppListPage.contentTitle().getText();
		SoftAssert softAssert=new SoftAssert();

		if(contentTitle.contains(expSuppName)){
			fluentwait(supplierPage.suppNameOnTitle());
			String actSuppName=suppListPage.getSupplier("Supplier").get(0).getText().trim();
			if(actSuppName.contains(expSuppName)){
				flag=true;				
			}
			Reporter.log("Expected Supplier Name:"+expSuppName+"::Actual Supplier Name:"+actSuppName,true);

		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Supplier Name Supplier ID
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="SupplierIDSearch",dataProviderClass=SearchDataProvider.class)
	public void SupplierIDQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		
		boolean flag=false;
		
		//Search By Supplier Id		 
		String searchType =dataMap.get("SearchType");
		String expSuppID=dataMap.get("SearchValue");
		
		homePage.quickSearch(dataMap);
		waitforPageLoad(suppListPage.contentTitle());

		String contentTitle=suppListPage.contentTitle().getText();
		SoftAssert softAssert=new SoftAssert();
		if(contentTitle.contains(expSuppID)){
			String actSuppID=suppListPage.getSupplier(searchType).get(0).getText().trim();
			softAssert.assertEquals(actSuppID, expSuppID);
			Reporter.log("Expected Supplier ID:"+expSuppID+"::Actual Supplier ID:"+actSuppID,true);
			flag=true;
		}
		
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Supplier Phone
	 *  
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="SupplierPhoneSearch",dataProviderClass=SearchDataProvider.class)
	public void SupplierPhoneQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;
		String searchType =dataMap.get("SearchType");
		String expSuppPhone=dataMap.get("SearchValue");
		SoftAssert softAssert=new SoftAssert();
		
		//Search By Supplier Phone

		homePage.quickSearch(dataMap);
		waitforPageLoad(suppListPage.contentTitle());
		String contentTitle=suppListPage.contentTitle().getText();
		
		if(contentTitle.contains(expSuppPhone)){		
			String actSuppPhone=suppListPage.getSupplier("Supplier Vitals").get(0).getText().trim();
			if(actSuppPhone.contains(expSuppPhone))
				flag=true;
			Reporter.log("Expected Supplier Phone:"+expSuppPhone+"::Actual Supplier Phone:"+actSuppPhone,true);
			
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Supplier Email
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="SupplierEmailSearch",dataProviderClass=SearchDataProvider.class)
	public void SupplierEmailQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		String searchType =dataMap.get("SearchType");
		String expSuppEmail=dataMap.get("SearchValue");
		
		//Search By Supplier EmailId
		homePage.quickSearch(dataMap);
		waitforPageLoad(suppListPage.contentTitle());
		String contentTitle=suppListPage.contentTitle().getText();
		
		if(contentTitle.contains(expSuppEmail)){
			String actSuppEmail=suppListPage.getSupplier("Supplier Vitals").get(0).getText().trim();
			if(actSuppEmail.contains(expSuppEmail))
				flag=true;
			Reporter.log("Expected Supplier Email:"+expSuppEmail+"::Actual Supplier Email:"+actSuppEmail,true);
			
		}
		
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Supplier Fax
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="SupplierFaxSearch",dataProviderClass=SearchDataProvider.class)
	public void SupplierFaxQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		String searchType =dataMap.get("SearchType");
		String expSuppFax=dataMap.get("SearchValue");

		//Search By Supplier Fax
		homePage.quickSearch(dataMap);
		waitforPageLoad(suppListPage.contentTitle());
		String contentTitle=suppListPage.contentTitle().getText();
		
		if(contentTitle.contains(expSuppFax)){
			String actSuppFax=suppListPage.getSupplier("Supplier Vitals").get(0).getText().trim();
			if(actSuppFax.contains(expSuppFax))
				flag=true;
			Reporter.log("Expected Supplier Fax:"+expSuppFax+"::Actual Supplier Fax:"+actSuppFax,true);
			
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Claim ID
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="ClaimIDSearch",dataProviderClass=SearchDataProvider.class)
	public void ClaimIDQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		String searchType =dataMap.get("SearchType");
		String expClaimId=dataMap.get("SearchValue");

		//Search by Claim Id
		homePage.quickSearch(dataMap);
		waitforPageLoad(claimsPage.claimbyStatus());
		fluentwait(claimsPage.claimbyStatus());
		String contentTitle=claimsPage.claimbyStatus().getText();

		if(contentTitle.contains(expClaimId)){
			String actClaimId=claimsPage.claimId().get(0).getText().trim();
			softAssert.assertEquals(actClaimId, expClaimId);
			Reporter.log("Expected Claim ID:"+expClaimId+"::Actual Claim ID:"+actClaimId,true);
			flag=true;
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Claim Amount
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="ClaimAmntSearch",dataProviderClass=SearchDataProvider.class)
	public void ClaimAmntQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		String searchType =dataMap.get("SearchType");
		String expClaimAmt=dataMap.get("SearchValue");
		
		//Search by Claim Amount
		homePage.quickSearch(dataMap);
		waitforPageLoad(claimsPage.claimbyStatus());
		String contentTitle=claimsPage.claimbyStatus().getText();
		
		if(contentTitle.contains(expClaimAmt)){
		//	expClaimAmt="$"+expClaimAmt;
			String actClaimAmt=claimsPage.claimAmount().get(0).getText().trim();
			softAssert.assertTrue(actClaimAmt.contains(expClaimAmt));
			Reporter.log("Expected Claim Amount:"+expClaimAmt+"::Actual Claim Amount:"+actClaimAmt,true);
			flag=true;
			
		}
	
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}

	/**
	 * Method to test Quick search using Supplier Reference
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="SupplierRefSearch",dataProviderClass=SearchDataProvider.class)
	public void SupplierRefQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
		
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		String searchType =dataMap.get("SearchType");
		String expSuppRef=dataMap.get("SearchValue");
			
		//Search by Supplier Reference
		homePage.quickSearch(dataMap);
		waitforPageLoad(claimsPage.claimbyStatus());
		String contentTitle=claimsPage.claimbyStatus().getText();
		
		if(contentTitle.contains(expSuppRef)){
			String actSuppRef=claimsPage.supplierReference().get(0).getText().trim();
			if(actSuppRef.contains(expSuppRef)){
				flag=true;
			}
			Reporter.log("Expected Supplier Reference:"+expSuppRef+"::Actual Supplier Reference:"+actSuppRef,true);
			
		}
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}
	
	/**
	 * Method to test Quick search using Credit Amount
	 * 
	 * @author girish.n 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test(dataProvider="CreditAmntSearch",dataProviderClass=SearchDataProvider.class)
	public void CreditAmntQuickSearchTest(LinkedHashMap<String,String> dataMap) throws FileNotFoundException, IOException{
	
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		String searchType =dataMap.get("SearchType");
		String expCdtAmt=dataMap.get("SearchValue");
		
		//Search By Credit Amount
		homePage.quickSearch(dataMap);
		waitforPageLoad(suppListPage.contentTitle());	
		String contentTitle=suppListPage.contentTitle().getText();
		
		if(contentTitle.contains(expCdtAmt)){
			expCdtAmt=expCdtAmt+".00";
			String actCdtAmt=suppListPage.getSupplier(searchType).get(0).getText().trim();
			softAssert.assertEquals(actCdtAmt, expCdtAmt);
			Reporter.log("Expected Credit Amount:"+expCdtAmt+"::Actual Credit Amount:"+actCdtAmt,true);
			flag=true;
		}
		
		
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	
	}
	
	@AfterClass
	public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	}
}
