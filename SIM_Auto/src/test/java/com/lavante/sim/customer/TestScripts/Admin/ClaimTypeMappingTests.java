package com.lavante.sim.customer.TestScripts.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class ClaimTypeMappingTests extends PageInitiator {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	
	String div="";
	String claimtype="";
	String division1="";
	String CustomerID="";
	String division="";
	
	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Priyanka
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();
		openAPP1();
		// Assigning the driver to the object of lavante utils
		lavanteUtils.driver = driver;

		// Login
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		CustomerID=(String) listofdatafrm.get(1);
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		

	}
	
	@BeforeMethod()
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException{
		lavanteUtils.refreshPage();
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap.put("maintab","Admin");
		LdataMap.put("subtab","claimTypeMapping");
		enobjhomePage.selectTab(LdataMap);
		lavanteUtils.waitForTime(3000);
		
		div=" select MAX(cd.DivisionAliasName) from CustomerOrganizationDivisionCategoryMap  cd, CustomerOrganization c "
				+ " where cd.divisionID=c.CustomerOrganizationID and c.customerId = "+CustomerID+" and	cd.divisionCategory_KVID = 18301 and c.isActive = 1";
		div=lavanteUtils.fetchDBdata(div);
		
		division1=" select MAX(cd.DivisionAliasName) from CustomerOrganizationDivisionCategoryMap  cd, CustomerOrganization c "
				+ " where cd.divisionID=c.CustomerOrganizationID and c.customerId = "+CustomerID+" and	cd.divisionCategory_KVID = 18301 and c.isActive = 1"
						+ " and  cd.DivisionAliasName not in ('"+div+"') ";
		division1=lavanteUtils.fetchDBdata(division1);
		
		claimtype="select MAX(ClaimType) from ClaimType where  ClaimtypeID not in (select ClaimtypeID from Claim) and isActive=1 and CustomerID="+CustomerID  ;
		claimtype=lavanteUtils.fetchDBdata(claimtype);
		
		division="'"+div+"','"+division1+"'";
		deleteQuery(division);
	}
		
	private void deleteQuery(String div) throws FileNotFoundException, IOException, SQLException{
		String query="delete  from Division_ClaimType_Map where ClaimTypeID in (select ClaimtypeID From ClaimType "
				+ "where ClaimType_I18nKey in (select i18nKey from UserTranslation where UTFString like '%"+claimtype+"%') )"
						+ "  and CustomerOrganizationID in (Select CustomerOrganizationID from CustomerOrganization "
						+ "where OrganizationName in ("+div+"))";
		lavanteUtils.UpdateDB(query);
	}
		
	/**
	 * MangeUsers- Add claim type mapping
	 * 
	 * @author priyanka
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	@Test
	public void addEditClaimtypeMapping() throws Exception {
		Reporter.log("Test Started for addNewClaimTypeMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		dataMap.put("Save", "");
		dataMap.put("Division", div);
		dataMap.put("ClaimType", claimtype);
		//adding claim type mapping
		objClaimTypeMapPage.addClaimTypeMapping(dataMap);
		
		//searching newly added claim type mapping
		dataMap.put("SearchText",claimtype);
		objClaimTypeMapPage.searchClaimtypeMapping(dataMap);
		
		boolean flagAdd = false;
		boolean flagEdit = false; 
		String actualClaimtype ="";
		String actualDivision = "";
		int noRecords =0;
		
		int k=0;
		while(flagAdd==false&& k<50){
			noRecords = objClaimTypeMapPage.ListDivisionName.size();
			lavanteUtils.waitForTime(5000);		
			outr: for (int i = 0; i <noRecords ; i++) {
				actualClaimtype = objClaimTypeMapPage.ListClaimType.get(i).getText();
				actualDivision = objClaimTypeMapPage.ListDivisionName.get(i).getText();
				// verifying added claim type mapping 
				if (actualClaimtype.equals(claimtype) && actualDivision.contains(div)) {
					flagAdd = true;
					Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
					Reporter.log("Claim type created " + actualClaimtype  + " Expected Claim type name " + dataMap.get("ClaimType"),true);
					
					//edit claim type mapping
					click(objClaimTypeMapPage.ListEditClaimTypeMapping.get(i));
					
					dataMap.clear();
					dataMap.put("Division", "Deselect All");
					objClaimTypeMapPage.fillClaimtypeMapping(dataMap);
					
					dataMap.put("Save", "");
					dataMap.put("Division", division1);
					objClaimTypeMapPage.fillClaimtypeMapping(dataMap);
					objClaimTypeMapPage.formAction(dataMap);
					
					lavanteUtils.waitForTime(5000);
					
					dataMap.put("SearchText",actualClaimtype);
					objClaimTypeMapPage.searchClaimtypeMapping(dataMap);
					
					//verify edit
					int ek=0;
					while(flagEdit==false&& ek<50){
					for ( i = 0; i < noRecords; i++) {
							actualClaimtype = objClaimTypeMapPage.ListClaimType.get(i).getText();
							actualDivision = objClaimTypeMapPage.ListDivisionName.get(i).getText();
							if (actualClaimtype.equals(claimtype) && actualDivision.contains(division1)) {
								Reporter.log("Claim type name edited " + actualClaimtype + " Expected claim type name " + claimtype,true);
								Reporter.log("Division name edited " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
								flagEdit = true;
								break outr;
							}
					}
					if(flagEdit==false){
						ek++;
						boolean flag=enobjhomePage.Pagination("Next");
						if(flag==false){
							ek=50001;
						}
					}
					
					}
				}
			}
			
			if(flagAdd==false){
					k++;
					boolean flag=enobjhomePage.Pagination("Next");
					if(flag==false){
						k=50001;
					}
			}
			
		}
				
		softAssert.assertTrue(flagAdd, "Claim type name created doesn't match");
		softAssert.assertTrue(flagEdit, "Claim type name edited doesn't match");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
		
	@Test
	public void addDeleteClaimTypeMapping() throws Exception {
		Reporter.log("Test Started for addDeleteClaimTypeMapping: " + currenttime(),true);
		
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		dataMap.put("Save", "");
		dataMap.put("Division", div);
		dataMap.put("ClaimType", claimtype);
		//adding claim type mapping
		objClaimTypeMapPage.addClaimTypeMapping(dataMap);
		
		boolean flagAdd = false;
		boolean flagDelete = false;
		dataMap.put("SearchText",claimtype);
		objClaimTypeMapPage.searchClaimtypeMapping(dataMap);
		lavanteUtils.waitForTime(3000);
		
		String actualClaimtype ="";
		String actualDivision = "";
		int	k=0;
		while(flagAdd==false&&k<50){
		lavanteUtils.waitForTime(5000);
			int noRecords = objClaimTypeMapPage.ListDivisionName.size();
			outr: for (int i = 0; i <noRecords ; i++) {
			
				actualClaimtype = objClaimTypeMapPage.ListClaimType.get(i).getText();
				actualDivision = objClaimTypeMapPage.ListDivisionName.get(i).getText();
				// verifying 
				if (actualClaimtype.equals(claimtype) && actualDivision.contains(div)) {
					flagAdd = true;
					Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
					Reporter.log("Claim type created " + actualClaimtype  + " Expected Claim type name " + dataMap.get("ClaimType"),true);
					
					//Delete Claim Type mapping
					lavanteUtils.fluentwait(objClaimTypeMapPage.DeleteLink());
					lavanteUtils.click(objClaimTypeMapPage.ListDeleteClaimTypeMapping.get(i));
					lavanteUtils.click(objClaimTypeMapPage.deleteBtn());
					lavanteUtils.waitForTime(3000);
					flagDelete=true;
					noRecords = objClaimTypeMapPage.ListDivisionName.size();
					for(int j=0; j<noRecords; j++) {
						actualDivision = objClaimTypeMapPage.ListDivisionName.get(j).getText().trim();
						Reporter.log("After deletion, Reslt should be no results,Actual:"+actualDivision);
						softAssert.assertEquals(actualDivision, "No Results","After deleteion not matched");
						flagDelete = true;
						break outr;
					}
				}
					
			}
			
			if(flagAdd==false){
			k++;
			boolean flag=enobjhomePage.Pagination("Next");
			if(flag==false){
				k=50001;
				}
			}
		}
		softAssert.assertTrue(flagAdd, "Claim type division mapping doesn't match");
		softAssert.assertTrue(flagDelete, "Claim type division mapping dose n't deleted");
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
		
	@Test
	public void duplicateClaimtypeMapping() throws Exception {
		Reporter.log("Test Started for duplicateClaimtypeMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		
		objClaimTypeMapPage.searchClaimtypeMapping(dataMap);
		
		String claimtype = objClaimTypeMapPage.ListClaimType.get(0).getText();
		String div = objClaimTypeMapPage.ListDivisionName.get(0).getText();
		
		dataMap.put("Save", "");
		dataMap.put("Division", div);
		dataMap.put("ClaimType", claimtype);
		//adding claim type mapping
		objClaimTypeMapPage.addClaimTypeMapping(dataMap);
		
		lavanteUtils.switchtoFrame(objClaimTypeMapPage.IframeAddClaimTypeMapping());
		
		boolean flag = false;
			if(objClaimTypeMapPage.Errormsg().isDisplayed()){
				softAssert.assertTrue(objClaimTypeMapPage.Errormsg().getText().contains("Mappings already Exists"),"Error Msg Not matched");
				Reporter.log("Error message:"+objClaimTypeMapPage.Errormsg().getText(),true);
				flag = true;
			}
			
			softAssert.assertTrue(flag, "Error message");
			softAssert.assertAll();
			Reporter.log("Test Ended at:" + currenttime());
	}
		
	@Test
	public void associatedClaimtypeMapping() throws Exception {
		Reporter.log("Test Started for associatedClaimtypeMapping: " + currenttime());
		SoftAssert softAssert = new SoftAssert();
		
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
		lavanteUtils.waitForTime(3000);
			
		 String xx="select MAX(ct.ClaimType) from CustomerOrganization Co, Payment p, Claim c , ClaimType ct "
				+ " where Co.CustomerOrganizationID = p.CustomerOrganizationID and p.PaymentID = c.PaymentID "
				+ " and ct.ClaimtypeID = c.ClaimTypeID and c.CustomerID="+CustomerID+" and c.IsActive=1";
		xx=lavanteUtils.fetchDBdata(xx);
		 String yy="select MAX(Co.OrganizationName) from CustomerOrganization Co, Payment p, Claim c , ClaimType ct "
					+ " where Co.CustomerOrganizationID = p.CustomerOrganizationID and p.PaymentID = c.PaymentID "
					+ " and ct.ClaimtypeID = c.ClaimTypeID and c.CustomerID="+CustomerID+" and c.IsActive=1";
			yy=lavanteUtils.fetchDBdata(yy);
		
		Reporter.log("Fetched Claim Type From DB for Search:"+xx,true);
		dataMap.put("SearchText",yy);
		objClaimTypeMapPage.searchClaimtypeMapping(dataMap);
		
		boolean flag = false;
		boolean flagAdd=false;
		
		
		int i=0;
		int k=0;
		while(flagAdd==false&& k<50){
		int noRecords = objClaimTypeMapPage.ListDivisionName.size();
		if(noRecords>0){
			outr:for( i=0;i<noRecords;i++){
				String actualClaimtype = objClaimTypeMapPage.ListClaimType.get(i).getText();
				String actualDivision = objClaimTypeMapPage.ListDivisionName.get(i).getText();
				// verifying added claim type mapping 
				if (actualClaimtype.equalsIgnoreCase(xx) && actualDivision.contains(yy)) {
					click(objClaimTypeMapPage.ListEditClaimTypeMapping.get(0));
					lavanteUtils.waitForTime(4000);
					if(objClaimTypeMapPage.BannerMessage().isDisplayed()){
						String err=objClaimTypeMapPage.BannerMessage().getText();
						Reporter.log("Edit Error message:"+err,true);
						String exp="Mapping can not be edited as it is already associated with claim";
						softAssert.assertEquals(err, exp,"Error msg for edit not matched");
						flag = true;flagAdd=true;
						}
						break outr;
					}
			
			}
			if(flagAdd==false){
				k++;
				boolean flags=enobjhomePage.Pagination("Next");
				if(flags==false){
					k=50001;
				}
			}
		}
	}
		Assert.assertTrue(flag, "Edit Error message");
		
		flag = false;
		if(objClaimTypeMapPage.ListDeleteClaimTypeMapping.size()>0){
			click(objClaimTypeMapPage.ListDeleteClaimTypeMapping.get(i));
			lavanteUtils.click(objClaimTypeMapPage.deleteBtn());
			lavanteUtils.waitForTime(3000);
			if(objClaimTypeMapPage.BannerMessage().isDisplayed()){
				String err=objClaimTypeMapPage.BannerMessage().getText();
				String exp="Mapping can not be deleted as it is already associated with claim";
				softAssert.assertEquals(err, exp,"Error msg for delete not matched");
				Reporter.log("Delete Error message:"+err,true);
				flag = true;
			}
		}
		softAssert.assertTrue(flag, "Delete Error message");
		
		softAssert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	@AfterClass
	public void quitApp() {

		enobjhomePage.logout();
		quitBrowser();
	}
}

		
	
		
