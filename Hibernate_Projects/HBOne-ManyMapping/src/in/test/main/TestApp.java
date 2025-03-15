package in.test.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.test.model.Account;
import in.test.model.Employee;
import in.test.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Account account = null;
		Employee employee = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction();
			if (transaction != null) {
				account = new Account();
				account.setAccNo(873857);
				account.setAccName("Jashwanth Jampala");
				account.setAccType("checking");
				employee = new Employee();
				employee.setAccount(account);
				employee.setEaddress("1811 EdgeWood DR");
				employee.setEname("Jashwanth");
				employee.setEsal(130000);
				 session.save(employee);
				flag = true;

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("SUCCESS");
			} else {
				transaction.rollback();
				System.out.println("There is an error in saving please try again...");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
