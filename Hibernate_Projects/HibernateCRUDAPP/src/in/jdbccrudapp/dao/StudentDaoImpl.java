package in.jdbccrudapp.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jdbccrudapp.model.Student;
import in.jdbccrudapp.utils.HibernateUtil;


public class StudentDaoImpl implements IStudentDao {
	Session session = HibernateUtil.getSession();

	@Override
	public String save(Student student) throws HibernateException {
		boolean flag = false;
		String status = null;
		try {
			Transaction transaction = session.beginTransaction();
			session.save(student);
			flag = true;

			if (flag) {
				transaction.commit();
				status = "SUCCESS";
			} else {
				transaction.rollback();
				status = "FAILURE";
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;
	}


	@Override
	public Student findById(Integer sid) {
		Student student=null;
	try {
		student=session.get(Student.class, sid);
	} catch (Exception e) {
		e.printStackTrace();
	}
		return student;
	}

	@Override
	public String updateById(Student student) {
		boolean flag = false;
		String status = null;
		try {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			flag = true;

			if (flag) {
				transaction.commit();
				status = "SUCCESS";
			} else {
				transaction.rollback();
				status = "FAILURE";
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return status;
	}


	@Override
	public String deleteById(Integer sid) {
		Transaction transaction =session.beginTransaction();
		Student student=findById(sid);
		String status=null;
		if(student!=null) {
			session.delete(student);
			boolean flag=true;
			if (flag) {
				transaction.commit();
				status = "SUCCESS";
			} else {
				transaction.rollback();
				status = "FAILURE";
			}
			
		}
		return status;
		}

}
