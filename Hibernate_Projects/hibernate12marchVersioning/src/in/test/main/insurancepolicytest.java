package in.test.main;
import hibernate5march.*;
import in.test.util.HibernateUtil;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class insurancepolicytest {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
		 insurancePolicy policy=null;
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
			policy=new insurancePolicy();
			policy.setPolicyName("PARENT INSURANCE");
			policy.setCompany("TCS");
			policy.setTenure(1);
			Serializable id = session.save(policy);
			result=true; 
			System.out.println(id);
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
