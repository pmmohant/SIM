package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
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
 * Created on 13-09-2018
 *@author Piramanayagam.S
 *Ended on 16-09-2018
 *
 */

public class LayoutTest extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String username=null;

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
			throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		username=LdataMap.get("username");
		
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();

	}
	
	@BeforeMethod
	public void before(){
		enobjhomePage.Layoutselect();
	}
	
	/**
	 * 
	 * Add and Edit the Layout
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void AddEditLayouttTest() throws Exception {
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
				
		Reporter.log("Test Started for verifyAddEdittLayoutTest :" + currenttime());
	
		
		String qname="Auto"+currenttime();
		String page="Claims to approve";
		dataMap.put("Page", page);
		dataMap.put("LayoutName",qname );
		dataMap.put("LayoutList","Attachments#Amount" );
		dataMap.put("Access", "Private");
		dataMap.put("Visibility", "Show this layout in the your dropdown options");
		dataMap.put("Save", "");
		objLayoutPage.CreateLayout(dataMap);

		SoftAssert softAssert=new SoftAssert();
		String yx=dataMap.get("SelectedSection");
				
		lavanteUtils.switchtoFrame(null);
		boolean flag = false;
		String actualAlertName = null;
		int size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Access rights").get(i));
				Reporter.log("Acces Rights, Exp:Private Actual:"+actualAlertName);
				softAssert.assertEquals(actualAlertName, "Private");
				
				dataMap.put("Action","Edit");
				objLayoutPage.selectAction(dataMap);
				
				dataMap.clear();
				qname="Auto"+currenttime();
				dataMap.put("LayoutName",qname );
				dataMap.put("Access", "Public");
				dataMap.put("Save", "");
				objLayoutPage.fillLayout(dataMap);
				objLayoutPage.formAction(dataMap);
								
				lavanteUtils.switchtoFrame(null);
				actualAlertName = null;
				size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
				for (i = 0; i <= size - 1; i++) {
					actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

					if (qname.equals(actualAlertName)) {
						Reporter.log("After Change, actualAlertName:" + actualAlertName + " expectedAlertName  " + qname,true);
					
						actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Access rights").get(i));
						Reporter.log("Acces Rights, Exp:Private Actual:"+actualAlertName);
						softAssert.assertEquals(actualAlertName, "Public");
						
						flag=true;
						break outr;
					}
				}
				
			}
		}

		Assert.assertTrue("Please retest",	flag);
		
		dataMap.put("Page",page);
		objLayoutPage.jumpTaskPage(dataMap);
		
		enobjhomePage.selectTab(dataMap);

		dataMap.put("LayoutName",qname);
		objLayoutPage.changeLayout(dataMap);
		
		List<String> act=objLayoutPage.ListofHeader();
		
		flag=false;
		for(int i=0;i<act.size();i++){
			Reporter.log(act.get(i)+",Actuals,Exp:"+yx);
			if(yx.contains(act.get(i))){
				Assert.assertTrue("Not matched",true);
				flag=true;
			}
		}
		
		softAssert.assertTrue(flag,	"Please retest the task");
		softAssert.assertAll();
		
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * Add and Delete the Layout
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void AddDeleteLayouttTest() throws Exception {
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
				
		Reporter.log("Test Started for verifyAdd Delete LayoutTest :" + currenttime());
		
		String qname="Auto"+currenttime();
		String page="Claims to approve";
		dataMap.put("Page",page );
		dataMap.put("LayoutName",qname );
		dataMap.put("LayoutList","Attachments#Amount" );
		dataMap.put("Access", "Private");
		dataMap.put("Visibility", "Show this layout in the your dropdown options");
		dataMap.put("Save", "");
		objLayoutPage.CreateLayout(dataMap);

		SoftAssert softAssert=new SoftAssert();
		
		lavanteUtils.switchtoFrame(null);
		boolean flag = false;
		String actualAlertName = null;
		int size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Access rights").get(i));
				Reporter.log("Acces Rights, Exp:Private Actual:"+actualAlertName);
				softAssert.assertEquals(actualAlertName, "Private");
				
				dataMap.put("Action","Delete");
				objLayoutPage.selectAction(dataMap);
				
				lavanteUtils.switchtoFrame(null);
				actualAlertName = null;
				size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
				for (i = 0; i <= size - 1; i++) {
					actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

					if (!qname.equalsIgnoreCase(actualAlertName)) {
						flag=true;
						break outr;
					}
				}
				
			}
		}

		Assert.assertTrue("Please retest",	flag);
		
		dataMap.put("Page",page);
		objLayoutPage.jumpTaskPage(dataMap);
		
		enobjhomePage.selectTab(dataMap);

		dataMap.put("LayoutName",qname);
		objLayoutPage.changeLayout(dataMap);
		
		Reporter.log(dataMap.get("selectedValue")+",Actuals,Exp:0",true);
		softAssert.assertFalse(dataMap.get("selectedValue").length()>0,	"Layout not deleted");
		
		softAssert.assertTrue(flag,	"Please retest the task");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for add delete at:" + currenttime());
	}

	/**
	 * 
	 * Add and Mark Default the layout 
	 * Verify the page loads with layout
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void MarkDefaultLayouttTest() throws Exception {
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
				
		Reporter.log("Test Started for verifyMark Default Test :" + currenttime());
		
		String qname="Auto"+currenttime();
		String page="Claims to approve";
		dataMap.put("Page", page);
		dataMap.put("LayoutName",qname );
		dataMap.put("LayoutList","Attachments#Amount" );
		dataMap.put("Access", "Private");
		dataMap.put("Visibility", "Show this layout in the your dropdown options");
		dataMap.put("Save", "");
		objLayoutPage.CreateLayout(dataMap);

		SoftAssert softAssert=new SoftAssert();
		
		lavanteUtils.switchtoFrame(null);
		boolean flag = false;
		String actualAlertName = null;
		int size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Access rights").get(i));
				Reporter.log("Acces Rights, Exp:Private Actual:"+actualAlertName);
				softAssert.assertEquals(actualAlertName, "Private");
				
				actualAlertName = objLayoutPage.iterateSearchHeaderFindColList("Actions#Default").get(i).getAttribute("class");
				if(actualAlertName.contains("unmarkDefault")){
					Reporter.log("Default, Exp:Default Actual:"+actualAlertName);
					softAssert.assertTrue(true, "DEfault failed");
				}
				
				dataMap.put("Action","MakeDefault");
				objLayoutPage.selectAction(dataMap);
				
				lavanteUtils.switchtoFrame(null);
				actualAlertName = null;
				size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
				for (i = 0; i <= size - 1; i++) {
					actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

					if (qname.equals(actualAlertName)) {
						Reporter.log("After Change, actualAlertName:" + actualAlertName + " expectedAlertName  " + qname,true);
						
						actualAlertName = objLayoutPage.iterateSearchHeaderFindColList("Actions#Default").get(i).getAttribute("class");
						if(actualAlertName.contains("makeDefault")){
							Reporter.log("Default, Exp:Default Actual:"+actualAlertName);
							softAssert.assertTrue(true, "DEfault failed");
							flag=true;
						}
						
						break outr;
					}
				}
				
			}
		}

		Assert.assertTrue("Please retest",	flag);
		
		dataMap.put("Page",page);
		objLayoutPage.jumpTaskPage(dataMap);
		
		enobjhomePage.selectTab(dataMap);

		dataMap.put("LayoutName",qname);
		objLayoutPage.changeLayout(dataMap);
		
		Reporter.log(dataMap.get("defaultValue")+",Actuals,Exp:"+qname,true);
		softAssert.assertEquals(dataMap.get("selectedValue"),qname,	"Default not matched");
		
		softAssert.assertTrue(flag,	"Please retest the task");
		softAssert.assertAll();
		
		Reporter.log("Test Ended at:" + currenttime());
	}

	/**
	 * 
	 * Add and unMArk Default the layout 
	 * Verify the page loads with layout
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void UnMarkDefaultLayouttTest() throws Exception {
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
				
		Reporter.log("Test Started for verify UnMark Default Test :" + currenttime());
		
		String qname="Auto"+currenttime();
		String page="Claims to approve";
		dataMap.put("Page", page);
		dataMap.put("LayoutName",qname );
		dataMap.put("LayoutList","Attachments#Amount" );
		dataMap.put("Access", "Private");
		dataMap.put("Visibility", "Show this layout in the your dropdown options#Make this layout your page default");
		dataMap.put("Save", "");
		objLayoutPage.CreateLayout(dataMap);

		SoftAssert softAssert=new SoftAssert();
		
		lavanteUtils.switchtoFrame(null);
		boolean flag = false;
		String actualAlertName = null;
		int size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Access rights").get(i));
				Reporter.log("Acces Rights, Exp:Private Actual:"+actualAlertName);
				softAssert.assertEquals(actualAlertName, "Private");
				
				actualAlertName = objLayoutPage.iterateSearchHeaderFindColList("Actions#Default").get(i).getAttribute("class");
				if(actualAlertName.contains("makeDefault")){
					Reporter.log("Default, Exp:Default Actual:"+actualAlertName);
					softAssert.assertTrue(true, "DEfault failed");
				}
				
				dataMap.put("Action","UnMarkDefault");
				objLayoutPage.selectAction(dataMap);
				
				lavanteUtils.switchtoFrame(null);
				actualAlertName = null;
				size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
				for (i = 0; i <= size - 1; i++) {
					actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

					if (qname.equals(actualAlertName)) {
						Reporter.log("After Change, actualAlertName:" + actualAlertName + " expectedAlertName  " + qname,true);
						
						actualAlertName = objLayoutPage.iterateSearchHeaderFindColList("Actions#Default").get(i).getAttribute("class");
						if(actualAlertName.contains("unmarkDefault")){
							Reporter.log("Default, Exp:Default Actual:"+actualAlertName);
							softAssert.assertTrue(true, "DEfault failed");
							flag=true;
						}
						
						break outr;
					}
				}
				
			}
		}

		Assert.assertTrue("Please retest",	flag);
		
		dataMap.put("Page",page);
		objLayoutPage.jumpTaskPage(dataMap);
		
		enobjhomePage.selectTab(dataMap);

		dataMap.put("LayoutName",qname);
		objLayoutPage.changeLayout(dataMap);
		
		Reporter.log(dataMap.get("defaultValue")+",Actuals,Should not match Exp:"+qname,true);
		softAssert.assertNotEquals(dataMap.get("selectedValue"),qname,	"Default matched");
		
		softAssert.assertTrue(flag,	"Please retest the task");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for UnMark at:" + currenttime());
	}

	/**
	 * In this test, we dont select the dropdown option while saving 
	 * verify in the manage layout page
	 * verify its in the dropdown of task page or not 
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void showinDropdownTest() throws Exception {
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
				
		Reporter.log("Test Started for verify Show in Dropdown LayoutTest :" + currenttime());
		
		String qname="Auto"+currenttime();
		String page="Claims to approve";
		dataMap.put("Page",page );
		dataMap.put("LayoutName",qname );
		dataMap.put("LayoutList","Attachments#Amount" );
		dataMap.put("Access", "Public");
		dataMap.put("Save", "");
		objLayoutPage.CreateLayout(dataMap);

		SoftAssert softAssert=new SoftAssert();
		
		lavanteUtils.switchtoFrame(null);
		boolean flag = false;
		String actualAlertName = null;
		int size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Type").get(i));
				String exp="User defined";
				Reporter.log("Type, Exp:"+page+",Actual:"+actualAlertName,true);
				softAssert.assertEquals(actualAlertName, exp,"Type not matched");
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Page name").get(i));
				Reporter.log("page, Exp:"+page+",Actual:"+actualAlertName,true);
				softAssert.assertEquals(actualAlertName, page,"page not matched");
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Created by").get(i)).toLowerCase();
				Reporter.log("Created by, Exp:"+page+",Actual:"+actualAlertName,true);
				exp=username.toLowerCase();
				softAssert.assertEquals(actualAlertName, exp,"Created by not matched");
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Access rights").get(i));
				Reporter.log("Acces Rights, Exp:Public Actual:"+actualAlertName,true);
				softAssert.assertEquals(actualAlertName, "Public","Access right not matched");
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Personal visibility").get(i));
				Reporter.log("Personal , Exp:Not in dropdown Actual:"+actualAlertName,true);
				softAssert.assertEquals(actualAlertName, "Not in dropdown","Personal not matched");
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Organizational visibility").get(i));
				Reporter.log("Organizational , Exp:Not in dropdown Actual:"+actualAlertName,true);
				softAssert.assertEquals(actualAlertName, "Not in dropdown","Organizational not matched");
				
				flag=true;
				break outr;
			}
		}

		Assert.assertTrue("Please retest",	flag);
		
		dataMap.put("Page",page);
		objLayoutPage.jumpTaskPage(dataMap);
		
		enobjhomePage.selectTab(dataMap);

		dataMap.put("LayoutName",qname);
		objLayoutPage.changeLayout(dataMap);
		
		Reporter.log(dataMap.get("selectedValue")+",Actuals,Exp:0",true);
		softAssert.assertFalse(dataMap.get("selectedValue").length()>0,	"Layout not deleted");
		
		softAssert.assertTrue(flag,	"Please retest the task");
		softAssert.assertAll();
		
		Reporter.log("Test Ended for Shown in Dropdown at:" + currenttime());
	}
	
	/**
	 * 
	 * Add and Search the Layout on Filter
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void SearchLayouttTest() throws Exception {
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<>();
				
		Reporter.log("Test Started for Search LayouttTest :" + currenttime());
	
		String qname="Auto"+currenttime();
		String page="Claims to approve";
		dataMap.put("Page", page);
		dataMap.put("LayoutName",qname );
		dataMap.put("LayoutList","Attachments#Amount" );
		dataMap.put("Access", "Private");
		dataMap.put("Save", "");
		objLayoutPage.CreateLayout(dataMap);

		SoftAssert softAssert=new SoftAssert();
				
		lavanteUtils.switchtoFrame(null);
		boolean flag = false;
		String actualAlertName = null;
		int size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Created by").get(i)).toLowerCase();
				Reporter.log("Created by, Exp:"+page+",Actual:"+actualAlertName,true);
				String exp=username.toLowerCase();
				softAssert.assertEquals(actualAlertName, exp,"Created by not matched");
						
				flag=true;
				break outr;
				
			}
		}

		Assert.assertTrue("Please retest the page",	flag);
		
		dataMap.put("Search","");
		dataMap.put("Createdby","Created by anyone");
		objLayoutPage.filterSearch(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		flag = false;
		actualAlertName = null;
		size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Created by").get(i)).toLowerCase();
				Reporter.log("Created by, Exp:"+page+",Actual:"+actualAlertName,true);
				String exp=username.toLowerCase();
				softAssert.assertEquals(actualAlertName, exp,"Created by not matched");
						
				flag=true;
				break outr;
				
			}
		}
		
		softAssert.assertTrue(flag,	"Please retest  anyone");
		
		dataMap.put("Createdby","Created by me");
		objLayoutPage.filterSearch(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		flag = false;
		actualAlertName = null;
		size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (qname.equals(actualAlertName)) {
				Reporter.log("actualAlertName  Mathced " + actualAlertName + " expectedAlertName  " + qname,true);
				
				actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Created by").get(i)).toLowerCase();
				Reporter.log("Created by, Exp:"+page+",Actual:"+actualAlertName,true);
				String exp=username.toLowerCase();
				softAssert.assertEquals(actualAlertName, exp,"Created by not matched");
						
				flag=true;
				break outr;
				
			}
		}
		
		softAssert.assertTrue(flag,	"Please retest created by me");

		dataMap.put("Page", "Claims pending update");
		dataMap.put("Createdby","Created by anyone");
		objLayoutPage.filterSearch(dataMap);
		
		lavanteUtils.switchtoFrame(null);
		flag = false;
		actualAlertName = null;
		size = objLayoutPage.iterateSearchHeaderFindColList("Layout name").size();
		outr:for (int i = 0; i <= size - 1; i++) {
			actualAlertName = lavanteUtils.getText(objLayoutPage.iterateSearchHeaderFindColList("Layout name").get(i));

			if (!qname.equals(actualAlertName)) {
				flag=true;
				break outr;
				
			}
		}
		
		softAssert.assertTrue(flag,	"Please retest Search");
		
		objLayoutPage.jumpTaskPage(dataMap);
		
		enobjhomePage.selectTab(dataMap);

		dataMap.put("LayoutName",qname);
		objLayoutPage.changeLayout(dataMap);
		
		Reporter.log(dataMap.get("selectedValue")+",Actuals,Exp:0",true);
		softAssert.assertFalse(dataMap.get("selectedValue").length()>0,	"Layout Available for the page");
		
		softAssert.assertTrue(flag,	"Please retest the task");
		
		softAssert.assertAll();
		
		Reporter.log("Test Ended for Search at:" + currenttime());
	}
	
	@AfterMethod
	public void SetupAftermethod() {
		lavanteUtils.refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
