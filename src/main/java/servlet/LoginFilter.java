package servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/user-dashboard")
public class LoginFilter implements Filter {

	public void init()
	{
		System.out.println("Login Filter Initialised");
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hsrq = (HttpServletRequest) arg0;
		HttpServletResponse hsrr = (HttpServletResponse) arg1;
		
		System.out.println("Login Filter");
		
		HttpSession hs = hsrq.getSession(false);
		if(hs != null)
		{
				chain.doFilter(arg0, arg1);
			}else
			{
				hsrr.sendRedirect("HTML/filters.html");
			}
		
		
		
	}
	public void destroy()
	{
		System.out.println("Destroy Method Called");
	}
	
}
