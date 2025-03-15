package in.test.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.test.model.Account;
import in.test.model.Employee;
import in.test.util.HibernateUtil;

public class TestApp2 {

	public static void main(String[] args) {
		Session session = null;
		Employee employee = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null)
			
				
				employee =session.load(Employee.class,1);
				System.out.println(employee);
				

			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSession(session);
		}
	}

}
