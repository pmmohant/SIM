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

public class SupplierRegistrationDataProvider {

	static String fname = "SupplierRegistration.xls";
	static String path = File.separator;
	static String dir = LavanteUtils.dir;

	/**
	 * Used for filling details in Invite New Supplier
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "InviteNewSupplier")
	public static Object[][] dataProviderInviteNewSupplier() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "InviteNewSupplier");
		return obj;
	}
	
	/**
	 * Used for filling details in Invite New Supplier
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "InviteNewSuppliers")
	public static Object[][] dataProviderInviteNewSuppliers() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "InviteNewSuppliers");
		return obj;
	}
	
	/**
	 * Used for filling details in SIM Supplier Setup page
	 * 
	 * @author Srikanth
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "AccRegistration")
	public static Object[][] dataProviderSIMSupplierSetup() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSupplierRegistration(f, "AccRegistration", "AccRegistration");
		return obj;
	}
	
	/**
	 * Used for Validating error messages in Supplier Registration page for mandatory fields
	 * 
	 * @author Srikanth
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "ValidateErrorMessage")
	public static Object[][] dataProviderValidateErrMessage() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSupplierRegistration(f, "AccRegistration", "ValidateErrorMessage");
		return obj;
	}
	
	@DataProvider(name = "AccSetup")
	public static Object[][] de() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSupplierAccSetup(f, "SimAccSetup", "AccSetup");
		return obj;
	}

	
	/**
	 * Used for filling details in Account Registration
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "InviteNwSup")
	public static Object[][] dataProviderInviteNwSup() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "InviteNwSup");
		return obj;
	}
	
	/**
	 * Used for filling details in Account Registration
	 * 
	 * @author Piramanayagam.S
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "LegalIDInviteNwSup")
	public static Object[][] dataProviderLegalInviteNwSup() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSupplierRegistration(f, "AccRegistration", "LegalIDInviteNwSup");
		return obj;
	}
	
	
	/**
	 * Used for filling details in Prescreen supplier
	 * 
	 * @author Subhash.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "PreScreen")
	public static Object[][] dataProviderPreScreenNwSup() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "PreScreen");
		return obj;
	}
	
	
	/**
	 * Used for filling details in RecoveryManager invite new supplier
	 * 
	 * @author Subhash.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "RecoveryManagerInviteSupplier")
	public static Object[][] dataProviderRecoveryManagerInviteSupplier() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "RecoveryManagerInviteSupplier");
		
		System.out.println("Object in RecoveryManagerInviteSupplier" + obj);
		return obj;
	}
	

	/**
	 * Used for filling details in RecoveryManager invite new supplier
	 * 
	 * @author Subhash.BV
	 * @return
	 * @throws Throwable
	 */
	@DataProvider(name = "InviteSup")
	public static Object[][] dataProviderInviteSupp() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "InviteSup");
		
		System.out.println("Object in RecoveryManagerInviteSupplier" + obj);
		return obj;
	}
	@DataProvider(name = "InviteSupplierEmail")
	public static Object[][] dataProviderInviteSupplierEmail() throws Throwable {
		String directory = LavanteUtils.getPresentWorkingDir();
		File f = new File(directory + path + dir + path + fname);
		Object[][] obj = getSData(f, "InviteNewSupplier", "InviteSupplierEmail");
		
		System.out.println("Object in RecoveryManagerInviteSupplier" + obj);
		return obj;
	}
	
	
	/**
	 * Used for Filling Supplier data in Invite New Supplier
	 * 
	 * @author Subhas.BV
	 * @param f
	 * @param sheetname
	 * @param TCkey
	 * @return
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getSData(File f, String sheetname, String TCkey) throws IOException {
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
		
		for (int i = 1; i <= rowcount; i++) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

			HSSFRow row = sheet.getRow(i);

			HSSFCell cells = row.getCell(2);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
					
			} 
			else {
				cells.setCellType(Cell.CELL_TYPE_STRING);
				if (cells.getStringCellValue().equalsIgnoreCase(TCkey) ) {

					int j = 0;

					j = 3;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell suppName = row.getCell(j);
						if (suppName == null || suppName.getCellType() == Cell.CELL_TYPE_BLANK) {
							
						} else {
							suppName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("supplierName", suppName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell contactName = row.getCell(j);
						if (contactName == null || contactName.getCellType() == Cell.CELL_TYPE_BLANK) {
						
						} else {
							contactName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("contactName", contactName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell contactEmail = row.getCell(j);
						if (contactEmail == null || contactEmail.getCellType() == Cell.CELL_TYPE_BLANK) {
						
						} else {
							contactEmail.setCellType(Cell.CELL_TYPE_STRING);
							map.put("email", contactEmail.getStringCellValue());
						}
					}


					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell supplierGrp = row.getCell(j);
						if (supplierGrp == null || supplierGrp.getCellType() == Cell.CELL_TYPE_BLANK) {
						
						} else {
							supplierGrp.setCellType(Cell.CELL_TYPE_STRING);
							map.put("suppgrp", supplierGrp.getStringCellValue());
							
						}
					}
					

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell invitingOrg = row.getCell(j);
						if (invitingOrg == null || invitingOrg.getCellType() == Cell.CELL_TYPE_BLANK) {
							
						} else {
							invitingOrg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("inviteorg", invitingOrg.getStringCellValue());
							
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell reason = row.getCell(j);
						if (reason == null || reason.getCellType() == Cell.CELL_TYPE_BLANK) {
							
						} else {
							reason.setCellType(Cell.CELL_TYPE_STRING);
							map.put("reason", reason.getStringCellValue());
							
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
						HSSFCell Address2 = row.getCell(j);
						if (Address2 == null || Address2.getCellType() == Cell.CELL_TYPE_BLANK) {
							
						} else {
							Address2.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Address2", Address2.getStringCellValue());
							
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
					mapsexcel[count - 1][0] = map;
					count = count - 1;

				} // else
			} // if
			
			

		} // for
		return mapsexcel;
	}
	
		


	private static LinkedHashMap[][] getSupplierAccSetup(File f, String sheetname, String TCkey) throws IOException {
		LinkedHashMap[][] mapsexcel = null;
		
		System.out.println(f + sheetname + TCkey);
		FileInputStream fs = new FileInputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook(fs);

		HSSFSheet sheet = wb.getSheet(sheetname);
		int rowcount = 0;

		rowcount = sheet.getLastRowNum();
		// Minus one due to the Object
		int count = 0;
		for (int x = 0; x <= rowcount; x++) {
			HSSFRow val = sheet.getRow(x);
			HSSFCell as = val.getCell(1);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {

			} else {
				as.setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(as.getStringCellValue()  + "" + TCkey);
				if (as.getStringCellValue().equalsIgnoreCase(TCkey)) {

					count++;
					mapsexcel = new LinkedHashMap[count][1];
				}

			}

		}
		

		for (int i = 1; i <= rowcount; i++) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

			HSSFRow row = sheet.getRow(i);

			HSSFCell cells = row.getCell(1);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
					
			} 
			else {
				cells.setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(cells.getStringCellValue());
				if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

					int j = 0;

					j = 2;
					
					

				}
			}
					
//------------Supplier Acc Setup---------------------------------------------------------------------------------->
						
					for (i = 1; i <= rowcount; i++) {
						
						  row = sheet.getRow(i);

						  cells = row.getCell(1);
						if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
								
						} 
						else {
							cells.setCellType(Cell.CELL_TYPE_STRING);
							System.out.println(cells.getStringCellValue());
							if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

								int j = 0;

								j = 2;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell preferredLanguage = row.getCell(j);
									if (preferredLanguage == null || preferredLanguage.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										preferredLanguage.setCellType(Cell.CELL_TYPE_STRING);
										map.put("preflanguage", preferredLanguage.getStringCellValue());
									}
								}
								
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell setPassword = row.getCell(j);
									if (setPassword == null || setPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										setPassword.setCellType(Cell.CELL_TYPE_STRING);
										map.put("setpass", setPassword.getStringCellValue());
									}
								}
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell confirmPassword = row.getCell(j);
									if (confirmPassword == null || confirmPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										confirmPassword.setCellType(Cell.CELL_TYPE_STRING);
										map.put("confirmpass", confirmPassword.getStringCellValue());
									}
								}
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell challengeQues = row.getCell(j);
									if (challengeQues == null || challengeQues.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										challengeQues.setCellType(Cell.CELL_TYPE_STRING);
										map.put("chquestion", challengeQues.getStringCellValue());
									}
								}
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell challengeAns = row.getCell(j);
									if (challengeAns == null || challengeAns.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										challengeAns.setCellType(Cell.CELL_TYPE_STRING);
										map.put("chanswer", challengeAns.getStringCellValue());
									}
								}
								
								/*mapsexcel[count - 1][0] = map;
								count = count - 1;*/
							} //else close
						}  //for close
					
					} 
	
					
		
