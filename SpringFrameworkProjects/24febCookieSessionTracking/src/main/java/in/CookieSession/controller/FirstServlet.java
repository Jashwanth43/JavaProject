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
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		String pname=request.getParameter("pname");
		//create a cookie as per the requrement
		 Cookie c1=new Cookie("pid",pid);
		 Cookie c2=new Cookie("pname",pname);
		 //send the cookie object through response
		 response.addCookie(c1);
		 response.addCookie(c2);
		 //forward response to form2.html
		 request.getRequestDispatcher("form3.html").forward(request, response);
		
	}

}
