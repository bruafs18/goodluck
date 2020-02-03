package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://172.17.0.2:3306/MyParkDB";

	static final String USER = "root";
	static final String PASS = "AllGroup15";
	
	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/partners")
	public static ArrayList<Pair<Integer,String>> GetPartners() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Pair<Integer,String>> arr = new  ArrayList<Pair<Integer,String>>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			stmt = conn.createStatement();
	
			String sql = "SELECT * FROM Partner ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num= rs.getInt("id");
				String abc= rs.getString("name");
				arr.add(new Pair<Integer,String>(num,abc));
			}
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
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

}
