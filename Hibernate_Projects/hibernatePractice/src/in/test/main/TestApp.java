package in.test.main;
import java.io.Serializable;
import hibernate5march.Employee;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
public class TestApp {
	public static void main(String... args) {
//		Configuration cfg=null;
//		Session session=null;
//		SessionFactory sessionFactory=null;
//		Transaction transaction=null;
//		======check in HibernateUitl.java class=================
//		 cfg=new Configuration();
//		cfg.configure();
//		  sessionFactory=cfg.buildSessionFactory();
//		 session=sessionFactory.openSession();
//		 System.out.println(sessionFactory.getProperties());
		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
			int id;
			Employee e=null;
		
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
//			e=new Employee();
//			e.setEmpid(1);
//			e.setEmpName("jjash");
//			e.setEmpSal(500.25);
//			   session.persist(e);
			e=session.get(Employee.class,1);
			System.out.println(e);
			e.setEmpSal((double) 9999);
			System.out.println(e);
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
