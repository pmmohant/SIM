package com.lavante.recovery.TestScripts.UAT;

import java.util.LinkedHashMap;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.recovery.Common.Util.LavanteUtils;
import com.lavante.recovery.pageobjects.pageInitiator;

public class Config_Uploads extends pageInitiator {

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void preCondition(@Optional(LavanteUtils.Platform) String platform,
			@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String version)
			throws Exception {

		launchAppThroughPOM(platform, browser, version);
		initiate();
		openAPP();

		loginPage.login();
		waitForTime(2000);
		homePage.SelectAudit(InitProperties("DefaultAudit").trim());
		
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		dataMap.put("maintab","configuration");
        dataMap.put("subtab","uploadConfiguration");
        homePage.selectTab(dataMap);
        waitforPageload(configUploadsPage.suppFilesTab());
	}
	
	/**
	 * Method to upload supplier details file and validate the same.
	 * @author girish.n
	 */
	@Test
	public void uploadSupplierFileTest(){
		
		Reporter.log("uploadSupplierFileTest Method Started at: " + currenttime(),true);
		LinkedHashMap<String,String> dataMap = new LinkedHashMap<String,String>();
		boolean flag=false;
		
		//Uploading File
		String expfileName="AddSuppTemplate-2.csv";
		String fullfileName="D:\\Recovery\\Extras\\UploadFileTemplate\\"+expfileName;
		dataMap.put("UploadType", "Add Supplier File");
		dataMap.put("UploadFile", fullfileName);
		dataMap.put("AddSuppFile","");
		configUploadsPage.uploadFile(dataMap);
		
		//Validating the upload
		SoftAssert softAssert = new SoftAssert();
		switchtoFrame(configUploadsPage.frameSuppFiles());
		
		for(int i=0;i<configUploadsPage.suppFileNameList().size();i++){
			String actFileName=configUploadsPage.suppFileNameList().get(i).getText().trim();
			if(expfileName.equalsIgnoreCase(actFileName)){
				
				softAssert.assertEquals(actFileName, expfileName);
				Reporter.log("Expected File Name:"+expfileName+"::Actual File Name:"+actFileName,true);
				
				String upldStatus=configUploadsPage.suppUpldStatusList().get(i).getText().trim(); 
				if(upldStatus.contains("Upload Process Completed")){
					flag=true;
				
				}else 
					for(int j=1;j<=4;j++){
						if(upldStatus.contains("File Loaded") || upldStatus.contains("Upload in Progress")){
							Reporter.log("Upload Status:"+upldStatus,true);
							waitForTime(30000);
							switchtoFrame(null);
							fluentwait(configUploadsPage.refreshSuppFilesBtn());
							click(configUploadsPage.refreshSuppFilesBtn());
							waitforPageload(configUploadsPage.refreshSuppFilesBtn());
							switchtoFrame(configUploadsPage.frameSuppFiles());
							upldStatus=configUploadsPage.suppUpldStatusList().get(i).getText().trim();
							
							if(upldStatus.contains("Upload Process Completed")){
								flag=true;
								break;
						}	
					}
				}
				Reporter.log("Upload Status:"+upldStatus,true);
				break;
			}			
		}
		switchtoFrame(null);
		Reporter.log("uploadSupplierFileTest Method Ended at: " + currenttime(),true);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
	}	
	@AfterClass
	public void QuitBrowser() {
		  homePage.logout();
		  quitBrowser();
	}		
}
