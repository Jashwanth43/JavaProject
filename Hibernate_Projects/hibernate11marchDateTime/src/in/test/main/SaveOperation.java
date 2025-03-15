package in.test.main;

import hibernate5march.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.test.util.HibernateUtil;

public class SaveOperation {

	public static void main(String[] args) {
		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
			PersonInfo person=new PersonInfo();
			person.setPname("sachin");
			person.setPaddress("Mumbai");
			person.setDob(LocalDate.of(1973, 04, 24));
			person.setDom(LocalDateTime.of(1987,6,21,12,35));
			person.setDoj(LocalTime.of(10,45));
			session.save(person);
			result=true;
			System.out.println(person);
			
		}
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			if(result) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session); 
		}
	}
	}
