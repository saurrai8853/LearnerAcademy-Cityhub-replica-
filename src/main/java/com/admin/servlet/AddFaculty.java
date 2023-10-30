package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FacultyDao;
import com.db.DBConnect;

import com.entity.Faculty;

@WebServlet("/addFaculty")
public class AddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fullname=request.getParameter("fullname");
			String dob=request.getParameter("dob");
			String qualification=request.getParameter("qualification");
			String spec=request.getParameter("spec");
			String email=request.getParameter("email");
			String mobno=request.getParameter("mobno");
			String password=request.getParameter("password");
			
			Faculty d=new Faculty(fullname,dob,qualification,spec,email,mobno,password);
			
			FacultyDao dao=new FacultyDao(DBConnect.getConn());
			HttpSession session=request.getSession();
			if(dao.registerFaculty(d)) {
				session.setAttribute("succMsg", "Faculty Added Successfully");
				response.sendRedirect("admin/Faculty.jsp");
			}else {
				session.setAttribute("errorMsg", "Something wrong on server");
				response.sendRedirect("admin/Faculty.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
