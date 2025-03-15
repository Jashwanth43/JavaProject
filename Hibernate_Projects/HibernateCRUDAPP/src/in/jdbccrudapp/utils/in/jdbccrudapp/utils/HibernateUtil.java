package in.jdbccrudapp.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static Configuration cfg=null;
	static Session session=null;
	static SessionFactory sessionFactory=null;
	static {
		try {
			 cfg=new Configuration();
			 cfg.configure();
			 sessionFactory=cfg.buildSessionFactory();
			System.out.println(sessionFactory.getProperties());
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Session getSession() {
		if(session==null) {
			session=sessionFactory.openSession();
		}
		return session;
		
	}
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
	}
	public static void closeSessionFactory(SessionFactory sessionFactory) {
		if(sessionFactory!=null)
			sessionFactory.close();
	}
	public static void startUp() {
	System.out.println("****Hibernate got started****");
	}
}
