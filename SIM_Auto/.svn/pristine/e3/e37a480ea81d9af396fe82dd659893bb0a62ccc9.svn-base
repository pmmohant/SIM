package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

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
 * 
 * ESignReset test - > 24-07-2018 Created
 * Ended on 25-07-2018
 * 
 * @author Piramanayagam.S
 *
 */
public class ESignReset extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();
	String custid = "";
	String pwd="";

	/**
	 * This class all test starts using login page and driver intilization
	 * 
	 * @author Piramanayagam.S
	 * @throws IOException
	 * @throws FileNotFoundException
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
		List<?> listofdatafrm = lavanteUtils.login("Certificate", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		custid = (String) listofdatafrm.get(1);
		pwd=LdataMap.get("password");

		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		

	}

	@BeforeMethod
	public void SetupBeforemethod() throws Exception {

		lavanteUtils.switchtoFrame(null);
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Supplier");
		enobjhomePage.selectTab(dataMap);

		dataMap.put("Search", "");
		dataMap.put("ProfStatus", "Approved");
		enobjsupplierBasicSearch.search(dataMap);

		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		String sup=enobjsupplierPage.supplierSelectionandProfileAction(dataMap);

		Reporter.log("Selected Supplier:"+sup);
		dataMap.put("tab","supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
	}

	/**
	 * Change Something in Enterprise tab - Should not reset
	 * Change Customer Specific should Reset the E-signature
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	@Test
	public void EsignReset() throws Exception {
		Reporter.log("Test Started for EsignReset in Edit Profile at :" + currenttime());
		SoftAssert softassert = new SoftAssert();
		boolean flag = false;
		LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String>();
		
		String orgx="Update CustomerMetadata set IsMandatoryField=1,IsVisibleField=1 where  ProfileMetadataID in  "
				+ "( select ProfileMetadataID From ProfileMEtadata where UIFieldID='productsServicesPerformed')"
				+ "and CustomerID="+custid;
		lavanteUtils.UpdateDB(orgx);
		
		orgx="update customer Set IsESignatureReset=1 where CustomerID="+custid;
		lavanteUtils.UpdateDB(orgx);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		for(int i=0;i<eneditProfile.todolist().size();i++){
			String x=eneditProfile.todolist().get(i).getText().trim();
			if(x.contains("Validate Signature")){
				flag=true;
				break;
			}
		}
		
		dataMap.put("password",pwd);
		dataMap.put("Esign","YES");
		
		if(flag){
			dataMap.put("tab","supplierRelationshipInfo");
			eneditProfile.selectTab(dataMap);
			eneditCustomerProfile.Esign(dataMap);
			flag=false;
		}

		dataMap.put("tab","supplierRelationshipEnterpriseInfo");
		eneditProfile.selectTab(dataMap);
		
		lavanteUtils.fluentwait(eneditEnterprise.supplierAliasName());
		eneditEnterprise.supplierAliasName().clear();
		lavanteUtils.typeinEdit("Rick"+randomnum(9), eneditEnterprise.supplierAliasName());
		
		dataMap.put("Save", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		for(int i=0;i<eneditProfile.todolist().size();i++){
			String x=eneditProfile.todolist().get(i).getText().trim();
			if(x.contains("Validate Signature")){
				flag=true;
				break;
			}
		}
		
		Reporter.log("Changing in Enterprise Profile Should  Reset TO DO,Exp: False,Actual:"+flag);
		softassert.assertFalse(flag, "Changing in Enterprise Profile Should not Reset TO DO");
		
		dataMap.put("tab","supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		
		dataMap.put("Product","SoftWare"+randomnum(9));
		eneditCustomerProfile.ProductServices(dataMap);
		
		dataMap.put("Previous", "");
		eneditProfile.formAction(dataMap);
		
		lavanteUtils.switchtoFrame(eneditProfile.iframe_todo());
		flag=false;
		for(int i=0;i<eneditProfile.todolist().size();i++){
			String x=eneditProfile.todolist().get(i).getText().trim();
			if(x.contains("Validate eSignature")){
				flag=true;
				break;
			}
		}
			
		softassert.assertTrue(flag, "Changing in Customer Specific should reset todo,Exp: True,Actual:"+flag);

		softassert.assertAll();
		Reporter.log("Test Ended for EsignReset in Edit Profile at:" + currenttime());

	}

	@AfterMethod
	public void aftermethod() throws FileNotFoundException, IOException, SQLException {
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("tab","supplierRelationshipInfo");
		eneditProfile.selectTab(dataMap);
		
		dataMap.put("password",pwd);
		dataMap.put("Esign","YES");
		eneditCustomerProfile.Esign(dataMap);
		
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
	}

	@AfterClass
	public void SetupafterClassmethod() {
		enobjhomePage.logout();
		quitBrowser();
	}

}
