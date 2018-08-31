package service;

import java.sql.SQLException;
import java.util.List;

import bean.Student;
/*
 * Bussiness Logic Layer
 * */
public interface StudentService {
	
	/*
	 * find all students' information
	 * */
	List<Student> findAll() throws SQLException ;
	
	Student findStudentById(int sid) throws SQLException ;

	void insert(Student student) throws SQLException;
	/*
	 * delete one student
	 * */
	void delete(int sid) throws SQLException;
	
	void update(Student student) throws SQLException;
	List<Student> searchStudent(String sname, String sgender) throws SQLException;
}
