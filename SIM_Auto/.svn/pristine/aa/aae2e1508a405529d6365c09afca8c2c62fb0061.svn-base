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

public class InvoiceDataProvider {

	static String fname="InvUpload.xls";
	static String path=File.separator;
	static String dir = LavanteUtils.dir;
	
	/**
	 * Used for Basic searching functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SubmitInvoice") 	
	public static Object[][] dataProviderSubInvoice() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","SubmitInvoice");
		return obj;
	}
	
	/**
	 * Used for Basic searching functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SplitInvoice") 	
	public static Object[][] dataProviderSplitInvoice() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","SplitInvoice");
		return obj;
	}
	
	@DataProvider(name="InvalidUpload") 	
	public static Object[][] dataProviderInvalidUpload() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","InvalidUpload");
		return obj;
	}
	
	@DataProvider(name="DELUpload") 	
	public static Object[][] dataProviderDELInvoice() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","DELUpload");
		return obj;
	}
	
	
	
	/**
	 * Used for Invoice functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="EditInvoice") 	
	public static Object[][] dataProviderEditInvoice() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","EditInvoice");
		return obj;
	}
	

	/**
	 * Used for Invoice functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="EmptySOW") 	
	public static Object[][] dataProviderEmptySOW() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","EmptySOW");
		return obj;
	}

	/**
	 * Used for Invoice functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="SplitInvoiceAmnt") 	
	public static Object[][] dataProviderSplitInvoiceAmnt() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","SplitInvoiceAmnt");
		return obj;
	}
	
	
	@DataProvider(name="SplitErrorMSG") 	
	public static Object[][] dataProviderSplitInvoiceErrmsg() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","SplitErrorMSG");
		return obj;
	}

	/**
	 * Used for Invoice functionality in various criteria for each fields/Combo fields
	 * Multiple data would be available in excel
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="EmptyDEL") 	
	public static Object[][] dataProviderEmptyDEL() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","EmptyDEL");
		return obj;
	}
	
	@DataProvider(name="POInvoice") 	
	public static Object[][] dataProviderPOInvoice() throws Throwable
	{		
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);
		Object[][] obj=getSubmitInvoice(f,"Invoice","POInvoice");
		return obj;
	}
	
	
	

	/**
	 * Used for Invoice- 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getSubmitInvoice(File f,String sheetname,String TCkey) throws IOException
	{
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
		for(int i=2;i<=rowcount;i++)
		{
			
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
				HSSFCell ErrorMsg=row.getCell(j);
				if (ErrorMsg == null || ErrorMsg.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { ErrorMsg.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("ErrorMsg",ErrorMsg.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell supplierName=row.getCell(j);
				if (supplierName == null || supplierName.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { supplierName.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("supplierName",supplierName.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell Division=row.getCell(j);
				if (Division == null || Division.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { Division.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("Division",Division.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell InvNum=row.getCell(j);
			if (InvNum == null || InvNum.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InvNum.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvNum", InvNum.getStringCellValue());
			 }
			}
			

			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell InvDate=row.getCell(j);
			if (InvDate == null || InvDate.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InvDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvDate", InvDate.getStringCellValue());
			 }
			}
			
					
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell NetAmnt=row.getCell(j);
			if (NetAmnt == null || NetAmnt.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { NetAmnt.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("NetAmnt", NetAmnt.getStringCellValue());
			 }
			}
		
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell TaxAmnt=row.getCell(j);
			if (TaxAmnt == null || TaxAmnt.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { TaxAmnt.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TaxAmnt", TaxAmnt.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell FreightAmnt=row.getCell(j);
			if (FreightAmnt == null || FreightAmnt.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { FreightAmnt.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("FreightAmnt", FreightAmnt.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell TotalInv=row.getCell(j);
			if (TotalInv == null || TotalInv.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { TotalInv.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TotalInv", TotalInv.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell Currency=row.getCell(j);
			if (Currency == null || Currency.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { Currency.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Currency", Currency.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell Invfile=row.getCell(j);
			if (Invfile == null || Invfile.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { Invfile.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Invfile", Invfile.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SOWNum=row.getCell(j);
			if (SOWNum == null || SOWNum.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SOWNum.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvSOWNum", SOWNum.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell Del=row.getCell(j);
			if (Del == null || Del.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { Del.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvDel", Del.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell PoQuestion=row.getCell(j);
			if (PoQuestion == null || PoQuestion.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { PoQuestion.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("POQuestion", PoQuestion.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell OrgNumber=row.getCell(j);
			if (OrgNumber == null || OrgNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { OrgNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("OrgNumber", OrgNumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell ProjNumber=row.getCell(j);
			if (ProjNumber == null || ProjNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { ProjNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ProjNumber", ProjNumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell AccNumber=row.getCell(j);
			if (AccNumber == null || AccNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { AccNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("AccNumber", AccNumber.getStringCellValue());
			 }
			
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell comment=row.getCell(j);
			if (comment == null || comment.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { comment.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("comment", comment.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell Invtypedrpdown=row.getCell(j);
			if (Invtypedrpdown == null || Invtypedrpdown.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { Invtypedrpdown.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Invtypedrpdown", Invtypedrpdown.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell InvAmount=row.getCell(j);
			if (InvAmount == null || InvAmount.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InvAmount.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InvAmount", InvAmount.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell PONumber=row.getCell(j);
			if (PONumber == null || PONumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { PONumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("PONumber", PONumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell ReceiverNumber=row.getCell(j);
			if (ReceiverNumber == null || ReceiverNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { ReceiverNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ReceiverNumber", ReceiverNumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell LabourCode=row.getCell(j);
			if (LabourCode == null || LabourCode.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { LabourCode.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("LabourCode", LabourCode.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell VendorEmployee=row.getCell(j);
			if (VendorEmployee == null || VendorEmployee.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { VendorEmployee.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("VendorEmployee", VendorEmployee.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell PLC=row.getCell(j);
			if (PLC == null || PLC.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { PLC.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("PLC", PLC.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell hours=row.getCell(j);
			if (hours == null || hours.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { hours.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("hours", hours.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1)
			{
			HSSFCell BatchDescription=row.getCell(j);
			if (BatchDescription == null || BatchDescription.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { BatchDescription.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("BatchDescription", BatchDescription.getStringCellValue());
			 }
			}
			mapsexcel[count-1][0]=map;
			count=count-1;
			
		  //else
	}//if
		
		} //for
		
	}
		return mapsexcel;
		
	
	
	}
}
