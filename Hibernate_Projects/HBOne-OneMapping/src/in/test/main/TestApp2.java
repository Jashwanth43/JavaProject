package in.test.main;

import java.util.Set;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.test.model.Department;
import in.test.model.Employee;
import in.test.util.HibernateUtil;

public class TestApp2 {

	public static void main(String[] args) {
		Session session = null;
		Department department = null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
			if (session != null)
				department=session.get(Department.class, "SBI52201");
				department.setDeptId("SBIDUGGI523");
				department.setDeptName("SBICHNDUGGI");
				System.out.println(department);
				flag=true;
			}

		catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}
	}

}
