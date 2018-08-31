package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Student;

public interface StuDao {
	/*
	 * find all students' information
	 * */
	List<Student> findAll() throws SQLException ;
	
	Student findStudentById(int sid) throws SQLException ;
	
	/*
	 * insert a new student into database
	 * */
	void insert(Student student) throws SQLException;
	/*
	 * delete a student
	 * */
	void delete(int sid) throws SQLException;
	
	void update(Student student) throws SQLException;
}
