package in.jdbcmvc.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jdbccrudapp.dto.Student;
import in.jdbcmvc.util.HibernateUtil;
public class HibernateStudentImpl implements HibernateStudent {
	static {
		System.out.println("getting called");
	}
	@Override
	public String save(Student student) {
		 Session session=null;
		 Transaction transaction=null;
		 boolean result=false;
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			System.out.println(student);
			session.save(student);
			 result=true;
			if(result) {
				return "success";
			}
			else {
				return "failure";
			}
			}
		 catch(HibernateException e) {
			
			e.printStackTrace();
		}finally {
			if(transaction!=null) {
			if(result)
				transaction.commit();
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		}
		return "Something wrong";
	}
	@Override
	public Student findById(Integer sid) {
		System.out.println("It's getting called");
		Session session=null;
		Student student=null;
		try {
			session =HibernateUtil.getSession();
			student=session.get(Student.class,sid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return student;
	}
	public String updateById(Student student) {
		Session session=null;
		Transaction transaction=null;
		boolean result=false;
		try {
			session =HibernateUtil.getSession();
			 transaction = session.beginTransaction();
			 session.saveOrUpdate(student);
			 result=true;
			 if(result) {
				 return "SUCCESS";
			 }else {
				 return "Failed";
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(transaction!=null) {
				if(result)
					transaction.commit();
				else
					transaction.rollback();
				HibernateUtil.closeSession(session);
			}
		}
		return null;
	
	}
	
}
