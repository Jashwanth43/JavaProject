package in.ijashwanth.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet implements Servlet {
	static {
		System.out.println("servlet is loading....");
	}
	
    public DemoServlet() {
        System.out.println("Servlet instantiation");
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("incctializing Servlet through init() method");
	}

	public void destroy() {
		System.out.println("Serlet is destorying....");
	}
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>My first app</title></head>");
		out.println("<body>");
		out.println("<h1>Hello Jashwanth welcome day-1 in servlet practice</h1>");
		out.println("<h2>Keep going you can do it...</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	

	
 
	
	

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}


	





}
