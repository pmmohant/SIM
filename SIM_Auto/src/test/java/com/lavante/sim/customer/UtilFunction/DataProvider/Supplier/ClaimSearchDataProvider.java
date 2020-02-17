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

public class ClaimSearchDataProvider {

	static String fname = "ClaimSearch.xls";
	static String path = File.separator;
	static String dir = LavanteUtils.dir;
	
	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "AdvSearch")
	public static Object[][] dataProviderViewSearch() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getAdvanceSearch(f, "AdvanceSearch", "AdvSearch");
		return obj;
	}
	

	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "AdvSaveSearch")
	public static Object[][] dataProviderAdvSaveSearch() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getAdvanceSearch(f, "AdvanceSearch", "AdvSaveSearch");
		return obj;
	}
	
		
	/**
	 * Used for Advance Search
	 * 
	 * @author Vidya.C
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getAdvanceSearch(File f, String sheetname, String TCkey) throws IOException {
		LinkedHashMap[][] mapsexcel = null;
		FileInputStream fs = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fs);

		HSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = 0;

		rowcount = sheet.getLastRowNum();
		// Minus one due to the Object
		int count = 0;
		for (int x = 1; x <= rowcount; x++) {
			HSSFRow val = sheet.getRow(x);
			HSSFCell as = val.getCell(1);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {

			} else {
				as.setCellType(Cell.CELL_TYPE_STRING);
				if (as.getStringCellValue().equalsIgnoreCase(TCkey)) {

					count++;
					mapsexcel = new LinkedHashMap[count][1];
				}
			}
		}
		for (int i = 2; i <= rowcount; i++) {

			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			HSSFRow row = sheet.getRow(i);

			HSSFCell cells = row.getCell(1);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {

			} else {
				cells.setCellType(Cell.CELL_TYPE_STRING);
				if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

					int j = 1;
					String x="";
					int lastcol=row.getLastCellNum() - 1;
					while(j<=lastcol ){
						j=j+1;
					//if (j <= row.getLastCellNum() - 1) {
						HSSFCell Tab = row.getCell(j);
						if (Tab == null || Tab.getCellType() == Cell.CELL_TYPE_BLANK) {

						} else {
							Tab.setCellType(Cell.CELL_TYPE_STRING);
							x= Tab.getStringCellValue();
						}
						
						j=j+1;
						Tab = row.getCell(j);
						if (Tab == null || Tab.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							Tab.setCellType(Cell.CELL_TYPE_STRING);
							map.put(x, Tab.getStringCellValue());
						}
					}


					mapsexcel[count - 1][0] = map;
					count = count - 1;

				} // else
			} // if

		} // for
		return mapsexcel;
	}

	
	
}
