package in.ServletFilter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
/**
 * Servlet Filter implementation class filerServlets
 */
@WebFilter("/test")
public class filerServlets extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     * 
     */
	private FilterConfig config;
    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext context=config.getServletContext();
		PrintWriter out=response.getWriter();
		HttpServletRequest req=(HttpServletRequest) request ;
		out.println("<h1>This is added by  first filter before request</h1>");
		System.out.println(config);
		context.log("A request coming from "+req.getRemoteHost()+"for URL"+req.getRequestURL()+" at date: "+new Date());
		chain.doFilter(request, response);
		out.println("<h1>This is the filer after sending request to servlet</h1>");
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
		
	}

}
