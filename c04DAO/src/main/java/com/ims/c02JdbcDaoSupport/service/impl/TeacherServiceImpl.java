package com.ims.c02JdbcDaoSupport.service.impl;


import com.ims.c02JdbcDaoSupport.dao.TeacherDao;
import com.ims.c02JdbcDaoSupport.model.Teacher;
import com.ims.c02JdbcDaoSupport.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
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
