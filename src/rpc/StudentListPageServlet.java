package rpc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListPageServlet
 */
@WebServlet("/StudentListPageServlet")
public class StudentListPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		StudentService service = new StudentServiceImpl();
		try {
			PageBean<Student> pageBean = service.searchStudent(currentPage);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("stu_list_page.jsp").forward(request, response);
		} catch (SQLException e) {
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
