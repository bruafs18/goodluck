package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBPostTemplate extends DBSettings {
	
	protected String Query;
	
    public final int RunQuery() {
    	int num =0;
    	Connection conn = null;
		PreparedStatement prepStmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			prepStmt = conn.prepareStatement(Query);
			prepStmt = TakeCareOfParams(prepStmt);
			num = prepStmt.executeUpdate();
			prepStmt.close();
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
				if (prepStmt != null)
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
		
		return num;
    }
    
    public abstract PreparedStatement TakeCareOfParams(PreparedStatement pst) throws SQLException;
}
