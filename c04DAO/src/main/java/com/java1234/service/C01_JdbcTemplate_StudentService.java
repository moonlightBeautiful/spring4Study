package com.java1234.service;

import com.java1234.model.Student;

import java.util.List;

public interface C01_JdbcTemplate_StudentService {

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int id);

    List<Student> findStudents();
}
