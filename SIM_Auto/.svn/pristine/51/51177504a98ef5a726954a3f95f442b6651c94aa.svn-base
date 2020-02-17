package com.lavante.sim.customer.TestScripts.DataIngestion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.pageobjects.PageInitiator;

public class DataIngestionTests extends PageInitiator {

	LavanteUtils lavanteUtils = new LavanteUtils();

	/**
	 * This class all test starts using login page and driver initialization
	 * 
	 * @author Subhash.BV
	 * 
	 */

	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,
			@Optional(LavanteUtils.browser) String browser, @Optional(LavanteUtils.browserVersion) String Version)
					throws Exception {

		launchAppFromPOM(Platform, browser, Version);
		initiate();

		openQAAPP3();
		
		lavanteUtils.driver=driver;
		
		//Login
		List listofdatafrm=lavanteUtils.login("CustomerKrogerAdmin", browser);
	/*	LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		String customerID=(String) listofdatafrm.get(1);*/
		
	}


	@Test 
	public void invoiceIngestion() throws IOException, SQLException{
	
		String z=lavanteUtils.ingestion("invoice");
		lavanteUtils.replaceColumnString(z, "AutoInv002", 138, 162);
		lavanteUtils.ServerCopyFile("/home/lavante/FILEREPO/ingestion_files/kroger/raw_files",z);
		
		String x="select TRIGGER_STATE From QRTZ_TRIGGERS where TRIGGER_NAME  in ('KrogerInboundIngestionTrigger')";
		x=lavanteUtils.fetchDBdataPlatform(x);
		if(!x.contains("Blocked")){
			String query=" update QRTZ_TRIGGERS set NEXT_FIRE_TIME='1536672553045',TRIGGER_STATE='WAITING' where TRIGGER_NAME  in ('KrogerInboundIngestionTrigger')";
			lavanteUtils.UpdatePlatformDB(query);
		}
		
		
		lavanteUtils.jobWaiting("KrogerInboundIngestionTrigger","1536672553045");
		
		
		
	}
	
	//@Test 
	public void LiabinvoiceIngestion() throws IOException, SQLException{
	
		String z=lavanteUtils.ingestion("Liab");
		lavanteUtils.replaceColumnString(z, "AutoInv001", 138, 162);
		lavanteUtils.ServerCopyFile("/home/lavante/FILEREPO/ingestion_files/kroger/raw_files",z);
		
		String x="select TRIGGER_STATE From QRTZ_TRIGGERS where TRIGGER_NAME  in ('KrogerInboundIngestionTrigger')";
		x=lavanteUtils.fetchDBdataPlatform(x);
		if(!x.contains("Blocked")){
			String query=" update QRTZ_TRIGGERS set NEXT_FIRE_TIME='1536672553045',TRIGGER_STATE='WAITING' where TRIGGER_NAME  in ('KrogerInboundIngestionTrigger')";
			lavanteUtils.UpdatePlatformDB(query);
		}
		
		
	}
	
	
	@Test 
	public void nchIngestion() throws IOException, SQLException{
	
		String z=lavanteUtils.ingestion("NCH");
		String expDdnNum ="111"+lavanteUtils.currenttime().trim(); //8 Char
		lavanteUtils.replaceColumnString(z, expDdnNum, 1, 10);
		String manNum="123";
		lavanteUtils.replaceColumnString(z, manNum, 10, 19);
		String manNam="AUT"+lavanteUtils.currenttime();
 		lavanteUtils.replaceColumnString(z, manNam, 19, 54);
		String CoupInv="34343";
		lavanteUtils.replaceColumnString(z, CoupInv, 54, 63);
		String CoupInvDate="12/12/2019";
		lavanteUtils.replaceColumnString(z, CoupInvDate, 63, 73);
		String dedAmont="122019.23";
		lavanteUtils.replaceColumnString(z, dedAmont, 73, 87);
		String adjustmentCode="12";
		lavanteUtils.replaceColumnString(z, adjustmentCode, 87, 89);
		String AdDesc="Auto Adj Desc";
		lavanteUtils.replaceColumnString(z, AdDesc, 89, 139);
		String ERPP="ERP-179";
		lavanteUtils.replaceColumnString(z, ERPP, 139, 147);
		String name="RockyGuy";
		lavanteUtils.replaceColumnString(z, name, 147, 181);
		
		lavanteUtils.ServerCopyFile("/home/lavante/FILEREPO/ingestion_files/kroger/raw_files",z);
		
		String x="select TRIGGER_STATE From QRTZ_TRIGGERS where TRIGGER_NAME  in ('KrogerInboundIngestionTrigger')";
		x=lavanteUtils.fetchDBdataPlatform(x);
		if(!x.contains("Blocked")){
			String query=" update QRTZ_TRIGGERS set NEXT_FIRE_TIME='1536672553045',TRIGGER_STATE='WAITING' where TRIGGER_NAME  in ('KrogerInboundIngestionTrigger')";
			lavanteUtils.UpdatePlatformDB(query);
		}
		
		
		lavanteUtils.jobWaiting("KrogerInboundIngestionTrigger","1536672553045");
		
		String xs="select DeductionNumber From  CouponDeductionHeader where DeductionNumber='"+expDdnNum+"'";
		xs=lavanteUtils.fetchDBdata(xs);
		
		Assert.assertTrue(xs.length()>0,"DB is not returned any value"+xs);
		Reporter.log("DB Verification:Deduction Number,Actual:"+xs+",Exp:"+expDdnNum,true);
		Assert.assertEquals(xs, expDdnNum,"Ded No Not matched with DB");
		
	}
	
	

	@AfterMethod
	public void SetupAftermethod() {
	
	}

	@AfterClass
	public void SetupafterClassmethod() {

	}
}
