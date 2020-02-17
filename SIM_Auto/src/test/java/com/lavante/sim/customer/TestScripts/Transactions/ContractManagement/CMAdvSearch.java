package com.lavante.sim.customer.TestScripts.Transactions.ContractManagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.CMSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;


/**
 * Created on 2-2-2016
 * Created for Contract Management Enhancment Test case
 * Enhancement covered SIM-7327
 * Ended on 15-2-2016
 * @author Piramanayagam.S
 *
 */
public class CMAdvSearch extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> loginDataMap=new LinkedHashMap<String, String>();
	String QNAME="SPAutoQuery";
	String currbrowser="";
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
		currbrowser=browser;
		List listofdatafrm=lavanteUtils.login("CMSearch", browser);
		customerID=(String) listofdatafrm.get(1);
		
		login();
		before();
		delQueryFrmDB("");
	}
	
	public void login() throws IOException, SQLException{

		List listofdatafrm=lavanteUtils.login("CMSearch", currbrowser);
		LinkedHashMap<String,String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		
		enobjloginpage.logintoAPP(LdataMap);
		before();
		
	}
	

	public void before(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		dataMap.put("subtab", "Management");
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
	
	}

	/** 
	 * Verify Adv Search Fields ,
	 * 			SAVE QUERY, in BUILD QUERY PAGE
	 * 			SAVE QUERY, in ADVANCE SEARCH TAB
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test
	public void VerifySaveQrybtnUI001() throws Exception{	
		Reporter.log("Test Started for Adv Search field:"+LavanteUtils.currenttime());
		System.out.println("Verify field");
		SoftAssert softassert=new SoftAssert();
	
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		
		lavanteUtils.fluentwait(encontractManagement.Saveqrybtn());		
		softassert.assertTrue(encontractManagement.Saveqrybtn().isDisplayed(),"Save Query is Not Available in Advance Search page");
		Reporter.log("Verification for SAVE QUERY OPTION IN Advanced Search Page");
		
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);

		lavanteUtils.switchtoFrame(encontractAdvancedSearch.IFRAMEadvSearch());
	
		softassert.assertTrue(encontractAdvancedSearch.buildSaveQuery().isDisplayed(),"Save Query is Not Available in Build Query Tab");		
		Reporter.log("Verification for SAVE QUERY OPTION IN Build Query Page");
		eneditContractManagement.close();
		
		
		softassert.assertAll();
		
		Reporter.log("Test Ended for Adv Search field:"+LavanteUtils.currenttime());
	}

	/** 
	 * Verify SAVE QUERY in Build Query Page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	////////@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public String IssueSaveQueryWhileBuilding002(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for SAVE QUERY:"+LavanteUtils.currenttime());
	
		boolean flag=false;
		QNAME="SPAutoQuery";
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		//Save After Building the query.		
		QNAME=QNAME+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved as:"+QNAME);
		
		SoftAssert softassert=new SoftAssert();
		if(encontractManagement.ListSAVEDQUERYNAME().size()>0){
			lavanteUtils.fluentwait(encontractManagement.ListSAVEDQUERYNAME().get(0));
			for(int i=0;i<encontractManagement.ListSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME"+appq+"is matched in the list");
					softassert.assertEquals(QNAME,appq,"Query Not Available");
					Reporter.log("Query Expected:"+QNAME+",Available in APP:"+appq);
					flag=true;
				}
			}
			
		}
		
		if(flag==false)
		{
			softassert.assertTrue(false,"Query Not Available");
			Reporter.log("Query Not Available");
			
		}
		delQueryFrmDB(QNAME);
		softassert.assertAll();
				
			
		
		Reporter.log("Test Ended----------------");
		return QNAME;
	}

	/**
	 * Verify Adv Search  SAVE QUERY  in Advance Search Tab
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void SAVEQueryAfterBuilding002(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for SAVE QUERY After Building:"+LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		System.out.println("Save after bukilding");
		
		QNAME="SPAutoQuery";
		
		boolean flag=false;
		
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		
		//Save After Building the query.		
		 QNAME=QNAME+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("Search","Search");
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Searched");
					
		dataMap.remove("Search");
		dataMap.remove("Build");				
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.Saveqrybtn());
		lavanteUtils.click(encontractManagement.Saveqrybtn());
		
		encontractAdvancedSearch.SaveQry(dataMap);
			
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.waitForTime(4400);
		
		outr:if(encontractManagement.ListSAVEDQUERYNAME().size()>0){  
			for(int i=0;i<encontractManagement.ListSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME,"+appq+"is matched in the list");
					System.out.println(appq);
					softassert.assertEquals(QNAME.trim(),appq.trim(),"Query Not Available");
					Reporter.log("Query Expected:"+QNAME+",Available in APP:"+appq);
					flag=true;
					break outr;
				}
			}
		}
		
		if(flag==false)
		{
			softassert.assertTrue(false,"Query Not Available");
			Reporter.log("Query Not Available");
			
		}
		delQueryFrmDB(QNAME);
		softassert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());					
		System.out.println("----------Test Ended----------------");
	}

	/** 
	 * Verify SAVE QUERY in Build Query Page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void SAVEQueryWhileBuilding0003(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for SAVE QUERY While Building:"+LavanteUtils.currenttime());
		System.out.println("Save while building");
		
		QNAME="SPAutoQuery";
		boolean flag=false;
		driver.navigate().refresh();
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		//Save After Building the query.		
		 QNAME="SPAutoQuery"+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved"+QNAME);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
		System.out.println(encontractManagement.ListSAVEDQUERYNAME().size());
		SoftAssert softassert=new SoftAssert();
		if(encontractManagement.ListSAVEDQUERYNAME().size()>0){ 
			
			lavanteUtils.fluentwait(encontractManagement.ListSAVEDQUERYNAME().get(0));
			for(int i=0;i<encontractManagement.ListSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					softassert.assertEquals(QNAME.trim(),appq.trim(),"Query Not Available");
					Reporter.log("Query Expected:"+QNAME+",Available in APP:"+appq);
					flag=true;
					delquery(appq);
				}
			}
			
		}
		
		if(flag==false)
		{
			softassert.assertTrue(false,"Query Not Available");
			Reporter.log("Query Not Available");
			
		}
		delQueryFrmDB(QNAME);
		softassert.assertAll();
		Reporter.log("Test Ended at:"+LavanteUtils.currenttime());
		
		System.out.println("----------Test Ended----------------");
		
	}

	/** Verify SAVE QUERY Count & Build Query Count Gives same result 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void BuildCountSaveCount004(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for SAVE Count :"+LavanteUtils.currenttime());
		System.out.println("Build Count");
		
		QNAME="SPAutoQuery";
		boolean flag=false;
		String SavedSearchcount="";
		
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Selected Build Query Option in Advanced Search Tab");
		
		//Save After Building the query.		
		QNAME=QNAME+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved:"+QNAME);
				
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
		
		SoftAssert softassert=new SoftAssert();
		
		lavanteUtils.switchtoFrame(encontractManagement.IFRAMESearchResult());
		String SaveCount1=encontractManagement.SearchCount().getText();
		System.out.println(SaveCount1);
		if(SaveCount1.contains("("))
		{
			String[] das=SaveCount1.split("\\(");
			System.out.println(das[1]);
			String[] dase=das[1].split("\\)");
			System.out.println(dase[0]);
			SavedSearchcount=dase[0];
			Reporter.log("Count After Saving:"+SavedSearchcount+",Available in APP");
			
		}

		
		lavanteUtils.switchtoFrame(null);
		String BuildCount="";
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		
		dataMap.remove("SaveQuery");
		dataMap.remove("SavetheQuery");
		dataMap.remove("SaveQueryName");
		dataMap.put("Search","SPAutoQuery"+LavanteUtils.randomnum());
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Searched");
		
		lavanteUtils.switchtoFrame(encontractManagement.IFRAMESearchResult());
		String SaveCount=encontractManagement.SearchCount().getText();
		System.out.println(SaveCount);
		if(SaveCount.contains("("))
		{
			String[] das=SaveCount.split("\\(");
			System.out.println(das[1]);
			String[] dase=das[1].split("\\)");
			System.out.println(dase[0]);
			BuildCount=dase[0];
			Reporter.log("Count After Searching by Building Query,"+dase[0]+",in APP.");
		}
		
		{
			softassert.assertEquals(BuildCount, SavedSearchcount,"Count Not matched with Build and Saved"+BuildCount+":"+SavedSearchcount);
			Reporter.log("Count by Building:"+BuildCount+",Count By Searching:"+SavedSearchcount);
			
			flag=true;
		}
		if(flag==false)
		{
			softassert.assertTrue(false,"Query Not Available");
			Reporter.log("Query Not Available");
			
		}
		delQueryFrmDB(QNAME);
		softassert.assertAll();				
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}

	/** 
	 * Verify Adv Search SAVE QUERY 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void NewNameforSavedQuery005(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Edit SAVE QUERY new Name:"+LavanteUtils.currenttime());
		
		QNAME="SPAutoQuery";
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
	
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
	
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Selected Buiild Query Option in Advanced Search Tab");
		
		//Save After Building the query.	
		QNAME=QNAME+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved as:"+QNAME);
	
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
		
		if(encontractManagement.ListSAVEDQUERYNAME().size()>0){ 
			
			lavanteUtils.fluentwait(encontractManagement.ListSAVEDQUERYNAME().get(0));
			for(int i=0;i<encontractManagement.ListSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME"+appq+"is matched in the list");
					//Clear All Data
					dataMap.clear();
					lavanteUtils.switchtoFrame(null);
					//For CLicking Build Option
					dataMap.put("Build","Build");
					encontractManagement.SelectSearchOption(dataMap);
					Reporter.log("Select Buiild Query Option in Advanced Search Tab");
					
					dataMap.put("SaveQuery","");
					encontractAdvancedSearch.formAction(dataMap);
					
					String read=encontractAdvancedSearch.SaveQryName().getAttribute("readonly");
					
					if(read.length()>0){
						softassert.assertTrue(true,"Saved Query Name can be Edited");
						Reporter.log("Saved Query Name cannot be Edited with new Name, Because the field is "+read);
						
						dataMap.put("CanceltheSaveQuery","");
						encontractAdvancedSearch.SaveQry(dataMap);
						flag=true;
						
					}
					
				}
			}
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Issue While Saving,Recheck");
		}
		
		delQueryFrmDB(QNAME);
		softassert.assertAll();

		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}

	/** 
	 * Verify  Edit Criteria of SAVE QUERY 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="EditCriteria",dataProviderClass=CMSearchDataProvider.class)
	public void EditCriteriaofSavedQuery006(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Edit SAVE QUERY Criteria------------------");
		Reporter.log("Test Started: "+LavanteUtils.currenttime());
		
		QNAME="SPAutoQuery";
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		//For CLicking Build Option
		dataMap.put("Build","Build");
		
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		//Save After Building the query.	
		QNAME=QNAME+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved as:"+QNAME);
		
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
	
		String Criteria1="";
		String Criteria2="";
		if(encontractManagement.ListSAVEDQUERYNAME().size()>0){ 
			
			lavanteUtils.fluentwait(encontractManagement.ListSAVEDQUERYNAME().get(0));
			for(int i=0;i<encontractManagement.ListSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME,"+appq+",is matched in the list");
					
					lavanteUtils.switchtoFrame(encontractManagement.IFRAMESearchResult());
					String SaveCount=encontractManagement.SearchCount().getText();
					System.out.println(SaveCount);
					if(SaveCount.contains("("))
					{
						String[] das=SaveCount.split("\\(");
						System.out.println(das[1]);
						String[] dase=das[1].split("\\)");
						System.out.println(dase[0]);
						Criteria1=dase[0];
						Reporter.log("Count of First Criteria:"+Criteria1+", in APP");
					}
					System.out.println(dataMap);
					
					Iterator it = dataMap.entrySet().iterator();
				    while (it.hasNext()) {
				        Map.Entry pair = (Map.Entry)it.next();
				        System.out.println(pair.getKey() + " = " + pair.getValue());
				     	String value=(String) pair.getValue();
				     	String key=(String) pair.getKey();
				     	System.out.println(value+key);
				        if(value.contains("Is")){	
				        	System.out.println("VALUE CONTAIN IS");
				        	dataMap.put(key, "Contains");
				        }
				      
				    }
				    
				    dataMap.remove("SaveQuery");
					dataMap.remove("SavetheQuery");
					dataMap.remove("ClearQuery");
					
					lavanteUtils.switchtoFrame(null);
					//For CLicking Build Option
					encontractManagement.SelectSearchOption(dataMap);
					
					//For CLicking Build Option
					dataMap.put("Build","Build");
					encontractManagement.SelectSearchOption(dataMap);
					Reporter.log("Select Buiild Query Option in Advanced Search Tab with new query");
					
					//Save After Building the query.	
					QNAME="SPAutoQuery"+LavanteUtils.randomnum();
					
					
					dataMap.remove("SaveQueryName");
					dataMap.put("SavetheQuery","");
					dataMap.put("SaveQuery","");
					encontractAdvancedSearch.buildquery(dataMap);
		
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.advSearchtab());
					lavanteUtils.switchtoFrame(encontractManagement.IFRAMESearchResult());
					
					String SaveCount2=encontractManagement.SearchCount().getText();
					System.out.println(SaveCount2);
					if(SaveCount2.contains("("))
					{
						String[] das=SaveCount2.split("\\(");
						System.out.println(das[1]);
						String[] dase=das[1].split("\\)");
						System.out.println(dase[0]);
						Criteria2=dase[0];
						Reporter.log("Count of Second Criteria:"+Criteria2+", in APP");
					}
					if(!Criteria2.equalsIgnoreCase(Criteria1)){
						softassert.assertNotEquals(Criteria2,Criteria1,"Both Criteria Matching,Issue with APP or Test Data,Recheck");
						Reporter.log("Edit criteria Verification,Count of Criteria 1:"+Criteria1+",Count of Criteria 2:"+Criteria2);
						flag=true;
					}
					
					
				}
			}
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Issue While Saving,Recheck the Scripts");
		}
		
		
		delquery(QNAME);
		delQueryFrmDB(QNAME);
		softassert.assertAll();
				
		System.out.println("----------Test Ended----------------");
	}

	/**
	 * Verify Delete of SAVE QUERY 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void DeleteSavedQuery007(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Delete SAVEd QUERY ------------------");
		Reporter.log("Test Started for Delete SAVEd QUERY :"+LavanteUtils.currenttime());
		
		QNAME="SPAutoQuery";
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();

		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		//For CLicking Build Option
		dataMap.put("Build","Build");
		
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		//Save After Building the query.	
		QNAME="SPAutoQuery"+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved as:"+QNAME);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
		if(encontractManagement.ListSAVEDQUERYNAME().size()>0){ 
			
			lavanteUtils.fluentwait(encontractManagement.ListSAVEDQUERYNAME().get(0));
			outr:for(int i=0;i<=encontractManagement.ListSAVEDQUERYNAME().size();i++)
			{
				
				String appq=encontractManagement.ListSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME,"+appq+" is matched in the list");
					
					lavanteUtils.click(encontractManagement.ListSAVEDQUERYDEL().get(i));
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.OKBtn());
					lavanteUtils.click(encontractManagement.OKBtn());
					Reporter.log("Created Query:"+QNAME+",has been deleted");
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.advSearchtab());
					int size=encontractManagement.ListSAVEDQUERYNAME().size();
					if(encontractManagement.ListSAVEDQUERYNAME().size()>0){
						
						boolean found=false;
						lavanteUtils.fluentwait(encontractManagement.ListSAVEDQUERYNAME().get(0));
						for(int j=0;j<size;j++)
						{
							String nwlistq=encontractManagement.ListSAVEDQUERYNAME().get(j).getText();
							if(QNAME.trim().equalsIgnoreCase(nwlistq.trim())){
								Reporter.log("Deleted Query Found in the list"+QNAME+"Actual,"+nwlistq);
								found =true;
							} 
							
						}
						
						if(found==false){
							Reporter.log("In the List,Query:"+QNAME+",is not available as it has been Deleted ");
							flag=true;
							break outr;
						}
					} else {
						flag=true;
						Reporter.log("Query:"+QNAME+",has been Deleted and Not Available in the list");
					}
				}
			}
			
		}
		if(flag==false){		
			softassert.assertTrue(false,"Issue While Saving,Recheck the Scripts");
		}
		delquery(QNAME);
		delQueryFrmDB(QNAME);
		softassert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());		
		System.out.println("----------Test Ended----------------");
	}
	
	/** 
	 * Verify Adv Search Shared SAVE QUERY 
	 * Login SAVE the query, Logout ,Verify with same and different role
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void SharePublicSavedQuery008(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Shared Functionality for Public SAVE QUERY:"+LavanteUtils.currenttime());
		
		QNAME="SPAutoQuery";
		boolean flag=false;
		
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		//Save After Building the query.		
		QNAME="SPAutoQuery"+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("Public", "");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved:"+QNAME);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
		System.out.println(encontractManagement.ListPublicSAVEDQUERYNAME().size());
		SoftAssert softassert=new SoftAssert();
		if(encontractManagement.ListPublicSAVEDQUERYNAME().size()>0){ 
			
			lavanteUtils.fluentwait(encontractManagement.ListPublicSAVEDQUERYNAME().get(0));
			for(int i=0;i<encontractManagement.ListPublicSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListPublicSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME,"+appq+" is matched in the list");
					enobjhomePage.logout();
					String login2="cnelson@gpstrategies.com";
					loginDataMap.put("username", login2);
					loginDataMap.put("password","lavante@123");
					enobjloginpage.logintoAPP(loginDataMap);
					Reporter.log("Logged into the Second Login:"+login2); 
					before();
					dataMap.put("AdvSearch","AdvSearch");
					encontractManagement.selectSearchTab(dataMap);
					Reporter.log("Navigated to Advanced Search Tab");
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.advSearchtab());
					if(encontractManagement.ListPublicSAVEDQUERYNAME().size()>0){ 
						
						lavanteUtils.fluentwait(encontractManagement.ListPublicSAVEDQUERYNAME().get(0));
						for(int j=0;j<encontractManagement.ListPublicSAVEDQUERYNAME().size();j++)
						{
							String nwappq=encontractManagement.ListPublicSAVEDQUERYNAME().get(j).getText();
							if(QNAME.trim().equalsIgnoreCase(nwappq.trim())){
								Reporter.log("QNAME:"+nwappq+",is matched in the list");
								softassert.assertEquals(QNAME.trim(),nwappq.trim(),"Query not Matched,expected"+QNAME+" in app"+nwappq);
								Reporter.log("QNAME:"+nwappq+"created in first login available to the same user role:"+login2);
							}
						}
					}
					
					enobjhomePage.logout();
					String login3="ssquires@gpstrategies.com";
					loginDataMap.put("username", login3);
					loginDataMap.put("password","lavante@123");
					enobjloginpage.logintoAPP(loginDataMap);
					Reporter.log("Logged into the Third Login:"+login3); 
					before();
					dataMap.put("AdvSearch","AdvSearch");
					encontractManagement.selectSearchTab(dataMap);
					Reporter.log("Navigated to Advanced Search Tab");
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.advSearchtab());
					if(encontractManagement.ListPublicSAVEDQUERYNAME().size()>0){ 
						
						lavanteUtils.fluentwait(encontractManagement.ListPublicSAVEDQUERYNAME().get(0));
						for(int j=0;j<encontractManagement.ListPublicSAVEDQUERYNAME().size();j++)
						{
							String nwappq=encontractManagement.ListPublicSAVEDQUERYNAME().get(j).getText();
							if(QNAME.trim().equalsIgnoreCase(nwappq.trim())){
								Reporter.log("QNAME:"+nwappq+",is matched in the list");
								softassert.assertEquals(QNAME.trim(),nwappq.trim(),"Query not Matched,expected"+QNAME+" in app"+nwappq);
								Reporter.log("QNAME:"+nwappq+"created in first login available for different user role:"+login3);
								flag=true;
							}
						}
					}
					
				}
			}
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Test Failed,Recheck with the data");
		}
		delQueryFrmDB(QNAME);
		enobjhomePage.logout();
		login();
		softassert.assertAll();
		Reporter.log("Test Ended at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");
	}

	/**
	 * Verify Adv Search Shared Private SAVE QUERY 
	 * Login SAVE the query, Logout ,Verify with same and different role
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test(dataProvider="SingleAdvSearch",dataProviderClass=CMSearchDataProvider.class)
	public void SharePrivateSavedQuery009(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Shared Functionality for Private SAVE QUERY------------------");
		Reporter.log("Test Started for Shared Functionality for Private SAVE QUERY:"+LavanteUtils.currenttime());
		
		String QNAME="SPAutoQuery";
		boolean flag=false;
		
		dataMap.put("AdvSearch","AdvSearch");
		encontractManagement.selectSearchTab(dataMap);
		Reporter.log("Navigated to Advanced Search Tab");
		//For CLicking Build Option
		dataMap.put("Build","Build");
		encontractManagement.SelectSearchOption(dataMap);
		Reporter.log("Select Buiild Query Option in Advanced Search Tab");
		//Save After Building the query.		
		QNAME="SPAutoQuery"+LavanteUtils.randomnum();
		dataMap.put("ClearQuery", "");
		dataMap.put("SaveQuery","");
		dataMap.put("Private", "");
		dataMap.put("SaveQueryName",QNAME);
		dataMap.put("SavetheQuery","");
		
		encontractAdvancedSearch.buildquery(dataMap);
		Reporter.log("Query Saved:"+QNAME);
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(encontractManagement.advSearchtab());
		System.out.println(encontractManagement.ListPublicSAVEDQUERYNAME().size());
		SoftAssert softassert=new SoftAssert();
		if(encontractManagement.ListPublicSAVEDQUERYNAME().size()>0){ 
			
			lavanteUtils.fluentwait(encontractManagement.ListPublicSAVEDQUERYNAME().get(0));
			for(int i=0;i<encontractManagement.ListPublicSAVEDQUERYNAME().size();i++)
			{
				String appq=encontractManagement.ListPublicSAVEDQUERYNAME().get(i).getText();
				if(QNAME.trim().equalsIgnoreCase(appq.trim())){
					Reporter.log("QNAME,"+appq+" is matched in the list");
					enobjhomePage.logout();
					String login2="ssquires@gpstrategies.com";
					loginDataMap.put("username", login2);
					loginDataMap.put("password","lavante@123");
					enobjloginpage.logintoAPP(loginDataMap);
					Reporter.log("Logged into the Second Login:"+login2); 
					before();
					dataMap.put("AdvSearch","AdvSearch");
					encontractManagement.selectSearchTab(dataMap);
					Reporter.log("Navigated to Advanced Search Tab");
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.advSearchtab());
					boolean found =false;
					System.out.println(encontractManagement.ListPublicSAVEDQUERYNAME().size());
					if(encontractManagement.ListPublicSAVEDQUERYNAME().size()>0){ 
						lavanteUtils.fluentwait(encontractManagement.ListPublicSAVEDQUERYNAME().get(0));
						for(int j=0;j<encontractManagement.ListPublicSAVEDQUERYNAME().size();j++)
						{
							String nwappq=encontractManagement.ListPublicSAVEDQUERYNAME().get(j).getText();
							System.out.println(nwappq+QNAME);
							if(QNAME.trim().equalsIgnoreCase(nwappq.trim())){
								Reporter.log("QNAME:"+QNAME+",is available in the list for "+login2);
								softassert.assertTrue(false,"Query available for the other role"+QNAME+" in app"+login2);
								Reporter.log("QNAME:"+QNAME+"created in first login,  available for different user role:"+login2);
								found=true;
							} 
						}
						
					}
					
					if(found==false){
						Reporter.log("QNAME:"+QNAME+",is not in the list for "+login2);
						softassert.assertTrue(true,"Query available for the other role"+QNAME+" in app"+login2);
						Reporter.log("QNAME:"+QNAME+"created in first login, not available for different user role:"+login2);
						flag=true;
					}
										
					enobjhomePage.logout();
					String login3="cnelson@gpstrategies.com";
					loginDataMap.put("username", login3);
					loginDataMap.put("password","lavante@123");
					enobjloginpage.logintoAPP(loginDataMap);
					Reporter.log("Logged into the Third Login:"+login3); 
					before();
					dataMap.put("AdvSearch","AdvSearch");
					encontractManagement.selectSearchTab(dataMap);
					Reporter.log("Navigated to Advanced Search Tab");
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(encontractManagement.advSearchtab());
					System.out.println(encontractManagement.ListPublicSAVEDQUERYNAME().size());
					if(encontractManagement.ListPublicSAVEDQUERYNAME().size()>0){ 
						
						lavanteUtils.fluentwait(encontractManagement.ListPublicSAVEDQUERYNAME().get(0));
						for(int j=0;j<encontractManagement.ListPublicSAVEDQUERYNAME().size();j++)
						{
							String nwappq=encontractManagement.ListPublicSAVEDQUERYNAME().get(j).getText();
							System.out.println(nwappq+QNAME);
							if(QNAME.trim().equalsIgnoreCase(nwappq.trim())){
								Reporter.log("QNAME:"+nwappq+",is matched in the list");
								softassert.assertEquals(QNAME.trim(),nwappq.trim(),"Query not Matched,expected"+QNAME+" in app"+nwappq);
								Reporter.log("QNAME:"+nwappq+"created in first login available to the same user role:"+login3);
								flag=true;
								delquery(nwappq);
							}
						}
					}
				}
			}
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Test Failed,Recheck with the data");
		}
		delQueryFrmDB(QNAME);
		enobjhomePage.logout();
		login();
		softassert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}
	
	private void delquery(String qname){
		
		List<WebElement> s=driver.findElements(By.cssSelector("[id*='queries'] td:nth-child(1) span"));
		for(int i=0;i<s.size();i++)
		{
			String appq=s.get(i).getText();
			if(qname.trim().equalsIgnoreCase(appq.trim())){
				lavanteUtils.click(encontractManagement.ListSAVEDQUERYDEL().get(i));
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(encontractManagement.OKBtn());
				lavanteUtils.click(encontractManagement.OKBtn());
			}
		}
	}
	
	private void delQueryFrmDB(String QNAME) throws Exception
	{
		String delquery="";
		if(QNAME.length()==0){
		 delquery="DELETE FROM SavedSearch WHERE SavedSearchCriteria like '%msa%' and SavedSearchCriteria like '%1%' and CustomerID="+customerID;
		 lavanteUtils.UpdateDB(delquery);
		}else {
			delquery="DELETE FROM SavedSearch WHERE QueryName like '%"+QNAME+"%' and CustomerID="+customerID;
			lavanteUtils.UpdateDB(delquery);
			lavanteUtils.refreshPage();
		}
		
	}
	
	/**
	 * After Method Switches to default frame
	 * 
	 * @author Piramanayagam.S
	 * @param null
	 * @throws Exception 
	 * @returns null
	 * 
	 */
	@AfterMethod
	public void SetupAftermethod() throws Exception{
		delQueryFrmDB(QNAME);
		enobjhomePage.popupclose();
		enobjhomePage.backtoSearch();
		lavanteUtils.refreshPage();
	}
	
	/**
	 * Logout Method and Driver Quitting the method
	 * @author Piramanayagam.S
	 * @param null
	 * @return null
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

