package in.test.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.test.model.Course;
import in.test.model.Student;
import in.test.util.HibernateUtil;
import java.util.Set;
import java.util.HashSet;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction();
			if (transaction != null) {
				Course c1=new Course("c-111","Java",1000);
				Course c2=new Course("c-222","JEE",1000);
				Course c3=new Course("c-333","Frameworks",2000);
				Set<Course>set1=new HashSet<Course>();
				set1.add(c1);
				set1.add(c2);
				set1.add(c3);
				Set<Course>set11=new HashSet<Course>();
				
				set11.add(c2);
				set11.add(c3);
				Set<Course>set111=new HashSet<Course>();
				set111.add(c1);
				
				set111.add(c3);
				Student s1=new Student("jashwanth","USA",set1);
				Student s2=new Student("Ananth","India",set11);
				Student s3=new Student("bhanu","India",set111);
				session.save(s1);
				session.save(s2);
				session.save(s3);
				
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
