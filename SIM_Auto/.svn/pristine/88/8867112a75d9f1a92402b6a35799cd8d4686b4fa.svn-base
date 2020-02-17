package com.lavante.sim.customer.TestScripts.Transactions.ContractManagement;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 05-1-2016
 * Created for Deliverable Enhancment Test case
 * Enhancement covered SIM-7341
 * Ended on 05-1-2016
 * @author Piramanayagam.S
 *
 */
public class ContractManagementTC extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
		
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		List listofdatafrm=lavanteUtils.login("Recovery", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	//	customerid=(String) cusstomerid.get(1);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	
	}
	
	/**
	 * In this Class all test starts from Supplier-Contract management tab,hence navigated to the page
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeMethod
	public void beforeClassMethod(){

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Suppliers");
		dataMap.put("subtab", "Contract Management");
		enobjhomePage.selectTab(dataMap);
		
	}
	

	/**
	 * Verify Deliverable Status field not available 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test
	public void VerifyStatusField001() throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Status field-------------------");
		lavanteUtils.switchtoFrame(encontractManagement.IFRAMESearchResult());
	
		for(int i=0;i<encontractManagement.tableheaderlist().size();i++)
			{
				String header=encontractManagement.tableheaderlist().get(i).getText();
				
				if(header.equalsIgnoreCase("Deliverable Status"))
				{
					Assert.assertTrue(false,"Deliverable Status field available");
				}else{
					Assert.assertTrue(true,"Deliverable Status field available");
				}
			}

		

		System.out.println("----------Test Ended----------------");
	}
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.logout();
		quitBrowser();
	}


}

