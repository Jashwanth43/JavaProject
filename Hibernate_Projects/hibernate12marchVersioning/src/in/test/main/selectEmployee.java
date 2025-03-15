package in.test.main;
import hibernate5march.*;
import java.util.*;
import java.io.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class selectEmployee {
	public static void main(String... args) throws IOException {

		Session session=null;
		session=HibernateUtil.getSession();
//		List<Employee> employees=new ArrayList<>();
		try {
		if(session!=null) {
		//Query<Employee> query=session.createQuery("From hibernate5march.Employee where empName=?");
//		Query<Employee> query=session.createQuery("From hibernate5march.Employee where empName=:first");
//		Query query=session.createQuery("SELECT empName,empSal From hibernate5march.Employee where empName=:first");

//		query.setParameter("first", "jashwanth");
//		employees=query.list();
		Query query=session.createQuery("SELECT empName,empSal From hibernate5march.Employee");

		List<Object[]> list=query.getResultList();
//		employees.forEach(Object->System.out.println(Employee));
		list.forEach(row->{
			for(Object obj:row) {
				System.out.println(obj+"\t");
			}
			System.out.println();
		});
		}
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session); 
		}
	}
}
	

