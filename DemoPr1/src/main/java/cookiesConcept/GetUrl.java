package cookiesConcept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/get")
public class GetUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		HttpSession hs = request.getSession(false);
		String s1 = (String) hs.getAttribute("book1");
		String s2 = (String) hs.getAttribute("book2");
		String s3 = (String) hs.getAttribute("book3");
		
		if(s1!=null) {
			pw.print(s1);
		}
		
		if(s2!=null) {
			pw.print(s2);
		}
		
		if(s3!=null) {
			pw.print(s3);
		}
		System.out.println(s1 +" "+s2+" "+s3);
	}
	

}
