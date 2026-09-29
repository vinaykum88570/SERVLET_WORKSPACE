package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		String s1 = (String)hs.getAttribute("book1");
		String s2 = (String)hs.getAttribute("book2");
		String s3 = (String)hs.getAttribute("book3");
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body bgcolor=cyan text=blue><center>");
		pw.print("<h1><u>Seletced Books</u></h1>");
		if(s1!=null) {
			pw.print(s1+"<br>");
		}
		if(s2!=null) {
			pw.print(s2+"<br>");
		}
		if(s3!=null) {
			pw.print(s3+"<br>");
		}
		pw.print("</center></body></html>");
	}

}
