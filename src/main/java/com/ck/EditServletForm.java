package com.ck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServletForm
 */
@WebServlet("/EditServletForm")
public class EditServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServletForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Student Data</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid); 
		
		Student e =  StudentDAO.getStudentById(id);
		
		out.print("<form action='EditServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='id' value='" + e.getId() +"'/></td></tr");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() +"'/></td></tr>");
		out.print("<tr><td>Select Subject:</td><td>");
		out.print("<select name='subject' style='width:150px'>");
		out.print("<option>Physics</option>");
		out.print("<option>Chemistry</option>");
		out.print("<option>Math</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='" + e.getPassword()  +"'/></td></tr>");	
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
