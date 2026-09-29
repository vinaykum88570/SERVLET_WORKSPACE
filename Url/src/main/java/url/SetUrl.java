package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sset")
public class SetUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		
		PrintWriter pw = response.getWriter();
		pw.print("<html> <body bgcolor=green text=yellow> <center>");
		pw.print("<h1>Your Books Are Added To Cart</h1> </br>");
		pw.print("<a href=get?book1="+s1+"&book2="+s2+"&book3="+s3+"> Next </a>");
		pw.print("</center></body></html>");
	}

}
