package com.lavante.sim.customer.TestScripts.Supplier.Search;

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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 19-2-2016
 * Created for Supplier Search 
 * Enhancement covered SIM -7614,SIM-7604
 * Ended on 19-02-2016
 * @author Piramanayagam.S
 *
 */
public class INNotINOperator extends PageInitiator{
	
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
		lavanteUtils.driver=driver;
		
		List listofdatafrm=lavanteUtils.login("Search-INNOTIN", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
	
		lavanteUtils.waitForTime(3000);
	}


	/** SIM-6146
	 * IN operator
	 * 
	 * @param dataMap
	 * //@Throws InvalidFormatException
	 * //@Throws IOException
	 * //@Throws SQLException 
	 */
	@Test(dataProvider="CountryOfReg",dataProviderClass=SupplierSearchDataProvider.class)
	public void INOPERATOR(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Adv Search -------------------");
		Reporter.log("Test Started to check for United states,GERMANY by using IN operator:"+LavanteUtils.currenttime());
		SoftAssert softAssert =new SoftAssert();

		String das=" update CustomerMetadata SET IsMandatoryField = 0  where ProfileMetadataID=1700 and CustomerID="+customerid;
		lavanteUtils.UpdateDB(das);
		
		String desc="Auto"+LavanteUtils.randomnum();
		//IN Query
		String query1="Insert into VirtualGroup (XML_CR,Description) VALUES ('<SearchCriterias><SearchCriteria><ColumnId><![CDATA[countryOfRegistration]]></ColumnId><Operator>"
				+ "<![CDATA[IN]]></Operator><Value><![CDATA[840,276,887]]></Value></SearchCriteria></SearchCriterias>','"+desc+"')";
		String query2="select VirtualGroupID from VirtualGroup where Description like '%"+desc+"%';";
		
		lavanteUtils.UpdateDB(query1);
		String id=lavanteUtils.fetchDBdata(query2);

		String mandQuery="Insert into CustomerMetadata (CustomerID  ,ProfileMetadataID  ,IsMandatoryField   ,IsVisibleField  ,IsNotifyField  ,VirtualGroupID  ,IsOnlyVirtualGroup,GroupID,GroupValue,IsNotEqualTo) "
				+ "VALUES ("+customerid+",1700,1,1,1,"+id+",1,0,0,0)";
				
		lavanteUtils.UpdateDB(mandQuery);
		
		Reporter.log("IN Query inserted into db for the following country: United states,Germany");
		Reporter.log("Tested started for united states:");
		boolean flag=false;
		
		
		String qname="AutoSP"+LavanteUtils.randomnum();
		
		dataMap.put("SaveQuery","");
		dataMap.put("saveqryname",qname);
		dataMap.put("SavetheQuery","");
		
		query2="delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%countryOfRegistration%' and CustomerID="+customerid; 
		lavanteUtils.UpdateDB(query2);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		ensupplierAdvanced.buildQuery(dataMap);	
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.supplist().size()>0){
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");
			String sup=enobjsupplierPage.VerifyManagedBy();
			Reporter.log("US SUpplier:"+sup);
			dataMap.put("supplierName", sup);
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			
			dataMap.put("tab", "Company");
			eneditProfile.selectTab(dataMap);
			
			lavanteUtils.waitForTime(3000);
			lavanteUtils.fluentwait(eneditLegal.businessStructure());
			String req="required";
			Reporter.log("US Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
			softAssert.assertTrue(eneditLegal.businessStructure().getAttribute("class").contains(req),"Field is not mandatory");
			Reporter.log(eneditLegal.businessStructure().getAttribute("class"));
		
			dataMap.put("EditCancel", "");
			eneditProfile.formAction(dataMap);
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enobjsupplierBasicSearch.BasicSearchTab);
			lavanteUtils.click(enobjsupplierBasicSearch.BasicSearchTab);

			lavanteUtils.waitForTime(7000);

			String germanysuppname="SCRV Rheinland Industrie Service Gmbh";
			lavanteUtils.waitForTime(3000);
			dataMap.put("supplierName", germanysuppname);
			dataMap.put("Search", "");			
			enobjsupplierBasicSearch.search(dataMap);
			
			lavanteUtils.waitForTime(5000);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			if(enobjsupplierPage.supplist().size()>0){
				Reporter.log("Query Returned with Search data");
				
				enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

				lavanteUtils.waitForTime(3000);
				eneditProfile.selectTab(dataMap);
				
				lavanteUtils.waitForTime(3000);
				lavanteUtils.fluentwait(eneditLegal.businessStructure());
				Reporter.log(eneditLegal.businessStructure().getText());
				Reporter.log("Germany-IN Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
				softAssert.assertTrue(eneditLegal.businessStructure().getAttribute("class").contains(req),eneditLegal.businessStructure().getAttribute("class")+"Field is mandatory");
				
				dataMap.put("EditCancel", "");
				eneditProfile.formAction(dataMap);
				
			}
			
			
			das=" Delete from CustomerMetadata where CustomerID="+customerid+" and ProfileMetadataID=1700";
			lavanteUtils.UpdateDB(das);
			query2="delete from SavedSearch where QueryName like '%"+qname+"%'"; 
			lavanteUtils.UpdateDB(query2);			
			
			flag=true;
			
			
		}else{
			Reporter.log("No Supplier Found for this Search");
			
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for IN Operator Search at:"+LavanteUtils.currenttime());
	}
	
	/** SIM-6146
	 * NOTIN operator
	 * 
	 * @param dataMap
	 * //@Throws InvalidFormatException
	 * //@Throws IOException
	 * //@Throws SQLException 
	 */
	@Test(dataProvider="CountryOfReg",dataProviderClass=SupplierSearchDataProvider.class)
	public void NOTIN(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Adv Search-------------------");
		Reporter.log("Test Started to check for United states,Germany by using NOTIN operator:"+LavanteUtils.currenttime());
		SoftAssert softAssert =new SoftAssert();
		String das=" update CustomerMetadata SET   IsMandatoryField = 0  where ProfileMetadataID=1700  and CustomerID="+customerid;
		lavanteUtils.UpdateDB(das);
		
		String desc="Auto"+LavanteUtils.randomnum();
		String query1="Insert into VirtualGroup (XML_CR,Description) VALUES ('<SearchCriterias><SearchCriteria><ColumnId><![CDATA[countryOfRegistration]]>"
				+ "</ColumnId><Operator><![CDATA[NOTIN]]></Operator><Value><![CDATA[840,276,887]]></Value></SearchCriteria></SearchCriterias>','"+desc+"')";
		String query2="select VirtualGroupID from VirtualGroup where Description like '%"+desc+"%';";
		
		lavanteUtils.UpdateDB(query1);
		String id=lavanteUtils.fetchDBdata(query2);
		
		String mandQuery="Insert into CustomerMetadata (CustomerID  ,ProfileMetadataID  ,IsMandatoryField   ,IsVisibleField  ,IsNotifyField  ,VirtualGroupID  ,IsOnlyVirtualGroup,GroupID,GroupValue,IsNotEqualTo) "
				+ "VALUES ("+customerid+",1700,1,1,1,"+id+",1,0,0,0)";
		
		
		lavanteUtils.UpdateDB(mandQuery);
		Reporter.log("NOTIN Query inserted into db for the following country: United states,Germany");
		
		System.out.println(dataMap.size()+"DAS"+dataMap);
		Reporter.log("Tested started for united states:");
		
		
		boolean flag=false;
				
		String qname="AutoSP"+LavanteUtils.randomnum();
		
		dataMap.put("SaveQuery","");
		dataMap.put("saveqryname",qname);
		dataMap.put("SavetheQuery","");
		
		query2="delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%countryOfRegistration%' and CustomerID="+customerid; 
		lavanteUtils.UpdateDB(query2);			
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		ensupplierAdvanced.buildQuery(dataMap);	
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.supplist().size()>0){
			
			Reporter.log("Query Returned with Search data");
			
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");
			String sup=enobjsupplierPage.VerifyManagedBy();
			Reporter.log("US SUpplier:"+sup);
			dataMap.put("supplierName", sup);
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

			
			dataMap.put("tab", "Company");
			eneditProfile.selectTab(dataMap);
			
			
			lavanteUtils.waitForTime(3000);
			lavanteUtils.fluentwait(eneditLegal.businessStructure());
			String req="required";
			Reporter.log("US Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
			softAssert.assertFalse(eneditLegal.businessStructure().getAttribute("class").contains(req),eneditLegal.businessStructure().getAttribute("class")+",Field is not mandatory");
			
			dataMap.put("EditCancel", "");
			eneditProfile.formAction(dataMap);
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enobjsupplierBasicSearch.BasicSearchTab);
			lavanteUtils.click(enobjsupplierBasicSearch.BasicSearchTab);
			
			lavanteUtils.waitForTime(7000);
			String germanySuppname="SCRV Rheinland Industrie Service Gmbh";
			dataMap.put("supplierName",germanySuppname);
			dataMap.put("Search", "");			
			enobjsupplierBasicSearch.search(dataMap);
			
			lavanteUtils.waitForTime(5000);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			Reporter.log("Germany Supplier:"+germanySuppname);
			
			if(enobjsupplierPage.supplist().size()>0){
				Reporter.log("Query Returned with Search data");
				
				enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

				lavanteUtils.waitForTime(3000);
				eneditProfile.selectTab(dataMap);
				
				lavanteUtils.waitForTime(3000);
				lavanteUtils.fluentwait(eneditLegal.businessStructure());
				Reporter.log("Germany-Not IN Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
				softAssert.assertFalse(eneditLegal.businessStructure().getAttribute("class").contains(req),eneditLegal.businessStructure().getAttribute("class")+"Field is not mandatory");
				
				dataMap.put("EditCancel", "");
				eneditProfile.formAction(dataMap);
				
			}
			
			das=" Delete from CustomerMetadata where CustomerID="+customerid+" and ProfileMetadataID=1700";
			lavanteUtils.UpdateDB(das);
			query2="delete from SavedSearch where QueryName like '%"+qname+"%'"; 
			lavanteUtils.UpdateDB(query2);
			
			flag=true;
			
			
		}else{
			Reporter.log("No Supplier Found for this Search");
			
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for CTI Search at:"+LavanteUtils.currenttime());
	}

	/** SIM-6146
	 * NOTIN operator
	 * 
	 * @param dataMap
	 * //@Throws InvalidFormatException
	 * //@Throws IOException
	 * //@Throws SQLException 
	 */
	@Test(dataProvider="CountryOfReg",dataProviderClass=SupplierSearchDataProvider.class)
	public void NOTINMutlitple(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Adv Search-------------------");
		Reporter.log("Test Started to check for United states,canada by using NOTIN operator:"+LavanteUtils.currenttime());
		SoftAssert softAssert =new SoftAssert();
		String das=" update CustomerMetadata SET   IsMandatoryField = 0   where ProfileMetadataID=1700  and CustomerID="+customerid;
		lavanteUtils.UpdateDB(das);
		
		String desc="Auto"+LavanteUtils.randomnum();
		//NOT IN 
		String query1="Insert into VirtualGroup (XML_CR,Description) VALUES ('<SearchCriterias><SearchCriteria><ColumnId><![CDATA[countryOfRegistration]]></ColumnId><Operator>"
				+ "<![CDATA[NOTIN]]></Operator><Value><![CDATA[840,124,887]]></Value></SearchCriteria></SearchCriterias>','"+desc+"')";
		String query2="select VirtualGroupID from VirtualGroup where Description like '%"+desc+"%';";
		
		lavanteUtils.UpdateDB(query1);
		String id=lavanteUtils.fetchDBdata(query2);
		
		String mandQuery="Insert into CustomerMetadata (CustomerID  ,ProfileMetadataID  ,IsMandatoryField   ,IsVisibleField  ,IsNotifyField  ,VirtualGroupID  ,IsOnlyVirtualGroup,GroupID,GroupValue,IsNotEqualTo) "
				+ "VALUES ("+customerid+",1700,1,1,1,"+id+",1,0,0,0)";
				
		lavanteUtils.UpdateDB(mandQuery);
		
		Reporter.log("NOTIN Query inserted into db for the following country: United states,canada");
		Reporter.log("Tested started for united states:");
		
		boolean flag=false;
		
		String qname="AutoSP"+LavanteUtils.randomnum();
		
		query2="delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%countryOfRegistration%' and CustomerID="+customerid; 
		lavanteUtils.UpdateDB(query2);
			
		dataMap.put("SaveQuery","");
		dataMap.put("saveqryname",qname);
		dataMap.put("SavetheQuery","");
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		ensupplierAdvanced.buildQuery(dataMap);	
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.supplist().size()>0){
			Reporter.log("Query Returned with Search data for US Supplier");
			
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");
			String sup=enobjsupplierPage.VerifyManagedBy();
			Reporter.log("US SUpplier:"+sup);
			dataMap.put("supplierName", sup);
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

			dataMap.put("tab", "Company");
			eneditProfile.selectTab(dataMap);
			
			lavanteUtils.waitForTime(3000);
			lavanteUtils.fluentwait(eneditLegal.businessStructure());
			String req="required";
			Reporter.log("US Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
			softAssert.assertFalse(eneditLegal.businessStructure().getAttribute("class").contains(req),eneditLegal.businessStructure().getAttribute("class")+",Field is not mandatory");
			
			dataMap.put("EditCancel", "");
			eneditProfile.formAction(dataMap);
			
			lavanteUtils.waitForTime(5000);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(enobjsupplierBasicSearch.BasicSearchTab);
			lavanteUtils.click(enobjsupplierBasicSearch.BasicSearchTab);
			
			lavanteUtils.waitForTime(7000);
			String germanySuppname="SCRV Rheinland Industrie Service Gmbh";
			Reporter.log("Tested started for Germany:"+germanySuppname);
			dataMap.put("supplierName", germanySuppname);
			dataMap.put("Search", "");			
			enobjsupplierBasicSearch.search(dataMap);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			if(enobjsupplierPage.supplist().size()>0){
				
				Reporter.log("Query Returned with Search data for Other Country(Germany) supplier");
				enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

				lavanteUtils.waitForTime(3000);
				eneditProfile.selectTab(dataMap);
				
				lavanteUtils.waitForTime(3000);
				lavanteUtils.fluentwait(eneditLegal.businessStructure());
				Reporter.log(eneditLegal.businessStructure().getText());	
				Reporter.log("Germany-NOT IN Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
				softAssert.assertTrue(eneditLegal.businessStructure().getAttribute("class").contains(req),eneditLegal.businessStructure().getAttribute("class")+",Field is not mandatory");
				
				dataMap.put("EditCancel", "");
				eneditProfile.formAction(dataMap);
				
			}
			
			
			das=" Delete from CustomerMetadata where CustomerID="+customerid+" and ProfileMetadataID=1700";
			lavanteUtils.UpdateDB(das);
			query2="delete from SavedSearch where QueryName like '%"+qname+"%'"; 
			lavanteUtils.UpdateDB(query2);
			
			flag=true;
			
			
		}else{
			Reporter.log("No Supplier Found for this Search");
			
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for CTI Search at:"+LavanteUtils.currenttime());
	}
	
	/** SIM-6146
	 * IN operator
	 * 
	 * @param dataMap
	 * //@Throws InvalidFormatException
	 * //@Throws IOException
	 * //@Throws SQLException 
	 */
	@Test(dataProvider="CountryOfReg",dataProviderClass=SupplierSearchDataProvider.class)
	public void INmultiple(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Adv Search-------------------");

		Reporter.log("Test Started to check for United states,canada by using IN operator:"+LavanteUtils.currenttime());
		SoftAssert softAssert =new SoftAssert();
		String das=" update CustomerMetadata SET IsMandatoryField = 0   where ProfileMetadataID=1700 and CustomerID="+customerid;
		lavanteUtils.UpdateDB(das);
		
		String desc="Auto"+LavanteUtils.randomnum();
		String query1="Insert into VirtualGroup (XML_CR,Description) VALUES ('<SearchCriterias><SearchCriteria><ColumnId><![CDATA[countryOfRegistration]]></ColumnId><Operator><![CDATA[IN]]></Operator><Value><![CDATA[840,124,887]]></Value></SearchCriteria></SearchCriterias>','"+desc+"')";
		String query2="select VirtualGroupID from VirtualGroup where Description like '%"+desc+"%';";
		
		lavanteUtils.UpdateDB(query1);
		String id=lavanteUtils.fetchDBdata(query2);

		String mandQuery="Insert into CustomerMetadata (CustomerID  ,ProfileMetadataID  ,IsMandatoryField   ,IsVisibleField  ,IsNotifyField  ,VirtualGroupID  ,IsOnlyVirtualGroup,GroupID,GroupValue,IsNotEqualTo) "
				+ "VALUES ("+customerid+",1700,1,1,1,"+id+",1,0,0,0)";
		
		System.out.println("MAND"+mandQuery);
		lavanteUtils.UpdateDB(mandQuery);
		
		Reporter.log("IN Query inserted into db for the following country: United states,canada");
		
		System.out.println(dataMap.size()+"DAS"+dataMap);
		
		Reporter.log("Tested started for united states:");
		
		boolean flag=false;
		
		String qname="AutoSP"+LavanteUtils.randomnum();
		
		dataMap.put("SaveQuery","");
		dataMap.put("saveqryname",qname);
		dataMap.put("SavetheQuery","");
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		query2="delete from SavedSearch where SavedSearchCriteria like '%840%' and SavedSearchCriteria like '%countryOfRegistration%' and CustomerID="+customerid; 
		lavanteUtils.UpdateDB(query2);
		
		ensupplierAdvanced.buildQuery(dataMap);	
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.supplist().size()>0){
			Reporter.log("Query Returned with Search data");
			
			
			dataMap.put("profile", "");
			dataMap.put("editProfile", "");
			/*		
			 query1="   delete from VirtualGroup where VirtualGroupID="+id+"";
			 mandQuery= " delete from CustomerMetadata where VirtualGroupID="+id+"";
			  */
			
			query2="delete from SavedSearch where QueryName like '%"+qname+"%'"; 
			lavanteUtils.UpdateDB(query2);
			String sup=enobjsupplierPage.VerifyManagedBy();
			Reporter.log("US SUpplier:"+sup);
			dataMap.put("supplierName", sup);
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
			dataMap.put("tab", "Company");
			eneditProfile.selectTab(dataMap);
			
			lavanteUtils.waitForTime(3000);
			lavanteUtils.fluentwait(eneditLegal.businessStructure());
			String req="required";
			Reporter.log("US Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
			softAssert.assertTrue(eneditLegal.businessStructure().getAttribute("class").contains(req),"Field is not mandatory");
		
			dataMap.put("EditCancel", "");
			eneditProfile.formAction(dataMap);
			
			lavanteUtils.fluentwait(enobjsupplierBasicSearch.BasicSearchTab);
			lavanteUtils.click(enobjsupplierBasicSearch.BasicSearchTab);
			
			lavanteUtils.waitForTime(7000);
			String canadaSuppname="Snew0706";
			Reporter.log("Tested started for canada:"+canadaSuppname);
			
			dataMap.put("supplierName", canadaSuppname);
			dataMap.put("Search", "");			
			enobjsupplierBasicSearch.search(dataMap);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
			
			if(enobjsupplierPage.supplist().size()>0){
				
				
				enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

				lavanteUtils.waitForTime(3000);
				eneditProfile.selectTab(dataMap);
				
				lavanteUtils.waitForTime(3000);
				lavanteUtils.fluentwait(eneditLegal.businessStructure());
				
				Reporter.log("Canada Business Structure field:"+eneditLegal.businessStructure().getAttribute("class"));
				softAssert.assertTrue(eneditLegal.businessStructure().getAttribute("class").contains(req),"Exp Field is mandatory,Actual:"+eneditLegal.businessStructure().getAttribute("class"));
				flag=true;
				dataMap.put("EditCancel", "");
				eneditProfile.formAction(dataMap);
				
				}
			
			
			das=" Delete from CustomerMetadata where CustomerID="+customerid+" and ProfileMetadataID=1700";
			lavanteUtils.UpdateDB(das);
			
			query2="delete from SavedSearch where QueryName like '%"+qname+"%'"; 
			lavanteUtils.UpdateDB(query2);
			
			
			
			
		}else{
			Reporter.log("No Supplier Found for this Search");
			
		}
		
		if(flag==false){
			softAssert.assertTrue(false,"DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for CTI Search at:"+LavanteUtils.currenttime());
	}

	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		enobjhomePage.backtoSearch();
		lavanteUtils.refreshPage();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
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

