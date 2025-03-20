package feb22AdvServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet (
	urlPatterns= {"/democonfigg"},
	initParams= {
			@WebInitParam(name="ttt",value="hello"),
			@WebInitParam(name="txx",value="hi"),
	}
)
public class demoConfig extends HttpServlet{
		public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
			
			ServletConfig context=getServletConfig();
			Enumeration<String> values=context.getInitParameterNames();
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
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			
		}
}
