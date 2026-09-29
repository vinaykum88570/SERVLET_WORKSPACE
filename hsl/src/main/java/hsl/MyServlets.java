package hsl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/test")
public class MyServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MyServlets() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		hs.setMaxInactiveInterval(60);
		int x = (Integer)hs.getAttribute("users");
		PrintWriter pw = response.getWriter();
		pw.println("x Users Accesing : "+ x);
		
	}

}
