package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionCountListener implements ServletContextListener, HttpSessionListener {
	ServletContext ctx;

    public SessionCountListener() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent se)  {
    	 System.out.println("Session Created!");
         Integer count = (Integer) ctx.getAttribute("session_count");
         ctx.setAttribute("session_count", count + 1);
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	System.out.println("Session Destroyed!");
    	Integer count = (Integer) ctx.getAttribute("session_count");
        ctx.setAttribute("session_count", count - 1);
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("Context Destroyed");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Context Initialized");
         ctx = sce.getServletContext();
         ctx.setAttribute("session_count", 0);
    }
	
}
