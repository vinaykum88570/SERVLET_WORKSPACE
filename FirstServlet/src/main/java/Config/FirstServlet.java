package Config;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


public class FirstServlet extends GenericServlet {

	
	public void service(ServletRequest req, ServletResponse res) {
		try {
			System.out.println("service methods");
	     	PrintWriter pw = res.getWriter();
			pw.print("Hello Servlet");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