//----------------------------------------------------------
					
					sheet = wb.getSheet("InviteNewSupplier");
					 rowcount = 0;

					rowcount = sheet.getLastRowNum();
					// Minus one due to the Object
					 count = 0;
					 
						for (int x = 0; x <= rowcount; x++) {
							HSSFRow val = sheet.getRow(x);
							HSSFCell as = val.getCell(2);
							if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {

							} else {
								as.setCellType(Cell.CELL_TYPE_STRING);
								System.out.println(as.getStringCellValue()  + "" + TCkey);
								if (as.getStringCellValue().equalsIgnoreCase(TCkey)) {

									count++;
									mapsexcel = new LinkedHashMap[count][1];
								}

							}

					}
					
					for (i = 1; i <= rowcount; i++) {
						//LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
						   row = sheet.getRow(i);

						   cells = row.getCell(2);
						if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
								
						} 
						else {
							cells.setCellType(Cell.CELL_TYPE_STRING);
							System.out.println(cells.getStringCellValue());
							if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

								int j = 0;

								j = 3;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell suppName = row.getCell(j);
									if (suppName == null || suppName.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										suppName.setCellType(Cell.CELL_TYPE_STRING);
										map.put("supplierName", suppName.getStringCellValue());
									}
								}

								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell contactName = row.getCell(j);
									if (contactName == null || contactName.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										contactName.setCellType(Cell.CELL_TYPE_STRING);
										map.put("contactName", contactName.getStringCellValue());
									}
								}

								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell contactEmail = row.getCell(j);
									if (contactEmail == null || contactEmail.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										contactEmail.setCellType(Cell.CELL_TYPE_STRING);
										map.put("email", contactEmail.getStringCellValue());
									}
								}

