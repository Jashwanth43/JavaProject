package in.jdbcmvc.Service;

import in.jdbcmvc.dao.HibernateStudent;
import in.jdbcmvc.dao.IStudentDao;
import in.jdbccrudapp.dto.Student;
import in.jdbcmvc.factory.StudentDaoFactory;
import in.jdbcmvc.factory.StudentHibernateDaoFactory;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao;
	@Override
	public String save(Student student) {
//		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		HibernateStudent hibernateStudent=StudentHibernateDaoFactory.getHibernateStudent();
		return hibernateStudent.save(student);
	}

	@Override
	public Student findById(Integer sid) {
//		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
	HibernateStudent hibernateStudent=StudentHibernateDaoFactory.getHibernateStudent();
		return hibernateStudent.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		//IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		HibernateStudent hibernateStudent=StudentHibernateDaoFactory.getHibernateStudent();

		return hibernateStudent.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(sid);
	}

}
