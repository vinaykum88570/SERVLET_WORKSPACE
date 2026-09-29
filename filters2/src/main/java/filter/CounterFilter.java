package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/homepage.html")
public class CounterFilter extends HttpFilter {
    int count=0;
    
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		count++;
		ServletContext sc = request.getServletContext();
		sc.setAttribute("views", count);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}


}
