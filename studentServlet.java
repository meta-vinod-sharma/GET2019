package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class student
 */

public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentServlet() {
        super();
       
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = JDBC.getConnection();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String studentClass = request.getParameter("class");
		String age = request.getParameter("age");
		
		try {
			PreparedStatement pst = con.prepareStatement("insert into student_details (student_fname, student_lname, father_name, student_email_id, student_class, student_age) values(?,?,?,?,?,?)");
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, fatherName);
			pst.setString(4, email);
			pst.setString(5, studentClass);
			pst.setString(6, age);
			
			int i = pst.executeUpdate();
			if (i != 0) {
				pw.println("<br>Record has been inserted");
			} else {
				pw.println("failed to insert the data");
			}
			
		} catch (SQLException e) {
			pw.println(e);
		}
	}

}
