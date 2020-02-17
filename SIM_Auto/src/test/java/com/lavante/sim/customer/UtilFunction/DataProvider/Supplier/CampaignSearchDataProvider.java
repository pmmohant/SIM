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

public class CampaignSearchDataProvider {

	//NEED TO CHECK THIS CLASS
	
	static String fname = "CampaignSearch.xls";
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
		Object[][] obj = getViewSearch(f, "AdvanceSearch", "AdvSearch");
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

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell InviteORG = row.getCell(j);
						if (InviteORG == null || InviteORG.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							InviteORG.setCellType(Cell.CELL_TYPE_STRING);
							map.put("InviteORG", InviteORG.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell SuppGrp = row.getCell(j);
						if (SuppGrp == null || SuppGrp.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							SuppGrp.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SuppGrp", SuppGrp.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell ProfStatus = row.getCell(j);
						if (ProfStatus == null || ProfStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							ProfStatus.setCellType(Cell.CELL_TYPE_STRING);
							map.put("ProfStatus", ProfStatus.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell InactiveSup = row.getCell(j);
						if (InactiveSup == null || InactiveSup.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							InactiveSup.setCellType(Cell.CELL_TYPE_STRING);
							map.put("InactiveSup", InactiveSup.getStringCellValue());
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
	 * Used for SupplierSearch- Adv Search Single Data 
	 * @author Piramanayagam.S
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getAdvData(File f,String sheetname,String TCkey) throws IOException{
		LinkedHashMap[][] mapsexcel=null;
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		
		HSSFSheet sheet=wb.getSheet(sheetname);
		int rowcount=0;
	
		rowcount=sheet.getLastRowNum();
		//Minus one due to the Object
		 int count=0;
		for(int x=1;x<=rowcount;x++) 
    	{  
    		HSSFRow val=sheet.getRow(x);
    		HSSFCell as=val.getCell(1);
			if (as == null || as.getCellType() == Cell.CELL_TYPE_BLANK) {
			
				 }else { as.setCellType(Cell.CELL_TYPE_STRING);
					 if(as.getStringCellValue().equalsIgnoreCase(TCkey))
					 {
						 count++;
						 mapsexcel = new LinkedHashMap[count][1];
					 }
				}
    	}
		for(int i=2;i<=rowcount;i++){
			
			LinkedHashMap<String, String> map=new LinkedHashMap<String,String>();
			HSSFRow row=sheet.getRow(i);
			
			HSSFCell cells=row.getCell(1);
			if (cells == null || cells.getCellType() == Cell.CELL_TYPE_BLANK) {
			
			}else 
			{ cells.setCellType(Cell.CELL_TYPE_STRING);
			if(cells.getStringCellValue().equalsIgnoreCase(TCkey))
		 {
			
			int j=2;
		
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell Tab=row.getCell(j);
				if (Tab == null || Tab.getCellType() == Cell.CELL_TYPE_BLANK) {
					
				 }else { Tab.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("Tab",Tab.getStringCellValue());
				 }
				}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell SupplierName=row.getCell(j);
			if (SupplierName == null || SupplierName.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { SupplierName.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SupplierName",SupplierName.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell AddressType=row.getCell(j);
			if (AddressType == null || AddressType.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { AddressType.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("AddressType",AddressType.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell CountryAddress=row.getCell(j);
			if (CountryAddress == null || CountryAddress.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { CountryAddress.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("CountryAddress",CountryAddress.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell StateAddress=row.getCell(j);
			if (StateAddress == null || StateAddress.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { StateAddress.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("StateAddress",StateAddress.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell faxDetails=row.getCell(j);
			if (faxDetails == null || faxDetails.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { faxDetails.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("FAX",faxDetails.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell GeoScope=row.getCell(j);
			if (GeoScope == null || GeoScope.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { GeoScope.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("GeoScope",GeoScope.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
			HSSFCell CurrencySearch=row.getCell(j);
			if (CurrencySearch == null || CurrencySearch.getCellType() == Cell.CELL_TYPE_BLANK) {
				
			 }else { CurrencySearch.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Currency",CurrencySearch.getStringCellValue());
			 }
			}
			
			
			//Diversity
					
			j=j+1;
			if(j<=row.getLastCellNum()-1){ 
				HSSFCell diversity=row.getCell(j);
				if (diversity == null || diversity.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { diversity.setCellType(Cell.CELL_TYPE_STRING);
					 map.put("diversity",diversity.getStringCellValue());
				 }
			}
			
			
			//Legal ID
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell countryofReg=row.getCell(j);
			if (countryofReg == null || countryofReg.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { countryofReg.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("RegCountry", countryofReg.getStringCellValue());
			 }
			}
			

			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell usincome=row.getCell(j);
			if (usincome == null || usincome.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { usincome.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("usincome", usincome.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell TaxIDNumber=row.getCell(j);
			if (TaxIDNumber == null || TaxIDNumber.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { TaxIDNumber.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("TaxIDNumber", TaxIDNumber.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell LegalDoc=row.getCell(j);
			if (LegalDoc == null || LegalDoc.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { LegalDoc.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("LegalDoc", LegalDoc.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell LegalDoc=row.getCell(j);
			if (LegalDoc == null || LegalDoc.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { LegalDoc.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("LegalDocStatus", LegalDoc.getStringCellValue());
			 }
			}

			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SuppInsurance=row.getCell(j);
			if (SuppInsurance == null || SuppInsurance.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SuppInsurance.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SuppInsurance", SuppInsurance.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell BusinessEthics=row.getCell(j);
			if (BusinessEthics == null || BusinessEthics.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { BusinessEthics.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("BusinessEthics", BusinessEthics.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell BusinessEthicsUploaded=row.getCell(j);
			if (BusinessEthicsUploaded == null || BusinessEthicsUploaded.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { BusinessEthicsUploaded.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("BusinessEthicsUploaded", BusinessEthicsUploaded.getStringCellValue());
			 }
			}
			
			
			
			//Payment TAB
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell OfferEarlyDiscount=row.getCell(j);
			if (OfferEarlyDiscount == null || OfferEarlyDiscount.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { OfferEarlyDiscount.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("OfferEarlyDiscount", OfferEarlyDiscount.getStringCellValue());
			 }
			}
		
			j=j+1;
			if(j<=row.getLastCellNum()-1){
		
			HSSFCell PaymentType=row.getCell(j);
			if (PaymentType == null || PaymentType.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { PaymentType.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("PaymentType", PaymentType.getStringCellValue());
			 }
			}
			
			//Specific Profile
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell specififcProfile=row.getCell(j);
			if (specififcProfile == null || specififcProfile.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { specififcProfile.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ForeignTaxInfoDocW8Provided", specififcProfile.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell specififcProfile=row.getCell(j);
			if (specififcProfile == null || specififcProfile.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { specififcProfile.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ForeignTaxInfoDocStatus", specififcProfile.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell ProductType=row.getCell(j);
			if (ProductType == null || ProductType.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { ProductType.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ProductType", ProductType.getStringCellValue());
			 }
			}
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell ProductServices=row.getCell(j);
			if (ProductServices == null || ProductServices.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { ProductServices.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ProductServices", ProductServices.getStringCellValue());
			 }
			}
			
			
			
			//Enterprise TAB 
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell ProfStatus=row.getCell(j);
			if (ProfStatus == null || ProfStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { ProfStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ProfStatus", ProfStatus.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell Approved=row.getCell(j);
			if (Approved == null || Approved.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { Approved.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("Approved", Approved.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell CTI=row.getCell(j);
			if (CTI == null || CTI.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { CTI.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("CTI", CTI.getStringCellValue());
			 }
			}
			
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell ValidForm=row.getCell(j);
			if (ValidForm == null || ValidForm.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { ValidForm.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("ValidForm", ValidForm.getStringCellValue());
			 }
			}
			
			//Invite Specific
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell InviteID=row.getCell(j);
			if (InviteID == null || InviteID.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InviteID.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InviteID", InviteID.getStringCellValue());
			 }
			}
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell InviteProfStatus=row.getCell(j);
			if (InviteProfStatus == null || InviteProfStatus.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { InviteProfStatus.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("InviteProfStatus", InviteProfStatus.getStringCellValue());
			 }
			}
			
			//End of Invite
			
			j=j+1;
			if(j<=row.getLastCellNum()-1){
			HSSFCell SuppGrp=row.getCell(j);
			if (SuppGrp == null || SuppGrp.getCellType() == Cell.CELL_TYPE_BLANK) {
			 }else { SuppGrp.setCellType(Cell.CELL_TYPE_STRING);
				 map.put("SuppGrp", SuppGrp.getStringCellValue());
			 }
			}
			
			
			mapsexcel[count-1][0]=map;
			count=count-1;
			
		 } //else
	}//if
		
		} //for
		return mapsexcel;
	}

	
	/**
	 * Used for AlertJobs
	 * 
	 * @author Subhas.BV
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getAlertJobsData(File f, String sheetname, String TCkey) throws IOException {
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
						HSSFCell entity = row.getCell(j);
						if (entity == null || entity.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							entity.setCellType(Cell.CELL_TYPE_STRING);
							map.put("Entity", entity.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell savedQuery = row.getCell(j);
						if (savedQuery == null || savedQuery.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							savedQuery.setCellType(Cell.CELL_TYPE_STRING);
							map.put("SavedQuery", savedQuery.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell AddressType = row.getCell(j);
						if (AddressType == null || AddressType.getCellType() == Cell.CELL_TYPE_BLANK) {

						} else {
							AddressType.setCellType(Cell.CELL_TYPE_STRING);
							map.put("AlertName", AddressType.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell emailSub = row.getCell(j);
						if (emailSub == null || emailSub.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							emailSub.setCellType(Cell.CELL_TYPE_STRING);
							map.put("EmailSubject", emailSub.getStringCellValue());
						}
					}

					// Legal ID
					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell RoleOption = row.getCell(j);
						if (RoleOption == null || RoleOption.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							RoleOption.setCellType(Cell.CELL_TYPE_STRING);
							map.put("RoleAndOption", RoleOption.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell useroption = row.getCell(j);
						if (useroption == null || useroption.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							useroption.setCellType(Cell.CELL_TYPE_STRING);
							map.put("UserAndOption", useroption.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell FreqOption = row.getCell(j);
						if (FreqOption == null || FreqOption.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							FreqOption.setCellType(Cell.CELL_TYPE_STRING);
							map.put("FrequencyAndOption", FreqOption.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {

						HSSFCell startdate = row.getCell(j);
						if (startdate == null || startdate.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							startdate.setCellType(Cell.CELL_TYPE_STRING);
							map.put("StartDate", startdate.getStringCellValue());
						}
					}

					j = j + 1;
					if (j <= row.getLastCellNum() - 1) {
						HSSFCell alertFormat = row.getCell(j);
						if (alertFormat == null || alertFormat.getCellType() == Cell.CELL_TYPE_BLANK) {
						} else {
							alertFormat.setCellType(Cell.CELL_TYPE_STRING);
							map.put("AlertTemplateFormat", alertFormat.getStringCellValue());
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
	 * Used for View Search
	 * 
	 * @author Vidya.C
	 * @param file
	 * @param sheetname
	 * @param TCkey
	 * @return Two dimension array object
	 * @throws IOException
	 */
	private static LinkedHashMap[][] getViewSearch(File f, String sheetname, String TCkey) throws IOException {
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
