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

public class DynamicSearch {

	static String fname = "DynamicSearch.xls";
	static String path = File.separator;
	static String dir = LavanteUtils.dir;
	
	
	@DataProvider(name = "ClaimsToApprove")
	public static Object[][] dataProviderBasicSearchUser() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSearchAdv(f, "ClaimsToApprove", "ClaimsToApprove");
		return obj;
	}
	
	@DataProvider(name = "SingleClaimsToApprove")
	public static Object[][] dataProviderBasicSearchApprove() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSearchAdv(f, "ClaimsToApprove", "SingleClaimsToApprove");
		return obj;
	}

	/**
	 * Used for User Search Data
	 * 
	 * @author Subhas.BV
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getSearchAdv(File f, String sheetname, String TCkey) throws IOException {
		LinkedHashMap[][] mapsexcel = null;
		FileInputStream fs = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fs);

		HSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = 0;

		rowcount = sheet.getLastRowNum();
	
		// Minus one due to the Object
		int count = 0;
		for (int x = 0; x <= rowcount; x++) {
			HSSFRow val = sheet.getRow(x);
			HSSFCell as = val.getCell(2);
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

			HSSFRow rows = sheet.getRow(1);
			HSSFRow row = sheet.getRow(i);

			HSSFCell cells = row.getCell(2);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {

				
			} else {
				cells.setCellType(Cell.CELL_TYPE_STRING);
				if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

					int j = 0;

					j = 3;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell email = row.getCell(j);
						if (email == null || email.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							email.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SearchFields", email.getStringCellValue());
						}
					}
					
					for(j=4;j<= row.getLastCellNum() - 1;j++){
						
						if (j <= row.getLastCellNum() - 1) {
							HSSFCell ContactName = row.getCell(j);
							if (ContactName == null || ContactName.getCellType() == Cell.CELL_TYPE_BLANK) {
							} else {
								ContactName.setCellType(Cell.CELL_TYPE_STRING);
								String valu=ContactName.getStringCellValue();
								ContactName = rows.getCell(j);
								ContactName.setCellType(Cell.CELL_TYPE_STRING);
								String key=ContactName.getStringCellValue();
								map.put(key,valu );
							}
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
