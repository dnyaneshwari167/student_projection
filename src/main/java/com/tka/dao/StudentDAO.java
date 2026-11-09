package com.tka.dao;

import java.util.List;
import com.tka.entity.Student;

public interface StudentDAO {

    public void insertStudent(Student student);

    public List<Student> searchStudentByCourse(String course);

    public List<Student> searchStudentAboveFees(Double fees);

    public List<Student> searchStudentUnderFees(Double fees);

    public List<Student> searchStudentByCourseNotEqual(String course);

    public List<Student> searchStudentFees(Double fees);

    public List<Student> searchStudentByName(List<String> names);

    public List<Student> searchStudentByFeesNotInRange(double min, double max);

    public List<Student> searchStudentByFeesNotInRangeList(List<Double> fees);

    public List<Student> searchStudentByNameAndFees(String name, double fees);

    public List<Student> searchStudentNameStartWith(String name);

    public List<Student> getStudentListByFees(double fees);

    public List<Student> getStudentList();

    public Student getHighestFeesStudent();

    public Student getLowestFeesStudent();

    public Student getSecondHighestFeesStudent();

    public Student getSecondLowestFeesStudent();
}