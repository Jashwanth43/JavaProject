package in.jdbccrudapp.factory;

import in.jdbccrudapp.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentServiceImpl studentService;
	private StudentServiceFactory() {	
	}
	public static StudentServiceImpl getStudentService() {
		
		if(studentService==null)
			studentService=new StudentServiceImpl();
			
		return studentService;
			
	}
	
}
