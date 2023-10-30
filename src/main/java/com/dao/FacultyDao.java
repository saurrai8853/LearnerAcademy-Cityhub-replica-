package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Faculty;

public class FacultyDao {
	 private Connection conn;

	public FacultyDao(Connection conn) {
		super();
		this.conn=conn;
		// TODO Auto-generated constructor stub
	}
	
	public boolean registerFaculty(Faculty fac) {
		boolean f=false;
		try {
			
			String sql="insert into Faculty(fullname,dob,qualification,specialist,email,mobNo,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,fac.getFullName());
			ps.setString(2, fac.getDob());
			ps.setString(3, fac.getQualification());
			ps.setString(4, fac.getSpecialist());
			ps.setString(5, fac.getEmail());
			ps.setString(6, fac.getMobNo());
			ps.setString(7, fac.getPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		
		
		
		return f;
		
	}
	public List<Faculty> getAllFaculty(){
		
		List<Faculty> list=new ArrayList<Faculty>();
		Faculty f=null;
		
		try {
			
			String sql="select * from faculty order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=new Faculty();
				
				f.setId(rs.getInt(1));
				f.setFullName(rs.getString(2));
				f.setDob(rs.getString(3));
				f.setQualification(rs.getString(4));
				f.setSpecialist(rs.getString(5));
				f.setEmail(rs.getString(6));
				f.setMobNo(rs.getString(7));
				f.setPassword(rs.getString(8));
				list.add(f);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
public Faculty getFacultyById(int id){
		
		
		Faculty f=null;
		
		try {
			
			String sql="select * from faculty where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				f=new Faculty();
				
				f.setId(rs.getInt(1));
				f.setFullName(rs.getString(2));
				f.setDob(rs.getString(3));
				f.setQualification(rs.getString(4));
				f.setSpecialist(rs.getString(5));
				f.setEmail(rs.getString(6));
				f.setMobNo(rs.getString(7));
				f.setPassword(rs.getString(8));
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}	 
	 
}
