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
public class AuthorizationFilter implements Filter {
//	@Override
	public void init() {
		System.out.println("Filter Initialised");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hsr = (HttpServletRequest)req;
		
		HttpSession hp = hsr.getSession(false);
		
		if (hp != null) {
			chain.doFilter(req, res);
		} else {
			((HttpServletResponse)res).sendRedirect("HTML/login.html");
		}
	}
	
	public void destroy()
	{
		System.out.println("Filter destroyed....");
	}


}
