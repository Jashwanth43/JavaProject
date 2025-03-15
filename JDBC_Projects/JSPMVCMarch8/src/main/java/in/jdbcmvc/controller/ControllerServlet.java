package in.jdbcmvc.controller;
import in.jdbccrudapp.dto.*;
import java.io.IOException;
import java.io.PrintWriter;

import in.jdbcmvc.Service.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.jdbcmvc.factory.StudentServiceFactory;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService stdse=StudentServiceFactory.getStudentService();
		String requestURI=request.getRequestURI();
		System.out.println(requestURI);
		RequestDispatcher rd=null;
		if(requestURI.endsWith("layout")) {
			rd=request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		}
		if(requestURI.endsWith("addform")) {
			String name=request.getParameter("sname");
			int age=Integer.parseInt(request.getParameter("sage"));
			String addr=request.getParameter("saddress");
			Student student=new Student();
			student.setage(age);
			student.setName(name);
			student.setSaddress(addr);
			String status=stdse.save(student);
			if(status!=null) {
				 if(status.equalsIgnoreCase("success")) {
					 System.out.println("success");
					 ServletContext context = getServletContext();
					    context.setAttribute("insert", "success");
					    rd = request.getRequestDispatcher("../result.jsp");
					    rd.forward(request, response);
				 }
				 else if (status.equalsIgnoreCase("failure")) {
					 System.out.println("failure");
					 ServletContext context= getServletContext();
					 context.setAttribute("insert","failure");
					 rd=request.getRequestDispatcher("../result.jsp");
					 rd.forward(request, response);
				 }
				 else {
					 System.out.println("Something wrong");
				 }
				  }
			
			
			
		}
		if(requestURI.endsWith("searchform")) {
			System.out.println("called");
			int id=Integer.parseInt(request.getParameter("sid"));
			Student student=stdse.findById(id);
			System.out.println(student);
			if(student!=null) {
//				response.setContentType("text/html");
//				PrintWriter out = response.getWriter();
//				out.println("<html><head><title>STUDENT DATA</title></head>");
//				out.println("<body bgcolor='lightblue'>");
//				out.println("<br/><br/><br/>");
//				out.println("<table align='center' border='1'>");
//				out.println("<tr>");
//				out.println("<th>SID</th>");
//				out.println("<th>SNAME</th>");
//				out.println("<th>SAGE</th>");
//				out.println("<th>SADDRESS</th>");
//				out.println("</tr>");
//				out.println("<tr>");
//				out.println("<td>" + student.getSid() + "</td>");
//				out.println("<td>" + student.getName() + "</td>");
//				out.println("<td>" + student.getage() + "</td>");
//				out.println("<td>" + student.getSaddress() + "</td>");
//				out.println("</tr>");
//				out.println("</table>");
//				out.println("</body>");
//				out.println("</html>");
//
//				out.close();
				//ServletContext context=getServletContext();
				 request.setAttribute("student", student);
				  rd=request.getRequestDispatcher("../stuentDisp.jsp");
				 rd.forward(request, response);
				
			}else {
				request.setAttribute("student", student);
				rd=request.getRequestDispatcher("../stuentDisp.jsp");
				rd.forward(request, response);
			}
		}
		if(requestURI.endsWith("deleteform")) {
			int id=Integer.parseInt(request.getParameter("sid"));
			String status=stdse.deleteById(id);
			if(status!=null) {
				 if(status.equalsIgnoreCase("success")) {
					 System.out.println("success");
					 ServletContext context=getServletContext();
					 context.setAttribute("delete", "success");
					 rd=request.getRequestDispatcher("../deleteresult.jsp");
					 rd.forward(request, response);
				 }
				 else if (status.equalsIgnoreCase("failure")) {
					 System.out.println("failure");
					 ServletContext context= getServletContext();
						context.setAttribute("insert","failure");
					 rd=request.getRequestDispatcher("../deleteresult.jsp");
					 rd.forward(request, response);
				 }
				 else {
					 rd = request.getRequestDispatcher("../notfound.html");
						rd.forward(request, response);
				 }
				  }
	}
		if (requestURI.endsWith("updateform")) {
			String sid = request.getParameter("sid");
			Student student = stdse.findById(Integer.parseInt(sid));
			if (student != null) {
				System.out.println(student);
				request.setAttribute("values", student);
				 rd=request.getRequestDispatcher("../updateStudent.jsp");
				 rd.forward(request, response);
//				response.setContentType("text/html");
//
//				// display editpage using html
//				PrintWriter out = response.getWriter();
//				out.println("<html><head><title>OUTPUT</title></head>");
//				out.println("<body bgcolor='lightblue'>");
//				out.println("<br/><br/><br/>");
//				out.println("<form method='post' action='./update'>");
//				out.println("<table align='center'>");
//				out.println("<tr><th>ID</th><td>" + student.getSid() + "</td></tr>");
//				out.println("<input type='hidden' name='sid' value='" + student.getSid() + "'/>");
//				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + student.getName()
//						+ "'/></td></tr>");
//				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + student.getage()
//						+ "'/></td></tr>");
//				out.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + student.getSaddress()
//						+ "'/></td></tr>");
//				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
//				out.println("</table>");
//				out.println("</form>");
//				out.println("</body>");
//				out.println("</html>");
//				out.close();

			} else {
				rd = request.getRequestDispatcher("../notfound.html");
				rd.forward(request, response);
			}
		}

		if (requestURI.endsWith("update")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setName(sname);
			student.setage(Integer.parseInt(sage));
			student.setSaddress(saddr);
			
			String status = stdse.updateById(student);
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../result.jsp");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				rd = request.getRequestDispatcher("../result.jsp");
				rd.forward(request, response);
			} 
		}
		
	}
}
