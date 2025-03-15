package in.test.main;
import hibernate5march.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class TestApp {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
		 MobileCustomer customer=new MobileCustomer();
			customer.setCname("parvathi");
			customer.setMobileNo(82472896);
			customer.setCallerTune("RRR");
			Integer id=null;
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
			id=(Integer) session.save(customer);
			System.out.println("The generated id value is: "+id);
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
