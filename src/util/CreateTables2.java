package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

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
		String sname = null;
		String gender = null;
		String phone = null;
		String birthday = null;
		String[] hobbyies = {"swim", "basketball", "soccer", "reading", "writing"};
		String hobby = null;
		String info = null;
		Random random = new Random();
		for (int i = 2 ; i < 25  ; i++) {
			sname = "test"+ i;
			gender = random.nextInt(2) == 0 ? "male":"female";
			phone =  (1000000 + random.nextInt(1000000))+"";
			int year = random.nextInt(100)+1900;
			int month = random.nextInt(12)+1;
			int day = random.nextInt(28)+1;
			birthday = year+"-"+month+"-"+day;
			hobby = hobbyies[random.nextInt(hobbyies.length)];
			info = " this is test"+i;
			sql =  "INSERT INTO `stu` (`sname`, `gender`, `phone`, `birthday`, `hobby`, `info`) "
					+ "VALUES ('"+sname+"', '"+gender+"', '"+phone+"', '"+birthday+"', '"+hobby+"', '"+info+"')";
			runner.update(sql);
		}

	}
}
