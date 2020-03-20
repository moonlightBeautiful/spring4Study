package com.ims.c01JdbcTemplate.service;


import com.ims.c01JdbcTemplate.model.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int id);

    List<Student> findStudents();
}
