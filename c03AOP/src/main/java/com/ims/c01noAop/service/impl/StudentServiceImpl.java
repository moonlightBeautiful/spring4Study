package com.ims.c01noAop.service.impl;


import com.ims.c01noAop.service.StudentService;

public class StudentServiceImpl implements StudentService {


    @Override
    public String addStudent(String name) {
        System.out.println("不使用AOP，手动做日志，开始添加学生名字：" + name);
        System.out.println("===============添加学生：" + name + "===============");
        System.out.println("不使用AOP，手动做日志，完成添加学生名字：" + name);
        return "学生";
    }
}
