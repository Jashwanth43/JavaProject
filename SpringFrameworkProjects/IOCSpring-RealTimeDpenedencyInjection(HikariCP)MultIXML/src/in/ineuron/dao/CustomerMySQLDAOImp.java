package in.ineuron.dao;


import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


import in.ineuron.bo.CustomerBO;

public class CustomerMySQLDAOImp implements ICustomerDAO {
	private DataSource dataSource;
	private static String CUSTOMER_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER(CNAME,CAADD,PAMT,INTRAMT) VALUES(?,?,?,?);";
	static {
		System.out.println("CustomerMySQLDAOImp.class file is loading...");
	}
	public CustomerMySQLDAOImp(DataSource dataSource) {
	System.out.println("CustomerMySQLDAOImp:: one param constructor");
		this.dataSource = dataSource;
	}
	@Override
	public int insert(CustomerBO bo) {
		int result=0;
	try(Connection connection =dataSource.getConnection()) {
		System.out.println("Connection Established successfully...");
		PreparedStatement pstmt = connection.prepareStatement(CUSTOMER_INSERT_QUERY);
		pstmt.setString(1,bo.getCustomerName());
		pstmt.setString(2, bo.getCustomerAddress());
		pstmt.setFloat(3,bo.getPamt());
		pstmt.setFloat(4, bo.getInterestAmt());
		 result=pstmt.executeUpdate();
		return result;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return result;
	}
}
