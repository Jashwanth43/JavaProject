package feb22AdvServlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contextdetails")
public class DemoServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
	ServletContext context=getServletContext();
	Enumeration<String> values=context.getInitParameterNames();
	context.setAttribute("jashwanth", 4443);
	context.setAttribute("anantha", 4444);
	context.setAttribute("bhanu", 4445);
	PrintWriter out=response.getWriter();
	out.println("<html><head><title>This is about servlet context</title></head>");
	out.println("<body>");
	out.println("<table border='1'>");
	out.println("<tr><th>context name</th><th>context value</th>");
	while(values.hasMoreElements()) {
		out.println("<tr>");
		String attributeName=(String)values.nextElement();
		String attributeValue=  context.getInitParameter(attributeName);
		out.println("<th>"+attributeName+"</th><th>"+attributeValue+"</th>");
		out.println("<\tr>");
	}
	Enumeration<String> attributes=context.getAttributeNames();
	while(attributes.hasMoreElements()) {
		
		out.println("<tr>");
		String attributeName=attributes.nextElement();
		Object attributeValue= context.getAttribute(attributeName);
		out.println("<th>"+attributeName+"</th><th>"+attributeValue+"</th>");
		out.println("<\tr>");
	}
	out.println("</table>");
	out.println("</body>");
	out.println("</html>");
	out.close();
	
}


}
