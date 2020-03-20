package com.ims.c02JdbcDaoSupport.service;


import com.ims.c02JdbcDaoSupport.model.Teacher;

import java.util.List;

public interface TeacherService {

    int addTeacher(Teacher student);

    int updateTeacher(Teacher student);

    int deleteTeacher(int id);

    List<Teacher> findTeachers();
}
