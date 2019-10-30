package com.java1234.C04DAO.c01JDBC.service;

import com.java1234.C04DAO.c01JDBC.model.Student;

import java.util.List;

public interface StudentService {

    public int addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int id);

    public List<Student> findStudents();
}
