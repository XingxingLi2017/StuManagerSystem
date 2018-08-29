package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {
	private static String driverClass = null;
	private static String url = null;
	private static String name = null;
	private static String password = null;
	
	static {
		// read configaration information from config file
		Properties props = new Properties();
		String path = JDBCUtil.class.getClassLoader().getResource("jdbc.properties").getPath();
		try {
			// load properties
			FileInputStream in = new FileInputStream(path);
			props.load(in);
			
			// fill the values of fields
			driverClass = props.getProperty("driverClass");
			url = props.getProperty("url");
			name = props.getProperty("name");
			password = props.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// get connection
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClass).newInstance();
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
