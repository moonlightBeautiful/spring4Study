package com.ims.c01JdbcTemplate.dao;


import com.ims.c01JdbcTemplate.model.Student;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface StudentDao {
    public int addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int id);

    public List<Student> findStudents();
}
