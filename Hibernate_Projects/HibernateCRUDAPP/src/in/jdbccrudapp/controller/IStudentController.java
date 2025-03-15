package in.jdbccrudapp.controller;

import in.jdbccrudapp.model.Student;


public interface IStudentController {
	String save(Student student); //create studetn bean operation for Database
	Student findById(Integer sid); //For read student bean operation for Databse
	String updateById(Student student); //For updating the student in database
	String deleteById(Integer sid); //For deletign the student in database
}
