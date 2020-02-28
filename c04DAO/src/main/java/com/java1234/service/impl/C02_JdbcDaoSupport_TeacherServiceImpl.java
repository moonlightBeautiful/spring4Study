package com.java1234.service.impl;


import com.java1234.dao.C02_JdbcDaoSupport_TeacherDao;
import com.java1234.model.Teacher;
import com.java1234.service.C02_JdbcDaoSupport_TeacherService;

import java.util.List;

public class C02_JdbcDaoSupport_TeacherServiceImpl implements C02_JdbcDaoSupport_TeacherService {

    private C02_JdbcDaoSupport_TeacherDao teacherDao;

    public void setTeacherDao(C02_JdbcDaoSupport_TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public int addTeacher(Teacher teacher) {

        return teacherDao.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {

        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int id) {

        return teacherDao.deleteTeacher(id);
    }

    @Override
    public List<Teacher> findTeachers() {

        return teacherDao.findTeachers();
    }


}
