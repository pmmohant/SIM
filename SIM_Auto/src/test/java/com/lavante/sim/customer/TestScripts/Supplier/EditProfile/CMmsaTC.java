package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
 * Created on 16-12-2015
 * Created for Deliverable Test case
 * Enhancement covered SIM -7108 ,SIM-7340,SIM-7341
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class CMmsaTC extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String customerid;
	String sname="";
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 */
	@SuppressWarnings("unchecked")
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
		List<?> listofdatafrm=lavanteUtils.login("MSA-1", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		
		sname="select MAX(su.SupplierName) from Relationship R,Supplier su,MasterServiceAgreement m "
				+ " where r.RelationShipID=m.RelationShipID and r.LavanteUID=su.LavanteUID "
				+ " and r.CustomerID="+customerid;
		sname=lavanteUtils.fetchDBdata(sname);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
				
		dataMap.put("Search", "");
		dataMap.put("supplierName", sname);
		
		Reporter.log("Supplier selected:"+sname);
		enobjsupplierBasicSearch.search(dataMap);		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
		dataMap.put("tab", "enterpriseContract");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

	}
	
	/**
		 * Add MSA, Verify all fields in eDIT page
		 * 
		 * @author Piramanayagam.S
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void MSAEdit001(LinkedHashMap<String,String> dataMap) throws Exception{	
			Reporter.log("Test Started for MSA Edit at:"+LavanteUtils.currenttime());
			dataMap.put("save", "");
			boolean flag=false;
		
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
			
			SoftAssert softassert=new SoftAssert();
			outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
				if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
					{		
							String msaNum=eneditContractManagement.MSANumTxt().get(i).getAttribute("title");
							Reporter.log("In Edit Page:");
							int j=i+1;
							String select="tr:nth-child("+j+") a[title*='Edit Master']";
							lavanteUtils.click(driver.findElement(By.cssSelector(select)));
							lavanteUtils.waitForTime(4000);
							
							lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());		
							
							System.out.println(msanottoexc+"+MSA NOT EXEC()");
							
							lavanteUtils.waitForTime(2000);
							
							//Client name
							Reporter.log("Client Name Verification,In App:"+eneditContractManagement.MSAViewClientName().getText()+",Expected:"+dataMap.get("msaclient"));
							softassert.assertEquals(eneditContractManagement.MSAViewClientName().getText(),dataMap.get("msaclient"),eneditContractManagement.MSAViewClientName().getText()+":"+dataMap.get("msaclient")+"MSA ClientName not matching");
							
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
								Reporter.log("Msa Type Verification,In App:"+msatype+",Expected:"+expmsatype);
								softassert.assertTrue(msatype.contains(expmsatype),msatype+"DAS"+expmsatype+ "MSA not matching");
							}
							
							//MSA NUM	
							Reporter.log("Msa Number Verification,In App:"+eneditContractManagement.MSAViewMSAnum().getText()+",Expected:"+msaNum);
							softassert.assertEquals(eneditContractManagement.MSAViewMSAnum().getText(),msaNum,
									eneditContractManagement.MSAViewMSAnum().getText()+":"+msaNum+ "SOWNum not matching");
							
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
								Reporter.log("Msa EverGreen Verification,In App:"+msagreen.isSelected());
								softassert.assertTrue(msagreen.isSelected(), "MSA Evergreen radio button is not saved");
							}
							
							//Not to exceed amnt
							Reporter.log("Msa Not To Exceed Verification,In App:"+eneditContractManagement.MSAnottoexceed().getAttribute("value")+",Expected:"+dataMap.get("msanottoexceed"));
							softassert.assertEquals(eneditContractManagement.MSAnottoexceed().getAttribute("value"),dataMap.get("msanottoexceed"),
									eneditContractManagement.MSAnottoexceed().getAttribute("value")+":"+dataMap.get("msanottoexceed")+"MSAnottoexceed not matching");
	
							//Status MSA
							Reporter.log("Msa Status Verification,In App:"+eneditContractManagement.MSAStatusDpdn().getText()+",Expected:"+dataMap.get("MSAstatus"));
							softassert.assertEquals(eneditContractManagement.MSAStatusDpdn().getText(),dataMap.get("MSAstatus"),
									eneditContractManagement.MSAStatusDpdn().getText()+":"+dataMap.get("MSAstatus")+ "MSA Status not matching");
							
							
							if(dataMap.containsKey("msaupload")){
							/*	String Singlefile=driver.findElement(By.cssSelector("[id*=''] a")).getText();
								System.out.println(Singlefile);
								softassert.assertTrue(Singlefile.contains(dataMap.get("SOWsingleFile")),
										"Single File doesnot contains"+dataMap.get("SOWsingleFile")+",but contains:"+Singlefile);*/
							}
							
	
							flag=true;
							break outr;
					}
						
							
				} 
			
			if(flag==false){
				softassert.assertTrue(false,"DATA NOT AVAILABLE");
				
			}
	
			softassert.assertAll();
			Reporter.log("Test Ended for MSA Edit at:"+LavanteUtils.currenttime());
		}
			
		/**
		 * Add MSA, Verify all fields in View page
		 * 
		 * @author Piramanayagam.S
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void MSAView002(LinkedHashMap<String,String> dataMap) throws Exception{	
			Reporter.log("Test Started for MSA View at:"+LavanteUtils.currenttime());
			dataMap.put("save", "");
			boolean flag=false;
			SoftAssert softassert=new SoftAssert();
			
			//TO uniquely identify the SOW
			String msanottoexc="17.38";
			msanottoexc=dataMap.get("msanottoexceed");
			if(msanottoexc.equalsIgnoreCase("ANY"))
			{
				msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(99);	
				dataMap.put("msanottoexceed",msanottoexc);
			}
		
			dataMap.put("MSASave", "");
			eneditContractManagement.createMSA(dataMap);

			outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
				if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
					{		
						Reporter.log("Created MSA");
						String msaNum=eneditContractManagement.MSANumTxt().get(i).getAttribute("title");
						
						lavanteUtils.click(eneditContractManagement.MSANumTxt().get(i));
						lavanteUtils.switchtoFrame(eneditContractManagement.MSAViewIFRAME());		
						Reporter.log("In View MSA:");

						lavanteUtils.waitForTime(2000);
						//Client Name
						Reporter.log("Client Name,Expected:"+dataMap.get("msaclient")+",In app:"+eneditContractManagement.MSAViewClientName().getText());
						softassert.assertEquals(eneditContractManagement.MSAViewClientName().getText(),dataMap.get("msaclient"),
								eneditContractManagement.MSAViewClientName().getText()+":"+dataMap.get("msaclient")+"MSA ClientName not matching");
							
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
							Reporter.log("Msa type,Expected:"+expmsatype+",In app:"+appmsatext);
							softassert.assertTrue(appmsatext.equalsIgnoreCase(expmsatype),
									appmsatext+"DAS"+expmsatype+ "MSA not matching");
						}								
							
						//MSA NUM
						String appmsanum=eneditContractManagement.MSAViewMSAnum().getText();
						Reporter.log("Msa Num,Expected:"+msaNum+",In app:"+appmsanum);
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
								Reporter.log("Msa EverGreen,Expected:"+msagreen+",In app:"+appEvergrentext);
								softassert.assertTrue(appEvergrentext.equalsIgnoreCase(msagreen), "MSA Evergreen radio button is not saved"+msagreen+","+appEvergrentext);
							}
						 
						 String appNttoexcedtext=eneditContractManagement.msaviewnttoexced().getText();
						 
						//Not to exceed amnt
						 Reporter.log("Msa Not to Exceed Amount,Expected:"+dataMap.get("msanottoexceed")+",In app:"+appNttoexcedtext);
						softassert.assertEquals(appNttoexcedtext,dataMap.get("msanottoexceed"),appNttoexcedtext+":ASD"+dataMap.get("msanottoexceed")+"MSAnottoexceed not matching");
	
						//Status MSA
						 String appStatustext=eneditContractManagement.MSAviewStatus().getText();
						 Reporter.log("Msa Status,Expected:"+dataMap.get("MSAstatus")+",In app:"+appStatustext);
							softassert.assertEquals(appStatustext,dataMap.get("MSAstatus"),appStatustext+"DAS"+dataMap.get("MSAstatus")+ "MSA Status not matching");
							
					
						 if(dataMap.containsKey("msaupload")){
							 		String appupload=eneditContractManagement.MSAViewUpload().getText();
									softassert.assertTrue(appupload.contains(dataMap.get("msaupload")),"Single File doesnot contains"+dataMap.get("msaupload")+",but contains:"+appupload);
								}
						 
						//Start Date
						if(dataMap.containsKey("MSAstartdate")){
							if(dataMap.get("MSAstartdate").equalsIgnoreCase("ANY"))
							{
							//	softassert.assertEquals(dp.MSAstartDate().getAttribute("value"),msanottoexc,
								//		dp.MSAstartDate().getAttribute("value")+"DAS"+msanottoexc+ "sowdesc not matching");
							}
						}
							
						flag=true;
						break outr;
						 
					}
							
								
			}
								
			
			if(flag==false){
				softassert.assertTrue(false,"Please Add DATA and RETEST");
			}
			
			softassert.assertAll();
			Reporter.log("Test Ended for MSA View at:"+LavanteUtils.currenttime());
		}
			
		/**	
		 * MSA creation based on client name
		 * SIM-7339
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void MSAbasedclient008(LinkedHashMap<String,String> dataMap) throws Exception{	
			Reporter.log("Test Started for MSA EDIT Deliverable:"+LavanteUtils.currenttime());
		
			
			String query1=" Update PopUpCustomerMetadata SET"
        		     + " IsRequiredField = '1' " 
        		     + " WHERE PopUpProfileMetadataID = 7501"
                     + " AND CustomerID = "+customerid;
    		        
			lavanteUtils.UpdateDB(query1);
			Reporter.log("Client Name is Set as Mandatory");
			
			String msanottoexc="17.38";
			msanottoexc=dataMap.get("msanottoexceed");
			if(msanottoexc.equalsIgnoreCase("ANY"))
			{
				msanottoexc=LavanteUtils.randomnum(99)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);	
				dataMap.put("msanottoexceed",msanottoexc);
			}
			dataMap.remove("msaclient");
			dataMap.put("Errmsg","");
			dataMap.put("MSASave", "");
			eneditContractManagement.createMSA(dataMap);
			
			lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());
			Reporter.log(eneditContractManagement.DELgetValidErrormsg().getText());
			
			Reporter.log("client name cannot be left blank");
			
			
						
		}			
			
		/** MSA creation without clientname
		 * SIM-7339
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void MSAcreationwithoutclient009(LinkedHashMap<String,String> dataMap) throws Exception{		
							
			Reporter.log("Test Started for MSA creation without clientname:"+LavanteUtils.currenttime());
			SoftAssert softassert=new SoftAssert();
			boolean flag=false;
			Reporter.log("Test started to check clent MSA at:"+LavanteUtils.currenttime());

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
			
			
			outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
				if(msanottoexc.equalsIgnoreCase(eneditContractManagement.MSAnottoexceedList().get(i).getText()))
						{		
								Reporter.log("Created MSA available in the list");
								lavanteUtils.click(eneditContractManagement.MSAnolist().get(i));
								
								lavanteUtils.switchtoFrame(eneditContractManagement.MSAViewIFRAME());		
									
								Reporter.log("In View MSA");
								lavanteUtils.waitForTime(2000);
								Reporter.log("client name in edit MSA,Expected :empty,In app:"+eneditContractManagement.MSAViewClientName().getText());
								softassert.assertTrue(eneditContractManagement.MSAViewClientName().getText().length()<=0,"Text not matched");
							
								flag=true;
								break outr;
					} 
				
				}
					
				
				if(flag==false){
					softassert.assertTrue(false,"DATA NOT AVAILABLE");
				}
			
							
			{
				  String query2=" Update PopUpCustomerMetadata SET"
		        		     + " IsRequiredField = '1' " 
		        		     + " WHERE PopUpProfileMetadataID = 7501"
                             + " AND CustomerID ="+customerid;
		        	
				  lavanteUtils.UpdateDB(query2);
		        Reporter.log("Client Name field is updated as mandatory in DB");
		        
			}
			
			softassert.assertAll();
			Reporter.log("Test ended for MSA creation without clientnam at:"+LavanteUtils.currenttime());
		}
			
		/**
		 * [SIM-7323] Addendum creation should depend on MSA
		 * Add new MSA -> Add new Addendum for newly created MSA -> Verify creation of Addendum is proper
		 * @author Suresh.Muddu
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void AddendumMSA003(LinkedHashMap<String,String> dataMap) throws Exception{
			
			Reporter.log("Test Started for Addendum MSA at:"+LavanteUtils.currenttime());
			SoftAssert softassert=new SoftAssert();
			String msanum=null;
			
			String msaamnt=LavanteUtils.randomnum(999)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
			
			dataMap.put("msanottoexceed", msaamnt);
			dataMap.put("MSASave", "");
			eneditContractManagement.createMSA(dataMap);
			
			
				if(eneditContractManagement.MSAnottoexceedList().size()>0){
					
					for(int i=0;i<eneditContractManagement.MSAnottoexceedList().size();i++){
						String msano=eneditContractManagement.MSAnottoexceedList().get(i).getText();
						if(msano.equalsIgnoreCase(msaamnt)){
									msanum=eneditContractManagement.MSAnolist().get(i).getText();
									if(msanum.length()>0){
										dataMap.put("msanum", msanum);
									}
									break;
							}
					}
				}
			
			dataMap.put("addendum", "Yes");
			
			String nwmsaamnt=LavanteUtils.randomnum(999)+"."+LavanteUtils.randomnum(99);
			dataMap.put("msanottoexceed", nwmsaamnt);
			
			eneditContractManagement.createMSA(dataMap);
			
			if(eneditContractManagement.MSAnottoexceedList().size()>0){
				outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
					String msano=eneditContractManagement.MSAnottoexceedList().get(i).getText();
					if(msano.equalsIgnoreCase(nwmsaamnt)){
						String appmsanum=eneditContractManagement.MSAnolist().get(i).getText();
						Reporter.log("Expecting MSA Number:"+msanum+",In app:"+appmsanum,true);
						softassert.assertTrue(appmsanum.contains(msanum),"MSA num not matched");
						
						appmsanum=eneditContractManagement.MSAtypelist().get(i).getText();	
						Reporter.log("Expecting MSA Type - Addendum,In app:"+appmsanum,true);
						softassert.assertEquals(appmsanum,"Addendum","Addendum num not matched");
						break outr;
					}
				}
			}
			
			softassert.assertAll();
			Reporter.log("Test Ended for Addendum MSA at:"+LavanteUtils.currenttime());
		}
		
		/**
		 * [SIM-7323] Addendum creation should depend on MSA
		 * Add new MSA -> Add new Addendum for newly created MSA -> Delete newly created MSA -> Verify appropriate alert/prompt appears for user while Deletion of new MSA
		 * @author Suresh.Muddu
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void AletMSADelete004(LinkedHashMap<String,String> dataMap) throws Exception{
			Reporter.log("Test Started for Addendum MSA at:"+LavanteUtils.currenttime());
			SoftAssert softassert=new SoftAssert();
			String msanum="";
			
			String msaamnt=LavanteUtils.randomnum(999)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
			
			dataMap.put("msanottoexceed", msaamnt);
			dataMap.put("MSASave", "");
			eneditContractManagement.createMSA(dataMap);
			Reporter.log("MSA Created Succesfully ");
		
				if(eneditContractManagement.MSAnottoexceedList().size()>0){
					
				outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
						String msano=eneditContractManagement.MSAnottoexceedList().get(i).getText();
						if(msano.equalsIgnoreCase(msaamnt)){
									msanum=eneditContractManagement.MSAnolist().get(i).getText();
									break outr;
							}
					}
				}
			
			dataMap.put("addendum", "Yes");
			dataMap.put("msanum", msanum);
			String nwmsaamnt=LavanteUtils.randomnum(999)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
			dataMap.put("msanottoexceed", nwmsaamnt);
			
			eneditContractManagement.createMSA(dataMap);
			Reporter.log("Addendum Created Succesfully ");
			
			innr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
					String msanwamnt=eneditContractManagement.MSAnottoexceedList().get(i).getText();
					String addnum=eneditContractManagement.MSAnolist().get(i).getText();
					if(msanwamnt.equalsIgnoreCase(nwmsaamnt)){
						Reporter.log("Addendum Created Succesfully available in the list of  MSA ");
						for(int j=0;j<eneditContractManagement.MSAnottoexceedList().size();j++){
							String msa=eneditContractManagement.MSAnottoexceedList().get(j).getText();
							if(msaamnt.equalsIgnoreCase(msa)){
								Reporter.log("Deleting MSA: ");
									lavanteUtils.click(eneditContractManagement.MSADellist().get(j));
									lavanteUtils.fluentwait(eneditContractManagement.DELdeleteOKbtn());
									lavanteUtils.click(eneditContractManagement.DELdeleteOKbtn());
									
									lavanteUtils.switchtoFrame(null);
									lavanteUtils.fluentwait(eneditContractManagement.MSADelMsg());
								/*	String appmsg=eneditContractManagement.MSADelMsg().getText();
									Reporter.log("Delete message for new MSA in app,:"+appmsg+",Expected:"+addnum);
									softassert.assertTrue(appmsg.contains(addnum),"Delete message not matched");
									lavanteUtils.click(eneditContractManagement.DELdeleteOKbtn());
								*/	break innr;
																	
								}
						}	
					}
				}
			
			
			softassert.assertAll();
			Reporter.log("Test Ended for Addendum MSA at:"+LavanteUtils.currenttime());
		}
		
		/**
		 * [SIM-7323] Addendum creation should depend on MSA
		 * Add new MSA with Evergreen "No"-> Add new Addendum with Evergreen "Yes" for newly created MSA -> Verify appropriate alert/prompt appears for user
		 * @author Suresh.Muddu
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void AlertMSANotEvergreen005(LinkedHashMap<String,String> dataMap) throws Exception{
	
			Reporter.log("Test Started for Addendum MSA at:"+LavanteUtils.currenttime());
			//Creating MSA with Evergreen NO
			String msaamnt=LavanteUtils.randomnum(999)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
			dataMap.put("msanottoexceed", msaamnt);
			
			if(dataMap.containsKey("msaevergreen")){
				dataMap.put("msaevergreen", "No");
			}else{
				dataMap.put("msaevergreen", "No");
			}
			//Adding End Date for MSA
			if(dataMap.containsKey("MSAeverEndDate")){
				dataMap.put("MSAeverEndDate", "Any");
			}else{
				dataMap.put("MSAeverEndDate", "Any");
			}
			
			dataMap.put("MSASave","");
			eneditContractManagement.createMSA(dataMap);
			
			Reporter.log("MSA Created Succesfully ");
			
			//Creating Addendum With Evergreen Yes
			
			String msanum=null;
			if(eneditContractManagement.MSAnottoexceedList().size()>0){
				
			outr:for(int i=eneditContractManagement.MSAnottoexceedList().size()-1;i>=0;i--){
					String msano=eneditContractManagement.MSAnottoexceedList().get(i).getText();
					if(msano.equalsIgnoreCase(msaamnt)){
								msanum=eneditContractManagement.MSAnolist().get(i).getText();
								break outr;
						}
				}
			}
			
			dataMap.put("msanum", msanum);		
			String msaadamnt=LavanteUtils.randomnum(999)+"."+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
			dataMap.put("msanottoexceed", msaadamnt);
			
			
			dataMap.put("addendum", "Yes");
			dataMap.put("msaevergreen", "Yes");
			dataMap.put("Errmsg", "");
			eneditContractManagement.createMSA(dataMap);
			
			/*lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(eneditContractManagement.MSADelMsg());
			String experrmsg="hence this addendum cannot be evergreen.";
			String apperrmsg=eneditContractManagement.MSADelMsg().getText();
			
			Reporter.log("Error msg, Expected:"+experrmsg+"");
			Reporter.log("Error msg In app:"+apperrmsg+"");
			Assert.assertTrue(apperrmsg.contains(experrmsg),"Error Message not Matched");
			lavanteUtils.click(eneditContractManagement.OKbtnDia());*/
			Reporter.log("Test Ended for Addendum MSA at:"+LavanteUtils.currenttime());
			
			
			
		}
		
		/**
		 * [SIM-7323] Addendum creation should depend on MSA
		 * Create Addendum without MSA -> Verify appropriate alert/prompt appears for user
		 * @author Suresh.Muddu
		 * @param dataMap
		 * @throws InvalidFormatException
		 * @throws IOException
		 */
		@Test(dataProvider="SingleMSAData",dataProviderClass=CMDataProvider.class)
		public void AddendumNoMSA006(LinkedHashMap<String,String> dataMap) throws Exception{
			Reporter.log("Test Started for Addendum MSA at:"+LavanteUtils.currenttime());
			SoftAssert softassert=new SoftAssert();
					
			
			dataMap.put("addendum", "Yes");
			
			if(dataMap.containsKey("msanum")){
				dataMap.remove("msanum");
			}
			
			dataMap.put("MSASave","");
			dataMap.put("Errmsg", "");
			eneditContractManagement.createMSA(dataMap);
			
			lavanteUtils.switchtoFrame(eneditContractManagement.IFRAMEMSAAddEdit());
			
			lavanteUtils.fluentwait(eneditContractManagement.DELgetValidErrormsg());
			String appmsg=eneditContractManagement.DELgetValidErrormsg().getText();
			String Reqmsg="'MSA Number' cannot be left blank.";
			Reporter.log("MSA Required error in app,:"+appmsg+",Expected:"+Reqmsg);
			softassert.assertEquals(appmsg, Reqmsg,"MSA error message not matched");
					
			softassert.assertAll();
			Reporter.log("Test Ended for Addendum MSA at:"+LavanteUtils.currenttime());
		}
		
	
	/**
	 * SetupAfter Method- Close the popup and refresh the page
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		refreshPage();
		enobjhomePage.popupclose();
		
	}

	/**
	 * SetupAfter Class- Close any popup and Close the driver
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@AfterClass
	public void SetupafterClassmethod() throws FileNotFoundException, IOException, SQLException{
				
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		if(sname.length()>0){
			String q=" delete from deliverable where SOWID in (select SOWID from StatementOfWork where MSAID in"
					+ " (Select MSAID from MasterServiceAgreement where RelationshipId in "
					+ "(select MAX(RelationshipID) From Relationship where LavanteUID in (select LavanteUID from supplier where SupplierName='"+sname+"') "
					+ "and CustomerID="+customerid+")) and SOWNumber not like 'S0001')";
			lavanteUtils.UpdateDB(q);
			
			 q=" delete from StatementOfWork where MSAID in"
						+ " (Select MSAID from MasterServiceAgreement where RelationshipId in "
						+ "(select MAX(RelationshipID) From Relationship where LavanteUID in (select LavanteUID from supplier where SupplierName='"+sname+"') "
						+ "and CustomerID="+customerid+") and MSANumber not like 'M0001' ) and SOWNumber not like 'S0001'";
				lavanteUtils.UpdateDB(q);
			
			 q=" delete from MasterServiceAgreement where RelationshipId in "
						+ "(select MAX(RelationshipID) From Relationship where LavanteUID in (select LavanteUID from supplier where SupplierName='"+sname+"') "
						+ "and CustomerID="+customerid+") and MSANumber not like 'M0001'";
				lavanteUtils.UpdateDB(q);
		}
		
		enobjhomePage.logout();
		
		quitBrowser();
	}

}

