package in.test.main;
import hibernate5march.*;
import java.util.*;
import java.io.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class selectEmployeeIndustryStands {
	public static void main(String... args) throws IOException {

		Session session=null;
		session=HibernateUtil.getSession();

		try {
		if(session!=null) {
	
		Query query=session.createQuery("From hibernate5march.Employee where eid=:first");
		query.setParameter("first", 523443);
		Optional<Employee>optional=query.uniqueResultOptional();
		if(optional.isPresent()) {
			Employee employee=optional.get();
			System.out.println(employee);
		}
		}
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session); 
		}
	}
}
	

