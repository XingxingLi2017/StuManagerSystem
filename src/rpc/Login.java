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
import dao.UserDao;
import dao.impl.StuDaoImpl;
import dao.impl.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username and password: "+userName + "," +password);
		
		UserDao dao = new UserDaoImpl();
		boolean isSuccess = dao.login(userName, password);
		if (isSuccess) {
			StuDao stuDao = new StuDaoImpl();
			List<Student> list = stuDao.findAll();
			request.getSession().setAttribute("list", list);
			response.sendRedirect("stu_list.jsp");
		} else {
			response.getWriter().write("invalide username or password");
		}
		
	}

}
