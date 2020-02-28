package com.java1234.service;

import com.java1234.model.Teacher;

import java.util.List;

public interface C02_JdbcDaoSupport_TeacherService {

    public int addTeacher(Teacher student);

    public int updateTeacher(Teacher student);

    public int deleteTeacher(int id);

    public List<Teacher> findTeachers();
}
