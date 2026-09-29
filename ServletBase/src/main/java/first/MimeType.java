package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MimeType
 */
@WebServlet("/mime")
public class MimeType extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("application/msword");
		PrintWriter pw = response.getWriter();
		pw.print("Welcome......");
	}

}
