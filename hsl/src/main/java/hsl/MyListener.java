package hsl;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener {
	int count = 0;
	

    public void sessionCreated(HttpSessionEvent hse)  { 
        count++;
        HttpSession hs = hse.getSession();
        hs.setAttribute("users", count);
    }

    public void sessionDestroyed(HttpSessionEvent hse)  { 
       count--;
       HttpSession hs = hse.getSession(); 
       hs.setAttribute("users", count);
    }
	
}
