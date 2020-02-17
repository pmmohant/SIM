package com.lavante.sim.customer.TestScripts.Admin.DownloadFile;

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
public class UATDownloadTC extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String uname="";
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
		uname=LdataMap.get("username");
	
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
			
	}
	
	@BeforeMethod
	public void beforeMethod(){
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Admin");
		dataMap.put("subtab","DownloadFiles");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
	}
		
	/** Download VMF
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 * Replacement of ManageFilesTC0003
	 * 
	 */
	@Test
	public void downloadVMF() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Download VMF:"+LavanteUtils.currenttime());
	
	String actual =enobjuploadFiles.Pageuploadfile().getText();
	String exp="Upload Files";
	Assert.assertEquals(actual, exp,"Verify Upload Link Not Matched");
	
	 actual =endownloadFiles.Pagedownloadfile().getText();
	 exp="Download Files";
	Assert.assertEquals(actual, exp,"Verify Download File Not Matched");
	
	LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
	
	
	dataMap.put("Status", "Completed");
	boolean Status=endownloadFiles.refreshDownloadHistoryTable(dataMap);
	if(Status==true){

	dataMap.put("specifydata", "VMF Fields");
	dataMap.put("specifydate", "Changes Since Last Extract");
	dataMap.put("Request", "");
	endownloadFiles.downloadFile(dataMap);
	
	boolean upstatus=endownloadFiles.refreshDownloadHistoryTable(dataMap);
	Assert.assertTrue(upstatus,"Newly Uploaded file Status:"+upstatus);
	Reporter.log("Download File:");
	
	lavanteUtils.switchtoFrame(endownloadFiles.IFRAMEdwnloadFile());
	
	for(int i=0;i<endownloadFiles.ListDownloadFile().size();){
		
		Reporter.log("Downloaded file available in the list");
		String downloadedby=endownloadFiles.ListdownloadBy().get(i).getText();
		
		String query="select ContactName from Contact where Email = '"+uname+"'";
		System.out.println(query);
		uname=lavanteUtils.fetchDBdata(query);
		
		Reporter.log("Downloaded Uname Name,Expected:"+uname+",Actuals:"+downloadedby);
		softassert.assertEquals(downloadedby,uname,"Download Uname not matched:"+uname+",Actuals:"+downloadedby);
		
		String status=endownloadFiles.ListdownloadStatus().get(i).getText();
		String expsttaus="Completed";
		Reporter.log("Downloaded file status,Expected:"+expsttaus+",Actuals:"+status);
		softassert.assertEquals(status,expsttaus,"Download Status not matched:"+expsttaus+",Actuals:"+status);
		
		String rcrdcount=endownloadFiles.ListdownloadNoofRecord().get(i).getText();
		int ads=Integer.parseInt(rcrdcount);
		if(ads>0){
			List<WebElement> s=endownloadFiles.ListDownloadFile().get(i).findElements(By.tagName("a"));
			System.out.println(s.size()+":TRue");
			int flags=s.size();
			System.out.println("Downloaded No of Record,Expected:1,Actuals:"+flags);
			Reporter.log("Downloaded No of Record,Expected:1,Actuals:"+flags);
			softassert.assertEquals(1,flags,"Download No of Record not matched:0,Actuals:"+flags);
		}else{
			List<WebElement> s=endownloadFiles.ListDownloadFile().get(i).findElements(By.tagName("a"));
			int flags=s.size();
			System.out.println(flags);
			System.out.println("Downloaded No of Record,Expected:0,Actuals:"+flags);
			Reporter.log("Downloaded No of Record,Expected:0,Actuals:"+flags);
			softassert.assertEquals(0,flags,"Download No of Record not matched:0,Actuals:"+flags);
		}
		flag=true;
		
		break;
		
	}
	

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
	Reporter.log("Test Ended for Download File at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Download File--------");
}
		
	/** Template Verification and Download Template VMF and Spend File
	 *  			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 * 
	 * Replacement of ManageFiles001
	 */
	@Test
	public void DownloadtemplateVerification() throws Exception{	
	boolean flag=false;
	SoftAssert softassert=new SoftAssert();
	Reporter.log("Test Started for Template Verification:"+LavanteUtils.currenttime());

	LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
	dataMap.put("maintab", "Admin");
	dataMap.put("subtab","UploadFiles");
	enobjhomePage.selectTab(dataMap);

	boolean f1 = false,f2=false;
	
	for(int i=0;i<enobjuploadFiles.ListUploadFileTemplate().size();i++){
	
		String x=enobjuploadFiles.ListUploadFileTemplate().get(i).getText();
		if(x.contains("Vendor Master File")){
			lavanteUtils.click(enobjuploadFiles.ListUploadFileTemplate().get(i));
			f1=true;
			
		}else if(x.equalsIgnoreCase("Spend File")){
			lavanteUtils.click(enobjuploadFiles.ListUploadFileTemplate().get(i));
			f2=true;
		}
		System.out.println(f1+""+f2);
		if(f1==true && f2==true){
			flag=true;
			break;
		}
	}
	
	if(flag==false)
	{
		softassert.assertTrue(false,"Template file not matched");
		
	}
	
	softassert.assertAll();
	Reporter.log("Test Started for Template Verification at:"+LavanteUtils.currenttime());
	System.out.println("----------Test Ended---Template Verification-------");
}
		
	/**LegalDocSearch Search and Verify in Manage File Download Doc
	 * Replacement of CustomerSupplierSearchTC0014
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test(dataProvider="LegalDocSearch",dataProviderClass=SupplierSearchDataProvider.class)
	public void DownloadLegalIDSearch(LinkedHashMap<String,String> dataMap) throws Exception{	
		System.out.println("------------Test Started for Download LegalID Search------------------");
		Reporter.log("Test Started for Download LegalID Search:"+LavanteUtils.currenttime());
		
		SoftAssert softassert =new SoftAssert();
		boolean flag=false;
		
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);

		lavanteUtils.waitForTime(3000);
		
		lavanteUtils.fluentwait(ensupplierAdvanced.advtab());
		lavanteUtils.click(ensupplierAdvanced.advtab());
		dataMap.put("Clear", "");
		dataMap.put("Search", "");
		
		ensupplierAdvanced.buildQuery(dataMap);			
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
			dataMap.put("OtherAction","");
			dataMap.put("downloaddoc","");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			Reporter.log("In Download Doc Popup:");
			String i18n="W-8#W-9";
			dataMap.put("LefttoRight", i18n);
			dataMap.put("OK", "");
			enobjsupplierPage.Movedoc(dataMap);
			lavanteUtils.switchtoFrame(null);
			
			dataMap.put("maintab","Files");
			dataMap.put("subtab", "DownloadFiles");
			
			enobjhomePage.selectTab(dataMap);
			Reporter.log("In Manage Files,Download Files page:");
			String query8="select FileName from FileDownload ";//where CustomerID="+custid+" and FieldId_CSV ='"+fieldid+"'";
			String fname=lavanteUtils.fetchDBdata(query8);
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(endownloadFiles.refreshBtn());
			Reporter.log("Downloading the file:"+fname);
			
			lavanteUtils.switchtoFrame(endownloadFiles.IFRAMEdwnloadFile());
			for(int i=0;i<endownloadFiles.ListDownloadFile().size();i++){
				String appfname=endownloadFiles.ListDownloadFile().get(i).getText();
				System.out.println(appfname+fname);
				if(appfname.equalsIgnoreCase(fname)){
					
					Reporter.log("File downladed available in the Download list");

					dataMap.put("Status", "Completed");
					endownloadFiles.refreshDownloadHistoryTable(dataMap);
					lavanteUtils.switchtoFrame(endownloadFiles.IFRAMEdwnloadFile());
					String fnam=endownloadFiles.ListDownloadFile().get(i).getText();
					String type=endownloadFiles.ListdownloadType().get(i).getText();
					String record=endownloadFiles.ListdownloadNoofRecord().get(i).getText();
			
					
					Reporter.log("Verification Started");
					Reporter.log("File name ,Expected:"+fname+",Actuals in app:"+fnam);
					softassert.assertEquals(fnam,fname,"File name Not matched,Actuals:"+fnam+"Expected:"+fname);
					Reporter.log("File Type ,Expected:Supplier Documents,Actuals in app:"+type);
					softassert.assertEquals(type,"Supplier Documents","File type Not matched,Actuals:"+type+"Expected:Supplier Documents");
					Reporter.log("File record ,Expected:1,Actuals in App:"+record);
					softassert.assertEquals(record,"1","Record name Not matched,Actuals:"+record+"Expected:1");
					flag=true;
					break;
					
				}
				
			}
			
			
		}
	
		if(flag==false){
			softassert.assertTrue(false,"DATA NOT AVAILABLE");
			Reporter.log("Please Add test data for this Search and RETEST");
		}
		
		softassert.assertAll();
		
		Reporter.log("Test Ended for Download LegalID Search at:"+LavanteUtils.currenttime());
	}
	
	/**
	 * SetupAfter method closes any popup 
	 * @author Piramanayagam.S
	 */
	@AfterMethod
	public void SetupAftermethod(){
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

