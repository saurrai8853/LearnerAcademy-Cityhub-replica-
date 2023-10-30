package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.db.DBConnect;
import com.entity.Student;
@WebServlet("/studentregister")
public class studentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Student stu=new Student(fullname, email, password);
		StudentDao dao=new StudentDao(DBConnect.getConn());
		HttpSession session=request.getSession();
		
		 
		boolean f=dao.register(stu);
		if(f) {
			session.setAttribute("succMsg","Register Student Succesfully");
			response.sendRedirect("sign_up.jsp");
		}
		else {
			session.setAttribute("errorMsg","something wrong on server");
			response.sendRedirect("sign_up.jsp");
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
