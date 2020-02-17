/*package com.lavante.sim.customer.TestScripts.Tasks.Payments;


import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
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
public class  PaymentQntoAns01 extends PageInitiator  {
	
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
		dataMap.put("subtab", "Workflow=17");
		enobjhomePage.selectTab(dataMap);
		
		if(!(enTaskinvoicestoApprve.iterateSearchHeaderFindColList("Invoice Type").size()>0)){
			LdataMap.put("filterby","Payment questions to answer");
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
		dataMap.put("subtab", "Workflow=17");
		enobjhomePage.selectTab(dataMap);
	}
	
	 *//**
	  *  Respond Payment question can be deleted PaymentSubmitQNto anstest
	 *//*	
	//Inmvalid@Test
	public void RespondPaymentQn() throws Exception
	{
		
		Reporter.log("Test Started for Respond  Payment Qn :"+currenttime());
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
				String PaymentNum=enPaymentQntoAnswer.selectSupplierFormAction(dataMap);
				String InvNum="";
				if(dataMap.containsKey("InvNum")){
					InvNum=dataMap.get("InvNum");
				}
				
				String expComment="AutoSP"+randomnum();
				dataMap.put("EnterComment",expComment);
				objPaymentsPage.CommentSearch(dataMap);
				dataMap.remove("EnterComment");
				
				dataMap.put("maintab", "Transactions");
				dataMap.put("subtab", "PaymentResult");
				enobjhomePage.selectTab(dataMap);
				
				dataMap.put("InvoiceNumber", InvNum);
				dataMap.put("PaymentRefNo", PaymentNum);
				dataMap.put("Search", "");
				objPaymentsPage.basicSearch(dataMap);
				
				String getPayRefNo = objPaymentsPage.getColumnText("Payment Ref No", 0);
				String getInvoiceNumber = objPaymentsPage.getColumnText("Invoice Number", 0);

				Reporter.log("Payment Ref NO is not equall to the searched , Expected : "+ PaymentNum + ", Actual : " + getPayRefNo);
				softAssert.assertEquals(getPayRefNo, PaymentNum,	"Payment Ref NO is not equall to the searched Supplier ERP ID, Expected : "+ PaymentNum + ", Actual : " + getPayRefNo);
			
				Reporter.log("Inv Num is not equall to the searched, Expected : "+ InvNum + ", Actual : " + getInvoiceNumber);
				softAssert.assertEquals(getInvoiceNumber, InvNum,	"Inv Num is not equall to the , Expected : "+ InvNum + ", Actual : " + getInvoiceNumber);
			
				objPaymentsPage.clickColText("Payment Ref No", PaymentNum);

				String actualComment ="";
				List<WebElement> privateComments = objViewPaymentsPage.PublicCommentsList();
				for (int j = 0; i < privateComments.size(); i++) {
					actualComment = privateComments.get(j).getText();
					if (actualComment.equals(expComment)) {
						flag = true;
						Reporter.log("Comment added, Expected :" + expComment + ", Actual :" + actualComment);
						softAssert.assertTrue(flag, "Mismatch in the comment added and searched , Expected :" + expComment	+ ", Actual :" + actualComment);
						break outr;
					}
				}
			
			}
		}	
			
		if(flag==false){
			softAssert.assertTrue(false,"Please add data and RETEST");
		}
		
		softAssert.assertAll();
		Reporter.log("Test ended for  Respond  Payment Qn :"+currenttime());
		
	}
			
	@AfterClass
	public void SetupafterClassmethod(){
		
		enobjhomePage.logout();
		quitBrowser();
	}



}

*/