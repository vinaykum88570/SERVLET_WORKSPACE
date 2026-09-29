package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class CountView
 */
@WebServlet("/CountView")
public class CountView extends GenericServlet {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int count=0;
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			count++;
			PrintWriter pw = response.getWriter();
			pw.print("<html><body bgcolor=yellow text=red><h1>");
			pw.print("This page has been accessed "+count+" times");
			pw.print("</h1></body></html>");
	}

}
