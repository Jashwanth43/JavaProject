package in.jdbcmvc.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.jdbccrudapp.dto.Student;
import in.jdbcmvc.util.HibernateUtil;
public class HibernateStudentImpl implements HibernateStudent {

    @Override
    public String save(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
        	session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            System.out.println(student);
            session.save(student);
            transaction.commit(); // Commit transaction
            return "success";
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback transaction if an exception occurs
            }
            e.printStackTrace();
            return "failure";
        } finally {
//            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public Student findById(Integer sid) {
        Session session = null;
        Student student = null;
        try {
            session = HibernateUtil.getSession();
            student = session.get(Student.class, sid);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
        }
        return student;
    }

    public String updateById(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            return "SUCCESS";
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "Failed";
        } finally {
//            HibernateUtil.closeSession(session);
        }
    }
}
