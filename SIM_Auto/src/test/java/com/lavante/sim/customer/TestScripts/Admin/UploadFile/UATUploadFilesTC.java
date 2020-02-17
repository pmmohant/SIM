package com.lavante.sim.customer.TestScripts.Admin.UploadFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.SupplierSearchDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 24-08-2016
 * Created for  UAT
 * Ended on 28-08-2016
 * @author Piramanayagam.S
 *
 */
public class UATUploadFilesTC extends PageInitiator{
	
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
		
	
	@BeforeMethod
	public void before(){

		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Files");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}
	
	/** Verify Manage File
	 * Verify Download File
	 * Verify Template Section
	 * Verify Upload Files Page Title
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * 
	 * Replacement of ManageFileTC0001
	 */
	@Test
	public void UITitleVerifyMngeFile001() throws Exception{	
		System.out.println("------------Test Started for  Title-------------------");
		Reporter.log("Test Started for  Upload File Page Title,verify:"+LavanteUtils.currenttime());
		
		
		String main="[id*='main'] [href*='Files']";
		lavanteUtils.waitForTime(3000);
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.Scrollintoview(driver.findElement(By.cssSelector(main)));
		lavanteUtils.fluentwait(driver.findElement(By.cssSelector(main)));
	
		lavanteUtils.getText(driver.findElement(By.cssSelector(main)));
		
		lavanteUtils.click(driver.findElement(By.cssSelector(main)));
		
		String sub="[id*='sub'] [href*='customerUploadFiles.lvp']";
		String actUploadtitle=lavanteUtils.getText(driver.findElement(By.cssSelector(sub)));
		System.out.println(actUploadtitle);
		String exptitle="Upload Files";
		Assert.assertEquals(actUploadtitle, exptitle,"Upload File Title Not Matched");
				
		String acttitle=enobjuploadFiles.uploadFiletitle().getText();
		System.out.println("Upload File:"+exptitle+",in app:"+acttitle);
		Reporter.log("Upload File, Page Title,:"+exptitle+",in app:"+acttitle);
		Assert.assertEquals(exptitle,acttitle,"Upload File");
	
				
		String subs="[id*='sub'] [href*='customerDownloadFiles.lvp']";
		String expdownloadtitle="Download Files";
		String actDownloadtitle=lavanteUtils.getText(driver.findElement(By.cssSelector(subs)));
		System.out.println(actDownloadtitle);
		
		Assert.assertEquals(actDownloadtitle, expdownloadtitle,"Download File Title Not Matched");
		
		Reporter.log("Test Ended for Upload File Page Title at:"+LavanteUtils.currenttime());
	}
		
	/** Upload VMF  in Business unit with  Customer organization from DB and verify in invite new supplier- N/A
	 *  Upload VMF  in Business unit  with  OWN data ,and verify in invite new supplier
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadVMFBusinessunit002() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for VMF in Business Unit at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	String expemailID="AutoSP"+LavanteUtils.randomnum();
	/*String buquery="select MAX(u.UTFString) FROM CustomerOrganization c,Usertranslation u where CustomerID="+customerid 
			+ " and c.OrganizationName_i18nKey=u.i18nKey";*/
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 5, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 18, ""+lavanteUtils.generateRandomNumber9OnLength(9)+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	
	String supp=LavanteUtils.Readcsv(nwfile,1);
	String buname=LavanteUtils.Readcsv(nwfile,5);
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	if(Status==true){
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean upstatus=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(upstatus,"Newly Uploaded file Status:"+upstatus);
	Reporter.log("Upload File:");
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();){
		
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();

		if(fname.equalsIgnoreCase(nwfile)){	
		
			Reporter.log("Uploaded file available in the list");
			fname=enobjuploadFiles.ListUploadFile().get(i).getText();
			
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
	
		Assert.assertTrue(flag,"File Available in the list");
		flag=false;
		
		LinkedHashMap<String,String> dataMap1=new LinkedHashMap<String, String>();
		dataMap1.put("maintab","Supplier");	
		enobjhomePage.selectTab(dataMap1);
		
		lavanteUtils.click(enobjsupplierPage.inviteNwlink());
		
		lavanteUtils.fluentwait(enobjInvitenewSupplier.inviteorg());
		lavanteUtils.click(enobjInvitenewSupplier.inviteorg());
		
		softassert.assertTrue(lavanteUtils.getValueFrmDpdn(buname),"Businesss Unit Not Matched,Expected:"+buname+",Actual");
		flag=true;
	}
	else {
		softassert.assertTrue(false,"Status Not Matched ,So File Upload did not happen");
		flag=true;
	}
	
	if(flag==false)
	{
		softassert.assertTrue(false,"Data not matched");
		
	}

	softassert.assertAll();
	Reporter.log("Test Ended for VMF in Business Unit at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---VMF in Business Unit--------");
}
	
	/** Upload Spend File
	 * Verify Hyper Link
	 * Verify Status
	 * Verify in Enterprise owned the amount
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadSpendFile004() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload Spend File at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	String nwfile=LavanteUtils.CopyFile("Spend_Template.csv");
	
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

	
	String spendamnt=" select SUM(ss.Spend) from Supplier as s,Relationship as r,SupplierSpend as ss where "
			+ " r.LavanteUID = s.LavanteUID and ss.RelationshipID=r.RelationshipID "
			+ " and s.SupplierName like '"+suppname+"'";
	
	 spendamnt=lavanteUtils.fetchDBdata(spendamnt);
	 Double amnt=200.00;
	 Double expamnt=amnt;
	 if(spendamnt!=null){
		expamnt=Double.parseDouble(spendamnt);
		expamnt=expamnt+amnt;
	 }
	String cur="USD";
	
	LavanteUtils.editcsv(nwfile, 0,supid );
	LavanteUtils.editcsv(nwfile, 1,""+amnt );
	LavanteUtils.editcsv(nwfile, 2,"USD" );
//	String supp=LavanteUtils.Readcsv(nwfile,1);
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Spend File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous Upload File Status Not Matched,Please Recheck");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"After Upload File Status Not Matched,Please Recheck");
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMESpenduploadFile());
	
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
			System.out.println("Uploaded file href,Expected:"+fname+",Actuals:"+href);
			softassert.assertTrue(href.contains(fname),"File name not matched");
			flag=true;
			break;
		
		}
		
	}
	
	Assert.assertTrue(flag,"File Status Not Expected");
	
	
	dataMap.clear();
	lavanteUtils.switchtoFrame(null);
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("Search", "");
	dataMap.put("supplierName", suppname);	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);

	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	enviewSupplier.clickOnSupplier(suppname);

	dataMap.put("maintab","Enterprise");
	enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.waitForTime(3000);
	String x=enviewSupplier.totalSpend().get(1).getText();
	
	x=x.replace(",", "");
	System.out.println(x);
	System.out.println("Currency Match,Actual:"+x+",Exp :"+cur);
	Reporter.log("Currency Match,Actual:"+x+",Exp :"+cur);
	softassert.assertTrue(x.contains(""+cur),"Currency Not matched");
	System.out.println("Amount Match,Actual:"+x+",Exp:"+expamnt);
	Reporter.log("Amount Match,Actual:"+x+",Exp :"+expamnt);
	softassert.assertTrue(x.contains(""+expamnt),"Amount Not matched");	

	softassert.assertAll();
	Reporter.log("Test Ended for Upload Spend File at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended-----Upload Spend File-------");
	
}
	
	/** Upload Invoice file 
	 * Verify in Invoice Page
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadInvoice004() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload Invoice at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
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
	
	String nwfile=LavanteUtils.CopyFile("Invoice_Template.csv");
	
	String invnum=LavanteUtils.randomnum();
	String invamnt="1000";
	LavanteUtils.editcsv(nwfile, 1, supid);
	LavanteUtils.editcsv(nwfile, 2, suppname);
	LavanteUtils.editcsv(nwfile, 3, invnum);
	LavanteUtils.editcsv(nwfile, 4, invamnt);
	String  invstatus=LavanteUtils.Readcsv(nwfile,10);
	
	Reporter.log("Edit CSV:");

	dataMap.put("UploadType", "Invoice File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"before File Upload Status Not Matched");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean upstatus=enobjuploadFiles.uploadFileGrid(dataMap); 
	Assert.assertTrue(upstatus,"After Uploaded File Status Not matched");
	
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEInvuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
		if(fname.equalsIgnoreCase(nwfile)){
		Reporter.log("Uploaded file available in the list");
		
		System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
		Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
		Assert.assertEquals(fname,nwfile,"File name not matched");
		
		String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
		String expsttaus="Upload Process Completed";
		System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
		Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
		Assert.assertTrue(status.contains(expsttaus),"File name not matched");
		
		flag=true;
		break;
		}
	}
	
	Assert.assertTrue(flag,"Status of File Status Not matched");
	
	dataMap.clear();
	
	dataMap.put("maintab","Supplier");
	dataMap.put("subtab", "InvoiceSearchResult");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("InvNum",invnum);
	dataMap.put("Search","");	
	eninvoiceBasicSearch.Search(dataMap);
	
	lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
	lavanteUtils.waitForTime(3000);
	lavanteUtils.fluentwait(eninvoicePage.TBLInvoicenumber());
	
	String appStatus=eninvoicePage.getColumnText("Invoice Status",0);
	Reporter.log("Invoice status,Verification,Expected:"+invstatus+"In app,"+appStatus);
	System.out.println("Invoice status,Verification,Expected:"+invstatus+"In app,"+appStatus);
	softassert.assertEquals(appStatus, invstatus,"Status Not Matched for the Invoice"+appStatus+","+invstatus);
	
	String appInum=eninvoicePage.getColumnText("Invoice Number", 0);	
	Reporter.log("Invoice Numb,Verification,Expected:"+invnum+"In app:,"+appInum);
	System.out.println("Invoice Numb,Verification,Expected:"+invnum+"In app:,"+appInum);
	softassert.assertEquals(appInum, invnum,"Invoice Number Not Matched for the Invoice"+appInum+","+invnum);
	
	String appSName=eninvoicePage.getColumnText("Supplier Name", 0);	
	Reporter.log("Invoice Supplier Name,Verification,Expected:"+suppname+"In app:,"+appSName);
	System.out.println("Invoice Supplier Name,Verification,Expected:"+suppname+"In app:,"+appSName);
	softassert.assertEquals(appSName, suppname," Supplier Name Not Matched for the Invoice"+appSName+","+suppname);
	
	String appSID=eninvoicePage.getColumnText("ERP", 0);	
	Reporter.log("Invoice Supplier ID,Verification,Expected:"+supid+"In app:,"+appSID);
	System.out.println("Invoice Supplier ID,Verification,Expected:"+supid+"In app:,"+appSID);
	softassert.assertEquals(appSID, supid," Supplier ID Not Matched for the Invoice,"+appSID+","+supid);
	
	LinkedHashMap<String,String> dataMaps=new LinkedHashMap<String, String>();	
	dataMaps.put("maintab","Files");	
	enobjhomePage.selectTab(dataMaps);
	
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload Invoice at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Upload Invoice---------");
	
}
	
	/** Upload duplicate invoice of other supplier and 
	 * New invoice should be created without affecting existing invoice.
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test(dataProvider="Upload",dataProviderClass=SupplierSearchDataProvider.class)
	public void uploadDuplicateInvoice004(LinkedHashMap<String,String> dataMap) throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload Invoice with Duplicate Invoice at:"+LavanteUtils.currenttime());
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("Search", "");
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
	
	String nwfile=LavanteUtils.CopyFile("Invoice_Template.csv");
	
	String quer=" select MAX(si.InvoiceNumber) from Supplier as s,Relationship as r,SupplierInvoiceDetails as si  "
			+ " where r.LavanteUID = s.LavanteUID and si.RelationshipID = r.RelationshipID"
			+ " and s.SupplierName NOT IN ('"+suppname+"') "
			+ "and si.CreatedOn<getUTCdate() and si.CustomerID="+customerid;
	
	String invnum=lavanteUtils.fetchDBdata(quer);
	
	String oldStatus="select UTFString from UserTranslation where i18nKey=( select Status_i18nKey from InvoiceStatus where InvoiceStatusId= ("
			+ " select si.InvoiceStatusId from Supplier as s,Relationship as r,SupplierInvoiceDetails as si"
			+ " where r.LavanteUID = s.LavanteUID and si.RelationshipID = r.RelationshipID and s.SupplierName NOT IN ('"+suppname+"')  "
			+ " and si.InvoiceNumber='"+invnum+"' 	and si.CreatedOn<getUTCdate() and si.CustomerID="+customerid+")) and LanguageID=50" ;
	
	oldStatus=lavanteUtils.fetchDBdata(oldStatus);
	
	String query=" select s.SupplierName from Supplier as s,Relationship as r,SupplierInvoiceDetails as si  "
			+ " where r.LavanteUID = s.LavanteUID and si.RelationshipID = r.RelationshipID"
			+ " and s.SupplierName NOT IN ('"+suppname+"') "
			+ " and si.CreatedOn<getdate() and si.CustomerID= "+customerid
			+ " and si.InvoiceNumber='"+invnum+"'" ;
	
	String oldsup=lavanteUtils.fetchDBdata(query);
	
	String invamnt="1000";
	LavanteUtils.editcsv(nwfile, 1, supid);
	LavanteUtils.editcsv(nwfile, 2, suppname);
	LavanteUtils.editcsv(nwfile, 3, invnum);
	LavanteUtils.editcsv(nwfile, 4, invamnt);
	String  invstatus=LavanteUtils.Readcsv(nwfile,10);
	
	Reporter.log("Edit CSV:");

	dataMap.put("UploadType", "Invoice File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"File Status Not Matched");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	Status=enobjuploadFiles.uploadFileGrid(dataMap); 
	Assert.assertTrue(Status,"Uploaded File Status Not matched");
	
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEInvuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		
		String fname=enobjuploadFiles.ListUploadFile().get(0).getText();
		if(fname.equalsIgnoreCase(nwfile)){
			
			Reporter.log("Uploaded file available in the list");
			
			System.out.println("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			Assert.assertEquals(fname,nwfile,"File name not matched");
			
			String status=enobjuploadFiles.ListuploadStatus().get(0).getText();
			String expsttaus="Upload Process Completed";
			System.out.println("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			Assert.assertTrue(status.contains(expsttaus),"File name not matched");
			flag=true;
			break;
		
		}
	}
	
	Assert.assertTrue(flag,"File Status Not Matched");
	
	dataMap.clear();
	
	dataMap.put("maintab","Supplier");
	dataMap.put("subtab", "InvoiceSearchResult");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("InvNum",invnum);
	dataMap.put("SuppName",suppname);	
	dataMap.put("Search","");	
	eninvoiceBasicSearch.Search(dataMap);
	
	lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
	lavanteUtils.waitForTime(3000);
	lavanteUtils.fluentwait(eninvoicePage.TBLInvoicenumber());
	
	Reporter.log("Verification of New Supplier New Invoice:");
	
	String appStatus=eninvoicePage.getColumnText("Invoice Status", 0);	
	Reporter.log("Invoice status,Verification,Expected:"+invstatus+"In app,"+appStatus);
	System.out.println("Invoice status,Verification,Expected:"+invstatus+"In app,"+appStatus);
	softassert.assertEquals(appStatus, invstatus,"Status Not Matched for the Invoice"+appStatus+","+invstatus);
	
	String appInum=eninvoicePage.getColumnText("Invoice Number", 0);		
	Reporter.log("Invoice Numb,Verification,Expected:"+invnum+"In app,"+appInum);
	System.out.println("Invoice Numb,Verification,Expected:"+invnum+"In app,"+appInum);
	softassert.assertEquals(appInum, invnum,"Invoice Number Not Matched for the Invoice"+appInum+","+invnum);
	
	String appSName=eninvoicePage.getColumnText("Supplier Name", 0);	
	Reporter.log("Invoice Supplier Name,Verification,Expected:"+suppname+"In app,"+appSName);
	System.out.println("Invoice Supplier Name,Verification,Expected:"+suppname+"In app,"+appSName);
	softassert.assertEquals(appSName, suppname," Supplier Name Not Matched for the Invoice"+appSName+","+suppname);
	
	String appSID=eninvoicePage.getColumnText("ERP", 0);		
	Reporter.log("Invoice Supplier ID,Verification,Expected:"+supid+"In app,"+appSID);
	System.out.println("Invoice Supplier ID,Verification,Expected:"+supid+"In app,"+appSID);
	softassert.assertEquals(appSID, supid," Supplier ID Not Matched for the Invoice,"+appSID+","+supid);
	
	lavanteUtils.switchtoFrame(null);
	
	Reporter.log("Verification for Old Supplier Old Invoice:");
	
	dataMap.put("InvNum",invnum);
	dataMap.put("SuppName",oldsup);	
	dataMap.put("Search","");	
	eninvoiceBasicSearch.Search(dataMap);
	
	lavanteUtils.switchtoFrame(eninvoicePage.IFRAMEsearchresult());
	lavanteUtils.fluentwait(eninvoicePage.TBLInvoicenumber());
	
	appInum=eninvoicePage.getColumnText("Invoice Number", 0);	
	Reporter.log("Old Invoice Numb,Verification,Expected:"+invnum+"In app,"+appInum);
	System.out.println("Old Invoice Numb,Verification,Expected:"+invnum+"In app,"+appInum);
	softassert.assertEquals(appInum, invnum,"Old Invoice Number Not Matched for the Invoice"+appInum+","+invnum);
	
	appSName=eninvoicePage.getColumnText("Supplier Name", 0);	
	Reporter.log("Old Invoice Supplier Name,Verification,Expected:"+suppname+"In app,"+appSName);
	System.out.println("Old Invoice Supplier Name,Verification,Expected:"+suppname+"In app,"+appSName);
	softassert.assertEquals(appSName, oldsup,"Old Supplier Name Not Matched for the Invoice"+appSName+","+suppname);
		
	appStatus=eninvoicePage.getColumnText("Invoice Status", 0);	
	Reporter.log("Invoice status,Verification,Expected:"+oldStatus+"In app,"+appStatus);
	System.out.println("Invoice status,Verification,Expected:"+oldStatus+"In app,"+appStatus);
	softassert.assertEquals(appStatus, oldStatus,"Status Not Matched for the Invoice"+appStatus+","+oldStatus);
	
	LinkedHashMap<String,String> dataMaps=new LinkedHashMap<String, String>();	
	dataMaps.put("maintab","Files");	
	enobjhomePage.selectTab(dataMaps);
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload Invoice with Duplicate Invoice at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Upload Invoice with Duplicate Invoice----------");
	
}
	
	/** Invalid as VMF Reinvite Contact not available in new template
	 *  			
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	//@Test(disabled=false)
	public void invalidTestVMFReinviteemail() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Update Upload VMF at:"+LavanteUtils.currenttime());
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
	dataMap.put("UploadType", "Supplier File");
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	if(Status==true){
	
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	String expemailID="AutoSP"+LavanteUtils.randomnum(9999999)+"@gmail.com";
	
	LavanteUtils.editcsv(nwfile, 21, expemailID);
	LavanteUtils.editcsv(nwfile, 4, expemailID);
	String supp=LavanteUtils.Readcsv(nwfile,1);
	Reporter.log("Edit CSV:");

	dataMap.put("UploadFile", nwfile);
	dataMap.put("UpdateRecords", "OK");
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	enobjuploadFiles.uploadFileGrid(dataMap);
	Reporter.log("Upload File:");
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();){
		
		Reporter.log("Uploaded file available in the list");
		String fname=enobjuploadFiles.ListUploadFile().get(0).getText();
		
		Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
		softassert.assertEquals(fname,nwfile,"File name not matched");
		
		String status=enobjuploadFiles.ListuploadStatus().get(0).getText();
		String expsttaus="Update Process Completed";
		Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
		softassert.assertEquals(status,expsttaus,"File name not matched");
		break;
		
	}
	
	LinkedHashMap<String,String> dataMap1=new LinkedHashMap<String, String>();
	lavanteUtils.switchtoFrame(null);
	
	dataMap1.put("maintab","Supplier");	
	enobjhomePage.selectTab(dataMap1);
	
	lavanteUtils.fluentwait(enobjsupplierBasicSearch.searchbtn());
	dataMap1.put("supplierName", supp);
	dataMap1.put("Search", "");
	enobjsupplierBasicSearch.search(dataMap);					
	
	Reporter.log("Navigated to Search Page");
		
	dataMap1.put("Communicate", "");
	dataMap1.put("Reinvite", "");
	enobjsupplierPage.supplierSelectionandProfileAction(dataMap1);
	Reporter.log("In Reinvite Page");
	
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
		File f=new File(LavanteUtils.getPresentWorkingDir()+File.separator+dir+File.separator+nwfile);
		f.delete();
		
	}else {
		softassert.assertTrue(false,"Status Not Matched ,So File Upload did not happen");
		flag=true;
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
	System.out.println("----------Test Ended----------------");
}
			
	/** Upload VMF with Other than Country Us should Show Country of registeration as US
	 *  				
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 * Replacement of ManageFilesTC0002
	 */
	@Test
	public void uploadCountryUS_007() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload VMF verify Empty Country at:"+LavanteUtils.currenttime());
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("Status", "Process Completed");
	
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File status Not matched");

	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 15, "");
	LavanteUtils.editcsv(nwfile, 18, ""+lavanteUtils.generateRandomNumber9OnLength(9)+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 21, "");
	LavanteUtils.editcsv(nwfile, 24, "");

	
	Reporter.log("Edit CSV");
	
