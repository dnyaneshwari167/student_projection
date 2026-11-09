package com.tka.main;

import java.util.List;

import com.tka.dao.StudentDAO;
import com.tka.daoImpl.StudentDaoImpl;
import com.tka.entity.Student;

public class StudentMain {

    public static void main(String[] args) {

        StudentDAO studentdao = new StudentDaoImpl();

        List<Student> student_list;

        /*
        student_list = studentdao.searchStudentByCourse("Java");
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentAboveFees(30000.0);
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentUnderFees(50000.0);
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentByCourseNotEqual("Python");
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentFees(20000.0);
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentByName(
                java.util.Arrays.asList("Rahul", "Priya"));
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentByNameAndFees("Rahul", 20000);
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.searchStudentNameStartWith("A");
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.getStudentListByFees(20000);
        student_list.forEach(s -> System.out.println(s));

        student_list = studentdao.getStudentList();
        student_list.forEach(s -> System.out.println(s));
        */

        System.out.println("Highest Fees Student: " + studentdao.getHighestFeesStudent());
        System.out.println("Lowest Fees Student: " + studentdao.getLowestFeesStudent());
        System.out.println("Second Highest Fees Student: " + studentdao.getSecondHighestFeesStudent());
        System.out.println("Second Lowest Fees Student: " + studentdao.getSecondLowestFeesStudent());
    }
}