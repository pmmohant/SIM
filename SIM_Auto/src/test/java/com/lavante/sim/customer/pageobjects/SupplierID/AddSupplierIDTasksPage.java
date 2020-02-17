package com.lavante.sim.customer.pageobjects.SupplierID;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.*;

public class AddSupplierIDTasksPage {
private WebDriver driver=null;
LavanteUtils lavanteUtils=new LavanteUtils();
SoftAssert sassert=new SoftAssert();

	private String pgtitle="Lavante SIM - Add Supplier ID";

	@FindBy(linkText="Tasks")
	private WebElement linkTasks;
	@FindBy(linkText="Add Supplier ID")
	private WebElement linkAddsupplierID;
	@FindBy(id="actionButton")
	private WebElement idaddsupplIDbtn;
	@FindBy(className="data_not_found")
	private WebElement clsNodata;
	@FindBy(xpath="//table[@id='add_supplierID']")
	private WebElement xpathtable;
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front dialog ui-dialog-buttons']")
	private WebElement xpathAddSupplierIDpopup;
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front dialog ui-dialog-buttons']//button[@class='button_green']")
	private WebElement xpathpopupOK;
	@FindBy(xpath="//input[@class='button_green']")
	private WebElement xpathbtnResolve;
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement xpathtextComment;
	@FindBy(xpath="//table[@class='data_table table_grid zebra']/tbody/tr/th")
	private List<WebElement> xpathtableExistingSupplierheader;
	@FindBy(xpath="//table[@class='data_table table_grid zebra']/tbody/tr/td")
	private WebElement xpathtableExistingSupplierdata;
	@FindBy(xpath="//iframe[@class='popup_iframe ui-dialog-content ui-widget-content']")
	private WebElement xpathiframeExistingSupplierIDpopup;
	@FindBy(xpath="//a[contains(@class,'open_popup') and contains(@href,'getERPSupplier')]")
	private WebElement xpathexistingSupplierIDlink;
	


public AddSupplierIDTasksPage(WebDriver driver){
	this.driver=driver;
	
}

public void navigatetoTasksAddSupplierID(){
	try{
		lavanteUtils.click(linkTasks);
		Reporter.log("\n Clicked on the |Tasks| TAB ");
		lavanteUtils.waitForTime(5000);
		lavanteUtils.click(linkAddsupplierID);
		Reporter.log("Clicked on the |Add Supplier ID| TAB");
		lavanteUtils.assertPageTitle(pgtitle);
	}catch(Exception e){
		Reporter.log("Navigation to the approval tasks failed due to : "+e.getCause());
		//log.severe("Failure in navigating to the approval tasks tab due to : "+e.getMessage());
		Assert.assertFalse(false, "Failed in navigation to the approval tasks page.  "+e.getCause());
	}
	
	
}

/**
 * Method: enterSupplierIDtoSupplier
 * Description: to add the supplier ID to the Supplier Specified
 * @param str_headername
 * @param str_suppliername
 * @param supplierID
 */
public void enterSupplierIDtoSupplier(String str_headername,String str_suppliername,String supplierID){
	int int_row=1;
	int int_col=0;
	String xpatheditsupplierID="/input[@type='text']";
	try{
		//int_row=checkTableData(xpathtable+"//thead/tr/th", xpathtable+"//tbody/tr", str_headername, str_suppliername);
		int_col=searchHeader("Supplier ID", xpathtable+"//thead/tr/th");
		lavanteUtils.typeinEdit(supplierID,driver.findElement(By.xpath(xpathtable+"//tbody/tr["+int_row+"]/td["+int_col+"]"+xpatheditsupplierID)));
		Reporter.log("Entered the supplier ID in the edit box in front of the supplier ");	
	}catch(Exception e){
		e.printStackTrace();
		Reporter.log("Failure in addition of supplier ID ");
		//log.severe("Failure due to  : "+e.getMessage());
		Assert.assertTrue(false,"Failure due to"+e.getCause());
	}
	
}

public void addSupplierID(){
	try{
		lavanteUtils.click(idaddsupplIDbtn);
		Reporter.log("Clicked on the Add Supplier ID button");
		if (lavanteUtils.isElementDisplayed(xpathAddSupplierIDpopup)) {
			Reporter.log("After clicking on the AddSupplierID button the pop-up appeared");
			if(lavanteUtils.isElementDisplayed(xpathpopupOK)){
				Reporter.log("The OK button is displayed in the pop-up");
				lavanteUtils.click(xpathpopupOK);
				Reporter.log("Clicked on the OK button in the pop-up");
			}else{
				//log.severe("OK button is not present in the pop-up window ");
				/*Reporter.log("Failed to find the OK button in the popup window");
				gp.takeScreenshot(driver, "OK_button");*/
			}
			
		}else{
			//log.severe("The pop up window did not open even after clicking on AddSupplierID button");
		/*	gp.takeScreenshot(driver, "pop-upWindow_didnot_open");
			Reporter.log("The pop-up did not appear even after entering the supplier ID for the supplier and clicking on the button");*/
		}
		
	}catch(Exception e){
		/*e.printStackTrace();
		Reporter.log("Failed to do the operation of Addition of the supplier ID ");
		//log.severe("Failure to add the supplier ID due to  : "+e.getMessage());
		gp.assertFailure(driver, "Failure in adding new supplier ID due to : ", ""+e.getCause());*/
	}
}


public int checkTableData(String str_headersxpath,String str_tablecontentsxpath,String str_header,String str_searchdata){
	String str_temp="";
	//WebElement we_ret=null;
	int int_ret=0;
	try{
		Assert.assertFalse(noDataAvailable(),"Failure due to no data is available");
		Reporter.log("\n Data is available in the supplier search table");
		String xpath_append="/td["+searchHeader(str_header,str_headersxpath)+"]";
		List<WebElement> lst_webelem=driver.findElements(By.xpath(str_tablecontentsxpath+xpath_append));
		for(int i=1;i<=lst_webelem.size();i++){
			str_temp=lavanteUtils.getText(driver.findElement(By.xpath(str_tablecontentsxpath+"["+i+"]"+xpath_append)));
			if(str_temp.trim().equalsIgnoreCase(str_searchdata.trim())||str_temp.trim().contains(str_searchdata.trim())){
				driver.findElement(By.xpath(str_tablecontentsxpath+"["+i+"]"+xpath_append));
				int_ret=i;
				Reporter.log("Supplier detail : "+str_header+" searched is : "+str_searchdata+" is found in the table in the row : "+i);
				break;
			}
		}
		
	}catch(Exception e){
		/*Reporter.log("Failed to check the table conntent "+str_searchdata+" Under the header : "+str_header);
		//log.severe("Failed to find the data "+str_searchdata+" under the header "+str_header+" due to "+e.getCause());
		gp.assertFailure(driver, "Failed due to ", ""+e.getMessage());*/
	}
	return int_ret;
}


public int searchHeader(String str_header, String str_xpathheaders){
	int int_ret=0;
	String str_temp="";
	try{
		List<WebElement> lst_webelem=driver.findElements(By.xpath(str_xpathheaders));
		for(int i=1;i<=lst_webelem.size();i++){
			str_temp=lavanteUtils.getText(driver.findElement(By.xpath(str_xpathheaders+"["+i+"]")));
			if(str_temp.trim().equalsIgnoreCase(str_header.trim())){
				Reporter.log("The header :"+str_header+" is found at position : "+i);
				int_ret=i;
				break;
			}
		}
		
	}catch(Exception e){
		/*Reporter.log("Failed to find the header from the table ");
		//log.severe("Failure to search the header from the table due to the reason : "+e.getMessage());
		gp.assertFailure(driver, "Failure to find the header from the table ", "Header : "+str_header);*/
	}
	return int_ret;
}
	
public String validateExistingSupplierID(String str_comments){
	String str_temp="";
	String str_suppliername="";
	try{
		if(lavanteUtils.isElementDisplayed(xpathexistingSupplierIDlink)){
			Reporter.log("Found the link after reassigning the existing supplier ID to the new supplier");
			lavanteUtils.click( xpathexistingSupplierIDlink);
			lavanteUtils.waitForTime(3000);
			Reporter.log("Clicked on the link that appears below the edit box");
			if(lavanteUtils.isElementDisplayed(xpathiframeExistingSupplierIDpopup)){
				Reporter.log("Found the frame after clicking on the link");
				Assert.assertTrue(lavanteUtils.switchtoFrame( xpathiframeExistingSupplierIDpopup));
				Reporter.log("Switched to the iframe of the pop-up");
				if(lavanteUtils.isElementDisplayed(xpathtableExistingSupplierheader.get(0))){
					int i=1;
					for (WebElement we: xpathtableExistingSupplierheader){
						str_temp=we.getText();
						if(str_temp.trim().equalsIgnoreCase(ConfigPathFile.SupplierNAME.getConstantValue()+":")){
							Reporter.log("Found the supplier name with the existing supplier ID in the table");
							str_suppliername=lavanteUtils.getText(driver.findElement(By.xpath(xpathtableExistingSupplierdata+"["+i+"]")));
							break;
						}
						i=i+1;
					}
				}
				lavanteUtils.typeinEdit(str_comments, xpathtextComment);
				Reporter.log("Entered the comments in the comments feild ");
				lavanteUtils.click(xpathbtnResolve);
				Reporter.log("Clicked on the Resolve button");
				lavanteUtils.waitForTime(5000);
				lavanteUtils.switchtoFrame(null);
			}else{ 
//				Reporter.log("Failed to find the pop-up frame after clicking on the link ");
//				gp.takeScreenshot(driver, "popup missing");
			}
		}else{
			/*Reporter.log("Failed to find the link to the pop up after reassigning the supplier id to a new supplier ");
			//log.severe("Failed to find the link to the pop-up after reassigning Supplier ID to the new supplier");
			gp.takeScreenshot(driver, "failed to find the link to the popup");*/
		}
	}catch(Exception e){
		e.printStackTrace();
		Reporter.log("Failed to find the link to to the pop-up after the existing supplier ID has been assigned to a new supplier");
		//log.severe("Failed ");
	}
	return str_suppliername;
}

