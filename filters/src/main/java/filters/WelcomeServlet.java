package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("uname");
		PrintWriter pw = response.getWriter();
		pw.println("Welcome "+ s1);
	}
	
	// XML File
//	 <servlet>
//	  	<servlet-name>WelcomeServlet</servlet-name>
//	  	<servlet-class>filters.WelcomeServlet</servlet-class>
//	  </servlet>
//	  <servlet-mapping>
//	  	<servlet-name>WelcomeServlet</servlet-name>
//	  	<url-pattern>/welcome</url-pattern>
//	  </servlet-mapping>
//	  <filter>
//	  	<filter-name>LoginFilter</filter-name>
//	  	<filter-class>filters.LoginFilter</filter-class>
//	  </filter>
//	  <filter-mapping>
//	  	<filter-name>LoginFilter</filter-name>
//	  	<url-pattern>/welcome</url-pattern>
//	  </filter-mapping>
}
