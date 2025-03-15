package in.test.main;
import hibernate5march.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class loadObject {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
		 MobileCustomer customer=null;
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
			customer=session.load(MobileCustomer.class, 1);
			//customer.setCallerTune("SAALAR");
			System.out.println(customer);
			result=true; 
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
