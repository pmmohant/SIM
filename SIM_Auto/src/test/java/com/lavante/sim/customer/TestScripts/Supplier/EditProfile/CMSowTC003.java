package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.CMDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 6-3-2016
 * Created for SOW Test case
 * Enhancement covered SIM-7531
 * Ended on 8-3-2016
 * @author Piramanayagam.S
 *
 */
public class CMSowTC003 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
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
		
		List listofdatafrm=lavanteUtils.login("SOW-1",browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		
		String sname="select MAX(su.SupplierName) from StatementOfWork s, Relationship R,Supplier su,MasterServiceAgreement m "
				+ " where s.MSAID=m.MSAID and r.RelationShipID=m.RelationShipID and r.LavanteUID=su.LavanteUID "
				+ " and r.CustomerID="+customerID;
		sname=lavanteUtils.fetchDBdata(sname);
		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
			
		//To Start the Test from Contract Management Tab
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
			
		dataMap.put("Search", "");
		dataMap.put("supplierName", sname);
		
		enobjhomePage.selectTab(dataMap);
		enobjsupplierBasicSearch.search(dataMap);		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
		dataMap.put("tab", "enterpriseContract");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
	
		Reporter.log("Supplier Name:"+sname,true);
	}
	
	
	/**SIM-7531
	 * Verify if “Request Management System (RMS)” custom field is added for SOW pop-up
	*  
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleSOWData",dataProviderClass=CMDataProvider.class)
	public void RMaddSOW001(LinkedHashMap<String,String> dataMap ) throws Exception{	
		Reporter.log("------------Test Started for “Request Management System (RMS)” custom field is added for SOW pop-up:-"+currenttime());
	
		dataMap.put("save", "");
		boolean flag=false;
		
		SoftAssert softassert=new SoftAssert();
		
		//TO uniquely identify the SOW
		String sowdesc="SP";
		sowdesc=dataMap.get("SOWDescription")+randomnum();
		dataMap.put("SOWDescription",sowdesc);
		dataMap.put("SOWSave", "");

		String sowRMSNo="SP";
		sowRMSNo=sowRMSNo+randomnum();
		dataMap.put("SOWRMSNo", sowRMSNo);
		dataMap.put("CustomerID",customerID);
		eneditContractManagement.AddSOW(dataMap);

		for(int i=eneditContractManagement.SOWDesclist().size()-1;i>=0;i--){
			if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
				{		
						String appsowno=eneditContractManagement.SOWnolist().get(i).getText();
						
						Reporter.log("sowRMS verification in  SOW table Expected,"+sowRMSNo+",Actuals:"+appsowno);
						softassert.assertTrue(appsowno.contains(sowRMSNo),"sow number Not matched");
						flag=true;
				}
		}
			
		if(flag==false){
			softassert.assertTrue(false,"Please Add DATA and RETEST");
		}

		softassert.assertAll();
		Reporter.log("Test ended for  “Request Management System (RMS)” custom field is added for SOW pop-up:"+currenttime());
	}

	/**SIM-7531
	 * Verify if user is able to edit & save the RMS number using “Edit” option for SOW pop-up
	*
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleSOWData",dataProviderClass=CMDataProvider.class)
	public void RMEdit002(LinkedHashMap<String,String> dataMap ) throws Exception{	
		Reporter.log("Test Started to check whether user is able to edit & save the RMS number using “Edit” option for SOW pop-up:"+currenttime());
		boolean flag=false;
		
		SoftAssert softassert=new SoftAssert();
		
		//TO uniquely identify the SOW
		String sowdesc="SP";
		sowdesc=dataMap.get("SOWDescription")+randomnum();			
		dataMap.put("SOWDescription",sowdesc);
		dataMap.put("SOWSave", "");

		String sowRMSNo="SP";
		sowRMSNo=sowRMSNo+randomnum(999);
		dataMap.put("SOWRMSNo", sowRMSNo);
		dataMap.put("CustomerID",customerID);
		eneditContractManagement.AddSOW(dataMap);

		for(int i=eneditContractManagement.SOWDesclist().size()-1;i>=0;i--){
			if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
				{		
			
				Reporter.log("Added SOW Available in the List");	
				int j=i+1;
				String select="tr:nth-child("+j+") a[title*='Edit Statement']";
				lavanteUtils.click(driver.findElement(By.cssSelector(select)));
				lavanteUtils.waitForTime(4000);
				
				lavanteUtils.switchtoFrame(eneditContractManagement.SOWEditIframe());
				
				Reporter.log("In edit Page:");
				
				String sowRMSNo1="SP";
				sowRMSNo1=sowRMSNo1+randomnum(468);
				
				dataMap.clear();
				dataMap.put("SOWSave", "");
				dataMap.put("CustomerID",customerID);
				dataMap.put("SOWRMSNo", sowRMSNo1);
				
				eneditContractManagement.fillSOWDetails(dataMap, "");
				eneditContractManagement.formActionSOW(dataMap);
				
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.waitForTime(5000);
				lavanteUtils.fluentwait(eneditContractManagement.addSOWnwBtn());
				
				for(int n=eneditContractManagement.SOWDesclist().size()-1;n>=0;n--){
					if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(n).getText()))
						{	
							lavanteUtils.waitForTime(3000);
							Reporter.log("Edited SOW available in the List");
							String appsow=eneditContractManagement.SOWnolist().get(n).getText();
							Reporter.log("Original RMS number:"+sowRMSNo+" is edited in edit sow pop up and New RMS is :"+sowRMSNo1+",In app SOW number is Updated with RMS No:"+appsow);
							softassert.assertTrue(appsow.contains(sowRMSNo1),"RMS number not matched");	
							flag=true;
							break;
						}
					}
				}
						
							
		}
			
		
		if(flag==false){
			softassert.assertTrue(false,"Please Add DATA and RETEST");
			
		}
		

		softassert.assertAll();
		Reporter.log("Test ended for  “Request Management System (RMS)” custom field is added for SOW pop-up:"+currenttime());
	}

	/** SIM-7531
	 * Verify if “Request Management System (RMS)” custom field is added for SOW pop-up
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleSOWData",dataProviderClass=CMDataProvider.class)
	public void RMcustomsow003(LinkedHashMap<String,String> dataMap ) throws Exception{	
		Reporter.log("Test Started for Request Management System (RMS) custom field for SOW pop-up:"+currenttime());
		SoftAssert softassert=new SoftAssert();
		String query1="Update CFE_Definition SET  IsVisible = '1'  where CFE_PageInfoID=2 and Label_i18nKey like '%RequestManagementNumber%' ";
		lavanteUtils.UpdateDB(query1);

		dataMap.clear();
		eneditContractManagement.createSOW(dataMap, "");
		
		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(eneditContractManagement.SOWAddIframe());
		
		Reporter.log("Request Management System (RMS)” custom field for SOW ,Expected:0 , Actuals:"+driver.findElements(By.id("SOWRMSno")).size());
		softassert.assertFalse(driver.findElements(By.id("SOWRMSno")).size()>0,"RMS ");
		
		
		String query="Update CFE_Definition SET   IsVisible = '1'  where CFE_PageInfoID=2 and Label_i18nKey like '%RequestManagementNumber%' ";
		lavanteUtils.UpdateDB(query);

		softassert.assertAll();
		Reporter.log("Test ended for Request Management System (RMS) custom field for SOW pop-up:"+currenttime());
	}

	/**SIM-7531
	 * Verify whether MSA mumber and sow number with RMS is displayed in deliverable table or not
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELRMSSOW004(LinkedHashMap<String,String> dataMap ) throws Exception{	
		Reporter.log("Test Started to check whether MSA mumber and sow number with RMS is displayed in deliverable at"+currenttime());
		boolean flag=false;
		
		SoftAssert softassert=new SoftAssert();
		
		//TO uniquely identify the SOW
		String sowdesc="SP";
		sowdesc=dataMap.get("SOWDescription")+randomnum();
		dataMap.put("SOWDescription",sowdesc);
		dataMap.put("SOWSave", "");

		String sowRMSNo="SP";
		sowRMSNo=sowRMSNo+randomnum();
		dataMap.put("SOWRMSNo", sowRMSNo);
		dataMap.put("save", "");
		dataMap.put("CustomerID",customerID);
		eneditContractManagement.AddSOW(dataMap);
		Reporter.log("Added SOW");
		for(int i=eneditContractManagement.SOWDesclist().size()-1;i>=0;i--){
			if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
				{		
						String appsowno=eneditContractManagement.SOWnolist().get(i).getText();
						String msano=eneditContractManagement.SOWmsanolist().get(i).getText();
						
						dataMap.put("save", "");
						eneditContractManagement.createDeliverable(dataMap, msano, appsowno);
						Reporter.log("Created deliverable for the Created SOW");
						int deliverable=3879;
						deliverable=eneditContractManagement.deliverable;
						String del=""+deliverable;
						
						lavanteUtils.waitForTime(2000);
						for(int j=eneditContractManagement.DELnolist().size()-1;j>=0;j--){
							if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(j).getText()))
								{
									Reporter.log("Created deliverable available in the list");
									String appsow=eneditContractManagement.DELsownolist().get(j).getText();
									String appmsa=eneditContractManagement.DELmsanolist().get(j).getText();
									
									Reporter.log("MSA number in deliverable table,Expected :"+msano+",In app:"+appmsa);
									softassert.assertEquals(appmsa,msano,"MSA num not matched");
									Reporter.log("sow number in deliverable table with RMS ,Expected :"+appsowno+",In app:"+appsow);
									softassert.assertEquals(appsow,appsowno,"sow num not matched");
									flag=true;
									break;
								}
							
					}
					 
				}
						
							
		}
			
		
		if(flag==false){
			softassert.assertTrue(false,"Please Add DATA and RETEST");
			
		}
		

		softassert.assertAll();
		Reporter.log("Test ended to check whether MSA mumber and sow number with RMS is displayed in deliverable table :"+currenttime());
	}

	
	/**
	 * After MEthod
	 */
	 @AfterMethod
	public void aftermethod(){
		 refreshPage();
		 enobjhomePage.popupclose();
		
	}
	
	/**
	 * After Class close the driver and logout from the application
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		enobjhomePage.close();
		enobjhomePage.logout();
		
		quitBrowser();
	}


}

