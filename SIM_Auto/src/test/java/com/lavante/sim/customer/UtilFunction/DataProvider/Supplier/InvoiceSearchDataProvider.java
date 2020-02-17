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

public class InvoiceSearchDataProvider {

	static String fname="InvoiceSearch.xls";
	static String path=File.separator;
	static String dir = LavanteUtils.dir;
	
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
	 * Used for Basic searching functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="AdvancedSearch") 	
	public static Object[][] dataProviderSubInvoice() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getAdvData(f,"AdvancedSearch","AdvancedSearch");
		return obj;
	}
	
	
	/**
	 * Used for Basic searching functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="InvoiceDate") 	
	public static Object[][] dataProviderInvoiceDatePayment() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getAdvData(f,"AdvancedSearch","InvoiceDate");
		return obj;
	}
	
	
	
	/**
	 * Used for InvoiceSearch- Basic Search Single Data 
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
			HSSFCell InvStatus=row.getCell(j);
			if (InvStatus == null || InvStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { InvStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvStatus",InvStatus.getStringCellValue());
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
	 * Used for Inv Adv Search- Adv Search Single Data 
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
			
			int j=2;
		
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell SupplierERPID=row.getCell(j);
				if (SupplierERPID == null || SupplierERPID.getCellType() == Cell.CELL_TYPE_BLANK) {
					
				 }else { SupplierERPID.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("SupplierERPID",SupplierERPID.getStringCellValue());
				 }
				}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell InvoiceNumber=row.getCell(j);
			if (InvoiceNumber == null || InvoiceNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { InvoiceNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvoiceNumber",InvoiceNumber.getStringCellValue());
			 }
			}
					
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell PONumber=row.getCell(j);
				if (PONumber == null || PONumber.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { PONumber.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("PONumber",PONumber.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell InvoiceType=row.getCell(j);
			if (InvoiceType == null || InvoiceType.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InvoiceType.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvoiceType", InvoiceType.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell InvoiceDate=row.getCell(j);
			if (InvoiceDate == null || InvoiceDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InvoiceDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvoiceDate", InvoiceDate.getStringCellValue());
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
