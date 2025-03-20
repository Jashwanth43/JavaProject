package in.register.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerUser")
public class registerUserServlets extends HttpServlet {
	static {
		System.out.println("started to register user");
	}
public void init() {
	System.out.println("Started initalization");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	ServletContext context=getServletContext();
	String url=context.getInitParameter("url");
	String username=context.getInitParameter("username");
	String password=context.getInitParameter("password");
	System.out.println(url+" "+username+" "+password);
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,username,password);
		if(connection!=null) {
			String query="insert into userdetails(Name,Email,city,country) values(?,?,?,?);";
			PreparedStatement prepstatmet=connection.prepareStatement(query);
			prepstatmet.setString(1, request.getParameter("name"));
			prepstatmet.setString(2, request.getParameter("email"));
			prepstatmet.setString(3, request.getParameter("city"));
			prepstatmet.setString(4, request.getParameter("country"));
			int result=prepstatmet.executeUpdate();
			if(result==1) {
				PrintWriter out=response.getWriter();
				out.println("<html><head><title>OUTPUT</title></head>");
				out.println("<body>");
				out.println("<h1>success</h1>");
				out.println("</body>");
				out.println("</html>");
				
			}
			prepstatmet.close();
			connection.close();
			
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
