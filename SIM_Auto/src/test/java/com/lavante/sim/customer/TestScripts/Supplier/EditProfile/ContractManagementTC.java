/*package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.CMDataProvider;
import com.lavante.sim.customer.pageobjects.MyLoginpage;
import com.lavante.sim.customer.pageobjects.Myhomepage;
import com.lavante.sim.customer.pageobjects.PageInitiator;
import com.lavante.sim.customer.pageobjects.Suppliers.EditProfile.EditProfContractManagement;
import com.lavante.sim.customer.pageobjects.Suppliers.EditProfile.EditProfilePage;
import com.lavante.sim.customer.pageobjects.Suppliers.Search.SupplierBasicSearchPage;
import com.lavante.sim.customer.pageobjects.Suppliers.Search.SupplierPage;

*//**
 * Created on 16-12-2015
 * Created for Deliverable Test case
 * Enhancement covered SIM -7108 ,SIM-7340,SIM-7341
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 *//*
public class ContractManagementTC extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
	String customerID="";
	
	*//**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 *//*
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
		String uname="SCRnicare.admin@lavante.com";
		customerID=lavanteUtils.fetchCustomer(uname);
		LdataMap.put("username", uname);
		LdataMap.put("password", InitProperties("password"));
		LdataMap.put("title", "Lavante SIM - On-boarding");
		enobjloginpage.logintoAPP(LdataMap);
	
		enobjhomePage.close();
		
	
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		
		
		dataMap.put("Search", "");
		dataMap.put("supplierName", "SCREGUARD BY QBF");
		
		enobjhomePage.selectTab(dataMap);
		enobjsupplierBasicSearch.search(dataMap);		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
		dataMap.put("tab", "enterpriseContract");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);
	}


	*//**
	 * Cancel Deliverable- Validate Label fields for notes and Cancelled 
	 * Getting ID from database due to Cancelled is Custom fields
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws SQLException 
	 *//*
	//@Test(dataProvider="CANCEL",dataProviderClass=Adatatprovider.class)
	public void CancelDeliverableview013(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for CANCEL Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=5390;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
					if(dataMap.containsKey("DELCancelled"))
					{ 
						eneditContractManagement.DELnolist().get(i).click();
						lavanteUtils.switchtoFrame(eneditContractManagement.DELIframeView());
						lavanteUtils.waitForTime(2000);
						String status=dataMap.get("DELCancelled");
						String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
								+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
								+ "UTFString like '%Can%' and LanguageID='50')  and CFE_PageInfoID='3';";
						
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
									+ "UTFString like '%Notes%' and LanguageID='50')  and CFE_PageInfoID='3';";
							
							String cannotes=lavanteUtils.fetchDBdata(query2);
					//		
							String cancllednotes="//label[contains(@for,'"+cannotes+"')]/../..//td[2]";
							System.out.println(cancllednotes);
							String cancelledNotes=driver.findElement(By.xpath(cancllednotes)).getText();
							
								System.out.println(cancelledNotes+canclledstatus);
								
							Assert.assertEquals(canclledstatus, status,"YES STATUS NOT MATHCED");
										
									
							Assert.assertEquals(cancelledNotes, notes,"Notes NOT MATHCED");
							flag=true;
									
							}	 else		{
								Assert.assertEquals(canclledstatus, status,"YES STATUS NOT MATHCED");
							
							flag=true;
							}			
						}
				}
			
		}
		
		
		if(flag==false)
		{
			Assert.assertTrue(false,"Data not matched");
			
		}else{
			lavanteUtils.switchtoFrame(null);
			eneditContractManagement.DELviewClose().click();
			driver.switchTo().defaultContent();
			lavanteUtils.switchtoFrame(null);
		}
	
		System.out.println("----------Test Ended----------------");
	}
	
	*//**
	 * Cancel Deliverable- Validate Label fields for notes and Cancelled 
	 * Getting ID from database due to Cancelled is Custom fields
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws SQLException 
	 *//*
	//@Test(dataProvider="CANCEL",dataProviderClass=Adatatprovider.class)
	public void CancelDeliverableEdit013(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for CANCEL Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=5390;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
	
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
					if(dataMap.containsKey("DELCancelled"))
					{ 
						eneditContractManagement.DELedit().get(i).click();
						lavanteUtils.fluentwait(eneditContractManagement.DELEditIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
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
								
							Assert.assertEquals(canclledstatus, "Yes","YES STATUS NOT MATHCED");
										
									
							Assert.assertEquals(cancelledNotes, notes,"Notes NOT MATHCED");
							flag=true;
									
							}	 else{ //FOR NO

								String canxpath="input[id*='"+id+"']+*~label";
								System.out.println(canxpath);
								String canclledstatus=driver.findElement(By.cssSelector(canxpath)).getText();
								System.out.println(canclledstatus);
								Assert.assertEquals(canclledstatus, "No","No STATUS NOT MATHCED");
							
							flag=true;
							}			
						}
				}
			
		}
		
		
		if(flag==false)
		{
			Assert.assertTrue(false,"Data not matched");
			
		}else{
			lavanteUtils.switchtoFrame(null);
			eneditContractManagement.DELviewClose().click();
			driver.switchTo().defaultContent();
			lavanteUtils.switchtoFrame(null);
		}
	
		System.out.println("----------Test Ended----------------");
	}
			
	*//**
	 * Cancel Deliverable- Validate Label fields for notes and Cancelled 
	 * Getting ID from database due to Cancelled is Custom fields
	 * and verifying in Copy page
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws SQLException 
	 *//*
	//@Test(dataProvider="CANCEL",dataProviderClass=Adatatprovider.class)
	public void CancelDeliverableCopy014(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for CANCEL Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=5390;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
	
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
					if(dataMap.containsKey("DELCancelled"))
					{ 
						eneditContractManagement.DELCopy().get(i).click();
						
						lavanteUtils.fluentwait(eneditContractManagement.DELIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
						
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
								
							Assert.assertEquals(canclledstatus, "Yes","YES STATUS NOT MATHCED");
										
									
							Assert.assertEquals(cancelledNotes, notes,"Notes NOT MATHCED");
							flag=true;
									
							}	 else{ //FOR NO

								String canxpath="input[id*='"+id+"']+*~label";
								System.out.println(canxpath);
								String canclledstatus=driver.findElement(By.cssSelector(canxpath)).getText();
								System.out.println(canclledstatus);
								Assert.assertEquals(canclledstatus, "No","No STATUS NOT MATHCED");
							
							flag=true;
							}			
						}
				}
			
		}
		
		
		if(flag==false)
		{
			Assert.assertTrue(false,"Data not matched");
			
		}else{
			lavanteUtils.switchtoFrame(null);
			eneditContractManagement.DELviewClose().click();
			driver.switchTo().defaultContent();
			lavanteUtils.switchtoFrame(null);
		}
	
		System.out.println("----------Test Ended----------------");
	}
	
	*//**
	 * Verify in the Edit page,

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
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void VerifyEditCancelDeliverable014(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for CANCEL Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=3879;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
						eneditContractManagement.DELedit().get(i).click();
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
						SoftAssert softassert=new SoftAssert();
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
						
				
				softassert.assertAll();
						
						flag=true;
				}	
		}
		
		if(flag==false)
		{
			Assert.assertTrue(false,"Data not matched");
			
		}
	
		System.out.println("----------Test Ended----------------");
	}

	*//**
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
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void CopyCancelDeliverable015(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for CANCEL Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		dataMap.put("emptyDel", "");
		
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		int deliverable=30;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
				{
						eneditContractManagement.DELCopy().get(i).click();
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
						SoftAssert softassert=new SoftAssert();
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
						
				
				softassert.assertAll();
						
						flag=true;
				}	
		}
		
		if(flag==false)
		{
			Assert.assertTrue(false,"Data not matched");
			
		}
	
		System.out.println("----------Test Ended----------------");
	}
	
	*//**
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
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void AddCancelDeliverable016(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for verification in Add CANCEL Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
	
		boolean flag=false;
		eneditContractManagement.AddDelievarable(dataMap);
		
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
				
				softassert.assertAll();
				flag=true;
		}	
		
		if(flag==false)
		{
			Assert.assertTrue(false,"Data not matched");
			
		}
	
		System.out.println("----------Test Ended----------------");
	}
	
	*//**
	 * Edit the Cancelled field in the Edit page,
			
			if status is "NO" edit to "YES" and save the field
			if status is "YES" edit to "YES" and save the field
			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void EditCancelDeliverable017(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
	System.out.println("------------Test Started for Edit Deliverable-------------------");
	System.out.println(dataMap.size()+"DAS"+dataMap);
	System.out.println(LavanteUtils.currenttime());
	dataMap.put("save", "");
	dataMap.put("emptyDel", "");
	
	boolean flag=false;
	eneditContractManagement.AddDelievarable(dataMap);
	int deliverable=3879;
	deliverable=eneditContractManagement.deliverable;
	String del=""+deliverable;
	
	lavanteUtils.waitForTime(2000);

	SoftAssert softassert=new SoftAssert();
	for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
		System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
		if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
					eneditContractManagement.DELedit().get(i).click();
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
					//lu.switchtoFrame(dp.DELEditIframe());
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
					
					String ntsid=lavanteUtils.getCustomIDQUERY("Note","3","50");
					
					lavanteUtils.waitForTime(2000);
					driver.findElement(By.id(ntsid)).sendKeys("Automation notes");
					
					
					//Save and Verify
					dataMap.put("save","");
					eneditContractManagement.formActionDeliverable(dataMap);
					
					//To Edit for NO
					for(int si=0;si<eneditContractManagement.DELnolist().size();si++){
						System.out.println(del+eneditContractManagement.DELnolist().get(si).getText());
						if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(si).getText()))
							{
									eneditContractManagement.DELedit().get(si).click();
									lavanteUtils.waitForTime(4000);
									lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
									softassert.assertTrue(driver.findElement(By.cssSelector("#"+id+":nth-child(1)")).isSelected(),"Edit is not working for cancelled option");
									
									driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).click();
									
									eneditContractManagement.formActionDeliverable(dataMap);
									lavanteUtils.waitForTime(2000);
									
									for(int jsi=0;jsi<eneditContractManagement.DELnolist().size();jsi++){
										System.out.println(del+eneditContractManagement.DELnolist().get(jsi).getText());
										if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(jsi).getText()))
											{
												eneditContractManagement.DELedit().get(si).click();
												lavanteUtils.waitForTime(4000);
												lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
												softassert.assertTrue(driver.findElement(By.cssSelector("#"+id+":nth-child(1)~input")).isSelected(),"Edit is not working for cancelled option");
												
											}
									}
											}
									
							}
					}
					
			softassert.assertAll();
					
					flag=true;
			}	
	
	if(flag==false)
	{
		Assert.assertTrue(false,"Data not matched");
		
	}

	System.out.println("----------Test Ended----------------");
}
		
	
	*//**
	 * Status Field should not be available
		In Page	
			Add  deliverable,
			Edit  deliverable,
			Copy  deliverable,
			View  deliverable,
			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * 
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void StatusField018(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
	System.out.println("------------Test Started for Edit Deliverable-------------------");
	System.out.println(dataMap.size()+"DAS"+dataMap);
	System.out.println(LavanteUtils.currenttime());
	dataMap.put("save", "");
	dataMap.put("emptyDel", "");
	
	boolean flag=false;
	eneditContractManagement.AddDelievarable(dataMap);
	int deliverable=8411;
	deliverable=eneditContractManagement.deliverable;
	String del=""+deliverable;
	
	lavanteUtils.waitForTime(2000);

	SoftAssert softassert=new SoftAssert();
	for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
		System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
		if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
					eneditContractManagement.DELedit().get(i).click();
					lavanteUtils.waitForTime(4000);
					
					lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
					//Navigate every label available in the page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase("Status")){
								softassert.assertTrue(false,"Status field available in the edit page");
							}
					}
				
					dataMap.remove("save");
					dataMap.put("cancel", "");
					eneditContractManagement.formActionDeliverable(dataMap);
					lavanteUtils.waitForTime(4000);
					
					System.out.println(eneditContractManagement.DELCopy().size());
					eneditContractManagement.DELCopy().get(i).click();
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
					
					//Navigate every label available in the copy page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase("Status")){
								softassert.assertTrue(false,"Status field available in the edit page");
							}
					}
					
					eneditContractManagement.formActionDeliverable(dataMap);
					
					eneditContractManagement.adddelnwBtn().click();
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
					
					//Navigate every label available in the copy page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase("Status")){
								softassert.assertTrue(false,"Status field available in the edit page");
							}
					}
					
					lavanteUtils.waitForTime(4000);
					eneditContractManagement.formActionDeliverable(dataMap);
					
					eneditContractManagement.DELnolist().get(i).click();
					lavanteUtils.switchtoFrame(eneditContractManagement.DELIframeView());
					
					//Navigate every label available in the copy page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase("Status")){
								softassert.assertTrue(false,"Status field available in the edit page");
							}
					}
					lavanteUtils.waitForTime(4000);

					flag=true;
			}
	
			softassert.assertAll();
					
			}	
	
	if(flag==false)
	{
		Assert.assertTrue(false,"Data not matched");
		
	}

	System.out.println("----------Test Ended----------------");
}
		
	

	*//**
	 * Status Field should not be available
		In Page	
			Add  deliverable,
			Edit  deliverable,
			Copy  deliverable,
			View  deliverable,
			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * 
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void SOWTALLYField019(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
	System.out.println("------------Test Started for SOWTALLY FIELD-------------------");
	System.out.println(dataMap.size()+"DAS"+dataMap);
	System.out.println(LavanteUtils.currenttime());
	dataMap.put("save", "");
	//TO uniquely identify the SOW
	String sowdesc=dataMap.get("SOWDescription")+LavanteUtils.randomnum();
	dataMap.put("SOWDescription",sowdesc);
	
	boolean flag=false;
	eneditContractManagement.AddSOW(dataMap);
	
	lavanteUtils.waitForTime(2000);

	SoftAssert softassert=new SoftAssert();
	for(int i=0;i<eneditContractManagement.SOWDesclist().size();i++){
		System.out.println(i+sowdesc+eneditContractManagement.SOWDesclist().get(i).getText());
		if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
			{
					//dp.SOWEdit().get(i).click();
					int j=i+1;
					String select="tr:nth-child("+j+") a[title*='Edit Statement']";
					System.out.println(select);
					driver.findElement(By.cssSelector(select)).click();
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(eneditContractManagement.SOWEditIframe());
					lavanteUtils.switchtoFrame(eneditContractManagement.SOWEditIframe());
					//Navigate every label available in the page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{	String expstring="SOW Tally:";
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase(expstring)){
								softassert.assertTrue(true,"SOW TALLY field not available in the edit page");
							}
					}
				
					dataMap.remove("save");
					dataMap.put("cancel", "");
					eneditContractManagement.formActionDeliverable(dataMap);
					lavanteUtils.waitForTime(4000);
					
					
					eneditContractManagement.addSOWnwBtn().click();
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(eneditContractManagement.SOWAddIframe());
					lavanteUtils.switchtoFrame(eneditContractManagement.SOWAddIframe());
					
					//Navigate every label available in the copy page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{    String expstring="SOW Tally:";
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase(expstring)){
								softassert.assertTrue(false,"Status field available in the Add page");
							}
					}
					
					lavanteUtils.waitForTime(4000);
					eneditContractManagement.formActionDeliverable(dataMap);
					
					eneditContractManagement.SOWnolist().get(i).click();
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(eneditContractManagement.SOWEditIframe());
					lavanteUtils.switchtoFrame(eneditContractManagement.SOWEditIframe());
					
					//Navigate every label available in the copy page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{ String expstring="SOW Tally:";
							String applabel=eneditContractManagement.labellist().get(i).getText();
							if(applabel.equalsIgnoreCase(expstring)){
								softassert.assertTrue(true,"SOW TALLY field available in the View page");
							}
					}
					lavanteUtils.waitForTime(4000);

					flag=true;
					softassert.assertAll();
			}
	
			
					
			}	
	
	if(flag==false)
	{
		Assert.assertTrue(false,"Data not matched");
		
	}

	System.out.println("----------Test Ended----------------");
}
		
	
	*//**
	 * Add SOW, Verify all fields in eDIT page
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void SOWEdit020(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Edit Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		boolean flag=false;
	
		//TO uniquely identify the SOW
		String sowdesc="SP6605";
		sowdesc=dataMap.get("SOWDescription")+LavanteUtils.randomnum();
		dataMap.put("SOWDescription",sowdesc);
		
		eneditContractManagement.AddSOW(dataMap);
		
		SoftAssert softassert=new SoftAssert();
		
		for(int i=0;i<eneditContractManagement.SOWDesclist().size();i++){
			System.out.println(i+sowdesc+eneditContractManagement.SOWDesclist().get(i).getText());
			if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
				{		
						String sowNUM=eneditContractManagement.SOWnolist().get(i).getAttribute("title");
						
						int j=i+1;
						String select="tr:nth-child("+j+") a[title*='Edit Statement']";
						driver.findElement(By.cssSelector(select)).click();
						lavanteUtils.waitForTime(4000);
						
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.SOWEditIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.SOWEditIframe());		
						
						System.out.println(sowdesc+"+dp.SOWdescr()");

						String clientid=lavanteUtils.getCustomIDQUERY("client Name","2","50");
						String Creditid=lavanteUtils.getCustomIDQUERY("credit","2","50");
						String upfront=lavanteUtils.getCustomIDQUERY("up front","2","50");
						String attachsingle=lavanteUtils.getCustomIDQUERY("attach single","2","50");
						String attachany=lavanteUtils.getCustomIDQUERY("attach any","2","50");
						
						lavanteUtils.waitForTime(2000);
						
						//MSA
						softassert.assertEquals(eneditContractManagement.SOWViewMSAType().getText(),dataMap.get("MSATYPE"),
								eneditContractManagement.SOWViewMSAType().getText()+"DAS"+dataMap.get("MSATYPE")+ "MSA not matching");
						//MSA NUM
						softassert.assertEquals(eneditContractManagement.SOWViewMSANum().getText(),eneditContractManagement.MSANUMBER,
								eneditContractManagement.SOWViewMSANum().getText()+"DAS"+eneditContractManagement.MSANUMBER+ "MSAnum not matching");
						//SOW NUM	
						softassert.assertEquals(eneditContractManagement.SOWViewSOWNum().getText(),sowNUM,
								eneditContractManagement.SOWViewSOWNum().getText()+"DAS"+sowNUM+ "SOWNum not matching");
						
						//Description
						softassert.assertEquals(eneditContractManagement.SOWdescr().getAttribute("value"),sowdesc,
								eneditContractManagement.SOWdescr().getAttribute("value")+"DAS"+sowdesc+ "sowdesc not matching");
						//Internal Contact
						softassert.assertEquals(eneditContractManagement.SOWinternalContact().getAttribute("value"),dataMap.get("SOWInternalContact"),
								eneditContractManagement.SOWinternalContact().getAttribute("value")+":DAS"+dataMap.get("SOWInternalContact")+"Internal Contact not matching");
						//Notes
						softassert.assertEquals(eneditContractManagement.SOWNotes().getAttribute("value"),dataMap.get("SOWNotes"),
								eneditContractManagement.SOWNotes().getAttribute("value")+":DAS"+dataMap.get("SOWNotes")+"Internal Contact not matching");
						//Payment type
						softassert.assertEquals(eneditContractManagement.SOWpaymenttypedpdn().getText(),dataMap.get("SOWPaymentType"),
								eneditContractManagement.SOWpaymenttypedpdn().getText()+":DAS"+dataMap.get("SOWPaymentType")+"SOWPaymentType  not matching");
						//Payment terms
						softassert.assertEquals(eneditContractManagement.SOWpaymenttrmdpdn().getText(),dataMap.get("SOWPaymentTerms"),
								eneditContractManagement.SOWpaymenttrmdpdn().getText()+":DAS"+dataMap.get("SOWPaymentTerms")+"SOWPaymentTerms not matching");
						
						//Not to exceed amnt
						softassert.assertEquals(eneditContractManagement.SOWnotToExceedAmount().getAttribute("value"),dataMap.get("SOWNotToExecedAmnt"),
								eneditContractManagement.SOWnotToExceedAmount().getAttribute("value")+":ASD"+dataMap.get("SOWInternalContact")+"SOWNotToExecedAmnt not matching");
					
						//Custom Fields
						//Client name
						if(dataMap.containsKey("SOWClientName")){
						String clientname=driver.findElement(By.cssSelector("[id*='"+clientid+"'] a")).getText();
						
						softassert.assertEquals(clientname,dataMap.get("SOWClientName"),
								clientname+":DAS"+dataMap.get("SOWClientName")+"SOWClientName not matching");
						}
						
						if(dataMap.containsKey("SOWCreditCard")){
							WebElement credit=null;
						if(dataMap.get("SOWCreditCard").equalsIgnoreCase("ANY")||dataMap.get("SOWCreditCard").equalsIgnoreCase("NO"))
						{
						 credit=driver.findElement(By.cssSelector("[id*='"+Creditid+"']:nth-child(1)~input"));
						}else{
						 credit=driver.findElement(By.cssSelector("[id*='"+Creditid+"']:nth-child(1)"));
						}//Credit
						softassert.assertTrue(credit.isSelected(), "Credit radio button is not saved");
						}
						
						if(dataMap.containsKey("SOWUpfront")){
							WebElement up=null;
							if(dataMap.get("SOWUpfront").equalsIgnoreCase("ANY")||dataMap.get("SOWUpfront").equalsIgnoreCase("NO"))
							{
							 up=driver.findElement(By.cssSelector("[id*='"+upfront+"']:nth-child(1)~input"));
							}else{
								 up=driver.findElement(By.cssSelector("[id*='"+upfront+"']:nth-child(1)"));
							}
							//UP
							softassert.assertTrue(up.isSelected(), "UP Front radio button is not saved");
							
							
						}
						
						if(dataMap.containsKey("SOWsingleFile")){
							String Singlefile=driver.findElement(By.cssSelector("[id*='"+attachsingle+"'] a")).getText();
							System.out.println(Singlefile);
							softassert.assertTrue(Singlefile.contains(dataMap.get("SOWsingleFile")),
									"Single File doesnot contains"+dataMap.get("SOWsingleFile")+",but contains:"+Singlefile);
						}
						if(dataMap.containsKey("SOWmultiFile")){
							String s=dataMap.get("SOWmultiFile");
							if(s.contains("#"))
							{
								String[] sp=s.split("#");
								List<WebElement> multifile=driver.findElements(By.cssSelector("[id*='"+attachany+"'] a[href*='down']"));
								for(int el=0;el<multifile.size();el++)
								{
									String name=multifile.get(el).getText();
									System.out.println(name);
								
									System.out.println(multifile);
									for(int ij=0;ij<sp.length;ij++)
									{ 
										if(name.contains(sp[ij])){
											softassert.assertTrue(name.contains(sp[ij]),
												"multi File doesnot contains"+sp[ij]+"but contains"+multifile);
										}
									}
								}
							}
							
							
							
						}
					
						
						softassert.assertAll();
						flag=true;
			} 
		}
		
		if(flag==false){
				Assert.assertTrue(false,"DATA NOT AVAILABLE");
			
		}
		System.out.println("----------Test Ended----------------");
	}
	
	
	*//**
	 * Add SOW, Verify all fields in View page
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void SOWView021(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Edit Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		boolean flag=false;
	
		//TO uniquely identify the SOW
		String sowdesc="SP2257";
		sowdesc=dataMap.get("SOWDescription")+LavanteUtils.randomnum();
		dataMap.put("SOWDescription",sowdesc);
		
		eneditContractManagement.AddSOW(dataMap);
		
		SoftAssert softassert=new SoftAssert();
		
		for(int i=0;i<eneditContractManagement.SOWDesclist().size();i++){
			System.out.println(i+sowdesc+eneditContractManagement.SOWDesclist().get(i).getText());
			if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
				{		
						String sowNUM=eneditContractManagement.SOWnolist().get(i).getAttribute("title");
						
						eneditContractManagement.SOWnolist().get(i).click();
						
						lavanteUtils.waitForTime(4000);
						
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.SOWViewIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.SOWViewIframe());		
						
						System.out.println(sowdesc+"+dp.SOWdescr()");

						String clientid=lavanteUtils.getCustomIDQUERY("client Name","2","50");
						String Creditid=lavanteUtils.getCustomIDQUERY("credit","2","50");
						String upfront=lavanteUtils.getCustomIDQUERY("up front","2","50");
						String attachsingle=lavanteUtils.getCustomIDQUERY("attach single","2","50");
						String attachany=lavanteUtils.getCustomIDQUERY("attach any","2","50");
						
						lavanteUtils.waitForTime(2000);
						
						//MSA
						softassert.assertEquals(eneditContractManagement.SOWViewMSAType().getText(),dataMap.get("MSATYPE"),
								eneditContractManagement.SOWViewMSAType().getText()+"DAS"+dataMap.get("MSATYPE")+ "MSA not matching");
						//MSA NUM
						softassert.assertEquals(eneditContractManagement.SOWViewMSANum().getText(),eneditContractManagement.MSANUMBER,
								eneditContractManagement.SOWViewMSANum().getText()+"DAS"+eneditContractManagement.MSANUMBER+ "MSAnum not matching");
						//SOW NUM	
						softassert.assertEquals(eneditContractManagement.SOWViewSOWNum().getText(),sowNUM,
								eneditContractManagement.SOWViewSOWNum().getText()+"DAS"+sowNUM+ "SOWNum not matching");						
						//Description
						softassert.assertEquals(eneditContractManagement.SOWViewDesc().getText(),sowdesc,
								eneditContractManagement.SOWViewDesc().getText()+"DAS"+sowdesc+ "sowdesc not matching");
						//Internal Contact
						softassert.assertEquals(eneditContractManagement.SOWViewInternal().getText(),dataMap.get("SOWInternalContact"),
								eneditContractManagement.SOWViewInternal().getText()+":DAS"+dataMap.get("SOWInternalContact")+"Internal Contact not matching");
						//Notes
						softassert.assertEquals(eneditContractManagement.SOWViewNotes().getText(),dataMap.get("SOWNotes"),
								eneditContractManagement.SOWViewNotes().getText()+":DAS"+dataMap.get("SOWNotes")+"Internal Contact not matching");
						//Payment type
						softassert.assertEquals(eneditContractManagement.SOWViewPaymentyp().getText(),dataMap.get("SOWPaymentType"),
								eneditContractManagement.SOWViewPaymentyp().getText()+":DAS"+dataMap.get("SOWPaymentType")+"SOWPaymentType  not matching");
						//Payment terms
						softassert.assertEquals(eneditContractManagement.SOWViewPaymentTerms().getText(),dataMap.get("SOWPaymentTerms"),
								eneditContractManagement.SOWViewPaymentTerms().getText()+":DAS"+dataMap.get("SOWPaymentTerms")+"SOWPaymentTerms not matching");
					
						//Not to exceed amnt
						softassert.assertEquals(eneditContractManagement.SOWViewNottoExceed().getText(),dataMap.get("SOWNotToExecedAmnt"),
								eneditContractManagement.SOWViewNottoExceed().getText()+":ASD"+dataMap.get("SOWInternalContact")+"SOWNotToExecedAmnt not matching");
					
						//CUSTOM FIELDS
						//Client name
						if(dataMap.containsKey("SOWClientName")){
						String clientname=driver.findElement(By.xpath("//label[contains(@for,'"+clientid+"')]/../..//td[2]")).getText();
						
						softassert.assertEquals(clientname,dataMap.get("SOWClientName"),
								clientname+":DAS"+dataMap.get("SOWClientName")+"SOWClientName not matching");
						}
					
						if(dataMap.containsKey("SOWCreditCard")){
							String appcredit=driver.findElement(By.xpath("//*[@for='"+Creditid+"']/../../td[2]")).getText();
							String credit=null;
							if(dataMap.get("SOWCreditCard").equalsIgnoreCase("ANY")||dataMap.get("SOWCreditCard").equalsIgnoreCase("NO"))
							{
							 credit="No";
							}else{
							 credit="Yes";
							}//Credit
							softassert.assertTrue(credit.equalsIgnoreCase(appcredit), "Credit radio button is not saved");
						}
						
						if(dataMap.containsKey("SOWUpfront")){
							String up=null;
							String appup=driver.findElement(By.xpath("//*[@for='"+upfront+"']/../../td[2]")).getText();
							if(dataMap.get("SOWUpfront").equalsIgnoreCase("ANY")||dataMap.get("SOWUpfront").equalsIgnoreCase("NO"))
							{
							 up="No";
							}else{
								up="Yes";
							}
							//UP
							softassert.assertTrue(up.equalsIgnoreCase(appup), "Credit radio button is not saved");
							
						}
						
						if(dataMap.containsKey("SOWsingleFile")){
							
							String Singlefile=driver.findElement(By.xpath("//*[@for='"+attachsingle+"']/../..//td[2]//a")).getText();
							
							System.out.println(Singlefile);
							softassert.assertTrue(Singlefile.contains(dataMap.get("SOWsingleFile")),
									"Single File doesnot contains"+dataMap.get("SOWsingleFile")+",but contains:"+Singlefile);
						}
						if(dataMap.containsKey("SOWmultiFile")){
							String s=dataMap.get("SOWmultiFile");
							if(s.contains("#"))
							{
								String[] sp=s.split("#");
								List<WebElement> multifile=driver.findElements(By.cssSelector("[ng-controller*='"+attachany+"'] a[href*='down']"));
								for(int el=0;el<multifile.size();el++)
								{
									String name=multifile.get(el).getText();
									System.out.println(name);
								
									System.out.println(multifile);
									for(int ij=0;ij<sp.length;ij++)
									{ 
										if(name.contains(sp[ij])){
											softassert.assertTrue(name.contains(sp[ij]),
												"multi File doesnot contains"+sp[ij]+"but contains"+multifile);
										}
									}
								}
							}
							
							
							
						}
					
						
						softassert.assertAll();
						flag=true;
			} 
		}
		
		if(flag==false){
				Assert.assertTrue(false,"DATA NOT AVAILABLE");
			
		}
		System.out.println("----------Test Ended----------------");
	}

	
	*//**
	 * Add MSA, Verify all fields in eDIT page
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void MSAEdit022(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for MSA EDIT Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		boolean flag=false;
	
		//TO uniquely identify the SOW
		String msanottoexc="151,815.00";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(99);	
			dataMap.put("msanottoexceed",msanottoexc);
		} 
	
		
		
		eneditContractManagement.createMSA(dataMap);
		
		SoftAssert softassert=new SoftAssert();
		System.out.println(eneditContractManagement.MSAnottoexceedList().size());
		for(int i=0;i<eneditContractManagement.MSAnottoexceedList().size();i++){
			System.out.println(i+msanottoexc+eneditContractManagement.MSAnottoexceedList().get(i).getText());
			if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
				{		
						String msaNum=eneditContractManagement.MSANumTxt().get(i).getAttribute("title");
						
						int j=i+1;
						String select="tr:nth-child("+j+") a[title*='Edit Master']";
						driver.findElement(By.cssSelector(select)).click();
						lavanteUtils.waitForTime(4000);
						
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.IFRAMEMSAAddEdit());
						lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());		
						
						System.out.println(msanottoexc+"+MSA NOT EXEC()");

						String clientid=lavanteUtils.getCustomIDQUERY("client Name","1","50");
						
						lavanteUtils.waitForTime(2000);
						
						//Client name
						if(dataMap.containsKey("msaclient")){
						String clientname=driver.findElement(By.cssSelector("[id*='"+clientid+"'] a")).getText();
						
						softassert.assertEquals(clientname,dataMap.get("msaclient"),
								clientname+":DAS"+dataMap.get("msaclient")+"MSA ClientName not matching");
						}
						
						
						//MSA
						if(dataMap.containsKey("addendum")){
							String expmsatype=null;
							String msatype=driver.findElement(By.xpath("//*[@class='field_required']")).getText();
							System.out.println(msatype);
							if(dataMap.get("addendum").equalsIgnoreCase("ANY")||dataMap.get("addendum").equalsIgnoreCase("NO"))
							{
							 expmsatype="MSA";
							}else{
								 expmsatype="Addendum";
							}
							//MSA
							softassert.assertTrue(msatype.contains(expmsatype),
								msatype+"DAS"+expmsatype+ "MSA not matching");
							
							
						}
						
						//MSA NUM	
						softassert.assertEquals(eneditContractManagement.MSAViewMSAnum().getText(),msaNum,
								eneditContractManagement.MSAViewMSAnum().getText()+"DAS"+msaNum+ "SOWNum not matching");
						
						//Start Date
						if(dataMap.containsKey("MSAstartdate")){
							if(dataMap.get("MSAstartdate").equalsIgnoreCase("ANY"))
							{
							//	softassert.assertEquals(dp.MSAstartDate().getAttribute("value"),msanottoexc,
								//		dp.MSAstartDate().getAttribute("value")+"DAS"+msanottoexc+ "sowdesc not matching");
							}
						}
						//Evergreen
						if(dataMap.containsKey("msaevergreen")){
							WebElement msagreen=null;
							if(dataMap.get("msaevergreen").equalsIgnoreCase("ANY")||dataMap.get("msaevergreen").equalsIgnoreCase("NO"))
							{
							 msagreen=driver.findElement(By.cssSelector("[name*='isEverGreenMSA']:nth-child(1)~input"));
							}else{
								 msagreen=driver.findElement(By.cssSelector("[name*='isEverGreenMSA']:nth-child(1)"));
							}
							//UP
							softassert.assertTrue(msagreen.isSelected(), "MSA Evergreen radio button is not saved");
							
							
						}
						//Not to exceed amnt
						softassert.assertEquals(eneditContractManagement.MSAnottoexceed().getAttribute("value"),dataMap.get("msanottoexceed"),
								eneditContractManagement.MSAnottoexceed().getAttribute("value")+":ASD"+dataMap.get("msanottoexceed")+"MSAnottoexceed not matching");
								

						//Status MSA
						softassert.assertEquals(eneditContractManagement.MSAStatusDpdn().getText(),dataMap.get("MSAstatus"),
								eneditContractManagement.MSAStatusDpdn().getText()+"DAS"+dataMap.get("MSAstatus")+ "MSA Status not matching");
						
						
						
						
						if(dataMap.containsKey("msaupload")){
							String Singlefile=driver.findElement(By.cssSelector("[id*=''] a")).getText();
							System.out.println(Singlefile);
							softassert.assertTrue(Singlefile.contains(dataMap.get("SOWsingleFile")),
									"Single File doesnot contains"+dataMap.get("SOWsingleFile")+",but contains:"+Singlefile);
						}
				}
					
						
						softassert.assertAll();
						flag=true;
			} 
		
		if(flag==false){
				Assert.assertTrue(false,"DATA NOT AVAILABLE");
			
		}
		System.out.println("----------Test Ended----------------");
	}
	
	
	*//**
	 * Add MSA, Verify all fields in View page
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=Adatatprovider.class)
	public void MSAView023(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for MSA EDIT Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		boolean flag=false;
	
		//TO uniquely identify the SOW
		
		String msanottoexc="17.38";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(99);	
			dataMap.put("msanottoexceed",msanottoexc);
		}
	
		
		
		eneditContractManagement.createMSA(dataMap);
		
		SoftAssert softassert=new SoftAssert();
		for(int i=0;i<eneditContractManagement.MSAnottoexceedList().size();i++){
			System.out.println(i+msanottoexc+eneditContractManagement.MSAnottoexceedList().get(i).getText());
			String labtxt;
			if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
				{		
					String msaNum=eneditContractManagement.MSANumTxt().get(i).getAttribute("title");
					
					eneditContractManagement.MSANumTxt().get(i).click();
					lavanteUtils.waitForTime(4000);
					
					lavanteUtils.switchtoFrame(null);
					lavanteUtils.fluentwait(eneditContractManagement.MSAViewIFRAME());
					lavanteUtils.switchtoFrame(eneditContractManagement.MSAViewIFRAME());		
					
					System.out.println(msanottoexc+"+MSA NOT EXEC()");
	
					lavanteUtils.waitForTime(2000);
						
						
					//MSA
					String appmsatext=eneditContractManagement.MSAViewMSAtype().getText();
					if(dataMap.containsKey("addendum")){
						String expmsatype=null;
						if(dataMap.get("addendum").equalsIgnoreCase("ANY")||dataMap.get("addendum").equalsIgnoreCase("NO"))
						{
						 expmsatype="MSA";
						}else{
							 expmsatype="Addendum";
						}
						//MSA
						softassert.assertTrue(appmsatext.equalsIgnoreCase(expmsatype),
								appmsatext+"DAS"+expmsatype+ "MSA not matching");
					}								
						
						//MSA NUM
					String appmsanum=eneditContractManagement.MSAViewMSAnum().getText();
					softassert.assertEquals(appmsanum,msaNum,
								appmsanum+","+msaNum+ "SOWNum not matching");
					
				 
					 String appEvergrentext=eneditContractManagement.MSAViewEvergreen().getText();
					//Evergreen
						if(dataMap.containsKey("msaevergreen")){
							String msagreen=null;
							if(dataMap.get("msaevergreen").equalsIgnoreCase("ANY")||dataMap.get("msaevergreen").equalsIgnoreCase("NO"))
							{
							 msagreen="NO";
							}else{
								 msagreen="YES";
							}
							//Green
							softassert.assertTrue(appEvergrentext.equalsIgnoreCase(msagreen), "MSA Evergreen radio button is not saved"+msagreen+","+appEvergrentext);
							
							
						}
					 
					 String appNttoexcedtext=eneditContractManagement.msaviewnttoexced().getText();
					 
					//Not to exceed amnt
					softassert.assertEquals(appNttoexcedtext,dataMap.get("msanottoexceed"),
							appNttoexcedtext+":ASD"+dataMap.get("msanottoexceed")+"MSAnottoexceed not matching");
						
					 String appStatustext=eneditContractManagement.MSAviewStatus().getText();
					//Status MSA
						softassert.assertEquals(appStatustext,dataMap.get("MSAstatus"),
								appStatustext+"DAS"+dataMap.get("MSAstatus")+ "MSA Status not matching");
						
					 String appupload=eneditContractManagement.MSAViewUpload().getText();
					 if(dataMap.containsKey("msaupload")){
								softassert.assertTrue(appupload.contains(dataMap.get("msaupload")),
										"Single File doesnot contains"+dataMap.get("msaupload")+",but contains:"+appupload);
							}
					 
					//CustomFields
					//Client name
					if(dataMap.containsKey("msaclient")){
					String clientid=lavanteUtils.getCustomIDQUERY("client Name","1","50");
					String clientname=driver.findElement(By.xpath("//*[@for='"+clientid+"']/../..//td[2]")).getText();
					
					softassert.assertEquals(clientname,dataMap.get("msaclient"),
							clientname+":DAS"+dataMap.get("msaclient")+"MSA ClientName not matching");
					}
					
					
					
					//Start Date
					if(dataMap.containsKey("MSAstartdate")){
						if(dataMap.get("MSAstartdate").equalsIgnoreCase("ANY"))
						{
						//	softassert.assertEquals(dp.MSAstartDate().getAttribute("value"),msanottoexc,
							//		dp.MSAstartDate().getAttribute("value")+"DAS"+msanottoexc+ "sowdesc not matching");
						}
					}
						
				

				
					softassert.assertAll();
					flag=true;

					 
				}
						
							
		}
							
		
		if(flag==false){
				Assert.assertTrue(false,"DATA NOT AVAILABLE");
			
		}
		System.out.println("----------Test Ended----------------");
	}
		
	*//** SIM -7533
	 * Add SOW, Verify all Status EDIT page
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void SOWMultiStatusEdit024(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Edit Deliverable-------------------");
		System.out.println(dataMap.size()+"DAS"+dataMap);
		System.out.println(LavanteUtils.currenttime());
		dataMap.put("save", "");
		boolean flag=false;
		SoftAssert softAssert=new SoftAssert();
		//TO uniquely identify the SOW
		String sowdesc="SP6605";
		sowdesc=dataMap.get("SOWDescription")+LavanteUtils.randomnum();
		dataMap.put("SOWDescription",sowdesc);
		dataMap.put("SOWStatus","Active");
		
		eneditContractManagement.AddSOW(dataMap);
		
		
		lavanteUtils.fluentwait(eneditContractManagement.addMSAnwBtn());
		for(int i=0;i<eneditContractManagement.SOWDesclist().size();i++){
			if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(i).getText()))
				{
					Reporter.log("SOW Available in the list");
					Reporter.log("SOW Status  after Creation is Active");
					String status=eneditContractManagement.SOWStatuslist().get(i).getText();
					softAssert.assertEquals(status,dataMap.get("SOWStatus"),"SOW Status in Active");
					
						int iij=i+1;
						String select="tr:nth-child("+iij+") a[title*='Edit Statement']";
						driver.findElement(By.cssSelector(select)).click();
						lavanteUtils.waitForTime(4000);
						
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.SOWEditIframe());
						lavanteUtils.switchtoFrame(eneditContractManagement.SOWEditIframe());		
						
						System.out.println(sowdesc+"+dp.SOWdescr()");
						dataMap.clear();
						
						dataMap.put("save", "");
						dataMap.put("SOWStatus","Cancelled");
						
						eneditContractManagement.fillSOWDetails(dataMap, "");
						eneditContractManagement.formActionSOW(dataMap);
						
						//Verification of Edit of Active SOW STATUS
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.addMSAnwBtn());
						for(int j=0;j<eneditContractManagement.SOWDesclist().size();j++){
							if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(j).getText()))
								{
									status=eneditContractManagement.SOWStatuslist().get(j).getText();
									Reporter.log("Status Change from Active to Cancelled");
									softAssert.assertEquals(status,dataMap.get("SOWStatus"),"SOW Status Not Changed Active to Cancelled");

									int ij=i+1;
									String selects="tr:nth-child("+ij+") a[title*='Edit Statement']";
									driver.findElement(By.cssSelector(selects)).click();
						
									dataMap.put("save", "");
									dataMap.put("SOWStatus","Complete");
									eneditContractManagement.fillSOWDetails(dataMap, "");
									eneditContractManagement.formActionSOW(dataMap);
								}
							}						
						
						//Verification of Edit of Cancelled SOW STATUS
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.addMSAnwBtn());
						for(int k=0;k<eneditContractManagement.SOWDesclist().size();k++){
							System.out.println(i+sowdesc+eneditContractManagement.SOWDesclist().get(k).getText());
							if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(k).getText()))
								{
									
									status=eneditContractManagement.SOWStatuslist().get(k).getText();
									Reporter.log("Status Change From Cancelled to Complete");
									softAssert.assertEquals(status,dataMap.get("SOWStatus"),"SOW Status Not Changed From Cancelled to Complete");
									int ij=i+1;
									String selects="tr:nth-child("+ij+") a[title*='Edit Statement']";
									driver.findElement(By.cssSelector(selects)).click();
									dataMap.put("save", "");
									dataMap.put("SOWStatus","Active");
									eneditContractManagement.fillSOWDetails(dataMap, "");
									eneditContractManagement.formActionSOW(dataMap);
								}
						}
						
						//Verification of Edit of Complete SOW STATUS
						lavanteUtils.switchtoFrame(null);
						lavanteUtils.fluentwait(eneditContractManagement.addMSAnwBtn());
						for(int l=0;l<eneditContractManagement.SOWDesclist().size();l++){
							if(sowdesc.equalsIgnoreCase(eneditContractManagement.SOWDesclist().get(l).getText()))
								{
									status=eneditContractManagement.SOWStatuslist().get(l).getText();
									Reporter.log("Status Change From Complete to Active");
									softAssert.assertEquals(status,dataMap.get("SOWStatus"),"SOW Status Not Changed From Complete to Active");
								}
						}
						lavanteUtils.waitForTime(2000);
					
					
						
						softAssert.assertAll();
						flag=true;
			} 
		}
		
		if(flag==false){
				Assert.assertTrue(false,"DATA NOT AVAILABLE");
			
		}
		System.out.println("----------Test Ended----------------");
	}
		
	*//**
	 * Verify Tax Rate as per the data sheet
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void CreateDELTravelService025(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate Est Tax for Item type-------------------");
		Reporter.log("Test Started for Validate Est Tax for Item Type at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		if(dataMap.containsKey("DELitemtype")){
			dataMap.put("DELitemtype", "Travel");	
		}else{
			dataMap.put("DELitemtype", "Travel");	
		}
		
		
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		System.out.println(amnt+eneditContractManagement.DELestTaxPercent().getText());
		String ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
		Reporter.log(amnt+":"+eneditContractManagement.DELestTaxPercent().getText()+"For  "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app:"+ds);
		softassert.assertTrue(ds.length()<=0,"Estimated tax is calculated for Travel Item type,In app:"+ds);
		
		dataMap.clear();
		
		dataMap.put("DELitemtype", "Services");	
		
		eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
		
		ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
		Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app: "+ds);
		softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Services Item type,In app:"+ds);
		
		dataMap.put("DELitemtype", "Materials");	
		
		eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
		
		ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
		Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax "+ds);
		softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Materials Item type,In app:"+ds);
		

		dataMap.put("cancel", "");
		eneditContractManagement.formActionDeliverable(dataMap);
		
		softassert.assertAll();
		System.out.println("----------Test Ended----------------");

	}
	
	*//**
	 * Verify Est Tax in Edit deliverable page with different item type
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void EditDELEstTax026(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate Est Tax for Item type in EDIT DEL-------------------");
		Reporter.log("Test Started for Validate Est Tax for Item Type in EDIT DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		
		
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{

				eneditContractManagement.DELedit().get(i).click();

				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(eneditContractManagement.DELEditIframe());
				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				
				
				lavanteUtils.waitForTime(2000);
				
				//To avoid unnecessary data filling
				dataMap.clear();
				
				if(dataMap.containsKey("DELitemtype")){
					dataMap.put("DELitemtype", "Travel");	
				}else{
					dataMap.put("DELitemtype", "Travel");	
				}
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				System.out.println(amnt+eneditContractManagement.DELestTaxPercent().getText());
				String ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
				Reporter.log("For  "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app:"+ds);
				softassert.assertTrue(ds.length()<=0,"Estimated tax is calculated for Travel, Item type,In app:"+ds);
				
				
				dataMap.put("DELitemtype", "Services");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some value ,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Services, Item type,In app:"+ds);
				
				dataMap.put("DELitemtype", "Materials");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some Value,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Materials, Item type,In app:"+ds);
				
				dataMap.put("cancel", "");
				eneditContractManagement.formActionDeliverable(dataMap);
				flag=true;

			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	*//**
	 * Verify Est Tax in Copy deliverable page with different item type
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void CopyDELEstTax026(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate Est Tax for Item type in COPY DEL-------------------");
		Reporter.log("Test Started for Validate Est Tax for Item Type in COPY DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		
		
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{

				eneditContractManagement.DELCopy().get(i).click();

				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(eneditContractManagement.DELEditIframe());
				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				
				
				lavanteUtils.waitForTime(2000);
				
				//To avoid unnecessary data filling
				dataMap.clear();
				
				if(dataMap.containsKey("DELitemtype")){
					dataMap.put("DELitemtype", "Travel");	
				}else{
					dataMap.put("DELitemtype", "Travel");	
				}
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				System.out.println(amnt+eneditContractManagement.DELestTaxPercent().getText());
				String ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
				Reporter.log("For  "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app:"+ds);
				softassert.assertTrue(ds.length()<=0,"Estimated tax is calculated for Travel, Item type,In app:"+ds);
				
				
				dataMap.put("DELitemtype", "Services");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some value ,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Services, Item type,In app:"+ds);
				
				dataMap.put("DELitemtype", "Materials");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTaxPercent().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some Value,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Materials, Item type,In app:"+ds);
				
				dataMap.put("cancel", "");
				eneditContractManagement.formActionDeliverable(dataMap);
				flag=true;

			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for COPY DEL Est Tax at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	*//**
	 * Verify Location with Tax Code  in Add deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void ADDDELLocation(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate DEL Location with TAX Code in DEL-------------------");
		Reporter.log("Test Started for Validate  DEL Location with TAX Code in DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		
		eneditContractManagement.AddDelievarable(dataMap);
		
		dataMap.clear();
		
		String dellocation=eneditContractManagement.DELdellocationname().getText();
		
		 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
		
		 	int rowcount=0;
			rowcount=sheet.getLastRowNum();
			System.out.println("ROWCOUNT:"+rowcount);
			String taxcode=null;
			String location=null;
			for(int x=1;x<=rowcount;x++) 
	    	{  
				HSSFRow val=sheet.getRow(x);
	    		
	    		//Location Column
	    		HSSFCell ase=val.getCell(0);
	    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
	    			
				 }else { 
					ase.setCellType(Cell.CELL_TYPE_STRING);
				 	location=ase.getStringCellValue();
				 	if(dellocation.contains(location)){
				 		
				 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
				 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
				 		
				 		//Tax Column
				 		HSSFCell as=val.getCell(1);
				    	
			    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			    			
						 }else { as.setCellType(Cell.CELL_TYPE_STRING);
						
						 	taxcode=as.getStringCellValue();
							 Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
							 softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");
							 flag=true;
							 
						 }
				 		
				 	} 
				 	
				 }
				
	    	}
		 
		if(flag==false){
			softassert.assertTrue(false,"Please add data and RETEST");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for DEL Location with Tax Code at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	*//**
	 * Verify Location with Tax Code  in Edit deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void EditDELLocationx028(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate Location with Tax Code  in EDIT DEL-------------------");
		Reporter.log("Test Started for Validate Location with Tax Code in EDIT DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		eneditContractManagement.AddDelievarable(dataMap);
		
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{

				eneditContractManagement.DELedit().get(i).click();

				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(eneditContractManagement.DELEditIframe());
				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				

				String dellocation=eneditContractManagement.DELdellocationname().getText();
				
				 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
				
			 	int rowcount=0;
				rowcount=sheet.getLastRowNum();
				System.out.println("ROWCOUNT:"+rowcount);
				String taxcode=null;
				String location=null;
				for(int x=1;x<=rowcount;x++) 
		    	{  
					HSSFRow val=sheet.getRow(x);
		    		
		    		//Location Column
		    		HSSFCell ase=val.getCell(0);
		    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
		    			
					 }else { 
						ase.setCellType(Cell.CELL_TYPE_STRING);
					 	location=ase.getStringCellValue();
					 	if(dellocation.contains(location)){
					 		
					 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
					 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
					 		
					 		//Tax Column
					 		HSSFCell as=val.getCell(1);
					    	
				    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
				    			
							 }else { as.setCellType(Cell.CELL_TYPE_STRING);
							
							 	taxcode=as.getStringCellValue();
								Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
								softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");

								flag=true;
								 
							 }
					 		
					 	} 
					 	
					 }
					
		    	}
				
			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended Location with Tax Code  at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	*//**
	 * Verify Location in Tax Code deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void CopyDELLocation029(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate Location with Tax Code in COPY DEL-------------------");
		Reporter.log("Test Started for Validate Location with Tax Code in COPY DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{

				eneditContractManagement.DELCopy().get(i).click();

				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(eneditContractManagement.DELEditIframe());
				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				
				
				lavanteUtils.waitForTime(2000);
				
				String dellocation=eneditContractManagement.DELdellocationname().getText();
				
				 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
				
			 	int rowcount=0;
				rowcount=sheet.getLastRowNum();
				System.out.println("ROWCOUNT:"+rowcount);
				String taxcode=null;
				String location=null;
				for(int x=1;x<=rowcount;x++) 
		    	{  
					HSSFRow val=sheet.getRow(x);
		    		
		    		//Location Column
		    		HSSFCell ase=val.getCell(0);
		    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
		    			
					 }else { 
						ase.setCellType(Cell.CELL_TYPE_STRING);
					 	location=ase.getStringCellValue();
					 	if(dellocation.contains(location)){
					 		
					 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
					 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
					 		
					 		//Tax Column
					 		HSSFCell as=val.getCell(1);
					    	
				    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
				    			
							 }else { as.setCellType(Cell.CELL_TYPE_STRING);
							
							 	taxcode=as.getStringCellValue();
								Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
								softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");

								flag=true;
								 
							 }
					 		
					 	} 
					 	
					 }
					
		    	}


			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for COPY DEL LOCATION in TaX CODE at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	
	*//**
	 * Verify Location in Tax Code View deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 *//*
	//@Test(dataProvider="VERIFYCALC",dataProviderClass=DELDataProvider.class)
	public void ViewDELLocation030(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException{	
		System.out.println("------------Test Started for Validate Location with Tax Code in View DEL-------------------");
		Reporter.log("Test Started for Validate Location with Tax Code in VIEW DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		eneditContractManagement.AddDelievarable(dataMap);
		Reporter.log("Created New Deliverable");
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		for(int i=0;i<eneditContractManagement.DELnolist().size();i++){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{

				eneditContractManagement.DELnolist().get(i).click();
				Reporter.log("In View Mode of Deliverable");
				
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(eneditContractManagement.DELIframeView());
				lavanteUtils.switchtoFrame(eneditContractManagement.DELIframeView());
				
				
				lavanteUtils.waitForTime(2000);
				
				String dellocation=eneditContractManagement.DELViewdeliverableLocation().getText();
				
				 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
				
			 	int rowcount=0;
				rowcount=sheet.getLastRowNum();
				System.out.println("ROWCOUNT:"+rowcount);
				String taxcode=null;
				String location=null;
				for(int x=1;x<=rowcount;x++) 
		    	{  
					HSSFRow val=sheet.getRow(x);
		    		
		    		//Location Column
		    		HSSFCell ase=val.getCell(0);
		    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
		    			
					 }else { 
						ase.setCellType(Cell.CELL_TYPE_STRING);
					 	location=ase.getStringCellValue();
					 	if(dellocation.contains(location)){
					 		
					 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
					 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
					 		
					 		//Tax Column
					 		HSSFCell as=val.getCell(1);
					    	
				    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
				    			
							 }else { as.setCellType(Cell.CELL_TYPE_STRING);
							
							 	taxcode=as.getStringCellValue();
								Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
								softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");

								flag=true;
								 
							 }
					 		
					 	} 
					 	
					 }
					
		    	}


			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for VIEW DEL LOCATION in TaX CODE at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	

	*//**
	 * Verify Location in Tax Code View deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 *//*
	@Test(dataProvider="VERIFYCALC",dataProviderClass=CMDataProvider.class)
	public void PayMentTerms(LinkedHashMap<String,String> dataMap) throws InvalidFormatException, IOException, SQLException{	
		System.out.println("------------Test Started for Validate Location with Tax Code in View DEL-------------------");
		Reporter.log("Test Started for Validate Location with Tax Code in VIEW DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		String i18Key ="AutoPaymentEFT"+LavanteUtils.randomnum();
		String exp="SP"+LavanteUtils.randomnum();
		
		String query1="Insert into I18NKey  (i18nKey) values ('"+i18Key+"')";
		String query2="Insert into UserTranslation (i18nKey,LanguageID,UTFString,IsCustomerSpecific) "
				+ " values ('"+i18Key+"',50,'"+exp+"','')" ;
		String query3= "Insert into PaymentTerms (CustomerID,PaymentTypeID,PaymentName,paymentName_i18nKey,TargetPage_KVID,DisplayOrder)"
				+ " values ("+customerID+",21,'"+exp+"','"+i18Key+"',1132,3)" ;
		
		lavanteUtils.UpdateDB(query1);
		lavanteUtils.UpdateDB(query2);
		lavanteUtils.UpdateDB(query3);
		
		
		//To  Save the deliverables
		eneditContractManagement.AddSOW(dataMap);
	
		dataMap.clear();
		dataMap.put("SOWPaymentType", "Check");
		dataMap.put("SOWPaymentTerms", exp);
	
		eneditContractManagement.SOWpaymenttrmdpdn().click();
		lavanteUtils.switchtoFrame(null);
		
		List<WebElement> el=driver.findElements(By.cssSelector("div[class*='drop'] li"));
		System.out.println(el.size());
		
		for(int i=0;i<el.size();i++)
		{
			String app=el.get(i).getText();
			System.out.println(app+"APP : EXP"+exp);
			if(app.equalsIgnoreCase(exp))
			{
				softassert.assertEquals(app,exp,"Value Expected Not matched");
			}
		}
		
	
		//Credit Card Verify
		dataMap.put("SOWPaymentType", "Credit Card");
		
		eneditContractManagement.SOWAddIframe();
		eneditContractManagement.SOWpaymenttrmdpdn().click();
		lavanteUtils.switchtoFrame(null);
		
		List<WebElement> el2=driver.findElements(By.cssSelector("div[class*='drop'] li"));
		System.out.println(el.size());
		
		for(int i=0;i<el2.size();i++)
		{
			String app=el2.get(i).getText();
			System.out.println(app+"APP : EXP"+exp);
			if(app.equalsIgnoreCase(exp))
			{
				softassert.assertEquals(app,exp,"Value Expected Not matched");
			}
		}
		
		dataMap.put("SOWPaymentType", "EFT");
		
		eneditContractManagement.SOWAddIframe();
		eneditContractManagement.SOWpaymenttrmdpdn().click();
		lavanteUtils.switchtoFrame(null);
		
		List<WebElement> el3=driver.findElements(By.cssSelector("div[class*='drop'] li"));
		System.out.println(el.size());
		
		for(int i=0;i<el3.size();i++)
		{
			String app=el3.get(i).getText();
			System.out.println(app+"APP : EXP"+exp);
			if(app.equalsIgnoreCase(exp))
			{
				softassert.assertEquals(app,exp,"Value Expected Not matched");
			}
		}
		
		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for VIEW DEL LOCATION in TaX CODE at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	
	
	@AfterMethod
	public void SetupAftermethod(){
		enobjhomePage.popupclose();
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		
	}
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.close();
		enobjhomePage.logout();
		
		quitBrowser();
	}


}

*/