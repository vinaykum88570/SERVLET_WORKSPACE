package module;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Login extends HttpServlet {
	Connection con;
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext sc = config.getServletContext();
			String s1 =	sc.getInitParameter("driver");
			String s2 =	sc.getInitParameter("url");
			String s3 = sc.getInitParameter("username");
			String s4 = sc.getInitParameter("password");
			
			Class.forName(s1);
			con = DriverManager.getConnection(s2, s3, s4);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		  
		
	}

	
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
    	 PrintWriter pw = response.getWriter();
		String s1 = request.getParameter("uname");
		String s2 = request.getParameter("pword");
		
		
		String sql ="select * from uinfo where UserName=? and Password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		
		
		ResultSet rs= pstmt.executeQuery();
		
		
		if(rs.next()) {
			// Login completed
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}
		else {
			pw.println("<html><body bgcolor=cyan text=blue> <h1>");
			pw.print("Invalid Username/PassWord");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}
		pw.print("</h1></body></html> ");
     }catch(Exception e) {
	   e.printStackTrace();
     }
		
	 }
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
