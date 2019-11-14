package com.java1234.service.impl;


import com.java1234.service.StudentService;

public class StudentServiceImpl implements StudentService {


    @Override
    public String addStudent(String name) {
        //System.out.println("不使用切面，手动做日志，开始添加学生名字："+name);
        // int i = 9 / 0;
        System.out.println("===============添加学生：" + name + "===============");
        //System.out.println("不使用切面，手动做日志，完成添加学生名字："+name);
        return "学生";
    }
}
