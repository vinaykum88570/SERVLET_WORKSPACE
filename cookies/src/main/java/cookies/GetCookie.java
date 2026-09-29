package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/get")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		Cookie[] c= request.getCookies();
		PrintWriter pw = response.getWriter();
		pw.print("<html><body bgcolor=wheat text=blue>");
		pw.print("<h1><u>Selected Books</u></u><br>");
		for(Cookie c2 : c) {
			pw.print(c2.getValue()+"<br>"); 
		}
		
	}

}
