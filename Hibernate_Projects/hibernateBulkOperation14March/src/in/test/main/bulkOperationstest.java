package in.test.main;
import in.test.util.*;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import hibernate5march.insurancePolicy;

public class bulkOperationstest {
public static void main(String... args) {
	Session session=null;
    Transaction	transaction =null;
    try {
		session=HibernateUtil.getSession();
		Query<insurancePolicy> query=session.getNamedQuery("selectquery");
		query.setParameter("companyName", "LIC");
	List<insurancePolicy> list=query.getResultList();
		list.forEach(li->System.out.println(li+li.getClass().getName()));
//		Query query=session.createQuery("SELECT policyName,tenure FROM insurancePolicy WHERE company=:companyName");
//		query.setParameter("companyName", "LIC");
//		List<Object[]> list=query.getResultList();
//	
//		list.forEach(row->{
//			for(Object o:row) {
//				System.out.print(o+"\t");
//			System.out.println();
//
//			}
//		});
//		
//		Query query=session.createQuery("SELECT policyName FROM insurancePolicy WHERE PolicyId=:companyName");
//		query.setParameter("companyName", 5);
//		Optional<String> optional=query.uniqueResultOptional();
//		if(optional.isPresent()) {
//			String  name=optional.get();
//			System.out.println(name);
//		}else {
//			System.out.println("There is no records present");
//		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		HibernateUtil.getSession();
	}
}
}
