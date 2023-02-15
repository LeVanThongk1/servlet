package com.ck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserValidation
 */
@WebServlet("/UserValidation")
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidation() {
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
		doGet(request, response);
	}
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/text5?useSSL=false", "root","12345" );
			String q = "select * from user1 where NAME=(?) and PASSWORK=(?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, password);	
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				name= rs.getString(1);	
				password= rs.getString(2);	
				
				if (name.equalsIgnoreCase(name) && password.equalsIgnoreCase(password));
				{
					pw.print("Login user by id :"+ name);
					HttpSession session =  request.getSession();
					if (session !=null) {
						session.setAttribute("name", name);
						RequestDispatcher rd = request.getRequestDispatcher("ViewServler");
						rd.include(request, response);
					}
				}
				}else {
					pw.print("<center><h3 style='color:green'>check either userName of password ! Thank </h3></center>");
					RequestDispatcher rd = request.getRequestDispatcher("LoginForm.html");
					rd.include(request, response);
				}
			con.close();
			
		} catch (Exception ex) {
			// TODO: handle exception
			pw.print(ex);
			pw.close();
}
	}

}
