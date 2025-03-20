package in.school.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class redirectTesting
 */
@WebServlet("/test1")
public class redirectTesting extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public redirectTesting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1 style='color:red;tex-align:center;'>This is first servlet</h1>");
		RequestDispatcher rd=request.getRequestDispatcher("/test2");
		rd.forward(request, response);
//		String link="http://localhost:8086/hello.html";
//		response.sendRedirect(link);
		out.close();
	}

}
