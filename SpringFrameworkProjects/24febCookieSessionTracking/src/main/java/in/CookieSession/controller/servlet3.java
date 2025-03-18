package in.CookieSession.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class sessionTracking01
 */
@WebServlet("/test3")
public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String manuDate=request.getParameter("mandate");
		String expireDate=request.getParameter("expire");
		//create a session object and store these data in session object
		Cookie[] cookies=request.getCookies();
		String pid=cookies[0].getValue();
		String pname=cookies[1].getValue();
		String pcost=cookies[2].getValue();
		String pquantity=cookies[3].getValue();
	
		//writiting resposne 
		response.setContentType("text/Html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>user details</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>The user details are: </h1>");
		out.println("<table border='1' bgcolor='cyan'>");
		out.println("<tr><td> Product ID:</td><td> "+pid+"</td></tr>");
		out.println("<tr><td> Product Name: </td><td>"+pname+"</td></tr>");
		out.println("<tr><td>  Product Cost:</td><td> "+pcost+"</td></tr>");
		out.println("<tr><td> Product Qunatity: </td><td> "+pquantity+"</td></tr>");
		out.println("<tr><td> Manufracture Date: </td><td>"+manuDate+"</td></tr>");
		out.println("<tr><td> Expiry Date: </td><td>"+expireDate+"</td></tr>");
		out.println("</table");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
		
	}

}
