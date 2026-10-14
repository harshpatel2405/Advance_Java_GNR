package servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ListenerDemo1 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		// TODO Auto-generated method stub
//		ServletContextListener.super.contextInitialized(sce);
		System.out.println("Application Started");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
//		// TODO Auto-generated method stub
//		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("Application Ended");
	}
	
}
