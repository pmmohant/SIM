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

public class ManageUsers {

	static String fname = "ManageUser.xls";
	static String path = File.separator;
	static String dir = LavanteUtils.dir;

	/**
	 * used FOR Manage User Page using this test data for
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "AddNwUser")
	public static Object[][] dataProviderSingleAddNwUser() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getUserData(f, "AddUser", "AddNwUser");
		return obj;
	}
	
	@DataProvider(name = "SupplierUser")
	public static Object[][] dataProviderSingleSupplierUser() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getUserData(f, "AddUser", "SupplierUser");
		return obj;
	}
	
	@DataProvider(name = "AddNwUserLavSupRole")
	public static Object[][] dataProviderSingleAddNwUserLavSupRole() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getUserData(f, "AddUser", "AddNwUserLavSupRole");
		return obj;
	}

	@DataProvider(name = "AddNwUserRecAccManager")
	public static Object[][] dataProviderSingleAddNwUserRecAccManager() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getUserData(f, "AddUser", "AddNwUserRecAccManager");
		return obj;
	}

	@DataProvider(name = "AddNwUserRecCustomer")
	public static Object[][] dataProviderSingleAddNwUserRecCustomer() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getUserData(f, "AddUser", "AddNwUserRecCustomer");
		return obj;
	}

	@DataProvider(name = "AddNwAddress")
	public static Object[][] dataProviderSingleAddNwAddress() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getDataForAddress(f, "AddAddress", "AddNwAddress");
		return obj;
	}
	
	@DataProvider(name = "UserSearchBasic")
	public static Object[][] dataProviderBasicSearchUser() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSearchUserData(f, "UserSearchBasic", "UserSearchBasic");
		return obj;
	}

	/**
	 * Used for User data
	 * 
	 * @author Subhas.BV
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getUserData(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell ContactName = row.getCell(j);
						if (ContactName == null || ContactName.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							ContactName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ContactName", ContactName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell Email = row.getCell(j);
						if (Email == null || Email.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							Email.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Email", Email.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell CreateAcc = row.getCell(j);
						if (CreateAcc == null || CreateAcc.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							CreateAcc.setCellType(Cell.CELL_TYPE_STRING);
							map.put("CreateAcc", CreateAcc.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell userRole = row.getCell(j);
						if (userRole == null || userRole.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							userRole.setCellType(Cell.CELL_TYPE_STRING);
							map.put("UserRole", userRole.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell invitingorg = row.getCell(j);
						if (invitingorg == null || invitingorg.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							invitingorg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("InvitingOrg", invitingorg.getStringCellValue());
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
	 * Used for User Search Data
	 * 
	 * @author Subhas.BV
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getSearchUserData(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell ContactName = row.getCell(j);
						if (ContactName == null || ContactName.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							ContactName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ContactName", ContactName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell email = row.getCell(j);
						if (email == null || email.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							email.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Email", email.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell contactPhone = row.getCell(j);
						if (contactPhone == null || contactPhone.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							contactPhone.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ContactPhone", contactPhone.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell contactFax = row.getCell(j);
						if (contactFax == null || contactFax.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							contactFax.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ContactFax", contactFax.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell CreateAcc = row.getCell(j);
						if (CreateAcc == null || CreateAcc.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							CreateAcc.setCellType(Cell.CELL_TYPE_STRING);
							map.put("CreateAcc", CreateAcc.getStringCellValue());
						}
					}
					
				
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell userRole = row.getCell(j);
						if (userRole == null || userRole.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							userRole.setCellType(Cell.CELL_TYPE_STRING);
							map.put("UserRole", userRole.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell invitingorg = row.getCell(j);
						if (invitingorg == null || invitingorg.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							invitingorg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("UserGroup", invitingorg.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell invitingorg = row.getCell(j);
						if (invitingorg == null || invitingorg.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							invitingorg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Division", invitingorg.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell invitingorg = row.getCell(j);
						if (invitingorg == null || invitingorg.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							invitingorg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ShowInactive", invitingorg.getStringCellValue());
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
	 * Used for Address data
	 * 
	 * @author Subhas.BV
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getDataForAddress(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell Address1 = row.getCell(j);
						if (Address1 == null || Address1.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							Address1.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Address1", Address1.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell City = row.getCell(j);
						if (City == null || City.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							City.setCellType(Cell.CELL_TYPE_STRING);
							map.put("City", City.getStringCellValue());
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
						HSSFCell PostalCode = row.getCell(j);
						if (PostalCode == null || PostalCode.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							PostalCode.setCellType(Cell.CELL_TYPE_STRING);
							map.put("PostalCode", PostalCode.getStringCellValue());
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
