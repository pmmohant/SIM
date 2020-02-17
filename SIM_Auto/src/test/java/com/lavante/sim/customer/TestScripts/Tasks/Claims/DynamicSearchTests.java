package com.lavante.sim.customer.TestScripts.Tasks.Claims;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
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

public class DynamicSearchTests extends PageInitiator{
	LavanteUtils lavanteUtils = new LavanteUtils();
	String customerID = null;
	String savedSearch = null;
	String roleTypeId;
	String userRoleId;
	
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
	}
	
	@BeforeMethod
	public void before() throws FileNotFoundException, IOException, SQLException {
		roleTypeId = "select RoleTypeID from RoleType where RoleType = 'DYNAMIC_SEARCH_SHARE_SAVE_QUERY'";
		roleTypeId = lavanteUtils.fetchDBdata(roleTypeId);
		
		userRoleId = "select UserRoleID from LoginRole where UserRoleName = 'Kroger PRGX Clerk'";
		userRoleId = lavanteUtils.fetchDBdata(userRoleId);
		
		// Login
		List<?> listofdatafrm = lavanteUtils.login("KrogerPRGXClerk", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LdataMap.put("maintab", "Tasks");
		LdataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(LdataMap);
	}

	/**
	 * Test script to do Advance search in task page for single criteria
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void privateSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for privateSavedSearchTest: " + currenttime(),true);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Private");
		dataMap.put("SaveQuery", "");
		dataMap.put("SearchSaveQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		enobjhomePage.logout();

		List<?> listofdatafrm = lavanteUtils.login("KrogerPRGXClerk1", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(dataMap);
		
		if(objTasksClaimPage.SaveAccordin().isDisplayed()) {
			lavanteUtils.clicks(objTasksClaimPage.SaveAccordin());
			List<WebElement> queryList = objTasksClaimPage.SavedQNameList();
			if(queryList.size()>0) {
				for(int i=0; i<queryList.size(); i++) {
					if(queryList.get(i).getText().trim().equals(savedSearch)) {
						flag = false;
						Assert.fail("Private Saved query is displayed for other user");
					} else {
						flag = true;
						Reporter.log("Private saved query is not displayed for user",true);
						
					}
				}
			} 
		} else {
			flag = true; 
			Reporter.log("Saved queries are not there, so private query is aslo not displayed");
		}
			
		softAssert.assertTrue(flag, "Please Retest...");
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for privateSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * Test script to do Advance search in task page for public saved query
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void publicSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for publicSavedSearchTest: " + currenttime(),true);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Public-My role");
		dataMap.put("SaveQuery", "");
		dataMap.put("SearchSaveQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		enobjhomePage.logout();

		List<?> listofdatafrm = lavanteUtils.login("KrogerPRGXClerk1", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(dataMap);
		
		flag = false;
		if(objTasksClaimPage.SaveAccordin().isDisplayed()) {
			lavanteUtils.clicks(objTasksClaimPage.SaveAccordin());
			flag = true;
			List<WebElement> queryList = objTasksClaimPage.SavedQNameList();
			if(queryList.size()>0) {
				for(int i=0; i<queryList.size(); i++) {
					if(queryList.get(i).getText().trim().equals(savedSearch)) {
						lavanteUtils.click((queryList.get(i)));
						lavanteUtils.click(objTasksClaimPage.searchbtn());
						claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
						if(claimList.size()>0) {
							for(int j=0; j<claimList.size(); j++) {
								if(claimList.get(j).getText().contains(claimId)) {
									Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(j).getText());
									softAssert.assertTrue(claimList.get(j).getText().contains(claimId), "Claim ID does not contain the search criteria");
									flag = true;
									break;
								} else {
									flag = false;
									Assert.fail("Cliam ID search is not matching the criteria");
								}
								
							}
						} else {
							softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
							flag = true;
						}
					}
				}
			}
		} else {
			flag = false;
			Assert.fail("Saved queries are not listed at all in same role login");
		}
		
		softAssert.assertTrue(flag,"Please Retest for Same Login");
		
		enobjhomePage.logout();

		listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(dataMap);
		
		flag = false;
		if(objTasksClaimPage.SaveAccordin().isDisplayed()) {
			lavanteUtils.clicks(objTasksClaimPage.SaveAccordin());
			List<WebElement> queryList = objTasksClaimPage.SavedQNameList();
			if(queryList.size()>0) {
				for(int i=0; i<queryList.size(); i++) {
					if(queryList.get(i).getText().trim().equals(savedSearch)) {
						flag = false;
						Assert.fail("Saved query is displayed for other user with different role");
					} else {
						flag = true;
						Reporter.log("Query saved by one user role is not displayed for user with different role",true);
						
					}
				}
			} 
		} else {
			flag = true;
			Reporter.log("Saved queries are not listed. Hence query saved by one user role is not displayed for user with different role",true);

		}
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for publicSavedSearchTest: " + currenttime(),true);
	}

	/**
	 * Test script to do Advance search in task page with Public-All access rights
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void PublicAllSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for PublicAllSavedSearchTest: " + currenttime(),true);

		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		String deleteQuery = "delete from LoginRole_RoleType_Map where RoleTypeID= "+roleTypeId+" and UserRoleID= "+userRoleId;
		lavanteUtils.UpdateDB(deleteQuery);
		lavanteUtils.refreshPage();
		
		String insertQuery = "insert into LoginRole_RoleType_Map (RoleTypeID, UserRoleID) VALUES ("+roleTypeId+", "+userRoleId+")";
		lavanteUtils.UpdateDB(insertQuery);
		lavanteUtils.refreshPage();
		
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Public-All");
		dataMap.put("SaveQuery", "");
		dataMap.put("SearchSaveQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		enobjhomePage.logout();

		List<?> listofdatafrm = lavanteUtils.login("CustomerKrogerAdmin", browser);
		LinkedHashMap<String, String>LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(dataMap);
		
		flag = false;
		if(objTasksClaimPage.SaveAccordin().isDisplayed()) {
			lavanteUtils.clicks(objTasksClaimPage.SaveAccordin());
			flag = true;
			List<WebElement> queryList = objTasksClaimPage.SavedQNameList();
			if(queryList.size()>0) {
				for(int i=0; i<queryList.size(); i++) {
					if(queryList.get(i).getText().trim().equals(dataMap.get("SaveSearchName"))) {
						lavanteUtils.click((queryList.get(i)));
						lavanteUtils.click(objTasksClaimPage.searchbtn());
						claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
						if(claimList.size()>0) {
							for(int j=0; j<claimList.size(); j++) {
								if(claimList.get(j).getText().contains(claimId)) {
									Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(j).getText());
									softAssert.assertTrue(claimList.get(j).getText().contains(claimId), "Claim ID does not contain the search criteria");
									flag = true;
									break;
								} else {
									flag = false;
									Assert.fail("Cliam ID search is not matching the criteria");
								}
								
							}
						} else {
							softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
							flag = true;
						}
					}
				}
			}
		} else {
			flag = false;
			Assert.fail("Saved querries are not listed at all in other user login");
		}
		
		lavanteUtils.UpdateDB(deleteQuery);
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for PublicAllSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * Test script to do Advance search in task page to edit saved query
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void EditSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for EditSavedSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Public-My role");
		dataMap.put("SaveQuery", "");
		dataMap.put("SearchSaveQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		claimId = "2";
		
		dataMap.put("QueryAction","");
		dataMap.put("EditQuery", "");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("SaveQuery", "");
		dataMap.put("BannerMsg", "");
		objTasksClaimPage.SavedQueryAction(dataMap);
		
		lavanteUtils.waitForTime(3000);
		softAssert.assertEquals(dataMap.get("BannerMsg").trim(), "Query updated successfully", "Banner message not matching");
		claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results after Edit should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria after Edit");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for EditSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * Test script to do Advance search in task page to delete saved query
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void DeleteSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for DeleteSavedSearchTest: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Public-My role");
		dataMap.put("SaveQuery", "");
		dataMap.put("SearchSaveQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		dataMap.put("QueryAction","");
		dataMap.put("DeleteQuery", "");
		objTasksClaimPage.SavedQueryAction(dataMap);
		
		softAssert.assertEquals(dataMap.get("BannerMsg").trim(), "Query deleted successfully", "Banner message not matching");
		List<WebElement> saveQList = objTasksClaimPage.SavedQNameList();
		if(saveQList.size()>0) {
			for(int i=0; i<saveQList.size(); i++) {
				if(saveQList.get(i).getText().equals(savedSearch)) {
					Reporter.log("Saved query is not deleted: "+savedSearch);
					break;
				} else {
					Reporter.log("Saved query is deleted successfully: "+savedSearch);
				}
			}
			
		} else {
			Reporter.log("Saved query is deleted successfully: "+savedSearch);

		}
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for DeleteSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * Test script to do Advance search in task page to make default saved query
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void MakeDefaultSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for MakeDefaultSavedSearchTest: " + currenttime(),true);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Public-My role");
		dataMap.put("SaveQuery", "");
		dataMap.put("SearchSaveQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> saveQList = objTasksClaimPage.SavedQNameList();
		for(int j=0; j<saveQList.size(); j++) {
			if(savedSearch.equals(saveQList.get(j).getText().trim())) {
				softAssert.assertTrue(objTasksClaimPage.markDefaultIconList().get(j).isDisplayed(), "Mark default icon is not displayed");
			} else {
				Assert.fail("Saved Query is not listed.");
			}
		}
		
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		dataMap.put("QueryAction","");
		dataMap.put("MarkAsDefault", "");
		objTasksClaimPage.SavedQueryAction(dataMap);
		
		softAssert.assertEquals(dataMap.get("BannerMsg").trim(), "Marked as default successfully", "Banner message not matching");
		
		enobjhomePage.logout();
		List<?> listofdatafrm = lavanteUtils.login("KrogerPRGXClerk", browser);
		LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);

		enobjloginpage.logintoAPP(LdataMap);
		
		dataMap.put("maintab", "Tasks");
		dataMap.put("subtab", "claimTasks");
		enobjhomePage.selectTab(dataMap);
		
		claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results afetr default query is executed, should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText().trim());
				softAssert.assertTrue(claimList.get(i).getText().trim().contains(claimId), "Claim ID does not contain the search criteria as default query has not executed");
				flag = true;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		dataMap.put("MarkAsDefault", "");
		dataMap.put("BannerMsg", "");
		objTasksClaimPage.SavedQueryAction(dataMap);
		softAssert.assertEquals(dataMap.get("BannerMsg").trim(), "Unmarked successfully", "Banner message not matching");

		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for MakeDefaultSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * Test script to do Advance search in task page to run saved query
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void RunSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for RunSavedSearchTest: " + currenttime(),true);

		SoftAssert softAssert = new SoftAssert();
		Boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		dataMap.put("SaveSearchName", "Any");
		dataMap.put("AccessRights", "Public-My role");
		dataMap.put("SaveQuery", "");
		dataMap.put("QueryAction","");
		dataMap.put("RunQuery", "");
		objTasksClaimPage.advanceSearch(dataMap);
		
		savedSearch = dataMap.get("SaveSearchName");
		List<WebElement> claimList = objTasksClaimPage.iterateSearchHeaderFindColList("Claim ID");
		if(claimList.size()>0) {
			for(int i=0; i<claimList.size(); i++) {
				Reporter.log("Claim ID search results should contain- Expected: "+claimId+" Actual: "+claimList.get(i).getText());
				softAssert.assertTrue(claimList.get(i).getText().contains(claimId), "Claim ID does not contain the search criteria");
				flag = true;
				break;
			}
		} else {
			softAssert.assertEquals("No Results", objTasksClaimPage.NoData().getText());
			flag = false;
		}
		
		softAssert.assertTrue(flag,"Please Retest");
		
		softAssert.assertAll();
		Reporter.log("<---------------------Test Ended for RunSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * Test script to configure user role for public saved query
	 * 
	 * @author Vidya.C
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void ConfigureUserRoleForSavedSearchTest() throws FileNotFoundException, IOException, SQLException {
		Reporter.log("<---------------------Test Started for ConfigureUserRoleForSavedSearchTest: " + currenttime(),true);

		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		String deleteQuery = "delete from LoginRole_RoleType_Map where RoleTypeID= "+roleTypeId+" and UserRoleID= "+userRoleId;
		lavanteUtils.UpdateDB(deleteQuery);
		lavanteUtils.refreshPage();
		
		SoftAssert softassert = new SoftAssert();
		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		String claimId = "1";
		dataMap.put("Advanced", "");
		dataMap.put("SearchFields", "ClaimId");
		dataMap.put("ClaimId", "Contains#"+claimId);
		dataMap.put("Save","");
		objTasksClaimPage.advanceSearch(dataMap);
		
		lavanteUtils.click(objTasksClaimPage.accessRightsDrpdwn());
		List<WebElement> accessOptions = lavanteUtils.getOptions(objTasksClaimPage.accessRightsDrpdwn());
		String expectedData = "Private#Public-My role";
		for(int i=0; i<accessOptions.size(); i++) {
			System.out.println("List of Access options before user-role is configured: "+accessOptions.get(i).getText());
			softassert.assertTrue(expectedData.contains(accessOptions.get(i).getText().trim()), "Access options are not matching without configuration");
		}
		
		String insertQuery = "insert into LoginRole_RoleType_Map (RoleTypeID, UserRoleID) VALUES ("+roleTypeId+", "+userRoleId+")";
		lavanteUtils.UpdateDB(insertQuery);
		lavanteUtils.refreshPage();
		
		lavanteUtils.fluentwait(objTasksClaimPage.searchbtn());
		objTasksClaimPage.advanceSearch(dataMap);
		accessOptions = lavanteUtils.getOptions(objTasksClaimPage.accessRightsDrpdwn());
		expectedData = "Private#Public-My role#Public-All";
		for(int i=0; i<accessOptions.size(); i++) {
			Reporter.log("List of Access options after user-role is configured: "+accessOptions.get(i).getText());
			softassert.assertTrue(expectedData.contains(accessOptions.get(i).getText().trim()), "Access options are not matching after configuration");

		}
		
		lavanteUtils.UpdateDB(deleteQuery);
		
		softassert.assertAll();	
		Reporter.log("<---------------------Test Ended for ConfigureUserRoleForSavedSearchTest: " + currenttime(),true);
	}
	
	/**
	 * SetupAfter method closes any popup
	 * 
	 * @author subhas.bv
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@AfterMethod
	public void SetupAfterMethod() throws FileNotFoundException, IOException, SQLException {
		enobjhomePage.logout();
		String deleteSavedSearch = "delete from SavedSearch where CustomerID = "+customerID+" and QueryName = '"+savedSearch+"'";
		lavanteUtils.UpdateDB(deleteSavedSearch);
	}

	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * 
	 * @author subhas.bv
	 */
	@AfterClass
	public void SetupafterClassMethod() {
		quitBrowser();
	}
}
