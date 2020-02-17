
package com.lavante.sim.customer.TestScripts.ManageAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class MyAccountTC0003_VerifyTimeZone extends PageInitiator  {

	LavanteUtils lavanteUtils=new LavanteUtils();	

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		
		openAPP();
			
		lavanteUtils.driver=driver;
		
		//Login
		List<?> listofdatafrm=lavanteUtils.login("DEL-1", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
	}

	
	/**
	 * Method Name : verifyMyAccountTimeZone 
	 * Change the time zone verify in Admin Upload page
	 * 
	 * @author Piramanayagam.S
	 * @param: None
	 * @return None
	 * @throws IOException 
	 */
	@Test
	public void verifyMyAccountTimeZone() throws IOException {
		Reporter.log("Time Zone Test Started: "+currenttime());
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "Upload");
		enobjhomePage.selectTab(dataMap);
		
		String[] data=ReadRowData();
		
		SoftAssert softAssert=new SoftAssert();
		if(data.length>1){	
			dataMap.put("MySetting","");
			dataMap.put("Timezone",data[1]);
			dataMap.put("Save","");
			enMyAccountPages.MyAccfill(dataMap);
			
			enobjuploadFiles.UploadFile(dataMap);
			
			lavanteUtils.switchtoFrame(enobjuploadFiles.IFRAMEVMFuploadFile());
			for (int i = 0; i < enobjuploadFiles.ListUploadFileOn().size(); i++) {
				String actOn = enobjuploadFiles.ListUploadFileOn().get(i).getText();
				String expDownload =data[0];
				Reporter.log("Uploaded file status,Expected:" + expDownload + ",Actuals:" + actOn,true);
				softAssert.assertTrue(actOn.contains(expDownload), "File Download On not matched");
				break;
			}
		}else{
			softAssert.assertTrue(false, "Please Correct the Test data");
		}
		
		softAssert.assertAll();
		
		Reporter.log("Time Zone Test Ended: "+currenttime());
	}
	
	private String[] ReadRowData() throws IOException {
		
		String[] data=new String[10];
		String directory = LavanteUtils.getPresentWorkingDir();
		 String fname = "MyAccTimeZone_UI_Control.xls";
		 String path = File.separator;
		 String dir = LavanteUtils.dir;
		File f = new File(directory + path + dir + path + fname);
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet("TimeZones");
		int rowcount=0;
		LinkedHashMap[][] mapsexcel=null;
		rowcount=sheet.getLastRowNum();
		rowcount=LavanteUtils.randomnum(rowcount);
		 int count=0;
		outr:for(int x=0;x<=rowcount;x++)
    	{  
			HSSFRow rows=sheet.getRow(rowcount);
    		HSSFCell column=rows.getCell(0);
    		String lang="";
			if (column == null || column.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else {
					column=rows.getCell(0);
					column.setCellType(Cell.CELL_TYPE_STRING);
				 	lang=column.getStringCellValue();
				 	data[0]=lang;

				 	column=rows.getCell(1);
				 	String logout=column.getStringCellValue();
				 	data[1]=logout;

				 	break outr;
				 	
				}
    
    	}
		
		return data;
		
	}
	
	@AfterClass
	public void close(){
		enobjhomePage.logout();
		quitBrowser();
	}

	

}
