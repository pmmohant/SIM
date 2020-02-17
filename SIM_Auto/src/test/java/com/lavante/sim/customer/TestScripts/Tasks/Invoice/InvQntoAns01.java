/*package com.lavante.sim.customer.TestScripts.Tasks.Invoice;


import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;


*//**
 * Created on 19-04-2018
 * Created for Invoice Qn To Answer
 *  * Ended on 19-04-2018
 * @author Piramanayagam.S
 *
 *//*
public class  InvQntoAns01 extends PageInitiator  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();	
	
	*//**
	 * This class all test starts using login page and driver initialization
	 * @author Piramanayagam.S
	 * 
	 *//*
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP1();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		List<?> listofdatafrm=lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Tasks");
		dataMap.put("subtab", "Workflow=10");
		enobjhomePage.selectTab(dataMap);
		
		if(!(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size()>0)){
			LdataMap.put("filterby","Invoice questions to answer");
			LdataMap.put("ALLSupplier","");
			LdataMap.put("ReAssign","");
			LdataMap.put("AssginTo","User");
			String x="Select lr.UserRoleName From Login l,LoginRole lr where l.ContactID in (select ContactID From contact where Email ='"+LdataMap.get("username")+"') "
					+ " and lr.UserRoleID=l.UserRoleID";
			x=lavanteUtils.fetchDBdata(x);
			String uname=x+"("+LdataMap.get("username")+")";
			LdataMap.put("User",uname); 
			enReassign.selectSupplierFormAction(LdataMap);
		}
	}

	@BeforeMethod
	public void Before(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Tasks");
		dataMap.put("subtab", "Workflow=10");
		enobjhomePage.selectTab(dataMap);
	}
	
	 *//**
	  *  
	 *//*	
	@Test
	public void RespondInvoiceQn() throws Exception
	{
		
		Reporter.log("Test Started for Respond  Invoice Qn :"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		boolean flag = false;

		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();

		int x=enobjhomePage.TotalPage().size();
		if(x==0){
			x=1;
		}
		outr:for(int ji=0;ji<x;ji++){
			for(int i=0;i<enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size();i++){
				dataMap.put("Respond","");
			//	String invnum=enInvoiceQntoAnswer.selectSupplierFormAction(dataMap);
				String suppName="";
				if(dataMap.containsKey("SupplierName")){
					suppName=dataMap.get("SupplierName");
				}
				
				String expComment="AutoSP"+randomnum();
				dataMap.put("EnterComment",expComment);
				eninvoicePage.CommentSearch(dataMap);
				dataMap.remove("EnterComment");
				
				dataMap.put("maintab","Invoice");
				dataMap.put("subtab", "InvoiceSearchResult");
				enobjhomePage.selectTab(dataMap);
				
			//	dataMap.put("InvNum",invnum);
				dataMap.put("SuppName",suppName);
				dataMap.put("Search","");
				eninvoiceBasicSearch.Search(dataMap);
				
				
				lavanteUtils.click(eninvoicePage.invComments());
				
				for(int j=0;j<eninvoicePage.CommentComment().size();j++){
					String actComment=eninvoicePage.CommentComment().get(j).getText();
					
					if(actComment.equalsIgnoreCase(expComment)){
						Reporter.log("Comment for Invoice to Respond,Actuals:"+actComment+",Expected:"+expComment,true);
						flag=true;
						break outr;
					}
					
					
				}
			
			}
	
		}
	
		if(flag==false){
			softAssert.assertTrue(false,"Please add data and RETEST");
		}
		
		softAssert.assertAll();
		Reporter.log("Test ended for  Respond  Invoice Qn :"+currenttime());
		
	}
			
	@AfterClass
	public void SetupafterClassmethod(){
		
		enobjhomePage.logout();
		quitBrowser();
	}



}

*/