package in.jdbccrudapp.factory;

import in.jdbccrudapp.controller.StudentControlerImpl;

public class StudentControlerFactory {
	private static StudentControlerImpl studentControler;
	public  StudentControlerFactory() {	
	}
	public static StudentControlerImpl getStudentController() {
		
		if(studentControler==null)
			studentControler=new StudentControlerImpl();
			
		return studentControler;
			
	}
	
}
