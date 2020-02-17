package lavante.recovery.DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import lavante.recovery.utilities.seleniumBaseClass;

public class CreditTableDataProvider {

	//static File f=new File("D:\\AutomationWs\\SIM_TRUNK\\testdata\\SupplierSearch.xls");
	static String fname="CreditTableData.xlsx";
	static String path=File.separator;
	static String dir="src"+File.separator+"test"+File.separator+"resources"+File.separator+"data";
	
	/**
	 * User for entering credits in credit table
	 * Multiple data would be available in excel
	 * @author Srikanth
	 * Date: 23-09-2016
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name="EnterCredits") 	
	public static Object[][] dataProviderEnterCreditsinCreditTable() throws Throwable
	{		
		String directory = seleniumBaseClass.getPresentWorkingDir();
		File f=new File(directory+"\\src\\test\\resources\\data\\" + fname);
		Object[][] obj=getBasicData(f,"CreditTable","EnterCredits");
		return obj;
	}
		
	/**
	 * D:\Recovery_Auto_Workspace\Recovery_Automation\RequestLetterLogo.jpg
	 * Used for SupplierSearch- Basic SeaD:\Recovery_Auto_Workspace\Recovery_Automation\RequestLetterLogo.jpgrch Single Data 
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
		XSSFWorkbook wb= new XSSFWorkbook(fs);
		
		XSSFSheet sheet=wb.getSheet(sheetname);
		int rowcount=0;
	
		rowcount=sheet.getLastRowNum();
		System.out.println("ROWCOUNT:"+rowcount);
		//Minus one due to the Object
		 int count=0;
		for(int x=1;x<=rowcount;x++) 
    	{  
    		XSSFRow val=sheet.getRow(x);
    		XSSFCell as=val.getCell(1);
    		 System.out.println(x+":"+as.getStringCellValue());
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else { as.setCellType(Cell.CELL_TYPE_STRING);
					 System.out.println(TCkey+x+"$:"+as.getStringCellValue());
					 if(as.getStringCellValue().equalsIgnoreCase(TCkey))
					 {
						 count++;
						 mapsexcel = new LinkedHashMap[count][1];
					 }
						
				}
    
    	}

		for(int i=2;i<=rowcount;i++){
			
			LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
			XSSFRow row=sheet.getRow(i);
			
			XSSFCell cells=row.getCell(1);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
			
			}else 
			{ cells.setCellType(Cell.CELL_TYPE_STRING);
			 System.out.println(i+":"+cells.getStringCellValue());
			if(cells.getStringCellValue().equalsIgnoreCase(TCkey))
		 {
			
			int j=2;
		
			if(j<=row.getLastCellNum()-1){ 
			XSSFCell SupplierRef=row.getCell(j);
			if (SupplierRef == null || SupplierRef.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { SupplierRef.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SupplierRef",SupplierRef.getStringCellValue());
			 }
			}
					
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				XSSFCell Customer=row.getCell(j);
				if (Customer == null || Customer.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { Customer.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("Customer",Customer.getStringCellValue());
				 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			XSSFCell CreditDate=row.getCell(j);
			if (CreditDate == null || CreditDate.getCellType() == Cell.CELL_TYPE_BLANK) {
				//map.put("MSATYPE", "");
			 }else { CreditDate.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("CreditDate", CreditDate.getStringCellValue());
			 }
			}
			

			j=j+1;
			if(j<=row.getLastCellNum()-1){
			XSSFCell Amount=row.getCell(j);
			if (Amount == null || Amount.getCellType() == Cell.CELL_TYPE_BLANK) {
				//map.put("MSATYPE", "");
			 }else { Amount.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Amount", Amount.getStringCellValue());
			 }
			}
			
					
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			XSSFCell Type=row.getCell(j);
			if (Type == null || Type.getCellType() == Cell.CELL_TYPE_BLANK) {
				//map.put("SOWStartDate", "");
			 }else { Type.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Type", Type.getStringCellValue());
			 }
			}
		
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			XSSFCell Currency=row.getCell(j);
			if (Currency == null || Currency.getCellType() == Cell.CELL_TYPE_BLANK) {
				//map.put("SOWInternalContact", "");
			 }else { Currency.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Currency", Currency.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			XSSFCell BusinessUnit=row.getCell(j);
			if (BusinessUnit == null || BusinessUnit.getCellType() == Cell.CELL_TYPE_BLANK) {
				//map.put("SOWInternalContact", "");
			 }else { BusinessUnit.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("BusinessUnit", BusinessUnit.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			XSSFCell Submit=row.getCell(j);
			if (Submit == null || Submit.getCellType() == Cell.CELL_TYPE_BLANK) {
			
			 }else { Submit.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Submit", Submit.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			XSSFCell Link=row.getCell(j);
			if (Link == null || Link.getCellType() == Cell.CELL_TYPE_BLANK) {
				j=j+1;
			 }else { Link.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Link", Link.getStringCellValue());
			 }
			}
			
			System.out.println("MAP:"+map);
			System.out.println("MINUS ONE FOR COUNT:"+count);
			mapsexcel[count-1][0]=map;
			count=count-1;
			System.out.println("DONE"+i);
			
		 } 
	}
		
		} 
	
		return mapsexcel;
	}
	
}
