package in.jdbcmvc.dao;

import in.jdbccrudapp.dto.Student;

public interface HibernateStudent {
	public 	String save(Student student); //create studetn bean operation for Database
	public	Student findById(Integer sid);
	public String updateById(Student student);
	
}
