package com.java1234.service.impl;


import com.java1234.dao.C01_JdbcTemplate_StudentDao;
import com.java1234.model.Student;
import com.java1234.service.C01_JdbcTemplate_StudentService;

import java.util.List;

public class C01_JdbcTemplate_StudentServiceImpl implements C01_JdbcTemplate_StudentService {

    private C01_JdbcTemplate_StudentDao studentDao;

    public void setStudentDao(C01_JdbcTemplate_StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.findStudents();
    }


}
