package com.ims.c02JdbcDaoSupport.dao;


import com.ims.c02JdbcDaoSupport.model.Teacher;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-06-18 11:28
 * @description ... 类
 */
public interface TeacherDao {
    int addTeacher(Teacher student);

    int updateTeacher(Teacher student);

    int deleteTeacher(int id);

    List<Teacher> findTeachers();
}
