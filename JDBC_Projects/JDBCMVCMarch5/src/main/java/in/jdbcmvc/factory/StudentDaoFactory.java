package in.jdbcmvc.factory;

import in.jdbcmvc.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDaoImpl studentDao;
	public static  StudentDaoImpl getStudentDao() {
		if(studentDao==null)
			studentDao=new StudentDaoImpl();
		return studentDao;
		
	}
}