	/**
	 * Method : noDataAvailable
	 * Purpose : To check if there is data available
	 * @param none
	 * @return boolean
	 * @author priya.pais
	 */
	public boolean noDataAvailable(){
		boolean bool_nodata=false;
		try{
			if(lavanteUtils.isElementDisplayed(clsNodata)){
				Reporter.log("There is no data available");
				bool_nodata=true;
			}else{
				Reporter.log("Data is available");
				bool_nodata=false;
			}
		}catch(Exception e){
			//Reporter.log("Failure in checking the data availability");
			//log.severe("Failure to check the data availability due to : "+e.getMessage());
		}
		return bool_nodata;
	}
	

/**
 * Method: dbGetTime
 * Purpose: Get the time from the database
 * @param none
 * @return String 
 */
public String dbGetTime(){
	String str_time="";
	try{
		str_time=lavanteUtils.fetchDBdata("SELECT CONVERT(VARCHAR, getdate(), 101) + ',' +  CONVERT(varchar(15),CAST(GETDATE() AS TIME),100)");
		Reporter.log("The time got from database : "+str_time);
	}catch(Exception e){
		/*Reporter.log("Failure in the DB component execution : "+e.getCause());
		//log.severe("DB query data fetching failure");
		Assert.assertTrue(false,"Failure in the DB query execution");*/
	}
	return str_time;
}

/**
 * Method: dBconnect
 * Purpose: to fetch data from DB
 * @param test_query
 * @return
 * @throws SQLException
 */
public String dBconnect(String test_query){
	String str_cnt="";
	try{
	/*con=lavanteUtils.ConnectToDB();
	
	if(con.isValid(1000)){
		Reporter.log("DATABASE connection is estabished and is valid");
	res_query=lavanteUtils.DBResultSet(con, test_query);
	int i=1;
	while(res_query.next()){
		lst.add(res_query.getString(i++));
	}*/
		
	 str_cnt=lavanteUtils.fetchDBdata(test_query);
	

	}catch(Exception e)
	{
		//log.severe("DB query execution error due to :"+e.getMessage());
		Assert.assertTrue(false,"DB query execution error");
	}
	
	return str_cnt;
}
}
