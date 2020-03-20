package com.ims.c02_xmlAop.service.impl;


import com.ims.c02_xmlAop.service.StudentService;

public class StudentServiceImpl implements StudentService {


    @Override
    public String addStudent(String name) {
        System.out.println("===============添加学生：" + name + "===============");
        /*int i = 9 / 0;*/
        return "学生";
    }
}
