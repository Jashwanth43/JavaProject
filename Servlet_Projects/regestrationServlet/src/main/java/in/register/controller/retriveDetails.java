package in.register.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

/**
 * Servlet implementation class retriveDetails
 */
@WebServlet(name = "ProfileDetails", urlPatterns = { "/details" })
public class retriveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null;
	public void init() {
		ServletContext context=getServletContext();
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			MysqlConnectionPoolDataSource ds=new MysqlConnectionPoolDataSource();
			ds.setUrl(url);
			ds.setUser(user);
			ds.setPassword(password);
			connection =ds.getConnection();
			
		}catch(Exception e){
		e.printStackTrace();	
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
