package in.test.main;
import in.test.util.*;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import hibernate5march.insurancePolicy;

public class bulkInsertOperation {
public static void main(String... args) {
	Session session=null;
    Transaction	transaction =null;
    int count=0;
    boolean flag=false;
    final String HQL_TRANSFER_QUERY = "INSERT INTO premiumInsurancePolicy(policyId, company, policyName, tenure) SELECT ip.policyId, ip.company, ip.policyName, ip.tenure FROM insurancePolicy ip WHERE ip.tenure >:first";
    try {
		session=HibernateUtil.getSession();
		transaction=session.beginTransaction();
		Query query=session.createQuery(HQL_TRANSFER_QUERY);
		query.setParameter("first",10);
		count=query.executeUpdate();
		flag=true;
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (flag) {
			transaction.commit();
			System.out.println("no of records transfered is :: " + count);
		} else {
			transaction.rollback();
			System.out.println(" record not copied/inserted");
		}
		HibernateUtil.getSession();
	}
}
}
