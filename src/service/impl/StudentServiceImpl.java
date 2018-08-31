package service.impl;

import java.sql.SQLException;
import java.util.List;

import bean.Student;
import dao.StuDao;
import dao.impl.StuDaoImpl;
import service.StudentService;

/*
 * implementation class of StudentService interface
 * */
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		StuDao dao = new StuDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StuDao dao = new StuDaoImpl();
		dao.insert(student);
	}

	@Override
	public void delete(int sid) throws SQLException {
		StuDao dao = new StuDaoImpl();
		dao.delete(sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StuDao dao = new StuDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		StuDao dao = new StuDaoImpl();
		dao.update(student);
	}
}
