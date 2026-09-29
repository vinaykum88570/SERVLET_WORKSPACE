package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	
@WebServlet("/set")
public class SetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String s1 = request.getParameter("book1") ;
		String s2 = request.getParameter("book2") ;
		String s3 = request.getParameter("book3") ;
		System.out.println(s1+" "+s2+" "+s3);
		if (s1!= null) {
			Cookie c1 = new Cookie("book1", s1); // new Cookie(name,value);
			response.addCookie(c1);
			
		}
		if(s2!=null) {
			Cookie c2 = new Cookie("book2", s2);
			response.addCookie(c2);
		}
		if(s3!=null) {
			Cookie c3 = new Cookie("book3", s3);
			response.addCookie(c3);
		}
		PrintWriter pw = response.getWriter();
		pw.println("<html><body bgcolor=cyan text=red><center ");
		pw.print("<h6><b> Your Books Are Added To Cart <b><h6>");
		pw.print("<a href=get> Next </a> ");
		pw.print("</center></body></html> ");
	}

}
