package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 7-3-2016
 * Created for Deliverable Test case
 * Enhancement covered SIM -7339
 * Ended on 10-3-2016
 * @author Piramanayagam.S
 *
 */
public class CMmsaTC002 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> loginDataMap=new LinkedHashMap<String, String>();
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
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		
		//Login	
		List listofdatafrm=lavanteUtils.login("MSA-2", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		
		String sname="select MAX(su.SupplierName) from Relationship R,Supplier su,MasterServiceAgreement m "
				+ " where r.RelationShipID=m.RelationShipID and r.LavanteUID=su.LavanteUID "
				+ " and r.CustomerID="+customerid;
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
	 * Add MSA, Verify client name is displayed or not in dropdown
	 * 
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test()
	public void AddMSAclient001() throws Exception{	
	
		Reporter.log("Test started to check clent MSA at:"+LavanteUtils.currenttime());

		SoftAssert softassert=new SoftAssert();
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String, String>();
		eneditContractManagement.createMSA(dataMap);
	
		Reporter.log("clent name display in add MSA :");
		softassert.assertTrue(eneditContractManagement.MSAClientName().isDisplayed(),"Client name is not displayed");

		Reporter.log("Test ended to check clent MSA at:"+LavanteUtils.currenttime());
	}
	
	/**
	 *  Verify in view page client name field is displayed or not
	 * 
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void viewMSAclient002(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for MSA EDIT Deliverable:"+LavanteUtils.currenttime());
		
		dataMap.put("save", "");
		boolean flag=false;
	
		//TO uniquely identify the SOW
		
		String msanottoexc="17.38";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
			dataMap.put("msanottoexceed",msanottoexc);
		}
	
		dataMap.put("MSASave", "");
		eneditContractManagement.createMSA(dataMap);
		
		SoftAssert softassert=new SoftAssert();
		outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
		
			if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
				{		
					Reporter.log("Created MSA available in the list");
					lavanteUtils.click(eneditContractManagement.MSANumTxt().get(i));
					lavanteUtils.waitForTime(4000);
					
					lavanteUtils.switchtoFrame(eneditContractManagement.MSAViewIFRAME());		
					
					Reporter.log("clent name in View MSA at:"+LavanteUtils.currenttime());
					softassert.assertTrue(eneditContractManagement.MSAViewClientName().isDisplayed(),"Client name not displayed");
					flag=true;
					break outr;
				}
						
							
		}
						

		if(flag==false){
			softassert.assertTrue(false,"Please Add DATA and RETEST");
			
		}
		

		softassert.assertAll();
		Reporter.log("Test ended to check client MSA in view MSA at:"+LavanteUtils.currenttime());
	}

	/** Verify in edit page clent name is displayed or not
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void EditMSAclent003(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for MSA EDIT Deliverable"+LavanteUtils.currenttime());
		
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//TO uniquely identify the SOW
		String msanottoexc="151,815.00";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
			dataMap.put("msanottoexceed",msanottoexc);
		} 
	
		
		dataMap.put("MSASave", "");
		eneditContractManagement.createMSA(dataMap);
		Reporter.log("Created MSA");
		
		outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
			if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
				{		
						Reporter.log("Created MSA available in the list:");
						int j=i+1;
						String select="tr:nth-child("+j+") a[title*='Edit Master']";
						lavanteUtils.click(driver.findElement(By.cssSelector(select)));
						lavanteUtils.waitForTime(4000);
						
						lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());		
						
						lavanteUtils.waitForTime(2000);
						Reporter.log("client name in edit MSA,Expected True,In app:"+eneditContractManagement.MSAViewClientName().isDisplayed());
						softassert.assertTrue(eneditContractManagement.MSAViewClientName().isDisplayed());
					
						flag=true;
						break outr;
						
				} 
		
			}
			
		
		if(flag==false){
			softassert.assertTrue(false,"DATA NOT AVAILABLE");
		}
		softassert.assertAll();
		Reporter.log("Test ended to check client MSA in Edit MSA at:"+LavanteUtils.currenttime());
	}

	/**  cofigured client name in view MSA
	* SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void configureMSAviewclient004(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for MSA EDIT Deliverable:"+LavanteUtils.currenttime());
	
		dataMap.put("save", "");
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//TO uniquely identify the SOW
		
		String msanottoexc="17.38";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
			dataMap.put("msanottoexceed",msanottoexc);
		}
		

		String i18Key ="AutoSPClientName"+LavanteUtils.randomnum();
          String expClientNAme="SP"+LavanteUtils.randomnum();
          
          String query1="Insert into I18NKey  (i18nKey) values ('"+i18Key+"')";
          String query2="Insert into UserTranslation (i18nKey,LanguageID,UTFString,IsCustomerSpecific) "
                       + " values ('"+i18Key+"',50,'"+ expClientNAme +"','')" ;
          String query3= " Insert into ClientNames ( CustomerID   ,ClientNameI18Nkey,CreatedBy  ,CreatedOn)"
                       + " values ("+customerid+",'"+i18Key+"','"+ expClientNAme +"' , 2/3/2015)" ;
          

          lavanteUtils.UpdateDB(query1);
          lavanteUtils.UpdateDB(query2);
          lavanteUtils.UpdateDB(query3);
          Reporter.log("New Client Name Inserted into DB:"+expClientNAme);
	
		dataMap.put("MSASave", "");
		dataMap.put("msaclient", expClientNAme);
		
		eneditContractManagement.createMSA(dataMap);
		
		outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
			if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
				{		
					Reporter.log("Created MSA available in the list");
					lavanteUtils.click(eneditContractManagement.MSANumTxt().get(i));
					lavanteUtils.waitForTime(4000);
					
					lavanteUtils.switchtoFrame(eneditContractManagement.MSAViewIFRAME());		
					
	
					String actualclientname=eneditContractManagement.MSAViewClientName().getText();
					Reporter.log("Configured Client for MSA Expected:"+expClientNAme+",Actual"+actualclientname);
					softassert.assertEquals(actualclientname, expClientNAme);
					flag=true;
					break outr;
					 
				}
						
							
		}
			
		String query="delete from MasterServiceAgreement where "
				+ " ClientNameID in (select ClientNameID from ClientNames where ClientNameI18Nkey='"+i18Key+"')";
		lavanteUtils.UpdateDB(query);
		query="delete from  ClientNames where ClientNameI18Nkey='"+i18Key+"'";
		lavanteUtils.UpdateDB(query);
		
		query="delete from UserTranslation where i18nKey='"+i18Key+"'";;
		lavanteUtils.UpdateDB(query);
		
		query="delete from i18nKey where i18nKey='"+i18Key+"'";
		lavanteUtils.UpdateDB(query);
		
		if(flag==false){
			softassert.assertTrue(false,"Please Add DATA and RETEST");
			
		}
		

		softassert.assertAll();
		Reporter.log("Test ended to check client MSA in view MSA at:"+LavanteUtils.currenttime());
	}

	/** configured client name in edit MSA
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void configEditMSAclient005(LinkedHashMap<String,String> dataMap) throws Exception{	
	Reporter.log("Test Started for MSA EDIT Deliverable:"+LavanteUtils.currenttime());
	boolean flag=false;
	
	SoftAssert softassert=new SoftAssert();
	
	
	//TO uniquely identify the SOW
	String msanottoexc="17.38";
	msanottoexc=dataMap.get("msanottoexceed");
	if(msanottoexc.equalsIgnoreCase("ANY"))
	{
		msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
		dataMap.put("msanottoexceed",msanottoexc);
	} 
	String i18Key ="AutoSPClientName"+LavanteUtils.randomnum();
    
    String query1="Insert into I18NKey  (i18nKey) values ('"+i18Key+"')";
    String query2="Insert into UserTranslation (i18nKey,LanguageID,UTFString,IsCustomerSpecific) "
                 + " values ('"+i18Key+"',50,'"+ i18Key +"','')" ;
    String query3= " Insert into ClientNames ( CustomerID   ,ClientNameI18Nkey,CreatedBy  ,CreatedOn)"
                 + " values ("+customerid+",'"+i18Key+"','"+ i18Key +"' , 2/8/2016)" ;
    

    lavanteUtils.UpdateDB(query1);
    lavanteUtils.UpdateDB(query2);
    lavanteUtils.UpdateDB(query3);
	Reporter.log("Client Name Inserted into DB"+i18Key);
    
	dataMap.put("MSASave", "");
	dataMap.put("msaclient", i18Key);
	eneditContractManagement.createMSA(dataMap);
	Reporter.log("Created MSA Successfully");
	
	outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
		if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
			{		
					Reporter.log("Created MSA Available in the list");
					int j=i+1;
					String select="tr:nth-child("+j+") a[title*='Edit Master']";
					lavanteUtils.click(driver.findElement(By.cssSelector(select)));
					lavanteUtils.waitForTime(4000);
					
					lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());		
					
					String actualclientname=eneditContractManagement.MSAeditclientName().getText();
					Reporter.log("Configured Client for MSA Expected:"+i18Key+",Actual"+actualclientname);
					softassert.assertEquals(actualclientname, i18Key);
				
					flag=true;
					break outr;
					
		} 
		
	}
	
	String query="delete from MasterServiceAgreement where "
			+ " ClientNameID in (select ClientNameID from ClientNames where ClientNameI18Nkey='"+i18Key+"')";
	lavanteUtils.UpdateDB(query);
	query="delete from  ClientNames where ClientNameI18Nkey='"+i18Key+"'";
	lavanteUtils.UpdateDB(query);
	
	query="delete from UserTranslation where i18nKey='"+i18Key+"'";
	lavanteUtils.UpdateDB(query);
	
	query="delete from i18nKey where i18nKey='"+i18Key+"'";
	lavanteUtils.UpdateDB(query);
	
	if(flag==false){
		softassert.assertTrue(false,"DATA NOT AVAILABLE");
	}
	softassert.assertAll();
	Reporter.log("Test ended to check client MSA in Edit MSA at:"+LavanteUtils.currenttime());
}
	
	/**	
	 * configured client name in Add MSA
	 * 
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void configAddMSAclient006(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for configured client name in Add MSA:"+LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		
		String i18Key ="AutoSPClientName"+LavanteUtils.randomnum()+customerid;
        
        String query1="Insert into I18NKey  (i18nKey) values ('"+i18Key+"')";
        String query2="Insert into UserTranslation (i18nKey,LanguageID,UTFString,IsCustomerSpecific) "
                     + " values ('"+i18Key+"',50,'"+ i18Key +"','')" ;
        String query3= " Insert into ClientNames ( CustomerID   ,ClientNameI18Nkey,CreatedBy  ,CreatedOn)"
                     + " values ("+customerid+",'"+i18Key+"','"+ i18Key +"' , 2/3/2015)" ;
        

        lavanteUtils.UpdateDB(query1);
        lavanteUtils.UpdateDB(query2);
        lavanteUtils.UpdateDB(query3);
		Reporter.log("Client Name Inserted into DB"+i18Key);
        
		dataMap.put("msaclient",i18Key);
		eneditContractManagement.createMSA(dataMap);
		
		lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());

		String actualclientname=eneditContractManagement.MSAClientName().getText();
		System.out.println("Configured Client for MSA Expected:"+i18Key+",Actual"+actualclientname);
		Reporter.log("Configured Client for MSA Expected:"+i18Key+",Actual"+actualclientname);
		softassert.assertEquals(actualclientname, i18Key);
		
		String query="delete from MasterServiceAgreement where "
				+ " ClientNameID in (select ClientNameID from ClientNames where ClientNameI18Nkey='"+i18Key+"')";
		lavanteUtils.UpdateDB(query);
		query="delete from  ClientNames where ClientNameI18Nkey='"+i18Key+"'";
		lavanteUtils.UpdateDB(query);
		
		query="delete from UserTranslation where i18nKey='"+i18Key+"'";
		lavanteUtils.UpdateDB(query);
		
		query="delete from i18nKey where i18nKey='"+i18Key+"'";
		lavanteUtils.UpdateDB(query);
	    Reporter.log("Addded Client Name Deleted from DB:"+i18Key);
	        
		softassert.assertAll();
		Reporter.log("Test ended configured client name in Add MSA:"+LavanteUtils.currenttime());
	}

			/**	
	 * MSA creation based on client name
	 * 
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void MSAbasedclient007(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for MSA Client Name Mandatory"+LavanteUtils.currenttime());
	
	

		String query2=" Update PopUpCustomerMetadata SET"
      		     + " IsRequiredField = '1' " 
      		     + " WHERE PopUpProfileMetadataID = 7501"
                   + " AND CustomerID = "+customerid;
      	
		lavanteUtils.UpdateDB(query2);
      Reporter.log("Client Name field is updated as mandatory in DB as before");
      
		String msanottoexc="17.38";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
			dataMap.put("msanottoexceed",msanottoexc);
		}
		dataMap.remove("msaclient");
		dataMap.put("MSASave", "");
		dataMap.put("Errmsg", "");
		eneditContractManagement.createMSA(dataMap);
		
		lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());
		Reporter.log("Client name Error Message");
		
		 query2=" Update PopUpCustomerMetadata SET"
     		     + " IsRequiredField = '0' " 
     		     + " WHERE PopUpProfileMetadataID = 7501"
                  + " AND CustomerID = "+customerid;
     	
		lavanteUtils.UpdateDB(query2);
		
		Assert.assertEquals(eneditContractManagement.DELgetValidErrormsg().getText(),"'Client Name' cannot be left blank.","Client Name Error message not apperaed");
		Reporter.log("Test Ended for MSA Client Name Mandatory"+LavanteUtils.currenttime());
		
					
	}			
				
	/** MSA creation without clientname
	 * SIM-7339	
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void MSAcreationwithoutclient008(LinkedHashMap<String,String> dataMap) throws Exception{		
		
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		Reporter.log("Test started to Creation of MSA without Client Name:"+LavanteUtils.currenttime());

		//TO uniquely identify the SOW
		String msanottoexc="151,815.00";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
			dataMap.put("msanottoexceed",msanottoexc);
		} 
	
        String query1=" Update PopUpCustomerMetadata SET"
        		     + " IsRequiredField = '0' " 
        		     + " WHERE PopUpProfileMetadataID = 7501"
                     + " AND CustomerID = "+customerid;
    		        
        lavanteUtils.UpdateDB(query1);
        
		Reporter.log("Client Name field is removed as mandatory from DB");
        
		dataMap.remove("msaclient");
		dataMap.put("MSASave", "");
		eneditContractManagement.createMSA(dataMap);

		{
			  String query2=" Update PopUpCustomerMetadata SET"
	        		     + " IsRequiredField = '1' " 
	        		     + " WHERE PopUpProfileMetadataID = 7501"
                         + " AND CustomerID = "+customerid;
	        	
			  lavanteUtils.UpdateDB(query2);
	        Reporter.log("Client Name field is updated as mandatory in DB as before");
	        
		}
		
		outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
				System.out.println(msanottoexc+":"+eneditContractManagement.MSAnottoexceedList().get(i).getText());
				if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
					{		
							Reporter.log("Created MSA Available in the list");
							lavanteUtils.click(eneditContractManagement.MSAnolist().get(i));
					       
							lavanteUtils.switchtoFrame(eneditContractManagement.MSAViewIFRAME());		
								
							Reporter.log("client name in edit MSA,Expected :empty,In app:"+eneditContractManagement.MSAViewClientName().getText());
							softassert.assertTrue(eneditContractManagement.MSAViewClientName().getText().length()<=0,"DAS");
						
							flag=true;
							break outr;
				} 
			
			}
				
			if(flag==false){
				softassert.assertTrue(false,"DATA NOT AVAILABLE");
			}
		
		 query1=" Update PopUpCustomerMetadata SET"
        		     + " IsRequiredField = '0' " 
        		     + " WHERE PopUpProfileMetadataID = 7501"
                     + " AND CustomerID = "+customerid;
    		        
        lavanteUtils.UpdateDB(query1);
		softassert.assertAll();
		Reporter.log("Test ended for MSA creation without clientname at:"+LavanteUtils.currenttime());
	}
	
	/**	
	 *header client name in MSA
	 * 
	 * SIM-7339
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void AddMSAclient009() throws Exception{	
		Reporter.log("Test Started for header client name in MSA:"+LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		
		Reporter.log("Test started to check clent MSA at:"+LavanteUtils.currenttime());
		
		String appheaad=eneditContractManagement.MSAheadClient().getText();
		Reporter.log("First Column in the MSA Table Expected,Client name,In app"+appheaad);
		softassert.assertEquals(appheaad,"Client Name","Err");
		Reporter.log("Test ended for header client name in MSA at:"+LavanteUtils.currenttime());
	}
	
	/** MSA creation based on clientname field
	 *SIM-7339		
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
	public void MSAcreationbasedclient010(LinkedHashMap<String,String> dataMap) throws Exception{		
						
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		Reporter.log("Test started to check client name field based on MSA at:"+LavanteUtils.currenttime());

		//TO uniquely identify the SOW
		String msanottoexc="151,815.00";
		msanottoexc=dataMap.get("msanottoexceed");
		if(msanottoexc.equalsIgnoreCase("ANY"))
		{
			msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
			dataMap.put("msanottoexceed",msanottoexc);
		} 

		dataMap.put("MSASave", "");
		eneditContractManagement.createMSA(dataMap);
		Reporter.log("MSA created");
		
		outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
				if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
					{		
						 Reporter.log("Created MSA Available in the list");
					     String appmsno= eneditContractManagement.MSAnolist().get(i).getText();
					     String expclname=dataMap.get("msaclient");
						
					     lavanteUtils.waitForTime(2000);
						 Reporter.log("client name in MSA,Expected :"+expclname+",In app:"+eneditContractManagement.MSAnolist().get(i).getText());
						 softassert.assertTrue(appmsno.contains(expclname),"ppp");
						
						 flag=true;
						 break outr;
					} 
			}
				
			
			if(flag==false){
				softassert.assertTrue(false,"DATA NOT AVAILABLE");
			}
		
	
		softassert.assertAll();
		Reporter.log("Test ended to check client name field basede on MSA at:"+LavanteUtils.currenttime());
	}
	
	@AfterMethod
	public void aftermethod(){
		refreshPage();
		enobjhomePage.popupclose();
		
	}
	
	/**
	 * After Close any Popup and Logout
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		enobjhomePage.logout();
		
		quitBrowser();
	}


}

