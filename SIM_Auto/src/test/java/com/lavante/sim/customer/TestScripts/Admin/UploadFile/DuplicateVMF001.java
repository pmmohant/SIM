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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 25-01-2017
 * Created for VMF Upload
 * Enhancement covered SIM-10950
 * Ended on 30-01-2017
 * @author Piramanayagam.S
 *
 */
public class DuplicateVMF001 extends PageInitiator {
	
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
		
	
	}
	
	@BeforeMethod
	public void before(){
		
		//One of the test in this class navigate to supplier search page.
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab","UploadFiles");
		enobjhomePage.selectTab(dataMap);
	}

	/**SIM-10950 In File Duplicate
	 * Upload VMF with DUNS Number
	 * Verify the duplicate supplier count
	 * Verify the sucessful supplier with the value duns number
	 * 			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void InfileDuplicate001() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for for InfIle Duplicate  VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	String rnm=""+lavanteUtils.generateRandomNumber9OnLength(9);
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, rnm);
	LavanteUtils.editcsv(nwfile, 5, "BU");
	LavanteUtils.editcsv(nwfile, 18, ""+rnm+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, ""+rnm);
	
	
//	LavanteUtils.editMultiRowcsv(nwfile,1,1, "23");
	//1st Row is Unique to be inserted into Application
	//2nd Row is for duplicate legal id , the below line is to create the 2nd row and for ease of use using this line
	LavanteUtils.editMultiRowcsv(nwfile,2,4,rnm ); //Legal ID  -Result Duplicate Legal ID 
	LavanteUtils.editMultiRowcsv(nwfile,3,4, ""); //LegaL ID -- rEsult Duplicate  Duns Num
	LavanteUtils.editMultiRowcsv(nwfile,4,24, ""); //Duns Number -- Result Duplicate ERP ID ERP NAME
	LavanteUtils.editMultiRowcsv(nwfile,5,1, ""); //ERP ID -- Result SNAME and PCODE
	LavanteUtils.editMultiRowcsv(nwfile,6,14, "");//PCODE  -- Result SNAME and Phone
	LavanteUtils.editMultiRowcsv(nwfile,7,16, "");//Phone  -- Result SNAME and FAX
	LavanteUtils.editMultiRowcsv(nwfile,8,17, "");//FAX  -- Result SNAME and EMAIL
	
	
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	
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
				
				status=enobjuploadFiles.VMFUploadListUniqrecord().get(i).getText();
				expsttaus="1";
				Reporter.log("Uploaded file Unique Count,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File name not matched");
				
				
				status=enobjuploadFiles.VMFUploadListduprecord().get(i).getText();
				expsttaus="7";
				Reporter.log("Uploaded file Duplicate Count,Expected:"+expsttaus+",Actuals:"+status);
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
	dataMap1.put("supplierName", expSname);
	dataMap1.put("Search", "");
	enobjsupplierBasicSearch.search(dataMap);					
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
		Reporter.log("Query Returned with Search data");
		
		String actSupName=enobjsupplierPage.supplist().get(0).getText();
		System.out.println("Uploaded Supplier in the Search Page,"+expSname+",Actual:"+actSupName);
		Reporter.log("Uploaded Supplier in the Search Page,"+expSname+",Actual:"+actSupName);
		softassert.assertEquals(actSupName,expSname,"Supplier Name Not Matched");
		
		lavanteUtils.click(enobjsupplierPage.iterateSearchHeaderFindColList("Name").get(0));
		lavanteUtils.switchtoFrame(null);

		String isduns=enviewSupplier.doyouhaveDuns().getText();
		System.out.println("Duns Number QN,Expected:Yes,Actuals:"+isduns);
		Reporter.log("Duns Number QN,Expected:Yes,Actuals:"+isduns);
		Assert.assertEquals(isduns, "Yes","Duns Num Qn Not Matched");
		
		String duns=enviewSupplier.DUNSNum().getText();
		System.out.println("Duns Number,Expected:"+rnm+",Actuals:"+duns);
		Reporter.log("Duns Number,Expected:"+rnm+",Actuals:"+duns);
		softassert.assertEquals(duns, rnm,"Duns Num Not Matched");
		
		enobjhomePage.backtoSearch();
		
		
	}

	
	softassert.assertAll();
	Reporter.log("Test Ended for InfIle Duplicate VMF at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---for InfIle Duplicate -------------");
}

	/**SIM-10950  In Customer Duplicate
	 * Upload VMF 
	 * Verify the duplicate supplier Count
	 * 			
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void InCustomerDuplicate002() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for for InCustomer Duplicate  VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	/*String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);*/
	
	String legalquery="Select  Top 1 dbo.lcfn_decrypt(LegalIdentifier,'TripTheLightFandango') From Supplier  where LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") ";
	legalquery=lavanteUtils.fetchDBdata(legalquery);
	
	String dunsquery="Select Top 1 DunsNumber  from Supplier Where Len( IsNull(DunsNumber,0))>8 and LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") ";
	dunsquery=lavanteUtils.fetchDBdata(dunsquery);
	
	String notdunsquery="Select Top 1 DunsNumber  from Supplier Where Len( IsNull(DunsNumber,0))>8 "
			+ " and LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") and DUNSNumber not in ('"+dunsquery+"') ";
	notdunsquery=lavanteUtils.fetchDBdata(notdunsquery);
	
	String erpQuery=" select MAX(SupplierERPID) from Relationship_ERP_Map where RelationshipID in ( select RelationshipID from Relationship where CustomerID="+customerid+")  "
			+ " and ERPCustomerMapID in (Select ERPCustomerMapID from ERPCustomerMap where CustomerID ="+customerid+" and ERPSource='SAP')"; 
	erpQuery=lavanteUtils.fetchDBdata(erpQuery);
	
	String noterpquery=" select MAX(SupplierERPID) from Relationship_ERP_Map where RelationshipID in ( select RelationshipID from Relationship where CustomerID="+customerid+")  "
			+ " and ERPCustomerMapID in (Select ERPCustomerMapID from ERPCustomerMap where CustomerID ="+customerid+" and ERPSource='SAP') and SupplierERPID not in ('"+erpQuery+"') "; 
	noterpquery=lavanteUtils.fetchDBdata(noterpquery);
	
	LavanteUtils.editMultiRowcsv(nwfile,1,1, noterpquery);
	LavanteUtils.editMultiRowcsv(nwfile,1,2, "LegalSP"+lavanteUtils.randomnum());
	LavanteUtils.editMultiRowcsv(nwfile,1,4,legalquery );
	LavanteUtils.editMultiRowcsv(nwfile,1,24, notdunsquery);
	
	lavanteUtils.waitForTime(4000);
	LavanteUtils.editMultiRowcsv(nwfile,2,1, "");
	LavanteUtils.editMultiRowcsv(nwfile,2,2, "DunsSP"+lavanteUtils.randomnum());
	LavanteUtils.editMultiRowcsv(nwfile,2,4, ""); //LegaL ID -- rEsult Duplicate  Duns Num
	LavanteUtils.editMultiRowcsv(nwfile,2,24, dunsquery); //-- rEsult Duplicate  Duns Num
	
	lavanteUtils.waitForTime(4000);
	LavanteUtils.editMultiRowcsv(nwfile,3,2, "ERPSP"+lavanteUtils.randomnum());
	LavanteUtils.editMultiRowcsv(nwfile,3,24, ""); //Duns Number -- Result Duplicate ERP ID ERP NAME
	LavanteUtils.editMultiRowcsv(nwfile,3,1, erpQuery);  //-- Result Duplicate ERP ID ERP NAME
	
	String postalCodeSName="  select MAX(SupplierName) from Supplier where LavanteUID in ( select LavanteUID from Supplier_Address_Map where AddressID in ("
			+ "     select AddressID from Address where datalength(ZipPostalCode)>0 ) ) and LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+")  " ;
	postalCodeSName=lavanteUtils.fetchDBdata(postalCodeSName);
    String query="select ZipPostalCode from Address where AddressID in ( select AddressID from Supplier_Address_Map where LavanteUID in"
	+ " (select LavanteUID from Supplier where SupplierName='"+postalCodeSName+"'))";
	String id=lavanteUtils.fetchDBdata(query);

	LavanteUtils.editMultiRowcsv(nwfile,4,1, ""); //ERP ID
    LavanteUtils.editMultiRowcsv(nwfile,4,2, postalCodeSName);
	LavanteUtils.editMultiRowcsv(nwfile,4,14, id);// Result SNAME and PCODE
	
	query="select MAX(SupplierPhone) from Supplier where LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") and SupplierName not in ('"+postalCodeSName+"')  " ;
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,5,14, "");//PCODE  
	LavanteUtils.editMultiRowcsv(nwfile,5,16,id); //Result SNAME and Phone
	String supPhoneSname="select MAX(SupplierName) from Supplier where SupplierPhone='"+id+"' and LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+")  and SupplierName not in ('"+postalCodeSName+"') ";
	supPhoneSname=lavanteUtils.fetchDBdata(supPhoneSname);
	LavanteUtils.editMultiRowcsv(nwfile,5,2, supPhoneSname);
	
	query="select MAX(SupplierFax) from Supplier where LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+")  and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"') ";
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,6,16, "");//Phone  
	LavanteUtils.editMultiRowcsv(nwfile,6,17,id); //Result SNAME and FAX
	String supFaxSName="select MAX(SupplierName) from Supplier where SupplierFax='"+id+"' and LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+")  and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"')  " ;
	supFaxSName=lavanteUtils.fetchDBdata(supFaxSName);
	LavanteUtils.editMultiRowcsv(nwfile,6,2, supFaxSName);
	
	query="select MAX(SupplierEmail) from Supplier where LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"','"+supFaxSName+"')  " ;
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,7,17,"");//FAX
	LavanteUtils.editMultiRowcsv(nwfile,7,18, id);//Result SNAME and EMAIL
	query="select MAX(SupplierName) from Supplier where SupplierEmail='"+id+"' and LavanteUID in (select LavanteUID from Relationship where customerID="+customerid+") and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"','"+supFaxSName+"')  " ;
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,7,2, id);
	
	Reporter.log("Edit CSV:"+nwfile);
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	
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
				String expsttaus="Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File Status not matched");
				
				String total=enobjuploadFiles.VMFUploadListTotalCount().get(i).getText();
				String expTotal="7";
				Reporter.log("Uploaded file status,Expected:"+expTotal+",Actuals:"+total);
				softassert.assertEquals(total,expTotal,"File Status not matched");
				
				
				String dupCount=enobjuploadFiles.VMFUploadListduprecord().get(i).getText();
				String expDupcount="7";
				Reporter.log("Uploaded file status,Expected:"+expDupcount+",Actuals:"+dupCount);
				softassert.assertEquals(dupCount,expDupcount,"File Status not matched");
				
				flag=true;
				break;
	}
	
	softassert.assertTrue(flag,"File not available in the list");
	
	softassert.assertAll();
	Reporter.log("Test Ended for InCustomer Duplicate VMF at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---for InCustomer Duplicate -------------");
	}
	
}
	
	

	/**SIM-10950  In Customer Duplicate
	 * Upload VMF 
	 * Verify the duplicate supplier Count
	 * 			
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void InNetworkCustomerDuplicate003() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for for In Network Customer Duplicate  VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	/*String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);*/
	
	String legalquery="Select  Top 1 dbo.lcfn_decrypt(LegalIdentifier,'TripTheLightFandango') From Supplier  where LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+")) and datalength(dbo.lcfn_decrypt(LegalIdentifier,'TripTheLightFandango'))>8";
	legalquery=lavanteUtils.fetchDBdata(legalquery);
	
	String dunsquery="Select Top 1 DunsNumber  from Supplier Where Len( IsNull(DunsNumber,0))>8 and LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+")) ";
	dunsquery=lavanteUtils.fetchDBdata(dunsquery);
	
	String notdunsquery="Select Top 1 DunsNumber  from Supplier Where Len( IsNull(DunsNumber,0))>8 "
			+ " and LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+")) and DUNSNumber not in ('"+dunsquery+"') ";
	notdunsquery=lavanteUtils.fetchDBdata(notdunsquery);
	
	String erpQuery=" select MAX(SupplierERPID) from Relationship_ERP_Map where RelationshipID in ( select RelationshipID from Relationship where CustomerID not in ("+customerid+"))  "
			+ " and ERPCustomerMapID in (Select ERPCustomerMapID from ERPCustomerMap where CustomerID ="+customerid+" and ERPSource='SAP')"; 
	erpQuery=lavanteUtils.fetchDBdata(erpQuery);
	
	String noterpquery=" select MAX(SupplierERPID) from Relationship_ERP_Map where RelationshipID in ( select RelationshipID from Relationship where CustomerID not in ('"+customerid+"'))  "
			+ " and ERPCustomerMapID in (Select ERPCustomerMapID from ERPCustomerMap where CustomerID not in ("+customerid+") and ERPSource='SAP') and SupplierERPID not in ('"+erpQuery+"') "; 
	noterpquery=lavanteUtils.fetchDBdata(noterpquery);
	
	LavanteUtils.editMultiRowcsv(nwfile,1,1, noterpquery);
	LavanteUtils.editMultiRowcsv(nwfile,1,2, "LegalSP"+lavanteUtils.randomnum());
	LavanteUtils.editMultiRowcsv(nwfile,1,4,legalquery );
	LavanteUtils.editMultiRowcsv(nwfile,1,24, notdunsquery);
	
	lavanteUtils.waitForTime(4000);
	LavanteUtils.editMultiRowcsv(nwfile,2,1, "");
	LavanteUtils.editMultiRowcsv(nwfile,2,2, "DunsSP"+lavanteUtils.randomnum());
	LavanteUtils.editMultiRowcsv(nwfile,2,4, ""); //LegaL ID -- rEsult Duplicate  Duns Num
	LavanteUtils.editMultiRowcsv(nwfile,2,24, dunsquery); //-- rEsult Duplicate  Duns Num
	
	lavanteUtils.waitForTime(4000);
	LavanteUtils.editMultiRowcsv(nwfile,3,2, "ERPSP"+lavanteUtils.randomnum());
	LavanteUtils.editMultiRowcsv(nwfile,3,24, ""); //Duns Number -- Result Duplicate ERP ID ERP NAME
	LavanteUtils.editMultiRowcsv(nwfile,3,1, erpQuery);  //-- Result Duplicate ERP ID ERP NAME
	
	String postalCodeSName="  select MAX(SupplierName) from Supplier where LavanteUID in ( select LavanteUID from Supplier_Address_Map where AddressID in ("
			+ "     select AddressID from Address where datalength(ZipPostalCode)>0 ) ) and LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+"))  " ;
	postalCodeSName=lavanteUtils.fetchDBdata(postalCodeSName);
    String query="select ZipPostalCode from Address where AddressID in ( select AddressID from Supplier_Address_Map where LavanteUID in"
	+ " (select LavanteUID from Supplier where SupplierName='"+postalCodeSName+"'))";
	String id=lavanteUtils.fetchDBdata(query);

	LavanteUtils.editMultiRowcsv(nwfile,4,1, ""); //ERP ID
    LavanteUtils.editMultiRowcsv(nwfile,4,2, postalCodeSName);
	LavanteUtils.editMultiRowcsv(nwfile,4,14, id);// Result SNAME and PCODE
	
	query="select MAX(SupplierPhone) from Supplier where LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+")) and SupplierName not in ('"+postalCodeSName+"')  " ;
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,5,14, "");//PCODE  
	LavanteUtils.editMultiRowcsv(nwfile,5,16,id); //Result SNAME and Phone
	String supPhoneSname="select MAX(SupplierName) from Supplier where SupplierPhone='"+id+"' and LavanteUID in (select LavanteUID from Relationship where customerID not in ('"+customerid+"'))  and SupplierName not in ('"+postalCodeSName+"') ";
	supPhoneSname=lavanteUtils.fetchDBdata(supPhoneSname);
	LavanteUtils.editMultiRowcsv(nwfile,5,2, supPhoneSname);
	
	query="select MAX(SupplierFax) from Supplier where LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+"))  and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"') ";
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,6,16, "");//Phone  
	LavanteUtils.editMultiRowcsv(nwfile,6,17,id); //Result SNAME and FAX
	String supFaxSName="select MAX(SupplierName) from Supplier where SupplierFax='"+id+"' and LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+"))  and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"')  " ;
	supFaxSName=lavanteUtils.fetchDBdata(supFaxSName);
	LavanteUtils.editMultiRowcsv(nwfile,6,2, supFaxSName);
	
	query="select MAX(SupplierEmail) from Supplier where LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+")) and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"','"+supFaxSName+"')  " ;
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,7,17,"");//FAX
	LavanteUtils.editMultiRowcsv(nwfile,7,18, id);//Result SNAME and EMAIL
	query="select MAX(SupplierName) from Supplier where SupplierEmail='"+id+"' and LavanteUID in (select LavanteUID from Relationship where customerID not in ("+customerid+")) and SupplierName not in ('"+supPhoneSname+"','"+postalCodeSName+"','"+supFaxSName+"')  " ;
	id=lavanteUtils.fetchDBdata(query);
	LavanteUtils.editMultiRowcsv(nwfile,7,2, id);
	
	Reporter.log("Edit CSV:"+nwfile);
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	
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
				String expsttaus="Upload Process Completed";
				Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
				softassert.assertEquals(status,expsttaus,"File Status not matched");
				flag=true;
				break;
			}
	}
	
	Assert.assertTrue(flag,"File not available in the list");
	
	softassert.assertAll();
	Reporter.log("Test Ended for InCustomer Duplicate VMF at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---for InCustomer Duplicate -------------");
}
	
	
	/**
	 * After method is to refresh the page
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		
		enobjhomePage.backtoSearch();
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

