package util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class CreateTables2 {

	public static void main(String[] args) throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		System.out.println(runner.toString());
		String sql = "DROP TABLE IF EXISTS stu";
		runner.update(sql);
		sql = "			CREATE TABLE stu(" + 
				"				sid INT PRIMARY KEY AUTO_INCREMENT," + 
				"				sname VARCHAR(20)," + 
				"				gender VARCHAR(20)," + 
				"				phone VARCHAR(20)," + 
				"				birthday DATE," + 
				"				hobby VARCHAR(100)," + 
				"				info VARCHAR(200)" + 
				")";
		runner.update(sql);
		sql = "INSERT INTO `stu` (`sid`, `sname`, `gender`, `phone`, `birthday`, `hobby`, `info`) "
				+ "VALUES ('1', 'test1', 'female', '333333', '1999-4-5', 'swim', 'this is test-1 stu')";
		runner.update(sql);
	}

}
