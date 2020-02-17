package com.lavante.sim.customer.TestScripts.Dashboard;

import java.util.ArrayList;
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
 * Created on 16-12-2015
 * Created for Recovery Chart
 * Enhancement covered SIM -6908
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class RecoveryChart extends PageInitiator{
	
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
		List listofdatafrm=lavanteUtils.login("Recovery", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
				
	}
	

	/** SIM-6908
	 * Recovery dashboard charts in claims
	 * @param null
	 * @return null 	
	 * 
	 */
	@Test
	public void claimsRecovery001() throws Exception{
		SoftAssert softAssert=new SoftAssert();	
		boolean flag=false;
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Home");
		dataMap.put("subtab", "customerDashboardClaim");

		enobjhomePage.selectTab(dataMap);

		
		List<String> da=new ArrayList<String>();
		da.add("Claims by Status");
		da.add("Claims by Type");
		da.add("All Claims");
		da.add("Claims by Organization");
		
		
		for(int i=0;i<enobjdashBoard.claimchats().size();i++){
			
			String appchartname=enobjdashBoard.claimchats().get(i).getText();
			
			Reporter.log("App chart name:"+appchartname);
			softAssert.assertTrue(da.contains(appchartname),da+":"+appchartname+"Does not contain");
			flag=true;
			
		}
		if(flag==false){
			softAssert.assertTrue(false,"Please Retest");
		}
		softAssert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());	
	}
	
	/** SIM-6908
	 * Recovery dashboard charts in claims
	 * @param null
	 * @return null 	
	 * 
	 */
	@Test
	public void suppStatsticRecovery002() throws Exception{
			LinkedHashMap<String, String> dataMap =new LinkedHashMap<String, String>();
			SoftAssert softAssert=new SoftAssert();
			boolean flag=false;
			dataMap.put("maintab", "Home");
			dataMap.put("subtab", "customerDashboardSupplierStatistics");
			enobjhomePage.selectTab(dataMap);
			
			List<String> da=new ArrayList<String>();
			da.add("Suppliers Excluded");
			da.add("Suppliers Targeted");
			da.add("Supplier Change Statistics");
			da.add("Related Supplier Analysis");
			
			System.out.println(enobjdashBoard.claimchats().size());
			
			for(int i=0;i<enobjdashBoard.claimchats().size();i++){
				
				String appchartname=enobjdashBoard.claimchats().get(i).getText();
				
				Reporter.log("App chart name:"+appchartname);
				softAssert.assertTrue(da.contains(appchartname),appchartname+"Does not contain");
				flag=true;
				
			}
			
			if(flag==false){
				softAssert.assertTrue(false,"Please Retest");
			}
			softAssert.assertAll();
			Reporter.log("Test Ended:"+LavanteUtils.currenttime());
		}
	
	/** SIM-6908
	 * Recovery dashboard charts in claims
	 * @param null
	 * @return null 	
	 * 
	 */
	@Test
	public void CompilanceRecovery003() throws Exception{
			LinkedHashMap<String, String> dataMap =new LinkedHashMap<String, String>();
			SoftAssert softAssert=new SoftAssert();
			boolean flag=false;
			dataMap.put("maintab", "Home");
			dataMap.put("subtab", "customerDashboardStatementCompliance");
			enobjhomePage.selectTab(dataMap);
			
			List<String> da=new ArrayList<String>();
			da.add("Compliance by Spend");
			da.add("Compliance by Count");
			da.add("Compliance by Spend Rank");
			da.add("Suppliers on OFAC SDN");
			
			System.out.println(enobjdashBoard.claimchats().size());
			
			for(int i=0;i<enobjdashBoard.claimchats().size();i++){
				
				String appchartname=enobjdashBoard.claimchats().get(i).getText();
				
				Reporter.log("App chart name:"+appchartname);
				softAssert.assertTrue(da.contains(appchartname),enobjdashBoard.claimchats().get(i).getText()+":"+appchartname+"Does not contain");
				flag=true;
				
			}
				

			if(flag==false){
				softAssert.assertTrue(false,"Please Retest");
			}
			softAssert.assertAll();
			Reporter.log("Test Ended:"+LavanteUtils.currenttime());		
	}
	
	/** SIM-6908
	 * Recovery dashboard charts in claims
	 * @param null
	 * @return null 	
	 * 
	 */
	@Test
	public void ClaimsByType() throws Exception{
		
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		String quer="Select UserRoleID from LoginRole_PageControl_Map where UserRoleID=14 AND PageControlID in (102)";
	
		String x=lavanteUtils.fetchDBdata(quer);
		System.out.println(x);
		if(x==null){
		
		String query="Insert into LoginRole_PageControl_Map (   UserRoleID  ,PageControlID  ,LoginAccessTypeID) VALUES ( 14     ,102     ,5  )";
		lavanteUtils.UpdateDB(query);
		}
		Reporter.log("Inserted into DB for disabling Claims By Type:");
		
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("subtab", "customerDashboardClaims");
		enobjhomePage.selectTab(dataMap);
		
		List<String> da=new ArrayList<String>();
		da.add("claims by Type");
		
		System.out.println(enobjdashBoard.claimchats().size());
		
		for(int i=0;i<enobjdashBoard.claimchats().size();i++){
			
			String appchartname=enobjdashBoard.claimchats().get(i).getText();
			
			
			Reporter.log(da.get(0)+"App chart name:"+appchartname+da.get(0).equalsIgnoreCase(appchartname));
			softAssert.assertFalse(da.contains(appchartname),"Does not contain");
			flag=true;
		}
		

		if(flag==false){
			softAssert.assertTrue(false,"Please Retest");
		}
		softAssert.assertAll();
		
	}
	
	/** SIM-6908
	 * Recovery dashboard charts in claims
	 * @param null
	 * @return null 	
	 * 
	 */
	@Test
	public void suppstatistics() throws Exception{
			
			SoftAssert softAssert=new SoftAssert();
			boolean flag=false;
			
			String quer="Select UserRoleID from LoginRole_PageControl_Map where UserRoleID=14 AND PageControlID in (104)";
		
			String x=lavanteUtils.fetchDBdata(quer);
			System.out.println(x);
			if(x==null){
			
			String query="Insert into LoginRole_PageControl_Map (   UserRoleID  ,PageControlID  ,LoginAccessTypeID) VALUES (   14     ,104    ,5  )";
				lavanteUtils.UpdateDB(query);
				System.out.println("Inserted");
			}
			
			Reporter.log("Inserted into DB for disabling Supplier Excluded");
			
			LinkedHashMap<String, String> dataMap =new LinkedHashMap<String, String>();
			dataMap.put("subtab", "customerDashboardSupplierStatistics");
			enobjhomePage.selectTab(dataMap);
			
			List<String> da=new ArrayList<String>();
			da.add("Suppliers Excluded");
			
			System.out.println(enobjdashBoard.claimchats().size());
			
			for(int i=0;i<enobjdashBoard.claimchats().size();i++){
				
				String appchartname=enobjdashBoard.claimchats().get(i).getText();
				Reporter.log(da.get(0)+"App chart name:"+appchartname+da.get(0).equalsIgnoreCase(appchartname));
				softAssert.assertFalse(da.contains(appchartname),da.get(0)+":"+appchartname+"Does not contain");
				
				flag=true;
			}
			if(flag==false){
				softAssert.assertTrue(false,"Please Retest");
			}
			softAssert.assertAll();
			Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}
	
	/** SIM-6908
	 * Recovery dashboard charts in claims
	 * @param null
	 * @return null 	
	 * 
	 */
	@Test
	public void stmtcompilance() throws Exception{
					
			SoftAssert softAssert=new SoftAssert();
			boolean flag=false;
			Reporter.log("Test Started for Statement Compilance:"+LavanteUtils.currenttime());
			
			String quer="Select UserRoleID from LoginRole_PageControl_Map where UserRoleID=14 AND PageControlID in (108)";
		
			String x=lavanteUtils.fetchDBdata(quer);
			System.out.println(x);
			if(x==null){
			
			String query="Insert into LoginRole_PageControl_Map (   UserRoleID  ,PageControlID  ,LoginAccessTypeID) VALUES (   14     ,108    ,5  )";
			lavanteUtils.UpdateDB(query);
			}
			
			Reporter.log("Inserted into DB for disabling Compilance by Count chart:");
			
			LinkedHashMap<String, String> dataMap =new LinkedHashMap<String, String>();
			dataMap.put("subtab", "customerDashboardStatementCompliance");
			enobjhomePage.selectTab(dataMap);
			
			List<String> da=new ArrayList<String>();
			da.add("compilance by count");
			
			System.out.println(enobjdashBoard.claimchats().size());
			
			for(int i=0;i<enobjdashBoard.claimchats().size();i++){
				
				String appchartname=enobjdashBoard.claimchats().get(i).getText();
				
				
				Reporter.log(da.get(0)+"App chart name:"+appchartname+da.get(0).equalsIgnoreCase(appchartname));
				softAssert.assertFalse(da.contains(appchartname),"Does not contain");
				flag=true;
			}
		
			if(flag==false){
				softAssert.assertTrue(false,"Please Retest");
			}
			softAssert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}
		
	@AfterMethod 
	public void SetupAftermethod(){
		
		lavanteUtils.refreshPage();
		
	}
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		
		enobjhomePage.logout();
		quitBrowser();
	}


}

