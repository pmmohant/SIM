/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	MadhuMurthy 
 *///

package com.lavante.sim.customer.TestScripts.ManageAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.ConfigPathFile;
import com.lavante.sim.Common.Util.GetExcelFile;
import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.Common.Util.setTestData;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class MyAccountTC0003_LanguageChange_Customer extends PageInitiator {
	LavanteUtils lavanteUtils=new LavanteUtils();
	static String fname="LanguageValidate.xls";
	static String path=File.separator;
	
	String email="";
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
		List listofdatafrm=lavanteUtils.login("DEL-1", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		email=LdataMap.get("username");
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}

	/**
	 * Method Name : verifyMyAccountTimeZone Purpose: Method for
	 * verifyMyAccountTimeZone
	 * 
	 * @param: None
	 * @return None
	 */
	@Test
	public void verifyMyLanguage() {
		int newRow=0;
		SoftAssert softAssert=new SoftAssert();
		Reporter.log("MyAccountTC0003_LanguageChange_Customer Started: ");
		try {
						
						newRow=ReadExcel();
						
						String[] data=ReadRowData(newRow);
						LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();

						dataMap.put("MySetting","");
						dataMap.put("Language",data[0]);
						dataMap.put("Save","");
						dataMap.put("VerifyMsg","");
						
						enMyAccountPages.MyAccfill(dataMap);
						
						Reporter.log("Language Changed to:"+data[0]);
						
						String msg=enMyAccountPages.SuccessMsg().getText();
						System.out.println("Language Change msg,Expected:"+data[3]+",actual:"+msg);
						Reporter.log("Language Change msg,Expected:"+data[3]+",actual:"+msg);
						Assert.assertEquals(msg, data[3],"Language Change msg,Not Matched,Expected:"+data[3]+",actual:"+msg);
						
						lavanteUtils.waitForTime(6000);
						
						String myacclink=enMyAccountPages.myAccLink().getText();
						System.out.println("Acc Link,Expected:"+data[2]+",actual:"+myacclink);
						Reporter.log("Acc Link,Expected:"+data[2]+",actual:"+myacclink);
						softAssert.assertTrue(data[2].contains(myacclink),"Acc Link,Not Matched,Expected:"+data[2]+",actual:"+myacclink);
						
						
						String log=enobjhomePage.logoutbtn().getText();					
						System.out.println("Logout,Expected:"+data[2]+",actual:"+log);
						Reporter.log("Logout,Expected:"+data[2]+",actual:"+log);
						softAssert.assertTrue(data[2].contains(log),"Logout,Not Matched,Expected:"+data[2]+",actual:"+log);
						
						
						softAssert.assertAll();

	} catch (Exception e) {
		}
		Reporter.log("MyAccountTC0003_LanguageChange_Customer is completed "+currenttime());
	}

	private String[] ReadRowData(int row) throws IOException {
		String[] data=new String[10];
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet("ChangeLanguageForCustomer");
		int rowcount=0;
		LinkedHashMap[][] mapsexcel=null;
		rowcount=sheet.getLastRowNum();
		 int count=0;
		outr:for(int x=0;x<=rowcount;x++)
    	{  
			HSSFRow rows=sheet.getRow(row);
    		HSSFCell column=rows.getCell(4);
    		String lang="";
			if (column == null || column.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else {
					column=rows.getCell(4);
					column.setCellType(Cell.CELL_TYPE_STRING);
				 	lang=column.getStringCellValue();
				 	data[0]=lang;

				 	column=rows.getCell(3);
				 	String logout=column.getStringCellValue();
				 	data[1]=logout;
				 	
				 	column=rows.getCell(6);
				 	String tab=column.getStringCellValue();
				 	data[2]=tab;
				 	
				 	column=rows.getCell(7);
				 	String comment=column.getStringCellValue();
				 	data[3]=comment;
				 	break outr;
				 	
				}
    
    	}
		
		return data;
		
	}


	private int ReadExcel() throws IOException {
		int rowcount=0;
		 String path = File.separator;
		File f = new File(getPresentWorkingDir() + path + dir + path + fname);
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet("ChangeLanguageForCustomer");
		rowcount=0;
		LinkedHashMap[][] mapsexcel=null;
		rowcount=sheet.getLastRowNum();
		rowcount=rowcount-3;
		rowcount=LavanteUtils.randomnum(rowcount);
		
		return rowcount;
	}
	
	@AfterClass
	public void close() throws IOException, SQLException{
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		//Revert to english
		String query="update Contact set LanguageID=50 where Email='"+email+"'";
		lavanteUtils.UpdateDB(query);
		
		String[] data=ReadRowData(1);
		dataMap.put("MySetting","");
		dataMap.put("Language",data[0]);
		dataMap.put("Save","");
		enMyAccountPages.MyAccfill(dataMap);
		
		Reporter.log("Language Changed to:"+data[0]);
		
		
		enobjhomePage.logout();
		quitBrowser();
	}

}
