package in.test.dispathcherTypes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dispatchterServlet1
 */
@WebServlet("/test1")
public class dispatchterServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dispatchterServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out=response.getWriter();
//		out.println("<h1>this is first servlet</h1>");
		ServletContext context=getServletContext();
		ServletContext fc=context.getContext("/tempDispatcher3");
		RequestDispatcher rd=fc.getRequestDispatcher("/test2");
		rd.forward(request,response);
	}

}
