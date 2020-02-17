package com.lavante.sim.customer.UtilFunction.DataProvider.Supplier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;

import com.lavante.sim.Common.Util.LavanteUtils;

public class CMSearchDataProvider {
	
	static String fname="CMAdvBasicSearch.xls";
	static String path=File.separator;
	static String dir = LavanteUtils.dir;
	
	/**
	 * Used for Single searching functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SingleSearch") 	
	public static Object[][] dataProviderSingleBasicSearch() throws Throwable
	{		

		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getBasicData(f,"BasicSearch","SingleSearch");
		return obj;
	}
	
	/**
	 * used FOR SINGLE DATA in advanced search using this test data for checking other functionality
	 * in advanced Search
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SingleAdvSearch") 	
	public static Object[][] dataProviderAdvSearch() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getAdvData(f,"AdvancedSearch","SingleAdvSearch");
		return obj;
	}
	
	/**
	 * used FOR SINGLE DATA in advanced search using this test data for checking other functionality
	 * in advanced Search
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="EditCriteria") 	
	public static Object[][] dataProviderAdvSearchEdit() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getAdvData(f,"AdvancedSearch","EditCriteria");
		return obj;
	}
	
	

	/**
	 * used FOR SINGLE DATA in advanced search using this test data for checking other functionality
	 * in advanced Search
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="AdvanceSearch") 	
	public static Object[][] dataProviderAdvsSearch() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getAdvData(f,"AdvancedSearch","AdvanceSearch");
		return obj;
	}
	
	
	/**
	 * Used for Basic searching functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="BasicSearch") 	
	public static Object[][] dataProviderBasicSearch() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getBasicData(f,"BasicSearch","BasicSearch");
		
		
		return obj;
	}
	
	
	/**
	 * Used for Deliverables-Contract Management - Basic Search 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getBasicData(File f,String sheetname,String TCkey) throws IOException{
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
			
			int j=2;
		
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell Searchtype=row.getCell(j);
			if (Searchtype == null || Searchtype.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { Searchtype.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Searchtype",Searchtype.getStringCellValue());
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
				 map.put("MSANum", MSATYPE.getStringCellValue());
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
		
			HSSFCell SOWStartDate=row.getCell(j);
			if (SOWStartDate == null || SOWStartDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStartDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWNumber", SOWStartDate.getStringCellValue());
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
			
			
			mapsexcel[count-1][0]=map;
			count=count-1;
			
		 } //else
	}//if
		
		} //for
		return mapsexcel;
	}
	

	/**
	 * Used for Advanced Search and Basic Search 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static HashMap[][] getAdvData(File f,String sheetname,String TCkey) throws IOException{
		HashMap[][] mapsexcel=null;
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
						 mapsexcel = new HashMap[count][1];
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
		

			j=3;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell msaclient=row.getCell(j);
			if (msaclient == null || msaclient.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { msaclient.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Searchtype",msaclient.getStringCellValue());
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
			HSSFCell SOWPaymentStatus=row.getCell(j);
			if (SOWPaymentStatus == null || SOWPaymentStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWPaymentStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SOWPaymentStatus", SOWPaymentStatus.getStringCellValue());
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
		
			HSSFCell DelType=row.getCell(j);
			if (DelType == null || DelType.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DelType.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeDel", DelType.getStringCellValue());
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
				int rows=LavanteUtils.randomnum(20);
				HSSFRow rowss=sheets.getRow(rows); 
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
		
			HSSFCell SOWStartDate=row.getCell(j);
			if (SOWStartDate == null || SOWStartDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWStartDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeAcc", SOWStartDate.getStringCellValue());
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
			HSSFCell DelORGCode=row.getCell(j);
			if (DelORGCode == null || DelORGCode.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { DelORGCode.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TypeDELOrgCode", DelORGCode.getStringCellValue());
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
