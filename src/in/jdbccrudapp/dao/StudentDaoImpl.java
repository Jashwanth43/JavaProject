package in.jdbccrudapp.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jdbccrudapp.dto.Student;
import in.jdbccrudapp.utils.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	private Connection connection=null;
	private String user="insert into studentname(name,email,city,country) values(?,?,?,?);";
	@Override
	public String save(Student student) {
		try {
			connection=JdbcUtil.getJdbcConnection();
			System.out.println("Implementation class object ");
			if(connection!=null) {
			PreparedStatement pstmt=connection.prepareStatement(user);
			if(pstmt!=null) {
			pstmt.setString(1, student.getName());
			pstmt.setString(2,student.getEmail());
			pstmt.setString(3, student.getCity());
			pstmt.setString(4,student.getCountry());
			int result=pstmt.executeUpdate();
			if(result==1) {
				return "success";
			}
			else {
				return "failure";
			}
			}
			}
		} catch (SQLException e ) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student findById(Integer sid) {
		 String details="select * from studentname where sid=?";
		 PreparedStatement pstmt=null;
		 Student student=null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			//System.out.println("Implementation class object ");
			 pstmt = connection.prepareStatement(details);
			pstmt.setInt(1,sid);
			ResultSet resultset=pstmt.executeQuery();
			if(resultset.next()) {
				student=new Student();
				student.setSid(resultset.getInt(1));
				student.setName(resultset.getString(2));
				student.setEmail(resultset.getString(3));
				student.setCity(resultset.getString(4));
				student.setCountry(resultset.getString(5));
				return student;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery="update studentname set name=?,email=?,city=?,country=? where sid=?;";
		PreparedStatement pstmt=null;
		String status=null;
		int result=0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlUpdateQuery);
			if(pstmt!=null)
				pstmt.setString(1, student.getName());
				pstmt.setString(2,student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4,student.getCountry());
				pstmt.setInt(5,student.getSid());
			if(pstmt!=null)
				 result=pstmt.executeUpdate();
			if(result==1) {
				return "success";
			}
			else {
				return "failure";
			}
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteById(Integer sid) {
		String query="delete from studentname where sid=?;";
		PreparedStatement pstmt=null;
		String status=null;
		try {
			Student student=findById(sid);
			if(student!=null) {
				System.out.println("id is present");
			connection=JdbcUtil.getJdbcConnection();
			System.out.println("Implementation class object ");
			if(connection!=null) {
			 pstmt=connection.prepareStatement(query);
			pstmt.setInt(1,sid);
			int result=pstmt.executeUpdate();
			if(result==1) {
				 status="success";
				 return status;
			}
			else {
				status= "failure";
				return status;
			}
			}
			
			}else {
				status="not available";
				return status;
			}
		} catch (SQLException e ) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
