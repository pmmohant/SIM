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


public class LoginDataProvider {

	static String fname="Login.xls";
	static String path=File.separator;
	static String dir=LavanteUtils.dir;
	
	/**
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="LoginValidation") 	
	public static Object[][] dataProviderLogin() throws Throwable
	{	
		String directory = LavanteUtils.getPresentWorkingDir();
		File f=new File(directory+path+dir+path+fname);	
		Object[][] obj=getLoginData(f,"LoginValidation","LoginValidation");
		return obj;
	}
	
	
	/**
	 * @author Piramanayagam.S
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getLoginData(File f,String sheetname,String TCkey) throws IOException{
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
					
						
		    
			int	j=3;
			HSSFCell username=row.getCell(j);
			if (username == null || username.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { username.setCellType(Cell.CELL_TYPE_STRING);
				 	{
				 		map.put("username", username.getStringCellValue());
				 	} 
				 }
				
			j=j+1;
			HSSFCell password=row.getCell(j);
			if (password == null || password.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { password.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("password", password.getStringCellValue());
			 }
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell errormsg=row.getCell(j);
			if (errormsg == null || errormsg.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { errormsg.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("errormsg",errormsg.getStringCellValue());
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
