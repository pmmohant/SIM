package com.lavante.sim.Common.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;


public class CommonUtils {

	public static Connection con=null;
	public static Statement stmt=null;	
	public static ResultSet rs=null;
	public static com.jcraft.jsch.Session session = null;
	 
	static {
		System.out.println(currenttime());
	}
	
	/**
	 * Waiting for the particular time
	 * @author Piramanayagam.S
	 * @param time
	 */
	public static  void waitForTime(int time) {
		try{
			Long t=(long) time;
			Thread.sleep(t);
		}catch(Exception e){
			
		}
	}
	
	/**
	 * getPresentWorkingDir() method contains set of instructions to get the
	 * current working directory
	 * 
	 * @throws IOException
	 * @param
	 * @return String CurrentWorkingDirectory
	 */
	public static String getPresentWorkingDir() throws IOException {
		File directory = new File(".");
	//	Pattern p = Pattern.compile("\\\\");
	//	Pattern p1 = Pattern.compile("/");
	//	Matcher m = p.matcher(directory.getAbsolutePath());
	//	Matcher m1 = p1.matcher(directory.getAbsolutePath());
	//	boolean result = m.find() || m1.find();
	//	System.out.println("GPD"+result);
		//D:\QA-Automation\Workspace\SIM_NewFrameWork\conf\initConfig.properties

	//	if (result) {
		//	directory = new File("/");
	//	}
		System.out.println("Get Present"+directory.getCanonicalPath());
		return directory.getCanonicalPath();
	}

	/**
	 * readProperties() method contains set of instructions to read the
	 * properties file where 'Filename' is the actual file which has to be read
	 * and 'Folder' is the location of this file.
	 * 
	 * @throws FileNotFoundException
	 *             , IOException
	 * @param String
	 *            Filename, String Folder
	 * @return 
	 * @return Properties AllProperties
	 */
	public static  Properties  readProperties(String Filename, String Folder){
		Properties props = new Properties();
		try {
		//	File config_file = new File(Folder + "//" + Filename);
			String directory = getPresentWorkingDir();
			System.out.println(directory);
			File config_file = new File(directory + File.separator + Folder +File.separator + Filename);
			System.out.println(config_file);
			props.load(new FileInputStream(config_file));
		} catch (FileNotFoundException e) {
	
		} catch (IOException e) {
	
		}
		return props;
	}