	dataMap.put("UploadFile", nwfile);
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean fstatus=enobjuploadFiles.uploadFileGrid(dataMap);
	Reporter.log("Upload File Status:"+fstatus);
	Assert.assertTrue(fstatus,"Current File status Not matched");
	
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
	Assert.assertTrue(flag,"Current File Upload Value Not matched");
	
	dataMap.clear();
	lavanteUtils.switchtoFrame(null);
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("Search", "");
	dataMap.put("supplierName", expSname);	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	enviewSupplier.clickOnSupplier(expSname);
	
	lavanteUtils.fluentwait(enviewSupplier.cntactaddress());
	String appadddress=enviewSupplier.cntactaddress().getText();
	String expcountry="United States";
	
	System.out.println("Country Contain,Actual:"+appadddress+",Exp :"+expcountry);
	Reporter.log("Country Contain,Actual:"+appadddress+",Exp :"+expcountry);
	softassert.assertTrue(appadddress.contains(expcountry),"Country do Not Contain,Expected,"+expcountry+",Actual:"+appadddress);

	/*dataMap.clear();
	
	dataMap.put("subtab","Legal");
	enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enviewSupplier.countryofReg());*/
	
	String actualcountry=enviewSupplier.countryofReg().getText();
	System.out.println("Country of Reg, expected,"+expcountry+",Actual:"+actualcountry);
	Reporter.log("Country of Reg, expected,"+expcountry+",Actual:"+actualcountry);
	softassert.assertEquals(actualcountry, expcountry,"Country of Reg Not matched");
	
