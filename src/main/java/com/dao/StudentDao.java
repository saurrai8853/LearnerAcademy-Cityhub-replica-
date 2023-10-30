package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Faculty;
import com.entity.Student;
import com.mysql.cj.xdevapi.Result;

public class StudentDao {

	private Connection conn;

	public StudentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean register(Student stu) {
		
		boolean f=false;
		
		try {
			String sql="insert into student(Full_name,email_id,password) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,stu.getFullname() );
			ps.setString(2, stu.getEmail());
			ps.setString(3, stu.getPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public Student login(String email,String password) {
		Student stu=null;
		try {
			String sql="select * from student where email_id=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				stu=new Student();
				stu.setId(rs.getInt(1));
				stu.setFullname(rs.getString(2));
				stu.setFullname(rs.getString(3));
				stu.setPassword(rs.getString(4));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		
		}
		return stu;
	}
public List<Student> getAllStudent(){
		
		List<Student> list=new ArrayList<Student>();
		Student f=null;
		
		try {
			
			String sql="select * from student order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=new Student();
				
				f.setId(rs.getInt(1));
				f.setFullname(rs.getString(2));
				f.setEmail(rs.getString(3));
				f.setPassword(rs.getString(4));
				list.add(f);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	 
}
