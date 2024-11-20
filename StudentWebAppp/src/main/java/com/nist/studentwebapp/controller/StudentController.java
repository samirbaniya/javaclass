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
		
		PreparedStatement ps = null;
		
		String sql = "Insert into student(name,address,contact,gender)values(?,?,?,?)";

		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2, address);
			ps.setLong(3,contact);
			ps.setString(4, gender);
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
			int id=rs.getInt("id");
			String name1=rs.getString("name");
			String address1=rs.getString("address");
			Long contact1=rs.getLong("contact");
			String gender1=rs.getString("gender");
			
			 Student student = new Student();
			 student.setName(name1);
			 student.setId(id);
			 student.setContact(contact1);
			 student.setGender(gender1);
			 student.setAddress(address1);
			 
			 studentList.add(student);
			
		}
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
//		System.out.println("id \t name /t address /t contact /t gender");
//		for(Student std: studentList) {
//			System.out.println(std.id+"\t"+std.name);
//		}
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("student_details.jsp");
		request.setAttribute("sList", studentList);
		rd.forward(request, response);
		
		
		
		
	}

}
