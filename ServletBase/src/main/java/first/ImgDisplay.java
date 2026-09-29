package first;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ImgDisplay
 */
@WebServlet("/ImgDisplay")
public class ImgDisplay extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String img="C:/Users/admin/OneDrive/Pictures/Avengers Hulk .jpg";
		
		ServletOutputStream sos = response.getOutputStream();
		FileInputStream fis = new FileInputStream(img);
		int n=fis.available();
		byte[] b = new byte[n];
		fis.read(b);
		sos.write(b);
		
	}

}
