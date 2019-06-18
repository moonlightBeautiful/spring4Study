package com.java1234.c04jdbc.service;

import com.java1234.c04jdbc.model.Teacher;

import java.util.List;

public interface TeacherService {

    public int addTeacher(Teacher student);

    public int updateTeacher(Teacher student);

    public int deleteTeacher(int id);

    public List<Teacher> findTeachers();
}