	/**
	 * currenttime() method contains set of instructions to show the
	 * current system time.
	 * 
	 * @throws Null  
	 * @Returns String[]           
	 * @param
	 */	
	public  static String currenttime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormats = new SimpleDateFormat("hh:mm:ss");
		String CurrentDates = DateFormats.format(cal.getTime());
		String time[] = CurrentDates.split(":");
		String hmstime=time[0]+time[1]+time[2];
		return hmstime;
	}

	/**
	 * InitProperties() method contains set of instructions to read the content of Initproperties file
	 * and gives back the Value after reading the Specified content
	 * 
	 * @author Piramanayagam.S
	 * @throws Null  
	 * @Returns String Value           
	 * @param String toread which is in the Initproperties file
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * 
	 */	
	public static String InitProperties(String toread) throws FileNotFoundException, IOException {
	
		Properties config = CommonUtils.readProperties("initConfig.properties", "conf");
		String value = config.getProperty(toread);
		return value;
	}
	
	/**
	 * Random Num Generator based on the Range
	 * 
	 * @author Piramanayagam.S
	 * @param i
	 * @return integer
	 */
	public static int randomnum(int i) {
		
		int rand=0;
		Random r=new Random();
		while(rand==0){
			rand=r.nextInt(i);
		}
		
		return rand;
	}
	
	/** Randomnum Generator from Currenttime
	 * @author Piramanayagam.S
	 * @param null
	 * @return String , time 
	 */
	public static String randomnum() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * Connect DB -Connect DB 
	 * @author Piramanayagam.S
	 * @return Statement 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static Statement ConnectDB() throws FileNotFoundException, IOException{
		String dbUrl=InitProperties("sim.dbURL");
		String dbUser=InitProperties("sim.dbUser");
		String dbPass=InitProperties("sim.dbPass");
		int port =Integer.parseInt(InitProperties("sim.dbport"));
		
		String dbName=InitProperties("sim.dbName");
	

		try {
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setUser(dbUser);
			ds.setPassword(dbPass);
			ds.setServerName(dbUrl);
			ds.setPortNumber(port);
			ds.setDatabaseName(dbName);
			con = (SQLServerConnection) ds.getConnection();
			stmt = (SQLServerStatement) con.createStatement();
			
		}catch(Exception e){
		}
		
		return stmt;
	}
	
	/**
	 * FetchDBdata run query in the SQL
	 * 
	 * @author Piramanayagam.S
	 * @param query
	 * @return String ,single value from Database
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static String fetchDBdata(String query) throws FileNotFoundException, IOException, SQLException  {
		
			String result=null;
			
			stmt=ConnectDB();
			rs=null;
			rs = (SQLServerResultSet) stmt.executeQuery(query);
			while(rs.next())
			{
				result=rs.getString(1);
				System.out.println(result+"FRM DB");
			}
			CloseDB();
		
		return result;
	}

	/**
	 * Update DB with the given Query
	 * @author Piramanayagam.S
	 * @param Query
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws SQLException 
	 */
	public static int UpdateDB(String Query) throws FileNotFoundException, IOException, SQLException{
		
		Statement stmt=ConnectDB();
		
		int rs=stmt.executeUpdate(Query);
		System.out.println("QUERY:"+Query);
		CloseDB();
		return rs;
		
		
	}
	
	/**
	 * Close DB connection After Connection
	 * @author Piramanayagam.S
	 * @throws SQLException
	 */
	private static void CloseDB() throws SQLException {
		if(rs!=null){
			rs.close();
		}	
		if(stmt!=null){
			stmt.close();
		}
		if(con!=null){
			con.close();
		}
		
		
		
		
	}
	
	/**
	 * getCustomIDQuery method for getting the Custom field ID from Database 
	 * 
	 * @author Piramanayagam.S
	 * @param UTFString,Page
	 * @param page
	 * @return
	 * @throws IOException
	 */
	public static String getCustomIDQUERY(String UTFString,String page) throws IOException{
		String id="";
		
		String query="select UIFieldId FROM CFE_Definition as c where c.Label_i18nKey in "
				+ "(select i18nKey from UserTranslation where LanguageID='50'  and "
				+ "UTFString like '%"+UTFString+"%' and LanguageID='50')  and CFE_PageInfoID='"+page+"';";
		try {
			id=CommonUtils.fetchDBdata(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	/**
	 * Read Excel return the sheet when filename given
	 * @author Piramanayagam.S
	 * @param Fname
	 * @param Sheetname
	 * @return
	 * @throws IOException
	 */
	public static HSSFSheet ReadExcel(String Fname,String Sheetname) throws IOException{
		
		File f=new File(getPresentWorkingDir()+File.separator+"testdata"+File.separator+Fname);
		FileInputStream fs=new FileInputStream(f);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet(Sheetname);
		
		return sheet;
	}
	
	public static String[] ReadExcelField(String fname, String sheetname,	String comment) throws IOException {
		String[] val=new String[3];
		 String sname="";
		HSSFSheet sheet=ReadExcel(fname,sheetname);
		int rowcount=sheet.getLastRowNum();
		outr:for(int x=0;x<=rowcount;x++) 
    	{  
			HSSFRow rows= sheet.getRow(x);
			HSSFCell cel=rows.getCell(0);
			String colval=cel.getStringCellValue();
			if(colval.equalsIgnoreCase(comment)){
				HSSFCell uname=rows.getCell(1);
				String unames=uname.getStringCellValue();
				HSSFCell pwd=rows.getCell(2);
				String pwds=pwd.getStringCellValue();
				HSSFCell snames=rows.getCell(3);
				if (snames != null ) {
						snames.setCellType(Cell.CELL_TYPE_STRING);
				 		sname=snames.getStringCellValue();
				 }
				/*if (snames == null || snames.getCellType() == Cell.CELL_TYPE_BLANK) {
				 }else { snames.setCellType(Cell.CELL_TYPE_STRING);
				 		sname=snames.getStringCellValue();
				 }*/
				
				val[0]=unames;
				val[1]=pwds;
				val[2]=sname;
				break outr;
			}
    		
    	}
		return val;
	}

	
	
	/**
	 * To Read Email From GMAIL BOX
	 * @author Piramanayagam.S
	 * @return
	 */
	public static String Readmail(){
		
		String Subject=null;
					
		String SMTP_HOST_NAME ="pop.gmail.com";
		String SMTP_HOST_PORT = "995";
		final String SMTP_AUTH_USER = "simsupplierqa42@gmail.com";
		final String SMTP_AUTH_PWD = "lavante123";
		String SMTP_HOST_PROTOCAL = "ON";
		final String emailFromAddress = "simsupplierqa42@gmail.com";
		
		boolean isAuthenticationRequired = true;
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.host",SMTP_HOST_NAME);
		props.setProperty("mail.smtp.port",SMTP_HOST_PORT);
		props.setProperty("mail.smtp.protocal",SMTP_HOST_PROTOCAL);

		props.put("mail.smtp.timeout", "60000");
		props.put("mail.smtp.connectiontimeout", "60000");
		props.put("mail.smtp.auth", "true"); 
		props.setProperty("mail.smtp.auth", Boolean
				.toString(isAuthenticationRequired));	
		if (SMTP_AUTH_USER != null && !SMTP_AUTH_USER.trim().equals(""))

			props.setProperty("mail.smtp.username", SMTP_AUTH_USER);

		if (SMTP_AUTH_PWD != null && !SMTP_AUTH_PWD.trim().equals(""))

			props.setProperty("mail.smtp.password", SMTP_AUTH_PWD);
		try {
	        Session session = Session.getInstance(props, new javax.mail.Authenticator()
	        {             
	            protected PasswordAuthentication getPasswordAuthentication() 
	            {                   
	            return new PasswordAuthentication(emailFromAddress,SMTP_AUTH_PWD);               
	            }       
	          });
	        try{

	            System.out.println("CONNECTED to Mail Box");
	         }catch(Exception e)
	         {
	        	 System.out.println("EX");
	         }
	        Store store = session.getStore("imaps");
	        store.connect(SMTP_HOST_NAME, emailFromAddress, SMTP_AUTH_PWD);
	        Folder inbox = store.getFolder("INBOX");
	       
	        System.out.println("Total Messages: " + inbox.getMessageCount());
	        System.out.println("New Messages: " + inbox.getNewMessageCount());
	        System.out.println("Unread Messages: " + inbox.getUnreadMessageCount());

	        if(!(inbox.getNewMessageCount()>0))
	        {
	        	try{
	        		waitForTime(4000);
	            }catch(Exception e)
	            {
	           	 
	            }
	        } 
	        
	        inbox.open(Folder.READ_ONLY);
	         
	        FlagTerm ft=new FlagTerm(new Flags(Flags.Flag.SEEN),false);
	        Message message[]=inbox.search(ft);
	       
	         
	        for(int i=0;i<=message.length-1;i++)
	         {
	        	System.out.println(Subject+(i+1)+":"+message[i].getSubject()+"\n");
	         
	         	if(message[i].getSubject().equalsIgnoreCase(Subject)){
	         		Subject=message[i].getSubject();
	         	}

	         }
	      
	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }
	    System.out.println(Subject);

		
		return Subject;
		
		
	}
	
	/**
	 * To Create Copy of Any file
	 *@author Piramanayagam.S 
	 * @return
	 * @throws IOException 
	 */
	public static String CopyFile(String orgfile) throws IOException{
		System.out.println(orgfile);
		//For File format
		String[] nwfile=orgfile.split("\\.");
		String nfile=CommonUtils.randomnum()+"."+nwfile[1];
		System.out.println("COPY:"+nfile);
		File srcfile=new File(getPresentWorkingDir()+File.separator+"testdata"+File.separator+orgfile);
		File destfile=new File(getPresentWorkingDir()+File.separator+"testdata"+File.separator+nfile);
		
		FileUtils.copyFile(srcfile, destfile);
		System.out.println("COPIED File:"+destfile);
		
		return nfile;
	}
	
	/***
	 * To Edit CSV- First row will retain and Second row will be edited with the given value
	 * @author Piramanayagam.S
	 * @param csvFile
	 * @param row
	 * @param value
	 */
	public static void editcsv(String csvFile,int row,String value) {
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] fieldheader = null ;
		String[] fieldValue = null ;
		try {
				String file=getPresentWorkingDir()+File.separator+"testdata"+File.separator+csvFile;
				System.out.println("Edit"+file);
				br = new BufferedReader(new FileReader(file));
				//Reading Header
				System.out.println("READ CSV");
				line=br.readLine();	
				fieldheader = line.split(cvsSplitBy);
				for(int i=0;i<fieldheader.length;i++){
					
				}
				
				//Reading FirstLine Value
				line=br.readLine();			
				fieldValue = line.split(cvsSplitBy);
				for(int i=0;i<fieldValue.length;i++){
				}
				
			
			System.out.println("EDIT CSV");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw );
			for(int i=0;i<fieldheader.length;i++){
				System.out.println(i+"VALUES:"+value);
				if(i==fieldheader.length-1){
					bw.write(fieldheader[i]);
				}else {
					bw.write(fieldheader[i]);
					bw.write(",");
				}
				
			}
			bw.newLine();
			for(int i=0;i<fieldValue.length;i++){
				System.out.println(i+"VALUES:"+value);
				if(i==fieldValue.length-1){
					bw.write(fieldValue[i]);
				} else if(i==row){ System.out.println(row+value);
					bw.write(value);
					bw.write(",");
				} else {
					bw.write(fieldValue[i]);
					bw.write(",");
				}
			}
			
			bw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	  }

	/***
	 * To Read CSV-Read all the Columns and Row data
	 * @author Piramanayagam.S
	 * @param csvFile
	 * @return Hashmap
	 * 
	 */
	public static String Readcsv(String csvFile,int col) {
		
		String data="";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";		 
		String[] fieldheader = null ;
		String[] fieldValue = null ;
		try {
				String file=getPresentWorkingDir()+File.separator+"testdata"+File.separator+csvFile;
				System.out.println("READ:"+file);
				br = new BufferedReader(new FileReader(file));
				
				//Reading Header
				line=br.readLine();	
				fieldheader = line.split(cvsSplitBy);
				for(int i=0;i<fieldheader.length;i++){
				}
				
				//Reading FirstLine Value
				line=br.readLine();			
				fieldValue = line.split(cvsSplitBy);
				for(int i=0;i<fieldValue.length;i++){
					if(i==col){
						data=fieldValue[i];
					}
				}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
		
		return data;
	  }


	private static ChannelSftp Connecttolinux() throws Exception {	
		
		String hostname = CommonUtils.InitProperties("lf.hostname");
        String username = CommonUtils.InitProperties("lf.username");
        String password = CommonUtils.InitProperties("lf.password");
        ChannelSftp sftpChannel=null;
        ChannelSftp channel2=null;
        String oldestFile=null;
        
        JSch jsch = new JSch();
        session = null;
        
        try {
            session = jsch.getSession(username, hostname, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect(); 
            Channel channel = session.openChannel("sftp");
            channel.connect();
            
             channel2 = (ChannelSftp)session.openChannel("sftp");
             channel2.connect();
            
             sftpChannel = (ChannelSftp) channel; 
             System.out.println("COnnected to linux");
            
        } catch (Exception e) {
            e.printStackTrace();  
            System.out.println("EXPCE"+e);
        }
		
        return channel2;
	}


	public static String ServerLatestFile( String folder,String type) throws Exception{	
	   
        String oldestFile=null;
        /*
        String platform=CommonUtils.InitProperties("Server");
        
        if(platform.equalsIgnoreCase("Linux")){
        
        try {
        
            ChannelSftp sftpChannel = Connecttolinux(); 
            System.out.println("Linux Directory:" + sftpChannel.pwd());
            System.out.println("F"+folder);
            sftpChannel.cd("..");
           sftpChannel.cd("/home/lavante");
            sftpChannel.cd(folder);
            
            System.out.println("Linux Directory:" + sftpChannel.pwd());
            Vector<ChannelSftp.LsEntry> list = sftpChannel.ls("*.csv");
            System.out.println(sftpChannel.pwd());
           
           System.out.println(list.size()+list.get(list.size()-1).getFilename());
            ChannelSftp.LsEntry lsEntry = null;
            SftpATTRS attrs = null;
            String nextName = null;
            
            
            int currentOldestTime;
            int nextTime = 2;
            
            lsEntry = (ChannelSftp.LsEntry) list.firstElement();
         
            attrs = lsEntry.getAttrs();
            currentOldestTime = attrs.getMTime();
            for (Object sftpFile : list) {
                lsEntry = (ChannelSftp.LsEntry) sftpFile;
                nextName = lsEntry.getFilename();
                System.out.println(nextName+currentOldestTime);
                attrs = lsEntry.getAttrs();
                nextTime = attrs.getMTime();
                if (currentOldestTime < nextTime) {
                    oldestFile = nextName;
                    currentOldestTime = nextTime;
                }
            }
            
            oldestFile = list.get(list.size()-1).getFilename();
            
            sftpChannel.exit();
            session.disconnect();
        
        } catch (SftpException e) {
            e.printStackTrace();
        }
        } else {
        	System.out.println("Window");
        	
        	String hostname = "192.168.21.20";
            String username = "Indecomm\\lavanateqa";
            String password = "Indecomm1$";
            ChannelSftp sftpChannel=null;
            ChannelSftp channel2=null;
            
            JSch jsch = new JSch();
            session = null;
            
            try {
                session = jsch.getSession(username, hostname, 22);
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(password);
                session.connect(); 
                Channel channel = session.openChannel("sftp");
                channel.connect();
                
                 channel2 = (ChannelSftp)session.openChannel("sftp");
                 channel2.connect();
                
                 sftpChannel = (ChannelSftp) channel; 
                 System.out.println("COnnected to linux");
                
            } catch (Exception e) {
                e.printStackTrace();  
                System.out.println("EXPCE"+e);
            }
            
            System.out.println("Linux Directory:" + sftpChannel.pwd());
        	
        	
        	
        	
        	String USER_NAME = "INDECOMM\\lavanteqa";
     		String PASSWORD = "Indecomm1$";
     		String NETWORK_FOLDER = "smb:\\192.168.21.20\\filerepo";
     	//	NETWORK_FOLDER="smb:\\LAVAQA2012.INDECOMM.LOCAL\\filerepo\\exportContractManagement\\";
        	NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("INDECOMM", USER_NAME, PASSWORD);
        	System.out.println("Authenticated for: "+auth.getUsername());
        			
            String Servername = NETWORK_FOLDER+"";
            
           SmbFile destFile = new SmbFile(Servername,auth);
           System.out.println("AITH: '"+auth+"' :"+Servername+":"+destFile);
           for (SmbFile f : destFile.listFiles())
           {
        	   System.out.println(f.getServer()+f.getLastModified()+f.getType()+f.getURL());
               System.out.println(f.getName()+":"+f.getDate());
               
               
           }
           File srcfiles=new File("");
             String srcfilesstring ="smb://192.168.21.20/Anonymos Logon/5-252064-1426149906850.pdf";
             System.out.println(srcfiles.getTotalSpace());
         //
            FileInputStream src = new FileInputStream(srcfilesstring);
            SmbFileOutputStream sfos = new SmbFileOutputStream(destFile);
             
             
            try{
                 int bytesRead = 0;
                 byte[] buffer = new byte[8192];
                 while ((bytesRead = src.read(buffer, 0, 8192)) != -1) {
                	sfos.write(buffer, 0, bytesRead);
                 }	             
                 System.out.println("Dropped File: " + srcfilesstring);
            	} 
            catch (Exception e) {                
                    e.printStackTrace();
                }
        	   
        	
        	
        }*/
        return oldestFile;
	}

 
	/**
	 * Copy the files from Server machine to Test data Folder
	 * @param folder
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void ServerCopyFile(String folder,String file) throws FileNotFoundException, IOException{
		  String hostname = CommonUtils.InitProperties("lf.hostname");
	        String username = CommonUtils.InitProperties("lf.username");
	        String password = CommonUtils.InitProperties("lf.password");
	        JSch jsch = new JSch();
	        com.jcraft.jsch.Session session = null;
	        
	        try {
	            session = jsch.getSession(username, hostname, 22);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.setPassword(password);
	            session.connect(); 
	            Channel channel = session.openChannel("sftp");
	            channel.connect();
	            ChannelSftp sftpChannel = (ChannelSftp) channel; 
	            sftpChannel.cd("..");
	            sftpChannel.cd(folder);
	            String g=folder+"/"+file;
	            sftpChannel.get(g, CommonUtils.getPresentWorkingDir()+File.separator+"testdata"+File.separator+file);
	            System.out.println("Linux Directory:" + file);
	            sftpChannel.exit();
	            session.disconnect();
	        
	        } catch (JSchException e) {
	            e.printStackTrace();  
	        } catch (SftpException e) {
	            e.printStackTrace();
	        }
	  
	    }
	
	  /**
   * Method is used to Delete the file from the Test data folder
   * @param file
   * @throws IOException
   */
	public static void deleteFile(String file) throws IOException{
	  File f=new File(CommonUtils.getPresentWorkingDir()+File.separator+"testdata"+File.separator+file);
	  f.delete();
  }

}
