package com.java1234.c03AOP.service.impl;


import com.java1234.c03AOP.service.StudentService;

public class StudentServiceImpl implements StudentService {


    @Override
    public String addStudent(String name) {
        // System.out.println("不使用切面，手动做日志，添加学生名字："+name);
        int i = 9 / 0;
        System.out.println("===============添加学生：" + name + "===============");
        return "学生";
    }
}
