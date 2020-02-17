package com.lavante.sim.customer.TestScripts.Supplier.EditProfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.bytecode.opencsv.CSVReader;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Created on 17-3-2016 Created for Contract Management Test case Enhancement
 * covered SIM Ended on 17-03-2016
 * 
 * @author Piramanayagam.S
 *
 */
public class CMexport {

	 String dir="src"+File.separator+"test"+File.separator+"resources"+File.separator+"data";
	 
	/**
	 * Verify in the Edit page,status field is available or not
	 * 
	 * @param dataMap
	 * @throws InvalidFormatException
	 * @throws IOException
	 *
	 * 
	 */
	@Test
	public void CMExport() throws Exception {
		Reporter.log("Test Started for CM export at:"+ LavanteUtils.currenttime());
		SoftAssert softassert = new SoftAssert();
		Assert.assertEquals(1,1);
		boolean flag=false;
		if(flag==false){
		String folder = LavanteUtils.InitProperties("exportContractManagement");
		
	//	folder = folder + File.separator+"Omnicare";
		System.out.println("FOLDER"+folder);
		
		String name = "e.csv"; LavanteUtils.ServerLatestFile(folder, "csv");
		
		if(name.length()>0){
		
			Reporter.log("SERVER FILE NAME:"+name);
			LavanteUtils.ServerCopyFile(folder, name);

			String[] colheader = new String[43];
			String[] dataheader = new String[43];
			CSVReader csvReaders = new CSVReader(new FileReader(
					LavanteUtils.getPresentWorkingDir() + File.separator+dir+File.separator+  name));
			try {
	
				/*
				 * CSVReader csvReader = new CSVReader(new
				 * FileReader(CommonUtils.getPresentWorkingDir
				 * ()+"\\testdata\\"+name)); String[] row = null; int rowline=0;
				 * while((row = csvReader.readNext()) != null) { rowline++; }
				 */
	
				String[] rows = null;
	
				{
					rows = csvReaders.readNext();
					for (int i = 0; i < 42; i++) {
						colheader[i] = rows[i];
					}
	
					for (int i = 0; i < 42; i++) {
						
						CSVReader csvReadersss = new CSVReader(new FileReader(LavanteUtils.getPresentWorkingDir()+File.separator+dir+File.separator+ name));
						String[] rowse = null;
						rowse = csvReadersss.readNext();
						List<String[]> sx=csvReadersss.readAll();
						System.out.println(sx.size());
						/*for(int ijj=0;ijj<sx.size();ijj++){
							int ads=sx.get(ijj).length;
							String[] yyy=sx.get(ijj);
						//	System.out.println(ads+"ADS");
							for(int up=0;up<ads;up++){
								String xx=yyy[up];
	
								if(xx.length()>0){
								//	System.out.println(xx+"XX");
								}else{
									
									
									
								}
							}
						}*/
						CSVReader csvReaderss = new CSVReader(new FileReader(LavanteUtils.getPresentWorkingDir()+File.separator+dir+File.separator+ name));
						int size=sx.size();
						rowse = csvReaderss.readNext();
						
						int j=0;
						do {
							
							rowse = csvReaderss.readNext();
							dataheader[i] = rowse[i];
							System.out.println(i + colheader[i] + ":"+ dataheader[i]);
							
							j++;
							
						} while (dataheader[i].length() == 0 && (j<size));
						Reporter.log(colheader[i] + ":" + dataheader[i]);
						softassert.assertTrue(dataheader[i].length() > 0);
						softassert.assertTrue(dataheader[i].length() > 0,"Data Not available for the column," + colheader[i]
										+ ":" + dataheader[i]);
						
					}
	
				}


			/*
			 * System.out.println("Sss"); for(int j=0;j<43;j++){
			 * Reporter.log(":"+colheader[j]+":");
			 * Reporter.log(dataheader[j]+":"+colheader[j]+":"+dataheader[j]);
			 * //
			 * softassert.assertTrue(dataheader[j].length()>0,colheader[j]+":"
			 * +dataheader[j]); flag=true; }
			 */

			/*
			 * while((rows = csvReaders.readNext()) != null) {
			 * System.out.println(rows.length); for(int i=0;i<rows.length;i++){
			 * 
			 * if(rows[i].length()>0){ //dataheader[i]=rows[i];
			 * //System.out.println(dataheader[i]); } else{ do{ // while((rows =
			 * csvReaders.readNext()) != null) { rows = csvReaders.readNext();
			 * //System.out.println(rows[i]); //dataheader[i]=rows[i];
			 * 
			 * } }while(rows[i].length()==0);
			 * 
			 * } } }
			 */

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			csvReaders.close();
			softassert.assertAll();
			Reporter.log("Test Ended for CM export at:"	+ LavanteUtils.currenttime());

		} 
		}else {
			softassert.assertTrue(false,"Name is null");
			Reporter.log("Test faile");
		}
		}
	} // Reading Header

	/*
	 * line=br.readLine(); fieldheader = line.split(cvsSplitBy); for(int
	 * i=0;i<fieldheader.length-1;i++){ colheader[i]=fieldheader[i]; }
	 * 
	 * //Reading FirstLine Value line=br.readLine(); fieldValue =
	 * line.split(cvsSplitBy); for(int i=0;i<fieldValue.length-1;i++){ {
	 * data=fieldValue[i]; if(data.length()>0){ dataheader[i]=data; }else{
	 * 
	 * do{ String sline=br.readLine(); String[] sfieldValue =
	 * sline.split(cvsSplitBy); dataheader[i]=sfieldValue[i];
	 * System.out.println(colheader[i]+"SCZXXXXXXXXXXXXXXXXX:"+dataheader[i]);
	 * Reporter.log(colheader[i]+dataheader[i].length());
	 * if(dataheader[i].length()<3){ dataheader[i]=""; }
	 * }while((dataheader[i].length()==0) ); } } }
	 * 
	 * 
	 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch
	 * (IOException e) { e.printStackTrace(); } finally { if (br != null) { try
	 * { br.close(); } catch (IOException e) { e.printStackTrace(); } } }
	 * 
	 * 
	 * for(int i=0;i<50;i++){ String
	 * sd=CommonUtils.Readcsv("SCM_2016_02_28_10_00_01_03.csv",i);
	 * System.out.println(sd); Reporter.log("CSV Column Content"+sd);
	 * softassert.assertTrue(sd.length()>0,"CSV File Content"+sd); flag=true; }
	 */

	// @AfterMethod

	

}
