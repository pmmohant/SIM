/**
 * Company			: 	LAVANTE
 * Project Name	   	:	Lavante SIM Application
 * Automation		: 	Selenium Automation
 * Author			: 	Venkata Ravi Majjari
 */

package com.lavante.sim.Common.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;

public class GetToDoListDataFromSQL {
	// Constant for Database DB
	static String DB_DB = "SIM";
	// Constant for Database User name
	static String DB_USER = "SIM_AppUser_QA";
	// Constant for Database Password
	static String DB_PASSWORD = "simqa678!**";

	@Test
	public List<String> dataExtract(List<setTestData> getDataBaseQuery) {
		List<String> data = new ArrayList<String>();
		SQLServerConnection con01 = null;
		SQLServerStatement stmt01 = null;
		SQLServerResultSet res01 = null;

		try {
			Reporter.log("\n Initiating SIM Database Connection");

			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setUser(DB_USER);
			ds.setPassword(DB_PASSWORD);
			ds.setServerName("192.168.21.43");
			ds.setPortNumber(49696);
			ds.setDatabaseName(DB_DB);
			con01 = (SQLServerConnection) ds.getConnection();
			stmt01 = (SQLServerStatement) con01.createStatement();
			Reporter.log("Conncetion to SIM data base is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(int i=0;i<getDataBaseQuery.size();i++) {
			String query = getDataBaseQuery.get(i).getToDoListQuery().toString();
			try {
				// Get the contents of user info table from DB
				res01 = (SQLServerResultSet) stmt01.executeQuery(query);

				while (res01.next()) {
					Date dDate = res01.getDate(3);
					SimpleDateFormat oFormat = new SimpleDateFormat("MM/dd/YYYY");
					String sDate = oFormat.format(dDate);
					data.add(res01.getString(1).toString() + "|" + sDate);
				}
				System.out.println(res01);
				Reporter.log("SQL Query execution is successful for TO Do List ");

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
