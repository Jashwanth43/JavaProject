package in.jdbcmvc.factory;

import in.jdbcmvc.dao.HibernateStudentImpl;

public class StudentHibernateDaoFactory  {
	static {
		System.out.println("StudentHibernateDaoFactory called");
	}
	private StudentHibernateDaoFactory(){
		
	}
static HibernateStudentImpl hibernateStudent=null;
		public static HibernateStudentImpl getHibernateStudent() {
			if(hibernateStudent==null) {
				hibernateStudent=new HibernateStudentImpl();
			}
			return hibernateStudent;
		}
}
