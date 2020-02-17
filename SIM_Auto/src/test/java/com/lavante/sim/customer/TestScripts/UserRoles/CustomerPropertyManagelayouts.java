package com.lavante.sim.customer.TestScripts.UserRoles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class CustomerPropertyManagelayouts extends PageInitiator {
	
	LavanteUtils lavanteUtils = new LavanteUtils();
	String Uname = "";
	String customerID = "";
	LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();

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
	public void BeforeMethod() throws FileNotFoundException, IOException, SQLException {
		List<?> listofdatafrm = lavanteUtils.login("Kroger", browser);
		LinkedHashMap<String, String> LdataMap = new LinkedHashMap<String, String>();
		LdataMap = (LinkedHashMap<String, String>) listofdatafrm.get(0);
		customerID = (String) listofdatafrm.get(1);
		Uname = LdataMap.get("username");
		// Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		String delete = "Delete from CustomerPropertyValue where CustomerPropertyID in (select CustomerPropertyID from CustomerProperty where PropertyName='LAYOUTS_COLUMNS_MAXCOUNT') and CustomerID="
				+ customerID + " ";
		lavanteUtils.UpdateDB(delete);

		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("username", "Transactions");
		dataMap.put("subtab", "customerClaimResult");
		enobjhomePage.selectTab(dataMap);
	}
	
	/**
	 * @author Priyanka.Mohanty
	 * 
	 * Manage Layouts Page
	 * 
	 *  Validate Customer Property
	 *  LAYOUTS_COLUMNS_MAXCOUNT
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 *
	 */
	
	@Test
	
	public void manageLayoutColMaxCountTest() throws FileNotFoundException, IOException, SQLException{
		
		Reporter.log("Test Started for manageLayoutColMaxCountTest  :" + currenttime());

		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
		
		String y ="select CustomerPropertyID from CustomerProperty where PropertyName = 'LAYOUTS_COLUMNS_MAXCOUNT'";
		
		 y=lavanteUtils.fetchDBdata(y);
		
		String insert = "insert into CustomerPropertyValue (CustomerPropertyID,CustomerID,IsActive) VALUES ("+y+","+customerID+",1)";

		lavanteUtils.UpdateDB(insert);
		
		
		
		
		
	}
	
	
}
