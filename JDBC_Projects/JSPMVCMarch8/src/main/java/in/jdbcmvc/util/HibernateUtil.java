package in.jdbcmvc.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static Configuration configuration=null;
    static SessionFactory sessionfactory=null;
	static Session session=null;
	static {
	try{
		configuration =new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionfactory=configuration.buildSessionFactory();
		
		
	}catch(HibernateException e){
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static Session getSession() {
		if(session==null)
			session=sessionfactory.openSession();
		return session;
	}
	public static void closeSession(Session session) {
		session.close();
	}
	public static void CloseSessionFactory(SessionFactory sessionfactory) {
		sessionfactory.close();
	}
}
