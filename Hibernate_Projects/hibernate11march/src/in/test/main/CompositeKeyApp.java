package in.test.main;
import java.io.Serializable;
import hibernate5march.*;
import in.test.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
public class CompositeKeyApp {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();
		Transaction transaction=null;
		 boolean result=false;
			int id;
		
		try {
		if(session!=null) 
			transaction=session.beginTransaction();
		if(transaction!=null) {
		ProjectInfo info=new ProjectInfo(101,903);
		ProgrammerProjectInfo projectDetials=new ProgrammerProjectInfo(info,"kohli",10,"jee");
		ProjectInfo id1=(ProjectInfo) session.save(projectDetials);	
		result=true; 
		System.out.println(id1);
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
