package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/welcome")
public class LoginFilters extends HttpFilter {
	Connection con; 
	public void init(FilterConfig fConfig) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/book","root","root");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			String s1 = request.getParameter("uname");
			String s2 = request.getParameter("pword");
			PreparedStatement pstmt = con.prepareStatement("select * from uinfo where uname=? and pword=?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			System.out.println(s1 +""+s2);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				chain.doFilter(request, response);
			}
			else {
				PrintWriter pw = response.getWriter();
			    pw.println("Invalid UN/PW");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
