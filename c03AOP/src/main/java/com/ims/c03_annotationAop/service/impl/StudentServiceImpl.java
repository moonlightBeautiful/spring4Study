package com.ims.c03_annotationAop.service.impl;


import com.ims.c03_annotationAop.service.StudentService;

public class StudentServiceImpl implements StudentService {


    @Override
    public String addStudent(String name) {
        System.out.println("===============添加学生：" + name + "===============");
        return "学生";
    }
}
