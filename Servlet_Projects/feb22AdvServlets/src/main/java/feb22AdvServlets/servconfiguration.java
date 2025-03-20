package feb22AdvServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/config")
public class servconfiguration extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//request methods
		response.setContentType("text/Html");
		System.out.println(request.getRemoteHost());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRemotePort());
		System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
		Enumeration<String>headerValues=request.getHeaderNames();
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>output</title></head>");
		out.println("<body>");
		out.println("<h1 align='center'>Request header information</h1>");
		out.println("<table align='center' border='1'> ");
		out.println("<tr><th>Header Name</th><th>Header Value</th><tr>");
		while(headerValues.hasMoreElements()) {
			out.println("<tr>");
		String headerName=(String)headerValues.nextElement();
		String headerValue=request.getHeader(headerName);
		out.println("<td>"+headerName+"</td><td>"+headerValue+"</td>");
		out.println("</tr>");	
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
