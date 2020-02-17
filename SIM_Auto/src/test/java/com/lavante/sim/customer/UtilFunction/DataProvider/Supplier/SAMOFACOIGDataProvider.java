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

public class SAMOFACOIGDataProvider {

	static String fname = "SAMOFACOIG.xls";
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
	@DataProvider(name = "DBCountSAM")
	public static Object[][] dataProviderSAM() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSAMData(f, "SAM", "DBCountSAM");
		return obj;
	}

	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Subhas.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "DBCountOFAC")
	public static Object[][] dataProviderOFAC() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSAMData(f, "OFAC", "DBCountOFAC");
		return obj;
	}

	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Subhas.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "DBCountOIG")
	public static Object[][] dataProviderOIG() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSAMData(f, "OIG", "DBCountOIG");
		return obj;
	}

	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Subhas.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "DBCountAddressDetailsUS")
	public static Object[][] dataProviderAddressDetailsUS() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSAMData(f,  "AddressDetails","SupplierLocationUS");
		return obj;
	}	
	
	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Subhas.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "DBCountAddressDetailsNonUS")
	public static Object[][] dataProviderAddressDetailsNonUS() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSAMData(f, "AddressDetails", "SupplierLocationNonUS");
		return obj;
	}	
	
	
	/**
	 * Used for Basic searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Subhas.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "DBCountLegalID")
	public static Object[][] dataProviderDBCountLegalID() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getLegalIDData(f, "LegalID", "LegalIDDBCount");
		return obj;
	}	
	
	
	/**
	 * Used for SupplierSearch- Basic Search Single Data
	 * 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getSAMData(File f, String sheetname, String TCkey) throws IOException {
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

					int j = 2;

					if (j <= row.getLastCellNum() - 1) {
						HSSFCell showinactive = row.getCell(j);
						if (showinactive == null || showinactive.getCellType() == Cell.CELL_TYPE_BLANK) {

						} else {
							showinactive.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ShowInactive", showinactive.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell filterby = row.getCell(j);
						if (filterby == null || filterby.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							filterby.setCellType(Cell.CELL_TYPE_STRING);
							map.put("FilterBY", filterby.getStringCellValue());
						}
					}
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell supname = row.getCell(j);
						if (supname == null || supname.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							supname.setCellType(Cell.CELL_TYPE_STRING);
							map.put("supplierName", supname.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell query = row.getCell(j);
						if (query == null || query.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							query.setCellType(Cell.CELL_TYPE_STRING);
							map.put("QUERY", query.getStringCellValue());
						}
					}

					mapsexcel[count - 1][0] = map;
					count = count - 1;

				} // else
			} // if

		} // for
		return mapsexcel;
	}

	
	/**
	 * Used for SupplierSearch- Basic Search Single Data
	 * 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getLegalIDData(File f, String sheetname, String TCkey) throws IOException {
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

					int j = 2;

					if (j <= row.getLastCellNum() - 1) {
						HSSFCell showinactive = row.getCell(j);
						if (showinactive == null || showinactive.getCellType() == Cell.CELL_TYPE_BLANK) {

						} else {
							showinactive.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ShowInactive", showinactive.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell filterby = row.getCell(j);
						if (filterby == null || filterby.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							filterby.setCellType(Cell.CELL_TYPE_STRING);
							map.put("FilterBY", filterby.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell filtersub = row.getCell(j);
						if (filtersub == null || filtersub.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							filtersub.setCellType(Cell.CELL_TYPE_STRING);
							map.put("FilterSub", filtersub.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell suplocation = row.getCell(j);
						if (suplocation == null || suplocation.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							suplocation.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SupplierLocation", suplocation.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell query = row.getCell(j);
						if (query == null || query.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							query.setCellType(Cell.CELL_TYPE_STRING);
							map.put("QUERY", query.getStringCellValue());
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
