package com.lavante.sim.customer.TestScripts.Compliance.LegalID;

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
public class UATLegalID extends PageInitiator{
	
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
	
	/**Verify Legal ID Options
	 * Verify Search
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void UISearchVerifyLegalOption() throws Exception{	
		
	Reporter.log("Test Started for Supplier Legal ID UI Search at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
	
	lavanteUtils.fluentwait(enobjLegalID.searchbtn());
	System.out.println("All Option Filter Visibility Status:"+enobjLegalID.filterBYALL().isDisplayed());
	Reporter.log("All Option Filter Visibility Status:"+enobjLegalID.filterBYALL().isDisplayed());	
	Assert.assertTrue(enobjLegalID.filterBYALL().isDisplayed(), "All Option Not Available");

	System.out.println("With Legal ID Option Filter Visibility Status:"+enobjLegalID.filterByWithLegalID().isDisplayed());
	Reporter.log("With Legal ID Filter Visibility Status:"+enobjLegalID.filterByWithLegalID().isDisplayed());
	Assert.assertTrue(enobjLegalID.filterByWithLegalID().isDisplayed(), "With Legal ID Option Not Available");

	System.out.println("No Legal ID Filter Visibility Status:"+enobjLegalID.filterByNoLegalID().isDisplayed());
	Reporter.log("No Legal ID Filter Visibility Status:"+enobjLegalID.filterByNoLegalID().isDisplayed());
	Assert.assertTrue(enobjLegalID.filterByNoLegalID().isDisplayed(), "NO Legal ID Option Not Available");

	if(enobjLegalID.ListSupplier().size()>0){
			
			dataMap.put("FilterBY","LegalID");
			enobjLegalID.searchSupplier(dataMap);
			
			System.out.println("AutoValidated Filter Visibility Status:"+enobjLegalID.filterByAutovalid().isDisplayed());
			Reporter.log("AutoValidated Filter Visibility Status:"+enobjLegalID.filterByAutovalid().isDisplayed());	
			softAssert.assertTrue(enobjLegalID.filterByAutovalid().isDisplayed(), "AutoValidated Option Not Available");
				
			System.out.println("Mismatch Filter Visibility Status:"+enobjLegalID.filterByMismatch().isDisplayed());
			Reporter.log("Mismatch Filter Visibility Status:"+enobjLegalID.filterByMismatch().isDisplayed());	
			softAssert.assertTrue(enobjLegalID.filterByMismatch().isDisplayed(), "Mismatch Option Not Available");
			
			System.out.println("Pending Validation Filter Visibility Status:"+enobjLegalID.filterByPendingValidation().isDisplayed());
			Reporter.log("Pending Validation Visibility Status:"+enobjLegalID.filterByPendingValidation().isDisplayed());	
			softAssert.assertTrue(enobjLegalID.filterByPendingValidation().isDisplayed(), "Pending Validation Option Not Available");
			
			System.out.println("Manually Validate Option Filter Visibility Status:"+enobjLegalID.filterByManuallyValidated().isDisplayed());
			Reporter.log("Manually Validate Option Filter Visibility Status:"+enobjLegalID.filterByManuallyValidated().isDisplayed());	
			softAssert.assertTrue(enobjLegalID.filterByManuallyValidated().isDisplayed(), "Manually Validate Option Not Available");

			flag=true;
		}else{
			softAssert.assertTrue(false,"No Supplier in Legal ID Page,Please retest");
		}
	
	softAssert.assertTrue(flag,"Please Re Check");
	softAssert.assertAll();
	
	Reporter.log("Test Ended for Supplier Legal ID UI Verify  :"+currenttime());
	System.out.println("----------Test Ended---for Supplier Legal ID  UI Verify   --------");
}

	/**For EU Unknown Invalid Supplier 
	 * Verify Do you have a VAT Reg Num in Edit Profile
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void DoyouhaveVatCheck() throws Exception{	
		
	Reporter.log("Test Started for VAT Reg Number Check Search at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
	
	lavanteUtils.fluentwait(enobjLegalID.searchtxt());
	
	dataMap.put("SupplierLocation", "EU");
	dataMap.put("FilterBY", "NoLegalID");
	dataMap.put("FilterSub", "Unknown");
	enobjLegalID.searchSupplier(dataMap);

	if(enobjLegalID.ListSupplier().size()>0){
		
	String sup=enobjLegalID.ListSupplier().get(0).getText();
	Reporter.log("Supplier Name:"+sup);
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("Search", "");
	dataMap.put("supplierName",sup);
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);

	dataMap.put("profile", "");
	dataMap.put("editProfile", "");		
	enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

	lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
	lavanteUtils.switchtoFrame(null);
	dataMap.put("tab", "CompanyDetails");
	eneditProfile.selectTab(dataMap);
	
	lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
	lavanteUtils.switchtoFrame(null);
	lavanteUtils.waitForTime(3000);
	lavanteUtils.fluentwait(eneditLegal.businessStructure());
	
	if(eneditLegal.VatRegNum().size()>0){
		softAssert.assertFalse(eneditLegal.VatRegNum().get(0).isSelected(),"YES Verification");
		softAssert.assertFalse(eneditLegal.VatRegNum().get(1).isSelected(),"No Verification");
			flag=true;
	}else{
			flag=false;
			softAssert.assertFalse(true,"VAT Reg Num Not Displayed");
		}
	}else{
			
		}
	
	softAssert.assertAll();
	
	Reporter.log("Test Ended for VAT Reg Number Check  :"+currenttime());
	System.out.println("----------Test Ended---for VAT Reg Number Check --------");
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
	public void USIRSTINErrmsg() throws Exception{	
		
	Reporter.log("Test Started for IRS TIN Reason at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
	
	lavanteUtils.fluentwait(enobjLegalID.searchbtn());
	
	dataMap.put("SupplierLocation", "US");
	dataMap.put("FilterBY", "LegalID");
	dataMap.put("FilterSub", "AutoValidated");
	enobjLegalID.searchSupplier(dataMap);

	if(enobjLegalID.ListSupplier().size()>0){
		
	String sup=enobjLegalID.ListSupplier().get(0).getText();
	String reason=enobjLegalID.ListValidCode().get(0).getText();
	
	System.out.println("For Auto Valid US Supplier,"+sup+",The Validation Reason is :"+reason);
	Reporter.log("For Auto Valid US Supplier,"+sup+",The Validation Reason is :"+reason);
	softAssert.assertTrue(reason.length()>0,"Auto Valid US,TIN Reason Not Available"+reason);
	
	dataMap.clear();
	dataMap.put("FilterSub", "MisMatch");
	enobjLegalID.searchSupplier(dataMap);
	
			if(enobjLegalID.ListSupplier().size()>0){
	
					sup=enobjLegalID.ListSupplier().get(0).getText();
					reason=enobjLegalID.ListValidCode().get(0).getText();
					
					System.out.println("For MisMatch US Supplier,"+sup+",The Validation Reason is :"+reason);
					Reporter.log("For MisMatch US Supplier,"+sup+",The Validation Reason is :"+reason);
					softAssert.assertTrue(reason.length()>0,"MisMatch US ,Tin Valid Reason Not Available"+reason);
					
					/*lavanteUtils.refreshPage();
					
					lavanteUtils.fluentwait(enobjLegalID.searchCount());
					String orgcount=enobjLegalID.searchCount().getText();
					dataMap.clear();
					dataMap.put("ShowInactive", "yes");
					enobjLegalID.searchSupplier(dataMap);
					String actCount=enobjLegalID.searchCount().getText();
					
					System.out.println("Count Match,Expected:"+orgcount+",Actual:"+actCount);
					Reporter.log("Count Match,Expected:"+orgcount+",Actual:"+actCount);
					softAssert.assertNotEquals(actCount, orgcount,"Count Matched,Expected:"+orgcount+",Actual:"+actCount);*/
					flag=true;
					
				}
	
		}else{
			flag=false;
			softAssert.assertFalse(true,"IRS TIN Reason Not Displayed");
		}
	
	
	softAssert.assertAll();
	
	Reporter.log("Test Ended for IRS TIN Reason :"+currenttime());
	System.out.println("----------Test Ended---for IRS TIN Reason --------");
}
	
	/**Create a EU supplier, Enter VAT REg Number
	 * Verify in Legal ID TAB  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider = "InviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void VATREGNUMEU(LinkedHashMap<String,String> dataMap) throws Exception{	
		
	Reporter.log("Test Started for VAT Reg Number Check Search at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log("  Invite New Supplier:");
	dataMap.put("TakeControl", "");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	String supp=s[0];
	
	dataMap.put("tab", "CompanyDetails");
	eneditProfile.selectTab(dataMap);
	
	lavanteUtils.fluentwait(eneditLegal.countryofReg());
	
	dataMap.put("CountryOfReg", "United Kingdom");
	dataMap.put("BusinessName", supp);
	dataMap.put("VAT", "YES");
	dataMap.put("VATNUM", "ANY");
	dataMap.put("euregnumber", "ANY");
	String[] data=eneditLegal.fillLegal(dataMap);
	
	dataMap.put("SaveExit","");
	eneditProfile.formAction(dataMap);
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	enviewSupplier.clickOnSupplier(supp);
		
	//dataMap.remove("maintab");
	//dataMap.put("subtab","Legal");
	//enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enviewSupplier.countryofReg());
	
	String actvat=enviewSupplier.taxIDNum().getText();
	
	System.out.println("VAT Reg Num ,Expected:"+data[1]+",Actual:"+actvat);
	Reporter.log("VAT Reg Num ,Expected:"+data[1]+",Actual:"+actvat);
	softAssert.assertTrue(actvat.contains(data[1]),"VAT Reg Num Not Matched,Expected:"+",Actual:"+actvat);
	
	String actreg=enviewSupplier.LegalregNum().getText();
	System.out.println("Reg Num ,Expected:"+data[0]+",Actual:"+actreg);
	Reporter.log("Reg Num ,Expected:"+data[0]+",Actual:"+actreg);
	softAssert.assertEquals(actreg, data[0],"Reg Num Not Matched,Expected:"+",Actual:"+actreg);
	
	softAssert.assertAll();
	
	Reporter.log("Test Ended for VAT Reg Number Check  :"+currenttime());
	System.out.println("----------Test Ended---for VAT Reg Number Check --------");
}
	
	/**Create a Canada Supplier with BN Number
	 * Verify in View Supplier 
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider = "InviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void BNNumCanada(LinkedHashMap<String,String> dataMap) throws Exception{	
		
	Reporter.log("Test Started for CANADA BN  Number Check Search at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log("  Invite New Supplier:");
	dataMap.put("TakeControl", "");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	String supp=s[0];
	
	
	dataMap.put("tab", "CompanyDetails");
	eneditProfile.selectTab(dataMap);
	
	lavanteUtils.fluentwait(eneditLegal.countryofReg());
	
	dataMap.put("CountryOfReg", "Canada");
	dataMap.put("Province", "Yukon Territory");
	dataMap.put("BusinessName", supp);
	dataMap.put("VAT", "YES");
	dataMap.put("VATNUM", "ANY");
	dataMap.put("TIN", "YES");
	String[] data=eneditLegal.fillLegal(dataMap);
	
	String act=eneditLegal.LabelBusinessIDNum().get(0).getText();
	Reporter.log("Canada,Expected Label, Business Number ,Actual"+act);
	softAssert.assertEquals(act, "Business Number(BN)","BN Num not matched"+act+ "Exp,Business Number(BN)");
	Reporter.log("Canada,Expected Label: Social Insurance Number,Actual"+act);
	act=eneditLegal.LabelBusinessIDNum().get(1).getText();
	softAssert.assertEquals(act, "Social Insurance Number (SIN)","SIN Num not matched,"+act+ "Exp,Social Insurance Number (SIN) ");
	 
	
	dataMap.put("SaveExit","");
	eneditProfile.formAction(dataMap);
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	enviewSupplier.clickOnSupplier(supp);
		
	//dataMap.remove("maintab");
	//dataMap.put("subtab","Legal");
	//enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enviewSupplier.countryofReg());
	
	String actvat=enviewSupplier.taxIDNum().getText();
	
	System.out.println("CANADA BN Num ,Expected:"+data[1]+",Actual:"+actvat);
	Reporter.log("CANADA BN Num ,Expected:"+data[1]+",Actual:"+actvat);
	softAssert.assertTrue(actvat.contains(data[1]),"CANADA BN Num Not Matched,Expected:"+",Actual:"+actvat);
	
	softAssert.assertAll();
	
	Reporter.log("Test Ended for CANADA BN  Reg Number Check  :"+currenttime());
	System.out.println("----------Test Ended---for CANADA BN  Number Check --------");
}
	
	/**Create a US Supplier with EU Income and EU VAT Num
	 * Verify in View Supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider = "InviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void USSupplierEUincomeVATNum(LinkedHashMap<String,String> dataMap) throws Exception{	
		
	Reporter.log("Test Started for US Supplier VAT Num Search at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();

	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log("  Invite New Supplier:");
	dataMap.put("TakeControl", "");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	String supp=s[0];
	
	dataMap.put("tab", "CompanyDetails");
	eneditProfile.selectTab(dataMap);
	
	lavanteUtils.fluentwait(eneditLegal.countryofReg());
	
	dataMap.put("CountryOfReg", "United States");
	dataMap.put("BusinessName", supp);
	dataMap.put("TIN", "YES");
	dataMap.put("TINNum", "ANY");
	dataMap.put("EUIncome", "YES");
	dataMap.put("EUbusinessName", supp);
	dataMap.put("EUCountry", "Sweden");	
	dataMap.put("VATNUM", "ANY");
	String[] data=eneditLegal.fillLegal(dataMap);
	
	dataMap.put("SaveExit","");
	eneditProfile.formAction(dataMap);
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	enviewSupplier.clickOnSupplier(supp);
		
//	dataMap.remove("maintab");
//	dataMap.put("subtab","Legal");
//	enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enviewSupplier.countryofReg());
	
	String actvat=enviewSupplier.EINNUM().getText();
	
	System.out.println("US Supplier VAT Num ,Expected:"+data[3]+",Actual:"+actvat);
	Reporter.log("US Supplier VAT Num ,Expected:"+data[3]+",Actual:"+actvat);
	softAssert.assertTrue(actvat.contains(data[3]),"US Supplier VAT Num Not Matched,Expected:"+",Actual:"+actvat);
	
	softAssert.assertAll();
	
	Reporter.log("Test Ended for US Supplier VAT Num Check  :"+currenttime());
	System.out.println("----------Test Ended---for US Supplier VAT Num Check --------");
}
	
	/**
	 * "Disable VAT Validation" via DB 
	 * Create a EU supplier
	 * Verify in Pending Valiadtion state in Legal ID Tab
	 * 
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider = "InviteNwSup", dataProviderClass = SupplierRegistrationDataProvider.class)
	public void DisableVAT(LinkedHashMap<String,String> dataMap) throws Exception{	
		
	Reporter.log("Test Started for Disable VAT at:"+currenttime());
	SoftAssert softAssert=new SoftAssert();
	boolean flag=false;
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	String query="select CustomerPropertyID from CustomerPropertyValue where CustomerID="+customerid+" and CustomerPropertyID=9";
	query=lavanteUtils.fetchDBdata(query);
	if(query==null){
		query="Insert into CustomerPropertyValue  (CustomerPropertyID  ,CustomerID  ,PropertyValue,  IsActive) VALUES (   9  ,"+customerid+"  ,'true' ,'1' ) ";
		lavanteUtils.UpdateDB(query);
	}
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	Reporter.log("  Invite New Supplier:");
	dataMap.put("TakeControl", "");
	dataMap.put("invite", "");
	String[] s=enobjInvitenewSupplier.inviteNwSupp(dataMap);
	String supp=s[0];
	
	dataMap.put("tab", "CompanyDetails");
	eneditProfile.selectTab(dataMap);
	
	lavanteUtils.fluentwait(eneditLegal.countryofReg());
	
	dataMap.put("CountryOfReg", "United Kingdom");
	dataMap.put("BusinessName", supp);
	dataMap.put("VAT", "YES");
	dataMap.put("VATNUM", "ANY");
	dataMap.put("euregnumber", "ANY");
	eneditLegal.fillLegal(dataMap);
	
	dataMap.put("SaveExit","");
	eneditProfile.formAction(dataMap);
	
	dataMap.put("subtab","customerSupplierLegalID");
	enobjhomePage.selectTab(dataMap);

	dataMap.put("SupplierLocation","EU");
	dataMap.put("supplierName", supp);
	enobjLegalID.searchSupplier(dataMap);
	
	if(enobjLegalID.ListSupplier().size()>0){
		
		String actsup=enobjLegalID.ListProfstatus().get(0).getText();
		String status="Pending Validation";
		System.out.println("Supplier Status, expected,Pending Validation,Actuals:"+actsup);
		Reporter.log("Supplier Status, expected,Pending Validation,Actuals:"+actsup);
		softAssert.assertEquals(actsup, status,"Supp Status Not matched");
		
		flag=true;
	}else{
		flag=false;
		softAssert.assertFalse(true,"Search of Supplier not shown in Legal ID Page,Please retest");
	}
	
	softAssert.assertAll();
	
	query="delete from CustomerPropertyValue where CustomerPropertyID=9 and CustomerID="+customerid;
	lavanteUtils.UpdateDB(query);
	
	
	Reporter.log("Test Ended for Disable VAT  Check  :"+currenttime());
	System.out.println("----------Test Ended---for Disable VAT  Check --------");
}
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		enobjInvitenewSupplier.cancel();
		enobjhomePage.backtoSearch();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		enobjhomePage.popupclose();	
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