/*								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell invitingOrg = row.getCell(j);
									if (invitingOrg == null || invitingOrg.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										invitingOrg.setCellType(Cell.CELL_TYPE_STRING);
										map.put("inviteorg", invitingOrg.getStringCellValue());
										
									}
								}*/

								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell supplierGrp = row.getCell(j);
									if (supplierGrp == null || supplierGrp.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										supplierGrp.setCellType(Cell.CELL_TYPE_STRING);
										map.put("suppgrp", supplierGrp.getStringCellValue());
										
									}
								}
								
								/*								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell reason = row.getCell(j);
									if (reason == null || reason.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										reason.setCellType(Cell.CELL_TYPE_STRING);
										map.put("reason", reason.getStringCellValue());
									}
								}
								
								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell SendInvite = row.getCell(j);
									if (SendInvite == null || SendInvite.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										SendInvite.setCellType(Cell.CELL_TYPE_STRING);
										map.put("suppInvitebtn", SendInvite.getStringCellValue());
									}
								}
								*/
								mapsexcel[count - 1][0] = map;
								count = count - 1;
							}
								
							}
						
	}
					wb.close();
					//return mapsexcel;
}
		return mapsexcel;
}
	


	private static LinkedHashMap[][] getSupplierRegistration(File f, String sheetname, String TCkey) throws IOException {
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
			HSSFCell as = val.getCell(1);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {

			} else {
				as.setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(as.getStringCellValue()  + "" + TCkey);
				if (as.getStringCellValue().equalsIgnoreCase(TCkey)) {

					count=count+1;
					mapsexcel = new LinkedHashMap[count][1];
				}

			}

		}
		

		for (int i = 1; i <= rowcount; i++) {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

			HSSFRow row = sheet.getRow(i);

			HSSFCell cells = row.getCell(1);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
					
			} 
			else {
				cells.setCellType(Cell.CELL_TYPE_STRING);
				System.out.println(cells.getStringCellValue());
				if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

					int j = 0;

					j = 2;
					
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell errmsg = row.getCell(j);
						if (errmsg == null || errmsg.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							errmsg.setCellType(Cell.CELL_TYPE_STRING);
							map.put("errmsg", errmsg.getStringCellValue());
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell contactName = row.getCell(j);
						if (contactName == null || contactName.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							contactName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("contactName", contactName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell country = row.getCell(j);
						if (country == null || country.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							country.setCellType(Cell.CELL_TYPE_STRING);
							map.put("country", country.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell companyLegalName = row.getCell(j);
						if (companyLegalName == null || companyLegalName.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							companyLegalName.setCellType(Cell.CELL_TYPE_STRING);
							map.put("companyLegalName", companyLegalName.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell tinNumber = row.getCell(j);
						if (tinNumber == null || tinNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							tinNumber.setCellType(Cell.CELL_TYPE_STRING);
							map.put("tinNumber", tinNumber.getStringCellValue());
							
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell USIncomeOption = row.getCell(j);
						if (USIncomeOption == null || USIncomeOption.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							USIncomeOption.setCellType(Cell.CELL_TYPE_STRING);
							map.put("USIncomeOption", USIncomeOption.getStringCellValue());
							
						}
					}
					
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell VATNumber = row.getCell(j);
						if (VATNumber == null || VATNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
							map.get(j);
						} else {
							VATNumber.setCellType(Cell.CELL_TYPE_STRING);
							map.put("VATNumber", VATNumber.getStringCellValue());
							
						}
					}

				
			
					
//------------Supplier Acc Setup---------------------------------------------------------------------------------->
					sheet = wb.getSheet("SimAccSetup");

					rowcount = sheet.getLastRowNum();
					// Minus one due to the Object
					// count = 0;
				
				/*	for (int x = 0; x <= rowcount; x++) {
							HSSFRow val = sheet.getRow(x);
							HSSFCell as = val.getCell(1);
							if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {

							} else {
								as.setCellType(Cell.CELL_TYPE_STRING);
								System.out.println(as.getStringCellValue()  + "" + TCkey);
								if (as.getStringCellValue().equalsIgnoreCase(TCkey)) {

									count++;
									mapsexcel = new LinkedHashMap[count][1];
								}

							}

					}*/
						
					
					for (i = 1; i <= rowcount; i++) {
						  row = sheet.getRow(i);

						  cells = row.getCell(1);
						if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
								
						} 
						else {
							cells.setCellType(Cell.CELL_TYPE_STRING);
							System.out.println(cells.getStringCellValue());
							if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

								j = 2;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell preferredLanguage = row.getCell(j);
									if (preferredLanguage == null || preferredLanguage.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										preferredLanguage.setCellType(Cell.CELL_TYPE_STRING);
										map.put("preflanguage", preferredLanguage.getStringCellValue());
									}
								}
								
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell setPassword = row.getCell(j);
									if (setPassword == null || setPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										setPassword.setCellType(Cell.CELL_TYPE_STRING);
										map.put("setpass", setPassword.getStringCellValue());
									}
								}
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell confirmPassword = row.getCell(j);
									if (confirmPassword == null || confirmPassword.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										confirmPassword.setCellType(Cell.CELL_TYPE_STRING);
										map.put("confirmpass", confirmPassword.getStringCellValue());
									}
								}
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell challengeQues = row.getCell(j);
									if (challengeQues == null || challengeQues.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										challengeQues.setCellType(Cell.CELL_TYPE_STRING);
										map.put("chquestion", challengeQues.getStringCellValue());
									}
								}
								
								j = j+1;
								if (j <= row.getLastCellNum() - 1) {
									
									System.out.println("Acc Setup columns" + row.getLastCellNum());
									HSSFCell challengeAns = row.getCell(j);
									if (challengeAns == null || challengeAns.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										challengeAns.setCellType(Cell.CELL_TYPE_STRING);
										map.put("chanswer", challengeAns.getStringCellValue());
									}
								}
								
								/*mapsexcel[count - 1][0] = map;
								count = count - 1;*/
							} //else close
						}  //for close
					
					} 
	
					
		
//-----------------------------Invite New Supplier -----------------------------
					
					sheet = wb.getSheet("InviteNewSupplier");

					rowcount = sheet.getLastRowNum();
					// Minus one due to the Object
					 
					/*	for (int x = 0; x <= rowcount; x++) {
							HSSFRow val = sheet.getRow(x);
							HSSFCell as = val.getCell(2);
							if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {

							} else {
								as.setCellType(Cell.CELL_TYPE_STRING);
								System.out.println(as.getStringCellValue()  + "" + TCkey);
								if (as.getStringCellValue().equalsIgnoreCase(TCkey)) {

									count++;
									mapsexcel = new LinkedHashMap[count][1];
								}

							}

					}*/
					
					for (i = 1; i <= rowcount; i++) {
						//LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
						   row = sheet.getRow(i);

						   cells = row.getCell(2);
						if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
								
						} 
						else {
							cells.setCellType(Cell.CELL_TYPE_STRING);
							System.out.println(cells.getStringCellValue());
							if (cells.getStringCellValue().equalsIgnoreCase(TCkey)) {

								j = 3;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell suppName = row.getCell(j);
									if (suppName == null || suppName.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										suppName.setCellType(Cell.CELL_TYPE_STRING);
										map.put("supplierName", suppName.getStringCellValue());
									}
								}

								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell contactName = row.getCell(j);
									if (contactName == null || contactName.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										contactName.setCellType(Cell.CELL_TYPE_STRING);
										map.put("contactName", contactName.getStringCellValue());
									}
								}

								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell contactEmail = row.getCell(j);
									if (contactEmail == null || contactEmail.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										contactEmail.setCellType(Cell.CELL_TYPE_STRING);
										map.put("email", contactEmail.getStringCellValue());
									}
								}

								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell supplierGrp = row.getCell(j);
									if (supplierGrp == null || supplierGrp.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										supplierGrp.setCellType(Cell.CELL_TYPE_STRING);
										map.put("suppgrp", supplierGrp.getStringCellValue());
										
									}
								}
								
								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell invitingOrg = row.getCell(j);
									if (invitingOrg == null || invitingOrg.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										invitingOrg.setCellType(Cell.CELL_TYPE_STRING);
										map.put("inviteorg", invitingOrg.getStringCellValue());
										
									}
								}

								
								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell reason = row.getCell(j);
									if (reason == null || reason.getCellType() == Cell.CELL_TYPE_BLANK) {
									} else {
										reason.setCellType(Cell.CELL_TYPE_STRING);
										map.put("reason", reason.getStringCellValue());
									}
								}
								
								/*			
								
								j = j + 1;
								if (j <= row.getLastCellNum() - 1) {
									HSSFCell SendInvite = row.getCell(j);
									if (SendInvite == null || SendInvite.getCellType() == Cell.CELL_TYPE_BLANK) {
										map.get(j);
									} else {
										SendInvite.setCellType(Cell.CELL_TYPE_STRING);
										map.put("suppInvitebtn", SendInvite.getStringCellValue());
									}
								}
								*/
								mapsexcel[count - 1][0] = map;
								count = count - 1;
							}
								
							}
					}
	}
			}
					wb.close();
					//return mapsexcel;
}
		return mapsexcel;
}
	
}


