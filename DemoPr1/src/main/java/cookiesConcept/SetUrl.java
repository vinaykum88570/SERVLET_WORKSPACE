package cookiesConcept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/set")
public class SetUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("book1");
		String s2 = request.getParameter("book2");
		String s3 = request.getParameter("book3");
		System.out.println(s1 +" "+s2+" "+s3);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("book1", s1);
		hs.setAttribute("book2", s2);
		hs.setAttribute("book3", s3);
		
		PrintWriter pw = response.getWriter();
		
		String s = response.encodeUrl("get");
		
		pw.print("<a href="+s+">next</a>");
		
		
		
		
		
	}

}
