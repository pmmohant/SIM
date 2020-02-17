package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

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
 * Created on 14-5-2016
 * Created for Edit Profile NAICS Test case
 * Ended on 16-5-2016
 * @author Piramanayagam.S
 *
 */
public class CompanyNAICS02 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
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
		List<?> listofdatafrm=lavanteUtils.login("Profile", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		lavanteUtils.switchtoFrame(null);
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
	}
	
	/**Save NAICS Functionality
	 * Add Primary NAICS 
	 *  Verify->Add Multiple NAICS on Primary
	 *  Verify->Add Duplicate NAICS on Secondary
	 *  Verify->Add Multiple NAICS on Secondary
	 * 	Verify in View Supplier
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void SaveNAICS() throws Exception{	
		Reporter.log("Test Started for Save NAICS Profile at :"+currenttime());
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		dataMap.put("ProfStatus","Approved");//#Enterprise
		dataMap.put("Tab","Legal");
		ensupplierAdvanced.buildQuery(dataMap);	

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		String supname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		String delteNAics=supname;
		delteNAics="delete from ServicesOrMaterialsClassification where LavanteUID in (Select LavanteUID from Supplier where SupplierName='"+delteNAics+"')";
		lavanteUtils.UpdateDB(delteNAics);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.Scrollintoview(eneditCompanyProfile.primaryNaicsCode());
		
		String expPrimaryHeaderNAICS="Agriculture, Forestry, Fishing and Hunting#Crop Production#Oilseed and Grain Farming#Soybean Farming";
		String expPrimaryNAICSchild="Soybean farming, field and seed production";
		dataMap.put("ParentNAICS",expPrimaryHeaderNAICS);
		dataMap.put("ChildNAICS",expPrimaryNAICSchild);
		
		SoftAssert softAssert=new SoftAssert();
		dataMap.put("supplierName",supname);
		dataMap.put("SaveNAICS","");
		dataMap.put("CountNAICS","1");
		eneditCompanyProfile.createPrimaryNaics(dataMap);
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);

		String actMsg="";
		actMsg=eneditCompanyProfile.primaryNaicsCode().getAttribute("disabled");
		String expMSg="true";
		
		System.out.println("Primary NAICS Code button Status,Exp:"+expMSg+",Actuals:"+actMsg);
		softAssert.assertEquals(actMsg,expMSg,"Primary NAICS code after adding NAICS Not disabled");
		
		dataMap.remove("DeleteNAICS");
		eneditCompanyProfile.createSecondaryNaics(dataMap);
		
		lavanteUtils.switchtoFrame(eneditCompanyProfile.iframeNAICS());
		lavanteUtils.switchtoFrame(null);
		actMsg=eneditCompanyProfile.dialogmsg().getText();
		expMSg="Duplicate NAICS Code";
		System.out.println("Primary NAICS Code,Exp:"+expMSg+",Actuals:"+actMsg);
		softAssert.assertEquals(actMsg,expMSg,"Msg Not Matched");
		lavanteUtils.switchtoFrame(eneditCompanyProfile.iframeNAICS());
		lavanteUtils.click(eneditCompanyProfile.cancelbtn());
		lavanteUtils.switchtoFrame(null);

		dataMap.clear();
		dataMap.put("SaveNAICS","");
		//Splitter String in #
		expPrimaryHeaderNAICS="Agriculture, Forestry, Fishing and Hunting#Crop Production#Oilseed and Grain Farming#Dry Pea and Bean Farming#Wheat Farming";
		String expSecNAICSchild="Pea farming, dry, field and seed production#Cowpea farming, dry, field and seed production";
		dataMap.put("ParentNAICS",expPrimaryHeaderNAICS);
		dataMap.put("ChildNAICS",expSecNAICSchild);
		dataMap.put("CountNAICS","2");
		eneditCompanyProfile.createSecondaryNaics(dataMap);
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		
		dataMap.put("SaveExit","");
		eneditProfile.formAction(dataMap);
		lavanteUtils.waitForTime(4000);
		
		lavanteUtils.waitforPageload(enobjsupplierBasicSearch.searchbtn());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(supname);
		
		String query="select NAICS12 From NAICS where Description='"+expPrimaryNAICSchild+"'";
		query=lavanteUtils.fetchDBdata(query);
		
		//Wait for page to load
		enviewSupplier.selectTab(dataMap);
		
		lavanteUtils.Scrollintoview(enviewSupplier.primaryNAICScode());
		lavanteUtils.fluentwait(enviewSupplier.supplierName());
		String actual=enviewSupplier.primaryNAICScode().getText();
		
		Reporter.log("NAICS CODE, Expected:"+query+",Actuals:"+actual);
		System.out.println("NAICS CODE, Expected:"+query+",Actuals:"+actual);
		softAssert.assertEquals(actual, query,"Primary NAICS CODE, Expected:"+query+",Actuals:"+actual);
		
		actual=enviewSupplier.primaryNAICSdesc().getText();

		Reporter.log("NAICS Desc, Expected:"+expPrimaryNAICSchild+",Actuals:"+actual);
		System.out.println("NAICS Desc, Expected:"+expPrimaryNAICSchild+",Actuals:"+actual);
		softAssert.assertEquals(actual,expPrimaryNAICSchild, "Primary NAICS Desc, Expected:"+expPrimaryNAICSchild+",Actuals:"+actual);
		
		String[] splitexpNaics=new String[10];
		String expCode="";
		int j=0;
		if(expSecNAICSchild.contains("#")){
			splitexpNaics=expSecNAICSchild.split("#");
			for(j=0;j<splitexpNaics.length;j++){
				query="select NAICS12 From NAICS where Description='"+splitexpNaics[j]+"'";
				expCode=expCode+lavanteUtils.fetchDBdata(query)+"#";
			}
		}
		
		for(int i=0;i<enviewSupplier.secondaryNAICScode().size();i++){
		
			actual=enviewSupplier.secondaryNAICScode().get(i).getText();
			
			Reporter.log("NAICS CODE, Expected:"+expCode+",Actuals:"+actual);
			System.out.println("NAICS CODE, Expected:"+expCode+",Actuals:"+actual);
			softAssert.assertTrue(expCode.contains(actual),"Secondary NAICS CODE, Expected:"+expCode+",Actuals:"+actual);
			
			actual=enviewSupplier.secondaryNAICSdesc().get(i).getText();
	
			Reporter.log("NAICS Desc, Expected:"+expSecNAICSchild+",Actuals:"+actual);
			System.out.println("NAICS Desc, Expected:"+expSecNAICSchild+",Actuals:"+actual);
			softAssert.assertTrue(expSecNAICSchild.contains(actual), "Secondary NAICS Desc, Expected:"+expSecNAICSchild+",Actuals:"+actual);
		}
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Save NAICS at:"+currenttime());

	}
	
	/**Save NAICS Functionality
	 * Add Primary NAICS 
	 *  Verify->Add Multiple NAICS on Primary
	 *  Verify->Add Duplicate NAICS on Secondary
	 *  Verify->Add Multiple NAICS on Secondary
	 * 	Verify in View Supplier
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void SearchNAICS() throws Exception{	
		Reporter.log("Test Started for Save NAICS Profile at :"+currenttime());
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		dataMap.put("ProfStatus","Approved");//#Enterprise
		dataMap.put("Tab","Legal");
		ensupplierAdvanced.buildQuery(dataMap);	

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		String supname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		String delteNAics=supname;
		delteNAics="delete from ServicesOrMaterialsClassification where LavanteUID in (Select LavanteUID from Supplier where SupplierName='"+delteNAics+"')";
		lavanteUtils.UpdateDB(delteNAics);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.Scrollintoview(eneditCompanyProfile.primaryNaicsCode());
		
		String query="SELECT Top 1 NAICS12 FROM NAICS where IsActive=1  ORDER BY newid() ";
		query=lavanteUtils.fetchDBdata(query);
		
		lavanteUtils.click(eneditCompanyProfile.primaryNaicsCode());
		
		dataMap.put("SearchKey", query);
		dataMap.put("Search", query);
		eneditCompanyProfile.SearchNAICS(dataMap);
		SoftAssert softAssert =new SoftAssert();
		for (int j = 0; j < eneditCompanyProfile.HeaderChildNAICS().size(); j++) {
			String childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			if(childheader.length()>0){
				Reporter.log("Naics Code ,Expected:"+query+",Actuals:"+childheader,true);
				softAssert.assertTrue(childheader.contains(query),"NAICS Code Not Matched");
			}
		}
		
		query="SELECT Top 1 Description FROM NAICS where IsActive=1  ORDER BY newid() ";
		query=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("SearchKey", query);
		dataMap.put("Search", query);
		eneditCompanyProfile.SearchNAICS(dataMap);
		
		for (int j = 0; j < eneditCompanyProfile.HeaderChildNAICS().size(); j++) {
			String childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			if(childheader.length()>0){
				Reporter.log("Naics Desc,Expected:"+query+",Actuals:"+childheader,true);
				softAssert.assertTrue(childheader.contains(query),"NAICS Desc Not Matched");
			}
		}
		
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Save NAICS at:"+currenttime());

	}
	
	/**
	 * Search UNSPSC 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void SearchUNSPSC() throws Exception{	
		Reporter.log("Test Started for Search UNSPSC  Profile at :"+currenttime());
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("RegCountry", "Equals To,United States");
		dataMap.put("Search", "");
		dataMap.put("ProfStatus","Approved");//#Enterprise
		dataMap.put("Tab","Legal");
		ensupplierAdvanced.buildQuery(dataMap);	

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		String supname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		String delteNAics=supname;
		delteNAics="delete from ServicesOrMaterialsClassification where LavanteUID in (Select LavanteUID from Supplier where SupplierName='"+delteNAics+"')";
		lavanteUtils.UpdateDB(delteNAics);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.Scrollintoview(eneditCompanyProfile.primaryNaicsCode());
		
		String query="SELECT Top 1 UNSPSCClassCode From UNSPSCClass  where IsActive=1  ORDER BY newid() ";
		query=lavanteUtils.fetchDBdata(query);
		
		lavanteUtils.click(eneditCompanyProfile.addUNSPSCCode());
		
		dataMap.put("SearchKey", query);
		dataMap.put("Search", query);
		eneditCompanyProfile.SearchNAICS(dataMap);
		SoftAssert softAssert =new SoftAssert();
		for (int j = 0; j < eneditCompanyProfile.HeaderChildNAICS().size(); j++) {
			String childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			if(childheader.length()>0){
				Reporter.log("UNSPSC Code ,Expected:"+query+",Actuals:"+childheader,true);
				softAssert.assertTrue(childheader.contains(query),"UNSPSC Code Not Matched");
			}
		}
		
		query="SELECT Top 1 UNSPSCClassTitle From UNSPSCClass  where IsActive=1  ORDER BY newid() ";
		query=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("SearchKey", query);
		dataMap.put("Search", query);
		eneditCompanyProfile.SearchNAICS(dataMap);
		
		for (int j = 0; j < eneditCompanyProfile.HeaderChildNAICS().size(); j++) {
			String childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			if(childheader.length()>0){
				Reporter.log("UNSPSC Desc,Expected:"+query+",Actuals:"+childheader,true);
				softAssert.assertTrue(childheader.contains(query),"UNSPSC Desc Not Matched");
			}
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Search UNSPSC at:"+currenttime());

	}

	/**
	 * Search NACE
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void SearchNACE() throws Exception{	
		Reporter.log("Test Started for Search UNSPSC  Profile at :"+currenttime());
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("RegCountry", "Equals To,United Kingdom");
		dataMap.put("Search", "");
		dataMap.put("ProfStatus","Approved");//#Enterprise
		dataMap.put("Tab","Legal");
		ensupplierAdvanced.buildQuery(dataMap);	

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		String supname=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		String delteNAics=supname;
		delteNAics="delete from ServicesOrMaterialsClassification where LavanteUID in (Select LavanteUID from Supplier where SupplierName='"+delteNAics+"')";
		lavanteUtils.UpdateDB(delteNAics);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.Scrollintoview(eneditCompanyProfile.addUNSPSCCode());
		
		String query="SELECT Top 1 FullCode from NACE   ORDER BY newid() ";
		query=lavanteUtils.fetchDBdata(query);
		
		lavanteUtils.click(eneditCompanyProfile.addUNSPSCCode());
		
		dataMap.put("SearchKey", query);
		dataMap.put("Search", query);
		eneditCompanyProfile.SearchNAICS(dataMap);
		boolean flag=false;
		SoftAssert softAssert =new SoftAssert();
		for (int j = 0; j < eneditCompanyProfile.HeaderChildNAICS().size(); j++) {
			String childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			if(childheader.length()>0){
				Reporter.log("NACE Code ,Expected:"+query+",Actuals:"+childheader,true);
				softAssert.assertTrue(childheader.contains(query),"NACE Code Not Matched");
				flag=true;
			}
		}
		
		softAssert.assertTrue(flag,"NACE Code Not Matched");
		flag=false;
		
		query="SELECT Top 1 Description from NACE  ORDER BY newid() ";
		query=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("SearchKey", query);
		dataMap.put("Search", query);
		eneditCompanyProfile.SearchNAICS(dataMap);
		
		for (int j = 0; j < eneditCompanyProfile.HeaderChildNAICS().size(); j++) {
			String childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			childheader = eneditCompanyProfile.HeaderChildNAICS().get(j).getText().trim();
			if(childheader.length()>0){
				Reporter.log("NACE Desc,Expected:"+query+",Actuals:"+childheader,true);
				softAssert.assertTrue(childheader.contains(query),"NACE Desc Not Matched");
				flag=true;
			}
		}
		
		softAssert.assertTrue(flag,"NACE Code Not Matched");
		flag=false;
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Search UNSPSC at:"+currenttime());

	}
	
	
	@AfterMethod
	public void aftermethod(){
		lavanteUtils.refreshPage();
		enobjhomePage.backtoSearch();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);	
		
	}
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

