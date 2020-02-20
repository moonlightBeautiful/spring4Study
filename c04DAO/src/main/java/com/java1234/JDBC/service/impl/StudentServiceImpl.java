package com.java1234.JDBC.service.impl;


import com.java1234.JDBC.dao.StudentDao;
import com.java1234.JDBC.model.Student;
import com.java1234.JDBC.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
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
