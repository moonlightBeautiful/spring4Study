package com.java1234.C04DAO.c01JDBC.service;

import com.java1234.C04DAO.c01JDBC.model.Teacher;

import java.util.List;

public interface TeacherService {

    public int addTeacher(Teacher student);

    public int updateTeacher(Teacher student);

    public int deleteTeacher(int id);

    public List<Teacher> findTeachers();
}
