package com.lavante.recovery.Common.Util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;



public class GridReportEmail {
	
	static LavanteUtils lavanteUtils=new LavanteUtils();
	static String fname = "GridResult.xls";
	static String path = File.separator;
	static String dir = "QATestData" + File.separator  + "data";
	static String foldername="20170913";
	static String htmlfname="C://Users//Piramanayagam.S//Music//"+foldername+"/"+"/html/overview.html";
    
     
	@Test
	public static void main() throws InterruptedException, Exception, Throwable
	{
		
		String overall=null;
		String overallPassed=null;
		String overallFailed=null;
		String overallSkipped=null;
		

		String directory = LavanteUtils.getPresentWorkingDir();
		String file=directory + path + dir + path + fname;
		File fs = new File(file);
		 HSSFWorkbook workbook = new HSSFWorkbook();
		 
		 HSSFSheet sheet = workbook.createSheet(foldername);
		 HSSFFont fontBold = workbook.createFont();
	     fontBold.setBold(true);
	        
	     HSSFFont fontItalic = workbook.createFont();
	     fontItalic.setItalic(true);
	     
		 
	     	Row row = sheet.createRow(0);
	       //Create a new cell in current row
	       Cell cell = row.createCell(0);
	       Cell cell1 = row.createCell(1);
	       Cell cell2 = row.createCell(2);
	       Cell cell3 = row.createCell(3);
	       Cell cell4 = row.createCell(4);
	       Cell cell5 = row.createCell(5);
	       Cell cell6 = row.createCell(6);
	       Cell cell7 = row.createCell(7);
	       Cell cell8 = row.createCell(8);
	       Cell cell9 = row.createCell(9);
	       
	       //Set value to new value
	       cell.setCellValue("Module");
	       cell1.setCellValue("IE");
	       cell4.setCellValue("Firefox ");
	       cell7.setCellValue("Chrome ");
	       
	       sheet.addMergedRegion(new CellRangeAddress(0,0,1,3));
	       sheet.addMergedRegion(new CellRangeAddress(0,0,4,6));
	       sheet.addMergedRegion(new CellRangeAddress(0,0,7,9));
	       
	        row = sheet.createRow(1);
	       //Create a new cell in current row
	        cell = row.createCell(0);
	        cell1 = row.createCell(1);
	        cell2 = row.createCell(2);
	        cell3 = row.createCell(3);
	        cell4 = row.createCell(4);
	        cell5 = row.createCell(5);
	        cell6 = row.createCell(6);
	        cell7 = row.createCell(7);
	        cell8 = row.createCell(8);
	        cell9 = row.createCell(9);
	       
	       //Set value to new value
	       cell1.setCellValue(" Passed");
	       cell2.setCellValue(" Skipped");
	       cell3.setCellValue(" Failed");
	       cell4.setCellValue(" Passed");
	       cell5.setCellValue(" Skipped");
	       cell6.setCellValue(" Failed");
	       cell7.setCellValue(" Passed");
	       cell8.setCellValue(" Skipped");
	       cell9.setCellValue(" Failed");
	       
	       
	     
		   String content = "";
		    try {
		    	
		    	
		    	File f=new File(htmlfname);
		    	if(f.exists()==true)
		    	{
			    	FileReader s=new FileReader(f);
			    	
			        BufferedReader in = new BufferedReader(s);
			        
			        String str;
			        while ((str = in.readLine()) != null) {
			            content +=str;	
			        }
			        in.close();
		    	}
		    } catch (IOException e) { System.out.println(e);
		    }
		    	
		    String findStr = "<div class=\"suiteLinks\">";
		    int totalmodule=StringUtils.countMatches(content, findStr);

		    System.out.println("TOTAL MODULE:"+totalmodule);
		    
		   if(content.contains("overviewTable")){
			   if(content.contains("<tr class=\"test\">")){
				   String[] hsuite=content.split("overviewTable");
				   for(int i=1;i<hsuite.length;i++){
					   
				        row = sheet.createRow(i+1);
				        sheet.setColumnWidth(0,12000);
				        cell = row.createCell(0);
				       //Create a new cell in current row
				        cell1 = row.createCell(1);
				        cell1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell1.setCellType(CellStyle.BORDER_DASHED);
				        cell2 = row.createCell(2);
				        cell2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell3 = row.createCell(3);				        
				        cell3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell4 = row.createCell(4);
				        cell4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);				        
				        cell5 = row.createCell(5);
				        cell5.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell6 = row.createCell(6);
				        cell6.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell7 = row.createCell(7);
				        cell7.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell8 = row.createCell(8);
				        cell8.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				        cell9 = row.createCell(9);
				        cell9.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					   
					   String[] ahsuite=hsuite[i].split("<div class=\"suiteLinks\">");
				    	String[] ahptc=ahsuite[1].split("</th>");
				    	String[] ahptc1=ahptc[0].split("</div> ");
				    	String[] csuite=hsuite[i].split("<tr class=\"test\">");
				    	for(int j=1;j<csuite.length;j++){
				    		String[] psut=csuite[j].split("</td>");
				    		String[] bp=psut[0].split(".html\">");
				    		String[] pp=psut[2].split("number\">");
				    		String[] sp=psut[3].split("number\">");
				    		String[] fp=psut[4].split("number\">");
				    		String[] br=bp[1].split("</a>");
				    		
				    		
				    		String x =ahptc1[1];
				    		HSSFRichTextString richString = new HSSFRichTextString(x);
					        richString = new HSSFRichTextString(x);
					        cell.setCellType(CellStyle.BORDER_DASHED);
					        richString.applyFont(0,x.length(),fontItalic);
					        cell.setCellValue( richString );
				    		
					 //      cell.setCellValue(br[0]);
					 //      cell.setCellValue(ahptc1[1]);
					       if(br[0].contains("IE")){
					    	   cell1.setCellValue(new Double(pp[1]));
					    	   cell2.setCellValue(new Double(sp[1]));
					    	   cell3.setCellValue(new Double(fp[1]));
					       }else if(br[0].contains("Fire")){

					    	   cell4.setCellValue(new Double(pp[1]));
					    	   cell5.setCellValue(new Double(sp[1]));
					    	   cell6.setCellValue(new Double(fp[1]));
					       }else {

					    	   cell7.setCellValue(new Double(pp[1]));
					    	   cell8.setCellValue(new Double(sp[1]));
					    	   cell9.setCellValue(new Double(fp[1]));
					       }
					       

					       try {
					    	   if(!fs.exists()){
					    		   fs.createNewFile();
					    	   }
								FileOutputStream out = new FileOutputStream(fs);
								workbook.write(out);
								out.close();
								
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					  }
				   }
				   
				   int modulecount=hsuite.length+1;
				   int totRow=1;
				   int totalrow=modulecount+totRow;
				   
				    row = sheet.createRow(totalrow);
			       //Create a new cell in current row
			        cell = row.createCell(0);
			        cell.setCellValue(" ");
			        String x ="Total";
			        HSSFRichTextString richString = new HSSFRichTextString(x);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue(richString );
			        
			        cell = row.createCell(1);
			        String strFormula= "SUM(B1:B"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(2);
			         strFormula= "SUM(C1:C"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(3);
			         strFormula= "SUM(D1:D"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(4);
			         strFormula= "SUM(E1:E"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(5);
			         strFormula= "SUM(F1:F"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(6);
			         strFormula= "SUM(G1:G"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(7);
			         strFormula= "SUM(H1:H"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        cell = row.createCell(8);
			         strFormula= "SUM(I1:I"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);			      
			        cell = row.createCell(9);
			         strFormula= "SUM(J1:J"+modulecount+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        
			        totalrow=totalrow+1;
			        int total=modulecount+4;
			        row = sheet.createRow(total);
			        
			        x ="Total Tests";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        strFormula= "SUM(A"+totalrow+":J"+totalrow+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        
			        row = sheet.createRow(modulecount+5);
			        x ="Total Passed";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        overallPassed= "SUM(B"+totalrow+"+E"+totalrow+"+H"+totalrow+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(overallPassed);
			        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			        CellValue cellValue = evaluator.evaluate(cell);
			        overallPassed=""+cellValue.getNumberValue();
			        overallPassed=overallPassed.replace(".0", "");
			        
			        row = sheet.createRow(modulecount+6);
			        x ="Total Skipped";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        overallSkipped= "SUM(C"+totalrow+"+F"+totalrow+"+I"+totalrow+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(overallSkipped);
			        cellValue = evaluator.evaluate(cell);
			        overallSkipped=""+cellValue.getNumberValue();
			        overallSkipped=overallSkipped.replace(".0", "");
			        
			        row = sheet.createRow(modulecount+7);
			        x ="Total Failed";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        overallFailed= "SUM(D"+totalrow+"+G"+totalrow+"+J"+totalrow+")";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(overallFailed);
			        cellValue = evaluator.evaluate(cell);
			        overallFailed=""+cellValue.getNumberValue();
			        overallFailed=overallFailed.replace(".0", "");
			       
			        row = sheet.createRow(modulecount+8);
			        x ="IE Browsers Pass Percentage";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        strFormula= "B"+(totalrow)+"/SUM(B"+totalrow+"+C"+totalrow+"+D"+totalrow+")*100";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        			        
			        row = sheet.createRow(modulecount+9);
			        x ="FireFox Browsers Pass Percentage";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        strFormula= "E"+(totalrow)+"/SUM(E"+totalrow+"+F"+totalrow+"+G"+totalrow+")*100";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        
			        row = sheet.createRow(modulecount+10);
			        x ="Chrome Pass Percentage";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        strFormula= "H"+(totalrow)+"/SUM(H"+totalrow+"+I"+totalrow+"+J"+totalrow+")*100";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(strFormula);
			        
			        row = sheet.createRow(modulecount+11);
			        x ="All 3 Browsers Pass Percentage";
			        richString = new HSSFRichTextString(x);
			        cell = row.createCell(3);
			        richString.applyFont(0,x.length(),fontBold);
			        cell.setCellValue( richString );
			        
			        cell = row.createCell(4);
			        overall= "E"+(total+2)+"/E"+(total+1)+"*100";
			        cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			        cell.setCellFormula(overall);
			        cellValue = evaluator.evaluate(cell);
			        overall=""+Math.round(cellValue.getNumberValue());
			 
			        FileOutputStream out = new FileOutputStream(fs);
					workbook.write(out);
					out.close();
					
				  System.out.println(fs);
			   }
		   }
		    
