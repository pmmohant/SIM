package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
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
 * Created on 4-3-2016
 * Created for SIM 5.13 Enhancement
 * Enhancement covered SIM -7115
 * Ended on 9-03-2016
 * @author Piramanayagam.S
 *
 */
public class CustomTabDownload02 extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String suppname="";
	String custid="";
	String subid="";
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
		
		List listofdatafrm=lavanteUtils.login("Download", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		custid=(String) listofdatafrm.get(1);
		
		//Login
		suppname=LdataMap.get("supname");		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		if(browser.equalsIgnoreCase("internet explorer")){
			subid="188";
		}else if(browser.equalsIgnoreCase("chrome")){
			subid="201";
			}else{
			subid="202";
		}
		//Login
		
	}

	/**
	 * Setup Before Method return to Edit profile
	 * @author Piramanayagam.S
	 * @param nul
	 * @throws Exception 
	 */
	@BeforeMethod
	public void SetupBeforemethod() throws Exception{
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("supplierName", suppname);
		enobjsupplierBasicSearch.search(dataMap);		
		
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		lavanteUtils.waitForTime(3000);

	}
	
	/**SIM-7115
	 * Verify Custom Field in Custom Tab can be used for Download document
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void CustomFieldsDownloadDoc001() throws Exception{	
		
		System.out.println("------------Test Started for Download Doc in Edit Profile-------------------");
		Reporter.log("Test Started for Download Document in Edit Profile at :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();

		String i18nkey="AutoSPField"+LavanteUtils.randomnum();
		
		String query0="select EditProfile_i18nKey from CustomerTabDefinition  WHERE CustomerId IN ("+custid+") "
				+ "and TabPageInfoID in (8,12,13,14) and EditProfile_i18nKey like '%Auto%'";
		
		String id=lavanteUtils.fetchDBdata(query0);
		
		String query00="select UTFString from UserTranslation where i18nKey = '"+id+"' and LanguageID=50";
		
		String tabname=lavanteUtils.fetchDBdata(query00);		
		
		String query1=" Insert into I18NKey ( i18nKey) VALUES (   '"+i18nkey+"')";
		String query2=" INSERT INTO UserTranslation (i18nKey  ,LanguageID  ,UTFString  ,IsCustomerSpecific) VALUES "
				+ " ('"+i18nkey+"'   ,50    ,'"+i18nkey+"'   ,'' )";
		//If tab not available
		/*String query3="Insert into CustomerTabDefinition (   EditProfile_i18nKey  ,DisplayOrder  ,CustomerId  ,ViewProfile_i18nKey"
				+ "  ,AdvSearch_i18nKey   ,AppendCustomerFieldsTop  ,isViewableBySupplier  ,TabPageInfoID  ,isVisible  ,EditProfileAdditional_i18nKey"
				+ " ) VALUES (  '"+i18nkey+"'   ,"+order+"  ,"+custid+"    ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,1  ,1  ,'39' ,1  ,'"+i18nkey+"')";*/
		
		String query4=" Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '"+i18nkey+"'   ,6    ,0    ,'"+i18nkey+"'    ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,0   ,0"
				+ "   ,1   ,0   ,0   ,"+subid+"    ,1   )";
		
		lavanteUtils.UpdateDB(query1);
		lavanteUtils.UpdateDB(query2);
		lavanteUtils.UpdateDB(query4);
		
		String query5="Select FieldId from CustomerFieldDefinition where EditProfile_i18nKey like '%"+i18nkey+"%'";
		
		String fieldid=lavanteUtils.fetchDBdata(query5);
		

		String query6=" Insert into CustomerFieldVGMetadata (  FieldDefinitionID  ,IsVisible)  VALUES (  "+fieldid+"   ,1 )";
		
		lavanteUtils.UpdateDB(query6);
		
		String query7=" Insert into ExtractCustomDocTypes_LoginRole_Map (   UserRoleID  ,FieldID  ,CustomerID) "
				+ " VALUES (  14    ,"+fieldid+"     ,"+custid+" )";
		
		lavanteUtils.UpdateDB(query7);
		
		Reporter.log("Field Inserted into DB:"+i18nkey);
		
		String xl="//h2[contains(text(),'"+tabname+"')]/../..";
		//Scroll into Custom Tab
		Reporter.log("In Edit Profile,Custom Tab:");
		
		lavanteUtils.Scrollintoview(driver.findElement(By.xpath(xl)));
		lavanteUtils.click(driver.findElement(By.xpath(xl)));
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(driver.findElement(By.id(i18nkey)));
		lavanteUtils.uploadFile("ANY", driver.findElement(By.id(i18nkey)));
	
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
				
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
			dataMap.put("OtherAction","");
			dataMap.put("downloaddoc","");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			Reporter.log("In Download Doc Popup:");
			
			dataMap.put("LefttoRight", i18nkey);
			dataMap.put("OK", "");
			enobjsupplierPage.Movedoc(dataMap);
			lavanteUtils.switchtoFrame(null);
			
			dataMap.put("maintab","Admin");
			dataMap.put("subtab", "DownloadFiles");
			
			enobjhomePage.selectTab(dataMap);
			Reporter.log("In Manage Files,Download Files page:");
			String query8="select FileName from FileDownload where CustomerID="+custid+" and FieldId_CSV ='"+fieldid+"'";
			String fname=lavanteUtils.fetchDBdata(query8);
			System.out.println(query8);
			
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
					 flag=endownloadFiles.refreshDownloadHistoryTable(dataMap);
					Assert.assertTrue(flag,"Download Not Completed withing Stipulated Time");
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
		{
			Reporter.log("Deleting from DB:"+i18nkey);

			String delquery1=" Delete from I18NKey WHERE i18nKey='"+i18nkey+"'";
			String delquery2=" Delete from UserTranslation WHERE i18nKey ='"+i18nkey+"'";
		//	String delquery3=" Delete from CustomerTabDefinition where EditProfile_i18nKey ='"+i18nkey+"'";
			

			String delquery3=" Delete from CustomerFieldDefinition where  EditProfile_i18nKey='"+i18nkey+"'";
			
			String delquery6="Delete from FieldValue where FieldID="+fieldid+"";			
			
			String delquery4=" Delete from CustomerFieldVGMetadata where FieldDefinitionID = '"+fieldid+"'";
			
			String delquery5=" Delete from ExtractCustomDocTypes_LoginRole_Map  where FieldID = '"+fieldid+"' ";
			
		
			lavanteUtils.UpdateDB(delquery5);
			lavanteUtils.UpdateDB(delquery4);
			lavanteUtils.UpdateDB(delquery6);
			lavanteUtils.UpdateDB(delquery3);
			lavanteUtils.UpdateDB(delquery2);
			lavanteUtils.UpdateDB(delquery1);
			
			
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Retest and RECHECK");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	/**SIM-7115
	 * Verify Doc after reset in Download Document
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void ResetDownloadDoc002() throws Exception{	
		
		System.out.println("------------Test Started for Download Doc in Edit Profile-------------------");
		Reporter.log("Test Started for Doc after reset in Download Document at :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
		
		String i18nkey="AutoSPField"+LavanteUtils.randomnum();
		
		String query0="select EditProfile_i18nKey from CustomerTabDefinition  WHERE CustomerId IN ("+custid+") "
				+ "and TabPageInfoID in (8,12,13,14) and EditProfile_i18nKey like '%Auto%'";
		
		String id=lavanteUtils.fetchDBdata(query0);
		
		String query00="select UTFString from UserTranslation where i18nKey = '"+id+"' and LanguageID=50";
		
		String tabname=lavanteUtils.fetchDBdata(query00);		
		
		String query1=" Insert into I18NKey ( i18nKey) VALUES (   '"+i18nkey+"')";
		String query2=" INSERT INTO UserTranslation (i18nKey  ,LanguageID  ,UTFString  ,IsCustomerSpecific) VALUES "
				+ " ('"+i18nkey+"'   ,50    ,'"+i18nkey+"'   ,'' )";
		//If tab not available
		/*		String query3="Insert into CustomerTabDefinition (   EditProfile_i18nKey  ,DisplayOrder  ,CustomerId  ,ViewProfile_i18nKey"
				+ "  ,AdvSearch_i18nKey   ,AppendCustomerFieldsTop  ,isViewableBySupplier  ,TabPageInfoID  ,isVisible  ,EditProfileAdditional_i18nKey"
				+ " ) VALUES (  '"+i18nkey+"'   ,"+order+"  ,"+custid+"     ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,1  ,1  ,'39' ,1  ,'"+i18nkey+"')";*/
		
		String query4=" Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '"+i18nkey+"'   ,6    ,0    ,'"+i18nkey+"'    ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,0   ,0"
				+ "   ,1   ,0   ,0   ,"+subid+"   ,1   )";
		
		//System.out.println(query3);
		lavanteUtils.UpdateDB(query1);
		lavanteUtils.UpdateDB(query2);
		lavanteUtils.UpdateDB(query4);
		
		String query5="Select FieldId from CustomerFieldDefinition where EditProfile_i18nKey like '%"+i18nkey+"%'";
		
		String fieldid=lavanteUtils.fetchDBdata(query5);
		

		String query6=" Insert into CustomerFieldVGMetadata (  FieldDefinitionID  ,IsVisible)  VALUES (  "+fieldid+"   ,1 )";
		
		lavanteUtils.UpdateDB(query6);
		
		String query7=" Insert into ExtractCustomDocTypes_LoginRole_Map (   UserRoleID  ,FieldID  ,CustomerID) "
				+ " VALUES (  14    ,"+fieldid+"     ,"+custid+" )";
		
		lavanteUtils.UpdateDB(query7);
		
		Reporter.log("Field Inserted into DB:"+i18nkey);
		
		String xl="//h2[contains(text(),'"+tabname+"')]/../..";
		
		//Scroll into Custom Tab
		lavanteUtils.Scrollintoview(driver.findElement(By.xpath(xl)));
		lavanteUtils.click(driver.findElement(By.xpath(xl)));
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(driver.findElement(By.id(i18nkey)));
		lavanteUtils.uploadFile("ANY", driver.findElement(By.id(i18nkey)));
	
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
			dataMap.put("OtherAction","");
			dataMap.put("downloaddoc","");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			
			dataMap.put("LefttoRight", i18nkey);
			dataMap.put("Reset", i18nkey);
			enobjsupplierPage.Movedoc(dataMap);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.IFRAMEdownloadoc());
			
			Reporter.log("Selected list to download Doc Size after Reset,Expected , 0,Actuals :"+enobjsupplierPage.MoveDocSelected().size());
			softassert.assertEquals(enobjsupplierPage.MoveDocSelected().size(),0,"Size Not Matched,Actuals"+enobjsupplierPage.MoveDocSelected().size());
			
			
			flag=true;
		}
		{
			Reporter.log("Deleting from DB:"+i18nkey);

			String delquery1=" Delete from I18NKey WHERE i18nKey='"+i18nkey+"'";
			String delquery2=" Delete from UserTranslation WHERE i18nKey ='"+i18nkey+"'";
		//	String delquery3=" Delete from CustomerTabDefinition where EditProfile_i18nKey ='"+i18nkey+"'";
			

			String delquery3=" Delete from CustomerFieldDefinition where  EditProfile_i18nKey='"+i18nkey+"'";
			
			String delquery6="Delete from FieldValue where FieldID="+fieldid+"";			
			
			String delquery4=" Delete from CustomerFieldVGMetadata where FieldDefinitionID = '"+fieldid+"'";
			
			String delquery5=" Delete from ExtractCustomDocTypes_LoginRole_Map  where FieldID = '"+fieldid+"' ";
			
			lavanteUtils.UpdateDB(delquery5);
			lavanteUtils.UpdateDB(delquery4);
			lavanteUtils.UpdateDB(delquery6);
			lavanteUtils.UpdateDB(delquery3);
			lavanteUtils.UpdateDB(delquery2);
			lavanteUtils.UpdateDB(delquery1);
			
			
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Retest and RECHECK");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for Validate Doc after reset in Download Document at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	/**SIM-7115
	 * Verify Error message in Download Document
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void DownloadDoc003() throws Exception{	
		
		System.out.println("------------Test Started for Download Doc in Edit Profile-------------------");
		Reporter.log("Test Started for Without Moving fields in Download Document at :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;

		LinkedHashMap<String,String> dataMap =new LinkedHashMap<String,String>();
		String i18nkey="AutoSPField"+LavanteUtils.randomnum();
		String query0="select EditProfile_i18nKey from CustomerTabDefinition  WHERE CustomerId IN ("+custid+") "
				+ "and TabPageInfoID in (8,12,13,14) and EditProfile_i18nKey like '%Auto%'";
		
		String id=lavanteUtils.fetchDBdata(query0);
		
		String query00="select UTFString from UserTranslation where i18nKey = '"+id+"' and LanguageID=50";
		
		String tabname=lavanteUtils.fetchDBdata(query00);	
		
		String query1=" Insert into I18NKey ( i18nKey) VALUES (   '"+i18nkey+"')";
		String query2=" INSERT INTO UserTranslation (i18nKey  ,LanguageID  ,UTFString  ,IsCustomerSpecific) VALUES "
				+ " ('"+i18nkey+"'   ,50    ,'"+i18nkey+"'   ,'' )";
		//If tab not available
		/*String query3="Insert into CustomerTabDefinition (   EditProfile_i18nKey  ,DisplayOrder  ,CustomerId  ,ViewProfile_i18nKey"
				+ "  ,AdvSearch_i18nKey   ,AppendCustomerFieldsTop  ,isViewableBySupplier  ,TabPageInfoID  ,isVisible  ,EditProfileAdditional_i18nKey"
				+ " ) VALUES (  '"+i18nkey+"'   ,"+order+"  ,"+custid+"     ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,1  ,1  ,'39' ,1  ,'"+i18nkey+"')";
		*/
		
		String query4=" Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '"+i18nkey+"'   ,6    ,0    ,'"+i18nkey+"'    ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,0   ,0"
				+ "   ,1   ,0   ,0   ,"+subid+"    ,1   )";
		
		//System.out.println(query3);
		lavanteUtils.UpdateDB(query1);
		lavanteUtils.UpdateDB(query2);
		lavanteUtils.UpdateDB(query4);
		
		String query5="Select FieldId from CustomerFieldDefinition where EditProfile_i18nKey like '%"+i18nkey+"%'";
		
		String fieldid=lavanteUtils.fetchDBdata(query5);
		

		String query6=" Insert into CustomerFieldVGMetadata (  FieldDefinitionID  ,IsVisible)  VALUES (  "+fieldid+"   ,1 )";
		
		lavanteUtils.UpdateDB(query6);
		
		String query7=" Insert into ExtractCustomDocTypes_LoginRole_Map (   UserRoleID  ,FieldID  ,CustomerID) "
				+ " VALUES (  14    ,"+fieldid+"     ,"+custid+" )";
		
		lavanteUtils.UpdateDB(query7);
		
		Reporter.log("Field Inserted into DB:"+i18nkey);
		
		String xl="//h2[contains(text(),'"+tabname+"')]/../..";
		
		//Scroll into Custom Tab
		lavanteUtils.Scrollintoview(driver.findElement(By.xpath(xl)));
		lavanteUtils.click(driver.findElement(By.xpath(xl)));
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(driver.findElement(By.id(i18nkey)));
		lavanteUtils.uploadFile("ANY", driver.findElement(By.id(i18nkey)));
	
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
			dataMap.put("OtherAction","");
			dataMap.put("downloaddoc","");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			
			lavanteUtils.switchtoFrame(enobjsupplierPage.IFRAMEdownloadoc());
			
			lavanteUtils.fluentwait(enobjsupplierPage.moveDocOKbtn());
			lavanteUtils.click(enobjsupplierPage.moveDocOKbtn());
			
			Reporter.log("When No Selected list in Download DOC ,Expected error message ,'Selected Sections' cannot be left blank.,Actuals :"+enobjsupplierPage.errormsg().getText());
			softassert.assertEquals(enobjsupplierPage.errormsg().getText(),"'Selected Sections' cannot be left blank.","Size Not Matched,Actuals"+enobjsupplierPage.errormsg().getText());
			
			
			flag=true;
		}
		{
			Reporter.log("Deleting from DB:"+i18nkey);

			String delquery1=" Delete from I18NKey WHERE i18nKey='"+i18nkey+"'";
			String delquery2=" Delete from UserTranslation WHERE i18nKey ='"+i18nkey+"'";
		//	String delquery3=" Delete from CustomerTabDefinition where EditProfile_i18nKey ='"+i18nkey+"'";
			

			String delquery3=" Delete from CustomerFieldDefinition where  EditProfile_i18nKey='"+i18nkey+"'";
			
			String delquery6="Delete from FieldValue where FieldID="+fieldid+"";			
			
			String delquery4=" Delete from CustomerFieldVGMetadata where FieldDefinitionID = '"+fieldid+"'";
			
			String delquery5=" Delete from ExtractCustomDocTypes_LoginRole_Map  where FieldID = '"+fieldid+"' ";
			
			lavanteUtils.UpdateDB(delquery5);
			lavanteUtils.UpdateDB(delquery4);
			lavanteUtils.UpdateDB(delquery6);
			lavanteUtils.UpdateDB(delquery3);
			lavanteUtils.UpdateDB(delquery2);
			lavanteUtils.UpdateDB(delquery1);
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Retest and RECHECK");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for Validate Doc after reset in Download Document at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	/**SIM-7115
	 * Verify When No Attachment Attached for Custom Field in Custom Tab can be used for Download document with 0 files
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void CustomFieldsNoDownloadDoc004() throws Exception{	
		
		System.out.println("------------Test Started for Download Doc in Edit Profile-------------------");
		Reporter.log("Test Started for Download Document in Edit Profile at :"+currenttime());
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		
		String i18nkey="AutoSPField"+LavanteUtils.randomnum();
		
		String query0="select EditProfile_i18nKey from CustomerTabDefinition  WHERE CustomerId IN ("+custid+") and TabPageInfoID in (8,12,13,14)"
				+ " and EditProfile_i18nKey like '%Auto%'";
		
		String id=lavanteUtils.fetchDBdata(query0);
		
		String query00="select UTFString from UserTranslation where i18nKey = '"+id+"' and LanguageID=50";
		
		String tabname=lavanteUtils.fetchDBdata(query00);		
		String query1=" Insert into I18NKey ( i18nKey) VALUES ( '"+i18nkey+"')";
		String query2=" INSERT INTO UserTranslation (i18nKey  ,LanguageID  ,UTFString  ,IsCustomerSpecific) VALUES "
				+ " ('"+i18nkey+"'   ,50    ,'"+i18nkey+"'   ,'' )";
		//If tab not available
		/*String query3="Insert into CustomerTabDefinition (   EditProfile_i18nKey  ,DisplayOrder  ,CustomerId  ,ViewProfile_i18nKey"
				+ "  ,AdvSearch_i18nKey   ,AppendCustomerFieldsTop  ,isViewableBySupplier  ,TabPageInfoID  ,isVisible  ,EditProfileAdditional_i18nKey"
				+ " ) VALUES (  '"+i18nkey+"'   ,"+order+"  ,"+custid+"     ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,1  ,1  ,'39' ,1  ,'"+i18nkey+"')";
		*/
		
		String query4=" Insert into CustomerFieldDefinition (  EditProfile_i18nKey  ,FieldDataTypeId  ,DisplayOrder   ,UIFieldId  ,ViewProfile_i18nKey  ,AdvSearch_i18nKey  ,IsApplicationRequired  ,IsMandatory"
				+ "  ,IsVisible  ,IsNotify  ,IsNotifyApprove ,SubSectionDefinitionId  ,isViewableBySupplier)  VALUES "
				+ " ( '"+i18nkey+"'   ,6    ,10   ,'"+i18nkey+"'    ,'"+i18nkey+"'    ,'"+i18nkey+"'   ,0   ,0"
				+ "   ,1   ,0   ,0   ,"+subid+"    ,1   )";
		
		//System.out.println(query3);
		lavanteUtils.UpdateDB(query1);
		lavanteUtils.UpdateDB(query2);
		lavanteUtils.UpdateDB(query4);
		
		String query5="Select FieldId from CustomerFieldDefinition where EditProfile_i18nKey like '%"+i18nkey+"%'";
		
		String fieldid=lavanteUtils.fetchDBdata(query5);
		
		String query6=" Insert into CustomerFieldVGMetadata (  FieldDefinitionID  ,IsVisible)  VALUES (  "+fieldid+"   ,1 )";
		
		lavanteUtils.UpdateDB(query6);
		
		String query7=" Insert into ExtractCustomDocTypes_LoginRole_Map (   UserRoleID  ,FieldID  ,CustomerID) "
				+ " VALUES (  14    ,"+fieldid+"     ,"+custid+" )";
		
		lavanteUtils.UpdateDB(query7);
		
		Reporter.log("Field Inserted into DB:"+i18nkey);
		
		String xl="//h2[contains(text(),'"+tabname+"')]/../..";
		
		//Scroll into Custom Tab
		lavanteUtils.Scrollintoview(driver.findElement(By.xpath(xl)));
		lavanteUtils.click(driver.findElement(By.xpath(xl)));
		
		lavanteUtils.switchtoFrame(null);
		lavanteUtils.fluentwait(driver.findElement(By.id(i18nkey)));
		
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(enobjsupplierPage.SearchListIFRAME());
		
		if(enobjsupplierPage.iterateSearchHeaderFindColList("Name").size()>0){
			
			dataMap.put("OtherAction","");
			dataMap.put("downloaddoc","");
			enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
			dataMap.put("LefttoRight", i18nkey);
			dataMap.put("OK", "");
			enobjsupplierPage.Movedoc(dataMap);
			lavanteUtils.switchtoFrame(null);
			
			dataMap.put("maintab","ADMIN");
			dataMap.put("subtab", "DownloadFiles");
			
			enobjhomePage.selectTab(dataMap);
			Reporter.log("In Manage Files,Download Files page:");
			String query8="select FileName from FileDownload where CustomerID="+custid+" and FieldId_CSV ='"+fieldid+"'";
			String fname=lavanteUtils.fetchDBdata(query8);
			System.out.println(query8);
			
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(endownloadFiles.refreshBtn());
			Reporter.log("Downloading the file:"+fname);
			
			lavanteUtils.switchtoFrame(endownloadFiles.IFRAMEdwnloadFile());
			for(int i=0;i<endownloadFiles.ListDownloadFile().size();i++){
				String appfname=endownloadFiles.ListDownloadFile().get(i).getText();
				System.out.println(appfname+fname);
				if(appfname.equalsIgnoreCase(fname)){
					
					dataMap.put("Status", "Completed");
					endownloadFiles.refreshDownloadHistoryTable(dataMap);
					Reporter.log("File downladed available in the Download list");
					
					lavanteUtils.switchtoFrame(endownloadFiles.IFRAMEdwnloadFile());
					
					String fnam=endownloadFiles.ListDownloadFile().get(i).getText();
					String type=endownloadFiles.ListdownloadType().get(i).getText();
					String record=endownloadFiles.ListdownloadNoofRecord().get(i).getText();
			
					
					Reporter.log("Verification Started:");
					Reporter.log("File name ,Expected:"+fname+",Actuals in app:"+fnam);
					softassert.assertEquals(fnam,fname,"File name Not matched,Actuals:"+fnam+"Expected:"+fname);
					Reporter.log("File Status ,Expected:Completed,Actuals in App:"+endownloadFiles.ListdownloadStatus().get(0).getText());
					softassert.assertEquals(endownloadFiles.ListdownloadStatus().get(0).getText(),"Completed","File Status  Not matched,Actuals:"+endownloadFiles.ListdownloadStatus().get(0).getText()+",Expected:Completed");
					Reporter.log("File Type ,Expected:Supplier Documents,Actuals in app:"+type);
					softassert.assertEquals(type,"Supplier Documents","File type Not matched,Actuals:"+type+"Expected:Supplier Documents");
					Reporter.log("File record ,Expected:0,Actuals in App:"+record);
					softassert.assertEquals(record,"0","Record name Not matched,Actuals:"+record+"Expected:0");
					
					flag=true;
					break;
					
				}
				
			}
			
			
		}
		{
			Reporter.log("Deleting from DB:"+i18nkey);

			String delquery1=" Delete from I18NKey WHERE i18nKey='"+i18nkey+"'";
			String delquery2=" Delete from UserTranslation WHERE i18nKey ='"+i18nkey+"'";
		//	String delquery3=" Delete from CustomerTabDefinition where EditProfile_i18nKey ='"+i18nkey+"'";
			

			String delquery3=" Delete from CustomerFieldDefinition where  EditProfile_i18nKey='"+i18nkey+"'";
			
			String delquery6="Delete from FieldValue where FieldID="+fieldid+"";			
			
			String delquery4=" Delete from CustomerFieldVGMetadata where FieldDefinitionID = '"+fieldid+"'";
			
			String delquery5=" Delete from ExtractCustomDocTypes_LoginRole_Map  where FieldID = '"+fieldid+"' ";
			
					
		
			lavanteUtils.UpdateDB(delquery5);
			delquery5="delete * from FileDownload where CustomerID="+custid+" and FieldId_CSV ='"+fieldid+"'";
						
			lavanteUtils.UpdateDB(delquery4);
			lavanteUtils.UpdateDB(delquery6);
			lavanteUtils.UpdateDB(delquery3);
			lavanteUtils.UpdateDB(delquery2);
			lavanteUtils.UpdateDB(delquery1);
			lavanteUtils.UpdateDB(delquery5);
			
			
		}
		
		if(flag==false){
			softassert.assertTrue(false,"Please Retest and RECHECK");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for Validate PayMentTerms in Edit Profile at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}
		
	/**
	 * After MEthod
	 */
	 @AfterMethod
	public void aftermethod(){
		lavanteUtils.switchtoFrame(null);
		enobjhomePage.popupclose();
		lavanteUtils.refreshPage();
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
	}
	
	/**
	 * Setup After Class Close the driver and Quits the browser and Logout
	 * @author Piramanayagam.S
	 * @param null
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

