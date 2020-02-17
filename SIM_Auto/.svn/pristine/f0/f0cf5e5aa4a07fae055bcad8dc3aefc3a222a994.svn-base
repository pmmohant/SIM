package com.lavante.sim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;




import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * Created on 16-12-2015
 * Created for Application And DB Instance UP
 * Ended on 04-02-2016
 * @author Piramanayagam.S
 *
 */
public class UtilityAppDB  {
	
	LavanteUtils lavanteUtils=new LavanteUtils();

	@Test
	public void AppURLVerification() throws InterruptedException, Exception, Throwable{
		System.out.println("APP Test Started at :"+lavanteUtils.currenttime());
		 boolean flag=true;
		String appurl=lavanteUtils.InitProperties("APPURL");
	    SoftAssert softAssert=new SoftAssert();
	    int responseCode = 0;
	    try {
		  URL hp = new URL(appurl); 
		  HttpURLConnection httpConn =  (HttpURLConnection)hp.openConnection();
		  httpConn.setInstanceFollowRedirects( false );
		  httpConn.setRequestMethod( "HEAD" ); 
		  httpConn.connect();
		  
		  
	     	try {
			responseCode = httpConn.getResponseCode();
			System.out.println(responseCode);
	     	} catch (IOException e) {
	     		if (responseCode!=200&&responseCode!=302&&responseCode!=0){
	     			
	     		}else{
	     		  flag=false;
	     		  System.out.println("Flag ");
	     		 softAssert.assertTrue(flag,"No Response ,Application is Down");
	     		}
	     	}
	     	if (responseCode!=200&&responseCode!=302&&responseCode!=0){
	     		flag=false;
	     		 softAssert.assertTrue(flag,"Application is not responding");
			}
	     	
		} catch (Exception e) {
			if (responseCode!=200&&responseCode!=302&&responseCode!=0){
     			
     		}else{
			  System.out.println("Application is Down");
			  flag=false;
			  softAssert.assertTrue(flag,"Application is Down");
     		}
		}
		
		 if(flag==false){
			    String to[]=new String[1];
			    to[0]="piramanayagam.s@indecomm.net";
			    //to[0]="Karthikeyan.Jayapaul@Indecomm.net";
			   // to[0]="Lavante@Indecomm.net";
			    
			    String cc[]=new String[0];
			//    cc[0]="piramanayagam.s@indecomm.net";
			 //   cc[1]=" Subramani.Pillai@Indecomm.net";
			    String sub="Automated Application Utility Code";
			    String msg="Hi All, \n Application Connection did not responded,Please check Application :"+appurl;
			    String Attachmentpath="";
			    
			    String FileAttachment[]=new String[0];
			    
			    lavanteUtils.sendemail(to, cc, sub,msg, Attachmentpath, FileAttachment);
			
		    }
		 
		 
	    
	    softAssert.assertAll();
	    System.out.println("App Test Ended at :"+lavanteUtils.currenttime());    
	}
	
	@Test
	public void VerificationonDB() throws InterruptedException, Exception, Throwable{
		
		System.out.println("DB Test Started at :"+lavanteUtils.currenttime());
		boolean flag=false;
		
		SoftAssert softAssert=new SoftAssert();
		String starttime=lavanteUtils.currenttime();
		System.out.println("DB Connection Triggered at :"+starttime);
		Connection con=lavanteUtils.ConnectDB1();
		CallableStatement proc_stmt = con.prepareCall("{ call lcsp_C_Contract_Suppliers_Search(?,?,?,?,?,?,?,?,?,?) }");
		proc_stmt.setString(1, "50");
	    proc_stmt.setString(2, "SCRhman");
	    proc_stmt.setString(3, null);
	    proc_stmt.setString(4, null);
	    proc_stmt.setString(5, null);
	    proc_stmt.setString(6, null);
	    proc_stmt.setInt(7, 1);
	    proc_stmt.setInt(8, 10);
	    proc_stmt.setString(9, "MSANumber asc");
	    proc_stmt.setString(10, "0");
	    
	    String dbProcedure="{ call lcsp_C_Contract_Suppliers_Search(50,SCRhman,?,?,?,?,1,10,MSANumber asc,0) }";
	    
	    ResultSet rs = proc_stmt.executeQuery();
	    while (rs.next()) {
	        String 
	        employeeId = rs.getString(	1	);
	        System.out.println("Generated RowNum: " + employeeId);
	        Reporter.log("Generated RowNum: " + employeeId);
	        employeeId = rs.getString(	2	);
	        System.out.println("Generated MSANumber: " + employeeId);	
	        Reporter.log("Generated MSANumber: " + employeeId);
	        employeeId = rs.getString(	3	);
	        System.out.println("Generated MSAType: " + employeeId);		
	        employeeId = rs.getString(	4	);
	        System.out.println("Generated SupplierName: " + employeeId);		
	        employeeId = rs.getString(	5	);
	        System.out.println("Generated SOWNumber: " + employeeId);		
	        employeeId = rs.getString(	6	);
	        System.out.println("Generated SOWStatus: " + employeeId);		
	        employeeId = rs.getString(	7	);
	        System.out.println("Generated LineItemDeliverable: " + employeeId);		
	        employeeId = rs.getString(	8	);
	        System.out.println("Generated Deliverable: " + employeeId);		
	        employeeId = rs.getString(	9	);
	        System.out.println("Generated ExpectedDeliverableDate: " + employeeId);		
	        employeeId = rs.getString(	10	);
	        System.out.println("Generated RelationshipId: " + employeeId);		
	        employeeId = rs.getString(	11	);
	        System.out.println("Generated LavanteUID: " + employeeId);		
	        employeeId = rs.getString(	12	);
	        System.out.println("Generated MSAID: " + employeeId);		
	        employeeId = rs.getString(	13	);
	        System.out.println("Generated SOWID: " + employeeId);		
	        employeeId = rs.getString(	14	);
	        System.out.println("Generated DeliverableID: " + employeeId);		
	        employeeId = rs.getString(	15	);
	        System.out.println("Generated PaymentStatusId: " + employeeId);	
	        flag=true;
	      }
	    softAssert.assertTrue(flag,"DB is Not UP at: "+lavanteUtils.currenttime());
	    
	    System.out.println("DB Connection Ended at :"+lavanteUtils.currenttime());
	    
	    softAssert.assertAll();
	    String endtime=lavanteUtils.currenttime();
	    System.out.println("DB Test Ended at :"+endtime);
	    
	    Integer x=Integer.parseInt(starttime);
	    Integer y=Integer.parseInt(endtime);

	    int xx=y-x;
	    
	    System.out.println(y-x);
	    int timeout=20;
	    		
	    if(xx>timeout){
		    String to[]=new String[1];
		    //to[0]="piramanayagam.s@indecomm.net";
		    to[0]=" Subramani.Pillai@Indecomm.net";
		   // to[0]="Lavante@Indecomm.net";
		    
		    String cc[]=new String[1];
		    cc[0]="piramanayagam.s@indecomm.net";
		    String sub="Automated DB Utility Code";
		    String msg="Hi All, \n DB Connection did not responded on proper timings,It took more than  , "+timeout+" Sec"
		    		+ " for a 1 Sec Procedure to execute,Actual time taken:"+xx+" Seconds, DB Execution Started at:"+starttime+",and Ended at :"+endtime
		    		 +" \n DB Procedure : "+dbProcedure;
		    String Attachmentpath="";
		    
		    String FileAttachment[]=new String[0];
		    
		    lavanteUtils.sendemail(to, cc, sub,msg, Attachmentpath, FileAttachment);
		
	    }
	}
	
	
}

