package login;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	Connection con ;
	private static final long serialVersionUID = 1L;
	
    public void init(ServletConfig config) {
    	
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException  {  
		try {
			
			
			
		String s1 = request.getParameter("fname");
		String s2 = request.getParameter("lname");
		String s3 = request.getParameter("uname");
		String s4 = request.getParameter("pword");
		

		
		String sql = "insert into uinfo values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		pstmt.setString(3, s3);
		pstmt.setString(4, s4);
		
		int execute = pstmt.executeUpdate();
		System.out.println(execute);
		PrintWriter pw = response.getWriter();
		if(execute>0) {
			pw.print("<html><body bgcolor=green text=yellow><center>");
			pw.print("<h1>You have Registered Successfully</h1>");
			pw.print("<a href=Login.html>Login</a>");
			pw.print("</html></body bgcolor=green text=yellow></center>");
		}else {
			pw.print("<html><body bgcolor=green text=yellow><center>");
			pw.print("<h1>You have not Registered Successfully</h1>");
			pw.print("<a href=reg.html>Login</a>");
			pw.print("</html></body bgcolor=green text=yellow></center>");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		  }
	    } 
	
	    public void destroy() {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
