package com.nist.studentwebapp.controller;

import java.awt.Desktop.Action;
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

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String value=request.getParameter("action");// edit
		PreparedStatement ps=null;
		ArrayList<Student>studentList=new ArrayList<>();
		
		if(value.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			String sql="Delete from student where id=?";
			
			try {
				ps = DatabaseConnection.getConnection().prepareStatement(sql);
				ps.setInt(1,id);
				
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			String sql1 = "Select * from student";
			
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

			
			
		}else if(value.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id")); // 1
			
			String sql="select * from student where id=?";
			try {
			ps=DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
		   ResultSet rs=ps.executeQuery();
		   Student student= new Student();
		   while(rs.next()) {
			  
			   student.setId(rs.getInt("id"));
			   student.setAddress(rs.getString("address"));
			   student.setContact(rs.getLong("contact"));
			   student.setGender(rs.getString("gender"));
			   student.setName(rs.getString("name"));
			   
			   
		   }
		   RequestDispatcher rd= request.getRequestDispatcher("student_form.jsp");
		   request.setAttribute("studentKey", student);
		   rd.forward(request, response);
		 
			
			
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}

		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
