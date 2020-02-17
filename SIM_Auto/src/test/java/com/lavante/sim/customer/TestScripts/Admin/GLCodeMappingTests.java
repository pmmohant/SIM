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

/** issue in application, Need to discuss with Geetha ***/
public class GLCodeMappingTests extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
	String div ="";
	String glcode = "";
	String customerID ="";
	String CustdivID ="";
	
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
		
	 launchAppFromPOM(Platform,browser,Version);
	 initiate();	
	 openAPP();
	 waitForTime(4000);
	 lavanteUtils.driver=driver;
	 
	 objLoginPage.verifyLoginPageDisplayed();
	 List<?> listofdatafrm=lavanteUtils.login("Kroger", browser);
	 LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
	 LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
	 customerID=(String) listofdatafrm.get(1);
	 enobjloginpage.logintoAPP(LdataMap);
	 waitForTime(3000);
	 objHomePage.verifyHomePageDisplayed();
	 
	}
	
	@BeforeMethod
	public void before() throws FileNotFoundException, IOException, SQLException{
		LinkedHashMap<String, String> dataMap = new LinkedHashMap<String, String>();
		dataMap.put("maintab", "Admin");
		dataMap.put("subtab", "glCodeMapping");
		enobjhomePage.selectTab(dataMap);
		
		
	/*	String x= "select MAX(CustomerORganizationID) from Division_GLCode_Map where CustomerOrganizationID in "
				+ "( Select CustomerOrganizationID from CustomerOrganization where CustomerOrganizationNumber is not null and TOConsider=1)";
		CustdivID =lavanteUtils.fetchDBdata(x);*/

		/*glcode="select MAX(GLCodeID) from Division_GLCode_Map where CustomerOrganizationID= "+CustdivID+"";
		
		glcode =lavanteUtils.fetchDBdata(glcode);
		
		glcode = "select Code from GLCode where GLCODEID="+glcode+"";
		
		glcode =lavanteUtils.fetchDBdata(glcode);
		
		div = "select CustomerOrganizationNumber from CustomerOrganization where CustomerOrganizationID="+CustdivID+"";
		
		 div =lavanteUtils.fetchDBdata(div);*/
		
		 div= "select MAX(cd.DivisionAliasName) from CustomerOrganizationDivisionCategoryMAp cd,CustomerOrganization c where  "
		 		+ " cd.divisionID=c.CustomerOrganizationID and c.CustomerID="+customerID+" and cd.DivisionCategory_KVID=18301";
		 div =lavanteUtils.fetchDBdata(div);
		 
		 CustdivID= "select MAX(c.CustomerOrganizationID) from CustomerOrganizationDivisionCategoryMAp cd,CustomerOrganization c where  "
			 		+ " cd.divisionID=c.CustomerOrganizationID and c.CustomerID="+customerID+" and cd.DivisionCategory_KVID=18301 and cd.DivisionAliasNAme='"+div+"'";
		 CustdivID =lavanteUtils.fetchDBdata(CustdivID);
		 
	/*	x= "select MAX(CustomerORganizationID) from Division_GLCode_Map where CustomerOrganizationID in "
					+ "( Select CustomerOrganizationID from CustomerOrganization where CustomerOrganizationNumber is not null and TOConsider=1)";
		CustdivID =lavanteUtils.fetchDBdata(x);*/

	}

	/** 
	 * @author Priyanka
	 * 
	 * Test to verify addition and edit of GL code mapping 
	 * 
	 */
	@Test
	public void addEditGLCodeMapping ()throws Exception{
		
		Reporter.log("Test Started for AddEditGLCodeMapping: "+ currenttime(),true);
	    SoftAssert softassert =new SoftAssert();
	    
		
		glcode = "select MAX(Code) from GLCode where GLCODEID not in ("
				+ "select GLCodeID from Division_GLCode_Map where CustomerOrganizationID= '"+CustdivID+"')";
		
		glcode =lavanteUtils.fetchDBdata(glcode);
		
		dataMap.put("Save", "");
		dataMap.put("Division",div);
		dataMap.put("GLCode", glcode);
		
		glcodemapping.addGLCodeMapping(dataMap);
		
		// Search for GL code
		dataMap.put("SearchValue",glcode);
		glcodemapping.searchGLCode(dataMap);
		
		//verifying gl code mapping
		
		boolean flagadd = false;
		boolean flagedit = false;
		
		String actualGLCodeMapping,actualDivision;
		int noRecords = glcodemapping.ListGLCodeName.size();
		outer: for (int i = 0; i <noRecords ; i++) {
			actualGLCodeMapping = glcodemapping.ListGLCodeName.get(i).getText();
			actualDivision = glcodemapping.ListDivisionName.get(i).getText();
			
			Reporter.log("GLCode Mapping created " + actualGLCodeMapping + " Expected GLCode name " + dataMap.get("GLCode"),true);
			Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);

			if (actualGLCodeMapping.equals(glcode) && actualDivision.contains(div)) {
				flagadd = true;
				Reporter.log("GLCode Mapping created " + actualGLCodeMapping + " Expected GLCode name  " + dataMap.get("GLCode"),true);
				Reporter.log("Division name created " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
				
				// Edit a GLCode Mapping 
				String anotherGl="select MAX(Code) from GLCode where Code not in ('"+glcode+"') and "
						+ "  GLCODEID not in ("
				+ "select GLCodeID from Division_GLCode_Map where CustomerOrganizationID= '"+CustdivID+"') ";
				
				anotherGl =lavanteUtils.fetchDBdata(anotherGl);
				
				click(glcodemapping.ListEditGLCodeMapping.get(i));
				
				dataMap.put("Save", "");
				dataMap.remove("Division");
				dataMap.put("GLCode", anotherGl);
				glcodemapping.fillGLCodeMapping(dataMap);
				glcodemapping.formAction(dataMap);
				
				dataMap.put("SearchValue",anotherGl);
				glcodemapping.searchGLCode(dataMap);
				
				//verifying Edit GLCode mapping
				String glCodemap=anotherGl;
				String division1=div;
				Reporter.log("GLCode Mapping edited " + actualGLCodeMapping + " Expected GLCode Mapping name " + anotherGl,true);
				Reporter.log("Division name edited " + actualDivision + " Expected Division name " + division1,true);

				noRecords = glcodemapping.ListGLCodeName.size();
				for ( i = 0; i < noRecords; i++) {
					actualGLCodeMapping = glcodemapping.ListGLCodeName.get(i).getText();
					actualDivision = glcodemapping.ListDivisionName.get(i).getText();
					
					if (actualGLCodeMapping.equals(glCodemap) && actualDivision.contains(division1)) {
						flagedit = true;
						Reporter.log("GLCode Mapping edited " + actualGLCodeMapping + " Expected GLCode Mapping name " + dataMap.get("GLCode"),true);
						Reporter.log("Division name edited " + actualDivision + " Expected Division name " + dataMap.get("Division"),true);
						glcode=glCodemap;
						break outer;
				
					}
				}
			}
		}
		
		softassert.assertTrue(flagadd, "GLCodeMapping created doesn't match");
		softassert.assertTrue(flagedit, "GLCodeMapping edited doesn't match");
		softassert.assertAll();
		Reporter.log("Test Ended at:" + currenttime());
	}
	
	/** 
	 * @author Priyanka
	 * 
	 * Test to verify addition and delete of GL code mapping 
	 * 
	 */
	@Test
	public void addDeleteGLCodeMapping ()throws Exception{
		
		Reporter.log("Test Started for AddDeleteGLCodeMapping: "+ currenttime(),true);
	    SoftAssert softassert =new SoftAssert();
	    
	   glcode = "select MAX(Code) from GLCode where GLCODEID not in ("
			+ "select GLCodeID from Division_GLCode_Map where CustomerOrganizationID= '"+CustdivID+"')";
		
		glcode =lavanteUtils.fetchDBdata(glcode);
		dataMap.put("Save", "");
		dataMap.put("Division", div);
		dataMap.put("GLCode", glcode);
		glcodemapping.addGLCodeMapping(dataMap);
		
		// Search for GL code
		dataMap.put("SearchValue",glcode);
		glcodemapping.searchGLCode(dataMap);
		
		String actGLCodeMapping = glcodemapping.GLCodeValueinTable().getText().trim();
		softassert.assertEquals(actGLCodeMapping, glcode,"Actual GLCodeMapping" + actGLCodeMapping+ " is not matching with expected GLCodeMapping "+ glcode);
		Reporter.log("Verification : expected glcode "+ glcode + "with actual GLCodeMapping" +actGLCodeMapping,true);
		
		//Delete GLCode
		click(glcodemapping.DeleteGLCodeMapping());
		click(glcodemapping.deleteConfirmButton());
		waitForTime(5000);
		

		// Search for Deleted GLCode
		dataMap.put("SearchValue",glcode);
		glcodemapping.searchGLCode(dataMap);
		
		fluentwait(glcodemapping.noResultsText());
		String actdata = glcodemapping.noResultsText().getAttribute("innerText");
		String expdata = "No results";
		softassert.assertEquals(actdata,  expdata, "expected data " +expdata + "is not matching with actual data " +actdata);
		Reporter.log("Verification : expected data "+ expdata + "with actual data" +actdata);
	
		softassert.assertAll();
		Reporter.log("Test Ended for deletion of GLCodeMapping and deltion of GLCodeMapping :" + currenttime(),true);

	}
	
	 /** 
	 * @author Priyanka
	 * 
	 * Test to verify duplicate of GLCodeMapping
	 * 
	 */
  @Test
   public void duplicateGLCodeMapping(){
	  
	  Reporter.log("Test Started for duplicate of GLCodeMapping: "+ currenttime(),true);
	  SoftAssert softassert =new SoftAssert();
	  boolean flagDuplicate=false;
	  
	  String glmap = glcodemapping.ListGLCodeName.get(0).getText();
	  String div= glcodemapping.ListDivisionName.get(0).getText();
	
	   	dataMap.put("Save", "");
		dataMap.put("Division", div);
		dataMap.put("GLCode", glmap);
		glcodemapping.addGLCodeMapping(dataMap);
		
		if(glcodemapping.Errormsg().isDisplayed()){
			  String exp = "Mappings already exists";
			  String actual= glcodemapping.Errormsg().getText().trim();
			  softassert.assertTrue(actual.contains(exp),"Error Msg Not matched".trim());
			  Reporter.log("Error message:"+exp+",Actual:"+actual, true);
			  flagDuplicate=true;
		  }
		  
		  softassert.assertTrue(flagDuplicate);
		  softassert.assertAll();
		  
	  }
	
	 /** 
	 * @author Priyanka
	 * 
	 * Test to verify associate of GLCodeMapping
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void associateGLCodeMapping() throws FileNotFoundException, IOException, SQLException {

		Reporter.log("Test Started for associate of GLCodeMapping: "+ currenttime(), true);
		SoftAssert softassert = new SoftAssert();
		boolean dataflag = false;
		
		
		int noRecords = glcodemapping.ListGLCodeName.size();
		outer: for (int i = 0; i <noRecords ; i++) {
			String GLCodeMapping = glcodemapping.ListGLCodeName.get(i).getText();
		
		    click(glcodemapping.ListEditGLCodeMapping.get(i));
		    
		    if(glcodemapping.bannerMsg().isDisplayed()){
		    String exp = "GLCode Mapping can not be edited as it is associated with claim"; 
		    String actual = glcodemapping.bannerMsg().getText().trim();
		    
		    softassert.assertTrue(actual.contains(exp),"Error Msg Not matched".trim());
			  Reporter.log("Error message:"+exp+",Actual:"+actual, true);
			  dataflag=true;
		  }
		  
		  softassert.assertTrue(dataflag);
		  softassert.assertAll();
		  
	  }
	}
	
	 /** 
		 * @author Priyanka
		 * 
		 * Test to verify interrelated of GLCodeMapping
		 *
		 * 
		 */
		@Test
		public void interrelatedGLCodeMapping() {
			
			Reporter.log("Test Started for interrelatedGLCodeMapping: "+ currenttime());
			SoftAssert softAssert = new SoftAssert();
			LinkedHashMap<String, String> dataMap=new LinkedHashMap<String, String> ();
			boolean flagAdd = false;
			boolean flag= false;
			
			
		}
		   
		    
		
		

	@AfterMethod
	public void SetupAftermethod() throws FileNotFoundException, IOException, SQLException {
		lavanteUtils.refreshPage();
		
		if(glcode.length()>0){
			  String x="delete from Division_GLCode_Map where GLcodeID=(select GLcodeID from GLCode where Code = '"+glcode+"'and CustomerID ='"+customerID+"')";
			  lavanteUtils.UpdateDB(x);
			  
		  }
	}
	
	@AfterClass
	public void quitApp() {
		enobjhomePage.logout();
		quitBrowser();
	}
 
}
