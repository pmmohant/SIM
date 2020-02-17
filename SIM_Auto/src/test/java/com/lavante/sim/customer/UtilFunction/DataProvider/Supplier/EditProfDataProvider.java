package com.lavante.sim.customer.UtilFunction.DataProvider.Supplier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;

import com.lavante.sim.Common.Util.LavanteUtils;

public class EditProfDataProvider {

	static String fname = "EditProfile.xls";
	static String path = File.separator;
	static String dir = LavanteUtils.dir;

	/**
	 * Used for Single searching functionality in various criteria for each
	 * fields/Combo fields Multiple data would be available in excel
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "UploadInsurance")
	public static Object[][] dataProviderSingleBasicSearch() throws Throwable {

		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = uploadInsurance(f, "Insurance", "UploadInsurance");
		return obj;
	}

	@DataProvider(name = "SpecificContacts")
	public static Object[][] dataProviderSpecificContacts() throws Throwable {

		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = sendEmail(f, "SendEmail", "SpecificContacts");
		return obj;
	}

	@DataProvider(name = "SendEmail")
	public static Object[][] dataProviderSendEmail() throws Throwable {

		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = sendEmail(f, "SendEmail", "SendEmail");
		return obj;
	}

	@DataProvider(name = "AttachEmail")
	public static Object[][] dataProviderAttachEmail() throws Throwable {

		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = sendEmail(f, "SendEmail", "AttachEmail");
		return obj;
	}

	@DataProvider(name = "USINCOMEYES")
	public static Object[][] dataProviderUSINCOMEYES() throws Throwable {

		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = LegalID(f, "LegalID", "USINCOMEYES");
		return obj;
	}

	@DataProvider(name = "AddLocation")
	public static Object[][] dataProviderAddLocation() throws Throwable {

		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = locationContact(f, "Contacts", "AddLocation");
		return obj;
	}

	/**
	 * Used for Upload Insurance - Basic Search
	 * 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] uploadInsurance(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell NameOfInsurance = row.getCell(j);
						if (NameOfInsurance == null || NameOfInsurance.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							NameOfInsurance.setCellType(Cell.CELL_TYPE_STRING);
							map.put("InsuranceName", NameOfInsurance.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell policytype = row.getCell(j);
						if (policytype == null || policytype.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							policytype.setCellType(Cell.CELL_TYPE_STRING);
							map.put("policytype", policytype.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell policyNum = row.getCell(j);
						if (policyNum == null || policyNum.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							policyNum.setCellType(Cell.CELL_TYPE_STRING);
							map.put("policyNum", policyNum.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell effectiveDate = row.getCell(j);
						if (effectiveDate == null || effectiveDate.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							effectiveDate.setCellType(Cell.CELL_TYPE_STRING);
							map.put("effectiveDate", effectiveDate.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {

						HSSFCell expirationDate = row.getCell(j);
						if (expirationDate == null || expirationDate.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							expirationDate.setCellType(Cell.CELL_TYPE_STRING);
							map.put("expirationDate", expirationDate.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell coverageLimit = row.getCell(j);
						if (coverageLimit == null || coverageLimit.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							coverageLimit.setCellType(Cell.CELL_TYPE_STRING);
							map.put("coverageLimit", coverageLimit.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell coverageLimit = row.getCell(j);
						if (coverageLimit == null || coverageLimit.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							coverageLimit.setCellType(Cell.CELL_TYPE_STRING);
							map.put("CurrencyType", coverageLimit.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell uploadInsurance = row.getCell(j);
						if (uploadInsurance == null || uploadInsurance.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							uploadInsurance.setCellType(Cell.CELL_TYPE_STRING);
							map.put("uploadInsurance", uploadInsurance.getStringCellValue());
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
	 * Used for Send Email
	 * 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] sendEmail(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell mailFrom = row.getCell(j);
						if (mailFrom == null || mailFrom.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							mailFrom.setCellType(Cell.CELL_TYPE_STRING);
							map.put("mailFrom", mailFrom.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell mailTemplate = row.getCell(j);
						if (mailTemplate == null || mailTemplate.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							mailTemplate.setCellType(Cell.CELL_TYPE_STRING);
							map.put("mailTemplate", mailTemplate.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell mailSubject = row.getCell(j);
						if (mailSubject == null || mailSubject.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							mailSubject.setCellType(Cell.CELL_TYPE_STRING);
							map.put("mailSubject", mailSubject.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell mailMessage = row.getCell(j);
						if (mailMessage == null || mailMessage.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							mailMessage.setCellType(Cell.CELL_TYPE_STRING);
							map.put("mailMessage", mailMessage.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {

						HSSFCell attachFile = row.getCell(j);
						if (attachFile == null || attachFile.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							attachFile.setCellType(Cell.CELL_TYPE_STRING);
							map.put("attachFile", attachFile.getStringCellValue());
						}
					}
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {

						HSSFCell attachFile = row.getCell(j);
						if (attachFile == null || attachFile.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							attachFile.setCellType(Cell.CELL_TYPE_STRING);
							map.put("LocationType", attachFile.getStringCellValue());
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
	 * Used for LegaL ID
	 * 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] LegalID(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell usIncome = row.getCell(j);
						if (usIncome == null || usIncome.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							usIncome.setCellType(Cell.CELL_TYPE_STRING);
							map.put("usIncome", usIncome.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell businessName = row.getCell(j);
						if (businessName == null || businessName.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							businessName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("businessName", businessName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell EINNum = row.getCell(j);
						if (EINNum == null || EINNum.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							EINNum.setCellType(Cell.CELL_TYPE_STRING);
							map.put("EINNum", EINNum.getStringCellValue());
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
	 * Used for Profile- Location Contact Info
	 * 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] locationContact(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell ERPID = row.getCell(j);
						if (ERPID == null || ERPID.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							ERPID.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ERPID", ERPID.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell LocationType = row.getCell(j);
						if (LocationType == null || LocationType.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							LocationType.setCellType(Cell.CELL_TYPE_STRING);
							map.put("LocationType", LocationType.getStringCellValue());
						}
					}

					j = j + 1;
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

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell Name = row.getCell(j);
						if (Name == null || Name.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							Name.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Name", Name.getStringCellValue());
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

					mapsexcel[count - 1][0] = map;
					count = count - 1;

				} // else
			} // if

		} // for
		return mapsexcel;
	}

}
