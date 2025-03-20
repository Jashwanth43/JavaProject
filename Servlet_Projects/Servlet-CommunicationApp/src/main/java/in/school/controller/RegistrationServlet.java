package in.school.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	public void init() {
		ServletContext context=getServletContext();
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		Integer age=Integer.parseInt(request.getParameter("uage"));
		String email=request.getParameter("uemail");
		String mobile=request.getParameter("umobile");
		int result=0;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(age<19 || age>30) {
			response.sendError(504,"User Age is not sufficient for this Recruitment");
		}	
		else {
			String query="insert into registration(Name,Age,Email,mobile) values(?,?,?,?)";
			try {
				PreparedStatement pstmt=connection.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				pstmt.setString(3,email);
				pstmt.setString(4,mobile);
			    result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result==1) {
			out.println("<html><head><title>Output</title></head>");
			out.println("<body>");
			out.println("<font color='red'>");
			out.println("<h2>iNeuron Consutlancy services</h2>");
			out.println("<h2>User registration services</h2>");
			out.println("</font>");
			out.println("<table border='1'>");
			out.println("<tr><td>User Name</td><td>"+name+"</td></tr>");
			out.println("<tr><td>Age</td><td>"+age+"</td></tr>");
			out.println("<tr><td>Email</td><td>"+email+"</td></tr>");
			out.println("<tr><td>Mobile</td><td>"+mobile+"</td></tr>");
			out.println("<tr><td>Registration status</td><td>REGISTERED SUCCESSFULLY</td></tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			}
			
				}
		
	}

}
