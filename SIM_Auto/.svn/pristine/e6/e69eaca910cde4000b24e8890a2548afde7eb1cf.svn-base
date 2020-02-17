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

public class MyAccountDataProvider {

	static String fname = "MyAccount.xls";
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
	@DataProvider(name = "ResetPWdErrorMsg")
	public static Object[][] UIResetPWD() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getResetPwd(f, "ResetPwd", "UIResetPwd");
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
	private static LinkedHashMap[][] getResetPwd(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell VerifyMsg = row.getCell(j);
						if (VerifyMsg == null || VerifyMsg.getCellType() == Cell.CELL_TYPE_BLANK) {

						} else {
							VerifyMsg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("VerifyMsg", VerifyMsg.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell CurrentPassword = row.getCell(j);
						if (CurrentPassword == null || CurrentPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							CurrentPassword.setCellType(Cell.CELL_TYPE_STRING);
							map.put("CurrentPassword", CurrentPassword.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell NewPassword = row.getCell(j);
						if (NewPassword == null || NewPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							NewPassword.setCellType(Cell.CELL_TYPE_STRING);
							map.put("NewPassword", NewPassword.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell ConfirmPassword = row.getCell(j);
						if (ConfirmPassword == null || ConfirmPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							ConfirmPassword.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ConfirmPassword", ConfirmPassword.getStringCellValue());
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
