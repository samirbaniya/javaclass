package com.nist.studentwebapp.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nist.webapp.databaseconnection.DatabaseConnection;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		long contact=Long.parseLong(request.getParameter("contact"));
		String gender=request.getParameter("gender");
		String id=request.getParameter("id");		
		PreparedStatement ps = null;
		
	
		
		String sql="";
				try {
					
					if(id==null  || id.isEmpty()) {
						 sql = "Insert into student(name,address,contact,gender)values(?,?,?,?)";
					}else {
						sql="update student set name=?, address=?, contact=?, gender=? where id=?";
							
					}
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, address);
			ps.setLong(3,contact);
			ps.setString(4, gender);
			if(id!=null && !id.isEmpty()) {
				ps.setInt(5, Integer.parseInt(id));
				
			}
			ps.executeUpdate();
			
		}catch(Exception err) {
			System.out.println(err);
		}	
		
		
		String sql1 = "Select * from student";
		ArrayList<Student>studentList=new ArrayList<>();
		try {
		ps = DatabaseConnection.getConnection().prepareStatement(sql1);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int id1=rs.getInt("id");
			String name1=rs.getString("name");
			String address1=rs.getString("address");
			Long contact1=rs.getLong("contact");
			String gender1=rs.getString("gender");
			
			 Student student = new Student();
			 student.setName(name1);
			 student.setId(id1);
			 student.setContact(contact1);
			 student.setGender(gender1);
			 student.setAddress(address1);
			 
			 studentList.add(student);
			
		}
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher("student_details.jsp");
		request.setAttribute("sList", studentList);
		rd.forward(request, response);
		
		
		
		
	}

}
