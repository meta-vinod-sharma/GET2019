package com.metacube.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class searchStudent
 */
@WebServlet("/showStudent")
public class searchAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**s
	 * @see HttpServlet#HttpServlet()
	 */
	public searchAllStudentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection con = JDBC.getConnection();
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from student_details");
		

			pw.print("<table width=50% border=1>");
			pw.print("<caption>Result:</caption>");

			ResultSet rs = pst.executeQuery();

			/* Printing column names */
			ResultSetMetaData rsmd = rs.getMetaData();
			int total = rsmd.getColumnCount();
			pw.print("<tr>");
			for (int i = 1; i <= total; i++) {
				pw.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}

			pw.print("</tr>");

			/* Printing result */

			while (rs.next()) {
				pw.print("<tr><td>" + rs.getInt(1) + "</td><td>"
						+ rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td><td>"
						+ rs.getString(5) + "</td><td>" + rs.getInt(6) + "</td><td>"
						+ rs.getInt(7) + "</td>"
						+"<td>"+ "<form action=\"updateStudentServlet\" method=\"GET\"><input type=\"hidden\" name=\"id\" value=\"" + rs.getInt(1) + "\"> <input type=\"submit\" value=\"Update\"></form>" + "</td> "+"</tr>");

			}

			pw.print("</table>");
		}

		catch (SQLException e) {
			pw.println(e);
		}

		finally {
			pw.close();
		}

	}

}
