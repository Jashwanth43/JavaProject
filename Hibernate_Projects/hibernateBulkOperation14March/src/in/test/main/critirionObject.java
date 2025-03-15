package in.test.main;
import hibernate5march.*;
import in.test.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;
public class critirionObject {
	public static void main(String... args) {

		Session session=null;
		session=HibernateUtil.getSession();

		try {
		if(session!=null) {
//			CriteriaBuilder builder=session.getCriteriaBuilder();
//			CriteriaQuery<Object[]> cQuery = builder.createQuery(Object[].class);
//			Root<insurancePolicy> root = cQuery.from(insurancePolicy.class);
//			cQuery.multiselect(root.get("company"),
//							   root.get("policyName"),
//							   root.get("policyId")
//					);
//			Predicate p1 = builder.equal(root.get("policyId"),5);
//			cQuery.where(p1);
//			Query<Object[]> query = session.createQuery(cQuery);
//			List<Object []> list=query.getResultList();
//			System.out.println(list);
//			list.forEach(row-> {
//				 for(Object o:row) {
//					 System.out.print(o);
//				 }
//				 System.out.println();
//			});
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<insurancePolicy> cQuery = builder.createQuery(insurancePolicy.class);
			Root<insurancePolicy> root = cQuery.from(insurancePolicy.class);
			cQuery.select(root);
			ParameterExpression<Long> param1=builder.parameter(Long.class);		
			ParameterExpression<Long> param2=builder.parameter(Long.class);
			Predicate p1=builder.ge(root.get("policyId"), param1);
			Predicate p2=builder.le(root.get("policyId"),param2);
			Predicate p3=builder.and(p1,p2);
			cQuery.where(p3);
			// Preparing a query having criteria query object
			Query<insurancePolicy> query = session.createQuery(cQuery);

			//setting up the parameters for projId
			query.setParameter(param1, 10L);
			query.setParameter(param2, 20L);
			
			
			// Executing the JPA QBC logic
			List<insurancePolicy> list = query.getResultList();

			// processing the result
			list.forEach(li->System.out.println(li));
			
		
			
						
		}
			
		
		}catch(HibernateException e1) {
			e1.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session); 
		}
		
	}
}
