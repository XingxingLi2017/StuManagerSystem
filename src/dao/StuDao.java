package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Student;

public interface StuDao {
	
	int PAGE_SIZE = 5;
	/*
	 * find students in current page
	 * */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
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
	/*
	 * search student based on name and gender
	 * */
	List<Student> searchStudent(String sname, String sgender) throws SQLException;
	/*
	 * query the total number of entry
	 * */
	int findCount()throws SQLException ;
}
