package scl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlets
 */
@WebServlet("/test")
public class MyServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MyServlets() {
        super();
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Connection con = (Connection)sc.getAttribute("mysql");
		PrintWriter pw = response.getWriter();
		pw.println("Connection oject Obtained Successfully.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
