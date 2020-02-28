package com.java1234.dao;

import com.java1234.model.Student;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface C01_JdbcTemplate_StudentDao {
    public int addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int id);

    public List<Student> findStudents();
}
