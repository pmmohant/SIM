package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 16-12-2015
 * Created for Deliverable Test case
 * Enhancement covered SIM -7108 ,SIM-7340,SIM-7341
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class CMdelTC002 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
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
		
		List listofdatafrm=lavanteUtils.login("DEL-1", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID=(String) listofdatafrm.get(1);
		
		
		String sname="select MAX(su.SupplierName) from Deliverable d,StatementOfWork s, Relationship R,Supplier su,MasterServiceAgreement m "
				+ " where s.MSAID=m.MSAID and r.RelationShipID=m.RelationShipID and r.LavanteUID=su.LavanteUID and d.SowID=s.SowID "
				+ " and r.CustomerID="+customerID;
		sname=lavanteUtils.fetchDBdata(sname);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
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

	}
	

	/**
	 * Verify in the Edit page,

			Cancelled option available or not
			Yes ,available or not
			No,available or not
			Notes on YES ,available or not
			NOTES ON NO,available or not
			 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void VerifyEditCancelDeliverable001(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for CANCEL Deliverable:"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=3879;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		
		for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
						lavanteUtils.click(eneditContractManagement.DELedit().get(i));
						lavanteUtils.waitForTime(4000);
						lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
						//lu.switchtoFrame(dp.DELEditIframe());
						lavanteUtils.waitForTime(2000);
						String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
								+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
								+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
						
						String id=lavanteUtils.fetchDBdata(query);
						String query2="  select UTFString from UserTranslation as u where LanguageID='50'  and "
								+ " UTFString like '%Canc%' and LanguageID='50' and i18nKey like '%deliverable.tx%'";
						
						String appstring=lavanteUtils.fetchDBdata(query2);
						String canstring="//label[contains(@for,'"+id+"')]";
						String leng=driver.findElement(By.xpath(canstring)).getText();
						String nwleng=null;
						if(leng.contains(":"))
						{
						String[] das=leng.split(":");
						nwleng=das[0];
						}
	
						//Verify Cancelled label
						softassert.assertEquals(nwleng,appstring,
								"Deliverable Cancelled Option  available"+nwleng+appstring);


						//Verify YES/NO and CAncelled Notes option
						String canststring="//label[contains(@for,'"+id+"')]/../..//td[2]//label";
						List<WebElement> el=driver.findElements(By.xpath(canststring));
						
						for(int ji=0;ji<el.size();ji++)
						{ 	System.out.println(ji);
							String status=el.get(ji).getText();
							System.out.println(status);
							
							if(status.equalsIgnoreCase("YES")){
								
								softassert.assertEquals(status,"Yes",
										"Deliverable Cancelled YES button  available");
								
								
								driver.findElement(By.cssSelector("#"+id+":nth-child(1)")).click();
								
								String query3="  select UTFString from UserTranslation as u where LanguageID='50'  and "
										+ " UTFString like '%Not%' and LanguageID='50' and i18nKey like '%deliverable.tx%'";
								
								String appstring2=lavanteUtils.fetchDBdata(query3);
								appstring2=appstring2+":";
								String nquery="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
										+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
										+ "UTFString like '%Note%' and LanguageID='50')  and CFE_PageInfoID='3';";
								String ntsid=lavanteUtils.fetchDBdata(nquery);
							
								String ntsstrng="//label[contains(@for,'"+ntsid+"')]";
								System.out.println("B$" +driver.findElement(By.xpath(ntsstrng)).getText()+appstring2);

								softassert.assertEquals(driver.findElement(By.xpath(ntsstrng)).getText(),appstring2,
										"Deliverable Cancelled Notes  available"+driver.findElement(By.xpath(ntsstrng)).getText()+appstring2);
								
								
								}else{
									
									softassert.assertEquals(status,"No",
											"Deliverable Cancelled No button  available"+status+"No");
									driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).click();
									lavanteUtils.waitForTime(2000);
									
									String nquery="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
											+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
											+ "UTFString like '%Note%' and LanguageID='50')  and CFE_PageInfoID='3';";
									String ntsid=lavanteUtils.fetchDBdata(nquery);
								
									String ntsstrng="//label[contains(@for,'"+ntsid+"')]";
									softassert.assertFalse(driver.findElement(By.xpath(ntsstrng)).isDisplayed(),"Notes available for No option");
									
									
								}
						}
						
						
						flag=true;
				}	
		}
		
		if(flag==false)
		{
			softassert.assertTrue(false,"Data not matched");
			
		}

		softassert.assertAll();
		
	
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}
	
	/**
	 * Cancelled deliverable- Valiadte notes and yes error message
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	//@Test(dataProvider="VERIFYCANCEL",dataProviderClass=CMDataProvider.class)
	public void CancelDeliverable002(LinkedHashMap<String,String> dataMap) throws Exception{	
		
		Reporter.log("Test Started for Cancel Deliverable:"+LavanteUtils.currenttime());
		SoftAssert softAssert=new SoftAssert();
		
		Reporter.log(""+dataMap);
		boolean flag=false;
		dataMap.put("save", "");		
		eneditContractManagement.AddDelievarable(dataMap);
				
		if(dataMap.containsKey("DELCancelled"))
		{ 
			String status=dataMap.get("DELCancelled");
			if(status.equalsIgnoreCase("YES"))
			{
				if(dataMap.containsKey("DELCancelledNotes"))
				{
					
				} else{ 
					lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
					String errmsg=eneditContractManagement.DELgetValidErrormsg().getText();
					Reporter.log("Error message for Mandatory Notes,In app:"+errmsg);
					softAssert.assertEquals(errmsg, dataMap.get("errormsg"),"Error message for cancelled not matching");
					flag=true;
				}
			} else{
				/*	lu.switchtoFrame(cmm.DELIframe());
				softAssert.assertTrue(cmm.DELCancelledYES().isDisplayed(), "YES IS SELECTED for CANCELLED");
				softAssert.assertTrue(cmm.DELCancelledNO().isDisplayed(), "NO IS SELECTED  for CANCELLED");
				*/
				flag=true;
			}

		} else{ 
			if(dataMap.containsKey("errormsg"))
			{
				lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
				String errmsg=eneditContractManagement.DELgetValidErrormsg().getText();
				Reporter.log("Error message for Mandatory Cancelled,In app:"+errmsg);
				softAssert.assertEquals(errmsg, dataMap.get("errormsg"),"Cancelled Error message   not matching");
				flag=true;
			}
		}
		
	
		
		if(flag==false)
		{
			softAssert.assertTrue(false,"Data not matched");
			
		}
		
		softAssert.assertAll();
		Reporter.log("Test Ended for Cancel Deliverable:"+LavanteUtils.currenttime());
	}
	
	/**
	 * Cancel Deliverable- Validate Label fields for notes and Cancelled 
	 * Getting ID from database due to Cancelled is Custom fields
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws SQLException 
	 */
	//@Test(dataProvider="CANCEL",dataProviderClass=CMDataProvider.class)
	public void CancelDeliverableview003(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for CANCEL Deliverable view"+LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=5390;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
					Reporter.log("Created Deliverable available in the list");
					if(dataMap.containsKey("DELCancelled"))
					{ 
						lavanteUtils.click(eneditContractManagement.DELnolist().get(i));
						lavanteUtils.switchtoFrame(eneditContractManagement.DELIframeView());
						lavanteUtils.waitForTime(2000);
						String status=dataMap.get("DELCancelled");
						String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
								+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
								+ "UTFString like '%Can%' and LanguageID='50'and i18nKey like '%deliverable.tx%')  and CFE_PageInfoID='3';";
						
						String id=lavanteUtils.fetchDBdata(query);
						String canxpath="//label[contains(@for,'"+id+"')]/../..//td[2]";
						System.out.println(canxpath);
						String canclledstatus=driver.findElement(By.xpath(canxpath)).getText();
						System.out.println(canclledstatus);
						if(status.equalsIgnoreCase("YES"))
						{ 
							String notes=dataMap.get("DELCancelledNotes");
							
							String query2="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
									+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
									+ "UTFString like '%Notes%' and LanguageID='50' and i18nKey like '%deliverable.tx%')  and CFE_PageInfoID='3';";
							
							String cannotes=lavanteUtils.fetchDBdata(query2);
					//		
							String cancllednotes="//label[contains(@for,'"+cannotes+"')]/../..//td[2]";
							System.out.println(cancllednotes);
							String cancelledNotes=driver.findElement(By.xpath(cancllednotes)).getText();
							Reporter.log("Cancelled Status Verification"+canclledstatus);
							softAssert.assertEquals(canclledstatus, status,"YES STATUS NOT MATHCED");
										
							Reporter.log("Cancelled Notes for Yes Verification"+cancelledNotes);		
							softAssert.assertEquals(cancelledNotes, notes,"Notes NOT MATHCED");
							flag=true;
									
							}	 else		{
								Reporter.log("Cancelled Status Verification:"+canclledstatus);
								softAssert.assertEquals(canclledstatus, status,"YES STATUS NOT MATHCED");
							
							flag=true;
							}			
						}
				}
			
		}
		
		
		if(flag==false)
		{
			softAssert.assertTrue(false,"Data not matched");
			
		}
		softAssert.assertAll();
		Reporter.log("Test Ended"+LavanteUtils.currenttime());
	}
	
	/**
	 * Cancel Deliverable- Validate Label fields for notes and Cancelled 
	 * Getting ID from database due to Cancelled is Custom fields
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws SQLException 
	 */
	//@Test(dataProvider="CANCEL",dataProviderClass=CMDataProvider.class)
	public void CancelDeliverableEdit004(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for CANCEL Deliverable-------------------");
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=5390;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
	
		for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
					Reporter.log("Created Deliverable available in the list");
					if(dataMap.containsKey("DELCancelled"))
					{ 
						lavanteUtils.click(eneditContractManagement.DELedit().get(i));
						lavanteUtils.fluentwait(eneditContractManagement.DELEditIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
						lavanteUtils.waitForTime(2000);
						Reporter.log("In edit Delivearbale page:");
						String status=dataMap.get("DELCancelled");
						String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
								+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
								+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
						String id=lavanteUtils.fetchDBdata(query);
						
						if(status.equalsIgnoreCase("YES"))
						{ 
							String canxpath="input[id*='"+id+"']~label:first-of-type";
							System.out.println(canxpath);
							String canclledstatus=driver.findElement(By.cssSelector(canxpath)).getText();
							System.out.println(canclledstatus);
							
							String notes=dataMap.get("DELCancelledNotes");
							
							String query2="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
									+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
									+ "UTFString like '%Notes%' and LanguageID='50')  and CFE_PageInfoID='3';";
							
							String cannotes=lavanteUtils.fetchDBdata(query2);
					//		
							String cancllednotes="textarea[id*='"+cannotes+"']";
							String cancelledNotes=driver.findElement(By.cssSelector(cancllednotes)).getText();
							
								
								softAssert.assertEquals(canclledstatus, "Yes","YES STATUS NOT MATHCED");
										
									
								softAssert.assertEquals(cancelledNotes, notes,"Notes NOT MATHCED");
								flag=true;
									
							}	 else{ //FOR NO

								String canxpath="input[id*='"+id+"']+*~label";
								System.out.println(canxpath);
								String canclledstatus=driver.findElement(By.cssSelector(canxpath)).getText();
								System.out.println(canclledstatus);
								softAssert.assertEquals(canclledstatus, "No","No STATUS NOT MATHCED");
								flag=true;
							}			
						}
				}
			
		}
		
		
		if(flag==false)
		{
			softAssert.assertTrue(false,"Data not matched");
			
		}
		softAssert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}
			
	/**
	 * Cancel Deliverable- Validate Label fields for notes and Cancelled 
	 * Getting ID from database due to Cancelled is Custom fields
	 * and verifying in Copy page
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws SQLException 
	 */
	//@Test(dataProvider="CANCEL",dataProviderClass=CMDataProvider.class)
	public void CancelDeliverableCopy005(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for CANCEL Deliverable:"+LavanteUtils.currenttime());
		
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		SoftAssert softAssert=new SoftAssert();
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=5390;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
	
		for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
					Reporter.log("Created Deliverable available in the list");
					if(dataMap.containsKey("DELCancelled"))
					{ 
						lavanteUtils.click(eneditContractManagement.DELCopy().get(i));
						
						lavanteUtils.fluentwait(eneditContractManagement.DELIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
						
						Reporter.log("In Copy Deliverable:");
						
						lavanteUtils.waitForTime(2000);
						String status=dataMap.get("DELCancelled");
						String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
								+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
								+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
						String id=lavanteUtils.fetchDBdata(query);
						
						if(status.equalsIgnoreCase("YES"))
						{ 
							String canxpath="input[id*='"+id+"']~label:first-of-type";
							System.out.println(canxpath);
							String canclledstatus=driver.findElement(By.cssSelector(canxpath)).getText();
							System.out.println(canclledstatus);
							
							String notes=dataMap.get("DELCancelledNotes");
							
							String query2="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
									+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
									+ "UTFString like '%Notes%' and LanguageID='50')  and CFE_PageInfoID='3';";
							
							String cannotes=lavanteUtils.fetchDBdata(query2);
					//		
							String cancllednotes="textarea[id*='"+cannotes+"']";
							System.out.println(cancllednotes);
							String cancelledNotes=driver.findElement(By.cssSelector(cancllednotes)).getText();
							
								System.out.println(cancelledNotes+canclledstatus);
								
								softAssert.assertEquals(canclledstatus, "Yes","YES STATUS NOT MATHCED");
										
									
								softAssert.assertEquals(cancelledNotes, notes,"Notes NOT MATHCED");
							flag=true;
									
							}	 else{ //FOR NO

								String canxpath="input[id*='"+id+"']+*~label";
								System.out.println(canxpath);
								String canclledstatus=driver.findElement(By.cssSelector(canxpath)).getText();
								System.out.println(canclledstatus);
								softAssert.assertEquals(canclledstatus, "No","No STATUS NOT MATHCED");
							
							flag=true;
							}			
						}
				}
			
		}
		
		
		if(flag==false)
		{
			softAssert.assertTrue(false,"Data not matched");
			
		}else{
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.click(eneditContractManagement.DELviewClose());
		}
		softAssert.assertAll();
		System.out.println("----------Test Ended----------------");
	}
			
	/**
	 * Verify in the Copy page,

			Cancelled option available or not
			Yes ,available or not
			No,available or not
			Notes on YES ,available or not
			NOTES ON NO,available or not
			
			Notes: Test is failing because Notes available in No option 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void CopyCancelDeliverable006(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for CopyCANCEL Deliverable"+LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=30;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;

		SoftAssert softassert=new SoftAssert();
		
		lavanteUtils.waitForTime(2000);
		
		for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
						Reporter.log("Created deliverable available in the list");
						lavanteUtils.click(eneditContractManagement.DELCopy().get(i));
						lavanteUtils.waitForTime(4000);
						lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='copy']")));
						//lu.switchtoFrame(dp.DELEditIframe());
						lavanteUtils.waitForTime(2000);
						String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
								+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
								+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
						
						String id=lavanteUtils.fetchDBdata(query);
						String query2="  select UTFString from UserTranslation as u where LanguageID='50'  and "
								+ " UTFString like '%Canc%' and LanguageID='50' and i18nKey like '%deliverable.tx%'";
						
						String appstring=lavanteUtils.fetchDBdata(query2);
						String canstring="//label[contains(@for,'"+id+"')]";
						String leng=driver.findElement(By.xpath(canstring)).getText();
						String nwleng=null;
						if(leng.contains(":"))
						{
						String[] das=leng.split(":");
						nwleng=das[0];
						}
	
						//Verify Cancelled label
						softassert.assertEquals(nwleng,appstring,
								"Deliverable Cancelled Option  available"+nwleng+appstring);


						//Verify YES/NO and CAncelled Notes option
						String canststring="//label[contains(@for,'"+id+"')]/../..//td[2]//label";
						List<WebElement> el=driver.findElements(By.xpath(canststring));
						
						for(int ji=0;ji<el.size();ji++)
						{ 	System.out.println(ji);
							String status=el.get(ji).getText();
							System.out.println(status);
							
							if(status.equalsIgnoreCase("YES")){
								
								softassert.assertEquals(status,"Yes",
										"Deliverable Cancelled YES button  available");
								
								
								driver.findElement(By.cssSelector("#"+id+":nth-child(1)")).click();
								
								String query3="  select UTFString from UserTranslation as u where LanguageID='50'  and "
										+ " UTFString like '%Not%' and LanguageID='50' and i18nKey like '%deliverable.tx%'";
								
								String appstring2=lavanteUtils.fetchDBdata(query3);
								appstring2=appstring2+":";
								String nquery="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
										+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
										+ "UTFString like '%Note%' and LanguageID='50' and i18nKey like '%deliverable.tx%')  and CFE_PageInfoID='3';";
								String ntsid=lavanteUtils.fetchDBdata(nquery);
							
								String ntsstrng="//label[contains(@for,'"+ntsid+"')]";
								Reporter.log("Canceled Notes Verification, Expected:"+appstring2);
								softassert.assertEquals(driver.findElement(By.xpath(ntsstrng)).getText(),appstring2,
										"Deliverable Cancelled Notes  available"+driver.findElement(By.xpath(ntsstrng)).getText()+appstring2);
								
								
								}else{
									Reporter.log("Canceled status Verification Expected: NO, In App:"+status);
									softassert.assertEquals(status,"No",
											"Deliverable Cancelled No button  available"+status+"No");
									lavanteUtils.Scrollintoview(driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")));
									driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).click();
									lavanteUtils.waitForTime(2000);
									
									String nquery="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
											+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
											+ "UTFString like '%Note%' and LanguageID='50' and i18nKey like '%deliverable.tx%')  and CFE_PageInfoID='3';";
									String ntsid=lavanteUtils.fetchDBdata(nquery);
								
									String ntsstrng="//label[contains(@for,'"+ntsid+"')]";
									
									softassert.assertFalse(driver.findElement(By.xpath(ntsstrng)).isDisplayed(),"Notes available for No option");
									
									
								}
						}
						
						flag=true;
						break;
				}	
		}
		
		if(flag==false)
		{
			softassert.assertTrue(false,"Data not matched");
			
		}
		softassert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());
	}
	
	/**
	 * Verify in the Add page,

			Cancelled option available or not
			Yes ,available or not
			No,available or not
			Notes on YES ,available or not
			NOTES ON NO,available or not
			
			Notes: Test is failing because Notes available in No option 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test
	public void AddCancelDeliverableUI007() throws Exception{	
		Reporter.log("Test Started for verification in Add CANCEL Deliverable:"+LavanteUtils.currenttime());
		boolean flag=false;
		LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
		eneditContractManagement.AddDelievarable(dataMap);
		Reporter.log("In Add Deliveable Page:");
		
		lavanteUtils.waitForTime(2000);
		String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
				+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
				+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
		
		String id=lavanteUtils.fetchDBdata(query);
		String query2="  select UTFString from UserTranslation as u where LanguageID='50'  and "
				+ " UTFString like '%Canc%' and LanguageID='50' and i18nKey like '%deliverable.tx%'";
		
		String appstring=lavanteUtils.fetchDBdata(query2);
		String canstring="//label[contains(@for,'"+id+"')]";
		String leng=driver.findElement(By.xpath(canstring)).getText();
		String nwleng=null;
		if(leng.contains(":"))
		{
		String[] das=leng.split(":");
		nwleng=das[0];
		}
	
		//Verify Cancelled label
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Cancelled Option in Add deliverable:,Expected:"+appstring+"In app:"+nwleng);
		softassert.assertEquals(nwleng,appstring,"Deliverable Cancelled Option not available"+nwleng+appstring);


	//Verify YES/NO and CAncelled Notes option
	String canststring="//label[contains(@for,'"+id+"')]/../..//td[2]//label";
	List<WebElement> el=driver.findElements(By.xpath(canststring));
	
	for(int ji=0;ji<el.size();ji++)
	{ 	
		String status=el.get(ji).getText();
		System.out.println(status);
		
		if(status.equalsIgnoreCase("YES")){
			Reporter.log("Cancelled Option,Yes Status :"+status);
			softassert.assertEquals(status,"Yes",
					"Deliverable Cancelled YES button  available");
			
			
			driver.findElement(By.cssSelector("#"+id+":nth-child(1)")).click();
			
			String query3="  select UTFString from UserTranslation as u where LanguageID='50'  and "
					+ " UTFString like '%Not%' and LanguageID='50' and i18nKey like '%deliverable.tx%'";
			
			String appstring2=lavanteUtils.fetchDBdata(query3);
			appstring2=appstring2+":";
			String nquery="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
					+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
					+ "UTFString like '%Note%' and LanguageID='50' and i18nKey like '%deliverable.tx%')  and CFE_PageInfoID='3';";
			String ntsid=lavanteUtils.fetchDBdata(nquery);
		
			String ntsstrng="//label[contains(@for,'"+ntsid+"')]";

			Reporter.log("Cancelled Notes Label,"+appstring2+"in app:"+driver.findElement(By.xpath(ntsstrng)).getText());
			softassert.assertEquals(driver.findElement(By.xpath(ntsstrng)).getText(),appstring2,
					"Deliverable Cancelled Notes  available"+driver.findElement(By.xpath(ntsstrng)).getText()+appstring2);
			
			
			}else{
				Reporter.log("Cancelled Option,No Status :"+status);
				softassert.assertEquals(status,"No",
						"Deliverable Cancelled No button  available"+status+"No");
				lavanteUtils.Scrollintoview(driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")));
				driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).click();
				lavanteUtils.waitForTime(2000);
				
				String nquery="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
						+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
						+ "UTFString like '%Note%' and LanguageID='50' and i18nKey like '%deliverable.tx%')  and CFE_PageInfoID='3';";
				String ntsid=lavanteUtils.fetchDBdata(nquery);
			
				String ntsstrng="//label[contains(@for,'"+ntsid+"')]";
				Reporter.log("Cancelled Notes for False,in app:"+driver.findElement(By.xpath(ntsstrng)).getText());
				softassert.assertFalse(driver.findElement(By.xpath(ntsstrng)).isDisplayed(),"Notes available for No option");
				
			}
				
				
				flag=true;
		}	
		
		if(flag==false)
		{
			softassert.assertTrue(false,"Data not matched");
			
		}
		softassert.assertAll();
		Reporter.log("Test Ended at"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");
	}
	
	/**
	 * Edit the Cancelled field in the Edit page,
			
			if status is "NO" edit to "YES" and save the field
			if status is "YES" edit to "YES" and save the field
			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void EditCancelDeliverable008(LinkedHashMap<String,String> dataMap) throws Exception{	
	Reporter.log("Test Started for Edit Deliverable:"+LavanteUtils.currenttime());
	SoftAssert softassert=new SoftAssert();
	dataMap.put("save", "");
	dataMap.put("emptyDel", "");
	
	boolean flag=false;
	eneditContractManagement.AddDelievarable(dataMap);
	int deliverable=3879;
	deliverable=eneditContractManagement.deliverable;
	String del=""+deliverable;
	
	lavanteUtils.waitForTime(2000);

	for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
		if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
				Reporter.log("Created Deliverable available in the list");
					lavanteUtils.click(eneditContractManagement.DELedit().get(i));
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
					//lu.switchtoFrame(dp.DELEditIframe());
					Reporter.log("In Edit Delivearble Page");
					lavanteUtils.waitForTime(2000);
					String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
							+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
							+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
					
					String id=lavanteUtils.fetchDBdata(query);
					
					//Verify Cancelled label
					softassert.assertTrue(driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).isSelected(),"Edit is not working for cancelled option");
				
					//Edit YES/NO and Enter Cancelled Notes 
					//For YES Selection
					driver.findElement(By.cssSelector("#"+id+":nth-child(1)")).click();
					
					String ntsid=lavanteUtils.getCustomIDQUERY("Note","3",customerID);
					
					lavanteUtils.waitForTime(2000);
					driver.findElement(By.id(ntsid)).sendKeys("Automation notes");
					
					
					//Save and Verify
					dataMap.put("save","");
					eneditContractManagement.formActionDeliverable(dataMap);
					
					//To Edit for NO
					for(int si=eneditContractManagement.DELnolist().size()-1;si>=0;si--){
						System.out.println(del+eneditContractManagement.DELnolist().get(si).getText());
						if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(si).getText()))
							{
									Reporter.log("Edited Deliverable available in the list");
									lavanteUtils.click(eneditContractManagement.DELedit().get(si));
									lavanteUtils.waitForTime(4000);
									lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
									Reporter.log("In Edit Deliverable Page:");
									
									softassert.assertTrue(driver.findElement(By.cssSelector("#"+id+":nth-child(1)")).isSelected(),"Edit is not working for cancelled option");
									driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).click();
									
									eneditContractManagement.formActionDeliverable(dataMap);
									lavanteUtils.waitForTime(2000);
									Reporter.log("Modified the Cancelled Notes:");
									
									
									for(int jsi=eneditContractManagement.DELnolist().size()-1;jsi>=0;jsi--){
										System.out.println(del+eneditContractManagement.DELnolist().get(jsi).getText());
										if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(jsi).getText()))
											{
												Reporter.log("Edited Deliverable available in the list");
												lavanteUtils.click(eneditContractManagement.DELedit().get(si));
												lavanteUtils.waitForTime(4000);
												
												lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
												Reporter.log("In Edit Deliverable Page:");
												softassert.assertTrue(driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).isSelected(),"Edit is not working for cancelled option");
											
											}
									}
											}
									
							}
					}
					
			
					
					flag=true;
					break;
			}	
	
	if(flag==false)
	{
		softassert.assertTrue(false,"Data not matched");
		
	}
	softassert.assertAll();
	Reporter.log("Test Ended at:"+LavanteUtils.currenttime());
}
			
	/**
	 * After MEthod
	 */
	 @AfterMethod
	public void aftermethod(){
		 refreshPage();
		enobjhomePage.popupclose();
		
	}
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		enobjhomePage.logout();
		quitBrowser();
	}


}

