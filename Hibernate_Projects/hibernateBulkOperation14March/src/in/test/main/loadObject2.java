package in.test.main;
import hibernate5march.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class loadObject2 {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
		 BankAccount account=null;
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
			account=session.load(BankAccount.class, 1L,LockMode.UPGRADE_NOWAIT);
			System.out.println(account);
			account.setBalance((double)100);
			
			
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
