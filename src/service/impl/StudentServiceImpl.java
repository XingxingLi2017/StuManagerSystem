package service.impl;

import java.sql.SQLException;
import java.util.List;

import bean.PageBean;
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

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		return new StuDaoImpl().searchStudent(sname, sgender);
	}

	@Override
	public PageBean searchStudent(int currentPage) throws SQLException {
		PageBean<Student> pageBean = new PageBean<>();
		StuDao dao = new StuDaoImpl();
		int pageSize = StuDao.PAGE_SIZE;
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		List<Student> students = dao.findStudentByPage(currentPage);
		pageBean.setList(students);;
		
		int totalItems = dao.findCount();
		pageBean.setTotalSize(totalItems);
		pageBean.setTotalPage(totalItems % pageSize == 0 ? totalItems / pageSize : totalItems / pageSize + 1);
		return pageBean;
	}
}
