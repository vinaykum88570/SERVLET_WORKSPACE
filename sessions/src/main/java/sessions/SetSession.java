package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");	
		
		
		
		// HTTP Session with cookies
		HttpSession hs = request.getSession();
		hs.setAttribute("book1", s1);
		hs.setAttribute("book2", s2);
		hs.setAttribute("book3", s3);
		
//		PrintWriter pw = response.getWriter();
//		pw.print("<html><body bgcolor=wheat text=blue><center>");
//		pw.print("<h1><u>Your Books Are Added To Cart</u></h1>");
//		pw.print("<a href=get> Next</a>");
//		pw.print("</center></body></html>");
		
		// HTTP Session with urlRewriting
		PrintWriter pw = response.getWriter();
		pw.print("<html><body bgcolor=wheat text=blue><center>");
		pw.print("<h1><u>Your Books Are Added To Cart</u></h1>");
		String s = response.encodeUrl("get");
		pw.print("<a href="+s+"> Next</a>");
		pw.print("</center></body></html>");
	}

}