	dataMap.clear();
	dataMap.put("maintab", "Enterprise");
	dataMap.put("subtab", "VMF");	
	enviewSupplier.selectTab(dataMap);
	
	lavanteUtils.fluentwait(enviewSupplier.VMFsuppname());
	String s=enviewSupplier.VMFsuppname().getText();
	System.out.println("VMF Supplier Name,Expected,"+expSname+",Actual:"+s);
	Reporter.log("VMF Supplier Name,Expected,"+expSname+",Actual:"+s);
	softassert.assertEquals(s,expSname,"VMF Supplier Name,Expected,"+expSname+",Actual:"+s);
	
	String address=enviewSupplier.VMFAddress().getText();
	System.out.println("VMF Content Address,Expected,"+expSname+",Actual:"+address);
	Reporter.log("VMF Content Address,Expected,"+expSname+",Actual:"+address);
	softassert.assertFalse(address.contains(expcountry),"VMF Content Address,Expected,"+expSname+",Actual:"+address);

	if(flag==false)
	{
		softassert.assertTrue(false,"Data not matched");
	}
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF verify Empty Country  at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Upload VMF verify Empty Country ---------");
}

	/** Upload VMF with Empty address 1 and vErify the address
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadEmptyAddress1_008() throws Exception{	
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload VMF verify Empty Address 1  at:"+LavanteUtils.currenttime());
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, ""+lavanteUtils.generateRandomNumber9OnLength(9));
	LavanteUtils.editcsv(nwfile, 9, "");
	LavanteUtils.editcsv(nwfile, 18, ""+lavanteUtils.generateRandomNumber9OnLength(9)+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, ""+lavanteUtils.generateRandomNumber9OnLength(9));

	
	String add2=LavanteUtils.Readcsv(nwfile,10);
	String add3=LavanteUtils.Readcsv(nwfile,11);
	
	Reporter.log("Edit CSV:");
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("UploadFile", nwfile);
	
	dataMap.put("Status", "Process Completed");
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File Status not Matched");
	
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Current File Status not Matched");
	
	Reporter.log("Upload File:"+nwfile);
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();i++){
		
		Reporter.log("Uploaded file available in the list");
		String fname=enobjuploadFiles.ListUploadFile().get(i).getText();
		if(fname.equalsIgnoreCase(nwfile)){
			Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			softassert.assertEquals(fname,nwfile,"File name not matched");
			
			String status=enobjuploadFiles.ListuploadStatus().get(i).getText();
			String expsttaus="Upload Process Completed";
			Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			softassert.assertEquals(status,expsttaus,"File Status not matched");
			Status=true;
			break;
		}
	}
	
	Assert.assertTrue(Status,"Current File Verification Status not Matched");
	
	dataMap.clear();
	lavanteUtils.switchtoFrame(null);
	
	dataMap.put("maintab","Supplier");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("Search", "");
	dataMap.put("supplierName", expSname);	
	lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
	enobjsupplierBasicSearch.search(dataMap);
	
	lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
	
	enviewSupplier.clickOnSupplier(expSname);
	
	lavanteUtils.fluentwait(enviewSupplier.cntactaddress());
	String x=enviewSupplier.cntactaddress().getText();
	
	System.out.println("Address 2 Contain,Actual:"+x+",Exp :"+add2);
	Reporter.log("Address 2 Contain,Actual:"+x+",Exp :"+add2);
	softassert.assertTrue(x.contains(add2),"Address 2 Not matched");
	System.out.println("Address 3 Match,Contain:"+x+",Exp:"+add3);
	Reporter.log("Address 3 Match,Contain:"+x+",Exp :"+add3);
	softassert.assertTrue(x.contains(add3),"Address 3 Not matched");	

	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF verify Empty Address 1 at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended-Upload VMF verify Empty Address 1-------");
}

	/** Upload VMF with US Country with legal id 
	 * Verify in Legal id page  
	 *   				
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadCountryUSwithTIN_007() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload VMF US With TIN at:"+LavanteUtils.currenttime());
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("Status", "Process Completed");
	
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File Upload Status not matched");

	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	String d=lavanteUtils.generateRandomNumber9OnLength(9);
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, d);
	LavanteUtils.editcsv(nwfile, 15, "United States");
	LavanteUtils.editcsv(nwfile, 18, d+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, d);
	
	String explegalName=LavanteUtils.Readcsv(nwfile, 3);
	String explegaltype=LavanteUtils.Readcsv(nwfile, 22);
	
	Reporter.log("Edit CSV");
	
	dataMap.put("UploadFile", nwfile);
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Current File Upload Status not matched");

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
			Status=true;
			break;
		}
	}
	
	Assert.assertTrue(Status,"Current File Upload Validation not matched");

	dataMap.clear();
	lavanteUtils.switchtoFrame(null);
	
	dataMap.put("maintab","Supplier");
	dataMap.put("subtab","customerSupplierLegalID");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("supplierName",expSname);
	dataMap.put("FilterBY","LegalID");
	dataMap.put("FilterSub", "PendingValidation");
	
	enobjLegalID.searchSupplier(dataMap);
	
	if(enobjLegalID.ListSupplier().size()>0){
		
		String actsup=enobjLegalID.ListSupplier().get(0).getText();
		
		System.out.println("Supplier Name, expected,"+expSname+",Actual:"+actsup);
		Reporter.log("Supplier Name, expected,"+expSname+",Actual:"+actsup);
		softassert.assertEquals(actsup, expSname,"Supp Name Not matched");
		
		String actlegal=enobjLegalID.ListSupplierLegalName().get(0).getText();
		System.out.println("Legal Name, expected,"+explegalName+",Actual:"+actlegal);
		Reporter.log("Legal Name, expected,"+explegalName+",Actual:"+actlegal);
		softassert.assertEquals(actlegal, explegalName,"Legal Name Not matched");
		
		actlegal=enobjLegalID.ListSupplierLegalID().get(0).getText();
		System.out.println("Legal ID, expected,"+d+",Actual:"+actlegal);
		Reporter.log("Legal ID, expected,"+d+",Actual:"+actlegal);
		softassert.assertEquals(actlegal, d,"Legal ID Not matched");
		
		lavanteUtils.click(enobjLegalID.ListSupplier().get(0));
		
		lavanteUtils.switchtoFrame(null);
		
		/*dataMap.remove("maintab");
		dataMap.put("subtab","Legal");
		enviewSupplier.selectTab(dataMap);*/
		
		lavanteUtils.fluentwait(enviewSupplier.countryofReg());
		
		String legal=enviewSupplier.legalIDstatus().getText();
		String exp="Provided";
		System.out.println("Legal ID Status, expected,"+exp+",Actual:"+legal);
		Reporter.log("Legal ID Status, expected,"+exp+",Actual:"+legal);
		softassert.assertEquals(legal, exp,"Legal ID Status Not matched");
				
		legal=enviewSupplier.taxIDtype().getText();
		System.out.println("Legal ID Type, expected,"+explegaltype+",Actual:"+legal);
		Reporter.log("Legal ID Type, expected,"+explegaltype+",Actual:"+legal);
		softassert.assertTrue(legal.contains(explegaltype),"Legal ID type Not matched");
		
		legal=enviewSupplier.taxIDNum().getText().trim();
		System.out.println("Legal ID Num, expected,"+d.trim()+",Actual:"+legal.trim());
		Reporter.log("Legal ID Num, expected,"+d.trim()+",Actual:"+legal.trim());
		softassert.assertEquals(legal.trim(), d.trim(),"Legal ID Num Not matched,Expected"+d.trim()+",Actuals:"+legal.trim());
		
		flag=true;
		
	}
	
	softassert.assertTrue(flag,"Test Failed,Please Recheck");
	softassert.assertAll();

	Reporter.log("Test Ended for Upload VMF verify LegaL ID With TIN  at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Upload VMF LegaL ID With TIN ---------");

}

	/** Upload VMF with US Country without legal id 
	 * Verify in Legal id page 
	 *   				
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 */
	@Test
	public void uploadCountryUSwithoutTIN_007() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Upload VMF US Without TIN at:"+LavanteUtils.currenttime());
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
	dataMap.put("UploadType", "Supplier File");
	dataMap.put("Status", "Process Completed");
	
	boolean Status=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Previous File Upload Status Not Matched");
	
	String nwfile=LavanteUtils.CopyFile("VMF_Template.csv");
	
	String id=""+LavanteUtils.randomnum(9999999);
	String expSname="AutoSP"+LavanteUtils.randomnum();
	String ERPNAMe="select UTFString FROM UserTranslation where i18nKey=( select ERP_i18nKey FROM ERP where ERPID=( "
			+ " select MIN(ERPID) from  ERPCustomerMap where CustomerID="+customerid+"))  and LanguageID=50";
	ERPNAMe=lavanteUtils.fetchDBdata(ERPNAMe);
	
	LavanteUtils.editcsv(nwfile, 0, ERPNAMe);
	LavanteUtils.editcsv(nwfile, 1, id);
	LavanteUtils.editcsv(nwfile, 2, expSname);
	LavanteUtils.editcsv(nwfile, 4, "");
	LavanteUtils.editcsv(nwfile, 15, "United States");
	LavanteUtils.editcsv(nwfile, 18, ""+lavanteUtils.generateRandomNumber9OnLength(9)+"@gmail.com");
	LavanteUtils.editcsv(nwfile, 24, ""+lavanteUtils.generateRandomNumber9OnLength(9));

	
	Reporter.log("Edit CSV");
	
	dataMap.put("UploadFile", nwfile);
	dataMap.put("UploadOK", "OK");
	enobjuploadFiles.UploadFile(dataMap);
	
	boolean fstatus=enobjuploadFiles.uploadFileGrid(dataMap);
	Assert.assertTrue(Status,"Current File Upload Status Not Matched");
	
	lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
	
	for(int i=0;i<enobjuploadFiles.ListUploadFile().size();){
		
		Reporter.log("Uploaded file available in the list");
		String fname=enobjuploadFiles.ListUploadFile().get(0).getText();
		if(fname.equalsIgnoreCase(nwfile)){
			Reporter.log("Uploaded file,Expected:"+fname+",Actuals:"+nwfile);
			softassert.assertEquals(fname,nwfile,"File name not matched");
			
			String status=enobjuploadFiles.ListuploadStatus().get(0).getText();
			String expsttaus="Upload Process Completed";
			Reporter.log("Uploaded file status,Expected:"+expsttaus+",Actuals:"+status);
			softassert.assertEquals(status,expsttaus,"File Status not matched");
			flag=true;
			break;
		
		}
		
	}
	Assert.assertTrue(flag,"Uploaded File Validation Status,Not Matched");
	flag=false;
	dataMap.clear();
	lavanteUtils.switchtoFrame(null);
	
	dataMap.put("maintab","Supplier");
	dataMap.put("subtab","customerSupplierLegalID");
	enobjhomePage.selectTab(dataMap);
	
	dataMap.put("supplierName",expSname);
	dataMap.put("FilterBY","NoLegalID");
	dataMap.put("FilterSub","Unknown");
	
	enobjLegalID.searchSupplier(dataMap);
	
	if(enobjLegalID.ListSupplier().size()>0){
		
		String actsup=enobjLegalID.ListSupplier().get(0).getText();
		
		System.out.println("Supplier Name, expected,"+expSname+",Actual:"+actsup);
		Reporter.log("Supplier Name, expected,"+expSname+",Actual:"+actsup);
		softassert.assertEquals(actsup, expSname,"Supp Name Not matched");
		
		lavanteUtils.click(enobjLegalID.ListSupplier().get(0));
		
		lavanteUtils.switchtoFrame(null);
		/*
		dataMap.remove("maintab");
		dataMap.put("subtab","Legal");
		enviewSupplier.selectTab(dataMap);*/
		
		lavanteUtils.fluentwait(enviewSupplier.countryofReg());
		
		String legal=enviewSupplier.legalIDstatus().getText();
		String exp="Unknown";
		System.out.println("Legal ID Status, expected,"+exp+",Actual:"+legal);
		Reporter.log("Legal ID Status, expected,"+exp+",Actual:"+legal);
		softassert.assertEquals(legal, exp,"Legal ID Status Not matched");
		flag=true;
	}
	
	softassert.assertAll();
	Reporter.log("Test Ended for Upload VMF verify LegaL ID Without TIN  at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Upload VMF LegaL ID Without TIN ---------");

}
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
		enobjInvitenewSupplier.cancel();
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

