package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import bean.Student;
import dao.StuDao;
import util.JDBCUtil2;
import util.TextUtils;

/*
 * implement StuDao interface
 * */
public class StuDaoImpl implements StuDao {

	/*
	 * find all the students
	 * */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
	}
	
	/*
	 * insert a new student 
	 * */
	@Override
	public void insert(Student student) throws SQLException {
		System.out.println(student);
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		String sql = "insert into `stu` values (null,?,?,?,?,?,?)";
		runner.update(sql,
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		runner.update("delete from stu where sid=?", sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		return runner.query("select * from stu where sid=?",new BeanHandler<Student>(Student.class), sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		runner.update("update stu set sname=? , gender=?, phone=?, birthday=?, hobby=?, info=? where sid=? ",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid()
				);
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		List<Object> params = new ArrayList<>();
		String sql = "select * from stu where 1=1";
		if (!TextUtils.isEmpty(sname)) {
			sql = sql + " and sname like ?";
			params.add("%"+sname+"%");
		}
		if (!TextUtils.isEmpty(sgender)) {
			sql = sql + " and sgender = ?";
			params.add(sgender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), params.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		List<Object> params = new ArrayList<>();
		params.add(PAGE_SIZE);
		params.add((currentPage - 1) * PAGE_SIZE);
		return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class), params.toArray());
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		// ScalarHandler: used for statistic information
		Long count = (Long)runner.query("select Count(*) from stu", new ScalarHandler());
		return count.intValue();
	}
}
