package com.lavante.sim.customer.TestScripts.Supplier.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 06-02-2017
 * Created for Supplier Agent Test 
 * SIM-9636 
 * Ended on 08-02-2017
 * @author Piramanayagam.S
 *
 */
public class AssocitateSupplierAgent extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String CustomerID="";

	/**
	 * 
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
		CustomerID=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		String query="update CustomerPropertyValue set PropertyValue='True' where CustomerPropertyID=2 and CustomerID="+CustomerID;
		lavanteUtils.UpdateDB(query);
	}
		
	@BeforeMethod
	public void before(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}

	/**SIM-9636 Associate Agent Again will try to associate a supplier agent again 
	 * Verify the Warning Msg
	 * 
	 * @author Piramanayagam.S
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void AssociateAgentAgain() throws Exception{	
		System.out.println("------------Test Started for AssociateAgentAgain-------------------");
		Reporter.log("Test Started for AssociateAgentAgain:"+currenttime());
		
		SoftAssert softassert =new SoftAssert();
		boolean flag=false;
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("Clear", "");
		
		dataMap.put("Tab", "Enterprise");
		dataMap.put("ManagedBy", "Supplier Agent");
		//dataMap.put("SupplierAgent", "a");
		dataMap.put("Search", "");
		
		ensupplierAdvanced.buildQuery(dataMap);			
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
			dataMap.put("OtherAction","");
			dataMap.put("AssociateAgent","");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			
			lavanteUtils.fluentwait(enobjsupplierPage.dialogmsg());
			String msg=enobjsupplierPage.dialogmsg().getText();
			String expmsg="This supplier is already associated with a supplier agent";
			
			System.out.println("Associate Msg:"+msg+",Expected:"+expmsg);
			Reporter.log("Associate Msg:"+msg+",Expected:"+expmsg);
			softassert.assertTrue(msg.contains(expmsg),"Error Message didnot match");
			flag=true;
		}else{
			Reporter.log("Please Add test data for this Search and RETEST");
			softassert.assertTrue(false,"DATA NOT AVAILABLE");
			flag=true;
		}
	
		if(flag==false){
			softassert.assertTrue(false,"Issue in the Code,Please Verify");
		}
		
		softassert.assertAll();
		
		Reporter.log("Test Ended for Associate Agent Again at:"+currenttime());
	}


	/**SIM-9636 Compare Contact List of Reinvite and Edit Contact List for Agent Supplier Managed
	 * 
	 * @author Piramanayagam.S
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void AssociateReinviteEditContactCompare() throws Exception{	
		Reporter.log("Test Started for Associate Reinvite Edit Compare:"+currenttime());
		
		SoftAssert softassert =new SoftAssert();
		boolean flag=false;
		
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("Clear", "");
		
		dataMap.put("Tab", "Enterprise");
		dataMap.put("ManagedBy", "Supplier Agent");
	//	dataMap.put("SupplierAgent", "a");
		dataMap.put("Search", "");
		
		ensupplierAdvanced.buildQuery(dataMap);	
		
		enobjsupplierPage.selectChangeView("Invites");
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
				dataMap.put("Invitation","");
				dataMap.put("Reinvite","");
				String sup=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
				
				lavanteUtils.switchtoFrame(enobjsupplierPage.IFRAMEreinvite());
				
				List<String> org=new ArrayList<String>();
				lavanteUtils.fluentwait(enobjsupplierPage.ListContact().get(0));
				for(int i=0;i<enobjsupplierPage.ListContact().size();i++){
					String x=enobjsupplierPage.ListContact().get(i).getText();
					if(!x.contains("Invite new supplier")){
						x=x.trim();
						
						//Reinvite Shows with Email ID
					if(x.contains(" (")){
							String[] splitedString=x.split(" \\(");
							if(splitedString[0].contains(" )")){
								String[] string2=splitedString[0].split(" \\)");
								org.add(string2[0]);
							}
							org.add(splitedString[0]);
					}else{
							org.add(x);
					}
					}
				}
				
				if(!(org.size()>0)){
					Assert.assertTrue(false, "There is no Contact for Reinvite,Please Recheck");
				}
	
				enobjhomePage.popupclose();
				
				dataMap.clear();
				
				//For Deselection of Existing Selection
				dataMap.put("supplierName",sup);
				enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
				
	
				dataMap.put("profile","");
				dataMap.put("editProfile","");
				enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
				
				
				dataMap.put("tab", "CompanyDetails");
				eneditProfile.selectTab(dataMap);
				
				Reporter.log("In Edit Profile:");
				lavanteUtils.click(eneditCompanyProfile.ManageSupplierContactsBtn());
				
				lavanteUtils.click(eneditCompanyProfile.OKbtn());
				
				List<String> actual=new ArrayList<String>();
				lavanteUtils.fluentwait(objUserPage.AddNewUserBtn);
				
				for(int i=0;i<objUserPage.ListOfContactName.size();i++){
					String s=objUserPage.ListOfContactName.get(i).getText();
					actual.add(s);
				}
			
				if(org.size()==actual.size()){
					Collections.sort(org);
					Collections.sort(actual);
					Reporter.log("Reinvite Actual List:"+actual+",Exp List"+org);
					softassert.assertTrue(org.equals(actual),"List Not Matched");
					flag=true;
					
				}else{
					softassert.assertTrue(false,"Size Not Matched for Reinvite and Contact List,Expected:"+org.size()+",Actuals:"+actual.size());
				}
			}
			
	
		if(flag==false){
			Reporter.log("Please Add test data for this Search and RETEST");
		}
		
		softassert.assertAll();
		
		Reporter.log("Test Ended for Associate Reinvite Edit Compare at:"+currenttime());
	}

	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		//enobjhomePage.popupclose();
		enobjhomePage.backtoSearch();
		//One of the Test uses Edit Profile Hence added the same.
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("EditCancel", "");
		eneditProfile.formAction(dataMap);	
		lavanteUtils.refreshPage();
		
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