		   String emailTo = lavanteUtils.InitProperties("emailToAddress");
		   String[] t=null;
		   if(emailTo.contains("#")){
			   String[] sp=emailTo.split("#");
			   t=new String[sp.length];
			   for(int i=0;i<sp.length;i++){
				   t[i]=sp[i];
			   }
			   
		   }else{
			   t=new String[1];
			   t[0]=emailTo;
		   }
		   
		   String emailCc = lavanteUtils.InitProperties("emailCCAddress");
		   String[] cc=null;
		   if(emailCc!=null){
			   if(emailCc.contains("#")){
				   String[] sp=emailCc.split("#");
				   cc=new String[sp.length];
				   for(int i=0;i<sp.length;i++){
					   cc[i]=sp[i];
				   }
				   
			   }else{
				   cc=new String[1];
				   cc[0]=emailCc;
			   }
		   }
			
			
			Date today = new Date();
			SimpleDateFormat DateFormats = new SimpleDateFormat("dd-MM-yy");//hh-mm-ss a
    		String date = DateFormats.format(today);
    		String sub="Recovery-Automation Nightly Run,Status:"+date;
    		
    		int AllCount=Integer.parseInt(overallPassed)+Integer.parseInt(overallFailed)+Integer.parseInt(overallSkipped);
    		
