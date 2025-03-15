package in.test.main;
import hibernate5march.*;
import java.util.*;



import java.io.*;
import in.test.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
public class updateEmployeeIndustryStands2 {
	public static void main(String... args) throws IOException {

		Session session=null;
		session=HibernateUtil.getSession();
		int count=0;
		boolean flag=false;
		Transaction transaction=null;
		try {
		if(session!=null) {
			transaction=session.beginTransaction();
		if(transaction!=null) {
		Query query=session.createQuery("UPDATE hibernate5march.Employee SET empSal=empSal+:increment where eid<=:first");
		query.setParameter("increment",50000.0);
		query.setParameter("first", 999999);
		count=query.executeUpdate();
		flag=true;
		}
		}
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Got updated no of rows: "+count);
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session); 
		}
	}
}
	

