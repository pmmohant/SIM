package com.lavante.sim.customer.TestScripts.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.LoginDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 24-08-2016
 * Created for UAT TC
 * Ended on 28-08-2016
 * @author Nandini.R
 * 
 * Created on 29-03-2017
 * Created for Login TC
 * Ended on 31-03-2017
 * @author Piramanayagam.S
 *
 */
public class UATlogin extends PageInitiator{
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
				
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		lavanteUtils.driver=driver;
	
	}
	
	@BeforeMethod
	public void beforeLogin() throws FileNotFoundException, IOException{
		openAPP();
	}

	/**
	 * Maximumn Login Attempt ==> Based on the No of Attempt Verify the error msg  

	 * @author Nandini.R 
	 */
	@Test
	public void Maximumloginattempts() throws Exception{
		
		Reporter.log("Test Started for Maxmimum Login attempt:"+currenttime());
		//MAx Fail Attempt
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		List<?> listofdatafrm=lavanteUtils.login("Maxfailedattempt", browser);
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		String uname="select MAX(C.Email) from Login L ,Contact C where IsLocked = 0 and FailedLoginAttempt=0 and L.ContactID=C.ContactID and UserRoleID <14";
		uname=fetchDBdata(uname);
		String query="select PropertyValue from ApplicationProperties where PropertyName like 'Max%'";
		String result=lavanteUtils.fetchDBdata(query);	
		result=""+2;
		String updateQuery=" update [Login] SET   IsLocked = '0'  WHERE  "
				+ " ContactID in ( select ContactID from Contact where Email like '"+uname+"')";
		String updateQuery1=" update [Login] SET   FailedLoginAttempt=0  WHERE  "
				+ " ContactID in ( select ContactID from Contact where Email like '"+uname+"')";
	//	lavanteUtils.UpdateDB(updateQuery);
	//	lavanteUtils.UpdateDB(updateQuery1);
		int r=Integer.parseInt(result);
		
		for(int i=0;i<r;i++){
			//Login		
			LdataMap.put("username",uname);
			LdataMap.put("password",randomnum());
			LdataMap.put("errormsg","");
			
			enobjloginpage.logintoAPP(LdataMap);
			String exptext="There are too many incorrect attempts, please try after some time.";
			String acttext=enobjloginpage.MAXerrormsg().getText();
			Assert.assertNotSame(acttext,exptext,"Login Attempt Failed before the attempt,Exp:"+exptext+",Actual:"+acttext);
		
		}
		
		lavanteUtils.refreshPage();
		
		LdataMap.put("password",LdataMap.get("password"));
		enobjloginpage.logintoAPP(LdataMap);
		String exptext="You have exceeded the number of permissible limits, your account has been temporarily locked.";
		 exptext="There are too many incorrect attempts, please try after some time.";
		String acttext=enobjloginpage.MAXerrormsg().getText();
		lavanteUtils.UpdateDB(updateQuery);
		lavanteUtils.UpdateDB(updateQuery1);
		Reporter.log("Error Message for max attempt,Expected:"+exptext+",Actuals:"+acttext,true);
		Assert.assertTrue(acttext.equalsIgnoreCase(exptext),"Error Message for max attempt,Expected:"+exptext+",Actuals:"+acttext);

		Reporter.log("Test Ended for Maxmimum Login attempt and UI Verify:"+currenttime());
	
	}

	/**
	 * UI Verify ==> of All the Link
	 *
	 *Replacement of  LoginTC0001 and LoginTC0002
	 * @author Piramanayagam.S ==>UI Verify
	 */
	@Test
	public void LinkVerify() throws Exception{
		
		Reporter.log("Test Started for Link Verify:"+currenttime());
		SoftAssert softAssert=new SoftAssert();
		
		//Verify the UI control for Recovery Link
		lavanteUtils.verifyElementDisplayed("RecoveryLink",enobjloginpage.RecoveryLink);
		Reporter.log("	Verified 'Looking for Lavante Recovery?' link on Login page ",true);
		objRecoveryPage.validateRecoveryLnk();
		openAPP();
		
		lavanteUtils.verifyElementDisplayed("NotRegisteredLink",enobjloginpage.NotRegisteredLink);
		Reporter.log("	Verified 'Not Registered' link on Login page ",true);
		objNotRegisteredPage.validateNotRegisteredLnk();
		openAPP();
		
		//Verify the UI control for Forgot Password Link
		lavanteUtils.verifyElementDisplayed("ForgotPasswordLink",enobjloginpage.ForgotPasswordLink);
		Reporter.log("	Verified 'Forgot Password' link on Login page ",true);
		objForgotPasswordPage.validateForgotPasswdLnk();
		openAPP();

		//Verify the UI control for Mcafee Link
		lavanteUtils.verifyElementDisplayed("McAfeeLink",enobjloginpage.McAfeeLink);
		Reporter.log("	Verified 'McAfee' link on Login page",true);
		objMcafeePage.validateMcafeeLnk();
		openAPP();
		
		lavanteUtils.verifyElementDisplayed("CopyRights",enobjloginpage.CopyRights);
		String strTextValue=lavanteUtils.getText(enobjloginpage.CopyRights);
		String expText="© Copyright PRGX/Lavante";
		softAssert.assertEquals(strTextValue,expText,"Copy Right Text Not Matched");
		Reporter.log("	Verified Copyrights text link on Login page as actual:'"+strTextValue+",Expected:,"+expText );

		//Verify the UI control for DigiCert Link
		lavanteUtils.verifyElementDisplayed("DigiCertLink",enobjloginpage.DigiCertLink);
		objDigCertPage.validateDigiCertLnk();
		Reporter.log("	Verified 'DigiCert trusted' link on Login page",true);
		Reporter.log("Verification of the UI controls on Login page is Successful: ",true);
		
	}
	
	/**
	 * Expired login ==>Fetch the expired login details and correct pwd and tries to login-->Verify the error msg
	 * 
	 * Replacement of LoginTC0005
	 * 
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void ExpiredLogin() throws FileNotFoundException, IOException, SQLException{
		String xdbquery="select MAX(c.email) from login l, contact c  where l.lastreset < getUTCdate()-90 and l.contactid = c.contactid and l.isactive = 1";
	
		String dbquery=lavanteUtils.fetchDBdata(xdbquery);
		if(dbquery==null){
			dbquery=" 	update  Login set lastreset= getUTCdate()-90  where LoginID in ( select MAX(LoginID) from Login	where "
					+ " ContactID in (Select ContactID from Contact ) and isActive=1  and  LastLoginDate < getUTCdate() ) ";
			lavanteUtils.UpdateDB(dbquery);	
			dbquery=lavanteUtils.fetchDBdata(xdbquery);
		}
		Assert.assertTrue(dbquery!=null,"DB Dont have data for expired login");
		
		//To Set PWD lavante123 in db for the above email id.
		String pwd=InitProperties("password");
		/*String updatepwd="UPDATE [Login]   SET EncryptedPassword='Csfqito1TIySInLbV4l8I4S35Hk=', PasswordSalt='Fqw9lCV8E8o=' "
				+ " where ContactID in ( select ContactID from Contact where Email='"+dbquery+"')";

		lavanteUtils.UpdateDB(updatepwd);
		pwd="lavante123";	
		;*/
		//Login		
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<>();
		LdataMap.put("username",dbquery);
		LdataMap.put("password",pwd);
		enobjloginpage.logintoAPP(LdataMap);
		lavanteUtils.fluentwait(enobjloginpage.expiredText);
		String actExp=enobjloginpage.expiredText.getText();
		lavanteUtils.waitForTime(4000);
		String expMsg = "Please create a new password as your current password has expired";

		Reporter.log("Expired Message for the user :"+dbquery+",Exp:"+expMsg+",Actuals:"+actExp,true);
		Assert.assertEquals(expMsg, actExp,"Expired Message Not matched");
	
	}
	
	/**
	 * Deactivated Test- Fetch the deactivated supplier login and Login-->Verify the Error Msg
	 * 
	 * Replacement of LoginTC0006
	 * 
	 * @author Piramanayagam.S
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	@Test
	public void DeactivatedLogin() throws FileNotFoundException, IOException, SQLException{
		
		String dbquery="select MAX(c.Email) From [Login] l ,Contact c where  l.ChallengeAnswer is not null and l.IsActive=1 "
				+ " and l.ContactID = c.ContactID and l.LastReset>getdate()-90 and c.ContactID in ( select ContactID from Contact where ContactID in "
				+ " ( select ContactID from Supplier_Contact_Map where LavanteUID in ("
				+ " select r.LavanteUID From Relationship r,Supplier s,Invite i  where s.LavanteUID=r.LavanteUID and r.RelationshipID=i.RelationshipID and I.ProfileStageID=10) ) )   ";
		
		dbquery =lavanteUtils.fetchDBdata(dbquery);
		if(dbquery!=null){
		//To Set PWD lavante123 in db for the above email id.
		String pwd=InitProperties("password");
		/*"UPDATE [Login]   SET EncryptedPassword='Csfqito1TIySInLbV4l8I4S35Hk=', PasswordSalt='Fqw9lCV8E8o=' "
				+ " where ContactID in ( select ContactID from Contact where Email='"+dbquery+"')";

		lavanteUtils.UpdateDB(pwd);
		LdataMap.put("password","lavante123");
		 */		
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<>();
		LdataMap.put("username",dbquery);
		LdataMap.put("password",pwd);
		LdataMap.put("errormsg","");
		enobjloginpage.logintoAPP(LdataMap);
		lavanteUtils.waitForTime(4000);
		lavanteUtils.fluentwait(enobjloginpage.errormsg());
		String actExp=enobjloginpage.errormsg().getText();
		
		String expMsg ="Your account has been deactivated. Please contact Lavante support or your customer for more information.";
		expMsg="Invalid User credentials or User has been deactivated.";
		Reporter.log("Deactivated Message for the user :"+dbquery+",Exp:"+expMsg+",Actuals:"+actExp,true);
		Assert.assertEquals(expMsg, actExp,"Deactivated Message Not matched");
		}else{
			Assert.assertTrue(false,"No Login Email Avaialble,Please Add Testdata and Retest");
		}
		
	}
	
	/**
	 * Login Error Verificaiton -Mandatoryness check-->Verify error msg
	 * 
	 * Replacement of LoginTC0003_0004
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 * @throws Exception
	 */
	@Test(dataProvider="LoginValidation",dataProviderClass=LoginDataProvider.class)
	public void LoginValidateErrorMsg(LinkedHashMap<String,String> dataMap) throws Exception{
		Reporter.log("Test Started for Error Msg at:"+currenttime());
		boolean flag=false;
		
		enobjloginpage.logintoAPP(dataMap);
		
		lavanteUtils.waitForTime(4000);
		if(dataMap.containsKey("errormsg")){
			String actExp="";
			actExp=enobjloginpage.errormsg().getText();
			String expMsg =dataMap.get("errormsg");
			System.out.println("Error Msg Verification for the datamap:"+dataMap+",Error Msg:"+expMsg+",Actuals:"+actExp);
			Reporter.log("Error Msg Verification for the datamap:"+dataMap+",Error Msg:"+expMsg+",Actuals:"+actExp);
			Assert.assertEquals(expMsg, actExp,"Error Msg Verification for the datamap:"+dataMap+",Error Msg:"+expMsg+",Actuals:"+actExp);
			flag=true;
		}else{
			lavanteUtils.fluentwait(enobjhomePage.UserName());
			Assert.assertTrue(lavanteUtils.isElementDisplayed(enobjhomePage.UserName()),"UserName Not avaialble on home page: for the creds"+dataMap);
			enobjhomePage.logout();
			flag=true;
		}
		if(flag==false){
			Assert.assertTrue(false,"Please Recheck");
		}
		
		Reporter.log("Test Ended for Error Msg at:"+currenttime());
	}
	
	/**
	 * SetupAfter Class closes any popup and Closes the Browser and Driver
	 * @author Piramanayagam.S
	 */
	@AfterClass
	public void SetupafterClassmethod(){
		quitBrowser();
		
	}
	
}
