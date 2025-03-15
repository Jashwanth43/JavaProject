package in.jdbccrudapp.service;

import in.jdbccrudapp.dao.IStudentDao;
import in.jdbccrudapp.model.Student;
import in.jdbccrudapp.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao;
	@Override
	public String save(Student student) {
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		
		return studentDao.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

}
