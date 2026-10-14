package servlet;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ListenerDemo2 implements ServletContextAttributeListener{
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Attribute Added");
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Attribute Removed");
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Attribute Replaced");
	}
}
