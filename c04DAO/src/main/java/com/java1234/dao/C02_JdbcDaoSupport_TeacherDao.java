package com.java1234.dao;

import com.java1234.model.Teacher;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface C02_JdbcDaoSupport_TeacherDao {
    public int addTeacher(Teacher student);

    public int updateTeacher(Teacher student);

    public int deleteTeacher(int id);

    public List<Teacher> findTeachers();
}
