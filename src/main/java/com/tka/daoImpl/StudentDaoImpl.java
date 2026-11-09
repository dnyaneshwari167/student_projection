package com.tka.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.dao.StudentDAO;
import com.tka.entity.Student;

public class StudentDaoImpl implements StudentDAO {

    private Session getSession() {
        return new Configuration().configure()
                .buildSessionFactory().openSession();
    }

    public void insertStudent(Student student) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        System.out.println("Student Data Saved...");
    }

    public List<Student> searchStudentByCourse(String course) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.eq("course", course)).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentAboveFees(Double fees) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.gt("fees", fees)).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentUnderFees(Double fees) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.le("fees", fees)).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentByCourseNotEqual(String course) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.ne("course", course)).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentFees(Double fees) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.ge("fees", fees)).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentByName(List<String> names) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.in("name", names)).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentByFeesNotInRange(double min, double max) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.not(Restrictions.between("fees", min, max))).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentByFeesNotInRangeList(List<Double> fees) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.not(Restrictions.in("fees", fees))).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentByNameAndFees(String name, double fees) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.and(
                        Restrictions.eq("name", name),
                        Restrictions.ge("fees", fees))).list();
        session.close();
        return list;
    }

    public List<Student> searchStudentNameStartWith(String name) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.like("name", name + "%")).list();
        session.close();
        return list;
    }

    public List<Student> getStudentListByFees(double fees) {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .add(Restrictions.ge("fees", fees))
                .addOrder(Order.asc("fees")).list();
        session.close();
        return list;
    }

    public List<Student> getStudentList() {
        Session session = getSession();
        List<Student> list = session.createCriteria(Student.class)
                .addOrder(Order.desc("fees"))
                .setFirstResult(0).setMaxResults(5).list();
        session.close();
        return list;
    }

    public Student getHighestFeesStudent() {
        Session session = getSession();
        Student student = (Student) session.createCriteria(Student.class)
                .addOrder(Order.desc("fees"))
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();
        session.close();
        return student;
    }

    public Student getLowestFeesStudent() {
        Session session = getSession();
        Student student = (Student) session.createCriteria(Student.class)
                .addOrder(Order.asc("fees"))
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();
        session.close();
        return student;
    }

    public Student getSecondHighestFeesStudent() {
        Session session = getSession();

        Double maxFees = (Double) session.createCriteria(Student.class)
                .setProjection(Projections.max("fees")).uniqueResult();

        Student student = null;

        if (maxFees != null) {
            student = (Student) session.createCriteria(Student.class)
                    .add(Restrictions.lt("fees", maxFees))
                    .addOrder(Order.desc("fees"))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return student;
    }

    public Student getSecondLowestFeesStudent() {
        Session session = getSession();

        Double minFees = (Double) session.createCriteria(Student.class)
                .setProjection(Projections.min("fees")).uniqueResult();

        Student student = null;

        if (minFees != null) {
            student = (Student) session.createCriteria(Student.class)
                    .add(Restrictions.gt("fees", minFees))
                    .addOrder(Order.asc("fees"))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return student;
    }
}