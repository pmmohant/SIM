package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;
import com.lavante.sim.customer.UtilFunction.DataProvider.Supplier.CMDataProvider;
import com.lavante.sim.customer.pageobjects.PageInitiator;

/**
 * Created on 16-12-2015
 * Created for Deliverable Test case
 * Enhancement covered 
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class CMdelTC003 extends PageInitiator {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	LinkedHashMap<String, String> loginDataMap=new LinkedHashMap<String, String>();
	
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
		openAPP();	
		//Assigning the driver to the object of lavante utils		
		lavanteUtils.driver=driver;
		
		//Login
		List listofdatafrm=lavanteUtils.login("DEL-1", browser);
		LinkedHashMap<String, String> LdataMap=new LinkedHashMap<String, String>();
		LdataMap=(LinkedHashMap<String, String>) listofdatafrm.get(0);
		String customerID=(String) listofdatafrm.get(1);
		
		
		String sname="select MAX(su.SupplierName) from Deliverable d,StatementOfWork s, Relationship R,Supplier su,MasterServiceAgreement m "
				+ " where s.MSAID=m.MSAID and r.RelationShipID=m.RelationShipID and r.LavanteUID=su.LavanteUID and d.SowID=s.SowID "
				+ " and r.CustomerID="+customerID;
		sname=lavanteUtils.fetchDBdata(sname);
		
		//Login		
		enobjloginpage.logintoAPP(LdataMap);
		enobjhomePage.close();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String, String>();
		dataMap.put("maintab","Supplier");
		dataMap.put("profile", "");
		dataMap.put("editProfile", "");
		
		
		dataMap.put("Search", "");
		dataMap.put("supplierName", sname);
		
		enobjhomePage.selectTab(dataMap);
		enobjsupplierBasicSearch.search(dataMap);		
		enobjsupplierPage.supplierSelectionandProfileAction(dataMap);
	
		dataMap.put("tab", "enterpriseContract");
		eneditProfile.selectTab(dataMap);
		lavanteUtils.waitForTime(3000);

	
	}
	

	
	/**
	 * Status Field should not be available
		In Page	
			Add  deliverable,
			Edit  deliverable,
			Copy  deliverable,
			View  deliverable,
			
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 * 
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void StatusField001(LinkedHashMap<String,String> dataMap) throws Exception{	
	Reporter.log("Test Started for Status Field in ALL Deliverable:"+LavanteUtils.currenttime());
	dataMap.put("save", "");
	dataMap.put("emptyDel", "");
	
	boolean flag=false;
	eneditContractManagement.AddDelievarable(dataMap);
	int deliverable=8411;
	deliverable=eneditContractManagement.deliverable;
	String del=""+deliverable;
	
	lavanteUtils.waitForTime(2000);

	SoftAssert softassert=new SoftAssert();
	outr:for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
		if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
					Reporter.log("Added Deliverable available in the list");
					lavanteUtils.click(eneditContractManagement.DELedit().get(i));
					lavanteUtils.waitForTime(4000);
					Reporter.log("Verify Status in Edit Page:");
					lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
					//Navigate every label available in the page
					One:for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(is).getText();
							System.out.println(applabel);
							if(applabel.equalsIgnoreCase("Status:")){
								Reporter.log(applabel+"is available in the Edit Deliverable Page");
								softassert.assertTrue(true,"Status field not available in the edit page");
								flag=true;
								break One;
							}
					}
				
					dataMap.remove("save");
					dataMap.put("cancel", "");
					eneditContractManagement.formActionDeliverable(dataMap);
					lavanteUtils.waitForTime(4000);
					
					lavanteUtils.click(eneditContractManagement.DELCopy().get(i));
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(driver.findElement(By.cssSelector("div[style*='visible']  iframe[src*='table_id=Add_Edit_Delive']")));
					Reporter.log("Verify Status in Copy Page:");
					//Navigate every label available in the copy page
					two:for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(is).getText();
							if(applabel.equalsIgnoreCase("Status:")){
								Reporter.log(applabel+"is available in the Copy Page");
								softassert.assertTrue(true,"Status field not available in the edit page");
								flag=true;
								break two;
							}
					}
					
					eneditContractManagement.formActionDeliverable(dataMap);
					
					lavanteUtils.click(eneditContractManagement.adddelnwBtn());
					lavanteUtils.waitForTime(4000);
					lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
					Reporter.log("Verify Status in Add Page:");
					//Navigate every label available in the copy page
					for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(is).getText();
							if(applabel.equalsIgnoreCase("Status:")){
								Reporter.log(applabel+" is available in the New Add Deliverable Page");
								softassert.assertTrue(true,"Status field not available in the edit page");
								flag=true;
								break;
							}
					}
					
					lavanteUtils.waitForTime(4000);
					eneditContractManagement.formActionDeliverable(dataMap);
					
					lavanteUtils.click(eneditContractManagement.DELnolist().get(i));
					lavanteUtils.switchtoFrame(eneditContractManagement.DELIframeView());
					Reporter.log("Verify Status in View Page:");
					//Navigate every label available in the copy page
					three:for(int is=0;is<eneditContractManagement.labellist().size();is++)
					{
							String applabel=eneditContractManagement.labellist().get(is).getText();
							if(applabel.equalsIgnoreCase("Status:")){
								Reporter.log(applabel+"is available in the View Deliverable Page");
								softassert.assertTrue(true,"Status field not available in the View page");
								flag=true;
								break three;
							}
					}
					lavanteUtils.waitForTime(4000);
					break outr;
					
			}
	
			
					
			}	
	
	if(flag==false)
	{
		softassert.assertTrue(false,"Data not matched");
	}
	softassert.assertAll();
	Reporter.log("Test Ended:"+LavanteUtils.currenttime());
}
		
	/**
	 * Verify Tax Rate as per the data sheet
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test
	public void DELEstTaxCreate002() throws Exception{	
		Reporter.log("Test Started for Validate Est Tax for Item Type at :"+LavanteUtils.currenttime());
		SoftAssert softassert=new SoftAssert();
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("DELdeliverablelocation","ANY");
		
		dataMap.put("DELitemtype", "Travel");	
		dataMap.put("DELinvamount","ANY");
		
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		System.out.println(eneditContractManagement.DELestTax().isDisplayed());
		System.out.println(amnt+eneditContractManagement.DELestTax().getText());
		String ds=eneditContractManagement.DELestTax().getAttribute("value");
		Reporter.log("For  "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app:"+ds);
		softassert.assertTrue(ds.length()<=0,"Estimated tax is calculated for Travel Item type,In app:"+ds);
		
		dataMap.clear();
		dataMap.put("DELitemtype", "Services");	
		
		eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
		
		ds=eneditContractManagement.DELestTax().getAttribute("value");
		Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app: "+ds);
		softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Services Item type,In app:"+ds);
		
		dataMap.clear();
		dataMap.put("DELitemtype", "Services");	
		eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
		
		ds=eneditContractManagement.DELestTax().getAttribute("value");
		Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax "+ds);
		softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Materials Item type,In app:"+ds);
		

		dataMap.put("cancel", "");
		eneditContractManagement.formActionDeliverable(dataMap);
		
		softassert.assertAll();
		Reporter.log("Test Ended:"+LavanteUtils.currenttime());

	}
	
	/**
	 * Verify Est Tax in Edit deliverable page with different item type
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELEstTaxEdit003(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate Est Tax for Item Type in EDIT DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		outr:for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{

				lavanteUtils.click(eneditContractManagement.DELedit().get(i));

				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				lavanteUtils.waitForTime(2000);
				
				//To avoid unnecessary data filling
				dataMap.clear();
				
				if(dataMap.containsKey("DELitemtype")){
					dataMap.put("DELitemtype", "Travel");	
				}else{
					dataMap.put("DELitemtype", "Travel");	
				}
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				System.out.println(amnt+eneditContractManagement.DELestTax().getText());
				String ds=eneditContractManagement.DELestTax().getAttribute("value");
				Reporter.log("For  "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app:"+ds);
				softassert.assertTrue(ds.length()<=0,"Estimated tax is calculated for Travel, Item type,In app:"+ds);
				
				
				dataMap.put("DELitemtype", "Services");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTax().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some value ,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Services, Item type,In app:"+ds);
				
				dataMap.put("DELitemtype", "Materials");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTax().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some Value,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Materials, Item type,In app:"+ds);
				
				dataMap.put("cancel", "");
				eneditContractManagement.formActionDeliverable(dataMap);
				flag=true;
				break outr;

			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended at:"+LavanteUtils.currenttime());

	}
	
	/**
	 * Verify Est Tax in Copy deliverable page with different item type
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELEstTaxCopy004(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate Est Tax for Item Type in COPY DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		int amnt=eneditContractManagement.AddDelievarable(dataMap);
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		outr:for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
				Reporter.log("Created Deliverable available in the list");
				lavanteUtils.click(eneditContractManagement.DELCopy().get(i));

				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				
				
				lavanteUtils.waitForTime(2000);
				Reporter.log("In Copy  Del Page:");
				//To avoid unnecessary data filling
				dataMap.clear();
				
				if(dataMap.containsKey("DELitemtype")){
					dataMap.put("DELitemtype", "Travel");	
				}else{
					dataMap.put("DELitemtype", "Travel");	
				}
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				System.out.println(amnt+eneditContractManagement.DELestTax().getText());
				String ds=eneditContractManagement.DELestTax().getAttribute("value");
				Reporter.log("For  "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Empty ,In app:"+ds);
				softassert.assertTrue(ds.length()<=0,"Estimated tax is calculated for Travel, Item type,In app:"+ds);
				
				
				dataMap.put("DELitemtype", "Services");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTax().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some value ,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Services, Item type,In app:"+ds);
				
				dataMap.put("DELitemtype", "Materials");	
				
				eneditContractManagement.fillDeliverableDetails(dataMap, "", "");
				
				ds=eneditContractManagement.DELestTax().getAttribute("value");
				Reporter.log("For "+dataMap.get("DELitemtype")+" the value of Est tax,Expected Some Value,In app: "+ds);
				softassert.assertTrue(ds.length()>0,"Estimated tax is not calculated for Materials, Item type,In app:"+ds);
				
				dataMap.put("cancel", "");
				eneditContractManagement.formActionDeliverable(dataMap);
				flag=true;
				break outr;
			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for COPY DEL Est Tax at:"+LavanteUtils.currenttime());

	}
	
	/**
	 * Verify Location with Tax Code  in Add deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELLocationADD005(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate  DEL Location with TAX Code in DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		eneditContractManagement.AddDelievarable(dataMap);
		
		dataMap.clear();
		
		String dellocation=eneditContractManagement.DELdellocationname().getText();
		
		 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
		
		 	int rowcount=0;
			rowcount=sheet.getLastRowNum();
			System.out.println("ROWCOUNT:"+rowcount);
			String taxcode=null;
			String location=null;
			for(int x=1;x<=rowcount;x++) 
	    	{  
				HSSFRow val=sheet.getRow(x);
	    		
	    		//Location Column
	    		HSSFCell ase=val.getCell(0);
	    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
	    			
				 }else { 
					ase.setCellType(Cell.CELL_TYPE_STRING);
				 	location=ase.getStringCellValue();
				 	if(dellocation.contains(location)){
				 		//Tax Column
				 		HSSFCell as=val.getCell(1);
				    	
			    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			    			
						 }else { as.setCellType(Cell.CELL_TYPE_STRING);
						
						taxcode=as.getStringCellValue();
						if(dellocation.endsWith(taxcode)){
							System.out.println("Del Location in app,"+dellocation+",expected:"+location);
							Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
							softassert.assertTrue(dellocation.contains(location),"DEL location not found"+dellocation+location);
				 		
						 	System.out.println("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
							 Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
							 softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found"+dellocation+taxcode);
							 flag=true;
							// break;
				 		
				 	} 
				 	
				 }
				
	    	}
				 }
	    	}
		if(flag==false){
			softassert.assertTrue(false,"Please add data and RETEST");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for DEL Location with Tax Code at:"+LavanteUtils.currenttime());

	}
	
	/**
	 * Verify Location with Tax Code  in Edit deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELLocationEdit006(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate Location with Tax Code in EDIT DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		eneditContractManagement.AddDelievarable(dataMap);
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		outr:for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
				Reporter.log("Created deliverable available in the list");
				lavanteUtils.click(eneditContractManagement.DELedit().get(i));

				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				

				String dellocation=eneditContractManagement.DELdellocationname().getText();
				
				 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
				
			 	int rowcount=0;
				rowcount=sheet.getLastRowNum();
				System.out.println("ROWCOUNT:"+rowcount);
				String taxcode=null;
				String location=null;
				for(int x=1;x<=rowcount;x++) 
		    	{  
					HSSFRow val=sheet.getRow(x);
		    		
		    		//Location Column
		    		HSSFCell ase=val.getCell(0);
		    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
		    			
					 }else { 
						ase.setCellType(Cell.CELL_TYPE_STRING);
					 	location=ase.getStringCellValue();
					 	if(dellocation.contains(location)){
					 		
					 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
					 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
					 		
					 		//Tax Column
					 		HSSFCell as=val.getCell(1);
					    	
				    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
				    			
							 }else { as.setCellType(Cell.CELL_TYPE_STRING);
							
							 	taxcode=as.getStringCellValue();
								Reporter.log("Del Location Tax in app,"+dellocation+",expected tax code:"+taxcode);
								softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");

								flag=true;
								break outr;
								 
							 }
					 		
					 	} 
					 	
					 }
					
		    	}
				
			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended Location with Tax Code  at:"+LavanteUtils.currenttime());

	}
	
	/**
	 * Verify Location in Tax Code deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELLocationCopy007(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate Location with Tax Code in COPY DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		eneditContractManagement.AddDelievarable(dataMap);
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		outr:for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
				Reporter.log("Created deliverable available in the list");
				lavanteUtils.click(eneditContractManagement.DELCopy().get(i));

				lavanteUtils.switchtoFrame(eneditContractManagement.DELEditIframe());
				
				
				lavanteUtils.waitForTime(2000);
				
				String dellocation=eneditContractManagement.DELdellocationname().getText();
				
				 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
				
			 	int rowcount=0;
				rowcount=sheet.getLastRowNum();
				System.out.println("ROWCOUNT:"+rowcount);
				String taxcode=null;
				String location=null;
				for(int x=1;x<=rowcount;x++) 
		    	{  
					HSSFRow val=sheet.getRow(x);
		    		
		    		//Location Column
		    		HSSFCell ase=val.getCell(0);
		    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
		    			
					 }else { 
						ase.setCellType(Cell.CELL_TYPE_STRING);
					 	location=ase.getStringCellValue();
					 	if(dellocation.contains(location)){
					 		
					 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
					 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
					 		
					 		//Tax Column
					 		HSSFCell as=val.getCell(1);
					    	
				    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
				    			
							 }else { as.setCellType(Cell.CELL_TYPE_STRING);
							
							 	taxcode=as.getStringCellValue();
								Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
								softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");

								flag=true;
								 break outr;
							 }
					 		
					 	} 
					 	
					 }
					
		    	}


			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for COPY DEL LOCATION in TaX CODE at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
		
	/**
	 * Verify Location in Tax Code View deliverable page 
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void DELLocationView008(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate Location with Tax Code in VIEW DEL at :"+LavanteUtils.currenttime());
		boolean flag=false;
		SoftAssert softassert=new SoftAssert();
		
		//To  Save the deliverables
		dataMap.put("save","");
		eneditContractManagement.AddDelievarable(dataMap);
		Reporter.log("Created New Deliverable");
		
		int deliverable=2248;
		deliverable=eneditContractManagement.deliverable;
		String del=""+deliverable;
		
		lavanteUtils.waitForTime(2000);
		outr:for(int i=eneditContractManagement.DELnolist().size()-1;i>=0;i--){
			System.out.println(del+eneditContractManagement.DELnolist().get(i).getText());
			if(del.equalsIgnoreCase(eneditContractManagement.DELnolist().get(i).getText()))
			{
				Reporter.log("Created deliverable available in the list");
				lavanteUtils.click(eneditContractManagement.DELnolist().get(i));
				Reporter.log("In View Mode of Deliverable");
				
				lavanteUtils.switchtoFrame(eneditContractManagement.DELIframeView());
				
				
				lavanteUtils.waitForTime(2000);
				
				String dellocation=eneditContractManagement.DELViewdeliverableLocation().getText();
				
				 HSSFSheet sheet=LavanteUtils.ReadExcel("Deliverables.xls", "TAX RATE LIST");
				
			 	int rowcount=0;
				rowcount=sheet.getLastRowNum();
				System.out.println("ROWCOUNT:"+rowcount);
				String taxcode=null;
				String location=null;
				for(int x=1;x<=rowcount;x++) 
		    	{  
					HSSFRow val=sheet.getRow(x);
		    		
		    		//Location Column
		    		HSSFCell ase=val.getCell(0);
		    		if (ase == null || ase.getCellType() == Cell.CELL_TYPE_BLANK) {
		    			
					 }else { 
						ase.setCellType(Cell.CELL_TYPE_STRING);
					 	location=ase.getStringCellValue();
					 	if(dellocation.contains(location)){
					 		
					 		Reporter.log("Del Location in app,"+dellocation+",expected:"+location);
					 		softassert.assertTrue(dellocation.contains(location),"DEL location not found");
					 		
					 		//Tax Column
					 		HSSFCell as=val.getCell(1);
					    	
				    		if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
				    			
							 }else { as.setCellType(Cell.CELL_TYPE_STRING);
							
							 	taxcode=as.getStringCellValue();
								Reporter.log("Del Location in app,"+dellocation+",expected tax code:"+taxcode);
								softassert.assertTrue(dellocation.contains(taxcode),"DEL location Tax not found");

								flag=true;
								break outr;
							 }
					 		
					 	} 
					 	
					 }
					
		    	}


			}
		
			
		}
		
		

		if(flag==false){
		softassert.assertTrue(false,"Please add data And RETEST");	
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended for VIEW DEL LOCATION in TaX CODE at:"+LavanteUtils.currenttime());
		System.out.println("----------Test Ended----------------");

	}
		
	/**
	 * Verify Tax Rate as per the data sheet
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void ValidateServiceTax009(LinkedHashMap<String,String> dataMap) throws Exception{	
		Reporter.log("Test Started for Validate TAX:"+LavanteUtils.currenttime());
		eneditContractManagement.AddDelievarable(dataMap);
		
		
		if(dataMap.get("DELestTax").length()>0)
		{ 	
			System.out.println(eneditContractManagement.DELestTaxPercent().getText());
			System.out.println(eneditContractManagement.DELestTaxPercent().getAttribute("value"));
			if(eneditContractManagement.DELestTaxPercent().getAttribute("value").contains("%"))
			{
				String[] sp=eneditContractManagement.DELestTaxPercent().getAttribute("value").split("%");
				
				Double exptxrate=Double.parseDouble(dataMap.get("DELestTax"));
			
				Double acttxrate=Double.parseDouble(sp[0])/100;
				System.out.println(Math.round(exptxrate)+"Actual:"+Math.round(acttxrate));
				Reporter.log("Tax Rate ,Expected for:"+exptxrate+",Actual is:"+acttxrate);
				Assert.assertEquals(Math.round(acttxrate),Math.round(exptxrate), "Tax Rate Not matched,Expected for:"+dataMap.get("DELestTax"));
	
			}else {
				Assert.assertTrue(eneditContractManagement.DELestTaxPercent().getAttribute("value").contains("%")==true,
						"Application did not show the tax rate with % ,App data:"+eneditContractManagement.DELestTaxPercent().getAttribute("value"));
			}	
		} else {
			Assert.assertTrue(dataMap.get("DELestTax").length()<0, "Tax Rate Not Given,in the test data:"+dataMap.get("DELestTax"));
		}
		

		dataMap.put("cancel", "");
		eneditContractManagement.formActionDeliverable(dataMap);
		
		Reporter.log("Test ended at:"+LavanteUtils.currenttime());
	}
	
	/**
	 * Verify TAX AMNT calculation is done after multiplying tax rate and amount
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @author Piramanayagam.S
	 */
	@Test(dataProvider="SingleDELData",dataProviderClass=CMDataProvider.class)
	public void ValidateEstTaxAmnt010(LinkedHashMap<String,String> dataMap) throws Exception{	
		
		Double exptax= 0.0;
		SoftAssert softassert=new SoftAssert();
		boolean flag=false;
		if(dataMap.containsKey("status"))
		{ 
			String amnt=""+LavanteUtils.randomnum(999);
			dataMap.put("DELinvamount",amnt);
			eneditContractManagement.AddDelievarable(dataMap);
			lavanteUtils.switchtoFrame(eneditContractManagement.DELIframe());
			String xx="";
			if(dataMap.get("DELestTax").length()>0)
			{
				Reporter.log("Amnt:"+amnt+"Est tax"+dataMap.get("DELestTax"));
				exptax=Double.parseDouble(amnt)*Double.parseDouble(dataMap.get("DELestTax"));
				DecimalFormat df = new DecimalFormat("#.##"); 
				xx=""+df.format(exptax);
				Reporter.log("Amnt:"+amnt+"Est tax"+dataMap.get("DELestTax"));
			}
			String s=eneditContractManagement.DELestTax().getAttribute("value");
			Reporter.log(s+":Actuals,Exp Tax Value:"+xx);
		//	Double doubles=Double.parseDouble(s);
			softassert.assertEquals(s, xx , "Tax Amount Not matched,Expected for:"+s+ ":"+exptax);
			flag=true;
		} 
		
		if(flag==false) {
			softassert.assertTrue(false,"Please Recheck the TEST");
		}
		
		softassert.assertAll();
		Reporter.log("Test Ended at :"+LavanteUtils.currenttime());
	}
	
	
	/**
	 * After MEthod
	 */
	 @AfterMethod
	public void aftermethod(){
		 refreshPage();
		enobjhomePage.popupclose();
		
	}
	
	
	@AfterClass
	public void SetupafterClassmethod(){
		
		LinkedHashMap<String,String> dataMap=new LinkedHashMap<String,String>();
		dataMap.put("SaveExit", "");
		eneditProfile.formAction(dataMap);
		
		enobjhomePage.logout();
		
		quitBrowser();
	}


}

