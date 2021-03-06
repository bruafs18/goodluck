package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBGetTemplate<T> extends DBSettings {
	
	
	
	protected String Query;
	
    public final ArrayList<T> RunQuery() {
    	Connection conn = null;
		Statement stmt = null;
		ArrayList<T> arr = new  ArrayList<T>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = Query;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				arr.add(TakeCareOfTheRecord(rs));
			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("jdbc");
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("class.forname");
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
		} 
		}
		
		return arr;
    }
    
    public abstract T TakeCareOfTheRecord(ResultSet rs) throws SQLException;
     
}
