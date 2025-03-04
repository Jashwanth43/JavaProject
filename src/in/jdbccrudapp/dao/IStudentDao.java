package in.jdbccrudapp.dao;

import in.jdbccrudapp.dto.Student;

public interface IStudentDao {
	String save(Student student); //create studetn bean operation for Database
	Student findById(Integer sid); //For read student bean operation for Databse
	String updateById(Student student); //For updating the student in database
	String deleteById(Integer sid); //For deletign the student in database
}