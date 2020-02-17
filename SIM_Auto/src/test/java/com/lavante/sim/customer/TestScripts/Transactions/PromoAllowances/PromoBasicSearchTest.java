package com.lavante.sim.customer.TestScripts.Transactions.PromoAllowances;

import java.util.LinkedHashMap;
import java.util.List;


import org.openqa.selenium.WebElement;
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

public class PromoBasicSearchTest extends PageInitiator{

	LavanteUtils lavanteUtils=new LavanteUtils();	
	String customerID="";
	
	/**
	 * This class all test starts using login page and driver initialization
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception
	{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openQAAPP3();	
		lavanteUtils.driver=driver;
		
		List<?> listofdatafrm=lavanteUtils.login("Kroger",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = fetchCustomer(LdataMap.get("username"));
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
	}
	
	@BeforeMethod
	public void setup() {
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","TRANSACTIONS");
		dataMap.put("subtab", "Promo");
		
		enobjhomePage.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
		
		dataMap.put("Clear","");
		objPromoPage.formAction(dataMap);
	}
	
	/**
	 * Do a basic search using single criteria
	 * 
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void BasicSearchSingleCriteria() throws Exception
	{
		
		Reporter.log("Test Started for Basic Search for single criteria: "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		String expdata = "1";
		dataMap.put("InvoiceNumber", expdata);
		dataMap.put("Search","");
		objPromoPage.Search(dataMap);
		
		List<WebElement> criteria = objPromoPage.iterateSearchHeaderFindColList("Offer number");
		if(criteria.size()>0) {
			for(int i=0;i<criteria.size();i++) {
				System.out.println("Search results, Expected: "+expdata+" Actual: "+criteria.get(i).getText());
				Reporter.log("Search results, Expected: "+expdata+" Actual: "+criteria.get(i).getText());
				softassert.assertTrue(criteria.get(i).getText().contains(expdata),"Search results are not matching, Expected: "+expdata+" Actual: "+criteria.get(i).getText());
				flag = true;
				 break;
			}
		} else {
			softassert.assertEquals("No results", objPromoPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Promo Search for single criteria: "+currenttime());
	}
	
	/**
	 * Do a basic search using multiple criteria
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void BasicSearchMultipleCriteria() throws Exception
	{
		
		Reporter.log("Test Started for Basic Search for multiple criteria: "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		String expdata = "1";
		String expSuppName = "s";
		dataMap.put("InvoiceNumber", expdata);
		dataMap.put("SupplierName",expSuppName);
		dataMap.put("Search","");
		objPromoPage.Search(dataMap);
		
		List<WebElement> invoiceNumberList = objPromoPage.iterateSearchHeaderFindColList("Invoice number");
		List<WebElement> suppNameList = objPromoPage.iterateSearchHeaderFindColList("Supplier name");
		if(invoiceNumberList.size()>0) {
			for(int i=0;i<invoiceNumberList.size();i++) {
				System.out.println("Search results, Expected: "+expdata+" Actual: "+invoiceNumberList.get(i).getText());
				Reporter.log("Search results, Expected: "+expdata+" Actual: "+invoiceNumberList.get(i).getText());
				softassert.assertTrue(invoiceNumberList.get(i).getText().contains(expdata),"Search results are not matching, Expected: "+expdata
						+" Actual: "+invoiceNumberList.get(i).getText());
				softassert.assertTrue(suppNameList.get(i).getText().contains(expSuppName) ,"Search results are not matching, Expected: "+expSuppName
						+" Actual: "+suppNameList.get(i).getText());
				flag = true;
				break;
			}
		} else {
			softassert.assertEquals("No results", objPromoPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for multiple criteria: "+currenttime());
	}
	
	/**
	 * Do a Comment for the Promo record,Verify by clicking on the comment icon
	 * 
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void AddComment() throws Exception
	{
		Reporter.log("Test Started for Promo record : "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		String expInvdata = "1";
		String expPromoID = "s";
		
		List<WebElement> invoiceNumberList = objPromoPage.iterateSearchHeaderFindColList("Invoice number");
		
		if(invoiceNumberList.size()>0) {
			outr:for(int i=0;i<invoiceNumberList.size();i++) {
				System.out.println(i);
				lavanteUtils.waitForTime(5000);
				expInvdata=objPromoPage.iterateSearchHeaderFindColList("Invoice number").get(i).getText();
				expPromoID =  objPromoPage.iterateSearchHeaderFindColList("Promo ID").get(i).getText();
				
				dataMap.put("Action", "AddComment");
				String comm="Auto"+currenttime();
				dataMap.put("EnterComment", comm);
				dataMap.put("PublicComment", "");
				objPromoPage.action(dataMap);
				
				lavanteUtils.refreshPage();
				
				dataMap.put("InvoiceNumber", expInvdata);
				dataMap.put("Search","");
				objPromoPage.Search(dataMap);
				
				List<WebElement> promoList = objPromoPage.iterateSearchHeaderFindColList("Promo ID");
				
				if(promoList.size()>0) {
					for(int ik=0;ik<promoList.size();ik++) {
						String actInvdata="";
						actInvdata=promoList.get(ik).getText();
						
						if(actInvdata.equalsIgnoreCase(expPromoID));
							Reporter.log("Promo Search results, Expected: "+expPromoID+" Actual: "+actInvdata,true);
							softassert.assertTrue(actInvdata.contains(expPromoID),"Promo Search results are not matching, Expected: "+expPromoID	+" Actual: "+expInvdata);
							
							actInvdata=objPromoPage.iterateSearchHeaderFindColList("Invoice number").get(ik).getText();
							Reporter.log("Inv Search results, Expected: "+expInvdata+" Actual: "+actInvdata,true);
							softassert.assertTrue(actInvdata.contains(expInvdata),"Inv Search results are not matching, Expected: "+expInvdata	+" Actual: "+expInvdata);
							
							objPromoPage.clickColText("comment");
							
							for(int si=0;si<objPromoPage.PublicCommentsList().size();si++){
								String actComm=objPromoPage.PublicCommentsList().get(si).getText();
								
								if(actComm.equalsIgnoreCase(comm))
								{
									Reporter.log("Promo Search results, Expected: "+comm+" Actual: "+actComm,true);
									softassert.assertTrue(actComm.contains(comm),"Promo Search results are not matching, Expected: "+comm	+" Actual: "+actComm);
									
									flag=true;
									break outr;
								}
							}
					}
				}
			}
		} else {
			softassert.assertEquals("No results", objPromoPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
			
		
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for single criteria and clear the search: "+currenttime());
	}

	/**
	 * Do a basic Clear search ,Do a Search Note down the count, Clear the search
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void BasicClearSearchCriteria() throws Exception
	{
		
		Reporter.log("Test Started for Basic Clear Search : "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		String expSuppName = "s";
		dataMap.put("SupplierName",expSuppName);
		dataMap.put("Search","");
		objPromoPage.Search(dataMap);
		
		List<WebElement> invoiceNumberList = objPromoPage.iterateSearchHeaderFindColList("Invoice number");
		List<WebElement> suppNameList = objPromoPage.iterateSearchHeaderFindColList("Supplier name");
		if(invoiceNumberList.size()>0) {
			for(int i=0;i<invoiceNumberList.size();i++) {
				Reporter.log("Search results, Expected: "+expSuppName+" Actual: "+invoiceNumberList.get(i).getText());
				softassert.assertTrue(suppNameList.get(i).getText().toLowerCase().contains(expSuppName.toLowerCase()) ,"Search results are not matching, Expected: "+expSuppName+",Actual: "+suppNameList.get(i).getText());
				flag = true;
				
				String expCount=objPromoPage.pgCount().getText().trim();
				int count=lavanteUtils.getCount(expCount);
				
				dataMap.remove("SupplierName");
				dataMap.remove("Search");
				dataMap.put("Clear","");
				objPromoPage.Search(dataMap);
				
				expCount=objPromoPage.pgCount().getText().trim();
				int actcount=lavanteUtils.getCount(expCount);
				
				Reporter.log(actcount+",Actual,Expected:"+count,true);
				softassert.assertNotEquals(actcount,count ,"Search results are matching, Expected: "+actcount+",Actual: "+count);
				break;
				
			}
		} else {
			softassert.assertEquals("No results", objPromoPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
				
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Clear Search : "+currenttime());
	}
		
	/**
	 * Select the Invoice Record ,Create a Draft Claim for the Promo Invoice,Verification on Invoice page
	 * 
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void SavePromoClaim() throws Exception
	{
		Reporter.log("Test Started for Create Claim for Promo : "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		List<WebElement> invoiceNumberList = objPromoPage.iterateSearchHeaderFindColList("Invoice number");
		
		if(invoiceNumberList.size()>0) {
			outr:for(int i=0;i<invoiceNumberList.size();i++) {
				lavanteUtils.click(objPromoPage.iterateSearchHeaderFindColList("Invoice number").get(i));
				
				List<String> xx=objViewInvoicePage.fetchAssClaimValue("Claim Type");
				
				String xclaimType=null;
				for(int j=0;j<xx.size();j++){
					String dixclaimType="'"+xx.get(j)+"'";
					if(j==0 && dixclaimType.length()>2){
						xclaimType=dixclaimType;
					}else if(j>0  && j<xx.size() && dixclaimType.length()>0 ){
						xclaimType=xclaimType+","+dixclaimType;
					}
				}
				
				if(xclaimType!=null){
					String c="select Min(ClaimType) from claimType where ClaimtypeID in ( "
							+ " select ClaimtypeID From ClaimType_Category_Map where ClaimCategoryKVID=18802) "
							+ "and ClaimType not in ("+xclaimType+") and IsActive=1 and CustomerID="+customerID;
					xclaimType=lavanteUtils.fetchDBdata(c);
				}
				
				lavanteUtils.click(objViewInvoicePage.CreateClaimBtn());
				
				String ExpAmnt="200";
				dataMap.put("ClaimType",xclaimType);
				dataMap.put("ClaimDesc","ANY");
				dataMap.put("ClaimAmount",ExpAmnt);
				dataMap.put("SaveClaim","");
				objCreateClaimPage.createClaim(dataMap);
				
			//	lavanteUtils.refreshPage();
				lavanteUtils.fluentwait(objViewInvoicePage.CreateClaimBtn());
				xx=objViewInvoicePage.fetchAssClaimValue("Claim Type");
				
				for(int j=0;j<xx.size();j++){
					String dixclaimType=xx.get(j);
					if(dixclaimType.equalsIgnoreCase(xclaimType)){
						softassert.assertEquals(xclaimType, dixclaimType,"Claim Type Not Matched");
						Reporter.log("Claim Type Created:"+dixclaimType+",Exp:"+xclaimType,true);
						
						xx=objViewInvoicePage.fetchAssClaimValue("Claim Status");
						dixclaimType=xx.get(j);
						softassert.assertEquals("Open", dixclaimType,"Claim Status Not Matched");
						Reporter.log("Claim Status Created:"+dixclaimType+",Exp:Open",true);
						
						xx=objViewInvoicePage.fetchAssClaimValue("Claim Category");
						dixclaimType=xx.get(j);
						softassert.assertEquals("Promo allowance claims", dixclaimType,"Claim Category Not Matched");
						Reporter.log("Claim Category Created:"+dixclaimType+",Exp:Promo allowance claims",true);
						
						xx=objViewInvoicePage.fetchAssClaimValue("Claim Amount");
						dixclaimType=xx.get(j);
						softassert.assertTrue(dixclaimType.contains(ExpAmnt),"Claim Category Not Matched");
						Reporter.log("Claim Amnt Created:"+dixclaimType+",Exp:Promo allowance claims",true);
						
						flag=true;
						break outr;
					}
				}
				
			}
		} else {
			softassert.assertEquals("No results", objPromoPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
			
		
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for single criteria and clear the search: "+currenttime());
	}

	/**
	 * Select the Invoice Record ,Create a Submit Claim for the Promo Invoice,Verification on Invoice page
	 * 
	 * @author Piramanayagam.S
	 * @throws Exception
	 */
	@Test
	public void SubmitPromoClaim() throws Exception
	{
		Reporter.log("Test Started for Create Claim for Promo : "+currenttime());
		LinkedHashMap<String , String> dataMap = new LinkedHashMap<>();
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		
		List<WebElement> invoiceNumberList = objPromoPage.iterateSearchHeaderFindColList("Invoice number");
		
		if(invoiceNumberList.size()>0) {
			outr:for(int i=0;i<invoiceNumberList.size();i++) {
				lavanteUtils.click(objPromoPage.iterateSearchHeaderFindColList("Invoice number").get(i));
				
				List<String> xx=objViewInvoicePage.fetchAssClaimValue("Claim Type");
				
				String xclaimType=null;
				for(int j=0;j<xx.size();j++){
					String dixclaimType="'"+xx.get(j)+"'";
					if(j==0 && dixclaimType.length()>2){
						xclaimType=dixclaimType;
					}else if(j>0  && j<xx.size() && dixclaimType.length()>0 ){
						xclaimType=xclaimType+","+dixclaimType;
					}
				}
				
				if(xclaimType!=null){
					String c="select Min(ClaimType) from claimType where ClaimtypeID in ( "
							+ " select ClaimtypeID From ClaimType_Category_Map where ClaimCategoryKVID=18802) "
							+ "and ClaimType not in ("+xclaimType+") and IsActive=1 and CustomerID="+customerID;
					xclaimType=lavanteUtils.fetchDBdata(c);
				}
				
				lavanteUtils.click(objViewInvoicePage.CreateClaimBtn());
				
				String ExpAmnt="200";
				dataMap.put("ClaimType",xclaimType);
				dataMap.put("ClaimDesc","ANY");
				dataMap.put("ClaimAmount",ExpAmnt);
				dataMap.put("SubmitClaim","");
				objCreateClaimPage.createClaim(dataMap);
				
			//	lavanteUtils.refreshPage();
				lavanteUtils.fluentwait(objViewInvoicePage.CreateClaimBtn());
				xx=objViewInvoicePage.fetchAssClaimValue("Claim Type");
				
				for(int j=0;j<xx.size();j++){
					String dixclaimType=xx.get(j);
					if(dixclaimType.equalsIgnoreCase(xclaimType)){
						softassert.assertEquals(xclaimType, dixclaimType,"Claim Type Not Matched");
						Reporter.log("Claim Type Created:"+dixclaimType+",Exp:"+xclaimType,true);
						
						xx=objViewInvoicePage.fetchAssClaimValue("Claim Status");
						dixclaimType=xx.get(j);
						softassert.assertEquals("Pending", dixclaimType,"Claim Status Not Matched");
						Reporter.log("Claim Status Created:"+dixclaimType+",Exp:Pending",true);
						
						xx=objViewInvoicePage.fetchAssClaimValue("Claim Category");
						dixclaimType=xx.get(j);
						softassert.assertEquals("Promo allowance claims", dixclaimType,"Claim Category Not Matched");
						Reporter.log("Claim Category Created:"+dixclaimType+",Exp:Promo allowance claims",true);
						
						xx=objViewInvoicePage.fetchAssClaimValue("Claim Amount");
						dixclaimType=xx.get(j);
						softassert.assertTrue(dixclaimType.contains(ExpAmnt),"Claim Category Not Matched");
						Reporter.log("Claim Amnt Created:"+dixclaimType+",Exp:Promo allowance claims",true);
						
						flag=true;
						break outr;
					}
				}
				
			}
		} else {
			softassert.assertEquals("No results", objPromoPage.NoData().getText());
			flag = true;
		}
		
		if(flag == false) {
			Reporter.log("Search results are not matching");
		}
			
		
		softassert.assertAll();
		Reporter.log("Test Ended for Verification of Basic Claims Search for single criteria and clear the search: "+currenttime());
	}
	
	
	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.refreshPage();
	}
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}
}
