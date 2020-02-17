package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
 * Created on 23-02-2017
 * Created for Diversity And Agency Exclusion 
 * Enhancement covered SIM -9958
 * Ended on 27-02-2017
 * @author Piramanayagam.S
 *
 */
public class CertificateDiversity02 extends PageInitiator {
	
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	String customerID="";
	String suppname="";
	
	/**
	 * This class all test starts using login page and driver intilization
	 * @author Piramanayagam.S
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@BeforeClass
	@Parameters({ "Platform", "Browser", "Version" })
	public void navigateToLoginPage(@Optional(LavanteUtils.Platform) String Platform,@Optional(LavanteUtils.browser) String browser,
			@Optional(LavanteUtils.browserVersion) String Version) throws Exception{
			
		launchAppFromPOM(Platform,browser,Version);
		initiate();
		openAPP();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		List listofdatafrm=lavanteUtils.login("Diversity", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		suppname=LdataMap.get("supname");
		customerID=(String) listofdatafrm.get(1);
		
		//Login
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		lavanteUtils.switchtoFrame(null);
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		enobjhomePage.selectTab(dataMap);
		
		dataMap.put("Search", "");
		dataMap.put("InactiveSup", "");
		dataMap.put("supplierName",suppname );
		enobjsupplierBasicSearch.search(dataMap);	
		
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
		
	}
	
	@BeforeMethod
	public void SetupBeforemethod() throws Exception{
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
	}

	/**SIM-9958
	 *  *Exclude Agency and Diversity for Minorty business
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void ExcludeAgencyDiversityMinorityBusiness() throws Exception{	
		System.out.println("------------Test Started for Minority Business Exclude Agency-------------------");
		Reporter.log("Test Started for Minority Business Exclude Agency- :"+currenttime());
		SoftAssert softassert=new SoftAssert();

		boolean flag=false;
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		int kvid=3102;
		String delquery="delete from CustomerDiversityCertificationAgencyExclusion";
		lavanteUtils.UpdateDB(delquery);
		delquery="delete from DiversityType_CertificationAgency_Map";
		lavanteUtils.UpdateDB(delquery);
		delquery="delete from CustomerDiversityTypeExclusion";
		lavanteUtils.UpdateDB(delquery);
		

		//101 for others so excluded  and 3102 for Minority business
		String diversityTypeID="select MAX(DiversityTypeID) from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID not in (101)";
		diversityTypeID=lavanteUtils.fetchDBdata(diversityTypeID);
		
		String AgencyID="select MAX(AgencyID) from DiversityCertificationAgency  where Classification_KVID="+kvid+" and AgencyID not in (101)";
		AgencyID=lavanteUtils.fetchDBdata(AgencyID);
		
		String query="insert into CustomerDiversityCertificationAgencyExclusion (   CustomerID  ,DiversityCertificationAgencyID) VALUES ("+customerID+"  ,"+AgencyID+")";
		lavanteUtils.UpdateDB(query);
		
		query="Insert into DiversityType_CertificationAgency_Map  ( DiversityTypeID  ,AgencyID  ) VALUES ( "+diversityTypeID+"  ,"+AgencyID+")";
		lavanteUtils.UpdateDB(query);
		
		query="select DiversityType from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID  in ("+diversityTypeID+") ";
		String diversityQuery=lavanteUtils.fetchDBdata(query);
		
		String Agencyquery="select AgencyName from DiversityCertificationAgency  where  AgencyID="+AgencyID+"  ";
		Agencyquery=lavanteUtils.fetchDBdata(Agencyquery);
		
		System.out.println("DB Config:Diversity Type:"+diversityQuery+",Mapped with Agency :"+Agencyquery+",And Same got Excluded");
		Reporter.log("DB Config:Diversity Type:"+diversityQuery+",Mapped with Agency :"+Agencyquery+",And Same got Excluded");
		
		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		
		dataMap.put("addMinority", "");
		dataMap.put("BusinessType", diversityQuery);
		dataMap.put("Agency", Agencyquery);
		
		eneditCertification.fillMinorityBusiness(dataMap);
		
		List<String> s=lavanteUtils.listelement(null);
		outr:for(int i=0;i<s.size();i++){
			System.out.println("Application : Diversity Type:"+diversityQuery+",Agency Dropdown Value Not Expected :"+Agencyquery+",Available are:"+s.get(i));
			Reporter.log("Application : Diversity Type:"+diversityQuery+",Agency Dropdown Value Not Expected :"+Agencyquery+",Available are:"+s.get(i));
			if(s.get(i).equalsIgnoreCase(Agencyquery)){
				flag=false;
				break outr;
			}
			if(i==s.size()-1){
				flag=true;
			}
		}
		
		softassert.assertTrue(flag,"Removed Agency Found");
		flag=false;
		enobjhomePage.popupclose();
		dataMap.clear();
		
		diversityTypeID="select MAX(DiversityTypeID) from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID not in ("+diversityTypeID+",101)";
		diversityTypeID=lavanteUtils.fetchDBdata(diversityTypeID);
		
		query="insert into CustomerDiversityTypeExclusion (   CustomerID  ,DiversityTypeID) VALUES ( "+customerID+"   ,"+diversityTypeID+" )";
		lavanteUtils.UpdateDB(query);
		
		query="select DiversityType from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID in ("+diversityTypeID+") ";
		diversityQuery=lavanteUtils.fetchDBdata(query);
		
		System.out.println("DB Config:Diversity Type:,"+diversityQuery+",got Excluded");
		Reporter.log("DB Config:Diversity Type:,"+diversityQuery+",got Excluded");
		
		dataMap.put("addMinority", "");
		dataMap.put("BusinessType", diversityQuery);
		
		eneditCertification.fillMinorityBusiness(dataMap);
		
		s=lavanteUtils.listelement(null);
		outr:for(int i=0;i<s.size();i++){
			System.out.println("Application : Diversity Type:"+diversityQuery+",Diversity Dropdown Value Not Expected :"+diversityQuery+",Available are:"+s.get(i));
			Reporter.log("Application : Diversity Type:"+diversityQuery+",Diversity Dropdown Value Not Expected :"+diversityQuery+",Available are:"+s.get(i));
			if(s.get(i).equalsIgnoreCase(diversityQuery)){
				flag=false;
				break outr;
			}
			if(i==s.size()-1){
				flag=true;
			}
		}
		
		softassert.assertTrue(flag,"Removed Diversity Type Found");

		if(flag==false){
			softassert.assertTrue(false,"Please Retest and RECHECK");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for Minority business Exclude Agency:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**SIM-9958
	 *Exclude Agency and Diversity for Small business
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void ExcludeAgencyDiversitySmallBusiness() throws Exception{	
		System.out.println("------------Test Started for Small Business Exclude Agency-------------------");
		Reporter.log("Test Started for Small Business Exclude Agency- :"+currenttime());
		SoftAssert softassert=new SoftAssert();

		boolean flag=false;
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		int kvid=3101;
		String delquery="delete from CustomerDiversityCertificationAgencyExclusion";
		lavanteUtils.UpdateDB(delquery);
		 delquery="delete from DiversityType_CertificationAgency_Map";
		 lavanteUtils.UpdateDB(delquery);
		 delquery="delete from CustomerDiversityTypeExclusion";
		 lavanteUtils.UpdateDB(delquery);
		

		//101 for others so excluded  and 3102 for Minority business
		String diversityTypeID="select MAX(DiversityTypeID) from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID not in (100)";
		diversityTypeID=lavanteUtils.fetchDBdata(diversityTypeID);
		
		String agencyID="select MAX(AgencyID) from DiversityCertificationAgency  where Classification_KVID="+kvid+" and AgencyID not in (100)";
		agencyID=lavanteUtils.fetchDBdata(agencyID);
		
		String query="insert into CustomerDiversityCertificationAgencyExclusion (   CustomerID  ,DiversityCertificationAgencyID) VALUES ("+customerID+"  ,"+agencyID+")";
		lavanteUtils.UpdateDB(query);
		
		
		String Agencyquery="select AgencyName from DiversityCertificationAgency  where Classification_KVID="+kvid+" and AgencyID="+agencyID+"  and AgencyID not in (100) ";
		Agencyquery=lavanteUtils.fetchDBdata(Agencyquery);
		
		query="Insert into DiversityType_CertificationAgency_Map  ( DiversityTypeID  ,AgencyID  ) VALUES (   "+diversityTypeID+"  ,"+agencyID+")";
		lavanteUtils.UpdateDB(query);
	
		query="select DiversityType from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID  in ("+diversityTypeID+") ";
		String diversityQuery=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		
		
		
		dataMap.put("addSmallBusiness", "");
		dataMap.put("BusinessType", diversityQuery);
		dataMap.put("Agency", Agencyquery);
		
		eneditCertification.fillSmallBusiness(dataMap);
		
		List<String> s=lavanteUtils.listelement(null);
		outr:for(int i=0;i<s.size();i++){
			System.out.println(s.get(i)+Agencyquery);
			if(s.get(i).equalsIgnoreCase(Agencyquery)){
				flag=false;
				break outr;
			}
			if(i==s.size()-1){
				flag=true;
			}
		}
		
		softassert.assertTrue(flag,"Removed Agency Found");
		flag=false;
		enobjhomePage.popupclose();
		dataMap.clear();
		
		diversityTypeID="select MAX(DiversityTypeID) from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID not in ("+diversityTypeID+",100)";
		diversityTypeID=lavanteUtils.fetchDBdata(diversityTypeID);
		
		query="insert into CustomerDiversityTypeExclusion (   CustomerID  ,DiversityTypeID) VALUES ( "+customerID+"   ,"+diversityTypeID+" )";
		lavanteUtils.UpdateDB(query);
		
		query="select DiversityType from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID in ("+diversityTypeID+") ";
		diversityQuery=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("addSmallBusiness", "");
		dataMap.put("BusinessType", diversityQuery);
		
		eneditCertification.fillSmallBusiness(dataMap);
		
		s=lavanteUtils.listelement(null);
		outr:for(int i=0;i<s.size();i++){
			System.out.println(s.get(i)+diversityQuery);
			if(s.get(i).equalsIgnoreCase(diversityQuery)){
				flag=false;
				break outr;
			}
			if(i==s.size()-1){
				flag=true;
			}
		}
		
		softassert.assertTrue(flag,"Removed Diversity Type Found");
		
		
		if(flag==false){
			softassert.assertTrue(false,"Please Retest and RECHECK");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for Small Business Exclude Agency in Edit Profile at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**SIM-9958
	 * Include Small business and Agency 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void IncludeAgencyDiversityMinorityBusiness() throws Exception{	
		System.out.println("------------Test Started for Minority Business Include Agency-------------------");
		Reporter.log("Test Started for Minority Business Include Agency- :"+currenttime());
		SoftAssert softassert=new SoftAssert();

		boolean flag=false;
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		int kvid=3102;
		String delquery="delete from CustomerDiversityCertificationAgencyExclusion";
		lavanteUtils.UpdateDB(delquery);
		 delquery="delete from DiversityType_CertificationAgency_Map";
		 lavanteUtils.UpdateDB(delquery);
		 delquery="delete from CustomerDiversityTypeExclusion";
		 lavanteUtils.UpdateDB(delquery);
		

		//101 for others so excluded  and 3102 for Minority business
		String diversityTypeID="select MAX(DiversityTypeID) from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID not in (101)";
		diversityTypeID=lavanteUtils.fetchDBdata(diversityTypeID);
		
		String AgencyID="select MAX(AgencyID) from DiversityCertificationAgency  where Classification_KVID="+kvid+" and AgencyID not in (101)";
		AgencyID=lavanteUtils.fetchDBdata(AgencyID);
		
		String query="Insert into DiversityType_CertificationAgency_Map  ( DiversityTypeID  ,AgencyID  ) VALUES (   "+diversityTypeID+"  ,"+AgencyID+")";
		lavanteUtils.UpdateDB(query);
		
		String Agencyquery="select AgencyName from DiversityCertificationAgency  where AgencyID in ("+AgencyID+") ";
		Agencyquery=lavanteUtils.fetchDBdata(Agencyquery);
		
		query="select DiversityType from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID  in ("+diversityTypeID+") ";
		String diversityQuery=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		
		
		dataMap.put("addMinority", "");
		dataMap.put("BusinessType", diversityQuery);
	//	dataMap.put("Agency", Agencyquery);
		
		eneditCertification.fillMinorityBusiness(dataMap);
		
		lavanteUtils.switchtoFrame(eneditCertification.IFRAMEAddMinority());
		lavanteUtils.click(eneditCertification.Agency());
		
		List<String> s=lavanteUtils.listelement(null);
		for(int i=0;i<s.size();i++){
			System.out.println(s.get(i)+Agencyquery);
			if(s.get(i).equalsIgnoreCase(Agencyquery)){
				flag=true;
				break ;
			}
		}
		
		softassert.assertTrue(flag,"Added Agency not Found");
		flag=false;
		
		lavanteUtils.switchtoFrame(eneditCertification.IFRAMEAddMinority());
		lavanteUtils.click(eneditCertification.BusinessType());
		
		s=lavanteUtils.listelement(null);
		for(int i=0;i<s.size();i++){
			System.out.println(s.get(i)+diversityQuery);
			if(s.get(i).equalsIgnoreCase(diversityQuery)){
				flag=true;
				break;
			}
		}
		
		softassert.assertTrue(flag,"Added Diversity Type Not Found");
		
		softassert.assertAll();
		Reporter.log("Test Ended for Include Minoirty Business Agency diversity in Edit Profile at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}

	/**SIM-9958
	 * Include SmallBusiness business and agency
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * @throws SQLException 
	 */
	@Test
	public void IncludeAgencyDiversitySmallBusiness() throws Exception{	
		Reporter.log("Test Started for Small Business Include Agency- :"+currenttime());
		SoftAssert softassert=new SoftAssert();

		boolean flag=false;
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		int kvid=3101;
		String delquery="delete from CustomerDiversityCertificationAgencyExclusion";
		lavanteUtils.UpdateDB(delquery);
		 delquery="delete from DiversityType_CertificationAgency_Map";
		 lavanteUtils.UpdateDB(delquery);
		 delquery="delete from CustomerDiversityTypeExclusion";
		 lavanteUtils.UpdateDB(delquery);
		

		//101 for others so excluded  and 3102 for Minority business
		String diversityTypeID="select MAX(DiversityTypeID) from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID not in (100)";
		diversityTypeID=lavanteUtils.fetchDBdata(diversityTypeID);
		
		String query="select MAX(AgencyID) from DiversityCertificationAgency  where Classification_KVID="+kvid+" and AgencyID not in (100)";
		query=lavanteUtils.fetchDBdata(query);
		
		String Agencyquery="select AgencyName from DiversityCertificationAgency  where  AgencyID="+query+"  ";
		Agencyquery=lavanteUtils.fetchDBdata(Agencyquery);
		
		query="Insert into DiversityType_CertificationAgency_Map  ( DiversityTypeID  ,AgencyID  ) VALUES (   "+diversityTypeID+"  ,"+query+")";
		lavanteUtils.UpdateDB(query);
		
		query="select DiversityType from DiversityType where DiversityClassificationKVID="+kvid+" and DiversityTypeID  in ("+diversityTypeID+") ";
		String diversityQuery=lavanteUtils.fetchDBdata(query);
		
		dataMap.put("tab", "Certification");
		eneditProfile.selectTab(dataMap);
		
		
		dataMap.put("addSmallBusiness", "");
		dataMap.put("BusinessType", diversityQuery);
		//	dataMap.put("Agency", Agencyquery);
		
		eneditCertification.fillSmallBusiness(dataMap);
		lavanteUtils.switchtoFrame(eneditCertification.IFRAMESmallBusiness());
		lavanteUtils.click(eneditCertification.Agency());
		
		List<String> s=lavanteUtils.listelement(null);
		outr:for(int i=0;i<s.size();i++){
			System.out.println(s.get(i)+Agencyquery);
			if(s.get(i).equalsIgnoreCase(Agencyquery)){
				flag=true;
				break outr;
			}
		}
		
		softassert.assertTrue(flag,"Added Agency Not Found");
		flag=false;
		
		lavanteUtils.switchtoFrame(eneditCertification.IFRAMESmallBusiness());
		lavanteUtils.click(eneditCertification.BusinessType());
		
		s=lavanteUtils.listelement(null);
		outr:for(int i=0;i<s.size();i++){
			if(s.get(i).equalsIgnoreCase(diversityQuery)){
				flag=true;
				break outr;
			}
		}
		
		softassert.assertTrue(flag,"Added Diversity Type Not Found");

		softassert.assertAll();
		Reporter.log("Test Ended for Small Business Inclusion in Edit Profile at:"+currenttime());
		System.out.println("----------Test Ended----------------");

	}
	
	@AfterMethod
	public void Setupaftermethod(){
		refreshPage();
	}

	@AfterClass
	public void SetupafterClassmethod(){
		enobjhomePage.logout();
		quitBrowser();
	}


}

