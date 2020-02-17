package com.lavante.sim.Common.Util;

import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;

public class GetExpiredUserDataFromSQL {

	// Constant for Database DB
	static String DB_DB = "SIM";
	// Constant for Database User name
	static String DB_USER = "SIM_AppUser_QA";
	// Constant for Database Password
	static String DB_PASSWORD = "simqa678!**";
	LavanteUtils lavanteUtils=new LavanteUtils();
	@Test
	public List<String> expiredUserDataExtract(List<setTestData> getDataBaseQuery,String strtype) {
		List<String> data = new ArrayList<String>();
		SQLServerConnection con01 = null;
		SQLServerStatement stmt01 = null;
		SQLServerResultSet res01 = null;

		try {
			Reporter.log("\n Initiating SIM Database Connection");
			stmt01 = (SQLServerStatement) lavanteUtils.ConnectDB();;
			Reporter.log("Conncetion to SIM data base is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(int i=0;i<getDataBaseQuery.size();i++) {
			String query = getDataBaseQuery.get(i).getQueryName().toString();
			try {
				// Get the contents of user info table from DB
				res01 = (SQLServerResultSet) stmt01.executeQuery(query);	

				while (res01.next()) {
					data.add(res01.getString(1).toString());
				}
				System.out.println(res01);
				Reporter.log("SQL Query execution is successful for: " + strtype );

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Close DB connection
		if (con01 != null) {
			try {
				con01.close();
				Reporter.log("Connection to the database is closed");
			} catch (SQLServerException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

}