    		String msg="Hi,\n \t The Test Execution Completed sucessfully at " +date + ", and Grid Report is generated ," +
    				" Publishing the Grid report with the pass rate of  " +overall+ "% .\n \t Summary as follows, \n \t" +
    						"  1.No of Total Test   :   "+AllCount+" \n \t" +
    						"  2.No of Passed Test  :   "+overallPassed+" \n \t" +
    						"  3.No of Skipped Test :   "+overallSkipped+" \n \t" +
    						"  4.No of Failed Test  :   "+overallFailed+" \n \t" +
    						"\n  Find the Attachment for your Reference \n \n Thanks,\n \t Automation Team" ;
  
			email(t,cc,sub,file,msg);
			
			System.out.println("Sent email sucess");
			
		    		
	      }
		     

	
	public static void email(String[] to, String[] cc, String sub, String filename,String msgbody) throws Exception, InterruptedException, Throwable {

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		// Generating the Email Subject randomly & passing it to emailcreation()
		// method

		

		// Reading Data from init properties
		
		String SMTP_HOST_NAME = lavanteUtils.InitProperties("SMTP_HOST_NAME");
		String SMTP_HOST_PORT = lavanteUtils.InitProperties("SMTP_HOST_PORT");
		String SMTP_AUTH_USER = lavanteUtils.InitProperties("SMTP_AUTH_USER");
		String SMTP_AUTH_PWD = lavanteUtils.InitProperties("SMTP_AUTH_PWD");
		String SMTP_HOST_PROTOCAL = lavanteUtils.InitProperties("SMTP_HOST_PROTOCAL");
		String emailFromAddress = lavanteUtils.InitProperties("emailFromAddress");

		boolean isAuthenticationRequired = true;

		// Set the host smtp address

		Properties props = new Properties();
		props.setProperty("mail.smtp.host",SMTP_HOST_NAME);
		props.setProperty("mail.smtp.port",SMTP_HOST_PORT);
		props.setProperty("mail.smtp.protocal",SMTP_HOST_PROTOCAL);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.timeout", "60000");
		props.put("mail.smtp.connectiontimeout", "60000");

		props.setProperty("mail.smtp.auth", Boolean
				.toString(isAuthenticationRequired));

		if (SMTP_AUTH_USER != null && !SMTP_AUTH_USER.trim().equals(""))

			props.setProperty("mail.smtp.username", SMTP_AUTH_USER);

		if (SMTP_AUTH_PWD != null && !SMTP_AUTH_PWD.trim().equals(""))

			props.setProperty("mail.smtp.password", SMTP_AUTH_PWD);
		Session session = Session.getInstance(props);
		// Session session = Session.getInstance(props, new
		// MailAuthenticator(emailFromAddress, SMTP_AUTH_PWD));
		
		 props.put("mail.smtp.port",SMTP_HOST_PORT); 
		
		 Transport mailTransport = session.getTransport(SMTP_HOST_PROTOCAL);
		 mailTransport.connect(SMTP_HOST_NAME, SMTP_AUTH_USER,SMTP_AUTH_PWD);
			System.out.println("Mail Connected");
		MimeMessage msg = new MimeMessage(session);
		
		props.put("mail.smtps.auth", "true");
		props.put("mail.debug", "true");

		// set the from address
		InternetAddress addressFrom = new InternetAddress(emailFromAddress);

		// Attachment
		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Fill the message
		messageBodyPart.setText(msgbody);

		// Create a multipart message
		Multipart multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);
		messageBodyPart = new MimeBodyPart();

		// Attachment
		if (!filename.equalsIgnoreCase("")) {
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("GridReport"+lavanteUtils.randomnum()+".xls");
			multipart.addBodyPart(messageBodyPart);
		}
		msg.setContent(multipart);
		// End of Attachment

		// Setting the Subject and Content Type
		msg.setSubject(sub);

		// msg.setContent(message, "text/html");
		msg.setHeader("X-Priority", "1");

		// From ID
		msg.setFrom(addressFrom);

		// Setting CC ID
		if (cc != null) {
			for (int j = 0; j < cc.length; j++) {
				InternetAddress ccid = new InternetAddress(cc[j]);
				msg.addRecipient(Message.RecipientType.CC, ccid);
			}
		}
		
		// Setting TO ID
		if (to != null) {
			for (int i = 0; i < to.length; i++) {
				InternetAddress toid = new InternetAddress(to[i]);
				msg.addRecipient(Message.RecipientType.TO, toid);
				if (filename.equalsIgnoreCase("")) {
					System.out.println("Sucessfully sent mail to: " + to[i]
							+ " With subject: " + sub);
				} else if (!filename.equalsIgnoreCase("")) {
					System.out.println("Sucessfully sent mail to: " + to[i]
							+ " With subject: " + sub + " With Attachment: "
							+ filename);
				}
			}
			/*
			 * //Setting BCC ID if (bcc != null){ for( int k = 0; k<to.length;
			 * k++) { InternetAddress bccid = new InternetAddress(bcc[k]);
			 * msg.addRecipient(Message.RecipientType.BCC, bccid); } }
			 */
			
			

			try {
				mailTransport.sendMessage(msg, msg.getAllRecipients());
				mailTransport.close();				
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}
	}
     
		   

	
}
		


