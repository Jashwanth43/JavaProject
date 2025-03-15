package in.test.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.test.model.branch;
import in.test.model.student;
import in.test.util.HibernateUtil;

public class testApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		branch br = null;
		
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.getTransaction();
			if (transaction != null) {
				br=new branch();
				br.setBranchId("CPS");
				br.setBranchName("COMPUTER SCIENCE");
				br.setBranchAddr("CMU");
				student student1=new student("jashwanth","mount pleasant",br);
				student student2=new student("anantha","Tenali",br);
				student student3=new student("bhanu","mangalagiri",br);
				session.save(student1);
				session.save(student2);
				session.save(student3);
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
