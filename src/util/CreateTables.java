package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateTables {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			FileInputStream in = new FileInputStream("src/jdbc.properties");
			Properties props = new Properties();
			props.load(in);
			String url = props.getProperty("url");
			String username = props.getProperty("name");
			String password = props.getProperty("password");
			String driverClass = props.getProperty("driverClass");
			Class.forName(driverClass).newInstance();
			conn = DriverManager.getConnection(url, username, password);
			if (conn == null) {
				System.err.println("get db connection failed.");
				return;
			}
			System.out.println("get db connection successfully");
			
			Statement stmt = conn.createStatement();
			String sql = "DROP TABLE IF EXISTS t_user";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE IF EXISTS t_stu";
			stmt.executeUpdate(sql);
			
			sql = "create table t_user ("+ 
					"id int not null auto_increment," + 
					"username varchar(20)," + 
					"`password` varchar(20)," + 
					"primary key (id)" + 
					")";
			stmt.executeUpdate(sql);
			
			sql = "insert into t_user (id, username, `password`) values (1, \"admin\", \"admin\")";
			stmt.execute(sql);
			sql = "insert into t_user (id, username, `password`) values (2, \"zhangsan\", \"123\")";
			stmt.execute(sql);
			sql = "insert into t_user (id, username, `password`) values (3, \"lisi\", \"456\")";
			stmt.executeUpdate(sql);
			
			sql = "create table t_stu (" + 
					"	id int not null auto_increment," + 
					"    `name` varchar(20)," + 
					"    age int,\r\n" + 
					"    gender varchar(20)," + 
					"    address varchar(31)," + 
					"    primary key (id)" + 
					")";
			stmt.executeUpdate(sql);
			
			sql = "insert into t_stu (id, `name`, age, gender, address) values (2, 'zhangsan', 34, 'male', '1111 Army Navy St')";
			stmt.executeUpdate(sql);
			sql = "insert into t_stu (`name`, age, gender, address) values ('lisi', 30, 'female', '2222 Army Navy St')";
			stmt.executeUpdate(sql);
			sql = "insert into t_stu (`name`, age, gender, address) values ('wang', 27, 'male', '2134 Army Navy St')";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
