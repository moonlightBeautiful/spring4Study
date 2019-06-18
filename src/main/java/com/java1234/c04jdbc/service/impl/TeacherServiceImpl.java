package com.java1234.c04jdbc.service.impl;


import com.java1234.c04jdbc.dao.TeacherDao;
import com.java1234.c04jdbc.model.Teacher;
import com.java1234.c04jdbc.service.TeacherService;

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
