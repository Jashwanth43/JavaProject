package in.CookieSession.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcost=request.getParameter("pcost");
		String pquantity=request.getParameter("pquantity");
		//create a cookie as per the requrement
		 Cookie c3=new Cookie("pcost",pcost);
		 Cookie c4=new Cookie("pquantity",pquantity);
		 //send the cookie object through response
		 response.addCookie(c3);
		 response.addCookie(c4);
		 //forward response to form2.html
		 request.getRequestDispatcher("form2.html").forward(request, response);
		
	}

}
