package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil2 {
	private static ComboPooledDataSource dataSource = null;
	static {
		// use config file: c3p0-config.xml
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		closeRs(rs);
		closeSt(stmt);
		closeConn(conn);
	}
	
	public static void release(Connection conn, Statement stmt) {
		closeSt(stmt);
		closeConn(conn);
	}
	public static void release(Connection conn) {
		closeConn(conn);
	}

	private static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	private static void closeSt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
	}

	private static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}
}
