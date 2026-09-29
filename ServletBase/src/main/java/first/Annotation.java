package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Annotation
 */
@WebServlet("/Annotation")
public class Annotation extends GenericServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		pw.print("Welcome to Annotation ");
	}

}
