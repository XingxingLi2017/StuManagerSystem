package rpc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StuDao;
import dao.impl.StuDaoImpl;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListServlet
 * 
 * query all the student and present student list on view
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("stu_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
