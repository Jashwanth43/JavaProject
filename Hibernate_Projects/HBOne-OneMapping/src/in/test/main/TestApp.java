package in.test.main;

import java.util.Set;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.test.model.Department;
import in.test.model.Employee;
import in.test.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Department department = null;
		Employee employee = null;
		boolean flag = false;
		Set<Employee> set=new HashSet<Employee>();
		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction();
			if (transaction != null) {
				Employee employee1 = new Employee();
				employee1.setEaddress("1811 EdgeWood DR");
				employee1.setEname("Jashwanth");
				employee1.setEsal(130000);
				set.add(employee1);
				Employee employee2 = new Employee();
				employee2.setEaddress("Tenali,Inida");
				employee2.setEname("Anantha Phani");
				employee2.setEsal(13000);
				set.add(employee2);
				Employee employee3 = new Employee();
				employee3.setEaddress("Miami,Florida");
				employee3.setEname("Florida");
				employee3.setEsal(58000);
				set.add(employee3);
				department=new Department();
				department.setEmployees(set);
				department.setDeptId("SBI52201");
				department.setDeptName("Tenali Brach");
				session.save(department);
				flag = true;

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println(department);
				System.out.println("SUCCESS");
			} else {
				transaction.rollback();
				System.out.println("There is an error in saving please try again...");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
