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

public class AccSetupDataProvider {

	static String fname = "SIMAccSetup.xls";
	static String fileSeperator = File.separator;
	static String dir = LavanteUtils.dir;

	/**
	 * used FOR Creation of Sucessfull Account Setup in SIM [First Page] only
	 * Supplier Registeration not covered
	 * 
	 * @author Ramireddy.Nandini
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "AccSetup")
	public static Object[][] dataProviderAccSetup() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + fileSeperator + dir + fileSeperator + fname);
		Object[][] obj = getAccSetupData(f, "AccountSetup", "AccSetup");
		return obj;
	}

	/**
	 *  used FOR Creation of Sucessfull Account Setup in SIM [First Page] only
	 * Supplier Registeration not covered
	 * 
	 * @author Ramireddy.Nandini
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getAccSetupData(File f, String sheetname, String TCkey) throws IOException {
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

			HSSFRow row = sheet.getRow(i);

			HSSFCell cells = row.getCell(2);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {

			} else {
				cells.setCellType(Cell.CELL_TYPE_STRING);
				if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

					int j = 0;

					j = 3;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell preflanguage = row.getCell(j);
						if (preflanguage == null || preflanguage.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							preflanguage.setCellType(Cell.CELL_TYPE_STRING);
							map.put("preflanguage", preflanguage.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell setpass = row.getCell(j);
						if (setpass == null || setpass.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							setpass.setCellType(Cell.CELL_TYPE_STRING);
							map.put("setpass", setpass.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell confirmpass = row.getCell(j);
						if (confirmpass == null || confirmpass.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							confirmpass.setCellType(Cell.CELL_TYPE_STRING);
							map.put("confirmpass", confirmpass.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell chquestion = row.getCell(j);
						if (chquestion == null || chquestion.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							chquestion.setCellType(Cell.CELL_TYPE_STRING);
							map.put("chquestion", chquestion.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell chanswer = row.getCell(j);
						if (chanswer == null || chanswer.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							chanswer.setCellType(Cell.CELL_TYPE_STRING);
							map.put("chanswer", chanswer.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell checkconfirm = row.getCell(j);
						if (checkconfirm == null || checkconfirm.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							checkconfirm.setCellType(Cell.CELL_TYPE_STRING);
							map.put("checkconfirm", checkconfirm.getStringCellValue());
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
