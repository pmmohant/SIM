package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

import java.io.IOException;
import java.sql.SQLException;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.EditProfDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 07-12-2016
 * Created for  Enhancement for Address File-SIM-9593 Upload Location Template
 * Ended on 07-12-2016
 * @author Piramanayagam.S
 *
 */
public class UATAddressFilesTC extends PageInitiator{
	
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
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		List listofdatafrm=lavanteUtils.login("Search-Supp", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=(String) listofdatafrm.get(1);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
	
	}
	
	/**
	 * Before Method -For Navigating to Manage File Page
	 */
	@BeforeMethod
	public void before(){

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}

	/** Upload Address File
	 * Verify Hyper Link
	 * Verify Status
	 * Verify via Advance Search
	 * Verify in Edit Profile
	 * Verify in View Supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test(dataProvider="AddLocation",dataProviderClass=EditProfDataProvider.class)
	public void uploadAddressFile001(LinkedHashMap<String, String> dataMap) throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Address File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Address_Template.csv");
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("SupplierID", "1");	
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		
		String suppname="";
		String supid="";
		for(int i=0;i<enobjsupplierPage.iterateSearchHeaderFindColList("ERP").size();i++){
			supid=enobjsupplierPage.getColumnText("ERP",0);
			if(supid.contains(": ")&&(supid.contains(ERPNAMe))){
				System.out.println(supid);
				suppname=enobjsupplierPage.getColumnText("Name",0);
				String[] dsa=supid.split(": ");
				supid=dsa[1];
				break;
			}
		}
		
		Assert.assertTrue(supid.length()>0, "Supplier ID Not available");
		Assert.assertTrue(suppname.length()>0, "Supplier Name Not available");
		
		String Addrss1="AConSP"+LavanteUtils.randomnum();
		String Addrs2=""+LavanteUtils.randomnum();
		String Addrs3=""+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9)+"-"+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
		String city="AConSP"+LavanteUtils.randomnum(99999);
		String country="select MAX([Name]) from Country ";
		country=lavanteUtils.fetchDBdata(country);
		
		String state="select TOP 1 (Name)  from StateProvince where ISOCountryID in "
				+ " (select ISOCountryID from Country where Name='"+country+"')";
		
		state=lavanteUtils.fetchDBdata(state);
		
		String pin=""+lavanteUtils.randomnum(9999999);

		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);
		
		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,Addrss1 );
		LavanteUtils.editcsv(nwfile, 5,Addrs2 );
		LavanteUtils.editcsv(nwfile, 6,Addrs3 );
		LavanteUtils.editcsv(nwfile, 7,city );
		LavanteUtils.editcsv(nwfile, 8,state );
		LavanteUtils.editcsv(nwfile, 9,pin );
		LavanteUtils.editcsv(nwfile, 10,country );

		//	String supp=LavanteUtils.Readcsv(nwfile,1);
		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "LocationFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMELocationuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softassert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.LocationUploadListunqrecord().get(i).getText();
				System.out.println("Uploaded file Count,Expected:1,Actuals:"+count);
				Reporter.log("Uploaded file Record Count,Expected:1,Actuals:"+count);
				softassert.assertEquals(count,"1","File Record Count not matched");
				flag=true;
				break;
			}
		}
		
		Assert.assertTrue(flag,"File Status Not Expected");

		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		
		dataMap.put("Tab", "CompanyProfile");
		dataMap.put("SupplierName", "Equals To,"+suppname);	
		dataMap.put("CityAddress", "Equals To,"+city);		
		ensupplierAdvanced.buildQuery(dataMap);
	
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		String actsuppname=enobjsupplierPage.getColumnText("Name",0);
		System.out.println("Advance Search,Contact Email Search, Match,Actual:"+actsuppname+",Exp:"+suppname);
		Reporter.log("Advance Search,Contact Email Search,Actual:"+actsuppname+",Exp :"+suppname);
		softassert.assertEquals(actsuppname,suppname,"Advance Search,Contact Email Search , Not matched");	
		
		dataMap.put("supplierName", suppname);	
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
		dataMap.put("tab", "Company");
		eneditProfile.selectTab(dataMap);

		
		dataMap.put("DelPrevious", "");
		String fullAddrss1=Addrss1+" "+Addrs2+" "+Addrs3+" ; "+city+" ; "+state+" - "+pin+" ; "+country;
		dataMap.put("AddAddress",fullAddrss1);
		
		dataMap.put("Contact","ANY");
		dataMap.put("AddContact","Add New");
		
		eneditCompanyProfile.AddLocationContact(dataMap);

		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		enviewSupplier.clickOnSupplier(suppname);

		lavanteUtils.waitForTime(3000);
		String actContactAdress=enviewSupplier.cntactaddress().getText();
		System.out.println("Contact Address Match,Actual:"+actContactAdress+",Exp:"+fullAddrss1);
		Reporter.log("Contact Address Match,Actual:"+actContactAdress+",Exp :"+fullAddrss1);
		softassert.assertTrue(actContactAdress.contains(Addrss1),"Contact Address 1 Not matched"+Addrss1);	
		softassert.assertTrue(actContactAdress.contains(Addrs2),"Contact Address 2 Not matched"+Addrs2);	
		softassert.assertTrue(actContactAdress.contains(Addrs3),"Contact Address Add 3 Not matched"+Addrs3);	
		softassert.assertTrue(actContactAdress.contains(city),"Contact Address City Not matched"+city);	
		softassert.assertTrue(actContactAdress.contains(state),"Contact Address State Not matched"+state);	
		softassert.assertTrue(actContactAdress.contains(pin),"Contact Address Pin Not matched"+pin);	
		softassert.assertTrue(actContactAdress.contains(country),"Contact Address Country Not matched"+country);	
		
		softassert.assertAll();
		
		Reporter.log("Test Ended for Upload Address File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Address File-------");
	
	}

	/** Upload Error Address File by providing invalid State and Country verify the Count
	 * Verify the Error Log
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void InvalidErorAddressFile002() throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Invalid Error Address File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Address_Template.csv");

		String suppname=" select MAX(SupplierName) from Supplier where LavanteUID in  (select LavanteUID from Relationship where CustomerID="+customerid+" and RelationshipID in"
				+ " (select RelationshipID from Relationship_ERP_Map where ERPCustomerMapID=1)) "
				+ " and LavanteUID in (select LavanteUID from Supplier_Address_Map)";
		
		suppname=lavanteUtils.fetchDBdata(suppname);
		
		String supid=" select SupplierERPID from Relationship_ERP_Map where RelationshipID "
				+ "   in (select RelationshipID from Relationship where CustomerID="+customerid+" and LavanteUID"
				+ "     in (select LavanteUID from Supplier where SupplierName='"+suppname+"') ) ";
		supid=lavanteUtils.fetchDBdata(supid);
		
	
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		String Addrss1="AConSP"+LavanteUtils.randomnum();
		String Addrs2=""+LavanteUtils.randomnum();
		String Addrs3=""+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9)+"-"+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
		String city="AConSP"+LavanteUtils.randomnum(99999);
		String country="AutoSPCountry";
		String state="AutoSPState";
		String pin=""+lavanteUtils.randomnum(9999999);

		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);
		
		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,Addrss1 );
		LavanteUtils.editcsv(nwfile, 5,Addrs2 );
		LavanteUtils.editcsv(nwfile, 6,Addrs3 );
		LavanteUtils.editcsv(nwfile, 7,city );
		LavanteUtils.editcsv(nwfile, 8,state );
		LavanteUtils.editcsv(nwfile, 9,pin );
		LavanteUtils.editcsv(nwfile, 10,country );

		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "LocationFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMELocationuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"Status not matched");
				
				String count=enobjuploadFiles.LocationUploadListErrrecord().get(i).getText();
				String exp="1";
				System.out.println("Uploaded file Error Count,Expected:"+exp+",Actuals:"+count);
				Reporter.log("Uploaded file Error Count,Expected:"+exp+",Actuals:"+count);
				softassert.assertEquals(count,exp,"Error Count not matched");
				
				lavanteUtils.click(enobjuploadFiles.LocationErrorLog().get(i));
				lavanteUtils.switchtoFrame(enobjuploadFiles.IframeFileProcessLogMsg());
				
				String actermsg=enobjuploadFiles.ContactErrorLogMsg().get(0).getText();
				String expmsg="invalid Country or State/Province";
				System.out.println("Uploaded file Error Msg Count,Expected:"+expmsg+",Actuals:"+actermsg);
				Reporter.log("Uploaded file  Error Msg,Expected:"+expmsg+",Actuals:"+actermsg);
				softassert.assertEquals(actermsg,expmsg,"Error Msg not matched");
				
				flag=true;
				break;
			
			}
		}

		Assert.assertTrue(flag,"Data not Matched");
		
		softassert.assertAll();
		Reporter.log("Test Ended for Upload Invalid Error Address File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Error Invalid Address  File-------");
	
	}
	
	/** Upload Invalid File for Address File by providing Empty State and verify the Count
	 * Verify the Error Log
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void InCompleteAddressFile003() throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Incomplete Address File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Address_Template.csv");

		String suppname=" select MAX(SupplierName) from Supplier where LavanteUID in  (select LavanteUID from Relationship where CustomerID="+customerid+" and RelationshipID in"
				+ " (select RelationshipID from Relationship_ERP_Map where ERPCustomerMapID=1)) "
				+ " and LavanteUID in (select LavanteUID from Supplier_Contact_Map)";
		
		suppname=lavanteUtils.fetchDBdata(suppname);
		
		String supid=" select SupplierERPID from Relationship_ERP_Map where RelationshipID "
				+ "   in (select RelationshipID from Relationship where CustomerID="+customerid+" and LavanteUID"
				+ "     in (select LavanteUID from Supplier where SupplierName='"+suppname+"') ) ";
		supid=lavanteUtils.fetchDBdata(supid);
		
	
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		String Addrss1="AConSP"+LavanteUtils.randomnum();
		String Addrs2=""+LavanteUtils.randomnum();
		String Addrs3=""+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9)+"-"+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
		String city="AConSP"+LavanteUtils.randomnum(99999);
		String country="select MAX([Name]) from Country ";
		country=lavanteUtils.fetchDBdata(country);
		
		String state="";
		String pin=""+lavanteUtils.randomnum(9999999);

		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);
		
		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,Addrss1 );
		LavanteUtils.editcsv(nwfile, 5,Addrs2 );
		LavanteUtils.editcsv(nwfile, 6,Addrs3 );
		LavanteUtils.editcsv(nwfile, 7,city );
		LavanteUtils.editcsv(nwfile, 8,state );
		LavanteUtils.editcsv(nwfile, 9,pin );
		LavanteUtils.editcsv(nwfile, 10,country );

		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "LocationFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMELocationuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"Status not matched");
				
				String count=enobjuploadFiles.LocationUploadListErrrecord().get(i).getText();
				String exp="1";
				System.out.println("Uploaded file Error Count,Expected:"+exp+",Actuals:"+count);
				Reporter.log("Uploaded file Error Count,Expected:"+exp+",Actuals:"+count);
				softassert.assertEquals(count,exp,"Error Count not matched");
				
				lavanteUtils.click(enobjuploadFiles.LocationErrorLog().get(i));
				lavanteUtils.switchtoFrame(enobjuploadFiles.IframeFileProcessLogMsg());
				
				String actermsg=enobjuploadFiles.ContactErrorLogMsg().get(0).getText();
				String expmsg="State or Province column is required field";
				System.out.println("Uploaded file Error Msg Count,Expected:"+expmsg+",Actuals:"+actermsg);
				Reporter.log("Uploaded file  Error Msg,Expected:"+expmsg+",Actuals:"+actermsg);
				softassert.assertEquals(actermsg,expmsg,"Error Msg not matched");
				flag=true;
				break;
			}
		}
		
		Assert.assertTrue(flag,"Data not Matched");
		
		softassert.assertAll();
		Reporter.log("Test Ended for Upload Incomplete Address File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Incomplete Address  File-------");
	
	}

	/** Upload Address File
	 * Verify Hyper Link
	 * Verify Status
	 * Verify via Advance Search
	 * Verify in Edit Profile
	 * Verify in View Supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void DuplicateAddressFile004() throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Address File at:"+LavanteUtils.currenttime());
		
		String nwfile=LavanteUtils.CopyFile("Address_Template.csv");
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("SupplierID", "1");	
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		enobjsupplierBasicSearch.search(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
				+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
		ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
		
		
		String suppname="";
		String supid="";
		for(int i=0;i<enobjsupplierPage.iterateSearchHeaderFindColList("ERP").size();i++){
			supid=enobjsupplierPage.getColumnText("ERP",0);
			if(supid.contains(": ")&&(supid.contains(ERPNAMe))){
				System.out.println(supid);
				suppname=enobjsupplierPage.getColumnText("Name",0);
				String[] dsa=supid.split(": ");
				supid=dsa[1];
				break;
			}
		}
		
		Assert.assertTrue(supid.length()>0, "Supplier ID Not available");
		Assert.assertTrue(suppname.length()>0, "Supplier Name Not available");
				
		String Addrss1="AConSP"+LavanteUtils.randomnum();
		String Addrs2=""+LavanteUtils.randomnum();
		String Addrs3=""+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9)+"-"+LavanteUtils.randomnum(9)+LavanteUtils.randomnum(9);
		String city="AConSP"+LavanteUtils.randomnum(99999);
		String country="select MAX([Name]) from Country ";
		country=lavanteUtils.fetchDBdata(country);
		
		String state="select TOP 1 (Name)  from StateProvince where ISOCountryID in "
				+ " (select ISOCountryID from Country where Name='"+country+"')";
		
		state=lavanteUtils.fetchDBdata(state);
		
		String pin=""+lavanteUtils.randomnum(9999999);

		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);
		
		LavanteUtils.editcsv(nwfile, 1,supid );
		LavanteUtils.editcsv(nwfile, 2,ERPNAMe );
		LavanteUtils.editcsv(nwfile, 3,suppname );
		LavanteUtils.editcsv(nwfile, 4,Addrss1 );
		LavanteUtils.editcsv(nwfile, 5,Addrs2 );
		LavanteUtils.editcsv(nwfile, 6,Addrs3 );
		LavanteUtils.editcsv(nwfile, 7,city );
		LavanteUtils.editcsv(nwfile, 8,state );
		LavanteUtils.editcsv(nwfile, 9,pin );
		LavanteUtils.editcsv(nwfile, 10,country );

		String dupfile=LavanteUtils.CopyFile(nwfile);
		
		Reporter.log("Edit CSV:");
		
		dataMap.put("UploadType", "LocationFile");
		dataMap.put("UploadFile", nwfile);
		
		dataMap.put("Status", "Process Completed");
		boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
		Reporter.log("Upload File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMELocationuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softassert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.LocationUploadListunqrecord().get(i).getText();
				System.out.println("Uploaded Succss file Count,Expected:1,Actuals:"+count);
				Reporter.log("Uploaded Succss file Record Count,Expected:1,Actuals:"+count);
				softassert.assertEquals(count,"1","File Succss Record Count not matched");
				flag=true;
				break;
			}
		}
		
		Assert.assertTrue(flag,"Org File Status Not Expected");

		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("UploadFile", dupfile);
		
		dataMap.put("UploadOK", "OK");
		enobjuploadFiles.UploadFile(dataMap);
		
		Status=enobjuploadFiles.uploadFileGrid(dataMap);
		Assert.assertTrue(Status,"After Uploading Duplicate File Status Not Matched,Please Recheck");
		Reporter.log("Uploaded Duplicate File:"+nwfile);
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMELocationuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			if(fname.equalsIgnoreCase(nwfile)){
			
				Reporter.log("Uploaded file available in the list");
			
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertTrue(status.contains(expsttaus),"File name not matched");
				
				String href=enobjuploadFiles.ListUploadFile().get(i).getAttribute("href");
				Reporter.log("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
				softassert.assertTrue(href.contains(fname),"File name not matched");
				
				String count=enobjuploadFiles.LocationUploadListDuprecord().get(i).getText();
				System.out.println("Uploaded Dup file Count,Expected:1,Actuals:"+count);
				Reporter.log("Uploaded Dup file Record Count,Expected:1,Actuals:"+count);
				softassert.assertEquals(count,"1","Dup File Record Count not matched");
				flag=true;
				break;
			}
		}
		
		Assert.assertTrue(flag,"Dup File Status Not Expected");
		
		softassert.assertAll();
		
		Reporter.log("Test Ended for Upload Dup Address File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Dup Address File-------");
	
	}


	/** Upload Address File
	 * Verify Hyper Link
	 * Verify Status
	 * Verify via Advance Search
	 * Verify in Edit Profile
	 * Verify in View Supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test
	public void UITabVerification() throws Exception{	
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		Reporter.log("Test Started for Upload Address File at:"+LavanteUtils.currenttime());

		String actTab=enobjuploadFiles.TabLocation().getText();
		String expTab="	Location ";
		System.out.println("Tab Name:"+actTab+","+expTab);
		Reporter.log("Tab Name:"+actTab+","+expTab);
		softassert.assertEquals(actTab, expTab,"Tab Name Not Matched");
		softassert.assertAll();
		
		Reporter.log("Test Ended for Upload Dup Address File at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended-----Upload Dup Address File-------");
	
	}
	
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		enobjhomePage.backtoSearch();
		enobjhomePage.popupclose();
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

