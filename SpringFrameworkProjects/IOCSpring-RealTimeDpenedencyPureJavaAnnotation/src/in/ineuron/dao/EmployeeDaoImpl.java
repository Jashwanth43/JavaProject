package in.ineuron.dao;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import in.ineuron.bo.EmployeeBO;
@Repository("dao")

public class EmployeeDaoImpl implements IEmployeeDao {
	private static final String SQL_INSERT_QUERY="insert into employee_spring(ename,eage,eaddress) values(?,?,?);";
	private static final String SQL_SELECT_QUERY = "select eid,ename,eage,eaddress from employee_spring;";
	@Autowired
	@Qualifier("hikariDataSource")
 private DataSource dataSource;
	@Override
	public String save(EmployeeBO bo) {
		int rowCount=0;
		try(Connection connection=dataSource.getConnection(); PreparedStatement pstmt=connection.prepareStatement(SQL_INSERT_QUERY)){
			pstmt.setString(1,bo.getEname());
			pstmt.setInt(2,bo.getEage());
			pstmt.setString(3,bo.getEaddress());
		    rowCount=pstmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rowCount==1?"RECORD INSERTED SUCCESFULLY": "RECORD INSERTION FAILED";
	}

	@Override
	public List<EmployeeBO> findAllEmployees() {
		ArrayList<EmployeeBO> empListBO =null;
		try(Connection connection=dataSource.getConnection();
				PreparedStatement pstmt=connection.prepareStatement(SQL_SELECT_QUERY);
				ResultSet resultSet=pstmt.executeQuery()){
		   empListBO = new ArrayList<EmployeeBO>();
			while(resultSet.next()) {
				EmployeeBO employeeBO = new EmployeeBO();
				employeeBO.setEid(resultSet.getInt(1));
				employeeBO.setEname(resultSet.getString(2));
				employeeBO.setEage(resultSet.getInt(3));
				employeeBO.setEaddress(resultSet.getString(4));
				empListBO.add(employeeBO);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empListBO;
	}

	@Override
	public EmployeeBO findById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateByiId(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteByiId(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

}
