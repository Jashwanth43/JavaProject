package in.jdbccrudapp.factory;

import in.jdbccrudapp.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDaoImpl studentDao;
	public static  StudentDaoImpl getStudentDao() {
		if(studentDao==null)
			studentDao=new StudentDaoImpl();
		return studentDao;
		
	}
}
