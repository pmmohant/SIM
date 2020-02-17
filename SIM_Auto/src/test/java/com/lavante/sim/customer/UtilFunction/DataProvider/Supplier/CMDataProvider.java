package com.lavante.sim.customer.UtilFunction.DataProvider.Supplier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;



import com.lavante.sim.Common.Util.LavanteUtils;


public class CMDataProvider {

	static String fname="Deliverables.xls";
	static String path=File.separator;
	static String dir=LavanteUtils.dir;
	
	/**
	 * used FOR SINGLE MSA DATA in contract Management using this test data for checking other functionality
	 * in MSA
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SingleMSAData") 	
	public static Object[][] dataProviderSingleMSA() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);	
		Object[][] obj=getSData(f,"Deliverables","SingleMSAData");
		return obj;
	}

	/**
	 * used FOR SINGLE SOW DATA in contract Management using this test data for checking other functionality
	 * in SOW
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SingleSOWData") 	
	public static Object[][] dataProviderSingleSOW() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","SingleSOWData");
		return obj;
	}
	
	/**
	 * used FOR SINGLE DEL DATA in contract Management using this test data for checking other functionality
	 * in DEL
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SingleDELData") 	
	public static Object[][] dataProviderSingleDEL() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","SingleDELData");
		return obj;
	}
	
	
	@DataProvider(name="SingleDELValue") 	
	public static Object[][] dataProviderSingleDELValue() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","SingleDELValue");
		return obj;
	}
	
	/**
	 * Used for Validating test
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="VALIDATE") 	
	public static Object[][] dataProviderDelValidateTest() throws Throwable
	{		
	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","VALIDATE");		
		return obj;
	}	
	
	/**
	 * Used for Data provider del save
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="VERIFYCALC") 	
	public static Object[][] dataProviderDelSaveTest() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","VERIFYCALC");
		return obj;
	}
	
	/**
	 * Used for Del cond verify test
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="CONDITIONALVERIFY") 	
	public static Object[][] dataProviderDelCondVerifyTest() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","CONDITIONALVERIFY");
		return obj;
	}
	
	/**
	 * Used for Del cancel verify
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="VERIFYCANCEL") 	
	public static Object[][] dataProviderCancelVerifyTest() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","VERIFYCANCEL");
		return obj;
	}
	
	/**
	 * Used for DEL Cancel 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="CANCEL") 	
	public static Object[][] dataProviderCancelTest() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSData(f,"Deliverables","CANCEL");
		return obj;
	}
	
	
	/**
	 * Used for Invite supplier data
	 * @author Piramanayagam.S
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getInviteSuppData(File f,String sheetname,String TCkey) throws IOException{
		LinkedHashMap[][] mapsexcel=null;
	
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet(sheetname);
		int rowcount=0;
	
		rowcount=sheet.getLastRowNum();
		 int count=0;
		for(int x=0;x<=rowcount;x++)
    	{   HSSFRow val=sheet.getRow(x);
    		HSSFCell as=val.getCell(0);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else { as.setCellType(Cell.CELL_TYPE_STRING);
					 if(as.getStringCellValue().equalsIgnoreCase(TCkey))
					 {
						 count++;
						 mapsexcel = new LinkedHashMap[count][1];
					 }
				}
    	}
		for(int i=2;i<=rowcount;i++){
			
		LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
		
			HSSFRow row=sheet.getRow(i);
			
			HSSFCell cells=row.getCell(0);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
			
			}else 
			{ cells.setCellType(Cell.CELL_TYPE_STRING);
			if(cells.getStringCellValue().equalsIgnoreCase(TCkey))
		 {
			int j=1;
			HSSFCell suppname=row.getCell(j);
			if (suppname == null || suppname.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { suppname.setCellType(Cell.CELL_TYPE_STRING);
				 		map.put("suppname", suppname.getStringCellValue());
				 }
				
			j=j+1;
			HSSFCell contactname=row.getCell(j);
			if (contactname == null || contactname.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { contactname.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("contactname", contactname.getStringCellValue());
			 }
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
				HSSFCell email=row.getCell(j);
				if (email == null || email.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { email.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("email",email.getStringCellValue());
				 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell invitorg=row.getCell(j);
			if (invitorg == null || invitorg.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { invitorg.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("inviteorg", invitorg.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell suppgrp=row.getCell(j);
			if (suppgrp == null || suppgrp.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { suppgrp.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("suppgrp", suppgrp.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell reason=row.getCell(j);
			if (reason == null || reason.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { reason.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("reason", reason.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell agreesup=row.getCell(j);
			if (agreesup == null || agreesup.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { agreesup.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("agreesup", agreesup.getStringCellValue());
			 }
			}
						
			
			mapsexcel[count-1][0]=map;
			count=count-1;
			
		 } //else
	}//if
		
		} //for
		return mapsexcel;
	}
	
	/**
	 * Used for Supplier data
	 * @author Piramanayagam.S
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getSData(File f,String sheetname,String TCkey) throws IOException{
		LinkedHashMap[][] mapsexcel=null;
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet(sheetname);
		int rowcount=0;
	
		rowcount=sheet.getLastRowNum();
		//Minus one due to the Object
		 int count=0;
		for(int x=0;x<=rowcount;x++)
    	{   HSSFRow val=sheet.getRow(x);
    		HSSFCell as=val.getCell(2);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else { as.setCellType(Cell.CELL_TYPE_STRING);
					 if(as.getStringCellValue().equalsIgnoreCase(TCkey))
					 {
						 count++;
						 mapsexcel = new LinkedHashMap[count][1];
					 }
				}
    	}
		for(int i=2;i<=rowcount;i++){
		LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
		
			HSSFRow row=sheet.getRow(i);
			
			HSSFCell cells=row.getCell(2);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
			
			}else 
			{ cells.setCellType(Cell.CELL_TYPE_STRING);
			if(cells.getStringCellValue().equalsIgnoreCase(TCkey))
		 {
		    
			int j=0;
			HSSFCell statusTab=row.getCell(j);
			if (statusTab == null || statusTab.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { statusTab.setCellType(Cell.CELL_TYPE_STRING);
				 	if(statusTab.getStringCellValue().equalsIgnoreCase("VALID"))
				 	{
				 		map.put("status", statusTab.getStringCellValue());
				 	} 
				 }
				
			j=1;
			HSSFCell errmsg=row.getCell(j);
			if (errmsg == null || errmsg.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { errmsg.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("errormsg", errmsg.getStringCellValue());
			 }
			
			j=3;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell msaclient=row.getCell(j);
			if (msaclient == null || msaclient.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { msaclient.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("msaclient",msaclient.getStringCellValue());
			 }
		}
				
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell addendum=row.getCell(j);
				if (addendum == null || addendum.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { addendum.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("addendum",addendum.getStringCellValue());
				 }
			}
			
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSAstartdate=row.getCell(j);
			if (MSAstartdate == null || MSAstartdate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSAstartdate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("MSAstartdate", MSAstartdate.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell msaevergreen=row.getCell(j);
			if (msaevergreen == null || msaevergreen.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { msaevergreen.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("msaevergreen", msaevergreen.getStringCellValue());
			 }
			}
			

			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell msanottoexceed=row.getCell(j);
				if (msanottoexceed == null || msanottoexceed.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { msanottoexceed.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("msanottoexceed",msanottoexceed.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSAstatus=row.getCell(j);
			if (MSAstatus == null || MSAstatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSAstatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("MSAstatus", MSAstatus.getStringCellValue());
			 }
			}
			

			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell msaupload=row.getCell(j);
				if (msaupload == null || msaupload.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { msaupload.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("msaupload",msaupload.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSATYPE=row.getCell(j);
			if (MSATYPE == null || MSATYPE.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSATYPE.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("MSATYPE", MSATYPE.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell SOWRMSNo=row.getCell(j);
			if (SOWRMSNo == null || SOWRMSNo.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWRMSNo.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWRMSNo", SOWRMSNo.getStringCellValue());
			 }
			}
		
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell SOWStartDate=row.getCell(j);
			if (SOWStartDate == null || SOWStartDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStartDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWStartDate", SOWStartDate.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell SOWEnddate=row.getCell(j);
			if (SOWEnddate == null || SOWEnddate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWEnddate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWEnddate", SOWEnddate.getStringCellValue());
			 }
			}
			
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWDescription=row.getCell(j);
			if (SOWDescription == null || SOWDescription.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWDescription.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWDescription", SOWDescription.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWInternalContact=row.getCell(j);
			if (SOWInternalContact == null || SOWInternalContact.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWInternalContact.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWInternalContact", SOWInternalContact.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWNotes=row.getCell(j);
			if (SOWNotes == null || SOWNotes.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWNotes.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWNotes", SOWNotes.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWStatus=row.getCell(j);
			if (SOWStatus == null || SOWStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWStatus", SOWStatus.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWPaymentType=row.getCell(j);
			if (SOWPaymentType == null || SOWPaymentType.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWPaymentType.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWPaymentType", SOWPaymentType.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWPaymentTerms=row.getCell(j);
			if (SOWPaymentTerms == null || SOWPaymentTerms.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWPaymentTerms.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWPaymentTerms", SOWPaymentTerms.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWNotToExecedAmnt=row.getCell(j);
			if (SOWNotToExecedAmnt == null || SOWNotToExecedAmnt.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWNotToExecedAmnt.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWNotToExecedAmnt", SOWNotToExecedAmnt.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWClient=row.getCell(j);
			if (SOWClient == null || SOWClient.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWClient.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWClientName", SOWClient.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWUpfront=row.getCell(j);
			if (SOWUpfront == null || SOWUpfront.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWUpfront.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWUpfront", SOWUpfront.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWCreditCard=row.getCell(j);
			if (SOWCreditCard == null || SOWCreditCard.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWCreditCard.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWCreditCard", SOWCreditCard.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWsingleFile=row.getCell(j);
			if (SOWsingleFile == null || SOWsingleFile.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWsingleFile.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWsingleFile", SOWsingleFile.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWmultiFile=row.getCell(j);
			if (SOWmultiFile == null || SOWmultiFile.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWmultiFile.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWmultiFile", SOWmultiFile.getStringCellValue());
			 }
			}
			
			
			//Deliverable
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELitemNumber=row.getCell(j);
			if (DELitemNumber == null || DELitemNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELitemNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELitemNumber", DELitemNumber.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELdeliverable=row.getCell(j);
			if (DELdeliverable == null || DELdeliverable.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELdeliverable.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELdeliverable", DELdeliverable.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELexpectedDelivarabledate=row.getCell(j);
			if (DELexpectedDelivarabledate == null || DELexpectedDelivarabledate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELexpectedDelivarabledate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELexpectedDelivarabledate", DELexpectedDelivarabledate.getStringCellValue());
			 }
			}
			j=j+1;
			
			HSSFSheet sheets=wb.getSheet("TAX RATE LIST");
			int rand=sheets.getLastRowNum();
			int rows=LavanteUtils.randomnum(rand);
			HSSFRow rowss=sheets.getRow(rows); 		
			
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELdeliverablelocation=row.getCell(j);
			
			if (DELdeliverablelocation == null || DELdeliverablelocation.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else {
				 
				 DELdeliverablelocation.setCellType(Cell.CELL_TYPE_STRING);
			 
				 String s=""+DELdeliverablelocation.getStringCellValue();
				if(DELdeliverablelocation.getStringCellValue().equalsIgnoreCase("ANY")){
					
					
					//Location at 0 th column
					HSSFCell DELdeliverablelocations=rowss.getCell(0);
					HSSFCell DELdeliverablecodes=rowss.getCell(1);
					 s=DELdeliverablelocations.getStringCellValue()+" - "+DELdeliverablecodes.getStringCellValue();
				}
				map.put("DELdeliverablelocation",s);
				 
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELestTax=row.getCell(j);
			if (DELestTax == null || DELestTax.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELestTax.setCellType(Cell.CELL_TYPE_STRING);
			 String x=DELestTax.getStringCellValue();
			 if(DELestTax.getStringCellValue().equalsIgnoreCase("ANY")){
				
				//Tax at 1st column
				HSSFCell DELestTaxlocations=rowss.getCell(2); 
				x=""+DELestTaxlocations.getNumericCellValue();
			 }
				map.put("DELestTax", x);
				 
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELitemtype=row.getCell(j);
			if (DELitemtype == null || DELitemtype.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELitemtype.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELitemtype", DELitemtype.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELinvamount=row.getCell(j);
			if (DELinvamount == null || DELinvamount.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELinvamount.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELinvamount", DELinvamount.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELcurrency=row.getCell(j);
			if (DELcurrency == null || DELcurrency.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELcurrency.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELcurrency", DELcurrency.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELpaymentstatus=row.getCell(j);
			if (DELpaymentstatus == null || DELpaymentstatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELpaymentstatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELpaymentstatus", DELpaymentstatus.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell DELaccnumber=row.getCell(j);
			if (DELaccnumber == null || DELaccnumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELaccnumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELaccnumber", DELaccnumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELlistprice=row.getCell(j);
			if (DELlistprice == null || DELlistprice.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELlistprice.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELlistprice", DELlistprice.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELdiscprice=row.getCell(j);
			if (DELdiscprice == null || DELdiscprice.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELdiscprice.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELdiscprice", DELdiscprice.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELcostsaving=row.getCell(j);
			if (DELcostsaving == null || DELcostsaving.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELcostsaving.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELcostsaving", DELcostsaving.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELCancelled=row.getCell(j);
			if (DELCancelled == null || DELCancelled.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELCancelled.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELCancelled", DELCancelled.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELCancelledNotes=row.getCell(j);
			if (DELCancelledNotes == null || DELCancelledNotes.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELCancelledNotes.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELCancelledNotes", DELCancelledNotes.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELBrowse=row.getCell(j);
			if (DELBrowse == null || DELBrowse.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELBrowse.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELBrowse", DELBrowse.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELexpenseNottoClient=row.getCell(j);
			if (DELexpenseNottoClient == null || DELexpenseNottoClient.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELexpenseNottoClient.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELexpenseNottoClient", DELexpenseNottoClient.getStringCellValue());
			 }
			}
			
			
			mapsexcel[count-1][0]=map;
			count=count-1;
			
		 } //else
	}//if
		
		} //for
		return mapsexcel;
	}
	
	/**
	 * Used for Deliverables-Contract Management - Advanced Search and Basic Search 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getAdvData(File f,String sheetname,String TCkey) throws IOException{
		LinkedHashMap[][] mapsexcel=null;
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet(sheetname);
		int rowcount=0;
	
		rowcount=sheet.getLastRowNum();
		//Minus one due to the Object
		 int count=0;
		for(int x=1;x<=rowcount;x++) 
    	{  
    		HSSFRow val=sheet.getRow(x);
    		HSSFCell as=val.getCell(1);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else { as.setCellType(Cell.CELL_TYPE_STRING);
					 if(as.getStringCellValue().equalsIgnoreCase(TCkey))
					 {
						 count++;
						 mapsexcel = new LinkedHashMap[count][1];
					 }
						
				}
    
    	}
		for(int i=2;i<=rowcount;i++){
		LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
		
			HSSFRow row=sheet.getRow(i);
			
			HSSFCell cells=row.getCell(1);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
			
			}else 
			{ cells.setCellType(Cell.CELL_TYPE_STRING);
			if(cells.getStringCellValue().equalsIgnoreCase(TCkey))
		 {
			
			int j=0;
		

			j=2;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell searchtype=row.getCell(j);
			if (searchtype == null || searchtype.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { searchtype.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Searchtype",searchtype.getStringCellValue());
			 }
			}
				
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell msaclient=row.getCell(j);
				if (msaclient == null || msaclient.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { msaclient.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("msaclient",msaclient.getStringCellValue());
				 }
				}
		
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DPTYPESUPPMSA=row.getCell(j);
			if (DPTYPESUPPMSA == null || DPTYPESUPPMSA.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DPTYPESUPPMSA.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DPTYPESUPPMSA", DPTYPESUPPMSA.getStringCellValue());
			 }
			}
					
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell addendum=row.getCell(j);
				if (addendum == null || addendum.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { addendum.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("msasuppliername",addendum.getStringCellValue());
				 }
			}
			

			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSATYPE=row.getCell(j);
			if (MSATYPE == null || MSATYPE.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSATYPE.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("MSATYPE", MSATYPE.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSATYPE=row.getCell(j);
			if (MSATYPE == null || MSATYPE.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSATYPE.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeMSANum", MSATYPE.getStringCellValue());
			 }
			}
					
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSATYPE=row.getCell(j);
			if (MSATYPE == null || MSATYPE.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSATYPE.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("MSANum", MSATYPE.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell MSAstatus=row.getCell(j);
			if (MSAstatus == null || MSAstatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { MSAstatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("MSAstatus", MSAstatus.getStringCellValue());
			 }
			}

			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell SOWStartDate=row.getCell(j);
			if (SOWStartDate == null || SOWStartDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStartDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeSOWNumber", SOWStartDate.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell SOWStartDate=row.getCell(j);
			if (SOWStartDate == null || SOWStartDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStartDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWNumber", SOWStartDate.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell SOWStartDate=row.getCell(j);
			if (SOWStartDate == null || SOWStartDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStartDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeSOWNotes", SOWStartDate.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWNotes=row.getCell(j);
			if (SOWNotes == null || SOWNotes.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWNotes.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWNotes", SOWNotes.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWStatus=row.getCell(j);
			if (SOWStatus == null || SOWStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWStatus", SOWStatus.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWDescription=row.getCell(j);
			if (SOWDescription == null || SOWDescription.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWDescription.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeSOWDescription", SOWDescription.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWDescription=row.getCell(j);
			if (SOWDescription == null || SOWDescription.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWDescription.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWDescription", SOWDescription.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWInternalContact=row.getCell(j);
			if (SOWInternalContact == null || SOWInternalContact.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWInternalContact.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TYpeSOWInternalContact", SOWInternalContact.getStringCellValue());
			 }
			}

			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWInternalContact=row.getCell(j);
			if (SOWInternalContact == null || SOWInternalContact.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWInternalContact.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWInternalContact", SOWInternalContact.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWClient=row.getCell(j);
			if (SOWClient == null || SOWClient.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWClient.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWPaymentStatus", SOWClient.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWUpfront=row.getCell(j);
			if (SOWUpfront == null || SOWUpfront.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWUpfront.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWUpfront", SOWUpfront.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWCreditCard=row.getCell(j);
			if (SOWCreditCard == null || SOWCreditCard.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWCreditCard.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWCreditCard", SOWCreditCard.getStringCellValue());
			 }
			}
			
			
			//Deliverable
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell typedel=row.getCell(j);
			if (typedel == null || typedel.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { typedel.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeDel", typedel.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELdeliverable=row.getCell(j);
			if (DELdeliverable == null || DELdeliverable.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELdeliverable.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELdeliverable", DELdeliverable.getStringCellValue());
			 }
			}
			
			
			
			j=j+1;
			
			
			
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELdeliverablelocation=row.getCell(j);
			
			if (DELdeliverablelocation == null || DELdeliverablelocation.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELdeliverablelocation.setCellType(Cell.CELL_TYPE_STRING);
			 String current=DELdeliverablelocation.getStringCellValue();
			 
			 //Location at 0 th column
			 if(current.equalsIgnoreCase("ANY")){
				 HSSFSheet sheets=wb.getSheet("TAX RATE LIST");
				int rand=sheets.getLastRowNum();
				HSSFRow rowss=sheets.getRow(rand); 
				HSSFCell DELdeliverablelocations=rowss.getCell(0);
				current=DELdeliverablelocations.getStringCellValue(); } 
				map.put("DELdeliverablelocation",current);
				 
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELitemtype=row.getCell(j);
			if (DELitemtype == null || DELitemtype.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELitemtype.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELitemtype", DELitemtype.getStringCellValue());
			 }
			}
		
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell typeacc=row.getCell(j);
			if (typeacc == null || typeacc.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { typeacc.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeAcc", typeacc.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell DELaccnumber=row.getCell(j);
			if (DELaccnumber == null || DELaccnumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELaccnumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELaccnumber", DELaccnumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell DELPaymentStatus=row.getCell(j);
			if (DELPaymentStatus == null || DELPaymentStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELPaymentStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELPaymentStatus", DELPaymentStatus.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELBudgetCode=row.getCell(j);
			if (DELBudgetCode == null || DELBudgetCode.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELBudgetCode.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeDELBudgetCode", DELBudgetCode.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELBudgetCode=row.getCell(j);
			if (DELBudgetCode == null || DELBudgetCode.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELBudgetCode.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELBudgetCode", DELBudgetCode.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELBudgetCode=row.getCell(j);
			if (DELBudgetCode == null || DELBudgetCode.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELBudgetCode.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeDELOrgCode", DELBudgetCode.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELOrgCode=row.getCell(j);
			if (DELOrgCode == null || DELOrgCode.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELOrgCode.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELOrgCode", DELOrgCode.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell DELexpenseNottoClient=row.getCell(j);
			if (DELexpenseNottoClient == null || DELexpenseNottoClient.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DELexpenseNottoClient.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("DELexpenseNottoClient", DELexpenseNottoClient.getStringCellValue());
			 }
			}
			
			mapsexcel[count-1][0]=map;
			count=count-1;
			
		 } //else
	}//if
		
		} //for
		return mapsexcel;
	}
	
	}
