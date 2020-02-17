package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

import java.io.File;
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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 10-3-2016
 * Created for VMF Upload
 * Enhancement covered SIM-7655
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class UploadVMFFile extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	String dir="src"+File.separator+"test"+File.separator+"resources"+File.separator+"data";
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
		List listofdatafrm=lavanteUtils.login("VMF", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerid=""+listofdatafrm.get(1);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
				
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);
	
	}
	

	/**SIM-7665 Handling of duplicates through VMF to be implemented for 'No response' suppliers
	 * Upload VMF
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadVMFUpdate001() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Update Upload VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	String expemailID="AutoSP"+LavanteUtils.randomnum();
	
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
	
	dataMap.put("maintab","Files");
	enobjhomePage.selectTab(dataMap);

	LavanteUtils.editcsv(nwfile, 1, supid);
	LavanteUtils.editcsv(nwfile, 2, suppname);	
	LavanteUtils.editcsv(nwfile, 6, "gmailcom");
	
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	dataMap.put("UpdateRecords", "OK");
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File not available in the list");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean fstatus=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(fstatus,"Current File not available in the list");
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

			if(fname.equalsIgnoreCase(nwfile)){	
				Reporter.log("Uploaded file available in the list");
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Update Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File name not matched");
				flag=true;
				break;
			}
	}
	
	Assert.assertTrue(flag,"File not available in the list");
	
	LinkedHashMap<String,String> dataMap1=new LinkedHashMap<String, String>();
	lavanteUtils.switchtoFrame(null);
	
	dataMap1.put("maintab","Supplier");	
	enobjhomePage.selectTab(dataMap1);
	
	lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
	dataMap1.put("supplierName", suppname);
	dataMap1.put("Search", "");
	enobjsupplierBasicSearch.search(dataMap);					
	
	Reporter.log("Navigated to Search Page");
		
	dataMap1.put("Communicate", "");
	dataMap1.put("Reinvite", "");
	enobjsupplierPage.supplierSelectionandProfileAction(dataMap1);
	Reporter.log("In Reinvite Page");
	
	expemailID=expemailID+"@gmail.com";
	lavanteUtils.switchtoFrame(enobjsupplierPage.IFRAMEreinvite());
	
	for(int i=0;i<enobjsupplierPage.ListContact().size();i++){
		String appemail=enobjsupplierPage.ListContact().get(i).getText();
		if(appemail.contains(expemailID)){
			Reporter.log("Added Email Via VMF File:"+expemailID+",In app:"+appemail);
			softassert.assertTrue(appemail.contains(expemailID),"Email ID not matched");
			flag=true;
			break;
			}
		}		
		
	softassert.assertTrue(flag,"Please Retest");
	LinkedHashMap<String,String> dataMaps=new LinkedHashMap<String, String>();	
	dataMaps.put("maintab","Files");	
	enobjhomePage.selectTab(dataMaps);
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended----------------");
}

	/**SIM-7665 Handling of duplicates through VMF to be implemented for 'No response' suppliers
	 * Upload VMF
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadVMFDuplicate002() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Duplicate Upload VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	Reporter.log("File:"+nwfile);
	String id=""+LavanteUtils.randomnum();
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 18, ""+lavanteUtils.generateRandomNumber9OnLength(9)+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	
	Reporter.log("CSV 1:"+nwfile);
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	lavanteUtils.waitForTime(8000);
	String nwfile2=LavanteUtils.CopyFile(nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"File Status after upload");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"File Status after upload");
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

		if(fname.equalsIgnoreCase(nwfile)){
			
			Reporter.log("Succesfully uploaded the file available in the list");
			Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			softassert.assertEquals(fname,nwfile,"File name not matched");
		
			String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
			String expsttaus="Upload Process Completed";
			Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			softassert.assertEquals(status,expsttaus,"Status not matched");
			flag=true;
			break;
			
		}
	}
	
	softassert.assertTrue(flag,"File not available in the list");
	
	lavanteUtils.switchtoFrame(null);
	enobjuploadFiles.uploadFileGrid(dataMap);
	Reporter.log("Uploading the same file without Update records");
	
	Reporter.log("CSV 2:"+nwfile);
	dataMap.put("UploadOK", "OK");
	dataMap.put("UploadFile", nwfile2);
	enobjuploadFiles.UploadFile(dataMap);
	
	enobjuploadFiles.uploadFileGrid(dataMap);
	Reporter.log("Uploading File again:"+nwfile2);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();){
		
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
		if(fname.equalsIgnoreCase(nwfile2)){

				Reporter.log("Succesfully uploaded the duplicated file available in the list");
				System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile2);
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile2);
				softassert.assertEquals(fname,nwfile2,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"Status not matched");
				
				String appduprecord=enobjuploadFiles.VMFUploadListduprecord().get(i).getText();
				String expduprecord="1";
				System.out.println("Uploaded file duplicate Record,Expected:"+expduprecord+",Actuals:"+appduprecord);
				Reporter.log("Uploaded file duplicate Record,Expected:"+expduprecord+",Actuals:"+appduprecord);
				softassert.assertEquals(appduprecord,expduprecord,"Dup Record not matched");
				flag=true;
				break;
			}
		}
		
		softassert.assertTrue(flag,"Data not matched");
		softassert.assertAll();
		Reporter.log("Test Ended for Upload VMF at:"+LavanteUtils.currenttime());
}
		
	/**SIM-7665 Handling of duplicates through VMF to be implemented for 'No response' suppliers
	 * Upload VMF
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadVMFError003() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Error Upload VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	Reporter.log("File:"+nwfile);

	String id=""+LavanteUtils.randomnum();
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);

	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 18, expSname);
	LavanteUtils.editcsv(nwfile, 24, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	
	Reporter.log("CSV:"+nwfile);
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File Status");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean Status2=enobjuploadFiles.uploadFileGrid(dataMap);
	Reporter.log("Upload File Status:"+Status2);
	Assert.assertTrue(Status2,"Current File Status");
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());

	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
	
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

		if(fname.equalsIgnoreCase(nwfile)){
		
			Reporter.log("Uploaded file available in the list");
			
			fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			softassert.assertEquals(fname,nwfile,"File name not matched");
			
			String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
			String expsttaus="Upload Process Completed";
			Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			softassert.assertEquals(status,expsttaus,"Status name not matched");
			
			String apperrecrd=enobjuploadFiles.VMFUploadListerrrecord().get(i).getText();
			String experrcrd="1";
			Reporter.log("Uploaded file Error Record Count,Expected:"+experrcrd+",Actuals:"+apperrecrd);
			softassert.assertEquals(apperrecrd,experrcrd,"File Error Count not matched,Expected:"+experrcrd+", In app"+apperrecrd);
			flag=true;
			break;
		}
	}
	
	softassert.assertTrue(flag,"File Not Available");
		
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended----------------");
}

	/**SIM-7665 Handling of duplicates through VMF to be implemented for 'No response' suppliers
	 * Upload VMF
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadVMFUniq004() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Unique Upload VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	Reporter.log("File:"+nwfile);
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 18, ""+lavanteUtils.generateRandomNumber9OnLength(9)+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	
	Reporter.log("File 2:"+nwfile);
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Status Before upload");
	
	dataMap.put("UploadFile", nwfile);
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Status after upload");
	Reporter.log("Upload File:");
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

		if(fname.equalsIgnoreCase(nwfile)){
		 
			Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			softassert.assertEquals(fname,nwfile,"File name not matched");
			
			String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
			String expsttaus="Upload Process Completed";
			Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			softassert.assertEquals(status,expsttaus,"File Status not matched");
			
			String apperrrecrd=enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
			String experrrcrd="1";
			Reporter.log("Uploaded file Unique Record Count,Expected:"+experrrcrd+",Actuals:"+apperrrecrd);
			softassert.assertEquals(apperrrecrd,experrrcrd,"Unique record not matched");
			flag=true;
			
			break;
		}
		
	}
	//Second verification
	
	if(flag==true){
	
		flag=false;
		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(null);
		
		dataMap.put("maintab","Supplier");	
		enobjhomePage.selectTab(dataMap);
		
		lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
		dataMap.put("supplierName", expSname);
		dataMap.put("Search", "");
		enobjsupplierBasicSearch.search(dataMap);							
		Reporter.log("In Search page");
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			String suppname=enobjsupplierPage.getColumnText("Name",0);
			Reporter.log("Added Supplier via VMF File,"+expSname+",In app:"+suppname);
			softassert.assertEquals(suppname, expSname,"Supplier name not matched");
			flag=true;
			}
		}
	
	if(flag==false)
	{
		softassert.assertTrue(false,"Data not matched");
		
	}

	LinkedHashMap<String,String> dataMaps=new LinkedHashMap<String, String>();	
	dataMaps.put("maintab","Files");	
	enobjhomePage.selectTab(dataMaps);
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF at:"+LavanteUtils.currenttime());
	
}
		
	/**SIM-7665 Handling of duplicates through VMF to be implemented for 'No response' suppliers
	 * Empty Template Upload VMF
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadVMFEmptyTemplate005() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Unique Upload VMF at:"+LavanteUtils.currenttime());

	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	Reporter.log("File:"+nwfile);
	for(int i=0;i<=24;i++){
		LavanteUtils.editcsv(nwfile, i, "");	
	}
	
	Reporter.log("Empty Template CSV:"+nwfile);
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	
	if(Status==true){
		dataMap.put("UploadType", "Supplier File");
		dataMap.put("UploadFile", nwfile);
		dataMap.put("UploadOK", "");
		
		enobjuploadFiles.UploadFile(dataMap);
		
		boolean Status2=enobjuploadFiles.uploadFileGrid(dataMap);
		
		if(Status2==true){
			enobjuploadFiles.uploadFileGrid(dataMap);
		
		Reporter.log("Upload File:");
		
		lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
		
		for(int i=0;i<enobjuploadFiles.ListUploadFile().size();){
			
			String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

			if(fname.equalsIgnoreCase(nwfile)){
			
				fname=enobjuploadFiles.ListUploadFile().get(i).getText();
				Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
				softassert.assertEquals(fname,nwfile,"File name not matched");
				
				String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
				String expsttaus="Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File Status not matched");
				
				String apperrrecrd=enobjuploadFiles.VMFUploadListerrrecord().get(i).getText();
				String experrrcrd="0";
				Reporter.log("Uploaded file Error Record Count,Expected:"+experrrcrd+",Actuals:"+apperrrecrd);
				softassert.assertEquals(apperrrecrd,experrrcrd,"Unique record not matched,Expected:"+experrrcrd+",Actuals:"+apperrrecrd);
				flag=true;
				break;
			}
		}
	}
		
	}else {
		softassert.assertTrue(false,"Status Not Matched ,So File Upload did not happen");
		flag=true;
	}
	if(flag==false)
	{
		softassert.assertTrue(false,"Data not matched");
		
	}
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF at:"+LavanteUtils.currenttime());
	
	}
		
	
	/**
	 * After method is to refresh the page
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		lavanteUtils.refreshPage();
		enobjhomePage.popupclose();
		
	}
	
	
	/**
	 * After Class logout and driver quitting
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

