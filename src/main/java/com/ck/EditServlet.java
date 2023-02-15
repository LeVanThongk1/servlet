package com.ck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String sid = request.getParameter("id");
		int id=Integer.parseInt(sid);	
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String password=request.getParameter("password");
		
		Student e = new Student();
		e.setId(id);
		e.setName(name);
		e.setSubject(subject);
		e.setPassword(password);
		
		int status=StudentDAO.update(e);
		if (status>0) {
			out.print("<h3 style='color:green'><br>Update successfully!</h3>");
			request.getRequestDispatcher("ViewServlet").include(request, response);
		} else {
			out.println("<h3 style='color:red'>Sorry</h3>");
		}
		out.close();
	}

}
