package com.lavante.sim.customer.TestScripts.Dashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
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
 * Created on 05-1-2016
 * Created for CustomerDashboard Non Must pass UAT
 * Ended on 05-1-2016
 * @author Piramanayagam.S
 *
 */
public class CustomerDashboardTC extends PageInitiator{
	
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
		
		List<?> listofdatafrm=lavanteUtils.login("Recovery", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
			
	}

	/**
	 * Verify Customer Logo and Company Logo
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void VerifyCustomerLogo() throws InvalidFormatException, IOException, SQLException{	
		Reporter.log("------------Test Started for Status field-------------------"+currenttime());
		boolean flag=false;
	
		SoftAssert softassert=new SoftAssert();
			
			String complogo=enobjhomePage.companylogo().getAttribute("href");
			System.out.println(complogo);
			if(complogo.contains("lavante")){
				softassert.assertTrue(true,"Company logo not present"+complogo);
			}
			
			String custlogo=enobjhomePage.customerlogo().getAttribute("style");
			if(custlogo.contains("\""))
			{
				String[] da=custlogo.split("\"");
				custlogo=da[1];
			}
		
			String query="select Name from Customer where CustomerLogoUrl "	+ "= '"+custlogo+"'";
			
			String data=lavanteUtils.fetchDBdata(query);
			if(data.length()>0)
				{
				softassert.assertTrue(true,"Query returned empty data available");
				flag=true;
				}
			
			softassert.assertAll();
			
			if(flag==false){
				Assert.assertTrue(false,"Data not available");
			}
			

		Reporter.log("----------Test Ended----------------"+currenttime());
	}
	
	/**
	 * Verify Supplier Search using Supplier name on Dashboard page
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test
	public void VerifyCustomerSearch002() throws InvalidFormatException, IOException{	
		Reporter.log("------------Test Started for Customer Search-------------------"+currenttime());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","SupplierSearch");
		enobjhomePage.selectTab(dataMap);
		
		String name=null;
		enobjsupplierPage.searchResultsFilterBy("Any");
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0)
			{
				name=enobjsupplierPage.getColumnText("Name",0);
			}
		lavanteUtils.switchtoFrame(null);
		
		dataMap.clear();		
		dataMap.put("maintab","customerDashboard");
		dataMap.put("subtab", "customerDashboard");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.clear();
		dataMap.put("type", "Supplier Name");
		dataMap.put("value",name);
		enobjhomePage.search(dataMap);
		
		lavanteUtils.fluentwait(enobjsupplierPage.SearchListIFRAME());
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0)
			{
				Assert.assertEquals(name,enobjsupplierPage.getColumnText("Name",0),"Search is not MATCHED");
			}
		
		
		Reporter.log("----------Test Ended----------------"+currenttime());
	}
	
	@Test(dataProvider="InviteSupplier")
	public void VerifyMultiSelectOrg003(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
			Reporter.log("------------Test Started for Supplier Search field-------------------"+currenttime());
			boolean flag=false;
		
			lavanteUtils.click(enobjhomePage.linkInviteNwsupp());
			
			dataMap.put("invite","");
			
			String suppname=null;
			if(dataMap.containsKey("suppname"))
			{
				suppname=dataMap.get("suppname");
				
				if(dataMap.get("suppname").equalsIgnoreCase("ANY"))
					{
						suppname	="SPPP";
						suppname=LavanteUtils.randomnum()+suppname;
					}
				dataMap.put("suppname",suppname);
			}
		//	in.createnwSupp(dataMap);
			
			dataMap.put("maintab","SupplierSearch");
			dataMap.put("subtab", "SupplierSearch");
			enobjhomePage.selectTab(dataMap);
			
			dataMap.put("supplierName", suppname);
			dataMap.put("Search", "");
			enobjsupplierBasicSearch.search(dataMap);
			
			//Switch to SUPP search
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			if(enobjsupplierPage.supplist().size()>0)
			{
				Assert.assertEquals(suppname,enobjsupplierPage.supplist().get(0).getText(),"Supplier not created");
				lavanteUtils.click(enobjsupplierPage.supplist().get(0));
				
				lavanteUtils.switchtoFrame(null);
				
				dataMap.put("maintab","Enterprise");
				//dataMap.put("subtab", "HeaderInformation");
				enviewSupplier.selectTab(dataMap);
				
				for(int i=0;i<enviewSupplier.invteorglist().size();i++){
					String appdata=enviewSupplier.invteorglist().get(i).getText();
					String org=dataMap.get("inviteorg");
					String loct=null;
					if(org.contains("#"))
					{
							String[] orglist=org.split("#");
							System.out.println(orglist.length);
								for(int ij=0;ij<orglist.length;ij++)
								{
								 loct="option[title='"+orglist[ij]+"']";
								 System.out.println(loct+appdata);
								 if(appdata.equalsIgnoreCase(loct))
									{
										Assert.assertTrue(true);
										
									}
								}
								flag=true;
					}
					
				}
				
			}
			if(flag==false){
				Assert.assertTrue(false,"DATA NOT AVAILABLE");
			}
			
			Reporter.log("----------Test Ended----------------"+currenttime());
		}
		
			
			

	@AfterMethod
	public void aftermethod(){
		enobjhomePage.backtoSearch();
	}
	
	@AfterClass
	public void close(){
		enobjhomePage.logout();
		quitBrowser();
	}

}

