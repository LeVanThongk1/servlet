package com.ck;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center><h1>Student List</h1><center>");
		out.println("<center><h2><a href='index.html'>Register Student</a></h2><center>");
		out.println("<center><h4><a href='LogOut'>LogOut</a></h4><center>");
		
		List<Student> list= StudentDAO.getAllStudents();
		
		out.print("<table border='2' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Subject</th><th>Edit</th><th>Delete</th></tr>");
		for(Student e : list) {
			out.print("<tr><td>"+ e.getId()+"</td><td>"+ e.getName()+"</td><td>"+ e.getPassword()+"</td><td>"
		+ e.getSubject()+"</td><td><a href='EditServletForm?id=" + e.getId() 
		+ "'>edit</a></td><td><a href='DeleteServlet?id=" + e.getId() +"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
