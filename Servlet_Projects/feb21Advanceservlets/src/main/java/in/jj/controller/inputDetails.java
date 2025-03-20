package in.jj.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/tester"}, loadOnStartup=1)
public class inputDetails extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
static {
	System.out.println("starting to get");
	
}
public void init(ServletConfig config) {
	System.out.println("Sevlet inti");
}
public void service() {
	System.out.println("testing sevice");
}
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	System.out.println("getting invoked");
	ServletConfig config=getServletConfig();
	System.out.println("config is"+config);
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>this is the get page</title>");
	out.println("/head>");
	out.println("<body>");
	out.println("user name: "+username);
	out.println("user name: "+password);
	out.println("<br>");
	out.println("Request Object is id: "+request.hashCode());
	out.println("<br>");
	out.println("Response Object is id: "+response.hashCode());
	out.println("<br>");
	out.println("Thread Object is id: "+Thread.currentThread().hashCode());
	out.println("</body>");
	out.println("</html>");
	out.close();
}
}
