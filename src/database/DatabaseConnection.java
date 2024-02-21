package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DatabaseConnection {
	String ConnectionString = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=Live_Sync;";
	String userName = "sysdb";
	String password = "1234";

	// connect method to connect to database
	public CachedRowSet connect(String query) {
		ResultSet rs = null;

		try {
			// connect to database
			Connection con = DriverManager.getConnection(ConnectionString, userName, password);

			// make a statement
			Statement stmt = con.createStatement();
			// execute query and get results
			rs = stmt.executeQuery(query);

			/*
			 * after connection is closed result set are also disconnect so use CachedROwset
			 * to populate and close connection
			 */
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet rowset = factory.createCachedRowSet();
			rowset.populate(rs);

			con.close();
			return rowset;

		} catch (Exception e) {
			// handle exception
			e.printStackTrace(System.out);
		}
		return null;

	}

}
