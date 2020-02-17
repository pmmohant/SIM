package com.lavante.sim.customer.TestScripts.Admin;

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
 * Created for creation of GL code and deletion of GL code
 * 
 * @author Ramya
 *
 */

public class GLCodeTC0001 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
	String GLCODE="";
	
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
		dataMap.put("subtab", "claimGlCodes");
		enobjhomePage.selectTab(dataMap);
	}
	
	/** 
	 * @author Ramya
	 * 
	 * Test to verify addition and deletion of gl code
	 * 
	 */
	  @Test
	  public void AddDeleteGLCode(){
		    Reporter.log("Test Started for creation of GL code and deletion of GL code: "+ currenttime(),true);
		    SoftAssert softassert =new SoftAssert();
					   
			//Adding GL code
			String expGlCode = "AutoTest1"+randomnum();
			dataMap.put("AddGLCode", "");
			dataMap.put("GLCode", expGlCode);
			dataMap.put("Status", "Active");
			dataMap.put("SaveIcon", "");
			glcode.createGLCode(dataMap);
			
			//FOR DB DELETE aFter MEthod
			GLCODE=expGlCode;
			
			waitForTime(4000);
			//Searching the GL Code
			dataMap.put("SearchValue", expGlCode); 
		    glcode.searchGLCode(dataMap);
		    
			//Verifying created GL code availability in GL Code table
			
			String actGLCodeV = glcode.glcodeTableValue().getAttribute("innerText").trim();
			softassert.assertEquals(actGLCodeV,  expGlCode,"Actual GL code" + actGLCodeV+ " is not matching with expected GL Code "+ expGlCode);
			Reporter.log("Verification : expected glcode "+ expGlCode + "with actual GL Code" +actGLCodeV);
			
			//Deletion of GL code
			click(glcode.GlCodeDelete());
			click(glcode.deleteConfirmButton());
			waitForTime(5000);
			
			waitForTime(4000);
			fluentwait(glcode.searchbutton());
			//Searching the GL Code
			dataMap.put("SearchValue", expGlCode); 
		    glcode.searchGLCode(dataMap);
		    			
			//Verifying deleted GL code availability in GL Code table
			fluentwait(glcode.noResultsText());
			String actdata = glcode.noResultsText().getAttribute("innerText");
			String expdata = "No results";
			softassert.assertEquals(actdata,  expdata, "expected data " +expdata + "is not matching with actual data " +actdata);
			Reporter.log("Verification : expected data "+ expdata + "with actual data" +actdata);
			softassert.assertAll();
			Reporter.log("Test Ended for creation of GL code and deltion of GL code :" + currenttime(),true);
	  }
	  
	  /** 
		 * @author Ramya
		 * 
		 * Test to verify message while creation of duplicate GL code
		 * 
		 */
	  @Test
	  public void VerifyDuplicateMessageGLCode(){
		    Reporter.log("Test Started for verification of duplicate message while creating GL code: "+ currenttime(),true);
		    SoftAssert softassert =new SoftAssert();
		  	String expGlCode = "AutoTest1"+randomnum();
			//Adding GL code
		  	dataMap.put("AddGLCode", "");
			dataMap.put("GLCode", expGlCode);
			dataMap.put("Status", "Active");
			dataMap.put("SaveIcon", "");
			glcode.createGLCode(dataMap);
			
			//For Deleting on DB
			GLCODE=expGlCode;
			
			waitForTime(4000);
			//Searching the GL Code
			dataMap.put("SearchValue", expGlCode); 
		    glcode.searchGLCode(dataMap);
		    
			//Verifying created GL code availability in GL Code table
			lavanteUtils.fluentwait(glcode.searchbutton());
			String actGLCodeV = glcode.glcodeTableValue().getAttribute("innerText").trim();
			softassert.assertEquals(actGLCodeV,  expGlCode,"expected gl code "+expGlCode + " is not matching with " +actGLCodeV);
			Reporter.log("Verification : expected glcode "+ expGlCode + "with actual GL Code" +actGLCodeV);
			
			//Creating duplicate GL Code and verifying error message
			glcode.createGLCode(dataMap);
			
			String expMessage = "GL Code already exists";
			String actMessage = glcode.Message().getText();
			softassert.assertEquals(actMessage, expMessage,"GL Code expected error message :"+expMessage+"is not matching with actual message " +actMessage);
			Reporter.log("Verification : expected message  "+ expMessage + "with actual message" +actMessage);
			
			softassert.assertAll();
			Reporter.log("Test Ended for checking error message for duplicate GL code:" + currenttime(),true);
	  }
	  
	  /** 
		 * @author Ramya
		 * 
		 * Test to verify message while deletion of GL code associated with a claim
		 */
	  @Test
	  public void VerifyGLCodeClaimsMessage() throws FileNotFoundException, IOException, SQLException{
		    Reporter.log("Test Started for verifying message while deltion of GL code associated with a claim: "+ currenttime(),true);
		  	SoftAssert softassert =new SoftAssert();
			waitForTime(4000);
			//Searching the GL Code
			String expGLCode = "";
			expGLCode  = "select code from GLCode where GLCodeID in(select top 1 GLCodeID from GLCodeSettlementAmount)";
      		expGLCode = lavanteUtils.fetchDBdata(expGLCode);
			dataMap.put("SearchValue",expGLCode );
		    glcode.searchGLCode(dataMap);
		    
		    waitForTime(5000);
		    //Deletion of GL code
		    fluentwait(glcode.searchbutton());
			click(glcode.GlCodeDelete());
			click(glcode.deleteConfirmButton());
			waitForTime(5000);
			
			//Verifying message while deletion of GL code
			fluentwait(glcode.Message());
			String actdata = glcode.Message().getAttribute("innerText");
			String expdata = "Selected GL Code cannot be deleted as it is associated with a claim";
			softassert.assertEquals(actdata,  expdata,"actual data" +actdata + "is not matching with expected data " +expdata);
			Reporter.log("Verification : expected data "+ expdata + "with actual data" +actdata);
			softassert.assertAll();
			Reporter.log("Test Ended for verfying message while deletion of GL code associated with claims"+ currenttime(),true);
		}
	  
	  /** 
		 * @author Ramya
		 * 
		 * Test to verify addition and editing GL code
		 * 
		 */
	  @Test
	  public void AddEditGLCode(){
		    Reporter.log("Test Started for creation of GL code and editing GL code: "+ currenttime(),true);
		  	SoftAssert softassert =new SoftAssert();
			
		  	//Adding GL Code
			String expGlCode = "AutoTest1"+randomnum();
			dataMap.put("AddGLCode", "");
			dataMap.put("GLCode", expGlCode);
			dataMap.put("Status", "Active");
			dataMap.put("SaveIcon", "");
			glcode.createGLCode(dataMap);
			
			//For Deleting on DB
			GLCODE=expGlCode;
			
			waitForTime(4000);
			//Searching the GL Code
			dataMap.put("SearchValue", expGlCode); 
		    glcode.searchGLCode(dataMap);
		    
			//Verifying created GL code availability in GL Code table
		    fluentwait(glcode.searchbutton());
			String actGLCodeV = glcode.glcodeTableValue().getAttribute("innerText").trim();
			softassert.assertEquals(actGLCodeV,  expGlCode,"actual gl code "+actGLCodeV + "is not matching with expected gl code " +expGlCode);
			Reporter.log("Verification : expected glcode "+ expGlCode + "with actual GL Code" +actGLCodeV);
			
			//Editing GL code
			expGlCode = "AutoTest2"+randomnum();
			click(glcode.editGlcode());
			dataMap.put("GLCode", expGlCode);
			glcode.createGLCode(dataMap);
			waitForTime(7000);
			
			//Searching the edited GL Code
	
			dataMap.put("SearchValue", expGlCode); 
		    glcode.searchGLCode(dataMap);
		    
			//For Deleting on DB
			GLCODE=expGlCode;
			
			//Verifying edited GL code availability in GL Code table
			actGLCodeV = glcode.glcodeTableValue().getAttribute("innerText").trim();
			softassert.assertEquals(actGLCodeV,  expGlCode, "actual gl code "+ actGLCodeV +"is not matching with expected gl code " +expGlCode);
			Reporter.log("Verification : expected glcode "+ expGlCode + "with actual GL Code" +actGLCodeV);
			softassert.assertAll();
			Reporter.log("Test Ended for creation of GL code and editing GL code :" + currenttime(),true);
	    }
	  
	  /** 
		 * @author Ramya
		 * 
		 * Test to verify creation of GL code and verifying in GL code mapping
		 * 
		 */
	  @Test
	  public void VerifyGLCodeinGlcodeMapping(){
		    Reporter.log("Test Started for creation of GL code and verification in GL code mapping : "+ currenttime(),true);
		  	SoftAssert softassert =new SoftAssert();
			String expGlCode = "AutoTest1"+randomnum();
			dataMap.put("AddGLCode", "");
			dataMap.put("GLCode", expGlCode);
			dataMap.put("Status", "Active");
			dataMap.put("SaveIcon", "");
			glcode.createGLCode(dataMap);
					
			//For Deleting on DB
			GLCODE=expGlCode;
			fluentwait(glcode.searchbutton());
			//Verifying created Gl code availabilty in Gl code mapping page
			dataMap.put("maintab", "Admin");
			dataMap.put("subtab", "glCodeMapping");
			enobjhomePage.selectTab(dataMap);
			
			dataMap.put("AddGLCodeMapping", "");
			dataMap.put("Division", "Select Division");
			dataMap.put("GLCode", expGlCode);
			glcodemapping.addGLCodeMapping(dataMap);
			
			waitForTime(3000);
			String actglcode = glcodemapping.GLCodeValueDropdown().getAttribute("innerText");
			softassert.assertEquals(actglcode, expGlCode,"actual gl code "+actglcode+ "is not matching with expected gl code "+expGlCode);
			Reporter.log("Verification : expected glcode "+ expGlCode + "with actual GL Code" +actglcode);
			softassert.assertAll();
			Reporter.log("Test Ended for GL code creation and verifying in GL code mapping :" + currenttime(),true);
	  }
	  
	  /**
	   * AfterMethod - Delete the GL Code from the dB
	   * @throws FileNotFoundException
	   * @throws IOException
	   * @throws SQLException
	   */
	  @AfterMethod
	  public void afterMethod() throws FileNotFoundException, IOException, SQLException{
		  if(GLCODE.length()>0){
			  String x="delete From GLCode where Code='"+GLCODE+"'";
			  lavanteUtils.UpdateDB(x);
			  GLCODE="";
		  }
		  lavanteUtils.refreshPage();
	  }
	  
	  @AfterClass
	  public void close(){
		    enobjhomePage.logout();
			quitBrowser();
		}
  
}
