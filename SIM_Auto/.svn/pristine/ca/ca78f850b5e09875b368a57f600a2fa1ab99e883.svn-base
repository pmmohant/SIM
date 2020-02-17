/*package com.lavante.sim.customer.UtilFunction.DataProvider.Supplier;		

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.lavante.sim.Common.Util.LavanteUtils;

public class ListenerTest implements ITestListener						
{		

	ClaimSearchDataProvider cp=new ClaimSearchDataProvider();
	LavanteUtils lavanteUtils=new LavanteUtils();
    @Override		
    public void onFinish(ITestContext Result) 					
    {		
    	 System.out.println("The onFinish of the testcase failed is :"+Result.getName());    		
    }		

    @Override		
    public void onStart(ITestContext Result)					
    {		
    	 System.out.println("The onStart of the testcase  is :"+Result.getName());	
    	 try {
    		 List<LinkedHashMap<String, String>> LdataMap=new ArrayList<LinkedHashMap<String, String>>();
    		 LdataMap=dataMapCreation(); 
    		 DBQUERY(LdataMap);
    		 
		} catch (Throwable e) {

		}
    	 
    	 
    }	
    
    
    
    public void da(LinkedHashMap<String, String> datamap)					
    {		
    	 try {
    		 datamap= DBQUERY(datamap);
    		 
    		 
		} catch (Throwable e) {

		}
    	 
    	 
    }
    
    public void das(String table,String col,String value){
    	String x="IF NOT EXISTS     "
    			+ " (select * from "+table+" where "+col+" in "
    			+ "     	(Select ClaimTypeID from ClaimType where ClaimType='"+value+"') )"
    			+ "    	BEGIN "
    			+ " DECLARE @ClaimTypeID int "
    			+ "  Select @ClaimTypeID = "+col+" from ClaimType where ClaimType='"+value+"'"
    			+ " Print @ClaimTypeID "
    			+ "	Update "+table+" Set "+col+" = @ClaimTypeID where  "+col+" in (select MAX("+col+") from "+table+" where "+col+"="+col+")"
    			+ "	END" ;
    	
    	
    	
    }
    
    private LinkedHashMap<String, String> DBQUERY( LinkedHashMap<String, String> LdataMap) throws FileNotFoundException, IOException {
    	 LinkedHashMap<String, String> dataMap=new LinkedHashMap<String,String>();
		 for(int i=0;i<LdataMap.size();i++){
			 for(Map.Entry<String, String> en:LdataMap.entrySet()){
				// String yx=LavanteUtils.DBProperties(en.getKey());
				// dataMap.put(yx,en.getValue());
			 }
			
		 }
		 
		 return dataMap;
	}
    

    private void DBQUERY(List< LinkedHashMap<String, String>> LdataMap) throws FileNotFoundException, IOException, SQLException {
    	LinkedHashMap<String, String> ds=new LinkedHashMap<String, String>();
		 for(int i=0;i<LdataMap.size();i++){
			 ds=LdataMap.get(i);
			
			 for(Map.Entry<String, String> en:ds.entrySet()){
				 String fname="ClaimSearch.xls";
				 String path=File.separator;
				 String dir = LavanteUtils.dir;
				 String directory = LavanteUtils.getPresentWorkingDir();
				 File f=new File(directory+path+dir+path+fname);
				String[] DBQUERY=getBasicData(f,"DBQUERY",en.getKey());

				int ji=1;
				String dy=en.getValue();
				if(dy.contains("#")){
					String[] den= dy.split("#");
					dy=den[0];
				} 
				
					if(DBQUERY[ji].contains("VALUE")){
						DBQUERY[ji]=DBQUERY[ji].replace("VALUE", dy);
					}
					String x=lavanteUtils.fetchDBdata(DBQUERY[ji]);
					System.out.println(x);
					if((x==null)||!(x.length()>0)){
						 ji=0;
						if(DBQUERY[ji].contains("VALUE")){
							DBQUERY[ji]=DBQUERY[ji].replace("VALUE", dy);
						}
						lavanteUtils.UpdateDB(DBQUERY[ji]);
					}	
					
			 }
			
		 }
		 
		 
	}

    

    public void DBDBQUERY(LinkedHashMap<String, String> dataMap) throws FileNotFoundException, IOException, SQLException {
    	 String fname="ClaimSearch.xls";
		 String path=File.separator;
		 String dir = LavanteUtils.dir;
		 String directory = LavanteUtils.getPresentWorkingDir();
		 File f=new File(directory+path+dir+path+fname);
		 
			 for(Map.Entry<String, String> en:dataMap.entrySet()){
				
				String[] DBQUERY=getBasicData(f,"DBQUERY",en.getKey());

				int ji=1;
				String dy=en.getValue();
				if(dy.contains("#")){
					String[] den= dy.split("#");
					dy=den[0];
				} 
				
					if(DBQUERY[ji].contains("VALUE")){
						DBQUERY[ji]=DBQUERY[ji].replace("VALUE", dy);
					}
					String x=lavanteUtils.fetchDBdata(DBQUERY[ji]);
					System.out.println(x);
					if((x==null)||!(x.length()>0)){
						 ji=0;
						if(DBQUERY[ji].contains("VALUE")){
							DBQUERY[ji]=DBQUERY[ji].replace("VALUE", dy);
						}
						lavanteUtils.UpdateDB(DBQUERY[ji]);
					}	
					
			 }
		 
	}

    

	*//**
	 * Used for Deliverables-Contract Management - Basic Search 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 *//*
	private String[]  getBasicData(File f,String sheetname,String TCkey) throws IOException{
		String[] xx=new String[10];
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet(sheetname);
		int rowcount=0;
	
		rowcount=sheet.getLastRowNum();
		//Minus one due to the Object
		 int count=0;
		for(int x=0;x<=rowcount;x++) 
    	{  
    		HSSFRow val=sheet.getRow(x);
    		HSSFCell as=val.getCell(0);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else { as.setCellType(Cell.CELL_TYPE_STRING);
					 if(as.getStringCellValue().equalsIgnoreCase(TCkey))
					 {
						
						 count++;
						as=val.getCell(1);
						if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
						 }else { as.setCellType(Cell.CELL_TYPE_STRING);
						 	xx[0]= as.getStringCellValue();
						 	
						}
						
						as=val.getCell(2);
						if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
						 }else { as.setCellType(Cell.CELL_TYPE_STRING);
						 	xx[1]= as.getStringCellValue();
						 	
						}
						
						
						
					 }
						
				}
    
    	}
		
		return xx;
		
	}
	
	
	private List<LinkedHashMap<String, String>>  dataMapCreation() throws Throwable {
    	 Object[][] dataMap=cp.dataProviderViewSearch();
		 List<LinkedHashMap<String, String>> LdataMap=new ArrayList<LinkedHashMap<String, String>>();
		 
		 Object[][] results = dataMap;
		 for (Object[] result : results) {
			 for (Object resultE : result) {
				 LinkedHashMap<String, String> m=new LinkedHashMap<String, String>();
				 String x=resultE.toString();
				 x=x.replace("{", "");
				 x=x.replace("}", "");
				 if (x.contains(",")){
					 String[] y =x.split(",");
					 for(int i=0;i<y.length;i++){
						 if(y[i].contains("=")){
							 String[] zy =y[i].split("=");
							 	m.put(zy[0].trim(), zy[1].trim());
							 	
	    					 }
						 }
					 }else {
						 if(x.contains("=")){
							 	String[] zy =x.split("=");
	    						 m.put(zy[0].trim(), zy[1].trim());
	    					 }
					 }
				 	LdataMap.add(m);
				 }
				
			 }
		 return LdataMap;
	}

	@Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    	 System.out.println("The onTestFailedButWithinSuccessPercentage of the testcase failed is :"+Result.getName());
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The onTestFailure of the testcase failed is :"+Result.getName());					
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The onTestSkipped of the testcase Skipped is :"+Result.getName());					
    }		

    // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    System.out.println(Result.getName()+"onTestStart test case started");					
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The onTestSuccess of the testcase passed is :"+Result.getName());					
    }		

}*/