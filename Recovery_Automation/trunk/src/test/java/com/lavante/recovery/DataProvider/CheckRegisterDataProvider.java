package com.lavante.recovery.DataProvider;

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

import com.lavante.recovery.Common.Util.LavanteUtils;

public class CheckRegisterDataProvider {

	static String fname = "CheckRegister.xls";
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
	@DataProvider(name = "CheckRegister")
	public static Object[][] dataProviderBasicSearch() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getBasicData(f, "CheckRegister", "CheckRegister");
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
	private static LinkedHashMap[][] getBasicData(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell SupplierID = row.getCell(j);
						if (SupplierID == null || SupplierID.getCellType() == Cell.CELL_TYPE_BLANK) {

						} else {
							SupplierID.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SupplierID", SupplierID.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell supplierName = row.getCell(j);
						if (supplierName == null || supplierName.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							supplierName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("supplierName", supplierName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell SpendRankFrm = row.getCell(j);
						if (SpendRankFrm == null || SpendRankFrm.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							SpendRankFrm.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SpendRankFrm", SpendRankFrm.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell SpendRankTo = row.getCell(j);
						if (SpendRankTo == null || SpendRankTo.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							SpendRankTo.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SpendRankTo", SpendRankTo.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {

						HSSFCell BusinessContact = row.getCell(j);
						if (BusinessContact == null || BusinessContact.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							BusinessContact.setCellType(Cell.CELL_TYPE_STRING);
							map.put("BusinessContact", BusinessContact.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell Country = row.getCell(j);
						if (Country == null || Country.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							Country.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Country", Country.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell State = row.getCell(j);
						if (State == null || State.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							State.setCellType(Cell.CELL_TYPE_STRING);
							map.put("State", State.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell TaxID = row.getCell(j);
						if (TaxID == null || TaxID.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							TaxID.setCellType(Cell.CELL_TYPE_STRING);
							map.put("TaxID", TaxID.getStringCellValue());
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
