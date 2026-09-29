package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterService extends HttpServlet {
	  private static final String query = "INSERT INTO BOOKDATA(BOOKNAME,BOOKEDITION,BOOKPRICE) VALUES(?,?,?)";
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        //get PrintWriter
	        PrintWriter pw = res.getWriter();
	        //set content type
	        res.setContentType("text/html");
	        //GET THE book info
	        String bookName = req.getParameter("bookName");
	        String bookEdition = req.getParameter("bookEdition");
	        float bookPrice = Float.parseFloat(req.getParameter("bookPrice"));
	        //LOAD jdbc driver
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException cnf) {
	            cnf.printStackTrace();
	        }
	        //generate the connection
	        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
	        		PreparedStatement pstmt = con.prepareStatement(query);) {
	            pstmt.setString(1, bookName);
	            pstmt.setString(2, bookEdition);
	            pstmt.setFloat(3, bookPrice);
	            int count = pstmt.executeUpdate();
	            pw.println("<a href='home.html'>Home</a><br>");
	            if (count == 1) {
	                pw.println("<center><h2>Record Is Registered Sucessfully</h2></center>");
	            } else {
	                pw.println("<center><h2>Record not Registered Sucessfully</center>");
	            }
	        } catch (SQLException se) {
	            se.printStackTrace();
	            pw.println("<h1>" + se.getMessage() + "</h2>");
	        } catch (Exception e) {
	            e.printStackTrace();
	            pw.println("<h1>" + e.getMessage() + "</h2>");
	        }
	        pw.println("<center><a href='home.html'>Home</a></center>");
	        pw.println("<br>");
	        pw.println("<center><a href='bookList'>Book List</a></center>");
	    }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 
					doGet(req, res);
				
	    }
}
