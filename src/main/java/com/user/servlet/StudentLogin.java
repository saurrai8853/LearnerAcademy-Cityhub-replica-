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
@WebServlet("/studentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		
		HttpSession session=request.getSession();
		StudentDao dao=new StudentDao(DBConnect.getConn());
		
		 Student stu=dao.login(email, password);
		
		if(stu!=null) {
			session.setAttribute("studentObj", stu);
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("errorMsg","Email or password wrong try again");
			response.sendRedirect("student_login.jsp");
		}
		
	}

	catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}

}
