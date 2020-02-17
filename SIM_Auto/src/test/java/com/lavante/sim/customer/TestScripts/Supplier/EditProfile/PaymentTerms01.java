package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;
/**
 * Created on 16-12-2015
 * Created for Payment Test
 * Ended on 24-12-2016
 * @author Piramanayagam.S
 *
 */
public class PaymentTerms01 extends PageInitiator {
	
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
		List listofdatafrm=lavanteUtils.login("Profile", browser);
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
		
		dataMap.put("Search", "");
		dataMap.put("supplierName", supname);
		enobjsupplierBasicSearch.search(dataMap);	

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
	}
	
	/**SIM-7284
	 * Verify Payment Terms is dependent of Payment Type in Edit Profile page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void UIEditDepndentPayMentTermsOrder() throws Exception{	
		Reporter.log("Test Started for Validate PayMentTerms in Edit Profile at :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		
		//To Set all the values to Some order
		String creditName="AutoSP"+randomnum()+customerID;
		String checkname="AutoSP1"+randomnum()+customerID;
		String EFTName="AutoSP2"+randomnum()+customerID;

		String crediti18="Insert into I18NKey  (i18nKey) values ('"+creditName+"')";
		String chki18="Insert into I18NKey  (i18nKey) values ('"+checkname+"')";
		String efti18="Insert into I18NKey  (i18nKey) values ('"+EFTName+"')";

		lavanteUtils.UpdateDB(crediti18);
		lavanteUtils.UpdateDB(chki18);
		lavanteUtils.UpdateDB(efti18);
		
		String uteft="Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific  ,UTFString) VALUES ( '"+creditName+"'   ,50 ,0 ,'"+creditName+"')";
		String utcredt="Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific ,UTFString) VALUES ('"+checkname+"'   ,50  ,0,'"+checkname+"')";
		String utchk="Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific ,UTFString) VALUES ('"+EFTName+"'   ,50 ,0,'"+EFTName+"')";

		lavanteUtils.UpdateDB(uteft);
		lavanteUtils.UpdateDB(utcredt);
		lavanteUtils.UpdateDB(utchk);

		String creditUpdate="Insert into PaymentTerms ( CustomerID  ,PaymentTypeID  ,PaymentName  ,PaymentName_i18nKey  ,TargetPage_KVID  ,DisplayOrder)"
				+ " VALUES ("+customerID+",1   ,'"+creditName+"'   ,'"+creditName+"'  ,1131    ,5 )";

		String checkupdate="Insert into PaymentTerms ( CustomerID  ,PaymentTypeID  ,PaymentName  ,PaymentName_i18nKey  ,TargetPage_KVID  ,DisplayOrder) "
				+ "VALUES ( "+customerID+"  ,11   ,'"+checkname+"'   ,'"+checkname+"'  ,1131    ,5 )";

		String EFTupdate="Insert into PaymentTerms ( CustomerID  ,PaymentTypeID  ,PaymentName  ,PaymentName_i18nKey  ,TargetPage_KVID  ,DisplayOrder) "
				+ "VALUES ("+customerID+"  ,21   ,'"+EFTName+"'   ,'"+EFTName+"'  ,1131    ,5 )";

		lavanteUtils.UpdateDB(creditUpdate);
		lavanteUtils.UpdateDB(checkupdate);
		lavanteUtils.UpdateDB(EFTupdate);
		
		Reporter.log("Inserted into DB:");
		Reporter.log("EFT Name:"+EFTName);
		Reporter.log("Credit Name:"+creditName);
		Reporter.log("Check Name:"+checkname);
		
		dataMap.put("tab", "Treasury");
		eneditProfile.selectTab(dataMap);
		String appterms=null;
		dataMap.clear();
		
		dataMap.put("paymentTypeSupport", "Check");
		dataMap.put("checkpaymentType", checkname);
		eneditPayment.fillPayMentInfo(dataMap);
		
		appterms=eneditPayment.CHKpaymentermslabel().getText();
		Reporter.log("Check Name,Expected:"+checkname+",In App:"+appterms);
		softassert.assertEquals(appterms,checkname,"Check not matched");

		dataMap.clear();
		dataMap.put("paymentTypeSupport", "EFT (Electronic Fund Transfer)");
		dataMap.put("eftpaymentType", EFTName);
		eneditPayment.fillPayMentInfo(dataMap);
		
		appterms=eneditPayment.eftpaymentermlabel().getText();
		Reporter.log("Eft Terms,Expected:"+EFTName+",In App:"+appterms);
		softassert.assertEquals(appterms,EFTName,"EFT not matched");
		
		dataMap.clear();
		dataMap.put("paymentTypeSupport", "Credit Card");
		dataMap.put("creditpaymentType", creditName);
		eneditPayment.fillPayMentInfo(dataMap);
		
		appterms=eneditPayment.creditpaymentermslabel().getText();
		Reporter.log("Credit Terms,Expected:"+creditName+",In App:"+appterms);
		softassert.assertEquals(appterms,creditName,"Credit Not Matched");
	
		
		String query10= "Delete from PaymentTerms where PaymentName_i18nKey like '%"+EFTName+"%'";
		
		String query11="Delete from UserTranslation where i18nKey like '%"+EFTName+"%'";
				
		String query12="Delete from I18NKey where i18nKey like '%"+EFTName+"%'";
		
		
		lavanteUtils.UpdateDB(query10);
		lavanteUtils.UpdateDB(query11);
		lavanteUtils.UpdateDB(query12);
		
		query10= "Delete from PaymentTerms where PaymentName_i18nKey like '%"+creditName+"%'";
		
		 query11="Delete from UserTranslation where i18nKey like '%"+creditName+"%'";
				
		 query12="Delete from I18NKey where i18nKey like '%"+creditName+"%'";
		
		
		 lavanteUtils.UpdateDB(query10);
		lavanteUtils.UpdateDB(query11);
		lavanteUtils.UpdateDB(query12);
		
		query10= "Delete from PaymentTerms where PaymentName_i18nKey like '%"+checkname+"%'";
		
		 query11="Delete from UserTranslation where i18nKey like '%"+checkname+"%'";
				
		 query12="Delete from I18NKey where i18nKey like '%"+checkname+"%'";
		
		
		 lavanteUtils.UpdateDB(query10);
		 lavanteUtils.UpdateDB(query11);
		 lavanteUtils.UpdateDB(query12);
		
		Reporter.log("Deleted Added DB Records");
		
		
		
	
		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**SIM-7284
	 * Verify Payment Terms is dependent of Payment Type in Edit Profile page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void UIEditInDepndntPayMentTermsOrder() throws Exception{	
		System.out.println("------------Test Started for Validate PayMentTerms in Edit Profile-------------------");
		Reporter.log("Test Started for Validate PayMentTerms in Edit Profile at :"+LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		//To Set all the values to Some order

		String  x="AutoSP";
		String creditName=x+LavanteUtils.randomnum()+customerID;
		String checkname="1"+x+LavanteUtils.randomnum()+customerID;
		String EFTName="2"+x+LavanteUtils.randomnum()+customerID;

		String crediti18="Insert into I18NKey  (i18nKey) values ('"+creditName+"')";
		String chki18="Insert into I18NKey  (i18nKey) values ('"+checkname+"')";
		String efti18="Insert into I18NKey  (i18nKey) values ('"+EFTName+"')";

		lavanteUtils.UpdateDB(crediti18);
		lavanteUtils.UpdateDB(chki18);
		lavanteUtils.UpdateDB(efti18);
		
		String uteft="Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific  ,UTFString) VALUES ( '"+creditName+"'   ,50 ,0 ,'"+creditName+"')";
		String utcredt="Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific ,UTFString) VALUES ('"+checkname+"'   ,50  ,0,'"+checkname+"')";
		String utchk="Insert into UserTranslation (   i18nKey  ,LanguageID ,IsCustomerSpecific ,UTFString) VALUES ('"+EFTName+"'   ,50 ,0,'"+EFTName+"')";

		lavanteUtils.UpdateDB(uteft);
		lavanteUtils.UpdateDB(utcredt);
		lavanteUtils.UpdateDB(utchk);

		String creditUpdate="Insert into PaymentTerms ( CustomerID  ,PaymentTypeID  ,PaymentName  ,PaymentName_i18nKey  ,TargetPage_KVID  ,DisplayOrder)"
				+ " VALUES ( "+customerID+" ,1   ,'"+creditName+"'   ,'"+creditName+"'  ,1131    ,5 )";

		String checkupdate="Insert into PaymentTerms ( CustomerID  ,PaymentTypeID  ,PaymentName  ,PaymentName_i18nKey  ,TargetPage_KVID  ,DisplayOrder) "
				+ "VALUES ( "+customerID+"  ,11   ,'"+checkname+"'   ,'"+checkname+"'  ,1131    ,5 )";

		String EFTupdate="Insert into PaymentTerms ( CustomerID  ,PaymentTypeID  ,PaymentName  ,PaymentName_i18nKey  ,TargetPage_KVID  ,DisplayOrder) "
				+ "VALUES ( "+customerID+"  ,21   ,'"+EFTName+"'   ,'"+EFTName+"'  ,1131    ,5 )";

		lavanteUtils.UpdateDB(creditUpdate);
		lavanteUtils.UpdateDB(checkupdate);
		lavanteUtils.UpdateDB(EFTupdate);
		
		Reporter.log("Inserted into DB:");
		Reporter.log("EFT Name:"+EFTName);
		Reporter.log("Credit Name:"+creditName);
		Reporter.log("Check Name:"+checkname);
		
		dataMap.put("tab", "Treasury");
		eneditProfile.selectTab(dataMap);
		
		String appterms=null;

		dataMap.clear();
		
		dataMap.put("paymentTypeSupport", "Check");
		dataMap.put("checkpaymentType", EFTName);
		eneditPayment.fillPayMentInfo(dataMap);
		
		appterms=eneditPayment.CHKpaymentermslabel().getText();
		Reporter.log("Check Terms Not Match,Expected:"+checkname+",In App:"+appterms);
		softassert.assertNotEquals(appterms,checkname,"EFTName available in Check Terms Matched");
	
		dataMap.put("checkpaymentType", creditName);
		eneditPayment.fillPayMentInfo(dataMap);
		
		appterms=eneditPayment.CHKpaymentermslabel().getText();
		Reporter.log("Check Terms Not Match,Expected:"+checkname+",In App:"+appterms);
		softassert.assertNotEquals(appterms,checkname,"Credit available in  Check matched");
	
		dataMap.put("checkpaymentType", checkname);
		eneditPayment.fillPayMentInfo(dataMap);
		
		appterms=eneditPayment.CHKpaymentermslabel().getText();
		softassert.assertEquals(appterms,checkname);
		Reporter.log("Check Terms Match,Expected:"+checkname+",In App:"+appterms);
		softassert.assertEquals(appterms,checkname,"Check available in  Check not matched");
			
		String query10= "Delete from PaymentTerms where PaymentName_i18nKey like '%"+creditName+"%'";
		
		String query11="Delete from UserTranslation where i18nKey like '%"+creditName+"%'";
				
		String query12="Delete from I18NKey where i18nKey like '%"+creditName+"%'";

		
		lavanteUtils.UpdateDB(query10);
		lavanteUtils.UpdateDB(query11);
		lavanteUtils.UpdateDB(query12);
		
		 query10= "Delete from PaymentTerms where PaymentName_i18nKey like '%"+EFTName+"%'";
		
		 query11="Delete from UserTranslation where i18nKey like '%"+EFTName+"%'";
				
		 query12="Delete from I18NKey where i18nKey like '%"+EFTName+"%'";
		
		
		 lavanteUtils.UpdateDB(query10);
		 lavanteUtils.UpdateDB(query11);
		 lavanteUtils.UpdateDB(query12);
		
		query10= "Delete from PaymentTerms where PaymentName_i18nKey like '%"+checkname+"%'";
		
		 query11="Delete from UserTranslation where i18nKey like '%"+checkname+"%'";
				
		 query12="Delete from I18NKey where i18nKey like '%"+checkname+"%'";
		
		
		 lavanteUtils.UpdateDB(query10);
		 lavanteUtils.UpdateDB(query11);
		 lavanteUtils.UpdateDB(query12);
		
		Reporter.log("Deleted Added DB Records");
		
		
		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:"+LavanteUtils.currenttime());
	
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

