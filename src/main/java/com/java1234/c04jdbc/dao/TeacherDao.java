package com.java1234.c04jdbc.dao;

import com.java1234.c04jdbc.model.Teacher;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface TeacherDao {
    public int addTeacher(Teacher student);

    public int updateTeacher(Teacher student);

    public int deleteTeacher(int id);

    public List<Teacher> findTeachers();
}
