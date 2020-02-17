package com.lavante.recovery.TestScripts.UAT;

import java.util.LinkedHashMap;
import java.util.List;

import lavante.recovery.utilities.Report;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.DataProvider.CheckRegisterDataProvider;
import com.lavante.recovery.pageobjects.pageInitiator;
import com.lavante.recovery.pageobjects.Invoice.InvoicePage;

import org.eclipse.jetty.io.FillInterest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author Ramya.Raj
 *
 */
public class Invoice extends pageInitiator {

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

		waitForTime(3000);

		//homePage.SelectAudit("ANY");

		waitForTime(3000);
		
		homePage.verifyHomePageDisplayed();
		
		}
	

	@Test
	public void Invoice() throws InterruptedException{
		SoftAssert softAssert = new SoftAssert();
		
		invoicePage.invoicesLink().click();
		LinkedHashMap<String, String> dataMap1 = new LinkedHashMap<String, String>();
		dataMap1.put("invoiceNumber","08/09/17*LP10091" );
		waitForTime(6000);
		
		invoicePage.InvoiceFilling(dataMap1);
		waitForTime(6000);
		
		//Verifying Supplier details:
		
		String eSupplier = "Noor";
		String aSupplier = invoicePage.supplierD().getAttribute("innerText");
		softAssert.assertEquals(aSupplier, eSupplier);
		System.out.println(aSupplier);
		
		String eSupplierId = "53982";
	    String aSupplierId = invoicePage.supplierIdD().getText();
	    softAssert.assertEquals(aSupplierId, eSupplierId);
	    
	    String eComments = "Process";
	    String aComments = invoicePage.commentsD().getAttribute("innerText");
	    softAssert.assertEquals(aComments, eComments);
	    
	    String eOrganization = "BAU";
	    String aOrganization = invoicePage.organzationD().getAttribute("innerText");
	    softAssert.assertEquals(aOrganization, eOrganization);
	    
	    String eClaimId = "LP2720001";
	    String aClaimId = invoicePage.claimIdD().getAttribute("innerText");
	    softAssert.assertEquals(aClaimId, eClaimId);
	    
	    String eReference = "15";
	    String aReference = invoicePage.reference().getAttribute("innerText");
	    softAssert.assertEquals(aReference, eReference);
	    
	    String eCreditDate = "02/02/2017";
	    String aCReditDate = invoicePage.creditDateD().getAttribute("innerText");
	    softAssert.assertEquals(aCReditDate, eCreditDate);
	    
	    String sEAmount = "$50.00";
	    String SAAmount = invoicePage.amountD().getAttribute("innerText");
	    softAssert.assertEquals(SAAmount, sEAmount);
	    
	    String eCurrency = "ARS";
	    String aCurrency = invoicePage.currencyD().getAttribute("innerText");
	    softAssert.assertEquals(aCurrency, eCurrency);
	    
	    String expCurrency1 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency1 = invoicePage.totalFoindingsForPCrncy().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency1, expCurrency1);
	    
	    String expCurrency2 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency2 = invoicePage.totalLessRefundsCrncy().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency2, expCurrency2);
	    
	    String expCurrency3 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency3 = invoicePage.totalLessVoids().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency3, expCurrency3);
	    
	    String expCurrency4 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency4 = invoicePage.netFindingsCrncy().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency4, expCurrency4);
	    
	    String expCurrency5 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency5 = invoicePage.rateCrncy().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency5, expCurrency5);
	    
	    String expCurrency6 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency6 = invoicePage.amountCrncy().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency6, expCurrency6);
	    
	    String expCurrency7 = invoicePage.usdLink().getAttribute("innerText");
	    String actCurrency7 = invoicePage.amountCrncy().getAttribute("innerText");
	    softAssert.assertEquals(actCurrency7, expCurrency7);
	    
	    invoicePage.creditLink().isDisplayed();
	    invoicePage.voidLink().isDisplayed();
	    invoicePage.refundLink.isDisplayed();
	    
	    
	    
	}
	    /**
		 * After Class Logout and Quit Method 
		 * 
		 * @author Ramya.Raj
		 */
		
		@AfterClass
		  public void QuitBrowser() {
			  homePage.logout();
			  quitBrowser();
		  }
		
	
		
	}



