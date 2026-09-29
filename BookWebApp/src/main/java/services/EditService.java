package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editurl")
public class EditService extends HttpServlet {
	 private static final String query = "update BOOKDATA set BOOKNAME=?,BOOKEDITION=?,BOOKPRICE=? where id=?";
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        //get PrintWriter
	        PrintWriter pw = res.getWriter();
	        //set content type
	        res.setContentType("text/html");
	        //get the id of record
	        int id = Integer.parseInt(req.getParameter("id"));
	        //get the edit data we want to edit
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
	        try (Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/book","root","root" ); 
	        		PreparedStatement pstmt = con.prepareStatement(query);) {
	        	pstmt.setString(1, bookName);
	        	pstmt.setString(2, bookEdition);
	        	pstmt.setFloat(3, bookPrice);
	        	pstmt.setInt(4, id);
	            int count = pstmt.executeUpdate();
	            pw.println("<a href='home.html'>Home</a>");
		        pw.println("<br>");
		        pw.println("<a href='bookList'><-:Back</a>");
	            if (count == 1) {
	                pw.println("<center><h2>Record is Edited Successfully</h2></center>");
	            } else {
	                pw.println("<center><h2>Record is not Edited Successfully</h2></center>");
	            }
	        } catch (SQLException se) {
	            se.printStackTrace();
	            pw.println("<h1>" + se.getMessage() + "</h2>");
	        } catch (Exception e) {
	            e.printStackTrace();
	            pw.println("<h1>" + e.getMessage() + "</h2>");
	        }
	       
	        pw.println("<a href='bookList'>Book List</a>");

	    }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        doGet(req, res);
	    }
	
}
