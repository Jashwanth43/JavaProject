package in.jdbcmvc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jdbccrudapp.dto.Student;
import in.jdbcmvc.util.*;
public class StudentDaoImpl implements IStudentDao {
	private Connection connection=null;
	private String user="insert into student(sage,sname,saddress) values(?,?,?);";
	@Override
	public String save(Student student) {
		try {
			connection=JdbcUtil.getJdbcConnection();
			System.out.println("Implementation class object ");
			if(connection!=null) {
			PreparedStatement pstmt=connection.prepareStatement(user);
			if(pstmt!=null) {
			pstmt.setInt(1, student.getage());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSaddress());

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
		 String details="select * from student where sid=?";
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
				student.setSid(resultset.getInt(4));
				student.setName(resultset.getString(2));
				student.setage(resultset.getInt(1));
				student.setSaddress(resultset.getString(3));
				return student;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery="update student set  sname=?,sage=?,saddress=? where sid=?;";
		PreparedStatement pstmt=null;

		int result=0;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
				pstmt=connection.prepareStatement(sqlUpdateQuery);
			if(pstmt!=null)
				pstmt.setInt(4, student.getSid());
				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getage());
				pstmt.setString(3, student.getSaddress());

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
		String query="delete from student where sid=?;";
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
