package rpc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int sid = Integer.parseInt(request.getParameter("sid"));
			// get data from form
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String info = request.getParameter("info");
			// get multiple values of parameter
			String[] hobbies = request.getParameterValues("hobby");
			String hobby = Arrays.toString(hobbies);
			// delete '[' and ']'
			hobby = hobby.substring(1, hobby.length()-1);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			// update information in database
			StudentService service = new StudentServiceImpl();
			Student student = new Student(sid, sname, gender, phone, hobby, info, date);
			service.update(student);
			
			// jump to StudentListServlet to reload page
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
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
