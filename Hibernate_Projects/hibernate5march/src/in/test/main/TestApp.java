package in.test.main;
import java.io.Serializable;
import java.util.List;

import hibernate5march.Employee;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;
public class TestApp {
	private static final String QUERY="FROM hibernate5march.Employee";
	public static void main(String... args) {
	Session session=null;
	session=HibernateUtil.getSession();
	if(session.isOpen()) {
		Query<Employee>query=session.createQuery(QUERY);
		List<Employee> list=query.list();
		list.forEach(System.out::println);
		
		
	}
	session.close();
	}
}
