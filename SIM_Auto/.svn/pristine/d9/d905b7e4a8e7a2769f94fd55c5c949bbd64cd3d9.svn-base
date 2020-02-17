package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
 * Creation of Departments
 * 
 * @author Piramanayagam.S
 *
 */

public class DepartmentsTest01 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	String deptName="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	 launchAppFromPOM(Platform,browser,Version);
	 initiate();	
	 openAPP1();
	 waitForTime(4000);
	 lavanteUtils.driver=driver;
	 
	 objLoginPage.verifyLoginPageDisplayed();
	 List<?> listofdatafrm=lavanteUtils.login("Kroger", browser);
	 LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
	 LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	 enobjloginpage.logintoAPP(LdataMap);
	 waitForTime(3000);
	 objHomePage.verifyHomePageDisplayed();
	 
	}
	
	@BeforeMethod
	public void before(){
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "department");
		enobjhomePage.selectTab(dataMap);
	}
	
	/** 
	 * @author Priyanka
	 * 
	 * Test to verify addition and edit of Departments
	 * 
	 */
	@Test
	public void addEditDepartment(){
	    Reporter.log("Test Started for creation of Department and deletion of Department: "+ currenttime(),true);
	    SoftAssert softassert =new SoftAssert();
	    
	  //Adding Department
		String deptName1 = "AutoTest1"+randomnum();
		dataMap.put("Department", deptName1);
		dataMap.put("Save", "");
		objDepartments.createDepartment(dataMap);
		
		//Verifying created Department availability in Department table
		String actGLCodeV = objDepartments.deptNameValue().getText().trim();
		softassert.assertEquals(actGLCodeV,  deptName1,"Actual Department" + actGLCodeV+ " is not matching with expected Department "+ deptName1);
		Reporter.log("Verification : expected glcode "+ deptName1 + "with actual Department" +actGLCodeV,true);
		
		waitForTime(4000);
		//Searching the Department
		dataMap.put("Search", ""); 
		objDepartments.search(dataMap);
		
		click(objDepartments.deptEdit());
		waitForTime(4000);

		deptName1 = "AutoTest1"+randomnum();
		dataMap.put("Department", deptName1);
		dataMap.put("Save", "");
		objDepartments.FillDepartment(dataMap);
		objDepartments.formActionDepartment(dataMap);

		objDepartments.searchformAction(dataMap);
		
		//Searching the EditedDepartment
		dataMap.put("Search", deptName); 
		objDepartments.search(dataMap);
		
		//Verifying edit updated Department availability in Department table
		String editdeprtname = objDepartments.deptNameValue().getText().trim();
		softassert.assertEquals(editdeprtname,  deptName1,"Actual Department" + editdeprtname+ " is not matching with expected Department "+ deptName1);
		Reporter.log("Verification : expected department "+ deptName1 + "with actual Department" +editdeprtname,true);
				
	    
	}
	
	/** 
	 * @author Piramanayagam.S
	 * 
	 * Test to verify addition and deletion of Departments
	 * 
	 */
	  @Test
	  public void addDeleteDepartment(){
		    Reporter.log("Test Started for creation of Department and deletion of Department: "+ currenttime(),true);
		    SoftAssert softassert =new SoftAssert();
					   
			//Adding Department
			String deptName = "AutoTest1"+randomnum();
			dataMap.put("Department", deptName);
			dataMap.put("Save", "");
			objDepartments.createDepartment(dataMap);
			
			//FOR DB DELETE aFter MEthod
			deptName=deptName;
			
			waitForTime(4000);
			//Searching the Department
			dataMap.put("Search", ""); 
			objDepartments.search(dataMap);
		    
			//Verifying created Department availability in Department table
			String actGLCodeV = objDepartments.deptNameValue().getText().trim();
			softassert.assertEquals(actGLCodeV,  deptName,"Actual Department" + actGLCodeV+ " is not matching with expected Department "+ deptName);
			Reporter.log("Verification : expected glcode "+ deptName + "with actual Department" +actGLCodeV,true);
			
			//Deletion of Department
			click(objDepartments.deptDelete());
			click(objDepartments.deleteConfirmButton());
			waitForTime(5000);
			
			waitForTime(4000);
			//Searching the Department
			dataMap.put("Search", ""); 
			objDepartments.search(dataMap);
		    			
			//Verifying deleted Department availability in Department table
			fluentwait(objDepartments.noResultsText());
			String actdata = objDepartments.noResultsText().getAttribute("innerText");
			String expdata = "No Results";
			softassert.assertEquals(actdata,  expdata, "expected data " +expdata + "is not matching with actual data " +actdata);
			Reporter.log("Verification : expected data "+ expdata + "with actual data" +actdata);
			softassert.assertAll();
			Reporter.log("Test Ended for creation of Department and deltion of Department :" + currenttime(),true);
	  }
	  
	  /** 
		 * @author Priyanka
		 * 
		 * Test to verify duplicate of Departments
		 * 
		 */
	  @Test
	  public void duplicateDepartment(){
		  
		  Reporter.log("Test Started for duplicate of Department: "+ currenttime(),true);
		  SoftAssert softassert =new SoftAssert();
		  boolean flag=false;
		  
		  String deprt = objDepartments.ListDepartment.get(0).getText();
		  dataMap.put("Department", deprt);
		  dataMap.put("Save", "");
		  objDepartments.createDepartment(dataMap);
		  
		  click(objDepartments.Bannerclose());
		  
		  if(objDepartments.Errormsg().isDisplayed()){
			  String exp = "Department name already exists";
			  String actual= objDepartments.Errormsg().getText().trim();
			  softassert.assertTrue(actual.contains(exp),"Error Msg Not matched".trim());
			  Reporter.log("Error message:"+exp+",Actual:"+actual, true);
			  flag=true;
		  }
		  
		  softassert.assertTrue(flag);
		  softassert.assertAll();
		  
	  }
	  
	  /** 
		 * @author Priyanka
		 * 
		 * Test to verify associate of Departments
		 * 
		 * 
		 * SIM-20299 blockes the below automation script
		 */
	  //@Test[Commented due to JIRA]
	  public void deleteAssociatedDepartment(){
		  
		  Reporter.log("Test Started for delete Associated of Department: "+ currenttime(),true);
		  SoftAssert softassert =new SoftAssert();
		  
		//Adding Department
			String deptName = "AutoTest1"+randomnum();
			dataMap.put("Department", deptName);
			dataMap.put("Save", "");
			objDepartments.createDepartment(dataMap);
			
			//FOR DB DELETE aFter MEthod
			deptName=deptName;
			
			waitForTime(4000);
			//Searching the Department
			dataMap.put("Search", deptName); 
			objDepartments.search(dataMap);
		    
			//Verifying created Department availability in Department table
			String actGLCodeV = objDepartments.deptNameValue().getText().trim();
			softassert.assertEquals(actGLCodeV,  deptName,"Actual Department" + actGLCodeV+ " is not matching with expected Department "+ deptName);
			Reporter.log("Verification : expected glcode "+ deptName + "with actual Department" +actGLCodeV,true);
		  
		  
	  }
	  
	  /** 
		 * @author Priyanka
		 * 
		 * Test to verify interrelation of Departments
		 * 
		 */
	  @Test
	  public void interrelationDepartment(){
		  
		  Reporter.log("Test Started for interrelation of Department: "+ currenttime(),true);
		  SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
			boolean flagAdd = false;
			boolean flag= false;
			
			String actualDeprtmnt;
			String deptName = "AutoTest1"+randomnum();
			dataMap.put("Department", deptName);
			dataMap.put("Save", "");
			objDepartments.createDepartment(dataMap);
						
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(objDepartments.AddDprtmntbtn());
			int noRecords = objDepartments.ListDepartment.size();
			outr: for (int i = 0; i < noRecords; i++) {
				actualDeprtmnt = objDepartments.ListDepartment.get(i).getText().trim();
				if (actualDeprtmnt.equalsIgnoreCase(deptName.trim())) {
					
					flagAdd = true;
					Reporter.log("Department name created " + actualDeprtmnt + "Expected Department name " + deptName,true);
					
				}
			}
			if (flagAdd) {
				dataMap.put("maintab", "Admin");
				dataMap.put("subtab", "Contacts");
				enobjhomePage.selectTab(dataMap);
				
				click(objUserPage.AddNewUserBtn);
				click(objUserPage.DepartmentDrpDwn());
				switchtoFrame(null);
				List<WebElement> el=lavanteUtils.driver.findElements(By.cssSelector("div[class*='active'] div[class*='drop'] li"));
				for (int i = 0; i < el.size(); i++) {
					String deprtmentMapdata = el.get(i).getText().trim();
					if (deptName.equalsIgnoreCase(deprtmentMapdata)) {
						Reporter.log("Department name availabe to select is: " + deprtmentMapdata + ", Expected Department name : "+ deptName, true);
						flag = true;
						deptName=deprtmentMapdata;
						break;
					}
				}
			}

			softAssert.assertTrue(flagAdd, "Add Department is failed");
			softAssert.assertTrue(flag, "Department is not avilable");
			softAssert.assertAll();
			Reporter.log("Test Ended at:" + currenttime());
		}
		  
		  
	  
	  
	  /**
	   * AfterMethod - Delete the Department from the dB
	   * @throws FileNotFoundException
	   * @throws IOException
	   * @throws SQLException
	   */
	  @AfterMethod
	  public void afterMethod() throws FileNotFoundException, IOException, SQLException{
		  if(deptName.length()>0){
			  String x="delete From Department where Code='"+deptName+"'";
			  lavanteUtils.UpdateDB(x);
			  deptName="";
		  }
	  }
	  
	  
	  @AfterClass
	  public void close(){
		    enobjhomePage.logout();
			quitBrowser();
		}
  
}
