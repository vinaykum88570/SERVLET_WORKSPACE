package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUrl
 */
@WebServlet("/get")
public class GetUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");	
	
		PrintWriter pw = response.getWriter();
		pw.print("<html> <body bgcolor=purple text=white> <center>");
		pw.print("<h1><u>Your Books Are Added To Cart</u></h1>");
		if(!s1.equals("null")) {
			pw.print(s1+"</br>");
			
		}
		if(!s2.equals("null")) {
			pw.print(s2+"</br>");
		}
		if(!s3.equals("null")) {
			pw.print(s3+"</br>");
		}
		pw.print("</html></center></body>");
	}

}
